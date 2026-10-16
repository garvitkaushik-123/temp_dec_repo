package com.bytedance.sdk.component.adexpress.DbA;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.adexpress.DbA.aAs;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;

/* loaded from: classes3.dex */
public class DbA implements aAs {
    private com.bytedance.sdk.component.adexpress.dynamic.eli.eli DbA;
    private int MGA;
    private ThemeStatusBroadcastReceiver Os;
    private wC aGH;
    private Context eli;
    private NU ui;

    public DbA(Context context, NU nu, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, com.bytedance.sdk.component.adexpress.dynamic.ui.wC wCVar, wC wCVar2, com.bytedance.sdk.component.adexpress.dynamic.MGA.eli eliVar, com.bytedance.sdk.component.adexpress.dynamic.eli.eli eliVar2) {
        this.eli = context;
        this.ui = nu;
        this.Os = themeStatusBroadcastReceiver;
        this.aGH = wCVar2;
        if (eliVar2 != null) {
            this.DbA = eliVar2;
        } else {
            this.DbA = new com.bytedance.sdk.component.adexpress.dynamic.eli.eli(this.eli, this.Os, z, wCVar, this.ui, eliVar);
        }
        this.DbA.eli(this.aGH);
        if (wCVar instanceof com.bytedance.sdk.component.adexpress.dynamic.ui.kb) {
            this.MGA = 3;
        } else {
            this.MGA = 2;
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.aAs
    public boolean eli(final aAs.eli eliVar) {
        this.ui.ui().eli(this.MGA);
        this.DbA.eli(new kb() { // from class: com.bytedance.sdk.component.adexpress.DbA.DbA.1
            @Override // com.bytedance.sdk.component.adexpress.DbA.kb
            public void eli(View view, nn nnVar) {
                if (eliVar.Os()) {
                    return;
                }
                DbA.this.ui.ui().ui(DbA.this.MGA);
                DbA.this.ui.ui().MGA(DbA.this.MGA);
                DbA.this.ui.ui().aAs();
                Dfc DbA = eliVar.DbA();
                if (DbA == null) {
                    return;
                }
                DbA.eli(DbA.this.DbA, nnVar);
                eliVar.eli(true);
            }

            @Override // com.bytedance.sdk.component.adexpress.DbA.kb
            public void eli(int i, String str) {
                DbA.this.ui.ui().eli(DbA.this.MGA, i, str, eliVar.DbA(DbA.this));
                if (eliVar.DbA(DbA.this)) {
                    eliVar.eli(DbA.this);
                    return;
                }
                Dfc DbA = eliVar.DbA();
                if (DbA == null) {
                    return;
                }
                DbA.a_(i);
            }
        });
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.aAs
    public void eli() {
        com.bytedance.sdk.component.adexpress.dynamic.eli.eli eliVar = this.DbA;
        if (eliVar != null) {
            eliVar.DbA();
        }
    }

    public com.bytedance.sdk.component.adexpress.dynamic.aGH DbA() {
        com.bytedance.sdk.component.adexpress.dynamic.eli.eli eliVar = this.DbA;
        if (eliVar != null) {
            return eliVar.aGH();
        }
        return null;
    }
}
