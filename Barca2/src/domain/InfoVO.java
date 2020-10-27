package domain;

import javafx.scene.image.Image;

public class InfoVO {
	private String title;
	private String content;
	private Image img;
	
	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public InfoVO(String title, String content, Image img) {
		this.title = title;
		this.content = content;
		this.img = img;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return title;
	}
}
