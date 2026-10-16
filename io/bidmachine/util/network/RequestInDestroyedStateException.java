package io.bidmachine.util.network;

import kotlin.Metadata;

/* compiled from: RequestInDestroyedStateException.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/bidmachine/util/network/RequestInDestroyedStateException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "()V", "bidmachine-android-sdk_ca_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class RequestInDestroyedStateException extends IllegalStateException {
    public RequestInDestroyedStateException() {
        super("Request has already been destroyed");
    }
}
