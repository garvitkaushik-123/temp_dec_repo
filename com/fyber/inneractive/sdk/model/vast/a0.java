package com.fyber.inneractive.sdk.model.vast;

import com.fyber.inneractive.sdk.util.u1;
import org.w3c.dom.Node;

/* loaded from: classes4.dex */
public final class a0 extends g {
    public String i;

    public a0() {
        this.f = 1;
    }

    public static a0 c(Node node) {
        a0 a0Var = new a0();
        super.b(node);
        a0Var.i = u1.a(u1.d(node, "VASTAdTagURI"));
        return a0Var;
    }
}
