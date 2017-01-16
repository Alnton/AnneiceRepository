package cn.itcast.videorecord;

import java.io.File;

import android.app.Activity;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActvity extends Activity {
	private static final String TAG = "MainActvity"; 
    private SurfaceView surfaceView;
    private MediaRecorder recorder;
    private Button recordButton;
    private Button stopButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
    	requestWindowFeature(Window.FEATURE_NO_TITLE);//没有标题
    	window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);// 设置全屏
    	window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);//高亮
    	
        setContentView(R.layout.main);
        
        recorder = new MediaRecorder();
        surfaceView = (SurfaceView)this.findViewById(R.id.surfaceView);
        /*下面设置Surface不维护自己的缓冲区，而是等待屏幕的渲染引擎将内容推送到用户面前*/
        this.surfaceView.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        this.surfaceView.getHolder().setFixedSize(320, 240);//设置分辨率
        this.surfaceView.getHolder().setKeepScreenOn(true);
        
        recordButton = (Button)this.findViewById(R.id.record);
        stopButton = (Button)this.findViewById(R.id.stop);
        ButtonClickListener listener = new ButtonClickListener();
        recordButton.setOnClickListener(listener);
        stopButton.setOnClickListener(listener);        
        stopButton.setEnabled(false);//按钮是否可用
    }
    
    @Override
	protected void onDestroy() {
		if(recorder!=null) recorder.release();
		super.onDestroy();
	}

	private final class ButtonClickListener implements View.OnClickListener{
		@Override
		public void onClick(View v) {
			Button button = (Button)v;
			try {
				switch (v.getId()) {
				case R.id.record:
					if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
						File file = new File(Environment.getExternalStorageDirectory(), System.currentTimeMillis()+ ".3gp");
						recorder.reset();
						recorder.setVideoSource(MediaRecorder.VideoSource.CAMERA); //从照相机采集视频
						recorder.setAudioSource(MediaRecorder.AudioSource.MIC); 
						recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
						recorder.setVideoSize(320, 240);
						recorder.setVideoFrameRate(3); //每秒3帧
						recorder.setVideoEncoder(MediaRecorder.VideoEncoder.H263); //设置视频编码方式
						recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
						recorder.setOutputFile(file.getAbsolutePath());
						recorder.setPreviewDisplay(surfaceView.getHolder().getSurface());
						recorder.prepare();//预期准备
						recorder.start();//开始刻录
						button.setEnabled(false);
						stopButton.setEnabled(true);						
					}else{
						Toast.makeText(MainActvity.this, R.string.sdcarderror, 1).show();
					}					
					break;

				case R.id.stop:
					recorder.stop();
					button.setEnabled(false);
					recordButton.setEnabled(true);
					Toast.makeText(MainActvity.this, R.string.success, 1).show();
					break;
				}
			} catch (Exception e) {
				Log.e(TAG, e.toString());
			}
		}
    	
    }
}