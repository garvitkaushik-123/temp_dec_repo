package com.fyber.inneractive.sdk.player.cache;

import android.net.Uri;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class g implements com.fyber.inneractive.sdk.player.exoplayer2.upstream.h {

    /* renamed from: a, reason: collision with root package name */
    public Uri f1350a;

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final long a(com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar) {
        new CountDownLatch(1);
        new AtomicReference();
        this.f1350a = kVar.f1570a;
        throw null;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final void close() {
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final int read(byte[] bArr, int i, int i2) {
        return -1;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final Uri a() {
        return this.f1350a;
    }
}
