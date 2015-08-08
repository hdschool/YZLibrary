package cn.hdscholl.yzlibrary.utils;


import cn.hdschool.yzlibrary.R;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;

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
	
	/**返回一个位移动画*/
	public static TranslateAnimation getTranslateAnimation(float fromX, float fromY, float toX, float toY, long durationMills)
	{
		TranslateAnimation anim = new TranslateAnimation(fromX, toX, fromY, toY);
		anim.setDuration(durationMills);
		return anim;
	}
	
	/**返回一个位移动画，参数值相对于自己，为0.0到1.0*/
	public static TranslateAnimation getTranslateAnimationBySelf(float fromX, float fromY, float toX, float toY, long durationMills)
	{
		TranslateAnimation anim = new TranslateAnimation(Animation.RELATIVE_TO_SELF, fromX, Animation.RELATIVE_TO_SELF, toX, Animation.RELATIVE_TO_SELF, fromY, Animation.RELATIVE_TO_SELF, toY);
		anim.setDuration(durationMills);
		return anim;
	}
	/**返回一个位移动画，参数值相对于parent，为0.0到1.0*/
	public static TranslateAnimation getTranslateAnimationByParent(float fromX, float fromY, float toX, float toY, long durationMills)
	{
		TranslateAnimation anim = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, fromX, Animation.RELATIVE_TO_PARENT, toX, Animation.RELATIVE_TO_PARENT, fromY, Animation.RELATIVE_TO_PARENT, toY);
		anim.setDuration(durationMills);
		return anim;
	}
}
