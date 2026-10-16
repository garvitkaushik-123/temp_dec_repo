package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzefa implements zzdgn {
    final /* synthetic */ zzcak zza;
    final /* synthetic */ zzfca zzb;
    final /* synthetic */ zzefb zzc;

    zzefa(zzefb zzefbVar, zzcak zzcakVar, zzfca zzfcaVar) {
        this.zza = zzcakVar;
        this.zzb = zzfcaVar;
        Objects.requireNonNull(zzefbVar);
        this.zzc = zzefbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgn
    public final zzfca zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzdgn
    public final void zzb(boolean z, Context context, zzcwl zzcwlVar) {
        zzdsj zzdsjVar;
        try {
            com.google.android.gms.ads.internal.zzv.zzj();
            AdOverlayInfoParcel adOverlayInfoParcel = (AdOverlayInfoParcel) this.zza.get();
            zzdsjVar = this.zzc.zze;
            com.google.android.gms.ads.internal.overlay.zzn.zza(context, adOverlayInfoParcel, true, zzdsjVar);
        } catch (Exception unused) {
        }
    }
}
