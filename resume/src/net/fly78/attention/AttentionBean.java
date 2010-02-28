package net.fly78.attention;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class AttentionBean {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	
	@Persistent
	private Date postDate;
	
	@Persistent
	private String topic;
	
	@Persistent
	private String url;
	
	@Persistent
	private String context;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public AttentionBean(Long id, Date postDate, String topic, String url,
			String context) {
		super();
		this.id = id;
		this.postDate = postDate;
		this.topic = topic;
		this.url = url;
		this.context = context;
	}

	@Override
	public String toString() {
		return "AttentionBean [context=" + context + ", id=" + id
				+ ", postDate=" + postDate + ", topic=" + topic + ", url="
				+ url + "]";
	}
	
	
}
