package cn.itcast.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.itcast.domain.Video;
import cn.itcast.service.VideoService;

public class VideoServiceBean implements VideoService {
	/**
	 * 获取最新的视频资讯
	 * @return
	 */
	public List<Video> getLastVides(){
		List<Video> videos = new ArrayList<Video>();
		videos.add(new Video(89, "喜羊羊与灰太狼全集", 67));
		videos.add(new Video(12, "实拍舰载直升东海救援演习", 23));
		videos.add(new Video(19, "喀麦隆VS荷兰", 90));
		return videos;
	}
}
