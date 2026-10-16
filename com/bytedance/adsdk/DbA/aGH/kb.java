package com.bytedance.adsdk.DbA.aGH;

import android.util.Pair;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class kb {
    private final ui eli;

    public kb(ui uiVar) {
        this.eli = uiVar;
    }

    Pair<Os, InputStream> eli(String str) {
        Os os;
        try {
            File DbA = DbA(str);
            if (DbA == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(DbA);
            if (DbA.getAbsolutePath().endsWith(".zip")) {
                os = Os.ZIP;
            } else {
                os = Os.JSON;
            }
            DbA.getAbsolutePath();
            return new Pair<>(os, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    File eli(String str, InputStream inputStream, Os os) throws IOException {
        File file = new File(eli(), eli(str, os, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.flush();
                        return file;
                    }
                }
            } finally {
                fileOutputStream.close();
            }
        } finally {
            inputStream.close();
        }
    }

    void eli(String str, Os os) {
        File file = new File(eli(), eli(str, os, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean renameTo = file.renameTo(file2);
        new StringBuilder("Copying temp file to real file (").append(file2);
        if (renameTo) {
            return;
        }
        file.getAbsolutePath();
        file2.getAbsolutePath();
    }

    private File DbA(String str) throws FileNotFoundException {
        File file = new File(eli(), eli(str, Os.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(eli(), eli(str, Os.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    private File eli() {
        File eli = this.eli.eli();
        if (eli.isFile()) {
            eli.delete();
        }
        if (!eli.exists()) {
            eli.mkdirs();
        }
        return eli;
    }

    private static String eli(String str, Os os, boolean z) {
        return "lottie_cache_" + str.replaceAll("\\W+", "") + (z ? os.eli() : os.Os);
    }
}
