package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;

/* loaded from: classes6.dex */
class H5 {

    /* renamed from: a, reason: collision with root package name */
    static final String f2895a = "ironbeast";
    static final String b = "outcome";
    static final int c = 4;
    static final int d = 3;
    static final int e = 2;
    static final int f = 0;

    H5() {
    }

    static AbstractC3052e a(String str, int i) {
        if (f2895a.equals(str)) {
            return new U9(i);
        }
        if (b.equals(str)) {
            return new Ec(i);
        }
        if (i == 2) {
            return new U9(i);
        }
        if (i == 3) {
            return new Ec(i);
        }
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.NATIVE, "EventsFormatterFactory failed to instantiate a formatter (type: " + str + ", adUnit: " + i + ")", 2);
        return null;
    }
}
