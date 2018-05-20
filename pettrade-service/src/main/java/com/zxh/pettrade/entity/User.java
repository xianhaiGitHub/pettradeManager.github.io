package com.zxh.pettrade.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 客户表
 * @author zhaoxianhai
 *
 */

@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uid")
	private Integer uid;

	@Column(name = "username", nullable = false, length = 32)
	private String userName;

	@Column(name = "password", nullable = false, length = 64)
	private String password;

	@Column(name = "name", nullable = false, length = 32)
	private String name;

	@Column(name = "email", length = 64)
	private String email;

	@Column(name = "phone", nullable = false, length = 16)
	private String phone;

	//年龄表示
	@Column(name = "pwd_key", nullable = false, length = 6)
	private String key;

	@Column(name = "address",length = 255)
	private String addr;

	@Column(name = "state")
	private Integer state;

	@Column(name = "code", length = 255)
	private String code;

	@OneToOne(mappedBy = "user")
	private Wallet wallet;

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", userName=" + userName + ", password=" + password + ", name=" + name + ", email="
				+ email + ", phone=" + phone + ", key=" + key + ", addr=" + addr + ", state=" + state + ", code=" + code
				+ ", wallet=" + wallet + "]";
	}
}
