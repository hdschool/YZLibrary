package cn.hdschool.yzlibrary;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

public class TestAct extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		TextView tv = new TextView(this);
		tv.setGravity(Gravity.CENTER);
		tv.setBackgroundColor(Color.RED);
		tv.setText("test");
		setContentView(tv);
	}
}
