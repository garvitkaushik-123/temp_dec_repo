package com.ironsource.mediationsdk.logger;

import com.ironsource.Sa;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes6.dex */
public class IronSourceLoggerManager extends IronSourceLogger implements LogListener {
    private static volatile IronSourceLoggerManager d;
    private final List<IronSourceLogger> c;

    private IronSourceLoggerManager(String str) {
        super(str);
        this.c = new CopyOnWriteArrayList();
        c();
    }

    private void c() {
        this.c.add(new a(0));
    }

    public static IronSourceLoggerManager getLogger() {
        if (d == null) {
            synchronized (IronSourceLoggerManager.class) {
                if (d == null) {
                    d = new IronSourceLoggerManager("IronSourceLoggerManager");
                }
            }
        }
        return d;
    }

    void a(IronSourceLogger.IronSourceTag ironSourceTag, Sa sa) {
        if (a(sa.a())) {
            return;
        }
        a(ironSourceTag, sa.c(), sa.a());
    }

    public void addLogger(IronSourceLogger ironSourceLogger) {
        this.c.add(ironSourceLogger);
    }

    @Override // com.ironsource.mediationsdk.logger.IronSourceLogger
    @Deprecated(forRemoval = true, since = "8.3.0")
    public void log(IronSourceLogger.IronSourceTag ironSourceTag, String str, int i) {
        if (a(i)) {
            return;
        }
        a(ironSourceTag, str, i);
    }

    @Override // com.ironsource.mediationsdk.logger.IronSourceLogger
    public void logException(IronSourceLogger.IronSourceTag ironSourceTag, String str, Throwable th) {
        if (th == null) {
            Iterator<IronSourceLogger> it = this.c.iterator();
            while (it.hasNext()) {
                it.next().log(ironSourceTag, str, 3);
            }
        } else {
            Iterator<IronSourceLogger> it2 = this.c.iterator();
            while (it2.hasNext()) {
                it2.next().logException(ironSourceTag, str, th);
            }
        }
    }

    @Override // com.ironsource.mediationsdk.logger.LogListener
    public void onLog(IronSourceLogger.IronSourceTag ironSourceTag, String str, int i) {
        log(ironSourceTag, str, i);
    }

    public void setLoggerDebugLevel(String str, int i) {
        if (str == null) {
            return;
        }
        IronSourceLogger a2 = a(str);
        if (a2 == null) {
            log(IronSourceLogger.IronSourceTag.NATIVE, "Failed to find logger:setLoggerDebugLevel(loggerName:" + str + " ,debugLevel:" + i + ")", 0);
        } else if (i < 0 || i > 3) {
            this.c.remove(a2);
        } else {
            log(IronSourceLogger.IronSourceTag.NATIVE, "setLoggerDebugLevel(loggerName:" + str + " ,debugLevel:" + i + ")", 0);
            a2.setDebugLevel(i);
        }
    }

    private IronSourceLoggerManager(String str, int i) {
        super(str, i);
        this.c = new CopyOnWriteArrayList();
        c();
    }

    private boolean a(int i) {
        return i < this.f3543a;
    }

    protected void a(IronSourceLogger.IronSourceTag ironSourceTag, String str, int i) {
        for (IronSourceLogger ironSourceLogger : this.c) {
            if (ironSourceLogger.a() <= i) {
                ironSourceLogger.log(ironSourceTag, str, i);
            }
        }
    }

    public static IronSourceLoggerManager getLogger(int i) {
        IronSourceLoggerManager logger = getLogger();
        logger.f3543a = i;
        return logger;
    }

    private IronSourceLogger a(String str) {
        for (IronSourceLogger ironSourceLogger : this.c) {
            if (ironSourceLogger.b().equals(str)) {
                return ironSourceLogger;
            }
        }
        return null;
    }
}
