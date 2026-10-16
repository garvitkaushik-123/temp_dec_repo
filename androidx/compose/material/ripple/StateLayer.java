package androidx.compose.material.ripple;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Ripple.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014J$\u0010\u0015\u001a\u00020\u0011*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, d2 = {"Landroidx/compose/material/ripple/StateLayer;", "", "bounded", "", "rippleAlpha", "Landroidx/compose/runtime/State;", "Landroidx/compose/material/ripple/RippleAlpha;", "(ZLandroidx/compose/runtime/State;)V", "animatedAlpha", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "currentInteraction", "Landroidx/compose/foundation/interaction/Interaction;", "interactions", "", "handleInteraction", "", "interaction", "scope", "Lkotlinx/coroutines/CoroutineScope;", "drawStateLayer", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/Color;", "drawStateLayer-H2RKhps", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FJ)V", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class StateLayer {
    private final boolean bounded;
    private Interaction currentInteraction;
    private final State<RippleAlpha> rippleAlpha;
    private final Animatable<Float, AnimationVector1D> animatedAlpha = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
    private final List<Interaction> interactions = new ArrayList();

    public StateLayer(boolean z, State<RippleAlpha> state) {
        this.bounded = z;
        this.rippleAlpha = state;
    }

    public final void handleInteraction(Interaction interaction, CoroutineScope scope) {
        AnimationSpec outgoingStateLayerAnimationSpecFor;
        float draggedAlpha;
        AnimationSpec incomingStateLayerAnimationSpecFor;
        boolean z = interaction instanceof HoverInteraction.Enter;
        if (z) {
            this.interactions.add(interaction);
        } else if (interaction instanceof HoverInteraction.Exit) {
            this.interactions.remove(((HoverInteraction.Exit) interaction).getEnter());
        } else if (interaction instanceof FocusInteraction.Focus) {
            this.interactions.add(interaction);
        } else if (interaction instanceof FocusInteraction.Unfocus) {
            this.interactions.remove(((FocusInteraction.Unfocus) interaction).getFocus());
        } else if (interaction instanceof DragInteraction.Start) {
            this.interactions.add(interaction);
        } else if (interaction instanceof DragInteraction.Stop) {
            this.interactions.remove(((DragInteraction.Stop) interaction).getStart());
        } else if (!(interaction instanceof DragInteraction.Cancel)) {
            return;
        } else {
            this.interactions.remove(((DragInteraction.Cancel) interaction).getStart());
        }
        Interaction interaction2 = (Interaction) CollectionsKt.lastOrNull((List) this.interactions);
        if (Intrinsics.areEqual(this.currentInteraction, interaction2)) {
            return;
        }
        if (interaction2 != null) {
            if (z) {
                draggedAlpha = this.rippleAlpha.getValue().getHoveredAlpha();
            } else if (interaction instanceof FocusInteraction.Focus) {
                draggedAlpha = this.rippleAlpha.getValue().getFocusedAlpha();
            } else {
                draggedAlpha = interaction instanceof DragInteraction.Start ? this.rippleAlpha.getValue().getDraggedAlpha() : 0.0f;
            }
            incomingStateLayerAnimationSpecFor = RippleKt.incomingStateLayerAnimationSpecFor(interaction2);
            BuildersKt__Builders_commonKt.launch$default(scope, null, null, new StateLayer$handleInteraction$1(this, draggedAlpha, incomingStateLayerAnimationSpecFor, null), 3, null);
        } else {
            outgoingStateLayerAnimationSpecFor = RippleKt.outgoingStateLayerAnimationSpecFor(this.currentInteraction);
            BuildersKt__Builders_commonKt.launch$default(scope, null, null, new StateLayer$handleInteraction$2(this, outgoingStateLayerAnimationSpecFor, null), 3, null);
        }
        this.currentInteraction = interaction2;
    }

    /* renamed from: drawStateLayer-H2RKhps, reason: not valid java name */
    public final void m1873drawStateLayerH2RKhps(DrawScope drawScope, float f, long j) {
        float f2;
        if (Float.isNaN(f)) {
            f2 = RippleAnimationKt.m1864getRippleEndRadiuscSwnlzA(drawScope, this.bounded, drawScope.mo4612getSizeNHjbRc());
        } else {
            f2 = drawScope.mo630toPx0680j_4(f);
        }
        float f3 = f2;
        float floatValue = this.animatedAlpha.getValue().floatValue();
        if (floatValue > 0.0f) {
            long m4062copywmQWz5c$default = Color.m4062copywmQWz5c$default(j, floatValue, 0.0f, 0.0f, 0.0f, 14, null);
            if (!this.bounded) {
                DrawScope.m4594drawCircleVaOC9Bg$default(drawScope, m4062copywmQWz5c$default, f3, 0L, 0.0f, null, null, 0, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE, null);
                return;
            }
            float m3891getWidthimpl = Size.m3891getWidthimpl(drawScope.mo4612getSizeNHjbRc());
            float m3888getHeightimpl = Size.m3888getHeightimpl(drawScope.mo4612getSizeNHjbRc());
            int m4052getIntersectrtfAjoo = ClipOp.INSTANCE.m4052getIntersectrtfAjoo();
            DrawContext drawContext = drawScope.getDrawContext();
            long mo4537getSizeNHjbRc = drawContext.mo4537getSizeNHjbRc();
            drawContext.getCanvas().save();
            drawContext.getTransform().mo4540clipRectN_I0leg(0.0f, 0.0f, m3891getWidthimpl, m3888getHeightimpl, m4052getIntersectrtfAjoo);
            DrawScope.m4594drawCircleVaOC9Bg$default(drawScope, m4062copywmQWz5c$default, f3, 0L, 0.0f, null, null, 0, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE, null);
            drawContext.getCanvas().restore();
            drawContext.mo4538setSizeuvyYCjk(mo4537getSizeNHjbRc);
        }
    }
}
