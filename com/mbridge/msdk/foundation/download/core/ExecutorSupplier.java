package com.mbridge.msdk.foundation.download.core;

import java.util.concurrent.ExecutorService;

/* loaded from: classes6.dex */
public interface ExecutorSupplier {
    ExecutorService getBackgroundTasks();

    ExecutorService getDownloadResultTasks();

    DownloadExecutor getDownloadTasks();

    ExecutorService getLruCacheThreadTasks();
}
