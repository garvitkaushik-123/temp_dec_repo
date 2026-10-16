package com.google.android.gms.internal.ads;

import android.text.Layout;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzamj {
    public CharSequence zzc;
    public long zza = 0;
    public long zzb = 0;
    public int zzd = 2;
    public float zze = -3.4028235E38f;
    public int zzf = 1;
    public int zzg = 0;
    public float zzh = -3.4028235E38f;
    public int zzi = Integer.MIN_VALUE;
    public float zzj = 1.0f;
    public int zzk = Integer.MIN_VALUE;

    /* JADX WARN: Code restructure failed: missing block: B:51:0x007b, code lost:
    
        if (r6 == 0) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzcs zza() {
        Layout.Alignment alignment;
        float f;
        CharSequence charSequence;
        float f2 = this.zzh;
        float f3 = -3.4028235E38f;
        if (f2 == -3.4028235E38f) {
            int i = this.zzd;
            f2 = i != 4 ? i != 5 ? 0.5f : 1.0f : 0.0f;
        }
        int i2 = this.zzi;
        if (i2 == Integer.MIN_VALUE) {
            int i3 = this.zzd;
            if (i3 != 1) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            i2 = 1;
                        }
                    }
                }
                i2 = 2;
            }
            i2 = 0;
        }
        zzcs zzcsVar = new zzcs();
        int i4 = this.zzd;
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 4) {
                        if (i4 != 5) {
                            zzea.zzf("WebvttCueParser", "Unknown textAlignment: " + i4);
                            alignment = null;
                        }
                    }
                }
                alignment = Layout.Alignment.ALIGN_OPPOSITE;
            } else {
                alignment = Layout.Alignment.ALIGN_CENTER;
            }
            zzcsVar.zzm(alignment);
            f = this.zze;
            int i5 = this.zzf;
            if (f != -3.4028235E38f || i5 != 0 || (f >= 0.0f && f <= 1.0f)) {
                if (f == -3.4028235E38f) {
                    f3 = f;
                }
                zzcsVar.zze(f3, i5);
                zzcsVar.zzf(this.zzg);
                zzcsVar.zzh(f2);
                zzcsVar.zzi(i2);
                float f4 = this.zzj;
                if (i2 == 0) {
                    f2 = 1.0f - f2;
                } else if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException(String.valueOf(i2));
                    }
                } else if (f2 <= 0.5f) {
                    f2 += f2;
                } else {
                    float f5 = 1.0f - f2;
                    f2 = f5 + f5;
                }
                zzcsVar.zzk(Math.min(f4, f2));
                zzcsVar.zzo(this.zzk);
                charSequence = this.zzc;
                if (charSequence != null) {
                    zzcsVar.zzl(charSequence);
                }
                return zzcsVar;
            }
            f3 = 1.0f;
            zzcsVar.zze(f3, i5);
            zzcsVar.zzf(this.zzg);
            zzcsVar.zzh(f2);
            zzcsVar.zzi(i2);
            float f42 = this.zzj;
            if (i2 == 0) {
            }
            zzcsVar.zzk(Math.min(f42, f2));
            zzcsVar.zzo(this.zzk);
            charSequence = this.zzc;
            if (charSequence != null) {
            }
            return zzcsVar;
        }
        alignment = Layout.Alignment.ALIGN_NORMAL;
        zzcsVar.zzm(alignment);
        f = this.zze;
        int i52 = this.zzf;
        if (f != -3.4028235E38f) {
        }
        if (f == -3.4028235E38f) {
        }
        zzcsVar.zze(f3, i52);
        zzcsVar.zzf(this.zzg);
        zzcsVar.zzh(f2);
        zzcsVar.zzi(i2);
        float f422 = this.zzj;
        if (i2 == 0) {
        }
        zzcsVar.zzk(Math.min(f422, f2));
        zzcsVar.zzo(this.zzk);
        charSequence = this.zzc;
        if (charSequence != null) {
        }
        return zzcsVar;
    }
}
