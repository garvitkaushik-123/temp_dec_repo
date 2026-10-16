package io.bidmachine.util.taskmanager.coroutine;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: UITaskManager.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/bidmachine/util/taskmanager/coroutine/UITaskManager;", "Lio/bidmachine/util/taskmanager/coroutine/CoroutineTaskManager;", "()V", "bidmachine-android-sdk_ca_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class UITaskManager extends CoroutineTaskManager {
    public UITaskManager() {
        super(new CoroutineName("UITaskManager").plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(Dispatchers.getMain().getImmediate()));
    }
}
