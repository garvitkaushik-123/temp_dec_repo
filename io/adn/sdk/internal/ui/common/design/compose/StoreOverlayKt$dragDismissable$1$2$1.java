package io.adn.sdk.internal.ui.common.design.compose;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import com.vungle.ads.internal.protos.Sdk;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: StoreOverlay.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.ui.common.design.compose.StoreOverlayKt$dragDismissable$1$2$1", f = "StoreOverlay.kt", i = {}, l = {Sdk.SDKError.Reason.INVALID_GZIP_BID_PAYLOAD_VALUE}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class StoreOverlayKt$dragDismissable$1$2$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ float $heightPx;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $offsetY;
    final /* synthetic */ Function0<Unit> $onDismiss;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ float $threshold;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StoreOverlayKt$dragDismissable$1$2$1(Animatable<Float, AnimationVector1D> animatable, float f, Function0<Unit> function0, CoroutineScope coroutineScope, float f2, Continuation<? super StoreOverlayKt$dragDismissable$1$2$1> continuation) {
        super(2, continuation);
        this.$offsetY = animatable;
        this.$threshold = f;
        this.$onDismiss = function0;
        this.$scope = coroutineScope;
        this.$heightPx = f2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        StoreOverlayKt$dragDismissable$1$2$1 storeOverlayKt$dragDismissable$1$2$1 = new StoreOverlayKt$dragDismissable$1$2$1(this.$offsetY, this.$threshold, this.$onDismiss, this.$scope, this.$heightPx, continuation);
        storeOverlayKt$dragDismissable$1$2$1.L$0 = obj;
        return storeOverlayKt$dragDismissable$1$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((StoreOverlayKt$dragDismissable$1$2$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            final Animatable<Float, AnimationVector1D> animatable = this.$offsetY;
            final float f = this.$threshold;
            final Function0<Unit> function0 = this.$onDismiss;
            final CoroutineScope coroutineScope = this.$scope;
            Function0 function02 = new Function0() { // from class: io.adn.sdk.internal.ui.common.design.compose.StoreOverlayKt$dragDismissable$1$2$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = StoreOverlayKt$dragDismissable$1$2$1.invokeSuspend$lambda$0(Animatable.this, f, function0, coroutineScope);
                    return invokeSuspend$lambda$0;
                }
            };
            final Animatable<Float, AnimationVector1D> animatable2 = this.$offsetY;
            final float f2 = this.$heightPx;
            final CoroutineScope coroutineScope2 = this.$scope;
            this.label = 1;
            if (DragGestureDetectorKt.detectVerticalDragGestures$default(pointerInputScope, null, function02, null, new Function2() { // from class: io.adn.sdk.internal.ui.common.design.compose.StoreOverlayKt$dragDismissable$1$2$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit invokeSuspend$lambda$1;
                    invokeSuspend$lambda$1 = StoreOverlayKt$dragDismissable$1$2$1.invokeSuspend$lambda$1(Animatable.this, f2, coroutineScope2, (PointerInputChange) obj2, ((Float) obj3).floatValue());
                    return invokeSuspend$lambda$1;
                }
            }, this, 5, null) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1(Animatable animatable, float f, CoroutineScope coroutineScope, PointerInputChange pointerInputChange, float f2) {
        pointerInputChange.consume();
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new StoreOverlayKt$dragDismissable$1$2$1$2$1(animatable, RangesKt.coerceIn(((Number) animatable.getValue()).floatValue() + f2, 0.0f, f), null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(Animatable animatable, float f, Function0 function0, CoroutineScope coroutineScope) {
        if (((Number) animatable.getValue()).floatValue() <= f) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new StoreOverlayKt$dragDismissable$1$2$1$1$1(animatable, null), 3, null);
        } else {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }
}
