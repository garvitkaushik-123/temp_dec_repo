package io.ktor.http.auth;

import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.http.CookieUtilsKt;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.http.parsing.ParseException;
import io.ktor.util.InternalAPI;
import io.ktor.util.date.GMTDateParser;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: HttpAuthHeader.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\"\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a,\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\rH\u0002\u001a,\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\rH\u0002\u001a\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0002\u001a5\u0010\u0010\u001a\u0004\u0018\u00010\b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002¢\u0006\u0002\u0010\u0016\u001a\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00132\u0006\u0010\t\u001a\u00020\n\u001a&\u0010\u0017\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002\u001a\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u00192\u0006\u0010\t\u001a\u00020\nH\u0007\u001a\f\u0010\u001a\u001a\u00020\u001b*\u00020\u0002H\u0002\u001a\f\u0010\u001c\u001a\u00020\u001b*\u00020\u0002H\u0002\u001a\u001c\u0010\u001d\u001a\u00020\b*\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u0002H\u0002\u001a\u0014\u0010\u001f\u001a\u00020\b*\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0002\u001a\f\u0010 \u001a\u00020\n*\u00020\nH\u0002\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"TOKEN68_EXTRA", "", "", "TOKEN_EXTRA", "escapeRegex", "Lkotlin/text/Regex;", "token68Pattern", "matchParameter", "", "headerValue", "", "startIndex", "parameters", "", "matchParameters", "matchToken68", "nextChallengeIndex", "headers", "", "Lio/ktor/http/auth/HttpAuthHeader;", "header", FirebaseAnalytics.Param.INDEX, "(Ljava/util/List;Lio/ktor/http/auth/HttpAuthHeader;ILjava/lang/String;)Ljava/lang/Integer;", "parseAuthorizationHeader", "parseAuthorizationHeaders", "", "isToken", "", "isToken68", "skipDelimiter", "delimiter", "skipSpaces", "unescaped", "ktor-http"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class HttpAuthHeaderKt {
    private static final Set<Character> TOKEN_EXTRA = SetsKt.setOf((Object[]) new Character[]{'!', '#', Character.valueOf(Typography.dollar), '%', Character.valueOf(Typography.amp), '\'', Character.valueOf(GMTDateParser.ANY), '+', '-', '.', '^', '_', '`', '|', '~'});
    private static final Set<Character> TOKEN68_EXTRA = SetsKt.setOf((Object[]) new Character[]{'-', '.', '_', '~', '+', '/'});
    private static final Regex token68Pattern = new Regex("[a-zA-Z0-9\\-._~+/]+=*");
    private static final Regex escapeRegex = new Regex("\\\\.");

    public static final HttpAuthHeader parseAuthorizationHeader(String headerValue) {
        Intrinsics.checkNotNullParameter(headerValue, "headerValue");
        int skipSpaces = skipSpaces(headerValue, 0);
        int i = skipSpaces;
        while (i < headerValue.length() && isToken(headerValue.charAt(i))) {
            i++;
        }
        String substring = StringsKt.substring(headerValue, RangesKt.until(skipSpaces, i));
        int skipSpaces2 = skipSpaces(headerValue, i);
        if (StringsKt.isBlank(substring)) {
            return null;
        }
        if (headerValue.length() == skipSpaces2) {
            return new HttpAuthHeader.Parameterized(substring, CollectionsKt.emptyList(), (HeaderValueEncoding) null, 4, (DefaultConstructorMarker) null);
        }
        int matchToken68 = matchToken68(headerValue, skipSpaces2);
        String obj = StringsKt.trim((CharSequence) StringsKt.substring(headerValue, RangesKt.until(skipSpaces2, matchToken68))).toString();
        if (obj.length() > 0 && matchToken68 == headerValue.length()) {
            return new HttpAuthHeader.Single(substring, obj);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (matchParameters(headerValue, skipSpaces2, linkedHashMap) == -1) {
            return new HttpAuthHeader.Parameterized(substring, linkedHashMap, (HeaderValueEncoding) null, 4, (DefaultConstructorMarker) null);
        }
        throw new ParseException("Function parseAuthorizationHeader can parse only one header", null, 2, null);
    }

    @InternalAPI
    public static final List<HttpAuthHeader> parseAuthorizationHeaders(String headerValue) {
        Intrinsics.checkNotNullParameter(headerValue, "headerValue");
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i != -1) {
            i = parseAuthorizationHeader(headerValue, i, arrayList);
        }
        return arrayList;
    }

    private static final int parseAuthorizationHeader(String str, int i, List<HttpAuthHeader> list) {
        Integer nextChallengeIndex;
        int skipSpaces = skipSpaces(str, i);
        int i2 = skipSpaces;
        while (i2 < str.length() && isToken(str.charAt(i2))) {
            i2++;
        }
        String substring = StringsKt.substring(str, RangesKt.until(skipSpaces, i2));
        if (StringsKt.isBlank(substring)) {
            throw new ParseException("Invalid authScheme value: it should be token, can't be blank", null, 2, null);
        }
        int skipSpaces2 = skipSpaces(str, i2);
        Integer nextChallengeIndex2 = nextChallengeIndex(list, new HttpAuthHeader.Parameterized(substring, CollectionsKt.emptyList(), (HeaderValueEncoding) null, 4, (DefaultConstructorMarker) null), skipSpaces2, str);
        if (nextChallengeIndex2 != null) {
            return nextChallengeIndex2.intValue();
        }
        int matchToken68 = matchToken68(str, skipSpaces2);
        String obj = StringsKt.trim((CharSequence) StringsKt.substring(str, RangesKt.until(skipSpaces2, matchToken68))).toString();
        if (obj.length() > 0 && (nextChallengeIndex = nextChallengeIndex(list, new HttpAuthHeader.Single(substring, obj), matchToken68, str)) != null) {
            return nextChallengeIndex.intValue();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int matchParameters = matchParameters(str, skipSpaces2, linkedHashMap);
        list.add(new HttpAuthHeader.Parameterized(substring, linkedHashMap, (HeaderValueEncoding) null, 4, (DefaultConstructorMarker) null));
        return matchParameters;
    }

    private static final Integer nextChallengeIndex(List<HttpAuthHeader> list, HttpAuthHeader httpAuthHeader, int i, String str) {
        if (i != str.length() && str.charAt(i) != ',') {
            return null;
        }
        list.add(httpAuthHeader);
        if (i == str.length()) {
            return -1;
        }
        if (str.charAt(i) == ',') {
            return Integer.valueOf(i + 1);
        }
        throw new IllegalStateException("".toString());
    }

    private static final int matchParameters(String str, int i, Map<String, String> map) {
        while (i > 0 && i < str.length()) {
            int matchParameter = matchParameter(str, i, map);
            if (matchParameter == i) {
                break;
            }
            i = skipDelimiter(str, matchParameter, AbstractJsonLexerKt.COMMA);
        }
        return i;
    }

    private static final int matchParameter(String str, int i, Map<String, String> map) {
        int i2;
        int skipSpaces = skipSpaces(str, i);
        int i3 = skipSpaces;
        while (i3 < str.length() && isToken(str.charAt(i3))) {
            i3++;
        }
        String substring = StringsKt.substring(str, RangesKt.until(skipSpaces, i3));
        int skipSpaces2 = skipSpaces(str, i3);
        if (skipSpaces2 == str.length() || str.charAt(skipSpaces2) != '=') {
            return i;
        }
        int skipSpaces3 = skipSpaces(str, skipSpaces2 + 1);
        boolean z = false;
        if (str.charAt(skipSpaces3) == '\"') {
            skipSpaces3++;
            i2 = skipSpaces3;
            boolean z2 = false;
            while (i2 < str.length() && (str.charAt(i2) != '\"' || z2)) {
                z2 = !z2 && str.charAt(i2) == '\\';
                i2++;
            }
            if (i2 == str.length()) {
                throw new ParseException("Expected closing quote'\"' in parameter", null, 2, null);
            }
            z = true;
        } else {
            i2 = skipSpaces3;
            while (i2 < str.length() && str.charAt(i2) != ' ' && str.charAt(i2) != ',') {
                i2++;
            }
        }
        String substring2 = StringsKt.substring(str, RangesKt.until(skipSpaces3, i2));
        if (z) {
            substring2 = unescaped(substring2);
        }
        map.put(substring, substring2);
        return z ? i2 + 1 : i2;
    }

    private static final int matchToken68(String str, int i) {
        int skipSpaces = skipSpaces(str, i);
        while (skipSpaces < str.length() && isToken68(str.charAt(skipSpaces))) {
            skipSpaces++;
        }
        while (skipSpaces < str.length() && str.charAt(skipSpaces) == '=') {
            skipSpaces++;
        }
        return skipSpaces(str, skipSpaces);
    }

    private static final String unescaped(String str) {
        return escapeRegex.replace(str, new Function1<MatchResult, CharSequence>() { // from class: io.ktor.http.auth.HttpAuthHeaderKt$unescaped$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(MatchResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return StringsKt.takeLast(it.getValue(), 1);
            }
        });
    }

    private static final int skipDelimiter(String str, int i, char c) {
        int skipSpaces = skipSpaces(str, i);
        if (skipSpaces == str.length()) {
            return -1;
        }
        if (str.charAt(skipSpaces) != c) {
            throw new ParseException("Expected delimiter " + c + " at position " + skipSpaces, null, 2, null);
        }
        return skipSpaces(str, skipSpaces + 1);
    }

    private static final int skipSpaces(String str, int i) {
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        return i;
    }

    private static final boolean isToken68(char c) {
        if ('a' > c || c >= '{') {
            return ('A' <= c && c < '[') || CookieUtilsKt.isDigit(c) || TOKEN68_EXTRA.contains(Character.valueOf(c));
        }
        return true;
    }

    private static final boolean isToken(char c) {
        if ('a' > c || c >= '{') {
            return ('A' <= c && c < '[') || CookieUtilsKt.isDigit(c) || TOKEN_EXTRA.contains(Character.valueOf(c));
        }
        return true;
    }
}
