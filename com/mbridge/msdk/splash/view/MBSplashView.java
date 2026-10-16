package com.mbridge.msdk.splash.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.AdError;
import com.ironsource.C3040d4;
import com.mbridge.msdk.dycreator.listener.DyCountDownListener;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.c0;
import com.mbridge.msdk.foundation.tools.e1;
import com.mbridge.msdk.foundation.tools.g;
import com.mbridge.msdk.foundation.tools.l0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.mbsignalcommon.windvane.f;
import io.bidmachine.rendering.model.EventTaskParams;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class MBSplashView extends RelativeLayout {
    private static String u = "MBSplashView";

    /* renamed from: a, reason: collision with root package name */
    private int f4791a;
    private MBSplashWebview b;
    private com.mbridge.msdk.splash.view.a c;
    private ViewGroup d;
    private View e;
    private View f;
    private int g;
    private boolean h;
    private boolean i;
    private boolean j;
    private ViewGroup k;
    private View l;
    private boolean m;
    private boolean n;
    private RelativeLayout.LayoutParams o;
    private com.mbridge.msdk.splash.signal.b p;
    private DyCountDownListener q;
    private boolean r;
    private View.OnTouchListener s;
    private boolean t;

    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return !MBSplashView.this.r;
        }
    }

    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f4793a;

        b(CampaignEx campaignEx) {
            this.f4793a = campaignEx;
        }

        @Override // java.lang.Runnable
        public void run() {
            MBSplashView.this.b(this.f4793a);
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                p0.a(MBSplashView.u, "webviewshow");
                String str = "";
                try {
                    int[] iArr = new int[2];
                    MBSplashView.this.b.getLocationOnScreen(iArr);
                    p0.b(MBSplashView.u, "coordinate:" + iArr[0] + "--" + iArr[1]);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("startX", u0.b(com.mbridge.msdk.foundation.controller.c.m().d(), iArr[0]));
                    jSONObject.put("startY", u0.b(com.mbridge.msdk.foundation.controller.c.m().d(), iArr[1]));
                    str = jSONObject.toString();
                } catch (Throwable th) {
                    p0.b(MBSplashView.u, th.getMessage(), th);
                }
                int[] iArr2 = new int[2];
                MBSplashView.this.b.getLocationInWindow(iArr2);
                MBSplashView.transInfoForMraid(MBSplashView.this.b, iArr2[0], iArr2[1], MBSplashView.this.b.getWidth(), MBSplashView.this.b.getHeight());
                f.a().a((WebView) MBSplashView.this.b, "webviewshow", Base64.encodeToString(str.toString().getBytes(), 2));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public MBSplashView(Context context) {
        this(context, null);
    }

    public static void transInfoForMraid(WebView webView, int i, int i2, int i3, int i4) {
        p0.b(u, "transInfoForMraid");
        try {
            int i5 = com.mbridge.msdk.foundation.controller.c.m().d().getResources().getConfiguration().orientation;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("orientation", i5 == 2 ? C3040d4.h.C : i5 == 1 ? C3040d4.h.D : AdError.UNDEFINED_DOMAIN);
            jSONObject.put("locked", "true");
            float n = l0.n(com.mbridge.msdk.foundation.controller.c.m().d());
            float m = l0.m(com.mbridge.msdk.foundation.controller.c.m().d());
            HashMap v = l0.v(com.mbridge.msdk.foundation.controller.c.m().d());
            int intValue = ((Integer) v.get("width")).intValue();
            int intValue2 = ((Integer) v.get("height")).intValue();
            HashMap hashMap = new HashMap();
            hashMap.put("placementType", "Interstitial");
            hashMap.put("state", EventTaskParams.STATE_GROUP_DEFAULT);
            hashMap.put("viewable", "true");
            hashMap.put("currentAppOrientation", jSONObject);
            float f = i;
            float f2 = i2;
            float f3 = i3;
            float f4 = i4;
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(webView, f, f2, f3, f4);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(webView, f, f2, f3, f4);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(webView, n, m);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(webView, intValue, intValue2);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(webView, hashMap);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(webView);
        } catch (Throwable th) {
            p0.b(u, "transInfoForMraid", th);
        }
    }

    public void changeCloseBtnState(int i) {
        View view = this.e;
        if (view != null) {
            if (i == 2) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
        }
    }

    public void clearResState() {
        this.j = false;
        this.i = false;
        this.h = false;
    }

    public void destroy() {
        removeAllViews();
        ViewGroup viewGroup = this.k;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        MBSplashWebview mBSplashWebview = this.b;
        if (mBSplashWebview == null || mBSplashWebview.isDestoryed()) {
            return;
        }
        this.b.finishAdSession();
        com.mbridge.msdk.splash.signal.c.a(this.b, "onSystemDestory", "");
        this.b.release();
        this.b = null;
    }

    public View.OnTouchListener getAllowClickSplashTouchListener() {
        return this.s;
    }

    public View getCloseView() {
        return this.e;
    }

    public ViewGroup getDevContainer() {
        return this.k;
    }

    public View getIconVg() {
        return this.f;
    }

    public View getSplashNativeView() {
        return this.l;
    }

    public com.mbridge.msdk.splash.signal.b getSplashSignalCommunicationImpl() {
        return this.p;
    }

    public MBSplashWebview getSplashWebview() {
        return this.b;
    }

    public boolean isAttach() {
        return this.n;
    }

    public boolean isDynamicView() {
        return this.m;
    }

    public boolean isH5Ready() {
        return this.h;
    }

    public boolean isImageReady() {
        return this.j;
    }

    public boolean isVideoReady() {
        return this.i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.n = true;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        b();
    }

    public void onPause() {
        View view = this.l;
        if (view == null || !(view instanceof MBSplashNativeView)) {
            return;
        }
        ((MBSplashNativeView) view).setIsPause(true);
    }

    public void onResume() {
        View view = this.l;
        if (view == null || !(view instanceof MBSplashNativeView)) {
            return;
        }
        ((MBSplashNativeView) view).setIsPause(false);
    }

    public void resetLoadState() {
        this.i = false;
        this.h = false;
    }

    public void setAllowClickSplash(boolean z) {
        this.r = z;
        setOnTouchListener(this.s);
    }

    public void setCloseView(View view) {
        this.e = view;
        if (view != null) {
            view.setContentDescription("closeButton");
        }
    }

    public void setDevContainer(ViewGroup viewGroup) {
        this.k = viewGroup;
    }

    public void setDyCountDownListener(DyCountDownListener dyCountDownListener) {
        this.q = dyCountDownListener;
    }

    public void setDynamicView(boolean z) {
        this.m = z;
    }

    public void setH5Ready(boolean z) {
        this.h = z;
    }

    public void setIconVg(View view, RelativeLayout.LayoutParams layoutParams) {
        this.f = view;
        this.o = layoutParams;
    }

    public void setImageReady(boolean z) {
        this.j = z;
    }

    public void setNotchPadding(int i, int i2, int i3, int i4) {
        View view = this.l;
        if (view != null && (view instanceof MBSplashNativeView)) {
            ((MBSplashNativeView) view).setNotchPadding(i, i2, i3, i4);
        }
        if (this.b != null) {
            f.a().a((WebView) this.b, "oncutoutfetched", Base64.encodeToString(c0.a(-999, i, i2, i3, i4).getBytes(), 0));
        }
    }

    public void setSplashNativeView(View view) {
        if (view != null) {
            this.l = view;
        }
    }

    public void setSplashSignalCommunicationImpl(com.mbridge.msdk.splash.signal.b bVar) {
        this.p = bVar;
        MBSplashWebview mBSplashWebview = this.b;
        if (mBSplashWebview != null) {
            mBSplashWebview.setObject(bVar);
        }
    }

    public void setSplashWebView() {
        if (this.b == null) {
            try {
                MBSplashWebview mBSplashWebview = new MBSplashWebview(getContext());
                this.b = mBSplashWebview;
                com.mbridge.msdk.splash.signal.b bVar = this.p;
                if (bVar != null) {
                    mBSplashWebview.setObject(bVar);
                }
                com.mbridge.msdk.splash.view.a aVar = this.c;
                if (aVar != null) {
                    this.b.setWebViewClient(aVar);
                    return;
                }
                com.mbridge.msdk.splash.view.a aVar2 = new com.mbridge.msdk.splash.view.a();
                this.c = aVar2;
                this.b.setWebViewClient(aVar2);
            } catch (Throwable th) {
                p0.b(u, th.getMessage());
            }
        }
    }

    public void setVideoReady(boolean z) {
        this.i = z;
    }

    public void show(CampaignEx campaignEx) {
        ViewGroup viewGroup;
        if (this.p != null && (viewGroup = this.k) != null && (viewGroup.getContext() instanceof Activity)) {
            this.p.a(this.k.getContext());
            com.mbridge.msdk.splash.view.a aVar = this.c;
            if (aVar != null) {
                aVar.a(this.p.a());
            }
        }
        a(campaignEx);
        clearResState();
    }

    public void updateCountdown(int i) {
        DyCountDownListener dyCountDownListener;
        View view;
        if (this.b != null && !this.m) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("countdown", i);
                f.a().a((WebView) this.b, "updateCountdown", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (this.m && (view = this.l) != null && (view instanceof MBSplashNativeView)) {
            ((MBSplashNativeView) view).updateCountDown(i);
        }
        if (!this.m || (dyCountDownListener = this.q) == null) {
            return;
        }
        dyCountDownListener.getCountDownValue(i);
    }

    public MBSplashView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void b() {
        setBackgroundColor(0);
        this.f4791a = getResources().getConfiguration().orientation;
    }

    public MBSplashView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.r = true;
        this.s = new a();
        this.t = true;
        b();
    }

    private void a(CampaignEx campaignEx) {
        View view;
        View view2;
        View view3;
        this.t = true;
        if (this.f == null) {
            if (this.m && (view3 = this.l) != null) {
                if (view3.getParent() != null) {
                    e1.a(this.l);
                }
                addView(this.l, new ViewGroup.LayoutParams(-1, -1));
            } else {
                MBSplashWebview mBSplashWebview = this.b;
                if (mBSplashWebview != null && mBSplashWebview.getParent() == null) {
                    addView(this.b, new ViewGroup.LayoutParams(-1, -1));
                }
                b(campaignEx);
            }
        } else {
            if (this.d == null) {
                RelativeLayout relativeLayout = new RelativeLayout(getContext());
                this.d = relativeLayout;
                relativeLayout.setId(2147482647);
            }
            if (this.f4791a == 2) {
                this.g = u0.g(getContext());
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(0, this.d.getId());
                if (this.m && (view2 = this.l) != null) {
                    if (view2.getParent() != null) {
                        e1.a(this.l);
                    }
                    addView(this.l, layoutParams);
                } else {
                    MBSplashWebview mBSplashWebview2 = this.b;
                    if (mBSplashWebview2 != null && mBSplashWebview2.getParent() == null) {
                        addView(this.b, layoutParams);
                    }
                    b(campaignEx);
                }
                ViewGroup viewGroup = this.d;
                if (viewGroup != null && viewGroup.getParent() == null) {
                    int i = this.o.width;
                    e1.a(this.f);
                    int i2 = this.g / 4;
                    if (i > i2) {
                        this.d.addView(this.f, i2, -1);
                        i = i2;
                    } else {
                        this.d.addView(this.f, i, -1);
                    }
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i, -1);
                    layoutParams2.addRule(11);
                    layoutParams2.addRule(13);
                    addView(this.d, layoutParams2);
                }
            } else {
                this.g = u0.f(getContext());
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams3.addRule(2, this.d.getId());
                if (this.m && (view = this.l) != null) {
                    if (view.getParent() != null) {
                        e1.a(this.l);
                    }
                    addView(this.l, layoutParams3);
                } else {
                    MBSplashWebview mBSplashWebview3 = this.b;
                    if (mBSplashWebview3 != null && mBSplashWebview3.getParent() == null) {
                        addView(this.b, layoutParams3);
                    }
                    b(campaignEx);
                }
                ViewGroup viewGroup2 = this.d;
                if (viewGroup2 != null && viewGroup2.getParent() == null) {
                    int i3 = this.o.height;
                    int i4 = this.g / 4;
                    if (i3 > i4) {
                        i3 = i4;
                    }
                    e1.a(this.f);
                    this.d.addView(this.f, -1, i3);
                    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, i3);
                    layoutParams4.addRule(12);
                    addView(this.d, layoutParams4);
                }
            }
        }
        View view4 = this.e;
        if (view4 != null) {
            if (view4.getParent() == null) {
                RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(u0.a(getContext(), 100.0f), u0.a(getContext(), 30.0f));
                layoutParams5.addRule(10);
                layoutParams5.addRule(11);
                layoutParams5.rightMargin = u0.a(getContext(), 10.0f);
                layoutParams5.topMargin = u0.a(getContext(), 10.0f);
                addView(this.e, layoutParams5);
                return;
            }
            bringChildToFront(this.e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CampaignEx campaignEx) {
        View view = this.b;
        if (view != null) {
            if (view == null) {
                view = this.l;
            }
            if (!(campaignEx != null ? g.b(campaignEx, null, view, campaignEx.getImpReportType()) : true)) {
                if (this.t) {
                    this.t = false;
                    this.b.postDelayed(new b(campaignEx), 200L);
                    return;
                }
                return;
            }
            this.b.setObject(this.p);
            this.b.post(new c());
        }
    }
}
