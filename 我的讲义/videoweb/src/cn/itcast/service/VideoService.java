package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.Video;

public interface VideoService {

	/**
	 * ��ȡ���µ���Ƶ��Ѷ
	 * @return
	 */
	public List<Video> getLastVides();

}