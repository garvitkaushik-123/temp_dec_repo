package com.mbridge.msdk.video.bt.module;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.tools.h0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.mbsignalcommon.windvane.f;
import com.mbridge.msdk.video.bt.component.d;
import com.mbridge.msdk.videocommon.setting.c;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public abstract class BTBaseView extends FrameLayout {
    public static final String TAG = "BTBaseView";
    protected static int n = 0;
    protected static int o = 1;

    /* renamed from: a, reason: collision with root package name */
    protected Context f4991a;
    protected CampaignEx b;
    protected String c;
    protected String d;
    protected c e;
    protected LayoutInflater f;
    protected int g;
    protected boolean h;
    protected float i;
    protected float j;
    protected Rect k;
    protected int l;
    protected int m;

    public BTBaseView(Context context) {
        this(context, null);
    }

    protected JSONObject a(int i) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e) {
            e = e;
        }
        try {
            jSONObject.put(a.h, u0.b(com.mbridge.msdk.foundation.controller.c.m().d(), this.i));
            jSONObject.put(a.i, u0.b(com.mbridge.msdk.foundation.controller.c.m().d(), this.j));
            jSONObject.put(a.m, i);
            try {
                this.g = getContext().getResources().getConfiguration().orientation;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            jSONObject.put(a.k, this.g);
            jSONObject.put(a.l, u0.d(getContext()));
            return jSONObject;
        } catch (JSONException e3) {
            e = e3;
            jSONObject2 = jSONObject;
            e.printStackTrace();
            return jSONObject2;
        }
    }

    protected void b() {
    }

    public void defaultShow() {
        p0.a(TAG, "defaultShow");
    }

    public int findColor(String str) {
        return h0.a(this.f4991a.getApplicationContext(), str, "color");
    }

    public int findDrawable(String str) {
        return h0.a(this.f4991a.getApplicationContext(), str, "drawable");
    }

    public int findID(String str) {
        return h0.a(this.f4991a.getApplicationContext(), str, "id");
    }

    public int findLayout(String str) {
        return h0.a(this.f4991a.getApplicationContext(), str, "layout");
    }

    public CampaignEx getCampaign() {
        return this.b;
    }

    public String getInstanceId() {
        return this.d;
    }

    public FrameLayout.LayoutParams getParentFrameLayoutParams() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            return (FrameLayout.LayoutParams) layoutParams;
        }
        return null;
    }

    public LinearLayout.LayoutParams getParentLinearLayoutParams() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return (LinearLayout.LayoutParams) layoutParams;
        }
        return null;
    }

    public RelativeLayout.LayoutParams getParentRelativeLayoutParams() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            return (RelativeLayout.LayoutParams) layoutParams;
        }
        return null;
    }

    public Rect getRect() {
        return this.k;
    }

    public String getUnitId() {
        return this.c;
    }

    public int getViewHeight() {
        return this.m;
    }

    public int getViewWidth() {
        return this.l;
    }

    public abstract void init(Context context);

    public boolean isLandscape() {
        return this.f4991a.getResources().getConfiguration().orientation == 2;
    }

    public boolean isNotNULL(View... viewArr) {
        if (viewArr == null) {
            return false;
        }
        int length = viewArr.length;
        int i = 0;
        boolean z = false;
        while (i < length) {
            if (viewArr[i] == null) {
                return false;
            }
            i++;
            z = true;
        }
        return z;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        this.g = configuration.orientation;
        super.onConfigurationChanged(configuration);
    }

    public abstract void onDestory();

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.i = motionEvent.getRawX();
        this.j = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onSelfConfigurationChanged(Configuration configuration) {
        this.g = configuration.orientation;
    }

    public void setCampaign(CampaignEx campaignEx) {
        this.b = campaignEx;
    }

    public void setInstanceId(String str) {
        this.d = str;
    }

    public void setLayout(int i, int i2) {
        this.l = i;
        this.m = i2;
    }

    public void setLayoutCenter(int i, int i2) {
        FrameLayout.LayoutParams parentFrameLayoutParams = getParentFrameLayoutParams();
        RelativeLayout.LayoutParams parentRelativeLayoutParams = getParentRelativeLayoutParams();
        LinearLayout.LayoutParams parentLinearLayoutParams = getParentLinearLayoutParams();
        if (parentRelativeLayoutParams != null) {
            parentRelativeLayoutParams.addRule(13);
            if (i != -999) {
                parentRelativeLayoutParams.width = i;
            }
            if (i2 != -999) {
                parentRelativeLayoutParams.height = i2;
            }
            setLayoutParams(parentRelativeLayoutParams);
            return;
        }
        if (parentLinearLayoutParams != null) {
            parentLinearLayoutParams.gravity = 17;
            if (i != -999) {
                parentLinearLayoutParams.width = i;
            }
            if (i2 != -999) {
                parentLinearLayoutParams.height = i2;
            }
            setLayoutParams(parentLinearLayoutParams);
            return;
        }
        if (parentFrameLayoutParams != null) {
            parentFrameLayoutParams.gravity = 17;
            if (i != -999) {
                parentFrameLayoutParams.width = i;
            }
            if (i2 != -999) {
                parentFrameLayoutParams.height = i2;
            }
            setLayoutParams(parentFrameLayoutParams);
        }
    }

    public void setLayoutParam(int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams parentFrameLayoutParams = getParentFrameLayoutParams();
        RelativeLayout.LayoutParams parentRelativeLayoutParams = getParentRelativeLayoutParams();
        LinearLayout.LayoutParams parentLinearLayoutParams = getParentLinearLayoutParams();
        if (parentRelativeLayoutParams != null) {
            parentRelativeLayoutParams.topMargin = i2;
            parentRelativeLayoutParams.leftMargin = i;
            if (i3 != -999) {
                parentRelativeLayoutParams.width = i3;
            }
            if (i4 != -999) {
                parentRelativeLayoutParams.height = i4;
            }
            setLayoutParams(parentRelativeLayoutParams);
            return;
        }
        if (parentLinearLayoutParams != null) {
            parentLinearLayoutParams.topMargin = i2;
            parentLinearLayoutParams.leftMargin = i;
            if (i3 != -999) {
                parentLinearLayoutParams.width = i3;
            }
            if (i4 != -999) {
                parentLinearLayoutParams.height = i4;
            }
            setLayoutParams(parentLinearLayoutParams);
            return;
        }
        if (parentFrameLayoutParams != null) {
            parentFrameLayoutParams.topMargin = i2;
            parentFrameLayoutParams.leftMargin = i;
            if (i3 != -999) {
                parentFrameLayoutParams.width = i3;
            }
            if (i4 != -999) {
                parentFrameLayoutParams.height = i4;
            }
            setLayoutParams(parentFrameLayoutParams);
        }
    }

    public void setMatchParent() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        } else {
            layoutParams.height = -1;
            layoutParams.width = -1;
        }
    }

    public void setRect(Rect rect) {
        this.k = rect;
    }

    public void setRewardUnitSetting(c cVar) {
        this.e = cVar;
    }

    public void setUnitId(String str) {
        this.c = str;
    }

    public void setWrapContent() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        } else {
            layoutParams.height = -2;
            layoutParams.width = -2;
        }
    }

    public BTBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = "";
        this.g = 1;
        this.h = false;
        this.f4991a = context;
        this.f = LayoutInflater.from(context);
        init(context);
    }

    protected static void a(WebView webView, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", n);
            jSONObject.put("id", str2);
            jSONObject.put("data", new JSONObject());
            f.a().a(webView, str, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e) {
            d.c().a(webView, e.getMessage());
            p0.a(TAG, e.getMessage());
        }
    }
}
