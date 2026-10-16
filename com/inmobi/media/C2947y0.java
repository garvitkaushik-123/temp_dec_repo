package com.inmobi.media;

import com.inmobi.ads.exceptions.VastException;
import com.inmobi.commons.core.configs.AdConfig;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.y0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2947y0 {
    public static final String BUYER_PRICE = "buyerPrice";
    public static final String CTX_HASH_KEY = "ctxHash";
    public static final C2931x0 Companion = new C2931x0();
    private static final long INVALID_AD_EXPIRY = -1;
    private static final String KEY_ADS = "ads";
    private static final String KEY_AD_SET_EXPIRY = "expiry";
    private static final String KEY_IMPRESSION_ID = "impressionId";
    private static final String KEY_IM_EXT = "imExts";
    private static final String KEY_MACROS = "macros";
    public static final String KEY_REQUEST_ID = "requestId";
    private static final String KEY_TRACKERS = "trackers";
    private static final String KEY_TRACKING_INFO = "trackingInfo";
    private static final String KEY_URL = "url";
    private static final String MACRO_ADV_PRICE = "${advPrice}";
    public static final String MACRO_CTX_HASH = "${ctxhash}";
    private static final String TAG = "y0";
    private final String adSetAuctionMeta;
    private String adType;
    private final boolean isPod;
    private Boolean isRewarded;
    private boolean logEnabled;
    private JSONObject macros;
    private long placementId;
    private final String adSetId = "";
    private String requestId = "";
    private boolean isAuctionClosed = true;
    private String transactionID = "";
    private final LinkedList<C2672h> ads = new LinkedList<>();

    public static /* synthetic */ void e() {
    }

    public final String c() {
        return this.adSetId;
    }

    public final String d() {
        return this.adType;
    }

    public final LinkedList<C2672h> f() {
        return this.ads;
    }

    public final boolean g() {
        return this.logEnabled;
    }

    public final JSONObject h() {
        return this.macros;
    }

    public final C2672h i() {
        try {
            if (!this.ads.isEmpty()) {
                CollectionsKt.removeFirst(this.ads);
            }
        } catch (Exception unused) {
        }
        return p();
    }

    public final long j() {
        return this.placementId;
    }

    public final String k() {
        return this.requestId;
    }

    public final String l() {
        return this.transactionID;
    }

    public final boolean m() {
        return this.isAuctionClosed;
    }

    public final boolean n() {
        return this.isPod;
    }

    public final Boolean o() {
        return this.isRewarded;
    }

    public final C2672h p() {
        try {
            if (this.ads.isEmpty()) {
                return null;
            }
            return this.ads.getFirst();
        } catch (Exception unused) {
            return null;
        }
    }

    public final String b() {
        return this.adSetAuctionMeta;
    }

    public final void a(Boolean bool) {
        this.isRewarded = bool;
    }

    public final void a(JSONObject responseJson, AdConfig adConfig, InterfaceC2971z5 interfaceC2971z5) throws JSONException {
        C2672h c2672h;
        Intrinsics.checkNotNullParameter(responseJson, "responseJson");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        if (!this.isAuctionClosed) {
            String string = responseJson.getString(KEY_REQUEST_ID);
            JSONArray jSONArray = responseJson.getJSONArray("ads");
            if (Intrinsics.areEqual(this.requestId, string)) {
                int length = jSONArray.length();
                if (length != 0) {
                    LinkedList linkedList = new LinkedList();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        String string2 = jSONObject.getString(KEY_IMPRESSION_ID);
                        this.macros = jSONObject.optJSONObject(KEY_MACROS);
                        Intrinsics.checkNotNull(string2);
                        Iterator<T> it = this.ads.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                c2672h = (C2672h) it.next();
                                if (Intrinsics.areEqual(string2, c2672h.s())) {
                                    break;
                                }
                            } else {
                                c2672h = null;
                                break;
                            }
                        }
                        if (c2672h != null) {
                            c2672h.a(this.macros);
                            try {
                                c2672h = J.a(c2672h, adConfig, interfaceC2971z5);
                            } catch (VastException unused) {
                            }
                            if (c2672h != null) {
                                JSONObject jSONObject2 = this.macros;
                                if (jSONObject2 != null) {
                                    if (jSONObject2.has(MACRO_ADV_PRICE)) {
                                        String string3 = jSONObject2.getString(MACRO_ADV_PRICE);
                                        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                                        c2672h.a(string3);
                                    }
                                    if (jSONObject2.has(MACRO_CTX_HASH)) {
                                        c2672h.b(jSONObject2.getString(MACRO_CTX_HASH));
                                    }
                                }
                                linkedList.add(c2672h);
                            }
                        }
                    }
                    this.ads.clear();
                    this.ads.addAll(linkedList);
                    if (!this.ads.isEmpty()) {
                        this.isAuctionClosed = true;
                        return;
                    }
                    throw new IllegalArgumentException("No matching ads to render");
                }
                throw new IllegalArgumentException("UAS response supplied doesn't have any ads");
            }
            throw new IllegalArgumentException("UAS response supplied was of a different requestId");
        }
        throw new IllegalStateException("Auction was already closed. Can't process UAS response");
    }

    public final void a(AdConfig adConfig, Te te, InterfaceC2971z5 interfaceC2971z5) {
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        C2672h p = p();
        if (p != null) {
            Se se = Se.f2431a;
            Se.a(p, adConfig, te, interfaceC2971z5);
        }
    }

    public final void a(C2672h ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        try {
            if (p() != null) {
                CollectionsKt.removeFirst(this.ads);
            }
        } catch (Exception unused) {
        }
        this.ads.add(0, ad);
    }
}
