package com.mbridge.msdk.mbbanner.common.response;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.entity.b;
import com.mbridge.msdk.foundation.same.net.c;
import com.mbridge.msdk.foundation.same.net.e;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.tracker.network.g;
import java.util.List;
import org.json.JSONObject;

/* compiled from: BannerResponseHandler.java */
/* loaded from: classes6.dex */
public abstract class a extends c<JSONObject> {
    private static final String b = "a";

    /* renamed from: a, reason: collision with root package name */
    private String f4470a = "";

    /* compiled from: BannerResponseHandler.java */
    /* renamed from: com.mbridge.msdk.mbbanner.common.response.a$a, reason: collision with other inner class name */
    class RunnableC0350a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4471a;
        final /* synthetic */ JSONObject b;
        final /* synthetic */ int c;

        /* compiled from: BannerResponseHandler.java */
        /* renamed from: com.mbridge.msdk.mbbanner.common.response.a$a$a, reason: collision with other inner class name */
        class RunnableC0351a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ CampaignUnit f4472a;

            RunnableC0351a(CampaignUnit campaignUnit) {
                this.f4472a = campaignUnit;
            }

            @Override // java.lang.Runnable
            public void run() {
                CampaignUnit campaignUnit = this.f4472a;
                if (campaignUnit != null && campaignUnit.getAds() != null && this.f4472a.getAds().size() > 0) {
                    a.this.a(this.f4472a);
                    if (!TextUtils.isEmpty(a.this.f4470a)) {
                        a.this.saveHbState(1);
                    }
                    a.this.saveRequestTime(this.f4472a.getAds().size());
                    return;
                }
                CampaignUnit campaignUnit2 = this.f4472a;
                String msg = campaignUnit2 != null ? campaignUnit2.getMsg() : null;
                if (TextUtils.isEmpty(msg)) {
                    msg = RunnableC0350a.this.b.optString(NotificationCompat.CATEGORY_MESSAGE);
                }
                RunnableC0350a runnableC0350a = RunnableC0350a.this;
                a.this.a(runnableC0350a.c, msg);
            }
        }

        RunnableC0350a(String str, JSONObject jSONObject, int i) {
            this.f4471a = str;
            this.b = jSONObject;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.mbridge.msdk.foundation.same.threadpool.a.c().post(new RunnableC0351a("v5".equals(this.f4471a) ? b.parseV5CampaignUnit(this.b.optJSONObject("data"), a.this.f4470a) : b.parseCampaignUnit(this.b.optJSONObject("data"), a.this.f4470a)));
        }
    }

    public abstract void a(int i, String str);

    public abstract void a(CampaignUnit campaignUnit);

    @Override // com.mbridge.msdk.foundation.same.net.c, com.mbridge.msdk.foundation.same.net.b
    public void onError(com.mbridge.msdk.foundation.same.net.exception.a aVar) {
        p0.c(b, "onFailed errorCode = " + aVar.f4288a);
        a(aVar.f4288a, com.mbridge.msdk.foundation.same.net.utils.a.a(aVar));
    }

    @Override // com.mbridge.msdk.foundation.same.net.c, com.mbridge.msdk.foundation.same.net.b
    public void onSuccess(e<JSONObject> eVar) {
        super.onSuccess(eVar);
        a(eVar.b.b, eVar.c);
    }

    public void a(String str) {
        this.f4470a = str;
    }

    private void a(List<g> list, JSONObject jSONObject) {
        p0.c(b, "parseLoad content = " + jSONObject);
        int optInt = jSONObject.optInt("status");
        if (1 == optInt) {
            calcRequestTime(System.currentTimeMillis());
            com.mbridge.msdk.foundation.same.threadpool.a.b().execute(new RunnableC0350a(jSONObject.optString("version"), jSONObject, optInt));
            return;
        }
        a(optInt, jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE));
    }
}
