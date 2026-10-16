package com.fyber.inneractive.sdk.model.vast;

import com.fyber.inneractive.sdk.util.u1;
import java.util.ArrayList;
import java.util.Iterator;
import org.w3c.dom.Node;

/* loaded from: classes4.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public String f1294a;
    public ArrayList b;

    public static u a(Node node) {
        f fVar;
        u uVar = new u();
        uVar.f1294a = u1.b(node, "version");
        ArrayList c = u1.c(node, "Ad");
        if (!c.isEmpty()) {
            uVar.b = new ArrayList();
            Iterator it = c.iterator();
            while (it.hasNext()) {
                Node node2 = (Node) it.next();
                if (node2 == null) {
                    fVar = null;
                } else {
                    f fVar2 = new f();
                    fVar2.f1284a = u1.b(node2, "id");
                    Node d = u1.d(node2, "Wrapper");
                    if (d != null) {
                        fVar2.b = a0.c(d);
                    }
                    Node d2 = u1.d(node2, "InLine");
                    if (d2 != null) {
                        fVar2.c = p.c(d2);
                    }
                    fVar = fVar2;
                }
                uVar.b.add(fVar);
            }
        }
        return uVar;
    }

    public final String toString() {
        return new StringBuilder("Vast: version - " + this.f1294a + "\nAds: ").toString();
    }
}
