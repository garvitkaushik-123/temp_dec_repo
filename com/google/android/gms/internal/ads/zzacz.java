package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzacz {
    public final List zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final int zzj;
    public final float zzk;
    public final String zzl;

    private zzacz(List list, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, float f, String str) {
        this.zza = list;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = i4;
        this.zzf = i5;
        this.zzg = i6;
        this.zzh = i7;
        this.zzi = i8;
        this.zzj = i9;
        this.zzk = f;
        this.zzl = str;
    }

    public static zzacz zza(zzen zzenVar) throws zzaz {
        String str;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        float f;
        int i7;
        int i8;
        try {
            zzenVar.zzM(4);
            int zzm = (zzenVar.zzm() & 3) + 1;
            if (zzm == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int zzm2 = zzenVar.zzm() & 31;
            for (int i9 = 0; i9 < zzm2; i9++) {
                arrayList.add(zzb(zzenVar));
            }
            int zzm3 = zzenVar.zzm();
            for (int i10 = 0; i10 < zzm3; i10++) {
                arrayList.add(zzb(zzenVar));
            }
            if (zzm2 > 0) {
                byte[] bArr = (byte[]) arrayList.get(0);
                byte[] bArr2 = (byte[]) arrayList.get(0);
                byte[] bArr3 = zzfv.zza;
                zzfu zzg = zzfv.zzg(bArr2, 5, bArr.length);
                int i11 = zzg.zze;
                int i12 = zzg.zzf;
                int i13 = zzg.zzh + 8;
                int i14 = zzg.zzi + 8;
                int i15 = zzg.zzj;
                int i16 = zzg.zzk;
                int i17 = zzg.zzl;
                int i18 = zzg.zzm;
                float f2 = zzg.zzg;
                str = zzdk.zzc(zzg.zza, zzg.zzb, zzg.zzc);
                i5 = i17;
                i6 = i18;
                f = f2;
                i4 = i14;
                i7 = i15;
                i8 = i16;
                i = i11;
                i2 = i12;
                i3 = i13;
            } else {
                str = null;
                i = -1;
                i2 = -1;
                i3 = -1;
                i4 = -1;
                i5 = -1;
                i6 = 16;
                f = 1.0f;
                i7 = -1;
                i8 = -1;
            }
            return new zzacz(arrayList, zzm, i, i2, i3, i4, i7, i8, i5, i6, f, str);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw zzaz.zza("Error parsing AVC config", e);
        }
    }

    private static byte[] zzb(zzen zzenVar) {
        int zzq = zzenVar.zzq();
        int zzc = zzenVar.zzc();
        zzenVar.zzM(zzq);
        return zzdk.zze(zzenVar.zzN(), zzc, zzq);
    }
}
