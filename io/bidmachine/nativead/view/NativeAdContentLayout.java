package io.bidmachine.nativead.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import io.bidmachine.Executable;
import io.bidmachine.R;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.nativead.NativeAd;
import io.bidmachine.nativead.NativeData;
import io.bidmachine.nativead.NativePublicData;
import io.bidmachine.utils.ViewHelper;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes6.dex */
public class NativeAdContentLayout extends NativeAdContainer {
    protected View callToActionView;
    private int callToActionViewId;
    private Set<WeakReference<View>> clickableViewRefs;
    private NativeAd currentAd;
    protected View descriptionView;
    private int descriptionViewId;
    protected View iconView;
    private int iconViewId;
    protected NativeMediaView mediaView;
    private int mediaViewId;
    protected View providerView;
    private int providerViewId;
    protected View ratingView;
    private int ratingViewId;
    protected View titleView;
    private int titleViewId;

    @Override // io.bidmachine.nativead.view.NativeAdContainer, android.view.ViewGroup
    public /* bridge */ /* synthetic */ void addView(View child) {
        super.addView(child);
    }

    @Override // io.bidmachine.nativead.view.NativeAdContainer, android.view.ViewGroup
    public /* bridge */ /* synthetic */ void addView(View child, int index) {
        super.addView(child, index);
    }

    @Override // io.bidmachine.nativead.view.NativeAdContainer, android.view.ViewGroup
    public /* bridge */ /* synthetic */ void addView(View child, int width, int height) {
        super.addView(child, width, height);
    }

    @Override // io.bidmachine.nativead.view.NativeAdContainer, android.view.ViewGroup
    public /* bridge */ /* synthetic */ void addView(View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
    }

    @Override // io.bidmachine.nativead.view.NativeAdContainer, android.view.ViewGroup, android.view.ViewManager
    public /* bridge */ /* synthetic */ void addView(View child, ViewGroup.LayoutParams params) {
        super.addView(child, params);
    }

    @Override // io.bidmachine.nativead.view.NativeAdContainer, android.view.ViewGroup, android.view.ViewParent
    public /* bridge */ /* synthetic */ void bringChildToFront(View child) {
        super.bringChildToFront(child);
    }

    @Override // io.bidmachine.nativead.view.NativeAdContainer, android.view.ViewGroup
    public /* bridge */ /* synthetic */ void removeAllViews() {
        super.removeAllViews();
    }

    @Override // io.bidmachine.nativead.view.NativeAdContainer, android.view.ViewGroup, android.view.ViewManager
    public /* bridge */ /* synthetic */ void removeView(View child) {
        super.removeView(child);
    }

    public NativeAdContentLayout(Context context) {
        this(context, null);
    }

