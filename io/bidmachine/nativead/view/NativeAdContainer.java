package io.bidmachine.nativead.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import io.bidmachine.utils.ViewHelper;

/* loaded from: classes6.dex */
class NativeAdContainer extends FrameLayout {
    final FrameLayout innerContainer;
    protected final NativeAdOverlayContainer overlayContainer;
    View previousConfiguredAdContainer;

    public NativeAdContainer(Context context) {
        this(context, null);
    }

    public NativeAdContainer(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NativeAdContainer(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public NativeAdContainer(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        FrameLayout frameLayout = new FrameLayout(context);
        this.innerContainer = frameLayout;
        NativeAdOverlayContainer nativeAdOverlayContainer = new NativeAdOverlayContainer(context);
        this.overlayContainer = nativeAdOverlayContainer;
        super.addView(frameLayout, -1, new FrameLayout.LayoutParams(-1, -1));
        super.addView(nativeAdOverlayContainer, -1, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // android.view.ViewGroup
    public void addView(View child) {
        FrameLayout frameLayout = this.innerContainer;
        if (child != frameLayout) {
            frameLayout.addView(child);
        } else {
            super.addView(child);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index) {
        FrameLayout frameLayout = this.innerContainer;
        if (child != frameLayout) {
            frameLayout.addView(child, index);
        } else {
            super.addView(child, index);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int width, int height) {
        FrameLayout frameLayout = this.innerContainer;
        if (child != frameLayout) {
            frameLayout.addView(child, width, height);
        } else {
            super.addView(child, width, height);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View child, ViewGroup.LayoutParams params) {
        FrameLayout frameLayout = this.innerContainer;
        if (child != frameLayout) {
            frameLayout.addView(child, params);
        } else {
            super.addView(child, params);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        FrameLayout frameLayout = this.innerContainer;
        if (child != frameLayout) {
            frameLayout.addView(child, index, params);
        } else {
            super.addView(child, index, params);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View child) {
        if (child == this.previousConfiguredAdContainer) {
            removePreviousAdContainer();
        } else {
            this.innerContainer.removeView(child);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void bringChildToFront(View child) {
        this.innerContainer.bringChildToFront(child);
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        this.innerContainer.removeAllViews();
    }

    protected void configureContainer(ViewGroup adContainer) {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        super.removeView(this.innerContainer);
        ViewHelper.removeViewFromParent(this.innerContainer);
        ViewHelper.removeViewFromParent(adContainer);
        removePreviousAdContainer();
        super.addView(adContainer, 0, layoutParams);
        adContainer.addView(this.innerContainer, 0, layoutParams);
        this.previousConfiguredAdContainer = adContainer;
    }

    protected void deConfigureContainer() {
        if (this.previousConfiguredAdContainer != null) {
            ViewHelper.removeViewFromParent(this.innerContainer);
            removePreviousAdContainer();
            super.addView(this.innerContainer, 0, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    protected void removePreviousAdContainer() {
        View view = this.previousConfiguredAdContainer;
        if (view != null) {
            super.removeView(view);
            this.previousConfiguredAdContainer = null;
        }
    }
}
