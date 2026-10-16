package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import com.vungle.ads.internal.protos.Sdk;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: BackdropScaffold.kt */
@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a;\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\tH\u0003¢\u0006\u0002\u0010\u000b\u001aò\u0001\u0010\f\u001a\u00020\u00042\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0017\u001a\u00020\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u00142\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001a2\b\b\u0002\u0010 \u001a\u00020\u001a2\b\b\u0002\u0010!\u001a\u00020\u001a2\u0019\b\u0002\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00040#¢\u0006\u0002\b\tH\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001ae\u0010'\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t¢\u0006\u0002\b)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020+0#2\"\u0010,\u001a\u001e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00040-¢\u0006\u0002\b\t¢\u0006\u0002\b)H\u0003¢\u0006\u0002\u0010/\u001a0\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u001a2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u00103\u001a\u00020\u0014H\u0003ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001aE\u00106\u001a\u00020\u00122\u0006\u00107\u001a\u00020\u00062\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u00020.092\u0014\b\u0002\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140#2\b\b\u0002\u0010;\u001a\u00020$H\u0007¢\u0006\u0002\u0010<\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006=²\u0006\n\u0010>\u001a\u00020.X\u008a\u0084\u0002²\u0006\n\u0010?\u001a\u00020.X\u008a\u0084\u0002"}, d2 = {"AnimationSlideOffset", "Landroidx/compose/ui/unit/Dp;", "F", "BackLayerTransition", "", "target", "Landroidx/compose/material/BackdropValue;", "appBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "content", "(Landroidx/compose/material/BackdropValue;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "BackdropScaffold", "backLayerContent", "frontLayerContent", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material/BackdropScaffoldState;", "gesturesEnabled", "", "peekHeight", "headerHeight", "persistentAppBar", "stickyFrontLayer", "backLayerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "backLayerContentColor", "frontLayerShape", "Landroidx/compose/ui/graphics/Shape;", "frontLayerElevation", "frontLayerBackgroundColor", "frontLayerContentColor", "frontLayerScrimColor", "snackbarHost", "Lkotlin/Function1;", "Landroidx/compose/material/SnackbarHostState;", "BackdropScaffold-BZszfkY", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BackdropScaffoldState;ZFFZZJJLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "BackdropStack", "backLayer", "Landroidx/compose/ui/UiComposable;", "calculateBackLayerConstraints", "Landroidx/compose/ui/unit/Constraints;", "frontLayer", "Lkotlin/Function2;", "", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)V", "Scrim", "color", "onDismiss", VastAttributes.VISIBLE, "Scrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "rememberBackdropScaffoldState", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmStateChange", "snackbarHostState", "(Landroidx/compose/material/BackdropValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BackdropScaffoldState;", "material_release", "alpha", "animationProgress"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BackdropScaffoldKt {
    private static final float AnimationSlideOffset = Dp.m6389constructorimpl(20);

    public static final BackdropScaffoldState rememberBackdropScaffoldState(final BackdropValue backdropValue, final AnimationSpec<Float> animationSpec, final Function1<? super BackdropValue, Boolean> function1, final SnackbarHostState snackbarHostState, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-862178912);
        ComposerKt.sourceInformation(composer, "C(rememberBackdropScaffoldState)P(2)173@6493L32,175@6564L538:BackdropScaffold.kt#jmzs0o");
        if ((i2 & 2) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i2 & 4) != 0) {
            function1 = new Function1<BackdropValue, Boolean>() { // from class: androidx.compose.material.BackdropScaffoldKt$rememberBackdropScaffoldState$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(BackdropValue backdropValue2) {
                    return true;
                }
            };
        }
        if ((i2 & 8) != 0) {
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
            ComposerKt.traceEventStart(-862178912, i, -1, "androidx.compose.material.rememberBackdropScaffoldState (BackdropScaffold.kt:174)");
        }
        BackdropScaffoldState backdropScaffoldState = (BackdropScaffoldState) RememberSaveableKt.m3680rememberSaveable(new Object[]{animationSpec, function1, snackbarHostState}, (Saver) BackdropScaffoldState.INSTANCE.Saver(animationSpec, function1, snackbarHostState), (String) null, (Function0) new Function0<BackdropScaffoldState>() { // from class: androidx.compose.material.BackdropScaffoldKt$rememberBackdropScaffoldState$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BackdropScaffoldState invoke() {
                return new BackdropScaffoldState(BackdropValue.this, animationSpec, function1, snackbarHostState);
            }
        }, composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return backdropScaffoldState;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x03d5  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x04b7  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0240  */
    /* renamed from: BackdropScaffold-BZszfkY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1538BackdropScaffoldBZszfkY(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, Modifier modifier, BackdropScaffoldState backdropScaffoldState, boolean z, float f, float f2, boolean z2, boolean z3, long j, long j2, Shape shape, float f3, long j3, long j4, long j5, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i5;
        boolean z4;
        int i6;
        float f4;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        Shape shape2;
        int i14;
        int i15;
        Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function32;
        int i16;
        Modifier modifier2;
        int i17;
        int i18;
        int i19;
        final BackdropScaffoldState backdropScaffoldState2;
        final float m1537getPeekHeightD9Ej5fM;
        float m1536getHeaderHeightD9Ej5fM;
        final boolean z5;
        boolean z6;
        final long j6;
        long j7;
        Shape shape3;
        float f5;
        long j8;
        long j9;
        long j10;
        long j11;
        int i20;
        final Shape shape4;
        float f6;
        Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function33;
        int i21;
        int i22;
        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function34;
        boolean changed;
        Object rememberedValue;
        final Shape shape5;
        Composer composer2;
        final boolean z7;
        final boolean z8;
        final float f7;
        final BackdropScaffoldState backdropScaffoldState3;
        final boolean z9;
        final long j12;
        final long j13;
        final float f8;
        final long j14;
        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function35;
        final Modifier modifier3;
        final long j15;
        int i23;
        Composer startRestartGroup = composer.startRestartGroup(1397420093);
        ComposerKt.sourceInformation(startRestartGroup, "C(BackdropScaffold)P(!1,2,5,12,15,10,13:c#ui.unit.Dp,11:c#ui.unit.Dp,14,17,1:c#ui.graphics.Color,3:c#ui.graphics.Color,9,7:c#ui.unit.Dp,4:c#ui.graphics.Color,6:c#ui.graphics.Color,8:c#ui.graphics.Color)262@11812L40,268@12139L6,269@12190L41,270@12287L15,272@12433L6,273@12485L42,274@12588L20,*277@12736L7,278@12810L7,295@13317L3282:BackdropScaffold.kt#jmzs0o");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= startRestartGroup.changedInstance(function22) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
            function24 = function23;
        } else {
            function24 = function23;
            if ((i & 896) == 0) {
                i4 |= startRestartGroup.changedInstance(function24) ? 256 : 128;
            }
        }
        int i24 = i3 & 8;
        if (i24 != 0) {
            i4 |= 3072;
        } else if ((i & 7168) == 0) {
            i4 |= startRestartGroup.changed(modifier) ? 2048 : 1024;
            int i25 = 8192;
            if ((i & 57344) == 0) {
                i4 |= ((i3 & 16) == 0 && startRestartGroup.changed(backdropScaffoldState)) ? 16384 : 8192;
            }
            i5 = i3 & 32;
            if (i5 == 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                z4 = z;
            } else {
                z4 = z;
                if ((i & 458752) == 0) {
                    i4 |= startRestartGroup.changed(z4) ? 131072 : 65536;
                }
            }
            i6 = i3 & 64;
            if (i6 == 0) {
                i4 |= 1572864;
                f4 = f;
            } else {
                f4 = f;
                if ((i & 3670016) == 0) {
                    i4 |= startRestartGroup.changed(f4) ? 1048576 : 524288;
                }
            }
            i7 = i3 & 128;
            if (i7 == 0) {
                i4 |= 12582912;
            } else if ((i & 29360128) == 0) {
                i4 |= startRestartGroup.changed(f2) ? 8388608 : 4194304;
            }
            i8 = i3 & 256;
            if (i8 == 0) {
                i4 |= 100663296;
            } else if ((i & 234881024) == 0) {
                i9 = i8;
                i4 |= startRestartGroup.changed(z2) ? 67108864 : 33554432;
                i10 = i3 & 512;
                if (i10 != 0) {
                    i12 = i4 | C.ENCODING_PCM_32BIT;
                    i11 = i10;
                } else {
                    if ((i & 1879048192) == 0) {
                        i11 = i10;
                        i4 |= startRestartGroup.changed(z3) ? 536870912 : 268435456;
                    } else {
                        i11 = i10;
                    }
                    i12 = i4;
                }
                if ((i2 & 14) == 0) {
                    i13 = i2 | (((i3 & 1024) == 0 && startRestartGroup.changed(j)) ? 4 : 2);
                } else {
                    i13 = i2;
                }
                if ((i2 & 112) == 0) {
                    i13 |= ((i3 & 2048) == 0 && startRestartGroup.changed(j2)) ? 32 : 16;
                }
                if ((i2 & 896) == 0) {
                    if ((i3 & 4096) == 0) {
                        shape2 = shape;
                        if (startRestartGroup.changed(shape2)) {
                            i23 = 256;
                            i13 |= i23;
                        }
                    } else {
                        shape2 = shape;
                    }
                    i23 = 128;
                    i13 |= i23;
                } else {
                    shape2 = shape;
                }
                i14 = i3 & 8192;
                if (i14 != 0) {
                    i13 |= 3072;
                } else if ((i2 & 7168) == 0) {
                    i13 |= startRestartGroup.changed(f3) ? 2048 : 1024;
                    if ((i2 & 57344) == 0) {
                        if ((i3 & 16384) == 0 && startRestartGroup.changed(j3)) {
                            i25 = 16384;
                        }
                        i13 |= i25;
                    }
                    if ((458752 & i2) == 0) {
                        i13 |= ((i3 & 32768) == 0 && startRestartGroup.changed(j4)) ? 131072 : 65536;
                    }
                    if ((3670016 & i2) == 0) {
                        i13 |= ((i3 & 65536) == 0 && startRestartGroup.changed(j5)) ? 1048576 : 524288;
                    }
                    i15 = i3 & 131072;
                    if (i15 == 0) {
                        i13 |= 12582912;
                        function32 = function3;
                    } else {
                        function32 = function3;
                        if ((i2 & 29360128) == 0) {
                            i13 |= startRestartGroup.changedInstance(function32) ? 8388608 : 4194304;
                        }
                    }
                    i16 = i13;
                    if ((i12 & 1533916891) == 306783378 || (i16 & 23967451) != 4793490 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            modifier2 = i24 == 0 ? Modifier.INSTANCE : modifier;
                            if ((i3 & 16) == 0) {
                                i19 = i14;
                                i17 = i15;
                                i18 = 6;
                                backdropScaffoldState2 = rememberBackdropScaffoldState(BackdropValue.Concealed, null, null, null, startRestartGroup, 6, 14);
                                i12 &= -57345;
                            } else {
                                i17 = i15;
                                i18 = 6;
                                i19 = i14;
                                backdropScaffoldState2 = backdropScaffoldState;
                            }
                            if (i5 != 0) {
                                z4 = true;
                            }
                            m1537getPeekHeightD9Ej5fM = i6 == 0 ? BackdropScaffoldDefaults.INSTANCE.m1537getPeekHeightD9Ej5fM() : f4;
                            m1536getHeaderHeightD9Ej5fM = i7 == 0 ? BackdropScaffoldDefaults.INSTANCE.m1536getHeaderHeightD9Ej5fM() : f2;
                            z5 = i9 == 0 ? true : z2;
                            z6 = i11 == 0 ? true : z3;
                            if ((i3 & 1024) == 0) {
                                j6 = MaterialTheme.INSTANCE.getColors(startRestartGroup, i18).m1603getPrimary0d7_KjU();
                                i16 &= -15;
                            } else {
                                j6 = j;
                            }
                            if ((i3 & 2048) == 0) {
                                j7 = ColorsKt.m1621contentColorForek8zF_U(j6, startRestartGroup, i16 & 14);
                                i16 &= -113;
                            } else {
                                j7 = j2;
                            }
                            int i26 = i16;
                            if ((i3 & 4096) == 0) {
                                shape3 = BackdropScaffoldDefaults.INSTANCE.getFrontLayerShape(startRestartGroup, 6);
                                i26 &= -897;
                            } else {
                                shape3 = shape;
                            }
                            float m1535getFrontLayerElevationD9Ej5fM = i19 == 0 ? BackdropScaffoldDefaults.INSTANCE.m1535getFrontLayerElevationD9Ej5fM() : f3;
                            Shape shape6 = shape3;
                            if ((i3 & 16384) == 0) {
                                f5 = m1535getFrontLayerElevationD9Ej5fM;
                                i26 &= -57345;
                                j8 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m1607getSurface0d7_KjU();
                            } else {
                                f5 = m1535getFrontLayerElevationD9Ej5fM;
                                j8 = j3;
                            }
                            if ((i3 & 32768) == 0) {
                                j9 = ColorsKt.m1621contentColorForek8zF_U(j8, startRestartGroup, (i26 >> 12) & 14);
                                i26 &= -458753;
                            } else {
                                j9 = j4;
                            }
                            if ((i3 & 65536) == 0) {
                                j10 = j8;
                                j11 = BackdropScaffoldDefaults.INSTANCE.getFrontLayerScrimColor(startRestartGroup, 6);
                                i20 = (-3670017) & i26;
                            } else {
                                j10 = j8;
                                j11 = j5;
                                i20 = i26;
                            }
                            if (i17 == 0) {
                                shape4 = shape6;
                                i21 = i20;
                                function33 = ComposableSingletons$BackdropScaffoldKt.INSTANCE.m1628getLambda1$material_release();
                                i22 = i12;
                                f6 = f5;
                                startRestartGroup.endDefaults();
                                final float f9 = f6;
                                if (ComposerKt.isTraceInProgress()) {
                                    function34 = function33;
                                } else {
                                    function34 = function33;
                                    ComposerKt.traceEventStart(1397420093, i22, i21, "androidx.compose.material.BackdropScaffold (BackdropScaffold.kt:276)");
                                }
                                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume = startRestartGroup.consume(localDensity);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                final float mo630toPx0680j_4 = ((Density) consume).mo630toPx0680j_4(m1537getPeekHeightD9Ej5fM);
                                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume2 = startRestartGroup.consume(localDensity2);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                final float mo630toPx0680j_42 = ((Density) consume2).mo630toPx0680j_4(m1536getHeaderHeightD9Ej5fM);
                                final ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, 1744778315, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$backLayer$1
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

                                    public final void invoke(Composer composer3, int i27) {
                                        ComposerKt.sourceInformation(composer3, "C:BackdropScaffold.kt#jmzs0o");
                                        if ((i27 & 11) != 2 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1744778315, i27, -1, "androidx.compose.material.BackdropScaffold.<anonymous> (BackdropScaffold.kt:281)");
                                            }
                                            if (z5) {
                                                composer3.startReplaceableGroup(-1017265285);
                                                ComposerKt.sourceInformation(composer3, "282@12922L82");
                                                Function2<Composer, Integer, Unit> function25 = function2;
                                                Function2<Composer, Integer, Unit> function26 = function22;
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
                                                ComposerKt.sourceInformationMarkerStart(composer3, -1993300157, "C283@12947L8,284@12972L18:BackdropScaffold.kt#jmzs0o");
                                                function25.invoke(composer3, 0);
                                                function26.invoke(composer3, 0);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                composer3.endReplaceableGroup();
                                                composer3.endNode();
                                                composer3.endReplaceableGroup();
                                                composer3.endReplaceableGroup();
                                                composer3.endReplaceableGroup();
                                            } else {
                                                composer3.startReplaceableGroup(-1017265173);
                                                ComposerKt.sourceInformation(composer3, "287@13034L72");
                                                BackdropScaffoldKt.BackLayerTransition(backdropScaffoldState2.getTargetValue(), function2, function22, composer3, 0);
                                                composer3.endReplaceableGroup();
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                });
                                startRestartGroup.startReplaceableGroup(1686358917);
                                changed = startRestartGroup.changed(mo630toPx0680j_42);
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = (Function1) new Function1<Constraints, Constraints>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Constraints invoke(Constraints constraints) {
                                            return Constraints.m6333boximpl(m1543invokeZezNO4M(constraints.getValue()));
                                        }

                                        /* renamed from: invoke-ZezNO4M, reason: not valid java name */
                                        public final long m1543invokeZezNO4M(long j16) {
                                            return ConstraintsKt.m6362offsetNN6EwU$default(Constraints.m6336copyZbe2FdA$default(j16, 0, 0, 0, 0, 10, null), 0, -MathKt.roundToInt(mo630toPx0680j_42), 1, null);
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                final Function1 function1 = (Function1) rememberedValue;
                                startRestartGroup.endReplaceableGroup();
                                final float f10 = m1536getHeaderHeightD9Ej5fM;
                                final BackdropScaffoldState backdropScaffoldState4 = backdropScaffoldState2;
                                final float f11 = m1537getPeekHeightD9Ej5fM;
                                final boolean z10 = z6;
                                final boolean z11 = z4;
                                final Function2<? super Composer, ? super Integer, Unit> function25 = function24;
                                final long j16 = j9;
                                final Modifier modifier4 = modifier2;
                                final long j17 = j10;
                                final long j18 = j11;
                                Function2<Composer, Integer, Unit> function26 = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1
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

                                    public final void invoke(Composer composer3, int i27) {
                                        ComposerKt.sourceInformation(composer3, "C299@13441L24,300@13474L3119:BackdropScaffold.kt#jmzs0o");
                                        if ((i27 & 11) != 2 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1049909631, i27, -1, "androidx.compose.material.BackdropScaffold.<anonymous> (BackdropScaffold.kt:299)");
                                            }
                                            composer3.startReplaceableGroup(773894976);
                                            ComposerKt.sourceInformation(composer3, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                                            composer3.startReplaceableGroup(-492369756);
                                            ComposerKt.sourceInformation(composer3, "CC(remember):Composables.kt#9igjgp");
                                            Object rememberedValue2 = composer3.rememberedValue();
                                            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer3));
                                                composer3.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                                                rememberedValue2 = compositionScopedCoroutineScopeCanceller;
                                            }
                                            composer3.endReplaceableGroup();
                                            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue2).getCoroutineScope();
                                            composer3.endReplaceableGroup();
                                            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.this, 0.0f, 1, null);
                                            Function2<Composer, Integer, Unit> function27 = composableLambda;
                                            Function1<Constraints, Constraints> function12 = function1;
                                            final float f12 = mo630toPx0680j_42;
                                            final boolean z12 = z10;
                                            final boolean z13 = z11;
                                            final BackdropScaffoldState backdropScaffoldState5 = backdropScaffoldState4;
                                            final float f13 = mo630toPx0680j_4;
                                            final Shape shape7 = shape4;
                                            final long j19 = j17;
                                            final long j20 = j16;
                                            final float f14 = f9;
                                            final float f15 = f10;
                                            final float f16 = f11;
                                            final Function2<Composer, Integer, Unit> function28 = function25;
                                            final long j21 = j18;
                                            final Function3<SnackbarHostState, Composer, Integer, Unit> function36 = function34;
                                            BackdropScaffoldKt.BackdropStack(fillMaxSize$default, function27, function12, ComposableLambdaKt.composableLambda(composer3, 1800047509, true, new Function4<Constraints, Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(4);
                                                }

                                                @Override // kotlin.jvm.functions.Function4
                                                public /* bridge */ /* synthetic */ Unit invoke(Constraints constraints, Float f17, Composer composer4, Integer num) {
                                                    m1541invokejYbf7pk(constraints.getValue(), f17.floatValue(), composer4, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke-jYbf7pk, reason: not valid java name */
                                                public final void m1541invokejYbf7pk(long j22, float f17, Composer composer4, int i28) {
                                                    int i29;
                                                    Modifier.Companion companion;
                                                    Modifier m1792swipeablepPrIpRY;
                                                    float m6389constructorimpl;
                                                    ComposerKt.sourceInformation(composer4, "CP(1:c#ui.unit.Constraints)344@15178L942,368@16163L420:BackdropScaffold.kt#jmzs0o");
                                                    if ((i28 & 14) == 0) {
                                                        i29 = i28 | (composer4.changed(j22) ? 4 : 2);
                                                    } else {
                                                        i29 = i28;
                                                    }
                                                    if ((i28 & 112) == 0) {
                                                        i29 |= composer4.changed(f17) ? 32 : 16;
                                                    }
                                                    if ((i29 & 731) != 146 || !composer4.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(1800047509, i29, -1, "androidx.compose.material.BackdropScaffold.<anonymous>.<anonymous> (BackdropScaffold.kt:305)");
                                                        }
                                                        float m6344getMaxHeightimpl = Constraints.m6344getMaxHeightimpl(j22);
                                                        float f18 = m6344getMaxHeightimpl - f12;
                                                        if (z12) {
                                                            f18 = Math.min(f18, f17);
                                                        }
                                                        float f19 = f18;
                                                        if (z13) {
                                                            companion = NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, backdropScaffoldState5.getNestedScrollConnection(), null, 2, null);
                                                        } else {
                                                            companion = Modifier.INSTANCE;
                                                        }
                                                        m1792swipeablepPrIpRY = SwipeableKt.m1792swipeablepPrIpRY(Modifier.INSTANCE.then(companion), backdropScaffoldState5, r17, Orientation.Vertical, (r26 & 8) != 0 ? true : z13, (r26 & 16) != 0 ? false : false, (r26 & 32) != 0 ? null : null, (r26 & 64) != 0 ? new Function2<T, T, FixedThreshold>() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                                                            /* JADX WARN: Can't rename method to resolve collision */
                                                            @Override // kotlin.jvm.functions.Function2
                                                            public final FixedThreshold invoke(T t, T t2) {
                                                                return new FixedThreshold(Dp.m6389constructorimpl(56), null);
                                                            }
                                                        } : null, (r26 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, MapsKt.mapOf(TuplesKt.to(Float.valueOf(f13), BackdropValue.Concealed), TuplesKt.to(Float.valueOf(f19), BackdropValue.Revealed)).keySet(), 0.0f, 0.0f, 6, null) : null, (r26 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1791getVelocityThresholdD9Ej5fM() : 0.0f);
                                                        final BackdropScaffoldState backdropScaffoldState6 = backdropScaffoldState5;
                                                        final CoroutineScope coroutineScope2 = coroutineScope;
                                                        Modifier semantics$default = SemanticsModifierKt.semantics$default(m1792swipeablepPrIpRY, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1
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
                                                                if (BackdropScaffoldState.this.isConcealed()) {
                                                                    final BackdropScaffoldState backdropScaffoldState7 = BackdropScaffoldState.this;
                                                                    final CoroutineScope coroutineScope3 = coroutineScope2;
                                                                    SemanticsPropertiesKt.collapse$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1.1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(0);
                                                                        }

                                                                        /* compiled from: BackdropScaffold.kt */
                                                                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                                                        @DebugMetadata(c = "androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1$1$1", f = "BackdropScaffold.kt", i = {}, l = {332}, m = "invokeSuspend", n = {}, s = {})
                                                                        /* renamed from: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1$1$1, reason: invalid class name and collision with other inner class name */
                                                                        static final class C00361 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                                            final /* synthetic */ BackdropScaffoldState $scaffoldState;
                                                                            int label;

                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            C00361(BackdropScaffoldState backdropScaffoldState, Continuation<? super C00361> continuation) {
                                                                                super(2, continuation);
                                                                                this.$scaffoldState = backdropScaffoldState;
                                                                            }

                                                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                                                return new C00361(this.$scaffoldState, continuation);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function2
                                                                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                                                return ((C00361) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                                            }

                                                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                            public final Object invokeSuspend(Object obj) {
                                                                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                                                int i = this.label;
                                                                                if (i == 0) {
                                                                                    ResultKt.throwOnFailure(obj);
                                                                                    this.label = 1;
                                                                                    if (this.$scaffoldState.reveal(this) == coroutine_suspended) {
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
                                                                            if (BackdropScaffoldState.this.getConfirmStateChange$material_release().invoke(BackdropValue.Revealed).booleanValue()) {
                                                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new C00361(BackdropScaffoldState.this, null), 3, null);
                                                                            }
                                                                            return true;
                                                                        }
                                                                    }, 1, null);
                                                                } else {
                                                                    final BackdropScaffoldState backdropScaffoldState8 = BackdropScaffoldState.this;
                                                                    final CoroutineScope coroutineScope4 = coroutineScope2;
                                                                    SemanticsPropertiesKt.expand$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1.2
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(0);
                                                                        }

                                                                        /* compiled from: BackdropScaffold.kt */
                                                                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                                                        @DebugMetadata(c = "androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1$2$1", f = "BackdropScaffold.kt", i = {}, l = {338}, m = "invokeSuspend", n = {}, s = {})
                                                                        /* renamed from: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1$2$1, reason: invalid class name */
                                                                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                                            final /* synthetic */ BackdropScaffoldState $scaffoldState;
                                                                            int label;

                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            AnonymousClass1(BackdropScaffoldState backdropScaffoldState, Continuation<? super AnonymousClass1> continuation) {
                                                                                super(2, continuation);
                                                                                this.$scaffoldState = backdropScaffoldState;
                                                                            }

                                                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                                                return new AnonymousClass1(this.$scaffoldState, continuation);
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
                                                                                    if (this.$scaffoldState.conceal(this) == coroutine_suspended) {
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
                                                                            if (BackdropScaffoldState.this.getConfirmStateChange$material_release().invoke(BackdropValue.Concealed).booleanValue()) {
                                                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope4, null, null, new AnonymousClass1(BackdropScaffoldState.this, null), 3, null);
                                                                            }
                                                                            return true;
                                                                        }
                                                                    }, 1, null);
                                                                }
                                                            }
                                                        }, 1, null);
                                                        Modifier.Companion companion2 = Modifier.INSTANCE;
                                                        composer4.startReplaceableGroup(1686360964);
                                                        boolean changed2 = composer4.changed(backdropScaffoldState5);
                                                        final BackdropScaffoldState backdropScaffoldState7 = backdropScaffoldState5;
                                                        Object rememberedValue3 = composer4.rememberedValue();
                                                        if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                            rememberedValue3 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$1$1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public /* bridge */ /* synthetic */ IntOffset invoke(Density density) {
                                                                    return IntOffset.m6508boximpl(m1542invokeBjo55l4(density));
                                                                }

                                                                /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                                                                public final long m1542invokeBjo55l4(Density density) {
                                                                    return IntOffsetKt.IntOffset(0, MathKt.roundToInt(BackdropScaffoldState.this.getOffset().getValue().floatValue()));
                                                                }
                                                            };
                                                            composer4.updateRememberedValue(rememberedValue3);
                                                        }
                                                        composer4.endReplaceableGroup();
                                                        Modifier then = OffsetKt.offset(companion2, (Function1) rememberedValue3).then(semantics$default);
                                                        Shape shape8 = shape7;
                                                        long j23 = j19;
                                                        long j24 = j20;
                                                        float f20 = f14;
                                                        final float f21 = f16;
                                                        final Function2<Composer, Integer, Unit> function29 = function28;
                                                        final long j25 = j21;
                                                        final BackdropScaffoldState backdropScaffoldState8 = backdropScaffoldState5;
                                                        final boolean z14 = z13;
                                                        final CoroutineScope coroutineScope3 = coroutineScope;
                                                        SurfaceKt.m1782SurfaceFjzlyU(then, shape8, j23, j24, null, f20, ComposableLambdaKt.composableLambda(composer4, -1065299503, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt.BackdropScaffold.1.1.2
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

                                                            public final void invoke(Composer composer5, int i30) {
                                                                ComposerKt.sourceInformation(composer5, "C353@15563L543:BackdropScaffold.kt#jmzs0o");
                                                                if ((i30 & 11) != 2 || !composer5.getSkipping()) {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(-1065299503, i30, -1, "androidx.compose.material.BackdropScaffold.<anonymous>.<anonymous>.<anonymous> (BackdropScaffold.kt:353)");
                                                                    }
                                                                    Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, f21, 7, null);
                                                                    Function2<Composer, Integer, Unit> function210 = function29;
                                                                    long j26 = j25;
                                                                    final BackdropScaffoldState backdropScaffoldState9 = backdropScaffoldState8;
                                                                    final boolean z15 = z14;
                                                                    final CoroutineScope coroutineScope4 = coroutineScope3;
                                                                    composer5.startReplaceableGroup(733328855);
                                                                    ComposerKt.sourceInformation(composer5, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer5, 0);
                                                                    composer5.startReplaceableGroup(-1323940314);
                                                                    ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                                    CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
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
                                                                    ComposerKt.sourceInformationMarkerStart(composer5, 967343230, "C354@15628L19,355@15668L420:BackdropScaffold.kt#jmzs0o");
                                                                    function210.invoke(composer5, 0);
                                                                    BackdropScaffoldKt.m1539Scrim3JVO9M(j26, new Function0<Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$2$1$1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(0);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function0
                                                                        public /* bridge */ /* synthetic */ Unit invoke() {
                                                                            invoke2();
                                                                            return Unit.INSTANCE;
                                                                        }

                                                                        /* compiled from: BackdropScaffold.kt */
                                                                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                                                        @DebugMetadata(c = "androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$2$1$1$1", f = "BackdropScaffold.kt", i = {}, l = {360}, m = "invokeSuspend", n = {}, s = {})
                                                                        /* renamed from: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$2$1$1$1, reason: invalid class name */
                                                                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                                            final /* synthetic */ BackdropScaffoldState $scaffoldState;
                                                                            int label;

                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            AnonymousClass1(BackdropScaffoldState backdropScaffoldState, Continuation<? super AnonymousClass1> continuation) {
                                                                                super(2, continuation);
                                                                                this.$scaffoldState = backdropScaffoldState;
                                                                            }

                                                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                                                return new AnonymousClass1(this.$scaffoldState, continuation);
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
                                                                                    if (this.$scaffoldState.conceal(this) == coroutine_suspended) {
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

                                                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                        public final void invoke2() {
                                                                            if (z15 && backdropScaffoldState9.getConfirmStateChange$material_release().invoke(BackdropValue.Concealed).booleanValue()) {
                                                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope4, null, null, new AnonymousClass1(backdropScaffoldState9, null), 3, null);
                                                                            }
                                                                        }
                                                                    }, backdropScaffoldState9.getTargetValue() == BackdropValue.Revealed, composer5, 0);
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
                                                        }), composer4, 1572864, 16);
                                                        Modifier.Companion companion3 = Modifier.INSTANCE;
                                                        if (backdropScaffoldState5.isRevealed() && f19 == m6344getMaxHeightimpl - f12) {
                                                            m6389constructorimpl = f15;
                                                        } else {
                                                            m6389constructorimpl = Dp.m6389constructorimpl(0);
                                                        }
                                                        Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(companion3, 0.0f, 0.0f, 0.0f, m6389constructorimpl, 7, null);
                                                        Alignment bottomCenter = Alignment.INSTANCE.getBottomCenter();
                                                        Function3<SnackbarHostState, Composer, Integer, Unit> function37 = function36;
                                                        BackdropScaffoldState backdropScaffoldState9 = backdropScaffoldState5;
                                                        composer4.startReplaceableGroup(733328855);
                                                        ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(bottomCenter, false, composer4, 6);
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
                                                        Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                        }
                                                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer4)), composer4, 0);
                                                        composer4.startReplaceableGroup(2058660585);
                                                        ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                        ComposerKt.sourceInformationMarkerStart(composer4, 1395535709, "C377@16524L45:BackdropScaffold.kt#jmzs0o");
                                                        function37.invoke(backdropScaffoldState9.getSnackbarHostState(), composer4, 0);
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
                                            }), composer3, 3120);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                };
                                Shape shape7 = shape4;
                                Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function36 = function34;
                                int i27 = i21 << 6;
                                SurfaceKt.m1782SurfaceFjzlyU(null, null, j6, j7, null, 0.0f, ComposableLambdaKt.composableLambda(startRestartGroup, -1049909631, true, function26), startRestartGroup, (i27 & 7168) | (i27 & 896) | 1572864, 51);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                shape5 = shape7;
                                composer2 = startRestartGroup;
                                z7 = z6;
                                z8 = z5;
                                f7 = m1536getHeaderHeightD9Ej5fM;
                                backdropScaffoldState3 = backdropScaffoldState2;
                                z9 = z4;
                                j12 = j7;
                                j13 = j11;
                                long j19 = j9;
                                f8 = f9;
                                j14 = j10;
                                function35 = function36;
                                modifier3 = modifier2;
                                j15 = j19;
                            } else {
                                shape4 = shape6;
                                f6 = f5;
                                function33 = function3;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i3 & 16) != 0) {
                                i12 &= -57345;
                            }
                            if ((i3 & 1024) != 0) {
                                i16 &= -15;
                            }
                            if ((i3 & 2048) != 0) {
                                i16 &= -113;
                            }
                            i20 = i16;
                            if ((i3 & 4096) != 0) {
                                i20 &= -897;
                            }
                            if ((i3 & 16384) != 0) {
                                i20 &= -57345;
                            }
                            if ((i3 & 32768) != 0) {
                                i20 &= -458753;
                            }
                            if ((i3 & 65536) != 0) {
                                i20 &= -3670017;
                            }
                            modifier2 = modifier;
                            backdropScaffoldState2 = backdropScaffoldState;
                            m1536getHeaderHeightD9Ej5fM = f2;
                            z5 = z2;
                            z6 = z3;
                            j7 = j2;
                            f6 = f3;
                            j10 = j3;
                            j9 = j4;
                            j11 = j5;
                            function33 = function3;
                            shape4 = shape2;
                            m1537getPeekHeightD9Ej5fM = f4;
                            j6 = j;
                        }
                        i21 = i20;
                        i22 = i12;
                        startRestartGroup.endDefaults();
                        final float f92 = f6;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume3 = startRestartGroup.consume(localDensity3);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        final float mo630toPx0680j_43 = ((Density) consume3).mo630toPx0680j_4(m1537getPeekHeightD9Ej5fM);
                        ProvidableCompositionLocal<Density> localDensity22 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume22 = startRestartGroup.consume(localDensity22);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        final float mo630toPx0680j_422 = ((Density) consume22).mo630toPx0680j_4(m1536getHeaderHeightD9Ej5fM);
                        final Function2<? super Composer, ? super Integer, Unit> composableLambda2 = ComposableLambdaKt.composableLambda(startRestartGroup, 1744778315, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$backLayer$1
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

                            public final void invoke(Composer composer3, int i272) {
                                ComposerKt.sourceInformation(composer3, "C:BackdropScaffold.kt#jmzs0o");
                                if ((i272 & 11) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1744778315, i272, -1, "androidx.compose.material.BackdropScaffold.<anonymous> (BackdropScaffold.kt:281)");
                                    }
                                    if (z5) {
                                        composer3.startReplaceableGroup(-1017265285);
                                        ComposerKt.sourceInformation(composer3, "282@12922L82");
                                        Function2<Composer, Integer, Unit> function252 = function2;
                                        Function2<Composer, Integer, Unit> function262 = function22;
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
                                        ComposerKt.sourceInformationMarkerStart(composer3, -1993300157, "C283@12947L8,284@12972L18:BackdropScaffold.kt#jmzs0o");
                                        function252.invoke(composer3, 0);
                                        function262.invoke(composer3, 0);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        composer3.endReplaceableGroup();
                                        composer3.endNode();
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                    } else {
                                        composer3.startReplaceableGroup(-1017265173);
                                        ComposerKt.sourceInformation(composer3, "287@13034L72");
                                        BackdropScaffoldKt.BackLayerTransition(backdropScaffoldState2.getTargetValue(), function2, function22, composer3, 0);
                                        composer3.endReplaceableGroup();
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        });
                        startRestartGroup.startReplaceableGroup(1686358917);
                        changed = startRestartGroup.changed(mo630toPx0680j_422);
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (!changed) {
                        }
                        rememberedValue = (Function1) new Function1<Constraints, Constraints>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Constraints invoke(Constraints constraints) {
                                return Constraints.m6333boximpl(m1543invokeZezNO4M(constraints.getValue()));
                            }

                            /* renamed from: invoke-ZezNO4M, reason: not valid java name */
                            public final long m1543invokeZezNO4M(long j162) {
                                return ConstraintsKt.m6362offsetNN6EwU$default(Constraints.m6336copyZbe2FdA$default(j162, 0, 0, 0, 0, 10, null), 0, -MathKt.roundToInt(mo630toPx0680j_422), 1, null);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                        final Function1<? super Constraints, Constraints> function12 = (Function1) rememberedValue;
                        startRestartGroup.endReplaceableGroup();
                        final float f102 = m1536getHeaderHeightD9Ej5fM;
                        final BackdropScaffoldState backdropScaffoldState42 = backdropScaffoldState2;
                        final float f112 = m1537getPeekHeightD9Ej5fM;
                        final boolean z102 = z6;
                        final boolean z112 = z4;
                        final Function2<? super Composer, ? super Integer, Unit> function252 = function24;
                        final long j162 = j9;
                        final Modifier modifier42 = modifier2;
                        final long j172 = j10;
                        final long j182 = j11;
                        Function2<Composer, Integer, Unit> function262 = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1
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

                            public final void invoke(Composer composer3, int i272) {
                                ComposerKt.sourceInformation(composer3, "C299@13441L24,300@13474L3119:BackdropScaffold.kt#jmzs0o");
                                if ((i272 & 11) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1049909631, i272, -1, "androidx.compose.material.BackdropScaffold.<anonymous> (BackdropScaffold.kt:299)");
                                    }
                                    composer3.startReplaceableGroup(773894976);
                                    ComposerKt.sourceInformation(composer3, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                                    composer3.startReplaceableGroup(-492369756);
                                    ComposerKt.sourceInformation(composer3, "CC(remember):Composables.kt#9igjgp");
                                    Object rememberedValue2 = composer3.rememberedValue();
                                    if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer3));
                                        composer3.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                                        rememberedValue2 = compositionScopedCoroutineScopeCanceller;
                                    }
                                    composer3.endReplaceableGroup();
                                    final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue2).getCoroutineScope();
                                    composer3.endReplaceableGroup();
                                    Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.this, 0.0f, 1, null);
                                    Function2<Composer, Integer, Unit> function27 = composableLambda2;
                                    Function1<Constraints, Constraints> function122 = function12;
                                    final float f12 = mo630toPx0680j_422;
                                    final boolean z12 = z102;
                                    final boolean z13 = z112;
                                    final BackdropScaffoldState backdropScaffoldState5 = backdropScaffoldState42;
                                    final float f13 = mo630toPx0680j_43;
                                    final Shape shape72 = shape4;
                                    final long j192 = j172;
                                    final long j20 = j162;
                                    final float f14 = f92;
                                    final float f15 = f102;
                                    final float f16 = f112;
                                    final Function2<? super Composer, ? super Integer, Unit> function28 = function252;
                                    final long j21 = j182;
                                    final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function362 = function34;
                                    BackdropScaffoldKt.BackdropStack(fillMaxSize$default, function27, function122, ComposableLambdaKt.composableLambda(composer3, 1800047509, true, new Function4<Constraints, Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(4);
                                        }

                                        @Override // kotlin.jvm.functions.Function4
                                        public /* bridge */ /* synthetic */ Unit invoke(Constraints constraints, Float f17, Composer composer4, Integer num) {
                                            m1541invokejYbf7pk(constraints.getValue(), f17.floatValue(), composer4, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke-jYbf7pk, reason: not valid java name */
                                        public final void m1541invokejYbf7pk(long j22, float f17, Composer composer4, int i28) {
                                            int i29;
                                            Modifier.Companion companion;
                                            Modifier m1792swipeablepPrIpRY;
                                            float m6389constructorimpl;
                                            ComposerKt.sourceInformation(composer4, "CP(1:c#ui.unit.Constraints)344@15178L942,368@16163L420:BackdropScaffold.kt#jmzs0o");
                                            if ((i28 & 14) == 0) {
                                                i29 = i28 | (composer4.changed(j22) ? 4 : 2);
                                            } else {
                                                i29 = i28;
                                            }
                                            if ((i28 & 112) == 0) {
                                                i29 |= composer4.changed(f17) ? 32 : 16;
                                            }
                                            if ((i29 & 731) != 146 || !composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1800047509, i29, -1, "androidx.compose.material.BackdropScaffold.<anonymous>.<anonymous> (BackdropScaffold.kt:305)");
                                                }
                                                float m6344getMaxHeightimpl = Constraints.m6344getMaxHeightimpl(j22);
                                                float f18 = m6344getMaxHeightimpl - f12;
                                                if (z12) {
                                                    f18 = Math.min(f18, f17);
                                                }
                                                float f19 = f18;
                                                if (z13) {
                                                    companion = NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, backdropScaffoldState5.getNestedScrollConnection(), null, 2, null);
                                                } else {
                                                    companion = Modifier.INSTANCE;
                                                }
                                                m1792swipeablepPrIpRY = SwipeableKt.m1792swipeablepPrIpRY(Modifier.INSTANCE.then(companion), backdropScaffoldState5, r17, Orientation.Vertical, (r26 & 8) != 0 ? true : z13, (r26 & 16) != 0 ? false : false, (r26 & 32) != 0 ? null : null, (r26 & 64) != 0 ? new Function2<T, T, FixedThreshold>() { // from class: androidx.compose.material.SwipeableKt$swipeable$1
                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                    @Override // kotlin.jvm.functions.Function2
                                                    public final FixedThreshold invoke(T t, T t2) {
                                                        return new FixedThreshold(Dp.m6389constructorimpl(56), null);
                                                    }
                                                } : null, (r26 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, MapsKt.mapOf(TuplesKt.to(Float.valueOf(f13), BackdropValue.Concealed), TuplesKt.to(Float.valueOf(f19), BackdropValue.Revealed)).keySet(), 0.0f, 0.0f, 6, null) : null, (r26 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1791getVelocityThresholdD9Ej5fM() : 0.0f);
                                                final BackdropScaffoldState backdropScaffoldState6 = backdropScaffoldState5;
                                                final CoroutineScope coroutineScope2 = coroutineScope;
                                                Modifier semantics$default = SemanticsModifierKt.semantics$default(m1792swipeablepPrIpRY, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1
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
                                                        if (BackdropScaffoldState.this.isConcealed()) {
                                                            final BackdropScaffoldState backdropScaffoldState7 = BackdropScaffoldState.this;
                                                            final CoroutineScope coroutineScope3 = coroutineScope2;
                                                            SemanticsPropertiesKt.collapse$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(0);
                                                                }

                                                                /* compiled from: BackdropScaffold.kt */
                                                                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                                                @DebugMetadata(c = "androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1$1$1", f = "BackdropScaffold.kt", i = {}, l = {332}, m = "invokeSuspend", n = {}, s = {})
                                                                /* renamed from: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1$1$1, reason: invalid class name and collision with other inner class name */
                                                                static final class C00361 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                                    final /* synthetic */ BackdropScaffoldState $scaffoldState;
                                                                    int label;

                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    C00361(BackdropScaffoldState backdropScaffoldState, Continuation<? super C00361> continuation) {
                                                                        super(2, continuation);
                                                                        this.$scaffoldState = backdropScaffoldState;
                                                                    }

                                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                                        return new C00361(this.$scaffoldState, continuation);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function2
                                                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                                        return ((C00361) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                                    }

                                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                    public final Object invokeSuspend(Object obj) {
                                                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                                        int i = this.label;
                                                                        if (i == 0) {
                                                                            ResultKt.throwOnFailure(obj);
                                                                            this.label = 1;
                                                                            if (this.$scaffoldState.reveal(this) == coroutine_suspended) {
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
                                                                    if (BackdropScaffoldState.this.getConfirmStateChange$material_release().invoke(BackdropValue.Revealed).booleanValue()) {
                                                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope3, null, null, new C00361(BackdropScaffoldState.this, null), 3, null);
                                                                    }
                                                                    return true;
                                                                }
                                                            }, 1, null);
                                                        } else {
                                                            final BackdropScaffoldState backdropScaffoldState8 = BackdropScaffoldState.this;
                                                            final CoroutineScope coroutineScope4 = coroutineScope2;
                                                            SemanticsPropertiesKt.expand$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1.2
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(0);
                                                                }

                                                                /* compiled from: BackdropScaffold.kt */
                                                                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                                                @DebugMetadata(c = "androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1$2$1", f = "BackdropScaffold.kt", i = {}, l = {338}, m = "invokeSuspend", n = {}, s = {})
                                                                /* renamed from: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1$2$1, reason: invalid class name */
                                                                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                                    final /* synthetic */ BackdropScaffoldState $scaffoldState;
                                                                    int label;

                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    AnonymousClass1(BackdropScaffoldState backdropScaffoldState, Continuation<? super AnonymousClass1> continuation) {
                                                                        super(2, continuation);
                                                                        this.$scaffoldState = backdropScaffoldState;
                                                                    }

                                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                                        return new AnonymousClass1(this.$scaffoldState, continuation);
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
                                                                            if (this.$scaffoldState.conceal(this) == coroutine_suspended) {
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
                                                                    if (BackdropScaffoldState.this.getConfirmStateChange$material_release().invoke(BackdropValue.Concealed).booleanValue()) {
                                                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope4, null, null, new AnonymousClass1(BackdropScaffoldState.this, null), 3, null);
                                                                    }
                                                                    return true;
                                                                }
                                                            }, 1, null);
                                                        }
                                                    }
                                                }, 1, null);
                                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                                composer4.startReplaceableGroup(1686360964);
                                                boolean changed2 = composer4.changed(backdropScaffoldState5);
                                                final BackdropScaffoldState backdropScaffoldState7 = backdropScaffoldState5;
                                                Object rememberedValue3 = composer4.rememberedValue();
                                                if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue3 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$1$1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public /* bridge */ /* synthetic */ IntOffset invoke(Density density) {
                                                            return IntOffset.m6508boximpl(m1542invokeBjo55l4(density));
                                                        }

                                                        /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                                                        public final long m1542invokeBjo55l4(Density density) {
                                                            return IntOffsetKt.IntOffset(0, MathKt.roundToInt(BackdropScaffoldState.this.getOffset().getValue().floatValue()));
                                                        }
                                                    };
                                                    composer4.updateRememberedValue(rememberedValue3);
                                                }
                                                composer4.endReplaceableGroup();
                                                Modifier then = OffsetKt.offset(companion2, (Function1) rememberedValue3).then(semantics$default);
                                                Shape shape8 = shape72;
                                                long j23 = j192;
                                                long j24 = j20;
                                                float f20 = f14;
                                                final float f21 = f16;
                                                final Function2<? super Composer, ? super Integer, Unit> function29 = function28;
                                                final long j25 = j21;
                                                final BackdropScaffoldState backdropScaffoldState8 = backdropScaffoldState5;
                                                final boolean z14 = z13;
                                                final CoroutineScope coroutineScope3 = coroutineScope;
                                                SurfaceKt.m1782SurfaceFjzlyU(then, shape8, j23, j24, null, f20, ComposableLambdaKt.composableLambda(composer4, -1065299503, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt.BackdropScaffold.1.1.2
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

                                                    public final void invoke(Composer composer5, int i30) {
                                                        ComposerKt.sourceInformation(composer5, "C353@15563L543:BackdropScaffold.kt#jmzs0o");
                                                        if ((i30 & 11) != 2 || !composer5.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-1065299503, i30, -1, "androidx.compose.material.BackdropScaffold.<anonymous>.<anonymous>.<anonymous> (BackdropScaffold.kt:353)");
                                                            }
                                                            Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, f21, 7, null);
                                                            Function2<Composer, Integer, Unit> function210 = function29;
                                                            long j26 = j25;
                                                            final BackdropScaffoldState backdropScaffoldState9 = backdropScaffoldState8;
                                                            final boolean z15 = z14;
                                                            final CoroutineScope coroutineScope4 = coroutineScope3;
                                                            composer5.startReplaceableGroup(733328855);
                                                            ComposerKt.sourceInformation(composer5, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer5, 0);
                                                            composer5.startReplaceableGroup(-1323940314);
                                                            ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                            CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
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
                                                            ComposerKt.sourceInformationMarkerStart(composer5, 967343230, "C354@15628L19,355@15668L420:BackdropScaffold.kt#jmzs0o");
                                                            function210.invoke(composer5, 0);
                                                            BackdropScaffoldKt.m1539Scrim3JVO9M(j26, new Function0<Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$2$1$1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(0);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function0
                                                                public /* bridge */ /* synthetic */ Unit invoke() {
                                                                    invoke2();
                                                                    return Unit.INSTANCE;
                                                                }

                                                                /* compiled from: BackdropScaffold.kt */
                                                                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                                                @DebugMetadata(c = "androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$2$1$1$1", f = "BackdropScaffold.kt", i = {}, l = {360}, m = "invokeSuspend", n = {}, s = {})
                                                                /* renamed from: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$2$1$1$1, reason: invalid class name */
                                                                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                                    final /* synthetic */ BackdropScaffoldState $scaffoldState;
                                                                    int label;

                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    AnonymousClass1(BackdropScaffoldState backdropScaffoldState, Continuation<? super AnonymousClass1> continuation) {
                                                                        super(2, continuation);
                                                                        this.$scaffoldState = backdropScaffoldState;
                                                                    }

                                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                                        return new AnonymousClass1(this.$scaffoldState, continuation);
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
                                                                            if (this.$scaffoldState.conceal(this) == coroutine_suspended) {
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

                                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                public final void invoke2() {
                                                                    if (z15 && backdropScaffoldState9.getConfirmStateChange$material_release().invoke(BackdropValue.Concealed).booleanValue()) {
                                                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope4, null, null, new AnonymousClass1(backdropScaffoldState9, null), 3, null);
                                                                    }
                                                                }
                                                            }, backdropScaffoldState9.getTargetValue() == BackdropValue.Revealed, composer5, 0);
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
                                                }), composer4, 1572864, 16);
                                                Modifier.Companion companion3 = Modifier.INSTANCE;
                                                if (backdropScaffoldState5.isRevealed() && f19 == m6344getMaxHeightimpl - f12) {
                                                    m6389constructorimpl = f15;
                                                } else {
                                                    m6389constructorimpl = Dp.m6389constructorimpl(0);
                                                }
                                                Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(companion3, 0.0f, 0.0f, 0.0f, m6389constructorimpl, 7, null);
                                                Alignment bottomCenter = Alignment.INSTANCE.getBottomCenter();
                                                Function3<SnackbarHostState, Composer, Integer, Unit> function37 = function362;
                                                BackdropScaffoldState backdropScaffoldState9 = backdropScaffoldState5;
                                                composer4.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(bottomCenter, false, composer4, 6);
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
                                                Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                }
                                                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer4)), composer4, 0);
                                                composer4.startReplaceableGroup(2058660585);
                                                ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer4, 1395535709, "C377@16524L45:BackdropScaffold.kt#jmzs0o");
                                                function37.invoke(backdropScaffoldState9.getSnackbarHostState(), composer4, 0);
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
                                    }), composer3, 3120);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        };
                        Shape shape72 = shape4;
                        Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function362 = function34;
                        int i272 = i21 << 6;
                        SurfaceKt.m1782SurfaceFjzlyU(null, null, j6, j7, null, 0.0f, ComposableLambdaKt.composableLambda(startRestartGroup, -1049909631, true, function262), startRestartGroup, (i272 & 7168) | (i272 & 896) | 1572864, 51);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        shape5 = shape72;
                        composer2 = startRestartGroup;
                        z7 = z6;
                        z8 = z5;
                        f7 = m1536getHeaderHeightD9Ej5fM;
                        backdropScaffoldState3 = backdropScaffoldState2;
                        z9 = z4;
                        j12 = j7;
                        j13 = j11;
                        long j192 = j9;
                        f8 = f92;
                        j14 = j10;
                        function35 = function362;
                        modifier3 = modifier2;
                        j15 = j192;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier3 = modifier;
                        backdropScaffoldState3 = backdropScaffoldState;
                        f7 = f2;
                        z8 = z2;
                        f8 = f3;
                        j14 = j3;
                        j15 = j4;
                        j13 = j5;
                        function35 = function32;
                        composer2 = startRestartGroup;
                        shape5 = shape2;
                        z9 = z4;
                        m1537getPeekHeightD9Ej5fM = f4;
                        z7 = z3;
                        j6 = j;
                        j12 = j2;
                    }
                    ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$2
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

                            public final void invoke(Composer composer3, int i28) {
                                BackdropScaffoldKt.m1538BackdropScaffoldBZszfkY(function2, function22, function23, modifier3, backdropScaffoldState3, z9, m1537getPeekHeightD9Ej5fM, f7, z8, z7, j6, j12, shape5, f8, j14, j15, j13, function35, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                            }
                        });
                        return;
                    }
                    return;
                }
                if ((i2 & 57344) == 0) {
                }
                if ((458752 & i2) == 0) {
                }
                if ((3670016 & i2) == 0) {
                }
                i15 = i3 & 131072;
                if (i15 == 0) {
                }
                i16 = i13;
                if ((i12 & 1533916891) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i24 == 0) {
                }
                if ((i3 & 16) == 0) {
                }
                if (i5 != 0) {
                }
                if (i6 == 0) {
                }
                if (i7 == 0) {
                }
                if (i9 == 0) {
                }
                if (i11 == 0) {
                }
                if ((i3 & 1024) == 0) {
                }
                if ((i3 & 2048) == 0) {
                }
                int i262 = i16;
                if ((i3 & 4096) == 0) {
                }
                if (i19 == 0) {
                }
                Shape shape62 = shape3;
                if ((i3 & 16384) == 0) {
                }
                if ((i3 & 32768) == 0) {
                }
                if ((i3 & 65536) == 0) {
                }
                if (i17 == 0) {
                }
            }
            i9 = i8;
            i10 = i3 & 512;
            if (i10 != 0) {
            }
            if ((i2 & 14) == 0) {
            }
            if ((i2 & 112) == 0) {
            }
            if ((i2 & 896) == 0) {
            }
            i14 = i3 & 8192;
            if (i14 != 0) {
            }
            if ((i2 & 57344) == 0) {
            }
            if ((458752 & i2) == 0) {
            }
            if ((3670016 & i2) == 0) {
            }
            i15 = i3 & 131072;
            if (i15 == 0) {
            }
            i16 = i13;
            if ((i12 & 1533916891) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i24 == 0) {
            }
            if ((i3 & 16) == 0) {
            }
            if (i5 != 0) {
            }
            if (i6 == 0) {
            }
            if (i7 == 0) {
            }
            if (i9 == 0) {
            }
            if (i11 == 0) {
            }
            if ((i3 & 1024) == 0) {
            }
            if ((i3 & 2048) == 0) {
            }
            int i2622 = i16;
            if ((i3 & 4096) == 0) {
            }
            if (i19 == 0) {
            }
            Shape shape622 = shape3;
            if ((i3 & 16384) == 0) {
            }
            if ((i3 & 32768) == 0) {
            }
            if ((i3 & 65536) == 0) {
            }
            if (i17 == 0) {
            }
        }
        int i252 = 8192;
        if ((i & 57344) == 0) {
        }
        i5 = i3 & 32;
        if (i5 == 0) {
        }
        i6 = i3 & 64;
        if (i6 == 0) {
        }
        i7 = i3 & 128;
        if (i7 == 0) {
        }
        i8 = i3 & 256;
        if (i8 == 0) {
        }
        i9 = i8;
        i10 = i3 & 512;
        if (i10 != 0) {
        }
        if ((i2 & 14) == 0) {
        }
        if ((i2 & 112) == 0) {
        }
        if ((i2 & 896) == 0) {
        }
        i14 = i3 & 8192;
        if (i14 != 0) {
        }
        if ((i2 & 57344) == 0) {
        }
        if ((458752 & i2) == 0) {
        }
        if ((3670016 & i2) == 0) {
        }
        i15 = i3 & 131072;
        if (i15 == 0) {
        }
        i16 = i13;
        if ((i12 & 1533916891) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i24 == 0) {
        }
        if ((i3 & 16) == 0) {
        }
        if (i5 != 0) {
        }
        if (i6 == 0) {
        }
        if (i7 == 0) {
        }
        if (i9 == 0) {
        }
        if (i11 == 0) {
        }
        if ((i3 & 1024) == 0) {
        }
        if ((i3 & 2048) == 0) {
        }
        int i26222 = i16;
        if ((i3 & 4096) == 0) {
        }
        if (i19 == 0) {
        }
        Shape shape6222 = shape3;
        if ((i3 & 16384) == 0) {
        }
        if ((i3 & 32768) == 0) {
        }
        if ((i3 & 65536) == 0) {
        }
        if (i17 == 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Scrim-3J-VO9M, reason: not valid java name */
    public static final void m1539Scrim3JVO9M(final long j, final Function0<Unit> function0, final boolean z, Composer composer, final int i) {
        int i2;
        Modifier.Companion companion;
        Composer startRestartGroup = composer.startRestartGroup(-92141505);
        ComposerKt.sourceInformation(startRestartGroup, "C(Scrim)P(0:c#ui.graphics.Color)390@16754L121,399@17055L171:BackdropScaffold.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i2 & 731) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-92141505, i2, -1, "androidx.compose.material.Scrim (BackdropScaffold.kt:388)");
            }
            if (j != Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                final State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, null, startRestartGroup, 48, 28);
                if (z) {
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    Unit unit = Unit.INSTANCE;
                    startRestartGroup.startReplaceableGroup(1686362685);
                    boolean changedInstance = startRestartGroup.changedInstance(function0);
                    BackdropScaffoldKt$Scrim$dismissModifier$1$1 rememberedValue = startRestartGroup.rememberedValue();
                    if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new BackdropScaffoldKt$Scrim$dismissModifier$1$1(function0, null);
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    startRestartGroup.endReplaceableGroup();
                    companion = SuspendingPointerInputFilterKt.pointerInput(companion2, unit, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue);
                } else {
                    companion = Modifier.INSTANCE;
                }
                Modifier then = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then(companion);
                startRestartGroup.startReplaceableGroup(1686362888);
                boolean changed = startRestartGroup.changed(j) | startRestartGroup.changed(animateFloatAsState);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$Scrim$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                            invoke2(drawScope);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(DrawScope drawScope) {
                            float Scrim_3J_VO9M$lambda$4;
                            long j2 = j;
                            Scrim_3J_VO9M$lambda$4 = BackdropScaffoldKt.Scrim_3J_VO9M$lambda$4(animateFloatAsState);
                            DrawScope.m4607drawRectnJ9OG0$default(drawScope, j2, 0L, 0L, Scrim_3J_VO9M$lambda$4, null, null, 0, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, null);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceableGroup();
                CanvasKt.Canvas(then, (Function1) rememberedValue2, startRestartGroup, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$Scrim$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    BackdropScaffoldKt.m1539Scrim3JVO9M(j, function0, z, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BackLayerTransition(final BackdropValue backdropValue, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-950970976);
        ComposerKt.sourceInformation(startRestartGroup, "C(BackLayerTransition)P(2)423@17886L112,*426@18048L7,431@18222L486:BackdropScaffold.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(backdropValue) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 256 : 128;
        }
        int i3 = i2;
        if ((i3 & 731) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-950970976, i3, -1, "androidx.compose.material.BackLayerTransition (BackdropScaffold.kt:420)");
            }
            State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(backdropValue == BackdropValue.Revealed ? 0.0f : 2.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, null, startRestartGroup, 48, 28);
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            float mo630toPx0680j_4 = ((Density) consume).mo630toPx0680j_4(AnimationSlideOffset);
            float f = 1;
            float coerceIn = RangesKt.coerceIn(BackLayerTransition$lambda$7(animateFloatAsState) - f, 0.0f, 1.0f);
            float coerceIn2 = RangesKt.coerceIn(f - BackLayerTransition$lambda$7(animateFloatAsState), 0.0f, 1.0f);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
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
            Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1538629116, "C432@18236L226,440@18471L231:BackdropScaffold.kt#jmzs0o");
            Modifier m4224graphicsLayerAp8cVGQ$default = GraphicsLayerModifierKt.m4224graphicsLayerAp8cVGQ$default(ZIndexModifierKt.zIndex(Modifier.INSTANCE, coerceIn), 0.0f, 0.0f, coerceIn, 0.0f, (f - coerceIn) * mo630toPx0680j_4, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131051, null);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m4224graphicsLayerAp8cVGQ$default);
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
            Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -481855243, "C438@18444L8:BackdropScaffold.kt#jmzs0o");
            function2.invoke(startRestartGroup, Integer.valueOf((i3 >> 3) & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            Modifier m4224graphicsLayerAp8cVGQ$default2 = GraphicsLayerModifierKt.m4224graphicsLayerAp8cVGQ$default(ZIndexModifierKt.zIndex(Modifier.INSTANCE, coerceIn2), 0.0f, 0.0f, coerceIn2, 0.0f, (f - coerceIn2) * (-mo630toPx0680j_4), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131051, null);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(m4224graphicsLayerAp8cVGQ$default2);
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
            Updater.m3600setimpl(m3593constructorimpl3, rememberBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3593constructorimpl3.getInserting() || !Intrinsics.areEqual(m3593constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m3593constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m3593constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            modifierMaterializerOf3.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -481855004, "C446@18683L9:BackdropScaffold.kt#jmzs0o");
            function22.invoke(startRestartGroup, Integer.valueOf((i3 >> 6) & 14));
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
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackLayerTransition$2
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
                    BackdropScaffoldKt.BackLayerTransition(BackdropValue.this, function2, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BackdropStack(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final Function1<? super Constraints, Constraints> function1, final Function4<? super Constraints, ? super Float, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1248995194);
        ComposerKt.sourceInformation(startRestartGroup, "C(BackdropStack)P(3)459@18986L917:BackdropScaffold.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= startRestartGroup.changedInstance(function4) ? 2048 : 1024;
        }
        if ((i2 & 5851) != 1170 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1248995194, i2, -1, "androidx.compose.material.BackdropStack (BackdropScaffold.kt:458)");
            }
            startRestartGroup.startReplaceableGroup(1686364737);
            boolean changedInstance = startRestartGroup.changedInstance(function2) | startRestartGroup.changedInstance(function1) | startRestartGroup.changedInstance(function4);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropStack$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                        return m1544invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                    }

                    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m1544invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, final long j) {
                        final Placeable mo5333measureBRTryo0 = ((Measurable) CollectionsKt.first((List) subcomposeMeasureScope.subcompose(BackdropLayers.Back, function2))).mo5333measureBRTryo0(function1.invoke(Constraints.m6333boximpl(j)).getValue());
                        final float height = mo5333measureBRTryo0.getHeight();
                        BackdropLayers backdropLayers = BackdropLayers.Front;
                        final Function4<Constraints, Float, Composer, Integer, Unit> function42 = function4;
                        List<Measurable> subcompose = subcomposeMeasureScope.subcompose(backdropLayers, ComposableLambdaKt.composableLambdaInstance(-1222642649, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropStack$1$1$placeables$1
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
                                ComposerKt.sourceInformation(composer2, "C468@19351L40:BackdropScaffold.kt#jmzs0o");
                                if ((i3 & 11) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1222642649, i3, -1, "androidx.compose.material.BackdropStack.<anonymous>.<anonymous>.<anonymous> (BackdropScaffold.kt:468)");
                                }
                                function42.invoke(Constraints.m6333boximpl(j), Float.valueOf(height), composer2, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }));
                        ArrayList arrayList = new ArrayList(subcompose.size());
                        int size = subcompose.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            arrayList.add(subcompose.get(i3).mo5333measureBRTryo0(j));
                        }
                        final ArrayList arrayList2 = arrayList;
                        int max = Math.max(Constraints.m6347getMinWidthimpl(j), mo5333measureBRTryo0.getWidth());
                        int max2 = Math.max(Constraints.m6346getMinHeightimpl(j), mo5333measureBRTryo0.getHeight());
                        int size2 = arrayList2.size();
                        int i4 = max2;
                        int i5 = max;
                        for (int i6 = 0; i6 < size2; i6++) {
                            Placeable placeable = (Placeable) arrayList2.get(i6);
                            i5 = Math.max(i5, placeable.getWidth());
                            i4 = Math.max(i4, placeable.getHeight());
                        }
                        return MeasureScope.layout$default(subcomposeMeasureScope, i5, i4, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropStack$1$1.2
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
                                Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, 0, 0, 0.0f, 4, null);
                                List<Placeable> list = arrayList2;
                                int size3 = list.size();
                                for (int i7 = 0; i7 < size3; i7++) {
                                    Placeable.PlacementScope.placeRelative$default(placementScope, list.get(i7), 0, 0, 0.0f, 4, null);
                                }
                            }
                        }, 4, null);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(modifier, (Function2) rememberedValue, startRestartGroup, i2 & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropStack$2
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
                    BackdropScaffoldKt.BackdropStack(Modifier.this, function2, function1, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float Scrim_3J_VO9M$lambda$4(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float BackLayerTransition$lambda$7(State<Float> state) {
        return state.getValue().floatValue();
    }
}
