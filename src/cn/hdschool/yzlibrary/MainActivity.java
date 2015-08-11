package cn.hdschool.yzlibrary;

import cn.hdscholl.yzlibrary.utils.AnimUtil;
import cn.hdscholl.yzlibrary.utils.ByteUtil;
import cn.hdscholl.yzlibrary.utils.CipherUtil;
import cn.hdscholl.yzlibrary.utils.DialogUtil;
import cn.hdscholl.yzlibrary.utils.DialogUtil.OkDialog;
import cn.hdscholl.yzlibrary.utils.ManagerUtil;
import cn.hdscholl.yzlibrary.utils.UIUtil;
import android.R.anim;
import android.os.Bundle;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Fragment;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.Builder;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.RotateAnimation;
import android.widget.Button;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		 final Button bt = (Button) findViewById(R.id.bt);
		 bt.setOnClickListener(new OnClickListener() {
		
		 @Override
		 public void onClick(View v) {
			 DialogUtil.showOkDialog(getFragmentManager(), "hello", "hello, my name is yangzhe", "ok", null);
		 }
		 });
		 
		 Button bt2 = (Button) findViewById(R.id.bt2);
		 bt2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				DialogUtil.showOkDialog(MainActivity.this, "hello", "hello, my name is yangzhe", "ok", null);
				
			}
		});
	}
}
