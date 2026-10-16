package com.mbridge.msdk.playercommon.exoplayer2.offline;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadManager;
import com.mbridge.msdk.playercommon.exoplayer2.scheduler.Requirements;
import com.mbridge.msdk.playercommon.exoplayer2.scheduler.RequirementsWatcher;
import com.mbridge.msdk.playercommon.exoplayer2.scheduler.Scheduler;
import com.mbridge.msdk.playercommon.exoplayer2.util.NotificationUtil;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.IOException;
import java.util.HashMap;

/* loaded from: classes6.dex */
public abstract class DownloadService extends Service {
    public static final String ACTION_ADD = "com.google.android.exoplayer.downloadService.action.ADD";
    public static final String ACTION_INIT = "com.google.android.exoplayer.downloadService.action.INIT";
    private static final String ACTION_RESTART = "com.google.android.exoplayer.downloadService.action.RESTART";
    private static final String ACTION_START_DOWNLOADS = "com.google.android.exoplayer.downloadService.action.START_DOWNLOADS";
    private static final String ACTION_STOP_DOWNLOADS = "com.google.android.exoplayer.downloadService.action.STOP_DOWNLOADS";
    private static final boolean DEBUG = false;
    public static final long DEFAULT_FOREGROUND_NOTIFICATION_UPDATE_INTERVAL = 1000;
    public static final String KEY_DOWNLOAD_ACTION = "download_action";
    public static final String KEY_FOREGROUND = "foreground";
    private static final String TAG = "DownloadService";
    private static final HashMap<Class<? extends DownloadService>, RequirementsHelper> requirementsHelpers = new HashMap<>();
    private final String channelId;
    private final int channelName;
    private DownloadManager downloadManager;
    private DownloadManagerListener downloadManagerListener;
    private final ForegroundNotificationUpdater foregroundNotificationUpdater;
    private int lastStartId;
    private boolean startedInForeground;
    private boolean taskRemoved;

