package omo;

public class MediaFile {
	private int post_id;
	private String name;
	private String media_type;
	private String url;
	
	public MediaFile(Integer post_id, String name, String media_type, String url) {
		this.setPost_id(post_id);
		this.setName(name);
		this.setMedia_type(media_type);
		this.setUrl(url);
		
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMedia_type() {
		return media_type;
	}

	public void setMedia_type(String media_type) {
		this.media_type = media_type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
