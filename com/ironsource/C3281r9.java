package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.ironsource.r9, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3281r9 extends AbstractC3208n3<C3315t9, AdapterAdInteractionListener> {
    public C3281r9(List<NetworkSettings> list, C3366w9 c3366w9, String str, Z9 z9, IronSourceSegment ironSourceSegment) {
        super(new C3298s9(str, list, c3366w9), z9, ironSourceSegment);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ironsource.AbstractC3242p3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C3315t9 a(NetworkSettings networkSettings, BaseAdAdapter<?, AdapterAdInteractionListener> baseAdAdapter, int i, String str, C3207n2 c3207n2) {
        return new C3315t9(this, new C3171l0(IronSource.AD_UNIT.INTERSTITIAL, this.o.o(), i, this.g, str, this.e, this.f, networkSettings, this.o.n()), baseAdAdapter, c3207n2, this);
    }

    @Override // com.ironsource.AbstractC3242p3
    protected K0 g() {
        return new A9();
    }

    @Override // com.ironsource.AbstractC3242p3
    protected String l() {
        return IronSourceConstants.INTERSTITIAL_EVENT_TYPE;
    }

    @Override // com.ironsource.AbstractC3242p3
    protected String o() {
        return IronSourceConstants.OPW_IS_MANAGER_NAME;
    }

    C3281r9(H7 h7, G7 g7, List<NetworkSettings> list, C3366w9 c3366w9, String str, Z9 z9, IronSourceSegment ironSourceSegment) {
        super(h7, g7, new C3298s9(str, list, c3366w9), z9, ironSourceSegment);
    }

    @Override // com.ironsource.AbstractC3242p3
    protected JSONObject b(NetworkSettings networkSettings) {
        return networkSettings.getInterstitialSettings();
    }
}
