package com.mbridge.msdk.video.bt.component;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.ironsource.C3040d4;
import com.ironsource.C3288s;
import com.ironsource.V5;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.m;
import com.mbridge.msdk.foundation.tools.c0;
import com.mbridge.msdk.foundation.tools.e1;
import com.mbridge.msdk.foundation.tools.l0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.f;
import com.mbridge.msdk.video.bt.module.BTBaseView;
import com.mbridge.msdk.video.bt.module.MBTempContainer;
import com.mbridge.msdk.video.bt.module.MBridgeBTContainer;
import com.mbridge.msdk.video.bt.module.MBridgeBTLayout;
import com.mbridge.msdk.video.bt.module.MBridgeBTNativeEC;
import com.mbridge.msdk.video.bt.module.MBridgeBTVideoView;
import com.mbridge.msdk.video.bt.module.MBridgeBTWebView;
import com.mbridge.msdk.video.signal.impl.k;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BaseOperateViews.java */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<String, LinkedHashMap<String, View>> f4983a = new ConcurrentHashMap<>();
    private static LinkedHashMap<String, String> b = new LinkedHashMap<>();
    private static LinkedHashMap<String, CampaignEx> c = new LinkedHashMap<>();
    private static LinkedHashMap<String, com.mbridge.msdk.videocommon.setting.c> d = new LinkedHashMap<>();
    private static LinkedHashMap<String, String> e = new LinkedHashMap<>();
    private static LinkedHashMap<String, Integer> f = new LinkedHashMap<>();
    private static LinkedHashMap<String, Activity> g = new LinkedHashMap<>();
    private static volatile int h = 10000;
    private static int i = 0;
    private static int j = 1;
    private static String k = "";
    private static int l;
    private static int m;
    private static int n;
    private static int o;
    private static int p;

    /* compiled from: BaseOperateViews.java */
    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f4986a;

        c(CampaignEx campaignEx) {
            this.f4986a = campaignEx;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                j a2 = j.a(g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
                if (a2 != null) {
                    if (a2.a(this.f4986a.getId())) {
                        a2.b(this.f4986a.getId());
                    } else {
                        com.mbridge.msdk.foundation.entity.g gVar = new com.mbridge.msdk.foundation.entity.g();
                        gVar.a(this.f4986a.getId());
                        gVar.b(this.f4986a.getFca());
                        gVar.c(this.f4986a.getFcb());
                        gVar.a(0);
                        gVar.d(1);
                        gVar.a(System.currentTimeMillis());
                        a2.b(gVar);
                    }
                }
                a.this.a(this.f4986a.getCampaignUnitId(), this.f4986a);
            } catch (Throwable th) {
                p0.b("OperateViews", th.getMessage(), th);
            }
        }
    }

    public void A(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e2 = e(optString2);
            if (TextUtils.isEmpty(e2) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b) != null) {
                e2 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                a(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, e2);
            if (!b2.containsKey(optString2)) {
                a(obj, "instanceId not exit");
                p0.a("OperateViews", "playerUnmute failed: instanceId not exit");
                return;
            }
            View view = b2.get(optString2);
            if (!(view instanceof MBridgeBTVideoView)) {
                a(obj, "instanceId is not player");
                p0.a("OperateViews", "playerUnmute failed: instanceId is not player");
            } else if (!((MBridgeBTVideoView) view).playUnMute()) {
                b(obj, "set unmute failed");
                p0.a("OperateViews", "playerUnmute failed: set unmute failed");
            } else {
                b(obj, optString2);
                a(obj, "onUnmute", optString2);
                p0.a("OperateViews", "playerUnmute successed");
            }
        } catch (Throwable th) {
            a(obj, th.getMessage());
            p0.a("OperateViews", "playerUnmute failed: " + th.getMessage());
        }
    }

    public void B(Object obj, JSONObject jSONObject) {
        try {
            jSONObject.optString("unitId");
            if (jSONObject.optJSONObject("data") == null) {
                a(obj, "data is empty");
            }
        } catch (Throwable th) {
            a(obj, th.getMessage());
        }
    }

    public void C(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e2 = e(optString2);
            if (TextUtils.isEmpty(e2) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b) != null) {
                e2 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                a(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, e2);
            if (!b2.containsKey(optString2)) {
                a(obj, "instanceId not exist");
                return;
            }
            View view = b2.get(optString2);
            if (!(view instanceof MBTempContainer)) {
                a(obj, "view not exist");
            } else {
                ((MBTempContainer) view).preload();
                b(obj, optString2);
            }
        } catch (Throwable th) {
            a(obj, th.getMessage());
            p0.a("OperateViews", "preloadSubPlayTemplateView failed: " + th.getMessage());
        }
    }

    public void D(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e2 = e(optString2);
            if (TextUtils.isEmpty(e2) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b) != null) {
                e2 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                a(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, e2);
            if (!b2.containsKey(optString2)) {
                a(obj, "params not enough");
                p0.a("OperateViews", "removeFromSuperView failed: params not enough instanceId = " + optString2);
                return;
            }
            View view = b2.get(optString2);
            if (view == null || view.getParent() == null) {
                a(obj, "view is null");
                p0.a("OperateViews", "removeFromSuperView failed: view is null instanceId = " + optString2);
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup == null) {
                a(obj, "parent is null");
                p0.a("OperateViews", "removeFromSuperView failed: parent is null instanceId = " + optString2);
            } else {
                viewGroup.removeView(view);
                b(obj, optString2);
                a(obj, "onRemoveFromView", optString2);
                p0.a("OperateViews", "removeFromSuperView instanceId = " + optString2);
            }
        } catch (Throwable th) {
            a(obj, th.getMessage());
            p0.a("OperateViews", "removeFromSuperView failed: " + th.getMessage());
        }
    }

    public void E(Object obj, JSONObject jSONObject) {
        String str;
        com.mbridge.msdk.videocommon.entity.c cVar;
        try {
            WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b;
            String str2 = "";
            String rid = windVaneWebView != null ? windVaneWebView.getRid() : "";
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            String optString3 = optJSONObject.optString("userId");
            boolean optBoolean = optJSONObject.optBoolean("expired");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject(C3288s.j);
            String optString4 = optJSONObject.optString("extra");
            if (optJSONObject2 != null) {
                str = "setSubPlayTemplateInfo failed: unitId not exist instanceId = ";
                com.mbridge.msdk.videocommon.entity.c cVar2 = new com.mbridge.msdk.videocommon.entity.c(optJSONObject2.optString("name"), optJSONObject2.optInt("amount"));
                str2 = optJSONObject2.optString("id");
                cVar = cVar2;
            } else {
                str = "setSubPlayTemplateInfo failed: unitId not exist instanceId = ";
                cVar = null;
            }
            LinkedHashMap<String, View> b2 = b(optString, rid);
            if (b2.size() <= 0 || !e.containsKey(optString2)) {
                a(obj, "unitId not exist");
                p0.a("OperateViews", str + optString2);
                return;
            }
            View view = b2.get(optString2);
            if (!(view instanceof MBTempContainer)) {
                a(obj, "instanceId not exist");
                p0.a("OperateViews", "setSubPlayTemplateInfo failed: instanceId not exist instanceId = " + optString2);
                return;
            }
            MBTempContainer mBTempContainer = (MBTempContainer) view;
            mBTempContainer.setReward(cVar);
            mBTempContainer.setUserId(optString3);
            mBTempContainer.setRewardId(str2);
            mBTempContainer.setCampaignExpired(optBoolean);
            if (!TextUtils.isEmpty(optString4)) {
                mBTempContainer.setDeveloperExtraData(optString4);
            }
            b(obj, optString2);
            p0.a("OperateViews", "setSubPlayTemplateInfo success instanceId = " + optString2);
        } catch (Throwable th) {
            a(obj, th.getMessage());
            p0.a("OperateViews", "setSubPlayTemplateInfo failed: " + th.getMessage());
        }
    }

    public void F(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e2 = e(optString2);
            if (TextUtils.isEmpty(e2) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b) != null) {
                e2 = windVaneWebView.getRid();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                a(obj, "data is empty");
                return;
            }
            double optDouble = optJSONObject.optDouble("alpha", 1.0d);
            LinkedHashMap<String, View> b2 = b(optString, e2);
            if (!b2.containsKey(optString2)) {
                a(obj, "instanceId not exist");
                p0.a("OperateViews", "setViewAlpha failed: instanceId not exist instanceId = " + optString2);
                return;
            }
            View view = b2.get(optString2);
            if (view == null) {
                a(obj, "view not exist");
                p0.a("OperateViews", "setViewAlpha failed: view not exist instanceId = " + optString2);
            } else {
                view.setAlpha((float) optDouble);
                b(obj, optString2);
                a(obj, "onViewAlphaChanged", optString2);
                p0.a("OperateViews", "setViewAlpha instanceId = " + optString2);
            }
        } catch (Throwable th) {
            a(obj, th.getMessage());
            p0.a("OperateViews", "setViewAlpha failed: " + th.getMessage());
        }
    }

    public void G(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e2 = e(optString2);
            if (TextUtils.isEmpty(e2) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b) != null) {
                e2 = windVaneWebView.getRid();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                a(obj, "data is empty");
                return;
            }
            String optString3 = optJSONObject.optString("color");
            if (TextUtils.isEmpty(optString3)) {
                a(obj, "color is not exist");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, e2);
            if (!b2.containsKey(optString2)) {
                a(obj, "instanceId not exist");
                p0.a("OperateViews", "setViewBgColor failed: instanceId not exist instanceId = " + optString2);
                return;
            }
            View view = b2.get(optString2);
            if (view == null) {
                a(obj, "view not exist");
                p0.a("OperateViews", "setViewBgColor failed: view not exist instanceId = " + optString2);
            } else {
                b(obj, optString2);
                view.setBackgroundColor(Color.parseColor(optString3));
                a(obj, "onViewBgColorChanged", optString2);
                p0.a("OperateViews", "setViewBgColor instanceId = " + optString2);
            }
        } catch (Throwable th) {
            a(obj, th.getMessage());
            p0.a("OperateViews", "setViewBgColor failed: " + th.getMessage());
        }
    }

    public void H(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e2 = e(optString2);
            if (TextUtils.isEmpty(e2) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b) != null) {
                e2 = windVaneWebView.getRid();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                a(obj, "data is empty");
                return;
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
            if (optJSONObject2 == null) {
                a(obj, "rect not exist");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, e2);
            Rect rect = new Rect(optJSONObject2.optInt("left", -999), optJSONObject2.optInt("top", -999), optJSONObject2.optInt("right", -999), optJSONObject2.optInt("bottom", -999));
            int optInt = optJSONObject2.optInt("width");
            int optInt2 = optJSONObject2.optInt("height");
            if (!b2.containsKey(optString2)) {
                a(obj, "instanceId not exist");
                p0.a("OperateViews", "setViewRect failed: instanceId not exist");
                return;
            }
            View view = b2.get(optString2);
            if (view == null) {
                a(obj, "view is null");
                p0.a("OperateViews", "setViewRect failed: view is null");
                return;
            }
            if (view.getParent() != null) {
                view.setLayoutParams(a(view.getLayoutParams(), rect, optInt, optInt2));
                view.requestLayout();
            } else {
                if (view instanceof MBridgeBTWebView) {
                    ((MBridgeBTWebView) view).setRect(rect);
                    ((MBridgeBTWebView) view).setLayout(optInt, optInt2);
                }
                if (view instanceof MBridgeBTVideoView) {
                    ((MBridgeBTVideoView) view).setRect(rect);
                    ((MBridgeBTVideoView) view).setLayout(optInt, optInt2);
                }
            }
            b(obj, optString2);
            a(obj, "onViewRectChanged", optString2);
            p0.a("OperateViews", "setViewRect instanceId = " + optString2);
        } catch (Throwable th) {
            a(obj, th.getMessage());
            p0.a("OperateViews", "setViewRect failed: " + th.getMessage());
        }
    }

    public void I(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e2 = e(optString2);
            if (TextUtils.isEmpty(e2) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b) != null) {
                e2 = windVaneWebView.getRid();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                a(obj, "data is empty");
                return;
            }
            double optDouble = optJSONObject.optDouble("vertical", 1.0d);
            double optDouble2 = optJSONObject.optDouble("horizon", 1.0d);
            LinkedHashMap<String, View> b2 = b(optString, e2);
            if (!b2.containsKey(optString2)) {
                a(obj, "instanceId not exist");
                p0.a("OperateViews", "setViewScale failed: instanceId not exist instanceId = " + optString2);
                return;
            }
            View view = b2.get(optString2);
            if (view == null) {
                a(obj, "view not exist");
                p0.a("OperateViews", "setViewScale failed: view not exist instanceId = " + optString2);
                return;
            }
            view.setScaleX((float) optDouble2);
            view.setScaleY((float) optDouble);
            b(obj, optString2);
            a(obj, "onViewScaleChanged", optString2);
            p0.a("OperateViews", "setViewScale instanceId = " + optString2);
        } catch (Throwable th) {
            a(obj, th.getMessage());
            p0.a("OperateViews", "setViewScale failed: " + th.getMessage());
        }
    }

    public void J(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e2 = e(optString2);
            if (TextUtils.isEmpty(e2) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b) != null) {
                e2 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                a(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, e2);
            if (!b2.containsKey(optString2)) {
                a(obj, "instanceId not exist");
                p0.a("OperateViews", "showView failed: instanceId not exist instanceId = " + optString2);
                return;
            }
            View view = b2.get(optString2);
            if (view == null) {
                a(obj, "view not exist");
                p0.a("OperateViews", "showView failed: view not exist instanceId = " + optString2);
            } else {
                view.setVisibility(0);
                b(obj, optString2);
                a(obj, "onShowView", optString2);
                p0.a("OperateViews", "showView instanceId = " + optString2);
            }
        } catch (Throwable th) {
            a(obj, th.getMessage());
            p0.a("OperateViews", "showView failed: " + th.getMessage());
        }
    }

    public void K(Object obj, JSONObject jSONObject) {
        try {
            WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b;
            String rid = windVaneWebView != null ? windVaneWebView.getRid() : "";
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            String optString3 = optJSONObject.optString(C3040d4.h.j0);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("eventData");
            if (optJSONObject2 == null) {
                optJSONObject2 = new JSONObject();
            }
            LinkedHashMap<String, View> b2 = b(optString, rid);
            if (b2.size() <= 0) {
                a(obj, "unitId not exist");
                p0.a("OperateViews", "webviewFireEvent failed: unitId not exist");
                return;
            }
            View view = b2.get(optString2);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (childAt instanceof WindVaneWebView) {
                        f.a().a((WebView) childAt, optString3, Base64.encodeToString(optJSONObject2.toString().getBytes(), 2));
                        b(obj, optString2);
                        p0.a("OperateViews", "webviewFireEvent instanceId = " + optString2);
                        return;
                    }
                }
            }
            a(obj, "instanceId not exist");
            p0.a("OperateViews", "webviewFireEvent failed: instanceId not exist instanceId = " + optString2);
        } catch (Throwable th) {
            a(obj, th.getMessage());
            p0.a("OperateViews", "webviewFireEvent failed: " + th.getMessage());
        }
    }

    public void L(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e2 = e(optString2);
            if (TextUtils.isEmpty(e2) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b) != null) {
                e2 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                a(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, e2);
            if (!b2.containsKey(optString2)) {
                a(obj, "instanceId not exist");
                p0.a("OperateViews", "webviewGoBack failed instanceId not exist instanceId = " + optString2);
                return;
            }
            View view = b2.get(optString2);
            if (!(view instanceof MBridgeBTWebView)) {
                a(obj, "view not exist");
                p0.a("OperateViews", "webviewGoBack failed view not exist instanceId = " + optString2);
            } else if (((MBridgeBTWebView) view).webviewGoBack()) {
                b(obj, optString2);
                p0.a("OperateViews", "webviewGoBack instanceId = " + optString2);
            } else {
                a(obj, "webviewGoBack failed");
                p0.a("OperateViews", "webviewGoBack failed instanceId = " + optString2);
            }
        } catch (Throwable th) {
            a(obj, th.getMessage());
            p0.a("OperateViews", "webviewGoBack failed: " + th.getMessage());
        }
    }

    public void M(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e2 = e(optString2);
            if (TextUtils.isEmpty(e2) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b) != null) {
                e2 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                a(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, e2);
            if (!b2.containsKey(optString2)) {
                a(obj, "instanceId not exist");
                p0.a("OperateViews", "webviewGoForward failed instanceId not exist instanceId = " + optString2);
                return;
            }
            View view = b2.get(optString2);
            if (!(view instanceof MBridgeBTWebView)) {
                a(obj, "view not exist");
                p0.a("OperateViews", "webviewGoForward failed view not exist instanceId = " + optString2);
            } else if (((MBridgeBTWebView) view).webviewGoForward()) {
                b(obj, optString2);
                p0.a("OperateViews", "webviewGoForward instanceId = " + optString2);
            } else {
                a(obj, "webviewGoForward failed");
                p0.a("OperateViews", "webviewGoForward failed instanceId = " + optString2);
            }
        } catch (Throwable th) {
            a(obj, th.getMessage());
            p0.a("OperateViews", "webviewGoForward failed: " + th.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r18v0, types: [com.mbridge.msdk.video.bt.component.a] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11, types: [android.graphics.Rect] */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r5v4, types: [com.mbridge.msdk.video.bt.module.BTBaseView, com.mbridge.msdk.video.bt.module.MBridgeBTWebView] */
    public void N(Object obj, JSONObject jSONObject) {
        ?? r3;
        String str;
        int optInt;
        WindVaneWebView windVaneWebView;
        ?? r2 = obj;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e2 = e(optString2);
            if (TextUtils.isEmpty(e2) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) r2).b) != null) {
                e2 = windVaneWebView.getRid();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                a(r2, "data is empty");
                return;
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("content");
            if (optJSONObject2 == null) {
                a(r2, "content is empty");
                return;
            }
            String optString3 = optJSONObject2.optString("fileURL");
            String optString4 = optJSONObject2.optString(V5.c.c);
            String optString5 = optJSONObject2.optString(AnalyticsConstants.CREATIVE_TYPE_HTML);
            if (TextUtils.isEmpty(optString3) && TextUtils.isEmpty(optString4) && TextUtils.isEmpty(optString5)) {
                a(r2, "url is empty");
                return;
            }
            JSONArray optJSONArray = optJSONObject2.optJSONArray("campaigns");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                int i2 = 0;
                while (i2 < length) {
                    JSONArray jSONArray = optJSONArray;
                    CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(optJSONArray.getJSONObject(i2));
                    if (parseCampaignWithBackData != null) {
                        parseCampaignWithBackData.setCampaignUnitId(optString);
                        arrayList.add(parseCampaignWithBackData);
                    }
                    i2++;
                    optJSONArray = jSONArray;
                }
            }
            String optString6 = optJSONObject2.optString("unitId");
            com.mbridge.msdk.videocommon.setting.c a2 = com.mbridge.msdk.videocommon.setting.c.a(optJSONObject2.optJSONObject("unitSetting"));
            if (a2 != null) {
                a2.h(optString6);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("rect");
            Rect rect = new Rect(-999, -999, -999, -999);
            if (optJSONObject3 != null) {
                try {
                    str = "OperateViews";
                    try {
                        Rect rect2 = new Rect(optJSONObject3.optInt("left", -999), optJSONObject3.optInt("top", -999), optJSONObject3.optInt("right", -999), optJSONObject3.optInt("bottom", -999));
                        int optInt2 = optJSONObject3.optInt("width");
                        optInt = optJSONObject3.optInt("height");
                        r3 = rect2;
                        r2 = optInt2;
                    } catch (Throwable th) {
                        th = th;
                        r2 = obj;
                        r3 = str;
                        a(r2, th.getMessage());
                        p0.a((String) r3, "webviewLoad failed: " + th.getMessage());
                    }
                } catch (Throwable th2) {
                    th = th2;
                    str = "OperateViews";
                    r2 = obj;
                    r3 = str;
                    a(r2, th.getMessage());
                    p0.a((String) r3, "webviewLoad failed: " + th.getMessage());
                }
            } else {
                str = "OperateViews";
                optInt = 0;
                r2 = 0;
                r3 = rect;
            }
            int optInt3 = optJSONObject2.optInt("refreshCache", 0);
            LinkedHashMap<String, View> b2 = b(optString, e2);
            try {
                if (!b2.containsKey(optString2)) {
                    a(obj, "instanceId not exist");
                    p0.a(str, "webviewLoad failed: instanceId not exist instanceId = " + optString2);
                    return;
                }
                View view = b2.get(optString2);
                if (!(view instanceof MBridgeBTWebView)) {
                    a(obj, "view not exist");
                    p0.a(str, "webviewLoad failed: view not exist instanceId = " + optString2);
                    return;
                }
                ?? r5 = (MBridgeBTWebView) view;
                r5.setHtml(optString5);
                r5.setFilePath(optString4);
                r5.setFileURL(optString3);
                r5.setRect(r3);
                r5.setLayout(r2, optInt);
                r5.setCampaigns(arrayList);
                r5.setRewardUnitSetting(a2);
                r5.webviewLoad(optInt3);
                Object obj2 = obj;
                try {
                    b(obj2, optString2);
                    p0.a(str, "webviewLoad instanceId = " + optString2);
                } catch (Throwable th3) {
                    th = th3;
                    r2 = obj2;
                    r3 = str;
                    a(r2, th.getMessage());
                    p0.a((String) r3, "webviewLoad failed: " + th.getMessage());
                }
            } catch (Throwable th4) {
                th = th4;
                a(r2, th.getMessage());
                p0.a((String) r3, "webviewLoad failed: " + th.getMessage());
            }
        } catch (Throwable th5) {
            th = th5;
            r3 = "OperateViews";
        }
    }

    public void O(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e2 = e(optString2);
            if (TextUtils.isEmpty(e2) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b) != null) {
                e2 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                a(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, e2);
            if (!b2.containsKey(optString2)) {
                a(obj, "instanceId not exist");
                p0.a("OperateViews", "webviewReload failed instanceId not exist instanceId = " + optString2);
                return;
            }
            View view = b2.get(optString2);
            if (!(view instanceof MBridgeBTWebView)) {
                a(obj, "view not exist");
                p0.a("OperateViews", "webviewReload failed view not exist instanceId = " + optString2);
            } else if (((MBridgeBTWebView) view).webviewReload()) {
                b(obj, optString2);
                p0.a("OperateViews", "webviewReload instanceId = " + optString2);
            } else {
                a(obj, "reload failed");
                p0.a("OperateViews", "webviewReload failed reload failed instanceId = " + optString2);
            }
        } catch (Throwable th) {
            a(obj, th.getMessage());
            p0.a("OperateViews", "webviewReload failed: " + th.getMessage());
        }
    }

    public String b() {
        h++;
        return String.valueOf(h);
    }

    public CampaignEx c(String str) {
        if (c.containsKey(str)) {
            return c.get(str);
        }
        return null;
    }

    public void d(String str, String str2) {
        b.put(str, str2);
    }

    public String e(String str) {
        return b.containsKey(str) ? b.get(str) : "";
    }

    public String f(String str) {
        return e.containsKey(str) ? e.get(str) : "";
    }

    public int g(String str) {
        if (f.containsKey(str)) {
            return f.get(str).intValue();
        }
        return 2;
    }

    public void h(String str) {
        g.remove(str);
    }

    public void i(Object obj, JSONObject jSONObject) {
        Object obj2;
        Throwable th;
        int i2;
        int i3;
        try {
            String optString = jSONObject.optString("unitId");
            try {
                if (TextUtils.isEmpty(optString)) {
                    a(obj, "unitId is empty");
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                int optInt = optJSONObject.optInt("delay", 0);
                optJSONObject.optString("fileURL");
                optJSONObject.optString(V5.c.c);
                optJSONObject.optString(AnalyticsConstants.CREATIVE_TYPE_HTML);
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
                Rect rect = new Rect(-999, -999, -999, -999);
                if (optJSONObject2 != null) {
                    rect = new Rect(optJSONObject2.optInt("left", -999), optJSONObject2.optInt("top", -999), optJSONObject2.optInt("right", -999), optJSONObject2.optInt("bottom", -999));
                    int optInt2 = optJSONObject2.optInt("width");
                    i3 = optJSONObject2.optInt("height");
                    i2 = optInt2;
                } else {
                    i2 = 0;
                    i3 = 0;
                }
                obj2 = obj;
                try {
                    new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0403a(obj2, optString, rect, i2, i3), optInt);
                } catch (Throwable th2) {
                    th = th2;
                    th = th;
                    a(obj2, th.getMessage());
                    p0.a("OperateViews", "create view failed：" + th.getMessage());
                }
            } catch (Throwable th3) {
                th = th3;
                obj2 = obj;
                a(obj2, th.getMessage());
                p0.a("OperateViews", "create view failed：" + th.getMessage());
            }
        } catch (Throwable th4) {
            th = th4;
            obj2 = obj;
        }
    }

    public void j(Object obj, JSONObject jSONObject) {
        Object obj2;
        Throwable th;
        int i2;
        int i3;
        try {
            String optString = jSONObject.optString("unitId");
            try {
                if (TextUtils.isEmpty(optString)) {
                    a(obj, "unitId is empty");
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                int optInt = optJSONObject.optInt("delay", 0);
                String optString2 = optJSONObject.optString("fileURL");
                String optString3 = optJSONObject.optString(V5.c.c);
                String optString4 = optJSONObject.optString(AnalyticsConstants.CREATIVE_TYPE_HTML);
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
                Rect rect = new Rect(-999, -999, -999, -999);
                if (optJSONObject2 != null) {
                    rect = new Rect(optJSONObject2.optInt("left", -999), optJSONObject2.optInt("top", -999), optJSONObject2.optInt("right", -999), optJSONObject2.optInt("bottom", -999));
                    int optInt2 = optJSONObject2.optInt("width");
                    i3 = optJSONObject2.optInt("height");
                    i2 = optInt2;
                } else {
                    i2 = 0;
                    i3 = 0;
                }
                obj2 = obj;
                try {
                    new Handler(Looper.getMainLooper()).postDelayed(new b(obj2, optString, optString2, optString3, optString4, rect, i2, i3), optInt);
                } catch (Throwable th2) {
                    th = th2;
                    th = th;
                    a(obj2, th.getMessage());
                    p0.a("OperateViews", "createWebview failed：" + th.getMessage());
                }
            } catch (Throwable th3) {
                th = th3;
                obj2 = obj;
                a(obj2, th.getMessage());
                p0.a("OperateViews", "createWebview failed：" + th.getMessage());
            }
        } catch (Throwable th4) {
            th = th4;
            obj2 = obj;
        }
    }

    public void k(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            if (jSONObject.optJSONObject("data") != null && !TextUtils.isEmpty(optString)) {
                String e2 = e(optString2);
                if (TextUtils.isEmpty(e2) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b) != null) {
                    e2 = windVaneWebView.getRid();
                }
                LinkedHashMap<String, View> b2 = b(optString, e2);
                if (b2 == null || !b2.containsKey(optString2)) {
                    a(obj, "unitId or instanceId not exist");
                    p0.a("OperateViews", "destroyComponent failed");
                    return;
                }
                View view = b2.get(optString2);
                b2.remove(optString2);
                if (view != null && view.getParent() != null) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(view);
                    }
                    if (view instanceof ViewGroup) {
                        ViewGroup viewGroup2 = (ViewGroup) view;
                        if (viewGroup2.getChildCount() > 0) {
                            int childCount = viewGroup2.getChildCount();
                            for (int i2 = 0; i2 < childCount; i2++) {
                                View childAt = viewGroup2.getChildAt(i2);
                                if (childAt instanceof MBridgeBTWebView) {
                                    b2.remove(((MBridgeBTWebView) childAt).getInstanceId());
                                    ((MBridgeBTWebView) childAt).onDestory();
                                } else if (childAt instanceof MBridgeBTVideoView) {
                                    b2.remove(((MBridgeBTVideoView) childAt).getInstanceId());
                                    ((MBridgeBTVideoView) childAt).onDestory();
                                } else if (childAt instanceof MBTempContainer) {
                                    b2.remove(((MBTempContainer) childAt).getInstanceId());
                                    ((MBTempContainer) childAt).onDestroy();
                                }
                            }
                        }
                    }
                }
                if (view instanceof MBTempContainer) {
                    ((MBTempContainer) view).onDestroy();
                }
                if (view instanceof MBridgeBTWebView) {
                    ((MBridgeBTWebView) view).onDestory();
                }
                if (view instanceof MBridgeBTVideoView) {
                    ((MBridgeBTVideoView) view).onDestory();
                }
                b(obj, optString2);
                a(obj, "onComponentDestroy", optString2);
                p0.a("OperateViews", "destroyComponent instanceId = " + optString2);
                return;
            }
            a(obj, "unidId or data is empty");
        } catch (Throwable th) {
            a(obj, th.getMessage());
            p0.a("OperateViews", "destroyComponent failed");
        }
    }

    public void l(Object obj, JSONObject jSONObject) {
        try {
            jSONObject.optString("unitId");
            String optString = jSONObject.optString("id");
            if (jSONObject.optJSONObject("data") == null) {
                a(obj, "data is empty");
            } else {
                b(obj, optString);
            }
        } catch (Throwable th) {
            a(obj, th.getMessage());
        }
    }

    public void m(Object obj, JSONObject jSONObject) {
        String str;
        int i2;
        boolean z;
        String str2;
        File file;
        String str3 = "";
        JSONObject jSONObject2 = new JSONObject();
        int i3 = 1;
        if (jSONObject == null) {
            try {
                jSONObject2.put("code", 1);
                jSONObject2.put(PglCryptUtils.KEY_MESSAGE, "params is null");
                f.a().b(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                return;
            } catch (JSONException e2) {
                p0.a("OperateViews", e2.getMessage());
                return;
            }
        }
        try {
            try {
                jSONObject2.put("code", 0);
                jSONObject2.put(PglCryptUtils.KEY_MESSAGE, "");
                JSONArray jSONArray = jSONObject.getJSONArray("resource");
                if (jSONArray == null || jSONArray.length() <= 0) {
                    try {
                        jSONObject2.put("code", 1);
                        jSONObject2.put(PglCryptUtils.KEY_MESSAGE, "resource is null");
                        f.a().b(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                        return;
                    } catch (JSONException e3) {
                        p0.a("OperateViews", e3.getMessage());
                        return;
                    }
                }
                JSONArray jSONArray2 = new JSONArray();
                int length = jSONArray.length();
                int i4 = 0;
                while (i4 < length) {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i4);
                    String optString = jSONObject3.optString("ref", str3);
                    int i5 = jSONObject3.getInt("type");
                    JSONObject jSONObject4 = new JSONObject();
                    JSONArray jSONArray3 = jSONArray;
                    if (i5 != i3 || TextUtils.isEmpty(optString)) {
                        str = str3;
                        i2 = length;
                        z = false;
                        if (i5 == 2 && !TextUtils.isEmpty(optString)) {
                            JSONObject jSONObject5 = new JSONObject();
                            jSONObject5.put("type", 2);
                            jSONObject5.put("path", H5DownLoadManager.getInstance().getH5ResAddress(optString) == null ? str : H5DownLoadManager.getInstance().getH5ResAddress(optString));
                            jSONObject4.put(optString, jSONObject5);
                            jSONArray2.put(jSONObject4);
                        } else if (i5 == 3 && !TextUtils.isEmpty(optString)) {
                            try {
                                file = new File(optString);
                            } catch (Throwable th) {
                                if (MBridgeConstans.DEBUG) {
                                    th.printStackTrace();
                                }
                            }
                            if (file.exists() && file.isFile() && file.canRead()) {
                                p0.a("OperateViews", "getFileInfo Mraid file " + optString);
                                str2 = "file:////" + optString;
                                JSONObject jSONObject6 = new JSONObject();
                                jSONObject6.put("type", 3);
                                jSONObject6.put("path", str2);
                                jSONObject4.put(optString, jSONObject6);
                                jSONArray2.put(jSONObject4);
                            }
                            str2 = str;
                            JSONObject jSONObject62 = new JSONObject();
                            jSONObject62.put("type", 3);
                            jSONObject62.put("path", str2);
                            jSONObject4.put(optString, jSONObject62);
                            jSONArray2.put(jSONObject4);
                        } else if (i5 == 4 && !TextUtils.isEmpty(optString)) {
                            JSONObject jSONObject7 = new JSONObject();
                            jSONObject7.put("type", 4);
                            jSONObject7.put("path", t0.a(optString) == null ? str : t0.a(optString));
                            jSONObject4.put(optString, jSONObject7);
                            jSONArray2.put(jSONObject4);
                        }
                    } else {
                        JSONObject jSONObject8 = new JSONObject();
                        m b2 = com.mbridge.msdk.foundation.db.m.a(g.a(com.mbridge.msdk.foundation.controller.c.m().d())).b(optString);
                        if (b2 != null) {
                            p0.a("OperateViews", "VideoBean not null");
                            jSONObject8.put("type", 1);
                            i2 = length;
                            jSONObject8.put("videoDataLength", b2.d());
                            String e4 = b2.e();
                            if (TextUtils.isEmpty(e4)) {
                                p0.a("OperateViews", "VideoPath null");
                                jSONObject8.put("path", str3);
                                jSONObject8.put("path4Web", str3);
                                str = str3;
                            } else {
                                str = str3;
                                p0.a("OperateViews", "VideoPath not null");
                                jSONObject8.put("path", e4);
                                jSONObject8.put("path4Web", e4);
                            }
                            if (b2.b() == 5) {
                                jSONObject8.put("downloaded", 1);
                                z = false;
                            } else {
                                z = false;
                                jSONObject8.put("downloaded", 0);
                            }
                            jSONObject4.put(optString, jSONObject8);
                            jSONArray2.put(jSONObject4);
                        } else {
                            str = str3;
                            i2 = length;
                            z = false;
                            p0.a("OperateViews", "VideoBean null");
                        }
                    }
                    i4++;
                    jSONArray = jSONArray3;
                    length = i2;
                    str3 = str;
                    i3 = 1;
                }
                jSONObject2.put("resource", jSONArray2);
                f.a().b(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                return;
            } catch (Throwable th2) {
                jSONObject2.put("code", 1);
                jSONObject2.put(PglCryptUtils.KEY_MESSAGE, th2.getLocalizedMessage());
                f.a().b(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                return;
            }
            jSONObject2.put("code", 1);
            jSONObject2.put(PglCryptUtils.KEY_MESSAGE, th2.getLocalizedMessage());
            f.a().b(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            return;
        } catch (JSONException e5) {
            p0.a("OperateViews", e5.getMessage());
            return;
        }
    }

    public void n(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e2 = e(optString2);
            if (TextUtils.isEmpty(e2) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b) != null) {
                e2 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                a(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, e2);
            if (!b2.containsKey(optString2)) {
                a(obj, "instanceId not exist");
                p0.a("OperateViews", "hideView failed: instanceId not exist");
                return;
            }
            View view = b2.get(optString2);
            if (view == null) {
                a(obj, "view not exist");
                p0.a("OperateViews", "hideView failed: view not exist");
            } else {
                view.setVisibility(8);
                b(obj, optString2);
                a(obj, "onHideView", optString2);
                p0.a("OperateViews", "hideView instanceId = " + optString2);
            }
        } catch (Throwable th) {
            a(obj, th.getMessage());
            p0.a("OperateViews", "hideView failed: + " + th.getMessage());
        }
    }

    public void o(Object obj, JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                a(obj, "data is empty");
                return;
            }
            CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(optJSONObject);
            if (parseCampaignWithBackData == null) {
                a(obj, "data camapign is empty");
            } else {
                a(parseCampaignWithBackData);
                b(obj, "");
            }
        } catch (Throwable th) {
            a(obj, th.getMessage());
        }
    }

    public void p(Object obj, JSONObject jSONObject) {
        int optInt;
        int optInt2;
        Rect rect;
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e2 = e(optString2);
            if (TextUtils.isEmpty(e2) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b) != null) {
                e2 = windVaneWebView.getRid();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                a(obj, "data is empty");
                return;
            }
            String optString3 = optJSONObject.optString("id");
            LinkedHashMap<String, View> b2 = b(optString, e2);
            if (!b2.containsKey(optString3) || !b2.containsKey(optString2)) {
                a(obj, "instanceId is not exist");
                p0.a("OperateViews", "appendSubView failed: instanceId is not exist");
                return;
            }
            ViewGroup viewGroup = (ViewGroup) b2.get(optString2);
            View view = b2.get(optString3);
            if (viewGroup != null && view != null) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
                if (view instanceof MBTempContainer) {
                    p0.b("OperateViews", "OperateViews setNotchString = " + String.format("%1$s-%2$s-%3$s-%4$s-%5$s", Integer.valueOf(l), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(o), Integer.valueOf(p)));
                    ((MBTempContainer) view).setNotchPadding(l, m, n, o, p);
                    Iterator<View> it = b2.values().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        View next = it.next();
                        if (next instanceof MBridgeBTContainer) {
                            e1.a(view);
                            ((MBridgeBTContainer) next).appendSubView((MBridgeBTContainer) next, (MBTempContainer) view, optJSONObject2);
                            break;
                        }
                    }
                } else {
                    if (optJSONObject2 != null) {
                        Rect rect2 = new Rect(optJSONObject2.optInt("left", -999), optJSONObject2.optInt("top", -999), optJSONObject2.optInt("right", -999), optJSONObject2.optInt("bottom", -999));
                        optInt = optJSONObject2.optInt("width");
                        optInt2 = optJSONObject2.optInt("height");
                        rect = rect2;
                    } else if (view instanceof BTBaseView) {
                        rect = ((BTBaseView) view).getRect();
                        optInt = ((BTBaseView) view).getViewWidth();
                        optInt2 = ((BTBaseView) view).getViewHeight();
                    } else {
                        optInt = 0;
                        rect = null;
                        optInt2 = 0;
                    }
                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                    if (viewGroup instanceof FrameLayout) {
                        layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    } else if (viewGroup instanceof RelativeLayout) {
                        layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    } else if (viewGroup instanceof LinearLayout) {
                        layoutParams = new LinearLayout.LayoutParams(-1, -1);
                    }
                    viewGroup.addView(view, a(layoutParams, rect, optInt, optInt2));
                }
                b(obj, optString2);
                a(obj, "onAppendView", optString2);
                p0.a("OperateViews", "appendSubView parentId = " + optString2 + " childId = " + optString3);
                return;
            }
            a(obj, "view is not exist");
        } catch (Throwable th) {
            a(obj, th.getMessage());
            p0.a("OperateViews", "appendSubView failed: " + th.getMessage());
        }
    }

    public void q(Object obj, JSONObject jSONObject) {
        int optInt;
        int optInt2;
        Rect rect;
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e2 = e(optString2);
            if (TextUtils.isEmpty(e2) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b) != null) {
                e2 = windVaneWebView.getRid();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null && !TextUtils.isEmpty(optString)) {
                String optString3 = optJSONObject.optString("id");
                LinkedHashMap<String, View> b2 = b(optString, e2);
                if (!b2.containsKey(optString2) || !b2.containsKey(optString3)) {
                    a(obj, "instanceId is not exist");
                    p0.a("OperateViews", "appendViewTo failed: instanceId is not exist");
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) b2.get(optString3);
                View view = b2.get(optString2);
                if (viewGroup != null && view != null) {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
                    if (view instanceof MBTempContainer) {
                        Iterator<View> it = b2.values().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            View next = it.next();
                            if (next instanceof MBridgeBTContainer) {
                                e1.a(view);
                                ((MBridgeBTContainer) next).appendSubView((MBridgeBTContainer) next, (MBTempContainer) view, optJSONObject2);
                                break;
                            }
                        }
                    } else {
                        if (optJSONObject2 != null) {
                            Rect rect2 = new Rect(optJSONObject2.optInt("left", -999), optJSONObject2.optInt("top", -999), optJSONObject2.optInt("right", -999), optJSONObject2.optInt("bottom", -999));
                            optInt = optJSONObject2.optInt("width");
                            optInt2 = optJSONObject2.optInt("height");
                            rect = rect2;
                        } else if (view instanceof BTBaseView) {
                            rect = ((BTBaseView) view).getRect();
                            optInt = ((BTBaseView) view).getViewWidth();
                            optInt2 = ((BTBaseView) view).getViewHeight();
                        } else {
                            optInt = 0;
                            rect = null;
                            optInt2 = 0;
                        }
                        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                        if (viewGroup instanceof FrameLayout) {
                            layoutParams = new FrameLayout.LayoutParams(-1, -1);
                        } else if (viewGroup instanceof RelativeLayout) {
                            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                        } else if (viewGroup instanceof LinearLayout) {
                            layoutParams = new LinearLayout.LayoutParams(-1, -1);
                        }
                        viewGroup.addView(view, a(layoutParams, rect, optInt, optInt2));
                    }
                    b(obj, optString2);
                    a(obj, "onAppendViewTo", optString2);
                    p0.a("OperateViews", "appendViewTo parentId = " + optString3 + " childId = " + optString2);
                    return;
                }
                a(obj, "view is not exist");
                return;
            }
            a(obj, "unitId or data is empty");
        } catch (Throwable th) {
            a(obj, th.getMessage());
            p0.a("OperateViews", "appendViewTo failed: " + th.getMessage());
        }
    }

    public void r(Object obj, JSONObject jSONObject) {
        int optInt;
        int optInt2;
        Rect rect;
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e2 = e(optString2);
            if (TextUtils.isEmpty(e2) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b) != null) {
                e2 = windVaneWebView.getRid();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                a(obj, "data is empty");
                return;
            }
            String optString3 = optJSONObject.optString("targetComponentId");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
            LinkedHashMap<String, View> b2 = b(optString, e2);
            if (!b2.containsKey(optString2) || !b2.containsKey(optString3)) {
                a(obj, "instanceId not exist");
                p0.a("OperateViews", "insertViewAbove failed: instanceId not exist instanceId = " + optString2);
                return;
            }
            View view = b2.get(optString2);
            View view2 = b2.get(optString3);
            if (view2 == null || view2.getParent() == null) {
                a(obj, "view not exist");
                p0.a("OperateViews", "insertViewAbove failed: view not exist instanceId = " + optString2);
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            int indexOfChild = viewGroup.indexOfChild(view2);
            if (optJSONObject2 != null) {
                Rect rect2 = new Rect(optJSONObject2.optInt("left", -999), optJSONObject2.optInt("top", -999), optJSONObject2.optInt("right", -999), optJSONObject2.optInt("bottom", -999));
                optInt = optJSONObject2.optInt("width");
                optInt2 = optJSONObject2.optInt("height");
                rect = rect2;
            } else if (view instanceof BTBaseView) {
                rect = ((BTBaseView) view).getRect();
                optInt = ((BTBaseView) view).getViewWidth();
                optInt2 = ((BTBaseView) view).getViewHeight();
            } else {
                optInt = 0;
                rect = null;
                optInt2 = 0;
            }
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (viewGroup instanceof FrameLayout) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof RelativeLayout) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof LinearLayout) {
                layoutParams = new LinearLayout.LayoutParams(-1, -1);
            }
            viewGroup.addView(view, indexOfChild + 1, a(layoutParams, rect, optInt, optInt2));
            b(obj, optString2);
            a(obj, "onInsertViewAbove", optString2);
            p0.a("OperateViews", "insertViewAbove instanceId = " + optString2 + " brotherId = " + optString3);
        } catch (Throwable th) {
            a(obj, th.getMessage());
            p0.a("OperateViews", "insertViewAbove failed: " + th.getMessage());
        }
    }

    public void s(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e2 = e(optString2);
            if (TextUtils.isEmpty(e2) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b) != null) {
                e2 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                a(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, e2);
            if (!b2.containsKey(optString2)) {
                a(obj, "instanceId not exist");
                p0.a("OperateViews", "playerGetMuteState failed instanceId not exist");
                return;
            }
            View view = b2.get(optString2);
            if (!(view instanceof MBridgeBTVideoView)) {
                a(obj, "instanceId is not player");
                p0.a("OperateViews", "playerGetMuteState failed instanceId is not player");
                return;
            }
            int mute = ((MBridgeBTVideoView) view).getMute();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", i);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("id", optString2);
            jSONObject3.put(CampaignEx.JSON_NATIVE_VIDEO_MUTE, mute);
            jSONObject2.put("data", jSONObject3);
            f.a().b(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            p0.a("OperateViews", "playerGetMuteState successed mute = " + mute);
        } catch (Throwable th) {
            a(obj, th.getMessage());
            p0.a("OperateViews", "playerGetMuteState failed: " + th.getMessage());
        }
    }

    public void t(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e2 = e(optString2);
            if (TextUtils.isEmpty(e2) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b) != null) {
                e2 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                a(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, e2);
            if (!b2.containsKey(optString2)) {
                a(obj, "instanceId not exist");
                p0.a("OperateViews", "playerMute failed: instanceId is not exist");
                return;
            }
            View view = b2.get(optString2);
            if (!(view instanceof MBridgeBTVideoView)) {
                a(obj, "instanceId is not player");
                p0.a("OperateViews", "playerMute failed: instanceId is not player");
            } else if (((MBridgeBTVideoView) view).playMute()) {
                b(obj, optString2);
                p0.a("OperateViews", "playerMute success");
            } else {
                a(obj, "set mute failed");
                p0.a("OperateViews", "playerMute failed set mute failed");
            }
        } catch (Throwable th) {
            a(obj, th.getMessage());
            p0.a("OperateViews", "playerMute failed: " + th.getMessage());
        }
    }

    public void u(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e2 = e(optString2);
            if (TextUtils.isEmpty(e2) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b) != null) {
                e2 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                a(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, e2);
            if (!b2.containsKey(optString2)) {
                a(obj, "instanceId not exit");
                p0.a("OperateViews", "playerPause failed instanceId not exit instanceId = " + optString2);
                return;
            }
            View view = b2.get(optString2);
            if (!(view instanceof MBridgeBTVideoView)) {
                a(obj, "instanceId is not player");
                p0.a("OperateViews", "playerPause failed instanceId is not player instanceId = " + optString2);
            } else {
                ((MBridgeBTVideoView) view).pause();
                b(obj, optString2);
                p0.a("OperateViews", "playerPause success");
            }
        } catch (Throwable th) {
            a(obj, th.getMessage());
            p0.a("OperateViews", "playerPause failed: " + th.getMessage());
        }
    }

    public void v(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e2 = e(optString2);
            if (TextUtils.isEmpty(e2) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b) != null) {
                e2 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                a(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, e2);
            if (!b2.containsKey(optString2)) {
                a(obj, "instanceId not exit");
                p0.a("OperateViews", "playerPlay failed instanceId not exit instanceId = " + optString2);
                return;
            }
            View view = b2.get(optString2);
            if (!(view instanceof MBridgeBTVideoView)) {
                a(obj, "instanceId is not player");
                p0.a("OperateViews", "playerPlay failed instanceId is not player instanceId = " + optString2);
                return;
            }
            MBridgeBTVideoView mBridgeBTVideoView = (MBridgeBTVideoView) view;
            MBridgeBTContainer a2 = a(optString, e2);
            if (a2 != null) {
                mBridgeBTVideoView.setAdEvents(a2.getAdEvents());
                mBridgeBTVideoView.setAdSession(a2.getAdSession());
                mBridgeBTVideoView.setVideoEvents(a2.getVideoEvents());
            }
            mBridgeBTVideoView.play();
            b(obj, optString2);
            p0.a("OperateViews", "playerPlay success");
        } catch (Throwable th) {
            a(obj, th.getMessage());
            p0.a("OperateViews", "playerPlay failed: " + th.getMessage());
        }
    }

    public void w(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e2 = e(optString2);
            if (TextUtils.isEmpty(e2) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b) != null) {
                e2 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                a(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, e2);
            if (!b2.containsKey(optString2)) {
                a(obj, "instanceId not exit");
                p0.a("OperateViews", "playerResume failed instanceId not exit instanceId = " + optString2);
                return;
            }
            View view = b2.get(optString2);
            if (!(view instanceof MBridgeBTVideoView)) {
                a(obj, "instanceId is not player");
                p0.a("OperateViews", "playerResume failed instanceId is not player instanceId = " + optString2);
            } else {
                ((MBridgeBTVideoView) view).resume();
                b(obj, optString2);
                p0.a("OperateViews", "playerResume success");
            }
        } catch (Throwable th) {
            a(obj, th.getMessage());
            p0.a("OperateViews", "playerResume failed: " + th.getMessage());
        }
    }

    public void x(Object obj, JSONObject jSONObject) {
        try {
            jSONObject.optString("unitId");
            jSONObject.optString("id");
            if (jSONObject.optJSONObject("data") == null) {
                a(obj, "data is empty");
            } else {
                a(obj, "android mediaPlayer not support setScaleType");
            }
        } catch (Throwable th) {
            a(obj, th.getMessage());
        }
    }

    public void y(Object obj, JSONObject jSONObject) {
        try {
            jSONObject.optString("unitId");
            if (jSONObject.optJSONObject("data") == null) {
                a(obj, "data is empty");
            }
        } catch (Throwable th) {
            a(obj, th.getMessage());
        }
    }

    public void z(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e2 = e(optString2);
            if (TextUtils.isEmpty(e2) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b) != null) {
                e2 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                a(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, e2);
            if (!b2.containsKey(optString2)) {
                a(obj, "instanceId not exit");
                p0.a("OperateViews", "playerStop failed instanceId not exit instanceId = " + optString2);
                return;
            }
            View view = b2.get(optString2);
            if (!(view instanceof MBridgeBTVideoView)) {
                a(obj, "instanceId is not player");
                p0.a("OperateViews", "playerStop failed instanceId is not player instanceId = " + optString2);
            } else {
                ((MBridgeBTVideoView) view).stop();
                b(obj, optString2);
                p0.a("OperateViews", "playerStop success");
            }
        } catch (Throwable th) {
            a(obj, th.getMessage());
            p0.a("OperateViews", "playerStop failed: " + th.getMessage());
        }
    }

    /* compiled from: BaseOperateViews.java */
    /* renamed from: com.mbridge.msdk.video.bt.component.a$a, reason: collision with other inner class name */
    class RunnableC0403a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f4984a;
        final /* synthetic */ String b;
        final /* synthetic */ Rect c;
        final /* synthetic */ int d;
        final /* synthetic */ int e;

        RunnableC0403a(Object obj, String str, Rect rect, int i, int i2) {
            this.f4984a = obj;
            this.b = str;
            this.c = rect;
            this.d = i;
            this.e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) this.f4984a).b;
            if (windVaneWebView == null) {
                str = "";
                windVaneWebView = null;
            } else {
                str = windVaneWebView.getRid();
            }
            LinkedHashMap<String, View> b = a.this.b(this.b, str);
            String b2 = a.this.b();
            a.b.put(b2, str);
            MBridgeBTLayout mBridgeBTLayout = new MBridgeBTLayout(com.mbridge.msdk.foundation.controller.c.m().d());
            b.put(b2, mBridgeBTLayout);
            mBridgeBTLayout.setInstanceId(b2);
            mBridgeBTLayout.setUnitId(this.b);
            mBridgeBTLayout.setWebView(windVaneWebView);
            mBridgeBTLayout.setRect(this.c);
            int i = this.d;
            if (i > 0 || this.e > 0) {
                mBridgeBTLayout.setLayout(i, this.e);
            }
            a.this.b(this.f4984a, b2);
            p0.a("OperateViews", "create view instanceId = " + b2);
        }
    }

    /* compiled from: BaseOperateViews.java */
    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f4985a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;
        final /* synthetic */ Rect f;
        final /* synthetic */ int g;
        final /* synthetic */ int h;

        b(Object obj, String str, String str2, String str3, String str4, Rect rect, int i, int i2) {
            this.f4985a = obj;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = rect;
            this.g = i;
            this.h = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) this.f4985a).b;
            if (windVaneWebView == null) {
                str = "";
                windVaneWebView = null;
            } else {
                str = windVaneWebView.getRid();
            }
            LinkedHashMap<String, View> b = a.this.b(this.b, str);
            String b2 = a.this.b();
            a.b.put(b2, str);
            MBridgeBTWebView mBridgeBTWebView = new MBridgeBTWebView(com.mbridge.msdk.foundation.controller.c.m().d());
            b.put(b2, mBridgeBTWebView);
            mBridgeBTWebView.setInstanceId(b2);
            mBridgeBTWebView.setUnitId(this.b);
            mBridgeBTWebView.setFileURL(this.c);
            mBridgeBTWebView.setFilePath(this.d);
            mBridgeBTWebView.setHtml(this.e);
            mBridgeBTWebView.setRect(this.f);
            mBridgeBTWebView.setWebViewRid(str);
            mBridgeBTWebView.setCreateWebView(windVaneWebView);
            int i = this.g;
            if (i > 0 || this.h > 0) {
                mBridgeBTWebView.setLayout(i, this.h);
            }
            mBridgeBTWebView.preload();
            a.this.b(this.f4985a, b2);
            p0.a("OperateViews", "createWebview instanceId = " + b2);
        }
    }

    public com.mbridge.msdk.videocommon.setting.c d(String str) {
        if (d.containsKey(str)) {
            return d.get(str);
        }
        return null;
    }

    public void h(Object obj, JSONObject jSONObject) {
        String str;
        WindVaneWebView windVaneWebView;
        String str2 = "OperateViews";
        try {
            String optString = jSONObject.optString("unitId");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null && !TextUtils.isEmpty(optString)) {
                int optInt = optJSONObject.optInt(CampaignEx.JSON_NATIVE_VIDEO_MUTE);
                String str3 = "";
                CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(optJSONObject.optJSONObject("campaign"));
                if (parseCampaignWithBackData != null && !TextUtils.isEmpty(optString)) {
                    parseCampaignWithBackData.setCampaignUnitId(optString);
                    str3 = parseCampaignWithBackData.getRequestId();
                }
                com.mbridge.msdk.videocommon.setting.c a2 = com.mbridge.msdk.videocommon.setting.c.a(optJSONObject.optJSONObject("unitSetting"));
                if (a2 != null) {
                    a2.h(optString);
                }
                String optString2 = optJSONObject.optString("userId");
                if (TextUtils.isEmpty(str3) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b) != null) {
                    str3 = windVaneWebView.getRid();
                }
                LinkedHashMap<String, View> b2 = b(optString, str3);
                String b3 = b();
                b.put(b3, str3);
                MBTempContainer mBTempContainer = new MBTempContainer(com.mbridge.msdk.foundation.controller.c.m().d());
                try {
                    k kVar = (k) ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b.getObject();
                    mBTempContainer.setAdEvents(kVar.j());
                    mBTempContainer.setAdSession(kVar.k());
                    mBTempContainer.setVideoEvents(kVar.o());
                } catch (Exception e2) {
                    p0.b("OperateViews", e2.getMessage());
                }
                mBTempContainer.setInstanceId(b3);
                mBTempContainer.setUnitId(optString);
                mBTempContainer.setCampaign(parseCampaignWithBackData);
                mBTempContainer.setRewardUnitSetting(a2);
                mBTempContainer.setBigOffer(true);
                if (!TextUtils.isEmpty(optString2)) {
                    mBTempContainer.setUserId(optString2);
                }
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(C3288s.j);
                if (optJSONObject2 != null) {
                    try {
                        String optString3 = optJSONObject2.optString("id");
                        str = "OperateViews";
                        try {
                            com.mbridge.msdk.videocommon.entity.c cVar = new com.mbridge.msdk.videocommon.entity.c(optJSONObject2.optString("name"), optJSONObject2.optInt("amount"));
                            if (!TextUtils.isEmpty(optString3)) {
                                mBTempContainer.setRewardId(optString3);
                            }
                            if (!TextUtils.isEmpty(cVar.c())) {
                                mBTempContainer.setReward(cVar);
                            }
                        } catch (Throwable th) {
                            th = th;
                            str2 = str;
                            a(obj, th.getMessage());
                            p0.a(str2, "createSubPlayTemplateView failed：" + th.getMessage());
                            return;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        a(obj, th.getMessage());
                        p0.a(str2, "createSubPlayTemplateView failed：" + th.getMessage());
                        return;
                    }
                } else {
                    str = "OperateViews";
                }
                String optString4 = optJSONObject.optString("extra");
                if (!TextUtils.isEmpty(optString4)) {
                    mBTempContainer.setDeveloperExtraData(optString4);
                }
                mBTempContainer.setMute(optInt);
                b2.put(b3, mBTempContainer);
                e.put(b3, optString);
                c.put(b3, parseCampaignWithBackData);
                d.put(b3, a2);
                b(obj, b3);
                p0.a(str, "createSubPlayTemplateView instanceId = " + b3);
                return;
            }
            a(obj, "unitId or data is empty");
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public void a(String str, Activity activity) {
        g.put(str, activity);
    }

    public void b(String str) {
        if (f.containsKey(str)) {
            f.remove(str);
        }
    }

    public void c(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e2 = e(optString2);
            if (TextUtils.isEmpty(e2) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b) != null) {
                e2 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                a(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, e2);
            if (b2.containsKey(optString2)) {
                View view = b2.get(optString2);
                if (view != null && view.getParent() != null) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        viewGroup.bringChildToFront(view);
                        b(obj, optString2);
                        a(obj, "onBringViewToFront", optString2);
                        p0.a("OperateViews", "bringViewToFront instanceId = " + optString2);
                        return;
                    }
                    a(obj, "parent is null");
                    p0.a("OperateViews", "bringViewToFront failed: parent is null");
                    return;
                }
                a(obj, "view is null");
                p0.a("OperateViews", "bringViewToFront failed: view is null");
                return;
            }
            a(obj, "instanceId is not exist");
            p0.a("OperateViews", "bringViewToFront failed: instanceId is not exist");
        } catch (Throwable th) {
            a(obj, th.getMessage());
            p0.a("OperateViews", "bringViewToFront failed: " + th.getMessage());
        }
    }

    public void g(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("unitId");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null && !TextUtils.isEmpty(optString)) {
                String str = "";
                CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(optJSONObject.optJSONObject("campaign"));
                if (parseCampaignWithBackData != null && !TextUtils.isEmpty(optString)) {
                    parseCampaignWithBackData.setCampaignUnitId(optString);
                    str = parseCampaignWithBackData.getRequestId();
                }
                int optInt = optJSONObject.optInt("show_time", 0);
                int optInt2 = optJSONObject.optInt("show_mute", 0);
                int optInt3 = optJSONObject.optInt("show_close", 0);
                int optInt4 = optJSONObject.optInt("orientation", 1);
                int optInt5 = optJSONObject.optInt("show_pgb", 0);
                MBridgeBTVideoView mBridgeBTVideoView = new MBridgeBTVideoView(com.mbridge.msdk.foundation.controller.c.m().d());
                try {
                    k kVar = (k) ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b.getObject();
                    mBridgeBTVideoView.setAdEvents(kVar.j());
                    mBridgeBTVideoView.setAdSession(kVar.k());
                    mBridgeBTVideoView.setVideoEvents(kVar.o());
                } catch (Exception e2) {
                    p0.b("OperateViews", e2.getMessage());
                }
                mBridgeBTVideoView.setCampaign(parseCampaignWithBackData);
                mBridgeBTVideoView.setUnitId(optString);
                mBridgeBTVideoView.setShowMute(optInt2);
                mBridgeBTVideoView.setShowTime(optInt);
                mBridgeBTVideoView.setShowClose(optInt3);
                mBridgeBTVideoView.setOrientation(optInt4);
                mBridgeBTVideoView.setProgressBarState(optInt5);
                WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b;
                if (windVaneWebView != null) {
                    str = windVaneWebView.getRid();
                    mBridgeBTVideoView.setCreateWebView(windVaneWebView);
                }
                LinkedHashMap<String, View> b2 = b(optString, str);
                String b3 = b();
                b.put(b3, str);
                mBridgeBTVideoView.setInstanceId(b3);
                b2.put(b3, mBridgeBTVideoView);
                mBridgeBTVideoView.preLoadData();
                if (parseCampaignWithBackData == null) {
                    a(obj, "campaign is null");
                    p0.a("OperateViews", "createPlayerView failed");
                } else {
                    b(obj, b3);
                    p0.a("OperateViews", "createPlayerView instanceId = " + b3);
                }
                com.mbridge.msdk.video.bt.component.b.a().a(b3, mBridgeBTVideoView);
                return;
            }
            a(obj, "unitId or data is empty");
        } catch (Throwable th) {
            a(obj, th.getMessage());
            p0.a("OperateViews", "createPlayerView failed：" + th.getMessage());
        }
    }

    public void a(String str, int i2) {
        f.put(str, Integer.valueOf(i2));
    }

    public void d(Object obj, JSONObject jSONObject) {
        try {
            WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b;
            String rid = windVaneWebView != null ? windVaneWebView.getRid() : "";
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString(C3040d4.h.j0);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            LinkedHashMap<String, View> b2 = b(optString, rid);
            if (b2 != null && b2.size() > 0) {
                for (View view : b2.values()) {
                    if (view instanceof MBridgeBTWebView) {
                        ((MBridgeBTWebView) view).broadcast(optString2, optJSONObject);
                    }
                    if (view instanceof MBridgeBTLayout) {
                        ((MBridgeBTLayout) view).broadcast(optString2, optJSONObject);
                    }
                }
                b(obj, "");
                return;
            }
            a(obj, "unitId not exist");
        } catch (Throwable th) {
            a(obj, th.getMessage());
            p0.a("OperateViews", "broadcast failed: " + th.getMessage());
        }
    }

    public void a(String str) {
        if (e.containsKey(str)) {
            e.remove(str);
        }
        if (d.containsKey(str)) {
            d.remove(str);
        }
        if (c.containsKey(str)) {
            c.remove(str);
        }
        if (b.containsKey(str)) {
            b.remove(str);
        }
    }

    public synchronized LinkedHashMap<String, View> b(String str, String str2) {
        if (f4983a.containsKey(str + "_" + str2)) {
            return f4983a.get(str + "_" + str2);
        }
        LinkedHashMap<String, View> linkedHashMap = new LinkedHashMap<>();
        f4983a.put(str + "_" + str2, linkedHashMap);
        return linkedHashMap;
    }

    public void e(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e2 = e(optString2);
            if (TextUtils.isEmpty(e2) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b) != null) {
                e2 = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                a(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, e2);
            if (b2.size() > 0) {
                MBridgeBTContainer mBridgeBTContainer = null;
                for (View view : b2.values()) {
                    if (view instanceof MBridgeBTContainer) {
                        mBridgeBTContainer = (MBridgeBTContainer) view;
                    } else if (view instanceof MBridgeBTWebView) {
                        ((MBridgeBTWebView) view).onDestory();
                    } else if (view instanceof MBridgeBTVideoView) {
                        com.mbridge.msdk.video.bt.component.b.a().a(((MBridgeBTVideoView) view).getInstanceId());
                        ((MBridgeBTVideoView) view).onDestory();
                    } else if (view instanceof MBTempContainer) {
                        ((MBTempContainer) view).onDestroy();
                    }
                }
                if (mBridgeBTContainer != null) {
                    mBridgeBTContainer.onAdClose();
                    f4983a.remove(b2);
                    b2.clear();
                    f4983a.remove(optString + "_" + e2);
                    b(obj, optString2);
                    return;
                }
                a(obj, "not found MBridgeBTContainer");
                p0.a("OperateViews", "closeAd successed");
                return;
            }
            a(obj, "unitId or instanceId not exist");
            p0.a("OperateViews", "closeAd failed: unitId or instanceId not exist unitId = " + optString);
        } catch (Throwable th) {
            a(obj, th.getMessage());
            p0.a("OperateViews", "closeAd failed: " + th.getMessage());
        }
    }

    public void f(Object obj, JSONObject jSONObject) {
        p0.a("OperateViews", "createNativeEC:" + jSONObject);
        try {
            String optString = jSONObject.optString("unitId");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null && !TextUtils.isEmpty(optString)) {
                String str = "";
                CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(optJSONObject.optJSONObject("campaign"));
                if (parseCampaignWithBackData != null && !TextUtils.isEmpty(optString)) {
                    parseCampaignWithBackData.setCampaignUnitId(optString);
                    str = parseCampaignWithBackData.getRequestId();
                }
                com.mbridge.msdk.videocommon.setting.c a2 = com.mbridge.msdk.videocommon.setting.c.a(optJSONObject.optJSONObject("unitSetting"));
                if (a2 != null) {
                    a2.h(optString);
                }
                MBridgeBTNativeEC mBridgeBTNativeEC = new MBridgeBTNativeEC(com.mbridge.msdk.foundation.controller.c.m().d());
                mBridgeBTNativeEC.setCampaign(parseCampaignWithBackData);
                k kVar = new k(null, parseCampaignWithBackData);
                kVar.setUnitId(optString);
                mBridgeBTNativeEC.setJSCommon(kVar);
                mBridgeBTNativeEC.setUnitId(optString);
                mBridgeBTNativeEC.setRewardUnitSetting(a2);
                WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b;
                if (windVaneWebView != null) {
                    str = windVaneWebView.getRid();
                    mBridgeBTNativeEC.setCreateWebView(windVaneWebView);
                }
                LinkedHashMap<String, View> b2 = b(optString, str);
                String b3 = b();
                b.put(b3, str);
                mBridgeBTNativeEC.setInstanceId(b3);
                b2.put(b3, mBridgeBTNativeEC);
                mBridgeBTNativeEC.preLoadData();
                if (parseCampaignWithBackData == null) {
                    a(obj, "campaign is null");
                    p0.a("OperateViews", "createNativeEC failed");
                    return;
                } else {
                    b(obj, b3);
                    p0.a("OperateViews", "createNativeEC instanceId = " + b3);
                    return;
                }
            }
            a(obj, "unitId or data is empty");
        } catch (Throwable th) {
            a(obj, th.getMessage());
            p0.a("OperateViews", "createNativeEC failed：" + th.getMessage());
        }
    }

    public void b(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", str);
            jSONObject.put("data", jSONObject2);
            f.a().b(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            a(obj, e2.getMessage());
            p0.a("OperateViews", e2.getMessage());
        }
    }

    public void a(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", j);
            jSONObject.put(PglCryptUtils.KEY_MESSAGE, str);
            jSONObject.put("data", new JSONObject());
            f.a().b(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            p0.a("OperateViews", e2.getMessage());
        }
    }

    public void b(Object obj, JSONObject jSONObject) {
        int optInt;
        int optInt2;
        Rect rect;
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e2 = e(optString2);
            if (TextUtils.isEmpty(e2) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b) != null) {
                e2 = windVaneWebView.getRid();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null && !TextUtils.isEmpty(optString)) {
                String optString3 = optJSONObject.optString("id");
                LinkedHashMap<String, View> b2 = b(optString, e2);
                if (b2.containsKey(optString2) && b2.containsKey(optString3)) {
                    ViewGroup viewGroup = (ViewGroup) b2.get(optString3);
                    View view = b2.get(optString2);
                    e1.a(view);
                    if (viewGroup != null && view != null) {
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
                        if (view instanceof MBTempContainer) {
                            Iterator<View> it = b2.values().iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                View next = it.next();
                                if (next instanceof MBridgeBTContainer) {
                                    e1.a(view);
                                    ((MBridgeBTContainer) next).appendSubView((MBridgeBTContainer) next, (MBTempContainer) view, optJSONObject2);
                                    break;
                                }
                            }
                        } else {
                            if (optJSONObject2 == null) {
                                if (view instanceof BTBaseView) {
                                    rect = ((BTBaseView) view).getRect();
                                    optInt = ((BTBaseView) view).getViewWidth();
                                    optInt2 = ((BTBaseView) view).getViewHeight();
                                } else {
                                    optInt = 0;
                                    rect = null;
                                    optInt2 = 0;
                                }
                            } else {
                                Rect rect2 = new Rect(optJSONObject2.optInt("left", -999), optJSONObject2.optInt("top", -999), optJSONObject2.optInt("right", -999), optJSONObject2.optInt("bottom", -999));
                                optInt = optJSONObject2.optInt("width");
                                optInt2 = optJSONObject2.optInt("height");
                                rect = rect2;
                            }
                            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                            if (viewGroup instanceof FrameLayout) {
                                layoutParams = new FrameLayout.LayoutParams(-1, -1);
                            } else if (viewGroup instanceof RelativeLayout) {
                                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                            } else if (viewGroup instanceof LinearLayout) {
                                layoutParams = new LinearLayout.LayoutParams(-1, -1);
                            }
                            ViewGroup.LayoutParams a2 = a(layoutParams, rect, optInt, optInt2);
                            e1.a(view);
                            viewGroup.addView(view, a2);
                        }
                        b(obj, optString2);
                        a(obj, "onAppendViewTo", optString2);
                        p0.a("OperateViews", "appendViewTo parentId = " + optString3 + " childId = " + optString2);
                        return;
                    }
                    a(obj, "view is not exist");
                    return;
                }
                a(obj, "instanceId is not exist");
                p0.a("OperateViews", "appendViewTo failed: instanceId is not exist");
                return;
            }
            a(obj, "unitId or data is empty");
        } catch (Throwable th) {
            a(obj, th.getMessage());
            p0.a("OperateViews", "appendViewTo failed: " + th.getMessage());
        }
    }

    public void a(WebView webView, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", j);
            jSONObject.put(PglCryptUtils.KEY_MESSAGE, str);
            jSONObject.put("data", new JSONObject());
            f.a().b(webView, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            p0.a("OperateViews", e2.getMessage());
        }
    }

    public void a(Object obj, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", str2);
            jSONObject.put("data", jSONObject2);
            f.a().a(obj, str, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            a(obj, e2.getMessage());
            p0.a("OperateViews", e2.getMessage());
        }
    }

    public void a(WebView webView, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", str2);
            jSONObject.put("data", jSONObject2);
            f.a().a(webView, str, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            a(webView, e2.getMessage());
            p0.a("OperateViews", e2.getMessage());
        }
    }

    public void c(Object obj, String str) {
        p0.a("OperateViews", "reportUrls:" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                int optInt = jSONObject.optInt("type");
                String a2 = u0.a(jSONObject.optString("url"), "&tun=", l0.y() + "");
                int optInt2 = jSONObject.optInt("report");
                if (optInt2 == 0) {
                    com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), (CampaignEx) null, "", a2, false, optInt != 0);
                } else {
                    com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), (CampaignEx) null, "", a2, false, optInt != 0, optInt2);
                }
            }
            try {
                b(obj, "");
            } catch (Throwable th) {
                th = th;
                p0.b("OperateViews", "reportUrls", th);
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARN: Type inference failed for: r5v2, types: [android.widget.LinearLayout$LayoutParams] */
    public ViewGroup.LayoutParams a(ViewGroup.LayoutParams layoutParams, Rect rect, int i2, int i3) {
        if (rect == null) {
            rect = new Rect(-999, -999, -999, -999);
        }
        Context d2 = com.mbridge.msdk.foundation.controller.c.m().d();
        if (d2 != null) {
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
                int i4 = rect.left;
                if (i4 != -999) {
                    layoutParams2.leftMargin = u0.a(d2, i4);
                }
                int i5 = rect.top;
                if (i5 != -999) {
                    layoutParams2.topMargin = u0.a(d2, i5);
                }
                int i6 = rect.right;
                if (i6 != -999) {
                    layoutParams2.rightMargin = u0.a(d2, i6);
                }
                int i7 = rect.bottom;
                if (i7 != -999) {
                    layoutParams2.bottomMargin = u0.a(d2, i7);
                }
                if (i2 > 0) {
                    layoutParams2.width = u0.a(d2, i2);
                }
                if (i3 > 0) {
                    layoutParams2.height = u0.a(d2, i3);
                }
                return layoutParams2;
            }
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
                int i8 = rect.left;
                if (i8 != -999) {
                    layoutParams3.leftMargin = u0.a(d2, i8);
                }
                int i9 = rect.top;
                if (i9 != -999) {
                    layoutParams3.topMargin = u0.a(d2, i9);
                }
                int i10 = rect.right;
                if (i10 != -999) {
                    layoutParams3.rightMargin = u0.a(d2, i10);
                }
                int i11 = rect.bottom;
                if (i11 != -999) {
                    layoutParams3.bottomMargin = u0.a(d2, i11);
                }
                if (i2 > 0) {
                    layoutParams3.width = u0.a(d2, i2);
                }
                if (i3 > 0) {
                    layoutParams3.height = u0.a(d2, i3);
                }
                return layoutParams3;
            }
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                layoutParams = new LinearLayout.LayoutParams(-1, -1);
                int i12 = rect.left;
                if (i12 != -999) {
                    ((LinearLayout.LayoutParams) layoutParams).leftMargin = u0.a(d2, i12);
                }
                int i13 = rect.top;
                if (i13 != -999) {
                    ((LinearLayout.LayoutParams) layoutParams).topMargin = u0.a(d2, i13);
                }
                int i14 = rect.right;
                if (i14 != -999) {
                    ((LinearLayout.LayoutParams) layoutParams).rightMargin = u0.a(d2, i14);
                }
                int i15 = rect.bottom;
                if (i15 != -999) {
                    ((LinearLayout.LayoutParams) layoutParams).bottomMargin = u0.a(d2, i15);
                }
                if (i2 > 0) {
                    ((LinearLayout.LayoutParams) layoutParams).width = u0.a(d2, i2);
                }
                if (i3 > 0) {
                    ((LinearLayout.LayoutParams) layoutParams).height = u0.a(d2, i3);
                }
            }
        }
        return layoutParams;
    }

    public void c(String str, String str2) {
        try {
            LinkedHashMap<String, View> b2 = b(str, str2);
            if (b2 != null && !b2.isEmpty()) {
                for (View view : b2.values()) {
                    if (view instanceof MBridgeBTContainer) {
                        ((MBridgeBTContainer) view).addNativeCloseButtonWhenWebViewCrash();
                    }
                }
            }
        } catch (Throwable th) {
            p0.b("OperateViews", th.getMessage());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00c6, code lost:
    
        com.mbridge.msdk.foundation.tools.e1.a(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00c9, code lost:
    
        r0 = (com.mbridge.msdk.video.bt.module.MBTempContainer) r5;
        r3 = (com.mbridge.msdk.video.signal.impl.k) ((com.mbridge.msdk.mbsignalcommon.windvane.a) r14).b.getObject();
        r0.setAdEvents(r3.j());
        r0.setAdSession(r3.k());
        r0.setVideoEvents(r3.o());
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ed, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ee, code lost:
    
        com.mbridge.msdk.foundation.tools.p0.b("OperateViews", r0.getMessage());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Object obj, JSONObject jSONObject) {
        String optString;
        View view;
        JSONObject optJSONObject;
        int optInt;
        int optInt2;
        Rect rect;
        View next;
        WindVaneWebView windVaneWebView;
        try {
            String optString2 = jSONObject.optString("unitId");
            String optString3 = jSONObject.optString("id");
            String e2 = e(optString3);
            if (TextUtils.isEmpty(e2) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b) != null) {
                e2 = windVaneWebView.getRid();
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
            if (optJSONObject2 == null) {
                a(obj, "data is empty");
                return;
            }
            optString = optJSONObject2.optString("id");
            LinkedHashMap<String, View> b2 = b(optString2, e2);
            if (b2.containsKey(optString) && b2.containsKey(optString3)) {
                ViewGroup viewGroup = (ViewGroup) b2.get(optString3);
                view = b2.get(optString);
                e1.a(view);
                if (viewGroup != null && view != null) {
                    optJSONObject = optJSONObject2.optJSONObject("rect");
                    if (view instanceof MBTempContainer) {
                        p0.b("OperateViews", "OperateViews setNotchString = " + String.format("%1$s-%2$s-%3$s-%4$s-%5$s", Integer.valueOf(l), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(o), Integer.valueOf(p)));
                        ((MBTempContainer) view).setNotchPadding(l, m, n, o, p);
                        Iterator<View> it = b2.values().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            next = it.next();
                            if (next instanceof MBridgeBTContainer) {
                                break;
                            }
                        }
                    } else {
                        if (optJSONObject == null) {
                            if (view instanceof BTBaseView) {
                                rect = ((BTBaseView) view).getRect();
                                optInt = ((BTBaseView) view).getViewWidth();
                                optInt2 = ((BTBaseView) view).getViewHeight();
                            } else {
                                optInt = 0;
                                rect = null;
                                optInt2 = 0;
                            }
                        } else {
                            Rect rect2 = new Rect(optJSONObject.optInt("left", -999), optJSONObject.optInt("top", -999), optJSONObject.optInt("right", -999), optJSONObject.optInt("bottom", -999));
                            optInt = optJSONObject.optInt("width");
                            optInt2 = optJSONObject.optInt("height");
                            rect = rect2;
                        }
                        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                        if (viewGroup instanceof FrameLayout) {
                            layoutParams = new FrameLayout.LayoutParams(-1, -1);
                        } else if (viewGroup instanceof RelativeLayout) {
                            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                        } else if (viewGroup instanceof LinearLayout) {
                            layoutParams = new LinearLayout.LayoutParams(-1, -1);
                        }
                        ViewGroup.LayoutParams a2 = a(layoutParams, rect, optInt, optInt2);
                        e1.a(view);
                        viewGroup.addView(view, a2);
                    }
                    b(obj, optString3);
                    a(obj, "onAppendView", optString3);
                    p0.a("OperateViews", "appendSubView parentId = " + optString3 + " childId = " + optString);
                }
                a(obj, "view is not exist");
                return;
            }
            a(obj, "instanceId is not exist");
            p0.a("OperateViews", "appendSubView failed: instanceId is not exist");
            return;
            ((MBridgeBTContainer) next).appendSubView((MBridgeBTContainer) next, (MBTempContainer) view, optJSONObject);
            b(obj, optString3);
            a(obj, "onAppendView", optString3);
            p0.a("OperateViews", "appendSubView parentId = " + optString3 + " childId = " + optString);
        } catch (Throwable th) {
            a(obj, th.getMessage());
            p0.a("OperateViews", "appendSubView failed: " + th.getMessage());
        }
    }

    public void b(Object obj, JSONObject jSONObject, boolean z) {
        int optInt;
        int optInt2;
        Rect rect;
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e2 = e(optString2);
            if (TextUtils.isEmpty(e2) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b) != null) {
                e2 = windVaneWebView.getRid();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                a(obj, "data is empty");
                return;
            }
            String optString3 = optJSONObject.optString("targetComponentId");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
            LinkedHashMap<String, View> b2 = b(optString, e2);
            if (b2.containsKey(optString2) && b2.containsKey(optString3)) {
                View view = b2.get(optString2);
                View view2 = b2.get(optString3);
                if (view2 != null && view2.getParent() != null) {
                    ViewGroup viewGroup = (ViewGroup) view2.getParent();
                    int indexOfChild = viewGroup.indexOfChild(view2);
                    if (optJSONObject2 == null) {
                        if (view instanceof BTBaseView) {
                            rect = ((BTBaseView) view).getRect();
                            optInt = ((BTBaseView) view).getViewWidth();
                            optInt2 = ((BTBaseView) view).getViewHeight();
                        } else {
                            rect = null;
                            optInt = 0;
                            optInt2 = 0;
                        }
                    } else {
                        Rect rect2 = new Rect(optJSONObject2.optInt("left", -999), optJSONObject2.optInt("top", -999), optJSONObject2.optInt("right", -999), optJSONObject2.optInt("bottom", -999));
                        optInt = optJSONObject2.optInt("width");
                        optInt2 = optJSONObject2.optInt("height");
                        rect = rect2;
                    }
                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                    if (viewGroup instanceof FrameLayout) {
                        layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    } else if (viewGroup instanceof RelativeLayout) {
                        layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    } else if (viewGroup instanceof LinearLayout) {
                        layoutParams = new LinearLayout.LayoutParams(-1, -1);
                    }
                    ViewGroup.LayoutParams a2 = a(layoutParams, rect, optInt, optInt2);
                    if (z) {
                        e1.a(view);
                    }
                    int i2 = indexOfChild - 1;
                    viewGroup.addView(view, i2 > -1 ? i2 : 0, a2);
                    b(obj, optString2);
                    a(obj, "onInsertViewBelow", optString2);
                    p0.a("OperateViews", "insertViewBelow instanceId = " + optString2);
                    return;
                }
                a(obj, "view not exist");
                p0.a("OperateViews", "insertViewBelow failed: view not exist instanceId = " + optString2);
                return;
            }
            a(obj, "instanceId not exist");
            p0.a("OperateViews", "insertViewBelow failed: instanceId not exist instanceId = " + optString2);
        } catch (Throwable th) {
            a(obj, th.getMessage());
            p0.a("OperateViews", "insertViewBelow failed: " + th.getMessage());
        }
    }

    public void a(Object obj, JSONObject jSONObject, boolean z) {
        int optInt;
        int optInt2;
        Rect rect;
        WindVaneWebView windVaneWebView;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String e2 = e(optString2);
            if (TextUtils.isEmpty(e2) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b) != null) {
                e2 = windVaneWebView.getRid();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                a(obj, "data is empty");
                return;
            }
            String optString3 = optJSONObject.optString("targetComponentId");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
            LinkedHashMap<String, View> b2 = b(optString, e2);
            if (b2.containsKey(optString2) && b2.containsKey(optString3)) {
                View view = b2.get(optString2);
                View view2 = b2.get(optString3);
                if (view2 != null && view2.getParent() != null) {
                    ViewGroup viewGroup = (ViewGroup) view2.getParent();
                    int indexOfChild = viewGroup.indexOfChild(view2);
                    if (optJSONObject2 == null) {
                        if (view instanceof BTBaseView) {
                            rect = ((BTBaseView) view).getRect();
                            optInt = ((BTBaseView) view).getViewWidth();
                            optInt2 = ((BTBaseView) view).getViewHeight();
                        } else {
                            optInt = 0;
                            rect = null;
                            optInt2 = 0;
                        }
                    } else {
                        Rect rect2 = new Rect(optJSONObject2.optInt("left", -999), optJSONObject2.optInt("top", -999), optJSONObject2.optInt("right", -999), optJSONObject2.optInt("bottom", -999));
                        optInt = optJSONObject2.optInt("width");
                        optInt2 = optJSONObject2.optInt("height");
                        rect = rect2;
                    }
                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                    if (viewGroup instanceof FrameLayout) {
                        layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    } else if (viewGroup instanceof RelativeLayout) {
                        layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    } else if (viewGroup instanceof LinearLayout) {
                        layoutParams = new LinearLayout.LayoutParams(-1, -1);
                    }
                    ViewGroup.LayoutParams a2 = a(layoutParams, rect, optInt, optInt2);
                    if (z) {
                        e1.a(view);
                    }
                    viewGroup.addView(view, indexOfChild + 1, a2);
                    b(obj, optString2);
                    a(obj, "onInsertViewAbove", optString2);
                    p0.a("OperateViews", "insertViewAbove instanceId = " + optString2 + " brotherId = " + optString3);
                    return;
                }
                a(obj, "view not exist");
                p0.a("OperateViews", "insertViewAbove failed: view not exist instanceId = " + optString2);
                return;
            }
            a(obj, "instanceId not exist");
            p0.a("OperateViews", "insertViewAbove failed: instanceId not exist instanceId = " + optString2);
        } catch (Throwable th) {
            a(obj, th.getMessage());
            p0.a("OperateViews", "insertViewAbove failed: " + th.getMessage());
        }
    }

    private MBridgeBTContainer a(String str, String str2) {
        LinkedHashMap<String, View> b2 = b(str, str2);
        if (b2.size() <= 0) {
            return null;
        }
        for (View view : b2.values()) {
            if (view instanceof MBridgeBTContainer) {
                return (MBridgeBTContainer) view;
            }
        }
        return null;
    }

    private void a(CampaignEx campaignEx) {
        new Thread(new c(campaignEx)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, CampaignEx campaignEx) {
        if (com.mbridge.msdk.foundation.same.buffer.b.k == null || TextUtils.isEmpty(campaignEx.getId())) {
            return;
        }
        com.mbridge.msdk.foundation.same.buffer.b.a(str, campaignEx, C3288s.j);
    }

    public void a(int i2, int i3, int i4, int i5, int i6) {
        p0.a("OperateViews", "OperateViews setNotchString = " + String.format("%1$s-%2$s-%3$s-%4$s-%5$s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)));
        k = c0.a(i2, i3, i4, i5, i6);
        l = i2;
        m = i3;
        n = i4;
        o = i5;
        p = i6;
    }
}
