package com.example.demo;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;

/**
 * 跟View有关的Util 功能1、屏幕适配
 * 
 * @author long_haoran
 * 
 */
@SuppressLint("NewApi")
// api 16+
public class ViewUtil {
	private static ResolutionUtil resolutionUtil;
	private static MarginLayoutParams layoutParams;
	private static List<View> convertViewList;

	/**
	 * 屏幕适配
	 * 
	 * @param context
	 * @param view
	 * @param containPadding
	 *            padding属性是在view绘制之后获取。假如在listView设为true，可能出现复用问题。
	 */
	public static void resolutionByViewGroup(Context context, View view,
			boolean containPadding) {
		if (!(view instanceof ViewGroup)) {
			try {
				throw new Exception("be sure your View instanceof ViewGroup");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ViewGroup viewGroup = (ViewGroup) view;
		int count = viewGroup.getChildCount();
		for (int i = 0; i < count; i++) {
			final View childView = viewGroup.getChildAt(i);
			if (childView instanceof ViewGroup) {
				resolutionByViewGroup(context, (ViewGroup) childView,
						containPadding);
			}
			resolutionByView(context, childView, containPadding);
		}
	}

	/**
	 * 屏幕适配
	 * 
	 * @param context
	 * @param view
	 * @param containPadding
	 *            控件是否含padding
	 */
	public static void resolutionByView(Context context, final View view,
			boolean containPadding) {
		if (resolutionUtil == null) {
			resolutionUtil = ResolutionUtil.getInstance(context);
		}
		ViewTreeObserver observer = view.getViewTreeObserver();
		layoutParams = (MarginLayoutParams) view.getLayoutParams();
		// view基本属性适配
		LayoutParamsResolution(view, layoutParams, containPadding);
		// 字体大小适配
		textSizeResolution(view);
	}

	private static void LayoutParamsResolution(final View view,
			MarginLayoutParams layoutParam, boolean containPadding) {
		// // padding
		// int paddingLeft = view.getPaddingLeft();
		// int paddingTop = view.getPaddingTop();
		// int paddingRight = view.getPaddingRight();
		// int paddingBottom = view.getPaddingBottom();
		// view.setPadding(resolutionUtil.px2dp2pxWidth(paddingLeft),
		// resolutionUtil.px2dp2pxWidth(paddingTop),
		// resolutionUtil.px2dp2pxWidth(paddingRight),
		// resolutionUtil.px2dp2pxWidth(paddingBottom));
		// margin、width、height
		int width = resolutionUtil.px2dp2pxWidth(layoutParams.width);
		int height = resolutionUtil.px2dp2pxWidth(layoutParams.height);
		if (width > 0) {
			layoutParams.width = width;
		}
		if (height > 0) {
			layoutParams.height = height;
		}
		layoutParams.leftMargin = resolutionUtil
				.px2dp2pxWidth(layoutParams.leftMargin);
		layoutParams.topMargin = resolutionUtil
				.px2dp2pxWidth(layoutParams.topMargin);
		layoutParams.rightMargin = resolutionUtil
				.px2dp2pxWidth(layoutParams.rightMargin);
		layoutParams.bottomMargin = resolutionUtil
				.px2dp2pxWidth(layoutParams.bottomMargin);
		view.setLayoutParams(layoutParams);

		// padding
		if (containPadding) {

			ViewTreeObserver vto = view.getViewTreeObserver();
			vto.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
				@Override
				public void onGlobalLayout() {
					// TODO Auto-generated method stub
					view.getViewTreeObserver().removeGlobalOnLayoutListener(
							this);
					int bottom = view.getPaddingBottom();
					int left = view.getPaddingLeft();
					int right = view.getPaddingRight();
					int top = view.getPaddingTop();
					view.setPadding(resolutionUtil.px2dp2pxWidth(left),
							resolutionUtil.px2dp2pxWidth(top),
							resolutionUtil.px2dp2pxWidth(right),
							resolutionUtil.px2dp2pxWidth(bottom));
				}
			});
		}
	}

	private static void textSizeResolution(View childView) {
		if (childView instanceof TextView) {
			((TextView) childView).setTextSize(resolutionUtil
					.px2sp2px(((TextView) childView).getTextSize()));
		}
	}

}
