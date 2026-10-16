package com.fyber.inneractive.sdk.response;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.CreativeType;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.ImpressionData;
import com.fyber.inneractive.sdk.ignite.m;
import com.fyber.inneractive.sdk.network.n;
import com.fyber.inneractive.sdk.network.o;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.t;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes4.dex */
public final class k implements j {

    /* renamed from: a, reason: collision with root package name */
    public final o f1729a;

    public k(o oVar) {
        this.f1729a = oVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0227  */
    @Override // com.fyber.inneractive.sdk.response.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(b bVar) {
        float parseFloat;
        Long valueOf;
        bVar.f1726a.D = false;
        IAConfigManager.O.x.e = false;
        ImpressionData impressionData = new ImpressionData();
        Map b = this.f1729a.b();
        String a2 = a(b, n.RETURNED_AD_TYPE);
        a(b, n.ERROR_CODE);
        String a3 = a(b, n.SESSION_ID);
        String a4 = a(b, n.CONTENT_ID);
        a(b, n.PUBLISHER_ID);
        String a5 = a(b, n.WIDTH);
        String a6 = a(b, n.HEIGHT);
        String a7 = a(b, n.SDK_IMPRESSION_URL);
        String a8 = a(b, n.SDK_CLICK_URL);
        String a9 = a(b, n.ATTRIBUTION_IMPRESSION_URL);
        String a10 = a(b, n.ATTRIBUTION_CLICK_URL);
        String a11 = a(b, n.AD_TIMEOUT);
        String a12 = a(b, n.AD_COMPLETION_URL);
        bVar.b = a(b, n.AD_UNIT_ID);
        a(b, n.AD_UNIT_TYPE);
        String a13 = a(b, n.AD_UNIT_DISPLAY_TYPE);
        String a14 = a(b, n.AD_NETWORK);
        String a15 = a(b, n.AD_NETWORK_ID);
        String a16 = a(b, n.CREATIVE_ID);
        String a17 = a(b, n.AD_DOMAIN);
        String a18 = a(b, n.APP_BUNDLE);
        String a19 = a(b, n.CAMPAIGN_ID);
        String a20 = a(b, n.CPM_VALUE);
        String a21 = a(b, n.CPM_CURRENCY);
        impressionData.setCpmValue(a20);
        impressionData.setCurrency(a21);
        String a22 = a(b, n.BANNER_MRC_PERCENT);
        String a23 = a(b, n.BANNER_MRC_DURATION);
        String a24 = a(b, n.BANNER_MRC_IMPRESSION_URL);
        String a25 = a(b, n.INTERSTITIAL_SKIP_MODE);
        String a26 = a(b, n.IGNITE_INSTALL_URL);
        String a27 = a(b, n.IGNITE_MODE);
        String a28 = a(b, n.APP_BUNDLE_LAUNCHER);
        String a29 = a(b, n.BRAND_BIDDER_SHOW_ENDCARD);
        String a30 = a(b, n.BRAND_BIDDER_CTA_TEXT);
        String a31 = a(b, n.MRAID_VIDEO_SIGNAL);
        String a32 = a(b, n.CREATIVE_TYPE);
        e eVar = bVar.f1726a;
        eVar.r = b;
        eVar.a(a11);
        impressionData.setImpressionId(a3);
        impressionData.setDemandSource(a14);
        e eVar2 = bVar.f1726a;
        eVar2.d = a4;
        eVar2.getClass();
        bVar.f1726a.A = a18;
        if (!TextUtils.isEmpty(a15)) {
            if (!TextUtils.isEmpty(a15)) {
                try {
                    valueOf = Long.valueOf(a15);
                } catch (NumberFormatException unused) {
                }
                impressionData.setDemandId(valueOf);
            }
            valueOf = null;
            impressionData.setDemandId(valueOf);
        }
        if (!TextUtils.isEmpty(a2)) {
            bVar.f1726a.g = Integer.valueOf(a2).intValue();
        }
        if (!TextUtils.isEmpty(a5)) {
            bVar.f1726a.e = Integer.valueOf(a5).intValue();
        }
        if (!TextUtils.isEmpty(a6)) {
            bVar.f1726a.f = Integer.valueOf(a6).intValue();
        }
        e eVar3 = bVar.f1726a;
        eVar3.k = a7;
        eVar3.l = a8;
        eVar3.m = a9;
        eVar3.n = a10;
        eVar3.q = a12;
        eVar3.o = bVar.b;
        try {
            eVar3.p = UnitDisplayType.fromValue(a13);
        } catch (IllegalArgumentException unused2) {
            bVar.f1726a.p = UnitDisplayType.INTERSTITIAL;
        }
        if (!TextUtils.isEmpty(a16)) {
            impressionData.setCreativeId(a16);
        }
        if (!TextUtils.isEmpty(a17)) {
            impressionData.setAdvertiserDomain(a17);
        }
        if (!TextUtils.isEmpty(a19)) {
            impressionData.setCampaignId(a19);
        }
        impressionData.setCountry(com.fyber.inneractive.sdk.util.k.i());
        e eVar4 = bVar.f1726a;
        eVar4.t = impressionData;
        eVar4.v = t.a(a22, 0);
        e eVar5 = bVar.f1726a;
        if (!TextUtils.isEmpty(a23)) {
            try {
                parseFloat = Float.parseFloat(a23);
            } catch (NumberFormatException unused3) {
            }
            eVar5.w = parseFloat;
            e eVar6 = bVar.f1726a;
            eVar6.x = a24;
            eVar6.y = t.a(a25, -1);
            if (!TextUtils.isEmpty(a26)) {
                bVar.f1726a.G = a26;
            }
            if (!TextUtils.isEmpty(a27)) {
                e eVar7 = bVar.f1726a;
                m a33 = m.a(a27);
                if (a33 == null) {
                    eVar7.getClass();
                    a33 = m.NONE;
                }
                eVar7.H = a33;
            }
            if (!TextUtils.isEmpty(a28)) {
                bVar.f1726a.I = a28;
            }
            if (!TextUtils.isEmpty(a29)) {
                bVar.f1726a.E = a29;
            }
            if (!TextUtils.isEmpty(a30)) {
                bVar.f1726a.F = a30;
            }
            bVar.f1726a.J = !"1".equals(a31) || Boolean.parseBoolean(a31);
            bVar.f1726a.M = CreativeType.fromValue(a32);
        }
        parseFloat = -1.0f;
        eVar5.w = parseFloat;
        e eVar62 = bVar.f1726a;
        eVar62.x = a24;
        eVar62.y = t.a(a25, -1);
        if (!TextUtils.isEmpty(a26)) {
        }
        if (!TextUtils.isEmpty(a27)) {
        }
        if (!TextUtils.isEmpty(a28)) {
        }
        if (!TextUtils.isEmpty(a29)) {
        }
        if (!TextUtils.isEmpty(a30)) {
        }
        bVar.f1726a.J = !"1".equals(a31) || Boolean.parseBoolean(a31);
        bVar.f1726a.M = CreativeType.fromValue(a32);
    }

    @Override // com.fyber.inneractive.sdk.response.j
    public final String a() {
        return this.f1729a.a().toString();
    }

    public final String a(Map map, n nVar) {
        String lowerCase = nVar.a().toLowerCase(Locale.US);
        String str = (String) map.get(lowerCase);
        IAlog.e("%s%s extracted from response header: %s", IAlog.a(this), lowerCase, str);
        IAlog.d("%s %s : %s", "RESPONSE_HEADER", lowerCase, str);
        return str;
    }
}
