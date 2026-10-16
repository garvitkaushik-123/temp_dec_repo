package com.fyber.inneractive.sdk.metrics;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;

/* loaded from: classes4.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f1274a;

    public a(String str) {
        this.f1274a = str;
    }

    public static boolean a(int i, int i2, JSONArray jSONArray, CopyOnWriteArrayList copyOnWriteArrayList) {
        if (i > 0 && i2 > 0) {
            long currentTimeMillis = System.currentTimeMillis() - TimeUnit.HOURS.toMillis(i);
            int i3 = 0;
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                long optLong = jSONArray.optLong(i4, 0L);
                if (optLong > currentTimeMillis) {
                    i3++;
                    copyOnWriteArrayList.add(Long.valueOf(optLong));
                }
            }
            if (i3 >= i2) {
                return true;
            }
        }
        return false;
    }
}
