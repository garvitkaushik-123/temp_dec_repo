package com.bytedance.sdk.component.adexpress.DbA;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.adexpress.DbA.aAs;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class aqO implements aAs {
    private com.bytedance.sdk.component.adexpress.ui.eli DbA;
    private AtomicBoolean MGA = new AtomicBoolean(false);
    private wC Os;
    private NU aGH;
    private Context eli;
    private ScheduledFuture<?> ui;

    public aqO(Context context, NU nu, com.bytedance.sdk.component.adexpress.ui.eli eliVar, wC wCVar) {
        this.eli = context;
        this.aGH = nu;
        this.Os = wCVar;
        this.DbA = eliVar;
        eliVar.eli(this.Os);
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.aAs
    public boolean eli(final aAs.eli eliVar) {
        int MGA = this.aGH.MGA();
        if (MGA < 0) {
            eli(eliVar, 107, "time is ".concat(String.valueOf(MGA)));
        } else {
            this.ui = com.bytedance.sdk.component.adexpress.aGH.aGH.eli(new eli(1, eliVar), MGA, TimeUnit.MILLISECONDS);
            this.DbA.eli(new kb() { // from class: com.bytedance.sdk.component.adexpress.DbA.aqO.1
                @Override // com.bytedance.sdk.component.adexpress.DbA.kb
                public void eli(View view, nn nnVar) {
                    Dfc DbA;
                    aqO.this.Os();
                    if (eliVar.Os() || (DbA = eliVar.DbA()) == null) {
                        return;
                    }
                    DbA.eli(aqO.this.DbA, nnVar);
                    eliVar.eli(true);
                }

                @Override // com.bytedance.sdk.component.adexpress.DbA.kb
                public void eli(int i, String str) {
                    aqO.this.eli(eliVar, i, str);
                }
            });
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.aAs
    public void eli() {
        this.DbA.aGH();
        Os();
    }

    public com.bytedance.sdk.component.adexpress.ui.eli DbA() {
        return this.DbA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Os() {
        try {
            ScheduledFuture<?> scheduledFuture = this.ui;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.ui.cancel(false);
            this.ui = null;
        } catch (Throwable unused) {
        }
    }

    private class eli implements Runnable {
        private int Os;
        aAs.eli eli;

        public eli(int i, aAs.eli eliVar) {
            this.Os = i;
            this.eli = eliVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.Os == 1) {
                aqO.this.DbA.eli(true);
                aqO.this.eli(this.eli, 107, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(aAs.eli eliVar, int i, String str) {
        Dfc DbA;
        if (eliVar.Os() || this.MGA.get()) {
            return;
        }
        Os();
        this.aGH.ui().eli(i, str);
        if (eliVar.DbA(this)) {
            eliVar.eli(this);
        } else {
            if (eliVar.Os() || (DbA = eliVar.DbA()) == null) {
                return;
            }
            eliVar.eli(true);
            DbA.a_(i);
        }
        this.MGA.getAndSet(true);
    }
}
