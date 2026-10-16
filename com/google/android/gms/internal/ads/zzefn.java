package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzefn implements zzdgn {
    final /* synthetic */ zzedp zza;
    final /* synthetic */ zzfca zzb;
    final /* synthetic */ zzefo zzc;

    zzefn(zzefo zzefoVar, zzedp zzedpVar, zzfca zzfcaVar) {
        this.zza = zzedpVar;
        this.zzb = zzfcaVar;
        Objects.requireNonNull(zzefoVar);
        this.zzc = zzefoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgn
    public final zzfca zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzdgn
    public final void zzb(boolean z, Context context, zzcwl zzcwlVar) throws zzdgm {
        VersionInfoParcel versionInfoParcel;
        try {
            zzfdu zzfduVar = (zzfdu) this.zza.zzb;
            zzfduVar.zzv(z);
            versionInfoParcel = this.zzc.zzc;
            if (versionInfoParcel.clientJarVersion < ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzaW)).intValue()) {
                zzfduVar.zzx();
            } else {
                zzfduVar.zzy(context);
            }
        } catch (zzfdd e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Cannot show interstitial.");
            throw new zzdgm(e.getCause());
        }
    }
}
