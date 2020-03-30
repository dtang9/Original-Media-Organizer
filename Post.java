package omo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {
	private int id;
	private String username;
	private String title;
	private String text;
	private Date date;
	List<MediaFile> mediafiles = new ArrayList<MediaFile>();

	public Post(int id, String username, String title, String text, Date date) {
		this.id = id;
		this.username = username;
		this.title = title;
		this.text = text;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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
}
