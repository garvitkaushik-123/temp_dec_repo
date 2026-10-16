package com.inmobi.media;

import com.inmobi.commons.core.configs.Config;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.a3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2556a3 {
    public static final /* synthetic */ int e = 0;

    /* renamed from: a, reason: collision with root package name */
    public final P9 f2514a;
    public final TreeMap b;
    public final LinkedHashMap c;
    public final R2 d;

    public C2556a3(U2 networkRequest, P9 mNetworkResponse) {
        char c;
        short s;
        Intrinsics.checkNotNullParameter(networkRequest, "networkRequest");
        Intrinsics.checkNotNullParameter(mNetworkResponse, "mNetworkResponse");
        this.f2514a = mNetworkResponse;
        TreeMap treeMap = new TreeMap(networkRequest.y);
        this.b = treeMap;
        this.c = new LinkedHashMap();
        I9 i9 = mNetworkResponse.d;
        Unit unit = null;
        if (i9 != null) {
            for (Map.Entry entry : treeMap.entrySet()) {
                Object value = entry.getValue();
                Intrinsics.checkNotNullExpressionValue(value, "<get-value>(...)");
                W2 w2 = new W2(null, (Config) value);
                w2.c = new R2((byte) 0, "Network error in fetching config.");
                LinkedHashMap linkedHashMap = this.c;
                Object key = entry.getKey();
                Intrinsics.checkNotNullExpressionValue(key, "<get-key>(...)");
                linkedHashMap.put(key, w2);
            }
            c = 3;
            s = 1;
            R2 r2 = new R2((byte) 0, i9.b);
            this.d = r2;
            Intrinsics.checkNotNullExpressionValue("a3", "TAG");
            byte b = r2.f2412a;
            String str = r2.b;
            Pair a2 = V2.a(this.b);
            Map mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i9.f2315a.f2658a)), TuplesKt.to("name", (List) a2.component1()), TuplesKt.to("lts", (List) a2.component2()), TuplesKt.to("networkType", L3.q()));
            Pd pd = Pd.f2401a;
            Pd.b("InvalidConfig", mutableMapOf, Td.f2443a);
            unit = Unit.INSTANCE;
        } else {
            c = 3;
            s = 1;
        }
        if (unit == null) {
            try {
                JSONObject jSONObject = new JSONObject(this.f2514a.a());
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                    Config config = (Config) this.b.get(next);
                    if (config != null) {
                        Intrinsics.checkNotNull(config);
                        W2 w22 = new W2(jSONObject2, config);
                        LinkedHashMap linkedHashMap2 = this.c;
                        Intrinsics.checkNotNull(next);
                        linkedHashMap2.put(next, w22);
                    }
                }
                Pair a3 = V2.a(this.b);
                List list = (List) a3.component1();
                List list2 = (List) a3.component2();
                Pair pair = TuplesKt.to("name", list);
                Pair pair2 = TuplesKt.to("lts", list2);
                Pair[] pairArr = new Pair[2];
                pairArr[0] = pair;
                pairArr[s] = pair2;
                Map mutableMapOf2 = MapsKt.mutableMapOf(pairArr);
                Pd pd2 = Pd.f2401a;
                Pd.b("ConfigFetched", mutableMapOf2, Td.f2443a);
            } catch (JSONException e2) {
                String localizedMessage = e2.getLocalizedMessage();
                if (localizedMessage == null) {
                    localizedMessage = "Exception while parsing config";
                } else {
                    Intrinsics.checkNotNull(localizedMessage);
                }
                R2 r22 = new R2((byte) 2, localizedMessage);
                this.d = r22;
                String str2 = r22.b;
                Pair a4 = V2.a(this.b);
                List list3 = (List) a4.component1();
                List list4 = (List) a4.component2();
                Pair pair3 = TuplesKt.to(IronSourceConstants.EVENTS_ERROR_CODE, Short.valueOf(s));
                Pair pair4 = TuplesKt.to("name", list3);
                Pair pair5 = TuplesKt.to("lts", list4);
                Pair pair6 = TuplesKt.to("networkType", L3.q());
                Pair[] pairArr2 = new Pair[4];
                pairArr2[0] = pair3;
                pairArr2[s] = pair4;
                pairArr2[2] = pair5;
                pairArr2[c] = pair6;
                Map mutableMapOf3 = MapsKt.mutableMapOf(pairArr2);
                Pd pd3 = Pd.f2401a;
                Pd.b("InvalidConfig", mutableMapOf3, Td.f2443a);
            }
        }
    }

    public final boolean a() {
        EnumC2790o4 enumC2790o4;
        I9 i9 = this.f2514a.d;
        if ((i9 != null ? i9.f2315a : null) == EnumC2790o4.i) {
            return true;
        }
        if (i9 == null || (enumC2790o4 = i9.f2315a) == null) {
            enumC2790o4 = EnumC2790o4.e;
        }
        int i = enumC2790o4.f2658a;
        return 500 <= i && i < 600;
    }
}
