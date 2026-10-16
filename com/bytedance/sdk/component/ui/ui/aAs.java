package com.bytedance.sdk.component.ui.ui;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.ui.dV;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class aAs extends eli {
    @Override // com.bytedance.sdk.component.ui.ui.FC
    public void eli(com.bytedance.sdk.component.ui.Os.Os os) {
        Bitmap DbA;
        int nlS = os.nlS();
        if (nlS != 2 && nlS != 1) {
            DbA = null;
        } else if (os.Xb() || os.QX().FC()) {
            DbA = DbA(os);
        } else {
            DbA = Os(os);
        }
        if (DbA == null) {
            os.eli(new nlS());
        } else {
            os.eli(new NU(DbA, null, false));
        }
    }

    @Override // com.bytedance.sdk.component.ui.ui.FC
    public String eli() {
        return "memory_cache";
    }

    private Bitmap DbA(com.bytedance.sdk.component.ui.Os.Os os) {
        Collection<dV> eli = os.nGm().eli();
        Bitmap bitmap = null;
        if (eli == null) {
            return null;
        }
        Iterator<dV> it = eli.iterator();
        while (it.hasNext() && (bitmap = it.next().eli(os.aAs())) == null) {
        }
        return bitmap;
    }

    private Bitmap Os(com.bytedance.sdk.component.ui.Os.Os os) {
        return os.nGm().eli(os.QX()).eli(os.aAs());
    }
}
