package com.bytedance.sdk.component.kb;

import android.os.Bundle;
import com.bytedance.sdk.component.DbA.eli.du;
import com.bytedance.sdk.component.DbA.eli.eli.eli.ui;
import com.bytedance.sdk.component.DbA.eli.wC;
import com.bytedance.sdk.component.kb.DbA.aGH;
import com.bytedance.sdk.component.kb.Os.Os;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class eli {
    private static ui eli;
    private du DbA;

    private eli(C0146eli c0146eli) {
        du.eli DbA = new du.eli().eli(c0146eli.eli, TimeUnit.MILLISECONDS).Os(c0146eli.Os, TimeUnit.MILLISECONDS).DbA(c0146eli.DbA, TimeUnit.MILLISECONDS);
        if (c0146eli.aGH != null && c0146eli.aGH.size() > 0) {
            Iterator<wC> it = c0146eli.aGH.iterator();
            while (it.hasNext()) {
                DbA.eli(it.next());
            }
        }
        if (c0146eli.MGA != null) {
            Bundle unused = c0146eli.MGA;
        }
        Set unused2 = c0146eli.ui;
        this.DbA = DbA.eli();
    }

    public static void eli() {
        Os.eli(Os.eli.DEBUG);
    }

    public aGH DbA() {
        return new aGH(this.DbA);
    }

    public com.bytedance.sdk.component.kb.DbA.DbA Os() {
        return new com.bytedance.sdk.component.kb.DbA.DbA(this.DbA);
    }

    public com.bytedance.sdk.component.kb.DbA.eli aGH() {
        return new com.bytedance.sdk.component.kb.DbA.eli(this.DbA);
    }

    public static boolean ui() {
        ui uiVar = eli;
        if (uiVar == null) {
            return false;
        }
        return uiVar.eli();
    }

    public static void eli(ui uiVar) {
        eli = uiVar;
    }

    public du MGA() {
        return this.DbA;
    }

    /* renamed from: com.bytedance.sdk.component.kb.eli$eli, reason: collision with other inner class name */
    public static final class C0146eli {
        private Bundle MGA;
        private Set<String> ui;
        final List<wC> aGH = new ArrayList();
        int eli = 10000;
        int DbA = 10000;
        int Os = 10000;

        public C0146eli eli(boolean z) {
            return this;
        }

        public C0146eli eli(long j, TimeUnit timeUnit) {
            this.eli = eli("timeout", j, timeUnit);
            return this;
        }

        public C0146eli DbA(long j, TimeUnit timeUnit) {
            this.DbA = eli("timeout", j, timeUnit);
            return this;
        }

        public C0146eli Os(long j, TimeUnit timeUnit) {
            this.Os = eli("timeout", j, timeUnit);
            return this;
        }

        public C0146eli eli(wC wCVar) {
            this.aGH.add(wCVar);
            return this;
        }

        private static int eli(String str, long j, TimeUnit timeUnit) {
            if (j < 0) {
                throw new IllegalArgumentException(str + " < 0");
            }
            if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            }
            long millis = timeUnit.toMillis(j);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException(str + " too large.");
            }
            if (millis != 0 || j <= 0) {
                return (int) millis;
            }
            throw new IllegalArgumentException(str + " too small.");
        }

        public eli eli() {
            return new eli(this);
        }
    }
}
