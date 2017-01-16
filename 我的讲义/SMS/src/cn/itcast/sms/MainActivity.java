package cn.itcast.sms;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    private EditText mobileText;
    private EditText contentText;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mobileText = (EditText)findViewById(R.id.mobile);
		contentText = (EditText)findViewById(R.id.content);
		
        Button button = (Button)this.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {			
			public void onClick(View v) {
				String mobile = mobileText.getText().toString();
				String content = contentText.getText().toString();
				SmsManager smsManager = SmsManager.getDefault();
				ArrayList<String> texts = smsManager.divideMessage(content);
				for(String text : texts){
					smsManager.sendTextMessage(mobile, null, text, null, null);
				}
				Toast.makeText(MainActivity.this, R.string.success, Toast.LENGTH_LONG).show();
			}
		});
    }
}