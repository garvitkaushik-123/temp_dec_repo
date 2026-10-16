package io.bidmachine.nativead.tasks;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import io.bidmachine.core.Utils;
import java.io.File;

/* loaded from: classes6.dex */
public class DownloadVideoTask implements Runnable {
    private static final String DIR_NAME = "native_video";
    private static final int RESULT_FAIL = 0;
    private static final int RESULT_SUCCESS = 1;
    private static final int SERVER_TIME_OUT = 20000;
    private File cacheDir;
    private final Handler handler = new Handler(Looper.getMainLooper()) { // from class: io.bidmachine.nativead.tasks.DownloadVideoTask.1
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (DownloadVideoTask.this.listener != null) {
                int i = msg.what;
                if (i == 0) {
                    DownloadVideoTask.this.listener.onVideoLoadingError(DownloadVideoTask.this);
                } else {
                    if (i != 1) {
                        return;
                    }
                    DownloadVideoTask.this.listener.onVideoLoaded(DownloadVideoTask.this, (Uri) msg.obj);
                }
            }
        }
    };
    private boolean initialized;
    private OnLoadedListener listener;
    private String videoUrl;

    public interface OnLoadedListener {
        void onVideoLoaded(DownloadVideoTask task, Uri videoFileUri);

        void onVideoLoadingError(DownloadVideoTask task);
    }

    public DownloadVideoTask(Context context, OnLoadedListener listener, String url) {
        if (url == null || !Utils.canUseExternalFilesDir()) {
            listener.onVideoLoadingError(this);
            return;
        }
        this.listener = listener;
        this.videoUrl = url;
        if (Utils.canUseExternalFilesDir()) {
            this.cacheDir = Utils.getCacheDir(context, DIR_NAME);
            this.initialized = true;
        } else {
            listener.onVideoLoadingError(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.initialized) {
            sendFail();
            return;
        }
        File cacheVideoFile = CacheUtils.cacheVideoFile(this.videoUrl, this.cacheDir, 20000);
        if (cacheVideoFile != null) {
            sendSuccess(cacheVideoFile);
        } else {
            sendFail();
        }
    }

    private void sendSuccess(File file) {
        Handler handler = this.handler;
        if (handler != null) {
            this.handler.sendMessage(handler.obtainMessage(1, Uri.fromFile(file)));
        }
    }

    private void sendFail() {
        Handler handler = this.handler;
        if (handler != null) {
            handler.sendEmptyMessage(0);
        }
    }
}
