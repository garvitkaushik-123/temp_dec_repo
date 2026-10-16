package io.ktor.client.plugins.cache;

import com.ironsource.C3040d4;
import com.ironsource.C3337ue;
import com.vungle.ads.internal.ui.AdActivity;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.http.DateUtilsKt;
import io.ktor.http.HeaderValue;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaderValueParserKt;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.util.date.DateJvmKt;
import io.ktor.util.date.DateKt;
import io.ktor.util.date.GMTDate;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.StringsKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpCacheEntry.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\u001a!\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0000\u001a$\u0010\t\u001a\u00020\n*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u0010H\u0000\u001a\u0018\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u0012*\u00020\u0005H\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"HttpCacheEntry", "Lio/ktor/client/plugins/cache/HttpCacheEntry;", "isShared", "", C3337ue.n, "Lio/ktor/client/statement/HttpResponse;", "(ZLio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldValidate", "Lio/ktor/client/plugins/cache/ValidateStatus;", "cacheExpires", "Lio/ktor/util/date/GMTDate;", "responseHeaders", "Lio/ktor/http/Headers;", AdActivity.REQUEST_KEY_EXTRA, "Lio/ktor/client/request/HttpRequestBuilder;", "fallback", "Lkotlin/Function0;", "varyKeys", "", "", "ktor-client-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class HttpCacheEntryKt {
    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object HttpCacheEntry(boolean z, HttpResponse httpResponse, Continuation<? super HttpCacheEntry> continuation) {
        HttpCacheEntryKt$HttpCacheEntry$1 httpCacheEntryKt$HttpCacheEntry$1;
        int i;
        if (continuation instanceof HttpCacheEntryKt$HttpCacheEntry$1) {
            httpCacheEntryKt$HttpCacheEntry$1 = (HttpCacheEntryKt$HttpCacheEntry$1) continuation;
            if ((httpCacheEntryKt$HttpCacheEntry$1.label & Integer.MIN_VALUE) != 0) {
                httpCacheEntryKt$HttpCacheEntry$1.label -= Integer.MIN_VALUE;
                HttpCacheEntryKt$HttpCacheEntry$1 httpCacheEntryKt$HttpCacheEntry$12 = httpCacheEntryKt$HttpCacheEntry$1;
                Object obj = httpCacheEntryKt$HttpCacheEntry$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = httpCacheEntryKt$HttpCacheEntry$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    ByteReadChannel content = httpResponse.getContent();
                    httpCacheEntryKt$HttpCacheEntry$12.L$0 = httpResponse;
                    httpCacheEntryKt$HttpCacheEntry$12.Z$0 = z;
                    httpCacheEntryKt$HttpCacheEntry$12.label = 1;
                    obj = ByteReadChannel.DefaultImpls.readRemaining$default(content, 0L, httpCacheEntryKt$HttpCacheEntry$12, 1, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    z = httpCacheEntryKt$HttpCacheEntry$12.Z$0;
                    httpResponse = (HttpResponse) httpCacheEntryKt$HttpCacheEntry$12.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                byte[] readBytes$default = StringsKt.readBytes$default((ByteReadPacket) obj, 0, 1, null);
                HttpResponseKt.complete(httpResponse);
                return new HttpCacheEntry(cacheExpires$default(httpResponse, z, null, 2, null), varyKeys(httpResponse), httpResponse, readBytes$default);
            }
        }
        httpCacheEntryKt$HttpCacheEntry$1 = new HttpCacheEntryKt$HttpCacheEntry$1(continuation);
        HttpCacheEntryKt$HttpCacheEntry$1 httpCacheEntryKt$HttpCacheEntry$122 = httpCacheEntryKt$HttpCacheEntry$1;
        Object obj2 = httpCacheEntryKt$HttpCacheEntry$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = httpCacheEntryKt$HttpCacheEntry$122.label;
        if (i != 0) {
        }
        byte[] readBytes$default2 = StringsKt.readBytes$default((ByteReadPacket) obj2, 0, 1, null);
        HttpResponseKt.complete(httpResponse);
        return new HttpCacheEntry(cacheExpires$default(httpResponse, z, null, 2, null), varyKeys(httpResponse), httpResponse, readBytes$default2);
    }

    public static final Map<String, String> varyKeys(HttpResponse httpResponse) {
        Intrinsics.checkNotNullParameter(httpResponse, "<this>");
        List<String> vary = HttpMessagePropertiesKt.vary(httpResponse);
        if (vary == null) {
            return MapsKt.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Headers headers = httpResponse.getCall().getRequest().getHeaders();
        for (String str : vary) {
            String str2 = headers.get(str);
            if (str2 == null) {
                str2 = "";
            }
            linkedHashMap.put(str, str2);
        }
        return linkedHashMap;
    }

    public static /* synthetic */ GMTDate cacheExpires$default(HttpResponse httpResponse, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = new Function0<GMTDate>() { // from class: io.ktor.client.plugins.cache.HttpCacheEntryKt$cacheExpires$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final GMTDate invoke() {
                    return DateJvmKt.GMTDate$default(null, 1, null);
                }
            };
        }
        return cacheExpires(httpResponse, z, function0);
    }

    public static final GMTDate cacheExpires(HttpResponse httpResponse, boolean z, Function0<GMTDate> fallback) {
        String str;
        Object obj;
        String value;
        List split$default;
        String str2;
        Intrinsics.checkNotNullParameter(httpResponse, "<this>");
        Intrinsics.checkNotNullParameter(fallback, "fallback");
        List<HeaderValue> cacheControl = HttpMessagePropertiesKt.cacheControl(httpResponse);
        Long l = null;
        if (z) {
            List<HeaderValue> list = cacheControl;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    String value2 = ((HeaderValue) it.next()).getValue();
                    str = io.ktor.client.utils.CacheControl.S_MAX_AGE;
                    if (kotlin.text.StringsKt.startsWith$default(value2, io.ktor.client.utils.CacheControl.S_MAX_AGE, false, 2, (Object) null)) {
                        break;
                    }
                }
            }
        }
        str = io.ktor.client.utils.CacheControl.MAX_AGE;
        Iterator<T> it2 = cacheControl.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            if (kotlin.text.StringsKt.startsWith$default(((HeaderValue) obj).getValue(), str, false, 2, (Object) null)) {
                break;
            }
        }
        HeaderValue headerValue = (HeaderValue) obj;
        if (headerValue != null && (value = headerValue.getValue()) != null && (split$default = kotlin.text.StringsKt.split$default((CharSequence) value, new String[]{C3040d4.i.b}, false, 0, 6, (Object) null)) != null && (str2 = (String) split$default.get(1)) != null) {
            l = kotlin.text.StringsKt.toLongOrNull(str2);
        }
        if (l != null) {
            return DateKt.plus(httpResponse.getRequestTime(), l.longValue() * 1000);
        }
        String str3 = httpResponse.getHeaders().get(HttpHeaders.INSTANCE.getExpires());
        if (str3 != null) {
            if (Intrinsics.areEqual(str3, "0") || kotlin.text.StringsKt.isBlank(str3)) {
                return fallback.invoke();
            }
            try {
                return DateUtilsKt.fromHttpToGmtDate(str3);
            } catch (Throwable unused) {
                return fallback.invoke();
            }
        }
        return fallback.invoke();
    }

    public static final ValidateStatus shouldValidate(GMTDate cacheExpires, Headers responseHeaders, HttpRequestBuilder request) {
        int i;
        Object obj;
        Integer num;
        String value;
        Integer intOrNull;
        String value2;
        List split$default;
        String str;
        Intrinsics.checkNotNullParameter(cacheExpires, "cacheExpires");
        Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
        Intrinsics.checkNotNullParameter(request, "request");
        HeadersBuilder headers = request.getHeaders();
        List<String> all = responseHeaders.getAll(HttpHeaders.INSTANCE.getCacheControl());
        Object obj2 = null;
        List<HeaderValue> parseHeaderValue = HttpHeaderValueParserKt.parseHeaderValue(all != null ? CollectionsKt.joinToString$default(all, ",", null, null, 0, null, null, 62, null) : null);
        List<String> all2 = headers.getAll(HttpHeaders.INSTANCE.getCacheControl());
        List<HeaderValue> parseHeaderValue2 = HttpHeaderValueParserKt.parseHeaderValue(all2 != null ? CollectionsKt.joinToString$default(all2, ",", null, null, 0, null, null, 62, null) : null);
        if (parseHeaderValue2.contains(CacheControl.INSTANCE.getNO_CACHE$ktor_client_core())) {
            HttpCacheKt.getLOGGER().trace("\"no-cache\" is set for " + request.getUrl() + ", should validate cached response");
            return ValidateStatus.ShouldValidate;
        }
        List<HeaderValue> list = parseHeaderValue2;
        Iterator<T> it = list.iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (kotlin.text.StringsKt.startsWith$default(((HeaderValue) obj).getValue(), "max-age=", false, 2, (Object) null)) {
                break;
            }
        }
        HeaderValue headerValue = (HeaderValue) obj;
        if (headerValue == null || (value2 = headerValue.getValue()) == null || (split$default = kotlin.text.StringsKt.split$default((CharSequence) value2, new String[]{C3040d4.i.b}, false, 0, 6, (Object) null)) == null || (str = (String) split$default.get(1)) == null) {
            num = null;
        } else {
            Integer intOrNull2 = kotlin.text.StringsKt.toIntOrNull(str);
            num = Integer.valueOf(intOrNull2 != null ? intOrNull2.intValue() : 0);
        }
        if (num != null && num.intValue() == 0) {
            HttpCacheKt.getLOGGER().trace("\"max-age\" is not set for " + request.getUrl() + ", should validate cached response");
            return ValidateStatus.ShouldValidate;
        }
        if (parseHeaderValue.contains(CacheControl.INSTANCE.getNO_CACHE$ktor_client_core())) {
            HttpCacheKt.getLOGGER().trace("\"no-cache\" is set for " + request.getUrl() + ", should validate cached response");
            return ValidateStatus.ShouldValidate;
        }
        long timestamp = cacheExpires.getTimestamp() - DateJvmKt.getTimeMillis();
        if (timestamp > 0) {
            HttpCacheKt.getLOGGER().trace("Cached response is valid for " + request.getUrl() + ", should not validate");
            return ValidateStatus.ShouldNotValidate;
        }
        if (parseHeaderValue.contains(CacheControl.INSTANCE.getMUST_REVALIDATE$ktor_client_core())) {
            HttpCacheKt.getLOGGER().trace("\"must-revalidate\" is set for " + request.getUrl() + ", should validate cached response");
            return ValidateStatus.ShouldValidate;
        }
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (kotlin.text.StringsKt.startsWith$default(((HeaderValue) next).getValue(), "max-stale=", false, 2, (Object) null)) {
                obj2 = next;
                break;
            }
        }
        HeaderValue headerValue2 = (HeaderValue) obj2;
        if (headerValue2 != null && (value = headerValue2.getValue()) != null) {
            String substring = value.substring(10);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            if (substring != null && (intOrNull = kotlin.text.StringsKt.toIntOrNull(substring)) != null) {
                i = intOrNull.intValue();
            }
        }
        if (timestamp + (i * 1000) > 0) {
            HttpCacheKt.getLOGGER().trace("Cached response is stale for " + request.getUrl() + " but less than max-stale, should warn");
            return ValidateStatus.ShouldWarn;
        }
        HttpCacheKt.getLOGGER().trace("Cached response is stale for " + request.getUrl() + ", should validate cached response");
        return ValidateStatus.ShouldValidate;
    }
}
