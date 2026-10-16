package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Y6 {

    /* renamed from: a, reason: collision with root package name */
    public final String f2492a;
    public final long b;
    public final int c;
    public final long d;
    public final boolean e;
    public final int f;

    public Y6(String fileName, long j, int i, long j2, boolean z, int i2) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        this.f2492a = fileName;
        this.b = j;
        this.c = i;
        this.d = j2;
        this.e = z;
        this.f = i2;
    }

    public /* synthetic */ Y6(String str, long j, int i, long j2, boolean z, int i2, int i3) {
        this(str, j, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0L : j2, (i3 & 16) != 0 ? false : z, (i3 & 32) != 0 ? 0 : i2);
    }
}
