package com.inmobi.media;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.l2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2740l2 {

    /* renamed from: a, reason: collision with root package name */
    public final int f2628a;
    public final String b;
    public final Map c;
    public final boolean d;
    public final boolean e;
    public int f;
    public long g;
    public final long h;
    public final AtomicBoolean i;

    public C2740l2(int i, String url, Map map, boolean z, boolean z2, int i2, long j, long j2) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.f2628a = i;
        this.b = url;
        this.c = map;
        this.d = z;
        this.e = z2;
        this.f = i2;
        this.g = j;
        this.h = j2;
        this.i = new AtomicBoolean(false);
    }

    public /* synthetic */ C2740l2(String str, Map map, boolean z, boolean z2, int i, int i2) {
        this(new Random().nextInt() & Integer.MAX_VALUE, str, (i2 & 4) != 0 ? null : map, z, z2, i, System.currentTimeMillis(), System.currentTimeMillis());
    }
}
