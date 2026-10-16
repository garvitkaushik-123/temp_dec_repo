package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
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
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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

/* compiled from: BottomSheetScaffold.kt */
@Metadata(d1 = {"\u0000Â\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0093\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2'\u0010\r\u001a#\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0002\b\u001f¢\u0006\u0002\b H\u0003ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001aÞ\u0002\u0010#\u001a\u00020\b2\u001c\u0010$\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0002\b\u001f¢\u0006\u0002\b 2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010%\u001a\u00020&2\u0015\b\u0002\u0010'\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010(¢\u0006\u0002\b\u001f2\u0019\b\u0002\u0010)\u001a\u0013\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0002\b\u001f2\u0015\b\u0002\u0010+\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010(¢\u0006\u0002\b\u001f2\b\b\u0002\u0010,\u001a\u00020-2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010.\u001a\u00020\u00012 \b\u0002\u0010/\u001a\u001a\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\b\u0018\u00010\u000e¢\u0006\u0002\b\u001f¢\u0006\u0002\b 2\b\b\u0002\u00100\u001a\u00020\f2\b\b\u0002\u00101\u001a\u00020\u00162\b\b\u0002\u00102\u001a\u00020\u00012\b\b\u0002\u00103\u001a\u00020\u00192\b\b\u0002\u00104\u001a\u00020\u00192\b\b\u0002\u00105\u001a\u00020\u00192\b\b\u0002\u00106\u001a\u00020\u00192\b\b\u0002\u00107\u001a\u00020\u00192\u0017\u0010\u001d\u001a\u0013\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0002\b\u001fH\u0007ø\u0001\u0000¢\u0006\u0004\b9\u0010:\u001a\u0080\u0002\u0010#\u001a\u00020\b2\u001c\u0010$\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0002\b\u001f¢\u0006\u0002\b 2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010%\u001a\u00020&2\u0015\b\u0002\u0010'\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010(¢\u0006\u0002\b\u001f2\u0019\b\u0002\u0010)\u001a\u0013\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0002\b\u001f2\u0015\b\u0002\u0010+\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010(¢\u0006\u0002\b\u001f2\b\b\u0002\u0010,\u001a\u00020-2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010.\u001a\u00020\u00012\b\b\u0002\u00106\u001a\u00020\u00192\b\b\u0002\u00107\u001a\u00020\u00192\u0017\u0010\u001d\u001a\u0013\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0002\b\u001fH\u0007ø\u0001\u0000¢\u0006\u0004\b;\u0010<\u001aÅ\u0001\u0010=\u001a\u00020\b2\u0013\u0010'\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010(¢\u0006\u0002\b\u001f2&\u0010>\u001a\"\u0012\u0013\u0012\u001108¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0002\b\u001f2&\u0010@\u001a\"\u0012\u0013\u0012\u00110A¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0002\b\u001f2\u0013\u0010+\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010(¢\u0006\u0002\b\u001f2\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\b0(¢\u0006\u0002\b\u001f2\u0006\u0010.\u001a\u00020\u00012\u0006\u0010,\u001a\u00020-2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020D0(2\u0006\u0010E\u001a\u00020\nH\u0003ø\u0001\u0000¢\u0006\u0004\bF\u0010G\u001a4\u0010H\u001a\u00020\n2\u0006\u0010I\u001a\u00020\u00142\u000e\b\u0002\u0010J\u001a\b\u0012\u0004\u0012\u00020D0K2\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\f0\u000eH\u0007\u001a \u0010H\u001a\u00020&2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\n2\u0006\u0010P\u001a\u00020*H\u0007\u001a>\u0010Q\u001a\u00020\n2\u0006\u0010I\u001a\u00020\u00142\u0006\u0010R\u001a\u00020S2\u000e\b\u0002\u0010J\u001a\b\u0012\u0004\u0012\u00020D0K2\u0014\b\u0002\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\f0\u000eH\u0007\u001a\u001c\u0010U\u001a\u00020V2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030W2\u0006\u0010X\u001a\u00020YH\u0002\u001a!\u0010Z\u001a\u00020&2\b\b\u0002\u0010O\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020*H\u0007¢\u0006\u0002\u0010[\u001a+\u0010Z\u001a\u00020&2\b\b\u0002\u0010M\u001a\u00020N2\b\b\u0002\u0010O\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020*H\u0007¢\u0006\u0002\u0010\\\u001a;\u0010]\u001a\u00020\n2\u0006\u0010I\u001a\u00020\u00142\u000e\b\u0002\u0010J\u001a\b\u0012\u0004\u0012\u00020D0K2\u0014\b\u0002\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\f0\u000eH\u0007¢\u0006\u0002\u0010^\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006_"}, d2 = {"BottomSheetScaffoldPositionalThreshold", "Landroidx/compose/ui/unit/Dp;", "F", "BottomSheetScaffoldVelocityThreshold", "BottomSheetScaffoldWithDrawerDeprecated", "", "FabSpacing", "BottomSheet", "", "state", "Landroidx/compose/material/BottomSheetState;", "sheetGesturesEnabled", "", "calculateAnchors", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/IntSize;", "Lkotlin/ParameterName;", "name", "sheetSize", "Landroidx/compose/material/DraggableAnchors;", "Landroidx/compose/material/BottomSheetValue;", "sheetShape", "Landroidx/compose/ui/graphics/Shape;", "sheetElevation", "sheetBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "sheetContentColor", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "BottomSheet-0cLKjW4", "(Landroidx/compose/material/BottomSheetState;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/Shape;FJJLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomSheetScaffold", "sheetContent", "scaffoldState", "Landroidx/compose/material/BottomSheetScaffoldState;", "topBar", "Lkotlin/Function0;", "snackbarHost", "Landroidx/compose/material/SnackbarHostState;", "floatingActionButton", "floatingActionButtonPosition", "Landroidx/compose/material/FabPosition;", "sheetPeekHeight", "drawerContent", "drawerGesturesEnabled", "drawerShape", "drawerElevation", "drawerBackgroundColor", "drawerContentColor", "drawerScrimColor", "backgroundColor", "contentColor", "Landroidx/compose/foundation/layout/PaddingValues;", "BottomSheetScaffold-bGncdBI", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BottomSheetScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLandroidx/compose/ui/graphics/Shape;FJJFLkotlin/jvm/functions/Function3;ZLandroidx/compose/ui/graphics/Shape;FJJJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;IIII)V", "BottomSheetScaffold-HnlDQGw", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BottomSheetScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLandroidx/compose/ui/graphics/Shape;FJJFJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "BottomSheetScaffoldLayout", "body", "innerPadding", "bottomSheet", "", "layoutHeight", "sheetOffset", "", "sheetState", "BottomSheetScaffoldLayout-KCBPh4w", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;FILkotlin/jvm/functions/Function0;Landroidx/compose/material/BottomSheetState;Landroidx/compose/runtime/Composer;I)V", "BottomSheetScaffoldState", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmStateChange", "drawerState", "Landroidx/compose/material/DrawerState;", "bottomSheetState", "snackbarHostState", "BottomSheetState", "density", "Landroidx/compose/ui/unit/Density;", "confirmValueChange", "ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroidx/compose/material/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "rememberBottomSheetScaffoldState", "(Landroidx/compose/material/BottomSheetState;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomSheetScaffoldState;", "(Landroidx/compose/material/DrawerState;Landroidx/compose/material/BottomSheetState;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomSheetScaffoldState;", "rememberBottomSheetState", "(Landroidx/compose/material/BottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomSheetState;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BottomSheetScaffoldKt {
    private static final String BottomSheetScaffoldWithDrawerDeprecated = "BottomSheetScaffold with a drawer has been deprecated. To achieve the same functionality, wrap your BottomSheetScaffold in aModalDrawer. See BottomSheetScaffoldWithDrawerSample for more details.";
    private static final float FabSpacing = Dp.m6389constructorimpl(16);
    private static final float BottomSheetScaffoldPositionalThreshold = Dp.m6389constructorimpl(56);
    private static final float BottomSheetScaffoldVelocityThreshold = Dp.m6389constructorimpl(Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE);

    public static /* synthetic */ BottomSheetState BottomSheetScaffoldState$default(BottomSheetValue bottomSheetValue, AnimationSpec animationSpec, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = AnchoredDraggableDefaults.INSTANCE.getAnimationSpec();
        }
        return BottomSheetScaffoldState(bottomSheetValue, (AnimationSpec<Float>) animationSpec, (Function1<? super BottomSheetValue, Boolean>) function1);
    }

    @Deprecated(message = "This constructor is deprecated. confirmStateChange has been renamed to confirmValueChange.", replaceWith = @ReplaceWith(expression = "BottomSheetScaffoldState(initialValue, animationSpec, confirmStateChange)", imports = {}))
    public static final BottomSheetState BottomSheetScaffoldState(BottomSheetValue bottomSheetValue, AnimationSpec<Float> animationSpec, Function1<? super BottomSheetValue, Boolean> function1) {
        return new BottomSheetState(bottomSheetValue, animationSpec, function1);
    }

    public static /* synthetic */ BottomSheetState BottomSheetState$default(BottomSheetValue bottomSheetValue, Density density, AnimationSpec animationSpec, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            animationSpec = AnchoredDraggableDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i & 8) != 0) {
            function1 = new Function1<BottomSheetValue, Boolean>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetState$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(BottomSheetValue bottomSheetValue2) {
                    return true;
                }
            };
        }
        return BottomSheetState(bottomSheetValue, density, animationSpec, function1);
    }

    public static final BottomSheetState BottomSheetState(BottomSheetValue bottomSheetValue, Density density, AnimationSpec<Float> animationSpec, Function1<? super BottomSheetValue, Boolean> function1) {
        BottomSheetState bottomSheetState = new BottomSheetState(bottomSheetValue, animationSpec, function1);
        bottomSheetState.setDensity$material_release(density);
        return bottomSheetState;
    }

    public static final BottomSheetState rememberBottomSheetState(final BottomSheetValue bottomSheetValue, final AnimationSpec<Float> animationSpec, final Function1<? super BottomSheetValue, Boolean> function1, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1808153344);
        ComposerKt.sourceInformation(composer, "C(rememberBottomSheetState)P(2)306@11010L7,307@11029L433:BottomSheetScaffold.kt#jmzs0o");
        if ((i2 & 2) != 0) {
            animationSpec = AnchoredDraggableDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i2 & 4) != 0) {
            function1 = new Function1<BottomSheetValue, Boolean>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$rememberBottomSheetState$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(BottomSheetValue bottomSheetValue2) {
                    return true;
                }
            };
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1808153344, i, -1, "androidx.compose.material.rememberBottomSheetState (BottomSheetScaffold.kt:305)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final Density density = (Density) consume;
        BottomSheetState bottomSheetState = (BottomSheetState) RememberSaveableKt.m3680rememberSaveable(new Object[]{animationSpec}, (Saver) BottomSheetState.INSTANCE.Saver(animationSpec, function1, density), (String) null, (Function0) new Function0<BottomSheetState>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$rememberBottomSheetState$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BottomSheetState invoke() {
                return BottomSheetScaffoldKt.BottomSheetState(BottomSheetValue.this, density, animationSpec, function1);
            }
        }, composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return bottomSheetState;
    }

    public static final BottomSheetScaffoldState rememberBottomSheetScaffoldState(BottomSheetState bottomSheetState, SnackbarHostState snackbarHostState, Composer composer, int i, int i2) {
        Composer composer2;
        composer.startReplaceableGroup(-1022285988);
        ComposerKt.sourceInformation(composer, "C(rememberBottomSheetScaffoldState)346@12196L35,347@12276L32,349@12350L196:BottomSheetScaffold.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            composer2 = composer;
            bottomSheetState = rememberBottomSheetState(BottomSheetValue.Collapsed, null, null, composer2, 6, 6);
        } else {
            composer2 = composer;
        }
        if ((i2 & 2) != 0) {
            composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer2, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue = composer2.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new SnackbarHostState();
                composer2.updateRememberedValue(rememberedValue);
            }
            composer2.endReplaceableGroup();
            snackbarHostState = (SnackbarHostState) rememberedValue;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1022285988, i, -1, "androidx.compose.material.rememberBottomSheetScaffoldState (BottomSheetScaffold.kt:348)");
        }
        composer2.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation(composer2, "CC(remember)P(1,2):Composables.kt#9igjgp");
        boolean changed = composer2.changed(bottomSheetState) | composer2.changed(snackbarHostState);
        Object rememberedValue2 = composer2.rememberedValue();
        if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new BottomSheetScaffoldState(bottomSheetState, snackbarHostState);
            composer2.updateRememberedValue(rememberedValue2);
        }
        composer2.endReplaceableGroup();
        BottomSheetScaffoldState bottomSheetScaffoldState = (BottomSheetScaffoldState) rememberedValue2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer2.endReplaceableGroup();
        return bottomSheetScaffoldState;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = BottomSheetScaffoldWithDrawerDeprecated)
    public static final BottomSheetScaffoldState BottomSheetScaffoldState(DrawerState drawerState, BottomSheetState bottomSheetState, SnackbarHostState snackbarHostState) {
        throw new IllegalStateException(BottomSheetScaffoldWithDrawerDeprecated.toString());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = BottomSheetScaffoldWithDrawerDeprecated)
    public static final BottomSheetScaffoldState rememberBottomSheetScaffoldState(DrawerState drawerState, BottomSheetState bottomSheetState, SnackbarHostState snackbarHostState, Composer composer, int i, int i2) {
        Composer composer2;
        composer.startReplaceableGroup(-1353009744);
        ComposerKt.sourceInformation(composer, "C(rememberBottomSheetScaffoldState)P(1)385@13723L39,386@13805L35,387@13885L32:BottomSheetScaffold.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            DrawerKt.rememberDrawerState(DrawerValue.Closed, null, composer, 6, 2);
        }
        if ((i2 & 2) != 0) {
            composer2 = composer;
            rememberBottomSheetState(BottomSheetValue.Collapsed, null, null, composer2, 6, 6);
        } else {
            composer2 = composer;
        }
        if ((i2 & 4) != 0) {
            composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer2, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue = composer2.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new SnackbarHostState();
                composer2.updateRememberedValue(rememberedValue);
            }
            composer2.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1353009744, i, -1, "androidx.compose.material.rememberBottomSheetScaffoldState (BottomSheetScaffold.kt:388)");
        }
        throw new IllegalStateException(BottomSheetScaffoldWithDrawerDeprecated.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x01b9, code lost:
    
        if (r4.changed(r52) == false) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01d3, code lost:
    
        if (r4.changed(r54) == false) goto L158;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x043f  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0458  */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0239  */
    /* renamed from: BottomSheetScaffold-HnlDQGw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1560BottomSheetScaffoldHnlDQGw(final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, BottomSheetScaffoldState bottomSheetScaffoldState, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function32, Function2<? super Composer, ? super Integer, Unit> function22, int i, boolean z, Shape shape, float f, long j, long j2, float f2, long j3, long j4, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function33, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        Modifier modifier2;
        final BottomSheetScaffoldState bottomSheetScaffoldState2;
        int i6;
        int i7;
        Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function34;
        int i8;
        Function2<? super Composer, ? super Integer, Unit> function23;
        int i9;
        int i10;
        int i11;
        boolean z2;
        int i12;
        int i13;
        int i14;
        long j5;
        int i15;
        int i16;
        int m1680getEnd5ygKITE;
        CornerBasedShape cornerBasedShape;
        float m1557getSheetElevationD9Ej5fM;
        boolean z3;
        long j6;
        float f3;
        int i17;
        long j7;
        int i18;
        long j8;
        long j9;
        long j10;
        long j11;
        Function2<? super Composer, ? super Integer, Unit> function24;
        float f4;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        boolean changed;
        Object rememberedValue;
        long j12;
        Composer composer2;
        final boolean z4;
        long j13;
        long j14;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final float f5;
        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function35;
        final int i19;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final Shape shape2;
        final BottomSheetScaffoldState bottomSheetScaffoldState3;
        final float f6;
        final long j15;
        ScopeUpdateScope endRestartGroup;
        int i20;
        int i21;
        Composer startRestartGroup = composer.startRestartGroup(-423121424);
        ComposerKt.sourceInformation(startRestartGroup, "C(BottomSheetScaffold)P(8,5,6,15,14,3,4:c#material.FabPosition,11,13,10:c#ui.unit.Dp,7:c#ui.graphics.Color,9:c#ui.graphics.Color,12:c#ui.unit.Dp,0:c#ui.graphics.Color,2:c#ui.graphics.Color)438@17024L34,444@17393L6,446@17524L6,447@17571L37,449@17724L6,450@17769L32,454@17970L7,455@17982L75,*459@18100L7,460@18140L2377:BottomSheetScaffold.kt#jmzs0o");
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i5 = (startRestartGroup.changedInstance(function3) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        int i22 = i4 & 2;
        if (i22 != 0) {
            i5 |= 48;
        } else if ((i2 & 112) == 0) {
            modifier2 = modifier;
            i5 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i2 & 896) != 0) {
                if ((i4 & 4) == 0) {
                    bottomSheetScaffoldState2 = bottomSheetScaffoldState;
                    if (startRestartGroup.changed(bottomSheetScaffoldState2)) {
                        i21 = 256;
                        i5 |= i21;
                    }
                } else {
                    bottomSheetScaffoldState2 = bottomSheetScaffoldState;
                }
                i21 = 128;
                i5 |= i21;
            } else {
                bottomSheetScaffoldState2 = bottomSheetScaffoldState;
            }
            i6 = i4 & 8;
            int i23 = 2048;
            if (i6 == 0) {
                i5 |= 3072;
            } else if ((i2 & 7168) == 0) {
                i5 |= startRestartGroup.changedInstance(function2) ? 2048 : 1024;
                i7 = i4 & 16;
                int i24 = 16384;
                if (i7 != 0) {
                    i5 |= 24576;
                    function34 = function32;
                } else {
                    function34 = function32;
                    if ((i2 & 57344) == 0) {
                        i5 |= startRestartGroup.changedInstance(function34) ? 16384 : 8192;
                    }
                }
                i8 = i4 & 32;
                if (i8 != 0) {
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    function23 = function22;
                } else {
                    function23 = function22;
                    if ((i2 & 458752) == 0) {
                        i5 |= startRestartGroup.changedInstance(function23) ? 131072 : 65536;
                    }
                }
                i9 = i4 & 64;
                if (i9 != 0) {
                    i5 |= 1572864;
                    i10 = i;
                } else {
                    i10 = i;
                    if ((i2 & 3670016) == 0) {
                        i5 |= startRestartGroup.changed(i10) ? 1048576 : 524288;
                    }
                }
                i11 = i4 & 128;
                if (i11 != 0) {
                    i5 |= 12582912;
                    z2 = z;
                } else {
                    z2 = z;
                    if ((i2 & 29360128) == 0) {
                        i5 |= startRestartGroup.changed(z2) ? 8388608 : 4194304;
                    }
                }
                if ((i2 & 234881024) == 0) {
                    if ((i4 & 256) == 0 && startRestartGroup.changed(shape)) {
                        i20 = 67108864;
                        i5 |= i20;
                    }
                    i20 = 33554432;
                    i5 |= i20;
                }
                i12 = i4 & 512;
                if (i12 != 0) {
                    i5 |= C.ENCODING_PCM_32BIT;
                } else if ((i2 & 1879048192) == 0) {
                    i13 = i12;
                    i5 |= startRestartGroup.changed(f) ? 536870912 : 268435456;
                    if ((i3 & 14) != 0) {
                        i14 = i3 | (((i4 & 1024) == 0 && startRestartGroup.changed(j)) ? 4 : 2);
                    } else {
                        i14 = i3;
                    }
                    if ((i3 & 112) != 0) {
                        j5 = j2;
                        i14 |= ((i4 & 2048) == 0 && startRestartGroup.changed(j5)) ? 32 : 16;
                    } else {
                        j5 = j2;
                    }
                    i15 = i4 & 4096;
                    if (i15 == 0) {
                        i16 = i14 | 384;
                    } else {
                        i16 = i14;
                        if ((i3 & 896) == 0) {
                            i16 |= startRestartGroup.changed(f2) ? 256 : 128;
                            if ((i3 & 7168) == 0) {
                                if ((i4 & 8192) != 0) {
                                }
                                i23 = 1024;
                                i16 |= i23;
                            }
                            if ((i3 & 57344) == 0) {
                                if ((i4 & 16384) != 0) {
                                }
                                i24 = 8192;
                                i16 |= i24;
                            }
                            if ((i4 & 32768) != 0) {
                                i16 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                            } else if ((i3 & 458752) == 0) {
                                i16 |= startRestartGroup.changedInstance(function33) ? 131072 : 65536;
                            }
                            if ((1533916891 & i5) == 306783378 || (i16 & 374491) != 74898 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    if (i22 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if ((i4 & 4) != 0) {
                                        i5 &= -897;
                                        bottomSheetScaffoldState2 = rememberBottomSheetScaffoldState(null, null, startRestartGroup, 0, 3);
                                    }
                                    Function2<? super Composer, ? super Integer, Unit> function28 = i6 != 0 ? null : function2;
                                    if (i7 != 0) {
                                        function34 = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1629getLambda1$material_release();
                                    }
                                    if (i8 != 0) {
                                        function23 = null;
                                    }
                                    m1680getEnd5ygKITE = i9 != 0 ? FabPosition.INSTANCE.m1680getEnd5ygKITE() : i10;
                                    if (i11 != 0) {
                                        z2 = true;
                                    }
                                    if ((i4 & 256) != 0) {
                                        cornerBasedShape = MaterialTheme.INSTANCE.getShapes(startRestartGroup, 6).getLarge();
                                        i5 &= -234881025;
                                    } else {
                                        cornerBasedShape = shape;
                                    }
                                    m1557getSheetElevationD9Ej5fM = i13 != 0 ? BottomSheetScaffoldDefaults.INSTANCE.m1557getSheetElevationD9Ej5fM() : f;
                                    if ((i4 & 1024) != 0) {
                                        i16 &= -15;
                                        z3 = z2;
                                        j6 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m1607getSurface0d7_KjU();
                                    } else {
                                        z3 = z2;
                                        j6 = j;
                                    }
                                    if ((i4 & 2048) != 0) {
                                        j5 = ColorsKt.m1621contentColorForek8zF_U(j6, startRestartGroup, i16 & 14);
                                        i16 &= -113;
                                    }
                                    int i25 = i16;
                                    float m1558getSheetPeekHeightD9Ej5fM = i15 != 0 ? BottomSheetScaffoldDefaults.INSTANCE.m1558getSheetPeekHeightD9Ej5fM() : f2;
                                    Function2<? super Composer, ? super Integer, Unit> function29 = function28;
                                    if ((i4 & 8192) != 0) {
                                        f3 = m1558getSheetPeekHeightD9Ej5fM;
                                        i17 = i25 & (-7169);
                                        j7 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m1596getBackground0d7_KjU();
                                    } else {
                                        f3 = m1558getSheetPeekHeightD9Ej5fM;
                                        i17 = i25;
                                        j7 = j3;
                                    }
                                    int i26 = i17;
                                    if ((i4 & 16384) != 0) {
                                        i18 = i26 & (-57345);
                                        j9 = j7;
                                        j8 = ColorsKt.m1621contentColorForek8zF_U(j7, startRestartGroup, (i26 >> 9) & 14);
                                        function24 = function29;
                                        f4 = f3;
                                        j10 = j5;
                                        j11 = j6;
                                        z2 = z3;
                                    } else {
                                        i18 = i26;
                                        j8 = j4;
                                        j9 = j7;
                                        j10 = j5;
                                        j11 = j6;
                                        z2 = z3;
                                        function24 = function29;
                                        f4 = f3;
                                    }
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i4 & 4) != 0) {
                                        i5 &= -897;
                                    }
                                    if ((i4 & 256) != 0) {
                                        i5 &= -234881025;
                                    }
                                    if ((i4 & 1024) != 0) {
                                        i16 &= -15;
                                    }
                                    if ((i4 & 2048) != 0) {
                                        i16 &= -113;
                                    }
                                    int i27 = i16;
                                    if ((i4 & 8192) != 0) {
                                        i27 &= -7169;
                                    }
                                    if ((i4 & 16384) != 0) {
                                        i27 &= -57345;
                                    }
                                    m1557getSheetElevationD9Ej5fM = f;
                                    f4 = f2;
                                    j9 = j3;
                                    j8 = j4;
                                    i18 = i27;
                                    j10 = j5;
                                    m1680getEnd5ygKITE = i10;
                                    function24 = function2;
                                    cornerBasedShape = shape;
                                    j11 = j;
                                }
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    function25 = function24;
                                    ComposerKt.traceEventStart(-423121424, i5, i18, "androidx.compose.material.BottomSheetScaffold (BottomSheetScaffold.kt:452)");
                                } else {
                                    function25 = function24;
                                }
                                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume = startRestartGroup.consume(localDensity);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                final Density density = (Density) consume;
                                startRestartGroup.startReplaceableGroup(1938007797);
                                changed = startRestartGroup.changed(bottomSheetScaffoldState2) | startRestartGroup.changed(density);
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$1
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
                                            BottomSheetScaffoldState.this.getBottomSheetState().setDensity$material_release(density);
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                startRestartGroup.endReplaceableGroup();
                                EffectsKt.SideEffect((Function0) rememberedValue, startRestartGroup, 0);
                                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume2 = startRestartGroup.consume(localDensity2);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                final float mo630toPx0680j_4 = ((Density) consume2).mo630toPx0680j_4(f4);
                                final float f7 = f4;
                                final long j16 = j11;
                                final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function36 = function34;
                                final int i28 = m1680getEnd5ygKITE;
                                final Function2<? super Composer, ? super Integer, Unit> function210 = function23;
                                final Shape shape3 = cornerBasedShape;
                                final BottomSheetScaffoldState bottomSheetScaffoldState4 = bottomSheetScaffoldState2;
                                final boolean z5 = z2;
                                final float f8 = m1557getSheetElevationD9Ej5fM;
                                final long j17 = j10;
                                Function2<? super Composer, ? super Integer, Unit> function211 = function25;
                                j12 = j16;
                                int i29 = i18 >> 3;
                                long j18 = j9;
                                long j19 = j8;
                                SurfaceKt.m1782SurfaceFjzlyU(SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null), null, j18, j19, null, 0.0f, ComposableLambdaKt.composableLambda(startRestartGroup, -131096268, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2
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

                                    public final void invoke(Composer composer3, int i30) {
                                        ComposerKt.sourceInformation(composer3, "C466@18279L2232:BottomSheetScaffold.kt#jmzs0o");
                                        if ((i30 & 11) != 2 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-131096268, i30, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:466)");
                                            }
                                            BottomSheetState bottomSheetState = BottomSheetScaffoldState.this.getBottomSheetState();
                                            Function2<Composer, Integer, Unit> function212 = function25;
                                            Function3<PaddingValues, Composer, Integer, Unit> function37 = function33;
                                            final boolean z6 = z5;
                                            final BottomSheetScaffoldState bottomSheetScaffoldState5 = BottomSheetScaffoldState.this;
                                            final float f9 = f7;
                                            final float f10 = mo630toPx0680j_4;
                                            final Shape shape4 = shape3;
                                            final float f11 = f8;
                                            final long j20 = j16;
                                            final long j21 = j17;
                                            final Function3<ColumnScope, Composer, Integer, Unit> function38 = function3;
                                            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer3, -1900337132, true, new Function3<Integer, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public /* bridge */ /* synthetic */ Unit invoke(Integer num, Composer composer4, Integer num2) {
                                                    invoke(num.intValue(), composer4, num2.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(final int i31, Composer composer4, int i32) {
                                                    int i33;
                                                    Modifier.Companion companion;
                                                    ComposerKt.sourceInformation(composer4, "C481@19031L1038:BottomSheetScaffold.kt#jmzs0o");
                                                    if ((i32 & 14) == 0) {
                                                        i33 = i32 | (composer4.changed(i31) ? 4 : 2);
                                                    } else {
                                                        i33 = i32;
                                                    }
                                                    if ((i33 & 91) != 18 || !composer4.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1900337132, i33, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous> (BottomSheetScaffold.kt:470)");
                                                        }
                                                        composer4.startReplaceableGroup(-816851224);
                                                        ComposerKt.sourceInformation(composer4, "473@18566L390");
                                                        if (z6) {
                                                            Modifier.Companion companion2 = Modifier.INSTANCE;
                                                            AnchoredDraggableState<BottomSheetValue> anchoredDraggableState$material_release = bottomSheetScaffoldState5.getBottomSheetState().getAnchoredDraggableState$material_release();
                                                            BottomSheetScaffoldState bottomSheetScaffoldState6 = bottomSheetScaffoldState5;
                                                            composer4.startReplaceableGroup(1157296644);
                                                            ComposerKt.sourceInformation(composer4, "CC(remember)P(1):Composables.kt#9igjgp");
                                                            boolean changed2 = composer4.changed(anchoredDraggableState$material_release);
                                                            Object rememberedValue2 = composer4.rememberedValue();
                                                            if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                                rememberedValue2 = BottomSheetScaffoldKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(bottomSheetScaffoldState6.getBottomSheetState().getAnchoredDraggableState$material_release(), Orientation.Vertical);
                                                                composer4.updateRememberedValue(rememberedValue2);
                                                            }
                                                            composer4.endReplaceableGroup();
                                                            companion = NestedScrollModifierKt.nestedScroll$default(companion2, (NestedScrollConnection) rememberedValue2, null, 2, null);
                                                        } else {
                                                            companion = Modifier.INSTANCE;
                                                        }
                                                        composer4.endReplaceableGroup();
                                                        BottomSheetState bottomSheetState2 = bottomSheetScaffoldState5.getBottomSheetState();
                                                        Modifier m919requiredHeightInVpY3zN4$default = SizeKt.m919requiredHeightInVpY3zN4$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), f9, 0.0f, 2, null);
                                                        boolean z7 = z6;
                                                        composer4.startReplaceableGroup(1938009097);
                                                        boolean changed3 = composer4.changed(i31) | composer4.changed(f10);
                                                        final float f12 = f10;
                                                        Object rememberedValue3 = composer4.rememberedValue();
                                                        if (changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                            rememberedValue3 = (Function1) new Function1<IntSize, DraggableAnchors<BottomSheetValue>>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2$1$1$1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public /* bridge */ /* synthetic */ DraggableAnchors<BottomSheetValue> invoke(IntSize intSize) {
                                                                    return m1566invokeozmzZPI(intSize.getPackedValue());
                                                                }

                                                                /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                                                                public final DraggableAnchors<BottomSheetValue> m1566invokeozmzZPI(long j22) {
                                                                    final float m6558getHeightimpl = IntSize.m6558getHeightimpl(j22);
                                                                    final int i34 = i31;
                                                                    final float f13 = f12;
                                                                    return AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<BottomSheetValue>, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2$1$1$1.1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<BottomSheetValue> draggableAnchorsConfig) {
                                                                            invoke2(draggableAnchorsConfig);
                                                                            return Unit.INSTANCE;
                                                                        }

                                                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                        public final void invoke2(DraggableAnchorsConfig<BottomSheetValue> draggableAnchorsConfig) {
                                                                            draggableAnchorsConfig.at(BottomSheetValue.Collapsed, i34 - f13);
                                                                            float f14 = m6558getHeightimpl;
                                                                            if (f14 <= 0.0f || f14 == f13) {
                                                                                return;
                                                                            }
                                                                            draggableAnchorsConfig.at(BottomSheetValue.Expanded, i34 - m6558getHeightimpl);
                                                                        }
                                                                    });
                                                                }
                                                            };
                                                            composer4.updateRememberedValue(rememberedValue3);
                                                        }
                                                        composer4.endReplaceableGroup();
                                                        BottomSheetScaffoldKt.m1559BottomSheet0cLKjW4(bottomSheetState2, z7, (Function1) rememberedValue3, shape4, f11, j20, j21, m919requiredHeightInVpY3zN4$default, function38, composer4, 0, 0);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer4.skipToGroupEnd();
                                                }
                                            });
                                            Function2<Composer, Integer, Unit> function213 = function210;
                                            final Function3<SnackbarHostState, Composer, Integer, Unit> function39 = function36;
                                            final BottomSheetScaffoldState bottomSheetScaffoldState6 = BottomSheetScaffoldState.this;
                                            ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composer3, -1011922215, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2.2
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

                                                public final void invoke(Composer composer4, int i31) {
                                                    ComposerKt.sourceInformation(composer4, "C505@20187L45:BottomSheetScaffold.kt#jmzs0o");
                                                    if ((i31 & 11) == 2 && composer4.getSkipping()) {
                                                        composer4.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1011922215, i31, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous> (BottomSheetScaffold.kt:505)");
                                                    }
                                                    function39.invoke(bottomSheetScaffoldState6.getSnackbarHostState(), composer4, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            });
                                            float f12 = f7;
                                            int i31 = i28;
                                            composer3.startReplaceableGroup(1938010078);
                                            boolean changed2 = composer3.changed(BottomSheetScaffoldState.this);
                                            final BottomSheetScaffoldState bottomSheetScaffoldState7 = BottomSheetScaffoldState.this;
                                            Object rememberedValue2 = composer3.rememberedValue();
                                            if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue2 = (Function0) new Function0<Float>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2$3$1
                                                    {
                                                        super(0);
                                                    }

                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Float invoke() {
                                                        return Float.valueOf(BottomSheetScaffoldState.this.getBottomSheetState().requireOffset());
                                                    }
                                                };
                                                composer3.updateRememberedValue(rememberedValue2);
                                            }
                                            composer3.endReplaceableGroup();
                                            BottomSheetScaffoldKt.m1562BottomSheetScaffoldLayoutKCBPh4w(function212, function37, composableLambda, function213, composableLambda2, f12, i31, (Function0) rememberedValue2, bottomSheetState, composer3, 24960);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }), startRestartGroup, (i29 & 7168) | (i29 & 896) | 1572864, 50);
                                composer2 = startRestartGroup;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                z4 = z2;
                                j13 = j19;
                                j14 = j18;
                                function26 = function211;
                                f5 = f7;
                                function35 = function34;
                                i19 = m1680getEnd5ygKITE;
                                function27 = function23;
                                shape2 = cornerBasedShape;
                                bottomSheetScaffoldState3 = bottomSheetScaffoldState2;
                                f6 = m1557getSheetElevationD9Ej5fM;
                                j15 = j17;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                shape2 = shape;
                                j12 = j;
                                j14 = j3;
                                j13 = j4;
                                composer2 = startRestartGroup;
                                bottomSheetScaffoldState3 = bottomSheetScaffoldState2;
                                z4 = z2;
                                function26 = function2;
                                f5 = f2;
                                j15 = j5;
                                function35 = function34;
                                function27 = function23;
                                i19 = i10;
                                f6 = f;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup != null) {
                                final Modifier modifier3 = modifier2;
                                final long j20 = j12;
                                final long j21 = j14;
                                final long j22 = j13;
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$3
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

                                    public final void invoke(Composer composer3, int i30) {
                                        BottomSheetScaffoldKt.m1560BottomSheetScaffoldHnlDQGw(function3, modifier3, bottomSheetScaffoldState3, function26, function35, function27, i19, z4, shape2, f6, j20, j15, f5, j21, j22, function33, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                    }
                    if ((i3 & 7168) == 0) {
                    }
                    if ((i3 & 57344) == 0) {
                    }
                    if ((i4 & 32768) != 0) {
                    }
                    if ((1533916891 & i5) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                    }
                    if (i22 != 0) {
                    }
                    if ((i4 & 4) != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if ((i4 & 256) != 0) {
                    }
                    if (i13 != 0) {
                    }
                    if ((i4 & 1024) != 0) {
                    }
                    if ((i4 & 2048) != 0) {
                    }
                    int i252 = i16;
                    if (i15 != 0) {
                    }
                    Function2<? super Composer, ? super Integer, Unit> function292 = function28;
                    if ((i4 & 8192) != 0) {
                    }
                    int i262 = i17;
                    if ((i4 & 16384) != 0) {
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume3 = startRestartGroup.consume(localDensity3);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    final Density density2 = (Density) consume3;
                    startRestartGroup.startReplaceableGroup(1938007797);
                    changed = startRestartGroup.changed(bottomSheetScaffoldState2) | startRestartGroup.changed(density2);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$1
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
                            BottomSheetScaffoldState.this.getBottomSheetState().setDensity$material_release(density2);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    startRestartGroup.endReplaceableGroup();
                    EffectsKt.SideEffect((Function0) rememberedValue, startRestartGroup, 0);
                    ProvidableCompositionLocal<Density> localDensity22 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume22 = startRestartGroup.consume(localDensity22);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    final float mo630toPx0680j_42 = ((Density) consume22).mo630toPx0680j_4(f4);
                    final float f72 = f4;
                    final long j162 = j11;
                    final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function362 = function34;
                    final int i282 = m1680getEnd5ygKITE;
                    final Function2<? super Composer, ? super Integer, Unit> function2102 = function23;
                    final Shape shape32 = cornerBasedShape;
                    final BottomSheetScaffoldState bottomSheetScaffoldState42 = bottomSheetScaffoldState2;
                    final boolean z52 = z2;
                    final float f82 = m1557getSheetElevationD9Ej5fM;
                    final long j172 = j10;
                    Function2<? super Composer, ? super Integer, Unit> function2112 = function25;
                    j12 = j162;
                    int i292 = i18 >> 3;
                    long j182 = j9;
                    long j192 = j8;
                    SurfaceKt.m1782SurfaceFjzlyU(SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null), null, j182, j192, null, 0.0f, ComposableLambdaKt.composableLambda(startRestartGroup, -131096268, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2
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

                        public final void invoke(Composer composer3, int i30) {
                            ComposerKt.sourceInformation(composer3, "C466@18279L2232:BottomSheetScaffold.kt#jmzs0o");
                            if ((i30 & 11) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-131096268, i30, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:466)");
                                }
                                BottomSheetState bottomSheetState = BottomSheetScaffoldState.this.getBottomSheetState();
                                Function2<Composer, Integer, Unit> function212 = function25;
                                Function3<PaddingValues, Composer, Integer, Unit> function37 = function33;
                                final boolean z6 = z52;
                                final BottomSheetScaffoldState bottomSheetScaffoldState5 = BottomSheetScaffoldState.this;
                                final float f9 = f72;
                                final float f10 = mo630toPx0680j_42;
                                final Shape shape4 = shape32;
                                final float f11 = f82;
                                final long j202 = j162;
                                final long j212 = j172;
                                final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function38 = function3;
                                ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer3, -1900337132, true, new Function3<Integer, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Composer composer4, Integer num2) {
                                        invoke(num.intValue(), composer4, num2.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(final int i31, Composer composer4, int i32) {
                                        int i33;
                                        Modifier.Companion companion;
                                        ComposerKt.sourceInformation(composer4, "C481@19031L1038:BottomSheetScaffold.kt#jmzs0o");
                                        if ((i32 & 14) == 0) {
                                            i33 = i32 | (composer4.changed(i31) ? 4 : 2);
                                        } else {
                                            i33 = i32;
                                        }
                                        if ((i33 & 91) != 18 || !composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1900337132, i33, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous> (BottomSheetScaffold.kt:470)");
                                            }
                                            composer4.startReplaceableGroup(-816851224);
                                            ComposerKt.sourceInformation(composer4, "473@18566L390");
                                            if (z6) {
                                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                                AnchoredDraggableState<BottomSheetValue> anchoredDraggableState$material_release = bottomSheetScaffoldState5.getBottomSheetState().getAnchoredDraggableState$material_release();
                                                BottomSheetScaffoldState bottomSheetScaffoldState6 = bottomSheetScaffoldState5;
                                                composer4.startReplaceableGroup(1157296644);
                                                ComposerKt.sourceInformation(composer4, "CC(remember)P(1):Composables.kt#9igjgp");
                                                boolean changed2 = composer4.changed(anchoredDraggableState$material_release);
                                                Object rememberedValue2 = composer4.rememberedValue();
                                                if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue2 = BottomSheetScaffoldKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(bottomSheetScaffoldState6.getBottomSheetState().getAnchoredDraggableState$material_release(), Orientation.Vertical);
                                                    composer4.updateRememberedValue(rememberedValue2);
                                                }
                                                composer4.endReplaceableGroup();
                                                companion = NestedScrollModifierKt.nestedScroll$default(companion2, (NestedScrollConnection) rememberedValue2, null, 2, null);
                                            } else {
                                                companion = Modifier.INSTANCE;
                                            }
                                            composer4.endReplaceableGroup();
                                            BottomSheetState bottomSheetState2 = bottomSheetScaffoldState5.getBottomSheetState();
                                            Modifier m919requiredHeightInVpY3zN4$default = SizeKt.m919requiredHeightInVpY3zN4$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), f9, 0.0f, 2, null);
                                            boolean z7 = z6;
                                            composer4.startReplaceableGroup(1938009097);
                                            boolean changed3 = composer4.changed(i31) | composer4.changed(f10);
                                            final float f12 = f10;
                                            Object rememberedValue3 = composer4.rememberedValue();
                                            if (changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue3 = (Function1) new Function1<IntSize, DraggableAnchors<BottomSheetValue>>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2$1$1$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ DraggableAnchors<BottomSheetValue> invoke(IntSize intSize) {
                                                        return m1566invokeozmzZPI(intSize.getPackedValue());
                                                    }

                                                    /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                                                    public final DraggableAnchors<BottomSheetValue> m1566invokeozmzZPI(long j222) {
                                                        final float m6558getHeightimpl = IntSize.m6558getHeightimpl(j222);
                                                        final int i34 = i31;
                                                        final float f13 = f12;
                                                        return AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<BottomSheetValue>, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2$1$1$1.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<BottomSheetValue> draggableAnchorsConfig) {
                                                                invoke2(draggableAnchorsConfig);
                                                                return Unit.INSTANCE;
                                                            }

                                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                            public final void invoke2(DraggableAnchorsConfig<BottomSheetValue> draggableAnchorsConfig) {
                                                                draggableAnchorsConfig.at(BottomSheetValue.Collapsed, i34 - f13);
                                                                float f14 = m6558getHeightimpl;
                                                                if (f14 <= 0.0f || f14 == f13) {
                                                                    return;
                                                                }
                                                                draggableAnchorsConfig.at(BottomSheetValue.Expanded, i34 - m6558getHeightimpl);
                                                            }
                                                        });
                                                    }
                                                };
                                                composer4.updateRememberedValue(rememberedValue3);
                                            }
                                            composer4.endReplaceableGroup();
                                            BottomSheetScaffoldKt.m1559BottomSheet0cLKjW4(bottomSheetState2, z7, (Function1) rememberedValue3, shape4, f11, j202, j212, m919requiredHeightInVpY3zN4$default, function38, composer4, 0, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                });
                                Function2<Composer, Integer, Unit> function213 = function2102;
                                final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function39 = function362;
                                final BottomSheetScaffoldState bottomSheetScaffoldState6 = BottomSheetScaffoldState.this;
                                ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composer3, -1011922215, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2.2
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

                                    public final void invoke(Composer composer4, int i31) {
                                        ComposerKt.sourceInformation(composer4, "C505@20187L45:BottomSheetScaffold.kt#jmzs0o");
                                        if ((i31 & 11) == 2 && composer4.getSkipping()) {
                                            composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1011922215, i31, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous> (BottomSheetScaffold.kt:505)");
                                        }
                                        function39.invoke(bottomSheetScaffoldState6.getSnackbarHostState(), composer4, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                });
                                float f12 = f72;
                                int i31 = i282;
                                composer3.startReplaceableGroup(1938010078);
                                boolean changed2 = composer3.changed(BottomSheetScaffoldState.this);
                                final BottomSheetScaffoldState bottomSheetScaffoldState7 = BottomSheetScaffoldState.this;
                                Object rememberedValue2 = composer3.rememberedValue();
                                if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue2 = (Function0) new Function0<Float>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2$3$1
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Float invoke() {
                                            return Float.valueOf(BottomSheetScaffoldState.this.getBottomSheetState().requireOffset());
                                        }
                                    };
                                    composer3.updateRememberedValue(rememberedValue2);
                                }
                                composer3.endReplaceableGroup();
                                BottomSheetScaffoldKt.m1562BottomSheetScaffoldLayoutKCBPh4w(function212, function37, composableLambda, function213, composableLambda2, f12, i31, (Function0) rememberedValue2, bottomSheetState, composer3, 24960);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), startRestartGroup, (i292 & 7168) | (i292 & 896) | 1572864, 50);
                    composer2 = startRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    z4 = z2;
                    j13 = j192;
                    j14 = j182;
                    function26 = function2112;
                    f5 = f72;
                    function35 = function34;
                    i19 = m1680getEnd5ygKITE;
                    function27 = function23;
                    shape2 = cornerBasedShape;
                    bottomSheetScaffoldState3 = bottomSheetScaffoldState2;
                    f6 = m1557getSheetElevationD9Ej5fM;
                    j15 = j172;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i13 = i12;
                if ((i3 & 14) != 0) {
                }
                if ((i3 & 112) != 0) {
                }
                i15 = i4 & 4096;
                if (i15 == 0) {
                }
                if ((i3 & 7168) == 0) {
                }
                if ((i3 & 57344) == 0) {
                }
                if ((i4 & 32768) != 0) {
                }
                if ((1533916891 & i5) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i22 != 0) {
                }
                if ((i4 & 4) != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if (i11 != 0) {
                }
                if ((i4 & 256) != 0) {
                }
                if (i13 != 0) {
                }
                if ((i4 & 1024) != 0) {
                }
                if ((i4 & 2048) != 0) {
                }
                int i2522 = i16;
                if (i15 != 0) {
                }
                Function2<? super Composer, ? super Integer, Unit> function2922 = function28;
                if ((i4 & 8192) != 0) {
                }
                int i2622 = i17;
                if ((i4 & 16384) != 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                ProvidableCompositionLocal<Density> localDensity32 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume32 = startRestartGroup.consume(localDensity32);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                final Density density22 = (Density) consume32;
                startRestartGroup.startReplaceableGroup(1938007797);
                changed = startRestartGroup.changed(bottomSheetScaffoldState2) | startRestartGroup.changed(density22);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$1
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
                        BottomSheetScaffoldState.this.getBottomSheetState().setDensity$material_release(density22);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
                startRestartGroup.endReplaceableGroup();
                EffectsKt.SideEffect((Function0) rememberedValue, startRestartGroup, 0);
                ProvidableCompositionLocal<Density> localDensity222 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume222 = startRestartGroup.consume(localDensity222);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                final float mo630toPx0680j_422 = ((Density) consume222).mo630toPx0680j_4(f4);
                final float f722 = f4;
                final long j1622 = j11;
                final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3622 = function34;
                final int i2822 = m1680getEnd5ygKITE;
                final Function2<? super Composer, ? super Integer, Unit> function21022 = function23;
                final Shape shape322 = cornerBasedShape;
                final BottomSheetScaffoldState bottomSheetScaffoldState422 = bottomSheetScaffoldState2;
                final boolean z522 = z2;
                final float f822 = m1557getSheetElevationD9Ej5fM;
                final long j1722 = j10;
                Function2<? super Composer, ? super Integer, Unit> function21122 = function25;
                j12 = j1622;
                int i2922 = i18 >> 3;
                long j1822 = j9;
                long j1922 = j8;
                SurfaceKt.m1782SurfaceFjzlyU(SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null), null, j1822, j1922, null, 0.0f, ComposableLambdaKt.composableLambda(startRestartGroup, -131096268, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2
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

                    public final void invoke(Composer composer3, int i30) {
                        ComposerKt.sourceInformation(composer3, "C466@18279L2232:BottomSheetScaffold.kt#jmzs0o");
                        if ((i30 & 11) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-131096268, i30, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:466)");
                            }
                            BottomSheetState bottomSheetState = BottomSheetScaffoldState.this.getBottomSheetState();
                            Function2<Composer, Integer, Unit> function212 = function25;
                            Function3<PaddingValues, Composer, Integer, Unit> function37 = function33;
                            final boolean z6 = z522;
                            final BottomSheetScaffoldState bottomSheetScaffoldState5 = BottomSheetScaffoldState.this;
                            final float f9 = f722;
                            final float f10 = mo630toPx0680j_422;
                            final Shape shape4 = shape322;
                            final float f11 = f822;
                            final long j202 = j1622;
                            final long j212 = j1722;
                            final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function38 = function3;
                            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer3, -1900337132, true, new Function3<Integer, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(Integer num, Composer composer4, Integer num2) {
                                    invoke(num.intValue(), composer4, num2.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(final int i31, Composer composer4, int i32) {
                                    int i33;
                                    Modifier.Companion companion;
                                    ComposerKt.sourceInformation(composer4, "C481@19031L1038:BottomSheetScaffold.kt#jmzs0o");
                                    if ((i32 & 14) == 0) {
                                        i33 = i32 | (composer4.changed(i31) ? 4 : 2);
                                    } else {
                                        i33 = i32;
                                    }
                                    if ((i33 & 91) != 18 || !composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1900337132, i33, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous> (BottomSheetScaffold.kt:470)");
                                        }
                                        composer4.startReplaceableGroup(-816851224);
                                        ComposerKt.sourceInformation(composer4, "473@18566L390");
                                        if (z6) {
                                            Modifier.Companion companion2 = Modifier.INSTANCE;
                                            AnchoredDraggableState<BottomSheetValue> anchoredDraggableState$material_release = bottomSheetScaffoldState5.getBottomSheetState().getAnchoredDraggableState$material_release();
                                            BottomSheetScaffoldState bottomSheetScaffoldState6 = bottomSheetScaffoldState5;
                                            composer4.startReplaceableGroup(1157296644);
                                            ComposerKt.sourceInformation(composer4, "CC(remember)P(1):Composables.kt#9igjgp");
                                            boolean changed2 = composer4.changed(anchoredDraggableState$material_release);
                                            Object rememberedValue2 = composer4.rememberedValue();
                                            if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue2 = BottomSheetScaffoldKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(bottomSheetScaffoldState6.getBottomSheetState().getAnchoredDraggableState$material_release(), Orientation.Vertical);
                                                composer4.updateRememberedValue(rememberedValue2);
                                            }
                                            composer4.endReplaceableGroup();
                                            companion = NestedScrollModifierKt.nestedScroll$default(companion2, (NestedScrollConnection) rememberedValue2, null, 2, null);
                                        } else {
                                            companion = Modifier.INSTANCE;
                                        }
                                        composer4.endReplaceableGroup();
                                        BottomSheetState bottomSheetState2 = bottomSheetScaffoldState5.getBottomSheetState();
                                        Modifier m919requiredHeightInVpY3zN4$default = SizeKt.m919requiredHeightInVpY3zN4$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), f9, 0.0f, 2, null);
                                        boolean z7 = z6;
                                        composer4.startReplaceableGroup(1938009097);
                                        boolean changed3 = composer4.changed(i31) | composer4.changed(f10);
                                        final float f12 = f10;
                                        Object rememberedValue3 = composer4.rememberedValue();
                                        if (changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue3 = (Function1) new Function1<IntSize, DraggableAnchors<BottomSheetValue>>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2$1$1$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ DraggableAnchors<BottomSheetValue> invoke(IntSize intSize) {
                                                    return m1566invokeozmzZPI(intSize.getPackedValue());
                                                }

                                                /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                                                public final DraggableAnchors<BottomSheetValue> m1566invokeozmzZPI(long j222) {
                                                    final float m6558getHeightimpl = IntSize.m6558getHeightimpl(j222);
                                                    final int i34 = i31;
                                                    final float f13 = f12;
                                                    return AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<BottomSheetValue>, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2$1$1$1.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<BottomSheetValue> draggableAnchorsConfig) {
                                                            invoke2(draggableAnchorsConfig);
                                                            return Unit.INSTANCE;
                                                        }

                                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                        public final void invoke2(DraggableAnchorsConfig<BottomSheetValue> draggableAnchorsConfig) {
                                                            draggableAnchorsConfig.at(BottomSheetValue.Collapsed, i34 - f13);
                                                            float f14 = m6558getHeightimpl;
                                                            if (f14 <= 0.0f || f14 == f13) {
                                                                return;
                                                            }
                                                            draggableAnchorsConfig.at(BottomSheetValue.Expanded, i34 - m6558getHeightimpl);
                                                        }
                                                    });
                                                }
                                            };
                                            composer4.updateRememberedValue(rememberedValue3);
                                        }
                                        composer4.endReplaceableGroup();
                                        BottomSheetScaffoldKt.m1559BottomSheet0cLKjW4(bottomSheetState2, z7, (Function1) rememberedValue3, shape4, f11, j202, j212, m919requiredHeightInVpY3zN4$default, function38, composer4, 0, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            });
                            Function2<Composer, Integer, Unit> function213 = function21022;
                            final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function39 = function3622;
                            final BottomSheetScaffoldState bottomSheetScaffoldState6 = BottomSheetScaffoldState.this;
                            ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composer3, -1011922215, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2.2
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

                                public final void invoke(Composer composer4, int i31) {
                                    ComposerKt.sourceInformation(composer4, "C505@20187L45:BottomSheetScaffold.kt#jmzs0o");
                                    if ((i31 & 11) == 2 && composer4.getSkipping()) {
                                        composer4.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1011922215, i31, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous> (BottomSheetScaffold.kt:505)");
                                    }
                                    function39.invoke(bottomSheetScaffoldState6.getSnackbarHostState(), composer4, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            });
                            float f12 = f722;
                            int i31 = i2822;
                            composer3.startReplaceableGroup(1938010078);
                            boolean changed2 = composer3.changed(BottomSheetScaffoldState.this);
                            final BottomSheetScaffoldState bottomSheetScaffoldState7 = BottomSheetScaffoldState.this;
                            Object rememberedValue2 = composer3.rememberedValue();
                            if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue2 = (Function0) new Function0<Float>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2$3$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Float invoke() {
                                        return Float.valueOf(BottomSheetScaffoldState.this.getBottomSheetState().requireOffset());
                                    }
                                };
                                composer3.updateRememberedValue(rememberedValue2);
                            }
                            composer3.endReplaceableGroup();
                            BottomSheetScaffoldKt.m1562BottomSheetScaffoldLayoutKCBPh4w(function212, function37, composableLambda, function213, composableLambda2, f12, i31, (Function0) rememberedValue2, bottomSheetState, composer3, 24960);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), startRestartGroup, (i2922 & 7168) | (i2922 & 896) | 1572864, 50);
                composer2 = startRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                }
                z4 = z2;
                j13 = j1922;
                j14 = j1822;
                function26 = function21122;
                f5 = f722;
                function35 = function34;
                i19 = m1680getEnd5ygKITE;
                function27 = function23;
                shape2 = cornerBasedShape;
                bottomSheetScaffoldState3 = bottomSheetScaffoldState2;
                f6 = m1557getSheetElevationD9Ej5fM;
                j15 = j1722;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i7 = i4 & 16;
            int i242 = 16384;
            if (i7 != 0) {
            }
            i8 = i4 & 32;
            if (i8 != 0) {
            }
            i9 = i4 & 64;
            if (i9 != 0) {
            }
            i11 = i4 & 128;
            if (i11 != 0) {
            }
            if ((i2 & 234881024) == 0) {
            }
            i12 = i4 & 512;
            if (i12 != 0) {
            }
            i13 = i12;
            if ((i3 & 14) != 0) {
            }
            if ((i3 & 112) != 0) {
            }
            i15 = i4 & 4096;
            if (i15 == 0) {
            }
            if ((i3 & 7168) == 0) {
            }
            if ((i3 & 57344) == 0) {
            }
            if ((i4 & 32768) != 0) {
            }
            if ((1533916891 & i5) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i22 != 0) {
            }
            if ((i4 & 4) != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if (i11 != 0) {
            }
            if ((i4 & 256) != 0) {
            }
            if (i13 != 0) {
            }
            if ((i4 & 1024) != 0) {
            }
            if ((i4 & 2048) != 0) {
            }
            int i25222 = i16;
            if (i15 != 0) {
            }
            Function2<? super Composer, ? super Integer, Unit> function29222 = function28;
            if ((i4 & 8192) != 0) {
            }
            int i26222 = i17;
            if ((i4 & 16384) != 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            ProvidableCompositionLocal<Density> localDensity322 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume322 = startRestartGroup.consume(localDensity322);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final Density density222 = (Density) consume322;
            startRestartGroup.startReplaceableGroup(1938007797);
            changed = startRestartGroup.changed(bottomSheetScaffoldState2) | startRestartGroup.changed(density222);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$1
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
                    BottomSheetScaffoldState.this.getBottomSheetState().setDensity$material_release(density222);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceableGroup();
            EffectsKt.SideEffect((Function0) rememberedValue, startRestartGroup, 0);
            ProvidableCompositionLocal<Density> localDensity2222 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2222 = startRestartGroup.consume(localDensity2222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final float mo630toPx0680j_4222 = ((Density) consume2222).mo630toPx0680j_4(f4);
            final float f7222 = f4;
            final long j16222 = j11;
            final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function36222 = function34;
            final int i28222 = m1680getEnd5ygKITE;
            final Function2<? super Composer, ? super Integer, Unit> function210222 = function23;
            final Shape shape3222 = cornerBasedShape;
            final BottomSheetScaffoldState bottomSheetScaffoldState4222 = bottomSheetScaffoldState2;
            final boolean z5222 = z2;
            final float f8222 = m1557getSheetElevationD9Ej5fM;
            final long j17222 = j10;
            Function2<? super Composer, ? super Integer, Unit> function211222 = function25;
            j12 = j16222;
            int i29222 = i18 >> 3;
            long j18222 = j9;
            long j19222 = j8;
            SurfaceKt.m1782SurfaceFjzlyU(SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null), null, j18222, j19222, null, 0.0f, ComposableLambdaKt.composableLambda(startRestartGroup, -131096268, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2
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

                public final void invoke(Composer composer3, int i30) {
                    ComposerKt.sourceInformation(composer3, "C466@18279L2232:BottomSheetScaffold.kt#jmzs0o");
                    if ((i30 & 11) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-131096268, i30, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:466)");
                        }
                        BottomSheetState bottomSheetState = BottomSheetScaffoldState.this.getBottomSheetState();
                        Function2<Composer, Integer, Unit> function212 = function25;
                        Function3<PaddingValues, Composer, Integer, Unit> function37 = function33;
                        final boolean z6 = z5222;
                        final BottomSheetScaffoldState bottomSheetScaffoldState5 = BottomSheetScaffoldState.this;
                        final float f9 = f7222;
                        final float f10 = mo630toPx0680j_4222;
                        final Shape shape4 = shape3222;
                        final float f11 = f8222;
                        final long j202 = j16222;
                        final long j212 = j17222;
                        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function38 = function3;
                        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer3, -1900337132, true, new Function3<Integer, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Composer composer4, Integer num2) {
                                invoke(num.intValue(), composer4, num2.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(final int i31, Composer composer4, int i32) {
                                int i33;
                                Modifier.Companion companion;
                                ComposerKt.sourceInformation(composer4, "C481@19031L1038:BottomSheetScaffold.kt#jmzs0o");
                                if ((i32 & 14) == 0) {
                                    i33 = i32 | (composer4.changed(i31) ? 4 : 2);
                                } else {
                                    i33 = i32;
                                }
                                if ((i33 & 91) != 18 || !composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1900337132, i33, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous> (BottomSheetScaffold.kt:470)");
                                    }
                                    composer4.startReplaceableGroup(-816851224);
                                    ComposerKt.sourceInformation(composer4, "473@18566L390");
                                    if (z6) {
                                        Modifier.Companion companion2 = Modifier.INSTANCE;
                                        AnchoredDraggableState<BottomSheetValue> anchoredDraggableState$material_release = bottomSheetScaffoldState5.getBottomSheetState().getAnchoredDraggableState$material_release();
                                        BottomSheetScaffoldState bottomSheetScaffoldState6 = bottomSheetScaffoldState5;
                                        composer4.startReplaceableGroup(1157296644);
                                        ComposerKt.sourceInformation(composer4, "CC(remember)P(1):Composables.kt#9igjgp");
                                        boolean changed2 = composer4.changed(anchoredDraggableState$material_release);
                                        Object rememberedValue2 = composer4.rememberedValue();
                                        if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue2 = BottomSheetScaffoldKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(bottomSheetScaffoldState6.getBottomSheetState().getAnchoredDraggableState$material_release(), Orientation.Vertical);
                                            composer4.updateRememberedValue(rememberedValue2);
                                        }
                                        composer4.endReplaceableGroup();
                                        companion = NestedScrollModifierKt.nestedScroll$default(companion2, (NestedScrollConnection) rememberedValue2, null, 2, null);
                                    } else {
                                        companion = Modifier.INSTANCE;
                                    }
                                    composer4.endReplaceableGroup();
                                    BottomSheetState bottomSheetState2 = bottomSheetScaffoldState5.getBottomSheetState();
                                    Modifier m919requiredHeightInVpY3zN4$default = SizeKt.m919requiredHeightInVpY3zN4$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), f9, 0.0f, 2, null);
                                    boolean z7 = z6;
                                    composer4.startReplaceableGroup(1938009097);
                                    boolean changed3 = composer4.changed(i31) | composer4.changed(f10);
                                    final float f12 = f10;
                                    Object rememberedValue3 = composer4.rememberedValue();
                                    if (changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue3 = (Function1) new Function1<IntSize, DraggableAnchors<BottomSheetValue>>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2$1$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ DraggableAnchors<BottomSheetValue> invoke(IntSize intSize) {
                                                return m1566invokeozmzZPI(intSize.getPackedValue());
                                            }

                                            /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                                            public final DraggableAnchors<BottomSheetValue> m1566invokeozmzZPI(long j222) {
                                                final float m6558getHeightimpl = IntSize.m6558getHeightimpl(j222);
                                                final int i34 = i31;
                                                final float f13 = f12;
                                                return AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<BottomSheetValue>, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2$1$1$1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<BottomSheetValue> draggableAnchorsConfig) {
                                                        invoke2(draggableAnchorsConfig);
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(DraggableAnchorsConfig<BottomSheetValue> draggableAnchorsConfig) {
                                                        draggableAnchorsConfig.at(BottomSheetValue.Collapsed, i34 - f13);
                                                        float f14 = m6558getHeightimpl;
                                                        if (f14 <= 0.0f || f14 == f13) {
                                                            return;
                                                        }
                                                        draggableAnchorsConfig.at(BottomSheetValue.Expanded, i34 - m6558getHeightimpl);
                                                    }
                                                });
                                            }
                                        };
                                        composer4.updateRememberedValue(rememberedValue3);
                                    }
                                    composer4.endReplaceableGroup();
                                    BottomSheetScaffoldKt.m1559BottomSheet0cLKjW4(bottomSheetState2, z7, (Function1) rememberedValue3, shape4, f11, j202, j212, m919requiredHeightInVpY3zN4$default, function38, composer4, 0, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer4.skipToGroupEnd();
                            }
                        });
                        Function2<Composer, Integer, Unit> function213 = function210222;
                        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function39 = function36222;
                        final BottomSheetScaffoldState bottomSheetScaffoldState6 = BottomSheetScaffoldState.this;
                        ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composer3, -1011922215, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2.2
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

                            public final void invoke(Composer composer4, int i31) {
                                ComposerKt.sourceInformation(composer4, "C505@20187L45:BottomSheetScaffold.kt#jmzs0o");
                                if ((i31 & 11) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1011922215, i31, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous> (BottomSheetScaffold.kt:505)");
                                }
                                function39.invoke(bottomSheetScaffoldState6.getSnackbarHostState(), composer4, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        });
                        float f12 = f7222;
                        int i31 = i28222;
                        composer3.startReplaceableGroup(1938010078);
                        boolean changed2 = composer3.changed(BottomSheetScaffoldState.this);
                        final BottomSheetScaffoldState bottomSheetScaffoldState7 = BottomSheetScaffoldState.this;
                        Object rememberedValue2 = composer3.rememberedValue();
                        if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = (Function0) new Function0<Float>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2$3$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Float invoke() {
                                    return Float.valueOf(BottomSheetScaffoldState.this.getBottomSheetState().requireOffset());
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue2);
                        }
                        composer3.endReplaceableGroup();
                        BottomSheetScaffoldKt.m1562BottomSheetScaffoldLayoutKCBPh4w(function212, function37, composableLambda, function213, composableLambda2, f12, i31, (Function0) rememberedValue2, bottomSheetState, composer3, 24960);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), startRestartGroup, (i29222 & 7168) | (i29222 & 896) | 1572864, 50);
            composer2 = startRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
            }
            z4 = z2;
            j13 = j19222;
            j14 = j18222;
            function26 = function211222;
            f5 = f7222;
            function35 = function34;
            i19 = m1680getEnd5ygKITE;
            function27 = function23;
            shape2 = cornerBasedShape;
            bottomSheetScaffoldState3 = bottomSheetScaffoldState2;
            f6 = m1557getSheetElevationD9Ej5fM;
            j15 = j17222;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i2 & 896) != 0) {
        }
        i6 = i4 & 8;
        int i232 = 2048;
        if (i6 == 0) {
        }
        i7 = i4 & 16;
        int i2422 = 16384;
        if (i7 != 0) {
        }
        i8 = i4 & 32;
        if (i8 != 0) {
        }
        i9 = i4 & 64;
        if (i9 != 0) {
        }
        i11 = i4 & 128;
        if (i11 != 0) {
        }
        if ((i2 & 234881024) == 0) {
        }
        i12 = i4 & 512;
        if (i12 != 0) {
        }
        i13 = i12;
        if ((i3 & 14) != 0) {
        }
        if ((i3 & 112) != 0) {
        }
        i15 = i4 & 4096;
        if (i15 == 0) {
        }
        if ((i3 & 7168) == 0) {
        }
        if ((i3 & 57344) == 0) {
        }
        if ((i4 & 32768) != 0) {
        }
        if ((1533916891 & i5) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i22 != 0) {
        }
        if ((i4 & 4) != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (i11 != 0) {
        }
        if ((i4 & 256) != 0) {
        }
        if (i13 != 0) {
        }
        if ((i4 & 1024) != 0) {
        }
        if ((i4 & 2048) != 0) {
        }
        int i252222 = i16;
        if (i15 != 0) {
        }
        Function2<? super Composer, ? super Integer, Unit> function292222 = function28;
        if ((i4 & 8192) != 0) {
        }
        int i262222 = i17;
        if ((i4 & 16384) != 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        ProvidableCompositionLocal<Density> localDensity3222 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume3222 = startRestartGroup.consume(localDensity3222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        final Density density2222 = (Density) consume3222;
        startRestartGroup.startReplaceableGroup(1938007797);
        changed = startRestartGroup.changed(bottomSheetScaffoldState2) | startRestartGroup.changed(density2222);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1$1
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
                BottomSheetScaffoldState.this.getBottomSheetState().setDensity$material_release(density2222);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceableGroup();
        EffectsKt.SideEffect((Function0) rememberedValue, startRestartGroup, 0);
        ProvidableCompositionLocal<Density> localDensity22222 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume22222 = startRestartGroup.consume(localDensity22222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        final float mo630toPx0680j_42222 = ((Density) consume22222).mo630toPx0680j_4(f4);
        final float f72222 = f4;
        final long j162222 = j11;
        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function362222 = function34;
        final int i282222 = m1680getEnd5ygKITE;
        final Function2<? super Composer, ? super Integer, Unit> function2102222 = function23;
        final Shape shape32222 = cornerBasedShape;
        final BottomSheetScaffoldState bottomSheetScaffoldState42222 = bottomSheetScaffoldState2;
        final boolean z52222 = z2;
        final float f82222 = m1557getSheetElevationD9Ej5fM;
        final long j172222 = j10;
        Function2<? super Composer, ? super Integer, Unit> function2112222 = function25;
        j12 = j162222;
        int i292222 = i18 >> 3;
        long j182222 = j9;
        long j192222 = j8;
        SurfaceKt.m1782SurfaceFjzlyU(SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null), null, j182222, j192222, null, 0.0f, ComposableLambdaKt.composableLambda(startRestartGroup, -131096268, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2
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

            public final void invoke(Composer composer3, int i30) {
                ComposerKt.sourceInformation(composer3, "C466@18279L2232:BottomSheetScaffold.kt#jmzs0o");
                if ((i30 & 11) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-131096268, i30, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:466)");
                    }
                    BottomSheetState bottomSheetState = BottomSheetScaffoldState.this.getBottomSheetState();
                    Function2<Composer, Integer, Unit> function212 = function25;
                    Function3<PaddingValues, Composer, Integer, Unit> function37 = function33;
                    final boolean z6 = z52222;
                    final BottomSheetScaffoldState bottomSheetScaffoldState5 = BottomSheetScaffoldState.this;
                    final float f9 = f72222;
                    final float f10 = mo630toPx0680j_42222;
                    final Shape shape4 = shape32222;
                    final float f11 = f82222;
                    final long j202 = j162222;
                    final long j212 = j172222;
                    final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function38 = function3;
                    ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer3, -1900337132, true, new Function3<Integer, Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Integer num, Composer composer4, Integer num2) {
                            invoke(num.intValue(), composer4, num2.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(final int i31, Composer composer4, int i32) {
                            int i33;
                            Modifier.Companion companion;
                            ComposerKt.sourceInformation(composer4, "C481@19031L1038:BottomSheetScaffold.kt#jmzs0o");
                            if ((i32 & 14) == 0) {
                                i33 = i32 | (composer4.changed(i31) ? 4 : 2);
                            } else {
                                i33 = i32;
                            }
                            if ((i33 & 91) != 18 || !composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1900337132, i33, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous> (BottomSheetScaffold.kt:470)");
                                }
                                composer4.startReplaceableGroup(-816851224);
                                ComposerKt.sourceInformation(composer4, "473@18566L390");
                                if (z6) {
                                    Modifier.Companion companion2 = Modifier.INSTANCE;
                                    AnchoredDraggableState<BottomSheetValue> anchoredDraggableState$material_release = bottomSheetScaffoldState5.getBottomSheetState().getAnchoredDraggableState$material_release();
                                    BottomSheetScaffoldState bottomSheetScaffoldState6 = bottomSheetScaffoldState5;
                                    composer4.startReplaceableGroup(1157296644);
                                    ComposerKt.sourceInformation(composer4, "CC(remember)P(1):Composables.kt#9igjgp");
                                    boolean changed2 = composer4.changed(anchoredDraggableState$material_release);
                                    Object rememberedValue2 = composer4.rememberedValue();
                                    if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue2 = BottomSheetScaffoldKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(bottomSheetScaffoldState6.getBottomSheetState().getAnchoredDraggableState$material_release(), Orientation.Vertical);
                                        composer4.updateRememberedValue(rememberedValue2);
                                    }
                                    composer4.endReplaceableGroup();
                                    companion = NestedScrollModifierKt.nestedScroll$default(companion2, (NestedScrollConnection) rememberedValue2, null, 2, null);
                                } else {
                                    companion = Modifier.INSTANCE;
                                }
                                composer4.endReplaceableGroup();
                                BottomSheetState bottomSheetState2 = bottomSheetScaffoldState5.getBottomSheetState();
                                Modifier m919requiredHeightInVpY3zN4$default = SizeKt.m919requiredHeightInVpY3zN4$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), f9, 0.0f, 2, null);
                                boolean z7 = z6;
                                composer4.startReplaceableGroup(1938009097);
                                boolean changed3 = composer4.changed(i31) | composer4.changed(f10);
                                final float f12 = f10;
                                Object rememberedValue3 = composer4.rememberedValue();
                                if (changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue3 = (Function1) new Function1<IntSize, DraggableAnchors<BottomSheetValue>>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2$1$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ DraggableAnchors<BottomSheetValue> invoke(IntSize intSize) {
                                            return m1566invokeozmzZPI(intSize.getPackedValue());
                                        }

                                        /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                                        public final DraggableAnchors<BottomSheetValue> m1566invokeozmzZPI(long j222) {
                                            final float m6558getHeightimpl = IntSize.m6558getHeightimpl(j222);
                                            final int i34 = i31;
                                            final float f13 = f12;
                                            return AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<BottomSheetValue>, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2$1$1$1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<BottomSheetValue> draggableAnchorsConfig) {
                                                    invoke2(draggableAnchorsConfig);
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(DraggableAnchorsConfig<BottomSheetValue> draggableAnchorsConfig) {
                                                    draggableAnchorsConfig.at(BottomSheetValue.Collapsed, i34 - f13);
                                                    float f14 = m6558getHeightimpl;
                                                    if (f14 <= 0.0f || f14 == f13) {
                                                        return;
                                                    }
                                                    draggableAnchorsConfig.at(BottomSheetValue.Expanded, i34 - m6558getHeightimpl);
                                                }
                                            });
                                        }
                                    };
                                    composer4.updateRememberedValue(rememberedValue3);
                                }
                                composer4.endReplaceableGroup();
                                BottomSheetScaffoldKt.m1559BottomSheet0cLKjW4(bottomSheetState2, z7, (Function1) rememberedValue3, shape4, f11, j202, j212, m919requiredHeightInVpY3zN4$default, function38, composer4, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer4.skipToGroupEnd();
                        }
                    });
                    Function2<Composer, Integer, Unit> function213 = function2102222;
                    final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function39 = function362222;
                    final BottomSheetScaffoldState bottomSheetScaffoldState6 = BottomSheetScaffoldState.this;
                    ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composer3, -1011922215, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2.2
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

                        public final void invoke(Composer composer4, int i31) {
                            ComposerKt.sourceInformation(composer4, "C505@20187L45:BottomSheetScaffold.kt#jmzs0o");
                            if ((i31 & 11) == 2 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1011922215, i31, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous> (BottomSheetScaffold.kt:505)");
                            }
                            function39.invoke(bottomSheetScaffoldState6.getSnackbarHostState(), composer4, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    });
                    float f12 = f72222;
                    int i31 = i282222;
                    composer3.startReplaceableGroup(1938010078);
                    boolean changed2 = composer3.changed(BottomSheetScaffoldState.this);
                    final BottomSheetScaffoldState bottomSheetScaffoldState7 = BottomSheetScaffoldState.this;
                    Object rememberedValue2 = composer3.rememberedValue();
                    if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = (Function0) new Function0<Float>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2$3$1
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Float invoke() {
                                return Float.valueOf(BottomSheetScaffoldState.this.getBottomSheetState().requireOffset());
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue2);
                    }
                    composer3.endReplaceableGroup();
                    BottomSheetScaffoldKt.m1562BottomSheetScaffoldLayoutKCBPh4w(function212, function37, composableLambda, function213, composableLambda2, f12, i31, (Function0) rememberedValue2, bottomSheetState, composer3, 24960);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }), startRestartGroup, (i292222 & 7168) | (i292222 & 896) | 1572864, 50);
        composer2 = startRestartGroup;
        if (ComposerKt.isTraceInProgress()) {
        }
        z4 = z2;
        j13 = j192222;
        j14 = j182222;
        function26 = function2112222;
        f5 = f72222;
        function35 = function34;
        i19 = m1680getEnd5ygKITE;
        function27 = function23;
        shape2 = cornerBasedShape;
        bottomSheetScaffoldState3 = bottomSheetScaffoldState2;
        f6 = m1557getSheetElevationD9Ej5fM;
        j15 = j172222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = BottomSheetScaffoldWithDrawerDeprecated)
    /* renamed from: BottomSheetScaffold-bGncdBI, reason: not valid java name */
    public static final void m1561BottomSheetScaffoldbGncdBI(final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, final Modifier modifier, final BottomSheetScaffoldState bottomSheetScaffoldState, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function32, final Function2<? super Composer, ? super Integer, Unit> function22, final int i, final boolean z, final Shape shape, final float f, long j, final long j2, final float f2, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function33, final boolean z2, final Shape shape2, final float f3, long j3, final long j4, final long j5, long j6, final long j7, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function34, Composer composer, final int i2, final int i3, final int i4, final int i5) {
        final long j8;
        int i6;
        long j9;
        long j10;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        long j11;
        long j12;
        long j13;
        Composer startRestartGroup = composer.startRestartGroup(46422755);
        ComposerKt.sourceInformation(startRestartGroup, "C(BottomSheetScaffold)P(15,12,13,22,21,10,11:c#material.FabPosition,18,20,17:c#ui.unit.Dp,14:c#ui.graphics.Color,16:c#ui.graphics.Color,19:c#ui.unit.Dp,4,7,9,6:c#ui.unit.Dp,3:c#ui.graphics.Color,5:c#ui.graphics.Color,8:c#ui.graphics.Color,0:c#ui.graphics.Color,2:c#ui.graphics.Color)574@24388L34,580@24757L6,582@24888L6,583@24935L37,587@25192L6,589@25307L6,590@25355L38,591@25440L10,592@25495L6,593@25540L32:BottomSheetScaffold.kt#jmzs0o");
        if ((i3 & 14) == 0) {
            j8 = j;
            i6 = i3 | (((i5 & 1024) == 0 && startRestartGroup.changed(j8)) ? 4 : 2);
        } else {
            j8 = j;
            i6 = i3;
        }
        if ((i3 & 29360128) == 0) {
            j9 = j3;
            i6 |= ((i5 & 131072) == 0 && startRestartGroup.changed(j9)) ? 8388608 : 4194304;
        } else {
            j9 = j3;
        }
        if ((i4 & 14) == 0) {
            j10 = j6;
            i7 = i4 | (((i5 & 1048576) == 0 && startRestartGroup.changed(j10)) ? 4 : 2);
        } else {
            j10 = j6;
            i7 = i4;
        }
        int i13 = i2 & 1;
        if (i13 == 0) {
            i9 = 131072;
            if ((20971531 & i6) == 4194306 && (i7 & 11) == 2 && startRestartGroup.getSkipping()) {
                startRestartGroup.skipToGroupEnd();
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    final long j14 = j9;
                    final long j15 = j10;
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$4
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

                        public final void invoke(Composer composer2, int i14) {
                            BottomSheetScaffoldKt.m1561BottomSheetScaffoldbGncdBI(function3, modifier, bottomSheetScaffoldState, function2, function32, function22, i, z, shape, f, j8, j2, f2, function33, z2, shape2, f3, j14, j4, j5, j15, j7, function34, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                        }
                    });
                    return;
                }
                return;
            }
            i8 = i5;
        } else {
            i8 = i5;
            i9 = 131072;
        }
        int i14 = i2;
        startRestartGroup.startDefaults();
        if (i13 == 0 || startRestartGroup.getDefaultsInvalid()) {
            if ((i8 & 2) != 0) {
                Modifier.Companion companion = Modifier.INSTANCE;
            }
            if ((i8 & 4) != 0) {
                i10 = -1879048193;
                rememberBottomSheetScaffoldState(null, null, startRestartGroup, 0, 3);
                i14 &= -897;
            } else {
                i10 = -1879048193;
            }
            if ((i8 & 16) != 0) {
                ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1630getLambda2$material_release();
            }
            if ((i8 & 64) != 0) {
                FabPosition.INSTANCE.m1680getEnd5ygKITE();
            }
            if ((i8 & 256) != 0) {
                MaterialTheme.INSTANCE.getShapes(startRestartGroup, 6).getLarge();
                i14 &= -234881025;
            }
            if ((i8 & 512) != 0) {
                BottomSheetScaffoldDefaults.INSTANCE.m1557getSheetElevationD9Ej5fM();
            }
            if ((i8 & 1024) != 0) {
                i6 &= -15;
                i11 = 524288;
                i12 = -29360129;
                j11 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m1607getSurface0d7_KjU();
            } else {
                i11 = 524288;
                i12 = -29360129;
                j11 = j;
            }
            if ((i8 & 2048) != 0) {
                ColorsKt.m1621contentColorForek8zF_U(j11, startRestartGroup, i6 & 14);
                i6 &= -113;
            }
            if ((i8 & 4096) != 0) {
                BottomSheetScaffoldDefaults.INSTANCE.m1558getSheetPeekHeightD9Ej5fM();
            }
            if ((i8 & 32768) != 0) {
                MaterialTheme.INSTANCE.getShapes(startRestartGroup, 6).getLarge();
                i6 &= -458753;
            }
            if ((65536 & i8) != 0) {
                DrawerDefaults.INSTANCE.m1649getElevationD9Ej5fM();
            }
            if ((i8 & i9) != 0) {
                j12 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m1607getSurface0d7_KjU();
                i6 &= i12;
            } else {
                j12 = j3;
            }
            if ((i8 & 262144) != 0) {
                ColorsKt.m1621contentColorForek8zF_U(j12, startRestartGroup, (i6 >> 21) & 14);
                i6 &= -234881025;
            }
            if ((i8 & i11) != 0) {
                DrawerDefaults.INSTANCE.getScrimColor(startRestartGroup, 6);
                i6 &= i10;
            }
            if ((i8 & 1048576) != 0) {
                j13 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m1596getBackground0d7_KjU();
                i7 &= -15;
            } else {
                j13 = j6;
            }
            if ((i8 & 2097152) != 0) {
                ColorsKt.m1621contentColorForek8zF_U(j13, startRestartGroup, i7 & 14);
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            if ((i8 & 4) != 0) {
                i14 &= -897;
            }
            if ((i8 & 256) != 0) {
                i14 &= -234881025;
            }
            if ((i8 & 1024) != 0) {
                i6 &= -15;
            }
            if ((i8 & 2048) != 0) {
                i6 &= -113;
            }
            if ((i8 & 32768) != 0) {
                i6 &= -458753;
            }
            if ((i8 & i9) != 0) {
                i6 &= -29360129;
            }
            if ((i8 & 262144) != 0) {
                i6 &= -234881025;
            }
            if ((i8 & 524288) != 0) {
                i6 &= -1879048193;
            }
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(46422755, i14, i6, "androidx.compose.material.BottomSheetScaffold (BottomSheetScaffold.kt:595)");
        }
        throw new IllegalStateException(BottomSheetScaffoldWithDrawerDeprecated.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0069  */
    /* renamed from: BottomSheet-0cLKjW4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1559BottomSheet0cLKjW4(final BottomSheetState bottomSheetState, final boolean z, final Function1<? super IntSize, ? extends DraggableAnchors<BottomSheetValue>> function1, final Shape shape, final float f, final long j, final long j2, Modifier modifier, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Shape shape2;
        float f2;
        int i4;
        int i5;
        long j3;
        int i6;
        Modifier modifier2;
        Object rememberedValue;
        boolean changedInstance;
        Object rememberedValue2;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(1407045933);
        ComposerKt.sourceInformation(startRestartGroup, "C(BottomSheet)P(8,6!1,7,5:c#ui.unit.Dp,3:c#ui.graphics.Color,4:c#ui.graphics.Color,2)612@26116L24,613@26145L1780:BottomSheetScaffold.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changed(bottomSheetState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= startRestartGroup.changed(z) ? 32 : 16;
            if ((i2 & 4) == 0) {
                i3 |= 384;
            } else if ((i & 896) == 0) {
                i3 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
            }
            if ((i2 & 8) == 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                shape2 = shape;
                i3 |= startRestartGroup.changed(shape2) ? 2048 : 1024;
                if ((i2 & 16) != 0) {
                    i3 |= 24576;
                } else if ((57344 & i) == 0) {
                    f2 = f;
                    i3 |= startRestartGroup.changed(f2) ? 16384 : 8192;
                    if ((i2 & 32) == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i & 458752) == 0) {
                        i3 |= startRestartGroup.changed(j) ? 131072 : 65536;
                    }
                    if ((i2 & 64) == 0) {
                        i3 |= 1572864;
                        i4 = 458752;
                    } else {
                        i4 = 458752;
                        if ((3670016 & i) == 0) {
                            i5 = 1572864;
                            j3 = j2;
                            i3 |= startRestartGroup.changed(j3) ? 1048576 : 524288;
                            int i8 = i5;
                            i6 = i2 & 128;
                            if (i6 != 0) {
                                i3 |= 12582912;
                            } else if ((i & 29360128) == 0) {
                                i3 |= startRestartGroup.changed(modifier) ? 8388608 : 4194304;
                            }
                            if ((i2 & 256) == 0) {
                                i7 = (234881024 & i) == 0 ? startRestartGroup.changedInstance(function3) ? 67108864 : 33554432 : 100663296;
                                if ((191739611 & i3) == 38347922 || !startRestartGroup.getSkipping()) {
                                    Modifier.Companion companion = i6 == 0 ? Modifier.INSTANCE : modifier;
                                    if (ComposerKt.isTraceInProgress()) {
                                        modifier2 = companion;
                                    } else {
                                        modifier2 = companion;
                                        ComposerKt.traceEventStart(1407045933, i3, -1, "androidx.compose.material.BottomSheet (BottomSheetScaffold.kt:611)");
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
                                    Modifier modifier4 = modifier2;
                                    Modifier anchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(modifier4, bottomSheetState.getAnchoredDraggableState$material_release(), Orientation.Vertical, z, false, null, false, 56, null);
                                    startRestartGroup.startReplaceableGroup(1938016202);
                                    changedInstance = startRestartGroup.changedInstance(function1) | startRestartGroup.changed(bottomSheetState);
                                    rememberedValue2 = startRestartGroup.rememberedValue();
                                    if (!changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue2 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$1$1

                                            /* compiled from: BottomSheetScaffold.kt */
                                            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                                            public /* synthetic */ class WhenMappings {
                                                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                                static {
                                                    int[] iArr = new int[BottomSheetValue.values().length];
                                                    try {
                                                        iArr[BottomSheetValue.Collapsed.ordinal()] = 1;
                                                    } catch (NoSuchFieldError unused) {
                                                    }
                                                    try {
                                                        iArr[BottomSheetValue.Expanded.ordinal()] = 2;
                                                    } catch (NoSuchFieldError unused2) {
                                                    }
                                                    $EnumSwitchMapping$0 = iArr;
                                                }
                                            }

                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                                                m1565invokeozmzZPI(intSize.getPackedValue());
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                                            public final void m1565invokeozmzZPI(long j4) {
                                                BottomSheetValue bottomSheetValue;
                                                DraggableAnchors<BottomSheetValue> invoke = function1.invoke(IntSize.m6551boximpl(j4));
                                                int i9 = WhenMappings.$EnumSwitchMapping$0[bottomSheetState.getAnchoredDraggableState$material_release().getTargetValue().ordinal()];
                                                if (i9 == 1) {
                                                    bottomSheetValue = BottomSheetValue.Collapsed;
                                                } else {
                                                    if (i9 != 2) {
                                                        throw new NoWhenBranchMatchedException();
                                                    }
                                                    bottomSheetValue = invoke.hasAnchorFor(BottomSheetValue.Expanded) ? BottomSheetValue.Expanded : BottomSheetValue.Collapsed;
                                                }
                                                bottomSheetState.getAnchoredDraggableState$material_release().updateAnchors(invoke, bottomSheetValue);
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue2);
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    int i9 = i3 >> 9;
                                    int i10 = ((i3 >> 6) & 112) | i8 | (i9 & 896) | (i9 & 7168) | ((i3 << 3) & i4);
                                    composer2 = startRestartGroup;
                                    SurfaceKt.m1782SurfaceFjzlyU(SemanticsModifierKt.semantics$default(OnRemeasuredModifierKt.onSizeChanged(anchoredDraggable$default, (Function1) rememberedValue2), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2
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
                                            if (BottomSheetState.this.getAnchoredDraggableState$material_release().getAnchors().getSize() > 1) {
                                                if (BottomSheetState.this.isCollapsed()) {
                                                    final BottomSheetState bottomSheetState2 = BottomSheetState.this;
                                                    final CoroutineScope coroutineScope2 = coroutineScope;
                                                    SemanticsPropertiesKt.expand$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(0);
                                                        }

                                                        /* compiled from: BottomSheetScaffold.kt */
                                                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                                        @DebugMetadata(c = "androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2$1$1", f = "BottomSheetScaffold.kt", i = {}, l = {636}, m = "invokeSuspend", n = {}, s = {})
                                                        /* renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2$1$1, reason: invalid class name and collision with other inner class name */
                                                        static final class C00371 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                            final /* synthetic */ BottomSheetState $state;
                                                            int label;

                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            C00371(BottomSheetState bottomSheetState, Continuation<? super C00371> continuation) {
                                                                super(2, continuation);
                                                                this.$state = bottomSheetState;
                                                            }

                                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                                return new C00371(this.$state, continuation);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function2
                                                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                                return ((C00371) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                            }

                                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                            public final Object invokeSuspend(Object obj) {
                                                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                                int i = this.label;
                                                                if (i == 0) {
                                                                    ResultKt.throwOnFailure(obj);
                                                                    this.label = 1;
                                                                    if (this.$state.expand(this) == coroutine_suspended) {
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
                                                            if (BottomSheetState.this.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(BottomSheetValue.Expanded).booleanValue()) {
                                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new C00371(BottomSheetState.this, null), 3, null);
                                                            }
                                                            return true;
                                                        }
                                                    }, 1, null);
                                                } else {
                                                    final BottomSheetState bottomSheetState3 = BottomSheetState.this;
                                                    final CoroutineScope coroutineScope3 = coroutineScope;
                                                    SemanticsPropertiesKt.collapse$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2.2
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(0);
                                                        }

                                                        /* compiled from: BottomSheetScaffold.kt */
                                                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                                        @DebugMetadata(c = "androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2$2$1", f = "BottomSheetScaffold.kt", i = {}, l = {643}, m = "invokeSuspend", n = {}, s = {})
                                                        /* renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2$2$1, reason: invalid class name */
                                                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                            final /* synthetic */ BottomSheetState $state;
                                                            int label;

                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            AnonymousClass1(BottomSheetState bottomSheetState, Continuation<? super AnonymousClass1> continuation) {
                                                                super(2, continuation);
                                                                this.$state = bottomSheetState;
                                                            }

                                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                                return new AnonymousClass1(this.$state, continuation);
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
                                                                    if (this.$state.collapse(this) == coroutine_suspended) {
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
                                                            if (BottomSheetState.this.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(BottomSheetValue.Collapsed).booleanValue()) {
                                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new AnonymousClass1(BottomSheetState.this, null), 3, null);
                                                            }
                                                            return true;
                                                        }
                                                    }, 1, null);
                                                }
                                            }
                                        }
                                    }, 1, null), shape2, j, j3, null, f2, ComposableLambdaKt.composableLambda(startRestartGroup, 1944994153, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$3
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

                                        public final void invoke(Composer composer3, int i11) {
                                            ComposerKt.sourceInformation(composer3, "C653@27892L25:BottomSheetScaffold.kt#jmzs0o");
                                            if ((i11 & 11) == 2 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1944994153, i11, -1, "androidx.compose.material.BottomSheet.<anonymous> (BottomSheetScaffold.kt:653)");
                                            }
                                            Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                                            composer3.startReplaceableGroup(-483455358);
                                            ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                            Modifier.Companion companion2 = Modifier.INSTANCE;
                                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                            composer3.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion2);
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
                                            Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                            composer3.startReplaceableGroup(2058660585);
                                            ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                            function32.invoke(ColumnScopeInstance.INSTANCE, composer3, 6);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            composer3.endReplaceableGroup();
                                            composer3.endNode();
                                            composer3.endReplaceableGroup();
                                            composer3.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer2, i10, 16);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier3 = modifier4;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    modifier3 = modifier;
                                    composer2 = startRestartGroup;
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup == null) {
                                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$4
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

                                        public final void invoke(Composer composer3, int i11) {
                                            BottomSheetScaffoldKt.m1559BottomSheet0cLKjW4(BottomSheetState.this, z, function1, shape, f, j, j2, modifier3, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i3 |= i7;
                            if ((191739611 & i3) == 38347922) {
                            }
                            if (i6 == 0) {
                            }
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
                            Modifier modifier42 = modifier2;
                            Modifier anchoredDraggable$default2 = AnchoredDraggableKt.anchoredDraggable$default(modifier42, bottomSheetState.getAnchoredDraggableState$material_release(), Orientation.Vertical, z, false, null, false, 56, null);
                            startRestartGroup.startReplaceableGroup(1938016202);
                            changedInstance = startRestartGroup.changedInstance(function1) | startRestartGroup.changed(bottomSheetState);
                            rememberedValue2 = startRestartGroup.rememberedValue();
                            if (!changedInstance) {
                            }
                            rememberedValue2 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$1$1

                                /* compiled from: BottomSheetScaffold.kt */
                                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                                public /* synthetic */ class WhenMappings {
                                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                    static {
                                        int[] iArr = new int[BottomSheetValue.values().length];
                                        try {
                                            iArr[BottomSheetValue.Collapsed.ordinal()] = 1;
                                        } catch (NoSuchFieldError unused) {
                                        }
                                        try {
                                            iArr[BottomSheetValue.Expanded.ordinal()] = 2;
                                        } catch (NoSuchFieldError unused2) {
                                        }
                                        $EnumSwitchMapping$0 = iArr;
                                    }
                                }

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                                    m1565invokeozmzZPI(intSize.getPackedValue());
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                                public final void m1565invokeozmzZPI(long j4) {
                                    BottomSheetValue bottomSheetValue;
                                    DraggableAnchors<BottomSheetValue> invoke = function1.invoke(IntSize.m6551boximpl(j4));
                                    int i92 = WhenMappings.$EnumSwitchMapping$0[bottomSheetState.getAnchoredDraggableState$material_release().getTargetValue().ordinal()];
                                    if (i92 == 1) {
                                        bottomSheetValue = BottomSheetValue.Collapsed;
                                    } else {
                                        if (i92 != 2) {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                        bottomSheetValue = invoke.hasAnchorFor(BottomSheetValue.Expanded) ? BottomSheetValue.Expanded : BottomSheetValue.Collapsed;
                                    }
                                    bottomSheetState.getAnchoredDraggableState$material_release().updateAnchors(invoke, bottomSheetValue);
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                            startRestartGroup.endReplaceableGroup();
                            int i92 = i3 >> 9;
                            int i102 = ((i3 >> 6) & 112) | i8 | (i92 & 896) | (i92 & 7168) | ((i3 << 3) & i4);
                            composer2 = startRestartGroup;
                            SurfaceKt.m1782SurfaceFjzlyU(SemanticsModifierKt.semantics$default(OnRemeasuredModifierKt.onSizeChanged(anchoredDraggable$default2, (Function1) rememberedValue2), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2
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
                                    if (BottomSheetState.this.getAnchoredDraggableState$material_release().getAnchors().getSize() > 1) {
                                        if (BottomSheetState.this.isCollapsed()) {
                                            final BottomSheetState bottomSheetState2 = BottomSheetState.this;
                                            final CoroutineScope coroutineScope22 = coroutineScope2;
                                            SemanticsPropertiesKt.expand$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                /* compiled from: BottomSheetScaffold.kt */
                                                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                                @DebugMetadata(c = "androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2$1$1", f = "BottomSheetScaffold.kt", i = {}, l = {636}, m = "invokeSuspend", n = {}, s = {})
                                                /* renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2$1$1, reason: invalid class name and collision with other inner class name */
                                                static final class C00371 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                    final /* synthetic */ BottomSheetState $state;
                                                    int label;

                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    C00371(BottomSheetState bottomSheetState, Continuation<? super C00371> continuation) {
                                                        super(2, continuation);
                                                        this.$state = bottomSheetState;
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                        return new C00371(this.$state, continuation);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                        return ((C00371) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    public final Object invokeSuspend(Object obj) {
                                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                        int i = this.label;
                                                        if (i == 0) {
                                                            ResultKt.throwOnFailure(obj);
                                                            this.label = 1;
                                                            if (this.$state.expand(this) == coroutine_suspended) {
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
                                                    if (BottomSheetState.this.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(BottomSheetValue.Expanded).booleanValue()) {
                                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope22, null, null, new C00371(BottomSheetState.this, null), 3, null);
                                                    }
                                                    return true;
                                                }
                                            }, 1, null);
                                        } else {
                                            final BottomSheetState bottomSheetState3 = BottomSheetState.this;
                                            final CoroutineScope coroutineScope3 = coroutineScope2;
                                            SemanticsPropertiesKt.collapse$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                /* compiled from: BottomSheetScaffold.kt */
                                                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                                @DebugMetadata(c = "androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2$2$1", f = "BottomSheetScaffold.kt", i = {}, l = {643}, m = "invokeSuspend", n = {}, s = {})
                                                /* renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2$2$1, reason: invalid class name */
                                                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                    final /* synthetic */ BottomSheetState $state;
                                                    int label;

                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    AnonymousClass1(BottomSheetState bottomSheetState, Continuation<? super AnonymousClass1> continuation) {
                                                        super(2, continuation);
                                                        this.$state = bottomSheetState;
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                        return new AnonymousClass1(this.$state, continuation);
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
                                                            if (this.$state.collapse(this) == coroutine_suspended) {
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
                                                    if (BottomSheetState.this.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(BottomSheetValue.Collapsed).booleanValue()) {
                                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new AnonymousClass1(BottomSheetState.this, null), 3, null);
                                                    }
                                                    return true;
                                                }
                                            }, 1, null);
                                        }
                                    }
                                }
                            }, 1, null), shape2, j, j3, null, f2, ComposableLambdaKt.composableLambda(startRestartGroup, 1944994153, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$3
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

                                public final void invoke(Composer composer3, int i11) {
                                    ComposerKt.sourceInformation(composer3, "C653@27892L25:BottomSheetScaffold.kt#jmzs0o");
                                    if ((i11 & 11) == 2 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1944994153, i11, -1, "androidx.compose.material.BottomSheet.<anonymous> (BottomSheetScaffold.kt:653)");
                                    }
                                    Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                                    composer3.startReplaceableGroup(-483455358);
                                    ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                    Modifier.Companion companion2 = Modifier.INSTANCE;
                                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                    composer3.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion2);
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
                                    Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                    composer3.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                    function32.invoke(ColumnScopeInstance.INSTANCE, composer3, 6);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    composer3.endReplaceableGroup();
                                    composer3.endNode();
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer2, i102, 16);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier3 = modifier42;
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                            }
                        }
                    }
                    i5 = 1572864;
                    j3 = j2;
                    int i82 = i5;
                    i6 = i2 & 128;
                    if (i6 != 0) {
                    }
                    if ((i2 & 256) == 0) {
                    }
                    i3 |= i7;
                    if ((191739611 & i3) == 38347922) {
                    }
                    if (i6 == 0) {
                    }
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
                    Modifier modifier422 = modifier2;
                    Modifier anchoredDraggable$default22 = AnchoredDraggableKt.anchoredDraggable$default(modifier422, bottomSheetState.getAnchoredDraggableState$material_release(), Orientation.Vertical, z, false, null, false, 56, null);
                    startRestartGroup.startReplaceableGroup(1938016202);
                    changedInstance = startRestartGroup.changedInstance(function1) | startRestartGroup.changed(bottomSheetState);
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (!changedInstance) {
                    }
                    rememberedValue2 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$1$1

                        /* compiled from: BottomSheetScaffold.kt */
                        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                        public /* synthetic */ class WhenMappings {
                            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                            static {
                                int[] iArr = new int[BottomSheetValue.values().length];
                                try {
                                    iArr[BottomSheetValue.Collapsed.ordinal()] = 1;
                                } catch (NoSuchFieldError unused) {
                                }
                                try {
                                    iArr[BottomSheetValue.Expanded.ordinal()] = 2;
                                } catch (NoSuchFieldError unused2) {
                                }
                                $EnumSwitchMapping$0 = iArr;
                            }
                        }

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                            m1565invokeozmzZPI(intSize.getPackedValue());
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                        public final void m1565invokeozmzZPI(long j4) {
                            BottomSheetValue bottomSheetValue;
                            DraggableAnchors<BottomSheetValue> invoke = function1.invoke(IntSize.m6551boximpl(j4));
                            int i922 = WhenMappings.$EnumSwitchMapping$0[bottomSheetState.getAnchoredDraggableState$material_release().getTargetValue().ordinal()];
                            if (i922 == 1) {
                                bottomSheetValue = BottomSheetValue.Collapsed;
                            } else {
                                if (i922 != 2) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                bottomSheetValue = invoke.hasAnchorFor(BottomSheetValue.Expanded) ? BottomSheetValue.Expanded : BottomSheetValue.Collapsed;
                            }
                            bottomSheetState.getAnchoredDraggableState$material_release().updateAnchors(invoke, bottomSheetValue);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                    startRestartGroup.endReplaceableGroup();
                    int i922 = i3 >> 9;
                    int i1022 = ((i3 >> 6) & 112) | i82 | (i922 & 896) | (i922 & 7168) | ((i3 << 3) & i4);
                    composer2 = startRestartGroup;
                    SurfaceKt.m1782SurfaceFjzlyU(SemanticsModifierKt.semantics$default(OnRemeasuredModifierKt.onSizeChanged(anchoredDraggable$default22, (Function1) rememberedValue2), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2
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
                            if (BottomSheetState.this.getAnchoredDraggableState$material_release().getAnchors().getSize() > 1) {
                                if (BottomSheetState.this.isCollapsed()) {
                                    final BottomSheetState bottomSheetState2 = BottomSheetState.this;
                                    final CoroutineScope coroutineScope222 = coroutineScope22;
                                    SemanticsPropertiesKt.expand$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        /* compiled from: BottomSheetScaffold.kt */
                                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                        @DebugMetadata(c = "androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2$1$1", f = "BottomSheetScaffold.kt", i = {}, l = {636}, m = "invokeSuspend", n = {}, s = {})
                                        /* renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2$1$1, reason: invalid class name and collision with other inner class name */
                                        static final class C00371 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                            final /* synthetic */ BottomSheetState $state;
                                            int label;

                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            C00371(BottomSheetState bottomSheetState, Continuation<? super C00371> continuation) {
                                                super(2, continuation);
                                                this.$state = bottomSheetState;
                                            }

                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                return new C00371(this.$state, continuation);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                return ((C00371) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                            }

                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                            public final Object invokeSuspend(Object obj) {
                                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                int i = this.label;
                                                if (i == 0) {
                                                    ResultKt.throwOnFailure(obj);
                                                    this.label = 1;
                                                    if (this.$state.expand(this) == coroutine_suspended) {
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
                                            if (BottomSheetState.this.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(BottomSheetValue.Expanded).booleanValue()) {
                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope222, null, null, new C00371(BottomSheetState.this, null), 3, null);
                                            }
                                            return true;
                                        }
                                    }, 1, null);
                                } else {
                                    final BottomSheetState bottomSheetState3 = BottomSheetState.this;
                                    final CoroutineScope coroutineScope3 = coroutineScope22;
                                    SemanticsPropertiesKt.collapse$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        /* compiled from: BottomSheetScaffold.kt */
                                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                        @DebugMetadata(c = "androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2$2$1", f = "BottomSheetScaffold.kt", i = {}, l = {643}, m = "invokeSuspend", n = {}, s = {})
                                        /* renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2$2$1, reason: invalid class name */
                                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                            final /* synthetic */ BottomSheetState $state;
                                            int label;

                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            AnonymousClass1(BottomSheetState bottomSheetState, Continuation<? super AnonymousClass1> continuation) {
                                                super(2, continuation);
                                                this.$state = bottomSheetState;
                                            }

                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                return new AnonymousClass1(this.$state, continuation);
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
                                                    if (this.$state.collapse(this) == coroutine_suspended) {
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
                                            if (BottomSheetState.this.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(BottomSheetValue.Collapsed).booleanValue()) {
                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new AnonymousClass1(BottomSheetState.this, null), 3, null);
                                            }
                                            return true;
                                        }
                                    }, 1, null);
                                }
                            }
                        }
                    }, 1, null), shape2, j, j3, null, f2, ComposableLambdaKt.composableLambda(startRestartGroup, 1944994153, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$3
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

                        public final void invoke(Composer composer3, int i11) {
                            ComposerKt.sourceInformation(composer3, "C653@27892L25:BottomSheetScaffold.kt#jmzs0o");
                            if ((i11 & 11) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1944994153, i11, -1, "androidx.compose.material.BottomSheet.<anonymous> (BottomSheetScaffold.kt:653)");
                            }
                            Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                            composer3.startReplaceableGroup(-483455358);
                            ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                            Modifier.Companion companion2 = Modifier.INSTANCE;
                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                            composer3.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion2);
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
                            Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                            composer3.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                            function32.invoke(ColumnScopeInstance.INSTANCE, composer3, 6);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endReplaceableGroup();
                            composer3.endNode();
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, i1022, 16);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier422;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                f2 = f;
                if ((i2 & 32) == 0) {
                }
                if ((i2 & 64) == 0) {
                }
                i5 = 1572864;
                j3 = j2;
                int i822 = i5;
                i6 = i2 & 128;
                if (i6 != 0) {
                }
                if ((i2 & 256) == 0) {
                }
                i3 |= i7;
                if ((191739611 & i3) == 38347922) {
                }
                if (i6 == 0) {
                }
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
                Modifier modifier4222 = modifier2;
                Modifier anchoredDraggable$default222 = AnchoredDraggableKt.anchoredDraggable$default(modifier4222, bottomSheetState.getAnchoredDraggableState$material_release(), Orientation.Vertical, z, false, null, false, 56, null);
                startRestartGroup.startReplaceableGroup(1938016202);
                changedInstance = startRestartGroup.changedInstance(function1) | startRestartGroup.changed(bottomSheetState);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!changedInstance) {
                }
                rememberedValue2 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$1$1

                    /* compiled from: BottomSheetScaffold.kt */
                    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                    public /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] iArr = new int[BottomSheetValue.values().length];
                            try {
                                iArr[BottomSheetValue.Collapsed.ordinal()] = 1;
                            } catch (NoSuchFieldError unused) {
                            }
                            try {
                                iArr[BottomSheetValue.Expanded.ordinal()] = 2;
                            } catch (NoSuchFieldError unused2) {
                            }
                            $EnumSwitchMapping$0 = iArr;
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                        m1565invokeozmzZPI(intSize.getPackedValue());
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                    public final void m1565invokeozmzZPI(long j4) {
                        BottomSheetValue bottomSheetValue;
                        DraggableAnchors<BottomSheetValue> invoke = function1.invoke(IntSize.m6551boximpl(j4));
                        int i9222 = WhenMappings.$EnumSwitchMapping$0[bottomSheetState.getAnchoredDraggableState$material_release().getTargetValue().ordinal()];
                        if (i9222 == 1) {
                            bottomSheetValue = BottomSheetValue.Collapsed;
                        } else {
                            if (i9222 != 2) {
                                throw new NoWhenBranchMatchedException();
                            }
                            bottomSheetValue = invoke.hasAnchorFor(BottomSheetValue.Expanded) ? BottomSheetValue.Expanded : BottomSheetValue.Collapsed;
                        }
                        bottomSheetState.getAnchoredDraggableState$material_release().updateAnchors(invoke, bottomSheetValue);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
                startRestartGroup.endReplaceableGroup();
                int i9222 = i3 >> 9;
                int i10222 = ((i3 >> 6) & 112) | i822 | (i9222 & 896) | (i9222 & 7168) | ((i3 << 3) & i4);
                composer2 = startRestartGroup;
                SurfaceKt.m1782SurfaceFjzlyU(SemanticsModifierKt.semantics$default(OnRemeasuredModifierKt.onSizeChanged(anchoredDraggable$default222, (Function1) rememberedValue2), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2
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
                        if (BottomSheetState.this.getAnchoredDraggableState$material_release().getAnchors().getSize() > 1) {
                            if (BottomSheetState.this.isCollapsed()) {
                                final BottomSheetState bottomSheetState2 = BottomSheetState.this;
                                final CoroutineScope coroutineScope2222 = coroutineScope222;
                                SemanticsPropertiesKt.expand$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* compiled from: BottomSheetScaffold.kt */
                                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                    @DebugMetadata(c = "androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2$1$1", f = "BottomSheetScaffold.kt", i = {}, l = {636}, m = "invokeSuspend", n = {}, s = {})
                                    /* renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2$1$1, reason: invalid class name and collision with other inner class name */
                                    static final class C00371 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        final /* synthetic */ BottomSheetState $state;
                                        int label;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        C00371(BottomSheetState bottomSheetState, Continuation<? super C00371> continuation) {
                                            super(2, continuation);
                                            this.$state = bottomSheetState;
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            return new C00371(this.$state, continuation);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                            return ((C00371) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Object invokeSuspend(Object obj) {
                                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            int i = this.label;
                                            if (i == 0) {
                                                ResultKt.throwOnFailure(obj);
                                                this.label = 1;
                                                if (this.$state.expand(this) == coroutine_suspended) {
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
                                        if (BottomSheetState.this.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(BottomSheetValue.Expanded).booleanValue()) {
                                            BuildersKt__Builders_commonKt.launch$default(coroutineScope2222, null, null, new C00371(BottomSheetState.this, null), 3, null);
                                        }
                                        return true;
                                    }
                                }, 1, null);
                            } else {
                                final BottomSheetState bottomSheetState3 = BottomSheetState.this;
                                final CoroutineScope coroutineScope3 = coroutineScope222;
                                SemanticsPropertiesKt.collapse$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* compiled from: BottomSheetScaffold.kt */
                                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                    @DebugMetadata(c = "androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2$2$1", f = "BottomSheetScaffold.kt", i = {}, l = {643}, m = "invokeSuspend", n = {}, s = {})
                                    /* renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2$2$1, reason: invalid class name */
                                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        final /* synthetic */ BottomSheetState $state;
                                        int label;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        AnonymousClass1(BottomSheetState bottomSheetState, Continuation<? super AnonymousClass1> continuation) {
                                            super(2, continuation);
                                            this.$state = bottomSheetState;
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            return new AnonymousClass1(this.$state, continuation);
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
                                                if (this.$state.collapse(this) == coroutine_suspended) {
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
                                        if (BottomSheetState.this.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(BottomSheetValue.Collapsed).booleanValue()) {
                                            BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new AnonymousClass1(BottomSheetState.this, null), 3, null);
                                        }
                                        return true;
                                    }
                                }, 1, null);
                            }
                        }
                    }
                }, 1, null), shape2, j, j3, null, f2, ComposableLambdaKt.composableLambda(startRestartGroup, 1944994153, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$3
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

                    public final void invoke(Composer composer3, int i11) {
                        ComposerKt.sourceInformation(composer3, "C653@27892L25:BottomSheetScaffold.kt#jmzs0o");
                        if ((i11 & 11) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1944994153, i11, -1, "androidx.compose.material.BottomSheet.<anonymous> (BottomSheetScaffold.kt:653)");
                        }
                        Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                        composer3.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                        Modifier.Companion companion2 = Modifier.INSTANCE;
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion2);
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
                        Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                        function32.invoke(ColumnScopeInstance.INSTANCE, composer3, 6);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer2, i10222, 16);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier4222;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            shape2 = shape;
            if ((i2 & 16) != 0) {
            }
            f2 = f;
            if ((i2 & 32) == 0) {
            }
            if ((i2 & 64) == 0) {
            }
            i5 = 1572864;
            j3 = j2;
            int i8222 = i5;
            i6 = i2 & 128;
            if (i6 != 0) {
            }
            if ((i2 & 256) == 0) {
            }
            i3 |= i7;
            if ((191739611 & i3) == 38347922) {
            }
            if (i6 == 0) {
            }
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
            Modifier modifier42222 = modifier2;
            Modifier anchoredDraggable$default2222 = AnchoredDraggableKt.anchoredDraggable$default(modifier42222, bottomSheetState.getAnchoredDraggableState$material_release(), Orientation.Vertical, z, false, null, false, 56, null);
            startRestartGroup.startReplaceableGroup(1938016202);
            changedInstance = startRestartGroup.changedInstance(function1) | startRestartGroup.changed(bottomSheetState);
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!changedInstance) {
            }
            rememberedValue2 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$1$1

                /* compiled from: BottomSheetScaffold.kt */
                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[BottomSheetValue.values().length];
                        try {
                            iArr[BottomSheetValue.Collapsed.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[BottomSheetValue.Expanded.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                    m1565invokeozmzZPI(intSize.getPackedValue());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                public final void m1565invokeozmzZPI(long j4) {
                    BottomSheetValue bottomSheetValue;
                    DraggableAnchors<BottomSheetValue> invoke = function1.invoke(IntSize.m6551boximpl(j4));
                    int i92222 = WhenMappings.$EnumSwitchMapping$0[bottomSheetState.getAnchoredDraggableState$material_release().getTargetValue().ordinal()];
                    if (i92222 == 1) {
                        bottomSheetValue = BottomSheetValue.Collapsed;
                    } else {
                        if (i92222 != 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        bottomSheetValue = invoke.hasAnchorFor(BottomSheetValue.Expanded) ? BottomSheetValue.Expanded : BottomSheetValue.Collapsed;
                    }
                    bottomSheetState.getAnchoredDraggableState$material_release().updateAnchors(invoke, bottomSheetValue);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue2);
            startRestartGroup.endReplaceableGroup();
            int i92222 = i3 >> 9;
            int i102222 = ((i3 >> 6) & 112) | i8222 | (i92222 & 896) | (i92222 & 7168) | ((i3 << 3) & i4);
            composer2 = startRestartGroup;
            SurfaceKt.m1782SurfaceFjzlyU(SemanticsModifierKt.semantics$default(OnRemeasuredModifierKt.onSizeChanged(anchoredDraggable$default2222, (Function1) rememberedValue2), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2
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
                    if (BottomSheetState.this.getAnchoredDraggableState$material_release().getAnchors().getSize() > 1) {
                        if (BottomSheetState.this.isCollapsed()) {
                            final BottomSheetState bottomSheetState2 = BottomSheetState.this;
                            final CoroutineScope coroutineScope22222 = coroutineScope2222;
                            SemanticsPropertiesKt.expand$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* compiled from: BottomSheetScaffold.kt */
                                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                @DebugMetadata(c = "androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2$1$1", f = "BottomSheetScaffold.kt", i = {}, l = {636}, m = "invokeSuspend", n = {}, s = {})
                                /* renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2$1$1, reason: invalid class name and collision with other inner class name */
                                static final class C00371 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ BottomSheetState $state;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    C00371(BottomSheetState bottomSheetState, Continuation<? super C00371> continuation) {
                                        super(2, continuation);
                                        this.$state = bottomSheetState;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new C00371(this.$state, continuation);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                        return ((C00371) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object obj) {
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        int i = this.label;
                                        if (i == 0) {
                                            ResultKt.throwOnFailure(obj);
                                            this.label = 1;
                                            if (this.$state.expand(this) == coroutine_suspended) {
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
                                    if (BottomSheetState.this.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(BottomSheetValue.Expanded).booleanValue()) {
                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope22222, null, null, new C00371(BottomSheetState.this, null), 3, null);
                                    }
                                    return true;
                                }
                            }, 1, null);
                        } else {
                            final BottomSheetState bottomSheetState3 = BottomSheetState.this;
                            final CoroutineScope coroutineScope3 = coroutineScope2222;
                            SemanticsPropertiesKt.collapse$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* compiled from: BottomSheetScaffold.kt */
                                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                @DebugMetadata(c = "androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2$2$1", f = "BottomSheetScaffold.kt", i = {}, l = {643}, m = "invokeSuspend", n = {}, s = {})
                                /* renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2$2$1, reason: invalid class name */
                                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ BottomSheetState $state;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    AnonymousClass1(BottomSheetState bottomSheetState, Continuation<? super AnonymousClass1> continuation) {
                                        super(2, continuation);
                                        this.$state = bottomSheetState;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new AnonymousClass1(this.$state, continuation);
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
                                            if (this.$state.collapse(this) == coroutine_suspended) {
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
                                    if (BottomSheetState.this.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(BottomSheetValue.Collapsed).booleanValue()) {
                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new AnonymousClass1(BottomSheetState.this, null), 3, null);
                                    }
                                    return true;
                                }
                            }, 1, null);
                        }
                    }
                }
            }, 1, null), shape2, j, j3, null, f2, ComposableLambdaKt.composableLambda(startRestartGroup, 1944994153, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$3
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

                public final void invoke(Composer composer3, int i11) {
                    ComposerKt.sourceInformation(composer3, "C653@27892L25:BottomSheetScaffold.kt#jmzs0o");
                    if ((i11 & 11) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1944994153, i11, -1, "androidx.compose.material.BottomSheet.<anonymous> (BottomSheetScaffold.kt:653)");
                    }
                    Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                    composer3.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion2);
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
                    Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                    function32.invoke(ColumnScopeInstance.INSTANCE, composer3, 6);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composer2, i102222, 16);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier42222;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        if ((i2 & 4) == 0) {
        }
        if ((i2 & 8) == 0) {
        }
        shape2 = shape;
        if ((i2 & 16) != 0) {
        }
        f2 = f;
        if ((i2 & 32) == 0) {
        }
        if ((i2 & 64) == 0) {
        }
        i5 = 1572864;
        j3 = j2;
        int i82222 = i5;
        i6 = i2 & 128;
        if (i6 != 0) {
        }
        if ((i2 & 256) == 0) {
        }
        i3 |= i7;
        if ((191739611 & i3) == 38347922) {
        }
        if (i6 == 0) {
        }
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
        final CoroutineScope coroutineScope22222 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
        startRestartGroup.endReplaceableGroup();
        Modifier modifier422222 = modifier2;
        Modifier anchoredDraggable$default22222 = AnchoredDraggableKt.anchoredDraggable$default(modifier422222, bottomSheetState.getAnchoredDraggableState$material_release(), Orientation.Vertical, z, false, null, false, 56, null);
        startRestartGroup.startReplaceableGroup(1938016202);
        changedInstance = startRestartGroup.changedInstance(function1) | startRestartGroup.changed(bottomSheetState);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!changedInstance) {
        }
        rememberedValue2 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$1$1

            /* compiled from: BottomSheetScaffold.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[BottomSheetValue.values().length];
                    try {
                        iArr[BottomSheetValue.Collapsed.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[BottomSheetValue.Expanded.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                m1565invokeozmzZPI(intSize.getPackedValue());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-ozmzZPI, reason: not valid java name */
            public final void m1565invokeozmzZPI(long j4) {
                BottomSheetValue bottomSheetValue;
                DraggableAnchors<BottomSheetValue> invoke = function1.invoke(IntSize.m6551boximpl(j4));
                int i922222 = WhenMappings.$EnumSwitchMapping$0[bottomSheetState.getAnchoredDraggableState$material_release().getTargetValue().ordinal()];
                if (i922222 == 1) {
                    bottomSheetValue = BottomSheetValue.Collapsed;
                } else {
                    if (i922222 != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    bottomSheetValue = invoke.hasAnchorFor(BottomSheetValue.Expanded) ? BottomSheetValue.Expanded : BottomSheetValue.Collapsed;
                }
                bottomSheetState.getAnchoredDraggableState$material_release().updateAnchors(invoke, bottomSheetValue);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue2);
        startRestartGroup.endReplaceableGroup();
        int i922222 = i3 >> 9;
        int i1022222 = ((i3 >> 6) & 112) | i82222 | (i922222 & 896) | (i922222 & 7168) | ((i3 << 3) & i4);
        composer2 = startRestartGroup;
        SurfaceKt.m1782SurfaceFjzlyU(SemanticsModifierKt.semantics$default(OnRemeasuredModifierKt.onSizeChanged(anchoredDraggable$default22222, (Function1) rememberedValue2), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2
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
                if (BottomSheetState.this.getAnchoredDraggableState$material_release().getAnchors().getSize() > 1) {
                    if (BottomSheetState.this.isCollapsed()) {
                        final BottomSheetState bottomSheetState2 = BottomSheetState.this;
                        final CoroutineScope coroutineScope222222 = coroutineScope22222;
                        SemanticsPropertiesKt.expand$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* compiled from: BottomSheetScaffold.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                            @DebugMetadata(c = "androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2$1$1", f = "BottomSheetScaffold.kt", i = {}, l = {636}, m = "invokeSuspend", n = {}, s = {})
                            /* renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2$1$1, reason: invalid class name and collision with other inner class name */
                            static final class C00371 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ BottomSheetState $state;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                C00371(BottomSheetState bottomSheetState, Continuation<? super C00371> continuation) {
                                    super(2, continuation);
                                    this.$state = bottomSheetState;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new C00371(this.$state, continuation);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return ((C00371) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i = this.label;
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        this.label = 1;
                                        if (this.$state.expand(this) == coroutine_suspended) {
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
                                if (BottomSheetState.this.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(BottomSheetValue.Expanded).booleanValue()) {
                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope222222, null, null, new C00371(BottomSheetState.this, null), 3, null);
                                }
                                return true;
                            }
                        }, 1, null);
                    } else {
                        final BottomSheetState bottomSheetState3 = BottomSheetState.this;
                        final CoroutineScope coroutineScope3 = coroutineScope22222;
                        SemanticsPropertiesKt.collapse$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* compiled from: BottomSheetScaffold.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                            @DebugMetadata(c = "androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2$2$1", f = "BottomSheetScaffold.kt", i = {}, l = {643}, m = "invokeSuspend", n = {}, s = {})
                            /* renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$2$2$1, reason: invalid class name */
                            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ BottomSheetState $state;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass1(BottomSheetState bottomSheetState, Continuation<? super AnonymousClass1> continuation) {
                                    super(2, continuation);
                                    this.$state = bottomSheetState;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new AnonymousClass1(this.$state, continuation);
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
                                        if (this.$state.collapse(this) == coroutine_suspended) {
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
                                if (BottomSheetState.this.getAnchoredDraggableState$material_release().getConfirmValueChange$material_release().invoke(BottomSheetValue.Collapsed).booleanValue()) {
                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new AnonymousClass1(BottomSheetState.this, null), 3, null);
                                }
                                return true;
                            }
                        }, 1, null);
                    }
                }
            }
        }, 1, null), shape2, j, j3, null, f2, ComposableLambdaKt.composableLambda(startRestartGroup, 1944994153, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheet$3
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

            public final void invoke(Composer composer3, int i11) {
                ComposerKt.sourceInformation(composer3, "C653@27892L25:BottomSheetScaffold.kt#jmzs0o");
                if ((i11 & 11) == 2 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1944994153, i11, -1, "androidx.compose.material.BottomSheet.<anonymous> (BottomSheetScaffold.kt:653)");
                }
                Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                composer3.startReplaceableGroup(-483455358);
                ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                Modifier.Companion companion2 = Modifier.INSTANCE;
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                composer3.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion2);
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
                Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                composer3.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                function32.invoke(ColumnScopeInstance.INSTANCE, composer3, 6);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endReplaceableGroup();
                composer3.endNode();
                composer3.endReplaceableGroup();
                composer3.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composer2, i1022222, 16);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier422222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: BottomSheetScaffoldLayout-KCBPh4w, reason: not valid java name */
    public static final void m1562BottomSheetScaffoldLayoutKCBPh4w(final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, final Function3<? super Integer, ? super Composer, ? super Integer, Unit> function32, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final float f, final int i, final Function0<Float> function0, final BottomSheetState bottomSheetState, Composer composer, final int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(1621720523);
        ComposerKt.sourceInformation(startRestartGroup, "C(BottomSheetScaffoldLayout)P(8!3,7,5:c#ui.unit.Dp,3:c#material.FabPosition)687@28825L3007:BottomSheetScaffold.kt#jmzs0o");
        if ((i2 & 14) == 0) {
            i3 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 112) == 0) {
            i3 |= startRestartGroup.changedInstance(function3) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            i3 |= startRestartGroup.changedInstance(function32) ? 256 : 128;
        }
        if ((i2 & 7168) == 0) {
            i3 |= startRestartGroup.changedInstance(function22) ? 2048 : 1024;
        }
        if ((57344 & i2) == 0) {
            i3 |= startRestartGroup.changedInstance(function23) ? 16384 : 8192;
        }
        if ((458752 & i2) == 0) {
            i3 |= startRestartGroup.changed(f) ? 131072 : 65536;
        }
        if ((3670016 & i2) == 0) {
            i3 |= startRestartGroup.changed(i) ? 1048576 : 524288;
        }
        if ((29360128 & i2) == 0) {
            i3 |= startRestartGroup.changedInstance(function0) ? 8388608 : 4194304;
        }
        if ((234881024 & i2) == 0) {
            i3 |= startRestartGroup.changed(bottomSheetState) ? 67108864 : 33554432;
        }
        if ((191739611 & i3) != 38347922 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1621720523, i3, -1, "androidx.compose.material.BottomSheetScaffoldLayout (BottomSheetScaffold.kt:686)");
            }
            startRestartGroup.startReplaceableGroup(1938018646);
            boolean changedInstance = startRestartGroup.changedInstance(function32) | startRestartGroup.changedInstance(function2) | startRestartGroup.changedInstance(function3) | startRestartGroup.changed(f) | startRestartGroup.changedInstance(function22) | startRestartGroup.changedInstance(function23) | startRestartGroup.changedInstance(function0) | startRestartGroup.changed(i) | startRestartGroup.changed(bottomSheetState);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                        return m1567invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                    }

                    /* JADX WARN: Removed duplicated region for block: B:106:0x0151  */
                    /* JADX WARN: Removed duplicated region for block: B:21:0x0107 A[LOOP:2: B:20:0x0105->B:21:0x0107, LOOP_END] */
                    /* JADX WARN: Removed duplicated region for block: B:25:0x0125  */
                    /* JADX WARN: Removed duplicated region for block: B:31:0x0154  */
                    /* JADX WARN: Removed duplicated region for block: B:38:0x0194  */
                    /* JADX WARN: Removed duplicated region for block: B:46:0x01f6 A[LOOP:4: B:45:0x01f4->B:46:0x01f6, LOOP_END] */
                    /* JADX WARN: Removed duplicated region for block: B:50:0x0215  */
                    /* JADX WARN: Removed duplicated region for block: B:53:0x0243  */
                    /* JADX WARN: Removed duplicated region for block: B:56:0x0250  */
                    /* JADX WARN: Removed duplicated region for block: B:59:0x0280  */
                    /* JADX WARN: Removed duplicated region for block: B:63:0x0286  */
                    /* JADX WARN: Removed duplicated region for block: B:64:0x0252  */
                    /* JADX WARN: Removed duplicated region for block: B:72:0x0249  */
                    /* JADX WARN: Removed duplicated region for block: B:73:0x0217  */
                    /* JADX WARN: Removed duplicated region for block: B:94:0x01db  */
                    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final MeasureResult m1567invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, long j) {
                        final ArrayList arrayList;
                        final int i4;
                        int size;
                        int i5;
                        Function2<Composer, Integer, Unit> function24;
                        ArrayList arrayList2;
                        final int i6;
                        int i7;
                        final int i8;
                        int size2;
                        int i9;
                        final ArrayList arrayList3;
                        Object obj;
                        Object obj2;
                        Object obj3;
                        Object obj4;
                        Object obj5;
                        int m6345getMaxWidthimpl = Constraints.m6345getMaxWidthimpl(j);
                        final int m6344getMaxHeightimpl = Constraints.m6344getMaxHeightimpl(j);
                        long m6336copyZbe2FdA$default = Constraints.m6336copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
                        BottomSheetScaffoldLayoutSlot bottomSheetScaffoldLayoutSlot = BottomSheetScaffoldLayoutSlot.Sheet;
                        final Function3<Integer, Composer, Integer, Unit> function33 = function32;
                        List<Measurable> subcompose = subcomposeMeasureScope.subcompose(bottomSheetScaffoldLayoutSlot, ComposableLambdaKt.composableLambdaInstance(-170696743, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$sheetPlaceables$1
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

                            public final void invoke(Composer composer2, int i10) {
                                ComposerKt.sourceInformation(composer2, "C693@29125L25:BottomSheetScaffold.kt#jmzs0o");
                                if ((i10 & 11) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-170696743, i10, -1, "androidx.compose.material.BottomSheetScaffoldLayout.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:693)");
                                }
                                function33.invoke(Integer.valueOf(m6344getMaxHeightimpl), composer2, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }));
                        ArrayList arrayList4 = new ArrayList(subcompose.size());
                        int size3 = subcompose.size();
                        for (int i10 = 0; i10 < size3; i10++) {
                            arrayList4.add(subcompose.get(i10).mo5333measureBRTryo0(m6336copyZbe2FdA$default));
                        }
                        final ArrayList arrayList5 = arrayList4;
                        Function2<Composer, Integer, Unit> function25 = function2;
                        if (function25 != null) {
                            List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(BottomSheetScaffoldLayoutSlot.TopBar, function25);
                            ArrayList arrayList6 = new ArrayList(subcompose2.size());
                            int size4 = subcompose2.size();
                            for (int i11 = 0; i11 < size4; i11++) {
                                arrayList6.add(subcompose2.get(i11).mo5333measureBRTryo0(m6336copyZbe2FdA$default));
                            }
                            arrayList = arrayList6;
                        } else {
                            arrayList = null;
                        }
                        if (arrayList != null) {
                            if (arrayList.isEmpty()) {
                                obj5 = null;
                            } else {
                                obj5 = arrayList.get(0);
                                int height = ((Placeable) obj5).getHeight();
                                int lastIndex = CollectionsKt.getLastIndex(arrayList);
                                if (1 <= lastIndex) {
                                    int i12 = 1;
                                    while (true) {
                                        Object obj6 = arrayList.get(i12);
                                        int height2 = ((Placeable) obj6).getHeight();
                                        if (height < height2) {
                                            height = height2;
                                            obj5 = obj6;
                                        }
                                        if (i12 == lastIndex) {
                                            break;
                                        }
                                        i12++;
                                    }
                                }
                            }
                            Placeable placeable = (Placeable) obj5;
                            if (placeable != null) {
                                i4 = placeable.getHeight();
                                long m6336copyZbe2FdA$default2 = Constraints.m6336copyZbe2FdA$default(m6336copyZbe2FdA$default, 0, 0, 0, m6344getMaxHeightimpl - i4, 7, null);
                                BottomSheetScaffoldLayoutSlot bottomSheetScaffoldLayoutSlot2 = BottomSheetScaffoldLayoutSlot.Body;
                                final Function3<PaddingValues, Composer, Integer, Unit> function34 = function3;
                                final float f2 = f;
                                List<Measurable> subcompose3 = subcomposeMeasureScope.subcompose(bottomSheetScaffoldLayoutSlot2, ComposableLambdaKt.composableLambdaInstance(-389342674, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$bodyPlaceables$1
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

                                    public final void invoke(Composer composer2, int i13) {
                                        ComposerKt.sourceInformation(composer2, "C704@29651L45:BottomSheetScaffold.kt#jmzs0o");
                                        if ((i13 & 11) == 2 && composer2.getSkipping()) {
                                            composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-389342674, i13, -1, "androidx.compose.material.BottomSheetScaffoldLayout.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:704)");
                                        }
                                        function34.invoke(PaddingKt.m876PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, f2, 7, null), composer2, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }));
                                ArrayList arrayList7 = new ArrayList(subcompose3.size());
                                size = subcompose3.size();
                                for (i5 = 0; i5 < size; i5++) {
                                    arrayList7.add(subcompose3.get(i5).mo5333measureBRTryo0(m6336copyZbe2FdA$default2));
                                }
                                final ArrayList arrayList8 = arrayList7;
                                function24 = function22;
                                if (function24 == null) {
                                    List<Measurable> subcompose4 = subcomposeMeasureScope.subcompose(BottomSheetScaffoldLayoutSlot.Fab, function24);
                                    ArrayList arrayList9 = new ArrayList(subcompose4.size());
                                    int size5 = subcompose4.size();
                                    for (int i13 = 0; i13 < size5; i13++) {
                                        arrayList9.add(subcompose4.get(i13).mo5333measureBRTryo0(m6336copyZbe2FdA$default));
                                    }
                                    arrayList2 = arrayList9;
                                } else {
                                    arrayList2 = null;
                                }
                                if (arrayList2 != null) {
                                    if (arrayList2.isEmpty()) {
                                        obj4 = null;
                                    } else {
                                        obj4 = arrayList2.get(0);
                                        int width = ((Placeable) obj4).getWidth();
                                        int lastIndex2 = CollectionsKt.getLastIndex(arrayList2);
                                        if (1 <= lastIndex2) {
                                            Object obj7 = obj4;
                                            int i14 = width;
                                            int i15 = 1;
                                            while (true) {
                                                Object obj8 = arrayList2.get(i15);
                                                int width2 = ((Placeable) obj8).getWidth();
                                                if (i14 < width2) {
                                                    obj7 = obj8;
                                                    i14 = width2;
                                                }
                                                if (i15 == lastIndex2) {
                                                    break;
                                                }
                                                i15++;
                                            }
                                            obj4 = obj7;
                                        }
                                    }
                                    Placeable placeable2 = (Placeable) obj4;
                                    if (placeable2 != null) {
                                        i6 = placeable2.getWidth();
                                        if (arrayList2 != null) {
                                            if (arrayList2.isEmpty()) {
                                                i7 = m6345getMaxWidthimpl;
                                                obj3 = null;
                                            } else {
                                                obj3 = arrayList2.get(0);
                                                int height3 = ((Placeable) obj3).getHeight();
                                                int lastIndex3 = CollectionsKt.getLastIndex(arrayList2);
                                                if (1 <= lastIndex3) {
                                                    Object obj9 = obj3;
                                                    int i16 = height3;
                                                    int i17 = 1;
                                                    while (true) {
                                                        Object obj10 = arrayList2.get(i17);
                                                        i7 = m6345getMaxWidthimpl;
                                                        int height4 = ((Placeable) obj10).getHeight();
                                                        if (i16 < height4) {
                                                            i16 = height4;
                                                            obj9 = obj10;
                                                        }
                                                        if (i17 == lastIndex3) {
                                                            break;
                                                        }
                                                        i17++;
                                                        m6345getMaxWidthimpl = i7;
                                                    }
                                                    obj3 = obj9;
                                                } else {
                                                    i7 = m6345getMaxWidthimpl;
                                                }
                                            }
                                            Placeable placeable3 = (Placeable) obj3;
                                            if (placeable3 != null) {
                                                i8 = placeable3.getHeight();
                                                List<Measurable> subcompose5 = subcomposeMeasureScope.subcompose(BottomSheetScaffoldLayoutSlot.Snackbar, function23);
                                                ArrayList arrayList10 = new ArrayList(subcompose5.size());
                                                size2 = subcompose5.size();
                                                i9 = 0;
                                                while (i9 < size2) {
                                                    arrayList10.add(subcompose5.get(i9).mo5333measureBRTryo0(m6336copyZbe2FdA$default));
                                                    i9++;
                                                    subcompose5 = subcompose5;
                                                }
                                                arrayList3 = arrayList10;
                                                if (arrayList3.isEmpty()) {
                                                    obj = arrayList3.get(0);
                                                    int width3 = ((Placeable) obj).getWidth();
                                                    int lastIndex4 = CollectionsKt.getLastIndex(arrayList3);
                                                    if (1 <= lastIndex4) {
                                                        int i18 = 1;
                                                        while (true) {
                                                            Object obj11 = arrayList3.get(i18);
                                                            int width4 = ((Placeable) obj11).getWidth();
                                                            if (width3 < width4) {
                                                                obj = obj11;
                                                                width3 = width4;
                                                            }
                                                            if (i18 == lastIndex4) {
                                                                break;
                                                            }
                                                            i18++;
                                                        }
                                                    }
                                                } else {
                                                    obj = null;
                                                }
                                                Placeable placeable4 = (Placeable) obj;
                                                final int width5 = placeable4 == null ? placeable4.getWidth() : 0;
                                                if (arrayList3.isEmpty()) {
                                                    obj2 = arrayList3.get(0);
                                                    int height5 = ((Placeable) obj2).getHeight();
                                                    int lastIndex5 = CollectionsKt.getLastIndex(arrayList3);
                                                    int i19 = 1;
                                                    if (1 <= lastIndex5) {
                                                        while (true) {
                                                            Object obj12 = arrayList3.get(i19);
                                                            int height6 = ((Placeable) obj12).getHeight();
                                                            if (height5 < height6) {
                                                                height5 = height6;
                                                                obj2 = obj12;
                                                            }
                                                            if (i19 == lastIndex5) {
                                                                break;
                                                            }
                                                            i19++;
                                                        }
                                                    }
                                                } else {
                                                    obj2 = null;
                                                }
                                                Placeable placeable5 = (Placeable) obj2;
                                                final int height7 = placeable5 == null ? placeable5.getHeight() : 0;
                                                final Function0<Float> function02 = function0;
                                                final ArrayList arrayList11 = arrayList2;
                                                final int i20 = i;
                                                final float f3 = f;
                                                final BottomSheetState bottomSheetState2 = bottomSheetState;
                                                final int i21 = i7;
                                                return MeasureScope.layout$default(subcomposeMeasureScope, i21, m6344getMaxHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1.1

                                                    /* compiled from: BottomSheetScaffold.kt */
                                                    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                                                    /* renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$1$WhenMappings */
                                                    public /* synthetic */ class WhenMappings {
                                                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                                        static {
                                                            int[] iArr = new int[BottomSheetValue.values().length];
                                                            try {
                                                                iArr[BottomSheetValue.Collapsed.ordinal()] = 1;
                                                            } catch (NoSuchFieldError unused) {
                                                            }
                                                            try {
                                                                iArr[BottomSheetValue.Expanded.ordinal()] = 2;
                                                            } catch (NoSuchFieldError unused2) {
                                                            }
                                                            $EnumSwitchMapping$0 = iArr;
                                                        }
                                                    }

                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                        invoke2(placementScope);
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(Placeable.PlacementScope placementScope) {
                                                        float f4;
                                                        int i22;
                                                        int i23;
                                                        int i24;
                                                        float f5;
                                                        float f6;
                                                        int roundToInt = MathKt.roundToInt(function02.invoke().floatValue());
                                                        int i25 = i20;
                                                        if (FabPosition.m1675equalsimpl0(i25, FabPosition.INSTANCE.m1681getStart5ygKITE())) {
                                                            SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                                            f6 = BottomSheetScaffoldKt.FabSpacing;
                                                            i22 = subcomposeMeasureScope2.mo624roundToPx0680j_4(f6);
                                                        } else if (FabPosition.m1675equalsimpl0(i25, FabPosition.INSTANCE.m1679getCenter5ygKITE())) {
                                                            i22 = (i21 - i6) / 2;
                                                        } else {
                                                            int i26 = i21 - i6;
                                                            SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope;
                                                            f4 = BottomSheetScaffoldKt.FabSpacing;
                                                            i22 = i26 - subcomposeMeasureScope3.mo624roundToPx0680j_4(f4);
                                                        }
                                                        float f7 = subcomposeMeasureScope.mo630toPx0680j_4(f3);
                                                        int i27 = i8;
                                                        if (f7 < i27 / 2) {
                                                            int i28 = roundToInt - i27;
                                                            SubcomposeMeasureScope subcomposeMeasureScope4 = subcomposeMeasureScope;
                                                            f5 = BottomSheetScaffoldKt.FabSpacing;
                                                            i23 = i28 - subcomposeMeasureScope4.mo624roundToPx0680j_4(f5);
                                                        } else {
                                                            i23 = roundToInt - (i27 / 2);
                                                        }
                                                        int i29 = i23;
                                                        int i30 = (i21 - width5) / 2;
                                                        int i31 = WhenMappings.$EnumSwitchMapping$0[bottomSheetState2.getCurrentValue().ordinal()];
                                                        if (i31 == 1) {
                                                            i24 = i29 - height7;
                                                        } else {
                                                            if (i31 != 2) {
                                                                throw new NoWhenBranchMatchedException();
                                                            }
                                                            i24 = m6344getMaxHeightimpl - height7;
                                                        }
                                                        int i32 = i24;
                                                        List<Placeable> list = arrayList8;
                                                        int i33 = i4;
                                                        int size6 = list.size();
                                                        for (int i34 = 0; i34 < size6; i34++) {
                                                            Placeable.PlacementScope.placeRelative$default(placementScope, list.get(i34), 0, i33, 0.0f, 4, null);
                                                        }
                                                        List<Placeable> list2 = arrayList;
                                                        if (list2 != null) {
                                                            int size7 = list2.size();
                                                            for (int i35 = 0; i35 < size7; i35++) {
                                                                Placeable.PlacementScope.placeRelative$default(placementScope, list2.get(i35), 0, 0, 0.0f, 4, null);
                                                            }
                                                        }
                                                        List<Placeable> list3 = arrayList5;
                                                        int size8 = list3.size();
                                                        for (int i36 = 0; i36 < size8; i36++) {
                                                            Placeable.PlacementScope.placeRelative$default(placementScope, list3.get(i36), 0, roundToInt, 0.0f, 4, null);
                                                        }
                                                        List<Placeable> list4 = arrayList11;
                                                        if (list4 != null) {
                                                            int size9 = list4.size();
                                                            for (int i37 = 0; i37 < size9; i37++) {
                                                                Placeable.PlacementScope.placeRelative$default(placementScope, list4.get(i37), i22, i29, 0.0f, 4, null);
                                                            }
                                                        }
                                                        List<Placeable> list5 = arrayList3;
                                                        int size10 = list5.size();
                                                        int i38 = 0;
                                                        while (i38 < size10) {
                                                            int i39 = i30;
                                                            int i40 = i32;
                                                            Placeable.PlacementScope.placeRelative$default(placementScope, list5.get(i38), i39, i40, 0.0f, 4, null);
                                                            i38++;
                                                            i32 = i40;
                                                            i30 = i39;
                                                        }
                                                    }
                                                }, 4, null);
                                            }
                                        } else {
                                            i7 = m6345getMaxWidthimpl;
                                        }
                                        i8 = 0;
                                        List<Measurable> subcompose52 = subcomposeMeasureScope.subcompose(BottomSheetScaffoldLayoutSlot.Snackbar, function23);
                                        ArrayList arrayList102 = new ArrayList(subcompose52.size());
                                        size2 = subcompose52.size();
                                        i9 = 0;
                                        while (i9 < size2) {
                                        }
                                        arrayList3 = arrayList102;
                                        if (arrayList3.isEmpty()) {
                                        }
                                        Placeable placeable42 = (Placeable) obj;
                                        if (placeable42 == null) {
                                        }
                                        if (arrayList3.isEmpty()) {
                                        }
                                        Placeable placeable52 = (Placeable) obj2;
                                        if (placeable52 == null) {
                                        }
                                        final Function0<Float> function022 = function0;
                                        final List<? extends Placeable> arrayList112 = arrayList2;
                                        final int i202 = i;
                                        final float f32 = f;
                                        final BottomSheetState bottomSheetState22 = bottomSheetState;
                                        final int i212 = i7;
                                        return MeasureScope.layout$default(subcomposeMeasureScope, i212, m6344getMaxHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1.1

                                            /* compiled from: BottomSheetScaffold.kt */
                                            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                                            /* renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$1$WhenMappings */
                                            public /* synthetic */ class WhenMappings {
                                                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                                static {
                                                    int[] iArr = new int[BottomSheetValue.values().length];
                                                    try {
                                                        iArr[BottomSheetValue.Collapsed.ordinal()] = 1;
                                                    } catch (NoSuchFieldError unused) {
                                                    }
                                                    try {
                                                        iArr[BottomSheetValue.Expanded.ordinal()] = 2;
                                                    } catch (NoSuchFieldError unused2) {
                                                    }
                                                    $EnumSwitchMapping$0 = iArr;
                                                }
                                            }

                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                invoke2(placementScope);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(Placeable.PlacementScope placementScope) {
                                                float f4;
                                                int i22;
                                                int i23;
                                                int i24;
                                                float f5;
                                                float f6;
                                                int roundToInt = MathKt.roundToInt(function022.invoke().floatValue());
                                                int i25 = i202;
                                                if (FabPosition.m1675equalsimpl0(i25, FabPosition.INSTANCE.m1681getStart5ygKITE())) {
                                                    SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                                    f6 = BottomSheetScaffoldKt.FabSpacing;
                                                    i22 = subcomposeMeasureScope2.mo624roundToPx0680j_4(f6);
                                                } else if (FabPosition.m1675equalsimpl0(i25, FabPosition.INSTANCE.m1679getCenter5ygKITE())) {
                                                    i22 = (i212 - i6) / 2;
                                                } else {
                                                    int i26 = i212 - i6;
                                                    SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope;
                                                    f4 = BottomSheetScaffoldKt.FabSpacing;
                                                    i22 = i26 - subcomposeMeasureScope3.mo624roundToPx0680j_4(f4);
                                                }
                                                float f7 = subcomposeMeasureScope.mo630toPx0680j_4(f32);
                                                int i27 = i8;
                                                if (f7 < i27 / 2) {
                                                    int i28 = roundToInt - i27;
                                                    SubcomposeMeasureScope subcomposeMeasureScope4 = subcomposeMeasureScope;
                                                    f5 = BottomSheetScaffoldKt.FabSpacing;
                                                    i23 = i28 - subcomposeMeasureScope4.mo624roundToPx0680j_4(f5);
                                                } else {
                                                    i23 = roundToInt - (i27 / 2);
                                                }
                                                int i29 = i23;
                                                int i30 = (i212 - width5) / 2;
                                                int i31 = WhenMappings.$EnumSwitchMapping$0[bottomSheetState22.getCurrentValue().ordinal()];
                                                if (i31 == 1) {
                                                    i24 = i29 - height7;
                                                } else {
                                                    if (i31 != 2) {
                                                        throw new NoWhenBranchMatchedException();
                                                    }
                                                    i24 = m6344getMaxHeightimpl - height7;
                                                }
                                                int i32 = i24;
                                                List<Placeable> list = arrayList8;
                                                int i33 = i4;
                                                int size6 = list.size();
                                                for (int i34 = 0; i34 < size6; i34++) {
                                                    Placeable.PlacementScope.placeRelative$default(placementScope, list.get(i34), 0, i33, 0.0f, 4, null);
                                                }
                                                List<Placeable> list2 = arrayList;
                                                if (list2 != null) {
                                                    int size7 = list2.size();
                                                    for (int i35 = 0; i35 < size7; i35++) {
                                                        Placeable.PlacementScope.placeRelative$default(placementScope, list2.get(i35), 0, 0, 0.0f, 4, null);
                                                    }
                                                }
                                                List<Placeable> list3 = arrayList5;
                                                int size8 = list3.size();
                                                for (int i36 = 0; i36 < size8; i36++) {
                                                    Placeable.PlacementScope.placeRelative$default(placementScope, list3.get(i36), 0, roundToInt, 0.0f, 4, null);
                                                }
                                                List<Placeable> list4 = arrayList112;
                                                if (list4 != null) {
                                                    int size9 = list4.size();
                                                    for (int i37 = 0; i37 < size9; i37++) {
                                                        Placeable.PlacementScope.placeRelative$default(placementScope, list4.get(i37), i22, i29, 0.0f, 4, null);
                                                    }
                                                }
                                                List<Placeable> list5 = arrayList3;
                                                int size10 = list5.size();
                                                int i38 = 0;
                                                while (i38 < size10) {
                                                    int i39 = i30;
                                                    int i40 = i32;
                                                    Placeable.PlacementScope.placeRelative$default(placementScope, list5.get(i38), i39, i40, 0.0f, 4, null);
                                                    i38++;
                                                    i32 = i40;
                                                    i30 = i39;
                                                }
                                            }
                                        }, 4, null);
                                    }
                                }
                                i6 = 0;
                                if (arrayList2 != null) {
                                }
                                i8 = 0;
                                List<Measurable> subcompose522 = subcomposeMeasureScope.subcompose(BottomSheetScaffoldLayoutSlot.Snackbar, function23);
                                ArrayList arrayList1022 = new ArrayList(subcompose522.size());
                                size2 = subcompose522.size();
                                i9 = 0;
                                while (i9 < size2) {
                                }
                                arrayList3 = arrayList1022;
                                if (arrayList3.isEmpty()) {
                                }
                                Placeable placeable422 = (Placeable) obj;
                                if (placeable422 == null) {
                                }
                                if (arrayList3.isEmpty()) {
                                }
                                Placeable placeable522 = (Placeable) obj2;
                                if (placeable522 == null) {
                                }
                                final Function0<Float> function0222 = function0;
                                final List<? extends Placeable> arrayList1122 = arrayList2;
                                final int i2022 = i;
                                final float f322 = f;
                                final BottomSheetState bottomSheetState222 = bottomSheetState;
                                final int i2122 = i7;
                                return MeasureScope.layout$default(subcomposeMeasureScope, i2122, m6344getMaxHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1.1

                                    /* compiled from: BottomSheetScaffold.kt */
                                    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                                    /* renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$1$WhenMappings */
                                    public /* synthetic */ class WhenMappings {
                                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                        static {
                                            int[] iArr = new int[BottomSheetValue.values().length];
                                            try {
                                                iArr[BottomSheetValue.Collapsed.ordinal()] = 1;
                                            } catch (NoSuchFieldError unused) {
                                            }
                                            try {
                                                iArr[BottomSheetValue.Expanded.ordinal()] = 2;
                                            } catch (NoSuchFieldError unused2) {
                                            }
                                            $EnumSwitchMapping$0 = iArr;
                                        }
                                    }

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                        invoke2(placementScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Placeable.PlacementScope placementScope) {
                                        float f4;
                                        int i22;
                                        int i23;
                                        int i24;
                                        float f5;
                                        float f6;
                                        int roundToInt = MathKt.roundToInt(function0222.invoke().floatValue());
                                        int i25 = i2022;
                                        if (FabPosition.m1675equalsimpl0(i25, FabPosition.INSTANCE.m1681getStart5ygKITE())) {
                                            SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                            f6 = BottomSheetScaffoldKt.FabSpacing;
                                            i22 = subcomposeMeasureScope2.mo624roundToPx0680j_4(f6);
                                        } else if (FabPosition.m1675equalsimpl0(i25, FabPosition.INSTANCE.m1679getCenter5ygKITE())) {
                                            i22 = (i2122 - i6) / 2;
                                        } else {
                                            int i26 = i2122 - i6;
                                            SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope;
                                            f4 = BottomSheetScaffoldKt.FabSpacing;
                                            i22 = i26 - subcomposeMeasureScope3.mo624roundToPx0680j_4(f4);
                                        }
                                        float f7 = subcomposeMeasureScope.mo630toPx0680j_4(f322);
                                        int i27 = i8;
                                        if (f7 < i27 / 2) {
                                            int i28 = roundToInt - i27;
                                            SubcomposeMeasureScope subcomposeMeasureScope4 = subcomposeMeasureScope;
                                            f5 = BottomSheetScaffoldKt.FabSpacing;
                                            i23 = i28 - subcomposeMeasureScope4.mo624roundToPx0680j_4(f5);
                                        } else {
                                            i23 = roundToInt - (i27 / 2);
                                        }
                                        int i29 = i23;
                                        int i30 = (i2122 - width5) / 2;
                                        int i31 = WhenMappings.$EnumSwitchMapping$0[bottomSheetState222.getCurrentValue().ordinal()];
                                        if (i31 == 1) {
                                            i24 = i29 - height7;
                                        } else {
                                            if (i31 != 2) {
                                                throw new NoWhenBranchMatchedException();
                                            }
                                            i24 = m6344getMaxHeightimpl - height7;
                                        }
                                        int i32 = i24;
                                        List<Placeable> list = arrayList8;
                                        int i33 = i4;
                                        int size6 = list.size();
                                        for (int i34 = 0; i34 < size6; i34++) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, list.get(i34), 0, i33, 0.0f, 4, null);
                                        }
                                        List<Placeable> list2 = arrayList;
                                        if (list2 != null) {
                                            int size7 = list2.size();
                                            for (int i35 = 0; i35 < size7; i35++) {
                                                Placeable.PlacementScope.placeRelative$default(placementScope, list2.get(i35), 0, 0, 0.0f, 4, null);
                                            }
                                        }
                                        List<Placeable> list3 = arrayList5;
                                        int size8 = list3.size();
                                        for (int i36 = 0; i36 < size8; i36++) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, list3.get(i36), 0, roundToInt, 0.0f, 4, null);
                                        }
                                        List<Placeable> list4 = arrayList1122;
                                        if (list4 != null) {
                                            int size9 = list4.size();
                                            for (int i37 = 0; i37 < size9; i37++) {
                                                Placeable.PlacementScope.placeRelative$default(placementScope, list4.get(i37), i22, i29, 0.0f, 4, null);
                                            }
                                        }
                                        List<Placeable> list5 = arrayList3;
                                        int size10 = list5.size();
                                        int i38 = 0;
                                        while (i38 < size10) {
                                            int i39 = i30;
                                            int i40 = i32;
                                            Placeable.PlacementScope.placeRelative$default(placementScope, list5.get(i38), i39, i40, 0.0f, 4, null);
                                            i38++;
                                            i32 = i40;
                                            i30 = i39;
                                        }
                                    }
                                }, 4, null);
                            }
                        }
                        i4 = 0;
                        long m6336copyZbe2FdA$default22 = Constraints.m6336copyZbe2FdA$default(m6336copyZbe2FdA$default, 0, 0, 0, m6344getMaxHeightimpl - i4, 7, null);
                        BottomSheetScaffoldLayoutSlot bottomSheetScaffoldLayoutSlot22 = BottomSheetScaffoldLayoutSlot.Body;
                        final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function342 = function3;
                        final float f22 = f;
                        List<Measurable> subcompose32 = subcomposeMeasureScope.subcompose(bottomSheetScaffoldLayoutSlot22, ComposableLambdaKt.composableLambdaInstance(-389342674, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$bodyPlaceables$1
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

                            public final void invoke(Composer composer2, int i132) {
                                ComposerKt.sourceInformation(composer2, "C704@29651L45:BottomSheetScaffold.kt#jmzs0o");
                                if ((i132 & 11) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-389342674, i132, -1, "androidx.compose.material.BottomSheetScaffoldLayout.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:704)");
                                }
                                function342.invoke(PaddingKt.m876PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, f22, 7, null), composer2, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }));
                        ArrayList arrayList72 = new ArrayList(subcompose32.size());
                        size = subcompose32.size();
                        while (i5 < size) {
                        }
                        final List<? extends Placeable> arrayList82 = arrayList72;
                        function24 = function22;
                        if (function24 == null) {
                        }
                        if (arrayList2 != null) {
                        }
                        i6 = 0;
                        if (arrayList2 != null) {
                        }
                        i8 = 0;
                        List<Measurable> subcompose5222 = subcomposeMeasureScope.subcompose(BottomSheetScaffoldLayoutSlot.Snackbar, function23);
                        ArrayList arrayList10222 = new ArrayList(subcompose5222.size());
                        size2 = subcompose5222.size();
                        i9 = 0;
                        while (i9 < size2) {
                        }
                        arrayList3 = arrayList10222;
                        if (arrayList3.isEmpty()) {
                        }
                        Placeable placeable4222 = (Placeable) obj;
                        if (placeable4222 == null) {
                        }
                        if (arrayList3.isEmpty()) {
                        }
                        Placeable placeable5222 = (Placeable) obj2;
                        if (placeable5222 == null) {
                        }
                        final Function0<Float> function02222 = function0;
                        final List<? extends Placeable> arrayList11222 = arrayList2;
                        final int i20222 = i;
                        final float f3222 = f;
                        final BottomSheetState bottomSheetState2222 = bottomSheetState;
                        final int i21222 = i7;
                        return MeasureScope.layout$default(subcomposeMeasureScope, i21222, m6344getMaxHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1.1

                            /* compiled from: BottomSheetScaffold.kt */
                            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                            /* renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$1$WhenMappings */
                            public /* synthetic */ class WhenMappings {
                                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                static {
                                    int[] iArr = new int[BottomSheetValue.values().length];
                                    try {
                                        iArr[BottomSheetValue.Collapsed.ordinal()] = 1;
                                    } catch (NoSuchFieldError unused) {
                                    }
                                    try {
                                        iArr[BottomSheetValue.Expanded.ordinal()] = 2;
                                    } catch (NoSuchFieldError unused2) {
                                    }
                                    $EnumSwitchMapping$0 = iArr;
                                }
                            }

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Placeable.PlacementScope placementScope) {
                                float f4;
                                int i22;
                                int i23;
                                int i24;
                                float f5;
                                float f6;
                                int roundToInt = MathKt.roundToInt(function02222.invoke().floatValue());
                                int i25 = i20222;
                                if (FabPosition.m1675equalsimpl0(i25, FabPosition.INSTANCE.m1681getStart5ygKITE())) {
                                    SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                    f6 = BottomSheetScaffoldKt.FabSpacing;
                                    i22 = subcomposeMeasureScope2.mo624roundToPx0680j_4(f6);
                                } else if (FabPosition.m1675equalsimpl0(i25, FabPosition.INSTANCE.m1679getCenter5ygKITE())) {
                                    i22 = (i21222 - i6) / 2;
                                } else {
                                    int i26 = i21222 - i6;
                                    SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope;
                                    f4 = BottomSheetScaffoldKt.FabSpacing;
                                    i22 = i26 - subcomposeMeasureScope3.mo624roundToPx0680j_4(f4);
                                }
                                float f7 = subcomposeMeasureScope.mo630toPx0680j_4(f3222);
                                int i27 = i8;
                                if (f7 < i27 / 2) {
                                    int i28 = roundToInt - i27;
                                    SubcomposeMeasureScope subcomposeMeasureScope4 = subcomposeMeasureScope;
                                    f5 = BottomSheetScaffoldKt.FabSpacing;
                                    i23 = i28 - subcomposeMeasureScope4.mo624roundToPx0680j_4(f5);
                                } else {
                                    i23 = roundToInt - (i27 / 2);
                                }
                                int i29 = i23;
                                int i30 = (i21222 - width5) / 2;
                                int i31 = WhenMappings.$EnumSwitchMapping$0[bottomSheetState2222.getCurrentValue().ordinal()];
                                if (i31 == 1) {
                                    i24 = i29 - height7;
                                } else {
                                    if (i31 != 2) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    i24 = m6344getMaxHeightimpl - height7;
                                }
                                int i32 = i24;
                                List<Placeable> list = arrayList82;
                                int i33 = i4;
                                int size6 = list.size();
                                for (int i34 = 0; i34 < size6; i34++) {
                                    Placeable.PlacementScope.placeRelative$default(placementScope, list.get(i34), 0, i33, 0.0f, 4, null);
                                }
                                List<Placeable> list2 = arrayList;
                                if (list2 != null) {
                                    int size7 = list2.size();
                                    for (int i35 = 0; i35 < size7; i35++) {
                                        Placeable.PlacementScope.placeRelative$default(placementScope, list2.get(i35), 0, 0, 0.0f, 4, null);
                                    }
                                }
                                List<Placeable> list3 = arrayList5;
                                int size8 = list3.size();
                                for (int i36 = 0; i36 < size8; i36++) {
                                    Placeable.PlacementScope.placeRelative$default(placementScope, list3.get(i36), 0, roundToInt, 0.0f, 4, null);
                                }
                                List<Placeable> list4 = arrayList11222;
                                if (list4 != null) {
                                    int size9 = list4.size();
                                    for (int i37 = 0; i37 < size9; i37++) {
                                        Placeable.PlacementScope.placeRelative$default(placementScope, list4.get(i37), i22, i29, 0.0f, 4, null);
                                    }
                                }
                                List<Placeable> list5 = arrayList3;
                                int size10 = list5.size();
                                int i38 = 0;
                                while (i38 < size10) {
                                    int i39 = i30;
                                    int i40 = i32;
                                    Placeable.PlacementScope.placeRelative$default(placementScope, list5.get(i38), i39, i40, 0.0f, 4, null);
                                    i38++;
                                    i32 = i40;
                                    i30 = i39;
                                }
                            }
                        }, 4, null);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(null, (Function2) rememberedValue, startRestartGroup, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2
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

                public final void invoke(Composer composer2, int i4) {
                    BottomSheetScaffoldKt.m1562BottomSheetScaffoldLayoutKCBPh4w(function2, function3, function32, function22, function23, f, i, function0, bottomSheetState, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(AnchoredDraggableState<?> anchoredDraggableState, Orientation orientation) {
        return new BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1(anchoredDraggableState, orientation);
    }
}
