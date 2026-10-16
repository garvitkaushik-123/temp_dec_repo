package com.fyber.inneractive.sdk.mraid;

import com.fyber.inneractive.sdk.util.e1;
import com.fyber.inneractive.sdk.web.i0;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class t extends f {
    public t(LinkedHashMap linkedHashMap, i0 i0Var, e1 e1Var) {
        super(linkedHashMap, i0Var, e1Var);
    }

    @Override // com.fyber.inneractive.sdk.mraid.f
    public final void a() {
        Map map = this.b;
        this.c.setOrientationProperties((map != null && map.containsKey("allowOrientationChange") && "false".equals(this.b.get("allowOrientationChange"))) ? false : true, (String) this.b.get("forceOrientation"));
    }

    @Override // com.fyber.inneractive.sdk.mraid.f
    public final boolean b() {
        return false;
    }
}
