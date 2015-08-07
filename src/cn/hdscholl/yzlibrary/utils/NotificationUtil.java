package cn.hdscholl.yzlibrary.utils;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class NotificationUtil {
	public static Notification createSimpleNotification(int iconId, String tickerTitle, String contentTitle, String contentText, Intent intent)
	{
		NotificationCompat.Builder builder = new NotificationCompat.Builder(UIUtil.getContext());
		//设置左边图标
		builder.setSmallIcon(iconId);
		//设置通知到来时状态栏提示文字
		builder.setTicker(tickerTitle);
		//设置内容标题，下拉抽屉可看到
		builder.setContentTitle(contentTitle);
		//设置内容文字，下拉抽抽屉可看到
		builder.setContentText(contentText);
		//优先级越高，显示越靠前
		builder.setPriority(Notification.PRIORITY_DEFAULT);
		//设置为true,则在intent触发后自动清除通知，否则不会清除
		builder.setAutoCancel(true);
		//表示后台任务，如果设置为true,则无法手动从抽屉上清除
		builder.setOngoing(true);
		//点击通知触发intent
		PendingIntent pendingIntent = PendingIntent.getActivity(UIUtil.getContext(), 0, intent, 0);
		builder.setContentIntent(pendingIntent);
		return builder.build();
	}
}
