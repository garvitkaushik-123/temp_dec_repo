package com.inmobi.media;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.ironsource.C3040d4;
import com.ironsource.C3061e8;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.vungle.ads.internal.protos.Sdk;
import io.bidmachine.media3.common.PlaybackException;
import io.bidmachine.rendering.model.EventTaskParams;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Lazy;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.v6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2905v6 {

    /* renamed from: a, reason: collision with root package name */
    public final GestureDetectorOnGestureListenerC2634ec f2731a;
    public final int b;
    public InterfaceC2971z5 c;

    public C2905v6(int i, GestureDetectorOnGestureListenerC2634ec mRenderView) {
        Intrinsics.checkNotNullParameter(mRenderView, "mRenderView");
        this.f2731a = mRenderView;
        this.b = i;
    }

    public static final void b(C2905v6 this$0, String str, String str2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        M6.a(this$0.f2731a.getLandingPageHandler(), "open", str, str2, null, false, 24);
    }

    public static final void c(C2905v6 this$0, String str, String str2) {
        R6 r6;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            S6 s6 = this$0.f2731a.getLandingPageHandler().f;
            if (s6 != null) {
                String a2 = J6.a(str2);
                M6 landingPageHandler = this$0.f2731a.getLandingPageHandler();
                int i = landingPageHandler.h + 1;
                landingPageHandler.h = i;
                r6 = new R6(s6, a2, i, 8);
            } else {
                r6 = null;
            }
            if (r6 != null) {
                r6.g = "IN_NATIVE";
            }
            this$0.f2731a.getLandingPageHandler().d("openEmbedded", str, str2, r6);
        } catch (Exception e) {
            this$0.f2731a.a(str, "Unexpected error", "openEmbedded");
            AbstractC2680h7.a((byte) 1, "InMobi", "Failed to open URL; SDK encountered unexpected error");
            InterfaceC2971z5 interfaceC2971z5 = this$0.c;
            if (interfaceC2971z5 != null) {
                String str3 = AbstractC2921w6.f2741a;
                ((A5) interfaceC2971z5).b(str3, rf.a(e, H6.a(str3, "access$getTAG$p(...)", "SDK encountered unexpected error in handling openEmbedded() request from creative; ")));
            }
        }
    }

    public static final void d(C2905v6 this$0, String str, String str2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        M6.a(this$0.f2731a.getLandingPageHandler(), "openWithoutTracker", str, str2, null, true, 8);
    }

    public static final void e(C2905v6 this$0, String str, String str2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = this$0.f2731a;
            int length = str2.length() - 1;
            int i = 0;
            boolean z = false;
            while (i <= length) {
                boolean z2 = Intrinsics.compare((int) str2.charAt(!z ? i : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z2) {
                    i++;
                } else {
                    z = true;
                }
            }
            gestureDetectorOnGestureListenerC2634ec.b(str, str2.subSequence(i, length + 1).toString());
        } catch (Exception e) {
            this$0.f2731a.a(str, "Unexpected error", "playVideo");
            AbstractC2680h7.a((byte) 1, "InMobi", "Error playing video; SDK encountered an unexpected error");
            InterfaceC2971z5 interfaceC2971z5 = this$0.c;
            if (interfaceC2971z5 != null) {
                String str3 = AbstractC2921w6.f2741a;
                ((A5) interfaceC2971z5).b(str3, rf.a(e, H6.a(str3, "access$getTAG$p(...)", "SDK encountered unexpected error in handling playVideo() request from creative; ")));
            }
        }
    }

    public static final void f(C2905v6 this$0, String str, String str2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.f2731a.getSiblingWebviewManager().b(this$0.f2731a.getRoute().b, str, str2);
        } catch (Exception e) {
            this$0.f2731a.a(C3061e8.j, AbstractC2815pc.a(str, Sdk.SDKError.Reason.AD_HTML_FAILED_TO_LOAD_VALUE));
            InterfaceC2971z5 interfaceC2971z5 = this$0.c;
            if (interfaceC2971z5 != null) {
                String str3 = AbstractC2921w6.f2741a;
                ((A5) interfaceC2971z5).b(str3, rf.a(e, H6.a(str3, "access$getTAG$p(...)", "SDK encountered unexpected error in handling sendMessage() request from creative; ")));
            }
        }
    }

    public final GestureDetectorOnGestureListenerC2634ec a() {
        if (Intrinsics.areEqual(this.f2731a.getRoute().b, EventTaskParams.STATE_GROUP_DEFAULT)) {
            return this.f2731a;
        }
        tf webViewFactory = this.f2731a.getWebViewFactory();
        webViewFactory.getClass();
        Intrinsics.checkNotNullParameter(EventTaskParams.STATE_GROUP_DEFAULT, "id");
        return (GestureDetectorOnGestureListenerC2634ec) webViewFactory.b.get(EventTaskParams.STATE_GROUP_DEFAULT);
    }

    @JavascriptInterface
    public final void asyncPing(String str, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            ((A5) interfaceC2971z5).a(str2, I6.a(str2, "access$getTAG$p(...)", "asyncPing called: ", url));
        }
        if (!URLUtil.isValidUrl(url)) {
            this.f2731a.a(str, "Invalid url", "asyncPing");
            return;
        }
        try {
            N9 n9 = new N9(url, this.c);
            n9.x = false;
            n9.t = false;
            n9.u = false;
            n9.a(new C2900v1(new C2916w1(n9, new C2856s6(this))));
        } catch (Exception e) {
            this.f2731a.a(str, "Unexpected error", "asyncPing");
            InterfaceC2971z5 interfaceC2971z52 = this.c;
            if (interfaceC2971z52 != null) {
                String str3 = AbstractC2921w6.f2741a;
                ((A5) interfaceC2971z52).b(str3, rf.a(e, H6.a(str3, "access$getTAG$p(...)", "SDK encountered internal error in handling asyncPing() request from creative; ")));
            }
        }
    }

    @JavascriptInterface
    public final void cancelSaveContent(String str, String mediaId) {
        Intrinsics.checkNotNullParameter(mediaId, "mediaId");
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            ((A5) interfaceC2971z5).a(str2, I6.a(str2, "access$getTAG$p(...)", "cancelSaveContent called. mediaId:", mediaId));
        }
    }

    @JavascriptInterface
    public final void close(final String str) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str2, "close called");
        }
        final GestureDetectorOnGestureListenerC2634ec a2 = a();
        if (a2 == null) {
            InterfaceC2971z5 interfaceC2971z52 = this.c;
            if (interfaceC2971z52 != null) {
                String str3 = AbstractC2921w6.f2741a;
                Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
                ((A5) interfaceC2971z52).a(str3, "webview not present cannot be closed");
                return;
            }
            return;
        }
        if (a2.K0) {
            InterfaceC2971z5 interfaceC2971z53 = this.c;
            if (interfaceC2971z53 != null) {
                String str4 = AbstractC2921w6.f2741a;
                Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$p(...)");
                ((A5) interfaceC2971z53).b(str4, "close called on unloaded ad");
                return;
            }
            return;
        }
        int i = AbstractC2970z4.f2771a;
        ExecutorC2793o7 executorC2793o7 = (ExecutorC2793o7) AbstractC2970z4.d.getValue();
        Runnable runnable = new Runnable() { // from class: com.inmobi.media.v6$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                C2905v6.a(GestureDetectorOnGestureListenerC2634ec.this, this, str);
            }
        };
        executorC2793o7.getClass();
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        executorC2793o7.f2659a.post(runnable);
    }

    @JavascriptInterface
    public final void closeAll(String str) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str2, "closeAll is called");
        }
        GestureDetectorOnGestureListenerC2634ec a2 = a();
        if (a2 == null) {
            InterfaceC2971z5 interfaceC2971z52 = this.c;
            if (interfaceC2971z52 != null) {
                String str3 = AbstractC2921w6.f2741a;
                Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
                ((A5) interfaceC2971z52).b(str3, "Found a null instance of ad render view!");
                return;
            }
            return;
        }
        InterfaceC2971z5 interfaceC2971z53 = a2.i;
        if (interfaceC2971z53 != null) {
            String str4 = GestureDetectorOnGestureListenerC2634ec.a1;
            ((A5) interfaceC2971z53).a(str4, Ob.a(a2, str4, "TAG", "closeAll "));
        }
        InterfaceC2553a0 interfaceC2553a0 = a2.j0;
        if (interfaceC2553a0 != null) {
            interfaceC2553a0.b();
        }
        Activity activity = (Activity) a2.q.get();
        if (activity != null) {
            activity.finish();
        }
    }

    @JavascriptInterface
    public final void closeCustomExpand(String str) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str2, "closeCustomExpand called.");
        }
        if (this.b != 1) {
            InterfaceC2971z5 interfaceC2971z52 = this.c;
            if (interfaceC2971z52 != null) {
                String str3 = AbstractC2921w6.f2741a;
                ((A5) interfaceC2971z52).b(str3, H6.a(str3, "access$getTAG$p(...)", "closeCustomExpand called in incorrect Ad type: ").append(this.b).toString());
                return;
            }
            return;
        }
        if (this.f2731a != null) {
            new Handler(this.f2731a.getContainerContext().getMainLooper()).post(new Runnable() { // from class: com.inmobi.media.v6$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    C2905v6.a(C2905v6.this);
                }
            });
            return;
        }
        InterfaceC2971z5 interfaceC2971z53 = this.c;
        if (interfaceC2971z53 != null) {
            String str4 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$p(...)");
            ((A5) interfaceC2971z53).b(str4, "Found a null instance of render view!");
        }
    }

    @JavascriptInterface
    public final void customExpand(String str, String str2, int i, float f, boolean z, boolean z2) {
        R6 r6;
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str3 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str3, "customExpand called");
        }
        if (this.f2731a.K0) {
            InterfaceC2971z5 interfaceC2971z52 = this.c;
            if (interfaceC2971z52 != null) {
                String str4 = AbstractC2921w6.f2741a;
                Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$p(...)");
                ((A5) interfaceC2971z52).b(str4, "customExpand called on unloaded ad");
                return;
            }
            return;
        }
        if (this.b != 1) {
            InterfaceC2971z5 interfaceC2971z53 = this.c;
            if (interfaceC2971z53 != null) {
                String str5 = AbstractC2921w6.f2741a;
                ((A5) interfaceC2971z53).b(str5, H6.a(str5, "access$getTAG$p(...)", "customExpand called in incorrect Ad type: ").append(this.b).toString());
                return;
            }
            return;
        }
        if (str2 != null) {
            int length = str2.length() - 1;
            int i2 = 0;
            boolean z3 = false;
            while (i2 <= length) {
                boolean z4 = Intrinsics.compare((int) str2.charAt(!z3 ? i2 : length), 32) <= 0;
                if (z3) {
                    if (!z4) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z4) {
                    i2++;
                } else {
                    z3 = true;
                }
            }
            if (str2.subSequence(i2, length + 1).toString().length() != 0) {
                if (i < 0 || i >= Z3.values().length) {
                    this.f2731a.a(str, "Invalid inputType", "customExpand");
                    return;
                }
                if (f < 0.0f || f > 1.0f) {
                    this.f2731a.a(str, "Invalid screenPercentage", "customExpand");
                    return;
                }
                S6 s6 = this.f2731a.getLandingPageHandler().f;
                if (s6 != null) {
                    String a2 = J6.a(str2);
                    M6 landingPageHandler = this.f2731a.getLandingPageHandler();
                    int i3 = landingPageHandler.h + 1;
                    landingPageHandler.h = i3;
                    r6 = new R6(s6, a2, i3, 8);
                } else {
                    r6 = null;
                }
                R6 r62 = r6;
                if (r62 != null) {
                    r62.g = "IN_CUSTOM";
                }
                M6 landingPageHandler2 = this.f2731a.getLandingPageHandler();
                F6 funnelState = F6.d;
                Integer valueOf = Integer.valueOf(ConnectionsStatusCodes.STATUS_ALREADY_HAVE_ACTIVE_STRATEGY);
                landingPageHandler2.getClass();
                Intrinsics.checkNotNullParameter(funnelState, "funnelState");
                J6.a(funnelState, r62, valueOf, new L6(landingPageHandler2));
                a(str, str2, i, f, z2, r62);
                return;
            }
        }
        this.f2731a.a(str, "Invalid " + i, "customExpand");
    }

    @JavascriptInterface
    public final void customExpandInNative(String str, String url, float f, boolean z) {
        R6 r6;
        Intrinsics.checkNotNullParameter(url, "url");
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str2, "customExpandInNative called");
        }
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = this.f2731a;
        if (gestureDetectorOnGestureListenerC2634ec.K0) {
            InterfaceC2971z5 interfaceC2971z52 = this.c;
            if (interfaceC2971z52 != null) {
                String str3 = AbstractC2921w6.f2741a;
                Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
                ((A5) interfaceC2971z52).b(str3, "customExpandInNative called on unloaded ad");
                return;
            }
            return;
        }
        if (this.b != 1) {
            InterfaceC2971z5 interfaceC2971z53 = this.c;
            if (interfaceC2971z53 != null) {
                String str4 = AbstractC2921w6.f2741a;
                ((A5) interfaceC2971z53).b(str4, H6.a(str4, "access$getTAG$p(...)", "customExpandInNative called in incorrect Ad type: ").append(this.b).toString());
                return;
            }
            return;
        }
        if (f < 0.0f || f > 1.0f) {
            gestureDetectorOnGestureListenerC2634ec.a(str, "Invalid screenPercentage", "customExpandInNative");
            return;
        }
        S6 s6 = gestureDetectorOnGestureListenerC2634ec.getLandingPageHandler().f;
        if (s6 != null) {
            String a2 = J6.a(url);
            M6 landingPageHandler = this.f2731a.getLandingPageHandler();
            int i = landingPageHandler.h + 1;
            landingPageHandler.h = i;
            r6 = new R6(s6, a2, i, 8);
        } else {
            r6 = null;
        }
        R6 r62 = r6;
        if (r62 != null) {
            r62.g = "IN_NATIVE";
        }
        M6 landingPageHandler2 = this.f2731a.getLandingPageHandler();
        F6 funnelState = F6.d;
        landingPageHandler2.getClass();
        Intrinsics.checkNotNullParameter(funnelState, "funnelState");
        J6.a(funnelState, r62, (Integer) 8010, (Function2) new L6(landingPageHandler2));
        int a3 = this.f2731a.getLandingPageHandler().a("customExpandInNative", str, url, r62, new C2691i2(f, z));
        InterfaceC2971z5 interfaceC2971z54 = this.c;
        if (interfaceC2971z54 != null) {
            String str5 = AbstractC2921w6.f2741a;
            ((A5) interfaceC2971z54).a(str5, X8.a(str5, "access$getTAG$p(...)", "customExpandInNativeRequest: ", a3));
        }
        if (a3 == 3) {
            Z3 z3 = Z3.f2503a;
            a(str, url, 0, f, !z, r62);
        }
    }

    @JavascriptInterface
    public final void destroyWebView(String str, final String str2) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str3 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str3, "destroyWebView called");
        }
        GestureDetectorOnGestureListenerC2634ec a2 = a();
        if (a2 != null && a2.K0) {
            InterfaceC2971z5 interfaceC2971z52 = this.c;
            if (interfaceC2971z52 != null) {
                String str4 = AbstractC2921w6.f2741a;
                Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$p(...)");
                ((A5) interfaceC2971z52).b(str4, "destroyWebView called on unloaded ad");
            }
            GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = this.f2731a;
            if (str2 == null) {
                str2 = "";
            }
            Lazy lazy = AbstractC2815pc.f2672a;
            JSONObject a3 = AbstractC2567ad.a(str2, "targetViewId", "id", str2);
            a3.put(IronSourceConstants.EVENTS_ERROR_CODE, 108);
            gestureDetectorOnGestureListenerC2634ec.a("destroyWebView", a3);
            return;
        }
        if (str2 != null && str2.length() != 0) {
            int i = AbstractC2970z4.f2771a;
            ExecutorC2793o7 executorC2793o7 = (ExecutorC2793o7) AbstractC2970z4.d.getValue();
            Runnable runnable = new Runnable() { // from class: com.inmobi.media.v6$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    C2905v6.a(C2905v6.this, str2);
                }
            };
            executorC2793o7.getClass();
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            executorC2793o7.f2659a.post(runnable);
            return;
        }
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec2 = this.f2731a;
        if (str2 == null) {
            str2 = "";
        }
        Lazy lazy2 = AbstractC2815pc.f2672a;
        JSONObject a4 = AbstractC2567ad.a(str2, "targetViewId", "id", str2);
        a4.put(IronSourceConstants.EVENTS_ERROR_CODE, Sdk.SDKError.Reason.INVALID_IFA_STATUS_VALUE);
        gestureDetectorOnGestureListenerC2634ec2.a("destroyWebView", a4);
    }

    @JavascriptInterface
    public final void disableBackButton(String str, boolean z) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str2, "disableBackButton called");
        }
        this.f2731a.getWebViewFactory().a(new C2873t6(z));
    }

    @JavascriptInterface
    public final void disableCloseRegion(final String str, final boolean z) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str2, "disableCloseRegion called");
        }
        final GestureDetectorOnGestureListenerC2634ec a2 = a();
        if (a2 != null) {
            int i = AbstractC2970z4.f2771a;
            ExecutorC2793o7 executorC2793o7 = (ExecutorC2793o7) AbstractC2970z4.d.getValue();
            Runnable runnable = new Runnable() { // from class: com.inmobi.media.v6$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    C2905v6.a(GestureDetectorOnGestureListenerC2634ec.this, z, this, str);
                }
            };
            executorC2793o7.getClass();
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            executorC2793o7.f2659a.post(runnable);
            return;
        }
        this.f2731a.a(str, "Unexpected error", "disableCloseRegion");
        InterfaceC2971z5 interfaceC2971z52 = this.c;
        if (interfaceC2971z52 != null) {
            String str3 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            ((A5) interfaceC2971z52).b(str3, "Found a null instance of render view!");
        }
    }

    @JavascriptInterface
    public final void fireAdFailed(String str) {
        try {
            InterfaceC2971z5 interfaceC2971z5 = this.c;
            if (interfaceC2971z5 != null) {
                String str2 = AbstractC2921w6.f2741a;
                Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
                ((A5) interfaceC2971z5).a(str2, "fireAdFailed called.");
            }
            this.f2731a.j();
        } catch (Exception e) {
            this.f2731a.a(str, "Unexpected error", "fireAdFailed");
            InterfaceC2971z5 interfaceC2971z52 = this.c;
            if (interfaceC2971z52 != null) {
                String str3 = AbstractC2921w6.f2741a;
                ((A5) interfaceC2971z52).b(str3, rf.a(e, H6.a(str3, "access$getTAG$p(...)", "SDK encountered unexpected error in handling fireAdFailed() signal from creative; ")));
            }
        }
    }

    @JavascriptInterface
    public final void fireAdReady(String str) {
        try {
            InterfaceC2971z5 interfaceC2971z5 = this.c;
            if (interfaceC2971z5 != null) {
                String str2 = AbstractC2921w6.f2741a;
                Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
                ((A5) interfaceC2971z5).a(str2, "fireAdReady called.");
            }
            this.f2731a.k();
        } catch (Exception e) {
            this.f2731a.a(str, "Unexpected error", "fireAdReady");
            InterfaceC2971z5 interfaceC2971z52 = this.c;
            if (interfaceC2971z52 != null) {
                String str3 = AbstractC2921w6.f2741a;
                ((A5) interfaceC2971z52).b(str3, rf.a(e, H6.a(str3, "access$getTAG$p(...)", "SDK encountered unexpected error in handling fireAdReady() signal from creative; ")));
            }
        }
    }

    @JavascriptInterface
    public final void fireComplete(String str) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str2, "fireComplete is called");
        }
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = this.f2731a;
        if (gestureDetectorOnGestureListenerC2634ec == null) {
            InterfaceC2971z5 interfaceC2971z52 = this.c;
            if (interfaceC2971z52 != null) {
                String str3 = AbstractC2921w6.f2741a;
                Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
                ((A5) interfaceC2971z52).b(str3, "Found a null instance of render view!");
                return;
            }
            return;
        }
        InterfaceC2971z5 interfaceC2971z53 = gestureDetectorOnGestureListenerC2634ec.i;
        if (interfaceC2971z53 != null) {
            String str4 = GestureDetectorOnGestureListenerC2634ec.a1;
            ((A5) interfaceC2971z53).c(str4, Ob.a(gestureDetectorOnGestureListenerC2634ec, str4, "TAG", "completeFromInterActive "));
        }
        C2625e3 c2625e3 = gestureDetectorOnGestureListenerC2634ec.T0;
        if (c2625e3 != null && !c2625e3.g.get()) {
            c2625e3.d.i = 1;
            Intrinsics.checkNotNull(c2625e3.c);
        }
        InterfaceC2971z5 interfaceC2971z54 = gestureDetectorOnGestureListenerC2634ec.i;
        if (interfaceC2971z54 != null) {
            String TAG = GestureDetectorOnGestureListenerC2634ec.a1;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z54).a(TAG, "completeFromInterActive");
        }
    }

    @JavascriptInterface
    public final void fireSkip(String str) {
        InterfaceC2971z5 interfaceC2971z5;
        InterfaceC2971z5 interfaceC2971z52 = this.c;
        if (interfaceC2971z52 != null) {
            String str2 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((A5) interfaceC2971z52).a(str2, "fireSkip is called");
        }
        if (this.f2731a == null && (interfaceC2971z5 = this.c) != null) {
            String str3 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).b(str3, "Found a null instance of render view!");
        }
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = this.f2731a;
        InterfaceC2971z5 interfaceC2971z53 = gestureDetectorOnGestureListenerC2634ec.i;
        if (interfaceC2971z53 != null) {
            String str4 = GestureDetectorOnGestureListenerC2634ec.a1;
            ((A5) interfaceC2971z53).c(str4, Ob.a(gestureDetectorOnGestureListenerC2634ec, str4, "TAG", "skipFromInterActive "));
        }
        C2625e3 c2625e3 = gestureDetectorOnGestureListenerC2634ec.T0;
        if (c2625e3 != null && !c2625e3.g.get()) {
            c2625e3.d.h = 1;
            Intrinsics.checkNotNull(c2625e3.c);
        }
        InterfaceC2971z5 interfaceC2971z54 = gestureDetectorOnGestureListenerC2634ec.i;
        if (interfaceC2971z54 != null) {
            String TAG = GestureDetectorOnGestureListenerC2634ec.a1;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z54).a(TAG, "skipFromInterActive");
        }
    }

    @JavascriptInterface
    public final String getAdContext(String str) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str2, "getAdContext is called");
        }
        GestureDetectorOnGestureListenerC2634ec a2 = a();
        if (a2 != null) {
            InterfaceC2553a0 adPodHandler = a2.getAdPodHandler();
            if (adPodHandler != null) {
                return ((S0) adPodHandler).K();
            }
            return null;
        }
        InterfaceC2971z5 interfaceC2971z52 = this.c;
        if (interfaceC2971z52 != null) {
            String str3 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            ((A5) interfaceC2971z52).b(str3, "Found a null instance of ad render view!");
        }
        return null;
    }

    @JavascriptInterface
    public final void getBlob(String str, String str2) {
        InterfaceC2573b2 interfaceC2573b2;
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str3 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str3, "getBlob is called");
        }
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = this.f2731a;
        if (gestureDetectorOnGestureListenerC2634ec == null) {
            InterfaceC2971z5 interfaceC2971z52 = this.c;
            if (interfaceC2971z52 != null) {
                String str4 = AbstractC2921w6.f2741a;
                Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$p(...)");
                ((A5) interfaceC2971z52).b(str4, "Found a null instance of render view!");
                return;
            }
            return;
        }
        InterfaceC2971z5 interfaceC2971z53 = gestureDetectorOnGestureListenerC2634ec.i;
        if (interfaceC2971z53 != null) {
            String TAG = GestureDetectorOnGestureListenerC2634ec.a1;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z53).a(TAG, "getBlob");
        }
        if (str == null || str2 == null || (interfaceC2573b2 = gestureDetectorOnGestureListenerC2634ec.f0) == null) {
            return;
        }
        ((S0) interfaceC2573b2).a(str, str2, gestureDetectorOnGestureListenerC2634ec, gestureDetectorOnGestureListenerC2634ec.getImpressionId());
    }

    @JavascriptInterface
    public final String getCurrentPosition(String str) {
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec;
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str2, "getCurrentPosition called");
        }
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec2 = this.f2731a;
        if (gestureDetectorOnGestureListenerC2634ec2 == null) {
            InterfaceC2971z5 interfaceC2971z52 = this.c;
            if (interfaceC2971z52 == null) {
                return "";
            }
            String str3 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            ((A5) interfaceC2971z52).b(str3, "Found a null instance of render view!");
            return "";
        }
        synchronized (gestureDetectorOnGestureListenerC2634ec2.getCurrentPositionMonitor()) {
            this.f2731a.C = true;
            new Handler(this.f2731a.getContainerContext().getMainLooper()).post(new Runnable() { // from class: com.inmobi.media.v6$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    C2905v6.b(C2905v6.this);
                }
            });
            while (true) {
                gestureDetectorOnGestureListenerC2634ec = this.f2731a;
                if (gestureDetectorOnGestureListenerC2634ec.C) {
                    try {
                        gestureDetectorOnGestureListenerC2634ec.getCurrentPositionMonitor().wait();
                    } catch (InterruptedException unused) {
                    }
                } else {
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
        return gestureDetectorOnGestureListenerC2634ec.getCurrentPosition();
    }

    @JavascriptInterface
    public final int getCurrentRenderingIndex(String str) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str2, "getCurrentRenderingIndex is called");
        }
        GestureDetectorOnGestureListenerC2634ec a2 = a();
        if (a2 != null) {
            return a2.getCurrentRenderingPodAdIndex();
        }
        InterfaceC2971z5 interfaceC2971z52 = this.c;
        if (interfaceC2971z52 == null) {
            return 0;
        }
        String str3 = AbstractC2921w6.f2741a;
        Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
        ((A5) interfaceC2971z52).b(str3, "Found a null instance of ad render view!");
        return 0;
    }

    @JavascriptInterface
    public final String getDefaultPosition(String str) {
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec;
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str2, "getDefaultPosition called");
        }
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec2 = this.f2731a;
        if (gestureDetectorOnGestureListenerC2634ec2 == null) {
            InterfaceC2971z5 interfaceC2971z52 = this.c;
            if (interfaceC2971z52 != null) {
                String str3 = AbstractC2921w6.f2741a;
                Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
                ((A5) interfaceC2971z52).b(str3, "Found a null instance of render view!");
            }
            String jSONObject = new JSONObject().toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "toString(...)");
            return jSONObject;
        }
        synchronized (gestureDetectorOnGestureListenerC2634ec2.getDefaultPositionMonitor()) {
            this.f2731a.B = true;
            new Handler(this.f2731a.getContainerContext().getMainLooper()).post(new Runnable() { // from class: com.inmobi.media.v6$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    C2905v6.c(C2905v6.this);
                }
            });
            while (true) {
                gestureDetectorOnGestureListenerC2634ec = this.f2731a;
                if (gestureDetectorOnGestureListenerC2634ec.B) {
                    try {
                        gestureDetectorOnGestureListenerC2634ec.getDefaultPositionMonitor().wait();
                    } catch (InterruptedException unused) {
                    }
                } else {
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
        return gestureDetectorOnGestureListenerC2634ec.getDefaultPosition();
    }

    @JavascriptInterface
    public final int getDeviceVolume(String str) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str2, "getDeviceVolume called");
        }
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = this.f2731a;
        if (gestureDetectorOnGestureListenerC2634ec == null) {
            InterfaceC2971z5 interfaceC2971z52 = this.c;
            if (interfaceC2971z52 != null) {
                String str3 = AbstractC2921w6.f2741a;
                Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
                ((A5) interfaceC2971z52).b(str3, "Found a null instance of render view!");
            }
            return -1;
        }
        try {
            F7 mediaProcessor = gestureDetectorOnGestureListenerC2634ec.getMediaProcessor();
            if (mediaProcessor != null) {
                return mediaProcessor.a();
            }
        } catch (Exception e) {
            this.f2731a.a(str, "Unexpected error", "getDeviceVolume");
            InterfaceC2971z5 interfaceC2971z53 = this.c;
            if (interfaceC2971z53 != null) {
                String str4 = AbstractC2921w6.f2741a;
                ((A5) interfaceC2971z53).b(str4, rf.a(e, H6.a(str4, "access$getTAG$p(...)", "SDK encountered unexpected error in handling getDeviceVolume() request from creative; ")));
            }
        }
        return -1;
    }

    @JavascriptInterface
    public final int getMaxDeviceVolume(String str) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str2, "getMaxDeviceVolume called");
        }
        try {
            return L3.f2348a.m();
        } catch (Exception e) {
            this.f2731a.a(str, "Unexpected error", "getMaxDeviceVolume");
            InterfaceC2971z5 interfaceC2971z52 = this.c;
            if (interfaceC2971z52 == null) {
                return 0;
            }
            String str3 = AbstractC2921w6.f2741a;
            ((A5) interfaceC2971z52).b(str3, rf.a(e, H6.a(str3, "access$getTAG$p(...)", "SDK encountered unexpected error in handling getMaxDeviceVolume() request from creative; ")));
            return 0;
        }
    }

    @JavascriptInterface
    public final String getMaxSize(String str) {
        int i;
        int i2;
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str2, "getMaxSize called");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            Activity fullScreenActivity = this.f2731a.getFullScreenActivity();
            if (fullScreenActivity == null) {
                Context containerContext = this.f2731a.getContainerContext();
                if ((containerContext instanceof Activity ? (Activity) containerContext : null) == null) {
                    return getScreenSize(str);
                }
                Context containerContext2 = this.f2731a.getContainerContext();
                Intrinsics.checkNotNull(containerContext2, "null cannot be cast to non-null type android.app.Activity");
                fullScreenActivity = (Activity) containerContext2;
            }
            FrameLayout frameLayout = (FrameLayout) fullScreenActivity.findViewById(R.id.content);
            int b = B2.b(frameLayout.getWidth() / U3.b());
            int b2 = B2.b(frameLayout.getHeight() / U3.b());
            if (this.f2731a.getFullScreenActivity() != null && (b == 0 || b2 == 0)) {
                Intrinsics.checkNotNull(frameLayout);
                ViewTreeObserverOnGlobalLayoutListenerC2840r6 viewTreeObserverOnGlobalLayoutListenerC2840r6 = new ViewTreeObserverOnGlobalLayoutListenerC2840r6(frameLayout, this.c);
                frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(viewTreeObserverOnGlobalLayoutListenerC2840r6);
                Boolean bool = Boolean.FALSE;
                synchronized (bool) {
                    try {
                        bool.wait();
                    } catch (InterruptedException unused) {
                    }
                    i = viewTreeObserverOnGlobalLayoutListenerC2840r6.c;
                    i2 = viewTreeObserverOnGlobalLayoutListenerC2840r6.d;
                    Unit unit = Unit.INSTANCE;
                }
                b2 = i2;
                b = i;
            }
            try {
                jSONObject.put("width", b);
                jSONObject.put("height", b2);
            } catch (JSONException e) {
                InterfaceC2971z5 interfaceC2971z52 = this.c;
                if (interfaceC2971z52 != null) {
                    String str3 = AbstractC2921w6.f2741a;
                    Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
                    ((A5) interfaceC2971z52).a(str3, "Error while creating max size Json.", e);
                }
            }
            InterfaceC2971z5 interfaceC2971z53 = this.c;
            if (interfaceC2971z53 != null) {
                String str4 = AbstractC2921w6.f2741a;
                Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$p(...)");
                ((A5) interfaceC2971z53).a(str4, "getMaxSize called:" + jSONObject);
            }
        } catch (Exception e2) {
            this.f2731a.a(str, "Unexpected error", "getMaxSize");
            InterfaceC2971z5 interfaceC2971z54 = this.c;
            if (interfaceC2971z54 != null) {
                String str5 = AbstractC2921w6.f2741a;
                ((A5) interfaceC2971z54).b(str5, rf.a(e2, H6.a(str5, "access$getTAG$p(...)", "SDK encountered unexpected error in handling getMaxSize() request from creative; ")));
            }
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
        return jSONObject2;
    }

    @JavascriptInterface
    public final String getOrientation(String str) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str2, "getOrientation called");
        }
        byte g = U3.g();
        return g == 1 ? "0" : g == 3 ? "90" : g == 2 ? "180" : g == 4 ? "270" : com.ironsource.Y1.f;
    }

    @JavascriptInterface
    public final String getOrientationProperties(String str) {
        GestureDetectorOnGestureListenerC2634ec a2 = a();
        if (a2 == null) {
            a2 = this.f2731a;
        }
        String str2 = a2.getOrientationProperties().d;
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str3 = AbstractC2921w6.f2741a;
            ((A5) interfaceC2971z5).a(str3, I6.a(str3, "access$getTAG$p(...)", "getOrientationProperties called: ", str2));
        }
        Intrinsics.checkNotNull(str2);
        return str2;
    }

    @JavascriptInterface
    public final String getPlacementType(String str) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str2, "getPlacementType called");
        }
        return 1 == this.b ? "interstitial" : "inline";
    }

    @JavascriptInterface
    public final String getPlatform(String str) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 == null) {
            return "android";
        }
        String str2 = AbstractC2921w6.f2741a;
        Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
        ((A5) interfaceC2971z5).a(str2, "getPlatform. Platform:android");
        return "android";
    }

    @JavascriptInterface
    public final String getPlatformVersion(String str) {
        String valueOf = String.valueOf(Build.VERSION.SDK_INT);
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            ((A5) interfaceC2971z5).a(str2, I6.a(str2, "access$getTAG$p(...)", "getPlatformVersion. Version:", valueOf));
        }
        return valueOf;
    }

    @JavascriptInterface
    public final String getRenderableAdIndexes(String str) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str2, "getRenderableAdIndexes is called");
        }
        GestureDetectorOnGestureListenerC2634ec a2 = a();
        if (a2 == null) {
            InterfaceC2971z5 interfaceC2971z52 = this.c;
            if (interfaceC2971z52 != null) {
                String str3 = AbstractC2921w6.f2741a;
                Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
                ((A5) interfaceC2971z52).b(str3, "Found a null instance of ad render view!");
            }
            String jSONArray = new JSONArray().toString();
            Intrinsics.checkNotNullExpressionValue(jSONArray, "toString(...)");
            return jSONArray;
        }
        JSONArray renderableAdIndexes = a2.getRenderableAdIndexes();
        InterfaceC2971z5 interfaceC2971z53 = this.c;
        if (interfaceC2971z53 != null) {
            String str4 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$p(...)");
            ((A5) interfaceC2971z53).a(str4, "renderableAdIndexes called:" + renderableAdIndexes);
        }
        String jSONArray2 = renderableAdIndexes.toString();
        Intrinsics.checkNotNullExpressionValue(jSONArray2, "toString(...)");
        return jSONArray2;
    }

    @JavascriptInterface
    public final String getSafeArea(String str) {
        JSONObject safeArea = this.f2731a.getSafeArea();
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str2, "getSafeArea called:" + safeArea);
        }
        if (safeArea != null) {
            return safeArea.toString();
        }
        return null;
    }

    @JavascriptInterface
    public final String getScreenSize(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("width", U3.h().f2459a);
            jSONObject.put("height", U3.h().b);
            InterfaceC2971z5 interfaceC2971z5 = this.c;
            if (interfaceC2971z5 != null) {
                String str2 = AbstractC2921w6.f2741a;
                Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
                ((A5) interfaceC2971z5).c(str2, "Message:Width x Height : " + U3.h().f2459a + 'x' + U3.h().b);
            }
        } catch (JSONException unused) {
        } catch (Exception e) {
            this.f2731a.a(str, "Unexpected error", "getScreenSize");
            InterfaceC2971z5 interfaceC2971z52 = this.c;
            if (interfaceC2971z52 != null) {
                String str3 = AbstractC2921w6.f2741a;
                ((A5) interfaceC2971z52).b(str3, rf.a(e, H6.a(str3, "access$getTAG$p(...)", "SDK encountered unexpected error while getting screen dimensions; ")));
            }
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
        InterfaceC2971z5 interfaceC2971z53 = this.c;
        if (interfaceC2971z53 != null) {
            String str4 = AbstractC2921w6.f2741a;
            ((A5) interfaceC2971z53).a(str4, I6.a(str4, "access$getTAG$p(...)", "getScreenSize called:", jSONObject2));
        }
        return jSONObject2;
    }

    @JavascriptInterface
    public final String getSdkVersion(String str) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 == null) {
            return "10.8.7";
        }
        String str2 = AbstractC2921w6.f2741a;
        Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
        ((A5) interfaceC2971z5).a(str2, "getSdkVersion called. Version:10.8.7");
        return "10.8.7";
    }

    @JavascriptInterface
    public final long getShowTimeStamp(String str) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str2, "getShowTimeStamp is called");
        }
        GestureDetectorOnGestureListenerC2634ec a2 = a();
        if (a2 == null) {
            InterfaceC2971z5 interfaceC2971z52 = this.c;
            if (interfaceC2971z52 == null) {
                return 0L;
            }
            String str3 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            ((A5) interfaceC2971z52).b(str3, "Found a null instance of ad render view!");
            return 0L;
        }
        long showTimeStamp = a2.getShowTimeStamp();
        InterfaceC2971z5 interfaceC2971z53 = this.c;
        if (interfaceC2971z53 != null) {
            String str4 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$p(...)");
            ((A5) interfaceC2971z53).a(str4, "getShowTimeStamp is " + showTimeStamp);
        }
        return showTimeStamp;
    }

    @JavascriptInterface
    public final String getState(String str) {
        String viewState = this.f2731a.getViewState();
        Locale ENGLISH = Locale.ENGLISH;
        Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
        String lowerCase = viewState.toLowerCase(ENGLISH);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            ((A5) interfaceC2971z5).c(str2, I6.a(str2, "access$getTAG$p(...)", "getState called:", lowerCase));
        }
        return lowerCase;
    }

    @JavascriptInterface
    public final String getVersion(String str) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 == null) {
            return "2.0";
        }
        String str2 = AbstractC2921w6.f2741a;
        Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
        ((A5) interfaceC2971z5).a(str2, "getVersion called. Version:2.0");
        return "2.0";
    }

    @JavascriptInterface
    public final void impressionFired(String str) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str2, "impressionFired is called");
        }
        this.f2731a.o();
    }

    @JavascriptInterface
    public final void incentCompleted(String str, String str2) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str3 = AbstractC2921w6.f2741a;
            ((A5) interfaceC2971z5).a(str3, I6.a(str3, "access$getTAG$p(...)", "incentCompleted called. IncentData:", str2));
        }
        if (str2 == null) {
            try {
                this.f2731a.getListener().b(new HashMap());
                return;
            } catch (Exception e) {
                this.f2731a.a(str, "Unexpected error", "incentCompleted");
                InterfaceC2971z5 interfaceC2971z52 = this.c;
                if (interfaceC2971z52 != null) {
                    String str4 = AbstractC2921w6.f2741a;
                    ((A5) interfaceC2971z52).b(str4, rf.a(e, H6.a(str4, "access$getTAG$p(...)", "SDK encountered unexpected error in handling onUserInteraction() signal from creative; ")));
                    return;
                }
                return;
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            HashMap hashMap = new HashMap();
            Iterator<String> keys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "keys(...)");
            while (keys.hasNext()) {
                String next = keys.next();
                Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
                String str5 = next;
                Object obj = jSONObject.get(str5);
                Intrinsics.checkNotNull(obj);
                hashMap.put(str5, obj);
            }
            try {
                try {
                    this.f2731a.getListener().b(hashMap);
                } catch (Exception e2) {
                    this.f2731a.a(str, "Unexpected error", "incentCompleted");
                    InterfaceC2971z5 interfaceC2971z53 = this.c;
                    if (interfaceC2971z53 != null) {
                        String str6 = AbstractC2921w6.f2741a;
                        Intrinsics.checkNotNullExpressionValue(str6, "access$getTAG$p(...)");
                        ((A5) interfaceC2971z53).b(str6, "SDK encountered unexpected error in handling onUserInteraction() signal from creative; " + e2.getMessage());
                    }
                }
            } catch (Exception e3) {
                this.f2731a.a(str, "Unexpected error", "incentCompleted");
                InterfaceC2971z5 interfaceC2971z54 = this.c;
                if (interfaceC2971z54 != null) {
                    String str7 = AbstractC2921w6.f2741a;
                    ((A5) interfaceC2971z54).b(str7, rf.a(e3, H6.a(str7, "access$getTAG$p(...)", "SDK encountered unexpected error in handling onUserInteraction() signal from creative; ")));
                }
            }
        } catch (JSONException unused) {
            this.f2731a.getListener().b(new HashMap());
        }
    }

    @JavascriptInterface
    public final boolean isBackButtonDisabled(String str) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str2, "isBackButtonDisabled called");
        }
        GestureDetectorOnGestureListenerC2634ec a2 = a();
        if (a2 == null) {
            a2 = this.f2731a;
        }
        return a2.H;
    }

    @JavascriptInterface
    public final String isDeviceMuted(String str) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str2, "isDeviceMuted called");
        }
        if (this.f2731a == null) {
            InterfaceC2971z5 interfaceC2971z52 = this.c;
            if (interfaceC2971z52 == null) {
                return "false";
            }
            String str3 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            ((A5) interfaceC2971z52).b(str3, "Found a null instance of render view!");
            return "false";
        }
        InterfaceC2971z5 interfaceC2971z53 = this.c;
        if (interfaceC2971z53 != null) {
            String str4 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$p(...)");
            ((A5) interfaceC2971z53).a(str4, "JavaScript called: isDeviceMuted()");
        }
        boolean z = false;
        try {
            F7 mediaProcessor = this.f2731a.getMediaProcessor();
            Intrinsics.checkNotNull(mediaProcessor);
            InterfaceC2971z5 interfaceC2971z54 = mediaProcessor.b;
            if (interfaceC2971z54 != null) {
                ((A5) interfaceC2971z54).c("MraidMediaProcessor", "isVolumeMuted");
            }
            Context d = Uc.d();
            if (d != null) {
                Object systemService = d.getSystemService("audio");
                AudioManager audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
                if (audioManager != null) {
                    if (2 != audioManager.getRingerMode()) {
                        z = true;
                    }
                }
            }
        } catch (Exception e) {
            InterfaceC2971z5 interfaceC2971z55 = this.c;
            if (interfaceC2971z55 != null) {
                String str5 = AbstractC2921w6.f2741a;
                ((A5) interfaceC2971z55).b(str5, rf.a(e, H6.a(str5, "access$getTAG$p(...)", "SDK encountered unexpected error in checking if device is muted; ")));
            }
        }
        return String.valueOf(z);
    }

    @JavascriptInterface
    public final String isHeadphonePlugged(String str) {
        boolean z;
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str2, "isHeadphonePlugged called");
        }
        if (this.f2731a == null) {
            InterfaceC2971z5 interfaceC2971z52 = this.c;
            if (interfaceC2971z52 == null) {
                return "false";
            }
            String str3 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            ((A5) interfaceC2971z52).b(str3, "Found a null instance of render view!");
            return "false";
        }
        InterfaceC2971z5 interfaceC2971z53 = this.c;
        if (interfaceC2971z53 != null) {
            String str4 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$p(...)");
            ((A5) interfaceC2971z53).a(str4, "JavaScript called: isHeadphonePlugged()");
        }
        try {
            F7 mediaProcessor = this.f2731a.getMediaProcessor();
            Intrinsics.checkNotNull(mediaProcessor);
            mediaProcessor.getClass();
            z = F7.b();
        } catch (Exception e) {
            InterfaceC2971z5 interfaceC2971z54 = this.c;
            if (interfaceC2971z54 != null) {
                String str5 = AbstractC2921w6.f2741a;
                ((A5) interfaceC2971z54).b(str5, rf.a(e, H6.a(str5, "access$getTAG$p(...)", "SDK encountered unexpected error in checking if headphones are plugged-in; ")));
            }
            z = false;
        }
        return String.valueOf(z);
    }

    @JavascriptInterface
    public final boolean isViewable(String str) {
        String str2 = AbstractC2921w6.f2741a;
        Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = this.f2731a;
        if (gestureDetectorOnGestureListenerC2634ec != null) {
            return gestureDetectorOnGestureListenerC2634ec.F == EnumC2620df.c;
        }
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).b(str2, "Found a null instance of render view!");
        }
        return false;
    }

    @JavascriptInterface
    public final void loadAd(String str, int i) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            ((A5) interfaceC2971z5).a(str2, X8.a(str2, "access$getTAG$p(...)", "loadAd is called with index - ", i));
        }
        GestureDetectorOnGestureListenerC2634ec a2 = a();
        if (a2 == null) {
            InterfaceC2971z5 interfaceC2971z52 = this.c;
            if (interfaceC2971z52 != null) {
                String str3 = AbstractC2921w6.f2741a;
                Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
                ((A5) interfaceC2971z52).b(str3, "Found a null instance of ad render view!");
                return;
            }
            return;
        }
        InterfaceC2971z5 interfaceC2971z53 = a2.i;
        if (interfaceC2971z53 != null) {
            String str4 = GestureDetectorOnGestureListenerC2634ec.a1;
            ((A5) interfaceC2971z53).a(str4, Ob.a(a2, str4, "TAG", "loadPodAd "));
        }
        if (a2.F == EnumC2620df.c && a2.j0 != null && !a2.J.get()) {
            InterfaceC2553a0 interfaceC2553a0 = a2.j0;
            if (interfaceC2553a0 != null) {
                interfaceC2553a0.a(i, a2);
                return;
            }
            return;
        }
        InterfaceC2971z5 interfaceC2971z54 = a2.i;
        if (interfaceC2971z54 != null) {
            String TAG = GestureDetectorOnGestureListenerC2634ec.a1;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z54).b(TAG, "Cannot load index pod ad as the current ad is not viewable");
        }
        a2.a(false);
    }

    @JavascriptInterface
    public final void loadWebView(String str, final String str2, final String str3) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str4 = AbstractC2921w6.f2741a;
            ((A5) interfaceC2971z5).a(str4, I6.a(str4, "access$getTAG$p(...)", "loadWebView called with html: ", str3));
        }
        GestureDetectorOnGestureListenerC2634ec a2 = a();
        if (a2 != null && a2.K0) {
            InterfaceC2971z5 interfaceC2971z52 = this.c;
            if (interfaceC2971z52 != null) {
                String str5 = AbstractC2921w6.f2741a;
                Intrinsics.checkNotNullExpressionValue(str5, "access$getTAG$p(...)");
                ((A5) interfaceC2971z52).b(str5, "loadWebView called on unloaded ad");
            }
            GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = this.f2731a;
            if (str2 == null) {
                str2 = "";
            }
            Lazy lazy = AbstractC2815pc.f2672a;
            JSONObject a3 = AbstractC2567ad.a(str2, "targetViewId", "id", str2);
            a3.put(IronSourceConstants.EVENTS_ERROR_CODE, 108);
            gestureDetectorOnGestureListenerC2634ec.a("loadWebView", a3);
            return;
        }
        GestureDetectorOnGestureListenerC2634ec a4 = a();
        if (a4 == null || a4.getPlacementType() != 1) {
            InterfaceC2971z5 interfaceC2971z53 = this.c;
            if (interfaceC2971z53 != null) {
                String str6 = AbstractC2921w6.f2741a;
                Intrinsics.checkNotNullExpressionValue(str6, "access$getTAG$p(...)");
                ((A5) interfaceC2971z53).b(str6, "sibling creation not allowed for inline placement type");
            }
            GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec2 = this.f2731a;
            if (str2 == null) {
                str2 = "";
            }
            Lazy lazy2 = AbstractC2815pc.f2672a;
            JSONObject a5 = AbstractC2567ad.a(str2, "targetViewId", "id", str2);
            a5.put(IronSourceConstants.EVENTS_ERROR_CODE, Sdk.SDKError.Reason.DEEPLINK_OPEN_FAILED_VALUE);
            gestureDetectorOnGestureListenerC2634ec2.a("loadWebView", a5);
            return;
        }
        if (str2 == null || StringsKt.isBlank(str2)) {
            GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec3 = this.f2731a;
            Lazy lazy3 = AbstractC2815pc.f2672a;
            JSONObject a6 = AbstractC2567ad.a("", "targetViewId", "id", "");
            a6.put(IronSourceConstants.EVENTS_ERROR_CODE, Sdk.SDKError.Reason.INVALID_IFA_STATUS_VALUE);
            gestureDetectorOnGestureListenerC2634ec3.a("loadWebView", a6);
            return;
        }
        if (str3 == null || str3.length() == 0) {
            this.f2731a.a("loadWebView", AbstractC2815pc.a(str2, Sdk.SDKError.Reason.MRAID_ERROR_VALUE));
            return;
        }
        int i = AbstractC2970z4.f2771a;
        ExecutorC2793o7 executorC2793o7 = (ExecutorC2793o7) AbstractC2970z4.d.getValue();
        Runnable runnable = new Runnable() { // from class: com.inmobi.media.v6$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                C2905v6.a(C2905v6.this, str2, str3);
            }
        };
        executorC2793o7.getClass();
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        executorC2793o7.f2659a.post(runnable);
    }

    @JavascriptInterface
    public final void log(String str, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            ((A5) interfaceC2971z5).c(str2, I6.a(str2, "access$getTAG$p(...)", "Log called. Message:", message));
        }
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = this.f2731a;
        gestureDetectorOnGestureListenerC2634ec.getClass();
        Gb gb = GestureDetectorOnGestureListenerC2634ec.Y0;
        gb.getClass();
        if (!((Boolean) GestureDetectorOnGestureListenerC2634ec.b1.getValue(gb, Gb.f2296a[0])).booleanValue() || message == null) {
            return;
        }
        gestureDetectorOnGestureListenerC2634ec.getListener().a(message);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x007e, code lost:
    
        if (new org.json.JSONObject(r10).length() == 0) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ee  */
    @JavascriptInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void logTelemetryEvent(String str, String eventType, String str2) {
        C2782nc c2782nc;
        String str3;
        if (eventType == null) {
            InterfaceC2971z5 interfaceC2971z5 = this.c;
            if (interfaceC2971z5 != null) {
                String str4 = AbstractC2921w6.f2741a;
                Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$p(...)");
                ((A5) interfaceC2971z5).b(str4, "eventType is null");
                return;
            }
            return;
        }
        InterfaceC2971z5 interfaceC2971z52 = this.c;
        if (interfaceC2971z52 != null) {
            String str5 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str5, "access$getTAG$p(...)");
            ((A5) interfaceC2971z52).a(str5, "logTelemetryEvent is called: ".concat(eventType));
        }
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = this.f2731a;
        gestureDetectorOnGestureListenerC2634ec.getClass();
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        c2782nc = gestureDetectorOnGestureListenerC2634ec.W;
        if (c2782nc != null) {
            Intrinsics.checkNotNullParameter(eventType, "eventType");
            if (c2782nc.g.get()) {
                return;
            }
            if (c2782nc.f.decrementAndGet() <= 0) {
                c2782nc.g.set(true);
                Map a2 = c2782nc.a();
                long j = c2782nc.c;
                ScheduledExecutorService scheduledExecutorService = Ie.f2319a;
                a2.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - j));
                Pd pd = Pd.f2401a;
                Pd.b("TemplateEventDropped", a2, Td.f2443a);
                return;
            }
            if (str2 != null) {
                try {
                } catch (JSONException e) {
                    Log.e(Pd.b, "Error parsing JSON: " + e);
                }
            }
            str3 = c2782nc.f2652a.k;
            if (str3 == null) {
                str3 = "";
            }
            Map mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("trigger", str3), TuplesKt.to("plType", String.valueOf(c2782nc.f2652a.f2589a.m())), TuplesKt.to("markupType", c2782nc.f2652a.b), TuplesKt.to("networkType", L3.q()));
            if (str2 != null) {
                mutableMapOf.put("payload", str2);
            }
            if (c2782nc.f2652a.c.length() > 0) {
                mutableMapOf.put("metadataBlob", c2782nc.f2652a.c);
            }
            Pd.b(eventType, mutableMapOf, Td.b);
        }
        return;
        str2 = null;
        str3 = c2782nc.f2652a.k;
        if (str3 == null) {
        }
        Map mutableMapOf2 = MapsKt.mutableMapOf(TuplesKt.to("trigger", str3), TuplesKt.to("plType", String.valueOf(c2782nc.f2652a.f2589a.m())), TuplesKt.to("markupType", c2782nc.f2652a.b), TuplesKt.to("networkType", L3.q()));
        if (str2 != null) {
        }
        if (c2782nc.f2652a.c.length() > 0) {
        }
        Pd.b(eventType, mutableMapOf2, Td.b);
    }

    @JavascriptInterface
    public final void onAudioStateChanged(String str, int i) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            ((A5) interfaceC2971z5).a(str2, X8.a(str2, "access$getTAG$p(...)", "onAudioStateChanged is called: ", i));
        }
        D1.b.getClass();
        D1 d1 = (D1) D1.c.get(i);
        if (d1 == null) {
            d1 = D1.d;
        }
        if (d1 != D1.d) {
            this.f2731a.getListener().a(d1);
        }
    }

    @JavascriptInterface
    public final void onOrientationChange(String str) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str2, ">>> onOrientationChange() >>> This API is deprecated!");
        }
    }

    @JavascriptInterface
    public final void onUserAudioMuteInteraction(String str, boolean z) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str2, "onAudioMuteInteraction is called: " + z);
        }
        this.f2731a.getListener().a(z);
    }

    @JavascriptInterface
    public final void onUserInteraction(String str, String str2) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str3 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str3, "onUserInteraction called");
        }
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = this.f2731a;
        if (gestureDetectorOnGestureListenerC2634ec != null && !gestureDetectorOnGestureListenerC2634ec.a()) {
            this.f2731a.a("onUserInteraction");
            return;
        }
        InterfaceC2971z5 interfaceC2971z52 = this.c;
        if (interfaceC2971z52 != null) {
            String str4 = AbstractC2921w6.f2741a;
            ((A5) interfaceC2971z52).a(str4, I6.a(str4, "access$getTAG$p(...)", "onUserInteraction called. Params:", str2));
        }
        if (str2 == null) {
            try {
                this.f2731a.getListener().a(new HashMap());
                return;
            } catch (Exception e) {
                this.f2731a.a(str, "Unexpected error", "onUserInteraction");
                InterfaceC2971z5 interfaceC2971z53 = this.c;
                if (interfaceC2971z53 != null) {
                    String str5 = AbstractC2921w6.f2741a;
                    ((A5) interfaceC2971z53).b(str5, rf.a(e, H6.a(str5, "access$getTAG$p(...)", "SDK encountered unexpected error in handling onUserInteraction() signal from creative; ")));
                    return;
                }
                return;
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            HashMap hashMap = new HashMap();
            Iterator<String> keys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "keys(...)");
            while (keys.hasNext()) {
                String next = keys.next();
                Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
                String str6 = next;
                Object obj = jSONObject.get(str6);
                Intrinsics.checkNotNull(obj);
                hashMap.put(str6, obj);
            }
            try {
                try {
                    this.f2731a.getListener().a(hashMap);
                } catch (Exception e2) {
                    this.f2731a.a(str, "Unexpected error", "onUserInteraction");
                    InterfaceC2971z5 interfaceC2971z54 = this.c;
                    if (interfaceC2971z54 != null) {
                        String str7 = AbstractC2921w6.f2741a;
                        Intrinsics.checkNotNullExpressionValue(str7, "access$getTAG$p(...)");
                        ((A5) interfaceC2971z54).b(str7, "SDK encountered unexpected error in handling onUserInteraction() signal from creative; " + e2.getMessage());
                    }
                }
            } catch (Exception e3) {
                this.f2731a.a(str, "Unexpected error", "onUserInteraction");
                InterfaceC2971z5 interfaceC2971z55 = this.c;
                if (interfaceC2971z55 != null) {
                    String str8 = AbstractC2921w6.f2741a;
                    ((A5) interfaceC2971z55).b(str8, rf.a(e3, H6.a(str8, "access$getTAG$p(...)", "SDK encountered unexpected error in handling onUserInteraction() signal from creative; ")));
                }
            }
        } catch (JSONException unused) {
            this.f2731a.getListener().a(new HashMap());
        }
    }

    @JavascriptInterface
    public final void open(final String str, final String str2) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str3 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str3, "open called");
        }
        if (!this.f2731a.a()) {
            this.f2731a.a("open");
            return;
        }
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = this.f2731a;
        if (!gestureDetectorOnGestureListenerC2634ec.K0) {
            gestureDetectorOnGestureListenerC2634ec.l();
            Md.a(new Runnable() { // from class: com.inmobi.media.v6$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    C2905v6.b(C2905v6.this, str, str2);
                }
            });
            return;
        }
        InterfaceC2971z5 interfaceC2971z52 = this.c;
        if (interfaceC2971z52 != null) {
            String str4 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$p(...)");
            ((A5) interfaceC2971z52).b(str4, "open called on unloaded ad");
        }
    }

    @JavascriptInterface
    public final void openEmbedded(final String str, final String str2) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str3 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str3, "openEmbedded called");
        }
        if (!this.f2731a.a()) {
            this.f2731a.a("openEmbedded");
            return;
        }
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = this.f2731a;
        if (!gestureDetectorOnGestureListenerC2634ec.K0) {
            gestureDetectorOnGestureListenerC2634ec.l();
            Md.a(new Runnable() { // from class: com.inmobi.media.v6$$ExternalSyntheticLambda16
                @Override // java.lang.Runnable
                public final void run() {
                    C2905v6.c(C2905v6.this, str, str2);
                }
            });
            return;
        }
        InterfaceC2971z5 interfaceC2971z52 = this.c;
        if (interfaceC2971z52 != null) {
            String str4 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$p(...)");
            ((A5) interfaceC2971z52).b(str4, "openEmbedded called on unloaded ad");
        }
    }

    @JavascriptInterface
    public final void openExternal(String str, String url, String str2) {
        R6 r6;
        Intrinsics.checkNotNullParameter(url, "url");
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str3 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str3, "open External");
        }
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = this.f2731a;
        if (gestureDetectorOnGestureListenerC2634ec == null) {
            InterfaceC2971z5 interfaceC2971z52 = this.c;
            if (interfaceC2971z52 != null) {
                String str4 = AbstractC2921w6.f2741a;
                Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$p(...)");
                ((A5) interfaceC2971z52).b(str4, "Found a null instance of render view!");
                return;
            }
            return;
        }
        if (!gestureDetectorOnGestureListenerC2634ec.a()) {
            this.f2731a.a("openExternal");
            return;
        }
        this.f2731a.l();
        InterfaceC2971z5 interfaceC2971z53 = this.c;
        if (interfaceC2971z53 != null) {
            String str5 = AbstractC2921w6.f2741a;
            ((A5) interfaceC2971z53).a(str5, I6.a(str5, "access$getTAG$p(...)", "openExternal called with url: ", url));
        }
        S6 s6 = this.f2731a.getLandingPageHandler().f;
        if (s6 != null) {
            String a2 = J6.a(url);
            M6 landingPageHandler = this.f2731a.getLandingPageHandler();
            int i = landingPageHandler.h + 1;
            landingPageHandler.h = i;
            r6 = new R6(s6, a2, i, 8);
        } else {
            r6 = null;
        }
        if (r6 != null) {
            r6.g = "EX_NATIVE";
        }
        M6 landingPageHandler2 = this.f2731a.getLandingPageHandler();
        F6 funnelState = F6.d;
        landingPageHandler2.getClass();
        Intrinsics.checkNotNullParameter(funnelState, "funnelState");
        J6.a(funnelState, r6, (Integer) null, new L6(landingPageHandler2));
        M6 landingPageHandler3 = this.f2731a.getLandingPageHandler();
        landingPageHandler3.getClass();
        Intrinsics.checkNotNullParameter("openExternal", "api");
        if (url != null) {
            landingPageHandler3.e(str, url, str2, r6);
            return;
        }
        if (str2 != null) {
            landingPageHandler3.e(str, str2, null, r6);
            return;
        }
        F6 funnelState2 = F6.e;
        Intrinsics.checkNotNullParameter(funnelState2, "funnelState");
        J6.a(funnelState2, r6, (Integer) 2, (Function2) new L6(landingPageHandler3));
        Ub ub = landingPageHandler3.d;
        if (ub != null) {
            Intrinsics.checkNotNullParameter("Empty url and fallback url", PglCryptUtils.KEY_MESSAGE);
            ub.f2452a.a(str, "Empty url and fallback url", "openExternal");
        }
        InterfaceC2971z5 interfaceC2971z54 = landingPageHandler3.g;
        if (interfaceC2971z54 != null) {
            Intrinsics.checkNotNullExpressionValue("M6", "TAG");
            ((A5) interfaceC2971z54).b("M6", "Empty deeplink and fallback urls");
        }
    }

    @JavascriptInterface
    public final void openWithoutTracker(final String str, final String str2) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str3 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str3, "openWithoutTracker called");
        }
        if (!this.f2731a.a()) {
            this.f2731a.a("openWithoutTracker");
            return;
        }
        if (!this.f2731a.K0) {
            Md.a(new Runnable() { // from class: com.inmobi.media.v6$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    C2905v6.d(C2905v6.this, str, str2);
                }
            });
            return;
        }
        InterfaceC2971z5 interfaceC2971z52 = this.c;
        if (interfaceC2971z52 != null) {
            String str4 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$p(...)");
            ((A5) interfaceC2971z52).b(str4, "openWithoutTracker called on unloaded ad");
        }
    }

    @JavascriptInterface
    public final void ping(String str, String str2, boolean z) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str3 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str3, "ping called");
        }
        if (this.f2731a == null) {
            InterfaceC2971z5 interfaceC2971z52 = this.c;
            if (interfaceC2971z52 != null) {
                String str4 = AbstractC2921w6.f2741a;
                Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$p(...)");
                ((A5) interfaceC2971z52).b(str4, "Found a null instance of render view!");
                return;
            }
            return;
        }
        if (str2 != null) {
            int length = str2.length() - 1;
            int i = 0;
            boolean z2 = false;
            while (i <= length) {
                boolean z3 = Intrinsics.compare((int) str2.charAt(!z2 ? i : length), 32) <= 0;
                if (z2) {
                    if (!z3) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z3) {
                    i++;
                } else {
                    z2 = true;
                }
            }
            if (str2.subSequence(i, length + 1).toString().length() != 0 && URLUtil.isValidUrl(str2)) {
                InterfaceC2971z5 interfaceC2971z53 = this.c;
                if (interfaceC2971z53 != null) {
                    String str5 = AbstractC2921w6.f2741a;
                    Intrinsics.checkNotNullExpressionValue(str5, "access$getTAG$p(...)");
                    ((A5) interfaceC2971z53).a(str5, "JavaScript called ping() URL: >>> " + str2 + " <<<");
                }
                try {
                    C2933x2.f2748a.a(str2, z, this.c);
                    return;
                } catch (Exception e) {
                    this.f2731a.a(str, "Unexpected error", "ping");
                    AbstractC2680h7.a((byte) 1, "InMobi", "Failed to fire ping; SDK encountered unexpected error");
                    InterfaceC2971z5 interfaceC2971z54 = this.c;
                    if (interfaceC2971z54 != null) {
                        String str6 = AbstractC2921w6.f2741a;
                        ((A5) interfaceC2971z54).b(str6, rf.a(e, H6.a(str6, "access$getTAG$p(...)", "SDK encountered unexpected error in handling ping() request from creative; ")));
                        return;
                    }
                    return;
                }
            }
        }
        this.f2731a.a(str, "Invalid URL:" + str2, "ping");
    }

    @JavascriptInterface
    public final void pingInWebView(String str, String str2, boolean z) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str3 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str3, "openInWebView called");
        }
        if (this.f2731a == null) {
            InterfaceC2971z5 interfaceC2971z52 = this.c;
            if (interfaceC2971z52 != null) {
                String str4 = AbstractC2921w6.f2741a;
                Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$p(...)");
                ((A5) interfaceC2971z52).b(str4, "Found a null instance of render view!");
                return;
            }
            return;
        }
        if (str2 != null) {
            int length = str2.length() - 1;
            int i = 0;
            boolean z2 = false;
            while (i <= length) {
                boolean z3 = Intrinsics.compare((int) str2.charAt(!z2 ? i : length), 32) <= 0;
                if (z2) {
                    if (!z3) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z3) {
                    i++;
                } else {
                    z2 = true;
                }
            }
            if (str2.subSequence(i, length + 1).toString().length() != 0 && URLUtil.isValidUrl(str2)) {
                InterfaceC2971z5 interfaceC2971z53 = this.c;
                if (interfaceC2971z53 != null) {
                    String str5 = AbstractC2921w6.f2741a;
                    Intrinsics.checkNotNullExpressionValue(str5, "access$getTAG$p(...)");
                    ((A5) interfaceC2971z53).a(str5, "JavaScript called pingInWebView() URL: >>> " + str2 + " <<<");
                }
                try {
                    C2933x2.f2748a.b(str2, z, this.c);
                    return;
                } catch (Exception e) {
                    this.f2731a.a(str, "Unexpected error", "pingInWebView");
                    AbstractC2680h7.a((byte) 1, "InMobi", "Failed to fire ping; SDK encountered unexpected error");
                    InterfaceC2971z5 interfaceC2971z54 = this.c;
                    if (interfaceC2971z54 != null) {
                        String str6 = AbstractC2921w6.f2741a;
                        ((A5) interfaceC2971z54).b(str6, rf.a(e, H6.a(str6, "access$getTAG$p(...)", "SDK encountered unexpected error in handling pingInWebView() request from creative; ")));
                        return;
                    }
                    return;
                }
            }
        }
        this.f2731a.a(str, "Invalid URL:" + str2, "pingInWebView");
    }

    @JavascriptInterface
    public final void pingV2(String str, String pingJson) {
        Intrinsics.checkNotNullParameter(pingJson, "pingJson");
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str2, "pingV2 called with JSON: >>> " + pingJson + " <<<");
        }
        try {
            this.f2731a.b(pingJson);
        } catch (Exception e) {
            this.f2731a.a(str, "Unexpected error", "ping");
            GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = this.f2731a;
            gestureDetectorOnGestureListenerC2634ec.getClass();
            Intrinsics.checkNotNullParameter(e, "e");
            InterfaceC2971z5 interfaceC2971z52 = gestureDetectorOnGestureListenerC2634ec.i;
            if (interfaceC2971z52 != null) {
                String str3 = GestureDetectorOnGestureListenerC2634ec.a1;
                ((A5) interfaceC2971z52).a(str3, Ob.a(gestureDetectorOnGestureListenerC2634ec, str3, "TAG", "handlePingException "), e);
            }
            Ha ha = gestureDetectorOnGestureListenerC2634ec.m;
            EnumC2774n4[] enumC2774n4Arr = EnumC2774n4.f2646a;
            ((Yb) ha).a("", PlaybackException.ERROR_CODE_SKIP_LIMIT_REACHED, "Ping exception occurred", System.currentTimeMillis(), 0);
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
            AbstractC2680h7.a((byte) 1, "InMobi", "Failed to fire ping; SDK encountered unexpected error");
            InterfaceC2971z5 interfaceC2971z53 = this.c;
            if (interfaceC2971z53 != null) {
                String str4 = AbstractC2921w6.f2741a;
                ((A5) interfaceC2971z53).b(str4, rf.a(e, H6.a(str4, "access$getTAG$p(...)", "SDK encountered unexpected error in handling ping() request from creative; ")));
            }
        }
    }

    @JavascriptInterface
    public final void playVideo(final String str, final String str2) {
        if (this.f2731a == null) {
            InterfaceC2971z5 interfaceC2971z5 = this.c;
            if (interfaceC2971z5 != null) {
                String str3 = AbstractC2921w6.f2741a;
                Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
                ((A5) interfaceC2971z5).b(str3, "Found a null instance of render view!");
                return;
            }
            return;
        }
        if (str2 != null) {
            int length = str2.length() - 1;
            int i = 0;
            boolean z = false;
            while (i <= length) {
                boolean z2 = Intrinsics.compare((int) str2.charAt(!z ? i : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z2) {
                    i++;
                } else {
                    z = true;
                }
            }
            if (str2.subSequence(i, length + 1).toString().length() != 0 && StringsKt.startsWith$default(str2, "http", false, 2, (Object) null) && (StringsKt.endsWith$default(str2, "mp4", false, 2, (Object) null) || StringsKt.endsWith$default(str2, "avi", false, 2, (Object) null) || StringsKt.endsWith$default(str2, "m4v", false, 2, (Object) null))) {
                InterfaceC2971z5 interfaceC2971z52 = this.c;
                if (interfaceC2971z52 != null) {
                    String str4 = AbstractC2921w6.f2741a;
                    Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$p(...)");
                    ((A5) interfaceC2971z52).a(str4, "JavaScript called: playVideo (" + str2 + ')');
                }
                new Handler(this.f2731a.getContainerContext().getMainLooper()).post(new Runnable() { // from class: com.inmobi.media.v6$$ExternalSyntheticLambda12
                    @Override // java.lang.Runnable
                    public final void run() {
                        C2905v6.e(C2905v6.this, str, str2);
                    }
                });
                return;
            }
        }
        this.f2731a.a(str, "Null or empty or invalid media playback URL supplied", "playVideo");
    }

    @JavascriptInterface
    public final void registerBackButtonPressedEventListener(String str) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str2, "registerBackButtonPressedEventListener called");
        }
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = this.f2731a;
        if (gestureDetectorOnGestureListenerC2634ec == null) {
            InterfaceC2971z5 interfaceC2971z52 = this.c;
            if (interfaceC2971z52 != null) {
                String str3 = AbstractC2921w6.f2741a;
                Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
                ((A5) interfaceC2971z52).b(str3, "Found a null instance of render view!");
                return;
            }
            return;
        }
        try {
            InterfaceC2971z5 interfaceC2971z53 = gestureDetectorOnGestureListenerC2634ec.i;
            if (interfaceC2971z53 != null) {
                String TAG = GestureDetectorOnGestureListenerC2634ec.a1;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((A5) interfaceC2971z53).a(TAG, "registerBackButtonPressedEventListener " + gestureDetectorOnGestureListenerC2634ec);
            }
            gestureDetectorOnGestureListenerC2634ec.I = str;
        } catch (Exception e) {
            this.f2731a.a(str, "Unexpected error", "registerBackButtonPressedEventListener");
            InterfaceC2971z5 interfaceC2971z54 = this.c;
            if (interfaceC2971z54 != null) {
                String str4 = AbstractC2921w6.f2741a;
                ((A5) interfaceC2971z54).b(str4, rf.a(e, H6.a(str4, "access$getTAG$p(...)", "SDK encountered unexpected error in handling registerBackButtonPressedEventListener() request from creative; ")));
            }
        }
    }

    @JavascriptInterface
    public final void registerDeviceMuteEventListener(String jsCallbackNamespace) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str, "registerDeviceMuteEventListener called");
        }
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = this.f2731a;
        if (gestureDetectorOnGestureListenerC2634ec == null) {
            InterfaceC2971z5 interfaceC2971z52 = this.c;
            if (interfaceC2971z52 != null) {
                String str2 = AbstractC2921w6.f2741a;
                Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
                ((A5) interfaceC2971z52).b(str2, "Found a null instance of render view!");
                return;
            }
            return;
        }
        if (jsCallbackNamespace != null) {
            try {
                F7 mediaProcessor = gestureDetectorOnGestureListenerC2634ec.getMediaProcessor();
                if (mediaProcessor != null) {
                    Intrinsics.checkNotNullParameter(jsCallbackNamespace, "jsCallbackNamespace");
                    if (mediaProcessor.d == null) {
                        C2857s7 c2857s7 = new C2857s7(new C7(mediaProcessor, jsCallbackNamespace));
                        mediaProcessor.d = c2857s7;
                        c2857s7.b();
                    }
                }
            } catch (Exception e) {
                this.f2731a.a(jsCallbackNamespace, "Unexpected error", "registerDeviceMuteEventListener");
                InterfaceC2971z5 interfaceC2971z53 = this.c;
                if (interfaceC2971z53 != null) {
                    String str3 = AbstractC2921w6.f2741a;
                    ((A5) interfaceC2971z53).b(str3, rf.a(e, H6.a(str3, "access$getTAG$p(...)", "SDK encountered unexpected error in handling registerDeviceMuteEventListener() request from creative; ")));
                }
            }
        }
    }

    @JavascriptInterface
    public final void registerDeviceVolumeChangeEventListener(String jsCallbackNamespace) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str, "registerDeviceVolumeChangeEventListener called");
        }
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = this.f2731a;
        if (gestureDetectorOnGestureListenerC2634ec == null) {
            InterfaceC2971z5 interfaceC2971z52 = this.c;
            if (interfaceC2971z52 != null) {
                String str2 = AbstractC2921w6.f2741a;
                Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
                ((A5) interfaceC2971z52).b(str2, "Found a null instance of render view!");
                return;
            }
            return;
        }
        if (jsCallbackNamespace != null) {
            try {
                F7 mediaProcessor = gestureDetectorOnGestureListenerC2634ec.getMediaProcessor();
                if (mediaProcessor != null) {
                    Intrinsics.checkNotNullParameter(jsCallbackNamespace, "jsCallbackNamespace");
                    Context d = Uc.d();
                    if (d != null && mediaProcessor.e == null) {
                        C2857s7 c2857s7 = new C2857s7(new D7(mediaProcessor, jsCallbackNamespace, d, new Handler(Looper.getMainLooper())));
                        mediaProcessor.e = c2857s7;
                        c2857s7.b();
                    }
                }
            } catch (Exception e) {
                this.f2731a.a(jsCallbackNamespace, "Unexpected error", "registerDeviceVolumeChangeEventListener");
                InterfaceC2971z5 interfaceC2971z53 = this.c;
                if (interfaceC2971z53 != null) {
                    String str3 = AbstractC2921w6.f2741a;
                    ((A5) interfaceC2971z53).b(str3, rf.a(e, H6.a(str3, "access$getTAG$p(...)", "SDK encountered unexpected error in handling registerDeviceVolumeChangeEventListener() request from creative; ")));
                }
            }
        }
    }

    @JavascriptInterface
    public final void registerHeadphonePluggedEventListener(String jsCallbackNamespace) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str, "registerHeadphonePluggedEventListener called");
        }
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = this.f2731a;
        if (gestureDetectorOnGestureListenerC2634ec == null) {
            InterfaceC2971z5 interfaceC2971z52 = this.c;
            if (interfaceC2971z52 != null) {
                String str2 = AbstractC2921w6.f2741a;
                Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
                ((A5) interfaceC2971z52).b(str2, "Found a null instance of render view!");
                return;
            }
            return;
        }
        if (jsCallbackNamespace != null) {
            try {
                F7 mediaProcessor = gestureDetectorOnGestureListenerC2634ec.getMediaProcessor();
                if (mediaProcessor != null) {
                    Intrinsics.checkNotNullParameter(jsCallbackNamespace, "jsCallbackNamespace");
                    if (mediaProcessor.f == null) {
                        C2857s7 c2857s7 = new C2857s7(new B7(mediaProcessor, jsCallbackNamespace));
                        mediaProcessor.f = c2857s7;
                        c2857s7.b();
                    }
                }
            } catch (Exception e) {
                this.f2731a.a(jsCallbackNamespace, "Unexpected error", "registerHeadphonePluggedEventListener");
                InterfaceC2971z5 interfaceC2971z53 = this.c;
                if (interfaceC2971z53 != null) {
                    String str3 = AbstractC2921w6.f2741a;
                    ((A5) interfaceC2971z53).b(str3, rf.a(e, H6.a(str3, "access$getTAG$p(...)", "SDK encountered unexpected error in handling registerHeadphonePluggedEventListener() request from creative; ")));
                }
            }
        }
    }

    @JavascriptInterface
    public final void saveBlob(String str, String str2) {
        InterfaceC2573b2 interfaceC2573b2;
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str3 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str3, "saveBlob is called");
        }
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = this.f2731a;
        if (gestureDetectorOnGestureListenerC2634ec == null) {
            InterfaceC2971z5 interfaceC2971z52 = this.c;
            if (interfaceC2971z52 != null) {
                String str4 = AbstractC2921w6.f2741a;
                Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$p(...)");
                ((A5) interfaceC2971z52).b(str4, "Found a null instance of render view!");
                return;
            }
            return;
        }
        InterfaceC2971z5 interfaceC2971z53 = gestureDetectorOnGestureListenerC2634ec.i;
        if (interfaceC2971z53 != null) {
            String TAG = GestureDetectorOnGestureListenerC2634ec.a1;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z53).a(TAG, "saveBlob");
        }
        if (str2 == null || (interfaceC2573b2 = gestureDetectorOnGestureListenerC2634ec.f0) == null) {
            return;
        }
        ((S0) interfaceC2573b2).a(str2, gestureDetectorOnGestureListenerC2634ec.getImpressionId());
    }

    @JavascriptInterface
    public final void saveContent(String str, String str2, String str3) {
        if (str2 != null && str2.length() != 0 && str3 != null && str3.length() != 0) {
            try {
                this.f2731a.b(str, str2, str3);
                return;
            } catch (Exception e) {
                this.f2731a.a(str, "Unexpected error", "saveContent");
                InterfaceC2971z5 interfaceC2971z5 = this.c;
                if (interfaceC2971z5 != null) {
                    String str4 = AbstractC2921w6.f2741a;
                    ((A5) interfaceC2971z5).b(str4, rf.a(e, H6.a(str4, "access$getTAG$p(...)", "SDK encountered unexpected error in handling saveContent() request from creative; ")));
                    return;
                }
                return;
            }
        }
        InterfaceC2971z5 interfaceC2971z52 = this.c;
        if (interfaceC2971z52 != null) {
            String str5 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str5, "access$getTAG$p(...)");
            ((A5) interfaceC2971z52).a(str5, "saveContent called with invalid parameters");
        }
        JSONObject jSONObject = new JSONObject();
        if (str3 == null) {
            str3 = "";
        }
        try {
            jSONObject.put("url", str3);
            jSONObject.put("reason", 8);
        } catch (JSONException unused) {
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
        String replace$default = StringsKt.replace$default(jSONObject2, "\"", "\\\"", false, 4, (Object) null);
        StringBuilder sb = new StringBuilder("sendSaveContentResult(\"saveContent_");
        if (str2 == null) {
            str2 = "";
        }
        this.f2731a.a(str, sb.append(str2).append("\", 'failed', \"").append(replace$default).append("\");").toString());
    }

    @JavascriptInterface
    public final void sendMessage(String str, final String str2, final String str3) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str4 = AbstractC2921w6.f2741a;
            ((A5) interfaceC2971z5).a(str4, I6.a(str4, "access$getTAG$p(...)", "sendMessage called with message: ", str3));
        }
        GestureDetectorOnGestureListenerC2634ec a2 = a();
        if (a2 != null && a2.K0) {
            InterfaceC2971z5 interfaceC2971z52 = this.c;
            if (interfaceC2971z52 != null) {
                String str5 = AbstractC2921w6.f2741a;
                Intrinsics.checkNotNullExpressionValue(str5, "access$getTAG$p(...)");
                ((A5) interfaceC2971z52).b(str5, "sendMessage called on unloaded ad");
            }
            GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = this.f2731a;
            if (str2 == null) {
                str2 = "";
            }
            Lazy lazy = AbstractC2815pc.f2672a;
            JSONObject a3 = AbstractC2567ad.a(str2, "targetViewId", "id", str2);
            a3.put(IronSourceConstants.EVENTS_ERROR_CODE, 108);
            gestureDetectorOnGestureListenerC2634ec.a(C3061e8.j, a3);
            return;
        }
        if (str2 == null || StringsKt.isBlank(str2)) {
            GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec2 = this.f2731a;
            if (str2 == null) {
                str2 = "";
            }
            Lazy lazy2 = AbstractC2815pc.f2672a;
            JSONObject a4 = AbstractC2567ad.a(str2, "targetViewId", "id", str2);
            a4.put(IronSourceConstants.EVENTS_ERROR_CODE, Sdk.SDKError.Reason.INVALID_IFA_STATUS_VALUE);
            gestureDetectorOnGestureListenerC2634ec2.a(C3061e8.j, a4);
            return;
        }
        if (str3 == null || StringsKt.isBlank(str3)) {
            this.f2731a.a(C3061e8.j, AbstractC2815pc.a(str2, Sdk.SDKError.Reason.MRAID_ERROR_VALUE));
            return;
        }
        int i = AbstractC2970z4.f2771a;
        ExecutorC2793o7 executorC2793o7 = (ExecutorC2793o7) AbstractC2970z4.d.getValue();
        Runnable runnable = new Runnable() { // from class: com.inmobi.media.v6$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                C2905v6.f(C2905v6.this, str2, str3);
            }
        };
        executorC2793o7.getClass();
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        executorC2793o7.f2659a.post(runnable);
    }

    @JavascriptInterface
    public final void setAdContext(String str, String podAdContext) {
        Intrinsics.checkNotNullParameter(podAdContext, "podAdContext");
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            ((A5) interfaceC2971z5).a(str2, I6.a(str2, "access$getTAG$p(...)", "setAdContext is called ", podAdContext));
        }
        GestureDetectorOnGestureListenerC2634ec a2 = a();
        if (a2 != null) {
            InterfaceC2553a0 adPodHandler = a2.getAdPodHandler();
            if (adPodHandler != null) {
                ((S0) adPodHandler).d(podAdContext);
                return;
            }
            return;
        }
        InterfaceC2971z5 interfaceC2971z52 = this.c;
        if (interfaceC2971z52 != null) {
            String str3 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            ((A5) interfaceC2971z52).b(str3, "Found a null instance of ad render view!");
        }
    }

    @JavascriptInterface
    public final void setCloseEndCardTracker(String str, String str2) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str3 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str3, "setCloseEndCardTracker is called");
        }
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = this.f2731a;
        if (gestureDetectorOnGestureListenerC2634ec == null) {
            InterfaceC2971z5 interfaceC2971z52 = this.c;
            if (interfaceC2971z52 != null) {
                String str4 = AbstractC2921w6.f2741a;
                Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$p(...)");
                ((A5) interfaceC2971z52).b(str4, "Found a null instance of render view!");
                return;
            }
            return;
        }
        try {
            gestureDetectorOnGestureListenerC2634ec.setCloseEndCardTracker(str2);
        } catch (Exception e) {
            this.f2731a.a(str, "Unexpected error", "getDownloadStatus");
            InterfaceC2971z5 interfaceC2971z53 = this.c;
            if (interfaceC2971z53 != null) {
                String str5 = AbstractC2921w6.f2741a;
                ((A5) interfaceC2971z53).b(str5, rf.a(e, H6.a(str5, "access$getTAG$p(...)", "SDK encountered unexpected error in handling getDownloadStatus() request from creative; ")));
            }
        }
    }

    @JavascriptInterface
    public final void setOrientationProperties(String str, final String orientationPropertiesString) {
        Intrinsics.checkNotNullParameter(orientationPropertiesString, "orientationPropertiesString");
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            ((A5) interfaceC2971z5).a(str2, I6.a(str2, "access$getTAG$p(...)", "setOrientationProperties called: ", orientationPropertiesString));
        }
        int i = AbstractC2970z4.f2771a;
        ExecutorC2793o7 executorC2793o7 = (ExecutorC2793o7) AbstractC2970z4.d.getValue();
        Runnable runnable = new Runnable() { // from class: com.inmobi.media.v6$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                C2905v6.b(C2905v6.this, orientationPropertiesString);
            }
        };
        executorC2793o7.getClass();
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        executorC2793o7.f2659a.post(runnable);
    }

    @JavascriptInterface
    public final void showAd(String str, int i) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            ((A5) interfaceC2971z5).a(str2, X8.a(str2, "access$getTAG$p(...)", "showAd is called with index ", i));
        }
        GestureDetectorOnGestureListenerC2634ec a2 = a();
        if (a2 == null) {
            InterfaceC2971z5 interfaceC2971z52 = this.c;
            if (interfaceC2971z52 != null) {
                String str3 = AbstractC2921w6.f2741a;
                Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
                ((A5) interfaceC2971z52).b(str3, "Found a null instance of ad render view!");
                return;
            }
            return;
        }
        InterfaceC2971z5 interfaceC2971z53 = a2.i;
        if (interfaceC2971z53 != null) {
            String TAG = GestureDetectorOnGestureListenerC2634ec.a1;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z53).a(TAG, "showPodAdAtIndex " + a2 + ' ' + i);
        }
        if (a2.F == EnumC2620df.c && a2.j0 != null && !a2.J.get()) {
            InterfaceC2553a0 interfaceC2553a0 = a2.j0;
            if (interfaceC2553a0 != null) {
                interfaceC2553a0.a(i, a2, a2.getFullScreenActivity());
                return;
            }
            return;
        }
        InterfaceC2971z5 interfaceC2971z54 = a2.i;
        if (interfaceC2971z54 != null) {
            String TAG2 = GestureDetectorOnGestureListenerC2634ec.a1;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((A5) interfaceC2971z54).b(TAG2, "Cannot show index pod ad as the current ad is not viewable");
        }
        a2.b(false);
    }

    @JavascriptInterface
    public final void showAlert(String str, String alert) {
        Intrinsics.checkNotNullParameter(alert, "alert");
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            ((A5) interfaceC2971z5).a(str2, I6.a(str2, "access$getTAG$p(...)", "showAlert: ", alert));
        }
    }

    @JavascriptInterface
    public final void showEndCard(String str) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str2, "showEndCard is called");
        }
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = this.f2731a;
        if (gestureDetectorOnGestureListenerC2634ec == null) {
            InterfaceC2971z5 interfaceC2971z52 = this.c;
            if (interfaceC2971z52 != null) {
                String str3 = AbstractC2921w6.f2741a;
                Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
                ((A5) interfaceC2971z52).b(str3, "Found a null instance of render view!");
                return;
            }
            return;
        }
        InterfaceC2971z5 interfaceC2971z53 = gestureDetectorOnGestureListenerC2634ec.i;
        if (interfaceC2971z53 != null) {
            String TAG = GestureDetectorOnGestureListenerC2634ec.a1;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z53).a(TAG, "showEndCardFromInterActive");
        }
        InterfaceC2930x referenceContainer = gestureDetectorOnGestureListenerC2634ec.getReferenceContainer();
        if (referenceContainer instanceof T7) {
            ((T7) referenceContainer).o();
        }
    }

    @JavascriptInterface
    public final void showWebView(String str, final String str2) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str3 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str3, "showEndCard called");
        }
        GestureDetectorOnGestureListenerC2634ec a2 = a();
        if (a2 != null && a2.K0) {
            InterfaceC2971z5 interfaceC2971z52 = this.c;
            if (interfaceC2971z52 != null) {
                String str4 = AbstractC2921w6.f2741a;
                Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$p(...)");
                ((A5) interfaceC2971z52).b(str4, "showWebView called on unloaded ad");
            }
            GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = this.f2731a;
            if (str2 == null) {
                str2 = "";
            }
            Lazy lazy = AbstractC2815pc.f2672a;
            JSONObject a3 = AbstractC2567ad.a(str2, "targetViewId", "id", str2);
            a3.put(IronSourceConstants.EVENTS_ERROR_CODE, 108);
            gestureDetectorOnGestureListenerC2634ec.a("showWebView", a3);
            return;
        }
        if (str2 != null && str2.length() != 0) {
            int i = AbstractC2970z4.f2771a;
            ExecutorC2793o7 executorC2793o7 = (ExecutorC2793o7) AbstractC2970z4.d.getValue();
            Runnable runnable = new Runnable() { // from class: com.inmobi.media.v6$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    C2905v6.c(C2905v6.this, str2);
                }
            };
            executorC2793o7.getClass();
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            executorC2793o7.f2659a.post(runnable);
            return;
        }
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec2 = this.f2731a;
        if (str2 == null) {
            str2 = "";
        }
        Lazy lazy2 = AbstractC2815pc.f2672a;
        JSONObject a4 = AbstractC2567ad.a(str2, "targetViewId", "id", str2);
        a4.put(IronSourceConstants.EVENTS_ERROR_CODE, Sdk.SDKError.Reason.INVALID_IFA_STATUS_VALUE);
        gestureDetectorOnGestureListenerC2634ec2.a("showWebView", a4);
    }

    @JavascriptInterface
    public final void storePicture(String str, String str2) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str3 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str3, "storePicture is deprecated and no-op. ");
        }
    }

    @JavascriptInterface
    public final void submitAdReport(String str, String adQualityUrl, String enableUserAdReportScreenshot, String templateInfo) {
        Intrinsics.checkNotNullParameter(adQualityUrl, "adQualityUrl");
        Intrinsics.checkNotNullParameter(enableUserAdReportScreenshot, "enableUserAdReportScreenshot");
        Intrinsics.checkNotNullParameter(templateInfo, "templateInfo");
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str2, "submitAdReport called");
        }
        this.f2731a.a(adQualityUrl, templateInfo, Intrinsics.areEqual(enableUserAdReportScreenshot, "1"));
    }

    @JavascriptInterface
    public final String supports(String str, String feature) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            ((A5) interfaceC2971z5).a(str2, I6.a(str2, "access$getTAG$p(...)", "Checking support for: ", feature));
        }
        String valueOf = String.valueOf(this.f2731a.f(feature));
        InterfaceC2971z5 interfaceC2971z52 = this.c;
        if (interfaceC2971z52 != null) {
            String str3 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            ((A5) interfaceC2971z52).c(str3, "Message:" + feature + " support: " + valueOf);
        }
        return valueOf;
    }

    @JavascriptInterface
    public final long timeSinceShow(String str) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str2, "timeSinceShow is called");
        }
        GestureDetectorOnGestureListenerC2634ec a2 = a();
        if (a2 == null) {
            InterfaceC2971z5 interfaceC2971z52 = this.c;
            if (interfaceC2971z52 != null) {
                String str3 = AbstractC2921w6.f2741a;
                Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
                ((A5) interfaceC2971z52).b(str3, "Found a null instance of ad render view!");
            }
            return 0L;
        }
        InterfaceC2971z5 interfaceC2971z53 = a2.i;
        if (interfaceC2971z53 != null) {
            String str4 = GestureDetectorOnGestureListenerC2634ec.a1;
            ((A5) interfaceC2971z53).c(str4, Ob.a(a2, str4, "TAG", "timeSincePodShow "));
        }
        InterfaceC2553a0 interfaceC2553a0 = a2.j0;
        if (interfaceC2553a0 != null) {
            return ((S0) interfaceC2553a0).A0();
        }
        return 0L;
    }

    @JavascriptInterface
    public final void unload(String str) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str2, "unload called");
        }
        GestureDetectorOnGestureListenerC2634ec a2 = a();
        if (a2 == null) {
            a2 = this.f2731a;
        }
        try {
            a2.q();
        } catch (Exception e) {
            a2.a(str, "Unexpected error", "unload");
            AbstractC2680h7.a((byte) 1, "InMobi", "Failed to unload ad; SDK encountered an unexpected error");
            InterfaceC2971z5 interfaceC2971z52 = this.c;
            if (interfaceC2971z52 != null) {
                String str3 = AbstractC2921w6.f2741a;
                ((A5) interfaceC2971z52).b(str3, rf.a(e, H6.a(str3, "access$getTAG$p(...)", "SDK encountered an expected error in handling the unload() request from creative; ")));
            }
        }
    }

    @JavascriptInterface
    public final void unregisterBackButtonPressedEventListener(String str) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str2, "unregisterBackButtonPressedEventListener called");
        }
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = this.f2731a;
        if (gestureDetectorOnGestureListenerC2634ec == null) {
            InterfaceC2971z5 interfaceC2971z52 = this.c;
            if (interfaceC2971z52 != null) {
                String str3 = AbstractC2921w6.f2741a;
                Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
                ((A5) interfaceC2971z52).b(str3, "Found a null instance of render view!");
                return;
            }
            return;
        }
        try {
            InterfaceC2971z5 interfaceC2971z53 = gestureDetectorOnGestureListenerC2634ec.i;
            if (interfaceC2971z53 != null) {
                String TAG = GestureDetectorOnGestureListenerC2634ec.a1;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((A5) interfaceC2971z53).a(TAG, "unregisterBackButtonPressedEventListener " + gestureDetectorOnGestureListenerC2634ec);
            }
            gestureDetectorOnGestureListenerC2634ec.I = null;
        } catch (Exception e) {
            this.f2731a.a(str, "Unexpected error", "unregisterBackButtonPressedEventListener");
            InterfaceC2971z5 interfaceC2971z54 = this.c;
            if (interfaceC2971z54 != null) {
                String str4 = AbstractC2921w6.f2741a;
                ((A5) interfaceC2971z54).b(str4, rf.a(e, H6.a(str4, "access$getTAG$p(...)", "SDK encountered unexpected error in handling unregisterBackButtonPressedEventListener() request from creative; ")));
            }
        }
    }

    @JavascriptInterface
    public final void unregisterDeviceMuteEventListener(String str) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str2, "unregisterDeviceMuteEventListener called");
        }
        if (this.f2731a == null) {
            InterfaceC2971z5 interfaceC2971z52 = this.c;
            if (interfaceC2971z52 != null) {
                String str3 = AbstractC2921w6.f2741a;
                Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
                ((A5) interfaceC2971z52).b(str3, "Found a null instance of render view!");
                return;
            }
            return;
        }
        InterfaceC2971z5 interfaceC2971z53 = this.c;
        if (interfaceC2971z53 != null) {
            String str4 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$p(...)");
            ((A5) interfaceC2971z53).a(str4, "Unregister device mute event listener ...");
        }
        try {
            F7 mediaProcessor = this.f2731a.getMediaProcessor();
            if (mediaProcessor != null) {
                C2857s7 c2857s7 = mediaProcessor.d;
                if (c2857s7 != null) {
                    c2857s7.a();
                }
                mediaProcessor.d = null;
            }
        } catch (Exception e) {
            this.f2731a.a(str, "Unexpected error", "unRegisterDeviceMuteEventListener");
            InterfaceC2971z5 interfaceC2971z54 = this.c;
            if (interfaceC2971z54 != null) {
                String str5 = AbstractC2921w6.f2741a;
                ((A5) interfaceC2971z54).b(str5, rf.a(e, H6.a(str5, "access$getTAG$p(...)", "SDK encountered unexpected error in handling unregisterDeviceMuteEventListener() request from creative; ")));
            }
        }
    }

    @JavascriptInterface
    public final void unregisterDeviceVolumeChangeEventListener(String str) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str2, "unregisterDeviceVolumeChangeEventListener called");
        }
        if (this.f2731a == null) {
            InterfaceC2971z5 interfaceC2971z52 = this.c;
            if (interfaceC2971z52 != null) {
                String str3 = AbstractC2921w6.f2741a;
                Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
                ((A5) interfaceC2971z52).b(str3, "Found a null instance of render view!");
                return;
            }
            return;
        }
        InterfaceC2971z5 interfaceC2971z53 = this.c;
        if (interfaceC2971z53 != null) {
            String str4 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$p(...)");
            ((A5) interfaceC2971z53).a(str4, "Unregister device volume change listener ...");
        }
        try {
            F7 mediaProcessor = this.f2731a.getMediaProcessor();
            if (mediaProcessor != null) {
                C2857s7 c2857s7 = mediaProcessor.e;
                if (c2857s7 != null) {
                    c2857s7.a();
                }
                mediaProcessor.e = null;
            }
        } catch (Exception e) {
            this.f2731a.a(str, "Unexpected error", "unregisterDeviceVolumeChangeEventListener");
            InterfaceC2971z5 interfaceC2971z54 = this.c;
            if (interfaceC2971z54 != null) {
                String str5 = AbstractC2921w6.f2741a;
                ((A5) interfaceC2971z54).b(str5, rf.a(e, H6.a(str5, "access$getTAG$p(...)", "SDK encountered unexpected error in handling unregisterDeviceVolumeChangeEventListener() request from creative; ")));
            }
        }
    }

    @JavascriptInterface
    public final void unregisterHeadphonePluggedEventListener(String str) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str2, "unregisterHeadphonePluggedEventListener called");
        }
        if (this.f2731a == null) {
            InterfaceC2971z5 interfaceC2971z52 = this.c;
            if (interfaceC2971z52 != null) {
                String str3 = AbstractC2921w6.f2741a;
                Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
                ((A5) interfaceC2971z52).b(str3, "Found a null instance of render view!");
                return;
            }
            return;
        }
        InterfaceC2971z5 interfaceC2971z53 = this.c;
        if (interfaceC2971z53 != null) {
            String str4 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$p(...)");
            ((A5) interfaceC2971z53).a(str4, "Unregister headphone plugged event listener ...");
        }
        try {
            F7 mediaProcessor = this.f2731a.getMediaProcessor();
            if (mediaProcessor != null) {
                C2857s7 c2857s7 = mediaProcessor.f;
                if (c2857s7 != null) {
                    c2857s7.a();
                }
                mediaProcessor.f = null;
            }
        } catch (Exception e) {
            this.f2731a.a(str, "Unexpected error", "unregisterHeadphonePluggedEventListener");
            InterfaceC2971z5 interfaceC2971z54 = this.c;
            if (interfaceC2971z54 != null) {
                String str5 = AbstractC2921w6.f2741a;
                ((A5) interfaceC2971z54).b(str5, rf.a(e, H6.a(str5, "access$getTAG$p(...)", "SDK encountered unexpected error in handling unregisterHeadphonePluggedEventListener() request from creative; ")));
            }
        }
    }

    @JavascriptInterface
    public final void useCustomClose(final String str, final boolean z) {
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str2 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str2, "useCustomClose called:" + z);
        }
        final GestureDetectorOnGestureListenerC2634ec a2 = a();
        if (a2 != null) {
            new Handler(a2.getContainerContext().getMainLooper()).post(new Runnable() { // from class: com.inmobi.media.v6$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    C2905v6.b(GestureDetectorOnGestureListenerC2634ec.this, z, this, str);
                }
            });
            return;
        }
        this.f2731a.a(str, "Unexpected error", "useCustomClose");
        InterfaceC2971z5 interfaceC2971z52 = this.c;
        if (interfaceC2971z52 != null) {
            String str3 = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            ((A5) interfaceC2971z52).b(str3, "Found a null instance of render view!");
        }
    }

    @JavascriptInterface
    public final void zoom(String jsCallbackNamespace, final int i) {
        Intrinsics.checkNotNullParameter(jsCallbackNamespace, "jsCallbackNamespace");
        InterfaceC2971z5 interfaceC2971z5 = this.c;
        if (interfaceC2971z5 != null) {
            String str = AbstractC2921w6.f2741a;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).a(str, "zoom is called " + jsCallbackNamespace + ' ' + i);
        }
        Md.a(new Runnable() { // from class: com.inmobi.media.v6$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                C2905v6.a(C2905v6.this, i);
            }
        });
    }

    public static final void b(C2905v6 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.f2731a.r();
        } catch (Exception e) {
            InterfaceC2971z5 interfaceC2971z5 = this$0.c;
            if (interfaceC2971z5 != null) {
                String str = AbstractC2921w6.f2741a;
                ((A5) interfaceC2971z5).b(str, rf.a(e, H6.a(str, "access$getTAG$p(...)", "SDK encountered unexpected error in getting/setting current position; ")));
            }
        }
    }

    public final void a(final String str, final String str2, final int i, final float f, final boolean z, final R6 r6) {
        if (r6 != null) {
            r6.g = "IN_CUSTOM";
        }
        new Handler(this.f2731a.getContainerContext().getMainLooper()).post(new Runnable() { // from class: com.inmobi.media.v6$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                C2905v6.a(C2905v6.this, r6, str2, i, str, f, z);
            }
        });
    }

    public static final void a(C2905v6 this$0, R6 r6, String expandInput, int i, String str, float f, boolean z) {
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(expandInput, "$expandInput");
        try {
            if (this$0.f2731a.getEmbeddedBrowserJsCallbacks() == null) {
                InterfaceC2971z5 interfaceC2971z5 = this$0.c;
                if (interfaceC2971z5 != null) {
                    String str4 = AbstractC2921w6.f2741a;
                    Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$p(...)");
                    ((A5) interfaceC2971z5).b(str4, "Found a null instance of EmbeddedBrowserJSCallback instance to customExpand");
                }
                M6 landingPageHandler = this$0.f2731a.getLandingPageHandler();
                F6 funnelState = F6.e;
                Integer valueOf = Integer.valueOf(ConnectionsStatusCodes.STATUS_ALREADY_DISCOVERING);
                landingPageHandler.getClass();
                Intrinsics.checkNotNullParameter(funnelState, "funnelState");
                J6.a(funnelState, r6, valueOf, new L6(landingPageHandler));
                return;
            }
            InterfaceC2971z5 interfaceC2971z52 = this$0.c;
            if (interfaceC2971z52 != null) {
                String str5 = AbstractC2921w6.f2741a;
                Intrinsics.checkNotNullExpressionValue(str5, "access$getTAG$p(...)");
                ((A5) interfaceC2971z52).a(str5, "Custom expand called. Url: " + expandInput);
            }
            Z3 z3 = Z3.values()[i];
            try {
                if (z3 == Z3.f2503a) {
                    try {
                        int a2 = this$0.f2731a.getLandingPageHandler().a("customExpand", str, expandInput, r6, null);
                        InterfaceC2971z5 interfaceC2971z53 = this$0.c;
                        if (interfaceC2971z53 != null) {
                            String str6 = AbstractC2921w6.f2741a;
                            Intrinsics.checkNotNullExpressionValue(str6, "access$getTAG$p(...)");
                            ((A5) interfaceC2971z53).a(str6, "processCustomExpandRequest: " + a2);
                        }
                        if (a2 == 3) {
                            InterfaceC2557a4 embeddedBrowserJsCallbacks = this$0.f2731a.getEmbeddedBrowserJsCallbacks();
                            if (embeddedBrowserJsCallbacks != null) {
                                str3 = expandInput;
                                ((C2678h5) embeddedBrowserJsCallbacks).a(str3, z3, f, z, this$0.f2731a.getViewTouchTimestamp(), r6);
                            } else {
                                str3 = expandInput;
                            }
                            M6 landingPageHandler2 = this$0.f2731a.getLandingPageHandler();
                            F6 funnelState2 = F6.f;
                            landingPageHandler2.getClass();
                            Intrinsics.checkNotNullParameter(funnelState2, "funnelState");
                            J6.a(funnelState2, r6, (Integer) null, new L6(landingPageHandler2));
                            Ub ub = this$0.f2731a.getLandingPageHandler().d;
                            if (ub != null) {
                                GestureDetectorOnGestureListenerC2634ec.a(ub.f2452a, "customExpand", str, str3);
                                return;
                            }
                            return;
                        }
                        InterfaceC2557a4 embeddedBrowserJsCallbacks2 = this$0.f2731a.getEmbeddedBrowserJsCallbacks();
                        if (embeddedBrowserJsCallbacks2 != null) {
                            C2711j5.a(((C2678h5) embeddedBrowserJsCallbacks2).f2586a);
                            return;
                        }
                        return;
                    } catch (Exception e) {
                        e = e;
                        str2 = str;
                        this$0.f2731a.a(str2, "Unexpected error", "customExpand");
                        M6 landingPageHandler3 = this$0.f2731a.getLandingPageHandler();
                        F6 funnelState3 = F6.e;
                        landingPageHandler3.getClass();
                        Intrinsics.checkNotNullParameter(funnelState3, "funnelState");
                        J6.a(funnelState3, r6, (Integer) 9, (Function2) new L6(landingPageHandler3));
                        AbstractC2680h7.a((byte) 1, "InMobi", "Failed to custom expand ad; SDK encountered an unexpected error");
                        InterfaceC2971z5 interfaceC2971z54 = this$0.c;
                        if (interfaceC2971z54 != null) {
                            String str7 = AbstractC2921w6.f2741a;
                            ((A5) interfaceC2971z54).b(str7, rf.a(e, H6.a(str7, "access$getTAG$p(...)", "SDK encountered unexpected error in handling customExpand() request; ")));
                            return;
                        }
                        return;
                    }
                }
                InterfaceC2557a4 embeddedBrowserJsCallbacks3 = this$0.f2731a.getEmbeddedBrowserJsCallbacks();
                if (embeddedBrowserJsCallbacks3 != null) {
                    ((C2678h5) embeddedBrowserJsCallbacks3).a(expandInput, z3, f, z, this$0.f2731a.getViewTouchTimestamp(), r6);
                }
                M6 landingPageHandler4 = this$0.f2731a.getLandingPageHandler();
                F6 funnelState4 = F6.f;
                landingPageHandler4.getClass();
                Intrinsics.checkNotNullParameter(funnelState4, "funnelState");
                J6.a(funnelState4, r6, (Integer) null, new L6(landingPageHandler4));
                Ub ub2 = this$0.f2731a.getLandingPageHandler().d;
                if (ub2 != null) {
                    GestureDetectorOnGestureListenerC2634ec.a(ub2.f2452a, "customExpand", str, expandInput);
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            str2 = str;
        }
    }

    public static final void c(C2905v6 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.f2731a.s();
        } catch (Exception e) {
            InterfaceC2971z5 interfaceC2971z5 = this$0.c;
            if (interfaceC2971z5 != null) {
                String str = AbstractC2921w6.f2741a;
                ((A5) interfaceC2971z5).b(str, rf.a(e, H6.a(str, "access$getTAG$p(...)", "SDK encountered unexpected error in getting/setting default position; ")));
            }
        }
    }

    public static final void b(C2905v6 this$0, String json) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(json, "$orientationPropertiesString");
        C2844ra op = this$0.f2731a.getOrientationProperties();
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(op, "op");
        C2844ra c2844ra = new C2844ra();
        c2844ra.d = json;
        try {
            JSONObject jSONObject = new JSONObject(json);
            String optString = jSONObject.optString("forceOrientation", op.b);
            Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
            Intrinsics.checkNotNullParameter(optString, "<set-?>");
            c2844ra.b = optString;
            c2844ra.f2695a = jSONObject.optBoolean("allowOrientationChange", op.f2695a);
            String optString2 = jSONObject.optString("direction", op.c);
            Intrinsics.checkNotNullExpressionValue(optString2, "optString(...)");
            Intrinsics.checkNotNullParameter(optString2, "<set-?>");
            c2844ra.c = optString2;
            if (!Intrinsics.areEqual(c2844ra.b, C3040d4.h.D) && !Intrinsics.areEqual(c2844ra.b, C3040d4.h.C)) {
                Intrinsics.checkNotNullParameter("none", "<set-?>");
                c2844ra.b = "none";
            }
            if (!Intrinsics.areEqual(c2844ra.c, "left") && !Intrinsics.areEqual(c2844ra.c, "right")) {
                Intrinsics.checkNotNullParameter("right", "<set-?>");
                c2844ra.c = "right";
            }
        } catch (JSONException unused) {
            c2844ra = null;
        }
        if (c2844ra != null) {
            this$0.f2731a.getWebViewFactory().a(new C2889u6(this$0, c2844ra));
        }
    }

    public static final void c(C2905v6 this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.f2731a.getSiblingWebviewManager().b(this$0.f2731a.getRoute().b, str);
        } catch (Exception e) {
            this$0.f2731a.a("showWebView", AbstractC2815pc.a(str, Sdk.SDKError.Reason.ASSET_FAILED_TO_DELETE_VALUE));
            InterfaceC2971z5 interfaceC2971z5 = this$0.c;
            if (interfaceC2971z5 != null) {
                String str2 = AbstractC2921w6.f2741a;
                ((A5) interfaceC2971z5).b(str2, rf.a(e, H6.a(str2, "access$getTAG$p(...)", "SDK encountered unexpected error in handling showEndCard() request from creative; ")));
            }
        }
    }

    public static final void b(GestureDetectorOnGestureListenerC2634ec adRenderView, boolean z, C2905v6 this$0, String str) {
        Intrinsics.checkNotNullParameter(adRenderView, "$adRenderView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            adRenderView.e(z);
        } catch (Exception e) {
            this$0.f2731a.a(str, "Unexpected error", "useCustomClose");
            InterfaceC2971z5 interfaceC2971z5 = this$0.c;
            if (interfaceC2971z5 != null) {
                String str2 = AbstractC2921w6.f2741a;
                ((A5) interfaceC2971z5).b(str2, rf.a(e, H6.a(str2, "access$getTAG$p(...)", "SDK encountered internal error in handling useCustomClose() request from creative; ")));
            }
        }
    }

    public static final void a(C2905v6 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.f2731a.getEmbeddedBrowserJsCallbacks() == null) {
            InterfaceC2971z5 interfaceC2971z5 = this$0.c;
            if (interfaceC2971z5 != null) {
                String str = AbstractC2921w6.f2741a;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
                ((A5) interfaceC2971z5).b(str, "Found a null instance of EmbeddedBrowserJSCallback instance to closeCustomExpand");
                return;
            }
            return;
        }
        InterfaceC2557a4 embeddedBrowserJsCallbacks = this$0.f2731a.getEmbeddedBrowserJsCallbacks();
        if (embeddedBrowserJsCallbacks != null) {
            C2711j5.a(((C2678h5) embeddedBrowserJsCallbacks).f2586a);
        }
    }

    public static final void a(GestureDetectorOnGestureListenerC2634ec it, C2905v6 this$0, String str) {
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            it.i();
        } catch (Exception e) {
            this$0.f2731a.a(str, "Unexpected error", "close");
            AbstractC2680h7.a((byte) 1, "InMobi", "Failed to close ad; SDK encountered an unexpected error");
            InterfaceC2971z5 interfaceC2971z5 = this$0.c;
            if (interfaceC2971z5 != null) {
                String str2 = AbstractC2921w6.f2741a;
                ((A5) interfaceC2971z5).b(str2, rf.a(e, H6.a(str2, "access$getTAG$p(...)", "SDK encountered an expected error in handling the close() request from creative; ")));
            }
        }
    }

    public static final void a(GestureDetectorOnGestureListenerC2634ec adRenderView, boolean z, C2905v6 this$0, String str) {
        Intrinsics.checkNotNullParameter(adRenderView, "$adRenderView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            adRenderView.d(z);
        } catch (Exception e) {
            this$0.f2731a.a(str, "Unexpected error", "disableCloseRegion");
            InterfaceC2971z5 interfaceC2971z5 = this$0.c;
            if (interfaceC2971z5 != null) {
                String str2 = AbstractC2921w6.f2741a;
                ((A5) interfaceC2971z5).b(str2, rf.a(e, H6.a(str2, "access$getTAG$p(...)", "SDK encountered unexpected error in handling disableCloseRegion() request from creative; ")));
            }
        }
    }

    public static final void a(C2905v6 this$0, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f2731a.setInitialScale(i);
    }

    public static final void a(C2905v6 this$0, String str, String str2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.f2731a.getSiblingWebviewManager().a(this$0.f2731a.getRoute().b, str, str2);
        } catch (Exception e) {
            this$0.f2731a.a("loadWebView", AbstractC2815pc.a(str, 308));
            InterfaceC2971z5 interfaceC2971z5 = this$0.c;
            if (interfaceC2971z5 != null) {
                String str3 = AbstractC2921w6.f2741a;
                ((A5) interfaceC2971z5).b(str3, rf.a(e, H6.a(str3, "access$getTAG$p(...)", "SDK encountered unexpected error in handling loadWebView() request from creative; ")));
            }
        }
    }

    public static final void a(C2905v6 this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.f2731a.getSiblingWebviewManager().a(this$0.f2731a.getRoute().b, str);
        } catch (Exception e) {
            this$0.f2731a.a("destroyWebView", AbstractC2815pc.a(str, Sdk.SDKError.Reason.MRAID_JS_CALL_EMPTY_VALUE));
            InterfaceC2971z5 interfaceC2971z5 = this$0.c;
            if (interfaceC2971z5 != null) {
                String str2 = AbstractC2921w6.f2741a;
                ((A5) interfaceC2971z5).b(str2, rf.a(e, H6.a(str2, "access$getTAG$p(...)", "SDK encountered unexpected error in handling destroyWebView() request from creative; ")));
            }
        }
    }
}
