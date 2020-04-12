package omo;

public class MediaFile {
	private int post_id;
	private String name;
	private String media_file;
	private String url;
	
	public MediaFile(Integer post_id, String name, String media_file, String url) {
		this.setPost_id(post_id);
		this.setName(name);
		this.setMedia_file(media_file);
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

	public String getMedia_file() {
		return media_file;
	}

	public void setMedia_file(String media_file) {
		this.media_file = media_file;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
