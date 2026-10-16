package com.bytedance.sdk.component.ui.aGH.DbA;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.ui.QX;

/* loaded from: classes3.dex */
public class eli<T> implements MGA {
    @Override // com.bytedance.sdk.component.ui.aGH.DbA.MGA
    public boolean eli(com.bytedance.sdk.component.ui.aGH.Os.Os os, QX qx, com.bytedance.sdk.component.ui.aGH.Os.eli eliVar) {
        Bitmap eli;
        String aAs = os.aAs();
        os.eli();
        com.bytedance.sdk.component.ui.DbA nGm = os.nGm();
        com.bytedance.sdk.component.ui.aGH.Os.MGA dV = os.dV();
        if (nGm == null || dV == null || !nGm.ui() || !eli(os) || (eli = dV.eli(nGm).eli(aAs)) == null) {
            return true;
        }
        os.eli();
        eliVar.eli(new com.bytedance.sdk.component.ui.aGH.Os.aGH().eli(os, eli, null, false));
        return false;
    }

    private boolean eli(com.bytedance.sdk.component.ui.aGH.Os.Os os) {
        int nlS = os.nlS();
        return nlS == 1 || nlS == 2;
    }

    @Override // com.bytedance.sdk.component.ui.aGH.DbA.MGA
    public String eli() {
        return "bitmap_cache";
    }
}
