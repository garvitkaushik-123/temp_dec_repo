package com.instagram.common.viewpoint.core;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: assets/audience_network/classes2.dex */
public class QT implements Runnable {
    public final /* synthetic */ C7P A00;
    public final /* synthetic */ ArrayList A01;

    public QT(C7P c7p, ArrayList arrayList) {
        this.A00 = c7p;
        this.A01 = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator it = this.A01.iterator();
        while (it.hasNext()) {
            RK holder = (RK) it.next();
            this.A00.A0d(holder);
        }
        this.A01.clear();
        this.A00.A01.remove(this.A01);
    }
}
