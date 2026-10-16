package com.bytedance.sdk.component.adexpress.DbA;

import com.bytedance.sdk.component.adexpress.DbA.aAs;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class nlS implements aAs.eli {
    private List<aAs> DbA;
    private FC Os;
    private AtomicBoolean aGH = new AtomicBoolean(false);
    Dfc eli;

    public nlS(List<aAs> list, FC fc) {
        this.DbA = list;
        this.Os = fc;
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.aAs.eli
    public void eli() {
        this.Os.aGH();
        Iterator<aAs> it = this.DbA.iterator();
        while (it.hasNext() && !it.next().eli(this)) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.aAs.eli
    public void eli(aAs aas) {
        int indexOf = this.DbA.indexOf(aas);
        if (indexOf < 0) {
            return;
        }
        do {
            indexOf++;
            if (indexOf >= this.DbA.size()) {
                return;
            }
        } while (!this.DbA.get(indexOf).eli(this));
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.aAs.eli
    public boolean DbA(aAs aas) {
        int indexOf = this.DbA.indexOf(aas);
        return indexOf < this.DbA.size() - 1 && indexOf >= 0;
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.aAs.eli
    public Dfc DbA() {
        return this.eli;
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.aAs.eli
    public void eli(Dfc dfc) {
        this.eli = dfc;
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.aAs.eli
    public void eli(boolean z) {
        this.aGH.getAndSet(z);
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.aAs.eli
    public boolean Os() {
        return this.aGH.get();
    }
}
