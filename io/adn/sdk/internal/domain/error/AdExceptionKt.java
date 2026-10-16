package io.adn.sdk.internal.domain.error;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdException.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toAdException", "Lio/adn/sdk/internal/domain/error/AdException;", "", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AdExceptionKt {
    public static final AdException toAdException(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        AdException adException = th instanceof AdException ? (AdException) th : null;
        return adException == null ? new AdException(AdError.UnknownError, th.getMessage()) : adException;
    }
}
