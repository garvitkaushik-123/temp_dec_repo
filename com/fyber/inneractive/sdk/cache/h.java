package com.fyber.inneractive.sdk.cache;

import com.fyber.inneractive.sdk.network.e0;

/* loaded from: classes4.dex */
public final class h implements e0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f1041a;

    public h(j jVar) {
        this.f1041a = jVar;
    }

    @Override // com.fyber.inneractive.sdk.network.e0
    public final void a(Object obj, Exception exc, boolean z) {
        String str = (String) obj;
        if (str != null) {
            this.f1041a.d = str;
        }
    }
}
