package com.inmobi.media;

import com.adjust.sdk.Constants;
import com.inmobi.ads.core.Trackers;
import com.inmobi.ads.core.TrackingInfo;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.x0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2931x0 {
    public static C2825q6 a() {
        return new C2825q6().a(new Ec(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS, C2947y0.class), (Dc) new U6(new C2850s0(), C2672h.class)).a(new Ec("trackingInfo", C2672h.class), (Dc) new U6(new C2867t0(), TrackingInfo.class)).a(new Ec(Constants.ADJUST_PREINSTALL_CONTENT_URI_PATH, TrackingInfo.class), (Dc) new U6(new C2883u0(), Trackers.class)).a(new Ec("url", Trackers.class), (Dc) new U6(new C2899v0(), String.class)).a(new Ec("imExts", Trackers.class), (Dc) new U6(new C2915w0(), String.class));
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0154 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f2 A[Catch: JSONException -> 0x0168, TRY_ENTER, TryCatch #2 {JSONException -> 0x0168, blocks: (B:3:0x0011, B:6:0x0028, B:9:0x0036, B:12:0x0047, B:14:0x0056, B:16:0x0068, B:18:0x0072, B:20:0x0087, B:21:0x0094, B:23:0x009a, B:25:0x00a2, B:26:0x00a5, B:46:0x00f2, B:47:0x0102, B:38:0x0120, B:39:0x0149, B:41:0x0154, B:55:0x015b, B:60:0x0021), top: B:2:0x0011 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C2947y0 a(JSONObject adContent, long j, String str, String requestId, InterfaceC2971z5 interfaceC2971z5) {
        String str2;
        long millis;
        JSONArray jSONArray;
        C2672h c2672h;
        String str3;
        String str4;
        C2672h c2672h2;
        String str5;
        String str6;
        String str7;
        Intrinsics.checkNotNullParameter(adContent, "adContent");
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        try {
            long optLong = adContent.optLong("expiry", -1L);
            millis = optLong > 0 ? TimeUnit.SECONDS.toMillis(optLong) : -1L;
            jSONArray = adContent.getJSONArray(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS);
        } catch (JSONException e) {
            if (interfaceC2971z5 != null) {
                str2 = C2947y0.TAG;
                Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$cp(...)");
                ((A5) interfaceC2971z5).a(str2, "Exception while inflating AdSet", e);
            }
        }
        if (jSONArray.length() == 0) {
            if (interfaceC2971z5 != null) {
                str7 = C2947y0.TAG;
                Intrinsics.checkNotNullExpressionValue(str7, "access$getTAG$cp(...)");
                ((A5) interfaceC2971z5).b(str7, "no ads");
            }
            return null;
        }
        C2947y0 c2947y0 = (C2947y0) a().a(adContent, C2947y0.class);
        if (interfaceC2971z5 != null) {
            str6 = C2947y0.TAG;
            Intrinsics.checkNotNullExpressionValue(str6, "access$getTAG$cp(...)");
            ((A5) interfaceC2971z5).a(str6, "adSet parsing success");
        }
        if (c2947y0 != null && c2947y0.c().length() > 0) {
            c2947y0.placementId = j;
            c2947y0.requestId = requestId;
            String str8 = str;
            c2947y0.adType = str8;
            int length = jSONArray.length();
            int i = 0;
            while (i < length) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                Iterator<T> it = c2947y0.f().iterator();
                int i2 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    C2672h c2672h3 = (C2672h) next;
                    if (Intrinsics.areEqual(jSONObject.optString("impressionId"), c2672h3.s())) {
                        if (interfaceC2971z5 != null) {
                            try {
                                str4 = C2947y0.TAG;
                                Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$cp(...)");
                                ((A5) interfaceC2971z5).a(str4, "inflating ad at index - " + i2);
                            } catch (Exception e2) {
                                e = e2;
                                c2672h2 = c2672h3;
                                if (interfaceC2971z5 != null) {
                                    str5 = C2947y0.TAG;
                                    Intrinsics.checkNotNullExpressionValue(str5, "access$getTAG$cp(...)");
                                    ((A5) interfaceC2971z5).a(str5, "Error inflating ad", e);
                                }
                                S5 s5 = S5.f2425a;
                                C2640f2 event = new C2640f2(e);
                                Intrinsics.checkNotNullParameter(event, "event");
                                S5.d.a(event);
                                c2672h = c2672h2;
                                if (c2672h != null) {
                                }
                                i++;
                                str8 = str;
                            }
                        }
                        String str9 = J.f2320a;
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        Intrinsics.checkNotNullExpressionValue(jSONObject2, "getJSONObject(...)");
                        c2672h2 = c2672h3;
                        try {
                            J.a(c2672h2, jSONObject2, str8, millis, interfaceC2971z5);
                        } catch (Exception e3) {
                            e = e3;
                            if (interfaceC2971z5 != null) {
                            }
                            S5 s52 = S5.f2425a;
                            C2640f2 event2 = new C2640f2(e);
                            Intrinsics.checkNotNullParameter(event2, "event");
                            S5.d.a(event2);
                            c2672h = c2672h2;
                            if (c2672h != null) {
                            }
                            i++;
                            str8 = str;
                        }
                    } else {
                        str8 = str;
                        i2 = i3;
                    }
                }
                c2672h = null;
                if (c2672h != null) {
                    if (interfaceC2971z5 != null) {
                        str3 = C2947y0.TAG;
                        Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$cp(...)");
                        ((A5) interfaceC2971z5).b(str3, "removing invalid ad  at index - " + CollectionsKt.indexOf((List<? extends C2672h>) c2947y0.f(), c2672h));
                    }
                    TypeIntrinsics.asMutableCollection(c2947y0.f()).remove(c2672h);
                }
                i++;
                str8 = str;
            }
            if (!c2947y0.f().isEmpty()) {
                return c2947y0;
            }
        }
        return null;
    }
}
