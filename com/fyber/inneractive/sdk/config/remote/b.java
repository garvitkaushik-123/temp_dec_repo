package com.fyber.inneractive.sdk.config.remote;

import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public UnitDisplayType f1116a;
    public Boolean b;
    public Integer c;
    public Integer d;

    public static b a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        int optInt = jSONObject.optInt("hide", Integer.MIN_VALUE);
        Integer valueOf = Integer.valueOf(optInt);
        int optInt2 = jSONObject.optInt(ToolBar.REFRESH, Integer.MIN_VALUE);
        Integer valueOf2 = Integer.valueOf(optInt2);
        bVar.f1116a = UnitDisplayType.fromValue(jSONObject.optString("unitDisplayType"));
        bVar.b = jSONObject.has("close") ? Boolean.valueOf(jSONObject.optBoolean("close", true)) : null;
        if (optInt == Integer.MIN_VALUE) {
            valueOf = null;
        }
        bVar.d = valueOf;
        bVar.c = optInt2 != Integer.MIN_VALUE ? valueOf2 : null;
        return bVar;
    }
}
