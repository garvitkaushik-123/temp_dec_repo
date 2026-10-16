package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzlp implements zzlg {
    public final zzvc zza;
    public int zzd;
    public boolean zze;
    public final List zzc = new ArrayList();
    public final Object zzb = new Object();

    public zzlp(zzvj zzvjVar, boolean z) {
        this.zza = new zzvc(zzvjVar, z);
    }

    @Override // com.google.android.gms.internal.ads.zzlg
    public final zzbl zza() {
        return this.zza.zzC();
    }

    @Override // com.google.android.gms.internal.ads.zzlg
    public final Object zzb() {
        return this.zzb;
    }

    public final void zzc(int i) {
        this.zzd = i;
        this.zze = false;
        this.zzc.clear();
    }
}
