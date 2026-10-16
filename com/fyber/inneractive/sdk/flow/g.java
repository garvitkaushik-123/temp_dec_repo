package com.fyber.inneractive.sdk.flow;

import android.content.Context;
import com.fyber.inneractive.sdk.activities.FyberReportAdActivity;
import com.fyber.inneractive.sdk.external.ImpressionData;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.ui.FyberAdIdentifierFactory;
import com.fyber.inneractive.sdk.ui.FyberAdIdentifierLocal;
import com.fyber.inneractive.sdk.ui.FyberAdIdentifierRemote;
import com.fyber.inneractive.sdk.ui.IFyberAdIdentifier;

/* loaded from: classes4.dex */
public final class g implements IFyberAdIdentifier.ClickListener, h {

    /* renamed from: a, reason: collision with root package name */
    public final Context f1203a;
    public final InneractiveAdRequest b;
    public final com.fyber.inneractive.sdk.response.e c;
    public final IFyberAdIdentifier d;

    public g(Context context, boolean z, InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.response.e eVar, com.fyber.inneractive.sdk.config.global.r rVar) {
        this.f1203a = context;
        this.b = inneractiveAdRequest;
        this.c = eVar;
        new FyberAdIdentifierFactory();
        IFyberAdIdentifier fyberAdIdentifierRemote = z ? new FyberAdIdentifierRemote(rVar) : new FyberAdIdentifierLocal(rVar);
        this.d = fyberAdIdentifierRemote;
        fyberAdIdentifierRemote.f1738a = this;
    }

    @Override // com.fyber.inneractive.sdk.ui.IFyberAdIdentifier.ClickListener
    public final void a() {
        Long l;
        String str;
        com.fyber.inneractive.sdk.response.e eVar = this.c;
        String str2 = null;
        if (eVar != null) {
            ImpressionData impressionData = eVar.t;
            String advertiserDomain = impressionData != null ? impressionData.getAdvertiserDomain() : null;
            ImpressionData impressionData2 = this.c.t;
            str = impressionData2 != null ? impressionData2.getDemandSource() : null;
            ImpressionData impressionData3 = this.c.t;
            str2 = advertiserDomain;
            l = impressionData3 != null ? impressionData3.getDemandId() : null;
        } else {
            l = null;
            str = null;
        }
        FyberReportAdActivity.start(this.f1203a, this, str2, str, l);
    }
}
