package com.bytedance.sdk.component.ui.aGH.Os.eli;

import android.content.Context;
import java.io.File;

/* loaded from: classes3.dex */
public class DbA implements com.bytedance.sdk.component.ui.DbA, Cloneable {
    private static volatile com.bytedance.sdk.component.ui.DbA FC;
    private int DbA;
    private boolean MGA;
    private int Os;
    private int aGH;
    private long eli;
    private boolean kb;
    private boolean ui;
    private File wC;

    @Override // com.bytedance.sdk.component.ui.DbA
    public boolean FC() {
        return true;
    }

    public DbA(int i, int i2, int i3, long j, File file) {
        this(i, i2, i3, j, i2 != 0, j != 0, file);
    }

    public DbA(int i, int i2, int i3, long j, boolean z, boolean z2, File file) {
        this.eli = j;
        this.DbA = i;
        this.Os = i2;
        this.aGH = i3;
        this.ui = z;
        this.MGA = z2;
        this.wC = file;
        this.kb = i3 != 0;
    }

    @Override // com.bytedance.sdk.component.ui.DbA
    public long eli() {
        return this.eli;
    }

    @Override // com.bytedance.sdk.component.ui.DbA
    public int DbA() {
        return this.DbA;
    }

    @Override // com.bytedance.sdk.component.ui.DbA
    public int Os() {
        return this.Os;
    }

    @Override // com.bytedance.sdk.component.ui.DbA
    public int aGH() {
        return this.aGH;
    }

    @Override // com.bytedance.sdk.component.ui.DbA
    public boolean ui() {
        return this.ui;
    }

    @Override // com.bytedance.sdk.component.ui.DbA
    public boolean MGA() {
        return this.kb;
    }

    @Override // com.bytedance.sdk.component.ui.DbA
    public boolean kb() {
        return this.MGA;
    }

    @Override // com.bytedance.sdk.component.ui.DbA
    public File wC() {
        return this.wC;
    }

    public static void eli(Context context, com.bytedance.sdk.component.ui.DbA dbA) {
        if (dbA != null) {
            FC = dbA;
        } else {
            FC = eli(new File(context.getCacheDir(), "image"));
        }
    }

    public static com.bytedance.sdk.component.ui.DbA eli(File file) {
        long eli;
        int Os;
        int aGH;
        file.mkdirs();
        if (FC == null) {
            Os = 10;
            aGH = 14;
            eli = 20;
        } else {
            eli = FC.eli();
            Os = FC.Os();
            aGH = FC.aGH();
        }
        return new DbA(0, Os, aGH, eli, file);
    }

    public static com.bytedance.sdk.component.ui.DbA aAs() {
        return FC;
    }
}
