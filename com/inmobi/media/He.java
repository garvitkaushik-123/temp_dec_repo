package com.inmobi.media;

import java.net.SocketTimeoutException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;

/* loaded from: classes4.dex */
public abstract class He {
    public static final boolean a(Response response) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        int code = response.code();
        return !(400 <= code && code < 600);
    }

    public static final Object a(ExecutorService executorService, long j, TimeUnit unit, Callable task) {
        Intrinsics.checkNotNullParameter(executorService, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(task, "task");
        Future submit = executorService.submit(task);
        Intrinsics.checkNotNullExpressionValue(submit, "submit(...)");
        try {
            return submit.get(j, unit);
        } catch (InterruptedException e) {
            submit.cancel(true);
            Thread.currentThread().interrupt();
            throw e;
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause == null) {
                throw e2;
            }
            throw cause;
        } catch (TimeoutException unused) {
            submit.cancel(true);
            throw new SocketTimeoutException();
        }
    }
}
