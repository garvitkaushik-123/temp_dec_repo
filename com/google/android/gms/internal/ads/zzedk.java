package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.privacysandbox.ads.adservices.java.topics.TopicsManagerFutures;
import androidx.privacysandbox.ads.adservices.topics.GetTopicsRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzedk {
    private final Context zza;

    zzedk(Context context) {
        this.zza = context;
    }

    public final ListenableFuture zza(boolean z) {
        try {
            GetTopicsRequest build = new GetTopicsRequest.Builder().setAdsSdkName(MobileAds.ERROR_DOMAIN).setShouldRecordObservation(z).build();
            TopicsManagerFutures from = TopicsManagerFutures.from(this.zza);
            return from != null ? from.getTopicsAsync(build) : zzgdn.zzg(new IllegalStateException());
        } catch (Exception e) {
            return zzgdn.zzg(e);
        }
    }
}
