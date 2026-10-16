package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public interface zzbwv extends IInterface {
    long zzb() throws RemoteException;

    Bundle zzc() throws RemoteException;

    com.google.android.gms.ads.internal.client.zzea zzd() throws RemoteException;

    zzbws zze() throws RemoteException;

    String zzf() throws RemoteException;

    String zzg() throws RemoteException;

    void zzh(com.google.android.gms.ads.internal.client.zzm zzmVar, zzbxc zzbxcVar) throws RemoteException;

    void zzi(com.google.android.gms.ads.internal.client.zzm zzmVar, zzbxc zzbxcVar) throws RemoteException;

    void zzj(boolean z) throws RemoteException;

    void zzk(com.google.android.gms.ads.internal.client.zzdq zzdqVar) throws RemoteException;

    void zzl(com.google.android.gms.ads.internal.client.zzdt zzdtVar) throws RemoteException;

    void zzm(long j) throws RemoteException;

    void zzn(zzbwy zzbwyVar) throws RemoteException;

    void zzo(zzbxj zzbxjVar) throws RemoteException;

    void zzp(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzq(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException;

    boolean zzr() throws RemoteException;

    void zzs(zzbxd zzbxdVar) throws RemoteException;
}
