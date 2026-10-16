package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad;

import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.l;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.x;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.b;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.d;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* loaded from: classes6.dex */
public final class f implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a {
    public static final int l = 8;

    /* renamed from: a, reason: collision with root package name */
    public final List<k> f6169a;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.h b;
    public final CoroutineScope c;
    public final MutableStateFlow<k> d;
    public final StateFlow<i.a> e;
    public final StateFlow<Boolean> f;
    public final Flow<Boolean> g;
    public final StateFlow<Boolean> h;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.c i;
    public final MutableSharedFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b> j;
    public final Flow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b> k;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.AdPlaylistControllerImpl$1", f = "AdPlaylistControllerImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.b, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6170a;
        public /* synthetic */ Object b;
        public final /* synthetic */ k d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(k kVar, Continuation<? super a> continuation) {
            super(2, continuation);
            this.d = kVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.b bVar, Continuation<? super Unit> continuation) {
            return ((a) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a aVar = f.this.new a(this.d, continuation);
            aVar.b = obj;
            return aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6170a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.b bVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.b) this.b;
            if (bVar instanceof b.d) {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.h hVar = f.this.b;
                if (hVar != null) {
                    hVar.a(x.j);
                }
                f.this.a(new b.f(((b.d) bVar).b()));
            } else if (bVar instanceof b.a) {
                f.this.a(b.a.b);
            } else if (bVar instanceof b.c) {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.h hVar2 = f.this.b;
                if (hVar2 != null) {
                    Boxing.boxBoolean(hVar2.b());
                }
                f.this.a(b.C0533b.b);
            } else {
                if (!(bVar instanceof b.C0540b)) {
                    throw new NoWhenBranchMatchedException();
                }
                ((k.a) this.d).a().destroy();
                Unit unit = Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.AdPlaylistControllerImpl$2", f = "AdPlaylistControllerImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.d, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6171a;
        public /* synthetic */ Object b;

        public b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.d dVar, Continuation<? super Unit> continuation) {
            return ((b) create(dVar, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            b bVar = f.this.new b(continuation);
            bVar.b = obj;
            return bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6171a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.d dVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.d) this.b;
            if (dVar instanceof d.C0558d) {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.h hVar = f.this.b;
                if (hVar != null) {
                    hVar.a(x.g);
                }
                f.this.a(new b.f(((d.C0558d) dVar).b()));
            } else if (Intrinsics.areEqual(dVar, d.a.b)) {
                f.this.a(b.a.b);
            } else if (Intrinsics.areEqual(dVar, d.e.b)) {
                f.this.a(b.i.b);
                f.this.T();
                Unit unit = Unit.INSTANCE;
            } else if (Intrinsics.areEqual(dVar, d.b.b)) {
                f.this.a(b.c.b);
                Boxing.boxBoolean(f.this.S());
            } else {
                if (!Intrinsics.areEqual(dVar, d.c.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.h hVar2 = f.this.b;
                if (hVar2 != null) {
                    Boxing.boxBoolean(hVar2.b());
                }
                f.this.a(b.g.b);
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.AdPlaylistControllerImpl$3", f = "AdPlaylistControllerImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.b, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6172a;
        public /* synthetic */ Object b;

        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f6173a;

            static {
                int[] iArr = new int[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.b.values().length];
                try {
                    iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.b.b.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.b.f6271a.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f6173a = iArr;
            }
        }

        public c(Continuation<? super c> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.b bVar, Continuation<? super Unit> continuation) {
            return ((c) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            c cVar = f.this.new c(continuation);
            cVar.b = obj;
            return cVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6172a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            int i = a.f6173a[((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.b) this.b).ordinal()];
            if (i == 1) {
                f.this.a(b.a.b);
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.h hVar = f.this.b;
                if (hVar != null) {
                    Boxing.boxBoolean(hVar.b());
                }
                f.this.a(b.d.b);
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.AdPlaylistControllerImpl$4", f = "AdPlaylistControllerImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<l, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6174a;
        public /* synthetic */ Object b;

        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f6175a;

            static {
                int[] iArr = new int[l.values().length];
                try {
                    iArr[l.f5903a.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[l.b.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f6175a = iArr;
            }
        }

        public d(Continuation<? super d> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(l lVar, Continuation<? super Unit> continuation) {
            return ((d) create(lVar, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            d dVar = f.this.new d(continuation);
            dVar.b = obj;
            return dVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6174a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            int i = a.f6175a[((l) this.b).ordinal()];
            if (i == 1) {
                f.this.a(b.i.b);
                f.this.T();
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                f.this.a(b.a.b);
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.AdPlaylistControllerImpl$canReplay$1", f = "AdPlaylistControllerImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends SuspendLambda implements Function3<k, Boolean, Continuation<? super Boolean>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6176a;
        public /* synthetic */ Object b;
        public /* synthetic */ Object c;

        public e(Continuation<? super e> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(k kVar, Boolean bool, Continuation<? super Boolean> continuation) {
            e eVar = f.this.new e(continuation);
            eVar.b = kVar;
            eVar.c = bool;
            return eVar.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x002d, code lost:
        
            if (kotlin.jvm.internal.Intrinsics.areEqual(r0, kotlin.coroutines.jvm.internal.Boxing.boxBoolean(true)) == false) goto L12;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6176a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            k kVar = (k) this.b;
            Boolean bool = (Boolean) this.c;
            boolean z = kVar != null && Intrinsics.areEqual(kVar, CollectionsKt.last(f.this.f6169a));
            return Boxing.boxBoolean(z);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.AdPlaylistControllerImpl$onEvent$1", f = "AdPlaylistControllerImpl.kt", i = {}, l = {239}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f$f, reason: collision with other inner class name */
    public static final class C0534f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6177a;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0534f(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b bVar, Continuation<? super C0534f> continuation) {
            super(2, continuation);
            this.c = bVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C0534f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return f.this.new C0534f(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6177a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableSharedFlow mutableSharedFlow = f.this.j;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b bVar = this.c;
                this.f6177a = 1;
                if (mutableSharedFlow.emit(bVar, this) == coroutine_suspended) {
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

    public static final class g implements Flow<i.a> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Flow f6178a;
        public final /* synthetic */ f b;

        public static final class a<T> implements FlowCollector {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ FlowCollector f6179a;
            public final /* synthetic */ f b;

            @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.AdPlaylistControllerImpl$special$$inlined$map$1$2", f = "AdPlaylistControllerImpl.kt", i = {}, l = {50}, m = "emit", n = {}, s = {})
            /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f$g$a$a, reason: collision with other inner class name */
            public static final class C0535a extends ContinuationImpl {

                /* renamed from: a, reason: collision with root package name */
                public /* synthetic */ Object f6180a;
                public int b;
                public Object c;

                public C0535a(Continuation continuation) {
                    super(continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.f6180a = obj;
                    this.b |= Integer.MIN_VALUE;
                    return a.this.emit(null, this);
                }
            }

            public a(FlowCollector flowCollector, f fVar) {
                this.f6179a = flowCollector;
                this.b = fVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
            /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object emit(Object obj, Continuation continuation) {
                C0535a c0535a;
                int i;
                Object obj2;
                if (continuation instanceof C0535a) {
                    c0535a = (C0535a) continuation;
                    int i2 = c0535a.b;
                    if ((i2 & Integer.MIN_VALUE) != 0) {
                        c0535a.b = i2 - Integer.MIN_VALUE;
                        Object obj3 = c0535a.f6180a;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = c0535a.b;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj3);
                            FlowCollector flowCollector = this.f6179a;
                            k kVar = (k) obj;
                            boolean areEqual = Intrinsics.areEqual(CollectionsKt.lastOrNull(this.b.f6169a), kVar);
                            if (kVar instanceof k.a) {
                                obj2 = new i.a.C0539a(((k.a) kVar).a(), areEqual);
                            } else if (kVar instanceof k.c) {
                                obj2 = new i.a.c(((k.c) kVar).a(), areEqual);
                            } else if (kVar instanceof k.b) {
                                obj2 = new i.a.b(((k.b) kVar).a(), areEqual);
                            } else if (kVar instanceof k.d) {
                                obj2 = new i.a.d(((k.d) kVar).a(), areEqual);
                            } else {
                                if (kVar != null) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                obj2 = null;
                            }
                            c0535a.b = 1;
                            if (flowCollector.emit(obj2, c0535a) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj3);
                        }
                        return Unit.INSTANCE;
                    }
                }
                c0535a = new C0535a(continuation);
                Object obj32 = c0535a.f6180a;
                Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = c0535a.b;
                if (i != 0) {
                }
                return Unit.INSTANCE;
            }
        }

        public g(Flow flow, f fVar) {
            this.f6178a = flow;
            this.b = fVar;
        }

        @Override // kotlinx.coroutines.flow.Flow
        public Object collect(FlowCollector<? super i.a> flowCollector, Continuation continuation) {
            Object collect = this.f6178a.collect(new a(flowCollector, this.b), continuation);
            return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
        }
    }

    public static final class h implements Flow<Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Flow f6181a;

        public static final class a<T> implements FlowCollector {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ FlowCollector f6182a;

            @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.AdPlaylistControllerImpl$special$$inlined$map$2$2", f = "AdPlaylistControllerImpl.kt", i = {}, l = {50}, m = "emit", n = {}, s = {})
            /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f$h$a$a, reason: collision with other inner class name */
            public static final class C0536a extends ContinuationImpl {

                /* renamed from: a, reason: collision with root package name */
                public /* synthetic */ Object f6183a;
                public int b;
                public Object c;

                public C0536a(Continuation continuation) {
                    super(continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.f6183a = obj;
                    this.b |= Integer.MIN_VALUE;
                    return a.this.emit(null, this);
                }
            }

            public a(FlowCollector flowCollector) {
                this.f6182a = flowCollector;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
            /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object emit(Object obj, Continuation continuation) {
                C0536a c0536a;
                int i;
                boolean z;
                if (continuation instanceof C0536a) {
                    c0536a = (C0536a) continuation;
                    int i2 = c0536a.b;
                    if ((i2 & Integer.MIN_VALUE) != 0) {
                        c0536a.b = i2 - Integer.MIN_VALUE;
                        Object obj2 = c0536a.f6183a;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = c0536a.b;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj2);
                            FlowCollector flowCollector = this.f6182a;
                            k kVar = (k) obj;
                            if (kVar instanceof k.a) {
                                z = ((k.a) kVar).a().K();
                            } else if (kVar instanceof k.c) {
                                z = ((k.c) kVar).a().K();
                            } else {
                                if (!(kVar instanceof k.b) && !(kVar instanceof k.d) && kVar != null) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                z = false;
                            }
                            Boolean boxBoolean = Boxing.boxBoolean(z);
                            c0536a.b = 1;
                            if (flowCollector.emit(boxBoolean, c0536a) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj2);
                        }
                        return Unit.INSTANCE;
                    }
                }
                c0536a = new C0536a(continuation);
                Object obj22 = c0536a.f6183a;
                Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = c0536a.b;
                if (i != 0) {
                }
                return Unit.INSTANCE;
            }
        }

        public h(Flow flow) {
            this.f6181a = flow;
        }

        @Override // kotlinx.coroutines.flow.Flow
        public Object collect(FlowCollector<? super Boolean> flowCollector, Continuation continuation) {
            Object collect = this.f6181a.collect(new a(flowCollector), continuation);
            return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(List<? extends k> playlist, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.h hVar) {
        Flow<Boolean> b2;
        Flow onEach;
        Intrinsics.checkNotNullParameter(playlist, "playlist");
        this.f6169a = playlist;
        this.b = hVar;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getMain());
        this.c = CoroutineScope;
        MutableStateFlow<k> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this.d = MutableStateFlow;
        g gVar = new g(MutableStateFlow, this);
        SharingStarted.Companion companion = SharingStarted.INSTANCE;
        this.e = FlowKt.stateIn(gVar, CoroutineScope, SharingStarted.Companion.WhileSubscribed$default(companion, 0L, 0L, 3, null), null);
        h hVar2 = new h(MutableStateFlow);
        SharingStarted WhileSubscribed$default = SharingStarted.Companion.WhileSubscribed$default(companion, 0L, 0L, 3, null);
        Boolean bool = Boolean.FALSE;
        this.f = FlowKt.stateIn(hVar2, CoroutineScope, WhileSubscribed$default, bool);
        b2 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.b((Flow<? extends k>) MutableStateFlow, CoroutineScope);
        this.g = b2;
        this.h = FlowKt.stateIn(FlowKt.combine(MutableStateFlow, b2, new e(null)), CoroutineScope, SharingStarted.Companion.WhileSubscribed$default(companion, 0L, 0L, 3, null), bool);
        this.i = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.e.a(MutableStateFlow, CoroutineScope);
        MutableSharedFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.j = MutableSharedFlow$default;
        this.k = MutableSharedFlow$default;
        for (k kVar : playlist) {
            if (kVar instanceof k.a) {
                onEach = FlowKt.onEach(((k.a) kVar).a().a(), new a(kVar, null));
            } else if (kVar instanceof k.c) {
                onEach = FlowKt.onEach(((k.c) kVar).a().a(), new b(null));
            } else if (kVar instanceof k.b) {
                onEach = FlowKt.onEach(((k.b) kVar).a().a(), new c(null));
            } else {
                if (!(kVar instanceof k.d)) {
                    throw new NoWhenBranchMatchedException();
                }
                onEach = FlowKt.onEach(((k.d) kVar).a().a(), new d(null));
            }
            FlowKt.launchIn(onEach, this.c);
        }
    }

    public static Object f(f fVar) {
        return Reflection.property0(new PropertyReference0Impl(fVar.i, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.c.class, "goNextAction", "getGoNextAction()Lkotlinx/coroutines/flow/StateFlow;", 0));
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i
    public void B() {
        K();
        a(b.h.b);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i
    public void C() {
        k value = this.d.getValue();
        if (value instanceof k.a) {
            ((k.a) value).a().b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.f.a());
            return;
        }
        if (value instanceof k.c) {
            ((k.c) value).a().b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.f.a());
            return;
        }
        if (value instanceof k.b) {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.f6184a, "Empty CTA DEC playlist item reached", null, false, 12, null);
        } else if (value instanceof k.d) {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.f6184a, "Empty CTA Mraid playlist item reached", null, false, 12, null);
        } else {
            if (value != null) {
                throw new NoWhenBranchMatchedException();
            }
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.f6184a, "Empty CTA playlist item reached", null, false, 12, null);
        }
    }

    public final void K() {
        k kVar = (k) CollectionsKt.firstOrNull((List) this.f6169a);
        if (kVar == null) {
            return;
        }
        a(kVar);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i
    public StateFlow<Boolean> P() {
        return this.h;
    }

    public final boolean S() {
        List<k> list = this.f6169a;
        k kVar = (k) CollectionsKt.getOrNull(list, CollectionsKt.indexOf((List<? extends k>) list, this.d.getValue()) + 1);
        if (kVar == null) {
            return false;
        }
        a(kVar);
        return true;
    }

    public final void T() {
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.a b2;
        b2 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.b((List<? extends k>) this.f6169a, this.d.getValue());
        if (b2 != null) {
            b2.u();
        }
        if (S()) {
            return;
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.h hVar = this.b;
        if (hVar != null) {
            hVar.a();
        }
        a(b.e.b);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k
    public void destroy() {
        CoroutineScopeKt.cancel$default(this.c, null, 1, null);
        for (k kVar : this.f6169a) {
            if (kVar instanceof k.a) {
                ((k.a) kVar).a().destroy();
            } else if (kVar instanceof k.c) {
                ((k.c) kVar).a().destroy();
            } else if (kVar instanceof k.b) {
                ((k.b) kVar).a().destroy();
            } else {
                if (!(kVar instanceof k.d)) {
                    throw new NoWhenBranchMatchedException();
                }
                ((k.d) kVar).a().destroy();
            }
        }
        a((k) null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i
    public StateFlow<i.a> k() {
        return this.e;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d
    public StateFlow<d.a> m() {
        return this.i.m();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i
    public StateFlow<Boolean> o() {
        return this.f;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i
    public void y() {
        if (m().getValue() instanceof d.a.C0557a) {
            k value = this.d.getValue();
            k.c cVar = value instanceof k.c ? (k.c) value : null;
            if (cVar != null) {
                cVar.a().h();
            } else {
                T();
            }
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a
    public void d() {
        K();
    }

    public final void a(k kVar) {
        this.d.setValue(kVar);
        if (kVar instanceof k.c) {
            ((k.c) kVar).a().s();
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a
    public Flow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b> a() {
        return this.k;
    }

    public final Job a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b bVar) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.c, null, null, new C0534f(bVar, null), 3, null);
        return launch$default;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.g
    public void a(a.AbstractC0571a.c button) {
        a.AbstractC0571a.c b2;
        Intrinsics.checkNotNullParameter(button, "button");
        b2 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.b((List<? extends k>) this.f6169a, this.d.getValue(), button);
        k value = this.d.getValue();
        if (value instanceof k.c) {
            ((k.c) value).a().a(b2);
            return;
        }
        if (value instanceof k.a) {
            ((k.a) value).a().a(b2);
            return;
        }
        if (value instanceof k.b) {
            ((k.b) value).a().a(b2);
        } else if (value instanceof k.d) {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.f6184a, "Empty onButtonRendered MRAID playlist item reached", null, false, 12, null);
        } else {
            if (value == null) {
                MolocoLogger.warn$default(MolocoLogger.INSTANCE, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.f6184a, "Displaying " + b2.d() + " at position: " + b2.e() + " of size: " + b2.f() + " in unknown playlist item type", null, false, 12, null);
                return;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.g
    public void a(a.AbstractC0571a.c.EnumC0573a buttonType) {
        a.AbstractC0571a.c.EnumC0573a b2;
        Intrinsics.checkNotNullParameter(buttonType, "buttonType");
        b2 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.b((List<? extends k>) this.f6169a, this.d.getValue(), buttonType);
        k value = this.d.getValue();
        if (value instanceof k.c) {
            ((k.c) value).a().a(b2);
            return;
        }
        if (value instanceof k.a) {
            ((k.a) value).a().a(b2);
            return;
        }
        if (value instanceof k.b) {
            ((k.b) value).a().a(b2);
        } else if (value instanceof k.d) {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.f6184a, "Empty onButtonUnRendered MRAID playlist item reached", null, false, 12, null);
        } else {
            if (value == null) {
                MolocoLogger.warn$default(MolocoLogger.INSTANCE, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.f6184a, "Unrendering " + b2 + " in unknown playlist item type", null, false, 12, null);
                return;
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
