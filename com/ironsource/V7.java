package com.ironsource;

import com.ironsource.X7;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* loaded from: classes6.dex */
public class V7 extends X7.a<ISDemandOnlyInterstitialListener> implements ISDemandOnlyInterstitialListener {

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3093a;
        final /* synthetic */ ISDemandOnlyInterstitialListener b;

        a(String str, ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener) {
            this.f3093a = str;
            this.b = iSDemandOnlyInterstitialListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            V7.this.a(this.f3093a, "onInterstitialAdReady()");
            this.b.onInterstitialAdReady(this.f3093a);
        }
    }

    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3094a;
        final /* synthetic */ IronSourceError b;
        final /* synthetic */ ISDemandOnlyInterstitialListener c;

        b(String str, IronSourceError ironSourceError, ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener) {
            this.f3094a = str;
            this.b = ironSourceError;
            this.c = iSDemandOnlyInterstitialListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            V7.this.a(this.f3094a, "onInterstitialAdLoadFailed() error = " + this.b.getErrorMessage());
            this.c.onInterstitialAdLoadFailed(this.f3094a, this.b);
        }
    }

    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3095a;
        final /* synthetic */ ISDemandOnlyInterstitialListener b;

        c(String str, ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener) {
            this.f3095a = str;
            this.b = iSDemandOnlyInterstitialListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            V7.this.a(this.f3095a, "onInterstitialAdOpened()");
            this.b.onInterstitialAdOpened(this.f3095a);
        }
    }

    class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3096a;
        final /* synthetic */ IronSourceError b;
        final /* synthetic */ ISDemandOnlyInterstitialListener c;

        d(String str, IronSourceError ironSourceError, ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener) {
            this.f3096a = str;
            this.b = ironSourceError;
            this.c = iSDemandOnlyInterstitialListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            V7.this.a(this.f3096a, "onInterstitialAdShowFailed() error = " + this.b.getErrorMessage());
            this.c.onInterstitialAdShowFailed(this.f3096a, this.b);
        }
    }

    class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3097a;
        final /* synthetic */ ISDemandOnlyInterstitialListener b;

        e(String str, ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener) {
            this.f3097a = str;
            this.b = iSDemandOnlyInterstitialListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            V7.this.a(this.f3097a, "onInterstitialAdClicked()");
            this.b.onInterstitialAdClicked(this.f3097a);
        }
    }

    class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3098a;
        final /* synthetic */ ISDemandOnlyInterstitialListener b;

        f(String str, ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener) {
            this.f3098a = str;
            this.b = iSDemandOnlyInterstitialListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            V7.this.a(this.f3098a, "onInterstitialAdClosed()");
            this.b.onInterstitialAdClosed(this.f3098a);
        }
    }

    V7(ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener) {
        b(iSDemandOnlyInterstitialListener);
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener
    public void onInterstitialAdClicked(String str) {
        ISDemandOnlyInterstitialListener a2 = a();
        a(new e(str, a2), a2 != null);
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener
    public void onInterstitialAdClosed(String str) {
        ISDemandOnlyInterstitialListener a2 = a();
        a(new f(str, a2), a2 != null);
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener
    public void onInterstitialAdLoadFailed(String str, IronSourceError ironSourceError) {
        ISDemandOnlyInterstitialListener a2 = a();
        a(new b(str, ironSourceError, a2), a2 != null);
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener
    public void onInterstitialAdOpened(String str) {
        ISDemandOnlyInterstitialListener a2 = a();
        a(new c(str, a2), a2 != null);
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener
    public void onInterstitialAdReady(String str) {
        ISDemandOnlyInterstitialListener a2 = a();
        a(new a(str, a2), a2 != null);
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener
    public void onInterstitialAdShowFailed(String str, IronSourceError ironSourceError) {
        ISDemandOnlyInterstitialListener a2 = a();
        a(new d(str, ironSourceError, a2), a2 != null);
    }

    V7() {
    }
}
