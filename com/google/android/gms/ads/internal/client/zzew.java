package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.internal.ads.zzbmj;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
final class zzew extends zzbmj {
    final /* synthetic */ zzey zza;

    /* synthetic */ zzew(zzey zzeyVar, zzex zzexVar) {
        Objects.requireNonNull(zzeyVar);
        this.zza = zzeyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbmk
    public final void zzb(List list) throws RemoteException {
        Object obj;
        int i;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        InitializationStatus zzA;
        zzey zzeyVar = this.zza;
        obj = zzeyVar.zzf;
        synchronized (obj) {
            zzeyVar.zzi = false;
            zzeyVar.zzj = true;
            arrayList2 = zzeyVar.zzh;
            arrayList = new ArrayList(arrayList2);
            arrayList3 = zzeyVar.zzh;
            arrayList3.clear();
        }
        zzA = zzey.zzA(list);
        int size = arrayList.size();
        for (i = 0; i < size; i++) {
            ((OnInitializationCompleteListener) arrayList.get(i)).onInitializationComplete(zzA);
        }
    }
}
