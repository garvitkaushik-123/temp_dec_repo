package com.bytedance.sdk.component.adexpress.eli.DbA;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.eli.Os.eli;
import com.bytedance.sdk.component.utils.bf;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.ironsource.C3040d4;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public class ui extends Os {
    private static volatile ui DbA;
    private static File eli;
    private AtomicBoolean Os = new AtomicBoolean(true);
    private AtomicBoolean aGH = new AtomicBoolean(false);
    private boolean ui = false;
    private AtomicBoolean MGA = new AtomicBoolean(false);
    private AtomicInteger kb = new AtomicInteger(0);
    private AtomicLong wC = new AtomicLong();

    public static ui DbA() {
        if (DbA == null) {
            synchronized (ui.class) {
                if (DbA == null) {
                    DbA = new ui();
                }
            }
        }
        return DbA;
    }

    private ui() {
        aAs();
    }

    public void Os() {
        aAs();
    }

    private void aAs() {
        com.bytedance.sdk.component.adexpress.aGH.aGH.DbA(new com.bytedance.sdk.component.wC.wC(C3040d4.a.f) { // from class: com.bytedance.sdk.component.adexpress.eli.DbA.ui.1
            @Override // java.lang.Runnable
            public void run() {
                wC.eli();
                ui.this.Os.set(false);
                ui.this.aGH();
                ui.this.kb();
                if (com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().Os() == null || !bf.eli(com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().Os().DbA()) || com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().Os() == null) {
                    return;
                }
                com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().Os().aGH();
            }
        }, 10);
    }

    public void aGH() {
        com.bytedance.sdk.component.adexpress.eli.Os.eli DbA2 = wC.DbA();
        if (DbA2 == null || !DbA2.wC()) {
            return;
        }
        boolean eli2 = eli(DbA2);
        if (!eli2) {
            wC.aGH();
        }
        this.ui = eli2;
    }

    public boolean eli(com.bytedance.sdk.component.adexpress.eli.Os.eli eliVar) {
        if (eliVar == null) {
            return false;
        }
        return eli(eliVar.eli()) || eli(eliVar.ui()) || eli(eliVar.MGA());
    }

    public boolean ui() {
        return this.ui;
    }

    public com.bytedance.sdk.component.adexpress.eli.Os.eli MGA() {
        return wC.DbA();
    }

    @Override // com.bytedance.sdk.component.adexpress.eli.DbA.Os
    public File eli() {
        return wC();
    }

    public void kb() {
        eli(false);
    }

    public void eli(boolean z) {
        List<eli.C0143eli> list;
        boolean z2;
        if (this.Os.get()) {
            return;
        }
        try {
            if (this.aGH.get()) {
                if (z) {
                    this.kb.getAndIncrement();
                    return;
                }
                return;
            }
            boolean z3 = true;
            this.aGH.set(true);
            com.bytedance.sdk.component.adexpress.eli.Os.eli ui = com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().Os().ui();
            com.bytedance.sdk.component.adexpress.eli.Os.eli DbA2 = wC.DbA();
            if (ui != null && ui.wC()) {
                if (!wC.DbA(ui)) {
                    this.aGH.set(false);
                    this.wC.set(System.currentTimeMillis());
                    return;
                }
                if (com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().Os() != null) {
                    com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().Os().Os().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.eli.DbA.ui.2
                        @Override // java.lang.Runnable
                        public void run() {
                            com.bytedance.sdk.component.adexpress.ui.ui.eli().DbA();
                        }
                    });
                }
                wC.eli(ui);
                boolean eli2 = (ui.ui() == null || TextUtils.isEmpty(ui.ui().eli())) ? false : eli(ui.ui().eli());
                if (ui.eli().size() != 0) {
                    list = eli(ui, DbA2);
                    z2 = list != null;
                } else {
                    list = null;
                    z2 = eli2;
                }
                if (!eli2) {
                    List<eli.C0143eli> DbA3 = DbA(ui, DbA2);
                    if (list == null || DbA3 == null) {
                        list = DbA3;
                    } else {
                        list.addAll(DbA3);
                    }
                    if (DbA3 == null) {
                        z3 = false;
                    }
                    if (DbA3 == null) {
                        this.aGH.set(false);
                    }
                    z2 = z3;
                }
                if (z2 && eli(ui)) {
                    wC.eli(ui);
                    wC.Os();
                    DbA(list);
                }
                aGH();
                this.aGH.set(false);
                this.wC.set(System.currentTimeMillis());
                du();
                return;
            }
            this.aGH.set(false);
            eli(109);
        } catch (Throwable unused) {
        }
    }

    private void du() {
        if (this.kb.getAndSet(0) <= 0 || System.currentTimeMillis() - this.wC.get() <= TTAdConstant.AD_MAX_EVENT_TIME) {
            return;
        }
        kb();
    }

    public static File wC() {
        if (eli == null) {
            try {
                File file = new File(new File(aGH.eli(), "tt_tmpl_pkg"), "template");
                file.mkdirs();
                eli = file;
            } catch (Throwable unused) {
            }
        }
        return eli;
    }

    public void DbA(boolean z) {
        this.MGA.set(z);
    }

    public void FC() {
        this.MGA.set(true);
        this.ui = false;
        this.aGH.set(false);
    }
}
