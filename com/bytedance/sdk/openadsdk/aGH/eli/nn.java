package com.bytedance.sdk.openadsdk.aGH.eli;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class nn {
    public static nn eli = new nn();
    private eli DbA;
    private final Map<String, eli> Os = new HashMap();
    private volatile boolean aGH;

    private int DbA() {
        eli eliVar = this.DbA;
        if (eliVar != null) {
            return eliVar.eli();
        }
        return 3;
    }

    private int Os() {
        eli eliVar = this.DbA;
        if (eliVar != null) {
            return eliVar.DbA();
        }
        return 30;
    }

    public void eli(eli eliVar) {
        this.DbA = eliVar;
    }

    public void eli(String str, eli eliVar) {
        if (TextUtils.isEmpty(str) || eliVar == null) {
            return;
        }
        this.Os.put(str, eliVar);
    }

    public int eli(String str) {
        if (!eli()) {
            return 4;
        }
        eli eliVar = this.Os.get(str);
        if (eliVar == null) {
            return DbA();
        }
        return eliVar.eli();
    }

    public int DbA(String str) {
        eli eliVar = this.Os.get(str);
        if (eliVar == null) {
            return Os();
        }
        return eliVar.DbA();
    }

    public boolean eli() {
        return this.aGH;
    }

    public void eli(boolean z) {
        this.aGH = z;
    }

    public static class eli {
        private final int DbA;
        private final int eli;

        public eli(int i, int i2) {
            this.eli = (i < 0 || i > 5) ? 3 : i;
            this.DbA = i2 < 10 ? 30 : i2;
        }

        public int eli() {
            return this.eli;
        }

        public int DbA() {
            return this.DbA;
        }
    }
}
