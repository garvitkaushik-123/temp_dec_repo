package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.ClipScrollableContainerKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.OverscrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LazyGrid.kt */
@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a~\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017H\u0001¢\u0006\u0002\u0010\u0018\u001av\u0010\u0019\u001a\u0019\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001a¢\u0006\u0002\b\u00172\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010!\u001a\u00020\"H\u0003¢\u0006\u0002\u0010#¨\u0006$"}, d2 = {"LazyGrid", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "slots", "Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "isVertical", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "rememberLazyGridMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyGridKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0140  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LazyGrid(Modifier modifier, final LazyGridState lazyGridState, final LazyGridSlotsProvider lazyGridSlotsProvider, PaddingValues paddingValues, boolean z, final boolean z2, FlingBehavior flingBehavior, final boolean z3, final Arrangement.Vertical vertical, final Arrangement.Horizontal horizontal, final Function1<? super LazyGridScope, Unit> function1, Composer composer, final int i, final int i2, final int i3) {
        Modifier modifier2;
        int i4;
        LazyGridSlotsProvider lazyGridSlotsProvider2;
        int i5;
        PaddingValues paddingValues2;
        int i6;
        int i7;
        int i8;
        boolean z4;
        FlingBehavior flingBehavior2;
        Modifier modifier3;
        int i9;
        PaddingValues paddingValues3;
        Object rememberedValue;
        Composer composer2;
        final boolean z5;
        final Modifier modifier4;
        final PaddingValues paddingValues4;
        final FlingBehavior flingBehavior3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-649686062);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyGrid)P(5,8,7,1,6,4,2,9,10,3)68@3230L15,78@3671L18,80@3720L50,82@3796L51,84@3874L24,85@3923L244,104@4440L277,113@4837L48,116@5048L7,112@4781L376,124@5381L7,100@4295L1571:LazyGrid.kt#7791vq");
        int i10 = i3 & 1;
        if (i10 != 0) {
            i4 = i | 6;
            modifier2 = modifier;
        } else if ((i & 14) == 0) {
            modifier2 = modifier;
            i4 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= startRestartGroup.changed(lazyGridState) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 896) == 0) {
            lazyGridSlotsProvider2 = lazyGridSlotsProvider;
            i4 |= startRestartGroup.changed(lazyGridSlotsProvider2) ? 256 : 128;
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else if ((i & 7168) == 0) {
                paddingValues2 = paddingValues;
                i4 |= startRestartGroup.changed(paddingValues2) ? 2048 : 1024;
                i6 = i3 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else if ((i & 57344) == 0) {
                    i4 |= startRestartGroup.changed(z) ? 16384 : 8192;
                }
                if ((i3 & 32) != 0) {
                    i7 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else {
                    if ((i & 458752) == 0) {
                        i7 = startRestartGroup.changed(z2) ? 131072 : 65536;
                    }
                    if ((i & 3670016) == 0) {
                        i4 |= ((i3 & 64) == 0 && startRestartGroup.changed(flingBehavior)) ? 1048576 : 524288;
                    }
                    if ((i3 & 128) == 0) {
                        i4 |= 12582912;
                    } else if ((i & 29360128) == 0) {
                        i4 |= startRestartGroup.changed(z3) ? 8388608 : 4194304;
                        if ((i3 & 256) != 0) {
                            i4 |= 100663296;
                        } else if ((234881024 & i) == 0) {
                            i4 |= startRestartGroup.changed(vertical) ? 67108864 : 33554432;
                            if ((i3 & 512) == 0) {
                                i4 |= C.ENCODING_PCM_32BIT;
                            } else if ((1879048192 & i) == 0) {
                                i4 |= startRestartGroup.changed(horizontal) ? 536870912 : 268435456;
                                if ((i3 & 1024) != 0) {
                                    i8 = i2 | 6;
                                } else if ((i2 & 14) == 0) {
                                    i8 = i2 | (startRestartGroup.changedInstance(function1) ? 4 : 2);
                                } else {
                                    i8 = i2;
                                }
                                if ((i4 & 1533916891) == 306783378 || (i8 & 11) != 2 || !startRestartGroup.getSkipping()) {
                                    startRestartGroup.startDefaults();
                                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                        Modifier.Companion companion = i10 != 0 ? Modifier.INSTANCE : modifier2;
                                        PaddingValues m872PaddingValues0680j_4 = i5 != 0 ? PaddingKt.m872PaddingValues0680j_4(Dp.m6389constructorimpl(0)) : paddingValues2;
                                        z4 = i6 == 0 ? z : false;
                                        if ((i3 & 64) != 0) {
                                            i9 = i4 & (-3670017);
                                            paddingValues3 = m872PaddingValues0680j_4;
                                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(startRestartGroup, 6);
                                            modifier3 = companion;
                                        } else {
                                            flingBehavior2 = flingBehavior;
                                            modifier3 = companion;
                                            i9 = i4;
                                            paddingValues3 = m872PaddingValues0680j_4;
                                        }
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        if ((i3 & 64) != 0) {
                                            i4 &= -3670017;
                                        }
                                        flingBehavior2 = flingBehavior;
                                        i9 = i4;
                                        paddingValues3 = paddingValues2;
                                        modifier3 = modifier2;
                                        z4 = z;
                                    }
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-649686062, i9, i8, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:77)");
                                    }
                                    OverscrollEffect overscrollEffect = ScrollableDefaults.INSTANCE.overscrollEffect(startRestartGroup, 6);
                                    int i11 = i9 >> 3;
                                    int i12 = i11 & 14;
                                    Function0<LazyGridItemProvider> rememberLazyGridItemProviderLambda = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, function1, startRestartGroup, ((i8 << 3) & 112) | i12);
                                    int i13 = i9 >> 9;
                                    LazyLayoutSemanticState rememberLazyGridSemanticState = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, startRestartGroup, (i13 & 112) | i12);
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
                                    CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                                    startRestartGroup.endReplaceableGroup();
                                    boolean z6 = z4;
                                    Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyGridMeasurePolicy = rememberLazyGridMeasurePolicy(rememberLazyGridItemProviderLambda, lazyGridState, lazyGridSlotsProvider2, paddingValues3, z6, z2, horizontal, vertical, coroutineScope, startRestartGroup, (i9 & 896) | (i9 & 112) | 134217728 | (i9 & 7168) | (i9 & 57344) | (i9 & 458752) | (i13 & 3670016) | (i11 & 29360128));
                                    PaddingValues paddingValues5 = paddingValues3;
                                    lazyGridState.setVertical$foundation_release(z2);
                                    Orientation orientation = z2 ? Orientation.Vertical : Orientation.Horizontal;
                                    Modifier clipScrollableContainer = ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier3.then(lazyGridState.getRemeasurementModifier()).then(lazyGridState.getAwaitLayoutModifier()), rememberLazyGridItemProviderLambda, rememberLazyGridSemanticState, orientation, z3, z6, startRestartGroup, (i13 & 57344) | ((i9 << 3) & 458752)), orientation);
                                    LazyLayoutBeyondBoundsState rememberLazyGridBeyondBoundsState = LazyGridBeyondBoundsModifierKt.rememberLazyGridBeyondBoundsState(lazyGridState, startRestartGroup, i12);
                                    LazyLayoutBeyondBoundsInfo beyondBoundsInfo = lazyGridState.getBeyondBoundsInfo();
                                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    Object consume = startRestartGroup.consume(localLayoutDirection);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    Modifier overscroll = OverscrollKt.overscroll(LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(clipScrollableContainer, rememberLazyGridBeyondBoundsState, beyondBoundsInfo, z6, (LayoutDirection) consume, orientation, z3, startRestartGroup, (MutableVector.$stable << 6) | (i11 & 7168) | (i11 & 3670016)), overscrollEffect);
                                    ScrollableDefaults scrollableDefaults = ScrollableDefaults.INSTANCE;
                                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    Object consume2 = startRestartGroup.consume(localLayoutDirection2);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    LazyLayoutKt.LazyLayout(rememberLazyGridItemProviderLambda, ScrollableKt.scrollable$default(overscroll, lazyGridState, orientation, overscrollEffect, z3, scrollableDefaults.reverseDirection((LayoutDirection) consume2, orientation, z6), flingBehavior2, lazyGridState.getInternalInteractionSource(), null, 128, null), lazyGridState.getPrefetchState(), rememberLazyGridMeasurePolicy, startRestartGroup, 0, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer2 = startRestartGroup;
                                    z5 = z6;
                                    modifier4 = modifier3;
                                    paddingValues4 = paddingValues5;
                                    flingBehavior3 = flingBehavior2;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    z5 = z;
                                    modifier4 = modifier2;
                                    composer2 = startRestartGroup;
                                    paddingValues4 = paddingValues2;
                                    flingBehavior3 = flingBehavior;
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup != null) {
                                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$LazyGrid$1
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
                                            LazyGridKt.LazyGrid(Modifier.this, lazyGridState, lazyGridSlotsProvider, paddingValues4, z5, z2, flingBehavior3, z3, vertical, horizontal, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            if ((i3 & 1024) != 0) {
                            }
                            if ((i4 & 1533916891) == 306783378) {
                            }
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                            }
                            if (i10 != 0) {
                            }
                            if (i5 != 0) {
                            }
                            if (i6 == 0) {
                            }
                            if ((i3 & 64) != 0) {
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            OverscrollEffect overscrollEffect2 = ScrollableDefaults.INSTANCE.overscrollEffect(startRestartGroup, 6);
                            int i112 = i9 >> 3;
                            int i122 = i112 & 14;
                            Function0<LazyGridItemProvider> rememberLazyGridItemProviderLambda2 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, function1, startRestartGroup, ((i8 << 3) & 112) | i122);
                            int i132 = i9 >> 9;
                            LazyLayoutSemanticState rememberLazyGridSemanticState2 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, startRestartGroup, (i132 & 112) | i122);
                            startRestartGroup.startReplaceableGroup(773894976);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                            startRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                            }
                            startRestartGroup.endReplaceableGroup();
                            CoroutineScope coroutineScope2 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                            startRestartGroup.endReplaceableGroup();
                            boolean z62 = z4;
                            Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyGridMeasurePolicy2 = rememberLazyGridMeasurePolicy(rememberLazyGridItemProviderLambda2, lazyGridState, lazyGridSlotsProvider2, paddingValues3, z62, z2, horizontal, vertical, coroutineScope2, startRestartGroup, (i9 & 896) | (i9 & 112) | 134217728 | (i9 & 7168) | (i9 & 57344) | (i9 & 458752) | (i132 & 3670016) | (i112 & 29360128));
                            PaddingValues paddingValues52 = paddingValues3;
                            lazyGridState.setVertical$foundation_release(z2);
                            Orientation orientation2 = z2 ? Orientation.Vertical : Orientation.Horizontal;
                            Modifier clipScrollableContainer2 = ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier3.then(lazyGridState.getRemeasurementModifier()).then(lazyGridState.getAwaitLayoutModifier()), rememberLazyGridItemProviderLambda2, rememberLazyGridSemanticState2, orientation2, z3, z62, startRestartGroup, (i132 & 57344) | ((i9 << 3) & 458752)), orientation2);
                            LazyLayoutBeyondBoundsState rememberLazyGridBeyondBoundsState2 = LazyGridBeyondBoundsModifierKt.rememberLazyGridBeyondBoundsState(lazyGridState, startRestartGroup, i122);
                            LazyLayoutBeyondBoundsInfo beyondBoundsInfo2 = lazyGridState.getBeyondBoundsInfo();
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume3 = startRestartGroup.consume(localLayoutDirection3);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            Modifier overscroll2 = OverscrollKt.overscroll(LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(clipScrollableContainer2, rememberLazyGridBeyondBoundsState2, beyondBoundsInfo2, z62, (LayoutDirection) consume3, orientation2, z3, startRestartGroup, (MutableVector.$stable << 6) | (i112 & 7168) | (i112 & 3670016)), overscrollEffect2);
                            ScrollableDefaults scrollableDefaults2 = ScrollableDefaults.INSTANCE;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection22 = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume22 = startRestartGroup.consume(localLayoutDirection22);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            LazyLayoutKt.LazyLayout(rememberLazyGridItemProviderLambda2, ScrollableKt.scrollable$default(overscroll2, lazyGridState, orientation2, overscrollEffect2, z3, scrollableDefaults2.reverseDirection((LayoutDirection) consume22, orientation2, z62), flingBehavior2, lazyGridState.getInternalInteractionSource(), null, 128, null), lazyGridState.getPrefetchState(), rememberLazyGridMeasurePolicy2, startRestartGroup, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composer2 = startRestartGroup;
                            z5 = z62;
                            modifier4 = modifier3;
                            paddingValues4 = paddingValues52;
                            flingBehavior3 = flingBehavior2;
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        if ((i3 & 512) == 0) {
                        }
                        if ((i3 & 1024) != 0) {
                        }
                        if ((i4 & 1533916891) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                        }
                        if (i10 != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 == 0) {
                        }
                        if ((i3 & 64) != 0) {
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        OverscrollEffect overscrollEffect22 = ScrollableDefaults.INSTANCE.overscrollEffect(startRestartGroup, 6);
                        int i1122 = i9 >> 3;
                        int i1222 = i1122 & 14;
                        Function0<LazyGridItemProvider> rememberLazyGridItemProviderLambda22 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, function1, startRestartGroup, ((i8 << 3) & 112) | i1222);
                        int i1322 = i9 >> 9;
                        LazyLayoutSemanticState rememberLazyGridSemanticState22 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, startRestartGroup, (i1322 & 112) | i1222);
                        startRestartGroup.startReplaceableGroup(773894976);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                        startRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                        }
                        startRestartGroup.endReplaceableGroup();
                        CoroutineScope coroutineScope22 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                        startRestartGroup.endReplaceableGroup();
                        boolean z622 = z4;
                        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyGridMeasurePolicy22 = rememberLazyGridMeasurePolicy(rememberLazyGridItemProviderLambda22, lazyGridState, lazyGridSlotsProvider2, paddingValues3, z622, z2, horizontal, vertical, coroutineScope22, startRestartGroup, (i9 & 896) | (i9 & 112) | 134217728 | (i9 & 7168) | (i9 & 57344) | (i9 & 458752) | (i1322 & 3670016) | (i1122 & 29360128));
                        PaddingValues paddingValues522 = paddingValues3;
                        lazyGridState.setVertical$foundation_release(z2);
                        Orientation orientation22 = z2 ? Orientation.Vertical : Orientation.Horizontal;
                        Modifier clipScrollableContainer22 = ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier3.then(lazyGridState.getRemeasurementModifier()).then(lazyGridState.getAwaitLayoutModifier()), rememberLazyGridItemProviderLambda22, rememberLazyGridSemanticState22, orientation22, z3, z622, startRestartGroup, (i1322 & 57344) | ((i9 << 3) & 458752)), orientation22);
                        LazyLayoutBeyondBoundsState rememberLazyGridBeyondBoundsState22 = LazyGridBeyondBoundsModifierKt.rememberLazyGridBeyondBoundsState(lazyGridState, startRestartGroup, i1222);
                        LazyLayoutBeyondBoundsInfo beyondBoundsInfo22 = lazyGridState.getBeyondBoundsInfo();
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection32 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume32 = startRestartGroup.consume(localLayoutDirection32);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        Modifier overscroll22 = OverscrollKt.overscroll(LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(clipScrollableContainer22, rememberLazyGridBeyondBoundsState22, beyondBoundsInfo22, z622, (LayoutDirection) consume32, orientation22, z3, startRestartGroup, (MutableVector.$stable << 6) | (i1122 & 7168) | (i1122 & 3670016)), overscrollEffect22);
                        ScrollableDefaults scrollableDefaults22 = ScrollableDefaults.INSTANCE;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection222 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume222 = startRestartGroup.consume(localLayoutDirection222);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        LazyLayoutKt.LazyLayout(rememberLazyGridItemProviderLambda22, ScrollableKt.scrollable$default(overscroll22, lazyGridState, orientation22, overscrollEffect22, z3, scrollableDefaults22.reverseDirection((LayoutDirection) consume222, orientation22, z622), flingBehavior2, lazyGridState.getInternalInteractionSource(), null, 128, null), lazyGridState.getPrefetchState(), rememberLazyGridMeasurePolicy22, startRestartGroup, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composer2 = startRestartGroup;
                        z5 = z622;
                        modifier4 = modifier3;
                        paddingValues4 = paddingValues522;
                        flingBehavior3 = flingBehavior2;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    if ((i3 & 256) != 0) {
                    }
                    if ((i3 & 512) == 0) {
                    }
                    if ((i3 & 1024) != 0) {
                    }
                    if ((i4 & 1533916891) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 == 0) {
                    }
                    if ((i3 & 64) != 0) {
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    OverscrollEffect overscrollEffect222 = ScrollableDefaults.INSTANCE.overscrollEffect(startRestartGroup, 6);
                    int i11222 = i9 >> 3;
                    int i12222 = i11222 & 14;
                    Function0<LazyGridItemProvider> rememberLazyGridItemProviderLambda222 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, function1, startRestartGroup, ((i8 << 3) & 112) | i12222);
                    int i13222 = i9 >> 9;
                    LazyLayoutSemanticState rememberLazyGridSemanticState222 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, startRestartGroup, (i13222 & 112) | i12222);
                    startRestartGroup.startReplaceableGroup(773894976);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                    startRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    CoroutineScope coroutineScope222 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                    startRestartGroup.endReplaceableGroup();
                    boolean z6222 = z4;
                    Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyGridMeasurePolicy222 = rememberLazyGridMeasurePolicy(rememberLazyGridItemProviderLambda222, lazyGridState, lazyGridSlotsProvider2, paddingValues3, z6222, z2, horizontal, vertical, coroutineScope222, startRestartGroup, (i9 & 896) | (i9 & 112) | 134217728 | (i9 & 7168) | (i9 & 57344) | (i9 & 458752) | (i13222 & 3670016) | (i11222 & 29360128));
                    PaddingValues paddingValues5222 = paddingValues3;
                    lazyGridState.setVertical$foundation_release(z2);
                    Orientation orientation222 = z2 ? Orientation.Vertical : Orientation.Horizontal;
                    Modifier clipScrollableContainer222 = ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier3.then(lazyGridState.getRemeasurementModifier()).then(lazyGridState.getAwaitLayoutModifier()), rememberLazyGridItemProviderLambda222, rememberLazyGridSemanticState222, orientation222, z3, z6222, startRestartGroup, (i13222 & 57344) | ((i9 << 3) & 458752)), orientation222);
                    LazyLayoutBeyondBoundsState rememberLazyGridBeyondBoundsState222 = LazyGridBeyondBoundsModifierKt.rememberLazyGridBeyondBoundsState(lazyGridState, startRestartGroup, i12222);
                    LazyLayoutBeyondBoundsInfo beyondBoundsInfo222 = lazyGridState.getBeyondBoundsInfo();
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection322 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume322 = startRestartGroup.consume(localLayoutDirection322);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    Modifier overscroll222 = OverscrollKt.overscroll(LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(clipScrollableContainer222, rememberLazyGridBeyondBoundsState222, beyondBoundsInfo222, z6222, (LayoutDirection) consume322, orientation222, z3, startRestartGroup, (MutableVector.$stable << 6) | (i11222 & 7168) | (i11222 & 3670016)), overscrollEffect222);
                    ScrollableDefaults scrollableDefaults222 = ScrollableDefaults.INSTANCE;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2222 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume2222 = startRestartGroup.consume(localLayoutDirection2222);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    LazyLayoutKt.LazyLayout(rememberLazyGridItemProviderLambda222, ScrollableKt.scrollable$default(overscroll222, lazyGridState, orientation222, overscrollEffect222, z3, scrollableDefaults222.reverseDirection((LayoutDirection) consume2222, orientation222, z6222), flingBehavior2, lazyGridState.getInternalInteractionSource(), null, 128, null), lazyGridState.getPrefetchState(), rememberLazyGridMeasurePolicy222, startRestartGroup, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2 = startRestartGroup;
                    z5 = z6222;
                    modifier4 = modifier3;
                    paddingValues4 = paddingValues5222;
                    flingBehavior3 = flingBehavior2;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i4 |= i7;
                if ((i & 3670016) == 0) {
                }
                if ((i3 & 128) == 0) {
                }
                if ((i3 & 256) != 0) {
                }
                if ((i3 & 512) == 0) {
                }
                if ((i3 & 1024) != 0) {
                }
                if ((i4 & 1533916891) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i10 != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 == 0) {
                }
                if ((i3 & 64) != 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                OverscrollEffect overscrollEffect2222 = ScrollableDefaults.INSTANCE.overscrollEffect(startRestartGroup, 6);
                int i112222 = i9 >> 3;
                int i122222 = i112222 & 14;
                Function0<LazyGridItemProvider> rememberLazyGridItemProviderLambda2222 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, function1, startRestartGroup, ((i8 << 3) & 112) | i122222);
                int i132222 = i9 >> 9;
                LazyLayoutSemanticState rememberLazyGridSemanticState2222 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, startRestartGroup, (i132222 & 112) | i122222);
                startRestartGroup.startReplaceableGroup(773894976);
                ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                startRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                }
                startRestartGroup.endReplaceableGroup();
                CoroutineScope coroutineScope2222 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                startRestartGroup.endReplaceableGroup();
                boolean z62222 = z4;
                Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyGridMeasurePolicy2222 = rememberLazyGridMeasurePolicy(rememberLazyGridItemProviderLambda2222, lazyGridState, lazyGridSlotsProvider2, paddingValues3, z62222, z2, horizontal, vertical, coroutineScope2222, startRestartGroup, (i9 & 896) | (i9 & 112) | 134217728 | (i9 & 7168) | (i9 & 57344) | (i9 & 458752) | (i132222 & 3670016) | (i112222 & 29360128));
                PaddingValues paddingValues52222 = paddingValues3;
                lazyGridState.setVertical$foundation_release(z2);
                Orientation orientation2222 = z2 ? Orientation.Vertical : Orientation.Horizontal;
                Modifier clipScrollableContainer2222 = ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier3.then(lazyGridState.getRemeasurementModifier()).then(lazyGridState.getAwaitLayoutModifier()), rememberLazyGridItemProviderLambda2222, rememberLazyGridSemanticState2222, orientation2222, z3, z62222, startRestartGroup, (i132222 & 57344) | ((i9 << 3) & 458752)), orientation2222);
                LazyLayoutBeyondBoundsState rememberLazyGridBeyondBoundsState2222 = LazyGridBeyondBoundsModifierKt.rememberLazyGridBeyondBoundsState(lazyGridState, startRestartGroup, i122222);
                LazyLayoutBeyondBoundsInfo beyondBoundsInfo2222 = lazyGridState.getBeyondBoundsInfo();
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3222 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume3222 = startRestartGroup.consume(localLayoutDirection3222);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Modifier overscroll2222 = OverscrollKt.overscroll(LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(clipScrollableContainer2222, rememberLazyGridBeyondBoundsState2222, beyondBoundsInfo2222, z62222, (LayoutDirection) consume3222, orientation2222, z3, startRestartGroup, (MutableVector.$stable << 6) | (i112222 & 7168) | (i112222 & 3670016)), overscrollEffect2222);
                ScrollableDefaults scrollableDefaults2222 = ScrollableDefaults.INSTANCE;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection22222 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume22222 = startRestartGroup.consume(localLayoutDirection22222);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                LazyLayoutKt.LazyLayout(rememberLazyGridItemProviderLambda2222, ScrollableKt.scrollable$default(overscroll2222, lazyGridState, orientation2222, overscrollEffect2222, z3, scrollableDefaults2222.reverseDirection((LayoutDirection) consume22222, orientation2222, z62222), flingBehavior2, lazyGridState.getInternalInteractionSource(), null, 128, null), lazyGridState.getPrefetchState(), rememberLazyGridMeasurePolicy2222, startRestartGroup, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                z5 = z62222;
                modifier4 = modifier3;
                paddingValues4 = paddingValues52222;
                flingBehavior3 = flingBehavior2;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            paddingValues2 = paddingValues;
            i6 = i3 & 16;
            if (i6 != 0) {
            }
            if ((i3 & 32) != 0) {
            }
            i4 |= i7;
            if ((i & 3670016) == 0) {
            }
            if ((i3 & 128) == 0) {
            }
            if ((i3 & 256) != 0) {
            }
            if ((i3 & 512) == 0) {
            }
            if ((i3 & 1024) != 0) {
            }
            if ((i4 & 1533916891) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i10 != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 == 0) {
            }
            if ((i3 & 64) != 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            OverscrollEffect overscrollEffect22222 = ScrollableDefaults.INSTANCE.overscrollEffect(startRestartGroup, 6);
            int i1122222 = i9 >> 3;
            int i1222222 = i1122222 & 14;
            Function0<LazyGridItemProvider> rememberLazyGridItemProviderLambda22222 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, function1, startRestartGroup, ((i8 << 3) & 112) | i1222222);
            int i1322222 = i9 >> 9;
            LazyLayoutSemanticState rememberLazyGridSemanticState22222 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, startRestartGroup, (i1322222 & 112) | i1222222);
            startRestartGroup.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            CoroutineScope coroutineScope22222 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
            startRestartGroup.endReplaceableGroup();
            boolean z622222 = z4;
            Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyGridMeasurePolicy22222 = rememberLazyGridMeasurePolicy(rememberLazyGridItemProviderLambda22222, lazyGridState, lazyGridSlotsProvider2, paddingValues3, z622222, z2, horizontal, vertical, coroutineScope22222, startRestartGroup, (i9 & 896) | (i9 & 112) | 134217728 | (i9 & 7168) | (i9 & 57344) | (i9 & 458752) | (i1322222 & 3670016) | (i1122222 & 29360128));
            PaddingValues paddingValues522222 = paddingValues3;
            lazyGridState.setVertical$foundation_release(z2);
            Orientation orientation22222 = z2 ? Orientation.Vertical : Orientation.Horizontal;
            Modifier clipScrollableContainer22222 = ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier3.then(lazyGridState.getRemeasurementModifier()).then(lazyGridState.getAwaitLayoutModifier()), rememberLazyGridItemProviderLambda22222, rememberLazyGridSemanticState22222, orientation22222, z3, z622222, startRestartGroup, (i1322222 & 57344) | ((i9 << 3) & 458752)), orientation22222);
            LazyLayoutBeyondBoundsState rememberLazyGridBeyondBoundsState22222 = LazyGridBeyondBoundsModifierKt.rememberLazyGridBeyondBoundsState(lazyGridState, startRestartGroup, i1222222);
            LazyLayoutBeyondBoundsInfo beyondBoundsInfo22222 = lazyGridState.getBeyondBoundsInfo();
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection32222 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume32222 = startRestartGroup.consume(localLayoutDirection32222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier overscroll22222 = OverscrollKt.overscroll(LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(clipScrollableContainer22222, rememberLazyGridBeyondBoundsState22222, beyondBoundsInfo22222, z622222, (LayoutDirection) consume32222, orientation22222, z3, startRestartGroup, (MutableVector.$stable << 6) | (i1122222 & 7168) | (i1122222 & 3670016)), overscrollEffect22222);
            ScrollableDefaults scrollableDefaults22222 = ScrollableDefaults.INSTANCE;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection222222 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume222222 = startRestartGroup.consume(localLayoutDirection222222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LazyLayoutKt.LazyLayout(rememberLazyGridItemProviderLambda22222, ScrollableKt.scrollable$default(overscroll22222, lazyGridState, orientation22222, overscrollEffect22222, z3, scrollableDefaults22222.reverseDirection((LayoutDirection) consume222222, orientation22222, z622222), flingBehavior2, lazyGridState.getInternalInteractionSource(), null, 128, null), lazyGridState.getPrefetchState(), rememberLazyGridMeasurePolicy22222, startRestartGroup, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            z5 = z622222;
            modifier4 = modifier3;
            paddingValues4 = paddingValues522222;
            flingBehavior3 = flingBehavior2;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        lazyGridSlotsProvider2 = lazyGridSlotsProvider;
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        paddingValues2 = paddingValues;
        i6 = i3 & 16;
        if (i6 != 0) {
        }
        if ((i3 & 32) != 0) {
        }
        i4 |= i7;
        if ((i & 3670016) == 0) {
        }
        if ((i3 & 128) == 0) {
        }
        if ((i3 & 256) != 0) {
        }
        if ((i3 & 512) == 0) {
        }
        if ((i3 & 1024) != 0) {
        }
        if ((i4 & 1533916891) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i10 != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 == 0) {
        }
        if ((i3 & 64) != 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        OverscrollEffect overscrollEffect222222 = ScrollableDefaults.INSTANCE.overscrollEffect(startRestartGroup, 6);
        int i11222222 = i9 >> 3;
        int i12222222 = i11222222 & 14;
        Function0<LazyGridItemProvider> rememberLazyGridItemProviderLambda222222 = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, function1, startRestartGroup, ((i8 << 3) & 112) | i12222222);
        int i13222222 = i9 >> 9;
        LazyLayoutSemanticState rememberLazyGridSemanticState222222 = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z4, startRestartGroup, (i13222222 & 112) | i12222222);
        startRestartGroup.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        CoroutineScope coroutineScope222222 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
        startRestartGroup.endReplaceableGroup();
        boolean z6222222 = z4;
        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyGridMeasurePolicy222222 = rememberLazyGridMeasurePolicy(rememberLazyGridItemProviderLambda222222, lazyGridState, lazyGridSlotsProvider2, paddingValues3, z6222222, z2, horizontal, vertical, coroutineScope222222, startRestartGroup, (i9 & 896) | (i9 & 112) | 134217728 | (i9 & 7168) | (i9 & 57344) | (i9 & 458752) | (i13222222 & 3670016) | (i11222222 & 29360128));
        PaddingValues paddingValues5222222 = paddingValues3;
        lazyGridState.setVertical$foundation_release(z2);
        Orientation orientation222222 = z2 ? Orientation.Vertical : Orientation.Horizontal;
        Modifier clipScrollableContainer222222 = ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier3.then(lazyGridState.getRemeasurementModifier()).then(lazyGridState.getAwaitLayoutModifier()), rememberLazyGridItemProviderLambda222222, rememberLazyGridSemanticState222222, orientation222222, z3, z6222222, startRestartGroup, (i13222222 & 57344) | ((i9 << 3) & 458752)), orientation222222);
        LazyLayoutBeyondBoundsState rememberLazyGridBeyondBoundsState222222 = LazyGridBeyondBoundsModifierKt.rememberLazyGridBeyondBoundsState(lazyGridState, startRestartGroup, i12222222);
        LazyLayoutBeyondBoundsInfo beyondBoundsInfo222222 = lazyGridState.getBeyondBoundsInfo();
        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection322222 = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume322222 = startRestartGroup.consume(localLayoutDirection322222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Modifier overscroll222222 = OverscrollKt.overscroll(LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(clipScrollableContainer222222, rememberLazyGridBeyondBoundsState222222, beyondBoundsInfo222222, z6222222, (LayoutDirection) consume322222, orientation222222, z3, startRestartGroup, (MutableVector.$stable << 6) | (i11222222 & 7168) | (i11222222 & 3670016)), overscrollEffect222222);
        ScrollableDefaults scrollableDefaults222222 = ScrollableDefaults.INSTANCE;
        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2222222 = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2222222 = startRestartGroup.consume(localLayoutDirection2222222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        LazyLayoutKt.LazyLayout(rememberLazyGridItemProviderLambda222222, ScrollableKt.scrollable$default(overscroll222222, lazyGridState, orientation222222, overscrollEffect222222, z3, scrollableDefaults222222.reverseDirection((LayoutDirection) consume2222222, orientation222222, z6222222), flingBehavior2, lazyGridState.getInternalInteractionSource(), null, 128, null), lazyGridState.getPrefetchState(), rememberLazyGridMeasurePolicy222222, startRestartGroup, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        z5 = z6222222;
        modifier4 = modifier3;
        paddingValues4 = paddingValues5222222;
        flingBehavior3 = flingBehavior2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    private static final Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyGridMeasurePolicy(final Function0<? extends LazyGridItemProvider> function0, final LazyGridState lazyGridState, final LazyGridSlotsProvider lazyGridSlotsProvider, final PaddingValues paddingValues, final boolean z, final boolean z2, final Arrangement.Horizontal horizontal, final Arrangement.Vertical vertical, final CoroutineScope coroutineScope, Composer composer, int i) {
        composer.startReplaceableGroup(-2068958445);
        ComposerKt.sourceInformation(composer, "C(rememberLazyGridMeasurePolicy)P(4,7,6!1,5,3,2,8)167@6903L8834:LazyGrid.kt#7791vq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2068958445, i, -1, "androidx.compose.foundation.lazy.grid.rememberLazyGridMeasurePolicy (LazyGrid.kt:167)");
        }
        Object[] objArr = {lazyGridState, lazyGridSlotsProvider, paddingValues, Boolean.valueOf(z), Boolean.valueOf(z2), horizontal, vertical};
        composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean z3 = false;
        for (int i2 = 0; i2 < 7; i2++) {
            z3 |= composer.changed(objArr[i2]);
        }
        Object rememberedValue = composer.rememberedValue();
        if (z3 || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = (Function2) new Function2<LazyLayoutMeasureScope, Constraints, LazyGridMeasureResult>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ LazyGridMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                    return m1015invoke0kLqBqw(lazyLayoutMeasureScope, constraints.getValue());
                }

                /* JADX WARN: Type inference failed for: r28v0, types: [androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1] */
                /* JADX WARN: Type inference failed for: r33v0, types: [androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1] */
                /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final LazyGridMeasureResult m1015invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
                    int i3;
                    int i4;
                    int i5;
                    float spacing;
                    int m6345getMaxWidthimpl;
                    long IntOffset;
                    int firstVisibleItemScrollOffset;
                    int i6;
                    CheckScrollableContainerConstraintsKt.m555checkScrollableContainerConstraintsK40F9xA(j, z2 ? Orientation.Vertical : Orientation.Horizontal);
                    if (z2) {
                        i3 = lazyLayoutMeasureScope.mo624roundToPx0680j_4(paddingValues.mo830calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                    } else {
                        i3 = lazyLayoutMeasureScope.mo624roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                    }
                    if (z2) {
                        i4 = lazyLayoutMeasureScope.mo624roundToPx0680j_4(paddingValues.mo831calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                    } else {
                        i4 = lazyLayoutMeasureScope.mo624roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                    }
                    int i7 = lazyLayoutMeasureScope.mo624roundToPx0680j_4(paddingValues.getTop());
                    int i8 = lazyLayoutMeasureScope.mo624roundToPx0680j_4(paddingValues.getBottom());
                    final int i9 = i7 + i8;
                    final int i10 = i3 + i4;
                    boolean z4 = z2;
                    int i11 = z4 ? i9 : i10;
                    if (z4 && !z) {
                        i5 = i7;
                    } else if (z4 && z) {
                        i5 = i8;
                    } else {
                        i5 = (z4 || z) ? i4 : i3;
                    }
                    final int i12 = i11 - i5;
                    long m6361offsetNN6EwU = ConstraintsKt.m6361offsetNN6EwU(j, -i10, -i9);
                    final LazyGridItemProvider invoke = function0.invoke();
                    final LazyGridSpanLayoutProvider spanLayoutProvider = invoke.getSpanLayoutProvider();
                    LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
                    final LazyGridSlots mo1004invoke0kLqBqw = lazyGridSlotsProvider.mo1004invoke0kLqBqw(lazyLayoutMeasureScope2, j);
                    int length = mo1004invoke0kLqBqw.getSizes().length;
                    spanLayoutProvider.setSlotsPerLine(length);
                    lazyGridState.setDensity$foundation_release(lazyLayoutMeasureScope2);
                    lazyGridState.setSlotsPerLine$foundation_release(length);
                    if (z2) {
                        Arrangement.Vertical vertical2 = vertical;
                        if (vertical2 == null) {
                            throw new IllegalArgumentException("null verticalArrangement when isVertical == true".toString());
                        }
                        spacing = vertical2.getSpacing();
                    } else {
                        Arrangement.Horizontal horizontal2 = horizontal;
                        if (horizontal2 == null) {
                            throw new IllegalArgumentException("null horizontalArrangement when isVertical == false".toString());
                        }
                        spacing = horizontal2.getSpacing();
                    }
                    final int i13 = lazyLayoutMeasureScope.mo624roundToPx0680j_4(spacing);
                    final int itemCount = invoke.getItemCount();
                    if (z2) {
                        m6345getMaxWidthimpl = Constraints.m6344getMaxHeightimpl(j) - i9;
                    } else {
                        m6345getMaxWidthimpl = Constraints.m6345getMaxWidthimpl(j) - i10;
                    }
                    int i14 = m6345getMaxWidthimpl;
                    if (!z || i14 > 0) {
                        IntOffset = IntOffsetKt.IntOffset(i3, i7);
                    } else {
                        boolean z5 = z2;
                        if (!z5) {
                            i3 += i14;
                        }
                        if (z5) {
                            i7 += i14;
                        }
                        IntOffset = IntOffsetKt.IntOffset(i3, i7);
                    }
                    final long j2 = IntOffset;
                    final LazyGridState lazyGridState2 = lazyGridState;
                    final boolean z6 = z2;
                    final boolean z7 = z;
                    final int i15 = i5;
                    final ?? r33 = new LazyGridMeasuredItemProvider(invoke, lazyLayoutMeasureScope, i13, lazyGridState2, z6, z7, i15, i12, j2) { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1
                        final /* synthetic */ int $afterContentPadding;
                        final /* synthetic */ int $beforeContentPadding;
                        final /* synthetic */ boolean $isVertical;
                        final /* synthetic */ boolean $reverseLayout;
                        final /* synthetic */ LazyGridState $state;
                        final /* synthetic */ LazyLayoutMeasureScope $this_null;
                        final /* synthetic */ long $visualItemOffset;

                        {
                            this.$this_null = lazyLayoutMeasureScope;
                            this.$state = lazyGridState2;
                            this.$isVertical = z6;
                            this.$reverseLayout = z7;
                            this.$beforeContentPadding = i15;
                            this.$afterContentPadding = i12;
                            this.$visualItemOffset = j2;
                        }

                        @Override // androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider
                        public LazyGridMeasuredItem createItem(int index, Object key, Object contentType, int crossAxisSize, int mainAxisSpacing, List<? extends Placeable> placeables) {
                            return new LazyGridMeasuredItem(index, key, this.$isVertical, crossAxisSize, mainAxisSpacing, this.$reverseLayout, this.$this_null.getLayoutDirection(), this.$beforeContentPadding, this.$afterContentPadding, placeables, this.$visualItemOffset, contentType, this.$state.getPlacementAnimator(), null);
                        }
                    };
                    final boolean z8 = z2;
                    final ?? r28 = new LazyGridMeasuredLineProvider(z8, mo1004invoke0kLqBqw, itemCount, i13, r33, spanLayoutProvider) { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1
                        final /* synthetic */ boolean $isVertical;
                        final /* synthetic */ LazyGridSlots $resolvedSlots;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(z8, mo1004invoke0kLqBqw, itemCount, i13, r33, spanLayoutProvider);
                            this.$isVertical = z8;
                            this.$resolvedSlots = mo1004invoke0kLqBqw;
                        }

                        @Override // androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider
                        public LazyGridMeasuredLine createLine(int index, LazyGridMeasuredItem[] items, List<GridItemSpan> spans, int mainAxisSpacing) {
                            return new LazyGridMeasuredLine(index, items, this.$resolvedSlots, spans, this.$isVertical, mainAxisSpacing);
                        }
                    };
                    lazyGridState.setPrefetchInfoRetriever$foundation_release(new Function1<Integer, ArrayList<Pair<? extends Integer, ? extends Constraints>>>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ ArrayList<Pair<? extends Integer, ? extends Constraints>> invoke(Integer num) {
                            return invoke(num.intValue());
                        }

                        public final ArrayList<Pair<Integer, Constraints>> invoke(int i16) {
                            LazyGridSpanLayoutProvider.LineConfiguration lineConfiguration = LazyGridSpanLayoutProvider.this.getLineConfiguration(i16);
                            int firstItemIndex = lineConfiguration.getFirstItemIndex();
                            ArrayList<Pair<Integer, Constraints>> arrayList = new ArrayList<>(lineConfiguration.getSpans().size());
                            List<GridItemSpan> spans = lineConfiguration.getSpans();
                            LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 = r28;
                            int size = spans.size();
                            int i17 = 0;
                            for (int i18 = 0; i18 < size; i18++) {
                                int m1000getCurrentLineSpanimpl = GridItemSpan.m1000getCurrentLineSpanimpl(spans.get(i18).getPackedValue());
                                arrayList.add(TuplesKt.to(Integer.valueOf(firstItemIndex), Constraints.m6333boximpl(lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1.m1022childConstraintsJhjzzOo$foundation_release(i17, m1000getCurrentLineSpanimpl))));
                                firstItemIndex++;
                                i17 += m1000getCurrentLineSpanimpl;
                            }
                            return arrayList;
                        }
                    });
                    Snapshot.Companion companion = Snapshot.INSTANCE;
                    LazyGridState lazyGridState3 = lazyGridState;
                    Snapshot createNonObservableSnapshot = companion.createNonObservableSnapshot();
                    try {
                        Snapshot makeCurrent = createNonObservableSnapshot.makeCurrent();
                        try {
                            int updateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyGridState3.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(invoke, lazyGridState3.getFirstVisibleItemIndex());
                            if (updateScrollPositionIfTheFirstItemWasMoved$foundation_release >= itemCount && itemCount > 0) {
                                i6 = spanLayoutProvider.getLineIndexOfItem(itemCount - 1);
                                firstVisibleItemScrollOffset = 0;
                                Unit unit = Unit.INSTANCE;
                                createNonObservableSnapshot.dispose();
                                LazyGridMeasureResult m1017measureLazyGridW2FL7xs = LazyGridMeasureKt.m1017measureLazyGridW2FL7xs(itemCount, (LazyGridMeasuredLineProvider) r28, (LazyGridMeasuredItemProvider) r33, i14, i5, i12, i13, i6, firstVisibleItemScrollOffset, lazyGridState.getScrollToBeConsumed(), m6361offsetNN6EwU, z2, vertical, horizontal, z, lazyLayoutMeasureScope2, lazyGridState.getPlacementAnimator(), spanLayoutProvider, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(invoke, lazyGridState.getPinnedItems(), lazyGridState.getBeyondBoundsInfo()), coroutineScope, lazyGridState.m1024getPlacementScopeInvalidatorzYiylxw$foundation_release(), new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                                        return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                                    }

                                    public final MeasureResult invoke(int i16, int i17, Function1<? super Placeable.PlacementScope, Unit> function1) {
                                        return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m6359constrainWidthK40F9xA(j, i16 + i10), ConstraintsKt.m6358constrainHeightK40F9xA(j, i17 + i9), MapsKt.emptyMap(), function1);
                                    }
                                });
                                LazyGridState.applyMeasureResult$foundation_release$default(lazyGridState, m1017measureLazyGridW2FL7xs, false, 2, null);
                                return m1017measureLazyGridW2FL7xs;
                            }
                            int lineIndexOfItem = spanLayoutProvider.getLineIndexOfItem(updateScrollPositionIfTheFirstItemWasMoved$foundation_release);
                            firstVisibleItemScrollOffset = lazyGridState3.getFirstVisibleItemScrollOffset();
                            i6 = lineIndexOfItem;
                            Unit unit2 = Unit.INSTANCE;
                            createNonObservableSnapshot.dispose();
                            LazyGridMeasureResult m1017measureLazyGridW2FL7xs2 = LazyGridMeasureKt.m1017measureLazyGridW2FL7xs(itemCount, (LazyGridMeasuredLineProvider) r28, (LazyGridMeasuredItemProvider) r33, i14, i5, i12, i13, i6, firstVisibleItemScrollOffset, lazyGridState.getScrollToBeConsumed(), m6361offsetNN6EwU, z2, vertical, horizontal, z, lazyLayoutMeasureScope2, lazyGridState.getPlacementAnimator(), spanLayoutProvider, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(invoke, lazyGridState.getPinnedItems(), lazyGridState.getBeyondBoundsInfo()), coroutineScope, lazyGridState.m1024getPlacementScopeInvalidatorzYiylxw$foundation_release(), new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1.3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                                    return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                                }

                                public final MeasureResult invoke(int i16, int i17, Function1<? super Placeable.PlacementScope, Unit> function1) {
                                    return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m6359constrainWidthK40F9xA(j, i16 + i10), ConstraintsKt.m6358constrainHeightK40F9xA(j, i17 + i9), MapsKt.emptyMap(), function1);
                                }
                            });
                            LazyGridState.applyMeasureResult$foundation_release$default(lazyGridState, m1017measureLazyGridW2FL7xs2, false, 2, null);
                            return m1017measureLazyGridW2FL7xs2;
                        } finally {
                            createNonObservableSnapshot.restoreCurrent(makeCurrent);
                        }
                    } catch (Throwable th) {
                        createNonObservableSnapshot.dispose();
                        throw th;
                    }
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2 = (Function2) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return function2;
    }
}
