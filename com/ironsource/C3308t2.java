package com.ironsource;

import com.ironsource.X7;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerListener;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* renamed from: com.ironsource.t2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3308t2 extends X7.a<ISDemandOnlyBannerListener> {

    /* renamed from: com.ironsource.t2$a */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3836a;
        final /* synthetic */ IronSourceError b;
        final /* synthetic */ ISDemandOnlyBannerListener c;

        a(String str, IronSourceError ironSourceError, ISDemandOnlyBannerListener iSDemandOnlyBannerListener) {
            this.f3836a = str;
            this.b = ironSourceError;
            this.c = iSDemandOnlyBannerListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3308t2.this.a(this.f3836a, "onBannerAdLoadFailed() error = " + this.b.getErrorMessage());
            this.c.onBannerAdLoadFailed(this.f3836a, this.b);
        }
    }

    /* renamed from: com.ironsource.t2$b */
    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3837a;
        final /* synthetic */ ISDemandOnlyBannerListener b;

        b(String str, ISDemandOnlyBannerListener iSDemandOnlyBannerListener) {
            this.f3837a = str;
            this.b = iSDemandOnlyBannerListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3308t2.this.a(this.f3837a, "onBannerAdLoaded()");
            this.b.onBannerAdLoaded(this.f3837a);
        }
    }

    /* renamed from: com.ironsource.t2$c */
    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3838a;
        final /* synthetic */ ISDemandOnlyBannerListener b;

        c(String str, ISDemandOnlyBannerListener iSDemandOnlyBannerListener) {
            this.f3838a = str;
            this.b = iSDemandOnlyBannerListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3308t2.this.a(this.f3838a, "onBannerAdShown()");
            this.b.onBannerAdShown(this.f3838a);
        }
    }

    /* renamed from: com.ironsource.t2$d */
    class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3839a;
        final /* synthetic */ ISDemandOnlyBannerListener b;

        d(String str, ISDemandOnlyBannerListener iSDemandOnlyBannerListener) {
            this.f3839a = str;
            this.b = iSDemandOnlyBannerListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3308t2.this.a(this.f3839a, "onBannerAdClicked()");
            this.b.onBannerAdClicked(this.f3839a);
        }
    }

    /* renamed from: com.ironsource.t2$e */
    class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3840a;
        final /* synthetic */ ISDemandOnlyBannerListener b;

        e(String str, ISDemandOnlyBannerListener iSDemandOnlyBannerListener) {
            this.f3840a = str;
            this.b = iSDemandOnlyBannerListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3308t2.this.a(this.f3840a, "onBannerAdLeftApplication()");
            this.b.onBannerAdLeftApplication(this.f3840a);
        }
    }

    public void a(String str, IronSourceError ironSourceError) {
        ISDemandOnlyBannerListener a2 = a();
        a(new a(str, ironSourceError, a2), a2 != null);
    }

    public void b(String str) {
        ISDemandOnlyBannerListener a2 = a();
        a(new e(str, a2), a2 != null);
    }

    public void c(String str) {
        ISDemandOnlyBannerListener a2 = a();
        a(new b(str, a2), a2 != null);
    }

    public void d(String str) {
        ISDemandOnlyBannerListener a2 = a();
        a(new c(str, a2), a2 != null);
    }

    public void a(String str) {
        ISDemandOnlyBannerListener a2 = a();
        a(new d(str, a2), a2 != null);
    }
}
