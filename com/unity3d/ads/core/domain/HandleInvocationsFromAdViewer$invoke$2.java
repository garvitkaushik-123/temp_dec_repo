package com.unity3d.ads.core.domain;

import com.unity3d.ads.adplayer.ExposedFunction;
import com.unity3d.ads.adplayer.Invocation;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: HandleInvocationsFromAdViewer.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/unity3d/ads/adplayer/Invocation;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$2", f = "HandleInvocationsFromAdViewer.kt", i = {}, l = {188}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class HandleInvocationsFromAdViewer$invoke$2 extends SuspendLambda implements Function2<Invocation, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, Function0<ExposedFunction>> $definition;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    HandleInvocationsFromAdViewer$invoke$2(Map<String, ? extends Function0<? extends ExposedFunction>> map, Continuation<? super HandleInvocationsFromAdViewer$invoke$2> continuation) {
        super(2, continuation);
        this.$definition = map;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        HandleInvocationsFromAdViewer$invoke$2 handleInvocationsFromAdViewer$invoke$2 = new HandleInvocationsFromAdViewer$invoke$2(this.$definition, continuation);
        handleInvocationsFromAdViewer$invoke$2.L$0 = obj;
        return handleInvocationsFromAdViewer$invoke$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Invocation invocation, Continuation<? super Unit> continuation) {
        return ((HandleInvocationsFromAdViewer$invoke$2) create(invocation, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ExposedFunction invoke;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Invocation invocation = (Invocation) this.L$0;
            Function0<ExposedFunction> function0 = this.$definition.get(invocation.getLocation());
            if (function0 == null || (invoke = function0.invoke()) == null) {
                return Unit.INSTANCE;
            }
            this.label = 1;
            if (invocation.handle(new AnonymousClass1(invoke, invocation, null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* compiled from: HandleInvocationsFromAdViewer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$2$1", f = "HandleInvocationsFromAdViewer.kt", i = {}, l = {188}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$2$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Object>, Object> {
        final /* synthetic */ ExposedFunction $exposedFunction;
        final /* synthetic */ Invocation $it;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ExposedFunction exposedFunction, Invocation invocation, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$exposedFunction = exposedFunction;
            this.$it = invocation;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.$exposedFunction, this.$it, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Object> continuation) {
            return invoke2((Continuation<Object>) continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<Object> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            ExposedFunction exposedFunction = this.$exposedFunction;
            Object[] parameters = this.$it.getParameters();
            this.label = 1;
            Object invoke = exposedFunction.invoke(parameters, this);
            return invoke == coroutine_suspended ? coroutine_suspended : invoke;
        }
    }
}
