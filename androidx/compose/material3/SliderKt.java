package androidx.compose.material3;

import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.Strings;
import androidx.compose.material3.tokens.SliderTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
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
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* compiled from: Slider.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0098\u0001\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001f2\u0019\b\u0002\u0010!\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#2\u0019\b\u0002\u0010$\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#2\u0019\b\u0002\u0010%\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#H\u0007¢\u0006\u0002\u0010&\u001aä\u0001\u0010\u0015\u001a\u00020\u00162\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(2\u0018\u0010*\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(\u0012\u0004\u0012\u00020\u00160\"2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020)0(2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010-2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001f2\u0019\b\u0002\u0010!\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#2\u0019\b\u0002\u0010$\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#2\u0019\b\u0002\u0010%\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#2\b\b\u0003\u0010.\u001a\u00020/H\u0007¢\u0006\u0002\u00100\u001a\u007f\u0010\u0015\u001a\u00020\u00162\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(2\u0018\u0010*\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(\u0012\u0004\u0012\u00020\u00160\"2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020)0(2\b\b\u0003\u0010.\u001a\u00020/2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010-2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0007¢\u0006\u0002\u00101\u001a\u0080\u0001\u00102\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#2\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#2\u0017\u0010%\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#H\u0003¢\u0006\u0002\u00103\u001as\u00104\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u0002052\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u00106\u001a\u00020\u001f2\u0019\b\u0002\u00107\u001a\u0013\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#2\u0019\b\u0002\u0010%\u001a\u0013\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#H\u0007¢\u0006\u0002\u00108\u001a³\u0001\u00104\u001a\u00020\u00162\u0006\u0010'\u001a\u00020)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00160\"2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010-2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u00106\u001a\u00020\u001f2\b\b\u0003\u0010.\u001a\u00020/2\u0019\b\u0002\u00107\u001a\u0013\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#2\u0019\b\u0002\u0010%\u001a\u0013\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#2\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020)0(H\u0007¢\u0006\u0002\u00109\u001a}\u00104\u001a\u00020\u00162\u0006\u0010'\u001a\u00020)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00160\"2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020)0(2\b\b\u0003\u0010.\u001a\u00020/2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010-2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u00106\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010:\u001a_\u0010;\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u0002052\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u00106\u001a\u00020\u001f2\u0017\u00107\u001a\u0013\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#2\u0017\u0010%\u001a\u0013\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#H\u0003¢\u0006\u0002\u0010<\u001a\u001d\u0010=\u001a\u00020\u00102\u0006\u0010>\u001a\u00020)2\u0006\u0010?\u001a\u00020)H\u0001¢\u0006\u0002\u0010@\u001a\u001b\u0010=\u001a\u00020\u00102\f\u0010A\u001a\b\u0012\u0004\u0012\u00020)0(H\u0001¢\u0006\u0002\u0010B\u001a \u0010C\u001a\u00020)2\u0006\u0010D\u001a\u00020)2\u0006\u0010E\u001a\u00020)2\u0006\u0010F\u001a\u00020)H\u0002\u001a:\u0010G\u001a\u00020\u00102\u0006\u0010H\u001a\u00020)2\u0006\u0010I\u001a\u00020)2\u0006\u0010J\u001a\u00020\u00102\u0006\u0010K\u001a\u00020)2\u0006\u0010L\u001a\u00020)H\u0002ø\u0001\u0000¢\u0006\u0004\bM\u0010N\u001a0\u0010G\u001a\u00020)2\u0006\u0010H\u001a\u00020)2\u0006\u0010I\u001a\u00020)2\u0006\u0010O\u001a\u00020)2\u0006\u0010K\u001a\u00020)2\u0006\u0010L\u001a\u00020)H\u0002\u001a(\u0010P\u001a\u00020)2\u0006\u0010Q\u001a\u00020)2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020)2\u0006\u0010U\u001a\u00020)H\u0002\u001a\u0010\u0010V\u001a\u00020S2\u0006\u0010.\u001a\u00020/H\u0002\u001a5\u0010W\u001a\u0010\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020)\u0018\u00010X*\u00020Z2\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020^H\u0082@ø\u0001\u0000¢\u0006\u0004\b_\u0010`\u001a\u001c\u0010a\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u000fH\u0002\u001a,\u0010b\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0003\u001a\u001c\u0010c\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u000fH\u0002\u001a\u001c\u0010d\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010\u0017\u001a\u0002052\u0006\u0010\u001b\u001a\u00020\u000fH\u0002\u001a$\u0010e\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010\u0017\u001a\u0002052\u0006\u00106\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0003\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007\"\u0016\u0010\b\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\t\u0010\n\"\u0010\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0016\u0010\f\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\r\u0010\n\"\u001e\u0010\u000e\u001a\u00020\u000f*\u00020\u00108@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006f"}, d2 = {"ThumbDefaultElevation", "Landroidx/compose/ui/unit/Dp;", "F", "ThumbHeight", "ThumbPressedElevation", "ThumbSize", "Landroidx/compose/ui/unit/DpSize;", "J", "ThumbWidth", "getThumbWidth", "()F", "TickSize", "TrackHeight", "getTrackHeight", "isSpecified", "", "Landroidx/compose/material3/SliderRange;", "isSpecified-If1S1O4$annotations", "(J)V", "isSpecified-If1S1O4", "(J)Z", "RangeSlider", "", "state", "Landroidx/compose/material3/RangeSliderState;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "colors", "Landroidx/compose/material3/SliderColors;", "startInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "endInteractionSource", "startThumb", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "endThumb", "track", "(Landroidx/compose/material3/RangeSliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "value", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "onValueChange", "valueRange", "onValueChangeFinished", "Lkotlin/Function0;", "steps", "", "(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;ILandroidx/compose/runtime/Composer;III)V", "(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/runtime/Composer;II)V", "RangeSliderImpl", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/RangeSliderState;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "Slider", "Landroidx/compose/material3/SliderState;", "interactionSource", "thumb", "(Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;ILkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/ranges/ClosedFloatingPointRange;Landroidx/compose/runtime/Composer;III)V", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "SliderImpl", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderState;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "SliderRange", "start", "endInclusive", "(FF)J", "range", "(Lkotlin/ranges/ClosedFloatingPointRange;)J", "calcFraction", "a", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "pos", "scale", "a1", "b1", VastAttributes.HORIZONTAL_POSITION, "a2", "b2", "scale-ziovWd0", "(FFJFF)J", "x1", "snapValueToTick", "current", "tickFractions", "", "minPx", "maxPx", "stepsToTickFractions", "awaitSlop", "Lkotlin/Pair;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "awaitSlop-8vUncbI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rangeSliderEndThumbSemantics", "rangeSliderPressDragModifier", "rangeSliderStartThumbSemantics", "sliderSemantics", "sliderTapModifier", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SliderKt {
    private static final float ThumbDefaultElevation;
    private static final float ThumbHeight;
    private static final float ThumbPressedElevation;
    private static final long ThumbSize;
    private static final float ThumbWidth;
    private static final float TickSize;
    private static final float TrackHeight;

    /* renamed from: isSpecified-If1S1O4$annotations, reason: not valid java name */
    public static /* synthetic */ void m2530isSpecifiedIf1S1O4$annotations(long j) {
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Slider(final float f, final Function1<? super Float, Unit> function1, Modifier modifier, boolean z, ClosedFloatingPointRange<Float> closedFloatingPointRange, int i, Function0<Unit> function0, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i2, final int i3) {
        float f2;
        int i4;
        Function1<? super Float, Unit> function12;
        Modifier modifier2;
        int i5;
        boolean z2;
        ClosedFloatingPointRange<Float> closedFloatingPointRange2;
        int i6;
        int i7;
        int i8;
        Function0<Unit> function02;
        int i9;
        int i10;
        int i11;
        final SliderColors sliderColors2;
        final MutableInteractionSource mutableInteractionSource2;
        Modifier modifier3;
        ClosedFloatingPointRange<Float> closedFloatingPointRange3;
        int i12;
        Function0<Unit> function03;
        int i13;
        Composer composer2;
        final Modifier modifier4;
        final boolean z3;
        final Function0<Unit> function04;
        final SliderColors sliderColors3;
        final MutableInteractionSource mutableInteractionSource3;
        final int i14;
        final ClosedFloatingPointRange<Float> closedFloatingPointRange4;
        ScopeUpdateScope endRestartGroup;
        int i15;
        int i16;
        Composer startRestartGroup = composer.startRestartGroup(-202044027);
        ComposerKt.sourceInformation(startRestartGroup, "C(Slider)P(7,4,3,1,8,6,5)155@7378L8,156@7438L39,158@7486L714:Slider.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
            f2 = f;
        } else {
            f2 = f;
            if ((i2 & 6) == 0) {
                i4 = (startRestartGroup.changed(f2) ? 4 : 2) | i2;
            } else {
                i4 = i2;
            }
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
            function12 = function1;
        } else {
            function12 = function1;
            if ((i2 & 48) == 0) {
                i4 |= startRestartGroup.changedInstance(function12) ? 32 : 16;
            }
        }
        int i17 = i3 & 4;
        if (i17 != 0) {
            i4 |= 384;
        } else if ((i2 & 384) == 0) {
            modifier2 = modifier;
            i4 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else if ((i2 & 3072) == 0) {
                z2 = z;
                i4 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                if ((i2 & 24576) == 0) {
                    if ((i3 & 16) == 0) {
                        closedFloatingPointRange2 = closedFloatingPointRange;
                        if (startRestartGroup.changed(closedFloatingPointRange2)) {
                            i16 = 16384;
                            i4 |= i16;
                        }
                    } else {
                        closedFloatingPointRange2 = closedFloatingPointRange;
                    }
                    i16 = 8192;
                    i4 |= i16;
                } else {
                    closedFloatingPointRange2 = closedFloatingPointRange;
                }
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i2) == 0) {
                    i7 = i;
                    i4 |= startRestartGroup.changed(i7) ? 131072 : 65536;
                    i8 = i3 & 64;
                    if (i8 == 0) {
                        i4 |= 1572864;
                    } else if ((1572864 & i2) == 0) {
                        function02 = function0;
                        i4 |= startRestartGroup.changedInstance(function02) ? 1048576 : 524288;
                        if ((i2 & 12582912) == 0) {
                            if ((i3 & 128) == 0 && startRestartGroup.changed(sliderColors)) {
                                i15 = 8388608;
                                i4 |= i15;
                            }
                            i15 = 4194304;
                            i4 |= i15;
                        }
                        i9 = i3 & 256;
                        if (i9 != 0) {
                            i4 |= 100663296;
                        } else if ((i2 & 100663296) == 0) {
                            i10 = i9;
                            i4 |= startRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                            int i18 = i4;
                            if ((i4 & 38347923) == 38347922 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    if (i17 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i5 != 0) {
                                        z2 = true;
                                    }
                                    if ((i3 & 16) == 0) {
                                        i11 = i18 & (-57345);
                                        closedFloatingPointRange2 = RangesKt.rangeTo(0.0f, 1.0f);
                                    } else {
                                        i11 = i18;
                                    }
                                    if (i6 != 0) {
                                        i7 = 0;
                                    }
                                    if (i8 != 0) {
                                        function02 = null;
                                    }
                                    if ((i3 & 128) == 0) {
                                        sliderColors2 = SliderDefaults.INSTANCE.colors(startRestartGroup, 6);
                                        i11 &= -29360129;
                                    } else {
                                        sliderColors2 = sliderColors;
                                    }
                                    if (i10 == 0) {
                                        startRestartGroup.startReplaceableGroup(-1537043190);
                                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                                        Object rememberedValue = startRestartGroup.rememberedValue();
                                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            startRestartGroup.updateRememberedValue(rememberedValue);
                                        }
                                        mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                        startRestartGroup.endReplaceableGroup();
                                    } else {
                                        mutableInteractionSource2 = mutableInteractionSource;
                                    }
                                    modifier3 = modifier2;
                                    closedFloatingPointRange3 = closedFloatingPointRange2;
                                    i12 = i7;
                                    function03 = function02;
                                    i13 = -202044027;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    int i19 = (i3 & 16) != 0 ? i18 & (-57345) : i18;
                                    if ((i3 & 128) != 0) {
                                        i19 &= -29360129;
                                    }
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    i11 = i19;
                                    modifier3 = modifier2;
                                    closedFloatingPointRange3 = closedFloatingPointRange2;
                                    i12 = i7;
                                    function03 = function02;
                                    i13 = -202044027;
                                    sliderColors2 = sliderColors;
                                }
                                final boolean z4 = z2;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(i13, i11, -1, "androidx.compose.material3.Slider (Slider.kt:157)");
                                }
                                int i20 = i11 >> 6;
                                SliderColors sliderColors4 = sliderColors2;
                                composer2 = startRestartGroup;
                                MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                                Slider(f2, function12, modifier3, z4, function03, sliderColors4, mutableInteractionSource4, i12, ComposableLambdaKt.composableLambda(startRestartGroup, 308249025, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(SliderState sliderState, Composer composer3, Integer num) {
                                        invoke(sliderState, composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(SliderState sliderState, Composer composer3, int i21) {
                                        ComposerKt.sourceInformation(composer3, "C168@7807L142:Slider.kt#uh7d8r");
                                        if ((i21 & 17) != 16 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(308249025, i21, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:168)");
                                            }
                                            SliderDefaults.INSTANCE.m2524Thumb9LiSoMs(MutableInteractionSource.this, null, sliderColors2, z4, 0L, composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }), ComposableLambdaKt.composableLambda(startRestartGroup, -1843234110, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(SliderState sliderState, Composer composer3, Integer num) {
                                        invoke(sliderState, composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(SliderState sliderState, Composer composer3, int i21) {
                                        ComposerKt.sourceInformation(composer3, "C175@8021L130:Slider.kt#uh7d8r");
                                        if ((i21 & 6) == 0) {
                                            i21 |= composer3.changed(sliderState) ? 4 : 2;
                                        }
                                        if ((i21 & 19) != 18 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1843234110, i21, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:175)");
                                            }
                                            SliderDefaults.INSTANCE.Track(sliderState, (Modifier) null, SliderColors.this, z4, composer3, (i21 & 14) | 24576, 2);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }), closedFloatingPointRange3, composer2, (i11 & 14) | 905969664 | (i11 & 112) | (i11 & 896) | (i11 & 7168) | (57344 & i20) | (458752 & i20) | (i20 & 3670016) | ((i11 << 6) & 29360128), (i11 >> 12) & 14, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier4 = modifier3;
                                z3 = z4;
                                function04 = function03;
                                sliderColors3 = sliderColors4;
                                mutableInteractionSource3 = mutableInteractionSource4;
                                i14 = i12;
                                closedFloatingPointRange4 = closedFloatingPointRange3;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                sliderColors3 = sliderColors;
                                composer2 = startRestartGroup;
                                modifier4 = modifier2;
                                z3 = z2;
                                closedFloatingPointRange4 = closedFloatingPointRange2;
                                i14 = i7;
                                function04 = function02;
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$4
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

                                    public final void invoke(Composer composer3, int i21) {
                                        SliderKt.Slider(f, function1, modifier4, z3, closedFloatingPointRange4, i14, function04, sliderColors3, mutableInteractionSource3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i10 = i9;
                        int i182 = i4;
                        if ((i4 & 38347923) == 38347922) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                        }
                        if (i17 != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if ((i3 & 16) == 0) {
                        }
                        if (i6 != 0) {
                        }
                        if (i8 != 0) {
                        }
                        if ((i3 & 128) == 0) {
                        }
                        if (i10 == 0) {
                        }
                        modifier3 = modifier2;
                        closedFloatingPointRange3 = closedFloatingPointRange2;
                        i12 = i7;
                        function03 = function02;
                        i13 = -202044027;
                        final boolean z42 = z2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i202 = i11 >> 6;
                        SliderColors sliderColors42 = sliderColors2;
                        composer2 = startRestartGroup;
                        MutableInteractionSource mutableInteractionSource42 = mutableInteractionSource2;
                        Slider(f2, function12, modifier3, z42, function03, sliderColors42, mutableInteractionSource42, i12, ComposableLambdaKt.composableLambda(startRestartGroup, 308249025, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(SliderState sliderState, Composer composer3, Integer num) {
                                invoke(sliderState, composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(SliderState sliderState, Composer composer3, int i21) {
                                ComposerKt.sourceInformation(composer3, "C168@7807L142:Slider.kt#uh7d8r");
                                if ((i21 & 17) != 16 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(308249025, i21, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:168)");
                                    }
                                    SliderDefaults.INSTANCE.m2524Thumb9LiSoMs(MutableInteractionSource.this, null, sliderColors2, z42, 0L, composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }), ComposableLambdaKt.composableLambda(startRestartGroup, -1843234110, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(SliderState sliderState, Composer composer3, Integer num) {
                                invoke(sliderState, composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(SliderState sliderState, Composer composer3, int i21) {
                                ComposerKt.sourceInformation(composer3, "C175@8021L130:Slider.kt#uh7d8r");
                                if ((i21 & 6) == 0) {
                                    i21 |= composer3.changed(sliderState) ? 4 : 2;
                                }
                                if ((i21 & 19) != 18 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1843234110, i21, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:175)");
                                    }
                                    SliderDefaults.INSTANCE.Track(sliderState, (Modifier) null, SliderColors.this, z42, composer3, (i21 & 14) | 24576, 2);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }), closedFloatingPointRange3, composer2, (i11 & 14) | 905969664 | (i11 & 112) | (i11 & 896) | (i11 & 7168) | (57344 & i202) | (458752 & i202) | (i202 & 3670016) | ((i11 << 6) & 29360128), (i11 >> 12) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier4 = modifier3;
                        z3 = z42;
                        function04 = function03;
                        sliderColors3 = sliderColors42;
                        mutableInteractionSource3 = mutableInteractionSource42;
                        i14 = i12;
                        closedFloatingPointRange4 = closedFloatingPointRange3;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    function02 = function0;
                    if ((i2 & 12582912) == 0) {
                    }
                    i9 = i3 & 256;
                    if (i9 != 0) {
                    }
                    i10 = i9;
                    int i1822 = i4;
                    if ((i4 & 38347923) == 38347922) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                    }
                    if (i17 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i3 & 16) == 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if ((i3 & 128) == 0) {
                    }
                    if (i10 == 0) {
                    }
                    modifier3 = modifier2;
                    closedFloatingPointRange3 = closedFloatingPointRange2;
                    i12 = i7;
                    function03 = function02;
                    i13 = -202044027;
                    final boolean z422 = z2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i2022 = i11 >> 6;
                    SliderColors sliderColors422 = sliderColors2;
                    composer2 = startRestartGroup;
                    MutableInteractionSource mutableInteractionSource422 = mutableInteractionSource2;
                    Slider(f2, function12, modifier3, z422, function03, sliderColors422, mutableInteractionSource422, i12, ComposableLambdaKt.composableLambda(startRestartGroup, 308249025, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(SliderState sliderState, Composer composer3, Integer num) {
                            invoke(sliderState, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(SliderState sliderState, Composer composer3, int i21) {
                            ComposerKt.sourceInformation(composer3, "C168@7807L142:Slider.kt#uh7d8r");
                            if ((i21 & 17) != 16 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(308249025, i21, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:168)");
                                }
                                SliderDefaults.INSTANCE.m2524Thumb9LiSoMs(MutableInteractionSource.this, null, sliderColors2, z422, 0L, composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), ComposableLambdaKt.composableLambda(startRestartGroup, -1843234110, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(SliderState sliderState, Composer composer3, Integer num) {
                            invoke(sliderState, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(SliderState sliderState, Composer composer3, int i21) {
                            ComposerKt.sourceInformation(composer3, "C175@8021L130:Slider.kt#uh7d8r");
                            if ((i21 & 6) == 0) {
                                i21 |= composer3.changed(sliderState) ? 4 : 2;
                            }
                            if ((i21 & 19) != 18 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1843234110, i21, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:175)");
                                }
                                SliderDefaults.INSTANCE.Track(sliderState, (Modifier) null, SliderColors.this, z422, composer3, (i21 & 14) | 24576, 2);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), closedFloatingPointRange3, composer2, (i11 & 14) | 905969664 | (i11 & 112) | (i11 & 896) | (i11 & 7168) | (57344 & i2022) | (458752 & i2022) | (i2022 & 3670016) | ((i11 << 6) & 29360128), (i11 >> 12) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier4 = modifier3;
                    z3 = z422;
                    function04 = function03;
                    sliderColors3 = sliderColors422;
                    mutableInteractionSource3 = mutableInteractionSource422;
                    i14 = i12;
                    closedFloatingPointRange4 = closedFloatingPointRange3;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                i7 = i;
                i8 = i3 & 64;
                if (i8 == 0) {
                }
                function02 = function0;
                if ((i2 & 12582912) == 0) {
                }
                i9 = i3 & 256;
                if (i9 != 0) {
                }
                i10 = i9;
                int i18222 = i4;
                if ((i4 & 38347923) == 38347922) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i17 != 0) {
                }
                if (i5 != 0) {
                }
                if ((i3 & 16) == 0) {
                }
                if (i6 != 0) {
                }
                if (i8 != 0) {
                }
                if ((i3 & 128) == 0) {
                }
                if (i10 == 0) {
                }
                modifier3 = modifier2;
                closedFloatingPointRange3 = closedFloatingPointRange2;
                i12 = i7;
                function03 = function02;
                i13 = -202044027;
                final boolean z4222 = z2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i20222 = i11 >> 6;
                SliderColors sliderColors4222 = sliderColors2;
                composer2 = startRestartGroup;
                MutableInteractionSource mutableInteractionSource4222 = mutableInteractionSource2;
                Slider(f2, function12, modifier3, z4222, function03, sliderColors4222, mutableInteractionSource4222, i12, ComposableLambdaKt.composableLambda(startRestartGroup, 308249025, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(SliderState sliderState, Composer composer3, Integer num) {
                        invoke(sliderState, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(SliderState sliderState, Composer composer3, int i21) {
                        ComposerKt.sourceInformation(composer3, "C168@7807L142:Slider.kt#uh7d8r");
                        if ((i21 & 17) != 16 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(308249025, i21, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:168)");
                            }
                            SliderDefaults.INSTANCE.m2524Thumb9LiSoMs(MutableInteractionSource.this, null, sliderColors2, z4222, 0L, composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), ComposableLambdaKt.composableLambda(startRestartGroup, -1843234110, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(SliderState sliderState, Composer composer3, Integer num) {
                        invoke(sliderState, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(SliderState sliderState, Composer composer3, int i21) {
                        ComposerKt.sourceInformation(composer3, "C175@8021L130:Slider.kt#uh7d8r");
                        if ((i21 & 6) == 0) {
                            i21 |= composer3.changed(sliderState) ? 4 : 2;
                        }
                        if ((i21 & 19) != 18 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1843234110, i21, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:175)");
                            }
                            SliderDefaults.INSTANCE.Track(sliderState, (Modifier) null, SliderColors.this, z4222, composer3, (i21 & 14) | 24576, 2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), closedFloatingPointRange3, composer2, (i11 & 14) | 905969664 | (i11 & 112) | (i11 & 896) | (i11 & 7168) | (57344 & i20222) | (458752 & i20222) | (i20222 & 3670016) | ((i11 << 6) & 29360128), (i11 >> 12) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier4 = modifier3;
                z3 = z4222;
                function04 = function03;
                sliderColors3 = sliderColors4222;
                mutableInteractionSource3 = mutableInteractionSource4222;
                i14 = i12;
                closedFloatingPointRange4 = closedFloatingPointRange3;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z2 = z;
            if ((i2 & 24576) == 0) {
            }
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            i7 = i;
            i8 = i3 & 64;
            if (i8 == 0) {
            }
            function02 = function0;
            if ((i2 & 12582912) == 0) {
            }
            i9 = i3 & 256;
            if (i9 != 0) {
            }
            i10 = i9;
            int i182222 = i4;
            if ((i4 & 38347923) == 38347922) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i17 != 0) {
            }
            if (i5 != 0) {
            }
            if ((i3 & 16) == 0) {
            }
            if (i6 != 0) {
            }
            if (i8 != 0) {
            }
            if ((i3 & 128) == 0) {
            }
            if (i10 == 0) {
            }
            modifier3 = modifier2;
            closedFloatingPointRange3 = closedFloatingPointRange2;
            i12 = i7;
            function03 = function02;
            i13 = -202044027;
            final boolean z42222 = z2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i202222 = i11 >> 6;
            SliderColors sliderColors42222 = sliderColors2;
            composer2 = startRestartGroup;
            MutableInteractionSource mutableInteractionSource42222 = mutableInteractionSource2;
            Slider(f2, function12, modifier3, z42222, function03, sliderColors42222, mutableInteractionSource42222, i12, ComposableLambdaKt.composableLambda(startRestartGroup, 308249025, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(SliderState sliderState, Composer composer3, Integer num) {
                    invoke(sliderState, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(SliderState sliderState, Composer composer3, int i21) {
                    ComposerKt.sourceInformation(composer3, "C168@7807L142:Slider.kt#uh7d8r");
                    if ((i21 & 17) != 16 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(308249025, i21, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:168)");
                        }
                        SliderDefaults.INSTANCE.m2524Thumb9LiSoMs(MutableInteractionSource.this, null, sliderColors2, z42222, 0L, composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), ComposableLambdaKt.composableLambda(startRestartGroup, -1843234110, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(SliderState sliderState, Composer composer3, Integer num) {
                    invoke(sliderState, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(SliderState sliderState, Composer composer3, int i21) {
                    ComposerKt.sourceInformation(composer3, "C175@8021L130:Slider.kt#uh7d8r");
                    if ((i21 & 6) == 0) {
                        i21 |= composer3.changed(sliderState) ? 4 : 2;
                    }
                    if ((i21 & 19) != 18 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1843234110, i21, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:175)");
                        }
                        SliderDefaults.INSTANCE.Track(sliderState, (Modifier) null, SliderColors.this, z42222, composer3, (i21 & 14) | 24576, 2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), closedFloatingPointRange3, composer2, (i11 & 14) | 905969664 | (i11 & 112) | (i11 & 896) | (i11 & 7168) | (57344 & i202222) | (458752 & i202222) | (i202222 & 3670016) | ((i11 << 6) & 29360128), (i11 >> 12) & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier4 = modifier3;
            z3 = z42222;
            function04 = function03;
            sliderColors3 = sliderColors42222;
            mutableInteractionSource3 = mutableInteractionSource42222;
            i14 = i12;
            closedFloatingPointRange4 = closedFloatingPointRange3;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        z2 = z;
        if ((i2 & 24576) == 0) {
        }
        i6 = i3 & 32;
        if (i6 != 0) {
        }
        i7 = i;
        i8 = i3 & 64;
        if (i8 == 0) {
        }
        function02 = function0;
        if ((i2 & 12582912) == 0) {
        }
        i9 = i3 & 256;
        if (i9 != 0) {
        }
        i10 = i9;
        int i1822222 = i4;
        if ((i4 & 38347923) == 38347922) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i17 != 0) {
        }
        if (i5 != 0) {
        }
        if ((i3 & 16) == 0) {
        }
        if (i6 != 0) {
        }
        if (i8 != 0) {
        }
        if ((i3 & 128) == 0) {
        }
        if (i10 == 0) {
        }
        modifier3 = modifier2;
        closedFloatingPointRange3 = closedFloatingPointRange2;
        i12 = i7;
        function03 = function02;
        i13 = -202044027;
        final boolean z422222 = z2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i2022222 = i11 >> 6;
        SliderColors sliderColors422222 = sliderColors2;
        composer2 = startRestartGroup;
        MutableInteractionSource mutableInteractionSource422222 = mutableInteractionSource2;
        Slider(f2, function12, modifier3, z422222, function03, sliderColors422222, mutableInteractionSource422222, i12, ComposableLambdaKt.composableLambda(startRestartGroup, 308249025, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(SliderState sliderState, Composer composer3, Integer num) {
                invoke(sliderState, composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(SliderState sliderState, Composer composer3, int i21) {
                ComposerKt.sourceInformation(composer3, "C168@7807L142:Slider.kt#uh7d8r");
                if ((i21 & 17) != 16 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(308249025, i21, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:168)");
                    }
                    SliderDefaults.INSTANCE.m2524Thumb9LiSoMs(MutableInteractionSource.this, null, sliderColors2, z422222, 0L, composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }), ComposableLambdaKt.composableLambda(startRestartGroup, -1843234110, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(SliderState sliderState, Composer composer3, Integer num) {
                invoke(sliderState, composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(SliderState sliderState, Composer composer3, int i21) {
                ComposerKt.sourceInformation(composer3, "C175@8021L130:Slider.kt#uh7d8r");
                if ((i21 & 6) == 0) {
                    i21 |= composer3.changed(sliderState) ? 4 : 2;
                }
                if ((i21 & 19) != 18 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1843234110, i21, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:175)");
                    }
                    SliderDefaults.INSTANCE.Track(sliderState, (Modifier) null, SliderColors.this, z422222, composer3, (i21 & 14) | 24576, 2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }), closedFloatingPointRange3, composer2, (i11 & 14) | 905969664 | (i11 & 112) | (i11 & 896) | (i11 & 7168) | (57344 & i2022222) | (458752 & i2022222) | (i2022222 & 3670016) | ((i11 << 6) & 29360128), (i11 >> 12) & 14, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        z3 = z422222;
        function04 = function03;
        sliderColors3 = sliderColors422222;
        mutableInteractionSource3 = mutableInteractionSource422222;
        i14 = i12;
        closedFloatingPointRange4 = closedFloatingPointRange3;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Slider(final float f, final Function1<? super Float, Unit> function1, Modifier modifier, boolean z, Function0<Unit> function0, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, int i, Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function3, Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function32, ClosedFloatingPointRange<Float> closedFloatingPointRange, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        final boolean z2;
        int i7;
        Function0<Unit> function02;
        final SliderColors sliderColors2;
        int i8;
        final MutableInteractionSource mutableInteractionSource2;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        ComposableLambda composableLambda;
        ComposableLambda composableLambda2;
        ClosedFloatingPointRange<Float> closedFloatingPointRange2;
        int i17;
        int i18;
        MutableInteractionSource mutableInteractionSource3;
        boolean z3;
        Object rememberedValue;
        Composer composer2;
        final ClosedFloatingPointRange<Float> closedFloatingPointRange3;
        final boolean z4;
        final Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function33;
        final Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function34;
        final MutableInteractionSource mutableInteractionSource4;
        final SliderColors sliderColors3;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        int i19;
        int i20;
        Composer startRestartGroup = composer.startRestartGroup(1191170377);
        ComposerKt.sourceInformation(startRestartGroup, "C(Slider)P(9,4,3,1,5)246@11459L8,247@11519L39,266@12117L43,267@12177L210,283@12458L184:Slider.kt#uh7d8r");
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i5 = (startRestartGroup.changed(f) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i2 & 48) == 0) {
            i5 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i21 = i4 & 4;
        if (i21 != 0) {
            i5 |= 384;
        } else if ((i2 & 384) == 0) {
            modifier2 = modifier;
            i5 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            i6 = i4 & 8;
            if (i6 == 0) {
                i5 |= 3072;
            } else if ((i2 & 3072) == 0) {
                z2 = z;
                i5 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                i7 = i4 & 16;
                if (i7 != 0) {
                    i5 |= 24576;
                } else if ((i2 & 24576) == 0) {
                    function02 = function0;
                    i5 |= startRestartGroup.changedInstance(function02) ? 16384 : 8192;
                    if ((196608 & i2) != 0) {
                        if ((i4 & 32) == 0) {
                            sliderColors2 = sliderColors;
                            if (startRestartGroup.changed(sliderColors2)) {
                                i20 = 131072;
                                i5 |= i20;
                            }
                        } else {
                            sliderColors2 = sliderColors;
                        }
                        i20 = 65536;
                        i5 |= i20;
                    } else {
                        sliderColors2 = sliderColors;
                    }
                    i8 = i4 & 64;
                    if (i8 == 0) {
                        i5 |= 1572864;
                        mutableInteractionSource2 = mutableInteractionSource;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if ((i2 & 1572864) == 0) {
                            i5 |= startRestartGroup.changed(mutableInteractionSource2) ? 1048576 : 524288;
                        }
                    }
                    i9 = i4 & 128;
                    if (i9 == 0) {
                        i5 |= 12582912;
                        i10 = i;
                    } else {
                        i10 = i;
                        if ((i2 & 12582912) == 0) {
                            i5 |= startRestartGroup.changed(i10) ? 8388608 : 4194304;
                        }
                    }
                    i11 = i4 & 256;
                    if (i11 == 0) {
                        i5 |= 100663296;
                    } else if ((i2 & 100663296) == 0) {
                        i12 = i11;
                        i5 |= startRestartGroup.changedInstance(function3) ? 67108864 : 33554432;
                        i13 = i4 & 512;
                        if (i13 != 0) {
                            i5 |= C.ENCODING_PCM_32BIT;
                        } else if ((i2 & C.ENCODING_PCM_32BIT) == 0) {
                            i14 = i13;
                            i5 |= startRestartGroup.changedInstance(function32) ? 536870912 : 268435456;
                            if ((i3 & 6) != 0) {
                                if ((i4 & 1024) == 0 && startRestartGroup.changed(closedFloatingPointRange)) {
                                    i19 = 4;
                                    i15 = i3 | i19;
                                }
                                i19 = 2;
                                i15 = i3 | i19;
                            } else {
                                i15 = i3;
                            }
                            int i22 = i5;
                            if ((i5 & 306783379) == 306783378 || (i15 & 3) != 2 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    if (i21 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i6 != 0) {
                                        z2 = true;
                                    }
                                    if (i7 != 0) {
                                        function02 = null;
                                    }
                                    if ((i4 & 32) == 0) {
                                        i16 = i22 & (-458753);
                                        sliderColors2 = SliderDefaults.INSTANCE.colors(startRestartGroup, 6);
                                    } else {
                                        i16 = i22;
                                    }
                                    if (i8 != 0) {
                                        startRestartGroup.startReplaceableGroup(-1537039109);
                                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                                        Object rememberedValue2 = startRestartGroup.rememberedValue();
                                        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                                            startRestartGroup.updateRememberedValue(rememberedValue2);
                                        }
                                        startRestartGroup.endReplaceableGroup();
                                        mutableInteractionSource2 = (MutableInteractionSource) rememberedValue2;
                                    }
                                    if (i9 != 0) {
                                        i10 = 0;
                                    }
                                    composableLambda = i12 == 0 ? ComposableLambdaKt.composableLambda(startRestartGroup, -1756326375, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$6
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(SliderState sliderState, Composer composer3, Integer num) {
                                            invoke(sliderState, composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(SliderState sliderState, Composer composer3, int i23) {
                                            ComposerKt.sourceInformation(composer3, "C251@11676L126:Slider.kt#uh7d8r");
                                            if ((i23 & 17) != 16 || !composer3.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1756326375, i23, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:251)");
                                                }
                                                SliderDefaults.INSTANCE.m2524Thumb9LiSoMs(MutableInteractionSource.this, null, sliderColors2, z2, 0L, composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    }) : function3;
                                    composableLambda2 = i14 == 0 ? ComposableLambdaKt.composableLambda(startRestartGroup, 2083675534, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$7
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(SliderState sliderState, Composer composer3, Integer num) {
                                            invoke(sliderState, composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(SliderState sliderState, Composer composer3, int i23) {
                                            ComposerKt.sourceInformation(composer3, "C258@11897L114:Slider.kt#uh7d8r");
                                            if ((i23 & 6) == 0) {
                                                i23 |= composer3.changed(sliderState) ? 4 : 2;
                                            }
                                            if ((i23 & 19) != 18 || !composer3.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(2083675534, i23, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:258)");
                                                }
                                                SliderDefaults.INSTANCE.Track(sliderState, (Modifier) null, SliderColors.this, z2, composer3, (i23 & 14) | 24576, 2);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    }) : function32;
                                    if ((i4 & 1024) == 0) {
                                        closedFloatingPointRange2 = RangesKt.rangeTo(0.0f, 1.0f);
                                        i15 &= -15;
                                    } else {
                                        closedFloatingPointRange2 = closedFloatingPointRange;
                                    }
                                    i17 = i16;
                                    i18 = i15;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i4 & 32) != 0) {
                                        i22 &= -458753;
                                    }
                                    if ((i4 & 1024) != 0) {
                                        i15 &= -15;
                                    }
                                    composableLambda = function3;
                                    composableLambda2 = function32;
                                    closedFloatingPointRange2 = closedFloatingPointRange;
                                    i18 = i15;
                                    i17 = i22;
                                }
                                startRestartGroup.endDefaults();
                                Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function35 = composableLambda;
                                if (ComposerKt.isTraceInProgress()) {
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    ComposerKt.traceEventStart(1191170377, i17, i18, "androidx.compose.material3.Slider (Slider.kt:265)");
                                }
                                final State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function02, startRestartGroup, (i17 >> 12) & 14);
                                startRestartGroup.startReplaceableGroup(-1537038451);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                                int i23 = i18;
                                z3 = ((29360128 & i17) != 8388608) | ((((i23 & 14) ^ 6) > 4 && startRestartGroup.changed(closedFloatingPointRange2)) || (i23 & 6) == 4);
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (!z3 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = new SliderState(f, i10, new Function0<Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$state$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
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
                                            Function0<Unit> value = rememberUpdatedState.getValue();
                                            if (value != null) {
                                                value.invoke();
                                            }
                                        }
                                    }, closedFloatingPointRange2);
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                SliderState sliderState = (SliderState) rememberedValue;
                                startRestartGroup.endReplaceableGroup();
                                sliderState.setOnValueChange$material3_release(function1);
                                sliderState.setValue(f);
                                int i24 = i17 >> 9;
                                Slider(sliderState, modifier2, z2, null, mutableInteractionSource3, function35, composableLambda2, startRestartGroup, ((i17 >> 3) & 1008) | ((i17 >> 6) & 57344) | (458752 & i24) | (i24 & 3670016), 8);
                                MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource3;
                                composer2 = startRestartGroup;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                closedFloatingPointRange3 = closedFloatingPointRange2;
                                z4 = z2;
                                function33 = composableLambda2;
                                function34 = function35;
                                mutableInteractionSource4 = mutableInteractionSource5;
                                sliderColors3 = sliderColors2;
                                modifier3 = modifier2;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                function34 = function3;
                                closedFloatingPointRange3 = closedFloatingPointRange;
                                composer2 = startRestartGroup;
                                z4 = z2;
                                function33 = function32;
                                mutableInteractionSource4 = mutableInteractionSource2;
                                modifier3 = modifier2;
                                sliderColors3 = sliderColors2;
                            }
                            final int i25 = i10;
                            final Function0<Unit> function03 = function02;
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup != null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$8
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

                                    public final void invoke(Composer composer3, int i26) {
                                        SliderKt.Slider(f, function1, modifier3, z4, function03, sliderColors3, mutableInteractionSource4, i25, function34, function33, closedFloatingPointRange3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i14 = i13;
                        if ((i3 & 6) != 0) {
                        }
                        int i222 = i5;
                        if ((i5 & 306783379) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                        }
                        if (i21 != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if (i7 != 0) {
                        }
                        if ((i4 & 32) == 0) {
                        }
                        if (i8 != 0) {
                        }
                        if (i9 != 0) {
                        }
                        if (i12 == 0) {
                        }
                        if (i14 == 0) {
                        }
                        if ((i4 & 1024) == 0) {
                        }
                        i17 = i16;
                        i18 = i15;
                        startRestartGroup.endDefaults();
                        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function352 = composableLambda;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        final State<? extends Function0<Unit>> rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function02, startRestartGroup, (i17 >> 12) & 14);
                        startRestartGroup.startReplaceableGroup(-1537038451);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                        int i232 = i18;
                        if (((i232 & 14) ^ 6) > 4) {
                            z3 = ((29360128 & i17) != 8388608) | ((((i232 & 14) ^ 6) > 4 && startRestartGroup.changed(closedFloatingPointRange2)) || (i232 & 6) == 4);
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (!z3) {
                            }
                            rememberedValue = new SliderState(f, i10, new Function0<Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$state$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
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
                                    Function0<Unit> value = rememberUpdatedState2.getValue();
                                    if (value != null) {
                                        value.invoke();
                                    }
                                }
                            }, closedFloatingPointRange2);
                            startRestartGroup.updateRememberedValue(rememberedValue);
                            SliderState sliderState2 = (SliderState) rememberedValue;
                            startRestartGroup.endReplaceableGroup();
                            sliderState2.setOnValueChange$material3_release(function1);
                            sliderState2.setValue(f);
                            int i242 = i17 >> 9;
                            Slider(sliderState2, modifier2, z2, null, mutableInteractionSource3, function352, composableLambda2, startRestartGroup, ((i17 >> 3) & 1008) | ((i17 >> 6) & 57344) | (458752 & i242) | (i242 & 3670016), 8);
                            MutableInteractionSource mutableInteractionSource52 = mutableInteractionSource3;
                            composer2 = startRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            closedFloatingPointRange3 = closedFloatingPointRange2;
                            z4 = z2;
                            function33 = composableLambda2;
                            function34 = function352;
                            mutableInteractionSource4 = mutableInteractionSource52;
                            sliderColors3 = sliderColors2;
                            modifier3 = modifier2;
                            final int i252 = i10;
                            final Function0<Unit> function032 = function02;
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        z3 = ((29360128 & i17) != 8388608) | ((((i232 & 14) ^ 6) > 4 && startRestartGroup.changed(closedFloatingPointRange2)) || (i232 & 6) == 4);
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (!z3) {
                        }
                        rememberedValue = new SliderState(f, i10, new Function0<Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$state$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
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
                                Function0<Unit> value = rememberUpdatedState2.getValue();
                                if (value != null) {
                                    value.invoke();
                                }
                            }
                        }, closedFloatingPointRange2);
                        startRestartGroup.updateRememberedValue(rememberedValue);
                        SliderState sliderState22 = (SliderState) rememberedValue;
                        startRestartGroup.endReplaceableGroup();
                        sliderState22.setOnValueChange$material3_release(function1);
                        sliderState22.setValue(f);
                        int i2422 = i17 >> 9;
                        Slider(sliderState22, modifier2, z2, null, mutableInteractionSource3, function352, composableLambda2, startRestartGroup, ((i17 >> 3) & 1008) | ((i17 >> 6) & 57344) | (458752 & i2422) | (i2422 & 3670016), 8);
                        MutableInteractionSource mutableInteractionSource522 = mutableInteractionSource3;
                        composer2 = startRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        closedFloatingPointRange3 = closedFloatingPointRange2;
                        z4 = z2;
                        function33 = composableLambda2;
                        function34 = function352;
                        mutableInteractionSource4 = mutableInteractionSource522;
                        sliderColors3 = sliderColors2;
                        modifier3 = modifier2;
                        final int i2522 = i10;
                        final Function0<Unit> function0322 = function02;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    i12 = i11;
                    i13 = i4 & 512;
                    if (i13 != 0) {
                    }
                    i14 = i13;
                    if ((i3 & 6) != 0) {
                    }
                    int i2222 = i5;
                    if ((i5 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                    }
                    if (i21 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if ((i4 & 32) == 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i12 == 0) {
                    }
                    if (i14 == 0) {
                    }
                    if ((i4 & 1024) == 0) {
                    }
                    i17 = i16;
                    i18 = i15;
                    startRestartGroup.endDefaults();
                    Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function3522 = composableLambda;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    final State<? extends Function0<Unit>> rememberUpdatedState22 = SnapshotStateKt.rememberUpdatedState(function02, startRestartGroup, (i17 >> 12) & 14);
                    startRestartGroup.startReplaceableGroup(-1537038451);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                    int i2322 = i18;
                    z3 = ((29360128 & i17) != 8388608) | ((((i2322 & 14) ^ 6) > 4 && startRestartGroup.changed(closedFloatingPointRange2)) || (i2322 & 6) == 4);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!z3) {
                    }
                    rememberedValue = new SliderState(f, i10, new Function0<Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$state$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
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
                            Function0<Unit> value = rememberUpdatedState22.getValue();
                            if (value != null) {
                                value.invoke();
                            }
                        }
                    }, closedFloatingPointRange2);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    SliderState sliderState222 = (SliderState) rememberedValue;
                    startRestartGroup.endReplaceableGroup();
                    sliderState222.setOnValueChange$material3_release(function1);
                    sliderState222.setValue(f);
                    int i24222 = i17 >> 9;
                    Slider(sliderState222, modifier2, z2, null, mutableInteractionSource3, function3522, composableLambda2, startRestartGroup, ((i17 >> 3) & 1008) | ((i17 >> 6) & 57344) | (458752 & i24222) | (i24222 & 3670016), 8);
                    MutableInteractionSource mutableInteractionSource5222 = mutableInteractionSource3;
                    composer2 = startRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    closedFloatingPointRange3 = closedFloatingPointRange2;
                    z4 = z2;
                    function33 = composableLambda2;
                    function34 = function3522;
                    mutableInteractionSource4 = mutableInteractionSource5222;
                    sliderColors3 = sliderColors2;
                    modifier3 = modifier2;
                    final int i25222 = i10;
                    final Function0<Unit> function03222 = function02;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function02 = function0;
                if ((196608 & i2) != 0) {
                }
                i8 = i4 & 64;
                if (i8 == 0) {
                }
                i9 = i4 & 128;
                if (i9 == 0) {
                }
                i11 = i4 & 256;
                if (i11 == 0) {
                }
                i12 = i11;
                i13 = i4 & 512;
                if (i13 != 0) {
                }
                i14 = i13;
                if ((i3 & 6) != 0) {
                }
                int i22222 = i5;
                if ((i5 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i21 != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                if ((i4 & 32) == 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if (i12 == 0) {
                }
                if (i14 == 0) {
                }
                if ((i4 & 1024) == 0) {
                }
                i17 = i16;
                i18 = i15;
                startRestartGroup.endDefaults();
                Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function35222 = composableLambda;
                if (ComposerKt.isTraceInProgress()) {
                }
                final State<? extends Function0<Unit>> rememberUpdatedState222 = SnapshotStateKt.rememberUpdatedState(function02, startRestartGroup, (i17 >> 12) & 14);
                startRestartGroup.startReplaceableGroup(-1537038451);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                int i23222 = i18;
                z3 = ((29360128 & i17) != 8388608) | ((((i23222 & 14) ^ 6) > 4 && startRestartGroup.changed(closedFloatingPointRange2)) || (i23222 & 6) == 4);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!z3) {
                }
                rememberedValue = new SliderState(f, i10, new Function0<Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$state$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
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
                        Function0<Unit> value = rememberUpdatedState222.getValue();
                        if (value != null) {
                            value.invoke();
                        }
                    }
                }, closedFloatingPointRange2);
                startRestartGroup.updateRememberedValue(rememberedValue);
                SliderState sliderState2222 = (SliderState) rememberedValue;
                startRestartGroup.endReplaceableGroup();
                sliderState2222.setOnValueChange$material3_release(function1);
                sliderState2222.setValue(f);
                int i242222 = i17 >> 9;
                Slider(sliderState2222, modifier2, z2, null, mutableInteractionSource3, function35222, composableLambda2, startRestartGroup, ((i17 >> 3) & 1008) | ((i17 >> 6) & 57344) | (458752 & i242222) | (i242222 & 3670016), 8);
                MutableInteractionSource mutableInteractionSource52222 = mutableInteractionSource3;
                composer2 = startRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                }
                closedFloatingPointRange3 = closedFloatingPointRange2;
                z4 = z2;
                function33 = composableLambda2;
                function34 = function35222;
                mutableInteractionSource4 = mutableInteractionSource52222;
                sliderColors3 = sliderColors2;
                modifier3 = modifier2;
                final int i252222 = i10;
                final Function0<Unit> function032222 = function02;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z2 = z;
            i7 = i4 & 16;
            if (i7 != 0) {
            }
            function02 = function0;
            if ((196608 & i2) != 0) {
            }
            i8 = i4 & 64;
            if (i8 == 0) {
            }
            i9 = i4 & 128;
            if (i9 == 0) {
            }
            i11 = i4 & 256;
            if (i11 == 0) {
            }
            i12 = i11;
            i13 = i4 & 512;
            if (i13 != 0) {
            }
            i14 = i13;
            if ((i3 & 6) != 0) {
            }
            int i222222 = i5;
            if ((i5 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i21 != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            if ((i4 & 32) == 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if (i12 == 0) {
            }
            if (i14 == 0) {
            }
            if ((i4 & 1024) == 0) {
            }
            i17 = i16;
            i18 = i15;
            startRestartGroup.endDefaults();
            Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function352222 = composableLambda;
            if (ComposerKt.isTraceInProgress()) {
            }
            final State<? extends Function0<Unit>> rememberUpdatedState2222 = SnapshotStateKt.rememberUpdatedState(function02, startRestartGroup, (i17 >> 12) & 14);
            startRestartGroup.startReplaceableGroup(-1537038451);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
            int i232222 = i18;
            z3 = ((29360128 & i17) != 8388608) | ((((i232222 & 14) ^ 6) > 4 && startRestartGroup.changed(closedFloatingPointRange2)) || (i232222 & 6) == 4);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!z3) {
            }
            rememberedValue = new SliderState(f, i10, new Function0<Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$state$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
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
                    Function0<Unit> value = rememberUpdatedState2222.getValue();
                    if (value != null) {
                        value.invoke();
                    }
                }
            }, closedFloatingPointRange2);
            startRestartGroup.updateRememberedValue(rememberedValue);
            SliderState sliderState22222 = (SliderState) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            sliderState22222.setOnValueChange$material3_release(function1);
            sliderState22222.setValue(f);
            int i2422222 = i17 >> 9;
            Slider(sliderState22222, modifier2, z2, null, mutableInteractionSource3, function352222, composableLambda2, startRestartGroup, ((i17 >> 3) & 1008) | ((i17 >> 6) & 57344) | (458752 & i2422222) | (i2422222 & 3670016), 8);
            MutableInteractionSource mutableInteractionSource522222 = mutableInteractionSource3;
            composer2 = startRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
            }
            closedFloatingPointRange3 = closedFloatingPointRange2;
            z4 = z2;
            function33 = composableLambda2;
            function34 = function352222;
            mutableInteractionSource4 = mutableInteractionSource522222;
            sliderColors3 = sliderColors2;
            modifier3 = modifier2;
            final int i2522222 = i10;
            final Function0<Unit> function0322222 = function02;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 8;
        if (i6 == 0) {
        }
        z2 = z;
        i7 = i4 & 16;
        if (i7 != 0) {
        }
        function02 = function0;
        if ((196608 & i2) != 0) {
        }
        i8 = i4 & 64;
        if (i8 == 0) {
        }
        i9 = i4 & 128;
        if (i9 == 0) {
        }
        i11 = i4 & 256;
        if (i11 == 0) {
        }
        i12 = i11;
        i13 = i4 & 512;
        if (i13 != 0) {
        }
        i14 = i13;
        if ((i3 & 6) != 0) {
        }
        int i2222222 = i5;
        if ((i5 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i21 != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        if ((i4 & 32) == 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (i12 == 0) {
        }
        if (i14 == 0) {
        }
        if ((i4 & 1024) == 0) {
        }
        i17 = i16;
        i18 = i15;
        startRestartGroup.endDefaults();
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function3522222 = composableLambda;
        if (ComposerKt.isTraceInProgress()) {
        }
        final State<? extends Function0<Unit>> rememberUpdatedState22222 = SnapshotStateKt.rememberUpdatedState(function02, startRestartGroup, (i17 >> 12) & 14);
        startRestartGroup.startReplaceableGroup(-1537038451);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
        int i2322222 = i18;
        z3 = ((29360128 & i17) != 8388608) | ((((i2322222 & 14) ^ 6) > 4 && startRestartGroup.changed(closedFloatingPointRange2)) || (i2322222 & 6) == 4);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!z3) {
        }
        rememberedValue = new SliderState(f, i10, new Function0<Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$state$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                Function0<Unit> value = rememberUpdatedState22222.getValue();
                if (value != null) {
                    value.invoke();
                }
            }
        }, closedFloatingPointRange2);
        startRestartGroup.updateRememberedValue(rememberedValue);
        SliderState sliderState222222 = (SliderState) rememberedValue;
        startRestartGroup.endReplaceableGroup();
        sliderState222222.setOnValueChange$material3_release(function1);
        sliderState222222.setValue(f);
        int i24222222 = i17 >> 9;
        Slider(sliderState222222, modifier2, z2, null, mutableInteractionSource3, function3522222, composableLambda2, startRestartGroup, ((i17 >> 3) & 1008) | ((i17 >> 6) & 57344) | (458752 & i24222222) | (i24222222 & 3670016), 8);
        MutableInteractionSource mutableInteractionSource5222222 = mutableInteractionSource3;
        composer2 = startRestartGroup;
        if (ComposerKt.isTraceInProgress()) {
        }
        closedFloatingPointRange3 = closedFloatingPointRange2;
        z4 = z2;
        function33 = composableLambda2;
        function34 = function3522222;
        mutableInteractionSource4 = mutableInteractionSource5222222;
        sliderColors3 = sliderColors2;
        modifier3 = modifier2;
        final int i25222222 = i10;
        final Function0<Unit> function03222222 = function02;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Slider(final SliderState sliderState, Modifier modifier, boolean z, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function3, Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function32, Composer composer, final int i, final int i2) {
        SliderState sliderState2;
        int i3;
        Modifier modifier2;
        int i4;
        final boolean z2;
        final SliderColors sliderColors2;
        int i5;
        final MutableInteractionSource mutableInteractionSource2;
        int i6;
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function33;
        int i7;
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function34;
        boolean z3;
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function35;
        MutableInteractionSource mutableInteractionSource3;
        Modifier modifier3;
        final SliderColors sliderColors3;
        final Modifier modifier4;
        final boolean z4;
        final MutableInteractionSource mutableInteractionSource4;
        final Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function36;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(-1303883986);
        ComposerKt.sourceInformation(startRestartGroup, "C(Slider)P(4,3,1)342@15085L8,343@15145L39,361@15666L188:Slider.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            sliderState2 = sliderState;
        } else {
            sliderState2 = sliderState;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changed(sliderState2) ? 4 : 2) | i;
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
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 256 : 128;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        sliderColors2 = sliderColors;
                        if (startRestartGroup.changed(sliderColors2)) {
                            i8 = 2048;
                            i3 |= i8;
                        }
                    } else {
                        sliderColors2 = sliderColors;
                    }
                    i8 = 1024;
                    i3 |= i8;
                } else {
                    sliderColors2 = sliderColors;
                }
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    i3 |= startRestartGroup.changed(mutableInteractionSource2) ? 16384 : 8192;
                    i6 = i2 & 32;
                    if (i6 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((196608 & i) == 0) {
                        function33 = function3;
                        i3 |= startRestartGroup.changedInstance(function33) ? 131072 : 65536;
                        i7 = i2 & 64;
                        if (i7 != 0) {
                            i3 |= 1572864;
                        } else if ((1572864 & i) == 0) {
                            function34 = function32;
                            i3 |= startRestartGroup.changedInstance(function34) ? 1048576 : 524288;
                            if ((i3 & 599187) == 599186 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    Modifier.Companion companion = i9 == 0 ? Modifier.INSTANCE : modifier2;
                                    if (i4 != 0) {
                                        z2 = true;
                                    }
                                    if ((i2 & 8) != 0) {
                                        i3 &= -7169;
                                        sliderColors2 = SliderDefaults.INSTANCE.colors(startRestartGroup, 6);
                                    }
                                    if (i5 != 0) {
                                        startRestartGroup.startReplaceableGroup(-1537035483);
                                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                                        Object rememberedValue = startRestartGroup.rememberedValue();
                                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            startRestartGroup.updateRememberedValue(rememberedValue);
                                        }
                                        startRestartGroup.endReplaceableGroup();
                                        mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                    }
                                    if (i6 != 0) {
                                        function33 = ComposableLambdaKt.composableLambda(startRestartGroup, 1426271326, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$10
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(SliderState sliderState3, Composer composer2, Integer num) {
                                                invoke(sliderState3, composer2, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(SliderState sliderState3, Composer composer2, int i10) {
                                                ComposerKt.sourceInformation(composer2, "C345@15258L126:Slider.kt#uh7d8r");
                                                if ((i10 & 17) != 16 || !composer2.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1426271326, i10, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:345)");
                                                    }
                                                    SliderDefaults.INSTANCE.m2524Thumb9LiSoMs(MutableInteractionSource.this, null, sliderColors2, z2, 0L, composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer2.skipToGroupEnd();
                                            }
                                        });
                                    }
                                    if (i7 != 0) {
                                        function34 = ComposableLambdaKt.composableLambda(startRestartGroup, 577038345, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$11
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(SliderState sliderState3, Composer composer2, Integer num) {
                                                invoke(sliderState3, composer2, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(SliderState sliderState3, Composer composer2, int i10) {
                                                ComposerKt.sourceInformation(composer2, "C352@15479L114:Slider.kt#uh7d8r");
                                                if ((i10 & 6) == 0) {
                                                    i10 |= composer2.changed(sliderState3) ? 4 : 2;
                                                }
                                                if ((i10 & 19) != 18 || !composer2.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(577038345, i10, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:352)");
                                                    }
                                                    SliderDefaults.INSTANCE.Track(sliderState3, (Modifier) null, SliderColors.this, z2, composer2, (i10 & 14) | 24576, 2);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer2.skipToGroupEnd();
                                            }
                                        });
                                    }
                                    z3 = z2;
                                    function35 = function33;
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    modifier3 = companion;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i2 & 8) != 0) {
                                        i3 &= -7169;
                                    }
                                    z3 = z2;
                                    function35 = function33;
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    modifier3 = modifier2;
                                }
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1303883986, i3, -1, "androidx.compose.material3.Slider (Slider.kt:358)");
                                }
                                if (sliderState2.getSteps() >= 0) {
                                    throw new IllegalArgumentException("steps should be >= 0".toString());
                                }
                                int i10 = i3 >> 3;
                                SliderImpl(modifier3, sliderState2, z3, mutableInteractionSource3, function35, function34, startRestartGroup, (i3 & 896) | (i10 & 14) | ((i3 << 3) & 112) | (i10 & 7168) | (57344 & i10) | (i10 & 458752));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                sliderColors3 = sliderColors2;
                                modifier4 = modifier3;
                                z4 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                function36 = function35;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                modifier4 = modifier2;
                                z4 = z2;
                                sliderColors3 = sliderColors2;
                                mutableInteractionSource4 = mutableInteractionSource2;
                                function36 = function33;
                            }
                            final Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function37 = function34;
                            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup != null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$13
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

                                    public final void invoke(Composer composer2, int i11) {
                                        SliderKt.Slider(SliderState.this, modifier4, z4, sliderColors3, mutableInteractionSource4, function36, function37, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        function34 = function32;
                        if ((i3 & 599187) == 599186) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                        }
                        if (i9 == 0) {
                        }
                        if (i4 != 0) {
                        }
                        if ((i2 & 8) != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if (i7 != 0) {
                        }
                        z3 = z2;
                        function35 = function33;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier3 = companion;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        if (sliderState2.getSteps() >= 0) {
                        }
                    }
                    function33 = function3;
                    i7 = i2 & 64;
                    if (i7 != 0) {
                    }
                    function34 = function32;
                    if ((i3 & 599187) == 599186) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i9 == 0) {
                    }
                    if (i4 != 0) {
                    }
                    if ((i2 & 8) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    z3 = z2;
                    function35 = function33;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier3 = companion;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    if (sliderState2.getSteps() >= 0) {
                    }
                }
                mutableInteractionSource2 = mutableInteractionSource;
                i6 = i2 & 32;
                if (i6 == 0) {
                }
                function33 = function3;
                i7 = i2 & 64;
                if (i7 != 0) {
                }
                function34 = function32;
                if ((i3 & 599187) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i9 == 0) {
                }
                if (i4 != 0) {
                }
                if ((i2 & 8) != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                z3 = z2;
                function35 = function33;
                mutableInteractionSource3 = mutableInteractionSource2;
                modifier3 = companion;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                if (sliderState2.getSteps() >= 0) {
                }
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            i6 = i2 & 32;
            if (i6 == 0) {
            }
            function33 = function3;
            i7 = i2 & 64;
            if (i7 != 0) {
            }
            function34 = function32;
            if ((i3 & 599187) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i9 == 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 8) != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            z3 = z2;
            function35 = function33;
            mutableInteractionSource3 = mutableInteractionSource2;
            modifier3 = companion;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            if (sliderState2.getSteps() >= 0) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        function33 = function3;
        i7 = i2 & 64;
        if (i7 != 0) {
        }
        function34 = function32;
        if ((i3 & 599187) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i9 == 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        z3 = z2;
        function35 = function33;
        mutableInteractionSource3 = mutableInteractionSource2;
        modifier3 = companion;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        if (sliderState2.getSteps() >= 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void RangeSlider(final ClosedFloatingPointRange<Float> closedFloatingPointRange, final Function1<? super ClosedFloatingPointRange<Float>, Unit> function1, Modifier modifier, boolean z, ClosedFloatingPointRange<Float> closedFloatingPointRange2, int i, Function0<Unit> function0, SliderColors sliderColors, Composer composer, final int i2, final int i3) {
        ClosedFloatingPointRange<Float> closedFloatingPointRange3;
        int i4;
        Function1<? super ClosedFloatingPointRange<Float>, Unit> function12;
        Modifier modifier2;
        int i5;
        boolean z2;
        ClosedFloatingPointRange<Float> closedFloatingPointRange4;
        int i6;
        int i7;
        int i8;
        Function0<Unit> function02;
        int i9;
        final SliderColors sliderColors2;
        final boolean z3;
        int i10;
        Function0<Unit> function03;
        Modifier modifier3;
        int i11;
        Object rememberedValue;
        Object rememberedValue2;
        Composer composer2;
        final SliderColors sliderColors3;
        final Modifier modifier4;
        final boolean z4;
        final ClosedFloatingPointRange<Float> closedFloatingPointRange5;
        final Function0<Unit> function04;
        final int i12;
        ScopeUpdateScope endRestartGroup;
        int i13;
        int i14;
        Composer startRestartGroup = composer.startRestartGroup(-743091416);
        ComposerKt.sourceInformation(startRestartGroup, "C(RangeSlider)P(6,3,2,1,7,5,4)415@18225L8,417@18297L39,418@18394L39,420@18439L987:Slider.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
            closedFloatingPointRange3 = closedFloatingPointRange;
        } else {
            closedFloatingPointRange3 = closedFloatingPointRange;
            if ((i2 & 6) == 0) {
                i4 = (startRestartGroup.changed(closedFloatingPointRange3) ? 4 : 2) | i2;
            } else {
                i4 = i2;
            }
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
            function12 = function1;
        } else {
            function12 = function1;
            if ((i2 & 48) == 0) {
                i4 |= startRestartGroup.changedInstance(function12) ? 32 : 16;
            }
        }
        int i15 = i3 & 4;
        if (i15 != 0) {
            i4 |= 384;
        } else if ((i2 & 384) == 0) {
            modifier2 = modifier;
            i4 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else if ((i2 & 3072) == 0) {
                z2 = z;
                i4 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                if ((i2 & 24576) == 0) {
                    if ((i3 & 16) == 0) {
                        closedFloatingPointRange4 = closedFloatingPointRange2;
                        if (startRestartGroup.changed(closedFloatingPointRange4)) {
                            i14 = 16384;
                            i4 |= i14;
                        }
                    } else {
                        closedFloatingPointRange4 = closedFloatingPointRange2;
                    }
                    i14 = 8192;
                    i4 |= i14;
                } else {
                    closedFloatingPointRange4 = closedFloatingPointRange2;
                }
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i2) == 0) {
                    i7 = i;
                    i4 |= startRestartGroup.changed(i7) ? 131072 : 65536;
                    i8 = i3 & 64;
                    if (i8 == 0) {
                        i4 |= 1572864;
                    } else if ((1572864 & i2) == 0) {
                        function02 = function0;
                        i4 |= startRestartGroup.changedInstance(function02) ? 1048576 : 524288;
                        if ((i2 & 12582912) == 0) {
                            if ((i3 & 128) == 0 && startRestartGroup.changed(sliderColors)) {
                                i13 = 8388608;
                                i4 |= i13;
                            }
                            i13 = 4194304;
                            i4 |= i13;
                        }
                        int i16 = i4;
                        if ((i4 & 4793491) == 4793490 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i15 != 0 ? Modifier.INSTANCE : modifier2;
                                if (i5 != 0) {
                                    z2 = true;
                                }
                                if ((i3 & 16) != 0) {
                                    i9 = i16 & (-57345);
                                    closedFloatingPointRange4 = RangesKt.rangeTo(0.0f, 1.0f);
                                } else {
                                    i9 = i16;
                                }
                                if (i6 != 0) {
                                    i7 = 0;
                                }
                                if (i8 != 0) {
                                    function02 = null;
                                }
                                if ((i3 & 128) != 0) {
                                    sliderColors2 = SliderDefaults.INSTANCE.colors(startRestartGroup, 6);
                                    i9 &= -29360129;
                                } else {
                                    sliderColors2 = sliderColors;
                                }
                                z3 = z2;
                                i10 = i7;
                                function03 = function02;
                                modifier3 = companion;
                                i11 = i9;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                i11 = (i3 & 16) != 0 ? i16 & (-57345) : i16;
                                if ((i3 & 128) != 0) {
                                    i11 &= -29360129;
                                }
                                sliderColors2 = sliderColors;
                                z3 = z2;
                                i10 = i7;
                                function03 = function02;
                                modifier3 = modifier2;
                            }
                            ClosedFloatingPointRange<Float> closedFloatingPointRange6 = closedFloatingPointRange4;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-743091416, i11, -1, "androidx.compose.material3.RangeSlider (Slider.kt:416)");
                            }
                            startRestartGroup.startReplaceableGroup(-223513570);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            final MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) rememberedValue;
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.startReplaceableGroup(-223513473);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                            rememberedValue2 = startRestartGroup.rememberedValue();
                            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                                startRestartGroup.updateRememberedValue(rememberedValue2);
                            }
                            final MutableInteractionSource mutableInteractionSource2 = (MutableInteractionSource) rememberedValue2;
                            startRestartGroup.endReplaceableGroup();
                            composer2 = startRestartGroup;
                            RangeSlider(closedFloatingPointRange3, function12, modifier3, z3, closedFloatingPointRange6, function03, null, mutableInteractionSource, mutableInteractionSource2, ComposableLambdaKt.composableLambda(startRestartGroup, -811582901, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState, Composer composer3, Integer num) {
                                    invoke(rangeSliderState, composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(RangeSliderState rangeSliderState, Composer composer3, int i17) {
                                    ComposerKt.sourceInformation(composer3, "C431@18841L147:Slider.kt#uh7d8r");
                                    if ((i17 & 17) != 16 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-811582901, i17, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:431)");
                                        }
                                        SliderDefaults.INSTANCE.m2524Thumb9LiSoMs(MutableInteractionSource.this, null, sliderColors2, z3, 0L, composer3, 196614, 18);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), ComposableLambdaKt.composableLambda(startRestartGroup, -1832060001, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState, Composer composer3, Integer num) {
                                    invoke(rangeSliderState, composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(RangeSliderState rangeSliderState, Composer composer3, int i17) {
                                    ComposerKt.sourceInformation(composer3, "C438@19048L145:Slider.kt#uh7d8r");
                                    if ((i17 & 17) != 16 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1832060001, i17, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:438)");
                                        }
                                        SliderDefaults.INSTANCE.m2524Thumb9LiSoMs(MutableInteractionSource.this, null, sliderColors2, z3, 0L, composer3, 196614, 18);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), ComposableLambdaKt.composableLambda(startRestartGroup, 377064480, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState, Composer composer3, Integer num) {
                                    invoke(rangeSliderState, composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(RangeSliderState rangeSliderState, Composer composer3, int i17) {
                                    ComposerKt.sourceInformation(composer3, "C445@19270L140:Slider.kt#uh7d8r");
                                    if ((i17 & 6) == 0) {
                                        i17 |= composer3.changed(rangeSliderState) ? 4 : 2;
                                    }
                                    if ((i17 & 19) != 18 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(377064480, i17, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:445)");
                                        }
                                        SliderDefaults.INSTANCE.Track(rangeSliderState, (Modifier) null, SliderColors.this, z3, composer3, (i17 & 14) | 24576, 2);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), i10, composer2, (i11 & 14) | 918552576 | (i11 & 112) | (i11 & 896) | (i11 & 7168) | (57344 & i11) | ((i11 >> 3) & 458752), ((i11 >> 9) & 896) | 54, 64);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            sliderColors3 = sliderColors2;
                            modifier4 = modifier3;
                            z4 = z3;
                            closedFloatingPointRange5 = closedFloatingPointRange6;
                            function04 = function03;
                            i12 = i10;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            sliderColors3 = sliderColors;
                            composer2 = startRestartGroup;
                            modifier4 = modifier2;
                            z4 = z2;
                            closedFloatingPointRange5 = closedFloatingPointRange4;
                            i12 = i7;
                            function04 = function02;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$4
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
                                    SliderKt.RangeSlider(closedFloatingPointRange, function1, modifier4, z4, closedFloatingPointRange5, i12, function04, sliderColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    function02 = function0;
                    if ((i2 & 12582912) == 0) {
                    }
                    int i162 = i4;
                    if ((i4 & 4793491) == 4793490) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                    }
                    if (i15 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i3 & 16) != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if ((i3 & 128) != 0) {
                    }
                    z3 = z2;
                    i10 = i7;
                    function03 = function02;
                    modifier3 = companion;
                    i11 = i9;
                    ClosedFloatingPointRange<Float> closedFloatingPointRange62 = closedFloatingPointRange4;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.startReplaceableGroup(-223513570);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    }
                    final MutableInteractionSource mutableInteractionSource3 = (MutableInteractionSource) rememberedValue;
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.startReplaceableGroup(-223513473);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    }
                    final MutableInteractionSource mutableInteractionSource22 = (MutableInteractionSource) rememberedValue2;
                    startRestartGroup.endReplaceableGroup();
                    composer2 = startRestartGroup;
                    RangeSlider(closedFloatingPointRange3, function12, modifier3, z3, closedFloatingPointRange62, function03, null, mutableInteractionSource3, mutableInteractionSource22, ComposableLambdaKt.composableLambda(startRestartGroup, -811582901, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState, Composer composer3, Integer num) {
                            invoke(rangeSliderState, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(RangeSliderState rangeSliderState, Composer composer3, int i17) {
                            ComposerKt.sourceInformation(composer3, "C431@18841L147:Slider.kt#uh7d8r");
                            if ((i17 & 17) != 16 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-811582901, i17, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:431)");
                                }
                                SliderDefaults.INSTANCE.m2524Thumb9LiSoMs(MutableInteractionSource.this, null, sliderColors2, z3, 0L, composer3, 196614, 18);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), ComposableLambdaKt.composableLambda(startRestartGroup, -1832060001, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState, Composer composer3, Integer num) {
                            invoke(rangeSliderState, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(RangeSliderState rangeSliderState, Composer composer3, int i17) {
                            ComposerKt.sourceInformation(composer3, "C438@19048L145:Slider.kt#uh7d8r");
                            if ((i17 & 17) != 16 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1832060001, i17, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:438)");
                                }
                                SliderDefaults.INSTANCE.m2524Thumb9LiSoMs(MutableInteractionSource.this, null, sliderColors2, z3, 0L, composer3, 196614, 18);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), ComposableLambdaKt.composableLambda(startRestartGroup, 377064480, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState, Composer composer3, Integer num) {
                            invoke(rangeSliderState, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(RangeSliderState rangeSliderState, Composer composer3, int i17) {
                            ComposerKt.sourceInformation(composer3, "C445@19270L140:Slider.kt#uh7d8r");
                            if ((i17 & 6) == 0) {
                                i17 |= composer3.changed(rangeSliderState) ? 4 : 2;
                            }
                            if ((i17 & 19) != 18 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(377064480, i17, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:445)");
                                }
                                SliderDefaults.INSTANCE.Track(rangeSliderState, (Modifier) null, SliderColors.this, z3, composer3, (i17 & 14) | 24576, 2);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), i10, composer2, (i11 & 14) | 918552576 | (i11 & 112) | (i11 & 896) | (i11 & 7168) | (57344 & i11) | ((i11 >> 3) & 458752), ((i11 >> 9) & 896) | 54, 64);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    sliderColors3 = sliderColors2;
                    modifier4 = modifier3;
                    z4 = z3;
                    closedFloatingPointRange5 = closedFloatingPointRange62;
                    function04 = function03;
                    i12 = i10;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i7 = i;
                i8 = i3 & 64;
                if (i8 == 0) {
                }
                function02 = function0;
                if ((i2 & 12582912) == 0) {
                }
                int i1622 = i4;
                if ((i4 & 4793491) == 4793490) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i15 != 0) {
                }
                if (i5 != 0) {
                }
                if ((i3 & 16) != 0) {
                }
                if (i6 != 0) {
                }
                if (i8 != 0) {
                }
                if ((i3 & 128) != 0) {
                }
                z3 = z2;
                i10 = i7;
                function03 = function02;
                modifier3 = companion;
                i11 = i9;
                ClosedFloatingPointRange<Float> closedFloatingPointRange622 = closedFloatingPointRange4;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceableGroup(-223513570);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                }
                final MutableInteractionSource mutableInteractionSource32 = (MutableInteractionSource) rememberedValue;
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(-223513473);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                }
                final MutableInteractionSource mutableInteractionSource222 = (MutableInteractionSource) rememberedValue2;
                startRestartGroup.endReplaceableGroup();
                composer2 = startRestartGroup;
                RangeSlider(closedFloatingPointRange3, function12, modifier3, z3, closedFloatingPointRange622, function03, null, mutableInteractionSource32, mutableInteractionSource222, ComposableLambdaKt.composableLambda(startRestartGroup, -811582901, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState, Composer composer3, Integer num) {
                        invoke(rangeSliderState, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RangeSliderState rangeSliderState, Composer composer3, int i17) {
                        ComposerKt.sourceInformation(composer3, "C431@18841L147:Slider.kt#uh7d8r");
                        if ((i17 & 17) != 16 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-811582901, i17, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:431)");
                            }
                            SliderDefaults.INSTANCE.m2524Thumb9LiSoMs(MutableInteractionSource.this, null, sliderColors2, z3, 0L, composer3, 196614, 18);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), ComposableLambdaKt.composableLambda(startRestartGroup, -1832060001, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState, Composer composer3, Integer num) {
                        invoke(rangeSliderState, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RangeSliderState rangeSliderState, Composer composer3, int i17) {
                        ComposerKt.sourceInformation(composer3, "C438@19048L145:Slider.kt#uh7d8r");
                        if ((i17 & 17) != 16 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1832060001, i17, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:438)");
                            }
                            SliderDefaults.INSTANCE.m2524Thumb9LiSoMs(MutableInteractionSource.this, null, sliderColors2, z3, 0L, composer3, 196614, 18);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), ComposableLambdaKt.composableLambda(startRestartGroup, 377064480, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState, Composer composer3, Integer num) {
                        invoke(rangeSliderState, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RangeSliderState rangeSliderState, Composer composer3, int i17) {
                        ComposerKt.sourceInformation(composer3, "C445@19270L140:Slider.kt#uh7d8r");
                        if ((i17 & 6) == 0) {
                            i17 |= composer3.changed(rangeSliderState) ? 4 : 2;
                        }
                        if ((i17 & 19) != 18 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(377064480, i17, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:445)");
                            }
                            SliderDefaults.INSTANCE.Track(rangeSliderState, (Modifier) null, SliderColors.this, z3, composer3, (i17 & 14) | 24576, 2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), i10, composer2, (i11 & 14) | 918552576 | (i11 & 112) | (i11 & 896) | (i11 & 7168) | (57344 & i11) | ((i11 >> 3) & 458752), ((i11 >> 9) & 896) | 54, 64);
                if (ComposerKt.isTraceInProgress()) {
                }
                sliderColors3 = sliderColors2;
                modifier4 = modifier3;
                z4 = z3;
                closedFloatingPointRange5 = closedFloatingPointRange622;
                function04 = function03;
                i12 = i10;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z2 = z;
            if ((i2 & 24576) == 0) {
            }
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            i7 = i;
            i8 = i3 & 64;
            if (i8 == 0) {
            }
            function02 = function0;
            if ((i2 & 12582912) == 0) {
            }
            int i16222 = i4;
            if ((i4 & 4793491) == 4793490) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i15 != 0) {
            }
            if (i5 != 0) {
            }
            if ((i3 & 16) != 0) {
            }
            if (i6 != 0) {
            }
            if (i8 != 0) {
            }
            if ((i3 & 128) != 0) {
            }
            z3 = z2;
            i10 = i7;
            function03 = function02;
            modifier3 = companion;
            i11 = i9;
            ClosedFloatingPointRange<Float> closedFloatingPointRange6222 = closedFloatingPointRange4;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(-223513570);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            final MutableInteractionSource mutableInteractionSource322 = (MutableInteractionSource) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-223513473);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            }
            final MutableInteractionSource mutableInteractionSource2222 = (MutableInteractionSource) rememberedValue2;
            startRestartGroup.endReplaceableGroup();
            composer2 = startRestartGroup;
            RangeSlider(closedFloatingPointRange3, function12, modifier3, z3, closedFloatingPointRange6222, function03, null, mutableInteractionSource322, mutableInteractionSource2222, ComposableLambdaKt.composableLambda(startRestartGroup, -811582901, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState, Composer composer3, Integer num) {
                    invoke(rangeSliderState, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RangeSliderState rangeSliderState, Composer composer3, int i17) {
                    ComposerKt.sourceInformation(composer3, "C431@18841L147:Slider.kt#uh7d8r");
                    if ((i17 & 17) != 16 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-811582901, i17, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:431)");
                        }
                        SliderDefaults.INSTANCE.m2524Thumb9LiSoMs(MutableInteractionSource.this, null, sliderColors2, z3, 0L, composer3, 196614, 18);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), ComposableLambdaKt.composableLambda(startRestartGroup, -1832060001, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState, Composer composer3, Integer num) {
                    invoke(rangeSliderState, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RangeSliderState rangeSliderState, Composer composer3, int i17) {
                    ComposerKt.sourceInformation(composer3, "C438@19048L145:Slider.kt#uh7d8r");
                    if ((i17 & 17) != 16 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1832060001, i17, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:438)");
                        }
                        SliderDefaults.INSTANCE.m2524Thumb9LiSoMs(MutableInteractionSource.this, null, sliderColors2, z3, 0L, composer3, 196614, 18);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), ComposableLambdaKt.composableLambda(startRestartGroup, 377064480, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState, Composer composer3, Integer num) {
                    invoke(rangeSliderState, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RangeSliderState rangeSliderState, Composer composer3, int i17) {
                    ComposerKt.sourceInformation(composer3, "C445@19270L140:Slider.kt#uh7d8r");
                    if ((i17 & 6) == 0) {
                        i17 |= composer3.changed(rangeSliderState) ? 4 : 2;
                    }
                    if ((i17 & 19) != 18 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(377064480, i17, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:445)");
                        }
                        SliderDefaults.INSTANCE.Track(rangeSliderState, (Modifier) null, SliderColors.this, z3, composer3, (i17 & 14) | 24576, 2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), i10, composer2, (i11 & 14) | 918552576 | (i11 & 112) | (i11 & 896) | (i11 & 7168) | (57344 & i11) | ((i11 >> 3) & 458752), ((i11 >> 9) & 896) | 54, 64);
            if (ComposerKt.isTraceInProgress()) {
            }
            sliderColors3 = sliderColors2;
            modifier4 = modifier3;
            z4 = z3;
            closedFloatingPointRange5 = closedFloatingPointRange6222;
            function04 = function03;
            i12 = i10;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        z2 = z;
        if ((i2 & 24576) == 0) {
        }
        i6 = i3 & 32;
        if (i6 != 0) {
        }
        i7 = i;
        i8 = i3 & 64;
        if (i8 == 0) {
        }
        function02 = function0;
        if ((i2 & 12582912) == 0) {
        }
        int i162222 = i4;
        if ((i4 & 4793491) == 4793490) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i15 != 0) {
        }
        if (i5 != 0) {
        }
        if ((i3 & 16) != 0) {
        }
        if (i6 != 0) {
        }
        if (i8 != 0) {
        }
        if ((i3 & 128) != 0) {
        }
        z3 = z2;
        i10 = i7;
        function03 = function02;
        modifier3 = companion;
        i11 = i9;
        ClosedFloatingPointRange<Float> closedFloatingPointRange62222 = closedFloatingPointRange4;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(-223513570);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        final MutableInteractionSource mutableInteractionSource3222 = (MutableInteractionSource) rememberedValue;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-223513473);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
        }
        final MutableInteractionSource mutableInteractionSource22222 = (MutableInteractionSource) rememberedValue2;
        startRestartGroup.endReplaceableGroup();
        composer2 = startRestartGroup;
        RangeSlider(closedFloatingPointRange3, function12, modifier3, z3, closedFloatingPointRange62222, function03, null, mutableInteractionSource3222, mutableInteractionSource22222, ComposableLambdaKt.composableLambda(startRestartGroup, -811582901, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState, Composer composer3, Integer num) {
                invoke(rangeSliderState, composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(RangeSliderState rangeSliderState, Composer composer3, int i17) {
                ComposerKt.sourceInformation(composer3, "C431@18841L147:Slider.kt#uh7d8r");
                if ((i17 & 17) != 16 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-811582901, i17, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:431)");
                    }
                    SliderDefaults.INSTANCE.m2524Thumb9LiSoMs(MutableInteractionSource.this, null, sliderColors2, z3, 0L, composer3, 196614, 18);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }), ComposableLambdaKt.composableLambda(startRestartGroup, -1832060001, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState, Composer composer3, Integer num) {
                invoke(rangeSliderState, composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(RangeSliderState rangeSliderState, Composer composer3, int i17) {
                ComposerKt.sourceInformation(composer3, "C438@19048L145:Slider.kt#uh7d8r");
                if ((i17 & 17) != 16 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1832060001, i17, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:438)");
                    }
                    SliderDefaults.INSTANCE.m2524Thumb9LiSoMs(MutableInteractionSource.this, null, sliderColors2, z3, 0L, composer3, 196614, 18);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }), ComposableLambdaKt.composableLambda(startRestartGroup, 377064480, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState, Composer composer3, Integer num) {
                invoke(rangeSliderState, composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(RangeSliderState rangeSliderState, Composer composer3, int i17) {
                ComposerKt.sourceInformation(composer3, "C445@19270L140:Slider.kt#uh7d8r");
                if ((i17 & 6) == 0) {
                    i17 |= composer3.changed(rangeSliderState) ? 4 : 2;
                }
                if ((i17 & 19) != 18 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(377064480, i17, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:445)");
                    }
                    SliderDefaults.INSTANCE.Track(rangeSliderState, (Modifier) null, SliderColors.this, z3, composer3, (i17 & 14) | 24576, 2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }), i10, composer2, (i11 & 14) | 918552576 | (i11 & 112) | (i11 & 896) | (i11 & 7168) | (57344 & i11) | ((i11 >> 3) & 458752), ((i11 >> 9) & 896) | 54, 64);
        if (ComposerKt.isTraceInProgress()) {
        }
        sliderColors3 = sliderColors2;
        modifier4 = modifier3;
        z4 = z3;
        closedFloatingPointRange5 = closedFloatingPointRange62222;
        function04 = function03;
        i12 = i10;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x041e  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0386  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void RangeSlider(final ClosedFloatingPointRange<Float> closedFloatingPointRange, final Function1<? super ClosedFloatingPointRange<Float>, Unit> function1, Modifier modifier, boolean z, ClosedFloatingPointRange<Float> closedFloatingPointRange2, Function0<Unit> function0, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function3, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function32, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function33, int i, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        final boolean z2;
        ClosedFloatingPointRange<Float> closedFloatingPointRange3;
        int i7;
        Function0<Unit> function02;
        final SliderColors sliderColors2;
        int i8;
        MutableInteractionSource mutableInteractionSource3;
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
        Modifier.Companion companion;
        final MutableInteractionSource mutableInteractionSource4;
        final MutableInteractionSource mutableInteractionSource5;
        ClosedFloatingPointRange<Float> closedFloatingPointRange4;
        ComposableLambda composableLambda;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function34;
        ComposableLambda composableLambda2;
        boolean z3;
        ComposableLambda composableLambda3;
        int i19;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function35;
        int i20;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function36;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function37;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function38;
        boolean z4;
        Object rememberedValue;
        int i21;
        int i22;
        boolean z5;
        Object rememberedValue2;
        Composer composer2;
        final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function39;
        final Modifier modifier3;
        final MutableInteractionSource mutableInteractionSource6;
        final int i23;
        final SliderColors sliderColors3;
        final MutableInteractionSource mutableInteractionSource7;
        final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function310;
        final ClosedFloatingPointRange<Float> closedFloatingPointRange5;
        final Function0<Unit> function03;
        final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function311;
        final boolean z6;
        ScopeUpdateScope endRestartGroup;
        int i24;
        Composer startRestartGroup = composer.startRestartGroup(-1048796133);
        ComposerKt.sourceInformation(startRestartGroup, "C(RangeSlider)P(11,5,4,1,12,6!1,7!1,8!1,10)517@23109L8,518@23174L39,519@23268L39,544@24060L43,545@24120L252,558@24400L44,562@24537L291:Slider.kt#uh7d8r");
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i5 = (startRestartGroup.changed(closedFloatingPointRange) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i2 & 48) == 0) {
            i5 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i25 = i4 & 4;
        if (i25 != 0) {
            i5 |= 384;
        } else if ((i2 & 384) == 0) {
            modifier2 = modifier;
            i5 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            i6 = i4 & 8;
            if (i6 == 0) {
                i5 |= 3072;
            } else if ((i2 & 3072) == 0) {
                z2 = z;
                i5 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                if ((i2 & 24576) == 0) {
                    if ((i4 & 16) == 0) {
                        closedFloatingPointRange3 = closedFloatingPointRange2;
                        if (startRestartGroup.changed(closedFloatingPointRange3)) {
                            i24 = 16384;
                            i5 |= i24;
                        }
                    } else {
                        closedFloatingPointRange3 = closedFloatingPointRange2;
                    }
                    i24 = 8192;
                    i5 |= i24;
                } else {
                    closedFloatingPointRange3 = closedFloatingPointRange2;
                }
                i7 = i4 & 32;
                if (i7 != 0) {
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    function02 = function0;
                } else {
                    function02 = function0;
                    if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i5 |= startRestartGroup.changedInstance(function02) ? 131072 : 65536;
                    }
                }
                if ((i2 & 1572864) == 0) {
                    sliderColors2 = sliderColors;
                    i5 |= ((i4 & 64) == 0 && startRestartGroup.changed(sliderColors2)) ? 1048576 : 524288;
                } else {
                    sliderColors2 = sliderColors;
                }
                i8 = i4 & 128;
                if (i8 != 0) {
                    i5 |= 12582912;
                    mutableInteractionSource3 = mutableInteractionSource;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                    if ((i2 & 12582912) == 0) {
                        i5 |= startRestartGroup.changed(mutableInteractionSource3) ? 8388608 : 4194304;
                    }
                }
                i9 = i4 & 256;
                if (i9 != 0) {
                    i5 |= 100663296;
                } else if ((i2 & 100663296) == 0) {
                    i10 = i9;
                    i5 |= startRestartGroup.changed(mutableInteractionSource2) ? 67108864 : 33554432;
                    i11 = i4 & 512;
                    if (i11 == 0) {
                        i5 |= C.ENCODING_PCM_32BIT;
                    } else if ((i2 & C.ENCODING_PCM_32BIT) == 0) {
                        i12 = i11;
                        i5 |= startRestartGroup.changedInstance(function3) ? 536870912 : 268435456;
                        i13 = i4 & 1024;
                        if (i13 != 0) {
                            i15 = i3 | 6;
                            i14 = i13;
                        } else if ((i3 & 6) == 0) {
                            i14 = i13;
                            i15 = i3 | (startRestartGroup.changedInstance(function32) ? 4 : 2);
                        } else {
                            i14 = i13;
                            i15 = i3;
                        }
                        i16 = i4 & 2048;
                        if (i16 != 0) {
                            i15 |= 48;
                            i17 = i16;
                        } else if ((i3 & 48) == 0) {
                            i17 = i16;
                            i15 |= startRestartGroup.changedInstance(function33) ? 32 : 16;
                        } else {
                            i17 = i16;
                        }
                        int i26 = i15;
                        i18 = i4 & 4096;
                        if (i18 != 0) {
                            i26 |= 384;
                        } else if ((i3 & 384) == 0) {
                            i26 |= startRestartGroup.changed(i) ? 256 : 128;
                            if ((i5 & 306783379) == 306783378 || (i26 & 147) != 146 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    companion = i25 == 0 ? Modifier.INSTANCE : modifier2;
                                    if (i6 != 0) {
                                        z2 = true;
                                    }
                                    if ((i4 & 16) != 0) {
                                        closedFloatingPointRange3 = RangesKt.rangeTo(0.0f, 1.0f);
                                        i5 &= -57345;
                                    }
                                    if (i7 != 0) {
                                        function02 = null;
                                    }
                                    if ((i4 & 64) != 0) {
                                        sliderColors2 = SliderDefaults.INSTANCE.colors(startRestartGroup, 6);
                                        i5 &= -3670017;
                                    }
                                    if (i8 == 0) {
                                        startRestartGroup.startReplaceableGroup(-223508693);
                                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                                        Object rememberedValue3 = startRestartGroup.rememberedValue();
                                        if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue3 = InteractionSourceKt.MutableInteractionSource();
                                            startRestartGroup.updateRememberedValue(rememberedValue3);
                                        }
                                        mutableInteractionSource4 = (MutableInteractionSource) rememberedValue3;
                                        startRestartGroup.endReplaceableGroup();
                                    } else {
                                        mutableInteractionSource4 = mutableInteractionSource3;
                                    }
                                    if (i10 == 0) {
                                        startRestartGroup.startReplaceableGroup(-223508599);
                                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                                        Object rememberedValue4 = startRestartGroup.rememberedValue();
                                        if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue4 = InteractionSourceKt.MutableInteractionSource();
                                            startRestartGroup.updateRememberedValue(rememberedValue4);
                                        }
                                        mutableInteractionSource5 = (MutableInteractionSource) rememberedValue4;
                                        startRestartGroup.endReplaceableGroup();
                                    } else {
                                        mutableInteractionSource5 = mutableInteractionSource2;
                                    }
                                    if (i12 == 0) {
                                        closedFloatingPointRange4 = closedFloatingPointRange3;
                                        composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, -1963073082, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$7
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState, Composer composer3, Integer num) {
                                                invoke(rangeSliderState, composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(RangeSliderState rangeSliderState, Composer composer3, int i27) {
                                                ComposerKt.sourceInformation(composer3, "C521@23391L131:Slider.kt#uh7d8r");
                                                if ((i27 & 17) != 16 || !composer3.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1963073082, i27, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:521)");
                                                    }
                                                    SliderDefaults.INSTANCE.m2524Thumb9LiSoMs(MutableInteractionSource.this, null, sliderColors2, z2, 0L, composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer3.skipToGroupEnd();
                                            }
                                        });
                                    } else {
                                        closedFloatingPointRange4 = closedFloatingPointRange3;
                                        composableLambda = function3;
                                    }
                                    if (i14 == 0) {
                                        function34 = composableLambda;
                                        composableLambda2 = ComposableLambdaKt.composableLambda(startRestartGroup, 1908709951, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$8
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState, Composer composer3, Integer num) {
                                                invoke(rangeSliderState, composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(RangeSliderState rangeSliderState, Composer composer3, int i27) {
                                                ComposerKt.sourceInformation(composer3, "C528@23610L129:Slider.kt#uh7d8r");
                                                if ((i27 & 17) != 16 || !composer3.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1908709951, i27, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:528)");
                                                    }
                                                    SliderDefaults.INSTANCE.m2524Thumb9LiSoMs(MutableInteractionSource.this, null, sliderColors2, z2, 0L, composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer3.skipToGroupEnd();
                                            }
                                        });
                                    } else {
                                        function34 = composableLambda;
                                        composableLambda2 = function32;
                                    }
                                    if (i17 == 0) {
                                        z3 = z2;
                                        composableLambda3 = ComposableLambdaKt.composableLambda(startRestartGroup, -429193201, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$9
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState, Composer composer3, Integer num) {
                                                invoke(rangeSliderState, composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(RangeSliderState rangeSliderState, Composer composer3, int i27) {
                                                ComposerKt.sourceInformation(composer3, "C535@23844L124:Slider.kt#uh7d8r");
                                                if ((i27 & 6) == 0) {
                                                    i27 |= composer3.changed(rangeSliderState) ? 4 : 2;
                                                }
                                                if ((i27 & 19) != 18 || !composer3.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-429193201, i27, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:535)");
                                                    }
                                                    SliderDefaults.INSTANCE.Track(rangeSliderState, (Modifier) null, SliderColors.this, z2, composer3, (i27 & 14) | 24576, 2);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer3.skipToGroupEnd();
                                            }
                                        });
                                    } else {
                                        z3 = z2;
                                        composableLambda3 = function33;
                                    }
                                    if (i18 == 0) {
                                        function35 = composableLambda3;
                                        i20 = i5;
                                        i19 = 0;
                                    } else {
                                        i19 = i;
                                        function35 = composableLambda3;
                                        i20 = i5;
                                    }
                                    function36 = function34;
                                    function37 = composableLambda2;
                                    closedFloatingPointRange3 = closedFloatingPointRange4;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i4 & 16) != 0) {
                                        i5 &= -57345;
                                    }
                                    if ((i4 & 64) != 0) {
                                        i5 &= -3670017;
                                    }
                                    i19 = i;
                                    z3 = z2;
                                    i20 = i5;
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                    companion = modifier2;
                                    mutableInteractionSource5 = mutableInteractionSource2;
                                    function36 = function3;
                                    function37 = function32;
                                    function35 = function33;
                                }
                                startRestartGroup.endDefaults();
                                Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function312 = function36;
                                if (ComposerKt.isTraceInProgress()) {
                                    function38 = function37;
                                } else {
                                    function38 = function37;
                                    ComposerKt.traceEventStart(-1048796133, i20, i26, "androidx.compose.material3.RangeSlider (Slider.kt:543)");
                                }
                                final State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function02, startRestartGroup, (i20 >> 15) & 14);
                                startRestartGroup.startReplaceableGroup(-223507747);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                                int i27 = i26;
                                z4 = ((i26 & 896) != 256) | ((((57344 & i20) ^ 24576) <= 16384 && startRestartGroup.changed(closedFloatingPointRange3)) || (i20 & 24576) == 16384);
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (!z4 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    i21 = i20;
                                    int i28 = i19;
                                    rememberedValue = new RangeSliderState(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue(), i28, new Function0<Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$state$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
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
                                            Function0<Unit> value = rememberUpdatedState.getValue();
                                            if (value != null) {
                                                value.invoke();
                                            }
                                        }
                                    }, closedFloatingPointRange3);
                                    i22 = i28;
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                } else {
                                    i21 = i20;
                                    i22 = i19;
                                }
                                RangeSliderState rangeSliderState = (RangeSliderState) rememberedValue;
                                startRestartGroup.endReplaceableGroup();
                                startRestartGroup.startReplaceableGroup(-223507467);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                                z5 = (i21 & 112) != 32;
                                rememberedValue2 = startRestartGroup.rememberedValue();
                                if (!z5 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue2 = (Function1) new Function1<SliderRange, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$10$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(SliderRange sliderRange) {
                                            m2532invokeIf1S1O4(sliderRange.m2543unboximpl());
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke-If1S1O4, reason: not valid java name */
                                        public final void m2532invokeIf1S1O4(long j) {
                                            function1.invoke(RangesKt.rangeTo(SliderRange.m2540getStartimpl(j), SliderRange.m2539getEndInclusiveimpl(j)));
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                }
                                startRestartGroup.endReplaceableGroup();
                                rangeSliderState.setOnValueChange$material3_release((Function1) rememberedValue2);
                                rangeSliderState.setActiveRangeStart(closedFloatingPointRange.getStart().floatValue());
                                rangeSliderState.setActiveRangeEnd(closedFloatingPointRange.getEndInclusive().floatValue());
                                int i29 = i21 >> 9;
                                int i30 = ((i21 >> 3) & 1008) | (57344 & i29) | (458752 & i29) | (i29 & 3670016);
                                int i31 = i27 << 21;
                                Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function313 = function35;
                                RangeSlider(rangeSliderState, companion, z3, null, mutableInteractionSource4, mutableInteractionSource5, function312, function38, function313, startRestartGroup, i30 | (29360128 & i31) | (i31 & 234881024), 8);
                                Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function314 = function38;
                                composer2 = startRestartGroup;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                MutableInteractionSource mutableInteractionSource8 = mutableInteractionSource4;
                                function39 = function312;
                                modifier3 = companion;
                                mutableInteractionSource6 = mutableInteractionSource8;
                                i23 = i22;
                                sliderColors3 = sliderColors2;
                                mutableInteractionSource7 = mutableInteractionSource5;
                                function310 = function313;
                                closedFloatingPointRange5 = closedFloatingPointRange3;
                                function03 = function02;
                                function311 = function314;
                                z6 = z3;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                function39 = function3;
                                composer2 = startRestartGroup;
                                z6 = z2;
                                closedFloatingPointRange5 = closedFloatingPointRange3;
                                sliderColors3 = sliderColors2;
                                function03 = function02;
                                mutableInteractionSource6 = mutableInteractionSource3;
                                modifier3 = modifier2;
                                mutableInteractionSource7 = mutableInteractionSource2;
                                function311 = function32;
                                function310 = function33;
                                i23 = i;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$11
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

                                    public final void invoke(Composer composer3, int i32) {
                                        SliderKt.RangeSlider(closedFloatingPointRange, function1, modifier3, z6, closedFloatingPointRange5, function03, sliderColors3, mutableInteractionSource6, mutableInteractionSource7, function39, function311, function310, i23, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if ((i5 & 306783379) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                        }
                        if (i25 == 0) {
                        }
                        if (i6 != 0) {
                        }
                        if ((i4 & 16) != 0) {
                        }
                        if (i7 != 0) {
                        }
                        if ((i4 & 64) != 0) {
                        }
                        if (i8 == 0) {
                        }
                        if (i10 == 0) {
                        }
                        if (i12 == 0) {
                        }
                        if (i14 == 0) {
                        }
                        if (i17 == 0) {
                        }
                        if (i18 == 0) {
                        }
                        function36 = function34;
                        function37 = composableLambda2;
                        closedFloatingPointRange3 = closedFloatingPointRange4;
                        startRestartGroup.endDefaults();
                        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function3122 = function36;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        final State<? extends Function0<Unit>> rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function02, startRestartGroup, (i20 >> 15) & 14);
                        startRestartGroup.startReplaceableGroup(-223507747);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                        int i272 = i26;
                        z4 = ((i26 & 896) != 256) | ((((57344 & i20) ^ 24576) <= 16384 && startRestartGroup.changed(closedFloatingPointRange3)) || (i20 & 24576) == 16384);
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (z4) {
                        }
                        i21 = i20;
                        int i282 = i19;
                        rememberedValue = new RangeSliderState(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue(), i282, new Function0<Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$state$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
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
                                Function0<Unit> value = rememberUpdatedState2.getValue();
                                if (value != null) {
                                    value.invoke();
                                }
                            }
                        }, closedFloatingPointRange3);
                        i22 = i282;
                        startRestartGroup.updateRememberedValue(rememberedValue);
                        RangeSliderState rangeSliderState2 = (RangeSliderState) rememberedValue;
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.startReplaceableGroup(-223507467);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                        if ((i21 & 112) != 32) {
                        }
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (!z5) {
                        }
                        rememberedValue2 = (Function1) new Function1<SliderRange, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$10$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SliderRange sliderRange) {
                                m2532invokeIf1S1O4(sliderRange.m2543unboximpl());
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke-If1S1O4, reason: not valid java name */
                            public final void m2532invokeIf1S1O4(long j) {
                                function1.invoke(RangesKt.rangeTo(SliderRange.m2540getStartimpl(j), SliderRange.m2539getEndInclusiveimpl(j)));
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                        startRestartGroup.endReplaceableGroup();
                        rangeSliderState2.setOnValueChange$material3_release((Function1) rememberedValue2);
                        rangeSliderState2.setActiveRangeStart(closedFloatingPointRange.getStart().floatValue());
                        rangeSliderState2.setActiveRangeEnd(closedFloatingPointRange.getEndInclusive().floatValue());
                        int i292 = i21 >> 9;
                        int i302 = ((i21 >> 3) & 1008) | (57344 & i292) | (458752 & i292) | (i292 & 3670016);
                        int i312 = i272 << 21;
                        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function3132 = function35;
                        RangeSlider(rangeSliderState2, companion, z3, null, mutableInteractionSource4, mutableInteractionSource5, function3122, function38, function3132, startRestartGroup, i302 | (29360128 & i312) | (i312 & 234881024), 8);
                        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function3142 = function38;
                        composer2 = startRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        MutableInteractionSource mutableInteractionSource82 = mutableInteractionSource4;
                        function39 = function3122;
                        modifier3 = companion;
                        mutableInteractionSource6 = mutableInteractionSource82;
                        i23 = i22;
                        sliderColors3 = sliderColors2;
                        mutableInteractionSource7 = mutableInteractionSource5;
                        function310 = function3132;
                        closedFloatingPointRange5 = closedFloatingPointRange3;
                        function03 = function02;
                        function311 = function3142;
                        z6 = z3;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i12 = i11;
                    i13 = i4 & 1024;
                    if (i13 != 0) {
                    }
                    i16 = i4 & 2048;
                    if (i16 != 0) {
                    }
                    int i262 = i15;
                    i18 = i4 & 4096;
                    if (i18 != 0) {
                    }
                    if ((i5 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                    }
                    if (i25 == 0) {
                    }
                    if (i6 != 0) {
                    }
                    if ((i4 & 16) != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if ((i4 & 64) != 0) {
                    }
                    if (i8 == 0) {
                    }
                    if (i10 == 0) {
                    }
                    if (i12 == 0) {
                    }
                    if (i14 == 0) {
                    }
                    if (i17 == 0) {
                    }
                    if (i18 == 0) {
                    }
                    function36 = function34;
                    function37 = composableLambda2;
                    closedFloatingPointRange3 = closedFloatingPointRange4;
                    startRestartGroup.endDefaults();
                    Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function31222 = function36;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    final State<? extends Function0<Unit>> rememberUpdatedState22 = SnapshotStateKt.rememberUpdatedState(function02, startRestartGroup, (i20 >> 15) & 14);
                    startRestartGroup.startReplaceableGroup(-223507747);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                    int i2722 = i262;
                    z4 = ((i262 & 896) != 256) | ((((57344 & i20) ^ 24576) <= 16384 && startRestartGroup.changed(closedFloatingPointRange3)) || (i20 & 24576) == 16384);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (z4) {
                    }
                    i21 = i20;
                    int i2822 = i19;
                    rememberedValue = new RangeSliderState(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue(), i2822, new Function0<Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$state$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
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
                            Function0<Unit> value = rememberUpdatedState22.getValue();
                            if (value != null) {
                                value.invoke();
                            }
                        }
                    }, closedFloatingPointRange3);
                    i22 = i2822;
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    RangeSliderState rangeSliderState22 = (RangeSliderState) rememberedValue;
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.startReplaceableGroup(-223507467);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                    if ((i21 & 112) != 32) {
                    }
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (!z5) {
                    }
                    rememberedValue2 = (Function1) new Function1<SliderRange, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$10$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SliderRange sliderRange) {
                            m2532invokeIf1S1O4(sliderRange.m2543unboximpl());
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke-If1S1O4, reason: not valid java name */
                        public final void m2532invokeIf1S1O4(long j) {
                            function1.invoke(RangesKt.rangeTo(SliderRange.m2540getStartimpl(j), SliderRange.m2539getEndInclusiveimpl(j)));
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                    startRestartGroup.endReplaceableGroup();
                    rangeSliderState22.setOnValueChange$material3_release((Function1) rememberedValue2);
                    rangeSliderState22.setActiveRangeStart(closedFloatingPointRange.getStart().floatValue());
                    rangeSliderState22.setActiveRangeEnd(closedFloatingPointRange.getEndInclusive().floatValue());
                    int i2922 = i21 >> 9;
                    int i3022 = ((i21 >> 3) & 1008) | (57344 & i2922) | (458752 & i2922) | (i2922 & 3670016);
                    int i3122 = i2722 << 21;
                    Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function31322 = function35;
                    RangeSlider(rangeSliderState22, companion, z3, null, mutableInteractionSource4, mutableInteractionSource5, function31222, function38, function31322, startRestartGroup, i3022 | (29360128 & i3122) | (i3122 & 234881024), 8);
                    Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function31422 = function38;
                    composer2 = startRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    MutableInteractionSource mutableInteractionSource822 = mutableInteractionSource4;
                    function39 = function31222;
                    modifier3 = companion;
                    mutableInteractionSource6 = mutableInteractionSource822;
                    i23 = i22;
                    sliderColors3 = sliderColors2;
                    mutableInteractionSource7 = mutableInteractionSource5;
                    function310 = function31322;
                    closedFloatingPointRange5 = closedFloatingPointRange3;
                    function03 = function02;
                    function311 = function31422;
                    z6 = z3;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                i10 = i9;
                i11 = i4 & 512;
                if (i11 == 0) {
                }
                i12 = i11;
                i13 = i4 & 1024;
                if (i13 != 0) {
                }
                i16 = i4 & 2048;
                if (i16 != 0) {
                }
                int i2622 = i15;
                i18 = i4 & 4096;
                if (i18 != 0) {
                }
                if ((i5 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i25 == 0) {
                }
                if (i6 != 0) {
                }
                if ((i4 & 16) != 0) {
                }
                if (i7 != 0) {
                }
                if ((i4 & 64) != 0) {
                }
                if (i8 == 0) {
                }
                if (i10 == 0) {
                }
                if (i12 == 0) {
                }
                if (i14 == 0) {
                }
                if (i17 == 0) {
                }
                if (i18 == 0) {
                }
                function36 = function34;
                function37 = composableLambda2;
                closedFloatingPointRange3 = closedFloatingPointRange4;
                startRestartGroup.endDefaults();
                Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function312222 = function36;
                if (ComposerKt.isTraceInProgress()) {
                }
                final State<? extends Function0<Unit>> rememberUpdatedState222 = SnapshotStateKt.rememberUpdatedState(function02, startRestartGroup, (i20 >> 15) & 14);
                startRestartGroup.startReplaceableGroup(-223507747);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                int i27222 = i2622;
                z4 = ((i2622 & 896) != 256) | ((((57344 & i20) ^ 24576) <= 16384 && startRestartGroup.changed(closedFloatingPointRange3)) || (i20 & 24576) == 16384);
                rememberedValue = startRestartGroup.rememberedValue();
                if (z4) {
                }
                i21 = i20;
                int i28222 = i19;
                rememberedValue = new RangeSliderState(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue(), i28222, new Function0<Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$state$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
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
                        Function0<Unit> value = rememberUpdatedState222.getValue();
                        if (value != null) {
                            value.invoke();
                        }
                    }
                }, closedFloatingPointRange3);
                i22 = i28222;
                startRestartGroup.updateRememberedValue(rememberedValue);
                RangeSliderState rangeSliderState222 = (RangeSliderState) rememberedValue;
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(-223507467);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                if ((i21 & 112) != 32) {
                }
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!z5) {
                }
                rememberedValue2 = (Function1) new Function1<SliderRange, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$10$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SliderRange sliderRange) {
                        m2532invokeIf1S1O4(sliderRange.m2543unboximpl());
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke-If1S1O4, reason: not valid java name */
                    public final void m2532invokeIf1S1O4(long j) {
                        function1.invoke(RangesKt.rangeTo(SliderRange.m2540getStartimpl(j), SliderRange.m2539getEndInclusiveimpl(j)));
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
                startRestartGroup.endReplaceableGroup();
                rangeSliderState222.setOnValueChange$material3_release((Function1) rememberedValue2);
                rangeSliderState222.setActiveRangeStart(closedFloatingPointRange.getStart().floatValue());
                rangeSliderState222.setActiveRangeEnd(closedFloatingPointRange.getEndInclusive().floatValue());
                int i29222 = i21 >> 9;
                int i30222 = ((i21 >> 3) & 1008) | (57344 & i29222) | (458752 & i29222) | (i29222 & 3670016);
                int i31222 = i27222 << 21;
                Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function313222 = function35;
                RangeSlider(rangeSliderState222, companion, z3, null, mutableInteractionSource4, mutableInteractionSource5, function312222, function38, function313222, startRestartGroup, i30222 | (29360128 & i31222) | (i31222 & 234881024), 8);
                Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function314222 = function38;
                composer2 = startRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                }
                MutableInteractionSource mutableInteractionSource8222 = mutableInteractionSource4;
                function39 = function312222;
                modifier3 = companion;
                mutableInteractionSource6 = mutableInteractionSource8222;
                i23 = i22;
                sliderColors3 = sliderColors2;
                mutableInteractionSource7 = mutableInteractionSource5;
                function310 = function313222;
                closedFloatingPointRange5 = closedFloatingPointRange3;
                function03 = function02;
                function311 = function314222;
                z6 = z3;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z2 = z;
            if ((i2 & 24576) == 0) {
            }
            i7 = i4 & 32;
            if (i7 != 0) {
            }
            if ((i2 & 1572864) == 0) {
            }
            i8 = i4 & 128;
            if (i8 != 0) {
            }
            i9 = i4 & 256;
            if (i9 != 0) {
            }
            i10 = i9;
            i11 = i4 & 512;
            if (i11 == 0) {
            }
            i12 = i11;
            i13 = i4 & 1024;
            if (i13 != 0) {
            }
            i16 = i4 & 2048;
            if (i16 != 0) {
            }
            int i26222 = i15;
            i18 = i4 & 4096;
            if (i18 != 0) {
            }
            if ((i5 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i25 == 0) {
            }
            if (i6 != 0) {
            }
            if ((i4 & 16) != 0) {
            }
            if (i7 != 0) {
            }
            if ((i4 & 64) != 0) {
            }
            if (i8 == 0) {
            }
            if (i10 == 0) {
            }
            if (i12 == 0) {
            }
            if (i14 == 0) {
            }
            if (i17 == 0) {
            }
            if (i18 == 0) {
            }
            function36 = function34;
            function37 = composableLambda2;
            closedFloatingPointRange3 = closedFloatingPointRange4;
            startRestartGroup.endDefaults();
            Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function3122222 = function36;
            if (ComposerKt.isTraceInProgress()) {
            }
            final State<? extends Function0<Unit>> rememberUpdatedState2222 = SnapshotStateKt.rememberUpdatedState(function02, startRestartGroup, (i20 >> 15) & 14);
            startRestartGroup.startReplaceableGroup(-223507747);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
            int i272222 = i26222;
            z4 = ((i26222 & 896) != 256) | ((((57344 & i20) ^ 24576) <= 16384 && startRestartGroup.changed(closedFloatingPointRange3)) || (i20 & 24576) == 16384);
            rememberedValue = startRestartGroup.rememberedValue();
            if (z4) {
            }
            i21 = i20;
            int i282222 = i19;
            rememberedValue = new RangeSliderState(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue(), i282222, new Function0<Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$state$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
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
                    Function0<Unit> value = rememberUpdatedState2222.getValue();
                    if (value != null) {
                        value.invoke();
                    }
                }
            }, closedFloatingPointRange3);
            i22 = i282222;
            startRestartGroup.updateRememberedValue(rememberedValue);
            RangeSliderState rangeSliderState2222 = (RangeSliderState) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-223507467);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
            if ((i21 & 112) != 32) {
            }
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!z5) {
            }
            rememberedValue2 = (Function1) new Function1<SliderRange, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$10$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SliderRange sliderRange) {
                    m2532invokeIf1S1O4(sliderRange.m2543unboximpl());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-If1S1O4, reason: not valid java name */
                public final void m2532invokeIf1S1O4(long j) {
                    function1.invoke(RangesKt.rangeTo(SliderRange.m2540getStartimpl(j), SliderRange.m2539getEndInclusiveimpl(j)));
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue2);
            startRestartGroup.endReplaceableGroup();
            rangeSliderState2222.setOnValueChange$material3_release((Function1) rememberedValue2);
            rangeSliderState2222.setActiveRangeStart(closedFloatingPointRange.getStart().floatValue());
            rangeSliderState2222.setActiveRangeEnd(closedFloatingPointRange.getEndInclusive().floatValue());
            int i292222 = i21 >> 9;
            int i302222 = ((i21 >> 3) & 1008) | (57344 & i292222) | (458752 & i292222) | (i292222 & 3670016);
            int i312222 = i272222 << 21;
            Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function3132222 = function35;
            RangeSlider(rangeSliderState2222, companion, z3, null, mutableInteractionSource4, mutableInteractionSource5, function3122222, function38, function3132222, startRestartGroup, i302222 | (29360128 & i312222) | (i312222 & 234881024), 8);
            Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function3142222 = function38;
            composer2 = startRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
            }
            MutableInteractionSource mutableInteractionSource82222 = mutableInteractionSource4;
            function39 = function3122222;
            modifier3 = companion;
            mutableInteractionSource6 = mutableInteractionSource82222;
            i23 = i22;
            sliderColors3 = sliderColors2;
            mutableInteractionSource7 = mutableInteractionSource5;
            function310 = function3132222;
            closedFloatingPointRange5 = closedFloatingPointRange3;
            function03 = function02;
            function311 = function3142222;
            z6 = z3;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 8;
        if (i6 == 0) {
        }
        z2 = z;
        if ((i2 & 24576) == 0) {
        }
        i7 = i4 & 32;
        if (i7 != 0) {
        }
        if ((i2 & 1572864) == 0) {
        }
        i8 = i4 & 128;
        if (i8 != 0) {
        }
        i9 = i4 & 256;
        if (i9 != 0) {
        }
        i10 = i9;
        i11 = i4 & 512;
        if (i11 == 0) {
        }
        i12 = i11;
        i13 = i4 & 1024;
        if (i13 != 0) {
        }
        i16 = i4 & 2048;
        if (i16 != 0) {
        }
        int i262222 = i15;
        i18 = i4 & 4096;
        if (i18 != 0) {
        }
        if ((i5 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i25 == 0) {
        }
        if (i6 != 0) {
        }
        if ((i4 & 16) != 0) {
        }
        if (i7 != 0) {
        }
        if ((i4 & 64) != 0) {
        }
        if (i8 == 0) {
        }
        if (i10 == 0) {
        }
        if (i12 == 0) {
        }
        if (i14 == 0) {
        }
        if (i17 == 0) {
        }
        if (i18 == 0) {
        }
        function36 = function34;
        function37 = composableLambda2;
        closedFloatingPointRange3 = closedFloatingPointRange4;
        startRestartGroup.endDefaults();
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function31222222 = function36;
        if (ComposerKt.isTraceInProgress()) {
        }
        final State<? extends Function0<Unit>> rememberUpdatedState22222 = SnapshotStateKt.rememberUpdatedState(function02, startRestartGroup, (i20 >> 15) & 14);
        startRestartGroup.startReplaceableGroup(-223507747);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
        int i2722222 = i262222;
        z4 = ((i262222 & 896) != 256) | ((((57344 & i20) ^ 24576) <= 16384 && startRestartGroup.changed(closedFloatingPointRange3)) || (i20 & 24576) == 16384);
        rememberedValue = startRestartGroup.rememberedValue();
        if (z4) {
        }
        i21 = i20;
        int i2822222 = i19;
        rememberedValue = new RangeSliderState(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue(), i2822222, new Function0<Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$state$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                Function0<Unit> value = rememberUpdatedState22222.getValue();
                if (value != null) {
                    value.invoke();
                }
            }
        }, closedFloatingPointRange3);
        i22 = i2822222;
        startRestartGroup.updateRememberedValue(rememberedValue);
        RangeSliderState rangeSliderState22222 = (RangeSliderState) rememberedValue;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-223507467);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
        if ((i21 & 112) != 32) {
        }
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!z5) {
        }
        rememberedValue2 = (Function1) new Function1<SliderRange, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$10$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SliderRange sliderRange) {
                m2532invokeIf1S1O4(sliderRange.m2543unboximpl());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-If1S1O4, reason: not valid java name */
            public final void m2532invokeIf1S1O4(long j) {
                function1.invoke(RangesKt.rangeTo(SliderRange.m2540getStartimpl(j), SliderRange.m2539getEndInclusiveimpl(j)));
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue2);
        startRestartGroup.endReplaceableGroup();
        rangeSliderState22222.setOnValueChange$material3_release((Function1) rememberedValue2);
        rangeSliderState22222.setActiveRangeStart(closedFloatingPointRange.getStart().floatValue());
        rangeSliderState22222.setActiveRangeEnd(closedFloatingPointRange.getEndInclusive().floatValue());
        int i2922222 = i21 >> 9;
        int i3022222 = ((i21 >> 3) & 1008) | (57344 & i2922222) | (458752 & i2922222) | (i2922222 & 3670016);
        int i3122222 = i2722222 << 21;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function31322222 = function35;
        RangeSlider(rangeSliderState22222, companion, z3, null, mutableInteractionSource4, mutableInteractionSource5, function31222222, function38, function31322222, startRestartGroup, i3022222 | (29360128 & i3122222) | (i3122222 & 234881024), 8);
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function31422222 = function38;
        composer2 = startRestartGroup;
        if (ComposerKt.isTraceInProgress()) {
        }
        MutableInteractionSource mutableInteractionSource822222 = mutableInteractionSource4;
        function39 = function31222222;
        modifier3 = companion;
        mutableInteractionSource6 = mutableInteractionSource822222;
        i23 = i22;
        sliderColors3 = sliderColors2;
        mutableInteractionSource7 = mutableInteractionSource5;
        function310 = function31322222;
        closedFloatingPointRange5 = closedFloatingPointRange3;
        function03 = function02;
        function311 = function31422222;
        z6 = z3;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void RangeSlider(final RangeSliderState rangeSliderState, Modifier modifier, boolean z, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function3, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function32, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function33, Composer composer, final int i, final int i2) {
        RangeSliderState rangeSliderState2;
        int i3;
        Modifier modifier2;
        int i4;
        final boolean z2;
        final SliderColors sliderColors2;
        int i5;
        MutableInteractionSource mutableInteractionSource3;
        int i6;
        final MutableInteractionSource mutableInteractionSource4;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        final MutableInteractionSource mutableInteractionSource5;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> composableLambda;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function34;
        Modifier modifier3;
        MutableInteractionSource mutableInteractionSource6;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function35;
        Composer composer2;
        final SliderColors sliderColors3;
        final Modifier modifier4;
        final boolean z3;
        final MutableInteractionSource mutableInteractionSource7;
        final MutableInteractionSource mutableInteractionSource8;
        final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function36;
        final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function37;
        final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function38;
        int i12;
        Composer startRestartGroup = composer.startRestartGroup(511405654);
        ComposerKt.sourceInformation(startRestartGroup, "C(RangeSlider)P(7,4,1!1,5!1,6)624@27533L8,625@27598L39,626@27692L39,651@28465L295:Slider.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            rangeSliderState2 = rangeSliderState;
        } else {
            rangeSliderState2 = rangeSliderState;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changed(rangeSliderState2) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i13 = i2 & 2;
        if (i13 != 0) {
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
                        sliderColors2 = sliderColors;
                        if (startRestartGroup.changed(sliderColors2)) {
                            i12 = 2048;
                            i3 |= i12;
                        }
                    } else {
                        sliderColors2 = sliderColors;
                    }
                    i12 = 1024;
                    i3 |= i12;
                } else {
                    sliderColors2 = sliderColors;
                }
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    mutableInteractionSource3 = mutableInteractionSource;
                    i3 |= startRestartGroup.changed(mutableInteractionSource3) ? 16384 : 8192;
                    i6 = i2 & 32;
                    if (i6 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((196608 & i) == 0) {
                        mutableInteractionSource4 = mutableInteractionSource2;
                        i3 |= startRestartGroup.changed(mutableInteractionSource4) ? 131072 : 65536;
                        i7 = i2 & 64;
                        if (i7 != 0) {
                            i3 |= 1572864;
                        } else if ((i & 1572864) == 0) {
                            i3 |= startRestartGroup.changedInstance(function3) ? 1048576 : 524288;
                        }
                        i8 = i2 & 128;
                        if (i8 != 0) {
                            i3 |= 12582912;
                        } else if ((i & 12582912) == 0) {
                            i9 = i8;
                            i3 |= startRestartGroup.changedInstance(function32) ? 8388608 : 4194304;
                            i10 = i2 & 256;
                            if (i10 == 0) {
                                i3 |= 100663296;
                            } else if ((i & 100663296) == 0) {
                                i11 = i10;
                                i3 |= startRestartGroup.changedInstance(function33) ? 67108864 : 33554432;
                                if ((i3 & 38347923) == 38347922 || !startRestartGroup.getSkipping()) {
                                    startRestartGroup.startDefaults();
                                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                        if (i13 != 0) {
                                            modifier2 = Modifier.INSTANCE;
                                        }
                                        if (i4 != 0) {
                                            z2 = true;
                                        }
                                        if ((i2 & 8) != 0) {
                                            i3 &= -7169;
                                            sliderColors2 = SliderDefaults.INSTANCE.colors(startRestartGroup, 6);
                                        }
                                        if (i5 != 0) {
                                            startRestartGroup.startReplaceableGroup(-223504269);
                                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                                            Object rememberedValue = startRestartGroup.rememberedValue();
                                            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                                startRestartGroup.updateRememberedValue(rememberedValue);
                                            }
                                            mutableInteractionSource5 = (MutableInteractionSource) rememberedValue;
                                            startRestartGroup.endReplaceableGroup();
                                        } else {
                                            mutableInteractionSource5 = mutableInteractionSource3;
                                        }
                                        if (i6 != 0) {
                                            startRestartGroup.startReplaceableGroup(-223504175);
                                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                                            Object rememberedValue2 = startRestartGroup.rememberedValue();
                                            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                                                startRestartGroup.updateRememberedValue(rememberedValue2);
                                            }
                                            startRestartGroup.endReplaceableGroup();
                                            mutableInteractionSource4 = (MutableInteractionSource) rememberedValue2;
                                        }
                                        ComposableLambda composableLambda2 = i7 != 0 ? ComposableLambdaKt.composableLambda(startRestartGroup, 1884205643, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$14
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState3, Composer composer3, Integer num) {
                                                invoke(rangeSliderState3, composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(RangeSliderState rangeSliderState3, Composer composer3, int i14) {
                                                ComposerKt.sourceInformation(composer3, "C628@27815L131:Slider.kt#uh7d8r");
                                                if ((i14 & 17) != 16 || !composer3.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1884205643, i14, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:628)");
                                                    }
                                                    SliderDefaults.INSTANCE.m2524Thumb9LiSoMs(MutableInteractionSource.this, null, sliderColors2, z2, 0L, composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer3.skipToGroupEnd();
                                            }
                                        }) : function3;
                                        ComposableLambda composableLambda3 = i9 != 0 ? ComposableLambdaKt.composableLambda(startRestartGroup, 1016457138, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$15
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState3, Composer composer3, Integer num) {
                                                invoke(rangeSliderState3, composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(RangeSliderState rangeSliderState3, Composer composer3, int i14) {
                                                ComposerKt.sourceInformation(composer3, "C635@28034L129:Slider.kt#uh7d8r");
                                                if ((i14 & 17) != 16 || !composer3.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1016457138, i14, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:635)");
                                                    }
                                                    SliderDefaults.INSTANCE.m2524Thumb9LiSoMs(MutableInteractionSource.this, null, sliderColors2, z2, 0L, composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer3.skipToGroupEnd();
                                            }
                                        }) : function32;
                                        composableLambda = i11 != 0 ? ComposableLambdaKt.composableLambda(startRestartGroup, -1617375262, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$16
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState3, Composer composer3, Integer num) {
                                                invoke(rangeSliderState3, composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(RangeSliderState rangeSliderState3, Composer composer3, int i14) {
                                                ComposerKt.sourceInformation(composer3, "C642@28268L124:Slider.kt#uh7d8r");
                                                if ((i14 & 6) == 0) {
                                                    i14 |= composer3.changed(rangeSliderState3) ? 4 : 2;
                                                }
                                                if ((i14 & 19) != 18 || !composer3.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1617375262, i14, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:642)");
                                                    }
                                                    SliderDefaults.INSTANCE.Track(rangeSliderState3, (Modifier) null, SliderColors.this, z2, composer3, (i14 & 14) | 24576, 2);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer3.skipToGroupEnd();
                                            }
                                        }) : function33;
                                        function34 = composableLambda2;
                                        modifier3 = modifier2;
                                        mutableInteractionSource6 = mutableInteractionSource5;
                                        function35 = composableLambda3;
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        if ((i2 & 8) != 0) {
                                            i3 &= -7169;
                                        }
                                        function34 = function3;
                                        function35 = function32;
                                        composableLambda = function33;
                                        modifier3 = modifier2;
                                        mutableInteractionSource6 = mutableInteractionSource3;
                                    }
                                    MutableInteractionSource mutableInteractionSource9 = mutableInteractionSource4;
                                    boolean z4 = z2;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(511405654, i3, -1, "androidx.compose.material3.RangeSlider (Slider.kt:648)");
                                    }
                                    if (rangeSliderState2.getSteps() < 0) {
                                        throw new IllegalArgumentException("steps should be >= 0".toString());
                                    }
                                    int i14 = i3 >> 3;
                                    composer2 = startRestartGroup;
                                    RangeSliderImpl(modifier3, rangeSliderState2, z4, mutableInteractionSource6, mutableInteractionSource9, function34, function35, composableLambda, composer2, (i3 & 896) | (i14 & 14) | ((i3 << 3) & 112) | (i14 & 7168) | (57344 & i14) | (458752 & i14) | (3670016 & i14) | (i14 & 29360128));
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    sliderColors3 = sliderColors2;
                                    modifier4 = modifier3;
                                    z3 = z4;
                                    mutableInteractionSource7 = mutableInteractionSource6;
                                    mutableInteractionSource8 = mutableInteractionSource9;
                                    function36 = function34;
                                    function37 = function35;
                                    function38 = composableLambda;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    function37 = function32;
                                    composer2 = startRestartGroup;
                                    modifier4 = modifier2;
                                    z3 = z2;
                                    sliderColors3 = sliderColors2;
                                    mutableInteractionSource7 = mutableInteractionSource3;
                                    mutableInteractionSource8 = mutableInteractionSource4;
                                    function36 = function3;
                                    function38 = function33;
                                }
                                ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup != null) {
                                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$18
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
                                            SliderKt.RangeSlider(RangeSliderState.this, modifier4, z3, sliderColors3, mutableInteractionSource7, mutableInteractionSource8, function36, function37, function38, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i11 = i10;
                            if ((i3 & 38347923) == 38347922) {
                            }
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                            }
                            if (i13 != 0) {
                            }
                            if (i4 != 0) {
                            }
                            if ((i2 & 8) != 0) {
                            }
                            if (i5 != 0) {
                            }
                            if (i6 != 0) {
                            }
                            if (i7 != 0) {
                            }
                            if (i9 != 0) {
                            }
                            if (i11 != 0) {
                            }
                            function34 = composableLambda2;
                            modifier3 = modifier2;
                            mutableInteractionSource6 = mutableInteractionSource5;
                            function35 = composableLambda3;
                            MutableInteractionSource mutableInteractionSource92 = mutableInteractionSource4;
                            boolean z42 = z2;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            if (rangeSliderState2.getSteps() < 0) {
                            }
                        }
                        i9 = i8;
                        i10 = i2 & 256;
                        if (i10 == 0) {
                        }
                        i11 = i10;
                        if ((i3 & 38347923) == 38347922) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                        }
                        if (i13 != 0) {
                        }
                        if (i4 != 0) {
                        }
                        if ((i2 & 8) != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if (i7 != 0) {
                        }
                        if (i9 != 0) {
                        }
                        if (i11 != 0) {
                        }
                        function34 = composableLambda2;
                        modifier3 = modifier2;
                        mutableInteractionSource6 = mutableInteractionSource5;
                        function35 = composableLambda3;
                        MutableInteractionSource mutableInteractionSource922 = mutableInteractionSource4;
                        boolean z422 = z2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        if (rangeSliderState2.getSteps() < 0) {
                        }
                    }
                    mutableInteractionSource4 = mutableInteractionSource2;
                    i7 = i2 & 64;
                    if (i7 != 0) {
                    }
                    i8 = i2 & 128;
                    if (i8 != 0) {
                    }
                    i9 = i8;
                    i10 = i2 & 256;
                    if (i10 == 0) {
                    }
                    i11 = i10;
                    if ((i3 & 38347923) == 38347922) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i13 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if ((i2 & 8) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i11 != 0) {
                    }
                    function34 = composableLambda2;
                    modifier3 = modifier2;
                    mutableInteractionSource6 = mutableInteractionSource5;
                    function35 = composableLambda3;
                    MutableInteractionSource mutableInteractionSource9222 = mutableInteractionSource4;
                    boolean z4222 = z2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    if (rangeSliderState2.getSteps() < 0) {
                    }
                }
                mutableInteractionSource3 = mutableInteractionSource;
                i6 = i2 & 32;
                if (i6 == 0) {
                }
                mutableInteractionSource4 = mutableInteractionSource2;
                i7 = i2 & 64;
                if (i7 != 0) {
                }
                i8 = i2 & 128;
                if (i8 != 0) {
                }
                i9 = i8;
                i10 = i2 & 256;
                if (i10 == 0) {
                }
                i11 = i10;
                if ((i3 & 38347923) == 38347922) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i13 != 0) {
                }
                if (i4 != 0) {
                }
                if ((i2 & 8) != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                if (i9 != 0) {
                }
                if (i11 != 0) {
                }
                function34 = composableLambda2;
                modifier3 = modifier2;
                mutableInteractionSource6 = mutableInteractionSource5;
                function35 = composableLambda3;
                MutableInteractionSource mutableInteractionSource92222 = mutableInteractionSource4;
                boolean z42222 = z2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                if (rangeSliderState2.getSteps() < 0) {
                }
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            mutableInteractionSource3 = mutableInteractionSource;
            i6 = i2 & 32;
            if (i6 == 0) {
            }
            mutableInteractionSource4 = mutableInteractionSource2;
            i7 = i2 & 64;
            if (i7 != 0) {
            }
            i8 = i2 & 128;
            if (i8 != 0) {
            }
            i9 = i8;
            i10 = i2 & 256;
            if (i10 == 0) {
            }
            i11 = i10;
            if ((i3 & 38347923) == 38347922) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i13 != 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 8) != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            if (i9 != 0) {
            }
            if (i11 != 0) {
            }
            function34 = composableLambda2;
            modifier3 = modifier2;
            mutableInteractionSource6 = mutableInteractionSource5;
            function35 = composableLambda3;
            MutableInteractionSource mutableInteractionSource922222 = mutableInteractionSource4;
            boolean z422222 = z2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            if (rangeSliderState2.getSteps() < 0) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        mutableInteractionSource3 = mutableInteractionSource;
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        mutableInteractionSource4 = mutableInteractionSource2;
        i7 = i2 & 64;
        if (i7 != 0) {
        }
        i8 = i2 & 128;
        if (i8 != 0) {
        }
        i9 = i8;
        i10 = i2 & 256;
        if (i10 == 0) {
        }
        i11 = i10;
        if ((i3 & 38347923) == 38347922) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i13 != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        if (i9 != 0) {
        }
        if (i11 != 0) {
        }
        function34 = composableLambda2;
        modifier3 = modifier2;
        mutableInteractionSource6 = mutableInteractionSource5;
        function35 = composableLambda3;
        MutableInteractionSource mutableInteractionSource9222222 = mutableInteractionSource4;
        boolean z4222222 = z2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        if (rangeSliderState2.getSteps() < 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SliderImpl(final Modifier modifier, final SliderState sliderState, boolean z, MutableInteractionSource mutableInteractionSource, Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function3, Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function32, Composer composer, final int i) {
        int i2;
        boolean z2;
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function33;
        final MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function34 = function32;
        Composer startRestartGroup = composer.startRestartGroup(1390990089);
        ComposerKt.sourceInformation(startRestartGroup, "C(SliderImpl)P(2,3)673@29093L7,684@29451L28,711@30244L1254,689@29563L1935:Slider.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(sliderState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(mutableInteractionSource2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(function3) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function34) ? 131072 : 65536;
        }
        if ((74899 & i2) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            function33 = function3;
            z2 = z;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1390990089, i2, -1, "androidx.compose.material3.SliderImpl (Slider.kt:672)");
            }
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            sliderState.setRtl$material3_release(consume == LayoutDirection.Rtl);
            Modifier sliderTapModifier = sliderTapModifier(Modifier.INSTANCE, sliderState, mutableInteractionSource2, z);
            Modifier.Companion companion = Modifier.INSTANCE;
            Orientation orientation = Orientation.Horizontal;
            boolean isRtl = sliderState.getIsRtl();
            boolean isDragging$material3_release = sliderState.isDragging$material3_release();
            Modifier.Companion companion2 = companion;
            SliderState sliderState2 = sliderState;
            startRestartGroup.startReplaceableGroup(1114013383);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
            int i3 = i2 & 112;
            boolean z3 = i3 == 32;
            SliderKt$SliderImpl$drag$1$1 rememberedValue = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new SliderKt$SliderImpl$drag$1$1(sliderState, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            z2 = z;
            int i4 = i2;
            Modifier draggable$default = DraggableKt.draggable$default(companion2, sliderState2, orientation, z2, mutableInteractionSource, isDragging$material3_release, null, (Function3) rememberedValue, isRtl, 32, null);
            mutableInteractionSource2 = mutableInteractionSource;
            Modifier then = FocusableKt.focusable(sliderSemantics(SizeKt.m924requiredSizeInqDBjuR0$default(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier), SliderTokens.INSTANCE.m3445getHandleWidthD9Ej5fM(), SliderTokens.INSTANCE.m3444getHandleHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), sliderState, z2), z2, mutableInteractionSource2).then(sliderTapModifier).then(draggable$default);
            startRestartGroup.startReplaceableGroup(1114014176);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
            boolean z4 = i3 == 32;
            MeasurePolicy rememberedValue2 = startRestartGroup.rememberedValue();
            if (z4 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new MeasurePolicy() { // from class: androidx.compose.material3.SliderKt$SliderImpl$2$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo355measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        int size = list.size();
                        int i5 = 0;
                        for (int i6 = 0; i6 < size; i6++) {
                            Measurable measurable = list.get(i6);
                            if (LayoutIdKt.getLayoutId(measurable) == SliderComponents.THUMB) {
                                long j2 = j;
                                final Placeable mo5333measureBRTryo0 = measurable.mo5333measureBRTryo0(j2);
                                int size2 = list.size();
                                while (i5 < size2) {
                                    Measurable measurable2 = list.get(i5);
                                    if (LayoutIdKt.getLayoutId(measurable2) == SliderComponents.TRACK) {
                                        final Placeable mo5333measureBRTryo02 = measurable2.mo5333measureBRTryo0(Constraints.m6336copyZbe2FdA$default(ConstraintsKt.m6362offsetNN6EwU$default(j2, -mo5333measureBRTryo0.getWidth(), 0, 2, null), 0, 0, 0, 0, 11, null));
                                        int width = mo5333measureBRTryo0.getWidth() + mo5333measureBRTryo02.getWidth();
                                        int max = Math.max(mo5333measureBRTryo02.getHeight(), mo5333measureBRTryo0.getHeight());
                                        SliderState.this.updateDimensions$material3_release(mo5333measureBRTryo0.getWidth(), width);
                                        final int width2 = mo5333measureBRTryo0.getWidth() / 2;
                                        final int roundToInt = MathKt.roundToInt(mo5333measureBRTryo02.getWidth() * SliderState.this.getCoercedValueAsFraction$material3_release());
                                        final int height = (max - mo5333measureBRTryo02.getHeight()) / 2;
                                        final int height2 = (max - mo5333measureBRTryo0.getHeight()) / 2;
                                        return MeasureScope.layout$default(measureScope, width, max, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.SliderKt$SliderImpl$2$1.1
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
                                                Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, width2, height, 0.0f, 4, null);
                                                Placeable.PlacementScope.placeRelative$default(placementScope, mo5333measureBRTryo0, roundToInt, height2, 0.0f, 4, null);
                                            }
                                        }, 4, null);
                                    }
                                    i5++;
                                    j2 = j;
                                }
                                throw new NoSuchElementException("Collection contains no element matching the predicate.");
                            }
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue2;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(then);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1541261174, "C691@29593L102,694@29708L102:Slider.kt#uh7d8r");
            Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, SliderComponents.THUMB);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(layoutId);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1819482525, "C692@29669L12:Slider.kt#uh7d8r");
            int i5 = (i4 >> 3) & 14;
            function33 = function3;
            function33.invoke(sliderState, startRestartGroup, Integer.valueOf(((i4 >> 9) & 112) | i5));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            Modifier layoutId2 = LayoutIdKt.layoutId(Modifier.INSTANCE, SliderComponents.TRACK);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(layoutId2);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1819482410, "C695@29784L12:Slider.kt#uh7d8r");
            function34 = function32;
            function34.invoke(sliderState, startRestartGroup, Integer.valueOf(((i4 >> 12) & 112) | i5));
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
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final boolean z5 = z2;
            final Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function35 = function33;
            final Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function36 = function34;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$SliderImpl$3
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

                public final void invoke(Composer composer2, int i6) {
                    SliderKt.SliderImpl(Modifier.this, sliderState, z5, mutableInteractionSource2, function35, function36, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RangeSliderImpl(final Modifier modifier, final RangeSliderState rangeSliderState, final boolean z, final MutableInteractionSource mutableInteractionSource, final MutableInteractionSource mutableInteractionSource2, final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function3, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function32, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function33, Composer composer, final int i) {
        Modifier modifier2;
        int i2;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function34;
        final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function35 = function33;
        Composer startRestartGroup = composer.startRestartGroup(-1411725677);
        ComposerKt.sourceInformation(startRestartGroup, "C(RangeSliderImpl)P(3,6!1,4!1,5)763@31973L7,775@32367L35,776@32435L33,807@33617L2386,778@32474L3529:Slider.kt#uh7d8r");
        if ((i & 6) == 0) {
            modifier2 = modifier;
            i2 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(rangeSliderState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(mutableInteractionSource) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changed(mutableInteractionSource2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function3) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function32) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function35) ? 8388608 : 4194304;
        }
        if ((4793491 & i2) != 4793490 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1411725677, i2, -1, "androidx.compose.material3.RangeSliderImpl (Slider.kt:762)");
            }
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            rangeSliderState.setRtl$material3_release(consume == LayoutDirection.Rtl);
            Modifier rangeSliderPressDragModifier = rangeSliderPressDragModifier(Modifier.INSTANCE, rangeSliderState, mutableInteractionSource, mutableInteractionSource2, z);
            Modifier rangeSliderStartThumbSemantics = rangeSliderStartThumbSemantics(Modifier.INSTANCE, rangeSliderState, z);
            Modifier rangeSliderEndThumbSemantics = rangeSliderEndThumbSemantics(Modifier.INSTANCE, rangeSliderState, z);
            Strings.Companion companion = Strings.INSTANCE;
            final String m2623getStringNWtq28 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(androidx.compose.ui.R.string.range_start), startRestartGroup, 0);
            Strings.Companion companion2 = Strings.INSTANCE;
            final String m2623getStringNWtq282 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(androidx.compose.ui.R.string.range_end), startRestartGroup, 0);
            Modifier then = SizeKt.m924requiredSizeInqDBjuR0$default(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier2), SliderTokens.INSTANCE.m3445getHandleWidthD9Ej5fM(), SliderTokens.INSTANCE.m3444getHandleHeightD9Ej5fM(), 0.0f, 0.0f, 12, null).then(rangeSliderPressDragModifier);
            startRestartGroup.startReplaceableGroup(1300547382);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
            boolean z2 = (i2 & 112) == 32;
            MeasurePolicy rememberedValue = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new MeasurePolicy() { // from class: androidx.compose.material3.SliderKt$RangeSliderImpl$2$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo355measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        long j2 = j;
                        int size = list.size();
                        int i3 = 0;
                        int i4 = 0;
                        while (i4 < size) {
                            Measurable measurable = list.get(i4);
                            if (LayoutIdKt.getLayoutId(measurable) == RangeSliderComponents.STARTTHUMB) {
                                final Placeable mo5333measureBRTryo0 = measurable.mo5333measureBRTryo0(j2);
                                int size2 = list.size();
                                int i5 = 0;
                                while (i5 < size2) {
                                    Measurable measurable2 = list.get(i5);
                                    if (LayoutIdKt.getLayoutId(measurable2) == RangeSliderComponents.ENDTHUMB) {
                                        final Placeable mo5333measureBRTryo02 = measurable2.mo5333measureBRTryo0(j2);
                                        int size3 = list.size();
                                        while (i3 < size3) {
                                            Measurable measurable3 = list.get(i3);
                                            if (LayoutIdKt.getLayoutId(measurable3) == RangeSliderComponents.TRACK) {
                                                final Placeable mo5333measureBRTryo03 = measurable3.mo5333measureBRTryo0(Constraints.m6336copyZbe2FdA$default(ConstraintsKt.m6362offsetNN6EwU$default(j2, (-(mo5333measureBRTryo0.getWidth() + mo5333measureBRTryo02.getWidth())) / 2, 0, 2, null), 0, 0, 0, 0, 11, null));
                                                int width = mo5333measureBRTryo03.getWidth() + ((mo5333measureBRTryo0.getWidth() + mo5333measureBRTryo02.getWidth()) / 2);
                                                int max = Math.max(mo5333measureBRTryo03.getHeight(), Math.max(mo5333measureBRTryo0.getHeight(), mo5333measureBRTryo02.getHeight()));
                                                RangeSliderState.this.setStartThumbWidth$material3_release(mo5333measureBRTryo0.getWidth());
                                                RangeSliderState.this.setEndThumbWidth$material3_release(mo5333measureBRTryo02.getWidth());
                                                RangeSliderState.this.setTotalWidth$material3_release(width);
                                                RangeSliderState.this.updateMinMaxPx$material3_release();
                                                final int width2 = mo5333measureBRTryo0.getWidth() / 2;
                                                final int roundToInt = MathKt.roundToInt(mo5333measureBRTryo03.getWidth() * RangeSliderState.this.getCoercedActiveRangeStartAsFraction$material3_release());
                                                final int roundToInt2 = MathKt.roundToInt((mo5333measureBRTryo03.getWidth() * RangeSliderState.this.getCoercedActiveRangeEndAsFraction$material3_release()) + ((mo5333measureBRTryo0.getWidth() - mo5333measureBRTryo02.getWidth()) / 2));
                                                final int height = (max - mo5333measureBRTryo03.getHeight()) / 2;
                                                final int height2 = (max - mo5333measureBRTryo0.getHeight()) / 2;
                                                final int height3 = (max - mo5333measureBRTryo02.getHeight()) / 2;
                                                return MeasureScope.layout$default(measureScope, width, max, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSliderImpl$2$1.1
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
                                                        Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, width2, height, 0.0f, 4, null);
                                                        Placeable.PlacementScope.placeRelative$default(placementScope, mo5333measureBRTryo0, roundToInt, height2, 0.0f, 4, null);
                                                        Placeable.PlacementScope.placeRelative$default(placementScope, mo5333measureBRTryo02, roundToInt2, height3, 0.0f, 4, null);
                                                    }
                                                }, 4, null);
                                            }
                                            i3++;
                                            j2 = j;
                                        }
                                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                                    }
                                    i5++;
                                    j2 = j;
                                }
                                throw new NoSuchElementException("Collection contains no element matching the predicate.");
                            }
                            i4++;
                            j2 = j;
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
            int i3 = i2;
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(then);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2040261250, "C782@32640L84,780@32504L359,790@33010L82,788@32876L349,796@33238L107:Slider.kt#uh7d8r");
            Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, RangeSliderComponents.STARTTHUMB);
            startRestartGroup.startReplaceableGroup(-2040261114);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
            boolean changed = startRestartGroup.changed(m2623getStringNWtq28);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSliderImpl$1$1$1
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
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            Modifier then2 = FocusableKt.focusable(SemanticsModifierKt.semantics(layoutId, true, (Function1) rememberedValue2), z, mutableInteractionSource).then(rangeSliderStartThumbSemantics);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(then2);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1631551475, "C787@32844L17:Slider.kt#uh7d8r");
            int i4 = (i3 >> 3) & 14;
            function3.invoke(rangeSliderState, startRestartGroup, Integer.valueOf(((i3 >> 12) & 112) | i4));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            Modifier layoutId2 = LayoutIdKt.layoutId(Modifier.INSTANCE, RangeSliderComponents.ENDTHUMB);
            startRestartGroup.startReplaceableGroup(-2040260744);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
            boolean changed2 = startRestartGroup.changed(m2623getStringNWtq282);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSliderImpl$1$3$1
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
                        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, m2623getStringNWtq282);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceableGroup();
            Modifier then3 = FocusableKt.focusable(SemanticsModifierKt.semantics(layoutId2, true, (Function1) rememberedValue3), z, mutableInteractionSource2).then(rangeSliderEndThumbSemantics);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(then3);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1631551839, "C795@33208L15:Slider.kt#uh7d8r");
            function34 = function32;
            function34.invoke(rangeSliderState, startRestartGroup, Integer.valueOf(((i3 >> 15) & 112) | i4));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            Modifier layoutId3 = LayoutIdKt.layoutId(Modifier.INSTANCE, RangeSliderComponents.TRACK);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(layoutId3);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1631551950, "C797@33319L12:Slider.kt#uh7d8r");
            function35 = function33;
            function35.invoke(rangeSliderState, startRestartGroup, Integer.valueOf(((i3 >> 18) & 112) | i4));
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
            function34 = function32;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function36 = function34;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSliderImpl$3
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
                    SliderKt.RangeSliderImpl(Modifier.this, rangeSliderState, z, mutableInteractionSource, mutableInteractionSource2, function3, function36, function35, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0067 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: awaitSlop-8vUncbI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m2528awaitSlop8vUncbI(AwaitPointerEventScope awaitPointerEventScope, long j, int i, Continuation<? super Pair<PointerInputChange, Float>> continuation) {
        SliderKt$awaitSlop$1 sliderKt$awaitSlop$1;
        int i2;
        Ref.FloatRef floatRef;
        PointerInputChange pointerInputChange;
        if (continuation instanceof SliderKt$awaitSlop$1) {
            sliderKt$awaitSlop$1 = (SliderKt$awaitSlop$1) continuation;
            if ((sliderKt$awaitSlop$1.label & Integer.MIN_VALUE) != 0) {
                sliderKt$awaitSlop$1.label -= Integer.MIN_VALUE;
                SliderKt$awaitSlop$1 sliderKt$awaitSlop$12 = sliderKt$awaitSlop$1;
                Object obj = sliderKt$awaitSlop$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = sliderKt$awaitSlop$12.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    final Ref.FloatRef floatRef2 = new Ref.FloatRef();
                    Function2<PointerInputChange, Float, Unit> function2 = new Function2<PointerInputChange, Float, Unit>() { // from class: androidx.compose.material3.SliderKt$awaitSlop$postPointerSlop$1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange2, Float f) {
                            invoke(pointerInputChange2, f.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(PointerInputChange pointerInputChange2, float f) {
                            pointerInputChange2.consume();
                            Ref.FloatRef.this.element = f;
                        }
                    };
                    sliderKt$awaitSlop$12.L$0 = floatRef2;
                    sliderKt$awaitSlop$12.label = 1;
                    Object m2183awaitHorizontalPointerSlopOrCancellationgDDlDlE = DragGestureDetectorCopyKt.m2183awaitHorizontalPointerSlopOrCancellationgDDlDlE(awaitPointerEventScope, j, i, function2, sliderKt$awaitSlop$12);
                    if (m2183awaitHorizontalPointerSlopOrCancellationgDDlDlE == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = m2183awaitHorizontalPointerSlopOrCancellationgDDlDlE;
                    floatRef = floatRef2;
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    floatRef = (Ref.FloatRef) sliderKt$awaitSlop$12.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                pointerInputChange = (PointerInputChange) obj;
                if (pointerInputChange == null) {
                    return TuplesKt.to(pointerInputChange, Boxing.boxFloat(floatRef.element));
                }
                return null;
            }
        }
        sliderKt$awaitSlop$1 = new SliderKt$awaitSlop$1(continuation);
        SliderKt$awaitSlop$1 sliderKt$awaitSlop$122 = sliderKt$awaitSlop$1;
        Object obj2 = sliderKt$awaitSlop$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = sliderKt$awaitSlop$122.label;
        if (i2 != 0) {
        }
        pointerInputChange = (PointerInputChange) obj2;
        if (pointerInputChange == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float[] stepsToTickFractions(int i) {
        if (i == 0) {
            return new float[0];
        }
        int i2 = i + 2;
        float[] fArr = new float[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            fArr[i3] = i3 / (i + 1);
        }
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float scale(float f, float f2, float f3, float f4, float f5) {
        return MathHelpersKt.lerp(f4, f5, calcFraction(f, f2, f3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: scale-ziovWd0, reason: not valid java name */
    public static final long m2531scaleziovWd0(float f, float f2, long j, float f3, float f4) {
        return SliderRange(scale(f, f2, SliderRange.m2540getStartimpl(j), f3, f4), scale(f, f2, SliderRange.m2539getEndInclusiveimpl(j), f3, f4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calcFraction(float f, float f2, float f3) {
        float f4 = f2 - f;
        return RangesKt.coerceIn(f4 == 0.0f ? 0.0f : (f3 - f) / f4, 0.0f, 1.0f);
    }

    private static final Modifier sliderSemantics(Modifier modifier, final SliderState sliderState, final boolean z) {
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SliderKt$sliderSemantics$1
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
                if (!z) {
                    SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
                }
                final SliderState sliderState2 = sliderState;
                SemanticsPropertiesKt.setProgress$default(semanticsPropertyReceiver, null, new Function1<Float, Boolean>() { // from class: androidx.compose.material3.SliderKt$sliderSemantics$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(Float f) {
                        return invoke(f.floatValue());
                    }

                    public final Boolean invoke(float f) {
                        int steps;
                        float coerceIn = RangesKt.coerceIn(f, SliderState.this.getValueRange().getStart().floatValue(), SliderState.this.getValueRange().getEndInclusive().floatValue());
                        boolean z2 = false;
                        if (SliderState.this.getSteps() > 0 && (steps = SliderState.this.getSteps() + 1) >= 0) {
                            float f2 = coerceIn;
                            float f3 = f2;
                            int i = 0;
                            while (true) {
                                float lerp = MathHelpersKt.lerp(SliderState.this.getValueRange().getStart().floatValue(), SliderState.this.getValueRange().getEndInclusive().floatValue(), i / (SliderState.this.getSteps() + 1));
                                float f4 = lerp - coerceIn;
                                if (Math.abs(f4) <= f2) {
                                    f2 = Math.abs(f4);
                                    f3 = lerp;
                                }
                                if (i == steps) {
                                    break;
                                }
                                i++;
                            }
                            coerceIn = f3;
                        }
                        if (coerceIn != SliderState.this.getValue()) {
                            if (coerceIn != SliderState.this.getValue()) {
                                if (SliderState.this.getOnValueChange$material3_release() != null) {
                                    Function1<Float, Unit> onValueChange$material3_release = SliderState.this.getOnValueChange$material3_release();
                                    if (onValueChange$material3_release != null) {
                                        onValueChange$material3_release.invoke(Float.valueOf(coerceIn));
                                    }
                                } else {
                                    SliderState.this.setValue(coerceIn);
                                }
                            }
                            Function0<Unit> onValueChangeFinished = SliderState.this.getOnValueChangeFinished();
                            if (onValueChangeFinished != null) {
                                onValueChangeFinished.invoke();
                            }
                            z2 = true;
                        }
                        return Boolean.valueOf(z2);
                    }
                }, 1, null);
            }
        }, 1, null), sliderState.getValue(), RangesKt.rangeTo(sliderState.getValueRange().getStart().floatValue(), sliderState.getValueRange().getEndInclusive().floatValue()), sliderState.getSteps());
    }

    private static final Modifier rangeSliderStartThumbSemantics(Modifier modifier, final RangeSliderState rangeSliderState, final boolean z) {
        final ClosedFloatingPointRange<Float> rangeTo = RangesKt.rangeTo(rangeSliderState.getValueRange().getStart().floatValue(), rangeSliderState.getActiveRangeEnd());
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SliderKt$rangeSliderStartThumbSemantics$1
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
                if (!z) {
                    SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
                }
                final ClosedFloatingPointRange<Float> closedFloatingPointRange = rangeTo;
                final RangeSliderState rangeSliderState2 = rangeSliderState;
                SemanticsPropertiesKt.setProgress$default(semanticsPropertyReceiver, null, new Function1<Float, Boolean>() { // from class: androidx.compose.material3.SliderKt$rangeSliderStartThumbSemantics$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(Float f) {
                        return invoke(f.floatValue());
                    }

                    public final Boolean invoke(float f) {
                        int startSteps$material3_release;
                        float coerceIn = RangesKt.coerceIn(f, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
                        boolean z2 = false;
                        if (rangeSliderState2.getStartSteps$material3_release() > 0 && (startSteps$material3_release = rangeSliderState2.getStartSteps$material3_release() + 1) >= 0) {
                            float f2 = coerceIn;
                            float f3 = f2;
                            int i = 0;
                            while (true) {
                                float lerp = MathHelpersKt.lerp(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue(), i / (rangeSliderState2.getStartSteps$material3_release() + 1));
                                float f4 = lerp - coerceIn;
                                if (Math.abs(f4) <= f2) {
                                    f2 = Math.abs(f4);
                                    f3 = lerp;
                                }
                                if (i == startSteps$material3_release) {
                                    break;
                                }
                                i++;
                            }
                            coerceIn = f3;
                        }
                        if (coerceIn != rangeSliderState2.getActiveRangeStart()) {
                            long SliderRange = SliderKt.SliderRange(coerceIn, rangeSliderState2.getActiveRangeEnd());
                            if (!SliderRange.m2538equalsimpl0(SliderRange, SliderKt.SliderRange(rangeSliderState2.getActiveRangeStart(), rangeSliderState2.getActiveRangeEnd()))) {
                                if (rangeSliderState2.getOnValueChange$material3_release() != null) {
                                    Function1<SliderRange, Unit> onValueChange$material3_release = rangeSliderState2.getOnValueChange$material3_release();
                                    if (onValueChange$material3_release != null) {
                                        onValueChange$material3_release.invoke(SliderRange.m2535boximpl(SliderRange));
                                    }
                                } else {
                                    rangeSliderState2.setActiveRangeStart(SliderRange.m2540getStartimpl(SliderRange));
                                    rangeSliderState2.setActiveRangeEnd(SliderRange.m2539getEndInclusiveimpl(SliderRange));
                                }
                            }
                            Function0<Unit> onValueChangeFinished = rangeSliderState2.getOnValueChangeFinished();
                            if (onValueChangeFinished != null) {
                                onValueChangeFinished.invoke();
                            }
                            z2 = true;
                        }
                        return Boolean.valueOf(z2);
                    }
                }, 1, null);
            }
        }, 1, null), rangeSliderState.getActiveRangeStart(), rangeTo, rangeSliderState.getStartSteps$material3_release());
    }

    private static final Modifier rangeSliderEndThumbSemantics(Modifier modifier, final RangeSliderState rangeSliderState, final boolean z) {
        final ClosedFloatingPointRange<Float> rangeTo = RangesKt.rangeTo(rangeSliderState.getActiveRangeStart(), rangeSliderState.getValueRange().getEndInclusive().floatValue());
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SliderKt$rangeSliderEndThumbSemantics$1
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
                if (!z) {
                    SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
                }
                final ClosedFloatingPointRange<Float> closedFloatingPointRange = rangeTo;
                final RangeSliderState rangeSliderState2 = rangeSliderState;
                SemanticsPropertiesKt.setProgress$default(semanticsPropertyReceiver, null, new Function1<Float, Boolean>() { // from class: androidx.compose.material3.SliderKt$rangeSliderEndThumbSemantics$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(Float f) {
                        return invoke(f.floatValue());
                    }

                    public final Boolean invoke(float f) {
                        int endSteps$material3_release;
                        float coerceIn = RangesKt.coerceIn(f, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
                        boolean z2 = false;
                        if (rangeSliderState2.getEndSteps$material3_release() > 0 && (endSteps$material3_release = rangeSliderState2.getEndSteps$material3_release() + 1) >= 0) {
                            float f2 = coerceIn;
                            float f3 = f2;
                            int i = 0;
                            while (true) {
                                float lerp = MathHelpersKt.lerp(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue(), i / (rangeSliderState2.getEndSteps$material3_release() + 1));
                                float f4 = lerp - coerceIn;
                                if (Math.abs(f4) <= f2) {
                                    f2 = Math.abs(f4);
                                    f3 = lerp;
                                }
                                if (i == endSteps$material3_release) {
                                    break;
                                }
                                i++;
                            }
                            coerceIn = f3;
                        }
                        if (coerceIn != rangeSliderState2.getActiveRangeEnd()) {
                            long SliderRange = SliderKt.SliderRange(rangeSliderState2.getActiveRangeStart(), coerceIn);
                            if (!SliderRange.m2538equalsimpl0(SliderRange, SliderKt.SliderRange(rangeSliderState2.getActiveRangeStart(), rangeSliderState2.getActiveRangeEnd()))) {
                                if (rangeSliderState2.getOnValueChange$material3_release() != null) {
                                    Function1<SliderRange, Unit> onValueChange$material3_release = rangeSliderState2.getOnValueChange$material3_release();
                                    if (onValueChange$material3_release != null) {
                                        onValueChange$material3_release.invoke(SliderRange.m2535boximpl(SliderRange));
                                    }
                                } else {
                                    rangeSliderState2.setActiveRangeStart(SliderRange.m2540getStartimpl(SliderRange));
                                    rangeSliderState2.setActiveRangeEnd(SliderRange.m2539getEndInclusiveimpl(SliderRange));
                                }
                            }
                            Function0<Unit> onValueChangeFinished = rangeSliderState2.getOnValueChangeFinished();
                            if (onValueChangeFinished != null) {
                                onValueChangeFinished.invoke();
                            }
                            z2 = true;
                        }
                        return Boolean.valueOf(z2);
                    }
                }, 1, null);
            }
        }, 1, null), rangeSliderState.getActiveRangeEnd(), rangeTo, rangeSliderState.getEndSteps$material3_release());
    }

    private static final Modifier sliderTapModifier(Modifier modifier, SliderState sliderState, MutableInteractionSource mutableInteractionSource, boolean z) {
        return z ? SuspendingPointerInputFilterKt.pointerInput(modifier, sliderState, mutableInteractionSource, new SliderKt$sliderTapModifier$1(sliderState, null)) : modifier;
    }

    private static final Modifier rangeSliderPressDragModifier(Modifier modifier, RangeSliderState rangeSliderState, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, boolean z) {
        return z ? SuspendingPointerInputFilterKt.pointerInput(modifier, new Object[]{mutableInteractionSource, mutableInteractionSource2, rangeSliderState}, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new SliderKt$rangeSliderPressDragModifier$1(rangeSliderState, mutableInteractionSource, mutableInteractionSource2, null)) : modifier;
    }

    static {
        float m3445getHandleWidthD9Ej5fM = SliderTokens.INSTANCE.m3445getHandleWidthD9Ej5fM();
        ThumbWidth = m3445getHandleWidthD9Ej5fM;
        float m3444getHandleHeightD9Ej5fM = SliderTokens.INSTANCE.m3444getHandleHeightD9Ej5fM();
        ThumbHeight = m3444getHandleHeightD9Ej5fM;
        ThumbSize = DpKt.m6411DpSizeYgX7TsA(m3445getHandleWidthD9Ej5fM, m3444getHandleHeightD9Ej5fM);
        ThumbDefaultElevation = Dp.m6389constructorimpl(1);
        ThumbPressedElevation = Dp.m6389constructorimpl(6);
        TickSize = SliderTokens.INSTANCE.m3451getTickMarksContainerSizeD9Ej5fM();
        TrackHeight = SliderTokens.INSTANCE.m3446getInactiveTrackHeightD9Ej5fM();
    }

    public static final float getThumbWidth() {
        return ThumbWidth;
    }

    public static final float getTrackHeight() {
        return TrackHeight;
    }

    public static final long SliderRange(float f, float f2) {
        if ((!Float.isNaN(f) || !Float.isNaN(f2)) && f > f2) {
            throw new IllegalArgumentException(("start(" + f + ") must be <= endInclusive(" + f2 + ')').toString());
        }
        return SliderRange.m2536constructorimpl((Float.floatToRawIntBits(f2) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
    }

    public static final long SliderRange(ClosedFloatingPointRange<Float> closedFloatingPointRange) {
        float floatValue = closedFloatingPointRange.getStart().floatValue();
        float floatValue2 = closedFloatingPointRange.getEndInclusive().floatValue();
        if ((!Float.isNaN(floatValue) || !Float.isNaN(floatValue2)) && floatValue > floatValue2) {
            throw new IllegalArgumentException(("ClosedFloatingPointRange<Float>.start(" + floatValue + ") must be <= ClosedFloatingPoint.endInclusive(" + floatValue2 + ')').toString());
        }
        return SliderRange.m2536constructorimpl((Float.floatToRawIntBits(floatValue) << 32) | (Float.floatToRawIntBits(floatValue2) & 4294967295L));
    }

    /* renamed from: isSpecified-If1S1O4, reason: not valid java name */
    public static final boolean m2529isSpecifiedIf1S1O4(long j) {
        return j != SliderRange.INSTANCE.m2545getUnspecifiedFYbKRX4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator] */
    public static final float snapValueToTick(float f, float[] fArr, float f2, float f3) {
        Float valueOf;
        if (fArr.length == 0) {
            valueOf = null;
        } else {
            float f4 = fArr[0];
            int lastIndex = ArraysKt.getLastIndex(fArr);
            if (lastIndex != 0) {
                float abs = Math.abs(MathHelpersKt.lerp(f2, f3, f4) - f);
                ?? it = new IntRange(1, lastIndex).iterator();
                while (it.hasNext()) {
                    float f5 = fArr[it.nextInt()];
                    float abs2 = Math.abs(MathHelpersKt.lerp(f2, f3, f5) - f);
                    if (Float.compare(abs, abs2) > 0) {
                        f4 = f5;
                        abs = abs2;
                    }
                }
                valueOf = Float.valueOf(f4);
            } else {
                valueOf = Float.valueOf(f4);
            }
        }
        return valueOf != null ? MathHelpersKt.lerp(f2, f3, valueOf.floatValue()) : f;
    }
}
