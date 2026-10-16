package com.google.android.gms.tasks;

/* compiled from: com.google.android.gms:play-services-tasks@@18.2.1 */
/* loaded from: classes5.dex */
public interface Continuation<TResult, TContinuationResult> {
    TContinuationResult then(Task<TResult> task) throws Exception;
}
