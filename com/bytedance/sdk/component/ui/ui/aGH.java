package com.bytedance.sdk.component.ui.ui;

/* loaded from: classes3.dex */
public class aGH extends eli {
    @Override // com.bytedance.sdk.component.ui.ui.FC
    public void eli(com.bytedance.sdk.component.ui.Os.Os os) {
        com.bytedance.sdk.component.ui.DbA QX = os.QX();
        if (QX != null) {
            if (QX.ui()) {
                os.eli(new aAs());
                return;
            } else if (QX.kb()) {
                os.eli(new MGA());
                return;
            }
        }
        os.eli(new du());
    }

    @Override // com.bytedance.sdk.component.ui.ui.FC
    public String eli() {
        return "cache_policy";
    }
}
