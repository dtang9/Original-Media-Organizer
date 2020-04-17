package omo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {
	private int id;
	private String user;
	private String title;
	private String message;
	private Date date;
	List<MediaFile> mediafiles = new ArrayList<MediaFile>();
	List<Hashtag> hashtags = new ArrayList<Hashtag>();

	public Post(int id, String user, String title, String message, Date date) {
		this.id = id;
		this.user = user;
		this.title = title;
		this.message = message;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<MediaFile> getMediafiles() {
		return mediafiles;
	}
	
	public void addMediafile(MediaFile file) {
		mediafiles.add(file);
	}

	public List<Hashtag> getHashtags() {
		return hashtags;
	}

	public void addHashtag(Hashtag hashtag) {
		hashtags.add(hashtag);
	}
}
