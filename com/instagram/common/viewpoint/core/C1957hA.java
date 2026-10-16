package com.instagram.common.viewpoint.core;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdScrollView;
import com.facebook.ads.NativeAdView;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.NativeAdsManager;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.hA, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1957hA extends PS {
    public static String[] A02 = {"mOKLXDYLG6rjJ8Uhc3dA94WggTy9aTCY", "BGa58WlKg30brm3iaXDpmKRreNqQx6sP", "OEIW0kNKyti99uOllTeGQwyl2xTRs9Rh", "66ZfANP52P8mfwFN1T5txUDlKbhE7PV5", "bDC5rvyouDOgyvzMPOhXiUUV9GXsFm8X", "OYxAj3HMhtWdnmP8KTtjhXT1I6nqQa9s", "h9E4hr1XPZf2wtmTKQKy9uKgM46lwlc6", "41TCzlsMJFbrsVbgrjJGy8KkwVmNtDJ0"};
    public List<NativeAd> A00 = new ArrayList();
    public final /* synthetic */ S3 A01;

    public C1957hA(S3 s3) {
        this.A01 = s3;
    }

    @Override // com.instagram.common.viewpoint.core.PS
    public final int A01() {
        return this.A00.size();
    }

    @Override // com.instagram.common.viewpoint.core.PS
    public final int A02(Object obj) {
        int index = this.A00.indexOf(obj);
        if (index >= 0) {
            return index;
        }
        return -2;
    }

    @Override // com.instagram.common.viewpoint.core.PS
    public final Object A04(ViewGroup viewGroup, int i) {
        NativeAdScrollView.AdViewProvider adViewProvider;
        NativeAdView.Type type;
        C1929gi c1929gi;
        NativeAdViewAttributes nativeAdViewAttributes;
        View adView;
        C1929gi c1929gi2;
        NativeAdView.Type type2;
        NativeAdViewAttributes nativeAdViewAttributes2;
        NativeAdScrollView.AdViewProvider adViewProvider2;
        adViewProvider = this.A01.A01;
        if (adViewProvider != null) {
            adViewProvider2 = this.A01.A01;
            adView = adViewProvider2.createView(this.A00.get(i), i);
        } else {
            type = this.A01.A02;
            if (type != null) {
                c1929gi2 = this.A01.A06;
                NativeAd nativeAd = this.A00.get(i);
                type2 = this.A01.A02;
                nativeAdViewAttributes2 = this.A01.A03;
                adView = NativeAdView.render(c1929gi2, nativeAd, type2, nativeAdViewAttributes2);
            } else {
                c1929gi = this.A01.A06;
                NativeAd nativeAd2 = this.A00.get(i);
                nativeAdViewAttributes = this.A01.A03;
                adView = NativeAdView.render(c1929gi, nativeAd2, nativeAdViewAttributes);
            }
        }
        viewGroup.addView(adView);
        return adView;
    }

    @Override // com.instagram.common.viewpoint.core.PS
    public final void A07(ViewGroup viewGroup, int i, Object obj) {
        NativeAdScrollView.AdViewProvider adViewProvider;
        NativeAdScrollView.AdViewProvider adViewProvider2;
        if (i < this.A00.size()) {
            S3 s3 = this.A01;
            if (A02[4].charAt(30) == 'x') {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[2] = "v77RhDbNLQhSOdbZwI5GIdcCxuAqz5PX";
            strArr[7] = "TxIZGVGrDJLkO7AUrnSGEi4CFfNom122";
            adViewProvider = s3.A01;
            if (adViewProvider != null) {
                adViewProvider2 = this.A01.A01;
                adViewProvider2.destroyView(this.A00.get(i), (View) obj);
            } else {
                this.A00.get(i).unregisterView();
            }
        }
        viewGroup.removeView((View) obj);
    }

    @Override // com.instagram.common.viewpoint.core.PS
    public final boolean A08(View view, Object obj) {
        return view == obj;
    }

    public final void A09() {
        int i;
        NativeAdsManager nativeAdsManager;
        NativeAdsManager nativeAdsManager2;
        this.A00.clear();
        i = this.A01.A00;
        nativeAdsManager = this.A01.A04;
        int min = Math.min(i, nativeAdsManager.getUniqueNativeAdCount());
        for (int i2 = 0; i2 < min; i2++) {
            nativeAdsManager2 = this.A01.A04;
            NativeAd ad = nativeAdsManager2.nextNativeAd();
            UK.A0L(ad.getInternalNativeAd()).A1l(true);
            this.A00.add(ad);
        }
        A05();
    }
}
