package com.google.android.gms.internal.consent_sdk;

import com.ironsource.C3040d4;
import java.util.Iterator;

/* compiled from: com.google.android.ump:user-messaging-platform@@3.2.0 */
/* loaded from: classes5.dex */
final class zzdj extends zzdf {
    final transient Object zza;

    zzdj(Object obj) {
        obj.getClass();
        this.zza = obj;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdb, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.zza.equals(obj);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdf, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdf, com.google.android.gms.internal.consent_sdk.zzdb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzdg(this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return C3040d4.i.d + this.zza.toString() + C3040d4.i.e;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdb
    final int zza(Object[] objArr, int i) {
        objArr[0] = this.zza;
        return 1;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdf, com.google.android.gms.internal.consent_sdk.zzdb
    /* renamed from: zzd */
    public final zzdk iterator() {
        return new zzdg(this.zza);
    }
}
