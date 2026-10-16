package com.bytedance.sdk.component.ui.ui;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class kb extends eli {
    @Override // com.bytedance.sdk.component.ui.ui.FC
    public void eli(com.bytedance.sdk.component.ui.Os.Os os) {
        List<com.bytedance.sdk.component.ui.Os.Os> list;
        String CMM = os.CMM();
        Map<String, List<com.bytedance.sdk.component.ui.Os.Os>> wC = os.nGm().wC();
        synchronized (wC) {
            list = wC.get(CMM);
            if (list == null) {
                list = new LinkedList<>();
            }
        }
        synchronized (list) {
            list.add(os);
            wC.put(CMM, list);
            if (list.size() <= 1) {
                os.eli(new aGH());
            }
        }
    }

    @Override // com.bytedance.sdk.component.ui.ui.FC
    public String eli() {
        return "check_duplicate";
    }
}
