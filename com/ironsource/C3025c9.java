package com.ironsource;

import android.content.Context;
import com.ironsource.C3337ue;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ironsource.c9, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3025c9 {

    /* renamed from: a, reason: collision with root package name */
    public static final a f3226a = new a(null);

    /* renamed from: com.ironsource.c9$a */
    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final JSONObject a(Context context) {
            try {
                return new JSONObject(IronSourceUtils.getLastResponse(context));
            } catch (JSONException unused) {
                return new JSONObject();
            }
        }

        @JvmStatic
        public final boolean b(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            F3 d = d(context);
            return d.d().length() > 0 && d.e().length() > 0;
        }

        @JvmStatic
        public final C3337ue c(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            F3 d = d(context);
            if (d.d().length() <= 0 || d.e().length() <= 0) {
                d = null;
            }
            if (d == null) {
                return null;
            }
            C3337ue c3337ue = new C3337ue(context, d.d(), d.f(), d.e());
            c3337ue.a(C3337ue.a.CACHE);
            return c3337ue;
        }

        @JvmStatic
        public final F3 d(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            JSONObject a2 = a(context);
            String cachedAppKey = a2.optString("appKey");
            String cachedUserId = a2.optString("userId");
            String cachedSettings = a2.optString(C3337ue.n);
            Intrinsics.checkNotNullExpressionValue(cachedAppKey, "cachedAppKey");
            Intrinsics.checkNotNullExpressionValue(cachedUserId, "cachedUserId");
            Intrinsics.checkNotNullExpressionValue(cachedSettings, "cachedSettings");
            return new F3(cachedAppKey, cachedUserId, cachedSettings);
        }

        private a() {
        }
    }

    @JvmStatic
    public static final boolean a(Context context) {
        return f3226a.b(context);
    }

    @JvmStatic
    public static final C3337ue b(Context context) {
        return f3226a.c(context);
    }

    @JvmStatic
    public static final F3 c(Context context) {
        return f3226a.d(context);
    }
}
