package com.zidan.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zidan.model.Video;
import com.zidan.model.VideoStreams;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;
@Service
public class YoutubeService {

@Autowired
private Video video;

	
	public Video getVideo(String url) {

		HttpResponse<String> response = Unirest.get("https://getvideo.p.rapidapi.com/?url="+url)
				.header("x-rapidapi-host", "getvideo.p.rapidapi.com")
				.header("x-rapidapi-key", "30a07ee996msh4cd8f0454d66117p1c82f9jsnf8b10a5ef492")
				.asString();
	
		System.out.println(response.getBody());
		
		JSONObject js = new JSONObject(response.getBody());
		
		//test response
//		JSONObject js = new JSONObject("{\r\n" + 
//				"    \"status\": true,\r\n" + 
//				"    \"message\": \"Successfully received info.\",\r\n" + 
//				"    \"description\": \"العنوان : افضل الاهداف المهينة فى تاريخ كرة القدم !!\\n• إذا أعجبك الفيديو , لايك ومشاركة للفيديو مع اصدقائك.\\n----------------------------------------­--------------------------\\n• أشترك فى قناة ( #سكيتشات_كرة_القدم ) : https://goo.gl/2su1Xx\\n• لا تنسى تفعيل الجرس🔔.\\n----------------------------------------­--------------------------\\n• تابعني على :\\n✔ الفيس بوك : https://www.facebook.com/sketchatkora\\n✔ تويتر : https://twitter.com/sketchatkora\\n✔ انستجرام : https://www.instagram.com/sketchatkora\",\r\n" + 
//				"    \"uploader\": \"سكيتشات كرة القدم\",\r\n" + 
//				"    \"url\": \"https://www.youtube.com/watch?v=4bdGtS6lD0M\",\r\n" + 
//				"    \"id\": \"4bdGtS6lD0M\",\r\n" + 
//				"    \"is_playlist\": false,\r\n" + 
//				"    \"site\": \"YouTube\",\r\n" + 
//				"    \"title\": \"افضل الاهداف المهينة فى تاريخ كرة القدم !!\",\r\n" + 
//				"    \"like_count\": 102097,\r\n" + 
//				"    \"dislike_count\": 8829,\r\n" + 
//				"    \"view_count\": 14123624,\r\n" + 
//				"    \"duration\": 383,\r\n" + 
//				"    \"upload_date\": \"20180510\",\r\n" + 
//				"    \"tags\": [\r\n" + 
//				"        \"اهداف\",\r\n" + 
//				"        \"اهداف كرة القدم\",\r\n" + 
//				"        \"كرة القدم\",\r\n" + 
//				"        \"سكيتشات كرة القدم\"\r\n" + 
//				"    ],\r\n" + 
//				"    \"uploader_url\": \"http://www.youtube.com/channel/UC7rBmJ4p-WIgQudtb2zaofw\",\r\n" + 
//				"    \"thumbnail\": \"https://i.ytimg.com/vi/4bdGtS6lD0M/maxresdefault.jpg\",\r\n" + 
//				"    \"streams\": [\r\n" + 
//				"        {\r\n" + 
//				"            \"url\": \"https://r2---sn-4g5e6nle.googlevideo.com/videoplayback?expire=1591025010&ei=EsnUXsP5IJaC1wKisqCoCw&ip=46.165.230.5&id=e1b746b52ea50f43&itag=22&source=youtube&requiressl=yes&mh=x_&mm=31%2C29&mn=sn-4g5e6nle%2Csn-4g5edn7y&ms=au%2Crdu&mv=m&mvi=1&pl=23&initcwndbps=1443750&vprv=1&mime=video%2Fmp4&ratebypass=yes&dur=383.129&lmt=1575845479933998&mt=1591003295&fvip=2&c=WEB&txp=5535432&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRgIhAKP30y0J40Sh7Zws_mW7lnrxCFHqBSttX0_Yu38XXbB4AiEA2LKLz0fuc4ojFuRIVwEJLCEkcdsiDrRgoZdlSaZwhMY%3D&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRQIgGdBmriZCEog9I0dLsqPxraVHY2IjmFMvq0TWsfA2R-kCIQDDBGh_pwlDSlfIRiLjQxOYsomTuvi9C0qX4dgrr3a9-w%3D%3D\",\r\n" + 
//				"            \"format\": \"1280x720 (720p)\",\r\n" + 
//				"            \"format_note\": \"720p\",\r\n" + 
//				"            \"extension\": \"mp4\",\r\n" + 
//				"            \"video_codec\": \"avc1.64001F\",\r\n" + 
//				"            \"audio_codec\": \"mp4a.40.2\",\r\n" + 
//				"            \"height\": 720,\r\n" + 
//				"            \"width\": 1280,\r\n" + 
//				"            \"fps\": 25,\r\n" + 
//				"            \"fmt_id\": \"22\",\r\n" + 
//				"            \"filesize\": null,\r\n" + 
//				"            \"filesize_pretty\": \"-\",\r\n" + 
//				"            \"has_audio\": true,\r\n" + 
//				"            \"has_video\": true,\r\n" + 
//				"            \"is_hd\": true\r\n" + 
//				"        },\r\n" + 
//				"        {\r\n" + 
//				"            \"url\": \"https://r2---sn-4g5e6nle.googlevideo.com/videoplayback?expire=1591025010&ei=EsnUXsP5IJaC1wKisqCoCw&ip=46.165.230.5&id=e1b746b52ea50f43&itag=18&source=youtube&requiressl=yes&mh=x_&mm=31%2C29&mn=sn-4g5e6nle%2Csn-4g5edn7y&ms=au%2Crdu&mv=m&mvi=1&pl=23&initcwndbps=1443750&vprv=1&mime=video%2Fmp4&gir=yes&clen=29961308&ratebypass=yes&dur=383.129&lmt=1575843111887557&mt=1591003295&fvip=2&c=WEB&txp=5531432&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cgir%2Cclen%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRQIgChjOHNI3ouaqVs7puXlBXERj6OUwafQAMFjXywIyTUkCIQCK-547cAj1uOscCo_VGGV6x00b2HPsslqTuppDCR34lA%3D%3D&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRQIgGdBmriZCEog9I0dLsqPxraVHY2IjmFMvq0TWsfA2R-kCIQDDBGh_pwlDSlfIRiLjQxOYsomTuvi9C0qX4dgrr3a9-w%3D%3D\",\r\n" + 
//				"            \"format\": \"640x360 (360p)\",\r\n" + 
//				"            \"format_note\": \"360p\",\r\n" + 
//				"            \"extension\": \"mp4\",\r\n" + 
//				"            \"video_codec\": \"avc1.42001E\",\r\n" + 
//				"            \"audio_codec\": \"mp4a.40.2\",\r\n" + 
//				"            \"height\": 360,\r\n" + 
//				"            \"width\": 640,\r\n" + 
//				"            \"fps\": 25,\r\n" + 
//				"            \"fmt_id\": \"18\",\r\n" + 
//				"            \"filesize\": 29961308,\r\n" + 
//				"            \"filesize_pretty\": \"28.57 MB\",\r\n" + 
//				"            \"has_audio\": true,\r\n" + 
//				"            \"has_video\": true,\r\n" + 
//				"            \"is_hd\": false\r\n" + 
//				"        },\r\n" + 
//				"        {\r\n" + 
//				"            \"url\": \"https://r2---sn-4g5e6nle.googlevideo.com/videoplayback?expire=1591025010&ei=EsnUXsP5IJaC1wKisqCoCw&ip=46.165.230.5&id=e1b746b52ea50f43&itag=251&source=youtube&requiressl=yes&mh=x_&mm=31%2C29&mn=sn-4g5e6nle%2Csn-4g5edn7y&ms=au%2Crdu&mv=m&mvi=1&pl=23&initcwndbps=1443750&vprv=1&mime=audio%2Fwebm&gir=yes&clen=6221780&dur=383.101&lmt=1575843989090277&mt=1591003295&fvip=2&keepalive=yes&c=WEB&txp=5531432&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cgir%2Cclen%2Cdur%2Clmt&sig=AOq0QJ8wRgIhAO49CY1gA0jdXKKEbZBxmZjw1qpAGmzQNSzz_aIPniuGAiEAxCn--VvwT9hfLztH0DHsxeduwAFjRdX5ah_sOKJ_TbE%3D&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRQIgGdBmriZCEog9I0dLsqPxraVHY2IjmFMvq0TWsfA2R-kCIQDDBGh_pwlDSlfIRiLjQxOYsomTuvi9C0qX4dgrr3a9-w%3D%3D&ratebypass=yes\",\r\n" + 
//				"            \"format\": \"audio only (tiny)\",\r\n" + 
//				"            \"format_note\": \"tiny\",\r\n" + 
//				"            \"extension\": \"webm\",\r\n" + 
//				"            \"video_codec\": \"none\",\r\n" + 
//				"            \"audio_codec\": \"opus\",\r\n" + 
//				"            \"height\": null,\r\n" + 
//				"            \"width\": null,\r\n" + 
//				"            \"fps\": null,\r\n" + 
//				"            \"fmt_id\": \"251\",\r\n" + 
//				"            \"filesize\": 6221780,\r\n" + 
//				"            \"filesize_pretty\": \"5.93 MB\",\r\n" + 
//				"            \"has_audio\": true,\r\n" + 
//				"            \"has_video\": true,\r\n" + 
//				"            \"is_hd\": false\r\n" + 
//				"        },\r\n" + 
//				"        {\r\n" + 
//				"            \"url\": \"https://r2---sn-4g5e6nle.googlevideo.com/videoplayback?expire=1591025010&ei=EsnUXsP5IJaC1wKisqCoCw&ip=46.165.230.5&id=e1b746b52ea50f43&itag=250&source=youtube&requiressl=yes&mh=x_&mm=31%2C29&mn=sn-4g5e6nle%2Csn-4g5edn7y&ms=au%2Crdu&mv=m&mvi=1&pl=23&initcwndbps=1443750&vprv=1&mime=audio%2Fwebm&gir=yes&clen=3145390&dur=383.101&lmt=1575843989839785&mt=1591003295&fvip=2&keepalive=yes&c=WEB&txp=5531432&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cgir%2Cclen%2Cdur%2Clmt&sig=AOq0QJ8wRQIhAOOa3ZlsFFBRD4oWhjAi369AA0vuPkW0CLkKaeKv3FpTAiApsXZTOzB639QJL6lEIp7EnEGpnOovhGNrz3JZjoDg-A%3D%3D&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRQIgGdBmriZCEog9I0dLsqPxraVHY2IjmFMvq0TWsfA2R-kCIQDDBGh_pwlDSlfIRiLjQxOYsomTuvi9C0qX4dgrr3a9-w%3D%3D&ratebypass=yes\",\r\n" + 
//				"            \"format\": \"audio only (tiny)\",\r\n" + 
//				"            \"format_note\": \"tiny\",\r\n" + 
//				"            \"extension\": \"webm\",\r\n" + 
//				"            \"video_codec\": \"none\",\r\n" + 
//				"            \"audio_codec\": \"opus\",\r\n" + 
//				"            \"height\": null,\r\n" + 
//				"            \"width\": null,\r\n" + 
//				"            \"fps\": null,\r\n" + 
//				"            \"fmt_id\": \"250\",\r\n" + 
//				"            \"filesize\": 3145390,\r\n" + 
//				"            \"filesize_pretty\": \"3 MB\",\r\n" + 
//				"            \"has_audio\": true,\r\n" + 
//				"            \"has_video\": true,\r\n" + 
//				"            \"is_hd\": false\r\n" + 
//				"        },\r\n" + 
//				"        {\r\n" + 
//				"            \"url\": \"https://r2---sn-4g5e6nle.googlevideo.com/videoplayback?expire=1591025010&ei=EsnUXsP5IJaC1wKisqCoCw&ip=46.165.230.5&id=e1b746b52ea50f43&itag=249&source=youtube&requiressl=yes&mh=x_&mm=31%2C29&mn=sn-4g5e6nle%2Csn-4g5edn7y&ms=au%2Crdu&mv=m&mvi=1&pl=23&initcwndbps=1443750&vprv=1&mime=audio%2Fwebm&gir=yes&clen=2401302&dur=383.101&lmt=1575843985924398&mt=1591003295&fvip=2&keepalive=yes&c=WEB&txp=5531432&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cgir%2Cclen%2Cdur%2Clmt&sig=AOq0QJ8wRAIgDUE0Bk1ZgsRtGUbUAyFvfJCsQpgLNyPYoHPK5p5riYcCIE0m4qa5_MKchwet4bpI01nObxF7a7OEcbugdUWhOO3z&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRQIgGdBmriZCEog9I0dLsqPxraVHY2IjmFMvq0TWsfA2R-kCIQDDBGh_pwlDSlfIRiLjQxOYsomTuvi9C0qX4dgrr3a9-w%3D%3D&ratebypass=yes\",\r\n" + 
//				"            \"format\": \"audio only (tiny)\",\r\n" + 
//				"            \"format_note\": \"tiny\",\r\n" + 
//				"            \"extension\": \"webm\",\r\n" + 
//				"            \"video_codec\": \"none\",\r\n" + 
//				"            \"audio_codec\": \"opus\",\r\n" + 
//				"            \"height\": null,\r\n" + 
//				"            \"width\": null,\r\n" + 
//				"            \"fps\": null,\r\n" + 
//				"            \"fmt_id\": \"249\",\r\n" + 
//				"            \"filesize\": 2401302,\r\n" + 
//				"            \"filesize_pretty\": \"2.29 MB\",\r\n" + 
//				"            \"has_audio\": true,\r\n" + 
//				"            \"has_video\": true,\r\n" + 
//				"            \"is_hd\": false\r\n" + 
//				"        },\r\n" + 
//				"        {\r\n" + 
//				"            \"url\": \"https://r2---sn-4g5e6nle.googlevideo.com/videoplayback?expire=1591025010&ei=EsnUXsP5IJaC1wKisqCoCw&ip=46.165.230.5&id=e1b746b52ea50f43&itag=299&aitags=133%2C134%2C135%2C136%2C137%2C160%2C242%2C243%2C244%2C247%2C248%2C278%2C298%2C299%2C302%2C303%2C394%2C395%2C396%2C397&source=youtube&requiressl=yes&mh=x_&mm=31%2C29&mn=sn-4g5e6nle%2Csn-4g5edn7y&ms=au%2Crdu&mv=m&mvi=1&pl=23&initcwndbps=1443750&vprv=1&mime=video%2Fmp4&gir=yes&clen=110574248&dur=383.080&lmt=1575845295682194&mt=1591003295&fvip=2&keepalive=yes&c=WEB&txp=5535432&sparams=expire%2Cei%2Cip%2Cid%2Caitags%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cgir%2Cclen%2Cdur%2Clmt&sig=AOq0QJ8wRgIhAJrGaOjckebYWtupy4zZSS3f6-NOu_FOhCGG1vL9Ymf0AiEA54ITIQxE0dU0Pxyg24iauEmOmrtrEz4pMIt9uy6oma8%3D&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRQIgGdBmriZCEog9I0dLsqPxraVHY2IjmFMvq0TWsfA2R-kCIQDDBGh_pwlDSlfIRiLjQxOYsomTuvi9C0qX4dgrr3a9-w%3D%3D&ratebypass=yes\",\r\n" + 
//				"            \"format\": \"1920x1080 (1080p50)\",\r\n" + 
//				"            \"format_note\": \"video only, no audio\",\r\n" + 
//				"            \"extension\": \"mp4\",\r\n" + 
//				"            \"video_codec\": \"avc1.64002a\",\r\n" + 
//				"            \"audio_codec\": \"none\",\r\n" + 
//				"            \"height\": 1080,\r\n" + 
//				"            \"width\": 1920,\r\n" + 
//				"            \"fps\": 50,\r\n" + 
//				"            \"fmt_id\": \"299\",\r\n" + 
//				"            \"filesize\": 110574248,\r\n" + 
//				"            \"filesize_pretty\": \"105.45 MB\",\r\n" + 
//				"            \"has_audio\": false,\r\n" + 
//				"            \"has_video\": true,\r\n" + 
//				"            \"is_hd\": false\r\n" + 
//				"        },\r\n" + 
//				"        {\r\n" + 
//				"            \"url\": \"https://r2---sn-4g5e6nle.googlevideo.com/videoplayback?expire=1591025010&ei=EsnUXsP5IJaC1wKisqCoCw&ip=46.165.230.5&id=e1b746b52ea50f43&itag=137&aitags=133%2C134%2C135%2C136%2C137%2C160%2C242%2C243%2C244%2C247%2C248%2C278%2C298%2C299%2C302%2C303%2C394%2C395%2C396%2C397&source=youtube&requiressl=yes&mh=x_&mm=31%2C29&mn=sn-4g5e6nle%2Csn-4g5edn7y&ms=au%2Crdu&mv=m&mvi=1&pl=23&initcwndbps=1443750&vprv=1&mime=video%2Fmp4&gir=yes&clen=107752280&dur=383.080&lmt=1575845307784020&mt=1591003295&fvip=2&keepalive=yes&c=WEB&txp=5535432&sparams=expire%2Cei%2Cip%2Cid%2Caitags%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cgir%2Cclen%2Cdur%2Clmt&sig=AOq0QJ8wRQIgTWXt0T-mVoEy4akmYg1IC8fhmzq-_apRx8xKOgI7D4MCIQDrq_yGc40raZFJikqm6b7yvPdHPNLi0AgXLn6jk9AwIg%3D%3D&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRQIgGdBmriZCEog9I0dLsqPxraVHY2IjmFMvq0TWsfA2R-kCIQDDBGh_pwlDSlfIRiLjQxOYsomTuvi9C0qX4dgrr3a9-w%3D%3D&ratebypass=yes\",\r\n" + 
//				"            \"format\": \"1920x1080 (1080p)\",\r\n" + 
//				"            \"format_note\": \"video only, no audio\",\r\n" + 
//				"            \"extension\": \"mp4\",\r\n" + 
//				"            \"video_codec\": \"avc1.640028\",\r\n" + 
//				"            \"audio_codec\": \"none\",\r\n" + 
//				"            \"height\": 1080,\r\n" + 
//				"            \"width\": 1920,\r\n" + 
//				"            \"fps\": 25,\r\n" + 
//				"            \"fmt_id\": \"137\",\r\n" + 
//				"            \"filesize\": 107752280,\r\n" + 
//				"            \"filesize_pretty\": \"102.76 MB\",\r\n" + 
//				"            \"has_audio\": false,\r\n" + 
//				"            \"has_video\": true,\r\n" + 
//				"            \"is_hd\": false\r\n" + 
//				"        },\r\n" + 
//				"        {\r\n" + 
//				"            \"url\": \"https://r2---sn-4g5e6nle.googlevideo.com/videoplayback?expire=1591025010&ei=EsnUXsP5IJaC1wKisqCoCw&ip=46.165.230.5&id=e1b746b52ea50f43&itag=303&aitags=133%2C134%2C135%2C136%2C137%2C160%2C242%2C243%2C244%2C247%2C248%2C278%2C298%2C299%2C302%2C303%2C394%2C395%2C396%2C397&source=youtube&requiressl=yes&mh=x_&mm=31%2C29&mn=sn-4g5e6nle%2Csn-4g5edn7y&ms=au%2Crdu&mv=m&mvi=1&pl=23&initcwndbps=1443750&vprv=1&mime=video%2Fwebm&gir=yes&clen=129312220&dur=383.080&lmt=1575846414909451&mt=1591003295&fvip=2&keepalive=yes&c=WEB&txp=5535432&sparams=expire%2Cei%2Cip%2Cid%2Caitags%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cgir%2Cclen%2Cdur%2Clmt&sig=AOq0QJ8wQwIgAUO-nqHAoQOAp96qLQ2KntaRY4L8B0DA7eRmS98sJaICHxjMsBKnHrGWTfaG-LLz6MLygnIFaUf9_VtrdB9mJaM%3D&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRQIgGdBmriZCEog9I0dLsqPxraVHY2IjmFMvq0TWsfA2R-kCIQDDBGh_pwlDSlfIRiLjQxOYsomTuvi9C0qX4dgrr3a9-w%3D%3D&ratebypass=yes\",\r\n" + 
//				"            \"format\": \"1920x1080 (1080p50)\",\r\n" + 
//				"            \"format_note\": \"video only, no audio\",\r\n" + 
//				"            \"extension\": \"webm\",\r\n" + 
//				"            \"video_codec\": \"vp9\",\r\n" + 
//				"            \"audio_codec\": \"none\",\r\n" + 
//				"            \"height\": 1080,\r\n" + 
//				"            \"width\": 1920,\r\n" + 
//				"            \"fps\": 50,\r\n" + 
//				"            \"fmt_id\": \"303\",\r\n" + 
//				"            \"filesize\": 129312220,\r\n" + 
//				"            \"filesize_pretty\": \"123.32 MB\",\r\n" + 
//				"            \"has_audio\": false,\r\n" + 
//				"            \"has_video\": true,\r\n" + 
//				"            \"is_hd\": false\r\n" + 
//				"        },\r\n" + 
//				"        {\r\n" + 
//				"            \"url\": \"https://r2---sn-4g5e6nle.googlevideo.com/videoplayback?expire=1591025010&ei=EsnUXsP5IJaC1wKisqCoCw&ip=46.165.230.5&id=e1b746b52ea50f43&itag=248&aitags=133%2C134%2C135%2C136%2C137%2C160%2C242%2C243%2C244%2C247%2C248%2C278%2C298%2C299%2C302%2C303%2C394%2C395%2C396%2C397&source=youtube&requiressl=yes&mh=x_&mm=31%2C29&mn=sn-4g5e6nle%2Csn-4g5edn7y&ms=au%2Crdu&mv=m&mvi=1&pl=23&initcwndbps=1443750&vprv=1&mime=video%2Fwebm&gir=yes&clen=90236292&dur=383.080&lmt=1575845840493521&mt=1591003295&fvip=2&keepalive=yes&c=WEB&txp=5535432&sparams=expire%2Cei%2Cip%2Cid%2Caitags%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cgir%2Cclen%2Cdur%2Clmt&sig=AOq0QJ8wRAIgSgU4N36sVcwlz6GhkMh0LKTFfdmVF95F_ljsEP_HuTgCIDWjydVMGCssEL691JjRGPeXwacSMNZcWnzRBVlWKNUV&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRQIgGdBmriZCEog9I0dLsqPxraVHY2IjmFMvq0TWsfA2R-kCIQDDBGh_pwlDSlfIRiLjQxOYsomTuvi9C0qX4dgrr3a9-w%3D%3D&ratebypass=yes\",\r\n" + 
//				"            \"format\": \"1920x1080 (1080p)\",\r\n" + 
//				"            \"format_note\": \"video only, no audio\",\r\n" + 
//				"            \"extension\": \"webm\",\r\n" + 
//				"            \"video_codec\": \"vp9\",\r\n" + 
//				"            \"audio_codec\": \"none\",\r\n" + 
//				"            \"height\": 1080,\r\n" + 
//				"            \"width\": 1920,\r\n" + 
//				"            \"fps\": 25,\r\n" + 
//				"            \"fmt_id\": \"248\",\r\n" + 
//				"            \"filesize\": 90236292,\r\n" + 
//				"            \"filesize_pretty\": \"86.06 MB\",\r\n" + 
//				"            \"has_audio\": false,\r\n" + 
//				"            \"has_video\": true,\r\n" + 
//				"            \"is_hd\": false\r\n" + 
//				"        },\r\n" + 
//				"        {\r\n" + 
//				"            \"url\": \"https://r2---sn-4g5e6nle.googlevideo.com/videoplayback?expire=1591025010&ei=EsnUXsP5IJaC1wKisqCoCw&ip=46.165.230.5&id=e1b746b52ea50f43&itag=136&aitags=133%2C134%2C135%2C136%2C137%2C160%2C242%2C243%2C244%2C247%2C248%2C278%2C298%2C299%2C302%2C303%2C394%2C395%2C396%2C397&source=youtube&requiressl=yes&mh=x_&mm=31%2C29&mn=sn-4g5e6nle%2Csn-4g5edn7y&ms=au%2Crdu&mv=m&mvi=1&pl=23&initcwndbps=1443750&vprv=1&mime=video%2Fmp4&gir=yes&clen=62479222&dur=383.080&lmt=1575845347050764&mt=1591003295&fvip=2&keepalive=yes&c=WEB&txp=5535432&sparams=expire%2Cei%2Cip%2Cid%2Caitags%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cgir%2Cclen%2Cdur%2Clmt&sig=AOq0QJ8wRgIhALoOjHidDdDslC9AKspyzdAw-aDAYqbWsrnWBrwTOjL0AiEAp-iymAs05LN5zFZD8huNWQOK56bSYQXwm1-F4I2wcdI%3D&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRQIgGdBmriZCEog9I0dLsqPxraVHY2IjmFMvq0TWsfA2R-kCIQDDBGh_pwlDSlfIRiLjQxOYsomTuvi9C0qX4dgrr3a9-w%3D%3D&ratebypass=yes\",\r\n" + 
//				"            \"format\": \"1280x720 (720p)\",\r\n" + 
//				"            \"format_note\": \"video only, no audio\",\r\n" + 
//				"            \"extension\": \"mp4\",\r\n" + 
//				"            \"video_codec\": \"avc1.4d401f\",\r\n" + 
//				"            \"audio_codec\": \"none\",\r\n" + 
//				"            \"height\": 720,\r\n" + 
//				"            \"width\": 1280,\r\n" + 
//				"            \"fps\": 25,\r\n" + 
//				"            \"fmt_id\": \"136\",\r\n" + 
//				"            \"filesize\": 62479222,\r\n" + 
//				"            \"filesize_pretty\": \"59.58 MB\",\r\n" + 
//				"            \"has_audio\": false,\r\n" + 
//				"            \"has_video\": true,\r\n" + 
//				"            \"is_hd\": false\r\n" + 
//				"        },\r\n" + 
//				"        {\r\n" + 
//				"            \"url\": \"https://r2---sn-4g5e6nle.googlevideo.com/videoplayback?expire=1591025010&ei=EsnUXsP5IJaC1wKisqCoCw&ip=46.165.230.5&id=e1b746b52ea50f43&itag=298&aitags=133%2C134%2C135%2C136%2C137%2C160%2C242%2C243%2C244%2C247%2C248%2C278%2C298%2C299%2C302%2C303%2C394%2C395%2C396%2C397&source=youtube&requiressl=yes&mh=x_&mm=31%2C29&mn=sn-4g5e6nle%2Csn-4g5edn7y&ms=au%2Crdu&mv=m&mvi=1&pl=23&initcwndbps=1443750&vprv=1&mime=video%2Fmp4&gir=yes&clen=34704289&dur=383.080&lmt=1575845182613978&mt=1591003295&fvip=2&keepalive=yes&c=WEB&txp=5535432&sparams=expire%2Cei%2Cip%2Cid%2Caitags%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cgir%2Cclen%2Cdur%2Clmt&sig=AOq0QJ8wRQIgBuevoXHKfkV-lFDAKak8ZZwKA0oQhBK4PLmzk0zlHUwCIQCo5F5Q5J1OejjhSFwJUKDDsv-S2w266dnXmx0NKuRpwg%3D%3D&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRQIgGdBmriZCEog9I0dLsqPxraVHY2IjmFMvq0TWsfA2R-kCIQDDBGh_pwlDSlfIRiLjQxOYsomTuvi9C0qX4dgrr3a9-w%3D%3D&ratebypass=yes\",\r\n" + 
//				"            \"format\": \"1280x720 (720p50)\",\r\n" + 
//				"            \"format_note\": \"video only, no audio\",\r\n" + 
//				"            \"extension\": \"mp4\",\r\n" + 
//				"            \"video_codec\": \"avc1.4d4020\",\r\n" + 
//				"            \"audio_codec\": \"none\",\r\n" + 
//				"            \"height\": 720,\r\n" + 
//				"            \"width\": 1280,\r\n" + 
//				"            \"fps\": 50,\r\n" + 
//				"            \"fmt_id\": \"298\",\r\n" + 
//				"            \"filesize\": 34704289,\r\n" + 
//				"            \"filesize_pretty\": \"33.1 MB\",\r\n" + 
//				"            \"has_audio\": false,\r\n" + 
//				"            \"has_video\": true,\r\n" + 
//				"            \"is_hd\": false\r\n" + 
//				"        },\r\n" + 
//				"        {\r\n" + 
//				"            \"url\": \"https://r2---sn-4g5e6nle.googlevideo.com/videoplayback?expire=1591025010&ei=EsnUXsP5IJaC1wKisqCoCw&ip=46.165.230.5&id=e1b746b52ea50f43&itag=247&aitags=133%2C134%2C135%2C136%2C137%2C160%2C242%2C243%2C244%2C247%2C248%2C278%2C298%2C299%2C302%2C303%2C394%2C395%2C396%2C397&source=youtube&requiressl=yes&mh=x_&mm=31%2C29&mn=sn-4g5e6nle%2Csn-4g5edn7y&ms=au%2Crdu&mv=m&mvi=1&pl=23&initcwndbps=1443750&vprv=1&mime=video%2Fwebm&gir=yes&clen=51781967&dur=383.080&lmt=1575845977647622&mt=1591003295&fvip=2&keepalive=yes&c=WEB&txp=5535432&sparams=expire%2Cei%2Cip%2Cid%2Caitags%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cgir%2Cclen%2Cdur%2Clmt&sig=AOq0QJ8wRQIgOYeNTevK1dEDMtFexJstYGoAVwHmLIf8tXEQIAw2AUECIQC3ZFxgCgPBrvH_Rpj8bS2qqnAg37AsXGezlWYinQqV6Q%3D%3D&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRQIgGdBmriZCEog9I0dLsqPxraVHY2IjmFMvq0TWsfA2R-kCIQDDBGh_pwlDSlfIRiLjQxOYsomTuvi9C0qX4dgrr3a9-w%3D%3D&ratebypass=yes\",\r\n" + 
//				"            \"format\": \"1280x720 (720p)\",\r\n" + 
//				"            \"format_note\": \"video only, no audio\",\r\n" + 
//				"            \"extension\": \"webm\",\r\n" + 
//				"            \"video_codec\": \"vp9\",\r\n" + 
//				"            \"audio_codec\": \"none\",\r\n" + 
//				"            \"height\": 720,\r\n" + 
//				"            \"width\": 1280,\r\n" + 
//				"            \"fps\": 25,\r\n" + 
//				"            \"fmt_id\": \"247\",\r\n" + 
//				"            \"filesize\": 51781967,\r\n" + 
//				"            \"filesize_pretty\": \"49.38 MB\",\r\n" + 
//				"            \"has_audio\": false,\r\n" + 
//				"            \"has_video\": true,\r\n" + 
//				"            \"is_hd\": false\r\n" + 
//				"        },\r\n" + 
//				"        {\r\n" + 
//				"            \"url\": \"https://r2---sn-4g5e6nle.googlevideo.com/videoplayback?expire=1591025010&ei=EsnUXsP5IJaC1wKisqCoCw&ip=46.165.230.5&id=e1b746b52ea50f43&itag=302&aitags=133%2C134%2C135%2C136%2C137%2C160%2C242%2C243%2C244%2C247%2C248%2C278%2C298%2C299%2C302%2C303%2C394%2C395%2C396%2C397&source=youtube&requiressl=yes&mh=x_&mm=31%2C29&mn=sn-4g5e6nle%2Csn-4g5edn7y&ms=au%2Crdu&mv=m&mvi=1&pl=23&initcwndbps=1443750&vprv=1&mime=video%2Fwebm&gir=yes&clen=46416778&dur=383.080&lmt=1575845714430839&mt=1591003295&fvip=2&keepalive=yes&c=WEB&txp=5535432&sparams=expire%2Cei%2Cip%2Cid%2Caitags%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cgir%2Cclen%2Cdur%2Clmt&sig=AOq0QJ8wRQIhANEvtZvfYXU2m0OiB5g0LDc3Q99tvNRqZvNv7eEkpsiFAiBFMqTGFYWtsTLWZhQ_y86IKvBcDYCfumLd1ul3RyNtew%3D%3D&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRQIgGdBmriZCEog9I0dLsqPxraVHY2IjmFMvq0TWsfA2R-kCIQDDBGh_pwlDSlfIRiLjQxOYsomTuvi9C0qX4dgrr3a9-w%3D%3D&ratebypass=yes\",\r\n" + 
//				"            \"format\": \"1280x720 (720p50)\",\r\n" + 
//				"            \"format_note\": \"video only, no audio\",\r\n" + 
//				"            \"extension\": \"webm\",\r\n" + 
//				"            \"video_codec\": \"vp9\",\r\n" + 
//				"            \"audio_codec\": \"none\",\r\n" + 
//				"            \"height\": 720,\r\n" + 
//				"            \"width\": 1280,\r\n" + 
//				"            \"fps\": 50,\r\n" + 
//				"            \"fmt_id\": \"302\",\r\n" + 
//				"            \"filesize\": 46416778,\r\n" + 
//				"            \"filesize_pretty\": \"44.27 MB\",\r\n" + 
//				"            \"has_audio\": false,\r\n" + 
//				"            \"has_video\": true,\r\n" + 
//				"            \"is_hd\": false\r\n" + 
//				"        },\r\n" + 
//				"        {\r\n" + 
//				"            \"url\": \"https://r2---sn-4g5e6nle.googlevideo.com/videoplayback?expire=1591025010&ei=EsnUXsP5IJaC1wKisqCoCw&ip=46.165.230.5&id=e1b746b52ea50f43&itag=397&aitags=133%2C134%2C135%2C136%2C137%2C160%2C242%2C243%2C244%2C247%2C248%2C278%2C298%2C299%2C302%2C303%2C394%2C395%2C396%2C397&source=youtube&requiressl=yes&mh=x_&mm=31%2C29&mn=sn-4g5e6nle%2Csn-4g5edn7y&ms=au%2Crdu&mv=m&mvi=1&pl=23&initcwndbps=1443750&vprv=1&mime=video%2Fmp4&gir=yes&clen=21407978&dur=383.080&lmt=1575849997659621&mt=1591003295&fvip=2&keepalive=yes&c=WEB&txp=5531432&sparams=expire%2Cei%2Cip%2Cid%2Caitags%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cgir%2Cclen%2Cdur%2Clmt&sig=AOq0QJ8wRQIgPQvLcUsldeNUhV-LTh4Qq7Hb8ama3MH8830BU0pAlk4CIQDsIOflAuPc37l8b2rPUFKclJtnGGitgADyMxiW9gCquA%3D%3D&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRQIgGdBmriZCEog9I0dLsqPxraVHY2IjmFMvq0TWsfA2R-kCIQDDBGh_pwlDSlfIRiLjQxOYsomTuvi9C0qX4dgrr3a9-w%3D%3D&ratebypass=yes\",\r\n" + 
//				"            \"format\": \"854x480 (480p)\",\r\n" + 
//				"            \"format_note\": \"video only, no audio\",\r\n" + 
//				"            \"extension\": \"mp4\",\r\n" + 
//				"            \"video_codec\": \"av01.0.04M.08\",\r\n" + 
//				"            \"audio_codec\": \"none\",\r\n" + 
//				"            \"height\": 480,\r\n" + 
//				"            \"width\": 854,\r\n" + 
//				"            \"fps\": 25,\r\n" + 
//				"            \"fmt_id\": \"397\",\r\n" + 
//				"            \"filesize\": 21407978,\r\n" + 
//				"            \"filesize_pretty\": \"20.42 MB\",\r\n" + 
//				"            \"has_audio\": false,\r\n" + 
//				"            \"has_video\": true,\r\n" + 
//				"            \"is_hd\": false\r\n" + 
//				"        },\r\n" + 
//				"        {\r\n" + 
//				"            \"url\": \"https://r2---sn-4g5e6nle.googlevideo.com/videoplayback?expire=1591025010&ei=EsnUXsP5IJaC1wKisqCoCw&ip=46.165.230.5&id=e1b746b52ea50f43&itag=135&aitags=133%2C134%2C135%2C136%2C137%2C160%2C242%2C243%2C244%2C247%2C248%2C278%2C298%2C299%2C302%2C303%2C394%2C395%2C396%2C397&source=youtube&requiressl=yes&mh=x_&mm=31%2C29&mn=sn-4g5e6nle%2Csn-4g5edn7y&ms=au%2Crdu&mv=m&mvi=1&pl=23&initcwndbps=1443750&vprv=1&mime=video%2Fmp4&gir=yes&clen=20603310&dur=383.080&lmt=1575845347051220&mt=1591003295&fvip=2&keepalive=yes&c=WEB&txp=5535432&sparams=expire%2Cei%2Cip%2Cid%2Caitags%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cgir%2Cclen%2Cdur%2Clmt&sig=AOq0QJ8wRQIgRvi0AklddCWEV58VGrNFKRa8GlSTD-8FuMzpWnA6ASwCIQCm08xeiflX1lSKfrOfT6Frm8pcjBeVfDpICFvAPWTCdQ%3D%3D&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRQIgGdBmriZCEog9I0dLsqPxraVHY2IjmFMvq0TWsfA2R-kCIQDDBGh_pwlDSlfIRiLjQxOYsomTuvi9C0qX4dgrr3a9-w%3D%3D&ratebypass=yes\",\r\n" + 
//				"            \"format\": \"854x480 (480p)\",\r\n" + 
//				"            \"format_note\": \"video only, no audio\",\r\n" + 
//				"            \"extension\": \"mp4\",\r\n" + 
//				"            \"video_codec\": \"avc1.4d401e\",\r\n" + 
//				"            \"audio_codec\": \"none\",\r\n" + 
//				"            \"height\": 480,\r\n" + 
//				"            \"width\": 854,\r\n" + 
//				"            \"fps\": 25,\r\n" + 
//				"            \"fmt_id\": \"135\",\r\n" + 
//				"            \"filesize\": 20603310,\r\n" + 
//				"            \"filesize_pretty\": \"19.65 MB\",\r\n" + 
//				"            \"has_audio\": false,\r\n" + 
//				"            \"has_video\": true,\r\n" + 
//				"            \"is_hd\": false\r\n" + 
//				"        },\r\n" + 
//				"        {\r\n" + 
//				"            \"url\": \"https://r2---sn-4g5e6nle.googlevideo.com/videoplayback?expire=1591025010&ei=EsnUXsP5IJaC1wKisqCoCw&ip=46.165.230.5&id=e1b746b52ea50f43&itag=244&aitags=133%2C134%2C135%2C136%2C137%2C160%2C242%2C243%2C244%2C247%2C248%2C278%2C298%2C299%2C302%2C303%2C394%2C395%2C396%2C397&source=youtube&requiressl=yes&mh=x_&mm=31%2C29&mn=sn-4g5e6nle%2Csn-4g5edn7y&ms=au%2Crdu&mv=m&mvi=1&pl=23&initcwndbps=1443750&vprv=1&mime=video%2Fwebm&gir=yes&clen=20066728&dur=383.080&lmt=1575845977651279&mt=1591003295&fvip=2&keepalive=yes&c=WEB&txp=5535432&sparams=expire%2Cei%2Cip%2Cid%2Caitags%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cgir%2Cclen%2Cdur%2Clmt&sig=AOq0QJ8wRQIhALmVm8rZ8o0d3wDLAvEMt0cBQJxFF2VfDStG5r70infyAiBxUuWK6yXsBow06A4uNu-v9-Psh5AxpRrduWdftbcqzg%3D%3D&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRQIgGdBmriZCEog9I0dLsqPxraVHY2IjmFMvq0TWsfA2R-kCIQDDBGh_pwlDSlfIRiLjQxOYsomTuvi9C0qX4dgrr3a9-w%3D%3D&ratebypass=yes\",\r\n" + 
//				"            \"format\": \"854x480 (480p)\",\r\n" + 
//				"            \"format_note\": \"video only, no audio\",\r\n" + 
//				"            \"extension\": \"webm\",\r\n" + 
//				"            \"video_codec\": \"vp9\",\r\n" + 
//				"            \"audio_codec\": \"none\",\r\n" + 
//				"            \"height\": 480,\r\n" + 
//				"            \"width\": 854,\r\n" + 
//				"            \"fps\": 25,\r\n" + 
//				"            \"fmt_id\": \"244\",\r\n" + 
//				"            \"filesize\": 20066728,\r\n" + 
//				"            \"filesize_pretty\": \"19.14 MB\",\r\n" + 
//				"            \"has_audio\": false,\r\n" + 
//				"            \"has_video\": true,\r\n" + 
//				"            \"is_hd\": false\r\n" + 
//				"        },\r\n" + 
//				"        {\r\n" + 
//				"            \"url\": \"https://r2---sn-4g5e6nle.googlevideo.com/videoplayback?expire=1591025010&ei=EsnUXsP5IJaC1wKisqCoCw&ip=46.165.230.5&id=e1b746b52ea50f43&itag=134&aitags=133%2C134%2C135%2C136%2C137%2C160%2C242%2C243%2C244%2C247%2C248%2C278%2C298%2C299%2C302%2C303%2C394%2C395%2C396%2C397&source=youtube&requiressl=yes&mh=x_&mm=31%2C29&mn=sn-4g5e6nle%2Csn-4g5edn7y&ms=au%2Crdu&mv=m&mvi=1&pl=23&initcwndbps=1443750&vprv=1&mime=video%2Fmp4&gir=yes&clen=14074188&dur=383.080&lmt=1575845347051815&mt=1591003295&fvip=2&keepalive=yes&c=WEB&txp=5535432&sparams=expire%2Cei%2Cip%2Cid%2Caitags%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cgir%2Cclen%2Cdur%2Clmt&sig=AOq0QJ8wRAIgQT17cD2Uop265cNz_Ji7r8XQF1zGiIX31rkHErwxGTwCIDrPEtAV35dbs3NCKB_CRu9lFsq2DReqyMBpg3JDsWWN&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRQIgGdBmriZCEog9I0dLsqPxraVHY2IjmFMvq0TWsfA2R-kCIQDDBGh_pwlDSlfIRiLjQxOYsomTuvi9C0qX4dgrr3a9-w%3D%3D&ratebypass=yes\",\r\n" + 
//				"            \"format\": \"640x360 (360p)\",\r\n" + 
//				"            \"format_note\": \"video only, no audio\",\r\n" + 
//				"            \"extension\": \"mp4\",\r\n" + 
//				"            \"video_codec\": \"avc1.4d401e\",\r\n" + 
//				"            \"audio_codec\": \"none\",\r\n" + 
//				"            \"height\": 360,\r\n" + 
//				"            \"width\": 640,\r\n" + 
//				"            \"fps\": 25,\r\n" + 
//				"            \"fmt_id\": \"134\",\r\n" + 
//				"            \"filesize\": 14074188,\r\n" + 
//				"            \"filesize_pretty\": \"13.42 MB\",\r\n" + 
//				"            \"has_audio\": false,\r\n" + 
//				"            \"has_video\": true,\r\n" + 
//				"            \"is_hd\": false\r\n" + 
//				"        },\r\n" + 
//				"        {\r\n" + 
//				"            \"url\": \"https://r2---sn-4g5e6nle.googlevideo.com/videoplayback?expire=1591025010&ei=EsnUXsP5IJaC1wKisqCoCw&ip=46.165.230.5&id=e1b746b52ea50f43&itag=396&aitags=133%2C134%2C135%2C136%2C137%2C160%2C242%2C243%2C244%2C247%2C248%2C278%2C298%2C299%2C302%2C303%2C394%2C395%2C396%2C397&source=youtube&requiressl=yes&mh=x_&mm=31%2C29&mn=sn-4g5e6nle%2Csn-4g5edn7y&ms=au%2Crdu&mv=m&mvi=1&pl=23&initcwndbps=1443750&vprv=1&mime=video%2Fmp4&gir=yes&clen=12340541&dur=383.080&lmt=1575849748295453&mt=1591003295&fvip=2&keepalive=yes&c=WEB&txp=5531432&sparams=expire%2Cei%2Cip%2Cid%2Caitags%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cgir%2Cclen%2Cdur%2Clmt&sig=AOq0QJ8wRQIhALLMXTQHDDkWdFno0LRjrEoAUERT3u_cmTScgR4XWawQAiBQdhnSbs1uPbrsmRCYbJ6NR8LgYcBBDFmyXSm_4cUZ0Q%3D%3D&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRQIgGdBmriZCEog9I0dLsqPxraVHY2IjmFMvq0TWsfA2R-kCIQDDBGh_pwlDSlfIRiLjQxOYsomTuvi9C0qX4dgrr3a9-w%3D%3D&ratebypass=yes\",\r\n" + 
//				"            \"format\": \"640x360 (360p)\",\r\n" + 
//				"            \"format_note\": \"video only, no audio\",\r\n" + 
//				"            \"extension\": \"mp4\",\r\n" + 
//				"            \"video_codec\": \"av01.0.01M.08\",\r\n" + 
//				"            \"audio_codec\": \"none\",\r\n" + 
//				"            \"height\": 360,\r\n" + 
//				"            \"width\": 640,\r\n" + 
//				"            \"fps\": 25,\r\n" + 
//				"            \"fmt_id\": \"396\",\r\n" + 
//				"            \"filesize\": 12340541,\r\n" + 
//				"            \"filesize_pretty\": \"11.77 MB\",\r\n" + 
//				"            \"has_audio\": false,\r\n" + 
//				"            \"has_video\": true,\r\n" + 
//				"            \"is_hd\": false\r\n" + 
//				"        },\r\n" + 
//				"        {\r\n" + 
//				"            \"url\": \"https://r2---sn-4g5e6nle.googlevideo.com/videoplayback?expire=1591025010&ei=EsnUXsP5IJaC1wKisqCoCw&ip=46.165.230.5&id=e1b746b52ea50f43&itag=243&aitags=133%2C134%2C135%2C136%2C137%2C160%2C242%2C243%2C244%2C247%2C248%2C278%2C298%2C299%2C302%2C303%2C394%2C395%2C396%2C397&source=youtube&requiressl=yes&mh=x_&mm=31%2C29&mn=sn-4g5e6nle%2Csn-4g5edn7y&ms=au%2Crdu&mv=m&mvi=1&pl=23&initcwndbps=1443750&vprv=1&mime=video%2Fwebm&gir=yes&clen=13269030&dur=383.080&lmt=1575845977873369&mt=1591003295&fvip=2&keepalive=yes&c=WEB&txp=5535432&sparams=expire%2Cei%2Cip%2Cid%2Caitags%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cgir%2Cclen%2Cdur%2Clmt&sig=AOq0QJ8wRgIhANheq4oBRa7xcG5Tn0GeHMjjBzLsF6LnYr5EhFHjBMvFAiEAo6eO9j4sjGVlDySo51OWmNWgL5ezbLq_dnw4ywTTPUA%3D&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRQIgGdBmriZCEog9I0dLsqPxraVHY2IjmFMvq0TWsfA2R-kCIQDDBGh_pwlDSlfIRiLjQxOYsomTuvi9C0qX4dgrr3a9-w%3D%3D&ratebypass=yes\",\r\n" + 
//				"            \"format\": \"640x360 (360p)\",\r\n" + 
//				"            \"format_note\": \"video only, no audio\",\r\n" + 
//				"            \"extension\": \"webm\",\r\n" + 
//				"            \"video_codec\": \"vp9\",\r\n" + 
//				"            \"audio_codec\": \"none\",\r\n" + 
//				"            \"height\": 360,\r\n" + 
//				"            \"width\": 640,\r\n" + 
//				"            \"fps\": 25,\r\n" + 
//				"            \"fmt_id\": \"243\",\r\n" + 
//				"            \"filesize\": 13269030,\r\n" + 
//				"            \"filesize_pretty\": \"12.65 MB\",\r\n" + 
//				"            \"has_audio\": false,\r\n" + 
//				"            \"has_video\": true,\r\n" + 
//				"            \"is_hd\": false\r\n" + 
//				"        },\r\n" + 
//				"        {\r\n" + 
//				"            \"url\": \"https://r2---sn-4g5e6nle.googlevideo.com/videoplayback?expire=1591025010&ei=EsnUXsP5IJaC1wKisqCoCw&ip=46.165.230.5&id=e1b746b52ea50f43&itag=133&aitags=133%2C134%2C135%2C136%2C137%2C160%2C242%2C243%2C244%2C247%2C248%2C278%2C298%2C299%2C302%2C303%2C394%2C395%2C396%2C397&source=youtube&requiressl=yes&mh=x_&mm=31%2C29&mn=sn-4g5e6nle%2Csn-4g5edn7y&ms=au%2Crdu&mv=m&mvi=1&pl=23&initcwndbps=1443750&vprv=1&mime=video%2Fmp4&gir=yes&clen=7085462&dur=383.080&lmt=1575845347054437&mt=1591003295&fvip=2&keepalive=yes&c=WEB&txp=5535432&sparams=expire%2Cei%2Cip%2Cid%2Caitags%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cgir%2Cclen%2Cdur%2Clmt&sig=AOq0QJ8wRAIgYYSnXtQYRcNF_jMhuKaFD99ZtIRwh2336XtduSQW-icCICAtbG8frhfXjlizQOfqJ3pgBqSM2oBySo6XciZwtL9V&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRQIgGdBmriZCEog9I0dLsqPxraVHY2IjmFMvq0TWsfA2R-kCIQDDBGh_pwlDSlfIRiLjQxOYsomTuvi9C0qX4dgrr3a9-w%3D%3D&ratebypass=yes\",\r\n" + 
//				"            \"format\": \"426x240 (240p)\",\r\n" + 
//				"            \"format_note\": \"video only, no audio\",\r\n" + 
//				"            \"extension\": \"mp4\",\r\n" + 
//				"            \"video_codec\": \"avc1.4d4015\",\r\n" + 
//				"            \"audio_codec\": \"none\",\r\n" + 
//				"            \"height\": 240,\r\n" + 
//				"            \"width\": 426,\r\n" + 
//				"            \"fps\": 25,\r\n" + 
//				"            \"fmt_id\": \"133\",\r\n" + 
//				"            \"filesize\": 7085462,\r\n" + 
//				"            \"filesize_pretty\": \"6.76 MB\",\r\n" + 
//				"            \"has_audio\": false,\r\n" + 
//				"            \"has_video\": true,\r\n" + 
//				"            \"is_hd\": false\r\n" + 
//				"        },\r\n" + 
//				"        {\r\n" + 
//				"            \"url\": \"https://r2---sn-4g5e6nle.googlevideo.com/videoplayback?expire=1591025010&ei=EsnUXsP5IJaC1wKisqCoCw&ip=46.165.230.5&id=e1b746b52ea50f43&itag=395&aitags=133%2C134%2C135%2C136%2C137%2C160%2C242%2C243%2C244%2C247%2C248%2C278%2C298%2C299%2C302%2C303%2C394%2C395%2C396%2C397&source=youtube&requiressl=yes&mh=x_&mm=31%2C29&mn=sn-4g5e6nle%2Csn-4g5edn7y&ms=au%2Crdu&mv=m&mvi=1&pl=23&initcwndbps=1443750&vprv=1&mime=video%2Fmp4&gir=yes&clen=7040825&dur=383.080&lmt=1575849656711380&mt=1591003295&fvip=2&keepalive=yes&c=WEB&txp=5531432&sparams=expire%2Cei%2Cip%2Cid%2Caitags%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cgir%2Cclen%2Cdur%2Clmt&sig=AOq0QJ8wRAIgCKIObq0YQ5OdN9p2XBQgrsFs5EBZIb9q6czVpU6TbGsCIHe-b4xHZTfr9BudWmoB-z7Jl8nK9a_WnLDAzlra2Hu5&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRQIgGdBmriZCEog9I0dLsqPxraVHY2IjmFMvq0TWsfA2R-kCIQDDBGh_pwlDSlfIRiLjQxOYsomTuvi9C0qX4dgrr3a9-w%3D%3D&ratebypass=yes\",\r\n" + 
//				"            \"format\": \"426x240 (240p)\",\r\n" + 
//				"            \"format_note\": \"video only, no audio\",\r\n" + 
//				"            \"extension\": \"mp4\",\r\n" + 
//				"            \"video_codec\": \"av01.0.00M.08\",\r\n" + 
//				"            \"audio_codec\": \"none\",\r\n" + 
//				"            \"height\": 240,\r\n" + 
//				"            \"width\": 426,\r\n" + 
//				"            \"fps\": 25,\r\n" + 
//				"            \"fmt_id\": \"395\",\r\n" + 
//				"            \"filesize\": 7040825,\r\n" + 
//				"            \"filesize_pretty\": \"6.71 MB\",\r\n" + 
//				"            \"has_audio\": false,\r\n" + 
//				"            \"has_video\": true,\r\n" + 
//				"            \"is_hd\": false\r\n" + 
//				"        },\r\n" + 
//				"        {\r\n" + 
//				"            \"url\": \"https://r2---sn-4g5e6nle.googlevideo.com/videoplayback?expire=1591025010&ei=EsnUXsP5IJaC1wKisqCoCw&ip=46.165.230.5&id=e1b746b52ea50f43&itag=242&aitags=133%2C134%2C135%2C136%2C137%2C160%2C242%2C243%2C244%2C247%2C248%2C278%2C298%2C299%2C302%2C303%2C394%2C395%2C396%2C397&source=youtube&requiressl=yes&mh=x_&mm=31%2C29&mn=sn-4g5e6nle%2Csn-4g5edn7y&ms=au%2Crdu&mv=m&mvi=1&pl=23&initcwndbps=1443750&vprv=1&mime=video%2Fwebm&gir=yes&clen=7773824&dur=383.080&lmt=1575845977653694&mt=1591003295&fvip=2&keepalive=yes&c=WEB&txp=5535432&sparams=expire%2Cei%2Cip%2Cid%2Caitags%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cgir%2Cclen%2Cdur%2Clmt&sig=AOq0QJ8wRQIhAPqW3hSeBWoUg-RWQAoZ2vNZBMPEZQ-jcz_9axMTMnCjAiB5RbYSIa1wKOXndLI--OoezMN_fBEypil3zLSqYMtZSw%3D%3D&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRQIgGdBmriZCEog9I0dLsqPxraVHY2IjmFMvq0TWsfA2R-kCIQDDBGh_pwlDSlfIRiLjQxOYsomTuvi9C0qX4dgrr3a9-w%3D%3D&ratebypass=yes\",\r\n" + 
//				"            \"format\": \"426x240 (240p)\",\r\n" + 
//				"            \"format_note\": \"video only, no audio\",\r\n" + 
//				"            \"extension\": \"webm\",\r\n" + 
//				"            \"video_codec\": \"vp9\",\r\n" + 
//				"            \"audio_codec\": \"none\",\r\n" + 
//				"            \"height\": 240,\r\n" + 
//				"            \"width\": 426,\r\n" + 
//				"            \"fps\": 25,\r\n" + 
//				"            \"fmt_id\": \"242\",\r\n" + 
//				"            \"filesize\": 7773824,\r\n" + 
//				"            \"filesize_pretty\": \"7.41 MB\",\r\n" + 
//				"            \"has_audio\": false,\r\n" + 
//				"            \"has_video\": true,\r\n" + 
//				"            \"is_hd\": false\r\n" + 
//				"        },\r\n" + 
//				"        {\r\n" + 
//				"            \"url\": \"https://r2---sn-4g5e6nle.googlevideo.com/videoplayback?expire=1591025010&ei=EsnUXsP5IJaC1wKisqCoCw&ip=46.165.230.5&id=e1b746b52ea50f43&itag=160&aitags=133%2C134%2C135%2C136%2C137%2C160%2C242%2C243%2C244%2C247%2C248%2C278%2C298%2C299%2C302%2C303%2C394%2C395%2C396%2C397&source=youtube&requiressl=yes&mh=x_&mm=31%2C29&mn=sn-4g5e6nle%2Csn-4g5edn7y&ms=au%2Crdu&mv=m&mvi=1&pl=23&initcwndbps=1443750&vprv=1&mime=video%2Fmp4&gir=yes&clen=3794780&dur=383.080&lmt=1575845347052734&mt=1591003295&fvip=2&keepalive=yes&c=WEB&txp=5535432&sparams=expire%2Cei%2Cip%2Cid%2Caitags%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cgir%2Cclen%2Cdur%2Clmt&sig=AOq0QJ8wRAIgM15DUQEcm5Lp1sH_mKXom2I3hzt5pjFBvGQuy_pQq-4CIE3UoCcs4iMLee1QlTAEuKdQJ58kKY6ngiyl2062iRIM&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRQIgGdBmriZCEog9I0dLsqPxraVHY2IjmFMvq0TWsfA2R-kCIQDDBGh_pwlDSlfIRiLjQxOYsomTuvi9C0qX4dgrr3a9-w%3D%3D&ratebypass=yes\",\r\n" + 
//				"            \"format\": \"256x144 (144p)\",\r\n" + 
//				"            \"format_note\": \"video only, no audio\",\r\n" + 
//				"            \"extension\": \"mp4\",\r\n" + 
//				"            \"video_codec\": \"avc1.4d400c\",\r\n" + 
//				"            \"audio_codec\": \"none\",\r\n" + 
//				"            \"height\": 144,\r\n" + 
//				"            \"width\": 256,\r\n" + 
//				"            \"fps\": 25,\r\n" + 
//				"            \"fmt_id\": \"160\",\r\n" + 
//				"            \"filesize\": 3794780,\r\n" + 
//				"            \"filesize_pretty\": \"3.62 MB\",\r\n" + 
//				"            \"has_audio\": false,\r\n" + 
//				"            \"has_video\": true,\r\n" + 
//				"            \"is_hd\": false\r\n" + 
//				"        },\r\n" + 
//				"        {\r\n" + 
//				"            \"url\": \"https://r2---sn-4g5e6nle.googlevideo.com/videoplayback?expire=1591025010&ei=EsnUXsP5IJaC1wKisqCoCw&ip=46.165.230.5&id=e1b746b52ea50f43&itag=394&aitags=133%2C134%2C135%2C136%2C137%2C160%2C242%2C243%2C244%2C247%2C248%2C278%2C298%2C299%2C302%2C303%2C394%2C395%2C396%2C397&source=youtube&requiressl=yes&mh=x_&mm=31%2C29&mn=sn-4g5e6nle%2Csn-4g5edn7y&ms=au%2Crdu&mv=m&mvi=1&pl=23&initcwndbps=1443750&vprv=1&mime=video%2Fmp4&gir=yes&clen=3472268&dur=383.080&lmt=1575849541162211&mt=1591003295&fvip=2&keepalive=yes&c=WEB&txp=5531432&sparams=expire%2Cei%2Cip%2Cid%2Caitags%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cgir%2Cclen%2Cdur%2Clmt&sig=AOq0QJ8wRQIhAJTJYcLsm98ehgCWMmOcoVDVluT8muP22YMN0IoPOULnAiB5TzWoDWLMk2KSINCB3tjZ7xOlIpGzGu3FNlevGb_9Zw%3D%3D&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRQIgGdBmriZCEog9I0dLsqPxraVHY2IjmFMvq0TWsfA2R-kCIQDDBGh_pwlDSlfIRiLjQxOYsomTuvi9C0qX4dgrr3a9-w%3D%3D&ratebypass=yes\",\r\n" + 
//				"            \"format\": \"256x144 (144p)\",\r\n" + 
//				"            \"format_note\": \"video only, no audio\",\r\n" + 
//				"            \"extension\": \"mp4\",\r\n" + 
//				"            \"video_codec\": \"av01.0.00M.08\",\r\n" + 
//				"            \"audio_codec\": \"none\",\r\n" + 
//				"            \"height\": 144,\r\n" + 
//				"            \"width\": 256,\r\n" + 
//				"            \"fps\": 25,\r\n" + 
//				"            \"fmt_id\": \"394\",\r\n" + 
//				"            \"filesize\": 3472268,\r\n" + 
//				"            \"filesize_pretty\": \"3.31 MB\",\r\n" + 
//				"            \"has_audio\": false,\r\n" + 
//				"            \"has_video\": true,\r\n" + 
//				"            \"is_hd\": false\r\n" + 
//				"        },\r\n" + 
//				"        {\r\n" + 
//				"            \"url\": \"https://r2---sn-4g5e6nle.googlevideo.com/videoplayback?expire=1591025010&ei=EsnUXsP5IJaC1wKisqCoCw&ip=46.165.230.5&id=e1b746b52ea50f43&itag=278&aitags=133%2C134%2C135%2C136%2C137%2C160%2C242%2C243%2C244%2C247%2C248%2C278%2C298%2C299%2C302%2C303%2C394%2C395%2C396%2C397&source=youtube&requiressl=yes&mh=x_&mm=31%2C29&mn=sn-4g5e6nle%2Csn-4g5edn7y&ms=au%2Crdu&mv=m&mvi=1&pl=23&initcwndbps=1443750&vprv=1&mime=video%2Fwebm&gir=yes&clen=4286725&dur=383.080&lmt=1575845977659209&mt=1591003295&fvip=2&keepalive=yes&c=WEB&txp=5535432&sparams=expire%2Cei%2Cip%2Cid%2Caitags%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cgir%2Cclen%2Cdur%2Clmt&sig=AOq0QJ8wRQIhALvy9FTceMrlV6gQYQVPr7C_LvaWwdKDnLHE2t-6mNVEAiBGrvJmoSY0PYfHbyN9V4BHkAYPqRo65FKwZ0ozCl55Dg%3D%3D&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRQIgGdBmriZCEog9I0dLsqPxraVHY2IjmFMvq0TWsfA2R-kCIQDDBGh_pwlDSlfIRiLjQxOYsomTuvi9C0qX4dgrr3a9-w%3D%3D&ratebypass=yes\",\r\n" + 
//				"            \"format\": \"256x144 (144p)\",\r\n" + 
//				"            \"format_note\": \"video only, no audio\",\r\n" + 
//				"            \"extension\": \"webm\",\r\n" + 
//				"            \"video_codec\": \"vp9\",\r\n" + 
//				"            \"audio_codec\": \"none\",\r\n" + 
//				"            \"height\": 144,\r\n" + 
//				"            \"width\": 256,\r\n" + 
//				"            \"fps\": 25,\r\n" + 
//				"            \"fmt_id\": \"278\",\r\n" + 
//				"            \"filesize\": 4286725,\r\n" + 
//				"            \"filesize_pretty\": \"4.09 MB\",\r\n" + 
//				"            \"has_audio\": false,\r\n" + 
//				"            \"has_video\": true,\r\n" + 
//				"            \"is_hd\": false\r\n" + 
//				"        },\r\n" + 
//				"        {\r\n" + 
//				"            \"url\": \"https://r2---sn-4g5e6nle.googlevideo.com/videoplayback?expire=1591025010&ei=EsnUXsP5IJaC1wKisqCoCw&ip=46.165.230.5&id=e1b746b52ea50f43&itag=140&source=youtube&requiressl=yes&mh=x_&mm=31%2C29&mn=sn-4g5e6nle%2Csn-4g5edn7y&ms=au%2Crdu&mv=m&mvi=1&pl=23&initcwndbps=1443750&vprv=1&mime=audio%2Fmp4&gir=yes&clen=6201256&dur=383.129&lmt=1575843987200258&mt=1591003295&fvip=2&keepalive=yes&c=WEB&txp=5531432&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cgir%2Cclen%2Cdur%2Clmt&sig=AOq0QJ8wRQIgda7xEpKSmexxWtCZdB9IUfdQ68SJpYLM6xIPp3aTohMCIQD08Ul08AzWludTTLT_JU9U31p8-nfwzi2GNk4OIXk6kQ%3D%3D&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRQIgGdBmriZCEog9I0dLsqPxraVHY2IjmFMvq0TWsfA2R-kCIQDDBGh_pwlDSlfIRiLjQxOYsomTuvi9C0qX4dgrr3a9-w%3D%3D&ratebypass=yes\",\r\n" + 
//				"            \"format\": \"audio only (tiny)\",\r\n" + 
//				"            \"format_note\": \"audio only, no video\",\r\n" + 
//				"            \"extension\": \"m4a\",\r\n" + 
//				"            \"video_codec\": \"none\",\r\n" + 
//				"            \"audio_codec\": \"mp4a.40.2\",\r\n" + 
//				"            \"height\": null,\r\n" + 
//				"            \"width\": null,\r\n" + 
//				"            \"fps\": null,\r\n" + 
//				"            \"fmt_id\": \"140\",\r\n" + 
//				"            \"filesize\": 6201256,\r\n" + 
//				"            \"filesize_pretty\": \"5.91 MB\",\r\n" + 
//				"            \"has_audio\": true,\r\n" + 
//				"            \"has_video\": false,\r\n" + 
//				"            \"is_hd\": false\r\n" + 
//				"        }\r\n" + 
//				"    ]\r\n" + 
//				"}");
       
		System.out.println(js.get("message"));
		
        video.setTitle(js.getString("title"));
        video.setDuration(js.getString("duration"));
        video.setThumbnail(js.getString("thumbnail"));
        video.setStatus(js.getBoolean("status"));
        video.setVideoStreams(fillVideoStreamsList(js.getJSONArray("streams")));
        
		System.out.println(video.getTitle());
		
		

		return video;
}
	
	public List<VideoStreams> fillVideoStreamsList(JSONArray jsa){
		List<VideoStreams> streamList = new ArrayList<>();
		
		Iterator<Object> it=jsa.iterator();
		while(it.hasNext()) {
		JSONObject jso	=(JSONObject) it.next();
		if(!jso.getString("format_note").equals("video only, no audio"))
		streamList.add(new VideoStreams(jso.getString("url"),jso.getString("format_note"),jso.getString("extension"),jso.getString("filesize_pretty")));	
		}
		
		return streamList;
	}
}