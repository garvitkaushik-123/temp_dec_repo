package androidx.compose.foundation.lazy;

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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LazyList.kt */
@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0098\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0017\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00010\u0019¢\u0006\u0002\b\u001bH\u0001¢\u0006\u0002\u0010\u001c\u001a\u008a\u0001\u0010\u001d\u001a\u0019\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001e¢\u0006\u0002\b\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0003¢\u0006\u0002\u0010%¨\u0006&"}, d2 = {"LazyList", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "isVertical", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "beyondBoundsItemCount", "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/gestures/FlingBehavior;ZILandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "rememberLazyListMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZZILandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/runtime/Composer;II)Lkotlin/jvm/functions/Function2;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyListKt {
    /* JADX WARN: Removed duplicated region for block: B:107:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x014e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LazyList(final Modifier modifier, final LazyListState lazyListState, final PaddingValues paddingValues, boolean z, final boolean z2, final FlingBehavior flingBehavior, final boolean z3, int i, Alignment.Horizontal horizontal, Arrangement.Vertical vertical, Alignment.Vertical vertical2, Arrangement.Horizontal horizontal2, final Function1<? super LazyListScope, Unit> function1, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        PaddingValues paddingValues2;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        Object rememberedValue;
        boolean z4;
        int i17;
        Composer composer2;
        final Alignment.Horizontal horizontal3;
        final Alignment.Vertical vertical3;
        final Arrangement.Horizontal horizontal4;
        final Arrangement.Vertical vertical4;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(620764179);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyList)P(7,9,2,8,6,3,10!1,4,12,11,5)80@3813L50,82@3889L48,83@3954L24,86@4037L292,99@4377L18,105@4632L277,114@5029L153,120@5345L7,113@4973L481,128@5678L7,101@4487L1676:LazyList.kt#428nma");
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i5 = (startRestartGroup.changed(modifier) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i2 & 112) == 0) {
            i5 |= startRestartGroup.changed(lazyListState) ? 32 : 16;
        }
        if ((i4 & 4) != 0) {
            i5 |= 384;
        } else if ((i2 & 896) == 0) {
            paddingValues2 = paddingValues;
            i5 |= startRestartGroup.changed(paddingValues2) ? 256 : 128;
            if ((i4 & 8) == 0) {
                i5 |= 3072;
            } else if ((i2 & 7168) == 0) {
                i5 |= startRestartGroup.changed(z) ? 2048 : 1024;
            }
            if ((i4 & 16) == 0) {
                i5 |= 24576;
            } else if ((i2 & 57344) == 0) {
                i5 |= startRestartGroup.changed(z2) ? 16384 : 8192;
            }
            if ((i4 & 32) == 0) {
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i2 & 458752) == 0) {
                i5 |= startRestartGroup.changed(flingBehavior) ? 131072 : 65536;
                if ((i4 & 64) != 0) {
                    i5 |= 1572864;
                } else if ((i2 & 3670016) == 0) {
                    i5 |= startRestartGroup.changed(z3) ? 1048576 : 524288;
                }
                i6 = i4 & 128;
                if (i6 != 0) {
                    i5 |= 12582912;
                    i7 = i;
                } else {
                    i7 = i;
                    if ((i2 & 29360128) == 0) {
                        i5 |= startRestartGroup.changed(i7) ? 8388608 : 4194304;
                    }
                }
                i8 = i4 & 256;
                if (i8 != 0) {
                    i5 |= 100663296;
                } else if ((i2 & 234881024) == 0) {
                    i5 |= startRestartGroup.changed(horizontal) ? 67108864 : 33554432;
                }
                i9 = i4 & 512;
                if (i9 != 0) {
                    i5 |= C.ENCODING_PCM_32BIT;
                } else if ((i2 & 1879048192) == 0) {
                    i10 = i9;
                    i5 |= startRestartGroup.changed(vertical) ? 536870912 : 268435456;
                    i11 = i4 & 1024;
                    if (i11 == 0) {
                        i13 = i3 | 6;
                        i12 = i11;
                    } else if ((i3 & 14) == 0) {
                        i12 = i11;
                        i13 = i3 | (startRestartGroup.changed(vertical2) ? 4 : 2);
                    } else {
                        i12 = i11;
                        i13 = i3;
                    }
                    i14 = i4 & 2048;
                    if (i14 == 0) {
                        i13 |= 48;
                        i15 = i14;
                    } else if ((i3 & 112) == 0) {
                        i15 = i14;
                        i13 |= startRestartGroup.changed(horizontal2) ? 32 : 16;
                    } else {
                        i15 = i14;
                    }
                    i16 = i13;
                    if ((i4 & 4096) == 0) {
                        i16 |= 384;
                    } else if ((i3 & 896) == 0) {
                        i16 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
                    }
                    if ((1533916891 & i5) == 306783378 || (i16 & 731) != 146 || !startRestartGroup.getSkipping()) {
                        int i18 = i6 == 0 ? 0 : i7;
                        Alignment.Horizontal horizontal5 = i8 == 0 ? null : horizontal;
                        Arrangement.Vertical vertical5 = i10 == 0 ? null : vertical;
                        Alignment.Vertical vertical6 = i12 == 0 ? null : vertical2;
                        Arrangement.Horizontal horizontal6 = i15 == 0 ? horizontal2 : null;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(620764179, i5, i16, "androidx.compose.foundation.lazy.LazyList (LazyList.kt:79)");
                        }
                        int i19 = (i5 >> 3) & 14;
                        Function0<LazyListItemProvider> rememberLazyListItemProviderLambda = LazyListItemProviderKt.rememberLazyListItemProviderLambda(lazyListState, function1, startRestartGroup, i19 | ((i16 >> 3) & 112));
                        LazyLayoutSemanticState rememberLazyListSemanticState = LazyListSemanticsKt.rememberLazyListSemanticState(lazyListState, z2, startRestartGroup, i19 | ((i5 >> 9) & 112));
                        startRestartGroup.startReplaceableGroup(773894976);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                        startRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        startRestartGroup.endReplaceableGroup();
                        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                        startRestartGroup.endReplaceableGroup();
                        lazyListState.setCoroutineScope$foundation_release(coroutineScope);
                        int i20 = i5 & 7168;
                        int i21 = i5 >> 6;
                        int i22 = i16 << 21;
                        int i23 = (65520 & i5) | (i21 & 458752) | (i21 & 3670016) | (i22 & 29360128) | (i22 & 234881024) | (1879048192 & i5);
                        Arrangement.Vertical vertical7 = vertical5;
                        Alignment.Vertical vertical8 = vertical6;
                        int i24 = i5;
                        Alignment.Horizontal horizontal7 = horizontal5;
                        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyListMeasurePolicy = rememberLazyListMeasurePolicy(rememberLazyListItemProviderLambda, lazyListState, paddingValues2, z, z2, i18, horizontal7, vertical8, horizontal6, vertical7, startRestartGroup, i23, 0);
                        int i25 = i18;
                        OverscrollEffect overscrollEffect = ScrollableDefaults.INSTANCE.overscrollEffect(startRestartGroup, 6);
                        Orientation orientation = !z2 ? Orientation.Vertical : Orientation.Horizontal;
                        Modifier clipScrollableContainer = ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier.then(lazyListState.getRemeasurementModifier()).then(lazyListState.getAwaitLayoutModifier()), rememberLazyListItemProviderLambda, rememberLazyListSemanticState, orientation, z3, z, startRestartGroup, (i21 & 57344) | ((i24 << 6) & 458752)), orientation);
                        LazyLayoutBeyondBoundsState rememberLazyListBeyondBoundsState = LazyListBeyondBoundsModifierKt.rememberLazyListBeyondBoundsState(lazyListState, i25, startRestartGroup, i19 | ((i24 >> 18) & 112));
                        LazyLayoutBeyondBoundsInfo beyondBoundsInfo = lazyListState.getBeyondBoundsInfo();
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume = startRestartGroup.consume(localLayoutDirection);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        z4 = z;
                        Modifier overscroll = OverscrollKt.overscroll(LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(clipScrollableContainer, rememberLazyListBeyondBoundsState, beyondBoundsInfo, z4, (LayoutDirection) consume, orientation, z3, startRestartGroup, i20 | (MutableVector.$stable << 6) | (i24 & 3670016)), overscrollEffect);
                        ScrollableDefaults scrollableDefaults = ScrollableDefaults.INSTANCE;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume2 = startRestartGroup.consume(localLayoutDirection2);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        i17 = i25;
                        LazyLayoutKt.LazyLayout(rememberLazyListItemProviderLambda, ScrollableKt.scrollable$default(overscroll, lazyListState, orientation, overscrollEffect, z3, scrollableDefaults.reverseDirection((LayoutDirection) consume2, orientation, z4), flingBehavior, lazyListState.getInternalInteractionSource(), null, 128, null), lazyListState.getPrefetchState(), rememberLazyListMeasurePolicy, startRestartGroup, 0, 0);
                        composer2 = startRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        horizontal3 = horizontal7;
                        vertical3 = vertical8;
                        horizontal4 = horizontal6;
                        vertical4 = vertical7;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        z4 = z;
                        horizontal3 = horizontal;
                        vertical4 = vertical;
                        vertical3 = vertical2;
                        composer2 = startRestartGroup;
                        i17 = i7;
                        horizontal4 = horizontal2;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        final boolean z5 = z4;
                        final int i26 = i17;
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListKt$LazyList$1
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

                            public final void invoke(Composer composer3, int i27) {
                                LazyListKt.LazyList(Modifier.this, lazyListState, paddingValues, z5, z2, flingBehavior, z3, i26, horizontal3, vertical4, vertical3, horizontal4, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
                            }
                        });
                        return;
                    }
                    return;
                }
                i10 = i9;
                i11 = i4 & 1024;
                if (i11 == 0) {
                }
                i14 = i4 & 2048;
                if (i14 == 0) {
                }
                i16 = i13;
                if ((i4 & 4096) == 0) {
                }
                if ((1533916891 & i5) == 306783378) {
                }
                if (i6 == 0) {
                }
                if (i8 == 0) {
                }
                if (i10 == 0) {
                }
                if (i12 == 0) {
                }
                Arrangement.Horizontal horizontal62 = i15 == 0 ? horizontal2 : null;
                if (ComposerKt.isTraceInProgress()) {
                }
                int i192 = (i5 >> 3) & 14;
                Function0<LazyListItemProvider> rememberLazyListItemProviderLambda2 = LazyListItemProviderKt.rememberLazyListItemProviderLambda(lazyListState, function1, startRestartGroup, i192 | ((i16 >> 3) & 112));
                LazyLayoutSemanticState rememberLazyListSemanticState2 = LazyListSemanticsKt.rememberLazyListSemanticState(lazyListState, z2, startRestartGroup, i192 | ((i5 >> 9) & 112));
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
                lazyListState.setCoroutineScope$foundation_release(coroutineScope2);
                int i202 = i5 & 7168;
                int i212 = i5 >> 6;
                int i222 = i16 << 21;
                int i232 = (65520 & i5) | (i212 & 458752) | (i212 & 3670016) | (i222 & 29360128) | (i222 & 234881024) | (1879048192 & i5);
                Arrangement.Vertical vertical72 = vertical5;
                Alignment.Vertical vertical82 = vertical6;
                int i242 = i5;
                Alignment.Horizontal horizontal72 = horizontal5;
                Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyListMeasurePolicy2 = rememberLazyListMeasurePolicy(rememberLazyListItemProviderLambda2, lazyListState, paddingValues2, z, z2, i18, horizontal72, vertical82, horizontal62, vertical72, startRestartGroup, i232, 0);
                int i252 = i18;
                OverscrollEffect overscrollEffect2 = ScrollableDefaults.INSTANCE.overscrollEffect(startRestartGroup, 6);
                Orientation orientation2 = !z2 ? Orientation.Vertical : Orientation.Horizontal;
                Modifier clipScrollableContainer2 = ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier.then(lazyListState.getRemeasurementModifier()).then(lazyListState.getAwaitLayoutModifier()), rememberLazyListItemProviderLambda2, rememberLazyListSemanticState2, orientation2, z3, z, startRestartGroup, (i212 & 57344) | ((i242 << 6) & 458752)), orientation2);
                LazyLayoutBeyondBoundsState rememberLazyListBeyondBoundsState2 = LazyListBeyondBoundsModifierKt.rememberLazyListBeyondBoundsState(lazyListState, i252, startRestartGroup, i192 | ((i242 >> 18) & 112));
                LazyLayoutBeyondBoundsInfo beyondBoundsInfo2 = lazyListState.getBeyondBoundsInfo();
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume3 = startRestartGroup.consume(localLayoutDirection3);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                z4 = z;
                Modifier overscroll2 = OverscrollKt.overscroll(LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(clipScrollableContainer2, rememberLazyListBeyondBoundsState2, beyondBoundsInfo2, z4, (LayoutDirection) consume3, orientation2, z3, startRestartGroup, i202 | (MutableVector.$stable << 6) | (i242 & 3670016)), overscrollEffect2);
                ScrollableDefaults scrollableDefaults2 = ScrollableDefaults.INSTANCE;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection22 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume22 = startRestartGroup.consume(localLayoutDirection22);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                i17 = i252;
                LazyLayoutKt.LazyLayout(rememberLazyListItemProviderLambda2, ScrollableKt.scrollable$default(overscroll2, lazyListState, orientation2, overscrollEffect2, z3, scrollableDefaults2.reverseDirection((LayoutDirection) consume22, orientation2, z4), flingBehavior, lazyListState.getInternalInteractionSource(), null, 128, null), lazyListState.getPrefetchState(), rememberLazyListMeasurePolicy2, startRestartGroup, 0, 0);
                composer2 = startRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                }
                horizontal3 = horizontal72;
                vertical3 = vertical82;
                horizontal4 = horizontal62;
                vertical4 = vertical72;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            if ((i4 & 64) != 0) {
            }
            i6 = i4 & 128;
            if (i6 != 0) {
            }
            i8 = i4 & 256;
            if (i8 != 0) {
            }
            i9 = i4 & 512;
            if (i9 != 0) {
            }
            i10 = i9;
            i11 = i4 & 1024;
            if (i11 == 0) {
            }
            i14 = i4 & 2048;
            if (i14 == 0) {
            }
            i16 = i13;
            if ((i4 & 4096) == 0) {
            }
            if ((1533916891 & i5) == 306783378) {
            }
            if (i6 == 0) {
            }
            if (i8 == 0) {
            }
            if (i10 == 0) {
            }
            if (i12 == 0) {
            }
            Arrangement.Horizontal horizontal622 = i15 == 0 ? horizontal2 : null;
            if (ComposerKt.isTraceInProgress()) {
            }
            int i1922 = (i5 >> 3) & 14;
            Function0<LazyListItemProvider> rememberLazyListItemProviderLambda22 = LazyListItemProviderKt.rememberLazyListItemProviderLambda(lazyListState, function1, startRestartGroup, i1922 | ((i16 >> 3) & 112));
            LazyLayoutSemanticState rememberLazyListSemanticState22 = LazyListSemanticsKt.rememberLazyListSemanticState(lazyListState, z2, startRestartGroup, i1922 | ((i5 >> 9) & 112));
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
            lazyListState.setCoroutineScope$foundation_release(coroutineScope22);
            int i2022 = i5 & 7168;
            int i2122 = i5 >> 6;
            int i2222 = i16 << 21;
            int i2322 = (65520 & i5) | (i2122 & 458752) | (i2122 & 3670016) | (i2222 & 29360128) | (i2222 & 234881024) | (1879048192 & i5);
            Arrangement.Vertical vertical722 = vertical5;
            Alignment.Vertical vertical822 = vertical6;
            int i2422 = i5;
            Alignment.Horizontal horizontal722 = horizontal5;
            Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyListMeasurePolicy22 = rememberLazyListMeasurePolicy(rememberLazyListItemProviderLambda22, lazyListState, paddingValues2, z, z2, i18, horizontal722, vertical822, horizontal622, vertical722, startRestartGroup, i2322, 0);
            int i2522 = i18;
            OverscrollEffect overscrollEffect22 = ScrollableDefaults.INSTANCE.overscrollEffect(startRestartGroup, 6);
            Orientation orientation22 = !z2 ? Orientation.Vertical : Orientation.Horizontal;
            Modifier clipScrollableContainer22 = ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier.then(lazyListState.getRemeasurementModifier()).then(lazyListState.getAwaitLayoutModifier()), rememberLazyListItemProviderLambda22, rememberLazyListSemanticState22, orientation22, z3, z, startRestartGroup, (i2122 & 57344) | ((i2422 << 6) & 458752)), orientation22);
            LazyLayoutBeyondBoundsState rememberLazyListBeyondBoundsState22 = LazyListBeyondBoundsModifierKt.rememberLazyListBeyondBoundsState(lazyListState, i2522, startRestartGroup, i1922 | ((i2422 >> 18) & 112));
            LazyLayoutBeyondBoundsInfo beyondBoundsInfo22 = lazyListState.getBeyondBoundsInfo();
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection32 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume32 = startRestartGroup.consume(localLayoutDirection32);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            z4 = z;
            Modifier overscroll22 = OverscrollKt.overscroll(LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(clipScrollableContainer22, rememberLazyListBeyondBoundsState22, beyondBoundsInfo22, z4, (LayoutDirection) consume32, orientation22, z3, startRestartGroup, i2022 | (MutableVector.$stable << 6) | (i2422 & 3670016)), overscrollEffect22);
            ScrollableDefaults scrollableDefaults22 = ScrollableDefaults.INSTANCE;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection222 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume222 = startRestartGroup.consume(localLayoutDirection222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            i17 = i2522;
            LazyLayoutKt.LazyLayout(rememberLazyListItemProviderLambda22, ScrollableKt.scrollable$default(overscroll22, lazyListState, orientation22, overscrollEffect22, z3, scrollableDefaults22.reverseDirection((LayoutDirection) consume222, orientation22, z4), flingBehavior, lazyListState.getInternalInteractionSource(), null, 128, null), lazyListState.getPrefetchState(), rememberLazyListMeasurePolicy22, startRestartGroup, 0, 0);
            composer2 = startRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
            }
            horizontal3 = horizontal722;
            vertical3 = vertical822;
            horizontal4 = horizontal622;
            vertical4 = vertical722;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        paddingValues2 = paddingValues;
        if ((i4 & 8) == 0) {
        }
        if ((i4 & 16) == 0) {
        }
        if ((i4 & 32) == 0) {
        }
        if ((i4 & 64) != 0) {
        }
        i6 = i4 & 128;
        if (i6 != 0) {
        }
        i8 = i4 & 256;
        if (i8 != 0) {
        }
        i9 = i4 & 512;
        if (i9 != 0) {
        }
        i10 = i9;
        i11 = i4 & 1024;
        if (i11 == 0) {
        }
        i14 = i4 & 2048;
        if (i14 == 0) {
        }
        i16 = i13;
        if ((i4 & 4096) == 0) {
        }
        if ((1533916891 & i5) == 306783378) {
        }
        if (i6 == 0) {
        }
        if (i8 == 0) {
        }
        if (i10 == 0) {
        }
        if (i12 == 0) {
        }
        Arrangement.Horizontal horizontal6222 = i15 == 0 ? horizontal2 : null;
        if (ComposerKt.isTraceInProgress()) {
        }
        int i19222 = (i5 >> 3) & 14;
        Function0<LazyListItemProvider> rememberLazyListItemProviderLambda222 = LazyListItemProviderKt.rememberLazyListItemProviderLambda(lazyListState, function1, startRestartGroup, i19222 | ((i16 >> 3) & 112));
        LazyLayoutSemanticState rememberLazyListSemanticState222 = LazyListSemanticsKt.rememberLazyListSemanticState(lazyListState, z2, startRestartGroup, i19222 | ((i5 >> 9) & 112));
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
        lazyListState.setCoroutineScope$foundation_release(coroutineScope222);
        int i20222 = i5 & 7168;
        int i21222 = i5 >> 6;
        int i22222 = i16 << 21;
        int i23222 = (65520 & i5) | (i21222 & 458752) | (i21222 & 3670016) | (i22222 & 29360128) | (i22222 & 234881024) | (1879048192 & i5);
        Arrangement.Vertical vertical7222 = vertical5;
        Alignment.Vertical vertical8222 = vertical6;
        int i24222 = i5;
        Alignment.Horizontal horizontal7222 = horizontal5;
        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyListMeasurePolicy222 = rememberLazyListMeasurePolicy(rememberLazyListItemProviderLambda222, lazyListState, paddingValues2, z, z2, i18, horizontal7222, vertical8222, horizontal6222, vertical7222, startRestartGroup, i23222, 0);
        int i25222 = i18;
        OverscrollEffect overscrollEffect222 = ScrollableDefaults.INSTANCE.overscrollEffect(startRestartGroup, 6);
        Orientation orientation222 = !z2 ? Orientation.Vertical : Orientation.Horizontal;
        Modifier clipScrollableContainer222 = ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier.then(lazyListState.getRemeasurementModifier()).then(lazyListState.getAwaitLayoutModifier()), rememberLazyListItemProviderLambda222, rememberLazyListSemanticState222, orientation222, z3, z, startRestartGroup, (i21222 & 57344) | ((i24222 << 6) & 458752)), orientation222);
        LazyLayoutBeyondBoundsState rememberLazyListBeyondBoundsState222 = LazyListBeyondBoundsModifierKt.rememberLazyListBeyondBoundsState(lazyListState, i25222, startRestartGroup, i19222 | ((i24222 >> 18) & 112));
        LazyLayoutBeyondBoundsInfo beyondBoundsInfo222 = lazyListState.getBeyondBoundsInfo();
        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection322 = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume322 = startRestartGroup.consume(localLayoutDirection322);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        z4 = z;
        Modifier overscroll222 = OverscrollKt.overscroll(LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(clipScrollableContainer222, rememberLazyListBeyondBoundsState222, beyondBoundsInfo222, z4, (LayoutDirection) consume322, orientation222, z3, startRestartGroup, i20222 | (MutableVector.$stable << 6) | (i24222 & 3670016)), overscrollEffect222);
        ScrollableDefaults scrollableDefaults222 = ScrollableDefaults.INSTANCE;
        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2222 = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2222 = startRestartGroup.consume(localLayoutDirection2222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        i17 = i25222;
        LazyLayoutKt.LazyLayout(rememberLazyListItemProviderLambda222, ScrollableKt.scrollable$default(overscroll222, lazyListState, orientation222, overscrollEffect222, z3, scrollableDefaults222.reverseDirection((LayoutDirection) consume2222, orientation222, z4), flingBehavior, lazyListState.getInternalInteractionSource(), null, 128, null), lazyListState.getPrefetchState(), rememberLazyListMeasurePolicy222, startRestartGroup, 0, 0);
        composer2 = startRestartGroup;
        if (ComposerKt.isTraceInProgress()) {
        }
        horizontal3 = horizontal7222;
        vertical3 = vertical8222;
        horizontal4 = horizontal6222;
        vertical4 = vertical7222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    private static final Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyListMeasurePolicy(final Function0<? extends LazyListItemProvider> function0, final LazyListState lazyListState, final PaddingValues paddingValues, final boolean z, final boolean z2, final int i, Alignment.Horizontal horizontal, Alignment.Vertical vertical, Arrangement.Horizontal horizontal2, Arrangement.Vertical vertical2, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(183156450);
        ComposerKt.sourceInformation(composer, "C(rememberLazyListMeasurePolicy)P(5,7,1,6,4!2,8)167@7348L7990:LazyList.kt#428nma");
        Alignment.Horizontal horizontal3 = (i3 & 64) != 0 ? null : horizontal;
        Alignment.Vertical vertical3 = (i3 & 128) != 0 ? null : vertical;
        Arrangement.Horizontal horizontal4 = (i3 & 256) != 0 ? null : horizontal2;
        Arrangement.Vertical vertical4 = (i3 & 512) != 0 ? null : vertical2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(183156450, i2, -1, "androidx.compose.foundation.lazy.rememberLazyListMeasurePolicy (LazyList.kt:167)");
        }
        Object[] objArr = {lazyListState, paddingValues, Boolean.valueOf(z), Boolean.valueOf(z2), horizontal3, vertical3, horizontal4, vertical4};
        composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean z3 = false;
        for (int i4 = 0; i4 < 8; i4++) {
            z3 |= composer.changed(objArr[i4]);
        }
        Object rememberedValue = composer.rememberedValue();
        if (z3 || rememberedValue == Composer.INSTANCE.getEmpty()) {
            final Arrangement.Vertical vertical5 = vertical4;
            final Arrangement.Horizontal horizontal5 = horizontal4;
            final Alignment.Horizontal horizontal6 = horizontal3;
            final Alignment.Vertical vertical6 = vertical3;
            rememberedValue = (Function2) new Function2<LazyLayoutMeasureScope, Constraints, LazyListMeasureResult>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ LazyListMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                    return m984invoke0kLqBqw(lazyLayoutMeasureScope, constraints.getValue());
                }

                /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final LazyListMeasureResult m984invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
                    int i5;
                    int i6;
                    final int i7;
                    float spacing;
                    int m6345getMaxWidthimpl;
                    long IntOffset;
                    float scrollToBeConsumed;
                    boolean z4 = LazyListState.this.getHasLookaheadPassOccurred() || lazyLayoutMeasureScope.isLookingAhead();
                    CheckScrollableContainerConstraintsKt.m555checkScrollableContainerConstraintsK40F9xA(j, z2 ? Orientation.Vertical : Orientation.Horizontal);
                    if (z2) {
                        i5 = lazyLayoutMeasureScope.mo624roundToPx0680j_4(paddingValues.mo830calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                    } else {
                        i5 = lazyLayoutMeasureScope.mo624roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                    }
                    if (z2) {
                        i6 = lazyLayoutMeasureScope.mo624roundToPx0680j_4(paddingValues.mo831calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                    } else {
                        i6 = lazyLayoutMeasureScope.mo624roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                    }
                    int i8 = lazyLayoutMeasureScope.mo624roundToPx0680j_4(paddingValues.getTop());
                    int i9 = lazyLayoutMeasureScope.mo624roundToPx0680j_4(paddingValues.getBottom());
                    final int i10 = i8 + i9;
                    final int i11 = i5 + i6;
                    boolean z5 = z2;
                    int i12 = z5 ? i10 : i11;
                    if (z5 && !z) {
                        i7 = i8;
                    } else if (z5 && z) {
                        i7 = i9;
                    } else {
                        i7 = (z5 || z) ? i6 : i5;
                    }
                    final int i13 = i12 - i7;
                    final long m6361offsetNN6EwU = ConstraintsKt.m6361offsetNN6EwU(j, -i11, -i10);
                    LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
                    LazyListState.this.setDensity$foundation_release(lazyLayoutMeasureScope2);
                    final LazyListItemProvider invoke = function0.invoke();
                    invoke.getItemScope().setMaxSize(Constraints.m6345getMaxWidthimpl(m6361offsetNN6EwU), Constraints.m6344getMaxHeightimpl(m6361offsetNN6EwU));
                    if (z2) {
                        Arrangement.Vertical vertical7 = vertical5;
                        if (vertical7 == null) {
                            throw new IllegalArgumentException("null verticalArrangement when isVertical == true".toString());
                        }
                        spacing = vertical7.getSpacing();
                    } else {
                        Arrangement.Horizontal horizontal7 = horizontal5;
                        if (horizontal7 == null) {
                            throw new IllegalArgumentException("null horizontalAlignment when isVertical == false".toString());
                        }
                        spacing = horizontal7.getSpacing();
                    }
                    final int i14 = lazyLayoutMeasureScope.mo624roundToPx0680j_4(spacing);
                    final int itemCount = invoke.getItemCount();
                    if (z2) {
                        m6345getMaxWidthimpl = Constraints.m6344getMaxHeightimpl(j) - i10;
                    } else {
                        m6345getMaxWidthimpl = Constraints.m6345getMaxWidthimpl(j) - i11;
                    }
                    int i15 = m6345getMaxWidthimpl;
                    if (!z || i15 > 0) {
                        IntOffset = IntOffsetKt.IntOffset(i5, i8);
                    } else {
                        boolean z6 = z2;
                        if (!z6) {
                            i5 += i15;
                        }
                        if (z6) {
                            i8 += i15;
                        }
                        IntOffset = IntOffsetKt.IntOffset(i5, i8);
                    }
                    final boolean z7 = z2;
                    final Alignment.Horizontal horizontal8 = horizontal6;
                    final Alignment.Vertical vertical8 = vertical6;
                    final boolean z8 = z;
                    final LazyListState lazyListState2 = LazyListState.this;
                    final long j2 = IntOffset;
                    LazyListMeasuredItemProvider lazyListMeasuredItemProvider = new LazyListMeasuredItemProvider(m6361offsetNN6EwU, z7, invoke, lazyLayoutMeasureScope, itemCount, i14, horizontal8, vertical8, z8, i7, i13, j2, lazyListState2) { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1
                        final /* synthetic */ int $afterContentPadding;
                        final /* synthetic */ int $beforeContentPadding;
                        final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
                        final /* synthetic */ boolean $isVertical;
                        final /* synthetic */ int $itemsCount;
                        final /* synthetic */ boolean $reverseLayout;
                        final /* synthetic */ int $spaceBetweenItems;
                        final /* synthetic */ LazyListState $state;
                        final /* synthetic */ LazyLayoutMeasureScope $this_null;
                        final /* synthetic */ Alignment.Vertical $verticalAlignment;
                        final /* synthetic */ long $visualItemOffset;

                        {
                            this.$isVertical = z7;
                            this.$this_null = lazyLayoutMeasureScope;
                            this.$itemsCount = itemCount;
                            this.$spaceBetweenItems = i14;
                            this.$horizontalAlignment = horizontal8;
                            this.$verticalAlignment = vertical8;
                            this.$reverseLayout = z8;
                            this.$beforeContentPadding = i7;
                            this.$afterContentPadding = i13;
                            this.$visualItemOffset = j2;
                            this.$state = lazyListState2;
                        }

                        @Override // androidx.compose.foundation.lazy.LazyListMeasuredItemProvider
                        public LazyListMeasuredItem createItem(int index, Object key, Object contentType, List<? extends Placeable> placeables) {
                            return new LazyListMeasuredItem(index, placeables, this.$isVertical, this.$horizontalAlignment, this.$verticalAlignment, this.$this_null.getLayoutDirection(), this.$reverseLayout, this.$beforeContentPadding, this.$afterContentPadding, index == this.$itemsCount + (-1) ? 0 : this.$spaceBetweenItems, this.$visualItemOffset, key, contentType, this.$state.getItemAnimator(), null);
                        }
                    };
                    LazyListState.this.m995setPremeasureConstraintsBRTryo0$foundation_release(lazyListMeasuredItemProvider.getChildConstraints());
                    Snapshot.Companion companion = Snapshot.INSTANCE;
                    LazyListState lazyListState3 = LazyListState.this;
                    Snapshot createNonObservableSnapshot = companion.createNonObservableSnapshot();
                    try {
                        Snapshot makeCurrent = createNonObservableSnapshot.makeCurrent();
                        try {
                            int updateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyListState3.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(invoke, lazyListState3.getFirstVisibleItemIndex());
                            int firstVisibleItemScrollOffset = lazyListState3.getFirstVisibleItemScrollOffset();
                            Unit unit = Unit.INSTANCE;
                            createNonObservableSnapshot.dispose();
                            List<Integer> calculateLazyLayoutPinnedIndices = LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(invoke, LazyListState.this.getPinnedItems(), LazyListState.this.getBeyondBoundsInfo());
                            if (lazyLayoutMeasureScope.isLookingAhead() || !z4) {
                                scrollToBeConsumed = LazyListState.this.getScrollToBeConsumed();
                            } else {
                                scrollToBeConsumed = LazyListState.this.getScrollDeltaBetweenPasses$foundation_release();
                            }
                            float f = scrollToBeConsumed;
                            LazyListMeasuredItemProvider lazyListMeasuredItemProvider2 = lazyListMeasuredItemProvider;
                            int i16 = i7;
                            boolean z9 = z2;
                            List<Integer> headerIndexes = invoke.getHeaderIndexes();
                            Arrangement.Vertical vertical9 = vertical5;
                            Arrangement.Horizontal horizontal9 = horizontal5;
                            boolean z10 = z;
                            LazyListItemAnimator itemAnimator = LazyListState.this.getItemAnimator();
                            int i17 = i;
                            boolean isLookingAhead = lazyLayoutMeasureScope.isLookingAhead();
                            LazyListMeasureResult postLookaheadLayoutInfo = LazyListState.this.getPostLookaheadLayoutInfo();
                            CoroutineScope coroutineScope = LazyListState.this.getCoroutineScope();
                            if (coroutineScope != null) {
                                LazyListMeasureResult m988measureLazyList5IMabDg = LazyListMeasureKt.m988measureLazyList5IMabDg(itemCount, lazyListMeasuredItemProvider2, i15, i16, i13, i14, updateScrollPositionIfTheFirstItemWasMoved$foundation_release, firstVisibleItemScrollOffset, f, m6361offsetNN6EwU, z9, headerIndexes, vertical9, horizontal9, z10, lazyLayoutMeasureScope2, itemAnimator, i17, calculateLazyLayoutPinnedIndices, z4, isLookingAhead, postLookaheadLayoutInfo, coroutineScope, LazyListState.this.m993getPlacementScopeInvalidatorzYiylxw$foundation_release(), new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                                        return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                                    }

                                    public final MeasureResult invoke(int i18, int i19, Function1<? super Placeable.PlacementScope, Unit> function1) {
                                        return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m6359constrainWidthK40F9xA(j, i18 + i11), ConstraintsKt.m6358constrainHeightK40F9xA(j, i19 + i10), MapsKt.emptyMap(), function1);
                                    }
                                });
                                LazyListState.applyMeasureResult$foundation_release$default(LazyListState.this, m988measureLazyList5IMabDg, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
                                return m988measureLazyList5IMabDg;
                            }
                            throw new IllegalArgumentException("coroutineScope should be not null".toString());
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
