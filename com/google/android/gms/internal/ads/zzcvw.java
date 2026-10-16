package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcvw extends zzdbt implements com.google.android.gms.ads.internal.client.zza {
    public zzcvw(Set set) {
        super(set);
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        zzq(new zzdbs() { // from class: com.google.android.gms.internal.ads.zzcvv
            @Override // com.google.android.gms.internal.ads.zzdbs
            public final void zza(Object obj) {
                ((com.google.android.gms.ads.internal.client.zza) obj).onAdClicked();
            }
        });
    }
}
