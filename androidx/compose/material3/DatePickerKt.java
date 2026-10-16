package androidx.compose.material3;

import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.ContentTransform;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
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
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.foundation.lazy.grid.LazyGridDslKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemInfo;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.foundation.lazy.grid.LazyGridScope;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.lazy.grid.LazyGridStateKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ArrowDropDownKt;
import androidx.compose.material3.Strings;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.material3.tokens.MotionTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.profileinstaller.ProfileVerifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: DatePicker.kt */
@Metadata(d1 = {"\u0000Ì\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a\u0084\u0001\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0013\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00032\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u0019H\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001ak\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010'\u001a\u00020(2\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0007¢\u0006\u0002\u0010+\u001a\u008d\u0001\u0010,\u001a\u00020\u00142\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u00020.2!\u00100\u001a\u001d\u0012\u0013\u0012\u00110.¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\u0014012!\u00105\u001a\u001d\u0012\u0013\u0012\u00110.¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\u0014012\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010'\u001a\u00020(2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u001c\u001a\u00020\u001dH\u0003¢\u0006\u0002\u0010=\u001aZ\u0010>\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u00020\u00032\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u0019H\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010D\u001aT\u0010E\u001a\u00020&2\n\u0010F\u001a\u00060Gj\u0002`H2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010.2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010.2\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010K\u001a\u00020L2\b\b\u0002\u0010;\u001a\u00020<H\u0007ø\u0001\u0000¢\u0006\u0004\bM\u0010N\u001an\u0010O\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010P\u001a\u00020*2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00140\u00182\u0006\u0010R\u001a\u00020*2\u0006\u0010S\u001a\u00020*2\u0006\u0010T\u001a\u00020*2\u0006\u0010U\u001a\u00020*2\u0006\u0010V\u001a\u00020W2\u0006\u0010\u001c\u001a\u00020\u001d2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u0019H\u0003¢\u0006\u0002\u0010X\u001a6\u0010Y\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010Z\u001a\u00020L2\u0012\u0010[\u001a\u000e\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\u001401H\u0001ø\u0001\u0000¢\u0006\u0004\b\\\u0010]\u001a\u008d\u0001\u0010^\u001a\u00020\u00142\u0006\u0010_\u001a\u00020`2\b\u0010-\u001a\u0004\u0018\u00010.2!\u00100\u001a\u001d\u0012\u0013\u0012\u00110.¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\u0014012!\u00105\u001a\u001d\u0012\u0013\u0012\u00110.¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\u0014012\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010'\u001a\u00020(2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u001c\u001a\u00020\u001dH\u0003¢\u0006\u0002\u0010a\u001av\u0010b\u001a\u00020\u00142\u0006\u0010c\u001a\u00020d2!\u00100\u001a\u001d\u0012\u0013\u0012\u00110.¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\u0014012\u0006\u0010e\u001a\u00020.2\b\u0010f\u001a\u0004\u0018\u00010.2\b\u0010g\u001a\u0004\u0018\u00010.2\b\u0010h\u001a\u0004\u0018\u00010i2\u0006\u0010'\u001a\u00020(2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u001c\u001a\u00020\u001dH\u0001¢\u0006\u0002\u0010j\u001ag\u0010k\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010l\u001a\u00020*2\u0006\u0010m\u001a\u00020*2\u0006\u0010n\u001a\u00020*2\u0006\u0010o\u001a\u00020W2\f\u0010p\u001a\b\u0012\u0004\u0012\u00020\u00140\u00182\f\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00140\u00182\f\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00140\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0003¢\u0006\u0002\u0010s\u001a\u009c\u0001\u0010t\u001a\u00020\u00142\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u00020.2\u0006\u0010Z\u001a\u00020L2#\u00100\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010.¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\u0014012!\u00105\u001a\u001d\u0012\u0013\u0012\u00110.¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\u0014012\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010'\u001a\u00020(2\u0006\u0010;\u001a\u00020<2\u0006\u0010\u001c\u001a\u00020\u001dH\u0003ø\u0001\u0000¢\u0006\u0004\bu\u0010v\u001a\u001d\u0010w\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u00107\u001a\u000208H\u0001¢\u0006\u0002\u0010x\u001a^\u0010y\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010P\u001a\u00020*2\u0006\u0010z\u001a\u00020*2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00140\u00182\u0006\u0010S\u001a\u00020*2\u0006\u0010V\u001a\u00020W2\u0006\u0010\u001c\u001a\u00020\u001d2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u0019H\u0003¢\u0006\u0002\u0010{\u001a`\u0010|\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010/\u001a\u00020.2!\u0010}\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(~\u0012\u0004\u0012\u00020\u0014012\u0006\u0010;\u001a\u00020<2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010\u001c\u001a\u00020\u001dH\u0003¢\u0006\u0002\u0010\u007f\u001aC\u0010\u0080\u0001\u001a\u00020\u00142\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00140\u00182\u0007\u0010\u0081\u0001\u001a\u00020*2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u0019H\u0003¢\u0006\u0003\u0010\u0082\u0001\u001a6\u0010\u0083\u0001\u001a\n\u0012\u0005\u0012\u00030\u0085\u00010\u0084\u00012\u0007\u0010%\u001a\u00030\u0086\u00012\b\u0010\u0087\u0001\u001a\u00030\u0088\u00012\u0007\u0010\u0089\u0001\u001a\u00020W2\u0007\u0010\u008a\u0001\u001a\u00020WH\u0002\u001a>\u0010\u008b\u0001\u001a\u0004\u0018\u00010W2\u0007\u0010\u008c\u0001\u001a\u00020*2\u0007\u0010\u008d\u0001\u001a\u00020*2\u0007\u0010\u008e\u0001\u001a\u00020*2\u0007\u0010\u008f\u0001\u001a\u00020*2\u0007\u0010\u0090\u0001\u001a\u00020*H\u0003¢\u0006\u0003\u0010\u0091\u0001\u001a\u0011\u0010\u0092\u0001\u001a\u00020\f2\u0006\u00109\u001a\u00020:H\u0000\u001aK\u0010\u0093\u0001\u001a\u00020&2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010.2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010.2\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010K\u001a\u00020L2\b\b\u0002\u0010;\u001a\u00020<H\u0007ø\u0001\u0000¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001\u001aK\u0010\u0096\u0001\u001a\u00020\u00142\u0006\u0010_\u001a\u00020`2!\u00105\u001a\u001d\u0012\u0013\u0012\u00110.¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\u0014012\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0080@¢\u0006\u0003\u0010\u0097\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0007\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\"\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\r\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u000e\u0010\u0005\"\u0016\u0010\u000f\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0010\u0010\u0005\"\u000e\u0010\u0011\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0012\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0098\u0001²\u0006\n\u0010n\u001a\u00020*X\u008a\u008e\u0002"}, d2 = {"DatePickerHeadlinePadding", "Landroidx/compose/foundation/layout/PaddingValues;", "DatePickerHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "getDatePickerHorizontalPadding", "()F", "F", "DatePickerModeTogglePadding", "getDatePickerModeTogglePadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "DatePickerTitlePadding", "MaxCalendarRows", "", "MonthYearHeight", "getMonthYearHeight", "RecommendedSizeForAccessibility", "getRecommendedSizeForAccessibility", "YearsInRow", "YearsVerticalPadding", "DateEntryContainer", "", "modifier", "Landroidx/compose/ui/Modifier;", "title", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "headline", "modeToggleButton", "colors", "Landroidx/compose/material3/DatePickerColors;", "headlineTextStyle", "Landroidx/compose/ui/text/TextStyle;", "headerMinHeight", "content", "DateEntryContainer-au3_HiA", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/ui/text/TextStyle;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "DatePicker", "state", "Landroidx/compose/material3/DatePickerState;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "showModeToggle", "", "(Landroidx/compose/material3/DatePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DatePickerFormatter;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;II)V", "DatePickerContent", "selectedDateMillis", "", "displayedMonthMillis", "onDateSelectionChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "dateInMillis", "onDisplayedMonthChange", "monthInMillis", "calendarModel", "Landroidx/compose/material3/CalendarModel;", "yearRange", "Lkotlin/ranges/IntRange;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "(Ljava/lang/Long;JLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "DatePickerHeader", "titleContentColor", "Landroidx/compose/ui/graphics/Color;", "headlineContentColor", "minHeight", "DatePickerHeader-pc5RIQQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;JJFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "DatePickerState", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "initialSelectedDateMillis", "initialDisplayedMonthMillis", "initialDisplayMode", "Landroidx/compose/material3/DisplayMode;", "DatePickerState-sHin3Bw", "(Ljava/util/Locale;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;)Landroidx/compose/material3/DatePickerState;", "Day", "selected", "onClick", "animateChecked", "enabled", "today", "inRange", "description", "", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;ZZZZLjava/lang/String;Landroidx/compose/material3/DatePickerColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "DisplayModeToggleButton", "displayMode", "onDisplayModeChange", "DisplayModeToggleButton-tER2X8s", "(Landroidx/compose/ui/Modifier;ILkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "HorizontalMonthsList", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "(Landroidx/compose/foundation/lazy/LazyListState;Ljava/lang/Long;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "Month", "month", "Landroidx/compose/material3/CalendarMonth;", "todayMillis", "startDateMillis", "endDateMillis", "rangeSelectionInfo", "Landroidx/compose/material3/SelectedRangeInfo;", "(Landroidx/compose/material3/CalendarMonth;Lkotlin/jvm/functions/Function1;JLjava/lang/Long;Ljava/lang/Long;Landroidx/compose/material3/SelectedRangeInfo;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "MonthsNavigation", "nextAvailable", "previousAvailable", "yearPickerVisible", "yearPickerText", "onNextClicked", "onPreviousClicked", "onYearPickerButtonClicked", "(Landroidx/compose/ui/Modifier;ZZZLjava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "SwitchableDateEntryContent", "SwitchableDateEntryContent-d7iavvg", "(Ljava/lang/Long;JILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "WeekDays", "(Landroidx/compose/material3/DatePickerColors;Landroidx/compose/material3/CalendarModel;Landroidx/compose/runtime/Composer;I)V", "Year", "currentYear", "(Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function0;ZLjava/lang/String;Landroidx/compose/material3/DatePickerColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "YearPicker", "onYearSelected", "year", "(Landroidx/compose/ui/Modifier;JLkotlin/jvm/functions/Function1;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "YearPickerMenuButton", "expanded", "(Lkotlin/jvm/functions/Function0;ZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "customScrollActions", "", "Landroidx/compose/ui/semantics/CustomAccessibilityAction;", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "scrollUpLabel", "scrollDownLabel", "dayContentDescription", "rangeSelectionEnabled", "isToday", "isStartDate", "isEndDate", "isInRange", "(ZZZZZLandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "numberOfMonthsInRange", "rememberDatePickerState", "rememberDatePickerState-EU0dCGE", "(Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DatePickerState;", "updateDisplayedMonth", "(Landroidx/compose/foundation/lazy/LazyListState;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/CalendarModel;Lkotlin/ranges/IntRange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DatePickerKt {
    private static final PaddingValues DatePickerHeadlinePadding;
    private static final float DatePickerHorizontalPadding;
    private static final PaddingValues DatePickerModeTogglePadding;
    private static final PaddingValues DatePickerTitlePadding;
    private static final int MaxCalendarRows = 6;
    private static final int YearsInRow = 3;
    private static final float YearsVerticalPadding;
    private static final float RecommendedSizeForAccessibility = Dp.m6389constructorimpl(48);
    private static final float MonthYearHeight = Dp.m6389constructorimpl(56);

    /* JADX WARN: Removed duplicated region for block: B:101:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0158  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DatePicker(final DatePickerState datePickerState, Modifier modifier, DatePickerFormatter datePickerFormatter, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, boolean z, DatePickerColors datePickerColors, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function23;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i6;
        boolean z2;
        DatePickerColors datePickerColors2;
        final DatePickerFormatter datePickerFormatter2;
        int i7;
        boolean z3;
        final DatePickerColors colors;
        Function2<? super Composer, ? super Integer, Unit> function25;
        boolean changed;
        Object rememberedValue;
        Composer composer2;
        final DatePickerFormatter datePickerFormatter3;
        final boolean z4;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final DatePickerColors datePickerColors3;
        ScopeUpdateScope endRestartGroup;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(809701813);
        ComposerKt.sourceInformation(startRestartGroup, "C(DatePicker)P(5,3,1,6,2,4)154@7440L47,170@8108L8,172@8145L15,173@8185L62,189@8801L10,174@8252L1391:DatePicker.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(datePickerState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i10 = i2 & 2;
        if (i10 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    if ((i & 512) == 0 ? startRestartGroup.changed(datePickerFormatter) : startRestartGroup.changedInstance(datePickerFormatter)) {
                        i9 = 256;
                        i3 |= i9;
                    }
                }
                i9 = 128;
                i3 |= i9;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                function23 = function2;
                i3 |= startRestartGroup.changedInstance(function23) ? 2048 : 1024;
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
                        z2 = z;
                        i3 |= startRestartGroup.changed(z2) ? 131072 : 65536;
                        if ((1572864 & i) == 0) {
                            if ((i2 & 64) == 0) {
                                datePickerColors2 = datePickerColors;
                                if (startRestartGroup.changed(datePickerColors2)) {
                                    i8 = 1048576;
                                    i3 |= i8;
                                }
                            } else {
                                datePickerColors2 = datePickerColors;
                            }
                            i8 = 524288;
                            i3 |= i8;
                        } else {
                            datePickerColors2 = datePickerColors;
                        }
                        if ((599187 & i3) == 599186 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                if (i10 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if ((i2 & 4) != 0) {
                                    startRestartGroup.startReplaceableGroup(1809358065);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
                                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                                    if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                        startRestartGroup.updateRememberedValue(rememberedValue2);
                                    }
                                    datePickerFormatter2 = (DatePickerFormatter) rememberedValue2;
                                    startRestartGroup.endReplaceableGroup();
                                    i3 &= -897;
                                } else {
                                    datePickerFormatter2 = datePickerFormatter;
                                }
                                if (i4 != 0) {
                                    function23 = ComposableLambdaKt.composableLambda(startRestartGroup, -1504998463, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$2
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i11) {
                                            PaddingValues paddingValues;
                                            ComposerKt.sourceInformation(composer3, "C156@7557L135:DatePicker.kt#uh7d8r");
                                            if ((i11 & 3) != 2 || !composer3.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1504998463, i11, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:156)");
                                                }
                                                DatePickerDefaults datePickerDefaults = DatePickerDefaults.INSTANCE;
                                                int mo2146getDisplayModejFl4v0 = DatePickerState.this.mo2146getDisplayModejFl4v0();
                                                Modifier.Companion companion = Modifier.INSTANCE;
                                                paddingValues = DatePickerKt.DatePickerTitlePadding;
                                                datePickerDefaults.m2131DatePickerTitlehOD91z4(mo2146getDisplayModejFl4v0, PaddingKt.padding(companion, paddingValues), composer3, 432, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    });
                                }
                                if (i5 != 0) {
                                    function24 = ComposableLambdaKt.composableLambda(startRestartGroup, -1780043561, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$3
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i11) {
                                            PaddingValues paddingValues;
                                            ComposerKt.sourceInformation(composer3, "C162@7771L243:DatePicker.kt#uh7d8r");
                                            if ((i11 & 3) != 2 || !composer3.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1780043561, i11, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:162)");
                                                }
                                                DatePickerDefaults datePickerDefaults = DatePickerDefaults.INSTANCE;
                                                Long selectedDateMillis = DatePickerState.this.getSelectedDateMillis();
                                                int mo2146getDisplayModejFl4v0 = DatePickerState.this.mo2146getDisplayModejFl4v0();
                                                DatePickerFormatter datePickerFormatter4 = datePickerFormatter2;
                                                Modifier.Companion companion = Modifier.INSTANCE;
                                                paddingValues = DatePickerKt.DatePickerHeadlinePadding;
                                                datePickerDefaults.m2130DatePickerHeadline3kbWawI(selectedDateMillis, mo2146getDisplayModejFl4v0, datePickerFormatter4, PaddingKt.padding(companion, paddingValues), composer3, 27648, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    });
                                }
                                if (i6 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 64) != 0) {
                                    i7 = i3 & (-3670017);
                                    z3 = z2;
                                    colors = DatePickerDefaults.INSTANCE.colors(startRestartGroup, 6);
                                    function25 = function23;
                                    Modifier modifier4 = modifier2;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(809701813, i7, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:171)");
                                    }
                                    Locale defaultLocale = ActualAndroid_androidKt.defaultLocale(startRestartGroup, 0);
                                    startRestartGroup.startReplaceableGroup(1809358810);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
                                    changed = startRestartGroup.changed(defaultLocale);
                                    rememberedValue = startRestartGroup.rememberedValue();
                                    if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = CalendarModel_androidKt.createCalendarModel(defaultLocale);
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    final CalendarModel calendarModel = (CalendarModel) rememberedValue;
                                    startRestartGroup.endReplaceableGroup();
                                    int i11 = ((i7 >> 3) & 14) | 14155776;
                                    int i12 = i7 >> 6;
                                    composer2 = startRestartGroup;
                                    m2135DateEntryContainerau3_HiA(modifier4, function25, function24, !z3 ? ComposableLambdaKt.composableLambda(startRestartGroup, 1982226759, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$4
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i13) {
                                            ComposerKt.sourceInformation(composer3, "C183@8630L50,180@8432L267:DatePicker.kt#uh7d8r");
                                            if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1982226759, i13, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:180)");
                                                }
                                                Modifier padding = PaddingKt.padding(Modifier.INSTANCE, DatePickerKt.getDatePickerModeTogglePadding());
                                                int mo2146getDisplayModejFl4v0 = DatePickerState.this.mo2146getDisplayModejFl4v0();
                                                composer3.startReplaceableGroup(-1036920264);
                                                ComposerKt.sourceInformation(composer3, "CC(remember):DatePicker.kt#9igjgp");
                                                boolean changed2 = composer3.changed(DatePickerState.this);
                                                final DatePickerState datePickerState2 = DatePickerState.this;
                                                Object rememberedValue3 = composer3.rememberedValue();
                                                if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue3 = (Function1) new Function1<DisplayMode, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$4$1$1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public /* bridge */ /* synthetic */ Unit invoke(DisplayMode displayMode) {
                                                            m2143invokevCnGnXg(displayMode.getValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        /* renamed from: invoke-vCnGnXg, reason: not valid java name */
                                                        public final void m2143invokevCnGnXg(int i14) {
                                                            DatePickerState.this.mo2147setDisplayModevCnGnXg(i14);
                                                        }
                                                    };
                                                    composer3.updateRememberedValue(rememberedValue3);
                                                }
                                                composer3.endReplaceableGroup();
                                                DatePickerKt.m2139DisplayModeToggleButtontER2X8s(padding, mo2146getDisplayModejFl4v0, (Function1) rememberedValue3, composer3, 6);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    }) : null, colors, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), DatePickerModalTokens.INSTANCE.getHeaderHeadlineFont()), DatePickerModalTokens.INSTANCE.m3102getHeaderContainerHeightD9Ej5fM(), ComposableLambdaKt.composableLambda(startRestartGroup, -1840727866, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$5
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
                                            ComposerKt.sourceInformation(composer3, "C199@9229L59,200@9327L91,195@8998L639:DatePicker.kt#uh7d8r");
                                            if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1840727866, i13, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:195)");
                                                }
                                                Long selectedDateMillis = DatePickerState.this.getSelectedDateMillis();
                                                long displayedMonthMillis = DatePickerState.this.getDisplayedMonthMillis();
                                                int mo2146getDisplayModejFl4v0 = DatePickerState.this.mo2146getDisplayModejFl4v0();
                                                composer3.startReplaceableGroup(-1036919665);
                                                ComposerKt.sourceInformation(composer3, "CC(remember):DatePicker.kt#9igjgp");
                                                boolean changed2 = composer3.changed(DatePickerState.this);
                                                final DatePickerState datePickerState2 = DatePickerState.this;
                                                Object rememberedValue3 = composer3.rememberedValue();
                                                if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue3 = (Function1) new Function1<Long, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$5$1$1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                                                            invoke2(l);
                                                            return Unit.INSTANCE;
                                                        }

                                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                        public final void invoke2(Long l) {
                                                            DatePickerState.this.setSelectedDateMillis(l);
                                                        }
                                                    };
                                                    composer3.updateRememberedValue(rememberedValue3);
                                                }
                                                Function1 function1 = (Function1) rememberedValue3;
                                                composer3.endReplaceableGroup();
                                                composer3.startReplaceableGroup(-1036919567);
                                                ComposerKt.sourceInformation(composer3, "CC(remember):DatePicker.kt#9igjgp");
                                                boolean changed3 = composer3.changed(DatePickerState.this);
                                                final DatePickerState datePickerState3 = DatePickerState.this;
                                                Object rememberedValue4 = composer3.rememberedValue();
                                                if (changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue4 = (Function1) new Function1<Long, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$5$2$1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                                                            invoke(l.longValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(long j) {
                                                            DatePickerState.this.setDisplayedMonthMillis(j);
                                                        }
                                                    };
                                                    composer3.updateRememberedValue(rememberedValue4);
                                                }
                                                composer3.endReplaceableGroup();
                                                DatePickerKt.m2140SwitchableDateEntryContentd7iavvg(selectedDateMillis, displayedMonthMillis, mo2146getDisplayModejFl4v0, function1, (Function1) rememberedValue4, calendarModel, DatePickerState.this.getYearRange(), datePickerFormatter2, DatePickerState.this.getSelectableDates(), colors, composer3, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    }), composer2, i11 | (i12 & 112) | (i12 & 896) | (i12 & 57344));
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    datePickerFormatter3 = datePickerFormatter2;
                                    z4 = z3;
                                    modifier3 = modifier4;
                                    function26 = function25;
                                    datePickerColors3 = colors;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 4) != 0) {
                                    i3 &= -897;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                }
                                datePickerFormatter2 = datePickerFormatter;
                            }
                            i7 = i3;
                            function25 = function23;
                            z3 = z2;
                            colors = datePickerColors2;
                            Modifier modifier42 = modifier2;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            Locale defaultLocale2 = ActualAndroid_androidKt.defaultLocale(startRestartGroup, 0);
                            startRestartGroup.startReplaceableGroup(1809358810);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
                            changed = startRestartGroup.changed(defaultLocale2);
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (!changed) {
                            }
                            rememberedValue = CalendarModel_androidKt.createCalendarModel(defaultLocale2);
                            startRestartGroup.updateRememberedValue(rememberedValue);
                            final CalendarModel calendarModel2 = (CalendarModel) rememberedValue;
                            startRestartGroup.endReplaceableGroup();
                            if (!z3) {
                            }
                            int i112 = ((i7 >> 3) & 14) | 14155776;
                            int i122 = i7 >> 6;
                            composer2 = startRestartGroup;
                            m2135DateEntryContainerau3_HiA(modifier42, function25, function24, !z3 ? ComposableLambdaKt.composableLambda(startRestartGroup, 1982226759, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$4
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i13) {
                                    ComposerKt.sourceInformation(composer3, "C183@8630L50,180@8432L267:DatePicker.kt#uh7d8r");
                                    if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1982226759, i13, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:180)");
                                        }
                                        Modifier padding = PaddingKt.padding(Modifier.INSTANCE, DatePickerKt.getDatePickerModeTogglePadding());
                                        int mo2146getDisplayModejFl4v0 = DatePickerState.this.mo2146getDisplayModejFl4v0();
                                        composer3.startReplaceableGroup(-1036920264);
                                        ComposerKt.sourceInformation(composer3, "CC(remember):DatePicker.kt#9igjgp");
                                        boolean changed2 = composer3.changed(DatePickerState.this);
                                        final DatePickerState datePickerState2 = DatePickerState.this;
                                        Object rememberedValue3 = composer3.rememberedValue();
                                        if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue3 = (Function1) new Function1<DisplayMode, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$4$1$1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(DisplayMode displayMode) {
                                                    m2143invokevCnGnXg(displayMode.getValue());
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke-vCnGnXg, reason: not valid java name */
                                                public final void m2143invokevCnGnXg(int i14) {
                                                    DatePickerState.this.mo2147setDisplayModevCnGnXg(i14);
                                                }
                                            };
                                            composer3.updateRememberedValue(rememberedValue3);
                                        }
                                        composer3.endReplaceableGroup();
                                        DatePickerKt.m2139DisplayModeToggleButtontER2X8s(padding, mo2146getDisplayModejFl4v0, (Function1) rememberedValue3, composer3, 6);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }) : null, colors, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), DatePickerModalTokens.INSTANCE.getHeaderHeadlineFont()), DatePickerModalTokens.INSTANCE.m3102getHeaderContainerHeightD9Ej5fM(), ComposableLambdaKt.composableLambda(startRestartGroup, -1840727866, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$5
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
                                    ComposerKt.sourceInformation(composer3, "C199@9229L59,200@9327L91,195@8998L639:DatePicker.kt#uh7d8r");
                                    if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1840727866, i13, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:195)");
                                        }
                                        Long selectedDateMillis = DatePickerState.this.getSelectedDateMillis();
                                        long displayedMonthMillis = DatePickerState.this.getDisplayedMonthMillis();
                                        int mo2146getDisplayModejFl4v0 = DatePickerState.this.mo2146getDisplayModejFl4v0();
                                        composer3.startReplaceableGroup(-1036919665);
                                        ComposerKt.sourceInformation(composer3, "CC(remember):DatePicker.kt#9igjgp");
                                        boolean changed2 = composer3.changed(DatePickerState.this);
                                        final DatePickerState datePickerState2 = DatePickerState.this;
                                        Object rememberedValue3 = composer3.rememberedValue();
                                        if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue3 = (Function1) new Function1<Long, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$5$1$1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                                                    invoke2(l);
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(Long l) {
                                                    DatePickerState.this.setSelectedDateMillis(l);
                                                }
                                            };
                                            composer3.updateRememberedValue(rememberedValue3);
                                        }
                                        Function1 function1 = (Function1) rememberedValue3;
                                        composer3.endReplaceableGroup();
                                        composer3.startReplaceableGroup(-1036919567);
                                        ComposerKt.sourceInformation(composer3, "CC(remember):DatePicker.kt#9igjgp");
                                        boolean changed3 = composer3.changed(DatePickerState.this);
                                        final DatePickerState datePickerState3 = DatePickerState.this;
                                        Object rememberedValue4 = composer3.rememberedValue();
                                        if (changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue4 = (Function1) new Function1<Long, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$5$2$1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                                                    invoke(l.longValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(long j) {
                                                    DatePickerState.this.setDisplayedMonthMillis(j);
                                                }
                                            };
                                            composer3.updateRememberedValue(rememberedValue4);
                                        }
                                        composer3.endReplaceableGroup();
                                        DatePickerKt.m2140SwitchableDateEntryContentd7iavvg(selectedDateMillis, displayedMonthMillis, mo2146getDisplayModejFl4v0, function1, (Function1) rememberedValue4, calendarModel2, DatePickerState.this.getYearRange(), datePickerFormatter2, DatePickerState.this.getSelectableDates(), colors, composer3, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), composer2, i112 | (i122 & 112) | (i122 & 896) | (i122 & 57344));
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            datePickerFormatter3 = datePickerFormatter2;
                            z4 = z3;
                            modifier3 = modifier42;
                            function26 = function25;
                            datePickerColors3 = colors;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            composer2 = startRestartGroup;
                            modifier3 = modifier2;
                            function26 = function23;
                            z4 = z2;
                            datePickerColors3 = datePickerColors2;
                            datePickerFormatter3 = datePickerFormatter;
                        }
                        final Function2<? super Composer, ? super Integer, Unit> function27 = function24;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$6
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
                                    DatePickerKt.DatePicker(DatePickerState.this, modifier3, datePickerFormatter3, function26, function27, z4, datePickerColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    z2 = z;
                    if ((1572864 & i) == 0) {
                    }
                    if ((599187 & i3) == 599186) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if ((i2 & 4) != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if ((i2 & 64) != 0) {
                    }
                    i7 = i3;
                    function25 = function23;
                    z3 = z2;
                    colors = datePickerColors2;
                    Modifier modifier422 = modifier2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    Locale defaultLocale22 = ActualAndroid_androidKt.defaultLocale(startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(1809358810);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
                    changed = startRestartGroup.changed(defaultLocale22);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue = CalendarModel_androidKt.createCalendarModel(defaultLocale22);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    final CalendarModel calendarModel22 = (CalendarModel) rememberedValue;
                    startRestartGroup.endReplaceableGroup();
                    if (!z3) {
                    }
                    int i1122 = ((i7 >> 3) & 14) | 14155776;
                    int i1222 = i7 >> 6;
                    composer2 = startRestartGroup;
                    m2135DateEntryContainerau3_HiA(modifier422, function25, function24, !z3 ? ComposableLambdaKt.composableLambda(startRestartGroup, 1982226759, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$4
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i13) {
                            ComposerKt.sourceInformation(composer3, "C183@8630L50,180@8432L267:DatePicker.kt#uh7d8r");
                            if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1982226759, i13, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:180)");
                                }
                                Modifier padding = PaddingKt.padding(Modifier.INSTANCE, DatePickerKt.getDatePickerModeTogglePadding());
                                int mo2146getDisplayModejFl4v0 = DatePickerState.this.mo2146getDisplayModejFl4v0();
                                composer3.startReplaceableGroup(-1036920264);
                                ComposerKt.sourceInformation(composer3, "CC(remember):DatePicker.kt#9igjgp");
                                boolean changed2 = composer3.changed(DatePickerState.this);
                                final DatePickerState datePickerState2 = DatePickerState.this;
                                Object rememberedValue3 = composer3.rememberedValue();
                                if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue3 = (Function1) new Function1<DisplayMode, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$4$1$1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(DisplayMode displayMode) {
                                            m2143invokevCnGnXg(displayMode.getValue());
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke-vCnGnXg, reason: not valid java name */
                                        public final void m2143invokevCnGnXg(int i14) {
                                            DatePickerState.this.mo2147setDisplayModevCnGnXg(i14);
                                        }
                                    };
                                    composer3.updateRememberedValue(rememberedValue3);
                                }
                                composer3.endReplaceableGroup();
                                DatePickerKt.m2139DisplayModeToggleButtontER2X8s(padding, mo2146getDisplayModejFl4v0, (Function1) rememberedValue3, composer3, 6);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }) : null, colors, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), DatePickerModalTokens.INSTANCE.getHeaderHeadlineFont()), DatePickerModalTokens.INSTANCE.m3102getHeaderContainerHeightD9Ej5fM(), ComposableLambdaKt.composableLambda(startRestartGroup, -1840727866, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$5
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
                            ComposerKt.sourceInformation(composer3, "C199@9229L59,200@9327L91,195@8998L639:DatePicker.kt#uh7d8r");
                            if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1840727866, i13, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:195)");
                                }
                                Long selectedDateMillis = DatePickerState.this.getSelectedDateMillis();
                                long displayedMonthMillis = DatePickerState.this.getDisplayedMonthMillis();
                                int mo2146getDisplayModejFl4v0 = DatePickerState.this.mo2146getDisplayModejFl4v0();
                                composer3.startReplaceableGroup(-1036919665);
                                ComposerKt.sourceInformation(composer3, "CC(remember):DatePicker.kt#9igjgp");
                                boolean changed2 = composer3.changed(DatePickerState.this);
                                final DatePickerState datePickerState2 = DatePickerState.this;
                                Object rememberedValue3 = composer3.rememberedValue();
                                if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue3 = (Function1) new Function1<Long, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$5$1$1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                                            invoke2(l);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(Long l) {
                                            DatePickerState.this.setSelectedDateMillis(l);
                                        }
                                    };
                                    composer3.updateRememberedValue(rememberedValue3);
                                }
                                Function1 function1 = (Function1) rememberedValue3;
                                composer3.endReplaceableGroup();
                                composer3.startReplaceableGroup(-1036919567);
                                ComposerKt.sourceInformation(composer3, "CC(remember):DatePicker.kt#9igjgp");
                                boolean changed3 = composer3.changed(DatePickerState.this);
                                final DatePickerState datePickerState3 = DatePickerState.this;
                                Object rememberedValue4 = composer3.rememberedValue();
                                if (changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue4 = (Function1) new Function1<Long, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$5$2$1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                                            invoke(l.longValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(long j) {
                                            DatePickerState.this.setDisplayedMonthMillis(j);
                                        }
                                    };
                                    composer3.updateRememberedValue(rememberedValue4);
                                }
                                composer3.endReplaceableGroup();
                                DatePickerKt.m2140SwitchableDateEntryContentd7iavvg(selectedDateMillis, displayedMonthMillis, mo2146getDisplayModejFl4v0, function1, (Function1) rememberedValue4, calendarModel22, DatePickerState.this.getYearRange(), datePickerFormatter2, DatePickerState.this.getSelectableDates(), colors, composer3, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), composer2, i1122 | (i1222 & 112) | (i1222 & 896) | (i1222 & 57344));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    datePickerFormatter3 = datePickerFormatter2;
                    z4 = z3;
                    modifier3 = modifier422;
                    function26 = function25;
                    datePickerColors3 = colors;
                    final Function2<? super Composer, ? super Integer, Unit> function272 = function24;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function24 = function22;
                i6 = i2 & 32;
                if (i6 == 0) {
                }
                z2 = z;
                if ((1572864 & i) == 0) {
                }
                if ((599187 & i3) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i10 != 0) {
                }
                if ((i2 & 4) != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if ((i2 & 64) != 0) {
                }
                i7 = i3;
                function25 = function23;
                z3 = z2;
                colors = datePickerColors2;
                Modifier modifier4222 = modifier2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                Locale defaultLocale222 = ActualAndroid_androidKt.defaultLocale(startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(1809358810);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
                changed = startRestartGroup.changed(defaultLocale222);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue = CalendarModel_androidKt.createCalendarModel(defaultLocale222);
                startRestartGroup.updateRememberedValue(rememberedValue);
                final CalendarModel calendarModel222 = (CalendarModel) rememberedValue;
                startRestartGroup.endReplaceableGroup();
                if (!z3) {
                }
                int i11222 = ((i7 >> 3) & 14) | 14155776;
                int i12222 = i7 >> 6;
                composer2 = startRestartGroup;
                m2135DateEntryContainerau3_HiA(modifier4222, function25, function24, !z3 ? ComposableLambdaKt.composableLambda(startRestartGroup, 1982226759, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$4
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i13) {
                        ComposerKt.sourceInformation(composer3, "C183@8630L50,180@8432L267:DatePicker.kt#uh7d8r");
                        if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1982226759, i13, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:180)");
                            }
                            Modifier padding = PaddingKt.padding(Modifier.INSTANCE, DatePickerKt.getDatePickerModeTogglePadding());
                            int mo2146getDisplayModejFl4v0 = DatePickerState.this.mo2146getDisplayModejFl4v0();
                            composer3.startReplaceableGroup(-1036920264);
                            ComposerKt.sourceInformation(composer3, "CC(remember):DatePicker.kt#9igjgp");
                            boolean changed2 = composer3.changed(DatePickerState.this);
                            final DatePickerState datePickerState2 = DatePickerState.this;
                            Object rememberedValue3 = composer3.rememberedValue();
                            if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue3 = (Function1) new Function1<DisplayMode, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$4$1$1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(DisplayMode displayMode) {
                                        m2143invokevCnGnXg(displayMode.getValue());
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke-vCnGnXg, reason: not valid java name */
                                    public final void m2143invokevCnGnXg(int i14) {
                                        DatePickerState.this.mo2147setDisplayModevCnGnXg(i14);
                                    }
                                };
                                composer3.updateRememberedValue(rememberedValue3);
                            }
                            composer3.endReplaceableGroup();
                            DatePickerKt.m2139DisplayModeToggleButtontER2X8s(padding, mo2146getDisplayModejFl4v0, (Function1) rememberedValue3, composer3, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }) : null, colors, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), DatePickerModalTokens.INSTANCE.getHeaderHeadlineFont()), DatePickerModalTokens.INSTANCE.m3102getHeaderContainerHeightD9Ej5fM(), ComposableLambdaKt.composableLambda(startRestartGroup, -1840727866, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$5
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
                        ComposerKt.sourceInformation(composer3, "C199@9229L59,200@9327L91,195@8998L639:DatePicker.kt#uh7d8r");
                        if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1840727866, i13, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:195)");
                            }
                            Long selectedDateMillis = DatePickerState.this.getSelectedDateMillis();
                            long displayedMonthMillis = DatePickerState.this.getDisplayedMonthMillis();
                            int mo2146getDisplayModejFl4v0 = DatePickerState.this.mo2146getDisplayModejFl4v0();
                            composer3.startReplaceableGroup(-1036919665);
                            ComposerKt.sourceInformation(composer3, "CC(remember):DatePicker.kt#9igjgp");
                            boolean changed2 = composer3.changed(DatePickerState.this);
                            final DatePickerState datePickerState2 = DatePickerState.this;
                            Object rememberedValue3 = composer3.rememberedValue();
                            if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue3 = (Function1) new Function1<Long, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$5$1$1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                                        invoke2(l);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Long l) {
                                        DatePickerState.this.setSelectedDateMillis(l);
                                    }
                                };
                                composer3.updateRememberedValue(rememberedValue3);
                            }
                            Function1 function1 = (Function1) rememberedValue3;
                            composer3.endReplaceableGroup();
                            composer3.startReplaceableGroup(-1036919567);
                            ComposerKt.sourceInformation(composer3, "CC(remember):DatePicker.kt#9igjgp");
                            boolean changed3 = composer3.changed(DatePickerState.this);
                            final DatePickerState datePickerState3 = DatePickerState.this;
                            Object rememberedValue4 = composer3.rememberedValue();
                            if (changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue4 = (Function1) new Function1<Long, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$5$2$1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                                        invoke(l.longValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(long j) {
                                        DatePickerState.this.setDisplayedMonthMillis(j);
                                    }
                                };
                                composer3.updateRememberedValue(rememberedValue4);
                            }
                            composer3.endReplaceableGroup();
                            DatePickerKt.m2140SwitchableDateEntryContentd7iavvg(selectedDateMillis, displayedMonthMillis, mo2146getDisplayModejFl4v0, function1, (Function1) rememberedValue4, calendarModel222, DatePickerState.this.getYearRange(), datePickerFormatter2, DatePickerState.this.getSelectableDates(), colors, composer3, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), composer2, i11222 | (i12222 & 112) | (i12222 & 896) | (i12222 & 57344));
                if (ComposerKt.isTraceInProgress()) {
                }
                datePickerFormatter3 = datePickerFormatter2;
                z4 = z3;
                modifier3 = modifier4222;
                function26 = function25;
                datePickerColors3 = colors;
                final Function2<? super Composer, ? super Integer, Unit> function2722 = function24;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function23 = function2;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            function24 = function22;
            i6 = i2 & 32;
            if (i6 == 0) {
            }
            z2 = z;
            if ((1572864 & i) == 0) {
            }
            if ((599187 & i3) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i10 != 0) {
            }
            if ((i2 & 4) != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if ((i2 & 64) != 0) {
            }
            i7 = i3;
            function25 = function23;
            z3 = z2;
            colors = datePickerColors2;
            Modifier modifier42222 = modifier2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            Locale defaultLocale2222 = ActualAndroid_androidKt.defaultLocale(startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(1809358810);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
            changed = startRestartGroup.changed(defaultLocale2222);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue = CalendarModel_androidKt.createCalendarModel(defaultLocale2222);
            startRestartGroup.updateRememberedValue(rememberedValue);
            final CalendarModel calendarModel2222 = (CalendarModel) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            if (!z3) {
            }
            int i112222 = ((i7 >> 3) & 14) | 14155776;
            int i122222 = i7 >> 6;
            composer2 = startRestartGroup;
            m2135DateEntryContainerau3_HiA(modifier42222, function25, function24, !z3 ? ComposableLambdaKt.composableLambda(startRestartGroup, 1982226759, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$4
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i13) {
                    ComposerKt.sourceInformation(composer3, "C183@8630L50,180@8432L267:DatePicker.kt#uh7d8r");
                    if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1982226759, i13, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:180)");
                        }
                        Modifier padding = PaddingKt.padding(Modifier.INSTANCE, DatePickerKt.getDatePickerModeTogglePadding());
                        int mo2146getDisplayModejFl4v0 = DatePickerState.this.mo2146getDisplayModejFl4v0();
                        composer3.startReplaceableGroup(-1036920264);
                        ComposerKt.sourceInformation(composer3, "CC(remember):DatePicker.kt#9igjgp");
                        boolean changed2 = composer3.changed(DatePickerState.this);
                        final DatePickerState datePickerState2 = DatePickerState.this;
                        Object rememberedValue3 = composer3.rememberedValue();
                        if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue3 = (Function1) new Function1<DisplayMode, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$4$1$1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(DisplayMode displayMode) {
                                    m2143invokevCnGnXg(displayMode.getValue());
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke-vCnGnXg, reason: not valid java name */
                                public final void m2143invokevCnGnXg(int i14) {
                                    DatePickerState.this.mo2147setDisplayModevCnGnXg(i14);
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue3);
                        }
                        composer3.endReplaceableGroup();
                        DatePickerKt.m2139DisplayModeToggleButtontER2X8s(padding, mo2146getDisplayModejFl4v0, (Function1) rememberedValue3, composer3, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }) : null, colors, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), DatePickerModalTokens.INSTANCE.getHeaderHeadlineFont()), DatePickerModalTokens.INSTANCE.m3102getHeaderContainerHeightD9Ej5fM(), ComposableLambdaKt.composableLambda(startRestartGroup, -1840727866, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$5
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
                    ComposerKt.sourceInformation(composer3, "C199@9229L59,200@9327L91,195@8998L639:DatePicker.kt#uh7d8r");
                    if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1840727866, i13, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:195)");
                        }
                        Long selectedDateMillis = DatePickerState.this.getSelectedDateMillis();
                        long displayedMonthMillis = DatePickerState.this.getDisplayedMonthMillis();
                        int mo2146getDisplayModejFl4v0 = DatePickerState.this.mo2146getDisplayModejFl4v0();
                        composer3.startReplaceableGroup(-1036919665);
                        ComposerKt.sourceInformation(composer3, "CC(remember):DatePicker.kt#9igjgp");
                        boolean changed2 = composer3.changed(DatePickerState.this);
                        final DatePickerState datePickerState2 = DatePickerState.this;
                        Object rememberedValue3 = composer3.rememberedValue();
                        if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue3 = (Function1) new Function1<Long, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$5$1$1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                                    invoke2(l);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Long l) {
                                    DatePickerState.this.setSelectedDateMillis(l);
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue3);
                        }
                        Function1 function1 = (Function1) rememberedValue3;
                        composer3.endReplaceableGroup();
                        composer3.startReplaceableGroup(-1036919567);
                        ComposerKt.sourceInformation(composer3, "CC(remember):DatePicker.kt#9igjgp");
                        boolean changed3 = composer3.changed(DatePickerState.this);
                        final DatePickerState datePickerState3 = DatePickerState.this;
                        Object rememberedValue4 = composer3.rememberedValue();
                        if (changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue4 = (Function1) new Function1<Long, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$5$2$1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                                    invoke(l.longValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(long j) {
                                    DatePickerState.this.setDisplayedMonthMillis(j);
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue4);
                        }
                        composer3.endReplaceableGroup();
                        DatePickerKt.m2140SwitchableDateEntryContentd7iavvg(selectedDateMillis, displayedMonthMillis, mo2146getDisplayModejFl4v0, function1, (Function1) rememberedValue4, calendarModel2222, DatePickerState.this.getYearRange(), datePickerFormatter2, DatePickerState.this.getSelectableDates(), colors, composer3, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), composer2, i112222 | (i122222 & 112) | (i122222 & 896) | (i122222 & 57344));
            if (ComposerKt.isTraceInProgress()) {
            }
            datePickerFormatter3 = datePickerFormatter2;
            z4 = z3;
            modifier3 = modifier42222;
            function26 = function25;
            datePickerColors3 = colors;
            final Function2<? super Composer, ? super Integer, Unit> function27222 = function24;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i & 384) == 0) {
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        function23 = function2;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        function24 = function22;
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        z2 = z;
        if ((1572864 & i) == 0) {
        }
        if ((599187 & i3) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i10 != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        i7 = i3;
        function25 = function23;
        z3 = z2;
        colors = datePickerColors2;
        Modifier modifier422222 = modifier2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        Locale defaultLocale22222 = ActualAndroid_androidKt.defaultLocale(startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(1809358810);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
        changed = startRestartGroup.changed(defaultLocale22222);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue = CalendarModel_androidKt.createCalendarModel(defaultLocale22222);
        startRestartGroup.updateRememberedValue(rememberedValue);
        final CalendarModel calendarModel22222 = (CalendarModel) rememberedValue;
        startRestartGroup.endReplaceableGroup();
        if (!z3) {
        }
        int i1122222 = ((i7 >> 3) & 14) | 14155776;
        int i1222222 = i7 >> 6;
        composer2 = startRestartGroup;
        m2135DateEntryContainerau3_HiA(modifier422222, function25, function24, !z3 ? ComposableLambdaKt.composableLambda(startRestartGroup, 1982226759, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$4
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                invoke(composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer3, int i13) {
                ComposerKt.sourceInformation(composer3, "C183@8630L50,180@8432L267:DatePicker.kt#uh7d8r");
                if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1982226759, i13, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:180)");
                    }
                    Modifier padding = PaddingKt.padding(Modifier.INSTANCE, DatePickerKt.getDatePickerModeTogglePadding());
                    int mo2146getDisplayModejFl4v0 = DatePickerState.this.mo2146getDisplayModejFl4v0();
                    composer3.startReplaceableGroup(-1036920264);
                    ComposerKt.sourceInformation(composer3, "CC(remember):DatePicker.kt#9igjgp");
                    boolean changed2 = composer3.changed(DatePickerState.this);
                    final DatePickerState datePickerState2 = DatePickerState.this;
                    Object rememberedValue3 = composer3.rememberedValue();
                    if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue3 = (Function1) new Function1<DisplayMode, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$4$1$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(DisplayMode displayMode) {
                                m2143invokevCnGnXg(displayMode.getValue());
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke-vCnGnXg, reason: not valid java name */
                            public final void m2143invokevCnGnXg(int i14) {
                                DatePickerState.this.mo2147setDisplayModevCnGnXg(i14);
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue3);
                    }
                    composer3.endReplaceableGroup();
                    DatePickerKt.m2139DisplayModeToggleButtontER2X8s(padding, mo2146getDisplayModejFl4v0, (Function1) rememberedValue3, composer3, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }) : null, colors, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), DatePickerModalTokens.INSTANCE.getHeaderHeadlineFont()), DatePickerModalTokens.INSTANCE.m3102getHeaderContainerHeightD9Ej5fM(), ComposableLambdaKt.composableLambda(startRestartGroup, -1840727866, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$5
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
                ComposerKt.sourceInformation(composer3, "C199@9229L59,200@9327L91,195@8998L639:DatePicker.kt#uh7d8r");
                if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1840727866, i13, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:195)");
                    }
                    Long selectedDateMillis = DatePickerState.this.getSelectedDateMillis();
                    long displayedMonthMillis = DatePickerState.this.getDisplayedMonthMillis();
                    int mo2146getDisplayModejFl4v0 = DatePickerState.this.mo2146getDisplayModejFl4v0();
                    composer3.startReplaceableGroup(-1036919665);
                    ComposerKt.sourceInformation(composer3, "CC(remember):DatePicker.kt#9igjgp");
                    boolean changed2 = composer3.changed(DatePickerState.this);
                    final DatePickerState datePickerState2 = DatePickerState.this;
                    Object rememberedValue3 = composer3.rememberedValue();
                    if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue3 = (Function1) new Function1<Long, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$5$1$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                                invoke2(l);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Long l) {
                                DatePickerState.this.setSelectedDateMillis(l);
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue3);
                    }
                    Function1 function1 = (Function1) rememberedValue3;
                    composer3.endReplaceableGroup();
                    composer3.startReplaceableGroup(-1036919567);
                    ComposerKt.sourceInformation(composer3, "CC(remember):DatePicker.kt#9igjgp");
                    boolean changed3 = composer3.changed(DatePickerState.this);
                    final DatePickerState datePickerState3 = DatePickerState.this;
                    Object rememberedValue4 = composer3.rememberedValue();
                    if (changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue4 = (Function1) new Function1<Long, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$5$2$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                                invoke(l.longValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(long j) {
                                DatePickerState.this.setDisplayedMonthMillis(j);
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue4);
                    }
                    composer3.endReplaceableGroup();
                    DatePickerKt.m2140SwitchableDateEntryContentd7iavvg(selectedDateMillis, displayedMonthMillis, mo2146getDisplayModejFl4v0, function1, (Function1) rememberedValue4, calendarModel22222, DatePickerState.this.getYearRange(), datePickerFormatter2, DatePickerState.this.getSelectableDates(), colors, composer3, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }), composer2, i1122222 | (i1222222 & 112) | (i1222222 & 896) | (i1222222 & 57344));
        if (ComposerKt.isTraceInProgress()) {
        }
        datePickerFormatter3 = datePickerFormatter2;
        z4 = z3;
        modifier3 = modifier422222;
        function26 = function25;
        datePickerColors3 = colors;
        final Function2<? super Composer, ? super Integer, Unit> function272222 = function24;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* renamed from: rememberDatePickerState-EU0dCGE, reason: not valid java name */
    public static final DatePickerState m2142rememberDatePickerStateEU0dCGE(Long l, Long l2, IntRange intRange, int i, SelectableDates selectableDates, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(2065763010);
        ComposerKt.sourceInformation(composer, "C(rememberDatePickerState)P(2,1,4,0:c#material3.DisplayMode)364@14941L15,367@15059L347,365@14968L438:DatePicker.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            l = null;
        }
        final Long l3 = l;
        final Long l4 = (i3 & 2) != 0 ? l3 : l2;
        if ((i3 & 4) != 0) {
            intRange = DatePickerDefaults.INSTANCE.getYearRange();
        }
        final IntRange intRange2 = intRange;
        if ((i3 & 8) != 0) {
            i = DisplayMode.INSTANCE.m2178getPickerjFl4v0();
        }
        final int i4 = i;
        if ((i3 & 16) != 0) {
            selectableDates = DatePickerDefaults.INSTANCE.getAllDates();
        }
        final SelectableDates selectableDates2 = selectableDates;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2065763010, i2, -1, "androidx.compose.material3.rememberDatePickerState (DatePicker.kt:363)");
        }
        final Locale defaultLocale = ActualAndroid_androidKt.defaultLocale(composer, 0);
        Object[] objArr = new Object[0];
        Saver<DatePickerStateImpl, Object> Saver = DatePickerStateImpl.INSTANCE.Saver(selectableDates2, defaultLocale);
        composer.startReplaceableGroup(-1398082866);
        ComposerKt.sourceInformation(composer, "CC(remember):DatePicker.kt#9igjgp");
        boolean changedInstance = ((((57344 & i2) ^ 24576) > 16384 && composer.changed(selectableDates2)) || (i2 & 24576) == 16384) | ((((i2 & 14) ^ 6) > 4 && composer.changed(l3)) || (i2 & 6) == 4) | ((((i2 & 112) ^ 48) > 32 && composer.changed(l4)) || (i2 & 48) == 32) | composer.changedInstance(intRange2) | ((((i2 & 7168) ^ 3072) > 2048 && composer.changed(i4)) || (i2 & 3072) == 2048) | composer.changedInstance(defaultLocale);
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = (Function0) new Function0<DatePickerStateImpl>() { // from class: androidx.compose.material3.DatePickerKt$rememberDatePickerState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final DatePickerStateImpl invoke() {
                    return new DatePickerStateImpl(l3, l4, intRange2, i4, selectableDates2, defaultLocale, null);
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        DatePickerStateImpl datePickerStateImpl = (DatePickerStateImpl) RememberSaveableKt.m3680rememberSaveable(objArr, (Saver) Saver, (String) null, (Function0) rememberedValue, composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return datePickerStateImpl;
    }

    /* renamed from: DatePickerState-sHin3Bw$default, reason: not valid java name */
    public static /* synthetic */ DatePickerState m2138DatePickerStatesHin3Bw$default(Locale locale, Long l, Long l2, IntRange intRange, int i, SelectableDates selectableDates, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            l = null;
        }
        if ((i2 & 4) != 0) {
            l2 = l;
        }
        if ((i2 & 8) != 0) {
            intRange = DatePickerDefaults.INSTANCE.getYearRange();
        }
        if ((i2 & 16) != 0) {
            i = DisplayMode.INSTANCE.m2178getPickerjFl4v0();
        }
        if ((i2 & 32) != 0) {
            selectableDates = DatePickerDefaults.INSTANCE.getAllDates();
        }
        SelectableDates selectableDates2 = selectableDates;
        IntRange intRange2 = intRange;
        return m2137DatePickerStatesHin3Bw(locale, l, l2, intRange2, i, selectableDates2);
    }

    /* renamed from: DatePickerState-sHin3Bw, reason: not valid java name */
    public static final DatePickerState m2137DatePickerStatesHin3Bw(Locale locale, Long l, Long l2, IntRange intRange, int i, SelectableDates selectableDates) {
        return new DatePickerStateImpl(l, l2, intRange, i, selectableDates, locale, null);
    }

    /* renamed from: DateEntryContainer-au3_HiA, reason: not valid java name */
    public static final void m2135DateEntryContainerau3_HiA(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final DatePickerColors datePickerColors, final TextStyle textStyle, final float f, final Function2<? super Composer, ? super Integer, Unit> function24, Composer composer, final int i) {
        int i2;
        Function2<? super Composer, ? super Integer, Unit> function25;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Function2<? super Composer, ? super Integer, Unit> function27;
        DatePickerColors datePickerColors2;
        TextStyle textStyle2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1507356255);
        ComposerKt.sourceInformation(startRestartGroup, "C(DateEntryContainer)P(6,7,3,5!1,4,2:c#ui.unit.Dp)1303@58682L1716:DatePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            function25 = function2;
            i2 |= startRestartGroup.changedInstance(function25) ? 32 : 16;
        } else {
            function25 = function2;
        }
        if ((i & 384) == 0) {
            function26 = function22;
            i2 |= startRestartGroup.changedInstance(function26) ? 256 : 128;
        } else {
            function26 = function22;
        }
        if ((i & 3072) == 0) {
            function27 = function23;
            i2 |= startRestartGroup.changedInstance(function27) ? 2048 : 1024;
        } else {
            function27 = function23;
        }
        if ((i & 24576) == 0) {
            datePickerColors2 = datePickerColors;
            i2 |= startRestartGroup.changed(datePickerColors2) ? 16384 : 8192;
        } else {
            datePickerColors2 = datePickerColors;
        }
        if ((196608 & i) == 0) {
            textStyle2 = textStyle;
            i2 |= startRestartGroup.changed(textStyle2) ? 131072 : 65536;
        } else {
            textStyle2 = textStyle;
        }
        if ((1572864 & i) == 0) {
            i2 |= startRestartGroup.changed(f) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function24) ? 8388608 : 4194304;
        }
        if ((4793491 & i2) != 4793490 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1507356255, i2, -1, "androidx.compose.material3.DateEntryContainer (DatePicker.kt:1302)");
            }
            Modifier semantics$default = SemanticsModifierKt.semantics$default(SizeKt.m932sizeInqDBjuR0$default(modifier, DatePickerModalTokens.INSTANCE.m3096getContainerWidthD9Ej5fM(), 0.0f, 0.0f, 0.0f, 14, null), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DateEntryContainer$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.setContainer(semanticsPropertyReceiver, true);
                }
            }, 1, null);
            startRestartGroup.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(semantics$default);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -916065881, "C1311@58918L1456,1344@60383L9:DatePicker.kt#uh7d8r");
            final Function2<? super Composer, ? super Integer, Unit> function28 = function25;
            final Function2<? super Composer, ? super Integer, Unit> function29 = function26;
            final Function2<? super Composer, ? super Integer, Unit> function210 = function27;
            final DatePickerColors datePickerColors3 = datePickerColors2;
            final TextStyle textStyle3 = textStyle2;
            m2136DatePickerHeaderpc5RIQQ(Modifier.INSTANCE, function2, datePickerColors2.getTitleContentColor(), datePickerColors2.getHeadlineContentColor(), f, ComposableLambdaKt.composableLambda(startRestartGroup, -229007058, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DateEntryContainer$2$1
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

                public final void invoke(Composer composer3, int i3) {
                    Arrangement.HorizontalOrVertical end;
                    ComposerKt.sourceInformation(composer3, "C1318@59182L1182:DatePicker.kt#uh7d8r");
                    if ((i3 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-229007058, i3, -1, "androidx.compose.material3.DateEntryContainer.<anonymous>.<anonymous> (DatePicker.kt:1318)");
                        }
                        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        final Function2<Composer, Integer, Unit> function211 = function29;
                        Function2<Composer, Integer, Unit> function212 = function210;
                        Function2<Composer, Integer, Unit> function213 = function28;
                        DatePickerColors datePickerColors4 = datePickerColors3;
                        TextStyle textStyle4 = textStyle3;
                        composer3.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                        MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
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
                        Updater.m3600setimpl(m3593constructorimpl2, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, 1449826990, "C1324@59507L580:DatePicker.kt#uh7d8r");
                        if (function211 != null && function212 != null) {
                            end = Arrangement.INSTANCE.getSpaceBetween();
                        } else if (function211 != null) {
                            end = Arrangement.INSTANCE.getStart();
                        } else {
                            end = Arrangement.INSTANCE.getEnd();
                        }
                        Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        composer3.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(end, centerVertically, composer3, 48);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default2);
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor3);
                        } else {
                            composer3.useNode();
                        }
                        Composer m3593constructorimpl3 = Updater.m3593constructorimpl(composer3);
                        Updater.m3600setimpl(m3593constructorimpl3, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m3593constructorimpl3.getInserting() || !Intrinsics.areEqual(m3593constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                            m3593constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                            m3593constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                        }
                        modifierMaterializerOf3.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                        final RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, -1011363262, "C:DatePicker.kt#uh7d8r");
                        composer3.startReplaceableGroup(-1011363262);
                        ComposerKt.sourceInformation(composer3, "1330@59790L210");
                        if (function211 != null) {
                            TextKt.ProvideTextStyle(textStyle4, ComposableLambdaKt.composableLambda(composer3, -962031352, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DateEntryContainer$2$1$1$1$1
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

                                public final void invoke(Composer composer4, int i4) {
                                    ComposerKt.sourceInformation(composer4, "C1331@59864L110:DatePicker.kt#uh7d8r");
                                    if ((i4 & 3) != 2 || !composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-962031352, i4, -1, "androidx.compose.material3.DateEntryContainer.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:1331)");
                                        }
                                        Modifier weight$default = RowScope.weight$default(RowScope.this, Modifier.INSTANCE, 1.0f, false, 2, null);
                                        Function2<Composer, Integer, Unit> function214 = function211;
                                        composer4.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer4, 0);
                                        composer4.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                        CompositionLocalMap currentCompositionLocalMap4 = composer4.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(weight$default);
                                        if (!(composer4.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer4.startReusableNode();
                                        if (composer4.getInserting()) {
                                            composer4.createNode(constructor4);
                                        } else {
                                            composer4.useNode();
                                        }
                                        Composer m3593constructorimpl4 = Updater.m3593constructorimpl(composer4);
                                        Updater.m3600setimpl(m3593constructorimpl4, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3600setimpl(m3593constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (m3593constructorimpl4.getInserting() || !Intrinsics.areEqual(m3593constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                            m3593constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                            m3593constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                                        }
                                        modifierMaterializerOf4.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer4)), composer4, 0);
                                        composer4.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer4, 2128822724, "C1332@59934L10:DatePicker.kt#uh7d8r");
                                        function214.invoke(composer4, 0);
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
                            }), composer3, 48);
                        }
                        composer3.endReplaceableGroup();
                        composer3.startReplaceableGroup(1449827808);
                        ComposerKt.sourceInformation(composer3, "1336@60061L8");
                        if (function212 != null) {
                            function212.invoke(composer3, 0);
                        }
                        composer3.endReplaceableGroup();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        composer3.startReplaceableGroup(1680523079);
                        ComposerKt.sourceInformation(composer3, "1340@60286L46");
                        if (function213 != null || function211 != null || function212 != null) {
                            DividerKt.m2181HorizontalDivider9IZ8Weo(null, 0.0f, datePickerColors4.getDividerColor(), composer3, 0, 3);
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
            }), startRestartGroup, (i2 & 112) | 196614 | (57344 & (i2 >> 6)));
            composer2 = startRestartGroup;
            function24.invoke(composer2, Integer.valueOf((i2 >> 21) & 14));
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DateEntryContainer$3
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

                public final void invoke(Composer composer3, int i3) {
                    DatePickerKt.m2135DateEntryContainerau3_HiA(Modifier.this, function2, function22, function23, datePickerColors, textStyle, f, function24, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* renamed from: DisplayModeToggleButton-tER2X8s, reason: not valid java name */
    public static final void m2139DisplayModeToggleButtontER2X8s(Modifier modifier, final int i, final Function1<? super DisplayMode, Unit> function1, Composer composer, final int i2) {
        int i3;
        boolean z;
        final Modifier modifier2;
        Composer startRestartGroup = composer.startRestartGroup(1393846115);
        ComposerKt.sourceInformation(startRestartGroup, "C(DisplayModeToggleButton)P(1,0:c#material3.DisplayMode):DatePicker.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= startRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i3 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1393846115, i3, -1, "androidx.compose.material3.DisplayModeToggleButton (DatePicker.kt:1354)");
            }
            if (!DisplayMode.m2173equalsimpl0(i, DisplayMode.INSTANCE.m2178getPickerjFl4v0())) {
                startRestartGroup.startReplaceableGroup(-1814955404);
                ComposerKt.sourceInformation(startRestartGroup, "1363@60955L43,1363@60934L271");
                startRestartGroup.startReplaceableGroup(-1814955373);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
                z = (i3 & 896) == 256;
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (z || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.DatePickerKt$DisplayModeToggleButton$2$1
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
                            function1.invoke(DisplayMode.m2170boximpl(DisplayMode.INSTANCE.m2178getPickerjFl4v0()));
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceableGroup();
                modifier2 = modifier;
                IconButtonKt.IconButton((Function0) rememberedValue, modifier2, false, null, null, ComposableSingletons$DatePickerKt.INSTANCE.m2074getLambda2$material3_release(), startRestartGroup, ((i3 << 3) & 112) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
                startRestartGroup.endReplaceableGroup();
            } else {
                startRestartGroup.startReplaceableGroup(-1814955688);
                ComposerKt.sourceInformation(startRestartGroup, "1356@60671L42,1356@60650L262");
                startRestartGroup.startReplaceableGroup(-1814955657);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
                z = (i3 & 896) == 256;
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (z || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.DatePickerKt$DisplayModeToggleButton$1$1
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
                            function1.invoke(DisplayMode.m2170boximpl(DisplayMode.INSTANCE.m2177getInputjFl4v0()));
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceableGroup();
                modifier2 = modifier;
                IconButtonKt.IconButton((Function0) rememberedValue2, modifier2, false, null, null, ComposableSingletons$DatePickerKt.INSTANCE.m2073getLambda1$material3_release(), startRestartGroup, ((i3 << 3) & 112) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
                startRestartGroup.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DisplayModeToggleButton$3
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
                    DatePickerKt.m2139DisplayModeToggleButtontER2X8s(Modifier.this, i, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: SwitchableDateEntryContent-d7iavvg, reason: not valid java name */
    public static final void m2140SwitchableDateEntryContentd7iavvg(final Long l, final long j, final int i, final Function1<? super Long, Unit> function1, final Function1<? super Long, Unit> function12, final CalendarModel calendarModel, final IntRange intRange, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, Composer composer, final int i2) {
        int i3;
        Function1<? super Long, Unit> function13;
        Function1<? super Long, Unit> function14;
        CalendarModel calendarModel2;
        IntRange intRange2;
        SelectableDates selectableDates2;
        DatePickerColors datePickerColors2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-895379221);
        ComposerKt.sourceInformation(startRestartGroup, "C(SwitchableDateEntryContent)P(8,4,3:c#material3.DisplayMode,5,6!1,9,2,7)*1392@62001L7,1399@62233L1975,1393@62037L3206:DatePicker.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i3 = (startRestartGroup.changed(l) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= startRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= startRestartGroup.changed(i) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            function13 = function1;
            i3 |= startRestartGroup.changedInstance(function13) ? 2048 : 1024;
        } else {
            function13 = function1;
        }
        if ((i2 & 24576) == 0) {
            function14 = function12;
            i3 |= startRestartGroup.changedInstance(function14) ? 16384 : 8192;
        } else {
            function14 = function12;
        }
        if ((196608 & i2) == 0) {
            calendarModel2 = calendarModel;
            i3 |= startRestartGroup.changedInstance(calendarModel2) ? 131072 : 65536;
        } else {
            calendarModel2 = calendarModel;
        }
        if ((1572864 & i2) == 0) {
            intRange2 = intRange;
            i3 |= startRestartGroup.changedInstance(intRange2) ? 1048576 : 524288;
        } else {
            intRange2 = intRange;
        }
        if ((12582912 & i2) == 0) {
            i3 |= (16777216 & i2) == 0 ? startRestartGroup.changed(datePickerFormatter) : startRestartGroup.changedInstance(datePickerFormatter) ? 8388608 : 4194304;
        }
        if ((100663296 & i2) == 0) {
            selectableDates2 = selectableDates;
            i3 |= startRestartGroup.changed(selectableDates2) ? 67108864 : 33554432;
        } else {
            selectableDates2 = selectableDates;
        }
        if ((805306368 & i2) == 0) {
            datePickerColors2 = datePickerColors;
            i3 |= startRestartGroup.changed(datePickerColors2) ? 536870912 : 268435456;
        } else {
            datePickerColors2 = datePickerColors;
        }
        int i4 = i3;
        if ((306783379 & i4) != 306783378 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-895379221, i4, -1, "androidx.compose.material3.SwitchableDateEntryContent (DatePicker.kt:1389)");
            }
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final int i5 = -((Density) consume).mo624roundToPx0680j_4(Dp.m6389constructorimpl(48));
            DisplayMode m2170boximpl = DisplayMode.m2170boximpl(i);
            Modifier semantics$default = SemanticsModifierKt.semantics$default(Modifier.INSTANCE, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.setContainer(semanticsPropertyReceiver, true);
                }
            }, 1, null);
            startRestartGroup.startReplaceableGroup(1777156755);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
            boolean changed = startRestartGroup.changed(i5);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = (Function1) new Function1<AnimatedContentTransitionScope<DisplayMode>, ContentTransform>() { // from class: androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final ContentTransform invoke(AnimatedContentTransitionScope<DisplayMode> animatedContentTransitionScope) {
                        ContentTransform contentTransform;
                        if (DisplayMode.m2173equalsimpl0(animatedContentTransitionScope.getTargetState().getValue(), DisplayMode.INSTANCE.m2177getInputjFl4v0())) {
                            EnterTransition plus = EnterExitTransitionKt.slideInVertically$default(null, new Function1<Integer, Integer>() { // from class: androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$2$1.1
                                public final Integer invoke(int i6) {
                                    return Integer.valueOf(i6);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                                    return invoke(num.intValue());
                                }
                            }, 1, null).plus(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(100, 100, null, 4, null), 0.0f, 2, null));
                            ExitTransition fadeOut$default = EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(100, 0, null, 6, null), 0.0f, 2, null);
                            final int i6 = i5;
                            contentTransform = AnimatedContentKt.togetherWith(plus, fadeOut$default.plus(EnterExitTransitionKt.slideOutVertically$default(null, new Function1<Integer, Integer>() { // from class: androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$2$1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public final Integer invoke(int i7) {
                                    return Integer.valueOf(i6);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                                    return invoke(num.intValue());
                                }
                            }, 1, null)));
                        } else {
                            TweenSpec tween$default = AnimationSpecKt.tween$default(0, 50, null, 5, null);
                            final int i7 = i5;
                            contentTransform = AnimatedContentKt.togetherWith(EnterExitTransitionKt.slideInVertically(tween$default, new Function1<Integer, Integer>() { // from class: androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$2$1.3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                                    return invoke(num.intValue());
                                }

                                public final Integer invoke(int i8) {
                                    return Integer.valueOf(i7);
                                }
                            }).plus(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(100, 100, null, 4, null), 0.0f, 2, null)), EnterExitTransitionKt.slideOutVertically$default(null, new Function1<Integer, Integer>() { // from class: androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$2$1.4
                                public final Integer invoke(int i8) {
                                    return Integer.valueOf(i8);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                                    return invoke(num.intValue());
                                }
                            }, 1, null).plus(EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(100, 0, null, 6, null), 0.0f, 2, null)));
                        }
                        return animatedContentTransitionScope.using(contentTransform, AnimatedContentKt.SizeTransform(true, new Function2<IntSize, IntSize, FiniteAnimationSpec<IntSize>>() { // from class: androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$2$1.5
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ FiniteAnimationSpec<IntSize> invoke(IntSize intSize, IntSize intSize2) {
                                return m2144invokeTemP2vQ(intSize.getPackedValue(), intSize2.getPackedValue());
                            }

                            /* renamed from: invoke-TemP2vQ, reason: not valid java name */
                            public final FiniteAnimationSpec<IntSize> m2144invokeTemP2vQ(long j2, long j3) {
                                return AnimationSpecKt.tween$default(500, 0, MotionTokens.INSTANCE.getEasingEmphasizedDecelerateCubicBezier(), 2, null);
                            }
                        }));
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            final Function1<? super Long, Unit> function15 = function13;
            final Function1<? super Long, Unit> function16 = function14;
            final CalendarModel calendarModel3 = calendarModel2;
            final IntRange intRange3 = intRange2;
            final SelectableDates selectableDates3 = selectableDates2;
            final DatePickerColors datePickerColors3 = datePickerColors2;
            composer2 = startRestartGroup;
            AnimatedContentKt.AnimatedContent(m2170boximpl, semantics$default, (Function1) rememberedValue, null, "DatePickerDisplayModeAnimation", null, ComposableLambdaKt.composableLambda(startRestartGroup, -459778869, true, new Function4<AnimatedContentScope, DisplayMode, Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(AnimatedContentScope animatedContentScope, DisplayMode displayMode, Composer composer3, Integer num) {
                    m2145invokefYndouo(animatedContentScope, displayMode.getValue(), composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-fYndouo, reason: not valid java name */
                public final void m2145invokefYndouo(AnimatedContentScope animatedContentScope, int i6, Composer composer3, int i7) {
                    ComposerKt.sourceInformation(composer3, "CP(0:c#material3.DisplayMode):DatePicker.kt#uh7d8r");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-459778869, i7, -1, "androidx.compose.material3.SwitchableDateEntryContent.<anonymous> (DatePicker.kt:1439)");
                    }
                    if (DisplayMode.m2173equalsimpl0(i6, DisplayMode.INSTANCE.m2178getPickerjFl4v0())) {
                        composer3.startReplaceableGroup(-1168710170);
                        ComposerKt.sourceInformation(composer3, "1440@64331L494");
                        DatePickerKt.DatePickerContent(l, j, function15, function16, calendarModel3, intRange3, datePickerFormatter, selectableDates3, datePickerColors3, composer3, 0);
                        composer3.endReplaceableGroup();
                    } else if (DisplayMode.m2173equalsimpl0(i6, DisplayMode.INSTANCE.m2177getInputjFl4v0())) {
                        composer3.startReplaceableGroup(-1168709641);
                        ComposerKt.sourceInformation(composer3, "1452@64860L367");
                        DateInputKt.DateInputContent(l, function15, calendarModel3, intRange3, datePickerFormatter, selectableDates3, datePickerColors3, composer3, 0);
                        composer3.endReplaceableGroup();
                    } else {
                        composer3.startReplaceableGroup(-1168709264);
                        composer3.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composer2, ((i4 >> 6) & 14) | 1597440, 40);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$4
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
                    DatePickerKt.m2140SwitchableDateEntryContentd7iavvg(l, j, i, function1, function12, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x029c, code lost:
    
        if (r1 == androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0264, code lost:
    
        if (r3 == androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L105;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DatePickerContent(final Long l, final long j, final Function1<? super Long, Unit> function1, final Function1<? super Long, Unit> function12, final CalendarModel calendarModel, final IntRange intRange, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, Composer composer, final int i) {
        int i2;
        String str;
        Function0 function0;
        Composer startRestartGroup = composer.startRestartGroup(-434467002);
        ComposerKt.sourceInformation(startRestartGroup, "C(DatePickerContent)P(7,3,4,5!1,8,2,6)1480@65783L87,1481@65896L24,1482@65950L42,1483@66017L15,1484@66037L4988:DatePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(l) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function12) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(calendarModel) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(intRange) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= (2097152 & i) == 0 ? startRestartGroup.changed(datePickerFormatter) : startRestartGroup.changedInstance(datePickerFormatter) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= startRestartGroup.changed(selectableDates) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i2 |= startRestartGroup.changed(datePickerColors) ? 67108864 : 33554432;
        }
        if ((38347923 & i2) != 38347922 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-434467002, i2, -1, "androidx.compose.material3.DatePickerContent (DatePicker.kt:1477)");
            }
            final CalendarMonth month = calendarModel.getMonth(j);
            final LazyListState rememberLazyListState = LazyListStateKt.rememberLazyListState(month.indexIn(intRange), 0, startRestartGroup, 0, 2);
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
            final MutableState mutableState = (MutableState) RememberSaveableKt.m3680rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) new Function0<MutableState<Boolean>>() { // from class: androidx.compose.material3.DatePickerKt$DatePickerContent$yearPickerVisible$2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final MutableState<Boolean> invoke() {
                    return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                }
            }, startRestartGroup, 3072, 6);
            Locale defaultLocale = ActualAndroid_androidKt.defaultLocale(startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -269657363, "C1494@66536L511,1506@67081L520,1518@67643L42,1485@66054L1670,1522@67734L3285:DatePicker.kt#uh7d8r");
            Modifier.Companion companion2 = Modifier.INSTANCE;
            float f = DatePickerHorizontalPadding;
            int i3 = i2;
            Modifier m881paddingVpY3zN4$default = PaddingKt.m881paddingVpY3zN4$default(companion2, f, 0.0f, 2, null);
            boolean canScrollForward = rememberLazyListState.getCanScrollForward();
            boolean canScrollBackward = rememberLazyListState.getCanScrollBackward();
            boolean DatePickerContent$lambda$8 = DatePickerContent$lambda$8(mutableState);
            String formatMonthYear = datePickerFormatter.formatMonthYear(Long.valueOf(j), defaultLocale);
            if (formatMonthYear == null) {
                formatMonthYear = "-";
            }
            startRestartGroup.startReplaceableGroup(-269656881);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(coroutineScope) | startRestartGroup.changed(rememberLazyListState);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance) {
                str = formatMonthYear;
            } else {
                str = formatMonthYear;
            }
            rememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePickerContent$1$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* compiled from: DatePicker.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.material3.DatePickerKt$DatePickerContent$1$1$1$1", f = "DatePicker.kt", i = {}, l = {1498}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: androidx.compose.material3.DatePickerKt$DatePickerContent$1$1$1$1, reason: invalid class name */
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ LazyListState $monthsListState;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(LazyListState lazyListState, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$monthsListState = lazyListState;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$monthsListState, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        try {
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                LazyListState lazyListState = this.$monthsListState;
                                this.label = 1;
                                if (LazyListState.animateScrollToItem$default(lazyListState, lazyListState.getFirstVisibleItemIndex() + 1, 0, this, 2, null) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                            }
                        } catch (IllegalArgumentException unused) {
                        }
                        return Unit.INSTANCE;
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScope.this, null, null, new AnonymousClass1(rememberLazyListState, null), 3, null);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue2);
            Function0 function02 = (Function0) rememberedValue2;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-269656336);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
            boolean changedInstance2 = startRestartGroup.changedInstance(coroutineScope) | startRestartGroup.changed(rememberLazyListState);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance2) {
                function0 = function02;
            } else {
                function0 = function02;
            }
            rememberedValue3 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePickerContent$1$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* compiled from: DatePicker.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.material3.DatePickerKt$DatePickerContent$1$2$1$1", f = "DatePicker.kt", i = {}, l = {1510}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: androidx.compose.material3.DatePickerKt$DatePickerContent$1$2$1$1, reason: invalid class name */
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ LazyListState $monthsListState;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(LazyListState lazyListState, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$monthsListState = lazyListState;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$monthsListState, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        try {
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                LazyListState lazyListState = this.$monthsListState;
                                this.label = 1;
                                if (LazyListState.animateScrollToItem$default(lazyListState, lazyListState.getFirstVisibleItemIndex() - 1, 0, this, 2, null) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                            }
                        } catch (IllegalArgumentException unused) {
                        }
                        return Unit.INSTANCE;
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScope.this, null, null, new AnonymousClass1(rememberLazyListState, null), 3, null);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue3);
            Function0 function03 = (Function0) rememberedValue3;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-269655774);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
            boolean changed = startRestartGroup.changed(mutableState);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePickerContent$1$3$1
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
                        boolean DatePickerContent$lambda$82;
                        MutableState<Boolean> mutableState2 = mutableState;
                        DatePickerContent$lambda$82 = DatePickerKt.DatePickerContent$lambda$8(mutableState2);
                        DatePickerKt.DatePickerContent$lambda$9(mutableState2, !DatePickerContent$lambda$82);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceableGroup();
            int i4 = i3 & 234881024;
            MonthsNavigation(m881paddingVpY3zN4$default, canScrollForward, canScrollBackward, DatePickerContent$lambda$8, str, function0, function03, (Function0) rememberedValue4, datePickerColors, startRestartGroup, i4 | 6);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            Modifier.Companion companion3 = Modifier.INSTANCE;
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion3);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1767588144, "C1523@67752L683,1537@68475L2534:DatePicker.kt#uh7d8r");
            Modifier m881paddingVpY3zN4$default2 = PaddingKt.m881paddingVpY3zN4$default(Modifier.INSTANCE, f, 0.0f, 2, null);
            startRestartGroup.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(m881paddingVpY3zN4$default2);
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
            Updater.m3600setimpl(m3593constructorimpl3, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3593constructorimpl3.getInserting() || !Intrinsics.areEqual(m3593constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m3593constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m3593constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            modifierMaterializerOf3.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 276693656, "C79@3979L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1247393713, "C1524@67848L31,1525@67896L525:DatePicker.kt#uh7d8r");
            WeekDays(datePickerColors, calendarModel, startRestartGroup, ((i3 >> 24) & 14) | ((i3 >> 9) & 112));
            HorizontalMonthsList(rememberLazyListState, l, function1, function12, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, startRestartGroup, ((i3 << 3) & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | (i3 & 29360128) | i4);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            AnimatedVisibilityKt.AnimatedVisibility(DatePickerContent$lambda$8(mutableState), ClipKt.clipToBounds(Modifier.INSTANCE), EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.6f, 1, null)), EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null)), (String) null, ComposableLambdaKt.composableLambda(startRestartGroup, 1193716082, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePickerContent$1$4$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer2, Integer num) {
                    invoke(animatedVisibilityScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer2, int i5) {
                    ComposerKt.sourceInformation(composer2, "C1547@69058L48,1548@69160L30,1548@69123L1872:DatePicker.kt#uh7d8r");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1193716082, i5, -1, "androidx.compose.material3.DatePickerContent.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:1547)");
                    }
                    Strings.Companion companion4 = Strings.INSTANCE;
                    final String m2623getStringNWtq28 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_date_picker_year_picker_pane_title), composer2, 0);
                    Modifier.Companion companion5 = Modifier.INSTANCE;
                    composer2.startReplaceableGroup(1247395025);
                    ComposerKt.sourceInformation(composer2, "CC(remember):DatePicker.kt#9igjgp");
                    boolean changed2 = composer2.changed(m2623getStringNWtq28);
                    Object rememberedValue5 = composer2.rememberedValue();
                    if (changed2 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue5 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePickerContent$1$4$2$1$1
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
                        composer2.updateRememberedValue(rememberedValue5);
                    }
                    composer2.endReplaceableGroup();
                    Modifier semantics$default = SemanticsModifierKt.semantics$default(companion5, false, (Function1) rememberedValue5, 1, null);
                    long j2 = j;
                    final MutableState<Boolean> mutableState2 = mutableState;
                    final CoroutineScope coroutineScope2 = coroutineScope;
                    final LazyListState lazyListState = rememberLazyListState;
                    final IntRange intRange2 = intRange;
                    final CalendarMonth calendarMonth = month;
                    SelectableDates selectableDates2 = selectableDates;
                    CalendarModel calendarModel2 = calendarModel;
                    DatePickerColors datePickerColors2 = datePickerColors;
                    composer2.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation(composer2, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                    MeasurePolicy columnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(semantics$default);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor4);
                    } else {
                        composer2.useNode();
                    }
                    Composer m3593constructorimpl4 = Updater.m3593constructorimpl(composer2);
                    Updater.m3600setimpl(m3593constructorimpl4, columnMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3600setimpl(m3593constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m3593constructorimpl4.getInserting() || !Intrinsics.areEqual(m3593constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                        m3593constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                        m3593constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                    }
                    modifierMaterializerOf4.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer2, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -1036318296, "C1560@69919L767,1549@69214L1696,1577@70931L46:DatePicker.kt#uh7d8r");
                    Modifier m881paddingVpY3zN4$default3 = PaddingKt.m881paddingVpY3zN4$default(SizeKt.m917requiredHeight3ABfNKs(Modifier.INSTANCE, Dp.m6389constructorimpl(Dp.m6389constructorimpl(DatePickerKt.getRecommendedSizeForAccessibility() * 7) - DividerDefaults.INSTANCE.m2179getThicknessD9Ej5fM())), DatePickerKt.getDatePickerHorizontalPadding(), 0.0f, 2, null);
                    composer2.startReplaceableGroup(-1036317591);
                    ComposerKt.sourceInformation(composer2, "CC(remember):DatePicker.kt#9igjgp");
                    boolean changed3 = composer2.changed(mutableState2) | composer2.changedInstance(coroutineScope2) | composer2.changed(lazyListState) | composer2.changedInstance(intRange2) | composer2.changed(calendarMonth);
                    Object rememberedValue6 = composer2.rememberedValue();
                    if (changed3 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue6 = (Function1) new Function1<Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePickerContent$1$4$2$2$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                                invoke(num.intValue());
                                return Unit.INSTANCE;
                            }

                            /* compiled from: DatePicker.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                            @DebugMetadata(c = "androidx.compose.material3.DatePickerKt$DatePickerContent$1$4$2$2$1$1$1", f = "DatePicker.kt", i = {}, l = {1568}, m = "invokeSuspend", n = {}, s = {})
                            /* renamed from: androidx.compose.material3.DatePickerKt$DatePickerContent$1$4$2$2$1$1$1, reason: invalid class name */
                            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ CalendarMonth $displayedMonth;
                                final /* synthetic */ LazyListState $monthsListState;
                                final /* synthetic */ int $year;
                                final /* synthetic */ IntRange $yearRange;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass1(LazyListState lazyListState, int i, IntRange intRange, CalendarMonth calendarMonth, Continuation<? super AnonymousClass1> continuation) {
                                    super(2, continuation);
                                    this.$monthsListState = lazyListState;
                                    this.$year = i;
                                    this.$yearRange = intRange;
                                    this.$displayedMonth = calendarMonth;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new AnonymousClass1(this.$monthsListState, this.$year, this.$yearRange, this.$displayedMonth, continuation);
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
                                        if (LazyListState.scrollToItem$default(this.$monthsListState, (((this.$year - this.$yearRange.getFirst()) * 12) + this.$displayedMonth.getMonth()) - 1, 0, this, 2, null) == coroutine_suspended) {
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

                            public final void invoke(int i6) {
                                boolean DatePickerContent$lambda$82;
                                MutableState<Boolean> mutableState3 = mutableState2;
                                DatePickerContent$lambda$82 = DatePickerKt.DatePickerContent$lambda$8(mutableState3);
                                DatePickerKt.DatePickerContent$lambda$9(mutableState3, !DatePickerContent$lambda$82);
                                BuildersKt__Builders_commonKt.launch$default(CoroutineScope.this, null, null, new AnonymousClass1(lazyListState, i6, intRange2, calendarMonth, null), 3, null);
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue6);
                    }
                    composer2.endReplaceableGroup();
                    DatePickerKt.YearPicker(m881paddingVpY3zN4$default3, j2, (Function1) rememberedValue6, selectableDates2, calendarModel2, intRange2, datePickerColors2, composer2, 6);
                    DividerKt.m2181HorizontalDivider9IZ8Weo(null, 0.0f, datePickerColors2.getDividerColor(), composer2, 0, 3);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), startRestartGroup, 200112, 16);
            startRestartGroup = startRestartGroup;
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
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePickerContent$2
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
                    DatePickerKt.DatePickerContent(l, j, function1, function12, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean DatePickerContent$lambda$8(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DatePickerContent$lambda$9(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* renamed from: DatePickerHeader-pc5RIQQ, reason: not valid java name */
    public static final void m2136DatePickerHeaderpc5RIQQ(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final long j, final long j2, final float f, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i) {
        int i2;
        Modifier.Companion companion;
        Composer startRestartGroup = composer.startRestartGroup(-996037719);
        ComposerKt.sourceInformation(startRestartGroup, "C(DatePickerHeader)P(3,4,5:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.unit.Dp)1600@71484L740:DatePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(j) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(j2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changed(f) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 131072 : 65536;
        }
        if ((74899 & i2) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-996037719, i2, -1, "androidx.compose.material3.DatePickerHeader (DatePicker.kt:1592)");
            }
            if (function2 != null) {
                companion = SizeKt.m913defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, 0.0f, f, 1, null);
            } else {
                companion = Modifier.INSTANCE;
            }
            Modifier then = SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null).then(companion);
            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            startRestartGroup.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(spaceBetween, Alignment.INSTANCE.getStart(), startRestartGroup, 6);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1127544336, "C1619@72104L114:DatePicker.kt#uh7d8r");
            startRestartGroup.startReplaceableGroup(1127544336);
            ComposerKt.sourceInformation(startRestartGroup, "1608@71722L10,1611@71841L244");
            if (function2 != null) {
                ProvideContentColorTextStyleKt.m2420ProvideContentColorTextStyle3JVO9M(j, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), DatePickerModalTokens.INSTANCE.getHeaderSupportingTextFont()), ComposableLambdaKt.composableLambda(startRestartGroup, 1936268514, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePickerHeader$1$1
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
                        ComposerKt.sourceInformation(composer2, "C1614@71978L93:DatePicker.kt#uh7d8r");
                        if ((i3 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1936268514, i3, -1, "androidx.compose.material3.DatePickerHeader.<anonymous>.<anonymous> (DatePicker.kt:1614)");
                            }
                            Alignment bottomStart = Alignment.INSTANCE.getBottomStart();
                            Function2<Composer, Integer, Unit> function23 = function2;
                            composer2.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            Modifier.Companion companion2 = Modifier.INSTANCE;
                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(bottomStart, false, composer2, 6);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion2);
                            if (!(composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor2);
                            } else {
                                composer2.useNode();
                            }
                            Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer2);
                            Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                            }
                            modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer2, 1465500517, "C1615@72046L7:DatePicker.kt#uh7d8r");
                            function23.invoke(composer2, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), startRestartGroup, ((i2 >> 6) & 14) | 384);
            }
            startRestartGroup.endReplaceableGroup();
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(j2)), function22, startRestartGroup, ((i2 >> 12) & 112) | ProvidedValue.$stable);
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
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePickerHeader$2
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
                    DatePickerKt.m2136DatePickerHeaderpc5RIQQ(Modifier.this, function2, j, j2, f, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void HorizontalMonthsList(LazyListState lazyListState, final Long l, final Function1<? super Long, Unit> function1, final Function1<? super Long, Unit> function12, final CalendarModel calendarModel, final IntRange intRange, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, Composer composer, final int i) {
        int i2;
        Long l2;
        final Function1<? super Long, Unit> function13;
        SelectableDates selectableDates2;
        DatePickerColors datePickerColors2;
        DatePickerKt$HorizontalMonthsList$2$1 datePickerKt$HorizontalMonthsList$2$1;
        final LazyListState lazyListState2 = lazyListState;
        Composer startRestartGroup = composer.startRestartGroup(-1994757941);
        ComposerKt.sourceInformation(startRestartGroup, "C(HorizontalMonthsList)P(3,7,4,5!1,8,2,6)1642@72780L138,1649@72963L10,1648@72923L1690,1687@74649L228,1687@74619L258:DatePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(lazyListState2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            l2 = l;
            i2 |= startRestartGroup.changed(l2) ? 32 : 16;
        } else {
            l2 = l;
        }
        if ((i & 384) == 0) {
            function13 = function1;
            i2 |= startRestartGroup.changedInstance(function13) ? 256 : 128;
        } else {
            function13 = function1;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function12) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(calendarModel) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(intRange) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= (2097152 & i) == 0 ? startRestartGroup.changed(datePickerFormatter) : startRestartGroup.changedInstance(datePickerFormatter) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            selectableDates2 = selectableDates;
            i2 |= startRestartGroup.changed(selectableDates2) ? 8388608 : 4194304;
        } else {
            selectableDates2 = selectableDates;
        }
        if ((100663296 & i) == 0) {
            datePickerColors2 = datePickerColors;
            i2 |= startRestartGroup.changed(datePickerColors2) ? 67108864 : 33554432;
        } else {
            datePickerColors2 = datePickerColors;
        }
        if ((38347923 & i2) != 38347922 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1994757941, i2, -1, "androidx.compose.material3.HorizontalMonthsList (DatePicker.kt:1640)");
            }
            final CalendarDate today = calendarModel.getToday();
            startRestartGroup.startReplaceableGroup(1346192500);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
            boolean changed = startRestartGroup.changed(intRange);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = calendarModel.getMonth(intRange.getFirst(), 1);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final CalendarMonth calendarMonth = (CalendarMonth) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            final DatePickerColors datePickerColors3 = datePickerColors2;
            final SelectableDates selectableDates3 = selectableDates2;
            final Long l3 = l2;
            int i3 = i2;
            TextKt.ProvideTextStyle(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), DatePickerModalTokens.INSTANCE.getDateLabelTextFont()), ComposableLambdaKt.composableLambda(startRestartGroup, 1504086906, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$HorizontalMonthsList$1
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
                    ComposerKt.sourceInformation(composer2, "C1661@73673L40,1662@73724L883,1651@73041L1566:DatePicker.kt#uh7d8r");
                    if ((i4 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1504086906, i4, -1, "androidx.compose.material3.HorizontalMonthsList.<anonymous> (DatePicker.kt:1651)");
                        }
                        Modifier semantics$default = SemanticsModifierKt.semantics$default(Modifier.INSTANCE, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DatePickerKt$HorizontalMonthsList$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.setHorizontalScrollAxisRange(semanticsPropertyReceiver, new ScrollAxisRange(new Function0<Float>() { // from class: androidx.compose.material3.DatePickerKt.HorizontalMonthsList.1.1.1
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Float invoke() {
                                        return Float.valueOf(0.0f);
                                    }
                                }, new Function0<Float>() { // from class: androidx.compose.material3.DatePickerKt.HorizontalMonthsList.1.1.2
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Float invoke() {
                                        return Float.valueOf(0.0f);
                                    }
                                }, false, 4, null));
                            }
                        }, 1, null);
                        LazyListState lazyListState3 = LazyListState.this;
                        FlingBehavior rememberSnapFlingBehavior$material3_release = DatePickerDefaults.INSTANCE.rememberSnapFlingBehavior$material3_release(LazyListState.this, null, composer2, 384, 2);
                        composer2.startReplaceableGroup(1286688325);
                        ComposerKt.sourceInformation(composer2, "CC(remember):DatePicker.kt#9igjgp");
                        boolean changedInstance = composer2.changedInstance(intRange) | composer2.changedInstance(calendarModel) | composer2.changed(calendarMonth) | composer2.changed(function13) | composer2.changed(today) | composer2.changed(l3) | composer2.changedInstance(datePickerFormatter) | composer2.changed(selectableDates3) | composer2.changed(datePickerColors3);
                        final IntRange intRange2 = intRange;
                        final CalendarModel calendarModel2 = calendarModel;
                        final CalendarMonth calendarMonth2 = calendarMonth;
                        final Function1<Long, Unit> function14 = function13;
                        final CalendarDate calendarDate = today;
                        final Long l4 = l3;
                        final DatePickerFormatter datePickerFormatter2 = datePickerFormatter;
                        final SelectableDates selectableDates4 = selectableDates3;
                        final DatePickerColors datePickerColors4 = datePickerColors3;
                        Object rememberedValue2 = composer2.rememberedValue();
                        if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = (Function1) new Function1<LazyListScope, Unit>() { // from class: androidx.compose.material3.DatePickerKt$HorizontalMonthsList$1$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                    invoke2(lazyListScope);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(LazyListScope lazyListScope) {
                                    int numberOfMonthsInRange = DatePickerKt.numberOfMonthsInRange(IntRange.this);
                                    final CalendarModel calendarModel3 = calendarModel2;
                                    final CalendarMonth calendarMonth3 = calendarMonth2;
                                    final Function1<Long, Unit> function15 = function14;
                                    final CalendarDate calendarDate2 = calendarDate;
                                    final Long l5 = l4;
                                    final DatePickerFormatter datePickerFormatter3 = datePickerFormatter2;
                                    final SelectableDates selectableDates5 = selectableDates4;
                                    final DatePickerColors datePickerColors5 = datePickerColors4;
                                    LazyListScope.items$default(lazyListScope, numberOfMonthsInRange, null, null, ComposableLambdaKt.composableLambdaInstance(1137566309, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$HorizontalMonthsList$1$2$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(4);
                                        }

                                        @Override // kotlin.jvm.functions.Function4
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer3, Integer num2) {
                                            invoke(lazyItemScope, num.intValue(), composer3, num2.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope lazyItemScope, int i5, Composer composer3, int i6) {
                                            int i7;
                                            ComposerKt.sourceInformation(composer3, "C1668@73949L634:DatePicker.kt#uh7d8r");
                                            if ((i6 & 6) == 0) {
                                                i7 = i6 | (composer3.changed(lazyItemScope) ? 4 : 2);
                                            } else {
                                                i7 = i6;
                                            }
                                            if ((i6 & 48) == 0) {
                                                i7 |= composer3.changed(i5) ? 32 : 16;
                                            }
                                            if ((i7 & 147) != 146 || !composer3.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1137566309, i7, -1, "androidx.compose.material3.HorizontalMonthsList.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:1664)");
                                                }
                                                CalendarMonth plusMonths = CalendarModel.this.plusMonths(calendarMonth3, i5);
                                                Modifier fillParentMaxWidth$default = LazyItemScope.fillParentMaxWidth$default(lazyItemScope, Modifier.INSTANCE, 0.0f, 1, null);
                                                Function1<Long, Unit> function16 = function15;
                                                CalendarDate calendarDate3 = calendarDate2;
                                                Long l6 = l5;
                                                DatePickerFormatter datePickerFormatter4 = datePickerFormatter3;
                                                SelectableDates selectableDates6 = selectableDates5;
                                                DatePickerColors datePickerColors6 = datePickerColors5;
                                                composer3.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                                composer3.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                                CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillParentMaxWidth$default);
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
                                                Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                }
                                                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                                composer3.startReplaceableGroup(2058660585);
                                                ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer3, 1367623956, "C1671@74055L510:DatePicker.kt#uh7d8r");
                                                DatePickerKt.Month(plusMonths, function16, calendarDate3.getUtcTimeMillis(), l6, null, null, datePickerFormatter4, selectableDates6, datePickerColors6, composer3, 221184);
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
                                    }), 6, null);
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue2);
                        }
                        composer2.endReplaceableGroup();
                        LazyDslKt.LazyRow(semantics$default, lazyListState3, null, false, null, null, rememberSnapFlingBehavior$material3_release, false, (Function1) rememberedValue2, composer2, 0, 188);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), startRestartGroup, 48);
            startRestartGroup.startReplaceableGroup(1346194369);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
            int i4 = i3 & 14;
            boolean changedInstance = (i4 == 4) | ((i3 & 7168) == 2048) | startRestartGroup.changedInstance(calendarModel) | startRestartGroup.changedInstance(intRange);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                lazyListState2 = lazyListState;
                datePickerKt$HorizontalMonthsList$2$1 = new DatePickerKt$HorizontalMonthsList$2$1(lazyListState2, function12, calendarModel, intRange, null);
                startRestartGroup.updateRememberedValue(datePickerKt$HorizontalMonthsList$2$1);
            } else {
                datePickerKt$HorizontalMonthsList$2$1 = rememberedValue2;
                lazyListState2 = lazyListState;
            }
            startRestartGroup.endReplaceableGroup();
            EffectsKt.LaunchedEffect(lazyListState2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) datePickerKt$HorizontalMonthsList$2$1, startRestartGroup, i4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$HorizontalMonthsList$3
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
                    DatePickerKt.HorizontalMonthsList(LazyListState.this, l, function1, function12, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final Object updateDisplayedMonth(final LazyListState lazyListState, final Function1<? super Long, Unit> function1, final CalendarModel calendarModel, final IntRange intRange, Continuation<? super Unit> continuation) {
        Object collect = SnapshotStateKt.snapshotFlow(new Function0<Integer>() { // from class: androidx.compose.material3.DatePickerKt$updateDisplayedMonth$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(LazyListState.this.getFirstVisibleItemIndex());
            }
        }).collect(new FlowCollector() { // from class: androidx.compose.material3.DatePickerKt$updateDisplayedMonth$3
            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation2) {
                return emit(((Number) obj).intValue(), (Continuation<? super Unit>) continuation2);
            }

            public final Object emit(int i, Continuation<? super Unit> continuation2) {
                int firstVisibleItemIndex = LazyListState.this.getFirstVisibleItemIndex() / 12;
                function1.invoke(Boxing.boxLong(calendarModel.getMonth(intRange.getFirst() + firstVisibleItemIndex, (LazyListState.this.getFirstVisibleItemIndex() % 12) + 1).getStartUtcTimeMillis()));
                return Unit.INSTANCE;
            }
        }, continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v2, types: [boolean, int] */
    public static final void WeekDays(final DatePickerColors datePickerColors, final CalendarModel calendarModel, Composer composer, final int i) {
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1849465391);
        ComposerKt.sourceInformation(startRestartGroup, "C(WeekDays)P(1)1733@76133L10,1735@76204L990:DatePicker.kt#uh7d8r");
        int i2 = (i & 6) == 0 ? (startRestartGroup.changed(datePickerColors) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(calendarModel) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1849465391, i2, -1, "androidx.compose.material3.WeekDays (DatePicker.kt:1721)");
            }
            int firstDayOfWeek = calendarModel.getFirstDayOfWeek();
            List<Pair<String, String>> weekdayNames = calendarModel.getWeekdayNames();
            ArrayList arrayList = new ArrayList();
            int i3 = firstDayOfWeek - 1;
            int size = weekdayNames.size();
            for (int i4 = i3; i4 < size; i4++) {
                arrayList.add(weekdayNames.get(i4));
            }
            ?? r8 = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                arrayList.add(weekdayNames.get(i5));
            }
            int i6 = 6;
            TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), DatePickerModalTokens.INSTANCE.getWeekdaysLabelTextFont());
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(SizeKt.m913defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, 0.0f, RecommendedSizeForAccessibility, 1, null), 0.0f, 1, null);
            Arrangement.HorizontalOrVertical spaceEvenly = Arrangement.INSTANCE.getSpaceEvenly();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            startRestartGroup.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(spaceEvenly, centerVertically, startRestartGroup, 54);
            int i7 = -1323940314;
            startRestartGroup.startReplaceableGroup(-1323940314);
            String str = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh";
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 289869412, "C:DatePicker.kt#uh7d8r");
            startRestartGroup.startReplaceableGroup(-971954356);
            ComposerKt.sourceInformation(startRestartGroup, "*1747@76615L33,1745@76532L646");
            ArrayList arrayList2 = arrayList;
            int size2 = arrayList2.size();
            int i8 = 0;
            while (i8 < size2) {
                final Pair pair = (Pair) arrayList2.get(i8);
                Modifier.Companion companion = Modifier.INSTANCE;
                startRestartGroup.startReplaceableGroup(784223355);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
                boolean changed = startRestartGroup.changed(pair);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DatePickerKt$WeekDays$1$1$1$1
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
                            SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, pair.getFirst());
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceableGroup();
                Modifier clearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(companion, (Function1) rememberedValue);
                float f = RecommendedSizeForAccessibility;
                Modifier m930sizeVpY3zN4 = SizeKt.m930sizeVpY3zN4(clearAndSetSemantics, f, f);
                Alignment center = Alignment.INSTANCE.getCenter();
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, r8, startRestartGroup, i6);
                startRestartGroup.startReplaceableGroup(i7);
                ComposerKt.sourceInformation(startRestartGroup, str);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, r8);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m930sizeVpY3zN4);
                boolean z = r8;
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
                modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf(z ? 1 : 0));
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 178856377, "C1753@76900L264:DatePicker.kt#uh7d8r");
                Composer composer3 = startRestartGroup;
                TextKt.m2781Text4IGK_g((String) pair.getSecond(), SizeKt.wrapContentSize$default(Modifier.INSTANCE, null, z, 3, null), datePickerColors.getWeekdayContentColor(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m6274boximpl(TextAlign.INSTANCE.m6281getCentere0LSkKk()), 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, fromToken, composer3, 48, 0, 65016);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endReplaceableGroup();
                composer3.endNode();
                composer3.endReplaceableGroup();
                composer3.endReplaceableGroup();
                i8++;
                startRestartGroup = composer3;
                arrayList2 = arrayList2;
                i7 = -1323940314;
                str = str;
                size2 = size2;
                r8 = z ? 1 : 0;
                i6 = 6;
            }
            composer2 = startRestartGroup;
            composer2.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$WeekDays$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                    invoke(composer4, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer4, int i9) {
                    DatePickerKt.WeekDays(DatePickerColors.this, calendarModel, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void Month(final CalendarMonth calendarMonth, final Function1<? super Long, Unit> function1, final long j, final Long l, final Long l2, final SelectedRangeInfo selectedRangeInfo, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, Composer composer, final int i) {
        CalendarMonth calendarMonth2;
        int i2;
        Modifier.Companion companion;
        Composer composer2;
        String str;
        String str2;
        int i3;
        int i4;
        Composer composer3;
        String str3;
        int i5;
        Locale locale;
        int i6;
        boolean z;
        char c;
        Locale locale2;
        boolean z2;
        boolean z3;
        Object mutableStateOf$default;
        final Function1<? super Long, Unit> function12 = function1;
        final SelectedRangeInfo selectedRangeInfo2 = selectedRangeInfo;
        final DatePickerColors datePickerColors2 = datePickerColors;
        Composer startRestartGroup = composer.startRestartGroup(-1912870997);
        ComposerKt.sourceInformation(startRestartGroup, "C(Month)P(3,4,8,7,2,5,1,6)1790@77967L15,1792@78009L4836:DatePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            calendarMonth2 = calendarMonth;
            i2 = (startRestartGroup.changed(calendarMonth2) ? 4 : 2) | i;
        } else {
            calendarMonth2 = calendarMonth;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function12) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(j) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(l) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changed(l2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changed(selectedRangeInfo2) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= (2097152 & i) == 0 ? startRestartGroup.changed(datePickerFormatter) : startRestartGroup.changedInstance(datePickerFormatter) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= startRestartGroup.changed(selectableDates) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i2 |= startRestartGroup.changed(datePickerColors2) ? 67108864 : 33554432;
        }
        if ((38347923 & i2) != 38347922 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1912870997, i2, -1, "androidx.compose.material3.Month (DatePicker.kt:1780)");
            }
            startRestartGroup.startReplaceableGroup(-2019459922);
            ComposerKt.sourceInformation(startRestartGroup, "1782@77774L131");
            String str4 = "CC(remember):DatePicker.kt#9igjgp";
            if (selectedRangeInfo2 != null) {
                Modifier.Companion companion2 = Modifier.INSTANCE;
                startRestartGroup.startReplaceableGroup(-2019459855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
                boolean z4 = ((i2 & 458752) == 131072) | ((i2 & 234881024) == 67108864);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (z4 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material3.DatePickerKt$Month$rangeSelectionDrawModifier$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                            invoke2(contentDrawScope);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(ContentDrawScope contentDrawScope) {
                            DateRangePickerKt.m2156drawRangeBackgroundmxwnekA(contentDrawScope, SelectedRangeInfo.this, datePickerColors2.getDayInSelectionRangeContainerColor());
                            contentDrawScope.drawContent();
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceableGroup();
                companion = DrawModifierKt.drawWithContent(companion2, (Function1) rememberedValue);
            } else {
                companion = Modifier.INSTANCE;
            }
            startRestartGroup.endReplaceableGroup();
            Locale defaultLocale = ActualAndroid_androidKt.defaultLocale(startRestartGroup, 0);
            Modifier then = SizeKt.m917requiredHeight3ABfNKs(Modifier.INSTANCE, Dp.m6389constructorimpl(RecommendedSizeForAccessibility * 6)).then(companion);
            Arrangement.HorizontalOrVertical spaceEvenly = Arrangement.INSTANCE.getSpaceEvenly();
            startRestartGroup.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(spaceEvenly, Alignment.INSTANCE.getStart(), startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(-1323940314);
            String str5 = "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh";
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
            String str6 = "C:DatePicker.kt#uh7d8r";
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -713628571, "C:DatePicker.kt#uh7d8r");
            startRestartGroup.startReplaceableGroup(-2019459388);
            ComposerKt.sourceInformation(startRestartGroup, "*1799@78298L4531");
            int i7 = 0;
            int i8 = 0;
            int i9 = 6;
            while (i7 < i9) {
                int i10 = i7;
                int i11 = i8;
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                Arrangement.HorizontalOrVertical spaceEvenly2 = Arrangement.INSTANCE.getSpaceEvenly();
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                startRestartGroup.startReplaceableGroup(693286680);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(spaceEvenly2, centerVertically, startRestartGroup, 54);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, str5);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
                String str7 = str5;
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
                Updater.m3600setimpl(m3593constructorimpl2, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1111236200, str6);
                startRestartGroup.startReplaceableGroup(-713628297);
                String str8 = "";
                ComposerKt.sourceInformation(startRestartGroup, "");
                int i12 = i11;
                int i13 = 0;
                while (i13 < 7) {
                    if (i12 < calendarMonth2.getDaysFromStartOfWeekToFirstOfMonth() || i12 >= calendarMonth2.getDaysFromStartOfWeekToFirstOfMonth() + calendarMonth2.getNumberOfDays()) {
                        str = str8;
                        str2 = str6;
                        i3 = i13;
                        i4 = i12;
                        composer3 = startRestartGroup;
                        str3 = str4;
                        i5 = i2;
                        locale = defaultLocale;
                        composer3.startReplaceableGroup(-1111235936);
                        ComposerKt.sourceInformation(composer3, "1810@78843L271");
                        Modifier.Companion companion3 = Modifier.INSTANCE;
                        float f = RecommendedSizeForAccessibility;
                        SpacerKt.Spacer(SizeKt.m922requiredSizeVpY3zN4(companion3, f, f), composer3, 6);
                        composer3.endReplaceableGroup();
                    } else {
                        startRestartGroup.startReplaceableGroup(-1111235573);
                        ComposerKt.sourceInformation(startRestartGroup, "1834@80231L341,1849@81021L39,1854@81396L518,1846@80852L1891");
                        final int daysFromStartOfWeekToFirstOfMonth = i12 - calendarMonth2.getDaysFromStartOfWeekToFirstOfMonth();
                        str = str8;
                        final long startUtcTimeMillis = calendarMonth2.getStartUtcTimeMillis() + (daysFromStartOfWeekToFirstOfMonth * 86400000);
                        boolean z5 = startUtcTimeMillis == j;
                        boolean z6 = l != null && startUtcTimeMillis == l.longValue();
                        if (l2 != null && startUtcTimeMillis == l2.longValue()) {
                            i6 = i2;
                            z = true;
                        } else {
                            i6 = i2;
                            z = false;
                        }
                        str2 = str6;
                        startRestartGroup.startReplaceableGroup(-1111235085);
                        ComposerKt.sourceInformation(startRestartGroup, "1824@79692L387");
                        if (selectedRangeInfo2 != null) {
                            startRestartGroup.startReplaceableGroup(-1111235023);
                            ComposerKt.sourceInformation(startRestartGroup, str4);
                            i3 = i13;
                            boolean changed = ((i6 & 458752) == 131072) | startRestartGroup.changed(startUtcTimeMillis);
                            Object rememberedValue2 = startRestartGroup.rememberedValue();
                            if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                if (startUtcTimeMillis >= (l != null ? l.longValue() : Long.MAX_VALUE)) {
                                    if (startUtcTimeMillis <= (l2 != null ? l2.longValue() : Long.MIN_VALUE)) {
                                        z3 = true;
                                        i4 = i12;
                                        c = 2;
                                        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), null, 2, null);
                                        startRestartGroup.updateRememberedValue(mutableStateOf$default);
                                    }
                                }
                                z3 = false;
                                i4 = i12;
                                c = 2;
                                mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), null, 2, null);
                                startRestartGroup.updateRememberedValue(mutableStateOf$default);
                            } else {
                                mutableStateOf$default = rememberedValue2;
                                i4 = i12;
                                c = 2;
                            }
                            startRestartGroup.endReplaceableGroup();
                            Locale locale3 = defaultLocale;
                            z2 = ((Boolean) ((MutableState) mutableStateOf$default).getValue()).booleanValue();
                            locale2 = locale3;
                        } else {
                            i3 = i13;
                            i4 = i12;
                            c = 2;
                            locale2 = defaultLocale;
                            z2 = false;
                        }
                        startRestartGroup.endReplaceableGroup();
                        Composer composer4 = startRestartGroup;
                        Locale locale4 = locale2;
                        String str9 = str4;
                        boolean z7 = z6;
                        String dayContentDescription = dayContentDescription(selectedRangeInfo2 != null, z5, z7, z, z2, composer4, 0);
                        boolean z8 = z2;
                        boolean z9 = z5;
                        i5 = i6;
                        String formatDate = datePickerFormatter.formatDate(Long.valueOf(startUtcTimeMillis), locale4, true);
                        if (formatDate == null) {
                            formatDate = str;
                        }
                        Modifier.Companion companion4 = Modifier.INSTANCE;
                        boolean z10 = z7 || z;
                        composer4.startReplaceableGroup(-1111233694);
                        str3 = str9;
                        ComposerKt.sourceInformation(composer4, str3);
                        locale = locale4;
                        boolean changed2 = ((i5 & 112) == 32) | composer4.changed(startUtcTimeMillis);
                        Object rememberedValue3 = composer4.rememberedValue();
                        if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue3 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.DatePickerKt$Month$1$1$1$1
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
                                    function12.invoke(Long.valueOf(startUtcTimeMillis));
                                }
                            };
                            composer4.updateRememberedValue(rememberedValue3);
                        }
                        Function0 function0 = (Function0) rememberedValue3;
                        composer4.endReplaceableGroup();
                        composer4.startReplaceableGroup(-1111233319);
                        ComposerKt.sourceInformation(composer4, str3);
                        boolean changed3 = composer4.changed(startUtcTimeMillis);
                        Object rememberedValue4 = composer4.rememberedValue();
                        if (changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue4 = Boolean.valueOf(selectableDates.isSelectableYear(calendarMonth.getYear()) && selectableDates.isSelectableDate(startUtcTimeMillis));
                            composer4.updateRememberedValue(rememberedValue4);
                        }
                        boolean booleanValue = ((Boolean) rememberedValue4).booleanValue();
                        composer4.endReplaceableGroup();
                        if (dayContentDescription != null) {
                            formatDate = dayContentDescription + ", " + formatDate;
                        }
                        Day(companion4, z10, function0, z7, booleanValue, z9, z8, formatDate, datePickerColors2, ComposableLambdaKt.composableLambda(composer4, -2095706591, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$Month$1$1$3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                invoke(composer5, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer5, int i14) {
                                ComposerKt.sourceInformation(composer5, "C1872@82396L321:DatePicker.kt#uh7d8r");
                                if ((i14 & 3) != 2 || !composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-2095706591, i14, -1, "androidx.compose.material3.Month.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:1872)");
                                    }
                                    TextKt.m2781Text4IGK_g(ActualJvm_jvmKt.toLocalString$default(daysFromStartOfWeekToFirstOfMonth + 1, 0, 0, false, 7, null), SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DatePickerKt$Month$1$1$3.1
                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                            invoke2(semanticsPropertyReceiver);
                                            return Unit.INSTANCE;
                                        }
                                    }), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m6274boximpl(TextAlign.INSTANCE.m6281getCentere0LSkKk()), 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer5, 0, 0, 130556);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer5.skipToGroupEnd();
                            }
                        }), composer4, (i5 & 234881024) | 805306374);
                        composer3 = composer4;
                        composer3.endReplaceableGroup();
                    }
                    i13 = i3 + 1;
                    function12 = function1;
                    selectedRangeInfo2 = selectedRangeInfo;
                    datePickerColors2 = datePickerColors;
                    i12 = i4 + 1;
                    str4 = str3;
                    startRestartGroup = composer3;
                    str8 = str;
                    str6 = str2;
                    defaultLocale = locale;
                    i2 = i5;
                    calendarMonth2 = calendarMonth;
                }
                Composer composer5 = startRestartGroup;
                i9 = 6;
                composer5.endReplaceableGroup();
                ComposerKt.sourceInformationMarkerEnd(composer5);
                ComposerKt.sourceInformationMarkerEnd(composer5);
                composer5.endReplaceableGroup();
                composer5.endNode();
                composer5.endReplaceableGroup();
                composer5.endReplaceableGroup();
                i7 = i10 + 1;
                function12 = function1;
                selectedRangeInfo2 = selectedRangeInfo;
                datePickerColors2 = datePickerColors;
                i8 = i12;
                str5 = str7;
                str6 = str6;
                calendarMonth2 = calendarMonth;
            }
            composer2 = startRestartGroup;
            composer2.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$Month$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                    invoke(composer6, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer6, int i14) {
                    DatePickerKt.Month(CalendarMonth.this, function1, j, l, l2, selectedRangeInfo, datePickerFormatter, selectableDates, datePickerColors, composer6, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final int numberOfMonthsInRange(IntRange intRange) {
        return ((intRange.getLast() - intRange.getFirst()) + 1) * 12;
    }

    private static final String dayContentDescription(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, Composer composer, int i) {
        composer.startReplaceableGroup(502032503);
        ComposerKt.sourceInformation(composer, "C(dayContentDescription)P(4,3,2)1919@83871L54:DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(502032503, i, -1, "androidx.compose.material3.dayContentDescription (DatePicker.kt:1900)");
        }
        StringBuilder sb = new StringBuilder();
        composer.startReplaceableGroup(-852185051);
        ComposerKt.sourceInformation(composer, "");
        if (z) {
            if (z3) {
                composer.startReplaceableGroup(-852184961);
                ComposerKt.sourceInformation(composer, "1905@83379L56");
                Strings.Companion companion = Strings.INSTANCE;
                sb.append(Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_date_range_picker_start_headline), composer, 0));
                composer.endReplaceableGroup();
            } else if (z4) {
                composer.startReplaceableGroup(-852184821);
                ComposerKt.sourceInformation(composer, "1909@83519L54");
                Strings.Companion companion2 = Strings.INSTANCE;
                sb.append(Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_date_range_picker_end_headline), composer, 0));
                composer.endReplaceableGroup();
            } else if (z5) {
                composer.startReplaceableGroup(-852184683);
                ComposerKt.sourceInformation(composer, "1913@83657L53");
                Strings.Companion companion3 = Strings.INSTANCE;
                sb.append(Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_date_range_picker_day_in_range), composer, 0));
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(-852184582);
                composer.endReplaceableGroup();
            }
        }
        composer.endReplaceableGroup();
        if (z2) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            Strings.Companion companion4 = Strings.INSTANCE;
            sb.append(Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_date_picker_today_description), composer, 0));
        }
        String sb2 = sb.length() == 0 ? null : sb.toString();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return sb2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Day(final Modifier modifier, final boolean z, final Function0<Unit> function0, final boolean z2, final boolean z3, final boolean z4, final boolean z5, final String str, final DatePickerColors datePickerColors, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        boolean z6;
        boolean z7;
        boolean z8;
        DatePickerColors datePickerColors2;
        Composer startRestartGroup = composer.startRestartGroup(-1434777861);
        ComposerKt.sourceInformation(startRestartGroup, "C(Day)P(6,8,7!1,4,9,5,3)1945@84736L102,1950@84924L5,1951@84954L129,1956@85121L150,1938@84354L1463:DatePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            z6 = z2;
            i2 |= startRestartGroup.changed(z6) ? 2048 : 1024;
        } else {
            z6 = z2;
        }
        if ((i & 24576) == 0) {
            z7 = z3;
            i2 |= startRestartGroup.changed(z7) ? 16384 : 8192;
        } else {
            z7 = z3;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changed(z4) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            z8 = z5;
            i2 |= startRestartGroup.changed(z8) ? 1048576 : 524288;
        } else {
            z8 = z5;
        }
        if ((12582912 & i) == 0) {
            i2 |= startRestartGroup.changed(str) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            datePickerColors2 = datePickerColors;
            i2 |= startRestartGroup.changed(datePickerColors2) ? 67108864 : 33554432;
        } else {
            datePickerColors2 = datePickerColors;
        }
        if ((805306368 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 536870912 : 268435456;
        }
        int i3 = i2;
        if ((306783379 & i3) != 306783378 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1434777861, i3, -1, "androidx.compose.material3.Day (DatePicker.kt:1937)");
            }
            startRestartGroup.startReplaceableGroup(1664739143);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
            boolean z9 = (29360128 & i3) == 8388608;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z9 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DatePickerKt$Day$1$1
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
                        SemanticsPropertiesKt.setText(semanticsPropertyReceiver, new AnnotatedString(str, null, null, 6, null));
                        SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5716getButtono7Vup1c());
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            Modifier semantics = SemanticsModifierKt.semantics(modifier, true, (Function1) rememberedValue);
            Shape value = ShapesKt.getValue(DatePickerModalTokens.INSTANCE.getDateContainerShape(), startRestartGroup, 6);
            int i4 = i3 >> 3;
            int i5 = i3 >> 15;
            long m4073unboximpl = datePickerColors2.dayContainerColor$material3_release(z, z7, z6, startRestartGroup, (i5 & 7168) | (i4 & 14) | ((i3 >> 9) & 112) | (i4 & 896)).getValue().m4073unboximpl();
            int i6 = i3 >> 12;
            SurfaceKt.m2634Surfaced85dljk(z, function0, semantics, z3, value, m4073unboximpl, datePickerColors.dayContentColor$material3_release(z4, z, z8, z3, startRestartGroup, (i5 & 14) | (i3 & 112) | (i6 & 896) | (i4 & 7168) | (i6 & 57344)).getValue().m4073unboximpl(), 0.0f, 0.0f, (!z4 || z) ? null : BorderStrokeKt.m554BorderStrokecXLIe8U(DatePickerModalTokens.INSTANCE.m3101getDateTodayContainerOutlineWidthD9Ej5fM(), datePickerColors.getTodayDateBorderColor()), (MutableInteractionSource) null, ComposableLambdaKt.composableLambda(startRestartGroup, -2031780827, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$Day$2
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

                public final void invoke(Composer composer2, int i7) {
                    ComposerKt.sourceInformation(composer2, "C1971@85536L275:DatePicker.kt#uh7d8r");
                    if ((i7 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2031780827, i7, -1, "androidx.compose.material3.Day.<anonymous> (DatePicker.kt:1971)");
                        }
                        Modifier m922requiredSizeVpY3zN4 = SizeKt.m922requiredSizeVpY3zN4(Modifier.INSTANCE, DatePickerModalTokens.INSTANCE.m3100getDateStateLayerWidthD9Ej5fM(), DatePickerModalTokens.INSTANCE.m3099getDateStateLayerHeightD9Ej5fM());
                        Alignment center = Alignment.INSTANCE.getCenter();
                        Function2<Composer, Integer, Unit> function22 = function2;
                        composer2.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m922requiredSizeVpY3zN4);
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer2.useNode();
                        }
                        Composer m3593constructorimpl = Updater.m3593constructorimpl(composer2);
                        Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, -806739671, "C1978@85792L9:DatePicker.kt#uh7d8r");
                        function22.invoke(composer2, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), startRestartGroup, i4 & 7294, 48, 1408);
            startRestartGroup = startRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$Day$3
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

                public final void invoke(Composer composer2, int i7) {
                    DatePickerKt.Day(Modifier.this, z, function0, z2, z3, z4, z5, str, datePickerColors, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void YearPicker(final Modifier modifier, final long j, final Function1<? super Integer, Unit> function1, final SelectableDates selectableDates, final CalendarModel calendarModel, final IntRange intRange, final DatePickerColors datePickerColors, Composer composer, final int i) {
        Modifier modifier2;
        int i2;
        Function1<? super Integer, Unit> function12;
        SelectableDates selectableDates2;
        CalendarModel calendarModel2;
        IntRange intRange2;
        DatePickerColors datePickerColors2;
        Composer startRestartGroup = composer.startRestartGroup(-1286899812);
        ComposerKt.sourceInformation(startRestartGroup, "C(YearPicker)P(3,2,4,5!1,6)1995@86176L10,1994@86128L4075:DatePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            modifier2 = modifier;
            i2 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            function12 = function1;
            i2 |= startRestartGroup.changedInstance(function12) ? 256 : 128;
        } else {
            function12 = function1;
        }
        if ((i & 3072) == 0) {
            selectableDates2 = selectableDates;
            i2 |= startRestartGroup.changed(selectableDates2) ? 2048 : 1024;
        } else {
            selectableDates2 = selectableDates;
        }
        if ((i & 24576) == 0) {
            calendarModel2 = calendarModel;
            i2 |= startRestartGroup.changedInstance(calendarModel2) ? 16384 : 8192;
        } else {
            calendarModel2 = calendarModel;
        }
        if ((196608 & i) == 0) {
            intRange2 = intRange;
            i2 |= startRestartGroup.changedInstance(intRange2) ? 131072 : 65536;
        } else {
            intRange2 = intRange;
        }
        if ((1572864 & i) == 0) {
            datePickerColors2 = datePickerColors;
            i2 |= startRestartGroup.changed(datePickerColors2) ? 1048576 : 524288;
        } else {
            datePickerColors2 = datePickerColors;
        }
        if ((599187 & i2) != 599186 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1286899812, i2, -1, "androidx.compose.material3.YearPicker (DatePicker.kt:1993)");
            }
            final Modifier modifier3 = modifier2;
            final Function1<? super Integer, Unit> function13 = function12;
            final SelectableDates selectableDates3 = selectableDates2;
            final CalendarModel calendarModel3 = calendarModel2;
            final IntRange intRange3 = intRange2;
            final DatePickerColors datePickerColors3 = datePickerColors2;
            TextKt.ProvideTextStyle(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), DatePickerModalTokens.INSTANCE.getSelectionYearLabelTextFont()), ComposableLambdaKt.composableLambda(startRestartGroup, 1301915789, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$YearPicker$1
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
                    float f;
                    final LazyGridState lazyGridState;
                    ComposerKt.sourceInformation(composer2, "C2000@86448L319,2008@86911L11,2010@87049L7,2008@86923L143,2012@87096L24,2013@87161L53,2014@87253L51,2027@87936L2261,2015@87313L2884:DatePicker.kt#uh7d8r");
                    if ((i3 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1301915789, i3, -1, "androidx.compose.material3.YearPicker.<anonymous> (DatePicker.kt:1997)");
                        }
                        CalendarModel calendarModel4 = CalendarModel.this;
                        final int year = calendarModel4.getMonth(calendarModel4.getToday()).getYear();
                        final int year2 = CalendarModel.this.getMonth(j).getYear();
                        LazyGridState rememberLazyGridState = LazyGridStateKt.rememberLazyGridState(Math.max(0, (year2 - intRange3.getFirst()) - 3), 0, composer2, 0, 2);
                        ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(composer2, 6);
                        long containerColor = datePickerColors3.getContainerColor();
                        ProvidableCompositionLocal<Dp> localAbsoluteTonalElevation = SurfaceKt.getLocalAbsoluteTonalElevation();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume = composer2.consume(localAbsoluteTonalElevation);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        long m2047applyTonalElevationRFCenO8 = ColorSchemeKt.m2047applyTonalElevationRFCenO8(colorScheme, containerColor, ((Dp) consume).m6403unboximpl(), composer2, 0);
                        composer2.startReplaceableGroup(773894976);
                        ComposerKt.sourceInformation(composer2, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                        composer2.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composer2, "CC(remember):Composables.kt#9igjgp");
                        Object rememberedValue = composer2.rememberedValue();
                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                            Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer2));
                            composer2.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                            rememberedValue = compositionScopedCoroutineScopeCanceller;
                        }
                        composer2.endReplaceableGroup();
                        final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                        composer2.endReplaceableGroup();
                        Strings.Companion companion = Strings.INSTANCE;
                        final String m2623getStringNWtq28 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_date_picker_scroll_to_earlier_years), composer2, 0);
                        Strings.Companion companion2 = Strings.INSTANCE;
                        final String m2623getStringNWtq282 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_date_picker_scroll_to_later_years), composer2, 0);
                        GridCells.Fixed fixed = new GridCells.Fixed(3);
                        Modifier semantics$default = SemanticsModifierKt.semantics$default(BackgroundKt.m527backgroundbw27NRU$default(modifier3, m2047applyTonalElevationRFCenO8, null, 2, null), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DatePickerKt$YearPicker$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.setVerticalScrollAxisRange(semanticsPropertyReceiver, new ScrollAxisRange(new Function0<Float>() { // from class: androidx.compose.material3.DatePickerKt.YearPicker.1.1.1
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Float invoke() {
                                        return Float.valueOf(0.0f);
                                    }
                                }, new Function0<Float>() { // from class: androidx.compose.material3.DatePickerKt.YearPicker.1.1.2
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Float invoke() {
                                        return Float.valueOf(0.0f);
                                    }
                                }, false, 4, null));
                            }
                        }, 1, null);
                        Arrangement.HorizontalOrVertical spaceEvenly = Arrangement.INSTANCE.getSpaceEvenly();
                        Arrangement arrangement = Arrangement.INSTANCE;
                        f = DatePickerKt.YearsVerticalPadding;
                        GridCells.Fixed fixed2 = fixed;
                        Arrangement.HorizontalOrVertical m788spacedBy0680j_4 = arrangement.m788spacedBy0680j_4(f);
                        Arrangement.HorizontalOrVertical horizontalOrVertical = spaceEvenly;
                        composer2.startReplaceableGroup(-969328877);
                        ComposerKt.sourceInformation(composer2, "CC(remember):DatePicker.kt#9igjgp");
                        boolean changedInstance = composer2.changedInstance(intRange3) | composer2.changed(rememberLazyGridState) | composer2.changedInstance(coroutineScope) | composer2.changed(m2623getStringNWtq28) | composer2.changed(m2623getStringNWtq282) | composer2.changed(year2) | composer2.changed(year) | composer2.changed(function13) | composer2.changed(selectableDates3) | composer2.changed(datePickerColors3);
                        final IntRange intRange4 = intRange3;
                        final Function1<Integer, Unit> function14 = function13;
                        final SelectableDates selectableDates4 = selectableDates3;
                        final DatePickerColors datePickerColors4 = datePickerColors3;
                        Object rememberedValue2 = composer2.rememberedValue();
                        if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            lazyGridState = rememberLazyGridState;
                            rememberedValue2 = (Function1) new Function1<LazyGridScope, Unit>() { // from class: androidx.compose.material3.DatePickerKt$YearPicker$1$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(LazyGridScope lazyGridScope) {
                                    invoke2(lazyGridScope);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(LazyGridScope lazyGridScope) {
                                    int count = CollectionsKt.count(IntRange.this);
                                    final IntRange intRange5 = IntRange.this;
                                    final LazyGridState lazyGridState2 = lazyGridState;
                                    final CoroutineScope coroutineScope2 = coroutineScope;
                                    final String str = m2623getStringNWtq28;
                                    final String str2 = m2623getStringNWtq282;
                                    final int i4 = year2;
                                    final int i5 = year;
                                    final Function1<Integer, Unit> function15 = function14;
                                    final SelectableDates selectableDates5 = selectableDates4;
                                    final DatePickerColors datePickerColors5 = datePickerColors4;
                                    LazyGridScope.items$default(lazyGridScope, count, null, null, null, ComposableLambdaKt.composableLambdaInstance(1040623618, true, new Function4<LazyGridItemScope, Integer, Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$YearPicker$1$2$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(4);
                                        }

                                        @Override // kotlin.jvm.functions.Function4
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Integer num, Composer composer3, Integer num2) {
                                            invoke(lazyGridItemScope, num.intValue(), composer3, num2.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyGridItemScope lazyGridItemScope, final int i6, Composer composer3, int i7) {
                                            int i8;
                                            ComposerKt.sourceInformation(composer3, "C2037@88435L975,2056@89567L32,*2058@89713L54,2031@88114L2059:DatePicker.kt#uh7d8r");
                                            if ((i7 & 48) == 0) {
                                                i8 = i7 | (composer3.changed(i6) ? 32 : 16);
                                            } else {
                                                i8 = i7;
                                            }
                                            if ((i8 & 145) != 144 || !composer3.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1040623618, i8, -1, "androidx.compose.material3.YearPicker.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:2029)");
                                                }
                                                final int first = i6 + IntRange.this.getFirst();
                                                final String localString$default = ActualJvm_jvmKt.toLocalString$default(first, 0, 0, false, 7, null);
                                                Modifier m922requiredSizeVpY3zN4 = SizeKt.m922requiredSizeVpY3zN4(Modifier.INSTANCE, DatePickerModalTokens.INSTANCE.m3108getSelectionYearContainerWidthD9Ej5fM(), DatePickerModalTokens.INSTANCE.m3107getSelectionYearContainerHeightD9Ej5fM());
                                                composer3.startReplaceableGroup(-1669466775);
                                                ComposerKt.sourceInformation(composer3, "CC(remember):DatePicker.kt#9igjgp");
                                                boolean changed = ((i8 & 112) == 32) | composer3.changed(lazyGridState2) | composer3.changedInstance(coroutineScope2) | composer3.changed(str) | composer3.changed(str2);
                                                final LazyGridState lazyGridState3 = lazyGridState2;
                                                final CoroutineScope coroutineScope3 = coroutineScope2;
                                                final String str3 = str;
                                                final String str4 = str2;
                                                Object rememberedValue3 = composer3.rememberedValue();
                                                if (changed || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue3 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DatePickerKt$YearPicker$1$2$1$1$1$1
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
                                                            List customScrollActions;
                                                            LazyGridItemInfo lazyGridItemInfo;
                                                            if (LazyGridState.this.getFirstVisibleItemIndex() == i6 || ((lazyGridItemInfo = (LazyGridItemInfo) CollectionsKt.lastOrNull((List) LazyGridState.this.getLayoutInfo().getVisibleItemsInfo())) != null && lazyGridItemInfo.getIndex() == i6)) {
                                                                customScrollActions = DatePickerKt.customScrollActions(LazyGridState.this, coroutineScope3, str3, str4);
                                                            } else {
                                                                customScrollActions = CollectionsKt.emptyList();
                                                            }
                                                            SemanticsPropertiesKt.setCustomActions(semanticsPropertyReceiver, customScrollActions);
                                                        }
                                                    };
                                                    composer3.updateRememberedValue(rememberedValue3);
                                                }
                                                composer3.endReplaceableGroup();
                                                Modifier semantics$default2 = SemanticsModifierKt.semantics$default(m922requiredSizeVpY3zN4, false, (Function1) rememberedValue3, 1, null);
                                                boolean z = first == i4;
                                                boolean z2 = first == i5;
                                                composer3.startReplaceableGroup(-1669465643);
                                                ComposerKt.sourceInformation(composer3, "CC(remember):DatePicker.kt#9igjgp");
                                                boolean changed2 = composer3.changed(function15) | composer3.changed(first);
                                                final Function1<Integer, Unit> function16 = function15;
                                                Object rememberedValue4 = composer3.rememberedValue();
                                                if (changed2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue4 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.DatePickerKt$YearPicker$1$2$1$1$2$1
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
                                                            function16.invoke(Integer.valueOf(first));
                                                        }
                                                    };
                                                    composer3.updateRememberedValue(rememberedValue4);
                                                }
                                                Function0 function0 = (Function0) rememberedValue4;
                                                composer3.endReplaceableGroup();
                                                boolean isSelectableYear = selectableDates5.isSelectableYear(first);
                                                Strings.Companion companion3 = Strings.INSTANCE;
                                                String format = String.format(Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_date_picker_navigate_to_year_description), composer3, 0), Arrays.copyOf(new Object[]{localString$default}, 1));
                                                Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                                                DatePickerKt.Year(semantics$default2, z, z2, function0, isSelectableYear, format, datePickerColors5, ComposableLambdaKt.composableLambda(composer3, 882189459, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt.YearPicker.1.2.1.1.3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                        invoke(composer4, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer4, int i9) {
                                                        ComposerKt.sourceInformation(composer4, "C2062@89892L263:DatePicker.kt#uh7d8r");
                                                        if ((i9 & 3) != 2 || !composer4.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(882189459, i9, -1, "androidx.compose.material3.YearPicker.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:2062)");
                                                            }
                                                            TextKt.m2781Text4IGK_g(localString$default, SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DatePickerKt.YearPicker.1.2.1.1.3.1
                                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                                    invoke2(semanticsPropertyReceiver);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m6274boximpl(TextAlign.INSTANCE.m6281getCentere0LSkKk()), 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer4, 0, 0, 130556);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer4.skipToGroupEnd();
                                                    }
                                                }), composer3, 12582912);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    }), 14, null);
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue2);
                        } else {
                            lazyGridState = rememberLazyGridState;
                        }
                        composer2.endReplaceableGroup();
                        LazyGridDslKt.LazyVerticalGrid(fixed2, semantics$default, lazyGridState, null, false, m788spacedBy0680j_4, horizontalOrVertical, null, false, (Function1) rememberedValue2, composer2, 1769472, 408);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), startRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$YearPicker$2
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
                    DatePickerKt.YearPicker(Modifier.this, j, function1, selectableDates, calendarModel, intRange, datePickerColors, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Year(final Modifier modifier, final boolean z, final boolean z2, final Function0<Unit> function0, final boolean z3, final String str, final DatePickerColors datePickerColors, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        int i3;
        Object obj;
        Composer startRestartGroup = composer.startRestartGroup(238547184);
        ComposerKt.sourceInformation(startRestartGroup, "C(Year)P(5,7,2,6,4,3)2086@90509L353,2103@91225L90,2108@91411L5,2109@91441L58,2110@91537L129,2097@90867L964:DatePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changed(z3) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changed(str) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= startRestartGroup.changed(datePickerColors) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 8388608 : 4194304;
        }
        if ((4793491 & i2) != 4793490 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(238547184, i2, -1, "androidx.compose.material3.Year (DatePicker.kt:2085)");
            }
            startRestartGroup.startReplaceableGroup(84263149);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
            int i4 = i2 & 112;
            boolean z4 = (i4 == 32) | ((i2 & 896) == 256);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z4 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                if (!z2 || z) {
                    i3 = i2;
                    obj = null;
                } else {
                    i3 = i2;
                    obj = BorderStrokeKt.m554BorderStrokecXLIe8U(DatePickerModalTokens.INSTANCE.m3101getDateTodayContainerOutlineWidthD9Ej5fM(), datePickerColors.getTodayDateBorderColor());
                }
                startRestartGroup.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
                i3 = i2;
            }
            BorderStroke borderStroke = (BorderStroke) obj;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(84263865);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DatePicker.kt#9igjgp");
            boolean z5 = (458752 & i3) == 131072;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DatePickerKt$Year$1$1
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
                        SemanticsPropertiesKt.setText(semanticsPropertyReceiver, new AnnotatedString(str, null, null, 6, null));
                        SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5716getButtono7Vup1c());
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            Modifier semantics = SemanticsModifierKt.semantics(modifier, true, (Function1) rememberedValue2);
            Shape value = ShapesKt.getValue(DatePickerModalTokens.INSTANCE.getSelectionYearStateLayerShape(), startRestartGroup, 6);
            int i5 = i3 >> 3;
            int i6 = i5 & 14;
            int i7 = i3 >> 9;
            long m4073unboximpl = datePickerColors.yearContainerColor$material3_release(z, z3, startRestartGroup, i6 | (i7 & 112) | ((i3 >> 12) & 896)).getValue().m4073unboximpl();
            int i8 = i3 >> 6;
            SurfaceKt.m2634Surfaced85dljk(z, function0, semantics, z3, value, m4073unboximpl, datePickerColors.yearContentColor$material3_release(z2, z, z3, startRestartGroup, (i7 & 7168) | i4 | (i8 & 14) | (i8 & 896)).getValue().m4073unboximpl(), 0.0f, 0.0f, borderStroke, (MutableInteractionSource) null, ComposableLambdaKt.composableLambda(startRestartGroup, -1573188346, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$Year$2
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
                    ComposerKt.sourceInformation(composer2, "C2117@91715L110:DatePicker.kt#uh7d8r");
                    if ((i9 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1573188346, i9, -1, "androidx.compose.material3.Year.<anonymous> (DatePicker.kt:2117)");
                        }
                        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Alignment center = Alignment.INSTANCE.getCenter();
                        Function2<Composer, Integer, Unit> function22 = function2;
                        composer2.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer2.useNode();
                        }
                        Composer m3593constructorimpl = Updater.m3593constructorimpl(composer2);
                        Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, 873758912, "C2118@91806L9:DatePicker.kt#uh7d8r");
                        function22.invoke(composer2, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), startRestartGroup, i6 | (i8 & 112) | (i5 & 7168), 48, 1408);
            startRestartGroup = startRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$Year$3
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
                    DatePickerKt.Year(Modifier.this, z, z2, function0, z3, str, datePickerColors, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MonthsNavigation(final Modifier modifier, final boolean z, final boolean z2, final boolean z3, final String str, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, DatePickerColors datePickerColors, Composer composer, final int i) {
        int i2;
        Function0<Unit> function04;
        Function0<Unit> function05;
        DatePickerColors datePickerColors2;
        Arrangement.HorizontalOrVertical spaceBetween;
        Composer startRestartGroup = composer.startRestartGroup(-773929258);
        ComposerKt.sourceInformation(startRestartGroup, "C(MonthsNavigation)P(1,2,6,8,7,3,4,5)2140@92337L1934:DatePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(z3) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changed(str) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            function04 = function02;
            i2 |= startRestartGroup.changedInstance(function04) ? 1048576 : 524288;
        } else {
            function04 = function02;
        }
        if ((12582912 & i) == 0) {
            function05 = function03;
            i2 |= startRestartGroup.changedInstance(function05) ? 8388608 : 4194304;
        } else {
            function05 = function03;
        }
        if ((100663296 & i) == 0) {
            datePickerColors2 = datePickerColors;
            i2 |= startRestartGroup.changed(datePickerColors2) ? 67108864 : 33554432;
        } else {
            datePickerColors2 = datePickerColors;
        }
        if ((38347923 & i2) != 38347922 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-773929258, i2, -1, "androidx.compose.material3.MonthsNavigation (DatePicker.kt:2139)");
            }
            Modifier m917requiredHeight3ABfNKs = SizeKt.m917requiredHeight3ABfNKs(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), MonthYearHeight);
            if (z3) {
                spaceBetween = Arrangement.INSTANCE.getStart();
            } else {
                spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            }
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            startRestartGroup.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, startRestartGroup, 48);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m917requiredHeight3ABfNKs);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1911948306, "C2151@92667L1598:DatePicker.kt#uh7d8r");
            final Function0<Unit> function06 = function04;
            final Function0<Unit> function07 = function05;
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(datePickerColors2.getNavigationContentColor())), ComposableLambdaKt.composableLambda(startRestartGroup, -962805198, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$MonthsNavigation$1$1
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
                    ComposerKt.sourceInformation(composer2, "C2153@92815L580,2167@93545L696:DatePicker.kt#uh7d8r");
                    if ((i3 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-962805198, i3, -1, "androidx.compose.material3.MonthsNavigation.<anonymous>.<anonymous> (DatePicker.kt:2153)");
                        }
                        Function0<Unit> function08 = function07;
                        boolean z4 = z3;
                        final String str2 = str;
                        DatePickerKt.YearPickerMenuButton(function08, z4, null, ComposableLambdaKt.composableLambda(composer2, 1377272806, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$MonthsNavigation$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i4) {
                                ComposerKt.sourceInformation(composer3, "C2158@93045L335,2157@92967L414:DatePicker.kt#uh7d8r");
                                if ((i4 & 3) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1377272806, i4, -1, "androidx.compose.material3.MonthsNavigation.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:2157)");
                                    }
                                    String str3 = str2;
                                    Modifier.Companion companion = Modifier.INSTANCE;
                                    composer3.startReplaceableGroup(1090374478);
                                    ComposerKt.sourceInformation(composer3, "CC(remember):DatePicker.kt#9igjgp");
                                    boolean changed = composer3.changed(str2);
                                    final String str4 = str2;
                                    Object rememberedValue = composer3.rememberedValue();
                                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DatePickerKt$MonthsNavigation$1$1$1$1$1
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
                                                SemanticsPropertiesKt.m5731setLiveRegionhR3wRGc(semanticsPropertyReceiver, LiveRegionMode.INSTANCE.m5708getPolite0phEisY());
                                                SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str4);
                                            }
                                        };
                                        composer3.updateRememberedValue(rememberedValue);
                                    }
                                    composer3.endReplaceableGroup();
                                    TextKt.m2781Text4IGK_g(str3, SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue, 1, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 0, 0, 131068);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }), composer2, 3072, 4);
                        if (!z3) {
                            Function0<Unit> function09 = function06;
                            boolean z5 = z2;
                            Function0<Unit> function010 = function0;
                            boolean z6 = z;
                            composer2.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                            Modifier.Companion companion = Modifier.INSTANCE;
                            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer2, 0);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion);
                            if (!(composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor2);
                            } else {
                                composer2.useNode();
                            }
                            Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer2);
                            Updater.m3600setimpl(m3593constructorimpl2, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                            }
                            modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer2, 1090375004, "C2168@93571L321,2174@93913L310:DatePicker.kt#uh7d8r");
                            IconButtonKt.IconButton(function09, null, z5, null, null, ComposableSingletons$DatePickerKt.INSTANCE.m2075getLambda3$material3_release(), composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 26);
                            IconButtonKt.IconButton(function010, null, z6, null, null, ComposableSingletons$DatePickerKt.INSTANCE.m2076getLambda4$material3_release(), composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 26);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), startRestartGroup, ProvidedValue.$stable | 48);
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
            final DatePickerColors datePickerColors3 = datePickerColors2;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$MonthsNavigation$2
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
                    DatePickerKt.MonthsNavigation(Modifier.this, z, z2, z3, str, function0, function02, function03, datePickerColors3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void YearPickerMenuButton(final Function0<Unit> function0, final boolean z, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        Modifier modifier2;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(409654418);
        ComposerKt.sourceInformation(startRestartGroup, "C(YearPickerMenuButton)P(3,1,2)2198@94691L7,2198@94641L58,2194@94512L665:DatePicker.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else if ((i & 6) == 0) {
            function02 = function0;
            i3 = (startRestartGroup.changedInstance(function02) ? 4 : 2) | i;
        } else {
            function02 = function0;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            if ((i2 & 8) == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                i3 |= startRestartGroup.changedInstance(function2) ? 2048 : 1024;
            }
            if ((i3 & 1171) == 1170 || !startRestartGroup.getSkipping()) {
                Modifier modifier3 = i4 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(409654418, i3, -1, "androidx.compose.material3.YearPickerMenuButton (DatePicker.kt:2193)");
                }
                RoundedCornerShape circleShape = RoundedCornerShapeKt.getCircleShape();
                ButtonDefaults buttonDefaults = ButtonDefaults.INSTANCE;
                ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume = startRestartGroup.consume(localContentColor);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                modifier2 = modifier3;
                ButtonKt.TextButton(function02, modifier2, false, circleShape, buttonDefaults.m1934textButtonColorsro_MJ88(0L, ((Color) consume).m4073unboximpl(), 0L, 0L, startRestartGroup, 24576, 13), null, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1899012021, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$YearPickerMenuButton$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                        invoke(rowScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RowScope rowScope, Composer composer2, int i5) {
                        String m2623getStringNWtq28;
                        ComposerKt.sourceInformation(composer2, "C2202@94766L9,2203@94784L49,2204@94842L329:DatePicker.kt#uh7d8r");
                        if ((i5 & 17) != 16 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1899012021, i5, -1, "androidx.compose.material3.YearPickerMenuButton.<anonymous> (DatePicker.kt:2202)");
                            }
                            function2.invoke(composer2, 0);
                            SpacerKt.Spacer(SizeKt.m928size3ABfNKs(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m1930getIconSpacingD9Ej5fM()), composer2, 6);
                            ImageVector arrowDropDown = ArrowDropDownKt.getArrowDropDown(Icons.Filled.INSTANCE);
                            if (z) {
                                composer2.startReplaceableGroup(1071201785);
                                ComposerKt.sourceInformation(composer2, "2207@94953L49");
                                Strings.Companion companion = Strings.INSTANCE;
                                m2623getStringNWtq28 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_date_picker_switch_to_day_selection), composer2, 0);
                                composer2.endReplaceableGroup();
                            } else {
                                composer2.startReplaceableGroup(1071201872);
                                ComposerKt.sourceInformation(composer2, "2209@95040L50");
                                Strings.Companion companion2 = Strings.INSTANCE;
                                m2623getStringNWtq28 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_date_picker_switch_to_year_selection), composer2, 0);
                                composer2.endReplaceableGroup();
                            }
                            IconKt.m2254Iconww6aTOc(arrowDropDown, m2623getStringNWtq28, RotateKt.rotate(Modifier.INSTANCE, z ? 180.0f : 0.0f), 0L, composer2, 0, 8);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), startRestartGroup, (i3 & 14) | 807075840 | ((i3 >> 3) & 112), 388);
                startRestartGroup = startRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                startRestartGroup.skipToGroupEnd();
            }
            final Modifier modifier4 = modifier2;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$YearPickerMenuButton$2
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
                        DatePickerKt.YearPickerMenuButton(function0, z, modifier4, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        modifier2 = modifier;
        if ((i2 & 8) == 0) {
        }
        if ((i3 & 1171) == 1170) {
        }
        if (i4 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        RoundedCornerShape circleShape2 = RoundedCornerShapeKt.getCircleShape();
        ButtonDefaults buttonDefaults2 = ButtonDefaults.INSTANCE;
        ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2 = startRestartGroup.consume(localContentColor2);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        modifier2 = modifier3;
        ButtonKt.TextButton(function02, modifier2, false, circleShape2, buttonDefaults2.m1934textButtonColorsro_MJ88(0L, ((Color) consume2).m4073unboximpl(), 0L, 0L, startRestartGroup, 24576, 13), null, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1899012021, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$YearPickerMenuButton$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                invoke(rowScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(RowScope rowScope, Composer composer2, int i5) {
                String m2623getStringNWtq28;
                ComposerKt.sourceInformation(composer2, "C2202@94766L9,2203@94784L49,2204@94842L329:DatePicker.kt#uh7d8r");
                if ((i5 & 17) != 16 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1899012021, i5, -1, "androidx.compose.material3.YearPickerMenuButton.<anonymous> (DatePicker.kt:2202)");
                    }
                    function2.invoke(composer2, 0);
                    SpacerKt.Spacer(SizeKt.m928size3ABfNKs(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m1930getIconSpacingD9Ej5fM()), composer2, 6);
                    ImageVector arrowDropDown = ArrowDropDownKt.getArrowDropDown(Icons.Filled.INSTANCE);
                    if (z) {
                        composer2.startReplaceableGroup(1071201785);
                        ComposerKt.sourceInformation(composer2, "2207@94953L49");
                        Strings.Companion companion = Strings.INSTANCE;
                        m2623getStringNWtq28 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_date_picker_switch_to_day_selection), composer2, 0);
                        composer2.endReplaceableGroup();
                    } else {
                        composer2.startReplaceableGroup(1071201872);
                        ComposerKt.sourceInformation(composer2, "2209@95040L50");
                        Strings.Companion companion2 = Strings.INSTANCE;
                        m2623getStringNWtq28 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_date_picker_switch_to_year_selection), composer2, 0);
                        composer2.endReplaceableGroup();
                    }
                    IconKt.m2254Iconww6aTOc(arrowDropDown, m2623getStringNWtq28, RotateKt.rotate(Modifier.INSTANCE, z ? 180.0f : 0.0f), 0L, composer2, 0, 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), startRestartGroup, (i3 & 14) | 807075840 | ((i3 >> 3) & 112), 388);
        startRestartGroup = startRestartGroup;
        if (ComposerKt.isTraceInProgress()) {
        }
        final Modifier modifier42 = modifier2;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<CustomAccessibilityAction> customScrollActions(final LazyGridState lazyGridState, final CoroutineScope coroutineScope, String str, String str2) {
        return CollectionsKt.listOf((Object[]) new CustomAccessibilityAction[]{new CustomAccessibilityAction(str, new Function0<Boolean>() { // from class: androidx.compose.material3.DatePickerKt$customScrollActions$scrollUpAction$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                boolean z;
                if (LazyGridState.this.getCanScrollBackward()) {
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(LazyGridState.this, null), 3, null);
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }

            /* compiled from: DatePicker.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material3.DatePickerKt$customScrollActions$scrollUpAction$1$1", f = "DatePicker.kt", i = {}, l = {2228}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.material3.DatePickerKt$customScrollActions$scrollUpAction$1$1, reason: invalid class name */
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ LazyGridState $state;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(LazyGridState lazyGridState, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$state = lazyGridState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$state, continuation);
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
                        LazyGridState lazyGridState = this.$state;
                        this.label = 1;
                        if (LazyGridState.scrollToItem$default(lazyGridState, lazyGridState.getFirstVisibleItemIndex() - 3, 0, this, 2, null) == coroutine_suspended) {
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
        }), new CustomAccessibilityAction(str2, new Function0<Boolean>() { // from class: androidx.compose.material3.DatePickerKt$customScrollActions$scrollDownAction$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                boolean z;
                if (LazyGridState.this.getCanScrollForward()) {
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(LazyGridState.this, null), 3, null);
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }

            /* compiled from: DatePicker.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material3.DatePickerKt$customScrollActions$scrollDownAction$1$1", f = "DatePicker.kt", i = {}, l = {2238}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.material3.DatePickerKt$customScrollActions$scrollDownAction$1$1, reason: invalid class name */
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ LazyGridState $state;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(LazyGridState lazyGridState, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$state = lazyGridState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$state, continuation);
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
                        LazyGridState lazyGridState = this.$state;
                        this.label = 1;
                        if (LazyGridState.scrollToItem$default(lazyGridState, lazyGridState.getFirstVisibleItemIndex() + 3, 0, this, 2, null) == coroutine_suspended) {
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
        })});
    }

    public static final float getRecommendedSizeForAccessibility() {
        return RecommendedSizeForAccessibility;
    }

    public static final float getMonthYearHeight() {
        return MonthYearHeight;
    }

    public static final float getDatePickerHorizontalPadding() {
        return DatePickerHorizontalPadding;
    }

    public static final PaddingValues getDatePickerModeTogglePadding() {
        return DatePickerModeTogglePadding;
    }

    static {
        float f = 12;
        DatePickerHorizontalPadding = Dp.m6389constructorimpl(f);
        DatePickerModeTogglePadding = PaddingKt.m876PaddingValuesa9UjIt4$default(0.0f, 0.0f, Dp.m6389constructorimpl(f), Dp.m6389constructorimpl(f), 3, null);
        float f2 = 24;
        float f3 = 16;
        DatePickerTitlePadding = PaddingKt.m876PaddingValuesa9UjIt4$default(Dp.m6389constructorimpl(f2), Dp.m6389constructorimpl(f3), Dp.m6389constructorimpl(f), 0.0f, 8, null);
        DatePickerHeadlinePadding = PaddingKt.m876PaddingValuesa9UjIt4$default(Dp.m6389constructorimpl(f2), 0.0f, Dp.m6389constructorimpl(f), Dp.m6389constructorimpl(f), 2, null);
        YearsVerticalPadding = Dp.m6389constructorimpl(f3);
    }
}
