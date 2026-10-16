package com.instagram.common.viewpoint.core;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import com.facebook.ads.internal.settings.AdInternalSettings;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* loaded from: assets/audience_network/classes2.dex */
public abstract class XI {
    public static byte[] A00;
    public static String[] A01 = {"jE5XhhYKQHpatPcaqKauHRorLHvmx36n", "j5XcoEcQeBll47Gmx6jJ35WP8DJmwvrw", "kVl1RLZeBZp6BFsBugJhIVOAvqqMASOM", "QSUK5zHpyvdae", "vPHRoVXEMWzbN", "yuxZo0oeIJp1om754wFfCKw5qfu7K2sC", "XIj7zi9aVzSGRkWRza9PLbW8qplNkm3M", "NShUMjU8EFbasu9WAPG4eHHUTqko21N4"};
    public static final Handler A02;
    public static final Set<String> A03;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 4);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{39, 47, 107, 112, 122, 119, 115, 104, Byte.MIN_VALUE, 108, 107, 39, 109, 118, 121, 39, 123, 108, 122, 123, 39, 104, 107, 122, 39, 118, 117, 115, Byte.MIN_VALUE, 48, -78, -66, -68, 125, -75, -80, -78, -76, -79, -66, -66, -70, 125, -70, -80, -61, -80, -67, -80, -87, -75, -77, 116, -84, -89, -87, -85, -88, -75, -75, -79, 116, -67, -89, -79, -81, -64, -89, -71, -82, -81};
    }

    static {
        A03();
        A03 = new HashSet();
        A02 = new Handler(Looper.getMainLooper());
    }

    public static void A04(Context context, String str) {
        if (AdInternalSettings.isTestMode(context)) {
            String str2 = str + A01(0, 30, 3);
        }
    }

    public static void A05(C1925ge c1925ge, InterfaceC1444Xh interfaceC1444Xh, String str) {
        if (str == null || A03.contains(str)) {
            return;
        }
        boolean isPackageInstalled = A08(c1925ge.getPackageManager(), str);
        if (isPackageInstalled) {
            interfaceC1444Xh.AF5(str);
            return;
        }
        A03.add(str);
        A02.removeCallbacksAndMessages(null);
        A02.postDelayed(new XH(new int[]{0}, str, c1925ge, interfaceC1444Xh), 1000L);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void A06(C1925ge c1925ge, String str) {
        boolean isWithinFB;
        if (!c1925ge.getPackageName().equals(A01(30, 19, 75))) {
            String packageName = c1925ge.getPackageName();
            String[] strArr = A01;
            if (strArr[1].charAt(0) != strArr[0].charAt(0)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[1] = "j02YsboHYugdBqu3W2eQxUFjhHj6b2oh";
            strArr2[0] = "jTJN86H0DvMYpZ5S4bGPoLkC3Jk4zW8z";
            if (!packageName.equals(A01(49, 22, 66))) {
                isWithinFB = false;
                if (!isWithinFB) {
                    A02.removeCallbacksAndMessages(null);
                    A03.remove(str);
                    return;
                } else {
                    OP.A00(c1925ge).A0A(str, null, 5);
                    return;
                }
            }
        }
        isWithinFB = true;
        if (!isWithinFB) {
        }
    }

    public static void A07(C1925ge c1925ge, String str, InterfaceC1444Xh interfaceC1444Xh) {
        boolean isWithinFB = c1925ge.getPackageName().equals(A01(30, 19, 75)) || c1925ge.getPackageName().equals(A01(49, 22, 66));
        if (isWithinFB) {
            A05(c1925ge, interfaceC1444Xh, str);
        } else {
            OP.A00(c1925ge).A0A(str, interfaceC1444Xh, 4);
        }
    }

    public static boolean A08(PackageManager packageManager, String str) {
        if (packageManager == null) {
            return false;
        }
        try {
            packageManager.getPackageGids(str);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
