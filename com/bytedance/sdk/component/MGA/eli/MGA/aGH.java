package com.bytedance.sdk.component.MGA.eli.MGA;

import android.text.TextUtils;
import java.util.Map;

/* loaded from: classes3.dex */
public class aGH {
    private final String DbA;
    private final String MGA;
    private final boolean Os;
    private boolean du;
    private final String eli;
    private String kb;
    private final int ui;
    private String wC;
    private int aGH = -1;
    private int FC = 0;
    private String aAs = null;

    aGH(String str, String str2, boolean z, int i, String str3) {
        this.eli = str;
        this.DbA = str2;
        this.Os = z;
        this.ui = i;
        this.MGA = str3;
    }

    public String eli() {
        return this.eli;
    }

    public String DbA() {
        return this.DbA;
    }

    public boolean Os() {
        return this.Os;
    }

    public int aGH() {
        return this.aGH;
    }

    public void eli(int i) {
        this.aGH = i;
    }

    public int ui() {
        return this.ui;
    }

    public String MGA() {
        return this.MGA;
    }

    public void eli(String str) {
        this.kb = str;
    }

    public String kb() {
        return this.kb;
    }

    public void DbA(int i) {
        this.FC = i;
        if (i == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.kb)) {
            this.kb = String.valueOf(this.FC);
        } else {
            this.kb += "," + this.FC;
        }
    }

    public int wC() {
        return this.FC;
    }

    public void DbA(String str) {
        this.wC = str;
    }

    public String FC() {
        return this.wC;
    }

    public void Os(String str) {
        this.aAs = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(this.wC)) {
            this.wC = String.valueOf(this.aAs);
        } else {
            this.wC += "," + this.aAs;
        }
    }

    public void eli(boolean z) {
        this.du = z;
    }

    public boolean aAs() {
        return this.du;
    }

    public Runnable eli(String str, Map<String, String> map) {
        return eli.eli().eli(this, str, map);
    }

    public boolean du() {
        return this.aGH == -1;
    }
}
