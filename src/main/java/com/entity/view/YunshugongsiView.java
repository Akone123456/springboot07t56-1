package com.entity.view;

import com.entity.YunshugongsiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 运输公司
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-13 17:53:27
 */
@TableName("yunshugongsi")
public class YunshugongsiView  extends YunshugongsiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YunshugongsiView(){
	}
 
 	public YunshugongsiView(YunshugongsiEntity yunshugongsiEntity){
 	try {
			BeanUtils.copyProperties(this, yunshugongsiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
