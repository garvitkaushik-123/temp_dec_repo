package com.moloco.sdk.acm;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0014\u0010\u0004\u001a\u00020\u00032\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007H&¨\u0006\b"}, d2 = {"Lcom/moloco/sdk/acm/AndroidClientMetricsCallback;", "", "onInitializationSuccess", "", "onInitializationFailure", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "moloco-android-client-metrics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface AndroidClientMetricsCallback {
    void onInitializationFailure(Exception e);

    void onInitializationSuccess();
}
