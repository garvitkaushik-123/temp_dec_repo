package com.fyber.inneractive.sdk.network;

import okhttp3.Response;

/* loaded from: classes4.dex */
public final class m1 extends l {
    public final Response g;

    public m1(l lVar, Response response) {
        this.g = response;
        this.d = lVar.d;
        this.c = lVar.c;
        this.e = lVar.e;
        this.f1328a = lVar.f1328a;
    }

    @Override // com.fyber.inneractive.sdk.network.l
    public final void a() {
        super.a();
        Response response = this.g;
        if (response != null) {
            response.close();
        }
    }
}
