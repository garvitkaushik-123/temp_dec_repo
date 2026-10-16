package com.bytedance.sdk.component.ui.ui;

import android.graphics.Bitmap;

/* loaded from: classes3.dex */
public class ui extends eli {
    private com.bytedance.sdk.component.ui.MGA DbA;
    private byte[] eli;

    public ui(byte[] bArr, com.bytedance.sdk.component.ui.MGA mga) {
        this.eli = bArr;
        this.DbA = mga;
    }

    @Override // com.bytedance.sdk.component.ui.ui.FC
    public void eli(com.bytedance.sdk.component.ui.Os.Os os) {
        com.bytedance.sdk.component.ui.Os.MGA nGm = os.nGm();
        com.bytedance.sdk.component.ui.Os.DbA.eli eli = nGm.eli(os);
        try {
            os.bf();
            Bitmap eli2 = eli.eli(this.eli);
            if (eli2 != null) {
                os.eli(new NU(eli2, this.DbA, false));
                nGm.eli(os.QX()).eli(os.aAs(), eli2);
                return;
            }
            eli(1002, "decode failed bitmap null", null, os);
        } catch (Throwable th) {
            eli(1002, "decode failed:" + th.getMessage(), th, os);
        }
    }

    private void eli(int i, String str, Throwable th, com.bytedance.sdk.component.ui.Os.Os os) {
        if (this.DbA == null) {
            os.eli(new du());
        } else {
            os.eli(new wC(i, str, th));
        }
    }

    @Override // com.bytedance.sdk.component.ui.ui.FC
    public String eli() {
        return "decode";
    }
}
