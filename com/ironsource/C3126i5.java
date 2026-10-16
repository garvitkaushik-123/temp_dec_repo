package com.ironsource;

import java.util.Date;

/* renamed from: com.ironsource.i5, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3126i5 {

    /* renamed from: a, reason: collision with root package name */
    private long f3356a = new Date().getTime();

    public static long a(C3126i5 c3126i5) {
        if (c3126i5 == null) {
            return 0L;
        }
        return new Date().getTime() - c3126i5.f3356a;
    }
}
