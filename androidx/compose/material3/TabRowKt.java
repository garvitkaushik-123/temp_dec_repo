package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TabRow.kt */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\u001a¤\u0001\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00012.\b\u0002\u0010\u0012\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u00192\u0013\b\u0002\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u0080\u0001\u0010\u001f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u0019¢\u0006\u0002\b!2\u0013\b\u0002\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a\u009a\u0001\u0010$\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00012.\b\u0002\u0010\u0012\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u00192\u0013\b\u0002\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a \u0001\u0010'\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2,\u0010\u0012\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u00192\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00012\u0013\b\u0002\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0006\u0010\f\u001a\u00020\rH\u0003ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a¤\u0001\u0010*\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00012.\b\u0002\u0010\u0012\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u00192\u0013\b\u0002\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010\u001e\u001a\u0080\u0001\u0010,\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u0019¢\u0006\u0002\b!2\u0013\b\u0002\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b-\u0010#\u001a\u0090\u0001\u0010.\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2.\b\u0002\u0010\u0012\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u00192\u0013\b\u0002\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b/\u0010#\u001an\u00100\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u0019¢\u0006\u0002\b!2\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u0019H\u0003ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001a~\u00103\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2,\u0010\u0012\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u00192\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u0019H\u0003ø\u0001\u0000¢\u0006\u0004\b4\u00102\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00065"}, d2 = {"ScrollableTabRowMinimumTabWidth", "Landroidx/compose/ui/unit/Dp;", "F", "ScrollableTabRowScrollSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "PrimaryScrollableTabRow", "", "selectedTabIndex", "", "modifier", "Landroidx/compose/ui/Modifier;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "edgePadding", "indicator", "Lkotlin/Function1;", "", "Landroidx/compose/material3/TabPosition;", "Lkotlin/ParameterName;", "name", "tabPositions", "Landroidx/compose/runtime/Composable;", "divider", "Lkotlin/Function0;", "tabs", "PrimaryScrollableTabRow-qhFBPw4", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "PrimaryTabRow", "Landroidx/compose/material3/TabIndicatorScope;", "Lkotlin/ExtensionFunctionType;", "PrimaryTabRow-pAZo6Ak", "(ILandroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ScrollableTabRow", "ScrollableTabRow-sKfQg0A", "(ILandroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ScrollableTabRowImp", "ScrollableTabRowImp-qhFBPw4", "(ILkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;II)V", "SecondaryScrollableTabRow", "SecondaryScrollableTabRow-qhFBPw4", "SecondaryTabRow", "SecondaryTabRow-pAZo6Ak", "TabRow", "TabRow-pAZo6Ak", "TabRowImpl", "TabRowImpl-DTcfvLk", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TabRowWithSubcomposeImpl", "TabRowWithSubcomposeImpl-DTcfvLk", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TabRowKt {
    private static final float ScrollableTabRowMinimumTabWidth = Dp.m6389constructorimpl(90);
    private static final AnimationSpec<Float> ScrollableTabRowScrollSpec = AnimationSpecKt.tween$default(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 0, EasingKt.getFastOutSlowInEasing(), 2, null);

    /* JADX WARN: Removed duplicated region for block: B:100:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0082  */
    /* renamed from: PrimaryTabRow-pAZo6Ak, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2683PrimaryTabRowpAZo6Ak(final int i, Modifier modifier, long j, long j2, Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        long j3;
        long j4;
        int i5;
        Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function32;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function23;
        Function2<? super Composer, ? super Integer, Unit> m2092getLambda1$material3_release;
        Modifier modifier3;
        long j5;
        Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function33;
        int i7;
        long j6;
        Composer composer2;
        final Modifier modifier4;
        final long j7;
        final long j8;
        final Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function34;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        ScopeUpdateScope endRestartGroup;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(-1884787284);
        ComposerKt.sourceInformation(startRestartGroup, "C(PrimaryTabRow)P(5,4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)150@7456L21,151@7520L19,166@7964L76:TabRow.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i10 = i3 & 2;
        if (i10 != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            modifier2 = modifier;
            i4 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i2 & 384) != 0) {
                if ((i3 & 4) == 0) {
                    j3 = j;
                    if (startRestartGroup.changed(j3)) {
                        i9 = 256;
                        i4 |= i9;
                    }
                } else {
                    j3 = j;
                }
                i9 = 128;
                i4 |= i9;
            } else {
                j3 = j;
            }
            if ((i2 & 3072) != 0) {
                if ((i3 & 8) == 0) {
                    j4 = j2;
                    if (startRestartGroup.changed(j4)) {
                        i8 = 2048;
                        i4 |= i8;
                    }
                } else {
                    j4 = j2;
                }
                i8 = 1024;
                i4 |= i8;
            } else {
                j4 = j2;
            }
            i5 = i3 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else if ((i2 & 24576) == 0) {
                function32 = function3;
                i4 |= startRestartGroup.changedInstance(function32) ? 16384 : 8192;
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i2) == 0) {
                    function23 = function2;
                    i4 |= startRestartGroup.changedInstance(function23) ? 131072 : 65536;
                    if ((i3 & 64) == 0) {
                        i4 |= 1572864;
                    } else if ((i2 & 1572864) == 0) {
                        i4 |= startRestartGroup.changedInstance(function22) ? 1048576 : 524288;
                        if ((i4 & 599187) == 599186 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                if (i10 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if ((i3 & 4) != 0) {
                                    j3 = TabRowDefaults.INSTANCE.getPrimaryContainerColor(startRestartGroup, 6);
                                    i4 &= -897;
                                }
                                if ((i3 & 8) != 0) {
                                    j4 = TabRowDefaults.INSTANCE.getPrimaryContentColor(startRestartGroup, 6);
                                    i4 &= -7169;
                                }
                                if (i5 != 0) {
                                    function32 = ComposableLambdaKt.composableLambda(startRestartGroup, -2021049253, true, new Function3<TabIndicatorScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$PrimaryTabRow$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(TabIndicatorScope tabIndicatorScope, Composer composer3, Integer num) {
                                            invoke(tabIndicatorScope, composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(TabIndicatorScope tabIndicatorScope, Composer composer3, int i11) {
                                            int i12;
                                            ComposerKt.sourceInformation(composer3, "C153@7624L204:TabRow.kt#uh7d8r");
                                            if ((i11 & 6) == 0) {
                                                i12 = ((i11 & 8) == 0 ? composer3.changed(tabIndicatorScope) : composer3.changedInstance(tabIndicatorScope) ? 4 : 2) | i11;
                                            } else {
                                                i12 = i11;
                                            }
                                            if ((i12 & 19) != 18 || !composer3.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-2021049253, i12, -1, "androidx.compose.material3.PrimaryTabRow.<anonymous> (TabRow.kt:153)");
                                                }
                                                TabRowDefaults.INSTANCE.m2679PrimaryIndicator10LGxhE(tabIndicatorScope.tabIndicatorOffset(Modifier.INSTANCE, i, true), Dp.INSTANCE.m6409getUnspecifiedD9Ej5fM(), 0.0f, 0L, null, composer3, 196656, 28);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    });
                                }
                                if (i6 != 0) {
                                    m2092getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m2092getLambda1$material3_release();
                                    modifier3 = modifier2;
                                    j5 = j4;
                                    function33 = function32;
                                    i7 = -1884787284;
                                    j6 = j3;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(i7, i4, -1, "androidx.compose.material3.PrimaryTabRow (TabRow.kt:165)");
                                    }
                                    composer2 = startRestartGroup;
                                    m2689TabRowImplDTcfvLk(modifier3, j6, j5, function33, m2092getLambda1$material3_release, function22, composer2, (i4 >> 3) & 524286);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier4 = modifier3;
                                    j7 = j6;
                                    j8 = j5;
                                    function34 = function33;
                                    function24 = m2092getLambda1$material3_release;
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
                            modifier3 = modifier2;
                            function33 = function32;
                            m2092getLambda1$material3_release = function23;
                            i7 = -1884787284;
                            j6 = j3;
                            j5 = j4;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composer2 = startRestartGroup;
                            m2689TabRowImplDTcfvLk(modifier3, j6, j5, function33, m2092getLambda1$material3_release, function22, composer2, (i4 >> 3) & 524286);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier4 = modifier3;
                            j7 = j6;
                            j8 = j5;
                            function34 = function33;
                            function24 = m2092getLambda1$material3_release;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            composer2 = startRestartGroup;
                            modifier4 = modifier2;
                            j7 = j3;
                            j8 = j4;
                            function34 = function32;
                            function24 = function23;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$PrimaryTabRow$2
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
                                    TabRowKt.m2683PrimaryTabRowpAZo6Ak(i, modifier4, j7, j8, function34, function24, function22, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i4 & 599187) == 599186) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if ((i3 & 4) != 0) {
                    }
                    if ((i3 & 8) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    modifier3 = modifier2;
                    function33 = function32;
                    m2092getLambda1$material3_release = function23;
                    i7 = -1884787284;
                    j6 = j3;
                    j5 = j4;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2 = startRestartGroup;
                    m2689TabRowImplDTcfvLk(modifier3, j6, j5, function33, m2092getLambda1$material3_release, function22, composer2, (i4 >> 3) & 524286);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier4 = modifier3;
                    j7 = j6;
                    j8 = j5;
                    function34 = function33;
                    function24 = m2092getLambda1$material3_release;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function23 = function2;
                if ((i3 & 64) == 0) {
                }
                if ((i4 & 599187) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i10 != 0) {
                }
                if ((i3 & 4) != 0) {
                }
                if ((i3 & 8) != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                modifier3 = modifier2;
                function33 = function32;
                m2092getLambda1$material3_release = function23;
                i7 = -1884787284;
                j6 = j3;
                j5 = j4;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                m2689TabRowImplDTcfvLk(modifier3, j6, j5, function33, m2092getLambda1$material3_release, function22, composer2, (i4 >> 3) & 524286);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier4 = modifier3;
                j7 = j6;
                j8 = j5;
                function34 = function33;
                function24 = m2092getLambda1$material3_release;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function32 = function3;
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            function23 = function2;
            if ((i3 & 64) == 0) {
            }
            if ((i4 & 599187) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i10 != 0) {
            }
            if ((i3 & 4) != 0) {
            }
            if ((i3 & 8) != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            modifier3 = modifier2;
            function33 = function32;
            m2092getLambda1$material3_release = function23;
            i7 = -1884787284;
            j6 = j3;
            j5 = j4;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            m2689TabRowImplDTcfvLk(modifier3, j6, j5, function33, m2092getLambda1$material3_release, function22, composer2, (i4 >> 3) & 524286);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier4 = modifier3;
            j7 = j6;
            j8 = j5;
            function34 = function33;
            function24 = m2092getLambda1$material3_release;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i2 & 384) != 0) {
        }
        if ((i2 & 3072) != 0) {
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
        if ((i4 & 599187) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i10 != 0) {
        }
        if ((i3 & 4) != 0) {
        }
        if ((i3 & 8) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        modifier3 = modifier2;
        function33 = function32;
        m2092getLambda1$material3_release = function23;
        i7 = -1884787284;
        j6 = j3;
        j5 = j4;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        m2689TabRowImplDTcfvLk(modifier3, j6, j5, function33, m2092getLambda1$material3_release, function22, composer2, (i4 >> 3) & 524286);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        j7 = j6;
        j8 = j5;
        function34 = function33;
        function24 = m2092getLambda1$material3_release;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0082  */
    /* renamed from: SecondaryTabRow-pAZo6Ak, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2687SecondaryTabRowpAZo6Ak(final int i, Modifier modifier, long j, long j2, Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        long j3;
        long j4;
        int i5;
        Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function32;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function23;
        Function2<? super Composer, ? super Integer, Unit> m2093getLambda2$material3_release;
        Modifier modifier3;
        long j5;
        Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function33;
        int i7;
        long j6;
        Composer composer2;
        final Modifier modifier4;
        final long j7;
        final long j8;
        final Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function34;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        ScopeUpdateScope endRestartGroup;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(-1909540706);
        ComposerKt.sourceInformation(startRestartGroup, "C(SecondaryTabRow)P(5,4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)207@10434L23,208@10500L21,219@10867L76:TabRow.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i10 = i3 & 2;
        if (i10 != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            modifier2 = modifier;
            i4 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i2 & 384) != 0) {
                if ((i3 & 4) == 0) {
                    j3 = j;
                    if (startRestartGroup.changed(j3)) {
                        i9 = 256;
                        i4 |= i9;
                    }
                } else {
                    j3 = j;
                }
                i9 = 128;
                i4 |= i9;
            } else {
                j3 = j;
            }
            if ((i2 & 3072) != 0) {
                if ((i3 & 8) == 0) {
                    j4 = j2;
                    if (startRestartGroup.changed(j4)) {
                        i8 = 2048;
                        i4 |= i8;
                    }
                } else {
                    j4 = j2;
                }
                i8 = 1024;
                i4 |= i8;
            } else {
                j4 = j2;
            }
            i5 = i3 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else if ((i2 & 24576) == 0) {
                function32 = function3;
                i4 |= startRestartGroup.changedInstance(function32) ? 16384 : 8192;
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i2) == 0) {
                    function23 = function2;
                    i4 |= startRestartGroup.changedInstance(function23) ? 131072 : 65536;
                    if ((i3 & 64) == 0) {
                        i4 |= 1572864;
                    } else if ((i2 & 1572864) == 0) {
                        i4 |= startRestartGroup.changedInstance(function22) ? 1048576 : 524288;
                        if ((i4 & 599187) == 599186 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                if (i10 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if ((i3 & 4) != 0) {
                                    j3 = TabRowDefaults.INSTANCE.getSecondaryContainerColor(startRestartGroup, 6);
                                    i4 &= -897;
                                }
                                if ((i3 & 8) != 0) {
                                    j4 = TabRowDefaults.INSTANCE.getSecondaryContentColor(startRestartGroup, 6);
                                    i4 &= -7169;
                                }
                                if (i5 != 0) {
                                    function32 = ComposableLambdaKt.composableLambda(startRestartGroup, 286693261, true, new Function3<TabIndicatorScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$SecondaryTabRow$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(TabIndicatorScope tabIndicatorScope, Composer composer3, Integer num) {
                                            invoke(tabIndicatorScope, composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(TabIndicatorScope tabIndicatorScope, Composer composer3, int i11) {
                                            ComposerKt.sourceInformation(composer3, "C210@10618L113:TabRow.kt#uh7d8r");
                                            if ((i11 & 6) == 0) {
                                                i11 |= (i11 & 8) == 0 ? composer3.changed(tabIndicatorScope) : composer3.changedInstance(tabIndicatorScope) ? 4 : 2;
                                            }
                                            if ((i11 & 19) != 18 || !composer3.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(286693261, i11, -1, "androidx.compose.material3.SecondaryTabRow.<anonymous> (TabRow.kt:210)");
                                                }
                                                TabRowDefaults.INSTANCE.m2680SecondaryIndicator9IZ8Weo(tabIndicatorScope.tabIndicatorOffset(Modifier.INSTANCE, i, false), 0.0f, 0L, composer3, 3072, 6);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    });
                                }
                                if (i6 != 0) {
                                    m2093getLambda2$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m2093getLambda2$material3_release();
                                    modifier3 = modifier2;
                                    j5 = j4;
                                    function33 = function32;
                                    i7 = -1909540706;
                                    j6 = j3;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(i7, i4, -1, "androidx.compose.material3.SecondaryTabRow (TabRow.kt:218)");
                                    }
                                    composer2 = startRestartGroup;
                                    m2689TabRowImplDTcfvLk(modifier3, j6, j5, function33, m2093getLambda2$material3_release, function22, composer2, (i4 >> 3) & 524286);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier4 = modifier3;
                                    j7 = j6;
                                    j8 = j5;
                                    function34 = function33;
                                    function24 = m2093getLambda2$material3_release;
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
                            modifier3 = modifier2;
                            function33 = function32;
                            m2093getLambda2$material3_release = function23;
                            i7 = -1909540706;
                            j6 = j3;
                            j5 = j4;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composer2 = startRestartGroup;
                            m2689TabRowImplDTcfvLk(modifier3, j6, j5, function33, m2093getLambda2$material3_release, function22, composer2, (i4 >> 3) & 524286);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier4 = modifier3;
                            j7 = j6;
                            j8 = j5;
                            function34 = function33;
                            function24 = m2093getLambda2$material3_release;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            composer2 = startRestartGroup;
                            modifier4 = modifier2;
                            j7 = j3;
                            j8 = j4;
                            function34 = function32;
                            function24 = function23;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$SecondaryTabRow$2
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
                                    TabRowKt.m2687SecondaryTabRowpAZo6Ak(i, modifier4, j7, j8, function34, function24, function22, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i4 & 599187) == 599186) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if ((i3 & 4) != 0) {
                    }
                    if ((i3 & 8) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    modifier3 = modifier2;
                    function33 = function32;
                    m2093getLambda2$material3_release = function23;
                    i7 = -1909540706;
                    j6 = j3;
                    j5 = j4;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2 = startRestartGroup;
                    m2689TabRowImplDTcfvLk(modifier3, j6, j5, function33, m2093getLambda2$material3_release, function22, composer2, (i4 >> 3) & 524286);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier4 = modifier3;
                    j7 = j6;
                    j8 = j5;
                    function34 = function33;
                    function24 = m2093getLambda2$material3_release;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function23 = function2;
                if ((i3 & 64) == 0) {
                }
                if ((i4 & 599187) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i10 != 0) {
                }
                if ((i3 & 4) != 0) {
                }
                if ((i3 & 8) != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                modifier3 = modifier2;
                function33 = function32;
                m2093getLambda2$material3_release = function23;
                i7 = -1909540706;
                j6 = j3;
                j5 = j4;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                m2689TabRowImplDTcfvLk(modifier3, j6, j5, function33, m2093getLambda2$material3_release, function22, composer2, (i4 >> 3) & 524286);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier4 = modifier3;
                j7 = j6;
                j8 = j5;
                function34 = function33;
                function24 = m2093getLambda2$material3_release;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function32 = function3;
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            function23 = function2;
            if ((i3 & 64) == 0) {
            }
            if ((i4 & 599187) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i10 != 0) {
            }
            if ((i3 & 4) != 0) {
            }
            if ((i3 & 8) != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            modifier3 = modifier2;
            function33 = function32;
            m2093getLambda2$material3_release = function23;
            i7 = -1909540706;
            j6 = j3;
            j5 = j4;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            m2689TabRowImplDTcfvLk(modifier3, j6, j5, function33, m2093getLambda2$material3_release, function22, composer2, (i4 >> 3) & 524286);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier4 = modifier3;
            j7 = j6;
            j8 = j5;
            function34 = function33;
            function24 = m2093getLambda2$material3_release;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i2 & 384) != 0) {
        }
        if ((i2 & 3072) != 0) {
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
        if ((i4 & 599187) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i10 != 0) {
        }
        if ((i3 & 4) != 0) {
        }
        if ((i3 & 8) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        modifier3 = modifier2;
        function33 = function32;
        m2093getLambda2$material3_release = function23;
        i7 = -1909540706;
        j6 = j3;
        j5 = j4;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        m2689TabRowImplDTcfvLk(modifier3, j6, j5, function33, m2093getLambda2$material3_release, function22, composer2, (i4 >> 3) & 524286);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        j7 = j6;
        j8 = j5;
        function34 = function33;
        function24 = m2093getLambda2$material3_release;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0082  */
    /* renamed from: TabRow-pAZo6Ak, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2688TabRowpAZo6Ak(final int i, Modifier modifier, long j, long j2, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        long j3;
        long j4;
        int i5;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function32;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function23;
        Function2<? super Composer, ? super Integer, Unit> m2094getLambda3$material3_release;
        Modifier modifier3;
        long j5;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function33;
        int i7;
        long j6;
        Composer composer2;
        final Modifier modifier4;
        final long j7;
        final long j8;
        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function34;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        ScopeUpdateScope endRestartGroup;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(-1199178586);
        ComposerKt.sourceInformation(startRestartGroup, "C(TabRow)P(5,4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)299@15165L21,300@15229L19,313@15685L90:TabRow.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i10 = i3 & 2;
        if (i10 != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            modifier2 = modifier;
            i4 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i2 & 384) != 0) {
                if ((i3 & 4) == 0) {
                    j3 = j;
                    if (startRestartGroup.changed(j3)) {
                        i9 = 256;
                        i4 |= i9;
                    }
                } else {
                    j3 = j;
                }
                i9 = 128;
                i4 |= i9;
            } else {
                j3 = j;
            }
            if ((i2 & 3072) != 0) {
                if ((i3 & 8) == 0) {
                    j4 = j2;
                    if (startRestartGroup.changed(j4)) {
                        i8 = 2048;
                        i4 |= i8;
                    }
                } else {
                    j4 = j2;
                }
                i8 = 1024;
                i4 |= i8;
            } else {
                j4 = j2;
            }
            i5 = i3 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else if ((i2 & 24576) == 0) {
                function32 = function3;
                i4 |= startRestartGroup.changedInstance(function32) ? 16384 : 8192;
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i2) == 0) {
                    function23 = function2;
                    i4 |= startRestartGroup.changedInstance(function23) ? 131072 : 65536;
                    if ((i3 & 64) == 0) {
                        i4 |= 1572864;
                    } else if ((i2 & 1572864) == 0) {
                        i4 |= startRestartGroup.changedInstance(function22) ? 1048576 : 524288;
                        if ((i4 & 599187) == 599186 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                if (i10 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if ((i3 & 4) != 0) {
                                    j3 = TabRowDefaults.INSTANCE.getPrimaryContainerColor(startRestartGroup, 6);
                                    i4 &= -897;
                                }
                                if ((i3 & 8) != 0) {
                                    j4 = TabRowDefaults.INSTANCE.getPrimaryContentColor(startRestartGroup, 6);
                                    i4 &= -7169;
                                }
                                if (i5 != 0) {
                                    function32 = ComposableLambdaKt.composableLambda(startRestartGroup, -2052073983, true, new Function3<List<? extends TabPosition>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRow$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(List<? extends TabPosition> list, Composer composer3, Integer num) {
                                            invoke((List<TabPosition>) list, composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(List<TabPosition> list, Composer composer3, int i11) {
                                            ComposerKt.sourceInformation(composer3, "C303@15430L109:TabRow.kt#uh7d8r");
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-2052073983, i11, -1, "androidx.compose.material3.TabRow.<anonymous> (TabRow.kt:302)");
                                            }
                                            if (i < list.size()) {
                                                TabRowDefaults.INSTANCE.m2680SecondaryIndicator9IZ8Weo(TabRowDefaults.INSTANCE.tabIndicatorOffset(Modifier.INSTANCE, list.get(i)), 0.0f, 0L, composer3, 3072, 6);
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    });
                                }
                                if (i6 != 0) {
                                    m2094getLambda3$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m2094getLambda3$material3_release();
                                    modifier3 = modifier2;
                                    j5 = j4;
                                    function33 = function32;
                                    i7 = -1199178586;
                                    j6 = j3;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(i7, i4, -1, "androidx.compose.material3.TabRow (TabRow.kt:312)");
                                    }
                                    composer2 = startRestartGroup;
                                    m2690TabRowWithSubcomposeImplDTcfvLk(modifier3, j6, j5, function33, m2094getLambda3$material3_release, function22, composer2, (i4 >> 3) & 524286);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier4 = modifier3;
                                    j7 = j6;
                                    j8 = j5;
                                    function34 = function33;
                                    function24 = m2094getLambda3$material3_release;
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
                            modifier3 = modifier2;
                            function33 = function32;
                            m2094getLambda3$material3_release = function23;
                            i7 = -1199178586;
                            j6 = j3;
                            j5 = j4;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composer2 = startRestartGroup;
                            m2690TabRowWithSubcomposeImplDTcfvLk(modifier3, j6, j5, function33, m2094getLambda3$material3_release, function22, composer2, (i4 >> 3) & 524286);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier4 = modifier3;
                            j7 = j6;
                            j8 = j5;
                            function34 = function33;
                            function24 = m2094getLambda3$material3_release;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            composer2 = startRestartGroup;
                            modifier4 = modifier2;
                            j7 = j3;
                            j8 = j4;
                            function34 = function32;
                            function24 = function23;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRow$2
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
                                    TabRowKt.m2688TabRowpAZo6Ak(i, modifier4, j7, j8, function34, function24, function22, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i4 & 599187) == 599186) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if ((i3 & 4) != 0) {
                    }
                    if ((i3 & 8) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    modifier3 = modifier2;
                    function33 = function32;
                    m2094getLambda3$material3_release = function23;
                    i7 = -1199178586;
                    j6 = j3;
                    j5 = j4;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2 = startRestartGroup;
                    m2690TabRowWithSubcomposeImplDTcfvLk(modifier3, j6, j5, function33, m2094getLambda3$material3_release, function22, composer2, (i4 >> 3) & 524286);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier4 = modifier3;
                    j7 = j6;
                    j8 = j5;
                    function34 = function33;
                    function24 = m2094getLambda3$material3_release;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function23 = function2;
                if ((i3 & 64) == 0) {
                }
                if ((i4 & 599187) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i10 != 0) {
                }
                if ((i3 & 4) != 0) {
                }
                if ((i3 & 8) != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                modifier3 = modifier2;
                function33 = function32;
                m2094getLambda3$material3_release = function23;
                i7 = -1199178586;
                j6 = j3;
                j5 = j4;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                m2690TabRowWithSubcomposeImplDTcfvLk(modifier3, j6, j5, function33, m2094getLambda3$material3_release, function22, composer2, (i4 >> 3) & 524286);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier4 = modifier3;
                j7 = j6;
                j8 = j5;
                function34 = function33;
                function24 = m2094getLambda3$material3_release;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function32 = function3;
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            function23 = function2;
            if ((i3 & 64) == 0) {
            }
            if ((i4 & 599187) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i10 != 0) {
            }
            if ((i3 & 4) != 0) {
            }
            if ((i3 & 8) != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            modifier3 = modifier2;
            function33 = function32;
            m2094getLambda3$material3_release = function23;
            i7 = -1199178586;
            j6 = j3;
            j5 = j4;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            m2690TabRowWithSubcomposeImplDTcfvLk(modifier3, j6, j5, function33, m2094getLambda3$material3_release, function22, composer2, (i4 >> 3) & 524286);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier4 = modifier3;
            j7 = j6;
            j8 = j5;
            function34 = function33;
            function24 = m2094getLambda3$material3_release;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i2 & 384) != 0) {
        }
        if ((i2 & 3072) != 0) {
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
        if ((i4 & 599187) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i10 != 0) {
        }
        if ((i3 & 4) != 0) {
        }
        if ((i3 & 8) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        modifier3 = modifier2;
        function33 = function32;
        m2094getLambda3$material3_release = function23;
        i7 = -1199178586;
        j6 = j3;
        j5 = j4;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        m2690TabRowWithSubcomposeImplDTcfvLk(modifier3, j6, j5, function33, m2094getLambda3$material3_release, function22, composer2, (i4 >> 3) & 524286);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        j7 = j6;
        j8 = j5;
        function34 = function33;
        function24 = m2094getLambda3$material3_release;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: TabRowImpl-DTcfvLk, reason: not valid java name */
    public static final void m2689TabRowImplDTcfvLk(Modifier modifier, final long j, final long j2, final Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i) {
        Modifier modifier2;
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1757425411);
        ComposerKt.sourceInformation(startRestartGroup, "C(TabRowImpl)P(4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)366@17359L4073:TabRow.kt#uh7d8r");
        if ((i & 6) == 0) {
            modifier2 = modifier;
            i2 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(j2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 131072 : 65536;
        }
        if ((74899 & i2) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1757425411, i2, -1, "androidx.compose.material3.TabRowImpl (TabRow.kt:365)");
            }
            int i3 = i2 << 3;
            composer2 = startRestartGroup;
            SurfaceKt.m2633SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, j, j2, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, -65106680, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$1
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

                public final void invoke(Composer composer3, int i4) {
                    ComposerKt.sourceInformation(composer3, "C371@17511L1344,416@19062L2364,409@18865L2561:TabRow.kt#uh7d8r");
                    if ((i4 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-65106680, i4, -1, "androidx.compose.material3.TabRowImpl.<anonymous> (TabRow.kt:371)");
                        }
                        composer3.startReplaceableGroup(474062752);
                        ComposerKt.sourceInformation(composer3, "CC(remember):TabRow.kt#9igjgp");
                        Object rememberedValue = composer3.rememberedValue();
                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = new TabRowKt$TabRowImpl$1$scope$1$1();
                            composer3.updateRememberedValue(rememberedValue);
                        }
                        final TabRowKt$TabRowImpl$1$scope$1$1 tabRowKt$TabRowImpl$1$scope$1$1 = (TabRowKt$TabRowImpl$1$scope$1$1) rememberedValue;
                        composer3.endReplaceableGroup();
                        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        final Function3<TabIndicatorScope, Composer, Integer, Unit> function32 = function3;
                        List listOf = CollectionsKt.listOf((Object[]) new Function2[]{function22, function2, ComposableLambdaKt.composableLambda(composer3, 1236693605, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$1.1
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

                            public final void invoke(Composer composer4, int i5) {
                                ComposerKt.sourceInformation(composer4, "C414@19023L11:TabRow.kt#uh7d8r");
                                if ((i5 & 3) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1236693605, i5, -1, "androidx.compose.material3.TabRowImpl.<anonymous>.<anonymous> (TabRow.kt:414)");
                                }
                                function32.invoke(tabRowKt$TabRowImpl$1$scope$1$1, composer4, 6);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        })});
                        composer3.startReplaceableGroup(474064303);
                        ComposerKt.sourceInformation(composer3, "CC(remember):TabRow.kt#9igjgp");
                        Object rememberedValue2 = composer3.rememberedValue();
                        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = (MultiContentMeasurePolicy) new MultiContentMeasurePolicy() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$1$2$1
                                @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
                                /* renamed from: measure-3p2s80s */
                                public final MeasureResult mo2302measure3p2s80s(MeasureScope measureScope, List<? extends List<? extends Measurable>> list, long j3) {
                                    MeasureScope measureScope2 = measureScope;
                                    List<? extends Measurable> list2 = list.get(0);
                                    List<? extends Measurable> list3 = list.get(1);
                                    int i5 = 2;
                                    List<? extends Measurable> list4 = list.get(2);
                                    int m6345getMaxWidthimpl = Constraints.m6345getMaxWidthimpl(j3);
                                    int size = list2.size();
                                    final Ref.IntRef intRef = new Ref.IntRef();
                                    if (size > 0) {
                                        intRef.element = m6345getMaxWidthimpl / size;
                                    }
                                    int i6 = 0;
                                    int size2 = list2.size();
                                    for (int i7 = 0; i7 < size2; i7++) {
                                        i6 = Integer.valueOf(Math.max(list2.get(i7).maxIntrinsicHeight(intRef.element), i6.intValue()));
                                    }
                                    final int intValue = i6.intValue();
                                    TabRowKt$TabRowImpl$1$scope$1$1 tabRowKt$TabRowImpl$1$scope$1$12 = TabRowKt$TabRowImpl$1$scope$1$1.this;
                                    ArrayList arrayList = new ArrayList(size);
                                    int i8 = 0;
                                    while (i8 < size) {
                                        arrayList.add(new TabPosition(Dp.m6389constructorimpl(measureScope2.mo627toDpu2uoSUM(intRef.element) * i8), measureScope2.mo627toDpu2uoSUM(intRef.element), ((Dp) ComparisonsKt.maxOf(Dp.m6387boximpl(Dp.m6389constructorimpl(measureScope2.mo627toDpu2uoSUM(Math.min(list2.get(i8).maxIntrinsicWidth(intValue), intRef.element)) - Dp.m6389constructorimpl(TabKt.getHorizontalTextPadding() * i5))), Dp.m6387boximpl(Dp.m6389constructorimpl(24)))).m6403unboximpl(), null));
                                        i8++;
                                        measureScope2 = measureScope;
                                        i5 = 2;
                                    }
                                    tabRowKt$TabRowImpl$1$scope$1$12.setTabPositions(arrayList);
                                    ArrayList arrayList2 = new ArrayList(list2.size());
                                    int size3 = list2.size();
                                    for (int i9 = 0; i9 < size3; i9++) {
                                        Measurable measurable = list2.get(i9);
                                        int i10 = intValue;
                                        long m6335copyZbe2FdA = Constraints.m6335copyZbe2FdA(j3, intRef.element, intRef.element, i10, intValue);
                                        intValue = i10;
                                        arrayList2.add(measurable.mo5333measureBRTryo0(m6335copyZbe2FdA));
                                    }
                                    final ArrayList arrayList3 = arrayList2;
                                    ArrayList arrayList4 = new ArrayList(list3.size());
                                    int size4 = list3.size();
                                    for (int i11 = 0; i11 < size4; i11++) {
                                        arrayList4.add(list3.get(i11).mo5333measureBRTryo0(Constraints.m6336copyZbe2FdA$default(j3, 0, 0, 0, 0, 11, null)));
                                    }
                                    final ArrayList arrayList5 = arrayList4;
                                    ArrayList arrayList6 = new ArrayList(list4.size());
                                    int size5 = list4.size();
                                    int i12 = 0;
                                    while (i12 < size5) {
                                        int i13 = intValue;
                                        intValue = i13;
                                        arrayList6.add(list4.get(i12).mo5333measureBRTryo0(Constraints.m6336copyZbe2FdA$default(j3, intRef.element, intRef.element, 0, i13, 4, null)));
                                        i12++;
                                        list4 = list4;
                                        arrayList6 = arrayList6;
                                    }
                                    final ArrayList arrayList7 = arrayList6;
                                    return MeasureScope.layout$default(measureScope, m6345getMaxWidthimpl, intValue, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$1$2$1.2
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
                                            List<Placeable> list5 = arrayList3;
                                            Ref.IntRef intRef2 = intRef;
                                            int size6 = list5.size();
                                            for (int i14 = 0; i14 < size6; i14++) {
                                                Placeable.PlacementScope.placeRelative$default(placementScope, list5.get(i14), i14 * intRef2.element, 0, 0.0f, 4, null);
                                            }
                                            List<Placeable> list6 = arrayList5;
                                            int i15 = intValue;
                                            int size7 = list6.size();
                                            for (int i16 = 0; i16 < size7; i16++) {
                                                Placeable placeable = list6.get(i16);
                                                Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, i15 - placeable.getHeight(), 0.0f, 4, null);
                                            }
                                            List<Placeable> list7 = arrayList7;
                                            int i17 = intValue;
                                            int size8 = list7.size();
                                            for (int i18 = 0; i18 < size8; i18++) {
                                                Placeable placeable2 = list7.get(i18);
                                                Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, 0, i17 - placeable2.getHeight(), 0.0f, 4, null);
                                            }
                                        }
                                    }, 4, null);
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue2);
                        }
                        MultiContentMeasurePolicy multiContentMeasurePolicy = (MultiContentMeasurePolicy) rememberedValue2;
                        composer3.endReplaceableGroup();
                        composer3.startReplaceableGroup(1399185516);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)171@6874L62,168@6760L182:Layout.kt#80mrfh");
                        Function2<Composer, Integer, Unit> combineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts(listOf);
                        composer3.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation(composer3, "CC(remember)P(1):Composables.kt#9igjgp");
                        boolean changed = composer3.changed(multiContentMeasurePolicy);
                        Object rememberedValue3 = composer3.rememberedValue();
                        if (changed || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicy);
                            composer3.updateRememberedValue(rememberedValue3);
                        }
                        composer3.endReplaceableGroup();
                        MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue3;
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
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
                        Updater.m3600setimpl(m3593constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        combineAsVirtualLayouts.invoke(composer3, 0);
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
            }), composer2, (i3 & 896) | 12582912 | (i3 & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$2
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

                public final void invoke(Composer composer3, int i4) {
                    TabRowKt.m2689TabRowImplDTcfvLk(Modifier.this, j, j2, function3, function2, function22, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: TabRowWithSubcomposeImpl-DTcfvLk, reason: not valid java name */
    public static final void m2690TabRowWithSubcomposeImplDTcfvLk(Modifier modifier, final long j, final long j2, final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i) {
        Modifier modifier2;
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-160898917);
        ComposerKt.sourceInformation(startRestartGroup, "C(TabRowWithSubcomposeImpl)P(4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)583@24853L2206:TabRow.kt#uh7d8r");
        if ((i & 6) == 0) {
            modifier2 = modifier;
            i2 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(j2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 131072 : 65536;
        }
        if ((74899 & i2) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-160898917, i2, -1, "androidx.compose.material3.TabRowWithSubcomposeImpl (TabRow.kt:582)");
            }
            int i3 = i2 << 3;
            composer2 = startRestartGroup;
            SurfaceKt.m2633SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier2), null, j, j2, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1617702432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowWithSubcomposeImpl$1
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

                public final void invoke(Composer composer3, int i4) {
                    ComposerKt.sourceInformation(composer3, "C588@25035L2018,588@24993L2060:TabRow.kt#uh7d8r");
                    if ((i4 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1617702432, i4, -1, "androidx.compose.material3.TabRowWithSubcomposeImpl.<anonymous> (TabRow.kt:588)");
                    }
                    Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    composer3.startReplaceableGroup(-1028159188);
                    ComposerKt.sourceInformation(composer3, "CC(remember):TabRow.kt#9igjgp");
                    boolean changed = composer3.changed(function22) | composer3.changed(function2) | composer3.changed(function3);
                    final Function2<Composer, Integer, Unit> function23 = function22;
                    final Function2<Composer, Integer, Unit> function24 = function2;
                    final Function3<List<TabPosition>, Composer, Integer, Unit> function32 = function3;
                    Object rememberedValue = composer3.rememberedValue();
                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.TabRowKt$TabRowWithSubcomposeImpl$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                return m2696invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                            }

                            /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final MeasureResult m2696invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, final long j3) {
                                int m6345getMaxWidthimpl = Constraints.m6345getMaxWidthimpl(j3);
                                List<Measurable> subcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function23);
                                int size = subcompose.size();
                                final Ref.IntRef intRef = new Ref.IntRef();
                                if (size > 0) {
                                    intRef.element = m6345getMaxWidthimpl / size;
                                }
                                int i5 = 0;
                                int size2 = subcompose.size();
                                for (int i6 = 0; i6 < size2; i6++) {
                                    i5 = Integer.valueOf(Math.max(subcompose.get(i6).maxIntrinsicHeight(intRef.element), i5.intValue()));
                                }
                                final int intValue = i5.intValue();
                                ArrayList arrayList = new ArrayList(subcompose.size());
                                int size3 = subcompose.size();
                                int i7 = 0;
                                while (i7 < size3) {
                                    arrayList.add(subcompose.get(i7).mo5333measureBRTryo0(Constraints.m6335copyZbe2FdA(j3, intRef.element, intRef.element, intValue, intValue)));
                                    i7++;
                                    m6345getMaxWidthimpl = m6345getMaxWidthimpl;
                                }
                                final int i8 = m6345getMaxWidthimpl;
                                final ArrayList arrayList2 = arrayList;
                                ArrayList arrayList3 = new ArrayList(size);
                                for (int i9 = 0; i9 < size; i9++) {
                                    arrayList3.add(new TabPosition(Dp.m6389constructorimpl(subcomposeMeasureScope.mo627toDpu2uoSUM(intRef.element) * i9), subcomposeMeasureScope.mo627toDpu2uoSUM(intRef.element), ((Dp) ComparisonsKt.maxOf(Dp.m6387boximpl(Dp.m6389constructorimpl(subcomposeMeasureScope.mo627toDpu2uoSUM(Math.min(subcompose.get(i9).maxIntrinsicWidth(intValue), intRef.element)) - Dp.m6389constructorimpl(TabKt.getHorizontalTextPadding() * 2))), Dp.m6387boximpl(Dp.m6389constructorimpl(24)))).m6403unboximpl(), null));
                                }
                                final ArrayList arrayList4 = arrayList3;
                                final Function2<Composer, Integer, Unit> function25 = function24;
                                final Function3<List<TabPosition>, Composer, Integer, Unit> function33 = function32;
                                return MeasureScope.layout$default(subcomposeMeasureScope, i8, intValue, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowWithSubcomposeImpl$1$1$1.1
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
                                        Ref.IntRef intRef2 = intRef;
                                        int size4 = list.size();
                                        for (int i10 = 0; i10 < size4; i10++) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, list.get(i10), i10 * intRef2.element, 0, 0.0f, 4, null);
                                        }
                                        List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Divider, function25);
                                        long j4 = j3;
                                        int i11 = intValue;
                                        int size5 = subcompose2.size();
                                        for (int i12 = 0; i12 < size5; i12++) {
                                            Placeable mo5333measureBRTryo0 = subcompose2.get(i12).mo5333measureBRTryo0(Constraints.m6336copyZbe2FdA$default(j4, 0, 0, 0, 0, 11, null));
                                            Placeable.PlacementScope.placeRelative$default(placementScope, mo5333measureBRTryo0, 0, i11 - mo5333measureBRTryo0.getHeight(), 0.0f, 4, null);
                                        }
                                        SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                        TabSlots tabSlots = TabSlots.Indicator;
                                        final Function3<List<TabPosition>, Composer, Integer, Unit> function34 = function33;
                                        final List<TabPosition> list2 = arrayList4;
                                        List<Measurable> subcompose3 = subcomposeMeasureScope2.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(1621992604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt.TabRowWithSubcomposeImpl.1.1.1.1.3
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

                                            public final void invoke(Composer composer4, int i13) {
                                                ComposerKt.sourceInformation(composer4, "C631@26859L23:TabRow.kt#uh7d8r");
                                                if ((i13 & 3) == 2 && composer4.getSkipping()) {
                                                    composer4.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1621992604, i13, -1, "androidx.compose.material3.TabRowWithSubcomposeImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:631)");
                                                }
                                                function34.invoke(list2, composer4, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }));
                                        int i13 = i8;
                                        int i14 = intValue;
                                        int size6 = subcompose3.size();
                                        for (int i15 = 0; i15 < size6; i15++) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, subcompose3.get(i15).mo5333measureBRTryo0(Constraints.INSTANCE.m6353fixedJhjzzOo(i13, i14)), 0, 0, 0.0f, 4, null);
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
            }), composer2, (i3 & 896) | 12582912 | (i3 & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowWithSubcomposeImpl$2
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

                public final void invoke(Composer composer3, int i4) {
                    TabRowKt.m2690TabRowWithSubcomposeImplDTcfvLk(Modifier.this, j, j2, function3, function2, function22, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00fe  */
    /* renamed from: PrimaryScrollableTabRow-qhFBPw4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2682PrimaryScrollableTabRowqhFBPw4(final int i, Modifier modifier, ScrollState scrollState, long j, long j2, float f, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        ScrollState scrollState2;
        long j3;
        long j4;
        int i5;
        float f2;
        int i6;
        int i7;
        int i8;
        ComposableLambda composableLambda;
        ScrollState scrollState3;
        long j5;
        int i9;
        Function2<? super Composer, ? super Integer, Unit> m2095getLambda4$material3_release;
        final Modifier modifier3;
        final float f3;
        final long j6;
        final long j7;
        final ScrollState scrollState4;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function32;
        ScopeUpdateScope endRestartGroup;
        int i10;
        int i11;
        int i12;
        Composer startRestartGroup = composer.startRestartGroup(-1763241113);
        ComposerKt.sourceInformation(startRestartGroup, "C(PrimaryScrollableTabRow)P(7,5,6,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp,4)677@29409L21,678@29475L21,679@29539L19,695@30196L327:TabRow.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i13 = i3 & 2;
        if (i13 != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            modifier2 = modifier;
            i4 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i2 & 384) != 0) {
                if ((i3 & 4) == 0) {
                    scrollState2 = scrollState;
                    if (startRestartGroup.changed(scrollState2)) {
                        i12 = 256;
                        i4 |= i12;
                    }
                } else {
                    scrollState2 = scrollState;
                }
                i12 = 128;
                i4 |= i12;
            } else {
                scrollState2 = scrollState;
            }
            if ((i2 & 3072) != 0) {
                if ((i3 & 8) == 0) {
                    j3 = j;
                    if (startRestartGroup.changed(j3)) {
                        i11 = 2048;
                        i4 |= i11;
                    }
                } else {
                    j3 = j;
                }
                i11 = 1024;
                i4 |= i11;
            } else {
                j3 = j;
            }
            if ((i2 & 24576) != 0) {
                if ((i3 & 16) == 0) {
                    j4 = j2;
                    if (startRestartGroup.changed(j4)) {
                        i10 = 16384;
                        i4 |= i10;
                    }
                } else {
                    j4 = j2;
                }
                i10 = 8192;
                i4 |= i10;
            } else {
                j4 = j2;
            }
            i5 = i3 & 32;
            if (i5 == 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((196608 & i2) == 0) {
                f2 = f;
                i4 |= startRestartGroup.changed(f2) ? 131072 : 65536;
                i6 = i3 & 64;
                if (i6 != 0) {
                    i4 |= 1572864;
                } else if ((i2 & 1572864) == 0) {
                    i4 |= startRestartGroup.changedInstance(function3) ? 1048576 : 524288;
                }
                i7 = i3 & 128;
                if (i7 != 0) {
                    i4 |= 12582912;
                } else if ((i2 & 12582912) == 0) {
                    i8 = i7;
                    i4 |= startRestartGroup.changedInstance(function2) ? 8388608 : 4194304;
                    if ((i3 & 256) == 0) {
                        i4 |= 100663296;
                    } else if ((i2 & 100663296) == 0) {
                        i4 |= startRestartGroup.changedInstance(function22) ? 67108864 : 33554432;
                        if ((i4 & 38347923) == 38347922 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                if (i13 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if ((i3 & 4) != 0) {
                                    i4 &= -897;
                                    scrollState2 = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
                                }
                                if ((i3 & 8) != 0) {
                                    j3 = TabRowDefaults.INSTANCE.getPrimaryContainerColor(startRestartGroup, 6);
                                    i4 &= -7169;
                                }
                                if ((i3 & 16) != 0) {
                                    j4 = TabRowDefaults.INSTANCE.getPrimaryContentColor(startRestartGroup, 6);
                                    i4 &= -57345;
                                }
                                if (i5 != 0) {
                                    f2 = TabRowDefaults.INSTANCE.m2681getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                                }
                                composableLambda = i6 != 0 ? ComposableLambdaKt.composableLambda(startRestartGroup, 438091970, true, new Function3<List<? extends TabPosition>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$PrimaryScrollableTabRow$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(List<? extends TabPosition> list, Composer composer2, Integer num) {
                                        invoke((List<TabPosition>) list, composer2, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(List<TabPosition> list, Composer composer2, int i14) {
                                        ComposerKt.sourceInformation(composer2, "C683@29809L75,684@29912L138:TabRow.kt#uh7d8r");
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(438091970, i14, -1, "androidx.compose.material3.PrimaryScrollableTabRow.<anonymous> (TabRow.kt:682)");
                                        }
                                        if (i < list.size()) {
                                            TabRowDefaults.INSTANCE.m2679PrimaryIndicator10LGxhE(TabRowDefaults.INSTANCE.tabIndicatorOffset(Modifier.INSTANCE, list.get(i)), invoke$lambda$0(AnimateAsStateKt.m433animateDpAsStateAjpBEmI(list.get(i).getContentWidth(), null, null, null, composer2, 0, 14)), 0.0f, 0L, null, composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }

                                    private static final float invoke$lambda$0(State<Dp> state) {
                                        return state.getValue().m6403unboximpl();
                                    }
                                }) : function3;
                                if (i8 != 0) {
                                    scrollState3 = scrollState2;
                                    j5 = j4;
                                    i9 = i4;
                                    m2095getLambda4$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m2095getLambda4$material3_release();
                                    modifier3 = modifier2;
                                    long j8 = j3;
                                    long j9 = j5;
                                    float f4 = f2;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1763241113, i9, -1, "androidx.compose.material3.PrimaryScrollableTabRow (TabRow.kt:694)");
                                    }
                                    int i14 = i9 >> 3;
                                    m2685ScrollableTabRowImpqhFBPw4(i, composableLambda, modifier3, j8, j9, f4, m2095getLambda4$material3_release, function22, scrollState3, startRestartGroup, (i9 & 14) | ((i9 >> 15) & 112) | ((i9 << 3) & 896) | (i9 & 7168) | (57344 & i9) | (458752 & i9) | (3670016 & i14) | (i14 & 29360128) | ((i9 << 18) & 234881024), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    Function2<? super Composer, ? super Integer, Unit> function24 = m2095getLambda4$material3_release;
                                    f3 = f4;
                                    j6 = j9;
                                    j7 = j8;
                                    scrollState4 = scrollState3;
                                    function23 = function24;
                                    function32 = composableLambda;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i3 & 4) != 0) {
                                    i4 &= -897;
                                }
                                if ((i3 & 8) != 0) {
                                    i4 &= -7169;
                                }
                                if ((i3 & 16) != 0) {
                                    i4 &= -57345;
                                }
                                composableLambda = function3;
                            }
                            scrollState3 = scrollState2;
                            j5 = j4;
                            m2095getLambda4$material3_release = function2;
                            i9 = i4;
                            modifier3 = modifier2;
                            long j82 = j3;
                            long j92 = j5;
                            float f42 = f2;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i142 = i9 >> 3;
                            m2685ScrollableTabRowImpqhFBPw4(i, composableLambda, modifier3, j82, j92, f42, m2095getLambda4$material3_release, function22, scrollState3, startRestartGroup, (i9 & 14) | ((i9 >> 15) & 112) | ((i9 << 3) & 896) | (i9 & 7168) | (57344 & i9) | (458752 & i9) | (3670016 & i142) | (i142 & 29360128) | ((i9 << 18) & 234881024), 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            Function2<? super Composer, ? super Integer, Unit> function242 = m2095getLambda4$material3_release;
                            f3 = f42;
                            j6 = j92;
                            j7 = j82;
                            scrollState4 = scrollState3;
                            function23 = function242;
                            function32 = composableLambda;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            function23 = function2;
                            modifier3 = modifier2;
                            scrollState4 = scrollState2;
                            j7 = j3;
                            j6 = j4;
                            f3 = f2;
                            function32 = function3;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$PrimaryScrollableTabRow$2
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

                                public final void invoke(Composer composer2, int i15) {
                                    TabRowKt.m2682PrimaryScrollableTabRowqhFBPw4(i, modifier3, scrollState4, j7, j6, f3, function32, function23, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i4 & 38347923) == 38347922) {
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
                    if ((i3 & 16) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    scrollState3 = scrollState2;
                    j5 = j4;
                    m2095getLambda4$material3_release = function2;
                    i9 = i4;
                    modifier3 = modifier2;
                    long j822 = j3;
                    long j922 = j5;
                    float f422 = f2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i1422 = i9 >> 3;
                    m2685ScrollableTabRowImpqhFBPw4(i, composableLambda, modifier3, j822, j922, f422, m2095getLambda4$material3_release, function22, scrollState3, startRestartGroup, (i9 & 14) | ((i9 >> 15) & 112) | ((i9 << 3) & 896) | (i9 & 7168) | (57344 & i9) | (458752 & i9) | (3670016 & i1422) | (i1422 & 29360128) | ((i9 << 18) & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    Function2<? super Composer, ? super Integer, Unit> function2422 = m2095getLambda4$material3_release;
                    f3 = f422;
                    j6 = j922;
                    j7 = j822;
                    scrollState4 = scrollState3;
                    function23 = function2422;
                    function32 = composableLambda;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i8 = i7;
                if ((i3 & 256) == 0) {
                }
                if ((i4 & 38347923) == 38347922) {
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
                if ((i3 & 16) != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (i8 != 0) {
                }
                scrollState3 = scrollState2;
                j5 = j4;
                m2095getLambda4$material3_release = function2;
                i9 = i4;
                modifier3 = modifier2;
                long j8222 = j3;
                long j9222 = j5;
                float f4222 = f2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i14222 = i9 >> 3;
                m2685ScrollableTabRowImpqhFBPw4(i, composableLambda, modifier3, j8222, j9222, f4222, m2095getLambda4$material3_release, function22, scrollState3, startRestartGroup, (i9 & 14) | ((i9 >> 15) & 112) | ((i9 << 3) & 896) | (i9 & 7168) | (57344 & i9) | (458752 & i9) | (3670016 & i14222) | (i14222 & 29360128) | ((i9 << 18) & 234881024), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                Function2<? super Composer, ? super Integer, Unit> function24222 = m2095getLambda4$material3_release;
                f3 = f4222;
                j6 = j9222;
                j7 = j8222;
                scrollState4 = scrollState3;
                function23 = function24222;
                function32 = composableLambda;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            f2 = f;
            i6 = i3 & 64;
            if (i6 != 0) {
            }
            i7 = i3 & 128;
            if (i7 != 0) {
            }
            i8 = i7;
            if ((i3 & 256) == 0) {
            }
            if ((i4 & 38347923) == 38347922) {
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
            if ((i3 & 16) != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i8 != 0) {
            }
            scrollState3 = scrollState2;
            j5 = j4;
            m2095getLambda4$material3_release = function2;
            i9 = i4;
            modifier3 = modifier2;
            long j82222 = j3;
            long j92222 = j5;
            float f42222 = f2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i142222 = i9 >> 3;
            m2685ScrollableTabRowImpqhFBPw4(i, composableLambda, modifier3, j82222, j92222, f42222, m2095getLambda4$material3_release, function22, scrollState3, startRestartGroup, (i9 & 14) | ((i9 >> 15) & 112) | ((i9 << 3) & 896) | (i9 & 7168) | (57344 & i9) | (458752 & i9) | (3670016 & i142222) | (i142222 & 29360128) | ((i9 << 18) & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            Function2<? super Composer, ? super Integer, Unit> function242222 = m2095getLambda4$material3_release;
            f3 = f42222;
            j6 = j92222;
            j7 = j82222;
            scrollState4 = scrollState3;
            function23 = function242222;
            function32 = composableLambda;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i2 & 384) != 0) {
        }
        if ((i2 & 3072) != 0) {
        }
        if ((i2 & 24576) != 0) {
        }
        i5 = i3 & 32;
        if (i5 == 0) {
        }
        f2 = f;
        i6 = i3 & 64;
        if (i6 != 0) {
        }
        i7 = i3 & 128;
        if (i7 != 0) {
        }
        i8 = i7;
        if ((i3 & 256) == 0) {
        }
        if ((i4 & 38347923) == 38347922) {
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
        if ((i3 & 16) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i8 != 0) {
        }
        scrollState3 = scrollState2;
        j5 = j4;
        m2095getLambda4$material3_release = function2;
        i9 = i4;
        modifier3 = modifier2;
        long j822222 = j3;
        long j922222 = j5;
        float f422222 = f2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i1422222 = i9 >> 3;
        m2685ScrollableTabRowImpqhFBPw4(i, composableLambda, modifier3, j822222, j922222, f422222, m2095getLambda4$material3_release, function22, scrollState3, startRestartGroup, (i9 & 14) | ((i9 >> 15) & 112) | ((i9 << 3) & 896) | (i9 & 7168) | (57344 & i9) | (458752 & i9) | (3670016 & i1422222) | (i1422222 & 29360128) | ((i9 << 18) & 234881024), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        Function2<? super Composer, ? super Integer, Unit> function2422222 = m2095getLambda4$material3_release;
        f3 = f422222;
        j6 = j922222;
        j7 = j822222;
        scrollState4 = scrollState3;
        function23 = function2422222;
        function32 = composableLambda;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00fe  */
    /* renamed from: SecondaryScrollableTabRow-qhFBPw4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2686SecondaryScrollableTabRowqhFBPw4(final int i, Modifier modifier, ScrollState scrollState, long j, long j2, float f, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        ScrollState scrollState2;
        long j3;
        long j4;
        int i5;
        float f2;
        int i6;
        int i7;
        int i8;
        ComposableLambda composableLambda;
        ScrollState scrollState3;
        long j5;
        int i9;
        Function2<? super Composer, ? super Integer, Unit> m2096getLambda5$material3_release;
        final Modifier modifier3;
        final float f3;
        final long j6;
        final long j7;
        final ScrollState scrollState4;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function32;
        ScopeUpdateScope endRestartGroup;
        int i10;
        int i11;
        int i12;
        Composer startRestartGroup = composer.startRestartGroup(1821940917);
        ComposerKt.sourceInformation(startRestartGroup, "C(SecondaryScrollableTabRow)P(7,5,6,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp,4)749@33144L21,750@33210L23,751@33276L21,763@33731L326:TabRow.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i13 = i3 & 2;
        if (i13 != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            modifier2 = modifier;
            i4 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i2 & 384) != 0) {
                if ((i3 & 4) == 0) {
                    scrollState2 = scrollState;
                    if (startRestartGroup.changed(scrollState2)) {
                        i12 = 256;
                        i4 |= i12;
                    }
                } else {
                    scrollState2 = scrollState;
                }
                i12 = 128;
                i4 |= i12;
            } else {
                scrollState2 = scrollState;
            }
            if ((i2 & 3072) != 0) {
                if ((i3 & 8) == 0) {
                    j3 = j;
                    if (startRestartGroup.changed(j3)) {
                        i11 = 2048;
                        i4 |= i11;
                    }
                } else {
                    j3 = j;
                }
                i11 = 1024;
                i4 |= i11;
            } else {
                j3 = j;
            }
            if ((i2 & 24576) != 0) {
                if ((i3 & 16) == 0) {
                    j4 = j2;
                    if (startRestartGroup.changed(j4)) {
                        i10 = 16384;
                        i4 |= i10;
                    }
                } else {
                    j4 = j2;
                }
                i10 = 8192;
                i4 |= i10;
            } else {
                j4 = j2;
            }
            i5 = i3 & 32;
            if (i5 == 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((196608 & i2) == 0) {
                f2 = f;
                i4 |= startRestartGroup.changed(f2) ? 131072 : 65536;
                i6 = i3 & 64;
                if (i6 != 0) {
                    i4 |= 1572864;
                } else if ((i2 & 1572864) == 0) {
                    i4 |= startRestartGroup.changedInstance(function3) ? 1048576 : 524288;
                }
                i7 = i3 & 128;
                if (i7 != 0) {
                    i4 |= 12582912;
                } else if ((i2 & 12582912) == 0) {
                    i8 = i7;
                    i4 |= startRestartGroup.changedInstance(function2) ? 8388608 : 4194304;
                    if ((i3 & 256) == 0) {
                        i4 |= 100663296;
                    } else if ((i2 & 100663296) == 0) {
                        i4 |= startRestartGroup.changedInstance(function22) ? 67108864 : 33554432;
                        if ((i4 & 38347923) == 38347922 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                if (i13 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if ((i3 & 4) != 0) {
                                    i4 &= -897;
                                    scrollState2 = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
                                }
                                if ((i3 & 8) != 0) {
                                    j3 = TabRowDefaults.INSTANCE.getSecondaryContainerColor(startRestartGroup, 6);
                                    i4 &= -7169;
                                }
                                if ((i3 & 16) != 0) {
                                    j4 = TabRowDefaults.INSTANCE.getSecondaryContentColor(startRestartGroup, 6);
                                    i4 &= -57345;
                                }
                                if (i5 != 0) {
                                    f2 = TabRowDefaults.INSTANCE.m2681getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                                }
                                composableLambda = i6 != 0 ? ComposableLambdaKt.composableLambda(startRestartGroup, -115843248, true, new Function3<List<? extends TabPosition>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$SecondaryScrollableTabRow$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(List<? extends TabPosition> list, Composer composer2, Integer num) {
                                        invoke((List<TabPosition>) list, composer2, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(List<TabPosition> list, Composer composer2, int i14) {
                                        ComposerKt.sourceInformation(composer2, "C754@33494L101:TabRow.kt#uh7d8r");
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-115843248, i14, -1, "androidx.compose.material3.SecondaryScrollableTabRow.<anonymous> (TabRow.kt:754)");
                                        }
                                        TabRowDefaults.INSTANCE.m2680SecondaryIndicator9IZ8Weo(TabRowDefaults.INSTANCE.tabIndicatorOffset(Modifier.INSTANCE, list.get(i)), 0.0f, 0L, composer2, 3072, 6);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }) : function3;
                                if (i8 != 0) {
                                    scrollState3 = scrollState2;
                                    j5 = j4;
                                    i9 = i4;
                                    m2096getLambda5$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m2096getLambda5$material3_release();
                                    modifier3 = modifier2;
                                    long j8 = j3;
                                    long j9 = j5;
                                    float f4 = f2;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1821940917, i9, -1, "androidx.compose.material3.SecondaryScrollableTabRow (TabRow.kt:762)");
                                    }
                                    int i14 = i9 >> 3;
                                    m2685ScrollableTabRowImpqhFBPw4(i, composableLambda, modifier3, j8, j9, f4, m2096getLambda5$material3_release, function22, scrollState3, startRestartGroup, (i9 & 14) | ((i9 >> 15) & 112) | ((i9 << 3) & 896) | (i9 & 7168) | (57344 & i9) | (458752 & i9) | (3670016 & i14) | (i14 & 29360128) | ((i9 << 18) & 234881024), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    Function2<? super Composer, ? super Integer, Unit> function24 = m2096getLambda5$material3_release;
                                    f3 = f4;
                                    j6 = j9;
                                    j7 = j8;
                                    scrollState4 = scrollState3;
                                    function23 = function24;
                                    function32 = composableLambda;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i3 & 4) != 0) {
                                    i4 &= -897;
                                }
                                if ((i3 & 8) != 0) {
                                    i4 &= -7169;
                                }
                                if ((i3 & 16) != 0) {
                                    i4 &= -57345;
                                }
                                composableLambda = function3;
                            }
                            scrollState3 = scrollState2;
                            j5 = j4;
                            m2096getLambda5$material3_release = function2;
                            i9 = i4;
                            modifier3 = modifier2;
                            long j82 = j3;
                            long j92 = j5;
                            float f42 = f2;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i142 = i9 >> 3;
                            m2685ScrollableTabRowImpqhFBPw4(i, composableLambda, modifier3, j82, j92, f42, m2096getLambda5$material3_release, function22, scrollState3, startRestartGroup, (i9 & 14) | ((i9 >> 15) & 112) | ((i9 << 3) & 896) | (i9 & 7168) | (57344 & i9) | (458752 & i9) | (3670016 & i142) | (i142 & 29360128) | ((i9 << 18) & 234881024), 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            Function2<? super Composer, ? super Integer, Unit> function242 = m2096getLambda5$material3_release;
                            f3 = f42;
                            j6 = j92;
                            j7 = j82;
                            scrollState4 = scrollState3;
                            function23 = function242;
                            function32 = composableLambda;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            function23 = function2;
                            modifier3 = modifier2;
                            scrollState4 = scrollState2;
                            j7 = j3;
                            j6 = j4;
                            f3 = f2;
                            function32 = function3;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$SecondaryScrollableTabRow$2
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

                                public final void invoke(Composer composer2, int i15) {
                                    TabRowKt.m2686SecondaryScrollableTabRowqhFBPw4(i, modifier3, scrollState4, j7, j6, f3, function32, function23, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i4 & 38347923) == 38347922) {
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
                    if ((i3 & 16) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    scrollState3 = scrollState2;
                    j5 = j4;
                    m2096getLambda5$material3_release = function2;
                    i9 = i4;
                    modifier3 = modifier2;
                    long j822 = j3;
                    long j922 = j5;
                    float f422 = f2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i1422 = i9 >> 3;
                    m2685ScrollableTabRowImpqhFBPw4(i, composableLambda, modifier3, j822, j922, f422, m2096getLambda5$material3_release, function22, scrollState3, startRestartGroup, (i9 & 14) | ((i9 >> 15) & 112) | ((i9 << 3) & 896) | (i9 & 7168) | (57344 & i9) | (458752 & i9) | (3670016 & i1422) | (i1422 & 29360128) | ((i9 << 18) & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    Function2<? super Composer, ? super Integer, Unit> function2422 = m2096getLambda5$material3_release;
                    f3 = f422;
                    j6 = j922;
                    j7 = j822;
                    scrollState4 = scrollState3;
                    function23 = function2422;
                    function32 = composableLambda;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i8 = i7;
                if ((i3 & 256) == 0) {
                }
                if ((i4 & 38347923) == 38347922) {
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
                if ((i3 & 16) != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (i8 != 0) {
                }
                scrollState3 = scrollState2;
                j5 = j4;
                m2096getLambda5$material3_release = function2;
                i9 = i4;
                modifier3 = modifier2;
                long j8222 = j3;
                long j9222 = j5;
                float f4222 = f2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i14222 = i9 >> 3;
                m2685ScrollableTabRowImpqhFBPw4(i, composableLambda, modifier3, j8222, j9222, f4222, m2096getLambda5$material3_release, function22, scrollState3, startRestartGroup, (i9 & 14) | ((i9 >> 15) & 112) | ((i9 << 3) & 896) | (i9 & 7168) | (57344 & i9) | (458752 & i9) | (3670016 & i14222) | (i14222 & 29360128) | ((i9 << 18) & 234881024), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                Function2<? super Composer, ? super Integer, Unit> function24222 = m2096getLambda5$material3_release;
                f3 = f4222;
                j6 = j9222;
                j7 = j8222;
                scrollState4 = scrollState3;
                function23 = function24222;
                function32 = composableLambda;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            f2 = f;
            i6 = i3 & 64;
            if (i6 != 0) {
            }
            i7 = i3 & 128;
            if (i7 != 0) {
            }
            i8 = i7;
            if ((i3 & 256) == 0) {
            }
            if ((i4 & 38347923) == 38347922) {
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
            if ((i3 & 16) != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i8 != 0) {
            }
            scrollState3 = scrollState2;
            j5 = j4;
            m2096getLambda5$material3_release = function2;
            i9 = i4;
            modifier3 = modifier2;
            long j82222 = j3;
            long j92222 = j5;
            float f42222 = f2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i142222 = i9 >> 3;
            m2685ScrollableTabRowImpqhFBPw4(i, composableLambda, modifier3, j82222, j92222, f42222, m2096getLambda5$material3_release, function22, scrollState3, startRestartGroup, (i9 & 14) | ((i9 >> 15) & 112) | ((i9 << 3) & 896) | (i9 & 7168) | (57344 & i9) | (458752 & i9) | (3670016 & i142222) | (i142222 & 29360128) | ((i9 << 18) & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            Function2<? super Composer, ? super Integer, Unit> function242222 = m2096getLambda5$material3_release;
            f3 = f42222;
            j6 = j92222;
            j7 = j82222;
            scrollState4 = scrollState3;
            function23 = function242222;
            function32 = composableLambda;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i2 & 384) != 0) {
        }
        if ((i2 & 3072) != 0) {
        }
        if ((i2 & 24576) != 0) {
        }
        i5 = i3 & 32;
        if (i5 == 0) {
        }
        f2 = f;
        i6 = i3 & 64;
        if (i6 != 0) {
        }
        i7 = i3 & 128;
        if (i7 != 0) {
        }
        i8 = i7;
        if ((i3 & 256) == 0) {
        }
        if ((i4 & 38347923) == 38347922) {
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
        if ((i3 & 16) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i8 != 0) {
        }
        scrollState3 = scrollState2;
        j5 = j4;
        m2096getLambda5$material3_release = function2;
        i9 = i4;
        modifier3 = modifier2;
        long j822222 = j3;
        long j922222 = j5;
        float f422222 = f2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i1422222 = i9 >> 3;
        m2685ScrollableTabRowImpqhFBPw4(i, composableLambda, modifier3, j822222, j922222, f422222, m2096getLambda5$material3_release, function22, scrollState3, startRestartGroup, (i9 & 14) | ((i9 >> 15) & 112) | ((i9 << 3) & 896) | (i9 & 7168) | (57344 & i9) | (458752 & i9) | (3670016 & i1422222) | (i1422222 & 29360128) | ((i9 << 18) & 234881024), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        Function2<? super Composer, ? super Integer, Unit> function2422222 = m2096getLambda5$material3_release;
        f3 = f422222;
        j6 = j922222;
        j7 = j822222;
        scrollState4 = scrollState3;
        function23 = function2422222;
        function32 = composableLambda;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00a1  */
    /* renamed from: ScrollableTabRow-sKfQg0A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2684ScrollableTabRowsKfQg0A(final int i, Modifier modifier, long j, long j2, float f, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        long j3;
        long j4;
        int i5;
        float f2;
        int i6;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function32;
        int i7;
        int i8;
        final Modifier modifier3;
        final long j5;
        final long j6;
        final float f3;
        Function2<? super Composer, ? super Integer, Unit> m2097getLambda6$material3_release;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function33;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function34;
        ScopeUpdateScope endRestartGroup;
        int i9;
        int i10;
        Composer startRestartGroup = composer.startRestartGroup(-497821003);
        ComposerKt.sourceInformation(startRestartGroup, "C(ScrollableTabRow)P(6,5,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp,4)816@36583L21,817@36647L19,838@37409L21,829@37100L336:TabRow.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i11 = i3 & 2;
        if (i11 != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            modifier2 = modifier;
            i4 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i2 & 384) != 0) {
                if ((i3 & 4) == 0) {
                    j3 = j;
                    if (startRestartGroup.changed(j3)) {
                        i10 = 256;
                        i4 |= i10;
                    }
                } else {
                    j3 = j;
                }
                i10 = 128;
                i4 |= i10;
            } else {
                j3 = j;
            }
            if ((i2 & 3072) != 0) {
                if ((i3 & 8) == 0) {
                    j4 = j2;
                    if (startRestartGroup.changed(j4)) {
                        i9 = 2048;
                        i4 |= i9;
                    }
                } else {
                    j4 = j2;
                }
                i9 = 1024;
                i4 |= i9;
            } else {
                j4 = j2;
            }
            i5 = i3 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else if ((i2 & 24576) == 0) {
                f2 = f;
                i4 |= startRestartGroup.changed(f2) ? 16384 : 8192;
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i2) == 0) {
                    function32 = function3;
                    i4 |= startRestartGroup.changedInstance(function32) ? 131072 : 65536;
                    i7 = i3 & 64;
                    if (i7 == 0) {
                        i4 |= 1572864;
                    } else if ((i2 & 1572864) == 0) {
                        i4 |= startRestartGroup.changedInstance(function2) ? 1048576 : 524288;
                    }
                    if ((i3 & 128) == 0) {
                        i4 |= 12582912;
                    } else if ((i2 & 12582912) == 0) {
                        i4 |= startRestartGroup.changedInstance(function22) ? 8388608 : 4194304;
                        if ((i4 & 4793491) == 4793490 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                if (i11 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if ((i3 & 4) != 0) {
                                    j3 = TabRowDefaults.INSTANCE.getPrimaryContainerColor(startRestartGroup, 6);
                                    i4 &= -897;
                                }
                                if ((i3 & 8) != 0) {
                                    j4 = TabRowDefaults.INSTANCE.getPrimaryContentColor(startRestartGroup, 6);
                                    i4 &= -7169;
                                }
                                if (i5 != 0) {
                                    f2 = TabRowDefaults.INSTANCE.m2681getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                                }
                                if (i6 != 0) {
                                    function32 = ComposableLambdaKt.composableLambda(startRestartGroup, -913748678, true, new Function3<List<? extends TabPosition>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRow$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(List<? extends TabPosition> list, Composer composer2, Integer num) {
                                            invoke((List<TabPosition>) list, composer2, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(List<TabPosition> list, Composer composer2, int i12) {
                                            ComposerKt.sourceInformation(composer2, "C820@36863L101:TabRow.kt#uh7d8r");
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-913748678, i12, -1, "androidx.compose.material3.ScrollableTabRow.<anonymous> (TabRow.kt:820)");
                                            }
                                            TabRowDefaults.INSTANCE.m2680SecondaryIndicator9IZ8Weo(TabRowDefaults.INSTANCE.tabIndicatorOffset(Modifier.INSTANCE, list.get(i)), 0.0f, 0L, composer2, 3072, 6);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    });
                                }
                                if (i7 != 0) {
                                    i8 = i4;
                                    modifier3 = modifier2;
                                    j5 = j3;
                                    j6 = j4;
                                    f3 = f2;
                                    m2097getLambda6$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m2097getLambda6$material3_release();
                                    function33 = function32;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-497821003, i8, -1, "androidx.compose.material3.ScrollableTabRow (TabRow.kt:828)");
                                    }
                                    int i12 = i8 << 3;
                                    m2685ScrollableTabRowImpqhFBPw4(i, function33, modifier3, j5, j6, f3, m2097getLambda6$material3_release, function22, ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), startRestartGroup, (i12 & 896) | (i8 & 14) | ((i8 >> 12) & 112) | (i12 & 7168) | (57344 & i12) | (458752 & i12) | (3670016 & i8) | (i8 & 29360128), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    function23 = m2097getLambda6$material3_release;
                                    function34 = function33;
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
                            i8 = i4;
                            modifier3 = modifier2;
                            j5 = j3;
                            j6 = j4;
                            f3 = f2;
                            function33 = function32;
                            m2097getLambda6$material3_release = function2;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i122 = i8 << 3;
                            m2685ScrollableTabRowImpqhFBPw4(i, function33, modifier3, j5, j6, f3, m2097getLambda6$material3_release, function22, ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), startRestartGroup, (i122 & 896) | (i8 & 14) | ((i8 >> 12) & 112) | (i122 & 7168) | (57344 & i122) | (458752 & i122) | (3670016 & i8) | (i8 & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            function23 = m2097getLambda6$material3_release;
                            function34 = function33;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            function23 = function2;
                            modifier3 = modifier2;
                            j5 = j3;
                            j6 = j4;
                            f3 = f2;
                            function34 = function32;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRow$2
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
                                    TabRowKt.m2684ScrollableTabRowsKfQg0A(i, modifier3, j5, j6, f3, function34, function23, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i4 & 4793491) == 4793490) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                    }
                    if (i11 != 0) {
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
                    i8 = i4;
                    modifier3 = modifier2;
                    j5 = j3;
                    j6 = j4;
                    f3 = f2;
                    function33 = function32;
                    m2097getLambda6$material3_release = function2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i1222 = i8 << 3;
                    m2685ScrollableTabRowImpqhFBPw4(i, function33, modifier3, j5, j6, f3, m2097getLambda6$material3_release, function22, ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), startRestartGroup, (i1222 & 896) | (i8 & 14) | ((i8 >> 12) & 112) | (i1222 & 7168) | (57344 & i1222) | (458752 & i1222) | (3670016 & i8) | (i8 & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    function23 = m2097getLambda6$material3_release;
                    function34 = function33;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function32 = function3;
                i7 = i3 & 64;
                if (i7 == 0) {
                }
                if ((i3 & 128) == 0) {
                }
                if ((i4 & 4793491) == 4793490) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i11 != 0) {
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
                i8 = i4;
                modifier3 = modifier2;
                j5 = j3;
                j6 = j4;
                f3 = f2;
                function33 = function32;
                m2097getLambda6$material3_release = function2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i12222 = i8 << 3;
                m2685ScrollableTabRowImpqhFBPw4(i, function33, modifier3, j5, j6, f3, m2097getLambda6$material3_release, function22, ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), startRestartGroup, (i12222 & 896) | (i8 & 14) | ((i8 >> 12) & 112) | (i12222 & 7168) | (57344 & i12222) | (458752 & i12222) | (3670016 & i8) | (i8 & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                function23 = m2097getLambda6$material3_release;
                function34 = function33;
                endRestartGroup = startRestartGroup.endRestartGroup();
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
            if ((i4 & 4793491) == 4793490) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i11 != 0) {
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
            i8 = i4;
            modifier3 = modifier2;
            j5 = j3;
            j6 = j4;
            f3 = f2;
            function33 = function32;
            m2097getLambda6$material3_release = function2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i122222 = i8 << 3;
            m2685ScrollableTabRowImpqhFBPw4(i, function33, modifier3, j5, j6, f3, m2097getLambda6$material3_release, function22, ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), startRestartGroup, (i122222 & 896) | (i8 & 14) | ((i8 >> 12) & 112) | (i122222 & 7168) | (57344 & i122222) | (458752 & i122222) | (3670016 & i8) | (i8 & 29360128), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            function23 = m2097getLambda6$material3_release;
            function34 = function33;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i2 & 384) != 0) {
        }
        if ((i2 & 3072) != 0) {
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
        if ((i4 & 4793491) == 4793490) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i11 != 0) {
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
        i8 = i4;
        modifier3 = modifier2;
        j5 = j3;
        j6 = j4;
        f3 = f2;
        function33 = function32;
        m2097getLambda6$material3_release = function2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i1222222 = i8 << 3;
        m2685ScrollableTabRowImpqhFBPw4(i, function33, modifier3, j5, j6, f3, m2097getLambda6$material3_release, function22, ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), startRestartGroup, (i1222222 & 896) | (i8 & 14) | ((i8 >> 12) & 112) | (i1222222 & 7168) | (57344 & i1222222) | (458752 & i1222222) | (3670016 & i8) | (i8 & 29360128), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        function23 = m2097getLambda6$material3_release;
        function34 = function33;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:106:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00c5  */
    /* renamed from: ScrollableTabRowImp-qhFBPw4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2685ScrollableTabRowImpqhFBPw4(final int i, final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, long j, long j2, float f, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final ScrollState scrollState, Composer composer, final int i2, final int i3) {
        int i4;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function32;
        int i5;
        Modifier modifier2;
        long j3;
        long j4;
        int i6;
        float f2;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> m2098getLambda7$material3_release;
        Composer composer2;
        final float f3;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        final Modifier modifier3;
        final long j5;
        final long j6;
        ScopeUpdateScope endRestartGroup;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(-1696166011);
        ComposerKt.sourceInformation(startRestartGroup, "C(ScrollableTabRowImp)P(7,4,5,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp!1,8)847@37660L21,848@37724L19,856@37975L3984:TabRow.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            function32 = function3;
            i4 |= startRestartGroup.changedInstance(function32) ? 32 : 16;
            i5 = i3 & 4;
            if (i5 == 0) {
                i4 |= 384;
            } else if ((i2 & 384) == 0) {
                modifier2 = modifier;
                i4 |= startRestartGroup.changed(modifier2) ? 256 : 128;
                if ((i2 & 3072) == 0) {
                    if ((i3 & 8) == 0) {
                        j3 = j;
                        if (startRestartGroup.changed(j3)) {
                            i9 = 2048;
                            i4 |= i9;
                        }
                    } else {
                        j3 = j;
                    }
                    i9 = 1024;
                    i4 |= i9;
                } else {
                    j3 = j;
                }
                if ((i2 & 24576) == 0) {
                    if ((i3 & 16) == 0) {
                        j4 = j2;
                        if (startRestartGroup.changed(j4)) {
                            i8 = 16384;
                            i4 |= i8;
                        }
                    } else {
                        j4 = j2;
                    }
                    i8 = 8192;
                    i4 |= i8;
                } else {
                    j4 = j2;
                }
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i2) == 0) {
                    f2 = f;
                    i4 |= startRestartGroup.changed(f2) ? 131072 : 65536;
                    i7 = i3 & 64;
                    if (i7 == 0) {
                        i4 |= 1572864;
                    } else if ((i2 & 1572864) == 0) {
                        i4 |= startRestartGroup.changedInstance(function2) ? 1048576 : 524288;
                    }
                    if ((i3 & 128) == 0) {
                        i4 |= 12582912;
                    } else if ((i2 & 12582912) == 0) {
                        i4 |= startRestartGroup.changedInstance(function22) ? 8388608 : 4194304;
                        if ((i3 & 256) != 0) {
                            i4 |= 100663296;
                        } else if ((i2 & 100663296) == 0) {
                            i4 |= startRestartGroup.changed(scrollState) ? 67108864 : 33554432;
                            if ((i4 & 38347923) == 38347922 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    if (i5 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if ((i3 & 8) != 0) {
                                        j3 = TabRowDefaults.INSTANCE.getPrimaryContainerColor(startRestartGroup, 6);
                                        i4 &= -7169;
                                    }
                                    if ((i3 & 16) != 0) {
                                        j4 = TabRowDefaults.INSTANCE.getPrimaryContentColor(startRestartGroup, 6);
                                        i4 &= -57345;
                                    }
                                    if (i6 != 0) {
                                        f2 = TabRowDefaults.INSTANCE.m2681getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                                    }
                                    if (i7 != 0) {
                                        m2098getLambda7$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m2098getLambda7$material3_release();
                                        long j7 = j4;
                                        final float f4 = f2;
                                        Modifier modifier4 = modifier2;
                                        long j8 = j3;
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1696166011, i4, -1, "androidx.compose.material3.ScrollableTabRowImp (TabRow.kt:855)");
                                        }
                                        final Function2<? super Composer, ? super Integer, Unit> function24 = m2098getLambda7$material3_release;
                                        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function33 = function32;
                                        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, -1178901494, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1
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

                                            public final void invoke(Composer composer3, int i10) {
                                                ComposerKt.sourceInformation(composer3, "C861@38118L24,862@38175L185,875@38628L3325,868@38369L3584:TabRow.kt#uh7d8r");
                                                if ((i10 & 3) != 2 || !composer3.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1178901494, i10, -1, "androidx.compose.material3.ScrollableTabRowImp.<anonymous> (TabRow.kt:861)");
                                                    }
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
                                                    composer3.startReplaceableGroup(121290627);
                                                    ComposerKt.sourceInformation(composer3, "CC(remember):TabRow.kt#9igjgp");
                                                    boolean changed = composer3.changed(ScrollState.this) | composer3.changed(coroutineScope);
                                                    ScrollState scrollState2 = ScrollState.this;
                                                    Object rememberedValue2 = composer3.rememberedValue();
                                                    if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue2 = new ScrollableTabData(scrollState2, coroutineScope);
                                                        composer3.updateRememberedValue(rememberedValue2);
                                                    }
                                                    final ScrollableTabData scrollableTabData = (ScrollableTabData) rememberedValue2;
                                                    composer3.endReplaceableGroup();
                                                    Modifier clipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getCenterStart(), false, 2, null), ScrollState.this, false, null, false, 14, null)));
                                                    composer3.startReplaceableGroup(121291080);
                                                    ComposerKt.sourceInformation(composer3, "CC(remember):TabRow.kt#9igjgp");
                                                    boolean changed2 = composer3.changed(f4) | composer3.changed(function22) | composer3.changed(function24) | composer3.changed(function33) | composer3.changedInstance(scrollableTabData) | composer3.changed(i);
                                                    final float f5 = f4;
                                                    final Function2<Composer, Integer, Unit> function25 = function22;
                                                    final Function2<Composer, Integer, Unit> function26 = function24;
                                                    final int i11 = i;
                                                    final Function3<List<TabPosition>, Composer, Integer, Unit> function34 = function33;
                                                    Object rememberedValue3 = composer3.rememberedValue();
                                                    if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue3 = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1$1$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            /* JADX WARN: Multi-variable type inference failed */
                                                            {
                                                                super(2);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function2
                                                            public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                                                return m2694invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                                                            }

                                                            /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                                                            public final MeasureResult m2694invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, final long j9) {
                                                                float f6;
                                                                f6 = TabRowKt.ScrollableTabRowMinimumTabWidth;
                                                                int i12 = subcomposeMeasureScope.mo624roundToPx0680j_4(f6);
                                                                final int i13 = subcomposeMeasureScope.mo624roundToPx0680j_4(f5);
                                                                List<Measurable> subcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function25);
                                                                int i14 = 0;
                                                                int size = subcompose.size();
                                                                for (int i15 = 0; i15 < size; i15++) {
                                                                    i14 = Integer.valueOf(Math.max(i14.intValue(), subcompose.get(i15).maxIntrinsicHeight(Integer.MAX_VALUE)));
                                                                }
                                                                final int intValue = i14.intValue();
                                                                long m6336copyZbe2FdA$default = Constraints.m6336copyZbe2FdA$default(j9, i12, 0, intValue, intValue, 2, null);
                                                                final ArrayList arrayList = new ArrayList();
                                                                final ArrayList arrayList2 = new ArrayList();
                                                                int size2 = subcompose.size();
                                                                for (int i16 = 0; i16 < size2; i16++) {
                                                                    Measurable measurable = subcompose.get(i16);
                                                                    Placeable mo5333measureBRTryo0 = measurable.mo5333measureBRTryo0(m6336copyZbe2FdA$default);
                                                                    float m6389constructorimpl = Dp.m6389constructorimpl(subcomposeMeasureScope.mo627toDpu2uoSUM(Math.min(measurable.maxIntrinsicWidth(mo5333measureBRTryo0.getHeight()), mo5333measureBRTryo0.getWidth())) - Dp.m6389constructorimpl(TabKt.getHorizontalTextPadding() * 2));
                                                                    arrayList.add(mo5333measureBRTryo0);
                                                                    arrayList2.add(Dp.m6387boximpl(m6389constructorimpl));
                                                                }
                                                                Integer valueOf = Integer.valueOf(i13 * 2);
                                                                int size3 = arrayList.size();
                                                                for (int i17 = 0; i17 < size3; i17++) {
                                                                    valueOf = Integer.valueOf(valueOf.intValue() + ((Placeable) arrayList.get(i17)).getWidth());
                                                                }
                                                                final int intValue2 = valueOf.intValue();
                                                                final Function2<Composer, Integer, Unit> function27 = function26;
                                                                final ScrollableTabData scrollableTabData2 = scrollableTabData;
                                                                final int i18 = i11;
                                                                final Function3<List<TabPosition>, Composer, Integer, Unit> function35 = function34;
                                                                return MeasureScope.layout$default(subcomposeMeasureScope, intValue2, intValue, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1$1$1.2
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
                                                                        int i19 = i13;
                                                                        List<Placeable> list = arrayList;
                                                                        SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                                                        List<Dp> list2 = arrayList2;
                                                                        int size4 = list.size();
                                                                        int i20 = i19;
                                                                        for (int i21 = 0; i21 < size4; i21++) {
                                                                            Placeable placeable = list.get(i21);
                                                                            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, i20, 0, 0.0f, 4, null);
                                                                            arrayList3.add(new TabPosition(subcomposeMeasureScope2.mo627toDpu2uoSUM(i20), subcomposeMeasureScope2.mo627toDpu2uoSUM(placeable.getWidth()), list2.get(i21).m6403unboximpl(), null));
                                                                            i20 += placeable.getWidth();
                                                                        }
                                                                        List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Divider, function27);
                                                                        long j10 = j9;
                                                                        int i22 = intValue2;
                                                                        int i23 = intValue;
                                                                        int size5 = subcompose2.size();
                                                                        for (int i24 = 0; i24 < size5; i24++) {
                                                                            Placeable mo5333measureBRTryo02 = subcompose2.get(i24).mo5333measureBRTryo0(Constraints.m6336copyZbe2FdA$default(j10, i22, i22, 0, 0, 8, null));
                                                                            Placeable.PlacementScope.placeRelative$default(placementScope, mo5333measureBRTryo02, 0, i23 - mo5333measureBRTryo02.getHeight(), 0.0f, 4, null);
                                                                        }
                                                                        SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope;
                                                                        TabSlots tabSlots = TabSlots.Indicator;
                                                                        final Function3<List<TabPosition>, Composer, Integer, Unit> function36 = function35;
                                                                        List<Measurable> subcompose3 = subcomposeMeasureScope3.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(358596038, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt.ScrollableTabRowImp.1.1.1.2.3
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

                                                                            public final void invoke(Composer composer4, int i25) {
                                                                                ComposerKt.sourceInformation(composer4, "C942@41500L23:TabRow.kt#uh7d8r");
                                                                                if ((i25 & 3) == 2 && composer4.getSkipping()) {
                                                                                    composer4.skipToGroupEnd();
                                                                                    return;
                                                                                }
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventStart(358596038, i25, -1, "androidx.compose.material3.ScrollableTabRowImp.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:942)");
                                                                                }
                                                                                function36.invoke(arrayList3, composer4, 0);
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventEnd();
                                                                                }
                                                                            }
                                                                        }));
                                                                        int i25 = intValue2;
                                                                        int i26 = intValue;
                                                                        int size6 = subcompose3.size();
                                                                        for (int i27 = 0; i27 < size6; i27++) {
                                                                            Placeable.PlacementScope.placeRelative$default(placementScope, subcompose3.get(i27).mo5333measureBRTryo0(Constraints.INSTANCE.m6353fixedJhjzzOo(i25, i26)), 0, 0, 0.0f, 4, null);
                                                                        }
                                                                        scrollableTabData2.onLaidOut(subcomposeMeasureScope, i13, arrayList3, i18);
                                                                    }
                                                                }, 4, null);
                                                            }
                                                        };
                                                        composer3.updateRememberedValue(rememberedValue3);
                                                    }
                                                    composer3.endReplaceableGroup();
                                                    SubcomposeLayoutKt.SubcomposeLayout(clipToBounds, (Function2) rememberedValue3, composer3, 0, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer3.skipToGroupEnd();
                                            }
                                        });
                                        int i10 = ((i4 >> 6) & 14) | 12582912;
                                        int i11 = i4 >> 3;
                                        composer2 = startRestartGroup;
                                        SurfaceKt.m2633SurfaceT9BRK9s(modifier4, null, j8, j7, 0.0f, 0.0f, null, composableLambda, composer2, i10 | (i11 & 896) | (i11 & 7168), 114);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        f3 = f4;
                                        function23 = function24;
                                        modifier3 = modifier4;
                                        j5 = j8;
                                        j6 = j7;
                                    }
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i3 & 8) != 0) {
                                        i4 &= -7169;
                                    }
                                    if ((i3 & 16) != 0) {
                                        i4 &= -57345;
                                    }
                                }
                                m2098getLambda7$material3_release = function2;
                                long j72 = j4;
                                final float f42 = f2;
                                Modifier modifier42 = modifier2;
                                long j82 = j3;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                final Function2<? super Composer, ? super Integer, Unit> function242 = m2098getLambda7$material3_release;
                                final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function332 = function32;
                                ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(startRestartGroup, -1178901494, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1
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

                                    public final void invoke(Composer composer3, int i102) {
                                        ComposerKt.sourceInformation(composer3, "C861@38118L24,862@38175L185,875@38628L3325,868@38369L3584:TabRow.kt#uh7d8r");
                                        if ((i102 & 3) != 2 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1178901494, i102, -1, "androidx.compose.material3.ScrollableTabRowImp.<anonymous> (TabRow.kt:861)");
                                            }
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
                                            composer3.startReplaceableGroup(121290627);
                                            ComposerKt.sourceInformation(composer3, "CC(remember):TabRow.kt#9igjgp");
                                            boolean changed = composer3.changed(ScrollState.this) | composer3.changed(coroutineScope);
                                            ScrollState scrollState2 = ScrollState.this;
                                            Object rememberedValue2 = composer3.rememberedValue();
                                            if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue2 = new ScrollableTabData(scrollState2, coroutineScope);
                                                composer3.updateRememberedValue(rememberedValue2);
                                            }
                                            final ScrollableTabData scrollableTabData = (ScrollableTabData) rememberedValue2;
                                            composer3.endReplaceableGroup();
                                            Modifier clipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getCenterStart(), false, 2, null), ScrollState.this, false, null, false, 14, null)));
                                            composer3.startReplaceableGroup(121291080);
                                            ComposerKt.sourceInformation(composer3, "CC(remember):TabRow.kt#9igjgp");
                                            boolean changed2 = composer3.changed(f42) | composer3.changed(function22) | composer3.changed(function242) | composer3.changed(function332) | composer3.changedInstance(scrollableTabData) | composer3.changed(i);
                                            final float f5 = f42;
                                            final Function2<? super Composer, ? super Integer, Unit> function25 = function22;
                                            final Function2<? super Composer, ? super Integer, Unit> function26 = function242;
                                            final int i112 = i;
                                            final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function34 = function332;
                                            Object rememberedValue3 = composer3.rememberedValue();
                                            if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue3 = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1$1$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                                        return m2694invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                                                    }

                                                    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                                                    public final MeasureResult m2694invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, final long j9) {
                                                        float f6;
                                                        f6 = TabRowKt.ScrollableTabRowMinimumTabWidth;
                                                        int i12 = subcomposeMeasureScope.mo624roundToPx0680j_4(f6);
                                                        final int i13 = subcomposeMeasureScope.mo624roundToPx0680j_4(f5);
                                                        List<Measurable> subcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function25);
                                                        int i14 = 0;
                                                        int size = subcompose.size();
                                                        for (int i15 = 0; i15 < size; i15++) {
                                                            i14 = Integer.valueOf(Math.max(i14.intValue(), subcompose.get(i15).maxIntrinsicHeight(Integer.MAX_VALUE)));
                                                        }
                                                        final int intValue = i14.intValue();
                                                        long m6336copyZbe2FdA$default = Constraints.m6336copyZbe2FdA$default(j9, i12, 0, intValue, intValue, 2, null);
                                                        final List<Placeable> arrayList = new ArrayList();
                                                        final List<Dp> arrayList2 = new ArrayList();
                                                        int size2 = subcompose.size();
                                                        for (int i16 = 0; i16 < size2; i16++) {
                                                            Measurable measurable = subcompose.get(i16);
                                                            Placeable mo5333measureBRTryo0 = measurable.mo5333measureBRTryo0(m6336copyZbe2FdA$default);
                                                            float m6389constructorimpl = Dp.m6389constructorimpl(subcomposeMeasureScope.mo627toDpu2uoSUM(Math.min(measurable.maxIntrinsicWidth(mo5333measureBRTryo0.getHeight()), mo5333measureBRTryo0.getWidth())) - Dp.m6389constructorimpl(TabKt.getHorizontalTextPadding() * 2));
                                                            arrayList.add(mo5333measureBRTryo0);
                                                            arrayList2.add(Dp.m6387boximpl(m6389constructorimpl));
                                                        }
                                                        Integer valueOf = Integer.valueOf(i13 * 2);
                                                        int size3 = arrayList.size();
                                                        for (int i17 = 0; i17 < size3; i17++) {
                                                            valueOf = Integer.valueOf(valueOf.intValue() + ((Placeable) arrayList.get(i17)).getWidth());
                                                        }
                                                        final int intValue2 = valueOf.intValue();
                                                        final Function2<? super Composer, ? super Integer, Unit> function27 = function26;
                                                        final ScrollableTabData scrollableTabData2 = scrollableTabData;
                                                        final int i18 = i112;
                                                        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function35 = function34;
                                                        return MeasureScope.layout$default(subcomposeMeasureScope, intValue2, intValue, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1$1$1.2
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
                                                                int i19 = i13;
                                                                List<Placeable> list = arrayList;
                                                                SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                                                List<Dp> list2 = arrayList2;
                                                                int size4 = list.size();
                                                                int i20 = i19;
                                                                for (int i21 = 0; i21 < size4; i21++) {
                                                                    Placeable placeable = list.get(i21);
                                                                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable, i20, 0, 0.0f, 4, null);
                                                                    arrayList3.add(new TabPosition(subcomposeMeasureScope2.mo627toDpu2uoSUM(i20), subcomposeMeasureScope2.mo627toDpu2uoSUM(placeable.getWidth()), list2.get(i21).m6403unboximpl(), null));
                                                                    i20 += placeable.getWidth();
                                                                }
                                                                List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Divider, function27);
                                                                long j10 = j9;
                                                                int i22 = intValue2;
                                                                int i23 = intValue;
                                                                int size5 = subcompose2.size();
                                                                for (int i24 = 0; i24 < size5; i24++) {
                                                                    Placeable mo5333measureBRTryo02 = subcompose2.get(i24).mo5333measureBRTryo0(Constraints.m6336copyZbe2FdA$default(j10, i22, i22, 0, 0, 8, null));
                                                                    Placeable.PlacementScope.placeRelative$default(placementScope, mo5333measureBRTryo02, 0, i23 - mo5333measureBRTryo02.getHeight(), 0.0f, 4, null);
                                                                }
                                                                SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope;
                                                                TabSlots tabSlots = TabSlots.Indicator;
                                                                final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function36 = function35;
                                                                List<Measurable> subcompose3 = subcomposeMeasureScope3.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(358596038, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt.ScrollableTabRowImp.1.1.1.2.3
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

                                                                    public final void invoke(Composer composer4, int i25) {
                                                                        ComposerKt.sourceInformation(composer4, "C942@41500L23:TabRow.kt#uh7d8r");
                                                                        if ((i25 & 3) == 2 && composer4.getSkipping()) {
                                                                            composer4.skipToGroupEnd();
                                                                            return;
                                                                        }
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(358596038, i25, -1, "androidx.compose.material3.ScrollableTabRowImp.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:942)");
                                                                        }
                                                                        function36.invoke(arrayList3, composer4, 0);
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                        }
                                                                    }
                                                                }));
                                                                int i25 = intValue2;
                                                                int i26 = intValue;
                                                                int size6 = subcompose3.size();
                                                                for (int i27 = 0; i27 < size6; i27++) {
                                                                    Placeable.PlacementScope.placeRelative$default(placementScope, subcompose3.get(i27).mo5333measureBRTryo0(Constraints.INSTANCE.m6353fixedJhjzzOo(i25, i26)), 0, 0, 0.0f, 4, null);
                                                                }
                                                                scrollableTabData2.onLaidOut(subcomposeMeasureScope, i13, arrayList3, i18);
                                                            }
                                                        }, 4, null);
                                                    }
                                                };
                                                composer3.updateRememberedValue(rememberedValue3);
                                            }
                                            composer3.endReplaceableGroup();
                                            SubcomposeLayoutKt.SubcomposeLayout(clipToBounds, (Function2) rememberedValue3, composer3, 0, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                });
                                int i102 = ((i4 >> 6) & 14) | 12582912;
                                int i112 = i4 >> 3;
                                composer2 = startRestartGroup;
                                SurfaceKt.m2633SurfaceT9BRK9s(modifier42, null, j82, j72, 0.0f, 0.0f, null, composableLambda2, composer2, i102 | (i112 & 896) | (i112 & 7168), 114);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                f3 = f42;
                                function23 = function242;
                                modifier3 = modifier42;
                                j5 = j82;
                                j6 = j72;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                composer2 = startRestartGroup;
                                modifier3 = modifier2;
                                j5 = j3;
                                j6 = j4;
                                f3 = f2;
                                function23 = function2;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$2
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

                                    public final void invoke(Composer composer3, int i12) {
                                        TabRowKt.m2685ScrollableTabRowImpqhFBPw4(i, function3, modifier3, j5, j6, f3, function23, function22, scrollState, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if ((i4 & 38347923) == 38347922) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if ((i3 & 8) != 0) {
                        }
                        if ((i3 & 16) != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if (i7 != 0) {
                        }
                        m2098getLambda7$material3_release = function2;
                        long j722 = j4;
                        final float f422 = f2;
                        Modifier modifier422 = modifier2;
                        long j822 = j3;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        final Function2<? super Composer, ? super Integer, Unit> function2422 = m2098getLambda7$material3_release;
                        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3322 = function32;
                        ComposableLambda composableLambda22 = ComposableLambdaKt.composableLambda(startRestartGroup, -1178901494, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1
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

                            public final void invoke(Composer composer3, int i1022) {
                                ComposerKt.sourceInformation(composer3, "C861@38118L24,862@38175L185,875@38628L3325,868@38369L3584:TabRow.kt#uh7d8r");
                                if ((i1022 & 3) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1178901494, i1022, -1, "androidx.compose.material3.ScrollableTabRowImp.<anonymous> (TabRow.kt:861)");
                                    }
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
                                    composer3.startReplaceableGroup(121290627);
                                    ComposerKt.sourceInformation(composer3, "CC(remember):TabRow.kt#9igjgp");
                                    boolean changed = composer3.changed(ScrollState.this) | composer3.changed(coroutineScope);
                                    ScrollState scrollState2 = ScrollState.this;
                                    Object rememberedValue2 = composer3.rememberedValue();
                                    if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue2 = new ScrollableTabData(scrollState2, coroutineScope);
                                        composer3.updateRememberedValue(rememberedValue2);
                                    }
                                    final ScrollableTabData scrollableTabData = (ScrollableTabData) rememberedValue2;
                                    composer3.endReplaceableGroup();
                                    Modifier clipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getCenterStart(), false, 2, null), ScrollState.this, false, null, false, 14, null)));
                                    composer3.startReplaceableGroup(121291080);
                                    ComposerKt.sourceInformation(composer3, "CC(remember):TabRow.kt#9igjgp");
                                    boolean changed2 = composer3.changed(f422) | composer3.changed(function22) | composer3.changed(function2422) | composer3.changed(function3322) | composer3.changedInstance(scrollableTabData) | composer3.changed(i);
                                    final float f5 = f422;
                                    final Function2<? super Composer, ? super Integer, Unit> function25 = function22;
                                    final Function2<? super Composer, ? super Integer, Unit> function26 = function2422;
                                    final int i1122 = i;
                                    final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function34 = function3322;
                                    Object rememberedValue3 = composer3.rememberedValue();
                                    if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue3 = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                                return m2694invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                                            }

                                            /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                                            public final MeasureResult m2694invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, final long j9) {
                                                float f6;
                                                f6 = TabRowKt.ScrollableTabRowMinimumTabWidth;
                                                int i12 = subcomposeMeasureScope.mo624roundToPx0680j_4(f6);
                                                final int i13 = subcomposeMeasureScope.mo624roundToPx0680j_4(f5);
                                                List<Measurable> subcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function25);
                                                int i14 = 0;
                                                int size = subcompose.size();
                                                for (int i15 = 0; i15 < size; i15++) {
                                                    i14 = Integer.valueOf(Math.max(i14.intValue(), subcompose.get(i15).maxIntrinsicHeight(Integer.MAX_VALUE)));
                                                }
                                                final int intValue = i14.intValue();
                                                long m6336copyZbe2FdA$default = Constraints.m6336copyZbe2FdA$default(j9, i12, 0, intValue, intValue, 2, null);
                                                final List<Placeable> arrayList = new ArrayList();
                                                final List<Dp> arrayList2 = new ArrayList();
                                                int size2 = subcompose.size();
                                                for (int i16 = 0; i16 < size2; i16++) {
                                                    Measurable measurable = subcompose.get(i16);
                                                    Placeable mo5333measureBRTryo0 = measurable.mo5333measureBRTryo0(m6336copyZbe2FdA$default);
                                                    float m6389constructorimpl = Dp.m6389constructorimpl(subcomposeMeasureScope.mo627toDpu2uoSUM(Math.min(measurable.maxIntrinsicWidth(mo5333measureBRTryo0.getHeight()), mo5333measureBRTryo0.getWidth())) - Dp.m6389constructorimpl(TabKt.getHorizontalTextPadding() * 2));
                                                    arrayList.add(mo5333measureBRTryo0);
                                                    arrayList2.add(Dp.m6387boximpl(m6389constructorimpl));
                                                }
                                                Integer valueOf = Integer.valueOf(i13 * 2);
                                                int size3 = arrayList.size();
                                                for (int i17 = 0; i17 < size3; i17++) {
                                                    valueOf = Integer.valueOf(valueOf.intValue() + ((Placeable) arrayList.get(i17)).getWidth());
                                                }
                                                final int intValue2 = valueOf.intValue();
                                                final Function2<? super Composer, ? super Integer, Unit> function27 = function26;
                                                final ScrollableTabData scrollableTabData2 = scrollableTabData;
                                                final int i18 = i1122;
                                                final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function35 = function34;
                                                return MeasureScope.layout$default(subcomposeMeasureScope, intValue2, intValue, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1$1$1.2
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
                                                        int i19 = i13;
                                                        List<Placeable> list = arrayList;
                                                        SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                                        List<Dp> list2 = arrayList2;
                                                        int size4 = list.size();
                                                        int i20 = i19;
                                                        for (int i21 = 0; i21 < size4; i21++) {
                                                            Placeable placeable = list.get(i21);
                                                            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, i20, 0, 0.0f, 4, null);
                                                            arrayList3.add(new TabPosition(subcomposeMeasureScope2.mo627toDpu2uoSUM(i20), subcomposeMeasureScope2.mo627toDpu2uoSUM(placeable.getWidth()), list2.get(i21).m6403unboximpl(), null));
                                                            i20 += placeable.getWidth();
                                                        }
                                                        List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Divider, function27);
                                                        long j10 = j9;
                                                        int i22 = intValue2;
                                                        int i23 = intValue;
                                                        int size5 = subcompose2.size();
                                                        for (int i24 = 0; i24 < size5; i24++) {
                                                            Placeable mo5333measureBRTryo02 = subcompose2.get(i24).mo5333measureBRTryo0(Constraints.m6336copyZbe2FdA$default(j10, i22, i22, 0, 0, 8, null));
                                                            Placeable.PlacementScope.placeRelative$default(placementScope, mo5333measureBRTryo02, 0, i23 - mo5333measureBRTryo02.getHeight(), 0.0f, 4, null);
                                                        }
                                                        SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope;
                                                        TabSlots tabSlots = TabSlots.Indicator;
                                                        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function36 = function35;
                                                        List<Measurable> subcompose3 = subcomposeMeasureScope3.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(358596038, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt.ScrollableTabRowImp.1.1.1.2.3
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

                                                            public final void invoke(Composer composer4, int i25) {
                                                                ComposerKt.sourceInformation(composer4, "C942@41500L23:TabRow.kt#uh7d8r");
                                                                if ((i25 & 3) == 2 && composer4.getSkipping()) {
                                                                    composer4.skipToGroupEnd();
                                                                    return;
                                                                }
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(358596038, i25, -1, "androidx.compose.material3.ScrollableTabRowImp.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:942)");
                                                                }
                                                                function36.invoke(arrayList3, composer4, 0);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                        }));
                                                        int i25 = intValue2;
                                                        int i26 = intValue;
                                                        int size6 = subcompose3.size();
                                                        for (int i27 = 0; i27 < size6; i27++) {
                                                            Placeable.PlacementScope.placeRelative$default(placementScope, subcompose3.get(i27).mo5333measureBRTryo0(Constraints.INSTANCE.m6353fixedJhjzzOo(i25, i26)), 0, 0, 0.0f, 4, null);
                                                        }
                                                        scrollableTabData2.onLaidOut(subcomposeMeasureScope, i13, arrayList3, i18);
                                                    }
                                                }, 4, null);
                                            }
                                        };
                                        composer3.updateRememberedValue(rememberedValue3);
                                    }
                                    composer3.endReplaceableGroup();
                                    SubcomposeLayoutKt.SubcomposeLayout(clipToBounds, (Function2) rememberedValue3, composer3, 0, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        });
                        int i1022 = ((i4 >> 6) & 14) | 12582912;
                        int i1122 = i4 >> 3;
                        composer2 = startRestartGroup;
                        SurfaceKt.m2633SurfaceT9BRK9s(modifier422, null, j822, j722, 0.0f, 0.0f, null, composableLambda22, composer2, i1022 | (i1122 & 896) | (i1122 & 7168), 114);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        f3 = f422;
                        function23 = function2422;
                        modifier3 = modifier422;
                        j5 = j822;
                        j6 = j722;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    if ((i3 & 256) != 0) {
                    }
                    if ((i4 & 38347923) == 38347922) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i3 & 8) != 0) {
                    }
                    if ((i3 & 16) != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    m2098getLambda7$material3_release = function2;
                    long j7222 = j4;
                    final float f4222 = f2;
                    Modifier modifier4222 = modifier2;
                    long j8222 = j3;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    final Function2<? super Composer, ? super Integer, Unit> function24222 = m2098getLambda7$material3_release;
                    final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function33222 = function32;
                    ComposableLambda composableLambda222 = ComposableLambdaKt.composableLambda(startRestartGroup, -1178901494, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1
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

                        public final void invoke(Composer composer3, int i10222) {
                            ComposerKt.sourceInformation(composer3, "C861@38118L24,862@38175L185,875@38628L3325,868@38369L3584:TabRow.kt#uh7d8r");
                            if ((i10222 & 3) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1178901494, i10222, -1, "androidx.compose.material3.ScrollableTabRowImp.<anonymous> (TabRow.kt:861)");
                                }
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
                                composer3.startReplaceableGroup(121290627);
                                ComposerKt.sourceInformation(composer3, "CC(remember):TabRow.kt#9igjgp");
                                boolean changed = composer3.changed(ScrollState.this) | composer3.changed(coroutineScope);
                                ScrollState scrollState2 = ScrollState.this;
                                Object rememberedValue2 = composer3.rememberedValue();
                                if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue2 = new ScrollableTabData(scrollState2, coroutineScope);
                                    composer3.updateRememberedValue(rememberedValue2);
                                }
                                final ScrollableTabData scrollableTabData = (ScrollableTabData) rememberedValue2;
                                composer3.endReplaceableGroup();
                                Modifier clipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getCenterStart(), false, 2, null), ScrollState.this, false, null, false, 14, null)));
                                composer3.startReplaceableGroup(121291080);
                                ComposerKt.sourceInformation(composer3, "CC(remember):TabRow.kt#9igjgp");
                                boolean changed2 = composer3.changed(f4222) | composer3.changed(function22) | composer3.changed(function24222) | composer3.changed(function33222) | composer3.changedInstance(scrollableTabData) | composer3.changed(i);
                                final float f5 = f4222;
                                final Function2<? super Composer, ? super Integer, Unit> function25 = function22;
                                final Function2<? super Composer, ? super Integer, Unit> function26 = function24222;
                                final int i11222 = i;
                                final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function34 = function33222;
                                Object rememberedValue3 = composer3.rememberedValue();
                                if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue3 = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                            return m2694invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                                        }

                                        /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                                        public final MeasureResult m2694invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, final long j9) {
                                            float f6;
                                            f6 = TabRowKt.ScrollableTabRowMinimumTabWidth;
                                            int i12 = subcomposeMeasureScope.mo624roundToPx0680j_4(f6);
                                            final int i13 = subcomposeMeasureScope.mo624roundToPx0680j_4(f5);
                                            List<Measurable> subcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function25);
                                            int i14 = 0;
                                            int size = subcompose.size();
                                            for (int i15 = 0; i15 < size; i15++) {
                                                i14 = Integer.valueOf(Math.max(i14.intValue(), subcompose.get(i15).maxIntrinsicHeight(Integer.MAX_VALUE)));
                                            }
                                            final int intValue = i14.intValue();
                                            long m6336copyZbe2FdA$default = Constraints.m6336copyZbe2FdA$default(j9, i12, 0, intValue, intValue, 2, null);
                                            final List<Placeable> arrayList = new ArrayList();
                                            final List<Dp> arrayList2 = new ArrayList();
                                            int size2 = subcompose.size();
                                            for (int i16 = 0; i16 < size2; i16++) {
                                                Measurable measurable = subcompose.get(i16);
                                                Placeable mo5333measureBRTryo0 = measurable.mo5333measureBRTryo0(m6336copyZbe2FdA$default);
                                                float m6389constructorimpl = Dp.m6389constructorimpl(subcomposeMeasureScope.mo627toDpu2uoSUM(Math.min(measurable.maxIntrinsicWidth(mo5333measureBRTryo0.getHeight()), mo5333measureBRTryo0.getWidth())) - Dp.m6389constructorimpl(TabKt.getHorizontalTextPadding() * 2));
                                                arrayList.add(mo5333measureBRTryo0);
                                                arrayList2.add(Dp.m6387boximpl(m6389constructorimpl));
                                            }
                                            Integer valueOf = Integer.valueOf(i13 * 2);
                                            int size3 = arrayList.size();
                                            for (int i17 = 0; i17 < size3; i17++) {
                                                valueOf = Integer.valueOf(valueOf.intValue() + ((Placeable) arrayList.get(i17)).getWidth());
                                            }
                                            final int intValue2 = valueOf.intValue();
                                            final Function2<? super Composer, ? super Integer, Unit> function27 = function26;
                                            final ScrollableTabData scrollableTabData2 = scrollableTabData;
                                            final int i18 = i11222;
                                            final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function35 = function34;
                                            return MeasureScope.layout$default(subcomposeMeasureScope, intValue2, intValue, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1$1$1.2
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
                                                    int i19 = i13;
                                                    List<Placeable> list = arrayList;
                                                    SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                                    List<Dp> list2 = arrayList2;
                                                    int size4 = list.size();
                                                    int i20 = i19;
                                                    for (int i21 = 0; i21 < size4; i21++) {
                                                        Placeable placeable = list.get(i21);
                                                        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, i20, 0, 0.0f, 4, null);
                                                        arrayList3.add(new TabPosition(subcomposeMeasureScope2.mo627toDpu2uoSUM(i20), subcomposeMeasureScope2.mo627toDpu2uoSUM(placeable.getWidth()), list2.get(i21).m6403unboximpl(), null));
                                                        i20 += placeable.getWidth();
                                                    }
                                                    List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Divider, function27);
                                                    long j10 = j9;
                                                    int i22 = intValue2;
                                                    int i23 = intValue;
                                                    int size5 = subcompose2.size();
                                                    for (int i24 = 0; i24 < size5; i24++) {
                                                        Placeable mo5333measureBRTryo02 = subcompose2.get(i24).mo5333measureBRTryo0(Constraints.m6336copyZbe2FdA$default(j10, i22, i22, 0, 0, 8, null));
                                                        Placeable.PlacementScope.placeRelative$default(placementScope, mo5333measureBRTryo02, 0, i23 - mo5333measureBRTryo02.getHeight(), 0.0f, 4, null);
                                                    }
                                                    SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope;
                                                    TabSlots tabSlots = TabSlots.Indicator;
                                                    final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function36 = function35;
                                                    List<Measurable> subcompose3 = subcomposeMeasureScope3.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(358596038, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt.ScrollableTabRowImp.1.1.1.2.3
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

                                                        public final void invoke(Composer composer4, int i25) {
                                                            ComposerKt.sourceInformation(composer4, "C942@41500L23:TabRow.kt#uh7d8r");
                                                            if ((i25 & 3) == 2 && composer4.getSkipping()) {
                                                                composer4.skipToGroupEnd();
                                                                return;
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(358596038, i25, -1, "androidx.compose.material3.ScrollableTabRowImp.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:942)");
                                                            }
                                                            function36.invoke(arrayList3, composer4, 0);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                    }));
                                                    int i25 = intValue2;
                                                    int i26 = intValue;
                                                    int size6 = subcompose3.size();
                                                    for (int i27 = 0; i27 < size6; i27++) {
                                                        Placeable.PlacementScope.placeRelative$default(placementScope, subcompose3.get(i27).mo5333measureBRTryo0(Constraints.INSTANCE.m6353fixedJhjzzOo(i25, i26)), 0, 0, 0.0f, 4, null);
                                                    }
                                                    scrollableTabData2.onLaidOut(subcomposeMeasureScope, i13, arrayList3, i18);
                                                }
                                            }, 4, null);
                                        }
                                    };
                                    composer3.updateRememberedValue(rememberedValue3);
                                }
                                composer3.endReplaceableGroup();
                                SubcomposeLayoutKt.SubcomposeLayout(clipToBounds, (Function2) rememberedValue3, composer3, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    });
                    int i10222 = ((i4 >> 6) & 14) | 12582912;
                    int i11222 = i4 >> 3;
                    composer2 = startRestartGroup;
                    SurfaceKt.m2633SurfaceT9BRK9s(modifier4222, null, j8222, j7222, 0.0f, 0.0f, null, composableLambda222, composer2, i10222 | (i11222 & 896) | (i11222 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    f3 = f4222;
                    function23 = function24222;
                    modifier3 = modifier4222;
                    j5 = j8222;
                    j6 = j7222;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                f2 = f;
                i7 = i3 & 64;
                if (i7 == 0) {
                }
                if ((i3 & 128) == 0) {
                }
                if ((i3 & 256) != 0) {
                }
                if ((i4 & 38347923) == 38347922) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i5 != 0) {
                }
                if ((i3 & 8) != 0) {
                }
                if ((i3 & 16) != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                m2098getLambda7$material3_release = function2;
                long j72222 = j4;
                final float f42222 = f2;
                Modifier modifier42222 = modifier2;
                long j82222 = j3;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                final Function2<? super Composer, ? super Integer, Unit> function242222 = m2098getLambda7$material3_release;
                final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function332222 = function32;
                ComposableLambda composableLambda2222 = ComposableLambdaKt.composableLambda(startRestartGroup, -1178901494, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1
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

                    public final void invoke(Composer composer3, int i102222) {
                        ComposerKt.sourceInformation(composer3, "C861@38118L24,862@38175L185,875@38628L3325,868@38369L3584:TabRow.kt#uh7d8r");
                        if ((i102222 & 3) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1178901494, i102222, -1, "androidx.compose.material3.ScrollableTabRowImp.<anonymous> (TabRow.kt:861)");
                            }
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
                            composer3.startReplaceableGroup(121290627);
                            ComposerKt.sourceInformation(composer3, "CC(remember):TabRow.kt#9igjgp");
                            boolean changed = composer3.changed(ScrollState.this) | composer3.changed(coroutineScope);
                            ScrollState scrollState2 = ScrollState.this;
                            Object rememberedValue2 = composer3.rememberedValue();
                            if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue2 = new ScrollableTabData(scrollState2, coroutineScope);
                                composer3.updateRememberedValue(rememberedValue2);
                            }
                            final ScrollableTabData scrollableTabData = (ScrollableTabData) rememberedValue2;
                            composer3.endReplaceableGroup();
                            Modifier clipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getCenterStart(), false, 2, null), ScrollState.this, false, null, false, 14, null)));
                            composer3.startReplaceableGroup(121291080);
                            ComposerKt.sourceInformation(composer3, "CC(remember):TabRow.kt#9igjgp");
                            boolean changed2 = composer3.changed(f42222) | composer3.changed(function22) | composer3.changed(function242222) | composer3.changed(function332222) | composer3.changedInstance(scrollableTabData) | composer3.changed(i);
                            final float f5 = f42222;
                            final Function2<? super Composer, ? super Integer, Unit> function25 = function22;
                            final Function2<? super Composer, ? super Integer, Unit> function26 = function242222;
                            final int i112222 = i;
                            final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function34 = function332222;
                            Object rememberedValue3 = composer3.rememberedValue();
                            if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue3 = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                        return m2694invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                                    }

                                    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                                    public final MeasureResult m2694invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, final long j9) {
                                        float f6;
                                        f6 = TabRowKt.ScrollableTabRowMinimumTabWidth;
                                        int i12 = subcomposeMeasureScope.mo624roundToPx0680j_4(f6);
                                        final int i13 = subcomposeMeasureScope.mo624roundToPx0680j_4(f5);
                                        List<Measurable> subcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function25);
                                        int i14 = 0;
                                        int size = subcompose.size();
                                        for (int i15 = 0; i15 < size; i15++) {
                                            i14 = Integer.valueOf(Math.max(i14.intValue(), subcompose.get(i15).maxIntrinsicHeight(Integer.MAX_VALUE)));
                                        }
                                        final int intValue = i14.intValue();
                                        long m6336copyZbe2FdA$default = Constraints.m6336copyZbe2FdA$default(j9, i12, 0, intValue, intValue, 2, null);
                                        final List<Placeable> arrayList = new ArrayList();
                                        final List<Dp> arrayList2 = new ArrayList();
                                        int size2 = subcompose.size();
                                        for (int i16 = 0; i16 < size2; i16++) {
                                            Measurable measurable = subcompose.get(i16);
                                            Placeable mo5333measureBRTryo0 = measurable.mo5333measureBRTryo0(m6336copyZbe2FdA$default);
                                            float m6389constructorimpl = Dp.m6389constructorimpl(subcomposeMeasureScope.mo627toDpu2uoSUM(Math.min(measurable.maxIntrinsicWidth(mo5333measureBRTryo0.getHeight()), mo5333measureBRTryo0.getWidth())) - Dp.m6389constructorimpl(TabKt.getHorizontalTextPadding() * 2));
                                            arrayList.add(mo5333measureBRTryo0);
                                            arrayList2.add(Dp.m6387boximpl(m6389constructorimpl));
                                        }
                                        Integer valueOf = Integer.valueOf(i13 * 2);
                                        int size3 = arrayList.size();
                                        for (int i17 = 0; i17 < size3; i17++) {
                                            valueOf = Integer.valueOf(valueOf.intValue() + ((Placeable) arrayList.get(i17)).getWidth());
                                        }
                                        final int intValue2 = valueOf.intValue();
                                        final Function2<? super Composer, ? super Integer, Unit> function27 = function26;
                                        final ScrollableTabData scrollableTabData2 = scrollableTabData;
                                        final int i18 = i112222;
                                        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function35 = function34;
                                        return MeasureScope.layout$default(subcomposeMeasureScope, intValue2, intValue, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1$1$1.2
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
                                                int i19 = i13;
                                                List<Placeable> list = arrayList;
                                                SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                                List<Dp> list2 = arrayList2;
                                                int size4 = list.size();
                                                int i20 = i19;
                                                for (int i21 = 0; i21 < size4; i21++) {
                                                    Placeable placeable = list.get(i21);
                                                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable, i20, 0, 0.0f, 4, null);
                                                    arrayList3.add(new TabPosition(subcomposeMeasureScope2.mo627toDpu2uoSUM(i20), subcomposeMeasureScope2.mo627toDpu2uoSUM(placeable.getWidth()), list2.get(i21).m6403unboximpl(), null));
                                                    i20 += placeable.getWidth();
                                                }
                                                List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Divider, function27);
                                                long j10 = j9;
                                                int i22 = intValue2;
                                                int i23 = intValue;
                                                int size5 = subcompose2.size();
                                                for (int i24 = 0; i24 < size5; i24++) {
                                                    Placeable mo5333measureBRTryo02 = subcompose2.get(i24).mo5333measureBRTryo0(Constraints.m6336copyZbe2FdA$default(j10, i22, i22, 0, 0, 8, null));
                                                    Placeable.PlacementScope.placeRelative$default(placementScope, mo5333measureBRTryo02, 0, i23 - mo5333measureBRTryo02.getHeight(), 0.0f, 4, null);
                                                }
                                                SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope;
                                                TabSlots tabSlots = TabSlots.Indicator;
                                                final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function36 = function35;
                                                List<Measurable> subcompose3 = subcomposeMeasureScope3.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(358596038, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt.ScrollableTabRowImp.1.1.1.2.3
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

                                                    public final void invoke(Composer composer4, int i25) {
                                                        ComposerKt.sourceInformation(composer4, "C942@41500L23:TabRow.kt#uh7d8r");
                                                        if ((i25 & 3) == 2 && composer4.getSkipping()) {
                                                            composer4.skipToGroupEnd();
                                                            return;
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(358596038, i25, -1, "androidx.compose.material3.ScrollableTabRowImp.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:942)");
                                                        }
                                                        function36.invoke(arrayList3, composer4, 0);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }));
                                                int i25 = intValue2;
                                                int i26 = intValue;
                                                int size6 = subcompose3.size();
                                                for (int i27 = 0; i27 < size6; i27++) {
                                                    Placeable.PlacementScope.placeRelative$default(placementScope, subcompose3.get(i27).mo5333measureBRTryo0(Constraints.INSTANCE.m6353fixedJhjzzOo(i25, i26)), 0, 0, 0.0f, 4, null);
                                                }
                                                scrollableTabData2.onLaidOut(subcomposeMeasureScope, i13, arrayList3, i18);
                                            }
                                        }, 4, null);
                                    }
                                };
                                composer3.updateRememberedValue(rememberedValue3);
                            }
                            composer3.endReplaceableGroup();
                            SubcomposeLayoutKt.SubcomposeLayout(clipToBounds, (Function2) rememberedValue3, composer3, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                });
                int i102222 = ((i4 >> 6) & 14) | 12582912;
                int i112222 = i4 >> 3;
                composer2 = startRestartGroup;
                SurfaceKt.m2633SurfaceT9BRK9s(modifier42222, null, j82222, j72222, 0.0f, 0.0f, null, composableLambda2222, composer2, i102222 | (i112222 & 896) | (i112222 & 7168), 114);
                if (ComposerKt.isTraceInProgress()) {
                }
                f3 = f42222;
                function23 = function242222;
                modifier3 = modifier42222;
                j5 = j82222;
                j6 = j72222;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            modifier2 = modifier;
            if ((i2 & 3072) == 0) {
            }
            if ((i2 & 24576) == 0) {
            }
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            f2 = f;
            i7 = i3 & 64;
            if (i7 == 0) {
            }
            if ((i3 & 128) == 0) {
            }
            if ((i3 & 256) != 0) {
            }
            if ((i4 & 38347923) == 38347922) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i5 != 0) {
            }
            if ((i3 & 8) != 0) {
            }
            if ((i3 & 16) != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            m2098getLambda7$material3_release = function2;
            long j722222 = j4;
            final float f422222 = f2;
            Modifier modifier422222 = modifier2;
            long j822222 = j3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            final Function2<? super Composer, ? super Integer, Unit> function2422222 = m2098getLambda7$material3_release;
            final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3322222 = function32;
            ComposableLambda composableLambda22222 = ComposableLambdaKt.composableLambda(startRestartGroup, -1178901494, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1
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

                public final void invoke(Composer composer3, int i1022222) {
                    ComposerKt.sourceInformation(composer3, "C861@38118L24,862@38175L185,875@38628L3325,868@38369L3584:TabRow.kt#uh7d8r");
                    if ((i1022222 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1178901494, i1022222, -1, "androidx.compose.material3.ScrollableTabRowImp.<anonymous> (TabRow.kt:861)");
                        }
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
                        composer3.startReplaceableGroup(121290627);
                        ComposerKt.sourceInformation(composer3, "CC(remember):TabRow.kt#9igjgp");
                        boolean changed = composer3.changed(ScrollState.this) | composer3.changed(coroutineScope);
                        ScrollState scrollState2 = ScrollState.this;
                        Object rememberedValue2 = composer3.rememberedValue();
                        if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = new ScrollableTabData(scrollState2, coroutineScope);
                            composer3.updateRememberedValue(rememberedValue2);
                        }
                        final ScrollableTabData scrollableTabData = (ScrollableTabData) rememberedValue2;
                        composer3.endReplaceableGroup();
                        Modifier clipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getCenterStart(), false, 2, null), ScrollState.this, false, null, false, 14, null)));
                        composer3.startReplaceableGroup(121291080);
                        ComposerKt.sourceInformation(composer3, "CC(remember):TabRow.kt#9igjgp");
                        boolean changed2 = composer3.changed(f422222) | composer3.changed(function22) | composer3.changed(function2422222) | composer3.changed(function3322222) | composer3.changedInstance(scrollableTabData) | composer3.changed(i);
                        final float f5 = f422222;
                        final Function2<? super Composer, ? super Integer, Unit> function25 = function22;
                        final Function2<? super Composer, ? super Integer, Unit> function26 = function2422222;
                        final int i1122222 = i;
                        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function34 = function3322222;
                        Object rememberedValue3 = composer3.rememberedValue();
                        if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue3 = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                    return m2694invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                                }

                                /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                                public final MeasureResult m2694invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, final long j9) {
                                    float f6;
                                    f6 = TabRowKt.ScrollableTabRowMinimumTabWidth;
                                    int i12 = subcomposeMeasureScope.mo624roundToPx0680j_4(f6);
                                    final int i13 = subcomposeMeasureScope.mo624roundToPx0680j_4(f5);
                                    List<Measurable> subcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function25);
                                    int i14 = 0;
                                    int size = subcompose.size();
                                    for (int i15 = 0; i15 < size; i15++) {
                                        i14 = Integer.valueOf(Math.max(i14.intValue(), subcompose.get(i15).maxIntrinsicHeight(Integer.MAX_VALUE)));
                                    }
                                    final int intValue = i14.intValue();
                                    long m6336copyZbe2FdA$default = Constraints.m6336copyZbe2FdA$default(j9, i12, 0, intValue, intValue, 2, null);
                                    final List<Placeable> arrayList = new ArrayList();
                                    final List<Dp> arrayList2 = new ArrayList();
                                    int size2 = subcompose.size();
                                    for (int i16 = 0; i16 < size2; i16++) {
                                        Measurable measurable = subcompose.get(i16);
                                        Placeable mo5333measureBRTryo0 = measurable.mo5333measureBRTryo0(m6336copyZbe2FdA$default);
                                        float m6389constructorimpl = Dp.m6389constructorimpl(subcomposeMeasureScope.mo627toDpu2uoSUM(Math.min(measurable.maxIntrinsicWidth(mo5333measureBRTryo0.getHeight()), mo5333measureBRTryo0.getWidth())) - Dp.m6389constructorimpl(TabKt.getHorizontalTextPadding() * 2));
                                        arrayList.add(mo5333measureBRTryo0);
                                        arrayList2.add(Dp.m6387boximpl(m6389constructorimpl));
                                    }
                                    Integer valueOf = Integer.valueOf(i13 * 2);
                                    int size3 = arrayList.size();
                                    for (int i17 = 0; i17 < size3; i17++) {
                                        valueOf = Integer.valueOf(valueOf.intValue() + ((Placeable) arrayList.get(i17)).getWidth());
                                    }
                                    final int intValue2 = valueOf.intValue();
                                    final Function2<? super Composer, ? super Integer, Unit> function27 = function26;
                                    final ScrollableTabData scrollableTabData2 = scrollableTabData;
                                    final int i18 = i1122222;
                                    final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function35 = function34;
                                    return MeasureScope.layout$default(subcomposeMeasureScope, intValue2, intValue, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1$1$1.2
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
                                            int i19 = i13;
                                            List<Placeable> list = arrayList;
                                            SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                            List<Dp> list2 = arrayList2;
                                            int size4 = list.size();
                                            int i20 = i19;
                                            for (int i21 = 0; i21 < size4; i21++) {
                                                Placeable placeable = list.get(i21);
                                                Placeable.PlacementScope.placeRelative$default(placementScope, placeable, i20, 0, 0.0f, 4, null);
                                                arrayList3.add(new TabPosition(subcomposeMeasureScope2.mo627toDpu2uoSUM(i20), subcomposeMeasureScope2.mo627toDpu2uoSUM(placeable.getWidth()), list2.get(i21).m6403unboximpl(), null));
                                                i20 += placeable.getWidth();
                                            }
                                            List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Divider, function27);
                                            long j10 = j9;
                                            int i22 = intValue2;
                                            int i23 = intValue;
                                            int size5 = subcompose2.size();
                                            for (int i24 = 0; i24 < size5; i24++) {
                                                Placeable mo5333measureBRTryo02 = subcompose2.get(i24).mo5333measureBRTryo0(Constraints.m6336copyZbe2FdA$default(j10, i22, i22, 0, 0, 8, null));
                                                Placeable.PlacementScope.placeRelative$default(placementScope, mo5333measureBRTryo02, 0, i23 - mo5333measureBRTryo02.getHeight(), 0.0f, 4, null);
                                            }
                                            SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope;
                                            TabSlots tabSlots = TabSlots.Indicator;
                                            final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function36 = function35;
                                            List<Measurable> subcompose3 = subcomposeMeasureScope3.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(358596038, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt.ScrollableTabRowImp.1.1.1.2.3
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

                                                public final void invoke(Composer composer4, int i25) {
                                                    ComposerKt.sourceInformation(composer4, "C942@41500L23:TabRow.kt#uh7d8r");
                                                    if ((i25 & 3) == 2 && composer4.getSkipping()) {
                                                        composer4.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(358596038, i25, -1, "androidx.compose.material3.ScrollableTabRowImp.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:942)");
                                                    }
                                                    function36.invoke(arrayList3, composer4, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }));
                                            int i25 = intValue2;
                                            int i26 = intValue;
                                            int size6 = subcompose3.size();
                                            for (int i27 = 0; i27 < size6; i27++) {
                                                Placeable.PlacementScope.placeRelative$default(placementScope, subcompose3.get(i27).mo5333measureBRTryo0(Constraints.INSTANCE.m6353fixedJhjzzOo(i25, i26)), 0, 0, 0.0f, 4, null);
                                            }
                                            scrollableTabData2.onLaidOut(subcomposeMeasureScope, i13, arrayList3, i18);
                                        }
                                    }, 4, null);
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue3);
                        }
                        composer3.endReplaceableGroup();
                        SubcomposeLayoutKt.SubcomposeLayout(clipToBounds, (Function2) rememberedValue3, composer3, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            });
            int i1022222 = ((i4 >> 6) & 14) | 12582912;
            int i1122222 = i4 >> 3;
            composer2 = startRestartGroup;
            SurfaceKt.m2633SurfaceT9BRK9s(modifier422222, null, j822222, j722222, 0.0f, 0.0f, null, composableLambda22222, composer2, i1022222 | (i1122222 & 896) | (i1122222 & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
            }
            f3 = f422222;
            function23 = function2422222;
            modifier3 = modifier422222;
            j5 = j822222;
            j6 = j722222;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        function32 = function3;
        i5 = i3 & 4;
        if (i5 == 0) {
        }
        modifier2 = modifier;
        if ((i2 & 3072) == 0) {
        }
        if ((i2 & 24576) == 0) {
        }
        i6 = i3 & 32;
        if (i6 != 0) {
        }
        f2 = f;
        i7 = i3 & 64;
        if (i7 == 0) {
        }
        if ((i3 & 128) == 0) {
        }
        if ((i3 & 256) != 0) {
        }
        if ((i4 & 38347923) == 38347922) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i5 != 0) {
        }
        if ((i3 & 8) != 0) {
        }
        if ((i3 & 16) != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        m2098getLambda7$material3_release = function2;
        long j7222222 = j4;
        final float f4222222 = f2;
        Modifier modifier4222222 = modifier2;
        long j8222222 = j3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        final Function2<? super Composer, ? super Integer, Unit> function24222222 = m2098getLambda7$material3_release;
        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function33222222 = function32;
        ComposableLambda composableLambda222222 = ComposableLambdaKt.composableLambda(startRestartGroup, -1178901494, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1
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

            public final void invoke(Composer composer3, int i10222222) {
                ComposerKt.sourceInformation(composer3, "C861@38118L24,862@38175L185,875@38628L3325,868@38369L3584:TabRow.kt#uh7d8r");
                if ((i10222222 & 3) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1178901494, i10222222, -1, "androidx.compose.material3.ScrollableTabRowImp.<anonymous> (TabRow.kt:861)");
                    }
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
                    composer3.startReplaceableGroup(121290627);
                    ComposerKt.sourceInformation(composer3, "CC(remember):TabRow.kt#9igjgp");
                    boolean changed = composer3.changed(ScrollState.this) | composer3.changed(coroutineScope);
                    ScrollState scrollState2 = ScrollState.this;
                    Object rememberedValue2 = composer3.rememberedValue();
                    if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = new ScrollableTabData(scrollState2, coroutineScope);
                        composer3.updateRememberedValue(rememberedValue2);
                    }
                    final ScrollableTabData scrollableTabData = (ScrollableTabData) rememberedValue2;
                    composer3.endReplaceableGroup();
                    Modifier clipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getCenterStart(), false, 2, null), ScrollState.this, false, null, false, 14, null)));
                    composer3.startReplaceableGroup(121291080);
                    ComposerKt.sourceInformation(composer3, "CC(remember):TabRow.kt#9igjgp");
                    boolean changed2 = composer3.changed(f4222222) | composer3.changed(function22) | composer3.changed(function24222222) | composer3.changed(function33222222) | composer3.changedInstance(scrollableTabData) | composer3.changed(i);
                    final float f5 = f4222222;
                    final Function2<? super Composer, ? super Integer, Unit> function25 = function22;
                    final Function2<? super Composer, ? super Integer, Unit> function26 = function24222222;
                    final int i11222222 = i;
                    final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function34 = function33222222;
                    Object rememberedValue3 = composer3.rememberedValue();
                    if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue3 = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                return m2694invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                            }

                            /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final MeasureResult m2694invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, final long j9) {
                                float f6;
                                f6 = TabRowKt.ScrollableTabRowMinimumTabWidth;
                                int i12 = subcomposeMeasureScope.mo624roundToPx0680j_4(f6);
                                final int i13 = subcomposeMeasureScope.mo624roundToPx0680j_4(f5);
                                List<Measurable> subcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function25);
                                int i14 = 0;
                                int size = subcompose.size();
                                for (int i15 = 0; i15 < size; i15++) {
                                    i14 = Integer.valueOf(Math.max(i14.intValue(), subcompose.get(i15).maxIntrinsicHeight(Integer.MAX_VALUE)));
                                }
                                final int intValue = i14.intValue();
                                long m6336copyZbe2FdA$default = Constraints.m6336copyZbe2FdA$default(j9, i12, 0, intValue, intValue, 2, null);
                                final List<Placeable> arrayList = new ArrayList();
                                final List<Dp> arrayList2 = new ArrayList();
                                int size2 = subcompose.size();
                                for (int i16 = 0; i16 < size2; i16++) {
                                    Measurable measurable = subcompose.get(i16);
                                    Placeable mo5333measureBRTryo0 = measurable.mo5333measureBRTryo0(m6336copyZbe2FdA$default);
                                    float m6389constructorimpl = Dp.m6389constructorimpl(subcomposeMeasureScope.mo627toDpu2uoSUM(Math.min(measurable.maxIntrinsicWidth(mo5333measureBRTryo0.getHeight()), mo5333measureBRTryo0.getWidth())) - Dp.m6389constructorimpl(TabKt.getHorizontalTextPadding() * 2));
                                    arrayList.add(mo5333measureBRTryo0);
                                    arrayList2.add(Dp.m6387boximpl(m6389constructorimpl));
                                }
                                Integer valueOf = Integer.valueOf(i13 * 2);
                                int size3 = arrayList.size();
                                for (int i17 = 0; i17 < size3; i17++) {
                                    valueOf = Integer.valueOf(valueOf.intValue() + ((Placeable) arrayList.get(i17)).getWidth());
                                }
                                final int intValue2 = valueOf.intValue();
                                final Function2<? super Composer, ? super Integer, Unit> function27 = function26;
                                final ScrollableTabData scrollableTabData2 = scrollableTabData;
                                final int i18 = i11222222;
                                final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function35 = function34;
                                return MeasureScope.layout$default(subcomposeMeasureScope, intValue2, intValue, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1$1$1.2
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
                                        int i19 = i13;
                                        List<Placeable> list = arrayList;
                                        SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                        List<Dp> list2 = arrayList2;
                                        int size4 = list.size();
                                        int i20 = i19;
                                        for (int i21 = 0; i21 < size4; i21++) {
                                            Placeable placeable = list.get(i21);
                                            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, i20, 0, 0.0f, 4, null);
                                            arrayList3.add(new TabPosition(subcomposeMeasureScope2.mo627toDpu2uoSUM(i20), subcomposeMeasureScope2.mo627toDpu2uoSUM(placeable.getWidth()), list2.get(i21).m6403unboximpl(), null));
                                            i20 += placeable.getWidth();
                                        }
                                        List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Divider, function27);
                                        long j10 = j9;
                                        int i22 = intValue2;
                                        int i23 = intValue;
                                        int size5 = subcompose2.size();
                                        for (int i24 = 0; i24 < size5; i24++) {
                                            Placeable mo5333measureBRTryo02 = subcompose2.get(i24).mo5333measureBRTryo0(Constraints.m6336copyZbe2FdA$default(j10, i22, i22, 0, 0, 8, null));
                                            Placeable.PlacementScope.placeRelative$default(placementScope, mo5333measureBRTryo02, 0, i23 - mo5333measureBRTryo02.getHeight(), 0.0f, 4, null);
                                        }
                                        SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope;
                                        TabSlots tabSlots = TabSlots.Indicator;
                                        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function36 = function35;
                                        List<Measurable> subcompose3 = subcomposeMeasureScope3.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(358596038, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt.ScrollableTabRowImp.1.1.1.2.3
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

                                            public final void invoke(Composer composer4, int i25) {
                                                ComposerKt.sourceInformation(composer4, "C942@41500L23:TabRow.kt#uh7d8r");
                                                if ((i25 & 3) == 2 && composer4.getSkipping()) {
                                                    composer4.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(358596038, i25, -1, "androidx.compose.material3.ScrollableTabRowImp.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:942)");
                                                }
                                                function36.invoke(arrayList3, composer4, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }));
                                        int i25 = intValue2;
                                        int i26 = intValue;
                                        int size6 = subcompose3.size();
                                        for (int i27 = 0; i27 < size6; i27++) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, subcompose3.get(i27).mo5333measureBRTryo0(Constraints.INSTANCE.m6353fixedJhjzzOo(i25, i26)), 0, 0, 0.0f, 4, null);
                                        }
                                        scrollableTabData2.onLaidOut(subcomposeMeasureScope, i13, arrayList3, i18);
                                    }
                                }, 4, null);
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue3);
                    }
                    composer3.endReplaceableGroup();
                    SubcomposeLayoutKt.SubcomposeLayout(clipToBounds, (Function2) rememberedValue3, composer3, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        });
        int i10222222 = ((i4 >> 6) & 14) | 12582912;
        int i11222222 = i4 >> 3;
        composer2 = startRestartGroup;
        SurfaceKt.m2633SurfaceT9BRK9s(modifier4222222, null, j8222222, j7222222, 0.0f, 0.0f, null, composableLambda222222, composer2, i10222222 | (i11222222 & 896) | (i11222222 & 7168), 114);
        if (ComposerKt.isTraceInProgress()) {
        }
        f3 = f4222222;
        function23 = function24222222;
        modifier3 = modifier4222222;
        j5 = j8222222;
        j6 = j7222222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
