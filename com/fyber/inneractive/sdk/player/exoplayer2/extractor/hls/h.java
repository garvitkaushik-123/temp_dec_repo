package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls;

import android.net.Uri;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.b0;
import com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.q;
import com.fyber.inneractive.sdk.player.exoplayer2.util.v;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import io.bidmachine.media3.exoplayer.hls.HlsMediaChunk;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public final class h extends com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.b {
    public static final AtomicInteger G = new AtomicInteger();
    public int A;
    public int B;
    public boolean C;
    public n D;
    public volatile boolean E;
    public volatile boolean F;
    public final int j;
    public final int k;
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a l;
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.h m;
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.k n;
    public final boolean o;
    public final boolean p;
    public final v q;
    public final String r;
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.i s;
    public final boolean t;
    public final boolean u;
    public final List v;
    public final boolean w;
    public final com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.n x;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n y;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.i z;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public h(com.fyber.inneractive.sdk.player.exoplayer2.upstream.h hVar, com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar, com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar2, com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a aVar, List list, int i, Object obj, long j, long j2, int i2, int i3, boolean z, v vVar, h hVar2, byte[] bArr, byte[] bArr2) {
        super(i, i2, j, j2, aVar.b, r8, kVar, obj);
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.h aVar2 = (bArr == null || bArr2 == null) ? hVar : new a(hVar, bArr, bArr2);
        this.k = i3;
        this.n = kVar2;
        this.l = aVar;
        this.v = list;
        this.p = z;
        this.q = vVar;
        this.o = aVar2 instanceof a;
        String lastPathSegment = kVar.f1570a.getLastPathSegment();
        this.r = lastPathSegment;
        boolean z2 = lastPathSegment.endsWith(".aac") || lastPathSegment.endsWith(".ac3") || lastPathSegment.endsWith(".ec3") || lastPathSegment.endsWith(".mp3");
        this.w = z2;
        if (hVar2 != null) {
            this.x = hVar2.x;
            this.y = hVar2.y;
            this.s = hVar2.z;
            boolean z3 = hVar2.l != aVar;
            this.t = z3;
            this.u = hVar2.k != i3 || z3;
        } else {
            this.x = z2 ? new com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.n() : null;
            this.y = z2 ? new com.fyber.inneractive.sdk.player.exoplayer2.util.n(10) : null;
            this.s = null;
            this.t = false;
            this.u = true;
        }
        this.m = hVar;
        this.j = G.getAndIncrement();
    }

    public final long a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar) {
        com.fyber.inneractive.sdk.player.exoplayer2.metadata.b a2;
        bVar.e = 0;
        if (!bVar.a(this.y.f1591a, 0, 10, true)) {
            return -9223372036854775807L;
        }
        this.y.c(10);
        if (this.y.l() != com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.n.b) {
            return -9223372036854775807L;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar = this.y;
        nVar.e(nVar.b + 3);
        int i = this.y.i();
        int i2 = i + 10;
        if (i2 > this.y.a()) {
            com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar2 = this.y;
            byte[] bArr = nVar2.f1591a;
            nVar2.c(i2);
            System.arraycopy(bArr, 0, this.y.f1591a, 0, 10);
        }
        if (!bVar.a(this.y.f1591a, 10, i, true) || (a2 = this.x.a(i, this.y.f1591a)) == null) {
            return -9223372036854775807L;
        }
        int length = a2.f1519a.length;
        for (int i3 = 0; i3 < length; i3++) {
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.o oVar = a2.f1519a[i3];
            if (oVar instanceof q) {
                q qVar = (q) oVar;
                if (HlsMediaChunk.PRIV_TIMESTAMP_FRAME_OWNER.equals(qVar.b)) {
                    System.arraycopy(qVar.c, 0, this.y.f1591a, 0, 8);
                    this.y.c(8);
                    return this.y.g();
                }
            }
        }
        return -9223372036854775807L;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.z
    public final void b() {
        this.E = true;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.a
    public final long c() {
        return this.B;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01ed A[Catch: all -> 0x0236, TryCatch #1 {all -> 0x0236, blocks: (B:116:0x01dc, B:118:0x01ed, B:120:0x01f5, B:121:0x01fe, B:122:0x01fc, B:124:0x0206, B:132:0x0224, B:137:0x0219, B:138:0x0223, B:128:0x020d, B:130:0x0211), top: B:115:0x01dc, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0206 A[Catch: all -> 0x0236, TRY_LEAVE, TryCatch #1 {all -> 0x0236, blocks: (B:116:0x01dc, B:118:0x01ed, B:120:0x01f5, B:121:0x01fe, B:122:0x01fc, B:124:0x0206, B:132:0x0224, B:137:0x0219, B:138:0x0223, B:128:0x020d, B:130:0x0211), top: B:115:0x01dc, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x020d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00f3  */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void load() {
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar;
        boolean z;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar2;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.i pVar;
        boolean z2;
        int i;
        String str;
        String str2;
        int i2 = 0;
        if (this.z == null && !this.w) {
            if ("text/vtt".equals(this.l.b.f) || this.r.endsWith(".webvtt") || this.r.endsWith(".vtt")) {
                pVar = new p(this.c.y, this.q);
            } else {
                if (this.u) {
                    if (!this.r.endsWith(".mp4")) {
                        if (!this.r.startsWith(".m4", r0.length() - 4)) {
                            List list = this.v;
                            if (list != null) {
                                i = 48;
                            } else {
                                list = Collections.emptyList();
                                i = 16;
                            }
                            String str3 = this.c.c;
                            if (!TextUtils.isEmpty(str3)) {
                                if (str3 != null) {
                                    for (String str4 : str3.split(",")) {
                                        str = com.fyber.inneractive.sdk.player.exoplayer2.util.i.a(str4);
                                        if (str != null && "audio".equals(com.fyber.inneractive.sdk.player.exoplayer2.util.i.b(str))) {
                                            break;
                                        }
                                    }
                                }
                                str = null;
                                if (!"audio/mp4a-latm".equals(str)) {
                                    i |= 2;
                                }
                                if (str3 != null) {
                                    for (String str5 : str3.split(",")) {
                                        str2 = com.fyber.inneractive.sdk.player.exoplayer2.util.i.a(str5);
                                        if (str2 != null && "video".equals(com.fyber.inneractive.sdk.player.exoplayer2.util.i.b(str2))) {
                                            break;
                                        }
                                    }
                                }
                                str2 = null;
                                if (!"video/avc".equals(str2)) {
                                    i |= 4;
                                }
                            }
                            b0 b0Var = new b0(2, this.q, new com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.e(i, list));
                            z2 = true;
                            pVar = b0Var;
                        }
                    }
                    pVar = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.m(this.q);
                } else {
                    pVar = this.s;
                    z2 = false;
                }
                if (z2) {
                    pVar.a(this.D);
                }
                this.z = pVar;
            }
            z2 = true;
            if (z2) {
            }
            this.z = pVar;
        }
        if (this.s != this.z && !this.C && (kVar2 = this.n) != null) {
            int i3 = this.A;
            int i4 = z.f1599a;
            if (i3 != 0) {
                long j = kVar2.d;
                long j2 = j == -1 ? -1L : j - i3;
                Uri uri = kVar2.f1570a;
                long j3 = i3 + kVar2.c;
                kVar2 = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.k(uri, j3, j3, j2, kVar2.e, kVar2.f);
            }
            try {
                com.fyber.inneractive.sdk.player.exoplayer2.upstream.h hVar = this.m;
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.b(hVar, kVar2.b, hVar.a(kVar2));
                int i5 = 0;
                while (i5 == 0) {
                    try {
                        if (this.E) {
                            break;
                        } else {
                            i5 = this.z.a(bVar, (com.fyber.inneractive.sdk.player.exoplayer2.extractor.o) null);
                        }
                    } finally {
                        this.A = (int) (bVar.c - this.n.b);
                    }
                }
                z.a(this.h);
                this.C = true;
            } finally {
            }
        }
        if (this.E) {
            return;
        }
        try {
            if (this.o) {
                kVar = this.f1529a;
                if (this.B != 0) {
                    z = true;
                    if (this.p) {
                        v vVar = this.q;
                        synchronized (vVar) {
                            while (vVar.c == -9223372036854775807L) {
                                vVar.wait();
                            }
                        }
                    } else {
                        v vVar2 = this.q;
                        if (vVar2.f1597a == Long.MAX_VALUE) {
                            vVar2.c(this.f);
                        }
                    }
                    com.fyber.inneractive.sdk.player.exoplayer2.upstream.h hVar2 = this.h;
                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar2 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.b(hVar2, kVar.b, hVar2.a(kVar));
                    if (this.z == null) {
                        long a2 = a(bVar2);
                        this.z = a(a2 != -9223372036854775807L ? this.q.b(a2) : this.f);
                    }
                    if (z) {
                        bVar2.a(this.B);
                    }
                    while (i2 == 0) {
                        try {
                            if (this.E) {
                                break;
                            } else {
                                i2 = this.z.a(bVar2, (com.fyber.inneractive.sdk.player.exoplayer2.extractor.o) null);
                            }
                        } finally {
                            this.B = (int) (bVar2.c - this.f1529a.b);
                        }
                    }
                    z.a(this.h);
                    this.F = true;
                    return;
                }
            } else {
                kVar = this.f1529a;
                int i6 = this.B;
                int i7 = z.f1599a;
                if (i6 != 0) {
                    long j4 = kVar.d;
                    long j5 = j4 != -1 ? j4 - i6 : -1L;
                    Uri uri2 = kVar.f1570a;
                    long j6 = i6 + kVar.c;
                    kVar = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.k(uri2, j6, j6, j5, kVar.e, kVar.f);
                }
            }
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.h hVar22 = this.h;
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar22 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.b(hVar22, kVar.b, hVar22.a(kVar));
            if (this.z == null) {
            }
            if (z) {
            }
            while (i2 == 0) {
            }
            z.a(this.h);
            this.F = true;
            return;
        } finally {
        }
        z = false;
        if (this.p) {
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.z
    public final boolean a() {
        return this.E;
    }

    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.i a(long j) {
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.i aVar;
        if (this.r.endsWith(".aac")) {
            aVar = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.c(j);
        } else if (!this.r.endsWith(".ac3") && !this.r.endsWith(".ec3")) {
            if (this.r.endsWith(".mp3")) {
                aVar = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3.c(j);
            } else {
                throw new IllegalArgumentException("Unkown extension for audio file: " + this.r);
            }
        } else {
            aVar = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.a(j);
        }
        aVar.a(this.D);
        return aVar;
    }
}
