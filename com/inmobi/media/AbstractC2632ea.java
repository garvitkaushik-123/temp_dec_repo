package com.inmobi.media;

import android.os.Debug;
import com.inmobi.commons.core.configs.CrashConfig;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.ea, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC2632ea {

    /* renamed from: a, reason: collision with root package name */
    public static final CrashConfig f2562a;

    static {
        LinkedHashMap linkedHashMap = O2.f2380a;
        f2562a = (CrashConfig) AbstractC2808p5.a("crashReporting", "null cannot be cast to non-null type com.inmobi.commons.core.configs.CrashConfig", null);
        System.currentTimeMillis();
    }

    public static void a(JSONObject payload, boolean z, boolean z2, long j) {
        int i;
        int i2;
        long[] jArr;
        Intrinsics.checkNotNullParameter(payload, "payload");
        if (f2562a.getCrashConfig().getReportOOMInfo() && z) {
            AbstractC2822q3 crashType = z2 ? C2806p3.d : C2773n3.d;
            Intrinsics.checkNotNullParameter(crashType, "type");
            C6 a2 = V5.a();
            if (a2 != null) {
                String key = crashType.c;
                Intrinsics.checkNotNullParameter(key, "key");
                a2.a(crashType.c, a2.f2249a.getInt(key, 0) + 1, true);
            }
            Intrinsics.checkNotNullParameter(crashType, "crashType");
            C6 a3 = V5.a();
            if (a3 != null) {
                String key2 = crashType.f2678a;
                Intrinsics.checkNotNullParameter(key2, "key");
                long j2 = a3.f2249a.getLong(key2, 0L);
                String str = crashType.b;
                if (j2 == 0) {
                    a3.a(str, j, true);
                } else {
                    a3.a(str, j - j2, true);
                }
            }
            if (z2) {
                C2806p3 type = C2806p3.d;
                Intrinsics.checkNotNullParameter(type, "type");
                C6 a4 = V5.a();
                if (a4 != null) {
                    String key3 = type.c;
                    Intrinsics.checkNotNullParameter(key3, "key");
                    i = a4.f2249a.getInt(key3, 0);
                } else {
                    i = 0;
                }
                C2773n3 type2 = C2773n3.d;
                Intrinsics.checkNotNullParameter(type2, "type");
                C6 a5 = V5.a();
                if (a5 != null) {
                    String key4 = type2.c;
                    Intrinsics.checkNotNullParameter(key4, "key");
                    i2 = a5.f2249a.getInt(key4, 0);
                } else {
                    i2 = 0;
                }
                int i3 = i + i2;
                float f = i3 > 0 ? (i * 100.0f) / i3 : 0.0f;
                payload.put("inmobiOOMCount", i);
                payload.put("appOOMCount", i2);
                payload.put("appOomCrashInterval", V5.a(type2));
                payload.put("inmOOMCrashInterval", V5.a(type));
                payload.put("oomRatioInMobiToApp", Float.valueOf(f));
                if (L3.f2348a.H()) {
                    long j3 = 0;
                    long j4 = 0;
                    for (Map.Entry<String, String> entry : Debug.getRuntimeStats().entrySet()) {
                        String key5 = entry.getKey();
                        String value = entry.getValue();
                        if (Intrinsics.areEqual(key5, "art.gc.blocking-gc-count")) {
                            Intrinsics.checkNotNull(value);
                            Long longOrNull = StringsKt.toLongOrNull(value);
                            j3 = longOrNull != null ? longOrNull.longValue() : 0L;
                        } else if (Intrinsics.areEqual(key5, "art.gc.gc-count")) {
                            Intrinsics.checkNotNull(value);
                            Long longOrNull2 = StringsKt.toLongOrNull(value);
                            j4 = longOrNull2 != null ? longOrNull2.longValue() : 0L;
                        }
                    }
                    jArr = new long[]{j3, j4};
                } else {
                    jArr = null;
                }
                if (jArr != null) {
                    payload.put("blockingGcCount", jArr[0]);
                    payload.put("gcCount", jArr[1]);
                }
            }
        }
    }
}
