package cn.hdscholl.yzlibrary.utils;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

public class ObjectAnimatorUtil {
	public static ObjectAnimator getAlphaAnimator(View view, float ... alphas)
	{
		ObjectAnimator animator = ObjectAnimator.ofFloat(view, "alpha", alphas);
		return animator;
	}
	
	public static ObjectAnimator getRotationAnimator(View view,  float ... angles)
	{
		ObjectAnimator animator = ObjectAnimator.ofFloat(view, "rotation", angles);
		return animator;
	}
	
	public static ObjectAnimator getRotationXAnimator(View view,  float ... angles)
	{
		ObjectAnimator animator = ObjectAnimator.ofFloat(view, "rotationX", angles);
		return animator;
	} 
	
	public static ObjectAnimator getRotationYAnimator(View view,  float ... angles)
	{
		ObjectAnimator animator = ObjectAnimator.ofFloat(view, "rotationY", angles);
		return animator;
	}
	
	public static ObjectAnimator getTranslationXAnimator(View view,  float ... translationXs)
	{
		ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationX", translationXs);
		return animator;
	}
	
	public static ObjectAnimator getTranslationYAnimator(View view,  float ... translationXs)
	{
		ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationY", translationXs);
		return animator;
	}
	
	public static ObjectAnimator getScaleXAnimator(View view,  float ... scaleXs)
	{
		ObjectAnimator animator = ObjectAnimator.ofFloat(view, "sclaeX", scaleXs);
		return animator;
	}
	
	public static ObjectAnimator getScaleYAnimator(View view,  float ... scaleXs)
	{
		ObjectAnimator animator = ObjectAnimator.ofFloat(view, "sclaeY", scaleXs);
		return animator;
	}
	
	public static AnimatorSet getAnimatorSet()
	{
		return new AnimatorSet();
	}
}
