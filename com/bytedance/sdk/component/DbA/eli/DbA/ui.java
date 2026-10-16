package com.bytedance.sdk.component.DbA.eli.DbA;

/* loaded from: classes3.dex */
final class ui {
    int DbA;
    ui MGA;
    int Os;
    boolean aGH;
    final byte[] eli;
    ui kb;
    boolean ui;

    ui() {
        this.eli = new byte[8192];
        this.ui = true;
        this.aGH = false;
    }

    ui(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.eli = bArr;
        this.DbA = i;
        this.Os = i2;
        this.aGH = z;
        this.ui = z2;
    }

    final ui eli() {
        this.aGH = true;
        return new ui(this.eli, this.DbA, this.Os, true, false);
    }

    public final ui DbA() {
        ui uiVar = this.MGA;
        ui uiVar2 = uiVar != this ? uiVar : null;
        ui uiVar3 = this.kb;
        if (uiVar3 != null) {
            uiVar3.MGA = uiVar;
        }
        ui uiVar4 = this.MGA;
        if (uiVar4 != null) {
            uiVar4.kb = uiVar3;
        }
        this.MGA = null;
        this.kb = null;
        return uiVar2;
    }

    public final ui eli(ui uiVar) {
        uiVar.kb = this;
        uiVar.MGA = this.MGA;
        this.MGA.kb = uiVar;
        this.MGA = uiVar;
        return uiVar;
    }
}
