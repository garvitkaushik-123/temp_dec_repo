package com.bytedance.sdk.openadsdk.core.wC;

import android.view.View;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.openadsdk.utils.cyF;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class bf extends com.bytedance.sdk.component.adexpress.DbA.eli<eli> {
    private eli DbA;
    private final com.bytedance.sdk.component.adexpress.DbA.NU MGA;
    private final View Os;
    private com.bytedance.sdk.component.adexpress.DbA.Os aGH;
    AtomicBoolean eli = new AtomicBoolean(false);
    private com.bytedance.sdk.component.adexpress.DbA.kb ui;

    public bf(View view, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, com.bytedance.sdk.component.adexpress.DbA.NU nu) {
        this.Os = view;
        this.MGA = nu;
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.aGH
    public void eli(com.bytedance.sdk.component.adexpress.DbA.kb kbVar) {
        this.ui = kbVar;
        cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.wC.bf.1
            @Override // java.lang.Runnable
            public void run() {
                bf.this.DbA();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DbA() {
        if (this.eli.get()) {
            return;
        }
        com.bytedance.sdk.component.adexpress.DbA.Os os = this.aGH;
        if (os == null || !os.eli((Xb) this.Os, 0)) {
            this.ui.eli(107, "backup false");
            return;
        }
        this.MGA.ui().kb();
        eli eliVar = (eli) this.Os.findViewWithTag("tt_express_backup_fl_tag_26");
        this.DbA = eliVar;
        if (eliVar != null) {
            com.bytedance.sdk.component.adexpress.DbA.nn nnVar = new com.bytedance.sdk.component.adexpress.DbA.nn();
            eli eliVar2 = this.DbA;
            float realWidth = eliVar2 == null ? 0.0f : eliVar2.getRealWidth();
            eli eliVar3 = this.DbA;
            float realHeight = eliVar3 != null ? eliVar3.getRealHeight() : 0.0f;
            nnVar.eli(true);
            nnVar.eli(realWidth);
            nnVar.DbA(realHeight);
            this.ui.eli(this.DbA, nnVar);
            return;
        }
        this.ui.eli(107, "backupview is null");
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.aGH
    /* renamed from: eli, reason: merged with bridge method [inline-methods] */
    public eli ui() {
        return this.DbA;
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.eli
    public void eli(com.bytedance.sdk.component.adexpress.DbA.Os os) {
        this.aGH = os;
    }
}
