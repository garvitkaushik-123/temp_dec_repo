package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ironsource.xe, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3388xe {

    /* renamed from: a, reason: collision with root package name */
    private C2988a6 f3940a;

    /* renamed from: com.ironsource.xe$a */
    private final class a extends RunnableC3371we {
        public a() {
        }

        @Override // com.ironsource.RunnableC3371we, java.lang.Runnable
        public void run() {
            JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
            try {
                mediationAdditionalData.put("duration", a());
            } catch (JSONException e) {
                C3260q4.d().a(e);
                IronLog.INTERNAL.error(e.toString());
            }
            Qc.P.a(new C3413z5(A5.APP_ENTER_BACKGROUND, mediationAdditionalData));
        }
    }

    public final void a(InterfaceC3144j7 applicationLifecycleService) {
        Intrinsics.checkNotNullParameter(applicationLifecycleService, "applicationLifecycleService");
        this.f3940a = new C2988a6(applicationLifecycleService, new a());
    }
}
