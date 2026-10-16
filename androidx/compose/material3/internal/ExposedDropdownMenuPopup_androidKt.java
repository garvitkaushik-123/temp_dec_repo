package androidx.compose.material3.internal;

import android.view.View;
import androidx.compose.material3.TouchExplorationStateProvider_androidKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: ExposedDropdownMenuPopup.android.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a:\u0010\u0000\u001a\u00020\u00012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0007H\u0001¢\u0006\u0002\u0010\b\u001a+\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0013\b\b\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0007H\u0083\b¢\u0006\u0002\u0010\f¨\u0006\r²\u0006\n\u0010\u000e\u001a\u00020\u000fX\u008a\u0084\u0002²\u0006\u0015\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0007X\u008a\u0084\u0002"}, d2 = {"ExposedDropdownMenuPopup", "", "onDismissRequest", "Lkotlin/Function0;", "popupPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SimpleStack", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material3_release", "isTouchExplorationEnabled", "", "currentContent"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ExposedDropdownMenuPopup_androidKt {
    public static final void ExposedDropdownMenuPopup(Function0<Unit> function0, final PopupPositionProvider popupPositionProvider, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        PopupPositionProvider popupPositionProvider2;
        final Function0<Unit> function03;
        boolean z;
        int i4;
        final LayoutDirection layoutDirection;
        final Function0<Unit> function04;
        Composer startRestartGroup = composer.startRestartGroup(-727958629);
        ComposerKt.sourceInformation(startRestartGroup, "C(ExposedDropdownMenuPopup)P(1,2)85@3452L7,86@3491L7,87@3546L7,88@3591L23,90@3644L28,91@3699L29,92@3747L38,93@3808L964,120@4808L319,120@4778L349,133@5144L150,133@5133L161,145@5551L462,156@6020L99,143@5472L647:ExposedDropdownMenuPopup.android.kt#mqatfk");
        int i5 = i2 & 1;
        if (i5 != 0) {
            i3 = i | 6;
            function02 = function0;
        } else if ((i & 6) == 0) {
            function02 = function0;
            i3 = (startRestartGroup.changedInstance(function02) ? 4 : 2) | i;
        } else {
            function02 = function0;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            popupPositionProvider2 = popupPositionProvider;
        } else {
            popupPositionProvider2 = popupPositionProvider;
            if ((i & 48) == 0) {
                i3 |= startRestartGroup.changed(popupPositionProvider2) ? 32 : 16;
            }
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        int i6 = i3;
        if ((i6 & 147) != 146 || !startRestartGroup.getSkipping()) {
            Function0<Unit> function05 = i5 != 0 ? null : function02;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-727958629, i6, -1, "androidx.compose.material3.internal.ExposedDropdownMenuPopup (ExposedDropdownMenuPopup.android.kt:84)");
            }
            ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localView);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            View view = (View) consume;
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density = (Density) consume2;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume3 = startRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection2 = (LayoutDirection) consume3;
            State<Boolean> state = TouchExplorationStateProvider_androidKt.touchExplorationState(startRestartGroup, 0);
            CompositionContext rememberCompositionContext = ComposablesKt.rememberCompositionContext(startRestartGroup, 0);
            final State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function2, startRestartGroup, (i6 >> 6) & 14);
            UUID uuid = (UUID) RememberSaveableKt.m3680rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) new Function0<UUID>() { // from class: androidx.compose.material3.internal.ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$popupId$1
                @Override // kotlin.jvm.functions.Function0
                public final UUID invoke() {
                    return UUID.randomUUID();
                }
            }, startRestartGroup, 3072, 6);
            boolean ExposedDropdownMenuPopup$lambda$0 = ExposedDropdownMenuPopup$lambda$0(state);
            startRestartGroup.startReplaceableGroup(-246571242);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ExposedDropdownMenuPopup.android.kt#9igjgp");
            boolean changed = startRestartGroup.changed(ExposedDropdownMenuPopup$lambda$0);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                function03 = function05;
                z = true;
                i4 = i6;
                layoutDirection = layoutDirection2;
                final PopupLayout popupLayout = new PopupLayout(function03, view, popupPositionProvider2, ExposedDropdownMenuPopup$lambda$0(state), density, uuid);
                popupLayout.setContent(rememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(-493861435, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$popupLayout$1$1$1
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
                        ComposerKt.sourceInformation(composer2, "C107@4397L122,103@4209L533:ExposedDropdownMenuPopup.android.kt#mqatfk");
                        if ((i7 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-493861435, i7, -1, "androidx.compose.material3.internal.ExposedDropdownMenuPopup.<anonymous>.<anonymous>.<anonymous> (ExposedDropdownMenuPopup.android.kt:103)");
                            }
                            Modifier semantics$default = SemanticsModifierKt.semantics$default(Modifier.INSTANCE, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.internal.ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$popupLayout$1$1$1.1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    SemanticsPropertiesKt.popup(semanticsPropertyReceiver);
                                }
                            }, 1, null);
                            composer2.startReplaceableGroup(-2041182138);
                            ComposerKt.sourceInformation(composer2, "CC(remember):ExposedDropdownMenuPopup.android.kt#9igjgp");
                            boolean changedInstance = composer2.changedInstance(PopupLayout.this);
                            final PopupLayout popupLayout2 = PopupLayout.this;
                            Object rememberedValue2 = composer2.rememberedValue();
                            if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue2 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.compose.material3.internal.ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$popupLayout$1$1$1$2$1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                                        m2942invokeozmzZPI(intSize.getPackedValue());
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                                    public final void m2942invokeozmzZPI(long j) {
                                        PopupLayout.this.m2944setPopupContentSizefhxjrPA(IntSize.m6551boximpl(j));
                                        PopupLayout.this.updatePosition();
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue2);
                            }
                            composer2.endReplaceableGroup();
                            Modifier alpha = AlphaKt.alpha(OnRemeasuredModifierKt.onSizeChanged(semantics$default, (Function1) rememberedValue2), PopupLayout.this.getCanCalculatePosition() ? 1.0f : 0.0f);
                            final State<Function2<Composer, Integer, Unit>> state2 = rememberUpdatedState;
                            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer2, 1824588059, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$popupLayout$1$1$1.3
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

                                public final void invoke(Composer composer3, int i8) {
                                    Function2 ExposedDropdownMenuPopup$lambda$1;
                                    ComposerKt.sourceInformation(composer3, "C114@4708L16:ExposedDropdownMenuPopup.android.kt#mqatfk");
                                    if ((i8 & 3) == 2 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1824588059, i8, -1, "androidx.compose.material3.internal.ExposedDropdownMenuPopup.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ExposedDropdownMenuPopup.android.kt:114)");
                                    }
                                    ExposedDropdownMenuPopup$lambda$1 = ExposedDropdownMenuPopup_androidKt.ExposedDropdownMenuPopup$lambda$1(state2);
                                    ExposedDropdownMenuPopup$lambda$1.invoke(composer3, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            });
                            composer2.startReplaceableGroup(437877758);
                            ComposerKt.sourceInformation(composer2, "CC(SimpleStack)P(1)167@6382L979:ExposedDropdownMenuPopup.android.kt#mqatfk");
                            ExposedDropdownMenuPopup_androidKt$SimpleStack$1 exposedDropdownMenuPopup_androidKt$SimpleStack$1 = ExposedDropdownMenuPopup_androidKt$SimpleStack$1.INSTANCE;
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(alpha);
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
                            Updater.m3600setimpl(m3593constructorimpl, exposedDropdownMenuPopup_androidKt$SimpleStack$1, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            composableLambda.invoke(composer2, 6);
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
                }));
                startRestartGroup.updateRememberedValue(popupLayout);
                rememberedValue = popupLayout;
            } else {
                function03 = function05;
                z = true;
                i4 = i6;
                layoutDirection = layoutDirection2;
            }
            final PopupLayout popupLayout2 = (PopupLayout) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-246570242);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ExposedDropdownMenuPopup.android.kt#9igjgp");
            int i7 = i4 & 14;
            boolean changedInstance = startRestartGroup.changedInstance(popupLayout2) | (i7 == 4 ? z : false) | startRestartGroup.changed(layoutDirection);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material3.internal.ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        PopupLayout.this.show();
                        PopupLayout.this.updateParameters(function03, layoutDirection);
                        final PopupLayout popupLayout3 = PopupLayout.this;
                        return new DisposableEffectResult() { // from class: androidx.compose.material3.internal.ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$1$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                PopupLayout.this.disposeComposition();
                                PopupLayout.this.dismiss();
                            }
                        };
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            EffectsKt.DisposableEffect(popupLayout2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue2, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-246569906);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ExposedDropdownMenuPopup.android.kt#9igjgp");
            boolean changedInstance2 = startRestartGroup.changedInstance(popupLayout2);
            if (i7 != 4) {
                z = false;
            }
            boolean changed2 = z | changedInstance2 | startRestartGroup.changed(layoutDirection);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.internal.ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$2$1
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
                        PopupLayout.this.updateParameters(function03, layoutDirection);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceableGroup();
            EffectsKt.SideEffect((Function0) rememberedValue3, startRestartGroup, 0);
            Modifier.Companion companion = Modifier.INSTANCE;
            startRestartGroup.startReplaceableGroup(-246569499);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ExposedDropdownMenuPopup.android.kt#9igjgp");
            boolean changedInstance3 = startRestartGroup.changedInstance(popupLayout2);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changedInstance3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material3.internal.ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$4$1
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
                        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
                        Intrinsics.checkNotNull(parentLayoutCoordinates);
                        long mo5340getSizeYbymL2g = parentLayoutCoordinates.mo5340getSizeYbymL2g();
                        long positionInWindow = LayoutCoordinatesKt.positionInWindow(parentLayoutCoordinates);
                        PopupLayout.this.setParentBounds(IntRectKt.m6549IntRectVbeCjmY(IntOffsetKt.IntOffset(MathKt.roundToInt(Offset.m3822getXimpl(positionInWindow)), MathKt.roundToInt(Offset.m3823getYimpl(positionInWindow))), mo5340getSizeYbymL2g));
                        PopupLayout.this.updatePosition();
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceableGroup();
            Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(companion, (Function1) rememberedValue4);
            startRestartGroup.startReplaceableGroup(-246569030);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ExposedDropdownMenuPopup.android.kt#9igjgp");
            boolean changedInstance4 = startRestartGroup.changedInstance(popupLayout2) | startRestartGroup.changed(layoutDirection);
            MeasurePolicy rememberedValue5 = startRestartGroup.rememberedValue();
            if (changedInstance4 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = new MeasurePolicy() { // from class: androidx.compose.material3.internal.ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$5$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo355measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        PopupLayout.this.setParentLayoutDirection(layoutDirection);
                        return MeasureScope.layout$default(measureScope, 0, 0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.internal.ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$5$1.1
                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Placeable.PlacementScope placementScope) {
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }
                        }, 4, null);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue5;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(onGloballyPositioned);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
            Updater.m3600setimpl(m3593constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 571475666, "C:ExposedDropdownMenuPopup.android.kt#mqatfk");
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function04 = function03;
        } else {
            startRestartGroup.skipToGroupEnd();
            function04 = function02;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$6
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

                public final void invoke(Composer composer2, int i8) {
                    ExposedDropdownMenuPopup_androidKt.ExposedDropdownMenuPopup(function04, popupPositionProvider, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    private static final void SimpleStack(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        composer.startReplaceableGroup(437877758);
        ComposerKt.sourceInformation(composer, "CC(SimpleStack)P(1)167@6382L979:ExposedDropdownMenuPopup.android.kt#mqatfk");
        ExposedDropdownMenuPopup_androidKt$SimpleStack$1 exposedDropdownMenuPopup_androidKt$SimpleStack$1 = ExposedDropdownMenuPopup_androidKt$SimpleStack$1.INSTANCE;
        composer.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(composer, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier);
        int i2 = (((((i << 3) & 112) | ((i >> 3) & 14)) << 9) & 7168) | 6;
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer m3593constructorimpl = Updater.m3593constructorimpl(composer);
        Updater.m3600setimpl(m3593constructorimpl, exposedDropdownMenuPopup_androidKt$SimpleStack$1, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer)), composer, 0);
        composer.startReplaceableGroup(2058660585);
        function2.invoke(composer, Integer.valueOf((i2 >> 9) & 14));
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    private static final boolean ExposedDropdownMenuPopup$lambda$0(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function2<Composer, Integer, Unit> ExposedDropdownMenuPopup$lambda$1(State<? extends Function2<? super Composer, ? super Integer, Unit>> state) {
        return (Function2) state.getValue();
    }
}
