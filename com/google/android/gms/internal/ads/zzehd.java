package com.google.android.gms.internal.ads;

import java.util.Iterator;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzehd {
    private final zzfdo zza;
    private final zzdpw zzb;
    private final zzdsj zzc;

    public zzehd(zzfdo zzfdoVar, zzdpw zzdpwVar, zzdsj zzdsjVar) {
        this.zza = zzfdoVar;
        this.zzb = zzdpwVar;
        this.zzc = zzdsjVar;
    }

    public final void zza(zzfcd zzfcdVar, zzfca zzfcaVar, int i, @Nullable zzedq zzedqVar, long j) {
        zzdpv zzdpvVar;
        zzdsi zza = this.zzc.zza();
        zza.zzd(zzfcdVar);
        zza.zzc(zzfcaVar);
        zza.zzb("action", "adapter_status");
        zza.zzb("adapter_l", String.valueOf(j));
        zza.zzb("sc", Integer.toString(i));
        if (zzedqVar != null) {
            zza.zzb("arec", Integer.toString(zzedqVar.zzb().zza));
            String zza2 = this.zza.zza(zzedqVar.getMessage());
            if (zza2 != null) {
                zza.zzb("areec", zza2);
            }
        }
        zzdpw zzdpwVar = this.zzb;
        Iterator it = zzfcaVar.zzt.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzdpvVar = null;
                break;
            } else {
                zzdpvVar = zzdpwVar.zza((String) it.next());
                if (zzdpvVar != null) {
                    break;
                }
            }
        }
        if (zzdpvVar != null) {
            zza.zzb("ancn", zzdpvVar.zza);
            zzbse zzbseVar = zzdpvVar.zzb;
            if (zzbseVar != null) {
                zza.zzb("adapter_v", zzbseVar.toString());
            }
            zzbse zzbseVar2 = zzdpvVar.zzc;
            if (zzbseVar2 != null) {
                zza.zzb("adapter_sv", zzbseVar2.toString());
            }
        }
        zza.zzj();
    }
}
