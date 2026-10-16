package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
class zzfyj extends zzfyk {
    Object[] zza;
    int zzb;
    boolean zzc;

    zzfyj(int i) {
        zzfxn.zza(i, "initialCapacity");
        this.zza = new Object[i];
        this.zzb = 0;
    }

    private final void zzf(int i) {
        int length = this.zza.length;
        int zze = zze(length, this.zzb + i);
        if (zze > length || this.zzc) {
            this.zza = Arrays.copyOf(this.zza, zze);
            this.zzc = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfyk
    public /* bridge */ /* synthetic */ zzfyk zzb(Object obj) {
        throw null;
    }

    public final zzfyk zzc(Iterable iterable) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            zzf(collection.size());
            if (collection instanceof zzfyl) {
                this.zzb = ((zzfyl) collection).zza(this.zza, this.zzb);
                return this;
            }
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            zzb(it.next());
        }
        return this;
    }

    final void zzd(Object[] objArr, int i) {
        zzgaa.zzb(objArr, 2);
        zzf(2);
        System.arraycopy(objArr, 0, this.zza, this.zzb, 2);
        this.zzb += 2;
    }

    public final zzfyj zza(Object obj) {
        obj.getClass();
        zzf(1);
        Object[] objArr = this.zza;
        int i = this.zzb;
        this.zzb = i + 1;
        objArr[i] = obj;
        return this;
    }
}
