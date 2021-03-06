package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.entity.FaceDataEntity;
import com.entity.TokenEntity;
import com.service.FaceDateService;
import com.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.YonghuEntity;
import com.entity.view.YonghuView;

import com.service.YonghuService;
import com.service.TokenService;

import java.io.IOException;

/**
 * 用户
 * 后端接口
 *
 * @author
 * @email
 * @date 2022-04-13 17:53:27
 */
@RestController
@RequestMapping("/yonghu")
public class YonghuController {
    @Autowired
    private YonghuService yonghuService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private FaceDateService faceDateService;

    /**
     * 登录
     */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        YonghuEntity user = yonghuService.selectOne(new EntityWrapper<YonghuEntity>().eq("zhanghao", username));
        if (user == null || !user.getMima().equals(password)) {
            return R.error("账号或密码不正确");
        }

        String token = tokenService.generateToken(user.getId(), username, "yonghu", "用户");
        return R.ok().put("token", token);
    }

    /**
     * 注册
     */
    @IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody YonghuEntity yonghu) {
        //ValidatorUtils.validateEntity(yonghu);
        YonghuEntity user = yonghuService.selectOne(new EntityWrapper<YonghuEntity>().eq("zhanghao", yonghu.getZhanghao()));
        if (user != null) {
            return R.error("注册用户已存在");
        }
        Long uId = new Date().getTime();
        yonghu.setId(uId);
        yonghuService.insert(yonghu);
        return R.ok();
    }

    /**
     * 添加人脸特征值-采集人脸信息到数据库
     *
     * @param user
     * @return
     */
    @RequestMapping("/addFaceData")
    public R addFaceData(YonghuEntity user) {


        String token = null;
        if (user.getImg() != null && user.getId() != null) {//必须让前端把用户id和采集的用户base64位的图片传递过来
            byte[] bytes = ImageUtils.base64ToByte(user.getImg());//base64位图转成byte[]
            TokenEntity tokenEntity = tokenService.selectById(user.getId());
            token = tokenEntity.getToken();
            YonghuEntity yonghu = yonghuService.selectById(user.getId());
            FaceData faceData = null;
            try {
                faceData = FaceUtils.getFaceData(bytes);
            } catch (Exception e) {
                e.printStackTrace();
                return R.error(0, "未检测到人脸-请正对摄像头重新识别-也可能你的浏览器没唤起摄像头");

            }

            //判断是否检测到人脸

            if (faceData == null || faceData.getValidateFace() != 0) {
                return R.error(0, "人脸检测失败-请正对摄像头");


            } else if (faceData.getValidatePoint() != 0) {
                return R.error(0, "获取人脸特征值失败-请重新采集");

            } else {
                // TODO
                yonghu.setFaceData(faceData.getFaceData());
                yonghuService.update(yonghu, null);
                return R.error(1, "您的人脸采集成功");

            }

        } else {
            return R.error(0, "摄像头未开启或者是未登陆等违规操作");

        }
    }

    /**
     * 人脸识别比对登录
     *
     * @param user
     * @return
     */
    @IgnoreAuth
    @RequestMapping("/faceMatch")
    public R searchUser(YonghuEntity user) {
        MessUtil resBody = new MessUtil();
        resBody.setStatus(0);
        resBody.setMsg("");
        // UserInfo one = userInfoService.getOne(new QueryWrapper<>(user));
        if (user.getImg() != null) {
            byte[] bytes = ImageUtils.base64ToByte(user.getImg());
            FaceData faceData = null;
            try {
                faceData = FaceUtils.getFaceData(bytes);
            } catch (Exception e) {
                e.printStackTrace();
                return R.error(0, "未检测到人脸-请正对摄像头重新识别-也可能你的浏览器没唤起摄像头");
            }


            //判断是否检测到人脸

            if (faceData == null || faceData.getValidateFace() != 0) {
                return R.error(0, "人脸检测失败-请正对摄像头");
            } else if (faceData.getValidatePoint() != 0) {
                return R.error(0, "获取人脸特征值失败-请重新采集");
            } else {//开始比对
                //先查出所有的启用的用户

                YonghuEntity o = new YonghuEntity<>();

                List<YonghuEntity> list = yonghuService.selectList(null);
                for (YonghuEntity uu : list) {
                    if (uu.getFaceData() != null) {
                        CompareFace compare = FaceUtils.compare(faceData.getFaceData(), uu.getFaceData());

                        if (compare.getScoreCode() != 0) {
                            return R.error(0, "识别失败，请重新识别");
                        }

                        if (compare.getScore() >= 0.8) {
                            String token = tokenService.generateToken(user.getId(), uu.getZhanghao(), "yonghu", "用户");
                            return R.error(1, "识别成功。欢迎" + uu.getXingming() + "进入系统")
                                    .put("token", token);
                        }

                    }
                }
            }
        }
        return R.error(0, "系统不存在您的人脸或者您已被禁用-请注册登录并绑定人脸");
    }


    /**
     * 退出
     */
    @RequestMapping("/logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }

    /**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request) {
        Long id = (Long) request.getSession().getAttribute("userId");
        YonghuEntity user = yonghuService.selectById(id);
        return R.ok().put("data", user);
    }

    /**
     * 密码重置
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        YonghuEntity user = yonghuService.selectOne(new EntityWrapper<YonghuEntity>().eq("zhanghao", username));
        if (user == null) {
            return R.error("账号不存在");
        }
        user.setMima("123456");
        yonghuService.updateById(user);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, YonghuEntity yonghu,
                  HttpServletRequest request) {
        EntityWrapper<YonghuEntity> ew = new EntityWrapper<YonghuEntity>();
        PageUtils page = yonghuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yonghu), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, YonghuEntity yonghu,
                  HttpServletRequest request) {
        EntityWrapper<YonghuEntity> ew = new EntityWrapper<YonghuEntity>();
        PageUtils page = yonghuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yonghu), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list(YonghuEntity yonghu) {
        EntityWrapper<YonghuEntity> ew = new EntityWrapper<YonghuEntity>();
        ew.allEq(MPUtil.allEQMapPre(yonghu, "yonghu"));
        return R.ok().put("data", yonghuService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YonghuEntity yonghu) {
        EntityWrapper<YonghuEntity> ew = new EntityWrapper<YonghuEntity>();
        ew.allEq(MPUtil.allEQMapPre(yonghu, "yonghu"));
        YonghuView yonghuView = yonghuService.selectView(ew);
        return R.ok("查询用户成功").put("data", yonghuView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        YonghuEntity yonghu = yonghuService.selectById(id);
        return R.ok().put("data", yonghu);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id) {
        YonghuEntity yonghu = yonghuService.selectById(id);
        return R.ok().put("data", yonghu);
    }


    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YonghuEntity yonghu, HttpServletRequest request) {
        yonghu.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
        //ValidatorUtils.validateEntity(yonghu);
        YonghuEntity user = yonghuService.selectOne(new EntityWrapper<YonghuEntity>().eq("zhanghao", yonghu.getZhanghao()));
        if (user != null) {
            return R.error("用户已存在");
        }
        yonghu.setId(new Date().getTime());
        yonghuService.insert(yonghu);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YonghuEntity yonghu, HttpServletRequest request) {
        yonghu.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
        //ValidatorUtils.validateEntity(yonghu);
        YonghuEntity user = yonghuService.selectOne(new EntityWrapper<YonghuEntity>().eq("zhanghao", yonghu.getZhanghao()));
        if (user != null) {
            return R.error("用户已存在");
        }
        yonghu.setId(new Date().getTime());
        yonghuService.insert(yonghu);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody YonghuEntity yonghu, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(yonghu);
        yonghuService.updateById(yonghu);//全部更新
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        yonghuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 提醒接口
     */
    @RequestMapping("/remind/{columnName}/{type}")
    public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request,
                         @PathVariable("type") String type, @RequestParam Map<String, Object> map) {
        map.put("column", columnName);
        map.put("type", type);

        if (type.equals("2")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            Date remindStartDate = null;
            Date remindEndDate = null;
            if (map.get("remindstart") != null) {
                Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
                c.setTime(new Date());
                c.add(Calendar.DAY_OF_MONTH, remindStart);
                remindStartDate = c.getTime();
                map.put("remindstart", sdf.format(remindStartDate));
            }
            if (map.get("remindend") != null) {
                Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
                c.setTime(new Date());
                c.add(Calendar.DAY_OF_MONTH, remindEnd);
                remindEndDate = c.getTime();
                map.put("remindend", sdf.format(remindEndDate));
            }
        }

        Wrapper<YonghuEntity> wrapper = new EntityWrapper<YonghuEntity>();
        if (map.get("remindstart") != null) {
            wrapper.ge(columnName, map.get("remindstart"));
        }
        if (map.get("remindend") != null) {
            wrapper.le(columnName, map.get("remindend"));
        }


        int count = yonghuService.selectCount(wrapper);
        return R.ok().put("count", count);
    }


}
