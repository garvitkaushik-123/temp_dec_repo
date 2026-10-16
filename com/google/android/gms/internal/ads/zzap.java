package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzap {
    public final String zza;
    public final zzak zzb;
    public final zzaj zzc;
    public final zzat zzd;
    public final zzaf zze;
    public final zzam zzf;

    static {
        new zzad().zzc();
        String str = zzex.zza;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
    }

    /* synthetic */ zzap(String str, zzag zzagVar, zzak zzakVar, zzaj zzajVar, zzat zzatVar, zzam zzamVar, zzao zzaoVar) {
        this.zza = str;
        this.zzb = zzakVar;
        this.zzc = zzajVar;
        this.zzd = zzatVar;
        this.zze = zzagVar;
        this.zzf = zzamVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzap)) {
            return false;
        }
        zzap zzapVar = (zzap) obj;
        return Objects.equals(this.zza, zzapVar.zza) && this.zze.equals(zzapVar.zze) && Objects.equals(this.zzb, zzapVar.zzb) && Objects.equals(this.zzc, zzapVar.zzc) && Objects.equals(this.zzd, zzapVar.zzd) && Objects.equals(this.zzf, zzapVar.zzf);
    }

    public final int hashCode() {
        int hashCode = this.zza.hashCode() * 31;
        zzak zzakVar = this.zzb;
        return (((((((hashCode + (zzakVar != null ? zzakVar.hashCode() : 0)) * 31) + this.zzc.hashCode()) * 31) + this.zze.hashCode()) * 31) + this.zzd.hashCode()) * 31;
    }
}
