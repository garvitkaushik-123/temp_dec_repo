package com.sourcepoint.cmplibrary.data.network.converter;

import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.ironsource.C3040d4;
import com.sourcepoint.cmplibrary.exception.InvalidResponseWebMessageException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExceptionUtils.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\t"}, d2 = {C3040d4.f.e, "", PglCryptUtils.KEY_MESSAGE, "", "throwable", "", "failParam", "param", "genericFail", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ExceptionUtilsKt {
    public static final Void failParam(String param) {
        Intrinsics.checkNotNullParameter(param, "param");
        throw new InvalidResponseWebMessageException(null, param + " object is null", false, 5, null);
    }

    public static final Void fail(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        throw new InvalidResponseWebMessageException(null, message, false, 5, null);
    }

    public static final Void fail(String message, Throwable throwable) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        throw new InvalidResponseWebMessageException(throwable, message, false, 4, null);
    }

    public static final Void genericFail(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        throw new RuntimeException(message);
    }
}
