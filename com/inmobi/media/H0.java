package com.inmobi.media;

import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public abstract class H0 {
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0032, code lost:
    
        if (r3.equals("video") == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003b, code lost:
    
        if (r3.equals("audio") == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0029, code lost:
    
        if (r3.equals("nonvideo") == false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static HashMap a(String creativeTypeString, String customRefData, boolean z, JSONObject jSONObject, byte b) {
        String str;
        Intrinsics.checkNotNullParameter(creativeTypeString, "creativeTypeString");
        Intrinsics.checkNotNullParameter(customRefData, "customRefData");
        HashMap hashMap = new HashMap();
        int hashCode = creativeTypeString.hashCode();
        if (hashCode == 93166550) {
            str = "audio";
        } else if (hashCode != 112202875) {
            if (hashCode == 1425678798) {
                str = "nonvideo";
            }
            str = "unknown";
        } else {
            str = "video";
        }
        hashMap.put("creativeType", str);
        hashMap.put("customReferenceData", customRefData);
        hashMap.put("impressionType", Byte.valueOf(b));
        HashMap hashMap2 = new HashMap();
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String optString = jSONObject.optString(next);
                Intrinsics.checkNotNull(next);
                Intrinsics.checkNotNull(optString);
                hashMap2.put(next, optString);
            }
        }
        hashMap.put("macros", hashMap2);
        hashMap.put("isolateVerificationScripts", Boolean.valueOf(z));
        return hashMap;
    }
}
