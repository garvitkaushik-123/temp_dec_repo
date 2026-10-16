package com.google.android.gms.ads.internal.client;

import android.app.Activity;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbtn;
import com.google.android.gms.internal.ads.zzbtp;
import com.google.android.gms.internal.ads.zzbts;
import com.google.android.gms.internal.ads.zzbtt;
import com.google.android.gms.internal.ads.zzbun;
import com.google.android.gms.internal.ads.zzbup;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
final class zzac extends zzba {
    final /* synthetic */ Activity zza;
    final /* synthetic */ zzaz zzb;

    zzac(zzaz zzazVar, Activity activity) {
        this.zza = activity;
        Objects.requireNonNull(zzazVar);
        this.zzb = zzazVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    protected final /* bridge */ /* synthetic */ Object zza() {
        zzaz.zzv(this.zza, "ad_overlay");
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final /* bridge */ /* synthetic */ Object zzb(zzcr zzcrVar) throws RemoteException {
        return zzcrVar.zzn(ObjectWrapper.wrap(this.zza));
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        zzbup zzbupVar;
        zzbtn zzbtnVar;
        Activity activity = this.zza;
        zzbde.zza(activity);
        if (!((Boolean) zzbd.zzc().zzb(zzbde.zzle)).booleanValue()) {
            zzaz zzazVar = this.zzb;
            Activity activity2 = this.zza;
            zzbtnVar = zzazVar.zze;
            return zzbtnVar.zza(activity2);
        }
        try {
            return zzbtp.zzI(((zzbtt) com.google.android.gms.ads.internal.util.client.zzs.zzb(activity, "com.google.android.gms.ads.ChimeraAdOverlayCreatorImpl", new com.google.android.gms.ads.internal.util.client.zzq() { // from class: com.google.android.gms.ads.internal.client.zzab
                @Override // com.google.android.gms.ads.internal.util.client.zzq
                public final Object zza(Object obj) {
                    return zzbts.zzb((IBinder) obj);
                }
            })).zze(ObjectWrapper.wrap(activity)));
        } catch (RemoteException | com.google.android.gms.ads.internal.util.client.zzr | NullPointerException e) {
            zzaz zzazVar2 = this.zzb;
            zzazVar2.zzg = zzbun.zza(this.zza.getApplicationContext());
            zzbupVar = zzazVar2.zzg;
            zzbupVar.zzh(e, "ClientApiBroker.createAdOverlay");
            return null;
        }
    }
}
