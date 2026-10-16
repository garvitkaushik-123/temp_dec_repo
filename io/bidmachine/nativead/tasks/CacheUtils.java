package io.bidmachine.nativead.tasks;

import android.media.ThumbnailUtils;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/* loaded from: classes6.dex */
class CacheUtils {
    CacheUtils() {
    }

    static File cacheVideoFile(String url, File cacheDir, int timeOut) {
        InputStream inputStream;
        File file;
        InputStream inputStream2 = null;
        try {
            inputStream = ConnectionUtils.getInputStream(url, timeOut);
            try {
                try {
                    file = new File(cacheDir, Utils.generateFileName(url));
                } catch (Exception e) {
                    e = e;
                    Logger.w(e);
                    Utils.close(inputStream);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                Utils.close(inputStream2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            Utils.close(inputStream2);
            throw th;
        }
        if (!file.exists() || file.length() <= 0 || !isVideoFileSupported(file)) {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            Utils.close(fileOutputStream);
            if (isVideoFileSupported(file)) {
                Utils.close(inputStream);
                return file;
            }
            Utils.close(inputStream);
            return null;
        }
        Utils.close(inputStream);
        return file;
    }

    private static boolean isVideoFileSupported(File file) {
        return ThumbnailUtils.createVideoThumbnail(file.getPath(), 1) != null;
    }
}
