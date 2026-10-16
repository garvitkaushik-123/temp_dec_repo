package com.bytedance.sdk.openadsdk.DbA;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public class DbA extends eli {
    private int DbA;
    private int Os;
    private volatile boolean aGH;

    public DbA(int i, int i2) {
        this.DbA = 15;
        this.Os = 3;
        if (i <= 0) {
            throw new IllegalArgumentException("Max count must be positive number!");
        }
        this.DbA = i;
        this.Os = i2;
    }

    public DbA(int i, int i2, boolean z) {
        this.DbA = 15;
        this.Os = 3;
        if (i <= 0) {
            throw new IllegalArgumentException("Max count must be positive number!");
        }
        this.DbA = i;
        this.Os = i2;
        this.aGH = z;
    }

    @Override // com.bytedance.sdk.openadsdk.DbA.eli
    protected boolean eli(long j, int i) {
        return i <= this.DbA;
    }

    @Override // com.bytedance.sdk.openadsdk.DbA.eli
    protected boolean eli(File file, long j, int i) {
        return i <= this.Os;
    }

    @Override // com.bytedance.sdk.openadsdk.DbA.eli
    protected void eli(List<File> list) {
        if (this.aGH) {
            aGH(list);
            this.aGH = false;
        } else {
            Os(list);
        }
    }

    private void Os(List<File> list) {
        long DbA = DbA(list);
        int size = list.size();
        if (eli(DbA, size)) {
            return;
        }
        for (File file : list) {
            long length = file.length();
            if (file.delete()) {
                size--;
                DbA -= length;
            }
            if (eli(file, DbA, size)) {
                return;
            }
        }
    }

    private void aGH(List<File> list) {
        long DbA;
        int size;
        boolean eli;
        if (list != null) {
            try {
                if (list.size() != 0 && !(eli = eli((DbA = DbA(list)), (size = list.size())))) {
                    TreeMap treeMap = new TreeMap();
                    for (File file : list) {
                        treeMap.put(Long.valueOf(file.lastModified()), file);
                    }
                    for (Map.Entry entry : treeMap.entrySet()) {
                        if (entry != null && !eli) {
                            ((Long) entry.getKey()).longValue();
                            File file2 = (File) entry.getValue();
                            long length = file2.length();
                            if (file2.delete()) {
                                size--;
                                DbA -= length;
                            }
                            if (eli(file2, DbA, size)) {
                                return;
                            }
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
