package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import android.net.Uri;
import com.ironsource.C3040d4;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f1570a;
    public final long b;
    public final long c;
    public final long d;
    public final String e;
    public final int f;

    public k(Uri uri, long j, long j2, long j3, String str, int i) {
        if (j < 0) {
            throw new IllegalArgumentException();
        }
        if (j2 < 0) {
            throw new IllegalArgumentException();
        }
        if (j3 <= 0 && j3 != -1) {
            throw new IllegalArgumentException();
        }
        this.f1570a = uri;
        this.b = j;
        this.c = j2;
        this.d = j3;
        this.e = str;
        this.f = i;
    }

    public final String toString() {
        return "DataSpec[" + this.f1570a + ", " + Arrays.toString((byte[]) null) + ", " + this.b + ", " + this.c + ", " + this.d + ", " + this.e + ", " + this.f + C3040d4.i.e;
    }
}
