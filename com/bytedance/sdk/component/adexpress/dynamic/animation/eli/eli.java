package com.bytedance.sdk.component.adexpress.dynamic.animation.eli;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class eli extends aGH {
    public eli(View view, com.bytedance.sdk.component.adexpress.dynamic.aGH.eli eliVar) {
        super(view, eliVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.eli.aGH
    List<ObjectAnimator> eli() {
        float nGm = this.DbA.nGm() / 100.0f;
        float QX = this.DbA.QX() / 100.0f;
        if ("reverse".equals(this.DbA.aqO()) && this.DbA.nn() <= 0.0d) {
            QX = nGm;
            nGm = QX;
        }
        this.Os.setAlpha(nGm);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.Os, "alpha", nGm, QX).setDuration((int) (this.DbA.aAs() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(eli(duration));
        return arrayList;
    }
}
