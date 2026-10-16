package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import com.google.android.exoplayer2.C;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FloatingActionButton.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0086\u0001\u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0002\b\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\b\b\u0002\u0010\f\u001a\u00020\r2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001ao\u0010\u001a\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0002\b\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"ExtendedFabIconPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ExtendedFabSize", "ExtendedFabTextPadding", "FabSize", "ExtendedFloatingActionButton", "", "text", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "onClick", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "Landroidx/compose/material/FloatingActionButtonElevation;", "ExtendedFloatingActionButton-wqdebIU", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material/FloatingActionButtonElevation;Landroidx/compose/runtime/Composer;II)V", "FloatingActionButton", "content", "FloatingActionButton-bogVsAg", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material/FloatingActionButtonElevation;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FloatingActionButtonKt {
    private static final float FabSize = Dp.m6389constructorimpl(56);
    private static final float ExtendedFabSize = Dp.m6389constructorimpl(48);
    private static final float ExtendedFabIconPadding = Dp.m6389constructorimpl(12);
    private static final float ExtendedFabTextPadding = Dp.m6389constructorimpl(20);

    /* JADX WARN: Removed duplicated region for block: B:102:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01ba  */
    /* renamed from: FloatingActionButton-bogVsAg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1690FloatingActionButtonbogVsAg(final Function0<Unit> function0, Modifier modifier, MutableInteractionSource mutableInteractionSource, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        Modifier modifier2;
        int i4;
        MutableInteractionSource mutableInteractionSource2;
        Shape shape2;
        long j3;
        int i5;
        int i6;
        final long j4;
        FloatingActionButtonElevation m1686elevationxZ9QkE;
        Composer composer2;
        final FloatingActionButtonElevation floatingActionButtonElevation2;
        final Modifier modifier3;
        final Shape shape3;
        final long j5;
        final long j6;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope endRestartGroup;
        int i7;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(1028985328);
        ComposerKt.sourceInformation(startRestartGroup, "C(FloatingActionButton)P(6,5,4,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3)82@3863L39,83@3937L6,84@4025L6,85@4069L32,86@4179L11,95@4457L28,89@4236L718:FloatingActionButton.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 14) == 0) {
                i3 = (startRestartGroup.changedInstance(function02) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i10 = i2 & 2;
        if (i10 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 896) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                i3 |= startRestartGroup.changed(mutableInteractionSource2) ? 256 : 128;
                if ((i & 7168) == 0) {
                    if ((i2 & 8) == 0) {
                        shape2 = shape;
                        if (startRestartGroup.changed(shape2)) {
                            i9 = 2048;
                            i3 |= i9;
                        }
                    } else {
                        shape2 = shape;
                    }
                    i9 = 1024;
                    i3 |= i9;
                } else {
                    shape2 = shape;
                }
                if ((i & 57344) == 0) {
                    j3 = j;
                    i3 |= ((i2 & 16) == 0 && startRestartGroup.changed(j3)) ? 16384 : 8192;
                } else {
                    j3 = j;
                }
                if ((i & 458752) == 0) {
                    i5 = 57344;
                    if ((i2 & 32) == 0) {
                        i6 = 458752;
                        j4 = j2;
                        if (startRestartGroup.changed(j4)) {
                            i8 = 131072;
                            i3 |= i8;
                        }
                    } else {
                        i6 = 458752;
                        j4 = j2;
                    }
                    i8 = 65536;
                    i3 |= i8;
                } else {
                    i5 = 57344;
                    i6 = 458752;
                    j4 = j2;
                }
                if ((i & 3670016) == 0) {
                    i3 |= ((i2 & 64) == 0 && startRestartGroup.changed(floatingActionButtonElevation)) ? 1048576 : 524288;
                }
                if ((i2 & 128) == 0) {
                    i7 = (29360128 & i) == 0 ? startRestartGroup.changedInstance(function2) ? 8388608 : 4194304 : 12582912;
                    if ((23967451 & i3) == 4793490 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            if (i10 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                startRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                                Object rememberedValue = startRestartGroup.rememberedValue();
                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                startRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                                shape2 = MaterialTheme.INSTANCE.getShapes(startRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            }
                            if ((i2 & 16) != 0) {
                                j3 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m1605getSecondary0d7_KjU();
                                i3 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                j4 = ColorsKt.m1621contentColorForek8zF_U(j3, startRestartGroup, (i3 >> 12) & 14);
                                i3 &= -458753;
                            }
                            if ((i2 & 64) != 0) {
                                m1686elevationxZ9QkE = FloatingActionButtonDefaults.INSTANCE.m1686elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 24576, 15);
                                i3 &= -3670017;
                                MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                                long j7 = j3;
                                int i11 = i6;
                                Shape shape4 = shape2;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1028985328, i3, -1, "androidx.compose.material.FloatingActionButton (FloatingActionButton.kt:88)");
                                }
                                composer2 = startRestartGroup;
                                long j8 = j4;
                                SurfaceKt.m1783SurfaceLPr_se0(function02, SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                        invoke2(semanticsPropertyReceiver);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                        SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5716getButtono7Vup1c());
                                    }
                                }, 1, null), false, shape4, j7, j8, null, m1686elevationxZ9QkE.elevation(mutableInteractionSource4, startRestartGroup, ((i3 >> 6) & 14) | ((i3 >> 15) & 112)).getValue().m6403unboximpl(), mutableInteractionSource4, ComposableLambdaKt.composableLambda(startRestartGroup, 1972871863, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$3
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
                                        ComposerKt.sourceInformation(composer3, "C98@4556L392:FloatingActionButton.kt#jmzs0o");
                                        if ((i12 & 11) != 2 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1972871863, i12, -1, "androidx.compose.material.FloatingActionButton.<anonymous> (FloatingActionButton.kt:98)");
                                            }
                                            ProvidedValue<Float> provides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m4065getAlphaimpl(j4)));
                                            final Function2<Composer, Integer, Unit> function22 = function2;
                                            CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer3, 1867794295, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$3.1
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
                                                    ComposerKt.sourceInformation(composer4, "C99@4673L10,99@4642L296:FloatingActionButton.kt#jmzs0o");
                                                    if ((i13 & 11) != 2 || !composer4.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(1867794295, i13, -1, "androidx.compose.material.FloatingActionButton.<anonymous>.<anonymous> (FloatingActionButton.kt:99)");
                                                        }
                                                        TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                                        final Function2<Composer, Integer, Unit> function23 = function22;
                                                        TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -1567914264, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt.FloatingActionButton.3.1.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            /* JADX WARN: Multi-variable type inference failed */
                                                            {
                                                                super(2);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function2
                                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                                invoke(composer5, num.intValue());
                                                                return Unit.INSTANCE;
                                                            }

                                                            public final void invoke(Composer composer5, int i14) {
                                                                float f;
                                                                float f2;
                                                                ComposerKt.sourceInformation(composer5, "C100@4710L214:FloatingActionButton.kt#jmzs0o");
                                                                if ((i14 & 11) != 2 || !composer5.getSkipping()) {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(-1567914264, i14, -1, "androidx.compose.material.FloatingActionButton.<anonymous>.<anonymous>.<anonymous> (FloatingActionButton.kt:100)");
                                                                    }
                                                                    Modifier.Companion companion = Modifier.INSTANCE;
                                                                    f = FloatingActionButtonKt.FabSize;
                                                                    f2 = FloatingActionButtonKt.FabSize;
                                                                    Modifier m912defaultMinSizeVpY3zN4 = SizeKt.m912defaultMinSizeVpY3zN4(companion, f, f2);
                                                                    Alignment center = Alignment.INSTANCE.getCenter();
                                                                    Function2<Composer, Integer, Unit> function24 = function23;
                                                                    composer5.startReplaceableGroup(733328855);
                                                                    ComposerKt.sourceInformation(composer5, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer5, 6);
                                                                    composer5.startReplaceableGroup(-1323940314);
                                                                    ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                                    CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m912defaultMinSizeVpY3zN4);
                                                                    if (!(composer5.getApplier() instanceof Applier)) {
                                                                        ComposablesKt.invalidApplier();
                                                                    }
                                                                    composer5.startReusableNode();
                                                                    if (composer5.getInserting()) {
                                                                        composer5.createNode(constructor);
                                                                    } else {
                                                                        composer5.useNode();
                                                                    }
                                                                    Composer m3593constructorimpl = Updater.m3593constructorimpl(composer5);
                                                                    Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                                    }
                                                                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                                    composer5.startReplaceableGroup(2058660585);
                                                                    ComposerKt.sourceInformationMarkerStart(composer5, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                                    ComposerKt.sourceInformationMarkerStart(composer5, 638020641, "C104@4913L9:FloatingActionButton.kt#jmzs0o");
                                                                    function24.invoke(composer5, 0);
                                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                                    composer5.endReplaceableGroup();
                                                                    composer5.endNode();
                                                                    composer5.endReplaceableGroup();
                                                                    composer5.endReplaceableGroup();
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                composer5.skipToGroupEnd();
                                                            }
                                                        }), composer4, 48);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer4.skipToGroupEnd();
                                                }
                                            }), composer3, ProvidedValue.$stable | 48);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }), composer2, (i11 & i3) | (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 7168) | (i3 & i5) | ((i3 << 18) & 234881024), 68);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                floatingActionButtonElevation2 = m1686elevationxZ9QkE;
                                modifier3 = modifier2;
                                shape3 = shape4;
                                j5 = j7;
                                j6 = j8;
                                mutableInteractionSource3 = mutableInteractionSource4;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                            }
                        }
                        m1686elevationxZ9QkE = floatingActionButtonElevation;
                        MutableInteractionSource mutableInteractionSource42 = mutableInteractionSource2;
                        long j72 = j3;
                        int i112 = i6;
                        Shape shape42 = shape2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composer2 = startRestartGroup;
                        long j82 = j4;
                        SurfaceKt.m1783SurfaceLPr_se0(function02, SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5716getButtono7Vup1c());
                            }
                        }, 1, null), false, shape42, j72, j82, null, m1686elevationxZ9QkE.elevation(mutableInteractionSource42, startRestartGroup, ((i3 >> 6) & 14) | ((i3 >> 15) & 112)).getValue().m6403unboximpl(), mutableInteractionSource42, ComposableLambdaKt.composableLambda(startRestartGroup, 1972871863, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$3
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
                                ComposerKt.sourceInformation(composer3, "C98@4556L392:FloatingActionButton.kt#jmzs0o");
                                if ((i12 & 11) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1972871863, i12, -1, "androidx.compose.material.FloatingActionButton.<anonymous> (FloatingActionButton.kt:98)");
                                    }
                                    ProvidedValue<Float> provides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m4065getAlphaimpl(j4)));
                                    final Function2<? super Composer, ? super Integer, Unit> function22 = function2;
                                    CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer3, 1867794295, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$3.1
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
                                            ComposerKt.sourceInformation(composer4, "C99@4673L10,99@4642L296:FloatingActionButton.kt#jmzs0o");
                                            if ((i13 & 11) != 2 || !composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1867794295, i13, -1, "androidx.compose.material.FloatingActionButton.<anonymous>.<anonymous> (FloatingActionButton.kt:99)");
                                                }
                                                TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                                final Function2<? super Composer, ? super Integer, Unit> function23 = function22;
                                                TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -1567914264, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt.FloatingActionButton.3.1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                        invoke(composer5, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer5, int i14) {
                                                        float f;
                                                        float f2;
                                                        ComposerKt.sourceInformation(composer5, "C100@4710L214:FloatingActionButton.kt#jmzs0o");
                                                        if ((i14 & 11) != 2 || !composer5.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-1567914264, i14, -1, "androidx.compose.material.FloatingActionButton.<anonymous>.<anonymous>.<anonymous> (FloatingActionButton.kt:100)");
                                                            }
                                                            Modifier.Companion companion = Modifier.INSTANCE;
                                                            f = FloatingActionButtonKt.FabSize;
                                                            f2 = FloatingActionButtonKt.FabSize;
                                                            Modifier m912defaultMinSizeVpY3zN4 = SizeKt.m912defaultMinSizeVpY3zN4(companion, f, f2);
                                                            Alignment center = Alignment.INSTANCE.getCenter();
                                                            Function2<Composer, Integer, Unit> function24 = function23;
                                                            composer5.startReplaceableGroup(733328855);
                                                            ComposerKt.sourceInformation(composer5, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer5, 6);
                                                            composer5.startReplaceableGroup(-1323940314);
                                                            ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                            CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m912defaultMinSizeVpY3zN4);
                                                            if (!(composer5.getApplier() instanceof Applier)) {
                                                                ComposablesKt.invalidApplier();
                                                            }
                                                            composer5.startReusableNode();
                                                            if (composer5.getInserting()) {
                                                                composer5.createNode(constructor);
                                                            } else {
                                                                composer5.useNode();
                                                            }
                                                            Composer m3593constructorimpl = Updater.m3593constructorimpl(composer5);
                                                            Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                            }
                                                            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                            composer5.startReplaceableGroup(2058660585);
                                                            ComposerKt.sourceInformationMarkerStart(composer5, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                            ComposerKt.sourceInformationMarkerStart(composer5, 638020641, "C104@4913L9:FloatingActionButton.kt#jmzs0o");
                                                            function24.invoke(composer5, 0);
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            composer5.endReplaceableGroup();
                                                            composer5.endNode();
                                                            composer5.endReplaceableGroup();
                                                            composer5.endReplaceableGroup();
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer5.skipToGroupEnd();
                                                    }
                                                }), composer4, 48);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer4.skipToGroupEnd();
                                        }
                                    }), composer3, ProvidedValue.$stable | 48);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }), composer2, (i112 & i3) | (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 7168) | (i3 & i5) | ((i3 << 18) & 234881024), 68);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        floatingActionButtonElevation2 = m1686elevationxZ9QkE;
                        modifier3 = modifier2;
                        shape3 = shape42;
                        j5 = j72;
                        j6 = j82;
                        mutableInteractionSource3 = mutableInteractionSource42;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        composer2 = startRestartGroup;
                        modifier3 = modifier2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape3 = shape2;
                        j6 = j4;
                        j5 = j3;
                        floatingActionButtonElevation2 = floatingActionButtonElevation;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$4
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
                                FloatingActionButtonKt.m1690FloatingActionButtonbogVsAg(function0, modifier3, mutableInteractionSource3, shape3, j5, j6, floatingActionButtonElevation2, function2, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= i7;
                if ((23967451 & i3) == 4793490) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i10 != 0) {
                }
                if (i4 != 0) {
                }
                if ((i2 & 8) != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if ((i2 & 64) != 0) {
                }
                m1686elevationxZ9QkE = floatingActionButtonElevation;
                MutableInteractionSource mutableInteractionSource422 = mutableInteractionSource2;
                long j722 = j3;
                int i1122 = i6;
                Shape shape422 = shape2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                long j822 = j4;
                SurfaceKt.m1783SurfaceLPr_se0(function02, SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5716getButtono7Vup1c());
                    }
                }, 1, null), false, shape422, j722, j822, null, m1686elevationxZ9QkE.elevation(mutableInteractionSource422, startRestartGroup, ((i3 >> 6) & 14) | ((i3 >> 15) & 112)).getValue().m6403unboximpl(), mutableInteractionSource422, ComposableLambdaKt.composableLambda(startRestartGroup, 1972871863, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$3
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
                        ComposerKt.sourceInformation(composer3, "C98@4556L392:FloatingActionButton.kt#jmzs0o");
                        if ((i12 & 11) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1972871863, i12, -1, "androidx.compose.material.FloatingActionButton.<anonymous> (FloatingActionButton.kt:98)");
                            }
                            ProvidedValue<Float> provides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m4065getAlphaimpl(j4)));
                            final Function2<? super Composer, ? super Integer, Unit> function22 = function2;
                            CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer3, 1867794295, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$3.1
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
                                    ComposerKt.sourceInformation(composer4, "C99@4673L10,99@4642L296:FloatingActionButton.kt#jmzs0o");
                                    if ((i13 & 11) != 2 || !composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1867794295, i13, -1, "androidx.compose.material.FloatingActionButton.<anonymous>.<anonymous> (FloatingActionButton.kt:99)");
                                        }
                                        TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                        final Function2<? super Composer, ? super Integer, Unit> function23 = function22;
                                        TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -1567914264, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt.FloatingActionButton.3.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                invoke(composer5, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer5, int i14) {
                                                float f;
                                                float f2;
                                                ComposerKt.sourceInformation(composer5, "C100@4710L214:FloatingActionButton.kt#jmzs0o");
                                                if ((i14 & 11) != 2 || !composer5.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1567914264, i14, -1, "androidx.compose.material.FloatingActionButton.<anonymous>.<anonymous>.<anonymous> (FloatingActionButton.kt:100)");
                                                    }
                                                    Modifier.Companion companion = Modifier.INSTANCE;
                                                    f = FloatingActionButtonKt.FabSize;
                                                    f2 = FloatingActionButtonKt.FabSize;
                                                    Modifier m912defaultMinSizeVpY3zN4 = SizeKt.m912defaultMinSizeVpY3zN4(companion, f, f2);
                                                    Alignment center = Alignment.INSTANCE.getCenter();
                                                    Function2<Composer, Integer, Unit> function24 = function23;
                                                    composer5.startReplaceableGroup(733328855);
                                                    ComposerKt.sourceInformation(composer5, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer5, 6);
                                                    composer5.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                    CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m912defaultMinSizeVpY3zN4);
                                                    if (!(composer5.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer5.startReusableNode();
                                                    if (composer5.getInserting()) {
                                                        composer5.createNode(constructor);
                                                    } else {
                                                        composer5.useNode();
                                                    }
                                                    Composer m3593constructorimpl = Updater.m3593constructorimpl(composer5);
                                                    Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                    }
                                                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                    composer5.startReplaceableGroup(2058660585);
                                                    ComposerKt.sourceInformationMarkerStart(composer5, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(composer5, 638020641, "C104@4913L9:FloatingActionButton.kt#jmzs0o");
                                                    function24.invoke(composer5, 0);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    composer5.endReplaceableGroup();
                                                    composer5.endNode();
                                                    composer5.endReplaceableGroup();
                                                    composer5.endReplaceableGroup();
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer5.skipToGroupEnd();
                                            }
                                        }), composer4, 48);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            }), composer3, ProvidedValue.$stable | 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), composer2, (i1122 & i3) | (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 7168) | (i3 & i5) | ((i3 << 18) & 234881024), 68);
                if (ComposerKt.isTraceInProgress()) {
                }
                floatingActionButtonElevation2 = m1686elevationxZ9QkE;
                modifier3 = modifier2;
                shape3 = shape422;
                j5 = j722;
                j6 = j822;
                mutableInteractionSource3 = mutableInteractionSource422;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i & 7168) == 0) {
            }
            if ((i & 57344) == 0) {
            }
            if ((i & 458752) == 0) {
            }
            if ((i & 3670016) == 0) {
            }
            if ((i2 & 128) == 0) {
            }
            i3 |= i7;
            if ((23967451 & i3) == 4793490) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i10 != 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 8) != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if ((i2 & 64) != 0) {
            }
            m1686elevationxZ9QkE = floatingActionButtonElevation;
            MutableInteractionSource mutableInteractionSource4222 = mutableInteractionSource2;
            long j7222 = j3;
            int i11222 = i6;
            Shape shape4222 = shape2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            long j8222 = j4;
            SurfaceKt.m1783SurfaceLPr_se0(function02, SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5716getButtono7Vup1c());
                }
            }, 1, null), false, shape4222, j7222, j8222, null, m1686elevationxZ9QkE.elevation(mutableInteractionSource4222, startRestartGroup, ((i3 >> 6) & 14) | ((i3 >> 15) & 112)).getValue().m6403unboximpl(), mutableInteractionSource4222, ComposableLambdaKt.composableLambda(startRestartGroup, 1972871863, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$3
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
                    ComposerKt.sourceInformation(composer3, "C98@4556L392:FloatingActionButton.kt#jmzs0o");
                    if ((i12 & 11) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1972871863, i12, -1, "androidx.compose.material.FloatingActionButton.<anonymous> (FloatingActionButton.kt:98)");
                        }
                        ProvidedValue<Float> provides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m4065getAlphaimpl(j4)));
                        final Function2<? super Composer, ? super Integer, Unit> function22 = function2;
                        CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer3, 1867794295, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$3.1
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
                                ComposerKt.sourceInformation(composer4, "C99@4673L10,99@4642L296:FloatingActionButton.kt#jmzs0o");
                                if ((i13 & 11) != 2 || !composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1867794295, i13, -1, "androidx.compose.material.FloatingActionButton.<anonymous>.<anonymous> (FloatingActionButton.kt:99)");
                                    }
                                    TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                    final Function2<? super Composer, ? super Integer, Unit> function23 = function22;
                                    TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -1567914264, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt.FloatingActionButton.3.1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                            invoke(composer5, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer5, int i14) {
                                            float f;
                                            float f2;
                                            ComposerKt.sourceInformation(composer5, "C100@4710L214:FloatingActionButton.kt#jmzs0o");
                                            if ((i14 & 11) != 2 || !composer5.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1567914264, i14, -1, "androidx.compose.material.FloatingActionButton.<anonymous>.<anonymous>.<anonymous> (FloatingActionButton.kt:100)");
                                                }
                                                Modifier.Companion companion = Modifier.INSTANCE;
                                                f = FloatingActionButtonKt.FabSize;
                                                f2 = FloatingActionButtonKt.FabSize;
                                                Modifier m912defaultMinSizeVpY3zN4 = SizeKt.m912defaultMinSizeVpY3zN4(companion, f, f2);
                                                Alignment center = Alignment.INSTANCE.getCenter();
                                                Function2<Composer, Integer, Unit> function24 = function23;
                                                composer5.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation(composer5, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer5, 6);
                                                composer5.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m912defaultMinSizeVpY3zN4);
                                                if (!(composer5.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer5.startReusableNode();
                                                if (composer5.getInserting()) {
                                                    composer5.createNode(constructor);
                                                } else {
                                                    composer5.useNode();
                                                }
                                                Composer m3593constructorimpl = Updater.m3593constructorimpl(composer5);
                                                Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                }
                                                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                composer5.startReplaceableGroup(2058660585);
                                                ComposerKt.sourceInformationMarkerStart(composer5, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer5, 638020641, "C104@4913L9:FloatingActionButton.kt#jmzs0o");
                                                function24.invoke(composer5, 0);
                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                composer5.endReplaceableGroup();
                                                composer5.endNode();
                                                composer5.endReplaceableGroup();
                                                composer5.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer5.skipToGroupEnd();
                                        }
                                    }), composer4, 48);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer4.skipToGroupEnd();
                            }
                        }), composer3, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), composer2, (i11222 & i3) | (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 7168) | (i3 & i5) | ((i3 << 18) & 234881024), 68);
            if (ComposerKt.isTraceInProgress()) {
            }
            floatingActionButtonElevation2 = m1686elevationxZ9QkE;
            modifier3 = modifier2;
            shape3 = shape4222;
            j5 = j7222;
            j6 = j8222;
            mutableInteractionSource3 = mutableInteractionSource4222;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i & 7168) == 0) {
        }
        if ((i & 57344) == 0) {
        }
        if ((i & 458752) == 0) {
        }
        if ((i & 3670016) == 0) {
        }
        if ((i2 & 128) == 0) {
        }
        i3 |= i7;
        if ((23967451 & i3) == 4793490) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i10 != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        m1686elevationxZ9QkE = floatingActionButtonElevation;
        MutableInteractionSource mutableInteractionSource42222 = mutableInteractionSource2;
        long j72222 = j3;
        int i112222 = i6;
        Shape shape42222 = shape2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        long j82222 = j4;
        SurfaceKt.m1783SurfaceLPr_se0(function02, SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5716getButtono7Vup1c());
            }
        }, 1, null), false, shape42222, j72222, j82222, null, m1686elevationxZ9QkE.elevation(mutableInteractionSource42222, startRestartGroup, ((i3 >> 6) & 14) | ((i3 >> 15) & 112)).getValue().m6403unboximpl(), mutableInteractionSource42222, ComposableLambdaKt.composableLambda(startRestartGroup, 1972871863, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$3
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
                ComposerKt.sourceInformation(composer3, "C98@4556L392:FloatingActionButton.kt#jmzs0o");
                if ((i12 & 11) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1972871863, i12, -1, "androidx.compose.material.FloatingActionButton.<anonymous> (FloatingActionButton.kt:98)");
                    }
                    ProvidedValue<Float> provides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m4065getAlphaimpl(j4)));
                    final Function2<? super Composer, ? super Integer, Unit> function22 = function2;
                    CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer3, 1867794295, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$FloatingActionButton$3.1
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
                            ComposerKt.sourceInformation(composer4, "C99@4673L10,99@4642L296:FloatingActionButton.kt#jmzs0o");
                            if ((i13 & 11) != 2 || !composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1867794295, i13, -1, "androidx.compose.material.FloatingActionButton.<anonymous>.<anonymous> (FloatingActionButton.kt:99)");
                                }
                                TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                final Function2<? super Composer, ? super Integer, Unit> function23 = function22;
                                TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -1567914264, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt.FloatingActionButton.3.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                        invoke(composer5, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer5, int i14) {
                                        float f;
                                        float f2;
                                        ComposerKt.sourceInformation(composer5, "C100@4710L214:FloatingActionButton.kt#jmzs0o");
                                        if ((i14 & 11) != 2 || !composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1567914264, i14, -1, "androidx.compose.material.FloatingActionButton.<anonymous>.<anonymous>.<anonymous> (FloatingActionButton.kt:100)");
                                            }
                                            Modifier.Companion companion = Modifier.INSTANCE;
                                            f = FloatingActionButtonKt.FabSize;
                                            f2 = FloatingActionButtonKt.FabSize;
                                            Modifier m912defaultMinSizeVpY3zN4 = SizeKt.m912defaultMinSizeVpY3zN4(companion, f, f2);
                                            Alignment center = Alignment.INSTANCE.getCenter();
                                            Function2<Composer, Integer, Unit> function24 = function23;
                                            composer5.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation(composer5, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer5, 6);
                                            composer5.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m912defaultMinSizeVpY3zN4);
                                            if (!(composer5.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer5.startReusableNode();
                                            if (composer5.getInserting()) {
                                                composer5.createNode(constructor);
                                            } else {
                                                composer5.useNode();
                                            }
                                            Composer m3593constructorimpl = Updater.m3593constructorimpl(composer5);
                                            Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                            composer5.startReplaceableGroup(2058660585);
                                            ComposerKt.sourceInformationMarkerStart(composer5, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer5, 638020641, "C104@4913L9:FloatingActionButton.kt#jmzs0o");
                                            function24.invoke(composer5, 0);
                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                            composer5.endReplaceableGroup();
                                            composer5.endNode();
                                            composer5.endReplaceableGroup();
                                            composer5.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer5.skipToGroupEnd();
                                    }
                                }), composer4, 48);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer4.skipToGroupEnd();
                        }
                    }), composer3, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }), composer2, (i112222 & i3) | (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 7168) | (i3 & i5) | ((i3 << 18) & 234881024), 68);
        if (ComposerKt.isTraceInProgress()) {
        }
        floatingActionButtonElevation2 = m1686elevationxZ9QkE;
        modifier3 = modifier2;
        shape3 = shape42222;
        j5 = j72222;
        j6 = j82222;
        mutableInteractionSource3 = mutableInteractionSource42222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01ba  */
    /* renamed from: ExtendedFloatingActionButton-wqdebIU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1689ExtendedFloatingActionButtonwqdebIU(final Function2<? super Composer, ? super Integer, Unit> function2, final Function0<Unit> function0, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, MutableInteractionSource mutableInteractionSource, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, Composer composer, final int i, final int i2) {
        int i3;
        Function0<Unit> function02;
        Modifier modifier2;
        int i4;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        int i5;
        Shape shape2;
        int i6;
        long j3;
        int i7;
        final FloatingActionButtonElevation floatingActionButtonElevation2;
        MutableInteractionSource mutableInteractionSource2;
        CornerBasedShape cornerBasedShape;
        long j4;
        long j5;
        Composer composer2;
        MutableInteractionSource mutableInteractionSource3;
        int i8;
        long j6;
        FloatingActionButtonElevation floatingActionButtonElevation3;
        int i9;
        int i10;
        Shape shape3;
        final Modifier modifier3;
        Composer composer3;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final MutableInteractionSource mutableInteractionSource4;
        final Shape shape4;
        final long j7;
        final long j8;
        ScopeUpdateScope endRestartGroup;
        int i11;
        int i12;
        Composer startRestartGroup = composer.startRestartGroup(-1555720195);
        ComposerKt.sourceInformation(startRestartGroup, "C(ExtendedFloatingActionButton)P(8,6,5,3,4,7,0:c#ui.graphics.Color,1:c#ui.graphics.Color)149@7154L39,150@7228L6,151@7316L6,152@7360L32,153@7470L11,155@7490L849:FloatingActionButton.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 112) == 0) {
                i3 |= startRestartGroup.changedInstance(function02) ? 32 : 16;
            }
        }
        int i13 = i2 & 4;
        if (i13 != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                function23 = function22;
                i3 |= startRestartGroup.changedInstance(function23) ? 2048 : 1024;
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 57344) == 0) {
                    i3 |= startRestartGroup.changed(mutableInteractionSource) ? 16384 : 8192;
                    if ((i & 458752) != 0) {
                        if ((i2 & 32) == 0) {
                            shape2 = shape;
                            if (startRestartGroup.changed(shape2)) {
                                i12 = 131072;
                                i3 |= i12;
                            }
                        } else {
                            shape2 = shape;
                        }
                        i12 = 65536;
                        i3 |= i12;
                    } else {
                        shape2 = shape;
                    }
                    if ((i & 3670016) != 0) {
                        i6 = 57344;
                        j3 = j;
                        i3 |= ((i2 & 64) == 0 && startRestartGroup.changed(j3)) ? 1048576 : 524288;
                    } else {
                        i6 = 57344;
                        j3 = j;
                    }
                    if ((i & 29360128) != 0) {
                        i7 = 458752;
                        i3 |= ((i2 & 128) == 0 && startRestartGroup.changed(j2)) ? 8388608 : 4194304;
                    } else {
                        i7 = 458752;
                    }
                    if ((i & 234881024) != 0) {
                        if ((i2 & 256) == 0) {
                            floatingActionButtonElevation2 = floatingActionButtonElevation;
                            if (startRestartGroup.changed(floatingActionButtonElevation2)) {
                                i11 = 67108864;
                                i3 |= i11;
                            }
                        } else {
                            floatingActionButtonElevation2 = floatingActionButtonElevation;
                        }
                        i11 = 33554432;
                        i3 |= i11;
                    } else {
                        floatingActionButtonElevation2 = floatingActionButtonElevation;
                    }
                    if ((i3 & 191739611) == 38347922 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            if (i13 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function23 = null;
                            }
                            if (i5 == 0) {
                                startRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                                Object rememberedValue = startRestartGroup.rememberedValue();
                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                startRestartGroup.endReplaceableGroup();
                                mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            if ((i2 & 32) == 0) {
                                cornerBasedShape = MaterialTheme.INSTANCE.getShapes(startRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -458753;
                            } else {
                                cornerBasedShape = shape2;
                            }
                            if ((i2 & 64) == 0) {
                                j4 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m1605getSecondary0d7_KjU();
                                i3 &= -3670017;
                            } else {
                                j4 = j3;
                            }
                            if ((i2 & 128) == 0) {
                                j5 = ColorsKt.m1621contentColorForek8zF_U(j4, startRestartGroup, (i3 >> 18) & 14);
                                i3 &= -29360129;
                            } else {
                                j5 = j2;
                            }
                            if ((i2 & 256) == 0) {
                                composer2 = startRestartGroup;
                                i3 &= -234881025;
                                mutableInteractionSource3 = mutableInteractionSource2;
                                i8 = 3670016;
                                floatingActionButtonElevation3 = FloatingActionButtonDefaults.INSTANCE.m1686elevationxZ9QkE(0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 24576, 15);
                                j6 = j4;
                            } else {
                                composer2 = startRestartGroup;
                                mutableInteractionSource3 = mutableInteractionSource2;
                                i8 = 3670016;
                                j6 = j4;
                                floatingActionButtonElevation3 = floatingActionButtonElevation2;
                            }
                            i9 = i7;
                            i10 = -1555720195;
                            shape3 = cornerBasedShape;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                            }
                            if ((i2 & 128) != 0) {
                                i3 &= -29360129;
                            }
                            if ((i2 & 256) != 0) {
                                i3 &= -234881025;
                            }
                            j5 = j2;
                            composer2 = startRestartGroup;
                            j6 = j3;
                            floatingActionButtonElevation3 = floatingActionButtonElevation2;
                            i8 = 3670016;
                            i9 = i7;
                            i10 = -1555720195;
                            mutableInteractionSource3 = mutableInteractionSource;
                            shape3 = shape2;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i10, i3, -1, "androidx.compose.material.ExtendedFloatingActionButton (FloatingActionButton.kt:154)");
                        }
                        float f = ExtendedFabSize;
                        int i14 = i3 >> 6;
                        m1690FloatingActionButtonbogVsAg(function02, SizeKt.m932sizeInqDBjuR0$default(modifier2, f, f, 0.0f, 0.0f, 12, null), mutableInteractionSource3, shape3, j6, j5, floatingActionButtonElevation3, ComposableLambdaKt.composableLambda(composer2, 1418981691, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$2
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

                            public final void invoke(Composer composer4, int i15) {
                                float f2;
                                float f3;
                                ComposerKt.sourceInformation(composer4, "C168@7958L375:FloatingActionButton.kt#jmzs0o");
                                if ((i15 & 11) != 2 || !composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1418981691, i15, -1, "androidx.compose.material.ExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:167)");
                                    }
                                    float f4 = function23 == null ? FloatingActionButtonKt.ExtendedFabTextPadding : FloatingActionButtonKt.ExtendedFabIconPadding;
                                    Modifier.Companion companion = Modifier.INSTANCE;
                                    f2 = FloatingActionButtonKt.ExtendedFabTextPadding;
                                    Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(companion, f4, 0.0f, f2, 0.0f, 10, null);
                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                    Function2<Composer, Integer, Unit> function25 = function23;
                                    Function2<Composer, Integer, Unit> function26 = function2;
                                    composer4.startReplaceableGroup(693286680);
                                    ComposerKt.sourceInformation(composer4, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer4, 48);
                                    composer4.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
                                    if (!(composer4.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer4.startReusableNode();
                                    if (composer4.getInserting()) {
                                        composer4.createNode(constructor);
                                    } else {
                                        composer4.useNode();
                                    }
                                    Composer m3593constructorimpl = Updater.m3593constructorimpl(composer4);
                                    Updater.m3600setimpl(m3593constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer4)), composer4, 0);
                                    composer4.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer4, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer4, -1435223698, "C179@8317L6:FloatingActionButton.kt#jmzs0o");
                                    composer4.startReplaceableGroup(-1435223698);
                                    ComposerKt.sourceInformation(composer4, "176@8221L6,177@8244L46");
                                    if (function25 != null) {
                                        function25.invoke(composer4, 0);
                                        Modifier.Companion companion2 = Modifier.INSTANCE;
                                        f3 = FloatingActionButtonKt.ExtendedFabIconPadding;
                                        SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion2, f3), composer4, 6);
                                    }
                                    composer4.endReplaceableGroup();
                                    function26.invoke(composer4, 0);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    composer4.endReplaceableGroup();
                                    composer4.endNode();
                                    composer4.endReplaceableGroup();
                                    composer4.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer4.skipToGroupEnd();
                            }
                        }), composer2, (i9 & i14) | (i14 & 896) | ((i3 >> 3) & 14) | 12582912 | (i14 & 7168) | (i14 & i6) | (i8 & i14), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        composer3 = composer2;
                        function24 = function23;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        shape4 = shape3;
                        j7 = j6;
                        j8 = j5;
                        floatingActionButtonElevation2 = floatingActionButtonElevation3;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        composer3 = startRestartGroup;
                        modifier3 = modifier2;
                        function24 = function23;
                        j7 = j3;
                        shape4 = shape2;
                        mutableInteractionSource4 = mutableInteractionSource;
                        j8 = j2;
                    }
                    endRestartGroup = composer3.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$3
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

                            public final void invoke(Composer composer4, int i15) {
                                FloatingActionButtonKt.m1689ExtendedFloatingActionButtonwqdebIU(function2, function0, modifier3, function24, mutableInteractionSource4, shape4, j7, j8, floatingActionButtonElevation2, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                if ((i & 458752) != 0) {
                }
                if ((i & 3670016) != 0) {
                }
                if ((i & 29360128) != 0) {
                }
                if ((i & 234881024) != 0) {
                }
                if ((i3 & 191739611) == 38347922) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i13 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 == 0) {
                }
                if ((i2 & 32) == 0) {
                }
                if ((i2 & 64) == 0) {
                }
                if ((i2 & 128) == 0) {
                }
                if ((i2 & 256) == 0) {
                }
                i9 = i7;
                i10 = -1555720195;
                shape3 = cornerBasedShape;
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                float f2 = ExtendedFabSize;
                int i142 = i3 >> 6;
                m1690FloatingActionButtonbogVsAg(function02, SizeKt.m932sizeInqDBjuR0$default(modifier2, f2, f2, 0.0f, 0.0f, 12, null), mutableInteractionSource3, shape3, j6, j5, floatingActionButtonElevation3, ComposableLambdaKt.composableLambda(composer2, 1418981691, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$2
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

                    public final void invoke(Composer composer4, int i15) {
                        float f22;
                        float f3;
                        ComposerKt.sourceInformation(composer4, "C168@7958L375:FloatingActionButton.kt#jmzs0o");
                        if ((i15 & 11) != 2 || !composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1418981691, i15, -1, "androidx.compose.material.ExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:167)");
                            }
                            float f4 = function23 == null ? FloatingActionButtonKt.ExtendedFabTextPadding : FloatingActionButtonKt.ExtendedFabIconPadding;
                            Modifier.Companion companion = Modifier.INSTANCE;
                            f22 = FloatingActionButtonKt.ExtendedFabTextPadding;
                            Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(companion, f4, 0.0f, f22, 0.0f, 10, null);
                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                            Function2<Composer, Integer, Unit> function25 = function23;
                            Function2<Composer, Integer, Unit> function26 = function2;
                            composer4.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composer4, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer4, 48);
                            composer4.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
                            if (!(composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer4.startReusableNode();
                            if (composer4.getInserting()) {
                                composer4.createNode(constructor);
                            } else {
                                composer4.useNode();
                            }
                            Composer m3593constructorimpl = Updater.m3593constructorimpl(composer4);
                            Updater.m3600setimpl(m3593constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer4)), composer4, 0);
                            composer4.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer4, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer4, -1435223698, "C179@8317L6:FloatingActionButton.kt#jmzs0o");
                            composer4.startReplaceableGroup(-1435223698);
                            ComposerKt.sourceInformation(composer4, "176@8221L6,177@8244L46");
                            if (function25 != null) {
                                function25.invoke(composer4, 0);
                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                f3 = FloatingActionButtonKt.ExtendedFabIconPadding;
                                SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion2, f3), composer4, 6);
                            }
                            composer4.endReplaceableGroup();
                            function26.invoke(composer4, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            composer4.endReplaceableGroup();
                            composer4.endNode();
                            composer4.endReplaceableGroup();
                            composer4.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer4.skipToGroupEnd();
                    }
                }), composer2, (i9 & i142) | (i142 & 896) | ((i3 >> 3) & 14) | 12582912 | (i142 & 7168) | (i142 & i6) | (i8 & i142), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier2;
                composer3 = composer2;
                function24 = function23;
                mutableInteractionSource4 = mutableInteractionSource3;
                shape4 = shape3;
                j7 = j6;
                j8 = j5;
                floatingActionButtonElevation2 = floatingActionButtonElevation3;
                endRestartGroup = composer3.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            function23 = function22;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            if ((i & 458752) != 0) {
            }
            if ((i & 3670016) != 0) {
            }
            if ((i & 29360128) != 0) {
            }
            if ((i & 234881024) != 0) {
            }
            if ((i3 & 191739611) == 38347922) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i13 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 == 0) {
            }
            if ((i2 & 32) == 0) {
            }
            if ((i2 & 64) == 0) {
            }
            if ((i2 & 128) == 0) {
            }
            if ((i2 & 256) == 0) {
            }
            i9 = i7;
            i10 = -1555720195;
            shape3 = cornerBasedShape;
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            float f22 = ExtendedFabSize;
            int i1422 = i3 >> 6;
            m1690FloatingActionButtonbogVsAg(function02, SizeKt.m932sizeInqDBjuR0$default(modifier2, f22, f22, 0.0f, 0.0f, 12, null), mutableInteractionSource3, shape3, j6, j5, floatingActionButtonElevation3, ComposableLambdaKt.composableLambda(composer2, 1418981691, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$2
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

                public final void invoke(Composer composer4, int i15) {
                    float f222;
                    float f3;
                    ComposerKt.sourceInformation(composer4, "C168@7958L375:FloatingActionButton.kt#jmzs0o");
                    if ((i15 & 11) != 2 || !composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1418981691, i15, -1, "androidx.compose.material.ExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:167)");
                        }
                        float f4 = function23 == null ? FloatingActionButtonKt.ExtendedFabTextPadding : FloatingActionButtonKt.ExtendedFabIconPadding;
                        Modifier.Companion companion = Modifier.INSTANCE;
                        f222 = FloatingActionButtonKt.ExtendedFabTextPadding;
                        Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(companion, f4, 0.0f, f222, 0.0f, 10, null);
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        Function2<Composer, Integer, Unit> function25 = function23;
                        Function2<Composer, Integer, Unit> function26 = function2;
                        composer4.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composer4, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer4, 48);
                        composer4.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
                        if (!(composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer4.startReusableNode();
                        if (composer4.getInserting()) {
                            composer4.createNode(constructor);
                        } else {
                            composer4.useNode();
                        }
                        Composer m3593constructorimpl = Updater.m3593constructorimpl(composer4);
                        Updater.m3600setimpl(m3593constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer4)), composer4, 0);
                        composer4.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer4, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer4, -1435223698, "C179@8317L6:FloatingActionButton.kt#jmzs0o");
                        composer4.startReplaceableGroup(-1435223698);
                        ComposerKt.sourceInformation(composer4, "176@8221L6,177@8244L46");
                        if (function25 != null) {
                            function25.invoke(composer4, 0);
                            Modifier.Companion companion2 = Modifier.INSTANCE;
                            f3 = FloatingActionButtonKt.ExtendedFabIconPadding;
                            SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion2, f3), composer4, 6);
                        }
                        composer4.endReplaceableGroup();
                        function26.invoke(composer4, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        composer4.endReplaceableGroup();
                        composer4.endNode();
                        composer4.endReplaceableGroup();
                        composer4.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer4.skipToGroupEnd();
                }
            }), composer2, (i9 & i1422) | (i1422 & 896) | ((i3 >> 3) & 14) | 12582912 | (i1422 & 7168) | (i1422 & i6) | (i8 & i1422), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier2;
            composer3 = composer2;
            function24 = function23;
            mutableInteractionSource4 = mutableInteractionSource3;
            shape4 = shape3;
            j7 = j6;
            j8 = j5;
            floatingActionButtonElevation2 = floatingActionButtonElevation3;
            endRestartGroup = composer3.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        function23 = function22;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        if ((i & 458752) != 0) {
        }
        if ((i & 3670016) != 0) {
        }
        if ((i & 29360128) != 0) {
        }
        if ((i & 234881024) != 0) {
        }
        if ((i3 & 191739611) == 38347922) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i13 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 == 0) {
        }
        if ((i2 & 32) == 0) {
        }
        if ((i2 & 64) == 0) {
        }
        if ((i2 & 128) == 0) {
        }
        if ((i2 & 256) == 0) {
        }
        i9 = i7;
        i10 = -1555720195;
        shape3 = cornerBasedShape;
        composer2.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        float f222 = ExtendedFabSize;
        int i14222 = i3 >> 6;
        m1690FloatingActionButtonbogVsAg(function02, SizeKt.m932sizeInqDBjuR0$default(modifier2, f222, f222, 0.0f, 0.0f, 12, null), mutableInteractionSource3, shape3, j6, j5, floatingActionButtonElevation3, ComposableLambdaKt.composableLambda(composer2, 1418981691, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.FloatingActionButtonKt$ExtendedFloatingActionButton$2
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

            public final void invoke(Composer composer4, int i15) {
                float f2222;
                float f3;
                ComposerKt.sourceInformation(composer4, "C168@7958L375:FloatingActionButton.kt#jmzs0o");
                if ((i15 & 11) != 2 || !composer4.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1418981691, i15, -1, "androidx.compose.material.ExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:167)");
                    }
                    float f4 = function23 == null ? FloatingActionButtonKt.ExtendedFabTextPadding : FloatingActionButtonKt.ExtendedFabIconPadding;
                    Modifier.Companion companion = Modifier.INSTANCE;
                    f2222 = FloatingActionButtonKt.ExtendedFabTextPadding;
                    Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(companion, f4, 0.0f, f2222, 0.0f, 10, null);
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    Function2<Composer, Integer, Unit> function25 = function23;
                    Function2<Composer, Integer, Unit> function26 = function2;
                    composer4.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer4, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer4, 48);
                    composer4.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
                    if (!(composer4.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer4.startReusableNode();
                    if (composer4.getInserting()) {
                        composer4.createNode(constructor);
                    } else {
                        composer4.useNode();
                    }
                    Composer m3593constructorimpl = Updater.m3593constructorimpl(composer4);
                    Updater.m3600setimpl(m3593constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer4)), composer4, 0);
                    composer4.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer4, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer4, -1435223698, "C179@8317L6:FloatingActionButton.kt#jmzs0o");
                    composer4.startReplaceableGroup(-1435223698);
                    ComposerKt.sourceInformation(composer4, "176@8221L6,177@8244L46");
                    if (function25 != null) {
                        function25.invoke(composer4, 0);
                        Modifier.Companion companion2 = Modifier.INSTANCE;
                        f3 = FloatingActionButtonKt.ExtendedFabIconPadding;
                        SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion2, f3), composer4, 6);
                    }
                    composer4.endReplaceableGroup();
                    function26.invoke(composer4, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    composer4.endReplaceableGroup();
                    composer4.endNode();
                    composer4.endReplaceableGroup();
                    composer4.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer4.skipToGroupEnd();
            }
        }), composer2, (i9 & i14222) | (i14222 & 896) | ((i3 >> 3) & 14) | 12582912 | (i14222 & 7168) | (i14222 & i6) | (i8 & i14222), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier2;
        composer3 = composer2;
        function24 = function23;
        mutableInteractionSource4 = mutableInteractionSource3;
        shape4 = shape3;
        j7 = j6;
        j8 = j5;
        floatingActionButtonElevation2 = floatingActionButtonElevation3;
        endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
