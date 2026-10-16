package com.fyber.inneractive.sdk.ui;

import com.fyber.inneractive.sdk.web.m;

/* loaded from: classes4.dex */
public final class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAmraidWebViewController f1744a;

    public f(IAmraidWebViewController iAmraidWebViewController) {
        this.f1744a = iAmraidWebViewController;
    }

    @Override // java.lang.Runnable
    public final void run() {
        m mVar = this.f1744a.b;
        if (mVar != null) {
            mVar.a("if (FyberMraidVideoController.getCurrentTime() < 0.2) { var ifr = document.createElement('iframe'); var container = document.body || document.documentElement; container.appendChild(ifr); ifr.setAttribute('sandbox', ''); ifr.setAttribute('style', 'position: fixed; bottom: -20px; border: none; visibility: hidden; height: 20px; z-index: -99999'); ifr.setAttribute('src','FyMraidVideo://fyMraidVideoAdPlaybackFailure'); console.log('dispatched closure event'); } else { console.log('video has progressed'); };");
        }
    }
}
