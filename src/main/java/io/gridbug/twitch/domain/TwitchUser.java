package io.gridbug.twitch.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Id;

@Entity
public class TwitchUser {
    @Column(length=40)
    @GeneratedValue(generator="randomId")
    @GenericGenerator(name="randomId", strategy="io.gridbug.twitch.domain.RandomIdGenerator")
    @Id
    private String id;

    private String token;
    private String type;
    private String name;
    private Date created_at;
    private Date updated_at;
    // _links
    
    private String logo;
    private String _id;
    private String display_name;
    private String email;
    private Boolean partnered;
    private String bio; // annotate as large string
    // notifications
    
    
    
    public TwitchUser() {
    }

    public TwitchUser(String id, String type, String name, Date created_at, Date updated_at, String logo, String _id,
			String display_name, String email, Boolean partnered, String bio) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.logo = logo;
		this._id = _id;
		this.display_name = display_name;
		this.email = email;
		this.partnered = partnered;
		this.bio = bio;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String type) {
		this.token = token;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getPartnered() {
		return partnered;
	}

	public void setPartnered(Boolean partnered) {
		this.partnered = partnered;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}


}
