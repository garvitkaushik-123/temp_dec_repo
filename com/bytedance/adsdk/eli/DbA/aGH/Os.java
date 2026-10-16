package com.bytedance.adsdk.eli.DbA.aGH;

import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.slf4j.Marker;

/* loaded from: classes3.dex */
public enum Os implements ui {
    QUESTION("?", 0),
    COLON(":", 0),
    DOUBLE_AMP("&&", 1),
    DOUBLE_BAR("||", 1),
    EQ("==", 2),
    GT(">", 2),
    LT("<", 2),
    LT_EQ("<=", 2),
    GT_EQ(">=", 2),
    NOT_EQ("!=", 2),
    PLUS(Marker.ANY_NON_NULL_MARKER, 3),
    MINUS("-", 3),
    MULTI("*", 4),
    DIVISION(RemoteSettings.FORWARD_SLASH_STRING, 4),
    MOD("%", 4);

    private static final Map<String, Os> aqO = new HashMap(128);
    private static final Set<Os> dV = new HashSet();
    private final int QX;
    private final String nGm;

    static {
        for (Os os : values()) {
            aqO.put(os.eli(), os);
            dV.add(os);
        }
    }

    Os(String str, int i) {
        this.nGm = str;
        this.QX = i;
    }

    public static Os eli(String str) {
        return aqO.get(str);
    }

    public static boolean eli(ui uiVar) {
        return uiVar instanceof Os;
    }

    public String eli() {
        return this.nGm;
    }

    public int DbA() {
        return this.QX;
    }
}
