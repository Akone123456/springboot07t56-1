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


import com.dao.YunshugongsiDao;
import com.entity.YunshugongsiEntity;
import com.service.YunshugongsiService;
import com.entity.vo.YunshugongsiVO;
import com.entity.view.YunshugongsiView;

@Service("yunshugongsiService")
public class YunshugongsiServiceImpl extends ServiceImpl<YunshugongsiDao, YunshugongsiEntity> implements YunshugongsiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YunshugongsiEntity> page = this.selectPage(
                new Query<YunshugongsiEntity>(params).getPage(),
                new EntityWrapper<YunshugongsiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YunshugongsiEntity> wrapper) {
		  Page<YunshugongsiView> page =new Query<YunshugongsiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YunshugongsiVO> selectListVO(Wrapper<YunshugongsiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YunshugongsiVO selectVO(Wrapper<YunshugongsiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YunshugongsiView> selectListView(Wrapper<YunshugongsiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YunshugongsiView selectView(Wrapper<YunshugongsiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
