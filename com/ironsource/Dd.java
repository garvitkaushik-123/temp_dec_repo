package com.ironsource;

import com.ironsource.N0;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.LoadWhileShowSupportState;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterSettingsInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdRewardListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class Dd extends AbstractC3259q3<Ed> {
    public Dd(List<NetworkSettings> list, Gd gd, String str, boolean z, Z9 z9, IronSourceSegment ironSourceSegment) {
        super(new Bd(str, list, gd, z), z9, ironSourceSegment);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ironsource.AbstractC3242p3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Ed a(NetworkSettings networkSettings, BaseAdAdapter<?, AdapterAdRewardListener> baseAdAdapter, int i, String str, C3207n2 c3207n2) {
        return new Ed(this, new C3171l0(IronSource.AD_UNIT.REWARDED_VIDEO, this.o.o(), i, this.g, str, this.e, this.f, networkSettings, this.o.n()), baseAdAdapter, c3207n2, this);
    }

    @Override // com.ironsource.AbstractC3242p3
    protected K0 g() {
        return new Jd();
    }

    @Override // com.ironsource.AbstractC3242p3
    protected String l() {
        return IronSourceConstants.REWARDED_VIDEO_EVENT_TYPE;
    }

    @Override // com.ironsource.AbstractC3242p3
    protected String o() {
        return IronSourceConstants.OPW_RV_MANAGER_NAME;
    }

    @Override // com.ironsource.AbstractC3242p3
    protected boolean q() {
        return this.o.h().a() == N0.a.MANUAL;
    }

    @Override // com.ironsource.AbstractC3242p3
    protected boolean t() {
        return this.o.h().a() == N0.a.AUTOMATIC_LOAD_WHILE_SHOW;
    }

    @Override // com.ironsource.AbstractC3242p3
    protected LoadWhileShowSupportState a(NetworkSettings networkSettings, AdapterBaseInterface adapterBaseInterface) {
        return ((AdapterSettingsInterface) adapterBaseInterface).getLoadWhileShowSupportedState(networkSettings);
    }

    @Override // com.ironsource.AbstractC3242p3
    protected void a(IronSourceError ironSourceError) {
        N0.a a2 = this.o.h().a();
        if (a2 != N0.a.AUTOMATIC_LOAD_AFTER_CLOSE && a2 != N0.a.AUTOMATIC_LOAD_WHILE_SHOW) {
            super.a(ironSourceError);
        } else {
            this.t.a(false, (AdInfo) null);
        }
    }

    @Override // com.ironsource.AbstractC3242p3
    protected JSONObject b(NetworkSettings networkSettings) {
        return networkSettings.getRewardedVideoSettings();
    }
}
