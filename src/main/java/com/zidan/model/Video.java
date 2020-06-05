package com.zidan.model;


import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Video {
 private Boolean status;
 private String title;
 private String duration;
 private String thumbnail;
 private List<VideoStreams> videoStreams;
public Boolean getStatus() {
	return status;
}
public void setStatus(Boolean status) {
	this.status = status;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDuration() {
	Integer durationtime=Integer.parseInt(duration);
    int min = durationtime/60;
    int sec = durationtime%60;
    
	return min+":"+sec;
}
public void setDuration(String duration) {
	this.duration = duration;
}
public String getThumbnail() {
	return thumbnail;
}
public void setThumbnail(String thumbnail) {
	this.thumbnail = thumbnail;
}
public List<VideoStreams> getVideoStreams() {
	return videoStreams;
}
public void setVideoStreams(List<VideoStreams> videoStreams) {
	this.videoStreams = videoStreams;
}

 
}
