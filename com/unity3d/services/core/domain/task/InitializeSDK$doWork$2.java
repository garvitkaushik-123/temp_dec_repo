package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.ErrorState;
import com.unity3d.services.core.configuration.InitializeEventsMetricSender;
import com.unity3d.services.core.device.Device;
import com.unity3d.services.core.domain.ResultExtensionsKt;
import com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage;
import com.unity3d.services.core.domain.task.InitializeStateComplete;
import com.unity3d.services.core.domain.task.InitializeStateConfig;
import com.unity3d.services.core.domain.task.InitializeStateCreate;
import com.unity3d.services.core.domain.task.InitializeStateLoadCache;
import com.unity3d.services.core.domain.task.InitializeStateLoadWeb;
import com.unity3d.services.core.domain.task.InitializeStateReset;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.properties.SdkProperties;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: InitializeSDK.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeSDK$doWork$2", f = "InitializeSDK.kt", i = {0, 1, 2, 2, 3, 4, 4, 5, 5, 5, 6, 6, 6, 7, 8, 9, 9, 10, 11}, l = {48, 53, 58, 60, 65, 67, 71, 74, 89, 92, 100, 103, 106}, m = "invokeSuspend", n = {"$this$withContext", "$this$withContext", "$this$withContext", "configuration", "resetResult", "$this$withContext", "configuration", "$this$withContext", "configuration", "configResult", "$this$withContext", "configuration", "configResult", "loadCacheResult", "configResult", "configResult", "loadWebResult", "configResult", "configResult"}, s = {"L$0", "L$0", "L$0", "L$2", "L$0", "L$0", "L$2", "L$0", "L$2", "L$3", "L$0", "L$2", "L$3", "L$0", "L$1", "L$1", "L$2", "L$1", "L$1"})
/* loaded from: classes7.dex */
final class InitializeSDK$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ InitializeSDK this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeSDK$doWork$2(InitializeSDK initializeSDK, Continuation<? super InitializeSDK$doWork$2> continuation) {
        super(2, continuation);
        this.this$0 = initializeSDK;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InitializeSDK$doWork$2 initializeSDK$doWork$2 = new InitializeSDK$doWork$2(this.this$0, continuation);
        initializeSDK$doWork$2.L$0 = obj;
        return initializeSDK$doWork$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Result<Unit>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit>> continuation) {
        return ((InitializeSDK$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0374, code lost:
    
        if (r14 == r2) goto L128;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01f8 A[Catch: all -> 0x038d, CancellationException -> 0x03bb, TryCatch #2 {CancellationException -> 0x03bb, all -> 0x038d, blocks: (B:7:0x0017, B:8:0x0377, B:18:0x0028, B:19:0x0358, B:23:0x0033, B:24:0x033f, B:26:0x0345, B:30:0x0046, B:31:0x0306, B:32:0x0317, B:37:0x0051, B:39:0x02ea, B:41:0x02f0, B:45:0x0061, B:46:0x0278, B:48:0x027e, B:49:0x028b, B:52:0x0079, B:54:0x0258, B:56:0x025e, B:59:0x028c, B:61:0x0297, B:63:0x02a1, B:65:0x02a7, B:66:0x02c4, B:70:0x0311, B:72:0x0381, B:73:0x038c, B:75:0x0096, B:76:0x0234, B:80:0x00a7, B:82:0x0217, B:84:0x021d, B:88:0x00b8, B:89:0x01e4, B:91:0x01ea, B:92:0x01f7, B:95:0x00ce, B:97:0x01c7, B:99:0x01cd, B:102:0x01f8, B:107:0x00e4, B:108:0x0180, B:110:0x0186, B:111:0x019a, B:114:0x01a6, B:119:0x00f7, B:120:0x015b, B:121:0x015e, B:126:0x0105, B:128:0x0122, B:130:0x0128), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0186 A[Catch: all -> 0x038d, CancellationException -> 0x03bb, TryCatch #2 {CancellationException -> 0x03bb, all -> 0x038d, blocks: (B:7:0x0017, B:8:0x0377, B:18:0x0028, B:19:0x0358, B:23:0x0033, B:24:0x033f, B:26:0x0345, B:30:0x0046, B:31:0x0306, B:32:0x0317, B:37:0x0051, B:39:0x02ea, B:41:0x02f0, B:45:0x0061, B:46:0x0278, B:48:0x027e, B:49:0x028b, B:52:0x0079, B:54:0x0258, B:56:0x025e, B:59:0x028c, B:61:0x0297, B:63:0x02a1, B:65:0x02a7, B:66:0x02c4, B:70:0x0311, B:72:0x0381, B:73:0x038c, B:75:0x0096, B:76:0x0234, B:80:0x00a7, B:82:0x0217, B:84:0x021d, B:88:0x00b8, B:89:0x01e4, B:91:0x01ea, B:92:0x01f7, B:95:0x00ce, B:97:0x01c7, B:99:0x01cd, B:102:0x01f8, B:107:0x00e4, B:108:0x0180, B:110:0x0186, B:111:0x019a, B:114:0x01a6, B:119:0x00f7, B:120:0x015b, B:121:0x015e, B:126:0x0105, B:128:0x0122, B:130:0x0128), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0345 A[Catch: all -> 0x038d, CancellationException -> 0x03bb, TryCatch #2 {CancellationException -> 0x03bb, all -> 0x038d, blocks: (B:7:0x0017, B:8:0x0377, B:18:0x0028, B:19:0x0358, B:23:0x0033, B:24:0x033f, B:26:0x0345, B:30:0x0046, B:31:0x0306, B:32:0x0317, B:37:0x0051, B:39:0x02ea, B:41:0x02f0, B:45:0x0061, B:46:0x0278, B:48:0x027e, B:49:0x028b, B:52:0x0079, B:54:0x0258, B:56:0x025e, B:59:0x028c, B:61:0x0297, B:63:0x02a1, B:65:0x02a7, B:66:0x02c4, B:70:0x0311, B:72:0x0381, B:73:0x038c, B:75:0x0096, B:76:0x0234, B:80:0x00a7, B:82:0x0217, B:84:0x021d, B:88:0x00b8, B:89:0x01e4, B:91:0x01ea, B:92:0x01f7, B:95:0x00ce, B:97:0x01c7, B:99:0x01cd, B:102:0x01f8, B:107:0x00e4, B:108:0x0180, B:110:0x0186, B:111:0x019a, B:114:0x01a6, B:119:0x00f7, B:120:0x015b, B:121:0x015e, B:126:0x0105, B:128:0x0122, B:130:0x0128), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x02f0 A[Catch: all -> 0x038d, CancellationException -> 0x03bb, TryCatch #2 {CancellationException -> 0x03bb, all -> 0x038d, blocks: (B:7:0x0017, B:8:0x0377, B:18:0x0028, B:19:0x0358, B:23:0x0033, B:24:0x033f, B:26:0x0345, B:30:0x0046, B:31:0x0306, B:32:0x0317, B:37:0x0051, B:39:0x02ea, B:41:0x02f0, B:45:0x0061, B:46:0x0278, B:48:0x027e, B:49:0x028b, B:52:0x0079, B:54:0x0258, B:56:0x025e, B:59:0x028c, B:61:0x0297, B:63:0x02a1, B:65:0x02a7, B:66:0x02c4, B:70:0x0311, B:72:0x0381, B:73:0x038c, B:75:0x0096, B:76:0x0234, B:80:0x00a7, B:82:0x0217, B:84:0x021d, B:88:0x00b8, B:89:0x01e4, B:91:0x01ea, B:92:0x01f7, B:95:0x00ce, B:97:0x01c7, B:99:0x01cd, B:102:0x01f8, B:107:0x00e4, B:108:0x0180, B:110:0x0186, B:111:0x019a, B:114:0x01a6, B:119:0x00f7, B:120:0x015b, B:121:0x015e, B:126:0x0105, B:128:0x0122, B:130:0x0128), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x027e A[Catch: all -> 0x038d, CancellationException -> 0x03bb, TryCatch #2 {CancellationException -> 0x03bb, all -> 0x038d, blocks: (B:7:0x0017, B:8:0x0377, B:18:0x0028, B:19:0x0358, B:23:0x0033, B:24:0x033f, B:26:0x0345, B:30:0x0046, B:31:0x0306, B:32:0x0317, B:37:0x0051, B:39:0x02ea, B:41:0x02f0, B:45:0x0061, B:46:0x0278, B:48:0x027e, B:49:0x028b, B:52:0x0079, B:54:0x0258, B:56:0x025e, B:59:0x028c, B:61:0x0297, B:63:0x02a1, B:65:0x02a7, B:66:0x02c4, B:70:0x0311, B:72:0x0381, B:73:0x038c, B:75:0x0096, B:76:0x0234, B:80:0x00a7, B:82:0x0217, B:84:0x021d, B:88:0x00b8, B:89:0x01e4, B:91:0x01ea, B:92:0x01f7, B:95:0x00ce, B:97:0x01c7, B:99:0x01cd, B:102:0x01f8, B:107:0x00e4, B:108:0x0180, B:110:0x0186, B:111:0x019a, B:114:0x01a6, B:119:0x00f7, B:120:0x015b, B:121:0x015e, B:126:0x0105, B:128:0x0122, B:130:0x0128), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x025e A[Catch: all -> 0x038d, CancellationException -> 0x03bb, TryCatch #2 {CancellationException -> 0x03bb, all -> 0x038d, blocks: (B:7:0x0017, B:8:0x0377, B:18:0x0028, B:19:0x0358, B:23:0x0033, B:24:0x033f, B:26:0x0345, B:30:0x0046, B:31:0x0306, B:32:0x0317, B:37:0x0051, B:39:0x02ea, B:41:0x02f0, B:45:0x0061, B:46:0x0278, B:48:0x027e, B:49:0x028b, B:52:0x0079, B:54:0x0258, B:56:0x025e, B:59:0x028c, B:61:0x0297, B:63:0x02a1, B:65:0x02a7, B:66:0x02c4, B:70:0x0311, B:72:0x0381, B:73:0x038c, B:75:0x0096, B:76:0x0234, B:80:0x00a7, B:82:0x0217, B:84:0x021d, B:88:0x00b8, B:89:0x01e4, B:91:0x01ea, B:92:0x01f7, B:95:0x00ce, B:97:0x01c7, B:99:0x01cd, B:102:0x01f8, B:107:0x00e4, B:108:0x0180, B:110:0x0186, B:111:0x019a, B:114:0x01a6, B:119:0x00f7, B:120:0x015b, B:121:0x015e, B:126:0x0105, B:128:0x0122, B:130:0x0128), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x028c A[Catch: all -> 0x038d, CancellationException -> 0x03bb, TryCatch #2 {CancellationException -> 0x03bb, all -> 0x038d, blocks: (B:7:0x0017, B:8:0x0377, B:18:0x0028, B:19:0x0358, B:23:0x0033, B:24:0x033f, B:26:0x0345, B:30:0x0046, B:31:0x0306, B:32:0x0317, B:37:0x0051, B:39:0x02ea, B:41:0x02f0, B:45:0x0061, B:46:0x0278, B:48:0x027e, B:49:0x028b, B:52:0x0079, B:54:0x0258, B:56:0x025e, B:59:0x028c, B:61:0x0297, B:63:0x02a1, B:65:0x02a7, B:66:0x02c4, B:70:0x0311, B:72:0x0381, B:73:0x038c, B:75:0x0096, B:76:0x0234, B:80:0x00a7, B:82:0x0217, B:84:0x021d, B:88:0x00b8, B:89:0x01e4, B:91:0x01ea, B:92:0x01f7, B:95:0x00ce, B:97:0x01c7, B:99:0x01cd, B:102:0x01f8, B:107:0x00e4, B:108:0x0180, B:110:0x0186, B:111:0x019a, B:114:0x01a6, B:119:0x00f7, B:120:0x015b, B:121:0x015e, B:126:0x0105, B:128:0x0122, B:130:0x0128), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x021d A[Catch: all -> 0x038d, CancellationException -> 0x03bb, TryCatch #2 {CancellationException -> 0x03bb, all -> 0x038d, blocks: (B:7:0x0017, B:8:0x0377, B:18:0x0028, B:19:0x0358, B:23:0x0033, B:24:0x033f, B:26:0x0345, B:30:0x0046, B:31:0x0306, B:32:0x0317, B:37:0x0051, B:39:0x02ea, B:41:0x02f0, B:45:0x0061, B:46:0x0278, B:48:0x027e, B:49:0x028b, B:52:0x0079, B:54:0x0258, B:56:0x025e, B:59:0x028c, B:61:0x0297, B:63:0x02a1, B:65:0x02a7, B:66:0x02c4, B:70:0x0311, B:72:0x0381, B:73:0x038c, B:75:0x0096, B:76:0x0234, B:80:0x00a7, B:82:0x0217, B:84:0x021d, B:88:0x00b8, B:89:0x01e4, B:91:0x01ea, B:92:0x01f7, B:95:0x00ce, B:97:0x01c7, B:99:0x01cd, B:102:0x01f8, B:107:0x00e4, B:108:0x0180, B:110:0x0186, B:111:0x019a, B:114:0x01a6, B:119:0x00f7, B:120:0x015b, B:121:0x015e, B:126:0x0105, B:128:0x0122, B:130:0x0128), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01ea A[Catch: all -> 0x038d, CancellationException -> 0x03bb, TryCatch #2 {CancellationException -> 0x03bb, all -> 0x038d, blocks: (B:7:0x0017, B:8:0x0377, B:18:0x0028, B:19:0x0358, B:23:0x0033, B:24:0x033f, B:26:0x0345, B:30:0x0046, B:31:0x0306, B:32:0x0317, B:37:0x0051, B:39:0x02ea, B:41:0x02f0, B:45:0x0061, B:46:0x0278, B:48:0x027e, B:49:0x028b, B:52:0x0079, B:54:0x0258, B:56:0x025e, B:59:0x028c, B:61:0x0297, B:63:0x02a1, B:65:0x02a7, B:66:0x02c4, B:70:0x0311, B:72:0x0381, B:73:0x038c, B:75:0x0096, B:76:0x0234, B:80:0x00a7, B:82:0x0217, B:84:0x021d, B:88:0x00b8, B:89:0x01e4, B:91:0x01ea, B:92:0x01f7, B:95:0x00ce, B:97:0x01c7, B:99:0x01cd, B:102:0x01f8, B:107:0x00e4, B:108:0x0180, B:110:0x0186, B:111:0x019a, B:114:0x01a6, B:119:0x00f7, B:120:0x015b, B:121:0x015e, B:126:0x0105, B:128:0x0122, B:130:0x0128), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01cd A[Catch: all -> 0x038d, CancellationException -> 0x03bb, TryCatch #2 {CancellationException -> 0x03bb, all -> 0x038d, blocks: (B:7:0x0017, B:8:0x0377, B:18:0x0028, B:19:0x0358, B:23:0x0033, B:24:0x033f, B:26:0x0345, B:30:0x0046, B:31:0x0306, B:32:0x0317, B:37:0x0051, B:39:0x02ea, B:41:0x02f0, B:45:0x0061, B:46:0x0278, B:48:0x027e, B:49:0x028b, B:52:0x0079, B:54:0x0258, B:56:0x025e, B:59:0x028c, B:61:0x0297, B:63:0x02a1, B:65:0x02a7, B:66:0x02c4, B:70:0x0311, B:72:0x0381, B:73:0x038c, B:75:0x0096, B:76:0x0234, B:80:0x00a7, B:82:0x0217, B:84:0x021d, B:88:0x00b8, B:89:0x01e4, B:91:0x01ea, B:92:0x01f7, B:95:0x00ce, B:97:0x01c7, B:99:0x01cd, B:102:0x01f8, B:107:0x00e4, B:108:0x0180, B:110:0x0186, B:111:0x019a, B:114:0x01a6, B:119:0x00f7, B:120:0x015b, B:121:0x015e, B:126:0x0105, B:128:0x0122, B:130:0x0128), top: B:2:0x000c }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object m10241constructorimpl;
        CoroutineScope coroutineScope;
        InitializeSDK initializeSDK;
        Object handleInitializationException;
        InitializeSDK initializeSDK2;
        ConfigFileFromLocalStorage configFileFromLocalStorage;
        Object obj2;
        InitializeSDK initializeSDK3;
        Object obj3;
        Throwable m10244exceptionOrNullimpl;
        Configuration configuration;
        InitializeStateReset initializeStateReset;
        Object obj4;
        InitializeSDK initializeSDK4;
        Object obj5;
        InitializeStateConfig initializeStateConfig;
        Object obj6;
        CoroutineScope coroutineScope2;
        InitializeSDK initializeSDK5;
        Configuration configuration2;
        Object m9276executeErrorStateBWLJW6A;
        Throwable m10244exceptionOrNullimpl2;
        Object handleInitializationException2;
        InitializeStateLoadCache initializeStateLoadCache;
        Object obj7;
        Object obj8;
        Object obj9;
        String webViewData;
        InitializeStateLoadWeb initializeStateLoadWeb;
        Object obj10;
        Object obj11;
        Object m9276executeErrorStateBWLJW6A2;
        Throwable m10244exceptionOrNullimpl3;
        Object handleInitializationException3;
        InitializeStateCreate initializeStateCreate;
        Object obj12;
        Object obj13;
        Object obj14;
        InitializeSDK initializeSDK6;
        Object handleInitializationException4;
        InitializeStateComplete initializeStateComplete;
        Object obj15;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (CancellationException e) {
            throw e;
        } catch (Throwable th) {
            Result.Companion companion = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.L$0;
                initializeSDK = this.this$0;
                Result.Companion companion2 = Result.INSTANCE;
                SdkProperties.setInitializationTime(Device.getElapsedRealtime());
                SdkProperties.setInitializationTimeSinceEpoch(System.currentTimeMillis());
                InitializeEventsMetricSender.getInstance().didInitStart();
                String gameId = ClientProperties.getGameId();
                if (gameId == null || StringsKt.toIntOrNull(gameId) == null) {
                    InitializationException initializationException = new InitializationException(ErrorState.InvalidGameId, new Exception("gameId \"" + gameId + "\" should be a number."), new Configuration());
                    this.L$0 = coroutineScope;
                    this.L$1 = initializeSDK;
                    this.label = 1;
                    handleInitializationException = initializeSDK.handleInitializationException(initializationException, this);
                    if (handleInitializationException == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    initializeSDK2 = initializeSDK;
                    Unit unit = Unit.INSTANCE;
                    initializeSDK = initializeSDK2;
                }
                DeviceLog.debug("Unity Ads Init: Loading Config File From Local Storage");
                configFileFromLocalStorage = initializeSDK.configFileFromLocalStorage;
                ConfigFileFromLocalStorage.Params params = new ConfigFileFromLocalStorage.Params(null, 1, null);
                this.L$0 = coroutineScope;
                this.L$1 = initializeSDK;
                this.label = 2;
                obj2 = configFileFromLocalStorage.mo9272invokegIAlus(params, this);
                if (obj2 != coroutine_suspended) {
                    return coroutine_suspended;
                }
                initializeSDK3 = initializeSDK;
                obj3 = obj2;
                m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(obj3);
                if (m10244exceptionOrNullimpl != null) {
                    DeviceLog.debug("Unity Ads Init: Could not load config file from local storage: " + m10244exceptionOrNullimpl.getMessage());
                }
                Configuration configuration3 = new Configuration();
                if (Result.m10247isFailureimpl(obj3)) {
                    obj3 = configuration3;
                }
                configuration = (Configuration) obj3;
                initializeStateReset = initializeSDK3.initializeStateReset;
                InitializeStateReset.Params params2 = new InitializeStateReset.Params(configuration);
                this.L$0 = coroutineScope;
                this.L$1 = initializeSDK3;
                this.L$2 = configuration;
                this.label = 3;
                obj4 = initializeStateReset.mo9272invokegIAlus(params2, this);
                if (obj4 != coroutine_suspended) {
                    return coroutine_suspended;
                }
                initializeSDK4 = initializeSDK3;
                obj5 = obj4;
                if (Result.m10247isFailureimpl(obj5)) {
                    initializeStateConfig = initializeSDK4.initializeStateConfig;
                    InitializeStateConfig.Params params3 = new InitializeStateConfig.Params(configuration);
                    this.L$0 = coroutineScope;
                    this.L$1 = initializeSDK4;
                    this.L$2 = configuration;
                    this.label = 5;
                    obj6 = initializeStateConfig.mo9272invokegIAlus(params3, this);
                    if (obj6 != coroutine_suspended) {
                        coroutineScope2 = coroutineScope;
                        initializeSDK5 = initializeSDK4;
                        configuration2 = configuration;
                        if (Result.m10247isFailureimpl(obj6)) {
                            InitializationException initializationExceptionOrThrow = ResultExtensionsKt.getInitializationExceptionOrThrow(obj6);
                            this.L$0 = coroutineScope2;
                            this.L$1 = initializeSDK5;
                            this.L$2 = configuration2;
                            this.L$3 = obj6;
                            this.label = 6;
                            handleInitializationException2 = initializeSDK5.handleInitializationException(initializationExceptionOrThrow, this);
                            if (handleInitializationException2 == coroutine_suspended) {
                            }
                        }
                        initializeStateLoadCache = initializeSDK5.initializeStateLoadCache;
                        ResultKt.throwOnFailure(obj6);
                        InitializeStateLoadCache.Params params4 = new InitializeStateLoadCache.Params((Configuration) obj6);
                        this.L$0 = coroutineScope2;
                        this.L$1 = initializeSDK5;
                        this.L$2 = configuration2;
                        this.L$3 = obj6;
                        this.label = 7;
                        obj7 = initializeStateLoadCache.mo9272invokegIAlus(params4, this);
                        if (obj7 == coroutine_suspended) {
                        }
                        Object obj16 = obj6;
                        obj8 = obj7;
                        obj9 = obj16;
                        CoroutineScope coroutineScope3 = coroutineScope2;
                        if (!Result.m10247isFailureimpl(obj8)) {
                            ErrorState errorState = ErrorState.LoadCache;
                            Throwable m10244exceptionOrNullimpl4 = Result.m10244exceptionOrNullimpl(obj8);
                            this.L$0 = obj8;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.label = 8;
                            m9276executeErrorStateBWLJW6A2 = initializeSDK5.m9276executeErrorStateBWLJW6A(errorState, m10244exceptionOrNullimpl4, configuration2, this);
                            if (m9276executeErrorStateBWLJW6A2 == coroutine_suspended) {
                            }
                            m10244exceptionOrNullimpl3 = Result.m10244exceptionOrNullimpl(obj8);
                            if (m10244exceptionOrNullimpl3 != null) {
                                throw new Exception(ErrorState.LoadCache.toString());
                            }
                            throw m10244exceptionOrNullimpl3;
                        }
                        ResultKt.throwOnFailure(obj8);
                        InitializeStateLoadCache.LoadCacheResult loadCacheResult = (InitializeStateLoadCache.LoadCacheResult) obj8;
                        if (loadCacheResult.getHasHashMismatch()) {
                            if (configuration2.getExperiments().isWebViewAsyncDownloadEnabled() && loadCacheResult.getWebViewData() != null) {
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope3, new CoroutineName("LaunchLoadWeb"), null, new InitializeSDK$doWork$2$1$webViewData$1(initializeSDK5, obj9, null), 2, null);
                                webViewData = loadCacheResult.getWebViewData();
                            } else {
                                initializeStateLoadWeb = initializeSDK5.initializeStateLoadWeb;
                                ResultKt.throwOnFailure(obj9);
                                InitializeStateLoadWeb.Params params5 = new InitializeStateLoadWeb.Params((Configuration) obj9);
                                this.L$0 = initializeSDK5;
                                this.L$1 = obj9;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.label = 9;
                                obj10 = initializeStateLoadWeb.mo9272invokegIAlus(params5, this);
                                if (obj10 != coroutine_suspended) {
                                    obj11 = obj9;
                                    if (Result.m10247isFailureimpl(obj10)) {
                                        InitializationException initializationExceptionOrThrow2 = ResultExtensionsKt.getInitializationExceptionOrThrow(obj10);
                                        this.L$0 = initializeSDK5;
                                        this.L$1 = obj11;
                                        this.L$2 = obj10;
                                        this.label = 10;
                                        handleInitializationException3 = initializeSDK5.handleInitializationException(initializationExceptionOrThrow2, this);
                                        if (handleInitializationException3 == coroutine_suspended) {
                                        }
                                    }
                                    obj9 = obj11;
                                    ResultKt.throwOnFailure(obj10);
                                    webViewData = ((InitializeStateLoadWeb.LoadWebResult) obj10).getWebViewDataString();
                                }
                            }
                        } else {
                            webViewData = loadCacheResult.getWebViewData();
                            if (webViewData == null) {
                                throw new IllegalStateException("WebView is missing.".toString());
                            }
                        }
                        initializeStateCreate = initializeSDK5.initializeStateCreate;
                        ResultKt.throwOnFailure(obj9);
                        InitializeStateCreate.Params params6 = new InitializeStateCreate.Params((Configuration) obj9, webViewData);
                        this.L$0 = initializeSDK5;
                        this.L$1 = obj9;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 11;
                        obj12 = initializeStateCreate.mo9272invokegIAlus(params6, this);
                        if (obj12 != coroutine_suspended) {
                            obj13 = obj9;
                            obj14 = obj12;
                            initializeSDK6 = initializeSDK5;
                            if (Result.m10247isFailureimpl(obj14)) {
                                InitializationException initializationExceptionOrThrow3 = ResultExtensionsKt.getInitializationExceptionOrThrow(obj14);
                                this.L$0 = initializeSDK6;
                                this.L$1 = obj13;
                                this.label = 12;
                                handleInitializationException4 = initializeSDK6.handleInitializationException(initializationExceptionOrThrow3, this);
                                if (handleInitializationException4 == coroutine_suspended) {
                                }
                            }
                            initializeStateComplete = initializeSDK6.initializeStateComplete;
                            ResultKt.throwOnFailure(obj13);
                            InitializeStateComplete.Params params7 = new InitializeStateComplete.Params((Configuration) obj13);
                            this.L$0 = null;
                            this.L$1 = null;
                            this.label = 13;
                            obj15 = initializeStateComplete.mo9272invokegIAlus(params7, this);
                            break;
                        }
                    }
                } else {
                    ErrorState errorState2 = ErrorState.ResetWebApp;
                    Throwable m10244exceptionOrNullimpl5 = Result.m10244exceptionOrNullimpl(obj5);
                    this.L$0 = obj5;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 4;
                    m9276executeErrorStateBWLJW6A = initializeSDK4.m9276executeErrorStateBWLJW6A(errorState2, m10244exceptionOrNullimpl5, configuration, this);
                    if (m9276executeErrorStateBWLJW6A == coroutine_suspended) {
                    }
                    m10244exceptionOrNullimpl2 = Result.m10244exceptionOrNullimpl(obj5);
                    if (m10244exceptionOrNullimpl2 != null) {
                        throw new Exception(ErrorState.ResetWebApp.toString());
                    }
                    throw m10244exceptionOrNullimpl2;
                }
                return coroutine_suspended;
            case 1:
                initializeSDK2 = (InitializeSDK) this.L$1;
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                Unit unit2 = Unit.INSTANCE;
                initializeSDK = initializeSDK2;
                DeviceLog.debug("Unity Ads Init: Loading Config File From Local Storage");
                configFileFromLocalStorage = initializeSDK.configFileFromLocalStorage;
                ConfigFileFromLocalStorage.Params params8 = new ConfigFileFromLocalStorage.Params(null, 1, null);
                this.L$0 = coroutineScope;
                this.L$1 = initializeSDK;
                this.label = 2;
                obj2 = configFileFromLocalStorage.mo9272invokegIAlus(params8, this);
                if (obj2 != coroutine_suspended) {
                }
                break;
            case 2:
                initializeSDK3 = (InitializeSDK) this.L$1;
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                obj3 = ((Result) obj).getValue();
                m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(obj3);
                if (m10244exceptionOrNullimpl != null) {
                }
                Configuration configuration32 = new Configuration();
                if (Result.m10247isFailureimpl(obj3)) {
                }
                configuration = (Configuration) obj3;
                initializeStateReset = initializeSDK3.initializeStateReset;
                InitializeStateReset.Params params22 = new InitializeStateReset.Params(configuration);
                this.L$0 = coroutineScope;
                this.L$1 = initializeSDK3;
                this.L$2 = configuration;
                this.label = 3;
                obj4 = initializeStateReset.mo9272invokegIAlus(params22, this);
                if (obj4 != coroutine_suspended) {
                }
                break;
            case 3:
                Configuration configuration4 = (Configuration) this.L$2;
                initializeSDK4 = (InitializeSDK) this.L$1;
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                obj5 = ((Result) obj).getValue();
                configuration = configuration4;
                if (Result.m10247isFailureimpl(obj5)) {
                }
                return coroutine_suspended;
            case 4:
                obj5 = this.L$0;
                ResultKt.throwOnFailure(obj);
                ((Result) obj).getValue();
                m10244exceptionOrNullimpl2 = Result.m10244exceptionOrNullimpl(obj5);
                if (m10244exceptionOrNullimpl2 != null) {
                }
                break;
            case 5:
                Configuration configuration5 = (Configuration) this.L$2;
                InitializeSDK initializeSDK7 = (InitializeSDK) this.L$1;
                CoroutineScope coroutineScope4 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                coroutineScope2 = coroutineScope4;
                initializeSDK5 = initializeSDK7;
                configuration2 = configuration5;
                obj6 = ((Result) obj).getValue();
                if (Result.m10247isFailureimpl(obj6)) {
                }
                initializeStateLoadCache = initializeSDK5.initializeStateLoadCache;
                ResultKt.throwOnFailure(obj6);
                InitializeStateLoadCache.Params params42 = new InitializeStateLoadCache.Params((Configuration) obj6);
                this.L$0 = coroutineScope2;
                this.L$1 = initializeSDK5;
                this.L$2 = configuration2;
                this.L$3 = obj6;
                this.label = 7;
                obj7 = initializeStateLoadCache.mo9272invokegIAlus(params42, this);
                if (obj7 == coroutine_suspended) {
                }
                Object obj162 = obj6;
                obj8 = obj7;
                obj9 = obj162;
                CoroutineScope coroutineScope32 = coroutineScope2;
                if (!Result.m10247isFailureimpl(obj8)) {
                }
                return coroutine_suspended;
            case 6:
                obj6 = this.L$3;
                configuration2 = (Configuration) this.L$2;
                initializeSDK5 = (InitializeSDK) this.L$1;
                coroutineScope2 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                initializeStateLoadCache = initializeSDK5.initializeStateLoadCache;
                ResultKt.throwOnFailure(obj6);
                InitializeStateLoadCache.Params params422 = new InitializeStateLoadCache.Params((Configuration) obj6);
                this.L$0 = coroutineScope2;
                this.L$1 = initializeSDK5;
                this.L$2 = configuration2;
                this.L$3 = obj6;
                this.label = 7;
                obj7 = initializeStateLoadCache.mo9272invokegIAlus(params422, this);
                if (obj7 == coroutine_suspended) {
                }
                Object obj1622 = obj6;
                obj8 = obj7;
                obj9 = obj1622;
                CoroutineScope coroutineScope322 = coroutineScope2;
                if (!Result.m10247isFailureimpl(obj8)) {
                }
                return coroutine_suspended;
            case 7:
                obj6 = this.L$3;
                configuration2 = (Configuration) this.L$2;
                initializeSDK5 = (InitializeSDK) this.L$1;
                coroutineScope2 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                obj7 = ((Result) obj).getValue();
                Object obj16222 = obj6;
                obj8 = obj7;
                obj9 = obj16222;
                CoroutineScope coroutineScope3222 = coroutineScope2;
                if (!Result.m10247isFailureimpl(obj8)) {
                }
                return coroutine_suspended;
            case 8:
                obj8 = this.L$0;
                ResultKt.throwOnFailure(obj);
                ((Result) obj).getValue();
                m10244exceptionOrNullimpl3 = Result.m10244exceptionOrNullimpl(obj8);
                if (m10244exceptionOrNullimpl3 != null) {
                }
                break;
            case 9:
                Object obj17 = this.L$1;
                InitializeSDK initializeSDK8 = (InitializeSDK) this.L$0;
                ResultKt.throwOnFailure(obj);
                initializeSDK5 = initializeSDK8;
                obj11 = obj17;
                obj10 = ((Result) obj).getValue();
                if (Result.m10247isFailureimpl(obj10)) {
                }
                obj9 = obj11;
                ResultKt.throwOnFailure(obj10);
                webViewData = ((InitializeStateLoadWeb.LoadWebResult) obj10).getWebViewDataString();
                initializeStateCreate = initializeSDK5.initializeStateCreate;
                ResultKt.throwOnFailure(obj9);
                InitializeStateCreate.Params params62 = new InitializeStateCreate.Params((Configuration) obj9, webViewData);
                this.L$0 = initializeSDK5;
                this.L$1 = obj9;
                this.L$2 = null;
                this.L$3 = null;
                this.label = 11;
                obj12 = initializeStateCreate.mo9272invokegIAlus(params62, this);
                if (obj12 != coroutine_suspended) {
                }
                break;
            case 10:
                obj10 = this.L$2;
                obj11 = this.L$1;
                initializeSDK5 = (InitializeSDK) this.L$0;
                ResultKt.throwOnFailure(obj);
                obj9 = obj11;
                ResultKt.throwOnFailure(obj10);
                webViewData = ((InitializeStateLoadWeb.LoadWebResult) obj10).getWebViewDataString();
                initializeStateCreate = initializeSDK5.initializeStateCreate;
                ResultKt.throwOnFailure(obj9);
                InitializeStateCreate.Params params622 = new InitializeStateCreate.Params((Configuration) obj9, webViewData);
                this.L$0 = initializeSDK5;
                this.L$1 = obj9;
                this.L$2 = null;
                this.L$3 = null;
                this.label = 11;
                obj12 = initializeStateCreate.mo9272invokegIAlus(params622, this);
                if (obj12 != coroutine_suspended) {
                }
                break;
            case 11:
                obj13 = this.L$1;
                initializeSDK6 = (InitializeSDK) this.L$0;
                ResultKt.throwOnFailure(obj);
                obj14 = ((Result) obj).getValue();
                if (Result.m10247isFailureimpl(obj14)) {
                }
                initializeStateComplete = initializeSDK6.initializeStateComplete;
                ResultKt.throwOnFailure(obj13);
                InitializeStateComplete.Params params72 = new InitializeStateComplete.Params((Configuration) obj13);
                this.L$0 = null;
                this.L$1 = null;
                this.label = 13;
                obj15 = initializeStateComplete.mo9272invokegIAlus(params72, this);
                break;
            case 12:
                obj13 = this.L$1;
                initializeSDK6 = (InitializeSDK) this.L$0;
                ResultKt.throwOnFailure(obj);
                initializeStateComplete = initializeSDK6.initializeStateComplete;
                ResultKt.throwOnFailure(obj13);
                InitializeStateComplete.Params params722 = new InitializeStateComplete.Params((Configuration) obj13);
                this.L$0 = null;
                this.L$1 = null;
                this.label = 13;
                obj15 = initializeStateComplete.mo9272invokegIAlus(params722, this);
                break;
            case 13:
                ResultKt.throwOnFailure(obj);
                obj15 = ((Result) obj).getValue();
                ResultKt.throwOnFailure(obj15);
                m10241constructorimpl = Result.m10241constructorimpl(Unit.INSTANCE);
                if (Result.m10248isSuccessimpl(m10241constructorimpl)) {
                    Result.Companion companion3 = Result.INSTANCE;
                    m10241constructorimpl = Result.m10241constructorimpl(m10241constructorimpl);
                } else {
                    Throwable m10244exceptionOrNullimpl6 = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
                    if (m10244exceptionOrNullimpl6 != null) {
                        Result.Companion companion4 = Result.INSTANCE;
                        m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(m10244exceptionOrNullimpl6));
                    }
                }
                return Result.m10240boximpl(m10241constructorimpl);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
