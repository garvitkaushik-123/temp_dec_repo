package com.inmobi.media;

import com.iab.omid.library.inmobi.adsession.Partner;
import com.inmobi.commons.core.configs.AdConfig;
import kotlin.text.StringsKt;

/* renamed from: com.inmobi.media.oa, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2796oa extends AbstractC2780na {
    public Partner b = Partner.createPartner("Inmobi", "a" + StringsKt.replace$default("10.8.7", ".", "", false, 4, (Object) null));

    /* JADX WARN: Code restructure failed: missing block: B:14:0x000c, code lost:
    
        if (r10 != null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(AdConfig adConfig) {
        AdConfig.OmidConfig omidConfig;
        if (adConfig != null) {
            try {
                AdConfig.ViewabilityConfig viewability = adConfig.getViewability();
                if (viewability != null) {
                    omidConfig = viewability.getOmidConfig();
                }
            } catch (Exception e) {
                S5 s5 = S5.f2425a;
                S5.d.a(AbstractC2920w5.a(e, "event"));
                return;
            }
        }
        omidConfig = new AdConfig.OmidConfig();
        this.b = Partner.createPartner(omidConfig.getPartnerKey(), "a" + StringsKt.replace$default("10.8.7", ".", "", false, 4, (Object) null));
        AbstractC2699ia.a(omidConfig);
    }
}
