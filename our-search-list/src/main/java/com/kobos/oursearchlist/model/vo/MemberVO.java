package com.kobos.oursearchlist.model.vo;

public class MemberVO {

	private String id;
	private String password;
	private String email;
	private String nickname;
	private String certified;
	private String enabled;

	public MemberVO(String id, String password, String email, String nickname, String certified, String enabled) {
		super();
		this.id = id;
		this.password = password;
		this.email = email;
		this.nickname = nickname;
		this.certified = certified;
		this.enabled = enabled;
	}

	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getCertified() {
		return certified;
	}

	public void setCertified(String certified) {
		this.certified = certified;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", email=" + email + ", nickname=" + nickname
				+ ", certified=" + certified + ", enabled=" + enabled + "]";
	}

}
