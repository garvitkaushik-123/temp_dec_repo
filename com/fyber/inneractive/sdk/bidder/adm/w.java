package com.fyber.inneractive.sdk.bidder.adm;

import com.fyber.inneractive.sdk.network.o0;

/* loaded from: classes4.dex */
public final class w implements o0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f1027a;

    public w(y yVar) {
        this.f1027a = yVar;
    }

    @Override // com.fyber.inneractive.sdk.network.o0
    public final void a(String str) {
        str.hashCode();
        switch (str) {
            case "sdkInitNetworkRequest":
                com.fyber.inneractive.sdk.metrics.d dVar = com.fyber.inneractive.sdk.metrics.d.d;
                dVar.a(this.f1027a.d).f();
                dVar.b(this.f1027a.d).c = System.currentTimeMillis();
                break;
            case "sdkGotServerResponse":
                com.fyber.inneractive.sdk.metrics.d.d.a(this.f1027a.d).h();
                break;
            case "sdkParsedResponse":
                com.fyber.inneractive.sdk.metrics.d.d.a(this.f1027a.d).d();
                break;
            case "sdkRequestEndedButWillBeRetried":
                com.fyber.inneractive.sdk.metrics.i b = com.fyber.inneractive.sdk.metrics.d.d.b(this.f1027a.d);
                b.f1279a.put(new com.fyber.inneractive.sdk.metrics.h("retrying"), Long.valueOf(System.currentTimeMillis() - b.c));
                break;
        }
    }
}
