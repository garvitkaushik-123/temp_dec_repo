package com.fyber.inneractive.sdk.external;

import com.fyber.inneractive.sdk.config.s0;
import com.fyber.inneractive.sdk.flow.t0;

/* loaded from: classes4.dex */
public class InneractiveAdRequest extends t0 {
    public final String c;
    public s0 d;

    public InneractiveAdRequest(String str) {
        this.c = str;
    }

    @Deprecated
    public boolean getMuteVideo() {
        return InneractiveAdManager.getMuteVideo();
    }

    public s0 getSelectedUnitConfig() {
        return this.d;
    }

    public String getSpotId() {
        return this.c;
    }

    @Deprecated
    public InneractiveUserConfig getUserParams() {
        return InneractiveAdManager.getUserParams();
    }

    @Deprecated
    public void setMuteVideo(boolean z) {
        InneractiveAdManager.setMuteVideo(z);
    }

    public void setSelectedUnitConfig(s0 s0Var) {
        this.d = s0Var;
    }

    @Deprecated
    public void setUserParams(InneractiveUserConfig inneractiveUserConfig) {
        InneractiveAdManager.setUserParams(inneractiveUserConfig);
    }
}
