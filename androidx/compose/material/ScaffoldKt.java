package androidx.compose.material;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: Scaffold.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a¨\u0001\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00140\u001d¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\u0006\u0010!\u001a\u00020\"2\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0003ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001a§\u0002\u0010&\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\u0013\b\u0002\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a2\u0013\b\u0002\u0010#\u001a\r\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a2\u0019\b\u0002\u0010+\u001a\u0013\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00140\u001d¢\u0006\u0002\b\u001a2\u0013\b\u0002\u0010-\u001a\r\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a2\b\b\u0002\u0010.\u001a\u00020\u00172\b\b\u0002\u0010/\u001a\u00020\t2 \b\u0002\u00100\u001a\u001a\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001d¢\u0006\u0002\b\u001a¢\u0006\u0002\b22\b\b\u0002\u00103\u001a\u00020\t2\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u00020\u00012\b\b\u0002\u00107\u001a\u0002082\b\b\u0002\u00109\u001a\u0002082\b\b\u0002\u0010:\u001a\u0002082\b\b\u0002\u0010;\u001a\u0002082\b\b\u0002\u0010<\u001a\u0002082\u0017\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00140\u001d¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001a\u009f\u0002\u0010&\u001a\u00020\u00142\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\u0013\b\u0002\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a2\u0013\b\u0002\u0010#\u001a\r\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a2\u0019\b\u0002\u0010+\u001a\u0013\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00140\u001d¢\u0006\u0002\b\u001a2\u0013\b\u0002\u0010-\u001a\r\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a2\b\b\u0002\u0010.\u001a\u00020\u00172\b\b\u0002\u0010/\u001a\u00020\t2 \b\u0002\u00100\u001a\u001a\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001d¢\u0006\u0002\b\u001a¢\u0006\u0002\b22\b\b\u0002\u00103\u001a\u00020\t2\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u00020\u00012\b\b\u0002\u00107\u001a\u0002082\b\b\u0002\u00109\u001a\u0002082\b\b\u0002\u0010:\u001a\u0002082\b\b\u0002\u0010;\u001a\u0002082\b\b\u0002\u0010<\u001a\u0002082\u0017\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00140\u001d¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b?\u0010@\u001a¨\u0001\u0010A\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00140\u001d¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\u0006\u0010!\u001a\u00020\"2\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0003ø\u0001\u0000¢\u0006\u0004\bB\u0010%\u001a¨\u0001\u0010C\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00140\u001d¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\u0006\u0010!\u001a\u00020\"2\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0003ø\u0001\u0000¢\u0006\u0004\bD\u0010%\u001a!\u0010E\u001a\u00020*2\b\b\u0002\u0010F\u001a\u00020G2\b\b\u0002\u0010H\u001a\u00020,H\u0007¢\u0006\u0002\u0010I\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u001c\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"1\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0087\u008e\u0002¢\u0006\u0018\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006J"}, d2 = {"FabSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "LocalFabPlacement", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material/FabPlacement;", "getLocalFabPlacement", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "<set-?>", "", "ScaffoldSubcomposeInMeasureFix", "getScaffoldSubcomposeInMeasureFix$annotations", "()V", "getScaffoldSubcomposeInMeasureFix", "()Z", "setScaffoldSubcomposeInMeasureFix", "(Z)V", "ScaffoldSubcomposeInMeasureFix$delegate", "Landroidx/compose/runtime/MutableState;", "LegacyScaffoldLayout", "", "isFabDocked", "fabPosition", "Landroidx/compose/material/FabPosition;", "topBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/UiComposable;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/PaddingValues;", "snackbar", "fab", "contentWindowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "bottomBar", "LegacyScaffoldLayout-i1QSOvI", "(ZILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Scaffold", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material/ScaffoldState;", "snackbarHost", "Landroidx/compose/material/SnackbarHostState;", "floatingActionButton", "floatingActionButtonPosition", "isFloatingActionButtonDocked", "drawerContent", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "drawerGesturesEnabled", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerElevation", "drawerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "drawerContentColor", "drawerScrimColor", "backgroundColor", "contentColor", "Scaffold-u4IkXBM", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;Landroidx/compose/material/ScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLkotlin/jvm/functions/Function3;ZLandroidx/compose/ui/graphics/Shape;FJJJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "Scaffold-27mzLpw", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material/ScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLkotlin/jvm/functions/Function3;ZLandroidx/compose/ui/graphics/Shape;FJJJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "ScaffoldLayout", "ScaffoldLayout-i1QSOvI", "ScaffoldLayoutWithMeasureFix", "ScaffoldLayoutWithMeasureFix-i1QSOvI", "rememberScaffoldState", "drawerState", "Landroidx/compose/material/DrawerState;", "snackbarHostState", "(Landroidx/compose/material/DrawerState;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/ScaffoldState;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ScaffoldKt {
    private static final MutableState ScaffoldSubcomposeInMeasureFix$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
    private static final ProvidableCompositionLocal<FabPlacement> LocalFabPlacement = CompositionLocalKt.staticCompositionLocalOf(new Function0<FabPlacement>() { // from class: androidx.compose.material.ScaffoldKt$LocalFabPlacement$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final FabPlacement invoke() {
            return null;
        }
    });
    private static final float FabSpacing = Dp.m6389constructorimpl(16);

    public static /* synthetic */ void getScaffoldSubcomposeInMeasureFix$annotations() {
    }

    public static final ScaffoldState rememberScaffoldState(DrawerState drawerState, SnackbarHostState snackbarHostState, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1569641925);
        ComposerKt.sourceInformation(composer, "C(rememberScaffoldState)74@2854L39,75@2938L32,76@2990L62:Scaffold.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            drawerState = DrawerKt.rememberDrawerState(DrawerValue.Closed, null, composer, 6, 2);
        }
        if ((i2 & 2) != 0) {
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new SnackbarHostState();
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            snackbarHostState = (SnackbarHostState) rememberedValue;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1569641925, i, -1, "androidx.compose.material.rememberScaffoldState (Scaffold.kt:76)");
        }
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new ScaffoldState(drawerState, snackbarHostState);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        ScaffoldState scaffoldState = (ScaffoldState) rememberedValue2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return scaffoldState;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0540  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x044e  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x051a  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x04f6  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x03f2  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x024a  */
    /* renamed from: Scaffold-u4IkXBM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1749Scaffoldu4IkXBM(final WindowInsets windowInsets, Modifier modifier, ScaffoldState scaffoldState, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function23, int i, boolean z, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32, boolean z2, Shape shape, float f, long j, long j2, long j3, long j4, long j5, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function33, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        Modifier modifier2;
        ScaffoldState scaffoldState2;
        int i6;
        int i7;
        int i8;
        Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function34;
        int i9;
        Function2<? super Composer, ? super Integer, Unit> function24;
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
        int i20;
        int i21;
        int i22;
        long j6;
        Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> m1633getLambda3$material_release;
        Function2<? super Composer, ? super Integer, Unit> m1634getLambda4$material_release;
        int m1680getEnd5ygKITE;
        boolean z3;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function35;
        boolean z4;
        CornerBasedShape cornerBasedShape;
        float m1649getElevationD9Ej5fM;
        Shape shape2;
        int i23;
        long j7;
        long j8;
        int i24;
        long j9;
        long j10;
        int i25;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        long j11;
        int i26;
        long j12;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Shape shape3;
        int i27;
        Shape shape4;
        boolean changed;
        Object rememberedValue;
        Shape shape5;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        final boolean z5;
        final float f2;
        final long j13;
        final long j14;
        final long j15;
        final long j16;
        final Shape shape6;
        final Modifier modifier3;
        final boolean z6;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function36;
        final int i28;
        final ScaffoldState scaffoldState3;
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function37;
        final long j17;
        ScopeUpdateScope endRestartGroup;
        int i29;
        int i30;
        Composer startRestartGroup = composer.startRestartGroup(-1288630565);
        ComposerKt.sourceInformation(startRestartGroup, "C(Scaffold)P(4,15,16,18,1,17,12,13:c#material.FabPosition,14,6,9,11,8:c#ui.unit.Dp,5:c#ui.graphics.Color,7:c#ui.graphics.Color,10:c#ui.graphics.Color,0:c#ui.graphics.Color,3:c#ui.graphics.Color)187@8483L23,196@8993L6,198@9108L6,199@9156L38,200@9241L10,201@9296L6,202@9341L32,205@9449L86:Scaffold.kt#jmzs0o");
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i5 = (startRestartGroup.changed(windowInsets) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        int i31 = i4 & 2;
        if (i31 != 0) {
            i5 |= 48;
        } else if ((i2 & 112) == 0) {
            modifier2 = modifier;
            i5 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i2 & 896) != 0) {
                if ((i4 & 4) == 0) {
                    scaffoldState2 = scaffoldState;
                    if (startRestartGroup.changed(scaffoldState2)) {
                        i30 = 256;
                        i5 |= i30;
                    }
                } else {
                    scaffoldState2 = scaffoldState;
                }
                i30 = 128;
                i5 |= i30;
            } else {
                scaffoldState2 = scaffoldState;
            }
            i6 = i4 & 8;
            int i32 = 1024;
            if (i6 == 0) {
                i5 |= 3072;
            } else if ((i2 & 7168) == 0) {
                i5 |= startRestartGroup.changedInstance(function2) ? 2048 : 1024;
                i7 = i4 & 16;
                if (i7 != 0) {
                    i5 |= 24576;
                } else if ((i2 & 57344) == 0) {
                    i5 |= startRestartGroup.changedInstance(function22) ? 16384 : 8192;
                }
                i8 = i4 & 32;
                if (i8 != 0) {
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    function34 = function3;
                } else {
                    function34 = function3;
                    if ((i2 & 458752) == 0) {
                        i5 |= startRestartGroup.changedInstance(function34) ? 131072 : 65536;
                    }
                }
                i9 = i4 & 64;
                if (i9 != 0) {
                    i5 |= 1572864;
                    function24 = function23;
                } else {
                    function24 = function23;
                    if ((i2 & 3670016) == 0) {
                        i5 |= startRestartGroup.changedInstance(function24) ? 1048576 : 524288;
                    }
                }
                i10 = i4 & 128;
                if (i10 != 0) {
                    i5 |= 12582912;
                    i11 = i;
                } else {
                    i11 = i;
                    if ((i2 & 29360128) == 0) {
                        i5 |= startRestartGroup.changed(i11) ? 8388608 : 4194304;
                    }
                }
                i12 = i4 & 256;
                if (i12 != 0) {
                    i5 |= 100663296;
                } else if ((i2 & 234881024) == 0) {
                    i13 = i12;
                    i5 |= startRestartGroup.changed(z) ? 67108864 : 33554432;
                    i14 = i4 & 512;
                    if (i14 == 0) {
                        i5 |= C.ENCODING_PCM_32BIT;
                    } else if ((i2 & 1879048192) == 0) {
                        i15 = i14;
                        i5 |= startRestartGroup.changedInstance(function32) ? 536870912 : 268435456;
                        i16 = i4 & 1024;
                        if (i16 != 0) {
                            i18 = i3 | 6;
                            i17 = i16;
                        } else if ((i3 & 14) == 0) {
                            i17 = i16;
                            i18 = i3 | (startRestartGroup.changed(z2) ? 4 : 2);
                        } else {
                            i17 = i16;
                            i18 = i3;
                        }
                        if ((i3 & 112) == 0) {
                            if ((i4 & 2048) == 0 && startRestartGroup.changed(shape)) {
                                i29 = 32;
                                i18 |= i29;
                            }
                            i29 = 16;
                            i18 |= i29;
                        }
                        int i33 = i18;
                        i19 = i4 & 4096;
                        if (i19 != 0) {
                            i20 = i33 | 384;
                        } else {
                            i20 = i33;
                            if ((i3 & 896) == 0) {
                                i20 |= startRestartGroup.changed(f) ? 256 : 128;
                                if ((i3 & 7168) != 0) {
                                    if ((i4 & 8192) == 0) {
                                        i21 = i19;
                                        if (startRestartGroup.changed(j)) {
                                            i32 = 2048;
                                        }
                                    } else {
                                        i21 = i19;
                                    }
                                    i20 |= i32;
                                } else {
                                    i21 = i19;
                                }
                                if ((i3 & 57344) != 0) {
                                    i22 = i21;
                                    i20 |= ((i4 & 16384) == 0 && startRestartGroup.changed(j2)) ? 16384 : 8192;
                                } else {
                                    i22 = i21;
                                }
                                if ((i3 & 458752) == 0) {
                                    i20 |= ((32768 & i4) == 0 && startRestartGroup.changed(j3)) ? 131072 : 65536;
                                }
                                if ((i3 & 3670016) == 0) {
                                    i20 |= ((i4 & 65536) == 0 && startRestartGroup.changed(j4)) ? 1048576 : 524288;
                                }
                                if ((i3 & 29360128) != 0) {
                                    j6 = j5;
                                    i20 |= ((i4 & 131072) == 0 && startRestartGroup.changed(j6)) ? 8388608 : 4194304;
                                } else {
                                    j6 = j5;
                                }
                                if ((262144 & i4) == 0) {
                                    i20 |= 100663296;
                                } else if ((i3 & 234881024) == 0) {
                                    i20 |= startRestartGroup.changedInstance(function33) ? 67108864 : 33554432;
                                    if ((i5 & 1533916891) == 306783378 || (i20 & 191739611) != 38347922 || !startRestartGroup.getSkipping()) {
                                        startRestartGroup.startDefaults();
                                        if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                            if (i31 != 0) {
                                                modifier2 = Modifier.INSTANCE;
                                            }
                                            if ((i4 & 4) != 0) {
                                                i5 &= -897;
                                                scaffoldState2 = rememberScaffoldState(null, null, startRestartGroup, 0, 3);
                                            }
                                            Function2<? super Composer, ? super Integer, Unit> m1631getLambda1$material_release = i6 != 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m1631getLambda1$material_release() : function2;
                                            Function2<? super Composer, ? super Integer, Unit> m1632getLambda2$material_release = i7 != 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m1632getLambda2$material_release() : function22;
                                            m1633getLambda3$material_release = i8 != 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m1633getLambda3$material_release() : function34;
                                            m1634getLambda4$material_release = i9 != 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m1634getLambda4$material_release() : function24;
                                            m1680getEnd5ygKITE = i10 != 0 ? FabPosition.INSTANCE.m1680getEnd5ygKITE() : i11;
                                            z3 = i13 != 0 ? false : z;
                                            function35 = i15 != 0 ? null : function32;
                                            z4 = i17 != 0 ? true : z2;
                                            Function2<? super Composer, ? super Integer, Unit> function210 = m1631getLambda1$material_release;
                                            Function2<? super Composer, ? super Integer, Unit> function211 = m1632getLambda2$material_release;
                                            if ((i4 & 2048) != 0) {
                                                cornerBasedShape = MaterialTheme.INSTANCE.getShapes(startRestartGroup, 6).getLarge();
                                                i20 &= -113;
                                            } else {
                                                cornerBasedShape = shape;
                                            }
                                            int i34 = i20;
                                            m1649getElevationD9Ej5fM = i22 != 0 ? DrawerDefaults.INSTANCE.m1649getElevationD9Ej5fM() : f;
                                            if ((i4 & 8192) != 0) {
                                                shape2 = cornerBasedShape;
                                                i23 = i5;
                                                j7 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m1607getSurface0d7_KjU();
                                                i34 &= -7169;
                                            } else {
                                                shape2 = cornerBasedShape;
                                                i23 = i5;
                                                j7 = j;
                                            }
                                            if ((i4 & 16384) != 0) {
                                                j8 = ColorsKt.m1621contentColorForek8zF_U(j7, startRestartGroup, (i34 >> 9) & 14);
                                                i34 &= -57345;
                                            } else {
                                                j8 = j2;
                                            }
                                            if ((32768 & i4) != 0) {
                                                i24 = 6;
                                                j9 = DrawerDefaults.INSTANCE.getScrimColor(startRestartGroup, 6);
                                                i34 &= -458753;
                                            } else {
                                                i24 = 6;
                                                j9 = j3;
                                            }
                                            if ((i4 & 65536) != 0) {
                                                i25 = i34 & (-3670017);
                                                j10 = MaterialTheme.INSTANCE.getColors(startRestartGroup, i24).m1596getBackground0d7_KjU();
                                            } else {
                                                j10 = j4;
                                                i25 = i34;
                                            }
                                            if ((i4 & 131072) != 0) {
                                                function25 = function210;
                                                i26 = i25 & (-29360129);
                                                j11 = ColorsKt.m1621contentColorForek8zF_U(j10, startRestartGroup, (i25 >> 18) & 14);
                                                i27 = i23;
                                                j12 = j10;
                                                function26 = function211;
                                                shape3 = shape2;
                                            } else {
                                                function25 = function210;
                                                j11 = j5;
                                                i26 = i25;
                                                j12 = j10;
                                                function26 = function211;
                                                shape3 = shape2;
                                                i27 = i23;
                                            }
                                        } else {
                                            startRestartGroup.skipToGroupEnd();
                                            if ((i4 & 4) != 0) {
                                                i5 &= -897;
                                            }
                                            if ((i4 & 2048) != 0) {
                                                i20 &= -113;
                                            }
                                            int i35 = i20;
                                            if ((i4 & 8192) != 0) {
                                                i35 &= -7169;
                                            }
                                            if ((i4 & 16384) != 0) {
                                                i35 &= -57345;
                                            }
                                            if ((32768 & i4) != 0) {
                                                i35 &= -458753;
                                            }
                                            if ((i4 & 65536) != 0) {
                                                i35 &= -3670017;
                                            }
                                            if ((i4 & 131072) != 0) {
                                                i35 &= -29360129;
                                            }
                                            function26 = function22;
                                            z3 = z;
                                            z4 = z2;
                                            shape3 = shape;
                                            m1649getElevationD9Ej5fM = f;
                                            j8 = j2;
                                            j9 = j3;
                                            j12 = j4;
                                            j11 = j6;
                                            m1633getLambda3$material_release = function34;
                                            m1634getLambda4$material_release = function24;
                                            m1680getEnd5ygKITE = i11;
                                            function25 = function2;
                                            function35 = function32;
                                            i26 = i35;
                                            i27 = i5;
                                            j7 = j;
                                        }
                                        startRestartGroup.endDefaults();
                                        final Function2<? super Composer, ? super Integer, Unit> function212 = function26;
                                        if (ComposerKt.isTraceInProgress()) {
                                            shape4 = shape3;
                                            ComposerKt.traceEventStart(-1288630565, i27, i26, "androidx.compose.material.Scaffold (Scaffold.kt:204)");
                                        } else {
                                            shape4 = shape3;
                                        }
                                        startRestartGroup.startReplaceableGroup(1157296644);
                                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
                                        changed = startRestartGroup.changed(windowInsets);
                                        rememberedValue = startRestartGroup.rememberedValue();
                                        if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue = new MutableWindowInsets(windowInsets);
                                            startRestartGroup.updateRememberedValue(rememberedValue);
                                        }
                                        startRestartGroup.endReplaceableGroup();
                                        final MutableWindowInsets mutableWindowInsets = (MutableWindowInsets) rememberedValue;
                                        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function38 = m1633getLambda3$material_release;
                                        final Function2<? super Composer, ? super Integer, Unit> function213 = m1634getLambda4$material_release;
                                        final int i36 = m1680getEnd5ygKITE;
                                        final ScaffoldState scaffoldState4 = scaffoldState2;
                                        final boolean z7 = z3;
                                        final long j18 = j12;
                                        final long j19 = j11;
                                        Function2<? super Composer, ? super Integer, Unit> function214 = function25;
                                        int i37 = i27;
                                        final ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, -219833176, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier4, Composer composer3, Integer num) {
                                                invoke(modifier4, composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Modifier modifier4, Composer composer3, int i38) {
                                                int i39;
                                                ComposerKt.sourceInformation(composer3, "C209@9601L905:Scaffold.kt#jmzs0o");
                                                if ((i38 & 14) == 0) {
                                                    i39 = i38 | (composer3.changed(modifier4) ? 4 : 2);
                                                } else {
                                                    i39 = i38;
                                                }
                                                if ((i39 & 91) != 18 || !composer3.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-219833176, i39, -1, "androidx.compose.material.Scaffold.<anonymous> (Scaffold.kt:209)");
                                                    }
                                                    composer3.startReplaceableGroup(-757570588);
                                                    boolean changed2 = composer3.changed(MutableWindowInsets.this) | composer3.changed(windowInsets);
                                                    final MutableWindowInsets mutableWindowInsets2 = MutableWindowInsets.this;
                                                    final WindowInsets windowInsets2 = windowInsets;
                                                    Object rememberedValue2 = composer3.rememberedValue();
                                                    if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue2 = (Function1) new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1$1$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public /* bridge */ /* synthetic */ Unit invoke(WindowInsets windowInsets3) {
                                                                invoke2(windowInsets3);
                                                                return Unit.INSTANCE;
                                                            }

                                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                            public final void invoke2(WindowInsets windowInsets3) {
                                                                MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(windowInsets2, windowInsets3));
                                                            }
                                                        };
                                                        composer3.updateRememberedValue(rememberedValue2);
                                                    }
                                                    composer3.endReplaceableGroup();
                                                    Modifier onConsumedWindowInsetsChanged = WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(modifier4, (Function1) rememberedValue2);
                                                    long j20 = j18;
                                                    long j21 = j19;
                                                    final boolean z8 = z7;
                                                    final int i40 = i36;
                                                    final Function2<Composer, Integer, Unit> function215 = function25;
                                                    final Function3<PaddingValues, Composer, Integer, Unit> function39 = function33;
                                                    final Function2<Composer, Integer, Unit> function216 = function213;
                                                    final MutableWindowInsets mutableWindowInsets3 = MutableWindowInsets.this;
                                                    final Function2<Composer, Integer, Unit> function217 = function212;
                                                    final Function3<SnackbarHostState, Composer, Integer, Unit> function310 = function38;
                                                    final ScaffoldState scaffoldState5 = scaffoldState4;
                                                    SurfaceKt.m1782SurfaceFjzlyU(onConsumedWindowInsetsChanged, null, j20, j21, null, 0.0f, ComposableLambdaKt.composableLambda(composer3, 1772955108, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1.2
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

                                                        public final void invoke(Composer composer4, int i41) {
                                                            ComposerKt.sourceInformation(composer4, "C218@10033L463:Scaffold.kt#jmzs0o");
                                                            if ((i41 & 11) != 2 || !composer4.getSkipping()) {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(1772955108, i41, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous> (Scaffold.kt:218)");
                                                                }
                                                                boolean z9 = z8;
                                                                int i42 = i40;
                                                                Function2<Composer, Integer, Unit> function218 = function215;
                                                                Function3<PaddingValues, Composer, Integer, Unit> function311 = function39;
                                                                final Function3<SnackbarHostState, Composer, Integer, Unit> function312 = function310;
                                                                final ScaffoldState scaffoldState6 = scaffoldState5;
                                                                ScaffoldKt.m1750ScaffoldLayouti1QSOvI(z9, i42, function218, function311, ComposableLambdaKt.composableLambda(composer4, 433906483, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt.Scaffold.child.1.2.1
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

                                                                    public final void invoke(Composer composer5, int i43) {
                                                                        ComposerKt.sourceInformation(composer5, "C225@10336L45:Scaffold.kt#jmzs0o");
                                                                        if ((i43 & 11) == 2 && composer5.getSkipping()) {
                                                                            composer5.skipToGroupEnd();
                                                                            return;
                                                                        }
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(433906483, i43, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:225)");
                                                                        }
                                                                        function312.invoke(scaffoldState6.getSnackbarHostState(), composer5, 0);
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                        }
                                                                    }
                                                                }), function216, mutableWindowInsets3, function217, composer4, 24576);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            composer4.skipToGroupEnd();
                                                        }
                                                    }), composer3, 1572864, 50);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer3.skipToGroupEnd();
                                            }
                                        });
                                        if (function35 != null) {
                                            startRestartGroup.startReplaceableGroup(-1013846315);
                                            ComposerKt.sourceInformation(startRestartGroup, "234@10555L487");
                                            int i38 = i26 << 9;
                                            Shape shape7 = shape4;
                                            DrawerKt.m1652ModalDrawerGs3lGvM(function35, modifier2, scaffoldState2.getDrawerState(), z4, shape7, m1649getElevationD9Ej5fM, j7, j8, j9, ComposableLambdaKt.composableLambda(startRestartGroup, -1409196448, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$1
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

                                                public final void invoke(Composer composer3, int i39) {
                                                    ComposerKt.sourceInformation(composer3, "C244@11015L15:Scaffold.kt#jmzs0o");
                                                    if ((i39 & 11) == 2 && composer3.getSkipping()) {
                                                        composer3.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1409196448, i39, -1, "androidx.compose.material.Scaffold.<anonymous> (Scaffold.kt:244)");
                                                    }
                                                    composableLambda.invoke(Modifier.INSTANCE, composer3, 54);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }), startRestartGroup, ((i37 >> 27) & 14) | C.ENCODING_PCM_32BIT | (i37 & 112) | (i38 & 7168) | (i38 & 57344) | (i38 & 458752) | (i38 & 3670016) | (i38 & 29360128) | (i38 & 234881024), 0);
                                            shape5 = shape7;
                                            composer2 = startRestartGroup;
                                            composer2.endReplaceableGroup();
                                        } else {
                                            shape5 = shape4;
                                            composer2 = startRestartGroup;
                                            composer2.startReplaceableGroup(-1013845806);
                                            ComposerKt.sourceInformation(composer2, "247@11064L15");
                                            composableLambda.invoke(modifier2, composer2, Integer.valueOf(((i37 >> 3) & 14) | 48));
                                            composer2.endReplaceableGroup();
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        function27 = function214;
                                        function28 = m1634getLambda4$material_release;
                                        z5 = z3;
                                        f2 = m1649getElevationD9Ej5fM;
                                        j13 = j8;
                                        j14 = j9;
                                        j15 = j12;
                                        j16 = j11;
                                        ScaffoldState scaffoldState5 = scaffoldState2;
                                        shape6 = shape5;
                                        modifier3 = modifier2;
                                        z6 = z4;
                                        long j20 = j7;
                                        function29 = function212;
                                        function36 = m1633getLambda3$material_release;
                                        i28 = m1680getEnd5ygKITE;
                                        scaffoldState3 = scaffoldState5;
                                        function37 = function35;
                                        j17 = j20;
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        function29 = function22;
                                        f2 = f;
                                        j13 = j2;
                                        j14 = j3;
                                        j15 = j4;
                                        composer2 = startRestartGroup;
                                        j16 = j6;
                                        function36 = function34;
                                        function28 = function24;
                                        modifier3 = modifier2;
                                        scaffoldState3 = scaffoldState2;
                                        i28 = i11;
                                        function27 = function2;
                                        z5 = z;
                                        function37 = function32;
                                        z6 = z2;
                                        shape6 = shape;
                                        j17 = j;
                                    }
                                    endRestartGroup = composer2.endRestartGroup();
                                    if (endRestartGroup != null) {
                                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$2
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

                                            public final void invoke(Composer composer3, int i39) {
                                                ScaffoldKt.m1749Scaffoldu4IkXBM(WindowInsets.this, modifier3, scaffoldState3, function27, function29, function36, function28, i28, z5, function37, z6, shape6, f2, j17, j13, j14, j15, j16, function33, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                                if ((i5 & 1533916891) == 306783378) {
                                }
                                startRestartGroup.startDefaults();
                                if ((i2 & 1) != 0) {
                                }
                                if (i31 != 0) {
                                }
                                if ((i4 & 4) != 0) {
                                }
                                if (i6 != 0) {
                                }
                                if (i7 != 0) {
                                }
                                if (i8 != 0) {
                                }
                                if (i9 != 0) {
                                }
                                if (i10 != 0) {
                                }
                                if (i13 != 0) {
                                }
                                if (i15 != 0) {
                                }
                                if (i17 != 0) {
                                }
                                Function2<? super Composer, ? super Integer, Unit> function2102 = m1631getLambda1$material_release;
                                Function2<? super Composer, ? super Integer, Unit> function2112 = m1632getLambda2$material_release;
                                if ((i4 & 2048) != 0) {
                                }
                                int i342 = i20;
                                if (i22 != 0) {
                                }
                                if ((i4 & 8192) != 0) {
                                }
                                if ((i4 & 16384) != 0) {
                                }
                                if ((32768 & i4) != 0) {
                                }
                                if ((i4 & 65536) != 0) {
                                }
                                if ((i4 & 131072) != 0) {
                                }
                                startRestartGroup.endDefaults();
                                final Function2<? super Composer, ? super Integer, Unit> function2122 = function26;
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                startRestartGroup.startReplaceableGroup(1157296644);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
                                changed = startRestartGroup.changed(windowInsets);
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (!changed) {
                                }
                                rememberedValue = new MutableWindowInsets(windowInsets);
                                startRestartGroup.updateRememberedValue(rememberedValue);
                                startRestartGroup.endReplaceableGroup();
                                final MutableWindowInsets mutableWindowInsets2 = (MutableWindowInsets) rememberedValue;
                                final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function382 = m1633getLambda3$material_release;
                                final Function2<? super Composer, ? super Integer, Unit> function2132 = m1634getLambda4$material_release;
                                final int i362 = m1680getEnd5ygKITE;
                                final ScaffoldState scaffoldState42 = scaffoldState2;
                                final boolean z72 = z3;
                                final long j182 = j12;
                                final long j192 = j11;
                                Function2<? super Composer, ? super Integer, Unit> function2142 = function25;
                                int i372 = i27;
                                final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> composableLambda2 = ComposableLambdaKt.composableLambda(startRestartGroup, -219833176, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier4, Composer composer3, Integer num) {
                                        invoke(modifier4, composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Modifier modifier4, Composer composer3, int i382) {
                                        int i39;
                                        ComposerKt.sourceInformation(composer3, "C209@9601L905:Scaffold.kt#jmzs0o");
                                        if ((i382 & 14) == 0) {
                                            i39 = i382 | (composer3.changed(modifier4) ? 4 : 2);
                                        } else {
                                            i39 = i382;
                                        }
                                        if ((i39 & 91) != 18 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-219833176, i39, -1, "androidx.compose.material.Scaffold.<anonymous> (Scaffold.kt:209)");
                                            }
                                            composer3.startReplaceableGroup(-757570588);
                                            boolean changed2 = composer3.changed(MutableWindowInsets.this) | composer3.changed(windowInsets);
                                            final MutableWindowInsets mutableWindowInsets22 = MutableWindowInsets.this;
                                            final WindowInsets windowInsets2 = windowInsets;
                                            Object rememberedValue2 = composer3.rememberedValue();
                                            if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue2 = (Function1) new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1$1$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ Unit invoke(WindowInsets windowInsets3) {
                                                        invoke2(windowInsets3);
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(WindowInsets windowInsets3) {
                                                        MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(windowInsets2, windowInsets3));
                                                    }
                                                };
                                                composer3.updateRememberedValue(rememberedValue2);
                                            }
                                            composer3.endReplaceableGroup();
                                            Modifier onConsumedWindowInsetsChanged = WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(modifier4, (Function1) rememberedValue2);
                                            long j202 = j182;
                                            long j21 = j192;
                                            final boolean z8 = z72;
                                            final int i40 = i362;
                                            final Function2<? super Composer, ? super Integer, Unit> function215 = function25;
                                            final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function39 = function33;
                                            final Function2<? super Composer, ? super Integer, Unit> function216 = function2132;
                                            final MutableWindowInsets mutableWindowInsets3 = MutableWindowInsets.this;
                                            final Function2<? super Composer, ? super Integer, Unit> function217 = function2122;
                                            final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function310 = function382;
                                            final ScaffoldState scaffoldState52 = scaffoldState42;
                                            SurfaceKt.m1782SurfaceFjzlyU(onConsumedWindowInsetsChanged, null, j202, j21, null, 0.0f, ComposableLambdaKt.composableLambda(composer3, 1772955108, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1.2
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

                                                public final void invoke(Composer composer4, int i41) {
                                                    ComposerKt.sourceInformation(composer4, "C218@10033L463:Scaffold.kt#jmzs0o");
                                                    if ((i41 & 11) != 2 || !composer4.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(1772955108, i41, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous> (Scaffold.kt:218)");
                                                        }
                                                        boolean z9 = z8;
                                                        int i42 = i40;
                                                        Function2<Composer, Integer, Unit> function218 = function215;
                                                        Function3<PaddingValues, Composer, Integer, Unit> function311 = function39;
                                                        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function312 = function310;
                                                        final ScaffoldState scaffoldState6 = scaffoldState52;
                                                        ScaffoldKt.m1750ScaffoldLayouti1QSOvI(z9, i42, function218, function311, ComposableLambdaKt.composableLambda(composer4, 433906483, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt.Scaffold.child.1.2.1
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

                                                            public final void invoke(Composer composer5, int i43) {
                                                                ComposerKt.sourceInformation(composer5, "C225@10336L45:Scaffold.kt#jmzs0o");
                                                                if ((i43 & 11) == 2 && composer5.getSkipping()) {
                                                                    composer5.skipToGroupEnd();
                                                                    return;
                                                                }
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(433906483, i43, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:225)");
                                                                }
                                                                function312.invoke(scaffoldState6.getSnackbarHostState(), composer5, 0);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                        }), function216, mutableWindowInsets3, function217, composer4, 24576);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer4.skipToGroupEnd();
                                                }
                                            }), composer3, 1572864, 50);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                });
                                if (function35 != null) {
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                function27 = function2142;
                                function28 = m1634getLambda4$material_release;
                                z5 = z3;
                                f2 = m1649getElevationD9Ej5fM;
                                j13 = j8;
                                j14 = j9;
                                j15 = j12;
                                j16 = j11;
                                ScaffoldState scaffoldState52 = scaffoldState2;
                                shape6 = shape5;
                                modifier3 = modifier2;
                                z6 = z4;
                                long j202 = j7;
                                function29 = function2122;
                                function36 = m1633getLambda3$material_release;
                                i28 = m1680getEnd5ygKITE;
                                scaffoldState3 = scaffoldState52;
                                function37 = function35;
                                j17 = j202;
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup != null) {
                                }
                            }
                        }
                        if ((i3 & 7168) != 0) {
                        }
                        if ((i3 & 57344) != 0) {
                        }
                        if ((i3 & 458752) == 0) {
                        }
                        if ((i3 & 3670016) == 0) {
                        }
                        if ((i3 & 29360128) != 0) {
                        }
                        if ((262144 & i4) == 0) {
                        }
                        if ((i5 & 1533916891) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                        }
                        if (i31 != 0) {
                        }
                        if ((i4 & 4) != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if (i7 != 0) {
                        }
                        if (i8 != 0) {
                        }
                        if (i9 != 0) {
                        }
                        if (i10 != 0) {
                        }
                        if (i13 != 0) {
                        }
                        if (i15 != 0) {
                        }
                        if (i17 != 0) {
                        }
                        Function2<? super Composer, ? super Integer, Unit> function21022 = m1631getLambda1$material_release;
                        Function2<? super Composer, ? super Integer, Unit> function21122 = m1632getLambda2$material_release;
                        if ((i4 & 2048) != 0) {
                        }
                        int i3422 = i20;
                        if (i22 != 0) {
                        }
                        if ((i4 & 8192) != 0) {
                        }
                        if ((i4 & 16384) != 0) {
                        }
                        if ((32768 & i4) != 0) {
                        }
                        if ((i4 & 65536) != 0) {
                        }
                        if ((i4 & 131072) != 0) {
                        }
                        startRestartGroup.endDefaults();
                        final Function2<? super Composer, ? super Integer, Unit> function21222 = function26;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        startRestartGroup.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
                        changed = startRestartGroup.changed(windowInsets);
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (!changed) {
                        }
                        rememberedValue = new MutableWindowInsets(windowInsets);
                        startRestartGroup.updateRememberedValue(rememberedValue);
                        startRestartGroup.endReplaceableGroup();
                        final MutableWindowInsets mutableWindowInsets22 = (MutableWindowInsets) rememberedValue;
                        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3822 = m1633getLambda3$material_release;
                        final Function2<? super Composer, ? super Integer, Unit> function21322 = m1634getLambda4$material_release;
                        final int i3622 = m1680getEnd5ygKITE;
                        final ScaffoldState scaffoldState422 = scaffoldState2;
                        final boolean z722 = z3;
                        final long j1822 = j12;
                        final long j1922 = j11;
                        Function2<? super Composer, ? super Integer, Unit> function21422 = function25;
                        int i3722 = i27;
                        final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> composableLambda22 = ComposableLambdaKt.composableLambda(startRestartGroup, -219833176, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier4, Composer composer3, Integer num) {
                                invoke(modifier4, composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Modifier modifier4, Composer composer3, int i382) {
                                int i39;
                                ComposerKt.sourceInformation(composer3, "C209@9601L905:Scaffold.kt#jmzs0o");
                                if ((i382 & 14) == 0) {
                                    i39 = i382 | (composer3.changed(modifier4) ? 4 : 2);
                                } else {
                                    i39 = i382;
                                }
                                if ((i39 & 91) != 18 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-219833176, i39, -1, "androidx.compose.material.Scaffold.<anonymous> (Scaffold.kt:209)");
                                    }
                                    composer3.startReplaceableGroup(-757570588);
                                    boolean changed2 = composer3.changed(MutableWindowInsets.this) | composer3.changed(windowInsets);
                                    final MutableWindowInsets mutableWindowInsets222 = MutableWindowInsets.this;
                                    final WindowInsets windowInsets2 = windowInsets;
                                    Object rememberedValue2 = composer3.rememberedValue();
                                    if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue2 = (Function1) new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(WindowInsets windowInsets3) {
                                                invoke2(windowInsets3);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(WindowInsets windowInsets3) {
                                                MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(windowInsets2, windowInsets3));
                                            }
                                        };
                                        composer3.updateRememberedValue(rememberedValue2);
                                    }
                                    composer3.endReplaceableGroup();
                                    Modifier onConsumedWindowInsetsChanged = WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(modifier4, (Function1) rememberedValue2);
                                    long j2022 = j1822;
                                    long j21 = j1922;
                                    final boolean z8 = z722;
                                    final int i40 = i3622;
                                    final Function2<? super Composer, ? super Integer, Unit> function215 = function25;
                                    final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function39 = function33;
                                    final Function2<? super Composer, ? super Integer, Unit> function216 = function21322;
                                    final MutableWindowInsets mutableWindowInsets3 = MutableWindowInsets.this;
                                    final Function2<? super Composer, ? super Integer, Unit> function217 = function21222;
                                    final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function310 = function3822;
                                    final ScaffoldState scaffoldState522 = scaffoldState422;
                                    SurfaceKt.m1782SurfaceFjzlyU(onConsumedWindowInsetsChanged, null, j2022, j21, null, 0.0f, ComposableLambdaKt.composableLambda(composer3, 1772955108, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1.2
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

                                        public final void invoke(Composer composer4, int i41) {
                                            ComposerKt.sourceInformation(composer4, "C218@10033L463:Scaffold.kt#jmzs0o");
                                            if ((i41 & 11) != 2 || !composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1772955108, i41, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous> (Scaffold.kt:218)");
                                                }
                                                boolean z9 = z8;
                                                int i42 = i40;
                                                Function2<Composer, Integer, Unit> function218 = function215;
                                                Function3<PaddingValues, Composer, Integer, Unit> function311 = function39;
                                                final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function312 = function310;
                                                final ScaffoldState scaffoldState6 = scaffoldState522;
                                                ScaffoldKt.m1750ScaffoldLayouti1QSOvI(z9, i42, function218, function311, ComposableLambdaKt.composableLambda(composer4, 433906483, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt.Scaffold.child.1.2.1
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

                                                    public final void invoke(Composer composer5, int i43) {
                                                        ComposerKt.sourceInformation(composer5, "C225@10336L45:Scaffold.kt#jmzs0o");
                                                        if ((i43 & 11) == 2 && composer5.getSkipping()) {
                                                            composer5.skipToGroupEnd();
                                                            return;
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(433906483, i43, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:225)");
                                                        }
                                                        function312.invoke(scaffoldState6.getSnackbarHostState(), composer5, 0);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }), function216, mutableWindowInsets3, function217, composer4, 24576);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer4.skipToGroupEnd();
                                        }
                                    }), composer3, 1572864, 50);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        });
                        if (function35 != null) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        function27 = function21422;
                        function28 = m1634getLambda4$material_release;
                        z5 = z3;
                        f2 = m1649getElevationD9Ej5fM;
                        j13 = j8;
                        j14 = j9;
                        j15 = j12;
                        j16 = j11;
                        ScaffoldState scaffoldState522 = scaffoldState2;
                        shape6 = shape5;
                        modifier3 = modifier2;
                        z6 = z4;
                        long j2022 = j7;
                        function29 = function21222;
                        function36 = m1633getLambda3$material_release;
                        i28 = m1680getEnd5ygKITE;
                        scaffoldState3 = scaffoldState522;
                        function37 = function35;
                        j17 = j2022;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    i15 = i14;
                    i16 = i4 & 1024;
                    if (i16 != 0) {
                    }
                    if ((i3 & 112) == 0) {
                    }
                    int i332 = i18;
                    i19 = i4 & 4096;
                    if (i19 != 0) {
                    }
                    if ((i3 & 7168) != 0) {
                    }
                    if ((i3 & 57344) != 0) {
                    }
                    if ((i3 & 458752) == 0) {
                    }
                    if ((i3 & 3670016) == 0) {
                    }
                    if ((i3 & 29360128) != 0) {
                    }
                    if ((262144 & i4) == 0) {
                    }
                    if ((i5 & 1533916891) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                    }
                    if (i31 != 0) {
                    }
                    if ((i4 & 4) != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i13 != 0) {
                    }
                    if (i15 != 0) {
                    }
                    if (i17 != 0) {
                    }
                    Function2<? super Composer, ? super Integer, Unit> function210222 = m1631getLambda1$material_release;
                    Function2<? super Composer, ? super Integer, Unit> function211222 = m1632getLambda2$material_release;
                    if ((i4 & 2048) != 0) {
                    }
                    int i34222 = i20;
                    if (i22 != 0) {
                    }
                    if ((i4 & 8192) != 0) {
                    }
                    if ((i4 & 16384) != 0) {
                    }
                    if ((32768 & i4) != 0) {
                    }
                    if ((i4 & 65536) != 0) {
                    }
                    if ((i4 & 131072) != 0) {
                    }
                    startRestartGroup.endDefaults();
                    final Function2<? super Composer, ? super Integer, Unit> function212222 = function26;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
                    changed = startRestartGroup.changed(windowInsets);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue = new MutableWindowInsets(windowInsets);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    startRestartGroup.endReplaceableGroup();
                    final MutableWindowInsets mutableWindowInsets222 = (MutableWindowInsets) rememberedValue;
                    final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function38222 = m1633getLambda3$material_release;
                    final Function2<? super Composer, ? super Integer, Unit> function213222 = m1634getLambda4$material_release;
                    final int i36222 = m1680getEnd5ygKITE;
                    final ScaffoldState scaffoldState4222 = scaffoldState2;
                    final boolean z7222 = z3;
                    final long j18222 = j12;
                    final long j19222 = j11;
                    Function2<? super Composer, ? super Integer, Unit> function214222 = function25;
                    int i37222 = i27;
                    final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> composableLambda222 = ComposableLambdaKt.composableLambda(startRestartGroup, -219833176, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier4, Composer composer3, Integer num) {
                            invoke(modifier4, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Modifier modifier4, Composer composer3, int i382) {
                            int i39;
                            ComposerKt.sourceInformation(composer3, "C209@9601L905:Scaffold.kt#jmzs0o");
                            if ((i382 & 14) == 0) {
                                i39 = i382 | (composer3.changed(modifier4) ? 4 : 2);
                            } else {
                                i39 = i382;
                            }
                            if ((i39 & 91) != 18 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-219833176, i39, -1, "androidx.compose.material.Scaffold.<anonymous> (Scaffold.kt:209)");
                                }
                                composer3.startReplaceableGroup(-757570588);
                                boolean changed2 = composer3.changed(MutableWindowInsets.this) | composer3.changed(windowInsets);
                                final MutableWindowInsets mutableWindowInsets2222 = MutableWindowInsets.this;
                                final WindowInsets windowInsets2 = windowInsets;
                                Object rememberedValue2 = composer3.rememberedValue();
                                if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue2 = (Function1) new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(WindowInsets windowInsets3) {
                                            invoke2(windowInsets3);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(WindowInsets windowInsets3) {
                                            MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(windowInsets2, windowInsets3));
                                        }
                                    };
                                    composer3.updateRememberedValue(rememberedValue2);
                                }
                                composer3.endReplaceableGroup();
                                Modifier onConsumedWindowInsetsChanged = WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(modifier4, (Function1) rememberedValue2);
                                long j20222 = j18222;
                                long j21 = j19222;
                                final boolean z8 = z7222;
                                final int i40 = i36222;
                                final Function2<? super Composer, ? super Integer, Unit> function215 = function25;
                                final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function39 = function33;
                                final Function2<? super Composer, ? super Integer, Unit> function216 = function213222;
                                final MutableWindowInsets mutableWindowInsets3 = MutableWindowInsets.this;
                                final Function2<? super Composer, ? super Integer, Unit> function217 = function212222;
                                final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function310 = function38222;
                                final ScaffoldState scaffoldState5222 = scaffoldState4222;
                                SurfaceKt.m1782SurfaceFjzlyU(onConsumedWindowInsetsChanged, null, j20222, j21, null, 0.0f, ComposableLambdaKt.composableLambda(composer3, 1772955108, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1.2
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

                                    public final void invoke(Composer composer4, int i41) {
                                        ComposerKt.sourceInformation(composer4, "C218@10033L463:Scaffold.kt#jmzs0o");
                                        if ((i41 & 11) != 2 || !composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1772955108, i41, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous> (Scaffold.kt:218)");
                                            }
                                            boolean z9 = z8;
                                            int i42 = i40;
                                            Function2<Composer, Integer, Unit> function218 = function215;
                                            Function3<PaddingValues, Composer, Integer, Unit> function311 = function39;
                                            final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function312 = function310;
                                            final ScaffoldState scaffoldState6 = scaffoldState5222;
                                            ScaffoldKt.m1750ScaffoldLayouti1QSOvI(z9, i42, function218, function311, ComposableLambdaKt.composableLambda(composer4, 433906483, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt.Scaffold.child.1.2.1
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

                                                public final void invoke(Composer composer5, int i43) {
                                                    ComposerKt.sourceInformation(composer5, "C225@10336L45:Scaffold.kt#jmzs0o");
                                                    if ((i43 & 11) == 2 && composer5.getSkipping()) {
                                                        composer5.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(433906483, i43, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:225)");
                                                    }
                                                    function312.invoke(scaffoldState6.getSnackbarHostState(), composer5, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }), function216, mutableWindowInsets3, function217, composer4, 24576);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                }), composer3, 1572864, 50);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    });
                    if (function35 != null) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    function27 = function214222;
                    function28 = m1634getLambda4$material_release;
                    z5 = z3;
                    f2 = m1649getElevationD9Ej5fM;
                    j13 = j8;
                    j14 = j9;
                    j15 = j12;
                    j16 = j11;
                    ScaffoldState scaffoldState5222 = scaffoldState2;
                    shape6 = shape5;
                    modifier3 = modifier2;
                    z6 = z4;
                    long j20222 = j7;
                    function29 = function212222;
                    function36 = m1633getLambda3$material_release;
                    i28 = m1680getEnd5ygKITE;
                    scaffoldState3 = scaffoldState5222;
                    function37 = function35;
                    j17 = j20222;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i13 = i12;
                i14 = i4 & 512;
                if (i14 == 0) {
                }
                i15 = i14;
                i16 = i4 & 1024;
                if (i16 != 0) {
                }
                if ((i3 & 112) == 0) {
                }
                int i3322 = i18;
                i19 = i4 & 4096;
                if (i19 != 0) {
                }
                if ((i3 & 7168) != 0) {
                }
                if ((i3 & 57344) != 0) {
                }
                if ((i3 & 458752) == 0) {
                }
                if ((i3 & 3670016) == 0) {
                }
                if ((i3 & 29360128) != 0) {
                }
                if ((262144 & i4) == 0) {
                }
                if ((i5 & 1533916891) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i31 != 0) {
                }
                if ((i4 & 4) != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if (i10 != 0) {
                }
                if (i13 != 0) {
                }
                if (i15 != 0) {
                }
                if (i17 != 0) {
                }
                Function2<? super Composer, ? super Integer, Unit> function2102222 = m1631getLambda1$material_release;
                Function2<? super Composer, ? super Integer, Unit> function2112222 = m1632getLambda2$material_release;
                if ((i4 & 2048) != 0) {
                }
                int i342222 = i20;
                if (i22 != 0) {
                }
                if ((i4 & 8192) != 0) {
                }
                if ((i4 & 16384) != 0) {
                }
                if ((32768 & i4) != 0) {
                }
                if ((i4 & 65536) != 0) {
                }
                if ((i4 & 131072) != 0) {
                }
                startRestartGroup.endDefaults();
                final Function2<? super Composer, ? super Integer, Unit> function2122222 = function26;
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
                changed = startRestartGroup.changed(windowInsets);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue = new MutableWindowInsets(windowInsets);
                startRestartGroup.updateRememberedValue(rememberedValue);
                startRestartGroup.endReplaceableGroup();
                final MutableWindowInsets mutableWindowInsets2222 = (MutableWindowInsets) rememberedValue;
                final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function382222 = m1633getLambda3$material_release;
                final Function2<? super Composer, ? super Integer, Unit> function2132222 = m1634getLambda4$material_release;
                final int i362222 = m1680getEnd5ygKITE;
                final ScaffoldState scaffoldState42222 = scaffoldState2;
                final boolean z72222 = z3;
                final long j182222 = j12;
                final long j192222 = j11;
                Function2<? super Composer, ? super Integer, Unit> function2142222 = function25;
                int i372222 = i27;
                final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> composableLambda2222 = ComposableLambdaKt.composableLambda(startRestartGroup, -219833176, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier4, Composer composer3, Integer num) {
                        invoke(modifier4, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Modifier modifier4, Composer composer3, int i382) {
                        int i39;
                        ComposerKt.sourceInformation(composer3, "C209@9601L905:Scaffold.kt#jmzs0o");
                        if ((i382 & 14) == 0) {
                            i39 = i382 | (composer3.changed(modifier4) ? 4 : 2);
                        } else {
                            i39 = i382;
                        }
                        if ((i39 & 91) != 18 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-219833176, i39, -1, "androidx.compose.material.Scaffold.<anonymous> (Scaffold.kt:209)");
                            }
                            composer3.startReplaceableGroup(-757570588);
                            boolean changed2 = composer3.changed(MutableWindowInsets.this) | composer3.changed(windowInsets);
                            final MutableWindowInsets mutableWindowInsets22222 = MutableWindowInsets.this;
                            final WindowInsets windowInsets2 = windowInsets;
                            Object rememberedValue2 = composer3.rememberedValue();
                            if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue2 = (Function1) new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(WindowInsets windowInsets3) {
                                        invoke2(windowInsets3);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(WindowInsets windowInsets3) {
                                        MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(windowInsets2, windowInsets3));
                                    }
                                };
                                composer3.updateRememberedValue(rememberedValue2);
                            }
                            composer3.endReplaceableGroup();
                            Modifier onConsumedWindowInsetsChanged = WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(modifier4, (Function1) rememberedValue2);
                            long j202222 = j182222;
                            long j21 = j192222;
                            final boolean z8 = z72222;
                            final int i40 = i362222;
                            final Function2<? super Composer, ? super Integer, Unit> function215 = function25;
                            final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function39 = function33;
                            final Function2<? super Composer, ? super Integer, Unit> function216 = function2132222;
                            final MutableWindowInsets mutableWindowInsets3 = MutableWindowInsets.this;
                            final Function2<? super Composer, ? super Integer, Unit> function217 = function2122222;
                            final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function310 = function382222;
                            final ScaffoldState scaffoldState52222 = scaffoldState42222;
                            SurfaceKt.m1782SurfaceFjzlyU(onConsumedWindowInsetsChanged, null, j202222, j21, null, 0.0f, ComposableLambdaKt.composableLambda(composer3, 1772955108, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1.2
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

                                public final void invoke(Composer composer4, int i41) {
                                    ComposerKt.sourceInformation(composer4, "C218@10033L463:Scaffold.kt#jmzs0o");
                                    if ((i41 & 11) != 2 || !composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1772955108, i41, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous> (Scaffold.kt:218)");
                                        }
                                        boolean z9 = z8;
                                        int i42 = i40;
                                        Function2<Composer, Integer, Unit> function218 = function215;
                                        Function3<PaddingValues, Composer, Integer, Unit> function311 = function39;
                                        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function312 = function310;
                                        final ScaffoldState scaffoldState6 = scaffoldState52222;
                                        ScaffoldKt.m1750ScaffoldLayouti1QSOvI(z9, i42, function218, function311, ComposableLambdaKt.composableLambda(composer4, 433906483, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt.Scaffold.child.1.2.1
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

                                            public final void invoke(Composer composer5, int i43) {
                                                ComposerKt.sourceInformation(composer5, "C225@10336L45:Scaffold.kt#jmzs0o");
                                                if ((i43 & 11) == 2 && composer5.getSkipping()) {
                                                    composer5.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(433906483, i43, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:225)");
                                                }
                                                function312.invoke(scaffoldState6.getSnackbarHostState(), composer5, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }), function216, mutableWindowInsets3, function217, composer4, 24576);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            }), composer3, 1572864, 50);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                });
                if (function35 != null) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                function27 = function2142222;
                function28 = m1634getLambda4$material_release;
                z5 = z3;
                f2 = m1649getElevationD9Ej5fM;
                j13 = j8;
                j14 = j9;
                j15 = j12;
                j16 = j11;
                ScaffoldState scaffoldState52222 = scaffoldState2;
                shape6 = shape5;
                modifier3 = modifier2;
                z6 = z4;
                long j202222 = j7;
                function29 = function2122222;
                function36 = m1633getLambda3$material_release;
                i28 = m1680getEnd5ygKITE;
                scaffoldState3 = scaffoldState52222;
                function37 = function35;
                j17 = j202222;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i7 = i4 & 16;
            if (i7 != 0) {
            }
            i8 = i4 & 32;
            if (i8 != 0) {
            }
            i9 = i4 & 64;
            if (i9 != 0) {
            }
            i10 = i4 & 128;
            if (i10 != 0) {
            }
            i12 = i4 & 256;
            if (i12 != 0) {
            }
            i13 = i12;
            i14 = i4 & 512;
            if (i14 == 0) {
            }
            i15 = i14;
            i16 = i4 & 1024;
            if (i16 != 0) {
            }
            if ((i3 & 112) == 0) {
            }
            int i33222 = i18;
            i19 = i4 & 4096;
            if (i19 != 0) {
            }
            if ((i3 & 7168) != 0) {
            }
            if ((i3 & 57344) != 0) {
            }
            if ((i3 & 458752) == 0) {
            }
            if ((i3 & 3670016) == 0) {
            }
            if ((i3 & 29360128) != 0) {
            }
            if ((262144 & i4) == 0) {
            }
            if ((i5 & 1533916891) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i31 != 0) {
            }
            if ((i4 & 4) != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if (i13 != 0) {
            }
            if (i15 != 0) {
            }
            if (i17 != 0) {
            }
            Function2<? super Composer, ? super Integer, Unit> function21022222 = m1631getLambda1$material_release;
            Function2<? super Composer, ? super Integer, Unit> function21122222 = m1632getLambda2$material_release;
            if ((i4 & 2048) != 0) {
            }
            int i3422222 = i20;
            if (i22 != 0) {
            }
            if ((i4 & 8192) != 0) {
            }
            if ((i4 & 16384) != 0) {
            }
            if ((32768 & i4) != 0) {
            }
            if ((i4 & 65536) != 0) {
            }
            if ((i4 & 131072) != 0) {
            }
            startRestartGroup.endDefaults();
            final Function2<? super Composer, ? super Integer, Unit> function21222222 = function26;
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            changed = startRestartGroup.changed(windowInsets);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue = new MutableWindowInsets(windowInsets);
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceableGroup();
            final MutableWindowInsets mutableWindowInsets22222 = (MutableWindowInsets) rememberedValue;
            final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3822222 = m1633getLambda3$material_release;
            final Function2<? super Composer, ? super Integer, Unit> function21322222 = m1634getLambda4$material_release;
            final int i3622222 = m1680getEnd5ygKITE;
            final ScaffoldState scaffoldState422222 = scaffoldState2;
            final boolean z722222 = z3;
            final long j1822222 = j12;
            final long j1922222 = j11;
            Function2<? super Composer, ? super Integer, Unit> function21422222 = function25;
            int i3722222 = i27;
            final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> composableLambda22222 = ComposableLambdaKt.composableLambda(startRestartGroup, -219833176, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier4, Composer composer3, Integer num) {
                    invoke(modifier4, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Modifier modifier4, Composer composer3, int i382) {
                    int i39;
                    ComposerKt.sourceInformation(composer3, "C209@9601L905:Scaffold.kt#jmzs0o");
                    if ((i382 & 14) == 0) {
                        i39 = i382 | (composer3.changed(modifier4) ? 4 : 2);
                    } else {
                        i39 = i382;
                    }
                    if ((i39 & 91) != 18 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-219833176, i39, -1, "androidx.compose.material.Scaffold.<anonymous> (Scaffold.kt:209)");
                        }
                        composer3.startReplaceableGroup(-757570588);
                        boolean changed2 = composer3.changed(MutableWindowInsets.this) | composer3.changed(windowInsets);
                        final MutableWindowInsets mutableWindowInsets222222 = MutableWindowInsets.this;
                        final WindowInsets windowInsets2 = windowInsets;
                        Object rememberedValue2 = composer3.rememberedValue();
                        if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = (Function1) new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(WindowInsets windowInsets3) {
                                    invoke2(windowInsets3);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(WindowInsets windowInsets3) {
                                    MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(windowInsets2, windowInsets3));
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue2);
                        }
                        composer3.endReplaceableGroup();
                        Modifier onConsumedWindowInsetsChanged = WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(modifier4, (Function1) rememberedValue2);
                        long j2022222 = j1822222;
                        long j21 = j1922222;
                        final boolean z8 = z722222;
                        final int i40 = i3622222;
                        final Function2<? super Composer, ? super Integer, Unit> function215 = function25;
                        final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function39 = function33;
                        final Function2<? super Composer, ? super Integer, Unit> function216 = function21322222;
                        final MutableWindowInsets mutableWindowInsets3 = MutableWindowInsets.this;
                        final Function2<? super Composer, ? super Integer, Unit> function217 = function21222222;
                        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function310 = function3822222;
                        final ScaffoldState scaffoldState522222 = scaffoldState422222;
                        SurfaceKt.m1782SurfaceFjzlyU(onConsumedWindowInsetsChanged, null, j2022222, j21, null, 0.0f, ComposableLambdaKt.composableLambda(composer3, 1772955108, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1.2
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

                            public final void invoke(Composer composer4, int i41) {
                                ComposerKt.sourceInformation(composer4, "C218@10033L463:Scaffold.kt#jmzs0o");
                                if ((i41 & 11) != 2 || !composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1772955108, i41, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous> (Scaffold.kt:218)");
                                    }
                                    boolean z9 = z8;
                                    int i42 = i40;
                                    Function2<Composer, Integer, Unit> function218 = function215;
                                    Function3<PaddingValues, Composer, Integer, Unit> function311 = function39;
                                    final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function312 = function310;
                                    final ScaffoldState scaffoldState6 = scaffoldState522222;
                                    ScaffoldKt.m1750ScaffoldLayouti1QSOvI(z9, i42, function218, function311, ComposableLambdaKt.composableLambda(composer4, 433906483, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt.Scaffold.child.1.2.1
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

                                        public final void invoke(Composer composer5, int i43) {
                                            ComposerKt.sourceInformation(composer5, "C225@10336L45:Scaffold.kt#jmzs0o");
                                            if ((i43 & 11) == 2 && composer5.getSkipping()) {
                                                composer5.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(433906483, i43, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:225)");
                                            }
                                            function312.invoke(scaffoldState6.getSnackbarHostState(), composer5, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), function216, mutableWindowInsets3, function217, composer4, 24576);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer4.skipToGroupEnd();
                            }
                        }), composer3, 1572864, 50);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            });
            if (function35 != null) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            function27 = function21422222;
            function28 = m1634getLambda4$material_release;
            z5 = z3;
            f2 = m1649getElevationD9Ej5fM;
            j13 = j8;
            j14 = j9;
            j15 = j12;
            j16 = j11;
            ScaffoldState scaffoldState522222 = scaffoldState2;
            shape6 = shape5;
            modifier3 = modifier2;
            z6 = z4;
            long j2022222 = j7;
            function29 = function21222222;
            function36 = m1633getLambda3$material_release;
            i28 = m1680getEnd5ygKITE;
            scaffoldState3 = scaffoldState522222;
            function37 = function35;
            j17 = j2022222;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i2 & 896) != 0) {
        }
        i6 = i4 & 8;
        int i322 = 1024;
        if (i6 == 0) {
        }
        i7 = i4 & 16;
        if (i7 != 0) {
        }
        i8 = i4 & 32;
        if (i8 != 0) {
        }
        i9 = i4 & 64;
        if (i9 != 0) {
        }
        i10 = i4 & 128;
        if (i10 != 0) {
        }
        i12 = i4 & 256;
        if (i12 != 0) {
        }
        i13 = i12;
        i14 = i4 & 512;
        if (i14 == 0) {
        }
        i15 = i14;
        i16 = i4 & 1024;
        if (i16 != 0) {
        }
        if ((i3 & 112) == 0) {
        }
        int i332222 = i18;
        i19 = i4 & 4096;
        if (i19 != 0) {
        }
        if ((i3 & 7168) != 0) {
        }
        if ((i3 & 57344) != 0) {
        }
        if ((i3 & 458752) == 0) {
        }
        if ((i3 & 3670016) == 0) {
        }
        if ((i3 & 29360128) != 0) {
        }
        if ((262144 & i4) == 0) {
        }
        if ((i5 & 1533916891) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i31 != 0) {
        }
        if ((i4 & 4) != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if (i13 != 0) {
        }
        if (i15 != 0) {
        }
        if (i17 != 0) {
        }
        Function2<? super Composer, ? super Integer, Unit> function210222222 = m1631getLambda1$material_release;
        Function2<? super Composer, ? super Integer, Unit> function211222222 = m1632getLambda2$material_release;
        if ((i4 & 2048) != 0) {
        }
        int i34222222 = i20;
        if (i22 != 0) {
        }
        if ((i4 & 8192) != 0) {
        }
        if ((i4 & 16384) != 0) {
        }
        if ((32768 & i4) != 0) {
        }
        if ((i4 & 65536) != 0) {
        }
        if ((i4 & 131072) != 0) {
        }
        startRestartGroup.endDefaults();
        final Function2<? super Composer, ? super Integer, Unit> function212222222 = function26;
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
        changed = startRestartGroup.changed(windowInsets);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue = new MutableWindowInsets(windowInsets);
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceableGroup();
        final MutableWindowInsets mutableWindowInsets222222 = (MutableWindowInsets) rememberedValue;
        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function38222222 = m1633getLambda3$material_release;
        final Function2<? super Composer, ? super Integer, Unit> function213222222 = m1634getLambda4$material_release;
        final int i36222222 = m1680getEnd5ygKITE;
        final ScaffoldState scaffoldState4222222 = scaffoldState2;
        final boolean z7222222 = z3;
        final long j18222222 = j12;
        final long j19222222 = j11;
        Function2<? super Composer, ? super Integer, Unit> function214222222 = function25;
        int i37222222 = i27;
        final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> composableLambda222222 = ComposableLambdaKt.composableLambda(startRestartGroup, -219833176, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier4, Composer composer3, Integer num) {
                invoke(modifier4, composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Modifier modifier4, Composer composer3, int i382) {
                int i39;
                ComposerKt.sourceInformation(composer3, "C209@9601L905:Scaffold.kt#jmzs0o");
                if ((i382 & 14) == 0) {
                    i39 = i382 | (composer3.changed(modifier4) ? 4 : 2);
                } else {
                    i39 = i382;
                }
                if ((i39 & 91) != 18 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-219833176, i39, -1, "androidx.compose.material.Scaffold.<anonymous> (Scaffold.kt:209)");
                    }
                    composer3.startReplaceableGroup(-757570588);
                    boolean changed2 = composer3.changed(MutableWindowInsets.this) | composer3.changed(windowInsets);
                    final MutableWindowInsets mutableWindowInsets2222222 = MutableWindowInsets.this;
                    final WindowInsets windowInsets2 = windowInsets;
                    Object rememberedValue2 = composer3.rememberedValue();
                    if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = (Function1) new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(WindowInsets windowInsets3) {
                                invoke2(windowInsets3);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(WindowInsets windowInsets3) {
                                MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(windowInsets2, windowInsets3));
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue2);
                    }
                    composer3.endReplaceableGroup();
                    Modifier onConsumedWindowInsetsChanged = WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(modifier4, (Function1) rememberedValue2);
                    long j20222222 = j18222222;
                    long j21 = j19222222;
                    final boolean z8 = z7222222;
                    final int i40 = i36222222;
                    final Function2<? super Composer, ? super Integer, Unit> function215 = function25;
                    final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function39 = function33;
                    final Function2<? super Composer, ? super Integer, Unit> function216 = function213222222;
                    final MutableWindowInsets mutableWindowInsets3 = MutableWindowInsets.this;
                    final Function2<? super Composer, ? super Integer, Unit> function217 = function212222222;
                    final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function310 = function38222222;
                    final ScaffoldState scaffoldState5222222 = scaffoldState4222222;
                    SurfaceKt.m1782SurfaceFjzlyU(onConsumedWindowInsetsChanged, null, j20222222, j21, null, 0.0f, ComposableLambdaKt.composableLambda(composer3, 1772955108, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1.2
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

                        public final void invoke(Composer composer4, int i41) {
                            ComposerKt.sourceInformation(composer4, "C218@10033L463:Scaffold.kt#jmzs0o");
                            if ((i41 & 11) != 2 || !composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1772955108, i41, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous> (Scaffold.kt:218)");
                                }
                                boolean z9 = z8;
                                int i42 = i40;
                                Function2<Composer, Integer, Unit> function218 = function215;
                                Function3<PaddingValues, Composer, Integer, Unit> function311 = function39;
                                final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function312 = function310;
                                final ScaffoldState scaffoldState6 = scaffoldState5222222;
                                ScaffoldKt.m1750ScaffoldLayouti1QSOvI(z9, i42, function218, function311, ComposableLambdaKt.composableLambda(composer4, 433906483, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt.Scaffold.child.1.2.1
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

                                    public final void invoke(Composer composer5, int i43) {
                                        ComposerKt.sourceInformation(composer5, "C225@10336L45:Scaffold.kt#jmzs0o");
                                        if ((i43 & 11) == 2 && composer5.getSkipping()) {
                                            composer5.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(433906483, i43, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:225)");
                                        }
                                        function312.invoke(scaffoldState6.getSnackbarHostState(), composer5, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), function216, mutableWindowInsets3, function217, composer4, 24576);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer4.skipToGroupEnd();
                        }
                    }), composer3, 1572864, 50);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        });
        if (function35 != null) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        function27 = function214222222;
        function28 = m1634getLambda4$material_release;
        z5 = z3;
        f2 = m1649getElevationD9Ej5fM;
        j13 = j8;
        j14 = j9;
        j15 = j12;
        j16 = j11;
        ScaffoldState scaffoldState5222222 = scaffoldState2;
        shape6 = shape5;
        modifier3 = modifier2;
        z6 = z4;
        long j20222222 = j7;
        function29 = function212222222;
        function36 = m1633getLambda3$material_release;
        i28 = m1680getEnd5ygKITE;
        scaffoldState3 = scaffoldState5222222;
        function37 = function35;
        j17 = j20222222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x01c7, code lost:
    
        if (r3.changed(r56) == false) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01e1, code lost:
    
        if (r3.changed(r58) == false) goto L159;
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x04a3  */
    /* JADX WARN: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0420  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0483  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x042b  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0372  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x024b  */
    /* renamed from: Scaffold-27mzLpw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1748Scaffold27mzLpw(Modifier modifier, ScaffoldState scaffoldState, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function23, int i, boolean z, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32, boolean z2, Shape shape, float f, long j, long j2, long j3, long j4, long j5, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function33, Composer composer, final int i2, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        ScaffoldState scaffoldState2;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i6;
        int i7;
        Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function34;
        int i8;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int i9;
        int i10;
        int i11;
        boolean z3;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        long j6;
        CornerBasedShape cornerBasedShape;
        float m1649getElevationD9Ej5fM;
        Function2<? super Composer, ? super Integer, Unit> function26;
        int i20;
        long j7;
        long j8;
        int i21;
        int i22;
        long j9;
        int i23;
        long j10;
        Shape shape2;
        Modifier modifier3;
        Function2<? super Composer, ? super Integer, Unit> function27;
        Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function35;
        ScaffoldState scaffoldState3;
        long j11;
        int i24;
        int i25;
        int i26;
        Function2<? super Composer, ? super Integer, Unit> function28;
        long j12;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function36;
        boolean z4;
        boolean z5;
        int i27;
        long j13;
        long j14;
        int i28;
        Composer composer2;
        final Modifier modifier4;
        final ScaffoldState scaffoldState4;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function37;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final int i29;
        final boolean z6;
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function38;
        final boolean z7;
        final Shape shape3;
        final float f2;
        final long j15;
        final long j16;
        final long j17;
        final long j18;
        final long j19;
        ScopeUpdateScope endRestartGroup;
        int i30;
        int i31;
        Composer startRestartGroup = composer.startRestartGroup(1037492569);
        ComposerKt.sourceInformation(startRestartGroup, "C(Scaffold)P(14,15,17,1,16,11,12:c#material.FabPosition,13,5,8,10,7:c#ui.unit.Dp,4:c#ui.graphics.Color,6:c#ui.graphics.Color,9:c#ui.graphics.Color,0:c#ui.graphics.Color,3:c#ui.graphics.Color)315@14928L23,324@15438L6,326@15553L6,327@15601L38,328@15686L10,329@15741L6,330@15786L32,333@15877L495:Scaffold.kt#jmzs0o");
        int i32 = i4 & 1;
        if (i32 != 0) {
            i5 = i2 | 6;
            modifier2 = modifier;
        } else if ((i2 & 14) == 0) {
            modifier2 = modifier;
            i5 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i2;
        } else {
            modifier2 = modifier;
            i5 = i2;
        }
        if ((i2 & 112) == 0) {
            if ((i4 & 2) == 0) {
                scaffoldState2 = scaffoldState;
                if (startRestartGroup.changed(scaffoldState2)) {
                    i31 = 32;
                    i5 |= i31;
                }
            } else {
                scaffoldState2 = scaffoldState;
            }
            i31 = 16;
            i5 |= i31;
        } else {
            scaffoldState2 = scaffoldState;
        }
        int i33 = i4 & 4;
        if (i33 != 0) {
            i5 |= 384;
        } else if ((i2 & 896) == 0) {
            function24 = function2;
            i5 |= startRestartGroup.changedInstance(function24) ? 256 : 128;
            i6 = i4 & 8;
            int i34 = 2048;
            if (i6 == 0) {
                i5 |= 3072;
            } else if ((i2 & 7168) == 0) {
                i5 |= startRestartGroup.changedInstance(function22) ? 2048 : 1024;
                i7 = i4 & 16;
                int i35 = 16384;
                if (i7 != 0) {
                    i5 |= 24576;
                    function34 = function3;
                } else {
                    function34 = function3;
                    if ((i2 & 57344) == 0) {
                        i5 |= startRestartGroup.changedInstance(function34) ? 16384 : 8192;
                    }
                }
                i8 = i4 & 32;
                if (i8 != 0) {
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    function25 = function23;
                } else {
                    function25 = function23;
                    if ((i2 & 458752) == 0) {
                        i5 |= startRestartGroup.changedInstance(function25) ? 131072 : 65536;
                    }
                }
                i9 = i4 & 64;
                if (i9 != 0) {
                    i5 |= 1572864;
                    i10 = i;
                } else {
                    i10 = i;
                    if ((i2 & 3670016) == 0) {
                        i5 |= startRestartGroup.changed(i10) ? 1048576 : 524288;
                    }
                }
                i11 = i4 & 128;
                if (i11 != 0) {
                    i5 |= 12582912;
                    z3 = z;
                } else {
                    z3 = z;
                    if ((i2 & 29360128) == 0) {
                        i5 |= startRestartGroup.changed(z3) ? 8388608 : 4194304;
                    }
                }
                i12 = i4 & 256;
                if (i12 != 0) {
                    i5 |= 100663296;
                } else if ((i2 & 234881024) == 0) {
                    i13 = i12;
                    i5 |= startRestartGroup.changedInstance(function32) ? 67108864 : 33554432;
                    i14 = i4 & 512;
                    if (i14 == 0) {
                        i5 |= C.ENCODING_PCM_32BIT;
                    } else if ((i2 & 1879048192) == 0) {
                        i15 = i14;
                        i5 |= startRestartGroup.changed(z2) ? 536870912 : 268435456;
                        if ((i3 & 14) == 0) {
                            if ((i4 & 1024) == 0 && startRestartGroup.changed(shape)) {
                                i30 = 4;
                                i16 = i3 | i30;
                            }
                            i30 = 2;
                            i16 = i3 | i30;
                        } else {
                            i16 = i3;
                        }
                        i17 = i4 & 2048;
                        if (i17 != 0) {
                            i16 |= 48;
                        } else if ((i3 & 112) == 0) {
                            i18 = i17;
                            i16 |= startRestartGroup.changed(f) ? 32 : 16;
                            if ((i3 & 896) != 0) {
                                i19 = i32;
                                j6 = j;
                                i16 |= ((i4 & 4096) == 0 && startRestartGroup.changed(j6)) ? 256 : 128;
                            } else {
                                i19 = i32;
                                j6 = j;
                            }
                            if ((i3 & 7168) == 0) {
                                if ((i4 & 8192) != 0) {
                                }
                                i34 = 1024;
                                i16 |= i34;
                            }
                            if ((i3 & 57344) == 0) {
                                if ((i4 & 16384) != 0) {
                                }
                                i35 = 8192;
                                i16 |= i35;
                            }
                            if ((i3 & 458752) == 0) {
                                i16 |= ((i4 & 32768) == 0 && startRestartGroup.changed(j4)) ? 131072 : 65536;
                            }
                            if ((i3 & 3670016) == 0) {
                                i16 |= ((i4 & 65536) == 0 && startRestartGroup.changed(j5)) ? 1048576 : 524288;
                            }
                            if ((i4 & 131072) == 0) {
                                i16 |= 12582912;
                            } else if ((i3 & 29360128) == 0) {
                                i16 |= startRestartGroup.changedInstance(function33) ? 8388608 : 4194304;
                            }
                            if ((1533916891 & i5) == 306783378 || (i16 & 23967451) != 4793490 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    if (i19 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if ((i4 & 2) != 0) {
                                        i5 &= -113;
                                        scaffoldState2 = rememberScaffoldState(null, null, startRestartGroup, 0, 3);
                                    }
                                    if (i33 != 0) {
                                        function24 = ComposableSingletons$ScaffoldKt.INSTANCE.m1635getLambda5$material_release();
                                    }
                                    Function2<? super Composer, ? super Integer, Unit> m1636getLambda6$material_release = i6 == 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m1636getLambda6$material_release() : function22;
                                    if (i7 != 0) {
                                        function34 = ComposableSingletons$ScaffoldKt.INSTANCE.m1637getLambda7$material_release();
                                    }
                                    if (i8 != 0) {
                                        function25 = ComposableSingletons$ScaffoldKt.INSTANCE.m1638getLambda8$material_release();
                                    }
                                    if (i9 != 0) {
                                        i10 = FabPosition.INSTANCE.m1680getEnd5ygKITE();
                                    }
                                    if (i11 != 0) {
                                        z3 = false;
                                    }
                                    Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function39 = i13 == 0 ? null : function32;
                                    boolean z8 = i15 == 0 ? true : z2;
                                    if ((i4 & 1024) == 0) {
                                        cornerBasedShape = MaterialTheme.INSTANCE.getShapes(startRestartGroup, 6).getLarge();
                                        i16 &= -15;
                                    } else {
                                        cornerBasedShape = shape;
                                    }
                                    int i36 = i16;
                                    m1649getElevationD9Ej5fM = i18 == 0 ? DrawerDefaults.INSTANCE.m1649getElevationD9Ej5fM() : f;
                                    if ((i4 & 4096) == 0) {
                                        function26 = m1636getLambda6$material_release;
                                        i20 = i36 & (-897);
                                        j7 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m1607getSurface0d7_KjU();
                                    } else {
                                        function26 = m1636getLambda6$material_release;
                                        i20 = i36;
                                        j7 = j;
                                    }
                                    Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function310 = function39;
                                    if ((i4 & 8192) == 0) {
                                        j8 = ColorsKt.m1621contentColorForek8zF_U(j7, startRestartGroup, (i20 >> 6) & 14);
                                        i20 &= -7169;
                                    } else {
                                        j8 = j2;
                                    }
                                    if ((i4 & 16384) == 0) {
                                        int i37 = i20;
                                        i21 = 6;
                                        j9 = DrawerDefaults.INSTANCE.getScrimColor(startRestartGroup, 6);
                                        i22 = i37 & (-57345);
                                    } else {
                                        int i38 = i20;
                                        i21 = 6;
                                        i22 = i38;
                                        j9 = j3;
                                    }
                                    int i39 = i22;
                                    if ((i4 & 32768) == 0) {
                                        j10 = MaterialTheme.INSTANCE.getColors(startRestartGroup, i21).m1596getBackground0d7_KjU();
                                        i23 = i39 & (-458753);
                                    } else {
                                        i23 = i39;
                                        j10 = j4;
                                    }
                                    if ((i4 & 65536) == 0) {
                                        long m1621contentColorForek8zF_U = ColorsKt.m1621contentColorForek8zF_U(j10, startRestartGroup, (i23 >> 15) & 14);
                                        long j20 = j10;
                                        i25 = i23 & (-3670017);
                                        i26 = 458752;
                                        j12 = m1621contentColorForek8zF_U;
                                        j11 = j20;
                                        boolean z9 = z3;
                                        z5 = z8;
                                        i27 = 57344;
                                        j13 = j8;
                                        j14 = j7;
                                        z4 = z9;
                                        Function2<? super Composer, ? super Integer, Unit> function212 = function24;
                                        shape2 = cornerBasedShape;
                                        modifier3 = modifier2;
                                        function27 = function212;
                                        ScaffoldState scaffoldState5 = scaffoldState2;
                                        function35 = function34;
                                        scaffoldState3 = scaffoldState5;
                                        function36 = function310;
                                        i24 = i5;
                                        function28 = function26;
                                    } else {
                                        Function2<? super Composer, ? super Integer, Unit> function213 = function24;
                                        shape2 = cornerBasedShape;
                                        modifier3 = modifier2;
                                        function27 = function213;
                                        ScaffoldState scaffoldState6 = scaffoldState2;
                                        function35 = function34;
                                        scaffoldState3 = scaffoldState6;
                                        j11 = j10;
                                        i24 = i5;
                                        i25 = i23;
                                        i26 = 458752;
                                        function28 = function26;
                                        j12 = j5;
                                        long j21 = j7;
                                        function36 = function310;
                                        z4 = z3;
                                        z5 = z8;
                                        i27 = 57344;
                                        j13 = j8;
                                        j14 = j21;
                                    }
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i4 & 2) != 0) {
                                        i5 &= -113;
                                    }
                                    if ((i4 & 1024) != 0) {
                                        i16 &= -15;
                                    }
                                    i25 = i16;
                                    if ((i4 & 4096) != 0) {
                                        i25 &= -897;
                                    }
                                    if ((i4 & 8192) != 0) {
                                        i25 &= -7169;
                                    }
                                    if ((i4 & 16384) != 0) {
                                        i25 &= -57345;
                                    }
                                    if ((32768 & i4) != 0) {
                                        i25 &= -458753;
                                    }
                                    if ((i4 & 65536) != 0) {
                                        i25 &= -3670017;
                                    }
                                    ScaffoldState scaffoldState7 = scaffoldState2;
                                    function35 = function34;
                                    scaffoldState3 = scaffoldState7;
                                    function36 = function32;
                                    m1649getElevationD9Ej5fM = f;
                                    j9 = j3;
                                    j11 = j4;
                                    j14 = j6;
                                    modifier3 = modifier2;
                                    i24 = i5;
                                    z4 = z3;
                                    function27 = function24;
                                    i27 = 57344;
                                    i26 = 458752;
                                    function28 = function22;
                                    z5 = z2;
                                    shape2 = shape;
                                    j13 = j2;
                                    j12 = j5;
                                }
                                startRestartGroup.endDefaults();
                                int i40 = i26;
                                if (ComposerKt.isTraceInProgress()) {
                                    i28 = i27;
                                } else {
                                    i28 = i27;
                                    ComposerKt.traceEventStart(1037492569, i24, i25, "androidx.compose.material.Scaffold (Scaffold.kt:332)");
                                }
                                int i41 = i25 << 3;
                                composer2 = startRestartGroup;
                                m1749Scaffoldu4IkXBM(WindowInsetsKt.m953WindowInsetsa9UjIt4$default(Dp.m6389constructorimpl(0), 0.0f, 0.0f, 0.0f, 14, null), modifier3, scaffoldState3, function27, function28, function35, function25, i10, z4, function36, z5, shape2, m1649getElevationD9Ej5fM, j14, j13, j9, j11, j12, function33, composer2, (i24 << 3) & 2147483632, ((i24 >> 27) & 14) | (i41 & 112) | (i41 & 896) | (i41 & 7168) | (i41 & i28) | (i41 & i40) | (i41 & 3670016) | (i41 & 29360128) | (i41 & 234881024), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier4 = modifier3;
                                scaffoldState4 = scaffoldState3;
                                function29 = function27;
                                function210 = function28;
                                function37 = function35;
                                function211 = function25;
                                i29 = i10;
                                z6 = z4;
                                function38 = function36;
                                z7 = z5;
                                shape3 = shape2;
                                f2 = m1649getElevationD9Ej5fM;
                                j15 = j14;
                                j16 = j13;
                                j17 = j9;
                                j18 = j11;
                                j19 = j12;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                f2 = f;
                                j17 = j3;
                                j18 = j4;
                                j19 = j5;
                                composer2 = startRestartGroup;
                                modifier4 = modifier2;
                                scaffoldState4 = scaffoldState2;
                                i29 = i10;
                                z6 = z3;
                                function29 = function24;
                                function38 = function32;
                                shape3 = shape;
                                j16 = j2;
                                j15 = j6;
                                function37 = function34;
                                function211 = function25;
                                function210 = function22;
                                z7 = z2;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$3
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

                                    public final void invoke(Composer composer3, int i42) {
                                        ScaffoldKt.m1748Scaffold27mzLpw(Modifier.this, scaffoldState4, function29, function210, function37, function211, i29, z6, function38, z7, shape3, f2, j15, j16, j17, j18, j19, function33, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i18 = i17;
                        if ((i3 & 896) != 0) {
                        }
                        if ((i3 & 7168) == 0) {
                        }
                        if ((i3 & 57344) == 0) {
                        }
                        if ((i3 & 458752) == 0) {
                        }
                        if ((i3 & 3670016) == 0) {
                        }
                        if ((i4 & 131072) == 0) {
                        }
                        if ((1533916891 & i5) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                        }
                        if (i19 != 0) {
                        }
                        if ((i4 & 2) != 0) {
                        }
                        if (i33 != 0) {
                        }
                        if (i6 == 0) {
                        }
                        if (i7 != 0) {
                        }
                        if (i8 != 0) {
                        }
                        if (i9 != 0) {
                        }
                        if (i11 != 0) {
                        }
                        if (i13 == 0) {
                        }
                        if (i15 == 0) {
                        }
                        if ((i4 & 1024) == 0) {
                        }
                        int i362 = i16;
                        if (i18 == 0) {
                        }
                        if ((i4 & 4096) == 0) {
                        }
                        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3102 = function39;
                        if ((i4 & 8192) == 0) {
                        }
                        if ((i4 & 16384) == 0) {
                        }
                        int i392 = i22;
                        if ((i4 & 32768) == 0) {
                        }
                        if ((i4 & 65536) == 0) {
                        }
                        startRestartGroup.endDefaults();
                        int i402 = i26;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i412 = i25 << 3;
                        composer2 = startRestartGroup;
                        m1749Scaffoldu4IkXBM(WindowInsetsKt.m953WindowInsetsa9UjIt4$default(Dp.m6389constructorimpl(0), 0.0f, 0.0f, 0.0f, 14, null), modifier3, scaffoldState3, function27, function28, function35, function25, i10, z4, function36, z5, shape2, m1649getElevationD9Ej5fM, j14, j13, j9, j11, j12, function33, composer2, (i24 << 3) & 2147483632, ((i24 >> 27) & 14) | (i412 & 112) | (i412 & 896) | (i412 & 7168) | (i412 & i28) | (i412 & i402) | (i412 & 3670016) | (i412 & 29360128) | (i412 & 234881024), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier4 = modifier3;
                        scaffoldState4 = scaffoldState3;
                        function29 = function27;
                        function210 = function28;
                        function37 = function35;
                        function211 = function25;
                        i29 = i10;
                        z6 = z4;
                        function38 = function36;
                        z7 = z5;
                        shape3 = shape2;
                        f2 = m1649getElevationD9Ej5fM;
                        j15 = j14;
                        j16 = j13;
                        j17 = j9;
                        j18 = j11;
                        j19 = j12;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i15 = i14;
                    if ((i3 & 14) == 0) {
                    }
                    i17 = i4 & 2048;
                    if (i17 != 0) {
                    }
                    i18 = i17;
                    if ((i3 & 896) != 0) {
                    }
                    if ((i3 & 7168) == 0) {
                    }
                    if ((i3 & 57344) == 0) {
                    }
                    if ((i3 & 458752) == 0) {
                    }
                    if ((i3 & 3670016) == 0) {
                    }
                    if ((i4 & 131072) == 0) {
                    }
                    if ((1533916891 & i5) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                    }
                    if (i19 != 0) {
                    }
                    if ((i4 & 2) != 0) {
                    }
                    if (i33 != 0) {
                    }
                    if (i6 == 0) {
                    }
                    if (i7 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i13 == 0) {
                    }
                    if (i15 == 0) {
                    }
                    if ((i4 & 1024) == 0) {
                    }
                    int i3622 = i16;
                    if (i18 == 0) {
                    }
                    if ((i4 & 4096) == 0) {
                    }
                    Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function31022 = function39;
                    if ((i4 & 8192) == 0) {
                    }
                    if ((i4 & 16384) == 0) {
                    }
                    int i3922 = i22;
                    if ((i4 & 32768) == 0) {
                    }
                    if ((i4 & 65536) == 0) {
                    }
                    startRestartGroup.endDefaults();
                    int i4022 = i26;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i4122 = i25 << 3;
                    composer2 = startRestartGroup;
                    m1749Scaffoldu4IkXBM(WindowInsetsKt.m953WindowInsetsa9UjIt4$default(Dp.m6389constructorimpl(0), 0.0f, 0.0f, 0.0f, 14, null), modifier3, scaffoldState3, function27, function28, function35, function25, i10, z4, function36, z5, shape2, m1649getElevationD9Ej5fM, j14, j13, j9, j11, j12, function33, composer2, (i24 << 3) & 2147483632, ((i24 >> 27) & 14) | (i4122 & 112) | (i4122 & 896) | (i4122 & 7168) | (i4122 & i28) | (i4122 & i4022) | (i4122 & 3670016) | (i4122 & 29360128) | (i4122 & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier4 = modifier3;
                    scaffoldState4 = scaffoldState3;
                    function29 = function27;
                    function210 = function28;
                    function37 = function35;
                    function211 = function25;
                    i29 = i10;
                    z6 = z4;
                    function38 = function36;
                    z7 = z5;
                    shape3 = shape2;
                    f2 = m1649getElevationD9Ej5fM;
                    j15 = j14;
                    j16 = j13;
                    j17 = j9;
                    j18 = j11;
                    j19 = j12;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                i13 = i12;
                i14 = i4 & 512;
                if (i14 == 0) {
                }
                i15 = i14;
                if ((i3 & 14) == 0) {
                }
                i17 = i4 & 2048;
                if (i17 != 0) {
                }
                i18 = i17;
                if ((i3 & 896) != 0) {
                }
                if ((i3 & 7168) == 0) {
                }
                if ((i3 & 57344) == 0) {
                }
                if ((i3 & 458752) == 0) {
                }
                if ((i3 & 3670016) == 0) {
                }
                if ((i4 & 131072) == 0) {
                }
                if ((1533916891 & i5) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i19 != 0) {
                }
                if ((i4 & 2) != 0) {
                }
                if (i33 != 0) {
                }
                if (i6 == 0) {
                }
                if (i7 != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if (i11 != 0) {
                }
                if (i13 == 0) {
                }
                if (i15 == 0) {
                }
                if ((i4 & 1024) == 0) {
                }
                int i36222 = i16;
                if (i18 == 0) {
                }
                if ((i4 & 4096) == 0) {
                }
                Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function310222 = function39;
                if ((i4 & 8192) == 0) {
                }
                if ((i4 & 16384) == 0) {
                }
                int i39222 = i22;
                if ((i4 & 32768) == 0) {
                }
                if ((i4 & 65536) == 0) {
                }
                startRestartGroup.endDefaults();
                int i40222 = i26;
                if (ComposerKt.isTraceInProgress()) {
                }
                int i41222 = i25 << 3;
                composer2 = startRestartGroup;
                m1749Scaffoldu4IkXBM(WindowInsetsKt.m953WindowInsetsa9UjIt4$default(Dp.m6389constructorimpl(0), 0.0f, 0.0f, 0.0f, 14, null), modifier3, scaffoldState3, function27, function28, function35, function25, i10, z4, function36, z5, shape2, m1649getElevationD9Ej5fM, j14, j13, j9, j11, j12, function33, composer2, (i24 << 3) & 2147483632, ((i24 >> 27) & 14) | (i41222 & 112) | (i41222 & 896) | (i41222 & 7168) | (i41222 & i28) | (i41222 & i40222) | (i41222 & 3670016) | (i41222 & 29360128) | (i41222 & 234881024), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier4 = modifier3;
                scaffoldState4 = scaffoldState3;
                function29 = function27;
                function210 = function28;
                function37 = function35;
                function211 = function25;
                i29 = i10;
                z6 = z4;
                function38 = function36;
                z7 = z5;
                shape3 = shape2;
                f2 = m1649getElevationD9Ej5fM;
                j15 = j14;
                j16 = j13;
                j17 = j9;
                j18 = j11;
                j19 = j12;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i7 = i4 & 16;
            int i352 = 16384;
            if (i7 != 0) {
            }
            i8 = i4 & 32;
            if (i8 != 0) {
            }
            i9 = i4 & 64;
            if (i9 != 0) {
            }
            i11 = i4 & 128;
            if (i11 != 0) {
            }
            i12 = i4 & 256;
            if (i12 != 0) {
            }
            i13 = i12;
            i14 = i4 & 512;
            if (i14 == 0) {
            }
            i15 = i14;
            if ((i3 & 14) == 0) {
            }
            i17 = i4 & 2048;
            if (i17 != 0) {
            }
            i18 = i17;
            if ((i3 & 896) != 0) {
            }
            if ((i3 & 7168) == 0) {
            }
            if ((i3 & 57344) == 0) {
            }
            if ((i3 & 458752) == 0) {
            }
            if ((i3 & 3670016) == 0) {
            }
            if ((i4 & 131072) == 0) {
            }
            if ((1533916891 & i5) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i19 != 0) {
            }
            if ((i4 & 2) != 0) {
            }
            if (i33 != 0) {
            }
            if (i6 == 0) {
            }
            if (i7 != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if (i11 != 0) {
            }
            if (i13 == 0) {
            }
            if (i15 == 0) {
            }
            if ((i4 & 1024) == 0) {
            }
            int i362222 = i16;
            if (i18 == 0) {
            }
            if ((i4 & 4096) == 0) {
            }
            Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3102222 = function39;
            if ((i4 & 8192) == 0) {
            }
            if ((i4 & 16384) == 0) {
            }
            int i392222 = i22;
            if ((i4 & 32768) == 0) {
            }
            if ((i4 & 65536) == 0) {
            }
            startRestartGroup.endDefaults();
            int i402222 = i26;
            if (ComposerKt.isTraceInProgress()) {
            }
            int i412222 = i25 << 3;
            composer2 = startRestartGroup;
            m1749Scaffoldu4IkXBM(WindowInsetsKt.m953WindowInsetsa9UjIt4$default(Dp.m6389constructorimpl(0), 0.0f, 0.0f, 0.0f, 14, null), modifier3, scaffoldState3, function27, function28, function35, function25, i10, z4, function36, z5, shape2, m1649getElevationD9Ej5fM, j14, j13, j9, j11, j12, function33, composer2, (i24 << 3) & 2147483632, ((i24 >> 27) & 14) | (i412222 & 112) | (i412222 & 896) | (i412222 & 7168) | (i412222 & i28) | (i412222 & i402222) | (i412222 & 3670016) | (i412222 & 29360128) | (i412222 & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier4 = modifier3;
            scaffoldState4 = scaffoldState3;
            function29 = function27;
            function210 = function28;
            function37 = function35;
            function211 = function25;
            i29 = i10;
            z6 = z4;
            function38 = function36;
            z7 = z5;
            shape3 = shape2;
            f2 = m1649getElevationD9Ej5fM;
            j15 = j14;
            j16 = j13;
            j17 = j9;
            j18 = j11;
            j19 = j12;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        function24 = function2;
        i6 = i4 & 8;
        int i342 = 2048;
        if (i6 == 0) {
        }
        i7 = i4 & 16;
        int i3522 = 16384;
        if (i7 != 0) {
        }
        i8 = i4 & 32;
        if (i8 != 0) {
        }
        i9 = i4 & 64;
        if (i9 != 0) {
        }
        i11 = i4 & 128;
        if (i11 != 0) {
        }
        i12 = i4 & 256;
        if (i12 != 0) {
        }
        i13 = i12;
        i14 = i4 & 512;
        if (i14 == 0) {
        }
        i15 = i14;
        if ((i3 & 14) == 0) {
        }
        i17 = i4 & 2048;
        if (i17 != 0) {
        }
        i18 = i17;
        if ((i3 & 896) != 0) {
        }
        if ((i3 & 7168) == 0) {
        }
        if ((i3 & 57344) == 0) {
        }
        if ((i3 & 458752) == 0) {
        }
        if ((i3 & 3670016) == 0) {
        }
        if ((i4 & 131072) == 0) {
        }
        if ((1533916891 & i5) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i19 != 0) {
        }
        if ((i4 & 2) != 0) {
        }
        if (i33 != 0) {
        }
        if (i6 == 0) {
        }
        if (i7 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (i11 != 0) {
        }
        if (i13 == 0) {
        }
        if (i15 == 0) {
        }
        if ((i4 & 1024) == 0) {
        }
        int i3622222 = i16;
        if (i18 == 0) {
        }
        if ((i4 & 4096) == 0) {
        }
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function31022222 = function39;
        if ((i4 & 8192) == 0) {
        }
        if ((i4 & 16384) == 0) {
        }
        int i3922222 = i22;
        if ((i4 & 32768) == 0) {
        }
        if ((i4 & 65536) == 0) {
        }
        startRestartGroup.endDefaults();
        int i4022222 = i26;
        if (ComposerKt.isTraceInProgress()) {
        }
        int i4122222 = i25 << 3;
        composer2 = startRestartGroup;
        m1749Scaffoldu4IkXBM(WindowInsetsKt.m953WindowInsetsa9UjIt4$default(Dp.m6389constructorimpl(0), 0.0f, 0.0f, 0.0f, 14, null), modifier3, scaffoldState3, function27, function28, function35, function25, i10, z4, function36, z5, shape2, m1649getElevationD9Ej5fM, j14, j13, j9, j11, j12, function33, composer2, (i24 << 3) & 2147483632, ((i24 >> 27) & 14) | (i4122222 & 112) | (i4122222 & 896) | (i4122222 & 7168) | (i4122222 & i28) | (i4122222 & i4022222) | (i4122222 & 3670016) | (i4122222 & 29360128) | (i4122222 & 234881024), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        scaffoldState4 = scaffoldState3;
        function29 = function27;
        function210 = function28;
        function37 = function35;
        function211 = function25;
        i29 = i10;
        z6 = z4;
        function38 = function36;
        z7 = z5;
        shape3 = shape2;
        f2 = m1649getElevationD9Ej5fM;
        j15 = j14;
        j16 = j13;
        j17 = j9;
        j18 = j11;
        j19 = j12;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean getScaffoldSubcomposeInMeasureFix() {
        return ((Boolean) ScaffoldSubcomposeInMeasureFix$delegate.getValue()).booleanValue();
    }

    public static final void setScaffoldSubcomposeInMeasureFix(boolean z) {
        ScaffoldSubcomposeInMeasureFix$delegate.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ScaffoldLayout-i1QSOvI, reason: not valid java name */
    public static final void m1750ScaffoldLayouti1QSOvI(final boolean z, final int i, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final WindowInsets windowInsets, final Function2<? super Composer, ? super Integer, Unit> function24, Composer composer, final int i2) {
        int i3;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-468424875);
        ComposerKt.sourceInformation(startRestartGroup, "C(ScaffoldLayout)P(5,4:c#material.FabPosition,7,1,6,3,2):Scaffold.kt#jmzs0o");
        if ((i2 & 14) == 0) {
            i3 = (startRestartGroup.changed(z) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 112) == 0) {
            i3 |= startRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i2 & 7168) == 0) {
            i3 |= startRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if ((57344 & i2) == 0) {
            i3 |= startRestartGroup.changedInstance(function22) ? 16384 : 8192;
        }
        if ((458752 & i2) == 0) {
            i3 |= startRestartGroup.changedInstance(function23) ? 131072 : 65536;
        }
        if ((3670016 & i2) == 0) {
            i3 |= startRestartGroup.changed(windowInsets) ? 1048576 : 524288;
        }
        if ((29360128 & i2) == 0) {
            i3 |= startRestartGroup.changedInstance(function24) ? 8388608 : 4194304;
        }
        if ((23967451 & i3) != 4793490 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-468424875, i3, -1, "androidx.compose.material.ScaffoldLayout (Scaffold.kt:409)");
            }
            if (getScaffoldSubcomposeInMeasureFix()) {
                startRestartGroup.startReplaceableGroup(-2103098080);
                ComposerKt.sourceInformation(startRestartGroup, "411@18576L322");
                composer2 = startRestartGroup;
                m1751ScaffoldLayoutWithMeasureFixi1QSOvI(z, i, function2, function3, function22, function23, windowInsets, function24, composer2, i3 & 33554430);
                composer2.endReplaceableGroup();
            } else {
                startRestartGroup.startReplaceableGroup(-2103097736);
                ComposerKt.sourceInformation(startRestartGroup, "422@18920L314");
                composer2 = startRestartGroup;
                m1747LegacyScaffoldLayouti1QSOvI(z, i, function2, function3, function22, function23, windowInsets, function24, composer2, i3 & 33554430);
                composer2.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1
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

                public final void invoke(Composer composer3, int i4) {
                    ScaffoldKt.m1750ScaffoldLayouti1QSOvI(z, i, function2, function3, function22, function23, windowInsets, function24, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ScaffoldLayoutWithMeasureFix-i1QSOvI, reason: not valid java name */
    public static final void m1751ScaffoldLayoutWithMeasureFixi1QSOvI(final boolean z, final int i, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final WindowInsets windowInsets, final Function2<? super Composer, ? super Integer, Unit> function24, Composer composer, final int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(1285900760);
        ComposerKt.sourceInformation(startRestartGroup, "C(ScaffoldLayoutWithMeasureFix)P(5,4:c#material.FabPosition,7,1,6,3,2)450@19773L6694:Scaffold.kt#jmzs0o");
        if ((i2 & 14) == 0) {
            i3 = (startRestartGroup.changed(z) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 112) == 0) {
            i3 |= startRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i2 & 7168) == 0) {
            i3 |= startRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if ((57344 & i2) == 0) {
            i3 |= startRestartGroup.changedInstance(function22) ? 16384 : 8192;
        }
        if ((458752 & i2) == 0) {
            i3 |= startRestartGroup.changedInstance(function23) ? 131072 : 65536;
        }
        if ((3670016 & i2) == 0) {
            i3 |= startRestartGroup.changed(windowInsets) ? 1048576 : 524288;
        }
        if ((29360128 & i2) == 0) {
            i3 |= startRestartGroup.changedInstance(function24) ? 8388608 : 4194304;
        }
        if ((23967451 & i3) != 4793490 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1285900760, i3, -1, "androidx.compose.material.ScaffoldLayoutWithMeasureFix (Scaffold.kt:449)");
            }
            startRestartGroup.startReplaceableGroup(-757560492);
            boolean changedInstance = startRestartGroup.changedInstance(function2) | startRestartGroup.changedInstance(function22) | startRestartGroup.changed(windowInsets) | startRestartGroup.changedInstance(function23) | startRestartGroup.changed(i) | startRestartGroup.changed(z) | startRestartGroup.changedInstance(function24) | startRestartGroup.changedInstance(function3);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayoutWithMeasureFix$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                        return m1756invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                    }

                    /* JADX WARN: Removed duplicated region for block: B:49:0x0283 A[LOOP:3: B:48:0x0281->B:49:0x0283, LOOP_END] */
                    /* JADX WARN: Removed duplicated region for block: B:53:0x029f  */
                    /* JADX WARN: Removed duplicated region for block: B:56:0x02cf  */
                    /* JADX WARN: Removed duplicated region for block: B:58:0x02dc  */
                    /* JADX WARN: Removed duplicated region for block: B:63:0x0322  */
                    /* JADX WARN: Removed duplicated region for block: B:68:0x037f A[LOOP:4: B:67:0x037d->B:68:0x037f, LOOP_END] */
                    /* JADX WARN: Removed duplicated region for block: B:76:0x0342  */
                    /* JADX WARN: Removed duplicated region for block: B:81:0x031e  */
                    /* JADX WARN: Removed duplicated region for block: B:82:0x02d9  */
                    /* JADX WARN: Removed duplicated region for block: B:83:0x02a1  */
                    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final MeasureResult m1756invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, long j) {
                        Object obj;
                        Object obj2;
                        final FabPlacement fabPlacement;
                        int size;
                        int i4;
                        final ArrayList arrayList;
                        Object obj3;
                        Integer num;
                        final ArrayList arrayList2;
                        final Integer num2;
                        final int i5;
                        int size2;
                        int i6;
                        int intValue;
                        int intValue2;
                        float f;
                        int i7;
                        int i8;
                        float f2;
                        Object obj4;
                        Object obj5;
                        int i9;
                        float f3;
                        float f4;
                        int i10;
                        float f5;
                        float f6;
                        int m6345getMaxWidthimpl = Constraints.m6345getMaxWidthimpl(j);
                        final int m6344getMaxHeightimpl = Constraints.m6344getMaxHeightimpl(j);
                        long m6336copyZbe2FdA$default = Constraints.m6336copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
                        List<Measurable> subcompose = subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.TopBar, function2);
                        ArrayList arrayList3 = new ArrayList(subcompose.size());
                        int size3 = subcompose.size();
                        for (int i11 = 0; i11 < size3; i11++) {
                            arrayList3.add(subcompose.get(i11).mo5333measureBRTryo0(m6336copyZbe2FdA$default));
                        }
                        ArrayList arrayList4 = arrayList3;
                        if (arrayList4.isEmpty()) {
                            obj = null;
                        } else {
                            obj = arrayList4.get(0);
                            int height = ((Placeable) obj).getHeight();
                            int lastIndex = CollectionsKt.getLastIndex(arrayList4);
                            if (1 <= lastIndex) {
                                int i12 = 1;
                                while (true) {
                                    Object obj6 = arrayList4.get(i12);
                                    int height2 = ((Placeable) obj6).getHeight();
                                    if (height < height2) {
                                        obj = obj6;
                                        height = height2;
                                    }
                                    if (i12 == lastIndex) {
                                        break;
                                    }
                                    i12++;
                                }
                            }
                        }
                        Placeable placeable = (Placeable) obj;
                        final int height3 = placeable != null ? placeable.getHeight() : 0;
                        List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.Snackbar, function22);
                        WindowInsets windowInsets2 = windowInsets;
                        ArrayList arrayList5 = new ArrayList(subcompose2.size());
                        int size4 = subcompose2.size();
                        int i13 = 0;
                        while (i13 < size4) {
                            SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                            arrayList5.add(subcompose2.get(i13).mo5333measureBRTryo0(ConstraintsKt.m6361offsetNN6EwU(m6336copyZbe2FdA$default, (-windowInsets2.getLeft(subcomposeMeasureScope2, subcomposeMeasureScope.getLayoutDirection())) - windowInsets2.getRight(subcomposeMeasureScope2, subcomposeMeasureScope.getLayoutDirection()), -windowInsets2.getBottom(subcomposeMeasureScope2))));
                            i13++;
                            subcompose2 = subcompose2;
                        }
                        final ArrayList arrayList6 = arrayList5;
                        if (arrayList6.isEmpty()) {
                            obj2 = null;
                        } else {
                            obj2 = arrayList6.get(0);
                            int height4 = ((Placeable) obj2).getHeight();
                            int lastIndex2 = CollectionsKt.getLastIndex(arrayList6);
                            if (1 <= lastIndex2) {
                                Object obj7 = obj2;
                                int i14 = height4;
                                int i15 = 1;
                                while (true) {
                                    Object obj8 = arrayList6.get(i15);
                                    int height5 = ((Placeable) obj8).getHeight();
                                    if (i14 < height5) {
                                        obj7 = obj8;
                                        i14 = height5;
                                    }
                                    if (i15 == lastIndex2) {
                                        break;
                                    }
                                    i15++;
                                }
                                obj2 = obj7;
                            }
                        }
                        Placeable placeable2 = (Placeable) obj2;
                        int height6 = placeable2 != null ? placeable2.getHeight() : 0;
                        List<Measurable> subcompose3 = subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.Fab, function23);
                        WindowInsets windowInsets3 = windowInsets;
                        ArrayList arrayList7 = new ArrayList(subcompose3.size());
                        int size5 = subcompose3.size();
                        int i16 = 0;
                        while (i16 < size5) {
                            int i17 = height6;
                            SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope;
                            arrayList7.add(subcompose3.get(i16).mo5333measureBRTryo0(ConstraintsKt.m6361offsetNN6EwU(m6336copyZbe2FdA$default, (-windowInsets3.getLeft(subcomposeMeasureScope3, subcomposeMeasureScope.getLayoutDirection())) - windowInsets3.getRight(subcomposeMeasureScope3, subcomposeMeasureScope.getLayoutDirection()), -windowInsets3.getBottom(subcomposeMeasureScope3))));
                            i16++;
                            height6 = i17;
                            subcompose3 = subcompose3;
                            arrayList4 = arrayList4;
                        }
                        int i18 = height6;
                        ArrayList arrayList8 = arrayList4;
                        final ArrayList arrayList9 = arrayList7;
                        if (!arrayList9.isEmpty()) {
                            if (arrayList9.isEmpty()) {
                                obj4 = null;
                            } else {
                                obj4 = arrayList9.get(0);
                                int width = ((Placeable) obj4).getWidth();
                                int lastIndex3 = CollectionsKt.getLastIndex(arrayList9);
                                if (1 <= lastIndex3) {
                                    Object obj9 = obj4;
                                    int i19 = width;
                                    int i20 = 1;
                                    while (true) {
                                        Object obj10 = arrayList9.get(i20);
                                        int width2 = ((Placeable) obj10).getWidth();
                                        if (i19 < width2) {
                                            obj9 = obj10;
                                            i19 = width2;
                                        }
                                        if (i20 == lastIndex3) {
                                            break;
                                        }
                                        i20++;
                                    }
                                    obj4 = obj9;
                                }
                            }
                            Placeable placeable3 = (Placeable) obj4;
                            int width3 = placeable3 != null ? placeable3.getWidth() : 0;
                            if (arrayList9.isEmpty()) {
                                obj5 = null;
                            } else {
                                obj5 = arrayList9.get(0);
                                int height7 = ((Placeable) obj5).getHeight();
                                int lastIndex4 = CollectionsKt.getLastIndex(arrayList9);
                                if (1 <= lastIndex4) {
                                    Object obj11 = obj5;
                                    int i21 = height7;
                                    int i22 = 1;
                                    while (true) {
                                        Object obj12 = arrayList9.get(i22);
                                        int height8 = ((Placeable) obj12).getHeight();
                                        if (i21 < height8) {
                                            obj11 = obj12;
                                            i21 = height8;
                                        }
                                        if (i22 == lastIndex4) {
                                            break;
                                        }
                                        i22++;
                                    }
                                    obj5 = obj11;
                                }
                            }
                            Placeable placeable4 = (Placeable) obj5;
                            int height9 = placeable4 != null ? placeable4.getHeight() : 0;
                            if (width3 != 0 && height9 != 0) {
                                int i23 = i;
                                if (FabPosition.m1675equalsimpl0(i23, FabPosition.INSTANCE.m1681getStart5ygKITE())) {
                                    if (subcomposeMeasureScope.getLayoutDirection() == LayoutDirection.Ltr) {
                                        f6 = ScaffoldKt.FabSpacing;
                                        i9 = subcomposeMeasureScope.mo624roundToPx0680j_4(f6);
                                        fabPlacement = new FabPlacement(z, i9, width3, height9);
                                    } else {
                                        f5 = ScaffoldKt.FabSpacing;
                                        i10 = subcomposeMeasureScope.mo624roundToPx0680j_4(f5);
                                        i9 = (m6345getMaxWidthimpl - i10) - width3;
                                        fabPlacement = new FabPlacement(z, i9, width3, height9);
                                    }
                                } else {
                                    if (FabPosition.m1675equalsimpl0(i23, FabPosition.INSTANCE.m1680getEnd5ygKITE())) {
                                        if (subcomposeMeasureScope.getLayoutDirection() == LayoutDirection.Ltr) {
                                            f4 = ScaffoldKt.FabSpacing;
                                            i10 = subcomposeMeasureScope.mo624roundToPx0680j_4(f4);
                                            i9 = (m6345getMaxWidthimpl - i10) - width3;
                                        } else {
                                            f3 = ScaffoldKt.FabSpacing;
                                            i9 = subcomposeMeasureScope.mo624roundToPx0680j_4(f3);
                                        }
                                    } else {
                                        i9 = (m6345getMaxWidthimpl - width3) / 2;
                                    }
                                    fabPlacement = new FabPlacement(z, i9, width3, height9);
                                }
                                ScaffoldLayoutContent scaffoldLayoutContent = ScaffoldLayoutContent.BottomBar;
                                final Function2<Composer, Integer, Unit> function25 = function24;
                                List<Measurable> subcompose4 = subcomposeMeasureScope.subcompose(scaffoldLayoutContent, ComposableLambdaKt.composableLambdaInstance(-1617485343, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayoutWithMeasureFix$1$1$bottomBarPlaceables$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num3) {
                                        invoke(composer2, num3.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer2, int i24) {
                                        ComposerKt.sourceInformation(composer2, "C535@23290L132:Scaffold.kt#jmzs0o");
                                        if ((i24 & 11) != 2 || !composer2.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1617485343, i24, -1, "androidx.compose.material.ScaffoldLayoutWithMeasureFix.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:535)");
                                            }
                                            CompositionLocalKt.CompositionLocalProvider(ScaffoldKt.getLocalFabPlacement().provides(FabPlacement.this), function25, composer2, ProvidedValue.$stable);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer2.skipToGroupEnd();
                                    }
                                }));
                                ArrayList arrayList10 = new ArrayList(subcompose4.size());
                                size = subcompose4.size();
                                for (i4 = 0; i4 < size; i4++) {
                                    arrayList10.add(subcompose4.get(i4).mo5333measureBRTryo0(m6336copyZbe2FdA$default));
                                }
                                arrayList = arrayList10;
                                if (arrayList.isEmpty()) {
                                    obj3 = arrayList.get(0);
                                    int height10 = ((Placeable) obj3).getHeight();
                                    int lastIndex5 = CollectionsKt.getLastIndex(arrayList);
                                    if (1 <= lastIndex5) {
                                        int i24 = 1;
                                        while (true) {
                                            Object obj13 = arrayList.get(i24);
                                            int height11 = ((Placeable) obj13).getHeight();
                                            if (height10 < height11) {
                                                height10 = height11;
                                                obj3 = obj13;
                                            }
                                            if (i24 == lastIndex5) {
                                                break;
                                            }
                                            i24++;
                                        }
                                    }
                                } else {
                                    obj3 = null;
                                }
                                Placeable placeable5 = (Placeable) obj3;
                                final Integer valueOf = placeable5 == null ? Integer.valueOf(placeable5.getHeight()) : null;
                                if (fabPlacement == null) {
                                    WindowInsets windowInsets4 = windowInsets;
                                    boolean z2 = z;
                                    if (valueOf == null) {
                                        int height12 = fabPlacement.getHeight();
                                        f2 = ScaffoldKt.FabSpacing;
                                        i8 = height12 + subcomposeMeasureScope.mo624roundToPx0680j_4(f2) + windowInsets4.getBottom(subcomposeMeasureScope);
                                    } else {
                                        if (z2) {
                                            intValue2 = valueOf.intValue();
                                            i7 = fabPlacement.getHeight() / 2;
                                        } else {
                                            intValue2 = valueOf.intValue() + fabPlacement.getHeight();
                                            f = ScaffoldKt.FabSpacing;
                                            i7 = subcomposeMeasureScope.mo624roundToPx0680j_4(f);
                                        }
                                        i8 = i7 + intValue2;
                                    }
                                    num = Integer.valueOf(i8);
                                } else {
                                    num = null;
                                }
                                if (i18 == 0) {
                                    if (num != null) {
                                        intValue = num.intValue();
                                    } else {
                                        intValue = valueOf != null ? valueOf.intValue() : windowInsets.getBottom(subcomposeMeasureScope);
                                    }
                                    arrayList2 = arrayList8;
                                    num2 = num;
                                    i5 = i18 + intValue;
                                } else {
                                    arrayList2 = arrayList8;
                                    num2 = num;
                                    i5 = 0;
                                }
                                int i25 = m6344getMaxHeightimpl - height3;
                                ScaffoldLayoutContent scaffoldLayoutContent2 = ScaffoldLayoutContent.MainContent;
                                final WindowInsets windowInsets5 = windowInsets;
                                final Function3<PaddingValues, Composer, Integer, Unit> function32 = function3;
                                final Integer num3 = valueOf;
                                List<Measurable> subcompose5 = subcomposeMeasureScope.subcompose(scaffoldLayoutContent2, ComposableLambdaKt.composableLambdaInstance(-914494158, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayoutWithMeasureFix$1$1$bodyContentPlaceables$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num4) {
                                        invoke(composer2, num4.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer2, int i26) {
                                        float m6389constructorimpl;
                                        float bottom;
                                        Integer num4;
                                        ComposerKt.sourceInformation(composer2, "C586@25446L21:Scaffold.kt#jmzs0o");
                                        if ((i26 & 11) != 2 || !composer2.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-914494158, i26, -1, "androidx.compose.material.ScaffoldLayoutWithMeasureFix.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:569)");
                                            }
                                            PaddingValues asPaddingValues = WindowInsetsKt.asPaddingValues(WindowInsets.this, subcomposeMeasureScope);
                                            if (arrayList2.isEmpty()) {
                                                m6389constructorimpl = asPaddingValues.getTop();
                                            } else {
                                                m6389constructorimpl = Dp.m6389constructorimpl(0);
                                            }
                                            if (arrayList.isEmpty() || (num4 = valueOf) == null) {
                                                bottom = asPaddingValues.getBottom();
                                            } else {
                                                bottom = subcomposeMeasureScope.mo627toDpu2uoSUM(num4.intValue());
                                            }
                                            function32.invoke(PaddingKt.m875PaddingValuesa9UjIt4(PaddingKt.calculateStartPadding(asPaddingValues, subcomposeMeasureScope.getLayoutDirection()), m6389constructorimpl, PaddingKt.calculateEndPadding(asPaddingValues, subcomposeMeasureScope.getLayoutDirection()), bottom), composer2, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer2.skipToGroupEnd();
                                    }
                                }));
                                ArrayList arrayList11 = new ArrayList(subcompose5.size());
                                size2 = subcompose5.size();
                                i6 = 0;
                                while (i6 < size2) {
                                    long j2 = m6336copyZbe2FdA$default;
                                    arrayList11.add(subcompose5.get(i6).mo5333measureBRTryo0(Constraints.m6336copyZbe2FdA$default(j2, 0, 0, 0, i25, 7, null)));
                                    i6++;
                                    m6336copyZbe2FdA$default = j2;
                                }
                                final ArrayList arrayList12 = arrayList11;
                                final FabPlacement fabPlacement2 = fabPlacement;
                                final ArrayList arrayList13 = arrayList2;
                                return MeasureScope.layout$default(subcomposeMeasureScope, m6345getMaxWidthimpl, m6344getMaxHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayoutWithMeasureFix$1$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
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
                                        List<Placeable> list = arrayList12;
                                        int i26 = height3;
                                        int size6 = list.size();
                                        for (int i27 = 0; i27 < size6; i27++) {
                                            Placeable.PlacementScope.place$default(placementScope, list.get(i27), 0, i26, 0.0f, 4, null);
                                        }
                                        List<Placeable> list2 = arrayList13;
                                        int size7 = list2.size();
                                        for (int i28 = 0; i28 < size7; i28++) {
                                            Placeable.PlacementScope.place$default(placementScope, list2.get(i28), 0, 0, 0.0f, 4, null);
                                        }
                                        List<Placeable> list3 = arrayList6;
                                        int i29 = m6344getMaxHeightimpl;
                                        int i30 = i5;
                                        int size8 = list3.size();
                                        for (int i31 = 0; i31 < size8; i31++) {
                                            Placeable.PlacementScope.place$default(placementScope, list3.get(i31), 0, i29 - i30, 0.0f, 4, null);
                                        }
                                        List<Placeable> list4 = arrayList;
                                        int i32 = m6344getMaxHeightimpl;
                                        Integer num4 = num3;
                                        int size9 = list4.size();
                                        for (int i33 = 0; i33 < size9; i33++) {
                                            Placeable.PlacementScope.place$default(placementScope, list4.get(i33), 0, i32 - (num4 != null ? num4.intValue() : 0), 0.0f, 4, null);
                                        }
                                        List<Placeable> list5 = arrayList9;
                                        FabPlacement fabPlacement3 = fabPlacement2;
                                        int i34 = m6344getMaxHeightimpl;
                                        Integer num5 = num2;
                                        int size10 = list5.size();
                                        for (int i35 = 0; i35 < size10; i35++) {
                                            Placeable.PlacementScope.place$default(placementScope, list5.get(i35), fabPlacement3 != null ? fabPlacement3.getLeft() : 0, i34 - (num5 != null ? num5.intValue() : 0), 0.0f, 4, null);
                                        }
                                    }
                                }, 4, null);
                            }
                        }
                        fabPlacement = null;
                        ScaffoldLayoutContent scaffoldLayoutContent3 = ScaffoldLayoutContent.BottomBar;
                        final Function2<? super Composer, ? super Integer, Unit> function252 = function24;
                        List<Measurable> subcompose42 = subcomposeMeasureScope.subcompose(scaffoldLayoutContent3, ComposableLambdaKt.composableLambdaInstance(-1617485343, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayoutWithMeasureFix$1$1$bottomBarPlaceables$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num32) {
                                invoke(composer2, num32.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i242) {
                                ComposerKt.sourceInformation(composer2, "C535@23290L132:Scaffold.kt#jmzs0o");
                                if ((i242 & 11) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1617485343, i242, -1, "androidx.compose.material.ScaffoldLayoutWithMeasureFix.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:535)");
                                    }
                                    CompositionLocalKt.CompositionLocalProvider(ScaffoldKt.getLocalFabPlacement().provides(FabPlacement.this), function252, composer2, ProvidedValue.$stable);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }));
                        ArrayList arrayList102 = new ArrayList(subcompose42.size());
                        size = subcompose42.size();
                        while (i4 < size) {
                        }
                        arrayList = arrayList102;
                        if (arrayList.isEmpty()) {
                        }
                        Placeable placeable52 = (Placeable) obj3;
                        if (placeable52 == null) {
                        }
                        if (fabPlacement == null) {
                        }
                        if (i18 == 0) {
                        }
                        int i252 = m6344getMaxHeightimpl - height3;
                        ScaffoldLayoutContent scaffoldLayoutContent22 = ScaffoldLayoutContent.MainContent;
                        final WindowInsets windowInsets52 = windowInsets;
                        final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function322 = function3;
                        final Integer num32 = valueOf;
                        List<Measurable> subcompose52 = subcomposeMeasureScope.subcompose(scaffoldLayoutContent22, ComposableLambdaKt.composableLambdaInstance(-914494158, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayoutWithMeasureFix$1$1$bodyContentPlaceables$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num4) {
                                invoke(composer2, num4.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i26) {
                                float m6389constructorimpl;
                                float bottom;
                                Integer num4;
                                ComposerKt.sourceInformation(composer2, "C586@25446L21:Scaffold.kt#jmzs0o");
                                if ((i26 & 11) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-914494158, i26, -1, "androidx.compose.material.ScaffoldLayoutWithMeasureFix.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:569)");
                                    }
                                    PaddingValues asPaddingValues = WindowInsetsKt.asPaddingValues(WindowInsets.this, subcomposeMeasureScope);
                                    if (arrayList2.isEmpty()) {
                                        m6389constructorimpl = asPaddingValues.getTop();
                                    } else {
                                        m6389constructorimpl = Dp.m6389constructorimpl(0);
                                    }
                                    if (arrayList.isEmpty() || (num4 = valueOf) == null) {
                                        bottom = asPaddingValues.getBottom();
                                    } else {
                                        bottom = subcomposeMeasureScope.mo627toDpu2uoSUM(num4.intValue());
                                    }
                                    function322.invoke(PaddingKt.m875PaddingValuesa9UjIt4(PaddingKt.calculateStartPadding(asPaddingValues, subcomposeMeasureScope.getLayoutDirection()), m6389constructorimpl, PaddingKt.calculateEndPadding(asPaddingValues, subcomposeMeasureScope.getLayoutDirection()), bottom), composer2, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }));
                        ArrayList arrayList112 = new ArrayList(subcompose52.size());
                        size2 = subcompose52.size();
                        i6 = 0;
                        while (i6 < size2) {
                        }
                        final List<? extends Placeable> arrayList122 = arrayList112;
                        final FabPlacement fabPlacement22 = fabPlacement;
                        final List<? extends Placeable> arrayList132 = arrayList2;
                        return MeasureScope.layout$default(subcomposeMeasureScope, m6345getMaxWidthimpl, m6344getMaxHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayoutWithMeasureFix$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
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
                                List<Placeable> list = arrayList122;
                                int i26 = height3;
                                int size6 = list.size();
                                for (int i27 = 0; i27 < size6; i27++) {
                                    Placeable.PlacementScope.place$default(placementScope, list.get(i27), 0, i26, 0.0f, 4, null);
                                }
                                List<Placeable> list2 = arrayList132;
                                int size7 = list2.size();
                                for (int i28 = 0; i28 < size7; i28++) {
                                    Placeable.PlacementScope.place$default(placementScope, list2.get(i28), 0, 0, 0.0f, 4, null);
                                }
                                List<Placeable> list3 = arrayList6;
                                int i29 = m6344getMaxHeightimpl;
                                int i30 = i5;
                                int size8 = list3.size();
                                for (int i31 = 0; i31 < size8; i31++) {
                                    Placeable.PlacementScope.place$default(placementScope, list3.get(i31), 0, i29 - i30, 0.0f, 4, null);
                                }
                                List<Placeable> list4 = arrayList;
                                int i32 = m6344getMaxHeightimpl;
                                Integer num4 = num32;
                                int size9 = list4.size();
                                for (int i33 = 0; i33 < size9; i33++) {
                                    Placeable.PlacementScope.place$default(placementScope, list4.get(i33), 0, i32 - (num4 != null ? num4.intValue() : 0), 0.0f, 4, null);
                                }
                                List<Placeable> list5 = arrayList9;
                                FabPlacement fabPlacement3 = fabPlacement22;
                                int i34 = m6344getMaxHeightimpl;
                                Integer num5 = num2;
                                int size10 = list5.size();
                                for (int i35 = 0; i35 < size10; i35++) {
                                    Placeable.PlacementScope.place$default(placementScope, list5.get(i35), fabPlacement3 != null ? fabPlacement3.getLeft() : 0, i34 - (num5 != null ? num5.intValue() : 0), 0.0f, 4, null);
                                }
                            }
                        }, 4, null);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(null, (Function2) rememberedValue, startRestartGroup, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayoutWithMeasureFix$2
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
                    ScaffoldKt.m1751ScaffoldLayoutWithMeasureFixi1QSOvI(z, i, function2, function3, function22, function23, windowInsets, function24, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: LegacyScaffoldLayout-i1QSOvI, reason: not valid java name */
    public static final void m1747LegacyScaffoldLayouti1QSOvI(final boolean z, final int i, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final WindowInsets windowInsets, final Function2<? super Composer, ? super Integer, Unit> function24, Composer composer, final int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(141059468);
        ComposerKt.sourceInformation(startRestartGroup, "C(LegacyScaffoldLayout)P(5,4:c#material.FabPosition,7,1,6,3,2)628@26997L7169:Scaffold.kt#jmzs0o");
        if ((i2 & 14) == 0) {
            i3 = (startRestartGroup.changed(z) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 112) == 0) {
            i3 |= startRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i2 & 7168) == 0) {
            i3 |= startRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if ((57344 & i2) == 0) {
            i3 |= startRestartGroup.changedInstance(function22) ? 16384 : 8192;
        }
        if ((458752 & i2) == 0) {
            i3 |= startRestartGroup.changedInstance(function23) ? 131072 : 65536;
        }
        if ((3670016 & i2) == 0) {
            i3 |= startRestartGroup.changed(windowInsets) ? 1048576 : 524288;
        }
        if ((29360128 & i2) == 0) {
            i3 |= startRestartGroup.changedInstance(function24) ? 8388608 : 4194304;
        }
        if ((23967451 & i3) != 4793490 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(141059468, i3, -1, "androidx.compose.material.LegacyScaffoldLayout (Scaffold.kt:627)");
            }
            startRestartGroup.startReplaceableGroup(-757553268);
            boolean changedInstance = startRestartGroup.changedInstance(function2) | startRestartGroup.changedInstance(function22) | startRestartGroup.changed(windowInsets) | startRestartGroup.changedInstance(function23) | startRestartGroup.changed(i) | startRestartGroup.changed(z) | startRestartGroup.changedInstance(function24) | startRestartGroup.changedInstance(function3);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.ScaffoldKt$LegacyScaffoldLayout$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                        return m1755invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                    }

                    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m1755invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, long j) {
                        final int m6345getMaxWidthimpl = Constraints.m6345getMaxWidthimpl(j);
                        final int m6344getMaxHeightimpl = Constraints.m6344getMaxHeightimpl(j);
                        final long m6336copyZbe2FdA$default = Constraints.m6336copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
                        final Function2<Composer, Integer, Unit> function25 = function2;
                        final Function2<Composer, Integer, Unit> function26 = function22;
                        final Function2<Composer, Integer, Unit> function27 = function23;
                        final int i4 = i;
                        final boolean z2 = z;
                        final WindowInsets windowInsets2 = windowInsets;
                        final Function2<Composer, Integer, Unit> function28 = function24;
                        final Function3<PaddingValues, Composer, Integer, Unit> function32 = function3;
                        return MeasureScope.layout$default(subcomposeMeasureScope, m6345getMaxWidthimpl, m6344getMaxHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.ScaffoldKt$LegacyScaffoldLayout$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX WARN: Removed duplicated region for block: B:110:0x0332  */
                            /* JADX WARN: Removed duplicated region for block: B:114:0x0314  */
                            /* JADX WARN: Removed duplicated region for block: B:115:0x02cd  */
                            /* JADX WARN: Removed duplicated region for block: B:116:0x0296  */
                            /* JADX WARN: Removed duplicated region for block: B:49:0x0277 A[LOOP:3: B:48:0x0275->B:49:0x0277, LOOP_END] */
                            /* JADX WARN: Removed duplicated region for block: B:53:0x0293  */
                            /* JADX WARN: Removed duplicated region for block: B:56:0x02c3  */
                            /* JADX WARN: Removed duplicated region for block: B:58:0x02d0  */
                            /* JADX WARN: Removed duplicated region for block: B:63:0x0317  */
                            /* JADX WARN: Removed duplicated region for block: B:68:0x0370 A[LOOP:4: B:67:0x036e->B:68:0x0370, LOOP_END] */
                            /* JADX WARN: Removed duplicated region for block: B:72:0x03aa A[LOOP:5: B:71:0x03a8->B:72:0x03aa, LOOP_END] */
                            /* JADX WARN: Removed duplicated region for block: B:76:0x03c7 A[LOOP:6: B:75:0x03c5->B:76:0x03c7, LOOP_END] */
                            /* JADX WARN: Removed duplicated region for block: B:80:0x03ea A[LOOP:7: B:79:0x03e8->B:80:0x03ea, LOOP_END] */
                            /* JADX WARN: Removed duplicated region for block: B:84:0x040d  */
                            /* JADX WARN: Removed duplicated region for block: B:94:0x0438  */
                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final void invoke2(Placeable.PlacementScope placementScope) {
                                Object obj;
                                Object obj2;
                                final FabPlacement fabPlacement;
                                int size;
                                int i5;
                                final ArrayList arrayList;
                                int i6;
                                Object obj3;
                                Integer num;
                                int i7;
                                int size2;
                                int i8;
                                int size3;
                                int i9;
                                int size4;
                                int i10;
                                int size5;
                                int i11;
                                int size6;
                                int i12;
                                int size7;
                                int i13;
                                int intValue;
                                float f;
                                int i14;
                                float f2;
                                Object obj4;
                                Object obj5;
                                int i15;
                                float f3;
                                int i16;
                                float f4;
                                int i17;
                                float f5;
                                float f6;
                                List<Measurable> subcompose = SubcomposeMeasureScope.this.subcompose(ScaffoldLayoutContent.TopBar, function25);
                                long j2 = m6336copyZbe2FdA$default;
                                ArrayList arrayList2 = new ArrayList(subcompose.size());
                                int size8 = subcompose.size();
                                for (int i18 = 0; i18 < size8; i18++) {
                                    arrayList2.add(subcompose.get(i18).mo5333measureBRTryo0(j2));
                                }
                                final ArrayList arrayList3 = arrayList2;
                                if (arrayList3.isEmpty()) {
                                    obj = null;
                                } else {
                                    obj = arrayList3.get(0);
                                    int height = ((Placeable) obj).getHeight();
                                    int lastIndex = CollectionsKt.getLastIndex(arrayList3);
                                    if (1 <= lastIndex) {
                                        int i19 = 1;
                                        while (true) {
                                            Object obj6 = arrayList3.get(i19);
                                            int height2 = ((Placeable) obj6).getHeight();
                                            if (height < height2) {
                                                obj = obj6;
                                                height = height2;
                                            }
                                            if (i19 == lastIndex) {
                                                break;
                                            } else {
                                                i19++;
                                            }
                                        }
                                    }
                                }
                                Placeable placeable = (Placeable) obj;
                                int height3 = placeable != null ? placeable.getHeight() : 0;
                                List<Measurable> subcompose2 = SubcomposeMeasureScope.this.subcompose(ScaffoldLayoutContent.Snackbar, function26);
                                WindowInsets windowInsets3 = windowInsets2;
                                SubcomposeMeasureScope subcomposeMeasureScope2 = SubcomposeMeasureScope.this;
                                long j3 = m6336copyZbe2FdA$default;
                                ArrayList arrayList4 = new ArrayList(subcompose2.size());
                                int size9 = subcompose2.size();
                                for (int i20 = 0; i20 < size9; i20++) {
                                    SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope2;
                                    arrayList4.add(subcompose2.get(i20).mo5333measureBRTryo0(ConstraintsKt.m6361offsetNN6EwU(j3, (-windowInsets3.getLeft(subcomposeMeasureScope3, subcomposeMeasureScope2.getLayoutDirection())) - windowInsets3.getRight(subcomposeMeasureScope3, subcomposeMeasureScope2.getLayoutDirection()), -windowInsets3.getBottom(subcomposeMeasureScope3))));
                                }
                                ArrayList arrayList5 = arrayList4;
                                if (arrayList5.isEmpty()) {
                                    obj2 = null;
                                } else {
                                    obj2 = arrayList5.get(0);
                                    int height4 = ((Placeable) obj2).getHeight();
                                    int lastIndex2 = CollectionsKt.getLastIndex(arrayList5);
                                    if (1 <= lastIndex2) {
                                        int i21 = 1;
                                        while (true) {
                                            Object obj7 = arrayList5.get(i21);
                                            int height5 = ((Placeable) obj7).getHeight();
                                            if (height4 < height5) {
                                                obj2 = obj7;
                                                height4 = height5;
                                            }
                                            if (i21 == lastIndex2) {
                                                break;
                                            } else {
                                                i21++;
                                            }
                                        }
                                    }
                                }
                                Placeable placeable2 = (Placeable) obj2;
                                int height6 = placeable2 != null ? placeable2.getHeight() : 0;
                                List<Measurable> subcompose3 = SubcomposeMeasureScope.this.subcompose(ScaffoldLayoutContent.Fab, function27);
                                WindowInsets windowInsets4 = windowInsets2;
                                SubcomposeMeasureScope subcomposeMeasureScope4 = SubcomposeMeasureScope.this;
                                long j4 = m6336copyZbe2FdA$default;
                                ArrayList arrayList6 = new ArrayList(subcompose3.size());
                                int size10 = subcompose3.size();
                                int i22 = 0;
                                while (i22 < size10) {
                                    SubcomposeMeasureScope subcomposeMeasureScope5 = subcomposeMeasureScope4;
                                    arrayList6.add(subcompose3.get(i22).mo5333measureBRTryo0(ConstraintsKt.m6361offsetNN6EwU(j4, (-windowInsets4.getLeft(subcomposeMeasureScope5, subcomposeMeasureScope4.getLayoutDirection())) - windowInsets4.getRight(subcomposeMeasureScope5, subcomposeMeasureScope4.getLayoutDirection()), -windowInsets4.getBottom(subcomposeMeasureScope5))));
                                    i22++;
                                    height6 = height6;
                                    subcompose3 = subcompose3;
                                }
                                int i23 = height6;
                                ArrayList arrayList7 = arrayList6;
                                if (!arrayList7.isEmpty()) {
                                    if (arrayList7.isEmpty()) {
                                        obj4 = null;
                                    } else {
                                        obj4 = arrayList7.get(0);
                                        int width = ((Placeable) obj4).getWidth();
                                        int lastIndex3 = CollectionsKt.getLastIndex(arrayList7);
                                        if (1 <= lastIndex3) {
                                            int i24 = 1;
                                            while (true) {
                                                Object obj8 = arrayList7.get(i24);
                                                int width2 = ((Placeable) obj8).getWidth();
                                                if (width < width2) {
                                                    obj4 = obj8;
                                                    width = width2;
                                                }
                                                if (i24 == lastIndex3) {
                                                    break;
                                                } else {
                                                    i24++;
                                                }
                                            }
                                        }
                                    }
                                    Placeable placeable3 = (Placeable) obj4;
                                    int width3 = placeable3 != null ? placeable3.getWidth() : 0;
                                    if (arrayList7.isEmpty()) {
                                        obj5 = null;
                                    } else {
                                        obj5 = arrayList7.get(0);
                                        int height7 = ((Placeable) obj5).getHeight();
                                        int lastIndex4 = CollectionsKt.getLastIndex(arrayList7);
                                        if (1 <= lastIndex4) {
                                            int i25 = 1;
                                            while (true) {
                                                Object obj9 = arrayList7.get(i25);
                                                int height8 = ((Placeable) obj9).getHeight();
                                                if (height7 < height8) {
                                                    obj5 = obj9;
                                                    height7 = height8;
                                                }
                                                if (i25 == lastIndex4) {
                                                    break;
                                                } else {
                                                    i25++;
                                                }
                                            }
                                        }
                                    }
                                    Placeable placeable4 = (Placeable) obj5;
                                    int height9 = placeable4 != null ? placeable4.getHeight() : 0;
                                    if (width3 != 0 && height9 != 0) {
                                        int i26 = i4;
                                        if (FabPosition.m1675equalsimpl0(i26, FabPosition.INSTANCE.m1681getStart5ygKITE())) {
                                            if (SubcomposeMeasureScope.this.getLayoutDirection() == LayoutDirection.Ltr) {
                                                SubcomposeMeasureScope subcomposeMeasureScope6 = SubcomposeMeasureScope.this;
                                                f6 = ScaffoldKt.FabSpacing;
                                                i15 = subcomposeMeasureScope6.mo624roundToPx0680j_4(f6);
                                                fabPlacement = new FabPlacement(z2, i15, width3, height9);
                                            } else {
                                                i16 = m6345getMaxWidthimpl;
                                                SubcomposeMeasureScope subcomposeMeasureScope7 = SubcomposeMeasureScope.this;
                                                f5 = ScaffoldKt.FabSpacing;
                                                i17 = subcomposeMeasureScope7.mo624roundToPx0680j_4(f5);
                                                i15 = (i16 - i17) - width3;
                                                fabPlacement = new FabPlacement(z2, i15, width3, height9);
                                            }
                                        } else {
                                            if (FabPosition.m1675equalsimpl0(i26, FabPosition.INSTANCE.m1680getEnd5ygKITE())) {
                                                if (SubcomposeMeasureScope.this.getLayoutDirection() == LayoutDirection.Ltr) {
                                                    i16 = m6345getMaxWidthimpl;
                                                    SubcomposeMeasureScope subcomposeMeasureScope8 = SubcomposeMeasureScope.this;
                                                    f4 = ScaffoldKt.FabSpacing;
                                                    i17 = subcomposeMeasureScope8.mo624roundToPx0680j_4(f4);
                                                    i15 = (i16 - i17) - width3;
                                                } else {
                                                    SubcomposeMeasureScope subcomposeMeasureScope9 = SubcomposeMeasureScope.this;
                                                    f3 = ScaffoldKt.FabSpacing;
                                                    i15 = subcomposeMeasureScope9.mo624roundToPx0680j_4(f3);
                                                }
                                            } else {
                                                i15 = (m6345getMaxWidthimpl - width3) / 2;
                                            }
                                            fabPlacement = new FabPlacement(z2, i15, width3, height9);
                                        }
                                        SubcomposeMeasureScope subcomposeMeasureScope10 = SubcomposeMeasureScope.this;
                                        ScaffoldLayoutContent scaffoldLayoutContent = ScaffoldLayoutContent.BottomBar;
                                        final Function2<Composer, Integer, Unit> function29 = function28;
                                        List<Measurable> subcompose4 = subcomposeMeasureScope10.subcompose(scaffoldLayoutContent, ComposableLambdaKt.composableLambdaInstance(-252607998, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$LegacyScaffoldLayout$1$1$1$bottomBarPlaceables$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num2) {
                                                invoke(composer2, num2.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer2, int i27) {
                                                ComposerKt.sourceInformation(composer2, "C714@30842L144:Scaffold.kt#jmzs0o");
                                                if ((i27 & 11) != 2 || !composer2.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-252607998, i27, -1, "androidx.compose.material.LegacyScaffoldLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:714)");
                                                    }
                                                    CompositionLocalKt.CompositionLocalProvider(ScaffoldKt.getLocalFabPlacement().provides(FabPlacement.this), function29, composer2, ProvidedValue.$stable);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer2.skipToGroupEnd();
                                            }
                                        }));
                                        long j5 = m6336copyZbe2FdA$default;
                                        ArrayList arrayList8 = new ArrayList(subcompose4.size());
                                        size = subcompose4.size();
                                        for (i5 = 0; i5 < size; i5++) {
                                            arrayList8.add(subcompose4.get(i5).mo5333measureBRTryo0(j5));
                                        }
                                        arrayList = arrayList8;
                                        if (arrayList.isEmpty()) {
                                            i6 = 0;
                                            obj3 = arrayList.get(0);
                                            int height10 = ((Placeable) obj3).getHeight();
                                            int lastIndex5 = CollectionsKt.getLastIndex(arrayList);
                                            if (1 <= lastIndex5) {
                                                int i27 = height10;
                                                int i28 = 1;
                                                while (true) {
                                                    Object obj10 = arrayList.get(i28);
                                                    int height11 = ((Placeable) obj10).getHeight();
                                                    if (i27 < height11) {
                                                        obj3 = obj10;
                                                        i27 = height11;
                                                    }
                                                    if (i28 == lastIndex5) {
                                                        break;
                                                    } else {
                                                        i28++;
                                                    }
                                                }
                                            }
                                        } else {
                                            i6 = 0;
                                            obj3 = null;
                                        }
                                        Placeable placeable5 = (Placeable) obj3;
                                        final Integer valueOf = placeable5 == null ? Integer.valueOf(placeable5.getHeight()) : null;
                                        if (fabPlacement == null) {
                                            SubcomposeMeasureScope subcomposeMeasureScope11 = SubcomposeMeasureScope.this;
                                            WindowInsets windowInsets5 = windowInsets2;
                                            boolean z3 = z2;
                                            if (valueOf == null) {
                                                int height12 = fabPlacement.getHeight();
                                                f2 = ScaffoldKt.FabSpacing;
                                                i14 = height12 + subcomposeMeasureScope11.mo624roundToPx0680j_4(f2) + windowInsets5.getBottom(subcomposeMeasureScope11);
                                            } else if (z3) {
                                                i14 = valueOf.intValue() + (fabPlacement.getHeight() / 2);
                                            } else {
                                                int intValue2 = valueOf.intValue() + fabPlacement.getHeight();
                                                f = ScaffoldKt.FabSpacing;
                                                i14 = intValue2 + subcomposeMeasureScope11.mo624roundToPx0680j_4(f);
                                            }
                                            num = Integer.valueOf(i14);
                                        } else {
                                            num = null;
                                        }
                                        if (i23 == 0) {
                                            if (num != null) {
                                                intValue = num.intValue();
                                            } else {
                                                intValue = valueOf != null ? valueOf.intValue() : windowInsets2.getBottom(SubcomposeMeasureScope.this);
                                            }
                                            i7 = i23 + intValue;
                                        } else {
                                            i7 = i6;
                                        }
                                        int i29 = m6344getMaxHeightimpl - height3;
                                        SubcomposeMeasureScope subcomposeMeasureScope12 = SubcomposeMeasureScope.this;
                                        ScaffoldLayoutContent scaffoldLayoutContent2 = ScaffoldLayoutContent.MainContent;
                                        final WindowInsets windowInsets6 = windowInsets2;
                                        final SubcomposeMeasureScope subcomposeMeasureScope13 = SubcomposeMeasureScope.this;
                                        final Function3<PaddingValues, Composer, Integer, Unit> function33 = function32;
                                        Function2<Composer, Integer, Unit> function210 = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$LegacyScaffoldLayout$1$1$1$bodyContentPlaceables$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num2) {
                                                invoke(composer2, num2.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer2, int i30) {
                                                float m6389constructorimpl;
                                                float bottom;
                                                Integer num2;
                                                ComposerKt.sourceInformation(composer2, "C765@33186L21:Scaffold.kt#jmzs0o");
                                                if ((i30 & 11) != 2 || !composer2.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(230985361, i30, -1, "androidx.compose.material.LegacyScaffoldLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:748)");
                                                    }
                                                    PaddingValues asPaddingValues = WindowInsetsKt.asPaddingValues(WindowInsets.this, subcomposeMeasureScope13);
                                                    if (arrayList3.isEmpty()) {
                                                        m6389constructorimpl = asPaddingValues.getTop();
                                                    } else {
                                                        m6389constructorimpl = Dp.m6389constructorimpl(0);
                                                    }
                                                    if (arrayList.isEmpty() || (num2 = valueOf) == null) {
                                                        bottom = asPaddingValues.getBottom();
                                                    } else {
                                                        bottom = subcomposeMeasureScope13.mo627toDpu2uoSUM(num2.intValue());
                                                    }
                                                    function33.invoke(PaddingKt.m875PaddingValuesa9UjIt4(PaddingKt.calculateStartPadding(asPaddingValues, subcomposeMeasureScope13.getLayoutDirection()), m6389constructorimpl, PaddingKt.calculateEndPadding(asPaddingValues, subcomposeMeasureScope13.getLayoutDirection()), bottom), composer2, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer2.skipToGroupEnd();
                                            }
                                        };
                                        Integer num2 = valueOf;
                                        List<Measurable> subcompose5 = subcomposeMeasureScope12.subcompose(scaffoldLayoutContent2, ComposableLambdaKt.composableLambdaInstance(230985361, true, function210));
                                        long j6 = m6336copyZbe2FdA$default;
                                        ArrayList arrayList9 = new ArrayList(subcompose5.size());
                                        size2 = subcompose5.size();
                                        i8 = 0;
                                        while (i8 < size2) {
                                            long j7 = j6;
                                            arrayList9.add(subcompose5.get(i8).mo5333measureBRTryo0(Constraints.m6336copyZbe2FdA$default(j7, 0, 0, 0, i29, 7, null)));
                                            i8++;
                                            subcompose5 = subcompose5;
                                            j6 = j7;
                                            num = num;
                                        }
                                        Integer num3 = num;
                                        ArrayList arrayList10 = arrayList9;
                                        size3 = arrayList10.size();
                                        for (i9 = 0; i9 < size3; i9++) {
                                            Placeable.PlacementScope.place$default(placementScope, (Placeable) arrayList10.get(i9), 0, height3, 0.0f, 4, null);
                                        }
                                        size4 = arrayList3.size();
                                        for (i10 = 0; i10 < size4; i10++) {
                                            Placeable.PlacementScope.place$default(placementScope, (Placeable) arrayList3.get(i10), 0, 0, 0.0f, 4, null);
                                        }
                                        int i30 = m6344getMaxHeightimpl;
                                        size5 = arrayList5.size();
                                        for (i11 = 0; i11 < size5; i11++) {
                                            Placeable.PlacementScope.place$default(placementScope, (Placeable) arrayList5.get(i11), 0, i30 - i7, 0.0f, 4, null);
                                        }
                                        int i31 = m6344getMaxHeightimpl;
                                        size6 = arrayList.size();
                                        for (i12 = 0; i12 < size6; i12++) {
                                            Placeable.PlacementScope.place$default(placementScope, (Placeable) arrayList.get(i12), 0, i31 - (num2 != null ? num2.intValue() : 0), 0.0f, 4, null);
                                        }
                                        int i32 = m6344getMaxHeightimpl;
                                        size7 = arrayList7.size();
                                        for (i13 = 0; i13 < size7; i13++) {
                                            Placeable.PlacementScope.place$default(placementScope, (Placeable) arrayList7.get(i13), fabPlacement != null ? fabPlacement.getLeft() : 0, i32 - (num3 != null ? num3.intValue() : 0), 0.0f, 4, null);
                                        }
                                    }
                                }
                                fabPlacement = null;
                                SubcomposeMeasureScope subcomposeMeasureScope102 = SubcomposeMeasureScope.this;
                                ScaffoldLayoutContent scaffoldLayoutContent3 = ScaffoldLayoutContent.BottomBar;
                                final Function2<? super Composer, ? super Integer, Unit> function292 = function28;
                                List<Measurable> subcompose42 = subcomposeMeasureScope102.subcompose(scaffoldLayoutContent3, ComposableLambdaKt.composableLambdaInstance(-252607998, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$LegacyScaffoldLayout$1$1$1$bottomBarPlaceables$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num22) {
                                        invoke(composer2, num22.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer2, int i272) {
                                        ComposerKt.sourceInformation(composer2, "C714@30842L144:Scaffold.kt#jmzs0o");
                                        if ((i272 & 11) != 2 || !composer2.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-252607998, i272, -1, "androidx.compose.material.LegacyScaffoldLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:714)");
                                            }
                                            CompositionLocalKt.CompositionLocalProvider(ScaffoldKt.getLocalFabPlacement().provides(FabPlacement.this), function292, composer2, ProvidedValue.$stable);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer2.skipToGroupEnd();
                                    }
                                }));
                                long j52 = m6336copyZbe2FdA$default;
                                ArrayList arrayList82 = new ArrayList(subcompose42.size());
                                size = subcompose42.size();
                                while (i5 < size) {
                                }
                                arrayList = arrayList82;
                                if (arrayList.isEmpty()) {
                                }
                                Placeable placeable52 = (Placeable) obj3;
                                if (placeable52 == null) {
                                }
                                if (fabPlacement == null) {
                                }
                                if (i23 == 0) {
                                }
                                int i292 = m6344getMaxHeightimpl - height3;
                                SubcomposeMeasureScope subcomposeMeasureScope122 = SubcomposeMeasureScope.this;
                                ScaffoldLayoutContent scaffoldLayoutContent22 = ScaffoldLayoutContent.MainContent;
                                final WindowInsets windowInsets62 = windowInsets2;
                                final SubcomposeMeasureScope subcomposeMeasureScope132 = SubcomposeMeasureScope.this;
                                final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function332 = function32;
                                Function2<Composer, Integer, Unit> function2102 = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$LegacyScaffoldLayout$1$1$1$bodyContentPlaceables$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num22) {
                                        invoke(composer2, num22.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer2, int i302) {
                                        float m6389constructorimpl;
                                        float bottom;
                                        Integer num22;
                                        ComposerKt.sourceInformation(composer2, "C765@33186L21:Scaffold.kt#jmzs0o");
                                        if ((i302 & 11) != 2 || !composer2.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(230985361, i302, -1, "androidx.compose.material.LegacyScaffoldLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:748)");
                                            }
                                            PaddingValues asPaddingValues = WindowInsetsKt.asPaddingValues(WindowInsets.this, subcomposeMeasureScope132);
                                            if (arrayList3.isEmpty()) {
                                                m6389constructorimpl = asPaddingValues.getTop();
                                            } else {
                                                m6389constructorimpl = Dp.m6389constructorimpl(0);
                                            }
                                            if (arrayList.isEmpty() || (num22 = valueOf) == null) {
                                                bottom = asPaddingValues.getBottom();
                                            } else {
                                                bottom = subcomposeMeasureScope132.mo627toDpu2uoSUM(num22.intValue());
                                            }
                                            function332.invoke(PaddingKt.m875PaddingValuesa9UjIt4(PaddingKt.calculateStartPadding(asPaddingValues, subcomposeMeasureScope132.getLayoutDirection()), m6389constructorimpl, PaddingKt.calculateEndPadding(asPaddingValues, subcomposeMeasureScope132.getLayoutDirection()), bottom), composer2, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer2.skipToGroupEnd();
                                    }
                                };
                                Integer num22 = valueOf;
                                List<Measurable> subcompose52 = subcomposeMeasureScope122.subcompose(scaffoldLayoutContent22, ComposableLambdaKt.composableLambdaInstance(230985361, true, function2102));
                                long j62 = m6336copyZbe2FdA$default;
                                ArrayList arrayList92 = new ArrayList(subcompose52.size());
                                size2 = subcompose52.size();
                                i8 = 0;
                                while (i8 < size2) {
                                }
                                Integer num32 = num;
                                ArrayList arrayList102 = arrayList92;
                                size3 = arrayList102.size();
                                while (i9 < size3) {
                                }
                                size4 = arrayList3.size();
                                while (i10 < size4) {
                                }
                                int i302 = m6344getMaxHeightimpl;
                                size5 = arrayList5.size();
                                while (i11 < size5) {
                                }
                                int i312 = m6344getMaxHeightimpl;
                                size6 = arrayList.size();
                                while (i12 < size6) {
                                }
                                int i322 = m6344getMaxHeightimpl;
                                size7 = arrayList7.size();
                                while (i13 < size7) {
                                }
                            }
                        }, 4, null);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(null, (Function2) rememberedValue, startRestartGroup, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$LegacyScaffoldLayout$2
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
                    ScaffoldKt.m1747LegacyScaffoldLayouti1QSOvI(z, i, function2, function3, function22, function23, windowInsets, function24, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    public static final ProvidableCompositionLocal<FabPlacement> getLocalFabPlacement() {
        return LocalFabPlacement;
    }
}
