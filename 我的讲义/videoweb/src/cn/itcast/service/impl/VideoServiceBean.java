package cn.itcast.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.itcast.domain.Video;
import cn.itcast.service.VideoService;

public class VideoServiceBean implements VideoService {
	/**
	 * ��ȡ���µ���Ƶ��Ѷ
	 * @return
	 */
	public List<Video> getLastVides(){
		List<Video> videos = new ArrayList<Video>();
		videos.add(new Video(89, "ϲ�������̫��ȫ��", 67));
		videos.add(new Video(12, "ʵ�Ľ���ֱ��������Ԯ��ϰ", 23));
		videos.add(new Video(19, "����¡VS����", 90));
		return videos;
	}
}
