package io.ktor.http;

import com.ironsource.D5;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import io.bidmachine.unified.UnifiedMediationParams;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: HttpMessageProperties.kt */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003\u001a\u0012\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006*\u00020\u0003\u001a\u0012\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006*\u00020\u0007\u001a\u001f\u0010\u0004\u001a\u0004\u0018\u00010\b*\u00020\u00072\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0007¢\u0006\u0002\u0010\t\u001a\u0011\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\u0003¢\u0006\u0002\u0010\f\u001a\u0011\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\u0007¢\u0006\u0002\u0010\r\u001a\u0014\u0010\n\u001a\u00020\b*\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0007\u001a\f\u0010\u0010\u001a\u0004\u0018\u00010\u0011*\u00020\u0003\u001a\f\u0010\u0010\u001a\u0004\u0018\u00010\u0011*\u00020\u0007\u001a\u0012\u0010\u0010\u001a\u00020\b*\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011\u001a\u0010\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0001*\u00020\u0007\u001a\f\u0010\u0015\u001a\u0004\u0018\u00010\u0016*\u00020\u0003\u001a\f\u0010\u0015\u001a\u0004\u0018\u00010\u0016*\u00020\u0007\u001a\u0012\u0010\u0017\u001a\u00020\b*\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0016\u001a\u0012\u0010\u0019\u001a\u00020\b*\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u000f\u001a\u0010\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00140\u0001*\u00020\u0003\u001a\u0012\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00160\u0001*\u00020\u0016H\u0000\u001a\u0012\u0010\u001d\u001a\u00020\b*\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0016\u001a\u0012\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0001*\u00020\u0003\u001a\u0012\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0001*\u00020\u0007¨\u0006 "}, d2 = {UnifiedMediationParams.KEY_CACHE_CONTROL, "", "Lio/ktor/http/HeaderValue;", "Lio/ktor/http/HttpMessage;", "charset", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "Lio/ktor/http/HttpMessageBuilder;", "", "(Lio/ktor/http/HttpMessageBuilder;Ljava/nio/charset/Charset;)Lkotlin/Unit;", "contentLength", "", "(Lio/ktor/http/HttpMessage;)Ljava/lang/Long;", "(Lio/ktor/http/HttpMessageBuilder;)Ljava/lang/Long;", "length", "", "contentType", "Lio/ktor/http/ContentType;", "type", "cookies", "Lio/ktor/http/Cookie;", DownloadModel.ETAG, "", "ifNoneMatch", "value", "maxAge", "seconds", "setCookie", "splitSetCookieHeader", "userAgent", "content", "vary", "ktor-http"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class HttpMessagePropertiesKt {
    public static final void contentType(HttpMessageBuilder httpMessageBuilder, ContentType type) {
        Intrinsics.checkNotNullParameter(httpMessageBuilder, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        httpMessageBuilder.getHeaders().set(HttpHeaders.INSTANCE.getContentType(), type.toString());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Content-Length is controlled by underlying engine. Don't specify it explicitly.")
    public static final void contentLength(HttpMessageBuilder httpMessageBuilder, int i) {
        Intrinsics.checkNotNullParameter(httpMessageBuilder, "<this>");
        httpMessageBuilder.getHeaders().set(HttpHeaders.INSTANCE.getContentLength(), String.valueOf(i));
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use content with particular content type and charset instead")
    public static final Unit charset(HttpMessageBuilder httpMessageBuilder, Charset charset) {
        Intrinsics.checkNotNullParameter(httpMessageBuilder, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        ContentType contentType = contentType(httpMessageBuilder);
        if (contentType == null) {
            return null;
        }
        contentType(httpMessageBuilder, ContentTypesKt.withCharset(contentType, charset));
        return Unit.INSTANCE;
    }

    public static final void maxAge(HttpMessageBuilder httpMessageBuilder, int i) {
        Intrinsics.checkNotNullParameter(httpMessageBuilder, "<this>");
        httpMessageBuilder.getHeaders().append(HttpHeaders.INSTANCE.getCacheControl(), "max-age=" + i);
    }

    public static final void ifNoneMatch(HttpMessageBuilder httpMessageBuilder, String value) {
        Intrinsics.checkNotNullParameter(httpMessageBuilder, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        httpMessageBuilder.getHeaders().set(HttpHeaders.INSTANCE.getIfNoneMatch(), value);
    }

    public static final void userAgent(HttpMessageBuilder httpMessageBuilder, String content) {
        Intrinsics.checkNotNullParameter(httpMessageBuilder, "<this>");
        Intrinsics.checkNotNullParameter(content, "content");
        httpMessageBuilder.getHeaders().set(HttpHeaders.INSTANCE.getUserAgent(), content);
    }

    public static final ContentType contentType(HttpMessageBuilder httpMessageBuilder) {
        Intrinsics.checkNotNullParameter(httpMessageBuilder, "<this>");
        String str = httpMessageBuilder.getHeaders().get(HttpHeaders.INSTANCE.getContentType());
        if (str != null) {
            return ContentType.INSTANCE.parse(str);
        }
        return null;
    }

    public static final Charset charset(HttpMessageBuilder httpMessageBuilder) {
        Intrinsics.checkNotNullParameter(httpMessageBuilder, "<this>");
        ContentType contentType = contentType(httpMessageBuilder);
        if (contentType != null) {
            return ContentTypesKt.charset(contentType);
        }
        return null;
    }

    public static final String etag(HttpMessageBuilder httpMessageBuilder) {
        Intrinsics.checkNotNullParameter(httpMessageBuilder, "<this>");
        return httpMessageBuilder.getHeaders().get(HttpHeaders.INSTANCE.getETag());
    }

    public static final List<String> vary(HttpMessageBuilder httpMessageBuilder) {
        Intrinsics.checkNotNullParameter(httpMessageBuilder, "<this>");
        List<String> all = httpMessageBuilder.getHeaders().getAll(HttpHeaders.INSTANCE.getVary());
        if (all == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = all.iterator();
        while (it.hasNext()) {
            List split$default = StringsKt.split$default((CharSequence) it.next(), new String[]{","}, false, 0, 6, (Object) null);
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
            Iterator it2 = split$default.iterator();
            while (it2.hasNext()) {
                arrayList2.add(StringsKt.trim((CharSequence) it2.next()).toString());
            }
            CollectionsKt.addAll(arrayList, arrayList2);
        }
        return arrayList;
    }

    public static final Long contentLength(HttpMessageBuilder httpMessageBuilder) {
        Intrinsics.checkNotNullParameter(httpMessageBuilder, "<this>");
        String str = httpMessageBuilder.getHeaders().get(HttpHeaders.INSTANCE.getContentLength());
        if (str != null) {
            return Long.valueOf(Long.parseLong(str));
        }
        return null;
    }

    public static final ContentType contentType(HttpMessage httpMessage) {
        Intrinsics.checkNotNullParameter(httpMessage, "<this>");
        String str = httpMessage.getHeaders().get(HttpHeaders.INSTANCE.getContentType());
        if (str != null) {
            return ContentType.INSTANCE.parse(str);
        }
        return null;
    }

    public static final Charset charset(HttpMessage httpMessage) {
        Intrinsics.checkNotNullParameter(httpMessage, "<this>");
        ContentType contentType = contentType(httpMessage);
        if (contentType != null) {
            return ContentTypesKt.charset(contentType);
        }
        return null;
    }

    public static final String etag(HttpMessage httpMessage) {
        Intrinsics.checkNotNullParameter(httpMessage, "<this>");
        return httpMessage.getHeaders().get(HttpHeaders.INSTANCE.getETag());
    }

    public static final List<String> vary(HttpMessage httpMessage) {
        Intrinsics.checkNotNullParameter(httpMessage, "<this>");
        List<String> all = httpMessage.getHeaders().getAll(HttpHeaders.INSTANCE.getVary());
        if (all == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = all.iterator();
        while (it.hasNext()) {
            List split$default = StringsKt.split$default((CharSequence) it.next(), new String[]{","}, false, 0, 6, (Object) null);
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
            Iterator it2 = split$default.iterator();
            while (it2.hasNext()) {
                arrayList2.add(StringsKt.trim((CharSequence) it2.next()).toString());
            }
            CollectionsKt.addAll(arrayList, arrayList2);
        }
        return arrayList;
    }

    public static final Long contentLength(HttpMessage httpMessage) {
        Intrinsics.checkNotNullParameter(httpMessage, "<this>");
        String str = httpMessage.getHeaders().get(HttpHeaders.INSTANCE.getContentLength());
        if (str != null) {
            return Long.valueOf(Long.parseLong(str));
        }
        return null;
    }

    public static final List<Cookie> setCookie(HttpMessage httpMessage) {
        Intrinsics.checkNotNullParameter(httpMessage, "<this>");
        List<String> all = httpMessage.getHeaders().getAll(HttpHeaders.INSTANCE.getSetCookie());
        if (all == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = all.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, splitSetCookieHeader((String) it.next()));
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList3.add(CookieKt.parseServerSetCookieHeader((String) it2.next()));
        }
        return arrayList3;
    }

    public static final List<Cookie> cookies(HttpMessageBuilder httpMessageBuilder) {
        Intrinsics.checkNotNullParameter(httpMessageBuilder, "<this>");
        List<String> all = httpMessageBuilder.getHeaders().getAll(HttpHeaders.INSTANCE.getSetCookie());
        if (all == null) {
            return CollectionsKt.emptyList();
        }
        List<String> list = all;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(CookieKt.parseServerSetCookieHeader((String) it.next()));
        }
        return arrayList;
    }

    public static final List<HeaderValue> cacheControl(HttpMessage httpMessage) {
        List<HeaderValue> parseHeaderValue;
        Intrinsics.checkNotNullParameter(httpMessage, "<this>");
        String str = httpMessage.getHeaders().get(HttpHeaders.INSTANCE.getCacheControl());
        return (str == null || (parseHeaderValue = HttpHeaderValueParserKt.parseHeaderValue(str)) == null) ? CollectionsKt.emptyList() : parseHeaderValue;
    }

    public static final List<String> splitSetCookieHeader(String str) {
        int i;
        Intrinsics.checkNotNullParameter(str, "<this>");
        String str2 = str;
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str2, AbstractJsonLexerKt.COMMA, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return CollectionsKt.listOf(str);
        }
        ArrayList arrayList = new ArrayList();
        int indexOf$default2 = StringsKt.indexOf$default((CharSequence) str2, D5.T, indexOf$default, false, 4, (Object) null);
        int indexOf$default3 = StringsKt.indexOf$default((CharSequence) str2, ';', indexOf$default, false, 4, (Object) null);
        int i2 = indexOf$default2;
        int i3 = 0;
        while (i3 < str.length() && indexOf$default > 0) {
            if (i2 < indexOf$default) {
                i2 = StringsKt.indexOf$default((CharSequence) str2, D5.T, indexOf$default, false, 4, (Object) null);
            }
            int i4 = indexOf$default;
            int i5 = i2;
            int indexOf$default4 = StringsKt.indexOf$default((CharSequence) str2, AbstractJsonLexerKt.COMMA, i4 + 1, false, 4, (Object) null);
            while (true) {
                i = i4;
                i4 = indexOf$default4;
                if (i4 < 0 || i4 >= i5) {
                    break;
                }
                indexOf$default4 = StringsKt.indexOf$default((CharSequence) str2, AbstractJsonLexerKt.COMMA, i4 + 1, false, 4, (Object) null);
            }
            if (indexOf$default3 < i) {
                indexOf$default3 = StringsKt.indexOf$default((CharSequence) str2, ';', i, false, 4, (Object) null);
            }
            if (i5 < 0) {
                String substring = str.substring(i3);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                arrayList.add(substring);
                return arrayList;
            }
            if (indexOf$default3 == -1 || indexOf$default3 > i5) {
                String substring2 = str.substring(i3, i);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                arrayList.add(substring2);
                i3 = i + 1;
            }
            indexOf$default = i4;
            i2 = i5;
        }
        if (i3 < str.length()) {
            String substring3 = str.substring(i3);
            Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String).substring(startIndex)");
            arrayList.add(substring3);
        }
        return arrayList;
    }
}
