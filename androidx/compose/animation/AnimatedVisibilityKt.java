package androidx.compose.animation;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.profileinstaller.ProfileVerifier;
import io.bidmachine.iab.vast.tags.VastAttributes;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnimatedVisibility.kt */
@Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0091\u0001\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0001¢\u0006\u0002\u0010\u001a\u001aa\u0010\u001b\u001a\u00020\u00072\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u001d2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0002\u0010 \u001aJ\u0010\u001b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00012\u0011\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\u00070\"¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010#\u001a[\u0010\u001b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0002\u0010$\u001ak\u0010%\u001a\u00020\u0007\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0001¢\u0006\u0002\u0010&\u001am\u0010\u001b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0002\u0010'\u001ae\u0010\u001b\u001a\u00020\u0007*\u00020(2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u001d2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0002\u0010)\u001a_\u0010\u001b\u001a\u00020\u0007*\u00020(2\u0006\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0002\u0010*\u001ae\u0010\u001b\u001a\u00020\u0007*\u00020+2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u001d2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0002\u0010,\u001a_\u0010\u001b\u001a\u00020\u0007*\u00020+2\u0006\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0002\u0010-\u001a9\u0010.\u001a\u00020\u0003\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010/\u001a\u0002H\bH\u0003¢\u0006\u0002\u00100\"\u001e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u00061²\u0006\"\u00102\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0013\"\u0004\b\u0000\u0010\bX\u008a\u0084\u0002²\u0006\u0010\u00103\u001a\u00020\u0001\"\u0004\b\u0000\u0010\bX\u008a\u0084\u0002"}, d2 = {"exitFinished", "", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "getExitFinished", "(Landroidx/compose/animation/core/Transition;)Z", "AnimatedEnterExitImpl", "", "T", "transition", VastAttributes.VISIBLE, "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enter", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "shouldDisposeBlock", "Lkotlin/Function2;", "onLookaheadMeasured", "Landroidx/compose/animation/OnLookaheadMeasured;", "content", "Landroidx/compose/animation/AnimatedVisibilityScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function2;Landroidx/compose/animation/OnLookaheadMeasured;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "AnimatedVisibility", "visibleState", "Landroidx/compose/animation/core/MutableTransitionState;", "label", "", "(Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "initiallyVisible", "Lkotlin/Function0;", "(ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "(ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "AnimatedVisibilityImpl", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/layout/ColumnScope;", "(Landroidx/compose/foundation/layout/ColumnScope;Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/foundation/layout/ColumnScope;ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/layout/RowScope;", "(Landroidx/compose/foundation/layout/RowScope;Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/foundation/layout/RowScope;ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "targetEnterExit", "targetState", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/EnterExitState;", "animation_release", "shouldDisposeBlockUpdated", "shouldDisposeAfterExit"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AnimatedVisibilityKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AnimatedVisibility(boolean z, Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, String str, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        final boolean z2;
        int i3;
        Modifier modifier2;
        int i4;
        EnterTransition enterTransition2;
        int i5;
        ExitTransition exitTransition2;
        int i6;
        String str2;
        Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function32;
        final String str3;
        final Modifier modifier3;
        final EnterTransition enterTransition3;
        final ExitTransition exitTransition3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(2088733774);
        ComposerKt.sourceInformation(startRestartGroup, "C(AnimatedVisibility)P(5,4,1,2,3)133@6955L32,134@6992L84:AnimatedVisibility.kt#xbi5r1");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            z2 = z;
        } else if ((i & 14) == 0) {
            z2 = z;
            i3 = (startRestartGroup.changed(z2) ? 4 : 2) | i;
        } else {
            z2 = z;
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 896) == 0) {
                enterTransition2 = enterTransition;
                i3 |= startRestartGroup.changed(enterTransition2) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 7168) == 0) {
                    exitTransition2 = exitTransition;
                    i3 |= startRestartGroup.changed(exitTransition2) ? 2048 : 1024;
                    i6 = i2 & 16;
                    if (i6 == 0) {
                        i3 |= 24576;
                    } else if ((i & 57344) == 0) {
                        str2 = str;
                        i3 |= startRestartGroup.changed(str2) ? 16384 : 8192;
                        if ((i2 & 32) != 0) {
                            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((i & 458752) == 0) {
                            function32 = function3;
                            i3 |= startRestartGroup.changedInstance(function32) ? 131072 : 65536;
                            if ((i3 & 374491) == 74898 || !startRestartGroup.getSkipping()) {
                                Modifier.Companion companion = i7 == 0 ? Modifier.INSTANCE : modifier2;
                                EnterTransition plus = i4 == 0 ? EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null)) : enterTransition2;
                                if (i5 != 0) {
                                    exitTransition2 = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                                }
                                String str4 = i6 == 0 ? "AnimatedVisibility" : str2;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2088733774, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:132)");
                                }
                                int i8 = i3 << 3;
                                Modifier modifier4 = companion;
                                EnterTransition enterTransition4 = plus;
                                ExitTransition exitTransition4 = exitTransition2;
                                AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z2), str4, startRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$1
                                    public final Boolean invoke(boolean z3) {
                                        return Boolean.valueOf(z3);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                        return invoke(bool.booleanValue());
                                    }
                                }, modifier4, enterTransition4, exitTransition4, function32, startRestartGroup, (i8 & 57344) | (i8 & 896) | 48 | (i8 & 7168) | (i3 & 458752));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                str3 = str4;
                                modifier3 = modifier4;
                                enterTransition3 = enterTransition4;
                                exitTransition3 = exitTransition4;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                modifier3 = modifier2;
                                enterTransition3 = enterTransition2;
                                exitTransition3 = exitTransition2;
                                str3 = str2;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$2
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

                                    public final void invoke(Composer composer2, int i9) {
                                        AnimatedVisibilityKt.AnimatedVisibility(z2, modifier3, enterTransition3, exitTransition3, str3, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        function32 = function3;
                        if ((i3 & 374491) == 74898) {
                        }
                        if (i7 == 0) {
                        }
                        if (i4 == 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i82 = i3 << 3;
                        Modifier modifier42 = companion;
                        EnterTransition enterTransition42 = plus;
                        ExitTransition exitTransition42 = exitTransition2;
                        AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z2), str4, startRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$1
                            public final Boolean invoke(boolean z3) {
                                return Boolean.valueOf(z3);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        }, modifier42, enterTransition42, exitTransition42, function32, startRestartGroup, (i82 & 57344) | (i82 & 896) | 48 | (i82 & 7168) | (i3 & 458752));
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        str3 = str4;
                        modifier3 = modifier42;
                        enterTransition3 = enterTransition42;
                        exitTransition3 = exitTransition42;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    str2 = str;
                    if ((i2 & 32) != 0) {
                    }
                    function32 = function3;
                    if ((i3 & 374491) == 74898) {
                    }
                    if (i7 == 0) {
                    }
                    if (i4 == 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i822 = i3 << 3;
                    Modifier modifier422 = companion;
                    EnterTransition enterTransition422 = plus;
                    ExitTransition exitTransition422 = exitTransition2;
                    AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z2), str4, startRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$1
                        public final Boolean invoke(boolean z3) {
                            return Boolean.valueOf(z3);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                            return invoke(bool.booleanValue());
                        }
                    }, modifier422, enterTransition422, exitTransition422, function32, startRestartGroup, (i822 & 57344) | (i822 & 896) | 48 | (i822 & 7168) | (i3 & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    str3 = str4;
                    modifier3 = modifier422;
                    enterTransition3 = enterTransition422;
                    exitTransition3 = exitTransition422;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                exitTransition2 = exitTransition;
                i6 = i2 & 16;
                if (i6 == 0) {
                }
                str2 = str;
                if ((i2 & 32) != 0) {
                }
                function32 = function3;
                if ((i3 & 374491) == 74898) {
                }
                if (i7 == 0) {
                }
                if (i4 == 0) {
                }
                if (i5 != 0) {
                }
                if (i6 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                int i8222 = i3 << 3;
                Modifier modifier4222 = companion;
                EnterTransition enterTransition4222 = plus;
                ExitTransition exitTransition4222 = exitTransition2;
                AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z2), str4, startRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$1
                    public final Boolean invoke(boolean z3) {
                        return Boolean.valueOf(z3);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                        return invoke(bool.booleanValue());
                    }
                }, modifier4222, enterTransition4222, exitTransition4222, function32, startRestartGroup, (i8222 & 57344) | (i8222 & 896) | 48 | (i8222 & 7168) | (i3 & 458752));
                if (ComposerKt.isTraceInProgress()) {
                }
                str3 = str4;
                modifier3 = modifier4222;
                enterTransition3 = enterTransition4222;
                exitTransition3 = exitTransition4222;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            enterTransition2 = enterTransition;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            exitTransition2 = exitTransition;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            str2 = str;
            if ((i2 & 32) != 0) {
            }
            function32 = function3;
            if ((i3 & 374491) == 74898) {
            }
            if (i7 == 0) {
            }
            if (i4 == 0) {
            }
            if (i5 != 0) {
            }
            if (i6 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            int i82222 = i3 << 3;
            Modifier modifier42222 = companion;
            EnterTransition enterTransition42222 = plus;
            ExitTransition exitTransition42222 = exitTransition2;
            AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z2), str4, startRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$1
                public final Boolean invoke(boolean z3) {
                    return Boolean.valueOf(z3);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                    return invoke(bool.booleanValue());
                }
            }, modifier42222, enterTransition42222, exitTransition42222, function32, startRestartGroup, (i82222 & 57344) | (i82222 & 896) | 48 | (i82222 & 7168) | (i3 & 458752));
            if (ComposerKt.isTraceInProgress()) {
            }
            str3 = str4;
            modifier3 = modifier42222;
            enterTransition3 = enterTransition42222;
            exitTransition3 = exitTransition42222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        enterTransition2 = enterTransition;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        exitTransition2 = exitTransition;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        str2 = str;
        if ((i2 & 32) != 0) {
        }
        function32 = function3;
        if ((i3 & 374491) == 74898) {
        }
        if (i7 == 0) {
        }
        if (i4 == 0) {
        }
        if (i5 != 0) {
        }
        if (i6 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        int i822222 = i3 << 3;
        Modifier modifier422222 = companion;
        EnterTransition enterTransition422222 = plus;
        ExitTransition exitTransition422222 = exitTransition2;
        AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z2), str4, startRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$1
            public final Boolean invoke(boolean z3) {
                return Boolean.valueOf(z3);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                return invoke(bool.booleanValue());
            }
        }, modifier422222, enterTransition422222, exitTransition422222, function32, startRestartGroup, (i822222 & 57344) | (i822222 & 896) | 48 | (i822222 & 7168) | (i3 & 458752));
        if (ComposerKt.isTraceInProgress()) {
        }
        str3 = str4;
        modifier3 = modifier422222;
        enterTransition3 = enterTransition422222;
        exitTransition3 = exitTransition422222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AnimatedVisibility(final RowScope rowScope, boolean z, Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, String str, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        final boolean z2;
        int i3;
        Modifier modifier2;
        int i4;
        EnterTransition enterTransition2;
        int i5;
        ExitTransition exitTransition2;
        int i6;
        String str2;
        Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function32;
        final String str3;
        final Modifier modifier3;
        final EnterTransition enterTransition3;
        final ExitTransition exitTransition3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1741346906);
        ComposerKt.sourceInformation(startRestartGroup, "C(AnimatedVisibility)P(5,4,1,2,3)208@11260L32,209@11297L84:AnimatedVisibility.kt#xbi5r1");
        if ((i2 & 1) != 0) {
            i3 = i | 48;
            z2 = z;
        } else {
            z2 = z;
            if ((i & 112) == 0) {
                i3 = (startRestartGroup.changed(z2) ? 32 : 16) | i;
            } else {
                i3 = i;
            }
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                enterTransition2 = enterTransition;
                i3 |= startRestartGroup.changed(enterTransition2) ? 2048 : 1024;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 57344) == 0) {
                    exitTransition2 = exitTransition;
                    i3 |= startRestartGroup.changed(exitTransition2) ? 16384 : 8192;
                    i6 = i2 & 16;
                    if (i6 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i & 458752) == 0) {
                        str2 = str;
                        i3 |= startRestartGroup.changed(str2) ? 131072 : 65536;
                        if ((i2 & 32) != 0) {
                            i3 |= 1572864;
                        } else if ((3670016 & i) == 0) {
                            function32 = function3;
                            i3 |= startRestartGroup.changedInstance(function32) ? 1048576 : 524288;
                            if ((i3 & 2995921) == 599184 || !startRestartGroup.getSkipping()) {
                                Modifier.Companion companion = i7 == 0 ? Modifier.INSTANCE : modifier2;
                                if (i4 != 0) {
                                    enterTransition2 = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null));
                                }
                                if (i5 != 0) {
                                    exitTransition2 = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null));
                                }
                                String str4 = i6 == 0 ? "AnimatedVisibility" : str2;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1741346906, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:207)");
                                }
                                int i8 = i3 >> 3;
                                Modifier modifier4 = companion;
                                EnterTransition enterTransition4 = enterTransition2;
                                ExitTransition exitTransition4 = exitTransition2;
                                AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z2), str4, startRestartGroup, (i8 & 14) | ((i3 >> 12) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$3
                                    public final Boolean invoke(boolean z3) {
                                        return Boolean.valueOf(z3);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                        return invoke(bool.booleanValue());
                                    }
                                }, modifier4, enterTransition4, exitTransition4, function32, startRestartGroup, (i3 & 57344) | (i3 & 896) | 48 | (i3 & 7168) | (i8 & 458752));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                str3 = str4;
                                modifier3 = modifier4;
                                enterTransition3 = enterTransition4;
                                exitTransition3 = exitTransition4;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                modifier3 = modifier2;
                                enterTransition3 = enterTransition2;
                                exitTransition3 = exitTransition2;
                                str3 = str2;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$4
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

                                    public final void invoke(Composer composer2, int i9) {
                                        AnimatedVisibilityKt.AnimatedVisibility(RowScope.this, z2, modifier3, enterTransition3, exitTransition3, str3, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        function32 = function3;
                        if ((i3 & 2995921) == 599184) {
                        }
                        if (i7 == 0) {
                        }
                        if (i4 != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i82 = i3 >> 3;
                        Modifier modifier42 = companion;
                        EnterTransition enterTransition42 = enterTransition2;
                        ExitTransition exitTransition42 = exitTransition2;
                        AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z2), str4, startRestartGroup, (i82 & 14) | ((i3 >> 12) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$3
                            public final Boolean invoke(boolean z3) {
                                return Boolean.valueOf(z3);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        }, modifier42, enterTransition42, exitTransition42, function32, startRestartGroup, (i3 & 57344) | (i3 & 896) | 48 | (i3 & 7168) | (i82 & 458752));
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        str3 = str4;
                        modifier3 = modifier42;
                        enterTransition3 = enterTransition42;
                        exitTransition3 = exitTransition42;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    str2 = str;
                    if ((i2 & 32) != 0) {
                    }
                    function32 = function3;
                    if ((i3 & 2995921) == 599184) {
                    }
                    if (i7 == 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i822 = i3 >> 3;
                    Modifier modifier422 = companion;
                    EnterTransition enterTransition422 = enterTransition2;
                    ExitTransition exitTransition422 = exitTransition2;
                    AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z2), str4, startRestartGroup, (i822 & 14) | ((i3 >> 12) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$3
                        public final Boolean invoke(boolean z3) {
                            return Boolean.valueOf(z3);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                            return invoke(bool.booleanValue());
                        }
                    }, modifier422, enterTransition422, exitTransition422, function32, startRestartGroup, (i3 & 57344) | (i3 & 896) | 48 | (i3 & 7168) | (i822 & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    str3 = str4;
                    modifier3 = modifier422;
                    enterTransition3 = enterTransition422;
                    exitTransition3 = exitTransition422;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                exitTransition2 = exitTransition;
                i6 = i2 & 16;
                if (i6 == 0) {
                }
                str2 = str;
                if ((i2 & 32) != 0) {
                }
                function32 = function3;
                if ((i3 & 2995921) == 599184) {
                }
                if (i7 == 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                int i8222 = i3 >> 3;
                Modifier modifier4222 = companion;
                EnterTransition enterTransition4222 = enterTransition2;
                ExitTransition exitTransition4222 = exitTransition2;
                AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z2), str4, startRestartGroup, (i8222 & 14) | ((i3 >> 12) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$3
                    public final Boolean invoke(boolean z3) {
                        return Boolean.valueOf(z3);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                        return invoke(bool.booleanValue());
                    }
                }, modifier4222, enterTransition4222, exitTransition4222, function32, startRestartGroup, (i3 & 57344) | (i3 & 896) | 48 | (i3 & 7168) | (i8222 & 458752));
                if (ComposerKt.isTraceInProgress()) {
                }
                str3 = str4;
                modifier3 = modifier4222;
                enterTransition3 = enterTransition4222;
                exitTransition3 = exitTransition4222;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            enterTransition2 = enterTransition;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            exitTransition2 = exitTransition;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            str2 = str;
            if ((i2 & 32) != 0) {
            }
            function32 = function3;
            if ((i3 & 2995921) == 599184) {
            }
            if (i7 == 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            int i82222 = i3 >> 3;
            Modifier modifier42222 = companion;
            EnterTransition enterTransition42222 = enterTransition2;
            ExitTransition exitTransition42222 = exitTransition2;
            AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z2), str4, startRestartGroup, (i82222 & 14) | ((i3 >> 12) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$3
                public final Boolean invoke(boolean z3) {
                    return Boolean.valueOf(z3);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                    return invoke(bool.booleanValue());
                }
            }, modifier42222, enterTransition42222, exitTransition42222, function32, startRestartGroup, (i3 & 57344) | (i3 & 896) | 48 | (i3 & 7168) | (i82222 & 458752));
            if (ComposerKt.isTraceInProgress()) {
            }
            str3 = str4;
            modifier3 = modifier42222;
            enterTransition3 = enterTransition42222;
            exitTransition3 = exitTransition42222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        enterTransition2 = enterTransition;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        exitTransition2 = exitTransition;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        str2 = str;
        if ((i2 & 32) != 0) {
        }
        function32 = function3;
        if ((i3 & 2995921) == 599184) {
        }
        if (i7 == 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        int i822222 = i3 >> 3;
        Modifier modifier422222 = companion;
        EnterTransition enterTransition422222 = enterTransition2;
        ExitTransition exitTransition422222 = exitTransition2;
        AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z2), str4, startRestartGroup, (i822222 & 14) | ((i3 >> 12) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$3
            public final Boolean invoke(boolean z3) {
                return Boolean.valueOf(z3);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                return invoke(bool.booleanValue());
            }
        }, modifier422222, enterTransition422222, exitTransition422222, function32, startRestartGroup, (i3 & 57344) | (i3 & 896) | 48 | (i3 & 7168) | (i822222 & 458752));
        if (ComposerKt.isTraceInProgress()) {
        }
        str3 = str4;
        modifier3 = modifier422222;
        enterTransition3 = enterTransition422222;
        exitTransition3 = exitTransition422222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AnimatedVisibility(final ColumnScope columnScope, boolean z, Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, String str, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        final boolean z2;
        int i3;
        Modifier modifier2;
        int i4;
        EnterTransition enterTransition2;
        int i5;
        ExitTransition exitTransition2;
        int i6;
        String str2;
        Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function32;
        final String str3;
        final Modifier modifier3;
        final EnterTransition enterTransition3;
        final ExitTransition exitTransition3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(1766503102);
        ComposerKt.sourceInformation(startRestartGroup, "C(AnimatedVisibility)P(5,4,1,2,3)281@15543L32,282@15580L84:AnimatedVisibility.kt#xbi5r1");
        if ((i2 & 1) != 0) {
            i3 = i | 48;
            z2 = z;
        } else {
            z2 = z;
            if ((i & 112) == 0) {
                i3 = (startRestartGroup.changed(z2) ? 32 : 16) | i;
            } else {
                i3 = i;
            }
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                enterTransition2 = enterTransition;
                i3 |= startRestartGroup.changed(enterTransition2) ? 2048 : 1024;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 57344) == 0) {
                    exitTransition2 = exitTransition;
                    i3 |= startRestartGroup.changed(exitTransition2) ? 16384 : 8192;
                    i6 = i2 & 16;
                    if (i6 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i & 458752) == 0) {
                        str2 = str;
                        i3 |= startRestartGroup.changed(str2) ? 131072 : 65536;
                        if ((i2 & 32) != 0) {
                            i3 |= 1572864;
                        } else if ((3670016 & i) == 0) {
                            function32 = function3;
                            i3 |= startRestartGroup.changedInstance(function32) ? 1048576 : 524288;
                            if ((i3 & 2995921) == 599184 || !startRestartGroup.getSkipping()) {
                                Modifier.Companion companion = i7 == 0 ? Modifier.INSTANCE : modifier2;
                                if (i4 != 0) {
                                    enterTransition2 = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                                }
                                if (i5 != 0) {
                                    exitTransition2 = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                                }
                                String str4 = i6 == 0 ? "AnimatedVisibility" : str2;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1766503102, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:280)");
                                }
                                int i8 = i3 >> 3;
                                Modifier modifier4 = companion;
                                EnterTransition enterTransition4 = enterTransition2;
                                ExitTransition exitTransition4 = exitTransition2;
                                AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z2), str4, startRestartGroup, (i8 & 14) | ((i3 >> 12) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$5
                                    public final Boolean invoke(boolean z3) {
                                        return Boolean.valueOf(z3);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                        return invoke(bool.booleanValue());
                                    }
                                }, modifier4, enterTransition4, exitTransition4, function32, startRestartGroup, (i3 & 57344) | (i3 & 896) | 48 | (i3 & 7168) | (i8 & 458752));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                str3 = str4;
                                modifier3 = modifier4;
                                enterTransition3 = enterTransition4;
                                exitTransition3 = exitTransition4;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                modifier3 = modifier2;
                                enterTransition3 = enterTransition2;
                                exitTransition3 = exitTransition2;
                                str3 = str2;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$6
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

                                    public final void invoke(Composer composer2, int i9) {
                                        AnimatedVisibilityKt.AnimatedVisibility(ColumnScope.this, z2, modifier3, enterTransition3, exitTransition3, str3, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        function32 = function3;
                        if ((i3 & 2995921) == 599184) {
                        }
                        if (i7 == 0) {
                        }
                        if (i4 != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i82 = i3 >> 3;
                        Modifier modifier42 = companion;
                        EnterTransition enterTransition42 = enterTransition2;
                        ExitTransition exitTransition42 = exitTransition2;
                        AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z2), str4, startRestartGroup, (i82 & 14) | ((i3 >> 12) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$5
                            public final Boolean invoke(boolean z3) {
                                return Boolean.valueOf(z3);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        }, modifier42, enterTransition42, exitTransition42, function32, startRestartGroup, (i3 & 57344) | (i3 & 896) | 48 | (i3 & 7168) | (i82 & 458752));
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        str3 = str4;
                        modifier3 = modifier42;
                        enterTransition3 = enterTransition42;
                        exitTransition3 = exitTransition42;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    str2 = str;
                    if ((i2 & 32) != 0) {
                    }
                    function32 = function3;
                    if ((i3 & 2995921) == 599184) {
                    }
                    if (i7 == 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i822 = i3 >> 3;
                    Modifier modifier422 = companion;
                    EnterTransition enterTransition422 = enterTransition2;
                    ExitTransition exitTransition422 = exitTransition2;
                    AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z2), str4, startRestartGroup, (i822 & 14) | ((i3 >> 12) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$5
                        public final Boolean invoke(boolean z3) {
                            return Boolean.valueOf(z3);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                            return invoke(bool.booleanValue());
                        }
                    }, modifier422, enterTransition422, exitTransition422, function32, startRestartGroup, (i3 & 57344) | (i3 & 896) | 48 | (i3 & 7168) | (i822 & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    str3 = str4;
                    modifier3 = modifier422;
                    enterTransition3 = enterTransition422;
                    exitTransition3 = exitTransition422;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                exitTransition2 = exitTransition;
                i6 = i2 & 16;
                if (i6 == 0) {
                }
                str2 = str;
                if ((i2 & 32) != 0) {
                }
                function32 = function3;
                if ((i3 & 2995921) == 599184) {
                }
                if (i7 == 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                int i8222 = i3 >> 3;
                Modifier modifier4222 = companion;
                EnterTransition enterTransition4222 = enterTransition2;
                ExitTransition exitTransition4222 = exitTransition2;
                AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z2), str4, startRestartGroup, (i8222 & 14) | ((i3 >> 12) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$5
                    public final Boolean invoke(boolean z3) {
                        return Boolean.valueOf(z3);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                        return invoke(bool.booleanValue());
                    }
                }, modifier4222, enterTransition4222, exitTransition4222, function32, startRestartGroup, (i3 & 57344) | (i3 & 896) | 48 | (i3 & 7168) | (i8222 & 458752));
                if (ComposerKt.isTraceInProgress()) {
                }
                str3 = str4;
                modifier3 = modifier4222;
                enterTransition3 = enterTransition4222;
                exitTransition3 = exitTransition4222;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            enterTransition2 = enterTransition;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            exitTransition2 = exitTransition;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            str2 = str;
            if ((i2 & 32) != 0) {
            }
            function32 = function3;
            if ((i3 & 2995921) == 599184) {
            }
            if (i7 == 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            int i82222 = i3 >> 3;
            Modifier modifier42222 = companion;
            EnterTransition enterTransition42222 = enterTransition2;
            ExitTransition exitTransition42222 = exitTransition2;
            AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z2), str4, startRestartGroup, (i82222 & 14) | ((i3 >> 12) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$5
                public final Boolean invoke(boolean z3) {
                    return Boolean.valueOf(z3);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                    return invoke(bool.booleanValue());
                }
            }, modifier42222, enterTransition42222, exitTransition42222, function32, startRestartGroup, (i3 & 57344) | (i3 & 896) | 48 | (i3 & 7168) | (i82222 & 458752));
            if (ComposerKt.isTraceInProgress()) {
            }
            str3 = str4;
            modifier3 = modifier42222;
            enterTransition3 = enterTransition42222;
            exitTransition3 = exitTransition42222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        enterTransition2 = enterTransition;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        exitTransition2 = exitTransition;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        str2 = str;
        if ((i2 & 32) != 0) {
        }
        function32 = function3;
        if ((i3 & 2995921) == 599184) {
        }
        if (i7 == 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        int i822222 = i3 >> 3;
        Modifier modifier422222 = companion;
        EnterTransition enterTransition422222 = enterTransition2;
        ExitTransition exitTransition422222 = exitTransition2;
        AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z2), str4, startRestartGroup, (i822222 & 14) | ((i3 >> 12) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$5
            public final Boolean invoke(boolean z3) {
                return Boolean.valueOf(z3);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                return invoke(bool.booleanValue());
            }
        }, modifier422222, enterTransition422222, exitTransition422222, function32, startRestartGroup, (i3 & 57344) | (i3 & 896) | 48 | (i3 & 7168) | (i822222 & 458752));
        if (ComposerKt.isTraceInProgress()) {
        }
        str3 = str4;
        modifier3 = modifier422222;
        enterTransition3 = enterTransition422222;
        exitTransition3 = exitTransition422222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AnimatedVisibility(final MutableTransitionState<Boolean> mutableTransitionState, Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, String str, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        EnterTransition enterTransition2;
        int i5;
        ExitTransition exitTransition2;
        int i6;
        String str2;
        Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function32;
        final String str3;
        final Modifier modifier3;
        final EnterTransition enterTransition3;
        final ExitTransition exitTransition3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-222898426);
        ComposerKt.sourceInformation(startRestartGroup, "C(AnimatedVisibility)P(5,4,1,2,3)387@20969L37,388@21011L84:AnimatedVisibility.kt#xbi5r1");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changed(mutableTransitionState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 896) == 0) {
                enterTransition2 = enterTransition;
                i3 |= startRestartGroup.changed(enterTransition2) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 7168) == 0) {
                    exitTransition2 = exitTransition;
                    i3 |= startRestartGroup.changed(exitTransition2) ? 2048 : 1024;
                    i6 = i2 & 16;
                    if (i6 == 0) {
                        i3 |= 24576;
                    } else if ((i & 57344) == 0) {
                        str2 = str;
                        i3 |= startRestartGroup.changed(str2) ? 16384 : 8192;
                        if ((i2 & 32) != 0) {
                            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((i & 458752) == 0) {
                            function32 = function3;
                            i3 |= startRestartGroup.changedInstance(function32) ? 131072 : 65536;
                            if ((i3 & 374491) == 74898 || !startRestartGroup.getSkipping()) {
                                Modifier.Companion companion = i7 == 0 ? Modifier.INSTANCE : modifier2;
                                EnterTransition plus = i4 == 0 ? EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null)) : enterTransition2;
                                if (i5 != 0) {
                                    exitTransition2 = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null));
                                }
                                String str4 = i6 == 0 ? "AnimatedVisibility" : str2;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-222898426, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:386)");
                                }
                                int i8 = i3 << 3;
                                Modifier modifier4 = companion;
                                EnterTransition enterTransition4 = plus;
                                ExitTransition exitTransition4 = exitTransition2;
                                AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.updateTransition((MutableTransitionState) mutableTransitionState, str4, startRestartGroup, MutableTransitionState.$stable | (i3 & 14) | ((i3 >> 9) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$7
                                    public final Boolean invoke(boolean z) {
                                        return Boolean.valueOf(z);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                        return invoke(bool.booleanValue());
                                    }
                                }, modifier4, enterTransition4, exitTransition4, function32, startRestartGroup, (i8 & 57344) | (i8 & 896) | 48 | (i8 & 7168) | (i3 & 458752));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                str3 = str4;
                                modifier3 = modifier4;
                                enterTransition3 = enterTransition4;
                                exitTransition3 = exitTransition4;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                modifier3 = modifier2;
                                enterTransition3 = enterTransition2;
                                exitTransition3 = exitTransition2;
                                str3 = str2;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$8
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

                                    public final void invoke(Composer composer2, int i9) {
                                        AnimatedVisibilityKt.AnimatedVisibility(mutableTransitionState, modifier3, enterTransition3, exitTransition3, str3, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        function32 = function3;
                        if ((i3 & 374491) == 74898) {
                        }
                        if (i7 == 0) {
                        }
                        if (i4 == 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i82 = i3 << 3;
                        Modifier modifier42 = companion;
                        EnterTransition enterTransition42 = plus;
                        ExitTransition exitTransition42 = exitTransition2;
                        AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.updateTransition((MutableTransitionState) mutableTransitionState, str4, startRestartGroup, MutableTransitionState.$stable | (i3 & 14) | ((i3 >> 9) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$7
                            public final Boolean invoke(boolean z) {
                                return Boolean.valueOf(z);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        }, modifier42, enterTransition42, exitTransition42, function32, startRestartGroup, (i82 & 57344) | (i82 & 896) | 48 | (i82 & 7168) | (i3 & 458752));
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        str3 = str4;
                        modifier3 = modifier42;
                        enterTransition3 = enterTransition42;
                        exitTransition3 = exitTransition42;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    str2 = str;
                    if ((i2 & 32) != 0) {
                    }
                    function32 = function3;
                    if ((i3 & 374491) == 74898) {
                    }
                    if (i7 == 0) {
                    }
                    if (i4 == 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i822 = i3 << 3;
                    Modifier modifier422 = companion;
                    EnterTransition enterTransition422 = plus;
                    ExitTransition exitTransition422 = exitTransition2;
                    AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.updateTransition((MutableTransitionState) mutableTransitionState, str4, startRestartGroup, MutableTransitionState.$stable | (i3 & 14) | ((i3 >> 9) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$7
                        public final Boolean invoke(boolean z) {
                            return Boolean.valueOf(z);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                            return invoke(bool.booleanValue());
                        }
                    }, modifier422, enterTransition422, exitTransition422, function32, startRestartGroup, (i822 & 57344) | (i822 & 896) | 48 | (i822 & 7168) | (i3 & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    str3 = str4;
                    modifier3 = modifier422;
                    enterTransition3 = enterTransition422;
                    exitTransition3 = exitTransition422;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                exitTransition2 = exitTransition;
                i6 = i2 & 16;
                if (i6 == 0) {
                }
                str2 = str;
                if ((i2 & 32) != 0) {
                }
                function32 = function3;
                if ((i3 & 374491) == 74898) {
                }
                if (i7 == 0) {
                }
                if (i4 == 0) {
                }
                if (i5 != 0) {
                }
                if (i6 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                int i8222 = i3 << 3;
                Modifier modifier4222 = companion;
                EnterTransition enterTransition4222 = plus;
                ExitTransition exitTransition4222 = exitTransition2;
                AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.updateTransition((MutableTransitionState) mutableTransitionState, str4, startRestartGroup, MutableTransitionState.$stable | (i3 & 14) | ((i3 >> 9) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$7
                    public final Boolean invoke(boolean z) {
                        return Boolean.valueOf(z);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                        return invoke(bool.booleanValue());
                    }
                }, modifier4222, enterTransition4222, exitTransition4222, function32, startRestartGroup, (i8222 & 57344) | (i8222 & 896) | 48 | (i8222 & 7168) | (i3 & 458752));
                if (ComposerKt.isTraceInProgress()) {
                }
                str3 = str4;
                modifier3 = modifier4222;
                enterTransition3 = enterTransition4222;
                exitTransition3 = exitTransition4222;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            enterTransition2 = enterTransition;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            exitTransition2 = exitTransition;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            str2 = str;
            if ((i2 & 32) != 0) {
            }
            function32 = function3;
            if ((i3 & 374491) == 74898) {
            }
            if (i7 == 0) {
            }
            if (i4 == 0) {
            }
            if (i5 != 0) {
            }
            if (i6 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            int i82222 = i3 << 3;
            Modifier modifier42222 = companion;
            EnterTransition enterTransition42222 = plus;
            ExitTransition exitTransition42222 = exitTransition2;
            AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.updateTransition((MutableTransitionState) mutableTransitionState, str4, startRestartGroup, MutableTransitionState.$stable | (i3 & 14) | ((i3 >> 9) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$7
                public final Boolean invoke(boolean z) {
                    return Boolean.valueOf(z);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                    return invoke(bool.booleanValue());
                }
            }, modifier42222, enterTransition42222, exitTransition42222, function32, startRestartGroup, (i82222 & 57344) | (i82222 & 896) | 48 | (i82222 & 7168) | (i3 & 458752));
            if (ComposerKt.isTraceInProgress()) {
            }
            str3 = str4;
            modifier3 = modifier42222;
            enterTransition3 = enterTransition42222;
            exitTransition3 = exitTransition42222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        enterTransition2 = enterTransition;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        exitTransition2 = exitTransition;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        str2 = str;
        if ((i2 & 32) != 0) {
        }
        function32 = function3;
        if ((i3 & 374491) == 74898) {
        }
        if (i7 == 0) {
        }
        if (i4 == 0) {
        }
        if (i5 != 0) {
        }
        if (i6 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        int i822222 = i3 << 3;
        Modifier modifier422222 = companion;
        EnterTransition enterTransition422222 = plus;
        ExitTransition exitTransition422222 = exitTransition2;
        AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.updateTransition((MutableTransitionState) mutableTransitionState, str4, startRestartGroup, MutableTransitionState.$stable | (i3 & 14) | ((i3 >> 9) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$7
            public final Boolean invoke(boolean z) {
                return Boolean.valueOf(z);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                return invoke(bool.booleanValue());
            }
        }, modifier422222, enterTransition422222, exitTransition422222, function32, startRestartGroup, (i822222 & 57344) | (i822222 & 896) | 48 | (i822222 & 7168) | (i3 & 458752));
        if (ComposerKt.isTraceInProgress()) {
        }
        str3 = str4;
        modifier3 = modifier422222;
        enterTransition3 = enterTransition422222;
        exitTransition3 = exitTransition422222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AnimatedVisibility(final RowScope rowScope, final MutableTransitionState<Boolean> mutableTransitionState, Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, String str, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        EnterTransition enterTransition2;
        int i5;
        ExitTransition exitTransition2;
        int i6;
        String str2;
        Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function32;
        final String str3;
        final Modifier modifier3;
        final EnterTransition enterTransition3;
        final ExitTransition exitTransition3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(836509870);
        ComposerKt.sourceInformation(startRestartGroup, "C(AnimatedVisibility)P(5,4,1,2,3)462@25330L37,463@25372L84:AnimatedVisibility.kt#xbi5r1");
        if ((i2 & 1) != 0) {
            i3 = i | 48;
        } else if ((i & 112) == 0) {
            i3 = (startRestartGroup.changed(mutableTransitionState) ? 32 : 16) | i;
        } else {
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                enterTransition2 = enterTransition;
                i3 |= startRestartGroup.changed(enterTransition2) ? 2048 : 1024;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 57344) == 0) {
                    exitTransition2 = exitTransition;
                    i3 |= startRestartGroup.changed(exitTransition2) ? 16384 : 8192;
                    i6 = i2 & 16;
                    if (i6 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i & 458752) == 0) {
                        str2 = str;
                        i3 |= startRestartGroup.changed(str2) ? 131072 : 65536;
                        if ((i2 & 32) != 0) {
                            i3 |= 1572864;
                        } else if ((3670016 & i) == 0) {
                            function32 = function3;
                            i3 |= startRestartGroup.changedInstance(function32) ? 1048576 : 524288;
                            if ((i3 & 2995921) == 599184 || !startRestartGroup.getSkipping()) {
                                Modifier.Companion companion = i7 == 0 ? Modifier.INSTANCE : modifier2;
                                if (i4 != 0) {
                                    enterTransition2 = EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                                }
                                if (i5 != 0) {
                                    exitTransition2 = EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                                }
                                String str4 = i6 == 0 ? "AnimatedVisibility" : str2;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(836509870, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:461)");
                                }
                                int i8 = i3 >> 3;
                                Modifier modifier4 = companion;
                                EnterTransition enterTransition4 = enterTransition2;
                                ExitTransition exitTransition4 = exitTransition2;
                                AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.updateTransition((MutableTransitionState) mutableTransitionState, str4, startRestartGroup, MutableTransitionState.$stable | (i8 & 14) | ((i3 >> 12) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$9
                                    public final Boolean invoke(boolean z) {
                                        return Boolean.valueOf(z);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                        return invoke(bool.booleanValue());
                                    }
                                }, modifier4, enterTransition4, exitTransition4, function32, startRestartGroup, (i3 & 57344) | (i3 & 896) | 48 | (i3 & 7168) | (i8 & 458752));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                str3 = str4;
                                modifier3 = modifier4;
                                enterTransition3 = enterTransition4;
                                exitTransition3 = exitTransition4;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                modifier3 = modifier2;
                                enterTransition3 = enterTransition2;
                                exitTransition3 = exitTransition2;
                                str3 = str2;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$10
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

                                    public final void invoke(Composer composer2, int i9) {
                                        AnimatedVisibilityKt.AnimatedVisibility(RowScope.this, mutableTransitionState, modifier3, enterTransition3, exitTransition3, str3, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        function32 = function3;
                        if ((i3 & 2995921) == 599184) {
                        }
                        if (i7 == 0) {
                        }
                        if (i4 != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i82 = i3 >> 3;
                        Modifier modifier42 = companion;
                        EnterTransition enterTransition42 = enterTransition2;
                        ExitTransition exitTransition42 = exitTransition2;
                        AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.updateTransition((MutableTransitionState) mutableTransitionState, str4, startRestartGroup, MutableTransitionState.$stable | (i82 & 14) | ((i3 >> 12) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$9
                            public final Boolean invoke(boolean z) {
                                return Boolean.valueOf(z);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        }, modifier42, enterTransition42, exitTransition42, function32, startRestartGroup, (i3 & 57344) | (i3 & 896) | 48 | (i3 & 7168) | (i82 & 458752));
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        str3 = str4;
                        modifier3 = modifier42;
                        enterTransition3 = enterTransition42;
                        exitTransition3 = exitTransition42;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    str2 = str;
                    if ((i2 & 32) != 0) {
                    }
                    function32 = function3;
                    if ((i3 & 2995921) == 599184) {
                    }
                    if (i7 == 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i822 = i3 >> 3;
                    Modifier modifier422 = companion;
                    EnterTransition enterTransition422 = enterTransition2;
                    ExitTransition exitTransition422 = exitTransition2;
                    AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.updateTransition((MutableTransitionState) mutableTransitionState, str4, startRestartGroup, MutableTransitionState.$stable | (i822 & 14) | ((i3 >> 12) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$9
                        public final Boolean invoke(boolean z) {
                            return Boolean.valueOf(z);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                            return invoke(bool.booleanValue());
                        }
                    }, modifier422, enterTransition422, exitTransition422, function32, startRestartGroup, (i3 & 57344) | (i3 & 896) | 48 | (i3 & 7168) | (i822 & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    str3 = str4;
                    modifier3 = modifier422;
                    enterTransition3 = enterTransition422;
                    exitTransition3 = exitTransition422;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                exitTransition2 = exitTransition;
                i6 = i2 & 16;
                if (i6 == 0) {
                }
                str2 = str;
                if ((i2 & 32) != 0) {
                }
                function32 = function3;
                if ((i3 & 2995921) == 599184) {
                }
                if (i7 == 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                int i8222 = i3 >> 3;
                Modifier modifier4222 = companion;
                EnterTransition enterTransition4222 = enterTransition2;
                ExitTransition exitTransition4222 = exitTransition2;
                AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.updateTransition((MutableTransitionState) mutableTransitionState, str4, startRestartGroup, MutableTransitionState.$stable | (i8222 & 14) | ((i3 >> 12) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$9
                    public final Boolean invoke(boolean z) {
                        return Boolean.valueOf(z);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                        return invoke(bool.booleanValue());
                    }
                }, modifier4222, enterTransition4222, exitTransition4222, function32, startRestartGroup, (i3 & 57344) | (i3 & 896) | 48 | (i3 & 7168) | (i8222 & 458752));
                if (ComposerKt.isTraceInProgress()) {
                }
                str3 = str4;
                modifier3 = modifier4222;
                enterTransition3 = enterTransition4222;
                exitTransition3 = exitTransition4222;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            enterTransition2 = enterTransition;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            exitTransition2 = exitTransition;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            str2 = str;
            if ((i2 & 32) != 0) {
            }
            function32 = function3;
            if ((i3 & 2995921) == 599184) {
            }
            if (i7 == 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            int i82222 = i3 >> 3;
            Modifier modifier42222 = companion;
            EnterTransition enterTransition42222 = enterTransition2;
            ExitTransition exitTransition42222 = exitTransition2;
            AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.updateTransition((MutableTransitionState) mutableTransitionState, str4, startRestartGroup, MutableTransitionState.$stable | (i82222 & 14) | ((i3 >> 12) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$9
                public final Boolean invoke(boolean z) {
                    return Boolean.valueOf(z);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                    return invoke(bool.booleanValue());
                }
            }, modifier42222, enterTransition42222, exitTransition42222, function32, startRestartGroup, (i3 & 57344) | (i3 & 896) | 48 | (i3 & 7168) | (i82222 & 458752));
            if (ComposerKt.isTraceInProgress()) {
            }
            str3 = str4;
            modifier3 = modifier42222;
            enterTransition3 = enterTransition42222;
            exitTransition3 = exitTransition42222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        enterTransition2 = enterTransition;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        exitTransition2 = exitTransition;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        str2 = str;
        if ((i2 & 32) != 0) {
        }
        function32 = function3;
        if ((i3 & 2995921) == 599184) {
        }
        if (i7 == 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        int i822222 = i3 >> 3;
        Modifier modifier422222 = companion;
        EnterTransition enterTransition422222 = enterTransition2;
        ExitTransition exitTransition422222 = exitTransition2;
        AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.updateTransition((MutableTransitionState) mutableTransitionState, str4, startRestartGroup, MutableTransitionState.$stable | (i822222 & 14) | ((i3 >> 12) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$9
            public final Boolean invoke(boolean z) {
                return Boolean.valueOf(z);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                return invoke(bool.booleanValue());
            }
        }, modifier422222, enterTransition422222, exitTransition422222, function32, startRestartGroup, (i3 & 57344) | (i3 & 896) | 48 | (i3 & 7168) | (i822222 & 458752));
        if (ComposerKt.isTraceInProgress()) {
        }
        str3 = str4;
        modifier3 = modifier422222;
        enterTransition3 = enterTransition422222;
        exitTransition3 = exitTransition422222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AnimatedVisibility(final ColumnScope columnScope, final MutableTransitionState<Boolean> mutableTransitionState, Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, String str, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        EnterTransition enterTransition2;
        int i5;
        ExitTransition exitTransition2;
        int i6;
        String str2;
        Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function32;
        final String str3;
        final Modifier modifier3;
        final EnterTransition enterTransition3;
        final ExitTransition exitTransition3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-850656618);
        ComposerKt.sourceInformation(startRestartGroup, "C(AnimatedVisibility)P(5,4,1,2,3)538@29783L37,539@29825L84:AnimatedVisibility.kt#xbi5r1");
        if ((i2 & 1) != 0) {
            i3 = i | 48;
        } else if ((i & 112) == 0) {
            i3 = (startRestartGroup.changed(mutableTransitionState) ? 32 : 16) | i;
        } else {
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                enterTransition2 = enterTransition;
                i3 |= startRestartGroup.changed(enterTransition2) ? 2048 : 1024;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 57344) == 0) {
                    exitTransition2 = exitTransition;
                    i3 |= startRestartGroup.changed(exitTransition2) ? 16384 : 8192;
                    i6 = i2 & 16;
                    if (i6 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i & 458752) == 0) {
                        str2 = str;
                        i3 |= startRestartGroup.changed(str2) ? 131072 : 65536;
                        if ((i2 & 32) != 0) {
                            i3 |= 1572864;
                        } else if ((3670016 & i) == 0) {
                            function32 = function3;
                            i3 |= startRestartGroup.changedInstance(function32) ? 1048576 : 524288;
                            if ((i3 & 2995921) == 599184 || !startRestartGroup.getSkipping()) {
                                Modifier.Companion companion = i7 == 0 ? Modifier.INSTANCE : modifier2;
                                if (i4 != 0) {
                                    enterTransition2 = EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                                }
                                if (i5 != 0) {
                                    exitTransition2 = EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                                }
                                String str4 = i6 == 0 ? "AnimatedVisibility" : str2;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-850656618, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:537)");
                                }
                                int i8 = i3 >> 3;
                                Modifier modifier4 = companion;
                                EnterTransition enterTransition4 = enterTransition2;
                                ExitTransition exitTransition4 = exitTransition2;
                                AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.updateTransition((MutableTransitionState) mutableTransitionState, str4, startRestartGroup, MutableTransitionState.$stable | (i8 & 14) | ((i3 >> 12) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$11
                                    public final Boolean invoke(boolean z) {
                                        return Boolean.valueOf(z);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                        return invoke(bool.booleanValue());
                                    }
                                }, modifier4, enterTransition4, exitTransition4, function32, startRestartGroup, (i3 & 57344) | (i3 & 896) | 48 | (i3 & 7168) | (i8 & 458752));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                str3 = str4;
                                modifier3 = modifier4;
                                enterTransition3 = enterTransition4;
                                exitTransition3 = exitTransition4;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                modifier3 = modifier2;
                                enterTransition3 = enterTransition2;
                                exitTransition3 = exitTransition2;
                                str3 = str2;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$12
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

                                    public final void invoke(Composer composer2, int i9) {
                                        AnimatedVisibilityKt.AnimatedVisibility(ColumnScope.this, mutableTransitionState, modifier3, enterTransition3, exitTransition3, str3, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        function32 = function3;
                        if ((i3 & 2995921) == 599184) {
                        }
                        if (i7 == 0) {
                        }
                        if (i4 != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i82 = i3 >> 3;
                        Modifier modifier42 = companion;
                        EnterTransition enterTransition42 = enterTransition2;
                        ExitTransition exitTransition42 = exitTransition2;
                        AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.updateTransition((MutableTransitionState) mutableTransitionState, str4, startRestartGroup, MutableTransitionState.$stable | (i82 & 14) | ((i3 >> 12) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$11
                            public final Boolean invoke(boolean z) {
                                return Boolean.valueOf(z);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        }, modifier42, enterTransition42, exitTransition42, function32, startRestartGroup, (i3 & 57344) | (i3 & 896) | 48 | (i3 & 7168) | (i82 & 458752));
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        str3 = str4;
                        modifier3 = modifier42;
                        enterTransition3 = enterTransition42;
                        exitTransition3 = exitTransition42;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    str2 = str;
                    if ((i2 & 32) != 0) {
                    }
                    function32 = function3;
                    if ((i3 & 2995921) == 599184) {
                    }
                    if (i7 == 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i822 = i3 >> 3;
                    Modifier modifier422 = companion;
                    EnterTransition enterTransition422 = enterTransition2;
                    ExitTransition exitTransition422 = exitTransition2;
                    AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.updateTransition((MutableTransitionState) mutableTransitionState, str4, startRestartGroup, MutableTransitionState.$stable | (i822 & 14) | ((i3 >> 12) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$11
                        public final Boolean invoke(boolean z) {
                            return Boolean.valueOf(z);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                            return invoke(bool.booleanValue());
                        }
                    }, modifier422, enterTransition422, exitTransition422, function32, startRestartGroup, (i3 & 57344) | (i3 & 896) | 48 | (i3 & 7168) | (i822 & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    str3 = str4;
                    modifier3 = modifier422;
                    enterTransition3 = enterTransition422;
                    exitTransition3 = exitTransition422;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                exitTransition2 = exitTransition;
                i6 = i2 & 16;
                if (i6 == 0) {
                }
                str2 = str;
                if ((i2 & 32) != 0) {
                }
                function32 = function3;
                if ((i3 & 2995921) == 599184) {
                }
                if (i7 == 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                int i8222 = i3 >> 3;
                Modifier modifier4222 = companion;
                EnterTransition enterTransition4222 = enterTransition2;
                ExitTransition exitTransition4222 = exitTransition2;
                AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.updateTransition((MutableTransitionState) mutableTransitionState, str4, startRestartGroup, MutableTransitionState.$stable | (i8222 & 14) | ((i3 >> 12) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$11
                    public final Boolean invoke(boolean z) {
                        return Boolean.valueOf(z);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                        return invoke(bool.booleanValue());
                    }
                }, modifier4222, enterTransition4222, exitTransition4222, function32, startRestartGroup, (i3 & 57344) | (i3 & 896) | 48 | (i3 & 7168) | (i8222 & 458752));
                if (ComposerKt.isTraceInProgress()) {
                }
                str3 = str4;
                modifier3 = modifier4222;
                enterTransition3 = enterTransition4222;
                exitTransition3 = exitTransition4222;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            enterTransition2 = enterTransition;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            exitTransition2 = exitTransition;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            str2 = str;
            if ((i2 & 32) != 0) {
            }
            function32 = function3;
            if ((i3 & 2995921) == 599184) {
            }
            if (i7 == 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            int i82222 = i3 >> 3;
            Modifier modifier42222 = companion;
            EnterTransition enterTransition42222 = enterTransition2;
            ExitTransition exitTransition42222 = exitTransition2;
            AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.updateTransition((MutableTransitionState) mutableTransitionState, str4, startRestartGroup, MutableTransitionState.$stable | (i82222 & 14) | ((i3 >> 12) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$11
                public final Boolean invoke(boolean z) {
                    return Boolean.valueOf(z);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                    return invoke(bool.booleanValue());
                }
            }, modifier42222, enterTransition42222, exitTransition42222, function32, startRestartGroup, (i3 & 57344) | (i3 & 896) | 48 | (i3 & 7168) | (i82222 & 458752));
            if (ComposerKt.isTraceInProgress()) {
            }
            str3 = str4;
            modifier3 = modifier42222;
            enterTransition3 = enterTransition42222;
            exitTransition3 = exitTransition42222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        enterTransition2 = enterTransition;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        exitTransition2 = exitTransition;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        str2 = str;
        if ((i2 & 32) != 0) {
        }
        function32 = function3;
        if ((i3 & 2995921) == 599184) {
        }
        if (i7 == 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        int i822222 = i3 >> 3;
        Modifier modifier422222 = companion;
        EnterTransition enterTransition422222 = enterTransition2;
        ExitTransition exitTransition422222 = exitTransition2;
        AnimatedVisibilityImpl(androidx.compose.animation.core.TransitionKt.updateTransition((MutableTransitionState) mutableTransitionState, str4, startRestartGroup, MutableTransitionState.$stable | (i822222 & 14) | ((i3 >> 12) & 112), 0), new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$11
            public final Boolean invoke(boolean z) {
                return Boolean.valueOf(z);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                return invoke(bool.booleanValue());
            }
        }, modifier422222, enterTransition422222, exitTransition422222, function32, startRestartGroup, (i3 & 57344) | (i3 & 896) | 48 | (i3 & 7168) | (i822222 & 458752));
        if (ComposerKt.isTraceInProgress()) {
        }
        str3 = str4;
        modifier3 = modifier422222;
        enterTransition3 = enterTransition422222;
        exitTransition3 = exitTransition422222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> void AnimatedVisibility(final Transition<T> transition, final Function1<? super T, Boolean> function1, Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Transition<T> transition2;
        int i3;
        Function1<? super T, Boolean> function12;
        final Modifier modifier2;
        int i4;
        EnterTransition enterTransition2;
        int i5;
        ExitTransition exitTransition2;
        Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function32;
        final EnterTransition enterTransition3;
        final ExitTransition exitTransition3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(1031950689);
        ComposerKt.sourceInformation(startRestartGroup, "C(AnimatedVisibility)P(4,3,1,2)612@34154L79:AnimatedVisibility.kt#xbi5r1");
        if ((i2 & Integer.MIN_VALUE) != 0) {
            i3 = i | 6;
            transition2 = transition;
        } else {
            transition2 = transition;
            if ((i & 14) == 0) {
                i3 = (startRestartGroup.changed(transition2) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 1) != 0) {
            i3 |= 48;
            function12 = function1;
        } else {
            function12 = function1;
            if ((i & 112) == 0) {
                i3 |= startRestartGroup.changedInstance(function12) ? 32 : 16;
            }
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                enterTransition2 = enterTransition;
                i3 |= startRestartGroup.changed(enterTransition2) ? 2048 : 1024;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((57344 & i) == 0) {
                    exitTransition2 = exitTransition;
                    i3 |= startRestartGroup.changed(exitTransition2) ? 16384 : 8192;
                    if ((i2 & 16) == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        function32 = function3;
                    } else {
                        function32 = function3;
                        if ((458752 & i) == 0) {
                            i3 |= startRestartGroup.changedInstance(function32) ? 131072 : 65536;
                        }
                    }
                    if ((374491 & i3) == 74898 || !startRestartGroup.getSkipping()) {
                        Modifier.Companion companion = i6 == 0 ? Modifier.INSTANCE : modifier2;
                        EnterTransition plus = i4 == 0 ? EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null)) : enterTransition2;
                        ExitTransition plus2 = i5 == 0 ? EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null)) : exitTransition2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1031950689, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:612)");
                        }
                        Modifier modifier3 = companion;
                        EnterTransition enterTransition4 = plus;
                        AnimatedVisibilityImpl(transition2, function12, modifier3, enterTransition4, plus2, function32, startRestartGroup, i3 & 524286);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier3;
                        enterTransition3 = enterTransition4;
                        exitTransition3 = plus2;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        enterTransition3 = enterTransition2;
                        exitTransition3 = exitTransition2;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$13
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
                                AnimatedVisibilityKt.AnimatedVisibility(transition, function1, modifier2, enterTransition3, exitTransition3, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                exitTransition2 = exitTransition;
                if ((i2 & 16) == 0) {
                }
                if ((374491 & i3) == 74898) {
                }
                if (i6 == 0) {
                }
                if (i4 == 0) {
                }
                if (i5 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                Modifier modifier32 = companion;
                EnterTransition enterTransition42 = plus;
                AnimatedVisibilityImpl(transition2, function12, modifier32, enterTransition42, plus2, function32, startRestartGroup, i3 & 524286);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier2 = modifier32;
                enterTransition3 = enterTransition42;
                exitTransition3 = plus2;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            enterTransition2 = enterTransition;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            exitTransition2 = exitTransition;
            if ((i2 & 16) == 0) {
            }
            if ((374491 & i3) == 74898) {
            }
            if (i6 == 0) {
            }
            if (i4 == 0) {
            }
            if (i5 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            Modifier modifier322 = companion;
            EnterTransition enterTransition422 = plus;
            AnimatedVisibilityImpl(transition2, function12, modifier322, enterTransition422, plus2, function32, startRestartGroup, i3 & 524286);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier2 = modifier322;
            enterTransition3 = enterTransition422;
            exitTransition3 = plus2;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        enterTransition2 = enterTransition;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        exitTransition2 = exitTransition;
        if ((i2 & 16) == 0) {
        }
        if ((374491 & i3) == 74898) {
        }
        if (i6 == 0) {
        }
        if (i4 == 0) {
        }
        if (i5 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Modifier modifier3222 = companion;
        EnterTransition enterTransition4222 = plus;
        AnimatedVisibilityImpl(transition2, function12, modifier3222, enterTransition4222, plus2, function32, startRestartGroup, i3 & 524286);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier2 = modifier3222;
        enterTransition3 = enterTransition4222;
        exitTransition3 = plus2;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0055  */
    @Deprecated(message = "AnimatedVisibility no longer accepts initiallyVisible as a parameter, please use AnimatedVisibility(MutableTransitionState, Modifier, ...) API instead", replaceWith = @ReplaceWith(expression = "AnimatedVisibility(transitionState = remember { MutableTransitionState(initiallyVisible) }\n.apply { targetState = visible },\nmodifier = modifier,\nenter = enter,\nexit = exit) {\ncontent() \n}", imports = {"androidx.compose.animation.core.MutableTransitionState"}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AnimatedVisibility(boolean z, Modifier modifier, final EnterTransition enterTransition, final ExitTransition exitTransition, boolean z2, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        final boolean z3;
        int i3;
        Modifier modifier2;
        EnterTransition enterTransition2;
        ExitTransition exitTransition2;
        final boolean z4;
        Object rememberedValue;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(1121582420);
        ComposerKt.sourceInformation(startRestartGroup, "C(AnimatedVisibility)P(5,4,1,2,3)*715@38991L53,714@38952L214:AnimatedVisibility.kt#xbi5r1");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            z3 = z;
        } else if ((i & 14) == 0) {
            z3 = z;
            i3 = (startRestartGroup.changed(z3) ? 4 : 2) | i;
        } else {
            z3 = z;
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i2 & 4) == 0) {
                i3 |= 384;
                enterTransition2 = enterTransition;
            } else {
                enterTransition2 = enterTransition;
                if ((i & 896) == 0) {
                    i3 |= startRestartGroup.changed(enterTransition2) ? 256 : 128;
                }
            }
            if ((i2 & 8) == 0) {
                i3 |= 3072;
                exitTransition2 = exitTransition;
            } else {
                exitTransition2 = exitTransition;
                if ((i & 7168) == 0) {
                    i3 |= startRestartGroup.changed(exitTransition2) ? 2048 : 1024;
                }
            }
            if ((i2 & 16) == 0) {
                i3 |= 24576;
            } else if ((57344 & i) == 0) {
                z4 = z2;
                i3 |= startRestartGroup.changed(z4) ? 16384 : 8192;
                if ((i2 & 32) != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((458752 & i) == 0) {
                    i3 |= startRestartGroup.changedInstance(function2) ? 131072 : 65536;
                }
                if ((374491 & i3) == 74898 || !startRestartGroup.getSkipping()) {
                    Modifier.Companion companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1121582420, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:714)");
                    }
                    startRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new MutableTransitionState(Boolean.valueOf(z4));
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    startRestartGroup.endReplaceableGroup();
                    MutableTransitionState mutableTransitionState = (MutableTransitionState) rememberedValue;
                    mutableTransitionState.setTargetState(Boolean.valueOf(z3));
                    Modifier modifier4 = companion;
                    AnimatedVisibility((MutableTransitionState<Boolean>) mutableTransitionState, modifier4, enterTransition2, exitTransition2, (String) null, ComposableLambdaKt.composableLambda(startRestartGroup, 1996320812, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$16
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer2, Integer num) {
                            invoke(animatedVisibilityScope, composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer2, int i5) {
                            ComposerKt.sourceInformation(composer2, "C721@39155L9:AnimatedVisibility.kt#xbi5r1");
                            if ((i5 & 81) == 16 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1996320812, i5, -1, "androidx.compose.animation.AnimatedVisibility.<anonymous> (AnimatedVisibility.kt:721)");
                            }
                            function2.invoke(composer2, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), startRestartGroup, MutableTransitionState.$stable | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i3 & 112) | (i3 & 896) | (i3 & 7168), 16);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$17
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

                        public final void invoke(Composer composer2, int i5) {
                            AnimatedVisibilityKt.AnimatedVisibility(z3, modifier3, enterTransition, exitTransition, z4, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            z4 = z2;
            if ((i2 & 32) != 0) {
            }
            if ((374491 & i3) == 74898) {
            }
            if (i4 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            MutableTransitionState mutableTransitionState2 = (MutableTransitionState) rememberedValue;
            mutableTransitionState2.setTargetState(Boolean.valueOf(z3));
            Modifier modifier42 = companion;
            AnimatedVisibility((MutableTransitionState<Boolean>) mutableTransitionState2, modifier42, enterTransition2, exitTransition2, (String) null, ComposableLambdaKt.composableLambda(startRestartGroup, 1996320812, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$16
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer2, Integer num) {
                    invoke(animatedVisibilityScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer2, int i5) {
                    ComposerKt.sourceInformation(composer2, "C721@39155L9:AnimatedVisibility.kt#xbi5r1");
                    if ((i5 & 81) == 16 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1996320812, i5, -1, "androidx.compose.animation.AnimatedVisibility.<anonymous> (AnimatedVisibility.kt:721)");
                    }
                    function2.invoke(composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), startRestartGroup, MutableTransitionState.$stable | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i3 & 112) | (i3 & 896) | (i3 & 7168), 16);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier42;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i2 & 4) == 0) {
        }
        if ((i2 & 8) == 0) {
        }
        if ((i2 & 16) == 0) {
        }
        z4 = z2;
        if ((i2 & 32) != 0) {
        }
        if ((374491 & i3) == 74898) {
        }
        if (i4 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        MutableTransitionState mutableTransitionState22 = (MutableTransitionState) rememberedValue;
        mutableTransitionState22.setTargetState(Boolean.valueOf(z3));
        Modifier modifier422 = companion;
        AnimatedVisibility((MutableTransitionState<Boolean>) mutableTransitionState22, modifier422, enterTransition2, exitTransition2, (String) null, ComposableLambdaKt.composableLambda(startRestartGroup, 1996320812, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$16
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer2, Integer num) {
                invoke(animatedVisibilityScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer2, int i5) {
                ComposerKt.sourceInformation(composer2, "C721@39155L9:AnimatedVisibility.kt#xbi5r1");
                if ((i5 & 81) == 16 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1996320812, i5, -1, "androidx.compose.animation.AnimatedVisibility.<anonymous> (AnimatedVisibility.kt:721)");
                }
                function2.invoke(composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), startRestartGroup, MutableTransitionState.$stable | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i3 & 112) | (i3 & 896) | (i3 & 7168), 16);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier422;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    public static final <T> void AnimatedVisibilityImpl(final Transition<T> transition, final Function1<? super T, Boolean> function1, final Modifier modifier, final EnterTransition enterTransition, final ExitTransition exitTransition, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        EnterTransition enterTransition2;
        Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function32;
        Composer startRestartGroup = composer.startRestartGroup(429978603);
        ComposerKt.sourceInformation(startRestartGroup, "C(AnimatedVisibilityImpl)P(4,5,3,1,2)740@39776L703:AnimatedVisibility.kt#xbi5r1");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(transition) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            enterTransition2 = enterTransition;
            i2 |= startRestartGroup.changed(enterTransition2) ? 2048 : 1024;
        } else {
            enterTransition2 = enterTransition;
        }
        if ((i & 57344) == 0) {
            i2 |= startRestartGroup.changed(exitTransition) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            function32 = function3;
            i2 |= startRestartGroup.changedInstance(function32) ? 131072 : 65536;
        } else {
            function32 = function3;
        }
        if ((374491 & i2) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(429978603, i2, -1, "androidx.compose.animation.AnimatedVisibilityImpl (AnimatedVisibility.kt:739)");
            }
            startRestartGroup.startReplaceableGroup(-311853878);
            boolean changedInstance = startRestartGroup.changedInstance(function1) | startRestartGroup.changed(transition);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibilityImpl$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                        return m384invoke3p2s80s(measureScope, measurable, constraints.getValue());
                    }

                    /* renamed from: invoke-3p2s80s, reason: not valid java name */
                    public final MeasureResult m384invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                        long IntSize;
                        final Placeable mo5333measureBRTryo0 = measurable.mo5333measureBRTryo0(j);
                        if (measureScope.isLookingAhead() && !function1.invoke(transition.getTargetState()).booleanValue()) {
                            IntSize = IntSize.INSTANCE.m6564getZeroYbymL2g();
                        } else {
                            IntSize = IntSizeKt.IntSize(mo5333measureBRTryo0.getWidth(), mo5333measureBRTryo0.getHeight());
                        }
                        return MeasureScope.layout$default(measureScope, IntSize.m6559getWidthimpl(IntSize), IntSize.m6558getHeightimpl(IntSize), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibilityImpl$1$1.1
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
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            AnimatedEnterExitImpl(transition, function1, LayoutModifierKt.layout(modifier, (Function3) rememberedValue), enterTransition2, exitTransition, new Function2<EnterExitState, EnterExitState, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibilityImpl$2
                @Override // kotlin.jvm.functions.Function2
                public final Boolean invoke(EnterExitState enterExitState, EnterExitState enterExitState2) {
                    return Boolean.valueOf(enterExitState == enterExitState2 && enterExitState2 == EnterExitState.PostExit);
                }
            }, null, function32, startRestartGroup, ((i2 << 6) & 29360128) | (57344 & i2) | 196608 | (i2 & 14) | (i2 & 112) | (i2 & 7168), 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibilityImpl$3
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

                public final void invoke(Composer composer2, int i3) {
                    AnimatedVisibilityKt.AnimatedVisibilityImpl(transition, function1, modifier, enterTransition, exitTransition, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0376  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> void AnimatedEnterExitImpl(final Transition<T> transition, final Function1<? super T, Boolean> function1, final Modifier modifier, final EnterTransition enterTransition, final ExitTransition exitTransition, final Function2<? super EnterExitState, ? super EnterExitState, Boolean> function2, OnLookaheadMeasured onLookaheadMeasured, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        EnterTransition enterTransition2;
        ExitTransition exitTransition2;
        int i4;
        int i5;
        OnLookaheadMeasured onLookaheadMeasured2;
        int i6;
        boolean changed;
        Object rememberedValue;
        int i7;
        final OnLookaheadMeasured onLookaheadMeasured3;
        Transition createChildTransitionInternal;
        boolean changed2;
        AnimatedVisibilityKt$AnimatedEnterExitImpl$shouldDisposeAfterExit$2$1 rememberedValue2;
        boolean changed3;
        Object rememberedValue3;
        Modifier.Companion companion;
        Object rememberedValue4;
        int currentCompositeKeyHash;
        Composer m3593constructorimpl;
        ScopeUpdateScope endRestartGroup;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(-891967166);
        ComposerKt.sourceInformation(startRestartGroup, "C(AnimatedEnterExitImpl)P(6,7,3,1,2,5,4)788@41251L116,792@41410L40,794@41490L574,815@42162L69,819@42377L39,833@43122L50,816@42244L942:AnimatedVisibility.kt#xbi5r1");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changed(transition) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
            enterTransition2 = enterTransition;
        } else {
            enterTransition2 = enterTransition;
            if ((i & 7168) == 0) {
                i3 |= startRestartGroup.changed(enterTransition2) ? 2048 : 1024;
            }
        }
        if ((i2 & 16) != 0) {
            i3 |= 24576;
            exitTransition2 = exitTransition;
        } else {
            exitTransition2 = exitTransition;
            if ((57344 & i) == 0) {
                i3 |= startRestartGroup.changed(exitTransition2) ? 16384 : 8192;
            }
        }
        if ((i2 & 32) != 0) {
            i4 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else {
            if ((458752 & i) == 0) {
                i4 = startRestartGroup.changedInstance(function2) ? 131072 : 65536;
            }
            i5 = i2 & 64;
            if (i5 == 0) {
                i3 |= 1572864;
            } else if ((3670016 & i) == 0) {
                onLookaheadMeasured2 = onLookaheadMeasured;
                i3 |= startRestartGroup.changed(onLookaheadMeasured2) ? 1048576 : 524288;
                if ((i2 & 128) == 0) {
                    i8 = (29360128 & i) == 0 ? startRestartGroup.changedInstance(function3) ? 8388608 : 4194304 : 12582912;
                    i6 = i3;
                    if ((23967451 & i6) == 4793490 || !startRestartGroup.getSkipping()) {
                        if (i5 != 0) {
                            onLookaheadMeasured2 = null;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-891967166, i6, -1, "androidx.compose.animation.AnimatedEnterExitImpl (AnimatedVisibility.kt:784)");
                        }
                        if (!function1.invoke(transition.getTargetState()).booleanValue() || function1.invoke(transition.getCurrentState()).booleanValue() || transition.isSeeking()) {
                            startRestartGroup.startReplaceableGroup(1215497572);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(createChildTransition)1010@39937L36,1011@39997L74,1012@40094L39,1013@40145L63:Transition.kt#pdpnli");
                            int i9 = ((i6 & 14) | 48) & 14;
                            startRestartGroup.startReplaceableGroup(1157296644);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
                            changed = startRestartGroup.changed(transition);
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = transition.getCurrentState();
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            startRestartGroup.endReplaceableGroup();
                            if (transition.isSeeking()) {
                                rememberedValue = transition.getCurrentState();
                            }
                            startRestartGroup.startReplaceableGroup(-466616829);
                            ComposerKt.sourceInformation(startRestartGroup, "C789@41329L28:AnimatedVisibility.kt#xbi5r1");
                            OnLookaheadMeasured onLookaheadMeasured4 = onLookaheadMeasured2;
                            if (ComposerKt.isTraceInProgress()) {
                                i7 = i6;
                            } else {
                                i7 = i6;
                                ComposerKt.traceEventStart(-466616829, 0, -1, "androidx.compose.animation.AnimatedEnterExitImpl.<anonymous> (AnimatedVisibility.kt:789)");
                            }
                            int i10 = i7 & 126;
                            EnterExitState targetEnterExit = targetEnterExit(transition, function1, rememberedValue, startRestartGroup, i10);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            startRestartGroup.endReplaceableGroup();
                            T targetState = transition.getTargetState();
                            startRestartGroup.startReplaceableGroup(-466616829);
                            ComposerKt.sourceInformation(startRestartGroup, "C789@41329L28:AnimatedVisibility.kt#xbi5r1");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-466616829, 0, -1, "androidx.compose.animation.AnimatedEnterExitImpl.<anonymous> (AnimatedVisibility.kt:789)");
                            }
                            EnterExitState targetEnterExit2 = targetEnterExit(transition, function1, targetState, startRestartGroup, i10);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            startRestartGroup.endReplaceableGroup();
                            onLookaheadMeasured3 = onLookaheadMeasured4;
                            createChildTransitionInternal = androidx.compose.animation.core.TransitionKt.createChildTransitionInternal(transition, targetEnterExit, targetEnterExit2, "EnterExitTransition", startRestartGroup, i9 | 3072);
                            startRestartGroup.endReplaceableGroup();
                            State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function2, startRestartGroup, (i7 >> 15) & 14);
                            Boolean invoke = function2.invoke(createChildTransitionInternal.getCurrentState(), createChildTransitionInternal.getTargetState());
                            startRestartGroup.startReplaceableGroup(-311852107);
                            changed2 = startRestartGroup.changed(createChildTransitionInternal) | startRestartGroup.changed(rememberUpdatedState);
                            rememberedValue2 = startRestartGroup.rememberedValue();
                            if (!changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue2 = new AnimatedVisibilityKt$AnimatedEnterExitImpl$shouldDisposeAfterExit$2$1(createChildTransitionInternal, rememberUpdatedState, null);
                                startRestartGroup.updateRememberedValue(rememberedValue2);
                            }
                            startRestartGroup.endReplaceableGroup();
                            State produceState = SnapshotStateKt.produceState(invoke, (Function2) rememberedValue2, startRestartGroup, 64);
                            if (getExitFinished(createChildTransitionInternal) || !AnimatedEnterExitImpl$lambda$6(produceState)) {
                                startRestartGroup.startReplaceableGroup(1157296644);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
                                changed3 = startRestartGroup.changed(transition);
                                rememberedValue3 = startRestartGroup.rememberedValue();
                                if (!changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue3 = new AnimatedVisibilityScopeImpl(createChildTransitionInternal);
                                    startRestartGroup.updateRememberedValue(rememberedValue3);
                                }
                                startRestartGroup.endReplaceableGroup();
                                AnimatedVisibilityScopeImpl animatedVisibilityScopeImpl = (AnimatedVisibilityScopeImpl) rememberedValue3;
                                int i11 = i7 >> 6;
                                Modifier createModifier = EnterExitTransitionKt.createModifier(createChildTransitionInternal, enterTransition2, exitTransition2, "Built-in", startRestartGroup, (i11 & 112) | 3072 | (i11 & 896));
                                if (onLookaheadMeasured3 == null) {
                                    companion = LayoutModifierKt.layout(Modifier.INSTANCE, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$2
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                                            return m383invoke3p2s80s(measureScope, measurable, constraints.getValue());
                                        }

                                        /* renamed from: invoke-3p2s80s, reason: not valid java name */
                                        public final MeasureResult m383invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                                            final Placeable mo5333measureBRTryo0 = measurable.mo5333measureBRTryo0(j);
                                            OnLookaheadMeasured onLookaheadMeasured5 = OnLookaheadMeasured.this;
                                            if (measureScope.isLookingAhead()) {
                                                onLookaheadMeasured5.m414invokeozmzZPI(IntSizeKt.IntSize(mo5333measureBRTryo0.getWidth(), mo5333measureBRTryo0.getHeight()));
                                            }
                                            return MeasureScope.layout$default(measureScope, mo5333measureBRTryo0.getWidth(), mo5333measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$2$1$1
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
                                } else {
                                    companion = Modifier.INSTANCE;
                                }
                                Modifier then = modifier.then(createModifier.then(companion));
                                startRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                                rememberedValue4 = startRestartGroup.rememberedValue();
                                if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue4 = new AnimatedEnterExitMeasurePolicy(animatedVisibilityScopeImpl);
                                    startRestartGroup.updateRememberedValue(rememberedValue4);
                                }
                                startRestartGroup.endReplaceableGroup();
                                MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue4;
                                startRestartGroup.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(then);
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
                                Updater.m3600setimpl(m3593constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (!m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                                startRestartGroup.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -174036415, "C817@42286L9:AnimatedVisibility.kt#xbi5r1");
                                function3.invoke(animatedVisibilityScopeImpl, startRestartGroup, Integer.valueOf(((i7 >> 18) & 112) | 8));
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                startRestartGroup.endReplaceableGroup();
                                startRestartGroup.endNode();
                                startRestartGroup.endReplaceableGroup();
                            }
                        } else {
                            onLookaheadMeasured3 = onLookaheadMeasured2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        onLookaheadMeasured2 = onLookaheadMeasured3;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        final OnLookaheadMeasured onLookaheadMeasured5 = onLookaheadMeasured2;
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$4
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
                                AnimatedVisibilityKt.AnimatedEnterExitImpl(transition, function1, modifier, enterTransition, exitTransition, function2, onLookaheadMeasured5, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= i8;
                i6 = i3;
                if ((23967451 & i6) == 4793490) {
                }
                if (i5 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                if (function1.invoke(transition.getTargetState()).booleanValue()) {
                }
                startRestartGroup.startReplaceableGroup(1215497572);
                ComposerKt.sourceInformation(startRestartGroup, "CC(createChildTransition)1010@39937L36,1011@39997L74,1012@40094L39,1013@40145L63:Transition.kt#pdpnli");
                int i92 = ((i6 & 14) | 48) & 14;
                startRestartGroup.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
                changed = startRestartGroup.changed(transition);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue = transition.getCurrentState();
                startRestartGroup.updateRememberedValue(rememberedValue);
                startRestartGroup.endReplaceableGroup();
                if (transition.isSeeking()) {
                }
                startRestartGroup.startReplaceableGroup(-466616829);
                ComposerKt.sourceInformation(startRestartGroup, "C789@41329L28:AnimatedVisibility.kt#xbi5r1");
                OnLookaheadMeasured onLookaheadMeasured42 = onLookaheadMeasured2;
                if (ComposerKt.isTraceInProgress()) {
                }
                int i102 = i7 & 126;
                EnterExitState targetEnterExit3 = targetEnterExit(transition, function1, rememberedValue, startRestartGroup, i102);
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.endReplaceableGroup();
                T targetState2 = transition.getTargetState();
                startRestartGroup.startReplaceableGroup(-466616829);
                ComposerKt.sourceInformation(startRestartGroup, "C789@41329L28:AnimatedVisibility.kt#xbi5r1");
                if (ComposerKt.isTraceInProgress()) {
                }
                EnterExitState targetEnterExit22 = targetEnterExit(transition, function1, targetState2, startRestartGroup, i102);
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.endReplaceableGroup();
                onLookaheadMeasured3 = onLookaheadMeasured42;
                createChildTransitionInternal = androidx.compose.animation.core.TransitionKt.createChildTransitionInternal(transition, targetEnterExit3, targetEnterExit22, "EnterExitTransition", startRestartGroup, i92 | 3072);
                startRestartGroup.endReplaceableGroup();
                State rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function2, startRestartGroup, (i7 >> 15) & 14);
                Boolean invoke2 = function2.invoke(createChildTransitionInternal.getCurrentState(), createChildTransitionInternal.getTargetState());
                startRestartGroup.startReplaceableGroup(-311852107);
                changed2 = startRestartGroup.changed(createChildTransitionInternal) | startRestartGroup.changed(rememberUpdatedState2);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!changed2) {
                }
                rememberedValue2 = new AnimatedVisibilityKt$AnimatedEnterExitImpl$shouldDisposeAfterExit$2$1(createChildTransitionInternal, rememberUpdatedState2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
                startRestartGroup.endReplaceableGroup();
                State produceState2 = SnapshotStateKt.produceState(invoke2, (Function2) rememberedValue2, startRestartGroup, 64);
                if (getExitFinished(createChildTransitionInternal)) {
                }
                startRestartGroup.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
                changed3 = startRestartGroup.changed(transition);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (!changed3) {
                }
                rememberedValue3 = new AnimatedVisibilityScopeImpl(createChildTransitionInternal);
                startRestartGroup.updateRememberedValue(rememberedValue3);
                startRestartGroup.endReplaceableGroup();
                AnimatedVisibilityScopeImpl animatedVisibilityScopeImpl2 = (AnimatedVisibilityScopeImpl) rememberedValue3;
                int i112 = i7 >> 6;
                Modifier createModifier2 = EnterExitTransitionKt.createModifier(createChildTransitionInternal, enterTransition2, exitTransition2, "Built-in", startRestartGroup, (i112 & 112) | 3072 | (i112 & 896));
                if (onLookaheadMeasured3 == null) {
                }
                Modifier then2 = modifier.then(createModifier2.then(companion));
                startRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                rememberedValue4 = startRestartGroup.rememberedValue();
                if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                }
                startRestartGroup.endReplaceableGroup();
                MeasurePolicy measurePolicy2 = (MeasurePolicy) rememberedValue4;
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(then2);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                }
                startRestartGroup.startReusableNode();
                if (!startRestartGroup.getInserting()) {
                }
                m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
                Updater.m3600setimpl(m3593constructorimpl, measurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!m3593constructorimpl.getInserting()) {
                }
                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
                modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -174036415, "C817@42286L9:AnimatedVisibility.kt#xbi5r1");
                function3.invoke(animatedVisibilityScopeImpl2, startRestartGroup, Integer.valueOf(((i7 >> 18) & 112) | 8));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                }
                onLookaheadMeasured2 = onLookaheadMeasured3;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            onLookaheadMeasured2 = onLookaheadMeasured;
            if ((i2 & 128) == 0) {
            }
            i3 |= i8;
            i6 = i3;
            if ((23967451 & i6) == 4793490) {
            }
            if (i5 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            if (function1.invoke(transition.getTargetState()).booleanValue()) {
            }
            startRestartGroup.startReplaceableGroup(1215497572);
            ComposerKt.sourceInformation(startRestartGroup, "CC(createChildTransition)1010@39937L36,1011@39997L74,1012@40094L39,1013@40145L63:Transition.kt#pdpnli");
            int i922 = ((i6 & 14) | 48) & 14;
            startRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            changed = startRestartGroup.changed(transition);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue = transition.getCurrentState();
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceableGroup();
            if (transition.isSeeking()) {
            }
            startRestartGroup.startReplaceableGroup(-466616829);
            ComposerKt.sourceInformation(startRestartGroup, "C789@41329L28:AnimatedVisibility.kt#xbi5r1");
            OnLookaheadMeasured onLookaheadMeasured422 = onLookaheadMeasured2;
            if (ComposerKt.isTraceInProgress()) {
            }
            int i1022 = i7 & 126;
            EnterExitState targetEnterExit32 = targetEnterExit(transition, function1, rememberedValue, startRestartGroup, i1022);
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.endReplaceableGroup();
            T targetState22 = transition.getTargetState();
            startRestartGroup.startReplaceableGroup(-466616829);
            ComposerKt.sourceInformation(startRestartGroup, "C789@41329L28:AnimatedVisibility.kt#xbi5r1");
            if (ComposerKt.isTraceInProgress()) {
            }
            EnterExitState targetEnterExit222 = targetEnterExit(transition, function1, targetState22, startRestartGroup, i1022);
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.endReplaceableGroup();
            onLookaheadMeasured3 = onLookaheadMeasured422;
            createChildTransitionInternal = androidx.compose.animation.core.TransitionKt.createChildTransitionInternal(transition, targetEnterExit32, targetEnterExit222, "EnterExitTransition", startRestartGroup, i922 | 3072);
            startRestartGroup.endReplaceableGroup();
            State rememberUpdatedState22 = SnapshotStateKt.rememberUpdatedState(function2, startRestartGroup, (i7 >> 15) & 14);
            Boolean invoke22 = function2.invoke(createChildTransitionInternal.getCurrentState(), createChildTransitionInternal.getTargetState());
            startRestartGroup.startReplaceableGroup(-311852107);
            changed2 = startRestartGroup.changed(createChildTransitionInternal) | startRestartGroup.changed(rememberUpdatedState22);
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!changed2) {
            }
            rememberedValue2 = new AnimatedVisibilityKt$AnimatedEnterExitImpl$shouldDisposeAfterExit$2$1(createChildTransitionInternal, rememberUpdatedState22, null);
            startRestartGroup.updateRememberedValue(rememberedValue2);
            startRestartGroup.endReplaceableGroup();
            State produceState22 = SnapshotStateKt.produceState(invoke22, (Function2) rememberedValue2, startRestartGroup, 64);
            if (getExitFinished(createChildTransitionInternal)) {
            }
            startRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            changed3 = startRestartGroup.changed(transition);
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (!changed3) {
            }
            rememberedValue3 = new AnimatedVisibilityScopeImpl(createChildTransitionInternal);
            startRestartGroup.updateRememberedValue(rememberedValue3);
            startRestartGroup.endReplaceableGroup();
            AnimatedVisibilityScopeImpl animatedVisibilityScopeImpl22 = (AnimatedVisibilityScopeImpl) rememberedValue3;
            int i1122 = i7 >> 6;
            Modifier createModifier22 = EnterExitTransitionKt.createModifier(createChildTransitionInternal, enterTransition2, exitTransition2, "Built-in", startRestartGroup, (i1122 & 112) | 3072 | (i1122 & 896));
            if (onLookaheadMeasured3 == null) {
            }
            Modifier then22 = modifier.then(createModifier22.then(companion));
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            MeasurePolicy measurePolicy22 = (MeasurePolicy) rememberedValue4;
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor22 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf22 = LayoutKt.modifierMaterializerOf(then22);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
            }
            startRestartGroup.startReusableNode();
            if (!startRestartGroup.getInserting()) {
            }
            m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
            Updater.m3600setimpl(m3593constructorimpl, measurePolicy22, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap22, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!m3593constructorimpl.getInserting()) {
            }
            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash22);
            modifierMaterializerOf22.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -174036415, "C817@42286L9:AnimatedVisibility.kt#xbi5r1");
            function3.invoke(animatedVisibilityScopeImpl22, startRestartGroup, Integer.valueOf(((i7 >> 18) & 112) | 8));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
            onLookaheadMeasured2 = onLookaheadMeasured3;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i3 |= i4;
        i5 = i2 & 64;
        if (i5 == 0) {
        }
        onLookaheadMeasured2 = onLookaheadMeasured;
        if ((i2 & 128) == 0) {
        }
        i3 |= i8;
        i6 = i3;
        if ((23967451 & i6) == 4793490) {
        }
        if (i5 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        if (function1.invoke(transition.getTargetState()).booleanValue()) {
        }
        startRestartGroup.startReplaceableGroup(1215497572);
        ComposerKt.sourceInformation(startRestartGroup, "CC(createChildTransition)1010@39937L36,1011@39997L74,1012@40094L39,1013@40145L63:Transition.kt#pdpnli");
        int i9222 = ((i6 & 14) | 48) & 14;
        startRestartGroup.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
        changed = startRestartGroup.changed(transition);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue = transition.getCurrentState();
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceableGroup();
        if (transition.isSeeking()) {
        }
        startRestartGroup.startReplaceableGroup(-466616829);
        ComposerKt.sourceInformation(startRestartGroup, "C789@41329L28:AnimatedVisibility.kt#xbi5r1");
        OnLookaheadMeasured onLookaheadMeasured4222 = onLookaheadMeasured2;
        if (ComposerKt.isTraceInProgress()) {
        }
        int i10222 = i7 & 126;
        EnterExitState targetEnterExit322 = targetEnterExit(transition, function1, rememberedValue, startRestartGroup, i10222);
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.endReplaceableGroup();
        T targetState222 = transition.getTargetState();
        startRestartGroup.startReplaceableGroup(-466616829);
        ComposerKt.sourceInformation(startRestartGroup, "C789@41329L28:AnimatedVisibility.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
        }
        EnterExitState targetEnterExit2222 = targetEnterExit(transition, function1, targetState222, startRestartGroup, i10222);
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.endReplaceableGroup();
        onLookaheadMeasured3 = onLookaheadMeasured4222;
        createChildTransitionInternal = androidx.compose.animation.core.TransitionKt.createChildTransitionInternal(transition, targetEnterExit322, targetEnterExit2222, "EnterExitTransition", startRestartGroup, i9222 | 3072);
        startRestartGroup.endReplaceableGroup();
        State rememberUpdatedState222 = SnapshotStateKt.rememberUpdatedState(function2, startRestartGroup, (i7 >> 15) & 14);
        Boolean invoke222 = function2.invoke(createChildTransitionInternal.getCurrentState(), createChildTransitionInternal.getTargetState());
        startRestartGroup.startReplaceableGroup(-311852107);
        changed2 = startRestartGroup.changed(createChildTransitionInternal) | startRestartGroup.changed(rememberUpdatedState222);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!changed2) {
        }
        rememberedValue2 = new AnimatedVisibilityKt$AnimatedEnterExitImpl$shouldDisposeAfterExit$2$1(createChildTransitionInternal, rememberUpdatedState222, null);
        startRestartGroup.updateRememberedValue(rememberedValue2);
        startRestartGroup.endReplaceableGroup();
        State produceState222 = SnapshotStateKt.produceState(invoke222, (Function2) rememberedValue2, startRestartGroup, 64);
        if (getExitFinished(createChildTransitionInternal)) {
        }
        startRestartGroup.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
        changed3 = startRestartGroup.changed(transition);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (!changed3) {
        }
        rememberedValue3 = new AnimatedVisibilityScopeImpl(createChildTransitionInternal);
        startRestartGroup.updateRememberedValue(rememberedValue3);
        startRestartGroup.endReplaceableGroup();
        AnimatedVisibilityScopeImpl animatedVisibilityScopeImpl222 = (AnimatedVisibilityScopeImpl) rememberedValue3;
        int i11222 = i7 >> 6;
        Modifier createModifier222 = EnterExitTransitionKt.createModifier(createChildTransitionInternal, enterTransition2, exitTransition2, "Built-in", startRestartGroup, (i11222 & 112) | 3072 | (i11222 & 896));
        if (onLookaheadMeasured3 == null) {
        }
        Modifier then222 = modifier.then(createModifier222.then(companion));
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        MeasurePolicy measurePolicy222 = (MeasurePolicy) rememberedValue4;
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor222 = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf222 = LayoutKt.modifierMaterializerOf(then222);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
        }
        startRestartGroup.startReusableNode();
        if (!startRestartGroup.getInserting()) {
        }
        m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
        Updater.m3600setimpl(m3593constructorimpl, measurePolicy222, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap222, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash222 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (!m3593constructorimpl.getInserting()) {
        }
        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash222);
        modifierMaterializerOf222.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -174036415, "C817@42286L9:AnimatedVisibility.kt#xbi5r1");
        function3.invoke(animatedVisibilityScopeImpl222, startRestartGroup, Integer.valueOf(((i7 >> 18) & 112) | 8));
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
        }
        onLookaheadMeasured2 = onLookaheadMeasured3;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getExitFinished(Transition<EnterExitState> transition) {
        return transition.getCurrentState() == EnterExitState.PostExit && transition.getTargetState() == EnterExitState.PostExit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> EnterExitState targetEnterExit(Transition<T> transition, Function1<? super T, Boolean> function1, T t, Composer composer, int i) {
        EnterExitState enterExitState;
        composer.startReplaceableGroup(361571134);
        ComposerKt.sourceInformation(composer, "C(targetEnterExit)P(1):AnimatedVisibility.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(361571134, i, -1, "androidx.compose.animation.targetEnterExit (AnimatedVisibility.kt:889)");
        }
        composer.startMovableGroup(-721835388, transition);
        ComposerKt.sourceInformation(composer, "902@45413L34");
        if (transition.isSeeking()) {
            if (function1.invoke(t).booleanValue()) {
                enterExitState = EnterExitState.Visible;
            } else if (function1.invoke(transition.getCurrentState()).booleanValue()) {
                enterExitState = EnterExitState.PostExit;
            } else {
                enterExitState = EnterExitState.PreEnter;
            }
        } else {
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            MutableState mutableState = (MutableState) rememberedValue;
            if (function1.invoke(transition.getCurrentState()).booleanValue()) {
                mutableState.setValue(true);
            }
            if (function1.invoke(t).booleanValue()) {
                enterExitState = EnterExitState.Visible;
            } else if (((Boolean) mutableState.getValue()).booleanValue()) {
                enterExitState = EnterExitState.PostExit;
            } else {
                enterExitState = EnterExitState.PreEnter;
            }
        }
        composer.endMovableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return enterExitState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function2<EnterExitState, EnterExitState, Boolean> AnimatedEnterExitImpl$lambda$4(State<? extends Function2<? super EnterExitState, ? super EnterExitState, Boolean>> state) {
        return (Function2) state.getValue();
    }

    private static final boolean AnimatedEnterExitImpl$lambda$6(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
