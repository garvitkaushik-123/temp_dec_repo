package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzezf {
    public static void zza(AtomicReference atomicReference, zzeze zzezeVar) {
        Object obj = atomicReference.get();
        if (obj == null) {
            return;
        }
        try {
            zzezeVar.zza(obj);
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        } catch (NullPointerException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("NullPointerException occurs when invoking a method from a delegating listener.", e2);
        }
    }
}
