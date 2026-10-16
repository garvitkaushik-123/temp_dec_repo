package io.bidmachine.nativead.tasks;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.nativead.utils.ImageHelper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes6.dex */
public class DownloadImageTask implements Runnable {
    private static final String DIR_NAME = "native_cache_image";
    private static final int RESULT_FAIL = 0;
    private static final int RESULT_IMAGE_SUCCESS = 2;
    private static final int RESULT_PATH_SUCCESS = 1;
    private static final int SERVER_TIME_OUT = 20000;
    private File cacheDir;
    private Context context;
    private final Handler handler = new Handler(Looper.getMainLooper()) { // from class: io.bidmachine.nativead.tasks.DownloadImageTask.1
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (DownloadImageTask.this.listener != null) {
                int i = msg.what;
                if (i == 0) {
                    DownloadImageTask.this.listener.onFail(DownloadImageTask.this);
                } else if (i == 1) {
                    DownloadImageTask.this.listener.onPathSuccess(DownloadImageTask.this, (Uri) msg.obj);
                } else {
                    if (i != 2) {
                        return;
                    }
                    DownloadImageTask.this.listener.onImageSuccess(DownloadImageTask.this, (Bitmap) msg.obj);
                }
            }
        }
    };
    private OnCacheImageListener listener;
    private String url;

    public interface OnCacheImageListener {
        void onFail(DownloadImageTask task);

        void onImageSuccess(DownloadImageTask task, Bitmap imageBitmap);

        void onPathSuccess(DownloadImageTask task, Uri imagePath);
    }

    public static Builder newBuilder(Context context, String url) {
        return new DownloadImageTask().new Builder(context, url);
    }

    public class Builder {
        public Builder(Context context, String url) {
            DownloadImageTask.this.context = context;
            DownloadImageTask.this.url = url;
        }

        public Builder setOnCacheImageListener(OnCacheImageListener listener) {
            DownloadImageTask.this.listener = listener;
            return this;
        }

        public DownloadImageTask build() {
            try {
                DownloadImageTask downloadImageTask = DownloadImageTask.this;
                if (downloadImageTask.context == null) {
                    if (DownloadImageTask.this.listener != null) {
                        DownloadImageTask.this.listener.onFail(DownloadImageTask.this);
                        return downloadImageTask;
                    }
                } else if (Utils.canUseExternalFilesDir()) {
                    DownloadImageTask downloadImageTask2 = DownloadImageTask.this;
                    downloadImageTask2.cacheDir = Utils.getCacheDir(downloadImageTask2.context, DownloadImageTask.DIR_NAME);
                }
                return downloadImageTask;
            } catch (Throwable th) {
                if (DownloadImageTask.this.context == null) {
                    if (DownloadImageTask.this.listener != null) {
                        DownloadImageTask.this.listener.onFail(DownloadImageTask.this);
                    }
                } else if (Utils.canUseExternalFilesDir()) {
                    DownloadImageTask downloadImageTask3 = DownloadImageTask.this;
                    downloadImageTask3.cacheDir = Utils.getCacheDir(downloadImageTask3.context, DownloadImageTask.DIR_NAME);
                }
                throw th;
            }
        }
    }

    private DownloadImageTask() {
    }

    @Override // java.lang.Runnable
    public void run() {
        if (TextUtils.isEmpty(this.url) || !Utils.isHttpUrl(this.url)) {
            sendFail();
            return;
        }
        String replace = this.url.replace(" ", "%20");
        this.url = replace;
        downloadImage(this.context, replace);
    }

    private void sendPathSuccess(Uri uri) {
        Handler handler = this.handler;
        if (handler != null) {
            this.handler.sendMessage(handler.obtainMessage(1, uri));
        }
    }

    private void sendImageSuccess(Bitmap image) {
        Handler handler = this.handler;
        if (handler != null) {
            this.handler.sendMessage(handler.obtainMessage(2, image));
        }
    }

    private void sendFail() {
        Handler handler = this.handler;
        if (handler != null) {
            handler.sendEmptyMessage(0);
        }
    }

    private void downloadImage(Context context, String url) {
        File file;
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inJustDecodeBounds = true;
        InputStream inputStream2 = null;
        if (this.cacheDir != null) {
            file = new File(this.cacheDir, Utils.generateFileName(url));
            if (file.exists() && file.length() > 0) {
                sendPathSuccess(Uri.fromFile(file));
                return;
            }
        } else {
            file = null;
        }
        try {
            inputStream = ConnectionUtils.getInputStream(url, 20000);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(inputStream.available());
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
        }
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                } else {
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
            if (file != null) {
                saveImage(file, byteArray, options);
                sendPathSuccess(Uri.fromFile(file));
            } else {
                int calculateReqWidth = ImageHelper.calculateReqWidth(context);
                options.inSampleSize = ImageHelper.calculateInSamplesSize(options, calculateReqWidth, ImageHelper.calculateReqHeight(calculateReqWidth));
                Bitmap convert = convert(byteArray, options);
                if (convert != null) {
                    sendImageSuccess(convert);
                } else {
                    sendFail();
                }
            }
            Utils.flush(byteArrayOutputStream);
            Utils.close(byteArrayOutputStream);
            Utils.close(inputStream);
        } catch (Throwable th3) {
            th = th3;
            inputStream2 = inputStream;
            try {
                Logger.w(th);
                sendFail();
            } finally {
                Utils.flush(byteArrayOutputStream);
                Utils.close(byteArrayOutputStream);
                Utils.close(inputStream2);
            }
        }
    }

    private void saveImage(File file, byte[] byteImage, BitmapFactory.Options options) {
        FileOutputStream fileOutputStream;
        options.inJustDecodeBounds = false;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            writeBitmap(byteImage, options, fileOutputStream);
            Utils.flush(fileOutputStream);
            Utils.close(fileOutputStream);
        } catch (Exception e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            Logger.w(e);
            Utils.flush(fileOutputStream2);
            Utils.close(fileOutputStream2);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            Utils.flush(fileOutputStream2);
            Utils.close(fileOutputStream2);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0032: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:16:0x0032 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.Closeable, java.io.Flushable] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r3v0, types: [io.bidmachine.nativead.tasks.DownloadImageTask] */
    private Bitmap convert(byte[] byteImage, BitmapFactory.Options options) {
        ByteArrayOutputStream byteArrayOutputStream;
        Object obj;
        options.inJustDecodeBounds = false;
        ?? r0 = 0;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(byteImage.length);
                try {
                    writeBitmap(byteImage, options, byteArrayOutputStream);
                    Bitmap decodeStream = BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
                    Utils.flush(byteArrayOutputStream);
                    Utils.close(byteArrayOutputStream);
                    return decodeStream;
                } catch (Exception e) {
                    e = e;
                    Logger.w(e);
                    Utils.flush(byteArrayOutputStream);
                    Utils.close(byteArrayOutputStream);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                r0 = obj;
                Utils.flush(r0);
                Utils.close(r0);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            byteArrayOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            Utils.flush(r0);
            Utils.close(r0);
            throw th;
        }
    }

    private void writeBitmap(byte[] byteImage, BitmapFactory.Options options, OutputStream outputStream) {
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteImage, 0, byteImage.length, options);
        decodeByteArray.compress(Bitmap.CompressFormat.PNG, 85, outputStream);
        decodeByteArray.recycle();
    }
}
