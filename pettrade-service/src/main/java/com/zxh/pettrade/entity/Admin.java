package com.zxh.pettrade.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * 宠物管理平台用户实体
 * @author zhaoxianhai
 * 
 */
@Table(name="adminuser")
@Entity
public class Admin implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="uid")
	private Integer uid;
	
	//@NotEmpty
	@Column(name="username",nullable=false,length=32)
	private String username;
	
	//@NotEmpty
	@Column(name="password",nullable=false,length=32)
	private String password;

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [uid=" + uid + ", username=" + username + ", password=" + password + "]";
	}

	

}
