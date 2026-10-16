package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public interface zzbza extends IInterface {
    IObjectWrapper zze(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, String str, IObjectWrapper iObjectWrapper3) throws RemoteException;

    void zzf(IObjectWrapper iObjectWrapper, zzbze zzbzeVar, zzbyx zzbyxVar) throws RemoteException;

    void zzg(zzbui zzbuiVar) throws RemoteException;

    void zzh(List list, IObjectWrapper iObjectWrapper, zzbuf zzbufVar) throws RemoteException;

    void zzi(List list, IObjectWrapper iObjectWrapper, zzbuf zzbufVar) throws RemoteException;

    void zzj(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzk(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzl(List list, IObjectWrapper iObjectWrapper, zzbuf zzbufVar) throws RemoteException;

    void zzm(List list, IObjectWrapper iObjectWrapper, zzbuf zzbufVar) throws RemoteException;
}
