package com.bytedance.sdk.openadsdk.core.aAs.DbA;

import android.content.Context;
import android.view.View;
import com.bytedance.adsdk.ugeno.core.dV;
import com.bytedance.sdk.component.adexpress.DbA.NU;
import com.bytedance.sdk.component.adexpress.DbA.aAs;
import com.bytedance.sdk.component.adexpress.DbA.nn;
import com.bytedance.sdk.component.adexpress.DbA.wC;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.core.wC.Dfc;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.vungle.ads.internal.protos.Sdk;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class kb implements aAs {
    private com.bytedance.sdk.openadsdk.core.aAs.MGA.Os DbA;
    private Dfc MGA;
    private NU Os;
    private ScheduledFuture<?> aGH;
    private Context eli;
    private AtomicBoolean ui = new AtomicBoolean(false);

    @Override // com.bytedance.sdk.component.adexpress.DbA.aAs
    public void eli() {
    }

    public kb(Context context, com.bytedance.sdk.openadsdk.core.aAs.MGA.Os os, wC wCVar, NU nu) {
        this.eli = context;
        this.DbA = os;
        this.Os = nu;
        this.DbA.eli(wCVar);
    }

    public void eli(Dfc dfc) {
        this.MGA = dfc;
        this.DbA.eli(dfc);
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.aAs
    public boolean eli(final aAs.eli eliVar) {
        int MGA = this.Os.MGA();
        if (MGA < 0) {
            eli(eliVar, Sdk.SDKError.Reason.TPAT_RETRY_FAILED_VALUE, "time is ".concat(String.valueOf(MGA)));
        } else {
            this.aGH = cyF.eli().schedule(new eli(1, eliVar), MGA, TimeUnit.MILLISECONDS);
            this.DbA.eli(new com.bytedance.sdk.component.adexpress.DbA.kb() { // from class: com.bytedance.sdk.openadsdk.core.aAs.DbA.kb.1
                @Override // com.bytedance.sdk.component.adexpress.DbA.kb
                public void eli(View view, nn nnVar) {
                    kb.this.DbA();
                    if (eliVar.Os()) {
                        return;
                    }
                    dV dVVar = new dV();
                    dVVar.eli(0);
                    ((com.bytedance.sdk.openadsdk.core.aAs.MGA.eli) kb.this.Os).qj().eli(dVVar);
                    kb.this.Os.ui().aAs();
                    com.bytedance.sdk.component.adexpress.DbA.Dfc DbA = eliVar.DbA();
                    if (DbA == null) {
                        return;
                    }
                    DbA.eli(kb.this.DbA, nnVar);
                    eliVar.eli(true);
                }

                @Override // com.bytedance.sdk.component.adexpress.DbA.kb
                public void eli(int i, String str) {
                    kb.this.eli(eliVar, i, str);
                }
            });
        }
        return true;
    }

    private class eli implements Runnable {
        private int Os;
        aAs.eli eli;

        eli(int i, aAs.eli eliVar) {
            this.Os = i;
            this.eli = eliVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.Os == 1) {
                kb.this.DbA.eli(true);
                kb.this.eli(this.eli, Sdk.SDKError.Reason.TPAT_RETRY_FAILED_VALUE, "real time out" + kb.this.Os.MGA());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(aAs.eli eliVar, int i, String str) {
        com.bytedance.sdk.component.adexpress.DbA.Dfc DbA;
        if (eliVar.Os() || this.ui.get()) {
            return;
        }
        DbA();
        dV dVVar = new dV();
        dVVar.eli(i);
        dVVar.eli(str);
        ((com.bytedance.sdk.openadsdk.core.aAs.MGA.eli) this.Os).qj().eli(dVVar);
        if (eliVar.DbA(this)) {
            eliVar.eli(this);
        } else {
            if (eliVar.Os() || (DbA = eliVar.DbA()) == null) {
                return;
            }
            eliVar.eli(true);
            DbA.a_(i);
        }
        this.ui.getAndSet(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DbA() {
        try {
            ScheduledFuture<?> scheduledFuture = this.aGH;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.aGH.cancel(false);
            this.aGH = null;
        } catch (Throwable th) {
            Xb.Os("RenderInterceptor", "remove ugen time out task fail", th.getMessage());
        }
    }
}
