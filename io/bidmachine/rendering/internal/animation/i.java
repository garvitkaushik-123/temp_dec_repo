package io.bidmachine.rendering.internal.animation;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.rendering.internal.InterfaceC3590c;
import io.bidmachine.rendering.model.AnimationEventType;
import io.bidmachine.util.ViewUtilsKt;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\b*\u00020\bH\u0082@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\t\u001a\u0004\u0018\u00010\b*\u00020\u000bH\u0082@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\fJ\u0019\u0010\t\u001a\u0004\u0018\u00010\b*\u00020\rH\u0082@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u000eJ\u0017\u0010\t\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\t\u0010\u0012J'\u0010\t\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\t\u0010\u0018J\u001f\u0010\t\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\t\u0010\u001aJ3\u0010\t\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0011H\u0096@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u001fJG\u0010\t\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u00112\u000e\u0010#\u001a\n\u0018\u00010!j\u0004\u0018\u0001`\"2\u000e\u0010$\u001a\n\u0018\u00010!j\u0004\u0018\u0001`\"H\u0016¢\u0006\u0004\b\t\u0010%JS\u0010&\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00112\u000e\u0010#\u001a\n\u0018\u00010!j\u0004\u0018\u0001`\"2\u000e\u0010$\u001a\n\u0018\u00010!j\u0004\u0018\u0001`\"H\u0096@ø\u0001\u0000¢\u0006\u0004\b&\u0010'JG\u0010&\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u00112\u000e\u0010#\u001a\n\u0018\u00010!j\u0004\u0018\u0001`\"2\u000e\u0010$\u001a\n\u0018\u00010!j\u0004\u0018\u0001`\"H\u0016¢\u0006\u0004\b&\u0010%JG\u0010\t\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u00112\u000e\u0010#\u001a\n\u0018\u00010!j\u0004\u0018\u0001`\"2\u000e\u0010$\u001a\n\u0018\u00010!j\u0004\u0018\u0001`\"H\u0016¢\u0006\u0004\b\t\u0010(JS\u0010\t\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00112\u000e\u0010#\u001a\n\u0018\u00010!j\u0004\u0018\u0001`\"2\u000e\u0010$\u001a\n\u0018\u00010!j\u0004\u0018\u0001`\"H\u0096@ø\u0001\u0000¢\u0006\u0004\b\t\u0010'J\u0017\u0010\t\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\t\u0010)J\u0017\u0010\t\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\rH\u0016¢\u0006\u0004\b\t\u0010*J\u001b\u0010&\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\bH\u0096@ø\u0001\u0000¢\u0006\u0004\b&\u0010\nJ\u000f\u0010\t\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\t\u0010+R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010,R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010-R \u00101\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u001c0.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100\u0082\u0002\u0004\n\u0002\b\u0019¨\u00062"}, d2 = {"Lio/bidmachine/rendering/internal/animation/i;", "Lio/bidmachine/rendering/internal/animation/b;", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lio/bidmachine/rendering/internal/h;", "coroutineDispatchers", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Lio/bidmachine/rendering/internal/h;)V", "Landroid/view/View;", "a", "(Landroid/view/View;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/bidmachine/rendering/internal/c;", "(Lio/bidmachine/rendering/internal/c;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/bidmachine/rendering/internal/d;", "(Lio/bidmachine/rendering/internal/d;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "id", "", "(I)Z", "adElement", "allowPostponed", "Lio/bidmachine/rendering/model/AnimationEventType;", "eventType", "", "(Lio/bidmachine/rendering/internal/c;ZLio/bidmachine/rendering/model/AnimationEventType;)V", "adPhase", "(Lio/bidmachine/rendering/internal/d;Lio/bidmachine/rendering/model/AnimationEventType;)V", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Lio/bidmachine/rendering/internal/animation/a;", "animation", "requiresLaidOut", "(Landroid/view/View;Lio/bidmachine/rendering/internal/animation/a;Lio/bidmachine/rendering/model/AnimationEventType;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "skip", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "onStart", "onEnd", "(Lio/bidmachine/rendering/internal/c;Lio/bidmachine/rendering/model/AnimationEventType;ZLjava/lang/Runnable;Ljava/lang/Runnable;)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Landroid/view/View;Lio/bidmachine/rendering/model/AnimationEventType;ZZLjava/lang/Runnable;Ljava/lang/Runnable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lio/bidmachine/rendering/internal/d;Lio/bidmachine/rendering/model/AnimationEventType;ZLjava/lang/Runnable;Ljava/lang/Runnable;)V", "(Lio/bidmachine/rendering/internal/c;)V", "(Lio/bidmachine/rendering/internal/d;)V", "()V", "Lkotlinx/coroutines/CoroutineScope;", "Lio/bidmachine/rendering/internal/h;", "", "c", "Ljava/util/Map;", "animations", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class i implements io.bidmachine.rendering.internal.animation.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final CoroutineScope coroutineScope;

    /* renamed from: b, reason: from kotlin metadata */
    private final io.bidmachine.rendering.internal.h coroutineDispatchers;

    /* renamed from: c, reason: from kotlin metadata */
    private final Map<Integer, io.bidmachine.rendering.internal.animation.a> animations;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.bidmachine.rendering.internal.animation.DefaultAdAnimationController$addAndPrepare$1", f = "DefaultAdAnimationController.kt", i = {}, l = {32, 35}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f6970a;
        final /* synthetic */ InterfaceC3590c c;
        final /* synthetic */ boolean d;
        final /* synthetic */ AnimationEventType e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC3590c interfaceC3590c, boolean z, AnimationEventType animationEventType, Continuation<? super a> continuation) {
            super(2, continuation);
            this.c = interfaceC3590c;
            this.d = z;
            this.e = animationEventType;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return i.this.new a(this.c, this.d, this.e, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x004e, code lost:
        
            if (r3.a(r4, r5, r6, r7, r9) == r0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0050, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x002b, code lost:
        
            if (r10 == r0) goto L17;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6970a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                i iVar = i.this;
                InterfaceC3590c interfaceC3590c = this.c;
                this.f6970a = 1;
                obj = iVar.a(interfaceC3590c, this);
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            View view = (View) obj;
            if (view != null) {
                InterfaceC3590c interfaceC3590c2 = this.c;
                boolean z = this.d;
                i iVar2 = i.this;
                AnimationEventType animationEventType = this.e;
                io.bidmachine.rendering.internal.animation.a a2 = io.bidmachine.rendering.internal.animation.d.a(interfaceC3590c2.getAdElementParams(), z);
                boolean lastAcceptedVisible = interfaceC3590c2.getLastAcceptedVisible();
                this.f6970a = 2;
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.bidmachine.rendering.internal.animation.DefaultAdAnimationController$addAndPrepare$2", f = "DefaultAdAnimationController.kt", i = {}, l = {45, 48}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f6971a;
        final /* synthetic */ io.bidmachine.rendering.internal.d c;
        final /* synthetic */ AnimationEventType d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(io.bidmachine.rendering.internal.d dVar, AnimationEventType animationEventType, Continuation<? super b> continuation) {
            super(2, continuation);
            this.c = dVar;
            this.d = animationEventType;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return i.this.new b(this.c, this.d, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0049, code lost:
        
            if (r3.a(r4, r5, r6, true, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r9) == r0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x004b, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x002b, code lost:
        
            if (r10 == r0) goto L17;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6971a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                i iVar = i.this;
                io.bidmachine.rendering.internal.d dVar = this.c;
                this.f6971a = 1;
                obj = iVar.a(dVar, this);
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            View view = (View) obj;
            if (view != null) {
                io.bidmachine.rendering.internal.d dVar2 = this.c;
                i iVar2 = i.this;
                AnimationEventType animationEventType = this.d;
                io.bidmachine.rendering.internal.animation.a a2 = io.bidmachine.rendering.internal.animation.d.a(dVar2.getAdPhaseParams());
                this.f6971a = 2;
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.bidmachine.rendering.internal.animation.DefaultAdAnimationController", f = "DefaultAdAnimationController.kt", i = {0, 0, 0}, l = {61}, m = "addAndPrepare", n = {MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "animation", "eventType"}, s = {"L$0", "L$1", "L$2"})
    static final class c extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f6972a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return i.this.a((View) null, (io.bidmachine.rendering.internal.animation.a) null, (AnimationEventType) null, false, (Continuation<? super Unit>) this);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.bidmachine.rendering.internal.animation.DefaultAdAnimationController$animate$1", f = "DefaultAdAnimationController.kt", i = {}, l = {101, 102}, m = "invokeSuspend", n = {}, s = {})
    static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f6973a;
        final /* synthetic */ InterfaceC3590c c;
        final /* synthetic */ AnimationEventType d;
        final /* synthetic */ boolean e;
        final /* synthetic */ Runnable f;
        final /* synthetic */ Runnable g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(InterfaceC3590c interfaceC3590c, AnimationEventType animationEventType, boolean z, Runnable runnable, Runnable runnable2, Continuation<? super d> continuation) {
            super(2, continuation);
            this.c = interfaceC3590c;
            this.d = animationEventType;
            this.e = z;
            this.f = runnable;
            this.g = runnable2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return i.this.new d(this.c, this.d, this.e, this.f, this.g, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x004a, code lost:
        
            if (r3.a(r4, r5, r6, r7, r8, r9, r11) == r0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x004c, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x002b, code lost:
        
            if (r12 == r0) goto L17;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6973a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                i iVar = i.this;
                InterfaceC3590c interfaceC3590c = this.c;
                this.f6973a = 1;
                obj = iVar.a(interfaceC3590c, this);
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            View view = (View) obj;
            if (view != null) {
                i iVar2 = i.this;
                AnimationEventType animationEventType = this.d;
                boolean z = this.e;
                InterfaceC3590c interfaceC3590c2 = this.c;
                Runnable runnable = this.f;
                Runnable runnable2 = this.g;
                boolean lastAcceptedVisible = interfaceC3590c2.getLastAcceptedVisible();
                this.f6973a = 2;
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.bidmachine.rendering.internal.animation.DefaultAdAnimationController$animate$2", f = "DefaultAdAnimationController.kt", i = {}, l = {114, 115}, m = "invokeSuspend", n = {}, s = {})
    static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f6974a;
        final /* synthetic */ io.bidmachine.rendering.internal.d c;
        final /* synthetic */ AnimationEventType d;
        final /* synthetic */ boolean e;
        final /* synthetic */ Runnable f;
        final /* synthetic */ Runnable g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(io.bidmachine.rendering.internal.d dVar, AnimationEventType animationEventType, boolean z, Runnable runnable, Runnable runnable2, Continuation<? super e> continuation) {
            super(2, continuation);
            this.c = dVar;
            this.d = animationEventType;
            this.e = z;
            this.f = runnable;
            this.g = runnable2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((e) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return i.this.new e(this.c, this.d, this.e, this.f, this.g, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0045, code lost:
        
            if (r3.a(r4, r5, r6, true, r8, r9, r11) == r0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0047, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x002b, code lost:
        
            if (r12 == r0) goto L17;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6974a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                i iVar = i.this;
                io.bidmachine.rendering.internal.d dVar = this.c;
                this.f6974a = 1;
                obj = iVar.a(dVar, this);
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            View view = (View) obj;
            if (view != null) {
                i iVar2 = i.this;
                AnimationEventType animationEventType = this.d;
                boolean z = this.e;
                Runnable runnable = this.f;
                Runnable runnable2 = this.g;
                this.f6974a = 2;
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.bidmachine.rendering.internal.animation.DefaultAdAnimationController", f = "DefaultAdAnimationController.kt", i = {0, 0, 0, 0, 0, 0}, l = {199}, m = "animate", n = {MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "eventType", "onStart", "onEnd", "animation$iv", "skip"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0"})
    static final class f extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f6975a;
        Object b;
        Object c;
        Object d;
        Object e;
        boolean f;
        /* synthetic */ Object g;
        int i;

        f(Continuation<? super f> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.g = obj;
            this.i |= Integer.MIN_VALUE;
            return i.this.a(null, null, false, false, null, null, this);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Landroid/view/View;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.bidmachine.rendering.internal.animation.DefaultAdAnimationController$awaitLayoutImmediate$2", f = "DefaultAdAnimationController.kt", i = {}, l = {179}, m = "invokeSuspend", n = {}, s = {})
    static final class g extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super View>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f6976a;
        final /* synthetic */ View b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(View view, Continuation<? super g> continuation) {
            super(2, continuation);
            this.b = view;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super View> continuation) {
            return ((g) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new g(this.b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6976a;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            View view = this.b;
            this.f6976a = 1;
            Object awaitLayout = ViewUtilsKt.awaitLayout(view, this);
            return awaitLayout == coroutine_suspended ? coroutine_suspended : awaitLayout;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Landroid/view/View;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.bidmachine.rendering.internal.animation.DefaultAdAnimationController$getViewImmediate$2", f = "DefaultAdAnimationController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class h extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super View>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f6977a;
        final /* synthetic */ InterfaceC3590c b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(InterfaceC3590c interfaceC3590c, Continuation<? super h> continuation) {
            super(2, continuation);
            this.b = interfaceC3590c;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super View> continuation) {
            return ((h) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new h(this.b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6977a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return this.b.j();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Landroid/view/ViewGroup;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.bidmachine.rendering.internal.animation.DefaultAdAnimationController$getViewImmediate$4", f = "DefaultAdAnimationController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: io.bidmachine.rendering.internal.animation.i$i, reason: collision with other inner class name */
    static final class C0614i extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ViewGroup>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f6978a;
        final /* synthetic */ io.bidmachine.rendering.internal.d b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0614i(io.bidmachine.rendering.internal.d dVar, Continuation<? super C0614i> continuation) {
            super(2, continuation);
            this.b = dVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ViewGroup> continuation) {
            return ((C0614i) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C0614i(this.b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6978a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return this.b.getCom.mbridge.msdk.MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW java.lang.String();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.bidmachine.rendering.internal.animation.DefaultAdAnimationController$prepareAndAnimate$1", f = "DefaultAdAnimationController.kt", i = {}, l = {74, 75}, m = "invokeSuspend", n = {}, s = {})
    static final class j extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f6979a;
        final /* synthetic */ InterfaceC3590c c;
        final /* synthetic */ AnimationEventType d;
        final /* synthetic */ boolean e;
        final /* synthetic */ Runnable f;
        final /* synthetic */ Runnable g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(InterfaceC3590c interfaceC3590c, AnimationEventType animationEventType, boolean z, Runnable runnable, Runnable runnable2, Continuation<? super j> continuation) {
            super(2, continuation);
            this.c = interfaceC3590c;
            this.d = animationEventType;
            this.e = z;
            this.f = runnable;
            this.g = runnable2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((j) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return i.this.new j(this.c, this.d, this.e, this.f, this.g, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x004a, code lost:
        
            if (r3.b(r4, r5, r6, r7, r8, r9, r11) == r0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x004c, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x002b, code lost:
        
            if (r12 == r0) goto L17;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6979a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                i iVar = i.this;
                InterfaceC3590c interfaceC3590c = this.c;
                this.f6979a = 1;
                obj = iVar.a(interfaceC3590c, this);
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            View view = (View) obj;
            if (view != null) {
                i iVar2 = i.this;
                AnimationEventType animationEventType = this.d;
                boolean z = this.e;
                InterfaceC3590c interfaceC3590c2 = this.c;
                Runnable runnable = this.f;
                Runnable runnable2 = this.g;
                boolean lastAcceptedVisible = interfaceC3590c2.getLastAcceptedVisible();
                this.f6979a = 2;
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.bidmachine.rendering.internal.animation.DefaultAdAnimationController", f = "DefaultAdAnimationController.kt", i = {0, 0, 0, 0, 0, 0}, l = {199}, m = "prepareAndAnimate", n = {MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "eventType", "onStart", "onEnd", "animation$iv", "skip"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0"})
    static final class k extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f6980a;
        Object b;
        Object c;
        Object d;
        Object e;
        boolean f;
        /* synthetic */ Object g;
        int i;

        k(Continuation<? super k> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.g = obj;
            this.i |= Integer.MIN_VALUE;
            return i.this.b(null, null, false, false, null, null, this);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.bidmachine.rendering.internal.animation.DefaultAdAnimationController$remove$1", f = "DefaultAdAnimationController.kt", i = {}, l = {134, 135}, m = "invokeSuspend", n = {}, s = {})
    static final class l extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f6981a;
        final /* synthetic */ InterfaceC3590c c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(InterfaceC3590c interfaceC3590c, Continuation<? super l> continuation) {
            super(2, continuation);
            this.c = interfaceC3590c;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((l) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return i.this.new l(this.c, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
        
            if (r1.b(r5, r4) == r0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x003c, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x002b, code lost:
        
            if (r5 == r0) goto L17;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6981a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                i iVar = i.this;
                InterfaceC3590c interfaceC3590c = this.c;
                this.f6981a = 1;
                obj = iVar.a(interfaceC3590c, this);
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            View view = (View) obj;
            if (view != null) {
                i iVar2 = i.this;
                this.f6981a = 2;
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.bidmachine.rendering.internal.animation.DefaultAdAnimationController$remove$2", f = "DefaultAdAnimationController.kt", i = {}, l = {ModuleDescriptor.MODULE_VERSION, 142}, m = "invokeSuspend", n = {}, s = {})
    static final class m extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f6982a;
        final /* synthetic */ io.bidmachine.rendering.internal.d c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(io.bidmachine.rendering.internal.d dVar, Continuation<? super m> continuation) {
            super(2, continuation);
            this.c = dVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((m) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return i.this.new m(this.c, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
        
            if (r1.b(r5, r4) == r0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x003c, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x002b, code lost:
        
            if (r5 == r0) goto L17;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6982a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                i iVar = i.this;
                io.bidmachine.rendering.internal.d dVar = this.c;
                this.f6982a = 1;
                obj = iVar.a(dVar, this);
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            View view = (View) obj;
            if (view != null) {
                i iVar2 = i.this;
                this.f6982a = 2;
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.bidmachine.rendering.internal.animation.DefaultAdAnimationController$removeAll$1", f = "DefaultAdAnimationController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class n extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f6983a;

        n(Continuation<? super n> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((n) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return i.this.new n(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6983a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Iterator it = i.this.animations.entrySet().iterator();
            while (it.hasNext()) {
                ((io.bidmachine.rendering.internal.animation.a) ((Map.Entry) it.next()).getValue()).a();
            }
            i.this.animations.clear();
            return Unit.INSTANCE;
        }
    }

    public i(CoroutineScope coroutineScope, io.bidmachine.rendering.internal.h coroutineDispatchers) {
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(coroutineDispatchers, "coroutineDispatchers");
        this.coroutineScope = coroutineScope;
        this.coroutineDispatchers = coroutineDispatchers;
        this.animations = new ConcurrentHashMap();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object b(View view, AnimationEventType animationEventType, boolean z, boolean z2, Runnable runnable, Runnable runnable2, Continuation<? super Unit> continuation) {
        k kVar;
        int i;
        View view2;
        io.bidmachine.rendering.internal.animation.a aVar;
        if (continuation instanceof k) {
            kVar = (k) continuation;
            int i2 = kVar.i;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                kVar.i = i2 - Integer.MIN_VALUE;
                Object obj = kVar.g;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = kVar.i;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    io.bidmachine.rendering.internal.animation.a aVar2 = this.animations.get(Boxing.boxInt(view.getId()));
                    if (aVar2 == null) {
                        if (runnable != null) {
                            runnable.run();
                        }
                        if (runnable2 != null) {
                            runnable2.run();
                        }
                        return Unit.INSTANCE;
                    }
                    if (z2) {
                        kVar.f6980a = view;
                        kVar.b = animationEventType;
                        kVar.c = runnable;
                        kVar.d = runnable2;
                        kVar.e = aVar2;
                        kVar.f = z;
                        kVar.i = 1;
                        if (a(view, kVar) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    view2 = view;
                    aVar = aVar2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    z = kVar.f;
                    io.bidmachine.rendering.internal.animation.a aVar3 = (io.bidmachine.rendering.internal.animation.a) kVar.e;
                    runnable2 = (Runnable) kVar.d;
                    runnable = (Runnable) kVar.c;
                    animationEventType = (AnimationEventType) kVar.b;
                    View view3 = (View) kVar.f6980a;
                    ResultKt.throwOnFailure(obj);
                    aVar = aVar3;
                    view2 = view3;
                }
                AnimationEventType animationEventType2 = animationEventType;
                aVar.a(view2, animationEventType2);
                aVar.a(view2, animationEventType2, runnable, runnable2, z);
                return Unit.INSTANCE;
            }
        }
        kVar = new k(continuation);
        Object obj2 = kVar.g;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = kVar.i;
        if (i != 0) {
        }
        AnimationEventType animationEventType22 = animationEventType;
        aVar.a(view2, animationEventType22);
        aVar.a(view2, animationEventType22, runnable, runnable2, z);
        return Unit.INSTANCE;
    }

    @Override // io.bidmachine.rendering.internal.animation.b
    public boolean a(int id) {
        io.bidmachine.rendering.internal.animation.a aVar = this.animations.get(Integer.valueOf(id));
        return aVar != null && aVar.b();
    }

    @Override // io.bidmachine.rendering.internal.animation.b
    public void a(InterfaceC3590c adElement, boolean allowPostponed, AnimationEventType eventType) {
        Intrinsics.checkNotNullParameter(adElement, "adElement");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, this.coroutineDispatchers.d(), null, new a(adElement, allowPostponed, eventType, null), 2, null);
    }

    @Override // io.bidmachine.rendering.internal.animation.b
    public void a(io.bidmachine.rendering.internal.d adPhase, AnimationEventType eventType) {
        Intrinsics.checkNotNullParameter(adPhase, "adPhase");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, this.coroutineDispatchers.d(), null, new b(adPhase, eventType, null), 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(View view, io.bidmachine.rendering.internal.animation.a aVar, AnimationEventType animationEventType, boolean z, Continuation<? super Unit> continuation) {
        c cVar;
        int i;
        if (continuation instanceof c) {
            cVar = (c) continuation;
            int i2 = cVar.f;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                cVar.f = i2 - Integer.MIN_VALUE;
                Object obj = cVar.d;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = cVar.f;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    this.animations.put(Boxing.boxInt(view.getId()), aVar);
                    if (z) {
                        cVar.f6972a = view;
                        cVar.b = aVar;
                        cVar.c = animationEventType;
                        cVar.f = 1;
                        if (a(view, cVar) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    animationEventType = (AnimationEventType) cVar.c;
                    aVar = (io.bidmachine.rendering.internal.animation.a) cVar.b;
                    view = (View) cVar.f6972a;
                    ResultKt.throwOnFailure(obj);
                }
                aVar.a(view, animationEventType);
                return Unit.INSTANCE;
            }
        }
        cVar = new c(continuation);
        Object obj2 = cVar.d;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = cVar.f;
        if (i != 0) {
        }
        aVar.a(view, animationEventType);
        return Unit.INSTANCE;
    }

    @Override // io.bidmachine.rendering.internal.animation.b
    public void b(InterfaceC3590c adElement, AnimationEventType eventType, boolean skip, Runnable onStart, Runnable onEnd) {
        Intrinsics.checkNotNullParameter(adElement, "adElement");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, this.coroutineDispatchers.d(), null, new d(adElement, eventType, skip, onStart, onEnd, null), 2, null);
    }

    public Object b(View view, Continuation<? super Unit> continuation) {
        io.bidmachine.rendering.internal.animation.a remove = this.animations.remove(Boxing.boxInt(view.getId()));
        if (remove != null) {
            remove.a();
        }
        return Unit.INSTANCE;
    }

    @Override // io.bidmachine.rendering.internal.animation.b
    public void a(InterfaceC3590c adElement, AnimationEventType eventType, boolean skip, Runnable onStart, Runnable onEnd) {
        Intrinsics.checkNotNullParameter(adElement, "adElement");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, this.coroutineDispatchers.d(), null, new j(adElement, eventType, skip, onStart, onEnd, null), 2, null);
    }

    @Override // io.bidmachine.rendering.internal.animation.b
    public void a(io.bidmachine.rendering.internal.d adPhase, AnimationEventType eventType, boolean skip, Runnable onStart, Runnable onEnd) {
        Intrinsics.checkNotNullParameter(adPhase, "adPhase");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, this.coroutineDispatchers.d(), null, new e(adPhase, eventType, skip, onStart, onEnd, null), 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(View view, AnimationEventType animationEventType, boolean z, boolean z2, Runnable runnable, Runnable runnable2, Continuation<? super Unit> continuation) {
        f fVar;
        int i;
        View view2;
        io.bidmachine.rendering.internal.animation.a aVar;
        if (continuation instanceof f) {
            fVar = (f) continuation;
            int i2 = fVar.i;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                fVar.i = i2 - Integer.MIN_VALUE;
                Object obj = fVar.g;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = fVar.i;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    io.bidmachine.rendering.internal.animation.a aVar2 = this.animations.get(Boxing.boxInt(view.getId()));
                    if (aVar2 == null) {
                        if (runnable != null) {
                            runnable.run();
                        }
                        if (runnable2 != null) {
                            runnable2.run();
                        }
                        return Unit.INSTANCE;
                    }
                    if (z2) {
                        fVar.f6975a = view;
                        fVar.b = animationEventType;
                        fVar.c = runnable;
                        fVar.d = runnable2;
                        fVar.e = aVar2;
                        fVar.f = z;
                        fVar.i = 1;
                        if (a(view, fVar) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    view2 = view;
                    aVar = aVar2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    z = fVar.f;
                    io.bidmachine.rendering.internal.animation.a aVar3 = (io.bidmachine.rendering.internal.animation.a) fVar.e;
                    runnable2 = (Runnable) fVar.d;
                    runnable = (Runnable) fVar.c;
                    animationEventType = (AnimationEventType) fVar.b;
                    View view3 = (View) fVar.f6975a;
                    ResultKt.throwOnFailure(obj);
                    aVar = aVar3;
                    view2 = view3;
                }
                aVar.a(view2, animationEventType, runnable, runnable2, z);
                return Unit.INSTANCE;
            }
        }
        fVar = new f(continuation);
        Object obj2 = fVar.g;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = fVar.i;
        if (i != 0) {
        }
        aVar.a(view2, animationEventType, runnable, runnable2, z);
        return Unit.INSTANCE;
    }

    @Override // io.bidmachine.rendering.internal.animation.b
    public void a(InterfaceC3590c adElement) {
        Intrinsics.checkNotNullParameter(adElement, "adElement");
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, this.coroutineDispatchers.d(), null, new l(adElement, null), 2, null);
    }

    @Override // io.bidmachine.rendering.internal.animation.b
    public void a(io.bidmachine.rendering.internal.d adPhase) {
        Intrinsics.checkNotNullParameter(adPhase, "adPhase");
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, this.coroutineDispatchers.d(), null, new m(adPhase, null), 2, null);
    }

    @Override // io.bidmachine.rendering.internal.animation.b
    public void a() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, this.coroutineDispatchers.d(), null, new n(null), 2, null);
    }

    private final Object a(View view, Continuation<? super View> continuation) {
        return BuildersKt.withContext(this.coroutineDispatchers.e(), new g(view, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object a(InterfaceC3590c interfaceC3590c, Continuation<? super View> continuation) {
        return BuildersKt.withContext(this.coroutineDispatchers.e(), new h(interfaceC3590c, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object a(io.bidmachine.rendering.internal.d dVar, Continuation<? super View> continuation) {
        return BuildersKt.withContext(this.coroutineDispatchers.e(), new C0614i(dVar, null), continuation);
    }
}
