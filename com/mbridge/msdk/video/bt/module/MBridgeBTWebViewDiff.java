package com.mbridge.msdk.video.bt.module;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.mbridge.msdk.click.a;
import com.mbridge.msdk.click.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.h;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.mbsignalcommon.mraid.b;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.video.signal.impl.k;

/* loaded from: classes6.dex */
public abstract class MBridgeBTWebViewDiff extends BTBaseView implements b, j {
    public k jsCommon;
    public WindVaneWebView webView;

    public MBridgeBTWebViewDiff(Context context) {
        super(context);
    }

    public abstract /* synthetic */ void close();

    public abstract /* synthetic */ void expand(String str, boolean z);

    public abstract /* synthetic */ CampaignEx getMraidCampaign();

    public void open(String str) {
        try {
            String clickURL = this.b.getClickURL();
            if (!TextUtils.isEmpty(str)) {
                this.b.setClickURL(str);
                reportOpen(str);
            }
            this.b.setClickTempSource(2);
            this.b.setClickType(2);
            this.b.setTriggerClickSource(2);
            a aVar = new a(getContext(), this.c);
            aVar.a(this);
            aVar.a(this.b);
            this.b.setClickURL(clickURL);
        } catch (Throwable th) {
            p0.b(BTBaseView.TAG, th.getMessage());
        }
    }

    public void reportOpen(String str) {
        try {
            CampaignEx mraidCampaign = getMraidCampaign();
            if (mraidCampaign != null) {
                new h(getContext()).a(mraidCampaign.getRequestId(), mraidCampaign.getRequestIdNotice(), mraidCampaign.getId(), this.c, str, this.b.isBidCampaign());
            }
        } catch (Throwable th) {
            p0.a(BTBaseView.TAG, th.getMessage());
        }
    }

    public void setChinaAlertInstallState(k kVar) {
    }

    public abstract /* synthetic */ void unload();

    public abstract /* synthetic */ void useCustomClose(boolean z);

    public MBridgeBTWebViewDiff(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
