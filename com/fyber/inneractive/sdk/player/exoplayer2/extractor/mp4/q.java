package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4;

import android.util.Log;
import android.util.Pair;
import java.util.UUID;

/* loaded from: classes4.dex */
public abstract class q {
    /* JADX WARN: Removed duplicated region for block: B:17:0x007b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static UUID a(byte[] bArr) {
        Pair pair;
        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(bArr);
        if (nVar.c >= 32) {
            nVar.e(0);
            if (nVar.b() == (nVar.c - nVar.b) + 4 && nVar.b() == c.V) {
                int b = (nVar.b() >> 24) & 255;
                if (b > 1) {
                    Log.w("PsshAtomUtil", "Unsupported pssh version: " + b);
                } else {
                    UUID uuid = new UUID(nVar.g(), nVar.g());
                    if (b == 1) {
                        nVar.e(nVar.b + (nVar.m() * 16));
                    }
                    int m = nVar.m();
                    if (m == nVar.c - nVar.b) {
                        byte[] bArr2 = new byte[m];
                        nVar.a(bArr2, 0, m);
                        pair = Pair.create(uuid, bArr2);
                        if (pair != null) {
                            return null;
                        }
                        return (UUID) pair.first;
                    }
                }
            }
        }
        pair = null;
        if (pair != null) {
        }
    }
}
