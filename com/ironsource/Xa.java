package com.ironsource;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ironsource.mediationsdk.ads.nativead.LevelPlayMediaView;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdViewBinderInterface;
import com.ironsource.mediationsdk.ads.nativead.internal.NativeAdViewHolder;
import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Xa extends FrameLayout implements NativeAdViewBinderInterface {

    /* renamed from: a, reason: collision with root package name */
    private final NativeAdViewHolder f3130a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Xa(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f3130a = new NativeAdViewHolder();
    }

    public final void a(Ua nativeAd) {
        Intrinsics.checkNotNullParameter(nativeAd, "nativeAd");
        List<View> a2 = a(this);
        removeAllViews();
        FrameLayout frameLayout = new FrameLayout(getContext());
        a(frameLayout, a2);
        AdapterNativeAdViewBinder f = nativeAd.f();
        if (f != null) {
            f.setBodyView(this.f3130a.getBodyView());
            f.setMediaView(this.f3130a.getMediaView());
            f.setCallToActionView(this.f3130a.getCallToActionView());
            f.setTitleView(this.f3130a.getTitleView());
            f.setIconView(this.f3130a.getIconView());
            f.setAdvertiserView(this.f3130a.getAdvertiserView());
            f.setNativeAdView(frameLayout);
            addView(f.getNetworkNativeAdView());
        }
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdViewBinderInterface
    public void setAdvertiserView(View view) {
        this.f3130a.setAdvertiserView(view);
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdViewBinderInterface
    public void setBodyView(View view) {
        this.f3130a.setBodyView(view);
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdViewBinderInterface
    public void setCallToActionView(View view) {
        this.f3130a.setCallToActionView(view);
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdViewBinderInterface
    public void setIconView(View view) {
        this.f3130a.setIconView(view);
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdViewBinderInterface
    public void setMediaView(LevelPlayMediaView levelPlayMediaView) {
        this.f3130a.setMediaView(levelPlayMediaView);
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdViewBinderInterface
    public void setTitleView(View view) {
        this.f3130a.setTitleView(view);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Xa(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f3130a = new NativeAdViewHolder();
    }

    private final void a(ViewGroup viewGroup, List<? extends View> list) {
        Iterator<? extends View> it = list.iterator();
        while (it.hasNext()) {
            viewGroup.addView(it.next());
        }
    }

    private final List<View> a(ViewGroup viewGroup) {
        ArrayList arrayList = new ArrayList();
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = viewGroup.getChildAt(i);
            Intrinsics.checkNotNullExpressionValue(child, "child");
            arrayList.add(child);
        }
        return arrayList;
    }
}
