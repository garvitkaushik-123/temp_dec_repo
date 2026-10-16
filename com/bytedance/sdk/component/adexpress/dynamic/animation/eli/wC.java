package com.bytedance.sdk.component.adexpress.dynamic.animation.eli;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class wC extends aGH {
    public wC(View view, com.bytedance.sdk.component.adexpress.dynamic.aGH.eli eliVar) {
        super(view, eliVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.eli.aGH
    List<ObjectAnimator> eli() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.Os, "rippleValue", 0.0f, 1.0f).setDuration((int) (this.DbA.aAs() * 1000.0d));
        ((ViewGroup) this.Os.getParent()).setClipChildren(false);
        ((ViewGroup) this.Os.getParent().getParent()).setClipChildren(false);
        ((ViewGroup) this.Os.getParent().getParent().getParent()).setClipChildren(false);
        this.Os.setTag(2097610712, this.DbA.wC());
        ArrayList arrayList = new ArrayList();
        arrayList.add(eli(duration));
        return arrayList;
    }
}
