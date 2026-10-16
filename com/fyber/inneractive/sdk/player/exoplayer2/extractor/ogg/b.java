package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg;

import io.bidmachine.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import java.io.EOFException;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class b implements h {

    /* renamed from: a, reason: collision with root package name */
    public final g f1463a = new g();
    public final long b;
    public final long c;
    public final l d;
    public int e;
    public long f;
    public long g;
    public long h;
    public long i;
    public long j;
    public long k;
    public long l;

    public b(long j, long j2, l lVar, int i, long j3) {
        if (j < 0 || j2 <= j) {
            throw new IllegalArgumentException();
        }
        this.d = lVar;
        this.b = j;
        this.c = j2;
        if (i != j2 - j) {
            this.e = 0;
        } else {
            this.f = j3;
            this.e = 3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00d4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d5  */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar) {
        long j;
        g gVar;
        long j2;
        long j3;
        long j4;
        long j5;
        int i;
        int i2 = this.e;
        long j6 = 0;
        if (i2 == 0) {
            j = 0;
            long j7 = bVar.c;
            this.g = j7;
            this.e = 1;
            long j8 = this.c - 65307;
            if (j8 > j7) {
                return j8;
            }
        } else {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        return -1L;
                    }
                    throw new IllegalStateException();
                }
                long j9 = this.h;
                if (j9 == 0) {
                    i = 3;
                    j2 = 2;
                } else {
                    long j10 = this.i;
                    long j11 = this.j;
                    if (j10 == j11) {
                        j5 = this.k;
                    } else {
                        long j12 = bVar.c;
                        if (a(bVar, j11)) {
                            this.f1463a.a(bVar, false);
                            bVar.e = 0;
                            g gVar2 = this.f1463a;
                            long j13 = gVar2.b;
                            long j14 = j9 - j13;
                            int i3 = gVar2.d + gVar2.e;
                            if (j14 < 0 || j14 > 72000) {
                                if (j14 < 0) {
                                    this.j = j12;
                                    this.l = j13;
                                    j2 = 2;
                                } else {
                                    j2 = 2;
                                    long j15 = i3;
                                    long j16 = bVar.c + j15;
                                    this.i = j16;
                                    this.k = j13;
                                    if ((this.j - j16) + j15 < SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US) {
                                        bVar.a(i3);
                                        j3 = -(this.k + 2);
                                        j4 = 0;
                                        if (j3 < j4) {
                                        }
                                    }
                                }
                                long j17 = this.j;
                                long j18 = this.i;
                                long j19 = j17 - j18;
                                if (j19 < SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US) {
                                    this.j = j18;
                                    j4 = 0;
                                    j3 = j18;
                                } else {
                                    j4 = 0;
                                    j3 = Math.min(Math.max(((j19 * j14) / (this.l - this.k)) + (bVar.c - (i3 * (j14 <= 0 ? 2 : 1))), j18), this.j - 1);
                                }
                                if (j3 < j4) {
                                }
                            } else {
                                bVar.a(i3);
                                j5 = this.f1463a.b;
                            }
                        } else {
                            j3 = this.i;
                            if (j3 == j12) {
                                throw new IOException("No ogg page can be found.");
                            }
                            j4 = 0;
                            j2 = 2;
                            if (j3 < j4) {
                                return j3;
                            }
                            long j20 = this.h;
                            j6 = -(j3 + j2);
                            this.f1463a.a(bVar, false);
                            while (true) {
                                g gVar3 = this.f1463a;
                                if (gVar3.b >= j20) {
                                    break;
                                }
                                bVar.a(gVar3.d + gVar3.e);
                                g gVar4 = this.f1463a;
                                long j21 = gVar4.b;
                                gVar4.a(bVar, false);
                                j6 = j21;
                            }
                            bVar.e = 0;
                            i = 3;
                        }
                    }
                    j3 = -(j5 + 2);
                    j4 = 0;
                    j2 = 2;
                    if (j3 < j4) {
                    }
                }
                this.e = i;
                return -(j6 + j2);
            }
            j = 0;
        }
        if (!a(bVar, this.c)) {
            throw new EOFException();
        }
        g gVar5 = this.f1463a;
        gVar5.f1467a = 0;
        gVar5.b = j;
        gVar5.c = 0;
        gVar5.d = 0;
        gVar5.e = 0;
        while (true) {
            gVar = this.f1463a;
            if ((gVar.f1467a & 4) == 4 || bVar.c >= this.c) {
                break;
            }
            gVar.a(bVar, false);
            g gVar6 = this.f1463a;
            bVar.a(gVar6.d + gVar6.e);
        }
        this.f = gVar.b;
        this.e = 3;
        return this.g;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.h
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.q b() {
        if (this.f != 0) {
            return new a(this);
        }
        return null;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.h
    public final long c(long j) {
        int i = this.e;
        if (i != 3 && i != 2) {
            throw new IllegalArgumentException();
        }
        long j2 = j == 0 ? 0L : (this.d.i * j) / 1000000;
        this.h = j2;
        this.e = 2;
        this.i = this.b;
        this.j = this.c;
        this.k = 0L;
        this.l = this.f;
        return j2;
    }

    public final boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar, long j) {
        int i;
        long min = Math.min(j + 3, this.c);
        int i2 = 2048;
        byte[] bArr = new byte[2048];
        while (true) {
            long j2 = bVar.c;
            int i3 = 0;
            if (i2 + j2 > min && (i2 = (int) (min - j2)) < 4) {
                return false;
            }
            bVar.a(bArr, 0, i2, false);
            while (true) {
                i = i2 - 3;
                if (i3 < i) {
                    if (bArr[i3] == 79 && bArr[i3 + 1] == 103 && bArr[i3 + 2] == 103 && bArr[i3 + 3] == 83) {
                        bVar.a(i3);
                        return true;
                    }
                    i3++;
                }
            }
            bVar.a(i);
        }
    }
}
