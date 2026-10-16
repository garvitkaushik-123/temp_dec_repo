package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzzm {
    private int zza;
    private int zzb;
    private int zzc = 0;
    private zzzf[] zzd = new zzzf[100];

    public zzzm(boolean z, int i) {
    }

    public final synchronized int zza() {
        return this.zzb * 65536;
    }

    public final synchronized zzzf zzb() {
        zzzf zzzfVar;
        this.zzb++;
        int i = this.zzc;
        if (i > 0) {
            zzzf[] zzzfVarArr = this.zzd;
            int i2 = i - 1;
            this.zzc = i2;
            zzzfVar = zzzfVarArr[i2];
            if (zzzfVar == null) {
                throw null;
            }
            zzzf zzzfVar2 = zzzfVar;
            zzzfVarArr[i2] = null;
        } else {
            zzzfVar = new zzzf(new byte[65536], 0);
            int i3 = this.zzb;
            zzzf[] zzzfVarArr2 = this.zzd;
            int length = zzzfVarArr2.length;
            if (i3 > length) {
                this.zzd = (zzzf[]) Arrays.copyOf(zzzfVarArr2, length + length);
                return zzzfVar;
            }
        }
        return zzzfVar;
    }

    public final synchronized void zzc(zzzf zzzfVar) {
        zzzf[] zzzfVarArr = this.zzd;
        int i = this.zzc;
        this.zzc = i + 1;
        zzzfVarArr[i] = zzzfVar;
        this.zzb--;
        notifyAll();
    }

    public final synchronized void zzd(zzzg zzzgVar) {
        while (zzzgVar != null) {
            zzzf[] zzzfVarArr = this.zzd;
            int i = this.zzc;
            this.zzc = i + 1;
            zzzfVarArr[i] = zzzgVar.zzc();
            this.zzb--;
            zzzgVar = zzzgVar.zzd();
        }
        notifyAll();
    }

    public final synchronized void zze() {
        zzf(0);
    }

    public final synchronized void zzf(int i) {
        int i2 = this.zza;
        this.zza = i;
        if (i < i2) {
            zzg();
        }
    }

    public final synchronized void zzg() {
        int i = this.zza;
        String str = zzex.zza;
        int max = Math.max(0, ((i + 65535) / 65536) - this.zzb);
        int i2 = this.zzc;
        if (max >= i2) {
            return;
        }
        Arrays.fill(this.zzd, max, i2, (Object) null);
        this.zzc = max;
    }
}
