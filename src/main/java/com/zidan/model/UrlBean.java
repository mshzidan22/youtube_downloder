package com.zidan.model;

import javax.validation.constraints.Pattern;

public class UrlBean {

    @Pattern(regexp = "^(http(s)?:\\/\\/)?((w){3}.)?youtu(be|.be)?(\\.com)?\\/.+",message = "Please Enter a valid youtube link")
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	

}
