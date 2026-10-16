package com.fyber.inneractive.sdk.flow;

import android.text.TextUtils;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.util.IAlog;
import com.ironsource.unity.androidbridge.AndroidBridgeConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f1242a;

    public v(w wVar) {
        this.f1242a = wVar;
    }

    public final void a(com.fyber.inneractive.sdk.network.u uVar, com.fyber.inneractive.sdk.ignite.m mVar) {
        w wVar = this.f1242a;
        InneractiveAdRequest inneractiveAdRequest = wVar.f1249a;
        com.fyber.inneractive.sdk.response.e eVar = wVar.b;
        com.fyber.inneractive.sdk.config.global.r rVar = wVar.c;
        JSONArray b = rVar != null ? rVar.b() : null;
        com.fyber.inneractive.sdk.network.w wVar2 = new com.fyber.inneractive.sdk.network.w(eVar);
        wVar2.c = uVar;
        wVar2.f1340a = inneractiveAdRequest;
        wVar2.d = b;
        JSONObject jSONObject = new JSONObject();
        String a2 = mVar.a();
        try {
            jSONObject.put("ignitem", a2);
        } catch (Exception unused) {
            IAlog.f("Got exception adding param to json object: %s, %s", "ignitem", a2);
        }
        wVar2.f.put(jSONObject);
        wVar2.a((String) null);
    }

    public final void a(com.fyber.inneractive.sdk.network.t tVar, String str, String str2, com.fyber.inneractive.sdk.ignite.m mVar) {
        w wVar = this.f1242a;
        InneractiveAdRequest inneractiveAdRequest = wVar.f1249a;
        com.fyber.inneractive.sdk.response.e eVar = wVar.b;
        com.fyber.inneractive.sdk.config.global.r rVar = wVar.c;
        JSONArray b = rVar != null ? rVar.b() : null;
        com.fyber.inneractive.sdk.network.w wVar2 = new com.fyber.inneractive.sdk.network.w(eVar);
        wVar2.b = tVar;
        wVar2.f1340a = inneractiveAdRequest;
        wVar2.d = b;
        JSONObject jSONObject = new JSONObject();
        if (mVar != null) {
            String a2 = mVar.a();
            try {
                jSONObject.put("ignitem", a2);
            } catch (Exception unused) {
                IAlog.f("Got exception adding param to json object: %s, %s", "ignitem", a2);
            }
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject.put(PglCryptUtils.KEY_MESSAGE, str);
            } catch (Exception unused2) {
                IAlog.f("Got exception adding param to json object: %s, %s", PglCryptUtils.KEY_MESSAGE, str);
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            try {
                jSONObject.put(AndroidBridgeConstants.ERROR_CODE, str2);
            } catch (Exception unused3) {
                IAlog.f("Got exception adding param to json object: %s, %s", AndroidBridgeConstants.ERROR_CODE, str2);
            }
        }
        wVar2.f.put(jSONObject);
        wVar2.a((String) null);
    }
}
