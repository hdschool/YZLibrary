package cn.hdschool.yzlibrary.utils;

public class ScreenUtil {

	public static int getScreenWidth()
	{
		return UIUtil.getContext().getResources().getDisplayMetrics().widthPixels;
	}
	
	public static int getScreenHeight()
	{
		return UIUtil.getContext().getResources().getDisplayMetrics().heightPixels;
	}
	
}
