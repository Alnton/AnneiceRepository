package cn.itcast.who;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class WhoService extends Service {
	private IBinder binder = new WhoBinder();
	private String[] names = {"ËïÏþ·¼", "Áõ¿¡Í¡"};

	public String getName(int id){
		if(id<0 || id>1) return null;
		return names[id];
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		return binder;
	}
	
	private final class WhoBinder extends Binder implements IWhoService{
		@Override
		public String who(int id) {
			return getName(id);
		}		
	}

}
