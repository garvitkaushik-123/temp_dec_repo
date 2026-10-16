package com.bytedance.sdk.component.adexpress.dynamic.animation.eli;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class MGA extends aGH {
    public MGA(View view, com.bytedance.sdk.component.adexpress.dynamic.aGH.eli eliVar) {
        super(view, eliVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.eli.aGH
    List<ObjectAnimator> eli() {
        float f = this.Os.getLayoutParams().width;
        this.Os.setTranslationX(f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.Os, "translationX", f, 0.0f).setDuration((int) (this.DbA.aAs() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.Os, "alpha", 0.0f, 1.0f).setDuration((int) (this.DbA.aAs() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(eli(duration));
        arrayList.add(eli(duration2));
        return arrayList;
    }
}
