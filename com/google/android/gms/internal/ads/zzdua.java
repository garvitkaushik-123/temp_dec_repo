package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdua implements zzdtk {
    private final long zza;
    private final zzdtp zzb;
    private final zzfbr zzc;

    zzdua(long j, Context context, zzdtp zzdtpVar, zzche zzcheVar, String str) {
        this.zza = j;
        this.zzb = zzdtpVar;
        zzfbt zzv = zzcheVar.zzv();
        zzv.zzb(context);
        zzv.zza(str);
        this.zzc = zzv.zzc().zza();
    }

    @Override // com.google.android.gms.internal.ads.zzdtk
    public final void zza() {
    }

    @Override // com.google.android.gms.internal.ads.zzdtk
    public final void zzb(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        try {
            this.zzc.zzh(zzmVar, new zzdty(this));
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdtk
    public final void zzc() {
        try {
            zzfbr zzfbrVar = this.zzc;
            zzfbrVar.zzn(new zzdtz(this));
            zzfbrVar.zzp(ObjectWrapper.wrap(null));
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }
}
