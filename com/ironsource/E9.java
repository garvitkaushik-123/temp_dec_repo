package com.ironsource;

import android.content.Context;
import com.ironsource.C3337ue;
import com.ironsource.V;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.unity3d.ironsourceads.InitListener;
import com.unity3d.ironsourceads.InitRequest;
import java.util.ArrayList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class E9 {

    /* renamed from: a, reason: collision with root package name */
    public static final E9 f2845a = new E9();
    private static final C3045d9 b = new C3045d9();

    public static final class a implements InitListener {
        a() {
        }

        @Override // com.unity3d.ironsourceads.InitListener
        public void onInitFailed(IronSourceError error) {
            Intrinsics.checkNotNullParameter(error, "error");
        }

        @Override // com.unity3d.ironsourceads.InitListener
        public void onInitSuccess() {
        }
    }

    private E9() {
    }

    public static final class b implements Yd {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f2846a;
        final /* synthetic */ C3126i5 b;
        final /* synthetic */ InitListener c;

        b(Context context, C3126i5 c3126i5, InitListener initListener) {
            this.f2846a = context;
            this.b = c3126i5;
            this.c = initListener;
        }

        @Override // com.ironsource.Yd
        public void a(Sd sdkConfig) {
            Intrinsics.checkNotNullParameter(sdkConfig, "sdkConfig");
            E9.f2845a.a(this.f2846a, sdkConfig.d(), this.b, this.c);
        }

        @Override // com.ironsource.Yd
        public void a(Ud error) {
            Intrinsics.checkNotNullParameter(error, "error");
            E9.f2845a.a(this.c, this.b, error);
        }
    }

    public final void a(final Context context, final InitRequest initRequest, final InitListener initializationListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initRequest, "initRequest");
        Intrinsics.checkNotNullParameter(initializationListener, "initializationListener");
        IronLog.API.info("IronSourceAds.init() appkey: " + initRequest.getAppKey() + ", legacyAdFormats: " + initRequest.getLegacyAdFormats() + ", context: " + context.getClass().getSimpleName());
        b.a(new Runnable() { // from class: com.ironsource.E9$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                E9.a(InitRequest.this, context, initializationListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(InitRequest initRequest, Context context, InitListener initializationListener) {
        Intrinsics.checkNotNullParameter(initRequest, "$initRequest");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(initializationListener, "$initializationListener");
        C3126i5 c3126i5 = new C3126i5();
        C3118he.f3342a.c(context, new C2996ae(initRequest.getAppKey(), null, ArraysKt.toMutableList(b.a(initRequest.getLegacyAdFormats())), 2, null), new b(context, c3126i5, initializationListener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Context context, C3337ue c3337ue, C3126i5 c3126i5, InitListener initListener) {
        String r = com.ironsource.mediationsdk.p.j().r();
        V8 f = c3337ue.f();
        Intrinsics.checkNotNullExpressionValue(f, "serverResponse.initialConfiguration");
        NetworkSettings b2 = c3337ue.k().b("IronSource");
        Intrinsics.checkNotNullExpressionValue(b2, "serverResponse.providerS…s.IRONSOURCE_CONFIG_NAME)");
        JSONObject interstitialSettings = b2.getInterstitialSettings();
        Intrinsics.checkNotNullExpressionValue(interstitialSettings, "networkSettings.interstitialSettings");
        f.a(new V.a(interstitialSettings));
        f.a(ConfigFile.getConfigFile().getPluginType());
        f.b(r);
        new X(new Zb()).a(context, f, new a());
        a(c3337ue, c3126i5, initListener);
    }

    private final void a(C3337ue c3337ue, C3126i5 c3126i5, final InitListener initListener) {
        J1 e;
        A1 b2 = c3337ue.c().b();
        new C3351vb().a((b2 == null || (e = b2.e()) == null) ? null : e.b(), true);
        String sessionId = com.ironsource.mediationsdk.p.j().r();
        Sb a2 = Sb.e.a();
        a2.a(c3337ue.k());
        a2.a(c3337ue.c());
        Intrinsics.checkNotNullExpressionValue(sessionId, "sessionId");
        a2.a(sessionId);
        a2.g();
        long a3 = C3126i5.a(c3126i5);
        C3045d9 c3045d9 = b;
        C3337ue.a h = c3337ue.h();
        Intrinsics.checkNotNullExpressionValue(h, "serverResponse.origin");
        c3045d9.a(a3, h);
        c3045d9.b(new Runnable() { // from class: com.ironsource.E9$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                E9.a(InitListener.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(InitListener initListener) {
        IronLog.CALLBACK.info("InitListener.onInitSuccess()");
        if (initListener != null) {
            initListener.onInitSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final InitListener initListener, C3126i5 c3126i5, final Ud ud) {
        long a2 = C3126i5.a(c3126i5);
        C3045d9 c3045d9 = b;
        c3045d9.a(ud, a2);
        c3045d9.b(new Runnable() { // from class: com.ironsource.E9$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                E9.a(Ud.this, initListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Ud error, InitListener initListener) {
        Intrinsics.checkNotNullParameter(error, "$error");
        IronLog.CALLBACK.info("InitListener.onInitFailed() error " + error);
        if (initListener != null) {
            initListener.onInitFailed(b.a(error));
        }
    }

    public final void a(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        ArrayList arrayList = new ArrayList();
        arrayList.add(value);
        com.ironsource.mediationsdk.p.j().a(key, arrayList);
    }
}
