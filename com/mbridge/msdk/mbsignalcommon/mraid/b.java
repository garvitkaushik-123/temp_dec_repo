package com.mbridge.msdk.mbsignalcommon.mraid;

import com.mbridge.msdk.foundation.entity.CampaignEx;

/* compiled from: IMraidSignalCommunication.java */
/* loaded from: classes6.dex */
public interface b {
    void close();

    void expand(String str, boolean z);

    CampaignEx getMraidCampaign();

    void open(String str);

    void unload();

    void useCustomClose(boolean z);
}
