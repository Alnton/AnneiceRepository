package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.Video;

public interface VideoService {

	/**
	 * 获取最新的视频资讯
	 * @return
	 */
	public List<Video> getLastVides();

}