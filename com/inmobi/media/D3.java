package com.inmobi.media;

import com.inmobi.commons.core.configs.Config;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public abstract class D3 {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap f2258a = new HashMap();

    public static Config a(String str, String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        String b = b(str, type);
        HashMap hashMap = f2258a;
        Object obj = hashMap.get(b);
        if (obj == null) {
            Config.Companion.getClass();
            obj = G2.a(type, str);
            hashMap.put(b, obj);
        }
        return (Config) obj;
    }

    public static String b(String str, String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return str + '-' + type;
    }
}
