package com.sourcepoint.cmplibrary.exception;

import androidx.core.app.NotificationCompat;
import com.example.cmplibrary.BuildConfig;
import com.google.common.net.HttpHeaders;
import com.ironsource.D5;
import com.sourcepoint.cmplibrary.util.OkHttpCallbackExtensionKt;
import com.sourcepoint.cmplibrary.util.OkHttpCallbackImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.json.JSONObject;

/* compiled from: LoggerImpl.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\"\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u0018\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u0014\u0010\u0019\u001a\u00020\u00102\n\u0010\u0018\u001a\u00060\u001aj\u0002`\u001bH\u0016J(\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\"\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J*\u0010 \u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010\u0007H\u0016J(\u0010\"\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0016J(\u0010$\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0016J\u0018\u0010&\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\"\u0010'\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006("}, d2 = {"Lcom/sourcepoint/cmplibrary/exception/LoggerImpl;", "Lcom/sourcepoint/cmplibrary/exception/Logger;", "networkClient", "Lokhttp3/OkHttpClient;", "errorMessageManager", "Lcom/sourcepoint/cmplibrary/exception/ErrorMessageManager;", "url", "", "(Lokhttp3/OkHttpClient;Lcom/sourcepoint/cmplibrary/exception/ErrorMessageManager;Ljava/lang/String;)V", "getErrorMessageManager", "()Lcom/sourcepoint/cmplibrary/exception/ErrorMessageManager;", "getNetworkClient", "()Lokhttp3/OkHttpClient;", "getUrl", "()Ljava/lang/String;", "clientEvent", "", "tag", NotificationCompat.CATEGORY_MESSAGE, "content", "computation", "json", "Lorg/json/JSONObject;", "d", "e", "error", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "flm", "type", "i", "nativeMessageAction", "pm", "pmId", "req", "body", "res", "status", "v", "webAppAction", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
final class LoggerImpl implements Logger {
    private final ErrorMessageManager errorMessageManager;
    private final OkHttpClient networkClient;
    private final String url;

    @Override // com.sourcepoint.cmplibrary.exception.Logger
    public void clientEvent(String tag, String msg, String content) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(content, "content");
    }

    @Override // com.sourcepoint.cmplibrary.exception.Logger
    public void computation(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
    }

    @Override // com.sourcepoint.cmplibrary.exception.Logger
    public void computation(String tag, String msg, JSONObject json) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
    }

    @Override // com.sourcepoint.cmplibrary.exception.Logger
    public void d(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
    }

    @Override // com.sourcepoint.cmplibrary.exception.Logger
    public void e(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
    }

    @Override // com.sourcepoint.cmplibrary.exception.Logger
    public void flm(String tag, String url, String type, JSONObject json) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(json, "json");
    }

    @Override // com.sourcepoint.cmplibrary.exception.Logger
    public void i(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
    }

    @Override // com.sourcepoint.cmplibrary.exception.Logger
    public void nativeMessageAction(String tag, String msg, JSONObject json) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
    }

    @Override // com.sourcepoint.cmplibrary.exception.Logger
    public void pm(String tag, String url, String type, String pmId) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(type, "type");
    }

    @Override // com.sourcepoint.cmplibrary.exception.Logger
    public void req(String tag, String url, String type, String body) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(body, "body");
    }

    @Override // com.sourcepoint.cmplibrary.exception.Logger
    public void res(String tag, String msg, String status, String body) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(body, "body");
    }

    @Override // com.sourcepoint.cmplibrary.exception.Logger
    public void v(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
    }

    @Override // com.sourcepoint.cmplibrary.exception.Logger
    public void webAppAction(String tag, String msg, JSONObject json) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
    }

    public LoggerImpl(OkHttpClient networkClient, ErrorMessageManager errorMessageManager, String url) {
        Intrinsics.checkNotNullParameter(networkClient, "networkClient");
        Intrinsics.checkNotNullParameter(errorMessageManager, "errorMessageManager");
        Intrinsics.checkNotNullParameter(url, "url");
        this.networkClient = networkClient;
        this.errorMessageManager = errorMessageManager;
        this.url = url;
    }

    public final OkHttpClient getNetworkClient() {
        return this.networkClient;
    }

    public final ErrorMessageManager getErrorMessageManager() {
        return this.errorMessageManager;
    }

    public final String getUrl() {
        return this.url;
    }

    @Override // com.sourcepoint.cmplibrary.exception.Logger
    public void error(RuntimeException e) {
        String str;
        String type;
        Intrinsics.checkNotNullParameter(e, "e");
        MediaType parse = MediaType.INSTANCE.parse(D5.L);
        RequestBody create = RequestBody.INSTANCE.create(parse, this.errorMessageManager.build(e));
        HttpUrl.Builder newBuilder = HttpUrl.INSTANCE.get(this.url).newBuilder();
        newBuilder.addQueryParameter("scriptType", "android");
        newBuilder.addQueryParameter("scriptVersion", BuildConfig.VERSION_NAME);
        Request.Builder post = new Request.Builder().url(newBuilder.build()).post(create);
        String str2 = "";
        if (parse == null || (str = parse.type()) == null) {
            str = "";
        }
        Request.Builder header = post.header(HttpHeaders.ACCEPT, str);
        if (parse != null && (type = parse.type()) != null) {
            str2 = type;
        }
        OkHttpCallbackExtensionKt.enqueue(this.networkClient.newCall(header.header("Content-Type", str2).build()), new Function1<OkHttpCallbackImpl, Unit>() { // from class: com.sourcepoint.cmplibrary.exception.LoggerImpl$error$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(OkHttpCallbackImpl enqueue) {
                Intrinsics.checkNotNullParameter(enqueue, "$this$enqueue");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OkHttpCallbackImpl okHttpCallbackImpl) {
                invoke2(okHttpCallbackImpl);
                return Unit.INSTANCE;
            }
        });
    }
}
