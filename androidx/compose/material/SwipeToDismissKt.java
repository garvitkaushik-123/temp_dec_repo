package androidx.compose.material;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.messaging.Constants;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: SwipeToDismiss.kt */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0081\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e0\r2\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\r¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\r¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0002\u0010\u0014\u001a\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0002\u001a-\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u00172\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001c0\rH\u0007¢\u0006\u0002\u0010\u001d\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006\u001e"}, d2 = {"DISMISS_THRESHOLD", "Landroidx/compose/ui/unit/Dp;", "F", "SwipeToDismiss", "", "state", "Landroidx/compose/material/DismissState;", "modifier", "Landroidx/compose/ui/Modifier;", "directions", "", "Landroidx/compose/material/DismissDirection;", "dismissThresholds", "Lkotlin/Function1;", "Landroidx/compose/material/ThresholdConfig;", "background", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "dismissContent", "(Landroidx/compose/material/DismissState;Landroidx/compose/ui/Modifier;Ljava/util/Set;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "getDismissDirection", Constants.MessagePayloadKeys.FROM, "Landroidx/compose/material/DismissValue;", "to", "rememberDismissState", "initialValue", "confirmStateChange", "", "(Landroidx/compose/material/DismissValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/DismissState;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SwipeToDismissKt {
    private static final float DISMISS_THRESHOLD = Dp.m6389constructorimpl(56);

    public static final DismissState rememberDismissState(final DismissValue dismissValue, final Function1<? super DismissValue, Boolean> function1, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1753522702);
        ComposerKt.sourceInformation(composer, "C(rememberDismissState)P(1)153@5407L127:SwipeToDismiss.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            dismissValue = DismissValue.Default;
        }
        if ((i2 & 2) != 0) {
            function1 = new Function1<DismissValue, Boolean>() { // from class: androidx.compose.material.SwipeToDismissKt$rememberDismissState$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(DismissValue dismissValue2) {
                    return true;
                }
            };
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1753522702, i, -1, "androidx.compose.material.rememberDismissState (SwipeToDismiss.kt:152)");
        }
        Object[] objArr = new Object[0];
        Saver<DismissState, DismissValue> Saver = DismissState.INSTANCE.Saver(function1);
        composer.startReplaceableGroup(96529381);
        boolean changed = composer.changed(dismissValue) | composer.changedInstance(function1);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = (Function0) new Function0<DismissState>() { // from class: androidx.compose.material.SwipeToDismissKt$rememberDismissState$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final DismissState invoke() {
                    return new DismissState(DismissValue.this, function1);
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        DismissState dismissState = (DismissState) RememberSaveableKt.m3680rememberSaveable(objArr, (Saver) Saver, (String) null, (Function0) rememberedValue, composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return dismissState;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SwipeToDismiss(final DismissState dismissState, Modifier modifier, Set<? extends DismissDirection> set, Function1<? super DismissDirection, ? extends ThresholdConfig> function1, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32, Composer composer, final int i, final int i2) {
        DismissState dismissState2;
        int i3;
        Modifier modifier2;
        int i4;
        int i5;
        Function1<? super DismissDirection, ? extends ThresholdConfig> function12;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33;
        final Set<? extends DismissDirection> set2;
        final Modifier modifier3;
        final Function1<? super DismissDirection, ? extends ThresholdConfig> function13;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(634380143);
        ComposerKt.sourceInformation(startRestartGroup, "C(SwipeToDismiss)P(5,4,1,3)182@6627L1407:SwipeToDismiss.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            dismissState2 = dismissState;
        } else if ((i & 14) == 0) {
            dismissState2 = dismissState;
            i3 = (startRestartGroup.changed(dismissState2) ? 4 : 2) | i;
        } else {
            dismissState2 = dismissState;
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
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
                function12 = function1;
                i3 |= startRestartGroup.changedInstance(function12) ? 2048 : 1024;
                if ((i2 & 16) != 0) {
                    i3 |= 24576;
                } else if ((57344 & i) == 0) {
                    function33 = function3;
                    i3 |= startRestartGroup.changedInstance(function33) ? 16384 : 8192;
                    if ((i2 & 32) == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((458752 & i) == 0) {
                        i3 |= startRestartGroup.changedInstance(function32) ? 131072 : 65536;
                        if (i4 == 4 || (374491 & i3) != 74898 || !startRestartGroup.getSkipping()) {
                            Modifier.Companion companion = i6 != 0 ? Modifier.INSTANCE : modifier2;
                            final Set<? extends DismissDirection> of = i4 != 0 ? SetsKt.setOf((Object[]) new DismissDirection[]{DismissDirection.EndToStart, DismissDirection.StartToEnd}) : set;
                            final Function1<? super DismissDirection, ? extends ThresholdConfig> function14 = i5 != 0 ? new Function1<DismissDirection, FixedThreshold>() { // from class: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$1
                                @Override // kotlin.jvm.functions.Function1
                                public final FixedThreshold invoke(DismissDirection dismissDirection) {
                                    float f;
                                    f = SwipeToDismissKt.DISMISS_THRESHOLD;
                                    return new FixedThreshold(f, null);
                                }
                            } : function12;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(634380143, i3, -1, "androidx.compose.material.SwipeToDismiss (SwipeToDismiss.kt:182)");
                            }
                            final DismissState dismissState3 = dismissState2;
                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function34 = function33;
                            set2 = of;
                            Modifier modifier4 = companion;
                            BoxWithConstraintsKt.BoxWithConstraints(modifier4, null, false, ComposableLambdaKt.composableLambda(startRestartGroup, 338007641, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2
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

                                public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, int i7) {
                                    BoxWithConstraintsScope boxWithConstraintsScope2;
                                    int i8;
                                    Modifier m1792swipeablepPrIpRY;
                                    ComposerKt.sourceInformation(composer2, "C184@6742L7,197@7314L718:SwipeToDismiss.kt#jmzs0o");
                                    if ((i7 & 14) == 0) {
                                        boxWithConstraintsScope2 = boxWithConstraintsScope;
                                        i8 = i7 | (composer2.changed(boxWithConstraintsScope2) ? 4 : 2);
                                    } else {
                                        boxWithConstraintsScope2 = boxWithConstraintsScope;
                                        i8 = i7;
                                    }
                                    if ((i8 & 91) != 18 || !composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(338007641, i8, -1, "androidx.compose.material.SwipeToDismiss.<anonymous> (SwipeToDismiss.kt:183)");
                                        }
                                        float m6345getMaxWidthimpl = Constraints.m6345getMaxWidthimpl(boxWithConstraintsScope2.mo815getConstraintsmsEJaDk());
                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                        Object consume = composer2.consume(localLayoutDirection);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        boolean z = consume == LayoutDirection.Rtl;
                                        Map mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to(Float.valueOf(0.0f), DismissValue.Default));
                                        if (of.contains(DismissDirection.StartToEnd)) {
                                            Pair pair = TuplesKt.to(Float.valueOf(m6345getMaxWidthimpl), DismissValue.DismissedToEnd);
                                            mutableMapOf.put(pair.getFirst(), pair.getSecond());
                                        }
                                        if (of.contains(DismissDirection.EndToStart)) {
                                            Pair pair2 = TuplesKt.to(Float.valueOf(-m6345getMaxWidthimpl), DismissValue.DismissedToStart);
                                            mutableMapOf.put(pair2.getFirst(), pair2.getSecond());
                                        }
                                        composer2.startReplaceableGroup(96530892);
                                        boolean changedInstance = composer2.changedInstance(function14);
                                        final Function1<DismissDirection, ThresholdConfig> function15 = function14;
                                        Object rememberedValue = composer2.rememberedValue();
                                        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue = (Function2) new Function2<DismissValue, DismissValue, ThresholdConfig>() { // from class: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2$thresholds$1$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public final ThresholdConfig invoke(DismissValue dismissValue, DismissValue dismissValue2) {
                                                    DismissDirection dismissDirection;
                                                    Function1<DismissDirection, ThresholdConfig> function16 = function15;
                                                    dismissDirection = SwipeToDismissKt.getDismissDirection(dismissValue, dismissValue2);
                                                    Intrinsics.checkNotNull(dismissDirection);
                                                    return function16.invoke(dismissDirection);
                                                }
                                            };
                                            composer2.updateRememberedValue(rememberedValue);
                                        }
                                        Function2 function2 = (Function2) rememberedValue;
                                        composer2.endReplaceableGroup();
                                        m1792swipeablepPrIpRY = SwipeableKt.m1792swipeablepPrIpRY(Modifier.INSTANCE, dismissState3, mutableMapOf, Orientation.Horizontal, (r26 & 8) != 0 ? true : dismissState3.getCurrentValue() == DismissValue.Default, (r26 & 16) != 0 ? false : z, (r26 & 32) != 0 ? null : null, (r26 & 64) != 0 ? new Function2<T, T, FixedThreshold>() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function2
                                            public final FixedThreshold invoke(T t, T t2) {
                                                return new FixedThreshold(Dp.m6389constructorimpl(56), null);
                                            }
                                        } : function2, (r26 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, mutableMapOf.keySet(), 0.0f, 0.0f, 6, null) : new ResistanceConfig(m6345getMaxWidthimpl, of.contains(DismissDirection.EndToStart) ? 10.0f : 20.0f, of.contains(DismissDirection.StartToEnd) ? 10.0f : 20.0f), (r26 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1791getVelocityThresholdD9Ej5fM() : 0.0f);
                                        Function3<RowScope, Composer, Integer, Unit> function35 = function34;
                                        final DismissState dismissState4 = dismissState3;
                                        Function3<RowScope, Composer, Integer, Unit> function36 = function32;
                                        composer2.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                                        composer2.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m1792swipeablepPrIpRY);
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
                                        ComposerKt.sourceInformationMarkerStart(composer2, 565741225, "C212@7778L98,216@7885L141:SwipeToDismiss.kt#jmzs0o");
                                        Modifier matchParentSize = boxScopeInstance.matchParentSize(Modifier.INSTANCE);
                                        composer2.startReplaceableGroup(693286680);
                                        ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer2, 0);
                                        composer2.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                        CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(matchParentSize);
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
                                        Updater.m3600setimpl(m3593constructorimpl2, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                            m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                            m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                        }
                                        modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                                        composer2.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                        function35.invoke(RowScopeInstance.INSTANCE, composer2, 6);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        composer2.endReplaceableGroup();
                                        composer2.endNode();
                                        composer2.endReplaceableGroup();
                                        composer2.endReplaceableGroup();
                                        Modifier.Companion companion2 = Modifier.INSTANCE;
                                        composer2.startReplaceableGroup(96531876);
                                        boolean changed = composer2.changed(dismissState4);
                                        Object rememberedValue2 = composer2.rememberedValue();
                                        if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue2 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2$1$1$1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ IntOffset invoke(Density density) {
                                                    return IntOffset.m6508boximpl(m1790invokeBjo55l4(density));
                                                }

                                                /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                                                public final long m1790invokeBjo55l4(Density density) {
                                                    return IntOffsetKt.IntOffset(MathKt.roundToInt(DismissState.this.getOffset().getValue().floatValue()), 0);
                                                }
                                            };
                                            composer2.updateRememberedValue(rememberedValue2);
                                        }
                                        composer2.endReplaceableGroup();
                                        Modifier offset = OffsetKt.offset(companion2, (Function1) rememberedValue2);
                                        composer2.startReplaceableGroup(693286680);
                                        ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                        MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer2, 0);
                                        composer2.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                        CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(offset);
                                        if (!(composer2.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer2.startReusableNode();
                                        if (composer2.getInserting()) {
                                            composer2.createNode(constructor3);
                                        } else {
                                            composer2.useNode();
                                        }
                                        Composer m3593constructorimpl3 = Updater.m3593constructorimpl(composer2);
                                        Updater.m3600setimpl(m3593constructorimpl3, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3600setimpl(m3593constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (m3593constructorimpl3.getInserting() || !Intrinsics.areEqual(m3593constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                            m3593constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                            m3593constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                        }
                                        modifierMaterializerOf3.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                                        composer2.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                        function36.invoke(RowScopeInstance.INSTANCE, composer2, 6);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        composer2.endReplaceableGroup();
                                        composer2.endNode();
                                        composer2.endReplaceableGroup();
                                        composer2.endReplaceableGroup();
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
                            }), startRestartGroup, ((i3 >> 3) & 14) | 3072, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            function13 = function14;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            set2 = set;
                            modifier3 = modifier2;
                            function13 = function12;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$3
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

                                public final void invoke(Composer composer2, int i7) {
                                    SwipeToDismissKt.SwipeToDismiss(DismissState.this, modifier3, set2, function13, function3, function32, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if (i4 == 4) {
                    }
                    if (i6 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    final DismissState dismissState32 = dismissState2;
                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function342 = function33;
                    set2 = of;
                    Modifier modifier42 = companion;
                    BoxWithConstraintsKt.BoxWithConstraints(modifier42, null, false, ComposableLambdaKt.composableLambda(startRestartGroup, 338007641, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2
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

                        public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, int i7) {
                            BoxWithConstraintsScope boxWithConstraintsScope2;
                            int i8;
                            Modifier m1792swipeablepPrIpRY;
                            ComposerKt.sourceInformation(composer2, "C184@6742L7,197@7314L718:SwipeToDismiss.kt#jmzs0o");
                            if ((i7 & 14) == 0) {
                                boxWithConstraintsScope2 = boxWithConstraintsScope;
                                i8 = i7 | (composer2.changed(boxWithConstraintsScope2) ? 4 : 2);
                            } else {
                                boxWithConstraintsScope2 = boxWithConstraintsScope;
                                i8 = i7;
                            }
                            if ((i8 & 91) != 18 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(338007641, i8, -1, "androidx.compose.material.SwipeToDismiss.<anonymous> (SwipeToDismiss.kt:183)");
                                }
                                float m6345getMaxWidthimpl = Constraints.m6345getMaxWidthimpl(boxWithConstraintsScope2.mo815getConstraintsmsEJaDk());
                                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume = composer2.consume(localLayoutDirection);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                boolean z = consume == LayoutDirection.Rtl;
                                Map mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to(Float.valueOf(0.0f), DismissValue.Default));
                                if (of.contains(DismissDirection.StartToEnd)) {
                                    Pair pair = TuplesKt.to(Float.valueOf(m6345getMaxWidthimpl), DismissValue.DismissedToEnd);
                                    mutableMapOf.put(pair.getFirst(), pair.getSecond());
                                }
                                if (of.contains(DismissDirection.EndToStart)) {
                                    Pair pair2 = TuplesKt.to(Float.valueOf(-m6345getMaxWidthimpl), DismissValue.DismissedToStart);
                                    mutableMapOf.put(pair2.getFirst(), pair2.getSecond());
                                }
                                composer2.startReplaceableGroup(96530892);
                                boolean changedInstance = composer2.changedInstance(function14);
                                final Function1<? super DismissDirection, ? extends ThresholdConfig> function15 = function14;
                                Object rememberedValue = composer2.rememberedValue();
                                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = (Function2) new Function2<DismissValue, DismissValue, ThresholdConfig>() { // from class: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2$thresholds$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final ThresholdConfig invoke(DismissValue dismissValue, DismissValue dismissValue2) {
                                            DismissDirection dismissDirection;
                                            Function1<DismissDirection, ThresholdConfig> function16 = function15;
                                            dismissDirection = SwipeToDismissKt.getDismissDirection(dismissValue, dismissValue2);
                                            Intrinsics.checkNotNull(dismissDirection);
                                            return function16.invoke(dismissDirection);
                                        }
                                    };
                                    composer2.updateRememberedValue(rememberedValue);
                                }
                                Function2 function2 = (Function2) rememberedValue;
                                composer2.endReplaceableGroup();
                                m1792swipeablepPrIpRY = SwipeableKt.m1792swipeablepPrIpRY(Modifier.INSTANCE, dismissState32, mutableMapOf, Orientation.Horizontal, (r26 & 8) != 0 ? true : dismissState32.getCurrentValue() == DismissValue.Default, (r26 & 16) != 0 ? false : z, (r26 & 32) != 0 ? null : null, (r26 & 64) != 0 ? new Function2<T, T, FixedThreshold>() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function2
                                    public final FixedThreshold invoke(T t, T t2) {
                                        return new FixedThreshold(Dp.m6389constructorimpl(56), null);
                                    }
                                } : function2, (r26 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, mutableMapOf.keySet(), 0.0f, 0.0f, 6, null) : new ResistanceConfig(m6345getMaxWidthimpl, of.contains(DismissDirection.EndToStart) ? 10.0f : 20.0f, of.contains(DismissDirection.StartToEnd) ? 10.0f : 20.0f), (r26 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1791getVelocityThresholdD9Ej5fM() : 0.0f);
                                Function3<RowScope, Composer, Integer, Unit> function35 = function342;
                                final DismissState dismissState4 = dismissState32;
                                Function3<RowScope, Composer, Integer, Unit> function36 = function32;
                                composer2.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                                composer2.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m1792swipeablepPrIpRY);
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
                                ComposerKt.sourceInformationMarkerStart(composer2, 565741225, "C212@7778L98,216@7885L141:SwipeToDismiss.kt#jmzs0o");
                                Modifier matchParentSize = boxScopeInstance.matchParentSize(Modifier.INSTANCE);
                                composer2.startReplaceableGroup(693286680);
                                ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer2, 0);
                                composer2.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(matchParentSize);
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
                                Updater.m3600setimpl(m3593constructorimpl2, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                    m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                    m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                }
                                modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                function35.invoke(RowScopeInstance.INSTANCE, composer2, 6);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                composer2.startReplaceableGroup(96531876);
                                boolean changed = composer2.changed(dismissState4);
                                Object rememberedValue2 = composer2.rememberedValue();
                                if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue2 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2$1$1$1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ IntOffset invoke(Density density) {
                                            return IntOffset.m6508boximpl(m1790invokeBjo55l4(density));
                                        }

                                        /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                                        public final long m1790invokeBjo55l4(Density density) {
                                            return IntOffsetKt.IntOffset(MathKt.roundToInt(DismissState.this.getOffset().getValue().floatValue()), 0);
                                        }
                                    };
                                    composer2.updateRememberedValue(rememberedValue2);
                                }
                                composer2.endReplaceableGroup();
                                Modifier offset = OffsetKt.offset(companion2, (Function1) rememberedValue2);
                                composer2.startReplaceableGroup(693286680);
                                ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer2, 0);
                                composer2.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(offset);
                                if (!(composer2.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer2.startReusableNode();
                                if (composer2.getInserting()) {
                                    composer2.createNode(constructor3);
                                } else {
                                    composer2.useNode();
                                }
                                Composer m3593constructorimpl3 = Updater.m3593constructorimpl(composer2);
                                Updater.m3600setimpl(m3593constructorimpl3, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3600setimpl(m3593constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m3593constructorimpl3.getInserting() || !Intrinsics.areEqual(m3593constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                    m3593constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                    m3593constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                }
                                modifierMaterializerOf3.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                function36.invoke(RowScopeInstance.INSTANCE, composer2, 6);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
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
                    }), startRestartGroup, ((i3 >> 3) & 14) | 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier42;
                    function13 = function14;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function33 = function3;
                if ((i2 & 32) == 0) {
                }
                if (i4 == 4) {
                }
                if (i6 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                final DismissState dismissState322 = dismissState2;
                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3422 = function33;
                set2 = of;
                Modifier modifier422 = companion;
                BoxWithConstraintsKt.BoxWithConstraints(modifier422, null, false, ComposableLambdaKt.composableLambda(startRestartGroup, 338007641, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2
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

                    public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, int i7) {
                        BoxWithConstraintsScope boxWithConstraintsScope2;
                        int i8;
                        Modifier m1792swipeablepPrIpRY;
                        ComposerKt.sourceInformation(composer2, "C184@6742L7,197@7314L718:SwipeToDismiss.kt#jmzs0o");
                        if ((i7 & 14) == 0) {
                            boxWithConstraintsScope2 = boxWithConstraintsScope;
                            i8 = i7 | (composer2.changed(boxWithConstraintsScope2) ? 4 : 2);
                        } else {
                            boxWithConstraintsScope2 = boxWithConstraintsScope;
                            i8 = i7;
                        }
                        if ((i8 & 91) != 18 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(338007641, i8, -1, "androidx.compose.material.SwipeToDismiss.<anonymous> (SwipeToDismiss.kt:183)");
                            }
                            float m6345getMaxWidthimpl = Constraints.m6345getMaxWidthimpl(boxWithConstraintsScope2.mo815getConstraintsmsEJaDk());
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume = composer2.consume(localLayoutDirection);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            boolean z = consume == LayoutDirection.Rtl;
                            Map mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to(Float.valueOf(0.0f), DismissValue.Default));
                            if (of.contains(DismissDirection.StartToEnd)) {
                                Pair pair = TuplesKt.to(Float.valueOf(m6345getMaxWidthimpl), DismissValue.DismissedToEnd);
                                mutableMapOf.put(pair.getFirst(), pair.getSecond());
                            }
                            if (of.contains(DismissDirection.EndToStart)) {
                                Pair pair2 = TuplesKt.to(Float.valueOf(-m6345getMaxWidthimpl), DismissValue.DismissedToStart);
                                mutableMapOf.put(pair2.getFirst(), pair2.getSecond());
                            }
                            composer2.startReplaceableGroup(96530892);
                            boolean changedInstance = composer2.changedInstance(function14);
                            final Function1<? super DismissDirection, ? extends ThresholdConfig> function15 = function14;
                            Object rememberedValue = composer2.rememberedValue();
                            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = (Function2) new Function2<DismissValue, DismissValue, ThresholdConfig>() { // from class: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2$thresholds$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final ThresholdConfig invoke(DismissValue dismissValue, DismissValue dismissValue2) {
                                        DismissDirection dismissDirection;
                                        Function1<DismissDirection, ThresholdConfig> function16 = function15;
                                        dismissDirection = SwipeToDismissKt.getDismissDirection(dismissValue, dismissValue2);
                                        Intrinsics.checkNotNull(dismissDirection);
                                        return function16.invoke(dismissDirection);
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue);
                            }
                            Function2 function2 = (Function2) rememberedValue;
                            composer2.endReplaceableGroup();
                            m1792swipeablepPrIpRY = SwipeableKt.m1792swipeablepPrIpRY(Modifier.INSTANCE, dismissState322, mutableMapOf, Orientation.Horizontal, (r26 & 8) != 0 ? true : dismissState322.getCurrentValue() == DismissValue.Default, (r26 & 16) != 0 ? false : z, (r26 & 32) != 0 ? null : null, (r26 & 64) != 0 ? new Function2<T, T, FixedThreshold>() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function2
                                public final FixedThreshold invoke(T t, T t2) {
                                    return new FixedThreshold(Dp.m6389constructorimpl(56), null);
                                }
                            } : function2, (r26 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, mutableMapOf.keySet(), 0.0f, 0.0f, 6, null) : new ResistanceConfig(m6345getMaxWidthimpl, of.contains(DismissDirection.EndToStart) ? 10.0f : 20.0f, of.contains(DismissDirection.StartToEnd) ? 10.0f : 20.0f), (r26 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1791getVelocityThresholdD9Ej5fM() : 0.0f);
                            Function3<RowScope, Composer, Integer, Unit> function35 = function3422;
                            final DismissState dismissState4 = dismissState322;
                            Function3<RowScope, Composer, Integer, Unit> function36 = function32;
                            composer2.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m1792swipeablepPrIpRY);
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
                            ComposerKt.sourceInformationMarkerStart(composer2, 565741225, "C212@7778L98,216@7885L141:SwipeToDismiss.kt#jmzs0o");
                            Modifier matchParentSize = boxScopeInstance.matchParentSize(Modifier.INSTANCE);
                            composer2.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer2, 0);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(matchParentSize);
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
                            Updater.m3600setimpl(m3593constructorimpl2, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                            }
                            modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                            function35.invoke(RowScopeInstance.INSTANCE, composer2, 6);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            Modifier.Companion companion2 = Modifier.INSTANCE;
                            composer2.startReplaceableGroup(96531876);
                            boolean changed = composer2.changed(dismissState4);
                            Object rememberedValue2 = composer2.rememberedValue();
                            if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue2 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2$1$1$1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ IntOffset invoke(Density density) {
                                        return IntOffset.m6508boximpl(m1790invokeBjo55l4(density));
                                    }

                                    /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                                    public final long m1790invokeBjo55l4(Density density) {
                                        return IntOffsetKt.IntOffset(MathKt.roundToInt(DismissState.this.getOffset().getValue().floatValue()), 0);
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue2);
                            }
                            composer2.endReplaceableGroup();
                            Modifier offset = OffsetKt.offset(companion2, (Function1) rememberedValue2);
                            composer2.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer2, 0);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(offset);
                            if (!(composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor3);
                            } else {
                                composer2.useNode();
                            }
                            Composer m3593constructorimpl3 = Updater.m3593constructorimpl(composer2);
                            Updater.m3600setimpl(m3593constructorimpl3, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3600setimpl(m3593constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m3593constructorimpl3.getInserting() || !Intrinsics.areEqual(m3593constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                m3593constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                m3593constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                            }
                            modifierMaterializerOf3.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                            function36.invoke(RowScopeInstance.INSTANCE, composer2, 6);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
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
                }), startRestartGroup, ((i3 >> 3) & 14) | 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier422;
                function13 = function14;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function12 = function1;
            if ((i2 & 16) != 0) {
            }
            function33 = function3;
            if ((i2 & 32) == 0) {
            }
            if (i4 == 4) {
            }
            if (i6 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            final DismissState dismissState3222 = dismissState2;
            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function34222 = function33;
            set2 = of;
            Modifier modifier4222 = companion;
            BoxWithConstraintsKt.BoxWithConstraints(modifier4222, null, false, ComposableLambdaKt.composableLambda(startRestartGroup, 338007641, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2
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

                public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, int i7) {
                    BoxWithConstraintsScope boxWithConstraintsScope2;
                    int i8;
                    Modifier m1792swipeablepPrIpRY;
                    ComposerKt.sourceInformation(composer2, "C184@6742L7,197@7314L718:SwipeToDismiss.kt#jmzs0o");
                    if ((i7 & 14) == 0) {
                        boxWithConstraintsScope2 = boxWithConstraintsScope;
                        i8 = i7 | (composer2.changed(boxWithConstraintsScope2) ? 4 : 2);
                    } else {
                        boxWithConstraintsScope2 = boxWithConstraintsScope;
                        i8 = i7;
                    }
                    if ((i8 & 91) != 18 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(338007641, i8, -1, "androidx.compose.material.SwipeToDismiss.<anonymous> (SwipeToDismiss.kt:183)");
                        }
                        float m6345getMaxWidthimpl = Constraints.m6345getMaxWidthimpl(boxWithConstraintsScope2.mo815getConstraintsmsEJaDk());
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume = composer2.consume(localLayoutDirection);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        boolean z = consume == LayoutDirection.Rtl;
                        Map mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to(Float.valueOf(0.0f), DismissValue.Default));
                        if (of.contains(DismissDirection.StartToEnd)) {
                            Pair pair = TuplesKt.to(Float.valueOf(m6345getMaxWidthimpl), DismissValue.DismissedToEnd);
                            mutableMapOf.put(pair.getFirst(), pair.getSecond());
                        }
                        if (of.contains(DismissDirection.EndToStart)) {
                            Pair pair2 = TuplesKt.to(Float.valueOf(-m6345getMaxWidthimpl), DismissValue.DismissedToStart);
                            mutableMapOf.put(pair2.getFirst(), pair2.getSecond());
                        }
                        composer2.startReplaceableGroup(96530892);
                        boolean changedInstance = composer2.changedInstance(function14);
                        final Function1<? super DismissDirection, ? extends ThresholdConfig> function15 = function14;
                        Object rememberedValue = composer2.rememberedValue();
                        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = (Function2) new Function2<DismissValue, DismissValue, ThresholdConfig>() { // from class: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2$thresholds$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final ThresholdConfig invoke(DismissValue dismissValue, DismissValue dismissValue2) {
                                    DismissDirection dismissDirection;
                                    Function1<DismissDirection, ThresholdConfig> function16 = function15;
                                    dismissDirection = SwipeToDismissKt.getDismissDirection(dismissValue, dismissValue2);
                                    Intrinsics.checkNotNull(dismissDirection);
                                    return function16.invoke(dismissDirection);
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue);
                        }
                        Function2 function2 = (Function2) rememberedValue;
                        composer2.endReplaceableGroup();
                        m1792swipeablepPrIpRY = SwipeableKt.m1792swipeablepPrIpRY(Modifier.INSTANCE, dismissState3222, mutableMapOf, Orientation.Horizontal, (r26 & 8) != 0 ? true : dismissState3222.getCurrentValue() == DismissValue.Default, (r26 & 16) != 0 ? false : z, (r26 & 32) != 0 ? null : null, (r26 & 64) != 0 ? new Function2<T, T, FixedThreshold>() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function2
                            public final FixedThreshold invoke(T t, T t2) {
                                return new FixedThreshold(Dp.m6389constructorimpl(56), null);
                            }
                        } : function2, (r26 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, mutableMapOf.keySet(), 0.0f, 0.0f, 6, null) : new ResistanceConfig(m6345getMaxWidthimpl, of.contains(DismissDirection.EndToStart) ? 10.0f : 20.0f, of.contains(DismissDirection.StartToEnd) ? 10.0f : 20.0f), (r26 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1791getVelocityThresholdD9Ej5fM() : 0.0f);
                        Function3<RowScope, Composer, Integer, Unit> function35 = function34222;
                        final DismissState dismissState4 = dismissState3222;
                        Function3<RowScope, Composer, Integer, Unit> function36 = function32;
                        composer2.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m1792swipeablepPrIpRY);
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
                        ComposerKt.sourceInformationMarkerStart(composer2, 565741225, "C212@7778L98,216@7885L141:SwipeToDismiss.kt#jmzs0o");
                        Modifier matchParentSize = boxScopeInstance.matchParentSize(Modifier.INSTANCE);
                        composer2.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer2, 0);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(matchParentSize);
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
                        Updater.m3600setimpl(m3593constructorimpl2, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                        function35.invoke(RowScopeInstance.INSTANCE, composer2, 6);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        Modifier.Companion companion2 = Modifier.INSTANCE;
                        composer2.startReplaceableGroup(96531876);
                        boolean changed = composer2.changed(dismissState4);
                        Object rememberedValue2 = composer2.rememberedValue();
                        if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2$1$1$1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ IntOffset invoke(Density density) {
                                    return IntOffset.m6508boximpl(m1790invokeBjo55l4(density));
                                }

                                /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                                public final long m1790invokeBjo55l4(Density density) {
                                    return IntOffsetKt.IntOffset(MathKt.roundToInt(DismissState.this.getOffset().getValue().floatValue()), 0);
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue2);
                        }
                        composer2.endReplaceableGroup();
                        Modifier offset = OffsetKt.offset(companion2, (Function1) rememberedValue2);
                        composer2.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                        MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer2, 0);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(offset);
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor3);
                        } else {
                            composer2.useNode();
                        }
                        Composer m3593constructorimpl3 = Updater.m3593constructorimpl(composer2);
                        Updater.m3600setimpl(m3593constructorimpl3, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m3593constructorimpl3.getInserting() || !Intrinsics.areEqual(m3593constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                            m3593constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                            m3593constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                        }
                        modifierMaterializerOf3.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                        function36.invoke(RowScopeInstance.INSTANCE, composer2, 6);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
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
            }), startRestartGroup, ((i3 >> 3) & 14) | 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier4222;
            function13 = function14;
            endRestartGroup = startRestartGroup.endRestartGroup();
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
        function12 = function1;
        if ((i2 & 16) != 0) {
        }
        function33 = function3;
        if ((i2 & 32) == 0) {
        }
        if (i4 == 4) {
        }
        if (i6 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        final DismissState dismissState32222 = dismissState2;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function342222 = function33;
        set2 = of;
        Modifier modifier42222 = companion;
        BoxWithConstraintsKt.BoxWithConstraints(modifier42222, null, false, ComposableLambdaKt.composableLambda(startRestartGroup, 338007641, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2
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

            public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, int i7) {
                BoxWithConstraintsScope boxWithConstraintsScope2;
                int i8;
                Modifier m1792swipeablepPrIpRY;
                ComposerKt.sourceInformation(composer2, "C184@6742L7,197@7314L718:SwipeToDismiss.kt#jmzs0o");
                if ((i7 & 14) == 0) {
                    boxWithConstraintsScope2 = boxWithConstraintsScope;
                    i8 = i7 | (composer2.changed(boxWithConstraintsScope2) ? 4 : 2);
                } else {
                    boxWithConstraintsScope2 = boxWithConstraintsScope;
                    i8 = i7;
                }
                if ((i8 & 91) != 18 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(338007641, i8, -1, "androidx.compose.material.SwipeToDismiss.<anonymous> (SwipeToDismiss.kt:183)");
                    }
                    float m6345getMaxWidthimpl = Constraints.m6345getMaxWidthimpl(boxWithConstraintsScope2.mo815getConstraintsmsEJaDk());
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = composer2.consume(localLayoutDirection);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    boolean z = consume == LayoutDirection.Rtl;
                    Map mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to(Float.valueOf(0.0f), DismissValue.Default));
                    if (of.contains(DismissDirection.StartToEnd)) {
                        Pair pair = TuplesKt.to(Float.valueOf(m6345getMaxWidthimpl), DismissValue.DismissedToEnd);
                        mutableMapOf.put(pair.getFirst(), pair.getSecond());
                    }
                    if (of.contains(DismissDirection.EndToStart)) {
                        Pair pair2 = TuplesKt.to(Float.valueOf(-m6345getMaxWidthimpl), DismissValue.DismissedToStart);
                        mutableMapOf.put(pair2.getFirst(), pair2.getSecond());
                    }
                    composer2.startReplaceableGroup(96530892);
                    boolean changedInstance = composer2.changedInstance(function14);
                    final Function1<? super DismissDirection, ? extends ThresholdConfig> function15 = function14;
                    Object rememberedValue = composer2.rememberedValue();
                    if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = (Function2) new Function2<DismissValue, DismissValue, ThresholdConfig>() { // from class: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2$thresholds$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final ThresholdConfig invoke(DismissValue dismissValue, DismissValue dismissValue2) {
                                DismissDirection dismissDirection;
                                Function1<DismissDirection, ThresholdConfig> function16 = function15;
                                dismissDirection = SwipeToDismissKt.getDismissDirection(dismissValue, dismissValue2);
                                Intrinsics.checkNotNull(dismissDirection);
                                return function16.invoke(dismissDirection);
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue);
                    }
                    Function2 function2 = (Function2) rememberedValue;
                    composer2.endReplaceableGroup();
                    m1792swipeablepPrIpRY = SwipeableKt.m1792swipeablepPrIpRY(Modifier.INSTANCE, dismissState32222, mutableMapOf, Orientation.Horizontal, (r26 & 8) != 0 ? true : dismissState32222.getCurrentValue() == DismissValue.Default, (r26 & 16) != 0 ? false : z, (r26 & 32) != 0 ? null : null, (r26 & 64) != 0 ? new Function2<T, T, FixedThreshold>() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function2
                        public final FixedThreshold invoke(T t, T t2) {
                            return new FixedThreshold(Dp.m6389constructorimpl(56), null);
                        }
                    } : function2, (r26 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, mutableMapOf.keySet(), 0.0f, 0.0f, 6, null) : new ResistanceConfig(m6345getMaxWidthimpl, of.contains(DismissDirection.EndToStart) ? 10.0f : 20.0f, of.contains(DismissDirection.StartToEnd) ? 10.0f : 20.0f), (r26 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1791getVelocityThresholdD9Ej5fM() : 0.0f);
                    Function3<RowScope, Composer, Integer, Unit> function35 = function342222;
                    final DismissState dismissState4 = dismissState32222;
                    Function3<RowScope, Composer, Integer, Unit> function36 = function32;
                    composer2.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m1792swipeablepPrIpRY);
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
                    ComposerKt.sourceInformationMarkerStart(composer2, 565741225, "C212@7778L98,216@7885L141:SwipeToDismiss.kt#jmzs0o");
                    Modifier matchParentSize = boxScopeInstance.matchParentSize(Modifier.INSTANCE);
                    composer2.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(matchParentSize);
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
                    Updater.m3600setimpl(m3593constructorimpl2, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                    function35.invoke(RowScopeInstance.INSTANCE, composer2, 6);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    composer2.startReplaceableGroup(96531876);
                    boolean changed = composer2.changed(dismissState4);
                    Object rememberedValue2 = composer2.rememberedValue();
                    if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2$1$1$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ IntOffset invoke(Density density) {
                                return IntOffset.m6508boximpl(m1790invokeBjo55l4(density));
                            }

                            /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                            public final long m1790invokeBjo55l4(Density density) {
                                return IntOffsetKt.IntOffset(MathKt.roundToInt(DismissState.this.getOffset().getValue().floatValue()), 0);
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue2);
                    }
                    composer2.endReplaceableGroup();
                    Modifier offset = OffsetKt.offset(companion2, (Function1) rememberedValue2);
                    composer2.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(offset);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor3);
                    } else {
                        composer2.useNode();
                    }
                    Composer m3593constructorimpl3 = Updater.m3593constructorimpl(composer2);
                    Updater.m3600setimpl(m3593constructorimpl3, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3600setimpl(m3593constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m3593constructorimpl3.getInserting() || !Intrinsics.areEqual(m3593constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        m3593constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        m3593constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    modifierMaterializerOf3.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                    function36.invoke(RowScopeInstance.INSTANCE, composer2, 6);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
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
        }), startRestartGroup, ((i3 >> 3) & 14) | 3072, 6);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier42222;
        function13 = function14;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DismissDirection getDismissDirection(DismissValue dismissValue, DismissValue dismissValue2) {
        if (dismissValue == dismissValue2 && dismissValue == DismissValue.Default) {
            return null;
        }
        if (dismissValue == dismissValue2 && dismissValue == DismissValue.DismissedToEnd) {
            return DismissDirection.StartToEnd;
        }
        if (dismissValue == dismissValue2 && dismissValue == DismissValue.DismissedToStart) {
            return DismissDirection.EndToStart;
        }
        if (dismissValue == DismissValue.Default && dismissValue2 == DismissValue.DismissedToEnd) {
            return DismissDirection.StartToEnd;
        }
        if (dismissValue == DismissValue.Default && dismissValue2 == DismissValue.DismissedToStart) {
            return DismissDirection.EndToStart;
        }
        if (dismissValue == DismissValue.DismissedToEnd && dismissValue2 == DismissValue.Default) {
            return DismissDirection.StartToEnd;
        }
        if (dismissValue == DismissValue.DismissedToStart && dismissValue2 == DismissValue.Default) {
            return DismissDirection.EndToStart;
        }
        return null;
    }
}
