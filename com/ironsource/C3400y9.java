package com.ironsource;

import com.ironsource.AbstractC3326u3;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.utils.IronSourceConstants;

/* renamed from: com.ironsource.y9, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3400y9 extends AbstractC3326u3 {
    private static C3400y9 R;
    private String P;
    private final K8 Q = C3334ub.U().s();

    private C3400y9() {
        this.H = "ironbeast";
        this.G = 2;
        this.I = IronSourceConstants.INTERSTITIAL_EVENT_TYPE;
        this.P = "";
    }

    public static synchronized C3400y9 i() {
        C3400y9 c3400y9;
        synchronized (C3400y9.class) {
            if (R == null) {
                C3400y9 c3400y92 = new C3400y9();
                R = c3400y92;
                c3400y92.e();
            }
            c3400y9 = R;
        }
        return c3400y9;
    }

    @Override // com.ironsource.AbstractC3326u3
    protected int c(C3413z5 c3413z5) {
        int f = f(c3413z5.c());
        return f == AbstractC3326u3.e.BANNER.b() ? this.Q.a(IronSource.AD_UNIT.BANNER) : f == AbstractC3326u3.e.NATIVE_AD.b() ? this.Q.a(IronSource.AD_UNIT.NATIVE_AD) : this.Q.a(IronSource.AD_UNIT.INTERSTITIAL);
    }

    @Override // com.ironsource.AbstractC3326u3
    protected boolean d(C3413z5 c3413z5) {
        int c = c3413z5.c();
        return c == A5.IS_CALLBACK_LOAD_SUCCESS.b() || c == A5.IS_INSTANCE_OPENED.b() || c == A5.IS_INSTANCE_CLOSED.b() || c == A5.IS_AUCTION_SUCCESS.b() || c == A5.IS_AUCTION_FAILED.b() || c == A5.BN_INSTANCE_SHOW.b() || c == A5.BN_AUCTION_SUCCESS.b() || c == A5.BN_AUCTION_FAILED.b() || c == A5.NT_INSTANCE_LOAD_SUCCESS.b() || c == A5.NT_INSTANCE_SHOW.b() || c == A5.NT_AUCTION_SUCCESS.b() || c == A5.NT_AUCTION_FAILED.b();
    }

    @Override // com.ironsource.AbstractC3326u3
    protected String e(int i) {
        return this.P;
    }

    @Override // com.ironsource.AbstractC3326u3
    protected void f(C3413z5 c3413z5) {
        this.P = c3413z5.b().optString("placement");
    }

    @Override // com.ironsource.AbstractC3326u3
    protected boolean j(C3413z5 c3413z5) {
        return false;
    }

    @Override // com.ironsource.AbstractC3326u3
    protected void d() {
        this.J.add(Integer.valueOf(A5.IS_LOAD_CALLED.b()));
        this.J.add(Integer.valueOf(A5.IS_INSTANCE_LOAD.b()));
        this.J.add(Integer.valueOf(A5.IS_INSTANCE_LOAD_SUCCESS.b()));
        this.J.add(Integer.valueOf(A5.IS_CALLBACK_LOAD_SUCCESS.b()));
        this.J.add(Integer.valueOf(A5.IS_INSTANCE_LOAD_FAILED.b()));
        this.J.add(Integer.valueOf(A5.IS_INSTANCE_LOAD_NO_FILL.b()));
        this.J.add(Integer.valueOf(A5.IS_INSTANCE_READY_TRUE.b()));
        this.J.add(Integer.valueOf(A5.IS_INSTANCE_READY_FALSE.b()));
        this.J.add(Integer.valueOf(A5.BN_LOAD.b()));
        this.J.add(Integer.valueOf(A5.BN_CALLBACK_LOAD_ERROR.b()));
        this.J.add(Integer.valueOf(A5.BN_RELOAD.b()));
        this.J.add(Integer.valueOf(A5.BN_CALLBACK_RELOAD_ERROR.b()));
        this.J.add(Integer.valueOf(A5.BN_CALLBACK_RELOAD_SUCCESS.b()));
        this.J.add(Integer.valueOf(A5.BN_INSTANCE_LOAD.b()));
        this.J.add(Integer.valueOf(A5.BN_INSTANCE_RELOAD.b()));
        this.J.add(Integer.valueOf(A5.BN_INSTANCE_LOAD_SUCCESS.b()));
        this.J.add(Integer.valueOf(A5.BN_INSTANCE_LOAD_ERROR.b()));
        this.J.add(Integer.valueOf(A5.BN_INSTANCE_RELOAD_SUCCESS.b()));
        this.J.add(Integer.valueOf(A5.BN_INSTANCE_RELOAD_ERROR.b()));
        this.J.add(Integer.valueOf(A5.BN_INSTANCE_UNEXPECTED_LOAD_SUCCESS.b()));
        this.J.add(Integer.valueOf(A5.BN_INSTANCE_UNEXPECTED_RELOAD_SUCCESS.b()));
        this.J.add(Integer.valueOf(A5.BN_INSTANCE_SHOW.b()));
        this.J.add(Integer.valueOf(A5.NT_LOAD.b()));
        this.J.add(Integer.valueOf(A5.NT_CALLBACK_LOAD_ERROR.b()));
        this.J.add(Integer.valueOf(A5.NT_INSTANCE_LOAD.b()));
        this.J.add(Integer.valueOf(A5.NT_INSTANCE_LOAD_SUCCESS.b()));
        this.J.add(Integer.valueOf(A5.NT_INSTANCE_LOAD_ERROR.b()));
        this.J.add(Integer.valueOf(A5.NT_INSTANCE_SHOW.b()));
    }
}
