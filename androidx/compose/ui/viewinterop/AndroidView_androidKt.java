package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.UiApplier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidView.android.kt */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ay\u0010\u0007\u001a\u00020\u0003\"\b\b\u0000\u0010\b*\u00020\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\b0\u00012\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00030\u00012\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00030\u0001H\u0007¢\u0006\u0002\u0010\u0010\u001aK\u0010\u0007\u001a\u00020\u0003\"\b\b\u0000\u0010\b*\u00020\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\b0\u00012\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00030\u0001H\u0007¢\u0006\u0002\u0010\u0011\u001a1\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\"\b\b\u0000\u0010\b*\u00020\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\b0\u0001H\u0003¢\u0006\u0002\u0010\u0015\u001a\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\b0\u0017\"\b\b\u0000\u0010\b*\u00020\u0002*\u00020\u0014H\u0002\u001a^\u0010\u0018\u001a\u00020\u0003\"\b\b\u0000\u0010\b*\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00140\u00192\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002ø\u0001\u0000¢\u0006\u0004\b&\u0010'\"\"\u0010\u0000\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006("}, d2 = {"NoOpUpdate", "Lkotlin/Function1;", "Landroid/view/View;", "", "Lkotlin/ExtensionFunctionType;", "getNoOpUpdate", "()Lkotlin/jvm/functions/Function1;", "AndroidView", "T", "factory", "Landroid/content/Context;", "modifier", "Landroidx/compose/ui/Modifier;", "onReset", "onRelease", "update", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "createAndroidViewNodeFactory", "Lkotlin/Function0;", "Landroidx/compose/ui/node/LayoutNode;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function0;", "requireViewFactoryHolder", "Landroidx/compose/ui/viewinterop/ViewFactoryHolder;", "updateViewHolderParams", "Landroidx/compose/runtime/Updater;", "compositeKeyHash", "", "density", "Landroidx/compose/ui/unit/Density;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "savedStateRegistryOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "compositionLocalMap", "Landroidx/compose/runtime/CompositionLocalMap;", "updateViewHolderParams-6NefGtU", "(Landroidx/compose/runtime/Composer;Landroidx/compose/ui/Modifier;ILandroidx/compose/ui/unit/Density;Landroidx/lifecycle/LifecycleOwner;Landroidx/savedstate/SavedStateRegistryOwner;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/runtime/CompositionLocalMap;)V", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AndroidView_androidKt {
    private static final Function1<View, Unit> NoOpUpdate = new Function1<View, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$NoOpUpdate$1
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.INSTANCE;
        }
    };

    public static final <T extends View> void AndroidView(final Function1<? super Context, ? extends T> function1, Modifier modifier, Function1<? super T, Unit> function12, Composer composer, final int i, final int i2) {
        int i3;
        final Modifier modifier2;
        final Function1<? super T, Unit> function13;
        Composer startRestartGroup = composer.startRestartGroup(-1783766393);
        ComposerKt.sourceInformation(startRestartGroup, "C(AndroidView)107@5478L130:AndroidView.android.kt#z33iqn");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changedInstance(function1) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            i3 |= startRestartGroup.changedInstance(function12) ? 256 : 128;
        }
        if ((i3 & 731) != 146 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            Modifier modifier3 = modifier;
            if (i5 != 0) {
                function12 = NoOpUpdate;
            }
            Function1<? super T, Unit> function14 = function12;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1783766393, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:106)");
            }
            AndroidView(function1, modifier3, null, NoOpUpdate, function14, startRestartGroup, (i3 & 14) | 3072 | (i3 & 112) | (57344 & (i3 << 6)), 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            function13 = function14;
        } else {
            startRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
            function13 = function12;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$1
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
                    AndroidView_androidKt.AndroidView(function1, modifier2, function13, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T extends View> void AndroidView(final Function1<? super Context, ? extends T> function1, Modifier modifier, Function1<? super T, Unit> function12, Function1<? super T, Unit> function13, Function1<? super T, Unit> function14, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Function1<? super T, Unit> function15;
        int i5;
        Function1<? super T, Unit> function16;
        int i6;
        Function1<? super T, Unit> function17;
        Modifier.Companion companion;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-180024211);
        ComposerKt.sourceInformation(startRestartGroup, "C(AndroidView)P(!2,3)211@11894L23,213@12018L7,214@12073L7,221@12529L7,222@12600L7:AndroidView.android.kt#z33iqn");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changedInstance(function1) ? 4 : 2) | i;
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
                function15 = function12;
                i3 |= startRestartGroup.changedInstance(function15) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 7168) == 0) {
                    function16 = function13;
                    i3 |= startRestartGroup.changedInstance(function16) ? 2048 : 1024;
                    i6 = i2 & 16;
                    if (i6 == 0) {
                        i3 |= 24576;
                    } else if ((57344 & i) == 0) {
                        function17 = function14;
                        i3 |= startRestartGroup.changedInstance(function17) ? 16384 : 8192;
                        if ((46811 & i3) == 9362 || !startRestartGroup.getSkipping()) {
                            companion = i7 != 0 ? Modifier.INSTANCE : modifier2;
                            if (i4 != 0) {
                                function15 = null;
                            }
                            if (i5 != 0) {
                                function16 = NoOpUpdate;
                            }
                            if (i6 != 0) {
                                function17 = NoOpUpdate;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:210)");
                            }
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume = startRestartGroup.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            Density density = (Density) consume;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume2 = startRestartGroup.consume(localLayoutDirection);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            LayoutDirection layoutDirection = (LayoutDirection) consume2;
                            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                            ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume3 = startRestartGroup.consume(localLifecycleOwner);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            LifecycleOwner lifecycleOwner = (LifecycleOwner) consume3;
                            ProvidableCompositionLocal<SavedStateRegistryOwner> localSavedStateRegistryOwner = AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume4 = startRestartGroup.consume(localSavedStateRegistryOwner);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            SavedStateRegistryOwner savedStateRegistryOwner = (SavedStateRegistryOwner) consume4;
                            if (function15 != null) {
                                startRestartGroup.startReplaceableGroup(-88753355);
                                ComposerKt.sourceInformation(startRestartGroup, "226@12710L37,225@12644L843");
                                final Function0<LayoutNode> createAndroidViewNodeFactory = createAndroidViewNodeFactory(function1, startRestartGroup, i3 & 14);
                                startRestartGroup.startReplaceableGroup(1405779621);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                                if (!(startRestartGroup.getApplier() instanceof UiApplier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                startRestartGroup.startReusableNode();
                                if (startRestartGroup.getInserting()) {
                                    startRestartGroup.createNode(new Function0<LayoutNode>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.node.LayoutNode, java.lang.Object] */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final LayoutNode invoke() {
                                            return Function0.this.invoke();
                                        }
                                    });
                                } else {
                                    startRestartGroup.useNode();
                                }
                                Composer m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
                                m6636updateViewHolderParams6NefGtU(m3593constructorimpl, materializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                                Updater.m3600setimpl(m3593constructorimpl, function15, new Function2<LayoutNode, Function1<? super T, ? extends Unit>, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$1
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, Object obj) {
                                        invoke(layoutNode, (Function1) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LayoutNode layoutNode, Function1<? super T, Unit> function18) {
                                        ViewFactoryHolder requireViewFactoryHolder;
                                        requireViewFactoryHolder = AndroidView_androidKt.requireViewFactoryHolder(layoutNode);
                                        requireViewFactoryHolder.setResetBlock(function18);
                                    }
                                });
                                Updater.m3600setimpl(m3593constructorimpl, function17, new Function2<LayoutNode, Function1<? super T, ? extends Unit>, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$2
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, Object obj) {
                                        invoke(layoutNode, (Function1) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LayoutNode layoutNode, Function1<? super T, Unit> function18) {
                                        ViewFactoryHolder requireViewFactoryHolder;
                                        requireViewFactoryHolder = AndroidView_androidKt.requireViewFactoryHolder(layoutNode);
                                        requireViewFactoryHolder.setUpdateBlock(function18);
                                    }
                                });
                                Updater.m3600setimpl(m3593constructorimpl, function16, new Function2<LayoutNode, Function1<? super T, ? extends Unit>, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$3
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, Object obj) {
                                        invoke(layoutNode, (Function1) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LayoutNode layoutNode, Function1<? super T, Unit> function18) {
                                        ViewFactoryHolder requireViewFactoryHolder;
                                        requireViewFactoryHolder = AndroidView_androidKt.requireViewFactoryHolder(layoutNode);
                                        requireViewFactoryHolder.setReleaseBlock(function18);
                                    }
                                });
                                startRestartGroup.endNode();
                                startRestartGroup.endReplaceableGroup();
                                startRestartGroup.endReplaceableGroup();
                            } else {
                                startRestartGroup.startReplaceableGroup(-88752490);
                                ComposerKt.sourceInformation(startRestartGroup, "244@13567L37,243@13509L756");
                                final Function0<LayoutNode> createAndroidViewNodeFactory2 = createAndroidViewNodeFactory(function1, startRestartGroup, i3 & 14);
                                startRestartGroup.startReplaceableGroup(1886828752);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(ComposeNode):Composables.kt#9igjgp");
                                if (!(startRestartGroup.getApplier() instanceof UiApplier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                startRestartGroup.startNode();
                                if (startRestartGroup.getInserting()) {
                                    startRestartGroup.createNode(new Function0<LayoutNode>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.node.LayoutNode, java.lang.Object] */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final LayoutNode invoke() {
                                            return Function0.this.invoke();
                                        }
                                    });
                                } else {
                                    startRestartGroup.useNode();
                                }
                                Composer m3593constructorimpl2 = Updater.m3593constructorimpl(startRestartGroup);
                                m6636updateViewHolderParams6NefGtU(m3593constructorimpl2, materializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                                Updater.m3600setimpl(m3593constructorimpl2, function17, new Function2<LayoutNode, Function1<? super T, ? extends Unit>, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3$1
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, Object obj) {
                                        invoke(layoutNode, (Function1) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LayoutNode layoutNode, Function1<? super T, Unit> function18) {
                                        ViewFactoryHolder requireViewFactoryHolder;
                                        requireViewFactoryHolder = AndroidView_androidKt.requireViewFactoryHolder(layoutNode);
                                        requireViewFactoryHolder.setUpdateBlock(function18);
                                    }
                                });
                                Updater.m3600setimpl(m3593constructorimpl2, function16, new Function2<LayoutNode, Function1<? super T, ? extends Unit>, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3$2
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, Object obj) {
                                        invoke(layoutNode, (Function1) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LayoutNode layoutNode, Function1<? super T, Unit> function18) {
                                        ViewFactoryHolder requireViewFactoryHolder;
                                        requireViewFactoryHolder = AndroidView_androidKt.requireViewFactoryHolder(layoutNode);
                                        requireViewFactoryHolder.setReleaseBlock(function18);
                                    }
                                });
                                startRestartGroup.endNode();
                                startRestartGroup.endReplaceableGroup();
                                startRestartGroup.endReplaceableGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            companion = modifier2;
                        }
                        final Function1<? super T, Unit> function18 = function15;
                        final Function1<? super T, Unit> function19 = function17;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Modifier modifier3 = companion;
                            final Function1<? super T, Unit> function110 = function16;
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$4
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
                                    AndroidView_androidKt.AndroidView(function1, modifier3, function18, function110, function19, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    function17 = function14;
                    if ((46811 & i3) == 9362) {
                    }
                    if (i7 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
                    ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume5 = startRestartGroup.consume(localDensity2);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    Density density2 = (Density) consume5;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume22 = startRestartGroup.consume(localLayoutDirection2);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    LayoutDirection layoutDirection2 = (LayoutDirection) consume22;
                    CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                    ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner2 = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume32 = startRestartGroup.consume(localLifecycleOwner2);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    LifecycleOwner lifecycleOwner2 = (LifecycleOwner) consume32;
                    ProvidableCompositionLocal<SavedStateRegistryOwner> localSavedStateRegistryOwner2 = AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume42 = startRestartGroup.consume(localSavedStateRegistryOwner2);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    SavedStateRegistryOwner savedStateRegistryOwner2 = (SavedStateRegistryOwner) consume42;
                    if (function15 != null) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    final Function1<? super T, Unit> function182 = function15;
                    final Function1<? super T, Unit> function192 = function17;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function16 = function13;
                i6 = i2 & 16;
                if (i6 == 0) {
                }
                function17 = function14;
                if ((46811 & i3) == 9362) {
                }
                if (i7 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                int currentCompositeKeyHash22 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
                ProvidableCompositionLocal<Density> localDensity22 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume52 = startRestartGroup.consume(localDensity22);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Density density22 = (Density) consume52;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection22 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume222 = startRestartGroup.consume(localLayoutDirection22);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                LayoutDirection layoutDirection22 = (LayoutDirection) consume222;
                CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
                ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner22 = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume322 = startRestartGroup.consume(localLifecycleOwner22);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                LifecycleOwner lifecycleOwner22 = (LifecycleOwner) consume322;
                ProvidableCompositionLocal<SavedStateRegistryOwner> localSavedStateRegistryOwner22 = AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume422 = startRestartGroup.consume(localSavedStateRegistryOwner22);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                SavedStateRegistryOwner savedStateRegistryOwner22 = (SavedStateRegistryOwner) consume422;
                if (function15 != null) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                final Function1<? super T, Unit> function1822 = function15;
                final Function1<? super T, Unit> function1922 = function17;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function15 = function12;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            function16 = function13;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            function17 = function14;
            if ((46811 & i3) == 9362) {
            }
            if (i7 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            int currentCompositeKeyHash222 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            Modifier materializeModifier222 = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
            ProvidableCompositionLocal<Density> localDensity222 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume522 = startRestartGroup.consume(localDensity222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density222 = (Density) consume522;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection222 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2222 = startRestartGroup.consume(localLayoutDirection222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection222 = (LayoutDirection) consume2222;
            CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
            ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner222 = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume3222 = startRestartGroup.consume(localLifecycleOwner222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LifecycleOwner lifecycleOwner222 = (LifecycleOwner) consume3222;
            ProvidableCompositionLocal<SavedStateRegistryOwner> localSavedStateRegistryOwner222 = AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume4222 = startRestartGroup.consume(localSavedStateRegistryOwner222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            SavedStateRegistryOwner savedStateRegistryOwner222 = (SavedStateRegistryOwner) consume4222;
            if (function15 != null) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            final Function1<? super T, Unit> function18222 = function15;
            final Function1<? super T, Unit> function19222 = function17;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        function15 = function12;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        function16 = function13;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        function17 = function14;
        if ((46811 & i3) == 9362) {
        }
        if (i7 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        int currentCompositeKeyHash2222 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        Modifier materializeModifier2222 = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
        ProvidableCompositionLocal<Density> localDensity2222 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume5222 = startRestartGroup.consume(localDensity2222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Density density2222 = (Density) consume5222;
        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2222 = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume22222 = startRestartGroup.consume(localLayoutDirection2222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        LayoutDirection layoutDirection2222 = (LayoutDirection) consume22222;
        CompositionLocalMap currentCompositionLocalMap2222 = startRestartGroup.getCurrentCompositionLocalMap();
        ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner2222 = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume32222 = startRestartGroup.consume(localLifecycleOwner2222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        LifecycleOwner lifecycleOwner2222 = (LifecycleOwner) consume32222;
        ProvidableCompositionLocal<SavedStateRegistryOwner> localSavedStateRegistryOwner2222 = AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume42222 = startRestartGroup.consume(localSavedStateRegistryOwner2222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        SavedStateRegistryOwner savedStateRegistryOwner2222 = (SavedStateRegistryOwner) consume42222;
        if (function15 != null) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        final Function1<? super T, Unit> function182222 = function15;
        final Function1<? super T, Unit> function192222 = function17;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    private static final <T extends View> Function0<LayoutNode> createAndroidViewNodeFactory(final Function1<? super Context, ? extends T> function1, Composer composer, int i) {
        composer.startReplaceableGroup(2030558801);
        ComposerKt.sourceInformation(composer, "C(createAndroidViewNodeFactory)266@14417L23,267@14472L7,268@14506L28,269@14586L7,270@14624L7:AndroidView.android.kt#z33iqn");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2030558801, i, -1, "androidx.compose.ui.viewinterop.createAndroidViewNodeFactory (AndroidView.android.kt:265)");
        }
        final int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final Context context = (Context) consume;
        final CompositionContext rememberCompositionContext = ComposablesKt.rememberCompositionContext(composer, 0);
        ProvidableCompositionLocal<SaveableStateRegistry> localSaveableStateRegistry = SaveableStateRegistryKt.getLocalSaveableStateRegistry();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2 = composer.consume(localSaveableStateRegistry);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final SaveableStateRegistry saveableStateRegistry = (SaveableStateRegistry) consume2;
        ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume3 = composer.consume(localView);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final View view = (View) consume3;
        Function0<LayoutNode> function0 = new Function0<LayoutNode>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$createAndroidViewNodeFactory$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LayoutNode invoke() {
                Context context2 = context;
                Function1<Context, T> function12 = function1;
                CompositionContext compositionContext = rememberCompositionContext;
                SaveableStateRegistry saveableStateRegistry2 = saveableStateRegistry;
                int i2 = currentCompositeKeyHash;
                KeyEvent.Callback callback = view;
                Intrinsics.checkNotNull(callback, "null cannot be cast to non-null type androidx.compose.ui.node.Owner");
                return new ViewFactoryHolder(context2, function12, compositionContext, saveableStateRegistry2, i2, (Owner) callback).getLayoutNode();
            }
        };
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return function0;
    }

    /* renamed from: updateViewHolderParams-6NefGtU, reason: not valid java name */
    private static final <T extends View> void m6636updateViewHolderParams6NefGtU(Composer composer, Modifier modifier, int i, Density density, LifecycleOwner lifecycleOwner, SavedStateRegistryOwner savedStateRegistryOwner, LayoutDirection layoutDirection, CompositionLocalMap compositionLocalMap) {
        Updater.m3600setimpl(composer, compositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Updater.m3600setimpl(composer, modifier, new Function2<LayoutNode, Modifier, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$updateViewHolderParams$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, Modifier modifier2) {
                invoke2(layoutNode, modifier2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LayoutNode layoutNode, Modifier modifier2) {
                ViewFactoryHolder requireViewFactoryHolder;
                requireViewFactoryHolder = AndroidView_androidKt.requireViewFactoryHolder(layoutNode);
                requireViewFactoryHolder.setModifier(modifier2);
            }
        });
        Updater.m3600setimpl(composer, density, new Function2<LayoutNode, Density, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$updateViewHolderParams$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, Density density2) {
                invoke2(layoutNode, density2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LayoutNode layoutNode, Density density2) {
                ViewFactoryHolder requireViewFactoryHolder;
                requireViewFactoryHolder = AndroidView_androidKt.requireViewFactoryHolder(layoutNode);
                requireViewFactoryHolder.setDensity(density2);
            }
        });
        Updater.m3600setimpl(composer, lifecycleOwner, new Function2<LayoutNode, LifecycleOwner, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$updateViewHolderParams$3
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, LifecycleOwner lifecycleOwner2) {
                invoke2(layoutNode, lifecycleOwner2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LayoutNode layoutNode, LifecycleOwner lifecycleOwner2) {
                ViewFactoryHolder requireViewFactoryHolder;
                requireViewFactoryHolder = AndroidView_androidKt.requireViewFactoryHolder(layoutNode);
                requireViewFactoryHolder.setLifecycleOwner(lifecycleOwner2);
            }
        });
        Updater.m3600setimpl(composer, savedStateRegistryOwner, new Function2<LayoutNode, SavedStateRegistryOwner, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$updateViewHolderParams$4
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, SavedStateRegistryOwner savedStateRegistryOwner2) {
                invoke2(layoutNode, savedStateRegistryOwner2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LayoutNode layoutNode, SavedStateRegistryOwner savedStateRegistryOwner2) {
                ViewFactoryHolder requireViewFactoryHolder;
                requireViewFactoryHolder = AndroidView_androidKt.requireViewFactoryHolder(layoutNode);
                requireViewFactoryHolder.setSavedStateRegistryOwner(savedStateRegistryOwner2);
            }
        });
        Updater.m3600setimpl(composer, layoutDirection, new Function2<LayoutNode, LayoutDirection, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$updateViewHolderParams$5

            /* compiled from: AndroidView.android.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[LayoutDirection.values().length];
                    try {
                        iArr[LayoutDirection.Ltr.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[LayoutDirection.Rtl.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, LayoutDirection layoutDirection2) {
                invoke2(layoutNode, layoutDirection2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LayoutNode layoutNode, LayoutDirection layoutDirection2) {
                ViewFactoryHolder requireViewFactoryHolder;
                requireViewFactoryHolder = AndroidView_androidKt.requireViewFactoryHolder(layoutNode);
                int i2 = WhenMappings.$EnumSwitchMapping$0[layoutDirection2.ordinal()];
                int i3 = 1;
                if (i2 == 1) {
                    i3 = 0;
                } else if (i2 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                requireViewFactoryHolder.setLayoutDirection(i3);
            }
        });
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (composer.getInserting() || !Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(i))) {
            composer.updateRememberedValue(Integer.valueOf(i));
            composer.apply(Integer.valueOf(i), setCompositeKeyHash);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T extends View> ViewFactoryHolder<T> requireViewFactoryHolder(LayoutNode layoutNode) {
        AndroidViewHolder interopViewFactoryHolder = layoutNode.getInteropViewFactoryHolder();
        if (interopViewFactoryHolder == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        Intrinsics.checkNotNull(interopViewFactoryHolder, "null cannot be cast to non-null type androidx.compose.ui.viewinterop.ViewFactoryHolder<T of androidx.compose.ui.viewinterop.AndroidView_androidKt.requireViewFactoryHolder>");
        return (ViewFactoryHolder) interopViewFactoryHolder;
    }

    public static final Function1<View, Unit> getNoOpUpdate() {
        return NoOpUpdate;
    }
}
