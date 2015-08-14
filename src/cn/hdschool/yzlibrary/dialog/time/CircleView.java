package cn.hdschool.yzlibrary.dialog.time;

import cn.hdschool.yzlibrary.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class CircleView extends View {
	private static final String tag = CircleView.class.getSimpleName();
	private final Paint mPaint = new Paint();
	private boolean mIs24HourMode;
	// 白色
	private int mWhite;
	// 黑灰色
	private int mBlack;
	private float mCircleRadiusMultipliter;
	private float mAmPmCircleRadiusMultiplier;
	private boolean mIsInitialized;

	private boolean mDrawValuesReady;
	private int mXCenter;
	private int mYCenter;
	private int mCircleRadius;

	public CircleView(Context context, AttributeSet attrs) {
		super(context, attrs);
		Resources res = context.getResources();
		mWhite = res.getColor(R.color.white);
		mBlack = res.getColor(R.color.numbers_text_color);
		mPaint.setAntiAlias(true);
		mIsInitialized = false;
	}

	//主要是设置了白色圆形占据
	public void initialize(Context context, boolean is24HourMode) {
		if (mIsInitialized) {
			Log.i(tag, "CircleView may only be initialized once");
			return;
		}
		Resources res = context.getResources();
		mIs24HourMode = is24HourMode;
		if (is24HourMode) {
			//默认是0.85;
			mCircleRadiusMultipliter = Float.parseFloat(res
					.getString(R.string.circle_radius_multiplier_24HourMode));
		}
		else
		{
			//默认是0.82;
			mCircleRadiusMultipliter = Float.parseFloat(res.getString(R.string.circle_radius_multiplier));
			mAmPmCircleRadiusMultiplier = Float.parseFloat(res.getString(R.string.ampm_circle_radius_multiplier));
		}
		mIsInitialized = true;
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		int viewWidth = getWidth();
		if(viewWidth == 0 || !mIsInitialized)
		{
			return;
		}
		if(!mDrawValuesReady)
		{
			//每次绘制时会调用,设置一些参数
			//中心点
			mXCenter = getWidth() /2;
			mYCenter = getHeight() /2 ;
			mCircleRadius = (int)(Math.min(mXCenter, mYCenter)* mCircleRadiusMultipliter);
			if(!mIs24HourMode)
			{
				int amPmCircleRadius = (int) (mCircleRadius * mAmPmCircleRadiusMultiplier);
				//如果是24小时模式，则圆盘不是在正中间，而是在原来正中间的位置上移小圆半径的二分之一
				mYCenter -= amPmCircleRadius / 2;
			}
			mDrawValuesReady = true;
		}
		mPaint.setColor(mWhite);
		canvas.drawCircle(mXCenter, mYCenter, mCircleRadius, mPaint);
		mPaint.setColor(mBlack);
		//白色表盘贺心处有一点
		canvas.drawCircle(mXCenter, mYCenter, 2, mPaint);
		super.onDraw(canvas);
	}

}
