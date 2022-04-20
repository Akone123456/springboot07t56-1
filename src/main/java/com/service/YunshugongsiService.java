package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YunshugongsiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YunshugongsiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YunshugongsiView;


/**
 * 运输公司
 *
 * @author 
 * @email 
 * @date 2022-04-13 17:53:27
 */
public interface YunshugongsiService extends IService<YunshugongsiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YunshugongsiVO> selectListVO(Wrapper<YunshugongsiEntity> wrapper);
   	
   	YunshugongsiVO selectVO(@Param("ew") Wrapper<YunshugongsiEntity> wrapper);
   	
   	List<YunshugongsiView> selectListView(Wrapper<YunshugongsiEntity> wrapper);
   	
   	YunshugongsiView selectView(@Param("ew") Wrapper<YunshugongsiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YunshugongsiEntity> wrapper);
   	

}