    public NativeAdContentLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NativeAdContentLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.clickableViewRefs = new HashSet();
        this.titleViewId = -1;
        this.callToActionViewId = -1;
        this.ratingViewId = -1;
        this.descriptionViewId = -1;
        this.providerViewId = -1;
        this.iconViewId = -1;
        this.mediaViewId = -1;
        if (attrs == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.NativeAdContentLayout, defStyleAttr, 0);
        try {
            this.titleViewId = obtainStyledAttributes.getResourceId(R.styleable.NativeAdContentLayout_titleViewId, -1);
            this.callToActionViewId = obtainStyledAttributes.getResourceId(R.styleable.NativeAdContentLayout_callToActionViewId, -1);
            this.ratingViewId = obtainStyledAttributes.getResourceId(R.styleable.NativeAdContentLayout_ratingViewId, -1);
            this.descriptionViewId = obtainStyledAttributes.getResourceId(R.styleable.NativeAdContentLayout_descriptionViewId, -1);
            this.providerViewId = obtainStyledAttributes.getResourceId(R.styleable.NativeAdContentLayout_providerViewId, -1);
            this.iconViewId = obtainStyledAttributes.getResourceId(R.styleable.NativeAdContentLayout_iconViewId, -1);
            this.mediaViewId = obtainStyledAttributes.getResourceId(R.styleable.NativeAdContentLayout_mediaViewId, -1);
            if (obtainStyledAttributes != null) {
                obtainStyledAttributes.close();
            }
        } catch (Throwable th) {
            if (obtainStyledAttributes != null) {
                try {
                    obtainStyledAttributes.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        setTitleView(findViewById(this.titleViewId));
        setCallToActionView(findViewById(this.callToActionViewId));
        setRatingView(findViewById(this.ratingViewId));
        setDescriptionView(findViewById(this.descriptionViewId));
        setProviderView(findViewById(this.providerViewId));
        setIconView(findViewById(this.iconViewId));
        setMediaView((NativeMediaView) findViewById(this.mediaViewId));
    }

    public void setTitleView(View view) {
        this.titleView = view;
    }

    public void setCallToActionView(View view) {
        this.callToActionView = view;
    }

    public void setRatingView(View view) {
        this.ratingView = view;
    }

    public void setDescriptionView(View view) {
        this.descriptionView = view;
    }

    public void setProviderView(View view) {
        this.providerView = view;
    }

    public void setIconView(View iconView) {
        this.iconView = iconView;
    }

    public void setMediaView(NativeMediaView mediaView) {
        this.mediaView = mediaView;
    }

    public View getTitleView() {
        return this.titleView;
    }

    public View getCallToActionView() {
        return this.callToActionView;
    }

    public View getRatingView() {
        return this.ratingView;
    }

    public View getDescriptionView() {
        return this.descriptionView;
    }

    public View getProviderView() {
        return this.providerView;
    }

    public View getIconView() {
        return this.iconView;
    }

    public NativeMediaView getMediaView() {
        return this.mediaView;
    }

    public Set<View> getClickableViews() {
        HashSet hashSet = new HashSet();
        Iterator<WeakReference<View>> it = this.clickableViewRefs.iterator();
        while (it.hasNext()) {
            View view = it.next().get();
            Objects.requireNonNull(hashSet);
            Utils.ifNotNull(view, new NativeAdContentLayout$$ExternalSyntheticLambda0(hashSet));
        }
        return hashSet;
    }

    private Set<View> getAllAvailableClickableViews() {
        final HashSet hashSet = new HashSet();
        View view = this.titleView;
        Objects.requireNonNull(hashSet);
        Utils.ifNotNull(view, new NativeAdContentLayout$$ExternalSyntheticLambda0(hashSet));
        View view2 = this.callToActionView;
        Objects.requireNonNull(hashSet);
        Utils.ifNotNull(view2, new NativeAdContentLayout$$ExternalSyntheticLambda0(hashSet));
        View view3 = this.ratingView;
        Objects.requireNonNull(hashSet);
        Utils.ifNotNull(view3, new NativeAdContentLayout$$ExternalSyntheticLambda0(hashSet));
        View view4 = this.descriptionView;
        Objects.requireNonNull(hashSet);
        Utils.ifNotNull(view4, new NativeAdContentLayout$$ExternalSyntheticLambda0(hashSet));
        View view5 = this.providerView;
        Objects.requireNonNull(hashSet);
        Utils.ifNotNull(view5, new NativeAdContentLayout$$ExternalSyntheticLambda0(hashSet));
        View view6 = this.iconView;
        Objects.requireNonNull(hashSet);
        Utils.ifNotNull(view6, new NativeAdContentLayout$$ExternalSyntheticLambda0(hashSet));
        NativeMediaView nativeMediaView = this.mediaView;
        Objects.requireNonNull(hashSet);
        Utils.ifNotNull(nativeMediaView, new Executable() { // from class: io.bidmachine.nativead.view.NativeAdContentLayout$$ExternalSyntheticLambda1
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                hashSet.add((NativeMediaView) obj);
            }
        });
        return hashSet;
    }

    public void bind(NativeAd ad) {
        if (ad == null || !ad.isLoaded()) {
            return;
        }
        View view = this.titleView;
        if (view instanceof TextView) {
            ((TextView) view).setText(ad.getTitle());
        }
        View view2 = this.descriptionView;
        if (view2 instanceof TextView) {
            ((TextView) view2).setText(ad.getDescription());
        }
        View view3 = this.ratingView;
        if (view3 instanceof RatingBar) {
            RatingBar ratingBar = (RatingBar) view3;
            if (ad.getRating() == -1.0f) {
                ratingBar.setVisibility(4);
            } else {
                ratingBar.setVisibility(0);
                ratingBar.setStepSize(0.1f);
                ratingBar.setRating(ad.getRating());
            }
        }
        View view4 = this.callToActionView;
        if (view4 instanceof TextView) {
            ((TextView) view4).setText(ad.getCallToAction());
        }
        if (this.providerView instanceof ViewGroup) {
            View providerView = ad.getProviderView(getContext());
            if (providerView instanceof NativeAdOverlayContainer) {
                providerView.setVisibility(8);
            } else if (providerView != null) {
                ViewHelper.removeViewFromParent(providerView);
                ((ViewGroup) this.providerView).addView(providerView, new ViewGroup.LayoutParams(-2, -2));
            }
        }
        NativePublicData adData = ad.getAdData();
        if (adData instanceof NativeData) {
            this.overlayContainer.bindNativeData((NativeData) adData);
        }
    }

    public void registerViewForInteraction(NativeAd nativeAd) {
        registerViewForInteraction(nativeAd, getAllAvailableClickableViews());
    }

    public void registerViewForInteraction(NativeAd nativeAd, Set<View> clickableViews) {
        if (nativeAd == null || !nativeAd.isLoaded()) {
            Logger.d("Native ad is not loaded. Please load it before registering");
            return;
        }
        if (clickableViews == null) {
            clickableViews = Collections.emptySet();
        }
        if (clickableViews.isEmpty()) {
            Logger.w("'registerViewForInteraction' called with empty 'clickableViews' list, native ad won't be interactive");
        }
        HashSet hashSet = new HashSet();
        Iterator<View> it = clickableViews.iterator();
        while (it.hasNext()) {
            hashSet.add(new WeakReference(it.next()));
        }
        unregisterViewForInteraction();
        this.clickableViewRefs = hashSet;
        this.currentAd = nativeAd;
        nativeAd.registerView(this, getIconView(), getMediaView(), clickableViews);
    }

    public void unregisterViewForInteraction() {
        NativeAd nativeAd = this.currentAd;
        if (nativeAd != null) {
            nativeAd.unregisterView();
        }
    }

    public void destroy() {
        NativeAd nativeAd = this.currentAd;
        if (nativeAd != null) {
            nativeAd.destroy();
        }
    }

    public boolean isRegistered() {
        NativeAd nativeAd = this.currentAd;
        return nativeAd != null && nativeAd.isViewRegistered();
    }
}
