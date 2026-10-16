package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.layout.AlignmentLineKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.RichTooltipTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.profileinstaller.ProfileVerifier;
import com.vungle.ads.internal.protos.Sdk;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Tooltip.kt */
@Metadata(d1 = {"\u0000~\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\u0085\u0001\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u0015\b\u0002\u0010 \u001a\u000f\u0012\u0004\u0012\u00020\u001d\u0018\u00010!¢\u0006\u0002\b\"2\u0015\b\u0002\u0010#\u001a\u000f\u0012\u0004\u0012\u00020\u001d\u0018\u00010!¢\u0006\u0002\b\"2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u00012\b\b\u0002\u0010)\u001a\u00020\u00012\u0011\u0010*\u001a\r\u0012\u0004\u0012\u00020\u001d0!¢\u0006\u0002\b\"H\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001al\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020/2\u001c\u00100\u001a\u0018\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\u001d01¢\u0006\u0002\b\"¢\u0006\u0002\b32\u0006\u00104\u001a\u0002052\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u00108\u001a\u0002072\u0011\u00109\u001a\r\u0012\u0004\u0012\u00020\u001d0!¢\u0006\u0002\b\"H\u0007¢\u0006\u0002\u0010:\u001a&\u0010;\u001a\u0002052\b\b\u0002\u0010<\u001a\u0002072\b\b\u0002\u0010=\u001a\u0002072\b\b\u0002\u0010>\u001a\u00020?H\u0007\u001a+\u0010@\u001a\u0002052\b\b\u0002\u0010<\u001a\u0002072\b\b\u0002\u0010=\u001a\u0002072\b\b\u0002\u0010>\u001a\u00020?H\u0007¢\u0006\u0002\u0010A\u001a\u001a\u0010B\u001a\u00020\u001f*\u00020\u001f2\f\u0010C\u001a\b\u0012\u0004\u0012\u0002070DH\u0000\u001a\u001c\u0010E\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010F\u001a\u0002072\u0006\u0010G\u001a\u000207H\u0003\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\"\u0010\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0016\u0010\u000b\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\f\u0010\r\"\u0010\u0010\u000e\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0016\u0010\u000f\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0010\u0010\r\"\u0010\u0010\u0011\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0016\u0010\u0012\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0013\u0010\r\"\u0010\u0010\u0014\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0015\u001a\u00020\u0016X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0016X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0018\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0019\u0010\r\"\u0016\u0010\u001a\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u001b\u0010\r\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006H²\u0006\f\u0010I\u001a\u0004\u0018\u00010JX\u008a\u008e\u0002²\u0006\n\u0010K\u001a\u00020LX\u008a\u0084\u0002²\u0006\n\u0010M\u001a\u00020LX\u008a\u0084\u0002"}, d2 = {"ActionLabelBottomPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ActionLabelMinHeight", "HeightFromSubheadToTextFirstLine", "HeightToSubheadFirstLine", "PlainTooltipContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getPlainTooltipContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "PlainTooltipHorizontalPadding", "PlainTooltipMaxWidth", "getPlainTooltipMaxWidth", "()F", "PlainTooltipVerticalPadding", "RichTooltipHorizontalPadding", "getRichTooltipHorizontalPadding", "RichTooltipMaxWidth", "SpacingBetweenTooltipAndAnchor", "getSpacingBetweenTooltipAndAnchor", "TextBottomPadding", "TooltipFadeInDuration", "", "TooltipFadeOutDuration", "TooltipMinHeight", "getTooltipMinHeight", "TooltipMinWidth", "getTooltipMinWidth", "RichTooltip", "", "modifier", "Landroidx/compose/ui/Modifier;", "title", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "action", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/RichTooltipColors;", "tonalElevation", "shadowElevation", "text", "RichTooltip-1tP8Re8", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/RichTooltipColors;FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TooltipBox", "positionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "tooltip", "Lkotlin/Function1;", "Landroidx/compose/material3/CaretScope;", "Lkotlin/ExtensionFunctionType;", "state", "Landroidx/compose/material3/TooltipState;", "focusable", "", "enableUserInput", "content", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function3;Landroidx/compose/material3/TooltipState;Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TooltipState", "initialIsVisible", "isPersistent", "mutatorMutex", "Landroidx/compose/foundation/MutatorMutex;", "rememberTooltipState", "(ZZLandroidx/compose/foundation/MutatorMutex;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TooltipState;", "animateTooltip", "transition", "Landroidx/compose/animation/core/Transition;", "textVerticalPadding", "subheadExists", "actionExists", "material3_release", "anchorBounds", "Landroidx/compose/ui/layout/LayoutCoordinates;", "scale", "", "alpha"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TooltipKt {
    private static final float ActionLabelBottomPadding;
    private static final float ActionLabelMinHeight;
    private static final float HeightFromSubheadToTextFirstLine;
    private static final float HeightToSubheadFirstLine;
    private static final PaddingValues PlainTooltipContentPadding;
    private static final float PlainTooltipHorizontalPadding;
    private static final float PlainTooltipVerticalPadding;
    private static final float RichTooltipHorizontalPadding;
    private static final float RichTooltipMaxWidth;
    private static final float SpacingBetweenTooltipAndAnchor;
    private static final float TextBottomPadding;
    public static final int TooltipFadeInDuration = 150;
    public static final int TooltipFadeOutDuration = 75;
    private static final float TooltipMinHeight;
    private static final float TooltipMinWidth = Dp.m6389constructorimpl(40);
    private static final float PlainTooltipMaxWidth = Dp.m6389constructorimpl(200);

    /* JADX WARN: Removed duplicated region for block: B:16:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TooltipBox(final PopupPositionProvider popupPositionProvider, final Function3<? super CaretScope, ? super Composer, ? super Integer, Unit> function3, final TooltipState tooltipState, Modifier modifier, boolean z, boolean z2, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        PopupPositionProvider popupPositionProvider2;
        int i3;
        Modifier modifier2;
        int i4;
        boolean z3;
        int i5;
        boolean z4;
        Object rememberedValue;
        Object rememberedValue2;
        Composer composer2;
        final Modifier modifier3;
        final boolean z5;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(1836749106);
        ComposerKt.sourceInformation(startRestartGroup, "C(TooltipBox)P(4,6,5,3,2,1)120@5234L64,121@5343L33,122@5393L257,139@5846L310:Tooltip.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            popupPositionProvider2 = popupPositionProvider;
        } else {
            popupPositionProvider2 = popupPositionProvider;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changed(popupPositionProvider2) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function3) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changed(tooltipState) ? 256 : 128;
        }
        int i6 = i2 & 8;
        if (i6 != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 2048 : 1024;
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                z3 = z;
                i3 |= startRestartGroup.changed(z3) ? 16384 : 8192;
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i) == 0) {
                    z4 = z2;
                    i3 |= startRestartGroup.changed(z4) ? 131072 : 65536;
                    if ((i2 & 64) == 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        i3 |= startRestartGroup.changedInstance(function2) ? 1048576 : 524288;
                    }
                    if ((599187 & i3) == 599186 || !startRestartGroup.getSkipping()) {
                        if (i6 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i5 != 0) {
                            z4 = true;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1836749106, i3, -1, "androidx.compose.material3.TooltipBox (Tooltip.kt:118)");
                        }
                        final Transition updateTransition = TransitionKt.updateTransition((MutableTransitionState) tooltipState.getTransition(), "tooltip transition", startRestartGroup, MutableTransitionState.$stable | 48, 0);
                        startRestartGroup.startReplaceableGroup(2029979988);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Tooltip.kt#9igjgp");
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        final MutableState mutableState = (MutableState) rememberedValue;
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.startReplaceableGroup(2029980038);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Tooltip.kt#9igjgp");
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = new CaretScope() { // from class: androidx.compose.material3.TooltipKt$TooltipBox$scope$1$1
                                @Override // androidx.compose.material3.CaretScope
                                public Modifier drawCaret(Modifier modifier4, final Function2<? super CacheDrawScope, ? super LayoutCoordinates, DrawResult> function22) {
                                    final MutableState<LayoutCoordinates> mutableState2 = mutableState;
                                    return DrawModifierKt.drawWithCache(modifier4, new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.compose.material3.TooltipKt$TooltipBox$scope$1$1$drawCaret$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                                            LayoutCoordinates TooltipBox$lambda$1;
                                            Function2<CacheDrawScope, LayoutCoordinates, DrawResult> function23 = function22;
                                            TooltipBox$lambda$1 = TooltipKt.TooltipBox$lambda$1(mutableState2);
                                            return function23.invoke(cacheDrawScope, TooltipBox$lambda$1);
                                        }
                                    });
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                        }
                        final TooltipKt$TooltipBox$scope$1$1 tooltipKt$TooltipBox$scope$1$1 = (TooltipKt$TooltipBox$scope$1$1) rememberedValue2;
                        startRestartGroup.endReplaceableGroup();
                        composer2 = startRestartGroup;
                        boolean z6 = z3;
                        Modifier modifier4 = modifier2;
                        BasicTooltip_androidKt.BasicTooltipBox(popupPositionProvider2, ComposableLambdaKt.composableLambda(startRestartGroup, -149611544, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TooltipKt$TooltipBox$1
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

                            public final void invoke(Composer composer3, int i7) {
                                ComposerKt.sourceInformation(composer3, "C141@5928L60:Tooltip.kt#uh7d8r");
                                if ((i7 & 3) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-149611544, i7, -1, "androidx.compose.material3.TooltipBox.<anonymous> (Tooltip.kt:141)");
                                }
                                Modifier animateTooltip = TooltipKt.animateTooltip(Modifier.INSTANCE, updateTransition);
                                Function3<CaretScope, Composer, Integer, Unit> function32 = function3;
                                TooltipKt$TooltipBox$scope$1$1 tooltipKt$TooltipBox$scope$1$12 = tooltipKt$TooltipBox$scope$1$1;
                                composer3.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                composer3.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(animateTooltip);
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
                                ComposerKt.sourceInformationMarkerStart(composer3, -824895606, "C141@5977L9:Tooltip.kt#uh7d8r");
                                function32.invoke(tooltipKt$TooltipBox$scope$1$12, composer3, 6);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endReplaceableGroup();
                                composer3.endNode();
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), tooltipState, modifier4, z6, z4, ComposableLambdaKt.composableLambda(startRestartGroup, -1130808188, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TooltipKt$TooltipBox$wrappedContent$1
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

                            public final void invoke(Composer composer3, int i7) {
                                ComposerKt.sourceInformation(composer3, "C133@5769L21,132@5711L123:Tooltip.kt#uh7d8r");
                                if ((i7 & 3) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1130808188, i7, -1, "androidx.compose.material3.TooltipBox.<anonymous> (Tooltip.kt:132)");
                                    }
                                    Modifier.Companion companion = Modifier.INSTANCE;
                                    composer3.startReplaceableGroup(-1995831905);
                                    ComposerKt.sourceInformation(composer3, "CC(remember):Tooltip.kt#9igjgp");
                                    final MutableState<LayoutCoordinates> mutableState2 = mutableState;
                                    Object rememberedValue3 = composer3.rememberedValue();
                                    if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue3 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material3.TooltipKt$TooltipBox$wrappedContent$1$1$1
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
                                                mutableState2.setValue(layoutCoordinates);
                                            }
                                        };
                                        composer3.updateRememberedValue(rememberedValue3);
                                    }
                                    composer3.endReplaceableGroup();
                                    Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(companion, (Function1) rememberedValue3);
                                    Function2<Composer, Integer, Unit> function22 = function2;
                                    composer3.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                    composer3.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(onGloballyPositioned);
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
                                    ComposerKt.sourceInformationMarkerStart(composer3, -824895762, "C135@5815L9:Tooltip.kt#uh7d8r");
                                    function22.invoke(composer3, 0);
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
                        }), composer2, (i3 & 14) | 1572912 | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (i3 & 458752), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        z5 = z6;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        composer2 = startRestartGroup;
                        modifier3 = modifier2;
                        z5 = z3;
                    }
                    final boolean z7 = z4;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TooltipKt$TooltipBox$2
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

                            public final void invoke(Composer composer3, int i7) {
                                TooltipKt.TooltipBox(PopupPositionProvider.this, function3, tooltipState, modifier3, z5, z7, function2, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                z4 = z2;
                if ((i2 & 64) == 0) {
                }
                if ((599187 & i3) == 599186) {
                }
                if (i6 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                final Transition<Boolean> updateTransition2 = TransitionKt.updateTransition((MutableTransitionState) tooltipState.getTransition(), "tooltip transition", startRestartGroup, MutableTransitionState.$stable | 48, 0);
                startRestartGroup.startReplaceableGroup(2029979988);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Tooltip.kt#9igjgp");
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                }
                final MutableState<LayoutCoordinates> mutableState2 = (MutableState) rememberedValue;
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(2029980038);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Tooltip.kt#9igjgp");
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                }
                final TooltipKt$TooltipBox$scope$1$1 tooltipKt$TooltipBox$scope$1$12 = (TooltipKt$TooltipBox$scope$1$1) rememberedValue2;
                startRestartGroup.endReplaceableGroup();
                composer2 = startRestartGroup;
                boolean z62 = z3;
                Modifier modifier42 = modifier2;
                BasicTooltip_androidKt.BasicTooltipBox(popupPositionProvider2, ComposableLambdaKt.composableLambda(startRestartGroup, -149611544, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TooltipKt$TooltipBox$1
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

                    public final void invoke(Composer composer3, int i7) {
                        ComposerKt.sourceInformation(composer3, "C141@5928L60:Tooltip.kt#uh7d8r");
                        if ((i7 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-149611544, i7, -1, "androidx.compose.material3.TooltipBox.<anonymous> (Tooltip.kt:141)");
                        }
                        Modifier animateTooltip = TooltipKt.animateTooltip(Modifier.INSTANCE, updateTransition2);
                        Function3<CaretScope, Composer, Integer, Unit> function32 = function3;
                        TooltipKt$TooltipBox$scope$1$1 tooltipKt$TooltipBox$scope$1$122 = tooltipKt$TooltipBox$scope$1$12;
                        composer3.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(animateTooltip);
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
                        ComposerKt.sourceInformationMarkerStart(composer3, -824895606, "C141@5977L9:Tooltip.kt#uh7d8r");
                        function32.invoke(tooltipKt$TooltipBox$scope$1$122, composer3, 6);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), tooltipState, modifier42, z62, z4, ComposableLambdaKt.composableLambda(startRestartGroup, -1130808188, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TooltipKt$TooltipBox$wrappedContent$1
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

                    public final void invoke(Composer composer3, int i7) {
                        ComposerKt.sourceInformation(composer3, "C133@5769L21,132@5711L123:Tooltip.kt#uh7d8r");
                        if ((i7 & 3) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1130808188, i7, -1, "androidx.compose.material3.TooltipBox.<anonymous> (Tooltip.kt:132)");
                            }
                            Modifier.Companion companion = Modifier.INSTANCE;
                            composer3.startReplaceableGroup(-1995831905);
                            ComposerKt.sourceInformation(composer3, "CC(remember):Tooltip.kt#9igjgp");
                            final MutableState<LayoutCoordinates> mutableState22 = mutableState2;
                            Object rememberedValue3 = composer3.rememberedValue();
                            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue3 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material3.TooltipKt$TooltipBox$wrappedContent$1$1$1
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
                                        mutableState22.setValue(layoutCoordinates);
                                    }
                                };
                                composer3.updateRememberedValue(rememberedValue3);
                            }
                            composer3.endReplaceableGroup();
                            Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(companion, (Function1) rememberedValue3);
                            Function2<Composer, Integer, Unit> function22 = function2;
                            composer3.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                            composer3.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(onGloballyPositioned);
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
                            ComposerKt.sourceInformationMarkerStart(composer3, -824895762, "C135@5815L9:Tooltip.kt#uh7d8r");
                            function22.invoke(composer3, 0);
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
                }), composer2, (i3 & 14) | 1572912 | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (i3 & 458752), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier42;
                z5 = z62;
                final boolean z72 = z4;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z3 = z;
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            z4 = z2;
            if ((i2 & 64) == 0) {
            }
            if ((599187 & i3) == 599186) {
            }
            if (i6 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            final Transition<Boolean> updateTransition22 = TransitionKt.updateTransition((MutableTransitionState) tooltipState.getTransition(), "tooltip transition", startRestartGroup, MutableTransitionState.$stable | 48, 0);
            startRestartGroup.startReplaceableGroup(2029979988);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Tooltip.kt#9igjgp");
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            final MutableState<LayoutCoordinates> mutableState22 = (MutableState) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(2029980038);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Tooltip.kt#9igjgp");
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            }
            final TooltipKt$TooltipBox$scope$1$1 tooltipKt$TooltipBox$scope$1$122 = (TooltipKt$TooltipBox$scope$1$1) rememberedValue2;
            startRestartGroup.endReplaceableGroup();
            composer2 = startRestartGroup;
            boolean z622 = z3;
            Modifier modifier422 = modifier2;
            BasicTooltip_androidKt.BasicTooltipBox(popupPositionProvider2, ComposableLambdaKt.composableLambda(startRestartGroup, -149611544, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TooltipKt$TooltipBox$1
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

                public final void invoke(Composer composer3, int i7) {
                    ComposerKt.sourceInformation(composer3, "C141@5928L60:Tooltip.kt#uh7d8r");
                    if ((i7 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-149611544, i7, -1, "androidx.compose.material3.TooltipBox.<anonymous> (Tooltip.kt:141)");
                    }
                    Modifier animateTooltip = TooltipKt.animateTooltip(Modifier.INSTANCE, updateTransition22);
                    Function3<CaretScope, Composer, Integer, Unit> function32 = function3;
                    TooltipKt$TooltipBox$scope$1$1 tooltipKt$TooltipBox$scope$1$1222 = tooltipKt$TooltipBox$scope$1$122;
                    composer3.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(animateTooltip);
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
                    ComposerKt.sourceInformationMarkerStart(composer3, -824895606, "C141@5977L9:Tooltip.kt#uh7d8r");
                    function32.invoke(tooltipKt$TooltipBox$scope$1$1222, composer3, 6);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), tooltipState, modifier422, z622, z4, ComposableLambdaKt.composableLambda(startRestartGroup, -1130808188, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TooltipKt$TooltipBox$wrappedContent$1
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

                public final void invoke(Composer composer3, int i7) {
                    ComposerKt.sourceInformation(composer3, "C133@5769L21,132@5711L123:Tooltip.kt#uh7d8r");
                    if ((i7 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1130808188, i7, -1, "androidx.compose.material3.TooltipBox.<anonymous> (Tooltip.kt:132)");
                        }
                        Modifier.Companion companion = Modifier.INSTANCE;
                        composer3.startReplaceableGroup(-1995831905);
                        ComposerKt.sourceInformation(composer3, "CC(remember):Tooltip.kt#9igjgp");
                        final MutableState<LayoutCoordinates> mutableState222 = mutableState22;
                        Object rememberedValue3 = composer3.rememberedValue();
                        if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue3 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material3.TooltipKt$TooltipBox$wrappedContent$1$1$1
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
                                    mutableState222.setValue(layoutCoordinates);
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue3);
                        }
                        composer3.endReplaceableGroup();
                        Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(companion, (Function1) rememberedValue3);
                        Function2<Composer, Integer, Unit> function22 = function2;
                        composer3.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(onGloballyPositioned);
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
                        ComposerKt.sourceInformationMarkerStart(composer3, -824895762, "C135@5815L9:Tooltip.kt#uh7d8r");
                        function22.invoke(composer3, 0);
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
            }), composer2, (i3 & 14) | 1572912 | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (i3 & 458752), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier422;
            z5 = z622;
            final boolean z722 = z4;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        z3 = z;
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        z4 = z2;
        if ((i2 & 64) == 0) {
        }
        if ((599187 & i3) == 599186) {
        }
        if (i6 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        final Transition<Boolean> updateTransition222 = TransitionKt.updateTransition((MutableTransitionState) tooltipState.getTransition(), "tooltip transition", startRestartGroup, MutableTransitionState.$stable | 48, 0);
        startRestartGroup.startReplaceableGroup(2029979988);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Tooltip.kt#9igjgp");
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        final MutableState<LayoutCoordinates> mutableState222 = (MutableState) rememberedValue;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(2029980038);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Tooltip.kt#9igjgp");
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
        }
        final TooltipKt$TooltipBox$scope$1$1 tooltipKt$TooltipBox$scope$1$1222 = (TooltipKt$TooltipBox$scope$1$1) rememberedValue2;
        startRestartGroup.endReplaceableGroup();
        composer2 = startRestartGroup;
        boolean z6222 = z3;
        Modifier modifier4222 = modifier2;
        BasicTooltip_androidKt.BasicTooltipBox(popupPositionProvider2, ComposableLambdaKt.composableLambda(startRestartGroup, -149611544, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TooltipKt$TooltipBox$1
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

            public final void invoke(Composer composer3, int i7) {
                ComposerKt.sourceInformation(composer3, "C141@5928L60:Tooltip.kt#uh7d8r");
                if ((i7 & 3) == 2 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-149611544, i7, -1, "androidx.compose.material3.TooltipBox.<anonymous> (Tooltip.kt:141)");
                }
                Modifier animateTooltip = TooltipKt.animateTooltip(Modifier.INSTANCE, updateTransition222);
                Function3<CaretScope, Composer, Integer, Unit> function32 = function3;
                TooltipKt$TooltipBox$scope$1$1 tooltipKt$TooltipBox$scope$1$12222 = tooltipKt$TooltipBox$scope$1$1222;
                composer3.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                composer3.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(animateTooltip);
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
                ComposerKt.sourceInformationMarkerStart(composer3, -824895606, "C141@5977L9:Tooltip.kt#uh7d8r");
                function32.invoke(tooltipKt$TooltipBox$scope$1$12222, composer3, 6);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endReplaceableGroup();
                composer3.endNode();
                composer3.endReplaceableGroup();
                composer3.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), tooltipState, modifier4222, z6222, z4, ComposableLambdaKt.composableLambda(startRestartGroup, -1130808188, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TooltipKt$TooltipBox$wrappedContent$1
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

            public final void invoke(Composer composer3, int i7) {
                ComposerKt.sourceInformation(composer3, "C133@5769L21,132@5711L123:Tooltip.kt#uh7d8r");
                if ((i7 & 3) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1130808188, i7, -1, "androidx.compose.material3.TooltipBox.<anonymous> (Tooltip.kt:132)");
                    }
                    Modifier.Companion companion = Modifier.INSTANCE;
                    composer3.startReplaceableGroup(-1995831905);
                    ComposerKt.sourceInformation(composer3, "CC(remember):Tooltip.kt#9igjgp");
                    final MutableState<LayoutCoordinates> mutableState2222 = mutableState222;
                    Object rememberedValue3 = composer3.rememberedValue();
                    if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue3 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material3.TooltipKt$TooltipBox$wrappedContent$1$1$1
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
                                mutableState2222.setValue(layoutCoordinates);
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue3);
                    }
                    composer3.endReplaceableGroup();
                    Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(companion, (Function1) rememberedValue3);
                    Function2<Composer, Integer, Unit> function22 = function2;
                    composer3.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(onGloballyPositioned);
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
                    ComposerKt.sourceInformationMarkerStart(composer3, -824895762, "C135@5815L9:Tooltip.kt#uh7d8r");
                    function22.invoke(composer3, 0);
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
        }), composer2, (i3 & 14) | 1572912 | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (i3 & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier4222;
        z5 = z6222;
        final boolean z7222 = z4;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LayoutCoordinates TooltipBox$lambda$1(MutableState<LayoutCoordinates> mutableState) {
        return mutableState.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00c8  */
    /* renamed from: RichTooltip-1tP8Re8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2924RichTooltip1tP8Re8(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Shape shape, RichTooltipColors richTooltipColors, float f, float f2, final Function2<? super Composer, ? super Integer, Unit> function23, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function25;
        Shape shape2;
        RichTooltipColors richTooltipColors2;
        int i5;
        float f3;
        int i6;
        Modifier.Companion companion;
        final RichTooltipColors richTooltipColors3;
        float f4;
        int i7;
        int i8;
        float m3426getContainerElevationD9Ej5fM;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        Composer composer2;
        final Modifier modifier3;
        final RichTooltipColors richTooltipColors4;
        final float f5;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        final float f6;
        ScopeUpdateScope endRestartGroup;
        int i9;
        int i10;
        Composer startRestartGroup = composer.startRestartGroup(1589779214);
        ComposerKt.sourceInformation(startRestartGroup, "C(RichTooltip)P(2,6!1,4!1,7:c#ui.unit.Dp,3:c#ui.unit.Dp)230@9367L25,231@9442L19,236@9631L2169:Tooltip.kt#uh7d8r");
        int i11 = i2 & 1;
        if (i11 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i12 = i2 & 2;
        if (i12 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            function24 = function2;
            i3 |= startRestartGroup.changedInstance(function24) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                function25 = function22;
                i3 |= startRestartGroup.changedInstance(function25) ? 256 : 128;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        shape2 = shape;
                        if (startRestartGroup.changed(shape2)) {
                            i10 = 2048;
                            i3 |= i10;
                        }
                    } else {
                        shape2 = shape;
                    }
                    i10 = 1024;
                    i3 |= i10;
                } else {
                    shape2 = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        richTooltipColors2 = richTooltipColors;
                        if (startRestartGroup.changed(richTooltipColors2)) {
                            i9 = 16384;
                            i3 |= i9;
                        }
                    } else {
                        richTooltipColors2 = richTooltipColors;
                    }
                    i9 = 8192;
                    i3 |= i9;
                } else {
                    richTooltipColors2 = richTooltipColors;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i) == 0) {
                    f3 = f;
                    i3 |= startRestartGroup.changed(f3) ? 131072 : 65536;
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        i3 |= startRestartGroup.changed(f2) ? 1048576 : 524288;
                    }
                    if ((i2 & 128) == 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i3 |= startRestartGroup.changedInstance(function23) ? 8388608 : 4194304;
                    }
                    if ((4793491 & i3) == 4793490 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            companion = i11 == 0 ? Modifier.INSTANCE : modifier2;
                            if (i12 != 0) {
                                function24 = null;
                            }
                            if (i4 != 0) {
                                function25 = null;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                                shape2 = TooltipDefaults.INSTANCE.getRichTooltipContainerShape(startRestartGroup, 6);
                            }
                            if ((i2 & 16) != 0) {
                                i3 = (-57345) & i3;
                                richTooltipColors2 = TooltipDefaults.INSTANCE.richTooltipColors(startRestartGroup, 6);
                            }
                            if (i5 != 0) {
                                f3 = RichTooltipTokens.INSTANCE.m3426getContainerElevationD9Ej5fM();
                            }
                            if (i6 != 0) {
                                richTooltipColors3 = richTooltipColors2;
                                f4 = f3;
                                i7 = 12582912;
                                i8 = 1589779214;
                                m3426getContainerElevationD9Ej5fM = RichTooltipTokens.INSTANCE.m3426getContainerElevationD9Ej5fM();
                                function26 = function25;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.material3.RichTooltip (Tooltip.kt:235)");
                                }
                                int i13 = ((i3 >> 6) & 112) | i7;
                                int i14 = i3 >> 3;
                                composer2 = startRestartGroup;
                                SurfaceKt.m2633SurfaceT9BRK9s(SizeKt.m932sizeInqDBjuR0$default(companion, TooltipMinWidth, TooltipMinHeight, RichTooltipMaxWidth, 0.0f, 8, null), shape2, richTooltipColors3.getContainerColor(), 0L, f4, m3426getContainerElevationD9Ej5fM, null, ComposableLambdaKt.composableLambda(startRestartGroup, 4342931, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TooltipKt$RichTooltip$1
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

                                    public final void invoke(Composer composer3, int i15) {
                                        float f7;
                                        RichTooltipColors richTooltipColors5;
                                        Modifier textVerticalPadding;
                                        float f8;
                                        float f9;
                                        ComposerKt.sourceInformation(composer3, "C249@10055L10,251@10172L10,253@10284L10,255@10352L1442:Tooltip.kt#uh7d8r");
                                        if ((i15 & 3) != 2 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(4342931, i15, -1, "androidx.compose.material3.RichTooltip.<anonymous> (Tooltip.kt:248)");
                                            }
                                            TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer3, 6), RichTooltipTokens.INSTANCE.getActionLabelTextFont());
                                            TextStyle fromToken2 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer3, 6), RichTooltipTokens.INSTANCE.getSubheadFont());
                                            TextStyle fromToken3 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer3, 6), RichTooltipTokens.INSTANCE.getSupportingTextFont());
                                            Modifier m881paddingVpY3zN4$default = PaddingKt.m881paddingVpY3zN4$default(Modifier.INSTANCE, TooltipKt.getRichTooltipHorizontalPadding(), 0.0f, 2, null);
                                            Function2<Composer, Integer, Unit> function29 = function24;
                                            Function2<Composer, Integer, Unit> function210 = function26;
                                            RichTooltipColors richTooltipColors6 = richTooltipColors3;
                                            Function2<Composer, Integer, Unit> function211 = function23;
                                            composer3.startReplaceableGroup(-483455358);
                                            ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                            composer3.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m881paddingVpY3zN4$default);
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
                                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer3, -1216116127, "C269@10905L349:Tooltip.kt#uh7d8r");
                                            composer3.startReplaceableGroup(-1216116120);
                                            ComposerKt.sourceInformation(composer3, "*259@10496L382");
                                            if (function29 == null) {
                                                richTooltipColors5 = richTooltipColors6;
                                            } else {
                                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                                f7 = TooltipKt.HeightToSubheadFirstLine;
                                                richTooltipColors5 = richTooltipColors6;
                                                Modifier m763paddingFromBaselineVpY3zN4$default = AlignmentLineKt.m763paddingFromBaselineVpY3zN4$default(companion2, f7, 0.0f, 2, null);
                                                composer3.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                                composer3.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                                CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m763paddingFromBaselineVpY3zN4$default);
                                                if (!(composer3.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer3.startReusableNode();
                                                if (composer3.getInserting()) {
                                                    composer3.createNode(constructor2);
                                                } else {
                                                    composer3.useNode();
                                                }
                                                Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                                                Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                    m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                    m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                                }
                                                modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                                composer3.startReplaceableGroup(2058660585);
                                                ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer3, -137016375, "C262@10633L227:Tooltip.kt#uh7d8r");
                                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(richTooltipColors5.getTitleContentColor())), TextKt.getLocalTextStyle().provides(fromToken2)}, function29, composer3, 0);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                composer3.endReplaceableGroup();
                                                composer3.endNode();
                                                composer3.endReplaceableGroup();
                                                composer3.endReplaceableGroup();
                                                Unit unit = Unit.INSTANCE;
                                                Unit unit2 = Unit.INSTANCE;
                                            }
                                            composer3.endReplaceableGroup();
                                            textVerticalPadding = TooltipKt.textVerticalPadding(Modifier.INSTANCE, function29 != null, function210 != null);
                                            composer3.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                            composer3.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                            CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(textVerticalPadding);
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
                                            Updater.m3600setimpl(m3593constructorimpl3, rememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3600setimpl(m3593constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if (m3593constructorimpl3.getInserting() || !Intrinsics.areEqual(m3593constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                                m3593constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                                m3593constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                            }
                                            modifierMaterializerOf3.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                            composer3.startReplaceableGroup(2058660585);
                                            ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer3, 1307460020, "C272@11029L211:Tooltip.kt#uh7d8r");
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(richTooltipColors5.getContentColor())), TextKt.getLocalTextStyle().provides(fromToken3)}, function211, composer3, 0);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            composer3.endReplaceableGroup();
                                            composer3.endNode();
                                            composer3.endReplaceableGroup();
                                            composer3.endReplaceableGroup();
                                            composer3.startReplaceableGroup(-8196376);
                                            ComposerKt.sourceInformation(composer3, "*279@11297L473");
                                            if (function210 != null) {
                                                Modifier.Companion companion3 = Modifier.INSTANCE;
                                                f8 = TooltipKt.ActionLabelMinHeight;
                                                Modifier m919requiredHeightInVpY3zN4$default = SizeKt.m919requiredHeightInVpY3zN4$default(companion3, f8, 0.0f, 2, null);
                                                f9 = TooltipKt.ActionLabelBottomPadding;
                                                Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(m919requiredHeightInVpY3zN4$default, 0.0f, 0.0f, 0.0f, f9, 7, null);
                                                composer3.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                                composer3.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                                CompositionLocalMap currentCompositionLocalMap4 = composer3.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
                                                if (!(composer3.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer3.startReusableNode();
                                                if (composer3.getInserting()) {
                                                    composer3.createNode(constructor4);
                                                } else {
                                                    composer3.useNode();
                                                }
                                                Composer m3593constructorimpl4 = Updater.m3593constructorimpl(composer3);
                                                Updater.m3600setimpl(m3593constructorimpl4, rememberBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3600setimpl(m3593constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if (m3593constructorimpl4.getInserting() || !Intrinsics.areEqual(m3593constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                                    m3593constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                                    m3593constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                                                }
                                                modifierMaterializerOf4.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                                composer3.startReplaceableGroup(2058660585);
                                                ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer3, -137015488, "C284@11520L232:Tooltip.kt#uh7d8r");
                                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(richTooltipColors5.getActionContentColor())), TextKt.getLocalTextStyle().provides(fromToken)}, function210, composer3, 0);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                composer3.endReplaceableGroup();
                                                composer3.endNode();
                                                composer3.endReplaceableGroup();
                                                composer3.endReplaceableGroup();
                                                Unit unit3 = Unit.INSTANCE;
                                                Unit unit4 = Unit.INSTANCE;
                                            }
                                            composer3.endReplaceableGroup();
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
                                }), composer2, i13 | (57344 & i14) | (i14 & 458752), 72);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = companion;
                                richTooltipColors4 = richTooltipColors3;
                                f5 = m3426getContainerElevationD9Ej5fM;
                                function27 = function26;
                                function28 = function24;
                                f6 = f4;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            companion = modifier2;
                        }
                        function26 = function25;
                        richTooltipColors3 = richTooltipColors2;
                        f4 = f3;
                        i7 = 12582912;
                        i8 = 1589779214;
                        m3426getContainerElevationD9Ej5fM = f2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i132 = ((i3 >> 6) & 112) | i7;
                        int i142 = i3 >> 3;
                        composer2 = startRestartGroup;
                        SurfaceKt.m2633SurfaceT9BRK9s(SizeKt.m932sizeInqDBjuR0$default(companion, TooltipMinWidth, TooltipMinHeight, RichTooltipMaxWidth, 0.0f, 8, null), shape2, richTooltipColors3.getContainerColor(), 0L, f4, m3426getContainerElevationD9Ej5fM, null, ComposableLambdaKt.composableLambda(startRestartGroup, 4342931, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TooltipKt$RichTooltip$1
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

                            public final void invoke(Composer composer3, int i15) {
                                float f7;
                                RichTooltipColors richTooltipColors5;
                                Modifier textVerticalPadding;
                                float f8;
                                float f9;
                                ComposerKt.sourceInformation(composer3, "C249@10055L10,251@10172L10,253@10284L10,255@10352L1442:Tooltip.kt#uh7d8r");
                                if ((i15 & 3) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(4342931, i15, -1, "androidx.compose.material3.RichTooltip.<anonymous> (Tooltip.kt:248)");
                                    }
                                    TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer3, 6), RichTooltipTokens.INSTANCE.getActionLabelTextFont());
                                    TextStyle fromToken2 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer3, 6), RichTooltipTokens.INSTANCE.getSubheadFont());
                                    TextStyle fromToken3 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer3, 6), RichTooltipTokens.INSTANCE.getSupportingTextFont());
                                    Modifier m881paddingVpY3zN4$default = PaddingKt.m881paddingVpY3zN4$default(Modifier.INSTANCE, TooltipKt.getRichTooltipHorizontalPadding(), 0.0f, 2, null);
                                    Function2<Composer, Integer, Unit> function29 = function24;
                                    Function2<Composer, Integer, Unit> function210 = function26;
                                    RichTooltipColors richTooltipColors6 = richTooltipColors3;
                                    Function2<Composer, Integer, Unit> function211 = function23;
                                    composer3.startReplaceableGroup(-483455358);
                                    ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                    composer3.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m881paddingVpY3zN4$default);
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
                                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer3, -1216116127, "C269@10905L349:Tooltip.kt#uh7d8r");
                                    composer3.startReplaceableGroup(-1216116120);
                                    ComposerKt.sourceInformation(composer3, "*259@10496L382");
                                    if (function29 == null) {
                                        richTooltipColors5 = richTooltipColors6;
                                    } else {
                                        Modifier.Companion companion2 = Modifier.INSTANCE;
                                        f7 = TooltipKt.HeightToSubheadFirstLine;
                                        richTooltipColors5 = richTooltipColors6;
                                        Modifier m763paddingFromBaselineVpY3zN4$default = AlignmentLineKt.m763paddingFromBaselineVpY3zN4$default(companion2, f7, 0.0f, 2, null);
                                        composer3.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                        composer3.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                        CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m763paddingFromBaselineVpY3zN4$default);
                                        if (!(composer3.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer3.startReusableNode();
                                        if (composer3.getInserting()) {
                                            composer3.createNode(constructor2);
                                        } else {
                                            composer3.useNode();
                                        }
                                        Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                                        Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                            m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                            m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                        }
                                        modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                        composer3.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer3, -137016375, "C262@10633L227:Tooltip.kt#uh7d8r");
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(richTooltipColors5.getTitleContentColor())), TextKt.getLocalTextStyle().provides(fromToken2)}, function29, composer3, 0);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        composer3.endReplaceableGroup();
                                        composer3.endNode();
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        Unit unit = Unit.INSTANCE;
                                        Unit unit2 = Unit.INSTANCE;
                                    }
                                    composer3.endReplaceableGroup();
                                    textVerticalPadding = TooltipKt.textVerticalPadding(Modifier.INSTANCE, function29 != null, function210 != null);
                                    composer3.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                    MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                    composer3.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(textVerticalPadding);
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
                                    Updater.m3600setimpl(m3593constructorimpl3, rememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3600setimpl(m3593constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m3593constructorimpl3.getInserting() || !Intrinsics.areEqual(m3593constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                        m3593constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                        m3593constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                    }
                                    modifierMaterializerOf3.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                    composer3.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer3, 1307460020, "C272@11029L211:Tooltip.kt#uh7d8r");
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(richTooltipColors5.getContentColor())), TextKt.getLocalTextStyle().provides(fromToken3)}, function211, composer3, 0);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    composer3.endReplaceableGroup();
                                    composer3.endNode();
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    composer3.startReplaceableGroup(-8196376);
                                    ComposerKt.sourceInformation(composer3, "*279@11297L473");
                                    if (function210 != null) {
                                        Modifier.Companion companion3 = Modifier.INSTANCE;
                                        f8 = TooltipKt.ActionLabelMinHeight;
                                        Modifier m919requiredHeightInVpY3zN4$default = SizeKt.m919requiredHeightInVpY3zN4$default(companion3, f8, 0.0f, 2, null);
                                        f9 = TooltipKt.ActionLabelBottomPadding;
                                        Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(m919requiredHeightInVpY3zN4$default, 0.0f, 0.0f, 0.0f, f9, 7, null);
                                        composer3.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                        composer3.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                        CompositionLocalMap currentCompositionLocalMap4 = composer3.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
                                        if (!(composer3.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer3.startReusableNode();
                                        if (composer3.getInserting()) {
                                            composer3.createNode(constructor4);
                                        } else {
                                            composer3.useNode();
                                        }
                                        Composer m3593constructorimpl4 = Updater.m3593constructorimpl(composer3);
                                        Updater.m3600setimpl(m3593constructorimpl4, rememberBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3600setimpl(m3593constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (m3593constructorimpl4.getInserting() || !Intrinsics.areEqual(m3593constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                            m3593constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                            m3593constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                                        }
                                        modifierMaterializerOf4.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                        composer3.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer3, -137015488, "C284@11520L232:Tooltip.kt#uh7d8r");
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(richTooltipColors5.getActionContentColor())), TextKt.getLocalTextStyle().provides(fromToken)}, function210, composer3, 0);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        composer3.endReplaceableGroup();
                                        composer3.endNode();
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        Unit unit3 = Unit.INSTANCE;
                                        Unit unit4 = Unit.INSTANCE;
                                    }
                                    composer3.endReplaceableGroup();
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
                        }), composer2, i132 | (57344 & i142) | (i142 & 458752), 72);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier3 = companion;
                        richTooltipColors4 = richTooltipColors3;
                        f5 = m3426getContainerElevationD9Ej5fM;
                        function27 = function26;
                        function28 = function24;
                        f6 = f4;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        f5 = f2;
                        composer2 = startRestartGroup;
                        modifier3 = modifier2;
                        function28 = function24;
                        function27 = function25;
                        richTooltipColors4 = richTooltipColors2;
                        f6 = f3;
                    }
                    final Shape shape3 = shape2;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TooltipKt$RichTooltip$2
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

                            public final void invoke(Composer composer3, int i15) {
                                TooltipKt.m2924RichTooltip1tP8Re8(Modifier.this, function28, function27, shape3, richTooltipColors4, f6, f5, function23, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                f3 = f;
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                if ((i2 & 128) == 0) {
                }
                if ((4793491 & i3) == 4793490) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i11 == 0) {
                }
                if (i12 != 0) {
                }
                if (i4 != 0) {
                }
                if ((i2 & 8) != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                function26 = function25;
                richTooltipColors3 = richTooltipColors2;
                f4 = f3;
                i7 = 12582912;
                i8 = 1589779214;
                m3426getContainerElevationD9Ej5fM = f2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i1322 = ((i3 >> 6) & 112) | i7;
                int i1422 = i3 >> 3;
                composer2 = startRestartGroup;
                SurfaceKt.m2633SurfaceT9BRK9s(SizeKt.m932sizeInqDBjuR0$default(companion, TooltipMinWidth, TooltipMinHeight, RichTooltipMaxWidth, 0.0f, 8, null), shape2, richTooltipColors3.getContainerColor(), 0L, f4, m3426getContainerElevationD9Ej5fM, null, ComposableLambdaKt.composableLambda(startRestartGroup, 4342931, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TooltipKt$RichTooltip$1
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

                    public final void invoke(Composer composer3, int i15) {
                        float f7;
                        RichTooltipColors richTooltipColors5;
                        Modifier textVerticalPadding;
                        float f8;
                        float f9;
                        ComposerKt.sourceInformation(composer3, "C249@10055L10,251@10172L10,253@10284L10,255@10352L1442:Tooltip.kt#uh7d8r");
                        if ((i15 & 3) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(4342931, i15, -1, "androidx.compose.material3.RichTooltip.<anonymous> (Tooltip.kt:248)");
                            }
                            TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer3, 6), RichTooltipTokens.INSTANCE.getActionLabelTextFont());
                            TextStyle fromToken2 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer3, 6), RichTooltipTokens.INSTANCE.getSubheadFont());
                            TextStyle fromToken3 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer3, 6), RichTooltipTokens.INSTANCE.getSupportingTextFont());
                            Modifier m881paddingVpY3zN4$default = PaddingKt.m881paddingVpY3zN4$default(Modifier.INSTANCE, TooltipKt.getRichTooltipHorizontalPadding(), 0.0f, 2, null);
                            Function2<Composer, Integer, Unit> function29 = function24;
                            Function2<Composer, Integer, Unit> function210 = function26;
                            RichTooltipColors richTooltipColors6 = richTooltipColors3;
                            Function2<Composer, Integer, Unit> function211 = function23;
                            composer3.startReplaceableGroup(-483455358);
                            ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                            composer3.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m881paddingVpY3zN4$default);
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
                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer3, -1216116127, "C269@10905L349:Tooltip.kt#uh7d8r");
                            composer3.startReplaceableGroup(-1216116120);
                            ComposerKt.sourceInformation(composer3, "*259@10496L382");
                            if (function29 == null) {
                                richTooltipColors5 = richTooltipColors6;
                            } else {
                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                f7 = TooltipKt.HeightToSubheadFirstLine;
                                richTooltipColors5 = richTooltipColors6;
                                Modifier m763paddingFromBaselineVpY3zN4$default = AlignmentLineKt.m763paddingFromBaselineVpY3zN4$default(companion2, f7, 0.0f, 2, null);
                                composer3.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                composer3.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m763paddingFromBaselineVpY3zN4$default);
                                if (!(composer3.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor2);
                                } else {
                                    composer3.useNode();
                                }
                                Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                                Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                    m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                    m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                }
                                modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                composer3.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer3, -137016375, "C262@10633L227:Tooltip.kt#uh7d8r");
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(richTooltipColors5.getTitleContentColor())), TextKt.getLocalTextStyle().provides(fromToken2)}, function29, composer3, 0);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endReplaceableGroup();
                                composer3.endNode();
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                Unit unit = Unit.INSTANCE;
                                Unit unit2 = Unit.INSTANCE;
                            }
                            composer3.endReplaceableGroup();
                            textVerticalPadding = TooltipKt.textVerticalPadding(Modifier.INSTANCE, function29 != null, function210 != null);
                            composer3.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                            composer3.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(textVerticalPadding);
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
                            Updater.m3600setimpl(m3593constructorimpl3, rememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3600setimpl(m3593constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m3593constructorimpl3.getInserting() || !Intrinsics.areEqual(m3593constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                m3593constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                m3593constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                            }
                            modifierMaterializerOf3.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                            composer3.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer3, 1307460020, "C272@11029L211:Tooltip.kt#uh7d8r");
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(richTooltipColors5.getContentColor())), TextKt.getLocalTextStyle().provides(fromToken3)}, function211, composer3, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endReplaceableGroup();
                            composer3.endNode();
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                            composer3.startReplaceableGroup(-8196376);
                            ComposerKt.sourceInformation(composer3, "*279@11297L473");
                            if (function210 != null) {
                                Modifier.Companion companion3 = Modifier.INSTANCE;
                                f8 = TooltipKt.ActionLabelMinHeight;
                                Modifier m919requiredHeightInVpY3zN4$default = SizeKt.m919requiredHeightInVpY3zN4$default(companion3, f8, 0.0f, 2, null);
                                f9 = TooltipKt.ActionLabelBottomPadding;
                                Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(m919requiredHeightInVpY3zN4$default, 0.0f, 0.0f, 0.0f, f9, 7, null);
                                composer3.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                composer3.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap4 = composer3.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
                                if (!(composer3.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor4);
                                } else {
                                    composer3.useNode();
                                }
                                Composer m3593constructorimpl4 = Updater.m3593constructorimpl(composer3);
                                Updater.m3600setimpl(m3593constructorimpl4, rememberBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3600setimpl(m3593constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m3593constructorimpl4.getInserting() || !Intrinsics.areEqual(m3593constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                    m3593constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                    m3593constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                                }
                                modifierMaterializerOf4.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                composer3.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer3, -137015488, "C284@11520L232:Tooltip.kt#uh7d8r");
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(richTooltipColors5.getActionContentColor())), TextKt.getLocalTextStyle().provides(fromToken)}, function210, composer3, 0);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endReplaceableGroup();
                                composer3.endNode();
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                Unit unit3 = Unit.INSTANCE;
                                Unit unit4 = Unit.INSTANCE;
                            }
                            composer3.endReplaceableGroup();
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
                }), composer2, i1322 | (57344 & i1422) | (i1422 & 458752), 72);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = companion;
                richTooltipColors4 = richTooltipColors3;
                f5 = m3426getContainerElevationD9Ej5fM;
                function27 = function26;
                function28 = function24;
                f6 = f4;
                final Shape shape32 = shape2;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            function25 = function22;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            f3 = f;
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            if ((i2 & 128) == 0) {
            }
            if ((4793491 & i3) == 4793490) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i11 == 0) {
            }
            if (i12 != 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 8) != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            function26 = function25;
            richTooltipColors3 = richTooltipColors2;
            f4 = f3;
            i7 = 12582912;
            i8 = 1589779214;
            m3426getContainerElevationD9Ej5fM = f2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i13222 = ((i3 >> 6) & 112) | i7;
            int i14222 = i3 >> 3;
            composer2 = startRestartGroup;
            SurfaceKt.m2633SurfaceT9BRK9s(SizeKt.m932sizeInqDBjuR0$default(companion, TooltipMinWidth, TooltipMinHeight, RichTooltipMaxWidth, 0.0f, 8, null), shape2, richTooltipColors3.getContainerColor(), 0L, f4, m3426getContainerElevationD9Ej5fM, null, ComposableLambdaKt.composableLambda(startRestartGroup, 4342931, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TooltipKt$RichTooltip$1
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

                public final void invoke(Composer composer3, int i15) {
                    float f7;
                    RichTooltipColors richTooltipColors5;
                    Modifier textVerticalPadding;
                    float f8;
                    float f9;
                    ComposerKt.sourceInformation(composer3, "C249@10055L10,251@10172L10,253@10284L10,255@10352L1442:Tooltip.kt#uh7d8r");
                    if ((i15 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(4342931, i15, -1, "androidx.compose.material3.RichTooltip.<anonymous> (Tooltip.kt:248)");
                        }
                        TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer3, 6), RichTooltipTokens.INSTANCE.getActionLabelTextFont());
                        TextStyle fromToken2 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer3, 6), RichTooltipTokens.INSTANCE.getSubheadFont());
                        TextStyle fromToken3 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer3, 6), RichTooltipTokens.INSTANCE.getSupportingTextFont());
                        Modifier m881paddingVpY3zN4$default = PaddingKt.m881paddingVpY3zN4$default(Modifier.INSTANCE, TooltipKt.getRichTooltipHorizontalPadding(), 0.0f, 2, null);
                        Function2<Composer, Integer, Unit> function29 = function24;
                        Function2<Composer, Integer, Unit> function210 = function26;
                        RichTooltipColors richTooltipColors6 = richTooltipColors3;
                        Function2<Composer, Integer, Unit> function211 = function23;
                        composer3.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m881paddingVpY3zN4$default);
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
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, -1216116127, "C269@10905L349:Tooltip.kt#uh7d8r");
                        composer3.startReplaceableGroup(-1216116120);
                        ComposerKt.sourceInformation(composer3, "*259@10496L382");
                        if (function29 == null) {
                            richTooltipColors5 = richTooltipColors6;
                        } else {
                            Modifier.Companion companion2 = Modifier.INSTANCE;
                            f7 = TooltipKt.HeightToSubheadFirstLine;
                            richTooltipColors5 = richTooltipColors6;
                            Modifier m763paddingFromBaselineVpY3zN4$default = AlignmentLineKt.m763paddingFromBaselineVpY3zN4$default(companion2, f7, 0.0f, 2, null);
                            composer3.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                            composer3.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m763paddingFromBaselineVpY3zN4$default);
                            if (!(composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer3.startReusableNode();
                            if (composer3.getInserting()) {
                                composer3.createNode(constructor2);
                            } else {
                                composer3.useNode();
                            }
                            Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                            Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                            }
                            modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                            composer3.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer3, -137016375, "C262@10633L227:Tooltip.kt#uh7d8r");
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(richTooltipColors5.getTitleContentColor())), TextKt.getLocalTextStyle().provides(fromToken2)}, function29, composer3, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endReplaceableGroup();
                            composer3.endNode();
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                            Unit unit = Unit.INSTANCE;
                            Unit unit2 = Unit.INSTANCE;
                        }
                        composer3.endReplaceableGroup();
                        textVerticalPadding = TooltipKt.textVerticalPadding(Modifier.INSTANCE, function29 != null, function210 != null);
                        composer3.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(textVerticalPadding);
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
                        Updater.m3600setimpl(m3593constructorimpl3, rememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m3593constructorimpl3.getInserting() || !Intrinsics.areEqual(m3593constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                            m3593constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                            m3593constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                        }
                        modifierMaterializerOf3.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, 1307460020, "C272@11029L211:Tooltip.kt#uh7d8r");
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(richTooltipColors5.getContentColor())), TextKt.getLocalTextStyle().provides(fromToken3)}, function211, composer3, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        composer3.startReplaceableGroup(-8196376);
                        ComposerKt.sourceInformation(composer3, "*279@11297L473");
                        if (function210 != null) {
                            Modifier.Companion companion3 = Modifier.INSTANCE;
                            f8 = TooltipKt.ActionLabelMinHeight;
                            Modifier m919requiredHeightInVpY3zN4$default = SizeKt.m919requiredHeightInVpY3zN4$default(companion3, f8, 0.0f, 2, null);
                            f9 = TooltipKt.ActionLabelBottomPadding;
                            Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(m919requiredHeightInVpY3zN4$default, 0.0f, 0.0f, 0.0f, f9, 7, null);
                            composer3.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                            composer3.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap4 = composer3.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
                            if (!(composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer3.startReusableNode();
                            if (composer3.getInserting()) {
                                composer3.createNode(constructor4);
                            } else {
                                composer3.useNode();
                            }
                            Composer m3593constructorimpl4 = Updater.m3593constructorimpl(composer3);
                            Updater.m3600setimpl(m3593constructorimpl4, rememberBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3600setimpl(m3593constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m3593constructorimpl4.getInserting() || !Intrinsics.areEqual(m3593constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                m3593constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                m3593constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                            }
                            modifierMaterializerOf4.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                            composer3.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer3, -137015488, "C284@11520L232:Tooltip.kt#uh7d8r");
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(richTooltipColors5.getActionContentColor())), TextKt.getLocalTextStyle().provides(fromToken)}, function210, composer3, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endReplaceableGroup();
                            composer3.endNode();
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                            Unit unit3 = Unit.INSTANCE;
                            Unit unit4 = Unit.INSTANCE;
                        }
                        composer3.endReplaceableGroup();
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
            }), composer2, i13222 | (57344 & i14222) | (i14222 & 458752), 72);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = companion;
            richTooltipColors4 = richTooltipColors3;
            f5 = m3426getContainerElevationD9Ej5fM;
            function27 = function26;
            function28 = function24;
            f6 = f4;
            final Shape shape322 = shape2;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        function24 = function2;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        function25 = function22;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        f3 = f;
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        if ((i2 & 128) == 0) {
        }
        if ((4793491 & i3) == 4793490) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i11 == 0) {
        }
        if (i12 != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        function26 = function25;
        richTooltipColors3 = richTooltipColors2;
        f4 = f3;
        i7 = 12582912;
        i8 = 1589779214;
        m3426getContainerElevationD9Ej5fM = f2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i132222 = ((i3 >> 6) & 112) | i7;
        int i142222 = i3 >> 3;
        composer2 = startRestartGroup;
        SurfaceKt.m2633SurfaceT9BRK9s(SizeKt.m932sizeInqDBjuR0$default(companion, TooltipMinWidth, TooltipMinHeight, RichTooltipMaxWidth, 0.0f, 8, null), shape2, richTooltipColors3.getContainerColor(), 0L, f4, m3426getContainerElevationD9Ej5fM, null, ComposableLambdaKt.composableLambda(startRestartGroup, 4342931, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TooltipKt$RichTooltip$1
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

            public final void invoke(Composer composer3, int i15) {
                float f7;
                RichTooltipColors richTooltipColors5;
                Modifier textVerticalPadding;
                float f8;
                float f9;
                ComposerKt.sourceInformation(composer3, "C249@10055L10,251@10172L10,253@10284L10,255@10352L1442:Tooltip.kt#uh7d8r");
                if ((i15 & 3) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(4342931, i15, -1, "androidx.compose.material3.RichTooltip.<anonymous> (Tooltip.kt:248)");
                    }
                    TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer3, 6), RichTooltipTokens.INSTANCE.getActionLabelTextFont());
                    TextStyle fromToken2 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer3, 6), RichTooltipTokens.INSTANCE.getSubheadFont());
                    TextStyle fromToken3 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer3, 6), RichTooltipTokens.INSTANCE.getSupportingTextFont());
                    Modifier m881paddingVpY3zN4$default = PaddingKt.m881paddingVpY3zN4$default(Modifier.INSTANCE, TooltipKt.getRichTooltipHorizontalPadding(), 0.0f, 2, null);
                    Function2<Composer, Integer, Unit> function29 = function24;
                    Function2<Composer, Integer, Unit> function210 = function26;
                    RichTooltipColors richTooltipColors6 = richTooltipColors3;
                    Function2<Composer, Integer, Unit> function211 = function23;
                    composer3.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m881paddingVpY3zN4$default);
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
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer3, -1216116127, "C269@10905L349:Tooltip.kt#uh7d8r");
                    composer3.startReplaceableGroup(-1216116120);
                    ComposerKt.sourceInformation(composer3, "*259@10496L382");
                    if (function29 == null) {
                        richTooltipColors5 = richTooltipColors6;
                    } else {
                        Modifier.Companion companion2 = Modifier.INSTANCE;
                        f7 = TooltipKt.HeightToSubheadFirstLine;
                        richTooltipColors5 = richTooltipColors6;
                        Modifier m763paddingFromBaselineVpY3zN4$default = AlignmentLineKt.m763paddingFromBaselineVpY3zN4$default(companion2, f7, 0.0f, 2, null);
                        composer3.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m763paddingFromBaselineVpY3zN4$default);
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor2);
                        } else {
                            composer3.useNode();
                        }
                        Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                        Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, -137016375, "C262@10633L227:Tooltip.kt#uh7d8r");
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(richTooltipColors5.getTitleContentColor())), TextKt.getLocalTextStyle().provides(fromToken2)}, function29, composer3, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        Unit unit = Unit.INSTANCE;
                        Unit unit2 = Unit.INSTANCE;
                    }
                    composer3.endReplaceableGroup();
                    textVerticalPadding = TooltipKt.textVerticalPadding(Modifier.INSTANCE, function29 != null, function210 != null);
                    composer3.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(textVerticalPadding);
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
                    Updater.m3600setimpl(m3593constructorimpl3, rememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3600setimpl(m3593constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m3593constructorimpl3.getInserting() || !Intrinsics.areEqual(m3593constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        m3593constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        m3593constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    modifierMaterializerOf3.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer3, 1307460020, "C272@11029L211:Tooltip.kt#uh7d8r");
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(richTooltipColors5.getContentColor())), TextKt.getLocalTextStyle().provides(fromToken3)}, function211, composer3, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    composer3.startReplaceableGroup(-8196376);
                    ComposerKt.sourceInformation(composer3, "*279@11297L473");
                    if (function210 != null) {
                        Modifier.Companion companion3 = Modifier.INSTANCE;
                        f8 = TooltipKt.ActionLabelMinHeight;
                        Modifier m919requiredHeightInVpY3zN4$default = SizeKt.m919requiredHeightInVpY3zN4$default(companion3, f8, 0.0f, 2, null);
                        f9 = TooltipKt.ActionLabelBottomPadding;
                        Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(m919requiredHeightInVpY3zN4$default, 0.0f, 0.0f, 0.0f, f9, 7, null);
                        composer3.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap4 = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor4);
                        } else {
                            composer3.useNode();
                        }
                        Composer m3593constructorimpl4 = Updater.m3593constructorimpl(composer3);
                        Updater.m3600setimpl(m3593constructorimpl4, rememberBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m3593constructorimpl4.getInserting() || !Intrinsics.areEqual(m3593constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                            m3593constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                            m3593constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                        }
                        modifierMaterializerOf4.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, -137015488, "C284@11520L232:Tooltip.kt#uh7d8r");
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(richTooltipColors5.getActionContentColor())), TextKt.getLocalTextStyle().provides(fromToken)}, function210, composer3, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        Unit unit3 = Unit.INSTANCE;
                        Unit unit4 = Unit.INSTANCE;
                    }
                    composer3.endReplaceableGroup();
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
        }), composer2, i132222 | (57344 & i142222) | (i142222 & 458752), 72);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = companion;
        richTooltipColors4 = richTooltipColors3;
        f5 = m3426getContainerElevationD9Ej5fM;
        function27 = function26;
        function28 = function24;
        f6 = f4;
        final Shape shape3222 = shape2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    public static final TooltipState rememberTooltipState(boolean z, boolean z2, MutatorMutex mutatorMutex, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1413230530);
        ComposerKt.sourceInformation(composer, "C(rememberTooltipState)513@20571L232:Tooltip.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            z = false;
        }
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        if ((i2 & 4) != 0) {
            mutatorMutex = BasicTooltipDefaults.INSTANCE.getGlobalMutatorMutex();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1413230530, i, -1, "androidx.compose.material3.rememberTooltipState (Tooltip.kt:513)");
        }
        composer.startReplaceableGroup(512858205);
        ComposerKt.sourceInformation(composer, "CC(remember):Tooltip.kt#9igjgp");
        boolean z3 = ((((i & 112) ^ 48) > 32 && composer.changed(z2)) || (i & 48) == 32) | ((((i & 896) ^ 384) > 256 && composer.changed(mutatorMutex)) || (i & 384) == 256);
        Object rememberedValue = composer.rememberedValue();
        if (z3 || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new TooltipStateImpl(z, z2, mutatorMutex);
            composer.updateRememberedValue(rememberedValue);
        }
        TooltipStateImpl tooltipStateImpl = (TooltipStateImpl) rememberedValue;
        composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return tooltipStateImpl;
    }

    public static /* synthetic */ TooltipState TooltipState$default(boolean z, boolean z2, MutatorMutex mutatorMutex, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            mutatorMutex = BasicTooltipDefaults.INSTANCE.getGlobalMutatorMutex();
        }
        return TooltipState(z, z2, mutatorMutex);
    }

    public static final TooltipState TooltipState(boolean z, boolean z2, MutatorMutex mutatorMutex) {
        return new TooltipStateImpl(z, z2, mutatorMutex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier textVerticalPadding(Modifier modifier, boolean z, boolean z2) {
        if (!z && !z2) {
            return PaddingKt.m881paddingVpY3zN4$default(modifier, 0.0f, PlainTooltipVerticalPadding, 1, null);
        }
        return PaddingKt.m883paddingqDBjuR0$default(AlignmentLineKt.m763paddingFromBaselineVpY3zN4$default(modifier, HeightFromSubheadToTextFirstLine, 0.0f, 2, null), 0.0f, 0.0f, 0.0f, TextBottomPadding, 7, null);
    }

    public static final float getSpacingBetweenTooltipAndAnchor() {
        return SpacingBetweenTooltipAndAnchor;
    }

    public static final float getTooltipMinHeight() {
        return TooltipMinHeight;
    }

    public static final float getTooltipMinWidth() {
        return TooltipMinWidth;
    }

    public static final float getPlainTooltipMaxWidth() {
        return PlainTooltipMaxWidth;
    }

    public static final PaddingValues getPlainTooltipContentPadding() {
        return PlainTooltipContentPadding;
    }

    public static final float getRichTooltipHorizontalPadding() {
        return RichTooltipHorizontalPadding;
    }

    public static final Modifier animateTooltip(Modifier modifier, final Transition<Boolean> transition) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material3.TooltipKt$animateTooltip$$inlined$debugInspectorInfo$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("animateTooltip");
                inspectorInfo.getProperties().set("transition", Transition.this);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.material3.TooltipKt$animateTooltip$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                composer.startReplaceableGroup(-1498516085);
                ComposerKt.sourceInformation(composer, "C655@25162L583,674@25775L561:Tooltip.kt#uh7d8r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1498516085, i, -1, "androidx.compose.material3.animateTooltip.<anonymous> (Tooltip.kt:655)");
                }
                Transition<Boolean> transition2 = transition;
                TooltipKt$animateTooltip$2$scale$2 tooltipKt$animateTooltip$2$scale$2 = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.TooltipKt$animateTooltip$2$scale$2
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer2, Integer num) {
                        return invoke(segment, composer2, num.intValue());
                    }

                    public final FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer2, int i2) {
                        TweenSpec tween$default;
                        composer2.startReplaceableGroup(386845748);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(386845748, i2, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:657)");
                        }
                        if (segment.isTransitioningTo(false, true)) {
                            tween$default = AnimationSpecKt.tween$default(150, 0, EasingKt.getLinearOutSlowInEasing(), 2, null);
                        } else {
                            tween$default = AnimationSpecKt.tween$default(75, 0, EasingKt.getLinearOutSlowInEasing(), 2, null);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer2.endReplaceableGroup();
                        return tween$default;
                    }
                };
                composer.startReplaceableGroup(-1338768149);
                ComposerKt.sourceInformation(composer, "CC(animateFloat)P(2)1165@46369L78:Transition.kt#pdpnli");
                TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
                composer.startReplaceableGroup(-142660079);
                ComposerKt.sourceInformation(composer, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
                boolean booleanValue = transition2.getCurrentState().booleanValue();
                composer.startReplaceableGroup(-1553362193);
                ComposerKt.sourceInformation(composer, "C:Tooltip.kt#uh7d8r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1553362193, 0, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:672)");
                }
                float f = booleanValue ? 1.0f : 0.8f;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                Float valueOf = Float.valueOf(f);
                boolean booleanValue2 = transition2.getTargetState().booleanValue();
                composer.startReplaceableGroup(-1553362193);
                ComposerKt.sourceInformation(composer, "C:Tooltip.kt#uh7d8r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1553362193, 0, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:672)");
                }
                float f2 = booleanValue2 ? 1.0f : 0.8f;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                State createTransitionAnimation = TransitionKt.createTransitionAnimation(transition2, valueOf, Float.valueOf(f2), tooltipKt$animateTooltip$2$scale$2.invoke((TooltipKt$animateTooltip$2$scale$2) transition2.getSegment(), (Transition.Segment<Boolean>) composer, (Composer) 0), vectorConverter, "tooltip transition: scaling", composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                Transition<Boolean> transition3 = transition;
                TooltipKt$animateTooltip$2$alpha$2 tooltipKt$animateTooltip$2$alpha$2 = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.TooltipKt$animateTooltip$2$alpha$2
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer2, Integer num) {
                        return invoke(segment, composer2, num.intValue());
                    }

                    public final FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer2, int i2) {
                        TweenSpec tween$default;
                        composer2.startReplaceableGroup(-281714272);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-281714272, i2, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:676)");
                        }
                        if (segment.isTransitioningTo(false, true)) {
                            tween$default = AnimationSpecKt.tween$default(150, 0, EasingKt.getLinearEasing(), 2, null);
                        } else {
                            tween$default = AnimationSpecKt.tween$default(75, 0, EasingKt.getLinearEasing(), 2, null);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer2.endReplaceableGroup();
                        return tween$default;
                    }
                };
                composer.startReplaceableGroup(-1338768149);
                ComposerKt.sourceInformation(composer, "CC(animateFloat)P(2)1165@46369L78:Transition.kt#pdpnli");
                TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
                composer.startReplaceableGroup(-142660079);
                ComposerKt.sourceInformation(composer, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
                boolean booleanValue3 = transition3.getCurrentState().booleanValue();
                composer.startReplaceableGroup(2073045083);
                ComposerKt.sourceInformation(composer, "C:Tooltip.kt#uh7d8r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2073045083, 0, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:691)");
                }
                float f3 = booleanValue3 ? 1.0f : 0.0f;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                Float valueOf2 = Float.valueOf(f3);
                boolean booleanValue4 = transition3.getTargetState().booleanValue();
                composer.startReplaceableGroup(2073045083);
                ComposerKt.sourceInformation(composer, "C:Tooltip.kt#uh7d8r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2073045083, 0, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:691)");
                }
                float f4 = booleanValue4 ? 1.0f : 0.0f;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                State createTransitionAnimation2 = TransitionKt.createTransitionAnimation(transition3, valueOf2, Float.valueOf(f4), tooltipKt$animateTooltip$2$alpha$2.invoke((TooltipKt$animateTooltip$2$alpha$2) transition3.getSegment(), (Transition.Segment<Boolean>) composer, (Composer) 0), vectorConverter2, "tooltip transition: alpha", composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                Modifier m4224graphicsLayerAp8cVGQ$default = GraphicsLayerModifierKt.m4224graphicsLayerAp8cVGQ$default(modifier2, invoke$lambda$1(createTransitionAnimation), invoke$lambda$1(createTransitionAnimation), invoke$lambda$3(createTransitionAnimation2), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131064, null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return m4224graphicsLayerAp8cVGQ$default;
            }

            private static final float invoke$lambda$1(State<Float> state) {
                return state.getValue().floatValue();
            }

            private static final float invoke$lambda$3(State<Float> state) {
                return state.getValue().floatValue();
            }
        });
    }

    static {
        float f = 4;
        SpacingBetweenTooltipAndAnchor = Dp.m6389constructorimpl(f);
        float f2 = 24;
        TooltipMinHeight = Dp.m6389constructorimpl(f2);
        float m6389constructorimpl = Dp.m6389constructorimpl(f);
        PlainTooltipVerticalPadding = m6389constructorimpl;
        float f3 = 8;
        float m6389constructorimpl2 = Dp.m6389constructorimpl(f3);
        PlainTooltipHorizontalPadding = m6389constructorimpl2;
        PlainTooltipContentPadding = PaddingKt.m873PaddingValuesYgX7TsA(m6389constructorimpl2, m6389constructorimpl);
        RichTooltipMaxWidth = Dp.m6389constructorimpl(Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE);
        float f4 = 16;
        RichTooltipHorizontalPadding = Dp.m6389constructorimpl(f4);
        HeightToSubheadFirstLine = Dp.m6389constructorimpl(28);
        HeightFromSubheadToTextFirstLine = Dp.m6389constructorimpl(f2);
        TextBottomPadding = Dp.m6389constructorimpl(f4);
        ActionLabelMinHeight = Dp.m6389constructorimpl(36);
        ActionLabelBottomPadding = Dp.m6389constructorimpl(f3);
    }
}
