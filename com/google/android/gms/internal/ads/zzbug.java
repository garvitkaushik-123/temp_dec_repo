package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
final class zzbug extends zzbyw {
    final /* synthetic */ QueryInfoGenerationCallback zza;

    zzbug(zzbuh zzbuhVar, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        this.zza = queryInfoGenerationCallback;
        Objects.requireNonNull(zzbuhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbyx
    public final void zzb(String str) {
        this.zza.onFailure(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbyx
    public final void zzc(String str, String str2, Bundle bundle) {
        this.zza.onSuccess(new QueryInfo(new com.google.android.gms.ads.internal.client.zzfb(str, bundle, str2)));
    }
}
