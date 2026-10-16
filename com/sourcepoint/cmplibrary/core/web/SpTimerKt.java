package com.sourcepoint.cmplibrary.core.web;

import com.sourcepoint.cmplibrary.core.ExecutorManager;
import com.sourcepoint.cmplibrary.core.web.SpTimer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SpTimer.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"create", "Lcom/sourcepoint/cmplibrary/core/web/SpTimer;", "Lcom/sourcepoint/cmplibrary/core/web/SpTimer$Companion;", "executorManager", "Lcom/sourcepoint/cmplibrary/core/ExecutorManager;", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SpTimerKt {
    public static final SpTimer create(SpTimer.Companion companion, ExecutorManager executorManager) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(executorManager, "executorManager");
        return new SpTimerImpl(executorManager);
    }
}
