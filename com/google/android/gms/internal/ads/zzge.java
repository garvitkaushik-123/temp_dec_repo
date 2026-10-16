package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzge extends zzgc {
    private Uri zza;
    private byte[] zzb;
    private int zzc;
    private int zzd;
    private boolean zze;
    private final zzgd zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzge(byte[] bArr) {
        super(false);
        zzgd zzgdVar = new zzgd(bArr);
        this.zzf = zzgdVar;
        zzdd.zzd(bArr.length > 0);
    }

    @Override // com.google.android.gms.internal.ads.zzl
    public final int zza(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.zzd;
        if (i3 == 0) {
            return -1;
        }
        int min = Math.min(i2, i3);
        byte[] bArr2 = this.zzb;
        zzdd.zzb(bArr2);
        System.arraycopy(bArr2, this.zzc, bArr, i, min);
        this.zzc += min;
        this.zzd -= min;
        zzg(min);
        return min;
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final long zzb(zzgo zzgoVar) throws IOException {
        zzi(zzgoVar);
        this.zza = zzgoVar.zza;
        this.zzb = this.zzf.zza;
        long j = zzgoVar.zze;
        int length = this.zzb.length;
        if (j > length) {
            throw new zzgk(2008);
        }
        int i = (int) j;
        this.zzc = i;
        int i2 = length - i;
        this.zzd = i2;
        long j2 = zzgoVar.zzf;
        if (j2 != -1) {
            this.zzd = (int) Math.min(i2, j2);
        }
        this.zze = true;
        zzj(zzgoVar);
        return j2 != -1 ? j2 : this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final Uri zzc() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final void zzd() {
        if (this.zze) {
            this.zze = false;
            zzh();
        }
        this.zza = null;
        this.zzb = null;
    }
}
