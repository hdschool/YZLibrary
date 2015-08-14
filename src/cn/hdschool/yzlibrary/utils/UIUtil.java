package cn.hdschool.yzlibrary.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import cn.hdschool.yzlibrary.R;
import cn.hdschool.yzlibrary.base.BaseApplication;

public class UIUtil {
	public static Context getContext() {
		return BaseApplication.getApplication();
	}

	public static Thread getMainThread() {
		return BaseApplication.getMainThread();
	}

	public static long getMainThreadId() {
		return BaseApplication.getMainThreadId();
	}

	/** dip转换px */
	public static int dip2px(int dip) {
		final float scale = getContext().getResources().getDisplayMetrics().density;
		return (int) (dip * scale + 0.5f);
	}

	/** px转换dip */
	public static int px2dip(int px) {
		final float scale = getContext().getResources().getDisplayMetrics().density;
		return (int) (px / scale + 0.5f);
	}
	
    /** 
     * 将sp值转换为px值，保证文字大小不变 
     */  
    public static int sp2px(float spValue) {  
    	  return  (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spValue, UIUtil.getContext().getResources().getDisplayMetrics());
    }  

	/** 获取主线程的handler */
	public static Handler getHandler() {
		return BaseApplication.getMainThreadHandler();
	}

	/** 延时在主线程执行runnable */
	public static boolean postDelayed(Runnable runnable, long delayMillis) {
		return getHandler().postDelayed(runnable, delayMillis);
	}

	/** 在主线程执行runnable */
	public static boolean post(Runnable runnable) {
		return getHandler().post(runnable);
	}

	/** 从主线程looper里面移除runnable */
	public static void removeCallbacks(Runnable runnable) {
		getHandler().removeCallbacks(runnable);
	}

	public static View inflate(int resId) {
		return LayoutInflater.from(getContext()).inflate(resId, null);
	}

	/** 获取资源 */
	public static Resources getResources() {
		return getContext().getResources();
	}

	/** 获取文字 */
	public static String getString(int resId) {
		return getResources().getString(resId);
	}

	/** 获取文字数组 */
	public static String[] getStringArray(int resId) {
		return getResources().getStringArray(resId);
	}

	/** 获取dimen */
	public static int getDimens(int resId) {
		return getResources().getDimensionPixelSize(resId);
	}

	/** 获取drawable */
	public static Drawable getDrawable(int resId) {
		return getResources().getDrawable(resId);
	}

	/** 获取颜色 */
	public static int getColor(int resId) {
		return getResources().getColor(resId);
	}

	/** 获取颜色选择器 */
	public static ColorStateList getColorStateList(int resId) {
		return getResources().getColorStateList(resId);
	}

	// 判断当前的线程是不是在主线程
	public static boolean isRunInMainThread() {
		return android.os.Process.myTid() == getMainThreadId();
	}

	public static void runInMainThread(Runnable runnable) {
		if (isRunInMainThread()) {
			runnable.run();
		} else {
			post(runnable);
		}
	}

	//显示toast
	private static void showToast(final String msg, final int duration)
	{
		if(TextUtils.isEmpty(msg))
		{
			return;
		}
		runInMainThread(new Runnable(){
			@Override
			public void run() {
				TextView tv = new TextView(getContext());
				tv.setText(msg);
				tv.setTextSize(12f);
				tv.setTextColor(Color.WHITE);
				tv.setPadding(15, 5, 15, 5);
				tv.setBackgroundResource(R.drawable.toast_bg);
				tv.setGravity(Gravity.CENTER);
				Toast toast = new Toast(getContext());
				toast.setDuration(duration);
				toast.setView(tv);
				toast.show();
			}
		});
	}
	/**展示短toast*/
	public static void showShortMsg(final String msg)
	{
		showToast(msg, Toast.LENGTH_SHORT);
	}
	/**展示长toast*/
	public static void showLongMsg(final String msg)
	{
		showToast(msg, Toast.LENGTH_LONG);
	}
}
