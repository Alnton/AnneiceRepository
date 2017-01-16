package cn.itcast.videonews;

import java.util.List;

import cn.itcast.domain.Video;
import cn.itcast.service.VideoService;
import android.test.AndroidTestCase;
import android.util.Log;

public class VideoServiceTest extends AndroidTestCase {
	private static final String TAG = "VideoServiceTest";
	
	public void testGetLastVideos() throws Throwable{
		List<Video> videos = VideoService.getLastVideos();
		for(Video video : videos){
			Log.i(TAG, video.toString());
		}
	}
}
