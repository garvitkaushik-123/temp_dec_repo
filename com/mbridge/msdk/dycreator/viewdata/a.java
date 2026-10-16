package com.mbridge.msdk.dycreator.viewdata;

import com.mbridge.msdk.dycreator.wrapper.DyOption;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* compiled from: MBRewardData.java */
/* loaded from: classes6.dex */
public class a implements com.mbridge.msdk.dycreator.viewdata.base.a {

    /* renamed from: a, reason: collision with root package name */
    private DyOption f4180a;
    private CampaignEx b;

    public a(DyOption dyOption) {
        this.f4180a = dyOption;
        this.b = dyOption.getCampaignEx();
    }

    @Override // com.mbridge.msdk.dycreator.viewdata.base.a
    public CampaignEx getBindData() {
        return this.b;
    }

    @Override // com.mbridge.msdk.dycreator.viewdata.base.a
    public DyOption getEffectData() {
        return this.f4180a;
    }
}
