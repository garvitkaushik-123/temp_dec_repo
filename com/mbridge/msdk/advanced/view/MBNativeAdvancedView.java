package com.mbridge.msdk.advanced.view;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.AdError;
import com.ironsource.C3040d4;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.l0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.mbsignalcommon.windvane.f;
import com.mbridge.msdk.widget.MBAdChoice;
import io.bidmachine.rendering.model.EventTaskParams;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class MBNativeAdvancedView extends RelativeLayout {
    private static String i = "MBAdvancedNativeView";

    /* renamed from: a, reason: collision with root package name */
    private MBNativeAdvancedWebview f4026a;
    private View b;
    private boolean c;
    private boolean d;
    private boolean e;
    MBAdChoice f;
    private com.mbridge.msdk.advanced.signal.b g;
    private Context h;

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                p0.a(MBNativeAdvancedView.i, "webviewshow");
                String str = "";
                try {
                    int[] iArr = new int[2];
                    MBNativeAdvancedView.this.f4026a.getLocationOnScreen(iArr);
                    p0.b(MBNativeAdvancedView.i, "coordinate:" + iArr[0] + "--" + iArr[1]);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("startX", u0.b(c.m().d(), iArr[0]));
                    jSONObject.put("startY", u0.b(c.m().d(), iArr[1]));
                    str = jSONObject.toString();
                } catch (Throwable th) {
                    p0.b(MBNativeAdvancedView.i, th.getMessage(), th);
                }
                f.a().a((WebView) MBNativeAdvancedView.this.f4026a, "webviewshow", Base64.encodeToString(str.toString().getBytes(), 2));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public MBNativeAdvancedView(Context context) {
        this(context, null);
    }

    private void b() {
        MBNativeAdvancedWebview mBNativeAdvancedWebview = this.f4026a;
        if (mBNativeAdvancedWebview != null && mBNativeAdvancedWebview.getParent() == null) {
            addView(this.f4026a, new ViewGroup.LayoutParams(-1, -1));
        }
        c();
        View view = this.b;
        if (view != null) {
            if (view.getParent() == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(u0.a(getContext(), 28.0f), u0.a(getContext(), 16.0f));
                layoutParams.addRule(10);
                layoutParams.addRule(11);
                layoutParams.rightMargin = u0.a(getContext(), 2.0f);
                layoutParams.topMargin = u0.a(getContext(), 2.0f);
                addView(this.b, layoutParams);
            } else {
                bringChildToFront(this.b);
            }
        }
        if (this.f == null) {
            MBAdChoice mBAdChoice = new MBAdChoice(getContext());
            this.f = mBAdChoice;
            mBAdChoice.setFeedbackDialogEventListener(new a());
        }
    }

    private void c() {
        int[] iArr = new int[2];
        this.f4026a.getLocationInWindow(iArr);
        MBNativeAdvancedWebview mBNativeAdvancedWebview = this.f4026a;
        transInfoForMraid(mBNativeAdvancedWebview, iArr[0], iArr[1], mBNativeAdvancedWebview.getWidth(), this.f4026a.getHeight());
        MBNativeAdvancedWebview mBNativeAdvancedWebview2 = this.f4026a;
        if (mBNativeAdvancedWebview2 != null) {
            mBNativeAdvancedWebview2.setObject(this.g);
            this.f4026a.post(new b());
        }
    }

    public static void transInfoForMraid(WebView webView, int i2, int i3, int i4, int i5) {
        p0.b(i, "transInfoForMraid");
        try {
            int i6 = c.m().d().getResources().getConfiguration().orientation;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("orientation", i6 == 2 ? C3040d4.h.C : i6 == 1 ? C3040d4.h.D : AdError.UNDEFINED_DOMAIN);
            jSONObject.put("locked", "true");
            float n = l0.n(c.m().d());
            float m = l0.m(c.m().d());
            HashMap v = l0.v(c.m().d());
            int intValue = ((Integer) v.get("width")).intValue();
            int intValue2 = ((Integer) v.get("height")).intValue();
            HashMap hashMap = new HashMap();
            hashMap.put("placementType", "inline");
            hashMap.put("state", EventTaskParams.STATE_GROUP_DEFAULT);
            hashMap.put("viewable", "true");
            hashMap.put("currentAppOrientation", jSONObject);
            float f = i2;
            float f2 = i3;
            float f3 = i4;
            float f4 = i5;
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(webView, f, f2, f3, f4);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(webView, f, f2, f3, f4);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(webView, n, m);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(webView, intValue, intValue2);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(webView, hashMap);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(webView);
        } catch (Throwable th) {
            p0.b(i, "transInfoForMraid", th);
        }
    }

    public void changeCloseBtnState(int i2) {
        View view = this.b;
        if (view != null) {
            if (i2 == 2) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
        }
    }

    public void clearResState() {
        this.e = false;
        this.d = false;
        this.c = false;
    }

    public void clearResStateAndRemoveClose() {
        clearResState();
        View view = this.b;
        if (view != null && view.getParent() != null) {
            removeView(this.b);
        }
        MBAdChoice mBAdChoice = this.f;
        if (mBAdChoice == null || mBAdChoice.getParent() == null) {
            return;
        }
        removeView(this.f);
    }

    public void destroy() {
        removeAllViews();
        MBNativeAdvancedWebview mBNativeAdvancedWebview = this.f4026a;
        if (mBNativeAdvancedWebview != null && !mBNativeAdvancedWebview.isDestoryed()) {
            this.f4026a.release();
            com.mbridge.msdk.advanced.signal.a.a(this.f4026a, "onSystemDestory", "");
        }
        if (this.h != null) {
            this.h = null;
        }
    }

    public com.mbridge.msdk.advanced.signal.b getAdvancedNativeSignalCommunicationImpl() {
        return this.g;
    }

    public MBNativeAdvancedWebview getAdvancedNativeWebview() {
        return this.f4026a;
    }

    public View getCloseView() {
        return this.b;
    }

    public boolean isEndCardReady() {
        return this.e;
    }

    public boolean isH5Ready() {
        return this.c;
    }

    public boolean isVideoReady() {
        return this.d;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void resetLoadState() {
        this.e = false;
        this.d = false;
        this.c = false;
    }

    public void setAdChoiceCampaign(CampaignEx campaignEx) {
        MBAdChoice mBAdChoice = this.f;
        if (mBAdChoice != null) {
            mBAdChoice.setCampaign(campaignEx);
            if (this.f.getParent() != null) {
                bringChildToFront(this.f);
                return;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(u0.a(c.m().d(), 6.0f), u0.a(c.m().d(), 6.0f));
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            addView(this.f, layoutParams);
        }
    }

    public void setAdvancedNativeSignalCommunicationImpl(com.mbridge.msdk.advanced.signal.b bVar) {
        this.g = bVar;
        MBNativeAdvancedWebview mBNativeAdvancedWebview = this.f4026a;
        if (mBNativeAdvancedWebview != null) {
            mBNativeAdvancedWebview.setObject(bVar);
        }
    }

    public void setAdvancedNativeWebview(MBNativeAdvancedWebview mBNativeAdvancedWebview) {
        this.f4026a = mBNativeAdvancedWebview;
        com.mbridge.msdk.advanced.signal.b bVar = this.g;
        if (bVar != null) {
            mBNativeAdvancedWebview.setObject(bVar);
        }
    }

    public void setCloseView(View view) {
        this.b = view;
        if (view != null) {
            view.setContentDescription("closeButton");
        }
    }

    public void setEndCardReady(boolean z) {
        this.e = z;
    }

    public void setH5Ready(boolean z) {
        this.c = z;
    }

    public void setVideoReady(boolean z) {
        this.d = z;
    }

    public void show() {
        b();
        clearResState();
    }

    class a implements com.mbridge.msdk.foundation.feedback.a {
        a() {
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a() {
            String str;
            try {
                JSONObject jSONObject = new JSONObject();
                if (c.m().d() != null) {
                    jSONObject.put("status", 1);
                }
                str = jSONObject.toString();
            } catch (Throwable th) {
                p0.b(MBNativeAdvancedView.i, th.getMessage(), th);
                str = "";
            }
            f.a().a((WebView) MBNativeAdvancedView.this.getAdvancedNativeWebview(), "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void close() {
            String str;
            try {
                JSONObject jSONObject = new JSONObject();
                if (c.m().d() != null) {
                    jSONObject.put("status", 2);
                }
                str = jSONObject.toString();
            } catch (Throwable th) {
                p0.b(MBNativeAdvancedView.i, th.getMessage(), th);
                str = "";
            }
            f.a().a((WebView) MBNativeAdvancedView.this.getAdvancedNativeWebview(), "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a(String str) {
            String str2;
            try {
                JSONObject jSONObject = new JSONObject();
                if (c.m().d() != null) {
                    jSONObject.put("status", 1);
                }
                str2 = jSONObject.toString();
            } catch (Throwable th) {
                p0.b(MBNativeAdvancedView.i, th.getMessage(), th);
                str2 = "";
            }
            f.a().a((WebView) MBNativeAdvancedView.this.getAdvancedNativeWebview(), "onFeedbackAlertStatusNotify", Base64.encodeToString(str2.getBytes(), 2));
        }
    }

    public MBNativeAdvancedView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MBNativeAdvancedView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.h = context;
    }
}
