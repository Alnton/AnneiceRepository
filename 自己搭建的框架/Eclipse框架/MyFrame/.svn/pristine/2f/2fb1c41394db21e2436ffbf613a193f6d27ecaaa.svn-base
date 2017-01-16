package com.alnton.myframe.ui.jpush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import cn.jpush.android.api.JPushInterface;

import com.alnton.myFrameCore.util.DebugLogUtil;

/**
 * JPush推送自定义接收器
 * @author 王乾州
 */
public class MyJpushReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        Bundle bundle = intent.getExtras();
        DebugLogUtil.d(DebugLogUtil.TAG, "[MyReceiver] onReceive - " + intent.getAction() + ", extras: "
            + printBundle(bundle));
        
        if (JPushInterface.ACTION_REGISTRATION_ID.equals(intent.getAction()))
        {
            String regId = bundle.getString(JPushInterface.EXTRA_REGISTRATION_ID);
            DebugLogUtil.d(DebugLogUtil.TAG, "[MyReceiver] 接收Registration Id : " + regId);
            //send the Registration Id to your server...
            
        }
        else if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction()))
        {
            DebugLogUtil.d(DebugLogUtil.TAG,
                "[MyReceiver] 接收到推送下来的自定义消息: " + bundle.getString(JPushInterface.EXTRA_MESSAGE));
            
            //            processCustomMessage(context, bundle);
        }
        else if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(intent.getAction()))
        {
            DebugLogUtil.d(DebugLogUtil.TAG, "[MyReceiver] 接收到推送下来的通知");
            int notifactionId = bundle.getInt(JPushInterface.EXTRA_NOTIFICATION_ID);
            DebugLogUtil.d(DebugLogUtil.TAG, "[MyReceiver] 接收到推送下来的通知的ID: " + notifactionId);
        }
        else if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction()))
        {
            DebugLogUtil.d(DebugLogUtil.TAG, "[MyReceiver] 用户点击打开了通知");
            
            JPushInterface.reportNotificationOpened(context, bundle.getString(JPushInterface.EXTRA_MSG_ID));
            
            //打开自定义的Activity
//            Intent i = new Intent(context, SystemMsgDetailActivity.class);
//            MsgInfo info = new MsgInfo();
//            info.setMsgContent(bundle.getString(JPushInterface.EXTRA_ALERT));
//            info.setMsgTitle(bundle.getString(JPushInterface.EXTRA_NOTIFICATION_TITLE));
//            bundle.putSerializable("systemMsg", info);
//            i.putExtras(bundle);
//            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            context.startActivity(i);
        }
        else if (JPushInterface.ACTION_RICHPUSH_CALLBACK.equals(intent.getAction()))
        {
            DebugLogUtil.d(DebugLogUtil.TAG,
                "[MyReceiver] 用户收到到RICH PUSH CALLBACK: " + bundle.getString(JPushInterface.EXTRA_EXTRA));
            //在这里根据 JPushInterface.EXTRA_EXTRA 的内容处理代码，比如打开新的Activity， 打开一个网页等..
        }
        else if (JPushInterface.ACTION_CONNECTION_CHANGE.equals(intent.getAction()))
        {
            boolean connected = intent.getBooleanExtra(JPushInterface.EXTRA_CONNECTION_CHANGE, false);
            DebugLogUtil.d(DebugLogUtil.TAG, "[MyReceiver]" + intent.getAction() + " connected state change to "
                + connected);
        }
        else
        {
            DebugLogUtil.d(DebugLogUtil.TAG, "[MyReceiver] Unhandled intent - " + intent.getAction());
        }
    }
    
    // 打印所有的 intent extra 数据
    private static String printBundle(Bundle bundle)
    {
        StringBuilder sb = new StringBuilder();
        for (String key : bundle.keySet())
        {
            if (key.equals(JPushInterface.EXTRA_NOTIFICATION_ID))
            {
                sb.append("\nkey:" + key + ", value:" + bundle.getInt(key));
            }
            else if (key.equals(JPushInterface.EXTRA_CONNECTION_CHANGE))
            {
                sb.append("\nkey:" + key + ", value:" + bundle.getBoolean(key));
            }
            else
            {
                sb.append("\nkey:" + key + ", value:" + bundle.getString(key));
            }
        }
        return sb.toString();
    }
    
    //send msg to MainActivity
    private void processCustomMessage(Context context, Bundle bundle)
    {
        //        if (JPushMainActivity.isForeground)
        //        {
        //            String message = bundle.getString(JPushInterface.EXTRA_MESSAGE);
        //            String extras = bundle.getString(JPushInterface.EXTRA_EXTRA);
        //            Intent msgIntent = new Intent(JPushMainActivity.MESSAGE_RECEIVED_ACTION);
        //            msgIntent.putExtra(JPushMainActivity.KEY_MESSAGE, message);
        //            if (!ExampleUtil.isEmpty(extras))
        //            {
        //                try
        //                {
        //                    JSONObject extraJson = new JSONObject(extras);
        //                    if (null != extraJson && extraJson.length() > 0)
        //                    {
        //                        msgIntent.putExtra(JPushMainActivity.KEY_EXTRAS, extras);
        //                    }
        //                }
        //                catch (JSONException e)
        //                {
        //                    
        //                }
        //                
        //            }
        //            context.sendBroadcast(msgIntent);
        //        }
    }
}