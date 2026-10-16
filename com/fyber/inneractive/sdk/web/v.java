package com.fyber.inneractive.sdk.web;

import android.widget.Toast;

/* loaded from: classes4.dex */
public final class v implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f1825a;

    public v(String str) {
        this.f1825a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Toast.makeText(com.fyber.inneractive.sdk.util.o.f1770a, this.f1825a, 0).show();
    }
}
