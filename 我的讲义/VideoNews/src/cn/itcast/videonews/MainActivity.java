package cn.itcast.videonews;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.itcast.domain.Video;
import cn.itcast.service.VideoService;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        try {
			List<Video> videos = VideoService.getLastJSONVideos();//获取最新视频资讯
			ListView listView = (ListView)this.findViewById(R.id.listView);
			List<HashMap<String, Object>> data = new ArrayList<HashMap<String,Object>>();
			for(Video video : videos){
				HashMap<String, Object> item = new HashMap<String, Object>();
				item.put("title", video.getTitle());
				item.put("timelength", "时长:"+video.getTimelength());
				item.put("id", video.getId());
				data.add(item);
			}
			SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.item,
					new String[]{"title","timelength"}, new int[]{R.id.title, R.id.timelength});
			listView.setAdapter(adapter);
		} catch (Throwable e) {
			Log.e(TAG, e.toString());
			Toast.makeText(this, R.string.error, 1).show();
		}
    }
}