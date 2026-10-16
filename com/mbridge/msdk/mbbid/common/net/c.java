package com.mbridge.msdk.mbbid.common.net;

import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.same.net.e;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import com.mbridge.msdk.tracker.network.g;
import java.util.List;
import org.json.JSONObject;

/* compiled from: BidResponseHandler.java */
/* loaded from: classes6.dex */
public abstract class c extends com.mbridge.msdk.foundation.same.net.c<JSONObject> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f4486a = "c";

    public c(String str, String str2) {
        this.unitId = str2;
        this.placementId = str;
    }

    private void a(List<g> list, JSONObject jSONObject) {
        int optInt = jSONObject.optInt("status");
        if (200 != optInt) {
            a(optInt, jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE));
            return;
        }
        BidResponsedEx parseBidResponsedEx = BidResponsedEx.parseBidResponsedEx(jSONObject.optJSONObject("data"), this.unitId);
        if (parseBidResponsedEx != null) {
            a(parseBidResponsedEx);
        } else {
            a(optInt, jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE));
        }
    }

    public abstract void a(int i, String str);

    public abstract void a(BidResponsedEx bidResponsedEx);

    @Override // com.mbridge.msdk.foundation.same.net.c, com.mbridge.msdk.foundation.same.net.b
    public void onError(com.mbridge.msdk.foundation.same.net.exception.a aVar) {
        p0.b(f4486a, "errorCode = " + aVar.f4288a);
        a(aVar.f4288a, com.mbridge.msdk.foundation.same.net.utils.a.a(aVar));
    }

    @Override // com.mbridge.msdk.foundation.same.net.c, com.mbridge.msdk.foundation.same.net.b
    public void onSuccess(e<JSONObject> eVar) {
        com.mbridge.msdk.foundation.same.net.toolbox.a aVar;
        super.onSuccess(eVar);
        if (eVar == null || (aVar = eVar.b) == null) {
            return;
        }
        a(aVar.b, eVar.c);
    }
}
