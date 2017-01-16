package cn.itcast.formbean;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class VideoForm extends ActionForm {
	private String format;
	private String name;
	private String timelength;
	private FormFile video;
	
	private String sender;
	private String content;
	private String time;

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public FormFile getVideo() {
		return video;
	}

	public void setVideo(FormFile video) {
		this.video = video;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTimelength() {
		return timelength;
	}

	public void setTimelength(String timelength) {
		this.timelength = timelength;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
	
}
