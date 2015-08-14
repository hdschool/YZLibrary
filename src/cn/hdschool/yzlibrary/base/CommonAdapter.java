package cn.hdschool.yzlibrary.base;

import java.util.List;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class CommonAdapter<T> extends BaseAdapter{
	private List<T> mDatas;
	private int itemLayoutId;
	public CommonAdapter(List<T> datas, int itemLayoutId)
	{
		this.mDatas = datas;
		this.itemLayoutId = itemLayoutId;
	}
	
	@Override
	public int getCount() {
		return mDatas.size();
	}

	@Override
	public Object  getItem(int position) {
		return this.mDatas.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = ViewHolder.getHolder(convertView, parent, this.itemLayoutId);
		convert(holder, mDatas.get(position));
		return holder.getConvertView();
	}
	
	public abstract void convert(ViewHolder viewHolder, T item);


}
