package com.unity3d.services.core.fid;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.ironsource.C3207n2;
import com.unity3d.services.core.reflection.GenericBridge;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FIdBridge.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006J\b\u0010\b\u001a\u00020\u0007H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/unity3d/services/core/fid/FIdBridge;", "Lcom/unity3d/services/core/reflection/GenericBridge;", C3207n2.p, "", "(Ljava/lang/Object;)V", Constants.GET_APP_INSTANCE_ID, "Lcom/google/android/gms/tasks/Task;", "", "getClassName", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class FIdBridge extends GenericBridge {
    private final Object instance;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FIdBridge(Object instance) {
        super(MapsKt.mapOf(new Pair(Constants.GET_APP_INSTANCE_ID, new Class[0])), false);
        Intrinsics.checkNotNullParameter(instance, "instance");
        this.instance = instance;
    }

    @Override // com.unity3d.services.core.reflection.GenericBridge
    protected String getClassName() {
        return Constants.INSTANCE.getClassName();
    }

    public final Task<String> getAppInstanceId() {
        Task<String> task = (Task) callNonVoidMethod(Constants.GET_APP_INSTANCE_ID, this.instance, new Object[0]);
        if (task != null) {
            return task;
        }
        Task<String> forResult = Tasks.forResult(null);
        Intrinsics.checkNotNullExpressionValue(forResult, "forResult(null)");
        return forResult;
    }
}
