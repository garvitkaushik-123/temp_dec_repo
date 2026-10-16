package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public interface zzbvi extends IInterface {
    void zze(com.google.android.gms.ads.internal.util.zzbb zzbbVar) throws RemoteException;

    @Deprecated
    void zzf(ParcelFileDescriptor parcelFileDescriptor) throws RemoteException;

    void zzg(ParcelFileDescriptor parcelFileDescriptor, zzbvq zzbvqVar) throws RemoteException;
}
