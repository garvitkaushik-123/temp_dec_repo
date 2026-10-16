package io.adn.sdk.internal.data.utils;

import io.adn.sdk.internal.common.utils.ConversionsKt;
import io.adn.sdk.internal.data.repository.BidTokenRepositoryKt;
import io.adn.sdk.internal.domain.error.AdError;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: BidTokenUtils.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0004H\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"bidTokenError", "", "error", "Lio/adn/sdk/internal/domain/error/AdError;", "", "TOKEN_ERROR", "UNKNOWN_ERROR_BASE_64", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class BidTokenUtilsKt {
    private static final String TOKEN_ERROR = "token_error";
    private static final String UNKNOWN_ERROR_BASE_64 = "eyJ0b2tlbl9lcnJvciI6ICJ1bmtnb25lIGVycm9yIn0=";

    public static final String bidTokenError(AdError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        return bidTokenError(error.toString());
    }

    public static final String bidTokenError(Throwable error) {
        Intrinsics.checkNotNullParameter(error, "error");
        String message = error.getMessage();
        if (message == null) {
            message = "Unknown error";
        }
        return bidTokenError(message);
    }

    public static final String bidTokenError(String error) {
        Object m10241constructorimpl;
        Intrinsics.checkNotNullParameter(error, "error");
        try {
            Result.Companion companion = Result.INSTANCE;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(BidTokenRepositoryKt.SDK_VERSION, "4.25.2");
            jSONObject.put(TOKEN_ERROR, error);
            m10241constructorimpl = Result.m10241constructorimpl(ConversionsKt.toBase64(jSONObject));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m10247isFailureimpl(m10241constructorimpl)) {
            m10241constructorimpl = UNKNOWN_ERROR_BASE_64;
        }
        return (String) m10241constructorimpl;
    }
}
