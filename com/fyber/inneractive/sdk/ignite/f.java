package com.fyber.inneractive.sdk.ignite;

import com.fyber.inneractive.sdk.network.e0;
import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public final class f implements e0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f1257a;

    public f(String str) {
        this.f1257a = str;
    }

    @Override // com.fyber.inneractive.sdk.network.e0
    public final void a(Object obj, Exception exc, boolean z) {
        String str = (String) obj;
        IAlog.a("Hit Request: Hitting URL finished: %s", this.f1257a);
        if (exc == null) {
            IAlog.a("Hit Request: Hitting URL response code: %s", str);
        } else {
            IAlog.a("Hit Request: Hitting URL failed: %s", exc);
        }
    }
}
