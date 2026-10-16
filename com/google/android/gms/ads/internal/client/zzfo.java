package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbmk;
import com.google.android.gms.internal.ads.zzbpq;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzfo extends zzda {
    private zzbmk zza;

    public static /* synthetic */ void zzb(zzfo zzfoVar) {
        zzbmk zzbmkVar = zzfoVar.zza;
        if (zzbmkVar != null) {
            try {
                zzbmkVar.zzb(Collections.emptyList());
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzk("Could not notify onComplete event.", e);
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final float zze() throws RemoteException {
        return 1.0f;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final String zzf() {
        return "";
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final List zzg() throws RemoteException {
        return Collections.emptyList();
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzh(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzi() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzj(boolean z) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzk() throws RemoteException {
        com.google.android.gms.ads.internal.util.client.zzo.zzg("The initialization is not processed because MobileAdsSettingsManager is not created successfully.");
        com.google.android.gms.ads.internal.util.client.zzf.zza.post(new Runnable() { // from class: com.google.android.gms.ads.internal.client.zzfn
            @Override // java.lang.Runnable
            public final void run() {
                zzfo.zzb(zzfo.this);
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzl(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzm(zzdn zzdnVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzn(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzo(zzbpq zzbpqVar) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzp(boolean z) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzq(float f) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzr(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzs(zzbmk zzbmkVar) throws RemoteException {
        this.zza = zzbmkVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzt(String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzu(zzfx zzfxVar) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final boolean zzv() throws RemoteException {
        return false;
    }
}
