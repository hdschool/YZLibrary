package cn.hdschool.yzlibrary.views;

import android.content.Context;
import android.support.v4.widget.ViewDragHelper;
import android.support.v4.widget.ViewDragHelper.Callback;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class DragLinearLayout extends LinearLayout {
	private ViewDragHelper mDragHelper;
	private Callback mCallback;

	public DragLinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public ViewDragHelper getDragHelper() {
		return mDragHelper;
	}

	public void setCallBack(Callback callback) {
		this.mCallback = callback;
		mDragHelper = ViewDragHelper.create(this, 1.0f, mCallback);
	}
	
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		if(mDragHelper != null)
		{
			return mDragHelper.shouldInterceptTouchEvent(ev);
		}
		return super.onInterceptTouchEvent(ev);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if(mDragHelper != null)
		{
			mDragHelper.processTouchEvent(event);
	        return true;
		}
		return super.onTouchEvent(event);
	}
}
