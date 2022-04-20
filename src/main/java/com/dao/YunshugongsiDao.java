package com.dao;

import com.entity.YunshugongsiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YunshugongsiVO;
import com.entity.view.YunshugongsiView;


/**
 * 运输公司
 * 
 * @author 
 * @email 
 * @date 2022-04-13 17:53:27
 */
public interface YunshugongsiDao extends BaseMapper<YunshugongsiEntity> {
	
	List<YunshugongsiVO> selectListVO(@Param("ew") Wrapper<YunshugongsiEntity> wrapper);
	
	YunshugongsiVO selectVO(@Param("ew") Wrapper<YunshugongsiEntity> wrapper);
	
	List<YunshugongsiView> selectListView(@Param("ew") Wrapper<YunshugongsiEntity> wrapper);

	List<YunshugongsiView> selectListView(Pagination page,@Param("ew") Wrapper<YunshugongsiEntity> wrapper);
	
	YunshugongsiView selectView(@Param("ew") Wrapper<YunshugongsiEntity> wrapper);
	

}
