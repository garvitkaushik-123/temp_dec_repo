package com.bytedance.sdk.component.ui.ui;

import com.bytedance.sdk.component.ui.aqO;
import com.ironsource.C3040d4;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class wC extends eli {
    private int DbA;
    private String Os;
    private Throwable eli;

    public wC(int i, String str, Throwable th) {
        this.DbA = i;
        this.Os = str;
        this.eli = th;
    }

    @Override // com.bytedance.sdk.component.ui.ui.FC
    public void eli(com.bytedance.sdk.component.ui.Os.Os os) {
        os.eli(new com.bytedance.sdk.component.ui.Os.eli(this.DbA, this.Os, this.eli));
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

    @Override // com.bytedance.sdk.component.ui.ui.FC
    public String eli() {
        return C3040d4.h.t;
    }

    private void DbA(com.bytedance.sdk.component.ui.Os.Os os) {
        aqO wC = os.wC();
        if (wC != null) {
            wC.eli(this.DbA, this.Os, this.eli);
        }
    }
}
