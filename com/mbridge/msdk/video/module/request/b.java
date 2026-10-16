package com.mbridge.msdk.video.module.request;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.net.wrapper.e;
import com.mbridge.msdk.foundation.tools.j0;
import com.mbridge.msdk.setting.h;
import org.json.JSONObject;

/* compiled from: VideoViewRequest.java */
/* loaded from: classes6.dex */
public class b extends a {
    public b(Context context) {
        super(context);
    }

    @Override // com.mbridge.msdk.video.module.request.a, com.mbridge.msdk.foundation.same.net.wrapper.c
    public void addExtraParams(String str, e eVar) {
        super.addExtraParams(str, eVar);
        if (h.b().d(c.m().b()) != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (TextUtils.isEmpty(jSONObject.toString())) {
                    return;
                }
                String b = j0.b(jSONObject.toString());
                if (TextUtils.isEmpty(b)) {
                    return;
                }
                eVar.a("dvi", b);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
