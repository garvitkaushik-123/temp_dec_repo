package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
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
import androidx.compose.foundation.layout.PaddingKt;
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
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.vungle.ads.internal.protos.Sdk;
import io.bidmachine.iab.vast.tags.VastAttributes;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Drawer.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0093\u0001\u0010\t\u001a\u00020\n2\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001a2\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\n0\u001e¢\u0006\u0002\b\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a0\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u001a2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\n0\u001e2\u0006\u0010$\u001a\u00020\u0015H\u0003ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a.\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00150\fH\u0007\u001a\u0014\u0010-\u001a\u00020.2\n\u0010/\u001a\u0006\u0012\u0002\b\u000300H\u0002\u001a\u0093\u0001\u00101\u001a\u00020\n2\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u0002022\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001a2\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\n0\u001e¢\u0006\u0002\b\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b3\u00104\u001a>\u00105\u001a\u00020\n2\u0006\u00106\u001a\u00020\u00152\f\u00107\u001a\b\u0012\u0004\u0012\u00020\n0\u001e2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00020\u001e2\u0006\u0010\"\u001a\u00020\u001aH\u0003ø\u0001\u0000¢\u0006\u0004\b9\u0010:\u001a \u0010;\u001a\u00020\u00022\u0006\u0010<\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u00022\u0006\u0010>\u001a\u00020\u0002H\u0002\u001a+\u0010?\u001a\u00020\u00132\u0006\u0010(\u001a\u00020)2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00150\fH\u0007¢\u0006\u0002\u0010@\u001a+\u0010A\u001a\u0002022\u0006\u0010(\u001a\u00020B2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020\u00150\fH\u0007¢\u0006\u0002\u0010C\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006D²\u0006\n\u0010E\u001a\u00020\u0002X\u008a\u0084\u0002"}, d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "BottomDrawerOpenFraction", "DrawerPositionalThreshold", "Landroidx/compose/ui/unit/Dp;", "F", "DrawerVelocityThreshold", "EndDrawerPadding", "BottomDrawer", "", "drawerContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "drawerState", "Landroidx/compose/material/BottomDrawerState;", "gesturesEnabled", "", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerElevation", "drawerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "drawerContentColor", "scrimColor", "content", "Lkotlin/Function0;", "BottomDrawer-Gs3lGvM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BottomDrawerState;ZLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "BottomDrawerScrim", "color", "onDismiss", VastAttributes.VISIBLE, "BottomDrawerScrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "BottomDrawerState", "initialValue", "Landroidx/compose/material/BottomDrawerValue;", "density", "Landroidx/compose/ui/unit/Density;", "confirmStateChange", "ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "state", "Landroidx/compose/material/AnchoredDraggableState;", "ModalDrawer", "Landroidx/compose/material/DrawerState;", "ModalDrawer-Gs3lGvM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/DrawerState;ZLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Scrim", "open", "onClose", "fraction", "Scrim-Bx497Mc", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;JLandroidx/compose/runtime/Composer;I)V", "calculateFraction", "a", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "pos", "rememberBottomDrawerState", "(Landroidx/compose/material/BottomDrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomDrawerState;", "rememberDrawerState", "Landroidx/compose/material/DrawerValue;", "(Landroidx/compose/material/DrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/DrawerState;", "material_release", "alpha"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DrawerKt {
    private static final float BottomDrawerOpenFraction = 0.5f;
    private static final float DrawerPositionalThreshold;
    private static final float EndDrawerPadding;
    private static final float DrawerVelocityThreshold = Dp.m6389constructorimpl(400);
    private static final TweenSpec<Float> AnimationSpec = new TweenSpec<>(256, 0, null, 6, null);

    public static /* synthetic */ BottomDrawerState BottomDrawerState$default(BottomDrawerValue bottomDrawerValue, Density density, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = new Function1<BottomDrawerValue, Boolean>() { // from class: androidx.compose.material.DrawerKt$BottomDrawerState$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(BottomDrawerValue bottomDrawerValue2) {
                    return true;
                }
            };
        }
        return BottomDrawerState(bottomDrawerValue, density, function1);
    }

    public static final BottomDrawerState BottomDrawerState(BottomDrawerValue bottomDrawerValue, Density density, Function1<? super BottomDrawerValue, Boolean> function1) {
        BottomDrawerState bottomDrawerState = new BottomDrawerState(bottomDrawerValue, function1);
        bottomDrawerState.setDensity$material_release(density);
        return bottomDrawerState;
    }

    public static final DrawerState rememberDrawerState(final DrawerValue drawerValue, final Function1<? super DrawerValue, Boolean> function1, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1435874229);
        ComposerKt.sourceInformation(composer, "C(rememberDrawerState)P(1)449@15518L125:Drawer.kt#jmzs0o");
        if ((i2 & 2) != 0) {
            function1 = new Function1<DrawerValue, Boolean>() { // from class: androidx.compose.material.DrawerKt$rememberDrawerState$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(DrawerValue drawerValue2) {
                    return true;
                }
            };
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1435874229, i, -1, "androidx.compose.material.rememberDrawerState (Drawer.kt:448)");
        }
        Object[] objArr = new Object[0];
        Saver<DrawerState, DrawerValue> Saver = DrawerState.INSTANCE.Saver(function1);
        composer.startReplaceableGroup(463496927);
        boolean changed = composer.changed(drawerValue) | composer.changedInstance(function1);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = (Function0) new Function0<DrawerState>() { // from class: androidx.compose.material.DrawerKt$rememberDrawerState$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final DrawerState invoke() {
                    return new DrawerState(DrawerValue.this, function1);
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        DrawerState drawerState = (DrawerState) RememberSaveableKt.m3680rememberSaveable(objArr, (Saver) Saver, (String) null, (Function0) rememberedValue, composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return drawerState;
    }

    public static final BottomDrawerState rememberBottomDrawerState(final BottomDrawerValue bottomDrawerValue, final Function1<? super BottomDrawerValue, Boolean> function1, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-598115156);
        ComposerKt.sourceInformation(composer, "C(rememberBottomDrawerState)P(1)466@16084L7,467@16103L164:Drawer.kt#jmzs0o");
        if ((i2 & 2) != 0) {
            function1 = new Function1<BottomDrawerValue, Boolean>() { // from class: androidx.compose.material.DrawerKt$rememberBottomDrawerState$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(BottomDrawerValue bottomDrawerValue2) {
                    return true;
                }
            };
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-598115156, i, -1, "androidx.compose.material.rememberBottomDrawerState (Drawer.kt:465)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final Density density = (Density) consume;
        Object[] objArr = {density};
        Saver<BottomDrawerState, BottomDrawerValue> Saver = BottomDrawerState.Companion.Saver(density, function1);
        composer.startReplaceableGroup(463497536);
        boolean changed = composer.changed(bottomDrawerValue) | composer.changed(density) | composer.changedInstance(function1);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = (Function0) new Function0<BottomDrawerState>() { // from class: androidx.compose.material.DrawerKt$rememberBottomDrawerState$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final BottomDrawerState invoke() {
                    return DrawerKt.BottomDrawerState(BottomDrawerValue.this, density, function1);
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        BottomDrawerState bottomDrawerState = (BottomDrawerState) RememberSaveableKt.m3680rememberSaveable(objArr, (Saver) Saver, (String) null, (Function0) rememberedValue, composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return bottomDrawerState;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x029f  */
    /* renamed from: ModalDrawer-Gs3lGvM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1652ModalDrawerGs3lGvM(final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, DrawerState drawerState, boolean z, Shape shape, float f, long j, long j2, long j3, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        DrawerState drawerState2;
        int i4;
        boolean z2;
        Shape shape2;
        int i5;
        float f2;
        int i6;
        long j4;
        Modifier.Companion companion;
        DrawerState drawerState3;
        CornerBasedShape cornerBasedShape;
        long j5;
        long j6;
        final DrawerState drawerState4;
        final Shape shape3;
        final float f3;
        final long j7;
        final long j8;
        Object obj;
        final long j9;
        final boolean z3;
        Object rememberedValue;
        final Modifier modifier3;
        final DrawerState drawerState5;
        final boolean z4;
        final long j10;
        final Shape shape4;
        final long j11;
        final long j12;
        final float f4;
        ScopeUpdateScope endRestartGroup;
        int i7;
        int i8;
        int i9;
        int i10;
        Composer startRestartGroup = composer.startRestartGroup(1305806945);
        ComposerKt.sourceInformation(startRestartGroup, "C(ModalDrawer)P(2,8,6,7,5,4:c#ui.unit.Dp,1:c#ui.graphics.Color,3:c#ui.graphics.Color,9:c#ui.graphics.Color)506@18077L39,508@18194L6,510@18309L6,511@18357L38,512@18436L10,515@18504L24,516@18533L3492:Drawer.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changedInstance(function3) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i11 = i2 & 2;
        if (i11 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i & 896) != 0) {
                if ((i2 & 4) == 0) {
                    drawerState2 = drawerState;
                    if (startRestartGroup.changed(drawerState2)) {
                        i10 = 256;
                        i3 |= i10;
                    }
                } else {
                    drawerState2 = drawerState;
                }
                i10 = 128;
                i3 |= i10;
            } else {
                drawerState2 = drawerState;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        shape2 = shape;
                        if (startRestartGroup.changed(shape2)) {
                            i9 = 16384;
                            i3 |= i9;
                        }
                    } else {
                        shape2 = shape;
                    }
                    i9 = 8192;
                    i3 |= i9;
                } else {
                    shape2 = shape;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((458752 & i) == 0) {
                    f2 = f;
                    i3 |= startRestartGroup.changed(f2) ? 131072 : 65536;
                    if ((3670016 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            i7 = i3;
                            if (startRestartGroup.changed(j)) {
                                i8 = 1048576;
                                i6 = i7 | i8;
                            }
                        } else {
                            i7 = i3;
                        }
                        i8 = 524288;
                        i6 = i7 | i8;
                    } else {
                        i6 = i3;
                    }
                    if ((i & 29360128) == 0) {
                        i6 |= ((i2 & 128) == 0 && startRestartGroup.changed(j2)) ? 8388608 : 4194304;
                    }
                    if ((234881024 & i) != 0) {
                        j4 = j3;
                        i6 |= ((i2 & 256) == 0 && startRestartGroup.changed(j4)) ? 67108864 : 33554432;
                    } else {
                        j4 = j3;
                    }
                    if ((i2 & 512) == 0) {
                        i6 |= C.ENCODING_PCM_32BIT;
                    } else if ((1879048192 & i) == 0) {
                        i6 |= startRestartGroup.changedInstance(function2) ? 536870912 : 268435456;
                        if ((1533916891 & i6) == 306783378 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                companion = i11 != 0 ? Modifier.INSTANCE : modifier2;
                                if ((i2 & 4) != 0) {
                                    drawerState3 = rememberDrawerState(DrawerValue.Closed, null, startRestartGroup, 6, 2);
                                    i6 &= -897;
                                } else {
                                    drawerState3 = drawerState2;
                                }
                                if (i4 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 16) != 0) {
                                    cornerBasedShape = MaterialTheme.INSTANCE.getShapes(startRestartGroup, 6).getLarge();
                                    i6 &= -57345;
                                } else {
                                    cornerBasedShape = shape2;
                                }
                                float m1649getElevationD9Ej5fM = i5 != 0 ? DrawerDefaults.INSTANCE.m1649getElevationD9Ej5fM() : f2;
                                if ((i2 & 64) != 0) {
                                    j5 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m1607getSurface0d7_KjU();
                                    i6 &= -3670017;
                                } else {
                                    j5 = j;
                                }
                                if ((i2 & 128) != 0) {
                                    j6 = ColorsKt.m1621contentColorForek8zF_U(j5, startRestartGroup, (i6 >> 18) & 14);
                                    i6 &= -29360129;
                                } else {
                                    j6 = j2;
                                }
                                if ((i2 & 256) != 0) {
                                    j4 = DrawerDefaults.INSTANCE.getScrimColor(startRestartGroup, 6);
                                    i6 &= -234881025;
                                }
                                drawerState4 = drawerState3;
                                shape3 = cornerBasedShape;
                                f3 = m1649getElevationD9Ej5fM;
                                j7 = j5;
                                j8 = j6;
                                obj = null;
                                j9 = j4;
                                z3 = z2;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 4) != 0) {
                                    i6 &= -897;
                                }
                                if ((i2 & 16) != 0) {
                                    i6 &= -57345;
                                }
                                if ((i2 & 64) != 0) {
                                    i6 &= -3670017;
                                }
                                if ((i2 & 128) != 0) {
                                    i6 &= -29360129;
                                }
                                if ((i2 & 256) != 0) {
                                    i6 &= -234881025;
                                }
                                j7 = j;
                                j8 = j2;
                                j9 = j4;
                                companion = modifier2;
                                drawerState4 = drawerState2;
                                z3 = z2;
                                shape3 = shape2;
                                f3 = f2;
                                obj = null;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1305806945, i6, -1, "androidx.compose.material.ModalDrawer (Drawer.kt:514)");
                            }
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
                            BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(companion, 0.0f, 1, obj), null, false, ComposableLambdaKt.composableLambda(startRestartGroup, 816674999, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, Integer num) {
                                    invoke(boxWithConstraintsScope, composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, int i12) {
                                    BoxWithConstraintsScope boxWithConstraintsScope2;
                                    int i13;
                                    float f5;
                                    ComposerKt.sourceInformation(composer2, "C525@18955L7,526@18971L285,535@19299L7,536@19338L2681:Drawer.kt#jmzs0o");
                                    if ((i12 & 14) == 0) {
                                        boxWithConstraintsScope2 = boxWithConstraintsScope;
                                        i13 = i12 | (composer2.changed(boxWithConstraintsScope2) ? 4 : 2);
                                    } else {
                                        boxWithConstraintsScope2 = boxWithConstraintsScope;
                                        i13 = i12;
                                    }
                                    if ((i13 & 91) != 18 || !composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(816674999, i13, -1, "androidx.compose.material.ModalDrawer.<anonymous> (Drawer.kt:517)");
                                        }
                                        long mo815getConstraintsmsEJaDk = boxWithConstraintsScope2.mo815getConstraintsmsEJaDk();
                                        if (!Constraints.m6341getHasBoundedWidthimpl(mo815getConstraintsmsEJaDk)) {
                                            throw new IllegalStateException("Drawer shouldn't have infinite width");
                                        }
                                        final float f6 = -Constraints.m6345getMaxWidthimpl(mo815getConstraintsmsEJaDk);
                                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                        Object consume = composer2.consume(localDensity);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        final Density density = (Density) consume;
                                        composer2.startReplaceableGroup(463500327);
                                        final float f7 = 0.0f;
                                        boolean changed = composer2.changed(DrawerState.this) | composer2.changed(density) | composer2.changed(f6) | composer2.changed(0.0f);
                                        final DrawerState drawerState6 = DrawerState.this;
                                        Object rememberedValue2 = composer2.rememberedValue();
                                        if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$1$1
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
                                                    DrawerState.this.setDensity$material_release(density);
                                                    final float f8 = f6;
                                                    final float f9 = f7;
                                                    AnchoredDraggableState.updateAnchors$default(DrawerState.this.getAnchoredDraggableState$material_release(), AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<DrawerValue>, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$1$1$anchors$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                                                            invoke2(draggableAnchorsConfig);
                                                            return Unit.INSTANCE;
                                                        }

                                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                        public final void invoke2(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                                                            draggableAnchorsConfig.at(DrawerValue.Closed, f8);
                                                            draggableAnchorsConfig.at(DrawerValue.Open, f9);
                                                        }
                                                    }), null, 2, null);
                                                }
                                            };
                                            composer2.updateRememberedValue(rememberedValue2);
                                        }
                                        composer2.endReplaceableGroup();
                                        EffectsKt.SideEffect((Function0) rememberedValue2, composer2, 0);
                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                        Object consume2 = composer2.consume(localLayoutDirection);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        Modifier anchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(Modifier.INSTANCE, DrawerState.this.getAnchoredDraggableState$material_release(), Orientation.Horizontal, z3, consume2 == LayoutDirection.Rtl, null, false, 48, null);
                                        final DrawerState drawerState7 = DrawerState.this;
                                        long j13 = j9;
                                        Shape shape5 = shape3;
                                        long j14 = j7;
                                        long j15 = j8;
                                        float f8 = f3;
                                        Function2<Composer, Integer, Unit> function22 = function2;
                                        final boolean z5 = z3;
                                        final CoroutineScope coroutineScope2 = coroutineScope;
                                        final Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                                        composer2.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                                        composer2.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(anchoredDraggable$default);
                                        if (!(composer2.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer2.startReusableNode();
                                        if (composer2.getInserting()) {
                                            composer2.createNode(constructor);
                                        } else {
                                            composer2.useNode();
                                        }
                                        Composer m3593constructorimpl = Updater.m3593constructorimpl(composer2);
                                        Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                        }
                                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                                        composer2.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer2, 413829170, "C545@19656L45,548@19714L553,563@20301L33,*565@20401L7,564@20347L1662:Drawer.kt#jmzs0o");
                                        composer2.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        Modifier.Companion companion2 = Modifier.INSTANCE;
                                        MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                                        composer2.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                        CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion2);
                                        if (!(composer2.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer2.startReusableNode();
                                        if (composer2.getInserting()) {
                                            composer2.createNode(constructor2);
                                        } else {
                                            composer2.useNode();
                                        }
                                        Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer2);
                                        Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                            m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                            m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                        }
                                        modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                                        composer2.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer2, 392280937, "C546@19678L9:Drawer.kt#jmzs0o");
                                        function22.invoke(composer2, 0);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        composer2.endReplaceableGroup();
                                        composer2.endNode();
                                        composer2.endReplaceableGroup();
                                        composer2.endReplaceableGroup();
                                        boolean isOpen = drawerState7.isOpen();
                                        Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$2
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
                                                if (z5 && drawerState7.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(DrawerValue.Closed).booleanValue()) {
                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new AnonymousClass1(drawerState7, null), 3, null);
                                                }
                                            }

                                            /* compiled from: Drawer.kt */
                                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                            @DebugMetadata(c = "androidx.compose.material.DrawerKt$ModalDrawer$1$2$2$1", f = "Drawer.kt", i = {}, l = {556}, m = "invokeSuspend", n = {}, s = {})
                                            /* renamed from: androidx.compose.material.DrawerKt$ModalDrawer$1$2$2$1, reason: invalid class name */
                                            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                final /* synthetic */ DrawerState $drawerState;
                                                int label;

                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                                    super(2, continuation);
                                                    this.$drawerState = drawerState;
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                    return new AnonymousClass1(this.$drawerState, continuation);
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
                                                        if (this.$drawerState.close(this) == coroutine_suspended) {
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
                                        };
                                        composer2.startReplaceableGroup(463501456);
                                        boolean changed2 = composer2.changed(f6) | composer2.changed(0.0f) | composer2.changed(drawerState7);
                                        Object rememberedValue3 = composer2.rememberedValue();
                                        if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            final float f9 = 0.0f;
                                            rememberedValue3 = (Function0) new Function0<Float>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$3$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Float invoke() {
                                                    float calculateFraction;
                                                    calculateFraction = DrawerKt.calculateFraction(f6, f9, drawerState7.requireOffset$material_release());
                                                    return Float.valueOf(calculateFraction);
                                                }
                                            };
                                            composer2.updateRememberedValue(rememberedValue3);
                                        }
                                        composer2.endReplaceableGroup();
                                        DrawerKt.m1653ScrimBx497Mc(isOpen, function0, (Function0) rememberedValue3, j13, composer2, 0);
                                        final String m1780getString4foXLRw = Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1777getNavigationMenuUdPEhr4(), composer2, 6);
                                        ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                        Object consume3 = composer2.consume(localDensity2);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        Density density2 = (Density) consume3;
                                        Modifier m931sizeInqDBjuR0 = SizeKt.m931sizeInqDBjuR0(Modifier.INSTANCE, density2.mo627toDpu2uoSUM(Constraints.m6347getMinWidthimpl(mo815getConstraintsmsEJaDk)), density2.mo627toDpu2uoSUM(Constraints.m6346getMinHeightimpl(mo815getConstraintsmsEJaDk)), density2.mo627toDpu2uoSUM(Constraints.m6345getMaxWidthimpl(mo815getConstraintsmsEJaDk)), density2.mo627toDpu2uoSUM(Constraints.m6344getMaxHeightimpl(mo815getConstraintsmsEJaDk)));
                                        composer2.startReplaceableGroup(463502210);
                                        boolean changed3 = composer2.changed(drawerState7);
                                        Object rememberedValue4 = composer2.rememberedValue();
                                        if (changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue4 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$5$1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ IntOffset invoke(Density density3) {
                                                    return IntOffset.m6508boximpl(m1659invokeBjo55l4(density3));
                                                }

                                                /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                                                public final long m1659invokeBjo55l4(Density density3) {
                                                    return IntOffsetKt.IntOffset(MathKt.roundToInt(DrawerState.this.requireOffset$material_release()), 0);
                                                }
                                            };
                                            composer2.updateRememberedValue(rememberedValue4);
                                        }
                                        composer2.endReplaceableGroup();
                                        Modifier offset = OffsetKt.offset(m931sizeInqDBjuR0, (Function1) rememberedValue4);
                                        f5 = DrawerKt.EndDrawerPadding;
                                        SurfaceKt.m1782SurfaceFjzlyU(SemanticsModifierKt.semantics$default(PaddingKt.m883paddingqDBjuR0$default(offset, 0.0f, 0.0f, f5, 0.0f, 11, null), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6
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
                                                SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m1780getString4foXLRw);
                                                if (drawerState7.isOpen()) {
                                                    final DrawerState drawerState8 = drawerState7;
                                                    final CoroutineScope coroutineScope3 = coroutineScope2;
                                                    SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(0);
                                                        }

                                                        /* JADX WARN: Can't rename method to resolve collision */
                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Boolean invoke() {
                                                            if (DrawerState.this.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(DrawerValue.Closed).booleanValue()) {
                                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new C00431(DrawerState.this, null), 3, null);
                                                            }
                                                            return true;
                                                        }

                                                        /* compiled from: Drawer.kt */
                                                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                                        @DebugMetadata(c = "androidx.compose.material.DrawerKt$ModalDrawer$1$2$6$1$1", f = "Drawer.kt", i = {}, l = {591}, m = "invokeSuspend", n = {}, s = {})
                                                        /* renamed from: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6$1$1, reason: invalid class name and collision with other inner class name */
                                                        static final class C00431 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                            final /* synthetic */ DrawerState $drawerState;
                                                            int label;

                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            C00431(DrawerState drawerState, Continuation<? super C00431> continuation) {
                                                                super(2, continuation);
                                                                this.$drawerState = drawerState;
                                                            }

                                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                                return new C00431(this.$drawerState, continuation);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function2
                                                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                                return ((C00431) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                            }

                                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                            public final Object invokeSuspend(Object obj) {
                                                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                                int i = this.label;
                                                                if (i == 0) {
                                                                    ResultKt.throwOnFailure(obj);
                                                                    this.label = 1;
                                                                    if (this.$drawerState.close(this) == coroutine_suspended) {
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
                                        }, 1, null), shape5, j14, j15, null, f8, ComposableLambdaKt.composableLambda(composer2, -1941234439, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$7
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
                                                ComposerKt.sourceInformation(composer3, "C600@21940L55:Drawer.kt#jmzs0o");
                                                if ((i14 & 11) == 2 && composer3.getSkipping()) {
                                                    composer3.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1941234439, i14, -1, "androidx.compose.material.ModalDrawer.<anonymous>.<anonymous>.<anonymous> (Drawer.kt:600)");
                                                }
                                                Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                                Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                                                composer3.startReplaceableGroup(-483455358);
                                                ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                                composer3.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                                CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(fillMaxSize$default);
                                                if (!(composer3.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer3.startReusableNode();
                                                if (composer3.getInserting()) {
                                                    composer3.createNode(constructor3);
                                                } else {
                                                    composer3.useNode();
                                                }
                                                Composer m3593constructorimpl3 = Updater.m3593constructorimpl(composer3);
                                                Updater.m3600setimpl(m3593constructorimpl3, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3600setimpl(m3593constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if (m3593constructorimpl3.getInserting() || !Intrinsics.areEqual(m3593constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                                    m3593constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                                    m3593constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                                }
                                                modifierMaterializerOf3.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                                composer3.startReplaceableGroup(2058660585);
                                                ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                                function33.invoke(ColumnScopeInstance.INSTANCE, composer3, 6);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                composer3.endReplaceableGroup();
                                                composer3.endNode();
                                                composer3.endReplaceableGroup();
                                                composer3.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }), composer2, 1572864, 16);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        composer2.endReplaceableGroup();
                                        composer2.endNode();
                                        composer2.endReplaceableGroup();
                                        composer2.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            }), startRestartGroup, 3072, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = companion;
                            drawerState5 = drawerState4;
                            z4 = z3;
                            j10 = j9;
                            shape4 = shape3;
                            j11 = j7;
                            j12 = j8;
                            f4 = f3;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            long j13 = j4;
                            modifier3 = modifier2;
                            f4 = f2;
                            j10 = j13;
                            drawerState5 = drawerState2;
                            z4 = z2;
                            shape4 = shape2;
                            j11 = j;
                            j12 = j2;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i12) {
                                    DrawerKt.m1652ModalDrawerGs3lGvM(function3, modifier3, drawerState5, z4, shape4, f4, j11, j12, j10, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((1533916891 & i6) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if ((i2 & 4) != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i2 & 64) != 0) {
                    }
                    if ((i2 & 128) != 0) {
                    }
                    if ((i2 & 256) != 0) {
                    }
                    drawerState4 = drawerState3;
                    shape3 = cornerBasedShape;
                    f3 = m1649getElevationD9Ej5fM;
                    j7 = j5;
                    j8 = j6;
                    obj = null;
                    j9 = j4;
                    z3 = z2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
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
                    BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(companion, 0.0f, 1, obj), null, false, ComposableLambdaKt.composableLambda(startRestartGroup, 816674999, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, Integer num) {
                            invoke(boxWithConstraintsScope, composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, int i12) {
                            BoxWithConstraintsScope boxWithConstraintsScope2;
                            int i13;
                            float f5;
                            ComposerKt.sourceInformation(composer2, "C525@18955L7,526@18971L285,535@19299L7,536@19338L2681:Drawer.kt#jmzs0o");
                            if ((i12 & 14) == 0) {
                                boxWithConstraintsScope2 = boxWithConstraintsScope;
                                i13 = i12 | (composer2.changed(boxWithConstraintsScope2) ? 4 : 2);
                            } else {
                                boxWithConstraintsScope2 = boxWithConstraintsScope;
                                i13 = i12;
                            }
                            if ((i13 & 91) != 18 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(816674999, i13, -1, "androidx.compose.material.ModalDrawer.<anonymous> (Drawer.kt:517)");
                                }
                                long mo815getConstraintsmsEJaDk = boxWithConstraintsScope2.mo815getConstraintsmsEJaDk();
                                if (!Constraints.m6341getHasBoundedWidthimpl(mo815getConstraintsmsEJaDk)) {
                                    throw new IllegalStateException("Drawer shouldn't have infinite width");
                                }
                                final float f6 = -Constraints.m6345getMaxWidthimpl(mo815getConstraintsmsEJaDk);
                                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume = composer2.consume(localDensity);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                final Density density = (Density) consume;
                                composer2.startReplaceableGroup(463500327);
                                final float f7 = 0.0f;
                                boolean changed = composer2.changed(DrawerState.this) | composer2.changed(density) | composer2.changed(f6) | composer2.changed(0.0f);
                                final DrawerState drawerState6 = DrawerState.this;
                                Object rememberedValue2 = composer2.rememberedValue();
                                if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$1$1
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
                                            DrawerState.this.setDensity$material_release(density);
                                            final float f8 = f6;
                                            final float f9 = f7;
                                            AnchoredDraggableState.updateAnchors$default(DrawerState.this.getAnchoredDraggableState$material_release(), AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<DrawerValue>, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$1$1$anchors$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                                                    invoke2(draggableAnchorsConfig);
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                                                    draggableAnchorsConfig.at(DrawerValue.Closed, f8);
                                                    draggableAnchorsConfig.at(DrawerValue.Open, f9);
                                                }
                                            }), null, 2, null);
                                        }
                                    };
                                    composer2.updateRememberedValue(rememberedValue2);
                                }
                                composer2.endReplaceableGroup();
                                EffectsKt.SideEffect((Function0) rememberedValue2, composer2, 0);
                                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume2 = composer2.consume(localLayoutDirection);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                Modifier anchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(Modifier.INSTANCE, DrawerState.this.getAnchoredDraggableState$material_release(), Orientation.Horizontal, z3, consume2 == LayoutDirection.Rtl, null, false, 48, null);
                                final DrawerState drawerState7 = DrawerState.this;
                                long j132 = j9;
                                Shape shape5 = shape3;
                                long j14 = j7;
                                long j15 = j8;
                                float f8 = f3;
                                Function2<Composer, Integer, Unit> function22 = function2;
                                final boolean z5 = z3;
                                final CoroutineScope coroutineScope22 = coroutineScope2;
                                final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                                composer2.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                                composer2.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(anchoredDraggable$default);
                                if (!(composer2.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer2.startReusableNode();
                                if (composer2.getInserting()) {
                                    composer2.createNode(constructor);
                                } else {
                                    composer2.useNode();
                                }
                                Composer m3593constructorimpl = Updater.m3593constructorimpl(composer2);
                                Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer2, 413829170, "C545@19656L45,548@19714L553,563@20301L33,*565@20401L7,564@20347L1662:Drawer.kt#jmzs0o");
                                composer2.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                                composer2.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion2);
                                if (!(composer2.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer2.startReusableNode();
                                if (composer2.getInserting()) {
                                    composer2.createNode(constructor2);
                                } else {
                                    composer2.useNode();
                                }
                                Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer2);
                                Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                    m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                    m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                }
                                modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer2, 392280937, "C546@19678L9:Drawer.kt#jmzs0o");
                                function22.invoke(composer2, 0);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                boolean isOpen = drawerState7.isOpen();
                                Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$2
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
                                        if (z5 && drawerState7.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(DrawerValue.Closed).booleanValue()) {
                                            BuildersKt__Builders_commonKt.launch$default(coroutineScope22, null, null, new AnonymousClass1(drawerState7, null), 3, null);
                                        }
                                    }

                                    /* compiled from: Drawer.kt */
                                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                    @DebugMetadata(c = "androidx.compose.material.DrawerKt$ModalDrawer$1$2$2$1", f = "Drawer.kt", i = {}, l = {556}, m = "invokeSuspend", n = {}, s = {})
                                    /* renamed from: androidx.compose.material.DrawerKt$ModalDrawer$1$2$2$1, reason: invalid class name */
                                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        final /* synthetic */ DrawerState $drawerState;
                                        int label;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                            super(2, continuation);
                                            this.$drawerState = drawerState;
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            return new AnonymousClass1(this.$drawerState, continuation);
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
                                                if (this.$drawerState.close(this) == coroutine_suspended) {
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
                                };
                                composer2.startReplaceableGroup(463501456);
                                boolean changed2 = composer2.changed(f6) | composer2.changed(0.0f) | composer2.changed(drawerState7);
                                Object rememberedValue3 = composer2.rememberedValue();
                                if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    final float f9 = 0.0f;
                                    rememberedValue3 = (Function0) new Function0<Float>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$3$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Float invoke() {
                                            float calculateFraction;
                                            calculateFraction = DrawerKt.calculateFraction(f6, f9, drawerState7.requireOffset$material_release());
                                            return Float.valueOf(calculateFraction);
                                        }
                                    };
                                    composer2.updateRememberedValue(rememberedValue3);
                                }
                                composer2.endReplaceableGroup();
                                DrawerKt.m1653ScrimBx497Mc(isOpen, function0, (Function0) rememberedValue3, j132, composer2, 0);
                                final String m1780getString4foXLRw = Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1777getNavigationMenuUdPEhr4(), composer2, 6);
                                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume3 = composer2.consume(localDensity2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                Density density2 = (Density) consume3;
                                Modifier m931sizeInqDBjuR0 = SizeKt.m931sizeInqDBjuR0(Modifier.INSTANCE, density2.mo627toDpu2uoSUM(Constraints.m6347getMinWidthimpl(mo815getConstraintsmsEJaDk)), density2.mo627toDpu2uoSUM(Constraints.m6346getMinHeightimpl(mo815getConstraintsmsEJaDk)), density2.mo627toDpu2uoSUM(Constraints.m6345getMaxWidthimpl(mo815getConstraintsmsEJaDk)), density2.mo627toDpu2uoSUM(Constraints.m6344getMaxHeightimpl(mo815getConstraintsmsEJaDk)));
                                composer2.startReplaceableGroup(463502210);
                                boolean changed3 = composer2.changed(drawerState7);
                                Object rememberedValue4 = composer2.rememberedValue();
                                if (changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue4 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$5$1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ IntOffset invoke(Density density3) {
                                            return IntOffset.m6508boximpl(m1659invokeBjo55l4(density3));
                                        }

                                        /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                                        public final long m1659invokeBjo55l4(Density density3) {
                                            return IntOffsetKt.IntOffset(MathKt.roundToInt(DrawerState.this.requireOffset$material_release()), 0);
                                        }
                                    };
                                    composer2.updateRememberedValue(rememberedValue4);
                                }
                                composer2.endReplaceableGroup();
                                Modifier offset = OffsetKt.offset(m931sizeInqDBjuR0, (Function1) rememberedValue4);
                                f5 = DrawerKt.EndDrawerPadding;
                                SurfaceKt.m1782SurfaceFjzlyU(SemanticsModifierKt.semantics$default(PaddingKt.m883paddingqDBjuR0$default(offset, 0.0f, 0.0f, f5, 0.0f, 11, null), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6
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
                                        SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m1780getString4foXLRw);
                                        if (drawerState7.isOpen()) {
                                            final DrawerState drawerState8 = drawerState7;
                                            final CoroutineScope coroutineScope3 = coroutineScope22;
                                            SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Boolean invoke() {
                                                    if (DrawerState.this.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(DrawerValue.Closed).booleanValue()) {
                                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new C00431(DrawerState.this, null), 3, null);
                                                    }
                                                    return true;
                                                }

                                                /* compiled from: Drawer.kt */
                                                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                                @DebugMetadata(c = "androidx.compose.material.DrawerKt$ModalDrawer$1$2$6$1$1", f = "Drawer.kt", i = {}, l = {591}, m = "invokeSuspend", n = {}, s = {})
                                                /* renamed from: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6$1$1, reason: invalid class name and collision with other inner class name */
                                                static final class C00431 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                    final /* synthetic */ DrawerState $drawerState;
                                                    int label;

                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    C00431(DrawerState drawerState, Continuation<? super C00431> continuation) {
                                                        super(2, continuation);
                                                        this.$drawerState = drawerState;
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                        return new C00431(this.$drawerState, continuation);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                        return ((C00431) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    public final Object invokeSuspend(Object obj) {
                                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                        int i = this.label;
                                                        if (i == 0) {
                                                            ResultKt.throwOnFailure(obj);
                                                            this.label = 1;
                                                            if (this.$drawerState.close(this) == coroutine_suspended) {
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
                                }, 1, null), shape5, j14, j15, null, f8, ComposableLambdaKt.composableLambda(composer2, -1941234439, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$7
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
                                        ComposerKt.sourceInformation(composer3, "C600@21940L55:Drawer.kt#jmzs0o");
                                        if ((i14 & 11) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1941234439, i14, -1, "androidx.compose.material.ModalDrawer.<anonymous>.<anonymous>.<anonymous> (Drawer.kt:600)");
                                        }
                                        Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                        Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                                        composer3.startReplaceableGroup(-483455358);
                                        ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                        composer3.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                        CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(fillMaxSize$default);
                                        if (!(composer3.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer3.startReusableNode();
                                        if (composer3.getInserting()) {
                                            composer3.createNode(constructor3);
                                        } else {
                                            composer3.useNode();
                                        }
                                        Composer m3593constructorimpl3 = Updater.m3593constructorimpl(composer3);
                                        Updater.m3600setimpl(m3593constructorimpl3, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3600setimpl(m3593constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (m3593constructorimpl3.getInserting() || !Intrinsics.areEqual(m3593constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                            m3593constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                            m3593constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                        }
                                        modifierMaterializerOf3.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                        composer3.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                        function33.invoke(ColumnScopeInstance.INSTANCE, composer3, 6);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        composer3.endReplaceableGroup();
                                        composer3.endNode();
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), composer2, 1572864, 16);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), startRestartGroup, 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = companion;
                    drawerState5 = drawerState4;
                    z4 = z3;
                    j10 = j9;
                    shape4 = shape3;
                    j11 = j7;
                    j12 = j8;
                    f4 = f3;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                f2 = f;
                if ((3670016 & i) != 0) {
                }
                if ((i & 29360128) == 0) {
                }
                if ((234881024 & i) != 0) {
                }
                if ((i2 & 512) == 0) {
                }
                if ((1533916891 & i6) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i11 != 0) {
                }
                if ((i2 & 4) != 0) {
                }
                if (i4 != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if (i5 != 0) {
                }
                if ((i2 & 64) != 0) {
                }
                if ((i2 & 128) != 0) {
                }
                if ((i2 & 256) != 0) {
                }
                drawerState4 = drawerState3;
                shape3 = cornerBasedShape;
                f3 = m1649getElevationD9Ej5fM;
                j7 = j5;
                j8 = j6;
                obj = null;
                j9 = j4;
                z3 = z2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
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
                BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(companion, 0.0f, 1, obj), null, false, ComposableLambdaKt.composableLambda(startRestartGroup, 816674999, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, Integer num) {
                        invoke(boxWithConstraintsScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, int i12) {
                        BoxWithConstraintsScope boxWithConstraintsScope2;
                        int i13;
                        float f5;
                        ComposerKt.sourceInformation(composer2, "C525@18955L7,526@18971L285,535@19299L7,536@19338L2681:Drawer.kt#jmzs0o");
                        if ((i12 & 14) == 0) {
                            boxWithConstraintsScope2 = boxWithConstraintsScope;
                            i13 = i12 | (composer2.changed(boxWithConstraintsScope2) ? 4 : 2);
                        } else {
                            boxWithConstraintsScope2 = boxWithConstraintsScope;
                            i13 = i12;
                        }
                        if ((i13 & 91) != 18 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(816674999, i13, -1, "androidx.compose.material.ModalDrawer.<anonymous> (Drawer.kt:517)");
                            }
                            long mo815getConstraintsmsEJaDk = boxWithConstraintsScope2.mo815getConstraintsmsEJaDk();
                            if (!Constraints.m6341getHasBoundedWidthimpl(mo815getConstraintsmsEJaDk)) {
                                throw new IllegalStateException("Drawer shouldn't have infinite width");
                            }
                            final float f6 = -Constraints.m6345getMaxWidthimpl(mo815getConstraintsmsEJaDk);
                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume = composer2.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            final Density density = (Density) consume;
                            composer2.startReplaceableGroup(463500327);
                            final float f7 = 0.0f;
                            boolean changed = composer2.changed(DrawerState.this) | composer2.changed(density) | composer2.changed(f6) | composer2.changed(0.0f);
                            final DrawerState drawerState6 = DrawerState.this;
                            Object rememberedValue2 = composer2.rememberedValue();
                            if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$1$1
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
                                        DrawerState.this.setDensity$material_release(density);
                                        final float f8 = f6;
                                        final float f9 = f7;
                                        AnchoredDraggableState.updateAnchors$default(DrawerState.this.getAnchoredDraggableState$material_release(), AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<DrawerValue>, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$1$1$anchors$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                                                invoke2(draggableAnchorsConfig);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                                                draggableAnchorsConfig.at(DrawerValue.Closed, f8);
                                                draggableAnchorsConfig.at(DrawerValue.Open, f9);
                                            }
                                        }), null, 2, null);
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue2);
                            }
                            composer2.endReplaceableGroup();
                            EffectsKt.SideEffect((Function0) rememberedValue2, composer2, 0);
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume2 = composer2.consume(localLayoutDirection);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            Modifier anchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(Modifier.INSTANCE, DrawerState.this.getAnchoredDraggableState$material_release(), Orientation.Horizontal, z3, consume2 == LayoutDirection.Rtl, null, false, 48, null);
                            final DrawerState drawerState7 = DrawerState.this;
                            long j132 = j9;
                            Shape shape5 = shape3;
                            long j14 = j7;
                            long j15 = j8;
                            float f8 = f3;
                            Function2<Composer, Integer, Unit> function22 = function2;
                            final boolean z5 = z3;
                            final CoroutineScope coroutineScope222 = coroutineScope22;
                            final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                            composer2.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(anchoredDraggable$default);
                            if (!(composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor);
                            } else {
                                composer2.useNode();
                            }
                            Composer m3593constructorimpl = Updater.m3593constructorimpl(composer2);
                            Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer2, 413829170, "C545@19656L45,548@19714L553,563@20301L33,*565@20401L7,564@20347L1662:Drawer.kt#jmzs0o");
                            composer2.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            Modifier.Companion companion2 = Modifier.INSTANCE;
                            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion2);
                            if (!(composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor2);
                            } else {
                                composer2.useNode();
                            }
                            Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer2);
                            Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                            }
                            modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer2, 392280937, "C546@19678L9:Drawer.kt#jmzs0o");
                            function22.invoke(composer2, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            boolean isOpen = drawerState7.isOpen();
                            Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$2
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
                                    if (z5 && drawerState7.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(DrawerValue.Closed).booleanValue()) {
                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope222, null, null, new AnonymousClass1(drawerState7, null), 3, null);
                                    }
                                }

                                /* compiled from: Drawer.kt */
                                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                @DebugMetadata(c = "androidx.compose.material.DrawerKt$ModalDrawer$1$2$2$1", f = "Drawer.kt", i = {}, l = {556}, m = "invokeSuspend", n = {}, s = {})
                                /* renamed from: androidx.compose.material.DrawerKt$ModalDrawer$1$2$2$1, reason: invalid class name */
                                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ DrawerState $drawerState;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                        super(2, continuation);
                                        this.$drawerState = drawerState;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new AnonymousClass1(this.$drawerState, continuation);
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
                                            if (this.$drawerState.close(this) == coroutine_suspended) {
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
                            };
                            composer2.startReplaceableGroup(463501456);
                            boolean changed2 = composer2.changed(f6) | composer2.changed(0.0f) | composer2.changed(drawerState7);
                            Object rememberedValue3 = composer2.rememberedValue();
                            if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                final float f9 = 0.0f;
                                rememberedValue3 = (Function0) new Function0<Float>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$3$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Float invoke() {
                                        float calculateFraction;
                                        calculateFraction = DrawerKt.calculateFraction(f6, f9, drawerState7.requireOffset$material_release());
                                        return Float.valueOf(calculateFraction);
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue3);
                            }
                            composer2.endReplaceableGroup();
                            DrawerKt.m1653ScrimBx497Mc(isOpen, function0, (Function0) rememberedValue3, j132, composer2, 0);
                            final String m1780getString4foXLRw = Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1777getNavigationMenuUdPEhr4(), composer2, 6);
                            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume3 = composer2.consume(localDensity2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            Density density2 = (Density) consume3;
                            Modifier m931sizeInqDBjuR0 = SizeKt.m931sizeInqDBjuR0(Modifier.INSTANCE, density2.mo627toDpu2uoSUM(Constraints.m6347getMinWidthimpl(mo815getConstraintsmsEJaDk)), density2.mo627toDpu2uoSUM(Constraints.m6346getMinHeightimpl(mo815getConstraintsmsEJaDk)), density2.mo627toDpu2uoSUM(Constraints.m6345getMaxWidthimpl(mo815getConstraintsmsEJaDk)), density2.mo627toDpu2uoSUM(Constraints.m6344getMaxHeightimpl(mo815getConstraintsmsEJaDk)));
                            composer2.startReplaceableGroup(463502210);
                            boolean changed3 = composer2.changed(drawerState7);
                            Object rememberedValue4 = composer2.rememberedValue();
                            if (changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue4 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$5$1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ IntOffset invoke(Density density3) {
                                        return IntOffset.m6508boximpl(m1659invokeBjo55l4(density3));
                                    }

                                    /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                                    public final long m1659invokeBjo55l4(Density density3) {
                                        return IntOffsetKt.IntOffset(MathKt.roundToInt(DrawerState.this.requireOffset$material_release()), 0);
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue4);
                            }
                            composer2.endReplaceableGroup();
                            Modifier offset = OffsetKt.offset(m931sizeInqDBjuR0, (Function1) rememberedValue4);
                            f5 = DrawerKt.EndDrawerPadding;
                            SurfaceKt.m1782SurfaceFjzlyU(SemanticsModifierKt.semantics$default(PaddingKt.m883paddingqDBjuR0$default(offset, 0.0f, 0.0f, f5, 0.0f, 11, null), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6
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
                                    SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m1780getString4foXLRw);
                                    if (drawerState7.isOpen()) {
                                        final DrawerState drawerState8 = drawerState7;
                                        final CoroutineScope coroutineScope3 = coroutineScope222;
                                        SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Boolean invoke() {
                                                if (DrawerState.this.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(DrawerValue.Closed).booleanValue()) {
                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new C00431(DrawerState.this, null), 3, null);
                                                }
                                                return true;
                                            }

                                            /* compiled from: Drawer.kt */
                                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                            @DebugMetadata(c = "androidx.compose.material.DrawerKt$ModalDrawer$1$2$6$1$1", f = "Drawer.kt", i = {}, l = {591}, m = "invokeSuspend", n = {}, s = {})
                                            /* renamed from: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6$1$1, reason: invalid class name and collision with other inner class name */
                                            static final class C00431 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                final /* synthetic */ DrawerState $drawerState;
                                                int label;

                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                C00431(DrawerState drawerState, Continuation<? super C00431> continuation) {
                                                    super(2, continuation);
                                                    this.$drawerState = drawerState;
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                    return new C00431(this.$drawerState, continuation);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                    return ((C00431) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Object invokeSuspend(Object obj) {
                                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                    int i = this.label;
                                                    if (i == 0) {
                                                        ResultKt.throwOnFailure(obj);
                                                        this.label = 1;
                                                        if (this.$drawerState.close(this) == coroutine_suspended) {
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
                            }, 1, null), shape5, j14, j15, null, f8, ComposableLambdaKt.composableLambda(composer2, -1941234439, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$7
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
                                    ComposerKt.sourceInformation(composer3, "C600@21940L55:Drawer.kt#jmzs0o");
                                    if ((i14 & 11) == 2 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1941234439, i14, -1, "androidx.compose.material.ModalDrawer.<anonymous>.<anonymous>.<anonymous> (Drawer.kt:600)");
                                    }
                                    Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                    Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                                    composer3.startReplaceableGroup(-483455358);
                                    ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                    composer3.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(fillMaxSize$default);
                                    if (!(composer3.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer3.startReusableNode();
                                    if (composer3.getInserting()) {
                                        composer3.createNode(constructor3);
                                    } else {
                                        composer3.useNode();
                                    }
                                    Composer m3593constructorimpl3 = Updater.m3593constructorimpl(composer3);
                                    Updater.m3600setimpl(m3593constructorimpl3, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3600setimpl(m3593constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m3593constructorimpl3.getInserting() || !Intrinsics.areEqual(m3593constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                        m3593constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                        m3593constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                    }
                                    modifierMaterializerOf3.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                    composer3.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                    function33.invoke(ColumnScopeInstance.INSTANCE, composer3, 6);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    composer3.endReplaceableGroup();
                                    composer3.endNode();
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer2, 1572864, 16);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), startRestartGroup, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = companion;
                drawerState5 = drawerState4;
                z4 = z3;
                j10 = j9;
                shape4 = shape3;
                j11 = j7;
                j12 = j8;
                f4 = f3;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z2 = z;
            if ((57344 & i) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            f2 = f;
            if ((3670016 & i) != 0) {
            }
            if ((i & 29360128) == 0) {
            }
            if ((234881024 & i) != 0) {
            }
            if ((i2 & 512) == 0) {
            }
            if ((1533916891 & i6) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i11 != 0) {
            }
            if ((i2 & 4) != 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 64) != 0) {
            }
            if ((i2 & 128) != 0) {
            }
            if ((i2 & 256) != 0) {
            }
            drawerState4 = drawerState3;
            shape3 = cornerBasedShape;
            f3 = m1649getElevationD9Ej5fM;
            j7 = j5;
            j8 = j6;
            obj = null;
            j9 = j4;
            z3 = z2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            final CoroutineScope coroutineScope222 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
            startRestartGroup.endReplaceableGroup();
            BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(companion, 0.0f, 1, obj), null, false, ComposableLambdaKt.composableLambda(startRestartGroup, 816674999, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, Integer num) {
                    invoke(boxWithConstraintsScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, int i12) {
                    BoxWithConstraintsScope boxWithConstraintsScope2;
                    int i13;
                    float f5;
                    ComposerKt.sourceInformation(composer2, "C525@18955L7,526@18971L285,535@19299L7,536@19338L2681:Drawer.kt#jmzs0o");
                    if ((i12 & 14) == 0) {
                        boxWithConstraintsScope2 = boxWithConstraintsScope;
                        i13 = i12 | (composer2.changed(boxWithConstraintsScope2) ? 4 : 2);
                    } else {
                        boxWithConstraintsScope2 = boxWithConstraintsScope;
                        i13 = i12;
                    }
                    if ((i13 & 91) != 18 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(816674999, i13, -1, "androidx.compose.material.ModalDrawer.<anonymous> (Drawer.kt:517)");
                        }
                        long mo815getConstraintsmsEJaDk = boxWithConstraintsScope2.mo815getConstraintsmsEJaDk();
                        if (!Constraints.m6341getHasBoundedWidthimpl(mo815getConstraintsmsEJaDk)) {
                            throw new IllegalStateException("Drawer shouldn't have infinite width");
                        }
                        final float f6 = -Constraints.m6345getMaxWidthimpl(mo815getConstraintsmsEJaDk);
                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume = composer2.consume(localDensity);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        final Density density = (Density) consume;
                        composer2.startReplaceableGroup(463500327);
                        final float f7 = 0.0f;
                        boolean changed = composer2.changed(DrawerState.this) | composer2.changed(density) | composer2.changed(f6) | composer2.changed(0.0f);
                        final DrawerState drawerState6 = DrawerState.this;
                        Object rememberedValue2 = composer2.rememberedValue();
                        if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$1$1
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
                                    DrawerState.this.setDensity$material_release(density);
                                    final float f8 = f6;
                                    final float f9 = f7;
                                    AnchoredDraggableState.updateAnchors$default(DrawerState.this.getAnchoredDraggableState$material_release(), AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<DrawerValue>, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$1$1$anchors$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                                            invoke2(draggableAnchorsConfig);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                                            draggableAnchorsConfig.at(DrawerValue.Closed, f8);
                                            draggableAnchorsConfig.at(DrawerValue.Open, f9);
                                        }
                                    }), null, 2, null);
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue2);
                        }
                        composer2.endReplaceableGroup();
                        EffectsKt.SideEffect((Function0) rememberedValue2, composer2, 0);
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume2 = composer2.consume(localLayoutDirection);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        Modifier anchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(Modifier.INSTANCE, DrawerState.this.getAnchoredDraggableState$material_release(), Orientation.Horizontal, z3, consume2 == LayoutDirection.Rtl, null, false, 48, null);
                        final DrawerState drawerState7 = DrawerState.this;
                        long j132 = j9;
                        Shape shape5 = shape3;
                        long j14 = j7;
                        long j15 = j8;
                        float f8 = f3;
                        Function2<Composer, Integer, Unit> function22 = function2;
                        final boolean z5 = z3;
                        final CoroutineScope coroutineScope2222 = coroutineScope222;
                        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                        composer2.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(anchoredDraggable$default);
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer2.useNode();
                        }
                        Composer m3593constructorimpl = Updater.m3593constructorimpl(composer2);
                        Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, 413829170, "C545@19656L45,548@19714L553,563@20301L33,*565@20401L7,564@20347L1662:Drawer.kt#jmzs0o");
                        composer2.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        Modifier.Companion companion2 = Modifier.INSTANCE;
                        MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion2);
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor2);
                        } else {
                            composer2.useNode();
                        }
                        Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer2);
                        Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, 392280937, "C546@19678L9:Drawer.kt#jmzs0o");
                        function22.invoke(composer2, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        boolean isOpen = drawerState7.isOpen();
                        Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$2
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
                                if (z5 && drawerState7.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(DrawerValue.Closed).booleanValue()) {
                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope2222, null, null, new AnonymousClass1(drawerState7, null), 3, null);
                                }
                            }

                            /* compiled from: Drawer.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                            @DebugMetadata(c = "androidx.compose.material.DrawerKt$ModalDrawer$1$2$2$1", f = "Drawer.kt", i = {}, l = {556}, m = "invokeSuspend", n = {}, s = {})
                            /* renamed from: androidx.compose.material.DrawerKt$ModalDrawer$1$2$2$1, reason: invalid class name */
                            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ DrawerState $drawerState;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                    super(2, continuation);
                                    this.$drawerState = drawerState;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new AnonymousClass1(this.$drawerState, continuation);
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
                                        if (this.$drawerState.close(this) == coroutine_suspended) {
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
                        };
                        composer2.startReplaceableGroup(463501456);
                        boolean changed2 = composer2.changed(f6) | composer2.changed(0.0f) | composer2.changed(drawerState7);
                        Object rememberedValue3 = composer2.rememberedValue();
                        if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            final float f9 = 0.0f;
                            rememberedValue3 = (Function0) new Function0<Float>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$3$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Float invoke() {
                                    float calculateFraction;
                                    calculateFraction = DrawerKt.calculateFraction(f6, f9, drawerState7.requireOffset$material_release());
                                    return Float.valueOf(calculateFraction);
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue3);
                        }
                        composer2.endReplaceableGroup();
                        DrawerKt.m1653ScrimBx497Mc(isOpen, function0, (Function0) rememberedValue3, j132, composer2, 0);
                        final String m1780getString4foXLRw = Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1777getNavigationMenuUdPEhr4(), composer2, 6);
                        ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume3 = composer2.consume(localDensity2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        Density density2 = (Density) consume3;
                        Modifier m931sizeInqDBjuR0 = SizeKt.m931sizeInqDBjuR0(Modifier.INSTANCE, density2.mo627toDpu2uoSUM(Constraints.m6347getMinWidthimpl(mo815getConstraintsmsEJaDk)), density2.mo627toDpu2uoSUM(Constraints.m6346getMinHeightimpl(mo815getConstraintsmsEJaDk)), density2.mo627toDpu2uoSUM(Constraints.m6345getMaxWidthimpl(mo815getConstraintsmsEJaDk)), density2.mo627toDpu2uoSUM(Constraints.m6344getMaxHeightimpl(mo815getConstraintsmsEJaDk)));
                        composer2.startReplaceableGroup(463502210);
                        boolean changed3 = composer2.changed(drawerState7);
                        Object rememberedValue4 = composer2.rememberedValue();
                        if (changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue4 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$5$1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ IntOffset invoke(Density density3) {
                                    return IntOffset.m6508boximpl(m1659invokeBjo55l4(density3));
                                }

                                /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                                public final long m1659invokeBjo55l4(Density density3) {
                                    return IntOffsetKt.IntOffset(MathKt.roundToInt(DrawerState.this.requireOffset$material_release()), 0);
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue4);
                        }
                        composer2.endReplaceableGroup();
                        Modifier offset = OffsetKt.offset(m931sizeInqDBjuR0, (Function1) rememberedValue4);
                        f5 = DrawerKt.EndDrawerPadding;
                        SurfaceKt.m1782SurfaceFjzlyU(SemanticsModifierKt.semantics$default(PaddingKt.m883paddingqDBjuR0$default(offset, 0.0f, 0.0f, f5, 0.0f, 11, null), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6
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
                                SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m1780getString4foXLRw);
                                if (drawerState7.isOpen()) {
                                    final DrawerState drawerState8 = drawerState7;
                                    final CoroutineScope coroutineScope3 = coroutineScope2222;
                                    SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Boolean invoke() {
                                            if (DrawerState.this.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(DrawerValue.Closed).booleanValue()) {
                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new C00431(DrawerState.this, null), 3, null);
                                            }
                                            return true;
                                        }

                                        /* compiled from: Drawer.kt */
                                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                        @DebugMetadata(c = "androidx.compose.material.DrawerKt$ModalDrawer$1$2$6$1$1", f = "Drawer.kt", i = {}, l = {591}, m = "invokeSuspend", n = {}, s = {})
                                        /* renamed from: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6$1$1, reason: invalid class name and collision with other inner class name */
                                        static final class C00431 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                            final /* synthetic */ DrawerState $drawerState;
                                            int label;

                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            C00431(DrawerState drawerState, Continuation<? super C00431> continuation) {
                                                super(2, continuation);
                                                this.$drawerState = drawerState;
                                            }

                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                return new C00431(this.$drawerState, continuation);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                return ((C00431) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                            }

                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                            public final Object invokeSuspend(Object obj) {
                                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                int i = this.label;
                                                if (i == 0) {
                                                    ResultKt.throwOnFailure(obj);
                                                    this.label = 1;
                                                    if (this.$drawerState.close(this) == coroutine_suspended) {
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
                        }, 1, null), shape5, j14, j15, null, f8, ComposableLambdaKt.composableLambda(composer2, -1941234439, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$7
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
                                ComposerKt.sourceInformation(composer3, "C600@21940L55:Drawer.kt#jmzs0o");
                                if ((i14 & 11) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1941234439, i14, -1, "androidx.compose.material.ModalDrawer.<anonymous>.<anonymous>.<anonymous> (Drawer.kt:600)");
                                }
                                Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                                composer3.startReplaceableGroup(-483455358);
                                ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                composer3.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(fillMaxSize$default);
                                if (!(composer3.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor3);
                                } else {
                                    composer3.useNode();
                                }
                                Composer m3593constructorimpl3 = Updater.m3593constructorimpl(composer3);
                                Updater.m3600setimpl(m3593constructorimpl3, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3600setimpl(m3593constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m3593constructorimpl3.getInserting() || !Intrinsics.areEqual(m3593constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                    m3593constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                    m3593constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                }
                                modifierMaterializerOf3.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                composer3.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                function33.invoke(ColumnScopeInstance.INSTANCE, composer3, 6);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endReplaceableGroup();
                                composer3.endNode();
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer2, 1572864, 16);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), startRestartGroup, 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = companion;
            drawerState5 = drawerState4;
            z4 = z3;
            j10 = j9;
            shape4 = shape3;
            j11 = j7;
            j12 = j8;
            f4 = f3;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i & 896) != 0) {
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z2 = z;
        if ((57344 & i) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        f2 = f;
        if ((3670016 & i) != 0) {
        }
        if ((i & 29360128) == 0) {
        }
        if ((234881024 & i) != 0) {
        }
        if ((i2 & 512) == 0) {
        }
        if ((1533916891 & i6) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i11 != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if ((i2 & 128) != 0) {
        }
        if ((i2 & 256) != 0) {
        }
        drawerState4 = drawerState3;
        shape3 = cornerBasedShape;
        f3 = m1649getElevationD9Ej5fM;
        j7 = j5;
        j8 = j6;
        obj = null;
        j9 = j4;
        z3 = z2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final CoroutineScope coroutineScope2222 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
        startRestartGroup.endReplaceableGroup();
        BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(companion, 0.0f, 1, obj), null, false, ComposableLambdaKt.composableLambda(startRestartGroup, 816674999, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, Integer num) {
                invoke(boxWithConstraintsScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, int i12) {
                BoxWithConstraintsScope boxWithConstraintsScope2;
                int i13;
                float f5;
                ComposerKt.sourceInformation(composer2, "C525@18955L7,526@18971L285,535@19299L7,536@19338L2681:Drawer.kt#jmzs0o");
                if ((i12 & 14) == 0) {
                    boxWithConstraintsScope2 = boxWithConstraintsScope;
                    i13 = i12 | (composer2.changed(boxWithConstraintsScope2) ? 4 : 2);
                } else {
                    boxWithConstraintsScope2 = boxWithConstraintsScope;
                    i13 = i12;
                }
                if ((i13 & 91) != 18 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(816674999, i13, -1, "androidx.compose.material.ModalDrawer.<anonymous> (Drawer.kt:517)");
                    }
                    long mo815getConstraintsmsEJaDk = boxWithConstraintsScope2.mo815getConstraintsmsEJaDk();
                    if (!Constraints.m6341getHasBoundedWidthimpl(mo815getConstraintsmsEJaDk)) {
                        throw new IllegalStateException("Drawer shouldn't have infinite width");
                    }
                    final float f6 = -Constraints.m6345getMaxWidthimpl(mo815getConstraintsmsEJaDk);
                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = composer2.consume(localDensity);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    final Density density = (Density) consume;
                    composer2.startReplaceableGroup(463500327);
                    final float f7 = 0.0f;
                    boolean changed = composer2.changed(DrawerState.this) | composer2.changed(density) | composer2.changed(f6) | composer2.changed(0.0f);
                    final DrawerState drawerState6 = DrawerState.this;
                    Object rememberedValue2 = composer2.rememberedValue();
                    if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$1$1
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
                                DrawerState.this.setDensity$material_release(density);
                                final float f8 = f6;
                                final float f9 = f7;
                                AnchoredDraggableState.updateAnchors$default(DrawerState.this.getAnchoredDraggableState$material_release(), AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<DrawerValue>, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$1$1$anchors$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                                        invoke2(draggableAnchorsConfig);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                                        draggableAnchorsConfig.at(DrawerValue.Closed, f8);
                                        draggableAnchorsConfig.at(DrawerValue.Open, f9);
                                    }
                                }), null, 2, null);
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue2);
                    }
                    composer2.endReplaceableGroup();
                    EffectsKt.SideEffect((Function0) rememberedValue2, composer2, 0);
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume2 = composer2.consume(localLayoutDirection);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Modifier anchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(Modifier.INSTANCE, DrawerState.this.getAnchoredDraggableState$material_release(), Orientation.Horizontal, z3, consume2 == LayoutDirection.Rtl, null, false, 48, null);
                    final DrawerState drawerState7 = DrawerState.this;
                    long j132 = j9;
                    Shape shape5 = shape3;
                    long j14 = j7;
                    long j15 = j8;
                    float f8 = f3;
                    Function2<Composer, Integer, Unit> function22 = function2;
                    final boolean z5 = z3;
                    final CoroutineScope coroutineScope22222 = coroutineScope2222;
                    final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                    composer2.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(anchoredDraggable$default);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer m3593constructorimpl = Updater.m3593constructorimpl(composer2);
                    Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 413829170, "C545@19656L45,548@19714L553,563@20301L33,*565@20401L7,564@20347L1662:Drawer.kt#jmzs0o");
                    composer2.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion2);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor2);
                    } else {
                        composer2.useNode();
                    }
                    Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer2);
                    Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 392280937, "C546@19678L9:Drawer.kt#jmzs0o");
                    function22.invoke(composer2, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    boolean isOpen = drawerState7.isOpen();
                    Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$2
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
                            if (z5 && drawerState7.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(DrawerValue.Closed).booleanValue()) {
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope22222, null, null, new AnonymousClass1(drawerState7, null), 3, null);
                            }
                        }

                        /* compiled from: Drawer.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                        @DebugMetadata(c = "androidx.compose.material.DrawerKt$ModalDrawer$1$2$2$1", f = "Drawer.kt", i = {}, l = {556}, m = "invokeSuspend", n = {}, s = {})
                        /* renamed from: androidx.compose.material.DrawerKt$ModalDrawer$1$2$2$1, reason: invalid class name */
                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ DrawerState $drawerState;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$drawerState = drawerState;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass1(this.$drawerState, continuation);
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
                                    if (this.$drawerState.close(this) == coroutine_suspended) {
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
                    };
                    composer2.startReplaceableGroup(463501456);
                    boolean changed2 = composer2.changed(f6) | composer2.changed(0.0f) | composer2.changed(drawerState7);
                    Object rememberedValue3 = composer2.rememberedValue();
                    if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        final float f9 = 0.0f;
                        rememberedValue3 = (Function0) new Function0<Float>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Float invoke() {
                                float calculateFraction;
                                calculateFraction = DrawerKt.calculateFraction(f6, f9, drawerState7.requireOffset$material_release());
                                return Float.valueOf(calculateFraction);
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue3);
                    }
                    composer2.endReplaceableGroup();
                    DrawerKt.m1653ScrimBx497Mc(isOpen, function0, (Function0) rememberedValue3, j132, composer2, 0);
                    final String m1780getString4foXLRw = Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1777getNavigationMenuUdPEhr4(), composer2, 6);
                    ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume3 = composer2.consume(localDensity2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Density density2 = (Density) consume3;
                    Modifier m931sizeInqDBjuR0 = SizeKt.m931sizeInqDBjuR0(Modifier.INSTANCE, density2.mo627toDpu2uoSUM(Constraints.m6347getMinWidthimpl(mo815getConstraintsmsEJaDk)), density2.mo627toDpu2uoSUM(Constraints.m6346getMinHeightimpl(mo815getConstraintsmsEJaDk)), density2.mo627toDpu2uoSUM(Constraints.m6345getMaxWidthimpl(mo815getConstraintsmsEJaDk)), density2.mo627toDpu2uoSUM(Constraints.m6344getMaxHeightimpl(mo815getConstraintsmsEJaDk)));
                    composer2.startReplaceableGroup(463502210);
                    boolean changed3 = composer2.changed(drawerState7);
                    Object rememberedValue4 = composer2.rememberedValue();
                    if (changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue4 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$5$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ IntOffset invoke(Density density3) {
                                return IntOffset.m6508boximpl(m1659invokeBjo55l4(density3));
                            }

                            /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                            public final long m1659invokeBjo55l4(Density density3) {
                                return IntOffsetKt.IntOffset(MathKt.roundToInt(DrawerState.this.requireOffset$material_release()), 0);
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue4);
                    }
                    composer2.endReplaceableGroup();
                    Modifier offset = OffsetKt.offset(m931sizeInqDBjuR0, (Function1) rememberedValue4);
                    f5 = DrawerKt.EndDrawerPadding;
                    SurfaceKt.m1782SurfaceFjzlyU(SemanticsModifierKt.semantics$default(PaddingKt.m883paddingqDBjuR0$default(offset, 0.0f, 0.0f, f5, 0.0f, 11, null), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6
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
                            SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m1780getString4foXLRw);
                            if (drawerState7.isOpen()) {
                                final DrawerState drawerState8 = drawerState7;
                                final CoroutineScope coroutineScope3 = coroutineScope22222;
                                SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        if (DrawerState.this.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(DrawerValue.Closed).booleanValue()) {
                                            BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new C00431(DrawerState.this, null), 3, null);
                                        }
                                        return true;
                                    }

                                    /* compiled from: Drawer.kt */
                                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                    @DebugMetadata(c = "androidx.compose.material.DrawerKt$ModalDrawer$1$2$6$1$1", f = "Drawer.kt", i = {}, l = {591}, m = "invokeSuspend", n = {}, s = {})
                                    /* renamed from: androidx.compose.material.DrawerKt$ModalDrawer$1$2$6$1$1, reason: invalid class name and collision with other inner class name */
                                    static final class C00431 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        final /* synthetic */ DrawerState $drawerState;
                                        int label;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        C00431(DrawerState drawerState, Continuation<? super C00431> continuation) {
                                            super(2, continuation);
                                            this.$drawerState = drawerState;
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            return new C00431(this.$drawerState, continuation);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                            return ((C00431) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Object invokeSuspend(Object obj) {
                                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            int i = this.label;
                                            if (i == 0) {
                                                ResultKt.throwOnFailure(obj);
                                                this.label = 1;
                                                if (this.$drawerState.close(this) == coroutine_suspended) {
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
                    }, 1, null), shape5, j14, j15, null, f8, ComposableLambdaKt.composableLambda(composer2, -1941234439, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$ModalDrawer$1$2$7
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
                            ComposerKt.sourceInformation(composer3, "C600@21940L55:Drawer.kt#jmzs0o");
                            if ((i14 & 11) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1941234439, i14, -1, "androidx.compose.material.ModalDrawer.<anonymous>.<anonymous>.<anonymous> (Drawer.kt:600)");
                            }
                            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                            Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                            composer3.startReplaceableGroup(-483455358);
                            ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                            composer3.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(fillMaxSize$default);
                            if (!(composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer3.startReusableNode();
                            if (composer3.getInserting()) {
                                composer3.createNode(constructor3);
                            } else {
                                composer3.useNode();
                            }
                            Composer m3593constructorimpl3 = Updater.m3593constructorimpl(composer3);
                            Updater.m3600setimpl(m3593constructorimpl3, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3600setimpl(m3593constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m3593constructorimpl3.getInserting() || !Intrinsics.areEqual(m3593constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                m3593constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                m3593constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                            }
                            modifierMaterializerOf3.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                            composer3.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                            function33.invoke(ColumnScopeInstance.INSTANCE, composer3, 6);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endReplaceableGroup();
                            composer3.endNode();
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, 1572864, 16);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), startRestartGroup, 3072, 6);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = companion;
        drawerState5 = drawerState4;
        z4 = z3;
        j10 = j9;
        shape4 = shape3;
        j11 = j7;
        j12 = j8;
        f4 = f3;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x019d  */
    /* renamed from: BottomDrawer-Gs3lGvM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1650BottomDrawerGs3lGvM(final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, BottomDrawerState bottomDrawerState, boolean z, Shape shape, float f, long j, long j2, long j3, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        int i5;
        boolean z2;
        Shape shape2;
        int i6;
        float f2;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function22;
        final Modifier.Companion companion;
        final BottomDrawerState bottomDrawerState2;
        CornerBasedShape cornerBasedShape;
        long j4;
        long j5;
        final float f3;
        final boolean z3;
        final long j6;
        final long j7;
        int i8;
        final long j8;
        final Shape shape3;
        Object rememberedValue;
        Composer composer2;
        final boolean z4;
        final BottomDrawerState bottomDrawerState3;
        final long j9;
        final Shape shape4;
        final long j10;
        final long j11;
        final float f4;
        ScopeUpdateScope endRestartGroup;
        int i9;
        int i10;
        int i11;
        Composer startRestartGroup = composer.startRestartGroup(625649286);
        ComposerKt.sourceInformation(startRestartGroup, "C(BottomDrawer)P(2,8,6,7,5,4:c#ui.unit.Dp,1:c#ui.graphics.Color,3:c#ui.graphics.Color,9:c#ui.graphics.Color)640@23904L33,642@24015L6,644@24130L6,645@24178L38,646@24257L10,650@24423L7,651@24435L56,654@24508L24,656@24538L4673:Drawer.kt#jmzs0o");
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
            } else if ((i & 7168) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        shape2 = shape;
                        if (startRestartGroup.changed(shape2)) {
                            i11 = 16384;
                            i3 |= i11;
                        }
                    } else {
                        shape2 = shape;
                    }
                    i11 = 8192;
                    i3 |= i11;
                } else {
                    shape2 = shape;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((458752 & i) == 0) {
                    f2 = f;
                    i3 |= startRestartGroup.changed(f2) ? 131072 : 65536;
                    if ((i & 3670016) != 0) {
                        if ((i2 & 64) == 0) {
                            i9 = i3;
                            if (startRestartGroup.changed(j)) {
                                i10 = 1048576;
                                i7 = i9 | i10;
                            }
                        } else {
                            i9 = i3;
                        }
                        i10 = 524288;
                        i7 = i9 | i10;
                    } else {
                        i7 = i3;
                    }
                    if ((i & 29360128) == 0) {
                        i7 |= ((i2 & 128) == 0 && startRestartGroup.changed(j2)) ? 8388608 : 4194304;
                    }
                    if ((234881024 & i) == 0) {
                        i7 |= ((i2 & 256) == 0 && startRestartGroup.changed(j3)) ? 67108864 : 33554432;
                    }
                    if ((i2 & 512) == 0) {
                        i7 |= C.ENCODING_PCM_32BIT;
                    } else if ((1879048192 & i) == 0) {
                        function22 = function2;
                        i7 |= startRestartGroup.changedInstance(function22) ? 536870912 : 268435456;
                        int i13 = i7;
                        if (i4 == 4 || (1533916891 & i13) != 306783378 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                companion = i12 != 0 ? Modifier.INSTANCE : modifier2;
                                if (i4 != 0) {
                                    bottomDrawerState2 = rememberBottomDrawerState(BottomDrawerValue.Closed, null, startRestartGroup, 6, 2);
                                    i13 &= -897;
                                } else {
                                    bottomDrawerState2 = bottomDrawerState;
                                }
                                if (i5 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 16) != 0) {
                                    cornerBasedShape = MaterialTheme.INSTANCE.getShapes(startRestartGroup, 6).getLarge();
                                    i13 &= -57345;
                                } else {
                                    cornerBasedShape = shape2;
                                }
                                float m1649getElevationD9Ej5fM = i6 != 0 ? DrawerDefaults.INSTANCE.m1649getElevationD9Ej5fM() : f2;
                                if ((i2 & 64) != 0) {
                                    j4 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m1607getSurface0d7_KjU();
                                    i13 &= -3670017;
                                } else {
                                    j4 = j;
                                }
                                if ((i2 & 128) != 0) {
                                    j5 = ColorsKt.m1621contentColorForek8zF_U(j4, startRestartGroup, (i13 >> 18) & 14);
                                    i13 &= -29360129;
                                } else {
                                    j5 = j2;
                                }
                                if ((i2 & 256) != 0) {
                                    i13 &= -234881025;
                                    f3 = m1649getElevationD9Ej5fM;
                                    z3 = z2;
                                    j7 = j5;
                                    j8 = DrawerDefaults.INSTANCE.getScrimColor(startRestartGroup, 6);
                                    i8 = 625649286;
                                    shape3 = cornerBasedShape;
                                    j6 = j4;
                                } else {
                                    f3 = m1649getElevationD9Ej5fM;
                                    z3 = z2;
                                    j6 = j4;
                                    j7 = j5;
                                    i8 = 625649286;
                                    j8 = j3;
                                    shape3 = cornerBasedShape;
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
                                j6 = j;
                                j7 = j2;
                                j8 = j3;
                                companion = modifier2;
                                z3 = z2;
                                shape3 = shape2;
                                f3 = f2;
                                i8 = 625649286;
                                bottomDrawerState2 = bottomDrawerState;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i8, i13, -1, "androidx.compose.material.BottomDrawer (Drawer.kt:648)");
                            }
                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume = startRestartGroup.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            final Density density = (Density) consume;
                            EffectsKt.SideEffect(new Function0<Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1
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
                                    BottomDrawerState.this.setDensity$material_release(density);
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
                            final Function2<? super Composer, ? super Integer, Unit> function23 = function22;
                            final BottomDrawerState bottomDrawerState4 = bottomDrawerState2;
                            BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(startRestartGroup, 1220102512, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$2
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
                                    BoxWithConstraintsScope boxWithConstraintsScope2;
                                    int i15;
                                    Modifier.Companion companion2;
                                    ComposerKt.sourceInformation(composer3, "C*660@24815L7,672@25230L7,683@25578L3627:Drawer.kt#jmzs0o");
                                    if ((i14 & 14) == 0) {
                                        boxWithConstraintsScope2 = boxWithConstraintsScope;
                                        i15 = i14 | (composer3.changed(boxWithConstraintsScope2) ? 4 : 2);
                                    } else {
                                        boxWithConstraintsScope2 = boxWithConstraintsScope;
                                        i15 = i14;
                                    }
                                    if ((i15 & 91) != 18 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1220102512, i15, -1, "androidx.compose.material.BottomDrawer.<anonymous> (Drawer.kt:657)");
                                        }
                                        final float m6344getMaxHeightimpl = Constraints.m6344getMaxHeightimpl(boxWithConstraintsScope2.mo815getConstraintsmsEJaDk());
                                        final boolean z5 = Constraints.m6345getMaxWidthimpl(boxWithConstraintsScope2.mo815getConstraintsmsEJaDk()) > Constraints.m6344getMaxHeightimpl(boxWithConstraintsScope2.mo815getConstraintsmsEJaDk());
                                        ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                        Object consume2 = composer3.consume(localDensity2);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        Density density2 = (Density) consume2;
                                        Modifier m932sizeInqDBjuR0$default = SizeKt.m932sizeInqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, density2.mo627toDpu2uoSUM(Constraints.m6345getMaxWidthimpl(boxWithConstraintsScope2.mo815getConstraintsmsEJaDk())), density2.mo627toDpu2uoSUM(Constraints.m6344getMaxHeightimpl(boxWithConstraintsScope2.mo815getConstraintsmsEJaDk())), 3, null);
                                        if (z3) {
                                            companion2 = NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, bottomDrawerState4.getNestedScrollConnection$material_release(), null, 2, null);
                                        } else {
                                            companion2 = Modifier.INSTANCE;
                                        }
                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                        Object consume3 = composer3.consume(localLayoutDirection);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        Modifier anchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(Modifier.INSTANCE.then(companion2), bottomDrawerState4.getAnchoredDraggableState$material_release(), Orientation.Vertical, z3, consume3 == LayoutDirection.Rtl, null, false, 48, null);
                                        Function2<Composer, Integer, Unit> function24 = function23;
                                        long j12 = j8;
                                        final BottomDrawerState bottomDrawerState5 = bottomDrawerState4;
                                        Shape shape5 = shape3;
                                        long j13 = j6;
                                        long j14 = j7;
                                        float f5 = f3;
                                        final boolean z6 = z3;
                                        final CoroutineScope coroutineScope2 = coroutineScope;
                                        final Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                                        composer3.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                        composer3.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(anchoredDraggable$default);
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
                                        ComposerKt.sourceInformationMarkerStart(composer3, 1720994599, "C684@25607L9,685@25629L391,696@26054L33,697@26100L3095:Drawer.kt#jmzs0o");
                                        function24.invoke(composer3, 0);
                                        DrawerKt.m1651BottomDrawerScrim3JVO9M(j12, new Function0<Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$2$1$1
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
                                                if (z6 && bottomDrawerState5.confirmStateChange$material_release(BottomDrawerValue.Closed)) {
                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new AnonymousClass1(bottomDrawerState5, null), 3, null);
                                                }
                                            }

                                            /* compiled from: Drawer.kt */
                                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                            @DebugMetadata(c = "androidx.compose.material.DrawerKt$BottomDrawer$2$1$1$1", f = "Drawer.kt", i = {}, l = {692}, m = "invokeSuspend", n = {}, s = {})
                                            /* renamed from: androidx.compose.material.DrawerKt$BottomDrawer$2$1$1$1, reason: invalid class name */
                                            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                final /* synthetic */ BottomDrawerState $drawerState;
                                                int label;

                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                AnonymousClass1(BottomDrawerState bottomDrawerState, Continuation<? super AnonymousClass1> continuation) {
                                                    super(2, continuation);
                                                    this.$drawerState = bottomDrawerState;
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                    return new AnonymousClass1(this.$drawerState, continuation);
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
                                                        if (this.$drawerState.close(this) == coroutine_suspended) {
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
                                        }, bottomDrawerState5.getTargetValue() != BottomDrawerValue.Closed, composer3, 0);
                                        final String m1780getString4foXLRw = Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1777getNavigationMenuUdPEhr4(), composer3, 6);
                                        SurfaceKt.m1782SurfaceFjzlyU(SemanticsModifierKt.semantics$default(OffsetKt.offset(OnRemeasuredModifierKt.onSizeChanged(m932sizeInqDBjuR0$default, new Function1<IntSize, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$2$1$2

                                            /* compiled from: Drawer.kt */
                                            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                                            public /* synthetic */ class WhenMappings {
                                                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                                static {
                                                    int[] iArr = new int[BottomDrawerValue.values().length];
                                                    try {
                                                        iArr[BottomDrawerValue.Closed.ordinal()] = 1;
                                                    } catch (NoSuchFieldError unused) {
                                                    }
                                                    try {
                                                        iArr[BottomDrawerValue.Open.ordinal()] = 2;
                                                    } catch (NoSuchFieldError unused2) {
                                                    }
                                                    try {
                                                        iArr[BottomDrawerValue.Expanded.ordinal()] = 3;
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
                                                m1656invokeozmzZPI(intSize.getPackedValue());
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                                            public final void m1656invokeozmzZPI(long j15) {
                                                BottomDrawerValue bottomDrawerValue;
                                                final float m6558getHeightimpl = IntSize.m6558getHeightimpl(j15);
                                                final float f6 = m6344getMaxHeightimpl;
                                                final boolean z7 = z5;
                                                DraggableAnchors<BottomDrawerValue> DraggableAnchors = AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<BottomDrawerValue>, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$2$1$2$newAnchors$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<BottomDrawerValue> draggableAnchorsConfig) {
                                                        invoke2(draggableAnchorsConfig);
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(DraggableAnchorsConfig<BottomDrawerValue> draggableAnchorsConfig) {
                                                        draggableAnchorsConfig.at(BottomDrawerValue.Closed, f6);
                                                        float f7 = f6 * 0.5f;
                                                        if (m6558getHeightimpl > f7 || z7) {
                                                            draggableAnchorsConfig.at(BottomDrawerValue.Open, f7);
                                                        }
                                                        if (m6558getHeightimpl > 0.0f) {
                                                            draggableAnchorsConfig.at(BottomDrawerValue.Expanded, Math.max(0.0f, f6 - m6558getHeightimpl));
                                                        }
                                                    }
                                                });
                                                if (BottomDrawerState.this.getAnchoredDraggableState$material_release().getAnchors().getSize() <= 0 && DraggableAnchors.hasAnchorFor(BottomDrawerState.this.getCurrentValue())) {
                                                    bottomDrawerValue = BottomDrawerState.this.getCurrentValue();
                                                } else {
                                                    int i16 = WhenMappings.$EnumSwitchMapping$0[BottomDrawerState.this.getTargetValue().ordinal()];
                                                    if (i16 == 1) {
                                                        bottomDrawerValue = BottomDrawerValue.Closed;
                                                    } else if (i16 == 2 || i16 == 3) {
                                                        if (DraggableAnchors.hasAnchorFor(BottomDrawerValue.Open)) {
                                                            bottomDrawerValue = BottomDrawerValue.Open;
                                                        } else {
                                                            bottomDrawerValue = DraggableAnchors.hasAnchorFor(BottomDrawerValue.Expanded) ? BottomDrawerValue.Expanded : BottomDrawerValue.Closed;
                                                        }
                                                    } else {
                                                        throw new NoWhenBranchMatchedException();
                                                    }
                                                }
                                                BottomDrawerState.this.getAnchoredDraggableState$material_release().updateAnchors(DraggableAnchors, bottomDrawerValue);
                                            }
                                        }), new Function1<Density, IntOffset>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$2$1$3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ IntOffset invoke(Density density3) {
                                                return IntOffset.m6508boximpl(m1657invokeBjo55l4(density3));
                                            }

                                            /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                                            public final long m1657invokeBjo55l4(Density density3) {
                                                return IntOffsetKt.IntOffset(0, MathKt.roundToInt(BottomDrawerState.this.requireOffset$material_release()));
                                            }
                                        }), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$2$1$4
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
                                                SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m1780getString4foXLRw);
                                                if (bottomDrawerState5.isOpen()) {
                                                    final BottomDrawerState bottomDrawerState6 = bottomDrawerState5;
                                                    final CoroutineScope coroutineScope3 = coroutineScope2;
                                                    SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$2$1$4.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(0);
                                                        }

                                                        /* compiled from: Drawer.kt */
                                                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                                        @DebugMetadata(c = "androidx.compose.material.DrawerKt$BottomDrawer$2$1$4$1$1", f = "Drawer.kt", i = {}, l = {748}, m = "invokeSuspend", n = {}, s = {})
                                                        /* renamed from: androidx.compose.material.DrawerKt$BottomDrawer$2$1$4$1$1, reason: invalid class name and collision with other inner class name */
                                                        static final class C00421 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                            final /* synthetic */ BottomDrawerState $drawerState;
                                                            int label;

                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            C00421(BottomDrawerState bottomDrawerState, Continuation<? super C00421> continuation) {
                                                                super(2, continuation);
                                                                this.$drawerState = bottomDrawerState;
                                                            }

                                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                                return new C00421(this.$drawerState, continuation);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function2
                                                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                                return ((C00421) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                            }

                                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                            public final Object invokeSuspend(Object obj) {
                                                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                                int i = this.label;
                                                                if (i == 0) {
                                                                    ResultKt.throwOnFailure(obj);
                                                                    this.label = 1;
                                                                    if (this.$drawerState.close(this) == coroutine_suspended) {
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

                                                        /* JADX WARN: Can't rename method to resolve collision */
                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Boolean invoke() {
                                                            if (BottomDrawerState.this.confirmStateChange$material_release(BottomDrawerValue.Closed)) {
                                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new C00421(BottomDrawerState.this, null), 3, null);
                                                            }
                                                            return true;
                                                        }
                                                    }, 1, null);
                                                }
                                            }
                                        }, 1, null), shape5, j13, j14, null, f5, ComposableLambdaKt.composableLambda(composer3, 457750254, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$2$1$5
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
                                                ComposerKt.sourceInformation(composer4, "C757@29150L31:Drawer.kt#jmzs0o");
                                                if ((i16 & 11) == 2 && composer4.getSkipping()) {
                                                    composer4.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(457750254, i16, -1, "androidx.compose.material.BottomDrawer.<anonymous>.<anonymous>.<anonymous> (Drawer.kt:757)");
                                                }
                                                Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                                                composer4.startReplaceableGroup(-483455358);
                                                ComposerKt.sourceInformation(composer4, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                                Modifier.Companion companion3 = Modifier.INSTANCE;
                                                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer4, 0);
                                                composer4.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                CompositionLocalMap currentCompositionLocalMap2 = composer4.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion3);
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
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        composer3.endReplaceableGroup();
                                        composer3.endNode();
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), startRestartGroup, 3072, 6);
                            composer2 = startRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z4 = z3;
                            bottomDrawerState3 = bottomDrawerState4;
                            j9 = j8;
                            shape4 = shape3;
                            j10 = j6;
                            j11 = j7;
                            f4 = f3;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            bottomDrawerState3 = bottomDrawerState;
                            composer2 = startRestartGroup;
                            companion = modifier2;
                            z4 = z2;
                            shape4 = shape2;
                            f4 = f2;
                            j10 = j;
                            j11 = j2;
                            j9 = j3;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$3
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
                                    DrawerKt.m1650BottomDrawerGs3lGvM(function3, companion, bottomDrawerState3, z4, shape4, f4, j10, j11, j9, function2, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    function22 = function2;
                    int i132 = i7;
                    if (i4 == 4) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i12 != 0) {
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
                    EffectsKt.SideEffect(new Function0<Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1
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
                            BottomDrawerState.this.setDensity$material_release(density2);
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
                    final Function2<? super Composer, ? super Integer, Unit> function232 = function22;
                    final BottomDrawerState bottomDrawerState42 = bottomDrawerState2;
                    BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(startRestartGroup, 1220102512, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$2
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
                            BoxWithConstraintsScope boxWithConstraintsScope2;
                            int i15;
                            Modifier.Companion companion2;
                            ComposerKt.sourceInformation(composer3, "C*660@24815L7,672@25230L7,683@25578L3627:Drawer.kt#jmzs0o");
                            if ((i14 & 14) == 0) {
                                boxWithConstraintsScope2 = boxWithConstraintsScope;
                                i15 = i14 | (composer3.changed(boxWithConstraintsScope2) ? 4 : 2);
                            } else {
                                boxWithConstraintsScope2 = boxWithConstraintsScope;
                                i15 = i14;
                            }
                            if ((i15 & 91) != 18 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1220102512, i15, -1, "androidx.compose.material.BottomDrawer.<anonymous> (Drawer.kt:657)");
                                }
                                final float m6344getMaxHeightimpl = Constraints.m6344getMaxHeightimpl(boxWithConstraintsScope2.mo815getConstraintsmsEJaDk());
                                final boolean z5 = Constraints.m6345getMaxWidthimpl(boxWithConstraintsScope2.mo815getConstraintsmsEJaDk()) > Constraints.m6344getMaxHeightimpl(boxWithConstraintsScope2.mo815getConstraintsmsEJaDk());
                                ProvidableCompositionLocal<Density> localDensity22 = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume22 = composer3.consume(localDensity22);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                Density density22 = (Density) consume22;
                                Modifier m932sizeInqDBjuR0$default = SizeKt.m932sizeInqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, density22.mo627toDpu2uoSUM(Constraints.m6345getMaxWidthimpl(boxWithConstraintsScope2.mo815getConstraintsmsEJaDk())), density22.mo627toDpu2uoSUM(Constraints.m6344getMaxHeightimpl(boxWithConstraintsScope2.mo815getConstraintsmsEJaDk())), 3, null);
                                if (z3) {
                                    companion2 = NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, bottomDrawerState42.getNestedScrollConnection$material_release(), null, 2, null);
                                } else {
                                    companion2 = Modifier.INSTANCE;
                                }
                                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume3 = composer3.consume(localLayoutDirection);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                Modifier anchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(Modifier.INSTANCE.then(companion2), bottomDrawerState42.getAnchoredDraggableState$material_release(), Orientation.Vertical, z3, consume3 == LayoutDirection.Rtl, null, false, 48, null);
                                Function2<Composer, Integer, Unit> function24 = function232;
                                long j12 = j8;
                                final BottomDrawerState bottomDrawerState5 = bottomDrawerState42;
                                Shape shape5 = shape3;
                                long j13 = j6;
                                long j14 = j7;
                                float f5 = f3;
                                final boolean z6 = z3;
                                final CoroutineScope coroutineScope22 = coroutineScope2;
                                final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                                composer3.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                composer3.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(anchoredDraggable$default);
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
                                ComposerKt.sourceInformationMarkerStart(composer3, 1720994599, "C684@25607L9,685@25629L391,696@26054L33,697@26100L3095:Drawer.kt#jmzs0o");
                                function24.invoke(composer3, 0);
                                DrawerKt.m1651BottomDrawerScrim3JVO9M(j12, new Function0<Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$2$1$1
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
                                        if (z6 && bottomDrawerState5.confirmStateChange$material_release(BottomDrawerValue.Closed)) {
                                            BuildersKt__Builders_commonKt.launch$default(coroutineScope22, null, null, new AnonymousClass1(bottomDrawerState5, null), 3, null);
                                        }
                                    }

                                    /* compiled from: Drawer.kt */
                                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                    @DebugMetadata(c = "androidx.compose.material.DrawerKt$BottomDrawer$2$1$1$1", f = "Drawer.kt", i = {}, l = {692}, m = "invokeSuspend", n = {}, s = {})
                                    /* renamed from: androidx.compose.material.DrawerKt$BottomDrawer$2$1$1$1, reason: invalid class name */
                                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        final /* synthetic */ BottomDrawerState $drawerState;
                                        int label;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        AnonymousClass1(BottomDrawerState bottomDrawerState, Continuation<? super AnonymousClass1> continuation) {
                                            super(2, continuation);
                                            this.$drawerState = bottomDrawerState;
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            return new AnonymousClass1(this.$drawerState, continuation);
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
                                                if (this.$drawerState.close(this) == coroutine_suspended) {
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
                                }, bottomDrawerState5.getTargetValue() != BottomDrawerValue.Closed, composer3, 0);
                                final String m1780getString4foXLRw = Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1777getNavigationMenuUdPEhr4(), composer3, 6);
                                SurfaceKt.m1782SurfaceFjzlyU(SemanticsModifierKt.semantics$default(OffsetKt.offset(OnRemeasuredModifierKt.onSizeChanged(m932sizeInqDBjuR0$default, new Function1<IntSize, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$2$1$2

                                    /* compiled from: Drawer.kt */
                                    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                                    public /* synthetic */ class WhenMappings {
                                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                        static {
                                            int[] iArr = new int[BottomDrawerValue.values().length];
                                            try {
                                                iArr[BottomDrawerValue.Closed.ordinal()] = 1;
                                            } catch (NoSuchFieldError unused) {
                                            }
                                            try {
                                                iArr[BottomDrawerValue.Open.ordinal()] = 2;
                                            } catch (NoSuchFieldError unused2) {
                                            }
                                            try {
                                                iArr[BottomDrawerValue.Expanded.ordinal()] = 3;
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
                                        m1656invokeozmzZPI(intSize.getPackedValue());
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                                    public final void m1656invokeozmzZPI(long j15) {
                                        BottomDrawerValue bottomDrawerValue;
                                        final float m6558getHeightimpl = IntSize.m6558getHeightimpl(j15);
                                        final float f6 = m6344getMaxHeightimpl;
                                        final boolean z7 = z5;
                                        DraggableAnchors<BottomDrawerValue> DraggableAnchors = AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<BottomDrawerValue>, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$2$1$2$newAnchors$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<BottomDrawerValue> draggableAnchorsConfig) {
                                                invoke2(draggableAnchorsConfig);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(DraggableAnchorsConfig<BottomDrawerValue> draggableAnchorsConfig) {
                                                draggableAnchorsConfig.at(BottomDrawerValue.Closed, f6);
                                                float f7 = f6 * 0.5f;
                                                if (m6558getHeightimpl > f7 || z7) {
                                                    draggableAnchorsConfig.at(BottomDrawerValue.Open, f7);
                                                }
                                                if (m6558getHeightimpl > 0.0f) {
                                                    draggableAnchorsConfig.at(BottomDrawerValue.Expanded, Math.max(0.0f, f6 - m6558getHeightimpl));
                                                }
                                            }
                                        });
                                        if (BottomDrawerState.this.getAnchoredDraggableState$material_release().getAnchors().getSize() <= 0 && DraggableAnchors.hasAnchorFor(BottomDrawerState.this.getCurrentValue())) {
                                            bottomDrawerValue = BottomDrawerState.this.getCurrentValue();
                                        } else {
                                            int i16 = WhenMappings.$EnumSwitchMapping$0[BottomDrawerState.this.getTargetValue().ordinal()];
                                            if (i16 == 1) {
                                                bottomDrawerValue = BottomDrawerValue.Closed;
                                            } else if (i16 == 2 || i16 == 3) {
                                                if (DraggableAnchors.hasAnchorFor(BottomDrawerValue.Open)) {
                                                    bottomDrawerValue = BottomDrawerValue.Open;
                                                } else {
                                                    bottomDrawerValue = DraggableAnchors.hasAnchorFor(BottomDrawerValue.Expanded) ? BottomDrawerValue.Expanded : BottomDrawerValue.Closed;
                                                }
                                            } else {
                                                throw new NoWhenBranchMatchedException();
                                            }
                                        }
                                        BottomDrawerState.this.getAnchoredDraggableState$material_release().updateAnchors(DraggableAnchors, bottomDrawerValue);
                                    }
                                }), new Function1<Density, IntOffset>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$2$1$3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ IntOffset invoke(Density density3) {
                                        return IntOffset.m6508boximpl(m1657invokeBjo55l4(density3));
                                    }

                                    /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                                    public final long m1657invokeBjo55l4(Density density3) {
                                        return IntOffsetKt.IntOffset(0, MathKt.roundToInt(BottomDrawerState.this.requireOffset$material_release()));
                                    }
                                }), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$2$1$4
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
                                        SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m1780getString4foXLRw);
                                        if (bottomDrawerState5.isOpen()) {
                                            final BottomDrawerState bottomDrawerState6 = bottomDrawerState5;
                                            final CoroutineScope coroutineScope3 = coroutineScope22;
                                            SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$2$1$4.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                /* compiled from: Drawer.kt */
                                                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                                @DebugMetadata(c = "androidx.compose.material.DrawerKt$BottomDrawer$2$1$4$1$1", f = "Drawer.kt", i = {}, l = {748}, m = "invokeSuspend", n = {}, s = {})
                                                /* renamed from: androidx.compose.material.DrawerKt$BottomDrawer$2$1$4$1$1, reason: invalid class name and collision with other inner class name */
                                                static final class C00421 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                    final /* synthetic */ BottomDrawerState $drawerState;
                                                    int label;

                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    C00421(BottomDrawerState bottomDrawerState, Continuation<? super C00421> continuation) {
                                                        super(2, continuation);
                                                        this.$drawerState = bottomDrawerState;
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                        return new C00421(this.$drawerState, continuation);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                        return ((C00421) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    public final Object invokeSuspend(Object obj) {
                                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                        int i = this.label;
                                                        if (i == 0) {
                                                            ResultKt.throwOnFailure(obj);
                                                            this.label = 1;
                                                            if (this.$drawerState.close(this) == coroutine_suspended) {
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

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Boolean invoke() {
                                                    if (BottomDrawerState.this.confirmStateChange$material_release(BottomDrawerValue.Closed)) {
                                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new C00421(BottomDrawerState.this, null), 3, null);
                                                    }
                                                    return true;
                                                }
                                            }, 1, null);
                                        }
                                    }
                                }, 1, null), shape5, j13, j14, null, f5, ComposableLambdaKt.composableLambda(composer3, 457750254, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$2$1$5
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
                                        ComposerKt.sourceInformation(composer4, "C757@29150L31:Drawer.kt#jmzs0o");
                                        if ((i16 & 11) == 2 && composer4.getSkipping()) {
                                            composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(457750254, i16, -1, "androidx.compose.material.BottomDrawer.<anonymous>.<anonymous>.<anonymous> (Drawer.kt:757)");
                                        }
                                        Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                                        composer4.startReplaceableGroup(-483455358);
                                        ComposerKt.sourceInformation(composer4, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                        Modifier.Companion companion3 = Modifier.INSTANCE;
                                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer4, 0);
                                        composer4.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                        CompositionLocalMap currentCompositionLocalMap2 = composer4.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion3);
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
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endReplaceableGroup();
                                composer3.endNode();
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), startRestartGroup, 3072, 6);
                    composer2 = startRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    z4 = z3;
                    bottomDrawerState3 = bottomDrawerState42;
                    j9 = j8;
                    shape4 = shape3;
                    j10 = j6;
                    j11 = j7;
                    f4 = f3;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                f2 = f;
                if ((i & 3670016) != 0) {
                }
                if ((i & 29360128) == 0) {
                }
                if ((234881024 & i) == 0) {
                }
                if ((i2 & 512) == 0) {
                }
                function22 = function2;
                int i1322 = i7;
                if (i4 == 4) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i12 != 0) {
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
                EffectsKt.SideEffect(new Function0<Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1
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
                        BottomDrawerState.this.setDensity$material_release(density22);
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
                final Function2<? super Composer, ? super Integer, Unit> function2322 = function22;
                final BottomDrawerState bottomDrawerState422 = bottomDrawerState2;
                BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(startRestartGroup, 1220102512, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$2
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
                        BoxWithConstraintsScope boxWithConstraintsScope2;
                        int i15;
                        Modifier.Companion companion2;
                        ComposerKt.sourceInformation(composer3, "C*660@24815L7,672@25230L7,683@25578L3627:Drawer.kt#jmzs0o");
                        if ((i14 & 14) == 0) {
                            boxWithConstraintsScope2 = boxWithConstraintsScope;
                            i15 = i14 | (composer3.changed(boxWithConstraintsScope2) ? 4 : 2);
                        } else {
                            boxWithConstraintsScope2 = boxWithConstraintsScope;
                            i15 = i14;
                        }
                        if ((i15 & 91) != 18 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1220102512, i15, -1, "androidx.compose.material.BottomDrawer.<anonymous> (Drawer.kt:657)");
                            }
                            final float m6344getMaxHeightimpl = Constraints.m6344getMaxHeightimpl(boxWithConstraintsScope2.mo815getConstraintsmsEJaDk());
                            final boolean z5 = Constraints.m6345getMaxWidthimpl(boxWithConstraintsScope2.mo815getConstraintsmsEJaDk()) > Constraints.m6344getMaxHeightimpl(boxWithConstraintsScope2.mo815getConstraintsmsEJaDk());
                            ProvidableCompositionLocal<Density> localDensity222 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume222 = composer3.consume(localDensity222);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            Density density222 = (Density) consume222;
                            Modifier m932sizeInqDBjuR0$default = SizeKt.m932sizeInqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, density222.mo627toDpu2uoSUM(Constraints.m6345getMaxWidthimpl(boxWithConstraintsScope2.mo815getConstraintsmsEJaDk())), density222.mo627toDpu2uoSUM(Constraints.m6344getMaxHeightimpl(boxWithConstraintsScope2.mo815getConstraintsmsEJaDk())), 3, null);
                            if (z3) {
                                companion2 = NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, bottomDrawerState422.getNestedScrollConnection$material_release(), null, 2, null);
                            } else {
                                companion2 = Modifier.INSTANCE;
                            }
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume3 = composer3.consume(localLayoutDirection);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            Modifier anchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(Modifier.INSTANCE.then(companion2), bottomDrawerState422.getAnchoredDraggableState$material_release(), Orientation.Vertical, z3, consume3 == LayoutDirection.Rtl, null, false, 48, null);
                            Function2<Composer, Integer, Unit> function24 = function2322;
                            long j12 = j8;
                            final BottomDrawerState bottomDrawerState5 = bottomDrawerState422;
                            Shape shape5 = shape3;
                            long j13 = j6;
                            long j14 = j7;
                            float f5 = f3;
                            final boolean z6 = z3;
                            final CoroutineScope coroutineScope222 = coroutineScope22;
                            final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                            composer3.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                            composer3.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(anchoredDraggable$default);
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
                            ComposerKt.sourceInformationMarkerStart(composer3, 1720994599, "C684@25607L9,685@25629L391,696@26054L33,697@26100L3095:Drawer.kt#jmzs0o");
                            function24.invoke(composer3, 0);
                            DrawerKt.m1651BottomDrawerScrim3JVO9M(j12, new Function0<Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$2$1$1
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
                                    if (z6 && bottomDrawerState5.confirmStateChange$material_release(BottomDrawerValue.Closed)) {
                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope222, null, null, new AnonymousClass1(bottomDrawerState5, null), 3, null);
                                    }
                                }

                                /* compiled from: Drawer.kt */
                                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                @DebugMetadata(c = "androidx.compose.material.DrawerKt$BottomDrawer$2$1$1$1", f = "Drawer.kt", i = {}, l = {692}, m = "invokeSuspend", n = {}, s = {})
                                /* renamed from: androidx.compose.material.DrawerKt$BottomDrawer$2$1$1$1, reason: invalid class name */
                                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ BottomDrawerState $drawerState;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    AnonymousClass1(BottomDrawerState bottomDrawerState, Continuation<? super AnonymousClass1> continuation) {
                                        super(2, continuation);
                                        this.$drawerState = bottomDrawerState;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new AnonymousClass1(this.$drawerState, continuation);
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
                                            if (this.$drawerState.close(this) == coroutine_suspended) {
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
                            }, bottomDrawerState5.getTargetValue() != BottomDrawerValue.Closed, composer3, 0);
                            final String m1780getString4foXLRw = Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1777getNavigationMenuUdPEhr4(), composer3, 6);
                            SurfaceKt.m1782SurfaceFjzlyU(SemanticsModifierKt.semantics$default(OffsetKt.offset(OnRemeasuredModifierKt.onSizeChanged(m932sizeInqDBjuR0$default, new Function1<IntSize, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$2$1$2

                                /* compiled from: Drawer.kt */
                                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                                public /* synthetic */ class WhenMappings {
                                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                    static {
                                        int[] iArr = new int[BottomDrawerValue.values().length];
                                        try {
                                            iArr[BottomDrawerValue.Closed.ordinal()] = 1;
                                        } catch (NoSuchFieldError unused) {
                                        }
                                        try {
                                            iArr[BottomDrawerValue.Open.ordinal()] = 2;
                                        } catch (NoSuchFieldError unused2) {
                                        }
                                        try {
                                            iArr[BottomDrawerValue.Expanded.ordinal()] = 3;
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
                                    m1656invokeozmzZPI(intSize.getPackedValue());
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                                public final void m1656invokeozmzZPI(long j15) {
                                    BottomDrawerValue bottomDrawerValue;
                                    final float m6558getHeightimpl = IntSize.m6558getHeightimpl(j15);
                                    final float f6 = m6344getMaxHeightimpl;
                                    final boolean z7 = z5;
                                    DraggableAnchors<BottomDrawerValue> DraggableAnchors = AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<BottomDrawerValue>, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$2$1$2$newAnchors$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<BottomDrawerValue> draggableAnchorsConfig) {
                                            invoke2(draggableAnchorsConfig);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(DraggableAnchorsConfig<BottomDrawerValue> draggableAnchorsConfig) {
                                            draggableAnchorsConfig.at(BottomDrawerValue.Closed, f6);
                                            float f7 = f6 * 0.5f;
                                            if (m6558getHeightimpl > f7 || z7) {
                                                draggableAnchorsConfig.at(BottomDrawerValue.Open, f7);
                                            }
                                            if (m6558getHeightimpl > 0.0f) {
                                                draggableAnchorsConfig.at(BottomDrawerValue.Expanded, Math.max(0.0f, f6 - m6558getHeightimpl));
                                            }
                                        }
                                    });
                                    if (BottomDrawerState.this.getAnchoredDraggableState$material_release().getAnchors().getSize() <= 0 && DraggableAnchors.hasAnchorFor(BottomDrawerState.this.getCurrentValue())) {
                                        bottomDrawerValue = BottomDrawerState.this.getCurrentValue();
                                    } else {
                                        int i16 = WhenMappings.$EnumSwitchMapping$0[BottomDrawerState.this.getTargetValue().ordinal()];
                                        if (i16 == 1) {
                                            bottomDrawerValue = BottomDrawerValue.Closed;
                                        } else if (i16 == 2 || i16 == 3) {
                                            if (DraggableAnchors.hasAnchorFor(BottomDrawerValue.Open)) {
                                                bottomDrawerValue = BottomDrawerValue.Open;
                                            } else {
                                                bottomDrawerValue = DraggableAnchors.hasAnchorFor(BottomDrawerValue.Expanded) ? BottomDrawerValue.Expanded : BottomDrawerValue.Closed;
                                            }
                                        } else {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                    }
                                    BottomDrawerState.this.getAnchoredDraggableState$material_release().updateAnchors(DraggableAnchors, bottomDrawerValue);
                                }
                            }), new Function1<Density, IntOffset>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$2$1$3
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ IntOffset invoke(Density density3) {
                                    return IntOffset.m6508boximpl(m1657invokeBjo55l4(density3));
                                }

                                /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                                public final long m1657invokeBjo55l4(Density density3) {
                                    return IntOffsetKt.IntOffset(0, MathKt.roundToInt(BottomDrawerState.this.requireOffset$material_release()));
                                }
                            }), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$2$1$4
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
                                    SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m1780getString4foXLRw);
                                    if (bottomDrawerState5.isOpen()) {
                                        final BottomDrawerState bottomDrawerState6 = bottomDrawerState5;
                                        final CoroutineScope coroutineScope3 = coroutineScope222;
                                        SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$2$1$4.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            /* compiled from: Drawer.kt */
                                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                            @DebugMetadata(c = "androidx.compose.material.DrawerKt$BottomDrawer$2$1$4$1$1", f = "Drawer.kt", i = {}, l = {748}, m = "invokeSuspend", n = {}, s = {})
                                            /* renamed from: androidx.compose.material.DrawerKt$BottomDrawer$2$1$4$1$1, reason: invalid class name and collision with other inner class name */
                                            static final class C00421 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                final /* synthetic */ BottomDrawerState $drawerState;
                                                int label;

                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                C00421(BottomDrawerState bottomDrawerState, Continuation<? super C00421> continuation) {
                                                    super(2, continuation);
                                                    this.$drawerState = bottomDrawerState;
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                    return new C00421(this.$drawerState, continuation);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                    return ((C00421) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Object invokeSuspend(Object obj) {
                                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                    int i = this.label;
                                                    if (i == 0) {
                                                        ResultKt.throwOnFailure(obj);
                                                        this.label = 1;
                                                        if (this.$drawerState.close(this) == coroutine_suspended) {
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

                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Boolean invoke() {
                                                if (BottomDrawerState.this.confirmStateChange$material_release(BottomDrawerValue.Closed)) {
                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new C00421(BottomDrawerState.this, null), 3, null);
                                                }
                                                return true;
                                            }
                                        }, 1, null);
                                    }
                                }
                            }, 1, null), shape5, j13, j14, null, f5, ComposableLambdaKt.composableLambda(composer3, 457750254, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$2$1$5
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
                                    ComposerKt.sourceInformation(composer4, "C757@29150L31:Drawer.kt#jmzs0o");
                                    if ((i16 & 11) == 2 && composer4.getSkipping()) {
                                        composer4.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(457750254, i16, -1, "androidx.compose.material.BottomDrawer.<anonymous>.<anonymous>.<anonymous> (Drawer.kt:757)");
                                    }
                                    Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                                    composer4.startReplaceableGroup(-483455358);
                                    ComposerKt.sourceInformation(composer4, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                    Modifier.Companion companion3 = Modifier.INSTANCE;
                                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer4, 0);
                                    composer4.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                    CompositionLocalMap currentCompositionLocalMap2 = composer4.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion3);
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
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endReplaceableGroup();
                            composer3.endNode();
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), startRestartGroup, 3072, 6);
                composer2 = startRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                }
                z4 = z3;
                bottomDrawerState3 = bottomDrawerState422;
                j9 = j8;
                shape4 = shape3;
                j10 = j6;
                j11 = j7;
                f4 = f3;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z2 = z;
            if ((57344 & i) == 0) {
            }
            i6 = i2 & 32;
            if (i6 != 0) {
            }
            f2 = f;
            if ((i & 3670016) != 0) {
            }
            if ((i & 29360128) == 0) {
            }
            if ((234881024 & i) == 0) {
            }
            if ((i2 & 512) == 0) {
            }
            function22 = function2;
            int i13222 = i7;
            if (i4 == 4) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i12 != 0) {
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
            ProvidableCompositionLocal<Density> localDensity222 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume222 = startRestartGroup.consume(localDensity222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final Density density222 = (Density) consume222;
            EffectsKt.SideEffect(new Function0<Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1
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
                    BottomDrawerState.this.setDensity$material_release(density222);
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
            final CoroutineScope coroutineScope222 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
            startRestartGroup.endReplaceableGroup();
            final Function2<? super Composer, ? super Integer, Unit> function23222 = function22;
            final BottomDrawerState bottomDrawerState4222 = bottomDrawerState2;
            BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(startRestartGroup, 1220102512, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$2
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
                    BoxWithConstraintsScope boxWithConstraintsScope2;
                    int i15;
                    Modifier.Companion companion2;
                    ComposerKt.sourceInformation(composer3, "C*660@24815L7,672@25230L7,683@25578L3627:Drawer.kt#jmzs0o");
                    if ((i14 & 14) == 0) {
                        boxWithConstraintsScope2 = boxWithConstraintsScope;
                        i15 = i14 | (composer3.changed(boxWithConstraintsScope2) ? 4 : 2);
                    } else {
                        boxWithConstraintsScope2 = boxWithConstraintsScope;
                        i15 = i14;
                    }
                    if ((i15 & 91) != 18 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1220102512, i15, -1, "androidx.compose.material.BottomDrawer.<anonymous> (Drawer.kt:657)");
                        }
                        final float m6344getMaxHeightimpl = Constraints.m6344getMaxHeightimpl(boxWithConstraintsScope2.mo815getConstraintsmsEJaDk());
                        final boolean z5 = Constraints.m6345getMaxWidthimpl(boxWithConstraintsScope2.mo815getConstraintsmsEJaDk()) > Constraints.m6344getMaxHeightimpl(boxWithConstraintsScope2.mo815getConstraintsmsEJaDk());
                        ProvidableCompositionLocal<Density> localDensity2222 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume2222 = composer3.consume(localDensity2222);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Density density2222 = (Density) consume2222;
                        Modifier m932sizeInqDBjuR0$default = SizeKt.m932sizeInqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, density2222.mo627toDpu2uoSUM(Constraints.m6345getMaxWidthimpl(boxWithConstraintsScope2.mo815getConstraintsmsEJaDk())), density2222.mo627toDpu2uoSUM(Constraints.m6344getMaxHeightimpl(boxWithConstraintsScope2.mo815getConstraintsmsEJaDk())), 3, null);
                        if (z3) {
                            companion2 = NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, bottomDrawerState4222.getNestedScrollConnection$material_release(), null, 2, null);
                        } else {
                            companion2 = Modifier.INSTANCE;
                        }
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume3 = composer3.consume(localLayoutDirection);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Modifier anchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(Modifier.INSTANCE.then(companion2), bottomDrawerState4222.getAnchoredDraggableState$material_release(), Orientation.Vertical, z3, consume3 == LayoutDirection.Rtl, null, false, 48, null);
                        Function2<Composer, Integer, Unit> function24 = function23222;
                        long j12 = j8;
                        final BottomDrawerState bottomDrawerState5 = bottomDrawerState4222;
                        Shape shape5 = shape3;
                        long j13 = j6;
                        long j14 = j7;
                        float f5 = f3;
                        final boolean z6 = z3;
                        final CoroutineScope coroutineScope2222 = coroutineScope222;
                        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                        composer3.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(anchoredDraggable$default);
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
                        ComposerKt.sourceInformationMarkerStart(composer3, 1720994599, "C684@25607L9,685@25629L391,696@26054L33,697@26100L3095:Drawer.kt#jmzs0o");
                        function24.invoke(composer3, 0);
                        DrawerKt.m1651BottomDrawerScrim3JVO9M(j12, new Function0<Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$2$1$1
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
                                if (z6 && bottomDrawerState5.confirmStateChange$material_release(BottomDrawerValue.Closed)) {
                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope2222, null, null, new AnonymousClass1(bottomDrawerState5, null), 3, null);
                                }
                            }

                            /* compiled from: Drawer.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                            @DebugMetadata(c = "androidx.compose.material.DrawerKt$BottomDrawer$2$1$1$1", f = "Drawer.kt", i = {}, l = {692}, m = "invokeSuspend", n = {}, s = {})
                            /* renamed from: androidx.compose.material.DrawerKt$BottomDrawer$2$1$1$1, reason: invalid class name */
                            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ BottomDrawerState $drawerState;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass1(BottomDrawerState bottomDrawerState, Continuation<? super AnonymousClass1> continuation) {
                                    super(2, continuation);
                                    this.$drawerState = bottomDrawerState;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new AnonymousClass1(this.$drawerState, continuation);
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
                                        if (this.$drawerState.close(this) == coroutine_suspended) {
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
                        }, bottomDrawerState5.getTargetValue() != BottomDrawerValue.Closed, composer3, 0);
                        final String m1780getString4foXLRw = Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1777getNavigationMenuUdPEhr4(), composer3, 6);
                        SurfaceKt.m1782SurfaceFjzlyU(SemanticsModifierKt.semantics$default(OffsetKt.offset(OnRemeasuredModifierKt.onSizeChanged(m932sizeInqDBjuR0$default, new Function1<IntSize, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$2$1$2

                            /* compiled from: Drawer.kt */
                            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                            public /* synthetic */ class WhenMappings {
                                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                static {
                                    int[] iArr = new int[BottomDrawerValue.values().length];
                                    try {
                                        iArr[BottomDrawerValue.Closed.ordinal()] = 1;
                                    } catch (NoSuchFieldError unused) {
                                    }
                                    try {
                                        iArr[BottomDrawerValue.Open.ordinal()] = 2;
                                    } catch (NoSuchFieldError unused2) {
                                    }
                                    try {
                                        iArr[BottomDrawerValue.Expanded.ordinal()] = 3;
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
                                m1656invokeozmzZPI(intSize.getPackedValue());
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                            public final void m1656invokeozmzZPI(long j15) {
                                BottomDrawerValue bottomDrawerValue;
                                final float m6558getHeightimpl = IntSize.m6558getHeightimpl(j15);
                                final float f6 = m6344getMaxHeightimpl;
                                final boolean z7 = z5;
                                DraggableAnchors<BottomDrawerValue> DraggableAnchors = AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<BottomDrawerValue>, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$2$1$2$newAnchors$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<BottomDrawerValue> draggableAnchorsConfig) {
                                        invoke2(draggableAnchorsConfig);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(DraggableAnchorsConfig<BottomDrawerValue> draggableAnchorsConfig) {
                                        draggableAnchorsConfig.at(BottomDrawerValue.Closed, f6);
                                        float f7 = f6 * 0.5f;
                                        if (m6558getHeightimpl > f7 || z7) {
                                            draggableAnchorsConfig.at(BottomDrawerValue.Open, f7);
                                        }
                                        if (m6558getHeightimpl > 0.0f) {
                                            draggableAnchorsConfig.at(BottomDrawerValue.Expanded, Math.max(0.0f, f6 - m6558getHeightimpl));
                                        }
                                    }
                                });
                                if (BottomDrawerState.this.getAnchoredDraggableState$material_release().getAnchors().getSize() <= 0 && DraggableAnchors.hasAnchorFor(BottomDrawerState.this.getCurrentValue())) {
                                    bottomDrawerValue = BottomDrawerState.this.getCurrentValue();
                                } else {
                                    int i16 = WhenMappings.$EnumSwitchMapping$0[BottomDrawerState.this.getTargetValue().ordinal()];
                                    if (i16 == 1) {
                                        bottomDrawerValue = BottomDrawerValue.Closed;
                                    } else if (i16 == 2 || i16 == 3) {
                                        if (DraggableAnchors.hasAnchorFor(BottomDrawerValue.Open)) {
                                            bottomDrawerValue = BottomDrawerValue.Open;
                                        } else {
                                            bottomDrawerValue = DraggableAnchors.hasAnchorFor(BottomDrawerValue.Expanded) ? BottomDrawerValue.Expanded : BottomDrawerValue.Closed;
                                        }
                                    } else {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                }
                                BottomDrawerState.this.getAnchoredDraggableState$material_release().updateAnchors(DraggableAnchors, bottomDrawerValue);
                            }
                        }), new Function1<Density, IntOffset>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$2$1$3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ IntOffset invoke(Density density3) {
                                return IntOffset.m6508boximpl(m1657invokeBjo55l4(density3));
                            }

                            /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                            public final long m1657invokeBjo55l4(Density density3) {
                                return IntOffsetKt.IntOffset(0, MathKt.roundToInt(BottomDrawerState.this.requireOffset$material_release()));
                            }
                        }), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$2$1$4
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
                                SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m1780getString4foXLRw);
                                if (bottomDrawerState5.isOpen()) {
                                    final BottomDrawerState bottomDrawerState6 = bottomDrawerState5;
                                    final CoroutineScope coroutineScope3 = coroutineScope2222;
                                    SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$2$1$4.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        /* compiled from: Drawer.kt */
                                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                        @DebugMetadata(c = "androidx.compose.material.DrawerKt$BottomDrawer$2$1$4$1$1", f = "Drawer.kt", i = {}, l = {748}, m = "invokeSuspend", n = {}, s = {})
                                        /* renamed from: androidx.compose.material.DrawerKt$BottomDrawer$2$1$4$1$1, reason: invalid class name and collision with other inner class name */
                                        static final class C00421 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                            final /* synthetic */ BottomDrawerState $drawerState;
                                            int label;

                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            C00421(BottomDrawerState bottomDrawerState, Continuation<? super C00421> continuation) {
                                                super(2, continuation);
                                                this.$drawerState = bottomDrawerState;
                                            }

                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                return new C00421(this.$drawerState, continuation);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                return ((C00421) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                            }

                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                            public final Object invokeSuspend(Object obj) {
                                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                int i = this.label;
                                                if (i == 0) {
                                                    ResultKt.throwOnFailure(obj);
                                                    this.label = 1;
                                                    if (this.$drawerState.close(this) == coroutine_suspended) {
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

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Boolean invoke() {
                                            if (BottomDrawerState.this.confirmStateChange$material_release(BottomDrawerValue.Closed)) {
                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new C00421(BottomDrawerState.this, null), 3, null);
                                            }
                                            return true;
                                        }
                                    }, 1, null);
                                }
                            }
                        }, 1, null), shape5, j13, j14, null, f5, ComposableLambdaKt.composableLambda(composer3, 457750254, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$2$1$5
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
                                ComposerKt.sourceInformation(composer4, "C757@29150L31:Drawer.kt#jmzs0o");
                                if ((i16 & 11) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(457750254, i16, -1, "androidx.compose.material.BottomDrawer.<anonymous>.<anonymous>.<anonymous> (Drawer.kt:757)");
                                }
                                Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                                composer4.startReplaceableGroup(-483455358);
                                ComposerKt.sourceInformation(composer4, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                Modifier.Companion companion3 = Modifier.INSTANCE;
                                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer4, 0);
                                composer4.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                CompositionLocalMap currentCompositionLocalMap2 = composer4.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion3);
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
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), startRestartGroup, 3072, 6);
            composer2 = startRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
            }
            z4 = z3;
            bottomDrawerState3 = bottomDrawerState4222;
            j9 = j8;
            shape4 = shape3;
            j10 = j6;
            j11 = j7;
            f4 = f3;
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
        z2 = z;
        if ((57344 & i) == 0) {
        }
        i6 = i2 & 32;
        if (i6 != 0) {
        }
        f2 = f;
        if ((i & 3670016) != 0) {
        }
        if ((i & 29360128) == 0) {
        }
        if ((234881024 & i) == 0) {
        }
        if ((i2 & 512) == 0) {
        }
        function22 = function2;
        int i132222 = i7;
        if (i4 == 4) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i12 != 0) {
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
        ProvidableCompositionLocal<Density> localDensity2222 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2222 = startRestartGroup.consume(localDensity2222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        final Density density2222 = (Density) consume2222;
        EffectsKt.SideEffect(new Function0<Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$1
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
                BottomDrawerState.this.setDensity$material_release(density2222);
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
        final CoroutineScope coroutineScope2222 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
        startRestartGroup.endReplaceableGroup();
        final Function2<? super Composer, ? super Integer, Unit> function232222 = function22;
        final BottomDrawerState bottomDrawerState42222 = bottomDrawerState2;
        BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(startRestartGroup, 1220102512, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$2
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
                BoxWithConstraintsScope boxWithConstraintsScope2;
                int i15;
                Modifier.Companion companion2;
                ComposerKt.sourceInformation(composer3, "C*660@24815L7,672@25230L7,683@25578L3627:Drawer.kt#jmzs0o");
                if ((i14 & 14) == 0) {
                    boxWithConstraintsScope2 = boxWithConstraintsScope;
                    i15 = i14 | (composer3.changed(boxWithConstraintsScope2) ? 4 : 2);
                } else {
                    boxWithConstraintsScope2 = boxWithConstraintsScope;
                    i15 = i14;
                }
                if ((i15 & 91) != 18 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1220102512, i15, -1, "androidx.compose.material.BottomDrawer.<anonymous> (Drawer.kt:657)");
                    }
                    final float m6344getMaxHeightimpl = Constraints.m6344getMaxHeightimpl(boxWithConstraintsScope2.mo815getConstraintsmsEJaDk());
                    final boolean z5 = Constraints.m6345getMaxWidthimpl(boxWithConstraintsScope2.mo815getConstraintsmsEJaDk()) > Constraints.m6344getMaxHeightimpl(boxWithConstraintsScope2.mo815getConstraintsmsEJaDk());
                    ProvidableCompositionLocal<Density> localDensity22222 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume22222 = composer3.consume(localDensity22222);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    Density density22222 = (Density) consume22222;
                    Modifier m932sizeInqDBjuR0$default = SizeKt.m932sizeInqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, density22222.mo627toDpu2uoSUM(Constraints.m6345getMaxWidthimpl(boxWithConstraintsScope2.mo815getConstraintsmsEJaDk())), density22222.mo627toDpu2uoSUM(Constraints.m6344getMaxHeightimpl(boxWithConstraintsScope2.mo815getConstraintsmsEJaDk())), 3, null);
                    if (z3) {
                        companion2 = NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, bottomDrawerState42222.getNestedScrollConnection$material_release(), null, 2, null);
                    } else {
                        companion2 = Modifier.INSTANCE;
                    }
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume3 = composer3.consume(localLayoutDirection);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    Modifier anchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(Modifier.INSTANCE.then(companion2), bottomDrawerState42222.getAnchoredDraggableState$material_release(), Orientation.Vertical, z3, consume3 == LayoutDirection.Rtl, null, false, 48, null);
                    Function2<Composer, Integer, Unit> function24 = function232222;
                    long j12 = j8;
                    final BottomDrawerState bottomDrawerState5 = bottomDrawerState42222;
                    Shape shape5 = shape3;
                    long j13 = j6;
                    long j14 = j7;
                    float f5 = f3;
                    final boolean z6 = z3;
                    final CoroutineScope coroutineScope22222 = coroutineScope2222;
                    final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                    composer3.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(anchoredDraggable$default);
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
                    ComposerKt.sourceInformationMarkerStart(composer3, 1720994599, "C684@25607L9,685@25629L391,696@26054L33,697@26100L3095:Drawer.kt#jmzs0o");
                    function24.invoke(composer3, 0);
                    DrawerKt.m1651BottomDrawerScrim3JVO9M(j12, new Function0<Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$2$1$1
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
                            if (z6 && bottomDrawerState5.confirmStateChange$material_release(BottomDrawerValue.Closed)) {
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope22222, null, null, new AnonymousClass1(bottomDrawerState5, null), 3, null);
                            }
                        }

                        /* compiled from: Drawer.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                        @DebugMetadata(c = "androidx.compose.material.DrawerKt$BottomDrawer$2$1$1$1", f = "Drawer.kt", i = {}, l = {692}, m = "invokeSuspend", n = {}, s = {})
                        /* renamed from: androidx.compose.material.DrawerKt$BottomDrawer$2$1$1$1, reason: invalid class name */
                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ BottomDrawerState $drawerState;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(BottomDrawerState bottomDrawerState, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$drawerState = bottomDrawerState;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass1(this.$drawerState, continuation);
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
                                    if (this.$drawerState.close(this) == coroutine_suspended) {
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
                    }, bottomDrawerState5.getTargetValue() != BottomDrawerValue.Closed, composer3, 0);
                    final String m1780getString4foXLRw = Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1777getNavigationMenuUdPEhr4(), composer3, 6);
                    SurfaceKt.m1782SurfaceFjzlyU(SemanticsModifierKt.semantics$default(OffsetKt.offset(OnRemeasuredModifierKt.onSizeChanged(m932sizeInqDBjuR0$default, new Function1<IntSize, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$2$1$2

                        /* compiled from: Drawer.kt */
                        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                        public /* synthetic */ class WhenMappings {
                            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                            static {
                                int[] iArr = new int[BottomDrawerValue.values().length];
                                try {
                                    iArr[BottomDrawerValue.Closed.ordinal()] = 1;
                                } catch (NoSuchFieldError unused) {
                                }
                                try {
                                    iArr[BottomDrawerValue.Open.ordinal()] = 2;
                                } catch (NoSuchFieldError unused2) {
                                }
                                try {
                                    iArr[BottomDrawerValue.Expanded.ordinal()] = 3;
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
                            m1656invokeozmzZPI(intSize.getPackedValue());
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                        public final void m1656invokeozmzZPI(long j15) {
                            BottomDrawerValue bottomDrawerValue;
                            final float m6558getHeightimpl = IntSize.m6558getHeightimpl(j15);
                            final float f6 = m6344getMaxHeightimpl;
                            final boolean z7 = z5;
                            DraggableAnchors<BottomDrawerValue> DraggableAnchors = AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<BottomDrawerValue>, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$2$1$2$newAnchors$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<BottomDrawerValue> draggableAnchorsConfig) {
                                    invoke2(draggableAnchorsConfig);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(DraggableAnchorsConfig<BottomDrawerValue> draggableAnchorsConfig) {
                                    draggableAnchorsConfig.at(BottomDrawerValue.Closed, f6);
                                    float f7 = f6 * 0.5f;
                                    if (m6558getHeightimpl > f7 || z7) {
                                        draggableAnchorsConfig.at(BottomDrawerValue.Open, f7);
                                    }
                                    if (m6558getHeightimpl > 0.0f) {
                                        draggableAnchorsConfig.at(BottomDrawerValue.Expanded, Math.max(0.0f, f6 - m6558getHeightimpl));
                                    }
                                }
                            });
                            if (BottomDrawerState.this.getAnchoredDraggableState$material_release().getAnchors().getSize() <= 0 && DraggableAnchors.hasAnchorFor(BottomDrawerState.this.getCurrentValue())) {
                                bottomDrawerValue = BottomDrawerState.this.getCurrentValue();
                            } else {
                                int i16 = WhenMappings.$EnumSwitchMapping$0[BottomDrawerState.this.getTargetValue().ordinal()];
                                if (i16 == 1) {
                                    bottomDrawerValue = BottomDrawerValue.Closed;
                                } else if (i16 == 2 || i16 == 3) {
                                    if (DraggableAnchors.hasAnchorFor(BottomDrawerValue.Open)) {
                                        bottomDrawerValue = BottomDrawerValue.Open;
                                    } else {
                                        bottomDrawerValue = DraggableAnchors.hasAnchorFor(BottomDrawerValue.Expanded) ? BottomDrawerValue.Expanded : BottomDrawerValue.Closed;
                                    }
                                } else {
                                    throw new NoWhenBranchMatchedException();
                                }
                            }
                            BottomDrawerState.this.getAnchoredDraggableState$material_release().updateAnchors(DraggableAnchors, bottomDrawerValue);
                        }
                    }), new Function1<Density, IntOffset>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$2$1$3
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ IntOffset invoke(Density density3) {
                            return IntOffset.m6508boximpl(m1657invokeBjo55l4(density3));
                        }

                        /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                        public final long m1657invokeBjo55l4(Density density3) {
                            return IntOffsetKt.IntOffset(0, MathKt.roundToInt(BottomDrawerState.this.requireOffset$material_release()));
                        }
                    }), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$2$1$4
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
                            SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m1780getString4foXLRw);
                            if (bottomDrawerState5.isOpen()) {
                                final BottomDrawerState bottomDrawerState6 = bottomDrawerState5;
                                final CoroutineScope coroutineScope3 = coroutineScope22222;
                                SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$2$1$4.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* compiled from: Drawer.kt */
                                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                    @DebugMetadata(c = "androidx.compose.material.DrawerKt$BottomDrawer$2$1$4$1$1", f = "Drawer.kt", i = {}, l = {748}, m = "invokeSuspend", n = {}, s = {})
                                    /* renamed from: androidx.compose.material.DrawerKt$BottomDrawer$2$1$4$1$1, reason: invalid class name and collision with other inner class name */
                                    static final class C00421 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        final /* synthetic */ BottomDrawerState $drawerState;
                                        int label;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        C00421(BottomDrawerState bottomDrawerState, Continuation<? super C00421> continuation) {
                                            super(2, continuation);
                                            this.$drawerState = bottomDrawerState;
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            return new C00421(this.$drawerState, continuation);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                            return ((C00421) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Object invokeSuspend(Object obj) {
                                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            int i = this.label;
                                            if (i == 0) {
                                                ResultKt.throwOnFailure(obj);
                                                this.label = 1;
                                                if (this.$drawerState.close(this) == coroutine_suspended) {
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

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        if (BottomDrawerState.this.confirmStateChange$material_release(BottomDrawerValue.Closed)) {
                                            BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new C00421(BottomDrawerState.this, null), 3, null);
                                        }
                                        return true;
                                    }
                                }, 1, null);
                            }
                        }
                    }, 1, null), shape5, j13, j14, null, f5, ComposableLambdaKt.composableLambda(composer3, 457750254, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawer$2$1$5
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
                            ComposerKt.sourceInformation(composer4, "C757@29150L31:Drawer.kt#jmzs0o");
                            if ((i16 & 11) == 2 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(457750254, i16, -1, "androidx.compose.material.BottomDrawer.<anonymous>.<anonymous>.<anonymous> (Drawer.kt:757)");
                            }
                            Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                            composer4.startReplaceableGroup(-483455358);
                            ComposerKt.sourceInformation(composer4, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                            Modifier.Companion companion3 = Modifier.INSTANCE;
                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer4, 0);
                            composer4.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = composer4.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion3);
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
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }), startRestartGroup, 3072, 6);
        composer2 = startRestartGroup;
        if (ComposerKt.isTraceInProgress()) {
        }
        z4 = z3;
        bottomDrawerState3 = bottomDrawerState42222;
        j9 = j8;
        shape4 = shape3;
        j10 = j6;
        j11 = j7;
        f4 = f3;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calculateFraction(float f, float f2, float f3) {
        return RangesKt.coerceIn((f3 - f) / (f2 - f), 0.0f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: BottomDrawerScrim-3J-VO9M, reason: not valid java name */
    public static final void m1651BottomDrawerScrim3JVO9M(final long j, final Function0<Unit> function0, final boolean z, Composer composer, final int i) {
        int i2;
        Modifier.Companion companion;
        Composer startRestartGroup = composer.startRestartGroup(-513067266);
        ComposerKt.sourceInformation(startRestartGroup, "C(BottomDrawerScrim)P(0:c#ui.graphics.Color)793@29917L121,797@30065L30,811@30509L171:Drawer.kt#jmzs0o");
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
                ComposerKt.traceEventStart(-513067266, i2, -1, "androidx.compose.material.BottomDrawerScrim (Drawer.kt:791)");
            }
            if (j != Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                final State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, null, startRestartGroup, 48, 28);
                final String m1780getString4foXLRw = Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1773getCloseDrawerUdPEhr4(), startRestartGroup, 6);
                if (z) {
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    startRestartGroup.startReplaceableGroup(463511548);
                    boolean changedInstance = startRestartGroup.changedInstance(function0);
                    DrawerKt$BottomDrawerScrim$dismissModifier$1$1 rememberedValue = startRestartGroup.rememberedValue();
                    if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new DrawerKt$BottomDrawerScrim$dismissModifier$1$1(function0, null);
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    startRestartGroup.endReplaceableGroup();
                    Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(companion2, function0, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue);
                    startRestartGroup.startReplaceableGroup(463511674);
                    boolean changed = startRestartGroup.changed(m1780getString4foXLRw) | startRestartGroup.changedInstance(function0);
                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                    if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawerScrim$dismissModifier$2$1
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
                                SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$BottomDrawerScrim$dismissModifier$2$1.1
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
                startRestartGroup.startReplaceableGroup(463511963);
                boolean changed2 = startRestartGroup.changed(j) | startRestartGroup.changed(animateFloatAsState);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawerScrim$1$1
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
                            float BottomDrawerScrim_3J_VO9M$lambda$3;
                            long j2 = j;
                            BottomDrawerScrim_3J_VO9M$lambda$3 = DrawerKt.BottomDrawerScrim_3J_VO9M$lambda$3(animateFloatAsState);
                            DrawScope.m4607drawRectnJ9OG0$default(drawScope, j2, 0L, 0L, BottomDrawerScrim_3J_VO9M$lambda$3, null, null, 0, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, null);
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
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawerScrim$2
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
                    DrawerKt.m1651BottomDrawerScrim3JVO9M(j, function0, z, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Scrim-Bx497Mc, reason: not valid java name */
    public static final void m1653ScrimBx497Mc(final boolean z, final Function0<Unit> function0, final Function0<Float> function02, final long j, Composer composer, final int i) {
        int i2;
        Modifier.Companion companion;
        Composer startRestartGroup = composer.startRestartGroup(1983403750);
        ComposerKt.sourceInformation(startRestartGroup, "C(Scrim)P(3,2,1,0:c#ui.graphics.Color)828@30835L30,840@31188L142:Drawer.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changedInstance(function02) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= startRestartGroup.changed(j) ? 2048 : 1024;
        }
        if ((i2 & 5851) != 1170 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1983403750, i2, -1, "androidx.compose.material.Scrim (Drawer.kt:827)");
            }
            final String m1780getString4foXLRw = Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1773getCloseDrawerUdPEhr4(), startRestartGroup, 6);
            if (z) {
                Modifier.Companion companion2 = Modifier.INSTANCE;
                startRestartGroup.startReplaceableGroup(463512299);
                boolean changedInstance = startRestartGroup.changedInstance(function0);
                DrawerKt$Scrim$dismissDrawer$1$1 rememberedValue = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new DrawerKt$Scrim$dismissDrawer$1$1(function0, null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceableGroup();
                Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(companion2, function0, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue);
                startRestartGroup.startReplaceableGroup(463512383);
                boolean changed = startRestartGroup.changed(m1780getString4foXLRw) | startRestartGroup.changedInstance(function0);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$Scrim$dismissDrawer$2$1
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
                            final Function0<Unit> function03 = function0;
                            SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$Scrim$dismissDrawer$2$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    function03.invoke();
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
            startRestartGroup.startReplaceableGroup(463512624);
            boolean changed2 = startRestartGroup.changed(j) | startRestartGroup.changedInstance(function02);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.DrawerKt$Scrim$1$1
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
                        DrawScope.m4607drawRectnJ9OG0$default(drawScope, j, 0L, 0L, function02.invoke().floatValue(), null, null, 0, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, null);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(then, (Function1) rememberedValue3, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$Scrim$2
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
                    DrawerKt.m1653ScrimBx497Mc(z, function0, function02, j, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(AnchoredDraggableState<?> anchoredDraggableState) {
        return new DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1(anchoredDraggableState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float BottomDrawerScrim_3J_VO9M$lambda$3(State<Float> state) {
        return state.getValue().floatValue();
    }

    static {
        float f = 56;
        EndDrawerPadding = Dp.m6389constructorimpl(f);
        DrawerPositionalThreshold = Dp.m6389constructorimpl(f);
    }
}
