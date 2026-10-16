package com.fyber.inneractive.sdk.config;

import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.util.a1;
import com.fyber.inneractive.sdk.util.z0;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class l0 implements z0 {

    /* renamed from: a, reason: collision with root package name */
    public Integer f1105a = null;
    public UnitDisplayType b;
    public Boolean c;
    public Integer d;

    @Override // com.fyber.inneractive.sdk.util.z0
    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        a1.a(jSONObject, ToolBar.REFRESH, this.f1105a);
        a1.a(jSONObject, "unitDisplayType", this.b);
        a1.a(jSONObject, "close", this.c);
        a1.a(jSONObject, "hideDelay", this.d);
        return jSONObject;
    }
}
