package com.zidan.model;

public class VideoStreams {

	private String url;
	private String format_note;
	private String extension;
	private String filesize_pretty;
	
	
	
	public VideoStreams() {
		super();
	}
	public VideoStreams(String url, String format_note, String extension, String filesize_pretty) {
		super();
		this.url = url;
		this.format_note = format_note;
		this.extension = extension;
		this.filesize_pretty = filesize_pretty;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getFormat_note() {
		return format_note;
	}
	public void setFormat_note(String format_note) {
		this.format_note = format_note;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getFilesize_pretty() {
		return filesize_pretty;
	}
	public void setFilesize_pretty(String filesize_pretty) {
		this.filesize_pretty = filesize_pretty;
	}

}
