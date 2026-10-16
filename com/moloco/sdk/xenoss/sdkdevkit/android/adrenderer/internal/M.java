package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.graphics.Rect;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.M;
import com.vungle.ads.internal.protos.Sdk;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* loaded from: classes6.dex */
public final class M {

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ViewVisibilityTrackerKt$collectLatestIsAttachedWindow$2", f = "ViewVisibilityTracker.kt", i = {}, l = {46, 49}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5800a;
        public /* synthetic */ boolean b;
        public final /* synthetic */ ProducerScope<Boolean> c;
        public final /* synthetic */ View d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(ProducerScope<? super Boolean> producerScope, View view, Continuation<? super a> continuation) {
            super(2, continuation);
            this.c = producerScope;
            this.d = view;
        }

        public final Object a(boolean z, Continuation<? super Unit> continuation) {
            return ((a) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a aVar = new a(this.c, this.d, continuation);
            aVar.b = ((Boolean) obj).booleanValue();
            return aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
            return a(bool.booleanValue(), continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:
        
            if (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.M.f(r5, r1, r4) == r0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x003e, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x003c, code lost:
        
            if (r5.send(r1, r4) == r0) goto L17;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5800a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.b) {
                    ProducerScope<Boolean> producerScope = this.c;
                    View view = this.d;
                    this.f5800a = 1;
                } else {
                    ProducerScope<Boolean> producerScope2 = this.c;
                    Boolean boxBoolean = Boxing.boxBoolean(false);
                    this.f5800a = 2;
                }
            } else {
                if (i != 1 && i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ViewVisibilityTrackerKt$collectLatestIsEnoughAreaVisible$2", f = "ViewVisibilityTracker.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5801a;
        public /* synthetic */ boolean b;
        public final /* synthetic */ ProducerScope<Boolean> c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(ProducerScope<? super Boolean> producerScope, Continuation<? super b> continuation) {
            super(2, continuation);
            this.c = producerScope;
        }

        public final Object a(boolean z, Continuation<? super Unit> continuation) {
            return ((b) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            b bVar = new b(this.c, continuation);
            bVar.b = ((Boolean) obj).booleanValue();
            return bVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
            return a(bool.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5801a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                boolean z = this.b;
                ProducerScope<Boolean> producerScope = this.c;
                Boolean boxBoolean = Boxing.boxBoolean(z);
                this.f5801a = 1;
                if (producerScope.send(boxBoolean, this) == coroutine_suspended) {
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
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ViewVisibilityTrackerKt$collectLatestIsLifecycleResumed$2", f = "ViewVisibilityTracker.kt", i = {}, l = {59, 62}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5802a;
        public /* synthetic */ Object b;
        public final /* synthetic */ ProducerScope<Boolean> c;
        public final /* synthetic */ View d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(ProducerScope<? super Boolean> producerScope, View view, Continuation<? super c> continuation) {
            super(2, continuation);
            this.c = producerScope;
            this.d = view;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
            return ((c) create(bool, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            c cVar = new c(this.c, this.d, continuation);
            cVar.b = obj;
            return cVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0037, code lost:
        
            if (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.M.e(r6, r1, r5) == r0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0048, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0046, code lost:
        
            if (r6.send(r1, r5) == r0) goto L17;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5802a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (Intrinsics.areEqual((Boolean) this.b, Boxing.boxBoolean(false))) {
                    ProducerScope<Boolean> producerScope = this.c;
                    Boolean boxBoolean = Boxing.boxBoolean(false);
                    this.f5802a = 2;
                } else {
                    ProducerScope<Boolean> producerScope2 = this.c;
                    View view = this.d;
                    this.f5802a = 1;
                }
            } else {
                if (i != 1 && i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ViewVisibilityTrackerKt$isAttachedToWindowFlow$1", f = "ViewVisibilityTracker.kt", i = {0}, l = {75, 91}, m = "invokeSuspend", n = {"$this$callbackFlow"}, s = {"L$0"})
    public static final class d extends SuspendLambda implements Function2<ProducerScope<? super Boolean>, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5803a;
        public /* synthetic */ Object b;
        public final /* synthetic */ View c;

        public static final class a implements View.OnAttachStateChangeListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ProducerScope<Boolean> f5804a;

            /* JADX WARN: Multi-variable type inference failed */
            public a(ProducerScope<? super Boolean> producerScope) {
                this.f5804a = producerScope;
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View p0) {
                Intrinsics.checkNotNullParameter(p0, "p0");
                this.f5804a.mo11746trySendJP2dKIU(Boolean.TRUE);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View p0) {
                Intrinsics.checkNotNullParameter(p0, "p0");
                this.f5804a.mo11746trySendJP2dKIU(Boolean.FALSE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(View view, Continuation<? super d> continuation) {
            super(2, continuation);
            this.c = view;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(ProducerScope<? super Boolean> producerScope, Continuation<? super Unit> continuation) {
            return ((d) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            d dVar = new d(this.c, continuation);
            dVar.b = obj;
            return dVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0059, code lost:
        
            if (kotlinx.coroutines.channels.ProduceKt.awaitClose(r1, r4, r5) == r0) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x005b, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x003c, code lost:
        
            if (r1.send(r6, r5) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            ProducerScope producerScope;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5803a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                producerScope = (ProducerScope) this.b;
                Boolean boxBoolean = Boxing.boxBoolean(this.c.isAttachedToWindow());
                this.b = producerScope;
                this.f5803a = 1;
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                producerScope = (ProducerScope) this.b;
                ResultKt.throwOnFailure(obj);
            }
            final a aVar = new a(producerScope);
            this.c.addOnAttachStateChangeListener(aVar);
            final View view = this.c;
            Function0 function0 = new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.M$d$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return M.d.a(view, aVar);
                }
            };
            this.b = null;
            this.f5803a = 2;
        }

        public static final Unit a(View view, a aVar) {
            view.removeOnAttachStateChangeListener(aVar);
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ViewVisibilityTrackerKt$isEnoughAreaVisibleFlow$1", f = "ViewVisibilityTracker.kt", i = {0, 0, 1, 1}, l = {Sdk.SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE, 134}, m = "invokeSuspend", n = {"$this$flow", "rect", "$this$flow", "rect"}, s = {"L$0", "L$1", "L$0", "L$1"})
    public static final class e extends SuspendLambda implements Function2<FlowCollector<? super Boolean>, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public Object f5805a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ View d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(View view, Continuation<? super e> continuation) {
            super(2, continuation);
            this.d = view;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(FlowCollector<? super Boolean> flowCollector, Continuation<? super Unit> continuation) {
            return ((e) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            e eVar = new e(this.d, continuation);
            eVar.c = obj;
            return eVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x005d, code lost:
        
            if (r5.emit(r9, r8) == r0) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x006c, code lost:
        
            if (kotlinx.coroutines.DelayKt.delay(500, r8) == r0) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x006e, code lost:
        
            return r0;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x006c -> B:6:0x003c). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            FlowCollector flowCollector;
            Rect rect;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                flowCollector = (FlowCollector) this.c;
                rect = new Rect(0, 0, 0, 0);
            } else if (i == 1) {
                rect = (Rect) this.f5805a;
                flowCollector = (FlowCollector) this.c;
                ResultKt.throwOnFailure(obj);
                this.c = flowCollector;
                this.f5805a = rect;
                this.b = 2;
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                rect = (Rect) this.f5805a;
                flowCollector = (FlowCollector) this.c;
                ResultKt.throwOnFailure(obj);
            }
            Boolean boxBoolean = Boxing.boxBoolean(this.d.isShown() && this.d.getGlobalVisibleRect(rect));
            this.c = flowCollector;
            this.f5805a = rect;
            this.b = 1;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ViewVisibilityTrackerKt$isLifecycleResumedFlow$1", f = "ViewVisibilityTracker.kt", i = {}, l = {Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE}, m = "invokeSuspend", n = {}, s = {})
    public static final class f extends SuspendLambda implements Function2<ProducerScope<? super Boolean>, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5806a;
        public /* synthetic */ Object b;
        public final /* synthetic */ Lifecycle c;

        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f5807a;

            static {
                int[] iArr = new int[Lifecycle.Event.values().length];
                try {
                    iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f5807a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Lifecycle lifecycle, Continuation<? super f> continuation) {
            super(2, continuation);
            this.c = lifecycle;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(ProducerScope<? super Boolean> producerScope, Continuation<? super Unit> continuation) {
            return ((f) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            f fVar = new f(this.c, continuation);
            fVar.b = obj;
            return fVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5806a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final ProducerScope producerScope = (ProducerScope) this.b;
                final LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.M$f$$ExternalSyntheticLambda0
                    @Override // androidx.lifecycle.LifecycleEventObserver
                    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                        M.f.a(ProducerScope.this, lifecycleOwner, event);
                    }
                };
                this.c.addObserver(lifecycleEventObserver);
                final Lifecycle lifecycle = this.c;
                Function0 function0 = new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.M$f$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return M.f.a(Lifecycle.this, lifecycleEventObserver);
                    }
                };
                this.f5806a = 1;
                if (ProduceKt.awaitClose(producerScope, function0, this) == coroutine_suspended) {
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

        public static final void a(ProducerScope producerScope, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            int i = a.f5807a[event.ordinal()];
            if (i == 1) {
                ChannelResult.m11761boximpl(producerScope.mo11746trySendJP2dKIU(Boolean.FALSE));
            } else if (i != 2) {
                Unit unit = Unit.INSTANCE;
            } else {
                ChannelResult.m11761boximpl(producerScope.mo11746trySendJP2dKIU(Boolean.TRUE));
            }
        }

        public static final Unit a(Lifecycle lifecycle, LifecycleEventObserver lifecycleEventObserver) {
            lifecycle.removeObserver(lifecycleEventObserver);
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ViewVisibilityTrackerKt$isLifecycleResumedFlow$lifecycle$1", f = "ViewVisibilityTracker.kt", i = {}, l = {102}, m = "invokeSuspend", n = {}, s = {})
    public static final class g extends SuspendLambda implements Function2<FlowCollector<? super Boolean>, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5808a;
        public /* synthetic */ Object b;

        public g(Continuation<? super g> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(FlowCollector<? super Boolean> flowCollector, Continuation<? super Unit> continuation) {
            return ((g) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            g gVar = new g(continuation);
            gVar.b = obj;
            return gVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5808a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector = (FlowCollector) this.b;
                this.f5808a = 1;
                if (flowCollector.emit(null, this) == coroutine_suspended) {
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
    }

    public static final Object d(ProducerScope<? super Boolean> producerScope, View view, Continuation<? super Unit> continuation) {
        Object collectLatest = FlowKt.collectLatest(a(view), new a(producerScope, view, null), continuation);
        return collectLatest == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collectLatest : Unit.INSTANCE;
    }

    public static final Object e(ProducerScope<? super Boolean> producerScope, View view, Continuation<? super Unit> continuation) {
        Object collectLatest = FlowKt.collectLatest(b(view), new b(producerScope, null), continuation);
        return collectLatest == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collectLatest : Unit.INSTANCE;
    }

    public static final Object f(ProducerScope<? super Boolean> producerScope, View view, Continuation<? super Unit> continuation) {
        Object collectLatest = FlowKt.collectLatest(a(ViewTreeLifecycleOwner.get(view)), new c(producerScope, view, null), continuation);
        return collectLatest == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collectLatest : Unit.INSTANCE;
    }

    public static final Flow<Boolean> b(View view) {
        return b(FlowKt.flow(new e(view, null)));
    }

    public static final Flow<Boolean> a(View view) {
        return b(FlowKt.callbackFlow(new d(view, null)));
    }

    public static final <T> Flow<T> b(Flow<? extends T> flow) {
        return FlowKt.flowOn(FlowKt.distinctUntilChanged(FlowKt.conflate(flow)), com.moloco.sdk.internal.scheduling.b.a().getMain());
    }

    public static final Flow<Boolean> a(LifecycleOwner lifecycleOwner) {
        Lifecycle lifecycle;
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            return b(FlowKt.callbackFlow(new f(lifecycle, null)));
        }
        return FlowKt.flow(new g(null));
    }
}
