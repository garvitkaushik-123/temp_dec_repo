package com.bytedance.sdk.component.adexpress.DbA;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.adexpress.DbA.aAs;

/* loaded from: classes3.dex */
public class MGA implements aAs {
    private eli DbA;
    private NU Os;
    private Context eli;

    @Override // com.bytedance.sdk.component.adexpress.DbA.aAs
    public void eli() {
    }

    public MGA(Context context, NU nu, eli eliVar) {
        this.eli = context;
        this.DbA = eliVar;
        this.Os = nu;
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.aAs
    public boolean eli(final aAs.eli eliVar) {
        this.Os.ui().MGA();
        this.DbA.eli(new kb() { // from class: com.bytedance.sdk.component.adexpress.DbA.MGA.1
            @Override // com.bytedance.sdk.component.adexpress.DbA.kb
            public void eli(View view, nn nnVar) {
                if (eliVar.Os()) {
                    return;
                }
                Dfc DbA = eliVar.DbA();
                if (DbA != null) {
                    DbA.eli(MGA.this.DbA, nnVar);
                }
                eliVar.eli(true);
            }

            @Override // com.bytedance.sdk.component.adexpress.DbA.kb
            public void eli(int i, String str) {
                Dfc DbA = eliVar.DbA();
                if (DbA != null) {
                    DbA.a_(i);
                }
            }
        });
        return true;
    }

    public void eli(Os os) {
        this.DbA.eli(os);
    }
}
