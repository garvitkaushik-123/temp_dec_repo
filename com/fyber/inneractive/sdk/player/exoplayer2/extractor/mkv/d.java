package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv;

import android.util.Log;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.j;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.r;
import com.fyber.inneractive.sdk.player.exoplayer2.o;
import com.fyber.inneractive.sdk.player.exoplayer2.util.i;
import com.fyber.inneractive.sdk.player.exoplayer2.util.n;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* loaded from: classes4.dex */
public final class d {
    public boolean L;
    public r O;
    public int P;

    /* renamed from: a, reason: collision with root package name */
    public String f1434a;
    public int b;
    public int c;
    public int d;
    public boolean e;
    public byte[] f;
    public byte[] g;
    public byte[] h;
    public com.fyber.inneractive.sdk.player.exoplayer2.drm.d i;
    public int j = -1;
    public int k = -1;
    public int l = -1;
    public int m = -1;
    public int n = 0;
    public byte[] o = null;
    public int p = -1;
    public boolean q = false;
    public int r = -1;
    public int s = -1;
    public int t = -1;
    public int u = 1000;
    public int v = 200;
    public float w = -1.0f;
    public float x = -1.0f;
    public float y = -1.0f;
    public float z = -1.0f;
    public float A = -1.0f;
    public float B = -1.0f;
    public float C = -1.0f;
    public float D = -1.0f;
    public float E = -1.0f;
    public float F = -1.0f;
    public int G = 1;
    public int H = -1;
    public int I = 8000;
    public long J = 0;
    public long K = 0;
    public boolean M = true;
    public String N = "eng";

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x03d5, code lost:
    
