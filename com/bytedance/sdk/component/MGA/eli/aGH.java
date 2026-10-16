package com.bytedance.sdk.component.MGA.eli;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.bf;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public class aGH {
    public static final aGH eli = new aGH();

    public void eli(eli eliVar, Context context) {
        DbA(eliVar, context);
        wC.kb().eli(context);
        wC.kb().eli(eliVar.aAs());
        wC.kb().DbA(eliVar.kb());
        wC.kb().Os(eliVar.wC());
        wC.kb().eli(eliVar.DbA());
        wC.kb().aGH(eliVar.FC());
        wC.kb().ui(eliVar.MGA());
        wC.kb().eli(eliVar.eli() == null ? com.bytedance.sdk.component.MGA.eli.eli.eli.ui.eli : eliVar.eli());
        wC.kb().DbA(eliVar.du());
        wC.kb().eli(eliVar.aGH());
        wC.kb().eli(eliVar.Os());
        wC.kb().eli(eliVar.ui());
        com.bytedance.sdk.component.MGA.eli.DbA.Os.Os.eli(eliVar.NU());
        com.bytedance.sdk.component.MGA.eli.DbA.Os.Os.DbA(eliVar.nlS());
        eli(eliVar);
    }

    private void eli(eli eliVar) {
        Executor ui;
        if (Looper.myLooper() != Looper.getMainLooper() && com.bytedance.sdk.component.MGA.eli.Os.eli.DbA()) {
            com.bytedance.sdk.component.MGA.eli.Os.eli.eli();
            return;
        }
        ui aGH = eliVar.aGH();
        if (aGH == null || !com.bytedance.sdk.component.MGA.eli.Os.eli.DbA() || (ui = aGH.ui()) == null) {
            return;
        }
        ui.execute(new Runnable() { // from class: com.bytedance.sdk.component.MGA.eli.aGH.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.component.MGA.eli.Os.eli.eli();
            }
        });
    }

    public void eli(boolean z) {
        wC.kb().eli(z);
    }

    private void DbA(eli eliVar, Context context) {
        Os.eli(context, "context == null");
        Os.eli(eliVar, "AdLogConfig == null");
        Os.eli(eliVar.aGH(), "AdLogDepend ==null");
    }

    private boolean eli(Context context, ui uiVar) {
        if (context == null || uiVar == null) {
            return false;
        }
        if (uiVar.MGA() == 2) {
            return true;
        }
        if (uiVar.MGA() == 1) {
            return uiVar.nn();
        }
        try {
            return bf.eli(context);
        } catch (Throwable th) {
            th.getMessage();
            return true;
        }
    }

    public void eli() {
        final ui aqO = wC.kb().aqO();
        if (aqO == null || wC.kb().MGA() == null || aqO.aGH() == null) {
            return;
        }
        if (wC.kb().DbA()) {
            if (eli(wC.kb().MGA(), aqO)) {
                wC.kb().FC();
                return;
            } else if (Os()) {
                aqO.aGH().execute(new com.bytedance.sdk.component.MGA.eli.ui.ui("start") { // from class: com.bytedance.sdk.component.MGA.eli.aGH.2
                    @Override // java.lang.Runnable
                    public void run() {
                        aGH.this.eli(aqO.MGA());
                    }
                });
                return;
            } else {
                eli(aqO.MGA());
                return;
            }
        }
        wC.kb().FC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(int i) {
        if (i == 0) {
            com.bytedance.sdk.component.MGA.eli.DbA.DbA.eli.eli();
        } else if (i == 1) {
            com.bytedance.sdk.component.MGA.eli.DbA.DbA.DbA.eli();
        }
    }

    public void DbA() {
        final ui aqO = wC.kb().aqO();
        if (aqO == null || wC.kb().MGA() == null || aqO.aGH() == null) {
            return;
        }
        if (wC.kb().DbA()) {
            if (eli(wC.kb().MGA(), aqO)) {
                wC.kb().du();
                return;
            } else if (Os()) {
                aqO.aGH().execute(new com.bytedance.sdk.component.MGA.eli.ui.ui("stop") { // from class: com.bytedance.sdk.component.MGA.eli.aGH.3
                    @Override // java.lang.Runnable
                    public void run() {
                        aGH.this.DbA(aqO.MGA());
                    }
                });
                return;
            } else {
                DbA(aqO.MGA());
                return;
            }
        }
        wC.kb().du();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DbA(int i) {
        if (i == 0) {
            com.bytedance.sdk.component.MGA.eli.DbA.DbA.eli.DbA();
        } else if (i == 1) {
            com.bytedance.sdk.component.MGA.eli.DbA.DbA.DbA.DbA();
        }
    }

    public void eli(com.bytedance.sdk.component.MGA.eli.aGH.eli eliVar) {
        DbA(eliVar);
    }

    private boolean Os() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    private void DbA(final com.bytedance.sdk.component.MGA.eli.aGH.eli eliVar) {
        final ui aqO = wC.kb().aqO();
        if (eliVar == null || aqO == null || wC.kb().MGA() == null || aqO.aGH() == null) {
            return;
        }
        if (wC.kb().DbA()) {
            if (eli(wC.kb().MGA(), aqO)) {
                wC.kb().eli(eliVar);
                return;
            }
            Os();
            if (Os()) {
                aqO.aGH().execute(new com.bytedance.sdk.component.MGA.eli.ui.ui("dispatchEvent") { // from class: com.bytedance.sdk.component.MGA.eli.aGH.4
                    @Override // java.lang.Runnable
                    public void run() {
                        aGH.this.eli(eliVar, aqO.MGA());
                    }
                });
                return;
            } else {
                eli(eliVar, aqO.MGA());
                return;
            }
        }
        wC.kb().eli(eliVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(com.bytedance.sdk.component.MGA.eli.aGH.eli eliVar, int i) {
        if (i == 0) {
            com.bytedance.sdk.component.MGA.eli.DbA.DbA.eli.eli(eliVar);
        } else if (i == 1) {
            com.bytedance.sdk.component.MGA.eli.DbA.DbA.DbA.eli(eliVar);
        }
    }

    public void eli(final String str, final List<String> list, final boolean z, Map<String, String> map, final int i, final String str2) {
        final ui aqO = wC.kb().aqO();
        if (aqO == null || wC.kb().MGA() == null || aqO.aGH() == null || !aqO.wC()) {
            return;
        }
        if (aqO.MGA() == 1) {
            if (list == null || list.isEmpty()) {
                return;
            }
        } else if (aqO.MGA() == 0 && (TextUtils.isEmpty(str) || list == null || list.isEmpty())) {
            return;
        }
        if (!wC.kb().DbA() || eli(wC.kb().MGA(), aqO)) {
            wC.kb().eli(str, list, z, map, i, str2);
        } else if (Os()) {
            aqO.aGH().execute(new com.bytedance.sdk.component.MGA.eli.ui.ui("trackFailed") { // from class: com.bytedance.sdk.component.MGA.eli.aGH.5
                @Override // java.lang.Runnable
                public void run() {
                    aGH.this.eli(str, (List<String>) list, z, aqO.MGA(), i, str2);
                }
            });
        } else {
            eli(str, list, z, aqO.MGA(), i, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(String str, List<String> list, boolean z, int i, int i2, String str2) {
        if (i == 0) {
            com.bytedance.sdk.component.MGA.eli.DbA.DbA.eli.eli(str, list, z);
        } else if (i == 1) {
            com.bytedance.sdk.component.MGA.eli.DbA.DbA.DbA.eli(str, list, z, i2, str2);
        }
    }

    public void eli(final String str, final boolean z) {
        final ui aqO = wC.kb().aqO();
        if (aqO == null || wC.kb().MGA() == null || aqO.aGH() == null || !aqO.wC() || (aqO.MGA() == 0 && TextUtils.isEmpty(str))) {
            return;
        }
        if (!wC.kb().DbA() || eli(wC.kb().MGA(), aqO)) {
            wC.kb().eli(str, z);
        } else if (Os()) {
            aqO.aGH().execute(new com.bytedance.sdk.component.MGA.eli.ui.ui("trackFailed") { // from class: com.bytedance.sdk.component.MGA.eli.aGH.6
                @Override // java.lang.Runnable
                public void run() {
                    aGH.this.eli(str, aqO.MGA(), z);
                }
            });
        } else {
            eli(str, aqO.MGA(), z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(String str, int i, boolean z) {
        if (i == 0) {
            com.bytedance.sdk.component.MGA.eli.DbA.DbA.eli.eli(str);
        } else if (i == 1) {
            com.bytedance.sdk.component.MGA.eli.DbA.DbA.DbA.eli(str, z);
        }
    }
}
