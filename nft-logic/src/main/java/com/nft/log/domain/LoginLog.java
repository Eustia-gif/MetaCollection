package com.nft.log.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.nft.common.utils.IdUtils;
import com.nft.constants.Constant;

import cn.hutool.http.useragent.UserAgent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "login_log")
@DynamicInsert(true)
@DynamicUpdate(true)
public class LoginLog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", length = 32)
	private String id;

	private String subSystem;

	private String state;

	private String ipAddr;

	private Date loginTime;

	private String browser;

	private String os;

	private String msg;

	private String userName;

	public LoginLog loginFail(String msg) {
		this.setState(Constant.LOGIN_STATUS_FAILURE);
		this.setMsg(msg);
		return this;
	}
	
	public LoginLog loginSuccess() {
		this.setState(Constant.LOGIN_STATUS_SUCCESS);
		this.setMsg(Constant.LOGIN_PROMPT_LOGIN_SUCCESS);
		return this;
	}

	public static LoginLog buildLog(String userName, String subSystem, String ipAddr, UserAgent userAgent) {
		LoginLog loginLog = new LoginLog();
		loginLog.setId(IdUtils.getId());
		loginLog.setUserName(userName);
		loginLog.setSubSystem(subSystem);
		loginLog.setIpAddr(ipAddr);
		loginLog.setLoginTime(new Date());
		loginLog.setBrowser(userAgent.getBrowser().getName());
		loginLog.setOs(userAgent.getOs().getName());
		return loginLog;
	}

}
