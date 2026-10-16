package androidx.compose.material3;

import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Label.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010\b\u001a\\\u0010\t\u001a\u00020\u00012\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\r¢\u0006\u0002\b\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00032\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0015²\u0006\f\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u008a\u008e\u0002"}, d2 = {"HandleInteractions", "", "enabled", "", "state", "Landroidx/compose/material3/BasicTooltipState;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLandroidx/compose/material3/BasicTooltipState;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;I)V", "Label", "label", "Lkotlin/Function1;", "Landroidx/compose/material3/CaretScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "isPersistent", "content", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material3_release", "anchorBounds", "Landroidx/compose/ui/layout/LayoutCoordinates;"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LabelKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Label(final Function3<? super CaretScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, MutableInteractionSource mutableInteractionSource, boolean z, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        MutableInteractionSource mutableInteractionSource2;
        int i5;
        boolean z2;
        MutableInteractionSource mutableInteractionSource3;
        boolean z3;
        SnapshotMutationPolicy snapshotMutationPolicy;
        LabelStateImpl rememberBasicTooltipState;
        Object rememberedValue;
        Object rememberedValue2;
        final MutableInteractionSource mutableInteractionSource4;
        final Modifier modifier3;
        final boolean z4;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-544399326);
        ComposerKt.sourceInformation(startRestartGroup, "C(Label)P(3,4,1,2)66@2846L39,71@3060L38,77@3290L33,78@3340L257,95@3793L249,104@4047L127:Label.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function3) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                i3 |= startRestartGroup.changed(mutableInteractionSource2) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    z2 = z;
                    i3 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                    if ((i2 & 16) == 0) {
                        i3 |= 24576;
                    } else if ((i & 24576) == 0) {
                        i3 |= startRestartGroup.changedInstance(function2) ? 16384 : 8192;
                    }
                    if ((i3 & 9363) == 9362 || !startRestartGroup.getSkipping()) {
                        Modifier.Companion companion = i6 == 0 ? Modifier.INSTANCE : modifier2;
                        if (i4 == 0) {
                            startRestartGroup.startReplaceableGroup(-2061465011);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Label.kt#9igjgp");
                            Object rememberedValue3 = startRestartGroup.rememberedValue();
                            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue3 = InteractionSourceKt.MutableInteractionSource();
                                startRestartGroup.updateRememberedValue(rememberedValue3);
                            }
                            startRestartGroup.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) rememberedValue3;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        z3 = i5 == 0 ? false : z2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-544399326, i3, -1, "androidx.compose.material3.Label (Label.kt:69)");
                        }
                        PopupPositionProvider m2921rememberPlainTooltipPositionProviderkHDZbjc = TooltipDefaults.INSTANCE.m2921rememberPlainTooltipPositionProviderkHDZbjc(0.0f, startRestartGroup, 48, 1);
                        if (!z3) {
                            startRestartGroup.startReplaceableGroup(-2061464716);
                            ComposerKt.sourceInformation(startRestartGroup, "73@3141L29");
                            startRestartGroup.startReplaceableGroup(-2061464716);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Label.kt#9igjgp");
                            Object rememberedValue4 = startRestartGroup.rememberedValue();
                            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue4 = new LabelStateImpl(false, false, 3, null);
                                startRestartGroup.updateRememberedValue(rememberedValue4);
                            }
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.endReplaceableGroup();
                            rememberBasicTooltipState = (LabelStateImpl) rememberedValue4;
                            snapshotMutationPolicy = null;
                        } else {
                            startRestartGroup.startReplaceableGroup(-2061464669);
                            ComposerKt.sourceInformation(startRestartGroup, "75@3188L56");
                            snapshotMutationPolicy = null;
                            rememberBasicTooltipState = BasicTooltipKt.rememberBasicTooltipState(false, false, new MutatorMutex(), startRestartGroup, 0, 3);
                            startRestartGroup.endReplaceableGroup();
                        }
                        startRestartGroup.startReplaceableGroup(-2061464567);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Label.kt#9igjgp");
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(snapshotMutationPolicy, snapshotMutationPolicy, 2, snapshotMutationPolicy);
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        final MutableState mutableState = (MutableState) rememberedValue;
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.startReplaceableGroup(-2061464517);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Label.kt#9igjgp");
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = new CaretScope() { // from class: androidx.compose.material3.LabelKt$Label$scope$1$1
                                @Override // androidx.compose.material3.CaretScope
                                public Modifier drawCaret(Modifier modifier4, final Function2<? super CacheDrawScope, ? super LayoutCoordinates, DrawResult> function22) {
                                    final MutableState<LayoutCoordinates> mutableState2 = mutableState;
                                    return DrawModifierKt.drawWithCache(modifier4, new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.compose.material3.LabelKt$Label$scope$1$1$drawCaret$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                                            LayoutCoordinates Label$lambda$3;
                                            Function2<CacheDrawScope, LayoutCoordinates, DrawResult> function23 = function22;
                                            Label$lambda$3 = LabelKt.Label$lambda$3(mutableState2);
                                            return function23.invoke(cacheDrawScope, Label$lambda$3);
                                        }
                                    });
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                        }
                        final LabelKt$Label$scope$1$1 labelKt$Label$scope$1$1 = (LabelKt$Label$scope$1$1) rememberedValue2;
                        startRestartGroup.endReplaceableGroup();
                        MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource3;
                        BasicTooltip_androidKt.BasicTooltipBox(m2921rememberPlainTooltipPositionProviderkHDZbjc, ComposableLambdaKt.composableLambda(startRestartGroup, 784196780, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.LabelKt$Label$2
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
                                ComposerKt.sourceInformation(composer2, "C97@3881L7:Label.kt#uh7d8r");
                                if ((i7 & 3) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(784196780, i7, -1, "androidx.compose.material3.Label.<anonymous> (Label.kt:97)");
                                }
                                function3.invoke(labelKt$Label$scope$1$1, composer2, 6);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), rememberBasicTooltipState, companion, false, false, ComposableLambdaKt.composableLambda(startRestartGroup, 1950723216, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.LabelKt$Label$wrappedContent$1
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
                                ComposerKt.sourceInformation(composer2, "C89@3716L21,88@3658L123:Label.kt#uh7d8r");
                                if ((i7 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1950723216, i7, -1, "androidx.compose.material3.Label.<anonymous> (Label.kt:88)");
                                    }
                                    Modifier.Companion companion2 = Modifier.INSTANCE;
                                    composer2.startReplaceableGroup(1482637652);
                                    ComposerKt.sourceInformation(composer2, "CC(remember):Label.kt#9igjgp");
                                    final MutableState<LayoutCoordinates> mutableState2 = mutableState;
                                    Object rememberedValue5 = composer2.rememberedValue();
                                    if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue5 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material3.LabelKt$Label$wrappedContent$1$1$1
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
                                        composer2.updateRememberedValue(rememberedValue5);
                                    }
                                    composer2.endReplaceableGroup();
                                    Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(companion2, (Function1) rememberedValue5);
                                    Function2<Composer, Integer, Unit> function22 = function2;
                                    composer2.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                                    composer2.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(onGloballyPositioned);
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
                                    ComposerKt.sourceInformationMarkerStart(composer2, -594506845, "C91@3762L9:Label.kt#uh7d8r");
                                    function22.invoke(composer2, 0);
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
                        }), startRestartGroup, ((i3 << 6) & 7168) | 1794096, 0);
                        startRestartGroup = startRestartGroup;
                        HandleInteractions(!z3, rememberBasicTooltipState, mutableInteractionSource5, startRestartGroup, i3 & 896);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource4 = mutableInteractionSource5;
                        modifier3 = companion;
                        z4 = z3;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        mutableInteractionSource4 = mutableInteractionSource2;
                        z4 = z2;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.LabelKt$Label$3
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
                                LabelKt.Label(function3, modifier3, mutableInteractionSource4, z4, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                z2 = z;
                if ((i2 & 16) == 0) {
                }
                if ((i3 & 9363) == 9362) {
                }
                if (i6 == 0) {
                }
                if (i4 == 0) {
                }
                if (i5 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                PopupPositionProvider m2921rememberPlainTooltipPositionProviderkHDZbjc2 = TooltipDefaults.INSTANCE.m2921rememberPlainTooltipPositionProviderkHDZbjc(0.0f, startRestartGroup, 48, 1);
                if (!z3) {
                }
                startRestartGroup.startReplaceableGroup(-2061464567);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Label.kt#9igjgp");
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                }
                final MutableState<LayoutCoordinates> mutableState2 = (MutableState) rememberedValue;
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(-2061464517);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Label.kt#9igjgp");
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                }
                final LabelKt$Label$scope$1$1 labelKt$Label$scope$1$12 = (LabelKt$Label$scope$1$1) rememberedValue2;
                startRestartGroup.endReplaceableGroup();
                MutableInteractionSource mutableInteractionSource52 = mutableInteractionSource3;
                BasicTooltip_androidKt.BasicTooltipBox(m2921rememberPlainTooltipPositionProviderkHDZbjc2, ComposableLambdaKt.composableLambda(startRestartGroup, 784196780, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.LabelKt$Label$2
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
                        ComposerKt.sourceInformation(composer2, "C97@3881L7:Label.kt#uh7d8r");
                        if ((i7 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(784196780, i7, -1, "androidx.compose.material3.Label.<anonymous> (Label.kt:97)");
                        }
                        function3.invoke(labelKt$Label$scope$1$12, composer2, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), rememberBasicTooltipState, companion, false, false, ComposableLambdaKt.composableLambda(startRestartGroup, 1950723216, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.LabelKt$Label$wrappedContent$1
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
                        ComposerKt.sourceInformation(composer2, "C89@3716L21,88@3658L123:Label.kt#uh7d8r");
                        if ((i7 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1950723216, i7, -1, "androidx.compose.material3.Label.<anonymous> (Label.kt:88)");
                            }
                            Modifier.Companion companion2 = Modifier.INSTANCE;
                            composer2.startReplaceableGroup(1482637652);
                            ComposerKt.sourceInformation(composer2, "CC(remember):Label.kt#9igjgp");
                            final MutableState<LayoutCoordinates> mutableState22 = mutableState2;
                            Object rememberedValue5 = composer2.rememberedValue();
                            if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue5 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material3.LabelKt$Label$wrappedContent$1$1$1
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
                                composer2.updateRememberedValue(rememberedValue5);
                            }
                            composer2.endReplaceableGroup();
                            Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(companion2, (Function1) rememberedValue5);
                            Function2<Composer, Integer, Unit> function22 = function2;
                            composer2.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(onGloballyPositioned);
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
                            ComposerKt.sourceInformationMarkerStart(composer2, -594506845, "C91@3762L9:Label.kt#uh7d8r");
                            function22.invoke(composer2, 0);
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
                }), startRestartGroup, ((i3 << 6) & 7168) | 1794096, 0);
                startRestartGroup = startRestartGroup;
                HandleInteractions(!z3, rememberBasicTooltipState, mutableInteractionSource52, startRestartGroup, i3 & 896);
                if (ComposerKt.isTraceInProgress()) {
                }
                mutableInteractionSource4 = mutableInteractionSource52;
                modifier3 = companion;
                z4 = z3;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            mutableInteractionSource2 = mutableInteractionSource;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            z2 = z;
            if ((i2 & 16) == 0) {
            }
            if ((i3 & 9363) == 9362) {
            }
            if (i6 == 0) {
            }
            if (i4 == 0) {
            }
            if (i5 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            PopupPositionProvider m2921rememberPlainTooltipPositionProviderkHDZbjc22 = TooltipDefaults.INSTANCE.m2921rememberPlainTooltipPositionProviderkHDZbjc(0.0f, startRestartGroup, 48, 1);
            if (!z3) {
            }
            startRestartGroup.startReplaceableGroup(-2061464567);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Label.kt#9igjgp");
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            final MutableState<LayoutCoordinates> mutableState22 = (MutableState) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-2061464517);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Label.kt#9igjgp");
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            }
            final LabelKt$Label$scope$1$1 labelKt$Label$scope$1$122 = (LabelKt$Label$scope$1$1) rememberedValue2;
            startRestartGroup.endReplaceableGroup();
            MutableInteractionSource mutableInteractionSource522 = mutableInteractionSource3;
            BasicTooltip_androidKt.BasicTooltipBox(m2921rememberPlainTooltipPositionProviderkHDZbjc22, ComposableLambdaKt.composableLambda(startRestartGroup, 784196780, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.LabelKt$Label$2
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
                    ComposerKt.sourceInformation(composer2, "C97@3881L7:Label.kt#uh7d8r");
                    if ((i7 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(784196780, i7, -1, "androidx.compose.material3.Label.<anonymous> (Label.kt:97)");
                    }
                    function3.invoke(labelKt$Label$scope$1$122, composer2, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), rememberBasicTooltipState, companion, false, false, ComposableLambdaKt.composableLambda(startRestartGroup, 1950723216, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.LabelKt$Label$wrappedContent$1
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
                    ComposerKt.sourceInformation(composer2, "C89@3716L21,88@3658L123:Label.kt#uh7d8r");
                    if ((i7 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1950723216, i7, -1, "androidx.compose.material3.Label.<anonymous> (Label.kt:88)");
                        }
                        Modifier.Companion companion2 = Modifier.INSTANCE;
                        composer2.startReplaceableGroup(1482637652);
                        ComposerKt.sourceInformation(composer2, "CC(remember):Label.kt#9igjgp");
                        final MutableState<LayoutCoordinates> mutableState222 = mutableState22;
                        Object rememberedValue5 = composer2.rememberedValue();
                        if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue5 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material3.LabelKt$Label$wrappedContent$1$1$1
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
                            composer2.updateRememberedValue(rememberedValue5);
                        }
                        composer2.endReplaceableGroup();
                        Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(companion2, (Function1) rememberedValue5);
                        Function2<Composer, Integer, Unit> function22 = function2;
                        composer2.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(onGloballyPositioned);
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
                        ComposerKt.sourceInformationMarkerStart(composer2, -594506845, "C91@3762L9:Label.kt#uh7d8r");
                        function22.invoke(composer2, 0);
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
            }), startRestartGroup, ((i3 << 6) & 7168) | 1794096, 0);
            startRestartGroup = startRestartGroup;
            HandleInteractions(!z3, rememberBasicTooltipState, mutableInteractionSource522, startRestartGroup, i3 & 896);
            if (ComposerKt.isTraceInProgress()) {
            }
            mutableInteractionSource4 = mutableInteractionSource522;
            modifier3 = companion;
            z4 = z3;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        z2 = z;
        if ((i2 & 16) == 0) {
        }
        if ((i3 & 9363) == 9362) {
        }
        if (i6 == 0) {
        }
        if (i4 == 0) {
        }
        if (i5 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        PopupPositionProvider m2921rememberPlainTooltipPositionProviderkHDZbjc222 = TooltipDefaults.INSTANCE.m2921rememberPlainTooltipPositionProviderkHDZbjc(0.0f, startRestartGroup, 48, 1);
        if (!z3) {
        }
        startRestartGroup.startReplaceableGroup(-2061464567);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Label.kt#9igjgp");
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        final MutableState<LayoutCoordinates> mutableState222 = (MutableState) rememberedValue;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-2061464517);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Label.kt#9igjgp");
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
        }
        final LabelKt$Label$scope$1$1 labelKt$Label$scope$1$1222 = (LabelKt$Label$scope$1$1) rememberedValue2;
        startRestartGroup.endReplaceableGroup();
        MutableInteractionSource mutableInteractionSource5222 = mutableInteractionSource3;
        BasicTooltip_androidKt.BasicTooltipBox(m2921rememberPlainTooltipPositionProviderkHDZbjc222, ComposableLambdaKt.composableLambda(startRestartGroup, 784196780, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.LabelKt$Label$2
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
                ComposerKt.sourceInformation(composer2, "C97@3881L7:Label.kt#uh7d8r");
                if ((i7 & 3) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(784196780, i7, -1, "androidx.compose.material3.Label.<anonymous> (Label.kt:97)");
                }
                function3.invoke(labelKt$Label$scope$1$1222, composer2, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), rememberBasicTooltipState, companion, false, false, ComposableLambdaKt.composableLambda(startRestartGroup, 1950723216, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.LabelKt$Label$wrappedContent$1
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
                ComposerKt.sourceInformation(composer2, "C89@3716L21,88@3658L123:Label.kt#uh7d8r");
                if ((i7 & 3) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1950723216, i7, -1, "androidx.compose.material3.Label.<anonymous> (Label.kt:88)");
                    }
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    composer2.startReplaceableGroup(1482637652);
                    ComposerKt.sourceInformation(composer2, "CC(remember):Label.kt#9igjgp");
                    final MutableState<LayoutCoordinates> mutableState2222 = mutableState222;
                    Object rememberedValue5 = composer2.rememberedValue();
                    if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue5 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material3.LabelKt$Label$wrappedContent$1$1$1
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
                        composer2.updateRememberedValue(rememberedValue5);
                    }
                    composer2.endReplaceableGroup();
                    Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(companion2, (Function1) rememberedValue5);
                    Function2<Composer, Integer, Unit> function22 = function2;
                    composer2.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(onGloballyPositioned);
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
                    ComposerKt.sourceInformationMarkerStart(composer2, -594506845, "C91@3762L9:Label.kt#uh7d8r");
                    function22.invoke(composer2, 0);
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
        }), startRestartGroup, ((i3 << 6) & 7168) | 1794096, 0);
        startRestartGroup = startRestartGroup;
        HandleInteractions(!z3, rememberBasicTooltipState, mutableInteractionSource5222, startRestartGroup, i3 & 896);
        if (ComposerKt.isTraceInProgress()) {
        }
        mutableInteractionSource4 = mutableInteractionSource5222;
        modifier3 = companion;
        z4 = z3;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LayoutCoordinates Label$lambda$3(MutableState<LayoutCoordinates> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void HandleInteractions(final boolean z, final BasicTooltipState basicTooltipState, final MutableInteractionSource mutableInteractionSource, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1479255681);
        ComposerKt.sourceInformation(startRestartGroup, "C(HandleInteractions)P(!1,2)119@4427L499,119@4393L533:Label.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(basicTooltipState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(mutableInteractionSource) ? 256 : 128;
        }
        if ((i2 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1479255681, i2, -1, "androidx.compose.material3.HandleInteractions (Label.kt:117)");
            }
            if (z) {
                startRestartGroup.startReplaceableGroup(-404204353);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Label.kt#9igjgp");
                boolean z2 = ((i2 & 896) == 256) | ((i2 & 112) == 32);
                LabelKt$HandleInteractions$1$1 rememberedValue = startRestartGroup.rememberedValue();
                if (z2 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new LabelKt$HandleInteractions$1$1(mutableInteractionSource, basicTooltipState, null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceableGroup();
                EffectsKt.LaunchedEffect(mutableInteractionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue, startRestartGroup, (i2 >> 6) & 14);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.LabelKt$HandleInteractions$2
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
                    LabelKt.HandleInteractions(z, basicTooltipState, mutableInteractionSource, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
