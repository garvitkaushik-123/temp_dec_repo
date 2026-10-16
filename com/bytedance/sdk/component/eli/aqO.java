package com.bytedance.sdk.component.eli;

import android.text.TextUtils;

/* loaded from: classes3.dex */
public class aqO {
    public final String DbA;
    public final String MGA;
    public final String Os;
    public final String aGH;
    public final int eli;
    public final String kb;
    public final String ui;
    public final String wC;

    public static eli eli() {
        return new eli();
    }

    public static aqO eli(String str, int i) {
        return new aqO(str, i);
    }

    private aqO(String str, int i) {
        this.DbA = null;
        this.Os = null;
        this.aGH = null;
        this.ui = null;
        this.MGA = str;
        this.kb = null;
        this.eli = i;
        this.wC = null;
    }

    private aqO(eli eliVar) {
        this.DbA = eliVar.eli;
        this.Os = eliVar.DbA;
        this.aGH = eliVar.Os;
        this.ui = eliVar.aGH;
        this.MGA = eliVar.ui;
        this.kb = eliVar.MGA;
        this.eli = 1;
        this.wC = eliVar.kb;
    }

    public static boolean eli(aqO aqo) {
        return aqo == null || aqo.eli != 1 || TextUtils.isEmpty(aqo.aGH) || TextUtils.isEmpty(aqo.ui);
    }

    public String toString() {
        return "methodName: " + this.aGH + ", params: " + this.ui + ", callbackId: " + this.MGA + ", type: " + this.Os + ", version: " + this.DbA + ", ";
    }

    public static final class eli {
        private String DbA;
        private String MGA;
        private String Os;
        private String aGH;
        private String eli;
        private String kb;
        private String ui;

        private eli() {
        }

        public eli eli(String str) {
            this.eli = str;
            return this;
        }

        public eli DbA(String str) {
            this.DbA = str;
            return this;
        }

        public eli Os(String str) {
            this.Os = str;
            return this;
        }

        public eli aGH(String str) {
            this.aGH = str;
            return this;
        }

        public eli ui(String str) {
            this.ui = str;
            return this;
        }

        public eli MGA(String str) {
            this.MGA = str;
            return this;
        }

        public eli kb(String str) {
            this.kb = str;
            return this;
        }

        public aqO eli() {
            return new aqO(this);
        }
    }
}
