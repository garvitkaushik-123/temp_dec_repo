package com.ironsource.mediationsdk.ads.nativead;

import android.app.Activity;
import com.ironsource.C3260q4;
import com.ironsource.Ib;
import com.ironsource.Kb;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdInterface;
import com.ironsource.mediationsdk.ads.nativead.internal.InternalNativeAdListener;
import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.p;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class LevelPlayNativeAd implements NativeAdInterface, NativeAdDataInterface, InternalNativeAdListener {

    /* renamed from: a, reason: collision with root package name */
    private String f3494a;
    private Placement b;
    private LevelPlayNativeAdListener c;
    private Ib d;
    private AdapterNativeAdData e;
    private AdapterNativeAdViewBinder f;
    private final AtomicBoolean g;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private String f3495a;
        private LevelPlayNativeAdListener b;

        public final LevelPlayNativeAd build() {
            return new LevelPlayNativeAd(this, null);
        }

        public final LevelPlayNativeAdListener getMListener$mediationsdk_release() {
            return this.b;
        }

        public final String getMPlacementName$mediationsdk_release() {
            return this.f3495a;
        }

        public final void setMListener$mediationsdk_release(LevelPlayNativeAdListener levelPlayNativeAdListener) {
            this.b = levelPlayNativeAdListener;
        }

        public final void setMPlacementName$mediationsdk_release(String str) {
            this.f3495a = str;
        }

        public final Builder withActivity(Activity activity) {
            ContextProvider.getInstance().updateActivity(activity);
            IronLog.INTERNAL.verbose("activity is updated to: " + (activity != null ? activity.hashCode() : 0));
            return this;
        }

        public final Builder withListener(LevelPlayNativeAdListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.b = listener;
            return this;
        }

        public final Builder withPlacementName(String str) {
            this.f3495a = str;
            return this;
        }
    }

    public /* synthetic */ LevelPlayNativeAd(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LevelPlayNativeAd this$0) {
        Unit unit;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b();
        Ib ib = this$0.d;
        if (ib != null) {
            ib.a(this$0.b);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this$0.a();
        }
    }

    private final void b() {
        if (this.g.compareAndSet(false, true)) {
            Ib c = p.j().c();
            this.d = c;
            if (c != null) {
                c.a(this);
                Kb j = p.j().j(this.f3494a);
                Intrinsics.checkNotNullExpressionValue(j, "getInstance().getNativeAdPlacement(mPlacementName)");
                this.b = new Placement(j);
            }
        }
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdInterface
    public void destroyAd() {
        IronLog.API.info(String.valueOf(this));
        try {
            Ib ib = this.d;
            if (ib != null) {
                ib.M();
            }
        } catch (Throwable th) {
            C3260q4.d().a(th);
            IronLog.API.error("destroyNativeAd()");
        }
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface
    public String getAdvertiser() {
        AdapterNativeAdData adapterNativeAdData = this.e;
        if (adapterNativeAdData != null) {
            return adapterNativeAdData.getAdvertiser();
        }
        return null;
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface
    public String getBody() {
        AdapterNativeAdData adapterNativeAdData = this.e;
        if (adapterNativeAdData != null) {
            return adapterNativeAdData.getBody();
        }
        return null;
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface
    public String getCallToAction() {
        AdapterNativeAdData adapterNativeAdData = this.e;
        if (adapterNativeAdData != null) {
            return adapterNativeAdData.getCallToAction();
        }
        return null;
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface
    public NativeAdDataInterface.Image getIcon() {
        AdapterNativeAdData adapterNativeAdData = this.e;
        if (adapterNativeAdData != null) {
            return adapterNativeAdData.getIcon();
        }
        return null;
    }

    public final AdapterNativeAdViewBinder getNativeAdViewBinder() {
        return this.f;
    }

    public final UUID getObjectId() {
        Ib ib = this.d;
        if (ib != null) {
            return ib.k();
        }
        return null;
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface
    public String getTitle() {
        AdapterNativeAdData adapterNativeAdData = this.e;
        if (adapterNativeAdData != null) {
            return adapterNativeAdData.getTitle();
        }
        return null;
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdInterface
    public void loadAd() {
        IronLog.API.info(String.valueOf(this));
        String initError = p.j().b();
        Intrinsics.checkNotNullExpressionValue(initError, "initError");
        if (initError.length() <= 0) {
            IronSourceThreadManager.INSTANCE.getInitHandler().post(new Runnable() { // from class: com.ironsource.mediationsdk.ads.nativead.LevelPlayNativeAd$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    LevelPlayNativeAd.a(LevelPlayNativeAd.this);
                }
            });
            return;
        }
        LevelPlayNativeAdListener levelPlayNativeAdListener = this.c;
        if (levelPlayNativeAdListener != null) {
            levelPlayNativeAdListener.onAdLoadFailed(this, ErrorBuilder.buildInitFailedError("loadAd(): " + initError, IronSourceConstants.NATIVE_AD_UNIT));
        }
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.internal.InternalNativeAdListener
    public void onNativeAdClicked(final AdInfo adInfo) {
        IronLog.CALLBACK.info(String.valueOf(this));
        IronSourceThreadManager.postOnUiThreadTask$default(IronSourceThreadManager.INSTANCE, new Runnable() { // from class: com.ironsource.mediationsdk.ads.nativead.LevelPlayNativeAd$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                LevelPlayNativeAd.a(LevelPlayNativeAd.this, adInfo);
            }
        }, 0L, 2, null);
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.internal.InternalNativeAdListener
    public void onNativeAdImpression(final AdInfo adInfo) {
        IronLog.CALLBACK.info(String.valueOf(this));
        IronSourceThreadManager.postOnUiThreadTask$default(IronSourceThreadManager.INSTANCE, new Runnable() { // from class: com.ironsource.mediationsdk.ads.nativead.LevelPlayNativeAd$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                LevelPlayNativeAd.b(LevelPlayNativeAd.this, adInfo);
            }
        }, 0L, 2, null);
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.internal.InternalNativeAdListener
    public void onNativeAdLoadFailed(final IronSourceError ironSourceError) {
        IronLog.CALLBACK.info(String.valueOf(this));
        IronSourceThreadManager.postOnUiThreadTask$default(IronSourceThreadManager.INSTANCE, new Runnable() { // from class: com.ironsource.mediationsdk.ads.nativead.LevelPlayNativeAd$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                LevelPlayNativeAd.a(LevelPlayNativeAd.this, ironSourceError);
            }
        }, 0L, 2, null);
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.internal.InternalNativeAdListener
    public void onNativeAdLoaded(final AdInfo adInfo, final AdapterNativeAdData adapterNativeAdData, final AdapterNativeAdViewBinder nativeAdViewBinder) {
        Intrinsics.checkNotNullParameter(adapterNativeAdData, "adapterNativeAdData");
        Intrinsics.checkNotNullParameter(nativeAdViewBinder, "nativeAdViewBinder");
        IronLog.CALLBACK.info(String.valueOf(this));
        IronSourceThreadManager.postOnUiThreadTask$default(IronSourceThreadManager.INSTANCE, new Runnable() { // from class: com.ironsource.mediationsdk.ads.nativead.LevelPlayNativeAd$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                LevelPlayNativeAd.a(LevelPlayNativeAd.this, adapterNativeAdData, nativeAdViewBinder, adInfo);
            }
        }, 0L, 2, null);
    }

    public final void setListener(LevelPlayNativeAdListener levelPlayNativeAdListener) {
        this.c = levelPlayNativeAdListener;
    }

    private LevelPlayNativeAd(Builder builder) {
        this.g = new AtomicBoolean(false);
        this.f3494a = builder.getMPlacementName$mediationsdk_release();
        this.c = builder.getMListener$mediationsdk_release();
    }

    private final void a() {
        LevelPlayNativeAdListener levelPlayNativeAdListener = this.c;
        if (levelPlayNativeAdListener != null) {
            levelPlayNativeAdListener.onAdLoadFailed(this, ErrorBuilder.buildInitFailedError("init() has failed", IronSourceConstants.NATIVE_AD_UNIT));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LevelPlayNativeAd this$0, AdInfo adInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LevelPlayNativeAdListener levelPlayNativeAdListener = this$0.c;
        if (levelPlayNativeAdListener != null) {
            levelPlayNativeAdListener.onAdImpression(this$0, adInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LevelPlayNativeAd this$0, AdapterNativeAdData adapterNativeAdData, AdapterNativeAdViewBinder nativeAdViewBinder, AdInfo adInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapterNativeAdData, "$adapterNativeAdData");
        Intrinsics.checkNotNullParameter(nativeAdViewBinder, "$nativeAdViewBinder");
        this$0.e = adapterNativeAdData;
        this$0.f = nativeAdViewBinder;
        LevelPlayNativeAdListener levelPlayNativeAdListener = this$0.c;
        if (levelPlayNativeAdListener != null) {
            levelPlayNativeAdListener.onAdLoaded(this$0, adInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LevelPlayNativeAd this$0, IronSourceError ironSourceError) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LevelPlayNativeAdListener levelPlayNativeAdListener = this$0.c;
        if (levelPlayNativeAdListener != null) {
            levelPlayNativeAdListener.onAdLoadFailed(this$0, ironSourceError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LevelPlayNativeAd this$0, AdInfo adInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LevelPlayNativeAdListener levelPlayNativeAdListener = this$0.c;
        if (levelPlayNativeAdListener != null) {
            levelPlayNativeAdListener.onAdClicked(this$0, adInfo);
        }
    }
}
