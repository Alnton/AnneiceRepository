package cn.itcast.videoupload;

import java.io.File;

import cn.itcast.service.VideoService;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private static final String TAG = "MainActivity";
    private EditText nameText;
    private EditText timelengthText;
    private EditText videofile;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        nameText = (EditText) this.findViewById(R.id.name);
        timelengthText = (EditText) this.findViewById(R.id.timelength);
        videofile = (EditText) this.findViewById(R.id.videofile);
        Button button = (Button) this.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				String name = nameText.getText().toString();
				String timelength = timelengthText.getText().toString();				
				String filename = videofile.getText().toString();				
				try {
					File file = new File(Environment.getExternalStorageDirectory(), filename);
					if(VideoService.saveVideo(name, timelength, file)){
						Toast.makeText(MainActivity.this, R.string.success, 1).show();
					}else{
						Toast.makeText(MainActivity.this, R.string.fail, 1).show();
					}
				} catch (Exception e) {
					Log.e(TAG, e.toString());
					Toast.makeText(MainActivity.this, R.string.error, 1).show();
				}
			}
		});
    }
}