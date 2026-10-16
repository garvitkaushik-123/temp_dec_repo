package androidx.compose.material3;

import androidx.compose.foundation.layout.AlignmentLineKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.SnackbarTokens;
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
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
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
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: Snackbar.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001ae\u0010\n\u001a\u00020\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000e2\u0013\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001ag\u0010\u0018\u001a\u00020\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000e2\u0013\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0013\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0014H\u0003ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0017\u001aj\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u00142\b\b\u0002\u0010&\u001a\u00020\u00142\b\b\u0002\u0010'\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0007ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a\u0099\u0001\u0010\u001c\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020 2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u00142\b\b\u0002\u0010&\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\u0011\u0010*\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010,\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006-"}, d2 = {"ContainerMaxWidth", "Landroidx/compose/ui/unit/Dp;", "F", "HeightToFirstLine", "HorizontalSpacing", "HorizontalSpacingButtonSide", "LongButtonVerticalOffset", "SeparateButtonExtraY", "SnackbarVerticalPadding", "TextEndExtraSpacing", "NewLineButtonSnackbar", "", "text", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "action", "dismissAction", "actionTextStyle", "Landroidx/compose/ui/text/TextStyle;", "actionContentColor", "Landroidx/compose/ui/graphics/Color;", "dismissActionContentColor", "NewLineButtonSnackbar-kKq0p4A", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JJLandroidx/compose/runtime/Composer;I)V", "OneRowSnackbar", "actionTextColor", "dismissActionColor", "OneRowSnackbar-kKq0p4A", "Snackbar", "snackbarData", "Landroidx/compose/material3/SnackbarData;", "modifier", "Landroidx/compose/ui/Modifier;", "actionOnNewLine", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "contentColor", "actionColor", "Snackbar-sDKtq54", "(Landroidx/compose/material3/SnackbarData;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJJJJLandroidx/compose/runtime/Composer;II)V", "content", "Snackbar-eQBnUkQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/graphics/Shape;JJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SnackbarKt {
    private static final float HorizontalSpacingButtonSide;
    private static final float TextEndExtraSpacing;
    private static final float ContainerMaxWidth = Dp.m6389constructorimpl(600);
    private static final float HeightToFirstLine = Dp.m6389constructorimpl(30);
    private static final float HorizontalSpacing = Dp.m6389constructorimpl(16);
    private static final float SeparateButtonExtraY = Dp.m6389constructorimpl(2);
    private static final float SnackbarVerticalPadding = Dp.m6389constructorimpl(6);
    private static final float LongButtonVerticalOffset = Dp.m6389constructorimpl(12);

    /* JADX WARN: Removed duplicated region for block: B:102:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01a0  */
    /* renamed from: Snackbar-eQBnUkQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2549SnackbareQBnUkQ(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, boolean z, Shape shape, long j, long j2, long j3, long j4, final Function2<? super Composer, ? super Integer, Unit> function23, Composer composer, final int i, final int i2) {
        int i3;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int i5;
        boolean z2;
        Shape shape2;
        long j5;
        int i6;
        Modifier.Companion companion;
        Function2<? super Composer, ? super Integer, Unit> function26;
        boolean z3;
        Shape shape3;
        long j6;
        long j7;
        long j8;
        long j9;
        Modifier modifier2;
        Composer composer2;
        final boolean z4;
        final Shape shape4;
        final long j10;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final long j11;
        ScopeUpdateScope endRestartGroup;
        int i7;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(-1235788955);
        ComposerKt.sourceInformation(startRestartGroup, "C(Snackbar)P(8!1,6,2,9,3:c#ui.graphics.Color,5:c#ui.graphics.Color,1:c#ui.graphics.Color,7:c#ui.graphics.Color)101@4932L5,102@4984L5,103@5034L12,104@5097L18,105@5173L25,108@5244L1420:Snackbar.kt#uh7d8r");
        int i9 = i2 & 1;
        if (i9 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i10 = i2 & 2;
        if (i10 != 0) {
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
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    z2 = z;
                    i3 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                    if ((i & 24576) != 0) {
                        if ((i2 & 16) == 0) {
                            shape2 = shape;
                            if (startRestartGroup.changed(shape2)) {
                                i8 = 16384;
                                i3 |= i8;
                            }
                        } else {
                            shape2 = shape;
                        }
                        i8 = 8192;
                        i3 |= i8;
                    } else {
                        shape2 = shape;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            j5 = j;
                            if (startRestartGroup.changed(j5)) {
                                i7 = 131072;
                                i3 |= i7;
                            }
                        } else {
                            j5 = j;
                        }
                        i7 = 65536;
                        i3 |= i7;
                    } else {
                        j5 = j;
                    }
                    if ((i & 1572864) != 0) {
                        i6 = i9;
                        i3 |= ((i2 & 64) == 0 && startRestartGroup.changed(j2)) ? 1048576 : 524288;
                    } else {
                        i6 = i9;
                    }
                    if ((i & 12582912) == 0) {
                        i3 |= ((i2 & 128) == 0 && startRestartGroup.changed(j3)) ? 8388608 : 4194304;
                    }
                    if ((100663296 & i) == 0) {
                        i3 |= ((i2 & 256) == 0 && startRestartGroup.changed(j4)) ? 67108864 : 33554432;
                    }
                    if ((i2 & 512) == 0) {
                        i3 |= C.ENCODING_PCM_32BIT;
                    } else if ((i & C.ENCODING_PCM_32BIT) == 0) {
                        i3 |= startRestartGroup.changedInstance(function23) ? 536870912 : 268435456;
                        if ((i3 & 306783379) == 306783378 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                companion = i6 != 0 ? Modifier.INSTANCE : modifier;
                                if (i10 != 0) {
                                    function24 = null;
                                }
                                function26 = i4 == 0 ? function25 : null;
                                z3 = i5 != 0 ? false : z2;
                                if ((i2 & 16) != 0) {
                                    shape3 = SnackbarDefaults.INSTANCE.getShape(startRestartGroup, 6);
                                    i3 &= -57345;
                                } else {
                                    shape3 = shape2;
                                }
                                if ((i2 & 32) != 0) {
                                    j6 = SnackbarDefaults.INSTANCE.getColor(startRestartGroup, 6);
                                    i3 &= -458753;
                                } else {
                                    j6 = j5;
                                }
                                if ((i2 & 64) != 0) {
                                    j7 = SnackbarDefaults.INSTANCE.getContentColor(startRestartGroup, 6);
                                    i3 &= -3670017;
                                } else {
                                    j7 = j2;
                                }
                                if ((i2 & 128) != 0) {
                                    j8 = SnackbarDefaults.INSTANCE.getActionContentColor(startRestartGroup, 6);
                                    i3 = (-29360129) & i3;
                                } else {
                                    j8 = j3;
                                }
                                if ((i2 & 256) != 0) {
                                    j9 = SnackbarDefaults.INSTANCE.getDismissActionContentColor(startRestartGroup, 6);
                                    i3 &= -234881025;
                                } else {
                                    j9 = j4;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
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
                                companion = modifier;
                                j8 = j3;
                                j9 = j4;
                                function26 = function25;
                                z3 = z2;
                                shape3 = shape2;
                                j6 = j5;
                                j7 = j2;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1235788955, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:107)");
                            }
                            final boolean z5 = z3;
                            final Function2<? super Composer, ? super Integer, Unit> function28 = function24;
                            final long j12 = j8;
                            final Function2<? super Composer, ? super Integer, Unit> function29 = function26;
                            final long j13 = j9;
                            int i11 = (i3 & 14) | 12779520;
                            int i12 = i3 >> 9;
                            Modifier modifier3 = companion;
                            SurfaceKt.m2633SurfaceT9BRK9s(modifier3, shape3, j6, j7, 0.0f, SnackbarTokens.INSTANCE.m3453getContainerElevationD9Ej5fM(), null, ComposableLambdaKt.composableLambda(startRestartGroup, -1829663446, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1
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

                                public final void invoke(Composer composer3, int i13) {
                                    ComposerKt.sourceInformation(composer3, "C115@5480L10,116@5580L10,117@5645L1013:Snackbar.kt#uh7d8r");
                                    if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1829663446, i13, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:115)");
                                        }
                                        TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer3, 6), SnackbarTokens.INSTANCE.getSupportingTextFont());
                                        final TextStyle fromToken2 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer3, 6), SnackbarTokens.INSTANCE.getActionLabelTextFont());
                                        ProvidedValue<TextStyle> provides = TextKt.getLocalTextStyle().provides(fromToken);
                                        final Function2<Composer, Integer, Unit> function210 = function28;
                                        final Function2<Composer, Integer, Unit> function211 = function23;
                                        final Function2<Composer, Integer, Unit> function212 = function29;
                                        final long j14 = j12;
                                        final long j15 = j13;
                                        final boolean z6 = z5;
                                        CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer3, 835891690, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1.1
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

                                            public final void invoke(Composer composer4, int i14) {
                                                ComposerKt.sourceInformation(composer4, "C:Snackbar.kt#uh7d8r");
                                                if ((i14 & 3) != 2 || !composer4.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(835891690, i14, -1, "androidx.compose.material3.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:118)");
                                                    }
                                                    if (function210 == null) {
                                                        composer4.startReplaceableGroup(-2104362406);
                                                        ComposerKt.sourceInformation(composer4, "119@5760L278");
                                                        SnackbarKt.m2548OneRowSnackbarkKq0p4A(function211, null, function212, fromToken2, j14, j15, composer4, 48);
                                                        composer4.endReplaceableGroup();
                                                    } else if (z6) {
                                                        composer4.startReplaceableGroup(-2104362092);
                                                        ComposerKt.sourceInformation(composer4, "127@6074L255");
                                                        SnackbarKt.m2547NewLineButtonSnackbarkKq0p4A(function211, function210, function212, fromToken2, j14, j15, composer4, 0);
                                                        composer4.endReplaceableGroup();
                                                    } else {
                                                        composer4.startReplaceableGroup(-2104361812);
                                                        ComposerKt.sourceInformation(composer4, "135@6354L280");
                                                        SnackbarKt.m2548OneRowSnackbarkKq0p4A(function211, function210, function212, fromToken2, j14, j15, composer4, 0);
                                                        composer4.endReplaceableGroup();
                                                    }
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
                            }), startRestartGroup, (i12 & 7168) | i11 | (i12 & 112) | (i12 & 896), 80);
                            modifier2 = modifier3;
                            composer2 = startRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z4 = z3;
                            shape4 = shape3;
                            j10 = j7;
                            function27 = function26;
                            j11 = j9;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            j8 = j3;
                            composer2 = startRestartGroup;
                            function27 = function25;
                            z4 = z2;
                            shape4 = shape2;
                            j6 = j5;
                            modifier2 = modifier;
                            j10 = j2;
                            j11 = j4;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Modifier modifier4 = modifier2;
                            final Function2<? super Composer, ? super Integer, Unit> function210 = function24;
                            final long j14 = j6;
                            final long j15 = j8;
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$2
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

                                public final void invoke(Composer composer3, int i13) {
                                    SnackbarKt.m2549SnackbareQBnUkQ(Modifier.this, function210, function27, z4, shape4, j14, j10, j15, j11, function23, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i3 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i4 == 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if ((i2 & 64) != 0) {
                    }
                    if ((i2 & 128) != 0) {
                    }
                    if ((i2 & 256) != 0) {
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    final boolean z52 = z3;
                    final Function2<? super Composer, ? super Integer, Unit> function282 = function24;
                    final long j122 = j8;
                    final Function2<? super Composer, ? super Integer, Unit> function292 = function26;
                    final long j132 = j9;
                    int i112 = (i3 & 14) | 12779520;
                    int i122 = i3 >> 9;
                    Modifier modifier32 = companion;
                    SurfaceKt.m2633SurfaceT9BRK9s(modifier32, shape3, j6, j7, 0.0f, SnackbarTokens.INSTANCE.m3453getContainerElevationD9Ej5fM(), null, ComposableLambdaKt.composableLambda(startRestartGroup, -1829663446, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1
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

                        public final void invoke(Composer composer3, int i13) {
                            ComposerKt.sourceInformation(composer3, "C115@5480L10,116@5580L10,117@5645L1013:Snackbar.kt#uh7d8r");
                            if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1829663446, i13, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:115)");
                                }
                                TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer3, 6), SnackbarTokens.INSTANCE.getSupportingTextFont());
                                final TextStyle fromToken2 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer3, 6), SnackbarTokens.INSTANCE.getActionLabelTextFont());
                                ProvidedValue<TextStyle> provides = TextKt.getLocalTextStyle().provides(fromToken);
                                final Function2<? super Composer, ? super Integer, Unit> function2102 = function282;
                                final Function2<? super Composer, ? super Integer, Unit> function211 = function23;
                                final Function2<? super Composer, ? super Integer, Unit> function212 = function292;
                                final long j142 = j122;
                                final long j152 = j132;
                                final boolean z6 = z52;
                                CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer3, 835891690, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1.1
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

                                    public final void invoke(Composer composer4, int i14) {
                                        ComposerKt.sourceInformation(composer4, "C:Snackbar.kt#uh7d8r");
                                        if ((i14 & 3) != 2 || !composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(835891690, i14, -1, "androidx.compose.material3.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:118)");
                                            }
                                            if (function2102 == null) {
                                                composer4.startReplaceableGroup(-2104362406);
                                                ComposerKt.sourceInformation(composer4, "119@5760L278");
                                                SnackbarKt.m2548OneRowSnackbarkKq0p4A(function211, null, function212, fromToken2, j142, j152, composer4, 48);
                                                composer4.endReplaceableGroup();
                                            } else if (z6) {
                                                composer4.startReplaceableGroup(-2104362092);
                                                ComposerKt.sourceInformation(composer4, "127@6074L255");
                                                SnackbarKt.m2547NewLineButtonSnackbarkKq0p4A(function211, function2102, function212, fromToken2, j142, j152, composer4, 0);
                                                composer4.endReplaceableGroup();
                                            } else {
                                                composer4.startReplaceableGroup(-2104361812);
                                                ComposerKt.sourceInformation(composer4, "135@6354L280");
                                                SnackbarKt.m2548OneRowSnackbarkKq0p4A(function211, function2102, function212, fromToken2, j142, j152, composer4, 0);
                                                composer4.endReplaceableGroup();
                                            }
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
                    }), startRestartGroup, (i122 & 7168) | i112 | (i122 & 112) | (i122 & 896), 80);
                    modifier2 = modifier32;
                    composer2 = startRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    z4 = z3;
                    shape4 = shape3;
                    j10 = j7;
                    function27 = function26;
                    j11 = j9;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                z2 = z;
                if ((i & 24576) != 0) {
                }
                if ((196608 & i) != 0) {
                }
                if ((i & 1572864) != 0) {
                }
                if ((i & 12582912) == 0) {
                }
                if ((100663296 & i) == 0) {
                }
                if ((i2 & 512) == 0) {
                }
                if ((i3 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i6 != 0) {
                }
                if (i10 != 0) {
                }
                if (i4 == 0) {
                }
                if (i5 != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if ((i2 & 64) != 0) {
                }
                if ((i2 & 128) != 0) {
                }
                if ((i2 & 256) != 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                final boolean z522 = z3;
                final Function2<? super Composer, ? super Integer, Unit> function2822 = function24;
                final long j1222 = j8;
                final Function2<? super Composer, ? super Integer, Unit> function2922 = function26;
                final long j1322 = j9;
                int i1122 = (i3 & 14) | 12779520;
                int i1222 = i3 >> 9;
                Modifier modifier322 = companion;
                SurfaceKt.m2633SurfaceT9BRK9s(modifier322, shape3, j6, j7, 0.0f, SnackbarTokens.INSTANCE.m3453getContainerElevationD9Ej5fM(), null, ComposableLambdaKt.composableLambda(startRestartGroup, -1829663446, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1
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

                    public final void invoke(Composer composer3, int i13) {
                        ComposerKt.sourceInformation(composer3, "C115@5480L10,116@5580L10,117@5645L1013:Snackbar.kt#uh7d8r");
                        if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1829663446, i13, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:115)");
                            }
                            TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer3, 6), SnackbarTokens.INSTANCE.getSupportingTextFont());
                            final TextStyle fromToken2 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer3, 6), SnackbarTokens.INSTANCE.getActionLabelTextFont());
                            ProvidedValue<TextStyle> provides = TextKt.getLocalTextStyle().provides(fromToken);
                            final Function2<? super Composer, ? super Integer, Unit> function2102 = function2822;
                            final Function2<? super Composer, ? super Integer, Unit> function211 = function23;
                            final Function2<? super Composer, ? super Integer, Unit> function212 = function2922;
                            final long j142 = j1222;
                            final long j152 = j1322;
                            final boolean z6 = z522;
                            CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer3, 835891690, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1.1
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

                                public final void invoke(Composer composer4, int i14) {
                                    ComposerKt.sourceInformation(composer4, "C:Snackbar.kt#uh7d8r");
                                    if ((i14 & 3) != 2 || !composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(835891690, i14, -1, "androidx.compose.material3.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:118)");
                                        }
                                        if (function2102 == null) {
                                            composer4.startReplaceableGroup(-2104362406);
                                            ComposerKt.sourceInformation(composer4, "119@5760L278");
                                            SnackbarKt.m2548OneRowSnackbarkKq0p4A(function211, null, function212, fromToken2, j142, j152, composer4, 48);
                                            composer4.endReplaceableGroup();
                                        } else if (z6) {
                                            composer4.startReplaceableGroup(-2104362092);
                                            ComposerKt.sourceInformation(composer4, "127@6074L255");
                                            SnackbarKt.m2547NewLineButtonSnackbarkKq0p4A(function211, function2102, function212, fromToken2, j142, j152, composer4, 0);
                                            composer4.endReplaceableGroup();
                                        } else {
                                            composer4.startReplaceableGroup(-2104361812);
                                            ComposerKt.sourceInformation(composer4, "135@6354L280");
                                            SnackbarKt.m2548OneRowSnackbarkKq0p4A(function211, function2102, function212, fromToken2, j142, j152, composer4, 0);
                                            composer4.endReplaceableGroup();
                                        }
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
                }), startRestartGroup, (i1222 & 7168) | i1122 | (i1222 & 112) | (i1222 & 896), 80);
                modifier2 = modifier322;
                composer2 = startRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                }
                z4 = z3;
                shape4 = shape3;
                j10 = j7;
                function27 = function26;
                j11 = j9;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function25 = function22;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            z2 = z;
            if ((i & 24576) != 0) {
            }
            if ((196608 & i) != 0) {
            }
            if ((i & 1572864) != 0) {
            }
            if ((i & 12582912) == 0) {
            }
            if ((100663296 & i) == 0) {
            }
            if ((i2 & 512) == 0) {
            }
            if ((i3 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i6 != 0) {
            }
            if (i10 != 0) {
            }
            if (i4 == 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if ((i2 & 64) != 0) {
            }
            if ((i2 & 128) != 0) {
            }
            if ((i2 & 256) != 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            final boolean z5222 = z3;
            final Function2<? super Composer, ? super Integer, Unit> function28222 = function24;
            final long j12222 = j8;
            final Function2<? super Composer, ? super Integer, Unit> function29222 = function26;
            final long j13222 = j9;
            int i11222 = (i3 & 14) | 12779520;
            int i12222 = i3 >> 9;
            Modifier modifier3222 = companion;
            SurfaceKt.m2633SurfaceT9BRK9s(modifier3222, shape3, j6, j7, 0.0f, SnackbarTokens.INSTANCE.m3453getContainerElevationD9Ej5fM(), null, ComposableLambdaKt.composableLambda(startRestartGroup, -1829663446, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1
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

                public final void invoke(Composer composer3, int i13) {
                    ComposerKt.sourceInformation(composer3, "C115@5480L10,116@5580L10,117@5645L1013:Snackbar.kt#uh7d8r");
                    if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1829663446, i13, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:115)");
                        }
                        TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer3, 6), SnackbarTokens.INSTANCE.getSupportingTextFont());
                        final TextStyle fromToken2 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer3, 6), SnackbarTokens.INSTANCE.getActionLabelTextFont());
                        ProvidedValue<TextStyle> provides = TextKt.getLocalTextStyle().provides(fromToken);
                        final Function2<? super Composer, ? super Integer, Unit> function2102 = function28222;
                        final Function2<? super Composer, ? super Integer, Unit> function211 = function23;
                        final Function2<? super Composer, ? super Integer, Unit> function212 = function29222;
                        final long j142 = j12222;
                        final long j152 = j13222;
                        final boolean z6 = z5222;
                        CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer3, 835891690, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1.1
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

                            public final void invoke(Composer composer4, int i14) {
                                ComposerKt.sourceInformation(composer4, "C:Snackbar.kt#uh7d8r");
                                if ((i14 & 3) != 2 || !composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(835891690, i14, -1, "androidx.compose.material3.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:118)");
                                    }
                                    if (function2102 == null) {
                                        composer4.startReplaceableGroup(-2104362406);
                                        ComposerKt.sourceInformation(composer4, "119@5760L278");
                                        SnackbarKt.m2548OneRowSnackbarkKq0p4A(function211, null, function212, fromToken2, j142, j152, composer4, 48);
                                        composer4.endReplaceableGroup();
                                    } else if (z6) {
                                        composer4.startReplaceableGroup(-2104362092);
                                        ComposerKt.sourceInformation(composer4, "127@6074L255");
                                        SnackbarKt.m2547NewLineButtonSnackbarkKq0p4A(function211, function2102, function212, fromToken2, j142, j152, composer4, 0);
                                        composer4.endReplaceableGroup();
                                    } else {
                                        composer4.startReplaceableGroup(-2104361812);
                                        ComposerKt.sourceInformation(composer4, "135@6354L280");
                                        SnackbarKt.m2548OneRowSnackbarkKq0p4A(function211, function2102, function212, fromToken2, j142, j152, composer4, 0);
                                        composer4.endReplaceableGroup();
                                    }
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
            }), startRestartGroup, (i12222 & 7168) | i11222 | (i12222 & 112) | (i12222 & 896), 80);
            modifier2 = modifier3222;
            composer2 = startRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
            }
            z4 = z3;
            shape4 = shape3;
            j10 = j7;
            function27 = function26;
            j11 = j9;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        function24 = function2;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        function25 = function22;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        z2 = z;
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        if ((i & 1572864) != 0) {
        }
        if ((i & 12582912) == 0) {
        }
        if ((100663296 & i) == 0) {
        }
        if ((i2 & 512) == 0) {
        }
        if ((i3 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i6 != 0) {
        }
        if (i10 != 0) {
        }
        if (i4 == 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if ((i2 & 128) != 0) {
        }
        if ((i2 & 256) != 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        final boolean z52222 = z3;
        final Function2<? super Composer, ? super Integer, Unit> function282222 = function24;
        final long j122222 = j8;
        final Function2<? super Composer, ? super Integer, Unit> function292222 = function26;
        final long j132222 = j9;
        int i112222 = (i3 & 14) | 12779520;
        int i122222 = i3 >> 9;
        Modifier modifier32222 = companion;
        SurfaceKt.m2633SurfaceT9BRK9s(modifier32222, shape3, j6, j7, 0.0f, SnackbarTokens.INSTANCE.m3453getContainerElevationD9Ej5fM(), null, ComposableLambdaKt.composableLambda(startRestartGroup, -1829663446, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1
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

            public final void invoke(Composer composer3, int i13) {
                ComposerKt.sourceInformation(composer3, "C115@5480L10,116@5580L10,117@5645L1013:Snackbar.kt#uh7d8r");
                if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1829663446, i13, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:115)");
                    }
                    TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer3, 6), SnackbarTokens.INSTANCE.getSupportingTextFont());
                    final TextStyle fromToken2 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer3, 6), SnackbarTokens.INSTANCE.getActionLabelTextFont());
                    ProvidedValue<TextStyle> provides = TextKt.getLocalTextStyle().provides(fromToken);
                    final Function2<? super Composer, ? super Integer, Unit> function2102 = function282222;
                    final Function2<? super Composer, ? super Integer, Unit> function211 = function23;
                    final Function2<? super Composer, ? super Integer, Unit> function212 = function292222;
                    final long j142 = j122222;
                    final long j152 = j132222;
                    final boolean z6 = z52222;
                    CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer3, 835891690, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$1.1
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

                        public final void invoke(Composer composer4, int i14) {
                            ComposerKt.sourceInformation(composer4, "C:Snackbar.kt#uh7d8r");
                            if ((i14 & 3) != 2 || !composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(835891690, i14, -1, "androidx.compose.material3.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:118)");
                                }
                                if (function2102 == null) {
                                    composer4.startReplaceableGroup(-2104362406);
                                    ComposerKt.sourceInformation(composer4, "119@5760L278");
                                    SnackbarKt.m2548OneRowSnackbarkKq0p4A(function211, null, function212, fromToken2, j142, j152, composer4, 48);
                                    composer4.endReplaceableGroup();
                                } else if (z6) {
                                    composer4.startReplaceableGroup(-2104362092);
                                    ComposerKt.sourceInformation(composer4, "127@6074L255");
                                    SnackbarKt.m2547NewLineButtonSnackbarkKq0p4A(function211, function2102, function212, fromToken2, j142, j152, composer4, 0);
                                    composer4.endReplaceableGroup();
                                } else {
                                    composer4.startReplaceableGroup(-2104361812);
                                    ComposerKt.sourceInformation(composer4, "135@6354L280");
                                    SnackbarKt.m2548OneRowSnackbarkKq0p4A(function211, function2102, function212, fromToken2, j142, j152, composer4, 0);
                                    composer4.endReplaceableGroup();
                                }
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
        }), startRestartGroup, (i122222 & 7168) | i112222 | (i122222 & 112) | (i122222 & 896), 80);
        modifier2 = modifier32222;
        composer2 = startRestartGroup;
        if (ComposerKt.isTraceInProgress()) {
        }
        z4 = z3;
        shape4 = shape3;
        j10 = j7;
        function27 = function26;
        j11 = j9;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0221  */
    /* renamed from: Snackbar-sDKtq54, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2550SnackbarsDKtq54(final SnackbarData snackbarData, Modifier modifier, boolean z, Shape shape, long j, long j2, long j3, long j4, long j5, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        Shape shape2;
        long j6;
        long j7;
        int i5;
        int i6;
        final Modifier.Companion companion;
        Shape shape3;
        long j8;
        long j9;
        long j10;
        long j11;
        long j12;
        long j13;
        final long j14;
        long j15;
        boolean z3;
        Shape shape4;
        long j16;
        Composer composer2;
        final long j17;
        final boolean z4;
        final Shape shape5;
        final long j18;
        final long j19;
        final long j20;
        final long j21;
        ScopeUpdateScope endRestartGroup;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        Composer startRestartGroup = composer.startRestartGroup(274621471);
        ComposerKt.sourceInformation(startRestartGroup, "C(Snackbar)P(8,6,2,7,3:c#ui.graphics.Color,4:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,5:c#ui.graphics.Color)203@9555L5,204@9607L5,205@9657L12,206@9713L11,207@9775L18,208@9851L25,238@10864L456:Snackbar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(snackbarData) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i12 = i2 & 2;
        if (i12 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 256 : 128;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        shape2 = shape;
                        if (startRestartGroup.changed(shape2)) {
                            i11 = 2048;
                            i3 |= i11;
                        }
                    } else {
                        shape2 = shape;
                    }
                    i11 = 1024;
                    i3 |= i11;
                } else {
                    shape2 = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        j6 = j;
                        if (startRestartGroup.changed(j6)) {
                            i10 = 16384;
                            i3 |= i10;
                        }
                    } else {
                        j6 = j;
                    }
                    i10 = 8192;
                    i3 |= i10;
                } else {
                    j6 = j;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        j7 = j2;
                        if (startRestartGroup.changed(j7)) {
                            i9 = 131072;
                            i3 |= i9;
                        }
                    } else {
                        j7 = j2;
                    }
                    i9 = 65536;
                    i3 |= i9;
                } else {
                    j7 = j2;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        i7 = i3;
                        i6 = i12;
                        if (startRestartGroup.changed(j3)) {
                            i8 = 1048576;
                            i5 = i7 | i8;
                        }
                    } else {
                        i7 = i3;
                        i6 = i12;
                    }
                    i8 = 524288;
                    i5 = i7 | i8;
                } else {
                    i5 = i3;
                    i6 = i12;
                }
                if ((i & 12582912) == 0) {
                    i5 |= ((i2 & 128) == 0 && startRestartGroup.changed(j4)) ? 8388608 : 4194304;
                }
                if ((100663296 & i) == 0) {
                    i5 |= ((i2 & 256) == 0 && startRestartGroup.changed(j5)) ? 67108864 : 33554432;
                }
                if ((38347923 & i5) == 38347922 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        companion = i6 != 0 ? Modifier.INSTANCE : modifier2;
                        boolean z5 = i4 != 0 ? false : z2;
                        if ((i2 & 8) != 0) {
                            shape3 = SnackbarDefaults.INSTANCE.getShape(startRestartGroup, 6);
                            i5 &= -7169;
                        } else {
                            shape3 = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            j8 = SnackbarDefaults.INSTANCE.getColor(startRestartGroup, 6);
                            i5 &= -57345;
                        } else {
                            j8 = j6;
                        }
                        if ((i2 & 32) != 0) {
                            j9 = SnackbarDefaults.INSTANCE.getContentColor(startRestartGroup, 6);
                            i5 &= -458753;
                        } else {
                            j9 = j7;
                        }
                        if ((i2 & 64) != 0) {
                            j10 = SnackbarDefaults.INSTANCE.getActionColor(startRestartGroup, 6);
                            i5 &= -3670017;
                        } else {
                            j10 = j3;
                        }
                        if ((i2 & 128) != 0) {
                            j11 = SnackbarDefaults.INSTANCE.getActionContentColor(startRestartGroup, 6);
                            i5 = (-29360129) & i5;
                        } else {
                            j11 = j4;
                        }
                        if ((i2 & 256) != 0) {
                            i5 &= -234881025;
                            j14 = j10;
                            j15 = j11;
                            j12 = SnackbarDefaults.INSTANCE.getDismissActionContentColor(startRestartGroup, 6);
                            z3 = z5;
                            shape4 = shape3;
                            j16 = j8;
                            j13 = j9;
                        } else {
                            j12 = j5;
                            j13 = j9;
                            j14 = j10;
                            j15 = j11;
                            z3 = z5;
                            shape4 = shape3;
                            j16 = j8;
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i2 & 8) != 0) {
                            i5 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i5 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            i5 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            i5 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            i5 &= -29360129;
                        }
                        if ((i2 & 256) != 0) {
                            i5 &= -234881025;
                        }
                        j14 = j3;
                        j15 = j4;
                        j12 = j5;
                        companion = modifier2;
                        z3 = z2;
                        shape4 = shape2;
                        j16 = j6;
                        j13 = j7;
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(274621471, i5, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:209)");
                    }
                    final String actionLabel = snackbarData.getVisuals().getActionLabel();
                    ComposableLambda composableLambda = actionLabel != null ? ComposableLambdaKt.composableLambda(startRestartGroup, -1378313599, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i13) {
                            ComposerKt.sourceInformation(composer3, "C214@10104L44,215@10176L32,213@10052L219:Snackbar.kt#uh7d8r");
                            if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1378313599, i13, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:213)");
                                }
                                ButtonColors m1934textButtonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1934textButtonColorsro_MJ88(0L, j14, 0L, 0L, composer3, 24576, 13);
                                composer3.startReplaceableGroup(-2057496839);
                                ComposerKt.sourceInformation(composer3, "CC(remember):Snackbar.kt#9igjgp");
                                boolean changed = composer3.changed(snackbarData);
                                final SnackbarData snackbarData2 = snackbarData;
                                Object rememberedValue = composer3.rememberedValue();
                                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1$1$1
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
                                    composer3.updateRememberedValue(rememberedValue);
                                }
                                Function0 function0 = (Function0) rememberedValue;
                                composer3.endReplaceableGroup();
                                final String str = actionLabel;
                                ButtonKt.TextButton(function0, null, false, null, m1934textButtonColorsro_MJ88, null, null, null, null, ComposableLambdaKt.composableLambda(composer3, 521110564, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer4, Integer num) {
                                        invoke(rowScope, composer4, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(RowScope rowScope, Composer composer4, int i14) {
                                        ComposerKt.sourceInformation(composer4, "C216@10238L17:Snackbar.kt#uh7d8r");
                                        if ((i14 & 17) == 16 && composer4.getSkipping()) {
                                            composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(521110564, i14, -1, "androidx.compose.material3.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:216)");
                                        }
                                        TextKt.m2781Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer4, 0, 0, 131070);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), composer3, C.ENCODING_PCM_32BIT, 494);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }) : null;
                    int i13 = i5 << 3;
                    composer2 = startRestartGroup;
                    m2549SnackbareQBnUkQ(PaddingKt.m879padding3ABfNKs(companion, Dp.m6389constructorimpl(12)), composableLambda, snackbarData.getVisuals().getWithDismissAction() ? ComposableLambdaKt.composableLambda(startRestartGroup, -1812633777, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$dismissActionComposable$1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i14) {
                            ComposerKt.sourceInformation(composer3, "C226@10513L26,225@10471L330:Snackbar.kt#uh7d8r");
                            if ((i14 & 3) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1812633777, i14, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:225)");
                                }
                                composer3.startReplaceableGroup(-2057496502);
                                ComposerKt.sourceInformation(composer3, "CC(remember):Snackbar.kt#9igjgp");
                                boolean changed = composer3.changed(SnackbarData.this);
                                final SnackbarData snackbarData2 = SnackbarData.this;
                                Object rememberedValue = composer3.rememberedValue();
                                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$dismissActionComposable$1$1$1
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
                                            SnackbarData.this.dismiss();
                                        }
                                    };
                                    composer3.updateRememberedValue(rememberedValue);
                                }
                                composer3.endReplaceableGroup();
                                IconButtonKt.IconButton((Function0) rememberedValue, null, false, null, null, ComposableSingletons$SnackbarKt.INSTANCE.m2091getLambda1$material3_release(), composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }) : null, z3, shape4, j16, j13, j15, j12, ComposableLambdaKt.composableLambda(startRestartGroup, -1266389126, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$3
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i14) {
                            ComposerKt.sourceInformation(composer3, "C248@11278L34:Snackbar.kt#uh7d8r");
                            if ((i14 & 3) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1266389126, i14, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:248)");
                            }
                            TextKt.m2781Text4IGK_g(SnackbarData.this.getVisuals().getMessage(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 0, 0, 131070);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, (i13 & 3670016) | (i13 & 7168) | C.ENCODING_PCM_32BIT | (57344 & i13) | (458752 & i13) | (29360128 & i5) | (234881024 & i5), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j17 = j14;
                    z4 = z3;
                    shape5 = shape4;
                    j18 = j16;
                    j19 = j13;
                    j20 = j15;
                    j21 = j12;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    composer2 = startRestartGroup;
                    companion = modifier2;
                    z4 = z2;
                    shape5 = shape2;
                    j18 = j6;
                    j19 = j7;
                    j17 = j3;
                    j20 = j4;
                    j21 = j5;
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i14) {
                            SnackbarKt.m2550SnackbarsDKtq54(SnackbarData.this, companion, z4, shape5, j18, j19, j17, j20, j21, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            if ((196608 & i) == 0) {
            }
            if ((1572864 & i) == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            if ((100663296 & i) == 0) {
            }
            if ((38347923 & i5) == 38347922) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i6 != 0) {
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
            if ((i2 & 128) != 0) {
            }
            if ((i2 & 256) != 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            final String actionLabel2 = snackbarData.getVisuals().getActionLabel();
            if (actionLabel2 != null) {
            }
            int i132 = i5 << 3;
            composer2 = startRestartGroup;
            m2549SnackbareQBnUkQ(PaddingKt.m879padding3ABfNKs(companion, Dp.m6389constructorimpl(12)), composableLambda, snackbarData.getVisuals().getWithDismissAction() ? ComposableLambdaKt.composableLambda(startRestartGroup, -1812633777, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$dismissActionComposable$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i14) {
                    ComposerKt.sourceInformation(composer3, "C226@10513L26,225@10471L330:Snackbar.kt#uh7d8r");
                    if ((i14 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1812633777, i14, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:225)");
                        }
                        composer3.startReplaceableGroup(-2057496502);
                        ComposerKt.sourceInformation(composer3, "CC(remember):Snackbar.kt#9igjgp");
                        boolean changed = composer3.changed(SnackbarData.this);
                        final SnackbarData snackbarData2 = SnackbarData.this;
                        Object rememberedValue = composer3.rememberedValue();
                        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$dismissActionComposable$1$1$1
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
                                    SnackbarData.this.dismiss();
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue);
                        }
                        composer3.endReplaceableGroup();
                        IconButtonKt.IconButton((Function0) rememberedValue, null, false, null, null, ComposableSingletons$SnackbarKt.INSTANCE.m2091getLambda1$material3_release(), composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }) : null, z3, shape4, j16, j13, j15, j12, ComposableLambdaKt.composableLambda(startRestartGroup, -1266389126, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$3
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i14) {
                    ComposerKt.sourceInformation(composer3, "C248@11278L34:Snackbar.kt#uh7d8r");
                    if ((i14 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1266389126, i14, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:248)");
                    }
                    TextKt.m2781Text4IGK_g(SnackbarData.this.getVisuals().getMessage(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 0, 0, 131070);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composer2, (i132 & 3670016) | (i132 & 7168) | C.ENCODING_PCM_32BIT | (57344 & i132) | (458752 & i132) | (29360128 & i5) | (234881024 & i5), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            j17 = j14;
            z4 = z3;
            shape5 = shape4;
            j18 = j16;
            j19 = j13;
            j20 = j15;
            j21 = j12;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        if ((196608 & i) == 0) {
        }
        if ((1572864 & i) == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        if ((100663296 & i) == 0) {
        }
        if ((38347923 & i5) == 38347922) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i6 != 0) {
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
        if ((i2 & 128) != 0) {
        }
        if ((i2 & 256) != 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        final String actionLabel22 = snackbarData.getVisuals().getActionLabel();
        if (actionLabel22 != null) {
        }
        int i1322 = i5 << 3;
        composer2 = startRestartGroup;
        m2549SnackbareQBnUkQ(PaddingKt.m879padding3ABfNKs(companion, Dp.m6389constructorimpl(12)), composableLambda, snackbarData.getVisuals().getWithDismissAction() ? ComposableLambdaKt.composableLambda(startRestartGroup, -1812633777, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$dismissActionComposable$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                invoke(composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer3, int i14) {
                ComposerKt.sourceInformation(composer3, "C226@10513L26,225@10471L330:Snackbar.kt#uh7d8r");
                if ((i14 & 3) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1812633777, i14, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:225)");
                    }
                    composer3.startReplaceableGroup(-2057496502);
                    ComposerKt.sourceInformation(composer3, "CC(remember):Snackbar.kt#9igjgp");
                    boolean changed = composer3.changed(SnackbarData.this);
                    final SnackbarData snackbarData2 = SnackbarData.this;
                    Object rememberedValue = composer3.rememberedValue();
                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$dismissActionComposable$1$1$1
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
                                SnackbarData.this.dismiss();
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue);
                    }
                    composer3.endReplaceableGroup();
                    IconButtonKt.IconButton((Function0) rememberedValue, null, false, null, null, ComposableSingletons$SnackbarKt.INSTANCE.m2091getLambda1$material3_release(), composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }) : null, z3, shape4, j16, j13, j15, j12, ComposableLambdaKt.composableLambda(startRestartGroup, -1266389126, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$3
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                invoke(composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer3, int i14) {
                ComposerKt.sourceInformation(composer3, "C248@11278L34:Snackbar.kt#uh7d8r");
                if ((i14 & 3) == 2 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1266389126, i14, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:248)");
                }
                TextKt.m2781Text4IGK_g(SnackbarData.this.getVisuals().getMessage(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 0, 0, 131070);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composer2, (i1322 & 3670016) | (i1322 & 7168) | C.ENCODING_PCM_32BIT | (57344 & i1322) | (458752 & i1322) | (29360128 & i5) | (234881024 & i5), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        j17 = j14;
        z4 = z3;
        shape5 = shape4;
        j18 = j16;
        j19 = j13;
        j20 = j15;
        j21 = j12;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: NewLineButtonSnackbar-kKq0p4A, reason: not valid java name */
    public static final void m2547NewLineButtonSnackbarkKq0p4A(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final TextStyle textStyle, final long j, final long j2, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1332496681);
        ComposerKt.sourceInformation(startRestartGroup, "C(NewLineButtonSnackbar)P(5!1,3,2,1:c#ui.graphics.Color,4:c#ui.graphics.Color)261@11595L1173:Snackbar.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function23) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(textStyle) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changed(j) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changed(j2) ? 131072 : 65536;
        }
        if ((74899 & i2) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1332496681, i2, -1, "androidx.compose.material3.NewLineButtonSnackbar (Snackbar.kt:260)");
            }
            Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(SizeKt.m935widthInVpY3zN4$default(Modifier.INSTANCE, 0.0f, ContainerMaxWidth, 1, null), 0.0f, 1, null), HorizontalSpacing, 0.0f, 0.0f, SeparateButtonExtraY, 6, null);
            startRestartGroup.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
            int i3 = i2;
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -916592009, "C271@11902L171,276@12083L679:Snackbar.kt#uh7d8r");
            Modifier m762paddingFromBaselineVpY3zN4 = AlignmentLineKt.m762paddingFromBaselineVpY3zN4(Modifier.INSTANCE, HeightToFirstLine, LongButtonVerticalOffset);
            float f = HorizontalSpacingButtonSide;
            Modifier m883paddingqDBjuR0$default2 = PaddingKt.m883paddingqDBjuR0$default(m762paddingFromBaselineVpY3zN4, 0.0f, 0.0f, f, 0.0f, 11, null);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 302366651, "C274@12065L6:Snackbar.kt#uh7d8r");
            function2.invoke(startRestartGroup, Integer.valueOf(i3 & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            Modifier align = columnScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getEnd());
            if (function23 != null) {
                f = Dp.m6389constructorimpl(0);
            }
            Modifier m883paddingqDBjuR0$default3 = PaddingKt.m883paddingqDBjuR0$default(align, 0.0f, 0.0f, f, 0.0f, 11, null);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default3);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 302366837, "C280@12251L501:Snackbar.kt#uh7d8r");
            startRestartGroup.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(companion);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor4);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3593constructorimpl4 = Updater.m3593constructorimpl(startRestartGroup);
            Updater.m3600setimpl(m3593constructorimpl4, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3593constructorimpl4.getInserting() || !Intrinsics.areEqual(m3593constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                m3593constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                m3593constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            modifierMaterializerOf4.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326681643, "C92@4661L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 435596204, "C281@12273L208:Snackbar.kt#uh7d8r");
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(j)), TextKt.getLocalTextStyle().provides(textStyle)}, function22, startRestartGroup, i3 & 112);
            startRestartGroup.startReplaceableGroup(302367084);
            ComposerKt.sourceInformation(startRestartGroup, "287@12547L173");
            if (function23 != null) {
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(j2)), function23, startRestartGroup, ProvidedValue.$stable | ((i3 >> 3) & 112));
            }
            startRestartGroup.endReplaceableGroup();
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
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$NewLineButtonSnackbar$2
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

                public final void invoke(Composer composer2, int i4) {
                    SnackbarKt.m2547NewLineButtonSnackbarkKq0p4A(function2, function22, function23, textStyle, j, j2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OneRowSnackbar-kKq0p4A, reason: not valid java name */
    public static final void m2548OneRowSnackbarkKq0p4A(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final TextStyle textStyle, final long j, final long j2, Composer composer, final int i) {
        int i2;
        float m6389constructorimpl;
        Composer startRestartGroup = composer.startRestartGroup(-903235475);
        ComposerKt.sourceInformation(startRestartGroup, "C(OneRowSnackbar)P(5!1,3,2,1:c#ui.graphics.Color,4:c#ui.graphics.Color)334@14108L3465,309@13126L4447:Snackbar.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function23) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(textStyle) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changed(j) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changed(j2) ? 131072 : 65536;
        }
        if ((74899 & i2) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-903235475, i2, -1, "androidx.compose.material3.OneRowSnackbar (Snackbar.kt:305)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            float f = HorizontalSpacing;
            if (function23 == null) {
                m6389constructorimpl = HorizontalSpacingButtonSide;
            } else {
                m6389constructorimpl = Dp.m6389constructorimpl(0);
            }
            Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(companion, f, 0.0f, m6389constructorimpl, 0.0f, 10, null);
            startRestartGroup.startReplaceableGroup(44739392);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Snackbar.kt#9igjgp");
            MeasurePolicy rememberedValue = startRestartGroup.rememberedValue();
            final String str = "text";
            final String str2 = "action";
            int i3 = i2;
            final String str3 = "dismissAction";
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new MeasurePolicy() { // from class: androidx.compose.material3.SnackbarKt$OneRowSnackbar$2$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo355measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j3) {
                        float f2;
                        Measurable measurable;
                        Measurable measurable2;
                        int i4;
                        float f3;
                        int i5;
                        int max;
                        int height;
                        int i6;
                        float f4;
                        MeasureScope measureScope2 = measureScope;
                        int m6345getMaxWidthimpl = Constraints.m6345getMaxWidthimpl(j3);
                        f2 = SnackbarKt.ContainerMaxWidth;
                        int min = Math.min(m6345getMaxWidthimpl, measureScope2.mo624roundToPx0680j_4(f2));
                        String str4 = str2;
                        int size = list.size();
                        int i7 = 0;
                        while (true) {
                            if (i7 >= size) {
                                measurable = null;
                                break;
                            }
                            measurable = list.get(i7);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), str4)) {
                                break;
                            }
                            i7++;
                        }
                        Measurable measurable3 = measurable;
                        Placeable mo5333measureBRTryo0 = measurable3 != null ? measurable3.mo5333measureBRTryo0(j3) : null;
                        String str5 = str3;
                        int size2 = list.size();
                        int i8 = 0;
                        while (true) {
                            if (i8 >= size2) {
                                measurable2 = null;
                                break;
                            }
                            measurable2 = list.get(i8);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), str5)) {
                                break;
                            }
                            i8++;
                        }
                        Measurable measurable4 = measurable2;
                        final Placeable mo5333measureBRTryo02 = measurable4 != null ? measurable4.mo5333measureBRTryo0(j3) : null;
                        int width = mo5333measureBRTryo0 != null ? mo5333measureBRTryo0.getWidth() : 0;
                        int height2 = mo5333measureBRTryo0 != null ? mo5333measureBRTryo0.getHeight() : 0;
                        int width2 = mo5333measureBRTryo02 != null ? mo5333measureBRTryo02.getWidth() : 0;
                        int height3 = mo5333measureBRTryo02 != null ? mo5333measureBRTryo02.getHeight() : 0;
                        if (width2 == 0) {
                            f4 = SnackbarKt.TextEndExtraSpacing;
                            i4 = measureScope2.mo624roundToPx0680j_4(f4);
                        } else {
                            i4 = 0;
                        }
                        int coerceAtLeast = RangesKt.coerceAtLeast(((min - width) - width2) - i4, Constraints.m6347getMinWidthimpl(j3));
                        String str6 = str;
                        int size3 = list.size();
                        int i9 = 0;
                        while (i9 < size3) {
                            Measurable measurable5 = list.get(i9);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable5), str6)) {
                                int i10 = height3;
                                final Placeable mo5333measureBRTryo03 = measurable5.mo5333measureBRTryo0(Constraints.m6336copyZbe2FdA$default(j3, 0, coerceAtLeast, 0, 0, 9, null));
                                int i11 = mo5333measureBRTryo03.get(androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline());
                                if (i11 == Integer.MIN_VALUE) {
                                    throw new IllegalArgumentException("No baselines for text".toString());
                                }
                                int i12 = mo5333measureBRTryo03.get(androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline());
                                if (i12 == Integer.MIN_VALUE) {
                                    throw new IllegalArgumentException("No baselines for text".toString());
                                }
                                final int i13 = min - width2;
                                final int i14 = i13 - width;
                                if (!(i11 == i12)) {
                                    f3 = SnackbarKt.HeightToFirstLine;
                                    i5 = measureScope2.mo624roundToPx0680j_4(f3) - i11;
                                    max = Math.max(measureScope2.mo624roundToPx0680j_4(SnackbarTokens.INSTANCE.m3456getTwoLinesContainerHeightD9Ej5fM()), mo5333measureBRTryo03.getHeight() + i5);
                                    if (mo5333measureBRTryo0 != null) {
                                        height = (max - mo5333measureBRTryo0.getHeight()) / 2;
                                    }
                                    height = 0;
                                } else {
                                    max = Math.max(measureScope2.mo624roundToPx0680j_4(SnackbarTokens.INSTANCE.m3455getSingleLineContainerHeightD9Ej5fM()), Math.max(height2, i10));
                                    i5 = (max - mo5333measureBRTryo03.getHeight()) / 2;
                                    if (mo5333measureBRTryo0 != null && (i6 = mo5333measureBRTryo0.get(androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline())) != Integer.MIN_VALUE) {
                                        height = (i11 + i5) - i6;
                                    }
                                    height = 0;
                                }
                                final int i15 = height;
                                final int i16 = i5;
                                int i17 = max;
                                final int height4 = mo5333measureBRTryo02 != null ? (i17 - mo5333measureBRTryo02.getHeight()) / 2 : 0;
                                final Placeable placeable = mo5333measureBRTryo0;
                                return MeasureScope.layout$default(measureScope2, min, i17, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.SnackbarKt$OneRowSnackbar$2$1.4
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
                                        Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, 0, i16, 0.0f, 4, null);
                                        Placeable placeable2 = mo5333measureBRTryo02;
                                        if (placeable2 != null) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i13, height4, 0.0f, 4, null);
                                        }
                                        Placeable placeable3 = placeable;
                                        if (placeable3 != null) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, i14, i15, 0.0f, 4, null);
                                        }
                                    }
                                }, 4, null);
                            }
                            i9++;
                            measureScope2 = measureScope;
                            height3 = height3;
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -167734359, "C311@13156L86:Snackbar.kt#uh7d8r");
            Modifier m881paddingVpY3zN4$default = PaddingKt.m881paddingVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, "text"), 0.0f, SnackbarVerticalPadding, 1, null);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 448288408, "C311@13234L6:Snackbar.kt#uh7d8r");
            function2.invoke(startRestartGroup, Integer.valueOf(i3 & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-167734260);
            ComposerKt.sourceInformation(startRestartGroup, "313@13293L295");
            if (function22 != null) {
                Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "action");
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 448288523, "C314@13349L221:Snackbar.kt#uh7d8r");
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(j)), TextKt.getLocalTextStyle().provides(textStyle)}, function22, startRestartGroup, i3 & 112);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(44738899);
            ComposerKt.sourceInformation(startRestartGroup, "322@13660L247");
            if (function23 != null) {
                Modifier layoutId2 = LayoutIdKt.layoutId(Modifier.INSTANCE, "dismissAction");
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(layoutId2);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor4);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m3593constructorimpl4 = Updater.m3593constructorimpl(startRestartGroup);
                Updater.m3600setimpl(m3593constructorimpl4, rememberBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3600setimpl(m3593constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m3593constructorimpl4.getInserting() || !Intrinsics.areEqual(m3593constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                    m3593constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    m3593constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                modifierMaterializerOf4.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 448288897, "C323@13723L166:Snackbar.kt#uh7d8r");
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(j2)), function23, startRestartGroup, ProvidedValue.$stable | ((i3 >> 3) & 112));
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
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$OneRowSnackbar$3
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

                public final void invoke(Composer composer2, int i4) {
                    SnackbarKt.m2548OneRowSnackbarkKq0p4A(function2, function22, function23, textStyle, j, j2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
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
