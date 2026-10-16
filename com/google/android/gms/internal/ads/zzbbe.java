package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.appopen.AppOpenAd;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbbe {
    private com.google.android.gms.ads.internal.client.zzbx zza;
    private final Context zzb;
    private final String zzc;
    private final com.google.android.gms.ads.internal.client.zzek zzd;
    private final AppOpenAd.AppOpenAdLoadCallback zze;
    private final zzbpm zzf = new zzbpm();
    private final com.google.android.gms.ads.internal.client.zzq zzg = com.google.android.gms.ads.internal.client.zzq.zza;

    public zzbbe(Context context, String str, com.google.android.gms.ads.internal.client.zzek zzekVar, AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback) {
        this.zzb = context;
        this.zzc = str;
        this.zzd = zzekVar;
        this.zze = appOpenAdLoadCallback;
    }

    public final void zza() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            com.google.android.gms.ads.internal.client.zzr zzb = com.google.android.gms.ads.internal.client.zzr.zzb();
            com.google.android.gms.ads.internal.client.zzaz zza = com.google.android.gms.ads.internal.client.zzbb.zza();
            Context context = this.zzb;
            String str = this.zzc;
            com.google.android.gms.ads.internal.client.zzbx zze = zza.zze(context, zzb, str, this.zzf);
            this.zza = zze;
            if (zze != null) {
                com.google.android.gms.ads.internal.client.zzek zzekVar = this.zzd;
                zzekVar.zzp(currentTimeMillis);
                this.zza.zzI(new zzbar(this.zze, str));
                this.zza.zzad(this.zzg.zza(context, zzekVar));
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }
}
