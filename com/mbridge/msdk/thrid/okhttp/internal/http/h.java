package com.mbridge.msdk.thrid.okhttp.internal.http;

import com.mbridge.msdk.thrid.okhttp.z;
import javax.annotation.Nullable;

/* compiled from: RealResponseBody.java */
/* loaded from: classes6.dex */
public final class h extends z {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final String f4838a;
    private final long b;
    private final com.mbridge.msdk.thrid.okio.e c;

    public h(@Nullable String str, long j, com.mbridge.msdk.thrid.okio.e eVar) {
        this.f4838a = str;
        this.b = j;
        this.c = eVar;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.z
    public long h() {
        return this.b;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.z
    public com.mbridge.msdk.thrid.okio.e k() {
        return this.c;
    }
}
