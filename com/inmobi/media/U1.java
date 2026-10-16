package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public abstract class U1 {

    /* renamed from: a, reason: collision with root package name */
    public String f2446a;
    public long b;
    public int c;
    public String d;

    public U1(String eventType, String str) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        this.f2446a = eventType;
        this.d = str;
        this.b = System.currentTimeMillis();
    }

    public final String a() {
        String str = this.d;
        return str == null ? "" : str;
    }
}
