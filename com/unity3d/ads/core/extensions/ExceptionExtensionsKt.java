package com.unity3d.ads.core.extensions;

import com.unity3d.services.SDKErrorHandler;
import java.io.PrintWriter;
import java.io.StringWriter;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* compiled from: ExceptionExtensions.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0006"}, d2 = {"getShortenedStackTrace", "", "", "maxLines", "", "retrieveUnityCrashValue", "unity-ads_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class ExceptionExtensionsKt {
    public static final String retrieveUnityCrashValue(Throwable th) {
        StackTraceElement stackTraceElement;
        boolean z;
        String className;
        Intrinsics.checkNotNullParameter(th, "<this>");
        StackTraceElement[] stackTrace = th.getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "this.stackTrace");
        StackTraceElement[] stackTraceElementArr = stackTrace;
        int length = stackTraceElementArr.length;
        int i = 0;
        while (true) {
            stackTraceElement = null;
            if (i >= length) {
                break;
            }
            StackTraceElement stackTraceElement2 = stackTraceElementArr[i];
            StackTraceElement stackTraceElement3 = stackTraceElement2;
            if (stackTraceElement3 == null || (className = stackTraceElement3.getClassName()) == null) {
                z = false;
            } else {
                Intrinsics.checkNotNullExpressionValue(className, "className");
                z = StringsKt.contains$default((CharSequence) className, (CharSequence) SDKErrorHandler.UNITY_PACKAGE, false, 2, (Object) null);
            }
            if (z) {
                stackTraceElement = stackTraceElement2;
                break;
            }
            i++;
        }
        StackTraceElement stackTraceElement4 = stackTraceElement;
        if (stackTraceElement4 != null) {
            String fileName = stackTraceElement4.getFileName();
            if (fileName == null) {
                fileName = "unknown";
            } else {
                Intrinsics.checkNotNullExpressionValue(fileName, "it.fileName ?: SDKErrorHandler.UNKNOWN_FILE");
            }
            String str = fileName + '_' + stackTraceElement4.getLineNumber();
            if (str != null) {
                return str;
            }
        }
        return "unknown";
    }

    public static /* synthetic */ String getShortenedStackTrace$default(Throwable th, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 15;
        }
        return getShortenedStackTrace(th, i);
    }

    public static final String getShortenedStackTrace(Throwable th, int i) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        try {
            PrintWriter stringWriter = new StringWriter();
            try {
                StringWriter stringWriter2 = stringWriter;
                stringWriter = new PrintWriter(stringWriter2);
                try {
                    th.printStackTrace(stringWriter);
                    String stringWriter3 = stringWriter2.toString();
                    Intrinsics.checkNotNullExpressionValue(stringWriter3, "stringWriter.toString()");
                    String joinToString$default = SequencesKt.joinToString$default(SequencesKt.take(StringsKt.lineSequence(StringsKt.trim((CharSequence) stringWriter3).toString()), i), "\n", null, null, 0, null, null, 62, null);
                    CloseableKt.closeFinally(stringWriter, null);
                    CloseableKt.closeFinally(stringWriter, null);
                    return joinToString$default;
                } finally {
                }
            } finally {
            }
        } catch (Throwable unused) {
            return "";
        }
    }
}
