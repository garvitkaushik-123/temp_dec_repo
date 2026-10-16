package com.tiktok.appevents;

import com.tiktok.TikTokBusinessSdk;
import com.tiktok.util.TTUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
class TTAppEventsQueue {
    private static String TAG = "com.tiktok.appevents.TTAppEventsQueue";
    private static List<TTAppEvent> memory = new ArrayList();

    private TTAppEventsQueue() {
    }

    private static void notifyChange() {
        if (TikTokBusinessSdk.memoryListener != null) {
            TikTokBusinessSdk.memoryListener.onMemoryChange(memory.size());
        }
        if (TikTokBusinessSdk.nextTimeFlushListener != null) {
            TikTokBusinessSdk.nextTimeFlushListener.thresholdLeft(100, Math.max(100 - size(), 0));
        }
    }

    public static synchronized void addEvent(TTAppEvent event) {
        synchronized (TTAppEventsQueue.class) {
            TTUtil.checkThread(TAG);
            memory.add(event);
            notifyChange();
        }
    }

    public static synchronized int size() {
        int size;
        synchronized (TTAppEventsQueue.class) {
            size = memory.size();
        }
        return size;
    }

    public static synchronized void clearAll() {
        synchronized (TTAppEventsQueue.class) {
            TTUtil.checkThread(TAG);
            memory = new ArrayList();
            notifyChange();
        }
    }

    public static synchronized List<TTAppEvent> exportAllEvents() {
        List<TTAppEvent> list;
        synchronized (TTAppEventsQueue.class) {
            list = memory;
            memory = new ArrayList();
            notifyChange();
        }
        return list;
    }
}
