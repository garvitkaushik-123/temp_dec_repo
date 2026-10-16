package com.google.android.gms.tasks;

import io.adn.sdk.internal.domain.constants.AnalyticsConstants;

/* compiled from: com.google.android.gms:play-services-tasks@@18.2.1 */
/* loaded from: classes5.dex */
public final class DuplicateTaskCompletionException extends IllegalStateException {
    private DuplicateTaskCompletionException(String str, Throwable th) {
        super(str, th);
    }

    public static IllegalStateException of(Task<?> task) {
        if (!task.isComplete()) {
            return new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
        Exception exception = task.getException();
        return new DuplicateTaskCompletionException("Complete with: ".concat(exception != null ? AnalyticsConstants.EVENT_FAILURE : task.isSuccessful() ? "result ".concat(String.valueOf(String.valueOf(task.getResult()))) : task.isCanceled() ? "cancellation" : "unknown issue"), exception);
    }
}
