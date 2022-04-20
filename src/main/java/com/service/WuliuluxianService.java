package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WuliuluxianEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WuliuluxianVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WuliuluxianView;


/**
 * 物流路线
 *
 * @author 
 * @email 
 * @date 2022-04-13 17:53:27
 */
public interface WuliuluxianService extends IService<WuliuluxianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WuliuluxianVO> selectListVO(Wrapper<WuliuluxianEntity> wrapper);
   	
   	WuliuluxianVO selectVO(@Param("ew") Wrapper<WuliuluxianEntity> wrapper);
   	
   	List<WuliuluxianView> selectListView(Wrapper<WuliuluxianEntity> wrapper);
   	
   	WuliuluxianView selectView(@Param("ew") Wrapper<WuliuluxianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WuliuluxianEntity> wrapper);
   	

}

