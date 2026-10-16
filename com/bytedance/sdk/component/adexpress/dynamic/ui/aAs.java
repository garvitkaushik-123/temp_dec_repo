package com.bytedance.sdk.component.adexpress.dynamic.ui;

import com.bytedance.sdk.component.adexpress.dynamic.ui.DbA;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class aAs {
    public static float eli(float f) {
        return (float) Math.ceil((f * 16.0f) / 16.0f);
    }

    public static List<DbA.eli> eli(float f, List<DbA.eli> list) {
        ArrayList<DbA.eli> arrayList = new ArrayList();
        Iterator<DbA.eli> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((DbA.eli) it.next().clone());
        }
        boolean z = true;
        int i = 0;
        int i2 = 0;
        for (DbA.eli eliVar : arrayList) {
            if (eliVar.DbA) {
                i = (int) (i + eliVar.eli);
            } else {
                i2 = (int) (i2 + eliVar.eli);
                z = false;
            }
        }
        if (!z || f <= i) {
            float f2 = i;
            float f3 = f < f2 ? f / f2 : 1.0f;
            float f4 = f > f2 ? (f - f2) / i2 : 0.0f;
            if (f4 > 1.0f) {
                ArrayList arrayList2 = new ArrayList();
                boolean z2 = false;
                for (DbA.eli eliVar2 : arrayList) {
                    if (!eliVar2.DbA && eliVar2.Os != 0.0f && eliVar2.eli * f4 > eliVar2.Os) {
                        eliVar2.eli = eliVar2.Os;
                        eliVar2.DbA = true;
                        z2 = true;
                    }
                    arrayList2.add(eliVar2);
                }
                if (z2) {
                    return eli(f, arrayList2);
                }
            }
            int i3 = 0;
            for (DbA.eli eliVar3 : arrayList) {
                if (eliVar3.DbA) {
                    eliVar3.eli = eli(eliVar3.eli * f3);
                } else {
                    eliVar3.eli = eli(eliVar3.eli * f4);
                }
                i3 = (int) (i3 + eliVar3.eli);
            }
            float f5 = i3;
            if (f5 < f) {
                float f6 = f - f5;
                for (int i4 = 0; i4 < arrayList.size() && f6 > 0.0f; i4 = (i4 + 1) % arrayList.size()) {
                    DbA.eli eliVar4 = (DbA.eli) arrayList.get(i4);
                    if ((f < f2 && eliVar4.DbA) || (f > f2 && !eliVar4.DbA)) {
                        eliVar4.eli += 0.0625f;
                        f6 -= 0.0625f;
                    }
                }
            }
        }
        return arrayList;
    }
}
