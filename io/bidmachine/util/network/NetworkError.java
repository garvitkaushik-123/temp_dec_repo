package io.bidmachine.util.network;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NetworkError.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lio/bidmachine/util/network/NetworkError;", "", "throwable", "", "(Ljava/lang/Throwable;)V", "getThrowable", "()Ljava/lang/Throwable;", "toString", "", "bidmachine-android-sdk_ca_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class NetworkError {
    private final Throwable throwable;

    public NetworkError(Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        this.throwable = throwable;
    }

    public final Throwable getThrowable() {
        return this.throwable;
    }

    public String toString() {
        return this.throwable.toString();
    }
}
