package com.fyber.inneractive.sdk.measurement;

import com.fyber.inneractive.sdk.network.e0;

/* loaded from: classes4.dex */
public final class c implements e0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f1266a;

    public c(e eVar) {
        this.f1266a = eVar;
    }

    @Override // com.fyber.inneractive.sdk.network.e0
    public final void a(Object obj, Exception exc, boolean z) {
        String str = (String) obj;
        if (str != null) {
            this.f1266a.d = str;
        }
    }
}
