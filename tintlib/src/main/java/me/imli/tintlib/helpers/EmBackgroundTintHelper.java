package me.imli.tintlib.helpers;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.graphics.drawable.DrawableUtils;
import android.util.AttributeSet;
import android.view.View;

import me.imli.tintlib.tint.EmTintManager;
import me.imli.tintlib.tint.TintInfo;

/**
 * Created by Em on 2016/1/27.
 */
public class EmBackgroundTintHelper {

    /**
     *
     * @param view
     * @param attrs
     * @param defStyleAttr
     */
    public static void loadFromAttributes(View view, AttributeSet attrs, int defStyleAttr) {
        TypedArray a = view.getContext().obtainStyledAttributes(attrs, R.styleable.BackgroundHelper, defStyleAttr, 0);
        try {
            if (a.hasValue(R.styleable.BackgroundHelper_backgroundTint)) {
                ViewCompat.setBackgroundTintList(view, a.getColorStateList(R.styleable.BackgroundHelper_backgroundTint));
            }
            if (a.hasValue(R.styleable.BackgroundHelper_backgroundTintMode)) {
                ViewCompat.setBackgroundTintMode(view, DrawableUtils.parseTintMode( a.getInt(R.styleable.BackgroundHelper_backgroundTintMode, -1), null));
            }
        } finally {
            a.recycle();
        }
    }

    /**
     *
     * @param view
     * @param info
     * @param resId
     */
    public static void onSetBackgroundResource(View view, TintInfo info, int resId) {
        applySupportBackgroundTint(view, info);
    }

    /**
     *
     * @param view
     * @param info
     * @param background
     */
    public static void onSetBackgroundDrawable(View view, TintInfo info, Drawable background) {
        applySupportBackgroundTint(view, info);
    }

    /**
     *
     * @param view
     * @param info
     * @param tint
     */
    public static void setSupportBackgroundTintList(View view, TintInfo info, ColorStateList tint) {
        info.mTintList = tint;
        applySupportBackgroundTint(view, info);
    }

    /**
     *
     * @param info
     * @return
     */
    public static ColorStateList getSupportBackgroundTintList(TintInfo info) {
        return info != null ? info.mTintList : null;
    }

    /**
     *
     * @param view
     * @param info
     * @param tintMode
     */
    public static void setSupportBackgroundTintMode(View view, TintInfo info, PorterDuff.Mode tintMode) {
        if (info == null) {
            info = new TintInfo();
        }
        info.mTintMode = tintMode;
        info.mHasTintMode = true;

        applySupportBackgroundTint(view, info);
    }

    /**
     *
     * @param info
     * @return
     */
    public static PorterDuff.Mode getSupportBackgroundTintMode(TintInfo info) {
        return info != null ? info.mTintMode : null;
    }

    /**
     *
     * @param view
     * @param info
     */
    static void applySupportBackgroundTint(View view, TintInfo info) {
        final Drawable background = view.getBackground();
        if (background != null) {
            if (info != null) {
                EmTintManager.tintDrawable(background, info, view.getDrawableState());
            }
        }
    }
}
