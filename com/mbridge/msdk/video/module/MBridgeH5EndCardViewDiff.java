package com.mbridge.msdk.video.module;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.mbridge.msdk.click.a;
import com.mbridge.msdk.click.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.mbsignalcommon.mraid.b;
import com.mbridge.msdk.video.signal.h;

/* loaded from: classes6.dex */
public abstract class MBridgeH5EndCardViewDiff extends MBridgeBaseView implements h, b, j {
    public String unitId;

    public MBridgeH5EndCardViewDiff(Context context) {
        super(context);
    }

    public abstract /* synthetic */ void close();

    public abstract /* synthetic */ void expand(String str, boolean z);

    public abstract /* synthetic */ CampaignEx getMraidCampaign();

    public abstract /* synthetic */ void handlerPlayableException(String str);

    public abstract /* synthetic */ void install(CampaignEx campaignEx);

    public abstract /* synthetic */ void notifyCloseBtn(int i);

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
            a aVar = new a(getContext(), this.unitId);
            aVar.a(this);
            aVar.a(this.b);
            this.b.setClickURL(clickURL);
            this.notifyListener.a(126, "");
        } catch (Exception e) {
            p0.b(MBridgeBaseView.TAG, e.getMessage());
        }
    }

    public abstract /* synthetic */ void orientation(Configuration configuration);

    public abstract /* synthetic */ void preLoadData(com.mbridge.msdk.video.signal.factory.b bVar);

    public abstract /* synthetic */ void readyStatus(int i);

    public void reportOpen(String str) {
        CampaignEx mraidCampaign = getMraidCampaign();
        if (mraidCampaign != null) {
            new com.mbridge.msdk.foundation.same.report.h(getContext()).a(mraidCampaign.getRequestId(), mraidCampaign.getRequestIdNotice(), mraidCampaign.getId(), this.unitId, str, this.b.isBidCampaign());
        }
    }

    public abstract /* synthetic */ void toggleCloseBtn(int i);

    public abstract /* synthetic */ void unload();

    public abstract /* synthetic */ void useCustomClose(boolean z);

    public abstract /* synthetic */ void webviewshow();

    public MBridgeH5EndCardViewDiff(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
