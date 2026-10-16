package com.bykv.vk.openvk.eli.eli.eli.kb;

/* loaded from: classes3.dex */
public class Os {
    private static int DbA = 4;
    private static String Os = "";
    private static boolean eli = false;

    public static void eli(String str) {
        Os = str;
    }

    public static void eli(int i) {
        DbA = i;
    }

    public static void eli() {
        eli = true;
        eli(3);
    }

    public static void DbA() {
        eli = false;
        eli(7);
    }
}
