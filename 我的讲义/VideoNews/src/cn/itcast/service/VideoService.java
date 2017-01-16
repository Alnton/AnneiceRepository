package cn.itcast.service;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

import android.util.Xml;

import cn.itcast.domain.Video;
import cn.itcast.utils.StreamTool;

public class VideoService {
	/**
	 * 从服务器获取最新的视频资讯
	 * @return
	 * @throws Throwable
	 */
	public static List<Video> getLastJSONVideos() throws Throwable{
		ArrayList<Video> videos = new ArrayList<Video>();
		String path = "http://192.168.1.10:8080/videoweb/video/list.do?format=json";
		URL url = new URL(path);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setConnectTimeout(5*1000);
		conn.setRequestMethod("GET");
		InputStream inStream = conn.getInputStream();	
		byte[] data = StreamTool.readInputStream(inStream);
		String json = new String(data);
		JSONArray array = new JSONArray(json);
		for(int i = 0 ; i < array.length() ; i++){
			JSONObject item = array.getJSONObject(i);
			Video video = new Video(item.getInt("id"), item.getString("title"), item.getInt("timelength"));
			videos.add(video);
		}
		return videos;
	}
	/**
	 * 从服务器获取最新的视频资讯
	 * @return
	 * @throws Throwable
	 */
	public static List<Video> getLastVideos() throws Throwable{
		String path = "http://192.168.1.10:8080/videoweb/video/list.do";
		URL url = new URL(path);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setConnectTimeout(5*1000);
		conn.setRequestMethod("GET");
		InputStream inStream = conn.getInputStream();		
		return parseXML(inStream);
	}

	private static List<Video> parseXML(InputStream inStream) throws Exception{
		Video video = null;
		List<Video> videos = null;
		XmlPullParser pullParser = Xml.newPullParser();
		pullParser.setInput(inStream, "UTF-8");
		int event = pullParser.getEventType();//触发第一个事件
		while(event!=XmlPullParser.END_DOCUMENT){
			switch (event) {
			case XmlPullParser.START_DOCUMENT:
				videos = new ArrayList<Video>();
				break;
			case XmlPullParser.START_TAG:
				if("video".equals(pullParser.getName())){
					int id = new Integer(pullParser.getAttributeValue(0));
					video = new Video();
					video.setId(id);
				}
				if(video!=null){
					if("title".equals(pullParser.getName())){
						video.setTitle(pullParser.nextText());
					}
					if("timelength".equals(pullParser.getName())){
						video.setTimelength(new Integer(pullParser.nextText()));
					}
				}
				break;
				
			case XmlPullParser.END_TAG:
				if("video".equals(pullParser.getName())){
					videos.add(video);
					video = null;
				}
				break;
			}
			event = pullParser.next();
		}
		return videos;
	}
}
