package omo;

public class Hashtag {
	private int post_id;
	private String word;

	public Hashtag(int post_id, String word) {
		this.post_id = post_id;
		this.word = word;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

}
