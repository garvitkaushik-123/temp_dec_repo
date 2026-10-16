package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzsc {
    public final int zza;
    public final zzvh zzb;
    private final CopyOnWriteArrayList zzc;

    public zzsc() {
        this(new CopyOnWriteArrayList(), 0, null);
    }

    private zzsc(CopyOnWriteArrayList copyOnWriteArrayList, int i, zzvh zzvhVar) {
        this.zzc = copyOnWriteArrayList;
        this.zza = 0;
        this.zzb = zzvhVar;
    }

    public final zzsc zza(int i, zzvh zzvhVar) {
        return new zzsc(this.zzc, 0, zzvhVar);
    }

    public final void zzb(Handler handler, zzsd zzsdVar) {
        this.zzc.add(new zzsb(handler, zzsdVar));
    }

    public final void zzc(zzsd zzsdVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.zzc;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            zzsb zzsbVar = (zzsb) it.next();
            if (zzsbVar.zza == zzsdVar) {
                copyOnWriteArrayList.remove(zzsbVar);
            }
        }
    }
}
