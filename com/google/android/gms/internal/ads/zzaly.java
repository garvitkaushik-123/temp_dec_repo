package com.google.android.gms.internal.ads;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.common.base.Ascii;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzaly implements zzakt {
    private final zzen zza = new zzen();
    private final boolean zzb;
    private final int zzc;
    private final int zzd;
    private final String zze;
    private final float zzf;
    private final int zzg;

    public zzaly(List list) {
        if (list.size() != 1 || (((byte[]) list.get(0)).length != 48 && ((byte[]) list.get(0)).length != 53)) {
            this.zzc = 0;
            this.zzd = -1;
            this.zze = "sans-serif";
            this.zzb = false;
            this.zzf = 0.85f;
            this.zzg = -1;
            return;
        }
        byte[] bArr = (byte[]) list.get(0);
        this.zzc = bArr[24];
        this.zzd = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
        this.zze = true == "Serif".equals(zzex.zzC(bArr, 43, bArr.length + (-43))) ? "serif" : "sans-serif";
        int i = bArr[25] * Ascii.DC4;
        this.zzg = i;
        boolean z = (bArr[0] & 32) != 0;
        this.zzb = z;
        if (z) {
            this.zzf = Math.max(0.0f, Math.min(((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / i, 0.95f));
        } else {
            this.zzf = 0.85f;
        }
    }

    private static void zzb(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i >>> 8) | ((i & 255) << 24)), i3, i4, i5 | 33);
        }
    }

    private static void zzc(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            int i6 = i5 | 33;
            int i7 = i & 1;
            int i8 = i & 2;
            boolean z = true;
            if (i7 == 0) {
                if (i8 != 0) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), i3, i4, i6);
                }
                z = false;
            } else if (i8 != 0) {
                spannableStringBuilder.setSpan(new StyleSpan(3), i3, i4, i6);
            } else {
                spannableStringBuilder.setSpan(new StyleSpan(1), i3, i4, i6);
                z = false;
            }
            if ((i & 4) != 0) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i3, i4, i6);
            } else {
                if (i7 != 0 || z) {
                    return;
                }
                spannableStringBuilder.setSpan(new StyleSpan(0), i3, i4, i6);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzakt
    public final void zza(byte[] bArr, int i, int i2, zzaks zzaksVar, zzdn zzdnVar) {
        String zzB;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        zzen zzenVar = this.zza;
        zzenVar.zzJ(bArr, i + i2);
        zzenVar.zzL(i);
        int i12 = 1;
        int i13 = 0;
        int i14 = 2;
        zzdd.zzd(zzenVar.zza() >= 2);
        int zzq = zzenVar.zzq();
        if (zzq == 0) {
            zzB = "";
        } else {
            int zzc = zzenVar.zzc();
            Charset zzC = zzenVar.zzC();
            int zzc2 = zzenVar.zzc() - zzc;
            if (zzC == null) {
                zzC = StandardCharsets.UTF_8;
            }
            zzB = zzenVar.zzB(zzq - zzc2, zzC);
        }
        if (zzB.isEmpty()) {
            zzdnVar.zza(new zzakl(zzfyq.zzn(), -9223372036854775807L, -9223372036854775807L));
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(zzB);
        int i15 = this.zzc;
        zzc(spannableStringBuilder, i15, 0, 0, spannableStringBuilder.length(), 16711680);
        int i16 = i15;
        int i17 = this.zzd;
        zzb(spannableStringBuilder, i17, -1, 0, spannableStringBuilder.length(), 16711680);
        int i18 = i17;
        String str = this.zze;
        int length = spannableStringBuilder.length();
        if (str != "sans-serif") {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), 0, length, 16711713);
        }
        float f = this.zzf;
        while (zzenVar.zza() >= 8) {
            int zzc3 = zzenVar.zzc();
            int zzg = zzenVar.zzg();
            int zzg2 = zzenVar.zzg();
            if (zzg2 == 1937013100) {
                zzdd.zzd(zzenVar.zza() >= i14 ? i12 : i13);
                int zzq2 = zzenVar.zzq();
                int i19 = i13;
                while (i19 < zzq2) {
                    zzdd.zzd(zzenVar.zza() >= 12 ? i12 : i13);
                    int zzq3 = zzenVar.zzq();
                    int zzq4 = zzenVar.zzq();
                    zzenVar.zzM(i14);
                    int i20 = zzq2;
                    int zzm = zzenVar.zzm();
                    zzenVar.zzM(i12);
                    int zzg3 = zzenVar.zzg();
                    if (zzq4 > spannableStringBuilder.length()) {
                        i6 = i16;
                        i7 = i18;
                        zzea.zzf("Tx3gParser", "Truncating styl end (" + zzq4 + ") to cueText.length() (" + spannableStringBuilder.length() + ").");
                        zzq4 = spannableStringBuilder.length();
                    } else {
                        i6 = i16;
                        i7 = i18;
                    }
                    if (zzq3 >= zzq4) {
                        zzea.zzf("Tx3gParser", "Ignoring styl with start (" + zzq3 + ") >= end (" + zzq4 + ").");
                        i10 = i6;
                        i9 = i19;
                        i8 = i20;
                        i11 = i7;
                    } else {
                        i8 = i20;
                        i9 = i19;
                        int i21 = i6;
                        zzc(spannableStringBuilder, zzm, i21, zzq3, zzq4, 0);
                        i10 = i21;
                        i11 = i7;
                        zzb(spannableStringBuilder, zzg3, i11, zzq3, zzq4, 0);
                    }
                    zzq2 = i8;
                    i16 = i10;
                    i18 = i11;
                    i12 = 1;
                    i14 = 2;
                    i19 = i9 + 1;
                    i13 = 0;
                }
                i3 = i16;
                i4 = i18;
                i5 = i14;
            } else {
                i3 = i16;
                i4 = i18;
                if (zzg2 == 1952608120 && this.zzb) {
                    i5 = 2;
                    zzdd.zzd(zzenVar.zza() >= 2);
                    float zzq5 = zzenVar.zzq();
                    int i22 = this.zzg;
                    String str2 = zzex.zza;
                    f = Math.max(0.0f, Math.min(zzq5 / i22, 0.95f));
                } else {
                    i5 = 2;
                }
            }
            zzenVar.zzL(zzc3 + zzg);
            i16 = i3;
            i14 = i5;
            i18 = i4;
            i12 = 1;
            i13 = 0;
        }
        zzcs zzcsVar = new zzcs();
        zzcsVar.zzl(spannableStringBuilder);
        zzcsVar.zze(f, 0);
        zzcsVar.zzf(0);
        zzdnVar.zza(new zzakl(zzfyq.zzo(zzcsVar.zzq()), -9223372036854775807L, -9223372036854775807L));
    }
}
