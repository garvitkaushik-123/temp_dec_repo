package com.bytedance.adsdk.ugeno.aGH.eli;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class DbA implements Os {
    private List<aGH> eli = new CopyOnWriteArrayList();

    @Override // com.bytedance.adsdk.ugeno.aGH.eli.Os
    public void eli(aGH agh) {
        this.eli.add(agh);
    }

    @Override // com.bytedance.adsdk.ugeno.aGH.eli.Os
    public void eli(String str) {
        if (this.eli.isEmpty()) {
            return;
        }
        Iterator<aGH> it = this.eli.iterator();
        while (it.hasNext()) {
            it.next().eli(str);
        }
    }
}
