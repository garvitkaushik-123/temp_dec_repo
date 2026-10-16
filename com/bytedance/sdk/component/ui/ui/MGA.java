package com.bytedance.sdk.component.ui.ui;

import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class MGA extends eli {
    @Override // com.bytedance.sdk.component.ui.ui.FC
    public void eli(com.bytedance.sdk.component.ui.Os.Os os) {
        byte[] eli;
        String FC = os.FC();
        if (os.Xb() || os.QX().FC()) {
            eli = eli(os, FC);
        } else {
            eli = DbA(os, FC);
        }
        if (eli == null) {
            os.eli(new du());
        } else {
            os.eli(new DbA(eli, null));
            os.nGm().DbA(os.QX()).eli(FC, eli);
        }
    }

    private byte[] eli(com.bytedance.sdk.component.ui.Os.Os os, String str) {
        os.nGm().Os(os.QX());
        Collection<com.bytedance.sdk.component.ui.Os> Os = os.nGm().Os();
        if (Os == null) {
            return null;
        }
        Iterator<com.bytedance.sdk.component.ui.Os> it = Os.iterator();
        while (it.hasNext()) {
            byte[] eli = it.next().eli((com.bytedance.sdk.component.ui.Os) str);
            if (eli != null) {
                return eli;
            }
        }
        return null;
    }

    private byte[] DbA(com.bytedance.sdk.component.ui.Os.Os os, String str) {
        com.bytedance.sdk.component.ui.Os Os = os.nGm().Os(os.QX());
        if (Os == null) {
            return null;
        }
        return Os.eli((com.bytedance.sdk.component.ui.Os) str);
    }

    @Override // com.bytedance.sdk.component.ui.ui.FC
    public String eli() {
        return "disk_cache";
    }
}
