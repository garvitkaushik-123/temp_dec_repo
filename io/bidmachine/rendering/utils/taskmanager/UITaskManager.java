package io.bidmachine.rendering.utils.taskmanager;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes8.dex */
public class UITaskManager extends SingleThreadTaskManager {

    /* renamed from: a, reason: collision with root package name */
    private static final Handler f7201a = new Handler(Looper.getMainLooper());

    @Override // io.bidmachine.rendering.utils.taskmanager.SingleThreadTaskManager
    protected Handler a() {
        return f7201a;
    }
}
