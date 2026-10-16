package com.unity3d.services.core.domain;

import androidx.exifinterface.media.ExifInterface;
import com.unity3d.services.core.domain.task.InitializationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResultExtensions.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u000e\b\u0000\u0010\u0001\u0018\u0001*\u00060\u0002j\u0002`\u0003*\u0006\u0012\u0002\b\u00030\u0004H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a)\u0010\u0006\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001\u0018\u0001*\u00060\u0002j\u0002`\u0003*\u0006\u0012\u0002\b\u00030\u0004H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b*\u0006\u0012\u0002\b\u00030\u0004ø\u0001\u0000¢\u0006\u0002\u0010\t\u001a\u0016\u0010\n\u001a\u00020\b*\u0006\u0012\u0002\b\u00030\u0004ø\u0001\u0000¢\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"getCustomExceptionOrNull", ExifInterface.LONGITUDE_EAST, "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Exception;", "getCustomExceptionOrThrow", "getInitializationExceptionOrNull", "Lcom/unity3d/services/core/domain/task/InitializationException;", "(Ljava/lang/Object;)Lcom/unity3d/services/core/domain/task/InitializationException;", "getInitializationExceptionOrThrow", "unity-ads_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class ResultExtensionsKt {
    public static final /* synthetic */ <E extends Exception> E getCustomExceptionOrNull(Object obj) {
        Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(obj);
        Intrinsics.reifiedOperationMarker(3, ExifInterface.LONGITUDE_EAST);
        if (m10244exceptionOrNullimpl instanceof Exception) {
            return (E) m10244exceptionOrNullimpl;
        }
        return null;
    }

    public static final /* synthetic */ <E extends Exception> E getCustomExceptionOrThrow(Object obj) {
        Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(obj);
        Intrinsics.reifiedOperationMarker(3, ExifInterface.LONGITUDE_EAST);
        if (m10244exceptionOrNullimpl instanceof Exception) {
            return (E) m10244exceptionOrNullimpl;
        }
        throw new IllegalArgumentException("Wrong Exception type found");
    }

    public static final InitializationException getInitializationExceptionOrNull(Object obj) {
        Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(obj);
        if (m10244exceptionOrNullimpl instanceof InitializationException) {
            return (InitializationException) m10244exceptionOrNullimpl;
        }
        return null;
    }

    public static final InitializationException getInitializationExceptionOrThrow(Object obj) {
        Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(obj);
        if (m10244exceptionOrNullimpl instanceof InitializationException) {
            return (InitializationException) m10244exceptionOrNullimpl;
        }
        throw new IllegalArgumentException("Wrong Exception type found");
    }
}
