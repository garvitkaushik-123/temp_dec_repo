package com.fyber.inneractive.sdk.bidder.adm;

import android.text.TextUtils;
import android.util.Base64;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.CreativeType;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.ImpressionData;
import com.fyber.inneractive.sdk.flow.b0;
import com.fyber.inneractive.sdk.network.d1;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Locale;

/* loaded from: classes4.dex */
public final class y implements com.fyber.inneractive.sdk.response.j {

    /* renamed from: a, reason: collision with root package name */
    public AdmParametersOuterClass$AdmParameters f1029a;
    public final String b;
    public String c;
    public final String d;

    public y(String str, String str2) {
        this.b = str;
        this.d = str2;
    }

    public final void a(b0 b0Var, com.fyber.inneractive.sdk.config.global.r rVar) {
        try {
            AdmParametersOuterClass$AdmParameters parseFrom = AdmParametersOuterClass$AdmParameters.parseFrom(Base64.decode(this.b, 0));
            this.f1029a = parseFrom;
            if (parseFrom != null) {
                b0Var.a();
            }
            b(b0Var, rVar);
        } catch (Exception e) {
            IAlog.f("failed to parse ad markup payload %s", e.getMessage());
            com.fyber.inneractive.sdk.util.r.b.post(new u(b0Var, e));
        }
    }

