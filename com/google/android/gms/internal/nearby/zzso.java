package com.google.android.gms.internal.nearby;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
final class zzso extends zzsj {
    private final zzsq zza;

    zzso(zzsq zzsqVar, int i) {
        super(zzsqVar.size(), i);
        this.zza = zzsqVar;
    }

    @Override // com.google.android.gms.internal.nearby.zzsj
    protected final Object zza(int i) {
        return this.zza.get(i);
    }
}
