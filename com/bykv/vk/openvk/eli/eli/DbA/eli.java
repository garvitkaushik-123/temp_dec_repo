package com.bykv.vk.openvk.eli.eli.DbA;

import com.bykv.vk.openvk.eli.eli.eli.eli.DbA;
import com.ironsource.C3288s;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class eli {
    public static int DbA = 10;
    public static int Os = 10;
    public static int aGH = 10;
    public static int eli = 10;
    private static DbA ui;

    public static void eli(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            eli = jSONObject.optInt("splash", 10);
            DbA = jSONObject.optInt(C3288s.j, 10);
            Os = jSONObject.optInt("brand", 10);
            int optInt = jSONObject.optInt("other", 10);
            aGH = optInt;
            if (eli < 0) {
                eli = 10;
            }
            if (DbA < 0) {
                DbA = 10;
            }
            if (Os < 0) {
                Os = 10;
            }
            if (optInt < 0) {
                aGH = 10;
            }
            new Object[]{"splash=", Integer.valueOf(eli), ",reward=", Integer.valueOf(DbA), ",brand=", Integer.valueOf(Os), ",other=", Integer.valueOf(aGH)};
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public static void eli(DbA dbA) {
        ui = dbA;
    }

    public static void eli() {
        DbA dbA = ui;
        if (dbA != null) {
            dbA.aGH();
        }
    }

    public static int DbA() {
        return eli;
    }

    public static int Os() {
        return DbA;
    }

    public static int aGH() {
        return Os;
    }

    public static int ui() {
        return aGH;
    }
}
