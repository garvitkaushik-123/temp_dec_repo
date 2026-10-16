package com.inmobi.media;

import com.inmobi.commons.core.configs.SignalsConfig;
import com.inmobi.unifiedId.InMobiUnifiedIdInterface;
import com.inmobi.unifiedId.InMobiUnifiedIdService;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.ze, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC2980ze {
    /* JADX WARN: Removed duplicated region for block: B:37:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0147  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Ae a() {
        LinkedHashMap linkedHashMap = O2.f2380a;
        boolean enabled = ((SignalsConfig) AbstractC2808p5.a("signals", "null cannot be cast to non-null type com.inmobi.commons.core.configs.SignalsConfig", null)).getUnifiedIdServiceConfig().getEnabled();
        if (!enabled) {
            InMobiUnifiedIdService.reset();
        }
        if (!enabled) {
            return new Ae();
        }
        Boolean c = C2881te.f2715a.c();
        boolean booleanValue = c != null ? c.booleanValue() : true;
        if (booleanValue) {
            InMobiUnifiedIdService.reset();
        }
        if (booleanValue) {
            return new Ae();
        }
        HashMap hashMap = new HashMap();
        JSONObject a2 = Q5.a();
        Iterator<String> keys = a2 != null ? a2.keys() : null;
        if (keys != null) {
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("src", next);
                    jSONObject.put("envelope", a2.get(next));
                    Intrinsics.checkNotNull(next);
                    hashMap.put(next, jSONObject);
                } catch (JSONException e) {
                    StringsKt.trimMargin$default(" Error in looping through publisher provided unif id " + e.getMessage() + "  \n                                        " + a2.get(next), null, 1, null);
                }
            }
        }
        JSONObject b = Q5.b();
        boolean z = false;
        z = false;
        z = false;
        if (b != null) {
            try {
                if (b.has("ufids")) {
                    JSONArray jSONArray = b.getJSONArray("ufids");
                    int length = jSONArray.length();
                    boolean z2 = false;
                    boolean z3 = false;
                    for (int i = 0; i < length; i++) {
                        try {
                            String string = jSONArray.getJSONObject(i).has("src") ? jSONArray.getJSONObject(i).getString("src") : null;
                            String string2 = jSONArray.getJSONObject(i).has("envelope") ? jSONArray.getJSONObject(i).getString("envelope") : null;
                            if (System.currentTimeMillis() > jSONArray.getJSONObject(i).getLong("expiry")) {
                                z2 = true;
                            } else if (string != null && string2 != null) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("src", string);
                                jSONObject2.put("envelope", string2);
                                hashMap.put(string, jSONObject2);
                                z3 = true;
                            }
                        } catch (JSONException unused) {
                            z = z3;
                            b.toString();
                            if (!hashMap.isEmpty()) {
                            }
                        }
                    }
                    if (z2) {
                        InMobiUnifiedIdService.fetchUnifiedIdsInternal$media_release(null);
                    }
                    z = z3;
                }
            } catch (JSONException unused2) {
            }
        }
        if (!hashMap.isEmpty()) {
            return new Ae();
        }
        JSONArray jSONArray2 = new JSONArray();
        Iterator it = hashMap.values().iterator();
        while (it.hasNext()) {
            jSONArray2.put((JSONObject) it.next());
        }
        return new Ae(jSONArray2.toString(), z);
    }

    public static final void b(InMobiUnifiedIdInterface inMobiUnifiedIdInterface, JSONObject jSONObject, Error error) {
        if (inMobiUnifiedIdInterface != null) {
            inMobiUnifiedIdInterface.onFetchCompleted(jSONObject, error);
        }
    }

    public static void a(final InMobiUnifiedIdInterface inMobiUnifiedIdInterface, final JSONObject jSONObject, final Error error) {
        short s;
        String message = error != null ? error.getMessage() : null;
        if (Intrinsics.areEqual(message, InMobiUnifiedIdInterface.NETWORK_FAILURE_AND_NO_LOCAL_DATA_PRESENT)) {
            s = 93;
        } else {
            s = Intrinsics.areEqual(message, InMobiUnifiedIdInterface.NO_LOCAL_DATA_PRESENT) ? (short) 94 : (short) -1;
        }
        if (s >= 0) {
            Map mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to(IronSourceConstants.EVENTS_ERROR_CODE, Short.valueOf(s)));
            Pd pd = Pd.f2401a;
            Pd.b("FetchCallbackFailure", mutableMapOf, Td.f2443a);
        }
        Md.a(new Runnable() { // from class: com.inmobi.media.ze$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC2980ze.b(InMobiUnifiedIdInterface.this, jSONObject, error);
            }
        });
    }

    public static JSONObject a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        if (jSONObject != null) {
            try {
                if (jSONObject.has("ufids")) {
                    JSONArray jSONArray2 = jSONObject.getJSONArray("ufids");
                    int length = jSONArray2.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject3 = jSONArray2.getJSONObject(i);
                        if (System.currentTimeMillis() < jSONObject3.getLong("expiry")) {
                            jSONArray.put(jSONObject3);
                        }
                    }
                }
            } catch (JSONException unused) {
                return null;
            }
        }
        if (jSONArray.length() <= 0) {
            return null;
        }
        jSONObject2.put("ufids", jSONArray);
        return jSONObject2;
    }

    public static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject3 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        if (jSONObject2 != null) {
            try {
                if (jSONObject2.has("ufids")) {
                    JSONArray jSONArray2 = jSONObject2.getJSONArray("ufids");
                    int length = jSONArray2.length();
                    for (int i = 0; i < length; i++) {
                        String string = jSONArray2.getJSONObject(i).getString("src");
                        Intrinsics.checkNotNull(string);
                        JSONObject jSONObject4 = jSONArray2.getJSONObject(i);
                        Intrinsics.checkNotNullExpressionValue(jSONObject4, "getJSONObject(...)");
                        hashMap.put(string, jSONObject4);
                    }
                }
            } catch (JSONException unused) {
                Objects.toString(jSONObject2);
                Objects.toString(jSONObject);
                return jSONObject3;
            }
        }
        if (jSONObject != null && jSONObject.has("ufids")) {
            JSONArray jSONArray3 = jSONObject.getJSONArray("ufids");
            int length2 = jSONArray3.length();
            for (int i2 = 0; i2 < length2; i2++) {
                String string2 = jSONArray3.getJSONObject(i2).getString("src");
                Intrinsics.checkNotNull(string2);
                JSONObject jSONObject5 = jSONArray3.getJSONObject(i2);
                Intrinsics.checkNotNullExpressionValue(jSONObject5, "getJSONObject(...)");
                hashMap.put(string2, jSONObject5);
            }
        }
        Collection values = hashMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        Iterator it = values.iterator();
        while (it.hasNext()) {
            jSONArray.put((JSONObject) it.next());
        }
        jSONObject3.put("ufids", jSONArray);
        return jSONObject3;
    }
}
