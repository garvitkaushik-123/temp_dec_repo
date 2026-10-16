package com.pgl.ssdk;

import android.text.TextUtils;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public class i0 {
    public static String a(String str) {
        String[] b = b(str);
        ArrayList arrayList = new ArrayList();
        if (b != null && b.length > 0) {
            for (String str2 : b) {
                try {
                    Class.forName(str2);
                    arrayList.add(str2);
                } catch (ClassNotFoundException unused) {
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList.toString();
    }

    public static String[] b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split("//");
    }
}
