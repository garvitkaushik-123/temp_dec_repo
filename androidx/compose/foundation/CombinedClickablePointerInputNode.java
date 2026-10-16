package androidx.compose.foundation;

import androidx.compose.foundation.AbstractClickableNode;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: Clickable.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\rJD\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007J\u0012\u0010\u000f\u001a\u00020\b*\u00020\u0010H\u0094@¢\u0006\u0002\u0010\u0011R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/CombinedClickablePointerInputNode;", "Landroidx/compose/foundation/AbstractClickablePointerInputNode;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "onClick", "Lkotlin/Function0;", "", "interactionData", "Landroidx/compose/foundation/AbstractClickableNode$InteractionData;", "onLongClick", "onDoubleClick", "(ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/AbstractClickableNode$InteractionData;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "update", "pointerInput", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class CombinedClickablePointerInputNode extends AbstractClickablePointerInputNode {
    private Function0<Unit> onDoubleClick;
    private Function0<Unit> onLongClick;

    public CombinedClickablePointerInputNode(boolean z, MutableInteractionSource mutableInteractionSource, Function0<Unit> function0, AbstractClickableNode.InteractionData interactionData, Function0<Unit> function02, Function0<Unit> function03) {
        super(z, mutableInteractionSource, function0, interactionData, null);
        this.onLongClick = function02;
        this.onDoubleClick = function03;
    }

    @Override // androidx.compose.foundation.AbstractClickablePointerInputNode
    protected Object pointerInput(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        AbstractClickableNode.InteractionData interactionData = getInteractionData();
        long m6565getCenterozmzZPI = IntSizeKt.m6565getCenterozmzZPI(pointerInputScope.getBoundsSize());
        interactionData.m500setCentreOffsetk4lQ0M(OffsetKt.Offset(IntOffset.m6517getXimpl(m6565getCenterozmzZPI), IntOffset.m6518getYimpl(m6565getCenterozmzZPI)));
        Object detectTapGestures = TapGestureDetectorKt.detectTapGestures(pointerInputScope, (!getEnabled() || this.onDoubleClick == null) ? null : new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.CombinedClickablePointerInputNode$pointerInput$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                m579invokek4lQ0M(offset.getPackedValue());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
            public final void m579invokek4lQ0M(long j) {
                Function0 function0;
                function0 = CombinedClickablePointerInputNode.this.onDoubleClick;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        }, (!getEnabled() || this.onLongClick == null) ? null : new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.CombinedClickablePointerInputNode$pointerInput$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                m580invokek4lQ0M(offset.getPackedValue());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
            public final void m580invokek4lQ0M(long j) {
                Function0 function0;
                function0 = CombinedClickablePointerInputNode.this.onLongClick;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        }, new CombinedClickablePointerInputNode$pointerInput$4(this, null), new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.CombinedClickablePointerInputNode$pointerInput$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                m582invokek4lQ0M(offset.getPackedValue());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
            public final void m582invokek4lQ0M(long j) {
                if (CombinedClickablePointerInputNode.this.getEnabled()) {
                    CombinedClickablePointerInputNode.this.getOnClick().invoke();
                }
            }
        }, continuation);
        return detectTapGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectTapGestures : Unit.INSTANCE;
    }

    public final void update(boolean enabled, MutableInteractionSource interactionSource, Function0<Unit> onClick, Function0<Unit> onLongClick, Function0<Unit> onDoubleClick) {
        boolean z;
        setOnClick(onClick);
        setInteractionSource(interactionSource);
        if (getEnabled() != enabled) {
            setEnabled(enabled);
            z = true;
        } else {
            z = false;
        }
        if ((this.onLongClick == null) != (onLongClick == null)) {
            z = true;
        }
        this.onLongClick = onLongClick;
        boolean z2 = (this.onDoubleClick == null) == (onDoubleClick == null) ? z : true;
        this.onDoubleClick = onDoubleClick;
        if (z2) {
            resetPointerInputHandler();
        }
    }
}
