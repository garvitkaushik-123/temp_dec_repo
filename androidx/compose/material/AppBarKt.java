package androidx.compose.material;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import io.bidmachine.iab.vast.tags.VastAttributes;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppBar.kt */
@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aj\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00072\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f0\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0003ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001av\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f0\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001an\u0010\u001e\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f0\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a\u008c\u0001\u0010$\u001a\u00020\f2\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\f0&¢\u0006\u0002\b\u001a2\u0006\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00072\u0015\b\u0002\u0010'\u001a\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010&¢\u0006\u0002\b\u001a2\u001e\b\u0002\u0010(\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f0\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a\u0084\u0001\u0010$\u001a\u00020\f2\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\f0&¢\u0006\u0002\b\u001a2\b\b\u0002\u0010\u0016\u001a\u00020\u00072\u0015\b\u0002\u0010'\u001a\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010&¢\u0006\u0002\b\u001a2\u001e\b\u0002\u0010(\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f0\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001aj\u0010$\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f0\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001ab\u0010$\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f0\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\b/\u00100\u001a\u0019\u00101\u001a\u0002022\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u000202H\u0080\b\u001a,\u00105\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u000202062\u0006\u00107\u001a\u0002022\u0006\u00104\u001a\u0002022\u0006\u00108\u001a\u000202H\u0000\u001a\u0011\u00109\u001a\u0002022\u0006\u0010:\u001a\u000202H\u0082\b\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006;"}, d2 = {"AppBarHeight", "Landroidx/compose/ui/unit/Dp;", "F", "AppBarHorizontalPadding", "BottomAppBarCutoutOffset", "BottomAppBarRoundedEdgeRadius", "TitleIconModifier", "Landroidx/compose/ui/Modifier;", "TitleInsetWithoutIcon", "ZeroInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "AppBar", "", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "shape", "Landroidx/compose/ui/graphics/Shape;", "windowInsets", "modifier", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "AppBar-HkEspTQ", "(JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomAppBar", "cutoutShape", "BottomAppBar-DanWW-k", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/graphics/Shape;FLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomAppBar-Y1yfwus", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/graphics/Shape;FLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TopAppBar", "title", "Lkotlin/Function0;", "navigationIcon", "actions", "TopAppBar-Rx1qByU", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;JJFLandroidx/compose/runtime/Composer;II)V", "TopAppBar-xWeB9-s", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;JJFLandroidx/compose/runtime/Composer;II)V", "TopAppBar-afqeVBk", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TopAppBar-HsRjFd4", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "calculateCutoutCircleYIntercept", "", "cutoutRadius", "verticalOffset", "calculateRoundedEdgeIntercept", "Lkotlin/Pair;", "controlPointX", "radius", "square", VastAttributes.HORIZONTAL_POSITION, "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AppBarKt {
    private static final float AppBarHeight = Dp.m6389constructorimpl(56);
    private static final float AppBarHorizontalPadding;
    private static final float BottomAppBarCutoutOffset;
    private static final float BottomAppBarRoundedEdgeRadius;
    private static final Modifier TitleIconModifier;
    private static final Modifier TitleInsetWithoutIcon;
    private static final WindowInsets ZeroInsets;

    private static final float square(float f) {
        return f * f;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0086  */
    /* renamed from: TopAppBar-Rx1qByU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1531TopAppBarRx1qByU(final Function2<? super Composer, ? super Integer, Unit> function2, final WindowInsets windowInsets, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, long j, long j2, float f, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Modifier modifier2;
        int i5;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        int i6;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32;
        int i7;
        long j3;
        int i8;
        int i9;
        long j4;
        int i10;
        int i11;
        long j5;
        long j6;
        float f2;
        Modifier modifier3;
        int i12;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33;
        final long j7;
        final long j8;
        final float f3;
        final Modifier modifier4;
        ScopeUpdateScope endRestartGroup;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(-763778507);
        ComposerKt.sourceInformation(startRestartGroup, "C(TopAppBar)P(6,7,4,5!1,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.unit.Dp)90@4376L6,91@4425L32,94@4522L1310:AppBar.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= startRestartGroup.changed(windowInsets) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 896) == 0) {
                modifier2 = modifier;
                i3 |= startRestartGroup.changed(modifier2) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 7168) == 0) {
                    function23 = function22;
                    i3 |= startRestartGroup.changedInstance(function23) ? 2048 : 1024;
                    i6 = i2 & 16;
                    if (i6 == 0) {
                        i3 |= 24576;
                    } else if ((57344 & i) == 0) {
                        function32 = function3;
                        i3 |= startRestartGroup.changedInstance(function32) ? 16384 : 8192;
                        if ((i & 458752) == 0) {
                            if ((i2 & 32) == 0 && startRestartGroup.changed(j)) {
                                i13 = 131072;
                                i3 |= i13;
                            }
                            i13 = 65536;
                            i3 |= i13;
                        }
                        if ((i & 3670016) == 0) {
                            i7 = 458752;
                            j3 = j2;
                            i3 |= ((i2 & 64) == 0 && startRestartGroup.changed(j3)) ? 1048576 : 524288;
                        } else {
                            i7 = 458752;
                            j3 = j2;
                        }
                        i8 = i2 & 128;
                        if (i8 != 0) {
                            i3 |= 12582912;
                        } else if ((i & 29360128) == 0) {
                            i3 |= startRestartGroup.changed(f) ? 8388608 : 4194304;
                        }
                        int i14 = i3;
                        if ((i3 & 23967451) == 4793490 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                if (i4 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i5 != 0) {
                                    function23 = null;
                                }
                                if (i6 != 0) {
                                    function32 = ComposableSingletons$AppBarKt.INSTANCE.m1626getLambda1$material_release();
                                }
                                if ((i2 & 32) != 0) {
                                    i14 &= -458753;
                                    i9 = -3670017;
                                    j4 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(startRestartGroup, 6));
                                } else {
                                    i9 = -3670017;
                                    j4 = j;
                                }
                                if ((i2 & 64) != 0) {
                                    j3 = ColorsKt.m1621contentColorForek8zF_U(j4, startRestartGroup, (i14 >> 15) & 14);
                                    i10 = i14 & i9;
                                } else {
                                    i10 = i14;
                                }
                                if (i8 != 0) {
                                    long j9 = j4;
                                    i11 = 3670016;
                                    j5 = j3;
                                    j6 = j9;
                                    f2 = AppBarDefaults.INSTANCE.m1526getTopAppBarElevationD9Ej5fM();
                                } else {
                                    long j10 = j4;
                                    i11 = 3670016;
                                    j5 = j3;
                                    j6 = j10;
                                    f2 = f;
                                }
                                modifier3 = modifier2;
                                i12 = -763778507;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                i10 = (i2 & 32) != 0 ? i14 & (-458753) : i14;
                                if ((i2 & 64) != 0) {
                                    i10 &= -3670017;
                                }
                                f2 = f;
                                modifier3 = modifier2;
                                i11 = 3670016;
                                i12 = -763778507;
                                j5 = j3;
                                j6 = j;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i12, i10, -1, "androidx.compose.material.TopAppBar (AppBar.kt:93)");
                            }
                            int i15 = i10 >> 15;
                            int i16 = i10 << 12;
                            composer2 = startRestartGroup;
                            m1527AppBarHkEspTQ(j6, j5, f2, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), windowInsets, modifier3, ComposableLambdaKt.composableLambda(startRestartGroup, 1849684359, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                                    invoke(rowScope, composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(RowScope rowScope, Composer composer3, int i17) {
                                    int i18;
                                    Modifier modifier5;
                                    int i19;
                                    Modifier modifier6;
                                    ComposerKt.sourceInformation(composer3, "C114@5092L412,128@5579L6,128@5514L312:AppBar.kt#jmzs0o");
                                    if ((i17 & 14) == 0) {
                                        i18 = i17 | (composer3.changed(rowScope) ? 4 : 2);
                                    } else {
                                        i18 = i17;
                                    }
                                    if ((i18 & 91) != 18 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1849684359, i18, -1, "androidx.compose.material.TopAppBar.<anonymous> (AppBar.kt:103)");
                                        }
                                        if (function23 == null) {
                                            composer3.startReplaceableGroup(-512812154);
                                            ComposerKt.sourceInformation(composer3, "104@4756L29");
                                            modifier6 = AppBarKt.TitleInsetWithoutIcon;
                                            SpacerKt.Spacer(modifier6, composer3, 6);
                                            composer3.endReplaceableGroup();
                                            i19 = 0;
                                        } else {
                                            composer3.startReplaceableGroup(-512812095);
                                            ComposerKt.sourceInformation(composer3, "106@4815L257");
                                            modifier5 = AppBarKt.TitleIconModifier;
                                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                            Function2<Composer, Integer, Unit> function25 = function23;
                                            composer3.startReplaceableGroup(693286680);
                                            ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer3, 48);
                                            composer3.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                            i19 = 0;
                                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier5);
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
                                            Updater.m3600setimpl(m3593constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                            composer3.startReplaceableGroup(2058660585);
                                            ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer3, -2027905463, "C108@4990L4,107@4904L154:AppBar.kt#jmzs0o");
                                            CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer3, 6))), function25, composer3, ProvidedValue.$stable);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            composer3.endReplaceableGroup();
                                            composer3.endNode();
                                            composer3.endReplaceableGroup();
                                            composer3.endReplaceableGroup();
                                            composer3.endReplaceableGroup();
                                        }
                                        int i20 = i19;
                                        Modifier weight$default = RowScope.weight$default(rowScope, SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, false, 2, null);
                                        Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                                        final Function2<Composer, Integer, Unit> function26 = function2;
                                        composer3.startReplaceableGroup(693286680);
                                        ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                        MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composer3, 48);
                                        composer3.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, i20);
                                        CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(weight$default);
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
                                        Updater.m3600setimpl(m3593constructorimpl2, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                            m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                            m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                        }
                                        modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, Integer.valueOf(i20));
                                        composer3.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                        RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer3, -2027905104, "C120@5302L10,120@5263L231:AppBar.kt#jmzs0o");
                                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer3, 6).getH6(), ComposableLambdaKt.composableLambda(composer3, -1654084516, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1$2$1
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

                                            public final void invoke(Composer composer4, int i21) {
                                                ComposerKt.sourceInformation(composer4, "C122@5421L4,121@5335L145:AppBar.kt#jmzs0o");
                                                if ((i21 & 11) != 2 || !composer4.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1654084516, i21, -1, "androidx.compose.material.TopAppBar.<anonymous>.<anonymous>.<anonymous> (AppBar.kt:121)");
                                                    }
                                                    CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer4, 6))), function26, composer4, ProvidedValue.$stable);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer4.skipToGroupEnd();
                                            }
                                        }), composer3, 48);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        composer3.endReplaceableGroup();
                                        composer3.endNode();
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        ProvidedValue<Float> provides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer3, 6)));
                                        final Function3<RowScope, Composer, Integer, Unit> function34 = function32;
                                        CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer3, 2129753671, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1.3
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

                                            public final void invoke(Composer composer4, int i21) {
                                                ComposerKt.sourceInformation(composer4, "C129@5601L215:AppBar.kt#jmzs0o");
                                                if ((i21 & 11) != 2 || !composer4.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(2129753671, i21, -1, "androidx.compose.material.TopAppBar.<anonymous>.<anonymous> (AppBar.kt:129)");
                                                    }
                                                    Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
                                                    Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                                                    Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                                                    Function3<RowScope, Composer, Integer, Unit> function35 = function34;
                                                    composer4.startReplaceableGroup(693286680);
                                                    ComposerKt.sourceInformation(composer4, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                                    MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(end, centerVertically3, composer4, 54);
                                                    composer4.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                    CompositionLocalMap currentCompositionLocalMap3 = composer4.getCurrentCompositionLocalMap();
                                                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(fillMaxHeight$default);
                                                    if (!(composer4.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer4.startReusableNode();
                                                    if (composer4.getInserting()) {
                                                        composer4.createNode(constructor3);
                                                    } else {
                                                        composer4.useNode();
                                                    }
                                                    Composer m3593constructorimpl3 = Updater.m3593constructorimpl(composer4);
                                                    Updater.m3600setimpl(m3593constructorimpl3, rowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m3600setimpl(m3593constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                    if (m3593constructorimpl3.getInserting() || !Intrinsics.areEqual(m3593constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                                        m3593constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                                        m3593constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                                    }
                                                    modifierMaterializerOf3.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer4)), composer4, 0);
                                                    composer4.startReplaceableGroup(2058660585);
                                                    ComposerKt.sourceInformationMarkerStart(composer4, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                                    function35.invoke(RowScopeInstance.INSTANCE, composer4, 6);
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
                                        }), composer3, ProvidedValue.$stable | 48);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), composer2, (i15 & 896) | (i15 & 14) | 12610560 | (i15 & 112) | (i16 & i7) | (i16 & i11), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function24 = function23;
                            function33 = function32;
                            j7 = j6;
                            j8 = j5;
                            f3 = f2;
                            modifier4 = modifier3;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            composer2 = startRestartGroup;
                            modifier4 = modifier2;
                            function24 = function23;
                            function33 = function32;
                            j8 = j3;
                            j7 = j;
                            f3 = f;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$2
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

                                public final void invoke(Composer composer3, int i17) {
                                    AppBarKt.m1531TopAppBarRx1qByU(function2, windowInsets, modifier4, function24, function33, j7, j8, f3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    function32 = function3;
                    if ((i & 458752) == 0) {
                    }
                    if ((i & 3670016) == 0) {
                    }
                    i8 = i2 & 128;
                    if (i8 != 0) {
                    }
                    int i142 = i3;
                    if ((i3 & 23967451) == 4793490) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if ((i2 & 64) != 0) {
                    }
                    if (i8 != 0) {
                    }
                    modifier3 = modifier2;
                    i12 = -763778507;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i152 = i10 >> 15;
                    int i162 = i10 << 12;
                    composer2 = startRestartGroup;
                    m1527AppBarHkEspTQ(j6, j5, f2, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), windowInsets, modifier3, ComposableLambdaKt.composableLambda(startRestartGroup, 1849684359, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                            invoke(rowScope, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(RowScope rowScope, Composer composer3, int i17) {
                            int i18;
                            Modifier modifier5;
                            int i19;
                            Modifier modifier6;
                            ComposerKt.sourceInformation(composer3, "C114@5092L412,128@5579L6,128@5514L312:AppBar.kt#jmzs0o");
                            if ((i17 & 14) == 0) {
                                i18 = i17 | (composer3.changed(rowScope) ? 4 : 2);
                            } else {
                                i18 = i17;
                            }
                            if ((i18 & 91) != 18 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1849684359, i18, -1, "androidx.compose.material.TopAppBar.<anonymous> (AppBar.kt:103)");
                                }
                                if (function23 == null) {
                                    composer3.startReplaceableGroup(-512812154);
                                    ComposerKt.sourceInformation(composer3, "104@4756L29");
                                    modifier6 = AppBarKt.TitleInsetWithoutIcon;
                                    SpacerKt.Spacer(modifier6, composer3, 6);
                                    composer3.endReplaceableGroup();
                                    i19 = 0;
                                } else {
                                    composer3.startReplaceableGroup(-512812095);
                                    ComposerKt.sourceInformation(composer3, "106@4815L257");
                                    modifier5 = AppBarKt.TitleIconModifier;
                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                    Function2<Composer, Integer, Unit> function25 = function23;
                                    composer3.startReplaceableGroup(693286680);
                                    ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer3, 48);
                                    composer3.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    i19 = 0;
                                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier5);
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
                                    Updater.m3600setimpl(m3593constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                    composer3.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer3, -2027905463, "C108@4990L4,107@4904L154:AppBar.kt#jmzs0o");
                                    CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer3, 6))), function25, composer3, ProvidedValue.$stable);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    composer3.endReplaceableGroup();
                                    composer3.endNode();
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                }
                                int i20 = i19;
                                Modifier weight$default = RowScope.weight$default(rowScope, SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, false, 2, null);
                                Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                                final Function2<? super Composer, ? super Integer, Unit> function26 = function2;
                                composer3.startReplaceableGroup(693286680);
                                ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composer3, 48);
                                composer3.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, i20);
                                CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(weight$default);
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
                                Updater.m3600setimpl(m3593constructorimpl2, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                    m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                    m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                }
                                modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, Integer.valueOf(i20));
                                composer3.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer3, -2027905104, "C120@5302L10,120@5263L231:AppBar.kt#jmzs0o");
                                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer3, 6).getH6(), ComposableLambdaKt.composableLambda(composer3, -1654084516, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1$2$1
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

                                    public final void invoke(Composer composer4, int i21) {
                                        ComposerKt.sourceInformation(composer4, "C122@5421L4,121@5335L145:AppBar.kt#jmzs0o");
                                        if ((i21 & 11) != 2 || !composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1654084516, i21, -1, "androidx.compose.material.TopAppBar.<anonymous>.<anonymous>.<anonymous> (AppBar.kt:121)");
                                            }
                                            CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer4, 6))), function26, composer4, ProvidedValue.$stable);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                }), composer3, 48);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endReplaceableGroup();
                                composer3.endNode();
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                ProvidedValue<Float> provides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer3, 6)));
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function34 = function32;
                                CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer3, 2129753671, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1.3
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

                                    public final void invoke(Composer composer4, int i21) {
                                        ComposerKt.sourceInformation(composer4, "C129@5601L215:AppBar.kt#jmzs0o");
                                        if ((i21 & 11) != 2 || !composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(2129753671, i21, -1, "androidx.compose.material.TopAppBar.<anonymous>.<anonymous> (AppBar.kt:129)");
                                            }
                                            Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
                                            Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                                            Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                                            Function3<RowScope, Composer, Integer, Unit> function35 = function34;
                                            composer4.startReplaceableGroup(693286680);
                                            ComposerKt.sourceInformation(composer4, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                            MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(end, centerVertically3, composer4, 54);
                                            composer4.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                            CompositionLocalMap currentCompositionLocalMap3 = composer4.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(fillMaxHeight$default);
                                            if (!(composer4.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer4.startReusableNode();
                                            if (composer4.getInserting()) {
                                                composer4.createNode(constructor3);
                                            } else {
                                                composer4.useNode();
                                            }
                                            Composer m3593constructorimpl3 = Updater.m3593constructorimpl(composer4);
                                            Updater.m3600setimpl(m3593constructorimpl3, rowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3600setimpl(m3593constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if (m3593constructorimpl3.getInserting() || !Intrinsics.areEqual(m3593constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                                m3593constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                                m3593constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                            }
                                            modifierMaterializerOf3.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer4)), composer4, 0);
                                            composer4.startReplaceableGroup(2058660585);
                                            ComposerKt.sourceInformationMarkerStart(composer4, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                            function35.invoke(RowScopeInstance.INSTANCE, composer4, 6);
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
                                }), composer3, ProvidedValue.$stable | 48);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), composer2, (i152 & 896) | (i152 & 14) | 12610560 | (i152 & 112) | (i162 & i7) | (i162 & i11), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    function24 = function23;
                    function33 = function32;
                    j7 = j6;
                    j8 = j5;
                    f3 = f2;
                    modifier4 = modifier3;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function23 = function22;
                i6 = i2 & 16;
                if (i6 == 0) {
                }
                function32 = function3;
                if ((i & 458752) == 0) {
                }
                if ((i & 3670016) == 0) {
                }
                i8 = i2 & 128;
                if (i8 != 0) {
                }
                int i1422 = i3;
                if ((i3 & 23967451) == 4793490) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if ((i2 & 64) != 0) {
                }
                if (i8 != 0) {
                }
                modifier3 = modifier2;
                i12 = -763778507;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i1522 = i10 >> 15;
                int i1622 = i10 << 12;
                composer2 = startRestartGroup;
                m1527AppBarHkEspTQ(j6, j5, f2, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), windowInsets, modifier3, ComposableLambdaKt.composableLambda(startRestartGroup, 1849684359, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                        invoke(rowScope, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RowScope rowScope, Composer composer3, int i17) {
                        int i18;
                        Modifier modifier5;
                        int i19;
                        Modifier modifier6;
                        ComposerKt.sourceInformation(composer3, "C114@5092L412,128@5579L6,128@5514L312:AppBar.kt#jmzs0o");
                        if ((i17 & 14) == 0) {
                            i18 = i17 | (composer3.changed(rowScope) ? 4 : 2);
                        } else {
                            i18 = i17;
                        }
                        if ((i18 & 91) != 18 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1849684359, i18, -1, "androidx.compose.material.TopAppBar.<anonymous> (AppBar.kt:103)");
                            }
                            if (function23 == null) {
                                composer3.startReplaceableGroup(-512812154);
                                ComposerKt.sourceInformation(composer3, "104@4756L29");
                                modifier6 = AppBarKt.TitleInsetWithoutIcon;
                                SpacerKt.Spacer(modifier6, composer3, 6);
                                composer3.endReplaceableGroup();
                                i19 = 0;
                            } else {
                                composer3.startReplaceableGroup(-512812095);
                                ComposerKt.sourceInformation(composer3, "106@4815L257");
                                modifier5 = AppBarKt.TitleIconModifier;
                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                Function2<Composer, Integer, Unit> function25 = function23;
                                composer3.startReplaceableGroup(693286680);
                                ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer3, 48);
                                composer3.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                i19 = 0;
                                CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier5);
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
                                Updater.m3600setimpl(m3593constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                composer3.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer3, -2027905463, "C108@4990L4,107@4904L154:AppBar.kt#jmzs0o");
                                CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer3, 6))), function25, composer3, ProvidedValue.$stable);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endReplaceableGroup();
                                composer3.endNode();
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                            }
                            int i20 = i19;
                            Modifier weight$default = RowScope.weight$default(rowScope, SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, false, 2, null);
                            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                            final Function2<? super Composer, ? super Integer, Unit> function26 = function2;
                            composer3.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composer3, 48);
                            composer3.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, i20);
                            CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(weight$default);
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
                            Updater.m3600setimpl(m3593constructorimpl2, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                            }
                            modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, Integer.valueOf(i20));
                            composer3.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer3, -2027905104, "C120@5302L10,120@5263L231:AppBar.kt#jmzs0o");
                            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer3, 6).getH6(), ComposableLambdaKt.composableLambda(composer3, -1654084516, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1$2$1
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

                                public final void invoke(Composer composer4, int i21) {
                                    ComposerKt.sourceInformation(composer4, "C122@5421L4,121@5335L145:AppBar.kt#jmzs0o");
                                    if ((i21 & 11) != 2 || !composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1654084516, i21, -1, "androidx.compose.material.TopAppBar.<anonymous>.<anonymous>.<anonymous> (AppBar.kt:121)");
                                        }
                                        CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer4, 6))), function26, composer4, ProvidedValue.$stable);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            }), composer3, 48);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endReplaceableGroup();
                            composer3.endNode();
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                            ProvidedValue<Float> provides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer3, 6)));
                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function34 = function32;
                            CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer3, 2129753671, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1.3
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

                                public final void invoke(Composer composer4, int i21) {
                                    ComposerKt.sourceInformation(composer4, "C129@5601L215:AppBar.kt#jmzs0o");
                                    if ((i21 & 11) != 2 || !composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(2129753671, i21, -1, "androidx.compose.material.TopAppBar.<anonymous>.<anonymous> (AppBar.kt:129)");
                                        }
                                        Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
                                        Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                                        Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                                        Function3<RowScope, Composer, Integer, Unit> function35 = function34;
                                        composer4.startReplaceableGroup(693286680);
                                        ComposerKt.sourceInformation(composer4, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                        MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(end, centerVertically3, composer4, 54);
                                        composer4.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                        CompositionLocalMap currentCompositionLocalMap3 = composer4.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(fillMaxHeight$default);
                                        if (!(composer4.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer4.startReusableNode();
                                        if (composer4.getInserting()) {
                                            composer4.createNode(constructor3);
                                        } else {
                                            composer4.useNode();
                                        }
                                        Composer m3593constructorimpl3 = Updater.m3593constructorimpl(composer4);
                                        Updater.m3600setimpl(m3593constructorimpl3, rowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3600setimpl(m3593constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (m3593constructorimpl3.getInserting() || !Intrinsics.areEqual(m3593constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                            m3593constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                            m3593constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                        }
                                        modifierMaterializerOf3.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer4)), composer4, 0);
                                        composer4.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer4, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                        function35.invoke(RowScopeInstance.INSTANCE, composer4, 6);
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
                            }), composer3, ProvidedValue.$stable | 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), composer2, (i1522 & 896) | (i1522 & 14) | 12610560 | (i1522 & 112) | (i1622 & i7) | (i1622 & i11), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                function24 = function23;
                function33 = function32;
                j7 = j6;
                j8 = j5;
                f3 = f2;
                modifier4 = modifier3;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            modifier2 = modifier;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            function23 = function22;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            function32 = function3;
            if ((i & 458752) == 0) {
            }
            if ((i & 3670016) == 0) {
            }
            i8 = i2 & 128;
            if (i8 != 0) {
            }
            int i14222 = i3;
            if ((i3 & 23967451) == 4793490) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if ((i2 & 64) != 0) {
            }
            if (i8 != 0) {
            }
            modifier3 = modifier2;
            i12 = -763778507;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i15222 = i10 >> 15;
            int i16222 = i10 << 12;
            composer2 = startRestartGroup;
            m1527AppBarHkEspTQ(j6, j5, f2, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), windowInsets, modifier3, ComposableLambdaKt.composableLambda(startRestartGroup, 1849684359, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                    invoke(rowScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RowScope rowScope, Composer composer3, int i17) {
                    int i18;
                    Modifier modifier5;
                    int i19;
                    Modifier modifier6;
                    ComposerKt.sourceInformation(composer3, "C114@5092L412,128@5579L6,128@5514L312:AppBar.kt#jmzs0o");
                    if ((i17 & 14) == 0) {
                        i18 = i17 | (composer3.changed(rowScope) ? 4 : 2);
                    } else {
                        i18 = i17;
                    }
                    if ((i18 & 91) != 18 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1849684359, i18, -1, "androidx.compose.material.TopAppBar.<anonymous> (AppBar.kt:103)");
                        }
                        if (function23 == null) {
                            composer3.startReplaceableGroup(-512812154);
                            ComposerKt.sourceInformation(composer3, "104@4756L29");
                            modifier6 = AppBarKt.TitleInsetWithoutIcon;
                            SpacerKt.Spacer(modifier6, composer3, 6);
                            composer3.endReplaceableGroup();
                            i19 = 0;
                        } else {
                            composer3.startReplaceableGroup(-512812095);
                            ComposerKt.sourceInformation(composer3, "106@4815L257");
                            modifier5 = AppBarKt.TitleIconModifier;
                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                            Function2<Composer, Integer, Unit> function25 = function23;
                            composer3.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer3, 48);
                            composer3.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            i19 = 0;
                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier5);
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
                            Updater.m3600setimpl(m3593constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                            composer3.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer3, -2027905463, "C108@4990L4,107@4904L154:AppBar.kt#jmzs0o");
                            CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer3, 6))), function25, composer3, ProvidedValue.$stable);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endReplaceableGroup();
                            composer3.endNode();
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                        }
                        int i20 = i19;
                        Modifier weight$default = RowScope.weight$default(rowScope, SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, false, 2, null);
                        Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                        final Function2<? super Composer, ? super Integer, Unit> function26 = function2;
                        composer3.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                        MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composer3, 48);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, i20);
                        CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(weight$default);
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
                        Updater.m3600setimpl(m3593constructorimpl2, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, Integer.valueOf(i20));
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, -2027905104, "C120@5302L10,120@5263L231:AppBar.kt#jmzs0o");
                        TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer3, 6).getH6(), ComposableLambdaKt.composableLambda(composer3, -1654084516, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1$2$1
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

                            public final void invoke(Composer composer4, int i21) {
                                ComposerKt.sourceInformation(composer4, "C122@5421L4,121@5335L145:AppBar.kt#jmzs0o");
                                if ((i21 & 11) != 2 || !composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1654084516, i21, -1, "androidx.compose.material.TopAppBar.<anonymous>.<anonymous>.<anonymous> (AppBar.kt:121)");
                                    }
                                    CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer4, 6))), function26, composer4, ProvidedValue.$stable);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer4.skipToGroupEnd();
                            }
                        }), composer3, 48);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        ProvidedValue<Float> provides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer3, 6)));
                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function34 = function32;
                        CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer3, 2129753671, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1.3
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

                            public final void invoke(Composer composer4, int i21) {
                                ComposerKt.sourceInformation(composer4, "C129@5601L215:AppBar.kt#jmzs0o");
                                if ((i21 & 11) != 2 || !composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(2129753671, i21, -1, "androidx.compose.material.TopAppBar.<anonymous>.<anonymous> (AppBar.kt:129)");
                                    }
                                    Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
                                    Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                                    Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                                    Function3<RowScope, Composer, Integer, Unit> function35 = function34;
                                    composer4.startReplaceableGroup(693286680);
                                    ComposerKt.sourceInformation(composer4, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                    MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(end, centerVertically3, composer4, 54);
                                    composer4.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                    CompositionLocalMap currentCompositionLocalMap3 = composer4.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(fillMaxHeight$default);
                                    if (!(composer4.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer4.startReusableNode();
                                    if (composer4.getInserting()) {
                                        composer4.createNode(constructor3);
                                    } else {
                                        composer4.useNode();
                                    }
                                    Composer m3593constructorimpl3 = Updater.m3593constructorimpl(composer4);
                                    Updater.m3600setimpl(m3593constructorimpl3, rowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3600setimpl(m3593constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m3593constructorimpl3.getInserting() || !Intrinsics.areEqual(m3593constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                        m3593constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                        m3593constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                    }
                                    modifierMaterializerOf3.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer4)), composer4, 0);
                                    composer4.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer4, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                    function35.invoke(RowScopeInstance.INSTANCE, composer4, 6);
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
                        }), composer3, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), composer2, (i15222 & 896) | (i15222 & 14) | 12610560 | (i15222 & 112) | (i16222 & i7) | (i16222 & i11), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            function24 = function23;
            function33 = function32;
            j7 = j6;
            j8 = j5;
            f3 = f2;
            modifier4 = modifier3;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        modifier2 = modifier;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        function23 = function22;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        function32 = function3;
        if ((i & 458752) == 0) {
        }
        if ((i & 3670016) == 0) {
        }
        i8 = i2 & 128;
        if (i8 != 0) {
        }
        int i142222 = i3;
        if ((i3 & 23967451) == 4793490) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if (i8 != 0) {
        }
        modifier3 = modifier2;
        i12 = -763778507;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i152222 = i10 >> 15;
        int i162222 = i10 << 12;
        composer2 = startRestartGroup;
        m1527AppBarHkEspTQ(j6, j5, f2, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), windowInsets, modifier3, ComposableLambdaKt.composableLambda(startRestartGroup, 1849684359, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                invoke(rowScope, composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(RowScope rowScope, Composer composer3, int i17) {
                int i18;
                Modifier modifier5;
                int i19;
                Modifier modifier6;
                ComposerKt.sourceInformation(composer3, "C114@5092L412,128@5579L6,128@5514L312:AppBar.kt#jmzs0o");
                if ((i17 & 14) == 0) {
                    i18 = i17 | (composer3.changed(rowScope) ? 4 : 2);
                } else {
                    i18 = i17;
                }
                if ((i18 & 91) != 18 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1849684359, i18, -1, "androidx.compose.material.TopAppBar.<anonymous> (AppBar.kt:103)");
                    }
                    if (function23 == null) {
                        composer3.startReplaceableGroup(-512812154);
                        ComposerKt.sourceInformation(composer3, "104@4756L29");
                        modifier6 = AppBarKt.TitleInsetWithoutIcon;
                        SpacerKt.Spacer(modifier6, composer3, 6);
                        composer3.endReplaceableGroup();
                        i19 = 0;
                    } else {
                        composer3.startReplaceableGroup(-512812095);
                        ComposerKt.sourceInformation(composer3, "106@4815L257");
                        modifier5 = AppBarKt.TitleIconModifier;
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        Function2<Composer, Integer, Unit> function25 = function23;
                        composer3.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer3, 48);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        i19 = 0;
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier5);
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
                        Updater.m3600setimpl(m3593constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, -2027905463, "C108@4990L4,107@4904L154:AppBar.kt#jmzs0o");
                        CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer3, 6))), function25, composer3, ProvidedValue.$stable);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                    }
                    int i20 = i19;
                    Modifier weight$default = RowScope.weight$default(rowScope, SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, false, 2, null);
                    Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                    final Function2<? super Composer, ? super Integer, Unit> function26 = function2;
                    composer3.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composer3, 48);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, i20);
                    CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(weight$default);
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
                    Updater.m3600setimpl(m3593constructorimpl2, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, Integer.valueOf(i20));
                    composer3.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer3, -2027905104, "C120@5302L10,120@5263L231:AppBar.kt#jmzs0o");
                    TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer3, 6).getH6(), ComposableLambdaKt.composableLambda(composer3, -1654084516, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1$2$1
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

                        public final void invoke(Composer composer4, int i21) {
                            ComposerKt.sourceInformation(composer4, "C122@5421L4,121@5335L145:AppBar.kt#jmzs0o");
                            if ((i21 & 11) != 2 || !composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1654084516, i21, -1, "androidx.compose.material.TopAppBar.<anonymous>.<anonymous>.<anonymous> (AppBar.kt:121)");
                                }
                                CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer4, 6))), function26, composer4, ProvidedValue.$stable);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer4.skipToGroupEnd();
                        }
                    }), composer3, 48);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    ProvidedValue<Float> provides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer3, 6)));
                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function34 = function32;
                    CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer3, 2129753671, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$1.3
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

                        public final void invoke(Composer composer4, int i21) {
                            ComposerKt.sourceInformation(composer4, "C129@5601L215:AppBar.kt#jmzs0o");
                            if ((i21 & 11) != 2 || !composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2129753671, i21, -1, "androidx.compose.material.TopAppBar.<anonymous>.<anonymous> (AppBar.kt:129)");
                                }
                                Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
                                Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                                Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                                Function3<RowScope, Composer, Integer, Unit> function35 = function34;
                                composer4.startReplaceableGroup(693286680);
                                ComposerKt.sourceInformation(composer4, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(end, centerVertically3, composer4, 54);
                                composer4.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                CompositionLocalMap currentCompositionLocalMap3 = composer4.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(fillMaxHeight$default);
                                if (!(composer4.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer4.startReusableNode();
                                if (composer4.getInserting()) {
                                    composer4.createNode(constructor3);
                                } else {
                                    composer4.useNode();
                                }
                                Composer m3593constructorimpl3 = Updater.m3593constructorimpl(composer4);
                                Updater.m3600setimpl(m3593constructorimpl3, rowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3600setimpl(m3593constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m3593constructorimpl3.getInserting() || !Intrinsics.areEqual(m3593constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                    m3593constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                    m3593constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                }
                                modifierMaterializerOf3.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer4)), composer4, 0);
                                composer4.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer4, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                function35.invoke(RowScopeInstance.INSTANCE, composer4, 6);
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
                    }), composer3, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }), composer2, (i152222 & 896) | (i152222 & 14) | 12610560 | (i152222 & 112) | (i162222 & i7) | (i162222 & i11), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        function24 = function23;
        function33 = function32;
        j7 = j6;
        j8 = j5;
        f3 = f2;
        modifier4 = modifier3;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x006a  */
    /* renamed from: TopAppBar-xWeB9-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1533TopAppBarxWeB9s(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, long j, long j2, float f, Composer composer, final int i, final int i2) {
        Function2<? super Composer, ? super Integer, Unit> function23;
        int i3;
        Modifier modifier2;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i5;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32;
        long j3;
        int i6;
        long j4;
        int i7;
        int i8;
        float f2;
        int i9;
        float m1526getTopAppBarElevationD9Ej5fM;
        Function2<? super Composer, ? super Integer, Unit> function25;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33;
        long j5;
        int i10;
        int i11;
        Composer composer2;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function34;
        final long j6;
        final long j7;
        final float f3;
        ScopeUpdateScope endRestartGroup;
        int i12;
        Composer startRestartGroup = composer.startRestartGroup(-2087748139);
        ComposerKt.sourceInformation(startRestartGroup, "C(TopAppBar)P(6,4,5!1,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.unit.Dp)172@7722L6,173@7771L32,176@7867L175:AppBar.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function23 = function2;
        } else {
            function23 = function2;
            if ((i & 14) == 0) {
                i3 = (startRestartGroup.changedInstance(function23) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i13 = i2 & 2;
        if (i13 != 0) {
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
                    function32 = function3;
                    i3 |= startRestartGroup.changedInstance(function32) ? 2048 : 1024;
                    if ((i & 57344) != 0) {
                        if ((i2 & 16) == 0) {
                            j3 = j;
                            if (startRestartGroup.changed(j3)) {
                                i12 = 16384;
                                i3 |= i12;
                            }
                        } else {
                            j3 = j;
                        }
                        i12 = 8192;
                        i3 |= i12;
                    } else {
                        j3 = j;
                    }
                    if ((i & 458752) != 0) {
                        i6 = 57344;
                        j4 = j2;
                        i3 |= ((i2 & 32) == 0 && startRestartGroup.changed(j4)) ? 131072 : 65536;
                    } else {
                        i6 = 57344;
                        j4 = j2;
                    }
                    i7 = i2 & 64;
                    if (i7 == 0) {
                        i3 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        i8 = 458752;
                        f2 = f;
                        i3 |= startRestartGroup.changed(f2) ? 1048576 : 524288;
                        int i14 = i3;
                        if ((i3 & 2995931) == 599186 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                if (i13 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function24 = null;
                                }
                                if (i5 != 0) {
                                    function32 = ComposableSingletons$AppBarKt.INSTANCE.m1627getLambda2$material_release();
                                }
                                if ((i2 & 16) != 0) {
                                    j3 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(startRestartGroup, 6));
                                    i9 = i14 & (-57345);
                                } else {
                                    i9 = i14;
                                }
                                if ((i2 & 32) != 0) {
                                    j4 = ColorsKt.m1621contentColorForek8zF_U(j3, startRestartGroup, (i9 >> 12) & 14);
                                    i9 &= -458753;
                                }
                                if (i7 != 0) {
                                    m1526getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m1526getTopAppBarElevationD9Ej5fM();
                                    function25 = function24;
                                    function33 = function32;
                                    j5 = j4;
                                    i10 = 3670016;
                                    i11 = i8;
                                    long j8 = j3;
                                    Modifier modifier4 = modifier2;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-2087748139, i9, -1, "androidx.compose.material.TopAppBar (AppBar.kt:175)");
                                    }
                                    int i15 = (i9 & 14) | 48;
                                    int i16 = i9 << 3;
                                    composer2 = startRestartGroup;
                                    m1531TopAppBarRx1qByU(function23, ZeroInsets, modifier4, function25, function33, j8, j5, m1526getTopAppBarElevationD9Ej5fM, composer2, (i10 & i16) | (i11 & i16) | i15 | (i16 & 896) | (i16 & 7168) | (i16 & i6) | (i16 & 29360128), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier3 = modifier4;
                                    function26 = function25;
                                    function34 = function33;
                                    j6 = j8;
                                    j7 = j5;
                                    f3 = m1526getTopAppBarElevationD9Ej5fM;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                i9 = (i2 & 16) != 0 ? i14 & (-57345) : i14;
                                if ((i2 & 32) != 0) {
                                    i9 &= -458753;
                                }
                            }
                            function33 = function32;
                            j5 = j4;
                            m1526getTopAppBarElevationD9Ej5fM = f2;
                            i10 = 3670016;
                            i11 = i8;
                            function25 = function24;
                            long j82 = j3;
                            Modifier modifier42 = modifier2;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i152 = (i9 & 14) | 48;
                            int i162 = i9 << 3;
                            composer2 = startRestartGroup;
                            m1531TopAppBarRx1qByU(function23, ZeroInsets, modifier42, function25, function33, j82, j5, m1526getTopAppBarElevationD9Ej5fM, composer2, (i10 & i162) | (i11 & i162) | i152 | (i162 & 896) | (i162 & 7168) | (i162 & i6) | (i162 & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier3 = modifier42;
                            function26 = function25;
                            function34 = function33;
                            j6 = j82;
                            j7 = j5;
                            f3 = m1526getTopAppBarElevationD9Ej5fM;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            composer2 = startRestartGroup;
                            modifier3 = modifier2;
                            function26 = function24;
                            function34 = function32;
                            j7 = j4;
                            j6 = j3;
                            f3 = f2;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$3
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

                                public final void invoke(Composer composer3, int i17) {
                                    AppBarKt.m1533TopAppBarxWeB9s(function2, modifier3, function26, function34, j6, j7, f3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i8 = 458752;
                    f2 = f;
                    int i142 = i3;
                    if ((i3 & 2995931) == 599186) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i13 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if (i7 != 0) {
                    }
                    function33 = function32;
                    j5 = j4;
                    m1526getTopAppBarElevationD9Ej5fM = f2;
                    i10 = 3670016;
                    i11 = i8;
                    function25 = function24;
                    long j822 = j3;
                    Modifier modifier422 = modifier2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i1522 = (i9 & 14) | 48;
                    int i1622 = i9 << 3;
                    composer2 = startRestartGroup;
                    m1531TopAppBarRx1qByU(function23, ZeroInsets, modifier422, function25, function33, j822, j5, m1526getTopAppBarElevationD9Ej5fM, composer2, (i10 & i1622) | (i11 & i1622) | i1522 | (i1622 & 896) | (i1622 & 7168) | (i1622 & i6) | (i1622 & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier422;
                    function26 = function25;
                    function34 = function33;
                    j6 = j822;
                    j7 = j5;
                    f3 = m1526getTopAppBarElevationD9Ej5fM;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function32 = function3;
                if ((i & 57344) != 0) {
                }
                if ((i & 458752) != 0) {
                }
                i7 = i2 & 64;
                if (i7 == 0) {
                }
                i8 = 458752;
                f2 = f;
                int i1422 = i3;
                if ((i3 & 2995931) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i13 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if (i7 != 0) {
                }
                function33 = function32;
                j5 = j4;
                m1526getTopAppBarElevationD9Ej5fM = f2;
                i10 = 3670016;
                i11 = i8;
                function25 = function24;
                long j8222 = j3;
                Modifier modifier4222 = modifier2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i15222 = (i9 & 14) | 48;
                int i16222 = i9 << 3;
                composer2 = startRestartGroup;
                m1531TopAppBarRx1qByU(function23, ZeroInsets, modifier4222, function25, function33, j8222, j5, m1526getTopAppBarElevationD9Ej5fM, composer2, (i10 & i16222) | (i11 & i16222) | i15222 | (i16222 & 896) | (i16222 & 7168) | (i16222 & i6) | (i16222 & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier4222;
                function26 = function25;
                function34 = function33;
                j6 = j8222;
                j7 = j5;
                f3 = m1526getTopAppBarElevationD9Ej5fM;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function24 = function22;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            function32 = function3;
            if ((i & 57344) != 0) {
            }
            if ((i & 458752) != 0) {
            }
            i7 = i2 & 64;
            if (i7 == 0) {
            }
            i8 = 458752;
            f2 = f;
            int i14222 = i3;
            if ((i3 & 2995931) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i13 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if (i7 != 0) {
            }
            function33 = function32;
            j5 = j4;
            m1526getTopAppBarElevationD9Ej5fM = f2;
            i10 = 3670016;
            i11 = i8;
            function25 = function24;
            long j82222 = j3;
            Modifier modifier42222 = modifier2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i152222 = (i9 & 14) | 48;
            int i162222 = i9 << 3;
            composer2 = startRestartGroup;
            m1531TopAppBarRx1qByU(function23, ZeroInsets, modifier42222, function25, function33, j82222, j5, m1526getTopAppBarElevationD9Ej5fM, composer2, (i10 & i162222) | (i11 & i162222) | i152222 | (i162222 & 896) | (i162222 & 7168) | (i162222 & i6) | (i162222 & 29360128), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier42222;
            function26 = function25;
            function34 = function33;
            j6 = j82222;
            j7 = j5;
            f3 = m1526getTopAppBarElevationD9Ej5fM;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
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
        function32 = function3;
        if ((i & 57344) != 0) {
        }
        if ((i & 458752) != 0) {
        }
        i7 = i2 & 64;
        if (i7 == 0) {
        }
        i8 = 458752;
        f2 = f;
        int i142222 = i3;
        if ((i3 & 2995931) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i13 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if (i7 != 0) {
        }
        function33 = function32;
        j5 = j4;
        m1526getTopAppBarElevationD9Ej5fM = f2;
        i10 = 3670016;
        i11 = i8;
        function25 = function24;
        long j822222 = j3;
        Modifier modifier422222 = modifier2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i1522222 = (i9 & 14) | 48;
        int i1622222 = i9 << 3;
        composer2 = startRestartGroup;
        m1531TopAppBarRx1qByU(function23, ZeroInsets, modifier422222, function25, function33, j822222, j5, m1526getTopAppBarElevationD9Ej5fM, composer2, (i10 & i1622222) | (i11 & i1622222) | i1522222 | (i1622222 & 896) | (i1622222 & 7168) | (i1622222 & i6) | (i1622222 & 29360128), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier422222;
        function26 = function25;
        function34 = function33;
        j6 = j822222;
        j7 = j5;
        f3 = m1526getTopAppBarElevationD9Ej5fM;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0087  */
    /* renamed from: TopAppBar-afqeVBk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1532TopAppBarafqeVBk(final WindowInsets windowInsets, Modifier modifier, long j, long j2, float f, PaddingValues paddingValues, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        long j3;
        long j4;
        int i4;
        float f2;
        int i5;
        PaddingValues paddingValues2;
        int i6;
        PaddingValues contentPadding;
        Modifier modifier3;
        long j5;
        Composer composer2;
        final long j6;
        final long j7;
        final float f3;
        final PaddingValues paddingValues3;
        final Modifier modifier4;
        ScopeUpdateScope endRestartGroup;
        int i7;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(883764366);
        ComposerKt.sourceInformation(startRestartGroup, "C(TopAppBar)P(6,5,0:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,3)222@9964L6,223@10013L32,228@10222L204:AppBar.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changed(windowInsets) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i & 896) != 0) {
                if ((i2 & 4) == 0) {
                    j3 = j;
                    if (startRestartGroup.changed(j3)) {
                        i8 = 256;
                        i3 |= i8;
                    }
                } else {
                    j3 = j;
                }
                i8 = 128;
                i3 |= i8;
            } else {
                j3 = j;
            }
            if ((i & 7168) != 0) {
                if ((i2 & 8) == 0) {
                    j4 = j2;
                    if (startRestartGroup.changed(j4)) {
                        i7 = 2048;
                        i3 |= i7;
                    }
                } else {
                    j4 = j2;
                }
                i7 = 1024;
                i3 |= i7;
            } else {
                j4 = j2;
            }
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else if ((57344 & i) == 0) {
                f2 = f;
                i3 |= startRestartGroup.changed(f2) ? 16384 : 8192;
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & 458752) == 0) {
                    paddingValues2 = paddingValues;
                    i3 |= startRestartGroup.changed(paddingValues2) ? 131072 : 65536;
                    if ((i2 & 64) == 0) {
                        i3 |= 1572864;
                        i6 = 458752;
                    } else {
                        i6 = 458752;
                        if ((i & 3670016) == 0) {
                            i3 |= startRestartGroup.changedInstance(function3) ? 1048576 : 524288;
                        }
                    }
                    if ((i3 & 2995931) == 599186 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            if (i9 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                j3 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(startRestartGroup, 6));
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                j4 = ColorsKt.m1621contentColorForek8zF_U(j3, startRestartGroup, (i3 >> 6) & 14);
                                i3 &= -7169;
                            }
                            if (i4 != 0) {
                                f2 = AppBarDefaults.INSTANCE.m1526getTopAppBarElevationD9Ej5fM();
                            }
                            if (i5 != 0) {
                                contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                                modifier3 = modifier2;
                                j5 = j4;
                                float f4 = f2;
                                long j8 = j3;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(883764366, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:227)");
                                }
                                int i10 = i3 >> 6;
                                int i11 = i3 << 15;
                                composer2 = startRestartGroup;
                                m1527AppBarHkEspTQ(j8, j5, f4, contentPadding, RectangleShapeKt.getRectangleShape(), windowInsets, modifier3, function3, composer2, (3670016 & i11) | (i10 & 7168) | (i10 & 14) | 24576 | (i10 & 112) | (i10 & 896) | (i11 & i6) | ((i3 << 3) & 29360128), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                j6 = j8;
                                j7 = j5;
                                f3 = f4;
                                paddingValues3 = contentPadding;
                                modifier4 = modifier3;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                        }
                        modifier3 = modifier2;
                        j5 = j4;
                        contentPadding = paddingValues2;
                        float f42 = f2;
                        long j82 = j3;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i102 = i3 >> 6;
                        int i112 = i3 << 15;
                        composer2 = startRestartGroup;
                        m1527AppBarHkEspTQ(j82, j5, f42, contentPadding, RectangleShapeKt.getRectangleShape(), windowInsets, modifier3, function3, composer2, (3670016 & i112) | (i102 & 7168) | (i102 & 14) | 24576 | (i102 & 112) | (i102 & 896) | (i112 & i6) | ((i3 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        j6 = j82;
                        j7 = j5;
                        f3 = f42;
                        paddingValues3 = contentPadding;
                        modifier4 = modifier3;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        composer2 = startRestartGroup;
                        modifier4 = modifier2;
                        j6 = j3;
                        j7 = j4;
                        f3 = f2;
                        paddingValues3 = paddingValues2;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$4
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
                                AppBarKt.m1532TopAppBarafqeVBk(WindowInsets.this, modifier4, j6, j7, f3, paddingValues3, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                paddingValues2 = paddingValues;
                if ((i2 & 64) == 0) {
                }
                if ((i3 & 2995931) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i9 != 0) {
                }
                if ((i2 & 4) != 0) {
                }
                if ((i2 & 8) != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                modifier3 = modifier2;
                j5 = j4;
                contentPadding = paddingValues2;
                float f422 = f2;
                long j822 = j3;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i1022 = i3 >> 6;
                int i1122 = i3 << 15;
                composer2 = startRestartGroup;
                m1527AppBarHkEspTQ(j822, j5, f422, contentPadding, RectangleShapeKt.getRectangleShape(), windowInsets, modifier3, function3, composer2, (3670016 & i1122) | (i1022 & 7168) | (i1022 & 14) | 24576 | (i1022 & 112) | (i1022 & 896) | (i1122 & i6) | ((i3 << 3) & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                j6 = j822;
                j7 = j5;
                f3 = f422;
                paddingValues3 = contentPadding;
                modifier4 = modifier3;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            f2 = f;
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            paddingValues2 = paddingValues;
            if ((i2 & 64) == 0) {
            }
            if ((i3 & 2995931) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i9 != 0) {
            }
            if ((i2 & 4) != 0) {
            }
            if ((i2 & 8) != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            modifier3 = modifier2;
            j5 = j4;
            contentPadding = paddingValues2;
            float f4222 = f2;
            long j8222 = j3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i10222 = i3 >> 6;
            int i11222 = i3 << 15;
            composer2 = startRestartGroup;
            m1527AppBarHkEspTQ(j8222, j5, f4222, contentPadding, RectangleShapeKt.getRectangleShape(), windowInsets, modifier3, function3, composer2, (3670016 & i11222) | (i10222 & 7168) | (i10222 & 14) | 24576 | (i10222 & 112) | (i10222 & 896) | (i11222 & i6) | ((i3 << 3) & 29360128), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            j6 = j8222;
            j7 = j5;
            f3 = f4222;
            paddingValues3 = contentPadding;
            modifier4 = modifier3;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        if ((i & 896) != 0) {
        }
        if ((i & 7168) != 0) {
        }
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        f2 = f;
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        paddingValues2 = paddingValues;
        if ((i2 & 64) == 0) {
        }
        if ((i3 & 2995931) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i9 != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        modifier3 = modifier2;
        j5 = j4;
        contentPadding = paddingValues2;
        float f42222 = f2;
        long j82222 = j3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i102222 = i3 >> 6;
        int i112222 = i3 << 15;
        composer2 = startRestartGroup;
        m1527AppBarHkEspTQ(j82222, j5, f42222, contentPadding, RectangleShapeKt.getRectangleShape(), windowInsets, modifier3, function3, composer2, (3670016 & i112222) | (i102222 & 7168) | (i102222 & 14) | 24576 | (i102222 & 112) | (i102222 & 896) | (i112222 & i6) | ((i3 << 3) & 29360128), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        j6 = j82222;
        j7 = j5;
        f3 = f42222;
        paddingValues3 = contentPadding;
        modifier4 = modifier3;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0087  */
    /* renamed from: TopAppBar-HsRjFd4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1530TopAppBarHsRjFd4(Modifier modifier, long j, long j2, float f, PaddingValues paddingValues, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long j3;
        long j4;
        float f2;
        int i4;
        PaddingValues paddingValues2;
        Modifier modifier3;
        long j5;
        float f3;
        PaddingValues contentPadding;
        long j6;
        Composer composer2;
        final long j7;
        final long j8;
        final float f4;
        final PaddingValues paddingValues3;
        final Modifier modifier4;
        int i5;
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(1897058582);
        ComposerKt.sourceInformation(startRestartGroup, "C(TopAppBar)P(5,0:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,3)269@12098L6,270@12147L32,275@12356L202:AppBar.kt#jmzs0o");
        int i7 = i2 & 1;
        if (i7 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 14) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 112) == 0) {
            if ((i2 & 2) == 0) {
                j3 = j;
                if (startRestartGroup.changed(j3)) {
                    i6 = 32;
                    i3 |= i6;
                }
            } else {
                j3 = j;
            }
            i6 = 16;
            i3 |= i6;
        } else {
            j3 = j;
        }
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                j4 = j2;
                if (startRestartGroup.changed(j4)) {
                    i5 = 256;
                    i3 |= i5;
                }
            } else {
                j4 = j2;
            }
            i5 = 128;
            i3 |= i5;
        } else {
            j4 = j2;
        }
        int i8 = i2 & 8;
        if (i8 != 0) {
            i3 |= 3072;
        } else if ((i & 7168) == 0) {
            f2 = f;
            i3 |= startRestartGroup.changed(f2) ? 2048 : 1024;
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else if ((57344 & i) == 0) {
                paddingValues2 = paddingValues;
                i3 |= startRestartGroup.changed(paddingValues2) ? 16384 : 8192;
                if ((i2 & 32) != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((458752 & i) == 0) {
                    i3 |= startRestartGroup.changedInstance(function3) ? 131072 : 65536;
                    if ((374491 & i3) == 74898 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion = i7 == 0 ? Modifier.INSTANCE : modifier2;
                            if ((i2 & 2) != 0) {
                                i3 &= -113;
                                j3 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(startRestartGroup, 6));
                            }
                            if ((i2 & 4) != 0) {
                                long m1621contentColorForek8zF_U = ColorsKt.m1621contentColorForek8zF_U(j3, startRestartGroup, (i3 >> 3) & 14);
                                i3 &= -897;
                                j4 = m1621contentColorForek8zF_U;
                            }
                            if (i8 != 0) {
                                f2 = AppBarDefaults.INSTANCE.m1526getTopAppBarElevationD9Ej5fM();
                            }
                            if (i4 == 0) {
                                modifier3 = companion;
                                j5 = j4;
                                f3 = f2;
                                contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                                j6 = j3;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1897058582, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:274)");
                                }
                                int i9 = i3 >> 3;
                                composer2 = startRestartGroup;
                                m1527AppBarHkEspTQ(j6, j5, f3, contentPadding, RectangleShapeKt.getRectangleShape(), ZeroInsets, modifier3, function3, composer2, (i9 & 7168) | (i9 & 14) | 221184 | (i9 & 112) | (i9 & 896) | ((i3 << 18) & 3670016) | ((i3 << 6) & 29360128), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                j7 = j6;
                                j8 = j5;
                                f4 = f3;
                                paddingValues3 = contentPadding;
                                modifier4 = modifier3;
                            } else {
                                modifier3 = companion;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 2) != 0) {
                                i3 &= -113;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            modifier3 = modifier2;
                        }
                        f3 = f2;
                        j6 = j3;
                        contentPadding = paddingValues2;
                        j5 = j4;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i92 = i3 >> 3;
                        composer2 = startRestartGroup;
                        m1527AppBarHkEspTQ(j6, j5, f3, contentPadding, RectangleShapeKt.getRectangleShape(), ZeroInsets, modifier3, function3, composer2, (i92 & 7168) | (i92 & 14) | 221184 | (i92 & 112) | (i92 & 896) | ((i3 << 18) & 3670016) | ((i3 << 6) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        j7 = j6;
                        j8 = j5;
                        f4 = f3;
                        paddingValues3 = contentPadding;
                        modifier4 = modifier3;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        composer2 = startRestartGroup;
                        modifier4 = modifier2;
                        j7 = j3;
                        j8 = j4;
                        f4 = f2;
                        paddingValues3 = paddingValues2;
                    }
                    ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$TopAppBar$5
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

                            public final void invoke(Composer composer3, int i10) {
                                AppBarKt.m1530TopAppBarHsRjFd4(Modifier.this, j7, j8, f4, paddingValues3, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                if ((374491 & i3) == 74898) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i7 == 0) {
                }
                if ((i2 & 2) != 0) {
                }
                if ((i2 & 4) != 0) {
                }
                if (i8 != 0) {
                }
                if (i4 == 0) {
                }
            }
            paddingValues2 = paddingValues;
            if ((i2 & 32) != 0) {
            }
            if ((374491 & i3) == 74898) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i7 == 0) {
            }
            if ((i2 & 2) != 0) {
            }
            if ((i2 & 4) != 0) {
            }
            if (i8 != 0) {
            }
            if (i4 == 0) {
            }
        }
        f2 = f;
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        paddingValues2 = paddingValues;
        if ((i2 & 32) != 0) {
        }
        if ((374491 & i3) == 74898) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i7 == 0) {
        }
        if ((i2 & 2) != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if (i8 != 0) {
        }
        if (i4 == 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01b6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00d1  */
    /* renamed from: BottomAppBar-DanWW-k, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1528BottomAppBarDanWWk(final WindowInsets windowInsets, Modifier modifier, long j, long j2, Shape shape, float f, PaddingValues paddingValues, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        long j3;
        long j4;
        int i4;
        Shape shape2;
        int i5;
        int i6;
        float f2;
        int i7;
        PaddingValues contentPadding;
        Shape shape3;
        BottomAppBarCutoutShape rectangleShape;
        Composer composer2;
        final Shape shape4;
        final long j5;
        final long j6;
        final float f3;
        final PaddingValues paddingValues2;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(382658343);
        ComposerKt.sourceInformation(startRestartGroup, "C(BottomAppBar)P(7,6,0:c#ui.graphics.Color,2:c#ui.graphics.Color,4,5:c#ui.unit.Dp,3)335@15300L6,336@15349L32,342@15630L7,348@15820L174:AppBar.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changed(windowInsets) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i10 = i2 & 2;
        if (i10 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i & 896) != 0) {
                if ((i2 & 4) == 0) {
                    j3 = j;
                    if (startRestartGroup.changed(j3)) {
                        i9 = 256;
                        i3 |= i9;
                    }
                } else {
                    j3 = j;
                }
                i9 = 128;
                i3 |= i9;
            } else {
                j3 = j;
            }
            if ((i & 7168) != 0) {
                if ((i2 & 8) == 0) {
                    j4 = j2;
                    if (startRestartGroup.changed(j4)) {
                        i8 = 2048;
                        i3 |= i8;
                    }
                } else {
                    j4 = j2;
                }
                i8 = 1024;
                i3 |= i8;
            } else {
                j4 = j2;
            }
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else if ((57344 & i) == 0) {
                shape2 = shape;
                i3 |= startRestartGroup.changed(shape2) ? 16384 : 8192;
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    i6 = 458752;
                    f2 = f;
                } else {
                    i6 = 458752;
                    f2 = f;
                    if ((i & 458752) == 0) {
                        i3 |= startRestartGroup.changed(f2) ? 131072 : 65536;
                    }
                }
                i7 = i2 & 64;
                if (i7 != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    i3 |= startRestartGroup.changed(paddingValues) ? 1048576 : 524288;
                }
                if ((i2 & 128) != 0) {
                    i3 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    i3 |= startRestartGroup.changedInstance(function3) ? 8388608 : 4194304;
                    if ((i3 & 23967451) == 4793490 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            if (i10 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                j3 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(startRestartGroup, 6));
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                j4 = ColorsKt.m1621contentColorForek8zF_U(j3, startRestartGroup, (i3 >> 6) & 14);
                                i3 &= -7169;
                            }
                            if (i4 != 0) {
                                shape2 = null;
                            }
                            if (i5 != 0) {
                                f2 = AppBarDefaults.INSTANCE.m1525getBottomAppBarElevationD9Ej5fM();
                            }
                            if (i7 != 0) {
                                contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                                Modifier modifier4 = modifier2;
                                shape3 = shape2;
                                long j7 = j3;
                                float f4 = f2;
                                long j8 = j4;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(382658343, i3, -1, "androidx.compose.material.BottomAppBar (AppBar.kt:341)");
                                }
                                ProvidableCompositionLocal<FabPlacement> localFabPlacement = ScaffoldKt.getLocalFabPlacement();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume = startRestartGroup.consume(localFabPlacement);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                FabPlacement fabPlacement = (FabPlacement) consume;
                                if (shape3 == null && fabPlacement != null && fabPlacement.getIsDocked()) {
                                    rectangleShape = new BottomAppBarCutoutShape(shape3, fabPlacement);
                                } else {
                                    rectangleShape = RectangleShapeKt.getRectangleShape();
                                }
                                int i11 = i3 >> 9;
                                int i12 = ((i3 >> 6) & 126) | (i11 & 896) | (i11 & 7168);
                                int i13 = i3 << 15;
                                composer2 = startRestartGroup;
                                m1527AppBarHkEspTQ(j7, j8, f4, contentPadding, rectangleShape, windowInsets, modifier4, function3, composer2, (3670016 & i13) | i12 | (i13 & i6) | (i3 & 29360128), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                shape4 = shape3;
                                j5 = j7;
                                j6 = j8;
                                f3 = f4;
                                paddingValues2 = contentPadding;
                                modifier3 = modifier4;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                        }
                        contentPadding = paddingValues;
                        Modifier modifier42 = modifier2;
                        shape3 = shape2;
                        long j72 = j3;
                        float f42 = f2;
                        long j82 = j4;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ProvidableCompositionLocal<FabPlacement> localFabPlacement2 = ScaffoldKt.getLocalFabPlacement();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume2 = startRestartGroup.consume(localFabPlacement2);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        FabPlacement fabPlacement2 = (FabPlacement) consume2;
                        if (shape3 == null) {
                        }
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                        int i112 = i3 >> 9;
                        int i122 = ((i3 >> 6) & 126) | (i112 & 896) | (i112 & 7168);
                        int i132 = i3 << 15;
                        composer2 = startRestartGroup;
                        m1527AppBarHkEspTQ(j72, j82, f42, contentPadding, rectangleShape, windowInsets, modifier42, function3, composer2, (3670016 & i132) | i122 | (i132 & i6) | (i3 & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        shape4 = shape3;
                        j5 = j72;
                        j6 = j82;
                        f3 = f42;
                        paddingValues2 = contentPadding;
                        modifier3 = modifier42;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        composer2 = startRestartGroup;
                        modifier3 = modifier2;
                        j5 = j3;
                        j6 = j4;
                        shape4 = shape2;
                        f3 = f2;
                        paddingValues2 = paddingValues;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$BottomAppBar$1
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

                            public final void invoke(Composer composer3, int i14) {
                                AppBarKt.m1528BottomAppBarDanWWk(WindowInsets.this, modifier3, j5, j6, shape4, f3, paddingValues2, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                if ((i3 & 23967451) == 4793490) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i10 != 0) {
                }
                if ((i2 & 4) != 0) {
                }
                if ((i2 & 8) != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if (i7 != 0) {
                }
                contentPadding = paddingValues;
                Modifier modifier422 = modifier2;
                shape3 = shape2;
                long j722 = j3;
                float f422 = f2;
                long j822 = j4;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                ProvidableCompositionLocal<FabPlacement> localFabPlacement22 = ScaffoldKt.getLocalFabPlacement();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume22 = startRestartGroup.consume(localFabPlacement22);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                FabPlacement fabPlacement22 = (FabPlacement) consume22;
                if (shape3 == null) {
                }
                rectangleShape = RectangleShapeKt.getRectangleShape();
                int i1122 = i3 >> 9;
                int i1222 = ((i3 >> 6) & 126) | (i1122 & 896) | (i1122 & 7168);
                int i1322 = i3 << 15;
                composer2 = startRestartGroup;
                m1527AppBarHkEspTQ(j722, j822, f422, contentPadding, rectangleShape, windowInsets, modifier422, function3, composer2, (3670016 & i1322) | i1222 | (i1322 & i6) | (i3 & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                shape4 = shape3;
                j5 = j722;
                j6 = j822;
                f3 = f422;
                paddingValues2 = contentPadding;
                modifier3 = modifier422;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            shape2 = shape;
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            i7 = i2 & 64;
            if (i7 != 0) {
            }
            if ((i2 & 128) != 0) {
            }
            if ((i3 & 23967451) == 4793490) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i10 != 0) {
            }
            if ((i2 & 4) != 0) {
            }
            if ((i2 & 8) != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if (i7 != 0) {
            }
            contentPadding = paddingValues;
            Modifier modifier4222 = modifier2;
            shape3 = shape2;
            long j7222 = j3;
            float f4222 = f2;
            long j8222 = j4;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            ProvidableCompositionLocal<FabPlacement> localFabPlacement222 = ScaffoldKt.getLocalFabPlacement();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume222 = startRestartGroup.consume(localFabPlacement222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            FabPlacement fabPlacement222 = (FabPlacement) consume222;
            if (shape3 == null) {
            }
            rectangleShape = RectangleShapeKt.getRectangleShape();
            int i11222 = i3 >> 9;
            int i12222 = ((i3 >> 6) & 126) | (i11222 & 896) | (i11222 & 7168);
            int i13222 = i3 << 15;
            composer2 = startRestartGroup;
            m1527AppBarHkEspTQ(j7222, j8222, f4222, contentPadding, rectangleShape, windowInsets, modifier4222, function3, composer2, (3670016 & i13222) | i12222 | (i13222 & i6) | (i3 & 29360128), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            shape4 = shape3;
            j5 = j7222;
            j6 = j8222;
            f3 = f4222;
            paddingValues2 = contentPadding;
            modifier3 = modifier4222;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        if ((i & 896) != 0) {
        }
        if ((i & 7168) != 0) {
        }
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        shape2 = shape;
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        i7 = i2 & 64;
        if (i7 != 0) {
        }
        if ((i2 & 128) != 0) {
        }
        if ((i3 & 23967451) == 4793490) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i10 != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if (i7 != 0) {
        }
        contentPadding = paddingValues;
        Modifier modifier42222 = modifier2;
        shape3 = shape2;
        long j72222 = j3;
        float f42222 = f2;
        long j82222 = j4;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        ProvidableCompositionLocal<FabPlacement> localFabPlacement2222 = ScaffoldKt.getLocalFabPlacement();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2222 = startRestartGroup.consume(localFabPlacement2222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        FabPlacement fabPlacement2222 = (FabPlacement) consume2222;
        if (shape3 == null) {
        }
        rectangleShape = RectangleShapeKt.getRectangleShape();
        int i112222 = i3 >> 9;
        int i122222 = ((i3 >> 6) & 126) | (i112222 & 896) | (i112222 & 7168);
        int i132222 = i3 << 15;
        composer2 = startRestartGroup;
        m1527AppBarHkEspTQ(j72222, j82222, f42222, contentPadding, rectangleShape, windowInsets, modifier42222, function3, composer2, (3670016 & i132222) | i122222 | (i132222 & i6) | (i3 & 29360128), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        shape4 = shape3;
        j5 = j72222;
        j6 = j82222;
        f3 = f42222;
        paddingValues2 = contentPadding;
        modifier3 = modifier42222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00aa  */
    /* renamed from: BottomAppBar-Y1yfwus, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1529BottomAppBarY1yfwus(Modifier modifier, long j, long j2, Shape shape, float f, PaddingValues paddingValues, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long j3;
        long j4;
        Shape shape2;
        int i4;
        float f2;
        int i5;
        int i6;
        PaddingValues paddingValues2;
        Modifier modifier3;
        PaddingValues contentPadding;
        Shape shape3;
        float f3;
        int i7;
        long j5;
        BottomAppBarCutoutShape rectangleShape;
        Composer composer2;
        final Shape shape4;
        final long j6;
        final long j7;
        final float f4;
        final PaddingValues paddingValues3;
        final Modifier modifier4;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(-1651948973);
        ComposerKt.sourceInformation(startRestartGroup, "C(BottomAppBar)P(6,0:c#ui.graphics.Color,2:c#ui.graphics.Color,4,5:c#ui.unit.Dp,3)403@18483L6,404@18532L32,410@18813L7,416@19003L172:AppBar.kt#jmzs0o");
        int i10 = i2 & 1;
        if (i10 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 14) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 112) == 0) {
            if ((i2 & 2) == 0) {
                j3 = j;
                if (startRestartGroup.changed(j3)) {
                    i9 = 32;
                    i3 |= i9;
                }
            } else {
                j3 = j;
            }
            i9 = 16;
            i3 |= i9;
        } else {
            j3 = j;
        }
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                j4 = j2;
                if (startRestartGroup.changed(j4)) {
                    i8 = 256;
                    i3 |= i8;
                }
            } else {
                j4 = j2;
            }
            i8 = 128;
            i3 |= i8;
        } else {
            j4 = j2;
        }
        int i11 = i2 & 8;
        if (i11 != 0) {
            i3 |= 3072;
        } else if ((i & 7168) == 0) {
            shape2 = shape;
            i3 |= startRestartGroup.changed(shape2) ? 2048 : 1024;
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else if ((57344 & i) == 0) {
                f2 = f;
                i3 |= startRestartGroup.changed(f2) ? 16384 : 8192;
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    i6 = 196608;
                    paddingValues2 = paddingValues;
                } else {
                    i6 = 196608;
                    paddingValues2 = paddingValues;
                    if ((i & 458752) == 0) {
                        i3 |= startRestartGroup.changed(paddingValues2) ? 131072 : 65536;
                    }
                }
                if ((i2 & 64) != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    i3 |= startRestartGroup.changedInstance(function3) ? 1048576 : 524288;
                }
                if ((i3 & 2995931) == 599186 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        Modifier.Companion companion = i10 != 0 ? Modifier.INSTANCE : modifier2;
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            j3 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(startRestartGroup, 6));
                        }
                        if ((i2 & 4) != 0) {
                            long m1621contentColorForek8zF_U = ColorsKt.m1621contentColorForek8zF_U(j3, startRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                            j4 = m1621contentColorForek8zF_U;
                        }
                        if (i11 != 0) {
                            shape2 = null;
                        }
                        if (i4 != 0) {
                            f2 = AppBarDefaults.INSTANCE.m1525getBottomAppBarElevationD9Ej5fM();
                        }
                        if (i5 != 0) {
                            modifier3 = companion;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            shape3 = shape2;
                            f3 = f2;
                            i7 = -1651948973;
                            j5 = j3;
                            long j8 = j4;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i7, i3, -1, "androidx.compose.material.BottomAppBar (AppBar.kt:409)");
                            }
                            ProvidableCompositionLocal<FabPlacement> localFabPlacement = ScaffoldKt.getLocalFabPlacement();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume = startRestartGroup.consume(localFabPlacement);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            FabPlacement fabPlacement = (FabPlacement) consume;
                            if (shape3 == null && fabPlacement != null && fabPlacement.getIsDocked()) {
                                rectangleShape = new BottomAppBarCutoutShape(shape3, fabPlacement);
                            } else {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            }
                            int i12 = i3 >> 3;
                            int i13 = i3 >> 6;
                            composer2 = startRestartGroup;
                            m1527AppBarHkEspTQ(j5, j8, f3, contentPadding, rectangleShape, ZeroInsets, modifier3, function3, composer2, (i12 & 112) | (i12 & 14) | i6 | (i13 & 896) | (i13 & 7168) | ((i3 << 18) & 3670016) | ((i3 << 3) & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            shape4 = shape3;
                            j6 = j5;
                            j7 = j8;
                            f4 = f3;
                            paddingValues3 = contentPadding;
                            modifier4 = modifier3;
                        } else {
                            modifier3 = companion;
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        modifier3 = modifier2;
                    }
                    shape3 = shape2;
                    contentPadding = paddingValues2;
                    i7 = -1651948973;
                    j5 = j3;
                    f3 = f2;
                    long j82 = j4;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ProvidableCompositionLocal<FabPlacement> localFabPlacement2 = ScaffoldKt.getLocalFabPlacement();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume2 = startRestartGroup.consume(localFabPlacement2);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    FabPlacement fabPlacement2 = (FabPlacement) consume2;
                    if (shape3 == null) {
                    }
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                    int i122 = i3 >> 3;
                    int i132 = i3 >> 6;
                    composer2 = startRestartGroup;
                    m1527AppBarHkEspTQ(j5, j82, f3, contentPadding, rectangleShape, ZeroInsets, modifier3, function3, composer2, (i122 & 112) | (i122 & 14) | i6 | (i132 & 896) | (i132 & 7168) | ((i3 << 18) & 3670016) | ((i3 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    shape4 = shape3;
                    j6 = j5;
                    j7 = j82;
                    f4 = f3;
                    paddingValues3 = contentPadding;
                    modifier4 = modifier3;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    composer2 = startRestartGroup;
                    modifier4 = modifier2;
                    j6 = j3;
                    j7 = j4;
                    shape4 = shape2;
                    f4 = f2;
                    paddingValues3 = paddingValues2;
                }
                ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$BottomAppBar$2
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

                        public final void invoke(Composer composer3, int i14) {
                            AppBarKt.m1529BottomAppBarY1yfwus(Modifier.this, j6, j7, shape4, f4, paddingValues3, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            f2 = f;
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            if ((i2 & 64) != 0) {
            }
            if ((i3 & 2995931) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i10 != 0) {
            }
            if ((i2 & 2) != 0) {
            }
            if ((i2 & 4) != 0) {
            }
            if (i11 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
        }
        shape2 = shape;
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        f2 = f;
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if ((i3 & 2995931) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i10 != 0) {
        }
        if ((i2 & 2) != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if (i11 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
    }

    public static final float calculateCutoutCircleYIntercept(float f, float f2) {
        return -((float) Math.sqrt((f * f) - (f2 * f2)));
    }

    public static final Pair<Float, Float> calculateRoundedEdgeIntercept(float f, float f2, float f3) {
        Float valueOf;
        Float valueOf2;
        Pair pair;
        Float valueOf3;
        Float valueOf4;
        float f4 = f2 * f2;
        float f5 = f3 * f3;
        float f6 = (f * f) + f4;
        float f7 = f4 * f5 * (f6 - f5);
        float f8 = f * f5;
        double d = f7;
        float sqrt = (f8 - ((float) Math.sqrt(d))) / f6;
        float sqrt2 = (f8 + ((float) Math.sqrt(d))) / f6;
        float sqrt3 = (float) Math.sqrt(f5 - (sqrt * sqrt));
        float sqrt4 = (float) Math.sqrt(f5 - (sqrt2 * sqrt2));
        if (f2 > 0.0f) {
            if (sqrt3 > sqrt4) {
                valueOf3 = Float.valueOf(sqrt);
                valueOf4 = Float.valueOf(sqrt3);
            } else {
                valueOf3 = Float.valueOf(sqrt2);
                valueOf4 = Float.valueOf(sqrt4);
            }
            pair = TuplesKt.to(valueOf3, valueOf4);
        } else {
            if (sqrt3 < sqrt4) {
                valueOf = Float.valueOf(sqrt);
                valueOf2 = Float.valueOf(sqrt3);
            } else {
                valueOf = Float.valueOf(sqrt2);
                valueOf2 = Float.valueOf(sqrt4);
            }
            pair = TuplesKt.to(valueOf, valueOf2);
        }
        float floatValue = ((Number) pair.component1()).floatValue();
        float floatValue2 = ((Number) pair.component2()).floatValue();
        if (floatValue < f) {
            floatValue2 = -floatValue2;
        }
        return TuplesKt.to(Float.valueOf(floatValue), Float.valueOf(floatValue2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0074  */
    /* renamed from: AppBar-HkEspTQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1527AppBarHkEspTQ(final long j, final long j2, final float f, final PaddingValues paddingValues, final Shape shape, final WindowInsets windowInsets, Modifier modifier, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        long j3;
        float f2;
        Shape shape2;
        int i4;
        int i5;
        int i6;
        Modifier modifier2;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(-712505634);
        ComposerKt.sourceInformation(startRestartGroup, "C(AppBar)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,3,6,7,5)720@31583L659:AppBar.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            j3 = j2;
        } else {
            j3 = j2;
            if ((i & 112) == 0) {
                i3 |= startRestartGroup.changed(j3) ? 32 : 16;
            }
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            f2 = f;
            i3 |= startRestartGroup.changed(f2) ? 256 : 128;
            if ((i2 & 8) == 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                i3 |= startRestartGroup.changed(paddingValues) ? 2048 : 1024;
            }
            if ((i2 & 16) == 0) {
                i3 |= 24576;
            } else if ((57344 & i) == 0) {
                shape2 = shape;
                i3 |= startRestartGroup.changed(shape2) ? 16384 : 8192;
                if ((i2 & 32) != 0) {
                    i4 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else {
                    if ((i & 458752) == 0) {
                        i4 = startRestartGroup.changed(windowInsets) ? 131072 : 65536;
                    }
                    i5 = i2 & 64;
                    if (i5 == 0) {
                        i3 |= 1572864;
                        i6 = 458752;
                        modifier2 = modifier;
                    } else {
                        i6 = 458752;
                        modifier2 = modifier;
                        if ((i & 3670016) == 0) {
                            i3 |= startRestartGroup.changed(modifier2) ? 1048576 : 524288;
                        }
                    }
                    if ((i2 & 128) != 0) {
                        i7 = (29360128 & i) == 0 ? startRestartGroup.changedInstance(function3) ? 8388608 : 4194304 : 12582912;
                        if ((23967451 & i3) == 4793490 || !startRestartGroup.getSkipping()) {
                            if (i5 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-712505634, i3, -1, "androidx.compose.material.AppBar (AppBar.kt:719)");
                            }
                            int i8 = i3 << 6;
                            composer2 = startRestartGroup;
                            long j4 = j3;
                            Modifier modifier4 = modifier2;
                            SurfaceKt.m1782SurfaceFjzlyU(modifier4, shape2, j, j4, null, f2, ComposableLambdaKt.composableLambda(startRestartGroup, 213273114, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1
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

                                public final void invoke(Composer composer3, int i9) {
                                    ComposerKt.sourceInformation(composer3, "C727@31825L6,727@31760L476:AppBar.kt#jmzs0o");
                                    if ((i9 & 11) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(213273114, i9, -1, "androidx.compose.material.AppBar.<anonymous> (AppBar.kt:727)");
                                        }
                                        ProvidedValue<Float> provides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer3, 6)));
                                        final WindowInsets windowInsets2 = WindowInsets.this;
                                        final PaddingValues paddingValues2 = paddingValues;
                                        final Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                                        CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer3, 600325466, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1.1
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

                                            public final void invoke(Composer composer4, int i10) {
                                                float f3;
                                                ComposerKt.sourceInformation(composer4, "C728@31847L379:AppBar.kt#jmzs0o");
                                                if ((i10 & 11) != 2 || !composer4.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(600325466, i10, -1, "androidx.compose.material.AppBar.<anonymous>.<anonymous> (AppBar.kt:728)");
                                                    }
                                                    Modifier padding = PaddingKt.padding(WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), WindowInsets.this), paddingValues2);
                                                    f3 = AppBarKt.AppBarHeight;
                                                    Modifier m914height3ABfNKs = SizeKt.m914height3ABfNKs(padding, f3);
                                                    Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                    Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                                                    composer4.startReplaceableGroup(693286680);
                                                    ComposerKt.sourceInformation(composer4, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer4, 54);
                                                    composer4.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                    CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m914height3ABfNKs);
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
                                                    function33.invoke(RowScopeInstance.INSTANCE, composer4, 6);
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
                                        }), composer3, ProvidedValue.$stable | 48);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), composer2, ((i3 >> 18) & 14) | 1572864 | ((i3 >> 9) & 112) | (i8 & 896) | (i8 & 7168) | ((i3 << 9) & i6), 16);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            composer2 = startRestartGroup;
                            modifier3 = modifier2;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$2
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

                                public final void invoke(Composer composer3, int i9) {
                                    AppBarKt.m1527AppBarHkEspTQ(j, j2, f, paddingValues, shape, windowInsets, modifier3, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i3 |= i7;
                    if ((23967451 & i3) == 4793490) {
                    }
                    if (i5 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i82 = i3 << 6;
                    composer2 = startRestartGroup;
                    long j42 = j3;
                    Modifier modifier42 = modifier2;
                    SurfaceKt.m1782SurfaceFjzlyU(modifier42, shape2, j, j42, null, f2, ComposableLambdaKt.composableLambda(startRestartGroup, 213273114, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1
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

                        public final void invoke(Composer composer3, int i9) {
                            ComposerKt.sourceInformation(composer3, "C727@31825L6,727@31760L476:AppBar.kt#jmzs0o");
                            if ((i9 & 11) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(213273114, i9, -1, "androidx.compose.material.AppBar.<anonymous> (AppBar.kt:727)");
                                }
                                ProvidedValue<Float> provides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer3, 6)));
                                final WindowInsets windowInsets2 = WindowInsets.this;
                                final PaddingValues paddingValues2 = paddingValues;
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                                CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer3, 600325466, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1.1
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

                                    public final void invoke(Composer composer4, int i10) {
                                        float f3;
                                        ComposerKt.sourceInformation(composer4, "C728@31847L379:AppBar.kt#jmzs0o");
                                        if ((i10 & 11) != 2 || !composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(600325466, i10, -1, "androidx.compose.material.AppBar.<anonymous>.<anonymous> (AppBar.kt:728)");
                                            }
                                            Modifier padding = PaddingKt.padding(WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), WindowInsets.this), paddingValues2);
                                            f3 = AppBarKt.AppBarHeight;
                                            Modifier m914height3ABfNKs = SizeKt.m914height3ABfNKs(padding, f3);
                                            Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                            Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                                            composer4.startReplaceableGroup(693286680);
                                            ComposerKt.sourceInformation(composer4, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer4, 54);
                                            composer4.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m914height3ABfNKs);
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
                                            function33.invoke(RowScopeInstance.INSTANCE, composer4, 6);
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
                                }), composer3, ProvidedValue.$stable | 48);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), composer2, ((i3 >> 18) & 14) | 1572864 | ((i3 >> 9) & 112) | (i82 & 896) | (i82 & 7168) | ((i3 << 9) & i6), 16);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier42;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i3 |= i4;
                i5 = i2 & 64;
                if (i5 == 0) {
                }
                if ((i2 & 128) != 0) {
                }
                i3 |= i7;
                if ((23967451 & i3) == 4793490) {
                }
                if (i5 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                int i822 = i3 << 6;
                composer2 = startRestartGroup;
                long j422 = j3;
                Modifier modifier422 = modifier2;
                SurfaceKt.m1782SurfaceFjzlyU(modifier422, shape2, j, j422, null, f2, ComposableLambdaKt.composableLambda(startRestartGroup, 213273114, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1
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

                    public final void invoke(Composer composer3, int i9) {
                        ComposerKt.sourceInformation(composer3, "C727@31825L6,727@31760L476:AppBar.kt#jmzs0o");
                        if ((i9 & 11) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(213273114, i9, -1, "androidx.compose.material.AppBar.<anonymous> (AppBar.kt:727)");
                            }
                            ProvidedValue<Float> provides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer3, 6)));
                            final WindowInsets windowInsets2 = WindowInsets.this;
                            final PaddingValues paddingValues2 = paddingValues;
                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                            CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer3, 600325466, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1.1
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

                                public final void invoke(Composer composer4, int i10) {
                                    float f3;
                                    ComposerKt.sourceInformation(composer4, "C728@31847L379:AppBar.kt#jmzs0o");
                                    if ((i10 & 11) != 2 || !composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(600325466, i10, -1, "androidx.compose.material.AppBar.<anonymous>.<anonymous> (AppBar.kt:728)");
                                        }
                                        Modifier padding = PaddingKt.padding(WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), WindowInsets.this), paddingValues2);
                                        f3 = AppBarKt.AppBarHeight;
                                        Modifier m914height3ABfNKs = SizeKt.m914height3ABfNKs(padding, f3);
                                        Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                        Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                                        composer4.startReplaceableGroup(693286680);
                                        ComposerKt.sourceInformation(composer4, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer4, 54);
                                        composer4.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m914height3ABfNKs);
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
                                        function33.invoke(RowScopeInstance.INSTANCE, composer4, 6);
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
                            }), composer3, ProvidedValue.$stable | 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), composer2, ((i3 >> 18) & 14) | 1572864 | ((i3 >> 9) & 112) | (i822 & 896) | (i822 & 7168) | ((i3 << 9) & i6), 16);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier422;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            shape2 = shape;
            if ((i2 & 32) != 0) {
            }
            i3 |= i4;
            i5 = i2 & 64;
            if (i5 == 0) {
            }
            if ((i2 & 128) != 0) {
            }
            i3 |= i7;
            if ((23967451 & i3) == 4793490) {
            }
            if (i5 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            int i8222 = i3 << 6;
            composer2 = startRestartGroup;
            long j4222 = j3;
            Modifier modifier4222 = modifier2;
            SurfaceKt.m1782SurfaceFjzlyU(modifier4222, shape2, j, j4222, null, f2, ComposableLambdaKt.composableLambda(startRestartGroup, 213273114, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1
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

                public final void invoke(Composer composer3, int i9) {
                    ComposerKt.sourceInformation(composer3, "C727@31825L6,727@31760L476:AppBar.kt#jmzs0o");
                    if ((i9 & 11) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(213273114, i9, -1, "androidx.compose.material.AppBar.<anonymous> (AppBar.kt:727)");
                        }
                        ProvidedValue<Float> provides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer3, 6)));
                        final WindowInsets windowInsets2 = WindowInsets.this;
                        final PaddingValues paddingValues2 = paddingValues;
                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                        CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer3, 600325466, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1.1
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

                            public final void invoke(Composer composer4, int i10) {
                                float f3;
                                ComposerKt.sourceInformation(composer4, "C728@31847L379:AppBar.kt#jmzs0o");
                                if ((i10 & 11) != 2 || !composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(600325466, i10, -1, "androidx.compose.material.AppBar.<anonymous>.<anonymous> (AppBar.kt:728)");
                                    }
                                    Modifier padding = PaddingKt.padding(WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), WindowInsets.this), paddingValues2);
                                    f3 = AppBarKt.AppBarHeight;
                                    Modifier m914height3ABfNKs = SizeKt.m914height3ABfNKs(padding, f3);
                                    Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                    Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                                    composer4.startReplaceableGroup(693286680);
                                    ComposerKt.sourceInformation(composer4, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer4, 54);
                                    composer4.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m914height3ABfNKs);
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
                                    function33.invoke(RowScopeInstance.INSTANCE, composer4, 6);
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
                        }), composer3, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), composer2, ((i3 >> 18) & 14) | 1572864 | ((i3 >> 9) & 112) | (i8222 & 896) | (i8222 & 7168) | ((i3 << 9) & i6), 16);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier4222;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        f2 = f;
        if ((i2 & 8) == 0) {
        }
        if ((i2 & 16) == 0) {
        }
        shape2 = shape;
        if ((i2 & 32) != 0) {
        }
        i3 |= i4;
        i5 = i2 & 64;
        if (i5 == 0) {
        }
        if ((i2 & 128) != 0) {
        }
        i3 |= i7;
        if ((23967451 & i3) == 4793490) {
        }
        if (i5 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        int i82222 = i3 << 6;
        composer2 = startRestartGroup;
        long j42222 = j3;
        Modifier modifier42222 = modifier2;
        SurfaceKt.m1782SurfaceFjzlyU(modifier42222, shape2, j, j42222, null, f2, ComposableLambdaKt.composableLambda(startRestartGroup, 213273114, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1
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

            public final void invoke(Composer composer3, int i9) {
                ComposerKt.sourceInformation(composer3, "C727@31825L6,727@31760L476:AppBar.kt#jmzs0o");
                if ((i9 & 11) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(213273114, i9, -1, "androidx.compose.material.AppBar.<anonymous> (AppBar.kt:727)");
                    }
                    ProvidedValue<Float> provides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer3, 6)));
                    final WindowInsets windowInsets2 = WindowInsets.this;
                    final PaddingValues paddingValues2 = paddingValues;
                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                    CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer3, 600325466, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AppBarKt$AppBar$1.1
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

                        public final void invoke(Composer composer4, int i10) {
                            float f3;
                            ComposerKt.sourceInformation(composer4, "C728@31847L379:AppBar.kt#jmzs0o");
                            if ((i10 & 11) != 2 || !composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(600325466, i10, -1, "androidx.compose.material.AppBar.<anonymous>.<anonymous> (AppBar.kt:728)");
                                }
                                Modifier padding = PaddingKt.padding(WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), WindowInsets.this), paddingValues2);
                                f3 = AppBarKt.AppBarHeight;
                                Modifier m914height3ABfNKs = SizeKt.m914height3ABfNKs(padding, f3);
                                Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                                composer4.startReplaceableGroup(693286680);
                                ComposerKt.sourceInformation(composer4, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer4, 54);
                                composer4.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m914height3ABfNKs);
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
                                function33.invoke(RowScopeInstance.INSTANCE, composer4, 6);
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
                    }), composer3, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }), composer2, ((i3 >> 18) & 14) | 1572864 | ((i3 >> 9) & 112) | (i82222 & 896) | (i82222 & 7168) | ((i3 << 9) & i6), 16);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier42222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    static {
        float f = 4;
        float m6389constructorimpl = Dp.m6389constructorimpl(f);
        AppBarHorizontalPadding = m6389constructorimpl;
        TitleInsetWithoutIcon = SizeKt.m933width3ABfNKs(Modifier.INSTANCE, Dp.m6389constructorimpl(Dp.m6389constructorimpl(16) - m6389constructorimpl));
        TitleIconModifier = SizeKt.m933width3ABfNKs(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6389constructorimpl(Dp.m6389constructorimpl(72) - m6389constructorimpl));
        BottomAppBarCutoutOffset = Dp.m6389constructorimpl(8);
        BottomAppBarRoundedEdgeRadius = Dp.m6389constructorimpl(f);
        ZeroInsets = WindowInsetsKt.m953WindowInsetsa9UjIt4$default(Dp.m6389constructorimpl(0), 0.0f, 0.0f, 0.0f, 14, null);
    }
}
