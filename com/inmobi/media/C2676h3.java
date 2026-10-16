package com.inmobi.media;

import android.content.Context;
import com.inmobi.commons.core.configs.AdConfig;
import com.inmobi.commons.core.configs.Config;
import com.inmobi.commons.core.configs.SignalsConfig;
import com.ironsource.C3040d4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;

/* renamed from: com.inmobi.media.h3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2676h3 {

    /* renamed from: a, reason: collision with root package name */
    public static final C2676h3 f2585a;
    public static LinkedList b;
    public static LinkedList c;
    public static SignalsConfig d;
    public static AdConfig e;
    public static byte[] f;
    public static String g;

    static {
        List<String> emptyList;
        AdConfig.ContextualDataConfig contextualData;
        C2676h3 c2676h3 = new C2676h3();
        f2585a = c2676h3;
        LinkedList linkedList = new LinkedList();
        b = linkedList;
        Object clone = linkedList.clone();
        Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type java.util.LinkedList<com.inmobi.signals.contextualdata.EncryptedContextualData>");
        c = (LinkedList) clone;
        C2660g3 c2660g3 = new C2660g3();
        C2641f3 c2641f3 = new C2641f3();
        LinkedHashMap linkedHashMap = O2.f2380a;
        Config a2 = M2.a("signals", Uc.b(), c2660g3);
        d = a2 instanceof SignalsConfig ? (SignalsConfig) a2 : null;
        Config a3 = M2.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS, Uc.b(), c2641f3);
        e = a3 instanceof AdConfig ? (AdConfig) a3 : null;
        SignalsConfig signalsConfig = d;
        f = AbstractC2710j4.a(signalsConfig != null ? signalsConfig.getKA() : null);
        AdConfig adConfig = e;
        if (adConfig == null || (contextualData = adConfig.getContextualData()) == null || (emptyList = contextualData.getSkipFields()) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(C2692i3.j);
        arrayList.removeAll(emptyList);
        g = CollectionsKt.joinToString$default(arrayList, ",", null, null, 0, null, null, 62, null);
        c2676h3.b();
    }

    public static final void a() {
        AdConfig.ContextualDataConfig contextualData;
        AdConfig.ContextualDataConfig contextualData2;
        AdConfig.ContextualDataConfig contextualData3;
        Intrinsics.checkNotNull("h3");
        long currentTimeMillis = System.currentTimeMillis();
        AdConfig adConfig = e;
        int i = 0;
        long expiryTime = currentTimeMillis - (((adConfig == null || (contextualData3 = adConfig.getContextualData()) == null) ? 0 : contextualData3.getExpiryTime()) * 1000);
        AdConfig adConfig2 = e;
        a(expiryTime, (adConfig2 == null || (contextualData2 = adConfig2.getContextualData()) == null) ? 0 : contextualData2.getMaxAdRecords());
        Object clone = b.clone();
        Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type java.util.LinkedList<com.inmobi.signals.contextualdata.EncryptedContextualData>");
        c = (LinkedList) clone;
        AdConfig adConfig3 = e;
        if (adConfig3 != null && (contextualData = adConfig3.getContextualData()) != null) {
            i = contextualData.getMaxAdRecords();
        }
        Intrinsics.checkNotNull("h3");
        C2608d3 c2608d3 = (C2608d3) Nc.d.getValue();
        c2608d3.getClass();
        c2608d3.a("id NOT IN (SELECT id FROM ( SELECT id FROM c_data WHERE timestamp > " + expiryTime + " ORDER BY timestamp DESC LIMIT " + i + ") foo);", null);
    }

    public static String c() {
        AdConfig.ContextualDataConfig contextualData;
        Intrinsics.checkNotNull("h3");
        if (g.length() == 0) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        long currentTimeMillis = System.currentTimeMillis();
        AdConfig adConfig = e;
        long expiryTime = currentTimeMillis - (((adConfig == null || (contextualData = adConfig.getContextualData()) == null) ? 0 : contextualData.getExpiryTime()) * 1000);
        LinkedList linkedList = c;
        ArrayList arrayList = new ArrayList();
        for (Object obj : linkedList) {
            if (((C2693i4) obj).b >= expiryTime) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            jSONArray.put(StringsKt.trim((CharSequence) ((C2693i4) it.next()).f2595a).toString());
        }
        String jSONArray2 = jSONArray.toString();
        Intrinsics.checkNotNullExpressionValue(jSONArray2, "toString(...)");
        return jSONArray2;
    }

    public static boolean d() {
        boolean z;
        AdConfig.ContextualDataConfig contextualData;
        Context d2 = Uc.d();
        if (d2 != null) {
            ConcurrentHashMap concurrentHashMap = C6.b;
            C6 a2 = B6.a(d2, "c_data_store");
            Intrinsics.checkNotNullParameter("isEnabled", C3040d4.h.W);
            z = a2.f2249a.getBoolean("isEnabled", true);
        } else {
            z = true;
        }
        if (!z) {
            Intrinsics.checkNotNull("h3");
            return false;
        }
        AdConfig adConfig = e;
        boolean z2 = ((adConfig == null || (contextualData = adConfig.getContextualData()) == null) ? 1 : contextualData.getMaxAdRecords()) > 0;
        Intrinsics.checkNotNull("h3");
        return z2;
    }

    public final void b() {
        Context d2 = Uc.d();
        if (d2 != null) {
            Intrinsics.checkNotNull("h3");
            ConcurrentHashMap concurrentHashMap = C6.b;
            C6 a2 = B6.a(d2, "c_data_store");
            Context d3 = Uc.d();
            int i = 1;
            if (d3 != null) {
                C6 a3 = B6.a(d3, "c_data_store");
                Intrinsics.checkNotNullParameter("akv", C3040d4.h.W);
                i = a3.f2249a.getInt("akv", 1);
            }
            SignalsConfig signalsConfig = d;
            if (signalsConfig == null || signalsConfig.getVAK() != i) {
                Intrinsics.checkNotNull("h3");
                SignalsConfig signalsConfig2 = d;
                if (signalsConfig2 != null) {
                    i = signalsConfig2.getVAK();
                }
                C6.a(a2, "akv", i, false, 4, (Object) null);
                e();
            }
        }
    }

    public final void e() {
        synchronized (this) {
            Intrinsics.checkNotNull("h3");
            C2608d3 c2608d3 = (C2608d3) Nc.d.getValue();
            c2608d3.getClass();
            try {
                A3.a(c2608d3.f2433a, null, null);
            } catch (Exception unused) {
            }
            LinkedList linkedList = new LinkedList();
            b = linkedList;
            Object clone = linkedList.clone();
            Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type java.util.LinkedList<com.inmobi.signals.contextualdata.EncryptedContextualData>");
            c = (LinkedList) clone;
            Unit unit = Unit.INSTANCE;
        }
    }

    public static void a(long j, int i) {
        Intrinsics.checkNotNull("h3");
        for (int size = b.size(); size > i; size--) {
            b.remove();
        }
        Intrinsics.checkNotNull("h3");
        Iterator it = b.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            if (((C2693i4) next).b >= j) {
                return;
            } else {
                it.remove();
            }
        }
    }
}
