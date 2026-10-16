package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.utils.IronSourceConstants;

/* loaded from: classes6.dex */
public class Id extends AbstractC3326u3 {
    private static Id R;
    private String P;
    private final K8 Q = C3334ub.U().s();

    private Id() {
        this.H = "outcome";
        this.G = 3;
        this.I = IronSourceConstants.REWARDED_VIDEO_EVENT_TYPE;
        this.P = "";
    }

    public static synchronized Id i() {
        Id id;
        synchronized (Id.class) {
            if (R == null) {
                Id id2 = new Id();
                R = id2;
                id2.e();
            }
            id = R;
        }
        return id;
    }

    @Override // com.ironsource.AbstractC3326u3
    protected int c(C3413z5 c3413z5) {
        return this.Q.a(IronSource.AD_UNIT.REWARDED_VIDEO);
    }

    @Override // com.ironsource.AbstractC3326u3
    protected boolean d(C3413z5 c3413z5) {
        int c = c3413z5.c();
        return c == A5.FIRST_INSTANCE.b() || c == A5.INIT_COMPLETE.b() || c == A5.SDK_INIT_FAILED.b() || c == A5.SDK_INIT_SUCCESS.b() || c == A5.RV_BUSINESS_MEDIATION_LOAD_SUCCESS.b() || c == A5.RV_BUSINESS_INSTANCE_OPENED.b() || c == A5.RV_INSTANCE_CLOSED.b() || c == A5.RV_BUSINESS_INSTANCE_REWARDED.b() || c == A5.RV_AUCTION_FAILED.b() || c == A5.RV_AUCTION_SUCCESS.b();
    }

    @Override // com.ironsource.AbstractC3326u3
    protected String e(int i) {
        return (i == 15 || (i >= 300 && i < 400)) ? this.P : "";
    }

    @Override // com.ironsource.AbstractC3326u3
    protected void f(C3413z5 c3413z5) {
        if (c3413z5.c() == 15 || (c3413z5.c() >= 300 && c3413z5.c() < 400)) {
            this.P = c3413z5.b().optString("placement");
        }
    }

    @Override // com.ironsource.AbstractC3326u3
    protected boolean j(C3413z5 c3413z5) {
        return false;
    }

    @Override // com.ironsource.AbstractC3326u3
    protected void d() {
        this.J.add(Integer.valueOf(A5.RV_BUSINESS_MEDIATION_LOAD.b()));
        this.J.add(Integer.valueOf(A5.RV_BUSINESS_INSTANCE_LOAD.b()));
        this.J.add(Integer.valueOf(A5.RV_BUSINESS_INSTANCE_LOAD_SUCCESS.b()));
        this.J.add(Integer.valueOf(A5.RV_BUSINESS_MEDIATION_LOAD_SUCCESS.b()));
        this.J.add(Integer.valueOf(A5.RV_INSTANCE_LOAD_FAILED.b()));
        this.J.add(Integer.valueOf(A5.RV_INSTANCE_SHOW_CHANCE.b()));
        this.J.add(Integer.valueOf(A5.RV_INSTANCE_READY_TRUE.b()));
        this.J.add(Integer.valueOf(A5.RV_INSTANCE_READY_FALSE.b()));
        this.J.add(Integer.valueOf(A5.RV_INSTANCE_LOAD_FAILED_REASON.b()));
        this.J.add(Integer.valueOf(A5.RV_INSTANCE_LOAD_NO_FILL.b()));
        this.J.add(Integer.valueOf(A5.RV_MEDIATION_LOAD_ERROR.b()));
    }
}
