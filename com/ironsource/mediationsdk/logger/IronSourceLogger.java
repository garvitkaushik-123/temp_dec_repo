package com.ironsource.mediationsdk.logger;

/* loaded from: classes6.dex */
public abstract class IronSourceLogger {

    /* renamed from: a, reason: collision with root package name */
    int f3543a;
    private String b;

    public class IronSourceLogLevel {
        public static final int ERROR = 3;
        public static final int GENERAL = 4;
        public static final int INFO = 1;
        public static final int VERBOSE = 0;
        public static final int WARNING = 2;

        public IronSourceLogLevel() {
        }
    }

    public enum IronSourceTag {
        API,
        ADAPTER_API,
        CALLBACK,
        ADAPTER_CALLBACK,
        NETWORK,
        INTERNAL,
        NATIVE,
        EVENT
    }

    IronSourceLogger(String str) {
        this.b = str;
        this.f3543a = 0;
    }

    int a() {
        return this.f3543a;
    }

    String b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof IronSourceLogger)) {
            IronSourceLogger ironSourceLogger = (IronSourceLogger) obj;
            String str = this.b;
            if (str != null && str.equals(ironSourceLogger.b)) {
                return true;
            }
        }
        return false;
    }

    public abstract void log(IronSourceTag ironSourceTag, String str, int i);

    public abstract void logException(IronSourceTag ironSourceTag, String str, Throwable th);

    public void setDebugLevel(int i) {
        this.f3543a = i;
    }

    IronSourceLogger(String str, int i) {
        this.b = str;
        this.f3543a = i;
    }
}
