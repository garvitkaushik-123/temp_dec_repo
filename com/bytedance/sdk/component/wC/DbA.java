package com.bytedance.sdk.component.wC;

import android.os.SystemClock;
import com.bytedance.sdk.component.utils.Dfc;

/* loaded from: classes3.dex */
class DbA implements Comparable, Runnable {
    private eli DbA;
    private long Os;
    private Thread aGH = null;
    private wC eli;

    private void eli(String str, String str2, long j) {
    }

    public DbA(wC wCVar, eli eliVar) {
        this.Os = 0L;
        this.eli = wCVar;
        this.DbA = eliVar;
        this.Os = SystemClock.uptimeMillis();
    }

    @Override // java.lang.Runnable
    public void run() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = uptimeMillis - this.Os;
        this.aGH = Thread.currentThread();
        wC wCVar = this.eli;
        if (wCVar != null) {
            wCVar.run();
        }
        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
        if (this.DbA != null) {
            aGH.eli();
        }
        if (Dfc.eli()) {
            eli eliVar = this.DbA;
            String eli = eliVar != null ? eliVar.eli() : "null";
            Long valueOf = Long.valueOf(j);
            Long valueOf2 = Long.valueOf(uptimeMillis2);
            wC wCVar2 = this.eli;
            new Object[]{"run: pool  = ", eli, " waitTime =", valueOf, " taskCost = ", valueOf2, " name=", wCVar2 != null ? wCVar2.getName() : "null"};
            String eli2 = this.DbA.eli();
            eli2.hashCode();
            switch (eli2) {
                case "ad":
                case "init":
                    if (uptimeMillis2 > 2000) {
                        eli eliVar2 = this.DbA;
                        String eli3 = eliVar2 != null ? eliVar2.eli() : "null";
                        wC wCVar3 = this.eli;
                        eli(eli3, wCVar3 != null ? wCVar3.getName() : "null", uptimeMillis2);
                        break;
                    }
                    break;
                case "io":
                    if (uptimeMillis2 > 5000) {
                        eli eliVar3 = this.DbA;
                        String eli4 = eliVar3 != null ? eliVar3.eli() : "null";
                        wC wCVar4 = this.eli;
                        eli(eli4, wCVar4 != null ? wCVar4.getName() : "null", uptimeMillis2);
                        break;
                    }
                    break;
                case "log":
                    if (uptimeMillis2 > 3000) {
                        eli eliVar4 = this.DbA;
                        String eli5 = eliVar4 != null ? eliVar4.eli() : "null";
                        wC wCVar5 = this.eli;
                        eli(eli5, wCVar5 != null ? wCVar5.getName() : "null", uptimeMillis2);
                        break;
                    }
                    break;
                case "computation":
                    if (uptimeMillis2 > 1000) {
                        eli eliVar5 = this.DbA;
                        String eli6 = eliVar5 != null ? eliVar5.eli() : "null";
                        wC wCVar6 = this.eli;
                        eli(eli6, wCVar6 != null ? wCVar6.getName() : "null", uptimeMillis2);
                        break;
                    }
                    break;
            }
        }
    }

    public wC eli() {
        return this.eli;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj instanceof DbA) {
            return this.eli.compareTo(((DbA) obj).eli());
        }
        return 0;
    }

    public int hashCode() {
        return this.eli.hashCode();
    }

    public boolean equals(Object obj) {
        wC wCVar;
        return (obj instanceof DbA) && (wCVar = this.eli) != null && wCVar.equals(((DbA) obj).eli());
    }
}
