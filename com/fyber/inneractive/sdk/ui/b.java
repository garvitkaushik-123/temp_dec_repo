package com.fyber.inneractive.sdk.ui;

import android.graphics.Bitmap;
import com.fyber.inneractive.sdk.network.e0;

/* loaded from: classes4.dex */
public final class b implements e0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FyberAdIdentifierLocal f1740a;

    public b(FyberAdIdentifierLocal fyberAdIdentifierLocal) {
        this.f1740a = fyberAdIdentifierLocal;
    }

    @Override // com.fyber.inneractive.sdk.network.e0
    public final void a(Object obj, Exception exc, boolean z) {
        Bitmap bitmap = (Bitmap) obj;
        if (exc != null || bitmap == null) {
            return;
        }
        this.f1740a.r = bitmap;
    }
}
