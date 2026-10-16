package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzeit implements zzedm {
    private final zzedo zza;
    private final zzeds zzb;
    private final zzfha zzc;
    private final zzgdy zzd;

    public zzeit(zzfha zzfhaVar, zzgdy zzgdyVar, zzedo zzedoVar, zzeds zzedsVar) {
        this.zzc = zzfhaVar;
        this.zzd = zzgdyVar;
        this.zzb = zzedsVar;
        this.zza = zzedoVar;
    }

    static final String zze(String str, int i) {
        return "Error from: " + str + ", code: " + i;
    }

    @Override // com.google.android.gms.internal.ads.zzedm
    public final ListenableFuture zza(final zzfcn zzfcnVar, final zzfca zzfcaVar) {
        final zzedp zzedpVar;
        Iterator it = zzfcaVar.zzt.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzedpVar = null;
                break;
            }
            try {
                zzedpVar = this.zza.zza((String) it.next(), zzfcaVar.zzv);
                break;
            } catch (zzfdd unused) {
            }
        }
        if (zzedpVar == null) {
            return zzgdn.zzg(new zzegj("Unable to instantiate mediation adapter class."));
        }
        zzcak zzcakVar = new zzcak();
        zzedpVar.zzc.zza(new zzeis(this, zzedpVar, zzcakVar));
        if (zzfcaVar.zzM) {
            Bundle bundle = zzfcnVar.zza.zza.zzd.zzm;
            Bundle bundle2 = bundle.getBundle(AdMobAdapter.class.getName());
            if (bundle2 == null) {
                bundle2 = new Bundle();
                bundle.putBundle(AdMobAdapter.class.getName(), bundle2);
            }
            bundle2.putBoolean("render_test_ad_label", true);
        }
        zzfha zzfhaVar = this.zzc;
        zzfgu zzfguVar = zzfgu.ADAPTER_LOAD_AD_SYN;
        Objects.requireNonNull(zzfhaVar);
        return zzfgk.zzd(new zzfgf() { // from class: com.google.android.gms.internal.ads.zzeiq
            @Override // com.google.android.gms.internal.ads.zzfgf
            public final void zza() {
                zzeit.this.zzb.zzb(zzfcnVar, zzfcaVar, zzedpVar);
            }
        }, this.zzd, zzfguVar, zzfhaVar).zzb(zzfgu.ADAPTER_LOAD_AD_ACK).zzd(zzcakVar).zzb(zzfgu.ADAPTER_WRAP_ADAPTER).zze(new zzfge() { // from class: com.google.android.gms.internal.ads.zzeir
            @Override // com.google.android.gms.internal.ads.zzfge
            public final Object zza(Object obj) {
                Object zza;
                zza = zzeit.this.zzb.zza(zzfcnVar, zzfcaVar, zzedpVar);
                return zza;
            }
        }).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzedm
    public final boolean zzb(zzfcn zzfcnVar, zzfca zzfcaVar) {
        return !zzfcaVar.zzt.isEmpty();
    }
}
