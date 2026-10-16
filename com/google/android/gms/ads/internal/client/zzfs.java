package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbws;
import com.google.android.gms.internal.ads.zzbwu;
import com.google.android.gms.internal.ads.zzbwy;
import com.google.android.gms.internal.ads.zzbxc;
import com.google.android.gms.internal.ads.zzbxd;
import com.google.android.gms.internal.ads.zzbxj;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzfs extends zzbwu {
    private static void zzu(final zzbxc zzbxcVar) {
        com.google.android.gms.ads.internal.util.client.zzo.zzg("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        com.google.android.gms.ads.internal.util.client.zzf.zza.post(new Runnable() { // from class: com.google.android.gms.ads.internal.client.zzfr
            @Override // java.lang.Runnable
            public final void run() {
                zzbxc zzbxcVar2 = zzbxc.this;
                if (zzbxcVar2 != null) {
                    try {
                        zzbxcVar2.zze(1);
                    } catch (RemoteException e) {
                        com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
                    }
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final long zzb() {
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final Bundle zzc() throws RemoteException {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final zzea zzd() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final zzbws zze() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final String zzf() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final String zzg() throws RemoteException {
        return "";
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzh(zzm zzmVar, zzbxc zzbxcVar) throws RemoteException {
        zzu(zzbxcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzi(zzm zzmVar, zzbxc zzbxcVar) throws RemoteException {
        zzu(zzbxcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzj(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzk(zzdq zzdqVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzl(zzdt zzdtVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzm(long j) {
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzn(zzbwy zzbwyVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzo(zzbxj zzbxjVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzp(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzq(IObjectWrapper iObjectWrapper, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final boolean zzr() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzs(zzbxd zzbxdVar) throws RemoteException {
    }
}
