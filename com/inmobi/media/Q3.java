package com.inmobi.media;

import java.io.File;

/* loaded from: classes4.dex */
public final class Q3 {

    /* renamed from: a, reason: collision with root package name */
    public final String f2404a;
    public final long[] b;
    public boolean c;
    public P3 d;
    public final /* synthetic */ S3 e;

    public Q3(S3 s3, String str) {
        this.e = s3;
        this.f2404a = str;
        this.b = new long[s3.h];
    }

    public final File a(int i) {
        return new File(this.e.f2423a, this.f2404a + "." + i);
    }

    public final File b(int i) {
        return new File(this.e.f2423a, this.f2404a + "." + i + ".tmp");
    }
}
