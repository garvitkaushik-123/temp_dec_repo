package io.ktor.client.utils;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExceptionUtilsJvm.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0003\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001¨\u0006\u0002"}, d2 = {"unwrapCancellationException", "", "ktor-client-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ExceptionUtilsJvmKt {
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001f, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Throwable unwrapCancellationException(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        Throwable th2 = th;
        while (true) {
            if (!(th2 instanceof CancellationException)) {
                if (th2 == null) {
                    break;
                }
                return th2;
            }
            CancellationException cancellationException = (CancellationException) th2;
            if (Intrinsics.areEqual(th2, cancellationException.getCause())) {
                break;
            }
            th2 = cancellationException.getCause();
        }
    }
}
