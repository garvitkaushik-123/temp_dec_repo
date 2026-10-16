package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.ClientApi;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzflh extends zzfld {
    public zzflh(ClientApi clientApi, Context context, int i, zzbpq zzbpqVar, com.google.android.gms.ads.internal.client.zzfv zzfvVar, com.google.android.gms.ads.internal.client.zzce zzceVar, ScheduledExecutorService scheduledExecutorService, zzfkg zzfkgVar, Clock clock) {
        super(clientApi, context, i, zzbpqVar, zzfvVar, zzceVar, scheduledExecutorService, zzfkgVar, clock);
    }

    @Override // com.google.android.gms.internal.ads.zzfld
    protected final /* bridge */ /* synthetic */ com.google.android.gms.ads.internal.client.zzea zza(Object obj) {
        try {
            return ((zzbwv) obj).zzd();
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzf("Failed to get response info for the rewarded ad.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfld
    protected final ListenableFuture zzb(Context context) {
        zzgeh zze = zzgeh.zze();
        zzbwv zzp = this.zza.zzp(ObjectWrapper.wrap(context), this.zze.zza, this.zzd, this.zzc);
        zzflg zzflgVar = new zzflg(this, zze, zzp);
        if (zzp == null) {
            zze.zzd(new zzfka(1, "Failed to create a rewarded ad."));
            return zze;
        }
        try {
            zzp.zzh(this.zze.zzc, zzflgVar);
            return zze;
        } catch (RemoteException unused) {
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to load rewarded ad.");
            zze.zzd(new zzfka(1, "remote exception"));
            return zze;
        }
    }

    public zzflh(String str, ClientApi clientApi, Context context, int i, zzbpq zzbpqVar, com.google.android.gms.ads.internal.client.zzfv zzfvVar, com.google.android.gms.ads.internal.client.zzch zzchVar, ScheduledExecutorService scheduledExecutorService, zzfkg zzfkgVar, Clock clock) {
        super(str, clientApi, context, i, zzbpqVar, zzfvVar, zzchVar, scheduledExecutorService, zzfkgVar, clock);
    }
}
