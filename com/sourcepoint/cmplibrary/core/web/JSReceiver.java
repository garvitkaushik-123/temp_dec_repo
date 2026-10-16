package com.sourcepoint.cmplibrary.core.web;

import android.webkit.JavascriptInterface;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;

/* compiled from: JSReceiver.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b`\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eJ\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H'J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H'J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H'J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH'J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0005H'¨\u0006\u000f"}, d2 = {"Lcom/sourcepoint/cmplibrary/core/web/JSReceiver;", "", "log", "", NotificationCompat.CATEGORY_MESSAGE, "", "tag", "onAction", "actionData", "onConsentUIReady", "isFromPM", "", "onError", "errorMessage", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface JSReceiver {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @JavascriptInterface
    void log(String msg);

    @JavascriptInterface
    void log(String tag, String msg);

    @JavascriptInterface
    void onAction(String actionData);

    @JavascriptInterface
    void onConsentUIReady(boolean isFromPM);

    @JavascriptInterface
    void onError(String errorMessage);

    /* compiled from: JSReceiver.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sourcepoint/cmplibrary/core/web/JSReceiver$Companion;", "", "()V", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
