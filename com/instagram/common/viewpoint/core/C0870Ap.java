package com.instagram.common.viewpoint.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* renamed from: com.facebook.ads.redexgen.X.Ap, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C0870Ap implements InterfaceC2533rI {
    public final /* synthetic */ C0869Ao A00;

    public C0870Ap(C0869Ao c0869Ao) {
        this.A00 = c0869Ao;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2533rI
    public final void AFq() {
        LinkedHashMap linkedHashMap;
        LinkedHashMap linkedHashMap2;
        ArrayList arrayList;
        LinkedHashMap linkedHashMap3;
        LinkedHashMap linkedHashMap4;
        InterfaceC2533rI interfaceC2533rI;
        InterfaceC2533rI interfaceC2533rI2;
        linkedHashMap = this.A00.A06;
        synchronized (linkedHashMap) {
            linkedHashMap2 = this.A00.A06;
            arrayList = new ArrayList(linkedHashMap2.size());
            linkedHashMap3 = this.A00.A06;
            for (Runnable runnable : linkedHashMap3.values()) {
                if (runnable != null) {
                    arrayList.add(runnable);
                }
            }
            linkedHashMap4 = this.A00.A06;
            linkedHashMap4.clear();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        interfaceC2533rI = this.A00.A01;
        if (interfaceC2533rI != null) {
            interfaceC2533rI2 = this.A00.A01;
            interfaceC2533rI2.AFq();
        }
    }
}
