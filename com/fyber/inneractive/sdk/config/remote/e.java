package com.fyber.inneractive.sdk.config.remote;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.mbridge.msdk.MBridgeConstans;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public a f1117a;
    public List b = null;
    public String c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01a7 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static e a(JSONObject jSONObject) {
        a aVar;
        JSONArray jSONArray;
        String str;
        int i;
        String str2;
        ArrayList arrayList;
        int i2;
        String str3;
        g gVar;
        String str4 = null;
        String optString = jSONObject.optString("updateHash", null);
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        e eVar = new e();
        eVar.c = optString;
        JSONObject optJSONObject = jSONObject.optJSONObject(MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        int optInt = optJSONObject == null ? -1 : optJSONObject.optInt("id", -1);
        String str5 = "isActive";
        if (optInt == -1) {
            aVar = null;
        } else {
            aVar = new a();
            aVar.f1115a = String.valueOf(optInt);
            aVar.b = optJSONObject.optString("publisherId", null);
            aVar.c = f.a(optJSONObject.optJSONObject("monitor"));
            aVar.d = j.a(optJSONObject.optJSONObject("video"));
            aVar.e = b.a(optJSONObject.optJSONObject("display"));
            aVar.f = k.a(optJSONObject.optJSONObject("viewability"));
            aVar.g = optJSONObject.optString("isActive", null);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("native");
            if (optJSONObject2 != null) {
                UnitDisplayType.fromValue(optJSONObject2.optString("unitDisplayType"));
            }
        }
        if (aVar == null) {
            return null;
        }
        eVar.f1117a = aVar;
        ArrayList arrayList2 = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("spots");
        if (optJSONArray != null) {
            int i3 = 0;
            while (i3 < optJSONArray.length()) {
                JSONObject optJSONObject3 = optJSONArray.optJSONObject(i3);
                if (optJSONObject3 != null) {
                    String optString2 = optJSONObject3.optString("id", str4);
                    if (!TextUtils.isEmpty(optString2)) {
                        h hVar = new h();
                        hVar.f1120a = optString2;
                        hVar.b = optJSONObject3.optString(str5, str4);
                        hVar.c = b.a(optJSONObject3.optJSONObject("display"));
                        hVar.d = f.a(optJSONObject3.optJSONObject("monitor"));
                        JSONObject optJSONObject4 = optJSONObject3.optJSONObject("native");
                        if (optJSONObject4 != null) {
                            UnitDisplayType.fromValue(optJSONObject4.optString("unitDisplayType"));
                        }
                        hVar.e = j.a(optJSONObject3.optJSONObject("video"));
                        hVar.f = k.a(optJSONObject3.optJSONObject("viewability"));
                        JSONArray optJSONArray2 = optJSONObject3.optJSONArray("units");
                        if (optJSONArray2 == null || optJSONArray2.length() == 0) {
                            jSONArray = optJSONArray;
                            i = i3;
                            str2 = str5;
                            arrayList = new ArrayList();
                        } else {
                            arrayList = new ArrayList();
                            jSONArray = optJSONArray;
                            int i4 = 0;
                            while (i4 < optJSONArray2.length()) {
                                JSONObject optJSONObject5 = optJSONArray2.optJSONObject(i4);
                                int i5 = i4;
                                if (optJSONObject5 != null) {
                                    i iVar = new i();
                                    i2 = i3;
                                    str3 = str5;
                                    iVar.f1121a = optJSONObject5.optString("id", null);
                                    iVar.b = optJSONObject5.optString("spotId", null);
                                    iVar.c = b.a(optJSONObject5.optJSONObject("display"));
                                    iVar.d = f.a(optJSONObject5.optJSONObject("monitor"));
                                    JSONObject optJSONObject6 = optJSONObject5.optJSONObject("native");
                                    if (optJSONObject6 != null) {
                                        gVar = new g();
                                        UnitDisplayType fromValue = UnitDisplayType.fromValue(optJSONObject6.optString("unitDisplayType"));
                                        if (fromValue != null) {
                                            gVar.f1119a = fromValue;
                                            iVar.e = gVar;
                                            iVar.f = j.a(optJSONObject5.optJSONObject("video"));
                                            iVar.g = k.a(optJSONObject5.optJSONObject("viewability"));
                                            arrayList.add(iVar);
                                        }
                                    }
                                    gVar = null;
                                    iVar.e = gVar;
                                    iVar.f = j.a(optJSONObject5.optJSONObject("video"));
                                    iVar.g = k.a(optJSONObject5.optJSONObject("viewability"));
                                    arrayList.add(iVar);
                                } else {
                                    i2 = i3;
                                    str3 = str5;
                                }
                                i4 = i5 + 1;
                                str5 = str3;
                                i3 = i2;
                            }
                            i = i3;
                            str2 = str5;
                        }
                        hVar.g = arrayList;
                        str = hVar;
                        if (str == null) {
                            arrayList2.add(str);
                        }
                        i3 = i + 1;
                        str5 = str2;
                        optJSONArray = jSONArray;
                        str4 = null;
                    }
                }
                jSONArray = optJSONArray;
                str = str4;
                i = i3;
                str2 = str5;
                if (str == null) {
                }
                i3 = i + 1;
                str5 = str2;
                optJSONArray = jSONArray;
                str4 = null;
            }
        }
        eVar.b = arrayList2;
        return eVar;
    }
}
