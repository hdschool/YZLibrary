package cn.hdschool.yzlibrary;

import cn.hdschool.yzlibrary.utils.AnimUtil;
import cn.hdschool.yzlibrary.utils.ByteUtil;
import cn.hdschool.yzlibrary.utils.CipherUtil;
import cn.hdschool.yzlibrary.utils.DialogUtil;
import cn.hdschool.yzlibrary.utils.ManagerUtil;
import cn.hdschool.yzlibrary.utils.UIUtil;
import cn.hdschool.yzlibrary.utils.DialogUtil.OkDialog;
import cn.hdschool.yzlibrary.views.DragLinearLayout;
import cn.hdschool.yzlibrary.views.DragViewGroup;
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
import android.support.v4.widget.ViewDragHelper.Callback;
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
		DragLinearLayout main = (DragLinearLayout) findViewById(R.id.main);
		main.setCallBack(new Callback() {
			
			@Override
			public boolean tryCaptureView(View child, int pointerId) {
				
				return true;
			}
		
			/**
			 * 返回值决定了view能拖动到的最左边位置，参数left表示view的getLeft();
			 */
			@Override
			public int clampViewPositionHorizontal(View child, int left, int dx) {
				if(left < 0)
				{
					return 0;
				}
				return left;
			}
			
			/**
			 * 返回值决定了view能拖动到的最顶部的位置,参数top表示view的getTop();
			 */
			@Override
			public int clampViewPositionVertical(View child, int top, int dy) {
				if(top < 0)
				{
					return 0;
				}
				return top;
			}
			@Override
			public int getViewHorizontalDragRange(View child) {
				// TODO Auto-generated method stub
				return 0;
			}
		
		});

	}
}
