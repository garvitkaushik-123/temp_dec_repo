package androidx.compose.material3;

import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.material3.Strings;
import androidx.compose.material3.tokens.NavigationDrawerTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.vungle.ads.internal.protos.Sdk;
import java.util.List;
import kotlin.Metadata;
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
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: NavigationDrawer.kt */
@Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\u001al\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\t0\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001aQ\u0010\u001b\u001a\u00020\t2\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\t0\u001d¢\u0006\u0002\b\u00172\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\t0\u001d¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010\"\u001aj\u0010#\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00052\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\t0\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0003ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001al\u0010&\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\t0\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\b'\u0010\u001a\u001a`\u0010(\u001a\u00020\t2\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\t0\u001d¢\u0006\u0002\b\u00172\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010)\u001a\u00020\u000f2\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\t0\u001d¢\u0006\u0002\b\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001a\u008c\u0001\u0010,\u001a\u00020\t2\u0011\u0010-\u001a\r\u0012\u0004\u0012\u00020\t0\u001d¢\u0006\u0002\b\u00172\u0006\u0010.\u001a\u00020!2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\t0\u001d2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0015\b\u0002\u00100\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u001d¢\u0006\u0002\b\u00172\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u001d¢\u0006\u0002\b\u00172\b\b\u0002\u00102\u001a\u00020\r2\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u000206H\u0007¢\u0006\u0002\u00107\u001al\u00108\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\t0\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\b9\u0010\u001a\u001a=\u0010:\u001a\u00020\t2\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\t0\u001d¢\u0006\u0002\b\u00172\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\t0\u001d¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010;\u001a>\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020!2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\t0\u001d2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d2\u0006\u0010@\u001a\u00020\u000fH\u0003ø\u0001\u0000¢\u0006\u0004\bA\u0010B\u001a \u0010C\u001a\u00020\u00022\u0006\u0010D\u001a\u00020\u00022\u0006\u0010E\u001a\u00020\u00022\u0006\u0010F\u001a\u00020\u0002H\u0002\u001a+\u0010G\u001a\u00020\u001f2\u0006\u0010H\u001a\u00020I2\u0014\b\u0002\u0010J\u001a\u000e\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020!0\u0015H\u0007¢\u0006\u0002\u0010K\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0002X\u0082D¢\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006L"}, d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "DrawerPositionalThreshold", "DrawerVelocityThreshold", "Landroidx/compose/ui/unit/Dp;", "F", "MinimumDrawerWidth", "DismissibleDrawerSheet", "", "modifier", "Landroidx/compose/ui/Modifier;", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerContainerColor", "Landroidx/compose/ui/graphics/Color;", "drawerContentColor", "drawerTonalElevation", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "DismissibleDrawerSheet-afqeVBk", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DismissibleNavigationDrawer", "drawerContent", "Lkotlin/Function0;", "drawerState", "Landroidx/compose/material3/DrawerState;", "gesturesEnabled", "", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DrawerState;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "DrawerSheet", "DrawerSheet-vywBR7E", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ModalDrawerSheet", "ModalDrawerSheet-afqeVBk", "ModalNavigationDrawer", "scrimColor", "ModalNavigationDrawer-FHprtrg", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DrawerState;ZJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "NavigationDrawerItem", "label", "selected", "onClick", "icon", "badge", "shape", "colors", "Landroidx/compose/material3/NavigationDrawerItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/NavigationDrawerItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "PermanentDrawerSheet", "PermanentDrawerSheet-afqeVBk", "PermanentNavigationDrawer", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Scrim", "open", "onClose", "fraction", "color", "Scrim-Bx497Mc", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;JLandroidx/compose/runtime/Composer;I)V", "calculateFraction", "a", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "pos", "rememberDrawerState", "initialValue", "Landroidx/compose/material3/DrawerValue;", "confirmStateChange", "(Landroidx/compose/material3/DrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DrawerState;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NavigationDrawerKt {
    private static final float DrawerPositionalThreshold = 0.5f;
    private static final float DrawerVelocityThreshold = Dp.m6389constructorimpl(400);
    private static final float MinimumDrawerWidth = Dp.m6389constructorimpl(240);
    private static final TweenSpec<Float> AnimationSpec = new TweenSpec<>(256, 0, null, 6, null);

    public static final DrawerState rememberDrawerState(final DrawerValue drawerValue, final Function1<? super DrawerValue, Boolean> function1, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(2098699222);
        ComposerKt.sourceInformation(composer, "C(rememberDrawerState)P(1)280@10617L61,280@10553L125:NavigationDrawer.kt#uh7d8r");
        if ((i2 & 2) != 0) {
            function1 = new Function1<DrawerValue, Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$rememberDrawerState$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(DrawerValue drawerValue2) {
                    return true;
                }
            };
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2098699222, i, -1, "androidx.compose.material3.rememberDrawerState (NavigationDrawer.kt:279)");
        }
        Object[] objArr = new Object[0];
        Saver<DrawerState, DrawerValue> Saver = DrawerState.INSTANCE.Saver(function1);
        composer.startReplaceableGroup(-21510967);
        ComposerKt.sourceInformation(composer, "CC(remember):NavigationDrawer.kt#9igjgp");
        boolean z = ((((i & 14) ^ 6) > 4 && composer.changed(drawerValue)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(function1)) || (i & 48) == 32);
        Object rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = (Function0) new Function0<DrawerState>() { // from class: androidx.compose.material3.NavigationDrawerKt$rememberDrawerState$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final DrawerState invoke() {
                    return new DrawerState(DrawerValue.this, function1);
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        DrawerState drawerState = (DrawerState) RememberSaveableKt.m3680rememberSaveable(objArr, (Saver) Saver, (String) null, (Function0) rememberedValue, composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return drawerState;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0514  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0520  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x05c2  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0524  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x03ce  */
    /* renamed from: ModalNavigationDrawer-FHprtrg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2357ModalNavigationDrawerFHprtrg(Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, DrawerState drawerState, boolean z, long j, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        final DrawerState drawerState2;
        int i4;
        long j2;
        int i5;
        Modifier.Companion companion;
        boolean z2;
        long scrimColor;
        Object rememberedValue;
        boolean changed;
        Object rememberedValue2;
        int currentCompositeKeyHash;
        Composer m3593constructorimpl;
        int currentCompositeKeyHash2;
        Composer m3593constructorimpl2;
        boolean changedInstance;
        Object rememberedValue3;
        boolean changed2;
        Object rememberedValue4;
        boolean z3;
        Object rememberedValue5;
        boolean changed3;
        Object rememberedValue6;
        int currentCompositeKeyHash3;
        Composer m3593constructorimpl3;
        final DrawerState drawerState3;
        final boolean z4;
        final long j3;
        final Modifier modifier3;
        int i6;
        final Function2<? super Composer, ? super Integer, Unit> function23 = function2;
        Composer startRestartGroup = composer.startRestartGroup(-1169303680);
        ComposerKt.sourceInformation(startRestartGroup, "C(ModalNavigationDrawer)P(1,4,2,3,5:c#ui.graphics.Color)309@11871L39,311@11988L10,314@12056L24,315@12106L33,316@12171L7,320@12300L250,320@12289L261,330@12589L7,331@12624L1701:NavigationDrawer.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function23) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i & 384) != 0) {
                if ((i2 & 4) == 0) {
                    drawerState2 = drawerState;
                    if (startRestartGroup.changed(drawerState2)) {
                        i6 = 256;
                        i3 |= i6;
                    }
                } else {
                    drawerState2 = drawerState;
                }
                i6 = 128;
                i3 |= i6;
            } else {
                drawerState2 = drawerState;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                i3 |= startRestartGroup.changed(z) ? 2048 : 1024;
                if ((i & 24576) == 0) {
                    j2 = j;
                    i3 |= ((i2 & 16) == 0 && startRestartGroup.changed(j2)) ? 16384 : 8192;
                } else {
                    j2 = j;
                }
                if ((i2 & 32) == 0) {
                    if ((196608 & i) == 0) {
                        i5 = startRestartGroup.changedInstance(function22) ? 131072 : 65536;
                    }
                    if ((74899 & i3) == 74898 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            companion = i7 == 0 ? Modifier.INSTANCE : modifier2;
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                drawerState2 = rememberDrawerState(DrawerValue.Closed, null, startRestartGroup, 6, 2);
                            }
                            boolean z5 = i4 == 0 ? true : z;
                            if ((i2 & 16) == 0) {
                                i3 &= -57345;
                                z2 = z5;
                                scrimColor = DrawerDefaults.INSTANCE.getScrimColor(startRestartGroup, 6);
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1169303680, i3, -1, "androidx.compose.material3.ModalNavigationDrawer (NavigationDrawer.kt:313)");
                                }
                                startRestartGroup.startReplaceableGroup(773894976);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                                startRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                                    startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                                    rememberedValue = compositionScopedCoroutineScopeCanceller;
                                }
                                startRestartGroup.endReplaceableGroup();
                                final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                                startRestartGroup.endReplaceableGroup();
                                Strings.Companion companion2 = Strings.INSTANCE;
                                final String m2623getStringNWtq28 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(androidx.compose.ui.R.string.navigation_menu), startRestartGroup, 0);
                                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume = startRestartGroup.consume(localDensity);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                final Density density = (Density) consume;
                                final float f = -density.mo630toPx0680j_4(NavigationDrawerTokens.INSTANCE.m3283getContainerWidthD9Ej5fM());
                                startRestartGroup.startReplaceableGroup(-1870335235);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                                int i8 = (i3 & 896) ^ 384;
                                changed = ((i8 <= 256 && startRestartGroup.changed(drawerState2)) || (i3 & 384) == 256) | startRestartGroup.changed(density) | startRestartGroup.changed(f);
                                rememberedValue2 = startRestartGroup.rememberedValue();
                                if (!changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    final float f2 = 0.0f;
                                    rememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$1$1
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
                                            DrawerState.this.setDensity$material3_release(density);
                                            AnchoredDraggableState<DrawerValue> anchoredDraggableState$material3_release = DrawerState.this.getAnchoredDraggableState$material3_release();
                                            final float f3 = f;
                                            final float f4 = f2;
                                            AnchoredDraggableState.updateAnchors$default(anchoredDraggableState$material3_release, AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<DrawerValue>, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$1$1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                                                    invoke2(draggableAnchorsConfig);
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                                                    draggableAnchorsConfig.at(DrawerValue.Closed, f3);
                                                    draggableAnchorsConfig.at(DrawerValue.Open, f4);
                                                }
                                            }), null, 2, null);
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                }
                                startRestartGroup.endReplaceableGroup();
                                EffectsKt.SideEffect((Function0) rememberedValue2, startRestartGroup, 0);
                                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume2 = startRestartGroup.consume(localLayoutDirection);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                Modifier anchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), drawerState2.getAnchoredDraggableState$material3_release(), Orientation.Horizontal, z2, consume2 != LayoutDirection.Rtl, null, 16, null);
                                Modifier modifier4 = companion;
                                final boolean z6 = z2;
                                startRestartGroup.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                                startRestartGroup.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                long j4 = scrimColor;
                                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(anchoredDraggable$default);
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
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2009208343, "C341@12933L37,346@13047L264,354@13336L98,344@12979L497,361@13535L198,368@13761L507,359@13485L834:NavigationDrawer.kt#uh7d8r");
                                startRestartGroup.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                Modifier.Companion companion3 = Modifier.INSTANCE;
                                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                                startRestartGroup.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion3);
                                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                startRestartGroup.startReusableNode();
                                if (!startRestartGroup.getInserting()) {
                                    startRestartGroup.createNode(constructor2);
                                } else {
                                    startRestartGroup.useNode();
                                }
                                m3593constructorimpl2 = Updater.m3593constructorimpl(startRestartGroup);
                                Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (!m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                    m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                    m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                }
                                modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                                startRestartGroup.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -860467894, "C342@12951L9:NavigationDrawer.kt#uh7d8r");
                                function22.invoke(startRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                startRestartGroup.endReplaceableGroup();
                                startRestartGroup.endNode();
                                startRestartGroup.endReplaceableGroup();
                                startRestartGroup.endReplaceableGroup();
                                boolean isOpen = drawerState2.isOpen();
                                startRestartGroup.startReplaceableGroup(2009208457);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                                changedInstance = ((i3 & 7168) != 2048) | ((i8 <= 256 && startRestartGroup.changed(drawerState2)) || (i3 & 384) == 256) | startRestartGroup.changedInstance(coroutineScope);
                                rememberedValue3 = startRestartGroup.rememberedValue();
                                if (!changedInstance || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue3 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$2$1
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
                                            if (z6 && drawerState2.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(DrawerValue.Closed).booleanValue()) {
                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(drawerState2, null), 3, null);
                                            }
                                        }

                                        /* compiled from: NavigationDrawer.kt */
                                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                        @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$2$1$1", f = "NavigationDrawer.kt", i = {}, l = {352}, m = "invokeSuspend", n = {}, s = {})
                                        /* renamed from: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$2$1$1, reason: invalid class name */
                                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                            final /* synthetic */ DrawerState $drawerState;
                                            int label;

                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                                super(2, continuation);
                                                this.$drawerState = drawerState;
                                            }

                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                return new AnonymousClass1(this.$drawerState, continuation);
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
                                                    if (this.$drawerState.close(this) == coroutine_suspended) {
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
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue3);
                                }
                                Function0 function0 = (Function0) rememberedValue3;
                                startRestartGroup.endReplaceableGroup();
                                startRestartGroup.startReplaceableGroup(2009208746);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                                changed2 = startRestartGroup.changed(f) | ((i8 <= 256 && startRestartGroup.changed(drawerState2)) || (i3 & 384) == 256);
                                rememberedValue4 = startRestartGroup.rememberedValue();
                                if (!changed2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                    final float f3 = 0.0f;
                                    rememberedValue4 = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$3$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Float invoke() {
                                            float calculateFraction;
                                            calculateFraction = NavigationDrawerKt.calculateFraction(f, f3, drawerState2.requireOffset$material3_release());
                                            return Float.valueOf(calculateFraction);
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue4);
                                }
                                startRestartGroup.endReplaceableGroup();
                                m2359ScrimBx497Mc(isOpen, function0, (Function0) rememberedValue4, j4, startRestartGroup, (i3 >> 3) & 7168);
                                Modifier.Companion companion4 = Modifier.INSTANCE;
                                startRestartGroup.startReplaceableGroup(2009208945);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                                z3 = (i8 <= 256 && startRestartGroup.changed(drawerState2)) || (i3 & 384) == 256;
                                rememberedValue5 = startRestartGroup.rememberedValue();
                                if (!z3 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue5 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$4$1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ IntOffset invoke(Density density2) {
                                            return IntOffset.m6508boximpl(m2362invokeBjo55l4(density2));
                                        }

                                        /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                                        public final long m2362invokeBjo55l4(Density density2) {
                                            return IntOffsetKt.IntOffset(MathKt.roundToInt(DrawerState.this.requireOffset$material3_release()), 0);
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue5);
                                }
                                startRestartGroup.endReplaceableGroup();
                                Modifier offset = OffsetKt.offset(companion4, (Function1) rememberedValue5);
                                startRestartGroup.startReplaceableGroup(2009209171);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                                changed3 = ((i8 <= 256 && startRestartGroup.changed(drawerState2)) || (i3 & 384) == 256) | startRestartGroup.changed(m2623getStringNWtq28) | startRestartGroup.changedInstance(coroutineScope);
                                rememberedValue6 = startRestartGroup.rememberedValue();
                                if (!changed3 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue6 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$5$1
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
                                            SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m2623getStringNWtq28);
                                            if (drawerState2.isOpen()) {
                                                final DrawerState drawerState4 = drawerState2;
                                                final CoroutineScope coroutineScope2 = coroutineScope;
                                                SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$5$1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(0);
                                                    }

                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Boolean invoke() {
                                                        if (DrawerState.this.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(DrawerValue.Closed).booleanValue()) {
                                                            BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new C00681(DrawerState.this, null), 3, null);
                                                        }
                                                        return true;
                                                    }

                                                    /* compiled from: NavigationDrawer.kt */
                                                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                                    @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$5$1$1$1", f = "NavigationDrawer.kt", i = {}, l = {377}, m = "invokeSuspend", n = {}, s = {})
                                                    /* renamed from: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$5$1$1$1, reason: invalid class name and collision with other inner class name */
                                                    static final class C00681 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                        final /* synthetic */ DrawerState $drawerState;
                                                        int label;

                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        C00681(DrawerState drawerState, Continuation<? super C00681> continuation) {
                                                            super(2, continuation);
                                                            this.$drawerState = drawerState;
                                                        }

                                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                            return new C00681(this.$drawerState, continuation);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function2
                                                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                            return ((C00681) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                        }

                                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                        public final Object invokeSuspend(Object obj) {
                                                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                            int i = this.label;
                                                            if (i == 0) {
                                                                ResultKt.throwOnFailure(obj);
                                                                this.label = 1;
                                                                if (this.$drawerState.close(this) == coroutine_suspended) {
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
                                                }, 1, null);
                                            }
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue6);
                                }
                                startRestartGroup.endReplaceableGroup();
                                Modifier semantics$default = SemanticsModifierKt.semantics$default(offset, false, (Function1) rememberedValue6, 1, null);
                                startRestartGroup.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                                startRestartGroup.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(semantics$default);
                                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                startRestartGroup.startReusableNode();
                                if (!startRestartGroup.getInserting()) {
                                    startRestartGroup.createNode(constructor3);
                                } else {
                                    startRestartGroup.useNode();
                                }
                                m3593constructorimpl3 = Updater.m3593constructorimpl(startRestartGroup);
                                Updater.m3600setimpl(m3593constructorimpl3, rememberBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3600setimpl(m3593constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (!m3593constructorimpl3.getInserting() || !Intrinsics.areEqual(m3593constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                    m3593constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                    m3593constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                }
                                modifierMaterializerOf3.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                                startRestartGroup.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -860466551, "C382@14294L15:NavigationDrawer.kt#uh7d8r");
                                function23 = function2;
                                function23.invoke(startRestartGroup, Integer.valueOf(i3 & 14));
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
                                drawerState3 = drawerState2;
                                z4 = z6;
                                j3 = j4;
                                modifier3 = modifier4;
                            } else {
                                z2 = z5;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            z2 = z;
                            companion = modifier2;
                        }
                        scrimColor = j2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        startRestartGroup.startReplaceableGroup(773894976);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                        startRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                        }
                        startRestartGroup.endReplaceableGroup();
                        final CoroutineScope coroutineScope2 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                        startRestartGroup.endReplaceableGroup();
                        Strings.Companion companion22 = Strings.INSTANCE;
                        final String m2623getStringNWtq282 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(androidx.compose.ui.R.string.navigation_menu), startRestartGroup, 0);
                        ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume3 = startRestartGroup.consume(localDensity2);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        final Density density2 = (Density) consume3;
                        final float f4 = -density2.mo630toPx0680j_4(NavigationDrawerTokens.INSTANCE.m3283getContainerWidthD9Ej5fM());
                        startRestartGroup.startReplaceableGroup(-1870335235);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                        int i82 = (i3 & 896) ^ 384;
                        changed = ((i82 <= 256 && startRestartGroup.changed(drawerState2)) || (i3 & 384) == 256) | startRestartGroup.changed(density2) | startRestartGroup.changed(f4);
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (!changed) {
                        }
                        final float f22 = 0.0f;
                        rememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$1$1
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
                                DrawerState.this.setDensity$material3_release(density2);
                                AnchoredDraggableState<DrawerValue> anchoredDraggableState$material3_release = DrawerState.this.getAnchoredDraggableState$material3_release();
                                final float f32 = f4;
                                final float f42 = f22;
                                AnchoredDraggableState.updateAnchors$default(anchoredDraggableState$material3_release, AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<DrawerValue>, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$1$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                                        invoke2(draggableAnchorsConfig);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                                        draggableAnchorsConfig.at(DrawerValue.Closed, f32);
                                        draggableAnchorsConfig.at(DrawerValue.Open, f42);
                                    }
                                }), null, 2, null);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                        startRestartGroup.endReplaceableGroup();
                        EffectsKt.SideEffect((Function0) rememberedValue2, startRestartGroup, 0);
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume22 = startRestartGroup.consume(localLayoutDirection2);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        Modifier anchoredDraggable$default2 = AnchoredDraggableKt.anchoredDraggable$default(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), drawerState2.getAnchoredDraggableState$material3_release(), Orientation.Horizontal, z2, consume22 != LayoutDirection.Rtl, null, 16, null);
                        Modifier modifier42 = companion;
                        final boolean z62 = z2;
                        startRestartGroup.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy4 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                        startRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        long j42 = scrimColor;
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(anchoredDraggable$default2);
                        if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        }
                        startRestartGroup.startReusableNode();
                        if (!startRestartGroup.getInserting()) {
                        }
                        m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
                        Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!m3593constructorimpl.getInserting()) {
                        }
                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash4);
                        modifierMaterializerOf4.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                        startRestartGroup.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2009208343, "C341@12933L37,346@13047L264,354@13336L98,344@12979L497,361@13535L198,368@13761L507,359@13485L834:NavigationDrawer.kt#uh7d8r");
                        startRestartGroup.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        Modifier.Companion companion32 = Modifier.INSTANCE;
                        MeasurePolicy rememberBoxMeasurePolicy22 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                        startRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor22 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf22 = LayoutKt.modifierMaterializerOf(companion32);
                        if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        }
                        startRestartGroup.startReusableNode();
                        if (!startRestartGroup.getInserting()) {
                        }
                        m3593constructorimpl2 = Updater.m3593constructorimpl(startRestartGroup);
                        Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy22, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap22, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!m3593constructorimpl2.getInserting()) {
                        }
                        m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash22);
                        modifierMaterializerOf22.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                        startRestartGroup.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -860467894, "C342@12951L9:NavigationDrawer.kt#uh7d8r");
                        function22.invoke(startRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.endNode();
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.endReplaceableGroup();
                        boolean isOpen2 = drawerState2.isOpen();
                        startRestartGroup.startReplaceableGroup(2009208457);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                        changedInstance = ((i3 & 7168) != 2048) | ((i82 <= 256 && startRestartGroup.changed(drawerState2)) || (i3 & 384) == 256) | startRestartGroup.changedInstance(coroutineScope2);
                        rememberedValue3 = startRestartGroup.rememberedValue();
                        if (!changedInstance) {
                        }
                        rememberedValue3 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$2$1
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
                                if (z62 && drawerState2.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(DrawerValue.Closed).booleanValue()) {
                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new AnonymousClass1(drawerState2, null), 3, null);
                                }
                            }

                            /* compiled from: NavigationDrawer.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                            @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$2$1$1", f = "NavigationDrawer.kt", i = {}, l = {352}, m = "invokeSuspend", n = {}, s = {})
                            /* renamed from: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$2$1$1, reason: invalid class name */
                            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ DrawerState $drawerState;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                    super(2, continuation);
                                    this.$drawerState = drawerState;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new AnonymousClass1(this.$drawerState, continuation);
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
                                        if (this.$drawerState.close(this) == coroutine_suspended) {
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
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue3);
                        Function0 function02 = (Function0) rememberedValue3;
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.startReplaceableGroup(2009208746);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                        changed2 = startRestartGroup.changed(f4) | ((i82 <= 256 && startRestartGroup.changed(drawerState2)) || (i3 & 384) == 256);
                        rememberedValue4 = startRestartGroup.rememberedValue();
                        if (!changed2) {
                        }
                        final float f32 = 0.0f;
                        rememberedValue4 = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Float invoke() {
                                float calculateFraction;
                                calculateFraction = NavigationDrawerKt.calculateFraction(f4, f32, drawerState2.requireOffset$material3_release());
                                return Float.valueOf(calculateFraction);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue4);
                        startRestartGroup.endReplaceableGroup();
                        m2359ScrimBx497Mc(isOpen2, function02, (Function0) rememberedValue4, j42, startRestartGroup, (i3 >> 3) & 7168);
                        Modifier.Companion companion42 = Modifier.INSTANCE;
                        startRestartGroup.startReplaceableGroup(2009208945);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                        if (i82 <= 256) {
                        }
                        rememberedValue5 = startRestartGroup.rememberedValue();
                        if (!z3) {
                        }
                        rememberedValue5 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$4$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ IntOffset invoke(Density density22) {
                                return IntOffset.m6508boximpl(m2362invokeBjo55l4(density22));
                            }

                            /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                            public final long m2362invokeBjo55l4(Density density22) {
                                return IntOffsetKt.IntOffset(MathKt.roundToInt(DrawerState.this.requireOffset$material3_release()), 0);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue5);
                        startRestartGroup.endReplaceableGroup();
                        Modifier offset2 = OffsetKt.offset(companion42, (Function1) rememberedValue5);
                        startRestartGroup.startReplaceableGroup(2009209171);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                        changed3 = ((i82 <= 256 && startRestartGroup.changed(drawerState2)) || (i3 & 384) == 256) | startRestartGroup.changed(m2623getStringNWtq282) | startRestartGroup.changedInstance(coroutineScope2);
                        rememberedValue6 = startRestartGroup.rememberedValue();
                        if (!changed3) {
                        }
                        rememberedValue6 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$5$1
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
                                SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m2623getStringNWtq282);
                                if (drawerState2.isOpen()) {
                                    final DrawerState drawerState4 = drawerState2;
                                    final CoroutineScope coroutineScope22 = coroutineScope2;
                                    SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$5$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Boolean invoke() {
                                            if (DrawerState.this.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(DrawerValue.Closed).booleanValue()) {
                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope22, null, null, new C00681(DrawerState.this, null), 3, null);
                                            }
                                            return true;
                                        }

                                        /* compiled from: NavigationDrawer.kt */
                                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                        @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$5$1$1$1", f = "NavigationDrawer.kt", i = {}, l = {377}, m = "invokeSuspend", n = {}, s = {})
                                        /* renamed from: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$5$1$1$1, reason: invalid class name and collision with other inner class name */
                                        static final class C00681 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                            final /* synthetic */ DrawerState $drawerState;
                                            int label;

                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            C00681(DrawerState drawerState, Continuation<? super C00681> continuation) {
                                                super(2, continuation);
                                                this.$drawerState = drawerState;
                                            }

                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                return new C00681(this.$drawerState, continuation);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                return ((C00681) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                            }

                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                            public final Object invokeSuspend(Object obj) {
                                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                int i = this.label;
                                                if (i == 0) {
                                                    ResultKt.throwOnFailure(obj);
                                                    this.label = 1;
                                                    if (this.$drawerState.close(this) == coroutine_suspended) {
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
                                    }, 1, null);
                                }
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue6);
                        startRestartGroup.endReplaceableGroup();
                        Modifier semantics$default2 = SemanticsModifierKt.semantics$default(offset2, false, (Function1) rememberedValue6, 1, null);
                        startRestartGroup.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy32 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                        startRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap32 = startRestartGroup.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor32 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf32 = LayoutKt.modifierMaterializerOf(semantics$default2);
                        if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        }
                        startRestartGroup.startReusableNode();
                        if (!startRestartGroup.getInserting()) {
                        }
                        m3593constructorimpl3 = Updater.m3593constructorimpl(startRestartGroup);
                        Updater.m3600setimpl(m3593constructorimpl3, rememberBoxMeasurePolicy32, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl3, currentCompositionLocalMap32, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash32 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!m3593constructorimpl3.getInserting()) {
                        }
                        m3593constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        m3593constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash32);
                        modifierMaterializerOf32.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                        startRestartGroup.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance32 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -860466551, "C382@14294L15:NavigationDrawer.kt#uh7d8r");
                        function23 = function2;
                        function23.invoke(startRestartGroup, Integer.valueOf(i3 & 14));
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
                        }
                        drawerState3 = drawerState2;
                        z4 = z62;
                        j3 = j42;
                        modifier3 = modifier42;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        z4 = z;
                        modifier3 = modifier2;
                        drawerState3 = drawerState2;
                        j3 = j2;
                    }
                    ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3
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

                            public final void invoke(Composer composer2, int i9) {
                                NavigationDrawerKt.m2357ModalNavigationDrawerFHprtrg(function23, modifier3, drawerState3, z4, j3, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                i5 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i3 |= i5;
                if ((74899 & i3) == 74898) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i7 == 0) {
                }
                if ((i2 & 4) != 0) {
                }
                if (i4 == 0) {
                }
                if ((i2 & 16) == 0) {
                }
            }
            if ((i & 24576) == 0) {
            }
            if ((i2 & 32) == 0) {
            }
            i3 |= i5;
            if ((74899 & i3) == 74898) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i7 == 0) {
            }
            if ((i2 & 4) != 0) {
            }
            if (i4 == 0) {
            }
            if ((i2 & 16) == 0) {
            }
        }
        modifier2 = modifier;
        if ((i & 384) != 0) {
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        if ((i & 24576) == 0) {
        }
        if ((i2 & 32) == 0) {
        }
        i3 |= i5;
        if ((74899 & i3) == 74898) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i7 == 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if (i4 == 0) {
        }
        if ((i2 & 16) == 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x04b1  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x04bd  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x04e6  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x056d  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x03f2  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x057c  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x038d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DismissibleNavigationDrawer(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, DrawerState drawerState, boolean z, Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        final DrawerState drawerState2;
        int i4;
        boolean z2;
        Modifier modifier3;
        boolean z3;
        boolean changed;
        Object rememberedValue;
        Object rememberedValue2;
        int currentCompositeKeyHash;
        Composer m3593constructorimpl;
        boolean z4;
        MeasurePolicy rememberedValue3;
        int currentCompositeKeyHash2;
        Composer m3593constructorimpl2;
        boolean changed2;
        Object rememberedValue4;
        int currentCompositeKeyHash3;
        Composer m3593constructorimpl3;
        int currentCompositeKeyHash4;
        Composer m3593constructorimpl4;
        final boolean z5;
        ScopeUpdateScope endRestartGroup;
        int i5;
        final Function2<? super Composer, ? super Integer, Unit> function23 = function22;
        Composer startRestartGroup = composer.startRestartGroup(398812198);
        ComposerKt.sourceInformation(startRestartGroup, "C(DismissibleNavigationDrawer)P(1,4,2,3)412@15589L39,416@15738L7,422@15939L250,422@15928L261,432@16207L24,433@16257L33,435@16329L7,436@16364L1446:NavigationDrawer.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i & 384) != 0) {
                if ((i2 & 4) == 0) {
                    drawerState2 = drawerState;
                    if (startRestartGroup.changed(drawerState2)) {
                        i5 = 256;
                        i3 |= i5;
                    }
                } else {
                    drawerState2 = drawerState;
                }
                i5 = 128;
                i3 |= i5;
            } else {
                drawerState2 = drawerState;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                if ((i2 & 16) != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    i3 |= startRestartGroup.changedInstance(function23) ? 16384 : 8192;
                }
                if ((i3 & 9363) == 9362 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        if (i6 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            drawerState2 = rememberDrawerState(DrawerValue.Closed, null, startRestartGroup, 6, 2);
                        }
                        if (i4 != 0) {
                            modifier3 = modifier2;
                            z3 = true;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(398812198, i3, -1, "androidx.compose.material3.DismissibleNavigationDrawer (NavigationDrawer.kt:415)");
                            }
                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume = startRestartGroup.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            final Density density = (Density) consume;
                            final float f = -density.mo630toPx0680j_4(NavigationDrawerTokens.INSTANCE.m3283getContainerWidthD9Ej5fM());
                            startRestartGroup.startReplaceableGroup(171918245);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                            int i7 = (i3 & 896) ^ 384;
                            changed = ((i7 <= 256 && startRestartGroup.changed(drawerState2)) || (i3 & 384) == 256) | startRestartGroup.changed(density) | startRestartGroup.changed(f);
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                final float f2 = 0.0f;
                                rememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$1$1
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
                                        DrawerState.this.setDensity$material3_release(density);
                                        AnchoredDraggableState<DrawerValue> anchoredDraggableState$material3_release = DrawerState.this.getAnchoredDraggableState$material3_release();
                                        final float f3 = f;
                                        final float f4 = f2;
                                        AnchoredDraggableState.updateAnchors$default(anchoredDraggableState$material3_release, AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<DrawerValue>, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$1$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                                                invoke2(draggableAnchorsConfig);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                                                draggableAnchorsConfig.at(DrawerValue.Closed, f3);
                                                draggableAnchorsConfig.at(DrawerValue.Open, f4);
                                            }
                                        }), null, 2, null);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            startRestartGroup.endReplaceableGroup();
                            EffectsKt.SideEffect((Function0) rememberedValue, startRestartGroup, 0);
                            startRestartGroup.startReplaceableGroup(773894976);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                            startRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                            rememberedValue2 = startRestartGroup.rememberedValue();
                            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                                rememberedValue2 = compositionScopedCoroutineScopeCanceller;
                            }
                            startRestartGroup.endReplaceableGroup();
                            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue2).getCoroutineScope();
                            startRestartGroup.endReplaceableGroup();
                            Strings.Companion companion = Strings.INSTANCE;
                            final String m2623getStringNWtq28 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(androidx.compose.ui.R.string.navigation_menu), startRestartGroup, 0);
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume2 = startRestartGroup.consume(localLayoutDirection);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            Modifier anchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(modifier3, drawerState2.getAnchoredDraggableState$material3_release(), Orientation.Horizontal, z3, consume2 != LayoutDirection.Rtl, null, 16, null);
                            startRestartGroup.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                            startRestartGroup.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(anchoredDraggable$default);
                            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            startRestartGroup.startReusableNode();
                            if (startRestartGroup.getInserting()) {
                                startRestartGroup.useNode();
                            } else {
                                startRestartGroup.createNode(constructor);
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
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 973030793, "C464@17278L526,445@16646L1158:NavigationDrawer.kt#uh7d8r");
                            startRestartGroup.startReplaceableGroup(973031425);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                            z4 = (i7 <= 256 && startRestartGroup.changed(drawerState2)) || (i3 & 384) == 256;
                            rememberedValue3 = startRestartGroup.rememberedValue();
                            if (!z4 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue3 = new MeasurePolicy() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$2$1
                                    @Override // androidx.compose.ui.layout.MeasurePolicy
                                    /* renamed from: measure-3p2s80s */
                                    public final MeasureResult mo355measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                        final Placeable mo5333measureBRTryo0 = list.get(0).mo5333measureBRTryo0(j);
                                        final Placeable mo5333measureBRTryo02 = list.get(1).mo5333measureBRTryo0(j);
                                        int width = mo5333measureBRTryo02.getWidth();
                                        int height = mo5333measureBRTryo02.getHeight();
                                        final DrawerState drawerState3 = DrawerState.this;
                                        return MeasureScope.layout$default(measureScope, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$2$1.1
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
                                                Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, MathKt.roundToInt(drawerState3.requireOffset$material3_release()) + mo5333measureBRTryo0.getWidth(), 0, 0.0f, 4, null);
                                                Placeable.PlacementScope.placeRelative$default(placementScope, mo5333measureBRTryo0, MathKt.roundToInt(drawerState3.requireOffset$material3_release()), 0, 0.0f, 4, null);
                                            }
                                        }, 4, null);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue3);
                            }
                            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue3;
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            Modifier.Companion companion2 = Modifier.INSTANCE;
                            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion2);
                            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            startRestartGroup.startReusableNode();
                            if (startRestartGroup.getInserting()) {
                                startRestartGroup.useNode();
                            } else {
                                startRestartGroup.createNode(constructor2);
                            }
                            m3593constructorimpl2 = Updater.m3593constructorimpl(startRestartGroup);
                            Updater.m3600setimpl(m3593constructorimpl2, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (!m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                            }
                            modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                            startRestartGroup.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 94149449, "C446@16700L459,446@16677L531,461@17221L45:NavigationDrawer.kt#uh7d8r");
                            Modifier.Companion companion3 = Modifier.INSTANCE;
                            startRestartGroup.startReplaceableGroup(94149472);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                            changed2 = startRestartGroup.changed(m2623getStringNWtq28) | ((i7 <= 256 && startRestartGroup.changed(drawerState2)) || (i3 & 384) == 256) | startRestartGroup.changedInstance(coroutineScope);
                            rememberedValue4 = startRestartGroup.rememberedValue();
                            if (!changed2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue4 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1
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
                                        SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m2623getStringNWtq28);
                                        if (drawerState2.isOpen()) {
                                            final DrawerState drawerState3 = drawerState2;
                                            final CoroutineScope coroutineScope2 = coroutineScope;
                                            SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Boolean invoke() {
                                                    if (DrawerState.this.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(DrawerValue.Closed).booleanValue()) {
                                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new C00671(DrawerState.this, null), 3, null);
                                                    }
                                                    return true;
                                                }

                                                /* compiled from: NavigationDrawer.kt */
                                                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                                @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1$1$1", f = "NavigationDrawer.kt", i = {}, l = {455}, m = "invokeSuspend", n = {}, s = {})
                                                /* renamed from: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1$1$1, reason: invalid class name and collision with other inner class name */
                                                static final class C00671 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                    final /* synthetic */ DrawerState $drawerState;
                                                    int label;

                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    C00671(DrawerState drawerState, Continuation<? super C00671> continuation) {
                                                        super(2, continuation);
                                                        this.$drawerState = drawerState;
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                        return new C00671(this.$drawerState, continuation);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                        return ((C00671) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    public final Object invokeSuspend(Object obj) {
                                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                        int i = this.label;
                                                        if (i == 0) {
                                                            ResultKt.throwOnFailure(obj);
                                                            this.label = 1;
                                                            if (this.$drawerState.close(this) == coroutine_suspended) {
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
                                            }, 1, null);
                                        }
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue4);
                            }
                            startRestartGroup.endReplaceableGroup();
                            Modifier semantics$default = SemanticsModifierKt.semantics$default(companion3, false, (Function1) rememberedValue4, 1, null);
                            startRestartGroup.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                            startRestartGroup.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(semantics$default);
                            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            startRestartGroup.startReusableNode();
                            if (startRestartGroup.getInserting()) {
                                startRestartGroup.useNode();
                            } else {
                                startRestartGroup.createNode(constructor3);
                            }
                            m3593constructorimpl3 = Updater.m3593constructorimpl(startRestartGroup);
                            Updater.m3600setimpl(m3593constructorimpl3, rememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3600setimpl(m3593constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (!m3593constructorimpl3.getInserting() || !Intrinsics.areEqual(m3593constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                m3593constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                m3593constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                            }
                            modifierMaterializerOf3.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                            startRestartGroup.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -817264288, "C459@17179L15:NavigationDrawer.kt#uh7d8r");
                            function2.invoke(startRestartGroup, Integer.valueOf(i3 & 14));
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.endNode();
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            Modifier.Companion companion4 = Modifier.INSTANCE;
                            MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                            startRestartGroup.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(companion4);
                            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            startRestartGroup.startReusableNode();
                            if (startRestartGroup.getInserting()) {
                                startRestartGroup.useNode();
                            } else {
                                startRestartGroup.createNode(constructor4);
                            }
                            m3593constructorimpl4 = Updater.m3593constructorimpl(startRestartGroup);
                            Updater.m3600setimpl(m3593constructorimpl4, rememberBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3600setimpl(m3593constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (!m3593constructorimpl4.getInserting() || !Intrinsics.areEqual(m3593constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                m3593constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                m3593constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                            }
                            modifierMaterializerOf4.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                            startRestartGroup.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -817264224, "C462@17243L9:NavigationDrawer.kt#uh7d8r");
                            function23 = function22;
                            function23.invoke(startRestartGroup, Integer.valueOf((i3 >> 12) & 14));
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
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.endNode();
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier2 = modifier3;
                            z5 = z3;
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                    }
                    modifier3 = modifier2;
                    z3 = z2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume3 = startRestartGroup.consume(localDensity2);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    final Density density2 = (Density) consume3;
                    final float f3 = -density2.mo630toPx0680j_4(NavigationDrawerTokens.INSTANCE.m3283getContainerWidthD9Ej5fM());
                    startRestartGroup.startReplaceableGroup(171918245);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                    int i72 = (i3 & 896) ^ 384;
                    changed = ((i72 <= 256 && startRestartGroup.changed(drawerState2)) || (i3 & 384) == 256) | startRestartGroup.changed(density2) | startRestartGroup.changed(f3);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    final float f22 = 0.0f;
                    rememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$1$1
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
                            DrawerState.this.setDensity$material3_release(density2);
                            AnchoredDraggableState<DrawerValue> anchoredDraggableState$material3_release = DrawerState.this.getAnchoredDraggableState$material3_release();
                            final float f32 = f3;
                            final float f4 = f22;
                            AnchoredDraggableState.updateAnchors$default(anchoredDraggableState$material3_release, AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<DrawerValue>, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$1$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                                    invoke2(draggableAnchorsConfig);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                                    draggableAnchorsConfig.at(DrawerValue.Closed, f32);
                                    draggableAnchorsConfig.at(DrawerValue.Open, f4);
                                }
                            }), null, 2, null);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    startRestartGroup.endReplaceableGroup();
                    EffectsKt.SideEffect((Function0) rememberedValue, startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(773894976);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                    startRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    final CoroutineScope coroutineScope2 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue2).getCoroutineScope();
                    startRestartGroup.endReplaceableGroup();
                    Strings.Companion companion5 = Strings.INSTANCE;
                    final String m2623getStringNWtq282 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(androidx.compose.ui.R.string.navigation_menu), startRestartGroup, 0);
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume22 = startRestartGroup.consume(localLayoutDirection2);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    Modifier anchoredDraggable$default2 = AnchoredDraggableKt.anchoredDraggable$default(modifier3, drawerState2.getAnchoredDraggableState$material3_release(), Orientation.Horizontal, z3, consume22 != LayoutDirection.Rtl, null, 16, null);
                    startRestartGroup.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy4 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap5 = startRestartGroup.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf5 = LayoutKt.modifierMaterializerOf(anchoredDraggable$default2);
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                    }
                    m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
                    Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!m3593constructorimpl.getInserting()) {
                    }
                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash5);
                    modifierMaterializerOf5.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 973030793, "C464@17278L526,445@16646L1158:NavigationDrawer.kt#uh7d8r");
                    startRestartGroup.startReplaceableGroup(973031425);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                    if (i72 <= 256) {
                    }
                    rememberedValue3 = startRestartGroup.rememberedValue();
                    if (!z4) {
                    }
                    rememberedValue3 = new MeasurePolicy() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$2$1
                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        /* renamed from: measure-3p2s80s */
                        public final MeasureResult mo355measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                            final Placeable mo5333measureBRTryo0 = list.get(0).mo5333measureBRTryo0(j);
                            final Placeable mo5333measureBRTryo02 = list.get(1).mo5333measureBRTryo0(j);
                            int width = mo5333measureBRTryo02.getWidth();
                            int height = mo5333measureBRTryo02.getHeight();
                            final DrawerState drawerState3 = DrawerState.this;
                            return MeasureScope.layout$default(measureScope, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$2$1.1
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
                                    Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, MathKt.roundToInt(drawerState3.requireOffset$material3_release()) + mo5333measureBRTryo0.getWidth(), 0, 0.0f, 4, null);
                                    Placeable.PlacementScope.placeRelative$default(placementScope, mo5333measureBRTryo0, MathKt.roundToInt(drawerState3.requireOffset$material3_release()), 0, 0.0f, 4, null);
                                }
                            }, 4, null);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                    MeasurePolicy measurePolicy2 = (MeasurePolicy) rememberedValue3;
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    Modifier.Companion companion22 = Modifier.INSTANCE;
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor22 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf22 = LayoutKt.modifierMaterializerOf(companion22);
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                    }
                    m3593constructorimpl2 = Updater.m3593constructorimpl(startRestartGroup);
                    Updater.m3600setimpl(m3593constructorimpl2, measurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap22, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!m3593constructorimpl2.getInserting()) {
                    }
                    m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash22);
                    modifierMaterializerOf22.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 94149449, "C446@16700L459,446@16677L531,461@17221L45:NavigationDrawer.kt#uh7d8r");
                    Modifier.Companion companion32 = Modifier.INSTANCE;
                    startRestartGroup.startReplaceableGroup(94149472);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                    changed2 = startRestartGroup.changed(m2623getStringNWtq282) | ((i72 <= 256 && startRestartGroup.changed(drawerState2)) || (i3 & 384) == 256) | startRestartGroup.changedInstance(coroutineScope2);
                    rememberedValue4 = startRestartGroup.rememberedValue();
                    if (!changed2) {
                    }
                    rememberedValue4 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1
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
                            SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m2623getStringNWtq282);
                            if (drawerState2.isOpen()) {
                                final DrawerState drawerState3 = drawerState2;
                                final CoroutineScope coroutineScope22 = coroutineScope2;
                                SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        if (DrawerState.this.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(DrawerValue.Closed).booleanValue()) {
                                            BuildersKt__Builders_commonKt.launch$default(coroutineScope22, null, null, new C00671(DrawerState.this, null), 3, null);
                                        }
                                        return true;
                                    }

                                    /* compiled from: NavigationDrawer.kt */
                                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                    @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1$1$1", f = "NavigationDrawer.kt", i = {}, l = {455}, m = "invokeSuspend", n = {}, s = {})
                                    /* renamed from: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1$1$1, reason: invalid class name and collision with other inner class name */
                                    static final class C00671 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        final /* synthetic */ DrawerState $drawerState;
                                        int label;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        C00671(DrawerState drawerState, Continuation<? super C00671> continuation) {
                                            super(2, continuation);
                                            this.$drawerState = drawerState;
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            return new C00671(this.$drawerState, continuation);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                            return ((C00671) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Object invokeSuspend(Object obj) {
                                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            int i = this.label;
                                            if (i == 0) {
                                                ResultKt.throwOnFailure(obj);
                                                this.label = 1;
                                                if (this.$drawerState.close(this) == coroutine_suspended) {
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
                                }, 1, null);
                            }
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                    startRestartGroup.endReplaceableGroup();
                    Modifier semantics$default2 = SemanticsModifierKt.semantics$default(companion32, false, (Function1) rememberedValue4, 1, null);
                    startRestartGroup.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy22 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap32 = startRestartGroup.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor32 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf32 = LayoutKt.modifierMaterializerOf(semantics$default2);
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                    }
                    m3593constructorimpl3 = Updater.m3593constructorimpl(startRestartGroup);
                    Updater.m3600setimpl(m3593constructorimpl3, rememberBoxMeasurePolicy22, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3600setimpl(m3593constructorimpl3, currentCompositionLocalMap32, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash32 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!m3593constructorimpl3.getInserting()) {
                    }
                    m3593constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m3593constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash32);
                    modifierMaterializerOf32.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -817264288, "C459@17179L15:NavigationDrawer.kt#uh7d8r");
                    function2.invoke(startRestartGroup, Integer.valueOf(i3 & 14));
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endNode();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    Modifier.Companion companion42 = Modifier.INSTANCE;
                    MeasurePolicy rememberBoxMeasurePolicy32 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap42 = startRestartGroup.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor42 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf42 = LayoutKt.modifierMaterializerOf(companion42);
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                    }
                    m3593constructorimpl4 = Updater.m3593constructorimpl(startRestartGroup);
                    Updater.m3600setimpl(m3593constructorimpl4, rememberBoxMeasurePolicy32, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3600setimpl(m3593constructorimpl4, currentCompositionLocalMap42, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash42 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!m3593constructorimpl4.getInserting()) {
                    }
                    m3593constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    m3593constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash42);
                    modifierMaterializerOf42.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance32 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -817264224, "C462@17243L9:NavigationDrawer.kt#uh7d8r");
                    function23 = function22;
                    function23.invoke(startRestartGroup, Integer.valueOf((i3 >> 12) & 14));
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
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endNode();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier2 = modifier3;
                    z5 = z3;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    z5 = z2;
                }
                final DrawerState drawerState3 = drawerState2;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier4 = modifier2;
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$3
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
                            NavigationDrawerKt.DismissibleNavigationDrawer(function2, modifier4, drawerState3, z5, function23, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            z2 = z;
            if ((i2 & 16) != 0) {
            }
            if ((i3 & 9363) == 9362) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i6 != 0) {
            }
            if ((i2 & 4) != 0) {
            }
            if (i4 != 0) {
            }
            modifier3 = modifier2;
            z3 = z2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            ProvidableCompositionLocal<Density> localDensity22 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume32 = startRestartGroup.consume(localDensity22);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final Density density22 = (Density) consume32;
            final float f32 = -density22.mo630toPx0680j_4(NavigationDrawerTokens.INSTANCE.m3283getContainerWidthD9Ej5fM());
            startRestartGroup.startReplaceableGroup(171918245);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
            int i722 = (i3 & 896) ^ 384;
            changed = ((i722 <= 256 && startRestartGroup.changed(drawerState2)) || (i3 & 384) == 256) | startRestartGroup.changed(density22) | startRestartGroup.changed(f32);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            final float f222 = 0.0f;
            rememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$1$1
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
                    DrawerState.this.setDensity$material3_release(density22);
                    AnchoredDraggableState<DrawerValue> anchoredDraggableState$material3_release = DrawerState.this.getAnchoredDraggableState$material3_release();
                    final float f322 = f32;
                    final float f4 = f222;
                    AnchoredDraggableState.updateAnchors$default(anchoredDraggableState$material3_release, AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<DrawerValue>, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$1$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                            invoke2(draggableAnchorsConfig);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                            draggableAnchorsConfig.at(DrawerValue.Closed, f322);
                            draggableAnchorsConfig.at(DrawerValue.Open, f4);
                        }
                    }), null, 2, null);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceableGroup();
            EffectsKt.SideEffect((Function0) rememberedValue, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            final CoroutineScope coroutineScope22 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue2).getCoroutineScope();
            startRestartGroup.endReplaceableGroup();
            Strings.Companion companion52 = Strings.INSTANCE;
            final String m2623getStringNWtq2822 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(androidx.compose.ui.R.string.navigation_menu), startRestartGroup, 0);
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection22 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume222 = startRestartGroup.consume(localLayoutDirection22);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier anchoredDraggable$default22 = AnchoredDraggableKt.anchoredDraggable$default(modifier3, drawerState2.getAnchoredDraggableState$material3_release(), Orientation.Horizontal, z3, consume222 != LayoutDirection.Rtl, null, 16, null);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy42 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap52 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor52 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf52 = LayoutKt.modifierMaterializerOf(anchoredDraggable$default22);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
            Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy42, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap52, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash52 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!m3593constructorimpl.getInserting()) {
            }
            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash52);
            modifierMaterializerOf52.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance42 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 973030793, "C464@17278L526,445@16646L1158:NavigationDrawer.kt#uh7d8r");
            startRestartGroup.startReplaceableGroup(973031425);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
            if (i722 <= 256) {
            }
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (!z4) {
            }
            rememberedValue3 = new MeasurePolicy() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$2$1
                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* renamed from: measure-3p2s80s */
                public final MeasureResult mo355measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                    final Placeable mo5333measureBRTryo0 = list.get(0).mo5333measureBRTryo0(j);
                    final Placeable mo5333measureBRTryo02 = list.get(1).mo5333measureBRTryo0(j);
                    int width = mo5333measureBRTryo02.getWidth();
                    int height = mo5333measureBRTryo02.getHeight();
                    final DrawerState drawerState32 = DrawerState.this;
                    return MeasureScope.layout$default(measureScope, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$2$1.1
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
                            Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, MathKt.roundToInt(drawerState32.requireOffset$material3_release()) + mo5333measureBRTryo0.getWidth(), 0, 0.0f, 4, null);
                            Placeable.PlacementScope.placeRelative$default(placementScope, mo5333measureBRTryo0, MathKt.roundToInt(drawerState32.requireOffset$material3_release()), 0, 0.0f, 4, null);
                        }
                    }, 4, null);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue3);
            MeasurePolicy measurePolicy22 = (MeasurePolicy) rememberedValue3;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            Modifier.Companion companion222 = Modifier.INSTANCE;
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor222 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf222 = LayoutKt.modifierMaterializerOf(companion222);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m3593constructorimpl2 = Updater.m3593constructorimpl(startRestartGroup);
            Updater.m3600setimpl(m3593constructorimpl2, measurePolicy22, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap222, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash222 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!m3593constructorimpl2.getInserting()) {
            }
            m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash222);
            modifierMaterializerOf222.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 94149449, "C446@16700L459,446@16677L531,461@17221L45:NavigationDrawer.kt#uh7d8r");
            Modifier.Companion companion322 = Modifier.INSTANCE;
            startRestartGroup.startReplaceableGroup(94149472);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
            changed2 = startRestartGroup.changed(m2623getStringNWtq2822) | ((i722 <= 256 && startRestartGroup.changed(drawerState2)) || (i3 & 384) == 256) | startRestartGroup.changedInstance(coroutineScope22);
            rememberedValue4 = startRestartGroup.rememberedValue();
            if (!changed2) {
            }
            rememberedValue4 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1
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
                    SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m2623getStringNWtq2822);
                    if (drawerState2.isOpen()) {
                        final DrawerState drawerState32 = drawerState2;
                        final CoroutineScope coroutineScope222 = coroutineScope22;
                        SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                if (DrawerState.this.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(DrawerValue.Closed).booleanValue()) {
                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope222, null, null, new C00671(DrawerState.this, null), 3, null);
                                }
                                return true;
                            }

                            /* compiled from: NavigationDrawer.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                            @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1$1$1", f = "NavigationDrawer.kt", i = {}, l = {455}, m = "invokeSuspend", n = {}, s = {})
                            /* renamed from: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1$1$1, reason: invalid class name and collision with other inner class name */
                            static final class C00671 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ DrawerState $drawerState;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                C00671(DrawerState drawerState, Continuation<? super C00671> continuation) {
                                    super(2, continuation);
                                    this.$drawerState = drawerState;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new C00671(this.$drawerState, continuation);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return ((C00671) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i = this.label;
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        this.label = 1;
                                        if (this.$drawerState.close(this) == coroutine_suspended) {
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
                        }, 1, null);
                    }
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue4);
            startRestartGroup.endReplaceableGroup();
            Modifier semantics$default22 = SemanticsModifierKt.semantics$default(companion322, false, (Function1) rememberedValue4, 1, null);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy222 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap322 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor322 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf322 = LayoutKt.modifierMaterializerOf(semantics$default22);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m3593constructorimpl3 = Updater.m3593constructorimpl(startRestartGroup);
            Updater.m3600setimpl(m3593constructorimpl3, rememberBoxMeasurePolicy222, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl3, currentCompositionLocalMap322, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash322 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!m3593constructorimpl3.getInserting()) {
            }
            m3593constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
            m3593constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash322);
            modifierMaterializerOf322.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance222 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -817264288, "C459@17179L15:NavigationDrawer.kt#uh7d8r");
            function2.invoke(startRestartGroup, Integer.valueOf(i3 & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            Modifier.Companion companion422 = Modifier.INSTANCE;
            MeasurePolicy rememberBoxMeasurePolicy322 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap422 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor422 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf422 = LayoutKt.modifierMaterializerOf(companion422);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m3593constructorimpl4 = Updater.m3593constructorimpl(startRestartGroup);
            Updater.m3600setimpl(m3593constructorimpl4, rememberBoxMeasurePolicy322, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl4, currentCompositionLocalMap422, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash422 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!m3593constructorimpl4.getInserting()) {
            }
            m3593constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
            m3593constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash422);
            modifierMaterializerOf422.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance322 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -817264224, "C462@17243L9:NavigationDrawer.kt#uh7d8r");
            function23 = function22;
            function23.invoke(startRestartGroup, Integer.valueOf((i3 >> 12) & 14));
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
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier2 = modifier3;
            z5 = z3;
            final DrawerState drawerState32 = drawerState2;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i & 384) != 0) {
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i2 & 16) != 0) {
        }
        if ((i3 & 9363) == 9362) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i6 != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if (i4 != 0) {
        }
        modifier3 = modifier2;
        z3 = z2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        ProvidableCompositionLocal<Density> localDensity222 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume322 = startRestartGroup.consume(localDensity222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        final Density density222 = (Density) consume322;
        final float f322 = -density222.mo630toPx0680j_4(NavigationDrawerTokens.INSTANCE.m3283getContainerWidthD9Ej5fM());
        startRestartGroup.startReplaceableGroup(171918245);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
        int i7222 = (i3 & 896) ^ 384;
        changed = ((i7222 <= 256 && startRestartGroup.changed(drawerState2)) || (i3 & 384) == 256) | startRestartGroup.changed(density222) | startRestartGroup.changed(f322);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        final float f2222 = 0.0f;
        rememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$1$1
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
                DrawerState.this.setDensity$material3_release(density222);
                AnchoredDraggableState<DrawerValue> anchoredDraggableState$material3_release = DrawerState.this.getAnchoredDraggableState$material3_release();
                final float f3222 = f322;
                final float f4 = f2222;
                AnchoredDraggableState.updateAnchors$default(anchoredDraggableState$material3_release, AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<DrawerValue>, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                        invoke2(draggableAnchorsConfig);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                        draggableAnchorsConfig.at(DrawerValue.Closed, f3222);
                        draggableAnchorsConfig.at(DrawerValue.Open, f4);
                    }
                }), null, 2, null);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceableGroup();
        EffectsKt.SideEffect((Function0) rememberedValue, startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final CoroutineScope coroutineScope222 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue2).getCoroutineScope();
        startRestartGroup.endReplaceableGroup();
        Strings.Companion companion522 = Strings.INSTANCE;
        final String m2623getStringNWtq28222 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(androidx.compose.ui.R.string.navigation_menu), startRestartGroup, 0);
        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection222 = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2222 = startRestartGroup.consume(localLayoutDirection222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Modifier anchoredDraggable$default222 = AnchoredDraggableKt.anchoredDraggable$default(modifier3, drawerState2.getAnchoredDraggableState$material3_release(), Orientation.Horizontal, z3, consume2222 != LayoutDirection.Rtl, null, 16, null);
        startRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
        MeasurePolicy rememberBoxMeasurePolicy422 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap522 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor522 = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf522 = LayoutKt.modifierMaterializerOf(anchoredDraggable$default222);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
        Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy422, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap522, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash522 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (!m3593constructorimpl.getInserting()) {
        }
        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash522);
        modifierMaterializerOf522.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance422 = BoxScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 973030793, "C464@17278L526,445@16646L1158:NavigationDrawer.kt#uh7d8r");
        startRestartGroup.startReplaceableGroup(973031425);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
        if (i7222 <= 256) {
        }
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (!z4) {
        }
        rememberedValue3 = new MeasurePolicy() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$2$1
            @Override // androidx.compose.ui.layout.MeasurePolicy
            /* renamed from: measure-3p2s80s */
            public final MeasureResult mo355measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                final Placeable mo5333measureBRTryo0 = list.get(0).mo5333measureBRTryo0(j);
                final Placeable mo5333measureBRTryo02 = list.get(1).mo5333measureBRTryo0(j);
                int width = mo5333measureBRTryo02.getWidth();
                int height = mo5333measureBRTryo02.getHeight();
                final DrawerState drawerState322 = DrawerState.this;
                return MeasureScope.layout$default(measureScope, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$2$1.1
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
                        Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, MathKt.roundToInt(drawerState322.requireOffset$material3_release()) + mo5333measureBRTryo0.getWidth(), 0, 0.0f, 4, null);
                        Placeable.PlacementScope.placeRelative$default(placementScope, mo5333measureBRTryo0, MathKt.roundToInt(drawerState322.requireOffset$material3_release()), 0, 0.0f, 4, null);
                    }
                }, 4, null);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue3);
        MeasurePolicy measurePolicy222 = (MeasurePolicy) rememberedValue3;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
        Modifier.Companion companion2222 = Modifier.INSTANCE;
        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2222 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor2222 = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2222 = LayoutKt.modifierMaterializerOf(companion2222);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m3593constructorimpl2 = Updater.m3593constructorimpl(startRestartGroup);
        Updater.m3600setimpl(m3593constructorimpl2, measurePolicy222, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2222, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2222 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (!m3593constructorimpl2.getInserting()) {
        }
        m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
        m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2222);
        modifierMaterializerOf2222.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 94149449, "C446@16700L459,446@16677L531,461@17221L45:NavigationDrawer.kt#uh7d8r");
        Modifier.Companion companion3222 = Modifier.INSTANCE;
        startRestartGroup.startReplaceableGroup(94149472);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
        changed2 = startRestartGroup.changed(m2623getStringNWtq28222) | ((i7222 <= 256 && startRestartGroup.changed(drawerState2)) || (i3 & 384) == 256) | startRestartGroup.changedInstance(coroutineScope222);
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (!changed2) {
        }
        rememberedValue4 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1
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
                SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m2623getStringNWtq28222);
                if (drawerState2.isOpen()) {
                    final DrawerState drawerState322 = drawerState2;
                    final CoroutineScope coroutineScope2222 = coroutineScope222;
                    SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            if (DrawerState.this.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(DrawerValue.Closed).booleanValue()) {
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope2222, null, null, new C00671(DrawerState.this, null), 3, null);
                            }
                            return true;
                        }

                        /* compiled from: NavigationDrawer.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                        @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1$1$1", f = "NavigationDrawer.kt", i = {}, l = {455}, m = "invokeSuspend", n = {}, s = {})
                        /* renamed from: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1$1$1, reason: invalid class name and collision with other inner class name */
                        static final class C00671 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ DrawerState $drawerState;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            C00671(DrawerState drawerState, Continuation<? super C00671> continuation) {
                                super(2, continuation);
                                this.$drawerState = drawerState;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new C00671(this.$drawerState, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((C00671) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    this.label = 1;
                                    if (this.$drawerState.close(this) == coroutine_suspended) {
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
                    }, 1, null);
                }
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue4);
        startRestartGroup.endReplaceableGroup();
        Modifier semantics$default222 = SemanticsModifierKt.semantics$default(companion3222, false, (Function1) rememberedValue4, 1, null);
        startRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
        MeasurePolicy rememberBoxMeasurePolicy2222 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
        currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap3222 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor3222 = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3222 = LayoutKt.modifierMaterializerOf(semantics$default222);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m3593constructorimpl3 = Updater.m3593constructorimpl(startRestartGroup);
        Updater.m3600setimpl(m3593constructorimpl3, rememberBoxMeasurePolicy2222, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3600setimpl(m3593constructorimpl3, currentCompositionLocalMap3222, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3222 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (!m3593constructorimpl3.getInserting()) {
        }
        m3593constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
        m3593constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3222);
        modifierMaterializerOf3222.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance2222 = BoxScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -817264288, "C459@17179L15:NavigationDrawer.kt#uh7d8r");
        function2.invoke(startRestartGroup, Integer.valueOf(i3 & 14));
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
        Modifier.Companion companion4222 = Modifier.INSTANCE;
        MeasurePolicy rememberBoxMeasurePolicy3222 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
        currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap4222 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor4222 = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4222 = LayoutKt.modifierMaterializerOf(companion4222);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m3593constructorimpl4 = Updater.m3593constructorimpl(startRestartGroup);
        Updater.m3600setimpl(m3593constructorimpl4, rememberBoxMeasurePolicy3222, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3600setimpl(m3593constructorimpl4, currentCompositionLocalMap4222, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4222 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (!m3593constructorimpl4.getInserting()) {
        }
        m3593constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
        m3593constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4222);
        modifierMaterializerOf4222.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance3222 = BoxScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -817264224, "C462@17243L9:NavigationDrawer.kt#uh7d8r");
        function23 = function22;
        function23.invoke(startRestartGroup, Integer.valueOf((i3 >> 12) & 14));
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
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier2 = modifier3;
        z5 = z3;
        final DrawerState drawerState322 = drawerState2;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    public static final void PermanentNavigationDrawer(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i, final int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-276843608);
        ComposerKt.sourceInformation(startRestartGroup, "C(PermanentNavigationDrawer)P(1,2)501@18841L105:NavigationDrawer.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function22) ? 256 : 128;
        }
        if ((i3 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-276843608, i3, -1, "androidx.compose.material3.PermanentNavigationDrawer (NavigationDrawer.kt:500)");
            }
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(modifier, 0.0f, 1, null);
            startRestartGroup.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxSize$default);
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
            Updater.m3600setimpl(m3593constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326681643, "C92@4661L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1153993360, "C502@18879L15,503@18903L37:NavigationDrawer.kt#uh7d8r");
            function2.invoke(startRestartGroup, Integer.valueOf(i3 & 14));
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1146975803, "C504@18921L9:NavigationDrawer.kt#uh7d8r");
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
        final Modifier modifier2 = modifier;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$PermanentNavigationDrawer$2
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
                    NavigationDrawerKt.PermanentNavigationDrawer(function2, modifier2, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00bf  */
    /* renamed from: ModalDrawerSheet-afqeVBk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2356ModalDrawerSheetafqeVBk(Modifier modifier, Shape shape, long j, long j2, float f, WindowInsets windowInsets, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Shape shape2;
        long j3;
        long j4;
        float f2;
        WindowInsets windowInsets2;
        long j5;
        long j6;
        float f3;
        WindowInsets windowInsets3;
        Modifier modifier3;
        Shape shape3;
        int i4;
        Composer composer2;
        final WindowInsets windowInsets4;
        final Modifier modifier4;
        final Shape shape4;
        final long j7;
        final long j8;
        final float f4;
        ScopeUpdateScope endRestartGroup;
        int i5;
        int i6;
        int i7;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(1001163336);
        ComposerKt.sourceInformation(startRestartGroup, "C(ModalDrawerSheet)P(5,3,1:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,6)528@20049L5,529@20105L14,530@20153L37,532@20308L12,535@20378L183:NavigationDrawer.kt#uh7d8r");
        int i9 = i2 & 1;
        if (i9 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                shape2 = shape;
                if (startRestartGroup.changed(shape2)) {
                    i8 = 32;
                    i3 |= i8;
                }
            } else {
                shape2 = shape;
            }
            i8 = 16;
            i3 |= i8;
        } else {
            shape2 = shape;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                j3 = j;
                if (startRestartGroup.changed(j3)) {
                    i7 = 256;
                    i3 |= i7;
                }
            } else {
                j3 = j;
            }
            i7 = 128;
            i3 |= i7;
        } else {
            j3 = j;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                j4 = j2;
                if (startRestartGroup.changed(j4)) {
                    i6 = 2048;
                    i3 |= i6;
                }
            } else {
                j4 = j2;
            }
            i6 = 1024;
            i3 |= i6;
        } else {
            j4 = j2;
        }
        int i10 = i2 & 16;
        if (i10 != 0) {
            i3 |= 24576;
        } else if ((i & 24576) == 0) {
            f2 = f;
            i3 |= startRestartGroup.changed(f2) ? 16384 : 8192;
            if ((196608 & i) != 0) {
                if ((i2 & 32) == 0) {
                    windowInsets2 = windowInsets;
                    if (startRestartGroup.changed(windowInsets2)) {
                        i5 = 131072;
                        i3 |= i5;
                    }
                } else {
                    windowInsets2 = windowInsets;
                }
                i5 = 65536;
                i3 |= i5;
            } else {
                windowInsets2 = windowInsets;
            }
            if ((i2 & 64) == 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                i3 |= startRestartGroup.changedInstance(function3) ? 1048576 : 524288;
                if ((599187 & i3) == 599186 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        Modifier.Companion companion = i9 != 0 ? Modifier.INSTANCE : modifier2;
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            shape2 = DrawerDefaults.INSTANCE.getShape(startRestartGroup, 6);
                        }
                        if ((i2 & 4) != 0) {
                            j3 = DrawerDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            j4 = ColorSchemeKt.m2049contentColorForek8zF_U(j3, startRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i10 != 0) {
                            f2 = DrawerDefaults.INSTANCE.m2189getModalDrawerElevationD9Ej5fM();
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                            shape3 = shape2;
                            j5 = j3;
                            j6 = j4;
                            f3 = f2;
                            modifier3 = companion;
                        } else {
                            j5 = j3;
                            j6 = j4;
                            f3 = f2;
                            windowInsets3 = windowInsets2;
                            modifier3 = companion;
                            shape3 = shape2;
                        }
                        i4 = 1001163336;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                        }
                        j5 = j3;
                        j6 = j4;
                        f3 = f2;
                        windowInsets3 = windowInsets2;
                        i4 = 1001163336;
                        modifier3 = modifier2;
                        shape3 = shape2;
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i4, i3, -1, "androidx.compose.material3.ModalDrawerSheet (NavigationDrawer.kt:534)");
                    }
                    int i11 = i3 << 3;
                    composer2 = startRestartGroup;
                    m2355DrawerSheetvywBR7E(windowInsets3, modifier3, shape3, j5, j6, f3, function3, composer2, ((i3 >> 15) & 14) | (i11 & 112) | (i11 & 896) | (i11 & 7168) | (57344 & i11) | (i11 & 458752) | (3670016 & i3), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    windowInsets4 = windowInsets3;
                    modifier4 = modifier3;
                    shape4 = shape3;
                    j7 = j5;
                    j8 = j6;
                    f4 = f3;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    composer2 = startRestartGroup;
                    modifier4 = modifier2;
                    shape4 = shape2;
                    j7 = j3;
                    j8 = j4;
                    f4 = f2;
                    windowInsets4 = windowInsets2;
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalDrawerSheet$1
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
                            NavigationDrawerKt.m2356ModalDrawerSheetafqeVBk(Modifier.this, shape4, j7, j8, f4, windowInsets4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            if ((599187 & i3) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i9 != 0) {
            }
            if ((i2 & 2) != 0) {
            }
            if ((i2 & 4) != 0) {
            }
            if ((i2 & 8) != 0) {
            }
            if (i10 != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            i4 = 1001163336;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i112 = i3 << 3;
            composer2 = startRestartGroup;
            m2355DrawerSheetvywBR7E(windowInsets3, modifier3, shape3, j5, j6, f3, function3, composer2, ((i3 >> 15) & 14) | (i112 & 112) | (i112 & 896) | (i112 & 7168) | (57344 & i112) | (i112 & 458752) | (3670016 & i3), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            windowInsets4 = windowInsets3;
            modifier4 = modifier3;
            shape4 = shape3;
            j7 = j5;
            j8 = j6;
            f4 = f3;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        f2 = f;
        if ((196608 & i) != 0) {
        }
        if ((i2 & 64) == 0) {
        }
        if ((599187 & i3) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i9 != 0) {
        }
        if ((i2 & 2) != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if (i10 != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        i4 = 1001163336;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i1122 = i3 << 3;
        composer2 = startRestartGroup;
        m2355DrawerSheetvywBR7E(windowInsets3, modifier3, shape3, j5, j6, f3, function3, composer2, ((i3 >> 15) & 14) | (i1122 & 112) | (i1122 & 896) | (i1122 & 7168) | (57344 & i1122) | (i1122 & 458752) | (3670016 & i3), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        windowInsets4 = windowInsets3;
        modifier4 = modifier3;
        shape4 = shape3;
        j7 = j5;
        j8 = j6;
        f4 = f3;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00b4  */
    /* renamed from: DismissibleDrawerSheet-afqeVBk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2354DismissibleDrawerSheetafqeVBk(Modifier modifier, Shape shape, long j, long j2, float f, WindowInsets windowInsets, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Shape shape2;
        long j3;
        long j4;
        int i4;
        float f2;
        WindowInsets windowInsets2;
        long j5;
        float f3;
        WindowInsets windowInsets3;
        Modifier modifier3;
        Shape shape3;
        long j6;
        int i5;
        Composer composer2;
        final WindowInsets windowInsets4;
        final Modifier modifier4;
        final Shape shape4;
        final long j7;
        final long j8;
        final float f4;
        ScopeUpdateScope endRestartGroup;
        int i6;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(-588600583);
        ComposerKt.sourceInformation(startRestartGroup, "C(DismissibleDrawerSheet)P(5,3,1:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,6)566@21732L14,567@21780L37,569@21941L12,572@22011L183:NavigationDrawer.kt#uh7d8r");
        int i8 = i2 & 1;
        if (i8 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            shape2 = shape;
            i3 |= startRestartGroup.changed(shape2) ? 32 : 16;
            if ((i & 384) != 0) {
                if ((i2 & 4) == 0) {
                    j3 = j;
                    if (startRestartGroup.changed(j3)) {
                        i7 = 256;
                        i3 |= i7;
                    }
                } else {
                    j3 = j;
                }
                i7 = 128;
                i3 |= i7;
            } else {
                j3 = j;
            }
            if ((i & 3072) != 0) {
                j4 = j2;
                i3 |= ((i2 & 8) == 0 && startRestartGroup.changed(j4)) ? 2048 : 1024;
            } else {
                j4 = j2;
            }
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                f2 = f;
                i3 |= startRestartGroup.changed(f2) ? 16384 : 8192;
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        windowInsets2 = windowInsets;
                        if (startRestartGroup.changed(windowInsets2)) {
                            i6 = 131072;
                            i3 |= i6;
                        }
                    } else {
                        windowInsets2 = windowInsets;
                    }
                    i6 = 65536;
                    i3 |= i6;
                } else {
                    windowInsets2 = windowInsets;
                }
                if ((i2 & 64) != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    i3 |= startRestartGroup.changedInstance(function3) ? 1048576 : 524288;
                    if ((i3 & 599187) == 599186 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion = i8 == 0 ? Modifier.INSTANCE : modifier2;
                            if (i9 != 0) {
                                shape2 = RectangleShapeKt.getRectangleShape();
                            }
                            if ((i2 & 4) != 0) {
                                j3 = DrawerDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                j4 = ColorSchemeKt.m2049contentColorForek8zF_U(j3, startRestartGroup, (i3 >> 6) & 14);
                                i3 &= -7169;
                            }
                            if (i4 != 0) {
                                f2 = DrawerDefaults.INSTANCE.m2187getDismissibleDrawerElevationD9Ej5fM();
                            }
                            if ((i2 & 32) == 0) {
                                i3 &= -458753;
                                j6 = j3;
                                j5 = j4;
                                f3 = f2;
                                modifier3 = companion;
                                windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                                shape3 = shape2;
                            } else {
                                j5 = j4;
                                f3 = f2;
                                windowInsets3 = windowInsets2;
                                modifier3 = companion;
                                shape3 = shape2;
                                j6 = j3;
                            }
                            i5 = -588600583;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            j5 = j4;
                            f3 = f2;
                            windowInsets3 = windowInsets2;
                            i5 = -588600583;
                            modifier3 = modifier2;
                            shape3 = shape2;
                            j6 = j3;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i5, i3, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:571)");
                        }
                        int i10 = i3 << 3;
                        composer2 = startRestartGroup;
                        m2355DrawerSheetvywBR7E(windowInsets3, modifier3, shape3, j6, j5, f3, function3, composer2, ((i3 >> 15) & 14) | (i10 & 112) | (i10 & 896) | (i10 & 7168) | (57344 & i10) | (i10 & 458752) | (3670016 & i3), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        windowInsets4 = windowInsets3;
                        modifier4 = modifier3;
                        shape4 = shape3;
                        j7 = j6;
                        j8 = j5;
                        f4 = f3;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        composer2 = startRestartGroup;
                        modifier4 = modifier2;
                        shape4 = shape2;
                        j7 = j3;
                        j8 = j4;
                        f4 = f2;
                        windowInsets4 = windowInsets2;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleDrawerSheet$1
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

                            public final void invoke(Composer composer3, int i11) {
                                NavigationDrawerKt.m2354DismissibleDrawerSheetafqeVBk(Modifier.this, shape4, j7, j8, f4, windowInsets4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                if ((i3 & 599187) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i8 == 0) {
                }
                if (i9 != 0) {
                }
                if ((i2 & 4) != 0) {
                }
                if ((i2 & 8) != 0) {
                }
                if (i4 != 0) {
                }
                if ((i2 & 32) == 0) {
                }
                i5 = -588600583;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i102 = i3 << 3;
                composer2 = startRestartGroup;
                m2355DrawerSheetvywBR7E(windowInsets3, modifier3, shape3, j6, j5, f3, function3, composer2, ((i3 >> 15) & 14) | (i102 & 112) | (i102 & 896) | (i102 & 7168) | (57344 & i102) | (i102 & 458752) | (3670016 & i3), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                windowInsets4 = windowInsets3;
                modifier4 = modifier3;
                shape4 = shape3;
                j7 = j6;
                j8 = j5;
                f4 = f3;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            f2 = f;
            if ((196608 & i) == 0) {
            }
            if ((i2 & 64) != 0) {
            }
            if ((i3 & 599187) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i8 == 0) {
            }
            if (i9 != 0) {
            }
            if ((i2 & 4) != 0) {
            }
            if ((i2 & 8) != 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 32) == 0) {
            }
            i5 = -588600583;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i1022 = i3 << 3;
            composer2 = startRestartGroup;
            m2355DrawerSheetvywBR7E(windowInsets3, modifier3, shape3, j6, j5, f3, function3, composer2, ((i3 >> 15) & 14) | (i1022 & 112) | (i1022 & 896) | (i1022 & 7168) | (57344 & i1022) | (i1022 & 458752) | (3670016 & i3), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            windowInsets4 = windowInsets3;
            modifier4 = modifier3;
            shape4 = shape3;
            j7 = j6;
            j8 = j5;
            f4 = f3;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        shape2 = shape;
        if ((i & 384) != 0) {
        }
        if ((i & 3072) != 0) {
        }
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        f2 = f;
        if ((196608 & i) == 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if ((i3 & 599187) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i8 == 0) {
        }
        if (i9 != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 32) == 0) {
        }
        i5 = -588600583;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i10222 = i3 << 3;
        composer2 = startRestartGroup;
        m2355DrawerSheetvywBR7E(windowInsets3, modifier3, shape3, j6, j5, f3, function3, composer2, ((i3 >> 15) & 14) | (i10222 & 112) | (i10222 & 896) | (i10222 & 7168) | (57344 & i10222) | (i10222 & 458752) | (3670016 & i3), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        windowInsets4 = windowInsets3;
        modifier4 = modifier3;
        shape4 = shape3;
        j7 = j6;
        j8 = j5;
        f4 = f3;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00bf  */
    /* renamed from: PermanentDrawerSheet-afqeVBk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2358PermanentDrawerSheetafqeVBk(Modifier modifier, Shape shape, long j, long j2, float f, WindowInsets windowInsets, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Shape shape2;
        long j3;
        long j4;
        int i4;
        float f2;
        WindowInsets windowInsets2;
        Modifier.Companion companion;
        long j5;
        long j6;
        float f3;
        int i5;
        WindowInsets windowInsets3;
        Shape shape3;
        boolean changed;
        Object rememberedValue;
        Composer composer2;
        final Modifier modifier3;
        final WindowInsets windowInsets4;
        final Shape shape4;
        final long j7;
        final long j8;
        final float f4;
        ScopeUpdateScope endRestartGroup;
        int i6;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(-1733353241);
        ComposerKt.sourceInformation(startRestartGroup, "C(PermanentDrawerSheet)P(5,3,1:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,6)603@23356L14,604@23404L37,606@23563L12,609@23654L33,612@23754L50,610@23692L244:NavigationDrawer.kt#uh7d8r");
        int i8 = i2 & 1;
        if (i8 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            shape2 = shape;
            i3 |= startRestartGroup.changed(shape2) ? 32 : 16;
            if ((i & 384) != 0) {
                if ((i2 & 4) == 0) {
                    j3 = j;
                    if (startRestartGroup.changed(j3)) {
                        i7 = 256;
                        i3 |= i7;
                    }
                } else {
                    j3 = j;
                }
                i7 = 128;
                i3 |= i7;
            } else {
                j3 = j;
            }
            if ((i & 3072) != 0) {
                j4 = j2;
                i3 |= ((i2 & 8) == 0 && startRestartGroup.changed(j4)) ? 2048 : 1024;
            } else {
                j4 = j2;
            }
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                f2 = f;
                i3 |= startRestartGroup.changed(f2) ? 16384 : 8192;
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        windowInsets2 = windowInsets;
                        if (startRestartGroup.changed(windowInsets2)) {
                            i6 = 131072;
                            i3 |= i6;
                        }
                    } else {
                        windowInsets2 = windowInsets;
                    }
                    i6 = 65536;
                    i3 |= i6;
                } else {
                    windowInsets2 = windowInsets;
                }
                if ((i2 & 64) != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    i3 |= startRestartGroup.changedInstance(function3) ? 1048576 : 524288;
                    if ((i3 & 599187) == 599186 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            companion = i8 == 0 ? Modifier.INSTANCE : modifier2;
                            if (i9 != 0) {
                                shape2 = RectangleShapeKt.getRectangleShape();
                            }
                            if ((i2 & 4) != 0) {
                                j3 = DrawerDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                j4 = ColorSchemeKt.m2049contentColorForek8zF_U(j3, startRestartGroup, (i3 >> 6) & 14);
                                i3 &= -7169;
                            }
                            if (i4 != 0) {
                                f2 = DrawerDefaults.INSTANCE.m2190getPermanentDrawerElevationD9Ej5fM();
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                j5 = j3;
                                j6 = j4;
                                f3 = f2;
                                i5 = -1733353241;
                                windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                                shape3 = shape2;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(i5, i3, -1, "androidx.compose.material3.PermanentDrawerSheet (NavigationDrawer.kt:608)");
                                }
                                Strings.Companion companion2 = Strings.INSTANCE;
                                final String m2623getStringNWtq28 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(androidx.compose.ui.R.string.navigation_menu), startRestartGroup, 0);
                                startRestartGroup.startReplaceableGroup(705343847);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                                changed = startRestartGroup.changed(m2623getStringNWtq28);
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$PermanentDrawerSheet$1$1
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
                                            SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m2623getStringNWtq28);
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                startRestartGroup.endReplaceableGroup();
                                int i10 = i3 << 3;
                                composer2 = startRestartGroup;
                                m2355DrawerSheetvywBR7E(windowInsets3, SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue, 1, null), shape3, j5, j6, f3, function3, composer2, ((i3 >> 15) & 14) | (i10 & 896) | (i10 & 7168) | (57344 & i10) | (i10 & 458752) | (3670016 & i3), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = companion;
                                windowInsets4 = windowInsets3;
                                shape4 = shape3;
                                j7 = j5;
                                j8 = j6;
                                f4 = f3;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            companion = modifier2;
                        }
                        j6 = j4;
                        f3 = f2;
                        windowInsets3 = windowInsets2;
                        i5 = -1733353241;
                        shape3 = shape2;
                        j5 = j3;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        Strings.Companion companion22 = Strings.INSTANCE;
                        final String m2623getStringNWtq282 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(androidx.compose.ui.R.string.navigation_menu), startRestartGroup, 0);
                        startRestartGroup.startReplaceableGroup(705343847);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                        changed = startRestartGroup.changed(m2623getStringNWtq282);
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (!changed) {
                        }
                        rememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$PermanentDrawerSheet$1$1
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
                                SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m2623getStringNWtq282);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                        startRestartGroup.endReplaceableGroup();
                        int i102 = i3 << 3;
                        composer2 = startRestartGroup;
                        m2355DrawerSheetvywBR7E(windowInsets3, SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue, 1, null), shape3, j5, j6, f3, function3, composer2, ((i3 >> 15) & 14) | (i102 & 896) | (i102 & 7168) | (57344 & i102) | (i102 & 458752) | (3670016 & i3), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier3 = companion;
                        windowInsets4 = windowInsets3;
                        shape4 = shape3;
                        j7 = j5;
                        j8 = j6;
                        f4 = f3;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        composer2 = startRestartGroup;
                        modifier3 = modifier2;
                        shape4 = shape2;
                        j7 = j3;
                        j8 = j4;
                        f4 = f2;
                        windowInsets4 = windowInsets2;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$PermanentDrawerSheet$2
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

                            public final void invoke(Composer composer3, int i11) {
                                NavigationDrawerKt.m2358PermanentDrawerSheetafqeVBk(Modifier.this, shape4, j7, j8, f4, windowInsets4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                if ((i3 & 599187) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i8 == 0) {
                }
                if (i9 != 0) {
                }
                if ((i2 & 4) != 0) {
                }
                if ((i2 & 8) != 0) {
                }
                if (i4 != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                j6 = j4;
                f3 = f2;
                windowInsets3 = windowInsets2;
                i5 = -1733353241;
                shape3 = shape2;
                j5 = j3;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                Strings.Companion companion222 = Strings.INSTANCE;
                final String m2623getStringNWtq2822 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(androidx.compose.ui.R.string.navigation_menu), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(705343847);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                changed = startRestartGroup.changed(m2623getStringNWtq2822);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$PermanentDrawerSheet$1$1
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
                        SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m2623getStringNWtq2822);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
                startRestartGroup.endReplaceableGroup();
                int i1022 = i3 << 3;
                composer2 = startRestartGroup;
                m2355DrawerSheetvywBR7E(windowInsets3, SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue, 1, null), shape3, j5, j6, f3, function3, composer2, ((i3 >> 15) & 14) | (i1022 & 896) | (i1022 & 7168) | (57344 & i1022) | (i1022 & 458752) | (3670016 & i3), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = companion;
                windowInsets4 = windowInsets3;
                shape4 = shape3;
                j7 = j5;
                j8 = j6;
                f4 = f3;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            f2 = f;
            if ((196608 & i) == 0) {
            }
            if ((i2 & 64) != 0) {
            }
            if ((i3 & 599187) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i8 == 0) {
            }
            if (i9 != 0) {
            }
            if ((i2 & 4) != 0) {
            }
            if ((i2 & 8) != 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            j6 = j4;
            f3 = f2;
            windowInsets3 = windowInsets2;
            i5 = -1733353241;
            shape3 = shape2;
            j5 = j3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            Strings.Companion companion2222 = Strings.INSTANCE;
            final String m2623getStringNWtq28222 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(androidx.compose.ui.R.string.navigation_menu), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(705343847);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
            changed = startRestartGroup.changed(m2623getStringNWtq28222);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$PermanentDrawerSheet$1$1
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
                    SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m2623getStringNWtq28222);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceableGroup();
            int i10222 = i3 << 3;
            composer2 = startRestartGroup;
            m2355DrawerSheetvywBR7E(windowInsets3, SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue, 1, null), shape3, j5, j6, f3, function3, composer2, ((i3 >> 15) & 14) | (i10222 & 896) | (i10222 & 7168) | (57344 & i10222) | (i10222 & 458752) | (3670016 & i3), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = companion;
            windowInsets4 = windowInsets3;
            shape4 = shape3;
            j7 = j5;
            j8 = j6;
            f4 = f3;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        shape2 = shape;
        if ((i & 384) != 0) {
        }
        if ((i & 3072) != 0) {
        }
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        f2 = f;
        if ((196608 & i) == 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if ((i3 & 599187) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i8 == 0) {
        }
        if (i9 != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        j6 = j4;
        f3 = f2;
        windowInsets3 = windowInsets2;
        i5 = -1733353241;
        shape3 = shape2;
        j5 = j3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        Strings.Companion companion22222 = Strings.INSTANCE;
        final String m2623getStringNWtq282222 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(androidx.compose.ui.R.string.navigation_menu), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(705343847);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
        changed = startRestartGroup.changed(m2623getStringNWtq282222);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$PermanentDrawerSheet$1$1
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
                SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m2623getStringNWtq282222);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceableGroup();
        int i102222 = i3 << 3;
        composer2 = startRestartGroup;
        m2355DrawerSheetvywBR7E(windowInsets3, SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue, 1, null), shape3, j5, j6, f3, function3, composer2, ((i3 >> 15) & 14) | (i102222 & 896) | (i102222 & 7168) | (57344 & i102222) | (i102222 & 458752) | (3670016 & i3), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = companion;
        windowInsets4 = windowInsets3;
        shape4 = shape3;
        j7 = j5;
        j8 = j6;
        f4 = f3;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x004e  */
    /* renamed from: DrawerSheet-vywBR7E, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2355DrawerSheetvywBR7E(final WindowInsets windowInsets, Modifier modifier, Shape shape, long j, long j2, float f, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Shape shape2;
        long j3;
        long j4;
        int i5;
        float f2;
        float m2190getPermanentDrawerElevationD9Ej5fM;
        long j5;
        int i6;
        Composer composer2;
        final Modifier modifier3;
        final Shape shape3;
        final long j6;
        final long j7;
        final float f3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(175072821);
        ComposerKt.sourceInformation(startRestartGroup, "C(DrawerSheet)P(6,5,3,1:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp)628@24134L14,629@24182L37,633@24349L667:NavigationDrawer.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(windowInsets) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                shape2 = shape;
                i3 |= startRestartGroup.changed(shape2) ? 256 : 128;
                if ((i & 3072) == 0) {
                    j3 = j;
                    i3 |= ((i2 & 8) == 0 && startRestartGroup.changed(j3)) ? 2048 : 1024;
                } else {
                    j3 = j;
                }
                if ((i & 24576) == 0) {
                    j4 = j2;
                    i3 |= ((i2 & 16) == 0 && startRestartGroup.changed(j4)) ? 16384 : 8192;
                } else {
                    j4 = j2;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i) == 0) {
                    f2 = f;
                    i3 |= startRestartGroup.changed(f2) ? 131072 : 65536;
                    if ((i2 & 64) == 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        i3 |= startRestartGroup.changedInstance(function3) ? 1048576 : 524288;
                    }
                    if ((i3 & 599187) == 599186 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            if (i7 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                shape2 = RectangleShapeKt.getRectangleShape();
                            }
                            if ((i2 & 8) != 0) {
                                j3 = DrawerDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                j4 = ColorSchemeKt.m2049contentColorForek8zF_U(j3, startRestartGroup, (i3 >> 9) & 14);
                                i3 &= -57345;
                            }
                            if (i5 != 0) {
                                m2190getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m2190getPermanentDrawerElevationD9Ej5fM();
                                j5 = j4;
                                i6 = 175072821;
                                long j8 = j3;
                                Shape shape4 = shape2;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(i6, i3, -1, "androidx.compose.material3.DrawerSheet (NavigationDrawer.kt:632)");
                                }
                                int i8 = i3 >> 3;
                                composer2 = startRestartGroup;
                                SurfaceKt.m2633SurfaceT9BRK9s(SizeKt.fillMaxHeight$default(SizeKt.m932sizeInqDBjuR0$default(modifier2, MinimumDrawerWidth, 0.0f, DrawerDefaults.INSTANCE.m2188getMaximumDrawerWidthD9Ej5fM(), 0.0f, 10, null), 0.0f, 1, null), shape4, j8, j5, m2190getPermanentDrawerElevationD9Ej5fM, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, 959363152, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DrawerSheet$1
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
                                        float f4;
                                        ComposerKt.sourceInformation(composer3, "C645@24731L279:NavigationDrawer.kt#uh7d8r");
                                        if ((i9 & 3) != 2 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(959363152, i9, -1, "androidx.compose.material3.DrawerSheet.<anonymous> (NavigationDrawer.kt:645)");
                                            }
                                            Modifier.Companion companion = Modifier.INSTANCE;
                                            f4 = NavigationDrawerKt.MinimumDrawerWidth;
                                            Modifier windowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.m932sizeInqDBjuR0$default(companion, f4, 0.0f, DrawerDefaults.INSTANCE.m2188getMaximumDrawerWidthD9Ej5fM(), 0.0f, 10, null), WindowInsets.this);
                                            Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                                            composer3.startReplaceableGroup(-483455358);
                                            ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                            composer3.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(windowInsetsPadding);
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
                                            function32.invoke(ColumnScopeInstance.INSTANCE, composer3, 6);
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
                                }), composer2, (i8 & 112) | 12582912 | (i8 & 896) | (i8 & 7168) | (i8 & 57344), 96);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = modifier2;
                                shape3 = shape4;
                                j6 = j8;
                                j7 = j5;
                                f3 = m2190getPermanentDrawerElevationD9Ej5fM;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                        }
                        m2190getPermanentDrawerElevationD9Ej5fM = f2;
                        i6 = 175072821;
                        j5 = j4;
                        long j82 = j3;
                        Shape shape42 = shape2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i82 = i3 >> 3;
                        composer2 = startRestartGroup;
                        SurfaceKt.m2633SurfaceT9BRK9s(SizeKt.fillMaxHeight$default(SizeKt.m932sizeInqDBjuR0$default(modifier2, MinimumDrawerWidth, 0.0f, DrawerDefaults.INSTANCE.m2188getMaximumDrawerWidthD9Ej5fM(), 0.0f, 10, null), 0.0f, 1, null), shape42, j82, j5, m2190getPermanentDrawerElevationD9Ej5fM, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, 959363152, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DrawerSheet$1
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
                                float f4;
                                ComposerKt.sourceInformation(composer3, "C645@24731L279:NavigationDrawer.kt#uh7d8r");
                                if ((i9 & 3) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(959363152, i9, -1, "androidx.compose.material3.DrawerSheet.<anonymous> (NavigationDrawer.kt:645)");
                                    }
                                    Modifier.Companion companion = Modifier.INSTANCE;
                                    f4 = NavigationDrawerKt.MinimumDrawerWidth;
                                    Modifier windowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.m932sizeInqDBjuR0$default(companion, f4, 0.0f, DrawerDefaults.INSTANCE.m2188getMaximumDrawerWidthD9Ej5fM(), 0.0f, 10, null), WindowInsets.this);
                                    Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                                    composer3.startReplaceableGroup(-483455358);
                                    ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                    composer3.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(windowInsetsPadding);
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
                                    function32.invoke(ColumnScopeInstance.INSTANCE, composer3, 6);
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
                        }), composer2, (i82 & 112) | 12582912 | (i82 & 896) | (i82 & 7168) | (i82 & 57344), 96);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier3 = modifier2;
                        shape3 = shape42;
                        j6 = j82;
                        j7 = j5;
                        f3 = m2190getPermanentDrawerElevationD9Ej5fM;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        composer2 = startRestartGroup;
                        modifier3 = modifier2;
                        shape3 = shape2;
                        j6 = j3;
                        j7 = j4;
                        f3 = f2;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DrawerSheet$2
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
                                NavigationDrawerKt.m2355DrawerSheetvywBR7E(WindowInsets.this, modifier3, shape3, j6, j7, f3, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                f2 = f;
                if ((i2 & 64) == 0) {
                }
                if ((i3 & 599187) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i7 != 0) {
                }
                if (i4 != 0) {
                }
                if ((i2 & 8) != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if (i5 != 0) {
                }
                m2190getPermanentDrawerElevationD9Ej5fM = f2;
                i6 = 175072821;
                j5 = j4;
                long j822 = j3;
                Shape shape422 = shape2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i822 = i3 >> 3;
                composer2 = startRestartGroup;
                SurfaceKt.m2633SurfaceT9BRK9s(SizeKt.fillMaxHeight$default(SizeKt.m932sizeInqDBjuR0$default(modifier2, MinimumDrawerWidth, 0.0f, DrawerDefaults.INSTANCE.m2188getMaximumDrawerWidthD9Ej5fM(), 0.0f, 10, null), 0.0f, 1, null), shape422, j822, j5, m2190getPermanentDrawerElevationD9Ej5fM, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, 959363152, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DrawerSheet$1
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
                        float f4;
                        ComposerKt.sourceInformation(composer3, "C645@24731L279:NavigationDrawer.kt#uh7d8r");
                        if ((i9 & 3) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(959363152, i9, -1, "androidx.compose.material3.DrawerSheet.<anonymous> (NavigationDrawer.kt:645)");
                            }
                            Modifier.Companion companion = Modifier.INSTANCE;
                            f4 = NavigationDrawerKt.MinimumDrawerWidth;
                            Modifier windowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.m932sizeInqDBjuR0$default(companion, f4, 0.0f, DrawerDefaults.INSTANCE.m2188getMaximumDrawerWidthD9Ej5fM(), 0.0f, 10, null), WindowInsets.this);
                            Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                            composer3.startReplaceableGroup(-483455358);
                            ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                            composer3.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(windowInsetsPadding);
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
                            function32.invoke(ColumnScopeInstance.INSTANCE, composer3, 6);
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
                }), composer2, (i822 & 112) | 12582912 | (i822 & 896) | (i822 & 7168) | (i822 & 57344), 96);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier2;
                shape3 = shape422;
                j6 = j822;
                j7 = j5;
                f3 = m2190getPermanentDrawerElevationD9Ej5fM;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            shape2 = shape;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            f2 = f;
            if ((i2 & 64) == 0) {
            }
            if ((i3 & 599187) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i7 != 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 8) != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if (i5 != 0) {
            }
            m2190getPermanentDrawerElevationD9Ej5fM = f2;
            i6 = 175072821;
            j5 = j4;
            long j8222 = j3;
            Shape shape4222 = shape2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i8222 = i3 >> 3;
            composer2 = startRestartGroup;
            SurfaceKt.m2633SurfaceT9BRK9s(SizeKt.fillMaxHeight$default(SizeKt.m932sizeInqDBjuR0$default(modifier2, MinimumDrawerWidth, 0.0f, DrawerDefaults.INSTANCE.m2188getMaximumDrawerWidthD9Ej5fM(), 0.0f, 10, null), 0.0f, 1, null), shape4222, j8222, j5, m2190getPermanentDrawerElevationD9Ej5fM, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, 959363152, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DrawerSheet$1
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
                    float f4;
                    ComposerKt.sourceInformation(composer3, "C645@24731L279:NavigationDrawer.kt#uh7d8r");
                    if ((i9 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(959363152, i9, -1, "androidx.compose.material3.DrawerSheet.<anonymous> (NavigationDrawer.kt:645)");
                        }
                        Modifier.Companion companion = Modifier.INSTANCE;
                        f4 = NavigationDrawerKt.MinimumDrawerWidth;
                        Modifier windowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.m932sizeInqDBjuR0$default(companion, f4, 0.0f, DrawerDefaults.INSTANCE.m2188getMaximumDrawerWidthD9Ej5fM(), 0.0f, 10, null), WindowInsets.this);
                        Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                        composer3.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(windowInsetsPadding);
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
                        function32.invoke(ColumnScopeInstance.INSTANCE, composer3, 6);
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
            }), composer2, (i8222 & 112) | 12582912 | (i8222 & 896) | (i8222 & 7168) | (i8222 & 57344), 96);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier2;
            shape3 = shape4222;
            j6 = j8222;
            j7 = j5;
            f3 = m2190getPermanentDrawerElevationD9Ej5fM;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        shape2 = shape;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        f2 = f;
        if ((i2 & 64) == 0) {
        }
        if ((i3 & 599187) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i7 != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if (i5 != 0) {
        }
        m2190getPermanentDrawerElevationD9Ej5fM = f2;
        i6 = 175072821;
        j5 = j4;
        long j82222 = j3;
        Shape shape42222 = shape2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i82222 = i3 >> 3;
        composer2 = startRestartGroup;
        SurfaceKt.m2633SurfaceT9BRK9s(SizeKt.fillMaxHeight$default(SizeKt.m932sizeInqDBjuR0$default(modifier2, MinimumDrawerWidth, 0.0f, DrawerDefaults.INSTANCE.m2188getMaximumDrawerWidthD9Ej5fM(), 0.0f, 10, null), 0.0f, 1, null), shape42222, j82222, j5, m2190getPermanentDrawerElevationD9Ej5fM, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, 959363152, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DrawerSheet$1
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
                float f4;
                ComposerKt.sourceInformation(composer3, "C645@24731L279:NavigationDrawer.kt#uh7d8r");
                if ((i9 & 3) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(959363152, i9, -1, "androidx.compose.material3.DrawerSheet.<anonymous> (NavigationDrawer.kt:645)");
                    }
                    Modifier.Companion companion = Modifier.INSTANCE;
                    f4 = NavigationDrawerKt.MinimumDrawerWidth;
                    Modifier windowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.m932sizeInqDBjuR0$default(companion, f4, 0.0f, DrawerDefaults.INSTANCE.m2188getMaximumDrawerWidthD9Ej5fM(), 0.0f, 10, null), WindowInsets.this);
                    Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                    composer3.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(windowInsetsPadding);
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
                    function32.invoke(ColumnScopeInstance.INSTANCE, composer3, 6);
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
        }), composer2, (i82222 & 112) | 12582912 | (i82222 & 896) | (i82222 & 7168) | (i82222 & 57344), 96);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier2;
        shape3 = shape42222;
        j6 = j82222;
        j7 = j5;
        f3 = m2190getPermanentDrawerElevationD9Ej5fM;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void NavigationDrawerItem(final Function2<? super Composer, ? super Integer, Unit> function2, final boolean z, final Function0<Unit> function0, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, NavigationDrawerItemColors navigationDrawerItemColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Modifier modifier2;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function25;
        Shape shape2;
        NavigationDrawerItemColors navigationDrawerItemColors2;
        int i7;
        MutableInteractionSource mutableInteractionSource2;
        int i8;
        Modifier.Companion companion;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Shape shape3;
        NavigationDrawerItemColors navigationDrawerItemColors3;
        int i9;
        MutableInteractionSource mutableInteractionSource3;
        int i10;
        Shape shape4;
        Composer composer2;
        final Shape shape5;
        final MutableInteractionSource mutableInteractionSource4;
        final NavigationDrawerItemColors navigationDrawerItemColors4;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        ScopeUpdateScope endRestartGroup;
        int i11;
        int i12;
        Composer startRestartGroup = composer.startRestartGroup(-1304626543);
        ComposerKt.sourceInformation(startRestartGroup, "C(NavigationDrawerItem)P(4,7,6,5,2!1,8)729@28081L5,730@28158L8,731@28218L39,741@28543L24,733@28266L1246:NavigationDrawer.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= startRestartGroup.changed(modifier2) ? 2048 : 1024;
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    function24 = function22;
                    i3 |= startRestartGroup.changedInstance(function24) ? 16384 : 8192;
                    i6 = i2 & 32;
                    if (i6 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((196608 & i) == 0) {
                        function25 = function23;
                        i3 |= startRestartGroup.changedInstance(function25) ? 131072 : 65536;
                        if ((1572864 & i) == 0) {
                            if ((i2 & 64) == 0) {
                                shape2 = shape;
                                if (startRestartGroup.changed(shape2)) {
                                    i12 = 1048576;
                                    i3 |= i12;
                                }
                            } else {
                                shape2 = shape;
                            }
                            i12 = 524288;
                            i3 |= i12;
                        } else {
                            shape2 = shape;
                        }
                        if ((12582912 & i) == 0) {
                            if ((i2 & 128) == 0) {
                                navigationDrawerItemColors2 = navigationDrawerItemColors;
                                if (startRestartGroup.changed(navigationDrawerItemColors2)) {
                                    i11 = 8388608;
                                    i3 |= i11;
                                }
                            } else {
                                navigationDrawerItemColors2 = navigationDrawerItemColors;
                            }
                            i11 = 4194304;
                            i3 |= i11;
                        } else {
                            navigationDrawerItemColors2 = navigationDrawerItemColors;
                        }
                        i7 = i2 & 256;
                        if (i7 != 0) {
                            i8 = i3 | 100663296;
                            mutableInteractionSource2 = mutableInteractionSource;
                        } else {
                            int i13 = i3;
                            mutableInteractionSource2 = mutableInteractionSource;
                            if ((i & 100663296) == 0) {
                                i8 = i13 | (startRestartGroup.changed(mutableInteractionSource2) ? 67108864 : 33554432);
                            } else {
                                i8 = i13;
                            }
                        }
                        if ((i8 & 38347923) == 38347922 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                                Function2<? super Composer, ? super Integer, Unit> function29 = i5 != 0 ? null : function24;
                                function26 = i6 != 0 ? null : function25;
                                if ((i2 & 64) != 0) {
                                    i8 &= -3670017;
                                    shape3 = ShapesKt.getValue(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), startRestartGroup, 6);
                                } else {
                                    shape3 = shape2;
                                }
                                int i14 = i8;
                                if ((i2 & 128) != 0) {
                                    navigationDrawerItemColors3 = NavigationDrawerItemDefaults.INSTANCE.m2353colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, startRestartGroup, 100663296, 255);
                                    startRestartGroup = startRestartGroup;
                                    i9 = i14 & (-29360129);
                                } else {
                                    navigationDrawerItemColors3 = navigationDrawerItemColors2;
                                    i9 = i14;
                                }
                                if (i7 != 0) {
                                    startRestartGroup.startReplaceableGroup(111536735);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                                    Object rememberedValue = startRestartGroup.rememberedValue();
                                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    navigationDrawerItemColors2 = navigationDrawerItemColors3;
                                    mutableInteractionSource3 = (MutableInteractionSource) rememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    navigationDrawerItemColors2 = navigationDrawerItemColors3;
                                }
                                i10 = i9;
                                function24 = function29;
                                shape4 = shape3;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 64) != 0) {
                                    i8 &= -3670017;
                                }
                                if ((i2 & 128) != 0) {
                                    i8 &= -29360129;
                                }
                                companion = modifier2;
                                function26 = function25;
                                shape4 = shape2;
                                mutableInteractionSource3 = mutableInteractionSource2;
                                i10 = i8;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1304626543, i10, -1, "androidx.compose.material3.NavigationDrawerItem (NavigationDrawer.kt:732)");
                            }
                            int i15 = i10 >> 3;
                            final Function2<? super Composer, ? super Integer, Unit> function210 = function24;
                            final NavigationDrawerItemColors navigationDrawerItemColors5 = navigationDrawerItemColors2;
                            final Function2<? super Composer, ? super Integer, Unit> function211 = function26;
                            Modifier modifier4 = companion;
                            SurfaceKt.m2634Surfaced85dljk(z, function0, SizeKt.fillMaxWidth$default(SizeKt.m914height3ABfNKs(SemanticsModifierKt.semantics$default(companion, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$NavigationDrawerItem$2
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5722getTabo7Vup1c());
                                }
                            }, 1, null), NavigationDrawerTokens.INSTANCE.m3281getActiveIndicatorHeightD9Ej5fM()), 0.0f, 1, null), false, shape4, navigationDrawerItemColors2.containerColor(z, startRestartGroup, (i15 & 14) | ((i10 >> 18) & 112)).getValue().m4073unboximpl(), 0L, 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource3, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, 191488423, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$NavigationDrawerItem$3
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
                                    ComposerKt.sourceInformation(composer3, "C744@28638L868:NavigationDrawer.kt#uh7d8r");
                                    if ((i16 & 3) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(191488423, i16, -1, "androidx.compose.material3.NavigationDrawerItem.<anonymous> (NavigationDrawer.kt:744)");
                                        }
                                        Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m6389constructorimpl(16), 0.0f, Dp.m6389constructorimpl(24), 0.0f, 10, null);
                                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                        Function2<Composer, Integer, Unit> function212 = function210;
                                        NavigationDrawerItemColors navigationDrawerItemColors6 = navigationDrawerItemColors5;
                                        boolean z2 = z;
                                        Function2<Composer, Integer, Unit> function213 = function211;
                                        Function2<Composer, Integer, Unit> function214 = function2;
                                        composer3.startReplaceableGroup(693286680);
                                        ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer3, 48);
                                        composer3.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
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
                                        ComposerKt.sourceInformationMarkerStart(composer3, -1538529193, "C753@29036L203:NavigationDrawer.kt#uh7d8r");
                                        composer3.startReplaceableGroup(-1538529193);
                                        ComposerKt.sourceInformation(composer3, "749@28843L19,750@28885L78,751@28980L29");
                                        if (function212 != null) {
                                            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(navigationDrawerItemColors6.iconColor(z2, composer3, 0).getValue().m4073unboximpl())), function212, composer3, ProvidedValue.$stable);
                                            SpacerKt.Spacer(SizeKt.m933width3ABfNKs(Modifier.INSTANCE, Dp.m6389constructorimpl(12)), composer3, 6);
                                        }
                                        composer3.endReplaceableGroup();
                                        Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                                        composer3.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                        composer3.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
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
                                        ComposerKt.sourceInformationMarkerStart(composer3, 1694714143, "C754@29103L19,755@29145L80:NavigationDrawer.kt#uh7d8r");
                                        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(navigationDrawerItemColors6.textColor(z2, composer3, 0).getValue().m4073unboximpl())), function214, composer3, ProvidedValue.$stable);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        composer3.endReplaceableGroup();
                                        composer3.endNode();
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        composer3.startReplaceableGroup(-533536502);
                                        ComposerKt.sourceInformation(composer3, "758@29289L29,759@29359L20,760@29402L80");
                                        if (function213 != null) {
                                            SpacerKt.Spacer(SizeKt.m933width3ABfNKs(Modifier.INSTANCE, Dp.m6389constructorimpl(12)), composer3, 6);
                                            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(navigationDrawerItemColors6.badgeColor(z2, composer3, 0).getValue().m4073unboximpl())), function213, composer3, ProvidedValue.$stable);
                                        }
                                        composer3.endReplaceableGroup();
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
                            }), startRestartGroup, (i15 & 126) | ((i10 >> 6) & 57344), ((i10 >> 24) & 14) | 48, 968);
                            composer2 = startRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            shape5 = shape4;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            navigationDrawerItemColors4 = navigationDrawerItemColors5;
                            modifier3 = modifier4;
                            function27 = function210;
                            function28 = function26;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            mutableInteractionSource4 = mutableInteractionSource2;
                            modifier3 = modifier2;
                            function27 = function24;
                            function28 = function25;
                            shape5 = shape2;
                            composer2 = startRestartGroup;
                            navigationDrawerItemColors4 = navigationDrawerItemColors2;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$NavigationDrawerItem$4
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
                                    NavigationDrawerKt.NavigationDrawerItem(function2, z, function0, modifier3, function27, function28, shape5, navigationDrawerItemColors4, mutableInteractionSource4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    function25 = function23;
                    if ((1572864 & i) == 0) {
                    }
                    if ((12582912 & i) == 0) {
                    }
                    i7 = i2 & 256;
                    if (i7 != 0) {
                    }
                    if ((i8 & 38347923) == 38347922) {
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
                    if ((i2 & 64) != 0) {
                    }
                    int i142 = i8;
                    if ((i2 & 128) != 0) {
                    }
                    if (i7 != 0) {
                    }
                    i10 = i9;
                    function24 = function29;
                    shape4 = shape3;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i152 = i10 >> 3;
                    final Function2<? super Composer, ? super Integer, Unit> function2102 = function24;
                    final NavigationDrawerItemColors navigationDrawerItemColors52 = navigationDrawerItemColors2;
                    final Function2<? super Composer, ? super Integer, Unit> function2112 = function26;
                    Modifier modifier42 = companion;
                    SurfaceKt.m2634Surfaced85dljk(z, function0, SizeKt.fillMaxWidth$default(SizeKt.m914height3ABfNKs(SemanticsModifierKt.semantics$default(companion, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$NavigationDrawerItem$2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5722getTabo7Vup1c());
                        }
                    }, 1, null), NavigationDrawerTokens.INSTANCE.m3281getActiveIndicatorHeightD9Ej5fM()), 0.0f, 1, null), false, shape4, navigationDrawerItemColors2.containerColor(z, startRestartGroup, (i152 & 14) | ((i10 >> 18) & 112)).getValue().m4073unboximpl(), 0L, 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource3, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, 191488423, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$NavigationDrawerItem$3
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
                            ComposerKt.sourceInformation(composer3, "C744@28638L868:NavigationDrawer.kt#uh7d8r");
                            if ((i16 & 3) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(191488423, i16, -1, "androidx.compose.material3.NavigationDrawerItem.<anonymous> (NavigationDrawer.kt:744)");
                                }
                                Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m6389constructorimpl(16), 0.0f, Dp.m6389constructorimpl(24), 0.0f, 10, null);
                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                Function2<Composer, Integer, Unit> function212 = function2102;
                                NavigationDrawerItemColors navigationDrawerItemColors6 = navigationDrawerItemColors52;
                                boolean z2 = z;
                                Function2<Composer, Integer, Unit> function213 = function2112;
                                Function2<Composer, Integer, Unit> function214 = function2;
                                composer3.startReplaceableGroup(693286680);
                                ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer3, 48);
                                composer3.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
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
                                ComposerKt.sourceInformationMarkerStart(composer3, -1538529193, "C753@29036L203:NavigationDrawer.kt#uh7d8r");
                                composer3.startReplaceableGroup(-1538529193);
                                ComposerKt.sourceInformation(composer3, "749@28843L19,750@28885L78,751@28980L29");
                                if (function212 != null) {
                                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(navigationDrawerItemColors6.iconColor(z2, composer3, 0).getValue().m4073unboximpl())), function212, composer3, ProvidedValue.$stable);
                                    SpacerKt.Spacer(SizeKt.m933width3ABfNKs(Modifier.INSTANCE, Dp.m6389constructorimpl(12)), composer3, 6);
                                }
                                composer3.endReplaceableGroup();
                                Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                                composer3.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                composer3.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
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
                                ComposerKt.sourceInformationMarkerStart(composer3, 1694714143, "C754@29103L19,755@29145L80:NavigationDrawer.kt#uh7d8r");
                                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(navigationDrawerItemColors6.textColor(z2, composer3, 0).getValue().m4073unboximpl())), function214, composer3, ProvidedValue.$stable);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endReplaceableGroup();
                                composer3.endNode();
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                composer3.startReplaceableGroup(-533536502);
                                ComposerKt.sourceInformation(composer3, "758@29289L29,759@29359L20,760@29402L80");
                                if (function213 != null) {
                                    SpacerKt.Spacer(SizeKt.m933width3ABfNKs(Modifier.INSTANCE, Dp.m6389constructorimpl(12)), composer3, 6);
                                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(navigationDrawerItemColors6.badgeColor(z2, composer3, 0).getValue().m4073unboximpl())), function213, composer3, ProvidedValue.$stable);
                                }
                                composer3.endReplaceableGroup();
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
                    }), startRestartGroup, (i152 & 126) | ((i10 >> 6) & 57344), ((i10 >> 24) & 14) | 48, 968);
                    composer2 = startRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    shape5 = shape4;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    navigationDrawerItemColors4 = navigationDrawerItemColors52;
                    modifier3 = modifier42;
                    function27 = function2102;
                    function28 = function26;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function24 = function22;
                i6 = i2 & 32;
                if (i6 == 0) {
                }
                function25 = function23;
                if ((1572864 & i) == 0) {
                }
                if ((12582912 & i) == 0) {
                }
                i7 = i2 & 256;
                if (i7 != 0) {
                }
                if ((i8 & 38347923) == 38347922) {
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
                if ((i2 & 64) != 0) {
                }
                int i1422 = i8;
                if ((i2 & 128) != 0) {
                }
                if (i7 != 0) {
                }
                i10 = i9;
                function24 = function29;
                shape4 = shape3;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i1522 = i10 >> 3;
                final Function2<? super Composer, ? super Integer, Unit> function21022 = function24;
                final NavigationDrawerItemColors navigationDrawerItemColors522 = navigationDrawerItemColors2;
                final Function2<? super Composer, ? super Integer, Unit> function21122 = function26;
                Modifier modifier422 = companion;
                SurfaceKt.m2634Surfaced85dljk(z, function0, SizeKt.fillMaxWidth$default(SizeKt.m914height3ABfNKs(SemanticsModifierKt.semantics$default(companion, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$NavigationDrawerItem$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5722getTabo7Vup1c());
                    }
                }, 1, null), NavigationDrawerTokens.INSTANCE.m3281getActiveIndicatorHeightD9Ej5fM()), 0.0f, 1, null), false, shape4, navigationDrawerItemColors2.containerColor(z, startRestartGroup, (i1522 & 14) | ((i10 >> 18) & 112)).getValue().m4073unboximpl(), 0L, 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource3, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, 191488423, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$NavigationDrawerItem$3
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
                        ComposerKt.sourceInformation(composer3, "C744@28638L868:NavigationDrawer.kt#uh7d8r");
                        if ((i16 & 3) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(191488423, i16, -1, "androidx.compose.material3.NavigationDrawerItem.<anonymous> (NavigationDrawer.kt:744)");
                            }
                            Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m6389constructorimpl(16), 0.0f, Dp.m6389constructorimpl(24), 0.0f, 10, null);
                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                            Function2<Composer, Integer, Unit> function212 = function21022;
                            NavigationDrawerItemColors navigationDrawerItemColors6 = navigationDrawerItemColors522;
                            boolean z2 = z;
                            Function2<Composer, Integer, Unit> function213 = function21122;
                            Function2<Composer, Integer, Unit> function214 = function2;
                            composer3.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer3, 48);
                            composer3.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
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
                            ComposerKt.sourceInformationMarkerStart(composer3, -1538529193, "C753@29036L203:NavigationDrawer.kt#uh7d8r");
                            composer3.startReplaceableGroup(-1538529193);
                            ComposerKt.sourceInformation(composer3, "749@28843L19,750@28885L78,751@28980L29");
                            if (function212 != null) {
                                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(navigationDrawerItemColors6.iconColor(z2, composer3, 0).getValue().m4073unboximpl())), function212, composer3, ProvidedValue.$stable);
                                SpacerKt.Spacer(SizeKt.m933width3ABfNKs(Modifier.INSTANCE, Dp.m6389constructorimpl(12)), composer3, 6);
                            }
                            composer3.endReplaceableGroup();
                            Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                            composer3.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                            composer3.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
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
                            ComposerKt.sourceInformationMarkerStart(composer3, 1694714143, "C754@29103L19,755@29145L80:NavigationDrawer.kt#uh7d8r");
                            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(navigationDrawerItemColors6.textColor(z2, composer3, 0).getValue().m4073unboximpl())), function214, composer3, ProvidedValue.$stable);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endReplaceableGroup();
                            composer3.endNode();
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                            composer3.startReplaceableGroup(-533536502);
                            ComposerKt.sourceInformation(composer3, "758@29289L29,759@29359L20,760@29402L80");
                            if (function213 != null) {
                                SpacerKt.Spacer(SizeKt.m933width3ABfNKs(Modifier.INSTANCE, Dp.m6389constructorimpl(12)), composer3, 6);
                                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(navigationDrawerItemColors6.badgeColor(z2, composer3, 0).getValue().m4073unboximpl())), function213, composer3, ProvidedValue.$stable);
                            }
                            composer3.endReplaceableGroup();
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
                }), startRestartGroup, (i1522 & 126) | ((i10 >> 6) & 57344), ((i10 >> 24) & 14) | 48, 968);
                composer2 = startRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                }
                shape5 = shape4;
                mutableInteractionSource4 = mutableInteractionSource3;
                navigationDrawerItemColors4 = navigationDrawerItemColors522;
                modifier3 = modifier422;
                function27 = function21022;
                function28 = function26;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            modifier2 = modifier;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            function24 = function22;
            i6 = i2 & 32;
            if (i6 == 0) {
            }
            function25 = function23;
            if ((1572864 & i) == 0) {
            }
            if ((12582912 & i) == 0) {
            }
            i7 = i2 & 256;
            if (i7 != 0) {
            }
            if ((i8 & 38347923) == 38347922) {
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
            if ((i2 & 64) != 0) {
            }
            int i14222 = i8;
            if ((i2 & 128) != 0) {
            }
            if (i7 != 0) {
            }
            i10 = i9;
            function24 = function29;
            shape4 = shape3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i15222 = i10 >> 3;
            final Function2<? super Composer, ? super Integer, Unit> function210222 = function24;
            final NavigationDrawerItemColors navigationDrawerItemColors5222 = navigationDrawerItemColors2;
            final Function2<? super Composer, ? super Integer, Unit> function211222 = function26;
            Modifier modifier4222 = companion;
            SurfaceKt.m2634Surfaced85dljk(z, function0, SizeKt.fillMaxWidth$default(SizeKt.m914height3ABfNKs(SemanticsModifierKt.semantics$default(companion, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$NavigationDrawerItem$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5722getTabo7Vup1c());
                }
            }, 1, null), NavigationDrawerTokens.INSTANCE.m3281getActiveIndicatorHeightD9Ej5fM()), 0.0f, 1, null), false, shape4, navigationDrawerItemColors2.containerColor(z, startRestartGroup, (i15222 & 14) | ((i10 >> 18) & 112)).getValue().m4073unboximpl(), 0L, 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource3, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, 191488423, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$NavigationDrawerItem$3
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
                    ComposerKt.sourceInformation(composer3, "C744@28638L868:NavigationDrawer.kt#uh7d8r");
                    if ((i16 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(191488423, i16, -1, "androidx.compose.material3.NavigationDrawerItem.<anonymous> (NavigationDrawer.kt:744)");
                        }
                        Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m6389constructorimpl(16), 0.0f, Dp.m6389constructorimpl(24), 0.0f, 10, null);
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        Function2<Composer, Integer, Unit> function212 = function210222;
                        NavigationDrawerItemColors navigationDrawerItemColors6 = navigationDrawerItemColors5222;
                        boolean z2 = z;
                        Function2<Composer, Integer, Unit> function213 = function211222;
                        Function2<Composer, Integer, Unit> function214 = function2;
                        composer3.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer3, 48);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
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
                        ComposerKt.sourceInformationMarkerStart(composer3, -1538529193, "C753@29036L203:NavigationDrawer.kt#uh7d8r");
                        composer3.startReplaceableGroup(-1538529193);
                        ComposerKt.sourceInformation(composer3, "749@28843L19,750@28885L78,751@28980L29");
                        if (function212 != null) {
                            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(navigationDrawerItemColors6.iconColor(z2, composer3, 0).getValue().m4073unboximpl())), function212, composer3, ProvidedValue.$stable);
                            SpacerKt.Spacer(SizeKt.m933width3ABfNKs(Modifier.INSTANCE, Dp.m6389constructorimpl(12)), composer3, 6);
                        }
                        composer3.endReplaceableGroup();
                        Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                        composer3.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
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
                        ComposerKt.sourceInformationMarkerStart(composer3, 1694714143, "C754@29103L19,755@29145L80:NavigationDrawer.kt#uh7d8r");
                        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(navigationDrawerItemColors6.textColor(z2, composer3, 0).getValue().m4073unboximpl())), function214, composer3, ProvidedValue.$stable);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        composer3.startReplaceableGroup(-533536502);
                        ComposerKt.sourceInformation(composer3, "758@29289L29,759@29359L20,760@29402L80");
                        if (function213 != null) {
                            SpacerKt.Spacer(SizeKt.m933width3ABfNKs(Modifier.INSTANCE, Dp.m6389constructorimpl(12)), composer3, 6);
                            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(navigationDrawerItemColors6.badgeColor(z2, composer3, 0).getValue().m4073unboximpl())), function213, composer3, ProvidedValue.$stable);
                        }
                        composer3.endReplaceableGroup();
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
            }), startRestartGroup, (i15222 & 126) | ((i10 >> 6) & 57344), ((i10 >> 24) & 14) | 48, 968);
            composer2 = startRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
            }
            shape5 = shape4;
            mutableInteractionSource4 = mutableInteractionSource3;
            navigationDrawerItemColors4 = navigationDrawerItemColors5222;
            modifier3 = modifier4222;
            function27 = function210222;
            function28 = function26;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        modifier2 = modifier;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        function24 = function22;
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        function25 = function23;
        if ((1572864 & i) == 0) {
        }
        if ((12582912 & i) == 0) {
        }
        i7 = i2 & 256;
        if (i7 != 0) {
        }
        if ((i8 & 38347923) == 38347922) {
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
        if ((i2 & 64) != 0) {
        }
        int i142222 = i8;
        if ((i2 & 128) != 0) {
        }
        if (i7 != 0) {
        }
        i10 = i9;
        function24 = function29;
        shape4 = shape3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i152222 = i10 >> 3;
        final Function2<? super Composer, ? super Integer, Unit> function2102222 = function24;
        final NavigationDrawerItemColors navigationDrawerItemColors52222 = navigationDrawerItemColors2;
        final Function2<? super Composer, ? super Integer, Unit> function2112222 = function26;
        Modifier modifier42222 = companion;
        SurfaceKt.m2634Surfaced85dljk(z, function0, SizeKt.fillMaxWidth$default(SizeKt.m914height3ABfNKs(SemanticsModifierKt.semantics$default(companion, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$NavigationDrawerItem$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5722getTabo7Vup1c());
            }
        }, 1, null), NavigationDrawerTokens.INSTANCE.m3281getActiveIndicatorHeightD9Ej5fM()), 0.0f, 1, null), false, shape4, navigationDrawerItemColors2.containerColor(z, startRestartGroup, (i152222 & 14) | ((i10 >> 18) & 112)).getValue().m4073unboximpl(), 0L, 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource3, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, 191488423, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$NavigationDrawerItem$3
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
                ComposerKt.sourceInformation(composer3, "C744@28638L868:NavigationDrawer.kt#uh7d8r");
                if ((i16 & 3) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(191488423, i16, -1, "androidx.compose.material3.NavigationDrawerItem.<anonymous> (NavigationDrawer.kt:744)");
                    }
                    Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m6389constructorimpl(16), 0.0f, Dp.m6389constructorimpl(24), 0.0f, 10, null);
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    Function2<Composer, Integer, Unit> function212 = function2102222;
                    NavigationDrawerItemColors navigationDrawerItemColors6 = navigationDrawerItemColors52222;
                    boolean z2 = z;
                    Function2<Composer, Integer, Unit> function213 = function2112222;
                    Function2<Composer, Integer, Unit> function214 = function2;
                    composer3.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer3, 48);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
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
                    ComposerKt.sourceInformationMarkerStart(composer3, -1538529193, "C753@29036L203:NavigationDrawer.kt#uh7d8r");
                    composer3.startReplaceableGroup(-1538529193);
                    ComposerKt.sourceInformation(composer3, "749@28843L19,750@28885L78,751@28980L29");
                    if (function212 != null) {
                        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(navigationDrawerItemColors6.iconColor(z2, composer3, 0).getValue().m4073unboximpl())), function212, composer3, ProvidedValue.$stable);
                        SpacerKt.Spacer(SizeKt.m933width3ABfNKs(Modifier.INSTANCE, Dp.m6389constructorimpl(12)), composer3, 6);
                    }
                    composer3.endReplaceableGroup();
                    Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                    composer3.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
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
                    ComposerKt.sourceInformationMarkerStart(composer3, 1694714143, "C754@29103L19,755@29145L80:NavigationDrawer.kt#uh7d8r");
                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(navigationDrawerItemColors6.textColor(z2, composer3, 0).getValue().m4073unboximpl())), function214, composer3, ProvidedValue.$stable);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    composer3.startReplaceableGroup(-533536502);
                    ComposerKt.sourceInformation(composer3, "758@29289L29,759@29359L20,760@29402L80");
                    if (function213 != null) {
                        SpacerKt.Spacer(SizeKt.m933width3ABfNKs(Modifier.INSTANCE, Dp.m6389constructorimpl(12)), composer3, 6);
                        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(navigationDrawerItemColors6.badgeColor(z2, composer3, 0).getValue().m4073unboximpl())), function213, composer3, ProvidedValue.$stable);
                    }
                    composer3.endReplaceableGroup();
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
        }), startRestartGroup, (i152222 & 126) | ((i10 >> 6) & 57344), ((i10 >> 24) & 14) | 48, 968);
        composer2 = startRestartGroup;
        if (ComposerKt.isTraceInProgress()) {
        }
        shape5 = shape4;
        mutableInteractionSource4 = mutableInteractionSource3;
        navigationDrawerItemColors4 = navigationDrawerItemColors52222;
        modifier3 = modifier42222;
        function27 = function2102222;
        function28 = function26;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calculateFraction(float f, float f2, float f3) {
        return RangesKt.coerceIn((f3 - f) / (f2 - f), 0.0f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Scrim-Bx497Mc, reason: not valid java name */
    public static final void m2359ScrimBx497Mc(final boolean z, final Function0<Unit> function0, final Function0<Float> function02, final long j, Composer composer, final int i) {
        int i2;
        int i3;
        Modifier.Companion companion;
        Composer startRestartGroup = composer.startRestartGroup(2106487387);
        ComposerKt.sourceInformation(startRestartGroup, "C(Scrim)P(3,2,1,0:c#ui.graphics.Color)919@35520L30,935@35964L51,931@35873L142:NavigationDrawer.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function02) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(j) ? 2048 : 1024;
        }
        if ((i2 & 1171) != 1170 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2106487387, i2, -1, "androidx.compose.material3.Scrim (NavigationDrawer.kt:918)");
            }
            Strings.Companion companion2 = Strings.INSTANCE;
            final String m2623getStringNWtq28 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(androidx.compose.ui.R.string.close_drawer), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1858700652);
            ComposerKt.sourceInformation(startRestartGroup, "922@35639L35,923@35723L108");
            if (z) {
                Modifier.Companion companion3 = Modifier.INSTANCE;
                startRestartGroup.startReplaceableGroup(-1858700588);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                int i4 = i2 & 112;
                boolean z2 = i4 == 32;
                NavigationDrawerKt$Scrim$dismissDrawer$1$1 rememberedValue = startRestartGroup.rememberedValue();
                if (z2 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new NavigationDrawerKt$Scrim$dismissDrawer$1$1(function0, null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceableGroup();
                Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(companion3, function0, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue);
                startRestartGroup.startReplaceableGroup(-1858700504);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                boolean changed = (i4 == 32) | startRestartGroup.changed(m2623getStringNWtq28);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$Scrim$dismissDrawer$2$1
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
                            SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, m2623getStringNWtq28);
                            final Function0<Unit> function03 = function0;
                            SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$Scrim$dismissDrawer$2$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    function03.invoke();
                                    return true;
                                }
                            }, 1, null);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceableGroup();
                i3 = 1;
                companion = SemanticsModifierKt.semantics(pointerInput, true, (Function1) rememberedValue2);
            } else {
                i3 = 1;
                companion = Modifier.INSTANCE;
            }
            startRestartGroup.endReplaceableGroup();
            Modifier then = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, i3, null).then(companion);
            startRestartGroup.startReplaceableGroup(-1858700263);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
            int i5 = ((i2 & 7168) == 2048 ? i3 : 0) | ((i2 & 896) == 256 ? i3 : 0);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (i5 != 0 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$Scrim$1$1
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
                        DrawScope.m4607drawRectnJ9OG0$default(drawScope, j, 0L, 0L, function02.invoke().floatValue(), null, null, 0, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, null);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(then, (Function1) rememberedValue3, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$Scrim$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i6) {
                    NavigationDrawerKt.m2359ScrimBx497Mc(z, function0, function02, j, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
