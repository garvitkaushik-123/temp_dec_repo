package com.google.android.gms.internal.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@18.6.0 */
/* loaded from: classes5.dex */
public final class zzaa {
    private final zzr zza;
    private final boolean zzb;
    private final zzw zzc;

    private zzaa(zzw zzwVar, boolean z, zzr zzrVar, int i) {
        this.zzc = zzwVar;
        this.zzb = z;
        this.zza = zzrVar;
    }

    public static zzaa zzc(zzr zzrVar) {
        return new zzaa(new zzw(zzrVar), false, zzq.zza, Integer.MAX_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Iterator zzh(CharSequence charSequence) {
        return new zzx(this, charSequence, this.zzc.zza);
    }

    public final zzaa zzb() {
        return new zzaa(this.zzc, true, this.zza, Integer.MAX_VALUE);
    }

    public final Iterable zzd(CharSequence charSequence) {
        return new zzy(this, charSequence);
    }

    public final List zzf(CharSequence charSequence) {
        charSequence.getClass();
        Iterator zzh = zzh(charSequence);
        ArrayList arrayList = new ArrayList();
        while (zzh.hasNext()) {
            arrayList.add((String) zzh.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
