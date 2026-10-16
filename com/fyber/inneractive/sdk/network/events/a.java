package com.fyber.inneractive.sdk.network.events;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.network.t;
import com.fyber.inneractive.sdk.network.w;
import com.fyber.inneractive.sdk.network.x;
import com.fyber.inneractive.sdk.response.e;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;

/* loaded from: classes4.dex */
public abstract class a {
    public static void a(t tVar, String str, String str2, InneractiveAdRequest inneractiveAdRequest, e eVar, HashMap hashMap, Boolean bool) {
        w wVar = new w(tVar, inneractiveAdRequest, eVar);
        x xVar = new x();
        if (bool != null) {
            xVar.a(bool, "loaded_from_cache");
        }
        xVar.a(str, IronSourceConstants.EVENTS_ERROR_CODE).a(str2, "templateURL");
        if (hashMap != null && !hashMap.isEmpty()) {
            for (String str3 : hashMap.keySet()) {
                String str4 = (String) hashMap.get(str3);
                if (!TextUtils.isEmpty(str4)) {
                    xVar.a(str4, str3);
                }
            }
        }
        wVar.f.put(xVar.f1342a);
        wVar.a((String) null);
    }

    public static void a(t tVar, b bVar, InneractiveAdRequest inneractiveAdRequest, e eVar, String str, String str2, Boolean bool) {
        w wVar = new w(tVar, inneractiveAdRequest, eVar);
        x xVar = new x();
        xVar.a(bVar.name(), IronSourceConstants.EVENTS_ERROR_CODE);
        if (!TextUtils.isEmpty(str2)) {
            xVar.a(str2, "templateURL");
        }
        if (!TextUtils.isEmpty(str)) {
            xVar.a(str, "error");
        }
        if (bool != null) {
            xVar.a(bool, "loaded_from_cache");
        }
        wVar.f.put(xVar.f1342a);
        wVar.a((String) null);
    }
}
