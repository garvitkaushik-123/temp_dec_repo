package com.bytedance.adsdk.eli.DbA.aGH;

import com.ironsource.C3040d4;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public enum aGH implements ui {
    LEFT_PAREN("("),
    RIGHT_PAREN(")"),
    LEFT_BRACKET(C3040d4.i.d),
    RIGHT_BRACKET(C3040d4.i.e),
    COMMA(",");

    private static final Map<String, aGH> MGA;
    private final String kb;

    static {
        HashMap hashMap = new HashMap(128);
        MGA = hashMap;
        for (aGH agh : hashMap.values()) {
            MGA.put(agh.eli(), agh);
        }
    }

    aGH(String str) {
        this.kb = str;
    }

    public static boolean eli(ui uiVar) {
        return uiVar instanceof aGH;
    }

    public String eli() {
        return this.kb;
    }
}
