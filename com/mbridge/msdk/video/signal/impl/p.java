package com.mbridge.msdk.video.signal.impl;

import com.ironsource.C3040d4;
import com.mbridge.msdk.foundation.tools.s;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: JSRewardVideoV1Diff.java */
/* loaded from: classes6.dex */
public class p extends g {
    public void a(JSONObject jSONObject) {
        try {
            jSONObject.put(C3040d4.h.G, new s(com.mbridge.msdk.foundation.controller.c.m().d()).a());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
