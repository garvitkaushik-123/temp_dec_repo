package io.ktor.http;

import io.ktor.http.Parameters;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* compiled from: Query.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a,\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b\u001a \u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0002\u001a \u0010\u000e\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\rH\u0002\u001a4\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a,\u0010\u0015\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\u0016"}, d2 = {"parseQueryString", "Lio/ktor/http/Parameters;", "query", "", "startIndex", "", "limit", "decode", "", "trimEnd", "start", "end", "text", "", "trimStart", "appendParam", "", "Lio/ktor/http/ParametersBuilder;", "nameIndex", "equalIndex", "endIndex", "parse", "ktor-http"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class QueryKt {
    public static /* synthetic */ Parameters parseQueryString$default(String str, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 1000;
        }
        if ((i3 & 8) != 0) {
            z = true;
        }
        return parseQueryString(str, i, i2, z);
    }

    public static final Parameters parseQueryString(String query, int i, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(query, "query");
        if (i > StringsKt.getLastIndex(query)) {
            return Parameters.INSTANCE.getEmpty();
        }
        Parameters.Companion companion = Parameters.INSTANCE;
        ParametersBuilder ParametersBuilder$default = ParametersKt.ParametersBuilder$default(0, 1, null);
        parse(ParametersBuilder$default, query, i, i2, z);
        return ParametersBuilder$default.build();
    }

    private static final void parse(ParametersBuilder parametersBuilder, String str, int i, int i2, boolean z) {
        int i3;
        int lastIndex = StringsKt.getLastIndex(str);
        int i4 = 0;
        int i5 = i;
        if (i <= lastIndex) {
            int i6 = i5;
            int i7 = 0;
            i3 = -1;
            while (i7 != i2) {
                char charAt = str.charAt(i6);
                if (charAt == '&') {
                    appendParam(parametersBuilder, str, i5, i3, i6, z);
                    i7++;
                    i5 = i6 + 1;
                    i3 = -1;
                } else if (charAt == '=' && i3 == -1) {
                    i3 = i6;
                }
                if (i6 != lastIndex) {
                    i6++;
                } else {
                    i4 = i7;
                }
            }
            return;
        }
        i3 = -1;
        if (i4 == i2) {
            return;
        }
        appendParam(parametersBuilder, str, i5, i3, str.length(), z);
    }

    private static final void appendParam(ParametersBuilder parametersBuilder, String str, int i, int i2, int i3, boolean z) {
        String substring;
        String substring2;
        String substring3;
        if (i2 == -1) {
            String str2 = str;
            int trimStart = trimStart(i, i3, str2);
            int trimEnd = trimEnd(trimStart, i3, str2);
            if (trimEnd > trimStart) {
                if (z) {
                    substring3 = CodecsKt.decodeURLQueryComponent$default(str, trimStart, trimEnd, false, null, 12, null);
                } else {
                    substring3 = str.substring(trimStart, trimEnd);
                    Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
                }
                parametersBuilder.appendAll(substring3, CollectionsKt.emptyList());
                return;
            }
            return;
        }
        String str3 = str;
        int trimStart2 = trimStart(i, i2, str3);
        int trimEnd2 = trimEnd(trimStart2, i2, str3);
        if (trimEnd2 > trimStart2) {
            if (z) {
                substring = CodecsKt.decodeURLQueryComponent$default(str, trimStart2, trimEnd2, false, null, 12, null);
            } else {
                substring = str.substring(trimStart2, trimEnd2);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            int trimStart3 = trimStart(i2 + 1, i3, str3);
            int trimEnd3 = trimEnd(trimStart3, i3, str3);
            if (z) {
                substring2 = CodecsKt.decodeURLQueryComponent$default(str, trimStart3, trimEnd3, true, null, 8, null);
            } else {
                substring2 = str.substring(trimStart3, trimEnd3);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            parametersBuilder.append(substring, substring2);
        }
    }

    private static final int trimEnd(int i, int i2, CharSequence charSequence) {
        while (i2 > i && CharsKt.isWhitespace(charSequence.charAt(i2 - 1))) {
            i2--;
        }
        return i2;
    }

    private static final int trimStart(int i, int i2, CharSequence charSequence) {
        while (i < i2 && CharsKt.isWhitespace(charSequence.charAt(i))) {
            i++;
        }
        return i;
    }
}
