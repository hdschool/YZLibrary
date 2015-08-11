package cn.hdscholl.yzlibrary.utils;

import java.io.Serializable;

import cn.hdschool.yzlibrary.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class DialogUtil {
	
	public static class OkDialog extends DialogFragment
	{
		private String title;
		private String message;
		private String okTitle;
		private ViewOnClickListenerWrapper okClickListener;
		public static OkDialog getOkDialog(String title, String message, String okTitle, final View.OnClickListener okClickListener)
		{
			OkDialog okDialog = new OkDialog();
			//利用setArguments传参数可以保存在转屏时参数恢复
			Bundle bundle = new Bundle();
			bundle.putString("title", title);
			bundle.putString("message", message);
			bundle.putString("okTitle", okTitle);
			//此处必须封装后才能放进bundle
			ViewOnClickListenerWrapper listener = new ViewOnClickListenerWrapper(okClickListener);
			bundle.putSerializable("listener", listener);
			okDialog.setArguments(bundle);
			return okDialog;
		}
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			Bundle bundle = getArguments();
			this.title = bundle.getString("title");
			this.message = bundle.getString("message");
			this.okTitle = bundle.getString("okTitle");
			this.okClickListener = (ViewOnClickListenerWrapper) bundle.getSerializable("listener");
			getDialog().setCancelable(false);
			getDialog().setCanceledOnTouchOutside(false);
			//去掉dialog的默认标题栏
			getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
			//背影透明
			getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
			View dialogView = View.inflate(UIUtil.getContext(), R.layout.ok_dialog_layout,
					null);
			TextView titleView = (TextView) dialogView
					.findViewById(R.id.tv_ok_dialog_title);
			titleView.setTextColor(Color.BLACK);
			TextView messageView = (TextView) dialogView
					.findViewById(R.id.tv_ok_dialog_message);
			messageView.setTextColor(Color.BLACK);
			Button okButton = (Button) dialogView
					.findViewById(R.id.bt_ok_dialog_ok);
			titleView.setText(title);
			messageView.setText(message);
			okButton.setText(okTitle);
			// 设置点击事件
			okButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					//点击ok后dismiss
					dismiss();
					if(okClickListener != null)
					{
						okClickListener.onClick(v);
					}
				}
			});
			return dialogView;
		}
		//OnClickListener包装类，定义此类主要是为了实现serializable
		public static class ViewOnClickListenerWrapper implements View.OnClickListener, Serializable
		{
			public ViewOnClickListenerWrapper(View.OnClickListener listener)
			{
				this.listener = listener;
			}
			private static final long serialVersionUID = -2369751956555567227L;
			private View.OnClickListener listener;
			@Override
			public void onClick(View v) {
				if(listener != null)
				{
					listener.onClick(v);
				}
			}
		}
	}
	
	public static void showOkDialog(FragmentManager manager, String title, String message, String okTitle, final View.OnClickListener okClickListener)
	{
		OkDialog.getOkDialog(title, message, okTitle, okClickListener).show(manager, title);
	}
	
	/**
	 * 显示一个对话框,有一个标题，一个主体和一个按钮，可监听按钮点击事件
	 * @param act
	 * @param title
	 * @param message
	 * @param okTitle
	 * @param okClickListener
	 */
	public static void showOkDialog(Activity act, String title,
			String message, String okTitle,
			final View.OnClickListener okClickListener) {
		//dialog布局,inflate的第三个参数为空，所以其布局文件根元素的布局参数无效，随便设置
		View dialogView = View.inflate(act, R.layout.ok_dialog_layout,
				null);
		//dialog对象
		final Dialog dialog = new Dialog(act, R.style.custom_dialog);
		TextView titleView = (TextView) dialogView
				.findViewById(R.id.tv_ok_dialog_title);
		TextView messageView = (TextView) dialogView
				.findViewById(R.id.tv_ok_dialog_message);
		Button okButton = (Button) dialogView
				.findViewById(R.id.bt_ok_dialog_ok);
		titleView.setText(title);
		messageView.setText(message);
		okButton.setText(okTitle);
		// 设置点击事件
		okButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//点击ok后dismiss
				dialog.dismiss();
				if(okClickListener != null)
				{
					okClickListener.onClick(v);
				}
			}
		});
		// 点击对话框周围区域对话框不会消失
		dialog.setCanceledOnTouchOutside(false);
		// 点击返回键对话框不会消失
		dialog.setCancelable(false);
		// 将dialog布局放进dialog中
		dialog.setContentView(dialogView, new LayoutParams(
				LayoutParams.WRAP_CONTENT
				, LayoutParams.WRAP_CONTENT));
		dialog.show();
	}
}
