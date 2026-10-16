package com.mbridge.msdk.interstitial.request;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.net.e;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.tracker.network.g;
import java.util.List;
import org.json.JSONObject;

/* compiled from: InterstitialResponseHandler.java */
/* loaded from: classes6.dex */
public abstract class c extends com.mbridge.msdk.foundation.same.net.c<JSONObject> {

    /* renamed from: a, reason: collision with root package name */
    private int f4415a;

    private void a(List<g> list, JSONObject jSONObject) {
        int optInt = jSONObject.optInt("status");
        if (1 != optInt) {
            a(optInt, jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE));
            return;
        }
        calcRequestTime(System.currentTimeMillis());
        CampaignUnit parseV5CampaignUnit = "v5".equals(jSONObject.optString("version")) ? com.mbridge.msdk.foundation.entity.b.parseV5CampaignUnit(jSONObject.optJSONObject("data")) : com.mbridge.msdk.foundation.entity.b.parseCampaignUnit(jSONObject.optJSONObject("data"));
        if (parseV5CampaignUnit != null && parseV5CampaignUnit.getListFrames() != null && parseV5CampaignUnit.getListFrames().size() > 0) {
            List<Frame> listFrames = parseV5CampaignUnit.getListFrames();
            a(listFrames);
            saveRequestTime(listFrames.size());
        } else {
            String msg = parseV5CampaignUnit != null ? parseV5CampaignUnit.getMsg() : null;
            if (TextUtils.isEmpty(msg)) {
                msg = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE);
            }
            a(optInt, msg);
        }
    }

    private void b(List<g> list, JSONObject jSONObject) {
        int optInt = jSONObject.optInt("status");
        if (1 != optInt) {
            a(optInt, jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE));
            return;
        }
        calcRequestTime(System.currentTimeMillis());
        CampaignUnit parseV5CampaignUnit = "v5".equals(jSONObject.optString("version")) ? com.mbridge.msdk.foundation.entity.b.parseV5CampaignUnit(jSONObject.optJSONObject("data")) : com.mbridge.msdk.foundation.entity.b.parseCampaignUnit(jSONObject.optJSONObject("data"));
        if (parseV5CampaignUnit != null && parseV5CampaignUnit.getAds() != null && parseV5CampaignUnit.getAds().size() > 0) {
            a(list, parseV5CampaignUnit);
            saveRequestTime(parseV5CampaignUnit.getAds().size());
        } else {
            String msg = parseV5CampaignUnit != null ? parseV5CampaignUnit.getMsg() : null;
            if (TextUtils.isEmpty(msg)) {
                msg = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE);
            }
            a(optInt, msg);
        }
    }

    public abstract void a(int i, String str);

    public abstract void a(List<Frame> list);

    public abstract void a(List<g> list, CampaignUnit campaignUnit);

    @Override // com.mbridge.msdk.foundation.same.net.c, com.mbridge.msdk.foundation.same.net.b
    public void onError(com.mbridge.msdk.foundation.same.net.exception.a aVar) {
        a(aVar.f4288a, com.mbridge.msdk.foundation.same.net.utils.a.a(aVar));
    }

    @Override // com.mbridge.msdk.foundation.same.net.c
    public void onPreExecute() {
        super.onPreExecute();
    }

    @Override // com.mbridge.msdk.foundation.same.net.c, com.mbridge.msdk.foundation.same.net.b
    public void onSuccess(e<JSONObject> eVar) {
        com.mbridge.msdk.foundation.same.net.toolbox.a aVar;
        super.onSuccess(eVar);
        if (eVar == null || (aVar = eVar.b) == null) {
            return;
        }
        int i = this.f4415a;
        if (i == 0) {
            b(aVar.b, eVar.c);
        } else if (i == 1) {
            a(aVar.b, eVar.c);
        }
    }
}
