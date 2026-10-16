package com.bytedance.sdk.component.ui.ui;

/* loaded from: classes3.dex */
public class nlS extends eli {
    @Override // com.bytedance.sdk.component.ui.ui.FC
    public void eli(com.bytedance.sdk.component.ui.Os.Os os) {
        byte[] eli = os.nGm().DbA(os.QX()).eli(os.FC());
        if (eli == null) {
            os.eli(new MGA());
        } else {
            os.eli(new DbA(eli, null));
        }
    }

    @Override // com.bytedance.sdk.component.ui.ui.FC
    public String eli() {
        return "raw_cache";
    }
}
