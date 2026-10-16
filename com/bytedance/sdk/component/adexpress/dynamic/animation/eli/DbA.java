package com.bytedance.sdk.component.adexpress.dynamic.animation.eli;

import android.view.View;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class DbA implements Cp {
    List<aGH> eli = new ArrayList();

    public DbA(View view, List<com.bytedance.sdk.component.adexpress.dynamic.aGH.eli> list) {
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.aGH.eli> it = list.iterator();
        while (it.hasNext()) {
            aGH eli = Os.eli().eli(view, it.next());
            if (eli != null) {
                this.eli.add(eli);
            }
        }
    }

    public void eli() {
        Iterator<aGH> it = this.eli.iterator();
        while (it.hasNext()) {
            try {
                it.next().Os();
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cp
    public void DbA() {
        Iterator<aGH> it = this.eli.iterator();
        while (it.hasNext()) {
            try {
                it.next().DbA();
            } catch (Exception unused) {
            }
        }
    }
}
