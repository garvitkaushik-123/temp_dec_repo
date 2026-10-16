package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TabRow.kt */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a©\u0001\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u000123\b\u0002\u0010\u0010\u001a-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00070\u0011¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\u0018\b\u0002\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001a¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001a¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u009f\u0001\u0010\u001e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r23\b\u0002\u0010\u0010\u001a-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00070\u0011¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\u0018\b\u0002\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001a¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001a¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006!"}, d2 = {"ScrollableTabRowMinimumTabWidth", "Landroidx/compose/ui/unit/Dp;", "F", "ScrollableTabRowScrollSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "ScrollableTabRow", "", "selectedTabIndex", "", "modifier", "Landroidx/compose/ui/Modifier;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "edgePadding", "indicator", "Lkotlin/Function1;", "", "Landroidx/compose/material/TabPosition;", "Lkotlin/ParameterName;", "name", "tabPositions", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/UiComposable;", "divider", "Lkotlin/Function0;", "tabs", "ScrollableTabRow-sKfQg0A", "(ILandroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TabRow", "TabRow-pAZo6Ak", "(ILandroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TabRowKt {
    private static final float ScrollableTabRowMinimumTabWidth = Dp.m6389constructorimpl(90);
    private static final AnimationSpec<Float> ScrollableTabRowScrollSpec = AnimationSpecKt.tween$default(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 0, EasingKt.getFastOutSlowInEasing(), 2, null);

    /* JADX WARN: Removed duplicated region for block: B:102:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0079  */
    /* renamed from: TabRow-pAZo6Ak, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1812TabRowpAZo6Ak(final int i, Modifier modifier, long j, long j2, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        long j3;
        long j4;
        int i5;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function32;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function23;
        final Function2<? super Composer, ? super Integer, Unit> m1640getLambda1$material_release;
        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function33;
        long j5;
        int i7;
        Composer composer2;
        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function34;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final Modifier modifier3;
        final long j6;
        final long j7;
        ScopeUpdateScope endRestartGroup;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(-249175289);
        ComposerKt.sourceInformation(startRestartGroup, "C(TabRow)P(5,4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)135@6677L6,136@6726L32,149@7183L1518:TabRow.kt#jmzs0o");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i4 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i9 = i3 & 2;
        if (i9 != 0) {
            i4 |= 48;
        } else if ((i2 & 112) == 0) {
            modifier2 = modifier;
            i4 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i2 & 896) != 0) {
                if ((i3 & 4) == 0) {
                    j3 = j;
                    if (startRestartGroup.changed(j3)) {
                        i8 = 256;
                        i4 |= i8;
                    }
                } else {
                    j3 = j;
                }
                i8 = 128;
                i4 |= i8;
            } else {
                j3 = j;
            }
            if ((i2 & 7168) != 0) {
                j4 = j2;
                i4 |= ((i3 & 8) == 0 && startRestartGroup.changed(j4)) ? 2048 : 1024;
            } else {
                j4 = j2;
            }
            i5 = i3 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else if ((57344 & i2) == 0) {
                function32 = function3;
                i4 |= startRestartGroup.changedInstance(function32) ? 16384 : 8192;
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((458752 & i2) == 0) {
                    function23 = function2;
                    i4 |= startRestartGroup.changedInstance(function23) ? 131072 : 65536;
                    if ((i3 & 64) == 0) {
                        i4 |= 1572864;
                    } else if ((i2 & 3670016) == 0) {
                        i4 |= startRestartGroup.changedInstance(function22) ? 1048576 : 524288;
                    }
                    if ((i4 & 2995931) == 599186 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            if (i9 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i3 & 4) != 0) {
                                j3 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(startRestartGroup, 6));
                                i4 &= -897;
                            }
                            if ((i3 & 8) != 0) {
                                j4 = ColorsKt.m1621contentColorForek8zF_U(j3, startRestartGroup, (i4 >> 6) & 14);
                                i4 &= -7169;
                            }
                            if (i5 != 0) {
                                function32 = ComposableLambdaKt.composableLambda(startRestartGroup, -553782708, true, new Function3<List<? extends TabPosition>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt$TabRow$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(List<? extends TabPosition> list, Composer composer3, Integer num) {
                                        invoke((List<TabPosition>) list, composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(List<TabPosition> list, Composer composer3, int i10) {
                                        ComposerKt.sourceInformation(composer3, "C139@6906L92:TabRow.kt#jmzs0o");
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-553782708, i10, -1, "androidx.compose.material.TabRow.<anonymous> (TabRow.kt:139)");
                                        }
                                        TabRowDefaults.INSTANCE.m1807Indicator9IZ8Weo(TabRowDefaults.INSTANCE.tabIndicatorOffset(Modifier.INSTANCE, list.get(i)), 0.0f, 0L, composer3, 3072, 6);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                });
                            }
                            if (i6 != 0) {
                                int i10 = i4;
                                m1640getLambda1$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1640getLambda1$material_release();
                                function33 = function32;
                                j5 = j3;
                                i7 = i10;
                                long j8 = j4;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-249175289, i7, -1, "androidx.compose.material.TabRow (TabRow.kt:148)");
                                }
                                composer2 = startRestartGroup;
                                SurfaceKt.m1782SurfaceFjzlyU(SelectableGroupKt.selectableGroup(modifier2), null, j5, j8, null, 0.0f, ComposableLambdaKt.composableLambda(startRestartGroup, -1961746365, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt$TabRow$2
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
                                        ComposerKt.sourceInformation(composer3, "C154@7324L1371:TabRow.kt#jmzs0o");
                                        if ((i11 & 11) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1961746365, i11, -1, "androidx.compose.material.TabRow.<anonymous> (TabRow.kt:154)");
                                        }
                                        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                        composer3.startReplaceableGroup(370751195);
                                        boolean changedInstance = composer3.changedInstance(function22) | composer3.changedInstance(m1640getLambda1$material_release) | composer3.changedInstance(function33);
                                        final Function2<Composer, Integer, Unit> function25 = function22;
                                        final Function2<Composer, Integer, Unit> function26 = m1640getLambda1$material_release;
                                        final Function3<List<TabPosition>, Composer, Integer, Unit> function35 = function33;
                                        Object rememberedValue = composer3.rememberedValue();
                                        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.TabRowKt$TabRow$2$1$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                                    return m1814invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                                                }

                                                /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                                                public final MeasureResult m1814invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, final long j9) {
                                                    int i12;
                                                    Object obj;
                                                    final int m6345getMaxWidthimpl = Constraints.m6345getMaxWidthimpl(j9);
                                                    List<Measurable> subcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function25);
                                                    int size = subcompose.size();
                                                    final int i13 = m6345getMaxWidthimpl / size;
                                                    ArrayList arrayList = new ArrayList(subcompose.size());
                                                    int size2 = subcompose.size();
                                                    int i14 = 0;
                                                    while (i14 < size2) {
                                                        Measurable measurable = subcompose.get(i14);
                                                        int i15 = i13;
                                                        long m6336copyZbe2FdA$default = Constraints.m6336copyZbe2FdA$default(j9, i15, i13, 0, 0, 12, null);
                                                        i13 = i15;
                                                        arrayList.add(measurable.mo5333measureBRTryo0(m6336copyZbe2FdA$default));
                                                        i14++;
                                                        subcompose = subcompose;
                                                    }
                                                    final ArrayList arrayList2 = arrayList;
                                                    if (arrayList2.isEmpty()) {
                                                        obj = null;
                                                        i12 = 0;
                                                    } else {
                                                        i12 = 0;
                                                        obj = arrayList2.get(0);
                                                        int height = ((Placeable) obj).getHeight();
                                                        int lastIndex = CollectionsKt.getLastIndex(arrayList2);
                                                        int i16 = 1;
                                                        if (1 <= lastIndex) {
                                                            while (true) {
                                                                Object obj2 = arrayList2.get(i16);
                                                                int height2 = ((Placeable) obj2).getHeight();
                                                                if (height < height2) {
                                                                    obj = obj2;
                                                                    height = height2;
                                                                }
                                                                if (i16 == lastIndex) {
                                                                    break;
                                                                }
                                                                i16++;
                                                            }
                                                        }
                                                    }
                                                    Placeable placeable = (Placeable) obj;
                                                    final int height3 = placeable != null ? placeable.getHeight() : i12;
                                                    ArrayList arrayList3 = new ArrayList(size);
                                                    for (int i17 = i12; i17 < size; i17++) {
                                                        arrayList3.add(new TabPosition(Dp.m6389constructorimpl(subcomposeMeasureScope.mo627toDpu2uoSUM(i13) * i17), subcomposeMeasureScope.mo627toDpu2uoSUM(i13), null));
                                                    }
                                                    final ArrayList arrayList4 = arrayList3;
                                                    final Function2<Composer, Integer, Unit> function27 = function26;
                                                    final Function3<List<TabPosition>, Composer, Integer, Unit> function36 = function35;
                                                    return MeasureScope.layout$default(subcomposeMeasureScope, m6345getMaxWidthimpl, height3, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.TabRowKt$TabRow$2$1$1.1
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
                                                            List<Placeable> list = arrayList2;
                                                            int i18 = i13;
                                                            int size3 = list.size();
                                                            for (int i19 = 0; i19 < size3; i19++) {
                                                                Placeable.PlacementScope.placeRelative$default(placementScope, list.get(i19), i19 * i18, 0, 0.0f, 4, null);
                                                            }
                                                            List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Divider, function27);
                                                            long j10 = j9;
                                                            int i20 = height3;
                                                            int size4 = subcompose2.size();
                                                            for (int i21 = 0; i21 < size4; i21++) {
                                                                Placeable mo5333measureBRTryo0 = subcompose2.get(i21).mo5333measureBRTryo0(Constraints.m6336copyZbe2FdA$default(j10, 0, 0, 0, 0, 11, null));
                                                                Placeable.PlacementScope.placeRelative$default(placementScope, mo5333measureBRTryo0, 0, i20 - mo5333measureBRTryo0.getHeight(), 0.0f, 4, null);
                                                            }
                                                            SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                                            TabSlots tabSlots = TabSlots.Indicator;
                                                            final Function3<List<TabPosition>, Composer, Integer, Unit> function37 = function36;
                                                            final List<TabPosition> list2 = arrayList4;
                                                            List<Measurable> subcompose3 = subcomposeMeasureScope2.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(-641946361, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt.TabRow.2.1.1.1.3
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

                                                                public final void invoke(Composer composer4, int i22) {
                                                                    ComposerKt.sourceInformation(composer4, "C180@8501L23:TabRow.kt#jmzs0o");
                                                                    if ((i22 & 11) == 2 && composer4.getSkipping()) {
                                                                        composer4.skipToGroupEnd();
                                                                        return;
                                                                    }
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(-641946361, i22, -1, "androidx.compose.material.TabRow.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:180)");
                                                                    }
                                                                    function37.invoke(list2, composer4, 8);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                            }));
                                                            int i22 = m6345getMaxWidthimpl;
                                                            int i23 = height3;
                                                            int size5 = subcompose3.size();
                                                            for (int i24 = 0; i24 < size5; i24++) {
                                                                Placeable.PlacementScope.placeRelative$default(placementScope, subcompose3.get(i24).mo5333measureBRTryo0(Constraints.INSTANCE.m6353fixedJhjzzOo(i22, i23)), 0, 0, 0.0f, 4, null);
                                                            }
                                                        }
                                                    }, 4, null);
                                                }
                                            };
                                            composer3.updateRememberedValue(rememberedValue);
                                        }
                                        composer3.endReplaceableGroup();
                                        SubcomposeLayoutKt.SubcomposeLayout(fillMaxWidth$default, (Function2) rememberedValue, composer3, 6, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), composer2, (i7 & 896) | 1572864 | (i7 & 7168), 50);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                function34 = function33;
                                function24 = m1640getLambda1$material_release;
                                modifier3 = modifier2;
                                j6 = j5;
                                j7 = j8;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i3 & 4) != 0) {
                                i4 &= -897;
                            }
                            if ((i3 & 8) != 0) {
                                i4 &= -7169;
                            }
                        }
                        function33 = function32;
                        j5 = j3;
                        i7 = i4;
                        m1640getLambda1$material_release = function23;
                        long j82 = j4;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composer2 = startRestartGroup;
                        SurfaceKt.m1782SurfaceFjzlyU(SelectableGroupKt.selectableGroup(modifier2), null, j5, j82, null, 0.0f, ComposableLambdaKt.composableLambda(startRestartGroup, -1961746365, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt$TabRow$2
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
                                ComposerKt.sourceInformation(composer3, "C154@7324L1371:TabRow.kt#jmzs0o");
                                if ((i11 & 11) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1961746365, i11, -1, "androidx.compose.material.TabRow.<anonymous> (TabRow.kt:154)");
                                }
                                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                composer3.startReplaceableGroup(370751195);
                                boolean changedInstance = composer3.changedInstance(function22) | composer3.changedInstance(m1640getLambda1$material_release) | composer3.changedInstance(function33);
                                final Function2<? super Composer, ? super Integer, Unit> function25 = function22;
                                final Function2<? super Composer, ? super Integer, Unit> function26 = m1640getLambda1$material_release;
                                final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function35 = function33;
                                Object rememberedValue = composer3.rememberedValue();
                                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.TabRowKt$TabRow$2$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                            return m1814invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                                        }

                                        /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                                        public final MeasureResult m1814invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, final long j9) {
                                            int i12;
                                            Object obj;
                                            final int m6345getMaxWidthimpl = Constraints.m6345getMaxWidthimpl(j9);
                                            List<Measurable> subcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function25);
                                            int size = subcompose.size();
                                            final int i13 = m6345getMaxWidthimpl / size;
                                            ArrayList arrayList = new ArrayList(subcompose.size());
                                            int size2 = subcompose.size();
                                            int i14 = 0;
                                            while (i14 < size2) {
                                                Measurable measurable = subcompose.get(i14);
                                                int i15 = i13;
                                                long m6336copyZbe2FdA$default = Constraints.m6336copyZbe2FdA$default(j9, i15, i13, 0, 0, 12, null);
                                                i13 = i15;
                                                arrayList.add(measurable.mo5333measureBRTryo0(m6336copyZbe2FdA$default));
                                                i14++;
                                                subcompose = subcompose;
                                            }
                                            final List<? extends Placeable> arrayList2 = arrayList;
                                            if (arrayList2.isEmpty()) {
                                                obj = null;
                                                i12 = 0;
                                            } else {
                                                i12 = 0;
                                                obj = arrayList2.get(0);
                                                int height = ((Placeable) obj).getHeight();
                                                int lastIndex = CollectionsKt.getLastIndex(arrayList2);
                                                int i16 = 1;
                                                if (1 <= lastIndex) {
                                                    while (true) {
                                                        Object obj2 = arrayList2.get(i16);
                                                        int height2 = ((Placeable) obj2).getHeight();
                                                        if (height < height2) {
                                                            obj = obj2;
                                                            height = height2;
                                                        }
                                                        if (i16 == lastIndex) {
                                                            break;
                                                        }
                                                        i16++;
                                                    }
                                                }
                                            }
                                            Placeable placeable = (Placeable) obj;
                                            final int height3 = placeable != null ? placeable.getHeight() : i12;
                                            ArrayList arrayList3 = new ArrayList(size);
                                            for (int i17 = i12; i17 < size; i17++) {
                                                arrayList3.add(new TabPosition(Dp.m6389constructorimpl(subcomposeMeasureScope.mo627toDpu2uoSUM(i13) * i17), subcomposeMeasureScope.mo627toDpu2uoSUM(i13), null));
                                            }
                                            final List<TabPosition> arrayList4 = arrayList3;
                                            final Function2<? super Composer, ? super Integer, Unit> function27 = function26;
                                            final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function36 = function35;
                                            return MeasureScope.layout$default(subcomposeMeasureScope, m6345getMaxWidthimpl, height3, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.TabRowKt$TabRow$2$1$1.1
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
                                                    List<Placeable> list = arrayList2;
                                                    int i18 = i13;
                                                    int size3 = list.size();
                                                    for (int i19 = 0; i19 < size3; i19++) {
                                                        Placeable.PlacementScope.placeRelative$default(placementScope, list.get(i19), i19 * i18, 0, 0.0f, 4, null);
                                                    }
                                                    List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Divider, function27);
                                                    long j10 = j9;
                                                    int i20 = height3;
                                                    int size4 = subcompose2.size();
                                                    for (int i21 = 0; i21 < size4; i21++) {
                                                        Placeable mo5333measureBRTryo0 = subcompose2.get(i21).mo5333measureBRTryo0(Constraints.m6336copyZbe2FdA$default(j10, 0, 0, 0, 0, 11, null));
                                                        Placeable.PlacementScope.placeRelative$default(placementScope, mo5333measureBRTryo0, 0, i20 - mo5333measureBRTryo0.getHeight(), 0.0f, 4, null);
                                                    }
                                                    SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                                    TabSlots tabSlots = TabSlots.Indicator;
                                                    final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function37 = function36;
                                                    final List<TabPosition> list2 = arrayList4;
                                                    List<Measurable> subcompose3 = subcomposeMeasureScope2.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(-641946361, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt.TabRow.2.1.1.1.3
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

                                                        public final void invoke(Composer composer4, int i22) {
                                                            ComposerKt.sourceInformation(composer4, "C180@8501L23:TabRow.kt#jmzs0o");
                                                            if ((i22 & 11) == 2 && composer4.getSkipping()) {
                                                                composer4.skipToGroupEnd();
                                                                return;
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-641946361, i22, -1, "androidx.compose.material.TabRow.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:180)");
                                                            }
                                                            function37.invoke(list2, composer4, 8);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                    }));
                                                    int i22 = m6345getMaxWidthimpl;
                                                    int i23 = height3;
                                                    int size5 = subcompose3.size();
                                                    for (int i24 = 0; i24 < size5; i24++) {
                                                        Placeable.PlacementScope.placeRelative$default(placementScope, subcompose3.get(i24).mo5333measureBRTryo0(Constraints.INSTANCE.m6353fixedJhjzzOo(i22, i23)), 0, 0, 0.0f, 4, null);
                                                    }
                                                }
                                            }, 4, null);
                                        }
                                    };
                                    composer3.updateRememberedValue(rememberedValue);
                                }
                                composer3.endReplaceableGroup();
                                SubcomposeLayoutKt.SubcomposeLayout(fillMaxWidth$default, (Function2) rememberedValue, composer3, 6, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer2, (i7 & 896) | 1572864 | (i7 & 7168), 50);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        function34 = function33;
                        function24 = m1640getLambda1$material_release;
                        modifier3 = modifier2;
                        j6 = j5;
                        j7 = j82;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        composer2 = startRestartGroup;
                        modifier3 = modifier2;
                        j6 = j3;
                        j7 = j4;
                        function34 = function32;
                        function24 = function23;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt$TabRow$3
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
                                TabRowKt.m1812TabRowpAZo6Ak(i, modifier3, j6, j7, function34, function24, function22, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                            }
                        });
                        return;
                    }
                    return;
                }
                function23 = function2;
                if ((i3 & 64) == 0) {
                }
                if ((i4 & 2995931) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i9 != 0) {
                }
                if ((i3 & 4) != 0) {
                }
                if ((i3 & 8) != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                function33 = function32;
                j5 = j3;
                i7 = i4;
                m1640getLambda1$material_release = function23;
                long j822 = j4;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                SurfaceKt.m1782SurfaceFjzlyU(SelectableGroupKt.selectableGroup(modifier2), null, j5, j822, null, 0.0f, ComposableLambdaKt.composableLambda(startRestartGroup, -1961746365, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt$TabRow$2
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
                        ComposerKt.sourceInformation(composer3, "C154@7324L1371:TabRow.kt#jmzs0o");
                        if ((i11 & 11) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1961746365, i11, -1, "androidx.compose.material.TabRow.<anonymous> (TabRow.kt:154)");
                        }
                        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        composer3.startReplaceableGroup(370751195);
                        boolean changedInstance = composer3.changedInstance(function22) | composer3.changedInstance(m1640getLambda1$material_release) | composer3.changedInstance(function33);
                        final Function2<? super Composer, ? super Integer, Unit> function25 = function22;
                        final Function2<? super Composer, ? super Integer, Unit> function26 = m1640getLambda1$material_release;
                        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function35 = function33;
                        Object rememberedValue = composer3.rememberedValue();
                        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.TabRowKt$TabRow$2$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                    return m1814invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                                }

                                /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                                public final MeasureResult m1814invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, final long j9) {
                                    int i12;
                                    Object obj;
                                    final int m6345getMaxWidthimpl = Constraints.m6345getMaxWidthimpl(j9);
                                    List<Measurable> subcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function25);
                                    int size = subcompose.size();
                                    final int i13 = m6345getMaxWidthimpl / size;
                                    ArrayList arrayList = new ArrayList(subcompose.size());
                                    int size2 = subcompose.size();
                                    int i14 = 0;
                                    while (i14 < size2) {
                                        Measurable measurable = subcompose.get(i14);
                                        int i15 = i13;
                                        long m6336copyZbe2FdA$default = Constraints.m6336copyZbe2FdA$default(j9, i15, i13, 0, 0, 12, null);
                                        i13 = i15;
                                        arrayList.add(measurable.mo5333measureBRTryo0(m6336copyZbe2FdA$default));
                                        i14++;
                                        subcompose = subcompose;
                                    }
                                    final List<? extends Placeable> arrayList2 = arrayList;
                                    if (arrayList2.isEmpty()) {
                                        obj = null;
                                        i12 = 0;
                                    } else {
                                        i12 = 0;
                                        obj = arrayList2.get(0);
                                        int height = ((Placeable) obj).getHeight();
                                        int lastIndex = CollectionsKt.getLastIndex(arrayList2);
                                        int i16 = 1;
                                        if (1 <= lastIndex) {
                                            while (true) {
                                                Object obj2 = arrayList2.get(i16);
                                                int height2 = ((Placeable) obj2).getHeight();
                                                if (height < height2) {
                                                    obj = obj2;
                                                    height = height2;
                                                }
                                                if (i16 == lastIndex) {
                                                    break;
                                                }
                                                i16++;
                                            }
                                        }
                                    }
                                    Placeable placeable = (Placeable) obj;
                                    final int height3 = placeable != null ? placeable.getHeight() : i12;
                                    ArrayList arrayList3 = new ArrayList(size);
                                    for (int i17 = i12; i17 < size; i17++) {
                                        arrayList3.add(new TabPosition(Dp.m6389constructorimpl(subcomposeMeasureScope.mo627toDpu2uoSUM(i13) * i17), subcomposeMeasureScope.mo627toDpu2uoSUM(i13), null));
                                    }
                                    final List<TabPosition> arrayList4 = arrayList3;
                                    final Function2<? super Composer, ? super Integer, Unit> function27 = function26;
                                    final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function36 = function35;
                                    return MeasureScope.layout$default(subcomposeMeasureScope, m6345getMaxWidthimpl, height3, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.TabRowKt$TabRow$2$1$1.1
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
                                            List<Placeable> list = arrayList2;
                                            int i18 = i13;
                                            int size3 = list.size();
                                            for (int i19 = 0; i19 < size3; i19++) {
                                                Placeable.PlacementScope.placeRelative$default(placementScope, list.get(i19), i19 * i18, 0, 0.0f, 4, null);
                                            }
                                            List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Divider, function27);
                                            long j10 = j9;
                                            int i20 = height3;
                                            int size4 = subcompose2.size();
                                            for (int i21 = 0; i21 < size4; i21++) {
                                                Placeable mo5333measureBRTryo0 = subcompose2.get(i21).mo5333measureBRTryo0(Constraints.m6336copyZbe2FdA$default(j10, 0, 0, 0, 0, 11, null));
                                                Placeable.PlacementScope.placeRelative$default(placementScope, mo5333measureBRTryo0, 0, i20 - mo5333measureBRTryo0.getHeight(), 0.0f, 4, null);
                                            }
                                            SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                            TabSlots tabSlots = TabSlots.Indicator;
                                            final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function37 = function36;
                                            final List<TabPosition> list2 = arrayList4;
                                            List<Measurable> subcompose3 = subcomposeMeasureScope2.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(-641946361, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt.TabRow.2.1.1.1.3
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

                                                public final void invoke(Composer composer4, int i22) {
                                                    ComposerKt.sourceInformation(composer4, "C180@8501L23:TabRow.kt#jmzs0o");
                                                    if ((i22 & 11) == 2 && composer4.getSkipping()) {
                                                        composer4.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-641946361, i22, -1, "androidx.compose.material.TabRow.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:180)");
                                                    }
                                                    function37.invoke(list2, composer4, 8);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }));
                                            int i22 = m6345getMaxWidthimpl;
                                            int i23 = height3;
                                            int size5 = subcompose3.size();
                                            for (int i24 = 0; i24 < size5; i24++) {
                                                Placeable.PlacementScope.placeRelative$default(placementScope, subcompose3.get(i24).mo5333measureBRTryo0(Constraints.INSTANCE.m6353fixedJhjzzOo(i22, i23)), 0, 0, 0.0f, 4, null);
                                            }
                                        }
                                    }, 4, null);
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue);
                        }
                        composer3.endReplaceableGroup();
                        SubcomposeLayoutKt.SubcomposeLayout(fillMaxWidth$default, (Function2) rememberedValue, composer3, 6, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer2, (i7 & 896) | 1572864 | (i7 & 7168), 50);
                if (ComposerKt.isTraceInProgress()) {
                }
                function34 = function33;
                function24 = m1640getLambda1$material_release;
                modifier3 = modifier2;
                j6 = j5;
                j7 = j822;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            function32 = function3;
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            function23 = function2;
            if ((i3 & 64) == 0) {
            }
            if ((i4 & 2995931) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i9 != 0) {
            }
            if ((i3 & 4) != 0) {
            }
            if ((i3 & 8) != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            function33 = function32;
            j5 = j3;
            i7 = i4;
            m1640getLambda1$material_release = function23;
            long j8222 = j4;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            SurfaceKt.m1782SurfaceFjzlyU(SelectableGroupKt.selectableGroup(modifier2), null, j5, j8222, null, 0.0f, ComposableLambdaKt.composableLambda(startRestartGroup, -1961746365, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt$TabRow$2
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
                    ComposerKt.sourceInformation(composer3, "C154@7324L1371:TabRow.kt#jmzs0o");
                    if ((i11 & 11) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1961746365, i11, -1, "androidx.compose.material.TabRow.<anonymous> (TabRow.kt:154)");
                    }
                    Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    composer3.startReplaceableGroup(370751195);
                    boolean changedInstance = composer3.changedInstance(function22) | composer3.changedInstance(m1640getLambda1$material_release) | composer3.changedInstance(function33);
                    final Function2<? super Composer, ? super Integer, Unit> function25 = function22;
                    final Function2<? super Composer, ? super Integer, Unit> function26 = m1640getLambda1$material_release;
                    final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function35 = function33;
                    Object rememberedValue = composer3.rememberedValue();
                    if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.TabRowKt$TabRow$2$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                return m1814invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                            }

                            /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final MeasureResult m1814invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, final long j9) {
                                int i12;
                                Object obj;
                                final int m6345getMaxWidthimpl = Constraints.m6345getMaxWidthimpl(j9);
                                List<Measurable> subcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function25);
                                int size = subcompose.size();
                                final int i13 = m6345getMaxWidthimpl / size;
                                ArrayList arrayList = new ArrayList(subcompose.size());
                                int size2 = subcompose.size();
                                int i14 = 0;
                                while (i14 < size2) {
                                    Measurable measurable = subcompose.get(i14);
                                    int i15 = i13;
                                    long m6336copyZbe2FdA$default = Constraints.m6336copyZbe2FdA$default(j9, i15, i13, 0, 0, 12, null);
                                    i13 = i15;
                                    arrayList.add(measurable.mo5333measureBRTryo0(m6336copyZbe2FdA$default));
                                    i14++;
                                    subcompose = subcompose;
                                }
                                final List<? extends Placeable> arrayList2 = arrayList;
                                if (arrayList2.isEmpty()) {
                                    obj = null;
                                    i12 = 0;
                                } else {
                                    i12 = 0;
                                    obj = arrayList2.get(0);
                                    int height = ((Placeable) obj).getHeight();
                                    int lastIndex = CollectionsKt.getLastIndex(arrayList2);
                                    int i16 = 1;
                                    if (1 <= lastIndex) {
                                        while (true) {
                                            Object obj2 = arrayList2.get(i16);
                                            int height2 = ((Placeable) obj2).getHeight();
                                            if (height < height2) {
                                                obj = obj2;
                                                height = height2;
                                            }
                                            if (i16 == lastIndex) {
                                                break;
                                            }
                                            i16++;
                                        }
                                    }
                                }
                                Placeable placeable = (Placeable) obj;
                                final int height3 = placeable != null ? placeable.getHeight() : i12;
                                ArrayList arrayList3 = new ArrayList(size);
                                for (int i17 = i12; i17 < size; i17++) {
                                    arrayList3.add(new TabPosition(Dp.m6389constructorimpl(subcomposeMeasureScope.mo627toDpu2uoSUM(i13) * i17), subcomposeMeasureScope.mo627toDpu2uoSUM(i13), null));
                                }
                                final List<TabPosition> arrayList4 = arrayList3;
                                final Function2<? super Composer, ? super Integer, Unit> function27 = function26;
                                final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function36 = function35;
                                return MeasureScope.layout$default(subcomposeMeasureScope, m6345getMaxWidthimpl, height3, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.TabRowKt$TabRow$2$1$1.1
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
                                        List<Placeable> list = arrayList2;
                                        int i18 = i13;
                                        int size3 = list.size();
                                        for (int i19 = 0; i19 < size3; i19++) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, list.get(i19), i19 * i18, 0, 0.0f, 4, null);
                                        }
                                        List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Divider, function27);
                                        long j10 = j9;
                                        int i20 = height3;
                                        int size4 = subcompose2.size();
                                        for (int i21 = 0; i21 < size4; i21++) {
                                            Placeable mo5333measureBRTryo0 = subcompose2.get(i21).mo5333measureBRTryo0(Constraints.m6336copyZbe2FdA$default(j10, 0, 0, 0, 0, 11, null));
                                            Placeable.PlacementScope.placeRelative$default(placementScope, mo5333measureBRTryo0, 0, i20 - mo5333measureBRTryo0.getHeight(), 0.0f, 4, null);
                                        }
                                        SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                        TabSlots tabSlots = TabSlots.Indicator;
                                        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function37 = function36;
                                        final List<TabPosition> list2 = arrayList4;
                                        List<Measurable> subcompose3 = subcomposeMeasureScope2.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(-641946361, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt.TabRow.2.1.1.1.3
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

                                            public final void invoke(Composer composer4, int i22) {
                                                ComposerKt.sourceInformation(composer4, "C180@8501L23:TabRow.kt#jmzs0o");
                                                if ((i22 & 11) == 2 && composer4.getSkipping()) {
                                                    composer4.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-641946361, i22, -1, "androidx.compose.material.TabRow.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:180)");
                                                }
                                                function37.invoke(list2, composer4, 8);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }));
                                        int i22 = m6345getMaxWidthimpl;
                                        int i23 = height3;
                                        int size5 = subcompose3.size();
                                        for (int i24 = 0; i24 < size5; i24++) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, subcompose3.get(i24).mo5333measureBRTryo0(Constraints.INSTANCE.m6353fixedJhjzzOo(i22, i23)), 0, 0, 0.0f, 4, null);
                                        }
                                    }
                                }, 4, null);
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue);
                    }
                    composer3.endReplaceableGroup();
                    SubcomposeLayoutKt.SubcomposeLayout(fillMaxWidth$default, (Function2) rememberedValue, composer3, 6, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composer2, (i7 & 896) | 1572864 | (i7 & 7168), 50);
            if (ComposerKt.isTraceInProgress()) {
            }
            function34 = function33;
            function24 = m1640getLambda1$material_release;
            modifier3 = modifier2;
            j6 = j5;
            j7 = j8222;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        if ((i2 & 896) != 0) {
        }
        if ((i2 & 7168) != 0) {
        }
        i5 = i3 & 16;
        if (i5 == 0) {
        }
        function32 = function3;
        i6 = i3 & 32;
        if (i6 != 0) {
        }
        function23 = function2;
        if ((i3 & 64) == 0) {
        }
        if ((i4 & 2995931) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i9 != 0) {
        }
        if ((i3 & 4) != 0) {
        }
        if ((i3 & 8) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        function33 = function32;
        j5 = j3;
        i7 = i4;
        m1640getLambda1$material_release = function23;
        long j82222 = j4;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        SurfaceKt.m1782SurfaceFjzlyU(SelectableGroupKt.selectableGroup(modifier2), null, j5, j82222, null, 0.0f, ComposableLambdaKt.composableLambda(startRestartGroup, -1961746365, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt$TabRow$2
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
                ComposerKt.sourceInformation(composer3, "C154@7324L1371:TabRow.kt#jmzs0o");
                if ((i11 & 11) == 2 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1961746365, i11, -1, "androidx.compose.material.TabRow.<anonymous> (TabRow.kt:154)");
                }
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                composer3.startReplaceableGroup(370751195);
                boolean changedInstance = composer3.changedInstance(function22) | composer3.changedInstance(m1640getLambda1$material_release) | composer3.changedInstance(function33);
                final Function2<? super Composer, ? super Integer, Unit> function25 = function22;
                final Function2<? super Composer, ? super Integer, Unit> function26 = m1640getLambda1$material_release;
                final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function35 = function33;
                Object rememberedValue = composer3.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.TabRowKt$TabRow$2$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                            return m1814invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                        }

                        /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                        public final MeasureResult m1814invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, final long j9) {
                            int i12;
                            Object obj;
                            final int m6345getMaxWidthimpl = Constraints.m6345getMaxWidthimpl(j9);
                            List<Measurable> subcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function25);
                            int size = subcompose.size();
                            final int i13 = m6345getMaxWidthimpl / size;
                            ArrayList arrayList = new ArrayList(subcompose.size());
                            int size2 = subcompose.size();
                            int i14 = 0;
                            while (i14 < size2) {
                                Measurable measurable = subcompose.get(i14);
                                int i15 = i13;
                                long m6336copyZbe2FdA$default = Constraints.m6336copyZbe2FdA$default(j9, i15, i13, 0, 0, 12, null);
                                i13 = i15;
                                arrayList.add(measurable.mo5333measureBRTryo0(m6336copyZbe2FdA$default));
                                i14++;
                                subcompose = subcompose;
                            }
                            final List<? extends Placeable> arrayList2 = arrayList;
                            if (arrayList2.isEmpty()) {
                                obj = null;
                                i12 = 0;
                            } else {
                                i12 = 0;
                                obj = arrayList2.get(0);
                                int height = ((Placeable) obj).getHeight();
                                int lastIndex = CollectionsKt.getLastIndex(arrayList2);
                                int i16 = 1;
                                if (1 <= lastIndex) {
                                    while (true) {
                                        Object obj2 = arrayList2.get(i16);
                                        int height2 = ((Placeable) obj2).getHeight();
                                        if (height < height2) {
                                            obj = obj2;
                                            height = height2;
                                        }
                                        if (i16 == lastIndex) {
                                            break;
                                        }
                                        i16++;
                                    }
                                }
                            }
                            Placeable placeable = (Placeable) obj;
                            final int height3 = placeable != null ? placeable.getHeight() : i12;
                            ArrayList arrayList3 = new ArrayList(size);
                            for (int i17 = i12; i17 < size; i17++) {
                                arrayList3.add(new TabPosition(Dp.m6389constructorimpl(subcomposeMeasureScope.mo627toDpu2uoSUM(i13) * i17), subcomposeMeasureScope.mo627toDpu2uoSUM(i13), null));
                            }
                            final List<TabPosition> arrayList4 = arrayList3;
                            final Function2<? super Composer, ? super Integer, Unit> function27 = function26;
                            final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function36 = function35;
                            return MeasureScope.layout$default(subcomposeMeasureScope, m6345getMaxWidthimpl, height3, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.TabRowKt$TabRow$2$1$1.1
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
                                    List<Placeable> list = arrayList2;
                                    int i18 = i13;
                                    int size3 = list.size();
                                    for (int i19 = 0; i19 < size3; i19++) {
                                        Placeable.PlacementScope.placeRelative$default(placementScope, list.get(i19), i19 * i18, 0, 0.0f, 4, null);
                                    }
                                    List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Divider, function27);
                                    long j10 = j9;
                                    int i20 = height3;
                                    int size4 = subcompose2.size();
                                    for (int i21 = 0; i21 < size4; i21++) {
                                        Placeable mo5333measureBRTryo0 = subcompose2.get(i21).mo5333measureBRTryo0(Constraints.m6336copyZbe2FdA$default(j10, 0, 0, 0, 0, 11, null));
                                        Placeable.PlacementScope.placeRelative$default(placementScope, mo5333measureBRTryo0, 0, i20 - mo5333measureBRTryo0.getHeight(), 0.0f, 4, null);
                                    }
                                    SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                    TabSlots tabSlots = TabSlots.Indicator;
                                    final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function37 = function36;
                                    final List<TabPosition> list2 = arrayList4;
                                    List<Measurable> subcompose3 = subcomposeMeasureScope2.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(-641946361, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt.TabRow.2.1.1.1.3
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

                                        public final void invoke(Composer composer4, int i22) {
                                            ComposerKt.sourceInformation(composer4, "C180@8501L23:TabRow.kt#jmzs0o");
                                            if ((i22 & 11) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-641946361, i22, -1, "androidx.compose.material.TabRow.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:180)");
                                            }
                                            function37.invoke(list2, composer4, 8);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }));
                                    int i22 = m6345getMaxWidthimpl;
                                    int i23 = height3;
                                    int size5 = subcompose3.size();
                                    for (int i24 = 0; i24 < size5; i24++) {
                                        Placeable.PlacementScope.placeRelative$default(placementScope, subcompose3.get(i24).mo5333measureBRTryo0(Constraints.INSTANCE.m6353fixedJhjzzOo(i22, i23)), 0, 0, 0.0f, 4, null);
                                    }
                                }
                            }, 4, null);
                        }
                    };
                    composer3.updateRememberedValue(rememberedValue);
                }
                composer3.endReplaceableGroup();
                SubcomposeLayoutKt.SubcomposeLayout(fillMaxWidth$default, (Function2) rememberedValue, composer3, 6, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composer2, (i7 & 896) | 1572864 | (i7 & 7168), 50);
        if (ComposerKt.isTraceInProgress()) {
        }
        function34 = function33;
        function24 = m1640getLambda1$material_release;
        modifier3 = modifier2;
        j6 = j5;
        j7 = j82222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00a3  */
    /* renamed from: ScrollableTabRow-sKfQg0A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1811ScrollableTabRowsKfQg0A(final int i, Modifier modifier, long j, long j2, float f, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        long j3;
        long j4;
        int i5;
        float f2;
        int i6;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function32;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> m1641getLambda2$material_release;
        float f3;
        Modifier modifier3;
        int i8;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function33;
        long j5;
        int i9;
        long j6;
        int i10;
        Composer composer2;
        final float f4;
        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function34;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        final Modifier modifier4;
        final long j7;
        final long j8;
        ScopeUpdateScope endRestartGroup;
        int i11;
        int i12;
        Composer startRestartGroup = composer.startRestartGroup(-1473476840);
        ComposerKt.sourceInformation(startRestartGroup, "C(ScrollableTabRow)P(6,5,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp,4)229@11309L6,230@11358L32,244@11877L3026:TabRow.kt#jmzs0o");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i4 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i13 = i3 & 2;
        if (i13 != 0) {
            i4 |= 48;
        } else if ((i2 & 112) == 0) {
            modifier2 = modifier;
            i4 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i2 & 896) != 0) {
                if ((i3 & 4) == 0) {
                    j3 = j;
                    if (startRestartGroup.changed(j3)) {
                        i12 = 256;
                        i4 |= i12;
                    }
                } else {
                    j3 = j;
                }
                i12 = 128;
                i4 |= i12;
            } else {
                j3 = j;
            }
            if ((i2 & 7168) != 0) {
                if ((i3 & 8) == 0) {
                    j4 = j2;
                    if (startRestartGroup.changed(j4)) {
                        i11 = 2048;
                        i4 |= i11;
                    }
                } else {
                    j4 = j2;
                }
                i11 = 1024;
                i4 |= i11;
            } else {
                j4 = j2;
            }
            i5 = i3 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else if ((57344 & i2) == 0) {
                f2 = f;
                i4 |= startRestartGroup.changed(f2) ? 16384 : 8192;
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((458752 & i2) == 0) {
                    function32 = function3;
                    i4 |= startRestartGroup.changedInstance(function32) ? 131072 : 65536;
                    i7 = i3 & 64;
                    if (i7 == 0) {
                        i4 |= 1572864;
                    } else if ((i2 & 3670016) == 0) {
                        i4 |= startRestartGroup.changedInstance(function2) ? 1048576 : 524288;
                    }
                    if ((i3 & 128) == 0) {
                        i4 |= 12582912;
                    } else if ((29360128 & i2) == 0) {
                        i4 |= startRestartGroup.changedInstance(function22) ? 8388608 : 4194304;
                        if ((i4 & 23967451) == 4793490 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                if (i13 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if ((i3 & 4) != 0) {
                                    j3 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(startRestartGroup, 6));
                                    i4 &= -897;
                                }
                                if ((i3 & 8) != 0) {
                                    j4 = ColorsKt.m1621contentColorForek8zF_U(j3, startRestartGroup, (i4 >> 6) & 14);
                                    i4 &= -7169;
                                }
                                if (i5 != 0) {
                                    f2 = TabRowDefaults.INSTANCE.m1810getScrollableTabRowPaddingD9Ej5fM();
                                }
                                if (i6 != 0) {
                                    function32 = ComposableLambdaKt.composableLambda(startRestartGroup, -655609869, true, new Function3<List<? extends TabPosition>, Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt$ScrollableTabRow$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(List<? extends TabPosition> list, Composer composer3, Integer num) {
                                            invoke((List<TabPosition>) list, composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(List<TabPosition> list, Composer composer3, int i14) {
                                            ComposerKt.sourceInformation(composer3, "C234@11600L92:TabRow.kt#jmzs0o");
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-655609869, i14, -1, "androidx.compose.material.ScrollableTabRow.<anonymous> (TabRow.kt:234)");
                                            }
                                            TabRowDefaults.INSTANCE.m1807Indicator9IZ8Weo(TabRowDefaults.INSTANCE.tabIndicatorOffset(Modifier.INSTANCE, list.get(i)), 0.0f, 0L, composer3, 3072, 6);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    });
                                }
                                if (i7 != 0) {
                                    Modifier modifier5 = modifier2;
                                    m1641getLambda2$material_release = ComposableSingletons$TabRowKt.INSTANCE.m1641getLambda2$material_release();
                                    f3 = f2;
                                    modifier3 = modifier5;
                                    long j9 = j3;
                                    i8 = i4;
                                    function33 = function32;
                                    j5 = j9;
                                    i9 = 1572864;
                                    j6 = j4;
                                    i10 = -1473476840;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(i10, i8, -1, "androidx.compose.material.ScrollableTabRow (TabRow.kt:243)");
                                    }
                                    final float f5 = f3;
                                    final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function35 = function33;
                                    final Function2<? super Composer, ? super Integer, Unit> function24 = m1641getLambda2$material_release;
                                    composer2 = startRestartGroup;
                                    SurfaceKt.m1782SurfaceFjzlyU(modifier3, null, j5, j6, null, 0.0f, ComposableLambdaKt.composableLambda(startRestartGroup, 1455860572, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt$ScrollableTabRow$2
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
                                            ComposerKt.sourceInformation(composer3, "C249@12018L21,250@12069L24,251@12126L185,257@12320L2577:TabRow.kt#jmzs0o");
                                            if ((i14 & 11) != 2 || !composer3.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1455860572, i14, -1, "androidx.compose.material.ScrollableTabRow.<anonymous> (TabRow.kt:249)");
                                                }
                                                ScrollState rememberScrollState = ScrollKt.rememberScrollState(0, composer3, 0, 1);
                                                composer3.startReplaceableGroup(773894976);
                                                ComposerKt.sourceInformation(composer3, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                                                composer3.startReplaceableGroup(-492369756);
                                                ComposerKt.sourceInformation(composer3, "CC(remember):Composables.kt#9igjgp");
                                                Object rememberedValue = composer3.rememberedValue();
                                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                    Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer3));
                                                    composer3.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                                                    rememberedValue = compositionScopedCoroutineScopeCanceller;
                                                }
                                                composer3.endReplaceableGroup();
                                                CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                                                composer3.endReplaceableGroup();
                                                composer3.startReplaceableGroup(511388516);
                                                ComposerKt.sourceInformation(composer3, "CC(remember)P(1,2):Composables.kt#9igjgp");
                                                boolean changed = composer3.changed(rememberScrollState) | composer3.changed(coroutineScope);
                                                Object rememberedValue2 = composer3.rememberedValue();
                                                if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue2 = new ScrollableTabData(rememberScrollState, coroutineScope);
                                                    composer3.updateRememberedValue(rememberedValue2);
                                                }
                                                composer3.endReplaceableGroup();
                                                final ScrollableTabData scrollableTabData = (ScrollableTabData) rememberedValue2;
                                                Modifier clipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getCenterStart(), false, 2, null), rememberScrollState, false, null, false, 14, null)));
                                                final float f6 = f5;
                                                final Function2<Composer, Integer, Unit> function25 = function22;
                                                final Function2<Composer, Integer, Unit> function26 = function24;
                                                final int i15 = i;
                                                final Function3<List<TabPosition>, Composer, Integer, Unit> function36 = function35;
                                                SubcomposeLayoutKt.SubcomposeLayout(clipToBounds, new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.TabRowKt$ScrollableTabRow$2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                                        return m1813invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                                                    }

                                                    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                                                    public final MeasureResult m1813invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, final long j10) {
                                                        float f7;
                                                        f7 = TabRowKt.ScrollableTabRowMinimumTabWidth;
                                                        int i16 = subcomposeMeasureScope.mo624roundToPx0680j_4(f7);
                                                        final int i17 = subcomposeMeasureScope.mo624roundToPx0680j_4(f6);
                                                        long m6336copyZbe2FdA$default = Constraints.m6336copyZbe2FdA$default(j10, i16, 0, 0, 0, 14, null);
                                                        List<Measurable> subcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function25);
                                                        ArrayList arrayList = new ArrayList(subcompose.size());
                                                        int size = subcompose.size();
                                                        for (int i18 = 0; i18 < size; i18++) {
                                                            arrayList.add(subcompose.get(i18).mo5333measureBRTryo0(m6336copyZbe2FdA$default));
                                                        }
                                                        final ArrayList arrayList2 = arrayList;
                                                        final Ref.IntRef intRef = new Ref.IntRef();
                                                        intRef.element = i17 * 2;
                                                        final Ref.IntRef intRef2 = new Ref.IntRef();
                                                        int size2 = arrayList2.size();
                                                        for (int i19 = 0; i19 < size2; i19++) {
                                                            Placeable placeable = (Placeable) arrayList2.get(i19);
                                                            intRef.element += placeable.getWidth();
                                                            intRef2.element = Math.max(intRef2.element, placeable.getHeight());
                                                        }
                                                        int i20 = intRef.element;
                                                        int i21 = intRef2.element;
                                                        final Function2<Composer, Integer, Unit> function27 = function26;
                                                        final ScrollableTabData scrollableTabData2 = scrollableTabData;
                                                        final int i22 = i15;
                                                        final Function3<List<TabPosition>, Composer, Integer, Unit> function37 = function36;
                                                        return MeasureScope.layout$default(subcomposeMeasureScope, i20, i21, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.TabRowKt.ScrollableTabRow.2.1.2
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
                                                                final ArrayList arrayList3 = new ArrayList();
                                                                int i23 = i17;
                                                                List<Placeable> list = arrayList2;
                                                                SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                                                int size3 = list.size();
                                                                int i24 = i23;
                                                                for (int i25 = 0; i25 < size3; i25++) {
                                                                    Placeable placeable2 = list.get(i25);
                                                                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i24, 0, 0.0f, 4, null);
                                                                    arrayList3.add(new TabPosition(subcomposeMeasureScope2.mo627toDpu2uoSUM(i24), subcomposeMeasureScope2.mo627toDpu2uoSUM(placeable2.getWidth()), null));
                                                                    i24 += placeable2.getWidth();
                                                                }
                                                                List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Divider, function27);
                                                                long j11 = j10;
                                                                Ref.IntRef intRef3 = intRef;
                                                                Ref.IntRef intRef4 = intRef2;
                                                                int size4 = subcompose2.size();
                                                                for (int i26 = 0; i26 < size4; i26++) {
                                                                    Placeable mo5333measureBRTryo0 = subcompose2.get(i26).mo5333measureBRTryo0(Constraints.m6336copyZbe2FdA$default(j11, intRef3.element, intRef3.element, 0, 0, 8, null));
                                                                    Placeable.PlacementScope.placeRelative$default(placementScope, mo5333measureBRTryo0, 0, intRef4.element - mo5333measureBRTryo0.getHeight(), 0.0f, 4, null);
                                                                }
                                                                SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope;
                                                                TabSlots tabSlots = TabSlots.Indicator;
                                                                final Function3<List<TabPosition>, Composer, Integer, Unit> function38 = function37;
                                                                List<Measurable> subcompose3 = subcomposeMeasureScope3.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(-411868839, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt.ScrollableTabRow.2.1.2.3
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

                                                                    public final void invoke(Composer composer4, int i27) {
                                                                        ComposerKt.sourceInformation(composer4, "C305@14444L23:TabRow.kt#jmzs0o");
                                                                        if ((i27 & 11) == 2 && composer4.getSkipping()) {
                                                                            composer4.skipToGroupEnd();
                                                                            return;
                                                                        }
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(-411868839, i27, -1, "androidx.compose.material.ScrollableTabRow.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:305)");
                                                                        }
                                                                        function38.invoke(arrayList3, composer4, 8);
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                        }
                                                                    }
                                                                }));
                                                                Ref.IntRef intRef5 = intRef;
                                                                Ref.IntRef intRef6 = intRef2;
                                                                int size5 = subcompose3.size();
                                                                for (int i27 = 0; i27 < size5; i27++) {
                                                                    Placeable.PlacementScope.placeRelative$default(placementScope, subcompose3.get(i27).mo5333measureBRTryo0(Constraints.INSTANCE.m6353fixedJhjzzOo(intRef5.element, intRef6.element)), 0, 0, 0.0f, 4, null);
                                                                }
                                                                scrollableTabData2.onLaidOut(subcomposeMeasureScope, i17, arrayList3, i22);
                                                            }
                                                        }, 4, null);
                                                    }
                                                }, composer3, 0, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    }), composer2, ((i8 >> 3) & 14) | i9 | (i8 & 896) | (i8 & 7168), 50);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    f4 = f5;
                                    function34 = function33;
                                    function23 = m1641getLambda2$material_release;
                                    modifier4 = modifier3;
                                    j7 = j5;
                                    j8 = j6;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i3 & 4) != 0) {
                                    i4 &= -897;
                                }
                                if ((i3 & 8) != 0) {
                                    i4 &= -7169;
                                }
                            }
                            long j10 = j3;
                            i8 = i4;
                            function33 = function32;
                            j5 = j10;
                            f3 = f2;
                            i9 = 1572864;
                            modifier3 = modifier2;
                            j6 = j4;
                            i10 = -1473476840;
                            m1641getLambda2$material_release = function2;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            final float f52 = f3;
                            final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function352 = function33;
                            final Function2<? super Composer, ? super Integer, Unit> function242 = m1641getLambda2$material_release;
                            composer2 = startRestartGroup;
                            SurfaceKt.m1782SurfaceFjzlyU(modifier3, null, j5, j6, null, 0.0f, ComposableLambdaKt.composableLambda(startRestartGroup, 1455860572, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt$ScrollableTabRow$2
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
                                    ComposerKt.sourceInformation(composer3, "C249@12018L21,250@12069L24,251@12126L185,257@12320L2577:TabRow.kt#jmzs0o");
                                    if ((i14 & 11) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1455860572, i14, -1, "androidx.compose.material.ScrollableTabRow.<anonymous> (TabRow.kt:249)");
                                        }
                                        ScrollState rememberScrollState = ScrollKt.rememberScrollState(0, composer3, 0, 1);
                                        composer3.startReplaceableGroup(773894976);
                                        ComposerKt.sourceInformation(composer3, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                                        composer3.startReplaceableGroup(-492369756);
                                        ComposerKt.sourceInformation(composer3, "CC(remember):Composables.kt#9igjgp");
                                        Object rememberedValue = composer3.rememberedValue();
                                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                            Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer3));
                                            composer3.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                                            rememberedValue = compositionScopedCoroutineScopeCanceller;
                                        }
                                        composer3.endReplaceableGroup();
                                        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                                        composer3.endReplaceableGroup();
                                        composer3.startReplaceableGroup(511388516);
                                        ComposerKt.sourceInformation(composer3, "CC(remember)P(1,2):Composables.kt#9igjgp");
                                        boolean changed = composer3.changed(rememberScrollState) | composer3.changed(coroutineScope);
                                        Object rememberedValue2 = composer3.rememberedValue();
                                        if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue2 = new ScrollableTabData(rememberScrollState, coroutineScope);
                                            composer3.updateRememberedValue(rememberedValue2);
                                        }
                                        composer3.endReplaceableGroup();
                                        final ScrollableTabData scrollableTabData = (ScrollableTabData) rememberedValue2;
                                        Modifier clipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getCenterStart(), false, 2, null), rememberScrollState, false, null, false, 14, null)));
                                        final float f6 = f52;
                                        final Function2<? super Composer, ? super Integer, Unit> function25 = function22;
                                        final Function2<? super Composer, ? super Integer, Unit> function26 = function242;
                                        final int i15 = i;
                                        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function36 = function352;
                                        SubcomposeLayoutKt.SubcomposeLayout(clipToBounds, new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.TabRowKt$ScrollableTabRow$2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                                return m1813invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                                            }

                                            /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                                            public final MeasureResult m1813invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, final long j102) {
                                                float f7;
                                                f7 = TabRowKt.ScrollableTabRowMinimumTabWidth;
                                                int i16 = subcomposeMeasureScope.mo624roundToPx0680j_4(f7);
                                                final int i17 = subcomposeMeasureScope.mo624roundToPx0680j_4(f6);
                                                long m6336copyZbe2FdA$default = Constraints.m6336copyZbe2FdA$default(j102, i16, 0, 0, 0, 14, null);
                                                List<Measurable> subcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function25);
                                                ArrayList arrayList = new ArrayList(subcompose.size());
                                                int size = subcompose.size();
                                                for (int i18 = 0; i18 < size; i18++) {
                                                    arrayList.add(subcompose.get(i18).mo5333measureBRTryo0(m6336copyZbe2FdA$default));
                                                }
                                                final List<? extends Placeable> arrayList2 = arrayList;
                                                final Ref.IntRef intRef = new Ref.IntRef();
                                                intRef.element = i17 * 2;
                                                final Ref.IntRef intRef2 = new Ref.IntRef();
                                                int size2 = arrayList2.size();
                                                for (int i19 = 0; i19 < size2; i19++) {
                                                    Placeable placeable = (Placeable) arrayList2.get(i19);
                                                    intRef.element += placeable.getWidth();
                                                    intRef2.element = Math.max(intRef2.element, placeable.getHeight());
                                                }
                                                int i20 = intRef.element;
                                                int i21 = intRef2.element;
                                                final Function2<? super Composer, ? super Integer, Unit> function27 = function26;
                                                final ScrollableTabData scrollableTabData2 = scrollableTabData;
                                                final int i22 = i15;
                                                final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function37 = function36;
                                                return MeasureScope.layout$default(subcomposeMeasureScope, i20, i21, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.TabRowKt.ScrollableTabRow.2.1.2
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
                                                        final List<TabPosition> arrayList3 = new ArrayList();
                                                        int i23 = i17;
                                                        List<Placeable> list = arrayList2;
                                                        SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                                        int size3 = list.size();
                                                        int i24 = i23;
                                                        for (int i25 = 0; i25 < size3; i25++) {
                                                            Placeable placeable2 = list.get(i25);
                                                            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i24, 0, 0.0f, 4, null);
                                                            arrayList3.add(new TabPosition(subcomposeMeasureScope2.mo627toDpu2uoSUM(i24), subcomposeMeasureScope2.mo627toDpu2uoSUM(placeable2.getWidth()), null));
                                                            i24 += placeable2.getWidth();
                                                        }
                                                        List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Divider, function27);
                                                        long j11 = j102;
                                                        Ref.IntRef intRef3 = intRef;
                                                        Ref.IntRef intRef4 = intRef2;
                                                        int size4 = subcompose2.size();
                                                        for (int i26 = 0; i26 < size4; i26++) {
                                                            Placeable mo5333measureBRTryo0 = subcompose2.get(i26).mo5333measureBRTryo0(Constraints.m6336copyZbe2FdA$default(j11, intRef3.element, intRef3.element, 0, 0, 8, null));
                                                            Placeable.PlacementScope.placeRelative$default(placementScope, mo5333measureBRTryo0, 0, intRef4.element - mo5333measureBRTryo0.getHeight(), 0.0f, 4, null);
                                                        }
                                                        SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope;
                                                        TabSlots tabSlots = TabSlots.Indicator;
                                                        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function38 = function37;
                                                        List<Measurable> subcompose3 = subcomposeMeasureScope3.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(-411868839, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt.ScrollableTabRow.2.1.2.3
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

                                                            public final void invoke(Composer composer4, int i27) {
                                                                ComposerKt.sourceInformation(composer4, "C305@14444L23:TabRow.kt#jmzs0o");
                                                                if ((i27 & 11) == 2 && composer4.getSkipping()) {
                                                                    composer4.skipToGroupEnd();
                                                                    return;
                                                                }
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-411868839, i27, -1, "androidx.compose.material.ScrollableTabRow.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:305)");
                                                                }
                                                                function38.invoke(arrayList3, composer4, 8);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                        }));
                                                        Ref.IntRef intRef5 = intRef;
                                                        Ref.IntRef intRef6 = intRef2;
                                                        int size5 = subcompose3.size();
                                                        for (int i27 = 0; i27 < size5; i27++) {
                                                            Placeable.PlacementScope.placeRelative$default(placementScope, subcompose3.get(i27).mo5333measureBRTryo0(Constraints.INSTANCE.m6353fixedJhjzzOo(intRef5.element, intRef6.element)), 0, 0, 0.0f, 4, null);
                                                        }
                                                        scrollableTabData2.onLaidOut(subcomposeMeasureScope, i17, arrayList3, i22);
                                                    }
                                                }, 4, null);
                                            }
                                        }, composer3, 0, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), composer2, ((i8 >> 3) & 14) | i9 | (i8 & 896) | (i8 & 7168), 50);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            f4 = f52;
                            function34 = function33;
                            function23 = m1641getLambda2$material_release;
                            modifier4 = modifier3;
                            j7 = j5;
                            j8 = j6;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            composer2 = startRestartGroup;
                            modifier4 = modifier2;
                            j7 = j3;
                            j8 = j4;
                            f4 = f2;
                            function34 = function32;
                            function23 = function2;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt$ScrollableTabRow$3
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
                                    TabRowKt.m1811ScrollableTabRowsKfQg0A(i, modifier4, j7, j8, f4, function34, function23, function22, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i4 & 23967451) == 4793490) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                    }
                    if (i13 != 0) {
                    }
                    if ((i3 & 4) != 0) {
                    }
                    if ((i3 & 8) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    long j102 = j3;
                    i8 = i4;
                    function33 = function32;
                    j5 = j102;
                    f3 = f2;
                    i9 = 1572864;
                    modifier3 = modifier2;
                    j6 = j4;
                    i10 = -1473476840;
                    m1641getLambda2$material_release = function2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    final float f522 = f3;
                    final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3522 = function33;
                    final Function2<? super Composer, ? super Integer, Unit> function2422 = m1641getLambda2$material_release;
                    composer2 = startRestartGroup;
                    SurfaceKt.m1782SurfaceFjzlyU(modifier3, null, j5, j6, null, 0.0f, ComposableLambdaKt.composableLambda(startRestartGroup, 1455860572, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt$ScrollableTabRow$2
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
                            ComposerKt.sourceInformation(composer3, "C249@12018L21,250@12069L24,251@12126L185,257@12320L2577:TabRow.kt#jmzs0o");
                            if ((i14 & 11) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1455860572, i14, -1, "androidx.compose.material.ScrollableTabRow.<anonymous> (TabRow.kt:249)");
                                }
                                ScrollState rememberScrollState = ScrollKt.rememberScrollState(0, composer3, 0, 1);
                                composer3.startReplaceableGroup(773894976);
                                ComposerKt.sourceInformation(composer3, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                                composer3.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(composer3, "CC(remember):Composables.kt#9igjgp");
                                Object rememberedValue = composer3.rememberedValue();
                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer3));
                                    composer3.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                                    rememberedValue = compositionScopedCoroutineScopeCanceller;
                                }
                                composer3.endReplaceableGroup();
                                CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                                composer3.endReplaceableGroup();
                                composer3.startReplaceableGroup(511388516);
                                ComposerKt.sourceInformation(composer3, "CC(remember)P(1,2):Composables.kt#9igjgp");
                                boolean changed = composer3.changed(rememberScrollState) | composer3.changed(coroutineScope);
                                Object rememberedValue2 = composer3.rememberedValue();
                                if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue2 = new ScrollableTabData(rememberScrollState, coroutineScope);
                                    composer3.updateRememberedValue(rememberedValue2);
                                }
                                composer3.endReplaceableGroup();
                                final ScrollableTabData scrollableTabData = (ScrollableTabData) rememberedValue2;
                                Modifier clipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getCenterStart(), false, 2, null), rememberScrollState, false, null, false, 14, null)));
                                final float f6 = f522;
                                final Function2<? super Composer, ? super Integer, Unit> function25 = function22;
                                final Function2<? super Composer, ? super Integer, Unit> function26 = function2422;
                                final int i15 = i;
                                final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function36 = function3522;
                                SubcomposeLayoutKt.SubcomposeLayout(clipToBounds, new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.TabRowKt$ScrollableTabRow$2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                        return m1813invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                                    }

                                    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                                    public final MeasureResult m1813invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, final long j1022) {
                                        float f7;
                                        f7 = TabRowKt.ScrollableTabRowMinimumTabWidth;
                                        int i16 = subcomposeMeasureScope.mo624roundToPx0680j_4(f7);
                                        final int i17 = subcomposeMeasureScope.mo624roundToPx0680j_4(f6);
                                        long m6336copyZbe2FdA$default = Constraints.m6336copyZbe2FdA$default(j1022, i16, 0, 0, 0, 14, null);
                                        List<Measurable> subcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function25);
                                        ArrayList arrayList = new ArrayList(subcompose.size());
                                        int size = subcompose.size();
                                        for (int i18 = 0; i18 < size; i18++) {
                                            arrayList.add(subcompose.get(i18).mo5333measureBRTryo0(m6336copyZbe2FdA$default));
                                        }
                                        final List<? extends Placeable> arrayList2 = arrayList;
                                        final Ref.IntRef intRef = new Ref.IntRef();
                                        intRef.element = i17 * 2;
                                        final Ref.IntRef intRef2 = new Ref.IntRef();
                                        int size2 = arrayList2.size();
                                        for (int i19 = 0; i19 < size2; i19++) {
                                            Placeable placeable = (Placeable) arrayList2.get(i19);
                                            intRef.element += placeable.getWidth();
                                            intRef2.element = Math.max(intRef2.element, placeable.getHeight());
                                        }
                                        int i20 = intRef.element;
                                        int i21 = intRef2.element;
                                        final Function2<? super Composer, ? super Integer, Unit> function27 = function26;
                                        final ScrollableTabData scrollableTabData2 = scrollableTabData;
                                        final int i22 = i15;
                                        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function37 = function36;
                                        return MeasureScope.layout$default(subcomposeMeasureScope, i20, i21, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.TabRowKt.ScrollableTabRow.2.1.2
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
                                                final List<TabPosition> arrayList3 = new ArrayList();
                                                int i23 = i17;
                                                List<Placeable> list = arrayList2;
                                                SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                                int size3 = list.size();
                                                int i24 = i23;
                                                for (int i25 = 0; i25 < size3; i25++) {
                                                    Placeable placeable2 = list.get(i25);
                                                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i24, 0, 0.0f, 4, null);
                                                    arrayList3.add(new TabPosition(subcomposeMeasureScope2.mo627toDpu2uoSUM(i24), subcomposeMeasureScope2.mo627toDpu2uoSUM(placeable2.getWidth()), null));
                                                    i24 += placeable2.getWidth();
                                                }
                                                List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Divider, function27);
                                                long j11 = j1022;
                                                Ref.IntRef intRef3 = intRef;
                                                Ref.IntRef intRef4 = intRef2;
                                                int size4 = subcompose2.size();
                                                for (int i26 = 0; i26 < size4; i26++) {
                                                    Placeable mo5333measureBRTryo0 = subcompose2.get(i26).mo5333measureBRTryo0(Constraints.m6336copyZbe2FdA$default(j11, intRef3.element, intRef3.element, 0, 0, 8, null));
                                                    Placeable.PlacementScope.placeRelative$default(placementScope, mo5333measureBRTryo0, 0, intRef4.element - mo5333measureBRTryo0.getHeight(), 0.0f, 4, null);
                                                }
                                                SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope;
                                                TabSlots tabSlots = TabSlots.Indicator;
                                                final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function38 = function37;
                                                List<Measurable> subcompose3 = subcomposeMeasureScope3.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(-411868839, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt.ScrollableTabRow.2.1.2.3
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

                                                    public final void invoke(Composer composer4, int i27) {
                                                        ComposerKt.sourceInformation(composer4, "C305@14444L23:TabRow.kt#jmzs0o");
                                                        if ((i27 & 11) == 2 && composer4.getSkipping()) {
                                                            composer4.skipToGroupEnd();
                                                            return;
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-411868839, i27, -1, "androidx.compose.material.ScrollableTabRow.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:305)");
                                                        }
                                                        function38.invoke(arrayList3, composer4, 8);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }));
                                                Ref.IntRef intRef5 = intRef;
                                                Ref.IntRef intRef6 = intRef2;
                                                int size5 = subcompose3.size();
                                                for (int i27 = 0; i27 < size5; i27++) {
                                                    Placeable.PlacementScope.placeRelative$default(placementScope, subcompose3.get(i27).mo5333measureBRTryo0(Constraints.INSTANCE.m6353fixedJhjzzOo(intRef5.element, intRef6.element)), 0, 0, 0.0f, 4, null);
                                                }
                                                scrollableTabData2.onLaidOut(subcomposeMeasureScope, i17, arrayList3, i22);
                                            }
                                        }, 4, null);
                                    }
                                }, composer3, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), composer2, ((i8 >> 3) & 14) | i9 | (i8 & 896) | (i8 & 7168), 50);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    f4 = f522;
                    function34 = function33;
                    function23 = m1641getLambda2$material_release;
                    modifier4 = modifier3;
                    j7 = j5;
                    j8 = j6;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function32 = function3;
                i7 = i3 & 64;
                if (i7 == 0) {
                }
                if ((i3 & 128) == 0) {
                }
                if ((i4 & 23967451) == 4793490) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i13 != 0) {
                }
                if ((i3 & 4) != 0) {
                }
                if ((i3 & 8) != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                long j1022 = j3;
                i8 = i4;
                function33 = function32;
                j5 = j1022;
                f3 = f2;
                i9 = 1572864;
                modifier3 = modifier2;
                j6 = j4;
                i10 = -1473476840;
                m1641getLambda2$material_release = function2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                final float f5222 = f3;
                final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function35222 = function33;
                final Function2<? super Composer, ? super Integer, Unit> function24222 = m1641getLambda2$material_release;
                composer2 = startRestartGroup;
                SurfaceKt.m1782SurfaceFjzlyU(modifier3, null, j5, j6, null, 0.0f, ComposableLambdaKt.composableLambda(startRestartGroup, 1455860572, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt$ScrollableTabRow$2
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
                        ComposerKt.sourceInformation(composer3, "C249@12018L21,250@12069L24,251@12126L185,257@12320L2577:TabRow.kt#jmzs0o");
                        if ((i14 & 11) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1455860572, i14, -1, "androidx.compose.material.ScrollableTabRow.<anonymous> (TabRow.kt:249)");
                            }
                            ScrollState rememberScrollState = ScrollKt.rememberScrollState(0, composer3, 0, 1);
                            composer3.startReplaceableGroup(773894976);
                            ComposerKt.sourceInformation(composer3, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                            composer3.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composer3, "CC(remember):Composables.kt#9igjgp");
                            Object rememberedValue = composer3.rememberedValue();
                            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer3));
                                composer3.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                                rememberedValue = compositionScopedCoroutineScopeCanceller;
                            }
                            composer3.endReplaceableGroup();
                            CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                            composer3.endReplaceableGroup();
                            composer3.startReplaceableGroup(511388516);
                            ComposerKt.sourceInformation(composer3, "CC(remember)P(1,2):Composables.kt#9igjgp");
                            boolean changed = composer3.changed(rememberScrollState) | composer3.changed(coroutineScope);
                            Object rememberedValue2 = composer3.rememberedValue();
                            if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue2 = new ScrollableTabData(rememberScrollState, coroutineScope);
                                composer3.updateRememberedValue(rememberedValue2);
                            }
                            composer3.endReplaceableGroup();
                            final ScrollableTabData scrollableTabData = (ScrollableTabData) rememberedValue2;
                            Modifier clipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getCenterStart(), false, 2, null), rememberScrollState, false, null, false, 14, null)));
                            final float f6 = f5222;
                            final Function2<? super Composer, ? super Integer, Unit> function25 = function22;
                            final Function2<? super Composer, ? super Integer, Unit> function26 = function24222;
                            final int i15 = i;
                            final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function36 = function35222;
                            SubcomposeLayoutKt.SubcomposeLayout(clipToBounds, new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.TabRowKt$ScrollableTabRow$2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                    return m1813invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                                }

                                /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                                public final MeasureResult m1813invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, final long j10222) {
                                    float f7;
                                    f7 = TabRowKt.ScrollableTabRowMinimumTabWidth;
                                    int i16 = subcomposeMeasureScope.mo624roundToPx0680j_4(f7);
                                    final int i17 = subcomposeMeasureScope.mo624roundToPx0680j_4(f6);
                                    long m6336copyZbe2FdA$default = Constraints.m6336copyZbe2FdA$default(j10222, i16, 0, 0, 0, 14, null);
                                    List<Measurable> subcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function25);
                                    ArrayList arrayList = new ArrayList(subcompose.size());
                                    int size = subcompose.size();
                                    for (int i18 = 0; i18 < size; i18++) {
                                        arrayList.add(subcompose.get(i18).mo5333measureBRTryo0(m6336copyZbe2FdA$default));
                                    }
                                    final List<? extends Placeable> arrayList2 = arrayList;
                                    final Ref.IntRef intRef = new Ref.IntRef();
                                    intRef.element = i17 * 2;
                                    final Ref.IntRef intRef2 = new Ref.IntRef();
                                    int size2 = arrayList2.size();
                                    for (int i19 = 0; i19 < size2; i19++) {
                                        Placeable placeable = (Placeable) arrayList2.get(i19);
                                        intRef.element += placeable.getWidth();
                                        intRef2.element = Math.max(intRef2.element, placeable.getHeight());
                                    }
                                    int i20 = intRef.element;
                                    int i21 = intRef2.element;
                                    final Function2<? super Composer, ? super Integer, Unit> function27 = function26;
                                    final ScrollableTabData scrollableTabData2 = scrollableTabData;
                                    final int i22 = i15;
                                    final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function37 = function36;
                                    return MeasureScope.layout$default(subcomposeMeasureScope, i20, i21, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.TabRowKt.ScrollableTabRow.2.1.2
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
                                            final List<TabPosition> arrayList3 = new ArrayList();
                                            int i23 = i17;
                                            List<Placeable> list = arrayList2;
                                            SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                            int size3 = list.size();
                                            int i24 = i23;
                                            for (int i25 = 0; i25 < size3; i25++) {
                                                Placeable placeable2 = list.get(i25);
                                                Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i24, 0, 0.0f, 4, null);
                                                arrayList3.add(new TabPosition(subcomposeMeasureScope2.mo627toDpu2uoSUM(i24), subcomposeMeasureScope2.mo627toDpu2uoSUM(placeable2.getWidth()), null));
                                                i24 += placeable2.getWidth();
                                            }
                                            List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Divider, function27);
                                            long j11 = j10222;
                                            Ref.IntRef intRef3 = intRef;
                                            Ref.IntRef intRef4 = intRef2;
                                            int size4 = subcompose2.size();
                                            for (int i26 = 0; i26 < size4; i26++) {
                                                Placeable mo5333measureBRTryo0 = subcompose2.get(i26).mo5333measureBRTryo0(Constraints.m6336copyZbe2FdA$default(j11, intRef3.element, intRef3.element, 0, 0, 8, null));
                                                Placeable.PlacementScope.placeRelative$default(placementScope, mo5333measureBRTryo0, 0, intRef4.element - mo5333measureBRTryo0.getHeight(), 0.0f, 4, null);
                                            }
                                            SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope;
                                            TabSlots tabSlots = TabSlots.Indicator;
                                            final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function38 = function37;
                                            List<Measurable> subcompose3 = subcomposeMeasureScope3.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(-411868839, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt.ScrollableTabRow.2.1.2.3
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

                                                public final void invoke(Composer composer4, int i27) {
                                                    ComposerKt.sourceInformation(composer4, "C305@14444L23:TabRow.kt#jmzs0o");
                                                    if ((i27 & 11) == 2 && composer4.getSkipping()) {
                                                        composer4.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-411868839, i27, -1, "androidx.compose.material.ScrollableTabRow.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:305)");
                                                    }
                                                    function38.invoke(arrayList3, composer4, 8);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }));
                                            Ref.IntRef intRef5 = intRef;
                                            Ref.IntRef intRef6 = intRef2;
                                            int size5 = subcompose3.size();
                                            for (int i27 = 0; i27 < size5; i27++) {
                                                Placeable.PlacementScope.placeRelative$default(placementScope, subcompose3.get(i27).mo5333measureBRTryo0(Constraints.INSTANCE.m6353fixedJhjzzOo(intRef5.element, intRef6.element)), 0, 0, 0.0f, 4, null);
                                            }
                                            scrollableTabData2.onLaidOut(subcomposeMeasureScope, i17, arrayList3, i22);
                                        }
                                    }, 4, null);
                                }
                            }, composer3, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), composer2, ((i8 >> 3) & 14) | i9 | (i8 & 896) | (i8 & 7168), 50);
                if (ComposerKt.isTraceInProgress()) {
                }
                f4 = f5222;
                function34 = function33;
                function23 = m1641getLambda2$material_release;
                modifier4 = modifier3;
                j7 = j5;
                j8 = j6;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            f2 = f;
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            function32 = function3;
            i7 = i3 & 64;
            if (i7 == 0) {
            }
            if ((i3 & 128) == 0) {
            }
            if ((i4 & 23967451) == 4793490) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i13 != 0) {
            }
            if ((i3 & 4) != 0) {
            }
            if ((i3 & 8) != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            long j10222 = j3;
            i8 = i4;
            function33 = function32;
            j5 = j10222;
            f3 = f2;
            i9 = 1572864;
            modifier3 = modifier2;
            j6 = j4;
            i10 = -1473476840;
            m1641getLambda2$material_release = function2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            final float f52222 = f3;
            final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function352222 = function33;
            final Function2<? super Composer, ? super Integer, Unit> function242222 = m1641getLambda2$material_release;
            composer2 = startRestartGroup;
            SurfaceKt.m1782SurfaceFjzlyU(modifier3, null, j5, j6, null, 0.0f, ComposableLambdaKt.composableLambda(startRestartGroup, 1455860572, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt$ScrollableTabRow$2
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
                    ComposerKt.sourceInformation(composer3, "C249@12018L21,250@12069L24,251@12126L185,257@12320L2577:TabRow.kt#jmzs0o");
                    if ((i14 & 11) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1455860572, i14, -1, "androidx.compose.material.ScrollableTabRow.<anonymous> (TabRow.kt:249)");
                        }
                        ScrollState rememberScrollState = ScrollKt.rememberScrollState(0, composer3, 0, 1);
                        composer3.startReplaceableGroup(773894976);
                        ComposerKt.sourceInformation(composer3, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                        composer3.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composer3, "CC(remember):Composables.kt#9igjgp");
                        Object rememberedValue = composer3.rememberedValue();
                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                            Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer3));
                            composer3.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                            rememberedValue = compositionScopedCoroutineScopeCanceller;
                        }
                        composer3.endReplaceableGroup();
                        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                        composer3.endReplaceableGroup();
                        composer3.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composer3, "CC(remember)P(1,2):Composables.kt#9igjgp");
                        boolean changed = composer3.changed(rememberScrollState) | composer3.changed(coroutineScope);
                        Object rememberedValue2 = composer3.rememberedValue();
                        if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = new ScrollableTabData(rememberScrollState, coroutineScope);
                            composer3.updateRememberedValue(rememberedValue2);
                        }
                        composer3.endReplaceableGroup();
                        final ScrollableTabData scrollableTabData = (ScrollableTabData) rememberedValue2;
                        Modifier clipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getCenterStart(), false, 2, null), rememberScrollState, false, null, false, 14, null)));
                        final float f6 = f52222;
                        final Function2<? super Composer, ? super Integer, Unit> function25 = function22;
                        final Function2<? super Composer, ? super Integer, Unit> function26 = function242222;
                        final int i15 = i;
                        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function36 = function352222;
                        SubcomposeLayoutKt.SubcomposeLayout(clipToBounds, new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.TabRowKt$ScrollableTabRow$2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                return m1813invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                            }

                            /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final MeasureResult m1813invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, final long j102222) {
                                float f7;
                                f7 = TabRowKt.ScrollableTabRowMinimumTabWidth;
                                int i16 = subcomposeMeasureScope.mo624roundToPx0680j_4(f7);
                                final int i17 = subcomposeMeasureScope.mo624roundToPx0680j_4(f6);
                                long m6336copyZbe2FdA$default = Constraints.m6336copyZbe2FdA$default(j102222, i16, 0, 0, 0, 14, null);
                                List<Measurable> subcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function25);
                                ArrayList arrayList = new ArrayList(subcompose.size());
                                int size = subcompose.size();
                                for (int i18 = 0; i18 < size; i18++) {
                                    arrayList.add(subcompose.get(i18).mo5333measureBRTryo0(m6336copyZbe2FdA$default));
                                }
                                final List<? extends Placeable> arrayList2 = arrayList;
                                final Ref.IntRef intRef = new Ref.IntRef();
                                intRef.element = i17 * 2;
                                final Ref.IntRef intRef2 = new Ref.IntRef();
                                int size2 = arrayList2.size();
                                for (int i19 = 0; i19 < size2; i19++) {
                                    Placeable placeable = (Placeable) arrayList2.get(i19);
                                    intRef.element += placeable.getWidth();
                                    intRef2.element = Math.max(intRef2.element, placeable.getHeight());
                                }
                                int i20 = intRef.element;
                                int i21 = intRef2.element;
                                final Function2<? super Composer, ? super Integer, Unit> function27 = function26;
                                final ScrollableTabData scrollableTabData2 = scrollableTabData;
                                final int i22 = i15;
                                final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function37 = function36;
                                return MeasureScope.layout$default(subcomposeMeasureScope, i20, i21, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.TabRowKt.ScrollableTabRow.2.1.2
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
                                        final List<TabPosition> arrayList3 = new ArrayList();
                                        int i23 = i17;
                                        List<Placeable> list = arrayList2;
                                        SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                        int size3 = list.size();
                                        int i24 = i23;
                                        for (int i25 = 0; i25 < size3; i25++) {
                                            Placeable placeable2 = list.get(i25);
                                            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i24, 0, 0.0f, 4, null);
                                            arrayList3.add(new TabPosition(subcomposeMeasureScope2.mo627toDpu2uoSUM(i24), subcomposeMeasureScope2.mo627toDpu2uoSUM(placeable2.getWidth()), null));
                                            i24 += placeable2.getWidth();
                                        }
                                        List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Divider, function27);
                                        long j11 = j102222;
                                        Ref.IntRef intRef3 = intRef;
                                        Ref.IntRef intRef4 = intRef2;
                                        int size4 = subcompose2.size();
                                        for (int i26 = 0; i26 < size4; i26++) {
                                            Placeable mo5333measureBRTryo0 = subcompose2.get(i26).mo5333measureBRTryo0(Constraints.m6336copyZbe2FdA$default(j11, intRef3.element, intRef3.element, 0, 0, 8, null));
                                            Placeable.PlacementScope.placeRelative$default(placementScope, mo5333measureBRTryo0, 0, intRef4.element - mo5333measureBRTryo0.getHeight(), 0.0f, 4, null);
                                        }
                                        SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope;
                                        TabSlots tabSlots = TabSlots.Indicator;
                                        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function38 = function37;
                                        List<Measurable> subcompose3 = subcomposeMeasureScope3.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(-411868839, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt.ScrollableTabRow.2.1.2.3
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

                                            public final void invoke(Composer composer4, int i27) {
                                                ComposerKt.sourceInformation(composer4, "C305@14444L23:TabRow.kt#jmzs0o");
                                                if ((i27 & 11) == 2 && composer4.getSkipping()) {
                                                    composer4.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-411868839, i27, -1, "androidx.compose.material.ScrollableTabRow.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:305)");
                                                }
                                                function38.invoke(arrayList3, composer4, 8);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }));
                                        Ref.IntRef intRef5 = intRef;
                                        Ref.IntRef intRef6 = intRef2;
                                        int size5 = subcompose3.size();
                                        for (int i27 = 0; i27 < size5; i27++) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, subcompose3.get(i27).mo5333measureBRTryo0(Constraints.INSTANCE.m6353fixedJhjzzOo(intRef5.element, intRef6.element)), 0, 0, 0.0f, 4, null);
                                        }
                                        scrollableTabData2.onLaidOut(subcomposeMeasureScope, i17, arrayList3, i22);
                                    }
                                }, 4, null);
                            }
                        }, composer3, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), composer2, ((i8 >> 3) & 14) | i9 | (i8 & 896) | (i8 & 7168), 50);
            if (ComposerKt.isTraceInProgress()) {
            }
            f4 = f52222;
            function34 = function33;
            function23 = m1641getLambda2$material_release;
            modifier4 = modifier3;
            j7 = j5;
            j8 = j6;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i2 & 896) != 0) {
        }
        if ((i2 & 7168) != 0) {
        }
        i5 = i3 & 16;
        if (i5 == 0) {
        }
        f2 = f;
        i6 = i3 & 32;
        if (i6 != 0) {
        }
        function32 = function3;
        i7 = i3 & 64;
        if (i7 == 0) {
        }
        if ((i3 & 128) == 0) {
        }
        if ((i4 & 23967451) == 4793490) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i13 != 0) {
        }
        if ((i3 & 4) != 0) {
        }
        if ((i3 & 8) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        long j102222 = j3;
        i8 = i4;
        function33 = function32;
        j5 = j102222;
        f3 = f2;
        i9 = 1572864;
        modifier3 = modifier2;
        j6 = j4;
        i10 = -1473476840;
        m1641getLambda2$material_release = function2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        final float f522222 = f3;
        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3522222 = function33;
        final Function2<? super Composer, ? super Integer, Unit> function2422222 = m1641getLambda2$material_release;
        composer2 = startRestartGroup;
        SurfaceKt.m1782SurfaceFjzlyU(modifier3, null, j5, j6, null, 0.0f, ComposableLambdaKt.composableLambda(startRestartGroup, 1455860572, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt$ScrollableTabRow$2
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
                ComposerKt.sourceInformation(composer3, "C249@12018L21,250@12069L24,251@12126L185,257@12320L2577:TabRow.kt#jmzs0o");
                if ((i14 & 11) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1455860572, i14, -1, "androidx.compose.material.ScrollableTabRow.<anonymous> (TabRow.kt:249)");
                    }
                    ScrollState rememberScrollState = ScrollKt.rememberScrollState(0, composer3, 0, 1);
                    composer3.startReplaceableGroup(773894976);
                    ComposerKt.sourceInformation(composer3, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                    composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composer3, "CC(remember):Composables.kt#9igjgp");
                    Object rememberedValue = composer3.rememberedValue();
                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                        Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer3));
                        composer3.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                        rememberedValue = compositionScopedCoroutineScopeCanceller;
                    }
                    composer3.endReplaceableGroup();
                    CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                    composer3.endReplaceableGroup();
                    composer3.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composer3, "CC(remember)P(1,2):Composables.kt#9igjgp");
                    boolean changed = composer3.changed(rememberScrollState) | composer3.changed(coroutineScope);
                    Object rememberedValue2 = composer3.rememberedValue();
                    if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = new ScrollableTabData(rememberScrollState, coroutineScope);
                        composer3.updateRememberedValue(rememberedValue2);
                    }
                    composer3.endReplaceableGroup();
                    final ScrollableTabData scrollableTabData = (ScrollableTabData) rememberedValue2;
                    Modifier clipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getCenterStart(), false, 2, null), rememberScrollState, false, null, false, 14, null)));
                    final float f6 = f522222;
                    final Function2<? super Composer, ? super Integer, Unit> function25 = function22;
                    final Function2<? super Composer, ? super Integer, Unit> function26 = function2422222;
                    final int i15 = i;
                    final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function36 = function3522222;
                    SubcomposeLayoutKt.SubcomposeLayout(clipToBounds, new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.TabRowKt$ScrollableTabRow$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                            return m1813invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                        }

                        /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                        public final MeasureResult m1813invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, final long j1022222) {
                            float f7;
                            f7 = TabRowKt.ScrollableTabRowMinimumTabWidth;
                            int i16 = subcomposeMeasureScope.mo624roundToPx0680j_4(f7);
                            final int i17 = subcomposeMeasureScope.mo624roundToPx0680j_4(f6);
                            long m6336copyZbe2FdA$default = Constraints.m6336copyZbe2FdA$default(j1022222, i16, 0, 0, 0, 14, null);
                            List<Measurable> subcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function25);
                            ArrayList arrayList = new ArrayList(subcompose.size());
                            int size = subcompose.size();
                            for (int i18 = 0; i18 < size; i18++) {
                                arrayList.add(subcompose.get(i18).mo5333measureBRTryo0(m6336copyZbe2FdA$default));
                            }
                            final List<? extends Placeable> arrayList2 = arrayList;
                            final Ref.IntRef intRef = new Ref.IntRef();
                            intRef.element = i17 * 2;
                            final Ref.IntRef intRef2 = new Ref.IntRef();
                            int size2 = arrayList2.size();
                            for (int i19 = 0; i19 < size2; i19++) {
                                Placeable placeable = (Placeable) arrayList2.get(i19);
                                intRef.element += placeable.getWidth();
                                intRef2.element = Math.max(intRef2.element, placeable.getHeight());
                            }
                            int i20 = intRef.element;
                            int i21 = intRef2.element;
                            final Function2<? super Composer, ? super Integer, Unit> function27 = function26;
                            final ScrollableTabData scrollableTabData2 = scrollableTabData;
                            final int i22 = i15;
                            final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function37 = function36;
                            return MeasureScope.layout$default(subcomposeMeasureScope, i20, i21, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.TabRowKt.ScrollableTabRow.2.1.2
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
                                    final List<TabPosition> arrayList3 = new ArrayList();
                                    int i23 = i17;
                                    List<Placeable> list = arrayList2;
                                    SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                    int size3 = list.size();
                                    int i24 = i23;
                                    for (int i25 = 0; i25 < size3; i25++) {
                                        Placeable placeable2 = list.get(i25);
                                        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i24, 0, 0.0f, 4, null);
                                        arrayList3.add(new TabPosition(subcomposeMeasureScope2.mo627toDpu2uoSUM(i24), subcomposeMeasureScope2.mo627toDpu2uoSUM(placeable2.getWidth()), null));
                                        i24 += placeable2.getWidth();
                                    }
                                    List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Divider, function27);
                                    long j11 = j1022222;
                                    Ref.IntRef intRef3 = intRef;
                                    Ref.IntRef intRef4 = intRef2;
                                    int size4 = subcompose2.size();
                                    for (int i26 = 0; i26 < size4; i26++) {
                                        Placeable mo5333measureBRTryo0 = subcompose2.get(i26).mo5333measureBRTryo0(Constraints.m6336copyZbe2FdA$default(j11, intRef3.element, intRef3.element, 0, 0, 8, null));
                                        Placeable.PlacementScope.placeRelative$default(placementScope, mo5333measureBRTryo0, 0, intRef4.element - mo5333measureBRTryo0.getHeight(), 0.0f, 4, null);
                                    }
                                    SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope;
                                    TabSlots tabSlots = TabSlots.Indicator;
                                    final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function38 = function37;
                                    List<Measurable> subcompose3 = subcomposeMeasureScope3.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(-411868839, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowKt.ScrollableTabRow.2.1.2.3
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

                                        public final void invoke(Composer composer4, int i27) {
                                            ComposerKt.sourceInformation(composer4, "C305@14444L23:TabRow.kt#jmzs0o");
                                            if ((i27 & 11) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-411868839, i27, -1, "androidx.compose.material.ScrollableTabRow.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:305)");
                                            }
                                            function38.invoke(arrayList3, composer4, 8);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }));
                                    Ref.IntRef intRef5 = intRef;
                                    Ref.IntRef intRef6 = intRef2;
                                    int size5 = subcompose3.size();
                                    for (int i27 = 0; i27 < size5; i27++) {
                                        Placeable.PlacementScope.placeRelative$default(placementScope, subcompose3.get(i27).mo5333measureBRTryo0(Constraints.INSTANCE.m6353fixedJhjzzOo(intRef5.element, intRef6.element)), 0, 0, 0.0f, 4, null);
                                    }
                                    scrollableTabData2.onLaidOut(subcomposeMeasureScope, i17, arrayList3, i22);
                                }
                            }, 4, null);
                        }
                    }, composer3, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }), composer2, ((i8 >> 3) & 14) | i9 | (i8 & 896) | (i8 & 7168), 50);
        if (ComposerKt.isTraceInProgress()) {
        }
        f4 = f522222;
        function34 = function33;
        function23 = m1641getLambda2$material_release;
        modifier4 = modifier3;
        j7 = j5;
        j8 = j6;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
