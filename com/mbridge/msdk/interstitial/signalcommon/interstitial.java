package com.mbridge.msdk.interstitial.signalcommon;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.mbridge.msdk.click.c;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.wrapper.e;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.interstitial.view.MBInterstitialActivity;
import com.mbridge.msdk.mbsignalcommon.windvane.AbsFeedBackForH5;
import com.mbridge.msdk.mbsignalcommon.windvane.f;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class interstitial extends AbsFeedBackForH5 {
    private static final String h = "com.mbridge.msdk.interstitial.signalcommon.interstitial";
    public static final /* synthetic */ int i = 0;
    private Object g;

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f4416a;
        final /* synthetic */ String b;

        a(List list, String str) {
            this.f4416a = list;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.mbridge.msdk.interstitial.cache.a a2 = com.mbridge.msdk.interstitial.cache.a.a();
            if (a2 != null) {
                a2.a(this.f4416a, this.b);
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f4417a;

        b(List list) {
            this.f4417a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i = 0; i < this.f4417a.size(); i++) {
                CampaignEx campaignEx = (CampaignEx) this.f4417a.get(i);
                if (campaignEx != null) {
                    j.a(g.a(((com.mbridge.msdk.mbsignalcommon.windvane.g) interstitial.this).f4571a)).b(campaignEx.getId());
                }
            }
        }
    }

    private void b() {
        try {
            Context context = this.f4571a;
            if (context != null && a(context) == 1) {
                try {
                    MBInterstitialActivity mBInterstitialActivity = (MBInterstitialActivity) this.f4571a;
                    if (mBInterstitialActivity != null) {
                        mBInterstitialActivity.hideLoading();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void c() {
        try {
            f.a().b(this.g, "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void d() {
        MBInterstitialActivity mBInterstitialActivity;
        try {
            Context context = this.f4571a;
            if (context == null || a(context) != 1 || (mBInterstitialActivity = (MBInterstitialActivity) this.f4571a) == null) {
                return;
            }
            mBInterstitialActivity.showWebView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getExcludeIdList(String str) {
        Exception e;
        ArrayList arrayList;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String optString = new JSONObject(str).optString(e.h);
            if (!TextUtils.isEmpty(optString)) {
                JSONArray jSONArray = new JSONArray(optString);
                if (jSONArray.length() > 0) {
                    arrayList = new ArrayList();
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        try {
                            if (!TextUtils.isEmpty(jSONArray.optString(i2))) {
                                arrayList.add(jSONArray.optString(i2));
                            }
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            return arrayList;
                        }
                    }
                    return arrayList;
                }
            }
            return null;
        } catch (Exception e3) {
            e = e3;
            arrayList = null;
        }
    }

    public void getInfo(Object obj, String str) {
        try {
            this.g = obj;
            Context context = this.f4571a;
            if (context == null) {
                c();
                return;
            }
            int a2 = a(context);
            if (TextUtils.isEmpty(a())) {
                c();
            } else if (a2 == 1) {
                a(obj, str);
            }
        } catch (Exception e) {
            e.printStackTrace();
            c();
        }
    }

    public void install(Object obj, String str) {
        try {
            Context context = this.f4571a;
            if (context != null && (context instanceof MBInterstitialActivity)) {
                ((MBInterstitialActivity) context).clickTracking();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openURL(Object obj, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("url");
            int optInt = jSONObject.optInt("type");
            if (optInt == 1) {
                c.c(this.f4571a, optString);
            } else if (optInt == 2) {
                c.e(this.f4571a, optString);
            }
        } catch (JSONException e) {
            p0.b(h, e.getMessage());
        } catch (Throwable th) {
            p0.b(h, th.getMessage());
        }
    }

    private void a(Object obj, String str) {
        try {
            b();
            d();
            Context context = this.f4571a;
            if (context == null) {
                c();
                return;
            }
            if (a(context) != 1) {
                c();
                return;
            }
            Context context2 = this.f4571a;
            if (context2 instanceof MBInterstitialActivity) {
                ((MBInterstitialActivity) context2).mIsMBPage = true;
            }
            String a2 = a();
            if (TextUtils.isEmpty(a2)) {
                c();
                return;
            }
            List<CampaignEx> a3 = a(a2);
            if (a3 == null) {
                c();
                return;
            }
            String a4 = a(a3);
            if (TextUtils.isEmpty(a4)) {
                c();
                return;
            }
            f.a().b(obj, a4);
            a(a2, a3);
            b(a2, a3);
            a(a3, a2);
        } catch (Exception e) {
            e.printStackTrace();
            c();
        }
    }

    private void b(String str, List<CampaignEx> list) {
        try {
            if (!TextUtils.isEmpty(str) && list != null && list.size() != 0) {
                new Thread(new b(list)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<CampaignEx> a(String str) {
        try {
            if (TextUtils.isEmpty(str) || com.mbridge.msdk.interstitial.cache.a.a() == null) {
                return null;
            }
            return com.mbridge.msdk.interstitial.cache.a.a().a(str, 1);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void a(List<CampaignEx> list, String str) {
        try {
            new Thread(new a(list, str)).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String a(List<CampaignEx> list) {
        if (list == null) {
            return "";
        }
        try {
            if (list.size() <= 0) {
                return "";
            }
            JSONArray parseCamplistToJson = CampaignEx.parseCamplistToJson(list);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("campaignList", parseCamplistToJson);
            String jSONObject2 = jSONObject.toString();
            return !TextUtils.isEmpty(jSONObject2) ? Base64.encodeToString(jSONObject2.getBytes(), 2) : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private int a(Context context) {
        return (context == null || !(context instanceof MBInterstitialActivity)) ? -1 : 1;
    }

    private String a() {
        Context context;
        MBInterstitialActivity mBInterstitialActivity;
        String str = null;
        try {
            context = this.f4571a;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (context == null) {
            return null;
        }
        if (a(context) == 1) {
            try {
                Context context2 = this.f4571a;
                if (context2 != null && (context2 instanceof MBInterstitialActivity) && (mBInterstitialActivity = (MBInterstitialActivity) context2) != null) {
                    str = mBInterstitialActivity.mUnitid;
                    return str;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return str;
    }

    private void a(String str, List<CampaignEx> list) {
        try {
            if (!TextUtils.isEmpty(str) && list != null && list.size() != 0) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    CampaignEx campaignEx = list.get(i2);
                    if (campaignEx != null) {
                        com.mbridge.msdk.foundation.same.buffer.b.a(str, campaignEx, "interstitial");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
