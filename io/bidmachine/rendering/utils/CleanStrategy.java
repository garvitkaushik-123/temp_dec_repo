package io.bidmachine.rendering.utils;

import java.io.File;

/* loaded from: classes8.dex */
public abstract class CleanStrategy {
    protected abstract boolean a(File file);

    public void clean(File dir) {
        File[] listFiles;
        if (dir == null || (listFiles = dir.listFiles()) == null) {
            return;
        }
        for (File file : listFiles) {
            if (file != null && a(file)) {
                FileUtils.deleteFile(file);
            }
        }
    }
}
