package io.adn.sdk.internal.data.utils;

import com.ironsource.C3337ue;
import com.vungle.ads.internal.ui.AdActivity;
import io.adn.sdk.internal.common.logger.AdLogEvent;
import io.adn.sdk.internal.common.logger.Logger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/* compiled from: HttpRequestUtils.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\f\u001a\u00020\rH\u0002¨\u0006\u0011"}, d2 = {"Lio/adn/sdk/internal/data/utils/LoggingInterceptor;", "Lokhttp3/Interceptor;", "<init>", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "logRequest", "", "startTime", "", AdActivity.REQUEST_KEY_EXTRA, "Lokhttp3/Request;", C3337ue.n, "extractBody", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class LoggingInterceptor implements Interceptor {
    public static final int $stable = 0;

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        long currentTimeMillis = System.currentTimeMillis();
        Response proceed = chain.proceed(request);
        if (Logger.INSTANCE.isVerbose()) {
            logRequest(currentTimeMillis, request, proceed);
        }
        return proceed;
    }

    private final void logRequest(long startTime, Request request, Response response) {
        try {
            Result.Companion companion = Result.INSTANCE;
            LoggingInterceptor loggingInterceptor = this;
            Logger.INSTANCE.log(new AdLogEvent.Http(request.method(), startTime, System.currentTimeMillis() - startTime, request.url().getUrl(), extractBody(request), response.code()));
            Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    private final String extractBody(Request request) {
        Object m10241constructorimpl;
        String str;
        try {
            Result.Companion companion = Result.INSTANCE;
            LoggingInterceptor loggingInterceptor = this;
            RequestBody body = request.body();
            if (body != null) {
                Buffer buffer = new Buffer();
                body.writeTo(buffer);
                str = buffer.readUtf8();
            } else {
                str = null;
            }
            m10241constructorimpl = Result.m10241constructorimpl(str);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        return (String) (Result.m10247isFailureimpl(m10241constructorimpl) ? null : m10241constructorimpl);
    }
}
