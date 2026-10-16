package com.ironsource;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.ironsource.C3337ue;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.p;
import com.ironsource.mediationsdk.server.HttpFunctions;
import com.ironsource.mediationsdk.server.ServerURL;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceAES;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ironsource.se, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3303se {
    private final C3084fe b(Context context, C3168ke c3168ke, C2996ae c2996ae) {
        C3084fe a2 = a(context, c3168ke, c2996ae);
        if (a2.c()) {
            return a2;
        }
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        logger.log(ironSourceTag, "Null or invalid response. Trying to get cached response", 0);
        C3337ue a3 = c3168ke.a(context, c2996ae.d());
        if (a3 == null) {
            return a2;
        }
        C3084fe c3084fe = new C3084fe(new C3013be(a3));
        IronSourceLoggerManager.getLogger().log(ironSourceTag, ErrorBuilder.buildUsingCachedConfigurationError(c2996ae.d(), c2996ae.f()) + ": " + c3084fe.b(), 1);
        c3168ke.g();
        return c3084fe;
    }

    public final void a(Context context, C2996ae request, C3168ke tools, Yd listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(tools, "tools");
        Intrinsics.checkNotNullParameter(listener, "listener");
        String f = request.f();
        if (f == null) {
            f = "";
        }
        tools.a("userId", f);
        tools.a("appKey", request.d());
        tools.c().i(request.f());
        tools.a();
        C3084fe b = b(context, tools, request);
        if (b.b() == null) {
            Ud a2 = b.a();
            if (a2 == null) {
                a2 = new Ud(510, "unknown error");
            }
            listener.a(a2);
            return;
        }
        Sd sd = new Sd(b.b());
        if (b.c()) {
            listener.a(sd);
        } else {
            listener.a(new Ud(Ud.e, "serverResponseIsNotValid"));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final C3084fe a(Context context, C3168ke c3168ke, C2996ae c2996ae) {
        Ud ud;
        try {
            String a2 = c3168ke.a(context);
            if (TextUtils.isEmpty(a2)) {
                a2 = c3168ke.b(context);
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "using custom identifier", 1);
            }
            String str = a2;
            IronSourceSegment d = c3168ke.d();
            ArrayList<Pair<String, String>> segmentData = d != null ? d.getSegmentData() : null;
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            String sendPostRequest = HttpFunctions.sendPostRequest(ServerURL.buildInitURL(context, c2996ae.d(), c2996ae.f(), str, null, true, segmentData, false), C2991a9.a().toString(), new p.c() { // from class: com.ironsource.se$$ExternalSyntheticLambda0
                @Override // com.ironsource.mediationsdk.p.c
                public final void a(String str2) {
                    C3303se.a(Ref.ObjectRef.this, str2);
                }
            });
            if (sendPostRequest == null) {
                IronLog.INTERNAL.warning("serverResponseString is null");
                return new C3084fe(a((String) objectRef.element));
            }
            if (c3168ke.e()) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose("encrypt");
                JSONObject jSONObject = new JSONObject(sendPostRequest);
                String encryptedResponse = jSONObject.optString(C3337ue.n);
                if (TextUtils.isEmpty(encryptedResponse)) {
                    ironLog.warning("encryptedResponse is empty - return null");
                    return new C3084fe(new Ud(2100, Xd.h));
                }
                boolean optBoolean = jSONObject.optBoolean("compression", false);
                Intrinsics.checkNotNullExpressionValue(encryptedResponse, "encryptedResponse");
                sendPostRequest = a(encryptedResponse, optBoolean);
                if (TextUtils.isEmpty(sendPostRequest)) {
                    ironLog.warning("encoded response invalid - return null");
                    c3168ke.f();
                    return new C3084fe(new Ud(Ud.f, Xd.g));
                }
            }
            C3337ue c3337ue = new C3337ue(context, c2996ae.d(), c2996ae.f(), sendPostRequest);
            c3337ue.a(C3337ue.a.SERVER);
            if (!c3337ue.p()) {
                IronLog.INTERNAL.warning("response invalid - return null");
                return new C3084fe(new Ud(Ud.e, "serverResponseIsNotValid"));
            }
            return new C3084fe(new C3013be(c3337ue));
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.warning("exception = " + e);
            if (e instanceof JSONException) {
                ud = new Ud(Ud.e, "serverResponseIsNotValid");
            } else {
                ud = new Ud(510, "internal error");
            }
            return new C3084fe(ud);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(Ref.ObjectRef reason, String errorMessage) {
        Intrinsics.checkNotNullParameter(reason, "$reason");
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        reason.element = errorMessage;
    }

    private final String a(String str, boolean z) {
        if (z) {
            String decryptAndDecompress = IronSourceAES.decryptAndDecompress(C3193m5.b().c(), str);
            Intrinsics.checkNotNullExpressionValue(decryptAndDecompress, "{\n      IronSourceAES.de… encryptedResponse)\n    }");
            return decryptAndDecompress;
        }
        String decode = IronSourceAES.decode(C3193m5.b().c(), str);
        Intrinsics.checkNotNullExpressionValue(decode, "{\n      IronSourceAES.de… encryptedResponse)\n    }");
        return decode;
    }

    private final Ud a(String str) {
        if (str != null) {
            return new Ud(Ud.h, str);
        }
        return new Ud(Ud.d, "noServerResponse");
    }
}
