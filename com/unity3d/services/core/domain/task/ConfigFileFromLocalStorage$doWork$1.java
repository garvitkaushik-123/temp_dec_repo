package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ConfigFileFromLocalStorage.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage", f = "ConfigFileFromLocalStorage.kt", i = {}, l = {27}, m = "doWork-gIAlu-s", n = {}, s = {})
/* loaded from: classes7.dex */
final class ConfigFileFromLocalStorage$doWork$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConfigFileFromLocalStorage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ConfigFileFromLocalStorage$doWork$1(ConfigFileFromLocalStorage configFileFromLocalStorage, Continuation<? super ConfigFileFromLocalStorage$doWork$1> continuation) {
        super(continuation);
        this.this$0 = configFileFromLocalStorage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m9274doWorkgIAlus = this.this$0.m9274doWorkgIAlus((ConfigFileFromLocalStorage.Params) null, (Continuation<? super Result<? extends Configuration>>) this);
        return m9274doWorkgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m9274doWorkgIAlus : Result.m10240boximpl(m9274doWorkgIAlus);
    }
}
