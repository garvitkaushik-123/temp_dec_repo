package com.ironsource;

import android.content.Context;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.ironsourceads.InitListener;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class X implements W {

    /* renamed from: a, reason: collision with root package name */
    private final Yb f3117a;

    public static final class a implements InterfaceC3352vc {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ V8 f3118a;
        final /* synthetic */ InitListener b;

        a(V8 v8, InitListener initListener) {
            this.f3118a = v8;
            this.b = initListener;
        }

        @Override // com.ironsource.InterfaceC3352vc
        public void onFail(C3247p8 error) {
            Intrinsics.checkNotNullParameter(error, "error");
            IronLog.ADAPTER_API.verbose("initSDKWithNetworkConfigurations error: " + error);
            this.b.onInitFailed(C3362w5.f3920a.a(new IronSourceError(error.a(), error.b())));
        }

        @Override // com.ironsource.InterfaceC3352vc
        public void onSuccess() {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose("initSDKWithNetworkConfigurations success");
            V e = this.f3118a.e();
            ironLog.verbose("controllerURL = " + (e != null ? e.c() : null));
            V e2 = this.f3118a.e();
            ironLog.verbose("controllerConfig = " + (e2 != null ? e2.a() : null));
            V e3 = this.f3118a.e();
            ironLog.verbose("debugMode = " + (e3 != null ? Integer.valueOf(e3.b()) : null));
            ironLog.verbose("applicationKey = " + this.f3118a.d());
            ironLog.verbose("userId = " + this.f3118a.h());
            this.b.onInitSuccess();
        }
    }

    public X(Yb networkInitApi) {
        Intrinsics.checkNotNullParameter(networkInitApi, "networkInitApi");
        this.f3117a = networkInitApi;
    }

    @Override // com.ironsource.W
    public void a(Context context, V8 initConfig, InitListener initListener) {
        JSONObject a2;
        String c;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initConfig, "initConfig");
        Intrinsics.checkNotNullParameter(initListener, "initListener");
        Yb yb = this.f3117a;
        V e = initConfig.e();
        yb.a(e != null ? e.b() : 0);
        V e2 = initConfig.e();
        if (e2 != null && (c = e2.c()) != null) {
            this.f3117a.b(c);
        }
        V e3 = initConfig.e();
        if (e3 != null && (a2 = e3.a()) != null) {
            Yb yb2 = this.f3117a;
            String jSONObject = a2.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "applicationConfig.toString()");
            yb2.a(jSONObject);
        }
        Map<String, String> a3 = new Wb().a();
        this.f3117a.a(new a(initConfig, initListener));
        this.f3117a.a(context, initConfig.d(), initConfig.h(), a3);
    }
}
