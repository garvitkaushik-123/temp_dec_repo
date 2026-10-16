package com.unity3d.ads.core.extensions;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: FlowExtensions.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.extensions.FlowExtensionsKt$timeoutAfter$1", f = "FlowExtensions.kt", i = {0}, l = {15, 17}, m = "invokeSuspend", n = {"$this$channelFlow"}, s = {"L$0"})
/* loaded from: classes7.dex */
final class FlowExtensionsKt$timeoutAfter$1<T> extends SuspendLambda implements Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $active;
    final /* synthetic */ Function2<Function0<Unit>, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ Flow<T> $this_timeoutAfter;
    final /* synthetic */ long $timeoutMillis;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FlowExtensionsKt$timeoutAfter$1(long j, boolean z, Function2<? super Function0<Unit>, ? super Continuation<? super Unit>, ? extends Object> function2, Flow<? extends T> flow, Continuation<? super FlowExtensionsKt$timeoutAfter$1> continuation) {
        super(2, continuation);
        this.$timeoutMillis = j;
        this.$active = z;
        this.$block = function2;
        this.$this_timeoutAfter = flow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FlowExtensionsKt$timeoutAfter$1 flowExtensionsKt$timeoutAfter$1 = new FlowExtensionsKt$timeoutAfter$1(this.$timeoutMillis, this.$active, this.$block, this.$this_timeoutAfter, continuation);
        flowExtensionsKt$timeoutAfter$1.L$0 = obj;
        return flowExtensionsKt$timeoutAfter$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
        return ((FlowExtensionsKt$timeoutAfter$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: FlowExtensions.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.ads.core.extensions.FlowExtensionsKt$timeoutAfter$1$1", f = "FlowExtensions.kt", i = {}, l = {10}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.unity3d.ads.core.extensions.FlowExtensionsKt$timeoutAfter$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ProducerScope<T> $$this$channelFlow;
        final /* synthetic */ Flow<T> $this_timeoutAfter;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Flow<? extends T> flow, ProducerScope<? super T> producerScope, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_timeoutAfter = flow;
            this.$$this$channelFlow = producerScope;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$this_timeoutAfter, this.$$this$channelFlow, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<T> flow = this.$this_timeoutAfter;
                final ProducerScope<T> producerScope = this.$$this$channelFlow;
                this.label = 1;
                if (flow.collect(new FlowCollector() { // from class: com.unity3d.ads.core.extensions.FlowExtensionsKt.timeoutAfter.1.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(T t, Continuation<? super Unit> continuation) {
                        Object send = producerScope.send(t, continuation);
                        return send == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? send : Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            SendChannel.DefaultImpls.close$default(this.$$this$channelFlow, null, 1, null);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0062, code lost:
    
        if (r12.invoke(r4, r11) == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0064, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004c, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(r11.$timeoutMillis, r11) == r0) goto L17;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ProducerScope producerScope;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            producerScope = (ProducerScope) this.L$0;
            BuildersKt__Builders_commonKt.launch$default(producerScope, null, null, new AnonymousClass1(this.$this_timeoutAfter, producerScope, null), 3, null);
            this.L$0 = producerScope;
            this.label = 1;
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            producerScope = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        if (this.$active) {
            Function2<Function0<Unit>, Continuation<? super Unit>, Object> function2 = this.$block;
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(producerScope);
            this.L$0 = null;
            this.label = 2;
        }
        return Unit.INSTANCE;
    }

    /* compiled from: FlowExtensions.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: com.unity3d.ads.core.extensions.FlowExtensionsKt$timeoutAfter$1$2, reason: invalid class name */
    /* synthetic */ class AnonymousClass2 extends AdaptedFunctionReference implements Function0<Unit> {
        AnonymousClass2(Object obj) {
            super(0, obj, ProducerScope.class, "close", "close(Ljava/lang/Throwable;)Z", 8);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            SendChannel.DefaultImpls.close$default((ProducerScope) this.receiver, null, 1, null);
        }
    }
}
