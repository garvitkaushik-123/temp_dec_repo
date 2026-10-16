package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzful implements ServiceConnection {
    final /* synthetic */ zzfun zza;

    /* synthetic */ zzful(zzfun zzfunVar, zzfum zzfumVar) {
        Objects.requireNonNull(zzfunVar);
        this.zza = zzfunVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        zzfuo zzfuoVar;
        zzfun zzfunVar = this.zza;
        zzfuoVar = zzfunVar.zzc;
        zzfuoVar.zzc("LmdServiceConnectionManager.onServiceConnected(%s)", componentName);
        zzfunVar.zzo(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfuj
            @Override // java.lang.Runnable
            public final void run() {
                zzfuo zzfuoVar2;
                zzfuo zzfuoVar3;
                List list;
                List list2;
                List list3;
                IInterface iInterface;
                IBinder.DeathRecipient deathRecipient;
                zzfsn zzb = zzfsm.zzb(iBinder);
                zzful zzfulVar = zzful.this;
                zzfun zzfunVar2 = zzfulVar.zza;
                zzfunVar2.zzj = zzb;
                zzfuoVar2 = zzfunVar2.zzc;
                zzfuoVar2.zzc("linkToDeath", new Object[0]);
                try {
                    iInterface = zzfunVar2.zzj;
                } catch (RemoteException e) {
                    zzfuoVar3 = zzfulVar.zza.zzc;
                    zzfuoVar3.zzb(e, "linkToDeath failed", new Object[0]);
                }
                if (iInterface == null) {
                    throw null;
                }
                IInterface iInterface2 = iInterface;
                IBinder asBinder = iInterface.asBinder();
                deathRecipient = zzfunVar2.zzh;
                asBinder.linkToDeath(deathRecipient, 0);
                zzfun zzfunVar3 = zzfulVar.zza;
                zzfunVar3.zzf = false;
                list = zzfunVar3.zze;
                synchronized (list) {
                    list2 = zzfunVar3.zze;
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        ((Runnable) it.next()).run();
                    }
                    list3 = zzfunVar3.zze;
                    list3.clear();
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzfuo zzfuoVar;
        zzfun zzfunVar = this.zza;
        zzfuoVar = zzfunVar.zzc;
        zzfuoVar.zzc("LmdServiceConnectionManager.onServiceDisconnected(%s)", componentName);
        zzfunVar.zzo(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfuk
            @Override // java.lang.Runnable
            public final void run() {
                zzfuo zzfuoVar2;
                IInterface iInterface;
                IBinder.DeathRecipient deathRecipient;
                zzfun zzfunVar2 = zzful.this.zza;
                zzfuoVar2 = zzfunVar2.zzc;
                zzfuoVar2.zzc("unlinkToDeath", new Object[0]);
                iInterface = zzfunVar2.zzj;
                iInterface.getClass();
                IBinder asBinder = iInterface.asBinder();
                deathRecipient = zzfunVar2.zzh;
                asBinder.unlinkToDeath(deathRecipient, 0);
                zzfunVar2.zzj = null;
                zzfunVar2.zzf = false;
            }
        });
    }
}
