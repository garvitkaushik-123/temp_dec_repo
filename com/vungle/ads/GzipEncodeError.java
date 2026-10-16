package com.vungle.ads;

import androidx.core.app.NotificationCompat;
import com.vungle.ads.internal.protos.Sdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VungleError.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/vungle/ads/GzipEncodeError;", "Lcom/vungle/ads/VungleError;", NotificationCompat.CATEGORY_MESSAGE, "", "(Ljava/lang/String;)V", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class GzipEncodeError extends VungleError {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GzipEncodeError(String msg) {
        super(Sdk.SDKError.Reason.GZIP_ENCODE_ERROR, msg, null);
        Intrinsics.checkNotNullParameter(msg, "msg");
    }
}
