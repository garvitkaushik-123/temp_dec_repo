package com.fyber.inneractive.sdk.player.exoplayer2.extractor;

import com.fyber.inneractive.sdk.player.exoplayer2.util.z;

/* loaded from: classes4.dex */
public final class a implements q {

    /* renamed from: a, reason: collision with root package name */
    public final long[] f1404a;
    public final long[] b;
    public final long c;

    public a(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f1404a = jArr;
        this.b = jArr3;
        int length = iArr.length;
        if (length <= 0) {
            this.c = 0L;
        } else {
            int i = length - 1;
            this.c = jArr2[i] + jArr3[i];
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.q
    public final boolean a() {
        return true;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.q
    public final long c() {
        return this.c;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.q
    public final long a(long j) {
        return this.f1404a[z.a(this.b, j, true)];
    }
}
