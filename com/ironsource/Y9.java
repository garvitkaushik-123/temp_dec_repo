package com.ironsource;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class Y9 {
    public static Map<String, Object> a(Object[][] objArr) {
        HashMap hashMap = new HashMap();
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    hashMap.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e) {
                C3260q4.d().a(e);
            }
        }
        return hashMap;
    }
}
