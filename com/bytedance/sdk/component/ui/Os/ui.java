package com.bytedance.sdk.component.ui.Os;

import android.content.Context;
import com.bytedance.sdk.component.ui.NU;
import com.bytedance.sdk.component.ui.Xb;
import com.bytedance.sdk.component.ui.bf;
import com.bytedance.sdk.component.ui.dV;
import com.bytedance.sdk.component.ui.nGm;
import com.bytedance.sdk.component.ui.nlS;
import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
public class ui implements NU {
    private ExecutorService DbA;
    private bf FC;
    private com.bytedance.sdk.component.ui.Os MGA;
    private com.bytedance.sdk.component.ui.aGH Os;
    private boolean aAs;
    private dV aGH;
    private nlS eli;
    private com.bytedance.sdk.component.ui.DbA kb;
    private nGm ui;
    private Xb wC;

    private ui(eli eliVar) {
        this.eli = eliVar.eli;
        this.DbA = eliVar.DbA;
        this.Os = eliVar.Os;
        this.aGH = eliVar.aGH;
        this.ui = eliVar.ui;
        this.MGA = eliVar.MGA;
        this.kb = eliVar.kb;
        this.wC = eliVar.wC;
        this.FC = eliVar.FC;
        this.aAs = eliVar.aAs;
    }

    @Override // com.bytedance.sdk.component.ui.NU
    public nlS eli() {
        return this.eli;
    }

    @Override // com.bytedance.sdk.component.ui.NU
    public ExecutorService DbA() {
        return this.DbA;
    }

    @Override // com.bytedance.sdk.component.ui.NU
    public com.bytedance.sdk.component.ui.aGH aGH() {
        return this.Os;
    }

    @Override // com.bytedance.sdk.component.ui.NU
    public dV ui() {
        return this.aGH;
    }

    @Override // com.bytedance.sdk.component.ui.NU
    public nGm MGA() {
        return this.ui;
    }

    @Override // com.bytedance.sdk.component.ui.NU
    public com.bytedance.sdk.component.ui.Os kb() {
        return this.MGA;
    }

    @Override // com.bytedance.sdk.component.ui.NU
    public Xb Os() {
        return this.wC;
    }

    @Override // com.bytedance.sdk.component.ui.NU
    public com.bytedance.sdk.component.ui.DbA wC() {
        return this.kb;
    }

    @Override // com.bytedance.sdk.component.ui.NU
    public bf FC() {
        return this.FC;
    }

    @Override // com.bytedance.sdk.component.ui.NU
    public boolean aAs() {
        return this.aAs;
    }

    public static ui eli(Context context) {
        return new eli().eli();
    }

    public static class eli {
        private ExecutorService DbA;
        private bf FC;
        private com.bytedance.sdk.component.ui.Os MGA;
        private com.bytedance.sdk.component.ui.aGH Os;
        private boolean aAs;
        private dV aGH;
        private nlS eli;
        private com.bytedance.sdk.component.ui.DbA kb;
        private nGm ui;
        private Xb wC;

        public eli eli(com.bytedance.sdk.component.ui.DbA dbA) {
            this.kb = dbA;
            return this;
        }

        public eli eli(bf bfVar) {
            this.FC = bfVar;
            return this;
        }

        public eli eli(Xb xb) {
            this.wC = xb;
            return this;
        }

        public eli eli(com.bytedance.sdk.component.ui.aGH agh) {
            this.Os = agh;
            return this;
        }

        public eli eli(boolean z) {
            this.aAs = z;
            return this;
        }

        public ui eli() {
            return new ui(this);
        }
    }
}
