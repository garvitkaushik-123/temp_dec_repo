package com.ironsource;

import android.text.TextUtils;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class U1 implements C0 {

    /* renamed from: a, reason: collision with root package name */
    private final C3156k2 f3065a;

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3066a;

        static {
            int[] iArr = new int[A0.values().length];
            try {
                iArr[A0.LOAD_AD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[A0.LOAD_AD_SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[A0.LOAD_AD_FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[A0.LOAD_AD_FAILED_WITH_REASON.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[A0.AUCTION_SUCCESS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[A0.AUCTION_FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[A0.AUCTION_FAILED_NO_CANDIDATES.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[A0.LOAD_AD_NO_FILL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[A0.AD_OPENED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[A0.AD_CLOSED.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[A0.SHOW_AD.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[A0.SHOW_AD_FAILED.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[A0.AD_CLICKED.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[A0.AD_REWARDED.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[A0.RELOAD_AD_FAILED_WITH_REASON.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[A0.RELOAD_AD_SUCCESS.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[A0.AD_LEFT_APPLICATION.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            f3066a = iArr;
        }
    }

    public U1(C3156k2 auctionData) {
        Intrinsics.checkNotNullParameter(auctionData, "auctionData");
        this.f3065a = auctionData;
    }

    private final boolean b(A0 a0) {
        switch (a.f3066a[a0.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
                return true;
            default:
                return false;
        }
    }

    @Override // com.ironsource.C0
    public Map<String, Object> a(A0 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        HashMap hashMap = new HashMap();
        JSONObject h = this.f3065a.h();
        if (h != null && h.length() > 0) {
            hashMap.put("genericParams", h);
        }
        if (b(event)) {
            hashMap.put(IronSourceConstants.AUCTION_TRIALS, Integer.valueOf(this.f3065a.i()));
            if (!TextUtils.isEmpty(this.f3065a.f())) {
                hashMap.put(IronSourceConstants.AUCTION_FALLBACK, this.f3065a.f());
            }
        }
        if (!TextUtils.isEmpty(this.f3065a.g())) {
            hashMap.put("auctionId", this.f3065a.g());
        }
        return hashMap;
    }
}
