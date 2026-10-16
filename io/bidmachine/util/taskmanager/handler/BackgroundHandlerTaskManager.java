package io.bidmachine.util.taskmanager.handler;

import android.os.Handler;
import android.os.HandlerThread;
import kotlin.Metadata;

/* compiled from: BackgroundHandlerTaskManager.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/bidmachine/util/taskmanager/handler/BackgroundHandlerTaskManager;", "Lio/bidmachine/util/taskmanager/handler/HandlerTaskManager;", "()V", "bidmachine-android-sdk_ca_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class BackgroundHandlerTaskManager extends HandlerTaskManager {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BackgroundHandlerTaskManager() {
        super(new Handler(r0.getLooper()));
        HandlerThread handlerThread = new HandlerThread("BackgroundHandlerTaskManager");
        handlerThread.start();
    }
}
