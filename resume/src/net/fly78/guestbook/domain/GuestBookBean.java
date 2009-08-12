package net.fly78.guestbook.domain;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.users.User;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class GuestBookBean {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	@Persistent
	private Integer belongid;
	@Persistent
	private String author;
	@Persistent
	private String content;
	@Persistent
	private Date date;
	@Persistent
	private Boolean publish;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getBelongid() {
		return belongid;
	}
	public void setBelongid(Integer belongid) {
		this.belongid = belongid;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Boolean getPublish() {
		return publish;
	}
	public void setPublish(Boolean publish) {
		this.publish = publish;
	}
	@Override
	public String toString() {
		return "GuestBookBean [author=" + author + ", belongid=" + belongid
				+ ", content=" + content + ", date=" + date + ", id=" + id
				+ ", isPublish=" + publish + "]";
	}
	public GuestBookBean( Integer belongid, String author,
			String content, Date date, Boolean isPublish) {
		super();
		this.belongid = belongid;
		this.author = author;
		this.content = content;
		this.date = date;
		this.publish = isPublish;
	}

	

	
}
