package com.bytedance.sdk.component.ui.aGH.DbA;

import com.bytedance.sdk.component.ui.QX;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class ui implements MGA {
    @Override // com.bytedance.sdk.component.ui.aGH.DbA.MGA
    public boolean eli(com.bytedance.sdk.component.ui.aGH.Os.Os os, QX qx, com.bytedance.sdk.component.ui.aGH.Os.eli eliVar) {
        List<com.bytedance.sdk.component.ui.aGH.Os.Os> list;
        String Xb = os.Xb();
        Map<String, List<com.bytedance.sdk.component.ui.aGH.Os.Os>> FC = os.dV().FC();
        os.nlS();
        os.eli();
        synchronized (FC) {
            list = FC.get(Xb);
            if (list == null) {
                list = new CopyOnWriteArrayList<>();
                FC.put(Xb, list);
            }
        }
        synchronized (list) {
            list.add(os);
            if (list.size() <= 1) {
                return true;
            }
            os.nlS();
            os.eli();
            return false;
        }
    }

    @Override // com.bytedance.sdk.component.ui.aGH.DbA.MGA
    public String eli() {
        return "check_duplicate";
    }
}
