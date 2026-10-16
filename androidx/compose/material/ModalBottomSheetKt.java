package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import com.unity3d.mediation.LevelPlayAdError;
import com.vungle.ads.internal.protos.Sdk;
import io.bidmachine.iab.vast.tags.VastAttributes;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ModalBottomSheet.kt */
@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a\u001c\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\t\u001a\u00020\nH\u0002\u001a\u0093\u0001\u0010\u000b\u001a\u00020\f2\u001c\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00012\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001c2\u0011\u0010\u001f\u001a\r\u0012\u0004\u0012\u00020\f0 ¢\u0006\u0002\b\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a@\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020%2\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\u0014\b\u0002\u0010)\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00170\u000e2\b\b\u0002\u0010*\u001a\u00020\u0017H\u0007\u001aH\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020%2\u0006\u0010+\u001a\u00020,2\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\u0014\b\u0002\u0010)\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00170\u000e2\b\b\u0002\u0010*\u001a\u00020\u0017H\u0007\u001a0\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020\u001c2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\f0 2\u0006\u00100\u001a\u00020\u0017H\u0003ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001a9\u00103\u001a\u00020\u00152\u0006\u0010$\u001a\u00020%2\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00170\u000eH\u0007¢\u0006\u0002\u00105\u001aE\u00103\u001a\u00020\u00152\u0006\u0010$\u001a\u00020%2\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\u0014\b\u0002\u0010)\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00170\u000e2\b\b\u0002\u00106\u001a\u00020\u0017H\u0007¢\u0006\u0002\u00107\u001aA\u00103\u001a\u00020\u00152\u0006\u0010$\u001a\u00020%2\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\u0006\u00106\u001a\u00020\u00172\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00170\u000eH\u0007¢\u0006\u0002\u00108\u001a\u001c\u00109\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010:\u001a\u00020(H\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006;²\u0006\n\u0010<\u001a\u00020(X\u008a\u0084\u0002"}, d2 = {"MaxModalBottomSheetWidth", "Landroidx/compose/ui/unit/Dp;", "F", "ModalBottomSheetPositionalThreshold", "ModalBottomSheetVelocityThreshold", "ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "state", "Landroidx/compose/material/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "ModalBottomSheetLayout", "", "sheetContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "sheetState", "Landroidx/compose/material/ModalBottomSheetState;", "sheetGesturesEnabled", "", "sheetShape", "Landroidx/compose/ui/graphics/Shape;", "sheetElevation", "sheetBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "sheetContentColor", "scrimColor", "content", "Lkotlin/Function0;", "ModalBottomSheetLayout-Gs3lGvM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/ModalBottomSheetState;ZLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ModalBottomSheetState", "initialValue", "Landroidx/compose/material/ModalBottomSheetValue;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "isSkipHalfExpanded", "density", "Landroidx/compose/ui/unit/Density;", "Scrim", "color", "onDismiss", VastAttributes.VISIBLE, "Scrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "rememberModalBottomSheetState", "confirmStateChange", "(Landroidx/compose/material/ModalBottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/ModalBottomSheetState;", "skipHalfExpanded", "(Landroidx/compose/material/ModalBottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ModalBottomSheetState;", "(Landroidx/compose/material/ModalBottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/ModalBottomSheetState;", "modalBottomSheetAnchors", "fullHeight", "material_release", "alpha"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ModalBottomSheetKt {
    private static final float ModalBottomSheetPositionalThreshold = Dp.m6389constructorimpl(56);
    private static final float ModalBottomSheetVelocityThreshold = Dp.m6389constructorimpl(Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE);
    private static final float MaxModalBottomSheetWidth = Dp.m6389constructorimpl(640);

    public static /* synthetic */ ModalBottomSheetState ModalBottomSheetState$default(ModalBottomSheetValue modalBottomSheetValue, Density density, AnimationSpec animationSpec, Function1 function1, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            animationSpec = AnchoredDraggableDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i & 8) != 0) {
            function1 = new Function1<ModalBottomSheetValue, Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetState$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(ModalBottomSheetValue modalBottomSheetValue2) {
                    return true;
                }
            };
        }
        if ((i & 16) != 0) {
            z = false;
        }
        return ModalBottomSheetState(modalBottomSheetValue, density, animationSpec, function1, z);
    }

    public static final ModalBottomSheetState ModalBottomSheetState(ModalBottomSheetValue modalBottomSheetValue, Density density, AnimationSpec<Float> animationSpec, Function1<? super ModalBottomSheetValue, Boolean> function1, boolean z) {
        ModalBottomSheetState modalBottomSheetState = new ModalBottomSheetState(modalBottomSheetValue, animationSpec, z, function1);
        modalBottomSheetState.setDensity$material_release(density);
        return modalBottomSheetState;
    }

    public static /* synthetic */ ModalBottomSheetState ModalBottomSheetState$default(ModalBottomSheetValue modalBottomSheetValue, AnimationSpec animationSpec, Function1 function1, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = AnchoredDraggableDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i & 4) != 0) {
            function1 = new Function1<ModalBottomSheetValue, Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetState$3
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(ModalBottomSheetValue modalBottomSheetValue2) {
                    return true;
                }
            };
        }
        if ((i & 8) != 0) {
            z = false;
        }
        return ModalBottomSheetState(modalBottomSheetValue, animationSpec, function1, z);
    }

    @Deprecated(message = "This constructor is deprecated. Density must be provided by the component. Please use the constructor that provides a [Density].", replaceWith = @ReplaceWith(expression = "\n            ModalBottomSheetState(\n                initialValue = initialValue,\n                density =,\n                animationSpec = animationSpec,\n                isSkipHalfExpanded = isSkipHalfExpanded,\n                confirmStateChange = confirmValueChange\n            )\n            ", imports = {}))
    public static final ModalBottomSheetState ModalBottomSheetState(ModalBottomSheetValue modalBottomSheetValue, AnimationSpec<Float> animationSpec, Function1<? super ModalBottomSheetValue, Boolean> function1, boolean z) {
        return new ModalBottomSheetState(modalBottomSheetValue, animationSpec, z, function1);
    }

    public static final ModalBottomSheetState rememberModalBottomSheetState(final ModalBottomSheetValue modalBottomSheetValue, AnimationSpec<Float> animationSpec, Function1<? super ModalBottomSheetValue, Boolean> function1, boolean z, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-126412120);
        ComposerKt.sourceInformation(composer, "C(rememberModalBottomSheetState)P(2)433@17446L7:ModalBottomSheet.kt#jmzs0o");
        final AnimationSpec<Float> animationSpec2 = (i2 & 2) != 0 ? AnchoredDraggableDefaults.INSTANCE.getAnimationSpec() : animationSpec;
        final Function1<? super ModalBottomSheetValue, Boolean> function12 = (i2 & 4) != 0 ? new Function1<ModalBottomSheetValue, Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt$rememberModalBottomSheetState$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(ModalBottomSheetValue modalBottomSheetValue2) {
                return true;
            }
        } : function1;
        final boolean z2 = (i2 & 8) != 0 ? false : z;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-126412120, i, -1, "androidx.compose.material.rememberModalBottomSheetState (ModalBottomSheet.kt:432)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final Density density = (Density) consume;
        composer.startMovableGroup(170051256, modalBottomSheetValue);
        ComposerKt.sourceInformation(composer, "438@17707L646");
        ModalBottomSheetState modalBottomSheetState = (ModalBottomSheetState) RememberSaveableKt.m3680rememberSaveable(new Object[]{modalBottomSheetValue, animationSpec2, Boolean.valueOf(z2), function12, density}, (Saver) ModalBottomSheetState.INSTANCE.Saver(animationSpec2, function12, z2, density), (String) null, (Function0) new Function0<ModalBottomSheetState>() { // from class: androidx.compose.material.ModalBottomSheetKt$rememberModalBottomSheetState$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ModalBottomSheetState invoke() {
                return ModalBottomSheetKt.ModalBottomSheetState(ModalBottomSheetValue.this, density, animationSpec2, function12, z2);
            }
        }, composer, 72, 4);
        composer.endMovableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return modalBottomSheetState;
    }

    @Deprecated(message = "This function is deprecated. confirmStateChange has been renamed to confirmValueChange.", replaceWith = @ReplaceWith(expression = "rememberModalBottomSheetState(initialValue, animationSpec, confirmStateChange, false)", imports = {}))
    public static final ModalBottomSheetState rememberModalBottomSheetState(ModalBottomSheetValue modalBottomSheetValue, AnimationSpec<Float> animationSpec, boolean z, Function1<? super ModalBottomSheetValue, Boolean> function1, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-409288536);
        ComposerKt.sourceInformation(composer, "C(rememberModalBottomSheetState)P(2!1,3)486@19775L185:ModalBottomSheet.kt#jmzs0o");
        if ((i2 & 2) != 0) {
            animationSpec = AnchoredDraggableDefaults.INSTANCE.getAnimationSpec();
        }
        AnimationSpec<Float> animationSpec2 = animationSpec;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-409288536, i, -1, "androidx.compose.material.rememberModalBottomSheetState (ModalBottomSheet.kt:486)");
        }
        ModalBottomSheetState rememberModalBottomSheetState = rememberModalBottomSheetState(modalBottomSheetValue, animationSpec2, function1, z, composer, (i & 14) | 64 | ((i >> 3) & 896) | ((i << 3) & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberModalBottomSheetState;
    }

    @Deprecated(message = "This function is deprecated. confirmStateChange has been renamed to confirmValueChange.", replaceWith = @ReplaceWith(expression = "rememberModalBottomSheetState(initialValue, animationSpec, confirmValueChange = confirmStateChange)", imports = {}))
    public static final ModalBottomSheetState rememberModalBottomSheetState(ModalBottomSheetValue modalBottomSheetValue, AnimationSpec<Float> animationSpec, Function1<? super ModalBottomSheetValue, Boolean> function1, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1928569212);
        ComposerKt.sourceInformation(composer, "C(rememberModalBottomSheetState)P(2)514@20852L174:ModalBottomSheet.kt#jmzs0o");
        if ((i2 & 2) != 0) {
            animationSpec = AnchoredDraggableDefaults.INSTANCE.getAnimationSpec();
        }
        AnimationSpec<Float> animationSpec2 = animationSpec;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1928569212, i, -1, "androidx.compose.material.rememberModalBottomSheetState (ModalBottomSheet.kt:514)");
        }
        ModalBottomSheetState rememberModalBottomSheetState = rememberModalBottomSheetState(modalBottomSheetValue, animationSpec2, function1, false, composer, (i & 14) | 3136 | (i & 896), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberModalBottomSheetState;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x019d  */
    /* renamed from: ModalBottomSheetLayout-Gs3lGvM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1704ModalBottomSheetLayoutGs3lGvM(final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, ModalBottomSheetState modalBottomSheetState, boolean z, Shape shape, float f, long j, long j2, long j3, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        int i5;
        boolean z2;
        Shape shape2;
        int i6;
        float f2;
        int i7;
        int i8;
        long j4;
        Modifier modifier3;
        int i9;
        boolean z3;
        final ModalBottomSheetState modalBottomSheetState2;
        CornerBasedShape cornerBasedShape;
        long j5;
        long j6;
        final long j7;
        final Shape shape3;
        final float f3;
        final long j8;
        final boolean z4;
        final long j9;
        Object rememberedValue;
        final Modifier modifier4;
        Composer composer2;
        final boolean z5;
        final ModalBottomSheetState modalBottomSheetState3;
        final Shape shape4;
        final long j10;
        final long j11;
        final float f4;
        final long j12;
        ScopeUpdateScope endRestartGroup;
        int i10;
        int i11;
        Composer startRestartGroup = composer.startRestartGroup(-92970288);
        ComposerKt.sourceInformation(startRestartGroup, "C(ModalBottomSheetLayout)P(4,1,9,7,8,6:c#ui.unit.Dp,3:c#ui.graphics.Color,5:c#ui.graphics.Color,2:c#ui.graphics.Color)556@22983L37,558@23102L6,560@23225L6,561@23272L37,562@23360L10,566@23526L7,567@23538L55,570@23610L24,572@23682L4175:ModalBottomSheet.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changedInstance(function3) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i12 = i2 & 2;
        if (i12 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 != 0) {
                i3 |= 128;
            }
            i5 = i2 & 8;
            if (i5 == 0) {
                i3 |= 3072;
                z2 = z;
            } else {
                z2 = z;
                if ((i & 7168) == 0) {
                    i3 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                }
            }
            if ((57344 & i) != 0) {
                shape2 = shape;
                i3 |= ((i2 & 16) == 0 && startRestartGroup.changed(shape2)) ? 16384 : 8192;
            } else {
                shape2 = shape;
            }
            i6 = i2 & 32;
            if (i6 == 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                f2 = f;
            } else {
                f2 = f;
                if ((458752 & i) == 0) {
                    i3 |= startRestartGroup.changed(f2) ? 131072 : 65536;
                }
            }
            if ((3670016 & i) != 0) {
                i7 = i3 | (((i2 & 64) == 0 && startRestartGroup.changed(j)) ? 1048576 : 524288);
            } else {
                i7 = i3;
            }
            if ((i & 29360128) != 0) {
                i8 = i12;
                if ((i2 & 128) == 0) {
                    j4 = j2;
                    if (startRestartGroup.changed(j4)) {
                        i11 = 8388608;
                        i7 |= i11;
                    }
                } else {
                    j4 = j2;
                }
                i11 = 4194304;
                i7 |= i11;
            } else {
                i8 = i12;
                j4 = j2;
            }
            if ((i & 234881024) == 0) {
                if ((i2 & 256) == 0 && startRestartGroup.changed(j3)) {
                    i10 = 67108864;
                    i7 |= i10;
                }
                i10 = 33554432;
                i7 |= i10;
            }
            if ((i2 & 512) == 0) {
                i7 |= C.ENCODING_PCM_32BIT;
            } else if ((1879048192 & i) == 0) {
                i7 |= startRestartGroup.changedInstance(function2) ? 536870912 : 268435456;
                int i13 = i7;
                if (i4 == 4 || (1533916891 & i13) != 306783378 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        Modifier.Companion companion = i8 != 0 ? Modifier.INSTANCE : modifier2;
                        if (i4 != 0) {
                            modifier3 = companion;
                            z3 = true;
                            modalBottomSheetState2 = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden, (AnimationSpec<Float>) null, (Function1<? super ModalBottomSheetValue, Boolean>) null, false, startRestartGroup, 6, 14);
                            i9 = i13 & (-897);
                        } else {
                            modifier3 = companion;
                            i9 = i13;
                            z3 = true;
                            modalBottomSheetState2 = modalBottomSheetState;
                        }
                        if (i5 != 0) {
                            z2 = z3;
                        }
                        if ((i2 & 16) != 0) {
                            cornerBasedShape = MaterialTheme.INSTANCE.getShapes(startRestartGroup, 6).getLarge();
                            i9 &= -57345;
                        } else {
                            cornerBasedShape = shape2;
                        }
                        float m1703getElevationD9Ej5fM = i6 != 0 ? ModalBottomSheetDefaults.INSTANCE.m1703getElevationD9Ej5fM() : f2;
                        if ((i2 & 64) != 0) {
                            j5 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m1607getSurface0d7_KjU();
                            i9 &= -3670017;
                        } else {
                            j5 = j;
                        }
                        if ((i2 & 128) != 0) {
                            j6 = ColorsKt.m1621contentColorForek8zF_U(j5, startRestartGroup, (i9 >> 18) & 14);
                            i9 &= -29360129;
                        } else {
                            j6 = j2;
                        }
                        if ((i2 & 256) != 0) {
                            i9 &= -234881025;
                            f3 = m1703getElevationD9Ej5fM;
                            j8 = j5;
                            z4 = z2;
                            j9 = j6;
                            j7 = ModalBottomSheetDefaults.INSTANCE.getScrimColor(startRestartGroup, 6);
                            modifier2 = modifier3;
                            shape3 = cornerBasedShape;
                        } else {
                            j7 = j3;
                            shape3 = cornerBasedShape;
                            f3 = m1703getElevationD9Ej5fM;
                            j8 = j5;
                            z4 = z2;
                            j9 = j6;
                            modifier2 = modifier3;
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if (i4 != 0) {
                            i13 &= -897;
                        }
                        if ((i2 & 16) != 0) {
                            i13 &= -57345;
                        }
                        if ((i2 & 64) != 0) {
                            i13 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            i13 &= -29360129;
                        }
                        if ((i2 & 256) != 0) {
                            i13 &= -234881025;
                        }
                        j8 = j;
                        j7 = j3;
                        i9 = i13;
                        j9 = j4;
                        z3 = true;
                        z4 = z2;
                        shape3 = shape2;
                        f3 = f2;
                        modalBottomSheetState2 = modalBottomSheetState;
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-92970288, i9, -1, "androidx.compose.material.ModalBottomSheetLayout (ModalBottomSheet.kt:564)");
                    }
                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = startRestartGroup.consume(localDensity);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    final Density density = (Density) consume;
                    EffectsKt.SideEffect(new Function0<Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            ModalBottomSheetState.this.setDensity$material_release(density);
                        }
                    }, startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(773894976);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                    startRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                        startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                        rememberedValue = compositionScopedCoroutineScopeCanceller;
                    }
                    startRestartGroup.endReplaceableGroup();
                    final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                    startRestartGroup.endReplaceableGroup();
                    final Orientation orientation = Orientation.Vertical;
                    final ModalBottomSheetState modalBottomSheetState4 = modalBottomSheetState2;
                    BoxWithConstraintsKt.BoxWithConstraints(modifier2, null, false, ComposableLambdaKt.composableLambda(startRestartGroup, -1731958854, z3, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer3, Integer num) {
                            invoke(boxWithConstraintsScope, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer3, int i14) {
                            int i15;
                            float f5;
                            Modifier.Companion companion2;
                            Modifier modalBottomSheetAnchors;
                            Modifier.Companion companion3;
                            ComposerKt.sourceInformation(composer3, "C574@23778L430,586@24217L3634:ModalBottomSheet.kt#jmzs0o");
                            if ((i14 & 14) == 0) {
                                i15 = i14 | (composer3.changed(boxWithConstraintsScope) ? 4 : 2);
                            } else {
                                i15 = i14;
                            }
                            if ((i15 & 91) != 18 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1731958854, i15, -1, "androidx.compose.material.ModalBottomSheetLayout.<anonymous> (ModalBottomSheet.kt:573)");
                                }
                                float m6344getMaxHeightimpl = Constraints.m6344getMaxHeightimpl(boxWithConstraintsScope.mo815getConstraintsmsEJaDk());
                                Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                Function2<Composer, Integer, Unit> function22 = function2;
                                long j13 = j7;
                                final ModalBottomSheetState modalBottomSheetState5 = modalBottomSheetState4;
                                final CoroutineScope coroutineScope2 = coroutineScope;
                                composer3.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                composer3.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxSize$default);
                                if (!(composer3.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor);
                                } else {
                                    composer3.useNode();
                                }
                                Composer m3593constructorimpl = Updater.m3593constructorimpl(composer3);
                                Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                composer3.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer3, -1295117001, "C575@23820L9,576@23842L356:ModalBottomSheet.kt#jmzs0o");
                                function22.invoke(composer3, 0);
                                ModalBottomSheetKt.m1705Scrim3JVO9M(j13, new Function0<Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* compiled from: ModalBottomSheet.kt */
                                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                    @DebugMetadata(c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2$1$1$1", f = "ModalBottomSheet.kt", i = {}, l = {581}, m = "invokeSuspend", n = {}, s = {})
                                    /* renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2$1$1$1, reason: invalid class name */
                                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        final /* synthetic */ ModalBottomSheetState $sheetState;
                                        int label;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        AnonymousClass1(ModalBottomSheetState modalBottomSheetState, Continuation<? super AnonymousClass1> continuation) {
                                            super(2, continuation);
                                            this.$sheetState = modalBottomSheetState;
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            return new AnonymousClass1(this.$sheetState, continuation);
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
                                                this.label = 1;
                                                if (this.$sheetState.hide(this) == coroutine_suspended) {
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

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        if (ModalBottomSheetState.this.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(ModalBottomSheetValue.Hidden).booleanValue()) {
                                            BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new AnonymousClass1(ModalBottomSheetState.this, null), 3, null);
                                        }
                                    }
                                }, modalBottomSheetState5.getAnchoredDraggableState$material_release().getTargetValue() != ModalBottomSheetValue.Hidden, composer3, 0);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endReplaceableGroup();
                                composer3.endNode();
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                Modifier align = boxWithConstraintsScope.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter());
                                f5 = ModalBottomSheetKt.MaxModalBottomSheetWidth;
                                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(SizeKt.m935widthInVpY3zN4$default(align, 0.0f, f5, 1, null), 0.0f, 1, null);
                                composer3.startReplaceableGroup(1241535654);
                                ComposerKt.sourceInformation(composer3, "594@24579L354");
                                if (z4) {
                                    Modifier.Companion companion4 = Modifier.INSTANCE;
                                    Object anchoredDraggableState$material_release = modalBottomSheetState4.getAnchoredDraggableState$material_release();
                                    Orientation orientation2 = orientation;
                                    ModalBottomSheetState modalBottomSheetState6 = modalBottomSheetState4;
                                    composer3.startReplaceableGroup(511388516);
                                    ComposerKt.sourceInformation(composer3, "CC(remember)P(1,2):Composables.kt#9igjgp");
                                    boolean changed = composer3.changed(anchoredDraggableState$material_release) | composer3.changed(orientation2);
                                    Object rememberedValue2 = composer3.rememberedValue();
                                    if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue2 = ModalBottomSheetKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(modalBottomSheetState6.getAnchoredDraggableState$material_release(), orientation2);
                                        composer3.updateRememberedValue(rememberedValue2);
                                    }
                                    composer3.endReplaceableGroup();
                                    companion2 = NestedScrollModifierKt.nestedScroll$default(companion4, (NestedScrollConnection) rememberedValue2, null, 2, null);
                                } else {
                                    companion2 = Modifier.INSTANCE;
                                }
                                composer3.endReplaceableGroup();
                                Modifier then = fillMaxWidth$default.then(companion2);
                                final ModalBottomSheetState modalBottomSheetState7 = modalBottomSheetState4;
                                modalBottomSheetAnchors = ModalBottomSheetKt.modalBottomSheetAnchors(AnchoredDraggableKt.anchoredDraggable$default(OffsetKt.offset(then, new Function1<Density, IntOffset>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ IntOffset invoke(Density density2) {
                                        return IntOffset.m6508boximpl(m1707invokeBjo55l4(density2));
                                    }

                                    /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                                    public final long m1707invokeBjo55l4(Density density2) {
                                        return IntOffsetKt.IntOffset(0, MathKt.roundToInt(ModalBottomSheetState.this.getAnchoredDraggableState$material_release().requireOffset()));
                                    }
                                }), modalBottomSheetState4.getAnchoredDraggableState$material_release(), orientation, z4 && modalBottomSheetState4.getAnchoredDraggableState$material_release().getCurrentValue() != ModalBottomSheetValue.Hidden, false, null, false, 56, null), modalBottomSheetState4, m6344getMaxHeightimpl);
                                if (z4) {
                                    Modifier.Companion companion5 = Modifier.INSTANCE;
                                    final ModalBottomSheetState modalBottomSheetState8 = modalBottomSheetState4;
                                    final CoroutineScope coroutineScope3 = coroutineScope;
                                    companion3 = SemanticsModifierKt.semantics$default(companion5, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2.4
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                            invoke2(semanticsPropertyReceiver);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                            if (ModalBottomSheetState.this.isVisible()) {
                                                final ModalBottomSheetState modalBottomSheetState9 = ModalBottomSheetState.this;
                                                final CoroutineScope coroutineScope4 = coroutineScope3;
                                                SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt.ModalBottomSheetLayout.2.4.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(0);
                                                    }

                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Boolean invoke() {
                                                        if (ModalBottomSheetState.this.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(ModalBottomSheetValue.Hidden).booleanValue()) {
                                                            BuildersKt__Builders_commonKt.launch$default(coroutineScope4, null, null, new C00451(ModalBottomSheetState.this, null), 3, null);
                                                        }
                                                        return true;
                                                    }

                                                    /* compiled from: ModalBottomSheet.kt */
                                                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                                    @DebugMetadata(c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2$4$1$1", f = "ModalBottomSheet.kt", i = {}, l = {LevelPlayAdError.ERROR_CODE_LOAD_FAILED_ALREADY_CALLED}, m = "invokeSuspend", n = {}, s = {})
                                                    /* renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2$4$1$1, reason: invalid class name and collision with other inner class name */
                                                    static final class C00451 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                        final /* synthetic */ ModalBottomSheetState $sheetState;
                                                        int label;

                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        C00451(ModalBottomSheetState modalBottomSheetState, Continuation<? super C00451> continuation) {
                                                            super(2, continuation);
                                                            this.$sheetState = modalBottomSheetState;
                                                        }

                                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                            return new C00451(this.$sheetState, continuation);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function2
                                                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                            return ((C00451) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                        }

                                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                        public final Object invokeSuspend(Object obj) {
                                                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                            int i = this.label;
                                                            if (i == 0) {
                                                                ResultKt.throwOnFailure(obj);
                                                                this.label = 1;
                                                                if (this.$sheetState.hide(this) == coroutine_suspended) {
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
                                                }, 1, null);
                                                if (ModalBottomSheetState.this.getAnchoredDraggableState$material_release().getCurrentValue() == ModalBottomSheetValue.HalfExpanded) {
                                                    final ModalBottomSheetState modalBottomSheetState10 = ModalBottomSheetState.this;
                                                    final CoroutineScope coroutineScope5 = coroutineScope3;
                                                    SemanticsPropertiesKt.expand$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt.ModalBottomSheetLayout.2.4.2
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(0);
                                                        }

                                                        /* JADX WARN: Can't rename method to resolve collision */
                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Boolean invoke() {
                                                            if (ModalBottomSheetState.this.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(ModalBottomSheetValue.Expanded).booleanValue()) {
                                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope5, null, null, new AnonymousClass1(ModalBottomSheetState.this, null), 3, null);
                                                            }
                                                            return true;
                                                        }

                                                        /* compiled from: ModalBottomSheet.kt */
                                                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                                        @DebugMetadata(c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2$4$2$1", f = "ModalBottomSheet.kt", i = {}, l = {639}, m = "invokeSuspend", n = {}, s = {})
                                                        /* renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2$4$2$1, reason: invalid class name */
                                                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                            final /* synthetic */ ModalBottomSheetState $sheetState;
                                                            int label;

                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            AnonymousClass1(ModalBottomSheetState modalBottomSheetState, Continuation<? super AnonymousClass1> continuation) {
                                                                super(2, continuation);
                                                                this.$sheetState = modalBottomSheetState;
                                                            }

                                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                                return new AnonymousClass1(this.$sheetState, continuation);
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
                                                                    this.label = 1;
                                                                    if (this.$sheetState.expand$material_release(this) == coroutine_suspended) {
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
                                                    }, 1, null);
                                                } else if (ModalBottomSheetState.this.getHasHalfExpandedState$material_release()) {
                                                    final ModalBottomSheetState modalBottomSheetState11 = ModalBottomSheetState.this;
                                                    final CoroutineScope coroutineScope6 = coroutineScope3;
                                                    SemanticsPropertiesKt.collapse$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt.ModalBottomSheetLayout.2.4.3
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(0);
                                                        }

                                                        /* JADX WARN: Can't rename method to resolve collision */
                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Boolean invoke() {
                                                            if (ModalBottomSheetState.this.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(ModalBottomSheetValue.HalfExpanded).booleanValue()) {
                                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope6, null, null, new AnonymousClass1(ModalBottomSheetState.this, null), 3, null);
                                                            }
                                                            return true;
                                                        }

                                                        /* compiled from: ModalBottomSheet.kt */
                                                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                                        @DebugMetadata(c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2$4$3$1", f = "ModalBottomSheet.kt", i = {}, l = {649}, m = "invokeSuspend", n = {}, s = {})
                                                        /* renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2$4$3$1, reason: invalid class name */
                                                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                            final /* synthetic */ ModalBottomSheetState $sheetState;
                                                            int label;

                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            AnonymousClass1(ModalBottomSheetState modalBottomSheetState, Continuation<? super AnonymousClass1> continuation) {
                                                                super(2, continuation);
                                                                this.$sheetState = modalBottomSheetState;
                                                            }

                                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                                return new AnonymousClass1(this.$sheetState, continuation);
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
                                                                    this.label = 1;
                                                                    if (this.$sheetState.halfExpand$material_release(this) == coroutine_suspended) {
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
                                                    }, 1, null);
                                                }
                                            }
                                        }
                                    }, 1, null);
                                } else {
                                    companion3 = Modifier.INSTANCE;
                                }
                                Modifier then2 = modalBottomSheetAnchors.then(companion3);
                                Shape shape5 = shape3;
                                long j14 = j8;
                                long j15 = j9;
                                float f6 = f3;
                                final Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                                SurfaceKt.m1782SurfaceFjzlyU(then2, shape5, j14, j15, null, f6, ComposableLambdaKt.composableLambda(composer3, 1552994302, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2.5
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                        invoke(composer4, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i16) {
                                        ComposerKt.sourceInformation(composer4, "C662@27811L30:ModalBottomSheet.kt#jmzs0o");
                                        if ((i16 & 11) == 2 && composer4.getSkipping()) {
                                            composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1552994302, i16, -1, "androidx.compose.material.ModalBottomSheetLayout.<anonymous>.<anonymous> (ModalBottomSheet.kt:662)");
                                        }
                                        Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                                        composer4.startReplaceableGroup(-483455358);
                                        ComposerKt.sourceInformation(composer4, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                        Modifier.Companion companion6 = Modifier.INSTANCE;
                                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer4, 0);
                                        composer4.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                        CompositionLocalMap currentCompositionLocalMap2 = composer4.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion6);
                                        if (!(composer4.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer4.startReusableNode();
                                        if (composer4.getInserting()) {
                                            composer4.createNode(constructor2);
                                        } else {
                                            composer4.useNode();
                                        }
                                        Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer4);
                                        Updater.m3600setimpl(m3593constructorimpl2, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                            m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                            m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                        }
                                        modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer4)), composer4, 0);
                                        composer4.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer4, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                        function33.invoke(ColumnScopeInstance.INSTANCE, composer4, 6);
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        composer4.endReplaceableGroup();
                                        composer4.endNode();
                                        composer4.endReplaceableGroup();
                                        composer4.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), composer3, 1572864, 16);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), startRestartGroup, ((i9 >> 3) & 14) | 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier2;
                    composer2 = startRestartGroup;
                    z5 = z4;
                    modalBottomSheetState3 = modalBottomSheetState4;
                    shape4 = shape3;
                    j10 = j8;
                    j11 = j9;
                    f4 = f3;
                    j12 = j7;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    long j13 = j4;
                    modifier4 = modifier2;
                    z5 = z2;
                    j11 = j13;
                    modalBottomSheetState3 = modalBottomSheetState;
                    j10 = j;
                    composer2 = startRestartGroup;
                    shape4 = shape2;
                    f4 = f2;
                    j12 = j3;
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i14) {
                            ModalBottomSheetKt.m1704ModalBottomSheetLayoutGs3lGvM(function3, modifier4, modalBottomSheetState3, z5, shape4, f4, j10, j11, j12, function2, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            int i132 = i7;
            if (i4 == 4) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i8 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if (i6 != 0) {
            }
            if ((i2 & 64) != 0) {
            }
            if ((i2 & 128) != 0) {
            }
            if ((i2 & 256) != 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final Density density2 = (Density) consume2;
            EffectsKt.SideEffect(new Function0<Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ModalBottomSheetState.this.setDensity$material_release(density2);
                }
            }, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            final CoroutineScope coroutineScope2 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
            startRestartGroup.endReplaceableGroup();
            final Orientation orientation2 = Orientation.Vertical;
            final ModalBottomSheetState modalBottomSheetState42 = modalBottomSheetState2;
            BoxWithConstraintsKt.BoxWithConstraints(modifier2, null, false, ComposableLambdaKt.composableLambda(startRestartGroup, -1731958854, z3, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer3, Integer num) {
                    invoke(boxWithConstraintsScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer3, int i14) {
                    int i15;
                    float f5;
                    Modifier.Companion companion2;
                    Modifier modalBottomSheetAnchors;
                    Modifier.Companion companion3;
                    ComposerKt.sourceInformation(composer3, "C574@23778L430,586@24217L3634:ModalBottomSheet.kt#jmzs0o");
                    if ((i14 & 14) == 0) {
                        i15 = i14 | (composer3.changed(boxWithConstraintsScope) ? 4 : 2);
                    } else {
                        i15 = i14;
                    }
                    if ((i15 & 91) != 18 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1731958854, i15, -1, "androidx.compose.material.ModalBottomSheetLayout.<anonymous> (ModalBottomSheet.kt:573)");
                        }
                        float m6344getMaxHeightimpl = Constraints.m6344getMaxHeightimpl(boxWithConstraintsScope.mo815getConstraintsmsEJaDk());
                        Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Function2<Composer, Integer, Unit> function22 = function2;
                        long j132 = j7;
                        final ModalBottomSheetState modalBottomSheetState5 = modalBottomSheetState42;
                        final CoroutineScope coroutineScope22 = coroutineScope2;
                        composer3.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxSize$default);
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor);
                        } else {
                            composer3.useNode();
                        }
                        Composer m3593constructorimpl = Updater.m3593constructorimpl(composer3);
                        Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, -1295117001, "C575@23820L9,576@23842L356:ModalBottomSheet.kt#jmzs0o");
                        function22.invoke(composer3, 0);
                        ModalBottomSheetKt.m1705Scrim3JVO9M(j132, new Function0<Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* compiled from: ModalBottomSheet.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                            @DebugMetadata(c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2$1$1$1", f = "ModalBottomSheet.kt", i = {}, l = {581}, m = "invokeSuspend", n = {}, s = {})
                            /* renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2$1$1$1, reason: invalid class name */
                            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ ModalBottomSheetState $sheetState;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass1(ModalBottomSheetState modalBottomSheetState, Continuation<? super AnonymousClass1> continuation) {
                                    super(2, continuation);
                                    this.$sheetState = modalBottomSheetState;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new AnonymousClass1(this.$sheetState, continuation);
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
                                        this.label = 1;
                                        if (this.$sheetState.hide(this) == coroutine_suspended) {
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

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                if (ModalBottomSheetState.this.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(ModalBottomSheetValue.Hidden).booleanValue()) {
                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope22, null, null, new AnonymousClass1(ModalBottomSheetState.this, null), 3, null);
                                }
                            }
                        }, modalBottomSheetState5.getAnchoredDraggableState$material_release().getTargetValue() != ModalBottomSheetValue.Hidden, composer3, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        Modifier align = boxWithConstraintsScope.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter());
                        f5 = ModalBottomSheetKt.MaxModalBottomSheetWidth;
                        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(SizeKt.m935widthInVpY3zN4$default(align, 0.0f, f5, 1, null), 0.0f, 1, null);
                        composer3.startReplaceableGroup(1241535654);
                        ComposerKt.sourceInformation(composer3, "594@24579L354");
                        if (z4) {
                            Modifier.Companion companion4 = Modifier.INSTANCE;
                            Object anchoredDraggableState$material_release = modalBottomSheetState42.getAnchoredDraggableState$material_release();
                            Orientation orientation22 = orientation2;
                            ModalBottomSheetState modalBottomSheetState6 = modalBottomSheetState42;
                            composer3.startReplaceableGroup(511388516);
                            ComposerKt.sourceInformation(composer3, "CC(remember)P(1,2):Composables.kt#9igjgp");
                            boolean changed = composer3.changed(anchoredDraggableState$material_release) | composer3.changed(orientation22);
                            Object rememberedValue2 = composer3.rememberedValue();
                            if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue2 = ModalBottomSheetKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(modalBottomSheetState6.getAnchoredDraggableState$material_release(), orientation22);
                                composer3.updateRememberedValue(rememberedValue2);
                            }
                            composer3.endReplaceableGroup();
                            companion2 = NestedScrollModifierKt.nestedScroll$default(companion4, (NestedScrollConnection) rememberedValue2, null, 2, null);
                        } else {
                            companion2 = Modifier.INSTANCE;
                        }
                        composer3.endReplaceableGroup();
                        Modifier then = fillMaxWidth$default.then(companion2);
                        final ModalBottomSheetState modalBottomSheetState7 = modalBottomSheetState42;
                        modalBottomSheetAnchors = ModalBottomSheetKt.modalBottomSheetAnchors(AnchoredDraggableKt.anchoredDraggable$default(OffsetKt.offset(then, new Function1<Density, IntOffset>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ IntOffset invoke(Density density22) {
                                return IntOffset.m6508boximpl(m1707invokeBjo55l4(density22));
                            }

                            /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                            public final long m1707invokeBjo55l4(Density density22) {
                                return IntOffsetKt.IntOffset(0, MathKt.roundToInt(ModalBottomSheetState.this.getAnchoredDraggableState$material_release().requireOffset()));
                            }
                        }), modalBottomSheetState42.getAnchoredDraggableState$material_release(), orientation2, z4 && modalBottomSheetState42.getAnchoredDraggableState$material_release().getCurrentValue() != ModalBottomSheetValue.Hidden, false, null, false, 56, null), modalBottomSheetState42, m6344getMaxHeightimpl);
                        if (z4) {
                            Modifier.Companion companion5 = Modifier.INSTANCE;
                            final ModalBottomSheetState modalBottomSheetState8 = modalBottomSheetState42;
                            final CoroutineScope coroutineScope3 = coroutineScope2;
                            companion3 = SemanticsModifierKt.semantics$default(companion5, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2.4
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    if (ModalBottomSheetState.this.isVisible()) {
                                        final ModalBottomSheetState modalBottomSheetState9 = ModalBottomSheetState.this;
                                        final CoroutineScope coroutineScope4 = coroutineScope3;
                                        SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt.ModalBottomSheetLayout.2.4.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Boolean invoke() {
                                                if (ModalBottomSheetState.this.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(ModalBottomSheetValue.Hidden).booleanValue()) {
                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope4, null, null, new C00451(ModalBottomSheetState.this, null), 3, null);
                                                }
                                                return true;
                                            }

                                            /* compiled from: ModalBottomSheet.kt */
                                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                            @DebugMetadata(c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2$4$1$1", f = "ModalBottomSheet.kt", i = {}, l = {LevelPlayAdError.ERROR_CODE_LOAD_FAILED_ALREADY_CALLED}, m = "invokeSuspend", n = {}, s = {})
                                            /* renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2$4$1$1, reason: invalid class name and collision with other inner class name */
                                            static final class C00451 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                final /* synthetic */ ModalBottomSheetState $sheetState;
                                                int label;

                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                C00451(ModalBottomSheetState modalBottomSheetState, Continuation<? super C00451> continuation) {
                                                    super(2, continuation);
                                                    this.$sheetState = modalBottomSheetState;
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                    return new C00451(this.$sheetState, continuation);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                    return ((C00451) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Object invokeSuspend(Object obj) {
                                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                    int i = this.label;
                                                    if (i == 0) {
                                                        ResultKt.throwOnFailure(obj);
                                                        this.label = 1;
                                                        if (this.$sheetState.hide(this) == coroutine_suspended) {
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
                                        }, 1, null);
                                        if (ModalBottomSheetState.this.getAnchoredDraggableState$material_release().getCurrentValue() == ModalBottomSheetValue.HalfExpanded) {
                                            final ModalBottomSheetState modalBottomSheetState10 = ModalBottomSheetState.this;
                                            final CoroutineScope coroutineScope5 = coroutineScope3;
                                            SemanticsPropertiesKt.expand$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt.ModalBottomSheetLayout.2.4.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Boolean invoke() {
                                                    if (ModalBottomSheetState.this.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(ModalBottomSheetValue.Expanded).booleanValue()) {
                                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope5, null, null, new AnonymousClass1(ModalBottomSheetState.this, null), 3, null);
                                                    }
                                                    return true;
                                                }

                                                /* compiled from: ModalBottomSheet.kt */
                                                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                                @DebugMetadata(c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2$4$2$1", f = "ModalBottomSheet.kt", i = {}, l = {639}, m = "invokeSuspend", n = {}, s = {})
                                                /* renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2$4$2$1, reason: invalid class name */
                                                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                    final /* synthetic */ ModalBottomSheetState $sheetState;
                                                    int label;

                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    AnonymousClass1(ModalBottomSheetState modalBottomSheetState, Continuation<? super AnonymousClass1> continuation) {
                                                        super(2, continuation);
                                                        this.$sheetState = modalBottomSheetState;
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                        return new AnonymousClass1(this.$sheetState, continuation);
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
                                                            this.label = 1;
                                                            if (this.$sheetState.expand$material_release(this) == coroutine_suspended) {
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
                                            }, 1, null);
                                        } else if (ModalBottomSheetState.this.getHasHalfExpandedState$material_release()) {
                                            final ModalBottomSheetState modalBottomSheetState11 = ModalBottomSheetState.this;
                                            final CoroutineScope coroutineScope6 = coroutineScope3;
                                            SemanticsPropertiesKt.collapse$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt.ModalBottomSheetLayout.2.4.3
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Boolean invoke() {
                                                    if (ModalBottomSheetState.this.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(ModalBottomSheetValue.HalfExpanded).booleanValue()) {
                                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope6, null, null, new AnonymousClass1(ModalBottomSheetState.this, null), 3, null);
                                                    }
                                                    return true;
                                                }

                                                /* compiled from: ModalBottomSheet.kt */
                                                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                                @DebugMetadata(c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2$4$3$1", f = "ModalBottomSheet.kt", i = {}, l = {649}, m = "invokeSuspend", n = {}, s = {})
                                                /* renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2$4$3$1, reason: invalid class name */
                                                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                    final /* synthetic */ ModalBottomSheetState $sheetState;
                                                    int label;

                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    AnonymousClass1(ModalBottomSheetState modalBottomSheetState, Continuation<? super AnonymousClass1> continuation) {
                                                        super(2, continuation);
                                                        this.$sheetState = modalBottomSheetState;
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                        return new AnonymousClass1(this.$sheetState, continuation);
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
                                                            this.label = 1;
                                                            if (this.$sheetState.halfExpand$material_release(this) == coroutine_suspended) {
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
                                            }, 1, null);
                                        }
                                    }
                                }
                            }, 1, null);
                        } else {
                            companion3 = Modifier.INSTANCE;
                        }
                        Modifier then2 = modalBottomSheetAnchors.then(companion3);
                        Shape shape5 = shape3;
                        long j14 = j8;
                        long j15 = j9;
                        float f6 = f3;
                        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                        SurfaceKt.m1782SurfaceFjzlyU(then2, shape5, j14, j15, null, f6, ComposableLambdaKt.composableLambda(composer3, 1552994302, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2.5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i16) {
                                ComposerKt.sourceInformation(composer4, "C662@27811L30:ModalBottomSheet.kt#jmzs0o");
                                if ((i16 & 11) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1552994302, i16, -1, "androidx.compose.material.ModalBottomSheetLayout.<anonymous>.<anonymous> (ModalBottomSheet.kt:662)");
                                }
                                Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                                composer4.startReplaceableGroup(-483455358);
                                ComposerKt.sourceInformation(composer4, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                Modifier.Companion companion6 = Modifier.INSTANCE;
                                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer4, 0);
                                composer4.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                CompositionLocalMap currentCompositionLocalMap2 = composer4.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion6);
                                if (!(composer4.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer4.startReusableNode();
                                if (composer4.getInserting()) {
                                    composer4.createNode(constructor2);
                                } else {
                                    composer4.useNode();
                                }
                                Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer4);
                                Updater.m3600setimpl(m3593constructorimpl2, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                    m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                    m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                }
                                modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer4)), composer4, 0);
                                composer4.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer4, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                function33.invoke(ColumnScopeInstance.INSTANCE, composer4, 6);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                composer4.endReplaceableGroup();
                                composer4.endNode();
                                composer4.endReplaceableGroup();
                                composer4.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer3, 1572864, 16);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), startRestartGroup, ((i9 >> 3) & 14) | 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier4 = modifier2;
            composer2 = startRestartGroup;
            z5 = z4;
            modalBottomSheetState3 = modalBottomSheetState42;
            shape4 = shape3;
            j10 = j8;
            j11 = j9;
            f4 = f3;
            j12 = j7;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
        }
        i5 = i2 & 8;
        if (i5 == 0) {
        }
        if ((57344 & i) != 0) {
        }
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        if ((3670016 & i) != 0) {
        }
        if ((i & 29360128) != 0) {
        }
        if ((i & 234881024) == 0) {
        }
        if ((i2 & 512) == 0) {
        }
        int i1322 = i7;
        if (i4 == 4) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i8 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if (i6 != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if ((i2 & 128) != 0) {
        }
        if ((i2 & 256) != 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        ProvidableCompositionLocal<Density> localDensity22 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume22 = startRestartGroup.consume(localDensity22);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        final Density density22 = (Density) consume22;
        EffectsKt.SideEffect(new Function0<Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ModalBottomSheetState.this.setDensity$material_release(density22);
            }
        }, startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final CoroutineScope coroutineScope22 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
        startRestartGroup.endReplaceableGroup();
        final Orientation orientation22 = Orientation.Vertical;
        final ModalBottomSheetState modalBottomSheetState422 = modalBottomSheetState2;
        BoxWithConstraintsKt.BoxWithConstraints(modifier2, null, false, ComposableLambdaKt.composableLambda(startRestartGroup, -1731958854, z3, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer3, Integer num) {
                invoke(boxWithConstraintsScope, composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer3, int i14) {
                int i15;
                float f5;
                Modifier.Companion companion2;
                Modifier modalBottomSheetAnchors;
                Modifier.Companion companion3;
                ComposerKt.sourceInformation(composer3, "C574@23778L430,586@24217L3634:ModalBottomSheet.kt#jmzs0o");
                if ((i14 & 14) == 0) {
                    i15 = i14 | (composer3.changed(boxWithConstraintsScope) ? 4 : 2);
                } else {
                    i15 = i14;
                }
                if ((i15 & 91) != 18 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1731958854, i15, -1, "androidx.compose.material.ModalBottomSheetLayout.<anonymous> (ModalBottomSheet.kt:573)");
                    }
                    float m6344getMaxHeightimpl = Constraints.m6344getMaxHeightimpl(boxWithConstraintsScope.mo815getConstraintsmsEJaDk());
                    Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Function2<Composer, Integer, Unit> function22 = function2;
                    long j132 = j7;
                    final ModalBottomSheetState modalBottomSheetState5 = modalBottomSheetState422;
                    final CoroutineScope coroutineScope222 = coroutineScope22;
                    composer3.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxSize$default);
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor);
                    } else {
                        composer3.useNode();
                    }
                    Composer m3593constructorimpl = Updater.m3593constructorimpl(composer3);
                    Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer3, -1295117001, "C575@23820L9,576@23842L356:ModalBottomSheet.kt#jmzs0o");
                    function22.invoke(composer3, 0);
                    ModalBottomSheetKt.m1705Scrim3JVO9M(j132, new Function0<Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* compiled from: ModalBottomSheet.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                        @DebugMetadata(c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2$1$1$1", f = "ModalBottomSheet.kt", i = {}, l = {581}, m = "invokeSuspend", n = {}, s = {})
                        /* renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2$1$1$1, reason: invalid class name */
                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ ModalBottomSheetState $sheetState;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(ModalBottomSheetState modalBottomSheetState, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$sheetState = modalBottomSheetState;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass1(this.$sheetState, continuation);
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
                                    this.label = 1;
                                    if (this.$sheetState.hide(this) == coroutine_suspended) {
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

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            if (ModalBottomSheetState.this.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(ModalBottomSheetValue.Hidden).booleanValue()) {
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope222, null, null, new AnonymousClass1(ModalBottomSheetState.this, null), 3, null);
                            }
                        }
                    }, modalBottomSheetState5.getAnchoredDraggableState$material_release().getTargetValue() != ModalBottomSheetValue.Hidden, composer3, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    Modifier align = boxWithConstraintsScope.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter());
                    f5 = ModalBottomSheetKt.MaxModalBottomSheetWidth;
                    Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(SizeKt.m935widthInVpY3zN4$default(align, 0.0f, f5, 1, null), 0.0f, 1, null);
                    composer3.startReplaceableGroup(1241535654);
                    ComposerKt.sourceInformation(composer3, "594@24579L354");
                    if (z4) {
                        Modifier.Companion companion4 = Modifier.INSTANCE;
                        Object anchoredDraggableState$material_release = modalBottomSheetState422.getAnchoredDraggableState$material_release();
                        Orientation orientation222 = orientation22;
                        ModalBottomSheetState modalBottomSheetState6 = modalBottomSheetState422;
                        composer3.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composer3, "CC(remember)P(1,2):Composables.kt#9igjgp");
                        boolean changed = composer3.changed(anchoredDraggableState$material_release) | composer3.changed(orientation222);
                        Object rememberedValue2 = composer3.rememberedValue();
                        if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = ModalBottomSheetKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(modalBottomSheetState6.getAnchoredDraggableState$material_release(), orientation222);
                            composer3.updateRememberedValue(rememberedValue2);
                        }
                        composer3.endReplaceableGroup();
                        companion2 = NestedScrollModifierKt.nestedScroll$default(companion4, (NestedScrollConnection) rememberedValue2, null, 2, null);
                    } else {
                        companion2 = Modifier.INSTANCE;
                    }
                    composer3.endReplaceableGroup();
                    Modifier then = fillMaxWidth$default.then(companion2);
                    final ModalBottomSheetState modalBottomSheetState7 = modalBottomSheetState422;
                    modalBottomSheetAnchors = ModalBottomSheetKt.modalBottomSheetAnchors(AnchoredDraggableKt.anchoredDraggable$default(OffsetKt.offset(then, new Function1<Density, IntOffset>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2.3
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ IntOffset invoke(Density density222) {
                            return IntOffset.m6508boximpl(m1707invokeBjo55l4(density222));
                        }

                        /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                        public final long m1707invokeBjo55l4(Density density222) {
                            return IntOffsetKt.IntOffset(0, MathKt.roundToInt(ModalBottomSheetState.this.getAnchoredDraggableState$material_release().requireOffset()));
                        }
                    }), modalBottomSheetState422.getAnchoredDraggableState$material_release(), orientation22, z4 && modalBottomSheetState422.getAnchoredDraggableState$material_release().getCurrentValue() != ModalBottomSheetValue.Hidden, false, null, false, 56, null), modalBottomSheetState422, m6344getMaxHeightimpl);
                    if (z4) {
                        Modifier.Companion companion5 = Modifier.INSTANCE;
                        final ModalBottomSheetState modalBottomSheetState8 = modalBottomSheetState422;
                        final CoroutineScope coroutineScope3 = coroutineScope22;
                        companion3 = SemanticsModifierKt.semantics$default(companion5, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                if (ModalBottomSheetState.this.isVisible()) {
                                    final ModalBottomSheetState modalBottomSheetState9 = ModalBottomSheetState.this;
                                    final CoroutineScope coroutineScope4 = coroutineScope3;
                                    SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt.ModalBottomSheetLayout.2.4.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Boolean invoke() {
                                            if (ModalBottomSheetState.this.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(ModalBottomSheetValue.Hidden).booleanValue()) {
                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope4, null, null, new C00451(ModalBottomSheetState.this, null), 3, null);
                                            }
                                            return true;
                                        }

                                        /* compiled from: ModalBottomSheet.kt */
                                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                        @DebugMetadata(c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2$4$1$1", f = "ModalBottomSheet.kt", i = {}, l = {LevelPlayAdError.ERROR_CODE_LOAD_FAILED_ALREADY_CALLED}, m = "invokeSuspend", n = {}, s = {})
                                        /* renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2$4$1$1, reason: invalid class name and collision with other inner class name */
                                        static final class C00451 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                            final /* synthetic */ ModalBottomSheetState $sheetState;
                                            int label;

                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            C00451(ModalBottomSheetState modalBottomSheetState, Continuation<? super C00451> continuation) {
                                                super(2, continuation);
                                                this.$sheetState = modalBottomSheetState;
                                            }

                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                return new C00451(this.$sheetState, continuation);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                return ((C00451) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                            }

                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                            public final Object invokeSuspend(Object obj) {
                                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                int i = this.label;
                                                if (i == 0) {
                                                    ResultKt.throwOnFailure(obj);
                                                    this.label = 1;
                                                    if (this.$sheetState.hide(this) == coroutine_suspended) {
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
                                    }, 1, null);
                                    if (ModalBottomSheetState.this.getAnchoredDraggableState$material_release().getCurrentValue() == ModalBottomSheetValue.HalfExpanded) {
                                        final ModalBottomSheetState modalBottomSheetState10 = ModalBottomSheetState.this;
                                        final CoroutineScope coroutineScope5 = coroutineScope3;
                                        SemanticsPropertiesKt.expand$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt.ModalBottomSheetLayout.2.4.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Boolean invoke() {
                                                if (ModalBottomSheetState.this.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(ModalBottomSheetValue.Expanded).booleanValue()) {
                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope5, null, null, new AnonymousClass1(ModalBottomSheetState.this, null), 3, null);
                                                }
                                                return true;
                                            }

                                            /* compiled from: ModalBottomSheet.kt */
                                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                            @DebugMetadata(c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2$4$2$1", f = "ModalBottomSheet.kt", i = {}, l = {639}, m = "invokeSuspend", n = {}, s = {})
                                            /* renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2$4$2$1, reason: invalid class name */
                                            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                final /* synthetic */ ModalBottomSheetState $sheetState;
                                                int label;

                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                AnonymousClass1(ModalBottomSheetState modalBottomSheetState, Continuation<? super AnonymousClass1> continuation) {
                                                    super(2, continuation);
                                                    this.$sheetState = modalBottomSheetState;
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                    return new AnonymousClass1(this.$sheetState, continuation);
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
                                                        this.label = 1;
                                                        if (this.$sheetState.expand$material_release(this) == coroutine_suspended) {
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
                                        }, 1, null);
                                    } else if (ModalBottomSheetState.this.getHasHalfExpandedState$material_release()) {
                                        final ModalBottomSheetState modalBottomSheetState11 = ModalBottomSheetState.this;
                                        final CoroutineScope coroutineScope6 = coroutineScope3;
                                        SemanticsPropertiesKt.collapse$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt.ModalBottomSheetLayout.2.4.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Boolean invoke() {
                                                if (ModalBottomSheetState.this.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(ModalBottomSheetValue.HalfExpanded).booleanValue()) {
                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope6, null, null, new AnonymousClass1(ModalBottomSheetState.this, null), 3, null);
                                                }
                                                return true;
                                            }

                                            /* compiled from: ModalBottomSheet.kt */
                                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                            @DebugMetadata(c = "androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2$4$3$1", f = "ModalBottomSheet.kt", i = {}, l = {649}, m = "invokeSuspend", n = {}, s = {})
                                            /* renamed from: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2$4$3$1, reason: invalid class name */
                                            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                final /* synthetic */ ModalBottomSheetState $sheetState;
                                                int label;

                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                AnonymousClass1(ModalBottomSheetState modalBottomSheetState, Continuation<? super AnonymousClass1> continuation) {
                                                    super(2, continuation);
                                                    this.$sheetState = modalBottomSheetState;
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                    return new AnonymousClass1(this.$sheetState, continuation);
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
                                                        this.label = 1;
                                                        if (this.$sheetState.halfExpand$material_release(this) == coroutine_suspended) {
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
                                        }, 1, null);
                                    }
                                }
                            }
                        }, 1, null);
                    } else {
                        companion3 = Modifier.INSTANCE;
                    }
                    Modifier then2 = modalBottomSheetAnchors.then(companion3);
                    Shape shape5 = shape3;
                    long j14 = j8;
                    long j15 = j9;
                    float f6 = f3;
                    final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                    SurfaceKt.m1782SurfaceFjzlyU(then2, shape5, j14, j15, null, f6, ComposableLambdaKt.composableLambda(composer3, 1552994302, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetLayout$2.5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                            invoke(composer4, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer4, int i16) {
                            ComposerKt.sourceInformation(composer4, "C662@27811L30:ModalBottomSheet.kt#jmzs0o");
                            if ((i16 & 11) == 2 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1552994302, i16, -1, "androidx.compose.material.ModalBottomSheetLayout.<anonymous>.<anonymous> (ModalBottomSheet.kt:662)");
                            }
                            Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                            composer4.startReplaceableGroup(-483455358);
                            ComposerKt.sourceInformation(composer4, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                            Modifier.Companion companion6 = Modifier.INSTANCE;
                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer4, 0);
                            composer4.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = composer4.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion6);
                            if (!(composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer4.startReusableNode();
                            if (composer4.getInserting()) {
                                composer4.createNode(constructor2);
                            } else {
                                composer4.useNode();
                            }
                            Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer4);
                            Updater.m3600setimpl(m3593constructorimpl2, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                            }
                            modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer4)), composer4, 0);
                            composer4.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer4, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                            function33.invoke(ColumnScopeInstance.INSTANCE, composer4, 6);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            composer4.endReplaceableGroup();
                            composer4.endNode();
                            composer4.endReplaceableGroup();
                            composer4.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer3, 1572864, 16);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }), startRestartGroup, ((i9 >> 3) & 14) | 3072, 6);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier2;
        composer2 = startRestartGroup;
        z5 = z4;
        modalBottomSheetState3 = modalBottomSheetState422;
        shape4 = shape3;
        j10 = j8;
        j11 = j9;
        f4 = f3;
        j12 = j7;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier modalBottomSheetAnchors(Modifier modifier, final ModalBottomSheetState modalBottomSheetState, final float f) {
        return OnRemeasuredModifierKt.onSizeChanged(modifier, new Function1<IntSize, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$modalBottomSheetAnchors$1

            /* compiled from: ModalBottomSheet.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[ModalBottomSheetValue.values().length];
                    try {
                        iArr[ModalBottomSheetValue.Hidden.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[ModalBottomSheetValue.HalfExpanded.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[ModalBottomSheetValue.Expanded.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                m1709invokeozmzZPI(intSize.getPackedValue());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-ozmzZPI, reason: not valid java name */
            public final void m1709invokeozmzZPI(final long j) {
                ModalBottomSheetValue modalBottomSheetValue;
                final float f2 = f;
                final ModalBottomSheetState modalBottomSheetState2 = ModalBottomSheetState.this;
                DraggableAnchors<ModalBottomSheetValue> DraggableAnchors = AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<ModalBottomSheetValue>, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$modalBottomSheetAnchors$1$newAnchors$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<ModalBottomSheetValue> draggableAnchorsConfig) {
                        invoke2(draggableAnchorsConfig);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DraggableAnchorsConfig<ModalBottomSheetValue> draggableAnchorsConfig) {
                        draggableAnchorsConfig.at(ModalBottomSheetValue.Hidden, f2);
                        float f3 = f2 / 2.0f;
                        if (!modalBottomSheetState2.getIsSkipHalfExpanded() && IntSize.m6558getHeightimpl(j) > f3) {
                            draggableAnchorsConfig.at(ModalBottomSheetValue.HalfExpanded, f3);
                        }
                        if (IntSize.m6558getHeightimpl(j) != 0) {
                            draggableAnchorsConfig.at(ModalBottomSheetValue.Expanded, Math.max(0.0f, f2 - IntSize.m6558getHeightimpl(j)));
                        }
                    }
                });
                boolean z = ModalBottomSheetState.this.getAnchoredDraggableState$material_release().getAnchors().getSize() > 0;
                ModalBottomSheetValue currentValue = ModalBottomSheetState.this.getCurrentValue();
                if (z || !DraggableAnchors.hasAnchorFor(currentValue)) {
                    int i = WhenMappings.$EnumSwitchMapping$0[ModalBottomSheetState.this.getTargetValue().ordinal()];
                    if (i == 1) {
                        currentValue = ModalBottomSheetValue.Hidden;
                    } else if (i == 2 || i == 3) {
                        if (DraggableAnchors.hasAnchorFor(ModalBottomSheetValue.HalfExpanded)) {
                            modalBottomSheetValue = ModalBottomSheetValue.HalfExpanded;
                        } else if (DraggableAnchors.hasAnchorFor(ModalBottomSheetValue.Expanded)) {
                            modalBottomSheetValue = ModalBottomSheetValue.Expanded;
                        } else {
                            modalBottomSheetValue = ModalBottomSheetValue.Hidden;
                        }
                        currentValue = modalBottomSheetValue;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                ModalBottomSheetState.this.getAnchoredDraggableState$material_release().updateAnchors(DraggableAnchors, currentValue);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Scrim-3J-VO9M, reason: not valid java name */
    public static final void m1705Scrim3JVO9M(final long j, final Function0<Unit> function0, final boolean z, Composer composer, final int i) {
        int i2;
        Modifier.Companion companion;
        Composer startRestartGroup = composer.startRestartGroup(-526532668);
        ComposerKt.sourceInformation(startRestartGroup, "C(Scrim)P(0:c#ui.graphics.Color)714@29494L121,718@29641L29,730@30047L171:ModalBottomSheet.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i2 & 731) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-526532668, i2, -1, "androidx.compose.material.Scrim (ModalBottomSheet.kt:712)");
            }
            if (j != Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                final State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, null, startRestartGroup, 48, 28);
                final String m1780getString4foXLRw = Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1774getCloseSheetUdPEhr4(), startRestartGroup, 6);
                if (z) {
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    startRestartGroup.startReplaceableGroup(-1375678423);
                    boolean changedInstance = startRestartGroup.changedInstance(function0);
                    ModalBottomSheetKt$Scrim$dismissModifier$1$1 rememberedValue = startRestartGroup.rememberedValue();
                    if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new ModalBottomSheetKt$Scrim$dismissModifier$1$1(function0, null);
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    startRestartGroup.endReplaceableGroup();
                    Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(companion2, function0, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue);
                    startRestartGroup.startReplaceableGroup(-1375678333);
                    boolean changed = startRestartGroup.changed(m1780getString4foXLRw) | startRestartGroup.changedInstance(function0);
                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                    if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$Scrim$dismissModifier$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, m1780getString4foXLRw);
                                final Function0<Unit> function02 = function0;
                                SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt$Scrim$dismissModifier$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        function02.invoke();
                                        return true;
                                    }
                                }, 1, null);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    startRestartGroup.endReplaceableGroup();
                    companion = SemanticsModifierKt.semantics(pointerInput, true, (Function1) rememberedValue2);
                } else {
                    companion = Modifier.INSTANCE;
                }
                Modifier then = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then(companion);
                startRestartGroup.startReplaceableGroup(-1375678045);
                boolean changed2 = startRestartGroup.changed(j) | startRestartGroup.changed(animateFloatAsState);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$Scrim$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                            invoke2(drawScope);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(DrawScope drawScope) {
                            float Scrim_3J_VO9M$lambda$1;
                            long j2 = j;
                            Scrim_3J_VO9M$lambda$1 = ModalBottomSheetKt.Scrim_3J_VO9M$lambda$1(animateFloatAsState);
                            DrawScope.m4607drawRectnJ9OG0$default(drawScope, j2, 0L, 0L, Scrim_3J_VO9M$lambda$1, null, null, 0, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, null);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceableGroup();
                CanvasKt.Canvas(then, (Function1) rememberedValue3, startRestartGroup, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$Scrim$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ModalBottomSheetKt.m1705Scrim3JVO9M(j, function0, z, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(AnchoredDraggableState<?> anchoredDraggableState, Orientation orientation) {
        return new ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1(anchoredDraggableState, orientation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float Scrim_3J_VO9M$lambda$1(State<Float> state) {
        return state.getValue().floatValue();
    }
}
