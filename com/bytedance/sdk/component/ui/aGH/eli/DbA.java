package com.bytedance.sdk.component.ui.aGH.eli;

import io.bidmachine.rendering.model.EventTaskParams;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class DbA {
    private static final TimeUnit eli = TimeUnit.SECONDS;

    public static ExecutorService eli() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 30L, eli, new LinkedBlockingQueue(), new eli(EventTaskParams.STATE_GROUP_DEFAULT));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }
}
