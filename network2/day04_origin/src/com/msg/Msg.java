package com.msg;

import java.io.Serializable;

public class Msg implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ip;
	private String id;
	private String msg;
	private String wip;
	public Msg() {
	}
	public Msg(String ip) {
		this.ip = ip;
	}
	public Msg(String id, String msg) {
		this.id = id;
		this.msg = msg;
	}
	public Msg(String ip, String id, String msg) {
		this.ip = ip;
		this.id = id;
		this.msg = msg;
	}
	
	public Msg(String ip, String id, String msg, String wip) {
		this.ip = ip;
		this.id = id;
		this.msg = msg;
		this.wip = wip;
	}
	
	public String getWip() {
		return wip;
	}
	public void setWip(String wip) {
		this.wip = wip;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}
