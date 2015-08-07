package cn.hdschool.yzlibrary;

import cn.hdscholl.yzlibrary.utils.AnimUtil;
import cn.hdscholl.yzlibrary.utils.ByteUtil;
import cn.hdscholl.yzlibrary.utils.CipherUtil;
import cn.hdscholl.yzlibrary.utils.ManagerUtil;
import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.Builder;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.RotateAnimation;
import android.widget.Button;

public class MainActivity extends Activity {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final AlphaAnimation anim = AnimUtil.getAlphaAnimation();
        final Button bt = (Button) findViewById(R.id.bt);
        bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, TestAct.class);
				startActivity(intent);
			}
		});
   }



    
}
