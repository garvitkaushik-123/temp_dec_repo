package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes5.dex */
final class zzld extends zzaz {
    final /* synthetic */ zzlw zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzld(zzlw zzlwVar, zzjs zzjsVar) {
        super(zzjsVar);
        this.zza = zzlwVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzaz
    public final void zzc() {
        zzaz zzazVar;
        zzlw zzlwVar = this.zza;
        if (zzlwVar.zzu.zzO()) {
            zzazVar = zzlwVar.zzr;
            zzazVar.zzd(2000L);
        }
    }
}
