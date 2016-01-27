package me.imli.tintlib.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.support.annotation.Nullable;
import android.support.v7.widget.TintManager;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.widget.ProgressBar;

import me.imli.tintlib.tintxx.TintInfo;

/**
 * Created by Em on 2016/1/27.
 */
public class AppCompatProgressBar extends ProgressBar {

    private static final int[] TINT_ATTRS = {
            android.R.attr.background
    };

    private TintInfo mInternalBackgroundTint;
    private TintInfo mBackgroundTint;
    private TintManager mTintManager;

    public AppCompatProgressBar(Context context) {
        super(context);
    }

    public AppCompatProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AppCompatProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        if (TintManager.SHOULD_BE_USED) {
            TintTypedArray a = TintTypedArray.obtainStyledAttributes(getContext(), attrs, TINT_ATTRS, defStyleAttr, 0);
            if (a.hasValue(0)) {
                ColorStateList tint = a.getTintManager().getTintList(a.getResourceId(0, -1));
                if (tint != null) {
                    setInternalBackgroundTint(tint);
                }
            }
            mTintManager = a.getTintManager();
            a.recycle();
        }
    }

    private void applySupportBackgroundTint() {
        if (getBackground() != null) {
            if (mBackgroundTint != null) {
                TintManager.tintViewBackground(this, mBackgroundTint);
            } else if (mInternalBackgroundTint != null) {
                TintManager.tintViewBackground(this, mInternalBackgroundTint);
            }
        }
    }

    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        applySupportBackgroundTint();
    }

    private void setInternalBackgroundTint(ColorStateList tint) {
        if (tint != null) {
            if (mInternalBackgroundTint == null) {
                mInternalBackgroundTint = new TintInfo();
            }
            mInternalBackgroundTint.mTintList = tint;
            mInternalBackgroundTint.mHasTintList = true;
        } else {
            mInternalBackgroundTint = null;
        }
        applySupportBackgroundTint();
    }

    @Override
    public void setSupportBackgroundTintList(ColorStateList tint) {
        if (mBackgroundTint == null) {
            mBackgroundTint = new TintInfo();
        }
        mBackgroundTint.mTintList = tint;
        mBackgroundTint.mHasTintList = true;

        applySupportBackgroundTint();
    }

    @Nullable
    @Override
    public ColorStateList getSupportBackgroundTintList() {
        return mBackgroundTint != null ? mBackgroundTint.mTintList : null;
    }

    @Override
    public void setSupportBackgroundTintMode(PorterDuff.Mode tintMode) {
        if (mBackgroundTint == null) {
            mBackgroundTint = new TintInfo();
        }
        mBackgroundTint.mTintMode = tintMode;
        mBackgroundTint.mHasTintMode = true;

        applySupportBackgroundTint();
    }

    @Nullable
    @Override
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return mBackgroundTint != null ? mBackgroundTint.mTintMode : null;
    }

}
