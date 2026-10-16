package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzajc {
    public final zzafb zza;
    public zzajs zzd;
    public zzaiy zze;
    public int zzf;
    public int zzg;
    public int zzh;
    public int zzi;
    private final String zzj;
    private boolean zzm;
    public final zzajr zzb = new zzajr();
    public final zzen zzc = new zzen();
    private final zzen zzk = new zzen(1);
    private final zzen zzl = new zzen();

    public zzajc(zzafb zzafbVar, zzajs zzajsVar, zzaiy zzaiyVar, String str) {
        this.zza = zzafbVar;
        this.zzd = zzajsVar;
        this.zze = zzaiyVar;
        this.zzj = str;
        zzh(zzajsVar, zzaiyVar);
    }

    public final int zza() {
        int i = !this.zzm ? this.zzd.zzg[this.zzf] : this.zzb.zzj[this.zzf] ? 1 : 0;
        return zzf() != null ? i | 1073741824 : i;
    }

    public final int zzb() {
        return !this.zzm ? this.zzd.zzd[this.zzf] : this.zzb.zzh[this.zzf];
    }

    public final int zzc(int i, int i2) {
        zzen zzenVar;
        zzajq zzf = zzf();
        if (zzf == null) {
            return 0;
        }
        int i3 = zzf.zzd;
        if (i3 != 0) {
            zzenVar = this.zzb.zzn;
        } else {
            byte[] bArr = zzf.zze;
            String str = zzex.zza;
            zzen zzenVar2 = this.zzl;
            byte[] bArr2 = bArr;
            int length = bArr2.length;
            zzenVar2.zzJ(bArr2, length);
            zzenVar = zzenVar2;
            i3 = length;
        }
        zzajr zzajrVar = this.zzb;
        boolean zzb = zzajrVar.zzb(this.zzf);
        boolean z = zzb || i2 != 0;
        zzen zzenVar3 = this.zzk;
        zzenVar3.zzN()[0] = (byte) ((true != z ? 0 : 128) | i3);
        zzenVar3.zzL(0);
        zzafb zzafbVar = this.zza;
        zzafbVar.zzs(zzenVar3, 1, 1);
        zzafbVar.zzs(zzenVar, i3, 1);
        if (!z) {
            return i3 + 1;
        }
        if (!zzb) {
            zzen zzenVar4 = this.zzc;
            zzenVar4.zzI(8);
            byte[] zzN = zzenVar4.zzN();
            zzN[0] = 0;
            zzN[1] = 1;
            zzN[2] = 0;
            zzN[3] = (byte) i2;
            zzN[4] = (byte) ((i >> 24) & 255);
            zzN[5] = (byte) ((i >> 16) & 255);
            zzN[6] = (byte) ((i >> 8) & 255);
            zzN[7] = (byte) (i & 255);
            zzafbVar.zzs(zzenVar4, 8, 1);
            return i3 + 9;
        }
        int i4 = i3 + 1;
        zzen zzenVar5 = zzajrVar.zzn;
        int zzq = zzenVar5.zzq();
        zzenVar5.zzM(-2);
        int i5 = (zzq * 6) + 2;
        if (i2 != 0) {
            zzen zzenVar6 = this.zzc;
            zzenVar6.zzI(i5);
            byte[] zzN2 = zzenVar6.zzN();
            zzenVar5.zzH(zzN2, 0, i5);
            int i6 = (((zzN2[2] & 255) << 8) | (zzN2[3] & 255)) + i2;
            zzN2[2] = (byte) ((i6 >> 8) & 255);
            zzN2[3] = (byte) (i6 & 255);
            zzenVar5 = zzenVar6;
        }
        zzafbVar.zzs(zzenVar5, i5, 1);
        return i4 + i5;
    }

    public final long zzd() {
        return !this.zzm ? this.zzd.zzc[this.zzf] : this.zzb.zzf[this.zzh];
    }

    public final long zze() {
        if (!this.zzm) {
            return this.zzd.zzf[this.zzf];
        }
        zzajr zzajrVar = this.zzb;
        return zzajrVar.zzi[this.zzf];
    }

    public final zzajq zzf() {
        if (!this.zzm) {
            return null;
        }
        zzajr zzajrVar = this.zzb;
        zzaiy zzaiyVar = zzajrVar.zza;
        String str = zzex.zza;
        int i = zzaiyVar.zza;
        zzajq zzajqVar = zzajrVar.zzm;
        if (zzajqVar == null) {
            zzajqVar = this.zzd.zza.zzb(i);
        }
        if (zzajqVar == null || !zzajqVar.zza) {
            return null;
        }
        return zzajqVar;
    }

    public final void zzh(zzajs zzajsVar, zzaiy zzaiyVar) {
        this.zzd = zzajsVar;
        this.zze = zzaiyVar;
        zzx zzb = zzajsVar.zza.zzg.zzb();
        zzb.zzG(this.zzj);
        this.zza.zzm(zzb.zzan());
        zzi();
    }

    public final void zzi() {
        zzajr zzajrVar = this.zzb;
        zzajrVar.zzd = 0;
        zzajrVar.zzp = 0L;
        zzajrVar.zzq = false;
        zzajrVar.zzk = false;
        zzajrVar.zzo = false;
        zzajrVar.zzm = null;
        this.zzf = 0;
        this.zzh = 0;
        this.zzg = 0;
        this.zzi = 0;
        this.zzm = false;
    }

    public final void zzj(zzs zzsVar) {
        zzajp zzajpVar = this.zzd.zza;
        zzaiy zzaiyVar = this.zzb.zza;
        String str = zzex.zza;
        zzajq zzb = zzajpVar.zzb(zzaiyVar.zza);
        zzs zzb2 = zzsVar.zzb(zzb != null ? zzb.zzb : null);
        zzz zzzVar = this.zzd.zza.zzg;
        String str2 = this.zzj;
        zzx zzb3 = zzzVar.zzb();
        zzb3.zzG(str2);
        zzb3.zzL(zzb2);
        this.zza.zzm(zzb3.zzan());
    }

    public final boolean zzl() {
        this.zzf++;
        if (!this.zzm) {
            return false;
        }
        int i = this.zzg + 1;
        this.zzg = i;
        int[] iArr = this.zzb.zzg;
        int i2 = this.zzh;
        if (i != iArr[i2]) {
            return true;
        }
        this.zzh = i2 + 1;
        this.zzg = 0;
        return false;
    }
}
