package com.bytedance.sdk.component.wC;

import com.bytedance.sdk.component.wC.eli;
import com.ironsource.C3040d4;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class MGA extends ui {
    public static Os DbA;
    private static volatile ThreadPoolExecutor FC;
    private static volatile ThreadPoolExecutor MGA;
    private static volatile ThreadPoolExecutor aAs;
    private static volatile ScheduledExecutorService du;
    private static volatile ThreadPoolExecutor kb;
    private static volatile ThreadPoolExecutor ui;
    private static volatile ThreadPoolExecutor wC;
    public static final int eli = Runtime.getRuntime().availableProcessors();
    public static int Os = 120;
    public static boolean aGH = true;

    public static ExecutorService DbA() {
        if (ui == null) {
            synchronized (MGA.class) {
                if (ui == null) {
                    ui = new eli.C0152eli().eli(C3040d4.a.f).eli(0).DbA(10).eli(5L).eli(TimeUnit.SECONDS).eli(new SynchronousQueue()).eli(wC()).eli(eli().createThreadFactory(10, C3040d4.a.f)).eli();
                }
            }
        }
        return ui;
    }

    public static void eli(wC wCVar) {
        if (ui == null) {
            DbA();
        }
        if (wCVar == null || ui == null) {
            return;
        }
        ui.execute(wCVar);
    }

    public static ExecutorService Os() {
        return eli(10);
    }

    public static ExecutorService eli(int i) {
        if (MGA == null) {
            synchronized (MGA.class) {
                if (MGA == null) {
                    eli eli2 = new eli.C0152eli().eli("io").eli(2).DbA(i).eli(20L).eli(TimeUnit.SECONDS).eli(new LinkedBlockingQueue()).eli(wC()).eli(eli().createThreadFactory(i, "io")).eli();
                    MGA = eli2;
                    eli2.allowCoreThreadTimeOut(true);
                }
            }
        }
        return MGA;
    }

    public static void DbA(wC wCVar) {
        if (MGA == null) {
            Os();
        }
        if (MGA != null) {
            MGA.execute(wCVar);
        }
    }

    public static void eli(wC wCVar, int i) {
        DbA(wCVar);
    }

    public static void eli(wC wCVar, int i, int i2) {
        if (MGA == null) {
            eli(i2);
        }
        if (wCVar == null || MGA == null) {
            return;
        }
        wCVar.setPriority(i);
        MGA.execute(wCVar);
    }

    public static ExecutorService aGH() {
        if (wC == null) {
            synchronized (MGA.class) {
                if (wC == null) {
                    eli eli2 = new eli.C0152eli().eli("log").DbA(10).eli(4).eli(20L).eli(TimeUnit.SECONDS).eli(new PriorityBlockingQueue()).eli(wC()).eli(eli().createThreadFactory(10, "log")).eli();
                    wC = eli2;
                    eli2.allowCoreThreadTimeOut(true);
                }
            }
        }
        return wC;
    }

    public static void Os(wC wCVar) {
        if (wC == null) {
            aGH();
        }
        if (wCVar == null || wC == null) {
            return;
        }
        wC.execute(wCVar);
    }

    public static void DbA(wC wCVar, int i) {
        if (wCVar != null) {
            wCVar.setPriority(i);
        }
        Os(wCVar);
    }

    public static ExecutorService ui() {
        if (aAs == null) {
            synchronized (MGA.class) {
                if (aAs == null) {
                    eli eli2 = new eli.C0152eli().eli("aidl").DbA(10).eli(2).eli(30L).eli(TimeUnit.SECONDS).eli(new PriorityBlockingQueue()).eli(wC()).eli(eli().createThreadFactory(10, "aidl")).eli();
                    aAs = eli2;
                    eli2.allowCoreThreadTimeOut(true);
                }
            }
        }
        return aAs;
    }

    public static void aGH(wC wCVar) {
        if (aAs == null) {
            ui();
        }
        if (wCVar == null || aAs == null) {
            return;
        }
        aAs.execute(wCVar);
    }

    public static void Os(wC wCVar, int i) {
        if (wCVar != null) {
            wCVar.setPriority(i);
        }
        aGH(wCVar);
    }

    public static ScheduledExecutorService MGA() {
        if (du == null) {
            synchronized (MGA.class) {
                if (du == null) {
                    du = Executors.newSingleThreadScheduledExecutor(eli().createThreadFactory(5, "scheduled"));
                }
            }
        }
        return du;
    }

    public static boolean kb() {
        return aGH;
    }

    public static void eli(boolean z) {
        aGH = z;
    }

    public static RejectedExecutionHandler wC() {
        return new RejectedExecutionHandler() { // from class: com.bytedance.sdk.component.wC.MGA.1
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            }
        };
    }

    public static Os FC() {
        return DbA;
    }

    public static void eli(Os os) {
        DbA = os;
    }

    public static ExecutorService DbA(int i) {
        if (kb == null) {
            synchronized (MGA.class) {
                if (kb == null) {
                    eli eli2 = new eli.C0152eli().eli("ad").eli(2).DbA(i).eli(20L).eli(TimeUnit.SECONDS).eli(new LinkedBlockingQueue()).eli(wC()).eli(eli().createThreadFactory(i, "ad")).eli();
                    kb = eli2;
                    eli2.allowCoreThreadTimeOut(true);
                }
            }
        }
        return kb;
    }

    public static void ui(wC wCVar) {
        if (kb == null) {
            DbA(5);
        }
        if (wCVar == null || kb == null) {
            return;
        }
        kb.execute(wCVar);
    }

    public static ExecutorService aAs() {
        if (FC == null) {
            synchronized (MGA.class) {
                if (FC == null) {
                    eli eli2 = new eli.C0152eli().eli("computation").eli(3).DbA(10).eli(20L).eli(TimeUnit.SECONDS).eli(new PriorityBlockingQueue()).eli(wC()).eli(eli().createThreadFactory(10, "computation")).eli();
                    FC = eli2;
                    eli2.allowCoreThreadTimeOut(true);
                }
            }
        }
        return FC;
    }

    public static void Os(int i) {
        Os = i;
    }
}
