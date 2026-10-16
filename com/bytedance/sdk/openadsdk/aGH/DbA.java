package com.bytedance.sdk.openadsdk.aGH;

import com.bytedance.sdk.openadsdk.aGH.Os.eli;
import com.ironsource.C3207n2;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public class DbA {
    public static final String eli = eli.InterfaceC0162eli.eli;
    public static final String DbA = eli.InterfaceC0162eli.DbA;
    public static final String Os = eli.InterfaceC0162eli.Os;
    public static final String aGH = eli.InterfaceC0162eli.aGH;
    public static final String ui = eli.InterfaceC0162eli.ui;
    public static final String MGA = eli.InterfaceC0162eli.MGA;
    public static final Set<String> kb = new HashSet(Arrays.asList("click", C3207n2.v, "insight_log"));

    /* renamed from: com.bytedance.sdk.openadsdk.aGH.DbA$DbA, reason: collision with other inner class name */
    public static class C0161DbA {
        public static int DbA = 2;
        public static int Os = 100;
        public static int eli = 1;
    }

    public static class eli {
        public static String DbA = "openAdLandPageLinks";
        public static String Os = "direct";
        public static String aGH = "saLandingPageLinks";
        public static String eli = "openDetailPage";
    }

    public static boolean eli(String str) {
        return "embeded_ad".equals(str) || "banner_ad".equals(str) || "interaction".equals(str) || "slide_banner_ad".equals(str);
    }
}
