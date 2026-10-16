package com.bytedance.sdk.openadsdk.utils;

import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.component.wC.Os.MGA;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class cyF {
    private static volatile boolean DbA;
    private static volatile com.bytedance.sdk.component.wC.Os.MGA FC;
    private static volatile com.bytedance.sdk.component.wC.Os.MGA MGA;
    private static volatile com.bytedance.sdk.component.wC.Os.MGA Os;
    private static volatile com.bytedance.sdk.component.wC.Os.MGA aAs;
    private static volatile com.bytedance.sdk.component.wC.Os.MGA aGH;
    private static volatile com.bytedance.sdk.component.wC.Os.MGA du;
    private static volatile ThreadPoolExecutor eli;
    private static volatile com.bytedance.sdk.component.wC.Os.MGA kb;
    private static volatile com.bytedance.sdk.component.wC.Os.MGA ui;
    private static volatile com.bytedance.sdk.component.wC.Os.MGA wC;

    static {
        com.bytedance.sdk.component.wC.Os.Os.eli(new com.bytedance.sdk.component.wC.Os.eli() { // from class: com.bytedance.sdk.openadsdk.utils.cyF.1
            @Override // com.bytedance.sdk.component.wC.Os.eli
            public void eli(com.bytedance.sdk.component.wC.Os.MGA mga, com.bytedance.sdk.component.wC.Os.DbA dbA) {
                dbA.DbA();
                new RuntimeException();
            }
        });
        eli = null;
        DbA = false;
    }

    public static ScheduledExecutorService eli() {
        return com.bytedance.sdk.component.wC.MGA.MGA();
    }

    public static ExecutorService DbA() {
        if (nlS()) {
            return dV();
        }
        return com.bytedance.sdk.component.wC.MGA.aAs();
    }

    public static ExecutorService Os() {
        if (nlS()) {
            return QX();
        }
        return com.bytedance.sdk.component.wC.MGA.Os();
    }

    public static ExecutorService aGH() {
        if (nlS()) {
            return Dfc();
        }
        return com.bytedance.sdk.component.wC.MGA.aGH();
    }

    public static ExecutorService ui() {
        if (nlS()) {
            return FC();
        }
        return com.bytedance.sdk.component.wC.MGA.DbA();
    }

    public static boolean MGA() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static boolean kb() {
        String str;
        if (nlS()) {
            str = "pag_log";
        } else {
            str = "csj_log";
        }
        String name = Thread.currentThread().getName();
        if (TextUtils.isEmpty(name)) {
            return false;
        }
        return name.startsWith(str);
    }

    public static void eli(Runnable runnable) {
        if (runnable == null || qj.eli) {
            return;
        }
        if (MGA()) {
            runnable.run();
        } else {
            com.bytedance.sdk.openadsdk.core.nn.Os().post(runnable);
        }
    }

    public static void DbA(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.nn.Os().removeCallbacks(runnable);
    }

    public static void eli(final com.bytedance.sdk.component.wC.wC wCVar) {
        if (qj.eli) {
            return;
        }
        if (nlS()) {
            FC().execute(new com.bytedance.sdk.component.wC.Os.DbA(wCVar.getName()) { // from class: com.bytedance.sdk.openadsdk.utils.cyF.2
                @Override // java.lang.Runnable
                public void run() {
                    wCVar.run();
                }
            });
        } else {
            com.bytedance.sdk.component.wC.MGA.eli(wCVar);
        }
    }

    public static ExecutorService wC() {
        if (nlS()) {
            return nGm();
        }
        return com.bytedance.sdk.component.wC.MGA.Os();
    }

    public static void DbA(final com.bytedance.sdk.component.wC.wC wCVar) {
        if (qj.eli) {
            return;
        }
        if (nlS()) {
            nGm().execute(new com.bytedance.sdk.component.wC.Os.DbA(wCVar.getName()) { // from class: com.bytedance.sdk.openadsdk.utils.cyF.3
                @Override // java.lang.Runnable
                public void run() {
                    wCVar.run();
                }
            });
        } else {
            com.bytedance.sdk.component.wC.MGA.DbA(wCVar);
        }
    }

    public static void eli(final com.bytedance.sdk.component.wC.wC wCVar, int i) {
        if (wCVar == null || qj.eli) {
            return;
        }
        if (nlS()) {
            com.bytedance.sdk.component.wC.Os.DbA dbA = new com.bytedance.sdk.component.wC.Os.DbA(wCVar.getName()) { // from class: com.bytedance.sdk.openadsdk.utils.cyF.4
                @Override // java.lang.Runnable
                public void run() {
                    wCVar.run();
                }
            };
            dbA.eli(i);
            nGm().execute(dbA);
            return;
        }
        com.bytedance.sdk.component.wC.MGA.eli(wCVar, 5, i);
    }

    public static void Os(final com.bytedance.sdk.component.wC.wC wCVar) {
        if (wCVar == null || qj.eli) {
            return;
        }
        if (nlS()) {
            Dfc().execute(new com.bytedance.sdk.component.wC.Os.DbA(wCVar.getName()) { // from class: com.bytedance.sdk.openadsdk.utils.cyF.5
                @Override // java.lang.Runnable
                public void run() {
                    wCVar.run();
                }
            });
        } else {
            com.bytedance.sdk.component.wC.MGA.Os(wCVar);
        }
    }

    public static void DbA(final com.bytedance.sdk.component.wC.wC wCVar, int i) {
        if (wCVar == null || qj.eli) {
            return;
        }
        if (nlS()) {
            com.bytedance.sdk.component.wC.Os.DbA dbA = new com.bytedance.sdk.component.wC.Os.DbA(wCVar.getName()) { // from class: com.bytedance.sdk.openadsdk.utils.cyF.6
                @Override // java.lang.Runnable
                public void run() {
                    wCVar.run();
                }
            };
            dbA.eli(i);
            Dfc().execute(dbA);
            return;
        }
        com.bytedance.sdk.component.wC.MGA.DbA(wCVar, i);
    }

    public static void aGH(final com.bytedance.sdk.component.wC.wC wCVar) {
        if (wCVar == null || qj.eli) {
            return;
        }
        if (nlS()) {
            nn().execute(new com.bytedance.sdk.component.wC.Os.DbA(wCVar.getName()) { // from class: com.bytedance.sdk.openadsdk.utils.cyF.7
                @Override // java.lang.Runnable
                public void run() {
                    wCVar.run();
                }
            });
        } else {
            com.bytedance.sdk.component.wC.MGA.ui(wCVar);
        }
    }

    public static void Os(final com.bytedance.sdk.component.wC.wC wCVar, int i) {
        if (wCVar == null || qj.eli) {
            return;
        }
        if (nlS()) {
            aqO().execute(new com.bytedance.sdk.component.wC.Os.DbA(wCVar.getName()) { // from class: com.bytedance.sdk.openadsdk.utils.cyF.8
                @Override // java.lang.Runnable
                public void run() {
                    wCVar.run();
                }
            });
        } else {
            com.bytedance.sdk.component.wC.MGA.Os(wCVar, i);
        }
    }

    public static void ui(final com.bytedance.sdk.component.wC.wC wCVar) {
        if (qj.eli) {
            return;
        }
        if (nlS()) {
            nn().execute(new com.bytedance.sdk.component.wC.Os.DbA(wCVar.getName(), wCVar) { // from class: com.bytedance.sdk.openadsdk.utils.cyF.9
                @Override // java.lang.Runnable
                public void run() {
                    wCVar.run();
                }
            });
            return;
        }
        ThreadPoolExecutor NU = NU();
        NU.execute(wCVar);
        if (DbA || !com.bytedance.sdk.openadsdk.core.settings.NU.CH()) {
            return;
        }
        DbA = true;
        NU.setCorePoolSize(com.bytedance.sdk.openadsdk.core.settings.NU.nY().DE());
    }

    public static void eli(com.bytedance.sdk.component.wC.Os.DbA dbA) {
        du().execute(dbA);
    }

    private static ThreadPoolExecutor NU() {
        int i;
        if (eli == null) {
            synchronized (cyF.class) {
                if (eli == null) {
                    if (com.bytedance.sdk.openadsdk.core.settings.NU.CH()) {
                        i = com.bytedance.sdk.openadsdk.core.settings.NU.nY().DE();
                        DbA = true;
                    } else {
                        i = 4;
                    }
                    int i2 = i;
                    eli = new ThreadPoolExecutor(i2, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
                    new Object[]{"token_thread_count=", Integer.valueOf(i2)};
                }
            }
        }
        return eli;
    }

    private static ThreadPoolExecutor nn() {
        com.bytedance.sdk.component.wC.Os.MGA mga;
        com.bytedance.sdk.component.wC.Os.MGA mga2 = Os;
        if (!eli(mga2)) {
            return mga2;
        }
        synchronized (cyF.class) {
            if (eli(Os)) {
                try {
                    Os = eli("ad", Os);
                } catch (Throwable th) {
                    th.getMessage();
                }
            }
            mga = Os;
        }
        return mga;
    }

    public static com.bytedance.sdk.component.wC.Os.MGA FC() {
        com.bytedance.sdk.component.wC.Os.MGA mga;
        com.bytedance.sdk.component.wC.Os.MGA mga2 = MGA;
        if (!eli(mga2)) {
            return mga2;
        }
        synchronized (cyF.class) {
            if (eli(MGA)) {
                try {
                    MGA = eli("cache", MGA);
                } catch (Throwable th) {
                    th.getMessage();
                }
            }
            mga = MGA;
        }
        return mga;
    }

    private static com.bytedance.sdk.component.wC.Os.MGA Dfc() {
        com.bytedance.sdk.component.wC.Os.MGA mga;
        com.bytedance.sdk.component.wC.Os.MGA mga2 = aGH;
        if (!eli(mga2)) {
            return mga2;
        }
        synchronized (cyF.class) {
            if (eli(aGH)) {
                try {
                    aGH = eli("log", aGH);
                } catch (Throwable th) {
                    th.getMessage();
                }
            }
            mga = aGH;
        }
        return mga;
    }

    private static com.bytedance.sdk.component.wC.Os.MGA aqO() {
        com.bytedance.sdk.component.wC.Os.MGA mga;
        com.bytedance.sdk.component.wC.Os.MGA mga2 = ui;
        if (!eli(mga2)) {
            return mga2;
        }
        synchronized (cyF.class) {
            if (eli(ui)) {
                try {
                    ui = eli("aidl", ui);
                } catch (Throwable th) {
                    th.getMessage();
                }
            }
            mga = ui;
        }
        return mga;
    }

    private static com.bytedance.sdk.component.wC.Os.MGA dV() {
        com.bytedance.sdk.component.wC.Os.MGA mga;
        com.bytedance.sdk.component.wC.Os.MGA mga2 = wC;
        if (!eli(mga2)) {
            return mga2;
        }
        synchronized (cyF.class) {
            if (eli(wC)) {
                try {
                    wC = eli("image", wC);
                } catch (Throwable th) {
                    th.getMessage();
                }
            }
            mga = wC;
        }
        return mga;
    }

    public static com.bytedance.sdk.component.wC.Os.MGA aAs() {
        com.bytedance.sdk.component.wC.Os.MGA mga;
        com.bytedance.sdk.component.wC.Os.MGA mga2 = FC;
        if (!eli(mga2)) {
            return mga2;
        }
        synchronized (cyF.class) {
            if (eli(FC)) {
                try {
                    FC = eli("express", FC);
                } catch (Throwable th) {
                    th.getMessage();
                }
            }
            mga = FC;
        }
        return mga;
    }

    private static com.bytedance.sdk.component.wC.Os.MGA nGm() {
        com.bytedance.sdk.component.wC.Os.MGA mga;
        com.bytedance.sdk.component.wC.Os.MGA mga2 = kb;
        if (!eli(mga2)) {
            return mga2;
        }
        synchronized (cyF.class) {
            if (eli(kb)) {
                try {
                    kb = eli("io", kb);
                } catch (Throwable th) {
                    th.getMessage();
                }
            }
            mga = kb;
        }
        return mga;
    }

    private static com.bytedance.sdk.component.wC.Os.MGA QX() {
        com.bytedance.sdk.component.wC.Os.MGA mga;
        com.bytedance.sdk.component.wC.Os.MGA mga2 = du;
        if (!eli(mga2)) {
            return mga2;
        }
        synchronized (cyF.class) {
            if (eli(du)) {
                try {
                    du = eli("imgdisk", du);
                } catch (Throwable th) {
                    th.getMessage();
                }
            }
            mga = du;
        }
        return mga;
    }

    public static com.bytedance.sdk.component.wC.Os.MGA du() {
        com.bytedance.sdk.component.wC.Os.MGA mga;
        com.bytedance.sdk.component.wC.Os.MGA mga2 = aAs;
        if (!eli(mga2)) {
            return mga2;
        }
        synchronized (cyF.class) {
            if (eli(aAs)) {
                try {
                    aAs = eli("net", aAs);
                } catch (Throwable th) {
                    th.getMessage();
                }
            }
            mga = aAs;
        }
        return mga;
    }

    private static boolean eli(com.bytedance.sdk.component.wC.Os.MGA mga) {
        if (mga != null) {
            return !mga.eli() && com.bytedance.sdk.openadsdk.core.settings.NU.CH();
        }
        return true;
    }

    public static boolean nlS() {
        if (com.bytedance.sdk.openadsdk.core.settings.NU.CH()) {
            return com.bytedance.sdk.openadsdk.core.settings.NU.nY().eEH();
        }
        return true;
    }

    private static com.bytedance.sdk.component.wC.Os.MGA eli(String str, com.bytedance.sdk.component.wC.Os.MGA mga) {
        MGA.eli eli2 = eli(str);
        if (mga == null) {
            return eli2.eli();
        }
        mga.eli(eli2);
        return mga;
    }

    private static MGA.eli eli(String str) {
        MGA.eli DbA2 = DbA(str);
        try {
            if (com.bytedance.sdk.openadsdk.core.settings.NU.CH()) {
                DbA2.DbA(true);
                JSONObject Gjg = com.bytedance.sdk.openadsdk.core.settings.NU.nY().Gjg();
                JSONObject optJSONObject = Gjg != null ? Gjg.optJSONObject(str) : null;
                if (optJSONObject != null) {
                    DbA2.DbA(true);
                    if (optJSONObject.has("coreSize")) {
                        DbA2.eli(optJSONObject.optInt("coreSize"));
                    }
                    if (optJSONObject.has("maxSize")) {
                        DbA2.DbA(optJSONObject.optInt("maxSize"));
                    }
                    if (optJSONObject.has("createSize")) {
                        DbA2.Os(optJSONObject.optInt("createSize"));
                    }
                    if (optJSONObject.has("keepAlive")) {
                        DbA2.eli(optJSONObject.optInt("keepAlive"));
                    }
                    if (optJSONObject.has("allowCoreTimeOut")) {
                        DbA2.eli(optJSONObject.optBoolean("allowCoreTimeOut"));
                    }
                    if (optJSONObject.has("reportLogThreshold")) {
                        optJSONObject.optInt("reportLogThreshold");
                    }
                    if (optJSONObject.has("logTaskCount")) {
                        optJSONObject.optInt("logTaskCount");
                        return DbA2;
                    }
                }
            }
        } catch (Throwable th) {
            th.getMessage();
        }
        return DbA2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static MGA.eli DbA(String str) {
        char c;
        if (TextUtils.isEmpty(str)) {
            str = "unknown";
        }
        MGA.eli eliVar = new MGA.eli();
        str.hashCode();
        switch (str.hashCode()) {
            case -1308979344:
                if (str.equals("express")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 3107:
                if (str.equals("ad")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 3366:
                if (str.equals("io")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 107332:
                if (str.equals("log")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 108957:
                if (str.equals("net")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 2993840:
                if (str.equals("aidl")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 94416770:
                if (str.equals("cache")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 100313435:
                if (str.equals("image")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 1236319578:
                if (str.equals("monitor")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 1917389792:
                if (str.equals("imgdisk")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return eliVar.eli(str).eli(2).DbA(4).Os(0).eli(10000L).eli(true).ui(-1).aGH(10).DbA(false);
            case 1:
                return eliVar.eli(str).eli(4).DbA(4).Os(0).eli(20000L).eli(true).ui(-1).aGH(10).DbA(false);
            case 2:
                return eliVar.eli(str).eli(4).DbA(10).Os(0).eli(20000L).eli(true).ui(-1).aGH(10).DbA(false);
            case 3:
                return eliVar.eli(str).eli(4).DbA(6).Os(2).eli(20000L).eli(true).ui(-1).aGH(10).DbA(false);
            case 4:
                return eliVar.eli(str).eli(10).DbA(10).Os(0).eli(10000L).eli(true).ui(-1).aGH(10).DbA(false);
            case 5:
                return eliVar.eli(str).eli(2).DbA(4).Os(0).eli(10000L).eli(true).ui(-1).aGH(10).DbA(false);
            case 6:
                return eliVar.eli(str).eli(0).DbA(0).Os(0).eli(5000L).eli(true).ui(-1).aGH(20).DbA(false);
            case 7:
                return eliVar.eli(str).eli(3).DbA(3).Os(0).eli(20000L).eli(true).ui(-1).aGH(10).DbA(false);
            case '\b':
                return eliVar.eli(str).eli(2).DbA(2).Os(0).eli(10000L).eli(true).ui(-1).aGH(10).DbA(false);
            case '\t':
                return eliVar.eli(str).eli(1).DbA(2).Os(3).eli(10000L).eli(true).ui(-1).aGH(10).DbA(false);
            default:
                return eliVar.eli(str).eli(8).DbA(16).Os(2).eli(20000L).eli(true).ui(-1).aGH(10).DbA(false);
        }
    }
}
