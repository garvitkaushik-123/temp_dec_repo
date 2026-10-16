package com.inmobi.media;

import java.util.Calendar;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public abstract class Y4 {
    public static HashMap a() {
        String str;
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("mk-version", Vc.a());
            Boolean c = C2881te.f2715a.c();
            if (c != null) {
                hashMap.put("u-id-adt", c.booleanValue() ? "1" : "0");
            }
            hashMap.put("ts", String.valueOf(Calendar.getInstance().getTimeInMillis()));
            Calendar calendar = Calendar.getInstance();
            hashMap.put("tz", String.valueOf(calendar.get(16) + calendar.get(15)));
            Zc.f2508a.getClass();
            HashMap hashMap2 = new HashMap();
            if (Zc.e && (str = Zc.d) != null) {
                hashMap2.put("u-s-id", str);
            }
            hashMap.putAll(hashMap2);
            return hashMap;
        } catch (Exception unused) {
            Intrinsics.checkNotNullExpressionValue("Y4", "TAG");
            return hashMap;
        }
    }
}
