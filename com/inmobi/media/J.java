package com.inmobi.media;

import com.inmobi.ads.exceptions.VastException;
import com.inmobi.commons.core.configs.AdConfig;
import com.ironsource.C3040d4;
import io.ktor.http.LinkHeader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public abstract class J {

    /* renamed from: a, reason: collision with root package name */
    public static final String f2320a = "h";

    public static void a(C2672h ad, JSONObject adJson, String str, long j, InterfaceC2971z5 interfaceC2971z5) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(adJson, "adJson");
        ad.a();
        long optLong = adJson.optLong("expiry", TimeUnit.MILLISECONDS.toSeconds(j));
        ad.a(adJson, str, optLong <= 0 ? -1L : TimeUnit.SECONDS.toMillis(optLong));
        if (Intrinsics.areEqual("inmobiJson", ad.u())) {
            try {
                JSONObject jSONObject = adJson.getJSONObject("pubContent");
                if (interfaceC2971z5 != null) {
                    String TAG = f2320a;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    String jSONObject2 = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
                    ((A5) interfaceC2971z5).a(TAG, jSONObject2);
                }
                if (jSONObject.isNull("rootContainer")) {
                    if (interfaceC2971z5 != null) {
                        String TAG2 = f2320a;
                        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                        ((A5) interfaceC2971z5).b(TAG2, "Missing key (rootContainer) in the ad markup");
                        return;
                    }
                    return;
                }
                JSONObject jSONObject3 = jSONObject.getJSONObject("rootContainer");
                JSONArray jSONArray = new JSONArray();
                Intrinsics.checkNotNull(jSONObject3);
                Iterator it = b(jSONObject3, interfaceC2971z5).iterator();
                while (it.hasNext()) {
                    a(jSONArray, (String) it.next(), (byte) 2);
                }
                Iterator it2 = a(jSONObject3, interfaceC2971z5).iterator();
                while (it2.hasNext()) {
                    a(jSONArray, (String) it2.next(), (byte) 1);
                }
                boolean d = d(jSONObject3, interfaceC2971z5);
                ad.a(jSONArray);
                ad.a(d);
            } catch (Exception e) {
                Intrinsics.checkNotNullExpressionValue(f2320a, "TAG");
                S5 s5 = S5.f2425a;
                S5.d.a(AbstractC2920w5.a(e, "event"));
            }
        }
    }

    public static ArrayList b(JSONObject jSONObject, InterfaceC2971z5 interfaceC2971z5) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("assetValue");
            Intrinsics.checkNotNull(jSONArray);
            if (!B2.a(jSONArray)) {
                String string = jSONObject.getString("assetType");
                if (StringsKt.equals("image", string, true)) {
                    if (!jSONObject.isNull(LinkHeader.Rel.PreLoad) && jSONObject.getBoolean(LinkHeader.Rel.PreLoad)) {
                        String string2 = jSONArray.getString(0);
                        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        arrayList.add(string2);
                        return arrayList;
                    }
                } else if (StringsKt.equals("container", string, true)) {
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        Intrinsics.checkNotNull(jSONObject2);
                        arrayList.addAll(b(jSONObject2, interfaceC2971z5));
                    }
                }
            }
        } catch (JSONException e) {
            if (interfaceC2971z5 != null) {
                String str = f2320a;
                ((A5) interfaceC2971z5).b(str, H6.a(str, "TAG", "Error getting getImageAssetUrls (").append(e.getMessage()).append(')').toString());
            }
        }
        return arrayList;
    }

    public static String c(JSONObject jSONObject, InterfaceC2971z5 interfaceC2971z5) {
        String str;
        String str2;
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("assetValue");
            Intrinsics.checkNotNull(jSONArray);
            if (B2.a(jSONArray)) {
                return "";
            }
            String string = jSONObject.getString("assetType");
            if (StringsKt.equals("video", string, true)) {
                str = jSONArray.getString(0);
            } else {
                if (StringsKt.equals("container", string, true)) {
                    int length = jSONArray.length();
                    str2 = "";
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        Intrinsics.checkNotNull(jSONObject2);
                        str2 = c(jSONObject2, interfaceC2971z5);
                        int length2 = str2.length() - 1;
                        int i2 = 0;
                        boolean z = false;
                        while (i2 <= length2) {
                            boolean z2 = Intrinsics.compare((int) str2.charAt(!z ? i2 : length2), 32) <= 0;
                            if (z) {
                                if (!z2) {
                                    break;
                                }
                                length2--;
                            } else if (z2) {
                                i2++;
                            } else {
                                z = true;
                            }
                        }
                        if (str2.subSequence(i2, length2 + 1).toString().length() > 0) {
                            break;
                        }
                    }
                    Intrinsics.checkNotNull(str2);
                    return str2;
                }
                str = "";
            }
            str2 = str;
            Intrinsics.checkNotNull(str2);
            return str2;
        } catch (JSONException e) {
            if (interfaceC2971z5 != null) {
                String str3 = f2320a;
                ((A5) interfaceC2971z5).b(str3, H6.a(str3, "TAG", "Error getting VAST video XML (").append(e.getMessage()).append(')').toString());
            }
            S5 s5 = S5.f2425a;
            C2640f2 event = new C2640f2(e);
            Intrinsics.checkNotNullParameter(event, "event");
            S5.d.a(event);
            return "";
        }
    }

    public static boolean d(JSONObject jSONObject, InterfaceC2971z5 interfaceC2971z5) {
        JSONArray jSONArray;
        try {
            jSONArray = jSONObject.getJSONArray("assetValue");
            Intrinsics.checkNotNull(jSONArray);
        } catch (JSONException e) {
            if (interfaceC2971z5 != null) {
                String str = f2320a;
                ((A5) interfaceC2971z5).b(str, H6.a(str, "TAG", "Error getting preload webview flag (").append(e.getMessage()).append(')').toString());
            }
            S5 s5 = S5.f2425a;
            C2640f2 event = new C2640f2(e);
            Intrinsics.checkNotNullParameter(event, "event");
            S5.d.a(event);
        }
        if (B2.a(jSONArray)) {
            return false;
        }
        String string = jSONObject.getString("assetType");
        if (StringsKt.equals(C3040d4.h.K, string, true)) {
            if (!jSONObject.isNull(LinkHeader.Rel.PreLoad) && jSONObject.getBoolean(LinkHeader.Rel.PreLoad)) {
                return true;
            }
        } else if (StringsKt.equals("container", string, true)) {
            int length = jSONArray.length();
            boolean z = false;
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                Intrinsics.checkNotNull(jSONObject2);
                z = d(jSONObject2, interfaceC2971z5);
                if (z) {
                    return z;
                }
            }
            return z;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x01e4 A[Catch: JSONException -> 0x0203, TryCatch #0 {JSONException -> 0x0203, blocks: (B:107:0x01d9, B:109:0x01e4, B:111:0x01ee), top: B:106:0x01d9 }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x023a A[Catch: JSONException -> 0x0259, TryCatch #1 {JSONException -> 0x0259, blocks: (B:130:0x022f, B:132:0x023a, B:134:0x0244), top: B:129:0x022f }] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final C2672h a(C2672h ad, AdConfig adConfig, InterfaceC2971z5 interfaceC2971z5) {
        byte b;
        Iterator it;
        Iterator it2;
        Iterator it3;
        String b2;
        int length;
        int i;
        int length2;
        int i2;
        int i3;
        int i4;
        char c;
        int i5;
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        if (Intrinsics.areEqual("inmobiJson", ad.u())) {
            JSONObject jSONObject = new JSONObject(ad.x());
            JSONObject jSONObject2 = jSONObject.getJSONObject("rootContainer");
            Intrinsics.checkNotNull(jSONObject2);
            String c2 = c(jSONObject2, interfaceC2971z5);
            int length3 = c2.length() - 1;
            int i6 = 0;
            int i7 = 0;
            boolean z = false;
            while (i7 <= length3) {
                boolean z2 = Intrinsics.compare((int) c2.charAt(!z ? i7 : length3), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    }
                    length3--;
                } else if (z2) {
                    i7++;
                } else {
                    z = true;
                }
            }
            if (c2.subSequence(i7, length3 + 1).toString().length() != 0) {
                Ue a2 = new Pe(adConfig.getVastVideo(), interfaceC2971z5).a(c2);
                JSONArray k = ad.k();
                if (a2.l != 0) {
                    if (interfaceC2971z5 != null) {
                        String TAG = f2320a;
                        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                        ((A5) interfaceC2971z5).b(TAG, "Processing VAST XML to build a video descriptor failed");
                    }
                    throw new VastException(a2.l);
                }
                String b3 = a2.b();
                if (b3 != null && b3.length() != 0) {
                    if (k != null) {
                        a(k, b3, (byte) 0);
                    }
                    AdConfig.VastVideoConfig vastVideo = adConfig.getVastVideo();
                    ArrayList arrayList = new ArrayList();
                    try {
                        JSONArray jSONArray = jSONObject.getJSONArray("pages");
                        b = 1;
                        try {
                            int length4 = jSONArray.length();
                            while (i6 < length4) {
                                if (jSONArray.getJSONObject(i6).isNull("rootContainer")) {
                                    i3 = length4;
                                    i4 = i6;
                                    c = ' ';
                                } else {
                                    JSONObject jSONObject3 = jSONArray.getJSONObject(i6).getJSONObject("rootContainer");
                                    Intrinsics.checkNotNullExpressionValue(jSONObject3, "getJSONObject(...)");
                                    String c3 = c(jSONObject3, interfaceC2971z5);
                                    i3 = length4;
                                    int length5 = c3.length() - 1;
                                    int i8 = 0;
                                    boolean z3 = false;
                                    while (true) {
                                        i5 = length5;
                                        if (i8 > length5) {
                                            i4 = i6;
                                            c = ' ';
                                            break;
                                        }
                                        if (!z3) {
                                            length5 = i8;
                                        }
                                        i4 = i6;
                                        c = ' ';
                                        boolean z4 = Intrinsics.compare((int) c3.charAt(length5), 32) <= 0;
                                        if (!z3) {
                                            if (z4) {
                                                i8++;
                                            } else {
                                                z3 = true;
                                            }
                                            length5 = i5;
                                        } else {
                                            if (!z4) {
                                                break;
                                            }
                                            length5 = i5 - 1;
                                        }
                                        i6 = i4;
                                    }
                                    if (c3.subSequence(i8, i5 + 1).toString().length() != 0) {
                                        Ue a3 = new Pe(vastVideo, interfaceC2971z5).a(c3);
                                        if (a3.l == 0) {
                                            String b4 = a3.b();
                                            if (b4 != null && !arrayList.isEmpty()) {
                                                arrayList.add(b4);
                                            }
                                        } else if (interfaceC2971z5 != null) {
                                            String TAG2 = f2320a;
                                            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                                            ((A5) interfaceC2971z5).b(TAG2, "No video present of error for video descriptor in pages array");
                                        }
                                    } else if (interfaceC2971z5 != null) {
                                        String TAG3 = f2320a;
                                        Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                                        ((A5) interfaceC2971z5).b(TAG3, "Missing VAST video XML in the ad markup");
                                    }
                                }
                                length4 = i3;
                                i6 = i4 + 1;
                            }
                        } catch (JSONException e) {
                            e = e;
                            if (interfaceC2971z5 != null) {
                                String TAG4 = f2320a;
                                Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
                                ((A5) interfaceC2971z5).a(TAG4, "JSONException in getPagesVideo", e);
                            }
                            if (interfaceC2971z5 != null) {
                            }
                            it = arrayList.iterator();
                            while (it.hasNext()) {
                            }
                            ArrayList arrayList2 = new ArrayList();
                            JSONArray jSONArray2 = jSONObject.getJSONArray("pages");
                            length2 = jSONArray2.length();
                            while (i2 < length2) {
                            }
                            it2 = arrayList2.iterator();
                            while (it2.hasNext()) {
                            }
                            ArrayList arrayList3 = new ArrayList();
                            JSONArray jSONArray3 = jSONObject.getJSONArray("pages");
                            length = jSONArray3.length();
                            while (i < length) {
                            }
                            it3 = arrayList3.iterator();
                            while (it3.hasNext()) {
                            }
                            b2 = a2.b();
                            String str = a2.g;
                            if (b2 != null) {
                            }
                            return null;
                        }
                    } catch (JSONException e2) {
                        e = e2;
                        b = 1;
                    }
                    if (interfaceC2971z5 != null) {
                        String str2 = f2320a;
                        ((A5) interfaceC2971z5).a(str2, H6.a(str2, "TAG", "Media size for pages ").append(arrayList.size()).toString());
                    }
                    it = arrayList.iterator();
                    while (it.hasNext()) {
                        String str3 = (String) it.next();
                        if (k != null) {
                            a(k, str3, (byte) 0);
                        }
                    }
                    ArrayList arrayList22 = new ArrayList();
                    try {
                        JSONArray jSONArray22 = jSONObject.getJSONArray("pages");
                        length2 = jSONArray22.length();
                        for (i2 = 0; i2 < length2; i2++) {
                            if (!jSONArray22.getJSONObject(i2).isNull("rootContainer")) {
                                JSONObject jSONObject4 = jSONArray22.getJSONObject(i2).getJSONObject("rootContainer");
                                Intrinsics.checkNotNullExpressionValue(jSONObject4, "getJSONObject(...)");
                                arrayList22.addAll(b(jSONObject4, interfaceC2971z5));
                            }
                        }
                    } catch (JSONException e3) {
                        if (interfaceC2971z5 != null) {
                            String TAG5 = f2320a;
                            Intrinsics.checkNotNullExpressionValue(TAG5, "TAG");
                            ((A5) interfaceC2971z5).a(TAG5, "JSONException in getPagesImage", e3);
                        }
                    }
                    it2 = arrayList22.iterator();
                    while (it2.hasNext()) {
                        String str4 = (String) it2.next();
                        if (k != null) {
                            a(k, str4, (byte) 2);
                        }
                    }
                    ArrayList arrayList32 = new ArrayList();
                    try {
                        JSONArray jSONArray32 = jSONObject.getJSONArray("pages");
                        length = jSONArray32.length();
                        for (i = 0; i < length; i++) {
                            if (!jSONArray32.getJSONObject(i).isNull("rootContainer")) {
                                JSONObject jSONObject5 = jSONArray32.getJSONObject(i).getJSONObject("rootContainer");
                                Intrinsics.checkNotNullExpressionValue(jSONObject5, "getJSONObject(...)");
                                arrayList32.addAll(a(jSONObject5, interfaceC2971z5));
                            }
                        }
                    } catch (JSONException e4) {
                        if (interfaceC2971z5 != null) {
                            String TAG6 = f2320a;
                            Intrinsics.checkNotNullExpressionValue(TAG6, "TAG");
                            ((A5) interfaceC2971z5).a(TAG6, "JSONException in getPagesGif", e4);
                        }
                    }
                    it3 = arrayList32.iterator();
                    while (it3.hasNext()) {
                        String str5 = (String) it3.next();
                        if (k != null) {
                            a(k, str5, b);
                        }
                    }
                    b2 = a2.b();
                    String str6 = a2.g;
                    if (b2 != null || str6 == null) {
                        return null;
                    }
                    return new W8(ad, k, b2, str6, a2.k, a2.h, a2.i);
                }
                if (interfaceC2971z5 != null) {
                    String TAG7 = f2320a;
                    Intrinsics.checkNotNullExpressionValue(TAG7, "TAG");
                    ((A5) interfaceC2971z5).b(TAG7, "No Media URL to download.Returning..");
                }
                throw new VastException(401);
            }
            if (interfaceC2971z5 != null) {
                String TAG8 = f2320a;
                Intrinsics.checkNotNullExpressionValue(TAG8, "TAG");
                ((A5) interfaceC2971z5).b(TAG8, "Missing VAST video XML in the ad markup");
            }
        }
        return ad;
    }

    public static void a(JSONArray jSONArray, String str, byte b) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", (int) b);
        jSONObject.put("url", str);
        jSONArray.put(jSONObject);
    }

    public static ArrayList a(JSONObject jSONObject, InterfaceC2971z5 interfaceC2971z5) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("assetValue");
            Intrinsics.checkNotNull(jSONArray);
            if (!B2.a(jSONArray)) {
                String string = jSONObject.getString("assetType");
                if (StringsKt.equals("gif", string, true)) {
                    String string2 = jSONArray.getString(0);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    arrayList.add(string2);
                    return arrayList;
                }
                if (StringsKt.equals("container", string, true)) {
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        Intrinsics.checkNotNull(jSONObject2);
                        arrayList.addAll(a(jSONObject2, interfaceC2971z5));
                    }
                }
            }
        } catch (JSONException e) {
            if (interfaceC2971z5 != null) {
                String str = f2320a;
                ((A5) interfaceC2971z5).b(str, H6.a(str, "TAG", "Error getting getGifAssetUrls (").append(e.getMessage()).append(')').toString());
            }
        }
        return arrayList;
    }
}
