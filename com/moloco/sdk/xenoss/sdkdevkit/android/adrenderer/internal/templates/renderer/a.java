package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer;

import android.webkit.JavascriptInterface;
import com.moloco.sdk.BuildConfig;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class a {
    public static final C0501a b = new C0501a(null);
    public static final int c = 8;
    public static final String d = "TemplateJavascript";

    /* renamed from: a, reason: collision with root package name */
    public final d f5958a;

    /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.a$a, reason: collision with other inner class name */
    public static final class C0501a {
        public /* synthetic */ C0501a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public C0501a() {
        }
    }

    public a(d eventHandler) {
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        this.f5958a = eventHandler;
    }

    @JavascriptInterface
    public final void log(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, d, message, null, false, 12, null);
    }

    @JavascriptInterface
    public final void onEvent(String event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.f5958a.a(event);
    }

    @JavascriptInterface
    public final String sdkVersion() {
        return BuildConfig.SDK_VERSION_NAME;
    }
}
