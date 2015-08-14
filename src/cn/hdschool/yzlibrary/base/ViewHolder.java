package cn.hdschool.yzlibrary.base;

import cn.hdschool.yzlibrary.utils.UIUtil;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {
	private final SparseArray<View> mViews;
	private View mConvertView;
	
	private ViewHolder(Context context, ViewGroup parent, int layoutId)
	{
		this.mViews = new SparseArray<View>();
		mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
		mConvertView.setTag(this);
	}
	
	public static ViewHolder getHolder(View convertView, ViewGroup parent, int layoutId)
	{
		if(convertView == null)
		{
			return new ViewHolder(UIUtil.getContext(), parent, layoutId);
		}
		else
		{
			return (ViewHolder) convertView.getTag();
		}
	}
	
	public <T extends View> T getView(int viewId)
	{
		View view = mViews.get(viewId);
		if(view == null)
		{
			view = mConvertView.findViewById(viewId);
			mViews.put(viewId, view);
		}
		return  (T) view;
	}
	
	public View getConvertView()
	{
		return mConvertView;
	}
	
	public ViewHolder setText(int viewId, String text)
	{
		TextView view = getView(viewId);
		view.setText(text);
		return this;
	}
	
	public ViewHolder setImageBitmap(int viewId, Bitmap bm)
	{
		ImageView view = getView(viewId);
		view.setImageBitmap(bm);
		return this;
	}
	
	public ViewHolder setImageResource(int viewId, int drawableId)
	{
		ImageView view = getView(viewId);
		view.setImageResource(drawableId);
		return this;
	}
}
