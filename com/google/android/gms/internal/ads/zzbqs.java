package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.mediation.MediationInterscrollerAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbqs extends zzbpy {
    private final MediationInterscrollerAd zza;

    public zzbqs(MediationInterscrollerAd mediationInterscrollerAd) {
        this.zza = mediationInterscrollerAd;
    }

    @Override // com.google.android.gms.internal.ads.zzbpz
    public final IObjectWrapper zze() {
        return ObjectWrapper.wrap(this.zza.getView());
    }

    @Override // com.google.android.gms.internal.ads.zzbpz
    public final boolean zzf() {
        return this.zza.shouldDelegateInterscrollerEffect();
    }
}
