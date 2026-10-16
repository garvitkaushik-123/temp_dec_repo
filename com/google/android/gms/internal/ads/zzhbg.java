package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
final class zzhbg extends zzgxs {
    final zzhbi zza;
    zzgxu zzb;
    final /* synthetic */ zzhbk zzc;

    zzhbg(zzhbk zzhbkVar) {
        Objects.requireNonNull(zzhbkVar);
        this.zzc = zzhbkVar;
        this.zza = new zzhbi(zzhbkVar, null);
        this.zzb = zzb();
    }

    private final zzgxu zzb() {
        zzhbi zzhbiVar = this.zza;
        if (zzhbiVar.hasNext()) {
            return zzhbiVar.next().iterator();
        }
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb != null;
    }

    @Override // com.google.android.gms.internal.ads.zzgxu
    public final byte zza() {
        zzgxu zzgxuVar = this.zzb;
        if (zzgxuVar == null) {
            throw new NoSuchElementException();
        }
        byte zza = zzgxuVar.zza();
        if (!this.zzb.hasNext()) {
            this.zzb = zzb();
        }
        return zza;
    }
}
