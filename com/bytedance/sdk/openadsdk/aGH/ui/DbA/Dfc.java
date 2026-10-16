package com.bytedance.sdk.openadsdk.aGH.ui.DbA;

import com.bytedance.sdk.openadsdk.core.model.ev;

/* loaded from: classes3.dex */
public class Dfc {
    private String DbA;
    private int Os;
    private com.bykv.vk.openvk.eli.eli.eli.Os.Os aGH;
    private long eli;
    private ev ui;

    public Dfc(long j, String str, int i, com.bykv.vk.openvk.eli.eli.eli.Os.Os os, ev evVar) {
        this.eli = j;
        this.DbA = str;
        this.Os = i;
        this.aGH = os;
        this.ui = evVar;
    }

    public long eli() {
        return this.eli;
    }

    public String DbA() {
        return this.DbA;
    }

    public int Os() {
        return this.Os;
    }

    public com.bykv.vk.openvk.eli.eli.eli.Os.Os aGH() {
        return this.aGH;
    }

    public ev ui() {
        return this.ui;
    }

    public static class eli {
        private int FC;
        private int aAs;
        private boolean aGH;
        private int du;
        private int nlS;
        private com.bykv.vk.openvk.eli.eli.eli.Os.eli nn;
        private boolean ui;
        private int wC;
        private long eli = 0;
        private long DbA = 0;
        private long Os = 0;
        private long MGA = 0;
        private boolean kb = false;
        private boolean NU = false;

        public long eli() {
            return this.MGA;
        }

        public void eli(long j) {
            this.MGA = j;
        }

        public long DbA() {
            return this.eli;
        }

        public void DbA(long j) {
            this.eli = j;
            aqO();
        }

        private void aqO() {
            long j = this.Os;
            if (j > 0) {
                long j2 = this.eli;
                if (j2 > j) {
                    long j3 = j2 % j;
                    this.eli = j3;
                    if (j3 == 0) {
                        this.eli = j;
                    }
                }
            }
        }

        public long Os() {
            return this.DbA;
        }

        public void Os(long j) {
            this.DbA = j;
        }

        public long aGH() {
            return this.Os;
        }

        public void aGH(long j) {
            this.Os = j;
            aqO();
        }

        public int ui() {
            return this.wC;
        }

        public void eli(int i) {
            this.wC = i;
        }

        public int MGA() {
            return this.FC;
        }

        public void DbA(int i) {
            this.FC = i;
        }

        public int kb() {
            long j = this.Os;
            if (j <= 0) {
                return 0;
            }
            return Math.min((int) ((this.eli * 100) / j), 100);
        }

        public int wC() {
            return this.aAs;
        }

        public void Os(int i) {
            this.aAs = i;
        }

        public int FC() {
            return this.du;
        }

        public int aAs() {
            return this.nlS;
        }

        public void aGH(int i) {
            this.nlS = i;
        }

        public boolean du() {
            return this.NU;
        }

        public boolean nlS() {
            return this.kb;
        }

        public void eli(boolean z) {
            this.kb = z;
        }

        public void eli(com.bykv.vk.openvk.eli.eli.eli.Os.eli eliVar) {
            this.nn = eliVar;
        }

        public com.bykv.vk.openvk.eli.eli.eli.Os.eli NU() {
            return this.nn;
        }

        public void DbA(boolean z) {
            this.aGH = z;
        }

        public boolean nn() {
            return this.aGH;
        }

        public void Os(boolean z) {
            this.ui = z;
        }

        public boolean Dfc() {
            return this.ui;
        }
    }
}
