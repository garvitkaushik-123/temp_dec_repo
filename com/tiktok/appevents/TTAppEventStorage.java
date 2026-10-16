package com.tiktok.appevents;

import android.app.Application;
import com.tiktok.TikTokBusinessSdk;
import com.tiktok.util.TTLogger;
import com.tiktok.util.TTUtil;
import io.ktor.http.ContentDisposition;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
class TTAppEventStorage {
    private static final String EVENT_STORAGE_FILE = "events_cache";
    private static final int MAX_PERSIST_EVENTS_NUM = 500;
    private static final String TAG = "com.tiktok.appevents.TTAppEventStorage";
    private static final TTLogger logger = new TTLogger(TTAppEventStorage.class.getCanonicalName(), TikTokBusinessSdk.getLogLevel());

    TTAppEventStorage() {
    }

    public static synchronized void persist(List<TTAppEvent> failedEvents) {
        synchronized (TTAppEventStorage.class) {
            TTUtil.checkThread(TAG);
            TTLogger tTLogger = logger;
            tTLogger.debug("Tried to persist to disk", new Object[0]);
            if (!TikTokBusinessSdk.isSystemActivated()) {
                tTLogger.debug("Quit persisting to disk because global switch is turned off", new Object[0]);
                return;
            }
            List<TTAppEvent> exportAllEvents = TTAppEventsQueue.exportAllEvents();
            TTAppEventPersist readFromDisk = readFromDisk();
            if (exportAllEvents.isEmpty() && readFromDisk.isEmpty() && (failedEvents == null || failedEvents.isEmpty())) {
                return;
            }
            TTAppEventPersist tTAppEventPersist = new TTAppEventPersist();
            if (failedEvents != null) {
                tTAppEventPersist.addEvents(failedEvents);
            }
            tTAppEventPersist.addEvents(readFromDisk.getAppEvents());
            tTAppEventPersist.addEvents(exportAllEvents);
            discardOldEvents(tTAppEventPersist, 500);
            saveToDisk(tTAppEventPersist);
        }
    }

    private static void discardOldEvents(TTAppEventPersist ttAppEventPersist, int maxPersistNum) {
        List<TTAppEvent> appEvents;
        int size;
        if (ttAppEventPersist == null || ttAppEventPersist.isEmpty() || (size = (appEvents = ttAppEventPersist.getAppEvents()).size()) <= maxPersistNum) {
            return;
        }
        logger.debug("Way too many events(%d), slim it!", Integer.valueOf(size));
        int i = size - maxPersistNum;
        TTAppEventLogger.totalDumped += i;
        TikTokBusinessSdk.diskListener.onDumped(TTAppEventLogger.totalDumped);
        ttAppEventPersist.setAppEvents(new ArrayList(appEvents.subList(i, size)));
    }

    private static boolean saveToDisk(TTAppEventPersist appEventPersist) {
        boolean z = false;
        if (appEventPersist.isEmpty()) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(TikTokBusinessSdk.getApplicationContext().openFileOutput(EVENT_STORAGE_FILE, 0)));
            try {
                objectOutputStream.writeObject(appEventPersist);
                logger.debug("Saving %d events to disk", Integer.valueOf(appEventPersist.getAppEvents().size()));
                if (TikTokBusinessSdk.diskListener != null) {
                    TikTokBusinessSdk.diskListener.onDiskChange(appEventPersist.getAppEvents().size(), false);
                }
                z = true;
                objectOutputStream.close();
            } finally {
            }
        } catch (Exception e) {
            TTCrashHandler.handleCrash(TAG, e, 2);
        }
        try {
            TikTokBusinessSdk.getAppEventLogger().monitorMetric("file_w", TTUtil.getMetaWithTS(Long.valueOf(currentTimeMillis)).put("latency", System.currentTimeMillis() - currentTimeMillis).put("success", z).put(ContentDisposition.Parameters.Size, appEventPersist.getAppEvents().size()), null);
        } catch (Exception unused) {
        }
        return z;
    }

    private static void deleteFile(File f) {
        if (f.exists()) {
            f.delete();
        }
    }

    static synchronized TTAppEventPersist readFromDisk() {
        synchronized (TTAppEventStorage.class) {
            long currentTimeMillis = System.currentTimeMillis();
            TTUtil.checkThread(TAG);
            Application applicationContext = TikTokBusinessSdk.getApplicationContext();
            File file = new File(applicationContext.getFilesDir(), EVENT_STORAGE_FILE);
            if (!file.exists()) {
                return new TTAppEventPersist();
            }
            TTAppEventPersist tTAppEventPersist = new TTAppEventPersist();
            try {
                FileInputStream openFileInput = applicationContext.openFileInput(EVENT_STORAGE_FILE);
                try {
                    tTAppEventPersist = TTSafeReadObjectUtil.safeReadTTAppEventPersist(openFileInput);
                    logger.debug("disk read data: %s", tTAppEventPersist);
                    deleteFile(file);
                    if (TikTokBusinessSdk.diskListener != null) {
                        TikTokBusinessSdk.diskListener.onDiskChange(0, true);
                    }
                    if (openFileInput != null) {
                        openFileInput.close();
                    }
                } finally {
                }
            } catch (Exception e) {
                deleteFile(file);
                TTCrashHandler.handleCrash(TAG, e, 2);
            }
            try {
                long currentTimeMillis2 = System.currentTimeMillis();
                TikTokBusinessSdk.getAppEventLogger().monitorMetric("file_r", TTUtil.getMetaWithTS(Long.valueOf(currentTimeMillis2)).put("latency", currentTimeMillis2 - currentTimeMillis).put(ContentDisposition.Parameters.Size, tTAppEventPersist.getAppEvents().size()), null);
            } catch (Exception unused) {
            }
            return tTAppEventPersist;
        }
    }

    public static synchronized void clearAll() {
        synchronized (TTAppEventStorage.class) {
            TTUtil.checkThread(TAG);
            deleteFile(new File(TikTokBusinessSdk.getApplicationContext().getFilesDir(), EVENT_STORAGE_FILE));
            if (TikTokBusinessSdk.diskListener != null) {
                TikTokBusinessSdk.diskListener.onDiskChange(0, true);
            }
        }
    }
}
