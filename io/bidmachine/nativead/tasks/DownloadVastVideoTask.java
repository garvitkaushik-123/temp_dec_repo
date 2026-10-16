package io.bidmachine.nativead.tasks;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.iab.CacheControl;
import io.bidmachine.iab.vast.VastRequest;
import io.bidmachine.iab.vast.processor.VastAd;
import java.io.File;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
public class DownloadVastVideoTask implements Runnable {
    private static final String DIR_NAME = "native_video";
    private static final int RESULT_FAIL = 0;
    private static final int RESULT_SUCCESS = 1;
    private static final int SERVER_TIME_OUT = 20000;
    private static final String SUPPORTED_VIDEO_TYPE_REGEX = "video/.*(?i)(mp4|3gpp|mp2t|webm|matroska)";
    private File cacheDir;
    private final Handler handler = new Handler(Looper.getMainLooper()) { // from class: io.bidmachine.nativead.tasks.DownloadVastVideoTask.1
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (DownloadVastVideoTask.this.listener != null) {
                int i = msg.what;
                if (i == 0) {
                    DownloadVastVideoTask.this.listener.onVideoLoadingError(DownloadVastVideoTask.this);
                } else {
                    if (i != 1) {
                        return;
                    }
                    Pair pair = (Pair) msg.obj;
                    DownloadVastVideoTask.this.listener.onVideoLoaded(DownloadVastVideoTask.this, (Uri) pair.first, (VastRequest) pair.second);
                }
            }
        }
    };
    private boolean initialized;
    private OnLoadedListener listener;
    private String videoTag;
    private WeakReference<Context> weakContext;

    public interface OnLoadedListener {
        void onVideoLoaded(DownloadVastVideoTask task, Uri videoFileUri, VastRequest vastRequest);

        void onVideoLoadingError(DownloadVastVideoTask task);
    }

    public DownloadVastVideoTask(Context context, OnLoadedListener listener, String tag) {
        if (tag == null || !Utils.canUseExternalFilesDir()) {
            listener.onVideoLoadingError(this);
            return;
        }
        this.weakContext = new WeakReference<>(context);
        this.listener = listener;
        this.videoTag = tag;
        if (Utils.canUseExternalFilesDir()) {
            this.cacheDir = Utils.getCacheDir(context, DIR_NAME);
            this.initialized = true;
        } else {
            listener.onVideoLoadingError(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        File cacheVideoFile;
        if (!this.initialized) {
            sendFail();
            return;
        }
        Context context = this.weakContext.get();
        if (context == null) {
            sendFail();
            return;
        }
        try {
            VastRequest build = VastRequest.newBuilder().setCacheControl(CacheControl.Stream).build();
            build.loadVideoWithDataSync(context, this.videoTag, null);
            VastAd vastAd = build.getVastAd();
            if (vastAd != null && vastAd.getPickedMediaFileTag().getType().matches(SUPPORTED_VIDEO_TYPE_REGEX) && (cacheVideoFile = CacheUtils.cacheVideoFile(vastAd.getPickedMediaFileTag().getText(), this.cacheDir, 20000)) != null) {
                sendSuccess(cacheVideoFile, build);
                return;
            }
        } catch (Exception e) {
            Logger.w(e);
        }
        sendFail();
    }

    private void sendSuccess(File file, VastRequest vastRequest) {
        Handler handler = this.handler;
        if (handler != null) {
            this.handler.sendMessage(handler.obtainMessage(1, new Pair(Uri.fromFile(file), vastRequest)));
        }
    }

    private void sendFail() {
        Handler handler = this.handler;
        if (handler != null) {
            handler.sendEmptyMessage(0);
        }
    }
}
