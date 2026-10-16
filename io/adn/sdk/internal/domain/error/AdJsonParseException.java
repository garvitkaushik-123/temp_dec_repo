package io.adn.sdk.internal.domain.error;

import kotlin.Metadata;

/* compiled from: AdException.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lio/adn/sdk/internal/domain/error/AdJsonParseException;", "Lio/adn/sdk/internal/domain/error/AdException;", "details", "", "payload", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getDetails", "()Ljava/lang/String;", "getPayload", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AdJsonParseException extends AdException {
    public static final int $stable = 0;
    private final String details;
    private final String payload;

    public AdJsonParseException(String str, String str2) {
        super(AdError.ParseResponseError, null, 2, null);
        this.details = str;
        this.payload = str2;
    }

    @Override // io.adn.sdk.internal.domain.error.AdException
    public String getDetails() {
        return this.details;
    }

    public final String getPayload() {
        return this.payload;
    }
}
