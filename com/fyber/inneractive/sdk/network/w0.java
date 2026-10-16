package com.fyber.inneractive.sdk.network;

import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public final class w0 implements e0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f1341a;
    public final /* synthetic */ long b;

    public w0(String str, long j) {
        this.f1341a = str;
        this.b = j;
    }

    @Override // com.fyber.inneractive.sdk.network.e0
    public final void a(Object obj, Exception exc, boolean z) {
        String str = (String) obj;
        IAlog.a("Hit Request: Hitting URL finished: %s", this.f1341a);
        if (exc == null) {
            IAlog.a("Hit Request: Hitting URL response code: %s", str);
        } else {
            IAlog.a("Hit Request: Hitting URL failed: %s", exc);
        }
        IAlog.a("Hit Request: Url hit took %s millis", Long.valueOf(System.currentTimeMillis() - this.b));
    }
}
