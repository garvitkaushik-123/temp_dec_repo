package com.bytedance.sdk.component.adexpress.dynamic.animation.eli;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class kb extends aGH {
    public kb(View view, com.bytedance.sdk.component.adexpress.dynamic.aGH.eli eliVar) {
        super(view, eliVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.eli.aGH
    List<ObjectAnimator> eli() {
        this.Os.setTag(2097610709, Integer.valueOf(this.DbA.Os()));
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.Os, "marqueeValue", 0.0f, 1.0f).setDuration((int) (this.DbA.aAs() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(eli(duration));
        return arrayList;
    }
}
