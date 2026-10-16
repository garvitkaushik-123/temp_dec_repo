package com.bytedance.sdk.component.wC;

/* loaded from: classes3.dex */
public class ui {
    private static aAs eli = new aAs() { // from class: com.bytedance.sdk.component.wC.ui.1
        @Override // com.bytedance.sdk.component.wC.aAs
        public FC createThreadFactory(int i, String str) {
            return new FC(i, str);
        }
    };

    public static void eli(aAs aas) {
        eli = aas;
    }

    public static aAs eli() {
        return eli;
    }
}
