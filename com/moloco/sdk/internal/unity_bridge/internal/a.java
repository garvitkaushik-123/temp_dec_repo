package com.moloco.sdk.internal.unity_bridge.internal;

import android.os.Handler;
import android.os.Looper;
import com.moloco.sdk.internal.unity_bridge.MolocoUnityLoadCallback;
import com.moloco.sdk.internal.unity_bridge.MolocoUnityShowCallback;
import com.moloco.sdk.internal.unity_bridge.internal.a;
import com.moloco.sdk.publisher.AdLoad;
import com.moloco.sdk.publisher.InterstitialAd;
import com.moloco.sdk.publisher.InterstitialAdShowListener;
import com.moloco.sdk.publisher.MediationInfo;
import com.moloco.sdk.publisher.Moloco;
import com.moloco.sdk.publisher.MolocoAd;
import com.moloco.sdk.publisher.MolocoAdError;
import io.ktor.util.collections.ConcurrentMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class a {
    public static final int b = 8;

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentMap<String, InterstitialAd> f5738a = new ConcurrentMap<>(0, 1, null);

    /* renamed from: com.moloco.sdk.internal.unity_bridge.internal.a$a, reason: collision with other inner class name */
    public static final class C0461a implements AdLoad.Listener {
        public final /* synthetic */ String b;
        public final /* synthetic */ InterstitialAd c;
        public final /* synthetic */ Handler d;
        public final /* synthetic */ MolocoUnityLoadCallback e;

        public C0461a(String str, InterstitialAd interstitialAd, Handler handler, MolocoUnityLoadCallback molocoUnityLoadCallback) {
            this.b = str;
            this.c = interstitialAd;
            this.d = handler;
            this.e = molocoUnityLoadCallback;
        }

        public static final void a(MolocoUnityLoadCallback molocoUnityLoadCallback, String str) {
            molocoUnityLoadCallback.onAdLoadSuccess(str);
        }

        @Override // com.moloco.sdk.publisher.AdLoad.Listener
        public void onAdLoadFailed(final MolocoAdError molocoAdError) {
            Intrinsics.checkNotNullParameter(molocoAdError, "molocoAdError");
            Handler handler = this.d;
            final MolocoUnityLoadCallback molocoUnityLoadCallback = this.e;
            final String str = this.b;
            handler.post(new Runnable() { // from class: com.moloco.sdk.internal.unity_bridge.internal.a$a$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    a.C0461a.a(MolocoUnityLoadCallback.this, str, molocoAdError);
                }
            });
        }

        @Override // com.moloco.sdk.publisher.AdLoad.Listener
        public void onAdLoadSuccess(MolocoAd molocoAd) {
            Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
            a.this.f5738a.put(this.b, this.c);
            Handler handler = this.d;
            final MolocoUnityLoadCallback molocoUnityLoadCallback = this.e;
            final String str = this.b;
            handler.post(new Runnable() { // from class: com.moloco.sdk.internal.unity_bridge.internal.a$a$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    a.C0461a.a(MolocoUnityLoadCallback.this, str);
                }
            });
        }

        public static final void a(MolocoUnityLoadCallback molocoUnityLoadCallback, String str, MolocoAdError molocoAdError) {
            molocoUnityLoadCallback.onAdLoadFailed(str, molocoAdError.toString());
        }
    }

    public static final class b implements InterstitialAdShowListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Handler f5740a;
        public final /* synthetic */ MolocoUnityShowCallback b;

        public b(Handler handler, MolocoUnityShowCallback molocoUnityShowCallback) {
            this.f5740a = handler;
            this.b = molocoUnityShowCallback;
        }

        public static final void a(MolocoUnityShowCallback molocoUnityShowCallback, MolocoAdError molocoAdError) {
            molocoUnityShowCallback.onAdShowFailed(molocoAdError.getAdUnitId(), molocoAdError.toString());
        }

        public static final void b(MolocoUnityShowCallback molocoUnityShowCallback, MolocoAd molocoAd) {
            molocoUnityShowCallback.onAdHidden(molocoAd.getAdUnitId());
        }

        public static final void c(MolocoUnityShowCallback molocoUnityShowCallback, MolocoAd molocoAd) {
            molocoUnityShowCallback.onAdShowSuccess(molocoAd.getAdUnitId());
        }

        @Override // com.moloco.sdk.publisher.AdShowListener
        public void onAdClicked(final MolocoAd molocoAd) {
            Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
            Handler handler = this.f5740a;
            final MolocoUnityShowCallback molocoUnityShowCallback = this.b;
            handler.post(new Runnable() { // from class: com.moloco.sdk.internal.unity_bridge.internal.a$b$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    a.b.a(MolocoUnityShowCallback.this, molocoAd);
                }
            });
        }

        @Override // com.moloco.sdk.publisher.AdShowListener
        public void onAdHidden(final MolocoAd molocoAd) {
            Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
            Handler handler = this.f5740a;
            final MolocoUnityShowCallback molocoUnityShowCallback = this.b;
            handler.post(new Runnable() { // from class: com.moloco.sdk.internal.unity_bridge.internal.a$b$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    a.b.b(MolocoUnityShowCallback.this, molocoAd);
                }
            });
        }

        @Override // com.moloco.sdk.publisher.AdShowListener
        public void onAdShowFailed(final MolocoAdError molocoAdError) {
            Intrinsics.checkNotNullParameter(molocoAdError, "molocoAdError");
            Handler handler = this.f5740a;
            final MolocoUnityShowCallback molocoUnityShowCallback = this.b;
            handler.post(new Runnable() { // from class: com.moloco.sdk.internal.unity_bridge.internal.a$b$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    a.b.a(MolocoUnityShowCallback.this, molocoAdError);
                }
            });
        }

        @Override // com.moloco.sdk.publisher.AdShowListener
        public void onAdShowSuccess(final MolocoAd molocoAd) {
            Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
            Handler handler = this.f5740a;
            final MolocoUnityShowCallback molocoUnityShowCallback = this.b;
            handler.post(new Runnable() { // from class: com.moloco.sdk.internal.unity_bridge.internal.a$b$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    a.b.c(MolocoUnityShowCallback.this, molocoAd);
                }
            });
        }

        public static final void a(MolocoUnityShowCallback molocoUnityShowCallback, MolocoAd molocoAd) {
            molocoUnityShowCallback.onAdClicked(molocoAd.getAdUnitId());
        }
    }

    public final void a(String mediation, final String adUnitId, final String bidResponse, final MolocoUnityLoadCallback unityLoadCallback) {
        Intrinsics.checkNotNullParameter(mediation, "mediation");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(bidResponse, "bidResponse");
        Intrinsics.checkNotNullParameter(unityLoadCallback, "unityLoadCallback");
        final Handler a2 = a();
        Moloco.createInterstitial$default(new MediationInfo(mediation), adUnitId, null, new Function2() { // from class: com.moloco.sdk.internal.unity_bridge.internal.a$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return a.a(a2, this, adUnitId, bidResponse, unityLoadCallback, (InterstitialAd) obj, (MolocoAdError.AdCreateError) obj2);
            }
        }, 4, null);
    }

    public static final Unit a(Handler handler, a aVar, final String str, String str2, final MolocoUnityLoadCallback molocoUnityLoadCallback, InterstitialAd interstitialAd, final MolocoAdError.AdCreateError adCreateError) {
        if (adCreateError != null) {
            handler.post(new Runnable() { // from class: com.moloco.sdk.internal.unity_bridge.internal.a$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    a.a(MolocoUnityLoadCallback.this, str, adCreateError);
                }
            });
            return Unit.INSTANCE;
        }
        Intrinsics.checkNotNull(interstitialAd, "null cannot be cast to non-null type com.moloco.sdk.publisher.InterstitialAd");
        aVar.a(interstitialAd, str, str2, handler, molocoUnityLoadCallback);
        return Unit.INSTANCE;
    }

    public static final void a(MolocoUnityLoadCallback molocoUnityLoadCallback, String str, MolocoAdError.AdCreateError adCreateError) {
        molocoUnityLoadCallback.onAdLoadFailed(str, adCreateError.toString());
    }

    public final void a(final String adUnitId, final MolocoUnityShowCallback callback) {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Handler a2 = a();
        InterstitialAd interstitialAd = this.f5738a.get(adUnitId);
        if (interstitialAd != null && interstitialAd.isLoaded()) {
            interstitialAd.show(new b(a2, callback));
            return;
        }
        if (interstitialAd != null) {
            interstitialAd.destroy();
        }
        a2.post(new Runnable() { // from class: com.moloco.sdk.internal.unity_bridge.internal.a$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                a.a(MolocoUnityShowCallback.this, adUnitId);
            }
        });
    }

    public static final void a(MolocoUnityShowCallback molocoUnityShowCallback, String str) {
        molocoUnityShowCallback.onAdShowFailed(str, "Ad cannot be shown as it was not loaded");
    }

    public final void a(InterstitialAd interstitialAd, final String str, String str2, Handler handler, final MolocoUnityLoadCallback molocoUnityLoadCallback) {
        InterstitialAd interstitialAd2 = this.f5738a.get(str);
        if (interstitialAd2 != null) {
            if (interstitialAd2.isLoaded()) {
                handler.post(new Runnable() { // from class: com.moloco.sdk.internal.unity_bridge.internal.a$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.a(MolocoUnityLoadCallback.this, str);
                    }
                });
                return;
            }
            interstitialAd2.destroy();
        }
        interstitialAd.load(str2, new C0461a(str, interstitialAd, handler, molocoUnityLoadCallback));
    }

    public static final void a(MolocoUnityLoadCallback molocoUnityLoadCallback, String str) {
        molocoUnityLoadCallback.onAdLoadSuccess(str);
    }

    public final Handler a() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            return new Handler(myLooper);
        }
        throw new IllegalStateException("Can't create handler inside thread " + Thread.currentThread() + " that has not called Looper.prepare()");
    }
}
