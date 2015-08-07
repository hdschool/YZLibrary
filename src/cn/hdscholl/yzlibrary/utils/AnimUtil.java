package cn.hdscholl.yzlibrary.utils;


import cn.hdschool.yzlibrary.R;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;

public class AnimUtil {
	/**返回一个不断围绕中心点不断旋转的动画*/
	public static RotateAnimation getRotateAnimation()
	{
		return (RotateAnimation) AnimationUtils.loadAnimation(UIUtil.getContext(), R.anim.rotate_animation);
	}
	
	/**返回一个alpha动画*/
	public static AlphaAnimation getAlphaAnimation()
	{
		return (AlphaAnimation) AnimationUtils.loadAnimation(UIUtil.getContext(), R.anim.alpha_animation);
	}
	
	/**返回一个alpha动画*/
	public static AlphaAnimation getAlphaAnimation(float fromAlpha, float toAlpha, long durationMillis)
	{
		AlphaAnimation anim = new AlphaAnimation(fromAlpha, toAlpha);
		anim.setDuration(durationMillis);
		return anim;
	}
}
