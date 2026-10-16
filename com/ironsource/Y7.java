package com.ironsource;

import com.ironsource.X7;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* loaded from: classes6.dex */
public class Y7 extends X7.a<ISDemandOnlyRewardedVideoListener> implements ISDemandOnlyRewardedVideoListener {

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3142a;
        final /* synthetic */ ISDemandOnlyRewardedVideoListener b;

        a(String str, ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener) {
            this.f3142a = str;
            this.b = iSDemandOnlyRewardedVideoListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            Y7.this.a(this.f3142a, "onRewardedVideoAdLoadSuccess()");
            this.b.onRewardedVideoAdLoadSuccess(this.f3142a);
        }
    }

    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3143a;
        final /* synthetic */ IronSourceError b;
        final /* synthetic */ ISDemandOnlyRewardedVideoListener c;

        b(String str, IronSourceError ironSourceError, ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener) {
            this.f3143a = str;
            this.b = ironSourceError;
            this.c = iSDemandOnlyRewardedVideoListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            Y7.this.a(this.f3143a, "onRewardedVideoAdLoadFailed() error = " + this.b.getErrorMessage());
            this.c.onRewardedVideoAdLoadFailed(this.f3143a, this.b);
        }
    }

    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3144a;
        final /* synthetic */ ISDemandOnlyRewardedVideoListener b;

        c(String str, ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener) {
            this.f3144a = str;
            this.b = iSDemandOnlyRewardedVideoListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            Y7.this.a(this.f3144a, "onRewardedVideoAdOpened()");
            this.b.onRewardedVideoAdOpened(this.f3144a);
        }
    }

    class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3145a;
        final /* synthetic */ IronSourceError b;
        final /* synthetic */ ISDemandOnlyRewardedVideoListener c;

        d(String str, IronSourceError ironSourceError, ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener) {
            this.f3145a = str;
            this.b = ironSourceError;
            this.c = iSDemandOnlyRewardedVideoListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            Y7.this.a(this.f3145a, "onRewardedVideoAdShowFailed() error = " + this.b.getErrorMessage());
            this.c.onRewardedVideoAdShowFailed(this.f3145a, this.b);
        }
    }

    class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3146a;
        final /* synthetic */ ISDemandOnlyRewardedVideoListener b;

        e(String str, ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener) {
            this.f3146a = str;
            this.b = iSDemandOnlyRewardedVideoListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            Y7.this.a(this.f3146a, "onRewardedVideoAdClicked()");
            this.b.onRewardedVideoAdClicked(this.f3146a);
        }
    }

    class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3147a;
        final /* synthetic */ ISDemandOnlyRewardedVideoListener b;

        f(String str, ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener) {
            this.f3147a = str;
            this.b = iSDemandOnlyRewardedVideoListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            Y7.this.a(this.f3147a, "onRewardedVideoAdRewarded()");
            this.b.onRewardedVideoAdRewarded(this.f3147a);
        }
    }

    class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3148a;
        final /* synthetic */ ISDemandOnlyRewardedVideoListener b;

        g(String str, ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener) {
            this.f3148a = str;
            this.b = iSDemandOnlyRewardedVideoListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            Y7.this.a(this.f3148a, "onRewardedVideoAdClosed()");
            this.b.onRewardedVideoAdClosed(this.f3148a);
        }
    }

    Y7(ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener) {
        b(iSDemandOnlyRewardedVideoListener);
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener
    public void onRewardedVideoAdClicked(String str) {
        ISDemandOnlyRewardedVideoListener a2 = a();
        a(new e(str, a2), a2 != null);
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener
    public void onRewardedVideoAdClosed(String str) {
        ISDemandOnlyRewardedVideoListener a2 = a();
        a(new g(str, a2), a2 != null);
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener
    public void onRewardedVideoAdLoadFailed(String str, IronSourceError ironSourceError) {
        ISDemandOnlyRewardedVideoListener a2 = a();
        a(new b(str, ironSourceError, a2), a2 != null);
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener
    public void onRewardedVideoAdLoadSuccess(String str) {
        ISDemandOnlyRewardedVideoListener a2 = a();
        a(new a(str, a2), a2 != null);
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener
    public void onRewardedVideoAdOpened(String str) {
        ISDemandOnlyRewardedVideoListener a2 = a();
        a(new c(str, a2), a2 != null);
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener
    public void onRewardedVideoAdRewarded(String str) {
        ISDemandOnlyRewardedVideoListener a2 = a();
        a(new f(str, a2), a2 != null);
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener
    public void onRewardedVideoAdShowFailed(String str, IronSourceError ironSourceError) {
        ISDemandOnlyRewardedVideoListener a2 = a();
        a(new d(str, ironSourceError, a2), a2 != null);
    }

    Y7() {
    }
}
