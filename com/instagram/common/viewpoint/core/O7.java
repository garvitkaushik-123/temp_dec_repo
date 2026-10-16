package com.instagram.common.viewpoint.core;

import com.facebook.ads.AdExperienceType;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.RewardData;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.EnumSet;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: assets/audience_network/classes2.dex */
public final class O7 {
    public static String[] A0E = {"e4QKd0vFJKlBfNQUlIHhfqQvs", "ktN6BUw9VrN2JTOHJ8TIrrXahMZ3fTmV", "DLbbL7kcZ5O", "9b4HlLYHdUSJ33wbgi9UrYdebMHGJs2L", "z1qfKPKzPcrrDsrmM", "3k9SvbOHIOGx0S2BWPTRCyg1cNUtQJE0", "0GDGJhxXKJqU0yOd0NeRuUkLVmalwgCj", "KW1MjCrhBg"};
    public int A00;
    public long A01;
    public RewardData A02;
    public VW A03;
    public String A04;
    public String A05;
    public boolean A06;
    public final U3 A07;
    public final EnumC1403Vp A08;
    public final EnumC1404Vq A09;
    public final String A0A;
    public final EnumSet<CacheFlag> A0B;
    public final int A0C;
    public final AdPlacementType A0D;

    public O7(String str, EnumC1404Vq enumC1404Vq, AdPlacementType adPlacementType, EnumC1403Vp enumC1403Vp, int i, U3 u3) {
        this(str, enumC1404Vq, adPlacementType, enumC1403Vp, i, EnumSet.of(CacheFlag.NONE), u3);
    }

    public O7(String str, EnumC1404Vq enumC1404Vq, AdPlacementType adPlacementType, EnumC1403Vp enumC1403Vp, int i, EnumSet<CacheFlag> cacheFlags, U3 u3) {
        this.A0A = str;
        this.A0D = adPlacementType;
        this.A08 = enumC1403Vp;
        this.A0C = i;
        this.A0B = cacheFlags;
        this.A09 = enumC1404Vq;
        this.A00 = -1;
        this.A07 = u3;
    }

    public final WA A00(C1929gi c1929gi, C1408Vu c1408Vu, AdExperienceType adExperienceType) {
        return new WA(c1929gi, this.A0A, this.A08 != null ? new C1450Xn(this.A08.A04(), this.A08.A03()) : null, this.A09, this.A0C, c1408Vu, AbstractC1456Xt.A01(C1379Up.A0N(c1929gi)), this.A04, adExperienceType != null ? adExperienceType.getAdExperienceType() : null, this.A07);
    }

    public final Set<AdPlacementType> A01() {
        LinkedHashSet linkedHashSet = new LinkedHashSet(2);
        if (this.A0D == AdPlacementType.BANNER && this.A09 == EnumC1404Vq.A0D) {
            linkedHashSet.add(AdPlacementType.BANNER);
            AdPlacementType adPlacementType = AdPlacementType.MEDIUM_RECTANGLE;
            String[] strArr = A0E;
            if (strArr[4].length() == strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0E;
            strArr2[4] = "dJCx3L7RUa0HYA9jO";
            strArr2[0] = "pYtnX6DZAplUTv76Lm34k0kqX";
            linkedHashSet.add(adPlacementType);
            return linkedHashSet;
        }
        if (this.A0D != null) {
            linkedHashSet.add(this.A0D);
            return linkedHashSet;
        }
        if (this.A08 == null) {
            linkedHashSet.add(AdPlacementType.NATIVE);
            return linkedHashSet;
        }
        if (this.A08 == EnumC1403Vp.A08) {
            linkedHashSet.add(AdPlacementType.INTERSTITIAL);
            return linkedHashSet;
        }
        linkedHashSet.add(AdPlacementType.BANNER);
        return linkedHashSet;
    }

    public final void A02(int i) {
        this.A00 = i;
    }

    public final void A03(long j) {
        this.A01 = j;
    }

    public final void A04(RewardData rewardData) {
        this.A02 = rewardData;
    }

    public final void A05(VW vw) {
        this.A03 = vw;
    }

    public final void A06(String str) {
        this.A04 = str;
    }

    public final void A07(String str) {
        this.A05 = str;
    }

    public final void A08(boolean z) {
        this.A06 = z;
    }
}
