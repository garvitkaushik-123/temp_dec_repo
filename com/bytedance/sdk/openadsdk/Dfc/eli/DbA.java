package com.bytedance.sdk.openadsdk.Dfc.eli;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.dZ;

/* loaded from: classes3.dex */
public class DbA {
    private ev DbA;
    private String MGA;
    private String Os;
    private int aGH;
    private String eli;
    private int kb;
    private boolean ui;
    private int wC = 0;
    private int FC = 0;

    public String eli() {
        return this.eli;
    }

    public void eli(String str) {
        this.eli = str;
    }

    public ev DbA() {
        return this.DbA;
    }

    public void eli(ev evVar) {
        this.DbA = evVar;
    }

    public String Os() {
        ev evVar;
        if (TextUtils.isEmpty(this.Os) && (evVar = this.DbA) != null) {
            this.Os = dZ.eli(evVar);
        }
        return this.Os;
    }

    public void DbA(String str) {
        this.Os = str;
    }

    public int aGH() {
        return this.aGH;
    }

    public void eli(int i) {
        this.aGH = i;
    }

    public boolean ui() {
        return this.ui;
    }

    public void eli(boolean z) {
        this.ui = z;
    }

    public String MGA() {
        return this.MGA;
    }

    public void Os(String str) {
        this.MGA = str;
    }

    public int kb() {
        return this.kb;
    }

    public void DbA(int i) {
        this.kb = i;
    }

    public int wC() {
        return this.wC;
    }

    public void Os(int i) {
        this.wC = i;
    }

    public int FC() {
        return this.FC;
    }

    public void aGH(int i) {
        this.FC = i;
    }
}
