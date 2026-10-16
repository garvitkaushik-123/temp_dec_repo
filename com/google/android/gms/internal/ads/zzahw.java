package com.google.android.gms.internal.ads;

import android.util.Pair;
import io.bidmachine.media3.common.C;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzahw {
    public byte[] zzO;
    public zzafc zzU;
    public boolean zzV;
    public zzafb zzX;
    public int zzY;
    private int zzZ;
    public boolean zza;
    public String zzb;
    public String zzc;
    public int zzd;
    public int zze;
    public int zzf;
    public int zzg;
    public boolean zzh;
    public byte[] zzi;
    public zzafa zzj;
    public byte[] zzk;
    public zzs zzl;
    public int zzm = -1;
    public int zzn = -1;
    public int zzo = -1;
    public int zzp = -1;
    public int zzq = -1;
    public int zzr = 0;
    public int zzs = -1;
    public float zzt = 0.0f;
    public float zzu = 0.0f;
    public float zzv = 0.0f;
    public byte[] zzw = null;
    public int zzx = -1;
    public boolean zzy = false;
    public int zzz = -1;
    public int zzA = -1;
    public int zzB = -1;
    public int zzC = 1000;
    public int zzD = 200;
    public float zzE = -1.0f;
    public float zzF = -1.0f;
    public float zzG = -1.0f;
    public float zzH = -1.0f;
    public float zzI = -1.0f;
    public float zzJ = -1.0f;
    public float zzK = -1.0f;
    public float zzL = -1.0f;
    public float zzM = -1.0f;
    public float zzN = -1.0f;
    public int zzP = 1;
    public int zzQ = -1;
    public int zzR = 8000;
    public long zzS = 0;
    public long zzT = 0;
    public boolean zzW = true;
    private String zzaa = "eng";

    protected zzahw() {
    }

    private static Pair zzf(zzen zzenVar) throws zzaz {
        try {
            zzenVar.zzM(16);
            long zzs = zzenVar.zzs();
            if (zzs == 1482049860) {
                return new Pair("video/divx", null);
            }
            if (zzs == 859189832) {
                return new Pair("video/3gpp", null);
            }
            if (zzs != 826496599) {
                zzea.zzf("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                return new Pair("video/x-unknown", null);
            }
            int zzc = zzenVar.zzc() + 20;
            byte[] zzN = zzenVar.zzN();
            while (true) {
                int length = zzN.length;
                if (zzc >= length - 4) {
                    throw zzaz.zza("Failed to find FourCC VC1 initialization data", null);
                }
                int i = zzc + 1;
                if (zzN[zzc] == 0 && zzN[i] == 0 && zzN[zzc + 2] == 1 && zzN[zzc + 3] == 15) {
                    return new Pair("video/wvc1", Collections.singletonList(Arrays.copyOfRange(zzN, zzc, length)));
                }
                zzc = i;
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzaz.zza("Error parsing FourCC private data", null);
        }
    }

    private static List zzg(byte[] bArr) throws zzaz {
        int i;
        int i2;
        try {
            if (bArr[0] != 2) {
                throw zzaz.zza("Error parsing vorbis codec private", null);
            }
            int i3 = 0;
            int i4 = 1;
            while (true) {
                int i5 = bArr[i4];
                i4++;
                i = i5 & 255;
                if (i != 255) {
                    break;
                }
                i3 += 255;
            }
            int i6 = i3 + i;
            int i7 = 0;
            while (true) {
                int i8 = bArr[i4];
                i4++;
                i2 = i8 & 255;
                if (i2 != 255) {
                    break;
                }
                i7 += 255;
            }
            int i9 = i7 + i2;
            if (bArr[i4] != 1) {
                throw zzaz.zza("Error parsing vorbis codec private", null);
            }
            byte[] bArr2 = new byte[i6];
            System.arraycopy(bArr, i4, bArr2, 0, i6);
            int i10 = i4 + i6;
            if (bArr[i10] != 3) {
                throw zzaz.zza("Error parsing vorbis codec private", null);
            }
            int i11 = i10 + i9;
            if (bArr[i11] != 5) {
                throw zzaz.zza("Error parsing vorbis codec private", null);
            }
            int length = bArr.length - i11;
            byte[] bArr3 = new byte[length];
            System.arraycopy(bArr, i11, bArr3, 0, length);
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(bArr2);
            arrayList.add(bArr3);
            return arrayList;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzaz.zza("Error parsing vorbis codec private", null);
        }
    }

    private static boolean zzh(zzen zzenVar) throws zzaz {
        try {
            int zzk = zzenVar.zzk();
            if (zzk == 1) {
                return true;
            }
            if (zzk == 65534) {
                zzenVar.zzL(24);
                if (zzenVar.zzt() == zzahy.zze.getMostSignificantBits()) {
                    if (zzenVar.zzt() == zzahy.zze.getLeastSignificantBits()) {
                        return true;
                    }
                }
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzaz.zza("Error parsing MS/ACM codec private", null);
        }
    }

    @EnsuresNonNull({"codecPrivate"})
    private final byte[] zzi(String str) throws zzaz {
        byte[] bArr = this.zzk;
        if (bArr != null) {
            return bArr;
        }
        throw zzaz.zza("Missing CodecPrivate for codec ".concat(String.valueOf(str)), null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:120:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x03e7  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x03f6  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x05e4  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x05fe  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0601  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0406  */
    @EnsuresNonNull({"this.output"})
    @RequiresNonNull({"codecId"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zze(zzady zzadyVar, int i) throws zzaz {
        char c;
        List zzo;
        List list;
        String str;
        String str2;
        int i2;
        List zzg;
        int i3;
        String str3;
        zzx zzxVar;
        int i4;
        zzk zzkVar;
        byte[] bArr;
        int i5;
        zzez zza;
        String str4 = this.zzc;
        int i6 = 4;
        int i7 = 0;
        int i8 = -1;
        switch (str4.hashCode()) {
            case -2095576542:
                if (str4.equals("V_MPEG4/ISO/AP")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -2095575984:
                if (str4.equals("V_MPEG4/ISO/SP")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1985379776:
                if (str4.equals("A_MS/ACM")) {
                    c = 23;
                    break;
                }
                c = 65535;
                break;
            case -1784763192:
                if (str4.equals("A_TRUEHD")) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case -1730367663:
                if (str4.equals("A_VORBIS")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case -1482641358:
                if (str4.equals("A_MPEG/L2")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case -1482641357:
                if (str4.equals("A_MPEG/L3")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case -1373388978:
                if (str4.equals("V_MS/VFW/FOURCC")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -933872740:
                if (str4.equals("S_DVBSUB")) {
                    c = '!';
                    break;
                }
                c = 65535;
                break;
            case -538363189:
                if (str4.equals("V_MPEG4/ISO/ASP")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -538363109:
                if (str4.equals("V_MPEG4/ISO/AVC")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -425012669:
                if (str4.equals("S_VOBSUB")) {
                    c = 31;
                    break;
                }
                c = 65535;
                break;
            case -356037306:
                if (str4.equals("A_DTS/LOSSLESS")) {
                    c = 21;
                    break;
                }
                c = 65535;
                break;
            case 62923557:
                if (str4.equals("A_AAC")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case 62923603:
                if (str4.equals("A_AC3")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 62927045:
                if (str4.equals("A_DTS")) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case 82318131:
                if (str4.equals("V_AV1")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 82338133:
                if (str4.equals("V_VP8")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 82338134:
                if (str4.equals("V_VP9")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 99146302:
                if (str4.equals("S_HDMV/PGS")) {
                    c = ' ';
                    break;
                }
                c = 65535;
                break;
            case 444813526:
                if (str4.equals("V_THEORA")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 542569478:
                if (str4.equals("A_DTS/EXPRESS")) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            case 635596514:
                if (str4.equals("A_PCM/FLOAT/IEEE")) {
                    c = 26;
                    break;
                }
                c = 65535;
                break;
            case 725948237:
                if (str4.equals("A_PCM/INT/BIG")) {
                    c = 25;
                    break;
                }
                c = 65535;
                break;
            case 725957860:
                if (str4.equals("A_PCM/INT/LIT")) {
                    c = 24;
                    break;
                }
                c = 65535;
                break;
            case 738597099:
                if (str4.equals("S_TEXT/ASS")) {
                    c = 28;
                    break;
                }
                c = 65535;
                break;
            case 738614379:
                if (str4.equals("S_TEXT/SSA")) {
                    c = 29;
                    break;
                }
                c = 65535;
                break;
            case 855502857:
                if (str4.equals("V_MPEGH/ISO/HEVC")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 1045209816:
                if (str4.equals("S_TEXT/WEBVTT")) {
                    c = 30;
                    break;
                }
                c = 65535;
                break;
            case 1422270023:
                if (str4.equals("S_TEXT/UTF8")) {
                    c = 27;
                    break;
                }
                c = 65535;
                break;
            case 1809237540:
                if (str4.equals("V_MPEG2")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1950749482:
                if (str4.equals("A_EAC3")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case 1950789798:
                if (str4.equals("A_FLAC")) {
                    c = 22;
                    break;
                }
                c = 65535;
                break;
            case 1951062397:
                if (str4.equals("A_OPUS")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        String str5 = "audio/raw";
        switch (c) {
            case 0:
                str5 = "video/x-vnd.on2.vp8";
                i2 = -1;
                i6 = -1;
                list = null;
                str2 = null;
                if (this.zzO != null && (zza = zzez.zza(new zzen(this.zzO))) != null) {
                    str2 = zza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                int i9 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                    zzxVar.zzD(this.zzP);
                    zzxVar.zzai(this.zzR);
                    zzxVar.zzab(i6);
                    i4 = 1;
                } else if (zzay.zzj(str3)) {
                    if (this.zzr == 0) {
                        int i10 = this.zzp;
                        if (i10 == -1) {
                            i10 = this.zzm;
                        }
                        this.zzp = i10;
                        int i11 = this.zzq;
                        if (i11 == -1) {
                            i11 = this.zzn;
                        }
                        this.zzq = i11;
                    }
                    float f = (this.zzp == -1 || (i5 = this.zzq) == -1) ? -1.0f : (this.zzn * r7) / (this.zzm * i5);
                    if (this.zzy) {
                        if (this.zzE == -1.0f || this.zzF == -1.0f || this.zzG == -1.0f || this.zzH == -1.0f || this.zzI == -1.0f || this.zzJ == -1.0f || this.zzK == -1.0f || this.zzL == -1.0f || this.zzM == -1.0f || this.zzN == -1.0f) {
                            bArr = null;
                        } else {
                            bArr = new byte[25];
                            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                            order.put((byte) 0);
                            order.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                            order.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                            order.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                            order.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                            order.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                            order.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                            order.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                            order.putShort((short) ((this.zzL * 50000.0f) + 0.5f));
                            order.putShort((short) (this.zzM + 0.5f));
                            order.putShort((short) (this.zzN + 0.5f));
                            order.putShort((short) this.zzC);
                            order.putShort((short) this.zzD);
                        }
                        zzi zziVar = new zzi();
                        zziVar.zzc(this.zzz);
                        zziVar.zzb(this.zzB);
                        zziVar.zzd(this.zzA);
                        zziVar.zze(bArr);
                        zziVar.zzf(this.zzo);
                        zziVar.zza(this.zzo);
                        zzkVar = zziVar.zzg();
                    } else {
                        zzkVar = null;
                    }
                    if (this.zzb != null && zzahy.zzf.containsKey(this.zzb)) {
                        i8 = ((Integer) zzahy.zzf.get(this.zzb)).intValue();
                    }
                    if (this.zzs == 0 && Float.compare(this.zzt, 0.0f) == 0 && Float.compare(this.zzu, 0.0f) == 0) {
                        if (Float.compare(this.zzv, 0.0f) != 0) {
                            if (Float.compare(this.zzv, 90.0f) == 0) {
                                i7 = 90;
                            } else if (Float.compare(this.zzv, -180.0f) == 0 || Float.compare(this.zzv, 180.0f) == 0) {
                                i7 = 180;
                            } else if (Float.compare(this.zzv, -90.0f) == 0) {
                                i7 = 270;
                            }
                        }
                        zzxVar.zzam(this.zzm);
                        zzxVar.zzQ(this.zzn);
                        zzxVar.zzad(f);
                        zzxVar.zzag(i7);
                        zzxVar.zzae(this.zzw);
                        zzxVar.zzak(this.zzx);
                        zzxVar.zzF(zzkVar);
                        i4 = 2;
                    }
                    i7 = i8;
                    zzxVar.zzam(this.zzm);
                    zzxVar.zzQ(this.zzn);
                    zzxVar.zzad(f);
                    zzxVar.zzag(i7);
                    zzxVar.zzae(this.zzw);
                    zzxVar.zzak(this.zzx);
                    zzxVar.zzF(zzkVar);
                    i4 = 2;
                } else {
                    if (!"application/x-subrip".equals(str3) && !"text/x-ssa".equals(str3) && !"text/vtt".equals(str3) && !"application/vobsub".equals(str3) && !"application/pgs".equals(str3) && !"application/dvbsubs".equals(str3)) {
                        throw zzaz.zza("Unexpected MIME type.", null);
                    }
                    i4 = 3;
                }
                if (this.zzb != null && !zzahy.zzf.containsKey(this.zzb)) {
                    zzxVar.zzU(this.zzb);
                }
                zzxVar.zzR(i);
                zzxVar.zzG(true == this.zza ? "video/x-matroska" : "video/webm");
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i9);
                zzxVar.zzT(list);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzan = zzxVar.zzan();
                zzafb zzw = zzadyVar.zzw(this.zzd, i4);
                this.zzX = zzw;
                zzw.zzm(zzan);
                return;
            case 1:
                byte[] bArr2 = this.zzk;
                zzo = bArr2 == null ? null : zzfyq.zzo(bArr2);
                str5 = "video/x-vnd.on2.vp9";
                list = zzo;
                i2 = -1;
                i6 = -1;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zza.zza;
                    str5 = "video/dolby-vision";
                    break;
                }
                str3 = str5;
                int i92 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                }
                if (this.zzb != null) {
                    zzxVar.zzU(this.zzb);
                    break;
                }
                zzxVar.zzR(i);
                zzxVar.zzG(true == this.zza ? "video/x-matroska" : "video/webm");
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i92);
                zzxVar.zzT(list);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzan2 = zzxVar.zzan();
                zzafb zzw2 = zzadyVar.zzw(this.zzd, i4);
                this.zzX = zzw2;
                zzw2.zzm(zzan2);
                return;
            case 2:
                byte[] bArr3 = this.zzk;
                zzo = bArr3 == null ? null : zzfyq.zzo(bArr3);
                str5 = "video/av01";
                list = zzo;
                i2 = -1;
                i6 = -1;
                str2 = null;
                if (this.zzO != null) {
                }
                str3 = str5;
                int i922 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                }
                if (this.zzb != null) {
                }
                zzxVar.zzR(i);
                zzxVar.zzG(true == this.zza ? "video/x-matroska" : "video/webm");
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i922);
                zzxVar.zzT(list);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzan22 = zzxVar.zzan();
                zzafb zzw22 = zzadyVar.zzw(this.zzd, i4);
                this.zzX = zzw22;
                zzw22.zzm(zzan22);
                return;
            case 3:
                str5 = "video/mpeg2";
                i2 = -1;
                i6 = -1;
                list = null;
                str2 = null;
                if (this.zzO != null) {
                }
                str3 = str5;
                int i9222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                }
                if (this.zzb != null) {
                }
                zzxVar.zzR(i);
                zzxVar.zzG(true == this.zza ? "video/x-matroska" : "video/webm");
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i9222);
                zzxVar.zzT(list);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzan222 = zzxVar.zzan();
                zzafb zzw222 = zzadyVar.zzw(this.zzd, i4);
                this.zzX = zzw222;
                zzw222.zzm(zzan222);
                return;
            case 4:
            case 5:
            case 6:
                byte[] bArr4 = this.zzk;
                zzo = bArr4 == null ? null : Collections.singletonList(bArr4);
                str5 = "video/mp4v-es";
                list = zzo;
                i2 = -1;
                i6 = -1;
                str2 = null;
                if (this.zzO != null) {
                }
                str3 = str5;
                int i92222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                }
                if (this.zzb != null) {
                }
                zzxVar.zzR(i);
                zzxVar.zzG(true == this.zza ? "video/x-matroska" : "video/webm");
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i92222);
                zzxVar.zzT(list);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzan2222 = zzxVar.zzan();
                zzafb zzw2222 = zzadyVar.zzw(this.zzd, i4);
                this.zzX = zzw2222;
                zzw2222.zzm(zzan2222);
                return;
            case 7:
                zzacz zza2 = zzacz.zza(new zzen(zzi(this.zzc)));
                list = zza2.zza;
                this.zzY = zza2.zzb;
                str = zza2.zzl;
                str5 = "video/avc";
                str2 = str;
                i2 = -1;
                i6 = -1;
                if (this.zzO != null) {
                }
                str3 = str5;
                int i922222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                }
                if (this.zzb != null) {
                }
                zzxVar.zzR(i);
                zzxVar.zzG(true == this.zza ? "video/x-matroska" : "video/webm");
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i922222);
                zzxVar.zzT(list);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzan22222 = zzxVar.zzan();
                zzafb zzw22222 = zzadyVar.zzw(this.zzd, i4);
                this.zzX = zzw22222;
                zzw22222.zzm(zzan22222);
                return;
            case '\b':
                zzaek zza3 = zzaek.zza(new zzen(zzi(this.zzc)));
                list = zza3.zza;
                this.zzY = zza3.zzb;
                str = zza3.zzn;
                str5 = "video/hevc";
                str2 = str;
                i2 = -1;
                i6 = -1;
                if (this.zzO != null) {
                }
                str3 = str5;
                int i9222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                }
                if (this.zzb != null) {
                }
                zzxVar.zzR(i);
                zzxVar.zzG(true == this.zza ? "video/x-matroska" : "video/webm");
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i9222222);
                zzxVar.zzT(list);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzan222222 = zzxVar.zzan();
                zzafb zzw222222 = zzadyVar.zzw(this.zzd, i4);
                this.zzX = zzw222222;
                zzw222222.zzm(zzan222222);
                return;
            case '\t':
                Pair zzf = zzf(new zzen(zzi(this.zzc)));
                str5 = (String) zzf.first;
                zzo = (List) zzf.second;
                list = zzo;
                i2 = -1;
                i6 = -1;
                str2 = null;
                if (this.zzO != null) {
                }
                str3 = str5;
                int i92222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                }
                if (this.zzb != null) {
                }
                zzxVar.zzR(i);
                zzxVar.zzG(true == this.zza ? "video/x-matroska" : "video/webm");
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i92222222);
                zzxVar.zzT(list);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzan2222222 = zzxVar.zzan();
                zzafb zzw2222222 = zzadyVar.zzw(this.zzd, i4);
                this.zzX = zzw2222222;
                zzw2222222.zzm(zzan2222222);
                return;
            case '\n':
                str5 = "video/x-unknown";
                i2 = -1;
                i6 = -1;
                list = null;
                str2 = null;
                if (this.zzO != null) {
                }
                str3 = str5;
                int i922222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                }
                if (this.zzb != null) {
                }
                zzxVar.zzR(i);
                zzxVar.zzG(true == this.zza ? "video/x-matroska" : "video/webm");
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i922222222);
                zzxVar.zzT(list);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzan22222222 = zzxVar.zzan();
                zzafb zzw22222222 = zzadyVar.zzw(this.zzd, i4);
                this.zzX = zzw22222222;
                zzw22222222.zzm(zzan22222222);
                return;
            case 11:
                zzg = zzg(zzi(str4));
                i3 = 8192;
                str5 = "audio/vorbis";
                list = zzg;
                i6 = -1;
                i2 = i3;
                str2 = null;
                if (this.zzO != null) {
                }
                str3 = str5;
                int i9222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                }
                if (this.zzb != null) {
                }
                zzxVar.zzR(i);
                zzxVar.zzG(true == this.zza ? "video/x-matroska" : "video/webm");
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i9222222222);
                zzxVar.zzT(list);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzan222222222 = zzxVar.zzan();
                zzafb zzw222222222 = zzadyVar.zzw(this.zzd, i4);
                this.zzX = zzw222222222;
                zzw222222222.zzm(zzan222222222);
                return;
            case '\f':
                zzg = new ArrayList(3);
                zzg.add(zzi(this.zzc));
                zzg.add(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.zzS).array());
                zzg.add(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.zzT).array());
                i3 = 5760;
                str5 = "audio/opus";
                list = zzg;
                i6 = -1;
                i2 = i3;
                str2 = null;
                if (this.zzO != null) {
                }
                str3 = str5;
                int i92222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                }
                if (this.zzb != null) {
                }
                zzxVar.zzR(i);
                zzxVar.zzG(true == this.zza ? "video/x-matroska" : "video/webm");
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i92222222222);
                zzxVar.zzT(list);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzan2222222222 = zzxVar.zzan();
                zzafb zzw2222222222 = zzadyVar.zzw(this.zzd, i4);
                this.zzX = zzw2222222222;
                zzw2222222222.zzm(zzan2222222222);
                return;
            case '\r':
                List singletonList = Collections.singletonList(zzi(str4));
                zzacp zza4 = zzacr.zza(this.zzk);
                this.zzR = zza4.zza;
                this.zzP = zza4.zzb;
                str5 = "audio/mp4a-latm";
                str2 = zza4.zzc;
                i6 = -1;
                list = singletonList;
                i2 = -1;
                if (this.zzO != null) {
                }
                str3 = str5;
                int i922222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                }
                if (this.zzb != null) {
                }
                zzxVar.zzR(i);
                zzxVar.zzG(true == this.zza ? "video/x-matroska" : "video/webm");
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i922222222222);
                zzxVar.zzT(list);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzan22222222222 = zzxVar.zzan();
                zzafb zzw22222222222 = zzadyVar.zzw(this.zzd, i4);
                this.zzX = zzw22222222222;
                zzw22222222222.zzm(zzan22222222222);
                return;
            case 14:
                str5 = "audio/mpeg-L2";
                i6 = -1;
                i2 = 4096;
                list = null;
                str2 = null;
                if (this.zzO != null) {
                }
                str3 = str5;
                int i9222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                }
                if (this.zzb != null) {
                }
                zzxVar.zzR(i);
                zzxVar.zzG(true == this.zza ? "video/x-matroska" : "video/webm");
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i9222222222222);
                zzxVar.zzT(list);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzan222222222222 = zzxVar.zzan();
                zzafb zzw222222222222 = zzadyVar.zzw(this.zzd, i4);
                this.zzX = zzw222222222222;
                zzw222222222222.zzm(zzan222222222222);
                return;
            case 15:
                str5 = "audio/mpeg";
                i6 = -1;
                i2 = 4096;
                list = null;
                str2 = null;
                if (this.zzO != null) {
                }
                str3 = str5;
                int i92222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                }
                if (this.zzb != null) {
                }
                zzxVar.zzR(i);
                zzxVar.zzG(true == this.zza ? "video/x-matroska" : "video/webm");
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i92222222222222);
                zzxVar.zzT(list);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzan2222222222222 = zzxVar.zzan();
                zzafb zzw2222222222222 = zzadyVar.zzw(this.zzd, i4);
                this.zzX = zzw2222222222222;
                zzw2222222222222.zzm(zzan2222222222222);
                return;
            case 16:
                str5 = "audio/ac3";
                i2 = -1;
                i6 = -1;
                list = null;
                str2 = null;
                if (this.zzO != null) {
                }
                str3 = str5;
                int i922222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                }
                if (this.zzb != null) {
                }
                zzxVar.zzR(i);
                zzxVar.zzG(true == this.zza ? "video/x-matroska" : "video/webm");
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i922222222222222);
                zzxVar.zzT(list);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzan22222222222222 = zzxVar.zzan();
                zzafb zzw22222222222222 = zzadyVar.zzw(this.zzd, i4);
                this.zzX = zzw22222222222222;
                zzw22222222222222.zzm(zzan22222222222222);
                return;
            case 17:
                str5 = "audio/eac3";
                i2 = -1;
                i6 = -1;
                list = null;
                str2 = null;
                if (this.zzO != null) {
                }
                str3 = str5;
                int i9222222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                }
                if (this.zzb != null) {
                }
                zzxVar.zzR(i);
                zzxVar.zzG(true == this.zza ? "video/x-matroska" : "video/webm");
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i9222222222222222);
                zzxVar.zzT(list);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzan222222222222222 = zzxVar.zzan();
                zzafb zzw222222222222222 = zzadyVar.zzw(this.zzd, i4);
                this.zzX = zzw222222222222222;
                zzw222222222222222.zzm(zzan222222222222222);
                return;
            case 18:
                this.zzU = new zzafc();
                str5 = "audio/true-hd";
                i2 = -1;
                i6 = -1;
                list = null;
                str2 = null;
                if (this.zzO != null) {
                }
                str3 = str5;
                int i92222222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                }
                if (this.zzb != null) {
                }
                zzxVar.zzR(i);
                zzxVar.zzG(true == this.zza ? "video/x-matroska" : "video/webm");
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i92222222222222222);
                zzxVar.zzT(list);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzan2222222222222222 = zzxVar.zzan();
                zzafb zzw2222222222222222 = zzadyVar.zzw(this.zzd, i4);
                this.zzX = zzw2222222222222222;
                zzw2222222222222222.zzm(zzan2222222222222222);
                return;
            case 19:
            case 20:
                str5 = "audio/vnd.dts";
                i2 = -1;
                i6 = -1;
                list = null;
                str2 = null;
                if (this.zzO != null) {
                }
                str3 = str5;
                int i922222222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                }
                if (this.zzb != null) {
                }
                zzxVar.zzR(i);
                zzxVar.zzG(true == this.zza ? "video/x-matroska" : "video/webm");
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i922222222222222222);
                zzxVar.zzT(list);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzan22222222222222222 = zzxVar.zzan();
                zzafb zzw22222222222222222 = zzadyVar.zzw(this.zzd, i4);
                this.zzX = zzw22222222222222222;
                zzw22222222222222222.zzm(zzan22222222222222222);
                return;
            case 21:
                str5 = "audio/vnd.dts.hd";
                i2 = -1;
                i6 = -1;
                list = null;
                str2 = null;
                if (this.zzO != null) {
                }
                str3 = str5;
                int i9222222222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                }
                if (this.zzb != null) {
                }
                zzxVar.zzR(i);
                zzxVar.zzG(true == this.zza ? "video/x-matroska" : "video/webm");
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i9222222222222222222);
                zzxVar.zzT(list);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzan222222222222222222 = zzxVar.zzan();
                zzafb zzw222222222222222222 = zzadyVar.zzw(this.zzd, i4);
                this.zzX = zzw222222222222222222;
                zzw222222222222222222.zzm(zzan222222222222222222);
                return;
            case 22:
                zzo = Collections.singletonList(zzi(str4));
                str5 = "audio/flac";
                list = zzo;
                i2 = -1;
                i6 = -1;
                str2 = null;
                if (this.zzO != null) {
                }
                str3 = str5;
                int i92222222222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                }
                if (this.zzb != null) {
                }
                zzxVar.zzR(i);
                zzxVar.zzG(true == this.zza ? "video/x-matroska" : "video/webm");
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i92222222222222222222);
                zzxVar.zzT(list);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzan2222222222222222222 = zzxVar.zzan();
                zzafb zzw2222222222222222222 = zzadyVar.zzw(this.zzd, i4);
                this.zzX = zzw2222222222222222222;
                zzw2222222222222222222.zzm(zzan2222222222222222222);
                return;
            case 23:
                if (zzh(new zzen(zzi(this.zzc)))) {
                    i6 = zzex.zzn(this.zzQ, ByteOrder.LITTLE_ENDIAN);
                    if (i6 == 0) {
                        zzea.zzf("MatroskaExtractor", "Unsupported PCM bit depth: " + this.zzQ + ". Setting mimeType to audio/x-unknown");
                    }
                    i2 = -1;
                    list = null;
                    str2 = null;
                    if (this.zzO != null) {
                    }
                    str3 = str5;
                    int i922222222222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                    zzxVar = new zzx();
                    if (!zzay.zzh(str3)) {
                    }
                    if (this.zzb != null) {
                    }
                    zzxVar.zzR(i);
                    zzxVar.zzG(true == this.zza ? "video/x-matroska" : "video/webm");
                    zzxVar.zzah(str3);
                    zzxVar.zzX(i2);
                    zzxVar.zzW(this.zzaa);
                    zzxVar.zzaj(i922222222222222222222);
                    zzxVar.zzT(list);
                    zzxVar.zzE(str2);
                    zzxVar.zzL(this.zzl);
                    zzz zzan22222222222222222222 = zzxVar.zzan();
                    zzafb zzw22222222222222222222 = zzadyVar.zzw(this.zzd, i4);
                    this.zzX = zzw22222222222222222222;
                    zzw22222222222222222222.zzm(zzan22222222222222222222);
                    return;
                }
                zzea.zzf("MatroskaExtractor", "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown");
                i2 = -1;
                i6 = -1;
                str5 = "audio/x-unknown";
                list = null;
                str2 = null;
                if (this.zzO != null) {
                }
                str3 = str5;
                int i9222222222222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                }
                if (this.zzb != null) {
                }
                zzxVar.zzR(i);
                zzxVar.zzG(true == this.zza ? "video/x-matroska" : "video/webm");
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i9222222222222222222222);
                zzxVar.zzT(list);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzan222222222222222222222 = zzxVar.zzan();
                zzafb zzw222222222222222222222 = zzadyVar.zzw(this.zzd, i4);
                this.zzX = zzw222222222222222222222;
                zzw222222222222222222222.zzm(zzan222222222222222222222);
                return;
            case 24:
                i6 = zzex.zzn(this.zzQ, ByteOrder.LITTLE_ENDIAN);
                if (i6 == 0) {
                    zzea.zzf("MatroskaExtractor", "Unsupported little endian PCM bit depth: " + this.zzQ + ". Setting mimeType to audio/x-unknown");
                    i2 = -1;
                    i6 = -1;
                    str5 = "audio/x-unknown";
                    list = null;
                    str2 = null;
                    if (this.zzO != null) {
                    }
                    str3 = str5;
                    int i92222222222222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                    zzxVar = new zzx();
                    if (!zzay.zzh(str3)) {
                    }
                    if (this.zzb != null) {
                    }
                    zzxVar.zzR(i);
                    zzxVar.zzG(true == this.zza ? "video/x-matroska" : "video/webm");
                    zzxVar.zzah(str3);
                    zzxVar.zzX(i2);
                    zzxVar.zzW(this.zzaa);
                    zzxVar.zzaj(i92222222222222222222222);
                    zzxVar.zzT(list);
                    zzxVar.zzE(str2);
                    zzxVar.zzL(this.zzl);
                    zzz zzan2222222222222222222222 = zzxVar.zzan();
                    zzafb zzw2222222222222222222222 = zzadyVar.zzw(this.zzd, i4);
                    this.zzX = zzw2222222222222222222222;
                    zzw2222222222222222222222.zzm(zzan2222222222222222222222);
                    return;
                }
                i2 = -1;
                list = null;
                str2 = null;
                if (this.zzO != null) {
                }
                str3 = str5;
                int i922222222222222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                }
                if (this.zzb != null) {
                }
                zzxVar.zzR(i);
                zzxVar.zzG(true == this.zza ? "video/x-matroska" : "video/webm");
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i922222222222222222222222);
                zzxVar.zzT(list);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzan22222222222222222222222 = zzxVar.zzan();
                zzafb zzw22222222222222222222222 = zzadyVar.zzw(this.zzd, i4);
                this.zzX = zzw22222222222222222222222;
                zzw22222222222222222222222.zzm(zzan22222222222222222222222);
                return;
            case 25:
                int i12 = this.zzQ;
                if (i12 == 8) {
                    i6 = 3;
                } else if (i12 == 16) {
                    i6 = 268435456;
                } else if (i12 == 24) {
                    i6 = C.ENCODING_PCM_24BIT_BIG_ENDIAN;
                } else {
                    if (i12 != 32) {
                        zzea.zzf("MatroskaExtractor", "Unsupported big endian PCM bit depth: " + i12 + ". Setting mimeType to audio/x-unknown");
                        i2 = -1;
                        i6 = -1;
                        str5 = "audio/x-unknown";
                        list = null;
                        str2 = null;
                        if (this.zzO != null) {
                        }
                        str3 = str5;
                        int i9222222222222222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                        zzxVar = new zzx();
                        if (!zzay.zzh(str3)) {
                        }
                        if (this.zzb != null) {
                        }
                        zzxVar.zzR(i);
                        zzxVar.zzG(true == this.zza ? "video/x-matroska" : "video/webm");
                        zzxVar.zzah(str3);
                        zzxVar.zzX(i2);
                        zzxVar.zzW(this.zzaa);
                        zzxVar.zzaj(i9222222222222222222222222);
                        zzxVar.zzT(list);
                        zzxVar.zzE(str2);
                        zzxVar.zzL(this.zzl);
                        zzz zzan222222222222222222222222 = zzxVar.zzan();
                        zzafb zzw222222222222222222222222 = zzadyVar.zzw(this.zzd, i4);
                        this.zzX = zzw222222222222222222222222;
                        zzw222222222222222222222222.zzm(zzan222222222222222222222222);
                        return;
                    }
                    i6 = C.ENCODING_PCM_32BIT_BIG_ENDIAN;
                }
                i2 = -1;
                list = null;
                str2 = null;
                if (this.zzO != null) {
                }
                str3 = str5;
                int i92222222222222222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                }
                if (this.zzb != null) {
                }
                zzxVar.zzR(i);
                zzxVar.zzG(true == this.zza ? "video/x-matroska" : "video/webm");
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i92222222222222222222222222);
                zzxVar.zzT(list);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzan2222222222222222222222222 = zzxVar.zzan();
                zzafb zzw2222222222222222222222222 = zzadyVar.zzw(this.zzd, i4);
                this.zzX = zzw2222222222222222222222222;
                zzw2222222222222222222222222.zzm(zzan2222222222222222222222222);
                return;
            case 26:
                int i13 = this.zzQ;
                if (i13 != 32) {
                    zzea.zzf("MatroskaExtractor", "Unsupported floating point PCM bit depth: " + i13 + ". Setting mimeType to audio/x-unknown");
                    i2 = -1;
                    i6 = -1;
                    str5 = "audio/x-unknown";
                    list = null;
                    str2 = null;
                    if (this.zzO != null) {
                    }
                    str3 = str5;
                    int i922222222222222222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                    zzxVar = new zzx();
                    if (!zzay.zzh(str3)) {
                    }
                    if (this.zzb != null) {
                    }
                    zzxVar.zzR(i);
                    zzxVar.zzG(true == this.zza ? "video/x-matroska" : "video/webm");
                    zzxVar.zzah(str3);
                    zzxVar.zzX(i2);
                    zzxVar.zzW(this.zzaa);
                    zzxVar.zzaj(i922222222222222222222222222);
                    zzxVar.zzT(list);
                    zzxVar.zzE(str2);
                    zzxVar.zzL(this.zzl);
                    zzz zzan22222222222222222222222222 = zzxVar.zzan();
                    zzafb zzw22222222222222222222222222 = zzadyVar.zzw(this.zzd, i4);
                    this.zzX = zzw22222222222222222222222222;
                    zzw22222222222222222222222222.zzm(zzan22222222222222222222222222);
                    return;
                }
                i2 = -1;
                list = null;
                str2 = null;
                if (this.zzO != null) {
                }
                str3 = str5;
                int i9222222222222222222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                }
                if (this.zzb != null) {
                }
                zzxVar.zzR(i);
                zzxVar.zzG(true == this.zza ? "video/x-matroska" : "video/webm");
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i9222222222222222222222222222);
                zzxVar.zzT(list);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzan222222222222222222222222222 = zzxVar.zzan();
                zzafb zzw222222222222222222222222222 = zzadyVar.zzw(this.zzd, i4);
                this.zzX = zzw222222222222222222222222222;
                zzw222222222222222222222222222.zzm(zzan222222222222222222222222222);
                return;
            case 27:
                i2 = -1;
                i6 = -1;
                str5 = "application/x-subrip";
                list = null;
                str2 = null;
                if (this.zzO != null) {
                }
                str3 = str5;
                int i92222222222222222222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                }
                if (this.zzb != null) {
                }
                zzxVar.zzR(i);
                zzxVar.zzG(true == this.zza ? "video/x-matroska" : "video/webm");
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i92222222222222222222222222222);
                zzxVar.zzT(list);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzan2222222222222222222222222222 = zzxVar.zzan();
                zzafb zzw2222222222222222222222222222 = zzadyVar.zzw(this.zzd, i4);
                this.zzX = zzw2222222222222222222222222222;
                zzw2222222222222222222222222222.zzm(zzan2222222222222222222222222222);
                return;
            case 28:
            case 29:
                list = zzfyq.zzp(zzahy.zzb, zzi(this.zzc));
                i2 = -1;
                i6 = -1;
                str5 = "text/x-ssa";
                str2 = null;
                if (this.zzO != null) {
                }
                str3 = str5;
                int i922222222222222222222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                }
                if (this.zzb != null) {
                }
                zzxVar.zzR(i);
                zzxVar.zzG(true == this.zza ? "video/x-matroska" : "video/webm");
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i922222222222222222222222222222);
                zzxVar.zzT(list);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzan22222222222222222222222222222 = zzxVar.zzan();
                zzafb zzw22222222222222222222222222222 = zzadyVar.zzw(this.zzd, i4);
                this.zzX = zzw22222222222222222222222222222;
                zzw22222222222222222222222222222.zzm(zzan22222222222222222222222222222);
                return;
            case 30:
                str5 = "text/vtt";
                i2 = -1;
                i6 = -1;
                list = null;
                str2 = null;
                if (this.zzO != null) {
                }
                str3 = str5;
                int i9222222222222222222222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                }
                if (this.zzb != null) {
                }
                zzxVar.zzR(i);
                zzxVar.zzG(true == this.zza ? "video/x-matroska" : "video/webm");
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i9222222222222222222222222222222);
                zzxVar.zzT(list);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzan222222222222222222222222222222 = zzxVar.zzan();
                zzafb zzw222222222222222222222222222222 = zzadyVar.zzw(this.zzd, i4);
                this.zzX = zzw222222222222222222222222222222;
                zzw222222222222222222222222222222.zzm(zzan222222222222222222222222222222);
                return;
            case 31:
                zzo = zzfyq.zzo(zzi(str4));
                str5 = "application/vobsub";
                list = zzo;
                i2 = -1;
                i6 = -1;
                str2 = null;
                if (this.zzO != null) {
                }
                str3 = str5;
                int i92222222222222222222222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                }
                if (this.zzb != null) {
                }
                zzxVar.zzR(i);
                zzxVar.zzG(true == this.zza ? "video/x-matroska" : "video/webm");
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i92222222222222222222222222222222);
                zzxVar.zzT(list);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzan2222222222222222222222222222222 = zzxVar.zzan();
                zzafb zzw2222222222222222222222222222222 = zzadyVar.zzw(this.zzd, i4);
                this.zzX = zzw2222222222222222222222222222222;
                zzw2222222222222222222222222222222.zzm(zzan2222222222222222222222222222222);
                return;
            case ' ':
                str5 = "application/pgs";
                i2 = -1;
                i6 = -1;
                list = null;
                str2 = null;
                if (this.zzO != null) {
                }
                str3 = str5;
                int i922222222222222222222222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                }
                if (this.zzb != null) {
                }
                zzxVar.zzR(i);
                zzxVar.zzG(true == this.zza ? "video/x-matroska" : "video/webm");
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i922222222222222222222222222222222);
                zzxVar.zzT(list);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzan22222222222222222222222222222222 = zzxVar.zzan();
                zzafb zzw22222222222222222222222222222222 = zzadyVar.zzw(this.zzd, i4);
                this.zzX = zzw22222222222222222222222222222222;
                zzw22222222222222222222222222222222.zzm(zzan22222222222222222222222222222222);
                return;
            case '!':
                byte[] bArr5 = new byte[4];
                System.arraycopy(zzi(str4), 0, bArr5, 0, 4);
                zzo = zzfyq.zzo(bArr5);
                str5 = "application/dvbsubs";
                list = zzo;
                i2 = -1;
                i6 = -1;
                str2 = null;
                if (this.zzO != null) {
                }
                str3 = str5;
                int i9222222222222222222222222222222222 = (this.zzW ? 1 : 0) | (true == this.zzV ? 0 : 2);
                zzxVar = new zzx();
                if (!zzay.zzh(str3)) {
                }
                if (this.zzb != null) {
                }
                zzxVar.zzR(i);
                zzxVar.zzG(true == this.zza ? "video/x-matroska" : "video/webm");
                zzxVar.zzah(str3);
                zzxVar.zzX(i2);
                zzxVar.zzW(this.zzaa);
                zzxVar.zzaj(i9222222222222222222222222222222222);
                zzxVar.zzT(list);
                zzxVar.zzE(str2);
                zzxVar.zzL(this.zzl);
                zzz zzan222222222222222222222222222222222 = zzxVar.zzan();
                zzafb zzw222222222222222222222222222222222 = zzadyVar.zzw(this.zzd, i4);
                this.zzX = zzw222222222222222222222222222222222;
                zzw222222222222222222222222222222222.zzm(zzan222222222222222222222222222222222);
                return;
            default:
                throw zzaz.zza("Unrecognized codec identifier.", null);
        }
    }
}
