package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
final class zzhbi implements Iterator {
    private final ArrayDeque zza;
    private zzgxv zzb;

    /* synthetic */ zzhbi(zzgxz zzgxzVar, zzhbj zzhbjVar) {
        if (!(zzgxzVar instanceof zzhbk)) {
            this.zza = null;
            this.zzb = (zzgxv) zzgxzVar;
            return;
        }
        zzhbk zzhbkVar = (zzhbk) zzgxzVar;
        ArrayDeque arrayDeque = new ArrayDeque(zzhbkVar.zzf());
        this.zza = arrayDeque;
        arrayDeque.push(zzhbkVar);
        this.zzb = zzb(zzhbkVar.zzd);
    }

    private final zzgxv zzb(zzgxz zzgxzVar) {
        while (zzgxzVar instanceof zzhbk) {
            zzhbk zzhbkVar = (zzhbk) zzgxzVar;
            this.zza.push(zzhbkVar);
            zzgxzVar = zzhbkVar.zzd;
        }
        return (zzgxv) zzgxzVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb != null;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzgxv next() {
        zzgxv zzgxvVar;
        zzgxv zzgxvVar2 = this.zzb;
        if (zzgxvVar2 == null) {
            throw new NoSuchElementException();
        }
        do {
            ArrayDeque arrayDeque = this.zza;
            zzgxvVar = null;
            if (arrayDeque == null || arrayDeque.isEmpty()) {
                break;
            }
            zzgxvVar = zzb(((zzhbk) arrayDeque.pop()).zze);
        } while (zzgxvVar.zzd() == 0);
        this.zzb = zzgxvVar;
        return zzgxvVar2;
    }
}
