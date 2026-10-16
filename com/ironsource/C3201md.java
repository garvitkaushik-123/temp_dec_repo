package com.ironsource;

import android.adservices.measurement.MeasurementManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.OutcomeReceiver;
import com.ironsource.C3040d4;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.unity3d.mediation.LevelPlay;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* renamed from: com.ironsource.md, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3201md {

    /* renamed from: a, reason: collision with root package name */
    private final B7 f3479a;
    private final Function0<Long> b;
    private final H7 c;
    private final Executor d;

    /* renamed from: com.ironsource.md$a */
    /* synthetic */ class a extends FunctionReferenceImpl implements Function0<Long> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f3480a = new a();

        a() {
            super(0, System.class, "currentTimeMillis", "currentTimeMillis()J", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Long invoke() {
            return Long.valueOf(System.currentTimeMillis());
        }
    }

    /* renamed from: com.ironsource.md$b */
    public static final class b implements OutcomeReceiver<Object, Exception> {
        b() {
        }

        @Override // android.os.OutcomeReceiver
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(Exception error) {
            Intrinsics.checkNotNullParameter(error, "error");
            C3201md.this.a(error.getMessage());
        }

        @Override // android.os.OutcomeReceiver
        public void onResult(Object obj) {
            C3201md.this.c();
        }
    }

    public C3201md() {
        this(null, null, null, null, 15, null);
    }

    private final boolean b(Context context) {
        return IronSourceUtils.getFirstSession(context);
    }

    private final void d() {
        this.f3479a.a(new C3413z5(A5.REGISTER_TRIGGER, (JSONObject) null));
    }

    public final void c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        d();
        try {
            MeasurementManager a2 = C3137j0.a(context);
            if (a2 == null) {
                a("could not obtain measurement manager");
            } else {
                a2.registerTrigger(a(context), this.d, a());
            }
        } catch (Exception e) {
            a(e.getMessage());
            C3260q4.d().a(e);
        }
    }

    public C3201md(B7 eventManager, Function0<Long> getTimeFunction, H7 serviceProvider, Executor executor) {
        Intrinsics.checkNotNullParameter(eventManager, "eventManager");
        Intrinsics.checkNotNullParameter(getTimeFunction, "getTimeFunction");
        Intrinsics.checkNotNullParameter(serviceProvider, "serviceProvider");
        Intrinsics.checkNotNullParameter(executor, "executor");
        this.f3479a = eventManager;
        this.b = getTimeFunction;
        this.c = serviceProvider;
        this.d = executor;
    }

    private final String b() {
        ConcurrentHashMap<String, List<String>> c = Z9.b().c();
        List<String> list = c != null ? c.get(com.ironsource.mediationsdk.metadata.a.b) : null;
        String str = list != null ? (String) CollectionsKt.first((List) list) : null;
        return str == null ? "" : str;
    }

    private final Uri a(Context context) {
        InterfaceC3381x7 i = this.c.i();
        String connectionType = IronSourceUtils.getConnectionType(context);
        Uri build = new Uri.Builder().scheme("https").authority("android-att.ironsrc.mobi").path("register_trigger").appendQueryParameter("osVersion", Build.VERSION.RELEASE).appendQueryParameter("apiLevel", String.valueOf(Build.VERSION.SDK_INT)).appendQueryParameter("deviceModel", Build.MODEL).appendQueryParameter("sdkVersion", LevelPlay.getSdkVersion()).appendQueryParameter("bundleID", context.getPackageName()).appendQueryParameter("gaid", i.I(context)).appendQueryParameter(N6.K0, i.y(context)).appendQueryParameter("auid", i.d(context)).appendQueryParameter("isFirstSession", String.valueOf(b(context))).appendQueryParameter("coppa", b()).appendQueryParameter(N6.i0, String.valueOf(C3137j0.a())).appendQueryParameter("origin", "1").appendQueryParameter("timestamp", String.valueOf(this.b.invoke().longValue())).appendQueryParameter(C3040d4.i.x, i.c(context)).appendQueryParameter("deviceCarrier", i.u(context)).appendQueryParameter("connectionType", connectionType).appendQueryParameter(Z3.b, String.valueOf(StringsKt.equals(connectionType, Z3.b, true))).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n        .schem…arameter\n        .build()");
        return build;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ C3201md(B7 b7, Function0 function0, H7 h7, Executor executor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(b7, function0, h7, executor);
        b7 = (i & 1) != 0 ? C3334ub.s.d().q() : b7;
        function0 = (i & 2) != 0 ? a.f3480a : function0;
        h7 = (i & 4) != 0 ? C3334ub.s.d() : h7;
        if ((i & 8) != 0) {
            executor = Executors.newSingleThreadExecutor();
            Intrinsics.checkNotNullExpressionValue(executor, "newSingleThreadExecutor()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        this.f3479a.a(new C3413z5(A5.REGISTER_TRIGGER_SUCCESS, (JSONObject) null));
    }

    private final OutcomeReceiver<Object, Exception> a() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str) {
        this.f3479a.a(new C3413z5(A5.REGISTER_TRIGGER_FAIL, new JSONObject().put("reason", str)));
    }
}
