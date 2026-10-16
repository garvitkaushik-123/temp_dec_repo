package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public interface zzbrp extends IInterface {
    com.google.android.gms.ads.internal.client.zzed zze() throws RemoteException;

    zzbse zzf() throws RemoteException;

    zzbse zzg() throws RemoteException;

    void zzh(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, com.google.android.gms.ads.internal.client.zzr zzrVar, zzbrs zzbrsVar) throws RemoteException;

    void zzi(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbra zzbraVar, zzbpw zzbpwVar) throws RemoteException;

    void zzj(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbrd zzbrdVar, zzbpw zzbpwVar, com.google.android.gms.ads.internal.client.zzr zzrVar) throws RemoteException;

    void zzk(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbrd zzbrdVar, zzbpw zzbpwVar, com.google.android.gms.ads.internal.client.zzr zzrVar) throws RemoteException;

    void zzl(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbrg zzbrgVar, zzbpw zzbpwVar) throws RemoteException;

    void zzm(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbrj zzbrjVar, zzbpw zzbpwVar) throws RemoteException;

    void zzn(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbrj zzbrjVar, zzbpw zzbpwVar, zzbge zzbgeVar) throws RemoteException;

    void zzo(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbrm zzbrmVar, zzbpw zzbpwVar) throws RemoteException;

    void zzp(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbrm zzbrmVar, zzbpw zzbpwVar) throws RemoteException;

    void zzq(String str) throws RemoteException;

    boolean zzr(IObjectWrapper iObjectWrapper) throws RemoteException;

    boolean zzs(IObjectWrapper iObjectWrapper) throws RemoteException;

    boolean zzt(IObjectWrapper iObjectWrapper) throws RemoteException;
}
