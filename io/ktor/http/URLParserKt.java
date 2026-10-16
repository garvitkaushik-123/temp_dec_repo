package io.ktor.http;

import com.google.firebase.sessions.settings.RemoteSettings;
import com.ironsource.C3040d4;
import io.ktor.util.CharsetKt;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* compiled from: URLParser.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u001a(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a \u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002\u001a$\u0010\r\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002\u001a\u001c\u0010\u0010\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002\u001a\f\u0010\u0011\u001a\u00020\u0012*\u00020\u000bH\u0002\u001a,\u0010\u0013\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0002\u001a$\u0010\u0015\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002\u001a$\u0010\u0016\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002\u001a$\u0010\u0017\u001a\u00020\u0006*\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002\u001a\u0012\u0010\u0018\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0002\u001a\u0014\u0010\u0019\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0002H\u0000\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u001a"}, d2 = {"ROOT_PATH", "", "", "getROOT_PATH", "()Ljava/util/List;", "count", "", "urlString", "startIndex", "endIndex", "char", "", "findScheme", "fillHost", "", "Lio/ktor/http/URLBuilder;", "indexOfColonInHostPort", "isLetter", "", "parseFile", "slashCount", "parseFragment", "parseMailto", "parseQuery", "takeFrom", "takeFromUnsafe", "ktor-http"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class URLParserKt {
    private static final List<String> ROOT_PATH = CollectionsKt.listOf("");

    public static final List<String> getROOT_PATH() {
        return ROOT_PATH;
    }

    public static final URLBuilder takeFrom(URLBuilder uRLBuilder, String urlString) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        if (StringsKt.isBlank(urlString)) {
            return uRLBuilder;
        }
        try {
            return takeFromUnsafe(uRLBuilder, urlString);
        } catch (Throwable th) {
            throw new URLParserException(urlString, th);
        }
    }

    public static final URLBuilder takeFromUnsafe(URLBuilder uRLBuilder, String urlString) {
        List<String> emptyList;
        List<String> emptyList2;
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        String str = urlString;
        int length = str.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            }
            if (!CharsKt.isWhitespace(str.charAt(i))) {
                break;
            }
            i++;
        }
        int length2 = str.length() - 1;
        if (length2 >= 0) {
            while (true) {
                int i2 = length2 - 1;
                if (!CharsKt.isWhitespace(str.charAt(length2))) {
                    break;
                }
                if (i2 < 0) {
                    break;
                }
                length2 = i2;
            }
        }
        length2 = -1;
        int i3 = length2 + 1;
        int findScheme = findScheme(urlString, i, i3);
        if (findScheme > 0) {
            String substring = urlString.substring(i, i + findScheme);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            uRLBuilder.setProtocol(URLProtocol.INSTANCE.createOrDefault(substring));
            i += findScheme + 1;
        }
        int count = count(urlString, i, i3, '/');
        int i4 = i + count;
        if (Intrinsics.areEqual(uRLBuilder.getProtocol().getName(), C3040d4.h.b)) {
            parseFile(uRLBuilder, urlString, i4, i3, count);
            return uRLBuilder;
        }
        if (Intrinsics.areEqual(uRLBuilder.getProtocol().getName(), "mailto")) {
            if (count != 0) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            parseMailto(uRLBuilder, urlString, i4, i3);
            return uRLBuilder;
        }
        if (count >= 2) {
            int i5 = i4;
            while (true) {
                Integer valueOf = Integer.valueOf(StringsKt.indexOfAny$default((CharSequence) str, CharsetKt.toCharArray("@/\\?#"), i5, false, 4, (Object) null));
                if (valueOf.intValue() <= 0) {
                    valueOf = null;
                }
                i4 = valueOf != null ? valueOf.intValue() : i3;
                if (i4 >= i3 || urlString.charAt(i4) != '@') {
                    break;
                }
                int indexOfColonInHostPort = indexOfColonInHostPort(urlString, i5, i4);
                if (indexOfColonInHostPort != -1) {
                    String substring2 = urlString.substring(i5, indexOfColonInHostPort);
                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    uRLBuilder.setEncodedUser(substring2);
                    String substring3 = urlString.substring(indexOfColonInHostPort + 1, i4);
                    Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
                    uRLBuilder.setEncodedPassword(substring3);
                } else {
                    String substring4 = urlString.substring(i5, i4);
                    Intrinsics.checkNotNullExpressionValue(substring4, "this as java.lang.String…ing(startIndex, endIndex)");
                    uRLBuilder.setEncodedUser(substring4);
                }
                i5 = i4 + 1;
            }
            fillHost(uRLBuilder, urlString, i5, i4);
        }
        int i6 = i4;
        if (i6 >= i3) {
            uRLBuilder.setEncodedPathSegments(urlString.charAt(length2) == '/' ? ROOT_PATH : CollectionsKt.emptyList());
            return uRLBuilder;
        }
        if (count == 0) {
            emptyList = CollectionsKt.dropLast(uRLBuilder.getEncodedPathSegments(), 1);
        } else {
            emptyList = CollectionsKt.emptyList();
        }
        uRLBuilder.setEncodedPathSegments(emptyList);
        Integer valueOf2 = Integer.valueOf(StringsKt.indexOfAny$default((CharSequence) str, CharsetKt.toCharArray("?#"), i6, false, 4, (Object) null));
        Integer num = valueOf2.intValue() > 0 ? valueOf2 : null;
        int intValue = num != null ? num.intValue() : i3;
        if (intValue > i6) {
            String substring5 = urlString.substring(i6, intValue);
            Intrinsics.checkNotNullExpressionValue(substring5, "this as java.lang.String…ing(startIndex, endIndex)");
            List<String> emptyList3 = (uRLBuilder.getEncodedPathSegments().size() == 1 && ((CharSequence) CollectionsKt.first((List) uRLBuilder.getEncodedPathSegments())).length() == 0) ? CollectionsKt.emptyList() : uRLBuilder.getEncodedPathSegments();
            List<String> split$default = Intrinsics.areEqual(substring5, RemoteSettings.FORWARD_SLASH_STRING) ? ROOT_PATH : StringsKt.split$default((CharSequence) substring5, new char[]{'/'}, false, 0, 6, (Object) null);
            if (count == 1) {
                emptyList2 = ROOT_PATH;
            } else {
                emptyList2 = CollectionsKt.emptyList();
            }
            uRLBuilder.setEncodedPathSegments(CollectionsKt.plus((Collection) emptyList3, (Iterable) CollectionsKt.plus((Collection) emptyList2, (Iterable) split$default)));
            i6 = intValue;
        }
        if (i6 < i3 && urlString.charAt(i6) == '?') {
            i6 = parseQuery(uRLBuilder, urlString, i6, i3);
        }
        parseFragment(uRLBuilder, urlString, i6, i3);
        return uRLBuilder;
    }

    private static final void parseFile(URLBuilder uRLBuilder, String str, int i, int i2, int i3) {
        if (i3 != 2) {
            if (i3 == 3) {
                uRLBuilder.setHost("");
                StringBuilder sb = new StringBuilder(RemoteSettings.FORWARD_SLASH_STRING);
                String substring = str.substring(i, i2);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                URLBuilderKt.setEncodedPath(uRLBuilder, sb.append(substring).toString());
                return;
            }
            throw new IllegalArgumentException("Invalid file url: " + str);
        }
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, '/', i, false, 4, (Object) null);
        if (indexOf$default == -1 || indexOf$default == i2) {
            String substring2 = str.substring(i, i2);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
            uRLBuilder.setHost(substring2);
        } else {
            String substring3 = str.substring(i, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
            uRLBuilder.setHost(substring3);
            String substring4 = str.substring(indexOf$default, i2);
            Intrinsics.checkNotNullExpressionValue(substring4, "this as java.lang.String…ing(startIndex, endIndex)");
            URLBuilderKt.setEncodedPath(uRLBuilder, substring4);
        }
    }

    private static final void parseMailto(URLBuilder uRLBuilder, String str, int i, int i2) {
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, "@", i, false, 4, (Object) null);
        if (indexOf$default == -1) {
            throw new IllegalArgumentException("Invalid mailto url: " + str + ", it should contain '@'.");
        }
        String substring = str.substring(i, indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        uRLBuilder.setUser(CodecsKt.decodeURLPart$default(substring, 0, 0, null, 7, null));
        String substring2 = str.substring(indexOf$default + 1, i2);
        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
        uRLBuilder.setHost(substring2);
    }

    private static final int parseQuery(final URLBuilder uRLBuilder, String str, int i, int i2) {
        int i3 = i + 1;
        if (i3 == i2) {
            uRLBuilder.setTrailingQuery(true);
            return i2;
        }
        Integer valueOf = Integer.valueOf(StringsKt.indexOf$default((CharSequence) str, '#', i3, false, 4, (Object) null));
        if (valueOf.intValue() <= 0) {
            valueOf = null;
        }
        if (valueOf != null) {
            i2 = valueOf.intValue();
        }
        String substring = str.substring(i3, i2);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        QueryKt.parseQueryString$default(substring, 0, 0, false, 6, null).forEach(new Function2<String, List<? extends String>, Unit>() { // from class: io.ktor.http.URLParserKt$parseQuery$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str2, List<? extends String> list) {
                invoke2(str2, (List<String>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String key, List<String> values) {
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(values, "values");
                URLBuilder.this.getEncodedParameters().appendAll(key, values);
            }
        });
        return i2;
    }

    private static final void parseFragment(URLBuilder uRLBuilder, String str, int i, int i2) {
        if (i >= i2 || str.charAt(i) != '#') {
            return;
        }
        String substring = str.substring(i + 1, i2);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        uRLBuilder.setEncodedFragment(substring);
    }

    private static final void fillHost(URLBuilder uRLBuilder, String str, int i, int i2) {
        Integer valueOf = Integer.valueOf(indexOfColonInHostPort(str, i, i2));
        if (valueOf.intValue() <= 0) {
            valueOf = null;
        }
        int intValue = valueOf != null ? valueOf.intValue() : i2;
        String substring = str.substring(i, intValue);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        uRLBuilder.setHost(substring);
        int i3 = intValue + 1;
        if (i3 < i2) {
            String substring2 = str.substring(i3, i2);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
            uRLBuilder.setPort(Integer.parseInt(substring2));
            return;
        }
        uRLBuilder.setPort(0);
    }

    private static final int findScheme(String str, int i, int i2) {
        int i3;
        int i4;
        char charAt = str.charAt(i);
        if (('a' > charAt || charAt >= '{') && ('A' > charAt || charAt >= '[')) {
            i3 = i;
            i4 = i3;
        } else {
            i3 = i;
            i4 = -1;
        }
        while (i3 < i2) {
            char charAt2 = str.charAt(i3);
            if (charAt2 != ':') {
                if (charAt2 == '/' || charAt2 == '?' || charAt2 == '#') {
                    break;
                }
                if (i4 == -1 && (('a' > charAt2 || charAt2 >= '{') && (('A' > charAt2 || charAt2 >= '[') && (('0' > charAt2 || charAt2 >= ':') && charAt2 != '.' && charAt2 != '+' && charAt2 != '-')))) {
                    i4 = i3;
                }
                i3++;
            } else {
                if (i4 == -1) {
                    return i3 - i;
                }
                throw new IllegalArgumentException("Illegal character in scheme at position " + i4);
            }
        }
        return -1;
    }

    private static final int count(String str, int i, int i2, char c) {
        int i3 = 0;
        while (true) {
            int i4 = i + i3;
            if (i4 >= i2 || str.charAt(i4) != c) {
                break;
            }
            i3++;
        }
        return i3;
    }

    private static final int indexOfColonInHostPort(String str, int i, int i2) {
        boolean z = false;
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt == '[') {
                z = true;
            } else if (charAt == ']') {
                z = false;
            } else if (charAt == ':' && !z) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private static final boolean isLetter(char c) {
        char lowerCase = Character.toLowerCase(c);
        return 'a' <= lowerCase && lowerCase < '{';
    }
}
