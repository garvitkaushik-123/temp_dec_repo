package com.unity3d.services.core.network.mapper;

import com.google.firebase.sessions.settings.RemoteSettings;
import com.unity3d.ads.gatewayclient.CommonGatewayClient;
import com.unity3d.services.core.network.model.HttpRequest;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/* compiled from: HttpRequestToOkHttpRequest.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002\u001a\u0012\u0010\u0004\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0002\u001a\n\u0010\b\u001a\u00020\t*\u00020\u0007\u001a\n\u0010\n\u001a\u00020\t*\u00020\u0007¨\u0006\u000b"}, d2 = {"generateOkHttpBody", "Lokhttp3/RequestBody;", "body", "", "generateOkHttpProtobufBody", "generateOkHttpHeaders", "Lokhttp3/Headers;", "Lcom/unity3d/services/core/network/model/HttpRequest;", "toOkHttpProtoRequest", "Lokhttp3/Request;", "toOkHttpRequest", "unity-ads_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class HttpRequestToOkHttpRequestKt {
    private static final RequestBody generateOkHttpBody(Object obj) {
        if (obj instanceof byte[]) {
            RequestBody create = RequestBody.create(MediaType.parse("text/plain;charset=utf-8"), (byte[]) obj);
            Intrinsics.checkNotNullExpressionValue(create, "create(MediaType.parse(\"…in;charset=utf-8\"), body)");
            return create;
        }
        if (obj instanceof String) {
            RequestBody create2 = RequestBody.create(MediaType.parse("text/plain;charset=utf-8"), (String) obj);
            Intrinsics.checkNotNullExpressionValue(create2, "create(MediaType.parse(\"…in;charset=utf-8\"), body)");
            return create2;
        }
        RequestBody create3 = RequestBody.create(MediaType.parse("text/plain;charset=utf-8"), "");
        Intrinsics.checkNotNullExpressionValue(create3, "create(MediaType.parse(\"…lain;charset=utf-8\"), \"\")");
        return create3;
    }

    private static final RequestBody generateOkHttpProtobufBody(Object obj) {
        if (obj instanceof byte[]) {
            RequestBody create = RequestBody.create(MediaType.parse(CommonGatewayClient.HEADER_PROTOBUF), (byte[]) obj);
            Intrinsics.checkNotNullExpressionValue(create, "create(MediaType.parse(\"…ation/x-protobuf\"), body)");
            return create;
        }
        if (obj instanceof String) {
            RequestBody create2 = RequestBody.create(MediaType.parse(CommonGatewayClient.HEADER_PROTOBUF), (String) obj);
            Intrinsics.checkNotNullExpressionValue(create2, "create(MediaType.parse(\"…ation/x-protobuf\"), body)");
            return create2;
        }
        RequestBody create3 = RequestBody.create(MediaType.parse(CommonGatewayClient.HEADER_PROTOBUF), "");
        Intrinsics.checkNotNullExpressionValue(create3, "create(MediaType.parse(\"…ication/x-protobuf\"), \"\")");
        return create3;
    }

    private static final Headers generateOkHttpHeaders(HttpRequest httpRequest) {
        Headers.Builder builder = new Headers.Builder();
        for (Map.Entry<String, List<String>> entry : httpRequest.getHeaders().entrySet()) {
            builder.add(entry.getKey(), CollectionsKt.joinToString$default(entry.getValue(), ",", null, null, 0, null, null, 62, null));
        }
        Headers build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n    .also { he…ng(\",\")) } }\n    .build()");
        return build;
    }

    public static final Request toOkHttpRequest(HttpRequest httpRequest) {
        Intrinsics.checkNotNullParameter(httpRequest, "<this>");
        Request.Builder url = new Request.Builder().url(StringsKt.removeSuffix(StringsKt.trim(httpRequest.getBaseURL(), '/') + '/' + StringsKt.trim(httpRequest.getPath(), '/'), (CharSequence) RemoteSettings.FORWARD_SLASH_STRING));
        String requestType = httpRequest.getMethod().toString();
        Object body = httpRequest.getBody();
        Request build = url.method(requestType, body != null ? generateOkHttpBody(body) : null).headers(generateOkHttpHeaders(httpRequest)).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n    .url(\"${ba…tpHeaders())\n    .build()");
        return build;
    }

    public static final Request toOkHttpProtoRequest(HttpRequest httpRequest) {
        Intrinsics.checkNotNullParameter(httpRequest, "<this>");
        Request.Builder url = new Request.Builder().url(StringsKt.removeSuffix(StringsKt.trim(httpRequest.getBaseURL(), '/') + '/' + StringsKt.trim(httpRequest.getPath(), '/'), (CharSequence) RemoteSettings.FORWARD_SLASH_STRING));
        String requestType = httpRequest.getMethod().toString();
        Object body = httpRequest.getBody();
        Request build = url.method(requestType, body != null ? generateOkHttpProtobufBody(body) : null).headers(generateOkHttpHeaders(httpRequest)).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n    .url(\"${ba…tpHeaders())\n    .build()");
        return build;
    }
}
