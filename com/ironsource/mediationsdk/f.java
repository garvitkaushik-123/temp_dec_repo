package com.ironsource.mediationsdk;

import android.content.Context;
import com.ironsource.C3123i2;
import com.ironsource.C3241p2;
import com.ironsource.S1;
import com.ironsource.mediationsdk.e;
import java.net.URL;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class f implements g {

    /* renamed from: a, reason: collision with root package name */
    private final C3241p2 f3532a;
    private final String b;

    public f(C3241p2 settings, String sessionId) {
        Intrinsics.checkNotNullParameter(settings, "settings");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.f3532a = settings;
        this.b = sessionId;
    }

    @Override // com.ironsource.mediationsdk.g
    public e.a a(Context context, i auctionRequestParams, S1 auctionListener) throws JSONException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(auctionRequestParams, "auctionRequestParams");
        Intrinsics.checkNotNullParameter(auctionListener, "auctionListener");
        JSONObject a2 = a(context, auctionRequestParams);
        String a3 = this.f3532a.a(auctionRequestParams.s());
        return auctionRequestParams.s() ? new C3123i2(auctionListener, new URL(a3), a2, auctionRequestParams.t(), this.f3532a) : new e.a(auctionListener, new URL(a3), a2, auctionRequestParams.t(), this.f3532a);
    }

    @Override // com.ironsource.mediationsdk.g
    public boolean b() {
        return this.f3532a.g() > 0;
    }

    @Override // com.ironsource.mediationsdk.g
    public boolean a() {
        return this.f3532a.n();
    }

    private final JSONObject a(Context context, i iVar) throws JSONException {
        JSONObject a2 = d.b().a(iVar);
        Intrinsics.checkNotNullExpressionValue(a2, "getInstance().enrichToke…low(auctionRequestParams)");
        return a2;
    }
}
