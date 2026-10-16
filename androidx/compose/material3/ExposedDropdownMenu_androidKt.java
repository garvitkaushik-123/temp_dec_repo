package androidx.compose.material3;

import android.content.res.Configuration;
import android.view.View;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.material3.Strings;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: ExposedDropdownMenu.android.kt */
@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aQ\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\r¢\u0006\u0002\b\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001a+\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0016H\u0003¢\u0006\u0002\u0010\u0017\u001a\"\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\u0019H\u0002\u001a2\u0010\u001e\u001a\u00020\n*\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00162\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0002\u001a\u000e\u0010\"\u001a\u00020\u001b*\u0004\u0018\u00010#H\u0002\u001a\f\u0010$\u001a\u00020\u001b*\u00020\u0012H\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006%²\u0006\f\u0010&\u001a\u0004\u0018\u00010#X\u008a\u008e\u0002²\u0006\n\u0010'\u001a\u00020\u0019X\u008a\u008e\u0002²\u0006\n\u0010(\u001a\u00020\u0019X\u008a\u008e\u0002"}, d2 = {"ExposedDropdownMenuItemHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ExposedDropdownMenuBox", "", "expanded", "", "onExpandedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Landroidx/compose/material3/ExposedDropdownMenuBoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "SoftKeyboardListener", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Landroid/view/View;", "density", "Landroidx/compose/ui/unit/Density;", "onKeyboardVisibilityChange", "Lkotlin/Function0;", "(Landroid/view/View;Landroidx/compose/ui/unit/Density;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "calculateMaxHeight", "", "windowBounds", "Landroidx/compose/ui/geometry/Rect;", "anchorBounds", "verticalMargin", "expandable", "expandedDescription", "", "collapsedDescription", "getAnchorBounds", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getWindowBounds", "material3_release", "anchorCoordinates", "anchorWidth", "menuMaxHeight"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ExposedDropdownMenu_androidKt {
    private static final float ExposedDropdownMenuItemHorizontalPadding = Dp.m6389constructorimpl(16);

    /* JADX WARN: Removed duplicated region for block: B:13:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x006a  */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v6, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ExposedDropdownMenuBox(boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, final Function3<? super ExposedDropdownMenuBoxScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        final Function1<? super Boolean, Unit> function12;
        Modifier modifier2;
        int i4;
        View view;
        Density density;
        int mo624roundToPx0680j_4;
        Object rememberedValue;
        MutableState mutableState;
        Object rememberedValue2;
        Object rememberedValue3;
        final MutableIntState mutableIntState;
        Object rememberedValue4;
        FocusRequester focusRequester;
        int i5;
        boolean changed;
        Object obj;
        Density density2;
        final View view2;
        String str;
        final MutableState mutableState2;
        int i6;
        final int i7;
        final FocusRequester focusRequester2;
        ?? r14;
        int currentCompositeKeyHash;
        Composer m3593constructorimpl;
        String str2;
        boolean z2;
        Object rememberedValue5;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        final boolean z3 = z;
        Composer startRestartGroup = composer.startRestartGroup(2067579792);
        ComposerKt.sourceInformation(startRestartGroup, "C(ExposedDropdownMenuBox)P(1,3,2)116@5545L7,117@5578L7,118@5617L7,122@5730L53,123@5807L33,124@5866L33,126@5926L29,127@5986L31,128@6049L32,130@6099L1761,166@7866L45,180@8254L59,180@8243L70:ExposedDropdownMenu.android.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(z3) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            function12 = function1;
        } else {
            function12 = function1;
            if ((i & 48) == 0) {
                i3 |= startRestartGroup.changedInstance(function12) ? 32 : 16;
            }
        }
        int i8 = i2 & 4;
        if (i8 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            if ((i2 & 8) == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                i3 |= startRestartGroup.changedInstance(function3) ? 2048 : 1024;
            }
            i4 = i3;
            if ((i4 & 1171) == 1170 || !startRestartGroup.getSkipping()) {
                Modifier modifier4 = i8 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2067579792, i4, -1, "androidx.compose.material3.ExposedDropdownMenuBox (ExposedDropdownMenu.android.kt:115)");
                }
                ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume = startRestartGroup.consume(localConfiguration);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Configuration configuration = (Configuration) consume;
                ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume2 = startRestartGroup.consume(localView);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                view = (View) consume2;
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume3 = startRestartGroup.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                density = (Density) consume3;
                mo624roundToPx0680j_4 = density.mo624roundToPx0680j_4(MenuKt.getMenuVerticalMargin());
                startRestartGroup.startReplaceableGroup(983580452);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                mutableState = (MutableState) rememberedValue;
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(983580529);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = SnapshotIntStateKt.mutableIntStateOf(0);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                final MutableIntState mutableIntState2 = (MutableIntState) rememberedValue2;
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(983580588);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = SnapshotIntStateKt.mutableIntStateOf(0);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                mutableIntState = (MutableIntState) rememberedValue3;
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(983580648);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
                rememberedValue4 = startRestartGroup.rememberedValue();
                if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue4 = new FocusRequester();
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                focusRequester = (FocusRequester) rememberedValue4;
                startRestartGroup.endReplaceableGroup();
                Strings.Companion companion = Strings.INSTANCE;
                final String m2623getStringNWtq28 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_dropdown_menu_expanded), startRestartGroup, 0);
                Strings.Companion companion2 = Strings.INSTANCE;
                final String m2623getStringNWtq282 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_dropdown_menu_collapsed), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(983580821);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
                i5 = i4 & 14;
                changed = startRestartGroup.changed(configuration) | (i5 != 4) | ((i4 & 112) != 32) | startRestartGroup.changed(view) | startRestartGroup.changed(density);
                Object rememberedValue6 = startRestartGroup.rememberedValue();
                if (!changed || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    z3 = z;
                    density2 = density;
                    view2 = view;
                    str = "CC(remember):ExposedDropdownMenu.android.kt#9igjgp";
                    mutableState2 = mutableState;
                    i6 = i5;
                    i7 = mo624roundToPx0680j_4;
                    focusRequester2 = focusRequester;
                    r14 = 0;
                    obj = new ExposedDropdownMenuBoxScope() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1
                        @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
                        public Modifier menuAnchor(Modifier modifier5) {
                            Modifier expandable;
                            final View view3 = view2;
                            final int i9 = i7;
                            final MutableState<LayoutCoordinates> mutableState3 = mutableState2;
                            final MutableIntState mutableIntState3 = mutableIntState2;
                            final MutableIntState mutableIntState4 = mutableIntState;
                            Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifier5, new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                    invoke2(layoutCoordinates);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(LayoutCoordinates layoutCoordinates) {
                                    Rect windowBounds;
                                    LayoutCoordinates ExposedDropdownMenuBox$lambda$2;
                                    Rect anchorBounds;
                                    int calculateMaxHeight;
                                    mutableState3.setValue(layoutCoordinates);
                                    mutableIntState3.setIntValue(IntSize.m6559getWidthimpl(layoutCoordinates.mo5340getSizeYbymL2g()));
                                    MutableIntState mutableIntState5 = mutableIntState4;
                                    windowBounds = ExposedDropdownMenu_androidKt.getWindowBounds(view3.getRootView());
                                    ExposedDropdownMenuBox$lambda$2 = ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$2(mutableState3);
                                    anchorBounds = ExposedDropdownMenu_androidKt.getAnchorBounds(ExposedDropdownMenuBox$lambda$2);
                                    calculateMaxHeight = ExposedDropdownMenu_androidKt.calculateMaxHeight(windowBounds, anchorBounds, i9);
                                    mutableIntState5.setIntValue(calculateMaxHeight);
                                }
                            });
                            boolean z4 = z3;
                            final Function1<Boolean, Unit> function13 = function12;
                            final boolean z5 = z3;
                            expandable = ExposedDropdownMenu_androidKt.expandable(onGloballyPositioned, z4, new Function0<Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
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
                                    function13.invoke(Boolean.valueOf(!z5));
                                }
                            }, m2623getStringNWtq28, m2623getStringNWtq282);
                            return FocusRequesterModifierKt.focusRequester(expandable, focusRequester2);
                        }

                        @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
                        public Modifier exposedDropdownSize(Modifier modifier5, final boolean z4) {
                            final MutableIntState mutableIntState3 = mutableIntState2;
                            final MutableIntState mutableIntState4 = mutableIntState;
                            return LayoutModifierKt.layout(modifier5, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1$exposedDropdownSize$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                                    return m2204invoke3p2s80s(measureScope, measurable, constraints.getValue());
                                }

                                /* renamed from: invoke-3p2s80s, reason: not valid java name */
                                public final MeasureResult m2204invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                                    int ExposedDropdownMenuBox$lambda$5;
                                    int ExposedDropdownMenuBox$lambda$8;
                                    ExposedDropdownMenuBox$lambda$5 = ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$5(mutableIntState3);
                                    int m6359constrainWidthK40F9xA = ConstraintsKt.m6359constrainWidthK40F9xA(j, ExposedDropdownMenuBox$lambda$5);
                                    ExposedDropdownMenuBox$lambda$8 = ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$8(mutableIntState4);
                                    int m6358constrainHeightK40F9xA = ConstraintsKt.m6358constrainHeightK40F9xA(j, ExposedDropdownMenuBox$lambda$8);
                                    int m6347getMinWidthimpl = z4 ? m6359constrainWidthK40F9xA : Constraints.m6347getMinWidthimpl(j);
                                    if (!z4) {
                                        m6359constrainWidthK40F9xA = Constraints.m6345getMaxWidthimpl(j);
                                    }
                                    final Placeable mo5333measureBRTryo0 = measurable.mo5333measureBRTryo0(Constraints.m6336copyZbe2FdA$default(j, m6347getMinWidthimpl, m6359constrainWidthK40F9xA, 0, m6358constrainHeightK40F9xA, 4, null));
                                    return MeasureScope.layout$default(measureScope, mo5333measureBRTryo0.getWidth(), mo5333measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1$exposedDropdownSize$1.1
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
                                            Placeable.PlacementScope.place$default(placementScope, Placeable.this, 0, 0, 0.0f, 4, null);
                                        }
                                    }, 4, null);
                                }
                            });
                        }
                    };
                    startRestartGroup.updateRememberedValue(obj);
                } else {
                    obj = rememberedValue6;
                    density2 = density;
                    view2 = view;
                    str = "CC(remember):ExposedDropdownMenu.android.kt#9igjgp";
                    mutableState2 = mutableState;
                    i6 = i5;
                    z3 = z;
                    i7 = mo624roundToPx0680j_4;
                    focusRequester2 = focusRequester;
                    r14 = 0;
                }
                ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1 exposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1 = (ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1) obj;
                startRestartGroup.endReplaceableGroup();
                int i9 = i4 >> 6;
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), r14, startRestartGroup, r14);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, r14);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                int i10 = r14;
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier4);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (!startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor);
                } else {
                    startRestartGroup.useNode();
                }
                m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
                Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf(i10));
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1004943029, "C167@7896L9:ExposedDropdownMenu.android.kt#uh7d8r");
                function3.invoke(exposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1, startRestartGroup, Integer.valueOf(i9 & 112));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(983582639);
                ComposerKt.sourceInformation(startRestartGroup, "171@7977L254,171@7941L290");
                if (z3) {
                    str2 = str;
                } else {
                    startRestartGroup.startReplaceableGroup(983582699);
                    str2 = str;
                    ComposerKt.sourceInformation(startRestartGroup, str2);
                    boolean changedInstance = startRestartGroup.changedInstance(view2) | startRestartGroup.changed(i7);
                    Object rememberedValue7 = startRestartGroup.rememberedValue();
                    if (changedInstance || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue7 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$2$1
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
                                Rect windowBounds;
                                LayoutCoordinates ExposedDropdownMenuBox$lambda$2;
                                Rect anchorBounds;
                                int calculateMaxHeight;
                                MutableIntState mutableIntState3 = mutableIntState;
                                windowBounds = ExposedDropdownMenu_androidKt.getWindowBounds(view2.getRootView());
                                ExposedDropdownMenuBox$lambda$2 = ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$2(mutableState2);
                                anchorBounds = ExposedDropdownMenu_androidKt.getAnchorBounds(ExposedDropdownMenuBox$lambda$2);
                                calculateMaxHeight = ExposedDropdownMenu_androidKt.calculateMaxHeight(windowBounds, anchorBounds, i7);
                                mutableIntState3.setIntValue(calculateMaxHeight);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue7);
                    }
                    startRestartGroup.endReplaceableGroup();
                    SoftKeyboardListener(view2, density2, (Function0) rememberedValue7, startRestartGroup, i10);
                }
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(983582976);
                ComposerKt.sourceInformation(startRestartGroup, str2);
                z2 = i6 != 4;
                rememberedValue5 = startRestartGroup.rememberedValue();
                if (!z2 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue5 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$3$1
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
                            if (z3) {
                                focusRequester2.requestFocus();
                            }
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                startRestartGroup.endReplaceableGroup();
                EffectsKt.SideEffect((Function0) rememberedValue5, startRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            } else {
                startRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$4
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

                    public final void invoke(Composer composer2, int i11) {
                        ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox(z3, function1, modifier3, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        modifier2 = modifier;
        if ((i2 & 8) == 0) {
        }
        i4 = i3;
        if ((i4 & 1171) == 1170) {
        }
        if (i8 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        ProvidableCompositionLocal<Configuration> localConfiguration2 = AndroidCompositionLocals_androidKt.getLocalConfiguration();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume4 = startRestartGroup.consume(localConfiguration2);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Configuration configuration2 = (Configuration) consume4;
        ProvidableCompositionLocal<View> localView2 = AndroidCompositionLocals_androidKt.getLocalView();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume22 = startRestartGroup.consume(localView2);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        view = (View) consume22;
        ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume32 = startRestartGroup.consume(localDensity2);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        density = (Density) consume32;
        mo624roundToPx0680j_4 = density.mo624roundToPx0680j_4(MenuKt.getMenuVerticalMargin());
        startRestartGroup.startReplaceableGroup(983580452);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        mutableState = (MutableState) rememberedValue;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(983580529);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
        }
        final MutableIntState mutableIntState22 = (MutableIntState) rememberedValue2;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(983580588);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
        }
        mutableIntState = (MutableIntState) rememberedValue3;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(983580648);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
        }
        focusRequester = (FocusRequester) rememberedValue4;
        startRestartGroup.endReplaceableGroup();
        Strings.Companion companion3 = Strings.INSTANCE;
        final String m2623getStringNWtq283 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_dropdown_menu_expanded), startRestartGroup, 0);
        Strings.Companion companion22 = Strings.INSTANCE;
        final String m2623getStringNWtq2822 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_dropdown_menu_collapsed), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(983580821);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
        i5 = i4 & 14;
        if ((i4 & 112) != 32) {
        }
        changed = startRestartGroup.changed(configuration2) | (i5 != 4) | ((i4 & 112) != 32) | startRestartGroup.changed(view) | startRestartGroup.changed(density);
        Object rememberedValue62 = startRestartGroup.rememberedValue();
        if (changed) {
        }
        z3 = z;
        density2 = density;
        view2 = view;
        str = "CC(remember):ExposedDropdownMenu.android.kt#9igjgp";
        mutableState2 = mutableState;
        i6 = i5;
        i7 = mo624roundToPx0680j_4;
        focusRequester2 = focusRequester;
        r14 = 0;
        obj = new ExposedDropdownMenuBoxScope() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1
            @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
            public Modifier menuAnchor(Modifier modifier5) {
                Modifier expandable;
                final View view3 = view2;
                final int i92 = i7;
                final MutableState<LayoutCoordinates> mutableState3 = mutableState2;
                final MutableIntState mutableIntState3 = mutableIntState22;
                final MutableIntState mutableIntState4 = mutableIntState;
                Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifier5, new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                        invoke2(layoutCoordinates);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LayoutCoordinates layoutCoordinates) {
                        Rect windowBounds;
                        LayoutCoordinates ExposedDropdownMenuBox$lambda$2;
                        Rect anchorBounds;
                        int calculateMaxHeight;
                        mutableState3.setValue(layoutCoordinates);
                        mutableIntState3.setIntValue(IntSize.m6559getWidthimpl(layoutCoordinates.mo5340getSizeYbymL2g()));
                        MutableIntState mutableIntState5 = mutableIntState4;
                        windowBounds = ExposedDropdownMenu_androidKt.getWindowBounds(view3.getRootView());
                        ExposedDropdownMenuBox$lambda$2 = ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$2(mutableState3);
                        anchorBounds = ExposedDropdownMenu_androidKt.getAnchorBounds(ExposedDropdownMenuBox$lambda$2);
                        calculateMaxHeight = ExposedDropdownMenu_androidKt.calculateMaxHeight(windowBounds, anchorBounds, i92);
                        mutableIntState5.setIntValue(calculateMaxHeight);
                    }
                });
                boolean z4 = z3;
                final Function1<? super Boolean, Unit> function13 = function12;
                final boolean z5 = z3;
                expandable = ExposedDropdownMenu_androidKt.expandable(onGloballyPositioned, z4, new Function0<Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
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
                        function13.invoke(Boolean.valueOf(!z5));
                    }
                }, m2623getStringNWtq283, m2623getStringNWtq2822);
                return FocusRequesterModifierKt.focusRequester(expandable, focusRequester2);
            }

            @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
            public Modifier exposedDropdownSize(Modifier modifier5, final boolean z4) {
                final MutableIntState mutableIntState3 = mutableIntState22;
                final MutableIntState mutableIntState4 = mutableIntState;
                return LayoutModifierKt.layout(modifier5, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1$exposedDropdownSize$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                        return m2204invoke3p2s80s(measureScope, measurable, constraints.getValue());
                    }

                    /* renamed from: invoke-3p2s80s, reason: not valid java name */
                    public final MeasureResult m2204invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                        int ExposedDropdownMenuBox$lambda$5;
                        int ExposedDropdownMenuBox$lambda$8;
                        ExposedDropdownMenuBox$lambda$5 = ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$5(mutableIntState3);
                        int m6359constrainWidthK40F9xA = ConstraintsKt.m6359constrainWidthK40F9xA(j, ExposedDropdownMenuBox$lambda$5);
                        ExposedDropdownMenuBox$lambda$8 = ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$8(mutableIntState4);
                        int m6358constrainHeightK40F9xA = ConstraintsKt.m6358constrainHeightK40F9xA(j, ExposedDropdownMenuBox$lambda$8);
                        int m6347getMinWidthimpl = z4 ? m6359constrainWidthK40F9xA : Constraints.m6347getMinWidthimpl(j);
                        if (!z4) {
                            m6359constrainWidthK40F9xA = Constraints.m6345getMaxWidthimpl(j);
                        }
                        final Placeable mo5333measureBRTryo0 = measurable.mo5333measureBRTryo0(Constraints.m6336copyZbe2FdA$default(j, m6347getMinWidthimpl, m6359constrainWidthK40F9xA, 0, m6358constrainHeightK40F9xA, 4, null));
                        return MeasureScope.layout$default(measureScope, mo5333measureBRTryo0.getWidth(), mo5333measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1$exposedDropdownSize$1.1
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
                                Placeable.PlacementScope.place$default(placementScope, Placeable.this, 0, 0, 0.0f, 4, null);
                            }
                        }, 4, null);
                    }
                });
            }
        };
        startRestartGroup.updateRememberedValue(obj);
        ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1 exposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$12 = (ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1) obj;
        startRestartGroup.endReplaceableGroup();
        int i92 = i4 >> 6;
        startRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
        MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), r14, startRestartGroup, r14);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, r14);
        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
        int i102 = r14;
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(modifier4);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
        }
        startRestartGroup.startReusableNode();
        if (!startRestartGroup.getInserting()) {
        }
        m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
        Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (!m3593constructorimpl.getInserting()) {
        }
        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
        modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf(i102));
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1004943029, "C167@7896L9:ExposedDropdownMenu.android.kt#uh7d8r");
        function3.invoke(exposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$12, startRestartGroup, Integer.valueOf(i92 & 112));
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(983582639);
        ComposerKt.sourceInformation(startRestartGroup, "171@7977L254,171@7941L290");
        if (z3) {
        }
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(983582976);
        ComposerKt.sourceInformation(startRestartGroup, str2);
        if (i6 != 4) {
        }
        rememberedValue5 = startRestartGroup.rememberedValue();
        if (!z2) {
        }
        rememberedValue5 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$3$1
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
                if (z3) {
                    focusRequester2.requestFocus();
                }
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue5);
        startRestartGroup.endReplaceableGroup();
        EffectsKt.SideEffect((Function0) rememberedValue5, startRestartGroup, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier4;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LayoutCoordinates ExposedDropdownMenuBox$lambda$2(MutableState<LayoutCoordinates> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ExposedDropdownMenuBox$lambda$5(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ExposedDropdownMenuBox$lambda$8(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SoftKeyboardListener(final View view, final Density density, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1319522472);
        ComposerKt.sourceInformation(startRestartGroup, "C(SoftKeyboardListener)P(2)193@8669L1413,193@8637L1445:ExposedDropdownMenu.android.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(view) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(density) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i2 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1319522472, i2, -1, "androidx.compose.material3.SoftKeyboardListener (ExposedDropdownMenu.android.kt:190)");
            }
            startRestartGroup.startReplaceableGroup(-491766155);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(view) | ((i2 & 896) == 256);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$SoftKeyboardListener$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        final ExposedDropdownMenu_androidKt$SoftKeyboardListener$1$1$listener$1 exposedDropdownMenu_androidKt$SoftKeyboardListener$1$1$listener$1 = new ExposedDropdownMenu_androidKt$SoftKeyboardListener$1$1$listener$1(view, function0);
                        return new DisposableEffectResult() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$SoftKeyboardListener$1$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                ExposedDropdownMenu_androidKt$SoftKeyboardListener$1$1$listener$1.this.dispose();
                            }
                        };
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            EffectsKt.DisposableEffect(view, density, (Function1) rememberedValue, startRestartGroup, i2 & 126);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$SoftKeyboardListener$2
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
                    ExposedDropdownMenu_androidKt.SoftKeyboardListener(view, density, function0, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier expandable(Modifier modifier, final boolean z, final Function0<Unit> function0, final String str, final String str2) {
        return SemanticsModifierKt.semantics$default(SuspendingPointerInputFilterKt.pointerInput(modifier, function0, new ExposedDropdownMenu_androidKt$expandable$1(function0, null)), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$expandable$2
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
                SemanticsPropertiesKt.setStateDescription(semanticsPropertyReceiver, z ? str : str2);
                SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5718getDropdownListo7Vup1c());
                final Function0<Unit> function02 = function0;
                SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$expandable$2.1
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
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int calculateMaxHeight(Rect rect, Rect rect2, int i) {
        int roundToInt;
        if (rect2 == null) {
            return 0;
        }
        float f = i;
        float top = rect.getTop() + f;
        float bottom = rect.getBottom() - f;
        if (rect2.getTop() > rect.getBottom() || rect2.getBottom() < rect.getTop()) {
            roundToInt = MathKt.roundToInt(bottom - top);
        } else {
            roundToInt = MathKt.roundToInt(Math.max(rect2.getTop() - top, bottom - rect2.getBottom()));
        }
        return Math.max(roundToInt, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect getWindowBounds(View view) {
        android.graphics.Rect rect = new android.graphics.Rect();
        view.getWindowVisibleDisplayFrame(rect);
        return RectHelper_androidKt.toComposeRect(rect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect getAnchorBounds(LayoutCoordinates layoutCoordinates) {
        return layoutCoordinates == null ? Rect.INSTANCE.getZero() : RectKt.m3862Recttz77jQw(LayoutCoordinatesKt.positionInWindow(layoutCoordinates), IntSizeKt.m6569toSizeozmzZPI(layoutCoordinates.mo5340getSizeYbymL2g()));
    }
}
