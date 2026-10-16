package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzzj {
    private final CopyOnWriteArrayList zza = new CopyOnWriteArrayList();

    public final void zza(Handler handler, zzzk zzzkVar) {
        zzc(zzzkVar);
        this.zza.add(new zzzi(handler, zzzkVar));
    }

    public final void zzb(final int i, final long j, final long j2) {
        boolean z;
        Handler handler;
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            final zzzi zzziVar = (zzzi) it.next();
            z = zzziVar.zzc;
            if (!z) {
                handler = zzziVar.zza;
                handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzzh
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzzk zzzkVar;
                        zzzkVar = zzzi.this.zzb;
                        zzzkVar.zzZ(i, j, j2);
                    }
                });
            }
        }
    }

    public final void zzc(zzzk zzzkVar) {
        zzzk zzzkVar2;
        CopyOnWriteArrayList copyOnWriteArrayList = this.zza;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            zzzi zzziVar = (zzzi) it.next();
            zzzkVar2 = zzziVar.zzb;
            if (zzzkVar2 == zzzkVar) {
                zzziVar.zzc();
                copyOnWriteArrayList.remove(zzziVar);
            }
        }
    }
}