        if (r1.g() == r2.getLeastSignificantBits()) goto L220;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0439  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x045e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x042a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(j jVar, int i) {
        char c;
        List singletonList;
        String str;
        int a2;
        int i2;
        String str2;
        List list;
        String str3;
        int i3;
        int i4;
        List list2;
        String str4;
        o oVar;
        com.fyber.inneractive.sdk.player.exoplayer2.video.c cVar;
        byte[] bArr;
        int i5;
        String str5 = this.f1434a;
        str5.getClass();
        str5.hashCode();
        int i6 = 3;
        switch (str5.hashCode()) {
            case -2095576542:
                if (str5.equals("V_MPEG4/ISO/AP")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -2095575984:
                if (str5.equals("V_MPEG4/ISO/SP")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1985379776:
                if (str5.equals("A_MS/ACM")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1784763192:
                if (str5.equals("A_TRUEHD")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1730367663:
                if (str5.equals("A_VORBIS")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1482641358:
                if (str5.equals("A_MPEG/L2")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -1482641357:
                if (str5.equals("A_MPEG/L3")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -1373388978:
                if (str5.equals("V_MS/VFW/FOURCC")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -933872740:
                if (str5.equals("S_DVBSUB")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -538363189:
                if (str5.equals("V_MPEG4/ISO/ASP")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -538363109:
                if (str5.equals("V_MPEG4/ISO/AVC")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case -425012669:
                if (str5.equals("S_VOBSUB")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case -356037306:
                if (str5.equals("A_DTS/LOSSLESS")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 62923557:
                if (str5.equals("A_AAC")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case 62923603:
                if (str5.equals("A_AC3")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 62927045:
                if (str5.equals("A_DTS")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case 82338133:
                if (str5.equals("V_VP8")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 82338134:
                if (str5.equals("V_VP9")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case 99146302:
                if (str5.equals("S_HDMV/PGS")) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case 444813526:
                if (str5.equals("V_THEORA")) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case 542569478:
                if (str5.equals("A_DTS/EXPRESS")) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            case 725957860:
                if (str5.equals("A_PCM/INT/LIT")) {
                    c = 21;
                    break;
                }
                c = 65535;
                break;
            case 855502857:
                if (str5.equals("V_MPEGH/ISO/HEVC")) {
                    c = 22;
                    break;
                }
                c = 65535;
                break;
            case 1422270023:
                if (str5.equals("S_TEXT/UTF8")) {
                    c = 23;
                    break;
                }
                c = 65535;
                break;
            case 1809237540:
                if (str5.equals("V_MPEG2")) {
                    c = 24;
                    break;
                }
                c = 65535;
                break;
            case 1950749482:
                if (str5.equals("A_EAC3")) {
                    c = 25;
                    break;
                }
                c = 65535;
                break;
            case 1950789798:
                if (str5.equals("A_FLAC")) {
                    c = 26;
                    break;
                }
                c = 65535;
                break;
            case 1951062397:
                if (str5.equals("A_OPUS")) {
                    c = 27;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        String str6 = "audio/x-unknown";
        switch (c) {
            case 0:
            case 1:
            case '\t':
                byte[] bArr2 = this.h;
                singletonList = bArr2 == null ? null : Collections.singletonList(bArr2);
                str = "video/mp4v-es";
                str6 = str;
                list2 = singletonList;
                a2 = -1;
                i4 = a2;
                list = list2;
                str2 = str6;
                i3 = -1;
                int i7 = (this.M ? 1 : 0) | (!this.L ? 2 : 0);
                if ("audio".equals(i.b(str2))) {
                    List list3 = list;
                    int i8 = i3;
                    if ("video".equals(i.b(str2))) {
                        if (this.n == 0) {
                            int i9 = this.l;
                            if (i9 == -1) {
                                i9 = this.j;
                            }
                            this.l = i9;
                            int i10 = this.m;
                            if (i10 == -1) {
                                i10 = this.k;
                            }
                            this.m = i10;
                        }
                        float f = (this.l == -1 || (i5 = this.m) == -1) ? -1.0f : (this.k * r1) / (this.j * i5);
                        if (this.q) {
                            if (this.w == -1.0f || this.x == -1.0f || this.y == -1.0f || this.z == -1.0f || this.A == -1.0f || this.B == -1.0f || this.C == -1.0f || this.D == -1.0f || this.E == -1.0f || this.F == -1.0f) {
                                bArr = null;
                            } else {
                                bArr = new byte[25];
                                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                                wrap.put((byte) 0);
                                wrap.putShort((short) ((this.w * 50000.0f) + 0.5f));
                                wrap.putShort((short) ((this.x * 50000.0f) + 0.5f));
                                wrap.putShort((short) ((this.y * 50000.0f) + 0.5f));
                                wrap.putShort((short) ((this.z * 50000.0f) + 0.5f));
                                wrap.putShort((short) ((this.A * 50000.0f) + 0.5f));
                                wrap.putShort((short) ((this.B * 50000.0f) + 0.5f));
                                wrap.putShort((short) ((this.C * 50000.0f) + 0.5f));
                                wrap.putShort((short) ((this.D * 50000.0f) + 0.5f));
                                wrap.putShort((short) (this.E + 0.5f));
                                wrap.putShort((short) (this.F + 0.5f));
                                wrap.putShort((short) this.u);
                                wrap.putShort((short) this.v);
                            }
                            cVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.c(this.r, this.t, this.s, bArr);
                        } else {
                            cVar = null;
                        }
                        oVar = o.a(Integer.toString(i), str2, i8, this.j, this.k, list3, -1, f, this.o, this.p, cVar, this.i);
                        i6 = 2;
                    } else {
                        String str7 = str2;
                        if ("application/x-subrip".equals(str7)) {
                            oVar = o.a(Integer.toString(i), str7, i7, this.N, -1, this.i, Long.MAX_VALUE, Collections.emptyList());
                        } else {
                            if (!"application/vobsub".equals(str7) && !"application/pgs".equals(str7) && !"application/dvbsubs".equals(str7)) {
                                throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Unexpected MIME type.");
                            }
                            oVar = new o(Integer.toString(i), null, str7, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, this.N, -1, Long.MAX_VALUE, list3, this.i, null);
                        }
                    }
                } else {
                    oVar = o.a(Integer.toString(i), str2, -1, i3, this.G, this.I, i4, -1, -1, list, this.i, i7, this.N, null);
                    i6 = 1;
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.g a3 = jVar.a(this.b, i6);
                this.O = a3;
                a3.a(oVar);
                return;
            case 2:
                n nVar = new n(this.h);
                try {
                    int f2 = nVar.f();
                    if (f2 != 1) {
                        if (f2 == 65534) {
                            nVar.e(24);
                            long g = nVar.g();
                            UUID uuid = e.b0;
                            if (g == uuid.getMostSignificantBits()) {
                                break;
                            }
                        }
                        Log.w("MatroskaExtractor", "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown");
                        a2 = -1;
                        list2 = null;
                        i4 = a2;
                        list = list2;
                        str2 = str6;
                        i3 = -1;
                        int i72 = (this.M ? 1 : 0) | (!this.L ? 2 : 0);
                        if ("audio".equals(i.b(str2))) {
                        }
                        com.fyber.inneractive.sdk.player.exoplayer2.extractor.g a32 = jVar.a(this.b, i6);
                        this.O = a32;
                        a32.a(oVar);
                        return;
                    }
                    a2 = z.a(this.H);
                    if (a2 != 0) {
                        str6 = "audio/raw";
                        list2 = null;
                        i4 = a2;
                        list = list2;
                        str2 = str6;
                        i3 = -1;
                        int i722 = (this.M ? 1 : 0) | (!this.L ? 2 : 0);
                        if ("audio".equals(i.b(str2))) {
                        }
                        com.fyber.inneractive.sdk.player.exoplayer2.extractor.g a322 = jVar.a(this.b, i6);
                        this.O = a322;
                        a322.a(oVar);
                        return;
                    }
                    Log.w("MatroskaExtractor", "Unsupported PCM bit depth: " + this.H + ". Setting mimeType to audio/x-unknown");
                    a2 = -1;
                    list2 = null;
                    i4 = a2;
                    list = list2;
                    str2 = str6;
                    i3 = -1;
                    int i7222 = (this.M ? 1 : 0) | (!this.L ? 2 : 0);
                    if ("audio".equals(i.b(str2))) {
                    }
                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.g a3222 = jVar.a(this.b, i6);
                    this.O = a3222;
                    a3222.a(oVar);
                    return;
                } catch (ArrayIndexOutOfBoundsException unused) {
                    throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Error parsing MS/ACM codec private");
                }
            case 3:
                str6 = "audio/true-hd";
                a2 = -1;
                list2 = null;
                i4 = a2;
                list = list2;
                str2 = str6;
                i3 = -1;
                int i72222 = (this.M ? 1 : 0) | (!this.L ? 2 : 0);
                if ("audio".equals(i.b(str2))) {
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.g a32222 = jVar.a(this.b, i6);
                this.O = a32222;
                a32222.a(oVar);
                return;
            case 4:
                byte[] bArr3 = this.h;
                try {
                    if (bArr3[0] != 2) {
                        throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Error parsing vorbis codec private");
                    }
                    int i11 = 1;
                    int i12 = 0;
                    while (true) {
                        int i13 = bArr3[i11];
                        if (i13 == -1) {
                            i12 += 255;
                            i11++;
                        } else {
                            int i14 = i11 + 1;
                            int i15 = i12 + i13;
                            int i16 = 0;
                            while (true) {
                                int i17 = bArr3[i14];
                                if (i17 != -1) {
                                    int i18 = i14 + 1;
                                    int i19 = i16 + i17;
                                    if (bArr3[i18] != 1) {
                                        throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Error parsing vorbis codec private");
                                    }
                                    byte[] bArr4 = new byte[i15];
                                    System.arraycopy(bArr3, i18, bArr4, 0, i15);
                                    int i20 = i18 + i15;
                                    if (bArr3[i20] != 3) {
                                        throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Error parsing vorbis codec private");
                                    }
                                    int i21 = i20 + i19;
                                    if (bArr3[i21] != 5) {
                                        throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Error parsing vorbis codec private");
                                    }
                                    byte[] bArr5 = new byte[bArr3.length - i21];
                                    System.arraycopy(bArr3, i21, bArr5, 0, bArr3.length - i21);
                                    ArrayList arrayList = new ArrayList(2);
                                    arrayList.add(bArr4);
                                    arrayList.add(bArr5);
                                    i2 = 8192;
                                    str2 = "audio/vorbis";
                                    list = arrayList;
                                    i3 = i2;
                                    i4 = -1;
                                    int i722222 = (this.M ? 1 : 0) | (!this.L ? 2 : 0);
                                    if ("audio".equals(i.b(str2))) {
                                    }
                                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.g a322222 = jVar.a(this.b, i6);
                                    this.O = a322222;
                                    a322222.a(oVar);
                                    return;
                                }
                                i16 += 255;
                                i14++;
                            }
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException unused2) {
                    throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Error parsing vorbis codec private");
                }
                break;
            case 5:
                str3 = "audio/mpeg-L2";
                str2 = str3;
                i3 = 4096;
                i4 = -1;
                list = null;
                int i7222222 = (this.M ? 1 : 0) | (!this.L ? 2 : 0);
                if ("audio".equals(i.b(str2))) {
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.g a3222222 = jVar.a(this.b, i6);
                this.O = a3222222;
                a3222222.a(oVar);
                return;
            case 6:
                str3 = "audio/mpeg";
                str2 = str3;
                i3 = 4096;
                i4 = -1;
                list = null;
                int i72222222 = (this.M ? 1 : 0) | (!this.L ? 2 : 0);
                if ("audio".equals(i.b(str2))) {
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.g a32222222 = jVar.a(this.b, i6);
                this.O = a32222222;
                a32222222.a(oVar);
                return;
            case 7:
                byte[] bArr6 = this.h;
                try {
                    if (16 > bArr6.length) {
                        throw new IllegalArgumentException();
                    }
                    if (((bArr6[16] & 255) | ((bArr6[17] & 255) << 8) | ((bArr6[18] & 255) << 16) | ((bArr6[19] & 255) << 24)) == 826496599) {
                        for (int i22 = 40; i22 < bArr6.length - 4; i22++) {
                            if (bArr6[i22] == 0 && bArr6[i22 + 1] == 0 && bArr6[i22 + 2] == 1 && bArr6[i22 + 3] == 15) {
                                singletonList = Collections.singletonList(Arrays.copyOfRange(bArr6, i22, bArr6.length));
                            }
                        }
                        throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Failed to find FourCC VC1 initialization data");
                    }
                    singletonList = null;
                    if (singletonList != null) {
                        str6 = "video/wvc1";
                    } else {
                        Log.w("MatroskaExtractor", "Unsupported FourCC. Setting mimeType to video/x-unknown");
                        str6 = "video/x-unknown";
                    }
                    list2 = singletonList;
                    a2 = -1;
                    i4 = a2;
                    list = list2;
                    str2 = str6;
                    i3 = -1;
                    int i722222222 = (this.M ? 1 : 0) | (!this.L ? 2 : 0);
                    if ("audio".equals(i.b(str2))) {
                    }
                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.g a322222222 = jVar.a(this.b, i6);
                    this.O = a322222222;
                    a322222222.a(oVar);
                    return;
                } catch (ArrayIndexOutOfBoundsException unused3) {
                    throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Error parsing FourCC VC1 codec private");
                }
            case '\b':
                byte[] bArr7 = this.h;
                singletonList = Collections.singletonList(new byte[]{bArr7[0], bArr7[1], bArr7[2], bArr7[3]});
                str = "application/dvbsubs";
                str6 = str;
                list2 = singletonList;
                a2 = -1;
                i4 = a2;
                list = list2;
                str2 = str6;
                i3 = -1;
                int i7222222222 = (this.M ? 1 : 0) | (!this.L ? 2 : 0);
                if ("audio".equals(i.b(str2))) {
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.g a3222222222 = jVar.a(this.b, i6);
                this.O = a3222222222;
                a3222222222.a(oVar);
                return;
            case '\n':
                com.fyber.inneractive.sdk.player.exoplayer2.video.a a4 = com.fyber.inneractive.sdk.player.exoplayer2.video.a.a(new n(this.h));
                list2 = a4.f1601a;
                this.P = a4.b;
                str4 = "video/avc";
                str6 = str4;
                a2 = -1;
                i4 = a2;
                list = list2;
                str2 = str6;
                i3 = -1;
                int i72222222222 = (this.M ? 1 : 0) | (!this.L ? 2 : 0);
                if ("audio".equals(i.b(str2))) {
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.g a32222222222 = jVar.a(this.b, i6);
                this.O = a32222222222;
                a32222222222.a(oVar);
                return;
            case 11:
                singletonList = Collections.singletonList(this.h);
                str = "application/vobsub";
                str6 = str;
                list2 = singletonList;
                a2 = -1;
                i4 = a2;
                list = list2;
                str2 = str6;
                i3 = -1;
                int i722222222222 = (this.M ? 1 : 0) | (!this.L ? 2 : 0);
                if ("audio".equals(i.b(str2))) {
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.g a322222222222 = jVar.a(this.b, i6);
                this.O = a322222222222;
                a322222222222.a(oVar);
                return;
            case '\f':
                str6 = "audio/vnd.dts.hd";
                a2 = -1;
                list2 = null;
                i4 = a2;
                list = list2;
                str2 = str6;
                i3 = -1;
                int i7222222222222 = (this.M ? 1 : 0) | (!this.L ? 2 : 0);
                if ("audio".equals(i.b(str2))) {
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.g a3222222222222 = jVar.a(this.b, i6);
                this.O = a3222222222222;
                a3222222222222.a(oVar);
                return;
            case '\r':
                singletonList = Collections.singletonList(this.h);
                str = "audio/mp4a-latm";
                str6 = str;
                list2 = singletonList;
                a2 = -1;
                i4 = a2;
                list = list2;
                str2 = str6;
                i3 = -1;
                int i72222222222222 = (this.M ? 1 : 0) | (!this.L ? 2 : 0);
                if ("audio".equals(i.b(str2))) {
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.g a32222222222222 = jVar.a(this.b, i6);
                this.O = a32222222222222;
                a32222222222222.a(oVar);
                return;
            case 14:
                str6 = "audio/ac3";
                a2 = -1;
                list2 = null;
                i4 = a2;
                list = list2;
                str2 = str6;
                i3 = -1;
                int i722222222222222 = (this.M ? 1 : 0) | (!this.L ? 2 : 0);
                if ("audio".equals(i.b(str2))) {
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.g a322222222222222 = jVar.a(this.b, i6);
                this.O = a322222222222222;
                a322222222222222.a(oVar);
                return;
            case 15:
            case 20:
                str6 = "audio/vnd.dts";
                a2 = -1;
                list2 = null;
                i4 = a2;
                list = list2;
                str2 = str6;
                i3 = -1;
                int i7222222222222222 = (this.M ? 1 : 0) | (!this.L ? 2 : 0);
                if ("audio".equals(i.b(str2))) {
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.g a3222222222222222 = jVar.a(this.b, i6);
                this.O = a3222222222222222;
                a3222222222222222.a(oVar);
                return;
            case 16:
                str6 = "video/x-vnd.on2.vp8";
                a2 = -1;
                list2 = null;
                i4 = a2;
                list = list2;
                str2 = str6;
                i3 = -1;
                int i72222222222222222 = (this.M ? 1 : 0) | (!this.L ? 2 : 0);
                if ("audio".equals(i.b(str2))) {
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.g a32222222222222222 = jVar.a(this.b, i6);
                this.O = a32222222222222222;
                a32222222222222222.a(oVar);
                return;
            case 17:
                str6 = "video/x-vnd.on2.vp9";
                a2 = -1;
                list2 = null;
                i4 = a2;
                list = list2;
                str2 = str6;
                i3 = -1;
                int i722222222222222222 = (this.M ? 1 : 0) | (!this.L ? 2 : 0);
                if ("audio".equals(i.b(str2))) {
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.g a322222222222222222 = jVar.a(this.b, i6);
                this.O = a322222222222222222;
                a322222222222222222.a(oVar);
                return;
            case 18:
                str6 = "application/pgs";
                a2 = -1;
                list2 = null;
                i4 = a2;
                list = list2;
                str2 = str6;
                i3 = -1;
                int i7222222222222222222 = (this.M ? 1 : 0) | (!this.L ? 2 : 0);
                if ("audio".equals(i.b(str2))) {
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.g a3222222222222222222 = jVar.a(this.b, i6);
                this.O = a3222222222222222222;
                a3222222222222222222.a(oVar);
                return;
            case 19:
                str6 = "video/x-unknown";
                a2 = -1;
                list2 = null;
                i4 = a2;
                list = list2;
                str2 = str6;
                i3 = -1;
                int i72222222222222222222 = (this.M ? 1 : 0) | (!this.L ? 2 : 0);
                if ("audio".equals(i.b(str2))) {
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.g a32222222222222222222 = jVar.a(this.b, i6);
                this.O = a32222222222222222222;
                a32222222222222222222.a(oVar);
                return;
            case 21:
                a2 = z.a(this.H);
                if (a2 != 0) {
                    str6 = "audio/raw";
                    list2 = null;
                    i4 = a2;
                    list = list2;
                    str2 = str6;
                    i3 = -1;
                    int i722222222222222222222 = (this.M ? 1 : 0) | (!this.L ? 2 : 0);
                    if ("audio".equals(i.b(str2))) {
                    }
                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.g a322222222222222222222 = jVar.a(this.b, i6);
                    this.O = a322222222222222222222;
                    a322222222222222222222.a(oVar);
                    return;
                }
                Log.w("MatroskaExtractor", "Unsupported PCM bit depth: " + this.H + ". Setting mimeType to audio/x-unknown");
                a2 = -1;
                list2 = null;
                i4 = a2;
                list = list2;
                str2 = str6;
                i3 = -1;
                int i7222222222222222222222 = (this.M ? 1 : 0) | (!this.L ? 2 : 0);
                if ("audio".equals(i.b(str2))) {
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.g a3222222222222222222222 = jVar.a(this.b, i6);
                this.O = a3222222222222222222222;
                a3222222222222222222222.a(oVar);
                return;
            case 22:
                com.fyber.inneractive.sdk.player.exoplayer2.video.d a5 = com.fyber.inneractive.sdk.player.exoplayer2.video.d.a(new n(this.h));
                list2 = a5.f1603a;
                this.P = a5.b;
                str4 = "video/hevc";
                str6 = str4;
                a2 = -1;
                i4 = a2;
                list = list2;
                str2 = str6;
                i3 = -1;
                int i72222222222222222222222 = (this.M ? 1 : 0) | (!this.L ? 2 : 0);
                if ("audio".equals(i.b(str2))) {
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.g a32222222222222222222222 = jVar.a(this.b, i6);
                this.O = a32222222222222222222222;
                a32222222222222222222222.a(oVar);
                return;
            case 23:
                str6 = "application/x-subrip";
                a2 = -1;
                list2 = null;
                i4 = a2;
                list = list2;
                str2 = str6;
                i3 = -1;
                int i722222222222222222222222 = (this.M ? 1 : 0) | (!this.L ? 2 : 0);
                if ("audio".equals(i.b(str2))) {
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.g a322222222222222222222222 = jVar.a(this.b, i6);
                this.O = a322222222222222222222222;
                a322222222222222222222222.a(oVar);
                return;
            case 24:
                str6 = "video/mpeg2";
                a2 = -1;
                list2 = null;
                i4 = a2;
                list = list2;
                str2 = str6;
                i3 = -1;
                int i7222222222222222222222222 = (this.M ? 1 : 0) | (!this.L ? 2 : 0);
                if ("audio".equals(i.b(str2))) {
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.g a3222222222222222222222222 = jVar.a(this.b, i6);
                this.O = a3222222222222222222222222;
                a3222222222222222222222222.a(oVar);
                return;
            case 25:
                str6 = "audio/eac3";
                a2 = -1;
                list2 = null;
                i4 = a2;
                list = list2;
                str2 = str6;
                i3 = -1;
                int i72222222222222222222222222 = (this.M ? 1 : 0) | (!this.L ? 2 : 0);
                if ("audio".equals(i.b(str2))) {
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.g a32222222222222222222222222 = jVar.a(this.b, i6);
                this.O = a32222222222222222222222222;
                a32222222222222222222222222.a(oVar);
                return;
            case 26:
                singletonList = Collections.singletonList(this.h);
                str = "audio/flac";
                str6 = str;
                list2 = singletonList;
                a2 = -1;
                i4 = a2;
                list = list2;
                str2 = str6;
                i3 = -1;
                int i722222222222222222222222222 = (this.M ? 1 : 0) | (!this.L ? 2 : 0);
                if ("audio".equals(i.b(str2))) {
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.g a322222222222222222222222222 = jVar.a(this.b, i6);
                this.O = a322222222222222222222222222;
                a322222222222222222222222222.a(oVar);
                return;
            case 27:
                ArrayList arrayList2 = new ArrayList(3);
                arrayList2.add(this.h);
                arrayList2.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.J).array());
                arrayList2.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.K).array());
                i2 = 5760;
                list = arrayList2;
                str2 = "audio/opus";
                i3 = i2;
                i4 = -1;
                int i7222222222222222222222222222 = (this.M ? 1 : 0) | (!this.L ? 2 : 0);
                if ("audio".equals(i.b(str2))) {
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.g a3222222222222222222222222222 = jVar.a(this.b, i6);
                this.O = a3222222222222222222222222222;
                a3222222222222222222222222222.a(oVar);
                return;
            default:
                throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Unrecognized codec identifier.");
        }
    }
}
