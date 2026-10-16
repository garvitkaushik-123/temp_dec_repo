package com.mbridge.msdk.mbbid.out;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.authoritycontroller.c;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.mbbid.common.middle.b;
import java.util.Map;

/* loaded from: classes6.dex */
public class BidManager {

    /* renamed from: a, reason: collision with root package name */
    private b f4488a;
    private BidListennning b;
    private boolean c;

    public BidManager(String str, String str2) {
        this(str, str2, "0");
    }

    private void a(String str) {
        BidListennning bidListennning = this.b;
        if (bidListennning != null) {
            bidListennning.onFailed(str);
        }
    }

    public static String getBuyerUid(Context context) {
        if (com.mbridge.msdk.util.b.a()) {
            try {
                c.c(true);
            } catch (Throwable th) {
                p0.b("BidManager", th.getMessage());
            }
        }
        return com.mbridge.msdk.mbbid.common.b.a(context, "");
    }

    public void bid() {
        b bVar = this.f4488a;
        if (bVar != null) {
            bVar.a(this.c);
        } else {
            a("you need init the class :BidManager");
        }
    }

    public void setBidListener(BidListennning bidListennning) {
        this.b = bidListennning;
        b bVar = this.f4488a;
        if (bVar != null) {
            bVar.a(bidListennning);
        }
    }

    public void setRewardPlus(boolean z) {
        this.c = z;
    }

    public BidManager(String str, String str2, String str3) {
        this.c = false;
        this.f4488a = new b(str, str2, str3);
    }

    public static String getBuyerUid(Context context, String str) {
        if (com.mbridge.msdk.util.b.a()) {
            try {
                c.c(true);
            } catch (Throwable th) {
                p0.b("BidManager", th.getMessage());
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return com.mbridge.msdk.mbbid.common.b.a(context, str);
    }

    public <T extends CommonBidRequestParams> BidManager(T t) {
        this(t == null ? "" : t.getmPlacementId(), t == null ? "" : t.getmUnitId(), t != null ? t.getmFloorPrice() : "");
        if (t instanceof BannerBidRequestParams) {
            BannerBidRequestParams bannerBidRequestParams = (BannerBidRequestParams) t;
            this.f4488a.a(bannerBidRequestParams.getHeight());
            this.f4488a.b(bannerBidRequestParams.getWidth());
            this.f4488a.a(296);
            if (t instanceof SplashBidRequestParams) {
                SplashBidRequestParams splashBidRequestParams = (SplashBidRequestParams) t;
                this.f4488a.b(splashBidRequestParams.a());
                this.f4488a.b(splashBidRequestParams.getOrientation());
                this.f4488a.a(297);
                return;
            }
            return;
        }
        if (t instanceof AdvancedNativeBidRequestParams) {
            AdvancedNativeBidRequestParams advancedNativeBidRequestParams = (AdvancedNativeBidRequestParams) t;
            this.f4488a.a(advancedNativeBidRequestParams.getHeight());
            this.f4488a.b(advancedNativeBidRequestParams.getWidth());
            this.f4488a.a(298);
        }
    }

    public static String getBuyerUid(Context context, Map<String, String> map) {
        if (com.mbridge.msdk.util.b.a()) {
            try {
                c.c(true);
            } catch (Throwable th) {
                p0.b("BidManager", th.getMessage());
            }
        }
        return com.mbridge.msdk.mbbid.common.b.a(context, map);
    }
}
