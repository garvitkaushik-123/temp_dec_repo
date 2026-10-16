package com.ironsource.mediationsdk.logger;

import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.logger.IronSourceLogger;

/* loaded from: classes6.dex */
public class b extends IronSourceLogger {
    private static final String e = "publisher";
    private LogListener c;
    private boolean d;

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3546a;
        final /* synthetic */ IronSourceLogger.IronSourceTag b;
        final /* synthetic */ int c;

        a(String str, IronSourceLogger.IronSourceTag ironSourceTag, int i) {
            this.f3546a = str;
            this.b = ironSourceTag;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            LogListener logListener = b.this.c;
            if (logListener == null || (str = this.f3546a) == null) {
                return;
            }
            logListener.onLog(this.b, str, this.c);
        }
    }

    private b() {
        super("publisher");
    }

    public void a(LogListener logListener) {
        this.c = logListener;
    }

    @Override // com.ironsource.mediationsdk.logger.IronSourceLogger
    public void log(IronSourceLogger.IronSourceTag ironSourceTag, String str, int i) {
        a aVar = new a(str, ironSourceTag, i);
        if (this.d) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(aVar);
        } else {
            IronSourceThreadManager.INSTANCE.postPublisherCallback(aVar);
        }
    }

    @Override // com.ironsource.mediationsdk.logger.IronSourceLogger
    public void logException(IronSourceLogger.IronSourceTag ironSourceTag, String str, Throwable th) {
        if (th != null) {
            log(ironSourceTag, th.getMessage(), 3);
        }
    }

    public b(LogListener logListener, int i) {
        super("publisher", i);
        this.c = logListener;
        this.d = false;
    }

    public void a(boolean z) {
        this.d = z;
    }
}
