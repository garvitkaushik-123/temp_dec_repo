package com.fyber.inneractive.sdk.ui;

import com.fyber.inneractive.sdk.web.m;

/* loaded from: classes4.dex */
public final class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAmraidWebViewController f1745a;

    public g(IAmraidWebViewController iAmraidWebViewController) {
        this.f1745a = iAmraidWebViewController;
    }

    @Override // java.lang.Runnable
    public final void run() {
        m mVar = this.f1745a.b;
        if (mVar != null) {
            try {
                mVar.invalidate();
            } catch (Throwable unused) {
            }
        }
    }
}
