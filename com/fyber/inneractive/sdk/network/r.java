package com.fyber.inneractive.sdk.network;

/* loaded from: classes4.dex */
public final class r implements o0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f1335a;

    public r(s sVar) {
        this.f1335a = sVar;
    }

    @Override // com.fyber.inneractive.sdk.network.o0
    public final void a(String str) {
        str.hashCode();
        switch (str) {
            case "sdkInitNetworkRequest":
                com.fyber.inneractive.sdk.metrics.d.d.a(this.f1335a.d).f();
                break;
            case "sdkGotServerResponse":
                com.fyber.inneractive.sdk.metrics.d.d.a(this.f1335a.d).g();
                break;
            case "sdkParsedResponse":
                com.fyber.inneractive.sdk.metrics.d.d.a(this.f1335a.d).d();
                break;
        }
    }
}
