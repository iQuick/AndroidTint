package me.imli.androidtint;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.support.annotation.Nullable;
import android.support.v4.view.TintableBackgroundView;
import android.util.AttributeSet;
import android.view.View;

import me.imli.tintlib.helpers.EmBackgroundTintHelper;
import me.imli.tintlib.tint.TintInfo;

/**
 *
 * 自定义 AppCompatView
 *
 * Created by Em on 2016/1/27.
 */
public class AppCompatView extends View implements TintableBackgroundView {

    private TintInfo mTintInfo;

    public AppCompatView(Context context) {
        this(context, null);
    }

    public AppCompatView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AppCompatView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        EmBackgroundTintHelper.loadFromAttributes(this, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mTintInfo = new TintInfo();
        mTintInfo.mHasTintList = true;
    }

    @Override
    public void setSupportBackgroundTintList(ColorStateList tint) {
        EmBackgroundTintHelper.setSupportBackgroundTintList(this, mTintInfo,tint);
    }

    @Nullable
    @Override
    public ColorStateList getSupportBackgroundTintList() {
        return EmBackgroundTintHelper.getSupportBackgroundTintList(mTintInfo);
    }

    @Override
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode tintMode) {
        EmBackgroundTintHelper.setSupportBackgroundTintMode(this, mTintInfo, tintMode);
    }

    @Nullable
    @Override
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return EmBackgroundTintHelper.getSupportBackgroundTintMode(mTintInfo);
    }
}
