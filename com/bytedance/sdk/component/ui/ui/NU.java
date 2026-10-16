package com.bytedance.sdk.component.ui.ui;

import com.bytedance.sdk.component.ui.aqO;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class NU<T> extends eli {
    private com.bytedance.sdk.component.ui.MGA DbA;
    private boolean Os;
    private T eli;

    public NU(T t, com.bytedance.sdk.component.ui.MGA mga, boolean z) {
        this.eli = t;
        this.DbA = mga;
        this.Os = z;
    }

    @Override // com.bytedance.sdk.component.ui.ui.FC
    public void eli(com.bytedance.sdk.component.ui.Os.Os os) {
        String CMM = os.CMM();
        Map<String, List<com.bytedance.sdk.component.ui.Os.Os>> wC = os.nGm().wC();
        List<com.bytedance.sdk.component.ui.Os.Os> list = wC.get(CMM);
        if (list == null) {
            DbA(os);
            return;
        }
        synchronized (list) {
            Iterator<com.bytedance.sdk.component.ui.Os.Os> it = list.iterator();
            while (it.hasNext()) {
                DbA(it.next());
            }
            list.clear();
            wC.remove(CMM);
        }
    }

    private Map<String, String> DbA() {
        com.bytedance.sdk.component.ui.MGA mga = this.DbA;
        if (mga != null) {
            return mga.ui();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.ui.ui.FC
    public String eli() {
        return "success";
    }

    private void DbA(com.bytedance.sdk.component.ui.Os.Os os) {
        aqO wC = os.wC();
        if (wC != null) {
            wC.eli(new com.bytedance.sdk.component.ui.Os.aGH().eli(os, this.eli, DbA(), this.Os));
        }
    }
}
