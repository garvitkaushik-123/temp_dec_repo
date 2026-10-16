package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage;
import com.unity3d.services.core.properties.SdkProperties;
import java.io.File;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* compiled from: ConfigFileFromLocalStorage.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/unity3d/services/core/configuration/Configuration;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage$doWork$2", f = "ConfigFileFromLocalStorage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class ConfigFileFromLocalStorage$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Configuration>>, Object> {
    final /* synthetic */ ConfigFileFromLocalStorage.Params $params;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ConfigFileFromLocalStorage$doWork$2(ConfigFileFromLocalStorage.Params params, Continuation<? super ConfigFileFromLocalStorage$doWork$2> continuation) {
        super(2, continuation);
        this.$params = params;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConfigFileFromLocalStorage$doWork$2(this.$params, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Configuration>> continuation) {
        return ((ConfigFileFromLocalStorage$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m10241constructorimpl;
        Configuration configuration;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ConfigFileFromLocalStorage.Params params = this.$params;
        try {
            Result.Companion companion = Result.INSTANCE;
            File file = new File(SdkProperties.getLocalConfigurationFilepath());
            if (!file.exists()) {
                configuration = params.getDefaultConfiguration();
            } else {
                configuration = new Configuration(new JSONObject(FilesKt.readText$default(file, null, 1, null)));
            }
            m10241constructorimpl = Result.m10241constructorimpl(configuration);
        } catch (CancellationException e) {
            throw e;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m10248isSuccessimpl(m10241constructorimpl)) {
            Result.Companion companion3 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(m10241constructorimpl);
        } else {
            Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
            if (m10244exceptionOrNullimpl != null) {
                Result.Companion companion4 = Result.INSTANCE;
                m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(m10244exceptionOrNullimpl));
            }
        }
        return Result.m10240boximpl(m10241constructorimpl);
    }
}
