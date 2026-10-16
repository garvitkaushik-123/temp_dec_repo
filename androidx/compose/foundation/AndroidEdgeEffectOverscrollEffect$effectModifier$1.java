package androidx.compose.foundation;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: AndroidOverscroll.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$effectModifier$1", f = "AndroidOverscroll.android.kt", i = {}, l = {Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class AndroidEdgeEffectOverscrollEffect$effectModifier$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AndroidEdgeEffectOverscrollEffect this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidEdgeEffectOverscrollEffect$effectModifier$1(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, Continuation<? super AndroidEdgeEffectOverscrollEffect$effectModifier$1> continuation) {
        super(2, continuation);
        this.this$0 = androidEdgeEffectOverscrollEffect;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AndroidEdgeEffectOverscrollEffect$effectModifier$1 androidEdgeEffectOverscrollEffect$effectModifier$1 = new AndroidEdgeEffectOverscrollEffect$effectModifier$1(this.this$0, continuation);
        androidEdgeEffectOverscrollEffect$effectModifier$1.L$0 = obj;
        return androidEdgeEffectOverscrollEffect$effectModifier$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((AndroidEdgeEffectOverscrollEffect$effectModifier$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: AndroidOverscroll.android.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$effectModifier$1$1", f = "AndroidOverscroll.android.kt", i = {0, 1}, l = {321, 325}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture"}, s = {"L$0", "L$0"})
    /* renamed from: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$effectModifier$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AndroidEdgeEffectOverscrollEffect this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = androidEdgeEffectOverscrollEffect;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x0069, code lost:
        
            if (r13 != r0) goto L18;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0069 -> B:6:0x006c). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            AwaitPointerEventScope awaitPointerEventScope;
            Object obj2;
            PointerId pointerId;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                this.L$0 = awaitPointerEventScope2;
                this.label = 1;
                obj = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope2, false, null, this, 2, null);
                if (obj != coroutine_suspended) {
                    awaitPointerEventScope = awaitPointerEventScope2;
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                List<PointerInputChange> changes = ((PointerEvent) obj).getChanges();
                ArrayList arrayList = new ArrayList(changes.size());
                int size = changes.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    PointerInputChange pointerInputChange = changes.get(i3);
                    if (pointerInputChange.getPressed()) {
                        arrayList.add(pointerInputChange);
                    }
                }
                ArrayList arrayList2 = arrayList;
                AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect = this.this$0;
                int size2 = arrayList2.size();
                while (true) {
                    if (i2 >= size2) {
                        obj2 = null;
                        break;
                    }
                    obj2 = arrayList2.get(i2);
                    long id = ((PointerInputChange) obj2).getId();
                    pointerId = androidEdgeEffectOverscrollEffect.pointerId;
                    if (PointerId.m5188equalsimpl(id, pointerId)) {
                        break;
                    }
                    i2++;
                }
                PointerInputChange pointerInputChange2 = (PointerInputChange) obj2;
                if (pointerInputChange2 == null) {
                    pointerInputChange2 = (PointerInputChange) CollectionsKt.firstOrNull((List) arrayList2);
                }
                if (pointerInputChange2 != null) {
                    this.this$0.pointerId = PointerId.m5186boximpl(pointerInputChange2.getId());
                    this.this$0.pointerPosition = Offset.m3811boximpl(pointerInputChange2.getPosition());
                }
                if (arrayList2.isEmpty()) {
                    this.this$0.pointerId = null;
                    return Unit.INSTANCE;
                }
                this.L$0 = awaitPointerEventScope;
                this.label = 2;
                obj = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, this, 1, null);
            }
            PointerInputChange pointerInputChange3 = (PointerInputChange) obj;
            this.this$0.pointerId = PointerId.m5186boximpl(pointerInputChange3.getId());
            this.this$0.pointerPosition = Offset.m3811boximpl(pointerInputChange3.getPosition());
            this.L$0 = awaitPointerEventScope;
            this.label = 2;
            obj = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, this, 1, null);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (ForEachGestureKt.awaitEachGesture((PointerInputScope) this.L$0, new AnonymousClass1(this.this$0, null), this) == coroutine_suspended) {
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
