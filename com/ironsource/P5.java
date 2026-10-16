package com.ironsource;

import android.content.Context;
import com.ironsource.C3040d4;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.server.HttpFunctions;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class P5 implements InterfaceC3335uc {

    /* renamed from: a, reason: collision with root package name */
    private boolean f2991a = true;
    private String b = Q5.j;

    public static final class a implements InterfaceC3077f7 {
        a() {
        }

        @Override // com.ironsource.InterfaceC3077f7
        public void a(boolean z) {
            if (z) {
                return;
            }
            IronLog.API.error("failed to send impression data");
        }
    }

    private final JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Ma.o, "android");
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        if (applicationContext != null) {
            jSONObject.put("deviceType", IronSourceUtils.getDeviceType(applicationContext));
            G9 ironSourceAdvId = IronSourceUtils.getIronSourceAdvId(applicationContext);
            if (ironSourceAdvId != null) {
                jSONObject.put("advId", ironSourceAdvId.c());
                jSONObject.put("advIdType", ironSourceAdvId.d());
            }
        }
        String k = com.ironsource.mediationsdk.p.j().k();
        if (k != null) {
            jSONObject.put(C3040d4.i.g, k);
        }
        return jSONObject;
    }

    @Override // com.ironsource.InterfaceC3335uc
    public void a() {
    }

    public final void a(String dataSource, JSONObject impressionData) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        Intrinsics.checkNotNullParameter(impressionData, "impressionData");
        if (!this.f2991a) {
            IronLog.INTERNAL.verbose("disabled from server");
            return;
        }
        try {
            JSONObject b = b();
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("externalMediationSource", dataSource);
            jSONObject.putOpt("externalMediationData", impressionData);
            jSONObject.putOpt("clientParams", b);
            IronLog.API.info("impressionData: " + jSONObject);
            HttpFunctions.sendPostRequest(this.b, jSONObject.toString(), new a());
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.API.error("exception " + e.getMessage() + " sending impression data");
        }
    }

    @Override // com.ironsource.InterfaceC3335uc
    public void e(String str) {
    }

    @Override // com.ironsource.InterfaceC3335uc
    public void a(List<IronSource.AD_UNIT> list, boolean z, U3 u3) {
        if (u3 != null) {
            A1 b = u3.b();
            K1 f = b != null ? b.f() : null;
            Intrinsics.checkNotNull(f);
            this.f2991a = f.l();
            this.b = u3.b().f().d();
        }
    }
}
