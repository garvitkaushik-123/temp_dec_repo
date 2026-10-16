package androidx.compose.material;

import android.graphics.Rect;
import android.view.View;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import com.ironsource.C3057e4;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExposedDropdownMenu.android.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001aQ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\f\u001a6\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0005H\u0002\u001a\"\u0010\u0015\u001a\u00020\u0007*\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¨\u0006\u0019²\u0006\n\u0010\u001a\u001a\u00020\u0013X\u008a\u008e\u0002²\u0006\n\u0010\u001b\u001a\u00020\u0013X\u008a\u008e\u0002"}, d2 = {"ExposedDropdownMenuBox", "", "expanded", "", "onExpandedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Landroidx/compose/material/ExposedDropdownMenuBoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "updateHeight", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Landroid/view/View;", C3057e4.f, "Landroidx/compose/ui/layout/LayoutCoordinates;", "verticalMarginInPx", "", "onHeightUpdate", "expandable", "Lkotlin/Function0;", "menuLabel", "", "material_release", "width", "menuHeight"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ExposedDropdownMenu_androidKt {
    /* JADX WARN: Removed duplicated region for block: B:13:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ExposedDropdownMenuBox(final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, final Function3<? super ExposedDropdownMenuBoxScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        Modifier.Companion companion;
        Object rememberedValue;
        Object rememberedValue2;
        Object rememberedValue3;
        boolean changed;
        Object rememberedValue4;
        Object rememberedValue5;
        boolean changedInstance;
        Object rememberedValue6;
        int currentCompositeKeyHash;
        Composer m3593constructorimpl;
        boolean changed2;
        Object rememberedValue7;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-617870381);
        ComposerKt.sourceInformation(startRestartGroup, "C(ExposedDropdownMenuBox)P(1,3,2)96@4191L7,97@4224L7,98@4249L33,99@4305L33,101@4439L37,103@4494L486,116@5006L29,131@5474L38,118@5041L550,137@5597L70,141@5673L441:ExposedDropdownMenu.android.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            if ((i2 & 8) == 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                i3 |= startRestartGroup.changedInstance(function3) ? 2048 : 1024;
            }
            if ((i3 & 5851) == 1170 || !startRestartGroup.getSkipping()) {
                companion = i4 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-617870381, i3, -1, "androidx.compose.material.ExposedDropdownMenuBox (ExposedDropdownMenu.android.kt:95)");
                }
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume = startRestartGroup.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                final Density density = (Density) consume;
                ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume2 = startRestartGroup.consume(localView);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                final View view = (View) consume2;
                startRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceableGroup();
                final MutableIntState mutableIntState = (MutableIntState) rememberedValue;
                startRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = SnapshotIntStateKt.mutableIntStateOf(0);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceableGroup();
                final MutableIntState mutableIntState2 = (MutableIntState) rememberedValue2;
                final int mo624roundToPx0680j_4 = density.mo624roundToPx0680j_4(MenuKt.getMenuVerticalMargin());
                startRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = new Ref();
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceableGroup();
                final Ref ref = (Ref) rememberedValue3;
                Integer valueOf = Integer.valueOf(ExposedDropdownMenuBox$lambda$4(mutableIntState2));
                Integer valueOf2 = Integer.valueOf(ExposedDropdownMenuBox$lambda$1(mutableIntState));
                startRestartGroup.startReplaceableGroup(1618982084);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
                changed = startRestartGroup.changed(density) | startRestartGroup.changed(valueOf) | startRestartGroup.changed(valueOf2);
                rememberedValue4 = startRestartGroup.rememberedValue();
                if (!changed || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue4 = new ExposedDropdownMenuBoxScope() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1
                        @Override // androidx.compose.material.ExposedDropdownMenuBoxScope
                        public Modifier exposedDropdownSize(Modifier modifier3, boolean z2) {
                            int ExposedDropdownMenuBox$lambda$4;
                            int ExposedDropdownMenuBox$lambda$1;
                            Density density2 = Density.this;
                            MutableIntState mutableIntState3 = mutableIntState2;
                            MutableIntState mutableIntState4 = mutableIntState;
                            ExposedDropdownMenuBox$lambda$4 = ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$4(mutableIntState3);
                            Modifier m916heightInVpY3zN4$default = SizeKt.m916heightInVpY3zN4$default(modifier3, 0.0f, density2.mo627toDpu2uoSUM(ExposedDropdownMenuBox$lambda$4), 1, null);
                            if (!z2) {
                                return m916heightInVpY3zN4$default;
                            }
                            ExposedDropdownMenuBox$lambda$1 = ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$1(mutableIntState4);
                            return SizeKt.m933width3ABfNKs(m916heightInVpY3zN4$default, density2.mo627toDpu2uoSUM(ExposedDropdownMenuBox$lambda$1));
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                startRestartGroup.endReplaceableGroup();
                ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1 exposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1 = (ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1) rememberedValue4;
                startRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                rememberedValue5 = startRestartGroup.rememberedValue();
                if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue5 = new FocusRequester();
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                startRestartGroup.endReplaceableGroup();
                final FocusRequester focusRequester = (FocusRequester) rememberedValue5;
                Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(companion, new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$1
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
                        mutableIntState.setIntValue(IntSize.m6559getWidthimpl(layoutCoordinates.mo5340getSizeYbymL2g()));
                        ref.setValue(layoutCoordinates);
                        View rootView = view.getRootView();
                        LayoutCoordinates value = ref.getValue();
                        int i5 = mo624roundToPx0680j_4;
                        final MutableIntState mutableIntState3 = mutableIntState2;
                        ExposedDropdownMenu_androidKt.updateHeight(rootView, value, i5, new Function1<Integer, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                                invoke(num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(int i6) {
                                MutableIntState.this.setIntValue(i6);
                            }
                        });
                    }
                });
                startRestartGroup.startReplaceableGroup(1959164229);
                changedInstance = startRestartGroup.changedInstance(function1) | startRestartGroup.changed(z);
                rememberedValue6 = startRestartGroup.rememberedValue();
                if (!changedInstance || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue6 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$2$1
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
                            function1.invoke(Boolean.valueOf(!z));
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue6);
                }
                startRestartGroup.endReplaceableGroup();
                Modifier focusRequester2 = FocusRequesterModifierKt.focusRequester(expandable(onGloballyPositioned, (Function0) rememberedValue6, Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1776getExposedDropdownMenuUdPEhr4(), startRestartGroup, 6)), focusRequester);
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(focusRequester2);
                int i5 = i3;
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
                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1560854722, "C134@5576L9:ExposedDropdownMenu.android.kt#jmzs0o");
                function3.invoke(exposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1, startRestartGroup, Integer.valueOf((i5 >> 6) & 112));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(1959164420);
                changed2 = startRestartGroup.changed(z) | startRestartGroup.changed(focusRequester);
                rememberedValue7 = startRestartGroup.rememberedValue();
                if (!changed2 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue7 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$4$1
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
                            if (z) {
                                focusRequester.requestFocus();
                            }
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue7);
                }
                startRestartGroup.endReplaceableGroup();
                EffectsKt.SideEffect((Function0) rememberedValue7, startRestartGroup, 0);
                EffectsKt.DisposableEffect(view, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        View view2 = view;
                        final View view3 = view;
                        final Ref<LayoutCoordinates> ref2 = ref;
                        final int i6 = mo624roundToPx0680j_4;
                        final MutableIntState mutableIntState3 = mutableIntState2;
                        final OnGlobalLayoutListener onGlobalLayoutListener = new OnGlobalLayoutListener(view2, new Function0<Unit>() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$5$listener$1
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
                                View rootView = view3.getRootView();
                                LayoutCoordinates value = ref2.getValue();
                                int i7 = i6;
                                final MutableIntState mutableIntState4 = mutableIntState3;
                                ExposedDropdownMenu_androidKt.updateHeight(rootView, value, i7, new Function1<Integer, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$5$listener$1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                                        invoke(num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(int i8) {
                                        MutableIntState.this.setIntValue(i8);
                                    }
                                });
                            }
                        });
                        return new DisposableEffectResult() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$5$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                OnGlobalLayoutListener.this.dispose();
                            }
                        };
                    }
                }, startRestartGroup, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                companion = modifier2;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                final Modifier modifier3 = companion;
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$6
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

                    public final void invoke(Composer composer2, int i6) {
                        ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox(z, function1, modifier3, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        modifier2 = modifier;
        if ((i2 & 8) == 0) {
        }
        if ((i3 & 5851) == 1170) {
        }
        if (i4 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume3 = startRestartGroup.consume(localDensity2);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        final Density density2 = (Density) consume3;
        ProvidableCompositionLocal<View> localView2 = AndroidCompositionLocals_androidKt.getLocalView();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume22 = startRestartGroup.consume(localView2);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        final View view2 = (View) consume22;
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final MutableIntState mutableIntState3 = (MutableIntState) rememberedValue;
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final MutableIntState mutableIntState22 = (MutableIntState) rememberedValue2;
        final int mo624roundToPx0680j_42 = density2.mo624roundToPx0680j_4(MenuKt.getMenuVerticalMargin());
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final Ref<LayoutCoordinates> ref2 = (Ref) rememberedValue3;
        Integer valueOf3 = Integer.valueOf(ExposedDropdownMenuBox$lambda$4(mutableIntState22));
        Integer valueOf22 = Integer.valueOf(ExposedDropdownMenuBox$lambda$1(mutableIntState3));
        startRestartGroup.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        changed = startRestartGroup.changed(density2) | startRestartGroup.changed(valueOf3) | startRestartGroup.changed(valueOf22);
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue4 = new ExposedDropdownMenuBoxScope() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1
            @Override // androidx.compose.material.ExposedDropdownMenuBoxScope
            public Modifier exposedDropdownSize(Modifier modifier32, boolean z2) {
                int ExposedDropdownMenuBox$lambda$4;
                int ExposedDropdownMenuBox$lambda$1;
                Density density22 = Density.this;
                MutableIntState mutableIntState32 = mutableIntState22;
                MutableIntState mutableIntState4 = mutableIntState3;
                ExposedDropdownMenuBox$lambda$4 = ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$4(mutableIntState32);
                Modifier m916heightInVpY3zN4$default = SizeKt.m916heightInVpY3zN4$default(modifier32, 0.0f, density22.mo627toDpu2uoSUM(ExposedDropdownMenuBox$lambda$4), 1, null);
                if (!z2) {
                    return m916heightInVpY3zN4$default;
                }
                ExposedDropdownMenuBox$lambda$1 = ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$1(mutableIntState4);
                return SizeKt.m933width3ABfNKs(m916heightInVpY3zN4$default, density22.mo627toDpu2uoSUM(ExposedDropdownMenuBox$lambda$1));
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue4);
        startRestartGroup.endReplaceableGroup();
        ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1 exposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$12 = (ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1) rememberedValue4;
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
        rememberedValue5 = startRestartGroup.rememberedValue();
        if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final FocusRequester focusRequester3 = (FocusRequester) rememberedValue5;
        Modifier onGloballyPositioned2 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion, new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$1
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
                mutableIntState3.setIntValue(IntSize.m6559getWidthimpl(layoutCoordinates.mo5340getSizeYbymL2g()));
                ref2.setValue(layoutCoordinates);
                View rootView = view2.getRootView();
                LayoutCoordinates value = ref2.getValue();
                int i52 = mo624roundToPx0680j_42;
                final MutableIntState mutableIntState32 = mutableIntState22;
                ExposedDropdownMenu_androidKt.updateHeight(rootView, value, i52, new Function1<Integer, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke(num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i6) {
                        MutableIntState.this.setIntValue(i6);
                    }
                });
            }
        });
        startRestartGroup.startReplaceableGroup(1959164229);
        changedInstance = startRestartGroup.changedInstance(function1) | startRestartGroup.changed(z);
        rememberedValue6 = startRestartGroup.rememberedValue();
        if (!changedInstance) {
        }
        rememberedValue6 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$2$1
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
                function1.invoke(Boolean.valueOf(!z));
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue6);
        startRestartGroup.endReplaceableGroup();
        Modifier focusRequester22 = FocusRequesterModifierKt.focusRequester(expandable(onGloballyPositioned2, (Function0) rememberedValue6, Strings_androidKt.m1780getString4foXLRw(Strings.INSTANCE.m1776getExposedDropdownMenuUdPEhr4(), startRestartGroup, 6)), focusRequester3);
        startRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
        MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(focusRequester22);
        int i52 = i3;
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
        modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1560854722, "C134@5576L9:ExposedDropdownMenu.android.kt#jmzs0o");
        function3.invoke(exposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$12, startRestartGroup, Integer.valueOf((i52 >> 6) & 112));
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(1959164420);
        changed2 = startRestartGroup.changed(z) | startRestartGroup.changed(focusRequester3);
        rememberedValue7 = startRestartGroup.rememberedValue();
        if (!changed2) {
        }
        rememberedValue7 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$4$1
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
                if (z) {
                    focusRequester3.requestFocus();
                }
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue7);
        startRestartGroup.endReplaceableGroup();
        EffectsKt.SideEffect((Function0) rememberedValue7, startRestartGroup, 0);
        EffectsKt.DisposableEffect(view2, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                View view22 = view2;
                final View view3 = view2;
                final Ref<LayoutCoordinates> ref22 = ref2;
                final int i6 = mo624roundToPx0680j_42;
                final MutableIntState mutableIntState32 = mutableIntState22;
                final OnGlobalLayoutListener onGlobalLayoutListener = new OnGlobalLayoutListener(view22, new Function0<Unit>() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$5$listener$1
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
                        View rootView = view3.getRootView();
                        LayoutCoordinates value = ref22.getValue();
                        int i7 = i6;
                        final MutableIntState mutableIntState4 = mutableIntState32;
                        ExposedDropdownMenu_androidKt.updateHeight(rootView, value, i7, new Function1<Integer, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$5$listener$1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                                invoke(num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(int i8) {
                                MutableIntState.this.setIntValue(i8);
                            }
                        });
                    }
                });
                return new DisposableEffectResult() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$5$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        OnGlobalLayoutListener.this.dispose();
                    }
                };
            }
        }, startRestartGroup, 8);
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ExposedDropdownMenuBox$lambda$1(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ExposedDropdownMenuBox$lambda$4(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    private static final Modifier expandable(Modifier modifier, final Function0<Unit> function0, final String str) {
        return SemanticsModifierKt.semantics$default(SuspendingPointerInputFilterKt.pointerInput(modifier, function0, new ExposedDropdownMenu_androidKt$expandable$1(function0, null)), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$expandable$2
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
                SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
                final Function0<Unit> function02 = function0;
                SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$expandable$2.1
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
    public static final void updateHeight(View view, LayoutCoordinates layoutCoordinates, int i, Function1<? super Integer, Unit> function1) {
        if (layoutCoordinates == null) {
            return;
        }
        view.getWindowVisibleDisplayFrame(new Rect());
        function1.invoke(Integer.valueOf(((int) Math.max(LayoutCoordinatesKt.boundsInWindow(layoutCoordinates).getTop() - r0.top, (r0.bottom - r0.top) - LayoutCoordinatesKt.boundsInWindow(layoutCoordinates).getBottom())) - i));
    }
}
