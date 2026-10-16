package com.pgl.ssdk;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import java.util.List;

/* loaded from: classes6.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    private static AccessibilityManager f6409a;

    private static AccessibilityManager a(Context context) {
        if (f6409a == null) {
            f6409a = (AccessibilityManager) context.getSystemService("accessibility");
        }
        return f6409a;
    }

    public static String b(Context context) {
        AccessibilityManager a2;
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        if (context == null || (a2 = a(context)) == null || (enabledAccessibilityServiceList = a2.getEnabledAccessibilityServiceList(-1)) == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < enabledAccessibilityServiceList.size(); i++) {
            AccessibilityServiceInfo accessibilityServiceInfo = enabledAccessibilityServiceList.get(i);
            if (accessibilityServiceInfo != null) {
                sb.append(String.format("%s#%s", accessibilityServiceInfo.getResolveInfo().serviceInfo.packageName, accessibilityServiceInfo.getResolveInfo().serviceInfo.name));
                if (i != enabledAccessibilityServiceList.size() - 1) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }
}
