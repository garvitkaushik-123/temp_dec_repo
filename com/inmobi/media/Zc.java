package com.inmobi.media;

import android.content.Context;
import android.os.Process;
import com.inmobi.commons.core.configs.SignalsConfig;
import com.ironsource.C3040d4;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class Zc {
    public static String d;
    public static boolean e;
    public static long f;
    public static final SignalsConfig.SessionConfig h;
    public static final AtomicBoolean i;
    public static final C6 j;
    public static final C2932x1 k;
    public static final C2932x1 l;
    public static final /* synthetic */ KProperty[] b = {Reflection.property1(new PropertyReference1Impl(Zc.class, "sessionCnt", "getSessionCnt()I", 0)), Reflection.property1(new PropertyReference1Impl(Zc.class, "userRetention", "getUserRetention()I", 0))};

    /* renamed from: a, reason: collision with root package name */
    public static final Zc f2508a = new Zc();
    public static final String c = "Zc";
    public static final List g = CollectionsKt.mutableListOf(0, 0, 0, 0);

    static {
        LinkedHashMap linkedHashMap = O2.f2380a;
        C6 c6 = null;
        h = ((SignalsConfig) AbstractC2808p5.a("signals", "null cannot be cast to non-null type com.inmobi.commons.core.configs.SignalsConfig", null)).getSession();
        i = new AtomicBoolean(false);
        Context d2 = Uc.d();
        if (d2 != null) {
            ConcurrentHashMap concurrentHashMap = C6.b;
            c6 = B6.a(d2, "session_pref_file");
        }
        j = c6;
        k = new C2932x1((Integer) (-1), (Function0) Xc.f2485a, false, 12);
        l = new C2932x1((Integer) (-1), (Function0) Yc.f2498a, false, 12);
    }

    public static int a() {
        C6 c6 = j;
        if (c6 == null) {
            return 0;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter("u-ret", C3040d4.h.W);
        return Integer.min((int) ((currentTimeMillis - c6.f2249a.getLong("u-ret", currentTimeMillis)) / 86400000), Integer.MAX_VALUE);
    }

    public static void c() {
        if (i.getAndSet(true)) {
            return;
        }
        LinkedHashMap linkedHashMap = O2.f2380a;
        if (((SignalsConfig) AbstractC2808p5.a("signals", "null cannot be cast to non-null type com.inmobi.commons.core.configs.SignalsConfig", null)).getIce().getSessionEnabled()) {
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
            d = uuid;
            String TAG = c;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        }
        f = System.currentTimeMillis() - Process.getElapsedCpuTime();
        SignalsConfig.SessionConfig sessionConfig = h;
        if (sessionConfig.getSigControlList().contains(5)) {
            C6 c6 = j;
            if (c6 != null) {
                Intrinsics.checkNotNullParameter("cnt", C3040d4.h.W);
                C6.a(c6, "cnt", Integer.min(c6.f2249a.getInt("cnt", 0) + 1, Integer.MAX_VALUE), false, 4, (Object) null);
            }
            k.a();
        }
        if (sessionConfig.getSigControlList().contains(6)) {
            C6 c62 = j;
            if (c62 != null) {
                Intrinsics.checkNotNullParameter("u-ret", C3040d4.h.W);
                if (!c62.f2249a.contains("u-ret")) {
                    C6.a(c62, "u-ret", System.currentTimeMillis(), false, 4, (Object) null);
                }
            }
            l.a();
        }
    }

    public final JSONObject b() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        SignalsConfig.SessionConfig sessionConfig = h;
        if (sessionConfig.getSigControlList().contains(0)) {
            linkedHashMap.put("st", Long.valueOf(f));
        }
        if (sessionConfig.getSigControlList().contains(5)) {
            C2932x1 c2932x1 = k;
            KProperty[] kPropertyArr = b;
            if (((Number) c2932x1.getValue(this, kPropertyArr[0])).intValue() != -1) {
                linkedHashMap.put("cnt", Integer.valueOf(((Number) c2932x1.getValue(this, kPropertyArr[0])).intValue()));
            }
        }
        if (sessionConfig.getSigControlList().contains(6)) {
            C2932x1 c2932x12 = l;
            KProperty[] kPropertyArr2 = b;
            if (((Number) c2932x12.getValue(this, kPropertyArr2[1])).intValue() != -1) {
                linkedHashMap.put("u-ret", Integer.valueOf(((Number) c2932x12.getValue(this, kPropertyArr2[1])).intValue()));
            }
        }
        List mutableList = CollectionsKt.toMutableList((Collection) g);
        if (!sessionConfig.getSigControlList().contains(1)) {
            mutableList.set(0, -1);
        }
        if (!sessionConfig.getSigControlList().contains(2)) {
            mutableList.set(1, -1);
        }
        if (!sessionConfig.getSigControlList().contains(3)) {
            mutableList.set(2, -1);
        }
        if (!sessionConfig.getSigControlList().contains(4)) {
            mutableList.set(3, -1);
        }
        if (!(mutableList instanceof Collection) || !mutableList.isEmpty()) {
            Iterator it = mutableList.iterator();
            while (it.hasNext()) {
                if (((Number) it.next()).intValue() != -1) {
                    linkedHashMap.put("dep", mutableList);
                    break;
                }
            }
        }
        try {
            return new JSONObject(linkedHashMap);
        } catch (Exception unused) {
            return new JSONObject();
        }
    }

    public static void a(String adtype, Boolean bool) {
        Intrinsics.checkNotNullParameter(adtype, "adtype");
        if (Intrinsics.areEqual(adtype, "banner") && h.getSigControlList().contains(1)) {
            List list = g;
            list.set(0, Integer.valueOf(Integer.min(((Number) list.get(0)).intValue() + 1, Integer.MAX_VALUE)));
        }
        if (Intrinsics.areEqual(adtype, "int") && !Intrinsics.areEqual(bool, Boolean.TRUE) && h.getSigControlList().contains(2)) {
            List list2 = g;
            list2.set(1, Integer.valueOf(Integer.min(((Number) list2.get(1)).intValue() + 1, Integer.MAX_VALUE)));
        }
        if (Intrinsics.areEqual(adtype, "native") && h.getSigControlList().contains(4)) {
            List list3 = g;
            list3.set(3, Integer.valueOf(Integer.min(((Number) list3.get(3)).intValue() + 1, Integer.MAX_VALUE)));
        }
        if (Intrinsics.areEqual(bool, Boolean.TRUE) && h.getSigControlList().contains(3)) {
            List list4 = g;
            list4.set(2, Integer.valueOf(Integer.min(((Number) list4.get(2)).intValue() + 1, Integer.MAX_VALUE)));
        }
    }
}
