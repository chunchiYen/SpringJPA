package com.example.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=50)
	private String id;

	@Column(length=20)
	private String createtime;

	@Column(name="CURRENT_CONNECTIONS", nullable=false)
	private BigInteger currentConnections;

	@Column(length=50)
	private String lastlogintime;

	@Column(length=30)
	private String name;

	@Column(length=30)
	private String nickname;

	@Column(length=20)
	private String password;

	@Column(length=255)
	private String picture;

	@Column(length=10)
	private String sex;

	@Column(length=255)
	private String tilepath;

	@Column(name="TOTAL_CONNECTIONS", nullable=false)
	private BigInteger totalConnections;

	@Column(length=32)
	private String user;

	@Column(length=30)
	private String username;

	public User() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public BigInteger getCurrentConnections() {
		return this.currentConnections;
	}

	public void setCurrentConnections(BigInteger currentConnections) {
		this.currentConnections = currentConnections;
	}

	public String getLastlogintime() {
		return this.lastlogintime;
	}

	public void setLastlogintime(String lastlogintime) {
		this.lastlogintime = lastlogintime;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTilepath() {
		return this.tilepath;
	}

	public void setTilepath(String tilepath) {
		this.tilepath = tilepath;
	}

	public BigInteger getTotalConnections() {
		return this.totalConnections;
	}

	public void setTotalConnections(BigInteger totalConnections) {
		this.totalConnections = totalConnections;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}