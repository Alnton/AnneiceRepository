package cn.itcast.videoplay;

import java.io.File;
import java.io.IOException;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.SurfaceHolder.Callback;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity {
	private static final String TAG = "MainActivity";
    private EditText filenameText;
    private SurfaceView surfaceView;
    private MediaPlayer mediaPlayer;
    private int position;
    private File file;
    
    @Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
    	position = savedInstanceState.getInt("position");
    	String filename = savedInstanceState.getString("file");
    	if(filename!=null) file = new File(Environment.getExternalStorageDirectory(), filename);
		super.onRestoreInstanceState(savedInstanceState);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		outState.putInt("position", position);
		outState.putString("file", file.getName());
		super.onSaveInstanceState(outState);
	}

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mediaPlayer = new MediaPlayer();
        ButtonClickListener listener = new ButtonClickListener();
        filenameText = (EditText)this.findViewById(R.id.filename);
        surfaceView = (SurfaceView)this.findViewById(R.id.surfaceView);
        surfaceView.getHolder().setFixedSize(176, 144);	//设置分辨率
        /*下面设置Surface不维护自己的缓冲区，而是等待屏幕的渲染引擎将内容推送到用户面前*/
        surfaceView.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        surfaceView.getHolder().addCallback(new SurfaceCallback());
        
        ImageButton playButton = (ImageButton) this.findViewById(R.id.play);
        ImageButton pauseButton = (ImageButton) this.findViewById(R.id.pause);
        ImageButton resetButton = (ImageButton) this.findViewById(R.id.reset);
        ImageButton stopButton = (ImageButton) this.findViewById(R.id.stop);
        playButton.setOnClickListener(listener);
        pauseButton.setOnClickListener(listener);
        resetButton.setOnClickListener(listener);
        stopButton.setOnClickListener(listener);
    }
    
    private final class SurfaceCallback implements Callback{
		@Override
		public void surfaceChanged(SurfaceHolder holder, int format, int width,int height) {			
		}
		
		@Override
		public void surfaceCreated(SurfaceHolder holder) {
			if(position>0 && file!=null){
				try {
					play(file);	
					mediaPlayer.seekTo(position);
					position = 0;
				} catch (Exception e) {
					Log.e(TAG, e.toString());
				}
			}
		}

		@Override
		public void surfaceDestroyed(SurfaceHolder holder) {
			if(mediaPlayer.isPlaying()){
				position = mediaPlayer.getCurrentPosition();
				mediaPlayer.stop();
			}
		}
    	
    }
    
    @Override
	protected void onDestroy() {
		if(mediaPlayer!=null) mediaPlayer.release();
		super.onDestroy();
	}

	private final class ButtonClickListener implements View.OnClickListener{
		@Override
		public void onClick(View v) {
			String filename = filenameText.getText().toString();
			if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
				file = new File(Environment.getExternalStorageDirectory(), filename);
				if(file.exists()){
					try {
						switch (v.getId()) {						
						case R.id.play:
							play(file);					
							break;

						case R.id.pause:
							if(mediaPlayer.isPlaying()){
								mediaPlayer.pause();
							}else{
								mediaPlayer.start();
							}
							break;
						case R.id.reset:
							if(mediaPlayer.isPlaying()){
								mediaPlayer.seekTo(0);
							}else{
								play(file);	
							}
							break;
						case R.id.stop:
							if(mediaPlayer.isPlaying()) mediaPlayer.stop();
							break;
						}
					} catch (Exception e) {
						Log.e(TAG, e.toString());
					}
				}else{
					Toast.makeText(MainActivity.this, R.string.noexsit, 1).show();
				}
			}else{
				Toast.makeText(MainActivity.this, R.string.sdcarderror, 1).show();
			}
		}	
    }	

	private void play(File file) throws IOException {
		mediaPlayer.reset();
		mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
		mediaPlayer.setDisplay(surfaceView.getHolder());
		mediaPlayer.setDataSource(file.getAbsolutePath());
		mediaPlayer.prepare();
		mediaPlayer.start();	
	}    
}