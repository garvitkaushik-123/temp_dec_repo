package com.ironsource;

import com.ironsource.N0;

/* loaded from: classes6.dex */
public final class Cd {
    /* JADX INFO: Access modifiers changed from: private */
    public static final N0 b(Gd gd, boolean z) {
        return new N0(z ? N0.a.MANUAL : gd.k().e() ? N0.a.AUTOMATIC_LOAD_WHILE_SHOW : N0.a.AUTOMATIC_LOAD_AFTER_CLOSE, gd.k().j(), gd.k().b(), -1L);
    }
}
