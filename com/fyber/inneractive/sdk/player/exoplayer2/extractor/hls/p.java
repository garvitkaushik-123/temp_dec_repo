package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.player.exoplayer2.r;
import com.fyber.inneractive.sdk.player.exoplayer2.util.v;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class p implements com.fyber.inneractive.sdk.player.exoplayer2.extractor.i {
    public static final Pattern g = Pattern.compile("LOCAL:([^,]+)");
    public static final Pattern h = Pattern.compile("MPEGTS:(\\d+)");

    /* renamed from: a, reason: collision with root package name */
    public final String f1422a;
    public final v b;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.j d;
    public int f;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n c = new com.fyber.inneractive.sdk.player.exoplayer2.util.n();
    public byte[] e = new byte[1024];

    public p(String str, v vVar) {
        this.f1422a = str;
        this.b = vVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar) {
        throw new IllegalStateException();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar) {
        this.d = jVar;
        jVar.a(new com.fyber.inneractive.sdk.player.exoplayer2.extractor.p(-9223372036854775807L));
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(long j, long j2) {
        throw new IllegalStateException();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final int a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.o oVar) {
        int min;
        Matcher matcher;
        String c;
        int i = (int) bVar.b;
        int i2 = this.f;
        byte[] bArr = this.e;
        if (i2 == bArr.length) {
            this.e = Arrays.copyOf(bArr, ((i != -1 ? i : bArr.length) * 3) / 2);
        }
        byte[] bArr2 = this.e;
        int i3 = this.f;
        int length = bArr2.length - i3;
        int i4 = bVar.f;
        if (i4 == 0) {
            min = 0;
        } else {
            min = Math.min(i4, length);
            System.arraycopy(bVar.d, 0, bArr2, i3, min);
            bVar.b(min);
        }
        if (min == 0) {
            min = bVar.a(bArr2, i3, length, 0, true);
        }
        if (min != -1) {
            bVar.c += min;
        }
        if (min != -1) {
            int i5 = this.f + min;
            this.f = i5;
            if (i == -1 || i5 != i) {
                return 0;
            }
        }
        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(this.e);
        try {
            Pattern pattern = com.fyber.inneractive.sdk.player.exoplayer2.text.webvtt.b.f1547a;
            String c2 = nVar.c();
            if (c2 == null || !com.fyber.inneractive.sdk.player.exoplayer2.text.webvtt.b.b.matcher(c2).matches()) {
                throw new com.fyber.inneractive.sdk.player.exoplayer2.text.a("Expected WEBVTT. Got " + c2);
            }
            long j = 0;
            long j2 = 0;
            while (true) {
                String c3 = nVar.c();
                if (TextUtils.isEmpty(c3)) {
                    while (true) {
                        String c4 = nVar.c();
                        if (c4 == null) {
                            matcher = null;
                            break;
                        }
                        if (com.fyber.inneractive.sdk.player.exoplayer2.text.webvtt.b.f1547a.matcher(c4).matches()) {
                            do {
                                c = nVar.c();
                                if (c != null) {
                                }
                            } while (!c.isEmpty());
                        } else {
                            matcher = com.fyber.inneractive.sdk.player.exoplayer2.text.webvtt.a.f1546a.matcher(c4);
                            if (matcher.matches()) {
                                break;
                            }
                        }
                    }
                    if (matcher == null) {
                        this.d.a(0, 3).a(com.fyber.inneractive.sdk.player.exoplayer2.o.a(null, "text/vtt", 0, this.f1422a, -1, null, 0L, Collections.emptyList()));
                        this.d.b();
                    } else {
                        long a2 = com.fyber.inneractive.sdk.player.exoplayer2.text.webvtt.b.a(matcher.group(1));
                        long a3 = this.b.a((j2 + a2) - j);
                        com.fyber.inneractive.sdk.player.exoplayer2.extractor.g a4 = this.d.a(0, 3);
                        a4.a(com.fyber.inneractive.sdk.player.exoplayer2.o.a(null, "text/vtt", 0, this.f1422a, -1, null, a3 - a2, Collections.emptyList()));
                        this.d.b();
                        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar2 = this.c;
                        byte[] bArr3 = this.e;
                        int i6 = this.f;
                        nVar2.f1591a = bArr3;
                        nVar2.c = i6;
                        nVar2.b = 0;
                        a4.a(i6, nVar2);
                        a4.a(a3, 1, this.f, 0, (byte[]) null);
                    }
                    return -1;
                }
                if (c3.startsWith("X-TIMESTAMP-MAP")) {
                    Matcher matcher2 = g.matcher(c3);
                    if (matcher2.find()) {
                        Matcher matcher3 = h.matcher(c3);
                        if (matcher3.find()) {
                            long a5 = com.fyber.inneractive.sdk.player.exoplayer2.text.webvtt.b.a(matcher2.group(1));
                            j2 = (Long.parseLong(matcher3.group(1)) * 1000000) / 90000;
                            j = a5;
                        } else {
                            throw new r("X-TIMESTAMP-MAP doesn't contain media timestamp: ".concat(c3));
                        }
                    } else {
                        throw new r("X-TIMESTAMP-MAP doesn't contain local timestamp: ".concat(c3));
                    }
                }
            }
        } catch (com.fyber.inneractive.sdk.player.exoplayer2.text.a e) {
            throw new r(e);
        }
    }
}
