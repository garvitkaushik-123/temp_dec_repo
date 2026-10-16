package com.sourcepoint.cmplibrary.util;

import androidx.exifinterface.media.ExifInterface;
import com.sourcepoint.cmplibrary.core.Either;
import com.sourcepoint.cmplibrary.exception.ApiRequestPostfix;
import com.sourcepoint.cmplibrary.exception.ConnectionTimeoutException;
import com.sourcepoint.cmplibrary.exception.ConsentLibExceptionK;
import com.sourcepoint.cmplibrary.exception.GenericSDKException;
import com.sourcepoint.cmplibrary.exception.UnableToParseResponseException;
import java.io.InterruptedIOException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;

/* compiled from: FunctionalUtils.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\u001a\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000\u001a.\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000\u001a\u0018\u0010\u0007\u001a\u00020\b*\u00020\t2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0000¨\u0006\n"}, d2 = {"check", "Lcom/sourcepoint/cmplibrary/core/Either;", ExifInterface.LONGITUDE_EAST, "block", "Lkotlin/Function0;", "requestPostfix", "Lcom/sourcepoint/cmplibrary/exception/ApiRequestPostfix;", "toConsentLibException", "Lcom/sourcepoint/cmplibrary/exception/ConsentLibExceptionK;", "", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FunctionalUtilsKt {
    public static final <E> Either<E> check(Function0<? extends E> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            return new Either.Right(block.invoke());
        } catch (Exception e) {
            return new Either.Left(toConsentLibException$default(e, null, 1, null));
        }
    }

    public static /* synthetic */ Either check$default(ApiRequestPostfix apiRequestPostfix, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            apiRequestPostfix = null;
        }
        return check(apiRequestPostfix, function0);
    }

    public static final <E> Either<E> check(ApiRequestPostfix apiRequestPostfix, Function0<? extends E> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            return new Either.Right(block.invoke());
        } catch (Exception e) {
            return new Either.Left(toConsentLibException(e, apiRequestPostfix));
        }
    }

    public static /* synthetic */ ConsentLibExceptionK toConsentLibException$default(Throwable th, ApiRequestPostfix apiRequestPostfix, int i, Object obj) {
        if ((i & 1) != 0) {
            apiRequestPostfix = null;
        }
        return toConsentLibException(th, apiRequestPostfix);
    }

    public static final ConsentLibExceptionK toConsentLibException(Throwable th, ApiRequestPostfix apiRequestPostfix) {
        String apiPostfix;
        String apiPostfix2;
        Intrinsics.checkNotNullParameter(th, "<this>");
        if (th instanceof ConsentLibExceptionK) {
            return (ConsentLibExceptionK) th;
        }
        if (th instanceof SerializationException) {
            String message = th.getMessage();
            if (message == null) {
                message = String.valueOf(th.getClass());
            }
            return new UnableToParseResponseException(th, message, false, (apiRequestPostfix == null || (apiPostfix2 = apiRequestPostfix.getApiPostfix()) == null) ? "" : apiPostfix2, 4, null);
        }
        if (th instanceof InterruptedIOException) {
            return new ConnectionTimeoutException(th, null, false, (apiRequestPostfix == null || (apiPostfix = apiRequestPostfix.getApiPostfix()) == null) ? "" : apiPostfix, 6, null);
        }
        String message2 = th.getMessage();
        if (message2 == null) {
            message2 = String.valueOf(th.getClass());
        }
        return new GenericSDKException(th, message2, false, 4, null);
    }
}
