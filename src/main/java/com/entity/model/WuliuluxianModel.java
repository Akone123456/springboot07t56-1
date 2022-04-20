package com.entity.model;

import com.entity.WuliuluxianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 物流路线
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2022-04-13 17:53:27
 */
public class WuliuluxianModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 起点地址
	 */
	
	private String qidiandizhi;
		
	/**
	 * 到达地址
	 */
	
	private String daodadizhi;
		
	/**
	 * 物流单价
	 */
	
	private Float wuliudanjia;
		
	/**
	 * 路线详情
	 */
	
	private String luxianxiangqing;
		
	/**
	 * 公司编号
	 */
	
	private String gongsibianhao;
		
	/**
	 * 公司名称
	 */
	
	private String gongsimingcheng;
		
	/**
	 * 联系电话
	 */
	
	private String lianxidianhua;
				
	
	/**
	 * 设置：起点地址
	 */
	 
	public void setQidiandizhi(String qidiandizhi) {
		this.qidiandizhi = qidiandizhi;
	}
	
	/**
	 * 获取：起点地址
	 */
	public String getQidiandizhi() {
		return qidiandizhi;
	}
				
	
	/**
	 * 设置：到达地址
	 */
	 
	public void setDaodadizhi(String daodadizhi) {
		this.daodadizhi = daodadizhi;
	}
	
	/**
	 * 获取：到达地址
	 */
	public String getDaodadizhi() {
		return daodadizhi;
	}
				
	
	/**
	 * 设置：物流单价
	 */
	 
	public void setWuliudanjia(Float wuliudanjia) {
		this.wuliudanjia = wuliudanjia;
	}
	
	/**
	 * 获取：物流单价
	 */
	public Float getWuliudanjia() {
		return wuliudanjia;
	}
				
	
	/**
	 * 设置：路线详情
	 */
	 
	public void setLuxianxiangqing(String luxianxiangqing) {
		this.luxianxiangqing = luxianxiangqing;
	}
	
	/**
	 * 获取：路线详情
	 */
	public String getLuxianxiangqing() {
		return luxianxiangqing;
	}
				
	
	/**
	 * 设置：公司编号
	 */
	 
	public void setGongsibianhao(String gongsibianhao) {
		this.gongsibianhao = gongsibianhao;
	}
	
	/**
	 * 获取：公司编号
	 */
	public String getGongsibianhao() {
		return gongsibianhao;
	}
				
	
	/**
	 * 设置：公司名称
	 */
	 
	public void setGongsimingcheng(String gongsimingcheng) {
		this.gongsimingcheng = gongsimingcheng;
	}
	
	/**
	 * 获取：公司名称
	 */
	public String getGongsimingcheng() {
		return gongsimingcheng;
	}
				
	
	/**
	 * 设置：联系电话
	 */
	 
	public void setLianxidianhua(String lianxidianhua) {
		this.lianxidianhua = lianxidianhua;
	}
	
	/**
	 * 获取：联系电话
	 */
	public String getLianxidianhua() {
		return lianxidianhua;
	}
			
}
