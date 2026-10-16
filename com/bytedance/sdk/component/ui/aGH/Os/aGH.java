package com.bytedance.sdk.component.ui.aGH.Os;

import com.bytedance.sdk.component.ui.du;
import java.util.Map;

/* loaded from: classes3.dex */
public class aGH<T> implements du {
    private String DbA;
    private boolean FC;
    private int MGA;
    private T Os;
    private com.bytedance.sdk.component.ui.kb aAs;
    private T aGH;
    private int du;
    private String eli;
    private Map<String, String> kb;
    private int ui;
    private boolean wC;

    public aGH eli(Os os, T t) {
        this.Os = t;
        this.eli = os.aAs();
        this.DbA = os.eli();
        this.ui = os.DbA();
        this.MGA = os.Os();
        this.FC = os.NU();
        this.aAs = os.Dfc();
        this.du = os.aqO();
        return this;
    }

    public aGH eli(Os os, T t, Map<String, String> map, boolean z) {
        this.kb = map;
        this.wC = z;
        return eli(os, t);
    }

    @Override // com.bytedance.sdk.component.ui.du
    public String eli() {
        return this.DbA;
    }

    @Override // com.bytedance.sdk.component.ui.du
    public T DbA() {
        return this.Os;
    }

    @Override // com.bytedance.sdk.component.ui.du
    public T Os() {
        return this.aGH;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.component.ui.du
    public void eli(Object obj) {
        this.aGH = this.Os;
        this.Os = obj;
    }

    @Override // com.bytedance.sdk.component.ui.du
    public Map<String, String> aGH() {
        return this.kb;
    }

    @Override // com.bytedance.sdk.component.ui.du
    public boolean ui() {
        return this.wC;
    }

    @Override // com.bytedance.sdk.component.ui.du
    public boolean MGA() {
        return this.FC;
    }

    @Override // com.bytedance.sdk.component.ui.du
    public int kb() {
        return this.du;
    }
}
