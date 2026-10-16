package com.mbridge.msdk.mbbanner.common.listener;

import com.mbridge.msdk.foundation.entity.CampaignEx;

/* compiled from: BannerBridgeListener.java */
/* loaded from: classes6.dex */
public interface a {
    void a(CampaignEx campaignEx);

    void a(boolean z);

    void a(boolean z, String str);

    void close();

    void readyStatus(int i);

    void toggleCloseBtn(int i);

    void triggerCloseBtn(String str);
}
