package cn.hdscholl.yzlibrary.utils;

import android.app.NotificationManager;
import android.content.Context;

public class ManagerUtil {
	public static NotificationManager getNotificationManager()
	{
		return (NotificationManager) UIUtil.getContext().getSystemService(Context.NOTIFICATION_SERVICE);
	}
}