    public final void b(b0 b0Var, com.fyber.inneractive.sdk.config.global.r rVar) {
        AdmParametersOuterClass$AdmParameters admParametersOuterClass$AdmParameters = this.f1029a;
        com.fyber.inneractive.sdk.response.e eVar = null;
        String markupUrl = (admParametersOuterClass$AdmParameters == null || !admParametersOuterClass$AdmParameters.hasMarkupUrl()) ? null : this.f1029a.getMarkupUrl();
        if (TextUtils.isEmpty(markupUrl)) {
            com.fyber.inneractive.sdk.util.r.b.post(new x(b0Var));
            return;
        }
        try {
            AdmParametersOuterClass$AdmParameters admParametersOuterClass$AdmParameters2 = this.f1029a;
            int a2 = admParametersOuterClass$AdmParameters2 != null ? admParametersOuterClass$AdmParameters2.getAdType().a() : c.OTHER.a();
            com.fyber.inneractive.sdk.response.a a3 = com.fyber.inneractive.sdk.response.a.a(a2);
            if (a3 == null) {
                a3 = com.fyber.inneractive.sdk.response.a.RETURNED_ADTYPE_MRAID;
            }
            com.fyber.inneractive.sdk.factories.e eVar2 = (com.fyber.inneractive.sdk.factories.e) com.fyber.inneractive.sdk.factories.d.f1171a.f1172a.get(a3);
            com.fyber.inneractive.sdk.response.b b = eVar2 != null ? eVar2.b() : null;
            if (b != null) {
                b.f1726a = b.a();
                a(b);
                eVar = b.f1726a;
            } else {
                IAlog.a("failed parse adm network request with no input stream - received ad type %s does not have an appropriate parser", Integer.valueOf(a2));
            }
        } catch (Exception e) {
            IAlog.a("failed parse adm network request with no input stream", e, new Object[0]);
        }
        com.fyber.inneractive.sdk.response.e eVar3 = eVar;
        d1 d1Var = new d1(new v(this, b0Var, eVar3), markupUrl, this, rVar, eVar3);
        d1Var.d = new w(this);
        IAConfigManager.O.s.b(d1Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:133:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0367  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x034c  */
    @Override // com.fyber.inneractive.sdk.response.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(com.fyber.inneractive.sdk.response.b bVar) {
        String str;
        String str2;
        String str3;
        int i;
        com.fyber.inneractive.sdk.ignite.m mVar;
        String igniteLauncherActivity;
        Boolean valueOf;
        String brandBidderCtaText;
        Boolean valueOf2;
        bVar.f1726a.D = true;
        IAConfigManager.O.x.e = true;
        ImpressionData impressionData = new ImpressionData();
        AdmParametersOuterClass$AdmParameters admParametersOuterClass$AdmParameters = this.f1029a;
        if (admParametersOuterClass$AdmParameters == null) {
            return;
        }
        int a2 = admParametersOuterClass$AdmParameters.getAdType().a();
        if (this.f1029a.hasErrorMessage()) {
            this.f1029a.getErrorMessage();
        }
        String sessionId = this.f1029a.hasSessionId() ? this.f1029a.getSessionId() : null;
        Long valueOf3 = this.f1029a.hasContentId() ? Long.valueOf(this.f1029a.getContentId()) : null;
        if (this.f1029a.hasPublisherId()) {
            this.f1029a.getPublisherId();
        }
        Integer valueOf4 = this.f1029a.hasAdWidth() ? Integer.valueOf(this.f1029a.getAdWidth()) : null;
        Integer valueOf5 = this.f1029a.hasAdHeight() ? Integer.valueOf(this.f1029a.getAdHeight()) : null;
        String sdkImpressionUrl = this.f1029a.hasSdkImpressionUrl() ? this.f1029a.getSdkImpressionUrl() : null;
        String sdkClickUrl = this.f1029a.hasSdkClickUrl() ? this.f1029a.getSdkClickUrl() : null;
        Integer valueOf6 = this.f1029a.hasAdExpirationInterval() ? Integer.valueOf(this.f1029a.getAdExpirationInterval()) : null;
        String adCompletionUrl = this.f1029a.hasAdCompletionUrl() ? this.f1029a.getAdCompletionUrl() : null;
        String attributionImpressionUrl = this.f1029a.hasAttributionImpressionUrl() ? this.f1029a.getAttributionImpressionUrl() : null;
        String attributionClickUrl = this.f1029a.hasAttributionClickUrl() ? this.f1029a.getAttributionClickUrl() : null;
        bVar.b = this.f1029a.hasAdUnitId() ? this.f1029a.getAdUnitId() : null;
        String name = this.f1029a.getAdUnitType().name();
        Locale locale = Locale.US;
        name.toLowerCase(locale);
        String lowerCase = this.f1029a.hasAdUnitId() ? this.f1029a.getAdUnitDisplayType().name().toLowerCase(locale) : null;
        String adNetworkName = this.f1029a.hasAdNetworkName() ? this.f1029a.getAdNetworkName() : null;
        String str4 = lowerCase;
        Long valueOf7 = this.f1029a.hasAdNetworkId() ? Long.valueOf(this.f1029a.getAdNetworkId()) : null;
        Long l = valueOf3;
        String creativeId = this.f1029a.hasCreativeId() ? this.f1029a.getCreativeId() : null;
        Integer num = valueOf4;
        String adDomain = this.f1029a.hasAdDomain() ? this.f1029a.getAdDomain() : null;
        Integer num2 = valueOf5;
        String appBundleId = this.f1029a.hasAppBundleId() ? this.f1029a.getAppBundleId() : null;
        Integer num3 = valueOf6;
        String campaignId = this.f1029a.hasCampaignId() ? this.f1029a.getCampaignId() : null;
        String d = this.f1029a.hasPricingValue() ? Double.toString(this.f1029a.getPricingValue()) : null;
        String str5 = adDomain;
        String valueOf8 = this.f1029a.hasSpotId() ? String.valueOf(this.f1029a.getSpotId()) : null;
        impressionData.setCpmValue(d);
        impressionData.setCurrency("USD");
        if (this.f1029a.hasMrcData()) {
            int pixelPercent = this.f1029a.getMrcData().hasPixelPercent() ? this.f1029a.getMrcData().getPixelPercent() : 0;
            str = creativeId;
            int pixelDuration = this.f1029a.getMrcData().hasPixelDuration() ? this.f1029a.getMrcData().getPixelDuration() : -1;
            str3 = attributionClickUrl;
            String pixelImpressionUrl = this.f1029a.getMrcData().hasPixelImpressionUrl() ? this.f1029a.getMrcData().getPixelImpressionUrl() : null;
            str2 = attributionImpressionUrl;
            com.fyber.inneractive.sdk.response.e eVar = bVar.f1726a;
            eVar.v = pixelPercent;
            eVar.w = pixelDuration;
            eVar.x = pixelImpressionUrl;
        } else {
            str = creativeId;
            str2 = attributionImpressionUrl;
            str3 = attributionClickUrl;
        }
        Boolean valueOf9 = this.f1029a.hasSkipMode() ? Boolean.valueOf(this.f1029a.getSkipMode()) : null;
        bVar.f1726a.s = this.f1029a.toString();
        bVar.f1726a.a(num3 != null ? num3.toString() : "");
        impressionData.setImpressionId(sessionId);
        impressionData.setDemandSource(adNetworkName);
        bVar.f1726a.d = l != null ? l.toString() : "";
        bVar.f1726a.getClass();
        bVar.f1726a.getClass();
        com.fyber.inneractive.sdk.response.e eVar2 = bVar.f1726a;
        eVar2.A = appBundleId;
        eVar2.B = this.d;
        eVar2.C = valueOf8;
        if (valueOf7 != null) {
            impressionData.setDemandId(valueOf7);
        }
        com.fyber.inneractive.sdk.response.e eVar3 = bVar.f1726a;
        eVar3.g = a2;
        if (num != null) {
            eVar3.e = num.intValue();
        }
        if (num2 != null) {
            bVar.f1726a.f = num2.intValue();
        }
        com.fyber.inneractive.sdk.response.e eVar4 = bVar.f1726a;
        eVar4.k = sdkImpressionUrl;
        eVar4.l = sdkClickUrl;
        eVar4.q = adCompletionUrl;
        eVar4.m = str2;
        eVar4.n = str3;
        eVar4.o = bVar.b;
        try {
            eVar4.p = UnitDisplayType.fromValue(str4);
        } catch (IllegalArgumentException unused) {
            bVar.f1726a.p = UnitDisplayType.INTERSTITIAL;
        }
        if (!TextUtils.isEmpty(str)) {
            impressionData.setCreativeId(str);
        }
        if (!TextUtils.isEmpty(str5)) {
            impressionData.setAdvertiserDomain(str5);
        }
        if (!TextUtils.isEmpty(campaignId)) {
            impressionData.setCampaignId(campaignId);
        }
        impressionData.setCountry(com.fyber.inneractive.sdk.util.k.i());
        bVar.f1726a.t = impressionData;
        if (valueOf9 == null) {
            i = -1;
        } else {
            i = valueOf9.booleanValue() ? 1 : 0;
        }
        bVar.f1726a.y = i;
        String igniteInstallUrl = this.f1029a.hasIgniteInstallUrl() ? this.f1029a.getIgniteInstallUrl() : null;
        if (!TextUtils.isEmpty(igniteInstallUrl)) {
            bVar.f1726a.G = igniteInstallUrl;
        }
        com.fyber.inneractive.sdk.response.e eVar5 = bVar.f1726a;
        com.fyber.inneractive.sdk.ignite.m mVar2 = com.fyber.inneractive.sdk.ignite.m.NONE;
        AdmParametersOuterClass$AdmParameters admParametersOuterClass$AdmParameters2 = this.f1029a;
        if (admParametersOuterClass$AdmParameters2 != null) {
            n igniteMode = admParametersOuterClass$AdmParameters2.hasIgniteMode() ? this.f1029a.getIgniteMode() : null;
            if (igniteMode != null && !igniteMode.equals(n.NONE)) {
                mVar = igniteMode.equals(n.SINGLETAP) ? com.fyber.inneractive.sdk.ignite.m.SINGLE_TAP : com.fyber.inneractive.sdk.ignite.m.TRUE_SINGLE_TAP;
                if (mVar == null) {
                    mVar2 = mVar;
                } else {
                    eVar5.getClass();
                }
                eVar5.H = mVar2;
                igniteLauncherActivity = !this.f1029a.hasIgniteLauncherActivity() ? this.f1029a.getIgniteLauncherActivity() : null;
                if (!TextUtils.isEmpty(igniteLauncherActivity)) {
                    bVar.f1726a.I = igniteLauncherActivity;
                }
                valueOf = !this.f1029a.hasBrandBidderDontShowEndcard() ? Boolean.valueOf(this.f1029a.getBrandBidderDontShowEndcard()) : null;
                if (valueOf != null) {
                    bVar.f1726a.E = valueOf.booleanValue() ? "1" : "0";
                }
                brandBidderCtaText = this.f1029a.getBrandBidderCtaText();
                if (!TextUtils.isEmpty(brandBidderCtaText)) {
                    bVar.f1726a.F = brandBidderCtaText;
                }
                valueOf2 = !this.f1029a.hasMraidVideoOMSignal() ? Boolean.valueOf(this.f1029a.getMraidVideoOMSignal()) : null;
                if (valueOf2 != null) {
                    bVar.f1726a.J = valueOf2.booleanValue();
                }
                bVar.f1726a.M = CreativeType.fromValue(this.f1029a.getCreativeType());
            }
        }
        mVar = mVar2;
        if (mVar == null) {
        }
        eVar5.H = mVar2;
        if (!this.f1029a.hasIgniteLauncherActivity()) {
        }
        if (!TextUtils.isEmpty(igniteLauncherActivity)) {
        }
        if (!this.f1029a.hasBrandBidderDontShowEndcard()) {
        }
        if (valueOf != null) {
        }
        brandBidderCtaText = this.f1029a.getBrandBidderCtaText();
        if (!TextUtils.isEmpty(brandBidderCtaText)) {
        }
        if (!this.f1029a.hasMraidVideoOMSignal()) {
        }
        if (valueOf2 != null) {
        }
        bVar.f1726a.M = CreativeType.fromValue(this.f1029a.getCreativeType());
    }

    @Override // com.fyber.inneractive.sdk.response.j
    public final String a() {
        return this.c;
    }
}
