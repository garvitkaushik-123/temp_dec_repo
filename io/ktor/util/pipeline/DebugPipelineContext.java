package io.ktor.util.pipeline;

import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.util.KtorDsl;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebugPipelineContext.kt */
@KtorDsl
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004Bg\u0012\u0006\u0010\u0005\u001a\u00028\u0001\u0012H\u0010\u0006\u001aD\u0012@\u0012>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00020\bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000b0\u0007\u0012\u0006\u0010\f\u001a\u00028\u0000\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u001b\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00028\u0000H\u0090@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u001d\u001a\u00020\nH\u0016J\u0011\u0010\u001e\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ\u0011\u0010 \u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ\u0019\u0010!\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001cR\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000RP\u0010\u0006\u001aD\u0012@\u0012>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00020\bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u00028\u0000X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lio/ktor/util/pipeline/DebugPipelineContext;", "TSubject", "", "TContext", "Lio/ktor/util/pipeline/PipelineContext;", "context", "interceptors", "", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "", "Lio/ktor/util/pipeline/PipelineInterceptorFunction;", "subject", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "(Ljava/lang/Object;Ljava/util/List;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", FirebaseAnalytics.Param.INDEX, "", "getSubject", "()Ljava/lang/Object;", "setSubject", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "execute", "initial", "execute$ktor_utils", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "finish", "proceed", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "proceedLoop", "proceedWith", "ktor-utils"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class DebugPipelineContext<TSubject, TContext> extends PipelineContext<TSubject, TContext> {
    private final CoroutineContext coroutineContext;
    private int index;
    private final List<Function3<PipelineContext<TSubject, TContext>, TSubject, Continuation<? super Unit>, Object>> interceptors;
    private TSubject subject;

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DebugPipelineContext(TContext context, List<? extends Function3<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super Continuation<? super Unit>, ? extends Object>> interceptors, TSubject subject, CoroutineContext coroutineContext) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(interceptors, "interceptors");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        this.interceptors = interceptors;
        this.coroutineContext = coroutineContext;
        this.subject = subject;
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public TSubject getSubject() {
        return this.subject;
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public void setSubject(TSubject tsubject) {
        Intrinsics.checkNotNullParameter(tsubject, "<set-?>");
        this.subject = tsubject;
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public void finish() {
        this.index = -1;
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public Object proceedWith(TSubject tsubject, Continuation<? super TSubject> continuation) {
        setSubject(tsubject);
        return proceed(continuation);
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public Object proceed(Continuation<? super TSubject> continuation) {
        int i = this.index;
        if (i < 0) {
            return getSubject();
        }
        if (i >= this.interceptors.size()) {
            finish();
            return getSubject();
        }
        return proceedLoop(continuation);
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public Object execute$ktor_utils(TSubject tsubject, Continuation<? super TSubject> continuation) {
        this.index = 0;
        setSubject(tsubject);
        return proceed(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object proceedLoop(Continuation<? super TSubject> continuation) {
        DebugPipelineContext$proceedLoop$1 debugPipelineContext$proceedLoop$1;
        Object coroutine_suspended;
        int i;
        DebugPipelineContext<TSubject, TContext> debugPipelineContext;
        int i2;
        Function3<PipelineContext<TSubject, TContext>, TSubject, Continuation<? super Unit>, Object> function3;
        TSubject subject;
        if (continuation instanceof DebugPipelineContext$proceedLoop$1) {
            debugPipelineContext$proceedLoop$1 = (DebugPipelineContext$proceedLoop$1) continuation;
            if ((debugPipelineContext$proceedLoop$1.label & Integer.MIN_VALUE) != 0) {
                debugPipelineContext$proceedLoop$1.label -= Integer.MIN_VALUE;
                Object obj = debugPipelineContext$proceedLoop$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = debugPipelineContext$proceedLoop$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    debugPipelineContext = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    debugPipelineContext = (DebugPipelineContext) debugPipelineContext$proceedLoop$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                do {
                    i2 = debugPipelineContext.index;
                    if (i2 == -1) {
                        List<Function3<PipelineContext<TSubject, TContext>, TSubject, Continuation<? super Unit>, Object>> list = debugPipelineContext.interceptors;
                        if (i2 >= list.size()) {
                            debugPipelineContext.finish();
                        } else {
                            function3 = list.get(i2);
                            debugPipelineContext.index = i2 + 1;
                            Intrinsics.checkNotNull(function3, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.coroutines.SuspendFunction2<io.ktor.util.pipeline.PipelineContext<TSubject of io.ktor.util.pipeline.DebugPipelineContext, TContext of io.ktor.util.pipeline.DebugPipelineContext>, TSubject of io.ktor.util.pipeline.DebugPipelineContext, kotlin.Unit>{ io.ktor.util.pipeline.PipelineKt.PipelineInterceptor<TSubject of io.ktor.util.pipeline.DebugPipelineContext, TContext of io.ktor.util.pipeline.DebugPipelineContext> }");
                            subject = debugPipelineContext.getSubject();
                            debugPipelineContext$proceedLoop$1.L$0 = debugPipelineContext;
                            debugPipelineContext$proceedLoop$1.label = 1;
                        }
                    }
                    return debugPipelineContext.getSubject();
                } while (function3.invoke(debugPipelineContext, subject, debugPipelineContext$proceedLoop$1) != coroutine_suspended);
                return coroutine_suspended;
            }
        }
        debugPipelineContext$proceedLoop$1 = new DebugPipelineContext$proceedLoop$1(this, continuation);
        Object obj2 = debugPipelineContext$proceedLoop$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = debugPipelineContext$proceedLoop$1.label;
        if (i != 0) {
        }
        do {
            i2 = debugPipelineContext.index;
            if (i2 == -1) {
            }
            return debugPipelineContext.getSubject();
        } while (function3.invoke(debugPipelineContext, subject, debugPipelineContext$proceedLoop$1) != coroutine_suspended);
        return coroutine_suspended;
    }
}
