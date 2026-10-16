package com.bytedance.sdk.component.ui.aGH.DbA;

import android.text.TextUtils;
import com.bytedance.sdk.component.ui.QX;
import com.bytedance.sdk.component.utils.aqO;

/* loaded from: classes3.dex */
public class DbA implements MGA {
    @Override // com.bytedance.sdk.component.ui.aGH.DbA.MGA
    public boolean eli(com.bytedance.sdk.component.ui.aGH.Os.Os os, QX qx, com.bytedance.sdk.component.ui.aGH.Os.eli eliVar) {
        if (TextUtils.isEmpty(os.aAs())) {
            String eli = eli(os);
            os.DbA(eli);
            os.eli(eli);
        }
        os.eli();
        return true;
    }

    @Override // com.bytedance.sdk.component.ui.aGH.DbA.MGA
    public String eli() {
        return "generate_key";
    }

    private String eli(com.bytedance.sdk.component.ui.aGH.Os.Os os) {
        return aqO.eli(os.eli());
    }
}
