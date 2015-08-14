package cn.hdschool.yzlibrary.dialog.time;

import java.util.Calendar;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class AmPmCircleView extends View{
	private static final String tag = "AmPmCircleView";
	private static final int SELECTED_APPHA = 51;
	private static final int PRESSED_ALPHA = 175;
	private final Paint mPaint = new Paint();
	private int mWhite;
	private int mAmPmTextColor;
	private int mBlue;
	private float mCircleRadiusMultiplier;
	private float mAmPmCircleRadiusMultiplier;
	private  String mAmText;
	private String mPmText;
	private boolean mIsInitialized;
	
	private static final int AM = Calendar.AM;
	private static final int PM = Calendar.PM;
	
	private boolean mDrawValuesReady;
	private int mAmPmCircleRadius;
	private int mAmXCenter;
	private int mPmXCenter;
	private int mAmPmYCenter;
	private int mAmOrPm;
	private int mAmOrPmPressed;
	
	public AmPmCircleView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mIsInitialized = false;
	}
	
	public void initialize(Context context, int amOrPm)
	{
		if(mIsInitialized)
		{
			Log.i(tag, "AmPmCirclesView may only be initialized once");
			return;
		}
		Resources res = context.getResources();
		mWhite = res.getColor(R.color.white);
		
	}
	
}
