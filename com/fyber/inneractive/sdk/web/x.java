package com.fyber.inneractive.sdk.web;

import android.media.MediaScannerConnection;
import android.text.TextUtils;

/* loaded from: classes4.dex */
public final class x implements com.fyber.inneractive.sdk.network.e0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i0 f1829a;

    public x(i0 i0Var) {
        this.f1829a = i0Var;
    }

    @Override // com.fyber.inneractive.sdk.network.e0
    public final void a(Object obj, Exception exc, boolean z) {
        String str = (String) obj;
        if (exc != null || TextUtils.isEmpty(str)) {
            com.fyber.inneractive.sdk.util.r.b.post(new w(this));
            return;
        }
        i0 i0Var = this.f1829a;
        if (com.fyber.inneractive.sdk.util.o.a(i0Var.b) != null) {
            a0 a0Var = new a0(str);
            MediaScannerConnection mediaScannerConnection = new MediaScannerConnection(com.fyber.inneractive.sdk.util.o.a(i0Var.b).getApplicationContext(), a0Var);
            a0Var.b = mediaScannerConnection;
            mediaScannerConnection.connect();
        }
    }
}
