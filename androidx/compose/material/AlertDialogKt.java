package androidx.compose.material;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
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
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: AlertDialog.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a{\u0010\b\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0013H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a5\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\fH\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a;\u0010\u001e\u001a\u00020\t*\u00020\u001f2\u0013\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0013\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\fH\u0001¢\u0006\u0002\u0010 \"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006!"}, d2 = {"TextBaselineDistanceFromTitle", "Landroidx/compose/ui/unit/TextUnit;", "J", "TextBaselineDistanceFromTop", "TextPadding", "Landroidx/compose/ui/Modifier;", "TitleBaselineDistanceFromTop", "TitlePadding", "AlertDialogContent", "", "buttons", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "AlertDialogContent-WMdw5o4", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/runtime/Composer;II)V", "AlertDialogFlowRow", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacing", "content", "AlertDialogFlowRow-ixp7dh8", "(FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "AlertDialogBaselineLayout", "Landroidx/compose/foundation/layout/ColumnScope;", "(Landroidx/compose/foundation/layout/ColumnScope;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AlertDialogKt {
    private static final Modifier TextPadding;
    private static final Modifier TitlePadding;
    private static final long TitleBaselineDistanceFromTop = TextUnitKt.getSp(40);
    private static final long TextBaselineDistanceFromTitle = TextUnitKt.getSp(36);
    private static final long TextBaselineDistanceFromTop = TextUnitKt.getSp(38);

    /* JADX WARN: Code restructure failed: missing block: B:62:0x011e, code lost:
    
        if ((r34 & 64) != 0) goto L99;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0098  */
    /* renamed from: AlertDialogContent-WMdw5o4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1519AlertDialogContentWMdw5o4(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, long j, long j2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        int i5;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        Shape shape2;
        long j3;
        long j4;
        int i6;
        int i7;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final Modifier modifier3;
        final Shape shape3;
        final long j5;
        final long j6;
        ScopeUpdateScope endRestartGroup;
        int i8;
        int i9;
        int i10;
        Composer startRestartGroup = composer.startRestartGroup(-453679601);
        ComposerKt.sourceInformation(startRestartGroup, "C(AlertDialogContent)P(1,3,6,5,4,0:c#ui.graphics.Color,2:c#ui.graphics.Color)50@1988L6,51@2046L6,52@2088L32,54@2130L1047:AlertDialog.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i11 = i2 & 2;
        if (i11 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 896) == 0) {
                function24 = function22;
                i3 |= startRestartGroup.changedInstance(function24) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 7168) == 0) {
                    function25 = function23;
                    i3 |= startRestartGroup.changedInstance(function25) ? 2048 : 1024;
                    if ((57344 & i) != 0) {
                        if ((i2 & 16) == 0) {
                            shape2 = shape;
                            if (startRestartGroup.changed(shape2)) {
                                i10 = 16384;
                                i3 |= i10;
                            }
                        } else {
                            shape2 = shape;
                        }
                        i10 = 8192;
                        i3 |= i10;
                    } else {
                        shape2 = shape;
                    }
                    if ((458752 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            j3 = j;
                            if (startRestartGroup.changed(j3)) {
                                i9 = 131072;
                                i3 |= i9;
                            }
                        } else {
                            j3 = j;
                        }
                        i9 = 65536;
                        i3 |= i9;
                    } else {
                        j3 = j;
                    }
                    if ((3670016 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            j4 = j2;
                            if (startRestartGroup.changed(j4)) {
                                i8 = 1048576;
                                i3 |= i8;
                            }
                        } else {
                            j4 = j2;
                        }
                        i8 = 524288;
                        i3 |= i8;
                    } else {
                        j4 = j2;
                    }
                    int i12 = i3;
                    if ((i3 & 2995931) == 599186 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) == 0 && !startRestartGroup.getDefaultsInvalid()) {
                            startRestartGroup.skipToGroupEnd();
                            i7 = (i2 & 16) != 0 ? i12 & (-57345) : i12;
                            if ((i2 & 32) != 0) {
                                i7 &= -458753;
                            }
                        } else {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function24 = null;
                            }
                            if (i5 != 0) {
                                function25 = null;
                            }
                            if ((i2 & 16) == 0) {
                                i6 = i12 & (-57345);
                                shape2 = MaterialTheme.INSTANCE.getShapes(startRestartGroup, 6).getMedium();
                            } else {
                                i6 = i12;
                            }
                            if ((i2 & 32) == 0) {
                                j3 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m1607getSurface0d7_KjU();
                                i7 = i6 & (-458753);
                            } else {
                                i7 = i6;
                            }
                            if ((i2 & 64) != 0) {
                                j4 = ColorsKt.m1621contentColorForek8zF_U(j3, startRestartGroup, (i7 >> 15) & 14);
                                i7 &= -3670017;
                            }
                            long j7 = j4;
                            long j8 = j3;
                            Shape shape4 = shape2;
                            Modifier modifier4 = modifier2;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-453679601, i7, -1, "androidx.compose.material.AlertDialogContent (AlertDialog.kt:53)");
                            }
                            int i13 = ((i7 >> 3) & 14) | 1572864;
                            int i14 = i7 >> 9;
                            composer2 = startRestartGroup;
                            SurfaceKt.m1782SurfaceFjzlyU(modifier4, shape4, j8, j7, null, 0.0f, ComposableLambdaKt.composableLambda(startRestartGroup, 629950291, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1
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
                                    ComposerKt.sourceInformation(composer3, "C60@2276L895:AlertDialog.kt#jmzs0o");
                                    if ((i15 & 11) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(629950291, i15, -1, "androidx.compose.material.AlertDialogContent.<anonymous> (AlertDialog.kt:60)");
                                        }
                                        final Function2<Composer, Integer, Unit> function28 = function24;
                                        final Function2<Composer, Integer, Unit> function29 = function25;
                                        Function2<Composer, Integer, Unit> function210 = function2;
                                        composer3.startReplaceableGroup(-483455358);
                                        ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                        Modifier.Companion companion = Modifier.INSTANCE;
                                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                        composer3.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
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
                                        ComposerKt.sourceInformationMarkerStart(composer3, -80835680, "C61@2297L842,81@3152L9:AlertDialog.kt#jmzs0o");
                                        AlertDialogKt.AlertDialogBaselineLayout(columnScopeInstance, function28 != null ? ComposableLambdaKt.composableLambda(composer3, 620104160, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1
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

                                            public final void invoke(Composer composer4, int i16) {
                                                ComposerKt.sourceInformation(composer4, "C64@2484L4,64@2419L240:AlertDialog.kt#jmzs0o");
                                                if ((i16 & 11) != 2 || !composer4.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(620104160, i16, -1, "androidx.compose.material.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:64)");
                                                    }
                                                    ProvidedValue<Float> provides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer4, 6)));
                                                    final Function2<Composer, Integer, Unit> function211 = function28;
                                                    CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer4, 770166432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1.1
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

                                                        public final void invoke(Composer composer5, int i17) {
                                                            ComposerKt.sourceInformation(composer5, "C65@2550L10,66@2599L34:AlertDialog.kt#jmzs0o");
                                                            if ((i17 & 11) != 2 || !composer5.getSkipping()) {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(770166432, i17, -1, "androidx.compose.material.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:65)");
                                                                }
                                                                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer5, 6).getSubtitle1(), function211, composer5, 0);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            composer5.skipToGroupEnd();
                                                        }
                                                    }), composer4, ProvidedValue.$stable | 48);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer4.skipToGroupEnd();
                                            }
                                        }) : null, function29 != null ? ComposableLambdaKt.composableLambda(composer3, 1965858367, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1
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

                                            public final void invoke(Composer composer4, int i16) {
                                                ComposerKt.sourceInformation(composer4, "C73@2888L6,72@2794L291:AlertDialog.kt#jmzs0o");
                                                if ((i16 & 11) != 2 || !composer4.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1965858367, i16, -1, "androidx.compose.material.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:72)");
                                                    }
                                                    ProvidedValue<Float> provides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer4, 6)));
                                                    final Function2<Composer, Integer, Unit> function211 = function29;
                                                    CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer4, 2115920639, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1.1
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

                                                        public final void invoke(Composer composer5, int i17) {
                                                            ComposerKt.sourceInformation(composer5, "C75@2981L10,76@3026L33:AlertDialog.kt#jmzs0o");
                                                            if ((i17 & 11) != 2 || !composer5.getSkipping()) {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(2115920639, i17, -1, "androidx.compose.material.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:75)");
                                                                }
                                                                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer5, 6).getBody2(), function211, composer5, 0);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            composer5.skipToGroupEnd();
                                                        }
                                                    }), composer4, ProvidedValue.$stable | 48);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer4.skipToGroupEnd();
                                            }
                                        }) : null, composer3, 6);
                                        function210.invoke(composer3, 0);
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
                            }), composer2, i13 | (i14 & 112) | (i14 & 896) | (i14 & 7168), 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function26 = function24;
                            function27 = function25;
                            modifier3 = modifier4;
                            shape3 = shape4;
                            j5 = j8;
                            j6 = j7;
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        composer2 = startRestartGroup;
                        modifier3 = modifier2;
                        function26 = function24;
                        function27 = function25;
                        shape3 = shape2;
                        j5 = j3;
                        j6 = j4;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$2
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
                                AlertDialogKt.m1519AlertDialogContentWMdw5o4(function2, modifier3, function26, function27, shape3, j5, j6, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                function25 = function23;
                if ((57344 & i) != 0) {
                }
                if ((458752 & i) != 0) {
                }
                if ((3670016 & i) != 0) {
                }
                int i122 = i3;
                if ((i3 & 2995931) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                }
                if (i11 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if ((i2 & 16) == 0) {
                }
                if ((i2 & 32) == 0) {
                }
                if ((i2 & 64) != 0) {
                }
                long j72 = j4;
                long j82 = j3;
                Shape shape42 = shape2;
                Modifier modifier42 = modifier2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i132 = ((i7 >> 3) & 14) | 1572864;
                int i142 = i7 >> 9;
                composer2 = startRestartGroup;
                SurfaceKt.m1782SurfaceFjzlyU(modifier42, shape42, j82, j72, null, 0.0f, ComposableLambdaKt.composableLambda(startRestartGroup, 629950291, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1
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
                        ComposerKt.sourceInformation(composer3, "C60@2276L895:AlertDialog.kt#jmzs0o");
                        if ((i15 & 11) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(629950291, i15, -1, "androidx.compose.material.AlertDialogContent.<anonymous> (AlertDialog.kt:60)");
                            }
                            final Function2<? super Composer, ? super Integer, Unit> function28 = function24;
                            final Function2<? super Composer, ? super Integer, Unit> function29 = function25;
                            Function2<Composer, Integer, Unit> function210 = function2;
                            composer3.startReplaceableGroup(-483455358);
                            ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                            Modifier.Companion companion = Modifier.INSTANCE;
                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                            composer3.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
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
                            ComposerKt.sourceInformationMarkerStart(composer3, -80835680, "C61@2297L842,81@3152L9:AlertDialog.kt#jmzs0o");
                            AlertDialogKt.AlertDialogBaselineLayout(columnScopeInstance, function28 != null ? ComposableLambdaKt.composableLambda(composer3, 620104160, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1
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

                                public final void invoke(Composer composer4, int i16) {
                                    ComposerKt.sourceInformation(composer4, "C64@2484L4,64@2419L240:AlertDialog.kt#jmzs0o");
                                    if ((i16 & 11) != 2 || !composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(620104160, i16, -1, "androidx.compose.material.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:64)");
                                        }
                                        ProvidedValue<Float> provides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer4, 6)));
                                        final Function2<? super Composer, ? super Integer, Unit> function211 = function28;
                                        CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer4, 770166432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1.1
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

                                            public final void invoke(Composer composer5, int i17) {
                                                ComposerKt.sourceInformation(composer5, "C65@2550L10,66@2599L34:AlertDialog.kt#jmzs0o");
                                                if ((i17 & 11) != 2 || !composer5.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(770166432, i17, -1, "androidx.compose.material.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:65)");
                                                    }
                                                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer5, 6).getSubtitle1(), function211, composer5, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer5.skipToGroupEnd();
                                            }
                                        }), composer4, ProvidedValue.$stable | 48);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            }) : null, function29 != null ? ComposableLambdaKt.composableLambda(composer3, 1965858367, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1
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

                                public final void invoke(Composer composer4, int i16) {
                                    ComposerKt.sourceInformation(composer4, "C73@2888L6,72@2794L291:AlertDialog.kt#jmzs0o");
                                    if ((i16 & 11) != 2 || !composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1965858367, i16, -1, "androidx.compose.material.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:72)");
                                        }
                                        ProvidedValue<Float> provides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer4, 6)));
                                        final Function2<? super Composer, ? super Integer, Unit> function211 = function29;
                                        CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer4, 2115920639, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1.1
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

                                            public final void invoke(Composer composer5, int i17) {
                                                ComposerKt.sourceInformation(composer5, "C75@2981L10,76@3026L33:AlertDialog.kt#jmzs0o");
                                                if ((i17 & 11) != 2 || !composer5.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(2115920639, i17, -1, "androidx.compose.material.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:75)");
                                                    }
                                                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer5, 6).getBody2(), function211, composer5, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer5.skipToGroupEnd();
                                            }
                                        }), composer4, ProvidedValue.$stable | 48);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            }) : null, composer3, 6);
                            function210.invoke(composer3, 0);
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
                }), composer2, i132 | (i142 & 112) | (i142 & 896) | (i142 & 7168), 48);
                if (ComposerKt.isTraceInProgress()) {
                }
                function26 = function24;
                function27 = function25;
                modifier3 = modifier42;
                shape3 = shape42;
                j5 = j82;
                j6 = j72;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            function24 = function22;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            function25 = function23;
            if ((57344 & i) != 0) {
            }
            if ((458752 & i) != 0) {
            }
            if ((3670016 & i) != 0) {
            }
            int i1222 = i3;
            if ((i3 & 2995931) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) == 0) {
            }
            if (i11 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 16) == 0) {
            }
            if ((i2 & 32) == 0) {
            }
            if ((i2 & 64) != 0) {
            }
            long j722 = j4;
            long j822 = j3;
            Shape shape422 = shape2;
            Modifier modifier422 = modifier2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i1322 = ((i7 >> 3) & 14) | 1572864;
            int i1422 = i7 >> 9;
            composer2 = startRestartGroup;
            SurfaceKt.m1782SurfaceFjzlyU(modifier422, shape422, j822, j722, null, 0.0f, ComposableLambdaKt.composableLambda(startRestartGroup, 629950291, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1
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
                    ComposerKt.sourceInformation(composer3, "C60@2276L895:AlertDialog.kt#jmzs0o");
                    if ((i15 & 11) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(629950291, i15, -1, "androidx.compose.material.AlertDialogContent.<anonymous> (AlertDialog.kt:60)");
                        }
                        final Function2<? super Composer, ? super Integer, Unit> function28 = function24;
                        final Function2<? super Composer, ? super Integer, Unit> function29 = function25;
                        Function2<Composer, Integer, Unit> function210 = function2;
                        composer3.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                        Modifier.Companion companion = Modifier.INSTANCE;
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
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
                        ComposerKt.sourceInformationMarkerStart(composer3, -80835680, "C61@2297L842,81@3152L9:AlertDialog.kt#jmzs0o");
                        AlertDialogKt.AlertDialogBaselineLayout(columnScopeInstance, function28 != null ? ComposableLambdaKt.composableLambda(composer3, 620104160, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1
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

                            public final void invoke(Composer composer4, int i16) {
                                ComposerKt.sourceInformation(composer4, "C64@2484L4,64@2419L240:AlertDialog.kt#jmzs0o");
                                if ((i16 & 11) != 2 || !composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(620104160, i16, -1, "androidx.compose.material.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:64)");
                                    }
                                    ProvidedValue<Float> provides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer4, 6)));
                                    final Function2<? super Composer, ? super Integer, Unit> function211 = function28;
                                    CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer4, 770166432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1.1
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

                                        public final void invoke(Composer composer5, int i17) {
                                            ComposerKt.sourceInformation(composer5, "C65@2550L10,66@2599L34:AlertDialog.kt#jmzs0o");
                                            if ((i17 & 11) != 2 || !composer5.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(770166432, i17, -1, "androidx.compose.material.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:65)");
                                                }
                                                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer5, 6).getSubtitle1(), function211, composer5, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer5.skipToGroupEnd();
                                        }
                                    }), composer4, ProvidedValue.$stable | 48);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer4.skipToGroupEnd();
                            }
                        }) : null, function29 != null ? ComposableLambdaKt.composableLambda(composer3, 1965858367, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1
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

                            public final void invoke(Composer composer4, int i16) {
                                ComposerKt.sourceInformation(composer4, "C73@2888L6,72@2794L291:AlertDialog.kt#jmzs0o");
                                if ((i16 & 11) != 2 || !composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1965858367, i16, -1, "androidx.compose.material.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:72)");
                                    }
                                    ProvidedValue<Float> provides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer4, 6)));
                                    final Function2<? super Composer, ? super Integer, Unit> function211 = function29;
                                    CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer4, 2115920639, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1.1
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

                                        public final void invoke(Composer composer5, int i17) {
                                            ComposerKt.sourceInformation(composer5, "C75@2981L10,76@3026L33:AlertDialog.kt#jmzs0o");
                                            if ((i17 & 11) != 2 || !composer5.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(2115920639, i17, -1, "androidx.compose.material.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:75)");
                                                }
                                                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer5, 6).getBody2(), function211, composer5, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer5.skipToGroupEnd();
                                        }
                                    }), composer4, ProvidedValue.$stable | 48);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer4.skipToGroupEnd();
                            }
                        }) : null, composer3, 6);
                        function210.invoke(composer3, 0);
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
            }), composer2, i1322 | (i1422 & 112) | (i1422 & 896) | (i1422 & 7168), 48);
            if (ComposerKt.isTraceInProgress()) {
            }
            function26 = function24;
            function27 = function25;
            modifier3 = modifier422;
            shape3 = shape422;
            j5 = j822;
            j6 = j722;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        function24 = function22;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        function25 = function23;
        if ((57344 & i) != 0) {
        }
        if ((458752 & i) != 0) {
        }
        if ((3670016 & i) != 0) {
        }
        int i12222 = i3;
        if ((i3 & 2995931) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) == 0) {
        }
        if (i11 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 16) == 0) {
        }
        if ((i2 & 32) == 0) {
        }
        if ((i2 & 64) != 0) {
        }
        long j7222 = j4;
        long j8222 = j3;
        Shape shape4222 = shape2;
        Modifier modifier4222 = modifier2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i13222 = ((i7 >> 3) & 14) | 1572864;
        int i14222 = i7 >> 9;
        composer2 = startRestartGroup;
        SurfaceKt.m1782SurfaceFjzlyU(modifier4222, shape4222, j8222, j7222, null, 0.0f, ComposableLambdaKt.composableLambda(startRestartGroup, 629950291, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1
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
                ComposerKt.sourceInformation(composer3, "C60@2276L895:AlertDialog.kt#jmzs0o");
                if ((i15 & 11) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(629950291, i15, -1, "androidx.compose.material.AlertDialogContent.<anonymous> (AlertDialog.kt:60)");
                    }
                    final Function2<? super Composer, ? super Integer, Unit> function28 = function24;
                    final Function2<? super Composer, ? super Integer, Unit> function29 = function25;
                    Function2<Composer, Integer, Unit> function210 = function2;
                    composer3.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                    Modifier.Companion companion = Modifier.INSTANCE;
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
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
                    ComposerKt.sourceInformationMarkerStart(composer3, -80835680, "C61@2297L842,81@3152L9:AlertDialog.kt#jmzs0o");
                    AlertDialogKt.AlertDialogBaselineLayout(columnScopeInstance, function28 != null ? ComposableLambdaKt.composableLambda(composer3, 620104160, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1
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

                        public final void invoke(Composer composer4, int i16) {
                            ComposerKt.sourceInformation(composer4, "C64@2484L4,64@2419L240:AlertDialog.kt#jmzs0o");
                            if ((i16 & 11) != 2 || !composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(620104160, i16, -1, "androidx.compose.material.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:64)");
                                }
                                ProvidedValue<Float> provides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer4, 6)));
                                final Function2<? super Composer, ? super Integer, Unit> function211 = function28;
                                CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer4, 770166432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$1$1.1
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

                                    public final void invoke(Composer composer5, int i17) {
                                        ComposerKt.sourceInformation(composer5, "C65@2550L10,66@2599L34:AlertDialog.kt#jmzs0o");
                                        if ((i17 & 11) != 2 || !composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(770166432, i17, -1, "androidx.compose.material.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:65)");
                                            }
                                            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer5, 6).getSubtitle1(), function211, composer5, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer5.skipToGroupEnd();
                                    }
                                }), composer4, ProvidedValue.$stable | 48);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer4.skipToGroupEnd();
                        }
                    }) : null, function29 != null ? ComposableLambdaKt.composableLambda(composer3, 1965858367, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1
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

                        public final void invoke(Composer composer4, int i16) {
                            ComposerKt.sourceInformation(composer4, "C73@2888L6,72@2794L291:AlertDialog.kt#jmzs0o");
                            if ((i16 & 11) != 2 || !composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1965858367, i16, -1, "androidx.compose.material.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:72)");
                                }
                                ProvidedValue<Float> provides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer4, 6)));
                                final Function2<? super Composer, ? super Integer, Unit> function211 = function29;
                                CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer4, 2115920639, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogContent$1$1$2$1.1
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

                                    public final void invoke(Composer composer5, int i17) {
                                        ComposerKt.sourceInformation(composer5, "C75@2981L10,76@3026L33:AlertDialog.kt#jmzs0o");
                                        if ((i17 & 11) != 2 || !composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(2115920639, i17, -1, "androidx.compose.material.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:75)");
                                            }
                                            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer5, 6).getBody2(), function211, composer5, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer5.skipToGroupEnd();
                                    }
                                }), composer4, ProvidedValue.$stable | 48);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer4.skipToGroupEnd();
                        }
                    }) : null, composer3, 6);
                    function210.invoke(composer3, 0);
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
        }), composer2, i13222 | (i14222 & 112) | (i14222 & 896) | (i14222 & 7168), 48);
        if (ComposerKt.isTraceInProgress()) {
        }
        function26 = function24;
        function27 = function25;
        modifier3 = modifier4222;
        shape3 = shape4222;
        j5 = j8222;
        j6 = j7222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    public static final void AlertDialogBaselineLayout(final ColumnScope columnScope, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer startRestartGroup = composer.startRestartGroup(-555573207);
        ComposerKt.sourceInformation(startRestartGroup, "C(AlertDialogBaselineLayout)P(1)98@3653L3487:AlertDialog.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(columnScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 256 : 128;
        }
        if ((i2 & 731) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-555573207, i2, -1, "androidx.compose.material.AlertDialogBaselineLayout (AlertDialog.kt:97)");
            }
            Modifier weight = columnScope.weight(Modifier.INSTANCE, 1.0f, false);
            AlertDialogKt$AlertDialogBaselineLayout$2 alertDialogKt$AlertDialogBaselineLayout$2 = new MeasurePolicy() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogBaselineLayout$2
                /* JADX WARN: Removed duplicated region for block: B:32:0x00b4  */
                /* JADX WARN: Removed duplicated region for block: B:39:0x00d9  */
                /* JADX WARN: Removed duplicated region for block: B:45:0x00f4  */
                /* JADX WARN: Removed duplicated region for block: B:47:0x0107  */
                /* JADX WARN: Removed duplicated region for block: B:49:0x0110  */
                /* JADX WARN: Removed duplicated region for block: B:51:0x011e  */
                /* JADX WARN: Removed duplicated region for block: B:60:0x0113  */
                /* JADX WARN: Removed duplicated region for block: B:64:0x010d  */
                /* JADX WARN: Removed duplicated region for block: B:65:0x00fd  */
                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* renamed from: measure-3p2s80s */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final MeasureResult mo355measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                    Measurable measurable;
                    Measurable measurable2;
                    int i3;
                    int i4;
                    long j2;
                    final int i5;
                    int i6;
                    long j3;
                    int i7;
                    final int i8;
                    long j4;
                    int size = list.size();
                    int i9 = 0;
                    while (true) {
                        if (i9 >= size) {
                            measurable = null;
                            break;
                        }
                        measurable = list.get(i9);
                        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "title")) {
                            break;
                        }
                        i9++;
                    }
                    Measurable measurable3 = measurable;
                    final Placeable mo5333measureBRTryo0 = measurable3 != null ? measurable3.mo5333measureBRTryo0(Constraints.m6336copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null)) : null;
                    int size2 = list.size();
                    int i10 = 0;
                    while (true) {
                        if (i10 >= size2) {
                            measurable2 = null;
                            break;
                        }
                        measurable2 = list.get(i10);
                        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "text")) {
                            break;
                        }
                        i10++;
                    }
                    Measurable measurable4 = measurable2;
                    final Placeable mo5333measureBRTryo02 = measurable4 != null ? measurable4.mo5333measureBRTryo0(Constraints.m6336copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null)) : null;
                    int max = Math.max(mo5333measureBRTryo0 != null ? mo5333measureBRTryo0.getWidth() : 0, mo5333measureBRTryo02 != null ? mo5333measureBRTryo02.getWidth() : 0);
                    if (mo5333measureBRTryo0 != null) {
                        int intValue = Integer.valueOf(mo5333measureBRTryo0.get(AlignmentLineKt.getFirstBaseline())).intValue();
                        Integer valueOf = intValue == Integer.MIN_VALUE ? null : Integer.valueOf(intValue);
                        if (valueOf != null) {
                            i3 = valueOf.intValue();
                            if (mo5333measureBRTryo0 != null) {
                                int i11 = mo5333measureBRTryo0.get(AlignmentLineKt.getLastBaseline());
                                Integer valueOf2 = i11 == Integer.MIN_VALUE ? null : Integer.valueOf(i11);
                                if (valueOf2 != null) {
                                    i4 = valueOf2.intValue();
                                    j2 = AlertDialogKt.TitleBaselineDistanceFromTop;
                                    i5 = measureScope.mo623roundToPxR2X_6o(j2) - i3;
                                    if (mo5333measureBRTryo02 != null) {
                                        int i12 = mo5333measureBRTryo02.get(AlignmentLineKt.getFirstBaseline());
                                        Integer valueOf3 = i12 != Integer.MIN_VALUE ? Integer.valueOf(i12) : null;
                                        if (valueOf3 != null) {
                                            i6 = valueOf3.intValue();
                                            if (mo5333measureBRTryo0 != null) {
                                                j4 = AlertDialogKt.TextBaselineDistanceFromTop;
                                                i7 = measureScope.mo623roundToPxR2X_6o(j4);
                                            } else {
                                                j3 = AlertDialogKt.TextBaselineDistanceFromTitle;
                                                i7 = measureScope.mo623roundToPxR2X_6o(j3);
                                            }
                                            int height = mo5333measureBRTryo0 == null ? mo5333measureBRTryo0.getHeight() + i5 : 0;
                                            if (mo5333measureBRTryo0 != null) {
                                                i8 = i7 - i6;
                                            } else {
                                                i8 = (i4 == 0 ? height - i6 : (i5 + i4) - i6) + i7;
                                            }
                                            if (mo5333measureBRTryo02 != null) {
                                                if (i4 == 0) {
                                                    r3 = (mo5333measureBRTryo02.getHeight() + i7) - i6;
                                                } else {
                                                    r3 = ((mo5333measureBRTryo02.getHeight() + i7) - i6) - ((mo5333measureBRTryo0 != null ? mo5333measureBRTryo0.getHeight() : 0) - i4);
                                                }
                                            }
                                            return MeasureScope.layout$default(measureScope, max, height + r3, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogBaselineLayout$2.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                                    Placeable.PlacementScope placementScope2;
                                                    Placeable placeable = Placeable.this;
                                                    if (placeable != null) {
                                                        placementScope2 = placementScope;
                                                        Placeable.PlacementScope.place$default(placementScope2, placeable, 0, i5, 0.0f, 4, null);
                                                    } else {
                                                        placementScope2 = placementScope;
                                                    }
                                                    Placeable placeable2 = mo5333measureBRTryo02;
                                                    if (placeable2 != null) {
                                                        Placeable.PlacementScope.place$default(placementScope2, placeable2, 0, i8, 0.0f, 4, null);
                                                    }
                                                }
                                            }, 4, null);
                                        }
                                    }
                                    i6 = 0;
                                    if (mo5333measureBRTryo0 != null) {
                                    }
                                    if (mo5333measureBRTryo0 == null) {
                                    }
                                    if (mo5333measureBRTryo0 != null) {
                                    }
                                    if (mo5333measureBRTryo02 != null) {
                                    }
                                    return MeasureScope.layout$default(measureScope, max, height + r3, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogBaselineLayout$2.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                            Placeable.PlacementScope placementScope2;
                                            Placeable placeable = Placeable.this;
                                            if (placeable != null) {
                                                placementScope2 = placementScope;
                                                Placeable.PlacementScope.place$default(placementScope2, placeable, 0, i5, 0.0f, 4, null);
                                            } else {
                                                placementScope2 = placementScope;
                                            }
                                            Placeable placeable2 = mo5333measureBRTryo02;
                                            if (placeable2 != null) {
                                                Placeable.PlacementScope.place$default(placementScope2, placeable2, 0, i8, 0.0f, 4, null);
                                            }
                                        }
                                    }, 4, null);
                                }
                            }
                            i4 = 0;
                            j2 = AlertDialogKt.TitleBaselineDistanceFromTop;
                            i5 = measureScope.mo623roundToPxR2X_6o(j2) - i3;
                            if (mo5333measureBRTryo02 != null) {
                            }
                            i6 = 0;
                            if (mo5333measureBRTryo0 != null) {
                            }
                            if (mo5333measureBRTryo0 == null) {
                            }
                            if (mo5333measureBRTryo0 != null) {
                            }
                            if (mo5333measureBRTryo02 != null) {
                            }
                            return MeasureScope.layout$default(measureScope, max, height + r3, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogBaselineLayout$2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                    Placeable.PlacementScope placementScope2;
                                    Placeable placeable = Placeable.this;
                                    if (placeable != null) {
                                        placementScope2 = placementScope;
                                        Placeable.PlacementScope.place$default(placementScope2, placeable, 0, i5, 0.0f, 4, null);
                                    } else {
                                        placementScope2 = placementScope;
                                    }
                                    Placeable placeable2 = mo5333measureBRTryo02;
                                    if (placeable2 != null) {
                                        Placeable.PlacementScope.place$default(placementScope2, placeable2, 0, i8, 0.0f, 4, null);
                                    }
                                }
                            }, 4, null);
                        }
                    }
                    i3 = 0;
                    if (mo5333measureBRTryo0 != null) {
                    }
                    i4 = 0;
                    j2 = AlertDialogKt.TitleBaselineDistanceFromTop;
                    i5 = measureScope.mo623roundToPxR2X_6o(j2) - i3;
                    if (mo5333measureBRTryo02 != null) {
                    }
                    i6 = 0;
                    if (mo5333measureBRTryo0 != null) {
                    }
                    if (mo5333measureBRTryo0 == null) {
                    }
                    if (mo5333measureBRTryo0 != null) {
                    }
                    if (mo5333measureBRTryo02 != null) {
                    }
                    return MeasureScope.layout$default(measureScope, max, height + r3, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogBaselineLayout$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            Placeable.PlacementScope placementScope2;
                            Placeable placeable = Placeable.this;
                            if (placeable != null) {
                                placementScope2 = placementScope;
                                Placeable.PlacementScope.place$default(placementScope2, placeable, 0, i5, 0.0f, 4, null);
                            } else {
                                placementScope2 = placementScope;
                            }
                            Placeable placeable2 = mo5333measureBRTryo02;
                            if (placeable2 != null) {
                                Placeable.PlacementScope.place$default(placementScope2, placeable2, 0, i8, 0.0f, 4, null);
                            }
                        }
                    }, 4, null);
                }
            };
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(weight);
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
            Updater.m3600setimpl(m3593constructorimpl, alertDialogKt$AlertDialogBaselineLayout$2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1160646121, "C:AlertDialog.kt#jmzs0o");
            startRestartGroup.startReplaceableGroup(-1160646114);
            ComposerKt.sourceInformation(startRestartGroup, "*101@3721L106");
            if (function2 == null) {
                z = false;
            } else {
                Modifier align = columnScope.align(LayoutIdKt.layoutId(TitlePadding, "title"), Alignment.INSTANCE.getStart());
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                z = false;
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(align);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor2);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m3593constructorimpl2 = Updater.m3593constructorimpl(startRestartGroup);
                Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -630329008, "C102@3802L7:AlertDialog.kt#jmzs0o");
                function2.invoke(startRestartGroup, 0);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1735756505);
            ComposerKt.sourceInformation(startRestartGroup, "*106@3890L103");
            if (function22 != null) {
                Modifier align2 = columnScope.align(LayoutIdKt.layoutId(TextPadding, "text"), Alignment.INSTANCE.getStart());
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                boolean z2 = z;
                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), z2, startRestartGroup, z2 ? 1 : 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, z2 ? 1 : 0);
                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(align2);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor3);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m3593constructorimpl3 = Updater.m3593constructorimpl(startRestartGroup);
                Updater.m3600setimpl(m3593constructorimpl3, rememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3600setimpl(m3593constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m3593constructorimpl3.getInserting() || !Intrinsics.areEqual(m3593constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    m3593constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m3593constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                modifierMaterializerOf3.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -630328841, "C107@3969L6:AlertDialog.kt#jmzs0o");
                function22.invoke(startRestartGroup, 0);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogBaselineLayout$3
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
                    AlertDialogKt.AlertDialogBaselineLayout(ColumnScope.this, function2, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* renamed from: AlertDialogFlowRow-ixp7dh8, reason: not valid java name */
    public static final void m1520AlertDialogFlowRowixp7dh8(final float f, final float f2, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(73434452);
        ComposerKt.sourceInformation(startRestartGroup, "C(AlertDialogFlowRow)P(2:c#ui.unit.Dp,1:c#ui.unit.Dp)194@7398L3581:AlertDialog.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed(f2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i2 & 731) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(73434452, i2, -1, "androidx.compose.material.AlertDialogFlowRow (AlertDialog.kt:193)");
            }
            startRestartGroup.startReplaceableGroup(-2007963684);
            boolean changed = startRestartGroup.changed(f) | startRestartGroup.changed(f2);
            MeasurePolicy rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new MeasurePolicy() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogFlowRow$1$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo355measure3p2s80s(final MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        int max;
                        final ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        final ArrayList arrayList3 = new ArrayList();
                        Ref.IntRef intRef = new Ref.IntRef();
                        Ref.IntRef intRef2 = new Ref.IntRef();
                        ArrayList arrayList4 = new ArrayList();
                        Ref.IntRef intRef3 = new Ref.IntRef();
                        Ref.IntRef intRef4 = new Ref.IntRef();
                        long Constraints$default = ConstraintsKt.Constraints$default(0, Constraints.m6345getMaxWidthimpl(j), 0, 0, 13, null);
                        float f3 = f;
                        float f4 = f2;
                        int size = list.size();
                        int i3 = 0;
                        while (i3 < size) {
                            float f5 = f4;
                            Placeable mo5333measureBRTryo0 = list.get(i3).mo5333measureBRTryo0(Constraints$default);
                            int i4 = size;
                            int i5 = i3;
                            Ref.IntRef intRef5 = intRef3;
                            ArrayList arrayList5 = arrayList4;
                            long j2 = Constraints$default;
                            if (!measure_3p2s80s$canAddToCurrentSequence(arrayList5, intRef5, measureScope, f3, j, mo5333measureBRTryo0)) {
                                measure_3p2s80s$startNewSequence(arrayList, intRef2, measureScope, f5, arrayList5, arrayList2, intRef4, arrayList3, intRef, intRef5);
                                arrayList5 = arrayList5;
                            }
                            if (!arrayList5.isEmpty()) {
                                intRef5.element += measureScope.mo624roundToPx0680j_4(f3);
                            }
                            arrayList5.add(mo5333measureBRTryo0);
                            intRef5.element += mo5333measureBRTryo0.getWidth();
                            intRef4.element = Math.max(intRef4.element, mo5333measureBRTryo0.getHeight());
                            i3 = i5 + 1;
                            arrayList4 = arrayList5;
                            intRef3 = intRef5;
                            Constraints$default = j2;
                            size = i4;
                            f4 = f5;
                        }
                        Ref.IntRef intRef6 = intRef3;
                        ArrayList arrayList6 = arrayList4;
                        if (!arrayList6.isEmpty()) {
                            measure_3p2s80s$startNewSequence(arrayList, intRef2, measureScope, f2, arrayList6, arrayList2, intRef4, arrayList3, intRef, intRef6);
                        }
                        if (Constraints.m6345getMaxWidthimpl(j) != Integer.MAX_VALUE) {
                            max = Constraints.m6345getMaxWidthimpl(j);
                        } else {
                            max = Math.max(intRef.element, Constraints.m6347getMinWidthimpl(j));
                        }
                        final int i6 = max;
                        int max2 = Math.max(intRef2.element, Constraints.m6346getMinHeightimpl(j));
                        final float f6 = f;
                        return MeasureScope.layout$default(measureScope, i6, max2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogFlowRow$1$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                List<List<Placeable>> list2 = arrayList;
                                MeasureScope measureScope2 = measureScope;
                                float f7 = f6;
                                int i7 = i6;
                                List<Integer> list3 = arrayList3;
                                int size2 = list2.size();
                                for (int i8 = 0; i8 < size2; i8++) {
                                    List<Placeable> list4 = list2.get(i8);
                                    int size3 = list4.size();
                                    int[] iArr = new int[size3];
                                    int i9 = 0;
                                    while (i9 < size3) {
                                        iArr[i9] = list4.get(i9).getWidth() + (i9 < CollectionsKt.getLastIndex(list4) ? measureScope2.mo624roundToPx0680j_4(f7) : 0);
                                        i9++;
                                    }
                                    Arrangement.Vertical bottom = Arrangement.INSTANCE.getBottom();
                                    int[] iArr2 = new int[size3];
                                    for (int i10 = 0; i10 < size3; i10++) {
                                        iArr2[i10] = 0;
                                    }
                                    bottom.arrange(measureScope2, i7, iArr, iArr2);
                                    int size4 = list4.size();
                                    for (int i11 = 0; i11 < size4; i11++) {
                                        Placeable.PlacementScope.place$default(placementScope, list4.get(i11), iArr2[i11], list3.get(i8).intValue(), 0.0f, 4, null);
                                    }
                                }
                            }
                        }, 4, null);
                    }

                    private static final boolean measure_3p2s80s$canAddToCurrentSequence(List<Placeable> list, Ref.IntRef intRef, MeasureScope measureScope, float f3, long j, Placeable placeable) {
                        return list.isEmpty() || (intRef.element + measureScope.mo624roundToPx0680j_4(f3)) + placeable.getWidth() <= Constraints.m6345getMaxWidthimpl(j);
                    }

                    private static final void measure_3p2s80s$startNewSequence(List<List<Placeable>> list, Ref.IntRef intRef, MeasureScope measureScope, float f3, List<Placeable> list2, List<Integer> list3, Ref.IntRef intRef2, List<Integer> list4, Ref.IntRef intRef3, Ref.IntRef intRef4) {
                        if (!list.isEmpty()) {
                            intRef.element += measureScope.mo624roundToPx0680j_4(f3);
                        }
                        list.add(0, CollectionsKt.toList(list2));
                        list3.add(Integer.valueOf(intRef2.element));
                        list4.add(Integer.valueOf(intRef.element));
                        intRef.element += intRef2.element;
                        intRef3.element = Math.max(intRef3.element, intRef4.element);
                        list2.clear();
                        intRef4.element = 0;
                        intRef2.element = 0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            int i3 = (i2 >> 6) & 14;
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            Modifier.Companion companion = Modifier.INSTANCE;
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
            int i4 = ((i3 << 9) & 7168) | 6;
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
            function2.invoke(startRestartGroup, Integer.valueOf((i4 >> 9) & 14));
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogFlowRow$2
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
                    AlertDialogKt.m1520AlertDialogFlowRowixp7dh8(f, f2, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    static {
        float f = 24;
        TitlePadding = PaddingKt.m883paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m6389constructorimpl(f), 0.0f, Dp.m6389constructorimpl(f), 0.0f, 10, null);
        TextPadding = PaddingKt.m883paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m6389constructorimpl(f), 0.0f, Dp.m6389constructorimpl(f), Dp.m6389constructorimpl(28), 2, null);
    }
}
