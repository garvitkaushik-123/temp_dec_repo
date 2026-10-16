package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcdg implements Iterable {
    private final List zza = new ArrayList();

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.zza.iterator();
    }

    final zzcdf zza(zzccb zzccbVar) {
        Iterator it = iterator();
        while (it.hasNext()) {
            zzcdf zzcdfVar = (zzcdf) it.next();
            if (zzcdfVar.zza == zzccbVar) {
                return zzcdfVar;
            }
        }
        return null;
    }

    public final void zzb(zzcdf zzcdfVar) {
        this.zza.add(zzcdfVar);
    }

    public final void zzc(zzcdf zzcdfVar) {
        this.zza.remove(zzcdfVar);
    }

    public final boolean zzd(zzccb zzccbVar) {
        ArrayList arrayList = new ArrayList();
        Iterator it = iterator();
        while (it.hasNext()) {
            zzcdf zzcdfVar = (zzcdf) it.next();
            if (zzcdfVar.zza == zzccbVar) {
                arrayList.add(zzcdfVar);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((zzcdf) it2.next()).zzb.zzf();
        }
        return true;
    }
}
