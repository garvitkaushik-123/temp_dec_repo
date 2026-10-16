package com.bytedance.sdk.component.MGA.eli.DbA;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.component.MGA.eli.ui;
import com.bytedance.sdk.component.MGA.eli.wC;
import java.util.Comparator;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public class aGH {
    private volatile com.bytedance.sdk.component.MGA.eli.DbA.Os.Os FC;
    private volatile Handler aAs;
    private final Comparator<com.bytedance.sdk.component.MGA.eli.aGH.eli> du;
    private final PriorityBlockingQueue<com.bytedance.sdk.component.MGA.eli.aGH.eli> nlS;
    public static final aGH eli = new aGH();
    public static final com.bytedance.sdk.component.MGA.eli.DbA.eli.eli aGH = new com.bytedance.sdk.component.MGA.eli.DbA.eli.eli();
    public static final AtomicLong ui = new AtomicLong(0);
    public static final AtomicLong MGA = new AtomicLong(0);
    public static final long kb = System.currentTimeMillis();
    public static long wC = 0;
    public volatile boolean DbA = false;
    public volatile boolean Os = false;

    public PriorityBlockingQueue<com.bytedance.sdk.component.MGA.eli.aGH.eli> eli() {
        return this.nlS;
    }

    private aGH() {
        Comparator<com.bytedance.sdk.component.MGA.eli.aGH.eli> comparator = new Comparator<com.bytedance.sdk.component.MGA.eli.aGH.eli>() { // from class: com.bytedance.sdk.component.MGA.eli.DbA.aGH.1
            @Override // java.util.Comparator
            /* renamed from: eli, reason: merged with bridge method [inline-methods] */
            public int compare(com.bytedance.sdk.component.MGA.eli.aGH.eli eliVar, com.bytedance.sdk.component.MGA.eli.aGH.eli eliVar2) {
                return aGH.this.eli(eliVar, eliVar2);
            }
        };
        this.du = comparator;
        this.nlS = new PriorityBlockingQueue<>(8, comparator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int eli(com.bytedance.sdk.component.MGA.eli.aGH.eli eliVar, com.bytedance.sdk.component.MGA.eli.aGH.eli eliVar2) {
        long j;
        long j2;
        long j3;
        long j4;
        if (eliVar == null) {
            return eliVar2 == null ? 0 : -1;
        }
        if (eliVar2 == null) {
            return 1;
        }
        if (eliVar.ui() == eliVar2.ui()) {
            if (eliVar.eli() != null) {
                j = eliVar.eli().eli();
                j2 = eliVar.eli().DbA();
            } else {
                j = 0;
                j2 = 0;
            }
            if (eliVar2.eli() != null) {
                j4 = eliVar2.eli().eli();
                j3 = eliVar2.eli().DbA();
            } else {
                j3 = 0;
                j4 = 0;
            }
            if (j == 0 || j4 == 0) {
                return 0;
            }
            long j5 = j - j4;
            if (Math.abs(j5) > 2147483647L) {
                return 0;
            }
            if (j5 != 0) {
                return (int) j5;
            }
            if (j2 == 0 || j3 == 0) {
                return 0;
            }
            return (int) (j2 - j3);
        }
        return eliVar.ui() - eliVar2.ui();
    }

    public void DbA() {
        aGH();
        ui();
    }

    public void eli(Handler handler) {
        this.aAs = handler;
    }

    public void Os() {
        if (this.FC == null || !this.FC.isAlive()) {
            return;
        }
        synchronized (this) {
            if (this.FC != null && this.FC.isAlive()) {
                if (this.aAs != null) {
                    this.aAs.removeCallbacksAndMessages(null);
                }
                this.FC.eli(false);
                this.FC.quitSafely();
                this.FC = null;
            }
        }
    }

    public boolean aGH() {
        try {
            if (this.FC != null || com.bytedance.sdk.component.MGA.eli.DbA.DbA()) {
                return false;
            }
            synchronized (this) {
                if (this.FC != null) {
                    return false;
                }
                this.FC = new com.bytedance.sdk.component.MGA.eli.DbA.Os.Os(this.nlS);
                this.FC.start();
                return true;
            }
        } catch (Throwable th) {
            th.getMessage();
            return false;
        }
    }

    public void eli(com.bytedance.sdk.component.MGA.eli.aGH.eli eliVar, int i) {
        aGH();
        ui aqO = wC.kb().aqO();
        com.bytedance.sdk.component.MGA.eli.DbA.Os.Os os = this.FC;
        if (os != null) {
            eli(aqO, eliVar);
            os.eli(eliVar, eliVar.ui() == 4);
        }
    }

    private void eli(final ui uiVar, com.bytedance.sdk.component.MGA.eli.aGH.eli eliVar) {
        if (uiVar != null) {
            try {
                if (uiVar.kb()) {
                    final long DbA = (eliVar == null || eliVar.eli() == null) ? 0L : eliVar.eli().DbA();
                    if (DbA == 1) {
                        wC = System.currentTimeMillis();
                    }
                    AtomicLong qyC = aGH.qyC();
                    com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(qyC, 1);
                    if (qyC.get() == 200) {
                        try {
                            if (Looper.getMainLooper() == Looper.myLooper()) {
                                Executor aGH2 = uiVar.aGH();
                                if (aGH2 == null) {
                                    aGH2 = uiVar.ui();
                                }
                                if (aGH2 != null) {
                                    aGH2.execute(new com.bytedance.sdk.component.MGA.eli.ui.ui("report") { // from class: com.bytedance.sdk.component.MGA.eli.DbA.aGH.2
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            aGH.this.eli(uiVar, DbA);
                                        }
                                    });
                                }
                            } else {
                                eli(uiVar, DbA);
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            } catch (Exception unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(ui uiVar, long j) {
        com.bytedance.sdk.component.MGA.eli.DbA.Os.Os os = this.FC;
        if (uiVar == null || os == null) {
            return;
        }
        com.bytedance.sdk.component.MGA.eli.DbA.eli.eli eliVar = aGH;
        os.eli(uiVar.eli(eliVar.DbA(j)), true);
        eliVar.Za();
    }

    public void ui() {
        com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(aGH.Cp(), 1);
        final com.bytedance.sdk.component.MGA.eli.DbA.Os.Os os = this.FC;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            if (os != null) {
                os.Os(2);
                return;
            }
            return;
        }
        ui aqO = wC.kb().aqO();
        if (aqO != null) {
            Executor aGH2 = aqO.aGH();
            if (aGH2 == null) {
                aGH2 = aqO.ui();
            }
            if (aGH2 != null) {
                aGH2.execute(new com.bytedance.sdk.component.MGA.eli.ui.ui("flush") { // from class: com.bytedance.sdk.component.MGA.eli.DbA.aGH.3
                    @Override // java.lang.Runnable
                    public void run() {
                        com.bytedance.sdk.component.MGA.eli.DbA.Os.Os os2 = os;
                        if (os2 != null) {
                            os2.Os(2);
                        }
                    }
                });
            }
        }
    }
}
