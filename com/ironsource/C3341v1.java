package com.ironsource;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.v1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3341v1 extends AbstractC3326u3 {
    public C3341v1() {
        this.H = "outcome";
        this.G = 4;
        this.I = IronSourceConstants.APP_EVENT_TYPE;
        e();
    }

    @Override // com.ironsource.AbstractC3326u3
    protected int c(C3413z5 c3413z5) {
        return 1;
    }

    @Override // com.ironsource.AbstractC3326u3
    protected void d() {
    }

    @Override // com.ironsource.AbstractC3326u3
    protected String e(int i) {
        return "";
    }

    @Override // com.ironsource.AbstractC3326u3
    protected void f(C3413z5 c3413z5) {
    }

    @Override // com.ironsource.AbstractC3326u3
    protected boolean h(C3413z5 c3413z5) {
        return false;
    }

    @Override // com.ironsource.AbstractC3326u3
    protected boolean j(C3413z5 c3413z5) {
        return false;
    }

    @Override // com.ironsource.AbstractC3326u3
    protected boolean d(C3413z5 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int c = event.c();
        return c == A5.FIRST_INSTANCE.b() || c == A5.INIT_COMPLETE.b() || c == A5.SDK_INIT_FAILED.b() || c == A5.SDK_INIT_SUCCESS.b();
    }
}
