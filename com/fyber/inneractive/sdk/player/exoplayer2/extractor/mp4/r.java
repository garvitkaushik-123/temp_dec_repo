package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4;

import android.support.v4.media.session.PlaybackStateCompat;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;

/* loaded from: classes4.dex */
public abstract class r {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f1455a = {z.a("isom"), z.a("iso2"), z.a("iso3"), z.a("iso4"), z.a("iso5"), z.a("iso6"), z.a("avc1"), z.a("hvc1"), z.a("hev1"), z.a("mp41"), z.a("mp42"), z.a("3g2a"), z.a("3g2b"), z.a("3gr6"), z.a("3gs6"), z.a("3ge6"), z.a("3gg6"), z.a("M4V "), z.a("M4A "), z.a("f4v "), z.a("kddi"), z.a("M4VP"), z.a("qt  "), z.a("MSNV")};

    public static boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar, boolean z) {
        boolean z2;
        int i;
        long j = bVar.b;
        if (j == -1 || j > PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            j = 4096;
        }
        int i2 = (int) j;
        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(64);
        boolean z3 = false;
        int i3 = 0;
        boolean z4 = false;
        while (i3 < i2) {
            nVar.c(8);
            bVar.a(nVar.f1591a, z3 ? 1 : 0, 8, z3);
            long k = nVar.k();
            int b = nVar.b();
            if (k == 1) {
                bVar.a(nVar.f1591a, 8, 8, z3);
                nVar.d(16);
                i = 16;
                k = nVar.n();
            } else {
                i = 8;
            }
            long j2 = i;
            if (k < j2) {
                return z3;
            }
            i3 += i;
            if (b != c.C) {
                if (b == c.L || b == c.N) {
                    z2 = true;
                    break;
                }
                long j3 = (i3 + k) - j2;
                boolean z5 = z3 ? 1 : 0;
                if (j3 >= i2) {
                    break;
                }
                int i4 = (int) (k - j2);
                i3 += i4;
                z4 = z4;
                if (b == c.b) {
                    if (i4 < 8) {
                        return z5;
                    }
                    nVar.c(i4);
                    bVar.a(nVar.f1591a, z5 ? 1 : 0, i4, z5);
                    int i5 = i4 / 4;
                    for (int i6 = 0; i6 < i5; i6++) {
                        if (i6 != 1) {
                            int b2 = nVar.b();
                            if ((b2 >>> 8) != z.a("3gp")) {
                                for (int i7 : f1455a) {
                                    if (i7 != b2) {
                                    }
                                }
                            }
                            z4 = true;
                            break;
                        }
                        nVar.e(nVar.b + 4);
                    }
                    z4 = z4;
                    if (!z4) {
                        return false;
                    }
                } else if (i4 != 0) {
                    bVar.a(i4, z5);
                    z4 = z4;
                }
                z3 = false;
            }
        }
        z2 = false;
        return z4 && z == z2;
    }
}
