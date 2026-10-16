package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch;

import adn.analytics.Analytics;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* loaded from: classes6.dex */
public final class b {

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.TapKt$detectTapUnconsumed$2", f = "Tap.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6266a;
        public /* synthetic */ Object b;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.a c;
        public final /* synthetic */ Function2<Offset, Offset, Unit> d;

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.TapKt$detectTapUnconsumed$2$1", f = "Tap.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.b$a$a, reason: collision with other inner class name */
        public static final class C0554a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public int f6267a;
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.a b;
            public final /* synthetic */ PointerInputScope c;
            public final /* synthetic */ Function2<Offset, Offset, Unit> d;

            @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.TapKt$detectTapUnconsumed$2$1$1", f = "Tap.kt", i = {0, 1}, l = {45, 48}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "down"}, s = {"L$0", "L$0"})
            /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.b$a$a$a, reason: collision with other inner class name */
            public static final class C0555a extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {

                /* renamed from: a, reason: collision with root package name */
                public int f6268a;
                public /* synthetic */ Object b;
                public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.a c;
                public final /* synthetic */ Function2<Offset, Offset, Unit> d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public C0555a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.a aVar, Function2<? super Offset, ? super Offset, Unit> function2, Continuation<? super C0555a> continuation) {
                    super(2, continuation);
                    this.c = aVar;
                    this.d = function2;
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                    return ((C0555a) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C0555a c0555a = new C0555a(this.c, this.d, continuation);
                    c0555a.b = obj;
                    return c0555a;
                }

                /* JADX WARN: Code restructure failed: missing block: B:24:0x0037, code lost:
                
                    if (r6 == r0) goto L18;
                 */
                /* JADX WARN: Removed duplicated region for block: B:12:0x0060  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x005a  */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object invokeSuspend(Object obj) {
                    AwaitPointerEventScope awaitPointerEventScope;
                    PointerInputChange pointerInputChange;
                    PointerInputChange pointerInputChange2;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.f6268a;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        awaitPointerEventScope = (AwaitPointerEventScope) this.b;
                        this.b = awaitPointerEventScope;
                        this.f6268a = 1;
                        obj = TapGestureDetectorKt.awaitFirstDown(awaitPointerEventScope, false, this);
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            pointerInputChange = (PointerInputChange) this.b;
                            ResultKt.throwOnFailure(obj);
                            pointerInputChange2 = (PointerInputChange) obj;
                            if (pointerInputChange2 != null) {
                                this.c.a();
                            } else {
                                this.c.b();
                                this.d.invoke(Offset.m3811boximpl(pointerInputChange.getPosition()), Offset.m3811boximpl(pointerInputChange2.getPosition()));
                            }
                            return Unit.INSTANCE;
                        }
                        awaitPointerEventScope = (AwaitPointerEventScope) this.b;
                        ResultKt.throwOnFailure(obj);
                    }
                    PointerInputChange pointerInputChange3 = (PointerInputChange) obj;
                    if (pointerInputChange3.getPressed() != pointerInputChange3.getPreviousPressed()) {
                        pointerInputChange3.consume();
                    }
                    this.b = pointerInputChange3;
                    this.f6268a = 2;
                    Object b = b.b(awaitPointerEventScope, this);
                    if (b != coroutine_suspended) {
                        pointerInputChange = pointerInputChange3;
                        obj = b;
                        pointerInputChange2 = (PointerInputChange) obj;
                        if (pointerInputChange2 != null) {
                        }
                        return Unit.INSTANCE;
                    }
                    return coroutine_suspended;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0554a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.a aVar, PointerInputScope pointerInputScope, Function2<? super Offset, ? super Offset, Unit> function2, Continuation<? super C0554a> continuation) {
                super(2, continuation);
                this.b = aVar;
                this.c = pointerInputScope;
                this.d = function2;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C0554a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C0554a(this.b, this.c, this.d, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f6267a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.b.c();
                    PointerInputScope pointerInputScope = this.c;
                    C0555a c0555a = new C0555a(this.b, this.d, null);
                    this.f6267a = 1;
                    if (pointerInputScope.awaitPointerEventScope(c0555a, this) == coroutine_suspended) {
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.a aVar, Function2<? super Offset, ? super Offset, Unit> function2, Continuation<? super a> continuation) {
            super(2, continuation);
            this.c = aVar;
            this.d = function2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
            return ((a) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a aVar = new a(this.c, this.d, continuation);
            aVar.b = obj;
            return aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6266a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                C0554a c0554a = new C0554a(this.c, (PointerInputScope) this.b, this.d, null);
                this.f6266a = 1;
                if (CoroutineScopeKt.coroutineScope(c0554a, this) == coroutine_suspended) {
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

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.TapKt", f = "Tap.kt", i = {0, 1}, l = {62, Analytics.AnalyticsData.COUNT_IMP_FIELD_NUMBER}, m = "waitForUpOrCancellationInitial", n = {"$this$waitForUpOrCancellationInitial", "$this$waitForUpOrCancellationInitial"}, s = {"L$0", "L$0"})
    /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.b$b, reason: collision with other inner class name */
    public static final class C0556b extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f6269a;
        public /* synthetic */ Object b;
        public int c;

        public C0556b(Continuation<? super C0556b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.c |= Integer.MIN_VALUE;
            return b.b((AwaitPointerEventScope) null, this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0050, code lost:
    
        if (r14 != r1) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0095, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a0, code lost:
    
        if (r14 == r1) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a2, code lost:
    
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00a0 -> B:11:0x00a3). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object b(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super PointerInputChange> continuation) {
        C0556b c0556b;
        int i;
        if (continuation instanceof C0556b) {
            c0556b = (C0556b) continuation;
            int i2 = c0556b.c;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c0556b.c = i2 - Integer.MIN_VALUE;
                Object obj = c0556b.b;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = c0556b.c;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    PointerEventPass pointerEventPass = PointerEventPass.Initial;
                    c0556b.f6269a = awaitPointerEventScope;
                    c0556b.c = 1;
                    obj = awaitPointerEventScope.awaitPointerEvent(pointerEventPass, c0556b);
                } else {
                    if (i == 1) {
                        awaitPointerEventScope = (AwaitPointerEventScope) c0556b.f6269a;
                        ResultKt.throwOnFailure(obj);
                        PointerEvent pointerEvent = (PointerEvent) obj;
                        List<PointerInputChange> changes = pointerEvent.getChanges();
                        int size = changes.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            if (!PointerEventKt.changedToUp(changes.get(i3))) {
                                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                                int size2 = changes2.size();
                                for (int i4 = 0; i4 < size2; i4++) {
                                    PointerInputChange pointerInputChange = changes2.get(i4);
                                    if (pointerInputChange.isConsumed() || PointerEventKt.m5152isOutOfBoundsjwHxaWs(pointerInputChange, awaitPointerEventScope.mo5119getSizeYbymL2g(), awaitPointerEventScope.mo5118getExtendedTouchPaddingNHjbRc())) {
                                        break;
                                    }
                                }
                                PointerEventPass pointerEventPass2 = PointerEventPass.Final;
                                c0556b.f6269a = awaitPointerEventScope;
                                c0556b.c = 2;
                                obj = awaitPointerEventScope.awaitPointerEvent(pointerEventPass2, c0556b);
                            }
                        }
                        return pointerEvent.getChanges().get(0);
                    }
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    awaitPointerEventScope = (AwaitPointerEventScope) c0556b.f6269a;
                    ResultKt.throwOnFailure(obj);
                    List<PointerInputChange> changes3 = ((PointerEvent) obj).getChanges();
                    int size3 = changes3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        if (changes3.get(i5).isConsumed()) {
                            return null;
                        }
                    }
                    PointerEventPass pointerEventPass3 = PointerEventPass.Initial;
                    c0556b.f6269a = awaitPointerEventScope;
                    c0556b.c = 1;
                    obj = awaitPointerEventScope.awaitPointerEvent(pointerEventPass3, c0556b);
                }
            }
        }
        c0556b = new C0556b(continuation);
        Object obj2 = c0556b.b;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = c0556b.c;
        if (i != 0) {
        }
    }

    public static final <T> void c(List<? extends T> list, Function1<? super T, Unit> function1) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            function1.invoke(list.get(i));
        }
    }

    public static final Object a(PointerInputScope pointerInputScope, Function2<? super Offset, ? super Offset, Unit> function2, Continuation<? super Unit> continuation) {
        Object forEachGesture = ForEachGestureKt.forEachGesture(pointerInputScope, new a(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.touch.a(pointerInputScope), function2, null), continuation);
        return forEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? forEachGesture : Unit.INSTANCE;
    }

    public static final <T> boolean a(List<? extends T> list, Function1<? super T, Boolean> function1) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!function1.invoke(list.get(i)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <T> boolean b(List<? extends T> list, Function1<? super T, Boolean> function1) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (function1.invoke(list.get(i)).booleanValue()) {
                return true;
            }
        }
        return false;
    }
}
