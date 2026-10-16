package com.bytedance.sdk.component.DbA.eli;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public abstract class du implements Cloneable {
    public long DbA;
    public long MGA;
    public TimeUnit Os;
    public long aGH;
    public List<wC> eli;
    public TimeUnit kb;
    public TimeUnit ui;

    public abstract DbA eli(nlS nls);

    public abstract aGH eli();

    public du(eli eliVar) {
        this.DbA = eliVar.DbA;
        this.aGH = eliVar.aGH;
        this.MGA = eliVar.MGA;
        this.eli = eliVar.eli;
        this.Os = eliVar.Os;
        this.ui = eliVar.ui;
        this.kb = eliVar.kb;
        this.eli = eliVar.eli;
    }

    public static final class eli {
        public long DbA;
        public long MGA;
        public TimeUnit Os;
        public long aGH;
        public final List<wC> eli;
        public TimeUnit kb;
        public TimeUnit ui;

        public eli() {
            this.eli = new ArrayList();
            this.DbA = 10000L;
            this.Os = TimeUnit.MILLISECONDS;
            this.aGH = 10000L;
            this.ui = TimeUnit.MILLISECONDS;
            this.MGA = 10000L;
            this.kb = TimeUnit.MILLISECONDS;
        }

        public eli(String str) {
            this.eli = new ArrayList();
            this.DbA = 10000L;
            this.Os = TimeUnit.MILLISECONDS;
            this.aGH = 10000L;
            this.ui = TimeUnit.MILLISECONDS;
            this.MGA = 10000L;
            this.kb = TimeUnit.MILLISECONDS;
        }

        public eli(du duVar) {
            this.eli = new ArrayList();
            this.DbA = 10000L;
            this.Os = TimeUnit.MILLISECONDS;
            this.aGH = 10000L;
            this.ui = TimeUnit.MILLISECONDS;
            this.MGA = 10000L;
            this.kb = TimeUnit.MILLISECONDS;
            this.DbA = duVar.DbA;
            this.Os = duVar.Os;
            this.aGH = duVar.aGH;
            this.ui = duVar.ui;
            this.MGA = duVar.MGA;
            this.kb = duVar.kb;
        }

        public eli eli(long j, TimeUnit timeUnit) {
            this.DbA = j;
            this.Os = timeUnit;
            return this;
        }

        public eli DbA(long j, TimeUnit timeUnit) {
            this.aGH = j;
            this.ui = timeUnit;
            return this;
        }

        public eli Os(long j, TimeUnit timeUnit) {
            this.MGA = j;
            this.kb = timeUnit;
            return this;
        }

        public eli eli(wC wCVar) {
            this.eli.add(wCVar);
            return this;
        }

        public du eli() {
            return com.bytedance.sdk.component.DbA.eli.eli.eli.eli(this);
        }
    }

    public eli DbA() {
        return new eli(this);
    }
}
