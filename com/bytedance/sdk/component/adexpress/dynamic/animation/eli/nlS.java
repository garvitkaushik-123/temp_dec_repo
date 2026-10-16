package com.bytedance.sdk.component.adexpress.dynamic.animation.eli;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class nlS extends aGH {
    public nlS(View view, com.bytedance.sdk.component.adexpress.dynamic.aGH.eli eliVar) {
        super(view, eliVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.eli.aGH
    List<ObjectAnimator> eli() {
        int i;
        int i2;
        this.Os.setTag(2097610711, Integer.valueOf(this.DbA.aGH()));
        if (this.Os == null || !com.bytedance.sdk.component.adexpress.aGH.DbA.eli(this.Os.getContext())) {
            i = 0;
            i2 = 1;
        } else {
            i2 = 0;
            i = 1;
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.Os, "shineValue", i, i2).setDuration((int) (this.DbA.aAs() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(eli(duration));
        return arrayList;
    }
}
