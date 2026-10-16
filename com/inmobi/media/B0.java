package com.inmobi.media;

import android.os.Build;
import android.os.SystemClock;
import androidx.exifinterface.media.ExifInterface;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.ironsource.C3040d4;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class B0 {

    /* renamed from: a, reason: collision with root package name */
    public final S0 f2239a;
    public final S0 b;
    public final Z c;
    public final String d;
    public long e;
    public InterfaceC2971z5 f;
    public final A0 g;
    public final C2966z0 h;

    public B0(S0 mAdStoreListener, S0 mTelemetryListener, Z mAdPlacement) {
        Intrinsics.checkNotNullParameter(mAdStoreListener, "mAdStoreListener");
        Intrinsics.checkNotNullParameter(mTelemetryListener, "mTelemetryListener");
        Intrinsics.checkNotNullParameter(mAdPlacement, "mAdPlacement");
        this.f2239a = mAdStoreListener;
        this.b = mTelemetryListener;
        this.c = mAdPlacement;
        this.d = "B0";
        this.g = new A0(this);
        this.h = new C2966z0(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C2947y0 a(T mRequest, Integer num) {
        V adNetworkResponse;
        P9 b;
        Intrinsics.checkNotNullParameter(mRequest, "networkRequest");
        if (num != null && SystemClock.elapsedRealtime() - this.e < num.intValue() * 1000) {
            throw new K(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.EARLY_REFRESH_REQUEST), (short) 2009);
        }
        if (mRequest != null) {
            Map map = mRequest.D;
            if (map == null) {
                map = new HashMap();
            }
            mRequest.D = map;
        }
        this.e = SystemClock.elapsedRealtime();
        Intrinsics.checkNotNullParameter(mRequest, "mAdNetworkRequest");
        try {
            Intrinsics.checkNotNullParameter(mRequest, "mRequest");
            b = mRequest.b();
            adNetworkResponse = new V(b);
        } catch (Exception unused) {
            adNetworkResponse = null;
        }
        try {
            if (b.b()) {
                Intrinsics.checkNotNullExpressionValue(ExifInterface.LATITUDE_SOUTH, "TAG");
            }
        } catch (Exception unused2) {
            Intrinsics.checkNotNullExpressionValue(ExifInterface.LATITUDE_SOUTH, "TAG");
            if (adNetworkResponse == null) {
            }
            if (adNetworkResponse != null) {
            }
        }
        I9 i9 = adNetworkResponse == null ? adNetworkResponse.f2456a.d : null;
        if (adNetworkResponse != null) {
            a(MapsKt.mutableMapOf(TuplesKt.to(IronSourceConstants.EVENTS_ERROR_CODE, (short) 2108)));
            throw new K(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), (short) 0);
        }
        if (i9 != null) {
            a(MapsKt.mutableMapOf(TuplesKt.to(IronSourceConstants.EVENTS_ERROR_CODE, i9.f2315a.toString())));
            InMobiAdRequestStatus inMobiAdRequestStatus = adNetworkResponse.b;
            if (inMobiAdRequestStatus == null) {
                return null;
            }
            throw new K(inMobiAdRequestStatus, (short) 0);
        }
        Intrinsics.checkNotNullParameter(adNetworkResponse, "adNetworkResponse");
        this.f2239a.g0();
        try {
            return a(new JSONObject(adNetworkResponse.f2456a.a()));
        } catch (JSONException e) {
            a(MapsKt.mutableMapOf(TuplesKt.to(IronSourceConstants.EVENTS_ERROR_CODE, (short) 2113)));
            InterfaceC2971z5 interfaceC2971z5 = this.f;
            if (interfaceC2971z5 != null) {
                String TAG = this.d;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((A5) interfaceC2971z5).a(TAG, "Error while parsing ad response.", e);
            }
            throw new K(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), (short) 0);
        }
    }

    public static String a() {
        String b = Uc.b();
        if (b == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        LinkedHashMap linkedHashMap = O2.f2380a;
        jSONObject.put("root", M2.a("root", b, null).getLastUpdateTimeStamp());
        jSONObject.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS, M2.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS, b, null).getLastUpdateTimeStamp());
        jSONObject.put("telemetry", M2.a("telemetry", b, null).getLastUpdateTimeStamp());
        jSONObject.put("crashReporting", M2.a("crashReporting", b, null).getLastUpdateTimeStamp());
        jSONObject.put("signals", M2.a("signals", b, null).getLastUpdateTimeStamp());
        return jSONObject.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0325 A[Catch: JSONException -> 0x043c, TryCatch #3 {JSONException -> 0x043c, blocks: (B:16:0x0321, B:18:0x0325, B:19:0x0331, B:21:0x033f, B:23:0x0343, B:24:0x034f, B:26:0x0357, B:53:0x0382, B:55:0x0386, B:56:0x0392, B:57:0x03b6, B:59:0x03b7, B:61:0x03bb, B:62:0x03d2, B:64:0x0415, B:65:0x041a, B:67:0x0422, B:68:0x0427, B:69:0x043b), top: B:15:0x0321 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x033f A[Catch: JSONException -> 0x043c, TryCatch #3 {JSONException -> 0x043c, blocks: (B:16:0x0321, B:18:0x0325, B:19:0x0331, B:21:0x033f, B:23:0x0343, B:24:0x034f, B:26:0x0357, B:53:0x0382, B:55:0x0386, B:56:0x0392, B:57:0x03b6, B:59:0x03b7, B:61:0x03bb, B:62:0x03d2, B:64:0x0415, B:65:0x041a, B:67:0x0422, B:68:0x0427, B:69:0x043b), top: B:15:0x0321 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x03b7 A[Catch: JSONException -> 0x043c, TryCatch #3 {JSONException -> 0x043c, blocks: (B:16:0x0321, B:18:0x0325, B:19:0x0331, B:21:0x033f, B:23:0x0343, B:24:0x034f, B:26:0x0357, B:53:0x0382, B:55:0x0386, B:56:0x0392, B:57:0x03b6, B:59:0x03b7, B:61:0x03bb, B:62:0x03d2, B:64:0x0415, B:65:0x041a, B:67:0x0422, B:68:0x0427, B:69:0x043b), top: B:15:0x0321 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02d0 A[Catch: JSONException -> 0x0302, TryCatch #1 {JSONException -> 0x0302, blocks: (B:11:0x02c9, B:74:0x02d0, B:76:0x02e1, B:77:0x02f8, B:79:0x02fc), top: B:10:0x02c9 }] */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r17v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C2947y0 a(JSONObject jSONObject) {
        ?? r17;
        String str;
        Object obj;
        InterfaceC2971z5 interfaceC2971z5;
        JSONArray jSONArray;
        String string;
        C2947y0 c2947y0;
        JSONArray jSONArray2;
        JSONArray jSONArray3;
        InterfaceC2971z5 interfaceC2971z52;
        try {
            InterfaceC2971z5 interfaceC2971z53 = this.f;
            if (interfaceC2971z53 != null) {
                String TAG = this.d;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((A5) interfaceC2971z53).c(TAG, "response - " + jSONObject);
            }
            JSONArray jSONArray4 = jSONObject.getJSONArray("adSets");
            Intrinsics.checkNotNullExpressionValue(jSONArray4, "getJSONArray(...)");
            if (B2.a(jSONArray4)) {
                obj = "networkType";
                str = "adType";
            } else {
                JSONObject jSONObject2 = jSONObject.getJSONArray("adSets").getJSONObject(0);
                InterfaceC2971z5 interfaceC2971z54 = this.f;
                if (interfaceC2971z54 != null) {
                    String optString = jSONObject.optString(C2947y0.KEY_REQUEST_ID);
                    Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
                    ((A5) interfaceC2971z54).e("requestID", optString);
                }
                InterfaceC2971z5 interfaceC2971z55 = this.f;
                if (interfaceC2971z55 != null) {
                    String optString2 = jSONObject.optString("placementId");
                    Intrinsics.checkNotNullExpressionValue(optString2, "optString(...)");
                    ((A5) interfaceC2971z55).e("placementID", optString2);
                }
                InterfaceC2971z5 interfaceC2971z56 = this.f;
                if (interfaceC2971z56 != null) {
                    ((A5) interfaceC2971z56).e("adType", String.valueOf(this.c.b()));
                }
                InterfaceC2971z5 interfaceC2971z57 = this.f;
                if (interfaceC2971z57 != null) {
                    ((A5) interfaceC2971z57).e("placementType", String.valueOf(this.c.m()));
                }
                InterfaceC2971z5 interfaceC2971z58 = this.f;
                if (interfaceC2971z58 != null) {
                    ((A5) interfaceC2971z58).e("bundleID", String.valueOf(C2623e1.f2554a));
                }
                InterfaceC2971z5 interfaceC2971z59 = this.f;
                if (interfaceC2971z59 != null) {
                    ((A5) interfaceC2971z59).e(C3040d4.i.n, L3.f2348a.c().getSecond());
                }
                InterfaceC2971z5 interfaceC2971z510 = this.f;
                if (interfaceC2971z510 != null) {
                    ((A5) interfaceC2971z510).e("networkType", L3.q());
                }
                InterfaceC2971z5 interfaceC2971z511 = this.f;
                if (interfaceC2971z511 != null) {
                    String MODEL = Build.MODEL;
                    Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                    ((A5) interfaceC2971z511).e("deviceModel", MODEL);
                }
                InterfaceC2971z5 interfaceC2971z512 = this.f;
                if (interfaceC2971z512 != null) {
                    ((A5) interfaceC2971z512).e("publisherID", String.valueOf(Uc.b()));
                }
                InterfaceC2971z5 interfaceC2971z513 = this.f;
                if (interfaceC2971z513 != null) {
                    ((A5) interfaceC2971z513).e("sdkAdPod", String.valueOf(jSONObject2.optBoolean("isPod")));
                }
                InterfaceC2971z5 interfaceC2971z514 = this.f;
                if (interfaceC2971z514 != null) {
                    ((A5) interfaceC2971z514).e("sdkVersion", "10.8.7");
                }
                InterfaceC2971z5 interfaceC2971z515 = this.f;
                if (interfaceC2971z515 != null) {
                    ((A5) interfaceC2971z515).e("tpName", String.valueOf(Vc.d()));
                }
                InterfaceC2971z5 interfaceC2971z516 = this.f;
                if (interfaceC2971z516 != null) {
                    ((A5) interfaceC2971z516).e("tpVersion", String.valueOf(Vc.f()));
                }
                InterfaceC2971z5 interfaceC2971z517 = this.f;
                if (interfaceC2971z517 != null) {
                    ((A5) interfaceC2971z517).e("source", "sdk_android");
                }
                InterfaceC2971z5 interfaceC2971z518 = this.f;
                if (interfaceC2971z518 != null) {
                    ((A5) interfaceC2971z518).e("mkVersion", Vc.a());
                }
                InterfaceC2971z5 interfaceC2971z519 = this.f;
                if (interfaceC2971z519 != null) {
                    ((A5) interfaceC2971z519).e("isServerSideLogging", String.valueOf(jSONObject2.optBoolean("logEnabled", false)));
                }
                InterfaceC2971z5 interfaceC2971z520 = this.f;
                if (interfaceC2971z520 != null) {
                    String optString3 = jSONObject2.optString("transactionId", "Not Set");
                    Intrinsics.checkNotNullExpressionValue(optString3, "optString(...)");
                    ((A5) interfaceC2971z520).e("transactionID", optString3);
                }
                InterfaceC2971z5 interfaceC2971z521 = this.f;
                if (interfaceC2971z521 != null) {
                    ((A5) interfaceC2971z521).e("webViewUserAgent", Uc.k());
                }
                String a2 = a();
                if (a2 != null && (interfaceC2971z52 = this.f) != null) {
                    ((A5) interfaceC2971z52).e("configData", a2);
                }
                r17 = jSONObject2.optBoolean("isPod");
                str = "adType";
                try {
                    if (r17 == 0) {
                        Object obj2 = "networkType";
                        if (jSONObject2.has(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS) && (jSONArray3 = jSONObject2.getJSONArray(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS)) != null && !B2.a(jSONArray3)) {
                            InterfaceC2971z5 interfaceC2971z522 = this.f;
                            if (interfaceC2971z522 != null) {
                                String optString4 = jSONObject2.getJSONArray(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS).getJSONObject(0).optString("creativeId");
                                Intrinsics.checkNotNullExpressionValue(optString4, "optString(...)");
                                ((A5) interfaceC2971z522).e("creativeID", optString4);
                            }
                            InterfaceC2971z5 interfaceC2971z523 = this.f;
                            obj = obj2;
                            if (interfaceC2971z523 != null) {
                                String optString5 = jSONObject2.getJSONArray(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS).getJSONObject(0).optString("impressionId");
                                Intrinsics.checkNotNullExpressionValue(optString5, "optString(...)");
                                ((A5) interfaceC2971z523).e("impressionID", optString5);
                                obj = obj2;
                            }
                        }
                        InterfaceC2971z5 interfaceC2971z524 = this.f;
                        obj = obj2;
                        if (interfaceC2971z524 != null) {
                            String TAG2 = this.d;
                            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                            ((A5) interfaceC2971z524).b(TAG2, "no ads. cannot update vitals");
                            obj = obj2;
                        }
                    } else {
                        try {
                            ArrayList arrayList = new ArrayList();
                            Object obj3 = "networkType";
                            ArrayList arrayList2 = new ArrayList();
                            if (jSONObject2.has(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS) && (jSONArray2 = jSONObject2.getJSONArray(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS)) != null && !B2.a(jSONArray2)) {
                                JSONArray jSONArray5 = jSONObject2.getJSONArray(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS);
                                int i = 0;
                                for (int length = jSONArray5.length(); i < length; length = length) {
                                    arrayList.add(i, jSONArray5.getJSONObject(i).optString("creativeId"));
                                    arrayList2.add(i, jSONArray5.getJSONObject(i).optString("impressionId"));
                                    i++;
                                }
                                InterfaceC2971z5 interfaceC2971z525 = this.f;
                                if (interfaceC2971z525 != null) {
                                    ((A5) interfaceC2971z525).e("creativeID", CollectionsKt.joinToString$default(arrayList, " , ", null, null, 0, null, null, 62, null));
                                }
                                InterfaceC2971z5 interfaceC2971z526 = this.f;
                                obj = obj3;
                                if (interfaceC2971z526 != null) {
                                    ((A5) interfaceC2971z526).e("impressionID", CollectionsKt.joinToString$default(arrayList2, " , ", null, null, 0, null, null, 62, null));
                                    obj = obj3;
                                }
                            }
                            InterfaceC2971z5 interfaceC2971z527 = this.f;
                            obj = obj3;
                            if (interfaceC2971z527 != null) {
                                String TAG3 = this.d;
                                Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                                ((A5) interfaceC2971z527).b(TAG3, "no ads. cannot update vitals");
                                obj = obj3;
                            }
                        } catch (JSONException e) {
                            e = e;
                            r17 = "networkType";
                            InterfaceC2971z5 interfaceC2971z528 = this.f;
                            obj = r17;
                            if (interfaceC2971z528 != null) {
                                String TAG4 = this.d;
                                Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
                                ((A5) interfaceC2971z528).a(TAG4, "error while update vitals", e);
                                obj = r17;
                            }
                            if (jSONObject.optJSONArray("adSets") == null) {
                            }
                            C2947y0 c2947y02 = null;
                            interfaceC2971z5 = this.f;
                            if (interfaceC2971z5 != null) {
                            }
                            jSONArray = jSONObject.getJSONArray("adSets");
                            string = jSONObject.getString(C2947y0.KEY_REQUEST_ID);
                            if (jSONArray.length() == 0) {
                            }
                        }
                    }
                } catch (JSONException e2) {
                    e = e2;
                }
            }
        } catch (JSONException e3) {
            e = e3;
            r17 = "networkType";
            str = "adType";
        }
        try {
            if (jSONObject.optJSONArray("adSets") == null) {
                boolean optBoolean = jSONObject.getJSONArray("adSets").getJSONObject(0).optBoolean("logEnabled", false);
                InterfaceC2971z5 interfaceC2971z529 = this.f;
                if (interfaceC2971z529 != null) {
                    String TAG5 = this.d;
                    Intrinsics.checkNotNullExpressionValue(TAG5, "TAG");
                    ((A5) interfaceC2971z529).a(TAG5, "server side logger lever - " + optBoolean);
                }
                InterfaceC2971z5 interfaceC2971z530 = this.f;
                if (interfaceC2971z530 != null) {
                    ((A5) interfaceC2971z530).a(optBoolean);
                }
            }
        } catch (JSONException e4) {
            InterfaceC2971z5 interfaceC2971z531 = this.f;
            if (interfaceC2971z531 != null) {
                String TAG6 = this.d;
                Intrinsics.checkNotNullExpressionValue(TAG6, "TAG");
                ((A5) interfaceC2971z531).a(TAG6, "error while setting server-side logging lever", e4);
            }
            InterfaceC2971z5 interfaceC2971z532 = this.f;
            if (interfaceC2971z532 != null) {
                ((A5) interfaceC2971z532).a(false);
            }
        }
        C2947y0 c2947y022 = null;
        try {
            interfaceC2971z5 = this.f;
            if (interfaceC2971z5 != null) {
                String TAG7 = this.d;
                Intrinsics.checkNotNullExpressionValue(TAG7, "TAG");
                ((A5) interfaceC2971z5).c(TAG7, "parseAdResponse called");
            }
            jSONArray = jSONObject.getJSONArray("adSets");
            string = jSONObject.getString(C2947y0.KEY_REQUEST_ID);
        } catch (JSONException e5) {
            InterfaceC2971z5 interfaceC2971z533 = this.f;
            if (interfaceC2971z533 != null) {
                String TAG8 = this.d;
                Intrinsics.checkNotNullExpressionValue(TAG8, "TAG");
                ((A5) interfaceC2971z533).a(TAG8, "Error while parsing ad response.", e5);
            }
        }
        if (jSONArray.length() == 0) {
            InterfaceC2971z5 interfaceC2971z534 = this.f;
            if (interfaceC2971z534 != null) {
                String TAG9 = this.d;
                Intrinsics.checkNotNullExpressionValue(TAG9, "TAG");
                ((A5) interfaceC2971z534).a(TAG9, "parseAdResponse responses available");
            }
            if (this.c.b() != null) {
                C2931x0 c2931x0 = C2947y0.Companion;
                JSONObject jSONObject3 = jSONArray.getJSONObject(0);
                Intrinsics.checkNotNullExpressionValue(jSONObject3, "getJSONObject(...)");
                long l = this.c.l();
                String b = this.c.b();
                Intrinsics.checkNotNull(string);
                InterfaceC2971z5 interfaceC2971z535 = this.f;
                c2931x0.getClass();
                c2947y0 = C2931x0.a(jSONObject3, l, b, string, interfaceC2971z535);
            } else {
                c2947y0 = null;
            }
            if (c2947y0 == null) {
                InterfaceC2971z5 interfaceC2971z536 = this.f;
                if (interfaceC2971z536 != null) {
                    String TAG10 = this.d;
                    Intrinsics.checkNotNullExpressionValue(TAG10, "TAG");
                    ((A5) interfaceC2971z536).b(TAG10, "adSet is null");
                }
                a(MapsKt.mutableMapOf(TuplesKt.to(IronSourceConstants.EVENTS_ERROR_CODE, (short) 2114)));
                throw new K(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), (short) 0);
            }
            c2947y022 = c2947y0;
            if (c2947y022 == null) {
                InterfaceC2971z5 interfaceC2971z537 = this.f;
                if (interfaceC2971z537 != null) {
                    String TAG11 = this.d;
                    Intrinsics.checkNotNullExpressionValue(TAG11, "TAG");
                    ((A5) interfaceC2971z537).b(TAG11, "Could not parse ad response:" + jSONObject);
                }
                a(MapsKt.mutableMapOf(TuplesKt.to(IronSourceConstants.EVENTS_ERROR_CODE, (short) 2115)));
                throw new K(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), (short) 0);
            }
            if (c2947y022.m()) {
                if (c2947y022.p() == null) {
                    Map mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to(IronSourceConstants.EVENTS_ERROR_CODE, (short) 2116));
                    Boolean o = c2947y022.o();
                    if (o != null) {
                        mutableMapOf.put("isRewarded", o);
                    }
                    a(mutableMapOf);
                    throw new K(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), (short) 0);
                }
                a(c2947y022.o());
                InterfaceC2971z5 interfaceC2971z538 = this.f;
                if (interfaceC2971z538 != null) {
                    String TAG12 = this.d;
                    Intrinsics.checkNotNullExpressionValue(TAG12, "TAG");
                    ((A5) interfaceC2971z538).a(TAG12, "==== CHECKPOINT REACHED - PARSING COMPLETE ====");
                }
                InterfaceC2971z5 interfaceC2971z539 = this.f;
                if (interfaceC2971z539 != null) {
                    ((A5) interfaceC2971z539).b();
                }
            } else {
                a(c2947y022.o());
            }
            return c2947y022;
        }
        InterfaceC2971z5 interfaceC2971z540 = this.f;
        if (interfaceC2971z540 != null) {
            String TAG13 = this.d;
            Intrinsics.checkNotNullExpressionValue(TAG13, "TAG");
            ((A5) interfaceC2971z540).b(TAG13, "Ad response received but no ad available:" + jSONObject);
        }
        Map<String, Object> mutableMapOf2 = MapsKt.mutableMapOf(TuplesKt.to("latency", Long.valueOf(SystemClock.elapsedRealtime() - this.e)), TuplesKt.to(obj, L3.q()), TuplesKt.to("plId", Long.valueOf(this.c.l())));
        String m = this.c.m();
        if (m != null) {
            mutableMapOf2.put("plType", m);
        }
        String b2 = this.c.b();
        if (b2 != null) {
            mutableMapOf2.put(str, b2);
        }
        this.b.b("ServerNoFill", mutableMapOf2);
        throw new K(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.NO_FILL), (short) 0);
    }

    public final void a(Boolean bool) {
        Map<String, Object> mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("latency", Long.valueOf(SystemClock.elapsedRealtime() - this.e)), TuplesKt.to("networkType", L3.q()), TuplesKt.to("plId", Long.valueOf(this.c.l())));
        String m = this.c.m();
        if (m != null) {
            mutableMapOf.put("plType", m);
        }
        if (bool != null) {
            mutableMapOf.put("isRewarded", bool);
        }
        String b = this.c.b();
        if (b != null) {
            mutableMapOf.put("adType", b);
        }
        this.b.b("ServerFill", mutableMapOf);
    }

    public final void a(Map payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        payload.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - this.e));
        String b = this.c.b();
        if (b != null) {
            payload.put("adType", b);
        }
        payload.put("networkType", L3.q());
        payload.put("plId", Long.valueOf(this.c.l()));
        String m = this.c.m();
        if (m != null) {
            payload.put("plType", m);
        }
        this.b.b("ServerError", (Map<String, Object>) payload);
    }
}
