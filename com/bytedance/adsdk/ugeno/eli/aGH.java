package com.bytedance.adsdk.ugeno.eli;

import android.text.TextUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.adjust.sdk.Constants;
import com.bytedance.adsdk.ugeno.eli.Os;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class aGH {
    public static int eli(int i) {
        if (i < 0) {
            return -1;
        }
        if (i == 0) {
            return Integer.MIN_VALUE;
        }
        return i - 1;
    }

    public static List<Os> eli(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() <= 0) {
                return null;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(eli(optJSONObject, jSONObject));
                }
            }
            return arrayList;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static Os eli(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return null;
        }
        Os os = new Os();
        os.DbA(com.bytedance.adsdk.ugeno.kb.Os.eli(com.bytedance.adsdk.ugeno.Os.DbA.eli(jSONObject.optString("delay"), jSONObject2), 0L));
        os.Os(com.bytedance.adsdk.ugeno.Os.DbA.eli(jSONObject.optString("name"), jSONObject2));
        os.DbA(com.bytedance.adsdk.ugeno.kb.Os.eli(com.bytedance.adsdk.ugeno.Os.DbA.eli(jSONObject.optString("playState"), jSONObject2), 1));
        os.eli(Math.max(com.bytedance.adsdk.ugeno.kb.Os.eli(com.bytedance.adsdk.ugeno.Os.DbA.eli(jSONObject.optString("duration"), jSONObject2), 0L), 0L));
        os.eli(com.bytedance.adsdk.ugeno.kb.Os.eli(com.bytedance.adsdk.ugeno.Os.DbA.eli(jSONObject.optString("playCount"), jSONObject2), 1));
        os.eli(com.bytedance.adsdk.ugeno.Os.DbA.eli(jSONObject.optString("playDirection"), jSONObject2));
        os.eli(DbA(jSONObject.optString("transformOrigin"), jSONObject2));
        os.DbA(com.bytedance.adsdk.ugeno.Os.DbA.eli(jSONObject.optString("timingFunction", "linear"), jSONObject2));
        os.eli(jSONObject.optJSONObject("effect"));
        os.eli(eli(jSONObject.optJSONArray("keyframes"), jSONObject2));
        return os;
    }

    public static Map<String, TreeMap<Float, String>> eli(JSONArray jSONArray, JSONObject jSONObject) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                float optDouble = (float) optJSONObject.optDouble("offset");
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    TreeMap treeMap = (TreeMap) hashMap.get(next);
                    if (!TextUtils.equals(next, "offset")) {
                        if (hashMap.containsKey(next) && treeMap != null) {
                            treeMap.put(Float.valueOf(optDouble), com.bytedance.adsdk.ugeno.Os.DbA.eli(optJSONObject.optString(next), jSONObject));
                        } else {
                            TreeMap treeMap2 = new TreeMap();
                            treeMap2.put(Float.valueOf(optDouble), com.bytedance.adsdk.ugeno.Os.DbA.eli(optJSONObject.optString(next), jSONObject));
                            hashMap.put(next, treeMap2);
                        }
                    }
                }
            }
        }
        return hashMap;
    }

    public static int eli(String str) {
        int hashCode = str.hashCode();
        if (hashCode == -1408024454) {
            return str.equals("alternate") ? 2 : 1;
        }
        if (hashCode != -1039745817) {
            return 1;
        }
        str.equals(Constants.NORMAL);
        return 1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static Interpolator DbA(String str) {
        char c;
        switch (str.hashCode()) {
            case -1965072618:
                if (str.equals("ease_in")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1102672091:
                if (str.equals("linear")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -787702915:
                if (str.equals("ease_out")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1065009829:
                if (str.equals("ease_in_out")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0) {
            return new AccelerateInterpolator();
        }
        if (c == 1) {
            return new AccelerateDecelerateInterpolator();
        }
        if (c == 2) {
            return new DecelerateInterpolator();
        }
        return new LinearInterpolator();
    }

    public static float[] Os(String str) {
        float[] fArr = {0.0f, 0.0f};
        JSONArray eli = com.bytedance.adsdk.ugeno.kb.DbA.eli(str, (JSONArray) null);
        if (eli != null && eli.length() == 2) {
            fArr[0] = (float) eli.optDouble(0);
            fArr[1] = (float) eli.optDouble(1);
        }
        return fArr;
    }

    public static Os.eli DbA(String str, JSONObject jSONObject) {
        JSONArray eli;
        if (TextUtils.isEmpty(str) || (eli = com.bytedance.adsdk.ugeno.kb.DbA.eli(str, (JSONArray) null)) == null || eli.length() != 2) {
            return null;
        }
        Os.eli eliVar = new Os.eli();
        eliVar.eli = com.bytedance.adsdk.ugeno.Os.DbA.eli(eli.optString(0), jSONObject);
        eliVar.DbA = com.bytedance.adsdk.ugeno.Os.DbA.eli(eli.optString(1), jSONObject);
        return eliVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int eli(String str, int i) {
        int i2 = i / 2;
        if (!TextUtils.isEmpty(str)) {
            str.hashCode();
            switch (str) {
                case "bottom":
                case "right":
                    return i;
                case "center":
                    break;
                case "top":
                case "left":
                    return 0;
                default:
                    try {
                        if (str.endsWith("%")) {
                            return (int) ((i * Float.parseFloat(str.substring(0, str.length() - 1))) / 100.0f);
                        }
                        return Integer.parseInt(str);
                    } catch (NumberFormatException unused) {
                        break;
                    }
            }
        }
        return i2;
    }
}
