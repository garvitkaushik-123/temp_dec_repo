package com.google.android.gms.ads.internal.client;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.internal.ads.zzbge;
import com.google.android.gms.internal.ads.zzbhn;
import com.google.android.gms.internal.ads.zzbhq;
import com.google.android.gms.internal.ads.zzbht;
import com.google.android.gms.internal.ads.zzbhw;
import com.google.android.gms.internal.ads.zzbia;
import com.google.android.gms.internal.ads.zzbid;
import com.google.android.gms.internal.ads.zzbmp;
import com.google.android.gms.internal.ads.zzbmy;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public interface zzbt extends IInterface {
    zzbq zze() throws RemoteException;

    void zzf(zzbhn zzbhnVar) throws RemoteException;

    void zzg(zzbhq zzbhqVar) throws RemoteException;

    void zzh(String str, zzbhw zzbhwVar, zzbht zzbhtVar) throws RemoteException;

    void zzi(zzbmy zzbmyVar) throws RemoteException;

    void zzj(zzbia zzbiaVar, zzr zzrVar) throws RemoteException;

    void zzk(zzbid zzbidVar) throws RemoteException;

    void zzl(zzbk zzbkVar) throws RemoteException;

    void zzm(AdManagerAdViewOptions adManagerAdViewOptions) throws RemoteException;

    void zzn(zzbmp zzbmpVar) throws RemoteException;

    void zzo(zzbge zzbgeVar) throws RemoteException;

    void zzp(PublisherAdViewOptions publisherAdViewOptions) throws RemoteException;

    void zzq(zzcs zzcsVar) throws RemoteException;
}