    private final class DownloadManagerListener implements DownloadManager.Listener {
        private DownloadManagerListener() {
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadManager.Listener
        public final void onIdle(DownloadManager downloadManager) {
            DownloadService.this.stop();
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadManager.Listener
        public void onInitialized(DownloadManager downloadManager) {
            DownloadService.this.maybeStartWatchingRequirements();
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadManager.Listener
        public void onTaskStateChanged(DownloadManager downloadManager, DownloadManager.TaskState taskState) {
            DownloadService.this.onTaskStateChanged(taskState);
            if (taskState.state == 1) {
                DownloadService.this.foregroundNotificationUpdater.startPeriodicUpdates();
            } else {
                DownloadService.this.foregroundNotificationUpdater.update();
            }
        }
    }

    private final class ForegroundNotificationUpdater implements Runnable {
        private final Handler handler = new Handler(Looper.getMainLooper());
        private boolean notificationDisplayed;
        private final int notificationId;
        private boolean periodicUpdatesStarted;
        private final long updateInterval;

        public ForegroundNotificationUpdater(int i, long j) {
            this.notificationId = i;
            this.updateInterval = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            update();
        }

        public void showNotificationIfNotAlready() {
            if (this.notificationDisplayed) {
                return;
            }
            update();
        }

        public void startPeriodicUpdates() {
            this.periodicUpdatesStarted = true;
            update();
        }

        public void stopPeriodicUpdates() {
            this.periodicUpdatesStarted = false;
            this.handler.removeCallbacks(this);
        }

        public void update() {
            DownloadManager.TaskState[] allTaskStates = DownloadService.this.downloadManager.getAllTaskStates();
            DownloadService downloadService = DownloadService.this;
            downloadService.startForeground(this.notificationId, downloadService.getForegroundNotification(allTaskStates));
            this.notificationDisplayed = true;
            if (this.periodicUpdatesStarted) {
                this.handler.removeCallbacks(this);
                this.handler.postDelayed(this, this.updateInterval);
            }
        }
    }

    private static final class RequirementsHelper implements RequirementsWatcher.Listener {
        private final Context context;
        private final Requirements requirements;
        private final RequirementsWatcher requirementsWatcher;
        private final Scheduler scheduler;
        private final Class<? extends DownloadService> serviceClass;

        private void startServiceWithAction(String str) {
            Util.startForegroundService(this.context, new Intent(this.context, this.serviceClass).setAction(str).putExtra("foreground", true));
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.scheduler.RequirementsWatcher.Listener
        public void requirementsMet(RequirementsWatcher requirementsWatcher) {
            startServiceWithAction(DownloadService.ACTION_START_DOWNLOADS);
            Scheduler scheduler = this.scheduler;
            if (scheduler != null) {
                scheduler.cancel();
            }
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.scheduler.RequirementsWatcher.Listener
        public void requirementsNotMet(RequirementsWatcher requirementsWatcher) {
            startServiceWithAction(DownloadService.ACTION_STOP_DOWNLOADS);
            if (this.scheduler != null) {
                String h = c.m().h();
                if (TextUtils.isEmpty(h)) {
                    h = this.context.getPackageName();
                }
                if (this.scheduler.schedule(this.requirements, h, DownloadService.ACTION_RESTART)) {
                    return;
                }
                Log.e(DownloadService.TAG, "Scheduling downloads failed.");
            }
        }

        public void start() {
            this.requirementsWatcher.start();
        }

        public void stop() {
            this.requirementsWatcher.stop();
            Scheduler scheduler = this.scheduler;
            if (scheduler != null) {
                scheduler.cancel();
            }
        }

        private RequirementsHelper(Context context, Requirements requirements, Scheduler scheduler, Class<? extends DownloadService> cls) {
            this.context = context;
            this.requirements = requirements;
            this.scheduler = scheduler;
            this.serviceClass = cls;
            this.requirementsWatcher = new RequirementsWatcher(context, this, requirements);
        }
    }

    protected DownloadService(int i) {
        this(i, 1000L);
    }

    public static Intent buildAddActionIntent(Context context, Class<? extends DownloadService> cls, DownloadAction downloadAction, boolean z) {
        return new Intent(context, cls).setAction(ACTION_ADD).putExtra(KEY_DOWNLOAD_ACTION, downloadAction.toByteArray()).putExtra("foreground", z);
    }

    private void logd(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void maybeStartWatchingRequirements() {
        if (this.downloadManager.getDownloadCount() != 0) {
            Class<?> cls = getClass();
            HashMap<Class<? extends DownloadService>, RequirementsHelper> hashMap = requirementsHelpers;
            if (((RequirementsHelper) hashMap.get(cls)) == null) {
                RequirementsHelper requirementsHelper = new RequirementsHelper(this, getRequirements(), getScheduler(), cls);
                hashMap.put(cls, requirementsHelper);
                requirementsHelper.start();
                logd("started watching requirements");
            }
        }
    }

    private void maybeStopWatchingRequirements() {
        RequirementsHelper remove;
        if (this.downloadManager.getDownloadCount() <= 0 && (remove = requirementsHelpers.remove(getClass())) != null) {
            remove.stop();
            logd("stopped watching requirements");
        }
    }

    public static void start(Context context, Class<? extends DownloadService> cls) {
        context.startService(new Intent(context, cls).setAction("com.google.android.exoplayer.downloadService.action.INIT"));
    }

    public static void startForeground(Context context, Class<? extends DownloadService> cls) {
        Util.startForegroundService(context, new Intent(context, cls).setAction("com.google.android.exoplayer.downloadService.action.INIT").putExtra("foreground", true));
    }

    public static void startWithAction(Context context, Class<? extends DownloadService> cls, DownloadAction downloadAction, boolean z) {
        Intent buildAddActionIntent = buildAddActionIntent(context, cls, downloadAction, z);
        if (z) {
            Util.startForegroundService(context, buildAddActionIntent);
        } else {
            context.startService(buildAddActionIntent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        this.foregroundNotificationUpdater.stopPeriodicUpdates();
        if (this.startedInForeground && Util.SDK_INT >= 26) {
            this.foregroundNotificationUpdater.showNotificationIfNotAlready();
        }
        if (Util.SDK_INT >= 28 || !this.taskRemoved) {
            logd("stopSelf(" + this.lastStartId + ") result: " + stopSelfResult(this.lastStartId));
        } else {
            stopSelf();
            logd("stopSelf()");
        }
    }

    protected abstract DownloadManager getDownloadManager();

    protected abstract Notification getForegroundNotification(DownloadManager.TaskState[] taskStateArr);

    protected Requirements getRequirements() {
        return new Requirements(1, false, false);
    }

    protected abstract Scheduler getScheduler();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        logd("onCreate");
        String str = this.channelId;
        if (str != null) {
            NotificationUtil.createNotificationChannel(this, str, this.channelName, 2);
        }
        this.downloadManager = getDownloadManager();
        DownloadManagerListener downloadManagerListener = new DownloadManagerListener();
        this.downloadManagerListener = downloadManagerListener;
        this.downloadManager.addListener(downloadManagerListener);
    }

    @Override // android.app.Service
    public void onDestroy() {
        logd("onDestroy");
        this.foregroundNotificationUpdater.stopPeriodicUpdates();
        this.downloadManager.removeListener(this.downloadManagerListener);
        maybeStopWatchingRequirements();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0083, code lost:
    
        if (r2.equals(com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadService.ACTION_RESTART) == false) goto L18;
     */
    @Override // android.app.Service
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int onStartCommand(Intent intent, int i, int i2) {
        String str;
        this.lastStartId = i2;
        char c = 0;
        this.taskRemoved = false;
        if (intent != null) {
            str = intent.getAction();
            this.startedInForeground |= intent.getBooleanExtra("foreground", false) || ACTION_RESTART.equals(str);
        } else {
            str = null;
        }
        if (str == null) {
            str = "com.google.android.exoplayer.downloadService.action.INIT";
        }
        logd("onStartCommand action: " + str + " startId: " + i2);
        str.hashCode();
        switch (str.hashCode()) {
            case -871181424:
                break;
            case -382886238:
                if (str.equals(ACTION_ADD)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -337334865:
                if (str.equals(ACTION_START_DOWNLOADS)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1015676687:
                if (str.equals("com.google.android.exoplayer.downloadService.action.INIT")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1286088717:
                if (str.equals(ACTION_STOP_DOWNLOADS)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
            case 3:
                break;
            case 1:
                byte[] byteArrayExtra = intent.getByteArrayExtra(KEY_DOWNLOAD_ACTION);
                if (byteArrayExtra != null) {
                    try {
                        this.downloadManager.handleAction(byteArrayExtra);
                        break;
                    } catch (IOException e) {
                        Log.e(TAG, "Failed to handle ADD action", e);
                        break;
                    }
                } else {
                    Log.e(TAG, "Ignoring ADD action with no action data");
                    break;
                }
            case 2:
                this.downloadManager.startDownloads();
                break;
            case 4:
                this.downloadManager.stopDownloads();
                break;
            default:
                Log.e(TAG, "Ignoring unrecognized action: " + str);
                break;
        }
        maybeStartWatchingRequirements();
        if (this.downloadManager.isIdle()) {
            stop();
        }
        return 1;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        logd("onTaskRemoved rootIntent: " + intent);
        this.taskRemoved = true;
    }

    protected void onTaskStateChanged(DownloadManager.TaskState taskState) {
    }

    protected DownloadService(int i, long j) {
        this(i, j, null, 0);
    }

    protected DownloadService(int i, long j, String str, int i2) {
        this.foregroundNotificationUpdater = new ForegroundNotificationUpdater(i, j);
        this.channelId = str;
        this.channelName = i2;
    }
}
