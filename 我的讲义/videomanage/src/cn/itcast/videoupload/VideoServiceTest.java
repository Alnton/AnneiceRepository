package cn.itcast.videoupload;

import cn.itcast.service.VideoService;
import android.test.AndroidTestCase;

public class VideoServiceTest extends AndroidTestCase {

	public void testSave() throws Throwable{
		VideoService.save("liming", "80");
	}
}
