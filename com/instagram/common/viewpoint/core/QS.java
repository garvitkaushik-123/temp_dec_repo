package com.instagram.common.viewpoint.core;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: assets/audience_network/classes2.dex */
public class QS implements Runnable {
    public final /* synthetic */ C7P A00;
    public final /* synthetic */ ArrayList A01;

    public QS(C7P c7p, ArrayList arrayList) {
        this.A00 = c7p;
        this.A01 = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator it = this.A01.iterator();
        while (it.hasNext()) {
            QZ change = (QZ) it.next();
            this.A00.A0c(change);
        }
        this.A01.clear();
        this.A00.A03.remove(this.A01);
    }
}
