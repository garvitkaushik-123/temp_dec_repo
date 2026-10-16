package io.bidmachine.rendering.utils;

import java.io.File;
import java.io.FileOutputStream;

/* loaded from: classes8.dex */
public class VideoUtils {
    public static void saveVideo(File file, byte[] byteVideo) {
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(byteVideo);
                io.bidmachine.iab.utils.Utils.flush(fileOutputStream2);
                io.bidmachine.iab.utils.Utils.close(fileOutputStream2);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                io.bidmachine.iab.utils.Utils.flush(fileOutputStream);
                io.bidmachine.iab.utils.Utils.close(fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
