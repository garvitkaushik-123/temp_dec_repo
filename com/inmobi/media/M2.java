package com.inmobi.media;

import android.os.Message;
import com.inmobi.commons.core.configs.Config;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class M2 {
    public static void a() {
        if (O2.c.getAndSet(true)) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
        b();
        a("root", Uc.b(), null);
    }

    public static void b() {
        Lazy lazy;
        final ArrayList arrayList = new ArrayList();
        lazy = O2.f;
        Q2 q2 = (Q2) lazy.getValue();
        q2.getClass();
        for (Config config : CollectionsKt.filterNotNull(T1.a(q2, null, null, null, null, null, null, 63))) {
            ConcurrentHashMap concurrentHashMap = O2.e;
            LinkedHashMap linkedHashMap = O2.f2380a;
            Intrinsics.checkNotNullParameter(config, "<this>");
            HashMap hashMap = D3.f2258a;
            Config config2 = (Config) concurrentHashMap.put(D3.b(config.getAccountId$media_release(), config.getType()), config);
            if (config2 == null || config2.getLastUpdateTimeStamp() != config.getLastUpdateTimeStamp()) {
                Intrinsics.checkNotNullParameter(config, "<this>");
                arrayList.add(D3.b(config.getAccountId$media_release(), config.getType()));
            }
        }
        ((I2) O2.b.getValue()).post(new Runnable() { // from class: com.inmobi.media.M2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                M2.a(arrayList);
            }
        });
    }

    public static final void a(List changedConfigKeys) {
        Intrinsics.checkNotNullParameter(changedConfigKeys, "$changedConfigKeys");
        try {
            Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
            Iterator it = changedConfigKeys.iterator();
            while (it.hasNext()) {
                Config config = (Config) O2.e.get((String) it.next());
                if (config != null) {
                    LinkedHashMap linkedHashMap = O2.f2380a;
                    b(config);
                }
            }
        } catch (Exception unused) {
            Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0087 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0088 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Config a(String type, String str, N2 n2) {
        Config config;
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
        Objects.toString(n2);
        Config a2 = D3.a(str, type);
        if (str == null) {
            Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
            return a2;
        }
        Message obtainMessage = ((I2) O2.b.getValue()).obtainMessage();
        Intrinsics.checkNotNullExpressionValue(obtainMessage, "obtainMessage(...)");
        obtainMessage.what = 0;
        obtainMessage.obj = new S2(a2, n2);
        ((I2) O2.b.getValue()).sendMessage(obtainMessage);
        Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
        Objects.toString(a2);
        String accountId$media_release = a2.getAccountId$media_release();
        if (accountId$media_release != null) {
            LinkedHashMap linkedHashMap = O2.f2380a;
            String type2 = a2.getType();
            Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
            ConcurrentHashMap concurrentHashMap = O2.e;
            Intrinsics.checkNotNullParameter(type2, "<this>");
            config = (Config) concurrentHashMap.get(D3.b(accountId$media_release, type2));
            if (config != null) {
                Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
                config.getLastUpdateTimeStamp();
                return config != null ? a2 : config;
            }
        }
        config = null;
        if (config != null) {
        }
    }

    public static Config a(String accountId, String type) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
        ConcurrentHashMap concurrentHashMap = O2.e;
        Intrinsics.checkNotNullParameter(type, "<this>");
        Config config = (Config) concurrentHashMap.get(D3.b(accountId, type));
        Config config2 = null;
        if (config != null) {
            Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
            config.getLastUpdateTimeStamp();
        } else {
            config = null;
        }
        if (config != null) {
            return config;
        }
        lazy = O2.f;
        Q2 q2 = (Q2) lazy.getValue();
        q2.getClass();
        Intrinsics.checkNotNullParameter(type, "type");
        Config config3 = (Config) q2.b("account_id=? AND config_type=?", new String[]{accountId, type});
        if (config3 != null) {
            Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
            config3.toString();
            if (B2.a(config3.getAccountId$media_release()) && config3.getType().length() > 0) {
                Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
                ConcurrentHashMap concurrentHashMap2 = O2.e;
                LinkedHashMap linkedHashMap = O2.f2380a;
                Intrinsics.checkNotNullParameter(config3, "<this>");
                concurrentHashMap2.put(D3.b(config3.getAccountId$media_release(), config3.getType()), config3);
                b(config3);
            }
            config2 = config3;
        }
        Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
        if (config2 != null) {
            config2.getLastUpdateTimeStamp();
        }
        return config2;
    }

    public static void b(Config config) {
        Map map;
        Map map2;
        Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
        map = O2.f2380a;
        ArrayList arrayList = (ArrayList) map.get(config);
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                if (((WeakReference) next).get() == null) {
                    it.remove();
                }
            }
        }
        map2 = O2.f2380a;
        ArrayList arrayList2 = (ArrayList) map2.get(config);
        if (arrayList2 != null) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                N2 n2 = (N2) ((WeakReference) it2.next()).get();
                if (n2 != null) {
                    Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
                    n2.getClass().toString();
                    n2.a(config);
                }
            }
        }
    }

    public static Config a(String accountId) {
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        Intrinsics.checkNotNullParameter("root", "type");
        Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
        Config a2 = a(accountId, "root");
        return a2 == null ? D3.a(accountId, "root") : a2;
    }

    public static void a(Config config) {
        Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
        Message obtainMessage = ((I2) O2.b.getValue()).obtainMessage();
        Intrinsics.checkNotNullExpressionValue(obtainMessage, "obtainMessage(...)");
        obtainMessage.what = 1;
        obtainMessage.obj = config;
        ((I2) O2.b.getValue()).sendMessage(obtainMessage);
    }
}
