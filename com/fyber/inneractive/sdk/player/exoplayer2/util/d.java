package com.fyber.inneractive.sdk.player.exoplayer2.util;

import android.util.Pair;

/* loaded from: classes4.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f1583a = {0, 0, 0, 1};
    public static final int[] b = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    public static final int[] c = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static Pair a(byte[] bArr) {
        int i;
        int i2;
        m mVar = new m(bArr);
        int a2 = mVar.a(5);
        if (a2 == 31) {
            a2 = mVar.a(6) + 32;
        }
        int a3 = mVar.a(4);
        if (a3 == 15) {
            i = mVar.a(24);
        } else {
            if (a3 >= 13) {
                throw new IllegalArgumentException();
            }
            i = b[a3];
        }
        int a4 = mVar.a(4);
        if (a2 == 5 || a2 == 29) {
            int a5 = mVar.a(4);
            if (a5 == 15) {
                i2 = mVar.a(24);
            } else {
                if (a5 >= 13) {
                    throw new IllegalArgumentException();
                }
                i2 = b[a5];
            }
            i = i2;
            int a6 = mVar.a(5);
            if (a6 == 31) {
                a6 = mVar.a(6) + 32;
            }
            if (a6 == 22) {
                a4 = mVar.a(4);
            }
        }
        int i3 = c[a4];
        if (i3 != -1) {
            return Pair.create(Integer.valueOf(i), Integer.valueOf(i3));
        }
        throw new IllegalArgumentException();
    }
}
