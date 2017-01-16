package cn.itcast.who;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    private IWhoService binder;
    private TextView resultView;
    private ServiceConnection conn = new WhoServiceConnection();
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        resultView = (TextView)this.findViewById(R.id.result);
       
    	Intent service = new Intent(MainActivity.this, WhoService.class);
		bindService(service, conn, BIND_AUTO_CREATE);
        Button button = (Button)this.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				resultView.setText(binder.who(0));
			}
		});
    }
    
    private final class WhoServiceConnection implements ServiceConnection{
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			binder = (IWhoService)service;
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			binder = null;
		}
    }

	@Override
	protected void onDestroy() {
		if(conn!=null && binder != null){
			unbindService(conn);
		}
		super.onDestroy();
	}
    
    
}