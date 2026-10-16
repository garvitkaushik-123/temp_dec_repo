package com.mbridge.msdk.mbnative.cache;

import com.mbridge.msdk.out.Campaign;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: NativeCacheFactory.java */
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static Map<Integer, b<String, List<Campaign>>> f4491a = new HashMap();

    public static b<String, List<Campaign>> a(int i) {
        if (f4491a.containsKey(Integer.valueOf(i))) {
            return f4491a.get(Integer.valueOf(i));
        }
        a aVar = new a(i);
        f4491a.put(Integer.valueOf(i), aVar);
        return aVar;
    }
}
