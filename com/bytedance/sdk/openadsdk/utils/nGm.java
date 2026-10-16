package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.os.Build;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class nGm {
    public static void eli() {
        Context eli = com.bytedance.sdk.openadsdk.core.dV.eli();
        if (eli != null && com.bytedance.sdk.component.utils.Dfc.aGH()) {
            String packageName = eli.getPackageName();
            int i = eli.getApplicationInfo().targetSdkVersion;
            try {
                String[] strArr = eli.getPackageManager().getPackageInfo(packageName, 4096).requestedPermissions;
                if (strArr != null && strArr.length > 0) {
                    List<String> DbA = DbA();
                    for (String str : strArr) {
                        if (str != null) {
                            DbA.remove(str);
                        }
                    }
                    if (!DbA.isEmpty()) {
                        Iterator<String> it = DbA.iterator();
                        while (it.hasNext()) {
                            new StringBuilder("    May be missing permissions：").append(it.next());
                        }
                    }
                }
            } catch (Throwable unused) {
            }
            if (i < 23) {
                try {
                    new StringBuilder("No adaptation required for dynamic permissions：target=").append(i).append("&phone=").append(Build.VERSION.SDK_INT);
                } catch (Throwable unused2) {
                }
            }
        }
    }

    private static List<String> DbA() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.INTERNET");
        arrayList.add("android.permission.ACCESS_NETWORK_STATE");
        arrayList.add("android.permission.WAKE_LOCK");
        return arrayList;
    }
}
