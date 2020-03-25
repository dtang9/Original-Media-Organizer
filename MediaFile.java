package omo;

public class MediaFile {
	private Integer postId;
	private String name;
	private String type;
	private String url;
	
	public MediaFile(Integer postId, String name, String type, String url) {
		this.postId = postId;
		this.name = name;
		this.type = type;
		this.url = url;
		
	}
	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
