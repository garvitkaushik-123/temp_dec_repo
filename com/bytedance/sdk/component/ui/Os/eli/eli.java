package com.bytedance.sdk.component.ui.Os.eli;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.unity3d.services.core.di.ServiceProvider;
import java.io.File;

/* loaded from: classes3.dex */
public class eli implements com.bytedance.sdk.component.ui.DbA, Cloneable {
    private static volatile com.bytedance.sdk.component.ui.DbA MGA;
    private int DbA;
    private boolean Os;
    private boolean aGH;
    private long eli;
    private File ui;

    @Override // com.bytedance.sdk.component.ui.DbA
    public boolean FC() {
        return true;
    }

    @Override // com.bytedance.sdk.component.ui.DbA
    public boolean MGA() {
        return false;
    }

    @Override // com.bytedance.sdk.component.ui.DbA
    public int Os() {
        return 0;
    }

    @Override // com.bytedance.sdk.component.ui.DbA
    public int aGH() {
        return 0;
    }

    public eli(int i, long j, File file) {
        this(i, j, i != 0, j != 0, file);
    }

    public eli(int i, long j, boolean z, boolean z2, File file) {
        this.eli = j;
        this.DbA = i;
        this.Os = z;
        this.aGH = z2;
        this.ui = file;
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
    public boolean ui() {
        return this.Os;
    }

    @Override // com.bytedance.sdk.component.ui.DbA
    public boolean kb() {
        return this.aGH;
    }

    @Override // com.bytedance.sdk.component.ui.DbA
    public File wC() {
        return this.ui;
    }

    public static void eli(Context context, com.bytedance.sdk.component.ui.DbA dbA) {
        if (dbA != null) {
            MGA = dbA;
        } else {
            MGA = eli(new File(context.getCacheDir(), "image"));
        }
    }

    public static com.bytedance.sdk.component.ui.DbA eli(File file) {
        int min;
        long min2;
        file.mkdirs();
        if (MGA == null) {
            min = Math.min(Long.valueOf(Runtime.getRuntime().maxMemory()).intValue() / 16, 31457280);
            min2 = Math.min(du() / 16, 41943040L);
        } else {
            min = Math.min(MGA.DbA() / 2, 31457280);
            min2 = Math.min(MGA.eli() / 2, 41943040L);
        }
        return new eli(Math.max(min, 26214400), Math.max(min2, ServiceProvider.HTTP_CACHE_DISK_SIZE), file);
    }

    public static com.bytedance.sdk.component.ui.DbA aAs() {
        return MGA;
    }

    private static long du() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getAvailableBlocks() * statFs.getBlockSize();
    }
}
