package com.mbridge.msdk.thrid.okio;

import android.support.v4.media.session.PlaybackStateCompat;

/* compiled from: SegmentPool.java */
/* loaded from: classes6.dex */
final class p {

    /* renamed from: a, reason: collision with root package name */
    static o f4913a;
    static long b;

    private p() {
    }

    static o a() {
        synchronized (p.class) {
            o oVar = f4913a;
            if (oVar == null) {
                return new o();
            }
            f4913a = oVar.f;
            oVar.f = null;
            b -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            return oVar;
        }
    }

    static void a(o oVar) {
        if (oVar.f == null && oVar.g == null) {
            if (oVar.d) {
                return;
            }
            synchronized (p.class) {
                long j = b + PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                if (j > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                    return;
                }
                b = j;
                oVar.f = f4913a;
                oVar.c = 0;
                oVar.b = 0;
                f4913a = oVar;
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
