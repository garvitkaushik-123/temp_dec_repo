package com.bytedance.sdk.openadsdk.core.wC;

import android.content.Context;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.openadsdk.utils.cyF;

/* loaded from: classes3.dex */
public class MGA extends com.bytedance.sdk.component.adexpress.dynamic.eli.eli {
    private com.bytedance.sdk.component.adexpress.DbA.kb DbA;
    private final com.bytedance.sdk.component.wC.wC Os;
    private final Runnable aGH;
    private final com.bytedance.sdk.component.adexpress.DbA.NU eli;

    public MGA(Context context, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, com.bytedance.sdk.component.adexpress.dynamic.ui.wC wCVar, com.bytedance.sdk.component.adexpress.DbA.NU nu, com.bytedance.sdk.component.adexpress.dynamic.MGA.eli eliVar) {
        super(context, themeStatusBroadcastReceiver, z, wCVar, nu, eliVar);
        this.Os = new com.bytedance.sdk.component.wC.wC("dynamic_render_template") { // from class: com.bytedance.sdk.openadsdk.core.wC.MGA.1
            @Override // java.lang.Runnable
            public void run() {
                MGA.this.eli.Os();
                com.bytedance.sdk.openadsdk.core.nn.Os().post(MGA.this.aGH);
            }
        };
        this.aGH = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.wC.MGA.2
            @Override // java.lang.Runnable
            public void run() {
                if (MGA.this.DbA != null) {
                    MGA mga = MGA.this;
                    MGA.super.eli(mga.DbA);
                }
            }
        };
        this.eli = nu;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.eli.eli, com.bytedance.sdk.component.adexpress.DbA.aGH
    public void eli(com.bytedance.sdk.component.adexpress.DbA.kb kbVar) {
        this.DbA = kbVar;
        cyF.DbA(this.Os);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.eli.eli
    public void DbA() {
        super.DbA();
        com.bytedance.sdk.openadsdk.core.nn.Os().removeCallbacks(this.aGH);
    }
}
