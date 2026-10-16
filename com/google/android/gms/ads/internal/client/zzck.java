package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbaw;
import com.google.android.gms.internal.ads.zzbpq;
import com.google.android.gms.internal.ads.zzbwv;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public interface zzck extends IInterface {
    int zze(int i, String str) throws RemoteException;

    Bundle zzf(int i) throws RemoteException;

    zzbaw zzg(String str) throws RemoteException;

    zzbaw zzh(String str) throws RemoteException;

    zzbx zzi(String str) throws RemoteException;

    zzbx zzj(String str) throws RemoteException;

    zzfv zzk(int i, String str) throws RemoteException;

    zzbwv zzl(String str) throws RemoteException;

    zzbwv zzm(String str) throws RemoteException;

    void zzn(int i) throws RemoteException;

    void zzo(zzbpq zzbpqVar) throws RemoteException;

    void zzp(List list, zzce zzceVar) throws RemoteException;

    boolean zzq(int i, String str) throws RemoteException;

    boolean zzr(int i, String str) throws RemoteException;

    boolean zzs(String str) throws RemoteException;

    boolean zzt(String str) throws RemoteException;

    boolean zzu(String str) throws RemoteException;

    boolean zzv(String str, zzfv zzfvVar, zzch zzchVar) throws RemoteException;
}
