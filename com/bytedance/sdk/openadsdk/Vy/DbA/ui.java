package com.bytedance.sdk.openadsdk.Vy.DbA;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.dZ;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class ui {
    private static final Map<Integer, DbA> eli = new ConcurrentHashMap();

    public static void eli(View view, ev evVar, eli eliVar) {
        if (view == null || evVar == null || evVar.GCU()) {
            return;
        }
        boolean Os = Os(evVar);
        if (KM.DbA(evVar) && eliVar != null) {
            eliVar.eli = -1;
        }
        eli(eli(view, evVar, Os, eliVar));
    }

    private static boolean Os(ev evVar) {
        if (evVar == null) {
            return false;
        }
        String eli2 = dZ.eli(evVar);
        return ((!"open_ad".equals(eli2) && !"fullscreen_interstitial_ad".equals(eli2) && !"rewarded_video".equals(eli2)) || KM.DbA(evVar) || evVar.mm() == 5 || evVar.mm() == 33 || !ev.ui(evVar) || evVar.nY() == null) ? false : true;
    }

    private static DbA eli(View view, ev evVar, boolean z, eli eliVar) {
        if (view == null || evVar == null || evVar.umh() == null) {
            return null;
        }
        Integer DbA = DbA(evVar);
        Map<Integer, DbA> map = eli;
        if (map.containsKey(DbA)) {
            DbA dbA = map.get(DbA);
            if (dbA != null) {
                dbA.eli(view);
            }
            return dbA;
        }
        DbA eli2 = DbA.eli(z, DbA, view, evVar, eliVar);
        map.put(DbA, eli2);
        return eli2;
    }

    private static void eli(DbA dbA) {
        if (dbA == null) {
            return;
        }
        dbA.eli();
    }

    public static void eli(ev evVar, int i) {
        if (evVar == null || evVar.umh() == null) {
            return;
        }
        eli(eli.get(DbA(evVar)), i);
    }

    public static void eli(DbA dbA, int i) {
        if (dbA == null) {
            return;
        }
        dbA.eli(i);
    }

    public static void eli(ev evVar) {
        if (evVar == null || evVar.umh() == null) {
            return;
        }
        Integer DbA = DbA(evVar);
        Map<Integer, DbA> map = eli;
        DbA dbA = map.get(DbA);
        if (dbA != null) {
            dbA.aAs();
        }
        DbA(DbA);
        if (map.size() <= 0) {
            kb.eli();
        }
    }

    public static DbA eli(Integer num) {
        return eli.get(num);
    }

    public static void DbA(Integer num) {
        eli.remove(num);
    }

    public static Integer DbA(ev evVar) {
        return Integer.valueOf((evVar.fO() + evVar.umh()).hashCode());
    }

    public static class eli {
        public int DbA = -1;
        public int eli;

        public eli(int i) {
            this.eli = i;
        }
    }
}
