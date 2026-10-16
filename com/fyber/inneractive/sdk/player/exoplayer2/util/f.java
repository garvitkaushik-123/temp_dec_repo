package com.fyber.inneractive.sdk.player.exoplayer2.util;

/* loaded from: classes4.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final int f1585a;
    public final int b;
    public final int c;
    public final long d;

    public f(byte[] bArr) {
        m mVar = new m(bArr);
        mVar.b(136);
        mVar.a(16);
        mVar.a(16);
        mVar.a(24);
        mVar.a(24);
        this.f1585a = mVar.a(20);
        this.b = mVar.a(3) + 1;
        this.c = mVar.a(5) + 1;
        this.d = ((mVar.a(4) & 15) << 32) | (mVar.a(32) & 4294967295L);
    }
}
