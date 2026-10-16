package com.sourcepoint.cmplibrary.exception;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: Logger.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\bf\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eJ \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\"\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0014\u0010\u000e\u001a\u00020\u00032\n\u0010\r\u001a\u00060\u000fj\u0002`\u0010H&J(\u0010\u0011\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\"\u0010\u0015\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J*\u0010\u0016\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H&J(\u0010\u0018\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H&J(\u0010\u001a\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H&J\u0018\u0010\u001c\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\"\u0010\u001d\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\u001f"}, d2 = {"Lcom/sourcepoint/cmplibrary/exception/Logger;", "", "clientEvent", "", "event", "", NotificationCompat.CATEGORY_MESSAGE, "content", "computation", "tag", "json", "Lorg/json/JSONObject;", "d", "e", "error", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "flm", "url", "type", "i", "nativeMessageAction", "pm", "params", "req", "body", "res", "status", "v", "webAppAction", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface Logger {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    void clientEvent(String event, String msg, String content);

    void computation(String tag, String msg);

    void computation(String tag, String msg, JSONObject json);

    void d(String tag, String msg);

    void e(String tag, String msg);

    void error(RuntimeException e);

    void flm(String tag, String url, String type, JSONObject json);

    void i(String tag, String msg);

    void nativeMessageAction(String tag, String msg, JSONObject json);

    void pm(String tag, String url, String type, String params);

    void req(String tag, String url, String type, String body);

    void res(String tag, String msg, String status, String body);

    void v(String tag, String msg);

    void webAppAction(String tag, String msg, JSONObject json);

    /* compiled from: Logger.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sourcepoint/cmplibrary/exception/Logger$Companion;", "", "()V", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
