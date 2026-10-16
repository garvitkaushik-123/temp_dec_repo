package io.adn.sdk.internal.ui.utils;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import io.adn.sdk.publisher.AdnClickElement;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: Compose.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.ui.utils.ComposeKt$clickWithCoordinates$1$1", f = "Compose.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class ComposeKt$clickWithCoordinates$1$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AdnClickElement $clickElement;
    final /* synthetic */ Function3<AdnClickElement, Integer, Integer, Unit> $onClicked;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ComposeKt$clickWithCoordinates$1$1(Function3<? super AdnClickElement, ? super Integer, ? super Integer, Unit> function3, AdnClickElement adnClickElement, Continuation<? super ComposeKt$clickWithCoordinates$1$1> continuation) {
        super(2, continuation);
        this.$onClicked = function3;
        this.$clickElement = adnClickElement;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ComposeKt$clickWithCoordinates$1$1 composeKt$clickWithCoordinates$1$1 = new ComposeKt$clickWithCoordinates$1$1(this.$onClicked, this.$clickElement, continuation);
        composeKt$clickWithCoordinates$1$1.L$0 = obj;
        return composeKt$clickWithCoordinates$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((ComposeKt$clickWithCoordinates$1$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            final Function3<AdnClickElement, Integer, Integer, Unit> function3 = this.$onClicked;
            final AdnClickElement adnClickElement = this.$clickElement;
            this.label = 1;
            if (TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, null, new Function1() { // from class: io.adn.sdk.internal.ui.utils.ComposeKt$clickWithCoordinates$1$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    Unit invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = ComposeKt$clickWithCoordinates$1$1.invokeSuspend$lambda$0(Function3.this, adnClickElement, (Offset) obj2);
                    return invokeSuspend$lambda$0;
                }
            }, this, 7, null) == coroutine_suspended) {
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
    public static final Unit invokeSuspend$lambda$0(Function3 function3, AdnClickElement adnClickElement, Offset offset) {
        function3.invoke(adnClickElement, Integer.valueOf((int) Offset.m3822getXimpl(offset.getPackedValue())), Integer.valueOf((int) Offset.m3823getYimpl(offset.getPackedValue())));
        return Unit.INSTANCE;
    }
}
