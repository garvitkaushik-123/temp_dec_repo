package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.material3.tokens.BottomAppBarTokens;
import androidx.compose.material3.tokens.TopAppBarLargeTokens;
import androidx.compose.material3.tokens.TopAppBarMediumTokens;
import androidx.compose.material3.tokens.TopAppBarSmallTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import com.vungle.ads.internal.protos.Sdk;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* compiled from: AppBar.kt */
@Metadata(d1 = {"\u0000®\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0083\u0001\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"H\u0007ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u008f\u0001\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&H\u0007ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001al\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\u001c\u0010)\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001ax\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\u001c\u0010)\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b,\u0010-\u001a \u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u000201H\u0007\u001a\u007f\u00104\u001a\u00020\u00112\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u00107\u001a\u0002082\n\b\u0002\u0010%\u001a\u0004\u0018\u000109H\u0007¢\u0006\u0002\u0010:\u001a\u007f\u0010;\u001a\u00020\u00112\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u00107\u001a\u0002082\n\b\u0002\u0010%\u001a\u0004\u0018\u000109H\u0007¢\u0006\u0002\u0010:\u001a\u007f\u0010<\u001a\u00020\u00112\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u00107\u001a\u0002082\n\b\u0002\u0010%\u001a\u0004\u0018\u000109H\u0007¢\u0006\u0002\u0010:\u001a\u0085\u0001\u0010=\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0011\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\u0006\u0010!\u001a\u00020\"2\u0006\u00107\u001a\u0002082\b\u0010%\u001a\u0004\u0018\u000109H\u0003¢\u0006\u0002\u0010B\u001a\u007f\u0010C\u001a\u00020\u00112\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u00107\u001a\u0002082\n\b\u0002\u0010%\u001a\u0004\u0018\u000109H\u0007¢\u0006\u0002\u0010:\u001a\u007f\u0010D\u001a\u00020\u00112\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u00107\u001a\u0002082\n\b\u0002\u0010%\u001a\u0004\u0018\u000109H\u0007¢\u0006\u0002\u0010:\u001a£\u0001\u0010E\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010F\u001a\u0002012\u0006\u0010G\u001a\u00020\u001c2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001c2\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0006\u0010>\u001a\u00020?2\u0006\u0010J\u001a\u0002012\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020A2\u0011\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u0015H\u0003ø\u0001\u0000¢\u0006\u0004\bR\u0010S\u001aµ\u0001\u0010T\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0006\u0010>\u001a\u00020?2\u0006\u0010O\u001a\u00020\u00012\u0011\u0010U\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0006\u0010V\u001a\u00020?2\u0011\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\u0006\u0010!\u001a\u00020\"2\u0006\u00107\u001a\u0002082\u0006\u0010W\u001a\u00020\u00012\u0006\u0010X\u001a\u00020\u00012\b\u0010%\u001a\u0004\u0018\u000109H\u0003ø\u0001\u0000¢\u0006\u0004\bY\u0010Z\u001a+\u0010[\u001a\u00020/2\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u0002012\b\b\u0002\u00103\u001a\u000201H\u0007¢\u0006\u0002\u0010\\\u001a+\u0010]\u001a\u00020^2\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u0002012\b\b\u0002\u00103\u001a\u000201H\u0007¢\u0006\u0002\u0010_\u001a>\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020^2\u0006\u0010c\u001a\u0002012\u000e\u0010d\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010e2\u000e\u0010f\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010gH\u0082@¢\u0006\u0002\u0010h\u001a>\u0010i\u001a\u00020a2\u0006\u0010b\u001a\u00020/2\u0006\u0010c\u001a\u0002012\u000e\u0010d\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010e2\u000e\u0010f\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010gH\u0083@¢\u0006\u0002\u0010j\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0016\u0010\u0003\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0004\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\f\u001a\u00020\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006k²\u0006\n\u0010l\u001a\u00020\u001cX\u008a\u0084\u0002"}, d2 = {"BottomAppBarHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "BottomAppBarVerticalPadding", "getBottomAppBarVerticalPadding", "()F", "FABHorizontalPadding", "FABVerticalPadding", "LargeTitleBottomPadding", "MediumTitleBottomPadding", "TopAppBarHorizontalPadding", "TopAppBarTitleInset", "TopTitleAlphaEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "getTopTitleAlphaEasing", "()Landroidx/compose/animation/core/CubicBezierEasing;", "BottomAppBar", "", "actions", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "floatingActionButton", "Lkotlin/Function0;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "BottomAppBar-Snr_uVM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/runtime/Composer;II)V", "scrollBehavior", "Landroidx/compose/material3/BottomAppBarScrollBehavior;", "BottomAppBar-qhFBPw4", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/BottomAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "content", "BottomAppBar-1oL4kX8", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomAppBar-e-3WI5M", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/BottomAppBarScrollBehavior;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomAppBarState", "Landroidx/compose/material3/BottomAppBarState;", "initialHeightOffsetLimit", "", "initialHeightOffset", "initialContentOffset", "CenterAlignedTopAppBar", "title", "navigationIcon", "colors", "Landroidx/compose/material3/TopAppBarColors;", "Landroidx/compose/material3/TopAppBarScrollBehavior;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "LargeTopAppBar", "MediumTopAppBar", "SingleRowTopAppBar", "titleTextStyle", "Landroidx/compose/ui/text/TextStyle;", "centeredTitle", "", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "SmallTopAppBar", "TopAppBar", "TopAppBarLayout", "heightPx", "navigationIconContentColor", "titleContentColor", "actionIconContentColor", "titleAlpha", "titleVerticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "titleHorizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "titleBottomPadding", "", "hideTitleSemantics", "TopAppBarLayout-kXwM9vE", "(Landroidx/compose/ui/Modifier;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;FLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;IZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TwoRowsTopAppBar", "smallTitle", "smallTitleTextStyle", "maxHeight", "pinnedHeight", "TwoRowsTopAppBar-tjU4iQQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;FLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;FFLandroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;III)V", "rememberBottomAppBarState", "(FFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/BottomAppBarState;", "rememberTopAppBarState", "Landroidx/compose/material3/TopAppBarState;", "(FFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarState;", "settleAppBar", "Landroidx/compose/ui/unit/Velocity;", "state", "velocity", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/material3/TopAppBarState;FLandroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "settleAppBarBottom", "(Landroidx/compose/material3/BottomAppBarState;FLandroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material3_release", "appBarContainerColor"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AppBarKt {
    private static final float BottomAppBarHorizontalPadding;
    private static final float BottomAppBarVerticalPadding;
    private static final float FABHorizontalPadding;
    private static final float FABVerticalPadding;
    private static final float LargeTitleBottomPadding;
    private static final float MediumTitleBottomPadding;
    private static final float TopAppBarHorizontalPadding;
    private static final float TopAppBarTitleInset;
    private static final CubicBezierEasing TopTitleAlphaEasing;

    /* JADX WARN: Removed duplicated region for block: B:102:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TopAppBar(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, Composer composer, final int i, final int i2) {
        Function2<? super Composer, ? super Integer, Unit> function23;
        int i3;
        Modifier modifier2;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i5;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32;
        WindowInsets windowInsets2;
        TopAppBarColors topAppBarColors2;
        int i6;
        TopAppBarScrollBehavior topAppBarScrollBehavior2;
        Function2<? super Composer, ? super Integer, Unit> function25;
        TopAppBarColors topAppBarColors3;
        TopAppBarScrollBehavior topAppBarScrollBehavior3;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33;
        Modifier modifier3;
        int i7;
        Composer composer2;
        final Modifier modifier4;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function34;
        final WindowInsets windowInsets3;
        final TopAppBarColors topAppBarColors4;
        final TopAppBarScrollBehavior topAppBarScrollBehavior4;
        ScopeUpdateScope endRestartGroup;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(1906353009);
        ComposerKt.sourceInformation(startRestartGroup, "C(TopAppBar)P(5,2,3!1,6)126@6292L12,127@6354L17,133@6544L10,130@6433L374:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function23 = function2;
        } else {
            function23 = function2;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changedInstance(function23) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i10 = i2 & 2;
        if (i10 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                function24 = function22;
                i3 |= startRestartGroup.changedInstance(function24) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    function32 = function3;
                    i3 |= startRestartGroup.changedInstance(function32) ? 2048 : 1024;
                    if ((i & 24576) != 0) {
                        if ((i2 & 16) == 0) {
                            windowInsets2 = windowInsets;
                            if (startRestartGroup.changed(windowInsets2)) {
                                i9 = 16384;
                                i3 |= i9;
                            }
                        } else {
                            windowInsets2 = windowInsets;
                        }
                        i9 = 8192;
                        i3 |= i9;
                    } else {
                        windowInsets2 = windowInsets;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            topAppBarColors2 = topAppBarColors;
                            if (startRestartGroup.changed(topAppBarColors2)) {
                                i8 = 131072;
                                i3 |= i8;
                            }
                        } else {
                            topAppBarColors2 = topAppBarColors;
                        }
                        i8 = 65536;
                        i3 |= i8;
                    } else {
                        topAppBarColors2 = topAppBarColors;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((1572864 & i) == 0) {
                        topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                        i3 |= startRestartGroup.changed(topAppBarScrollBehavior2) ? 1048576 : 524288;
                        if ((599187 & i3) == 599186 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i10 != 0 ? Modifier.INSTANCE : modifier2;
                                if (i4 != 0) {
                                    function24 = ComposableSingletons$AppBarKt.INSTANCE.m2059getLambda1$material3_release();
                                }
                                if (i5 != 0) {
                                    function32 = ComposableSingletons$AppBarKt.INSTANCE.m2063getLambda2$material3_release();
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                    topAppBarColors2 = TopAppBarDefaults.INSTANCE.topAppBarColors(startRestartGroup, 6);
                                }
                                if (i6 != 0) {
                                    topAppBarScrollBehavior3 = null;
                                    function25 = function24;
                                    function33 = function32;
                                    topAppBarColors3 = topAppBarColors2;
                                } else {
                                    function25 = function24;
                                    topAppBarColors3 = topAppBarColors2;
                                    topAppBarScrollBehavior3 = topAppBarScrollBehavior2;
                                    function33 = function32;
                                }
                                modifier3 = companion;
                                i7 = 1906353009;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                function25 = function24;
                                topAppBarColors3 = topAppBarColors2;
                                topAppBarScrollBehavior3 = topAppBarScrollBehavior2;
                                i7 = 1906353009;
                                function33 = function32;
                                modifier3 = modifier2;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i7, i3, -1, "androidx.compose.material3.TopAppBar (AppBar.kt:129)");
                            }
                            int i11 = ((i3 >> 3) & 14) | 3072 | ((i3 << 3) & 112);
                            int i12 = i3 << 6;
                            composer2 = startRestartGroup;
                            WindowInsets windowInsets4 = windowInsets2;
                            SingleRowTopAppBar(modifier3, function23, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TopAppBarSmallTokens.INSTANCE.getHeadlineFont()), false, function25, function33, windowInsets4, topAppBarColors3, topAppBarScrollBehavior3, composer2, i11 | (57344 & i12) | (458752 & i12) | (3670016 & i12) | (29360128 & i12) | (i12 & 234881024), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier4 = modifier3;
                            function26 = function25;
                            function34 = function33;
                            windowInsets3 = windowInsets4;
                            topAppBarColors4 = topAppBarColors3;
                            topAppBarScrollBehavior4 = topAppBarScrollBehavior3;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            composer2 = startRestartGroup;
                            modifier4 = modifier2;
                            function26 = function24;
                            function34 = function32;
                            windowInsets3 = windowInsets2;
                            topAppBarColors4 = topAppBarColors2;
                            topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$TopAppBar$1
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
                                    AppBarKt.TopAppBar(function2, modifier4, function26, function34, windowInsets3, topAppBarColors4, topAppBarScrollBehavior4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                    if ((599187 & i3) == 599186) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if (i6 != 0) {
                    }
                    modifier3 = companion;
                    i7 = 1906353009;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i112 = ((i3 >> 3) & 14) | 3072 | ((i3 << 3) & 112);
                    int i122 = i3 << 6;
                    composer2 = startRestartGroup;
                    WindowInsets windowInsets42 = windowInsets2;
                    SingleRowTopAppBar(modifier3, function23, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TopAppBarSmallTokens.INSTANCE.getHeadlineFont()), false, function25, function33, windowInsets42, topAppBarColors3, topAppBarScrollBehavior3, composer2, i112 | (57344 & i122) | (458752 & i122) | (3670016 & i122) | (29360128 & i122) | (i122 & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier4 = modifier3;
                    function26 = function25;
                    function34 = function33;
                    windowInsets3 = windowInsets42;
                    topAppBarColors4 = topAppBarColors3;
                    topAppBarScrollBehavior4 = topAppBarScrollBehavior3;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function32 = function3;
                if ((i & 24576) != 0) {
                }
                if ((196608 & i) != 0) {
                }
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                if ((599187 & i3) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i10 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if (i6 != 0) {
                }
                modifier3 = companion;
                i7 = 1906353009;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i1122 = ((i3 >> 3) & 14) | 3072 | ((i3 << 3) & 112);
                int i1222 = i3 << 6;
                composer2 = startRestartGroup;
                WindowInsets windowInsets422 = windowInsets2;
                SingleRowTopAppBar(modifier3, function23, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TopAppBarSmallTokens.INSTANCE.getHeadlineFont()), false, function25, function33, windowInsets422, topAppBarColors3, topAppBarScrollBehavior3, composer2, i1122 | (57344 & i1222) | (458752 & i1222) | (3670016 & i1222) | (29360128 & i1222) | (i1222 & 234881024), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier4 = modifier3;
                function26 = function25;
                function34 = function33;
                windowInsets3 = windowInsets422;
                topAppBarColors4 = topAppBarColors3;
                topAppBarScrollBehavior4 = topAppBarScrollBehavior3;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function24 = function22;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            function32 = function3;
            if ((i & 24576) != 0) {
            }
            if ((196608 & i) != 0) {
            }
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            topAppBarScrollBehavior2 = topAppBarScrollBehavior;
            if ((599187 & i3) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i10 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if (i6 != 0) {
            }
            modifier3 = companion;
            i7 = 1906353009;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i11222 = ((i3 >> 3) & 14) | 3072 | ((i3 << 3) & 112);
            int i12222 = i3 << 6;
            composer2 = startRestartGroup;
            WindowInsets windowInsets4222 = windowInsets2;
            SingleRowTopAppBar(modifier3, function23, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TopAppBarSmallTokens.INSTANCE.getHeadlineFont()), false, function25, function33, windowInsets4222, topAppBarColors3, topAppBarScrollBehavior3, composer2, i11222 | (57344 & i12222) | (458752 & i12222) | (3670016 & i12222) | (29360128 & i12222) | (i12222 & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier4 = modifier3;
            function26 = function25;
            function34 = function33;
            windowInsets3 = windowInsets4222;
            topAppBarColors4 = topAppBarColors3;
            topAppBarScrollBehavior4 = topAppBarScrollBehavior3;
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
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        topAppBarScrollBehavior2 = topAppBarScrollBehavior;
        if ((599187 & i3) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i10 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if (i6 != 0) {
        }
        modifier3 = companion;
        i7 = 1906353009;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i112222 = ((i3 >> 3) & 14) | 3072 | ((i3 << 3) & 112);
        int i122222 = i3 << 6;
        composer2 = startRestartGroup;
        WindowInsets windowInsets42222 = windowInsets2;
        SingleRowTopAppBar(modifier3, function23, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TopAppBarSmallTokens.INSTANCE.getHeadlineFont()), false, function25, function33, windowInsets42222, topAppBarColors3, topAppBarScrollBehavior3, composer2, i112222 | (57344 & i122222) | (458752 & i122222) | (3670016 & i122222) | (29360128 & i122222) | (i122222 & 234881024), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        function26 = function25;
        function34 = function33;
        windowInsets3 = windowInsets42222;
        topAppBarColors4 = topAppBarColors3;
        topAppBarScrollBehavior4 = topAppBarScrollBehavior3;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x006a  */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Use TopAppBar instead.", replaceWith = @ReplaceWith(expression = "TopAppBar(title, modifier, navigationIcon, actions, windowInsets, colors, scrollBehavior)", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SmallTopAppBar(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, Composer composer, final int i, final int i2) {
        Function2<? super Composer, ? super Integer, Unit> function23;
        int i3;
        Modifier modifier2;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i5;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32;
        WindowInsets windowInsets2;
        TopAppBarColors topAppBarColors2;
        int i6;
        TopAppBarScrollBehavior topAppBarScrollBehavior2;
        WindowInsets windowInsets3;
        TopAppBarScrollBehavior topAppBarScrollBehavior3;
        Function2<? super Composer, ? super Integer, Unit> function25;
        TopAppBarColors topAppBarColors3;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33;
        Modifier modifier3;
        Composer composer2;
        final Modifier modifier4;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function34;
        final WindowInsets windowInsets4;
        final TopAppBarColors topAppBarColors4;
        final TopAppBarScrollBehavior topAppBarScrollBehavior4;
        ScopeUpdateScope endRestartGroup;
        int i7;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(-1967617284);
        ComposerKt.sourceInformation(startRestartGroup, "C(SmallTopAppBar)P(5,2,3!1,6)189@9271L12,190@9333L17,192@9408L89:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function23 = function2;
        } else {
            function23 = function2;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changedInstance(function23) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i9 = i2 & 2;
        if (i9 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                function24 = function22;
                i3 |= startRestartGroup.changedInstance(function24) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    function32 = function3;
                    i3 |= startRestartGroup.changedInstance(function32) ? 2048 : 1024;
                    if ((i & 24576) != 0) {
                        if ((i2 & 16) == 0) {
                            windowInsets2 = windowInsets;
                            if (startRestartGroup.changed(windowInsets2)) {
                                i8 = 16384;
                                i3 |= i8;
                            }
                        } else {
                            windowInsets2 = windowInsets;
                        }
                        i8 = 8192;
                        i3 |= i8;
                    } else {
                        windowInsets2 = windowInsets;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            topAppBarColors2 = topAppBarColors;
                            if (startRestartGroup.changed(topAppBarColors2)) {
                                i7 = 131072;
                                i3 |= i7;
                            }
                        } else {
                            topAppBarColors2 = topAppBarColors;
                        }
                        i7 = 65536;
                        i3 |= i7;
                    } else {
                        topAppBarColors2 = topAppBarColors;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((1572864 & i) == 0) {
                        topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                        i3 |= startRestartGroup.changed(topAppBarScrollBehavior2) ? 1048576 : 524288;
                        if ((599187 & i3) == 599186 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i9 != 0 ? Modifier.INSTANCE : modifier2;
                                if (i4 != 0) {
                                    function24 = ComposableSingletons$AppBarKt.INSTANCE.m2064getLambda3$material3_release();
                                }
                                if (i5 != 0) {
                                    function32 = ComposableSingletons$AppBarKt.INSTANCE.m2065getLambda4$material3_release();
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                    topAppBarColors2 = TopAppBarDefaults.INSTANCE.topAppBarColors(startRestartGroup, 6);
                                }
                                if (i6 != 0) {
                                    topAppBarScrollBehavior3 = null;
                                    windowInsets3 = windowInsets2;
                                    topAppBarColors3 = topAppBarColors2;
                                    function25 = function24;
                                } else {
                                    windowInsets3 = windowInsets2;
                                    topAppBarScrollBehavior3 = topAppBarScrollBehavior2;
                                    function25 = function24;
                                    topAppBarColors3 = topAppBarColors2;
                                }
                                function33 = function32;
                                modifier3 = companion;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                windowInsets3 = windowInsets2;
                                topAppBarScrollBehavior3 = topAppBarScrollBehavior2;
                                function25 = function24;
                                topAppBarColors3 = topAppBarColors2;
                                function33 = function32;
                                modifier3 = modifier2;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1967617284, i3, -1, "androidx.compose.material3.SmallTopAppBar (AppBar.kt:192)");
                            }
                            composer2 = startRestartGroup;
                            TopAppBar(function23, modifier3, function25, function33, windowInsets3, topAppBarColors3, topAppBarScrollBehavior3, composer2, i3 & 4194302, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier4 = modifier3;
                            function26 = function25;
                            function34 = function33;
                            windowInsets4 = windowInsets3;
                            topAppBarColors4 = topAppBarColors3;
                            topAppBarScrollBehavior4 = topAppBarScrollBehavior3;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            composer2 = startRestartGroup;
                            modifier4 = modifier2;
                            function26 = function24;
                            function34 = function32;
                            windowInsets4 = windowInsets2;
                            topAppBarColors4 = topAppBarColors2;
                            topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$SmallTopAppBar$1
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
                                    AppBarKt.SmallTopAppBar(function2, modifier4, function26, function34, windowInsets4, topAppBarColors4, topAppBarScrollBehavior4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                    if ((599187 & i3) == 599186) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if (i6 != 0) {
                    }
                    function33 = function32;
                    modifier3 = companion;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2 = startRestartGroup;
                    TopAppBar(function23, modifier3, function25, function33, windowInsets3, topAppBarColors3, topAppBarScrollBehavior3, composer2, i3 & 4194302, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier4 = modifier3;
                    function26 = function25;
                    function34 = function33;
                    windowInsets4 = windowInsets3;
                    topAppBarColors4 = topAppBarColors3;
                    topAppBarScrollBehavior4 = topAppBarScrollBehavior3;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function32 = function3;
                if ((i & 24576) != 0) {
                }
                if ((196608 & i) != 0) {
                }
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                if ((599187 & i3) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i9 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if (i6 != 0) {
                }
                function33 = function32;
                modifier3 = companion;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                TopAppBar(function23, modifier3, function25, function33, windowInsets3, topAppBarColors3, topAppBarScrollBehavior3, composer2, i3 & 4194302, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier4 = modifier3;
                function26 = function25;
                function34 = function33;
                windowInsets4 = windowInsets3;
                topAppBarColors4 = topAppBarColors3;
                topAppBarScrollBehavior4 = topAppBarScrollBehavior3;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function24 = function22;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            function32 = function3;
            if ((i & 24576) != 0) {
            }
            if ((196608 & i) != 0) {
            }
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            topAppBarScrollBehavior2 = topAppBarScrollBehavior;
            if ((599187 & i3) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i9 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if (i6 != 0) {
            }
            function33 = function32;
            modifier3 = companion;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            TopAppBar(function23, modifier3, function25, function33, windowInsets3, topAppBarColors3, topAppBarScrollBehavior3, composer2, i3 & 4194302, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier4 = modifier3;
            function26 = function25;
            function34 = function33;
            windowInsets4 = windowInsets3;
            topAppBarColors4 = topAppBarColors3;
            topAppBarScrollBehavior4 = topAppBarScrollBehavior3;
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
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        topAppBarScrollBehavior2 = topAppBarScrollBehavior;
        if ((599187 & i3) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i9 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if (i6 != 0) {
        }
        function33 = function32;
        modifier3 = companion;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        TopAppBar(function23, modifier3, function25, function33, windowInsets3, topAppBarColors3, topAppBarScrollBehavior3, composer2, i3 & 4194302, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        function26 = function25;
        function34 = function33;
        windowInsets4 = windowInsets3;
        topAppBarColors4 = topAppBarColors3;
        topAppBarScrollBehavior4 = topAppBarScrollBehavior3;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void CenterAlignedTopAppBar(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, Composer composer, final int i, final int i2) {
        Function2<? super Composer, ? super Integer, Unit> function23;
        int i3;
        Modifier modifier2;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i5;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32;
        WindowInsets windowInsets2;
        TopAppBarColors topAppBarColors2;
        int i6;
        TopAppBarScrollBehavior topAppBarScrollBehavior2;
        Function2<? super Composer, ? super Integer, Unit> function25;
        TopAppBarColors topAppBarColors3;
        TopAppBarScrollBehavior topAppBarScrollBehavior3;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33;
        Modifier modifier3;
        int i7;
        Composer composer2;
        final Modifier modifier4;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function34;
        final WindowInsets windowInsets3;
        final TopAppBarColors topAppBarColors4;
        final TopAppBarScrollBehavior topAppBarScrollBehavior4;
        ScopeUpdateScope endRestartGroup;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(-2139286460);
        ComposerKt.sourceInformation(startRestartGroup, "C(CenterAlignedTopAppBar)P(5,2,3!1,6)230@11690L12,231@11752L30,238@11963L10,234@11844L381:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function23 = function2;
        } else {
            function23 = function2;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changedInstance(function23) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i10 = i2 & 2;
        if (i10 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                function24 = function22;
                i3 |= startRestartGroup.changedInstance(function24) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    function32 = function3;
                    i3 |= startRestartGroup.changedInstance(function32) ? 2048 : 1024;
                    if ((i & 24576) != 0) {
                        if ((i2 & 16) == 0) {
                            windowInsets2 = windowInsets;
                            if (startRestartGroup.changed(windowInsets2)) {
                                i9 = 16384;
                                i3 |= i9;
                            }
                        } else {
                            windowInsets2 = windowInsets;
                        }
                        i9 = 8192;
                        i3 |= i9;
                    } else {
                        windowInsets2 = windowInsets;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            topAppBarColors2 = topAppBarColors;
                            if (startRestartGroup.changed(topAppBarColors2)) {
                                i8 = 131072;
                                i3 |= i8;
                            }
                        } else {
                            topAppBarColors2 = topAppBarColors;
                        }
                        i8 = 65536;
                        i3 |= i8;
                    } else {
                        topAppBarColors2 = topAppBarColors;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((1572864 & i) == 0) {
                        topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                        i3 |= startRestartGroup.changed(topAppBarScrollBehavior2) ? 1048576 : 524288;
                        if ((599187 & i3) == 599186 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i10 != 0 ? Modifier.INSTANCE : modifier2;
                                if (i4 != 0) {
                                    function24 = ComposableSingletons$AppBarKt.INSTANCE.m2066getLambda5$material3_release();
                                }
                                if (i5 != 0) {
                                    function32 = ComposableSingletons$AppBarKt.INSTANCE.m2067getLambda6$material3_release();
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                    topAppBarColors2 = TopAppBarDefaults.INSTANCE.centerAlignedTopAppBarColors(startRestartGroup, 6);
                                }
                                if (i6 != 0) {
                                    topAppBarScrollBehavior3 = null;
                                    function25 = function24;
                                    function33 = function32;
                                    topAppBarColors3 = topAppBarColors2;
                                } else {
                                    function25 = function24;
                                    topAppBarColors3 = topAppBarColors2;
                                    topAppBarScrollBehavior3 = topAppBarScrollBehavior2;
                                    function33 = function32;
                                }
                                modifier3 = companion;
                                i7 = -2139286460;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                function25 = function24;
                                topAppBarColors3 = topAppBarColors2;
                                topAppBarScrollBehavior3 = topAppBarScrollBehavior2;
                                i7 = -2139286460;
                                function33 = function32;
                                modifier3 = modifier2;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i7, i3, -1, "androidx.compose.material3.CenterAlignedTopAppBar (AppBar.kt:233)");
                            }
                            int i11 = ((i3 >> 3) & 14) | 3072 | ((i3 << 3) & 112);
                            int i12 = i3 << 6;
                            composer2 = startRestartGroup;
                            WindowInsets windowInsets4 = windowInsets2;
                            SingleRowTopAppBar(modifier3, function23, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TopAppBarSmallTokens.INSTANCE.getHeadlineFont()), true, function25, function33, windowInsets4, topAppBarColors3, topAppBarScrollBehavior3, composer2, i11 | (57344 & i12) | (458752 & i12) | (3670016 & i12) | (29360128 & i12) | (i12 & 234881024), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier4 = modifier3;
                            function26 = function25;
                            function34 = function33;
                            windowInsets3 = windowInsets4;
                            topAppBarColors4 = topAppBarColors3;
                            topAppBarScrollBehavior4 = topAppBarScrollBehavior3;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            composer2 = startRestartGroup;
                            modifier4 = modifier2;
                            function26 = function24;
                            function34 = function32;
                            windowInsets3 = windowInsets2;
                            topAppBarColors4 = topAppBarColors2;
                            topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$CenterAlignedTopAppBar$1
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
                                    AppBarKt.CenterAlignedTopAppBar(function2, modifier4, function26, function34, windowInsets3, topAppBarColors4, topAppBarScrollBehavior4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                    if ((599187 & i3) == 599186) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if (i6 != 0) {
                    }
                    modifier3 = companion;
                    i7 = -2139286460;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i112 = ((i3 >> 3) & 14) | 3072 | ((i3 << 3) & 112);
                    int i122 = i3 << 6;
                    composer2 = startRestartGroup;
                    WindowInsets windowInsets42 = windowInsets2;
                    SingleRowTopAppBar(modifier3, function23, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TopAppBarSmallTokens.INSTANCE.getHeadlineFont()), true, function25, function33, windowInsets42, topAppBarColors3, topAppBarScrollBehavior3, composer2, i112 | (57344 & i122) | (458752 & i122) | (3670016 & i122) | (29360128 & i122) | (i122 & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier4 = modifier3;
                    function26 = function25;
                    function34 = function33;
                    windowInsets3 = windowInsets42;
                    topAppBarColors4 = topAppBarColors3;
                    topAppBarScrollBehavior4 = topAppBarScrollBehavior3;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function32 = function3;
                if ((i & 24576) != 0) {
                }
                if ((196608 & i) != 0) {
                }
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                if ((599187 & i3) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i10 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if (i6 != 0) {
                }
                modifier3 = companion;
                i7 = -2139286460;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i1122 = ((i3 >> 3) & 14) | 3072 | ((i3 << 3) & 112);
                int i1222 = i3 << 6;
                composer2 = startRestartGroup;
                WindowInsets windowInsets422 = windowInsets2;
                SingleRowTopAppBar(modifier3, function23, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TopAppBarSmallTokens.INSTANCE.getHeadlineFont()), true, function25, function33, windowInsets422, topAppBarColors3, topAppBarScrollBehavior3, composer2, i1122 | (57344 & i1222) | (458752 & i1222) | (3670016 & i1222) | (29360128 & i1222) | (i1222 & 234881024), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier4 = modifier3;
                function26 = function25;
                function34 = function33;
                windowInsets3 = windowInsets422;
                topAppBarColors4 = topAppBarColors3;
                topAppBarScrollBehavior4 = topAppBarScrollBehavior3;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function24 = function22;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            function32 = function3;
            if ((i & 24576) != 0) {
            }
            if ((196608 & i) != 0) {
            }
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            topAppBarScrollBehavior2 = topAppBarScrollBehavior;
            if ((599187 & i3) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i10 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if (i6 != 0) {
            }
            modifier3 = companion;
            i7 = -2139286460;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i11222 = ((i3 >> 3) & 14) | 3072 | ((i3 << 3) & 112);
            int i12222 = i3 << 6;
            composer2 = startRestartGroup;
            WindowInsets windowInsets4222 = windowInsets2;
            SingleRowTopAppBar(modifier3, function23, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TopAppBarSmallTokens.INSTANCE.getHeadlineFont()), true, function25, function33, windowInsets4222, topAppBarColors3, topAppBarScrollBehavior3, composer2, i11222 | (57344 & i12222) | (458752 & i12222) | (3670016 & i12222) | (29360128 & i12222) | (i12222 & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier4 = modifier3;
            function26 = function25;
            function34 = function33;
            windowInsets3 = windowInsets4222;
            topAppBarColors4 = topAppBarColors3;
            topAppBarScrollBehavior4 = topAppBarScrollBehavior3;
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
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        topAppBarScrollBehavior2 = topAppBarScrollBehavior;
        if ((599187 & i3) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i10 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if (i6 != 0) {
        }
        modifier3 = companion;
        i7 = -2139286460;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i112222 = ((i3 >> 3) & 14) | 3072 | ((i3 << 3) & 112);
        int i122222 = i3 << 6;
        composer2 = startRestartGroup;
        WindowInsets windowInsets42222 = windowInsets2;
        SingleRowTopAppBar(modifier3, function23, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TopAppBarSmallTokens.INSTANCE.getHeadlineFont()), true, function25, function33, windowInsets42222, topAppBarColors3, topAppBarScrollBehavior3, composer2, i112222 | (57344 & i122222) | (458752 & i122222) | (3670016 & i122222) | (29360128 & i122222) | (i122222 & 234881024), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        function26 = function25;
        function34 = function33;
        windowInsets3 = windowInsets42222;
        topAppBarColors4 = topAppBarColors3;
        topAppBarScrollBehavior4 = topAppBarScrollBehavior3;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void MediumTopAppBar(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, Composer composer, final int i, final int i2) {
        Function2<? super Composer, ? super Integer, Unit> function23;
        int i3;
        Modifier modifier2;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i5;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32;
        WindowInsets windowInsets2;
        TopAppBarColors topAppBarColors2;
        int i6;
        TopAppBarScrollBehavior topAppBarScrollBehavior2;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33;
        WindowInsets windowInsets3;
        TopAppBarColors topAppBarColors3;
        TopAppBarScrollBehavior topAppBarScrollBehavior3;
        Modifier modifier3;
        int i7;
        Composer composer2;
        final Modifier modifier4;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function34;
        final WindowInsets windowInsets4;
        final TopAppBarColors topAppBarColors4;
        final TopAppBarScrollBehavior topAppBarScrollBehavior4;
        ScopeUpdateScope endRestartGroup;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(1805417862);
        ComposerKt.sourceInformation(startRestartGroup, "C(MediumTopAppBar)P(5,2,3!1,6)285@14543L12,286@14605L23,292@14799L10,293@14901L10,289@14690L646:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function23 = function2;
        } else {
            function23 = function2;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changedInstance(function23) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i10 = i2 & 2;
        if (i10 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                function24 = function22;
                i3 |= startRestartGroup.changedInstance(function24) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    function32 = function3;
                    i3 |= startRestartGroup.changedInstance(function32) ? 2048 : 1024;
                    if ((i & 24576) != 0) {
                        if ((i2 & 16) == 0) {
                            windowInsets2 = windowInsets;
                            if (startRestartGroup.changed(windowInsets2)) {
                                i9 = 16384;
                                i3 |= i9;
                            }
                        } else {
                            windowInsets2 = windowInsets;
                        }
                        i9 = 8192;
                        i3 |= i9;
                    } else {
                        windowInsets2 = windowInsets;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            topAppBarColors2 = topAppBarColors;
                            if (startRestartGroup.changed(topAppBarColors2)) {
                                i8 = 131072;
                                i3 |= i8;
                            }
                        } else {
                            topAppBarColors2 = topAppBarColors;
                        }
                        i8 = 65536;
                        i3 |= i8;
                    } else {
                        topAppBarColors2 = topAppBarColors;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((1572864 & i) == 0) {
                        topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                        i3 |= startRestartGroup.changed(topAppBarScrollBehavior2) ? 1048576 : 524288;
                        if ((599187 & i3) == 599186 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i10 != 0 ? Modifier.INSTANCE : modifier2;
                                if (i4 != 0) {
                                    function24 = ComposableSingletons$AppBarKt.INSTANCE.m2068getLambda7$material3_release();
                                }
                                if (i5 != 0) {
                                    function32 = ComposableSingletons$AppBarKt.INSTANCE.m2069getLambda8$material3_release();
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                    topAppBarColors2 = TopAppBarDefaults.INSTANCE.mediumTopAppBarColors(startRestartGroup, 6);
                                }
                                if (i6 != 0) {
                                    topAppBarScrollBehavior3 = null;
                                    function33 = function32;
                                    windowInsets3 = windowInsets2;
                                    topAppBarColors3 = topAppBarColors2;
                                } else {
                                    function33 = function32;
                                    windowInsets3 = windowInsets2;
                                    topAppBarColors3 = topAppBarColors2;
                                    topAppBarScrollBehavior3 = topAppBarScrollBehavior2;
                                }
                                modifier3 = companion;
                                i7 = 1805417862;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                function33 = function32;
                                windowInsets3 = windowInsets2;
                                topAppBarColors3 = topAppBarColors2;
                                topAppBarScrollBehavior3 = topAppBarScrollBehavior2;
                                i7 = 1805417862;
                                modifier3 = modifier2;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i7, i3, -1, "androidx.compose.material3.MediumTopAppBar (AppBar.kt:288)");
                            }
                            int i11 = i3 << 12;
                            composer2 = startRestartGroup;
                            Function2<? super Composer, ? super Integer, Unit> function26 = function24;
                            m1889TwoRowsTopAppBartjU4iQQ(modifier3, function23, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TopAppBarMediumTokens.INSTANCE.getHeadlineFont()), MediumTitleBottomPadding, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TopAppBarSmallTokens.INSTANCE.getHeadlineFont()), function26, function33, windowInsets3, topAppBarColors3, TopAppBarMediumTokens.INSTANCE.m3508getContainerHeightD9Ej5fM(), TopAppBarSmallTokens.INSTANCE.m3518getContainerHeightD9Ej5fM(), topAppBarScrollBehavior3, composer2, ((i3 >> 3) & 14) | 3072 | ((i3 << 3) & 112) | (57344 & i11) | (3670016 & i11) | (29360128 & i11) | (234881024 & i11) | (i11 & 1879048192), ((i3 >> 12) & 896) | 54, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier4 = modifier3;
                            function25 = function26;
                            function34 = function33;
                            windowInsets4 = windowInsets3;
                            topAppBarColors4 = topAppBarColors3;
                            topAppBarScrollBehavior4 = topAppBarScrollBehavior3;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            composer2 = startRestartGroup;
                            modifier4 = modifier2;
                            function25 = function24;
                            function34 = function32;
                            windowInsets4 = windowInsets2;
                            topAppBarColors4 = topAppBarColors2;
                            topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$MediumTopAppBar$1
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
                                    AppBarKt.MediumTopAppBar(function2, modifier4, function25, function34, windowInsets4, topAppBarColors4, topAppBarScrollBehavior4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                    if ((599187 & i3) == 599186) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if (i6 != 0) {
                    }
                    modifier3 = companion;
                    i7 = 1805417862;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i112 = i3 << 12;
                    composer2 = startRestartGroup;
                    Function2<? super Composer, ? super Integer, Unit> function262 = function24;
                    m1889TwoRowsTopAppBartjU4iQQ(modifier3, function23, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TopAppBarMediumTokens.INSTANCE.getHeadlineFont()), MediumTitleBottomPadding, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TopAppBarSmallTokens.INSTANCE.getHeadlineFont()), function262, function33, windowInsets3, topAppBarColors3, TopAppBarMediumTokens.INSTANCE.m3508getContainerHeightD9Ej5fM(), TopAppBarSmallTokens.INSTANCE.m3518getContainerHeightD9Ej5fM(), topAppBarScrollBehavior3, composer2, ((i3 >> 3) & 14) | 3072 | ((i3 << 3) & 112) | (57344 & i112) | (3670016 & i112) | (29360128 & i112) | (234881024 & i112) | (i112 & 1879048192), ((i3 >> 12) & 896) | 54, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier4 = modifier3;
                    function25 = function262;
                    function34 = function33;
                    windowInsets4 = windowInsets3;
                    topAppBarColors4 = topAppBarColors3;
                    topAppBarScrollBehavior4 = topAppBarScrollBehavior3;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function32 = function3;
                if ((i & 24576) != 0) {
                }
                if ((196608 & i) != 0) {
                }
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                if ((599187 & i3) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i10 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if (i6 != 0) {
                }
                modifier3 = companion;
                i7 = 1805417862;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i1122 = i3 << 12;
                composer2 = startRestartGroup;
                Function2<? super Composer, ? super Integer, Unit> function2622 = function24;
                m1889TwoRowsTopAppBartjU4iQQ(modifier3, function23, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TopAppBarMediumTokens.INSTANCE.getHeadlineFont()), MediumTitleBottomPadding, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TopAppBarSmallTokens.INSTANCE.getHeadlineFont()), function2622, function33, windowInsets3, topAppBarColors3, TopAppBarMediumTokens.INSTANCE.m3508getContainerHeightD9Ej5fM(), TopAppBarSmallTokens.INSTANCE.m3518getContainerHeightD9Ej5fM(), topAppBarScrollBehavior3, composer2, ((i3 >> 3) & 14) | 3072 | ((i3 << 3) & 112) | (57344 & i1122) | (3670016 & i1122) | (29360128 & i1122) | (234881024 & i1122) | (i1122 & 1879048192), ((i3 >> 12) & 896) | 54, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier4 = modifier3;
                function25 = function2622;
                function34 = function33;
                windowInsets4 = windowInsets3;
                topAppBarColors4 = topAppBarColors3;
                topAppBarScrollBehavior4 = topAppBarScrollBehavior3;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function24 = function22;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            function32 = function3;
            if ((i & 24576) != 0) {
            }
            if ((196608 & i) != 0) {
            }
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            topAppBarScrollBehavior2 = topAppBarScrollBehavior;
            if ((599187 & i3) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i10 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if (i6 != 0) {
            }
            modifier3 = companion;
            i7 = 1805417862;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i11222 = i3 << 12;
            composer2 = startRestartGroup;
            Function2<? super Composer, ? super Integer, Unit> function26222 = function24;
            m1889TwoRowsTopAppBartjU4iQQ(modifier3, function23, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TopAppBarMediumTokens.INSTANCE.getHeadlineFont()), MediumTitleBottomPadding, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TopAppBarSmallTokens.INSTANCE.getHeadlineFont()), function26222, function33, windowInsets3, topAppBarColors3, TopAppBarMediumTokens.INSTANCE.m3508getContainerHeightD9Ej5fM(), TopAppBarSmallTokens.INSTANCE.m3518getContainerHeightD9Ej5fM(), topAppBarScrollBehavior3, composer2, ((i3 >> 3) & 14) | 3072 | ((i3 << 3) & 112) | (57344 & i11222) | (3670016 & i11222) | (29360128 & i11222) | (234881024 & i11222) | (i11222 & 1879048192), ((i3 >> 12) & 896) | 54, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier4 = modifier3;
            function25 = function26222;
            function34 = function33;
            windowInsets4 = windowInsets3;
            topAppBarColors4 = topAppBarColors3;
            topAppBarScrollBehavior4 = topAppBarScrollBehavior3;
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
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        topAppBarScrollBehavior2 = topAppBarScrollBehavior;
        if ((599187 & i3) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i10 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if (i6 != 0) {
        }
        modifier3 = companion;
        i7 = 1805417862;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i112222 = i3 << 12;
        composer2 = startRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function262222 = function24;
        m1889TwoRowsTopAppBartjU4iQQ(modifier3, function23, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TopAppBarMediumTokens.INSTANCE.getHeadlineFont()), MediumTitleBottomPadding, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TopAppBarSmallTokens.INSTANCE.getHeadlineFont()), function262222, function33, windowInsets3, topAppBarColors3, TopAppBarMediumTokens.INSTANCE.m3508getContainerHeightD9Ej5fM(), TopAppBarSmallTokens.INSTANCE.m3518getContainerHeightD9Ej5fM(), topAppBarScrollBehavior3, composer2, ((i3 >> 3) & 14) | 3072 | ((i3 << 3) & 112) | (57344 & i112222) | (3670016 & i112222) | (29360128 & i112222) | (234881024 & i112222) | (i112222 & 1879048192), ((i3 >> 12) & 896) | 54, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        function25 = function262222;
        function34 = function33;
        windowInsets4 = windowInsets3;
        topAppBarColors4 = topAppBarColors3;
        topAppBarScrollBehavior4 = topAppBarScrollBehavior3;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LargeTopAppBar(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, Composer composer, final int i, final int i2) {
        Function2<? super Composer, ? super Integer, Unit> function23;
        int i3;
        Modifier modifier2;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i5;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32;
        WindowInsets windowInsets2;
        TopAppBarColors topAppBarColors2;
        int i6;
        TopAppBarScrollBehavior topAppBarScrollBehavior2;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33;
        WindowInsets windowInsets3;
        TopAppBarColors topAppBarColors3;
        TopAppBarScrollBehavior topAppBarScrollBehavior3;
        Modifier modifier3;
        int i7;
        Composer composer2;
        final Modifier modifier4;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function34;
        final WindowInsets windowInsets4;
        final TopAppBarColors topAppBarColors4;
        final TopAppBarScrollBehavior topAppBarScrollBehavior4;
        ScopeUpdateScope endRestartGroup;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(-474540752);
        ComposerKt.sourceInformation(startRestartGroup, "C(LargeTopAppBar)P(5,2,3!1,6)343@17646L12,344@17708L22,349@17872L10,350@17973L10,347@17792L643:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function23 = function2;
        } else {
            function23 = function2;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changedInstance(function23) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i10 = i2 & 2;
        if (i10 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                function24 = function22;
                i3 |= startRestartGroup.changedInstance(function24) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    function32 = function3;
                    i3 |= startRestartGroup.changedInstance(function32) ? 2048 : 1024;
                    if ((i & 24576) != 0) {
                        if ((i2 & 16) == 0) {
                            windowInsets2 = windowInsets;
                            if (startRestartGroup.changed(windowInsets2)) {
                                i9 = 16384;
                                i3 |= i9;
                            }
                        } else {
                            windowInsets2 = windowInsets;
                        }
                        i9 = 8192;
                        i3 |= i9;
                    } else {
                        windowInsets2 = windowInsets;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            topAppBarColors2 = topAppBarColors;
                            if (startRestartGroup.changed(topAppBarColors2)) {
                                i8 = 131072;
                                i3 |= i8;
                            }
                        } else {
                            topAppBarColors2 = topAppBarColors;
                        }
                        i8 = 65536;
                        i3 |= i8;
                    } else {
                        topAppBarColors2 = topAppBarColors;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((1572864 & i) == 0) {
                        topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                        i3 |= startRestartGroup.changed(topAppBarScrollBehavior2) ? 1048576 : 524288;
                        if ((599187 & i3) == 599186 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i10 != 0 ? Modifier.INSTANCE : modifier2;
                                if (i4 != 0) {
                                    function24 = ComposableSingletons$AppBarKt.INSTANCE.m2070getLambda9$material3_release();
                                }
                                if (i5 != 0) {
                                    function32 = ComposableSingletons$AppBarKt.INSTANCE.m2060getLambda10$material3_release();
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                    topAppBarColors2 = TopAppBarDefaults.INSTANCE.largeTopAppBarColors(startRestartGroup, 6);
                                }
                                if (i6 != 0) {
                                    topAppBarScrollBehavior3 = null;
                                    function33 = function32;
                                    windowInsets3 = windowInsets2;
                                    topAppBarColors3 = topAppBarColors2;
                                } else {
                                    function33 = function32;
                                    windowInsets3 = windowInsets2;
                                    topAppBarColors3 = topAppBarColors2;
                                    topAppBarScrollBehavior3 = topAppBarScrollBehavior2;
                                }
                                modifier3 = companion;
                                i7 = -474540752;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                function33 = function32;
                                windowInsets3 = windowInsets2;
                                topAppBarColors3 = topAppBarColors2;
                                topAppBarScrollBehavior3 = topAppBarScrollBehavior2;
                                i7 = -474540752;
                                modifier3 = modifier2;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i7, i3, -1, "androidx.compose.material3.LargeTopAppBar (AppBar.kt:346)");
                            }
                            int i11 = i3 << 12;
                            composer2 = startRestartGroup;
                            Function2<? super Composer, ? super Integer, Unit> function26 = function24;
                            m1889TwoRowsTopAppBartjU4iQQ(modifier3, function23, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TopAppBarLargeTokens.INSTANCE.getHeadlineFont()), LargeTitleBottomPadding, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TopAppBarSmallTokens.INSTANCE.getHeadlineFont()), function26, function33, windowInsets3, topAppBarColors3, TopAppBarLargeTokens.INSTANCE.m3504getContainerHeightD9Ej5fM(), TopAppBarSmallTokens.INSTANCE.m3518getContainerHeightD9Ej5fM(), topAppBarScrollBehavior3, composer2, ((i3 >> 3) & 14) | 3072 | ((i3 << 3) & 112) | (57344 & i11) | (3670016 & i11) | (29360128 & i11) | (234881024 & i11) | (i11 & 1879048192), ((i3 >> 12) & 896) | 54, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier4 = modifier3;
                            function25 = function26;
                            function34 = function33;
                            windowInsets4 = windowInsets3;
                            topAppBarColors4 = topAppBarColors3;
                            topAppBarScrollBehavior4 = topAppBarScrollBehavior3;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            composer2 = startRestartGroup;
                            modifier4 = modifier2;
                            function25 = function24;
                            function34 = function32;
                            windowInsets4 = windowInsets2;
                            topAppBarColors4 = topAppBarColors2;
                            topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$LargeTopAppBar$1
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
                                    AppBarKt.LargeTopAppBar(function2, modifier4, function25, function34, windowInsets4, topAppBarColors4, topAppBarScrollBehavior4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                    if ((599187 & i3) == 599186) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if (i6 != 0) {
                    }
                    modifier3 = companion;
                    i7 = -474540752;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i112 = i3 << 12;
                    composer2 = startRestartGroup;
                    Function2<? super Composer, ? super Integer, Unit> function262 = function24;
                    m1889TwoRowsTopAppBartjU4iQQ(modifier3, function23, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TopAppBarLargeTokens.INSTANCE.getHeadlineFont()), LargeTitleBottomPadding, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TopAppBarSmallTokens.INSTANCE.getHeadlineFont()), function262, function33, windowInsets3, topAppBarColors3, TopAppBarLargeTokens.INSTANCE.m3504getContainerHeightD9Ej5fM(), TopAppBarSmallTokens.INSTANCE.m3518getContainerHeightD9Ej5fM(), topAppBarScrollBehavior3, composer2, ((i3 >> 3) & 14) | 3072 | ((i3 << 3) & 112) | (57344 & i112) | (3670016 & i112) | (29360128 & i112) | (234881024 & i112) | (i112 & 1879048192), ((i3 >> 12) & 896) | 54, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier4 = modifier3;
                    function25 = function262;
                    function34 = function33;
                    windowInsets4 = windowInsets3;
                    topAppBarColors4 = topAppBarColors3;
                    topAppBarScrollBehavior4 = topAppBarScrollBehavior3;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function32 = function3;
                if ((i & 24576) != 0) {
                }
                if ((196608 & i) != 0) {
                }
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                if ((599187 & i3) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i10 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if (i6 != 0) {
                }
                modifier3 = companion;
                i7 = -474540752;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i1122 = i3 << 12;
                composer2 = startRestartGroup;
                Function2<? super Composer, ? super Integer, Unit> function2622 = function24;
                m1889TwoRowsTopAppBartjU4iQQ(modifier3, function23, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TopAppBarLargeTokens.INSTANCE.getHeadlineFont()), LargeTitleBottomPadding, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TopAppBarSmallTokens.INSTANCE.getHeadlineFont()), function2622, function33, windowInsets3, topAppBarColors3, TopAppBarLargeTokens.INSTANCE.m3504getContainerHeightD9Ej5fM(), TopAppBarSmallTokens.INSTANCE.m3518getContainerHeightD9Ej5fM(), topAppBarScrollBehavior3, composer2, ((i3 >> 3) & 14) | 3072 | ((i3 << 3) & 112) | (57344 & i1122) | (3670016 & i1122) | (29360128 & i1122) | (234881024 & i1122) | (i1122 & 1879048192), ((i3 >> 12) & 896) | 54, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier4 = modifier3;
                function25 = function2622;
                function34 = function33;
                windowInsets4 = windowInsets3;
                topAppBarColors4 = topAppBarColors3;
                topAppBarScrollBehavior4 = topAppBarScrollBehavior3;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function24 = function22;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            function32 = function3;
            if ((i & 24576) != 0) {
            }
            if ((196608 & i) != 0) {
            }
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            topAppBarScrollBehavior2 = topAppBarScrollBehavior;
            if ((599187 & i3) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i10 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if (i6 != 0) {
            }
            modifier3 = companion;
            i7 = -474540752;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i11222 = i3 << 12;
            composer2 = startRestartGroup;
            Function2<? super Composer, ? super Integer, Unit> function26222 = function24;
            m1889TwoRowsTopAppBartjU4iQQ(modifier3, function23, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TopAppBarLargeTokens.INSTANCE.getHeadlineFont()), LargeTitleBottomPadding, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TopAppBarSmallTokens.INSTANCE.getHeadlineFont()), function26222, function33, windowInsets3, topAppBarColors3, TopAppBarLargeTokens.INSTANCE.m3504getContainerHeightD9Ej5fM(), TopAppBarSmallTokens.INSTANCE.m3518getContainerHeightD9Ej5fM(), topAppBarScrollBehavior3, composer2, ((i3 >> 3) & 14) | 3072 | ((i3 << 3) & 112) | (57344 & i11222) | (3670016 & i11222) | (29360128 & i11222) | (234881024 & i11222) | (i11222 & 1879048192), ((i3 >> 12) & 896) | 54, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier4 = modifier3;
            function25 = function26222;
            function34 = function33;
            windowInsets4 = windowInsets3;
            topAppBarColors4 = topAppBarColors3;
            topAppBarScrollBehavior4 = topAppBarScrollBehavior3;
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
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        topAppBarScrollBehavior2 = topAppBarScrollBehavior;
        if ((599187 & i3) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i10 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if (i6 != 0) {
        }
        modifier3 = companion;
        i7 = -474540752;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i112222 = i3 << 12;
        composer2 = startRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function262222 = function24;
        m1889TwoRowsTopAppBartjU4iQQ(modifier3, function23, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TopAppBarLargeTokens.INSTANCE.getHeadlineFont()), LargeTitleBottomPadding, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TopAppBarSmallTokens.INSTANCE.getHeadlineFont()), function262222, function33, windowInsets3, topAppBarColors3, TopAppBarLargeTokens.INSTANCE.m3504getContainerHeightD9Ej5fM(), TopAppBarSmallTokens.INSTANCE.m3518getContainerHeightD9Ej5fM(), topAppBarScrollBehavior3, composer2, ((i3 >> 3) & 14) | 3072 | ((i3 << 3) & 112) | (57344 & i112222) | (3670016 & i112222) | (29360128 & i112222) | (234881024 & i112222) | (i112222 & 1879048192), ((i3 >> 12) & 896) | 54, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        function25 = function262222;
        function34 = function33;
        windowInsets4 = windowInsets3;
        topAppBarColors4 = topAppBarColors3;
        topAppBarScrollBehavior4 = topAppBarScrollBehavior3;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00c3  */
    /* renamed from: BottomAppBar-Snr_uVM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1885BottomAppBarSnr_uVM(final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, long j, long j2, float f, PaddingValues paddingValues, WindowInsets windowInsets, Composer composer, final int i, final int i2) {
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32;
        int i3;
        Modifier modifier2;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function22;
        long j3;
        long j4;
        int i5;
        float f2;
        int i6;
        WindowInsets windowInsets2;
        PaddingValues paddingValues2;
        Modifier modifier3;
        Composer composer2;
        final Modifier modifier4;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        final long j5;
        final long j6;
        final float f3;
        final PaddingValues paddingValues3;
        final WindowInsets windowInsets3;
        int i7;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(2141738945);
        ComposerKt.sourceInformation(startRestartGroup, "C(BottomAppBar)P(!1,5,4,1:c#ui.graphics.Color,2:c#ui.graphics.Color,6:c#ui.unit.Dp)400@20438L14,401@20480L31,404@20706L12,405@20724L315:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function32 = function3;
        } else {
            function32 = function3;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changedInstance(function32) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i10 = i2 & 2;
        if (i10 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                function22 = function2;
                i3 |= startRestartGroup.changedInstance(function22) ? 256 : 128;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        j3 = j;
                        if (startRestartGroup.changed(j3)) {
                            i9 = 2048;
                            i3 |= i9;
                        }
                    } else {
                        j3 = j;
                    }
                    i9 = 1024;
                    i3 |= i9;
                } else {
                    j3 = j;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        j4 = j2;
                        if (startRestartGroup.changed(j4)) {
                            i8 = 16384;
                            i3 |= i8;
                        }
                    } else {
                        j4 = j2;
                    }
                    i8 = 8192;
                    i3 |= i8;
                } else {
                    j4 = j2;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i) == 0) {
                    f2 = f;
                    i3 |= startRestartGroup.changed(f2) ? 131072 : 65536;
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        i3 |= startRestartGroup.changed(paddingValues) ? 1048576 : 524288;
                    }
                    if ((i & 12582912) == 0) {
                        if ((i2 & 128) == 0 && startRestartGroup.changed(windowInsets)) {
                            i7 = 8388608;
                            i3 |= i7;
                        }
                        i7 = 4194304;
                        i3 |= i7;
                    }
                    if ((i3 & 4793491) == 4793490 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            if (i10 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function22 = null;
                            }
                            if ((i2 & 8) != 0) {
                                j3 = BottomAppBarDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                j4 = ColorSchemeKt.m2049contentColorForek8zF_U(j3, startRestartGroup, (i3 >> 9) & 14);
                                i3 &= -57345;
                            }
                            if (i5 != 0) {
                                f2 = BottomAppBarDefaults.INSTANCE.m1902getContainerElevationD9Ej5fM();
                            }
                            PaddingValues contentPadding = i6 == 0 ? BottomAppBarDefaults.INSTANCE.getContentPadding() : paddingValues;
                            if ((i2 & 128) == 0) {
                                i3 &= -29360129;
                                paddingValues2 = contentPadding;
                                modifier3 = modifier2;
                                windowInsets2 = BottomAppBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                                long j7 = j3;
                                long j8 = j4;
                                float f4 = f2;
                                Function2<? super Composer, ? super Integer, Unit> function24 = function22;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2141738945, i3, -1, "androidx.compose.material3.BottomAppBar (AppBar.kt:405)");
                                }
                                composer2 = startRestartGroup;
                                m1887BottomAppBarqhFBPw4(function32, modifier3, function24, j7, j8, f4, paddingValues2, windowInsets2, null, composer2, (i3 & 14) | 100663296 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | (i3 & 29360128), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier4 = modifier3;
                                function23 = function24;
                                j5 = j7;
                                j6 = j8;
                                f3 = f4;
                                paddingValues3 = paddingValues2;
                                windowInsets3 = windowInsets2;
                            } else {
                                windowInsets2 = windowInsets;
                                paddingValues2 = contentPadding;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            if ((i2 & 128) != 0) {
                                i3 &= -29360129;
                            }
                            paddingValues2 = paddingValues;
                            windowInsets2 = windowInsets;
                        }
                        modifier3 = modifier2;
                        long j72 = j3;
                        long j82 = j4;
                        float f42 = f2;
                        Function2<? super Composer, ? super Integer, Unit> function242 = function22;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composer2 = startRestartGroup;
                        m1887BottomAppBarqhFBPw4(function32, modifier3, function242, j72, j82, f42, paddingValues2, windowInsets2, null, composer2, (i3 & 14) | 100663296 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | (i3 & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier4 = modifier3;
                        function23 = function242;
                        j5 = j72;
                        j6 = j82;
                        f3 = f42;
                        paddingValues3 = paddingValues2;
                        windowInsets3 = windowInsets2;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        composer2 = startRestartGroup;
                        modifier4 = modifier2;
                        function23 = function22;
                        j5 = j3;
                        j6 = j4;
                        f3 = f2;
                        paddingValues3 = paddingValues;
                        windowInsets3 = windowInsets;
                    }
                    ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$1
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
                                AppBarKt.m1885BottomAppBarSnr_uVM(function3, modifier4, function23, j5, j6, f3, paddingValues3, windowInsets3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                f2 = f;
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                if ((i & 12582912) == 0) {
                }
                if ((i3 & 4793491) == 4793490) {
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
                if (i5 != 0) {
                }
                if (i6 == 0) {
                }
                if ((i2 & 128) == 0) {
                }
            }
            function22 = function2;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            f2 = f;
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            if ((i3 & 4793491) == 4793490) {
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
            if (i5 != 0) {
            }
            if (i6 == 0) {
            }
            if ((i2 & 128) == 0) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        function22 = function2;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        f2 = f;
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        if ((i3 & 4793491) == 4793490) {
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
        if (i5 != 0) {
        }
        if (i6 == 0) {
        }
        if ((i2 & 128) == 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01c2  */
    /* renamed from: BottomAppBar-qhFBPw4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1887BottomAppBarqhFBPw4(final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, long j, long j2, float f, PaddingValues paddingValues, WindowInsets windowInsets, BottomAppBarScrollBehavior bottomAppBarScrollBehavior, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        final Function2<? super Composer, ? super Integer, Unit> function22;
        long j3;
        long j4;
        int i5;
        float f2;
        int i6;
        int i7;
        int i8;
        WindowInsets windowInsets2;
        BottomAppBarScrollBehavior bottomAppBarScrollBehavior2;
        float f3;
        PaddingValues paddingValues2;
        WindowInsets windowInsets3;
        int i9;
        Modifier modifier3;
        long j5;
        long j6;
        int i10;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        final Modifier modifier4;
        final long j7;
        final long j8;
        final float f4;
        final PaddingValues paddingValues3;
        final WindowInsets windowInsets4;
        final BottomAppBarScrollBehavior bottomAppBarScrollBehavior3;
        ScopeUpdateScope endRestartGroup;
        int i11;
        int i12;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(-1044837119);
        ComposerKt.sourceInformation(startRestartGroup, "C(BottomAppBar)P(!1,5,4,1:c#ui.graphics.Color,2:c#ui.graphics.Color,7:c#ui.unit.Dp!1,8)462@23624L14,463@23666L31,466@23892L12,468@23966L804:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function3) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i14 = i2 & 2;
        if (i14 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                function22 = function2;
                i3 |= startRestartGroup.changedInstance(function22) ? 256 : 128;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        j3 = j;
                        if (startRestartGroup.changed(j3)) {
                            i13 = 2048;
                            i3 |= i13;
                        }
                    } else {
                        j3 = j;
                    }
                    i13 = 1024;
                    i3 |= i13;
                } else {
                    j3 = j;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        j4 = j2;
                        if (startRestartGroup.changed(j4)) {
                            i12 = 16384;
                            i3 |= i12;
                        }
                    } else {
                        j4 = j2;
                    }
                    i12 = 8192;
                    i3 |= i12;
                } else {
                    j4 = j2;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i) == 0) {
                    f2 = f;
                    i3 |= startRestartGroup.changed(f2) ? 131072 : 65536;
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        i3 |= startRestartGroup.changed(paddingValues) ? 1048576 : 524288;
                    }
                    if ((i & 12582912) == 0) {
                        if ((i2 & 128) == 0 && startRestartGroup.changed(windowInsets)) {
                            i11 = 8388608;
                            i3 |= i11;
                        }
                        i11 = 4194304;
                        i3 |= i11;
                    }
                    i7 = i2 & 256;
                    if (i7 == 0) {
                        i3 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i8 = i7;
                        i3 |= startRestartGroup.changed(bottomAppBarScrollBehavior) ? 67108864 : 33554432;
                        if ((i3 & 38347923) == 38347922 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                if (i14 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function22 = null;
                                }
                                if ((i2 & 8) != 0) {
                                    j3 = BottomAppBarDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                                    i3 &= -7169;
                                }
                                if ((i2 & 16) != 0) {
                                    j4 = ColorSchemeKt.m2049contentColorForek8zF_U(j3, startRestartGroup, (i3 >> 9) & 14);
                                    i3 &= -57345;
                                }
                                float m1902getContainerElevationD9Ej5fM = i5 != 0 ? BottomAppBarDefaults.INSTANCE.m1902getContainerElevationD9Ej5fM() : f2;
                                PaddingValues contentPadding = i6 != 0 ? BottomAppBarDefaults.INSTANCE.getContentPadding() : paddingValues;
                                if ((i2 & 128) != 0) {
                                    windowInsets2 = BottomAppBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                                    i3 &= -29360129;
                                } else {
                                    windowInsets2 = windowInsets;
                                }
                                bottomAppBarScrollBehavior2 = i8 != 0 ? null : bottomAppBarScrollBehavior;
                                f3 = m1902getContainerElevationD9Ej5fM;
                                paddingValues2 = contentPadding;
                                windowInsets3 = windowInsets2;
                                i9 = 12582912;
                                modifier3 = modifier2;
                                j5 = j3;
                                j6 = j4;
                                i10 = -1044837119;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 128) != 0) {
                                    i3 &= -29360129;
                                }
                                paddingValues2 = paddingValues;
                                windowInsets3 = windowInsets;
                                bottomAppBarScrollBehavior2 = bottomAppBarScrollBehavior;
                                modifier3 = modifier2;
                                f3 = f2;
                                i9 = 12582912;
                                i10 = -1044837119;
                                j5 = j3;
                                j6 = j4;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i10, i3, -1, "androidx.compose.material3.BottomAppBar (AppBar.kt:468)");
                            }
                            int i15 = i9 | ((i3 >> 3) & 14);
                            int i16 = i3 >> 6;
                            composer2 = startRestartGroup;
                            m1886BottomAppBare3WI5M(modifier3, j5, j6, f3, paddingValues2, windowInsets3, bottomAppBarScrollBehavior2, ComposableLambdaKt.composableLambda(startRestartGroup, 1566394874, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$2
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
                                    float f5;
                                    float f6;
                                    ComposerKt.sourceInformation(composer3, "C477@24226L184,484@24459L303:AppBar.kt#uh7d8r");
                                    if ((i17 & 6) == 0) {
                                        i18 = i17 | (composer3.changed(rowScope) ? 4 : 2);
                                    } else {
                                        i18 = i17;
                                    }
                                    if ((i18 & 19) != 18 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1566394874, i18, -1, "androidx.compose.material3.BottomAppBar.<anonymous> (AppBar.kt:477)");
                                        }
                                        Modifier weight$default = RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null);
                                        Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                        Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                                        composer3.startReplaceableGroup(693286680);
                                        ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer3, 54);
                                        composer3.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(weight$default);
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
                                        function32.invoke(RowScopeInstance.INSTANCE, composer3, 6);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        composer3.endReplaceableGroup();
                                        composer3.endNode();
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        if (function22 != null) {
                                            Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
                                            f5 = AppBarKt.FABVerticalPadding;
                                            f6 = AppBarKt.FABHorizontalPadding;
                                            Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(fillMaxHeight$default, 0.0f, f5, f6, 0.0f, 9, null);
                                            Alignment topStart = Alignment.INSTANCE.getTopStart();
                                            Function2<Composer, Integer, Unit> function24 = function22;
                                            composer3.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(topStart, false, composer3, 6);
                                            composer3.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                            CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
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
                                            ComposerKt.sourceInformationMarkerStart(composer3, 1859776956, "C493@24730L22:AppBar.kt#uh7d8r");
                                            function24.invoke(composer3, 0);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            composer3.endReplaceableGroup();
                                            composer3.endNode();
                                            composer3.endReplaceableGroup();
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
                            }), composer2, i15 | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (i16 & 3670016), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function23 = function22;
                            modifier4 = modifier3;
                            j7 = j5;
                            j8 = j6;
                            f4 = f3;
                            paddingValues3 = paddingValues2;
                            windowInsets4 = windowInsets3;
                            bottomAppBarScrollBehavior3 = bottomAppBarScrollBehavior2;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            composer2 = startRestartGroup;
                            modifier4 = modifier2;
                            function23 = function22;
                            j7 = j3;
                            j8 = j4;
                            f4 = f2;
                            paddingValues3 = paddingValues;
                            windowInsets4 = windowInsets;
                            bottomAppBarScrollBehavior3 = bottomAppBarScrollBehavior;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$3
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
                                    AppBarKt.m1887BottomAppBarqhFBPw4(function3, modifier4, function23, j7, j8, f4, paddingValues3, windowInsets4, bottomAppBarScrollBehavior3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i8 = i7;
                    if ((i3 & 38347923) == 38347922) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i14 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if ((i2 & 8) != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if ((i2 & 128) != 0) {
                    }
                    if (i8 != 0) {
                    }
                    f3 = m1902getContainerElevationD9Ej5fM;
                    paddingValues2 = contentPadding;
                    windowInsets3 = windowInsets2;
                    i9 = 12582912;
                    modifier3 = modifier2;
                    j5 = j3;
                    j6 = j4;
                    i10 = -1044837119;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i152 = i9 | ((i3 >> 3) & 14);
                    int i162 = i3 >> 6;
                    composer2 = startRestartGroup;
                    m1886BottomAppBare3WI5M(modifier3, j5, j6, f3, paddingValues2, windowInsets3, bottomAppBarScrollBehavior2, ComposableLambdaKt.composableLambda(startRestartGroup, 1566394874, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$2
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
                            float f5;
                            float f6;
                            ComposerKt.sourceInformation(composer3, "C477@24226L184,484@24459L303:AppBar.kt#uh7d8r");
                            if ((i17 & 6) == 0) {
                                i18 = i17 | (composer3.changed(rowScope) ? 4 : 2);
                            } else {
                                i18 = i17;
                            }
                            if ((i18 & 19) != 18 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1566394874, i18, -1, "androidx.compose.material3.BottomAppBar.<anonymous> (AppBar.kt:477)");
                                }
                                Modifier weight$default = RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null);
                                Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                                composer3.startReplaceableGroup(693286680);
                                ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer3, 54);
                                composer3.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(weight$default);
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
                                function32.invoke(RowScopeInstance.INSTANCE, composer3, 6);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endReplaceableGroup();
                                composer3.endNode();
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                if (function22 != null) {
                                    Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
                                    f5 = AppBarKt.FABVerticalPadding;
                                    f6 = AppBarKt.FABHorizontalPadding;
                                    Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(fillMaxHeight$default, 0.0f, f5, f6, 0.0f, 9, null);
                                    Alignment topStart = Alignment.INSTANCE.getTopStart();
                                    Function2<Composer, Integer, Unit> function24 = function22;
                                    composer3.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(topStart, false, composer3, 6);
                                    composer3.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
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
                                    ComposerKt.sourceInformationMarkerStart(composer3, 1859776956, "C493@24730L22:AppBar.kt#uh7d8r");
                                    function24.invoke(composer3, 0);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    composer3.endReplaceableGroup();
                                    composer3.endNode();
                                    composer3.endReplaceableGroup();
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
                    }), composer2, i152 | (i162 & 112) | (i162 & 896) | (i162 & 7168) | (57344 & i162) | (458752 & i162) | (i162 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    function23 = function22;
                    modifier4 = modifier3;
                    j7 = j5;
                    j8 = j6;
                    f4 = f3;
                    paddingValues3 = paddingValues2;
                    windowInsets4 = windowInsets3;
                    bottomAppBarScrollBehavior3 = bottomAppBarScrollBehavior2;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                f2 = f;
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                if ((i & 12582912) == 0) {
                }
                i7 = i2 & 256;
                if (i7 == 0) {
                }
                i8 = i7;
                if ((i3 & 38347923) == 38347922) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i14 != 0) {
                }
                if (i4 != 0) {
                }
                if ((i2 & 8) != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if ((i2 & 128) != 0) {
                }
                if (i8 != 0) {
                }
                f3 = m1902getContainerElevationD9Ej5fM;
                paddingValues2 = contentPadding;
                windowInsets3 = windowInsets2;
                i9 = 12582912;
                modifier3 = modifier2;
                j5 = j3;
                j6 = j4;
                i10 = -1044837119;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i1522 = i9 | ((i3 >> 3) & 14);
                int i1622 = i3 >> 6;
                composer2 = startRestartGroup;
                m1886BottomAppBare3WI5M(modifier3, j5, j6, f3, paddingValues2, windowInsets3, bottomAppBarScrollBehavior2, ComposableLambdaKt.composableLambda(startRestartGroup, 1566394874, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$2
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
                        float f5;
                        float f6;
                        ComposerKt.sourceInformation(composer3, "C477@24226L184,484@24459L303:AppBar.kt#uh7d8r");
                        if ((i17 & 6) == 0) {
                            i18 = i17 | (composer3.changed(rowScope) ? 4 : 2);
                        } else {
                            i18 = i17;
                        }
                        if ((i18 & 19) != 18 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1566394874, i18, -1, "androidx.compose.material3.BottomAppBar.<anonymous> (AppBar.kt:477)");
                            }
                            Modifier weight$default = RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null);
                            Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                            Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                            composer3.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer3, 54);
                            composer3.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(weight$default);
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
                            function32.invoke(RowScopeInstance.INSTANCE, composer3, 6);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endReplaceableGroup();
                            composer3.endNode();
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                            if (function22 != null) {
                                Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
                                f5 = AppBarKt.FABVerticalPadding;
                                f6 = AppBarKt.FABHorizontalPadding;
                                Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(fillMaxHeight$default, 0.0f, f5, f6, 0.0f, 9, null);
                                Alignment topStart = Alignment.INSTANCE.getTopStart();
                                Function2<Composer, Integer, Unit> function24 = function22;
                                composer3.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(topStart, false, composer3, 6);
                                composer3.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
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
                                ComposerKt.sourceInformationMarkerStart(composer3, 1859776956, "C493@24730L22:AppBar.kt#uh7d8r");
                                function24.invoke(composer3, 0);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endReplaceableGroup();
                                composer3.endNode();
                                composer3.endReplaceableGroup();
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
                }), composer2, i1522 | (i1622 & 112) | (i1622 & 896) | (i1622 & 7168) | (57344 & i1622) | (458752 & i1622) | (i1622 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                function23 = function22;
                modifier4 = modifier3;
                j7 = j5;
                j8 = j6;
                f4 = f3;
                paddingValues3 = paddingValues2;
                windowInsets4 = windowInsets3;
                bottomAppBarScrollBehavior3 = bottomAppBarScrollBehavior2;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function22 = function2;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            f2 = f;
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            i7 = i2 & 256;
            if (i7 == 0) {
            }
            i8 = i7;
            if ((i3 & 38347923) == 38347922) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i14 != 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 8) != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if ((i2 & 128) != 0) {
            }
            if (i8 != 0) {
            }
            f3 = m1902getContainerElevationD9Ej5fM;
            paddingValues2 = contentPadding;
            windowInsets3 = windowInsets2;
            i9 = 12582912;
            modifier3 = modifier2;
            j5 = j3;
            j6 = j4;
            i10 = -1044837119;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i15222 = i9 | ((i3 >> 3) & 14);
            int i16222 = i3 >> 6;
            composer2 = startRestartGroup;
            m1886BottomAppBare3WI5M(modifier3, j5, j6, f3, paddingValues2, windowInsets3, bottomAppBarScrollBehavior2, ComposableLambdaKt.composableLambda(startRestartGroup, 1566394874, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$2
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
                    float f5;
                    float f6;
                    ComposerKt.sourceInformation(composer3, "C477@24226L184,484@24459L303:AppBar.kt#uh7d8r");
                    if ((i17 & 6) == 0) {
                        i18 = i17 | (composer3.changed(rowScope) ? 4 : 2);
                    } else {
                        i18 = i17;
                    }
                    if ((i18 & 19) != 18 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1566394874, i18, -1, "androidx.compose.material3.BottomAppBar.<anonymous> (AppBar.kt:477)");
                        }
                        Modifier weight$default = RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null);
                        Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                        composer3.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer3, 54);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(weight$default);
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
                        function32.invoke(RowScopeInstance.INSTANCE, composer3, 6);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        if (function22 != null) {
                            Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
                            f5 = AppBarKt.FABVerticalPadding;
                            f6 = AppBarKt.FABHorizontalPadding;
                            Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(fillMaxHeight$default, 0.0f, f5, f6, 0.0f, 9, null);
                            Alignment topStart = Alignment.INSTANCE.getTopStart();
                            Function2<Composer, Integer, Unit> function24 = function22;
                            composer3.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(topStart, false, composer3, 6);
                            composer3.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
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
                            ComposerKt.sourceInformationMarkerStart(composer3, 1859776956, "C493@24730L22:AppBar.kt#uh7d8r");
                            function24.invoke(composer3, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endReplaceableGroup();
                            composer3.endNode();
                            composer3.endReplaceableGroup();
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
            }), composer2, i15222 | (i16222 & 112) | (i16222 & 896) | (i16222 & 7168) | (57344 & i16222) | (458752 & i16222) | (i16222 & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            function23 = function22;
            modifier4 = modifier3;
            j7 = j5;
            j8 = j6;
            f4 = f3;
            paddingValues3 = paddingValues2;
            windowInsets4 = windowInsets3;
            bottomAppBarScrollBehavior3 = bottomAppBarScrollBehavior2;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        function22 = function2;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        f2 = f;
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        i7 = i2 & 256;
        if (i7 == 0) {
        }
        i8 = i7;
        if ((i3 & 38347923) == 38347922) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i14 != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if ((i2 & 128) != 0) {
        }
        if (i8 != 0) {
        }
        f3 = m1902getContainerElevationD9Ej5fM;
        paddingValues2 = contentPadding;
        windowInsets3 = windowInsets2;
        i9 = 12582912;
        modifier3 = modifier2;
        j5 = j3;
        j6 = j4;
        i10 = -1044837119;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i152222 = i9 | ((i3 >> 3) & 14);
        int i162222 = i3 >> 6;
        composer2 = startRestartGroup;
        m1886BottomAppBare3WI5M(modifier3, j5, j6, f3, paddingValues2, windowInsets3, bottomAppBarScrollBehavior2, ComposableLambdaKt.composableLambda(startRestartGroup, 1566394874, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$2
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
                float f5;
                float f6;
                ComposerKt.sourceInformation(composer3, "C477@24226L184,484@24459L303:AppBar.kt#uh7d8r");
                if ((i17 & 6) == 0) {
                    i18 = i17 | (composer3.changed(rowScope) ? 4 : 2);
                } else {
                    i18 = i17;
                }
                if ((i18 & 19) != 18 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1566394874, i18, -1, "androidx.compose.material3.BottomAppBar.<anonymous> (AppBar.kt:477)");
                    }
                    Modifier weight$default = RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null);
                    Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                    composer3.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer3, 54);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(weight$default);
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
                    function32.invoke(RowScopeInstance.INSTANCE, composer3, 6);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    if (function22 != null) {
                        Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
                        f5 = AppBarKt.FABVerticalPadding;
                        f6 = AppBarKt.FABHorizontalPadding;
                        Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(fillMaxHeight$default, 0.0f, f5, f6, 0.0f, 9, null);
                        Alignment topStart = Alignment.INSTANCE.getTopStart();
                        Function2<Composer, Integer, Unit> function24 = function22;
                        composer3.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(topStart, false, composer3, 6);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
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
                        ComposerKt.sourceInformationMarkerStart(composer3, 1859776956, "C493@24730L22:AppBar.kt#uh7d8r");
                        function24.invoke(composer3, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
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
        }), composer2, i152222 | (i162222 & 112) | (i162222 & 896) | (i162222 & 7168) | (57344 & i162222) | (458752 & i162222) | (i162222 & 3670016), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        function23 = function22;
        modifier4 = modifier3;
        j7 = j5;
        j8 = j6;
        f4 = f3;
        paddingValues3 = paddingValues2;
        windowInsets4 = windowInsets3;
        bottomAppBarScrollBehavior3 = bottomAppBarScrollBehavior2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0087  */
    /* renamed from: BottomAppBar-1oL4kX8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1884BottomAppBar1oL4kX8(Modifier modifier, long j, long j2, float f, PaddingValues paddingValues, WindowInsets windowInsets, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long j3;
        long j4;
        float f2;
        int i4;
        PaddingValues paddingValues2;
        WindowInsets windowInsets2;
        Modifier modifier3;
        int i5;
        float f3;
        PaddingValues paddingValues3;
        WindowInsets windowInsets3;
        int i6;
        long j5;
        long j6;
        Composer composer2;
        final Modifier modifier4;
        final long j7;
        final long j8;
        final float f4;
        final PaddingValues paddingValues4;
        final WindowInsets windowInsets4;
        ScopeUpdateScope endRestartGroup;
        int i7;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(-1391700845);
        ComposerKt.sourceInformation(startRestartGroup, "C(BottomAppBar)P(4,0:c#ui.graphics.Color,2:c#ui.graphics.Color,5:c#ui.unit.Dp,3,6)527@26431L14,528@26473L31,531@26699L12,533@26762L266:AppBar.kt#uh7d8r");
        int i10 = i2 & 1;
        if (i10 != 0) {
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
        if ((i & 384) == 0) {
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
        } else if ((i & 3072) == 0) {
            f2 = f;
            i3 |= startRestartGroup.changed(f2) ? 2048 : 1024;
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                paddingValues2 = paddingValues;
                i3 |= startRestartGroup.changed(paddingValues2) ? 16384 : 8192;
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        windowInsets2 = windowInsets;
                        if (startRestartGroup.changed(windowInsets2)) {
                            i7 = 131072;
                            i3 |= i7;
                        }
                    } else {
                        windowInsets2 = windowInsets;
                    }
                    i7 = 65536;
                    i3 |= i7;
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
                            Modifier.Companion companion = i10 == 0 ? Modifier.INSTANCE : modifier2;
                            if ((i2 & 2) != 0) {
                                j3 = BottomAppBarDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                                i3 &= -113;
                            }
                            if ((i2 & 4) != 0) {
                                j4 = ColorSchemeKt.m2049contentColorForek8zF_U(j3, startRestartGroup, (i3 >> 3) & 14);
                                i3 &= -897;
                            }
                            if (i11 != 0) {
                                f2 = BottomAppBarDefaults.INSTANCE.m1902getContainerElevationD9Ej5fM();
                            }
                            if (i4 != 0) {
                                paddingValues2 = BottomAppBarDefaults.INSTANCE.getContentPadding();
                            }
                            if ((i2 & 32) == 0) {
                                i3 &= -458753;
                                float f5 = f2;
                                modifier3 = companion;
                                i5 = 1572864;
                                f3 = f5;
                                windowInsets3 = BottomAppBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                                j6 = j4;
                                paddingValues3 = paddingValues2;
                                i6 = -1391700845;
                                j5 = j3;
                            } else {
                                float f6 = f2;
                                modifier3 = companion;
                                i5 = 1572864;
                                f3 = f6;
                                paddingValues3 = paddingValues2;
                                windowInsets3 = windowInsets2;
                                i6 = -1391700845;
                                j5 = j3;
                                j6 = j4;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 2) != 0) {
                                i3 &= -113;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            paddingValues3 = paddingValues2;
                            windowInsets3 = windowInsets2;
                            i5 = 1572864;
                            i6 = -1391700845;
                            j5 = j3;
                            j6 = j4;
                            f3 = f2;
                            modifier3 = modifier2;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i6, i3, -1, "androidx.compose.material3.BottomAppBar (AppBar.kt:533)");
                        }
                        composer2 = startRestartGroup;
                        m1886BottomAppBare3WI5M(modifier3, j5, j6, f3, paddingValues3, windowInsets3, null, function3, composer2, i5 | (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (29360128 & (i3 << 3)), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        j7 = j5;
                        j8 = j6;
                        f4 = f3;
                        paddingValues4 = paddingValues3;
                        windowInsets4 = windowInsets3;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        composer2 = startRestartGroup;
                        modifier4 = modifier2;
                        j7 = j3;
                        j8 = j4;
                        f4 = f2;
                        paddingValues4 = paddingValues2;
                        windowInsets4 = windowInsets2;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$4
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
                                AppBarKt.m1884BottomAppBar1oL4kX8(Modifier.this, j7, j8, f4, paddingValues4, windowInsets4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
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
                if (i10 == 0) {
                }
                if ((i2 & 2) != 0) {
                }
                if ((i2 & 4) != 0) {
                }
                if (i11 != 0) {
                }
                if (i4 != 0) {
                }
                if ((i2 & 32) == 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                m1886BottomAppBare3WI5M(modifier3, j5, j6, f3, paddingValues3, windowInsets3, null, function3, composer2, i5 | (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (29360128 & (i3 << 3)), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier4 = modifier3;
                j7 = j5;
                j8 = j6;
                f4 = f3;
                paddingValues4 = paddingValues3;
                windowInsets4 = windowInsets3;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            paddingValues2 = paddingValues;
            if ((196608 & i) == 0) {
            }
            if ((i2 & 64) != 0) {
            }
            if ((i3 & 599187) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i10 == 0) {
            }
            if ((i2 & 2) != 0) {
            }
            if ((i2 & 4) != 0) {
            }
            if (i11 != 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 32) == 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            m1886BottomAppBare3WI5M(modifier3, j5, j6, f3, paddingValues3, windowInsets3, null, function3, composer2, i5 | (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (29360128 & (i3 << 3)), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier4 = modifier3;
            j7 = j5;
            j8 = j6;
            f4 = f3;
            paddingValues4 = paddingValues3;
            windowInsets4 = windowInsets3;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        f2 = f;
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        paddingValues2 = paddingValues;
        if ((196608 & i) == 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if ((i3 & 599187) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i10 == 0) {
        }
        if ((i2 & 2) != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if (i11 != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 32) == 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        m1886BottomAppBare3WI5M(modifier3, j5, j6, f3, paddingValues3, windowInsets3, null, function3, composer2, i5 | (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (29360128 & (i3 << 3)), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        j7 = j5;
        j8 = j6;
        f4 = f3;
        paddingValues4 = paddingValues3;
        windowInsets4 = windowInsets3;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02e0  */
    /* renamed from: BottomAppBar-e-3WI5M, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1886BottomAppBare3WI5M(Modifier modifier, long j, long j2, float f, PaddingValues paddingValues, WindowInsets windowInsets, BottomAppBarScrollBehavior bottomAppBarScrollBehavior, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long j3;
        long j4;
        float f2;
        int i4;
        PaddingValues paddingValues2;
        int i5;
        WindowInsets windowInsets2;
        final WindowInsets windowInsets3;
        final PaddingValues paddingValues3;
        long j5;
        int i6;
        int i7;
        long j6;
        final BottomAppBarScrollBehavior bottomAppBarScrollBehavior2;
        float f3;
        int i8;
        int i9;
        int i10;
        Modifier.Companion companion;
        boolean z;
        Object rememberedValue;
        Composer composer2;
        final PaddingValues paddingValues4;
        final Modifier modifier3;
        final WindowInsets windowInsets4;
        final BottomAppBarScrollBehavior bottomAppBarScrollBehavior3;
        final long j7;
        final long j8;
        final float f4;
        ScopeUpdateScope endRestartGroup;
        int i11;
        int i12;
        Composer startRestartGroup = composer.startRestartGroup(422438773);
        ComposerKt.sourceInformation(startRestartGroup, "C(BottomAppBar)P(4,0:c#ui.graphics.Color,2:c#ui.graphics.Color,6:c#ui.unit.Dp,3,7,5)577@29038L14,578@29080L31,581@29306L12,613@30640L5,615@30695L577,608@30373L1325:AppBar.kt#uh7d8r");
        int i13 = i2 & 1;
        if (i13 != 0) {
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
                j3 = j;
                if (startRestartGroup.changed(j3)) {
                    i12 = 32;
                    i3 |= i12;
                }
            } else {
                j3 = j;
            }
            i12 = 16;
            i3 |= i12;
        } else {
            j3 = j;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                j4 = j2;
                if (startRestartGroup.changed(j4)) {
                    i11 = 256;
                    i3 |= i11;
                }
            } else {
                j4 = j2;
            }
            i11 = 128;
            i3 |= i11;
        } else {
            j4 = j2;
        }
        int i14 = i2 & 8;
        if (i14 != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            f2 = f;
            i3 |= startRestartGroup.changed(f2) ? 2048 : 1024;
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                paddingValues2 = paddingValues;
                i3 |= startRestartGroup.changed(paddingValues2) ? 16384 : 8192;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    i3 |= ((i2 & 32) == 0 && startRestartGroup.changed(windowInsets)) ? 131072 : 65536;
                }
                i5 = i2 & 64;
                if (i5 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    i3 |= startRestartGroup.changed(bottomAppBarScrollBehavior) ? 1048576 : 524288;
                }
                if ((i2 & 128) != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    i3 |= startRestartGroup.changedInstance(function3) ? 8388608 : 4194304;
                }
                if ((4793491 & i3) == 4793490 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        if (i13 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 2) != 0) {
                            j3 = BottomAppBarDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                            i3 &= -113;
                        }
                        if ((i2 & 4) != 0) {
                            j4 = ColorSchemeKt.m2049contentColorForek8zF_U(j3, startRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                        }
                        if (i14 != 0) {
                            f2 = BottomAppBarDefaults.INSTANCE.m1902getContainerElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            paddingValues2 = BottomAppBarDefaults.INSTANCE.getContentPadding();
                        }
                        if ((i2 & 32) != 0) {
                            windowInsets2 = BottomAppBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                            i3 &= -458753;
                        } else {
                            windowInsets2 = windowInsets;
                        }
                        if (i5 != 0) {
                            int i15 = i3;
                            windowInsets3 = windowInsets2;
                            paddingValues3 = paddingValues2;
                            j5 = j3;
                            i6 = i15;
                            long j9 = j4;
                            i7 = 12582912;
                            j6 = j9;
                            f3 = f2;
                            bottomAppBarScrollBehavior2 = null;
                        } else {
                            int i16 = i3;
                            windowInsets3 = windowInsets2;
                            paddingValues3 = paddingValues2;
                            j5 = j3;
                            i6 = i16;
                            long j10 = j4;
                            i7 = 12582912;
                            j6 = j10;
                            bottomAppBarScrollBehavior2 = bottomAppBarScrollBehavior;
                            f3 = f2;
                        }
                        i8 = 422438773;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                        }
                        long j11 = j4;
                        i7 = 12582912;
                        j6 = j11;
                        f3 = f2;
                        paddingValues3 = paddingValues2;
                        i8 = 422438773;
                        j5 = j3;
                        bottomAppBarScrollBehavior2 = bottomAppBarScrollBehavior;
                        i6 = i3;
                        windowInsets3 = windowInsets;
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i8, i6, -1, "androidx.compose.material3.BottomAppBar (AppBar.kt:584)");
                    }
                    startRestartGroup.startReplaceableGroup(1291864525);
                    ComposerKt.sourceInformation(startRestartGroup, "589@29726L83,589@29703L106,592@29839L261");
                    if (bottomAppBarScrollBehavior2 == null && !bottomAppBarScrollBehavior2.getIsPinned()) {
                        Modifier.Companion companion2 = Modifier.INSTANCE;
                        Orientation orientation = Orientation.Vertical;
                        i9 = i7;
                        startRestartGroup.startReplaceableGroup(1291864702);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AppBar.kt#9igjgp");
                        int i17 = i6 & 3670016;
                        i10 = 3670016;
                        boolean z2 = i17 == 1048576;
                        Object rememberedValue2 = startRestartGroup.rememberedValue();
                        if (z2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = (Function1) new Function1<Float, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$appBarDragModifier$1$1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Float f5) {
                                    invoke(f5.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f5) {
                                    BottomAppBarState state = BottomAppBarScrollBehavior.this.getState();
                                    state.setHeightOffset(state.getHeightOffset() - f5);
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                        }
                        startRestartGroup.endReplaceableGroup();
                        DraggableState rememberDraggableState = DraggableKt.rememberDraggableState((Function1) rememberedValue2, startRestartGroup, 0);
                        Modifier.Companion companion3 = companion2;
                        startRestartGroup.startReplaceableGroup(1291864815);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AppBar.kt#9igjgp");
                        boolean z3 = i17 == 1048576;
                        AppBarKt$BottomAppBar$appBarDragModifier$2$1 rememberedValue3 = startRestartGroup.rememberedValue();
                        if (z3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue3 = new AppBarKt$BottomAppBar$appBarDragModifier$2$1(bottomAppBarScrollBehavior2, null);
                            startRestartGroup.updateRememberedValue(rememberedValue3);
                        }
                        startRestartGroup.endReplaceableGroup();
                        companion = DraggableKt.draggable$default(companion3, rememberDraggableState, orientation, false, null, false, null, (Function3) rememberedValue3, false, 188, null);
                    } else {
                        i9 = i7;
                        i10 = 3670016;
                        companion = Modifier.INSTANCE;
                    }
                    startRestartGroup.endReplaceableGroup();
                    Shape value = ShapesKt.getValue(BottomAppBarTokens.INSTANCE.getContainerShape(), startRestartGroup, 6);
                    startRestartGroup.startReplaceableGroup(1291865671);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AppBar.kt#9igjgp");
                    z = (i6 & i10) == 1048576;
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!z || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$5$1
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                                return m1892invoke3p2s80s(measureScope, measurable, constraints.getValue());
                            }

                            /* renamed from: invoke-3p2s80s, reason: not valid java name */
                            public final MeasureResult m1892invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j12) {
                                BottomAppBarState state;
                                BottomAppBarScrollBehavior bottomAppBarScrollBehavior4 = BottomAppBarScrollBehavior.this;
                                BottomAppBarState state2 = bottomAppBarScrollBehavior4 != null ? bottomAppBarScrollBehavior4.getState() : null;
                                if (state2 != null) {
                                    state2.setHeightOffsetLimit(-measureScope.mo630toPx0680j_4(BottomAppBarTokens.INSTANCE.m2970getContainerHeightD9Ej5fM()));
                                }
                                final Placeable mo5333measureBRTryo0 = measurable.mo5333measureBRTryo0(j12);
                                float height = mo5333measureBRTryo0.getHeight();
                                BottomAppBarScrollBehavior bottomAppBarScrollBehavior5 = BottomAppBarScrollBehavior.this;
                                return MeasureScope.layout$default(measureScope, mo5333measureBRTryo0.getWidth(), MathKt.roundToInt(height + ((bottomAppBarScrollBehavior5 == null || (state = bottomAppBarScrollBehavior5.getState()) == null) ? 0.0f : state.getHeightOffset())), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$5$1.1
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
                                        Placeable.PlacementScope.place$default(placementScope, Placeable.this, 0, 0, 0.0f, 4, null);
                                    }
                                }, 4, null);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    startRestartGroup.endReplaceableGroup();
                    int i18 = i6 << 3;
                    composer2 = startRestartGroup;
                    SurfaceKt.m2633SurfaceT9BRK9s(LayoutModifierKt.layout(modifier2, (Function3) rememberedValue).then(companion), value, j5, j6, f3, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1243053520, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$6
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

                        public final void invoke(Composer composer3, int i19) {
                            ComposerKt.sourceInformation(composer3, "C629@31327L365:AppBar.kt#uh7d8r");
                            if ((i19 & 3) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1243053520, i19, -1, "androidx.compose.material3.BottomAppBar.<anonymous> (AppBar.kt:629)");
                                }
                                Modifier padding = PaddingKt.padding(SizeKt.m914height3ABfNKs(WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), WindowInsets.this), BottomAppBarTokens.INSTANCE.m2970getContainerHeightD9Ej5fM()), paddingValues3);
                                Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                                composer3.startReplaceableGroup(693286680);
                                ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer3, 54);
                                composer3.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(padding);
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
                                function32.invoke(RowScopeInstance.INSTANCE, composer3, 6);
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
                    }), composer2, (i18 & 896) | i9 | (i18 & 7168) | (i18 & 57344), 96);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    paddingValues4 = paddingValues3;
                    modifier3 = modifier2;
                    windowInsets4 = windowInsets3;
                    bottomAppBarScrollBehavior3 = bottomAppBarScrollBehavior2;
                    j7 = j5;
                    j8 = j6;
                    f4 = f3;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    bottomAppBarScrollBehavior3 = bottomAppBarScrollBehavior;
                    composer2 = startRestartGroup;
                    modifier3 = modifier2;
                    j7 = j3;
                    j8 = j4;
                    f4 = f2;
                    paddingValues4 = paddingValues2;
                    windowInsets4 = windowInsets;
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$7
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

                        public final void invoke(Composer composer3, int i19) {
                            AppBarKt.m1886BottomAppBare3WI5M(Modifier.this, j7, j8, f4, paddingValues4, windowInsets4, bottomAppBarScrollBehavior3, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            paddingValues2 = paddingValues;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            }
            i5 = i2 & 64;
            if (i5 != 0) {
            }
            if ((i2 & 128) != 0) {
            }
            if ((4793491 & i3) == 4793490) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i13 != 0) {
            }
            if ((i2 & 2) != 0) {
            }
            if ((i2 & 4) != 0) {
            }
            if (i14 != 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if (i5 != 0) {
            }
            i8 = 422438773;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(1291864525);
            ComposerKt.sourceInformation(startRestartGroup, "589@29726L83,589@29703L106,592@29839L261");
            if (bottomAppBarScrollBehavior2 == null) {
            }
            i9 = i7;
            i10 = 3670016;
            companion = Modifier.INSTANCE;
            startRestartGroup.endReplaceableGroup();
            Shape value2 = ShapesKt.getValue(BottomAppBarTokens.INSTANCE.getContainerShape(), startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(1291865671);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AppBar.kt#9igjgp");
            if ((i6 & i10) == 1048576) {
            }
            rememberedValue = startRestartGroup.rememberedValue();
            if (!z) {
            }
            rememberedValue = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$5$1
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                    return m1892invoke3p2s80s(measureScope, measurable, constraints.getValue());
                }

                /* renamed from: invoke-3p2s80s, reason: not valid java name */
                public final MeasureResult m1892invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j12) {
                    BottomAppBarState state;
                    BottomAppBarScrollBehavior bottomAppBarScrollBehavior4 = BottomAppBarScrollBehavior.this;
                    BottomAppBarState state2 = bottomAppBarScrollBehavior4 != null ? bottomAppBarScrollBehavior4.getState() : null;
                    if (state2 != null) {
                        state2.setHeightOffsetLimit(-measureScope.mo630toPx0680j_4(BottomAppBarTokens.INSTANCE.m2970getContainerHeightD9Ej5fM()));
                    }
                    final Placeable mo5333measureBRTryo0 = measurable.mo5333measureBRTryo0(j12);
                    float height = mo5333measureBRTryo0.getHeight();
                    BottomAppBarScrollBehavior bottomAppBarScrollBehavior5 = BottomAppBarScrollBehavior.this;
                    return MeasureScope.layout$default(measureScope, mo5333measureBRTryo0.getWidth(), MathKt.roundToInt(height + ((bottomAppBarScrollBehavior5 == null || (state = bottomAppBarScrollBehavior5.getState()) == null) ? 0.0f : state.getHeightOffset())), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$5$1.1
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
                            Placeable.PlacementScope.place$default(placementScope, Placeable.this, 0, 0, 0.0f, 4, null);
                        }
                    }, 4, null);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceableGroup();
            int i182 = i6 << 3;
            composer2 = startRestartGroup;
            SurfaceKt.m2633SurfaceT9BRK9s(LayoutModifierKt.layout(modifier2, (Function3) rememberedValue).then(companion), value2, j5, j6, f3, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1243053520, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$6
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

                public final void invoke(Composer composer3, int i19) {
                    ComposerKt.sourceInformation(composer3, "C629@31327L365:AppBar.kt#uh7d8r");
                    if ((i19 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1243053520, i19, -1, "androidx.compose.material3.BottomAppBar.<anonymous> (AppBar.kt:629)");
                        }
                        Modifier padding = PaddingKt.padding(SizeKt.m914height3ABfNKs(WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), WindowInsets.this), BottomAppBarTokens.INSTANCE.m2970getContainerHeightD9Ej5fM()), paddingValues3);
                        Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                        composer3.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer3, 54);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(padding);
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
                        function32.invoke(RowScopeInstance.INSTANCE, composer3, 6);
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
            }), composer2, (i182 & 896) | i9 | (i182 & 7168) | (i182 & 57344), 96);
            if (ComposerKt.isTraceInProgress()) {
            }
            paddingValues4 = paddingValues3;
            modifier3 = modifier2;
            windowInsets4 = windowInsets3;
            bottomAppBarScrollBehavior3 = bottomAppBarScrollBehavior2;
            j7 = j5;
            j8 = j6;
            f4 = f3;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        f2 = f;
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        paddingValues2 = paddingValues;
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
        }
        i5 = i2 & 64;
        if (i5 != 0) {
        }
        if ((i2 & 128) != 0) {
        }
        if ((4793491 & i3) == 4793490) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i13 != 0) {
        }
        if ((i2 & 2) != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if (i14 != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if (i5 != 0) {
        }
        i8 = 422438773;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(1291864525);
        ComposerKt.sourceInformation(startRestartGroup, "589@29726L83,589@29703L106,592@29839L261");
        if (bottomAppBarScrollBehavior2 == null) {
        }
        i9 = i7;
        i10 = 3670016;
        companion = Modifier.INSTANCE;
        startRestartGroup.endReplaceableGroup();
        Shape value22 = ShapesKt.getValue(BottomAppBarTokens.INSTANCE.getContainerShape(), startRestartGroup, 6);
        startRestartGroup.startReplaceableGroup(1291865671);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AppBar.kt#9igjgp");
        if ((i6 & i10) == 1048576) {
        }
        rememberedValue = startRestartGroup.rememberedValue();
        if (!z) {
        }
        rememberedValue = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$5$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                return m1892invoke3p2s80s(measureScope, measurable, constraints.getValue());
            }

            /* renamed from: invoke-3p2s80s, reason: not valid java name */
            public final MeasureResult m1892invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j12) {
                BottomAppBarState state;
                BottomAppBarScrollBehavior bottomAppBarScrollBehavior4 = BottomAppBarScrollBehavior.this;
                BottomAppBarState state2 = bottomAppBarScrollBehavior4 != null ? bottomAppBarScrollBehavior4.getState() : null;
                if (state2 != null) {
                    state2.setHeightOffsetLimit(-measureScope.mo630toPx0680j_4(BottomAppBarTokens.INSTANCE.m2970getContainerHeightD9Ej5fM()));
                }
                final Placeable mo5333measureBRTryo0 = measurable.mo5333measureBRTryo0(j12);
                float height = mo5333measureBRTryo0.getHeight();
                BottomAppBarScrollBehavior bottomAppBarScrollBehavior5 = BottomAppBarScrollBehavior.this;
                return MeasureScope.layout$default(measureScope, mo5333measureBRTryo0.getWidth(), MathKt.roundToInt(height + ((bottomAppBarScrollBehavior5 == null || (state = bottomAppBarScrollBehavior5.getState()) == null) ? 0.0f : state.getHeightOffset())), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$5$1.1
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
                        Placeable.PlacementScope.place$default(placementScope, Placeable.this, 0, 0, 0.0f, 4, null);
                    }
                }, 4, null);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceableGroup();
        int i1822 = i6 << 3;
        composer2 = startRestartGroup;
        SurfaceKt.m2633SurfaceT9BRK9s(LayoutModifierKt.layout(modifier2, (Function3) rememberedValue).then(companion), value22, j5, j6, f3, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1243053520, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$6
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

            public final void invoke(Composer composer3, int i19) {
                ComposerKt.sourceInformation(composer3, "C629@31327L365:AppBar.kt#uh7d8r");
                if ((i19 & 3) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1243053520, i19, -1, "androidx.compose.material3.BottomAppBar.<anonymous> (AppBar.kt:629)");
                    }
                    Modifier padding = PaddingKt.padding(SizeKt.m914height3ABfNKs(WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), WindowInsets.this), BottomAppBarTokens.INSTANCE.m2970getContainerHeightD9Ej5fM()), paddingValues3);
                    Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                    composer3.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer3, 54);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(padding);
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
                    function32.invoke(RowScopeInstance.INSTANCE, composer3, 6);
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
        }), composer2, (i1822 & 896) | i9 | (i1822 & 7168) | (i1822 & 57344), 96);
        if (ComposerKt.isTraceInProgress()) {
        }
        paddingValues4 = paddingValues3;
        modifier3 = modifier2;
        windowInsets4 = windowInsets3;
        bottomAppBarScrollBehavior3 = bottomAppBarScrollBehavior2;
        j7 = j5;
        j8 = j6;
        f4 = f3;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    public static final TopAppBarState rememberTopAppBarState(final float f, final float f2, final float f3, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1801969826);
        ComposerKt.sourceInformation(composer, "C(rememberTopAppBarState)P(2,1)1052@50642L145,1052@50595L192:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            f = -3.4028235E38f;
        }
        if ((i2 & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i2 & 4) != 0) {
            f3 = 0.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1801969826, i, -1, "androidx.compose.material3.rememberTopAppBarState (AppBar.kt:1051)");
        }
        Object[] objArr = new Object[0];
        Saver<TopAppBarState, ?> saver = TopAppBarState.INSTANCE.getSaver();
        composer.startReplaceableGroup(1171243704);
        ComposerKt.sourceInformation(composer, "CC(remember):AppBar.kt#9igjgp");
        boolean z = ((((i & 14) ^ 6) > 4 && composer.changed(f)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(f2)) || (i & 48) == 32) | ((((i & 896) ^ 384) > 256 && composer.changed(f3)) || (i & 384) == 256);
        Object rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = (Function0) new Function0<TopAppBarState>() { // from class: androidx.compose.material3.AppBarKt$rememberTopAppBarState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final TopAppBarState invoke() {
                    return new TopAppBarState(f, f2, f3);
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        TopAppBarState topAppBarState = (TopAppBarState) RememberSaveableKt.m3680rememberSaveable(objArr, (Saver) saver, (String) null, (Function0) rememberedValue, composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return topAppBarState;
    }

    public static final BottomAppBarState rememberBottomAppBarState(final float f, final float f2, final float f3, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1420874240);
        ComposerKt.sourceInformation(composer, "C(rememberBottomAppBarState)P(2,1)1373@63308L148,1373@63258L198:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            f = -3.4028235E38f;
        }
        if ((i2 & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i2 & 4) != 0) {
            f3 = 0.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1420874240, i, -1, "androidx.compose.material3.rememberBottomAppBarState (AppBar.kt:1372)");
        }
        Object[] objArr = new Object[0];
        Saver<BottomAppBarState, ?> saver = BottomAppBarState.INSTANCE.getSaver();
        composer.startReplaceableGroup(647586024);
        ComposerKt.sourceInformation(composer, "CC(remember):AppBar.kt#9igjgp");
        boolean z = ((((i & 14) ^ 6) > 4 && composer.changed(f)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(f2)) || (i & 48) == 32) | ((((i & 896) ^ 384) > 256 && composer.changed(f3)) || (i & 384) == 256);
        Object rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = (Function0) new Function0<BottomAppBarState>() { // from class: androidx.compose.material3.AppBarKt$rememberBottomAppBarState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final BottomAppBarState invoke() {
                    return AppBarKt.BottomAppBarState(f, f2, f3);
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        BottomAppBarState bottomAppBarState = (BottomAppBarState) RememberSaveableKt.m3680rememberSaveable(objArr, (Saver) saver, (String) null, (Function0) rememberedValue, composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return bottomAppBarState;
    }

    public static final BottomAppBarState BottomAppBarState(float f, float f2, float f3) {
        return new BottomAppBarStateImpl(f, f2, f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00af, code lost:
    
        if (androidx.compose.animation.core.SuspendAnimationKt.animateDecay$default(r5, r23, false, r6, r7, 2, null) == r2) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object settleAppBarBottom(BottomAppBarState bottomAppBarState, float f, DecayAnimationSpec<Float> decayAnimationSpec, AnimationSpec<Float> animationSpec, Continuation<? super Velocity> continuation) {
        AppBarKt$settleAppBarBottom$1 appBarKt$settleAppBarBottom$1;
        AppBarKt$settleAppBarBottom$1 appBarKt$settleAppBarBottom$12;
        Object coroutine_suspended;
        int i;
        final Ref.FloatRef floatRef;
        AnimationSpec<Float> animationSpec2;
        AnimationSpec<Float> animationSpec3;
        AnimationState AnimationState$default;
        Float boxFloat;
        Function1<AnimationScope<Float, AnimationVector1D>, Unit> function1;
        Ref.FloatRef floatRef2;
        final BottomAppBarState bottomAppBarState2 = bottomAppBarState;
        if (continuation instanceof AppBarKt$settleAppBarBottom$1) {
            appBarKt$settleAppBarBottom$1 = (AppBarKt$settleAppBarBottom$1) continuation;
            if ((appBarKt$settleAppBarBottom$1.label & Integer.MIN_VALUE) != 0) {
                appBarKt$settleAppBarBottom$1.label -= Integer.MIN_VALUE;
                appBarKt$settleAppBarBottom$12 = appBarKt$settleAppBarBottom$1;
                Object obj = appBarKt$settleAppBarBottom$12.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = appBarKt$settleAppBarBottom$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (bottomAppBarState2.getCollapsedFraction() < 0.01f || bottomAppBarState2.getCollapsedFraction() == 1.0f) {
                        return Velocity.m6615boximpl(Velocity.INSTANCE.m6635getZero9UxMQ8M());
                    }
                    floatRef = new Ref.FloatRef();
                    floatRef.element = f;
                    if (decayAnimationSpec == null || Math.abs(f) <= 1.0f) {
                        animationSpec2 = animationSpec;
                    } else {
                        final Ref.FloatRef floatRef3 = new Ref.FloatRef();
                        AnimationState AnimationState$default2 = AnimationStateKt.AnimationState$default(0.0f, f, 0L, 0L, false, 28, null);
                        Function1<AnimationScope<Float, AnimationVector1D>, Unit> function12 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.material3.AppBarKt$settleAppBarBottom$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                                invoke2(animationScope);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(AnimationScope<Float, AnimationVector1D> animationScope) {
                                float floatValue = animationScope.getValue().floatValue() - Ref.FloatRef.this.element;
                                float heightOffset = bottomAppBarState2.getHeightOffset();
                                bottomAppBarState2.setHeightOffset(heightOffset + floatValue);
                                float abs = Math.abs(heightOffset - bottomAppBarState2.getHeightOffset());
                                Ref.FloatRef.this.element = animationScope.getValue().floatValue();
                                floatRef.element = animationScope.getVelocity().floatValue();
                                if (Math.abs(floatValue - abs) > 0.5f) {
                                    animationScope.cancelAnimation();
                                }
                            }
                        };
                        appBarKt$settleAppBarBottom$12.L$0 = bottomAppBarState2;
                        animationSpec2 = animationSpec;
                        appBarKt$settleAppBarBottom$12.L$1 = animationSpec2;
                        appBarKt$settleAppBarBottom$12.L$2 = floatRef;
                        appBarKt$settleAppBarBottom$12.label = 1;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        floatRef2 = (Ref.FloatRef) appBarKt$settleAppBarBottom$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        floatRef = floatRef2;
                        return Velocity.m6615boximpl(VelocityKt.Velocity(0.0f, floatRef.element));
                    }
                    Ref.FloatRef floatRef4 = (Ref.FloatRef) appBarKt$settleAppBarBottom$12.L$2;
                    AnimationSpec<Float> animationSpec4 = (AnimationSpec) appBarKt$settleAppBarBottom$12.L$1;
                    BottomAppBarState bottomAppBarState3 = (BottomAppBarState) appBarKt$settleAppBarBottom$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    floatRef = floatRef4;
                    animationSpec2 = animationSpec4;
                    bottomAppBarState2 = bottomAppBarState3;
                }
                animationSpec3 = animationSpec2;
                if (animationSpec3 != null && bottomAppBarState2.getHeightOffset() < 0.0f && bottomAppBarState2.getHeightOffset() > bottomAppBarState2.getHeightOffsetLimit()) {
                    AnimationState$default = AnimationStateKt.AnimationState$default(bottomAppBarState2.getHeightOffset(), 0.0f, 0L, 0L, false, 30, null);
                    boxFloat = Boxing.boxFloat(bottomAppBarState2.getCollapsedFraction() >= 0.5f ? 0.0f : bottomAppBarState2.getHeightOffsetLimit());
                    function1 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.material3.AppBarKt$settleAppBarBottom$3
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                            invoke2(animationScope);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(AnimationScope<Float, AnimationVector1D> animationScope) {
                            BottomAppBarState.this.setHeightOffset(animationScope.getValue().floatValue());
                        }
                    };
                    appBarKt$settleAppBarBottom$12.L$0 = floatRef;
                    appBarKt$settleAppBarBottom$12.L$1 = null;
                    appBarKt$settleAppBarBottom$12.L$2 = null;
                    appBarKt$settleAppBarBottom$12.label = 2;
                    if (SuspendAnimationKt.animateTo$default(AnimationState$default, boxFloat, animationSpec3, false, function1, appBarKt$settleAppBarBottom$12, 4, null) != coroutine_suspended) {
                        floatRef2 = floatRef;
                        floatRef = floatRef2;
                    }
                    return coroutine_suspended;
                }
                return Velocity.m6615boximpl(VelocityKt.Velocity(0.0f, floatRef.element));
            }
        }
        appBarKt$settleAppBarBottom$1 = new AppBarKt$settleAppBarBottom$1(continuation);
        appBarKt$settleAppBarBottom$12 = appBarKt$settleAppBarBottom$1;
        Object obj2 = appBarKt$settleAppBarBottom$12.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = appBarKt$settleAppBarBottom$12.label;
        if (i != 0) {
        }
        animationSpec3 = animationSpec2;
        if (animationSpec3 != null) {
            AnimationState$default = AnimationStateKt.AnimationState$default(bottomAppBarState2.getHeightOffset(), 0.0f, 0L, 0L, false, 30, null);
            boxFloat = Boxing.boxFloat(bottomAppBarState2.getCollapsedFraction() >= 0.5f ? 0.0f : bottomAppBarState2.getHeightOffsetLimit());
            function1 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.material3.AppBarKt$settleAppBarBottom$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                    invoke2(animationScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AnimationScope<Float, AnimationVector1D> animationScope) {
                    BottomAppBarState.this.setHeightOffset(animationScope.getValue().floatValue());
                }
            };
            appBarKt$settleAppBarBottom$12.L$0 = floatRef;
            appBarKt$settleAppBarBottom$12.L$1 = null;
            appBarKt$settleAppBarBottom$12.L$2 = null;
            appBarKt$settleAppBarBottom$12.label = 2;
            if (SuspendAnimationKt.animateTo$default(AnimationState$default, boxFloat, animationSpec3, false, function1, appBarKt$settleAppBarBottom$12, 4, null) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        return Velocity.m6615boximpl(VelocityKt.Velocity(0.0f, floatRef.element));
    }

    public static final float getBottomAppBarVerticalPadding() {
        return BottomAppBarVerticalPadding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:101:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SingleRowTopAppBar(Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle textStyle, final boolean z, final Function2<? super Composer, ? super Integer, Unit> function22, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, final WindowInsets windowInsets, final TopAppBarColors topAppBarColors, final TopAppBarScrollBehavior topAppBarScrollBehavior, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        boolean changed;
        Object rememberedValue;
        Modifier.Companion companion;
        Composer composer2;
        TopAppBarState state;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(1841601619);
        ComposerKt.sourceInformation(startRestartGroup, "C(SingleRowTopAppBar)P(3,6,7,1,4!1,8)*1639@73368L7,1640@73441L167,1640@73430L178,1652@74154L151,1690@75611L1166:AppBar.kt#uh7d8r");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
            if ((i2 & 4) == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                i3 |= startRestartGroup.changed(textStyle) ? 256 : 128;
                if ((i2 & 8) != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    i3 |= startRestartGroup.changed(z) ? 2048 : 1024;
                    if ((i2 & 16) == 0) {
                        i3 |= 24576;
                    } else if ((i & 24576) == 0) {
                        i3 |= startRestartGroup.changedInstance(function22) ? 16384 : 8192;
                        if ((i2 & 32) != 0) {
                            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i3 |= startRestartGroup.changedInstance(function3) ? 131072 : 65536;
                        }
                        if ((i2 & 64) != 0) {
                            i3 |= 1572864;
                        } else if ((i & 1572864) == 0) {
                            i3 |= startRestartGroup.changed(windowInsets) ? 1048576 : 524288;
                            if ((i2 & 128) == 0) {
                                i3 |= 12582912;
                            } else if ((i & 12582912) == 0) {
                                i3 |= startRestartGroup.changed(topAppBarColors) ? 8388608 : 4194304;
                            }
                            if ((i2 & 256) == 0) {
                                i3 |= 100663296;
                            } else if ((i & 100663296) == 0) {
                                i3 |= startRestartGroup.changed(topAppBarScrollBehavior) ? 67108864 : 33554432;
                            }
                            if ((38347923 & i3) == 38347922 || !startRestartGroup.getSkipping()) {
                                if (i4 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1841601619, i3, -1, "androidx.compose.material3.SingleRowTopAppBar (AppBar.kt:1635)");
                                }
                                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume = startRestartGroup.consume(localDensity);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                final float f = -((Density) consume).mo630toPx0680j_4(TopAppBarSmallTokens.INSTANCE.m3518getContainerHeightD9Ej5fM());
                                startRestartGroup.startReplaceableGroup(-1008351447);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AppBar.kt#9igjgp");
                                int i5 = i3 & 234881024;
                                changed = (i5 != 67108864) | startRestartGroup.changed(f);
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$1$1
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
                                            TopAppBarState state2;
                                            TopAppBarScrollBehavior topAppBarScrollBehavior2 = TopAppBarScrollBehavior.this;
                                            if (Intrinsics.areEqual((topAppBarScrollBehavior2 == null || (state2 = topAppBarScrollBehavior2.getState()) == null) ? null : Float.valueOf(state2.getHeightOffsetLimit()), f)) {
                                                return;
                                            }
                                            TopAppBarScrollBehavior topAppBarScrollBehavior3 = TopAppBarScrollBehavior.this;
                                            TopAppBarState state3 = topAppBarScrollBehavior3 != null ? topAppBarScrollBehavior3.getState() : null;
                                            if (state3 == null) {
                                                return;
                                            }
                                            state3.setHeightOffsetLimit(f);
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                startRestartGroup.endReplaceableGroup();
                                EffectsKt.SideEffect((Function0) rememberedValue, startRestartGroup, 0);
                                State<Color> m421animateColorAsStateeuL9pac = SingleValueAnimationKt.m421animateColorAsStateeuL9pac(topAppBarColors.m2929containerColorvNxB06k$material3_release(((topAppBarScrollBehavior != null || (state = topAppBarScrollBehavior.getState()) == null) ? 0.0f : state.getOverlappedFraction()) <= 0.01f ? 1.0f : 0.0f), AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null), null, null, startRestartGroup, 48, 12);
                                final ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, 1520880938, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$actionsRow$1
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

                                    public final void invoke(Composer composer3, int i6) {
                                        ComposerKt.sourceInformation(composer3, "C1659@74390L157:AppBar.kt#uh7d8r");
                                        if ((i6 & 3) != 2 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1520880938, i6, -1, "androidx.compose.material3.SingleRowTopAppBar.<anonymous> (AppBar.kt:1659)");
                                            }
                                            Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                            Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                                            composer3.startReplaceableGroup(693286680);
                                            ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                            Modifier.Companion companion2 = Modifier.INSTANCE;
                                            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(end, centerVertically, composer3, 54);
                                            composer3.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion2);
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
                                            function32.invoke(RowScopeInstance.INSTANCE, composer3, 6);
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
                                });
                                startRestartGroup.startReplaceableGroup(-1008350212);
                                ComposerKt.sourceInformation(startRestartGroup, "1670@74853L118,1670@74830L141,1673@75001L255");
                                if (topAppBarScrollBehavior == null && !topAppBarScrollBehavior.getIsPinned()) {
                                    Modifier.Companion companion2 = Modifier.INSTANCE;
                                    Orientation orientation = Orientation.Vertical;
                                    startRestartGroup.startReplaceableGroup(-1008350035);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AppBar.kt#9igjgp");
                                    boolean z2 = i5 == 67108864;
                                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                                    if (z2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue2 = (Function1) new Function1<Float, Unit>() { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$appBarDragModifier$1$1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(Float f2) {
                                                invoke(f2.floatValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(float f2) {
                                                TopAppBarScrollBehavior.this.getState().setHeightOffset(TopAppBarScrollBehavior.this.getState().getHeightOffset() + f2);
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue2);
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    DraggableState rememberDraggableState = DraggableKt.rememberDraggableState((Function1) rememberedValue2, startRestartGroup, 0);
                                    Modifier.Companion companion3 = companion2;
                                    startRestartGroup.startReplaceableGroup(-1008349887);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AppBar.kt#9igjgp");
                                    boolean z3 = i5 == 67108864;
                                    AppBarKt$SingleRowTopAppBar$appBarDragModifier$2$1 rememberedValue3 = startRestartGroup.rememberedValue();
                                    if (z3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue3 = new AppBarKt$SingleRowTopAppBar$appBarDragModifier$2$1(topAppBarScrollBehavior, null);
                                        startRestartGroup.updateRememberedValue(rememberedValue3);
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    companion = DraggableKt.draggable$default(companion3, rememberDraggableState, orientation, false, null, false, null, (Function3) rememberedValue3, false, 188, null);
                                } else {
                                    companion = Modifier.INSTANCE;
                                }
                                startRestartGroup.endReplaceableGroup();
                                SurfaceKt.m2633SurfaceT9BRK9s(modifier2.then(companion), null, SingleRowTopAppBar$lambda$7(m421animateColorAsStateeuL9pac), 0L, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, 376925230, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$2
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

                                    public final void invoke(Composer composer3, int i6) {
                                        TopAppBarState state2;
                                        ComposerKt.sourceInformation(composer3, "C*1691@75731L7,1695@75881L890:AppBar.kt#uh7d8r");
                                        if ((i6 & 3) != 2 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(376925230, i6, -1, "androidx.compose.material3.SingleRowTopAppBar.<anonymous> (AppBar.kt:1691)");
                                            }
                                            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                            Object consume2 = composer3.consume(localDensity2);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            TopAppBarScrollBehavior topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                                            AppBarKt.m1888TopAppBarLayoutkXwM9vE(ClipKt.clipToBounds(WindowInsetsPaddingKt.windowInsetsPadding(Modifier.INSTANCE, WindowInsets.this)), ((Density) consume2).mo630toPx0680j_4(TopAppBarSmallTokens.INSTANCE.m3518getContainerHeightD9Ej5fM()) + ((topAppBarScrollBehavior2 == null || (state2 = topAppBarScrollBehavior2.getState()) == null) ? 0.0f : state2.getHeightOffset()), topAppBarColors.getNavigationIconContentColor(), topAppBarColors.getTitleContentColor(), topAppBarColors.getActionIconContentColor(), function2, textStyle, 1.0f, Arrangement.INSTANCE.getCenter(), z ? Arrangement.INSTANCE.getCenter() : Arrangement.INSTANCE.getStart(), 0, false, function22, composableLambda, composer3, 113246208, 3126);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }), startRestartGroup, 12582912, Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE);
                                composer2 = startRestartGroup;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                composer2 = startRestartGroup;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                final Modifier modifier3 = modifier2;
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$3
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

                                    public final void invoke(Composer composer3, int i6) {
                                        AppBarKt.SingleRowTopAppBar(Modifier.this, function2, textStyle, z, function22, function3, windowInsets, topAppBarColors, topAppBarScrollBehavior, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if ((i2 & 128) == 0) {
                        }
                        if ((i2 & 256) == 0) {
                        }
                        if ((38347923 & i3) == 38347922) {
                        }
                        if (i4 != 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume2 = startRestartGroup.consume(localDensity2);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        final float f2 = -((Density) consume2).mo630toPx0680j_4(TopAppBarSmallTokens.INSTANCE.m3518getContainerHeightD9Ej5fM());
                        startRestartGroup.startReplaceableGroup(-1008351447);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AppBar.kt#9igjgp");
                        int i52 = i3 & 234881024;
                        changed = (i52 != 67108864) | startRestartGroup.changed(f2);
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (!changed) {
                        }
                        rememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$1$1
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
                                TopAppBarState state2;
                                TopAppBarScrollBehavior topAppBarScrollBehavior2 = TopAppBarScrollBehavior.this;
                                if (Intrinsics.areEqual((topAppBarScrollBehavior2 == null || (state2 = topAppBarScrollBehavior2.getState()) == null) ? null : Float.valueOf(state2.getHeightOffsetLimit()), f2)) {
                                    return;
                                }
                                TopAppBarScrollBehavior topAppBarScrollBehavior3 = TopAppBarScrollBehavior.this;
                                TopAppBarState state3 = topAppBarScrollBehavior3 != null ? topAppBarScrollBehavior3.getState() : null;
                                if (state3 == null) {
                                    return;
                                }
                                state3.setHeightOffsetLimit(f2);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                        startRestartGroup.endReplaceableGroup();
                        EffectsKt.SideEffect((Function0) rememberedValue, startRestartGroup, 0);
                        State<Color> m421animateColorAsStateeuL9pac2 = SingleValueAnimationKt.m421animateColorAsStateeuL9pac(topAppBarColors.m2929containerColorvNxB06k$material3_release(((topAppBarScrollBehavior != null || (state = topAppBarScrollBehavior.getState()) == null) ? 0.0f : state.getOverlappedFraction()) <= 0.01f ? 1.0f : 0.0f), AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null), null, null, startRestartGroup, 48, 12);
                        final Function2<? super Composer, ? super Integer, Unit> composableLambda2 = ComposableLambdaKt.composableLambda(startRestartGroup, 1520880938, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$actionsRow$1
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

                            public final void invoke(Composer composer3, int i6) {
                                ComposerKt.sourceInformation(composer3, "C1659@74390L157:AppBar.kt#uh7d8r");
                                if ((i6 & 3) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1520880938, i6, -1, "androidx.compose.material3.SingleRowTopAppBar.<anonymous> (AppBar.kt:1659)");
                                    }
                                    Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                    Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                                    composer3.startReplaceableGroup(693286680);
                                    ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                    Modifier.Companion companion22 = Modifier.INSTANCE;
                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(end, centerVertically, composer3, 54);
                                    composer3.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion22);
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
                                    function32.invoke(RowScopeInstance.INSTANCE, composer3, 6);
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
                        });
                        startRestartGroup.startReplaceableGroup(-1008350212);
                        ComposerKt.sourceInformation(startRestartGroup, "1670@74853L118,1670@74830L141,1673@75001L255");
                        if (topAppBarScrollBehavior == null) {
                        }
                        companion = Modifier.INSTANCE;
                        startRestartGroup.endReplaceableGroup();
                        SurfaceKt.m2633SurfaceT9BRK9s(modifier2.then(companion), null, SingleRowTopAppBar$lambda$7(m421animateColorAsStateeuL9pac2), 0L, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, 376925230, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$2
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

                            public final void invoke(Composer composer3, int i6) {
                                TopAppBarState state2;
                                ComposerKt.sourceInformation(composer3, "C*1691@75731L7,1695@75881L890:AppBar.kt#uh7d8r");
                                if ((i6 & 3) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(376925230, i6, -1, "androidx.compose.material3.SingleRowTopAppBar.<anonymous> (AppBar.kt:1691)");
                                    }
                                    ProvidableCompositionLocal<Density> localDensity22 = CompositionLocalsKt.getLocalDensity();
                                    ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    Object consume22 = composer3.consume(localDensity22);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    TopAppBarScrollBehavior topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                                    AppBarKt.m1888TopAppBarLayoutkXwM9vE(ClipKt.clipToBounds(WindowInsetsPaddingKt.windowInsetsPadding(Modifier.INSTANCE, WindowInsets.this)), ((Density) consume22).mo630toPx0680j_4(TopAppBarSmallTokens.INSTANCE.m3518getContainerHeightD9Ej5fM()) + ((topAppBarScrollBehavior2 == null || (state2 = topAppBarScrollBehavior2.getState()) == null) ? 0.0f : state2.getHeightOffset()), topAppBarColors.getNavigationIconContentColor(), topAppBarColors.getTitleContentColor(), topAppBarColors.getActionIconContentColor(), function2, textStyle, 1.0f, Arrangement.INSTANCE.getCenter(), z ? Arrangement.INSTANCE.getCenter() : Arrangement.INSTANCE.getStart(), 0, false, function22, composableLambda2, composer3, 113246208, 3126);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }), startRestartGroup, 12582912, Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE);
                        composer2 = startRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if ((i2 & 64) != 0) {
                    }
                    if ((i2 & 128) == 0) {
                    }
                    if ((i2 & 256) == 0) {
                    }
                    if ((38347923 & i3) == 38347922) {
                    }
                    if (i4 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ProvidableCompositionLocal<Density> localDensity22 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume22 = startRestartGroup.consume(localDensity22);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    final float f22 = -((Density) consume22).mo630toPx0680j_4(TopAppBarSmallTokens.INSTANCE.m3518getContainerHeightD9Ej5fM());
                    startRestartGroup.startReplaceableGroup(-1008351447);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AppBar.kt#9igjgp");
                    int i522 = i3 & 234881024;
                    changed = (i522 != 67108864) | startRestartGroup.changed(f22);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$1$1
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
                            TopAppBarState state2;
                            TopAppBarScrollBehavior topAppBarScrollBehavior2 = TopAppBarScrollBehavior.this;
                            if (Intrinsics.areEqual((topAppBarScrollBehavior2 == null || (state2 = topAppBarScrollBehavior2.getState()) == null) ? null : Float.valueOf(state2.getHeightOffsetLimit()), f22)) {
                                return;
                            }
                            TopAppBarScrollBehavior topAppBarScrollBehavior3 = TopAppBarScrollBehavior.this;
                            TopAppBarState state3 = topAppBarScrollBehavior3 != null ? topAppBarScrollBehavior3.getState() : null;
                            if (state3 == null) {
                                return;
                            }
                            state3.setHeightOffsetLimit(f22);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    startRestartGroup.endReplaceableGroup();
                    EffectsKt.SideEffect((Function0) rememberedValue, startRestartGroup, 0);
                    State<Color> m421animateColorAsStateeuL9pac22 = SingleValueAnimationKt.m421animateColorAsStateeuL9pac(topAppBarColors.m2929containerColorvNxB06k$material3_release(((topAppBarScrollBehavior != null || (state = topAppBarScrollBehavior.getState()) == null) ? 0.0f : state.getOverlappedFraction()) <= 0.01f ? 1.0f : 0.0f), AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null), null, null, startRestartGroup, 48, 12);
                    final Function2<? super Composer, ? super Integer, Unit> composableLambda22 = ComposableLambdaKt.composableLambda(startRestartGroup, 1520880938, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$actionsRow$1
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

                        public final void invoke(Composer composer3, int i6) {
                            ComposerKt.sourceInformation(composer3, "C1659@74390L157:AppBar.kt#uh7d8r");
                            if ((i6 & 3) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1520880938, i6, -1, "androidx.compose.material3.SingleRowTopAppBar.<anonymous> (AppBar.kt:1659)");
                                }
                                Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                                composer3.startReplaceableGroup(693286680);
                                ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                Modifier.Companion companion22 = Modifier.INSTANCE;
                                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(end, centerVertically, composer3, 54);
                                composer3.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion22);
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
                                function32.invoke(RowScopeInstance.INSTANCE, composer3, 6);
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
                    });
                    startRestartGroup.startReplaceableGroup(-1008350212);
                    ComposerKt.sourceInformation(startRestartGroup, "1670@74853L118,1670@74830L141,1673@75001L255");
                    if (topAppBarScrollBehavior == null) {
                    }
                    companion = Modifier.INSTANCE;
                    startRestartGroup.endReplaceableGroup();
                    SurfaceKt.m2633SurfaceT9BRK9s(modifier2.then(companion), null, SingleRowTopAppBar$lambda$7(m421animateColorAsStateeuL9pac22), 0L, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, 376925230, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$2
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

                        public final void invoke(Composer composer3, int i6) {
                            TopAppBarState state2;
                            ComposerKt.sourceInformation(composer3, "C*1691@75731L7,1695@75881L890:AppBar.kt#uh7d8r");
                            if ((i6 & 3) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(376925230, i6, -1, "androidx.compose.material3.SingleRowTopAppBar.<anonymous> (AppBar.kt:1691)");
                                }
                                ProvidableCompositionLocal<Density> localDensity222 = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume222 = composer3.consume(localDensity222);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                TopAppBarScrollBehavior topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                                AppBarKt.m1888TopAppBarLayoutkXwM9vE(ClipKt.clipToBounds(WindowInsetsPaddingKt.windowInsetsPadding(Modifier.INSTANCE, WindowInsets.this)), ((Density) consume222).mo630toPx0680j_4(TopAppBarSmallTokens.INSTANCE.m3518getContainerHeightD9Ej5fM()) + ((topAppBarScrollBehavior2 == null || (state2 = topAppBarScrollBehavior2.getState()) == null) ? 0.0f : state2.getHeightOffset()), topAppBarColors.getNavigationIconContentColor(), topAppBarColors.getTitleContentColor(), topAppBarColors.getActionIconContentColor(), function2, textStyle, 1.0f, Arrangement.INSTANCE.getCenter(), z ? Arrangement.INSTANCE.getCenter() : Arrangement.INSTANCE.getStart(), 0, false, function22, composableLambda22, composer3, 113246208, 3126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), startRestartGroup, 12582912, Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE);
                    composer2 = startRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                if ((i2 & 16) == 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if ((i2 & 64) != 0) {
                }
                if ((i2 & 128) == 0) {
                }
                if ((i2 & 256) == 0) {
                }
                if ((38347923 & i3) == 38347922) {
                }
                if (i4 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                ProvidableCompositionLocal<Density> localDensity222 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume222 = startRestartGroup.consume(localDensity222);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                final float f222 = -((Density) consume222).mo630toPx0680j_4(TopAppBarSmallTokens.INSTANCE.m3518getContainerHeightD9Ej5fM());
                startRestartGroup.startReplaceableGroup(-1008351447);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AppBar.kt#9igjgp");
                int i5222 = i3 & 234881024;
                changed = (i5222 != 67108864) | startRestartGroup.changed(f222);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$1$1
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
                        TopAppBarState state2;
                        TopAppBarScrollBehavior topAppBarScrollBehavior2 = TopAppBarScrollBehavior.this;
                        if (Intrinsics.areEqual((topAppBarScrollBehavior2 == null || (state2 = topAppBarScrollBehavior2.getState()) == null) ? null : Float.valueOf(state2.getHeightOffsetLimit()), f222)) {
                            return;
                        }
                        TopAppBarScrollBehavior topAppBarScrollBehavior3 = TopAppBarScrollBehavior.this;
                        TopAppBarState state3 = topAppBarScrollBehavior3 != null ? topAppBarScrollBehavior3.getState() : null;
                        if (state3 == null) {
                            return;
                        }
                        state3.setHeightOffsetLimit(f222);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
                startRestartGroup.endReplaceableGroup();
                EffectsKt.SideEffect((Function0) rememberedValue, startRestartGroup, 0);
                State<Color> m421animateColorAsStateeuL9pac222 = SingleValueAnimationKt.m421animateColorAsStateeuL9pac(topAppBarColors.m2929containerColorvNxB06k$material3_release(((topAppBarScrollBehavior != null || (state = topAppBarScrollBehavior.getState()) == null) ? 0.0f : state.getOverlappedFraction()) <= 0.01f ? 1.0f : 0.0f), AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null), null, null, startRestartGroup, 48, 12);
                final Function2<? super Composer, ? super Integer, Unit> composableLambda222 = ComposableLambdaKt.composableLambda(startRestartGroup, 1520880938, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$actionsRow$1
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

                    public final void invoke(Composer composer3, int i6) {
                        ComposerKt.sourceInformation(composer3, "C1659@74390L157:AppBar.kt#uh7d8r");
                        if ((i6 & 3) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1520880938, i6, -1, "androidx.compose.material3.SingleRowTopAppBar.<anonymous> (AppBar.kt:1659)");
                            }
                            Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                            Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                            composer3.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                            Modifier.Companion companion22 = Modifier.INSTANCE;
                            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(end, centerVertically, composer3, 54);
                            composer3.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion22);
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
                            function32.invoke(RowScopeInstance.INSTANCE, composer3, 6);
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
                });
                startRestartGroup.startReplaceableGroup(-1008350212);
                ComposerKt.sourceInformation(startRestartGroup, "1670@74853L118,1670@74830L141,1673@75001L255");
                if (topAppBarScrollBehavior == null) {
                }
                companion = Modifier.INSTANCE;
                startRestartGroup.endReplaceableGroup();
                SurfaceKt.m2633SurfaceT9BRK9s(modifier2.then(companion), null, SingleRowTopAppBar$lambda$7(m421animateColorAsStateeuL9pac222), 0L, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, 376925230, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$2
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

                    public final void invoke(Composer composer3, int i6) {
                        TopAppBarState state2;
                        ComposerKt.sourceInformation(composer3, "C*1691@75731L7,1695@75881L890:AppBar.kt#uh7d8r");
                        if ((i6 & 3) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(376925230, i6, -1, "androidx.compose.material3.SingleRowTopAppBar.<anonymous> (AppBar.kt:1691)");
                            }
                            ProvidableCompositionLocal<Density> localDensity2222 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume2222 = composer3.consume(localDensity2222);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            TopAppBarScrollBehavior topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                            AppBarKt.m1888TopAppBarLayoutkXwM9vE(ClipKt.clipToBounds(WindowInsetsPaddingKt.windowInsetsPadding(Modifier.INSTANCE, WindowInsets.this)), ((Density) consume2222).mo630toPx0680j_4(TopAppBarSmallTokens.INSTANCE.m3518getContainerHeightD9Ej5fM()) + ((topAppBarScrollBehavior2 == null || (state2 = topAppBarScrollBehavior2.getState()) == null) ? 0.0f : state2.getHeightOffset()), topAppBarColors.getNavigationIconContentColor(), topAppBarColors.getTitleContentColor(), topAppBarColors.getActionIconContentColor(), function2, textStyle, 1.0f, Arrangement.INSTANCE.getCenter(), z ? Arrangement.INSTANCE.getCenter() : Arrangement.INSTANCE.getStart(), 0, false, function22, composableLambda222, composer3, 113246208, 3126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), startRestartGroup, 12582912, Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE);
                composer2 = startRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            if ((i2 & 8) != 0) {
            }
            if ((i2 & 16) == 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if ((i2 & 64) != 0) {
            }
            if ((i2 & 128) == 0) {
            }
            if ((i2 & 256) == 0) {
            }
            if ((38347923 & i3) == 38347922) {
            }
            if (i4 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            ProvidableCompositionLocal<Density> localDensity2222 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2222 = startRestartGroup.consume(localDensity2222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final float f2222 = -((Density) consume2222).mo630toPx0680j_4(TopAppBarSmallTokens.INSTANCE.m3518getContainerHeightD9Ej5fM());
            startRestartGroup.startReplaceableGroup(-1008351447);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AppBar.kt#9igjgp");
            int i52222 = i3 & 234881024;
            changed = (i52222 != 67108864) | startRestartGroup.changed(f2222);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$1$1
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
                    TopAppBarState state2;
                    TopAppBarScrollBehavior topAppBarScrollBehavior2 = TopAppBarScrollBehavior.this;
                    if (Intrinsics.areEqual((topAppBarScrollBehavior2 == null || (state2 = topAppBarScrollBehavior2.getState()) == null) ? null : Float.valueOf(state2.getHeightOffsetLimit()), f2222)) {
                        return;
                    }
                    TopAppBarScrollBehavior topAppBarScrollBehavior3 = TopAppBarScrollBehavior.this;
                    TopAppBarState state3 = topAppBarScrollBehavior3 != null ? topAppBarScrollBehavior3.getState() : null;
                    if (state3 == null) {
                        return;
                    }
                    state3.setHeightOffsetLimit(f2222);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceableGroup();
            EffectsKt.SideEffect((Function0) rememberedValue, startRestartGroup, 0);
            State<Color> m421animateColorAsStateeuL9pac2222 = SingleValueAnimationKt.m421animateColorAsStateeuL9pac(topAppBarColors.m2929containerColorvNxB06k$material3_release(((topAppBarScrollBehavior != null || (state = topAppBarScrollBehavior.getState()) == null) ? 0.0f : state.getOverlappedFraction()) <= 0.01f ? 1.0f : 0.0f), AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null), null, null, startRestartGroup, 48, 12);
            final Function2<? super Composer, ? super Integer, Unit> composableLambda2222 = ComposableLambdaKt.composableLambda(startRestartGroup, 1520880938, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$actionsRow$1
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

                public final void invoke(Composer composer3, int i6) {
                    ComposerKt.sourceInformation(composer3, "C1659@74390L157:AppBar.kt#uh7d8r");
                    if ((i6 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1520880938, i6, -1, "androidx.compose.material3.SingleRowTopAppBar.<anonymous> (AppBar.kt:1659)");
                        }
                        Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                        composer3.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                        Modifier.Companion companion22 = Modifier.INSTANCE;
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(end, centerVertically, composer3, 54);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion22);
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
                        function32.invoke(RowScopeInstance.INSTANCE, composer3, 6);
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
            });
            startRestartGroup.startReplaceableGroup(-1008350212);
            ComposerKt.sourceInformation(startRestartGroup, "1670@74853L118,1670@74830L141,1673@75001L255");
            if (topAppBarScrollBehavior == null) {
            }
            companion = Modifier.INSTANCE;
            startRestartGroup.endReplaceableGroup();
            SurfaceKt.m2633SurfaceT9BRK9s(modifier2.then(companion), null, SingleRowTopAppBar$lambda$7(m421animateColorAsStateeuL9pac2222), 0L, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, 376925230, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$2
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

                public final void invoke(Composer composer3, int i6) {
                    TopAppBarState state2;
                    ComposerKt.sourceInformation(composer3, "C*1691@75731L7,1695@75881L890:AppBar.kt#uh7d8r");
                    if ((i6 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(376925230, i6, -1, "androidx.compose.material3.SingleRowTopAppBar.<anonymous> (AppBar.kt:1691)");
                        }
                        ProvidableCompositionLocal<Density> localDensity22222 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume22222 = composer3.consume(localDensity22222);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        TopAppBarScrollBehavior topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                        AppBarKt.m1888TopAppBarLayoutkXwM9vE(ClipKt.clipToBounds(WindowInsetsPaddingKt.windowInsetsPadding(Modifier.INSTANCE, WindowInsets.this)), ((Density) consume22222).mo630toPx0680j_4(TopAppBarSmallTokens.INSTANCE.m3518getContainerHeightD9Ej5fM()) + ((topAppBarScrollBehavior2 == null || (state2 = topAppBarScrollBehavior2.getState()) == null) ? 0.0f : state2.getHeightOffset()), topAppBarColors.getNavigationIconContentColor(), topAppBarColors.getTitleContentColor(), topAppBarColors.getActionIconContentColor(), function2, textStyle, 1.0f, Arrangement.INSTANCE.getCenter(), z ? Arrangement.INSTANCE.getCenter() : Arrangement.INSTANCE.getStart(), 0, false, function22, composableLambda2222, composer3, 113246208, 3126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), startRestartGroup, 12582912, Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE);
            composer2 = startRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        if ((i2 & 4) == 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if ((i2 & 16) == 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if ((i2 & 128) == 0) {
        }
        if ((i2 & 256) == 0) {
        }
        if ((38347923 & i3) == 38347922) {
        }
        if (i4 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        ProvidableCompositionLocal<Density> localDensity22222 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume22222 = startRestartGroup.consume(localDensity22222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        final float f22222 = -((Density) consume22222).mo630toPx0680j_4(TopAppBarSmallTokens.INSTANCE.m3518getContainerHeightD9Ej5fM());
        startRestartGroup.startReplaceableGroup(-1008351447);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AppBar.kt#9igjgp");
        int i522222 = i3 & 234881024;
        changed = (i522222 != 67108864) | startRestartGroup.changed(f22222);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$1$1
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
                TopAppBarState state2;
                TopAppBarScrollBehavior topAppBarScrollBehavior2 = TopAppBarScrollBehavior.this;
                if (Intrinsics.areEqual((topAppBarScrollBehavior2 == null || (state2 = topAppBarScrollBehavior2.getState()) == null) ? null : Float.valueOf(state2.getHeightOffsetLimit()), f22222)) {
                    return;
                }
                TopAppBarScrollBehavior topAppBarScrollBehavior3 = TopAppBarScrollBehavior.this;
                TopAppBarState state3 = topAppBarScrollBehavior3 != null ? topAppBarScrollBehavior3.getState() : null;
                if (state3 == null) {
                    return;
                }
                state3.setHeightOffsetLimit(f22222);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceableGroup();
        EffectsKt.SideEffect((Function0) rememberedValue, startRestartGroup, 0);
        State<Color> m421animateColorAsStateeuL9pac22222 = SingleValueAnimationKt.m421animateColorAsStateeuL9pac(topAppBarColors.m2929containerColorvNxB06k$material3_release(((topAppBarScrollBehavior != null || (state = topAppBarScrollBehavior.getState()) == null) ? 0.0f : state.getOverlappedFraction()) <= 0.01f ? 1.0f : 0.0f), AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null), null, null, startRestartGroup, 48, 12);
        final Function2<? super Composer, ? super Integer, Unit> composableLambda22222 = ComposableLambdaKt.composableLambda(startRestartGroup, 1520880938, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$actionsRow$1
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

            public final void invoke(Composer composer3, int i6) {
                ComposerKt.sourceInformation(composer3, "C1659@74390L157:AppBar.kt#uh7d8r");
                if ((i6 & 3) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1520880938, i6, -1, "androidx.compose.material3.SingleRowTopAppBar.<anonymous> (AppBar.kt:1659)");
                    }
                    Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                    composer3.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    Modifier.Companion companion22 = Modifier.INSTANCE;
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(end, centerVertically, composer3, 54);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion22);
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
                    function32.invoke(RowScopeInstance.INSTANCE, composer3, 6);
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
        });
        startRestartGroup.startReplaceableGroup(-1008350212);
        ComposerKt.sourceInformation(startRestartGroup, "1670@74853L118,1670@74830L141,1673@75001L255");
        if (topAppBarScrollBehavior == null) {
        }
        companion = Modifier.INSTANCE;
        startRestartGroup.endReplaceableGroup();
        SurfaceKt.m2633SurfaceT9BRK9s(modifier2.then(companion), null, SingleRowTopAppBar$lambda$7(m421animateColorAsStateeuL9pac22222), 0L, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, 376925230, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$2
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

            public final void invoke(Composer composer3, int i6) {
                TopAppBarState state2;
                ComposerKt.sourceInformation(composer3, "C*1691@75731L7,1695@75881L890:AppBar.kt#uh7d8r");
                if ((i6 & 3) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(376925230, i6, -1, "androidx.compose.material3.SingleRowTopAppBar.<anonymous> (AppBar.kt:1691)");
                    }
                    ProvidableCompositionLocal<Density> localDensity222222 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume222222 = composer3.consume(localDensity222222);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    TopAppBarScrollBehavior topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                    AppBarKt.m1888TopAppBarLayoutkXwM9vE(ClipKt.clipToBounds(WindowInsetsPaddingKt.windowInsetsPadding(Modifier.INSTANCE, WindowInsets.this)), ((Density) consume222222).mo630toPx0680j_4(TopAppBarSmallTokens.INSTANCE.m3518getContainerHeightD9Ej5fM()) + ((topAppBarScrollBehavior2 == null || (state2 = topAppBarScrollBehavior2.getState()) == null) ? 0.0f : state2.getHeightOffset()), topAppBarColors.getNavigationIconContentColor(), topAppBarColors.getTitleContentColor(), topAppBarColors.getActionIconContentColor(), function2, textStyle, 1.0f, Arrangement.INSTANCE.getCenter(), z ? Arrangement.INSTANCE.getCenter() : Arrangement.INSTANCE.getStart(), 0, false, function22, composableLambda22222, composer3, 113246208, 3126);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }), startRestartGroup, 12582912, Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE);
        composer2 = startRestartGroup;
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01c2  */
    /* renamed from: TwoRowsTopAppBar-tjU4iQQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1889TwoRowsTopAppBartjU4iQQ(Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle textStyle, final float f, final Function2<? super Composer, ? super Integer, Unit> function22, final TextStyle textStyle2, final Function2<? super Composer, ? super Integer, Unit> function23, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, final WindowInsets windowInsets, final TopAppBarColors topAppBarColors, final float f2, final float f3, final TopAppBarScrollBehavior topAppBarScrollBehavior, Composer composer, final int i, final int i2, final int i3) {
        Modifier modifier2;
        int i4;
        TextStyle textStyle3;
        int i5;
        int i6;
        Modifier.Companion companion;
        Composer composer2;
        final Modifier modifier3;
        TopAppBarState state;
        Composer startRestartGroup = composer.startRestartGroup(210227552);
        ComposerKt.sourceInformation(startRestartGroup, "C(TwoRowsTopAppBar)P(3,9,11,10:c#ui.unit.Dp,7,8,4!1,12!1,2:c#ui.unit.Dp,5:c#ui.unit.Dp)*1750@77824L7,1758@78137L189,1758@78126L200,1807@80298L2301:AppBar.kt#uh7d8r");
        int i7 = i3 & 1;
        if (i7 != 0) {
            i4 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i4 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 384) == 0) {
            textStyle3 = textStyle;
            i4 |= startRestartGroup.changed(textStyle3) ? 256 : 128;
            if ((i3 & 8) == 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                i4 |= startRestartGroup.changed(f) ? 2048 : 1024;
            }
            if ((i3 & 16) == 0) {
                i4 |= 24576;
            } else if ((i & 24576) == 0) {
                i4 |= startRestartGroup.changedInstance(function22) ? 16384 : 8192;
                if ((i3 & 32) != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    i4 |= startRestartGroup.changed(textStyle2) ? 131072 : 65536;
                }
                if ((i3 & 64) != 0) {
                    i4 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    i4 |= startRestartGroup.changedInstance(function23) ? 1048576 : 524288;
                }
                if ((i3 & 128) != 0) {
                    i4 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    i4 |= startRestartGroup.changedInstance(function3) ? 8388608 : 4194304;
                }
                if ((i3 & 256) != 0) {
                    i4 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    i4 |= startRestartGroup.changed(windowInsets) ? 67108864 : 33554432;
                    if ((i3 & 512) == 0) {
                        i4 |= C.ENCODING_PCM_32BIT;
                    } else if ((i & C.ENCODING_PCM_32BIT) == 0) {
                        i4 |= startRestartGroup.changed(topAppBarColors) ? 536870912 : 268435456;
                    }
                    if ((i3 & 1024) == 0) {
                        i5 = i2 | 6;
                    } else if ((i2 & 6) == 0) {
                        i5 = i2 | (startRestartGroup.changed(f2) ? 4 : 2);
                    } else {
                        i5 = i2;
                    }
                    int i8 = i5;
                    if ((i3 & 2048) == 0) {
                        i6 = i8 | 48;
                    } else if ((i2 & 48) == 0) {
                        i6 = i8 | (startRestartGroup.changed(f3) ? 32 : 16);
                    } else {
                        i6 = i8;
                    }
                    if ((i3 & 4096) == 0) {
                        i6 |= 384;
                    } else if ((i2 & 384) == 0) {
                        i6 |= startRestartGroup.changed(topAppBarScrollBehavior) ? 256 : 128;
                    }
                    if ((306783379 & i4) == 306783378 || (i6 & 147) != 146 || !startRestartGroup.getSkipping()) {
                        Modifier.Companion companion2 = i7 == 0 ? Modifier.INSTANCE : modifier2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(210227552, i4, i6, "androidx.compose.material3.TwoRowsTopAppBar (AppBar.kt:1741)");
                        }
                        if (Dp.m6388compareTo0680j_4(f2, f3) > 0) {
                            throw new IllegalArgumentException("A TwoRowsTopAppBar max height should be greater than its pinned height");
                        }
                        final Ref.FloatRef floatRef = new Ref.FloatRef();
                        final Ref.FloatRef floatRef2 = new Ref.FloatRef();
                        final Ref.IntRef intRef = new Ref.IntRef();
                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume = startRestartGroup.consume(localDensity);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        Density density = (Density) consume;
                        floatRef.element = density.mo630toPx0680j_4(f3);
                        floatRef2.element = density.mo630toPx0680j_4(f2);
                        intRef.element = density.mo624roundToPx0680j_4(f);
                        startRestartGroup.startReplaceableGroup(-1609641260);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AppBar.kt#9igjgp");
                        int i9 = i6 & 896;
                        boolean changed = startRestartGroup.changed(floatRef.element) | (i9 == 256) | startRestartGroup.changed(floatRef2.element);
                        Object rememberedValue = startRestartGroup.rememberedValue();
                        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$2$1
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
                                    TopAppBarState state2;
                                    TopAppBarScrollBehavior topAppBarScrollBehavior2 = TopAppBarScrollBehavior.this;
                                    if (Intrinsics.areEqual((topAppBarScrollBehavior2 == null || (state2 = topAppBarScrollBehavior2.getState()) == null) ? null : Float.valueOf(state2.getHeightOffsetLimit()), floatRef.element - floatRef2.element)) {
                                        return;
                                    }
                                    TopAppBarScrollBehavior topAppBarScrollBehavior3 = TopAppBarScrollBehavior.this;
                                    TopAppBarState state3 = topAppBarScrollBehavior3 != null ? topAppBarScrollBehavior3.getState() : null;
                                    if (state3 == null) {
                                        return;
                                    }
                                    state3.setHeightOffsetLimit(floatRef.element - floatRef2.element);
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        startRestartGroup.endReplaceableGroup();
                        EffectsKt.SideEffect((Function0) rememberedValue, startRestartGroup, 0);
                        float collapsedFraction = (topAppBarScrollBehavior == null || (state = topAppBarScrollBehavior.getState()) == null) ? 0.0f : state.getCollapsedFraction();
                        long m2929containerColorvNxB06k$material3_release = topAppBarColors.m2929containerColorvNxB06k$material3_release(collapsedFraction);
                        final ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, -1048401111, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$actionsRow$1
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
                                ComposerKt.sourceInformation(composer3, "C1774@78959L157:AppBar.kt#uh7d8r");
                                if ((i10 & 3) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1048401111, i10, -1, "androidx.compose.material3.TwoRowsTopAppBar.<anonymous> (AppBar.kt:1774)");
                                    }
                                    Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                    Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                                    composer3.startReplaceableGroup(693286680);
                                    ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                    Modifier.Companion companion3 = Modifier.INSTANCE;
                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(end, centerVertically, composer3, 54);
                                    composer3.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion3);
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
                                    function32.invoke(RowScopeInstance.INSTANCE, composer3, 6);
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
                        });
                        final float transform = TopTitleAlphaEasing.transform(collapsedFraction);
                        final float f4 = 1.0f - collapsedFraction;
                        boolean z = collapsedFraction < 0.5f;
                        final boolean z2 = !z;
                        startRestartGroup.startReplaceableGroup(-1609639731);
                        ComposerKt.sourceInformation(startRestartGroup, "1791@79843L118,1791@79820L141,1794@79991L255");
                        if (topAppBarScrollBehavior != null && !topAppBarScrollBehavior.getIsPinned()) {
                            Modifier.Companion companion3 = Modifier.INSTANCE;
                            Orientation orientation = Orientation.Vertical;
                            startRestartGroup.startReplaceableGroup(-1609639554);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AppBar.kt#9igjgp");
                            boolean z3 = i9 == 256;
                            Object rememberedValue2 = startRestartGroup.rememberedValue();
                            if (z3 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue2 = (Function1) new Function1<Float, Unit>() { // from class: androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$appBarDragModifier$1$1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Float f5) {
                                        invoke(f5.floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(float f5) {
                                        TopAppBarScrollBehavior.this.getState().setHeightOffset(TopAppBarScrollBehavior.this.getState().getHeightOffset() + f5);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue2);
                            }
                            startRestartGroup.endReplaceableGroup();
                            DraggableState rememberDraggableState = DraggableKt.rememberDraggableState((Function1) rememberedValue2, startRestartGroup, 0);
                            Modifier.Companion companion4 = companion3;
                            startRestartGroup.startReplaceableGroup(-1609639406);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AppBar.kt#9igjgp");
                            boolean z4 = i9 == 256;
                            AppBarKt$TwoRowsTopAppBar$appBarDragModifier$2$1 rememberedValue3 = startRestartGroup.rememberedValue();
                            if (z4 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue3 = new AppBarKt$TwoRowsTopAppBar$appBarDragModifier$2$1(topAppBarScrollBehavior, null);
                                startRestartGroup.updateRememberedValue(rememberedValue3);
                            }
                            startRestartGroup.endReplaceableGroup();
                            companion = DraggableKt.draggable$default(companion4, rememberDraggableState, orientation, false, null, false, null, (Function3) rememberedValue3, false, 188, null);
                        } else {
                            companion = Modifier.INSTANCE;
                        }
                        startRestartGroup.endReplaceableGroup();
                        final TextStyle textStyle4 = textStyle3;
                        final boolean z5 = z;
                        composer2 = startRestartGroup;
                        SurfaceKt.m2633SurfaceT9BRK9s(companion2.then(companion), null, m2929containerColorvNxB06k$material3_release, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1985938853, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$3
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
                                TopAppBarState state2;
                                ComposerKt.sourceInformation(composer3, "C1808@80392L2201:AppBar.kt#uh7d8r");
                                if ((i10 & 3) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1985938853, i10, -1, "androidx.compose.material3.TwoRowsTopAppBar.<anonymous> (AppBar.kt:1808)");
                                    }
                                    WindowInsets windowInsets2 = WindowInsets.this;
                                    Ref.FloatRef floatRef3 = floatRef;
                                    TopAppBarColors topAppBarColors2 = topAppBarColors;
                                    Function2<Composer, Integer, Unit> function24 = function22;
                                    TextStyle textStyle5 = textStyle2;
                                    float f5 = transform;
                                    boolean z6 = z5;
                                    Function2<Composer, Integer, Unit> function25 = function23;
                                    Function2<Composer, Integer, Unit> function26 = composableLambda;
                                    Ref.FloatRef floatRef4 = floatRef2;
                                    TopAppBarScrollBehavior topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                                    Function2<Composer, Integer, Unit> function27 = function2;
                                    TextStyle textStyle6 = textStyle4;
                                    float f6 = f4;
                                    Ref.IntRef intRef2 = intRef;
                                    boolean z7 = z2;
                                    composer3.startReplaceableGroup(-483455358);
                                    ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                    Modifier.Companion companion5 = Modifier.INSTANCE;
                                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                    composer3.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion5);
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
                                    ComposerKt.sourceInformationMarkerStart(composer3, 1863931258, "C1809@80413L982,1830@81408L1175:AppBar.kt#uh7d8r");
                                    AppBarKt.m1888TopAppBarLayoutkXwM9vE(ClipKt.clipToBounds(WindowInsetsPaddingKt.windowInsetsPadding(Modifier.INSTANCE, windowInsets2)), floatRef3.element, topAppBarColors2.getNavigationIconContentColor(), topAppBarColors2.getTitleContentColor(), topAppBarColors2.getActionIconContentColor(), function24, textStyle5, f5, Arrangement.INSTANCE.getCenter(), Arrangement.INSTANCE.getStart(), 0, z6, function25, function26, composer3, 905969664, 3078);
                                    AppBarKt.m1888TopAppBarLayoutkXwM9vE(ClipKt.clipToBounds(WindowInsetsPaddingKt.windowInsetsPadding(Modifier.INSTANCE, WindowInsetsKt.m954onlybOOhFvg(windowInsets2, WindowInsetsSides.INSTANCE.m975getHorizontalJoeWqyM()))), ((topAppBarScrollBehavior2 == null || (state2 = topAppBarScrollBehavior2.getState()) == null) ? 0.0f : state2.getHeightOffset()) + (floatRef4.element - floatRef3.element), topAppBarColors2.getNavigationIconContentColor(), topAppBarColors2.getTitleContentColor(), topAppBarColors2.getActionIconContentColor(), function27, textStyle6, f6, Arrangement.INSTANCE.getBottom(), Arrangement.INSTANCE.getStart(), intRef2.element, z7, ComposableSingletons$AppBarKt.INSTANCE.m2061getLambda11$material3_release(), ComposableSingletons$AppBarKt.INSTANCE.m2062getLambda12$material3_release(), composer3, 905969664, 3456);
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
                        }), composer2, 12582912, Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = companion2;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        composer2 = startRestartGroup;
                        modifier3 = modifier2;
                    }
                    ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$4
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
                                AppBarKt.m1889TwoRowsTopAppBartjU4iQQ(Modifier.this, function2, textStyle, f, function22, textStyle2, function23, function3, windowInsets, topAppBarColors, f2, f3, topAppBarScrollBehavior, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                            }
                        });
                        return;
                    }
                    return;
                }
                if ((i3 & 512) == 0) {
                }
                if ((i3 & 1024) == 0) {
                }
                int i82 = i5;
                if ((i3 & 2048) == 0) {
                }
                if ((i3 & 4096) == 0) {
                }
                if ((306783379 & i4) == 306783378) {
                }
                if (i7 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                if (Dp.m6388compareTo0680j_4(f2, f3) > 0) {
                }
            }
            if ((i3 & 32) != 0) {
            }
            if ((i3 & 64) != 0) {
            }
            if ((i3 & 128) != 0) {
            }
            if ((i3 & 256) != 0) {
            }
            if ((i3 & 512) == 0) {
            }
            if ((i3 & 1024) == 0) {
            }
            int i822 = i5;
            if ((i3 & 2048) == 0) {
            }
            if ((i3 & 4096) == 0) {
            }
            if ((306783379 & i4) == 306783378) {
            }
            if (i7 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            if (Dp.m6388compareTo0680j_4(f2, f3) > 0) {
            }
        }
        textStyle3 = textStyle;
        if ((i3 & 8) == 0) {
        }
        if ((i3 & 16) == 0) {
        }
        if ((i3 & 32) != 0) {
        }
        if ((i3 & 64) != 0) {
        }
        if ((i3 & 128) != 0) {
        }
        if ((i3 & 256) != 0) {
        }
        if ((i3 & 512) == 0) {
        }
        if ((i3 & 1024) == 0) {
        }
        int i8222 = i5;
        if ((i3 & 2048) == 0) {
        }
        if ((i3 & 4096) == 0) {
        }
        if ((306783379 & i4) == 306783378) {
        }
        if (i7 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        if (Dp.m6388compareTo0680j_4(f2, f3) > 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: TopAppBarLayout-kXwM9vE, reason: not valid java name */
    public static final void m1888TopAppBarLayoutkXwM9vE(final Modifier modifier, final float f, final long j, final long j2, final long j3, final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle textStyle, final float f2, final Arrangement.Vertical vertical, final Arrangement.Horizontal horizontal, final int i, final boolean z, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, Composer composer, final int i2, final int i3) {
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(-6794037);
        ComposerKt.sourceInformation(startRestartGroup, "C(TopAppBarLayout)P(4,2,6:c#ui.graphics.Color,10:c#ui.graphics.Color,0:c#ui.graphics.Color,7,12,8,13,11,9,3,5)1936@85940L4001,1900@84643L5298:AppBar.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changed(modifier) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= startRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= startRestartGroup.changed(j) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= startRestartGroup.changed(j2) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= startRestartGroup.changed(j3) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            function24 = function2;
            i4 |= startRestartGroup.changedInstance(function24) ? 131072 : 65536;
        } else {
            function24 = function2;
        }
        if ((i2 & 1572864) == 0) {
            i4 |= startRestartGroup.changed(textStyle) ? 1048576 : 524288;
        }
        if ((i2 & 12582912) == 0) {
            i4 |= startRestartGroup.changed(f2) ? 8388608 : 4194304;
        }
        if ((i2 & 100663296) == 0) {
            i4 |= startRestartGroup.changed(vertical) ? 67108864 : 33554432;
        }
        if ((i2 & C.ENCODING_PCM_32BIT) == 0) {
            i4 |= startRestartGroup.changed(horizontal) ? 536870912 : 268435456;
        }
        if ((i3 & 6) == 0) {
            i5 = i3 | (startRestartGroup.changed(i) ? 4 : 2);
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= startRestartGroup.changedInstance(function22) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i5 |= startRestartGroup.changedInstance(function23) ? 2048 : 1024;
        }
        int i6 = i5;
        if ((i4 & 306783379) != 306783378 || (i6 & 1171) != 1170 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-6794037, i4, i6, "androidx.compose.material3.TopAppBarLayout (AppBar.kt:1899)");
            }
            startRestartGroup.startReplaceableGroup(1019460550);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AppBar.kt#9igjgp");
            boolean z2 = ((i4 & 112) == 32) | ((1879048192 & i4) == 536870912) | ((234881024 & i4) == 67108864) | ((i6 & 14) == 4);
            MeasurePolicy rememberedValue = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new MeasurePolicy() { // from class: androidx.compose.material3.AppBarKt$TopAppBarLayout$2$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo355measure3p2s80s(final MeasureScope measureScope, List<? extends Measurable> list, final long j4) {
                        int coerceAtLeast;
                        int size = list.size();
                        for (int i7 = 0; i7 < size; i7++) {
                            Measurable measurable = list.get(i7);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "navigationIcon")) {
                                final Placeable mo5333measureBRTryo0 = measurable.mo5333measureBRTryo0(Constraints.m6336copyZbe2FdA$default(j4, 0, 0, 0, 0, 14, null));
                                int size2 = list.size();
                                for (int i8 = 0; i8 < size2; i8++) {
                                    Measurable measurable2 = list.get(i8);
                                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "actionIcons")) {
                                        final Placeable mo5333measureBRTryo02 = measurable2.mo5333measureBRTryo0(Constraints.m6336copyZbe2FdA$default(j4, 0, 0, 0, 0, 14, null));
                                        if (Constraints.m6345getMaxWidthimpl(j4) == Integer.MAX_VALUE) {
                                            coerceAtLeast = Constraints.m6345getMaxWidthimpl(j4);
                                        } else {
                                            coerceAtLeast = RangesKt.coerceAtLeast((Constraints.m6345getMaxWidthimpl(j4) - mo5333measureBRTryo0.getWidth()) - mo5333measureBRTryo02.getWidth(), 0);
                                        }
                                        int i9 = coerceAtLeast;
                                        int size3 = list.size();
                                        for (int i10 = 0; i10 < size3; i10++) {
                                            Measurable measurable3 = list.get(i10);
                                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), "title")) {
                                                final Placeable mo5333measureBRTryo03 = measurable3.mo5333measureBRTryo0(Constraints.m6336copyZbe2FdA$default(j4, 0, i9, 0, 0, 12, null));
                                                final int i11 = mo5333measureBRTryo03.get(AlignmentLineKt.getLastBaseline()) != Integer.MIN_VALUE ? mo5333measureBRTryo03.get(AlignmentLineKt.getLastBaseline()) : 0;
                                                final int roundToInt = Float.isNaN(f) ? 0 : MathKt.roundToInt(f);
                                                int m6345getMaxWidthimpl = Constraints.m6345getMaxWidthimpl(j4);
                                                final Arrangement.Horizontal horizontal2 = horizontal;
                                                final Arrangement.Vertical vertical2 = vertical;
                                                final int i12 = i;
                                                return MeasureScope.layout$default(measureScope, m6345getMaxWidthimpl, roundToInt, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.AppBarKt$TopAppBarLayout$2$1.1
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
                                                        float f3;
                                                        int max;
                                                        int i13;
                                                        int height;
                                                        int max2;
                                                        int i14;
                                                        int m6345getMaxWidthimpl2;
                                                        Placeable placeable = Placeable.this;
                                                        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, (roundToInt - placeable.getHeight()) / 2, 0.0f, 4, null);
                                                        Placeable placeable2 = mo5333measureBRTryo03;
                                                        Arrangement.Horizontal horizontal3 = horizontal2;
                                                        if (Intrinsics.areEqual(horizontal3, Arrangement.INSTANCE.getCenter())) {
                                                            max = (Constraints.m6345getMaxWidthimpl(j4) - mo5333measureBRTryo03.getWidth()) / 2;
                                                            if (max < Placeable.this.getWidth()) {
                                                                m6345getMaxWidthimpl2 = Placeable.this.getWidth() - max;
                                                            } else if (mo5333measureBRTryo03.getWidth() + max > Constraints.m6345getMaxWidthimpl(j4) - mo5333measureBRTryo02.getWidth()) {
                                                                m6345getMaxWidthimpl2 = (Constraints.m6345getMaxWidthimpl(j4) - mo5333measureBRTryo02.getWidth()) - (mo5333measureBRTryo03.getWidth() + max);
                                                            }
                                                            max += m6345getMaxWidthimpl2;
                                                        } else if (Intrinsics.areEqual(horizontal3, Arrangement.INSTANCE.getEnd())) {
                                                            max = (Constraints.m6345getMaxWidthimpl(j4) - mo5333measureBRTryo03.getWidth()) - mo5333measureBRTryo02.getWidth();
                                                        } else {
                                                            MeasureScope measureScope2 = measureScope;
                                                            f3 = AppBarKt.TopAppBarTitleInset;
                                                            max = Math.max(measureScope2.mo624roundToPx0680j_4(f3), Placeable.this.getWidth());
                                                        }
                                                        int i15 = max;
                                                        Arrangement.Vertical vertical3 = vertical2;
                                                        if (Intrinsics.areEqual(vertical3, Arrangement.INSTANCE.getCenter())) {
                                                            i14 = (roundToInt - mo5333measureBRTryo03.getHeight()) / 2;
                                                        } else if (!Intrinsics.areEqual(vertical3, Arrangement.INSTANCE.getBottom())) {
                                                            i13 = 0;
                                                            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i15, i13, 0.0f, 4, null);
                                                            Placeable.PlacementScope.placeRelative$default(placementScope, mo5333measureBRTryo02, Constraints.m6345getMaxWidthimpl(j4) - mo5333measureBRTryo02.getWidth(), (roundToInt - mo5333measureBRTryo02.getHeight()) / 2, 0.0f, 4, null);
                                                        } else {
                                                            if (i12 == 0) {
                                                                height = roundToInt;
                                                                max2 = mo5333measureBRTryo03.getHeight();
                                                            } else {
                                                                height = roundToInt - mo5333measureBRTryo03.getHeight();
                                                                max2 = Math.max(0, (i12 - mo5333measureBRTryo03.getHeight()) + i11);
                                                            }
                                                            i14 = height - max2;
                                                        }
                                                        i13 = i14;
                                                        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i15, i13, 0.0f, 4, null);
                                                        Placeable.PlacementScope.placeRelative$default(placementScope, mo5333measureBRTryo02, Constraints.m6345getMaxWidthimpl(j4) - mo5333measureBRTryo02.getWidth(), (roundToInt - mo5333measureBRTryo02.getHeight()) / 2, 0.0f, 4, null);
                                                    }
                                                }, 4, null);
                                            }
                                        }
                                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                                    }
                                }
                                throw new NoSuchElementException("Collection contains no element matching the predicate.");
                            }
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
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -290509324, "C1902@84673L352,1912@85038L507,1924@85558L336:AppBar.kt#uh7d8r");
            Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "navigationIcon");
            float f3 = TopAppBarHorizontalPadding;
            Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(layoutId, f3, 0.0f, 0.0f, 0.0f, 14, null);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
            int i7 = i4;
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1090257852, "C1907@84848L163:AppBar.kt#uh7d8r");
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(j)), function22, startRestartGroup, ProvidedValue.$stable | ((i6 >> 3) & 112));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            Modifier m881paddingVpY3zN4$default = PaddingKt.m881paddingVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, "title"), f3, 0.0f, 2, null);
            Modifier.Companion companion = Modifier.INSTANCE;
            if (z) {
                companion = SemanticsModifierKt.clearAndSetSemantics(companion, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.AppBarKt$TopAppBarLayout$1$2
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }
                });
            }
            Modifier m4224graphicsLayerAp8cVGQ$default = GraphicsLayerModifierKt.m4224graphicsLayerAp8cVGQ$default(m881paddingVpY3zN4$default.then(companion), 0.0f, 0.0f, f2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131067, null);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(m4224graphicsLayerAp8cVGQ$default);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1090257337, "C1919@85363L168:AppBar.kt#uh7d8r");
            int i8 = i7 >> 9;
            ProvideContentColorTextStyleKt.m2420ProvideContentColorTextStyle3JVO9M(j2, textStyle, function24, startRestartGroup, (i8 & 896) | (i8 & 14) | ((i7 >> 15) & 112));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            Modifier m883paddingqDBjuR0$default2 = PaddingKt.m883paddingqDBjuR0$default(LayoutIdKt.layoutId(Modifier.INSTANCE, "actionIcons"), 0.0f, 0.0f, f3, 0.0f, 11, null);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default2);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1090256972, "C1929@85728L152:AppBar.kt#uh7d8r");
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(j3)), function23, startRestartGroup, ProvidedValue.$stable | ((i6 >> 6) & 112));
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
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$TopAppBarLayout$3
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
                    AppBarKt.m1888TopAppBarLayoutkXwM9vE(Modifier.this, f, j, j2, j3, function2, textStyle, f2, vertical, horizontal, i, z, function22, function23, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00af, code lost:
    
        if (androidx.compose.animation.core.SuspendAnimationKt.animateDecay$default(r5, r23, false, r6, r7, 2, null) == r2) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object settleAppBar(TopAppBarState topAppBarState, float f, DecayAnimationSpec<Float> decayAnimationSpec, AnimationSpec<Float> animationSpec, Continuation<? super Velocity> continuation) {
        AppBarKt$settleAppBar$1 appBarKt$settleAppBar$1;
        AppBarKt$settleAppBar$1 appBarKt$settleAppBar$12;
        Object coroutine_suspended;
        int i;
        final Ref.FloatRef floatRef;
        AnimationSpec<Float> animationSpec2;
        AnimationSpec<Float> animationSpec3;
        AnimationState AnimationState$default;
        Float boxFloat;
        Function1<AnimationScope<Float, AnimationVector1D>, Unit> function1;
        Ref.FloatRef floatRef2;
        final TopAppBarState topAppBarState2 = topAppBarState;
        if (continuation instanceof AppBarKt$settleAppBar$1) {
            appBarKt$settleAppBar$1 = (AppBarKt$settleAppBar$1) continuation;
            if ((appBarKt$settleAppBar$1.label & Integer.MIN_VALUE) != 0) {
                appBarKt$settleAppBar$1.label -= Integer.MIN_VALUE;
                appBarKt$settleAppBar$12 = appBarKt$settleAppBar$1;
                Object obj = appBarKt$settleAppBar$12.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = appBarKt$settleAppBar$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (topAppBarState2.getCollapsedFraction() < 0.01f || topAppBarState2.getCollapsedFraction() == 1.0f) {
                        return Velocity.m6615boximpl(Velocity.INSTANCE.m6635getZero9UxMQ8M());
                    }
                    floatRef = new Ref.FloatRef();
                    floatRef.element = f;
                    if (decayAnimationSpec == null || Math.abs(f) <= 1.0f) {
                        animationSpec2 = animationSpec;
                    } else {
                        final Ref.FloatRef floatRef3 = new Ref.FloatRef();
                        AnimationState AnimationState$default2 = AnimationStateKt.AnimationState$default(0.0f, f, 0L, 0L, false, 28, null);
                        Function1<AnimationScope<Float, AnimationVector1D>, Unit> function12 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.material3.AppBarKt$settleAppBar$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                                invoke2(animationScope);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(AnimationScope<Float, AnimationVector1D> animationScope) {
                                float floatValue = animationScope.getValue().floatValue() - Ref.FloatRef.this.element;
                                float heightOffset = topAppBarState2.getHeightOffset();
                                topAppBarState2.setHeightOffset(heightOffset + floatValue);
                                float abs = Math.abs(heightOffset - topAppBarState2.getHeightOffset());
                                Ref.FloatRef.this.element = animationScope.getValue().floatValue();
                                floatRef.element = animationScope.getVelocity().floatValue();
                                if (Math.abs(floatValue - abs) > 0.5f) {
                                    animationScope.cancelAnimation();
                                }
                            }
                        };
                        appBarKt$settleAppBar$12.L$0 = topAppBarState2;
                        animationSpec2 = animationSpec;
                        appBarKt$settleAppBar$12.L$1 = animationSpec2;
                        appBarKt$settleAppBar$12.L$2 = floatRef;
                        appBarKt$settleAppBar$12.label = 1;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        floatRef2 = (Ref.FloatRef) appBarKt$settleAppBar$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        floatRef = floatRef2;
                        return Velocity.m6615boximpl(VelocityKt.Velocity(0.0f, floatRef.element));
                    }
                    Ref.FloatRef floatRef4 = (Ref.FloatRef) appBarKt$settleAppBar$12.L$2;
                    AnimationSpec<Float> animationSpec4 = (AnimationSpec) appBarKt$settleAppBar$12.L$1;
                    TopAppBarState topAppBarState3 = (TopAppBarState) appBarKt$settleAppBar$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    floatRef = floatRef4;
                    animationSpec2 = animationSpec4;
                    topAppBarState2 = topAppBarState3;
                }
                animationSpec3 = animationSpec2;
                if (animationSpec3 != null && topAppBarState2.getHeightOffset() < 0.0f && topAppBarState2.getHeightOffset() > topAppBarState2.getHeightOffsetLimit()) {
                    AnimationState$default = AnimationStateKt.AnimationState$default(topAppBarState2.getHeightOffset(), 0.0f, 0L, 0L, false, 30, null);
                    boxFloat = Boxing.boxFloat(topAppBarState2.getCollapsedFraction() >= 0.5f ? 0.0f : topAppBarState2.getHeightOffsetLimit());
                    function1 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.material3.AppBarKt$settleAppBar$3
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                            invoke2(animationScope);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(AnimationScope<Float, AnimationVector1D> animationScope) {
                            TopAppBarState.this.setHeightOffset(animationScope.getValue().floatValue());
                        }
                    };
                    appBarKt$settleAppBar$12.L$0 = floatRef;
                    appBarKt$settleAppBar$12.L$1 = null;
                    appBarKt$settleAppBar$12.L$2 = null;
                    appBarKt$settleAppBar$12.label = 2;
                    if (SuspendAnimationKt.animateTo$default(AnimationState$default, boxFloat, animationSpec3, false, function1, appBarKt$settleAppBar$12, 4, null) != coroutine_suspended) {
                        floatRef2 = floatRef;
                        floatRef = floatRef2;
                    }
                    return coroutine_suspended;
                }
                return Velocity.m6615boximpl(VelocityKt.Velocity(0.0f, floatRef.element));
            }
        }
        appBarKt$settleAppBar$1 = new AppBarKt$settleAppBar$1(continuation);
        appBarKt$settleAppBar$12 = appBarKt$settleAppBar$1;
        Object obj2 = appBarKt$settleAppBar$12.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = appBarKt$settleAppBar$12.label;
        if (i != 0) {
        }
        animationSpec3 = animationSpec2;
        if (animationSpec3 != null) {
            AnimationState$default = AnimationStateKt.AnimationState$default(topAppBarState2.getHeightOffset(), 0.0f, 0L, 0L, false, 30, null);
            boxFloat = Boxing.boxFloat(topAppBarState2.getCollapsedFraction() >= 0.5f ? 0.0f : topAppBarState2.getHeightOffsetLimit());
            function1 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.material3.AppBarKt$settleAppBar$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                    invoke2(animationScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AnimationScope<Float, AnimationVector1D> animationScope) {
                    TopAppBarState.this.setHeightOffset(animationScope.getValue().floatValue());
                }
            };
            appBarKt$settleAppBar$12.L$0 = floatRef;
            appBarKt$settleAppBar$12.L$1 = null;
            appBarKt$settleAppBar$12.L$2 = null;
            appBarKt$settleAppBar$12.label = 2;
            if (SuspendAnimationKt.animateTo$default(AnimationState$default, boxFloat, animationSpec3, false, function1, appBarKt$settleAppBar$12, 4, null) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        return Velocity.m6615boximpl(VelocityKt.Velocity(0.0f, floatRef.element));
    }

    public static final CubicBezierEasing getTopTitleAlphaEasing() {
        return TopTitleAlphaEasing;
    }

    private static final long SingleRowTopAppBar$lambda$7(State<Color> state) {
        return state.getValue().m4073unboximpl();
    }

    static {
        float f = 16;
        float f2 = 12;
        float m6389constructorimpl = Dp.m6389constructorimpl(Dp.m6389constructorimpl(f) - Dp.m6389constructorimpl(f2));
        BottomAppBarHorizontalPadding = m6389constructorimpl;
        float m6389constructorimpl2 = Dp.m6389constructorimpl(Dp.m6389constructorimpl(f) - Dp.m6389constructorimpl(f2));
        BottomAppBarVerticalPadding = m6389constructorimpl2;
        FABHorizontalPadding = Dp.m6389constructorimpl(Dp.m6389constructorimpl(f) - m6389constructorimpl);
        FABVerticalPadding = Dp.m6389constructorimpl(Dp.m6389constructorimpl(f2) - m6389constructorimpl2);
        TopTitleAlphaEasing = new CubicBezierEasing(0.8f, 0.0f, 0.8f, 0.15f);
        MediumTitleBottomPadding = Dp.m6389constructorimpl(24);
        LargeTitleBottomPadding = Dp.m6389constructorimpl(28);
        float m6389constructorimpl3 = Dp.m6389constructorimpl(4);
        TopAppBarHorizontalPadding = m6389constructorimpl3;
        TopAppBarTitleInset = Dp.m6389constructorimpl(Dp.m6389constructorimpl(f) - m6389constructorimpl3);
    }
}
