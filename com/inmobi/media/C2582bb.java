package com.inmobi.media;

import android.content.Context;
import com.android.billingclient.api.BillingClient;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.bb, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2582bb extends Lambda implements Function1 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2582bb() {
        super(1);
        String str = C2616db.f2549a;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        C6 c6;
        C2633eb c2633eb = (C2633eb) obj;
        String str = C2616db.f2549a;
        C2616db.d = 2;
        if (c2633eb == null) {
            C2894ub c2894ub = C2616db.b;
            if (c2894ub != null) {
                c2894ub.f2722a = null;
                BillingClient billingClient = c2894ub.b;
                if (billingClient != null) {
                    billingClient.endConnection();
                }
            }
            C2616db.b = null;
        } else {
            c2633eb.toString();
            JSONObject jSONObject = new JSONObject();
            int i = c2633eb.f2563a;
            if (i > 0) {
                jSONObject.put("p", i);
            }
            int i2 = c2633eb.b;
            if (i2 > 0) {
                jSONObject.put("s", i2);
            }
            String nipMapJSON = jSONObject.length() == 0 ? null : jSONObject.toString();
            if (nipMapJSON != null) {
                C2616db.f2549a = nipMapJSON;
                Intrinsics.checkNotNullParameter(nipMapJSON, "nipMapJSON");
                Intrinsics.checkNotNullParameter(nipMapJSON, "nipMapJSON");
                Context d = Uc.d();
                if (d != null) {
                    ConcurrentHashMap concurrentHashMap = C6.b;
                    c6 = B6.a(d, "purchase_store");
                } else {
                    c6 = null;
                }
                if (c6 != null) {
                    C6.a(c6, "purchase_pref", nipMapJSON, false, 4, (Object) null);
                }
            }
            C2894ub c2894ub2 = C2616db.b;
            if (c2894ub2 != null) {
                c2894ub2.f2722a = null;
                BillingClient billingClient2 = c2894ub2.b;
                if (billingClient2 != null) {
                    billingClient2.endConnection();
                }
            }
            C2616db.b = null;
        }
        return Unit.INSTANCE;
    }
}
