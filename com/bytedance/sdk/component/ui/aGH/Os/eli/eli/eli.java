package com.bytedance.sdk.component.ui.aGH.Os.eli.eli;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.aAs;
import com.bytedance.sdk.component.utils.kb;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class eli {
    private File DbA;
    private int eli;

    private eli(int i, File file) {
        this.eli = i;
        this.DbA = file;
    }

    public static eli eli(int i, File file) {
        try {
            eli eliVar = new eli(i, file);
            if (file != null) {
                file.mkdirs();
            }
            return eliVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public synchronized InputStream eli(String str) {
        FileInputStream fileInputStream;
        if (this.eli <= 0) {
            return null;
        }
        File DbA = DbA(str);
        try {
            try {
                fileInputStream = new FileInputStream(DbA);
            } catch (Throwable unused) {
                return null;
            }
        } catch (FileNotFoundException unused2) {
            fileInputStream = null;
        }
        try {
            Os(DbA);
            return fileInputStream;
        } catch (FileNotFoundException unused3) {
            aAs.eli(fileInputStream);
            return null;
        }
    }

    public synchronized boolean eli(String str, byte[] bArr) {
        if (this.eli > 0 && str != null && bArr != null) {
            File Os = Os(str);
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(Os);
                try {
                    fileOutputStream2.write(bArr);
                    if (Os.exists()) {
                        eli(Os, DbA(str), true);
                    }
                    aAs.eli(fileOutputStream2);
                    List<File> eli = eli(this.DbA);
                    if (eli != null) {
                        int size = eli.size();
                        int i = this.eli;
                        if (size > i) {
                            eli((int) (i * 0.7d));
                        }
                    }
                    return true;
                } catch (FileNotFoundException unused) {
                    fileOutputStream = fileOutputStream2;
                    try {
                        File file = this.DbA;
                        if (file != null) {
                            file.mkdirs();
                        }
                        aAs.eli(fileOutputStream);
                        List<File> eli2 = eli(this.DbA);
                        if (eli2 != null) {
                            int size2 = eli2.size();
                            int i2 = this.eli;
                            if (size2 > i2) {
                                eli((int) (i2 * 0.7d));
                            }
                        }
                        return false;
                    } finally {
                        aAs.eli(fileOutputStream);
                        List<File> eli3 = eli(this.DbA);
                        if (eli3 != null) {
                            int size3 = eli3.size();
                            int i3 = this.eli;
                            if (size3 > i3) {
                                eli((int) (i3 * 0.7d));
                            }
                        }
                    }
                } catch (Throwable unused2) {
                    fileOutputStream = fileOutputStream2;
                    return false;
                }
            } catch (FileNotFoundException unused3) {
            } catch (Throwable unused4) {
            }
        }
        return false;
    }

    private List<File> eli(File file) {
        File[] listFiles;
        if (file != null) {
            try {
                if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
                    List<File> asList = Arrays.asList(listFiles);
                    ArrayList arrayList = new ArrayList();
                    for (File file2 : asList) {
                        if (file2 != null && file2.isFile() && !TextUtils.isEmpty(file2.getName()) && !file2.getName().endsWith(".temp")) {
                            arrayList.add(file2);
                        }
                    }
                    return arrayList;
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public synchronized void eli(int i) {
        try {
            if (i > this.eli) {
                return;
            }
            List<File> DbA = DbA(this.DbA);
            if (DbA != null && DbA.size() > i) {
                while (i < DbA.size()) {
                    File file = DbA.get(i);
                    if (file != null && file.exists()) {
                        file.delete();
                    }
                    i++;
                }
            }
        } catch (Throwable unused) {
        }
    }

    private List<File> DbA(File file) {
        List<File> eli = eli(file);
        if (eli == null || eli.isEmpty()) {
            return null;
        }
        final HashMap hashMap = new HashMap();
        for (File file2 : eli) {
            hashMap.put(file2, Long.valueOf(file2.lastModified()));
        }
        Collections.sort(eli, new Comparator<File>() { // from class: com.bytedance.sdk.component.ui.aGH.Os.eli.eli.eli.1
            @Override // java.util.Comparator
            /* renamed from: eli, reason: merged with bridge method [inline-methods] */
            public int compare(File file3, File file4) {
                if (file3 == null && file4 == null) {
                    return 0;
                }
                if (file3 == null) {
                    return 1;
                }
                if (file4 == null) {
                    return -1;
                }
                return Long.compare(((Long) hashMap.get(file4)).longValue(), ((Long) hashMap.get(file3)).longValue());
            }
        });
        return eli;
    }

    private void Os(File file) {
        if (file == null) {
            return;
        }
        try {
            kb.DbA(file);
        } catch (Throwable unused) {
        }
    }

    private void eli(File file, File file2, boolean z) throws IOException {
        if (z) {
            aGH(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    private static void aGH(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private File DbA(String str) {
        return new File(this.DbA, str);
    }

    private File Os(String str) {
        return new File(this.DbA, str + ".temp");
    }
}
