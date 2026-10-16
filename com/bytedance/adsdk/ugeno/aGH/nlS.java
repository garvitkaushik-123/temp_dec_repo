package com.bytedance.adsdk.ugeno.aGH;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.aGH.MGA;
import java.util.HashMap;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class nlS {
    public static MGA.eli eli(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        MGA.eli eliVar = new MGA.eli();
        String eli = com.bytedance.adsdk.ugeno.Os.DbA.eli(str, jSONObject);
        Uri parse = Uri.parse(eli);
        if (parse == null) {
            return null;
        }
        eliVar.Os(eli);
        if (!TextUtils.isEmpty(parse.getScheme())) {
            eliVar.eli(parse.getScheme());
        }
        String authority = parse.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            authority = parse.getPath();
        }
        eliVar.DbA(authority);
        eliVar.aGH(eliVar.eli() + "://" + eliVar.DbA());
        HashMap hashMap = new HashMap();
        Set<String> queryParameterNames = parse.getQueryParameterNames();
        if (queryParameterNames != null && queryParameterNames.size() > 0) {
            for (String str2 : queryParameterNames) {
                hashMap.put(str2, com.bytedance.adsdk.ugeno.Os.DbA.eli(parse.getQueryParameter(str2), jSONObject));
            }
        }
        eliVar.eli(hashMap);
        return eliVar;
    }
}
