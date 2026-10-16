package com.fyber.inneractive.sdk.measurement.tracker;

import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.web.m;
import com.iab.omid.library.fyber.adsession.AdEvents;
import com.iab.omid.library.fyber.adsession.AdSessionConfiguration;
import com.iab.omid.library.fyber.adsession.CreativeType;
import com.iab.omid.library.fyber.adsession.ImpressionType;
import com.iab.omid.library.fyber.adsession.Owner;
import com.iab.omid.library.fyber.adsession.Partner;

/* loaded from: classes4.dex */
public final class a extends e {
    public a(Partner partner, m mVar) {
        super(partner, mVar);
    }

    @Override // com.fyber.inneractive.sdk.measurement.tracker.e
    public final void a(m mVar) {
        super.a(mVar);
        try {
            AdEvents createAdEvents = AdEvents.createAdEvents(this.f1273a);
            this.b = createAdEvents;
            createAdEvents.loaded();
        } catch (Throwable unused) {
        }
    }

    @Override // com.fyber.inneractive.sdk.measurement.tracker.e
    public final AdSessionConfiguration b() {
        try {
            return AdSessionConfiguration.createAdSessionConfiguration(CreativeType.HTML_DISPLAY, ImpressionType.UNSPECIFIED, Owner.NATIVE, Owner.NONE, false);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.fyber.inneractive.sdk.measurement.tracker.e
    public final void c() {
        AdEvents adEvents;
        if (this.c || this.f1273a == null || (adEvents = this.b) == null) {
            return;
        }
        this.c = true;
        try {
            adEvents.impressionOccurred();
        } catch (Throwable unused) {
        }
    }

    @Override // com.fyber.inneractive.sdk.measurement.tracker.e
    public final void a() {
        IAlog.f("%s Unsupported functionality for non video MRAID ads", IAlog.a(this));
    }
}
