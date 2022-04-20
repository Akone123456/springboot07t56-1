package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.WuliuluxianDao;
import com.entity.WuliuluxianEntity;
import com.service.WuliuluxianService;
import com.entity.vo.WuliuluxianVO;
import com.entity.view.WuliuluxianView;

@Service("wuliuluxianService")
public class WuliuluxianServiceImpl extends ServiceImpl<WuliuluxianDao, WuliuluxianEntity> implements WuliuluxianService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WuliuluxianEntity> page = this.selectPage(
                new Query<WuliuluxianEntity>(params).getPage(),
                new EntityWrapper<WuliuluxianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WuliuluxianEntity> wrapper) {
		  Page<WuliuluxianView> page =new Query<WuliuluxianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WuliuluxianVO> selectListVO(Wrapper<WuliuluxianEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WuliuluxianVO selectVO(Wrapper<WuliuluxianEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WuliuluxianView> selectListView(Wrapper<WuliuluxianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WuliuluxianView selectView(Wrapper<WuliuluxianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
