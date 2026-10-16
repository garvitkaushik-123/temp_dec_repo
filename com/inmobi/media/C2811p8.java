package com.inmobi.media;

import android.graphics.Point;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.compose.material.OutlinedTextFieldKt;
import com.adjust.sdk.Constants;
import com.google.firebase.ktx.BuildConfig;
import com.inmobi.commons.core.configs.AdConfig;
import com.ironsource.C3040d4;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import io.bidmachine.iab.vast.tags.VastAttributes;
import io.bidmachine.iab.vast.tags.VastTagName;
import io.bidmachine.unified.UnifiedMediationParams;
import io.ktor.http.ContentDisposition;
import io.ktor.http.LinkHeader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.p8, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2811p8 {
    public static final /* synthetic */ int u = 0;

    /* renamed from: a, reason: collision with root package name */
    public final JSONObject f2669a;
    public final byte b;
    public final boolean c;
    public final JSONObject d;
    public final C2681h8 e;
    public final JSONArray f;
    public C2811p8 g;
    public final HashMap h;
    public final HashMap i;
    public final HashMap j;
    public final HashMap k;
    public Ue l;
    public final AdConfig m;
    public final InterfaceC2971z5 n;
    public final int o;
    public final C2794o8 p;
    public boolean q;
    public F9 r;
    public final boolean s;
    public final Map t;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C2811p8(int i, JSONObject pubContent, AdConfig adConfig, HashMap hashMap, Ue ue, InterfaceC2971z5 interfaceC2971z5) {
        this(i, pubContent, null, false, adConfig, hashMap, ue, interfaceC2971z5);
        Intrinsics.checkNotNullParameter(pubContent, "pubContent");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
    }

    public static int a(int i) {
        return (int) (U3.b() * i);
    }

    public final C2681h8 b(int i) {
        C2681h8 c2681h8 = this.e;
        if (c2681h8 != null) {
            int i2 = 0;
            while (i2 < c2681h8.B) {
                try {
                    int i3 = i2 + 1;
                    C2613d8 c2613d8 = (C2613d8) c2681h8.A.get(i2);
                    Intrinsics.checkNotNull(c2613d8);
                    if (StringsKt.equals(c2613d8.b, "card_scrollable", true)) {
                        C2681h8 c2681h82 = c2613d8 instanceof C2681h8 ? (C2681h8) c2613d8 : null;
                        if (i < (c2681h82 != null ? c2681h82.B : 0)) {
                            C2613d8 c2613d82 = (c2681h82 == null || i < 0 || i >= c2681h82.B) ? null : (C2613d8) c2681h82.A.get(i);
                            if (c2613d82 instanceof C2681h8) {
                                return (C2681h8) c2613d82;
                            }
                        }
                        return null;
                    }
                    i2 = i3;
                } catch (IndexOutOfBoundsException e) {
                    throw new NoSuchElementException(e.getMessage());
                }
            }
        }
        return null;
    }

    public final ArrayList c() {
        HashMap hashMap = this.i;
        return new ArrayList(hashMap != null ? hashMap.keySet() : null);
    }

    public final int d() {
        C2681h8 c2681h8 = this.e;
        if (c2681h8 != null) {
            Iterator it = c2681h8.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C2613d8 c2613d8 = (C2613d8) it.next();
                if (StringsKt.equals(c2613d8.b, "card_scrollable", true)) {
                    if (c2613d8 instanceof C2681h8) {
                        return ((C2681h8) c2613d8).B;
                    }
                }
            }
        }
        return 0;
    }

    public final JSONObject e() {
        try {
            JSONArray jSONArray = this.f;
            if (jSONArray != null) {
                return jSONArray.getJSONObject(0);
            }
            return null;
        } catch (JSONException e) {
            InterfaceC2971z5 interfaceC2971z5 = this.n;
            if (interfaceC2971z5 == null) {
                return null;
            }
            ((A5) interfaceC2971z5).b("p8", E0.a(e, H6.a("p8", "TAG", "Exception while getting Pages - ")));
            return null;
        }
    }

    public final boolean f() {
        C2681h8 c2681h8;
        C2681h8 c2681h82 = this.e;
        if (c2681h82 == null) {
            InterfaceC2971z5 interfaceC2971z5 = this.n;
            if (interfaceC2971z5 == null) {
                return false;
            }
            Intrinsics.checkNotNullExpressionValue("p8", "TAG");
            ((A5) interfaceC2971z5).b("p8", "Invalid Data Model: No Root Container");
            return false;
        }
        if (c2681h82 != null) {
            Iterator it = c2681h82.iterator();
            while (true) {
                C2665g8 c2665g8 = (C2665g8) it;
                if (!c2665g8.hasNext()) {
                    break;
                }
                C2613d8 c2613d8 = (C2613d8) c2665g8.next();
                if (StringsKt.equals(c2613d8.b, "card_scrollable", true)) {
                    if (c2613d8 instanceof C2681h8) {
                        c2681h8 = (C2681h8) c2613d8;
                    }
                }
            }
        }
        c2681h8 = null;
        if (c2681h8 == null) {
            InterfaceC2971z5 interfaceC2971z52 = this.n;
            if (interfaceC2971z52 != null) {
                Intrinsics.checkNotNullExpressionValue("p8", "TAG");
                ((A5) interfaceC2971z52).b("p8", "No Card Scrollable in the data model");
            }
            return g();
        }
        if (d() > 0) {
            return g();
        }
        InterfaceC2971z5 interfaceC2971z53 = this.n;
        if (interfaceC2971z53 == null) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue("p8", "TAG");
        ((A5) interfaceC2971z53).b("p8", "Invalid Data Model: No Cards in Card Scrollable");
        return false;
    }

    public final boolean g() {
        InterfaceC2971z5 interfaceC2971z5;
        List<C2613d8> n = n("VIDEO");
        if (n != null && !n.isEmpty()) {
            for (C2613d8 c2613d8 : n) {
                if (c2613d8.f2546a.length() == 0 && (interfaceC2971z5 = this.n) != null) {
                    Intrinsics.checkNotNullExpressionValue("p8", "TAG");
                    ((A5) interfaceC2971z5).b("p8", "Video asset has invalid ID! CTA link resolution may not work");
                }
                C2597c9 c2597c9 = c2613d8 instanceof C2597c9 ? (C2597c9) c2613d8 : null;
                if ((c2597c9 != null ? c2597c9.d() : null) == null) {
                    InterfaceC2971z5 interfaceC2971z52 = this.n;
                    if (interfaceC2971z52 != null) {
                        Intrinsics.checkNotNullExpressionValue("p8", "TAG");
                        ((A5) interfaceC2971z52).b("p8", "No Vast XML. Discarding DataModel");
                    }
                    return false;
                }
                Ve d = c2597c9.d();
                ArrayList arrayList = d != null ? ((Ue) d).e : null;
                if (arrayList == null || arrayList.isEmpty()) {
                    InterfaceC2971z5 interfaceC2971z53 = this.n;
                    if (interfaceC2971z53 != null) {
                        Intrinsics.checkNotNullExpressionValue("p8", "TAG");
                        ((A5) interfaceC2971z53).b("p8", "No Media files. Discarding DataModel");
                    }
                    return false;
                }
                Ve d2 = c2597c9.d();
                String b = d2 != null ? ((Ue) d2).b() : null;
                if (b == null || b.length() == 0) {
                    InterfaceC2971z5 interfaceC2971z54 = this.n;
                    if (interfaceC2971z54 != null) {
                        Intrinsics.checkNotNullExpressionValue("p8", "TAG");
                        ((A5) interfaceC2971z54).b("p8", "Invalid Media URL.Discarding the model");
                    }
                    c2597c9.a("error", MapsKt.hashMapOf(TuplesKt.to("[ERRORCODE]", "403")), (L7) null, this.n);
                    return false;
                }
            }
        }
        return true;
    }

    public final void h() {
        C2794o8 c2794o8;
        C2794o8 c2794o82;
        try {
            JSONObject jSONObject = this.f2669a;
            if (jSONObject == null) {
                C2794o8 c2794o83 = this.p;
                if (c2794o83 == null) {
                    return;
                }
                c2794o83.c = new C2613d8((String) null, (String) null, (String) null, (C2630e8) null, 31);
                return;
            }
            if (!jSONObject.isNull("passThroughJson") && (c2794o82 = this.p) != null) {
                c2794o82.f2660a = jSONObject.getJSONObject("passThroughJson");
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("adContent");
            if (optJSONObject != null && (c2794o8 = this.p) != null) {
                C2778n8 c2778n8 = c2794o8.b;
                c2778n8.f2650a = optJSONObject.optString("title", null);
                c2778n8.b = optJSONObject.optString("description", null);
                c2778n8.d = optJSONObject.optString("ctaText", null);
                c2778n8.c = optJSONObject.optString(UnifiedMediationParams.KEY_ICON_URL, null);
                c2778n8.e = optJSONObject.optLong("rating", 0L);
                c2778n8.f = optJSONObject.optString("landingPageUrl", null);
                c2778n8.g = optJSONObject.optBoolean("isApp");
            }
            C2613d8 c2613d8 = new C2613d8((String) null, (String) null, (String) null, (C2630e8) null, 31);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("onClick");
            if (optJSONObject2 != null) {
                try {
                    a(c2613d8, optJSONObject2);
                } catch (JSONException unused) {
                    InterfaceC2971z5 interfaceC2971z5 = this.n;
                    if (interfaceC2971z5 != null) {
                        Intrinsics.checkNotNullExpressionValue("p8", "TAG");
                        ((A5) interfaceC2971z5).b("p8", "JSONException in parsing click params for publisher CTA");
                    }
                }
                if (!optJSONObject2.isNull("openMode")) {
                    String string = optJSONObject2.getString("openMode");
                    Intrinsics.checkNotNull(string);
                    String b = b(string);
                    Intrinsics.checkNotNullParameter(b, "<set-?>");
                    c2613d8.g = b;
                    String optString = optJSONObject2.optString("fallbackUrl");
                    Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
                    c2613d8.a(optString);
                }
                c2613d8.i = optJSONObject2.optBoolean("supportLockScreen", false);
            }
            ArrayList trackers = j(jSONObject);
            if (trackers != null) {
                Intrinsics.checkNotNullParameter(trackers, "trackers");
                c2613d8.s.addAll(trackers);
            }
            C2794o8 c2794o84 = this.p;
            if (c2794o84 == null) {
                return;
            }
            c2794o84.c = c2613d8;
        } catch (JSONException unused2) {
            InterfaceC2971z5 interfaceC2971z52 = this.n;
            if (interfaceC2971z52 != null) {
                Intrinsics.checkNotNullExpressionValue("p8", "TAG");
                ((A5) interfaceC2971z52).b("p8", "Exception in getting publisher values from JSON");
            }
        }
    }

    public final JSONObject i(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.isNull("assetStyle") ? null : jSONObject.getJSONObject("assetStyle");
            if (jSONObject2 != null) {
                return jSONObject2;
            }
            if (jSONObject.isNull("assetStyleRef")) {
                return new JSONObject();
            }
            String string = jSONObject.getString("assetStyleRef");
            JSONObject jSONObject3 = this.d;
            JSONObject optJSONObject = jSONObject3 != null ? jSONObject3.optJSONObject(string) : null;
            return optJSONObject == null ? new JSONObject() : optJSONObject;
        } catch (JSONException e) {
            InterfaceC2971z5 interfaceC2971z5 = this.n;
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).b("p8", E0.a(e, H6.a("p8", "TAG", "Exception while getting assetStyle - ")));
            }
            return new JSONObject();
        }
    }

    public final ArrayList j(JSONObject jSONObject) {
        if (jSONObject.isNull(Constants.ADJUST_PREINSTALL_CONTENT_URI_PATH)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(Constants.ADJUST_PREINSTALL_CONTENT_URI_PATH);
            Intrinsics.checkNotNull(jSONArray);
            if (!B2.a(jSONArray)) {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    if (!jSONObject2.isNull("trackerType")) {
                        String string = jSONObject2.getString("trackerType");
                        Intrinsics.checkNotNull(string);
                        if (Intrinsics.areEqual("url_ping", k(string))) {
                            int optInt = jSONObject2.optInt("eventId", 0);
                            if (!jSONObject2.isNull("uiEvent")) {
                                String string2 = jSONObject2.getString("uiEvent");
                                Intrinsics.checkNotNull(string2);
                                String g = g(string2);
                                if (!Intrinsics.areEqual("unknown", g)) {
                                    if (Intrinsics.areEqual("OMID_VIEWABILITY", g)) {
                                        Intrinsics.checkNotNull(jSONObject2);
                                        arrayList.addAll(o(jSONObject2));
                                    } else {
                                        Intrinsics.checkNotNull(jSONObject2);
                                        U8 a2 = a(optInt, g, jSONObject2);
                                        if (a2 != null) {
                                            arrayList.add(a2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (JSONException e) {
            InterfaceC2971z5 interfaceC2971z5 = this.n;
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).b("p8", E0.a(e, H6.a("p8", "TAG", "Exception while getting assetTrackers - ")));
            }
        }
        return arrayList;
    }

    public final String k(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("assetType");
            Intrinsics.checkNotNull(string);
            return string;
        } catch (JSONException e) {
            InterfaceC2971z5 interfaceC2971z5 = this.n;
            if (interfaceC2971z5 == null) {
                return "";
            }
            ((A5) interfaceC2971z5).b("p8", E0.a(e, H6.a("p8", "TAG", "Exception while getting assetType - ")));
            return "";
        }
    }

    public final String l(JSONObject jSONObject) {
        try {
            if (!StringsKt.equals(k(jSONObject), "ICON", true) && !StringsKt.equals(k(jSONObject), "IMAGE", true) && !StringsKt.equals(k(jSONObject), "GIF", true)) {
                return "";
            }
            String string = jSONObject.getJSONArray("assetValue").getString(0);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            if (string.length() <= 0) {
                return "";
            }
            String string2 = jSONObject.getJSONArray("assetValue").getString(0);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        } catch (JSONException e) {
            InterfaceC2971z5 interfaceC2971z5 = this.n;
            if (interfaceC2971z5 == null) {
                return "";
            }
            ((A5) interfaceC2971z5).b("p8", E0.a(e, H6.a("p8", "TAG", "Exception while getting assetUrl - ")));
            return "";
        }
    }

    public final C2613d8 m(String str) {
        HashMap hashMap;
        C2613d8 c2613d8;
        if (str != null && str.length() != 0) {
            HashMap hashMap2 = this.j;
            if (hashMap2 != null && (c2613d8 = (C2613d8) hashMap2.get(str)) != null) {
                return c2613d8;
            }
            C2811p8 c2811p8 = this.g;
            if (c2811p8 != null && (hashMap = c2811p8.j) != null) {
                return (C2613d8) hashMap.get(str);
            }
        }
        return null;
    }

    public final List n(String assetType) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(assetType, "assetType");
        HashMap hashMap = this.i;
        return (hashMap == null || (arrayList = (ArrayList) hashMap.get(assetType)) == null) ? CollectionsKt.emptyList() : arrayList;
    }

    public final ArrayList o(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        try {
            HashMap hashMap = new HashMap();
            if (!jSONObject.isNull("macros")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("macros");
                Iterator<String> keys = jSONObject2.keys();
                Intrinsics.checkNotNull(keys);
                while (keys.hasNext()) {
                    String next = keys.next();
                    String string = jSONObject2.getString(next);
                    Intrinsics.checkNotNull(next);
                    Intrinsics.checkNotNull(string);
                    hashMap.put(next, string);
                }
            }
            JSONArray jSONArray = jSONObject.getJSONArray("adVerifications");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                if (!jSONObject3.isNull("url")) {
                    String optString = jSONObject3.optString(VastAttributes.VENDOR);
                    String optString2 = jSONObject3.optString("verificationParams");
                    String string2 = jSONObject3.getString("url");
                    Intrinsics.checkNotNull(optString);
                    Intrinsics.checkNotNull(string2);
                    arrayList.add(new C2683ha(optString, optString2, string2, hashMap));
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.add(new U8("", 0, "OMID_VIEWABILITY", hashMap));
                return arrayList;
            }
        } catch (Exception e) {
            InterfaceC2971z5 interfaceC2971z5 = this.n;
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).b("p8", rf.a(e, H6.a("p8", "TAG", "Failed to parse OMID tracker : ")));
            }
        }
        return arrayList;
    }

    public final String p(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("dataType");
            Intrinsics.checkNotNull(string);
            return string;
        } catch (JSONException e) {
            InterfaceC2971z5 interfaceC2971z5 = this.n;
            if (interfaceC2971z5 == null) {
                return "";
            }
            ((A5) interfaceC2971z5).b("p8", E0.a(e, H6.a("p8", "TAG", "Exception while getting webViewAssetValue - ")));
            return "";
        }
    }

    public final O8 q(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        long optLong = jSONObject.optLong("absolute");
        long optLong2 = jSONObject.optLong("percentage");
        String optString = jSONObject.optString("reference");
        Intrinsics.checkNotNull(optString);
        return new O8(optLong, optLong2, optString, this);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C2811p8(int i, JSONObject pubContent, C2811p8 c2811p8, boolean z, AdConfig adConfig, InterfaceC2971z5 interfaceC2971z5) {
        this(i, pubContent, c2811p8, z, adConfig, c2811p8.t, null, interfaceC2971z5);
        Intrinsics.checkNotNullParameter(pubContent, "pubContent");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
    }

    public final C2613d8 a(C2811p8 c2811p8, C2613d8 c2613d8) {
        Object obj = c2613d8.e;
        String str = obj instanceof String ? (String) obj : null;
        if (str == null || str.length() == 0) {
            return null;
        }
        String[] strArr = (String[]) new Regex("\\|").split(str, 0).toArray(new String[0]);
        C2613d8 m = c2811p8.m(strArr[0]);
        if (m == null) {
            C2811p8 c2811p82 = c2811p8.g;
            if (c2811p82 == null) {
                return null;
            }
            return a(c2811p82, c2613d8);
        }
        if (Intrinsics.areEqual(m, c2613d8)) {
            return null;
        }
        if (strArr.length == 1) {
            m.l = (byte) 1;
            return m;
        }
        m.l = AbstractC2762m8.a(strArr[1]);
        InterfaceC2971z5 interfaceC2971z5 = this.n;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("p8", H6.a("p8", "TAG", "Referenced asset ( ").append(m.b).append(" )").toString());
        }
        return m;
    }

    public final JSONObject c(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.isNull("display") ? new JSONObject() : jSONObject.getJSONObject("display");
            Intrinsics.checkNotNull(jSONObject2);
            return jSONObject2;
        } catch (JSONException e) {
            InterfaceC2971z5 interfaceC2971z5 = this.n;
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).b("p8", E0.a(e, H6.a("p8", "TAG", "Exception while getting assetDisplayOnProperties - ")));
            }
            return new JSONObject();
        }
    }

    public final String n(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("valueType");
            Intrinsics.checkNotNull(string);
            return string;
        } catch (JSONException e) {
            InterfaceC2971z5 interfaceC2971z5 = this.n;
            if (interfaceC2971z5 == null) {
                return "";
            }
            ((A5) interfaceC2971z5).b("p8", E0.a(e, H6.a("p8", "TAG", "Exception while getting assetValueType - ")));
            return "";
        }
    }

    public C2811p8(int i, JSONObject pubContent, C2811p8 c2811p8, boolean z, AdConfig adConfig, Map map, Ue ue, InterfaceC2971z5 interfaceC2971z5) {
        byte h;
        HashMap hashMap;
        C2613d8 asset;
        C2613d8 c2613d8;
        Ve d;
        int i2;
        HashMap hashMap2;
        this.o = i;
        this.g = c2811p8;
        this.m = adConfig;
        this.f2669a = pubContent;
        this.b = (byte) 0;
        this.c = false;
        this.l = ue;
        this.j = new HashMap();
        HashMap hashMap3 = new HashMap();
        this.k = hashMap3;
        this.i = new HashMap();
        this.p = new C2794o8();
        this.s = z;
        this.t = map;
        this.n = interfaceC2971z5;
        try {
            this.d = pubContent.optJSONObject("styleRefs");
            if (pubContent.isNull("orientation")) {
                h = 0;
            } else {
                String string = pubContent.getString("orientation");
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                h = h(string);
            }
            this.b = h;
            this.q = pubContent.optBoolean("shouldAutoOpenLandingPage", true);
            this.c = pubContent.optBoolean("disableBackButton");
            JSONObject jSONObject = pubContent.getJSONObject("rootContainer");
            Intrinsics.checkNotNull(jSONObject);
            C2613d8 a2 = a(jSONObject, "CONTAINER", "/rootContainer");
            this.e = a2 instanceof C2681h8 ? (C2681h8) a2 : null;
            h();
            if (pubContent.has("rewards")) {
                this.h = new HashMap();
            }
            C2672h.Companion.getClass();
            Intrinsics.checkNotNullParameter(pubContent, "pubContent");
            if (pubContent.has("rewards")) {
                hashMap = new HashMap();
                JSONObject optJSONObject = pubContent.optJSONObject("rewards");
                if (optJSONObject != null) {
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String string2 = optJSONObject.getString(next);
                        Intrinsics.checkNotNull(next);
                        Intrinsics.checkNotNull(string2);
                        hashMap.put(next, string2);
                    }
                }
            } else {
                hashMap = null;
            }
            if (hashMap != null && (hashMap2 = this.h) != null) {
                hashMap2.putAll(hashMap);
            }
            a();
            b();
            for (Map.Entry entry : hashMap3.entrySet()) {
                HashMap hashMap4 = this.j;
                if (hashMap4 != null && (asset = (C2613d8) hashMap4.get(entry.getKey())) != null && 4 == asset.m && (asset.n != -1 || asset.o != -1)) {
                    HashMap hashMap5 = this.j;
                    if (hashMap5 != null && (c2613d8 = (C2613d8) hashMap5.get(entry.getValue())) != null && Intrinsics.areEqual("VIDEO", c2613d8.c)) {
                        C2597c9 c2597c9 = c2613d8 instanceof C2597c9 ? (C2597c9) c2613d8 : null;
                        if (c2597c9 != null && (d = c2597c9.d()) != null) {
                            Ue ue2 = d instanceof Ue ? (Ue) d : null;
                            if (ue2 != null) {
                                try {
                                    i2 = ue2.a();
                                } catch (ArrayIndexOutOfBoundsException unused) {
                                    InterfaceC2971z5 interfaceC2971z52 = this.n;
                                    if (interfaceC2971z52 != null) {
                                        Intrinsics.checkNotNullExpressionValue("p8", "TAG");
                                        ((A5) interfaceC2971z52).b("p8", "ArrayIndexOutOfBoundsException in getting media duration");
                                    }
                                    i2 = 0;
                                }
                                if (i2 == 0) {
                                    asset.n = 0;
                                } else {
                                    asset.n = a(asset.n, i2);
                                    asset.o = a(asset.o, i2);
                                }
                                Intrinsics.checkNotNullParameter(asset, "asset");
                                ((C2597c9) c2613d8).y.add(asset);
                            }
                        }
                    }
                }
            }
            JSONArray optJSONArray = pubContent.optJSONArray("pages");
            this.f = optJSONArray == null ? new JSONArray() : optJSONArray;
        } catch (JSONException e) {
            InterfaceC2971z5 interfaceC2971z53 = this.n;
            if (interfaceC2971z53 != null) {
                ((A5) interfaceC2971z53).b("p8", E0.a(e, H6.a("p8", "TAG", "Exception while getting pagesArray - ")));
            }
        }
    }

    public final JSONArray m(JSONObject jSONObject) {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("assetValue");
            Intrinsics.checkNotNullExpressionValue(jSONArray, "getJSONArray(...)");
            return jSONArray;
        } catch (JSONException e) {
            InterfaceC2971z5 interfaceC2971z5 = this.n;
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).b("p8", E0.a(e, H6.a("p8", "TAG", "Exception while getting assetValue - ")));
            }
            return new JSONArray();
        }
    }

    public final byte e(JSONObject jSONObject) {
        try {
            JSONObject c = c(jSONObject);
            if (c.isNull("type")) {
                return (byte) 2;
            }
            String string = c.getString("type");
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return f(string);
        } catch (JSONException e) {
            InterfaceC2971z5 interfaceC2971z5 = this.n;
            if (interfaceC2971z5 == null) {
                return (byte) 2;
            }
            ((A5) interfaceC2971z5).b("p8", E0.a(e, H6.a("p8", "TAG", "Exception while getting assetDisplay - ")));
            return (byte) 2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0154, code lost:
    
        r1 = ((com.inmobi.media.Ue) r7).i;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0158, code lost:
    
        if (r1 == null) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x015a, code lost:
    
        r1 = r1.size();
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x00f0, code lost:
    
        if (android.webkit.URLUtil.isValidUrl(r8) != false) goto L57;
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0133  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b() {
        String str;
        boolean areEqual;
        InterfaceC2971z5 interfaceC2971z5;
        for (C2613d8 c2613d8 : n("WEBVIEW")) {
            F9 f9 = c2613d8 instanceof F9 ? (F9) c2613d8 : null;
            if (f9 != null && !Intrinsics.areEqual("URL", f9.y) && !Intrinsics.areEqual("HTML", f9.y)) {
                C2613d8 a2 = a(this, c2613d8);
                if (a2 == null) {
                    InterfaceC2971z5 interfaceC2971z52 = this.n;
                    if (interfaceC2971z52 != null) {
                        ((A5) interfaceC2971z52).b("p8", H6.a("p8", "TAG", "Could not find referenced asset for asset (").append(c2613d8.b).append(')').toString());
                    }
                } else if (Intrinsics.areEqual(a2.c, c2613d8.c)) {
                    c2613d8.e = a2.e;
                } else if (Intrinsics.areEqual(a2.c, "VIDEO")) {
                    if (2 == a2.l) {
                        C2597c9 c2597c9 = a2 instanceof C2597c9 ? (C2597c9) a2 : null;
                        if (c2597c9 != null) {
                            Ve d = c2597c9.d();
                            Le companionAd = Je.a(c2597c9, c2613d8);
                            if (companionAd != null) {
                                if (Intrinsics.areEqual("REF_HTML", f9.y)) {
                                    ArrayList a3 = companionAd.a(2);
                                    if (!a3.isEmpty()) {
                                        str = ((Ke) a3.get(0)).b;
                                    } else {
                                        ArrayList a4 = companionAd.a(3);
                                        if (!a4.isEmpty()) {
                                            str = ((Ke) a4.get(0)).b;
                                            if (URLUtil.isValidUrl(str)) {
                                                f9.y = "REF_IFRAME";
                                            }
                                        }
                                    }
                                    areEqual = Intrinsics.areEqual("REF_IFRAME", f9.y);
                                    boolean areEqual2 = Intrinsics.areEqual("REF_HTML", f9.y);
                                    if ((areEqual || URLUtil.isValidUrl(str)) && companionAd != null && (!areEqual2 || str != null)) {
                                        if (d != null) {
                                            Intrinsics.checkNotNullParameter(companionAd, "companionAd");
                                            ((Ue) d).j = companionAd;
                                        }
                                        interfaceC2971z5 = this.n;
                                        if (interfaceC2971z5 != null) {
                                            ((A5) interfaceC2971z5).a("p8", I6.a("p8", "TAG", "Setting asset value: ", str));
                                        }
                                        c2613d8.e = str;
                                        ArrayList trackers = companionAd.a("creativeView");
                                        Intrinsics.checkNotNullParameter(trackers, "trackers");
                                        c2613d8.s.addAll(trackers);
                                    } else {
                                        int i = -1;
                                        if (i > 0) {
                                            c2597c9.v = 8;
                                            c2597c9.a("error", MapsKt.hashMapOf(TuplesKt.to("[ERRORCODE]", "601")), (L7) null, this.n);
                                            InterfaceC2971z5 interfaceC2971z53 = this.n;
                                            if (interfaceC2971z53 != null) {
                                                Intrinsics.checkNotNullExpressionValue("p8", "TAG");
                                                ((A5) interfaceC2971z53).b("p8", "Unable to find the best-fit companion ad! Returning ...");
                                            }
                                        }
                                        f9.y = "UNKNOWN";
                                    }
                                } else if (Intrinsics.areEqual("REF_IFRAME", f9.y)) {
                                    ArrayList a5 = companionAd.a(3);
                                    if (!a5.isEmpty()) {
                                        str = ((Ke) a5.get(0)).b;
                                    } else {
                                        ArrayList a6 = companionAd.a(2);
                                        if (!a6.isEmpty()) {
                                            f9.y = "REF_HTML";
                                            str = ((Ke) a6.get(0)).b;
                                            areEqual = Intrinsics.areEqual("REF_IFRAME", f9.y);
                                            boolean areEqual22 = Intrinsics.areEqual("REF_HTML", f9.y);
                                            if (areEqual) {
                                            }
                                            if (d != null) {
                                            }
                                            interfaceC2971z5 = this.n;
                                            if (interfaceC2971z5 != null) {
                                            }
                                            c2613d8.e = str;
                                            ArrayList trackers2 = companionAd.a("creativeView");
                                            Intrinsics.checkNotNullParameter(trackers2, "trackers");
                                            c2613d8.s.addAll(trackers2);
                                        }
                                    }
                                }
                            }
                            str = null;
                            areEqual = Intrinsics.areEqual("REF_IFRAME", f9.y);
                            boolean areEqual222 = Intrinsics.areEqual("REF_HTML", f9.y);
                            if (areEqual) {
                            }
                            if (d != null) {
                            }
                            interfaceC2971z5 = this.n;
                            if (interfaceC2971z5 != null) {
                            }
                            c2613d8.e = str;
                            ArrayList trackers22 = companionAd.a("creativeView");
                            Intrinsics.checkNotNullParameter(trackers22, "trackers");
                            c2613d8.s.addAll(trackers22);
                        }
                    } else {
                        InterfaceC2971z5 interfaceC2971z54 = this.n;
                        if (interfaceC2971z54 != null) {
                            Intrinsics.checkNotNullExpressionValue("p8", "TAG");
                            ((A5) interfaceC2971z54).b("p8", "Unknown creative type reference for webView asset! Returning ...");
                        }
                    }
                }
            }
        }
    }

    public final String f(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("assetId");
            Intrinsics.checkNotNull(string);
            return string;
        } catch (JSONException e) {
            InterfaceC2971z5 interfaceC2971z5 = this.n;
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).b("p8", E0.a(e, H6.a("p8", "TAG", "Exception while getting assetId - ")));
            }
            return String.valueOf(jSONObject.hashCode());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0078 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String j(String str) {
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = str.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        int length = lowerCase.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) lowerCase.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String a2 = I7.a(length, 1, lowerCase, i);
        switch (a2.hashCode()) {
            case -1178781136:
                return !a2.equals("italic") ? "none" : "italic";
            case -1026963764:
                if (a2.equals("underline")) {
                    return "underline";
                }
                break;
            case -891985998:
                if (a2.equals("strike")) {
                    return "strike";
                }
                break;
            case 3029637:
                if (a2.equals("bold")) {
                    return "bold";
                }
                break;
            case 3387192:
                a2.equals("none");
        }
    }

    public final Point h(JSONObject jSONObject) {
        JSONObject i;
        Point point = new Point();
        try {
            i = i(jSONObject);
        } catch (JSONException e) {
            InterfaceC2971z5 interfaceC2971z5 = this.n;
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).b("p8", E0.a(e, H6.a("p8", "TAG", "Exception while getting assetPosition - ")));
            }
        }
        if (i.isNull("geometry")) {
            return point;
        }
        JSONArray jSONArray = i.getJSONArray("geometry");
        point.x = a(jSONArray.getInt(0));
        point.y = a(jSONArray.getInt(1));
        return point;
    }

    public final String g(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("assetName");
            Intrinsics.checkNotNull(string);
            return string;
        } catch (JSONException e) {
            InterfaceC2971z5 interfaceC2971z5 = this.n;
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).b("p8", E0.a(e, H6.a("p8", "TAG", "Exception while getting assetName - ")));
                return "";
            }
            return "";
        }
    }

    public static byte l(String str) {
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String a2 = I7.a(length, 1, str, i);
        return (!Intrinsics.areEqual(a2, "absolute") && Intrinsics.areEqual(a2, "reference")) ? (byte) 1 : (byte) 0;
    }

    public static byte f(String str) {
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String a2 = I7.a(length, 1, str, i);
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = a2.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        int hashCode = lowerCase.hashCode();
        if (hashCode != -921832806) {
            if (hashCode == -284840886) {
                lowerCase.equals("unknown");
            } else if (hashCode == 1728122231 && lowerCase.equals("absolute")) {
                return (byte) 3;
            }
        } else if (lowerCase.equals("percentage")) {
            return (byte) 4;
        }
        return (byte) 1;
    }

    public static String k(String str) {
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String upperCase = str.toUpperCase(US);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        int length = upperCase.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) upperCase.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String a2 = I7.a(length, 1, upperCase, i);
        int hashCode = a2.hashCode();
        if (hashCode == -1430070305) {
            if (!a2.equals("HTML_SCRIPT")) {
                return "unknown";
            }
            return "html_script";
        }
        if (hashCode == -158113182) {
            if (a2.equals("URL_PING")) {
                return "url_ping";
            }
            return "unknown";
        }
        if (hashCode == 1110926088 && a2.equals("URL_WEBVIEW_PING")) {
            return "webview_ping";
        }
        return "unknown";
    }

    public static byte i(String str) {
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String a2 = I7.a(length, 1, str, i);
        return (!Intrinsics.areEqual(a2, "paged") && Intrinsics.areEqual(a2, "free")) ? (byte) 1 : (byte) 0;
    }

    public static String e(String str) {
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = str.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        int length = lowerCase.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) lowerCase.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String a2 = I7.a(length, 1, lowerCase, i);
        if (Intrinsics.areEqual(a2, "none") || !Intrinsics.areEqual(a2, "line")) {
            return "none";
        }
        return "line";
    }

    public static String c(String str) {
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = str.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        int length = lowerCase.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) lowerCase.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String a2 = I7.a(length, 1, lowerCase, i);
        switch (a2.hashCode()) {
            case -938102371:
                if (!a2.equals("rating")) {
                    return "CONTAINER";
                }
                return "RATING";
            case -410956671:
                a2.equals("container");
                return "CONTAINER";
            case 98832:
                if (a2.equals("cta")) {
                    return VastTagName.CTA;
                }
                return "CONTAINER";
            case 102340:
                if (a2.equals("gif")) {
                    return "GIF";
                }
                return "CONTAINER";
            case 3226745:
                if (a2.equals("icon")) {
                    return "ICON";
                }
                return "CONTAINER";
            case 3556653:
                if (a2.equals("text")) {
                    return "TEXT";
                }
                return "CONTAINER";
            case 100313435:
                if (a2.equals("image")) {
                    return "IMAGE";
                }
                return "CONTAINER";
            case 110364485:
                if (a2.equals("timer")) {
                    return "TIMER";
                }
                return "CONTAINER";
            case 112202875:
                if (a2.equals("video")) {
                    return "VIDEO";
                }
                return "CONTAINER";
            case 1224424441:
                if (a2.equals(C3040d4.h.K)) {
                    return "WEBVIEW";
                }
                return "CONTAINER";
            default:
                return "CONTAINER";
        }
    }

    public final void a() {
        ArrayList arrayList;
        for (C2613d8 c2613d8 : n("IMAGE")) {
            Object obj = c2613d8.e;
            if (!URLUtil.isValidUrl(obj instanceof String ? (String) obj : null)) {
                C2613d8 a2 = a(this, c2613d8);
                if (a2 == null) {
                    InterfaceC2971z5 interfaceC2971z5 = this.n;
                    if (interfaceC2971z5 != null) {
                        ((A5) interfaceC2971z5).b("p8", H6.a("p8", "TAG", "Could not find referenced asset for asset (").append(c2613d8.b).append(')').toString());
                    }
                } else if (Intrinsics.areEqual(a2.c, c2613d8.c)) {
                    c2613d8.e = a2.e;
                } else if (Intrinsics.areEqual(a2.c, "VIDEO") && a2.l == 1) {
                    InterfaceC2971z5 interfaceC2971z52 = this.n;
                    if (interfaceC2971z52 != null) {
                        Intrinsics.checkNotNullExpressionValue("p8", "TAG");
                        ((A5) interfaceC2971z52).b("p8", "Image asset cannot reference a linear creative in a video element!");
                    }
                } else if (Intrinsics.areEqual(a2.c, "VIDEO") && a2.l == 2) {
                    C2597c9 c2597c9 = a2 instanceof C2597c9 ? (C2597c9) a2 : null;
                    if (c2597c9 != null) {
                        Ve d = c2597c9.d();
                        Le companionAd = Je.a(c2597c9, c2613d8);
                        ArrayList<Ke> a3 = companionAd != null ? companionAd.a(1) : null;
                        if (a3 != null) {
                            for (Ke ke : a3) {
                                if (URLUtil.isValidUrl(ke.b)) {
                                    break;
                                }
                            }
                        }
                        ke = null;
                        if (companionAd != null && ke != null) {
                            if (d != null) {
                                Intrinsics.checkNotNullParameter(companionAd, "companionAd");
                                ((Ue) d).j = companionAd;
                            }
                            InterfaceC2971z5 interfaceC2971z53 = this.n;
                            if (interfaceC2971z53 != null) {
                                ((A5) interfaceC2971z53).a("p8", H6.a("p8", "TAG", "Setting image asset value: ").append(ke.b).toString());
                            }
                            c2613d8.e = ke.b;
                            ArrayList trackers = companionAd.a("creativeView");
                            Intrinsics.checkNotNullParameter(trackers, "trackers");
                            c2613d8.s.addAll(trackers);
                            ArrayList trackers2 = c2597c9.s;
                            Intrinsics.checkNotNullParameter(trackers2, "trackers");
                            Intrinsics.checkNotNullParameter("error", "eventType");
                            Iterator it = trackers2.iterator();
                            while (it.hasNext()) {
                                U8 u8 = (U8) it.next();
                                if (Intrinsics.areEqual("error", u8.b)) {
                                    c2613d8.s.add(u8);
                                }
                            }
                        } else if (((d == null || (arrayList = ((Ue) d).i) == null) ? -1 : arrayList.size()) > 0) {
                            c2597c9.v = 8;
                            c2597c9.a("error", MapsKt.hashMapOf(TuplesKt.to("[ERRORCODE]", "601")), (L7) null, this.n);
                            InterfaceC2971z5 interfaceC2971z54 = this.n;
                            if (interfaceC2971z54 != null) {
                                Intrinsics.checkNotNullExpressionValue("p8", "TAG");
                                ((A5) interfaceC2971z54).b("p8", "Unable to find the best-fit companion ad! Returning ...");
                            }
                        }
                    }
                }
            }
        }
    }

    public final String d(JSONObject jSONObject) {
        try {
            JSONObject c = c(jSONObject);
            String string = c.isNull("reference") ? "" : c.getString("reference");
            Intrinsics.checkNotNull(string);
            return string;
        } catch (JSONException e) {
            InterfaceC2971z5 interfaceC2971z5 = this.n;
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).b("p8", E0.a(e, H6.a("p8", "TAG", "Exception while getting assetDisplayOnReference - ")));
            }
            return "";
        }
    }

    public static byte h(String str) {
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = str.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        int length = lowerCase.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) lowerCase.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String a2 = I7.a(length, 1, lowerCase, i);
        int hashCode = a2.hashCode();
        if (hashCode == -1626174665) {
            a2.equals(BuildConfig.VERSION_NAME);
        } else if (hashCode != 729267099) {
            if (hashCode == 1430647483 && a2.equals(C3040d4.h.C)) {
                return (byte) 2;
            }
        } else if (a2.equals(C3040d4.h.D)) {
            return (byte) 1;
        }
        return (byte) 0;
    }

    public final void b(C2613d8 c2613d8, JSONObject jSONObject) {
        String str;
        String str2 = "";
        boolean z = false;
        if (jSONObject.isNull("assetOnclick")) {
            str = "";
        } else {
            JSONObject optJSONObject = jSONObject.optJSONObject("assetOnclick");
            if (optJSONObject != null && !optJSONObject.isNull("itemUrl")) {
                str = jSONObject.getJSONObject("assetOnclick").getString("itemUrl");
                Intrinsics.checkNotNullExpressionValue(str, "getString(...)");
                z = true;
            } else {
                InterfaceC2971z5 interfaceC2971z5 = this.n;
                if (interfaceC2971z5 != null) {
                    Intrinsics.checkNotNullExpressionValue("p8", "TAG");
                    ((A5) interfaceC2971z5).b("p8", "Missing itemUrl on asset " + jSONObject);
                }
                str = "";
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("assetOnclick");
            if (optJSONObject2 == null || !optJSONObject2.isNull("action")) {
                str2 = jSONObject.getJSONObject("assetOnclick").getString("action");
                Intrinsics.checkNotNullExpressionValue(str2, "getString(...)");
                z = true;
            }
        }
        c2613d8.b(str);
        Intrinsics.checkNotNullParameter(str2, "<set-?>");
        c2613d8.h = str2;
        c2613d8.f = z;
    }

    public final M8 c(Point point, Point point2, Point point3, Point point4, JSONObject jSONObject) {
        JSONObject optJSONObject;
        String str;
        String str2;
        String a2;
        String str3;
        String str4;
        String str5;
        String a3;
        int i;
        byte b;
        String str6 = "straight";
        String str7 = "#ff000000";
        if (jSONObject.isNull(OutlinedTextFieldKt.BorderId) || (optJSONObject = jSONObject.optJSONObject(OutlinedTextFieldKt.BorderId)) == null || optJSONObject.isNull("style")) {
            str5 = "straight";
            str3 = "#ff000000";
            str4 = "none";
        } else {
            String string = optJSONObject.getString("style");
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String e = e(string);
            if (!optJSONObject.isNull("corner")) {
                String string2 = optJSONObject.getString("corner");
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                str6 = d(string2);
            }
            if (optJSONObject.isNull("color")) {
                str = e;
                str2 = str6;
                a2 = "#ff000000";
            } else {
                String string3 = optJSONObject.getString("color");
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                int length = string3.length() - 1;
                int i2 = 0;
                boolean z = false;
                while (true) {
                    str = e;
                    if (i2 > length) {
                        str2 = str6;
                        break;
                    }
                    str2 = str6;
                    boolean z2 = Intrinsics.compare((int) string3.charAt(!z ? i2 : length), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        }
                        length--;
                    } else if (z2) {
                        i2++;
                    } else {
                        z = true;
                    }
                    e = str;
                    str6 = str2;
                }
                a2 = I7.a(length, 1, string3, i2);
            }
            str3 = a2;
            str4 = str;
            str5 = str2;
        }
        if (jSONObject.isNull("backgroundColor")) {
            a3 = "#00000000";
        } else {
            String string4 = jSONObject.getString("backgroundColor");
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            int length2 = string4.length() - 1;
            boolean z3 = false;
            int i3 = 0;
            while (i3 <= length2) {
                boolean z4 = z3;
                boolean z5 = Intrinsics.compare((int) string4.charAt(!z3 ? i3 : length2), 32) <= 0;
                if (z4) {
                    if (!z5) {
                        break;
                    }
                    length2--;
                } else if (z5) {
                    i3++;
                } else {
                    z3 = true;
                }
                z3 = z4;
            }
            a3 = I7.a(length2, 1, string4, i3);
        }
        String str8 = a3;
        JSONObject jSONObject2 = jSONObject.getJSONObject("text");
        try {
            String string5 = jSONObject2.getString(ContentDisposition.Parameters.Size);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            int parseDouble = (int) Double.parseDouble(string5);
            if (!jSONObject2.isNull("length")) {
                String string6 = jSONObject2.getString("length");
                Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                Integer.parseInt(string6);
            }
            if (jSONObject2.isNull("color")) {
                i = parseDouble;
            } else {
                String string7 = jSONObject2.getString("color");
                Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
                int length3 = string7.length() - 1;
                boolean z6 = false;
                int i4 = 0;
                while (true) {
                    if (i4 > length3) {
                        i = parseDouble;
                        break;
                    }
                    i = parseDouble;
                    boolean z7 = Intrinsics.compare((int) string7.charAt(!z6 ? i4 : length3), 32) <= 0;
                    if (z6) {
                        if (!z7) {
                            break;
                        }
                        length3--;
                    } else if (z7) {
                        i4++;
                    } else {
                        parseDouble = i;
                        z6 = true;
                    }
                    parseDouble = i;
                }
                str7 = I7.a(length3, 1, string7, i4);
            }
            String str9 = str7;
            ArrayList arrayList = new ArrayList();
            if (jSONObject2.isNull("style")) {
                arrayList.add("none");
            } else {
                int length4 = jSONObject2.getJSONArray("style").length();
                if (length4 == 0) {
                    arrayList.add("none");
                } else {
                    for (int i5 = 0; i5 < length4; i5++) {
                        String string8 = jSONObject2.getJSONArray("style").getString(i5);
                        Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
                        arrayList.add(j(string8));
                    }
                }
            }
            if (!jSONObject2.isNull("align")) {
                String string9 = jSONObject2.getString("align");
                Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
                int length5 = string9.length() - 1;
                boolean z8 = false;
                int i6 = 0;
                while (i6 <= length5) {
                    boolean z9 = Intrinsics.compare((int) string9.charAt(!z8 ? i6 : length5), 32) <= 0;
                    if (z8) {
                        if (!z9) {
                            break;
                        }
                        length5--;
                    } else if (z9) {
                        i6++;
                    } else {
                        z8 = true;
                    }
                }
                String a4 = I7.a(length5, 1, string9, i6);
                int hashCode = a4.hashCode();
                if (hashCode != -1364013605) {
                    if (hashCode == 3317767) {
                        a4.equals("left");
                    } else if (hashCode == 108511772 && a4.equals("right")) {
                        b = 1;
                    }
                } else if (a4.equals("centre")) {
                    b = 2;
                }
                return new M8(point.x, point.y, point2.x, point2.y, point3.x, point3.y, point4.x, point4.y, str4, str5, str3, str8, i, b, str9, arrayList, new P8(q(jSONObject.optJSONObject("startOffset")), q(jSONObject.optJSONObject("timerDuration"))));
            }
            b = 0;
            return new M8(point.x, point.y, point2.x, point2.y, point3.x, point3.y, point4.x, point4.y, str4, str5, str3, str8, i, b, str9, arrayList, new P8(q(jSONObject.optJSONObject("startOffset")), q(jSONObject.optJSONObject("timerDuration"))));
        } catch (NumberFormatException e2) {
            InterfaceC2971z5 interfaceC2971z5 = this.n;
            if (interfaceC2971z5 != null) {
                Intrinsics.checkNotNullExpressionValue("p8", "TAG");
                ((A5) interfaceC2971z5).b("p8", "Failure in building text asset! Text size should be an integer");
            }
            JSONException jSONException = new JSONException(e2.getMessage());
            S5 s5 = S5.f2425a;
            C2640f2 event = new C2640f2(e2);
            Intrinsics.checkNotNullParameter(event, "event");
            S5.d.a(event);
            throw jSONException;
        }
    }

    public final Point b(JSONObject jSONObject, Point point) {
        JSONObject i;
        try {
            i = i(jSONObject);
        } catch (JSONException unused) {
        }
        if (i.isNull("finalGeometry")) {
            return point;
        }
        JSONArray jSONArray = i.getJSONArray("finalGeometry");
        Point point2 = new Point();
        point2.x = a(jSONArray.getInt(0));
        point2.y = a(jSONArray.getInt(1));
        return point2;
    }

    public final Point b(JSONObject jSONObject) {
        JSONObject i;
        Point point = new Point();
        try {
            i = i(jSONObject);
        } catch (JSONException e) {
            InterfaceC2971z5 interfaceC2971z5 = this.n;
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).b("p8", E0.a(e, H6.a("p8", "TAG", "Exception while getting assetDimensions - ")));
            }
        }
        if (i.isNull("geometry")) {
            return point;
        }
        JSONArray jSONArray = i.getJSONArray("geometry");
        point.x = a(jSONArray.getInt(2));
        point.y = a(jSONArray.getInt(3));
        return point;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x011d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String g(String str) {
        int hashCode;
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String upperCase = str.toUpperCase(US);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        int length = upperCase.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) upperCase.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String a2 = I7.a(length, 1, upperCase, i);
        switch (a2.hashCode()) {
            case -1881262698:
                if (a2.equals("RENDER")) {
                    return "Impression";
                }
                break;
            case -825499301:
                if (a2.equals("FALLBACK_URL_CLICK")) {
                    return "TRACKER_EVENT_TYPE_FALLBACK_URL";
                }
                break;
            case 2342118:
                if (a2.equals("LOAD")) {
                    return "load";
                }
                break;
            case 2634405:
                if (a2.equals("VIEW")) {
                    return "page_view";
                }
                break;
            case 64212328:
                if (a2.equals("CLICK")) {
                    return "click";
                }
                break;
            case 368426751:
                if (a2.equals("OMID_VIEWABILITY")) {
                    return "OMID_VIEWABILITY";
                }
                break;
            case 1963885793:
                if (a2.equals("VIDEO_VIEWABILITY")) {
                    return "VideoImpression";
                }
                break;
            case 2008409463:
                if (a2.equals("CLIENT_FILL")) {
                    return "client_fill";
                }
                break;
        }
        Locale US2 = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US2, "US");
        String upperCase2 = str.toUpperCase(US2);
        Intrinsics.checkNotNullExpressionValue(upperCase2, "this as java.lang.String).toUpperCase(locale)");
        int length2 = upperCase2.length() - 1;
        int i2 = 0;
        boolean z3 = false;
        while (i2 <= length2) {
            boolean z4 = Intrinsics.compare((int) upperCase2.charAt(!z3 ? i2 : length2), 32) <= 0;
            if (z3) {
                if (!z4) {
                    String a3 = I7.a(length2, 1, upperCase2, i2);
                    hashCode = a3.hashCode();
                    if (hashCode != -1836567951) {
                        if (!a3.equals("DOWNLOADER_DOWNLOADED")) {
                            return "unknown";
                        }
                        return "TRACKER_EVENT_TYPE_DOWNLOADER_DOWNLOADED";
                    }
                    if (hashCode == -1099027408) {
                        if (a3.equals("DOWNLOADER_DOWNLOADING")) {
                            return "TRACKER_EVENT_TYPE_DOWNLOADER_DOWNLOADING";
                        }
                        return "unknown";
                    }
                    if (hashCode != 1331888222) {
                        return (hashCode == 1346121898 && a3.equals("DOWNLOADER_INITIALIZED")) ? "TRACKER_EVENT_TYPE_FALLBACK_URL" : "unknown";
                    }
                    if (a3.equals("DOWNLOADER_ERROR")) {
                        return "TRACKER_EVENT_TYPE_DOWNLOADER_ERROR";
                    }
                    return "unknown";
                }
                length2--;
            } else if (z4) {
                i2++;
            } else {
                z3 = true;
            }
        }
        String a32 = I7.a(length2, 1, upperCase2, i2);
        hashCode = a32.hashCode();
        if (hashCode != -1836567951) {
        }
    }

    public static String d(String str) {
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = str.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        int length = lowerCase.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) lowerCase.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String a2 = I7.a(length, 1, lowerCase, i);
        if (Intrinsics.areEqual(a2, "straight") || !Intrinsics.areEqual(a2, "curved")) {
            return "straight";
        }
        return "curved";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0076 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0077 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(String str) {
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String upperCase = str.toUpperCase(US);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        int length = upperCase.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) upperCase.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String a2 = I7.a(length, 1, upperCase, i);
        switch (a2.hashCode()) {
            case -2084521848:
                return a2.equals("DOWNLOAD") ? a2 : "EXTERNAL";
            case -1038134325:
                if (!a2.equals("EXTERNAL")) {
                }
                break;
            case 69805756:
                if (!a2.equals("INAPP")) {
                }
                break;
            case 1411860198:
                if (!a2.equals("DEEPLINK")) {
                }
                break;
            case 1568475786:
                if (!a2.equals("EMBEDDED")) {
                }
                break;
        }
    }

    public final C2730k8 b(Point point, Point point2, Point point3, Point point4, JSONObject jSONObject) {
        JSONObject optJSONObject;
        String str;
        String str2;
        String a2;
        String str3;
        String str4;
        String str5;
        String a3;
        int i;
        String str6 = "straight";
        String str7 = "#ff000000";
        if (jSONObject.isNull(OutlinedTextFieldKt.BorderId) || (optJSONObject = jSONObject.optJSONObject(OutlinedTextFieldKt.BorderId)) == null || optJSONObject.isNull("style")) {
            str5 = "straight";
            str3 = "#ff000000";
            str4 = "none";
        } else {
            String string = optJSONObject.getString("style");
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String e = e(string);
            if (!optJSONObject.isNull("corner")) {
                String string2 = optJSONObject.getString("corner");
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                str6 = d(string2);
            }
            if (optJSONObject.isNull("color")) {
                str = e;
                str2 = str6;
                a2 = "#ff000000";
            } else {
                String string3 = optJSONObject.getString("color");
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                int length = string3.length() - 1;
                int i2 = 0;
                boolean z = false;
                while (true) {
                    str = e;
                    if (i2 > length) {
                        str2 = str6;
                        break;
                    }
                    str2 = str6;
                    boolean z2 = Intrinsics.compare((int) string3.charAt(!z ? i2 : length), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        }
                        length--;
                    } else if (z2) {
                        i2++;
                    } else {
                        z = true;
                    }
                    e = str;
                    str6 = str2;
                }
                a2 = I7.a(length, 1, string3, i2);
            }
            str3 = a2;
            str4 = str;
            str5 = str2;
        }
        if (jSONObject.isNull("backgroundColor")) {
            a3 = "#00000000";
        } else {
            String string4 = jSONObject.getString("backgroundColor");
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            int length2 = string4.length() - 1;
            boolean z3 = false;
            int i3 = 0;
            while (i3 <= length2) {
                boolean z4 = z3;
                boolean z5 = Intrinsics.compare((int) string4.charAt(!z3 ? i3 : length2), 32) <= 0;
                if (z4) {
                    if (!z5) {
                        break;
                    }
                    length2--;
                } else if (z5) {
                    i3++;
                } else {
                    z3 = true;
                }
                z3 = z4;
            }
            a3 = I7.a(length2, 1, string4, i3);
        }
        String str8 = a3;
        JSONObject jSONObject2 = jSONObject.getJSONObject("text");
        try {
            String string5 = jSONObject2.getString(ContentDisposition.Parameters.Size);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            int parseDouble = (int) Double.parseDouble(string5);
            if (jSONObject2.isNull("color")) {
                i = parseDouble;
            } else {
                String string6 = jSONObject2.getString("color");
                Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                int length3 = string6.length() - 1;
                boolean z6 = false;
                int i4 = 0;
                while (true) {
                    if (i4 > length3) {
                        i = parseDouble;
                        break;
                    }
                    i = parseDouble;
                    boolean z7 = Intrinsics.compare((int) string6.charAt(!z6 ? i4 : length3), 32) <= 0;
                    if (z6) {
                        if (!z7) {
                            break;
                        }
                        length3--;
                    } else if (z7) {
                        i4++;
                    } else {
                        parseDouble = i;
                        z6 = true;
                    }
                    parseDouble = i;
                }
                str7 = I7.a(length3, 1, string6, i4);
            }
            String str9 = str7;
            ArrayList arrayList = new ArrayList();
            if (jSONObject2.isNull("style")) {
                arrayList.add("none");
            } else {
                int length4 = jSONObject2.getJSONArray("style").length();
                if (length4 == 0) {
                    arrayList.add("none");
                } else {
                    for (int i5 = 0; i5 < length4; i5++) {
                        String string7 = jSONObject2.getJSONArray("style").getString(i5);
                        Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
                        arrayList.add(j(string7));
                    }
                }
            }
            return new C2730k8(point.x, point.y, point2.x, point2.y, point3.x, point3.y, point4.x, point4.y, str4, str5, str3, str8, i, str9, arrayList, new P8(q(jSONObject.optJSONObject("startOffset")), q(jSONObject.optJSONObject("timerDuration"))));
        } catch (NumberFormatException e2) {
            InterfaceC2971z5 interfaceC2971z5 = this.n;
            if (interfaceC2971z5 != null) {
                Intrinsics.checkNotNullExpressionValue("p8", "TAG");
                ((A5) interfaceC2971z5).b("p8", "Failure in building text asset! Text size should be an integer");
            }
            JSONException jSONException = new JSONException(e2.getMessage());
            S5 s5 = S5.f2425a;
            C2640f2 event = new C2640f2(e2);
            Intrinsics.checkNotNullParameter(event, "event");
            S5.d.a(event);
            throw jSONException;
        }
    }

    public static int a(int i, int i2) {
        if (i == -1 || i == 0) {
            return i;
        }
        if (i == 25) {
            return i2 / 4;
        }
        if (i == 50) {
            return i2 / 2;
        }
        if (i != 75) {
            return i != 100 ? i2 / 4 : i2;
        }
        return (i2 * 3) / 4;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:299|210|211|212|213|214|(5:261|262|(1:264)|265|266)(1:216)|(1:217)|(3:247|248|(1:250)(11:251|(3:253|254|255)(1:257)|224|225|226|(1:228)(1:235)|229|(1:231)|232|233|(0)))|219|220|221|(10:223|224|225|226|(0)(0)|229|(0)|232|233|(0))(10:241|242|225|226|(0)(0)|229|(0)|232|233|(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(28:70|(2:172|173)(1:72)|(1:76)|83|(2:(1:170)|171)|85|86|87|(3:140|(10:145|146|147|148|(1:150)(1:162)|151|(18:156|94|95|(4:129|130|(2:133|131)|134)|97|(1:128)(2:101|102)|103|104|105|106|107|(1:109)(1:119)|110|(1:112)(1:118)|(1:114)|115|116|(0))|157|(1:159)(1:161)|160)(2:142|143)|144)(4:89|90|91|92)|93|94|95|(0)|97|(1:99)|128|103|104|105|106|107|(0)(0)|110|(0)(0)|(0)|115|116|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x03ac, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x03ae, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x03af, code lost:
    
        r15 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x0600, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:109:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x039d A[Catch: JSONException -> 0x03ac, TryCatch #16 {JSONException -> 0x03ac, blocks: (B:107:0x0385, B:110:0x038e, B:114:0x039d, B:115:0x03a0, B:118:0x0399), top: B:106:0x0385 }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0399 A[Catch: JSONException -> 0x03ac, TryCatch #16 {JSONException -> 0x03ac, blocks: (B:107:0x0385, B:110:0x038e, B:114:0x039d, B:115:0x03a0, B:118:0x0399), top: B:106:0x0385 }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0338 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x047c  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x056f  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x05c1 A[Catch: JSONException -> 0x05ce, TRY_ENTER, TRY_LEAVE, TryCatch #33 {JSONException -> 0x05ce, blocks: (B:255:0x0590, B:257:0x0594, B:223:0x05c1), top: B:217:0x0572 }] */
    /* JADX WARN: Removed duplicated region for block: B:228:0x05e7 A[Catch: JSONException -> 0x05fe, TryCatch #7 {JSONException -> 0x05fe, blocks: (B:226:0x05de, B:228:0x05e7, B:229:0x05ee, B:231:0x05f5, B:232:0x05f8), top: B:225:0x05de }] */
    /* JADX WARN: Removed duplicated region for block: B:231:0x05f5 A[Catch: JSONException -> 0x05fe, TryCatch #7 {JSONException -> 0x05fe, blocks: (B:226:0x05de, B:228:0x05e7, B:229:0x05ee, B:231:0x05f5, B:232:0x05f8), top: B:225:0x05de }] */
    /* JADX WARN: Removed duplicated region for block: B:235:0x05ed  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x05d0 A[Catch: JSONException -> 0x0600, TRY_ENTER, TRY_LEAVE, TryCatch #8 {JSONException -> 0x0600, blocks: (B:221:0x05bb, B:241:0x05d0), top: B:220:0x05bb }] */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0574 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:261:0x053c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:284:0x049f  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x04d4 A[Catch: JSONException -> 0x0504, TryCatch #2 {JSONException -> 0x0504, blocks: (B:285:0x04af, B:287:0x04ba, B:290:0x04d4, B:294:0x04ef), top: B:30:0x0107 }] */
    /* JADX WARN: Removed duplicated region for block: B:295:0x050b  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0613  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x0699 A[Catch: JSONException -> 0x06d1, TryCatch #27 {JSONException -> 0x06d1, blocks: (B:314:0x063c, B:316:0x0646, B:319:0x0660, B:321:0x0670, B:324:0x0677, B:325:0x0690, B:327:0x0699, B:328:0x06a0, B:332:0x0684, B:333:0x0650), top: B:313:0x063c }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x010a A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:331:0x069f  */
    /* JADX WARN: Removed duplicated region for block: B:340:0x06b4  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x06d6 A[Catch: JSONException -> 0x082e, TryCatch #18 {JSONException -> 0x082e, blocks: (B:342:0x06c4, B:346:0x06cb, B:347:0x06d6, B:349:0x06fb), top: B:30:0x0107 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x083a A[Catch: JSONException -> 0x0847, TRY_LEAVE, TryCatch #4 {JSONException -> 0x0847, blocks: (B:33:0x0836, B:35:0x083a, B:379:0x07d2, B:381:0x0817, B:384:0x07fb, B:386:0x080b, B:387:0x0812, B:391:0x081f), top: B:30:0x0107 }] */
    /* JADX WARN: Removed duplicated region for block: B:370:0x0785 A[Catch: JSONException -> 0x0828, TryCatch #23 {JSONException -> 0x0828, blocks: (B:367:0x0766, B:368:0x0779, B:370:0x0785, B:371:0x0788, B:372:0x0792, B:374:0x0798, B:376:0x07ca, B:394:0x076c), top: B:360:0x0750 }] */
    /* JADX WARN: Removed duplicated region for block: B:374:0x0798 A[Catch: JSONException -> 0x0828, TryCatch #23 {JSONException -> 0x0828, blocks: (B:367:0x0766, B:368:0x0779, B:370:0x0785, B:371:0x0788, B:372:0x0792, B:374:0x0798, B:376:0x07ca, B:394:0x076c), top: B:360:0x0750 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x086f  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x0119 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x085a  */
    /* JADX WARN: Type inference failed for: r0v102, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18, types: [com.inmobi.media.p8] */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v2, types: [com.inmobi.media.p8] */
    /* JADX WARN: Type inference failed for: r12v40 */
    /* JADX WARN: Type inference failed for: r12v41 */
    /* JADX WARN: Type inference failed for: r12v42 */
    /* JADX WARN: Type inference failed for: r12v43 */
    /* JADX WARN: Type inference failed for: r12v44 */
    /* JADX WARN: Type inference failed for: r12v45 */
    /* JADX WARN: Type inference failed for: r12v47 */
    /* JADX WARN: Type inference failed for: r12v48 */
    /* JADX WARN: Type inference failed for: r12v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v55 */
    /* JADX WARN: Type inference failed for: r12v59 */
    /* JADX WARN: Type inference failed for: r12v62 */
    /* JADX WARN: Type inference failed for: r12v70 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r12v91 */
    /* JADX WARN: Type inference failed for: r12v92 */
    /* JADX WARN: Type inference failed for: r12v96 */
    /* JADX WARN: Type inference failed for: r12v97 */
    /* JADX WARN: Type inference failed for: r12v98 */
    /* JADX WARN: Type inference failed for: r12v99 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v106 */
    /* JADX WARN: Type inference failed for: r1v112 */
    /* JADX WARN: Type inference failed for: r1v126 */
    /* JADX WARN: Type inference failed for: r1v127 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v44 */
    /* JADX WARN: Type inference failed for: r1v45 */
    /* JADX WARN: Type inference failed for: r1v49, types: [com.inmobi.media.p8] */
    /* JADX WARN: Type inference failed for: r1v64 */
    /* JADX WARN: Type inference failed for: r1v91 */
    /* JADX WARN: Type inference failed for: r1v92 */
    /* JADX WARN: Type inference failed for: r1v93 */
    /* JADX WARN: Type inference failed for: r1v96 */
    /* JADX WARN: Type inference failed for: r1v99 */
    /* JADX WARN: Type inference failed for: r31v6, types: [int] */
    /* JADX WARN: Type inference failed for: r31v7 */
    /* JADX WARN: Type inference failed for: r31v8 */
    /* JADX WARN: Type inference failed for: r47v0, types: [java.lang.Object, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C2613d8 a(JSONObject jSONObject, String str, String str2) {
        Point point;
        ?? r1;
        C2613d8 c2613d8;
        String str3;
        ?? r12;
        String str4;
        int i;
        String str5;
        int i2;
        String str6;
        InterfaceC2971z5 interfaceC2971z5;
        C2811p8 c2811p8;
        String str7;
        C2613d8 c2613d82;
        ArrayList arrayList;
        HashMap hashMap;
        HashMap hashMap2;
        HashMap hashMap3;
        C2811p8 c2811p82;
        String str8;
        String str9;
        String str10;
        C2811p8 c2811p83;
        C2811p8 c2811p84;
        String str11;
        String str12;
        String str13;
        C2811p8 c2811p85;
        String str14;
        int i3;
        String str15;
        String str16;
        C2630e8 a2;
        C2811p8 c2811p86;
        String str17;
        C2811p8 c2811p87;
        String str18;
        String str19;
        String str20;
        byte b;
        C2681h8 c2681h8;
        JSONObject jSONObject2;
        JSONArray jSONArray;
        int i4;
        String str21;
        String str22;
        C2811p8 c2811p88;
        C2811p8 c2811p89;
        String str23;
        C2730k8 b2;
        String str24;
        String optString;
        String str25;
        C2746l8 c2746l8;
        String str26;
        ArrayList arrayList2;
        Point point2;
        C2811p8 c2811p810;
        C2811p8 c2811p811;
        String str27;
        C2811p8 c2811p812;
        C2613d8 c2875t8;
        C2811p8 c2811p813;
        String str28;
        String str29;
        String str30;
        String str31;
        String str32;
        C2630e8 a3;
        String str33;
        String str34;
        String str35;
        JSONObject jSONObject3;
        String str36;
        int i5;
        String str37;
        C2811p8 c2811p814;
        C2811p8 c2811p815;
        C2811p8 c2811p816;
        String str38;
        String str39;
        String str40;
        String str41;
        ArrayList arrayList3;
        String str42;
        Object obj;
        boolean optBoolean;
        boolean optBoolean2;
        boolean optBoolean3;
        boolean optBoolean4;
        int b3;
        boolean z;
        double optDouble;
        ArrayList arrayList4;
        String str43;
        int i6;
        int i7;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        String str44;
        C2580b9 c2580b9;
        AdConfig.RenderingConfig rendering;
        String str45;
        InterfaceC2971z5 interfaceC2971z52;
        InterfaceC2971z5 interfaceC2971z53;
        String str46;
        Object obj2;
        String f = f(jSONObject);
        String g = g(jSONObject);
        JSONObject i8 = i(jSONObject);
        String str47 = "TAG";
        C2613d8 c2613d83 = null;
        if (!a((String) str, i8)) {
            InterfaceC2971z5 interfaceC2971z54 = this.n;
            if (interfaceC2971z54 != null) {
                ((A5) interfaceC2971z54).b("p8", I6.a("p8", "TAG", "Invalid asset style for asset: ", g));
                Unit unit = Unit.INSTANCE;
            }
            InterfaceC2971z5 interfaceC2971z55 = this.n;
            if (interfaceC2971z55 != null) {
                Intrinsics.checkNotNullExpressionValue("p8", "TAG");
                ((A5) interfaceC2971z55).b("p8", "Asset style JSON: " + i8);
                Unit unit2 = Unit.INSTANCE;
            }
            return null;
        }
        Point h = h(jSONObject);
        Point b4 = b(jSONObject, h);
        Point b5 = b(jSONObject);
        Point a4 = a(jSONObject, b5);
        ArrayList j = j(jSONObject);
        byte e = e(jSONObject);
        int a5 = a(jSONObject, true);
        int a6 = a(jSONObject, false);
        String d = d(jSONObject);
        byte l = l(n(jSONObject));
        JSONArray m = m(jSONObject);
        if (m.length() != 0) {
            point = b5;
            try {
                String string = m.getString(0);
                try {
                    if (TextUtils.isEmpty(string)) {
                        return null;
                    }
                    if (l == 1) {
                        c2613d8 = m(string);
                        if (c2613d8 == null) {
                            try {
                                C2811p8 c2811p817 = this.g;
                                if (c2811p817 != null) {
                                    c2613d8 = c2811p817.m(string);
                                }
                            } catch (JSONException e2) {
                                e = e2;
                                str46 = string;
                                InterfaceC2971z5 interfaceC2971z56 = this.n;
                                if (interfaceC2971z56 != null) {
                                    ((A5) interfaceC2971z56).b("p8", E0.a(e, H6.a("p8", "TAG", "Exception while buildingAsset - ")));
                                    Unit unit3 = Unit.INSTANCE;
                                }
                                r1 = "VIDEO";
                                str3 = str46;
                                str47 = "getJSONObject(...)";
                                str9 = "EXTERNAL";
                                str5 = "IMAGE";
                                str4 = d;
                                str10 = g;
                                r12 = "openMode";
                                str6 = "assetOnclick";
                                try {
                                    try {
                                        try {
                                            switch (str.hashCode()) {
                                                case -1919329183:
                                                    break;
                                                case -1884772963:
                                                    break;
                                                case 67056:
                                                    break;
                                                case 70564:
                                                    break;
                                                case 2241657:
                                                    break;
                                                case 2571565:
                                                    break;
                                                case 69775675:
                                                    break;
                                                case 79826725:
                                                    break;
                                                case 81665115:
                                                    break;
                                                case 1942407129:
                                                    break;
                                            }
                                        } catch (JSONException e3) {
                                            e = e3;
                                            c2811p83 = this;
                                            str13 = j;
                                        }
                                    } catch (JSONException e4) {
                                        e = e4;
                                    }
                                } catch (JSONException e5) {
                                    e = e5;
                                }
                                return null;
                            }
                        }
                        obj2 = "VIDEO";
                        str3 = string;
                        r1 = obj2;
                    }
                    obj2 = "VIDEO";
                    c2613d8 = null;
                    str3 = string;
                    r1 = obj2;
                } catch (JSONException e6) {
                    e = e6;
                    str46 = string;
                    c2613d8 = null;
                }
            } catch (JSONException e7) {
                e = e7;
                c2613d8 = null;
                str46 = null;
            }
        } else {
            point = b5;
            r1 = "VIDEO";
            c2613d8 = null;
            str3 = null;
        }
        try {
            str47 = "getJSONObject(...)";
            str9 = "EXTERNAL";
            str5 = "IMAGE";
            str4 = d;
            str10 = g;
            r12 = "openMode";
            str6 = "assetOnclick";
        } catch (JSONException e8) {
            e = e8;
            r12 = this;
            str4 = d;
            i = a6;
            str5 = "p8";
            r1 = f;
            i2 = a5;
            str6 = str;
        }
        switch (str.hashCode()) {
            case -1919329183:
                c2811p87 = this;
                str5 = f;
                i2 = a5;
                Point point3 = point;
                str12 = "TAG";
                i = a6;
                str11 = "p8";
                str6 = str;
                if (str6.equals("CONTAINER")) {
                    C2630e8 a7 = c2811p87.a(h, point3, b4, a4, i8);
                    try {
                        String str48 = "NO_ACTION";
                        if (jSONObject.isNull("assetOnclick")) {
                            str18 = "NO_ACTION";
                            str19 = null;
                            str20 = str48;
                        } else {
                            if (!jSONObject.getJSONObject("assetOnclick").isNull("openMode")) {
                                String string2 = jSONObject.getJSONObject("assetOnclick").getString("openMode");
                                Intrinsics.checkNotNull(string2);
                                str9 = b(string2);
                            }
                            JSONObject jSONObject4 = jSONObject.getJSONObject("assetOnclick");
                            Intrinsics.checkNotNullExpressionValue(jSONObject4, "getJSONObject(...)");
                            String optString2 = jSONObject4.optString("fallbackUrl");
                            Intrinsics.checkNotNullExpressionValue(optString2, "optString(...)");
                            str19 = optString2;
                            str18 = str9;
                            str20 = jSONObject4;
                        }
                        if (i8.has("transitionEffect")) {
                            String string3 = i8.getString("transitionEffect");
                            Intrinsics.checkNotNull(string3);
                            b = i(string3);
                        } else {
                            b = 0;
                        }
                    } catch (JSONException e9) {
                        e = e9;
                        c2811p84 = this;
                        r1 = str5;
                        r12 = c2811p84;
                        str47 = str12;
                        str5 = str11;
                        interfaceC2971z5 = r12.n;
                        str8 = r1;
                        c2811p82 = r12;
                        if (interfaceC2971z5 != null) {
                        }
                        c2613d82 = c2613d83;
                        str7 = str8;
                        c2811p8 = c2811p82;
                        if (c2613d82 != null) {
                        }
                        return c2613d82;
                    }
                    try {
                    } catch (JSONException e10) {
                        e = e10;
                        r1 = str20;
                        r12 = r12;
                        str47 = str12;
                        str5 = str11;
                        interfaceC2971z5 = r12.n;
                        str8 = r1;
                        c2811p82 = r12;
                        if (interfaceC2971z5 != null) {
                        }
                        c2613d82 = c2613d83;
                        str7 = str8;
                        c2811p8 = c2811p82;
                        if (c2613d82 != null) {
                        }
                        return c2613d82;
                    }
                    if (j != null && !j.isEmpty()) {
                        r12 = this;
                        String str49 = str5;
                        c2681h8 = new C2681h8(str49, str10, a7, j, str18, jSONObject, b);
                        jSONObject2 = jSONObject;
                        str20 = str49;
                        c2681h8.c(str2);
                        c2681h8.i = jSONObject2.optBoolean("supportLockScreen", false);
                        if (str19 != null) {
                            c2681h8.a(str19);
                        }
                        r12.b(c2681h8, jSONObject2);
                        jSONArray = jSONObject2.getJSONArray("assetValue");
                        i4 = 0;
                        while (i4 < jSONArray.length()) {
                            String str50 = str2 + ".assetValue[" + i4 + AbstractJsonLexerKt.END_LIST;
                            JSONObject jSONObject5 = jSONArray.getJSONObject(i4);
                            Intrinsics.checkNotNull(jSONObject5);
                            C2613d8 a8 = r12.a(jSONObject5, c(r12.k(jSONObject5)), str50);
                            if (a8 == null) {
                                InterfaceC2971z5 interfaceC2971z57 = r12.n;
                                if (interfaceC2971z57 != null) {
                                    str21 = str12;
                                    str22 = str11;
                                    Intrinsics.checkNotNullExpressionValue(str22, str21);
                                    ((A5) interfaceC2971z57).b(str22, "Cannot build asset from JSON: " + jSONObject5 + ' ');
                                    Unit unit4 = Unit.INSTANCE;
                                } else {
                                    str21 = str12;
                                    str22 = str11;
                                }
                            } else {
                                str21 = str12;
                                str22 = str11;
                                a8.c(str50);
                                a8.a(c2681h8);
                                JSONObject optJSONObject = jSONObject2.optJSONObject("assetOnclick");
                                c2681h8.i = optJSONObject != null ? optJSONObject.optBoolean("supportLockScreen", false) : false;
                                c2681h8.a(a8);
                            }
                            i4++;
                            str12 = str21;
                            str11 = str22;
                        }
                        Unit unit5 = Unit.INSTANCE;
                        c2613d83 = c2681h8;
                        str8 = str20;
                        c2811p82 = r12;
                        c2613d82 = c2613d83;
                        str7 = str8;
                        c2811p8 = c2811p82;
                        if (c2613d82 != null) {
                            c2613d82.b(e);
                            c2613d82.b(i2);
                            c2613d82.a(i);
                            C2613d8.d(str4);
                            if (str4.length() > 0 && (hashMap3 = c2811p8.k) != null) {
                                hashMap3.put(str7, str4);
                                Unit unit6 = Unit.INSTANCE;
                            }
                            if (str7.length() > 0 && (hashMap = c2811p8.j) != null && !hashMap.containsKey(str7) && (hashMap2 = c2811p8.j) != null) {
                                hashMap2.put(str7, c2613d82);
                                Unit unit7 = Unit.INSTANCE;
                            }
                            HashMap hashMap4 = c2811p8.i;
                            if (hashMap4 != null && hashMap4.containsKey(str6)) {
                                HashMap hashMap5 = c2811p8.i;
                                if (hashMap5 != null && (arrayList = (ArrayList) hashMap5.get(str6)) != null) {
                                    arrayList.add(c2613d82);
                                }
                            } else {
                                HashMap hashMap6 = c2811p8.i;
                                if (hashMap6 != null) {
                                    hashMap6.put(str6, CollectionsKt.arrayListOf(c2613d82));
                                    Unit unit8 = Unit.INSTANCE;
                                }
                            }
                        }
                    }
                    r12 = this;
                    String str51 = str5;
                    c2681h8 = new C2681h8(str51, str10, a7, str18, jSONObject, b);
                    jSONObject2 = jSONObject;
                    str20 = str51;
                    c2681h8.c(str2);
                    c2681h8.i = jSONObject2.optBoolean("supportLockScreen", false);
                    if (str19 != null) {
                    }
                    r12.b(c2681h8, jSONObject2);
                    jSONArray = jSONObject2.getJSONArray("assetValue");
                    i4 = 0;
                    while (i4 < jSONArray.length()) {
                    }
                    Unit unit52 = Unit.INSTANCE;
                    c2613d83 = c2681h8;
                    str8 = str20;
                    c2811p82 = r12;
                    c2613d82 = c2613d83;
                    str7 = str8;
                    c2811p8 = c2811p82;
                    if (c2613d82 != null) {
                    }
                }
                c2811p88 = c2811p87;
                str23 = str5;
                c2811p813 = c2811p88;
                str28 = str12;
                str29 = str11;
                str38 = str23;
                c2811p816 = c2811p813;
                interfaceC2971z53 = c2811p816.n;
                str8 = str38;
                c2811p82 = c2811p816;
                if (interfaceC2971z53 != null) {
                    Intrinsics.checkNotNullExpressionValue(str29, str28);
                    ((A5) interfaceC2971z53).b(str29, "Unknown assetType ( null ) received in adResponse");
                    Unit unit9 = Unit.INSTANCE;
                    str8 = str38;
                    c2811p82 = c2811p816;
                }
                c2613d82 = c2613d83;
                str7 = str8;
                c2811p8 = c2811p82;
                if (c2613d82 != null) {
                }
                break;
            case -1884772963:
                c2811p87 = this;
                str5 = f;
                i2 = a5;
                str12 = "TAG";
                i = a6;
                str11 = "p8";
                str6 = str;
                if (str6.equals("RATING")) {
                    Unit unit10 = Unit.INSTANCE;
                    c2811p89 = c2811p87;
                    str8 = str5;
                    c2811p82 = c2811p89;
                    c2613d82 = c2613d83;
                    str7 = str8;
                    c2811p8 = c2811p82;
                    if (c2613d82 != null) {
                    }
                } else {
                    c2811p88 = c2811p87;
                    str23 = str5;
                    c2811p813 = c2811p88;
                    str28 = str12;
                    str29 = str11;
                    str38 = str23;
                    c2811p816 = c2811p813;
                    interfaceC2971z53 = c2811p816.n;
                    str8 = str38;
                    c2811p82 = c2811p816;
                    if (interfaceC2971z53 != null) {
                    }
                    c2613d82 = c2613d83;
                    str7 = str8;
                    c2811p8 = c2811p82;
                    if (c2613d82 != null) {
                    }
                }
                break;
            case 67056:
                str5 = f;
                i2 = a5;
                Point point4 = point;
                str12 = "TAG";
                i = a6;
                str11 = "p8";
                try {
                } catch (JSONException e11) {
                    e = e11;
                    r1 = this;
                }
                if (str.equals(VastTagName.CTA)) {
                    if (!jSONObject.isNull("assetOnclick")) {
                        r1 = this;
                        try {
                            b2 = r1.b(h, point4, b4, a4, i8);
                            JSONObject optJSONObject2 = jSONObject.optJSONObject("assetOnclick");
                            if (optJSONObject2 == null || !optJSONObject2.isNull("openMode")) {
                                String string4 = jSONObject.getJSONObject("assetOnclick").getString("openMode");
                                Intrinsics.checkNotNull(string4);
                                str9 = b(string4);
                            }
                            str24 = str9;
                            JSONObject jSONObject6 = jSONObject.getJSONObject("assetOnclick");
                            Intrinsics.checkNotNullExpressionValue(jSONObject6, "getJSONObject(...)");
                            optString = jSONObject6.optString("fallbackUrl");
                            Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
                        } catch (JSONException e12) {
                            e = e12;
                            str6 = str;
                            c2811p84 = r1;
                            r1 = str5;
                            r12 = c2811p84;
                            str47 = str12;
                            str5 = str11;
                            interfaceC2971z5 = r12.n;
                            str8 = r1;
                            c2811p82 = r12;
                            if (interfaceC2971z5 != null) {
                            }
                            c2613d82 = c2613d83;
                            str7 = str8;
                            c2811p8 = c2811p82;
                            if (c2613d82 != null) {
                            }
                            return c2613d82;
                        }
                        if (j != null && !j.isEmpty()) {
                            str25 = "assetOnclick";
                            c2746l8 = new C2746l8(str5, str10, b2, str3, j, str24);
                            c2746l8.c(str2);
                            JSONObject optJSONObject3 = jSONObject.optJSONObject(str25);
                            c2746l8.i = optJSONObject3 == null ? optJSONObject3.optBoolean("supportLockScreen", false) : false;
                            r1.b(c2746l8, jSONObject);
                            c2746l8.a(optString);
                            Unit unit11 = Unit.INSTANCE;
                            str6 = str;
                            c2811p89 = r1;
                            c2613d83 = c2746l8;
                            str8 = str5;
                            c2811p82 = c2811p89;
                            c2613d82 = c2613d83;
                            str7 = str8;
                            c2811p8 = c2811p82;
                            if (c2613d82 != null) {
                            }
                        }
                        str25 = "assetOnclick";
                        c2746l8 = new C2746l8(str5, str10, b2, str3, str24);
                        c2746l8.c(str2);
                        JSONObject optJSONObject32 = jSONObject.optJSONObject(str25);
                        c2746l8.i = optJSONObject32 == null ? optJSONObject32.optBoolean("supportLockScreen", false) : false;
                        r1.b(c2746l8, jSONObject);
                        c2746l8.a(optString);
                        Unit unit112 = Unit.INSTANCE;
                        str6 = str;
                        c2811p89 = r1;
                        c2613d83 = c2746l8;
                        str8 = str5;
                        c2811p82 = c2811p89;
                        c2613d82 = c2613d83;
                        str7 = str8;
                        c2811p8 = c2811p82;
                        if (c2613d82 != null) {
                        }
                    }
                } else {
                    c2811p88 = this;
                    str6 = str;
                    str23 = str5;
                    c2811p813 = c2811p88;
                    str28 = str12;
                    str29 = str11;
                    str38 = str23;
                    c2811p816 = c2811p813;
                    interfaceC2971z53 = c2811p816.n;
                    str8 = str38;
                    c2811p82 = c2811p816;
                    if (interfaceC2971z53 != null) {
                    }
                    c2613d82 = c2613d83;
                    str7 = str8;
                    c2811p8 = c2811p82;
                    if (c2613d82 != null) {
                    }
                }
                break;
            case 70564:
                str26 = str2;
                arrayList2 = j;
                String str52 = f;
                i2 = a5;
                point2 = point;
                str12 = "TAG";
                i = a6;
                str11 = "p8";
                try {
                    str27 = str52;
                } catch (JSONException e13) {
                    e = e13;
                    c2811p810 = this;
                    str5 = str52;
                    str6 = str;
                    c2811p84 = c2811p810;
                    r1 = str5;
                    r12 = c2811p84;
                    str47 = str12;
                    str5 = str11;
                    interfaceC2971z5 = r12.n;
                    str8 = r1;
                    c2811p82 = r12;
                    if (interfaceC2971z5 != null) {
                    }
                    c2613d82 = c2613d83;
                    str7 = str8;
                    c2811p8 = c2811p82;
                    if (c2613d82 != null) {
                    }
                    return c2613d82;
                }
                if (str.equals("GIF")) {
                    c2811p811 = this;
                    str32 = str52;
                    String str53 = str32;
                    try {
                        a3 = c2811p811.a(h, point2, b4, a4, i8);
                        try {
                            String str54 = "NO_ACTION";
                            if (!jSONObject.isNull("assetOnclick")) {
                                str34 = "NO_ACTION";
                                str33 = null;
                                str35 = str54;
                            } else {
                                try {
                                    if (!jSONObject.getJSONObject("assetOnclick").isNull("openMode")) {
                                        String string5 = jSONObject.getJSONObject("assetOnclick").getString("openMode");
                                        Intrinsics.checkNotNull(string5);
                                        str9 = b(string5);
                                    }
                                    JSONObject jSONObject7 = jSONObject.getJSONObject("assetOnclick");
                                    Intrinsics.checkNotNullExpressionValue(jSONObject7, "getJSONObject(...)");
                                    String optString3 = jSONObject7.optString("fallbackUrl");
                                    Intrinsics.checkNotNullExpressionValue(optString3, "optString(...)");
                                    str33 = optString3;
                                    str34 = str9;
                                    str35 = jSONObject7;
                                } catch (JSONException e14) {
                                    e = e14;
                                    r12 = this;
                                    str6 = str;
                                    r1 = str53;
                                    str47 = str12;
                                    str5 = str11;
                                    interfaceC2971z5 = r12.n;
                                    str8 = r1;
                                    c2811p82 = r12;
                                    if (interfaceC2971z5 != null) {
                                    }
                                    c2613d82 = c2613d83;
                                    str7 = str8;
                                    c2811p8 = c2811p82;
                                    if (c2613d82 != null) {
                                    }
                                    return c2613d82;
                                }
                            }
                            try {
                            } catch (JSONException e15) {
                                e = e15;
                            }
                        } catch (JSONException e16) {
                            e = e16;
                            c2811p810 = this;
                            str5 = str53;
                            str6 = str;
                            c2811p84 = c2811p810;
                            r1 = str5;
                            r12 = c2811p84;
                            str47 = str12;
                            str5 = str11;
                            interfaceC2971z5 = r12.n;
                            str8 = r1;
                            c2811p82 = r12;
                            if (interfaceC2971z5 != null) {
                                ((A5) interfaceC2971z5).b(str5, E0.a(e, H6.a(str5, str47, "Exception while building assetTypes - ")));
                                Unit unit12 = Unit.INSTANCE;
                                str8 = r1;
                                c2811p82 = r12;
                            }
                            c2613d82 = c2613d83;
                            str7 = str8;
                            c2811p8 = c2811p82;
                            if (c2613d82 != null) {
                            }
                            return c2613d82;
                        }
                    } catch (JSONException e17) {
                        e = e17;
                        c2811p810 = c2811p811;
                    }
                    if (arrayList2 != null) {
                        try {
                        } catch (JSONException e18) {
                            e = e18;
                            r12 = this;
                            str35 = str53;
                            str6 = str;
                            r1 = str35;
                            r12 = r12;
                            str47 = str12;
                            str5 = str11;
                            interfaceC2971z5 = r12.n;
                            str8 = r1;
                            c2811p82 = r12;
                            if (interfaceC2971z5 != null) {
                            }
                            c2613d82 = c2613d83;
                            str7 = str8;
                            c2811p8 = c2811p82;
                            if (c2613d82 != null) {
                            }
                            return c2613d82;
                        }
                        if (!arrayList2.isEmpty()) {
                            if (Intrinsics.areEqual("IMAGE", (Object) str)) {
                                r12 = this;
                                String str55 = str53;
                                c2613d82 = new C2891u8(str55, str10, a3, l(jSONObject), arrayList2, str34, jSONObject);
                                str35 = str55;
                            } else {
                                r12 = this;
                                String str56 = str53;
                                c2613d82 = new C2858s8(str56, str10, a3, l(jSONObject), arrayList2, str34, jSONObject);
                                str35 = str56;
                            }
                            jSONObject3 = jSONObject;
                            str5 = str35;
                            c2811p810 = r12;
                            try {
                                c2613d82.c(str26);
                                JSONObject optJSONObject4 = jSONObject3.optJSONObject("assetOnclick");
                                c2613d82.i = optJSONObject4 != null ? optJSONObject4.optBoolean("supportLockScreen", false) : false;
                                c2811p810.b(c2613d82, jSONObject3);
                                if (str33 != null) {
                                    c2613d82.a(str33);
                                }
                                Unit unit13 = Unit.INSTANCE;
                                str6 = str;
                                str7 = str5;
                                c2811p8 = c2811p810;
                            } catch (JSONException e19) {
                                e = e19;
                                str6 = str;
                                c2811p84 = c2811p810;
                                r1 = str5;
                                r12 = c2811p84;
                                str47 = str12;
                                str5 = str11;
                                interfaceC2971z5 = r12.n;
                                str8 = r1;
                                c2811p82 = r12;
                                if (interfaceC2971z5 != null) {
                                }
                                c2613d82 = c2613d83;
                                str7 = str8;
                                c2811p8 = c2811p82;
                                if (c2613d82 != null) {
                                }
                                return c2613d82;
                            }
                            if (c2613d82 != null) {
                            }
                        }
                    }
                    r12 = this;
                    String str57 = str34;
                    str35 = str53;
                    String str58 = str10;
                    if (!Intrinsics.areEqual("IMAGE", (Object) str)) {
                        c2613d82 = new C2891u8(str35, str58, a3, l(jSONObject), str57, jSONObject);
                        str35 = str35;
                        r12 = r12;
                        jSONObject3 = jSONObject;
                        str5 = str35;
                        c2811p810 = r12;
                        c2613d82.c(str26);
                        JSONObject optJSONObject42 = jSONObject3.optJSONObject("assetOnclick");
                        c2613d82.i = optJSONObject42 != null ? optJSONObject42.optBoolean("supportLockScreen", false) : false;
                        c2811p810.b(c2613d82, jSONObject3);
                        if (str33 != null) {
                        }
                        Unit unit132 = Unit.INSTANCE;
                        str6 = str;
                        str7 = str5;
                        c2811p8 = c2811p810;
                        if (c2613d82 != null) {
                        }
                    } else {
                        c2613d82 = new C2858s8(str35, str58, a3, l(jSONObject), str57, jSONObject);
                        str5 = str35;
                        jSONObject3 = jSONObject;
                        c2811p810 = r12;
                        c2613d82.c(str26);
                        JSONObject optJSONObject422 = jSONObject3.optJSONObject("assetOnclick");
                        c2613d82.i = optJSONObject422 != null ? optJSONObject422.optBoolean("supportLockScreen", false) : false;
                        c2811p810.b(c2613d82, jSONObject3);
                        if (str33 != null) {
                        }
                        Unit unit1322 = Unit.INSTANCE;
                        str6 = str;
                        str7 = str5;
                        c2811p8 = c2811p810;
                        if (c2613d82 != null) {
                        }
                    }
                }
                c2811p812 = this;
                str30 = str27;
                str6 = str;
                str23 = str30;
                c2811p813 = c2811p812;
                str28 = str12;
                str29 = str11;
                str38 = str23;
                c2811p816 = c2811p813;
                interfaceC2971z53 = c2811p816.n;
                str8 = str38;
                c2811p82 = c2811p816;
                if (interfaceC2971z53 != null) {
                }
                c2613d82 = c2613d83;
                str7 = str8;
                c2811p8 = c2811p82;
                if (c2613d82 != null) {
                }
                break;
            case 2241657:
                String str59 = f;
                i2 = a5;
                Point point5 = point;
                str12 = "TAG";
                i = a6;
                str11 = "p8";
                if (str.equals("ICON")) {
                    c2875t8 = new C2875t8(str59, str10, a(h, point5, b4, a4, i8), l(jSONObject));
                    c2875t8.c(str2);
                    Unit unit14 = Unit.INSTANCE;
                    j = str59;
                    c2811p82 = this;
                    c2613d83 = c2875t8;
                    str6 = str;
                    str8 = j;
                    c2613d82 = c2613d83;
                    str7 = str8;
                    c2811p8 = c2811p82;
                    if (c2613d82 != null) {
                    }
                } else {
                    str27 = str59;
                    c2811p812 = this;
                    str30 = str27;
                    str6 = str;
                    str23 = str30;
                    c2811p813 = c2811p812;
                    str28 = str12;
                    str29 = str11;
                    str38 = str23;
                    c2811p816 = c2811p813;
                    interfaceC2971z53 = c2811p816.n;
                    str8 = str38;
                    c2811p82 = c2811p816;
                    if (interfaceC2971z53 != null) {
                    }
                    c2613d82 = c2613d83;
                    str7 = str8;
                    c2811p8 = c2811p82;
                    if (c2613d82 != null) {
                    }
                }
                break;
            case 2571565:
                c2811p811 = this;
                String str60 = f;
                i2 = a5;
                Point point6 = point;
                str12 = "TAG";
                i = a6;
                str11 = "p8";
                str31 = str60;
                if (str.equals("TEXT")) {
                    c2875t8 = new N8(str60, str10, c2811p811.c(h, point6, b4, a4, i8), str3);
                    c2875t8.c(str2);
                    Unit unit15 = Unit.INSTANCE;
                    j = str60;
                    c2811p82 = this;
                    c2613d83 = c2875t8;
                    str6 = str;
                    str8 = j;
                    c2613d82 = c2613d83;
                    str7 = str8;
                    c2811p8 = c2811p82;
                    if (c2613d82 != null) {
                    }
                }
                c2811p812 = c2811p811;
                str30 = str31;
                str6 = str;
                str23 = str30;
                c2811p813 = c2811p812;
                str28 = str12;
                str29 = str11;
                str38 = str23;
                c2811p816 = c2811p813;
                interfaceC2971z53 = c2811p816.n;
                str8 = str38;
                c2811p82 = c2811p816;
                if (interfaceC2971z53 != null) {
                }
                c2613d82 = c2613d83;
                str7 = str8;
                c2811p8 = c2811p82;
                if (c2613d82 != null) {
                }
                break;
            case 69775675:
                c2811p811 = this;
                arrayList2 = j;
                String str61 = f;
                i2 = a5;
                point2 = point;
                str12 = "TAG";
                i = a6;
                str11 = "p8";
                try {
                    str31 = str61;
                    if (str.equals("IMAGE")) {
                        str10 = str10;
                        str26 = str2;
                        str32 = str61;
                        String str532 = str32;
                        a3 = c2811p811.a(h, point2, b4, a4, i8);
                        String str542 = "NO_ACTION";
                        if (!jSONObject.isNull("assetOnclick")) {
                        }
                        if (arrayList2 != null) {
                        }
                        r12 = this;
                        String str572 = str34;
                        str35 = str532;
                        String str582 = str10;
                        if (!Intrinsics.areEqual("IMAGE", (Object) str)) {
                        }
                    }
                    c2811p812 = c2811p811;
                    str30 = str31;
                    str6 = str;
                    str23 = str30;
                    c2811p813 = c2811p812;
                    str28 = str12;
                    str29 = str11;
                    str38 = str23;
                    c2811p816 = c2811p813;
                    interfaceC2971z53 = c2811p816.n;
                    str8 = str38;
                    c2811p82 = c2811p816;
                    if (interfaceC2971z53 != null) {
                    }
                } catch (JSONException e20) {
                    e = e20;
                    c2811p83 = c2811p811;
                    str13 = str61;
                    str6 = str;
                    r1 = str13;
                    r12 = c2811p83;
                    str47 = str12;
                    str5 = str11;
                    interfaceC2971z5 = r12.n;
                    str8 = r1;
                    c2811p82 = r12;
                    if (interfaceC2971z5 != null) {
                    }
                    c2613d82 = c2613d83;
                    str7 = str8;
                    c2811p8 = c2811p82;
                    if (c2613d82 != null) {
                    }
                    return c2613d82;
                }
                c2613d82 = c2613d83;
                str7 = str8;
                c2811p8 = c2811p82;
                if (c2613d82 != null) {
                }
                break;
            case 79826725:
                str36 = f;
                i5 = a5;
                Point point7 = point;
                String str62 = "p8";
                str37 = "TAG";
                try {
                } catch (JSONException e21) {
                    e = e21;
                    c2811p814 = this;
                }
                if (str.equals("TIMER")) {
                    c2811p814 = this;
                    try {
                        C2630e8 a9 = c2811p814.a(h, point7, b4, a4, i8);
                        O8 q = jSONObject.has("startOffset") ? c2811p814.q(jSONObject.getJSONObject("startOffset")) : null;
                        O8 q2 = jSONObject.has("timerDuration") ? c2811p814.q(jSONObject.getJSONObject("timerDuration")) : null;
                        boolean optBoolean5 = jSONObject.optBoolean("displayTimer", true);
                        Q8 q8 = new Q8(str36, str10, a9, new P8(q, q2));
                        q8.a(optBoolean5);
                        if (jSONObject.has("assetOnFinish")) {
                            Object obj3 = jSONObject.get("assetOnFinish");
                            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type org.json.JSONObject");
                            JSONObject jSONObject8 = (JSONObject) obj3;
                            if (jSONObject8.has("action")) {
                                String string6 = jSONObject8.getString("action");
                                Intrinsics.checkNotNull(string6);
                                q8.a(a(string6));
                            }
                        }
                        q8.c(str2);
                        Unit unit16 = Unit.INSTANCE;
                        c2811p86 = c2811p814;
                        c2613d83 = q8;
                        str6 = str;
                        str17 = str36;
                        i2 = i5;
                        i = a6;
                        str8 = str17;
                        c2811p82 = c2811p86;
                    } catch (JSONException e22) {
                        e = e22;
                        c2811p815 = c2811p814;
                        str40 = str62;
                        str6 = str;
                        r1 = str36;
                        r12 = c2811p815;
                        str39 = str40;
                        i2 = i5;
                        i = a6;
                        str47 = str37;
                        str5 = str39;
                        interfaceC2971z5 = r12.n;
                        str8 = r1;
                        c2811p82 = r12;
                        if (interfaceC2971z5 != null) {
                        }
                        c2613d82 = c2613d83;
                        str7 = str8;
                        c2811p8 = c2811p82;
                        if (c2613d82 != null) {
                        }
                        return c2613d82;
                    }
                    c2613d82 = c2613d83;
                    str7 = str8;
                    c2811p8 = c2811p82;
                    if (c2613d82 != null) {
                    }
                } else {
                    c2811p816 = this;
                    str6 = str;
                    str38 = str36;
                    i2 = i5;
                    i = a6;
                    str28 = str37;
                    str29 = str62;
                    interfaceC2971z53 = c2811p816.n;
                    str8 = str38;
                    c2811p82 = c2811p816;
                    if (interfaceC2971z53 != null) {
                    }
                    c2613d82 = c2613d83;
                    str7 = str8;
                    c2811p8 = c2811p82;
                    if (c2613d82 != null) {
                    }
                }
                break;
            case 81665115:
                i5 = a5;
                Point point8 = point;
                try {
                } catch (JSONException e23) {
                    e = e23;
                    str37 = "TAG";
                    str41 = "p8";
                }
                if (str.equals(r1)) {
                    ?? r0 = this.i;
                    if (r0 != 0) {
                        try {
                            arrayList3 = (ArrayList) r0.get(r1);
                        } catch (JSONException e24) {
                            e = e24;
                            r12 = this;
                            str47 = "TAG";
                            str5 = "p8";
                            str6 = str;
                            r1 = f;
                            i2 = i5;
                            i = a6;
                            interfaceC2971z5 = r12.n;
                            str8 = r1;
                            c2811p82 = r12;
                            if (interfaceC2971z5 != null) {
                            }
                            c2613d82 = c2613d83;
                            str7 = str8;
                            c2811p8 = c2811p82;
                            if (c2613d82 != null) {
                            }
                            return c2613d82;
                        }
                    } else {
                        arrayList3 = null;
                    }
                    if (arrayList3 != null && (interfaceC2971z52 = this.n) != null) {
                        Intrinsics.checkNotNullExpressionValue("p8", "TAG");
                        ((A5) interfaceC2971z52).b("p8", "One video asset already present! I will add this to the data model (for now) but ideally consider skipping this asset");
                        Unit unit17 = Unit.INSTANCE;
                    }
                    P8 a10 = a(i8);
                    int i9 = h.x;
                    ?? r31 = h.y;
                    C2580b9 c2580b92 = new C2580b9(i9, r31, point8.x, point8.y, b4.x, b4.y, a4.x, a4.y, a10);
                    Ve ve = this.l;
                    if (ve == null) {
                        if (str3 == null) {
                            str3 = "";
                        }
                        ve = a(jSONObject, str3, c2613d8);
                    }
                    Ve ve2 = ve;
                    str37 = "TAG";
                    if (this.o == 0) {
                        try {
                        } catch (JSONException e25) {
                            e = e25;
                        }
                        if (c2613d8 != null) {
                            try {
                                str42 = "p8";
                                obj = c2613d8.a().get("didRequestFullScreen");
                            } catch (JSONException e26) {
                                e = e26;
                                r31 = "p8";
                                r12 = this;
                                str6 = str;
                                r1 = f;
                                str39 = r31;
                                i2 = i5;
                                i = a6;
                                str47 = str37;
                                str5 = str39;
                                interfaceC2971z5 = r12.n;
                                str8 = r1;
                                c2811p82 = r12;
                                if (interfaceC2971z5 != null) {
                                }
                                c2613d82 = c2613d83;
                                str7 = str8;
                                c2811p8 = c2811p82;
                                if (c2613d82 != null) {
                                }
                                return c2613d82;
                            }
                            if (!Intrinsics.areEqual(obj instanceof Boolean ? (Boolean) obj : null, Boolean.TRUE) && !this.s) {
                                arrayList4 = j;
                                str43 = f;
                                i6 = Integer.MAX_VALUE;
                                i7 = 0;
                                z2 = true;
                                z3 = true;
                                z4 = false;
                                z5 = true;
                                z6 = true;
                                str41 = str42;
                                HashMap hashMap7 = new HashMap();
                                if (!jSONObject.isNull("videoViewabilityConfig")) {
                                    try {
                                        JSONObject jSONObject9 = jSONObject.getJSONObject("videoViewabilityConfig");
                                        Iterator<String> keys = jSONObject9.keys();
                                        Intrinsics.checkNotNull(keys);
                                        while (keys.hasNext()) {
                                            String next = keys.next();
                                            Object obj4 = jSONObject9.get(next);
                                            Intrinsics.checkNotNull(next);
                                            Intrinsics.checkNotNull(obj4);
                                            hashMap7.put(next, obj4);
                                        }
                                    } catch (JSONException e27) {
                                        e = e27;
                                        r12 = this;
                                        str6 = str;
                                        r1 = str43;
                                        str39 = str41;
                                        i2 = i5;
                                        i = a6;
                                        str47 = str37;
                                        str5 = str39;
                                        interfaceC2971z5 = r12.n;
                                        str8 = r1;
                                        c2811p82 = r12;
                                        if (interfaceC2971z5 != null) {
                                        }
                                        c2613d82 = c2613d83;
                                        str7 = str8;
                                        c2811p8 = c2811p82;
                                        if (c2613d82 != null) {
                                        }
                                        return c2613d82;
                                    }
                                }
                                AdConfig adConfig = this.m;
                                C2597c9 c2597c9 = new C2597c9(str43, str10, c2580b92, ve2, z2, z3, z4, z5, z6, arrayList4, (adConfig != null || (rendering = adConfig.getRendering()) == null) ? false : rendering.getEnablePubMuteControl());
                                str36 = str43;
                                c2597c9.a(hashMap7);
                                c2597c9.c(i6 > 0 ? Integer.MAX_VALUE : i6);
                                c2597c9.c(str2);
                                c2597c9.w = c2613d8;
                                if (c2613d8 == null) {
                                    c2613d8.w = c2597c9;
                                }
                                if (i7 != 0) {
                                    c2597c9.d(i7);
                                }
                                Unit unit18 = Unit.INSTANCE;
                                c2811p8 = this;
                                str6 = str;
                                c2613d82 = c2597c9;
                                str7 = str36;
                                i2 = i5;
                                i = a6;
                                if (c2613d82 != null) {
                                }
                            }
                            optBoolean = jSONObject.optBoolean("loop", false);
                            boolean optBoolean6 = jSONObject.optBoolean("showProgress", true);
                            optBoolean2 = jSONObject.optBoolean("soundOn", true);
                            optBoolean3 = jSONObject.optBoolean("showMute", true);
                            optBoolean4 = jSONObject.optBoolean("autoPlay", true);
                            b3 = c2613d8 instanceof C2597c9 ? ((C2597c9) c2613d8).b() : Integer.MAX_VALUE;
                            z = optBoolean6;
                            optDouble = jSONObject.optDouble("pauseAfter", 0.0d);
                            str44 = str42;
                        } else {
                            str44 = "p8";
                            optBoolean = jSONObject.optBoolean("loop", true);
                            boolean optBoolean7 = jSONObject.optBoolean("showProgress", false);
                            optBoolean2 = jSONObject.optBoolean("soundOn", false);
                            boolean optBoolean8 = jSONObject.optBoolean("showMute", false);
                            boolean optBoolean9 = jSONObject.optBoolean("autoPlay", true);
                            int optInt = jSONObject.optInt("completeAfter", Integer.MAX_VALUE);
                            optBoolean4 = optBoolean9;
                            optDouble = jSONObject.optDouble("pauseAfter", 0.0d);
                            z = optBoolean7;
                            optBoolean3 = optBoolean8;
                            b3 = optInt;
                        }
                        c2580b9 = c2580b92;
                        str45 = str44;
                    } else {
                        str41 = "p8";
                        try {
                            optBoolean = jSONObject.optBoolean("loop", false);
                            boolean optBoolean10 = jSONObject.optBoolean("showProgress", true);
                            optBoolean2 = jSONObject.optBoolean("soundOn", true);
                            optBoolean3 = jSONObject.optBoolean("showMute", true);
                            optBoolean4 = jSONObject.optBoolean("autoPlay", true);
                            c2580b9 = c2580b92;
                            z = optBoolean10;
                            b3 = jSONObject.optInt("completeAfter", Integer.MAX_VALUE);
                            optDouble = jSONObject.optDouble("pauseAfter", 0.0d);
                            str45 = str41;
                        } catch (JSONException e28) {
                            e = e28;
                            str36 = f;
                            c2811p815 = this;
                            str40 = str41;
                            str6 = str;
                            r1 = str36;
                            r12 = c2811p815;
                            str39 = str40;
                            i2 = i5;
                            i = a6;
                            str47 = str37;
                            str5 = str39;
                            interfaceC2971z5 = r12.n;
                            str8 = r1;
                            c2811p82 = r12;
                            if (interfaceC2971z5 != null) {
                            }
                            c2613d82 = c2613d83;
                            str7 = str8;
                            c2811p8 = c2811p82;
                            if (c2613d82 != null) {
                            }
                            return c2613d82;
                        }
                    }
                    i7 = (int) optDouble;
                    arrayList4 = j;
                    z5 = z;
                    c2580b92 = c2580b9;
                    z4 = optBoolean;
                    z2 = optBoolean2;
                    z6 = optBoolean4;
                    i6 = b3;
                    str43 = f;
                    z3 = optBoolean3;
                    str41 = str45;
                    HashMap hashMap72 = new HashMap();
                    if (!jSONObject.isNull("videoViewabilityConfig")) {
                    }
                    AdConfig adConfig2 = this.m;
                    C2597c9 c2597c92 = new C2597c9(str43, str10, c2580b92, ve2, z2, z3, z4, z5, z6, arrayList4, (adConfig2 != null || (rendering = adConfig2.getRendering()) == null) ? false : rendering.getEnablePubMuteControl());
                    str36 = str43;
                    c2597c92.a(hashMap72);
                    c2597c92.c(i6 > 0 ? Integer.MAX_VALUE : i6);
                    c2597c92.c(str2);
                    c2597c92.w = c2613d8;
                    if (c2613d8 == null) {
                    }
                    if (i7 != 0) {
                    }
                    Unit unit182 = Unit.INSTANCE;
                    c2811p8 = this;
                    str6 = str;
                    c2613d82 = c2597c92;
                    str7 = str36;
                    i2 = i5;
                    i = a6;
                    if (c2613d82 != null) {
                    }
                } else {
                    c2811p816 = this;
                    str28 = "TAG";
                    str29 = "p8";
                    str6 = str;
                    str38 = f;
                    i2 = i5;
                    i = a6;
                    interfaceC2971z53 = c2811p816.n;
                    str8 = str38;
                    c2811p82 = c2811p816;
                    if (interfaceC2971z53 != null) {
                    }
                    c2613d82 = c2613d83;
                    str7 = str8;
                    c2811p8 = c2811p82;
                    if (c2613d82 != null) {
                    }
                }
                break;
            case 1942407129:
                try {
                } catch (JSONException e29) {
                    e = e29;
                    c2811p85 = this;
                }
                if (str.equals("WEBVIEW")) {
                    if (str3 != null) {
                        String a11 = E9.a(p(jSONObject));
                        if (Intrinsics.areEqual("URL", a11)) {
                            try {
                                if (!URLUtil.isValidUrl(str3)) {
                                }
                            } catch (JSONException e30) {
                                e = e30;
                                r12 = this;
                                str6 = str;
                                r1 = f;
                                i2 = a5;
                                str47 = "TAG";
                                i = a6;
                                str5 = "p8";
                                interfaceC2971z5 = r12.n;
                                str8 = r1;
                                c2811p82 = r12;
                                if (interfaceC2971z5 != null) {
                                }
                                c2613d82 = c2613d83;
                                str7 = str8;
                                c2811p8 = c2811p82;
                                if (c2613d82 != null) {
                                }
                                return c2613d82;
                            }
                        }
                        try {
                            a2 = a(h, point, b4, a4, i8);
                            c2811p85 = this;
                            try {
                                str14 = f;
                                i3 = a5;
                                str15 = "TAG";
                                str16 = "p8";
                            } catch (JSONException e31) {
                                e = e31;
                                str14 = f;
                                i3 = a5;
                                str15 = "TAG";
                                str16 = "p8";
                                r12 = c2811p85;
                                str47 = str15;
                                str6 = str;
                                i2 = i3;
                                r1 = str14;
                                i = a6;
                                str5 = str16;
                                interfaceC2971z5 = r12.n;
                                str8 = r1;
                                c2811p82 = r12;
                                if (interfaceC2971z5 != null) {
                                }
                                c2613d82 = c2613d83;
                                str7 = str8;
                                c2811p8 = c2811p82;
                                if (c2613d82 != null) {
                                }
                                return c2613d82;
                            }
                        } catch (JSONException e32) {
                            e = e32;
                            c2811p85 = this;
                        }
                        try {
                            F9 f9 = new F9(str14, str10, a2, str3, jSONObject.optBoolean("isScrollable"));
                            f9.e(a11);
                            f9.c(str2);
                            if (jSONObject.optBoolean(LinkHeader.Rel.PreLoad, false)) {
                                f9.b();
                                c2811p85.r = f9;
                            }
                            Unit unit19 = Unit.INSTANCE;
                            c2811p86 = c2811p85;
                            str6 = str;
                            i2 = i3;
                            c2613d83 = f9;
                            str17 = str14;
                            i = a6;
                            str8 = str17;
                            c2811p82 = c2811p86;
                        } catch (JSONException e33) {
                            e = e33;
                            r12 = c2811p85;
                            str47 = str15;
                            str6 = str;
                            i2 = i3;
                            r1 = str14;
                            i = a6;
                            str5 = str16;
                            interfaceC2971z5 = r12.n;
                            str8 = r1;
                            c2811p82 = r12;
                            if (interfaceC2971z5 != null) {
                            }
                            c2613d82 = c2613d83;
                            str7 = str8;
                            c2811p8 = c2811p82;
                            if (c2613d82 != null) {
                            }
                            return c2613d82;
                        }
                        c2613d82 = c2613d83;
                        str7 = str8;
                        c2811p8 = c2811p82;
                        if (c2613d82 != null) {
                        }
                    }
                }
                break;
            default:
                c2811p816 = this;
                str6 = str;
                str38 = f;
                i2 = a5;
                str28 = "TAG";
                i = a6;
                str29 = "p8";
                interfaceC2971z53 = c2811p816.n;
                str8 = str38;
                c2811p82 = c2811p816;
                if (interfaceC2971z53 != null) {
                }
                c2613d82 = c2613d83;
                str7 = str8;
                c2811p8 = c2811p82;
                if (c2613d82 != null) {
                }
                break;
        }
        return null;
    }

    public final void a(C2613d8 c2613d8, JSONObject jSONObject) {
        String string;
        boolean z;
        boolean z2 = true;
        String str = "";
        if (jSONObject.isNull("itemUrl")) {
            InterfaceC2971z5 interfaceC2971z5 = this.n;
            if (interfaceC2971z5 != null) {
                Intrinsics.checkNotNullExpressionValue("p8", "TAG");
                ((A5) interfaceC2971z5).b("p8", "Missing itemUrl on publisher onClick");
            }
            z = false;
            string = "";
        } else {
            string = jSONObject.getString("itemUrl");
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            z = true;
        }
        if (jSONObject.isNull("action")) {
            z2 = z;
        } else {
            str = jSONObject.getString("action");
            Intrinsics.checkNotNullExpressionValue(str, "getString(...)");
        }
        c2613d8.b(string);
        String optString = jSONObject.optString("fallbackUrl");
        Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
        c2613d8.a(optString);
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        c2613d8.h = str;
        c2613d8.f = z2;
        c2613d8.u = jSONObject.optString("appBundleId");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final boolean a(String str, JSONObject jSONObject) {
        if (!jSONObject.isNull("geometry")) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("geometry");
                Intrinsics.checkNotNull(jSONArray);
                try {
                    int i = jSONArray.getInt(2);
                    int i2 = jSONArray.getInt(3);
                    if (i > 0 && i2 > 0) {
                        switch (str.hashCode()) {
                            case -1919329183:
                                if (!str.equals("CONTAINER")) {
                                    break;
                                } else {
                                    return true;
                                }
                            case 67056:
                                if (!str.equals(VastTagName.CTA)) {
                                    break;
                                }
                                break;
                            case 70564:
                                if (!str.equals("GIF")) {
                                    break;
                                } else {
                                    return true;
                                }
                            case 2241657:
                                if (!str.equals("ICON")) {
                                    break;
                                } else {
                                    return true;
                                }
                            case 2571565:
                                if (!str.equals("TEXT")) {
                                    break;
                                }
                                break;
                            case 69775675:
                                if (!str.equals("IMAGE")) {
                                    break;
                                } else {
                                    return true;
                                }
                            case 79826725:
                                if (!str.equals("TIMER")) {
                                    break;
                                } else {
                                    return true;
                                }
                            case 81665115:
                                if (!str.equals("VIDEO")) {
                                    break;
                                } else {
                                    return true;
                                }
                            case 1942407129:
                                if (str.equals("WEBVIEW")) {
                                    return true;
                                }
                                break;
                        }
                        if (jSONObject.isNull("text")) {
                            return false;
                        }
                        try {
                            String string = jSONObject.getJSONObject("text").getString(ContentDisposition.Parameters.Size);
                            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                            if (((int) Double.parseDouble(string)) > 0) {
                                return true;
                            }
                        } catch (NumberFormatException e) {
                            InterfaceC2971z5 interfaceC2971z5 = this.n;
                            if (interfaceC2971z5 != null) {
                                Intrinsics.checkNotNullExpressionValue("p8", "TAG");
                                ((A5) interfaceC2971z5).b("p8", "Failure in validating text asset! Text size should be an integer");
                            }
                            S5 s5 = S5.f2425a;
                            C2640f2 event = new C2640f2(e);
                            Intrinsics.checkNotNullParameter(event, "event");
                            S5.d.a(event);
                            return false;
                        }
                    }
                } catch (JSONException e2) {
                    InterfaceC2971z5 interfaceC2971z52 = this.n;
                    if (interfaceC2971z52 != null) {
                        Intrinsics.checkNotNullExpressionValue("p8", "TAG");
                        ((A5) interfaceC2971z52).b("p8", "Exception while getting geometry - " + e2.getMessage());
                    }
                }
                return false;
            } catch (JSONException e3) {
                InterfaceC2971z5 interfaceC2971z53 = this.n;
                if (interfaceC2971z53 != null) {
                    ((A5) interfaceC2971z53).b("p8", E0.a(e3, H6.a("p8", "TAG", "Exception while getting assetStyle - ")));
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x015a, code lost:
    
        if (r11.equals(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_NATIVE_VIDEO_MUTE) == false) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01a1, code lost:
    
        r6 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0163, code lost:
    
        if (r11.equals("load") == false) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x016c, code lost:
    
        if (r11.equals("client_fill") == false) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x017a, code lost:
    
        if (r11.equals(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_NATIVE_VIDEO_COMPLETE) == false) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0183, code lost:
    
        if (r11.equals(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_NATIVE_VIDEO_UNMUTE) == false) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x018c, code lost:
    
        if (r11.equals(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_NATIVE_VIDEO_RESUME) == false) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0195, code lost:
    
        if (r11.equals("thirdQuartile") == false) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x019e, code lost:
    
        if (r11.equals(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_NATIVE_VIDEO_MIDPOINT) == false) goto L124;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final U8 a(int i, String str, JSONObject jSONObject) {
        String a2;
        String str2;
        int i2 = 0;
        if (jSONObject.isNull("url")) {
            a2 = "";
        } else {
            String string = jSONObject.getString("url");
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            int length = string.length() - 1;
            int i3 = 0;
            boolean z = false;
            while (i3 <= length) {
                boolean z2 = Intrinsics.compare((int) string.charAt(!z ? i3 : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    }
                    length--;
                } else if (z2) {
                    i3++;
                } else {
                    z = true;
                }
            }
            a2 = I7.a(length, 1, string, i3);
        }
        HashMap hashMap = new HashMap();
        if (Intrinsics.areEqual("VideoImpression", str)) {
            JSONArray optJSONArray = jSONObject.optJSONArray("events");
            if ((a2.length() == 0 || ((StringsKt.startsWith$default(a2, "http", false, 2, (Object) null) && !URLUtil.isValidUrl(a2)) || !StringsKt.startsWith$default(a2, "http", false, 2, (Object) null))) && optJSONArray == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null) {
                int length2 = optJSONArray.length();
                while (i2 < length2) {
                    String string2 = optJSONArray.getString(i2);
                    int i4 = i2;
                    String str3 = "unknown";
                    if (!TextUtils.isEmpty(string2) && string2 != null) {
                        switch (string2.hashCode()) {
                            case -1638835128:
                                str2 = CampaignEx.JSON_NATIVE_VIDEO_MIDPOINT;
                                break;
                            case -1337830390:
                                str2 = "thirdQuartile";
                                break;
                            case -934426579:
                                str2 = CampaignEx.JSON_NATIVE_VIDEO_RESUME;
                                break;
                            case -840405966:
                                str2 = CampaignEx.JSON_NATIVE_VIDEO_UNMUTE;
                                break;
                            case -599445191:
                                str2 = CampaignEx.JSON_NATIVE_VIDEO_COMPLETE;
                                break;
                            case -284840886:
                                string2.equals("unknown");
                                break;
                            case -174104201:
                                str2 = "client_fill";
                                break;
                            case 3327206:
                                str2 = "load";
                                break;
                            case 3363353:
                                str2 = CampaignEx.JSON_NATIVE_VIDEO_MUTE;
                                break;
                            case 94750088:
                                if (string2.equals("click")) {
                                    str3 = "click";
                                    break;
                                }
                                break;
                            case 96784904:
                                if (string2.equals("error")) {
                                    str3 = "error";
                                    break;
                                }
                                break;
                            case 106440182:
                                if (string2.equals(CampaignEx.JSON_NATIVE_VIDEO_PAUSE)) {
                                    str3 = CampaignEx.JSON_NATIVE_VIDEO_PAUSE;
                                    break;
                                }
                                break;
                            case 109757538:
                                if (string2.equals("start")) {
                                    str3 = "start";
                                    break;
                                }
                                break;
                            case 110066619:
                                if (string2.equals(com.vungle.ads.internal.Constants.TEMPLATE_TYPE_FULLSCREEN)) {
                                    str3 = com.vungle.ads.internal.Constants.TEMPLATE_TYPE_FULLSCREEN;
                                    break;
                                }
                                break;
                            case 113951609:
                                if (string2.equals("exitFullscreen")) {
                                    str3 = "exitFullscreen";
                                    break;
                                }
                                break;
                            case 354294980:
                                if (string2.equals("VideoImpression")) {
                                    str3 = "VideoImpression";
                                    break;
                                }
                                break;
                            case 368426751:
                                if (string2.equals("OMID_VIEWABILITY")) {
                                    str3 = "OMID_VIEWABILITY";
                                    break;
                                }
                                break;
                            case 560220243:
                                if (string2.equals("firstQuartile")) {
                                    str3 = "firstQuartile";
                                    break;
                                }
                                break;
                            case 883937877:
                                if (string2.equals("page_view")) {
                                    str3 = "page_view";
                                    break;
                                }
                                break;
                            case 1342121331:
                                if (string2.equals("closeEndCard")) {
                                    str3 = "closeEndCard";
                                    break;
                                }
                                break;
                            case 1778167540:
                                if (string2.equals("creativeView")) {
                                    str3 = "creativeView";
                                    break;
                                }
                                break;
                            case 2114088489:
                                if (string2.equals("Impression")) {
                                    str3 = "Impression";
                                    break;
                                }
                                break;
                        }
                    }
                    if (Intrinsics.areEqual("creativeView", str3) || Intrinsics.areEqual("start", str3) || Intrinsics.areEqual("Impression", str3)) {
                        arrayList.add(str3);
                    }
                    i2 = i4 + 1;
                }
            }
            hashMap.put("referencedEvents", arrayList);
        } else if (!URLUtil.isValidUrl(a2)) {
            return null;
        }
        HashMap hashMap2 = new HashMap();
        try {
            if (!jSONObject.isNull("params")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("params");
                Iterator<String> keys = jSONObject2.keys();
                Intrinsics.checkNotNull(keys);
                while (keys.hasNext()) {
                    String next = keys.next();
                    Intrinsics.checkNotNull(next);
                    String string3 = jSONObject2.getString(next);
                    Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                    hashMap2.put(next, string3);
                }
            }
        } catch (JSONException e) {
            InterfaceC2971z5 interfaceC2971z5 = this.n;
            if (interfaceC2971z5 != null) {
                Intrinsics.checkNotNullExpressionValue("p8", "TAG");
                ((A5) interfaceC2971z5).a("p8", "Failed to parser tracker.params", e);
            }
        }
        U8 u8 = new U8(a2, i, str, hashMap2);
        u8.e = new HashMap(hashMap);
        return u8;
    }

    public final Ve a(JSONObject jSONObject, String str, C2613d8 c2613d8) {
        AdConfig.VastVideoConfig vastVideo;
        if (StringsKt.equals(k(jSONObject), "VIDEO", true)) {
            try {
                if (!jSONObject.isNull("assetValue")) {
                    if (c2613d8 instanceof C2597c9) {
                        Object obj = ((C2597c9) c2613d8).e;
                        if (obj instanceof Ve) {
                            return (Ve) obj;
                        }
                    } else {
                        AdConfig adConfig = this.m;
                        if (adConfig != null && (vastVideo = adConfig.getVastVideo()) != null) {
                            return new Pe(vastVideo, this.n).a(str);
                        }
                    }
                }
                return null;
            } catch (JSONException e) {
                InterfaceC2971z5 interfaceC2971z5 = this.n;
                if (interfaceC2971z5 != null) {
                    ((A5) interfaceC2971z5).b("p8", E0.a(e, H6.a("p8", "TAG", "Exception while getting videoDescriptor - ")));
                }
            }
        }
        return null;
    }

    public final Point a(JSONObject jSONObject, Point point) {
        JSONObject i;
        try {
            i = i(jSONObject);
        } catch (JSONException unused) {
        }
        if (i.isNull("finalGeometry")) {
            return point;
        }
        JSONArray jSONArray = i.getJSONArray("finalGeometry");
        Point point2 = new Point();
        point2.x = a(jSONArray.getInt(2));
        point2.y = a(jSONArray.getInt(3));
        return point2;
    }

    public final int a(JSONObject jSONObject, boolean z) {
        JSONObject c;
        String str;
        try {
            c = c(jSONObject);
            str = z ? "delay" : "hideAfterDelay";
        } catch (JSONException e) {
            InterfaceC2971z5 interfaceC2971z5 = this.n;
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).b("p8", E0.a(e, H6.a("p8", "TAG", "Exception while getting assetDisplayOnDelay - ")));
            }
        }
        if (c.isNull(str)) {
            return -1;
        }
        int i = c.getInt(str);
        if (3 != e(jSONObject)) {
            if (4 == e(jSONObject)) {
                if (i != 0) {
                    if (1 <= i && i < 101) {
                        int[] iArr = {25, 50, 75, 100};
                        double d = Double.MAX_VALUE;
                        int i2 = -1;
                        for (int i3 = 0; i3 < 4; i3++) {
                            int i4 = i - iArr[i3];
                            double d2 = i4 * i4;
                            if (d2 < d) {
                                i2 = i3;
                                d = d2;
                            }
                        }
                        return iArr[i2];
                    }
                }
            }
            return -1;
        }
        return i;
    }

    public static byte a(String str) {
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String upperCase = str.toUpperCase(US);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        int length = upperCase.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) upperCase.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String a2 = I7.a(length, 1, upperCase, i);
        return (!Intrinsics.areEqual(a2, "NONE") && Intrinsics.areEqual(a2, "EXIT")) ? (byte) 1 : (byte) 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x013c, code lost:
    
        if (r6.equals("aspectFill") == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0143, code lost:
    
        if (r6.equals(io.bidmachine.iab.vast.tags.VastAttributes.FILL_COLOR) == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x014c, code lost:
    
        if (r6.equals("aspectFit") == false) goto L92;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C2630e8 a(Point point, Point point2, Point point3, Point point4, JSONObject jSONObject) {
        JSONObject optJSONObject;
        String a2;
        String str;
        String str2 = "none";
        String str3 = "#ff000000";
        String str4 = "straight";
        if (!jSONObject.isNull(OutlinedTextFieldKt.BorderId) && (optJSONObject = jSONObject.optJSONObject(OutlinedTextFieldKt.BorderId)) != null && !optJSONObject.isNull("style")) {
            String string = optJSONObject.getString("style");
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            str2 = e(string);
            if (!optJSONObject.isNull("corner")) {
                String string2 = optJSONObject.getString("corner");
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                str4 = d(string2);
            }
            if (!optJSONObject.isNull("color")) {
                String string3 = optJSONObject.getString("color");
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                int length = string3.length() - 1;
                int i = 0;
                boolean z = false;
                while (i <= length) {
                    boolean z2 = Intrinsics.compare((int) string3.charAt(!z ? i : length), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        }
                        length--;
                    } else if (z2) {
                        i++;
                    } else {
                        z = true;
                    }
                }
                str3 = I7.a(length, 1, string3, i);
            }
        }
        String str5 = str2;
        String str6 = str3;
        String str7 = str4;
        if (jSONObject.isNull("backgroundColor")) {
            a2 = "#00000000";
        } else {
            String string4 = jSONObject.getString("backgroundColor");
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            int length2 = string4.length() - 1;
            int i2 = 0;
            boolean z3 = false;
            while (i2 <= length2) {
                boolean z4 = Intrinsics.compare((int) string4.charAt(!z3 ? i2 : length2), 32) <= 0;
                if (z3) {
                    if (!z4) {
                        break;
                    }
                    length2--;
                } else if (z4) {
                    i2++;
                } else {
                    z3 = true;
                }
            }
            a2 = I7.a(length2, 1, string4, i2);
        }
        String str8 = a2;
        boolean isNull = jSONObject.isNull("contentMode");
        String str9 = VastAttributes.FILL_COLOR;
        if (!isNull) {
            String string5 = jSONObject.getString("contentMode");
            Intrinsics.checkNotNull(string5);
            int length3 = string5.length() - 1;
            int i3 = 0;
            boolean z5 = false;
            while (i3 <= length3) {
                boolean z6 = Intrinsics.compare((int) string5.charAt(!z5 ? i3 : length3), 32) <= 0;
                if (z5) {
                    if (!z6) {
                        break;
                    }
                    length3--;
                } else if (z6) {
                    i3++;
                } else {
                    z5 = true;
                }
            }
            String a3 = I7.a(length3, 1, string5, i3);
            int hashCode = a3.hashCode();
            if (hashCode == -1626174665) {
                a3.equals(BuildConfig.VERSION_NAME);
            } else {
                if (hashCode == -1362001767) {
                    str9 = "aspectFit";
                } else if (hashCode != 3143043) {
                    if (hashCode == 727618043) {
                        str9 = "aspectFill";
                    }
                }
                return new C2630e8(point.x, point.y, point2.x, point2.y, point3.x, point3.y, point4.x, point4.y, str, str5, str7, str6, str8, new P8(q(jSONObject.optJSONObject("startOffset")), q(jSONObject.optJSONObject("timerDuration"))));
            }
            str = BuildConfig.VERSION_NAME;
            return new C2630e8(point.x, point.y, point2.x, point2.y, point3.x, point3.y, point4.x, point4.y, str, str5, str7, str6, str8, new P8(q(jSONObject.optJSONObject("startOffset")), q(jSONObject.optJSONObject("timerDuration"))));
        }
        str = str9;
        return new C2630e8(point.x, point.y, point2.x, point2.y, point3.x, point3.y, point4.x, point4.y, str, str5, str7, str6, str8, new P8(q(jSONObject.optJSONObject("startOffset")), q(jSONObject.optJSONObject("timerDuration"))));
    }

    public final P8 a(JSONObject jSONObject) {
        return new P8(q(jSONObject.optJSONObject("startOffset")), q(jSONObject.optJSONObject("timerDuration")));
    }
}
