package com.fyber.inneractive.sdk.privacysandbox;

import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f1654a;

    public a(String str) {
        this.f1654a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IAlog.c("Registered source %s", this.f1654a);
    }
}
