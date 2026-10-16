package com.fyber.inneractive.sdk.web;

/* loaded from: classes4.dex */
public final class h1 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i1 f1803a;

    public h1(i1 i1Var) {
        this.f1803a = i1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        m mVar = this.f1803a.b;
        if (mVar != null) {
            mVar.a("if (FyberMraidVideoController.getCurrentTime() < 0.2) { var ifr = document.createElement('iframe'); var container = document.body || document.documentElement; container.appendChild(ifr); ifr.setAttribute('sandbox', ''); ifr.setAttribute('style', 'position: fixed; bottom: -20px; border: none; visibility: hidden; height: 20px; z-index: -99999'); ifr.setAttribute('src','FyMraidVideo://fyMraidVideoAdPlaybackFailure'); console.log('dispatched closure event'); } else { console.log('video has progressed'); };");
        }
    }
}
