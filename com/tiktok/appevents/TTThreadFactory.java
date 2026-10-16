package com.tiktok.appevents;

import com.tiktok.TikTokBusinessSdk;
import java.lang.Thread;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes6.dex */
public class TTThreadFactory implements ThreadFactory {
    static final String TAG = TTInAppPurchaseManager.class.getCanonicalName();

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.tiktok.appevents.TTThreadFactory.1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread2, Throwable throwable) {
                TTCrashHandler.handleCrash(TTThreadFactory.TAG, throwable, 3);
                if (TikTokBusinessSdk.getCrashListener() != null) {
                    TikTokBusinessSdk.getCrashListener().onCrash(thread2, throwable);
                }
            }
        });
        return thread;
    }
}
