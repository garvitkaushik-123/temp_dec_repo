package com.sourcepoint.cmplibrary.core;

import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: ExecutorManager.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ExecutorManagerImpl$executeOnWorkerThread$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0<Unit> $block;
    final /* synthetic */ ExecutorManagerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ExecutorManagerImpl$executeOnWorkerThread$1(ExecutorManagerImpl executorManagerImpl, Function0<Unit> function0) {
        super(0);
        this.this$0 = executorManagerImpl;
        this.$block = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ExecutorService executorService;
        executorService = this.this$0.executor;
        final Function0<Unit> function0 = this.$block;
        executorService.execute(new Runnable() { // from class: com.sourcepoint.cmplibrary.core.ExecutorManagerImpl$executeOnWorkerThread$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ExecutorManagerImpl$executeOnWorkerThread$1.invoke$lambda$0(Function0.this);
            }
        });
    }
}
