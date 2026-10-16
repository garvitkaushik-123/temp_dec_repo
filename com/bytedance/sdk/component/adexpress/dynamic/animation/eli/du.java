package com.bytedance.sdk.component.adexpress.dynamic.animation.eli;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class du extends aGH {
    public du(View view, com.bytedance.sdk.component.adexpress.dynamic.aGH.eli eliVar) {
        super(view, eliVar);
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.setClipChildren(false);
            viewGroup.setClipToPadding(false);
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            if (viewGroup2 == null || !(viewGroup2 instanceof com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui)) {
                return;
            }
            viewGroup2.setClipChildren(false);
            viewGroup2.setClipToPadding(false);
            ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getParent();
            if (viewGroup3 == null || !(viewGroup3 instanceof com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui)) {
                return;
            }
            viewGroup3.setClipChildren(false);
            viewGroup3.setClipToPadding(false);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.eli.aGH
    List<ObjectAnimator> eli() {
        float f;
        float du = (float) this.DbA.du();
        float nlS = (float) this.DbA.nlS();
        String aqO = this.DbA.aqO();
        float f2 = 1.0f;
        if ("reverse".equals(aqO) || "alternate-reverse".equals(aqO)) {
            f = 1.0f;
        } else {
            f = nlS;
            nlS = 1.0f;
            f2 = du;
            du = 1.0f;
        }
        this.Os.setTag(2097610710, this.DbA.DbA());
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.Os, "scaleX", du, f2).setDuration((int) (this.DbA.aAs() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.Os, "scaleY", nlS, f).setDuration((int) (this.DbA.aAs() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(eli(duration));
        arrayList.add(eli(duration2));
        return arrayList;
    }
}
