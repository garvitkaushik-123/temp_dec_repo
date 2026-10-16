package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.creative.mraid;

import android.content.Context;
import android.webkit.JavascriptInterface;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.p;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class c {
    public static final a c = new a(null);
    public static final int d = 8;
    public static final String e = "MraidJsEventReceiver";

    /* renamed from: a, reason: collision with root package name */
    public final Context f5955a;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.creative.mraid.a b;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    public c(Context context, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.creative.mraid.a mraidCommunicationHub) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mraidCommunicationHub, "mraidCommunicationHub");
        this.f5955a = context;
        this.b = mraidCommunicationHub;
    }

    @JavascriptInterface
    public final void close() {
        this.b.a();
    }

    @JavascriptInterface
    public final void expand(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
    }

    @JavascriptInterface
    public final void open(String jsonParams) {
        Intrinsics.checkNotNullParameter(jsonParams, "jsonParams");
        String string = new JSONObject(jsonParams).getString("url");
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.creative.mraid.a aVar = this.b;
        Intrinsics.checkNotNull(string);
        aVar.a(string);
    }

    @JavascriptInterface
    public final void resize(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
    }

    @JavascriptInterface
    public final void setOrientationProperties(String jsonParams) {
        Intrinsics.checkNotNullParameter(jsonParams, "jsonParams");
        try {
            JSONObject jSONObject = new JSONObject(jsonParams);
            boolean optBoolean = jSONObject.optBoolean("allowOrientationChange", true);
            String optString = jSONObject.optString("forceOrientation", "none");
            MolocoLogger.debug$default(MolocoLogger.INSTANCE, e, "Orientation Set from JSON: " + optBoolean + ", " + optString, false, 4, null);
            p a2 = p.f5907a.a(optString);
            if (a2 != null) {
                this.b.a(optBoolean, a2);
            }
        } catch (Exception e2) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, e, "Error parsing orientation properties JSON", e2, false, 8, null);
        }
    }
}
