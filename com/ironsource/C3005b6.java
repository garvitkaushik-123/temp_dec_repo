package com.ironsource;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.ironsource.b6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3005b6 implements InterfaceC3318tc {

    /* renamed from: a, reason: collision with root package name */
    private InterfaceC3022c6 f3195a;
    private WeakReference<InterfaceC3042d6> b = new WeakReference<>(null);

    /* renamed from: com.ironsource.b6$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f3196a = new a();
        public static final String b = "impressions";

        private a() {
        }
    }

    public final void a(InterfaceC3022c6 loadListener) {
        Intrinsics.checkNotNullParameter(loadListener, "loadListener");
        this.f3195a = loadListener;
    }

    @Override // com.ironsource.InterfaceC3318tc
    public void onInterstitialAdRewarded(String str, int i) {
        InterfaceC3042d6 interfaceC3042d6 = this.b.get();
        if (interfaceC3042d6 != null) {
            interfaceC3042d6.onAdInstanceDidReward(str, i);
        }
    }

    @Override // com.ironsource.InterfaceC3318tc
    public void onInterstitialClick() {
        InterfaceC3042d6 interfaceC3042d6 = this.b.get();
        if (interfaceC3042d6 != null) {
            interfaceC3042d6.onAdInstanceDidClick();
        }
    }

    @Override // com.ironsource.InterfaceC3318tc
    public void onInterstitialClose() {
        InterfaceC3042d6 interfaceC3042d6 = this.b.get();
        if (interfaceC3042d6 != null) {
            interfaceC3042d6.onAdInstanceDidDismiss();
        }
    }

    @Override // com.ironsource.InterfaceC3318tc
    public void onInterstitialEventNotificationReceived(String str, JSONObject jSONObject) {
        InterfaceC3042d6 interfaceC3042d6;
        if (!Intrinsics.areEqual(str, "impressions") || (interfaceC3042d6 = this.b.get()) == null) {
            return;
        }
        interfaceC3042d6.onAdInstanceDidBecomeVisible();
    }

    @Override // com.ironsource.InterfaceC3318tc
    public void onInterstitialInitFailed(String str) {
    }

    @Override // com.ironsource.InterfaceC3318tc
    public void onInterstitialInitSuccess() {
    }

    @Override // com.ironsource.InterfaceC3318tc
    public void onInterstitialLoadFailed(String description) {
        Intrinsics.checkNotNullParameter(description, "description");
        InterfaceC3022c6 interfaceC3022c6 = this.f3195a;
        if (interfaceC3022c6 != null) {
            interfaceC3022c6.a(description);
        }
    }

    @Override // com.ironsource.InterfaceC3318tc
    public void onInterstitialLoadSuccess(B9 adInstance) {
        Intrinsics.checkNotNullParameter(adInstance, "adInstance");
        InterfaceC3022c6 interfaceC3022c6 = this.f3195a;
        if (interfaceC3022c6 != null) {
            interfaceC3022c6.a(adInstance);
        }
    }

    @Override // com.ironsource.InterfaceC3318tc
    public void onInterstitialOpen() {
        InterfaceC3042d6 interfaceC3042d6 = this.b.get();
        if (interfaceC3042d6 != null) {
            interfaceC3042d6.onAdInstanceDidShow();
        }
    }

    @Override // com.ironsource.InterfaceC3318tc
    public void onInterstitialShowFailed(String str) {
        InterfaceC3042d6 interfaceC3042d6 = this.b.get();
        if (interfaceC3042d6 != null) {
            interfaceC3042d6.a(str);
        }
    }

    @Override // com.ironsource.InterfaceC3318tc
    public void onInterstitialShowSuccess() {
    }

    public final void a(InterfaceC3042d6 showListener) {
        Intrinsics.checkNotNullParameter(showListener, "showListener");
        this.b = new WeakReference<>(showListener);
    }
}
