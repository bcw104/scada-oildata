package com.ht.scada.oildata.entity;

import com.ht.scada.security.entity.User;

import java.util.Date;

import javax.persistence.Column;

/**
 * 故障诊断记录
 * @author 薄成文
 *
 */
public class FaultDiagnoseRecord {

	private String id; // 唯一主键
	private String code;// 计量点编号(回路号、井号等)
	private String name;// 故障类型
	private String info;// 故障信息
	private Integer level;	// 故障程度 
	@Column(name = "action_time")
	private Date actionTime;
	@Column(name = "resume_time")
	private Date resumeTime;
	
	private User user;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	public Integer getLevel() {
		return level;
	}
	
	public void setLevel(Integer level) {
		this.level = level;
	}

	public Date getActionTime() {
		return actionTime;
	}

	public void setActionTime(Date actionTime) {
		this.actionTime = actionTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	public Date getResumeTime() {
		return resumeTime;
	}

	public void setResumeTime(Date resumeTime) {
		this.resumeTime = resumeTime;
	}

	/**
	 * 生成报警记录用
	 * @return
	 */
	public String getReMark() {
		return "故障类型为：" + name + (level==null?"":("；故障程度为：" + String.valueOf(level)));
	}

}
