package com.bytedance.adsdk.DbA;

import android.util.Pair;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class nGm {
    private boolean eli = false;
    private final Set<Object> DbA = new eli();
    private final Map<String, com.bytedance.adsdk.DbA.MGA.aGH> Os = new HashMap();
    private final Comparator<Pair<String, Float>> aGH = new Comparator<Pair<String, Float>>() { // from class: com.bytedance.adsdk.DbA.nGm.1
        @Override // java.util.Comparator
        /* renamed from: eli, reason: merged with bridge method [inline-methods] */
        public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float floatValue = ((Float) pair.second).floatValue();
            float floatValue2 = ((Float) pair2.second).floatValue();
            if (floatValue2 > floatValue) {
                return 1;
            }
            return floatValue > floatValue2 ? -1 : 0;
        }
    };

    void eli(boolean z) {
        this.eli = z;
    }

    public void eli(String str, float f) {
        if (this.eli) {
            com.bytedance.adsdk.DbA.MGA.aGH agh = this.Os.get(str);
            if (agh == null) {
                agh = new com.bytedance.adsdk.DbA.MGA.aGH();
                this.Os.put(str, agh);
            }
            agh.eli(f);
            if (str.equals("__container")) {
                Iterator<Object> it = this.DbA.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    }
}
