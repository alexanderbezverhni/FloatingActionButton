package com.github.clans.fab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;

public class AnydoSlideFloatingActionButton extends FloatingActionButton {

    private static final int TRANSLATE_DURATION_MILLIS = 200;

    private boolean mVisible = true;
    private int mHiddenTranslationY = Integer.MAX_VALUE;

    public AnydoSlideFloatingActionButton(Context context) {
        super(context);
    }

    public AnydoSlideFloatingActionButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AnydoSlideFloatingActionButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public AnydoSlideFloatingActionButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void show(boolean animate) {
        toggle(true, animate, false);
    }

    @Override
    public void hide(boolean animate) {
        toggle(false, animate, false);
    }

    @Override
    public boolean isHidden() {
        return getTranslationY() == mHiddenTranslationY;
    }

    private void toggle(final boolean visible, final boolean animate, boolean force) {
        if (mVisible != visible || force) {
            mVisible = visible;
            int height = getHeight();
            if (height == 0 && !force) {
                ViewTreeObserver vto = getViewTreeObserver();
                if (vto.isAlive()) {
                    vto.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                        @Override
                        public boolean onPreDraw() {
                            ViewTreeObserver currentVto = getViewTreeObserver();
                            if (currentVto.isAlive()) {
                                currentVto.removeOnPreDrawListener(this);
                            }
                            toggle(visible, animate, true);
                            return true;
                        }
                    });
                    return;
                }
            }
            int mHiddenTranslationY = visible ? 0 : height + getMarginBottom();
            if (animate) {
                animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(TRANSLATE_DURATION_MILLIS).translationY(mHiddenTranslationY);
            } else {
                setTranslationY(mHiddenTranslationY);
            }
        }
    }

    private int getMarginBottom() {
        return getResources().getDimensionPixelSize(R.dimen.anydo_fab_margin_bottom);
    }
}
