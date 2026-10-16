package io.adn.sdk.internal.data.api.remote;

import io.adn.sdk.internal.domain.error.AdError;
import io.adn.sdk.internal.domain.error.AdException;
import kotlin.Metadata;

/* compiled from: RemoteDataSource.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/adn/sdk/internal/data/api/remote/HttpRequestException;", "Lio/adn/sdk/internal/domain/error/AdException;", "<init>", "()V", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
final class HttpRequestException extends AdException {
    public HttpRequestException() {
        super(AdError.HttpRequestError, null, 2, null);
    }
}
