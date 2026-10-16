package com.bytedance.sdk.openadsdk.aqO;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class DbA {
    public static int DbA = 0;
    public static int Os = 1;
    public static int aGH = 2;
    public static int eli = -1;
    public static int ui = 3;
    private int MGA = eli;
    private long kb = 0;
    private long wC = 0;
    private final List<Os> FC = new ArrayList();
    private long aAs = 0;

    public void eli(long j) {
        this.MGA = DbA;
        this.kb = j;
    }

    public void DbA(long j) {
        int i;
        int i2 = this.MGA;
        if (i2 == eli || i2 == (i = ui)) {
            return;
        }
        this.MGA = i;
        this.wC = j;
    }

    public void Os(long j) {
        int i;
        int i2 = this.MGA;
        if (i2 == eli || i2 == (i = aGH) || i2 == ui) {
            return;
        }
        this.MGA = i;
        this.aAs = j;
    }

    public void aGH(long j) {
        int i = this.MGA;
        if (i == eli || i != aGH) {
            return;
        }
        this.MGA = Os;
        this.FC.add(new Os(this.aAs, j));
        this.aAs = 0L;
    }

    public long eli(long j, long j2) {
        long j3;
        long j4;
        long DbA2;
        long j5 = this.wC;
        if (j5 != 0 && j > j5) {
            return 0L;
        }
        int i = 0;
        for (Os os : this.FC) {
            if (os.DbA() > j) {
                if (j < os.eli()) {
                    j4 = i;
                    DbA2 = os.DbA() - os.eli();
                } else {
                    j4 = i;
                    DbA2 = os.DbA() - j;
                }
                i = (int) (j4 + DbA2);
            }
        }
        long j6 = this.kb;
        if (j6 < j) {
            long j7 = this.aAs;
            if (j7 == 0) {
                j7 = this.wC;
                if (j7 == 0) {
                    j3 = j2 - j;
                }
            } else if (j7 <= j) {
                return 0L;
            }
            return (j7 - j) - i;
        }
        long j8 = this.aAs;
        if (j8 == 0) {
            j8 = this.wC;
            if (j8 == 0) {
                j3 = j2 - j6;
            }
        } else if (j8 <= j6) {
            return 0L;
        }
        return (j8 - j6) - i;
        return j3 - i;
    }

    public int eli() {
        return this.MGA;
    }
}
