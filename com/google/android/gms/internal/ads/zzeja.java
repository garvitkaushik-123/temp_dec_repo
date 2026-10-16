package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzeja implements zzedm {
    private final Context zza;
    private final zzcpx zzb;
    private final zzbdz zzc;
    private final zzgdy zzd;
    private final zzfha zze;

    public zzeja(Context context, zzcpx zzcpxVar, zzfha zzfhaVar, zzgdy zzgdyVar, zzbdz zzbdzVar) {
        this.zza = context;
        this.zzb = zzcpxVar;
        this.zze = zzfhaVar;
        this.zzd = zzgdyVar;
        this.zzc = zzbdzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzedm
    public final ListenableFuture zza(zzfcn zzfcnVar, zzfca zzfcaVar) {
        zzeiy zzeiyVar = new zzeiy(this, new View(this.zza), null, new zzcqy() { // from class: com.google.android.gms.internal.ads.zzeiw
            @Override // com.google.android.gms.internal.ads.zzcqy
            public final com.google.android.gms.ads.internal.client.zzed zza() {
                return null;
            }
        }, (zzfcb) zzfcaVar.zzu.get(0));
        zzcot zza = this.zzb.zza(new zzcrq(zzfcnVar, zzfcaVar, null), zzeiyVar);
        zzeiz zzm = zza.zzm();
        zzfcf zzfcfVar = zzfcaVar.zzs;
        final zzbdu zzbduVar = new zzbdu(zzm, zzfcfVar.zzb, zzfcfVar.zza);
        zzfgu zzfguVar = zzfgu.CUSTOM_RENDER_SYN;
        zzfha zzfhaVar = this.zze;
        Objects.requireNonNull(zzfhaVar);
        return zzfgk.zzd(new zzfgf() { // from class: com.google.android.gms.internal.ads.zzeix
            @Override // com.google.android.gms.internal.ads.zzfgf
            public final void zza() {
                zzeja.this.zzc.zze(zzbduVar);
            }
        }, this.zzd, zzfguVar, zzfhaVar).zzb(zzfgu.CUSTOM_RENDER_ACK).zzd(zzgdn.zzh(zza.zza())).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzedm
    public final boolean zzb(zzfcn zzfcnVar, zzfca zzfcaVar) {
        zzfcf zzfcfVar;
        return (this.zzc == null || (zzfcfVar = zzfcaVar.zzs) == null || zzfcfVar.zza == null) ? false : true;
    }
}
