package com.inmobi.media;

import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public abstract class B6 {
    public static C6 a(Context context, String fileKey) {
        ConcurrentHashMap concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileKey, "fileKey");
        Intrinsics.checkNotNullParameter(fileKey, "fileKey");
        String str = "com.im.keyValueStore." + fileKey;
        concurrentHashMap = C6.b;
        C6 c6 = (C6) concurrentHashMap.get(str);
        if (c6 == null) {
            c6 = new C6(context, str);
            concurrentHashMap2 = C6.b;
            C6 c62 = (C6) concurrentHashMap2.putIfAbsent(str, c6);
            if (c62 != null) {
                return c62;
            }
        }
        return c6;
    }
}
