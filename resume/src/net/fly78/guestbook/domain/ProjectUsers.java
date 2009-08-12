package net.fly78.guestbook.domain;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class ProjectUsers {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	@Persistent
	private String username;
	@Persistent
	private String password;
	@Persistent
	private String email;
	@Persistent
	private String im;
	@Persistent
	private String birthday;
	@Persistent
	private String url;
	@Persistent
	private Boolean check;
	
	public Boolean getCheck() {
		return check;
	}
	public void setCheck(Boolean check) {
		this.check = check;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIm() {
		return im;
	}
	public void setIm(String im) {
		this.im = im;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public ProjectUsers(String username, String password, String email,
			String im, String birthday, String url) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.im = im;
		this.birthday = birthday;
		this.url = url;
	}
	@Override
	public String toString() {
		return "ProjectUsers [birthday=" + birthday + ", check=" + check
				+ ", email=" + email + ", id=" + id + ", im=" + im
				+ ", password=" + password + ", url=" + url + ", username="
				+ username + "]";
	}
	
	
	
}
