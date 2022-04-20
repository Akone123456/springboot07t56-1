package com.dao;

import com.entity.WuliuluxianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WuliuluxianVO;
import com.entity.view.WuliuluxianView;


/**
 * 物流路线
 * 
 * @author 
 * @email 
 * @date 2022-04-13 17:53:27
 */
public interface WuliuluxianDao extends BaseMapper<WuliuluxianEntity> {
	
	List<WuliuluxianVO> selectListVO(@Param("ew") Wrapper<WuliuluxianEntity> wrapper);
	
	WuliuluxianVO selectVO(@Param("ew") Wrapper<WuliuluxianEntity> wrapper);
	
	List<WuliuluxianView> selectListView(@Param("ew") Wrapper<WuliuluxianEntity> wrapper);

	List<WuliuluxianView> selectListView(Pagination page,@Param("ew") Wrapper<WuliuluxianEntity> wrapper);
	
	WuliuluxianView selectView(@Param("ew") Wrapper<WuliuluxianEntity> wrapper);
	

}
