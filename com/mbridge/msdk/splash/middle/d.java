package com.mbridge.msdk.splash.middle;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.j;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.out.MBSplashShowListener;
import com.mbridge.msdk.out.MBridgeIds;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SplashShowListenerImpl.java */
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private MBSplashShowListener f4756a;
    private CampaignEx b;
    private c c;

    public d(c cVar, MBSplashShowListener mBSplashShowListener, CampaignEx campaignEx) {
        this.c = cVar;
        this.f4756a = mBSplashShowListener;
        this.b = campaignEx;
    }

    public void a(MBridgeIds mBridgeIds, String str) {
        c cVar = this.c;
        if (cVar != null) {
            cVar.x = false;
        }
        j.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.b, mBridgeIds.getUnitId(), str);
        MBSplashShowListener mBSplashShowListener = this.f4756a;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onShowFailed(mBridgeIds, str);
        }
    }

    public void b(MBridgeIds mBridgeIds) {
        c cVar = this.c;
        if (cVar != null) {
            cVar.x = true;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("load_to", this.c.e());
            jSONObject.put("allow_skip", this.c.f() ? 1 : 0);
            jSONObject.put("countdown", this.c.d());
        } catch (JSONException e) {
            p0.b("SplashShowListenerImpl", "e:" + e.getMessage());
        }
        j.b(com.mbridge.msdk.foundation.controller.c.m().d(), this.b, mBridgeIds.getUnitId(), jSONObject.toString());
        MBSplashShowListener mBSplashShowListener = this.f4756a;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onShowSuccessed(mBridgeIds);
        }
    }

    public void a(MBridgeIds mBridgeIds) {
        MBSplashShowListener mBSplashShowListener = this.f4756a;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onAdClicked(mBridgeIds);
        }
    }

    public void a(MBridgeIds mBridgeIds, int i) {
        MBSplashShowListener mBSplashShowListener = this.f4756a;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onDismiss(mBridgeIds, i);
        }
        c cVar = this.c;
        if (cVar != null) {
            cVar.x = false;
        }
        if (i == 6 || i == 4 || i == 5) {
            com.mbridge.msdk.splash.report.a.a(this.b, mBridgeIds.getUnitId(), i);
        }
    }

    public void a(MBridgeIds mBridgeIds, long j) {
        MBSplashShowListener mBSplashShowListener = this.f4756a;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onAdTick(mBridgeIds, j);
        }
    }

    public void a(MBridgeIds mBridgeIds, int i, int i2, int i3) {
        MBSplashShowListener mBSplashShowListener = this.f4756a;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onZoomOutPlayStart(mBridgeIds);
        }
        com.mbridge.msdk.splash.report.a.a(this.b, mBridgeIds.getUnitId(), i, i2, i3);
    }
}
