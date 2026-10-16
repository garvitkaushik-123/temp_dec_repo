package com.bytedance.sdk.component.FC;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class DbA {
    public static boolean eli(List<String> list, String str) {
        if (list != null && !list.isEmpty()) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (Pattern.matches(it.next(), str)) {
                    return true;
                }
            }
        }
        return false;
    }
}
