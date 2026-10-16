package com.mbridge.msdk.splash.request;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.tracker.network.g;
import java.util.List;
import org.json.JSONObject;

/* compiled from: SplashResponseHandler.java */
/* loaded from: classes6.dex */
public abstract class d extends com.mbridge.msdk.foundation.same.net.c<JSONObject> {
    private static final String c = "d";

    /* renamed from: a, reason: collision with root package name */
    private int f4757a;
    private String b;

    /* compiled from: SplashResponseHandler.java */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4758a;
        final /* synthetic */ JSONObject b;
        final /* synthetic */ List c;
        final /* synthetic */ int d;

        /* compiled from: SplashResponseHandler.java */
        /* renamed from: com.mbridge.msdk.splash.request.d$a$a, reason: collision with other inner class name */
        class RunnableC0392a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ CampaignUnit f4759a;

            RunnableC0392a(CampaignUnit campaignUnit) {
                this.f4759a = campaignUnit;
            }

            @Override // java.lang.Runnable
            public void run() {
                CampaignUnit campaignUnit = this.f4759a;
                if (campaignUnit != null && campaignUnit.getAds() != null && this.f4759a.getAds().size() > 0) {
                    a aVar = a.this;
                    d.this.a(aVar.c, this.f4759a);
                    d.this.saveRequestTime(this.f4759a.getAds().size());
                } else {
                    CampaignUnit campaignUnit2 = this.f4759a;
                    String msg = campaignUnit2 != null ? campaignUnit2.getMsg() : null;
                    if (TextUtils.isEmpty(msg)) {
                        msg = a.this.b.optString(NotificationCompat.CATEGORY_MESSAGE);
                    }
                    a aVar2 = a.this;
                    d.this.a(aVar2.d, msg);
                }
            }
        }

        a(String str, JSONObject jSONObject, List list, int i) {
            this.f4758a = str;
            this.b = jSONObject;
            this.c = list;
            this.d = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.mbridge.msdk.foundation.same.threadpool.a.c().post(new RunnableC0392a("v5".equals(this.f4758a) ? com.mbridge.msdk.foundation.entity.b.parseV5CampaignUnit(this.b.optJSONObject("data"), d.this.b) : com.mbridge.msdk.foundation.entity.b.parseCampaignUnit(this.b.optJSONObject("data"), d.this.b)));
        }
    }

    private void b(List<g> list, JSONObject jSONObject) {
        int optInt = jSONObject.optInt("status");
        if (1 != optInt) {
            a(optInt, jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE));
            return;
        }
        calcRequestTime(System.currentTimeMillis());
        com.mbridge.msdk.foundation.same.threadpool.a.b().execute(new a(jSONObject.optString("version"), jSONObject, list, optInt));
    }

    public abstract void a(int i, String str);

    public abstract void a(List<Frame> list);

    public abstract void a(List<g> list, CampaignUnit campaignUnit);

    @Override // com.mbridge.msdk.foundation.same.net.c, com.mbridge.msdk.foundation.same.net.b
    public void onError(com.mbridge.msdk.foundation.same.net.exception.a aVar) {
        p0.b(c, "errorCode = " + aVar.f4288a);
        a(aVar.f4288a, com.mbridge.msdk.foundation.same.net.utils.a.a(aVar));
    }

    @Override // com.mbridge.msdk.foundation.same.net.c
    public void onPreExecute() {
        super.onPreExecute();
    }

    @Override // com.mbridge.msdk.foundation.same.net.c, com.mbridge.msdk.foundation.same.net.b
    public void onSuccess(com.mbridge.msdk.foundation.same.net.e<JSONObject> eVar) {
        com.mbridge.msdk.foundation.same.net.toolbox.a aVar;
        super.onSuccess(eVar);
        if (eVar == null || (aVar = eVar.b) == null) {
            return;
        }
        int i = this.f4757a;
        if (i == 0) {
            b(aVar.b, eVar.c);
        } else if (i == 1) {
            a(aVar.b, eVar.c);
        }
    }

    public void a(String str) {
        this.b = str;
    }

    private void a(List<g> list, JSONObject jSONObject) {
        CampaignUnit parseCampaignUnit;
        int optInt = jSONObject.optInt("status");
        if (1 == optInt) {
            calcRequestTime(System.currentTimeMillis());
            if ("v5".equals(jSONObject.optString("version"))) {
                parseCampaignUnit = com.mbridge.msdk.foundation.entity.b.parseV5CampaignUnit(jSONObject.optJSONObject("data"), this.b);
            } else {
                parseCampaignUnit = com.mbridge.msdk.foundation.entity.b.parseCampaignUnit(jSONObject.optJSONObject("data"), this.b);
            }
            if (parseCampaignUnit != null && parseCampaignUnit.getListFrames() != null && parseCampaignUnit.getListFrames().size() > 0) {
                List<Frame> listFrames = parseCampaignUnit.getListFrames();
                a(listFrames);
                saveRequestTime(listFrames.size());
                return;
            } else {
                String msg = parseCampaignUnit != null ? parseCampaignUnit.getMsg() : null;
                if (TextUtils.isEmpty(msg)) {
                    msg = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE);
                }
                a(optInt, msg);
                return;
            }
        }
        a(optInt, jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE));
    }
}
