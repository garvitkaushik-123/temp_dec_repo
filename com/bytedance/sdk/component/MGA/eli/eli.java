package com.bytedance.sdk.component.MGA.eli;

/* loaded from: classes3.dex */
public class eli {
    private com.bytedance.sdk.component.MGA.eli.DbA.Os DbA;
    private ui FC;
    private com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli MGA;
    private long NU;
    private com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli Os;
    private boolean aAs;
    private com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli aGH;
    private int du;
    private com.bytedance.sdk.component.MGA.eli.eli.ui eli;
    private com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli kb;
    private int nlS;
    private com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli ui;
    private boolean wC;

    private eli() {
        this.du = 200;
        this.nlS = 10;
    }

    public com.bytedance.sdk.component.MGA.eli.eli.ui eli() {
        return this.eli;
    }

    public com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli DbA() {
        return this.MGA;
    }

    public boolean Os() {
        return this.aAs;
    }

    public ui aGH() {
        return this.FC;
    }

    public long ui() {
        return this.NU;
    }

    public com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli MGA() {
        return this.kb;
    }

    public com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli kb() {
        return this.Os;
    }

    public com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli wC() {
        return this.aGH;
    }

    public com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli FC() {
        return this.ui;
    }

    public com.bytedance.sdk.component.MGA.eli.DbA.Os aAs() {
        return this.DbA;
    }

    public boolean du() {
        return this.wC;
    }

    public int nlS() {
        return this.du;
    }

    public int NU() {
        return this.nlS;
    }

    /* renamed from: com.bytedance.sdk.component.MGA.eli.eli$eli, reason: collision with other inner class name */
    public static class C0134eli {
        private com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli DbA;
        private boolean FC;
        private boolean MGA;
        private com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli Os;
        private com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli aGH;
        private com.bytedance.sdk.component.MGA.eli.DbA.Os eli;
        private ui kb;
        private long nlS;
        private com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli ui;
        private com.bytedance.sdk.component.MGA.eli.eli.ui wC;
        private int aAs = 5000;
        private int du = 10;

        public C0134eli eli(long j) {
            this.nlS = j;
            return this;
        }

        public C0134eli eli(com.bytedance.sdk.component.MGA.eli.eli.ui uiVar) {
            this.wC = uiVar;
            return this;
        }

        public C0134eli eli(ui uiVar) {
            this.kb = uiVar;
            return this;
        }

        public C0134eli eli(boolean z) {
            this.MGA = z;
            return this;
        }

        public C0134eli eli(com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli eliVar) {
            this.DbA = eliVar;
            return this;
        }

        public C0134eli DbA(com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli eliVar) {
            this.Os = eliVar;
            return this;
        }

        public C0134eli Os(com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli eliVar) {
            this.aGH = eliVar;
            return this;
        }

        public C0134eli eli(com.bytedance.sdk.component.MGA.eli.DbA.Os os) {
            this.eli = os;
            return this;
        }

        public C0134eli eli(int i) {
            this.aAs = i;
            return this;
        }

        public C0134eli DbA(int i) {
            this.du = i;
            return this;
        }

        public eli eli() {
            eli eliVar = new eli();
            eliVar.DbA = this.eli;
            eliVar.Os = this.DbA;
            eliVar.aGH = this.Os;
            eliVar.ui = this.aGH;
            eliVar.MGA = this.ui;
            eliVar.wC = this.MGA;
            eliVar.FC = this.kb;
            eliVar.eli = this.wC;
            eliVar.aAs = this.FC;
            eliVar.nlS = this.du;
            eliVar.du = this.aAs;
            eliVar.NU = this.nlS;
            return eliVar;
        }
    }
}
