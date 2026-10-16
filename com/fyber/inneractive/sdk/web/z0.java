package com.fyber.inneractive.sdk.web;

import android.util.LruCache;

/* loaded from: classes4.dex */
public final class z0 extends LruCache {
    public z0() {
        super(1048576);
    }

    @Override // android.util.LruCache
    public final int sizeOf(Object obj, Object obj2) {
        String str;
        c1 c1Var = (c1) obj2;
        int i = 0;
        for (String str2 : c1Var.b.keySet()) {
            if (str2 != null && (str = (String) c1Var.b.get(str2)) != null) {
                i += str.length() + str2.length();
            }
        }
        return i + c1Var.f1793a.length;
    }
}
