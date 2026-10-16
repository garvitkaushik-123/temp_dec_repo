package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzeje implements com.google.android.gms.ads.internal.zzg {
    final /* synthetic */ zzcak zza;
    final /* synthetic */ zzfcn zzb;
    final /* synthetic */ zzfca zzc;
    final /* synthetic */ zzejk zzd;
    final /* synthetic */ zzejf zze;

    zzeje(zzejf zzejfVar, zzcak zzcakVar, zzfcn zzfcnVar, zzfca zzfcaVar, zzejk zzejkVar) {
        this.zza = zzcakVar;
        this.zzb = zzfcnVar;
        this.zzc = zzfcaVar;
        this.zzd = zzejkVar;
        Objects.requireNonNull(zzejfVar);
        this.zze = zzejfVar;
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zza(View view) {
        zzejo zzejoVar;
        zzejk zzejkVar = this.zzd;
        zzejoVar = this.zze.zzd;
        this.zza.zzc(zzejoVar.zza(this.zzb, this.zzc, view, zzejkVar));
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzb() {
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzc() {
    }
}
