package com.instagram.common.viewpoint.core;

/* loaded from: assets/audience_network/classes2.dex */
public class PT implements InterfaceC1463Ya {
    public static String[] A02 = {"YUGwJzzikBNzfLIllCMdkir2Jyj8DuFq", "ntVfVONdyCctXWp", "AonpNDk7AlTTh7WnvPqW51ITIbVwFUJp", "NJZ9S98WzFijxyBcJxql7T6JOIFmEfw7", "8QFO", "nOxceDp", "zcnAPzBVA2CXXQsDQKs94da1Vf1b77Qu", "s6TvhQwfXdUE9Ss2QaqLkXkKVbAwWXrL"};
    public final /* synthetic */ C1291Re A00;
    public final /* synthetic */ PJ A01;

    public PT(PJ pj, C1291Re c1291Re) {
        this.A01 = pj;
        this.A00 = c1291Re;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1463Ya
    public final void ACl(AbstractC1464Yb abstractC1464Yb) {
        if (abstractC1464Yb.getToolbarActionMode() == 8) {
            this.A01.A0d();
            return;
        }
        this.A01.A0G.A04(VH.A07, null);
        if (this.A01.A0l()) {
            return;
        }
        PJ pj = this.A01;
        if (A02[3].charAt(29) != 'f') {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[0] = "pLKL5MIsKfCUMWoMxvxDNCAoAO8BGlnS";
        strArr[7] = "7PsgTAKpTeXTqL7VuWAjeXRdKL6HZN4L";
        if (pj.A0i()) {
            this.A01.A0h(this.A00);
        } else {
            this.A01.A0E.A0F().AB0();
            this.A00.finish(1);
        }
    }
}
