package androidx.compose.material;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
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
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import com.google.android.exoplayer2.C;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: Snackbar.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a3\u0010\u000b\u001a\u00020\f2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000fH\u0003¢\u0006\u0002\u0010\u0011\u001a3\u0010\u0012\u001a\u00020\f2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000fH\u0003¢\u0006\u0002\u0010\u0011\u001a`\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\u001d2\b\b\u0002\u0010 \u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001ax\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e¢\u0006\u0002\b\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010 \u001a\u00020\u00012\u0011\u0010#\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001a \u0010&\u001a\u00020\f2\u0011\u0010#\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000fH\u0003¢\u0006\u0002\u0010'\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006("}, d2 = {"HeightToFirstLine", "Landroidx/compose/ui/unit/Dp;", "F", "HorizontalSpacing", "HorizontalSpacingButtonSide", "LongButtonVerticalOffset", "SeparateButtonExtraY", "SnackbarMinHeightOneLine", "SnackbarMinHeightTwoLines", "SnackbarVerticalPadding", "TextEndExtraSpacing", "NewLineButtonSnackbar", "", "text", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "action", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "OneRowSnackbar", "Snackbar", "snackbarData", "Landroidx/compose/material/SnackbarData;", "modifier", "Landroidx/compose/ui/Modifier;", "actionOnNewLine", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "actionColor", "elevation", "Snackbar-sPrSdHI", "(Landroidx/compose/material/SnackbarData;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJJFLandroidx/compose/runtime/Composer;II)V", "content", "Snackbar-7zSek6w", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/graphics/Shape;JJFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TextOnlySnackbar", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SnackbarKt {
    private static final float HorizontalSpacingButtonSide;
    private static final float TextEndExtraSpacing;
    private static final float HeightToFirstLine = Dp.m6389constructorimpl(30);
    private static final float HorizontalSpacing = Dp.m6389constructorimpl(16);
    private static final float SeparateButtonExtraY = Dp.m6389constructorimpl(2);
    private static final float SnackbarVerticalPadding = Dp.m6389constructorimpl(6);
    private static final float LongButtonVerticalOffset = Dp.m6389constructorimpl(12);
    private static final float SnackbarMinHeightOneLine = Dp.m6389constructorimpl(48);
    private static final float SnackbarMinHeightTwoLines = Dp.m6389constructorimpl(68);

    /* JADX WARN: Removed duplicated region for block: B:105:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00ef  */
    /* renamed from: Snackbar-7zSek6w, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1764Snackbar7zSek6w(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, boolean z, Shape shape, long j, long j2, float f, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i, final int i2) {
        int i3;
        Function2<? super Composer, ? super Integer, Unit> function23;
        int i4;
        boolean z2;
        Shape shape2;
        long j3;
        int i5;
        int i6;
        int i7;
        float f2;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final boolean z3;
        CornerBasedShape cornerBasedShape;
        long j4;
        int i8;
        Modifier modifier2;
        Shape shape3;
        int i9;
        long j5;
        float f3;
        long j6;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        final boolean z4;
        final Modifier modifier3;
        final Shape shape4;
        final long j7;
        final long j8;
        final float f4;
        ScopeUpdateScope endRestartGroup;
        int i10;
        int i11;
        int i12;
        Composer startRestartGroup = composer.startRestartGroup(-558258760);
        ComposerKt.sourceInformation(startRestartGroup, "C(Snackbar)P(6!2,7,2:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.unit.Dp)85@3997L6,86@4057L15,87@4114L6,91@4200L631:Snackbar.kt#jmzs0o");
        int i13 = i2 & 1;
        if (i13 != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i14 = i2 & 2;
        if (i14 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            function23 = function2;
            i3 |= startRestartGroup.changedInstance(function23) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 896) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 256 : 128;
                if ((i & 7168) == 0) {
                    if ((i2 & 8) == 0) {
                        shape2 = shape;
                        if (startRestartGroup.changed(shape2)) {
                            i12 = 2048;
                            i3 |= i12;
                        }
                    } else {
                        shape2 = shape;
                    }
                    i12 = 1024;
                    i3 |= i12;
                } else {
                    shape2 = shape;
                }
                if ((57344 & i) == 0) {
                    if ((i2 & 16) == 0) {
                        j3 = j;
                        if (startRestartGroup.changed(j3)) {
                            i11 = 16384;
                            i3 |= i11;
                        }
                    } else {
                        j3 = j;
                    }
                    i11 = 8192;
                    i3 |= i11;
                } else {
                    j3 = j;
                }
                if ((i & 458752) == 0) {
                    i5 = i13;
                    i3 |= ((i2 & 32) == 0 && startRestartGroup.changed(j2)) ? 131072 : 65536;
                } else {
                    i5 = i13;
                }
                i6 = i2 & 64;
                if (i6 != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    i7 = 458752;
                    f2 = f;
                    i3 |= startRestartGroup.changed(f2) ? 1048576 : 524288;
                    if ((i2 & 128) != 0) {
                        i10 = (29360128 & i) == 0 ? startRestartGroup.changedInstance(function22) ? 8388608 : 4194304 : 12582912;
                        if ((23967451 & i3) == 4793490 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i5 != 0 ? Modifier.INSTANCE : modifier;
                                function24 = i14 != 0 ? null : function23;
                                z3 = i4 != 0 ? false : z2;
                                if ((i2 & 8) != 0) {
                                    cornerBasedShape = MaterialTheme.INSTANCE.getShapes(startRestartGroup, 6).getSmall();
                                    i3 &= -7169;
                                } else {
                                    cornerBasedShape = shape2;
                                }
                                if ((i2 & 16) != 0) {
                                    j3 = SnackbarDefaults.INSTANCE.getBackgroundColor(startRestartGroup, 6);
                                    i3 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    j4 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m1607getSurface0d7_KjU();
                                    i3 = (-458753) & i3;
                                } else {
                                    j4 = j2;
                                }
                                if (i6 != 0) {
                                    j6 = j3;
                                    modifier2 = companion;
                                    shape3 = cornerBasedShape;
                                    i9 = 1572864;
                                    long j9 = j4;
                                    f3 = Dp.m6389constructorimpl(6);
                                    i8 = i7;
                                    j5 = j9;
                                } else {
                                    i8 = i7;
                                    long j10 = j3;
                                    modifier2 = companion;
                                    shape3 = cornerBasedShape;
                                    i9 = 1572864;
                                    j5 = j4;
                                    f3 = f2;
                                    j6 = j10;
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
                                function24 = function23;
                                z3 = z2;
                                f3 = f2;
                                i9 = 1572864;
                                i8 = i7;
                                j5 = j2;
                                j6 = j3;
                                modifier2 = modifier;
                                shape3 = shape2;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-558258760, i3, -1, "androidx.compose.material.Snackbar (Snackbar.kt:90)");
                            }
                            int i15 = i3 >> 6;
                            composer2 = startRestartGroup;
                            SurfaceKt.m1782SurfaceFjzlyU(modifier2, shape3, j6, j5, null, f3, ComposableLambdaKt.composableLambda(startRestartGroup, -2084221700, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$1
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

                                public final void invoke(Composer composer3, int i16) {
                                    ComposerKt.sourceInformation(composer3, "C98@4442L4,98@4377L448:Snackbar.kt#jmzs0o");
                                    if ((i16 & 11) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-2084221700, i16, -1, "androidx.compose.material.Snackbar.<anonymous> (Snackbar.kt:98)");
                                        }
                                        ProvidedValue<Float> provides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer3, 6)));
                                        final Function2<Composer, Integer, Unit> function26 = function24;
                                        final Function2<Composer, Integer, Unit> function27 = function22;
                                        final boolean z5 = z3;
                                        CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer3, 1939362236, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$1.1
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

                                            public final void invoke(Composer composer4, int i17) {
                                                ComposerKt.sourceInformation(composer4, "C99@4492L10,100@4521L294:Snackbar.kt#jmzs0o");
                                                if ((i17 & 11) != 2 || !composer4.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1939362236, i17, -1, "androidx.compose.material.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:99)");
                                                    }
                                                    TextStyle body2 = MaterialTheme.INSTANCE.getTypography(composer4, 6).getBody2();
                                                    final Function2<Composer, Integer, Unit> function28 = function26;
                                                    final Function2<Composer, Integer, Unit> function29 = function27;
                                                    final boolean z6 = z5;
                                                    TextKt.ProvideTextStyle(body2, ComposableLambdaKt.composableLambda(composer4, 225114541, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt.Snackbar.1.1.1
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

                                                        public final void invoke(Composer composer5, int i18) {
                                                            ComposerKt.sourceInformation(composer5, "C:Snackbar.kt#jmzs0o");
                                                            if ((i18 & 11) != 2 || !composer5.getSkipping()) {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(225114541, i18, -1, "androidx.compose.material.Snackbar.<anonymous>.<anonymous>.<anonymous> (Snackbar.kt:101)");
                                                                }
                                                                if (function28 == null) {
                                                                    composer5.startReplaceableGroup(59708388);
                                                                    ComposerKt.sourceInformation(composer5, "102@4620L25");
                                                                    SnackbarKt.TextOnlySnackbar(function29, composer5, 0);
                                                                    composer5.endReplaceableGroup();
                                                                } else if (z6) {
                                                                    composer5.startReplaceableGroup(59708453);
                                                                    ComposerKt.sourceInformation(composer5, "103@4685L38");
                                                                    SnackbarKt.NewLineButtonSnackbar(function29, function28, composer5, 0);
                                                                    composer5.endReplaceableGroup();
                                                                } else {
                                                                    composer5.startReplaceableGroup(59708520);
                                                                    ComposerKt.sourceInformation(composer5, "104@4752L31");
                                                                    SnackbarKt.OneRowSnackbar(function29, function28, composer5, 0);
                                                                    composer5.endReplaceableGroup();
                                                                }
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
                            }), composer2, i9 | (i3 & 14) | (i15 & 112) | (i15 & 896) | (i15 & 7168) | (i8 & (i3 >> 3)), 16);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function25 = function24;
                            z4 = z3;
                            modifier3 = modifier2;
                            shape4 = shape3;
                            j7 = j6;
                            j8 = j5;
                            f4 = f3;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            composer2 = startRestartGroup;
                            function25 = function23;
                            z4 = z2;
                            shape4 = shape2;
                            j7 = j3;
                            f4 = f2;
                            modifier3 = modifier;
                            j8 = j2;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$2
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

                                public final void invoke(Composer composer3, int i16) {
                                    SnackbarKt.m1764Snackbar7zSek6w(Modifier.this, function25, z4, shape4, j7, j8, f4, function22, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i3 |= i10;
                    if ((23967451 & i3) == 4793490) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i14 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if ((i2 & 8) != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if (i6 != 0) {
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i152 = i3 >> 6;
                    composer2 = startRestartGroup;
                    SurfaceKt.m1782SurfaceFjzlyU(modifier2, shape3, j6, j5, null, f3, ComposableLambdaKt.composableLambda(startRestartGroup, -2084221700, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$1
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

                        public final void invoke(Composer composer3, int i16) {
                            ComposerKt.sourceInformation(composer3, "C98@4442L4,98@4377L448:Snackbar.kt#jmzs0o");
                            if ((i16 & 11) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-2084221700, i16, -1, "androidx.compose.material.Snackbar.<anonymous> (Snackbar.kt:98)");
                                }
                                ProvidedValue<Float> provides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer3, 6)));
                                final Function2<? super Composer, ? super Integer, Unit> function26 = function24;
                                final Function2<? super Composer, ? super Integer, Unit> function27 = function22;
                                final boolean z5 = z3;
                                CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer3, 1939362236, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$1.1
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

                                    public final void invoke(Composer composer4, int i17) {
                                        ComposerKt.sourceInformation(composer4, "C99@4492L10,100@4521L294:Snackbar.kt#jmzs0o");
                                        if ((i17 & 11) != 2 || !composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1939362236, i17, -1, "androidx.compose.material.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:99)");
                                            }
                                            TextStyle body2 = MaterialTheme.INSTANCE.getTypography(composer4, 6).getBody2();
                                            final Function2<? super Composer, ? super Integer, Unit> function28 = function26;
                                            final Function2<? super Composer, ? super Integer, Unit> function29 = function27;
                                            final boolean z6 = z5;
                                            TextKt.ProvideTextStyle(body2, ComposableLambdaKt.composableLambda(composer4, 225114541, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt.Snackbar.1.1.1
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

                                                public final void invoke(Composer composer5, int i18) {
                                                    ComposerKt.sourceInformation(composer5, "C:Snackbar.kt#jmzs0o");
                                                    if ((i18 & 11) != 2 || !composer5.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(225114541, i18, -1, "androidx.compose.material.Snackbar.<anonymous>.<anonymous>.<anonymous> (Snackbar.kt:101)");
                                                        }
                                                        if (function28 == null) {
                                                            composer5.startReplaceableGroup(59708388);
                                                            ComposerKt.sourceInformation(composer5, "102@4620L25");
                                                            SnackbarKt.TextOnlySnackbar(function29, composer5, 0);
                                                            composer5.endReplaceableGroup();
                                                        } else if (z6) {
                                                            composer5.startReplaceableGroup(59708453);
                                                            ComposerKt.sourceInformation(composer5, "103@4685L38");
                                                            SnackbarKt.NewLineButtonSnackbar(function29, function28, composer5, 0);
                                                            composer5.endReplaceableGroup();
                                                        } else {
                                                            composer5.startReplaceableGroup(59708520);
                                                            ComposerKt.sourceInformation(composer5, "104@4752L31");
                                                            SnackbarKt.OneRowSnackbar(function29, function28, composer5, 0);
                                                            composer5.endReplaceableGroup();
                                                        }
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
                    }), composer2, i9 | (i3 & 14) | (i152 & 112) | (i152 & 896) | (i152 & 7168) | (i8 & (i3 >> 3)), 16);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    function25 = function24;
                    z4 = z3;
                    modifier3 = modifier2;
                    shape4 = shape3;
                    j7 = j6;
                    j8 = j5;
                    f4 = f3;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i7 = 458752;
                f2 = f;
                if ((i2 & 128) != 0) {
                }
                i3 |= i10;
                if ((23967451 & i3) == 4793490) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i5 != 0) {
                }
                if (i14 != 0) {
                }
                if (i4 != 0) {
                }
                if ((i2 & 8) != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if (i6 != 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i1522 = i3 >> 6;
                composer2 = startRestartGroup;
                SurfaceKt.m1782SurfaceFjzlyU(modifier2, shape3, j6, j5, null, f3, ComposableLambdaKt.composableLambda(startRestartGroup, -2084221700, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$1
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

                    public final void invoke(Composer composer3, int i16) {
                        ComposerKt.sourceInformation(composer3, "C98@4442L4,98@4377L448:Snackbar.kt#jmzs0o");
                        if ((i16 & 11) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2084221700, i16, -1, "androidx.compose.material.Snackbar.<anonymous> (Snackbar.kt:98)");
                            }
                            ProvidedValue<Float> provides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer3, 6)));
                            final Function2<? super Composer, ? super Integer, Unit> function26 = function24;
                            final Function2<? super Composer, ? super Integer, Unit> function27 = function22;
                            final boolean z5 = z3;
                            CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer3, 1939362236, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$1.1
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

                                public final void invoke(Composer composer4, int i17) {
                                    ComposerKt.sourceInformation(composer4, "C99@4492L10,100@4521L294:Snackbar.kt#jmzs0o");
                                    if ((i17 & 11) != 2 || !composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1939362236, i17, -1, "androidx.compose.material.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:99)");
                                        }
                                        TextStyle body2 = MaterialTheme.INSTANCE.getTypography(composer4, 6).getBody2();
                                        final Function2<? super Composer, ? super Integer, Unit> function28 = function26;
                                        final Function2<? super Composer, ? super Integer, Unit> function29 = function27;
                                        final boolean z6 = z5;
                                        TextKt.ProvideTextStyle(body2, ComposableLambdaKt.composableLambda(composer4, 225114541, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt.Snackbar.1.1.1
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

                                            public final void invoke(Composer composer5, int i18) {
                                                ComposerKt.sourceInformation(composer5, "C:Snackbar.kt#jmzs0o");
                                                if ((i18 & 11) != 2 || !composer5.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(225114541, i18, -1, "androidx.compose.material.Snackbar.<anonymous>.<anonymous>.<anonymous> (Snackbar.kt:101)");
                                                    }
                                                    if (function28 == null) {
                                                        composer5.startReplaceableGroup(59708388);
                                                        ComposerKt.sourceInformation(composer5, "102@4620L25");
                                                        SnackbarKt.TextOnlySnackbar(function29, composer5, 0);
                                                        composer5.endReplaceableGroup();
                                                    } else if (z6) {
                                                        composer5.startReplaceableGroup(59708453);
                                                        ComposerKt.sourceInformation(composer5, "103@4685L38");
                                                        SnackbarKt.NewLineButtonSnackbar(function29, function28, composer5, 0);
                                                        composer5.endReplaceableGroup();
                                                    } else {
                                                        composer5.startReplaceableGroup(59708520);
                                                        ComposerKt.sourceInformation(composer5, "104@4752L31");
                                                        SnackbarKt.OneRowSnackbar(function29, function28, composer5, 0);
                                                        composer5.endReplaceableGroup();
                                                    }
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
                }), composer2, i9 | (i3 & 14) | (i1522 & 112) | (i1522 & 896) | (i1522 & 7168) | (i8 & (i3 >> 3)), 16);
                if (ComposerKt.isTraceInProgress()) {
                }
                function25 = function24;
                z4 = z3;
                modifier3 = modifier2;
                shape4 = shape3;
                j7 = j6;
                j8 = j5;
                f4 = f3;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z2 = z;
            if ((i & 7168) == 0) {
            }
            if ((57344 & i) == 0) {
            }
            if ((i & 458752) == 0) {
            }
            i6 = i2 & 64;
            if (i6 != 0) {
            }
            i7 = 458752;
            f2 = f;
            if ((i2 & 128) != 0) {
            }
            i3 |= i10;
            if ((23967451 & i3) == 4793490) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i5 != 0) {
            }
            if (i14 != 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 8) != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if (i6 != 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i15222 = i3 >> 6;
            composer2 = startRestartGroup;
            SurfaceKt.m1782SurfaceFjzlyU(modifier2, shape3, j6, j5, null, f3, ComposableLambdaKt.composableLambda(startRestartGroup, -2084221700, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$1
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

                public final void invoke(Composer composer3, int i16) {
                    ComposerKt.sourceInformation(composer3, "C98@4442L4,98@4377L448:Snackbar.kt#jmzs0o");
                    if ((i16 & 11) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2084221700, i16, -1, "androidx.compose.material.Snackbar.<anonymous> (Snackbar.kt:98)");
                        }
                        ProvidedValue<Float> provides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer3, 6)));
                        final Function2<? super Composer, ? super Integer, Unit> function26 = function24;
                        final Function2<? super Composer, ? super Integer, Unit> function27 = function22;
                        final boolean z5 = z3;
                        CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer3, 1939362236, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$1.1
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

                            public final void invoke(Composer composer4, int i17) {
                                ComposerKt.sourceInformation(composer4, "C99@4492L10,100@4521L294:Snackbar.kt#jmzs0o");
                                if ((i17 & 11) != 2 || !composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1939362236, i17, -1, "androidx.compose.material.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:99)");
                                    }
                                    TextStyle body2 = MaterialTheme.INSTANCE.getTypography(composer4, 6).getBody2();
                                    final Function2<? super Composer, ? super Integer, Unit> function28 = function26;
                                    final Function2<? super Composer, ? super Integer, Unit> function29 = function27;
                                    final boolean z6 = z5;
                                    TextKt.ProvideTextStyle(body2, ComposableLambdaKt.composableLambda(composer4, 225114541, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt.Snackbar.1.1.1
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

                                        public final void invoke(Composer composer5, int i18) {
                                            ComposerKt.sourceInformation(composer5, "C:Snackbar.kt#jmzs0o");
                                            if ((i18 & 11) != 2 || !composer5.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(225114541, i18, -1, "androidx.compose.material.Snackbar.<anonymous>.<anonymous>.<anonymous> (Snackbar.kt:101)");
                                                }
                                                if (function28 == null) {
                                                    composer5.startReplaceableGroup(59708388);
                                                    ComposerKt.sourceInformation(composer5, "102@4620L25");
                                                    SnackbarKt.TextOnlySnackbar(function29, composer5, 0);
                                                    composer5.endReplaceableGroup();
                                                } else if (z6) {
                                                    composer5.startReplaceableGroup(59708453);
                                                    ComposerKt.sourceInformation(composer5, "103@4685L38");
                                                    SnackbarKt.NewLineButtonSnackbar(function29, function28, composer5, 0);
                                                    composer5.endReplaceableGroup();
                                                } else {
                                                    composer5.startReplaceableGroup(59708520);
                                                    ComposerKt.sourceInformation(composer5, "104@4752L31");
                                                    SnackbarKt.OneRowSnackbar(function29, function28, composer5, 0);
                                                    composer5.endReplaceableGroup();
                                                }
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
            }), composer2, i9 | (i3 & 14) | (i15222 & 112) | (i15222 & 896) | (i15222 & 7168) | (i8 & (i3 >> 3)), 16);
            if (ComposerKt.isTraceInProgress()) {
            }
            function25 = function24;
            z4 = z3;
            modifier3 = modifier2;
            shape4 = shape3;
            j7 = j6;
            j8 = j5;
            f4 = f3;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        function23 = function2;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 7168) == 0) {
        }
        if ((57344 & i) == 0) {
        }
        if ((i & 458752) == 0) {
        }
        i6 = i2 & 64;
        if (i6 != 0) {
        }
        i7 = 458752;
        f2 = f;
        if ((i2 & 128) != 0) {
        }
        i3 |= i10;
        if ((23967451 & i3) == 4793490) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i5 != 0) {
        }
        if (i14 != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if (i6 != 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i152222 = i3 >> 6;
        composer2 = startRestartGroup;
        SurfaceKt.m1782SurfaceFjzlyU(modifier2, shape3, j6, j5, null, f3, ComposableLambdaKt.composableLambda(startRestartGroup, -2084221700, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$1
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

            public final void invoke(Composer composer3, int i16) {
                ComposerKt.sourceInformation(composer3, "C98@4442L4,98@4377L448:Snackbar.kt#jmzs0o");
                if ((i16 & 11) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2084221700, i16, -1, "androidx.compose.material.Snackbar.<anonymous> (Snackbar.kt:98)");
                    }
                    ProvidedValue<Float> provides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer3, 6)));
                    final Function2<? super Composer, ? super Integer, Unit> function26 = function24;
                    final Function2<? super Composer, ? super Integer, Unit> function27 = function22;
                    final boolean z5 = z3;
                    CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer3, 1939362236, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$1.1
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

                        public final void invoke(Composer composer4, int i17) {
                            ComposerKt.sourceInformation(composer4, "C99@4492L10,100@4521L294:Snackbar.kt#jmzs0o");
                            if ((i17 & 11) != 2 || !composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1939362236, i17, -1, "androidx.compose.material.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:99)");
                                }
                                TextStyle body2 = MaterialTheme.INSTANCE.getTypography(composer4, 6).getBody2();
                                final Function2<? super Composer, ? super Integer, Unit> function28 = function26;
                                final Function2<? super Composer, ? super Integer, Unit> function29 = function27;
                                final boolean z6 = z5;
                                TextKt.ProvideTextStyle(body2, ComposableLambdaKt.composableLambda(composer4, 225114541, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt.Snackbar.1.1.1
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

                                    public final void invoke(Composer composer5, int i18) {
                                        ComposerKt.sourceInformation(composer5, "C:Snackbar.kt#jmzs0o");
                                        if ((i18 & 11) != 2 || !composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(225114541, i18, -1, "androidx.compose.material.Snackbar.<anonymous>.<anonymous>.<anonymous> (Snackbar.kt:101)");
                                            }
                                            if (function28 == null) {
                                                composer5.startReplaceableGroup(59708388);
                                                ComposerKt.sourceInformation(composer5, "102@4620L25");
                                                SnackbarKt.TextOnlySnackbar(function29, composer5, 0);
                                                composer5.endReplaceableGroup();
                                            } else if (z6) {
                                                composer5.startReplaceableGroup(59708453);
                                                ComposerKt.sourceInformation(composer5, "103@4685L38");
                                                SnackbarKt.NewLineButtonSnackbar(function29, function28, composer5, 0);
                                                composer5.endReplaceableGroup();
                                            } else {
                                                composer5.startReplaceableGroup(59708520);
                                                ComposerKt.sourceInformation(composer5, "104@4752L31");
                                                SnackbarKt.OneRowSnackbar(function29, function28, composer5, 0);
                                                composer5.endReplaceableGroup();
                                            }
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
        }), composer2, i9 | (i3 & 14) | (i152222 & 112) | (i152222 & 896) | (i152222 & 7168) | (i8 & (i3 >> 3)), 16);
        if (ComposerKt.isTraceInProgress()) {
        }
        function25 = function24;
        z4 = z3;
        modifier3 = modifier2;
        shape4 = shape3;
        j7 = j6;
        j8 = j5;
        f4 = f3;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x018e  */
    /* renamed from: Snackbar-sPrSdHI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1765SnackbarsPrSdHI(final SnackbarData snackbarData, Modifier modifier, boolean z, Shape shape, long j, long j2, long j3, float f, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        Shape shape2;
        int i5;
        long j4;
        int i6;
        final long j5;
        int i7;
        int i8;
        float f2;
        long j6;
        long j7;
        float f3;
        int i9;
        int i10;
        int i11;
        long j8;
        int i12;
        Composer composer2;
        final Modifier modifier3;
        final long j9;
        final boolean z3;
        final Shape shape3;
        final long j10;
        final long j11;
        final float f4;
        ScopeUpdateScope endRestartGroup;
        int i13;
        int i14;
        int i15;
        Composer startRestartGroup = composer.startRestartGroup(258660814);
        ComposerKt.sourceInformation(startRestartGroup, "C(Snackbar)P(7,5,1,6,2:c#ui.graphics.Color,3:c#ui.graphics.Color,0:c#ui.graphics.Color,4:c#ui.unit.Dp)156@7174L6,157@7234L15,158@7291L6,159@7349L18,174@7826L320:Snackbar.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changed(snackbarData) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i16 = i2 & 2;
        if (i16 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 896) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 256 : 128;
                if ((i & 7168) == 0) {
                    if ((i2 & 8) == 0) {
                        shape2 = shape;
                        if (startRestartGroup.changed(shape2)) {
                            i15 = 2048;
                            i3 |= i15;
                        }
                    } else {
                        shape2 = shape;
                    }
                    i15 = 1024;
                    i3 |= i15;
                } else {
                    shape2 = shape;
                }
                if ((i & 57344) == 0) {
                    if ((i2 & 16) == 0 && startRestartGroup.changed(j)) {
                        i14 = 16384;
                        i3 |= i14;
                    }
                    i14 = 8192;
                    i3 |= i14;
                }
                if ((i & 458752) == 0) {
                    i5 = 57344;
                    j4 = j2;
                    i3 |= ((i2 & 32) == 0 && startRestartGroup.changed(j4)) ? 131072 : 65536;
                } else {
                    i5 = 57344;
                    j4 = j2;
                }
                if ((i & 3670016) == 0) {
                    if ((i2 & 64) == 0) {
                        i6 = 3670016;
                        j5 = j3;
                        if (startRestartGroup.changed(j5)) {
                            i13 = 1048576;
                            i3 |= i13;
                        }
                    } else {
                        i6 = 3670016;
                        j5 = j3;
                    }
                    i13 = 524288;
                    i3 |= i13;
                } else {
                    i6 = 3670016;
                    j5 = j3;
                }
                i7 = i2 & 128;
                if (i7 != 0) {
                    i3 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    i8 = i6;
                    f2 = f;
                    i3 |= startRestartGroup.changed(f2) ? 8388608 : 4194304;
                    if ((i3 & 23967451) == 4793490 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z2 = false;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                                shape2 = MaterialTheme.INSTANCE.getShapes(startRestartGroup, 6).getSmall();
                            }
                            if ((i2 & 16) == 0) {
                                j6 = SnackbarDefaults.INSTANCE.getBackgroundColor(startRestartGroup, 6);
                                i3 &= -57345;
                            } else {
                                j6 = j;
                            }
                            if ((i2 & 32) != 0) {
                                j4 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m1607getSurface0d7_KjU();
                                i3 &= -458753;
                            }
                            if ((i2 & 64) != 0) {
                                j5 = SnackbarDefaults.INSTANCE.getPrimaryActionColor(startRestartGroup, 6);
                                i3 &= -3670017;
                            }
                            if (i7 == 0) {
                                f3 = Dp.m6389constructorimpl(6);
                                j7 = j4;
                            } else {
                                j7 = j4;
                                f3 = f2;
                            }
                            i9 = 458752;
                            i10 = 12582912;
                            i11 = i8;
                            j8 = j6;
                            i12 = 258660814;
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
                            j7 = j4;
                            f3 = f2;
                            i9 = 458752;
                            i10 = 12582912;
                            i11 = i8;
                            i12 = 258660814;
                            j8 = j;
                        }
                        boolean z4 = z2;
                        Shape shape4 = shape2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i12, i3, -1, "androidx.compose.material.Snackbar (Snackbar.kt:161)");
                        }
                        final String actionLabel = snackbarData.getActionLabel();
                        composer2 = startRestartGroup;
                        m1764Snackbar7zSek6w(PaddingKt.m879padding3ABfNKs(modifier2, Dp.m6389constructorimpl(12)), actionLabel == null ? ComposableLambdaKt.composableLambda(startRestartGroup, 1843479216, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i17) {
                                ComposerKt.sourceInformation(composer3, "C166@7612L44,165@7560L219:Snackbar.kt#jmzs0o");
                                if ((i17 & 11) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1843479216, i17, -1, "androidx.compose.material.Snackbar.<anonymous> (Snackbar.kt:165)");
                                }
                                ButtonColors m1577textButtonColorsRGew2ao = ButtonDefaults.INSTANCE.m1577textButtonColorsRGew2ao(0L, j5, 0L, composer3, 3072, 5);
                                final SnackbarData snackbarData2 = snackbarData;
                                Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1.1
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
                                        SnackbarData.this.performAction();
                                    }
                                };
                                final String str = actionLabel;
                                ButtonKt.TextButton(function0, null, false, null, null, null, null, m1577textButtonColorsRGew2ao, null, ComposableLambdaKt.composableLambda(composer3, -929149933, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer4, Integer num) {
                                        invoke(rowScope, composer4, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(RowScope rowScope, Composer composer4, int i18) {
                                        ComposerKt.sourceInformation(composer4, "C168@7746L17:Snackbar.kt#jmzs0o");
                                        if ((i18 & 81) == 16 && composer4.getSkipping()) {
                                            composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-929149933, i18, -1, "androidx.compose.material.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:168)");
                                        }
                                        TextKt.m1842Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer4, 0, 0, 131070);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), composer3, C.ENCODING_PCM_32BIT, 382);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }) : null, z4, shape4, j8, j7, f3, ComposableLambdaKt.composableLambda(startRestartGroup, -261845785, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$3
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i17) {
                                ComposerKt.sourceInformation(composer3, "C176@7900L26:Snackbar.kt#jmzs0o");
                                if ((i17 & 11) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-261845785, i17, -1, "androidx.compose.material.Snackbar.<anonymous> (Snackbar.kt:176)");
                                }
                                TextKt.m1842Text4IGK_g(SnackbarData.this.getMessage(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 0, 0, 131070);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer2, i10 | (i3 & 896) | (i3 & 7168) | (i3 & i5) | (i9 & i3) | ((i3 >> 3) & i11), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        j9 = j5;
                        z3 = z4;
                        shape3 = shape4;
                        j10 = j8;
                        j11 = j7;
                        f4 = f3;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        composer2 = startRestartGroup;
                        modifier3 = modifier2;
                        z3 = z2;
                        shape3 = shape2;
                        j11 = j4;
                        j9 = j5;
                        f4 = f2;
                        j10 = j;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i17) {
                                SnackbarKt.m1765SnackbarsPrSdHI(SnackbarData.this, modifier3, z3, shape3, j10, j11, j9, f4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                i8 = i6;
                f2 = f;
                if ((i3 & 23967451) == 4793490) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i16 != 0) {
                }
                if (i4 != 0) {
                }
                if ((i2 & 8) != 0) {
                }
                if ((i2 & 16) == 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if ((i2 & 64) != 0) {
                }
                if (i7 == 0) {
                }
                i9 = 458752;
                i10 = 12582912;
                i11 = i8;
                j8 = j6;
                i12 = 258660814;
                boolean z42 = z2;
                Shape shape42 = shape2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                final String actionLabel2 = snackbarData.getActionLabel();
                if (actionLabel2 == null) {
                }
                composer2 = startRestartGroup;
                m1764Snackbar7zSek6w(PaddingKt.m879padding3ABfNKs(modifier2, Dp.m6389constructorimpl(12)), actionLabel2 == null ? ComposableLambdaKt.composableLambda(startRestartGroup, 1843479216, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i17) {
                        ComposerKt.sourceInformation(composer3, "C166@7612L44,165@7560L219:Snackbar.kt#jmzs0o");
                        if ((i17 & 11) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1843479216, i17, -1, "androidx.compose.material.Snackbar.<anonymous> (Snackbar.kt:165)");
                        }
                        ButtonColors m1577textButtonColorsRGew2ao = ButtonDefaults.INSTANCE.m1577textButtonColorsRGew2ao(0L, j5, 0L, composer3, 3072, 5);
                        final SnackbarData snackbarData2 = snackbarData;
                        Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1.1
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
                                SnackbarData.this.performAction();
                            }
                        };
                        final String str = actionLabel2;
                        ButtonKt.TextButton(function0, null, false, null, null, null, null, m1577textButtonColorsRGew2ao, null, ComposableLambdaKt.composableLambda(composer3, -929149933, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer4, Integer num) {
                                invoke(rowScope, composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(RowScope rowScope, Composer composer4, int i18) {
                                ComposerKt.sourceInformation(composer4, "C168@7746L17:Snackbar.kt#jmzs0o");
                                if ((i18 & 81) == 16 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-929149933, i18, -1, "androidx.compose.material.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:168)");
                                }
                                TextKt.m1842Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer4, 0, 0, 131070);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer3, C.ENCODING_PCM_32BIT, 382);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }) : null, z42, shape42, j8, j7, f3, ComposableLambdaKt.composableLambda(startRestartGroup, -261845785, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$3
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i17) {
                        ComposerKt.sourceInformation(composer3, "C176@7900L26:Snackbar.kt#jmzs0o");
                        if ((i17 & 11) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-261845785, i17, -1, "androidx.compose.material.Snackbar.<anonymous> (Snackbar.kt:176)");
                        }
                        TextKt.m1842Text4IGK_g(SnackbarData.this.getMessage(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 0, 0, 131070);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer2, i10 | (i3 & 896) | (i3 & 7168) | (i3 & i5) | (i9 & i3) | ((i3 >> 3) & i11), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier2;
                j9 = j5;
                z3 = z42;
                shape3 = shape42;
                j10 = j8;
                j11 = j7;
                f4 = f3;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z2 = z;
            if ((i & 7168) == 0) {
            }
            if ((i & 57344) == 0) {
            }
            if ((i & 458752) == 0) {
            }
            if ((i & 3670016) == 0) {
            }
            i7 = i2 & 128;
            if (i7 != 0) {
            }
            i8 = i6;
            f2 = f;
            if ((i3 & 23967451) == 4793490) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i16 != 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 8) != 0) {
            }
            if ((i2 & 16) == 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if ((i2 & 64) != 0) {
            }
            if (i7 == 0) {
            }
            i9 = 458752;
            i10 = 12582912;
            i11 = i8;
            j8 = j6;
            i12 = 258660814;
            boolean z422 = z2;
            Shape shape422 = shape2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            final String actionLabel22 = snackbarData.getActionLabel();
            if (actionLabel22 == null) {
            }
            composer2 = startRestartGroup;
            m1764Snackbar7zSek6w(PaddingKt.m879padding3ABfNKs(modifier2, Dp.m6389constructorimpl(12)), actionLabel22 == null ? ComposableLambdaKt.composableLambda(startRestartGroup, 1843479216, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i17) {
                    ComposerKt.sourceInformation(composer3, "C166@7612L44,165@7560L219:Snackbar.kt#jmzs0o");
                    if ((i17 & 11) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1843479216, i17, -1, "androidx.compose.material.Snackbar.<anonymous> (Snackbar.kt:165)");
                    }
                    ButtonColors m1577textButtonColorsRGew2ao = ButtonDefaults.INSTANCE.m1577textButtonColorsRGew2ao(0L, j5, 0L, composer3, 3072, 5);
                    final SnackbarData snackbarData2 = snackbarData;
                    Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1.1
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
                            SnackbarData.this.performAction();
                        }
                    };
                    final String str = actionLabel22;
                    ButtonKt.TextButton(function0, null, false, null, null, null, null, m1577textButtonColorsRGew2ao, null, ComposableLambdaKt.composableLambda(composer3, -929149933, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer4, Integer num) {
                            invoke(rowScope, composer4, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(RowScope rowScope, Composer composer4, int i18) {
                            ComposerKt.sourceInformation(composer4, "C168@7746L17:Snackbar.kt#jmzs0o");
                            if ((i18 & 81) == 16 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-929149933, i18, -1, "androidx.compose.material.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:168)");
                            }
                            TextKt.m1842Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer4, 0, 0, 131070);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer3, C.ENCODING_PCM_32BIT, 382);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }) : null, z422, shape422, j8, j7, f3, ComposableLambdaKt.composableLambda(startRestartGroup, -261845785, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$3
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i17) {
                    ComposerKt.sourceInformation(composer3, "C176@7900L26:Snackbar.kt#jmzs0o");
                    if ((i17 & 11) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-261845785, i17, -1, "androidx.compose.material.Snackbar.<anonymous> (Snackbar.kt:176)");
                    }
                    TextKt.m1842Text4IGK_g(SnackbarData.this.getMessage(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 0, 0, 131070);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composer2, i10 | (i3 & 896) | (i3 & 7168) | (i3 & i5) | (i9 & i3) | ((i3 >> 3) & i11), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier2;
            j9 = j5;
            z3 = z422;
            shape3 = shape422;
            j10 = j8;
            j11 = j7;
            f4 = f3;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 7168) == 0) {
        }
        if ((i & 57344) == 0) {
        }
        if ((i & 458752) == 0) {
        }
        if ((i & 3670016) == 0) {
        }
        i7 = i2 & 128;
        if (i7 != 0) {
        }
        i8 = i6;
        f2 = f;
        if ((i3 & 23967451) == 4793490) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i16 != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if ((i2 & 16) == 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if (i7 == 0) {
        }
        i9 = 458752;
        i10 = 12582912;
        i11 = i8;
        j8 = j6;
        i12 = 258660814;
        boolean z4222 = z2;
        Shape shape4222 = shape2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        final String actionLabel222 = snackbarData.getActionLabel();
        if (actionLabel222 == null) {
        }
        composer2 = startRestartGroup;
        m1764Snackbar7zSek6w(PaddingKt.m879padding3ABfNKs(modifier2, Dp.m6389constructorimpl(12)), actionLabel222 == null ? ComposableLambdaKt.composableLambda(startRestartGroup, 1843479216, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                invoke(composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer3, int i17) {
                ComposerKt.sourceInformation(composer3, "C166@7612L44,165@7560L219:Snackbar.kt#jmzs0o");
                if ((i17 & 11) == 2 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1843479216, i17, -1, "androidx.compose.material.Snackbar.<anonymous> (Snackbar.kt:165)");
                }
                ButtonColors m1577textButtonColorsRGew2ao = ButtonDefaults.INSTANCE.m1577textButtonColorsRGew2ao(0L, j5, 0L, composer3, 3072, 5);
                final SnackbarData snackbarData2 = snackbarData;
                Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1.1
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
                        SnackbarData.this.performAction();
                    }
                };
                final String str = actionLabel222;
                ButtonKt.TextButton(function0, null, false, null, null, null, null, m1577textButtonColorsRGew2ao, null, ComposableLambdaKt.composableLambda(composer3, -929149933, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer4, Integer num) {
                        invoke(rowScope, composer4, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RowScope rowScope, Composer composer4, int i18) {
                        ComposerKt.sourceInformation(composer4, "C168@7746L17:Snackbar.kt#jmzs0o");
                        if ((i18 & 81) == 16 && composer4.getSkipping()) {
                            composer4.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-929149933, i18, -1, "androidx.compose.material.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:168)");
                        }
                        TextKt.m1842Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer4, 0, 0, 131070);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer3, C.ENCODING_PCM_32BIT, 382);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }) : null, z4222, shape4222, j8, j7, f3, ComposableLambdaKt.composableLambda(startRestartGroup, -261845785, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$Snackbar$3
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                invoke(composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer3, int i17) {
                ComposerKt.sourceInformation(composer3, "C176@7900L26:Snackbar.kt#jmzs0o");
                if ((i17 & 11) == 2 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-261845785, i17, -1, "androidx.compose.material.Snackbar.<anonymous> (Snackbar.kt:176)");
                }
                TextKt.m1842Text4IGK_g(SnackbarData.this.getMessage(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 0, 0, 131070);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composer2, i10 | (i3 & 896) | (i3 & 7168) | (i3 & i5) | (i9 & i3) | ((i3 >> 3) & i11), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier2;
        j9 = j5;
        z3 = z4222;
        shape3 = shape4222;
        j10 = j8;
        j11 = j7;
        f4 = f3;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TextOnlySnackbar(final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(917397959);
        ComposerKt.sourceInformation(startRestartGroup, "C(TextOnlySnackbar)237@9969L1207:Snackbar.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(917397959, i2, -1, "androidx.compose.material.TextOnlySnackbar (Snackbar.kt:236)");
            }
            SnackbarKt$TextOnlySnackbar$2 snackbarKt$TextOnlySnackbar$2 = new MeasurePolicy() { // from class: androidx.compose.material.SnackbarKt$TextOnlySnackbar$2
                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* renamed from: measure-3p2s80s */
                public final MeasureResult mo355measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                    if (list.size() != 1) {
                        throw new IllegalArgumentException("text for Snackbar expected to have exactly only one child".toString());
                    }
                    final Placeable mo5333measureBRTryo0 = ((Measurable) CollectionsKt.first((List) list)).mo5333measureBRTryo0(j);
                    int i3 = mo5333measureBRTryo0.get(AlignmentLineKt.getFirstBaseline());
                    int i4 = mo5333measureBRTryo0.get(AlignmentLineKt.getLastBaseline());
                    if (i3 == Integer.MIN_VALUE) {
                        throw new IllegalArgumentException("No baselines for text".toString());
                    }
                    if (i4 == Integer.MIN_VALUE) {
                        throw new IllegalArgumentException("No baselines for text".toString());
                    }
                    final int max = Math.max(measureScope.mo624roundToPx0680j_4(i3 == i4 ? SnackbarKt.SnackbarMinHeightOneLine : SnackbarKt.SnackbarMinHeightTwoLines), mo5333measureBRTryo0.getHeight());
                    return MeasureScope.layout$default(measureScope, Constraints.m6345getMaxWidthimpl(j), max, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.SnackbarKt$TextOnlySnackbar$2.4
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
                            Placeable.PlacementScope.placeRelative$default(placementScope, mo5333measureBRTryo0, 0, (max - mo5333measureBRTryo0.getHeight()) / 2, 0.0f, 4, null);
                        }
                    }, 4, null);
                }
            };
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            Modifier.Companion companion = Modifier.INSTANCE;
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
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
            Updater.m3600setimpl(m3593constructorimpl, snackbarKt$TextOnlySnackbar$2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1987608289, "C238@9986L202:Snackbar.kt#jmzs0o");
            Modifier m880paddingVpY3zN4 = PaddingKt.m880paddingVpY3zN4(Modifier.INSTANCE, HorizontalSpacing, SnackbarVerticalPadding);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m880paddingVpY3zN4);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1159676023, "C244@10169L9:Snackbar.kt#jmzs0o");
            function2.invoke(startRestartGroup, Integer.valueOf(i2 & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
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
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$TextOnlySnackbar$3
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
                    SnackbarKt.TextOnlySnackbar(function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void NewLineButtonSnackbar(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1229075900);
        ComposerKt.sourceInformation(startRestartGroup, "C(NewLineButtonSnackbar)P(1)275@11304L476:Snackbar.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1229075900, i2, -1, "androidx.compose.material.NewLineButtonSnackbar (Snackbar.kt:274)");
            }
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            float f = HorizontalSpacing;
            float f2 = HorizontalSpacingButtonSide;
            Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(fillMaxWidth$default, f, 0.0f, f2, SeparateButtonExtraY, 2, null);
            startRestartGroup.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
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
            Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 276693656, "C79@3979L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 71171671, "C283@11547L171,287@11727L47:Snackbar.kt#jmzs0o");
            Modifier m883paddingqDBjuR0$default2 = PaddingKt.m883paddingqDBjuR0$default(androidx.compose.foundation.layout.AlignmentLineKt.m762paddingFromBaselineVpY3zN4(Modifier.INSTANCE, HeightToFirstLine, LongButtonVerticalOffset), 0.0f, 0.0f, f2, 0.0f, 11, null);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default2);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 683214619, "C286@11710L6:Snackbar.kt#jmzs0o");
            function2.invoke(startRestartGroup, Integer.valueOf(i2 & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            Modifier align = columnScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getEnd());
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(align);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 683214673, "C287@11764L8:Snackbar.kt#jmzs0o");
            function22.invoke(startRestartGroup, Integer.valueOf((i2 >> 3) & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$NewLineButtonSnackbar$2
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
                    SnackbarKt.NewLineButtonSnackbar(function2, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void OneRowSnackbar(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-534813202);
        ComposerKt.sourceInformation(startRestartGroup, "C(OneRowSnackbar)P(1)298@11955L2564:Snackbar.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-534813202, i2, -1, "androidx.compose.material.OneRowSnackbar (Snackbar.kt:295)");
            }
            Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(Modifier.INSTANCE, HorizontalSpacing, 0.0f, HorizontalSpacingButtonSide, 0.0f, 10, null);
            startRestartGroup.startReplaceableGroup(-1696415923);
            final String str = "action";
            final String str2 = "text";
            boolean changed = startRestartGroup.changed("action") | startRestartGroup.changed("text");
            MeasurePolicy rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new MeasurePolicy() { // from class: androidx.compose.material.SnackbarKt$OneRowSnackbar$2$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo355measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        float f;
                        float f2;
                        int i3;
                        float f3;
                        int max;
                        float f4;
                        MeasureScope measureScope2 = measureScope;
                        String str3 = str;
                        int size = list.size();
                        int i4 = 0;
                        int i5 = 0;
                        while (i5 < size) {
                            Measurable measurable = list.get(i5);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), str3)) {
                                long j2 = j;
                                final Placeable mo5333measureBRTryo0 = measurable.mo5333measureBRTryo0(j2);
                                int m6345getMaxWidthimpl = Constraints.m6345getMaxWidthimpl(j2) - mo5333measureBRTryo0.getWidth();
                                f = SnackbarKt.TextEndExtraSpacing;
                                int coerceAtLeast = RangesKt.coerceAtLeast(m6345getMaxWidthimpl - measureScope2.mo624roundToPx0680j_4(f), Constraints.m6347getMinWidthimpl(j2));
                                String str4 = str2;
                                int size2 = list.size();
                                int i6 = 0;
                                while (i6 < size2) {
                                    Measurable measurable2 = list.get(i6);
                                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), str4)) {
                                        final Placeable mo5333measureBRTryo02 = measurable2.mo5333measureBRTryo0(Constraints.m6336copyZbe2FdA$default(j2, 0, coerceAtLeast, 0, 0, 9, null));
                                        int i7 = mo5333measureBRTryo02.get(AlignmentLineKt.getFirstBaseline());
                                        if (i7 == Integer.MIN_VALUE) {
                                            throw new IllegalArgumentException("No baselines for text".toString());
                                        }
                                        int i8 = mo5333measureBRTryo02.get(AlignmentLineKt.getLastBaseline());
                                        if (i8 == Integer.MIN_VALUE) {
                                            throw new IllegalArgumentException("No baselines for text".toString());
                                        }
                                        boolean z = i7 == i8;
                                        final int m6345getMaxWidthimpl2 = Constraints.m6345getMaxWidthimpl(j) - mo5333measureBRTryo0.getWidth();
                                        if (z) {
                                            f4 = SnackbarKt.SnackbarMinHeightOneLine;
                                            max = Math.max(measureScope2.mo624roundToPx0680j_4(f4), mo5333measureBRTryo0.getHeight());
                                            i3 = (max - mo5333measureBRTryo02.getHeight()) / 2;
                                            int i9 = mo5333measureBRTryo0.get(AlignmentLineKt.getFirstBaseline());
                                            if (i9 != Integer.MIN_VALUE) {
                                                i4 = (i7 + i3) - i9;
                                            }
                                        } else {
                                            f2 = SnackbarKt.HeightToFirstLine;
                                            i3 = measureScope2.mo624roundToPx0680j_4(f2) - i7;
                                            f3 = SnackbarKt.SnackbarMinHeightTwoLines;
                                            max = Math.max(measureScope2.mo624roundToPx0680j_4(f3), mo5333measureBRTryo02.getHeight() + i3);
                                            i4 = (max - mo5333measureBRTryo0.getHeight()) / 2;
                                        }
                                        final int i10 = i4;
                                        final int i11 = i3;
                                        return MeasureScope.layout$default(measureScope2, Constraints.m6345getMaxWidthimpl(j), max, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.SnackbarKt$OneRowSnackbar$2$1.4
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
                                                Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, 0, i11, 0.0f, 4, null);
                                                Placeable.PlacementScope.placeRelative$default(placementScope, mo5333measureBRTryo0, m6345getMaxWidthimpl2, i10, 0.0f, 4, null);
                                            }
                                        }, 4, null);
                                    }
                                    i6++;
                                    measureScope2 = measureScope;
                                    j2 = j;
                                }
                                throw new NoSuchElementException("Collection contains no element matching the predicate.");
                            }
                            i5++;
                            measureScope2 = measureScope;
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -849178829, "C300@11985L86,301@12084L46:Snackbar.kt#jmzs0o");
            Modifier m881paddingVpY3zN4$default = PaddingKt.m881paddingVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, "text"), 0.0f, SnackbarVerticalPadding, 1, null);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m881paddingVpY3zN4$default);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -202240350, "C300@12063L6:Snackbar.kt#jmzs0o");
            function2.invoke(startRestartGroup, Integer.valueOf(i2 & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "action");
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(layoutId);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -202240293, "C301@12120L8:Snackbar.kt#jmzs0o");
            function22.invoke(startRestartGroup, Integer.valueOf((i2 >> 3) & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
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
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$OneRowSnackbar$3
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
                    SnackbarKt.OneRowSnackbar(function2, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    static {
        float f = 8;
        HorizontalSpacingButtonSide = Dp.m6389constructorimpl(f);
        TextEndExtraSpacing = Dp.m6389constructorimpl(f);
    }
}
