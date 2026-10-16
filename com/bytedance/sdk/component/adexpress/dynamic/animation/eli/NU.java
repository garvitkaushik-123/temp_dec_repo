package com.bytedance.sdk.component.adexpress.dynamic.animation.eli;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class NU extends aGH {
    public NU(View view, com.bytedance.sdk.component.adexpress.dynamic.aGH.eli eliVar) {
        super(view, eliVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.eli.aGH
    List<ObjectAnimator> eli() {
        if ((this.Os instanceof ImageView) && (this.Os.getParent() instanceof com.bytedance.sdk.component.adexpress.dynamic.dynamicview.du)) {
            this.Os = (View) this.Os.getParent();
            ((ViewGroup) this.Os).setClipChildren(true);
            ((ViewGroup) this.Os.getParent()).setClipChildren(true);
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.Os, "stretchValue", 0.0f, 1.0f).setDuration((int) (this.DbA.aAs() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(eli(duration));
        return arrayList;
    }
}
