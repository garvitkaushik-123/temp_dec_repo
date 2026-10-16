package com.mbridge.msdk.out;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.error.b;
import com.mbridge.msdk.foundation.same.report.metrics.c;
import com.mbridge.msdk.foundation.same.report.metrics.e;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.mbbanner.controll.a;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class MBBannerView extends RelativeLayout implements BaseExtraInterfaceForHandler {
    private String bidToken;
    private a controller;
    private boolean hadAttached;
    private boolean isVisible;
    private BannerAdListener mBannerAdListener;
    private MBridgeIds mBridgeIds;
    private String unitId;

    public MBBannerView(Context context) {
        this(context, null);
    }

    private void callbackAndReportFail(c cVar, b bVar) {
        String str = "";
        if (bVar != null) {
            try {
                str = bVar.g();
            } catch (Throwable th) {
                p0.b("BannerView", th.getMessage());
            }
        }
        cVar.a(bVar);
        cVar.b(true);
        com.mbridge.msdk.mbbanner.common.report.a.a("2000047", cVar, (e) null);
        BannerAdListener bannerAdListener = this.mBannerAdListener;
        if (bannerAdListener != null) {
            bannerAdListener.onLoadFailed(this.mBridgeIds, str);
        }
    }

    private void delayedNotify() {
        postDelayed(new Runnable() { // from class: com.mbridge.msdk.out.MBBannerView.1
            @Override // java.lang.Runnable
            public void run() {
                if (MBBannerView.this.controller == null || com.mbridge.msdk.foundation.feedback.b.f) {
                    return;
                }
                MBBannerView.this.controller.c(true);
            }
        }, 200L);
    }

    private void updateAttachedState(boolean z) {
        this.hadAttached = z;
        a aVar = this.controller;
        if (aVar != null) {
            aVar.b(z);
        }
    }

    public String getCreativeIdWithUnitId() {
        a aVar = this.controller;
        return aVar != null ? aVar.d() : "";
    }

    public String getRequestId() {
        a aVar = this.controller;
        return aVar != null ? aVar.e() : "";
    }

    public void init(BannerSize bannerSize, String str, String str2) {
        this.unitId = str2;
        this.mBridgeIds = new MBridgeIds(TextUtils.isEmpty(str) ? "" : str, str2);
        String e = u0.e(str2);
        if (!TextUtils.isEmpty(e)) {
            u0.b(str2, e);
        }
        a aVar = new a(this, bannerSize, str, str2);
        this.controller = aVar;
        aVar.c(this.isVisible);
        this.controller.b(this.hadAttached);
    }

    public void load() {
        String b = com.mbridge.msdk.mbbanner.common.report.a.b(this.bidToken);
        c a2 = com.mbridge.msdk.mbbanner.common.report.a.a(this.unitId, b);
        a2.h("0");
        a aVar = this.controller;
        if (aVar != null) {
            aVar.b(this.hadAttached);
            this.controller.a("", b);
        } else {
            b bVar = new b(880042);
            bVar.b(b);
            callbackAndReportFail(a2, bVar);
        }
    }

    public void loadFromBid(String str) {
        this.bidToken = str;
        String b = com.mbridge.msdk.mbbanner.common.report.a.b(str);
        c a2 = com.mbridge.msdk.mbbanner.common.report.a.a(this.unitId, b);
        a2.h("1");
        if (this.controller == null) {
            b bVar = new b(880042);
            bVar.b(b);
            callbackAndReportFail(a2, bVar);
        } else if (TextUtils.isEmpty(str)) {
            b bVar2 = new b(880035);
            bVar2.b(b);
            callbackAndReportFail(a2, bVar2);
        } else {
            this.controller.b(this.hadAttached);
            this.controller.b(0);
            this.controller.a(str, b);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateAttachedState(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        updateAttachedState(false);
    }

    public void onPause() {
        if (this.controller == null || !TextUtils.isEmpty(this.bidToken)) {
            return;
        }
        this.controller.g();
    }

    public void onResume() {
        if (this.controller == null || !TextUtils.isEmpty(this.bidToken) || com.mbridge.msdk.foundation.feedback.b.f) {
            return;
        }
        this.controller.h();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        this.isVisible = i == 0;
        a aVar = this.controller;
        if (aVar != null) {
            if (i == 0) {
                delayedNotify();
            } else {
                aVar.c(false);
            }
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.isVisible = i == 0;
        if (this.controller != null) {
            if (i == 0) {
                delayedNotify();
            } else {
                if (com.mbridge.msdk.foundation.feedback.b.f) {
                    return;
                }
                this.controller.c(false);
            }
        }
    }

    public void release() {
        if (this.mBannerAdListener != null) {
            this.mBannerAdListener = null;
        }
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a((BannerAdListener) null);
            this.controller.i();
        }
        removeAllViews();
    }

    public void setAllowShowCloseBtn(boolean z) {
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a(z);
        }
    }

    public void setBannerAdListener(BannerAdListener bannerAdListener) {
        this.mBannerAdListener = bannerAdListener;
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a(bannerAdListener);
        }
    }

    @Override // com.mbridge.msdk.out.BaseExtraInterfaceForHandler
    public void setExtraInfo(JSONObject jSONObject) {
        com.mbridge.msdk.foundation.controller.c.m().a(this.unitId, jSONObject);
    }

    public void setRefreshTime(int i) {
        a aVar = this.controller;
        if (aVar == null || i < 0) {
            return;
        }
        aVar.b(i);
    }

    public void updateBannerSize(BannerSize bannerSize) {
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a(bannerSize);
        }
    }

    public MBBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MBBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hadAttached = false;
        this.isVisible = false;
        com.mbridge.msdk.foundation.controller.c.m().a(context);
    }
}
