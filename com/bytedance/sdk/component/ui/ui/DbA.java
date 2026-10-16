package com.bytedance.sdk.component.ui.ui;

/* loaded from: classes3.dex */
public class DbA implements FC {
    private com.bytedance.sdk.component.ui.MGA DbA;
    private byte[] eli;

    public DbA(byte[] bArr, com.bytedance.sdk.component.ui.MGA mga) {
        this.eli = bArr;
        this.DbA = mga;
    }

    @Override // com.bytedance.sdk.component.ui.ui.FC
    public void eli(com.bytedance.sdk.component.ui.Os.Os os) {
        FC wCVar;
        int nlS = os.nlS();
        os.eli(this.eli.length);
        if (nlS != 2) {
            if (nlS == 3) {
                byte[] bArr = this.eli;
                wCVar = new NU(bArr, this.DbA, com.bytedance.sdk.component.utils.MGA.DbA(bArr));
            } else {
                boolean DbA = com.bytedance.sdk.component.utils.MGA.DbA(this.eli);
                if (DbA) {
                    wCVar = new NU(this.eli, this.DbA, DbA);
                } else if (com.bytedance.sdk.component.utils.MGA.eli(this.eli)) {
                    wCVar = new ui(this.eli, this.DbA);
                } else {
                    wCVar = new NU(this.eli, this.DbA, DbA);
                }
            }
        } else if (com.bytedance.sdk.component.utils.MGA.eli(this.eli)) {
            wCVar = new ui(this.eli, this.DbA);
        } else if (this.DbA == null) {
            wCVar = new du();
        } else {
            wCVar = new wC(1001, "not image format", null);
        }
        os.eli(wCVar);
    }

    @Override // com.bytedance.sdk.component.ui.ui.FC
    public String eli() {
        return "image_type";
    }
}
