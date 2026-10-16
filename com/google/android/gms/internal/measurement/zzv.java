package com.google.android.gms.internal.measurement;

import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes5.dex */
public final class zzv extends zzai {
    private final zzz zza;

    public zzv(zzz zzzVar) {
        super("internal.registerCallback");
        this.zza = zzzVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzai
    public final zzap zza(zzg zzgVar, List list) {
        zzh.zzh(this.zzd, 3, list);
        String zzi = zzgVar.zzb((zzap) list.get(0)).zzi();
        zzap zzb = zzgVar.zzb((zzap) list.get(1));
        if (!(zzb instanceof zzao)) {
            throw new IllegalArgumentException("Invalid callback type");
        }
        zzap zzb2 = zzgVar.zzb((zzap) list.get(2));
        if (!(zzb2 instanceof zzam)) {
            throw new IllegalArgumentException("Invalid callback params");
        }
        zzam zzamVar = (zzam) zzb2;
        if (!zzamVar.zzt("type")) {
            throw new IllegalArgumentException("Undefined rule type");
        }
        this.zza.zza(zzi, zzamVar.zzt(HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY) ? zzh.zzb(zzamVar.zzf(HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY).zzh().doubleValue()) : 1000, (zzao) zzb, zzamVar.zzf("type").zzi());
        return zzap.zzf;
    }
}
