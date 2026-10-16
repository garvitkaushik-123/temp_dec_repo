package com.mbridge.msdk.video.module;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.URLUtil;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.mbsignalcommon.windvane.f;
import com.mbridge.msdk.out.BaseTrackingListener;

/* loaded from: classes6.dex */
public class MBridgeLandingPageView extends MBridgeH5EndCardView {

    private static final class b implements com.mbridge.msdk.mbsignalcommon.base.a {
        private b() {
        }

        @Override // com.mbridge.msdk.mbsignalcommon.base.a
        public boolean a(String str) {
            if (TextUtils.isEmpty(str) || URLUtil.isNetworkUrl(str)) {
                return false;
            }
            t0.a(c.m().d(), str, (BaseTrackingListener) null);
            return true;
        }
    }

    public MBridgeLandingPageView(Context context) {
        super(context);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardView
    protected String getURL() {
        CampaignEx campaignEx = this.b;
        if (campaignEx != null) {
            return com.mbridge.msdk.click.c.a(campaignEx.getClickURL(), "-999", "-999");
        }
        return null;
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardView, com.mbridge.msdk.video.module.MBridgeBaseView
    public void init(Context context) {
        super.init(context);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardView, com.mbridge.msdk.video.module.MBridgeH5EndCardViewDiff
    public void preLoadData(com.mbridge.msdk.video.signal.factory.b bVar) {
        if (this.e) {
            this.p.setFilter(new b());
        }
        super.preLoadData(bVar);
        setVisibility(0);
        setCloseVisible(0);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardView, com.mbridge.msdk.video.module.MBridgeH5EndCardViewDiff
    public void webviewshow() {
        try {
            p0.a(MBridgeBaseView.TAG, "webviewshow");
            f.a().a((WebView) this.p, "webviewshow", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MBridgeLandingPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
