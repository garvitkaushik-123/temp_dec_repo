package com.ironsource;

import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public final class Qc extends AbstractC3326u3 {
    public static final Qc P;

    public static final class a {
        public final void a() {
            new J9().b(ContextProvider.getInstance().getApplicationContext());
            Qc.P.a(new C3413z5(A5.INIT_DEFERRED_DATA, new X8().a()));
        }
    }

    static {
        Qc qc = new Qc();
        P = qc;
        qc.H = "outcome";
        qc.G = 0;
        qc.I = IronSourceConstants.PIXEL_EVENT_TYPE;
        qc.e();
    }

    private Qc() {
    }

    @Override // com.ironsource.AbstractC3326u3
    protected void a(ArrayList<C3413z5> arrayList) {
    }

    @Override // com.ironsource.AbstractC3326u3
    protected int c(C3413z5 c3413z5) {
        return 1;
    }

    @Override // com.ironsource.AbstractC3326u3
    protected void d() {
    }

    @Override // com.ironsource.AbstractC3326u3
    protected boolean d(C3413z5 c3413z5) {
        return true;
    }

    @Override // com.ironsource.AbstractC3326u3
    protected String e(int i) {
        return "";
    }

    @Override // com.ironsource.AbstractC3326u3
    protected void f(C3413z5 c3413z5) {
    }

    @Override // com.ironsource.AbstractC3326u3
    protected boolean g(C3413z5 c3413z5) {
        return false;
    }

    @Override // com.ironsource.AbstractC3326u3
    protected boolean h(C3413z5 c3413z5) {
        return false;
    }

    @Override // com.ironsource.AbstractC3326u3
    protected boolean j(C3413z5 c3413z5) {
        return false;
    }
}
