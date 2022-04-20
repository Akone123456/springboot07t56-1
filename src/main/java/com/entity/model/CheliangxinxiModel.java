package com.entity.model;

import com.entity.CheliangxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 车辆信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2022-04-13 17:53:27
 */
public class CheliangxinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 车辆类型
	 */
	
	private String cheliangleixing;
		
	/**
	 * 车架号
	 */
	
	private String chejiahao;
		
	/**
	 * 载重量
	 */
	
	private String zaizhongliang;
		
	/**
	 * 里程
	 */
	
	private String licheng;
		
	/**
	 * 司机姓名
	 */
	
	private String sijixingming;
				
	
	/**
	 * 设置：车辆类型
	 */
	 
	public void setCheliangleixing(String cheliangleixing) {
		this.cheliangleixing = cheliangleixing;
	}
	
	/**
	 * 获取：车辆类型
	 */
	public String getCheliangleixing() {
		return cheliangleixing;
	}
				
	
	/**
	 * 设置：车架号
	 */
	 
	public void setChejiahao(String chejiahao) {
		this.chejiahao = chejiahao;
	}
	
	/**
	 * 获取：车架号
	 */
	public String getChejiahao() {
		return chejiahao;
	}
				
	
	/**
	 * 设置：载重量
	 */
	 
	public void setZaizhongliang(String zaizhongliang) {
		this.zaizhongliang = zaizhongliang;
	}
	
	/**
	 * 获取：载重量
	 */
	public String getZaizhongliang() {
		return zaizhongliang;
	}
				
	
	/**
	 * 设置：里程
	 */
	 
	public void setLicheng(String licheng) {
		this.licheng = licheng;
	}
	
	/**
	 * 获取：里程
	 */
	public String getLicheng() {
		return licheng;
	}
				
	
	/**
	 * 设置：司机姓名
	 */
	 
	public void setSijixingming(String sijixingming) {
		this.sijixingming = sijixingming;
	}
	
	/**
	 * 获取：司机姓名
	 */
	public String getSijixingming() {
		return sijixingming;
	}
			
}
