package com.bytedance.sdk.component.ui.Os.eli.eli;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
final class aGH {
    static final Charset eli = Charset.forName(C.ASCII_NAME);
    static final Charset DbA = Charset.forName("UTF-8");

    static void eli(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IOException("not a readable directory: ".concat(String.valueOf(file)));
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                eli(file2);
            }
            if (!file2.delete()) {
                throw new IOException("failed to delete file: ".concat(String.valueOf(file2)));
            }
        }
    }
}
