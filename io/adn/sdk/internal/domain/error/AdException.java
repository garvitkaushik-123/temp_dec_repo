package io.adn.sdk.internal.domain.error;

import io.adn.sdk.publisher.AdnAdError;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdException.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0011\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u00020\u0006H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lio/adn/sdk/internal/domain/error/AdException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "error", "Lio/adn/sdk/internal/domain/error/AdError;", "details", "", "<init>", "(Lio/adn/sdk/internal/domain/error/AdError;Ljava/lang/String;)V", "getError", "()Lio/adn/sdk/internal/domain/error/AdError;", "getDetails", "()Ljava/lang/String;", "toExternalError", "Lio/adn/sdk/publisher/AdnAdError;", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public class AdException extends Exception {
    public static final int $stable = 0;
    private final String details;
    private final AdError error;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdException(AdError error, String str) {
        super(str);
        Intrinsics.checkNotNullParameter(error, "error");
        this.error = error;
        this.details = str;
    }

    public /* synthetic */ AdException(AdError adError, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(adError, (i & 2) != 0 ? null : str);
    }

    public String getDetails() {
        return this.details;
    }

    public AdError getError() {
        return this.error;
    }

    public final AdnAdError toExternalError() {
        return getError().toExternalError();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "AdException(error=" + getError().getValue() + ", details=" + getDetails() + ')';
    }
}
