package androidx.compose.material3;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.Strings;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import com.vungle.ads.internal.protos.Sdk;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: BottomSheetScaffold.kt */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u001a\u008a\u0002\u0010\u0000\u001a\u00020\u00012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\f2\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00052\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u00112\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001aÀ\u0001\u0010\"\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00052&\u0010#\u001a\"\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052&\u0010'\u001a\"\u0012\u0013\u0012\u00110(¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u00052\u0006\u0010\u000b\u001a\u00020\f2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u00162\u0006\u0010,\u001a\u00020-2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0011H\u0003ø\u0001\u0000¢\u0006\u0004\b.\u0010/\u001a¶\u0001\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020-2'\u00102\u001a#\u0012\u0013\u0012\u001103¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(4\u0012\n\u0012\b\u0012\u0004\u0012\u000206050\u00032\u0006\u00107\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u00108\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u00109\u001a\u00020\f2\u0006\u0010:\u001a\u00020\f2\u0013\u0010;\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00052\u001c\u0010\u001e\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0006H\u0003ø\u0001\u0000¢\u0006\u0004\b<\u0010=\u001a!\u0010>\u001a\u00020\n2\b\b\u0002\u0010?\u001a\u00020-2\b\b\u0002\u0010@\u001a\u00020\u001bH\u0007¢\u0006\u0002\u0010A\u001a7\u0010B\u001a\u00020-2\b\b\u0002\u0010C\u001a\u0002062\u0014\b\u0002\u0010D\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u00180\u00032\b\b\u0002\u0010E\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010F\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006G"}, d2 = {"BottomSheetScaffold", "", "sheetContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material3/BottomSheetScaffoldState;", "sheetPeekHeight", "Landroidx/compose/ui/unit/Dp;", "sheetMaxWidth", "sheetShape", "Landroidx/compose/ui/graphics/Shape;", "sheetContainerColor", "Landroidx/compose/ui/graphics/Color;", "sheetContentColor", "sheetTonalElevation", "sheetShadowElevation", "sheetDragHandle", "Lkotlin/Function0;", "sheetSwipeEnabled", "", "topBar", "snackbarHost", "Landroidx/compose/material3/SnackbarHostState;", "containerColor", "contentColor", "content", "Landroidx/compose/foundation/layout/PaddingValues;", "BottomSheetScaffold-sdMYb0k", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/BottomSheetScaffoldState;FFLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;JJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "BottomSheetScaffoldLayout", "body", "Lkotlin/ParameterName;", "name", "innerPadding", "bottomSheet", "", "layoutHeight", "sheetOffset", "", "sheetState", "Landroidx/compose/material3/SheetState;", "BottomSheetScaffoldLayout-PxNyym8", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;FLkotlin/jvm/functions/Function0;Landroidx/compose/material3/SheetState;JJLandroidx/compose/runtime/Composer;I)V", "StandardBottomSheet", "state", "calculateAnchors", "Landroidx/compose/ui/unit/IntSize;", "sheetSize", "Landroidx/compose/material3/DraggableAnchors;", "Landroidx/compose/material3/SheetValue;", "peekHeight", "shape", "tonalElevation", "shadowElevation", "dragHandle", "StandardBottomSheet-XcniZvE", "(Landroidx/compose/material3/SheetState;Lkotlin/jvm/functions/Function1;FFZLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "rememberBottomSheetScaffoldState", "bottomSheetState", "snackbarHostState", "(Landroidx/compose/material3/SheetState;Landroidx/compose/material3/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/BottomSheetScaffoldState;", "rememberStandardBottomSheetState", "initialValue", "confirmValueChange", "skipHiddenState", "(Landroidx/compose/material3/SheetValue;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SheetState;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BottomSheetScaffoldKt {
    /* JADX WARN: Removed duplicated region for block: B:102:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0413  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0488  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x036f  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0367  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x04ad  */
    /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    /* renamed from: BottomSheetScaffold-sdMYb0k, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1907BottomSheetScaffoldsdMYb0k(final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, BottomSheetScaffoldState bottomSheetScaffoldState, float f, float f2, Shape shape, long j, long j2, float f3, float f4, Function2<? super Composer, ? super Integer, Unit> function2, boolean z, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function32, long j3, long j4, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function33, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        BottomSheetScaffoldState bottomSheetScaffoldState2;
        int i5;
        float f5;
        int i6;
        float f6;
        Shape shape2;
        long j5;
        long j6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        final BottomSheetScaffoldState bottomSheetScaffoldState3;
        int i20;
        long j7;
        float m1904getElevationD9Ej5fM;
        float m1904getElevationD9Ej5fM2;
        Function2<? super Composer, ? super Integer, Unit> m2071getLambda1$material3_release;
        boolean z2;
        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> m2072getLambda2$material3_release;
        Function2<? super Composer, ? super Integer, Unit> function23;
        long j8;
        long j9;
        long j10;
        int i21;
        Modifier modifier2;
        Function2<? super Composer, ? super Integer, Unit> function24;
        Function2<? super Composer, ? super Integer, Unit> function25;
        boolean z3;
        Object rememberedValue;
        Composer composer2;
        final BottomSheetScaffoldState bottomSheetScaffoldState4;
        final long j11;
        final float f7;
        final boolean z4;
        final long j12;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function34;
        final float f8;
        final float f9;
        final Shape shape3;
        final long j13;
        final float f10;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final long j14;
        ScopeUpdateScope endRestartGroup;
        int i22;
        int i23;
        Composer startRestartGroup = composer.startRestartGroup(-1523924135);
        ComposerKt.sourceInformation(startRestartGroup, "C(BottomSheetScaffold)P(6,3,4,10:c#ui.unit.Dp,9:c#ui.unit.Dp,12,5:c#ui.graphics.Color,7:c#ui.graphics.Color,14:c#ui.unit.Dp,11:c#ui.unit.Dp,8,13,16,15,0:c#ui.graphics.Color,2:c#ui.graphics.Color)103@5431L34,106@5633L13,107@5701L14,108@5748L36,115@6205L11,116@6252L31,*119@6379L7,130@6700L50,122@6436L1811:BottomSheetScaffold.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changedInstance(function3) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i24 = i3 & 2;
        if (i24 != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changed(modifier) ? 32 : 16;
            if ((i & 384) != 0) {
                if ((i3 & 4) == 0) {
                    bottomSheetScaffoldState2 = bottomSheetScaffoldState;
                    if (startRestartGroup.changed(bottomSheetScaffoldState2)) {
                        i23 = 256;
                        i4 |= i23;
                    }
                } else {
                    bottomSheetScaffoldState2 = bottomSheetScaffoldState;
                }
                i23 = 128;
                i4 |= i23;
            } else {
                bottomSheetScaffoldState2 = bottomSheetScaffoldState;
            }
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                f5 = f;
                i4 |= startRestartGroup.changed(f5) ? 2048 : 1024;
                i6 = i3 & 16;
                int i25 = 8192;
                if (i6 != 0) {
                    i4 |= 24576;
                } else if ((i & 24576) == 0) {
                    f6 = f2;
                    i4 |= startRestartGroup.changed(f6) ? 16384 : 8192;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                        shape2 = shape;
                        i4 |= ((i3 & 32) == 0 && startRestartGroup.changed(shape2)) ? 131072 : 65536;
                    } else {
                        shape2 = shape;
                    }
                    if ((i & 1572864) != 0) {
                        j5 = j;
                        i4 |= ((i3 & 64) == 0 && startRestartGroup.changed(j5)) ? 1048576 : 524288;
                    } else {
                        j5 = j;
                    }
                    if ((i & 12582912) != 0) {
                        if ((i3 & 128) == 0) {
                            j6 = j2;
                            if (startRestartGroup.changed(j6)) {
                                i22 = 8388608;
                                i4 |= i22;
                            }
                        } else {
                            j6 = j2;
                        }
                        i22 = 4194304;
                        i4 |= i22;
                    } else {
                        j6 = j2;
                    }
                    i7 = i3 & 256;
                    if (i7 == 0) {
                        i4 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i8 = i7;
                        i4 |= startRestartGroup.changed(f3) ? 67108864 : 33554432;
                        i9 = i3 & 512;
                        if (i9 != 0) {
                            i4 |= C.ENCODING_PCM_32BIT;
                        } else if ((i & C.ENCODING_PCM_32BIT) == 0) {
                            i10 = i9;
                            i4 |= startRestartGroup.changed(f4) ? 536870912 : 268435456;
                            i11 = i3 & 1024;
                            if (i11 == 0) {
                                i13 = i2 | 6;
                                i12 = i11;
                            } else if ((i2 & 6) == 0) {
                                i12 = i11;
                                i13 = i2 | (startRestartGroup.changedInstance(function2) ? 4 : 2);
                            } else {
                                i12 = i11;
                                i13 = i2;
                            }
                            i14 = i3 & 2048;
                            if (i14 == 0) {
                                i13 |= 48;
                                i15 = i14;
                            } else if ((i2 & 48) == 0) {
                                i15 = i14;
                                i13 |= startRestartGroup.changed(z) ? 32 : 16;
                            } else {
                                i15 = i14;
                            }
                            int i26 = i13;
                            i16 = i3 & 4096;
                            if (i16 == 0) {
                                i17 = i26 | 384;
                            } else {
                                int i27 = i26;
                                if ((i2 & 384) == 0) {
                                    i27 |= startRestartGroup.changedInstance(function22) ? 256 : 128;
                                }
                                i17 = i27;
                            }
                            i18 = i3 & 8192;
                            if (i18 == 0) {
                                i19 = i17 | 3072;
                            } else {
                                int i28 = i17;
                                if ((i2 & 3072) == 0) {
                                    i19 = i28 | (startRestartGroup.changedInstance(function32) ? 2048 : 1024);
                                } else {
                                    i19 = i28;
                                }
                            }
                            if ((i2 & 24576) == 0) {
                                if ((i3 & 16384) == 0 && startRestartGroup.changed(j3)) {
                                    i25 = 16384;
                                }
                                i19 |= i25;
                            }
                            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                i19 |= ((i3 & 32768) == 0 && startRestartGroup.changed(j4)) ? 131072 : 65536;
                            }
                            if ((i3 & 65536) == 0) {
                                i19 |= 1572864;
                            } else if ((i2 & 1572864) == 0) {
                                i19 |= startRestartGroup.changedInstance(function33) ? 1048576 : 524288;
                            }
                            if ((306783379 & i4) == 306783378 || (i19 & 599187) != 599186 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    Modifier.Companion companion = i24 == 0 ? Modifier.INSTANCE : modifier;
                                    if ((i3 & 4) == 0) {
                                        bottomSheetScaffoldState3 = rememberBottomSheetScaffoldState(null, null, startRestartGroup, 0, 3);
                                        i4 &= -897;
                                    } else {
                                        bottomSheetScaffoldState3 = bottomSheetScaffoldState2;
                                    }
                                    if (i5 != 0) {
                                        f5 = BottomSheetDefaults.INSTANCE.m1906getSheetPeekHeightD9Ej5fM();
                                    }
                                    if (i6 != 0) {
                                        f6 = BottomSheetDefaults.INSTANCE.m1905getSheetMaxWidthD9Ej5fM();
                                    }
                                    if ((i3 & 32) == 0) {
                                        i20 = 6;
                                        shape2 = BottomSheetDefaults.INSTANCE.getExpandedShape(startRestartGroup, 6);
                                        i4 &= -458753;
                                    } else {
                                        i20 = 6;
                                    }
                                    if ((i3 & 64) != 0) {
                                        j5 = BottomSheetDefaults.INSTANCE.getContainerColor(startRestartGroup, i20);
                                        i4 &= -3670017;
                                    }
                                    if ((i3 & 128) == 0) {
                                        j7 = ColorSchemeKt.m2049contentColorForek8zF_U(j5, startRestartGroup, (i4 >> 18) & 14);
                                        i4 &= -29360129;
                                    } else {
                                        j7 = j6;
                                    }
                                    m1904getElevationD9Ej5fM = i8 == 0 ? BottomSheetDefaults.INSTANCE.m1904getElevationD9Ej5fM() : f3;
                                    m1904getElevationD9Ej5fM2 = i10 == 0 ? BottomSheetDefaults.INSTANCE.m1904getElevationD9Ej5fM() : f4;
                                    m2071getLambda1$material3_release = i12 == 0 ? ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m2071getLambda1$material3_release() : function2;
                                    z2 = i15 == 0 ? true : z;
                                    Function2<? super Composer, ? super Integer, Unit> function28 = i16 == 0 ? function22 : null;
                                    m2072getLambda2$material3_release = i18 == 0 ? ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m2072getLambda2$material3_release() : function32;
                                    Modifier modifier4 = companion;
                                    if ((i3 & 16384) == 0) {
                                        function23 = function28;
                                        j8 = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, 6).getSurface();
                                        i19 &= -57345;
                                    } else {
                                        function23 = function28;
                                        j8 = j3;
                                    }
                                    if ((i3 & 32768) == 0) {
                                        i21 = i19 & (-458753);
                                        j9 = ColorSchemeKt.m2049contentColorForek8zF_U(j8, startRestartGroup, (i19 >> 12) & 14);
                                        j10 = j8;
                                    } else {
                                        j9 = j4;
                                        j10 = j8;
                                        i21 = i19;
                                    }
                                    modifier2 = modifier4;
                                    function24 = function23;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i3 & 4) != 0) {
                                        i4 &= -897;
                                    }
                                    if ((i3 & 32) != 0) {
                                        i4 &= -458753;
                                    }
                                    if ((i3 & 64) != 0) {
                                        i4 &= -3670017;
                                    }
                                    if ((i3 & 128) != 0) {
                                        i4 &= -29360129;
                                    }
                                    if ((i3 & 16384) != 0) {
                                        i19 &= -57345;
                                    }
                                    if ((i3 & 32768) != 0) {
                                        i19 &= -458753;
                                    }
                                    modifier2 = modifier;
                                    m1904getElevationD9Ej5fM2 = f4;
                                    m2071getLambda1$material3_release = function2;
                                    z2 = z;
                                    function24 = function22;
                                    m2072getLambda2$material3_release = function32;
                                    j10 = j3;
                                    j9 = j4;
                                    bottomSheetScaffoldState3 = bottomSheetScaffoldState2;
                                    j7 = j6;
                                    i21 = i19;
                                    m1904getElevationD9Ej5fM = f3;
                                }
                                startRestartGroup.endDefaults();
                                Modifier modifier5 = modifier2;
                                if (ComposerKt.isTraceInProgress()) {
                                    function25 = function24;
                                } else {
                                    function25 = function24;
                                    ComposerKt.traceEventStart(-1523924135, i4, i21, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:118)");
                                }
                                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                int i29 = i21;
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume = startRestartGroup.consume(localDensity);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                final int mo624roundToPx0680j_4 = ((Density) consume).mo624roundToPx0680j_4(f5);
                                SheetState bottomSheetState = bottomSheetScaffoldState3.getBottomSheetState();
                                final float f11 = f5;
                                final float f12 = f6;
                                final BottomSheetScaffoldState bottomSheetScaffoldState5 = bottomSheetScaffoldState3;
                                final Shape shape4 = shape2;
                                final long j15 = j5;
                                final long j16 = j7;
                                final float f13 = m1904getElevationD9Ej5fM;
                                final float f14 = m1904getElevationD9Ej5fM2;
                                final Function2<? super Composer, ? super Integer, Unit> function29 = m2071getLambda1$material3_release;
                                final boolean z5 = z2;
                                ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, -680109608, true, new Function3<Integer, Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Composer composer3, Integer num2) {
                                        invoke(num.intValue(), composer3, num2.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(final int i30, Composer composer3, int i31) {
                                        int i32;
                                        ComposerKt.sourceInformation(composer3, "C140@7195L686,135@6935L1296:BottomSheetScaffold.kt#uh7d8r");
                                        if ((i31 & 6) == 0) {
                                            i32 = i31 | (composer3.changed(i30) ? 4 : 2);
                                        } else {
                                            i32 = i31;
                                        }
                                        if ((i32 & 19) != 18 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-680109608, i32, -1, "androidx.compose.material3.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:135)");
                                            }
                                            SheetState bottomSheetState2 = BottomSheetScaffoldState.this.getBottomSheetState();
                                            composer3.startReplaceableGroup(1237684821);
                                            ComposerKt.sourceInformation(composer3, "CC(remember):BottomSheetScaffold.kt#9igjgp");
                                            boolean changed = ((i32 & 14) == 4) | composer3.changed(BottomSheetScaffoldState.this) | composer3.changed(mo624roundToPx0680j_4);
                                            final BottomSheetScaffoldState bottomSheetScaffoldState6 = BottomSheetScaffoldState.this;
                                            final int i33 = mo624roundToPx0680j_4;
                                            Object rememberedValue2 = composer3.rememberedValue();
                                            if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue2 = (Function1) new Function1<IntSize, DraggableAnchors<SheetValue>>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1$1$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ DraggableAnchors<SheetValue> invoke(IntSize intSize) {
                                                        return m1912invokeozmzZPI(intSize.getPackedValue());
                                                    }

                                                    /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                                                    public final DraggableAnchors<SheetValue> m1912invokeozmzZPI(long j17) {
                                                        final int m6558getHeightimpl = IntSize.m6558getHeightimpl(j17);
                                                        final BottomSheetScaffoldState bottomSheetScaffoldState7 = BottomSheetScaffoldState.this;
                                                        final int i34 = i30;
                                                        final int i35 = i33;
                                                        return AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<SheetValue>, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1$1$1.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<SheetValue> draggableAnchorsConfig) {
                                                                invoke2(draggableAnchorsConfig);
                                                                return Unit.INSTANCE;
                                                            }

                                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                            public final void invoke2(DraggableAnchorsConfig<SheetValue> draggableAnchorsConfig) {
                                                                if (!BottomSheetScaffoldState.this.getBottomSheetState().getSkipPartiallyExpanded()) {
                                                                    draggableAnchorsConfig.at(SheetValue.PartiallyExpanded, i34 - i35);
                                                                }
                                                                if (m6558getHeightimpl != i35) {
                                                                    draggableAnchorsConfig.at(SheetValue.Expanded, Math.max(i34 - m6558getHeightimpl, 0));
                                                                }
                                                                if (BottomSheetScaffoldState.this.getBottomSheetState().getSkipHiddenState()) {
                                                                    return;
                                                                }
                                                                draggableAnchorsConfig.at(SheetValue.Hidden, i34);
                                                            }
                                                        });
                                                    }
                                                };
                                                composer3.updateRememberedValue(rememberedValue2);
                                            }
                                            composer3.endReplaceableGroup();
                                            BottomSheetScaffoldKt.m1909StandardBottomSheetXcniZvE(bottomSheetState2, (Function1) rememberedValue2, f11, f12, z5, shape4, j15, j16, f13, f14, function29, function3, composer3, 0, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                });
                                ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(startRestartGroup, 88659390, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$2
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

                                    public final void invoke(Composer composer3, int i30) {
                                        ComposerKt.sourceInformation(composer3, "C127@6578L45:BottomSheetScaffold.kt#uh7d8r");
                                        if ((i30 & 3) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(88659390, i30, -1, "androidx.compose.material3.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:127)");
                                        }
                                        m2072getLambda2$material3_release.invoke(bottomSheetScaffoldState3.getSnackbarHostState(), composer3, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                });
                                startRestartGroup.startReplaceableGroup(-1567544379);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):BottomSheetScaffold.kt#9igjgp");
                                z3 = (((i4 & 896) ^ 384) <= 256 && startRestartGroup.changed(bottomSheetScaffoldState3)) || (i4 & 384) == 256;
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (!z3 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$3$1
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Float invoke() {
                                            return Float.valueOf(BottomSheetScaffoldState.this.getBottomSheetState().requireOffset());
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                startRestartGroup.endReplaceableGroup();
                                int i30 = i29 << 12;
                                Function2<? super Composer, ? super Integer, Unit> function210 = function25;
                                long j17 = j10;
                                long j18 = j9;
                                m1908BottomSheetScaffoldLayoutPxNyym8(modifier5, function210, function33, composableLambda, composableLambda2, f5, (Function0) rememberedValue, bottomSheetState, j17, j18, startRestartGroup, ((i29 >> 12) & 896) | ((i4 >> 3) & 14) | 27648 | ((i29 >> 3) & 112) | (458752 & (i4 << 6)) | (234881024 & i30) | (i30 & 1879048192));
                                composer2 = startRestartGroup;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                bottomSheetScaffoldState4 = bottomSheetScaffoldState3;
                                j11 = j5;
                                f7 = m1904getElevationD9Ej5fM;
                                z4 = z2;
                                j12 = j18;
                                modifier3 = modifier5;
                                float f15 = m1904getElevationD9Ej5fM2;
                                function26 = function210;
                                function34 = m2072getLambda2$material3_release;
                                f8 = f5;
                                f9 = f6;
                                shape3 = shape2;
                                j13 = j7;
                                f10 = f15;
                                function27 = m2071getLambda1$material3_release;
                                j14 = j17;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                modifier3 = modifier;
                                function26 = function22;
                                function34 = function32;
                                j14 = j3;
                                j12 = j4;
                                composer2 = startRestartGroup;
                                f8 = f5;
                                f9 = f6;
                                shape3 = shape2;
                                j11 = j5;
                                bottomSheetScaffoldState4 = bottomSheetScaffoldState2;
                                j13 = j6;
                                f7 = f3;
                                f10 = f4;
                                function27 = function2;
                                z4 = z;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$4
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

                                    public final void invoke(Composer composer3, int i31) {
                                        BottomSheetScaffoldKt.m1907BottomSheetScaffoldsdMYb0k(function3, modifier3, bottomSheetScaffoldState4, f8, f9, shape3, j11, j13, f7, f10, function27, z4, function26, function34, j14, j12, function33, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i10 = i9;
                        i11 = i3 & 1024;
                        if (i11 == 0) {
                        }
                        i14 = i3 & 2048;
                        if (i14 == 0) {
                        }
                        int i262 = i13;
                        i16 = i3 & 4096;
                        if (i16 == 0) {
                        }
                        i18 = i3 & 8192;
                        if (i18 == 0) {
                        }
                        if ((i2 & 24576) == 0) {
                        }
                        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        }
                        if ((i3 & 65536) == 0) {
                        }
                        if ((306783379 & i4) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                        }
                        if (i24 == 0) {
                        }
                        if ((i3 & 4) == 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if ((i3 & 32) == 0) {
                        }
                        if ((i3 & 64) != 0) {
                        }
                        if ((i3 & 128) == 0) {
                        }
                        if (i8 == 0) {
                        }
                        if (i10 == 0) {
                        }
                        if (i12 == 0) {
                        }
                        if (i15 == 0) {
                        }
                        if (i16 == 0) {
                        }
                        if (i18 == 0) {
                        }
                        Modifier modifier42 = companion;
                        if ((i3 & 16384) == 0) {
                        }
                        if ((i3 & 32768) == 0) {
                        }
                        modifier2 = modifier42;
                        function24 = function23;
                        startRestartGroup.endDefaults();
                        Modifier modifier52 = modifier2;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                        int i292 = i21;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume2 = startRestartGroup.consume(localDensity2);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        final int mo624roundToPx0680j_42 = ((Density) consume2).mo624roundToPx0680j_4(f5);
                        SheetState bottomSheetState2 = bottomSheetScaffoldState3.getBottomSheetState();
                        final float f112 = f5;
                        final float f122 = f6;
                        final BottomSheetScaffoldState bottomSheetScaffoldState52 = bottomSheetScaffoldState3;
                        final Shape shape42 = shape2;
                        final long j152 = j5;
                        final long j162 = j7;
                        final float f132 = m1904getElevationD9Ej5fM;
                        final float f142 = m1904getElevationD9Ej5fM2;
                        final Function2<? super Composer, ? super Integer, Unit> function292 = m2071getLambda1$material3_release;
                        final boolean z52 = z2;
                        ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(startRestartGroup, -680109608, true, new Function3<Integer, Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Composer composer3, Integer num2) {
                                invoke(num.intValue(), composer3, num2.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(final int i302, Composer composer3, int i31) {
                                int i32;
                                ComposerKt.sourceInformation(composer3, "C140@7195L686,135@6935L1296:BottomSheetScaffold.kt#uh7d8r");
                                if ((i31 & 6) == 0) {
                                    i32 = i31 | (composer3.changed(i302) ? 4 : 2);
                                } else {
                                    i32 = i31;
                                }
                                if ((i32 & 19) != 18 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-680109608, i32, -1, "androidx.compose.material3.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:135)");
                                    }
                                    SheetState bottomSheetState22 = BottomSheetScaffoldState.this.getBottomSheetState();
                                    composer3.startReplaceableGroup(1237684821);
                                    ComposerKt.sourceInformation(composer3, "CC(remember):BottomSheetScaffold.kt#9igjgp");
                                    boolean changed = ((i32 & 14) == 4) | composer3.changed(BottomSheetScaffoldState.this) | composer3.changed(mo624roundToPx0680j_42);
                                    final BottomSheetScaffoldState bottomSheetScaffoldState6 = BottomSheetScaffoldState.this;
                                    final int i33 = mo624roundToPx0680j_42;
                                    Object rememberedValue2 = composer3.rememberedValue();
                                    if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue2 = (Function1) new Function1<IntSize, DraggableAnchors<SheetValue>>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ DraggableAnchors<SheetValue> invoke(IntSize intSize) {
                                                return m1912invokeozmzZPI(intSize.getPackedValue());
                                            }

                                            /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                                            public final DraggableAnchors<SheetValue> m1912invokeozmzZPI(long j172) {
                                                final int m6558getHeightimpl = IntSize.m6558getHeightimpl(j172);
                                                final BottomSheetScaffoldState bottomSheetScaffoldState7 = BottomSheetScaffoldState.this;
                                                final int i34 = i302;
                                                final int i35 = i33;
                                                return AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<SheetValue>, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1$1$1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<SheetValue> draggableAnchorsConfig) {
                                                        invoke2(draggableAnchorsConfig);
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(DraggableAnchorsConfig<SheetValue> draggableAnchorsConfig) {
                                                        if (!BottomSheetScaffoldState.this.getBottomSheetState().getSkipPartiallyExpanded()) {
                                                            draggableAnchorsConfig.at(SheetValue.PartiallyExpanded, i34 - i35);
                                                        }
                                                        if (m6558getHeightimpl != i35) {
                                                            draggableAnchorsConfig.at(SheetValue.Expanded, Math.max(i34 - m6558getHeightimpl, 0));
                                                        }
                                                        if (BottomSheetScaffoldState.this.getBottomSheetState().getSkipHiddenState()) {
                                                            return;
                                                        }
                                                        draggableAnchorsConfig.at(SheetValue.Hidden, i34);
                                                    }
                                                });
                                            }
                                        };
                                        composer3.updateRememberedValue(rememberedValue2);
                                    }
                                    composer3.endReplaceableGroup();
                                    BottomSheetScaffoldKt.m1909StandardBottomSheetXcniZvE(bottomSheetState22, (Function1) rememberedValue2, f112, f122, z52, shape42, j152, j162, f132, f142, function292, function3, composer3, 0, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        });
                        ComposableLambda composableLambda22 = ComposableLambdaKt.composableLambda(startRestartGroup, 88659390, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$2
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

                            public final void invoke(Composer composer3, int i302) {
                                ComposerKt.sourceInformation(composer3, "C127@6578L45:BottomSheetScaffold.kt#uh7d8r");
                                if ((i302 & 3) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(88659390, i302, -1, "androidx.compose.material3.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:127)");
                                }
                                m2072getLambda2$material3_release.invoke(bottomSheetScaffoldState3.getSnackbarHostState(), composer3, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        });
                        startRestartGroup.startReplaceableGroup(-1567544379);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):BottomSheetScaffold.kt#9igjgp");
                        if (((i4 & 896) ^ 384) <= 256) {
                        }
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (!z3) {
                        }
                        rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$3$1
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Float invoke() {
                                return Float.valueOf(BottomSheetScaffoldState.this.getBottomSheetState().requireOffset());
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                        startRestartGroup.endReplaceableGroup();
                        int i302 = i292 << 12;
                        Function2<? super Composer, ? super Integer, Unit> function2102 = function25;
                        long j172 = j10;
                        long j182 = j9;
                        m1908BottomSheetScaffoldLayoutPxNyym8(modifier52, function2102, function33, composableLambda3, composableLambda22, f5, (Function0) rememberedValue, bottomSheetState2, j172, j182, startRestartGroup, ((i292 >> 12) & 896) | ((i4 >> 3) & 14) | 27648 | ((i292 >> 3) & 112) | (458752 & (i4 << 6)) | (234881024 & i302) | (i302 & 1879048192));
                        composer2 = startRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        bottomSheetScaffoldState4 = bottomSheetScaffoldState3;
                        j11 = j5;
                        f7 = m1904getElevationD9Ej5fM;
                        z4 = z2;
                        j12 = j182;
                        modifier3 = modifier52;
                        float f152 = m1904getElevationD9Ej5fM2;
                        function26 = function2102;
                        function34 = m2072getLambda2$material3_release;
                        f8 = f5;
                        f9 = f6;
                        shape3 = shape2;
                        j13 = j7;
                        f10 = f152;
                        function27 = m2071getLambda1$material3_release;
                        j14 = j172;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i8 = i7;
                    i9 = i3 & 512;
                    if (i9 != 0) {
                    }
                    i10 = i9;
                    i11 = i3 & 1024;
                    if (i11 == 0) {
                    }
                    i14 = i3 & 2048;
                    if (i14 == 0) {
                    }
                    int i2622 = i13;
                    i16 = i3 & 4096;
                    if (i16 == 0) {
                    }
                    i18 = i3 & 8192;
                    if (i18 == 0) {
                    }
                    if ((i2 & 24576) == 0) {
                    }
                    if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    }
                    if ((i3 & 65536) == 0) {
                    }
                    if ((306783379 & i4) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i24 == 0) {
                    }
                    if ((i3 & 4) == 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if ((i3 & 32) == 0) {
                    }
                    if ((i3 & 64) != 0) {
                    }
                    if ((i3 & 128) == 0) {
                    }
                    if (i8 == 0) {
                    }
                    if (i10 == 0) {
                    }
                    if (i12 == 0) {
                    }
                    if (i15 == 0) {
                    }
                    if (i16 == 0) {
                    }
                    if (i18 == 0) {
                    }
                    Modifier modifier422 = companion;
                    if ((i3 & 16384) == 0) {
                    }
                    if ((i3 & 32768) == 0) {
                    }
                    modifier2 = modifier422;
                    function24 = function23;
                    startRestartGroup.endDefaults();
                    Modifier modifier522 = modifier2;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ProvidableCompositionLocal<Density> localDensity22 = CompositionLocalsKt.getLocalDensity();
                    int i2922 = i21;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume22 = startRestartGroup.consume(localDensity22);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    final int mo624roundToPx0680j_422 = ((Density) consume22).mo624roundToPx0680j_4(f5);
                    SheetState bottomSheetState22 = bottomSheetScaffoldState3.getBottomSheetState();
                    final float f1122 = f5;
                    final float f1222 = f6;
                    final BottomSheetScaffoldState bottomSheetScaffoldState522 = bottomSheetScaffoldState3;
                    final Shape shape422 = shape2;
                    final long j1522 = j5;
                    final long j1622 = j7;
                    final float f1322 = m1904getElevationD9Ej5fM;
                    final float f1422 = m1904getElevationD9Ej5fM2;
                    final Function2<? super Composer, ? super Integer, Unit> function2922 = m2071getLambda1$material3_release;
                    final boolean z522 = z2;
                    ComposableLambda composableLambda32 = ComposableLambdaKt.composableLambda(startRestartGroup, -680109608, true, new Function3<Integer, Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Integer num, Composer composer3, Integer num2) {
                            invoke(num.intValue(), composer3, num2.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(final int i3022, Composer composer3, int i31) {
                            int i32;
                            ComposerKt.sourceInformation(composer3, "C140@7195L686,135@6935L1296:BottomSheetScaffold.kt#uh7d8r");
                            if ((i31 & 6) == 0) {
                                i32 = i31 | (composer3.changed(i3022) ? 4 : 2);
                            } else {
                                i32 = i31;
                            }
                            if ((i32 & 19) != 18 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-680109608, i32, -1, "androidx.compose.material3.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:135)");
                                }
                                SheetState bottomSheetState222 = BottomSheetScaffoldState.this.getBottomSheetState();
                                composer3.startReplaceableGroup(1237684821);
                                ComposerKt.sourceInformation(composer3, "CC(remember):BottomSheetScaffold.kt#9igjgp");
                                boolean changed = ((i32 & 14) == 4) | composer3.changed(BottomSheetScaffoldState.this) | composer3.changed(mo624roundToPx0680j_422);
                                final BottomSheetScaffoldState bottomSheetScaffoldState6 = BottomSheetScaffoldState.this;
                                final int i33 = mo624roundToPx0680j_422;
                                Object rememberedValue2 = composer3.rememberedValue();
                                if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue2 = (Function1) new Function1<IntSize, DraggableAnchors<SheetValue>>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ DraggableAnchors<SheetValue> invoke(IntSize intSize) {
                                            return m1912invokeozmzZPI(intSize.getPackedValue());
                                        }

                                        /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                                        public final DraggableAnchors<SheetValue> m1912invokeozmzZPI(long j1722) {
                                            final int m6558getHeightimpl = IntSize.m6558getHeightimpl(j1722);
                                            final BottomSheetScaffoldState bottomSheetScaffoldState7 = BottomSheetScaffoldState.this;
                                            final int i34 = i3022;
                                            final int i35 = i33;
                                            return AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<SheetValue>, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1$1$1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<SheetValue> draggableAnchorsConfig) {
                                                    invoke2(draggableAnchorsConfig);
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(DraggableAnchorsConfig<SheetValue> draggableAnchorsConfig) {
                                                    if (!BottomSheetScaffoldState.this.getBottomSheetState().getSkipPartiallyExpanded()) {
                                                        draggableAnchorsConfig.at(SheetValue.PartiallyExpanded, i34 - i35);
                                                    }
                                                    if (m6558getHeightimpl != i35) {
                                                        draggableAnchorsConfig.at(SheetValue.Expanded, Math.max(i34 - m6558getHeightimpl, 0));
                                                    }
                                                    if (BottomSheetScaffoldState.this.getBottomSheetState().getSkipHiddenState()) {
                                                        return;
                                                    }
                                                    draggableAnchorsConfig.at(SheetValue.Hidden, i34);
                                                }
                                            });
                                        }
                                    };
                                    composer3.updateRememberedValue(rememberedValue2);
                                }
                                composer3.endReplaceableGroup();
                                BottomSheetScaffoldKt.m1909StandardBottomSheetXcniZvE(bottomSheetState222, (Function1) rememberedValue2, f1122, f1222, z522, shape422, j1522, j1622, f1322, f1422, function2922, function3, composer3, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    });
                    ComposableLambda composableLambda222 = ComposableLambdaKt.composableLambda(startRestartGroup, 88659390, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$2
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

                        public final void invoke(Composer composer3, int i3022) {
                            ComposerKt.sourceInformation(composer3, "C127@6578L45:BottomSheetScaffold.kt#uh7d8r");
                            if ((i3022 & 3) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(88659390, i3022, -1, "androidx.compose.material3.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:127)");
                            }
                            m2072getLambda2$material3_release.invoke(bottomSheetScaffoldState3.getSnackbarHostState(), composer3, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    });
                    startRestartGroup.startReplaceableGroup(-1567544379);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):BottomSheetScaffold.kt#9igjgp");
                    if (((i4 & 896) ^ 384) <= 256) {
                    }
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!z3) {
                    }
                    rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$3$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Float invoke() {
                            return Float.valueOf(BottomSheetScaffoldState.this.getBottomSheetState().requireOffset());
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    startRestartGroup.endReplaceableGroup();
                    int i3022 = i2922 << 12;
                    Function2<? super Composer, ? super Integer, Unit> function21022 = function25;
                    long j1722 = j10;
                    long j1822 = j9;
                    m1908BottomSheetScaffoldLayoutPxNyym8(modifier522, function21022, function33, composableLambda32, composableLambda222, f5, (Function0) rememberedValue, bottomSheetState22, j1722, j1822, startRestartGroup, ((i2922 >> 12) & 896) | ((i4 >> 3) & 14) | 27648 | ((i2922 >> 3) & 112) | (458752 & (i4 << 6)) | (234881024 & i3022) | (i3022 & 1879048192));
                    composer2 = startRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    bottomSheetScaffoldState4 = bottomSheetScaffoldState3;
                    j11 = j5;
                    f7 = m1904getElevationD9Ej5fM;
                    z4 = z2;
                    j12 = j1822;
                    modifier3 = modifier522;
                    float f1522 = m1904getElevationD9Ej5fM2;
                    function26 = function21022;
                    function34 = m2072getLambda2$material3_release;
                    f8 = f5;
                    f9 = f6;
                    shape3 = shape2;
                    j13 = j7;
                    f10 = f1522;
                    function27 = m2071getLambda1$material3_release;
                    j14 = j1722;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                f6 = f2;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                }
                if ((i & 1572864) != 0) {
                }
                if ((i & 12582912) != 0) {
                }
                i7 = i3 & 256;
                if (i7 == 0) {
                }
                i8 = i7;
                i9 = i3 & 512;
                if (i9 != 0) {
                }
                i10 = i9;
                i11 = i3 & 1024;
                if (i11 == 0) {
                }
                i14 = i3 & 2048;
                if (i14 == 0) {
                }
                int i26222 = i13;
                i16 = i3 & 4096;
                if (i16 == 0) {
                }
                i18 = i3 & 8192;
                if (i18 == 0) {
                }
                if ((i2 & 24576) == 0) {
                }
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                }
                if ((i3 & 65536) == 0) {
                }
                if ((306783379 & i4) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i24 == 0) {
                }
                if ((i3 & 4) == 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if ((i3 & 32) == 0) {
                }
                if ((i3 & 64) != 0) {
                }
                if ((i3 & 128) == 0) {
                }
                if (i8 == 0) {
                }
                if (i10 == 0) {
                }
                if (i12 == 0) {
                }
                if (i15 == 0) {
                }
                if (i16 == 0) {
                }
                if (i18 == 0) {
                }
                Modifier modifier4222 = companion;
                if ((i3 & 16384) == 0) {
                }
                if ((i3 & 32768) == 0) {
                }
                modifier2 = modifier4222;
                function24 = function23;
                startRestartGroup.endDefaults();
                Modifier modifier5222 = modifier2;
                if (ComposerKt.isTraceInProgress()) {
                }
                ProvidableCompositionLocal<Density> localDensity222 = CompositionLocalsKt.getLocalDensity();
                int i29222 = i21;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume222 = startRestartGroup.consume(localDensity222);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                final int mo624roundToPx0680j_4222 = ((Density) consume222).mo624roundToPx0680j_4(f5);
                SheetState bottomSheetState222 = bottomSheetScaffoldState3.getBottomSheetState();
                final float f11222 = f5;
                final float f12222 = f6;
                final BottomSheetScaffoldState bottomSheetScaffoldState5222 = bottomSheetScaffoldState3;
                final Shape shape4222 = shape2;
                final long j15222 = j5;
                final long j16222 = j7;
                final float f13222 = m1904getElevationD9Ej5fM;
                final float f14222 = m1904getElevationD9Ej5fM2;
                final Function2<? super Composer, ? super Integer, Unit> function29222 = m2071getLambda1$material3_release;
                final boolean z5222 = z2;
                ComposableLambda composableLambda322 = ComposableLambdaKt.composableLambda(startRestartGroup, -680109608, true, new Function3<Integer, Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Composer composer3, Integer num2) {
                        invoke(num.intValue(), composer3, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(final int i30222, Composer composer3, int i31) {
                        int i32;
                        ComposerKt.sourceInformation(composer3, "C140@7195L686,135@6935L1296:BottomSheetScaffold.kt#uh7d8r");
                        if ((i31 & 6) == 0) {
                            i32 = i31 | (composer3.changed(i30222) ? 4 : 2);
                        } else {
                            i32 = i31;
                        }
                        if ((i32 & 19) != 18 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-680109608, i32, -1, "androidx.compose.material3.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:135)");
                            }
                            SheetState bottomSheetState2222 = BottomSheetScaffoldState.this.getBottomSheetState();
                            composer3.startReplaceableGroup(1237684821);
                            ComposerKt.sourceInformation(composer3, "CC(remember):BottomSheetScaffold.kt#9igjgp");
                            boolean changed = ((i32 & 14) == 4) | composer3.changed(BottomSheetScaffoldState.this) | composer3.changed(mo624roundToPx0680j_4222);
                            final BottomSheetScaffoldState bottomSheetScaffoldState6 = BottomSheetScaffoldState.this;
                            final int i33 = mo624roundToPx0680j_4222;
                            Object rememberedValue2 = composer3.rememberedValue();
                            if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue2 = (Function1) new Function1<IntSize, DraggableAnchors<SheetValue>>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ DraggableAnchors<SheetValue> invoke(IntSize intSize) {
                                        return m1912invokeozmzZPI(intSize.getPackedValue());
                                    }

                                    /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                                    public final DraggableAnchors<SheetValue> m1912invokeozmzZPI(long j17222) {
                                        final int m6558getHeightimpl = IntSize.m6558getHeightimpl(j17222);
                                        final BottomSheetScaffoldState bottomSheetScaffoldState7 = BottomSheetScaffoldState.this;
                                        final int i34 = i30222;
                                        final int i35 = i33;
                                        return AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<SheetValue>, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1$1$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<SheetValue> draggableAnchorsConfig) {
                                                invoke2(draggableAnchorsConfig);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(DraggableAnchorsConfig<SheetValue> draggableAnchorsConfig) {
                                                if (!BottomSheetScaffoldState.this.getBottomSheetState().getSkipPartiallyExpanded()) {
                                                    draggableAnchorsConfig.at(SheetValue.PartiallyExpanded, i34 - i35);
                                                }
                                                if (m6558getHeightimpl != i35) {
                                                    draggableAnchorsConfig.at(SheetValue.Expanded, Math.max(i34 - m6558getHeightimpl, 0));
                                                }
                                                if (BottomSheetScaffoldState.this.getBottomSheetState().getSkipHiddenState()) {
                                                    return;
                                                }
                                                draggableAnchorsConfig.at(SheetValue.Hidden, i34);
                                            }
                                        });
                                    }
                                };
                                composer3.updateRememberedValue(rememberedValue2);
                            }
                            composer3.endReplaceableGroup();
                            BottomSheetScaffoldKt.m1909StandardBottomSheetXcniZvE(bottomSheetState2222, (Function1) rememberedValue2, f11222, f12222, z5222, shape4222, j15222, j16222, f13222, f14222, function29222, function3, composer3, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                });
                ComposableLambda composableLambda2222 = ComposableLambdaKt.composableLambda(startRestartGroup, 88659390, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$2
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

                    public final void invoke(Composer composer3, int i30222) {
                        ComposerKt.sourceInformation(composer3, "C127@6578L45:BottomSheetScaffold.kt#uh7d8r");
                        if ((i30222 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(88659390, i30222, -1, "androidx.compose.material3.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:127)");
                        }
                        m2072getLambda2$material3_release.invoke(bottomSheetScaffoldState3.getSnackbarHostState(), composer3, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                });
                startRestartGroup.startReplaceableGroup(-1567544379);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):BottomSheetScaffold.kt#9igjgp");
                if (((i4 & 896) ^ 384) <= 256) {
                }
                rememberedValue = startRestartGroup.rememberedValue();
                if (!z3) {
                }
                rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$3$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        return Float.valueOf(BottomSheetScaffoldState.this.getBottomSheetState().requireOffset());
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
                startRestartGroup.endReplaceableGroup();
                int i30222 = i29222 << 12;
                Function2<? super Composer, ? super Integer, Unit> function210222 = function25;
                long j17222 = j10;
                long j18222 = j9;
                m1908BottomSheetScaffoldLayoutPxNyym8(modifier5222, function210222, function33, composableLambda322, composableLambda2222, f5, (Function0) rememberedValue, bottomSheetState222, j17222, j18222, startRestartGroup, ((i29222 >> 12) & 896) | ((i4 >> 3) & 14) | 27648 | ((i29222 >> 3) & 112) | (458752 & (i4 << 6)) | (234881024 & i30222) | (i30222 & 1879048192));
                composer2 = startRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                }
                bottomSheetScaffoldState4 = bottomSheetScaffoldState3;
                j11 = j5;
                f7 = m1904getElevationD9Ej5fM;
                z4 = z2;
                j12 = j18222;
                modifier3 = modifier5222;
                float f15222 = m1904getElevationD9Ej5fM2;
                function26 = function210222;
                function34 = m2072getLambda2$material3_release;
                f8 = f5;
                f9 = f6;
                shape3 = shape2;
                j13 = j7;
                f10 = f15222;
                function27 = m2071getLambda1$material3_release;
                j14 = j17222;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            f5 = f;
            i6 = i3 & 16;
            int i252 = 8192;
            if (i6 != 0) {
            }
            f6 = f2;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
            }
            if ((i & 1572864) != 0) {
            }
            if ((i & 12582912) != 0) {
            }
            i7 = i3 & 256;
            if (i7 == 0) {
            }
            i8 = i7;
            i9 = i3 & 512;
            if (i9 != 0) {
            }
            i10 = i9;
            i11 = i3 & 1024;
            if (i11 == 0) {
            }
            i14 = i3 & 2048;
            if (i14 == 0) {
            }
            int i262222 = i13;
            i16 = i3 & 4096;
            if (i16 == 0) {
            }
            i18 = i3 & 8192;
            if (i18 == 0) {
            }
            if ((i2 & 24576) == 0) {
            }
            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            }
            if ((i3 & 65536) == 0) {
            }
            if ((306783379 & i4) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i24 == 0) {
            }
            if ((i3 & 4) == 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if ((i3 & 32) == 0) {
            }
            if ((i3 & 64) != 0) {
            }
            if ((i3 & 128) == 0) {
            }
            if (i8 == 0) {
            }
            if (i10 == 0) {
            }
            if (i12 == 0) {
            }
            if (i15 == 0) {
            }
            if (i16 == 0) {
            }
            if (i18 == 0) {
            }
            Modifier modifier42222 = companion;
            if ((i3 & 16384) == 0) {
            }
            if ((i3 & 32768) == 0) {
            }
            modifier2 = modifier42222;
            function24 = function23;
            startRestartGroup.endDefaults();
            Modifier modifier52222 = modifier2;
            if (ComposerKt.isTraceInProgress()) {
            }
            ProvidableCompositionLocal<Density> localDensity2222 = CompositionLocalsKt.getLocalDensity();
            int i292222 = i21;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2222 = startRestartGroup.consume(localDensity2222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final int mo624roundToPx0680j_42222 = ((Density) consume2222).mo624roundToPx0680j_4(f5);
            SheetState bottomSheetState2222 = bottomSheetScaffoldState3.getBottomSheetState();
            final float f112222 = f5;
            final float f122222 = f6;
            final BottomSheetScaffoldState bottomSheetScaffoldState52222 = bottomSheetScaffoldState3;
            final Shape shape42222 = shape2;
            final long j152222 = j5;
            final long j162222 = j7;
            final float f132222 = m1904getElevationD9Ej5fM;
            final float f142222 = m1904getElevationD9Ej5fM2;
            final Function2<? super Composer, ? super Integer, Unit> function292222 = m2071getLambda1$material3_release;
            final boolean z52222 = z2;
            ComposableLambda composableLambda3222 = ComposableLambdaKt.composableLambda(startRestartGroup, -680109608, true, new Function3<Integer, Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, Composer composer3, Integer num2) {
                    invoke(num.intValue(), composer3, num2.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final int i302222, Composer composer3, int i31) {
                    int i32;
                    ComposerKt.sourceInformation(composer3, "C140@7195L686,135@6935L1296:BottomSheetScaffold.kt#uh7d8r");
                    if ((i31 & 6) == 0) {
                        i32 = i31 | (composer3.changed(i302222) ? 4 : 2);
                    } else {
                        i32 = i31;
                    }
                    if ((i32 & 19) != 18 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-680109608, i32, -1, "androidx.compose.material3.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:135)");
                        }
                        SheetState bottomSheetState22222 = BottomSheetScaffoldState.this.getBottomSheetState();
                        composer3.startReplaceableGroup(1237684821);
                        ComposerKt.sourceInformation(composer3, "CC(remember):BottomSheetScaffold.kt#9igjgp");
                        boolean changed = ((i32 & 14) == 4) | composer3.changed(BottomSheetScaffoldState.this) | composer3.changed(mo624roundToPx0680j_42222);
                        final BottomSheetScaffoldState bottomSheetScaffoldState6 = BottomSheetScaffoldState.this;
                        final int i33 = mo624roundToPx0680j_42222;
                        Object rememberedValue2 = composer3.rememberedValue();
                        if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = (Function1) new Function1<IntSize, DraggableAnchors<SheetValue>>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ DraggableAnchors<SheetValue> invoke(IntSize intSize) {
                                    return m1912invokeozmzZPI(intSize.getPackedValue());
                                }

                                /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                                public final DraggableAnchors<SheetValue> m1912invokeozmzZPI(long j172222) {
                                    final int m6558getHeightimpl = IntSize.m6558getHeightimpl(j172222);
                                    final BottomSheetScaffoldState bottomSheetScaffoldState7 = BottomSheetScaffoldState.this;
                                    final int i34 = i302222;
                                    final int i35 = i33;
                                    return AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<SheetValue>, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1$1$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<SheetValue> draggableAnchorsConfig) {
                                            invoke2(draggableAnchorsConfig);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(DraggableAnchorsConfig<SheetValue> draggableAnchorsConfig) {
                                            if (!BottomSheetScaffoldState.this.getBottomSheetState().getSkipPartiallyExpanded()) {
                                                draggableAnchorsConfig.at(SheetValue.PartiallyExpanded, i34 - i35);
                                            }
                                            if (m6558getHeightimpl != i35) {
                                                draggableAnchorsConfig.at(SheetValue.Expanded, Math.max(i34 - m6558getHeightimpl, 0));
                                            }
                                            if (BottomSheetScaffoldState.this.getBottomSheetState().getSkipHiddenState()) {
                                                return;
                                            }
                                            draggableAnchorsConfig.at(SheetValue.Hidden, i34);
                                        }
                                    });
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue2);
                        }
                        composer3.endReplaceableGroup();
                        BottomSheetScaffoldKt.m1909StandardBottomSheetXcniZvE(bottomSheetState22222, (Function1) rememberedValue2, f112222, f122222, z52222, shape42222, j152222, j162222, f132222, f142222, function292222, function3, composer3, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            });
            ComposableLambda composableLambda22222 = ComposableLambdaKt.composableLambda(startRestartGroup, 88659390, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$2
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

                public final void invoke(Composer composer3, int i302222) {
                    ComposerKt.sourceInformation(composer3, "C127@6578L45:BottomSheetScaffold.kt#uh7d8r");
                    if ((i302222 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(88659390, i302222, -1, "androidx.compose.material3.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:127)");
                    }
                    m2072getLambda2$material3_release.invoke(bottomSheetScaffoldState3.getSnackbarHostState(), composer3, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            });
            startRestartGroup.startReplaceableGroup(-1567544379);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            if (((i4 & 896) ^ 384) <= 256) {
            }
            rememberedValue = startRestartGroup.rememberedValue();
            if (!z3) {
            }
            rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$3$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Float invoke() {
                    return Float.valueOf(BottomSheetScaffoldState.this.getBottomSheetState().requireOffset());
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceableGroup();
            int i302222 = i292222 << 12;
            Function2<? super Composer, ? super Integer, Unit> function2102222 = function25;
            long j172222 = j10;
            long j182222 = j9;
            m1908BottomSheetScaffoldLayoutPxNyym8(modifier52222, function2102222, function33, composableLambda3222, composableLambda22222, f5, (Function0) rememberedValue, bottomSheetState2222, j172222, j182222, startRestartGroup, ((i292222 >> 12) & 896) | ((i4 >> 3) & 14) | 27648 | ((i292222 >> 3) & 112) | (458752 & (i4 << 6)) | (234881024 & i302222) | (i302222 & 1879048192));
            composer2 = startRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
            }
            bottomSheetScaffoldState4 = bottomSheetScaffoldState3;
            j11 = j5;
            f7 = m1904getElevationD9Ej5fM;
            z4 = z2;
            j12 = j182222;
            modifier3 = modifier52222;
            float f152222 = m1904getElevationD9Ej5fM2;
            function26 = function2102222;
            function34 = m2072getLambda2$material3_release;
            f8 = f5;
            f9 = f6;
            shape3 = shape2;
            j13 = j7;
            f10 = f152222;
            function27 = m2071getLambda1$material3_release;
            j14 = j172222;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        if ((i & 384) != 0) {
        }
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        f5 = f;
        i6 = i3 & 16;
        int i2522 = 8192;
        if (i6 != 0) {
        }
        f6 = f2;
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
        }
        if ((i & 1572864) != 0) {
        }
        if ((i & 12582912) != 0) {
        }
        i7 = i3 & 256;
        if (i7 == 0) {
        }
        i8 = i7;
        i9 = i3 & 512;
        if (i9 != 0) {
        }
        i10 = i9;
        i11 = i3 & 1024;
        if (i11 == 0) {
        }
        i14 = i3 & 2048;
        if (i14 == 0) {
        }
        int i2622222 = i13;
        i16 = i3 & 4096;
        if (i16 == 0) {
        }
        i18 = i3 & 8192;
        if (i18 == 0) {
        }
        if ((i2 & 24576) == 0) {
        }
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
        }
        if ((i3 & 65536) == 0) {
        }
        if ((306783379 & i4) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i24 == 0) {
        }
        if ((i3 & 4) == 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if ((i3 & 32) == 0) {
        }
        if ((i3 & 64) != 0) {
        }
        if ((i3 & 128) == 0) {
        }
        if (i8 == 0) {
        }
        if (i10 == 0) {
        }
        if (i12 == 0) {
        }
        if (i15 == 0) {
        }
        if (i16 == 0) {
        }
        if (i18 == 0) {
        }
        Modifier modifier422222 = companion;
        if ((i3 & 16384) == 0) {
        }
        if ((i3 & 32768) == 0) {
        }
        modifier2 = modifier422222;
        function24 = function23;
        startRestartGroup.endDefaults();
        Modifier modifier522222 = modifier2;
        if (ComposerKt.isTraceInProgress()) {
        }
        ProvidableCompositionLocal<Density> localDensity22222 = CompositionLocalsKt.getLocalDensity();
        int i2922222 = i21;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume22222 = startRestartGroup.consume(localDensity22222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        final int mo624roundToPx0680j_422222 = ((Density) consume22222).mo624roundToPx0680j_4(f5);
        SheetState bottomSheetState22222 = bottomSheetScaffoldState3.getBottomSheetState();
        final float f1122222 = f5;
        final float f1222222 = f6;
        final BottomSheetScaffoldState bottomSheetScaffoldState522222 = bottomSheetScaffoldState3;
        final Shape shape422222 = shape2;
        final long j1522222 = j5;
        final long j1622222 = j7;
        final float f1322222 = m1904getElevationD9Ej5fM;
        final float f1422222 = m1904getElevationD9Ej5fM2;
        final Function2<? super Composer, ? super Integer, Unit> function2922222 = m2071getLambda1$material3_release;
        final boolean z522222 = z2;
        ComposableLambda composableLambda32222 = ComposableLambdaKt.composableLambda(startRestartGroup, -680109608, true, new Function3<Integer, Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Composer composer3, Integer num2) {
                invoke(num.intValue(), composer3, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(final int i3022222, Composer composer3, int i31) {
                int i32;
                ComposerKt.sourceInformation(composer3, "C140@7195L686,135@6935L1296:BottomSheetScaffold.kt#uh7d8r");
                if ((i31 & 6) == 0) {
                    i32 = i31 | (composer3.changed(i3022222) ? 4 : 2);
                } else {
                    i32 = i31;
                }
                if ((i32 & 19) != 18 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-680109608, i32, -1, "androidx.compose.material3.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:135)");
                    }
                    SheetState bottomSheetState222222 = BottomSheetScaffoldState.this.getBottomSheetState();
                    composer3.startReplaceableGroup(1237684821);
                    ComposerKt.sourceInformation(composer3, "CC(remember):BottomSheetScaffold.kt#9igjgp");
                    boolean changed = ((i32 & 14) == 4) | composer3.changed(BottomSheetScaffoldState.this) | composer3.changed(mo624roundToPx0680j_422222);
                    final BottomSheetScaffoldState bottomSheetScaffoldState6 = BottomSheetScaffoldState.this;
                    final int i33 = mo624roundToPx0680j_422222;
                    Object rememberedValue2 = composer3.rememberedValue();
                    if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = (Function1) new Function1<IntSize, DraggableAnchors<SheetValue>>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ DraggableAnchors<SheetValue> invoke(IntSize intSize) {
                                return m1912invokeozmzZPI(intSize.getPackedValue());
                            }

                            /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                            public final DraggableAnchors<SheetValue> m1912invokeozmzZPI(long j1722222) {
                                final int m6558getHeightimpl = IntSize.m6558getHeightimpl(j1722222);
                                final BottomSheetScaffoldState bottomSheetScaffoldState7 = BottomSheetScaffoldState.this;
                                final int i34 = i3022222;
                                final int i35 = i33;
                                return AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<SheetValue>, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1$1$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<SheetValue> draggableAnchorsConfig) {
                                        invoke2(draggableAnchorsConfig);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(DraggableAnchorsConfig<SheetValue> draggableAnchorsConfig) {
                                        if (!BottomSheetScaffoldState.this.getBottomSheetState().getSkipPartiallyExpanded()) {
                                            draggableAnchorsConfig.at(SheetValue.PartiallyExpanded, i34 - i35);
                                        }
                                        if (m6558getHeightimpl != i35) {
                                            draggableAnchorsConfig.at(SheetValue.Expanded, Math.max(i34 - m6558getHeightimpl, 0));
                                        }
                                        if (BottomSheetScaffoldState.this.getBottomSheetState().getSkipHiddenState()) {
                                            return;
                                        }
                                        draggableAnchorsConfig.at(SheetValue.Hidden, i34);
                                    }
                                });
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue2);
                    }
                    composer3.endReplaceableGroup();
                    BottomSheetScaffoldKt.m1909StandardBottomSheetXcniZvE(bottomSheetState222222, (Function1) rememberedValue2, f1122222, f1222222, z522222, shape422222, j1522222, j1622222, f1322222, f1422222, function2922222, function3, composer3, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        });
        ComposableLambda composableLambda222222 = ComposableLambdaKt.composableLambda(startRestartGroup, 88659390, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$2
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

            public final void invoke(Composer composer3, int i3022222) {
                ComposerKt.sourceInformation(composer3, "C127@6578L45:BottomSheetScaffold.kt#uh7d8r");
                if ((i3022222 & 3) == 2 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(88659390, i3022222, -1, "androidx.compose.material3.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:127)");
                }
                m2072getLambda2$material3_release.invoke(bottomSheetScaffoldState3.getSnackbarHostState(), composer3, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        });
        startRestartGroup.startReplaceableGroup(-1567544379);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):BottomSheetScaffold.kt#9igjgp");
        if (((i4 & 896) ^ 384) <= 256) {
        }
        rememberedValue = startRestartGroup.rememberedValue();
        if (!z3) {
        }
        rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$3$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(BottomSheetScaffoldState.this.getBottomSheetState().requireOffset());
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceableGroup();
        int i3022222 = i2922222 << 12;
        Function2<? super Composer, ? super Integer, Unit> function21022222 = function25;
        long j1722222 = j10;
        long j1822222 = j9;
        m1908BottomSheetScaffoldLayoutPxNyym8(modifier522222, function21022222, function33, composableLambda32222, composableLambda222222, f5, (Function0) rememberedValue, bottomSheetState22222, j1722222, j1822222, startRestartGroup, ((i2922222 >> 12) & 896) | ((i4 >> 3) & 14) | 27648 | ((i2922222 >> 3) & 112) | (458752 & (i4 << 6)) | (234881024 & i3022222) | (i3022222 & 1879048192));
        composer2 = startRestartGroup;
        if (ComposerKt.isTraceInProgress()) {
        }
        bottomSheetScaffoldState4 = bottomSheetScaffoldState3;
        j11 = j5;
        f7 = m1904getElevationD9Ej5fM;
        z4 = z2;
        j12 = j1822222;
        modifier3 = modifier522222;
        float f1522222 = m1904getElevationD9Ej5fM2;
        function26 = function21022222;
        function34 = m2072getLambda2$material3_release;
        f8 = f5;
        f9 = f6;
        shape3 = shape2;
        j13 = j7;
        f10 = f1522222;
        function27 = m2071getLambda1$material3_release;
        j14 = j1722222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    public static final BottomSheetScaffoldState rememberBottomSheetScaffoldState(SheetState sheetState, SnackbarHostState snackbarHostState, Composer composer, int i, int i2) {
        Composer composer2;
        composer.startReplaceableGroup(-1474606134);
        ComposerKt.sourceInformation(composer, "C(rememberBottomSheetScaffoldState)189@9008L34,190@9087L32,192@9161L196:BottomSheetScaffold.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            composer2 = composer;
            sheetState = rememberStandardBottomSheetState(null, null, false, composer2, 0, 7);
        } else {
            composer2 = composer;
        }
        if ((i2 & 2) != 0) {
            composer2.startReplaceableGroup(667326536);
            ComposerKt.sourceInformation(composer2, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            Object rememberedValue = composer2.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new SnackbarHostState();
                composer2.updateRememberedValue(rememberedValue);
            }
            snackbarHostState = (SnackbarHostState) rememberedValue;
            composer2.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1474606134, i, -1, "androidx.compose.material3.rememberBottomSheetScaffoldState (BottomSheetScaffold.kt:191)");
        }
        composer2.startReplaceableGroup(667326610);
        ComposerKt.sourceInformation(composer2, "CC(remember):BottomSheetScaffold.kt#9igjgp");
        boolean z = ((((i & 14) ^ 6) > 4 && composer2.changed(sheetState)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer2.changed(snackbarHostState)) || (i & 48) == 32);
        Object rememberedValue2 = composer2.rememberedValue();
        if (z || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new BottomSheetScaffoldState(sheetState, snackbarHostState);
            composer2.updateRememberedValue(rememberedValue2);
        }
        BottomSheetScaffoldState bottomSheetScaffoldState = (BottomSheetScaffoldState) rememberedValue2;
        composer2.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer2.endReplaceableGroup();
        return bottomSheetScaffoldState;
    }

    public static final SheetState rememberStandardBottomSheetState(SheetValue sheetValue, Function1<? super SheetValue, Boolean> function1, boolean z, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(678511581);
        ComposerKt.sourceInformation(composer, "C(rememberStandardBottomSheetState)P(1)214@9987L76:BottomSheetScaffold.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            sheetValue = SheetValue.PartiallyExpanded;
        }
        SheetValue sheetValue2 = sheetValue;
        if ((i2 & 2) != 0) {
            function1 = new Function1<SheetValue, Boolean>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$rememberStandardBottomSheetState$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(SheetValue sheetValue3) {
                    return true;
                }
            };
        }
        Function1<? super SheetValue, Boolean> function12 = function1;
        if ((i2 & 4) != 0) {
            z = true;
        }
        boolean z2 = z;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(678511581, i, -1, "androidx.compose.material3.rememberStandardBottomSheetState (BottomSheetScaffold.kt:214)");
        }
        SheetState rememberSheetState = SheetDefaultsKt.rememberSheetState(false, function12, sheetValue2, z2, composer, (i & 112) | 6 | ((i << 6) & 896) | ((i << 3) & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberSheetState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: StandardBottomSheet-XcniZvE, reason: not valid java name */
    public static final void m1909StandardBottomSheetXcniZvE(final SheetState sheetState, final Function1<? super IntSize, ? extends DraggableAnchors<SheetValue>> function1, final float f, final float f2, final boolean z, final Shape shape, final long j, final long j2, final float f3, final float f4, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        boolean z2;
        Shape shape2;
        long j3;
        int i4;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(424459667);
        ComposerKt.sourceInformation(startRestartGroup, "C(StandardBottomSheet)P(10!1,5:c#ui.unit.Dp,8:c#ui.unit.Dp,9,7,1:c#ui.graphics.Color,3:c#ui.graphics.Color,11:c#ui.unit.Dp,6:c#ui.unit.Dp,4)232@10554L24,242@10826L326,255@11381L491,236@10628L3850:BottomSheetScaffold.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(sheetState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= startRestartGroup.changed(f) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= startRestartGroup.changed(f2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            z2 = z;
            i3 |= startRestartGroup.changed(z2) ? 16384 : 8192;
        } else {
            z2 = z;
        }
        if ((196608 & i) == 0) {
            shape2 = shape;
            i3 |= startRestartGroup.changed(shape2) ? 131072 : 65536;
        } else {
            shape2 = shape;
        }
        if ((1572864 & i) == 0) {
            j3 = j;
            i3 |= startRestartGroup.changed(j3) ? 1048576 : 524288;
        } else {
            j3 = j;
        }
        if ((i & 12582912) == 0) {
            i3 |= startRestartGroup.changed(j2) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= startRestartGroup.changed(f3) ? 67108864 : 33554432;
        }
        if ((i & C.ENCODING_PCM_32BIT) == 0) {
            i3 |= startRestartGroup.changed(f4) ? 536870912 : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (startRestartGroup.changedInstance(function2) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= startRestartGroup.changedInstance(function3) ? 32 : 16;
        }
        int i5 = i4;
        if ((i3 & 306783379) != 306783378 || (i5 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(424459667, i3, i5, "androidx.compose.material3.StandardBottomSheet (BottomSheetScaffold.kt:231)");
            }
            startRestartGroup.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            startRestartGroup.endReplaceableGroup();
            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
            startRestartGroup.endReplaceableGroup();
            Orientation orientation = Orientation.Vertical;
            int i6 = i3;
            Modifier m919requiredHeightInVpY3zN4$default = SizeKt.m919requiredHeightInVpY3zN4$default(SizeKt.fillMaxWidth$default(SizeKt.m935widthInVpY3zN4$default(Modifier.INSTANCE, 0.0f, f2, 1, null), 0.0f, 1, null), f, 0.0f, 2, null);
            AnchoredDraggableState<SheetValue> anchoredDraggableState$material3_release = sheetState.getAnchoredDraggableState$material3_release();
            startRestartGroup.startReplaceableGroup(1603483798);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            boolean changed = startRestartGroup.changed(anchoredDraggableState$material3_release);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = SheetDefaultsKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(sheetState, orientation, new Function1<Float, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Float f5) {
                        invoke(f5.floatValue());
                        return Unit.INSTANCE;
                    }

                    /* compiled from: BottomSheetScaffold.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$1$1$1", f = "BottomSheetScaffold.kt", i = {}, l = {247}, m = "invokeSuspend", n = {}, s = {})
                    /* renamed from: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$1$1$1, reason: invalid class name */
                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ float $it;
                        final /* synthetic */ SheetState $state;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(SheetState sheetState, float f, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.$state = sheetState;
                            this.$it = f;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.$state, this.$it, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                this.label = 1;
                                if (this.$state.settle$material3_release(this.$it, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    public final void invoke(float f5) {
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScope.this, null, null, new AnonymousClass1(sheetState, f5, null), 3, null);
                    }
                });
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            Modifier anchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(NestedScrollModifierKt.nestedScroll$default(m919requiredHeightInVpY3zN4$default, (NestedScrollConnection) rememberedValue2, null, 2, null), sheetState.getAnchoredDraggableState$material3_release(), orientation, z2, false, null, 24, null);
            startRestartGroup.startReplaceableGroup(1603484353);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            boolean z3 = ((i6 & 112) == 32) | ((i6 & 14) == 4);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$2$1

                    /* compiled from: BottomSheetScaffold.kt */
                    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                    public /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] iArr = new int[SheetValue.values().length];
                            try {
                                iArr[SheetValue.Hidden.ordinal()] = 1;
                            } catch (NoSuchFieldError unused) {
                            }
                            try {
                                iArr[SheetValue.PartiallyExpanded.ordinal()] = 2;
                            } catch (NoSuchFieldError unused2) {
                            }
                            try {
                                iArr[SheetValue.Expanded.ordinal()] = 3;
                            } catch (NoSuchFieldError unused3) {
                            }
                            $EnumSwitchMapping$0 = iArr;
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                        m1914invokeozmzZPI(intSize.getPackedValue());
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                    public final void m1914invokeozmzZPI(long j4) {
                        SheetValue sheetValue;
                        DraggableAnchors<SheetValue> invoke = function1.invoke(IntSize.m6551boximpl(j4));
                        int i7 = WhenMappings.$EnumSwitchMapping$0[sheetState.getAnchoredDraggableState$material3_release().getTargetValue().ordinal()];
                        if (i7 == 1 || i7 == 2) {
                            sheetValue = SheetValue.PartiallyExpanded;
                        } else {
                            if (i7 != 3) {
                                throw new NoWhenBranchMatchedException();
                            }
                            sheetValue = invoke.hasAnchorFor(SheetValue.Expanded) ? SheetValue.Expanded : SheetValue.PartiallyExpanded;
                        }
                        sheetState.getAnchoredDraggableState$material3_release().updateAnchors(invoke, sheetValue);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceableGroup();
            int i7 = i6 >> 12;
            composer2 = startRestartGroup;
            SurfaceKt.m2633SurfaceT9BRK9s(OnRemeasuredModifierKt.onSizeChanged(anchoredDraggable$default, (Function1) rememberedValue3), shape2, j3, j2, f3, f4, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1070542936, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3
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
                    ComposerKt.sourceInformation(composer3, "C271@12066L2406:BottomSheetScaffold.kt#uh7d8r");
                    if ((i8 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1070542936, i8, -1, "androidx.compose.material3.StandardBottomSheet.<anonymous> (BottomSheetScaffold.kt:271)");
                        }
                        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Function2<Composer, Integer, Unit> function22 = function2;
                        final SheetState sheetState2 = sheetState;
                        final boolean z4 = z;
                        final CoroutineScope coroutineScope2 = coroutineScope;
                        Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                        composer3.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
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
                        ComposerKt.sourceInformationMarkerStart(composer3, -176229282, "C314@14453L9:BottomSheetScaffold.kt#uh7d8r");
                        composer3.startReplaceableGroup(-176229282);
                        ComposerKt.sourceInformation(composer3, "274@12205L54,275@12301L48,276@12390L47,280@12599L1755,277@12454L1972");
                        if (function22 != null) {
                            Strings.Companion companion = Strings.INSTANCE;
                            final String m2623getStringNWtq28 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_bottom_sheet_collapse_description), composer3, 0);
                            Strings.Companion companion2 = Strings.INSTANCE;
                            final String m2623getStringNWtq282 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_bottom_sheet_dismiss_description), composer3, 0);
                            Strings.Companion companion3 = Strings.INSTANCE;
                            final String m2623getStringNWtq283 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_bottom_sheet_expand_description), composer3, 0);
                            Modifier align = columnScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterHorizontally());
                            composer3.startReplaceableGroup(-176228795);
                            ComposerKt.sourceInformation(composer3, "CC(remember):BottomSheetScaffold.kt#9igjgp");
                            boolean changed2 = composer3.changed(sheetState2) | composer3.changed(z4) | composer3.changed(m2623getStringNWtq283) | composer3.changedInstance(coroutineScope2) | composer3.changed(m2623getStringNWtq28) | composer3.changed(m2623getStringNWtq282);
                            Object rememberedValue4 = composer3.rememberedValue();
                            if (changed2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue4 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1
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
                                        final SheetState sheetState3 = SheetState.this;
                                        boolean z5 = z4;
                                        String str = m2623getStringNWtq283;
                                        String str2 = m2623getStringNWtq28;
                                        String str3 = m2623getStringNWtq282;
                                        final CoroutineScope coroutineScope3 = coroutineScope2;
                                        if (sheetState3.getAnchoredDraggableState$material3_release().getAnchors().getSize() <= 1 || !z5) {
                                            return;
                                        }
                                        if (sheetState3.getCurrentValue() == SheetValue.PartiallyExpanded) {
                                            if (sheetState3.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(SheetValue.Expanded).booleanValue()) {
                                                SemanticsPropertiesKt.expand(semanticsPropertyReceiver, str, new Function0<Boolean>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(0);
                                                    }

                                                    /* compiled from: BottomSheetScaffold.kt */
                                                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                                    @DebugMetadata(c = "androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1$1$1", f = "BottomSheetScaffold.kt", i = {}, l = {289}, m = "invokeSuspend", n = {}, s = {})
                                                    /* renamed from: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1$1$1, reason: invalid class name */
                                                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                        final /* synthetic */ SheetState $this_with;
                                                        int label;

                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        AnonymousClass1(SheetState sheetState, Continuation<? super AnonymousClass1> continuation) {
                                                            super(2, continuation);
                                                            this.$this_with = sheetState;
                                                        }

                                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                            return new AnonymousClass1(this.$this_with, continuation);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function2
                                                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                        }

                                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                        public final Object invokeSuspend(Object obj) {
                                                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                            int i = this.label;
                                                            if (i == 0) {
                                                                ResultKt.throwOnFailure(obj);
                                                                this.label = 1;
                                                                if (this.$this_with.expand(this) == coroutine_suspended) {
                                                                    return coroutine_suspended;
                                                                }
                                                            } else {
                                                                if (i != 1) {
                                                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                                }
                                                                ResultKt.throwOnFailure(obj);
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    }

                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Boolean invoke() {
                                                        BuildersKt__Builders_commonKt.launch$default(CoroutineScope.this, null, null, new AnonymousClass1(sheetState3, null), 3, null);
                                                        return true;
                                                    }
                                                });
                                            }
                                        } else if (sheetState3.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(SheetValue.PartiallyExpanded).booleanValue()) {
                                            SemanticsPropertiesKt.collapse(semanticsPropertyReceiver, str2, new Function0<Boolean>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1$2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                /* compiled from: BottomSheetScaffold.kt */
                                                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                                @DebugMetadata(c = "androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1$2$1", f = "BottomSheetScaffold.kt", i = {}, l = {298}, m = "invokeSuspend", n = {}, s = {})
                                                /* renamed from: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1$2$1, reason: invalid class name */
                                                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                    final /* synthetic */ SheetState $this_with;
                                                    int label;

                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    AnonymousClass1(SheetState sheetState, Continuation<? super AnonymousClass1> continuation) {
                                                        super(2, continuation);
                                                        this.$this_with = sheetState;
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                        return new AnonymousClass1(this.$this_with, continuation);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    public final Object invokeSuspend(Object obj) {
                                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                        int i = this.label;
                                                        if (i == 0) {
                                                            ResultKt.throwOnFailure(obj);
                                                            this.label = 1;
                                                            if (this.$this_with.partialExpand(this) == coroutine_suspended) {
                                                                return coroutine_suspended;
                                                            }
                                                        } else {
                                                            if (i != 1) {
                                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                            }
                                                            ResultKt.throwOnFailure(obj);
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Boolean invoke() {
                                                    BuildersKt__Builders_commonKt.launch$default(CoroutineScope.this, null, null, new AnonymousClass1(sheetState3, null), 3, null);
                                                    return true;
                                                }
                                            });
                                        }
                                        if (sheetState3.getSkipHiddenState()) {
                                            return;
                                        }
                                        SemanticsPropertiesKt.dismiss(semanticsPropertyReceiver, str3, new Function0<Boolean>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1$3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            /* compiled from: BottomSheetScaffold.kt */
                                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                            @DebugMetadata(c = "androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1$3$1", f = "BottomSheetScaffold.kt", i = {}, l = {Sdk.SDKError.Reason.AD_EXPIRED_VALUE}, m = "invokeSuspend", n = {}, s = {})
                                            /* renamed from: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1$3$1, reason: invalid class name */
                                            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                final /* synthetic */ SheetState $this_with;
                                                int label;

                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                AnonymousClass1(SheetState sheetState, Continuation<? super AnonymousClass1> continuation) {
                                                    super(2, continuation);
                                                    this.$this_with = sheetState;
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                    return new AnonymousClass1(this.$this_with, continuation);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Object invokeSuspend(Object obj) {
                                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                    int i = this.label;
                                                    if (i == 0) {
                                                        ResultKt.throwOnFailure(obj);
                                                        this.label = 1;
                                                        if (this.$this_with.hide(this) == coroutine_suspended) {
                                                            return coroutine_suspended;
                                                        }
                                                    } else {
                                                        if (i != 1) {
                                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                        }
                                                        ResultKt.throwOnFailure(obj);
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }

                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Boolean invoke() {
                                                BuildersKt__Builders_commonKt.launch$default(CoroutineScope.this, null, null, new AnonymousClass1(sheetState3, null), 3, null);
                                                return true;
                                            }
                                        });
                                    }
                                };
                                composer3.updateRememberedValue(rememberedValue4);
                            }
                            composer3.endReplaceableGroup();
                            Modifier semantics = SemanticsModifierKt.semantics(align, true, (Function1) rememberedValue4);
                            composer3.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                            composer3.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(semantics);
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
                            ComposerKt.sourceInformationMarkerStart(composer3, 1084283499, "C311@14396L12:BottomSheetScaffold.kt#uh7d8r");
                            function22.invoke(composer3, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endReplaceableGroup();
                            composer3.endNode();
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                        }
                        composer3.endReplaceableGroup();
                        function32.invoke(columnScopeInstance, composer3, 6);
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
            }), composer2, (i7 & 112) | 12582912 | (i7 & 896) | (i7 & 7168) | (57344 & i7) | (i7 & 458752), 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$4
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
                    BottomSheetScaffoldKt.m1909StandardBottomSheetXcniZvE(SheetState.this, function1, f, f2, z, shape, j, j2, f3, f4, function2, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: BottomSheetScaffoldLayout-PxNyym8, reason: not valid java name */
    public static final void m1908BottomSheetScaffoldLayoutPxNyym8(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, final Function3<? super Integer, ? super Composer, ? super Integer, Unit> function32, final Function2<? super Composer, ? super Integer, Unit> function22, final float f, final Function0<Float> function0, final SheetState sheetState, final long j, final long j2, Composer composer, final int i) {
        int i2;
        Function2<? super Composer, ? super Integer, Unit> function23;
        float f2;
        Composer startRestartGroup = composer.startRestartGroup(-1120561936);
        ComposerKt.sourceInformation(startRestartGroup, "C(BottomSheetScaffoldLayout)P(4,9!2,8,6:c#ui.unit.Dp,5,7,2:c#ui.graphics.Color,3:c#ui.graphics.Color)334@15050L7,335@15073L44,335@15062L55,338@15139L1965,338@15122L1982:BottomSheetScaffold.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function3) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function32) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            function23 = function22;
            i2 |= startRestartGroup.changedInstance(function23) ? 16384 : 8192;
        } else {
            function23 = function22;
        }
        if ((196608 & i) == 0) {
            f2 = f;
            i2 |= startRestartGroup.changed(f2) ? 131072 : 65536;
        } else {
            f2 = f;
        }
        if ((i & 1572864) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i2 |= startRestartGroup.changed(sheetState) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i2 |= startRestartGroup.changed(j) ? 67108864 : 33554432;
        }
        if ((i & C.ENCODING_PCM_32BIT) == 0) {
            i2 |= startRestartGroup.changed(j2) ? 536870912 : 268435456;
        }
        if ((i2 & 306783379) != 306783378 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1120561936, i2, -1, "androidx.compose.material3.BottomSheetScaffoldLayout (BottomSheetScaffold.kt:332)");
            }
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final Density density = (Density) consume;
            startRestartGroup.startReplaceableGroup(-99158096);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            int i3 = 29360128 & i2;
            boolean changed = (i3 == 8388608) | startRestartGroup.changed(density);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1
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
                        SheetState.this.setDensity$material3_release(density);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            EffectsKt.SideEffect((Function0) rememberedValue, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-99158030);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            boolean z = ((i2 & 7168) == 2048) | ((i2 & 112) == 32) | ((i2 & 14) == 4) | ((234881024 & i2) == 67108864) | ((1879048192 & i2) == 536870912) | ((i2 & 896) == 256) | ((458752 & i2) == 131072) | ((57344 & i2) == 16384) | ((i2 & 3670016) == 1048576) | (i3 == 8388608);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                final Function2<? super Composer, ? super Integer, Unit> function24 = function23;
                final float f3 = f2;
                rememberedValue2 = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                        return m1913invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                    }

                    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m1913invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j3) {
                        final int m6345getMaxWidthimpl = Constraints.m6345getMaxWidthimpl(j3);
                        final int m6344getMaxHeightimpl = Constraints.m6344getMaxHeightimpl(j3);
                        long m6336copyZbe2FdA$default = Constraints.m6336copyZbe2FdA$default(j3, 0, 0, 0, 0, 10, null);
                        BottomSheetScaffoldLayoutSlot bottomSheetScaffoldLayoutSlot = BottomSheetScaffoldLayoutSlot.Sheet;
                        final Function3<Integer, Composer, Integer, Unit> function33 = function32;
                        final Placeable mo5333measureBRTryo0 = subcomposeMeasureScope.subcompose(bottomSheetScaffoldLayoutSlot, ComposableLambdaKt.composableLambdaInstance(-1192048628, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1$sheetPlaceable$1
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
                                ComposerKt.sourceInformation(composer2, "C344@15421L25:BottomSheetScaffold.kt#uh7d8r");
                                if ((i4 & 3) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1192048628, i4, -1, "androidx.compose.material3.BottomSheetScaffoldLayout.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:344)");
                                }
                                function33.invoke(Integer.valueOf(m6344getMaxHeightimpl), composer2, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        })).get(0).mo5333measureBRTryo0(m6336copyZbe2FdA$default);
                        final Function2<Composer, Integer, Unit> function25 = function2;
                        final Placeable mo5333measureBRTryo02 = function25 != null ? subcomposeMeasureScope.subcompose(BottomSheetScaffoldLayoutSlot.TopBar, ComposableLambdaKt.composableLambdaInstance(-873203005, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1$topBarPlaceable$1$1
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
                                ComposerKt.sourceInformation(composer2, "C348@15594L8:BottomSheetScaffold.kt#uh7d8r");
                                if ((i4 & 3) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-873203005, i4, -1, "androidx.compose.material3.BottomSheetScaffoldLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:348)");
                                }
                                function25.invoke(composer2, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        })).get(0).mo5333measureBRTryo0(m6336copyZbe2FdA$default) : null;
                        final int height = mo5333measureBRTryo02 != null ? mo5333measureBRTryo02.getHeight() : 0;
                        long m6336copyZbe2FdA$default2 = Constraints.m6336copyZbe2FdA$default(m6336copyZbe2FdA$default, 0, 0, 0, m6344getMaxHeightimpl - height, 7, null);
                        BottomSheetScaffoldLayoutSlot bottomSheetScaffoldLayoutSlot2 = BottomSheetScaffoldLayoutSlot.Body;
                        final Modifier modifier2 = modifier;
                        final long j4 = j;
                        final long j5 = j2;
                        final Function3<PaddingValues, Composer, Integer, Unit> function34 = function3;
                        final float f4 = f3;
                        final Placeable mo5333measureBRTryo03 = subcomposeMeasureScope.subcompose(bottomSheetScaffoldLayoutSlot2, ComposableLambdaKt.composableLambdaInstance(-1459220575, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1$bodyPlaceable$1
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
                                ComposerKt.sourceInformation(composer2, "C355@15900L194:BottomSheetScaffold.kt#uh7d8r");
                                if ((i4 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1459220575, i4, -1, "androidx.compose.material3.BottomSheetScaffoldLayout.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:355)");
                                    }
                                    Modifier modifier3 = Modifier.this;
                                    long j6 = j4;
                                    long j7 = j5;
                                    final Function3<PaddingValues, Composer, Integer, Unit> function35 = function34;
                                    final float f5 = f4;
                                    SurfaceKt.m2633SurfaceT9BRK9s(modifier3, null, j6, j7, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, 1725620860, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1$bodyPlaceable$1.1
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

                                        public final void invoke(Composer composer3, int i5) {
                                            ComposerKt.sourceInformation(composer3, "C359@16047L45:BottomSheetScaffold.kt#uh7d8r");
                                            if ((i5 & 3) == 2 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1725620860, i5, -1, "androidx.compose.material3.BottomSheetScaffoldLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:359)");
                                            }
                                            function35.invoke(PaddingKt.m876PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, f5, 7, null), composer3, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer2, 12582912, 114);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        })).get(0).mo5333measureBRTryo0(m6336copyZbe2FdA$default2);
                        final Placeable mo5333measureBRTryo04 = subcomposeMeasureScope.subcompose(BottomSheetScaffoldLayoutSlot.Snackbar, function24).get(0).mo5333measureBRTryo0(m6336copyZbe2FdA$default);
                        final Function0<Float> function02 = function0;
                        final SheetState sheetState2 = sheetState;
                        return MeasureScope.layout$default(subcomposeMeasureScope, m6345getMaxWidthimpl, m6344getMaxHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1.1

                            /* compiled from: BottomSheetScaffold.kt */
                            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                            /* renamed from: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1$1$WhenMappings */
                            public /* synthetic */ class WhenMappings {
                                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                static {
                                    int[] iArr = new int[SheetValue.values().length];
                                    try {
                                        iArr[SheetValue.PartiallyExpanded.ordinal()] = 1;
                                    } catch (NoSuchFieldError unused) {
                                    }
                                    try {
                                        iArr[SheetValue.Expanded.ordinal()] = 2;
                                    } catch (NoSuchFieldError unused2) {
                                    }
                                    try {
                                        iArr[SheetValue.Hidden.ordinal()] = 3;
                                    } catch (NoSuchFieldError unused3) {
                                    }
                                    $EnumSwitchMapping$0 = iArr;
                                }
                            }

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
                                int height2;
                                int roundToInt = MathKt.roundToInt(function02.invoke().floatValue());
                                int max = Integer.max(0, (m6345getMaxWidthimpl - mo5333measureBRTryo0.getWidth()) / 2);
                                int width = (m6345getMaxWidthimpl - mo5333measureBRTryo04.getWidth()) / 2;
                                int i4 = WhenMappings.$EnumSwitchMapping$0[sheetState2.getCurrentValue().ordinal()];
                                if (i4 == 1) {
                                    height2 = roundToInt - mo5333measureBRTryo04.getHeight();
                                } else {
                                    if (i4 != 2 && i4 != 3) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    height2 = m6344getMaxHeightimpl - mo5333measureBRTryo04.getHeight();
                                }
                                int i5 = height2;
                                Placeable.PlacementScope.placeRelative$default(placementScope, mo5333measureBRTryo03, 0, height, 0.0f, 4, null);
                                Placeable placeable = mo5333measureBRTryo02;
                                if (placeable != null) {
                                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
                                }
                                Placeable.PlacementScope.placeRelative$default(placementScope, mo5333measureBRTryo0, max, roundToInt, 0.0f, 4, null);
                                Placeable.PlacementScope.placeRelative$default(placementScope, mo5333measureBRTryo04, width, i5, 0.0f, 4, null);
                            }
                        }, 4, null);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(null, (Function2) rememberedValue2, startRestartGroup, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$3
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
                    BottomSheetScaffoldKt.m1908BottomSheetScaffoldLayoutPxNyym8(Modifier.this, function2, function3, function32, function22, f, function0, sheetState, j, j2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
