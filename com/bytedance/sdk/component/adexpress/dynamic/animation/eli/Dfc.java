package com.bytedance.sdk.component.adexpress.dynamic.animation.eli;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class Dfc extends aGH {
    public Dfc(View view, com.bytedance.sdk.component.adexpress.dynamic.aGH.eli eliVar) {
        super(view, eliVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.eli.aGH
    List<ObjectAnimator> eli() {
        float f;
        float eli = com.bytedance.sdk.component.adexpress.aGH.kb.eli(com.bytedance.sdk.component.adexpress.aGH.eli(), this.DbA.MGA());
        float eli2 = com.bytedance.sdk.component.adexpress.aGH.kb.eli(com.bytedance.sdk.component.adexpress.aGH.eli(), this.DbA.kb());
        float f2 = 0.0f;
        if ("reverse".equals(this.DbA.aqO())) {
            f = eli2;
            eli2 = 0.0f;
            f2 = eli;
            eli = 0.0f;
        } else {
            f = 0.0f;
        }
        if (com.bytedance.sdk.component.adexpress.aGH.DbA.eli(this.Os.getContext())) {
            eli = -eli;
            f2 = -f2;
        }
        this.Os.setTranslationX(eli);
        this.Os.setTranslationY(eli2);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.Os, "translationX", eli, f2).setDuration((int) (this.DbA.aAs() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.Os, "translationY", eli2, f).setDuration((int) (this.DbA.aAs() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(eli(duration));
        arrayList.add(eli(duration2));
        return arrayList;
    }
}
