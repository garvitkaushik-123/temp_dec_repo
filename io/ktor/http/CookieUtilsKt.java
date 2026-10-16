package io.ktor.http;

import io.ktor.util.date.Month;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: CookieUtils.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0000\u001a\f\u0010\b\u001a\u00020\u0006*\u00020\u0007H\u0000\u001a\f\u0010\t\u001a\u00020\u0006*\u00020\u0007H\u0000\u001a\f\u0010\n\u001a\u00020\u0006*\u00020\u0007H\u0000\u001a\f\u0010\u000b\u001a\u00020\u0006*\u00020\u0007H\u0000\u001a\u001e\u0010\f\u001a\u00020\u0001*\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0080\bø\u0001\u0000\u001a$\u0010\u000f\u001a\u00020\u0001*\u00020\u00042\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011H\u0080\bø\u0001\u0000\u001a$\u0010\u0013\u001a\u00020\u0001*\u00020\u00042\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0011H\u0080\bø\u0001\u0000\u001a0\u0010\u0015\u001a\u00020\u0001*\u00020\u00042\u001e\u0010\u0010\u001a\u001a\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0016H\u0080\bø\u0001\u0000\u001a$\u0010\u0017\u001a\u00020\u0001*\u00020\u00042\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011H\u0080\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018"}, d2 = {"handleToken", "", "Lio/ktor/http/CookieDateBuilder;", "token", "", "isDelimiter", "", "", "isDigit", "isNonDelimiter", "isNonDigit", "isOctet", "otherwise", "block", "Lkotlin/Function0;", "tryParseDayOfMonth", "success", "Lkotlin/Function1;", "", "tryParseMonth", "Lio/ktor/util/date/Month;", "tryParseTime", "Lkotlin/Function3;", "tryParseYear", "ktor-http"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class CookieUtilsKt {
    public static final boolean isDelimiter(char c) {
        if (c == '\t') {
            return true;
        }
        if (' ' <= c && c < '0') {
            return true;
        }
        if (';' <= c && c < 'A') {
            return true;
        }
        if ('[' > c || c >= 'a') {
            return '{' <= c && c < 127;
        }
        return true;
    }

    public static final boolean isDigit(char c) {
        return '0' <= c && c < ':';
    }

    public static final boolean isNonDelimiter(char c) {
        if (c >= 0 && c < '\t') {
            return true;
        }
        if ('\n' <= c && c < ' ') {
            return true;
        }
        if (('0' <= c && c < ':') || c == ':') {
            return true;
        }
        if ('a' <= c && c < '{') {
            return true;
        }
        if ('A' > c || c >= '[') {
            return 127 <= c && c < 256;
        }
        return true;
    }

    public static final boolean isNonDigit(char c) {
        if (c < 0 || c >= '0') {
            return 'J' <= c && c < 256;
        }
        return true;
    }

    public static final boolean isOctet(char c) {
        return c >= 0 && c < 256;
    }

    public static final void otherwise(boolean z, Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (z) {
            return;
        }
        block.invoke();
    }

    public static final void tryParseTime(String str, Function3<? super Integer, ? super Integer, ? super Integer, Unit> success) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(success, "success");
        StringLexer stringLexer = new StringLexer(str);
        int index = stringLexer.getIndex();
        if (stringLexer.accept(CookieUtilsKt$tryParseTime$hour$1$1.INSTANCE)) {
            stringLexer.accept(CookieUtilsKt$tryParseTime$hour$1$3.INSTANCE);
            String substring = stringLexer.getSource().substring(index, stringLexer.getIndex());
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            int parseInt = Integer.parseInt(substring);
            if (stringLexer.accept(CookieUtilsKt$tryParseTime$1.INSTANCE)) {
                int index2 = stringLexer.getIndex();
                if (stringLexer.accept(CookieUtilsKt$tryParseTime$minute$1$1.INSTANCE)) {
                    stringLexer.accept(CookieUtilsKt$tryParseTime$minute$1$3.INSTANCE);
                    String substring2 = stringLexer.getSource().substring(index2, stringLexer.getIndex());
                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    int parseInt2 = Integer.parseInt(substring2);
                    if (stringLexer.accept(CookieUtilsKt$tryParseTime$3.INSTANCE)) {
                        int index3 = stringLexer.getIndex();
                        if (stringLexer.accept(CookieUtilsKt$tryParseTime$second$1$1.INSTANCE)) {
                            stringLexer.accept(CookieUtilsKt$tryParseTime$second$1$3.INSTANCE);
                            String substring3 = stringLexer.getSource().substring(index3, stringLexer.getIndex());
                            Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
                            int parseInt3 = Integer.parseInt(substring3);
                            if (stringLexer.accept(CookieUtilsKt$tryParseTime$5.INSTANCE)) {
                                stringLexer.acceptWhile(CookieUtilsKt$tryParseTime$6.INSTANCE);
                            }
                            success.invoke(Integer.valueOf(parseInt), Integer.valueOf(parseInt2), Integer.valueOf(parseInt3));
                        }
                    }
                }
            }
        }
    }

    public static final void tryParseMonth(String str, Function1<? super Month, Unit> success) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(success, "success");
        if (str.length() < 3) {
            return;
        }
        for (Month month : Month.values()) {
            if (StringsKt.startsWith(str, month.getValue(), true)) {
                success.invoke(month);
                return;
            }
        }
    }

    public static final void tryParseDayOfMonth(String str, Function1<? super Integer, Unit> success) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(success, "success");
        StringLexer stringLexer = new StringLexer(str);
        int index = stringLexer.getIndex();
        if (stringLexer.accept(CookieUtilsKt$tryParseDayOfMonth$day$1$1.INSTANCE)) {
            stringLexer.accept(CookieUtilsKt$tryParseDayOfMonth$day$1$3.INSTANCE);
            String substring = stringLexer.getSource().substring(index, stringLexer.getIndex());
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            int parseInt = Integer.parseInt(substring);
            if (stringLexer.accept(CookieUtilsKt$tryParseDayOfMonth$1.INSTANCE)) {
                stringLexer.acceptWhile(CookieUtilsKt$tryParseDayOfMonth$2.INSTANCE);
            }
            success.invoke(Integer.valueOf(parseInt));
        }
    }

    public static final void tryParseYear(String str, Function1<? super Integer, Unit> success) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(success, "success");
        StringLexer stringLexer = new StringLexer(str);
        int index = stringLexer.getIndex();
        for (int i = 0; i < 2; i++) {
            if (!stringLexer.accept(CookieUtilsKt$tryParseYear$year$1$1$1.INSTANCE)) {
                return;
            }
        }
        for (int i2 = 0; i2 < 2; i2++) {
            stringLexer.accept(CookieUtilsKt$tryParseYear$year$1$2$1.INSTANCE);
        }
        String substring = stringLexer.getSource().substring(index, stringLexer.getIndex());
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        int parseInt = Integer.parseInt(substring);
        if (stringLexer.accept(CookieUtilsKt$tryParseYear$1.INSTANCE)) {
            stringLexer.acceptWhile(CookieUtilsKt$tryParseYear$2.INSTANCE);
        }
        success.invoke(Integer.valueOf(parseInt));
    }

    public static final void handleToken(CookieDateBuilder cookieDateBuilder, String token) {
        Intrinsics.checkNotNullParameter(cookieDateBuilder, "<this>");
        Intrinsics.checkNotNullParameter(token, "token");
        if (cookieDateBuilder.getHours() == null || cookieDateBuilder.getMinutes() == null || cookieDateBuilder.getSeconds() == null) {
            StringLexer stringLexer = new StringLexer(token);
            int index = stringLexer.getIndex();
            if (stringLexer.accept(CookieUtilsKt$tryParseTime$hour$1$1.INSTANCE)) {
                stringLexer.accept(CookieUtilsKt$tryParseTime$hour$1$3.INSTANCE);
                String substring = stringLexer.getSource().substring(index, stringLexer.getIndex());
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                int parseInt = Integer.parseInt(substring);
                if (stringLexer.accept(CookieUtilsKt$tryParseTime$1.INSTANCE)) {
                    int index2 = stringLexer.getIndex();
                    if (stringLexer.accept(CookieUtilsKt$tryParseTime$minute$1$1.INSTANCE)) {
                        stringLexer.accept(CookieUtilsKt$tryParseTime$minute$1$3.INSTANCE);
                        String substring2 = stringLexer.getSource().substring(index2, stringLexer.getIndex());
                        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                        int parseInt2 = Integer.parseInt(substring2);
                        if (stringLexer.accept(CookieUtilsKt$tryParseTime$3.INSTANCE)) {
                            int index3 = stringLexer.getIndex();
                            if (stringLexer.accept(CookieUtilsKt$tryParseTime$second$1$1.INSTANCE)) {
                                stringLexer.accept(CookieUtilsKt$tryParseTime$second$1$3.INSTANCE);
                                String substring3 = stringLexer.getSource().substring(index3, stringLexer.getIndex());
                                Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
                                int parseInt3 = Integer.parseInt(substring3);
                                if (stringLexer.accept(CookieUtilsKt$tryParseTime$5.INSTANCE)) {
                                    stringLexer.acceptWhile(CookieUtilsKt$tryParseTime$6.INSTANCE);
                                }
                                cookieDateBuilder.setHours(Integer.valueOf(parseInt));
                                cookieDateBuilder.setMinutes(Integer.valueOf(parseInt2));
                                cookieDateBuilder.setSeconds(Integer.valueOf(parseInt3));
                                return;
                            }
                        }
                    }
                }
            }
        }
        if (cookieDateBuilder.getDayOfMonth() == null) {
            StringLexer stringLexer2 = new StringLexer(token);
            int index4 = stringLexer2.getIndex();
            if (stringLexer2.accept(CookieUtilsKt$tryParseDayOfMonth$day$1$1.INSTANCE)) {
                stringLexer2.accept(CookieUtilsKt$tryParseDayOfMonth$day$1$3.INSTANCE);
                String substring4 = stringLexer2.getSource().substring(index4, stringLexer2.getIndex());
                Intrinsics.checkNotNullExpressionValue(substring4, "this as java.lang.String…ing(startIndex, endIndex)");
                int parseInt4 = Integer.parseInt(substring4);
                if (stringLexer2.accept(CookieUtilsKt$tryParseDayOfMonth$1.INSTANCE)) {
                    stringLexer2.acceptWhile(CookieUtilsKt$tryParseDayOfMonth$2.INSTANCE);
                }
                cookieDateBuilder.setDayOfMonth(Integer.valueOf(parseInt4));
                return;
            }
        }
        if (cookieDateBuilder.getMonth() == null && token.length() >= 3) {
            for (Month month : Month.values()) {
                if (StringsKt.startsWith(token, month.getValue(), true)) {
                    cookieDateBuilder.setMonth(month);
                    return;
                }
            }
        }
        if (cookieDateBuilder.getYear() == null) {
            StringLexer stringLexer3 = new StringLexer(token);
            int index5 = stringLexer3.getIndex();
            for (int i = 0; i < 2; i++) {
                if (!stringLexer3.accept(CookieUtilsKt$tryParseYear$year$1$1$1.INSTANCE)) {
                    return;
                }
            }
            for (int i2 = 0; i2 < 2; i2++) {
                stringLexer3.accept(CookieUtilsKt$tryParseYear$year$1$2$1.INSTANCE);
            }
            String substring5 = stringLexer3.getSource().substring(index5, stringLexer3.getIndex());
            Intrinsics.checkNotNullExpressionValue(substring5, "this as java.lang.String…ing(startIndex, endIndex)");
            int parseInt5 = Integer.parseInt(substring5);
            if (stringLexer3.accept(CookieUtilsKt$tryParseYear$1.INSTANCE)) {
                stringLexer3.acceptWhile(CookieUtilsKt$tryParseYear$2.INSTANCE);
            }
            cookieDateBuilder.setYear(Integer.valueOf(parseInt5));
        }
    }
}
