package com.bytedance.sdk.component.kb;

import com.bytedance.sdk.component.DbA.eli.aAs;
import java.io.File;
import java.util.Map;

/* loaded from: classes3.dex */
public class DbA {
    final String DbA;
    private final boolean FC;
    final long MGA;
    final Map<String, String> Os;
    final String aGH;
    final int eli;
    aAs kb;
    final long ui;
    private File wC = null;
    private byte[] aAs = null;

    public DbA(boolean z, int i, String str, Map<String, String> map, String str2, long j, long j2) {
        this.FC = z;
        this.eli = i;
        this.DbA = str;
        this.Os = map;
        this.aGH = str2;
        this.ui = j;
        this.MGA = j2;
    }

    public int eli() {
        return this.eli;
    }

    public String DbA() {
        return this.DbA;
    }

    public Map<String, String> Os() {
        return this.Os;
    }

    public String aGH() {
        return this.aGH;
    }

    public File ui() {
        return this.wC;
    }

    public void eli(File file) {
        this.wC = file;
    }

    public boolean MGA() {
        return this.FC;
    }

    public void eli(byte[] bArr) {
        this.aAs = bArr;
    }

    public aAs kb() {
        return this.kb;
    }

    public void eli(aAs aas) {
        this.kb = aas;
    }
}
