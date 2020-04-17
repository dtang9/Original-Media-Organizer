package omo;

public class Text {
	private String user;
	private String title;
	private String message;
	
	public Text(String user, String title, String message) {
		this.user = user;
		this.title = title;
		this.message = message;
	}

	public String getUser() {
		return user;
	}

	public void setUsername(String user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
