package androidx.compose.ui.platform;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.SystemClock;
import android.os.Trace;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.translation.ViewTranslationCallback;
import android.view.translation.ViewTranslationRequest;
import android.view.translation.ViewTranslationResponse;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.SessionMutex;
import androidx.compose.ui.autofill.AndroidAutofill;
import androidx.compose.ui.autofill.AndroidAutofill_androidKt;
import androidx.compose.ui.autofill.Autofill;
import androidx.compose.ui.autofill.AutofillCallback;
import androidx.compose.ui.autofill.AutofillTree;
import androidx.compose.ui.draganddrop.ComposeDragShadowBuilder;
import androidx.compose.ui.draganddrop.DragAndDropManager;
import androidx.compose.ui.draganddrop.DragAndDropTransferData;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.focus.FocusTransactionManager;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import androidx.compose.ui.input.InputMode;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.input.InputModeManagerImpl;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.MotionEventAdapter;
import androidx.compose.ui.input.pointer.PointerIcon;
import androidx.compose.ui.input.pointer.PointerIconService;
import androidx.compose.ui.input.pointer.PointerInputEvent;
import androidx.compose.ui.input.pointer.PointerInputEventData;
import androidx.compose.ui.input.pointer.PointerInputEventProcessor;
import androidx.compose.ui.input.pointer.PointerInputEventProcessorKt;
import androidx.compose.ui.input.pointer.PointerKeyboardModifiers;
import androidx.compose.ui.input.pointer.PositionCalculator;
import androidx.compose.ui.input.pointer.ProcessResult;
import androidx.compose.ui.input.rotary.RotaryInputModifierKt;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.PlaceableKt;
import androidx.compose.ui.layout.RootMeasurePolicy;
import androidx.compose.ui.modifier.ModifierLocalManager;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.MeasureAndLayoutDelegate;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.OwnerSnapshotObserver;
import androidx.compose.ui.node.RootForTest;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.semantics.EmptySemanticsElement;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyResolver_androidKt;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputServiceAndroid;
import androidx.compose.ui.unit.AndroidDensity_androidKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.ironsource.C3040d4;
import com.ironsource.C3337ue;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AndroidComposeView.android.kt */
@Metadata(d1 = {"\u0000Ê\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\f*\u0002\u00ad\u0001\b\u0000\u0018\u0000 Ê\u00032\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0006É\u0003Ê\u0003Ë\u0003B\u0015\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001b\u0010\u0080\u0002\u001a\u0002062\b\u0010ç\u0001\u001a\u00030\u0081\u00022\b\u0010\u0082\u0002\u001a\u00030°\u0001J&\u0010\u0083\u0002\u001a\u0002062\u0007\u0010\u0084\u0002\u001a\u00020>2\b\u0010\u0085\u0002\u001a\u00030\u0086\u00022\b\u0010\u0087\u0002\u001a\u00030\u0088\u0002H\u0002J\u0019\u0010#\u001a\u0002062\u000f\u0010\u0089\u0002\u001a\n\u0012\u0005\u0012\u00030\u008b\u00020\u008a\u0002H\u0016J\t\u0010\u008c\u0002\u001a\u00020aH\u0002J\u0010\u0010\u008d\u0002\u001a\u000206H\u0086@¢\u0006\u0003\u0010\u008e\u0002J\u001e\u0010\u008f\u0002\u001a\u00020z2\u0007\u0010\u0090\u0002\u001a\u00020zH\u0016ø\u0001\u0000¢\u0006\u0006\b\u0091\u0002\u0010\u0092\u0002J\u001e\u0010\u0093\u0002\u001a\u00020z2\u0007\u0010\u0094\u0002\u001a\u00020zH\u0016ø\u0001\u0000¢\u0006\u0006\b\u0095\u0002\u0010\u0092\u0002J\u0012\u0010\u0096\u0002\u001a\u00020a2\u0007\u0010\u0097\u0002\u001a\u00020>H\u0016J\u0012\u0010\u0098\u0002\u001a\u00020a2\u0007\u0010\u0097\u0002\u001a\u00020>H\u0016J\u0012\u0010\u0099\u0002\u001a\u0002062\u0007\u0010\u009a\u0002\u001a\u00020\u0001H\u0002J\"\u0010\u009b\u0002\u001a\u00030\u009c\u00022\u0007\u0010\u009d\u0002\u001a\u00020>H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u009e\u0002\u0010\u009f\u0002J.\u0010 \u0002\u001a\u00020E2\u0014\u0010¡\u0002\u001a\u000f\u0012\u0005\u0012\u00030¢\u0002\u0012\u0004\u0012\u000206042\r\u0010£\u0002\u001a\b\u0012\u0004\u0012\u0002060NH\u0016J\u0013\u0010¤\u0002\u001a\u0002062\b\u0010¥\u0002\u001a\u00030¦\u0002H\u0014J\u0013\u0010§\u0002\u001a\u00020a2\b\u0010¨\u0002\u001a\u00030©\u0001H\u0016J\u0013\u0010©\u0002\u001a\u00020a2\b\u0010¨\u0002\u001a\u00030©\u0001H\u0016J\u0013\u0010ª\u0002\u001a\u00020a2\b\u0010¨\u0002\u001a\u00030«\u0002H\u0016J\u0013\u0010¬\u0002\u001a\u00020a2\b\u0010¨\u0002\u001a\u00030«\u0002H\u0016J\u0013\u0010\u00ad\u0002\u001a\u00020a2\b\u0010®\u0002\u001a\u00030©\u0001H\u0016J\u001b\u0010¯\u0002\u001a\u0002062\b\u0010ç\u0001\u001a\u00030\u0081\u00022\b\u0010¥\u0002\u001a\u00030¦\u0002J\u001f\u0010°\u0002\u001a\u0005\u0018\u00010è\u00012\u0007\u0010±\u0002\u001a\u00020>2\b\u0010²\u0002\u001a\u00030è\u0001H\u0002J\u0013\u0010³\u0002\u001a\u0005\u0018\u00010è\u00012\u0007\u0010±\u0002\u001a\u00020>J\u001c\u0010´\u0002\u001a\u0002062\b\u0010\u0082\u0002\u001a\u00030°\u00012\u0007\u0010µ\u0002\u001a\u00020aH\u0016J\"\u0010¶\u0002\u001a\u0005\u0018\u00010·\u00022\b\u0010¸\u0002\u001a\u00030¹\u0002H\u0016ø\u0001\u0000¢\u0006\u0006\bº\u0002\u0010»\u0002J\u0013\u0010¼\u0002\u001a\u0002062\b\u0010½\u0002\u001a\u00030¾\u0002H\u0016J#\u0010¿\u0002\u001a\u00030À\u00022\b\u0010®\u0002\u001a\u00030©\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bÁ\u0002\u0010Â\u0002J\u0013\u0010Ã\u0002\u001a\u00020a2\b\u0010¨\u0002\u001a\u00030©\u0001H\u0002J\u001d\u0010Ä\u0002\u001a\u00020a2\b\u0010¨\u0002\u001a\u00030©\u00012\b\u0010Å\u0002\u001a\u00030©\u0001H\u0002J\t\u0010Æ\u0002\u001a\u000206H\u0016J\u0013\u0010Ç\u0002\u001a\u0002062\b\u0010È\u0002\u001a\u00030°\u0001H\u0002J\u0013\u0010É\u0002\u001a\u0002062\b\u0010È\u0002\u001a\u00030°\u0001H\u0002J\u0013\u0010Ê\u0002\u001a\u00020a2\b\u0010¨\u0002\u001a\u00030©\u0001H\u0002J\u0013\u0010Ë\u0002\u001a\u00020a2\b\u0010¨\u0002\u001a\u00030©\u0001H\u0002J\u0013\u0010Ì\u0002\u001a\u00020a2\b\u0010®\u0002\u001a\u00030©\u0001H\u0002J\u0013\u0010Í\u0002\u001a\u00020a2\b\u0010¨\u0002\u001a\u00030©\u0001H\u0002J\u001e\u0010Î\u0002\u001a\u00020z2\u0007\u0010\u0094\u0002\u001a\u00020zH\u0016ø\u0001\u0000¢\u0006\u0006\bÏ\u0002\u0010\u0092\u0002J\u001f\u0010Î\u0002\u001a\u0002062\b\u0010Ð\u0002\u001a\u00030á\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bÑ\u0002\u0010Ò\u0002J)\u0010Ó\u0002\u001a\u0002062\b\u0010\u0082\u0002\u001a\u00030°\u00012\b\u0010Ô\u0002\u001a\u00030\u009b\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bÕ\u0002\u0010Ö\u0002J\u0012\u0010Ó\u0002\u001a\u0002062\u0007\u0010×\u0002\u001a\u00020aH\u0016J\t\u0010Ø\u0002\u001a\u000206H\u0016J!\u0010Ù\u0002\u001a\u0002062\u0007\u0010Ú\u0002\u001a\u00020E2\u0007\u0010Û\u0002\u001a\u00020aH\u0000¢\u0006\u0003\bÜ\u0002J\u0013\u0010Ý\u0002\u001a\u0002062\b\u0010È\u0002\u001a\u00030°\u0001H\u0016J\t\u0010Þ\u0002\u001a\u000206H\u0014J\t\u0010ß\u0002\u001a\u00020aH\u0016J\u0012\u0010à\u0002\u001a\u0002062\u0007\u0010á\u0002\u001a\u000205H\u0014J\u0016\u0010â\u0002\u001a\u0005\u0018\u00010ã\u00022\b\u0010ä\u0002\u001a\u00030å\u0002H\u0016J0\u0010æ\u0002\u001a\u0002062\b\u0010ç\u0002\u001a\u00030è\u00022\b\u0010é\u0002\u001a\u00030ä\u00012\u0011\u0010ê\u0002\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010ì\u00020ë\u0002H\u0017J\u0013\u0010í\u0002\u001a\u0002062\b\u0010È\u0002\u001a\u00030°\u0001H\u0016J\t\u0010î\u0002\u001a\u000206H\u0014J\u0013\u0010ï\u0002\u001a\u0002062\b\u0010¥\u0002\u001a\u00030¦\u0002H\u0014J\t\u0010ð\u0002\u001a\u000206H\u0016J'\u0010ñ\u0002\u001a\u0002062\u0007\u0010ò\u0002\u001a\u00020a2\u0007\u0010\u0097\u0002\u001a\u00020>2\n\u0010ó\u0002\u001a\u0005\u0018\u00010¾\u0002H\u0014J6\u0010ô\u0002\u001a\u0002062\u0007\u0010õ\u0002\u001a\u00020a2\u0007\u0010ö\u0002\u001a\u00020>2\u0007\u0010÷\u0002\u001a\u00020>2\u0007\u0010ø\u0002\u001a\u00020>2\u0007\u0010ù\u0002\u001a\u00020>H\u0014J\u0013\u0010ú\u0002\u001a\u0002062\b\u0010\u0082\u0002\u001a\u00030°\u0001H\u0016J\u001b\u0010û\u0002\u001a\u0002062\u0007\u0010ü\u0002\u001a\u00020>2\u0007\u0010ý\u0002\u001a\u00020>H\u0014J\u001e\u0010þ\u0002\u001a\u0002062\n\u0010ÿ\u0002\u001a\u0005\u0018\u00010\u0080\u00032\u0007\u0010\u0081\u0003\u001a\u00020>H\u0016J.\u0010\u0082\u0003\u001a\u0002062\b\u0010\u0082\u0002\u001a\u00030°\u00012\u0007\u0010µ\u0002\u001a\u00020a2\u0007\u0010\u0083\u0003\u001a\u00020a2\u0007\u0010\u0084\u0003\u001a\u00020aH\u0016J%\u0010\u0085\u0003\u001a\u0002062\b\u0010\u0082\u0002\u001a\u00030°\u00012\u0007\u0010µ\u0002\u001a\u00020a2\u0007\u0010\u0083\u0003\u001a\u00020aH\u0016J\u0013\u0010\u0086\u0003\u001a\u0002062\b\u0010\u0087\u0003\u001a\u00030\u0088\u0003H\u0016J\u0012\u0010\u0089\u0003\u001a\u0002062\u0007\u0010\u0085\u0001\u001a\u00020>H\u0016J\t\u0010\u008a\u0003\u001a\u000206H\u0016J\u001c\u0010\u008b\u0003\u001a\u0002062\u0011\u0010\u008c\u0003\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u008e\u00030\u008d\u0003H\u0017J\u0012\u0010\u008f\u0003\u001a\u0002062\u0007\u0010\u0090\u0003\u001a\u00020aH\u0016J+\u0010\u0091\u0003\u001a\u00030\u009c\u00022\u0007\u0010\u0092\u0003\u001a\u00020>2\u0007\u0010ù\u0002\u001a\u00020>H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0093\u0003\u0010\u0094\u0003J\t\u0010\u0095\u0003\u001a\u000206H\u0002J\u0013\u0010\u0095\u0003\u001a\u0002062\b\u0010®\u0002\u001a\u00030©\u0001H\u0002J\t\u0010\u0096\u0003\u001a\u000206H\u0002J\u0018\u0010\u0097\u0003\u001a\u00020a2\u0007\u0010Ú\u0002\u001a\u00020EH\u0000¢\u0006\u0003\b\u0098\u0003J\u0018\u0010\u0099\u0003\u001a\u0002062\r\u0010\u009a\u0003\u001a\b\u0012\u0004\u0012\u0002060NH\u0016J\u0013\u0010\u009b\u0003\u001a\u0002062\b\u0010\u009a\u0003\u001a\u00030\u009c\u0003H\u0016J\u0011\u0010\u009d\u0003\u001a\u0002062\b\u0010ç\u0001\u001a\u00030\u0081\u0002J\u0007\u0010\u009e\u0003\u001a\u000206J\u0013\u0010\u009f\u0003\u001a\u0002062\b\u0010\u0082\u0002\u001a\u00030°\u0001H\u0016J\u0017\u0010\u0084\u0003\u001a\u0002062\f\b\u0002\u0010 \u0003\u001a\u0005\u0018\u00010°\u0001H\u0002J\u001e\u0010¡\u0003\u001a\u00020z2\u0007\u0010¢\u0003\u001a\u00020zH\u0016ø\u0001\u0000¢\u0006\u0006\b£\u0003\u0010\u0092\u0002J\u001f\u0010¤\u0003\u001a\u00020a2\b\u0010¸\u0002\u001a\u00030¹\u0002H\u0016ø\u0001\u0000¢\u0006\u0006\b¥\u0003\u0010¦\u0003J#\u0010§\u0003\u001a\u00030À\u00022\b\u0010®\u0002\u001a\u00030©\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b¨\u0003\u0010Â\u0002J0\u0010©\u0003\u001a\u0002062\b\u0010®\u0002\u001a\u00030©\u00012\u0007\u0010ª\u0003\u001a\u00020>2\u0007\u0010«\u0003\u001a\u00020|2\t\b\u0002\u0010¬\u0003\u001a\u00020aH\u0002J\u001c\u0010\u00ad\u0003\u001a\u0002062\u0013\u0010®\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020604J\t\u0010¯\u0003\u001a\u00020aH\u0016JE\u0010°\u0003\u001a\u00020a2\b\u0010±\u0003\u001a\u00030²\u00032\b\u0010³\u0003\u001a\u00030´\u00032\u001a\u0010µ\u0003\u001a\u0015\u0012\u0005\u0012\u00030¶\u0003\u0012\u0004\u0012\u00020604¢\u0006\u0003\b·\u0003H\u0002ø\u0001\u0000¢\u0006\u0006\b¸\u0003\u0010¹\u0003JA\u0010º\u0003\u001a\u00030»\u00032.\u0010¼\u0003\u001a)\b\u0001\u0012\u0005\u0012\u00030¾\u0003\u0012\f\u0012\n\u0012\u0005\u0012\u00030»\u00030¿\u0003\u0012\u0007\u0012\u0005\u0018\u00010À\u00030½\u0003¢\u0006\u0003\b·\u0003H\u0096@¢\u0006\u0003\u0010Á\u0003J\t\u0010Â\u0003\u001a\u000206H\u0002J\u000e\u0010Ã\u0003\u001a\u00020a*\u00030°\u0001H\u0002J\u001b\u0010Ä\u0003\u001a\u00020>*\u00030\u009c\u0002H\u0082\nø\u0001\u0000¢\u0006\u0006\bÅ\u0003\u0010Æ\u0003J\u001b\u0010Ç\u0003\u001a\u00020>*\u00030\u009c\u0002H\u0082\nø\u0001\u0000¢\u0006\u0006\bÈ\u0003\u0010Æ\u0003R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u00128B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u001dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0016\u0010#\u001a\u0004\u0018\u00010$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020(X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\u00020.X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R&\u00103\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020604X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u000e\u0010=\u001a\u00020>X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010@\u001a\u00020?2\u0006\u0010\u0011\u001a\u00020?@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0014\u0010C\u001a\b\u0012\u0004\u0012\u00020E0DX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010F\u001a\u00020GX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u000e\u0010J\u001a\u00020KX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010L\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u000206\u0018\u00010N0MX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010O\u001a\u00020PX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR+\u0010T\u001a\u00020S2\u0006\u0010\u0011\u001a\u00020S8V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bY\u0010\u0019\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001c\u0010Z\u001a\u00020[8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\\\u0010]\u001a\u0004\b^\u0010_R\u000e\u0010`\u001a\u00020aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010d\u001a\u00020eX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010fR\u0014\u0010g\u001a\u00020hX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bi\u0010jR\u0014\u0010k\u001a\u00020a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bl\u0010mR\u000e\u0010n\u001a\u00020aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010o\u001a\u00020p8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bq\u0010rR\u000e\u0010s\u001a\u00020aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010t\u001a\u00020a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bt\u0010mR\u000e\u0010u\u001a\u00020aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010v\u001a\u00020wX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010x\u001a\u00020aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010y\u001a\u00020zX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010fR&\u0010{\u001a\u00020|8\u0000@\u0000X\u0081\u000e¢\u0006\u0016\n\u0000\u0012\u0004\b}\u0010]\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0016\u0010\u0082\u0001\u001a\t\u0012\u0004\u0012\u00020E0\u0083\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R3\u0010\u0085\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u0011\u001a\u00030\u0084\u00018V@RX\u0096\u008e\u0002¢\u0006\u0017\n\u0005\b\u008a\u0001\u0010\u0019\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0010\u0010\u008b\u0001\u001a\u00030\u008c\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u008d\u0001\u001a\u00030\u008e\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u008f\u0001\u001a\u00030\u0090\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0091\u0001\u001a\u00020|8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0092\u0001\u0010\u007fR\u0018\u0010\u0093\u0001\u001a\u00030\u0094\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001R\u0010\u0010\u0097\u0001\u001a\u00030\u0098\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0099\u0001\u001a\u00020aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u009b\u0001X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u001d\u0010\u009c\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u000206\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u009d\u0001\u001a\u00030\u009e\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u009f\u0001\u0010 \u0001R\u0018\u0010¡\u0001\u001a\u00030¢\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b£\u0001\u0010¤\u0001R\u0010\u0010¥\u0001\u001a\u00030¦\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010§\u0001\u001a\n\u0012\u0004\u0012\u00020E\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010¨\u0001\u001a\u0005\u0018\u00010©\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010ª\u0001\u001a\u00020|X\u0082\u000e¢\u0006\u0002\n\u0000R\u0015\u0010«\u0001\u001a\b\u0012\u0004\u0012\u0002060NX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010¬\u0001\u001a\u00030\u00ad\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010®\u0001R\u0018\u0010¯\u0001\u001a\u00030°\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b±\u0001\u0010²\u0001R\u0018\u0010³\u0001\u001a\u00030´\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bµ\u0001\u0010¶\u0001R\u000f\u0010·\u0001\u001a\u00020wX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010¸\u0001\u001a\u00030¹\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010º\u0001\u001a\u00030»\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010¼\u0001\u001a\u00030½\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b¾\u0001\u0010¿\u0001R\u0010\u0010À\u0001\u001a\u00030Á\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010Â\u0001\u001a\u00030Ã\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bÄ\u0001\u0010Å\u0001R%\u0010Æ\u0001\u001a\u00020aX\u0096\u000e¢\u0006\u0018\n\u0000\u0012\u0005\bÇ\u0001\u0010]\u001a\u0005\bÈ\u0001\u0010m\"\u0006\bÉ\u0001\u0010Ê\u0001R\u0018\u0010Ë\u0001\u001a\u00030Ì\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bÍ\u0001\u0010Î\u0001R\u0018\u0010Ï\u0001\u001a\u00030Ð\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bÑ\u0001\u0010Ò\u0001R\u000f\u0010Ó\u0001\u001a\u00020aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010Ô\u0001\u001a\u00030Õ\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bÖ\u0001\u0010×\u0001R \u0010Ø\u0001\u001a\n\u0012\u0005\u0012\u00030Ú\u00010Ù\u0001X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\n\u0003\u0010Û\u0001R\u0018\u0010Ü\u0001\u001a\u00030Ý\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bÞ\u0001\u0010ß\u0001R\u0019\u0010à\u0001\u001a\u00030á\u0001X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\n\u0003\u0010â\u0001R\u0010\u0010ã\u0001\u001a\u00030ä\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010å\u0001\u001a\u00030æ\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010ç\u0001\u001a\u00030è\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bé\u0001\u0010ê\u0001R\u0018\u0010ë\u0001\u001a\u00030ì\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bí\u0001\u0010î\u0001R\u0012\u0010ï\u0001\u001a\u0005\u0018\u00010ð\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010ñ\u0001\u001a\u00030á\u0001X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\n\u0003\u0010â\u0001R!\u0010ò\u0001\u001a\u0004\u0018\u00010\u00128FX\u0086\u0084\u0002¢\u0006\u000f\n\u0006\bô\u0001\u0010õ\u0001\u001a\u0005\bó\u0001\u0010\u0015R\u000f\u0010ö\u0001\u001a\u00020aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010÷\u0001\u001a\u00030ø\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bù\u0001\u0010ú\u0001R\u0017\u0010û\u0001\u001a\u00020zX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010fR\u0019\u0010ü\u0001\u001a\u00030á\u0001X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\n\u0003\u0010â\u0001R\u001b\u0010ý\u0001\u001a\u00020>*\u0002058BX\u0082\u0004¢\u0006\b\u001a\u0006\bþ\u0001\u0010ÿ\u0001\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Ì\u0003"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeView;", "Landroid/view/ViewGroup;", "Landroidx/compose/ui/node/Owner;", "Landroidx/compose/ui/platform/ViewRootForTest;", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "context", "Landroid/content/Context;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroid/content/Context;Lkotlin/coroutines/CoroutineContext;)V", "_androidViewsHandler", "Landroidx/compose/ui/platform/AndroidViewsHandler;", "_autofill", "Landroidx/compose/ui/autofill/AndroidAutofill;", "_inputModeManager", "Landroidx/compose/ui/input/InputModeManagerImpl;", "<set-?>", "Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "_viewTreeOwners", "get_viewTreeOwners", "()Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "set_viewTreeOwners", "(Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;)V", "_viewTreeOwners$delegate", "Landroidx/compose/runtime/MutableState;", "_windowInfo", "Landroidx/compose/ui/platform/WindowInfoImpl;", "accessibilityManager", "Landroidx/compose/ui/platform/AndroidAccessibilityManager;", "getAccessibilityManager", "()Landroidx/compose/ui/platform/AndroidAccessibilityManager;", "androidViewsHandler", "getAndroidViewsHandler$ui_release", "()Landroidx/compose/ui/platform/AndroidViewsHandler;", "autofill", "Landroidx/compose/ui/autofill/Autofill;", "getAutofill", "()Landroidx/compose/ui/autofill/Autofill;", "autofillTree", "Landroidx/compose/ui/autofill/AutofillTree;", "getAutofillTree", "()Landroidx/compose/ui/autofill/AutofillTree;", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "clipboardManager", "Landroidx/compose/ui/platform/AndroidClipboardManager;", "getClipboardManager", "()Landroidx/compose/ui/platform/AndroidClipboardManager;", "composeAccessibilityDelegate", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;", "configurationChangeObserver", "Lkotlin/Function1;", "Landroid/content/res/Configuration;", "", "getConfigurationChangeObserver", "()Lkotlin/jvm/functions/Function1;", "setConfigurationChangeObserver", "(Lkotlin/jvm/functions/Function1;)V", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "currentFontWeightAdjustment", "", "Landroidx/compose/ui/unit/Density;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "dirtyLayers", "", "Landroidx/compose/ui/node/OwnedLayer;", "dragAndDropManager", "Landroidx/compose/ui/draganddrop/DragAndDropManager;", "getDragAndDropManager", "()Landroidx/compose/ui/draganddrop/DragAndDropManager;", "dragAndDropModifierOnDragListener", "Landroidx/compose/ui/platform/DragAndDropModifierOnDragListener;", "endApplyChangesListeners", "Landroidx/compose/runtime/collection/MutableVector;", "Lkotlin/Function0;", "focusOwner", "Landroidx/compose/ui/focus/FocusOwner;", "getFocusOwner", "()Landroidx/compose/ui/focus/FocusOwner;", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "fontFamilyResolver", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "setFontFamilyResolver", "(Landroidx/compose/ui/text/font/FontFamily$Resolver;)V", "fontFamilyResolver$delegate", "fontLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "getFontLoader$annotations", "()V", "getFontLoader", "()Landroidx/compose/ui/text/font/Font$ResourceLoader;", "forceUseMatrixCache", "", "globalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "globalPosition", "Landroidx/compose/ui/unit/IntOffset;", "J", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "hasPendingMeasureOrLayout", "getHasPendingMeasureOrLayout", "()Z", "hoverExitReceived", "inputModeManager", "Landroidx/compose/ui/input/InputModeManager;", "getInputModeManager", "()Landroidx/compose/ui/input/InputModeManager;", "isDrawingContent", "isLifecycleInResumedState", "isRenderNodeCompatible", "keyInputModifier", "Landroidx/compose/ui/Modifier;", "keyboardModifiersRequireUpdate", "lastDownPointerPosition", "Landroidx/compose/ui/geometry/Offset;", "lastMatrixRecalculationAnimationTime", "", "getLastMatrixRecalculationAnimationTime$ui_release$annotations", "getLastMatrixRecalculationAnimationTime$ui_release", "()J", "setLastMatrixRecalculationAnimationTime$ui_release", "(J)V", "layerCache", "Landroidx/compose/ui/platform/WeakCache;", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "layoutDirection$delegate", "legacyTextInputServiceAndroid", "Landroidx/compose/ui/text/input/TextInputServiceAndroid;", "matrixToWindow", "Landroidx/compose/ui/platform/CalculateMatrixToWindow;", "measureAndLayoutDelegate", "Landroidx/compose/ui/node/MeasureAndLayoutDelegate;", "measureIteration", "getMeasureIteration", "modifierLocalManager", "Landroidx/compose/ui/modifier/ModifierLocalManager;", "getModifierLocalManager", "()Landroidx/compose/ui/modifier/ModifierLocalManager;", "motionEventAdapter", "Landroidx/compose/ui/input/pointer/MotionEventAdapter;", "observationClearRequested", "onMeasureConstraints", "Landroidx/compose/ui/unit/Constraints;", "onViewTreeOwnersAvailable", "placementScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getPlacementScope", "()Landroidx/compose/ui/layout/Placeable$PlacementScope;", "pointerIconService", "Landroidx/compose/ui/input/pointer/PointerIconService;", "getPointerIconService", "()Landroidx/compose/ui/input/pointer/PointerIconService;", "pointerInputEventProcessor", "Landroidx/compose/ui/input/pointer/PointerInputEventProcessor;", "postponedDirtyLayers", "previousMotionEvent", "Landroid/view/MotionEvent;", "relayoutTime", "resendMotionEventOnLayout", "resendMotionEventRunnable", "androidx/compose/ui/platform/AndroidComposeView$resendMotionEventRunnable$1", "Landroidx/compose/ui/platform/AndroidComposeView$resendMotionEventRunnable$1;", "root", "Landroidx/compose/ui/node/LayoutNode;", "getRoot", "()Landroidx/compose/ui/node/LayoutNode;", "rootForTest", "Landroidx/compose/ui/node/RootForTest;", "getRootForTest", "()Landroidx/compose/ui/node/RootForTest;", "rotaryInputModifier", "scrollChangedListener", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "semanticsModifier", "Landroidx/compose/ui/semantics/EmptySemanticsElement;", "semanticsOwner", "Landroidx/compose/ui/semantics/SemanticsOwner;", "getSemanticsOwner", "()Landroidx/compose/ui/semantics/SemanticsOwner;", "sendHoverExitEvent", "Ljava/lang/Runnable;", "sharedDrawScope", "Landroidx/compose/ui/node/LayoutNodeDrawScope;", "getSharedDrawScope", "()Landroidx/compose/ui/node/LayoutNodeDrawScope;", "showLayoutBounds", "getShowLayoutBounds$annotations", "getShowLayoutBounds", "setShowLayoutBounds", "(Z)V", "snapshotObserver", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "softwareKeyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "getSoftwareKeyboardController", "()Landroidx/compose/ui/platform/SoftwareKeyboardController;", "superclassInitComplete", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "getTextInputService", "()Landroidx/compose/ui/text/input/TextInputService;", "textInputSessionMutex", "Landroidx/compose/ui/SessionMutex;", "Landroidx/compose/ui/platform/AndroidPlatformTextInputSession;", "Ljava/util/concurrent/atomic/AtomicReference;", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "tmpMatrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "tmpPositionArray", "", "touchModeChangeListener", "Landroid/view/ViewTreeObserver$OnTouchModeChangeListener;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Landroid/view/View;", "getView", "()Landroid/view/View;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "viewLayersContainer", "Landroidx/compose/ui/platform/DrawChildContainer;", "viewToWindowMatrix", "viewTreeOwners", "getViewTreeOwners", "viewTreeOwners$delegate", "Landroidx/compose/runtime/State;", "wasMeasuredWithMultipleConstraints", "windowInfo", "Landroidx/compose/ui/platform/WindowInfo;", "getWindowInfo", "()Landroidx/compose/ui/platform/WindowInfo;", "windowPosition", "windowToViewMatrix", "fontWeightAdjustmentCompat", "getFontWeightAdjustmentCompat", "(Landroid/content/res/Configuration;)I", "addAndroidView", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "layoutNode", "addExtraDataToAccessibilityNodeInfoHelper", "virtualViewId", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "extraDataKey", "", "values", "Landroid/util/SparseArray;", "Landroid/view/autofill/AutofillValue;", "autofillSupported", "boundsUpdatesEventLoop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateLocalPosition", "positionInWindow", "calculateLocalPosition-MK-Hz9U", "(J)J", "calculatePositionInWindow", "localPosition", "calculatePositionInWindow-MK-Hz9U", "canScrollHorizontally", "direction", "canScrollVertically", "clearChildInvalidObservations", "viewGroup", "convertMeasureSpec", "Lkotlin/ULong;", "measureSpec", "convertMeasureSpec-I7RO_PI", "(I)J", "createLayer", "drawBlock", "Landroidx/compose/ui/graphics/Canvas;", "invalidateParentLayer", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "dispatchGenericMotionEvent", "event", "dispatchHoverEvent", "dispatchKeyEvent", "Landroid/view/KeyEvent;", "dispatchKeyEventPreIme", "dispatchTouchEvent", "motionEvent", "drawAndroidView", "findViewByAccessibilityIdRootedAtCurrentView", "accessibilityId", "currentView", "findViewByAccessibilityIdTraversal", "forceMeasureTheSubtree", "affectsLookahead", "getFocusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "getFocusDirection-P8AzH3I", "(Landroid/view/KeyEvent;)Landroidx/compose/ui/focus/FocusDirection;", "getFocusedRect", "rect", "Landroid/graphics/Rect;", "handleMotionEvent", "Landroidx/compose/ui/input/pointer/ProcessResult;", "handleMotionEvent-8iAsVTc", "(Landroid/view/MotionEvent;)I", "handleRotaryEvent", "hasChangedDevices", "lastEvent", "invalidateDescendants", "invalidateLayers", "node", "invalidateLayoutNodeMeasurement", "isBadMotionEvent", "isDevicePressEvent", "isInBounds", "isPositionChanged", "localToScreen", "localToScreen-MK-Hz9U", "localTransform", "localToScreen-58bKbWc", "([F)V", "measureAndLayout", "constraints", "measureAndLayout-0kLqBqw", "(Landroidx/compose/ui/node/LayoutNode;J)V", "sendPointerUpdate", "measureAndLayoutForTest", "notifyLayerIsDirty", "layer", "isDirty", "notifyLayerIsDirty$ui_release", "onAttach", "onAttachedToWindow", "onCheckIsTextEditor", "onConfigurationChanged", "newConfig", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "onCreateVirtualViewTranslationRequests", "virtualIds", "", "supportedFormats", "requestsCollector", "Ljava/util/function/Consumer;", "Landroid/view/translation/ViewTranslationRequest;", "onDetach", "onDetachedFromWindow", "onDraw", "onEndApplyChanges", "onFocusChanged", "gainFocus", "previouslyFocusedRect", "onLayout", "changed", "l", "t", "r", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "onLayoutChange", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onProvideAutofillVirtualStructure", "structure", "Landroid/view/ViewStructure;", "flags", "onRequestMeasure", "forceRequest", "scheduleMeasureAndLayout", "onRequestRelayout", C3040d4.h.u0, "owner", "Landroidx/lifecycle/LifecycleOwner;", "onRtlPropertiesChanged", "onSemanticsChange", "onVirtualViewTranslationResponses", C3337ue.n, "Landroid/util/LongSparseArray;", "Landroid/view/translation/ViewTranslationResponse;", "onWindowFocusChanged", "hasWindowFocus", "pack", "a", "pack-ZIaKswc", "(II)J", "recalculateWindowPosition", "recalculateWindowViewTransforms", "recycle", "recycle$ui_release", "registerOnEndApplyChangesListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "registerOnLayoutCompletedListener", "Landroidx/compose/ui/node/Owner$OnLayoutCompletedListener;", "removeAndroidView", "requestClearInvalidObservations", "requestOnPositionedCallback", "nodeToRemeasure", "screenToLocal", "positionOnScreen", "screenToLocal-MK-Hz9U", "sendKeyEvent", "sendKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "sendMotionEvent", "sendMotionEvent-8iAsVTc", "sendSimulatedEvent", "action", "eventTime", "forceHover", "setOnViewTreeOwnersAvailable", "callback", "shouldDelayChildPressedState", "startDrag", "transferData", "Landroidx/compose/ui/draganddrop/DragAndDropTransferData;", "decorationSize", "Landroidx/compose/ui/geometry/Size;", "drawDragDecoration", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "startDrag-12SF9DM", "(Landroidx/compose/ui/draganddrop/DragAndDropTransferData;JLkotlin/jvm/functions/Function1;)Z", "textInputSession", "", "session", "Lkotlin/Function2;", "Landroidx/compose/ui/platform/PlatformTextInputSessionScope;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePositionCacheAndDispatch", "childSizeCanAffectParentSize", "component1", "component1-VKZWuLQ", "(J)I", "component2", "component2-VKZWuLQ", "AndroidComposeViewTranslationCallback", "Companion", "ViewTreeOwners", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidComposeView extends ViewGroup implements Owner, ViewRootForTest, PositionCalculator, DefaultLifecycleObserver {
    private static final String FocusTag = "Compose Focus";
    private static final int MaximumLayerCacheSize = 10;
    private static Method getBooleanMethod;
    private static Class<?> systemPropertiesClass;
    private AndroidViewsHandler _androidViewsHandler;
    private final AndroidAutofill _autofill;
    private final InputModeManagerImpl _inputModeManager;

    /* renamed from: _viewTreeOwners$delegate, reason: from kotlin metadata */
    private final MutableState _viewTreeOwners;
    private final WindowInfoImpl _windowInfo;
    private final AndroidAccessibilityManager accessibilityManager;
    private final AutofillTree autofillTree;
    private final CanvasHolder canvasHolder;
    private final AndroidClipboardManager clipboardManager;
    private final AndroidComposeViewAccessibilityDelegateCompat composeAccessibilityDelegate;
    private Function1<? super Configuration, Unit> configurationChangeObserver;
    private final CoroutineContext coroutineContext;
    private int currentFontWeightAdjustment;
    private Density density;
    private final List<OwnedLayer> dirtyLayers;
    private final DragAndDropManager dragAndDropManager;
    private final DragAndDropModifierOnDragListener dragAndDropModifierOnDragListener;
    private final MutableVector<Function0<Unit>> endApplyChangesListeners;
    private final FocusOwner focusOwner;

    /* renamed from: fontFamilyResolver$delegate, reason: from kotlin metadata */
    private final MutableState fontFamilyResolver;
    private final Font.ResourceLoader fontLoader;
    private boolean forceUseMatrixCache;
    private final ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;
    private long globalPosition;
    private final HapticFeedback hapticFeedBack;
    private boolean hoverExitReceived;
    private boolean isDrawingContent;
    private boolean isRenderNodeCompatible;
    private final Modifier keyInputModifier;
    private boolean keyboardModifiersRequireUpdate;
    private long lastDownPointerPosition;
    private long lastMatrixRecalculationAnimationTime;
    private final WeakCache<OwnedLayer> layerCache;

    /* renamed from: layoutDirection$delegate, reason: from kotlin metadata */
    private final MutableState layoutDirection;
    private final TextInputServiceAndroid legacyTextInputServiceAndroid;
    private final CalculateMatrixToWindow matrixToWindow;
    private final MeasureAndLayoutDelegate measureAndLayoutDelegate;
    private final ModifierLocalManager modifierLocalManager;
    private final MotionEventAdapter motionEventAdapter;
    private boolean observationClearRequested;
    private Constraints onMeasureConstraints;
    private Function1<? super ViewTreeOwners, Unit> onViewTreeOwnersAvailable;
    private final PointerIconService pointerIconService;
    private final PointerInputEventProcessor pointerInputEventProcessor;
    private List<OwnedLayer> postponedDirtyLayers;
    private MotionEvent previousMotionEvent;
    private long relayoutTime;
    private final Function0<Unit> resendMotionEventOnLayout;
    private final AndroidComposeView$resendMotionEventRunnable$1 resendMotionEventRunnable;
    private final LayoutNode root;
    private final RootForTest rootForTest;
    private final Modifier rotaryInputModifier;
    private final ViewTreeObserver.OnScrollChangedListener scrollChangedListener;
    private final EmptySemanticsElement semanticsModifier;
    private final SemanticsOwner semanticsOwner;
    private final Runnable sendHoverExitEvent;
    private final LayoutNodeDrawScope sharedDrawScope;
    private boolean showLayoutBounds;
    private final OwnerSnapshotObserver snapshotObserver;
    private final SoftwareKeyboardController softwareKeyboardController;
    private boolean superclassInitComplete;
    private final TextInputService textInputService;
    private final AtomicReference<SessionMutex.Session<T>> textInputSessionMutex;
    private final TextToolbar textToolbar;
    private final float[] tmpMatrix;
    private final int[] tmpPositionArray;
    private final ViewTreeObserver.OnTouchModeChangeListener touchModeChangeListener;
    private final ViewConfiguration viewConfiguration;
    private DrawChildContainer viewLayersContainer;
    private final float[] viewToWindowMatrix;

    /* renamed from: viewTreeOwners$delegate, reason: from kotlin metadata */
    private final State viewTreeOwners;
    private boolean wasMeasuredWithMultipleConstraints;
    private long windowPosition;
    private final float[] windowToViewMatrix;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    private final boolean autofillSupported() {
        return true;
    }

    @Deprecated(message = "fontLoader is deprecated, use fontFamilyResolver", replaceWith = @ReplaceWith(expression = "fontFamilyResolver", imports = {}))
    public static /* synthetic */ void getFontLoader$annotations() {
    }

    public static /* synthetic */ void getLastMatrixRecalculationAnimationTime$ui_release$annotations() {
    }

    public static /* synthetic */ void getShowLayoutBounds$annotations() {
    }

    @Override // androidx.compose.ui.node.Owner
    public void onAttach(LayoutNode node) {
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // androidx.compose.ui.node.Owner
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v13, types: [androidx.compose.ui.platform.AndroidComposeView$resendMotionEventRunnable$1] */
    public AndroidComposeView(Context context, CoroutineContext coroutineContext) {
        super(context);
        CalculateMatrixToWindowApi21 calculateMatrixToWindowApi21;
        this.coroutineContext = coroutineContext;
        this.lastDownPointerPosition = Offset.INSTANCE.m3837getUnspecifiedF1C5BW0();
        this.superclassInitComplete = true;
        this.sharedDrawScope = new LayoutNodeDrawScope(null, 1, 0 == true ? 1 : 0);
        this.density = AndroidDensity_androidKt.Density(context);
        EmptySemanticsElement emptySemanticsElement = EmptySemanticsElement.INSTANCE;
        this.semanticsModifier = emptySemanticsElement;
        this.focusOwner = new FocusOwnerImpl(new Function1<Function0<? extends Unit>, Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$focusOwner$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function0<? extends Unit> function0) {
                invoke2((Function0<Unit>) function0);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function0<Unit> function0) {
                AndroidComposeView.this.registerOnEndApplyChangesListener(function0);
            }
        });
        DragAndDropModifierOnDragListener dragAndDropModifierOnDragListener = new DragAndDropModifierOnDragListener(new AndroidComposeView$dragAndDropModifierOnDragListener$1(this));
        this.dragAndDropModifierOnDragListener = dragAndDropModifierOnDragListener;
        this.dragAndDropManager = dragAndDropModifierOnDragListener;
        this._windowInfo = new WindowInfoImpl();
        Modifier onKeyEvent = KeyInputModifierKt.onKeyEvent(Modifier.INSTANCE, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$keyInputModifier$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                return m5626invokeZmokQxo(keyEvent.m5060unboximpl());
            }

            /* renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m5626invokeZmokQxo(android.view.KeyEvent keyEvent) {
                FocusDirection mo5594getFocusDirectionP8AzH3I = AndroidComposeView.this.mo5594getFocusDirectionP8AzH3I(keyEvent);
                if (mo5594getFocusDirectionP8AzH3I == null || !KeyEventType.m5064equalsimpl0(KeyEvent_androidKt.m5072getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m5068getKeyDownCS__XNY())) {
                    return false;
                }
                return Boolean.valueOf(AndroidComposeView.this.getFocusOwner().mo3756moveFocus3ESFkO8(mo5594getFocusDirectionP8AzH3I.getValue()));
            }
        });
        this.keyInputModifier = onKeyEvent;
        Modifier onRotaryScrollEvent = RotaryInputModifierKt.onRotaryScrollEvent(Modifier.INSTANCE, new Function1<RotaryScrollEvent, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$rotaryInputModifier$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(RotaryScrollEvent rotaryScrollEvent) {
                return false;
            }
        });
        this.rotaryInputModifier = onRotaryScrollEvent;
        this.canvasHolder = new CanvasHolder();
        LayoutNode layoutNode = new LayoutNode(false, 0, 3, null);
        layoutNode.setMeasurePolicy(RootMeasurePolicy.INSTANCE);
        layoutNode.setDensity(getDensity());
        layoutNode.setModifier(Modifier.INSTANCE.then(emptySemanticsElement).then(onRotaryScrollEvent).then(getFocusOwner().getModifier()).then(onKeyEvent).then(dragAndDropModifierOnDragListener.getModifier()));
        this.root = layoutNode;
        this.rootForTest = this;
        this.semanticsOwner = new SemanticsOwner(getRoot());
        AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = new AndroidComposeViewAccessibilityDelegateCompat(this);
        this.composeAccessibilityDelegate = androidComposeViewAccessibilityDelegateCompat;
        this.autofillTree = new AutofillTree();
        this.dirtyLayers = new ArrayList();
        this.motionEventAdapter = new MotionEventAdapter();
        this.pointerInputEventProcessor = new PointerInputEventProcessor(getRoot());
        this.configurationChangeObserver = new Function1<Configuration, Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$configurationChangeObserver$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Configuration configuration) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Configuration configuration) {
                invoke2(configuration);
                return Unit.INSTANCE;
            }
        };
        this._autofill = autofillSupported() ? new AndroidAutofill(this, getAutofillTree()) : null;
        this.clipboardManager = new AndroidClipboardManager(context);
        this.accessibilityManager = new AndroidAccessibilityManager(context);
        this.snapshotObserver = new OwnerSnapshotObserver(new AndroidComposeView$snapshotObserver$1(this));
        this.measureAndLayoutDelegate = new MeasureAndLayoutDelegate(getRoot());
        this.viewConfiguration = new AndroidViewConfiguration(android.view.ViewConfiguration.get(context));
        this.globalPosition = IntOffsetKt.IntOffset(Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.tmpPositionArray = new int[]{0, 0};
        float[] m4294constructorimpl$default = Matrix.m4294constructorimpl$default(null, 1, null);
        this.tmpMatrix = m4294constructorimpl$default;
        this.viewToWindowMatrix = Matrix.m4294constructorimpl$default(null, 1, null);
        this.windowToViewMatrix = Matrix.m4294constructorimpl$default(null, 1, null);
        this.lastMatrixRecalculationAnimationTime = -1L;
        this.windowPosition = Offset.INSTANCE.m3836getInfiniteF1C5BW0();
        this.isRenderNodeCompatible = true;
        this._viewTreeOwners = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.viewTreeOwners = SnapshotStateKt.derivedStateOf(new Function0<ViewTreeOwners>() { // from class: androidx.compose.ui.platform.AndroidComposeView$viewTreeOwners$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AndroidComposeView.ViewTreeOwners invoke() {
                AndroidComposeView.ViewTreeOwners viewTreeOwners;
                viewTreeOwners = AndroidComposeView.this.get_viewTreeOwners();
                return viewTreeOwners;
            }
        });
        this.globalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.compose.ui.platform.AndroidComposeView$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                AndroidComposeView.this.updatePositionCacheAndDispatch();
            }
        };
        this.scrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: androidx.compose.ui.platform.AndroidComposeView$$ExternalSyntheticLambda1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                AndroidComposeView.this.updatePositionCacheAndDispatch();
            }
        };
        this.touchModeChangeListener = new ViewTreeObserver.OnTouchModeChangeListener() { // from class: androidx.compose.ui.platform.AndroidComposeView$$ExternalSyntheticLambda2
            @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
            public final void onTouchModeChanged(boolean z) {
                AndroidComposeView.touchModeChangeListener$lambda$3(AndroidComposeView.this, z);
            }
        };
        TextInputServiceAndroid textInputServiceAndroid = new TextInputServiceAndroid(getView(), this);
        this.legacyTextInputServiceAndroid = textInputServiceAndroid;
        this.textInputService = new TextInputService(AndroidComposeView_androidKt.getPlatformTextInputServiceInterceptor().invoke(textInputServiceAndroid));
        this.textInputSessionMutex = SessionMutex.m3702constructorimpl();
        this.softwareKeyboardController = new DelegatingSoftwareKeyboardController(getTextInputService());
        this.fontLoader = new AndroidFontResourceLoader(context);
        this.fontFamilyResolver = SnapshotStateKt.mutableStateOf(FontFamilyResolver_androidKt.createFontFamilyResolver(context), SnapshotStateKt.referentialEqualityPolicy());
        this.currentFontWeightAdjustment = getFontWeightAdjustmentCompat(context.getResources().getConfiguration());
        this.layoutDirection = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(AndroidComposeView_androidKt.getLocaleLayoutDirection(context.getResources().getConfiguration()), null, 2, null);
        AndroidComposeView androidComposeView = this;
        this.hapticFeedBack = new PlatformHapticFeedback(androidComposeView);
        this._inputModeManager = new InputModeManagerImpl(isInTouchMode() ? InputMode.INSTANCE.m4754getTouchaOaMEAU() : InputMode.INSTANCE.m4753getKeyboardaOaMEAU(), new Function1<InputMode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$_inputModeManager$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(InputMode inputMode) {
                return m5624invokeiuPiT84(inputMode.getValue());
            }

            /* renamed from: invoke-iuPiT84, reason: not valid java name */
            public final Boolean m5624invokeiuPiT84(int i) {
                boolean requestFocusFromTouch;
                if (InputMode.m4749equalsimpl0(i, InputMode.INSTANCE.m4754getTouchaOaMEAU())) {
                    requestFocusFromTouch = AndroidComposeView.this.isInTouchMode();
                } else {
                    requestFocusFromTouch = InputMode.m4749equalsimpl0(i, InputMode.INSTANCE.m4753getKeyboardaOaMEAU()) ? AndroidComposeView.this.isInTouchMode() ? AndroidComposeView.this.requestFocusFromTouch() : true : false;
                }
                return Boolean.valueOf(requestFocusFromTouch);
            }
        }, null);
        AndroidComposeView androidComposeView2 = this;
        this.modifierLocalManager = new ModifierLocalManager(androidComposeView2);
        this.textToolbar = new AndroidTextToolbar(androidComposeView);
        this.layerCache = new WeakCache<>();
        this.endApplyChangesListeners = new MutableVector<>(new Function0[16], 0);
        this.resendMotionEventRunnable = new Runnable() { // from class: androidx.compose.ui.platform.AndroidComposeView$resendMotionEventRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                MotionEvent motionEvent;
                long j;
                AndroidComposeView.this.removeCallbacks(this);
                motionEvent = AndroidComposeView.this.previousMotionEvent;
                if (motionEvent != null) {
                    boolean z = motionEvent.getToolType(0) == 3;
                    int actionMasked = motionEvent.getActionMasked();
                    if (z) {
                        if (actionMasked == 10 || actionMasked == 1) {
                            return;
                        }
                    } else if (actionMasked == 1) {
                        return;
                    }
                    int i = 7;
                    if (actionMasked != 7 && actionMasked != 9) {
                        i = 2;
                    }
                    AndroidComposeView androidComposeView3 = AndroidComposeView.this;
                    j = androidComposeView3.relayoutTime;
                    androidComposeView3.sendSimulatedEvent(motionEvent, i, j, false);
                }
            }
        };
        this.sendHoverExitEvent = new Runnable() { // from class: androidx.compose.ui.platform.AndroidComposeView$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                AndroidComposeView.sendHoverExitEvent$lambda$5(AndroidComposeView.this);
            }
        };
        this.resendMotionEventOnLayout = new Function0<Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$resendMotionEventOnLayout$1
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
                MotionEvent motionEvent;
                AndroidComposeView$resendMotionEventRunnable$1 androidComposeView$resendMotionEventRunnable$1;
                motionEvent = AndroidComposeView.this.previousMotionEvent;
                if (motionEvent != null) {
                    int actionMasked = motionEvent.getActionMasked();
                    if (actionMasked == 7 || actionMasked == 9) {
                        AndroidComposeView.this.relayoutTime = SystemClock.uptimeMillis();
                        AndroidComposeView androidComposeView3 = AndroidComposeView.this;
                        androidComposeView$resendMotionEventRunnable$1 = androidComposeView3.resendMotionEventRunnable;
                        androidComposeView3.post(androidComposeView$resendMotionEventRunnable$1);
                    }
                }
            }
        };
        if (Build.VERSION.SDK_INT >= 29) {
            calculateMatrixToWindowApi21 = new CalculateMatrixToWindowApi29();
        } else {
            calculateMatrixToWindowApi21 = new CalculateMatrixToWindowApi21(m4294constructorimpl$default, null);
        }
        this.matrixToWindow = calculateMatrixToWindowApi21;
        setWillNotDraw(false);
        setFocusable(true);
        AndroidComposeViewVerificationHelperMethodsO.INSTANCE.focusable(androidComposeView, 1, false);
        setFocusableInTouchMode(true);
        setClipChildren(false);
        ViewCompat.setAccessibilityDelegate(androidComposeView, androidComposeViewAccessibilityDelegateCompat);
        Function1<ViewRootForTest, Unit> onViewCreatedCallback = ViewRootForTest.INSTANCE.getOnViewCreatedCallback();
        if (onViewCreatedCallback != null) {
            onViewCreatedCallback.invoke(this);
        }
        setOnDragListener(dragAndDropModifierOnDragListener);
        getRoot().attach$ui_release(androidComposeView2);
        if (Build.VERSION.SDK_INT >= 29) {
            AndroidComposeViewForceDarkModeQ.INSTANCE.disallowForceDark(androidComposeView);
        }
        this.pointerIconService = new PointerIconService() { // from class: androidx.compose.ui.platform.AndroidComposeView$pointerIconService$1
            private PointerIcon currentIcon = PointerIcon.INSTANCE.getDefault();

            @Override // androidx.compose.ui.input.pointer.PointerIconService
            /* renamed from: getIcon, reason: from getter */
            public PointerIcon getCurrentIcon() {
                return this.currentIcon;
            }

            @Override // androidx.compose.ui.input.pointer.PointerIconService
            public void setIcon(PointerIcon value) {
                if (value == null) {
                    value = PointerIcon.INSTANCE.getDefault();
                }
                this.currentIcon = value;
                AndroidComposeViewVerificationHelperMethodsN.INSTANCE.setPointerIcon(AndroidComposeView.this, this.currentIcon);
            }
        };
    }

    @Override // androidx.compose.ui.node.Owner
    public LayoutNodeDrawScope getSharedDrawScope() {
        return this.sharedDrawScope;
    }

    @Override // androidx.compose.ui.platform.ViewRootForTest
    public View getView() {
        return this;
    }

    @Override // androidx.compose.ui.node.Owner, androidx.compose.ui.node.RootForTest
    public Density getDensity() {
        return this.density;
    }

    @Override // androidx.compose.ui.node.Owner
    public FocusOwner getFocusOwner() {
        return this.focusOwner;
    }

    @Override // androidx.compose.ui.node.Owner
    public DragAndDropManager getDragAndDropManager() {
        return this.dragAndDropManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public WindowInfo getWindowInfo() {
        return this._windowInfo;
    }

    @Override // androidx.compose.ui.node.Owner
    public LayoutNode getRoot() {
        return this.root;
    }

    @Override // androidx.compose.ui.node.Owner
    public RootForTest getRootForTest() {
        return this.rootForTest;
    }

    @Override // androidx.compose.ui.node.RootForTest
    public SemanticsOwner getSemanticsOwner() {
        return this.semanticsOwner;
    }

    @Override // androidx.compose.ui.node.Owner
    public AutofillTree getAutofillTree() {
        return this.autofillTree;
    }

    public final Function1<Configuration, Unit> getConfigurationChangeObserver() {
        return this.configurationChangeObserver;
    }

    public final void setConfigurationChangeObserver(Function1<? super Configuration, Unit> function1) {
        this.configurationChangeObserver = function1;
    }

    @Override // androidx.compose.ui.node.Owner
    public Autofill getAutofill() {
        return this._autofill;
    }

    @Override // androidx.compose.ui.node.Owner
    public AndroidClipboardManager getClipboardManager() {
        return this.clipboardManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public AndroidAccessibilityManager getAccessibilityManager() {
        return this.accessibilityManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public OwnerSnapshotObserver getSnapshotObserver() {
        return this.snapshotObserver;
    }

    @Override // androidx.compose.ui.node.Owner
    public boolean getShowLayoutBounds() {
        return this.showLayoutBounds;
    }

    @Override // androidx.compose.ui.node.Owner
    public void setShowLayoutBounds(boolean z) {
        this.showLayoutBounds = z;
    }

    public final AndroidViewsHandler getAndroidViewsHandler$ui_release() {
        if (this._androidViewsHandler == null) {
            AndroidViewsHandler androidViewsHandler = new AndroidViewsHandler(getContext());
            this._androidViewsHandler = androidViewsHandler;
            addView(androidViewsHandler);
        }
        AndroidViewsHandler androidViewsHandler2 = this._androidViewsHandler;
        Intrinsics.checkNotNull(androidViewsHandler2);
        return androidViewsHandler2;
    }

    @Override // androidx.compose.ui.node.Owner
    public long getMeasureIteration() {
        return this.measureAndLayoutDelegate.getMeasureIteration();
    }

    @Override // androidx.compose.ui.node.Owner
    public ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    @Override // androidx.compose.ui.platform.ViewRootForTest
    public boolean getHasPendingMeasureOrLayout() {
        return this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout();
    }

    /* renamed from: getLastMatrixRecalculationAnimationTime$ui_release, reason: from getter */
    public final long getLastMatrixRecalculationAnimationTime() {
        return this.lastMatrixRecalculationAnimationTime;
    }

    public final void setLastMatrixRecalculationAnimationTime$ui_release(long j) {
        this.lastMatrixRecalculationAnimationTime = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final ViewTreeOwners get_viewTreeOwners() {
        return (ViewTreeOwners) this._viewTreeOwners.getValue();
    }

    private final void set_viewTreeOwners(ViewTreeOwners viewTreeOwners) {
        this._viewTreeOwners.setValue(viewTreeOwners);
    }

    public final ViewTreeOwners getViewTreeOwners() {
        return (ViewTreeOwners) this.viewTreeOwners.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void touchModeChangeListener$lambda$3(AndroidComposeView androidComposeView, boolean z) {
        androidComposeView._inputModeManager.m4757setInputModeiuPiT84(z ? InputMode.INSTANCE.m4754getTouchaOaMEAU() : InputMode.INSTANCE.m4753getKeyboardaOaMEAU());
    }

    @Override // androidx.compose.ui.node.Owner, androidx.compose.ui.node.RootForTest
    public TextInputService getTextInputService() {
        return this.textInputService;
    }

    @Override // androidx.compose.ui.node.Owner
    public SoftwareKeyboardController getSoftwareKeyboardController() {
        return this.softwareKeyboardController;
    }

    @Override // androidx.compose.ui.node.Owner
    public Placeable.PlacementScope getPlacementScope() {
        return PlaceableKt.PlacementScope(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // androidx.compose.ui.platform.PlatformTextInputSessionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object textInputSession(Function2<? super PlatformTextInputSessionScope, ? super Continuation<?>, ? extends Object> function2, Continuation<?> continuation) {
        AndroidComposeView$textInputSession$1 androidComposeView$textInputSession$1;
        int i;
        if (continuation instanceof AndroidComposeView$textInputSession$1) {
            androidComposeView$textInputSession$1 = (AndroidComposeView$textInputSession$1) continuation;
            if ((androidComposeView$textInputSession$1.label & Integer.MIN_VALUE) != 0) {
                androidComposeView$textInputSession$1.label -= Integer.MIN_VALUE;
                Object obj = androidComposeView$textInputSession$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = androidComposeView$textInputSession$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    AtomicReference<SessionMutex.Session<T>> atomicReference = this.textInputSessionMutex;
                    Function1<CoroutineScope, AndroidPlatformTextInputSession> function1 = new Function1<CoroutineScope, AndroidPlatformTextInputSession>() { // from class: androidx.compose.ui.platform.AndroidComposeView$textInputSession$2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final AndroidPlatformTextInputSession invoke(CoroutineScope coroutineScope) {
                            AndroidComposeView androidComposeView = AndroidComposeView.this;
                            return new AndroidPlatformTextInputSession(androidComposeView, androidComposeView.getTextInputService(), coroutineScope);
                        }
                    };
                    androidComposeView$textInputSession$1.label = 1;
                    if (SessionMutex.m3709withSessionCancellingPreviousimpl(atomicReference, function1, function2, androidComposeView$textInputSession$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                throw new KotlinNothingValueException();
            }
        }
        androidComposeView$textInputSession$1 = new AndroidComposeView$textInputSession$1(this, continuation);
        Object obj2 = androidComposeView$textInputSession$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidComposeView$textInputSession$1.label;
        if (i != 0) {
        }
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.ui.node.Owner
    public Font.ResourceLoader getFontLoader() {
        return this.fontLoader;
    }

    private void setFontFamilyResolver(FontFamily.Resolver resolver) {
        this.fontFamilyResolver.setValue(resolver);
    }

    @Override // androidx.compose.ui.node.Owner
    public FontFamily.Resolver getFontFamilyResolver() {
        return (FontFamily.Resolver) this.fontFamilyResolver.getValue();
    }

    private final int getFontWeightAdjustmentCompat(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            return configuration.fontWeightAdjustment;
        }
        return 0;
    }

    private void setLayoutDirection(LayoutDirection layoutDirection) {
        this.layoutDirection.setValue(layoutDirection);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View, android.view.ViewParent, androidx.compose.ui.node.Owner
    public LayoutDirection getLayoutDirection() {
        return (LayoutDirection) this.layoutDirection.getValue();
    }

    @Override // androidx.compose.ui.node.Owner
    public HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    @Override // androidx.compose.ui.node.Owner
    public InputModeManager getInputModeManager() {
        return this._inputModeManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public ModifierLocalManager getModifierLocalManager() {
        return this.modifierLocalManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendHoverExitEvent$lambda$5(AndroidComposeView androidComposeView) {
        androidComposeView.hoverExitReceived = false;
        MotionEvent motionEvent = androidComposeView.previousMotionEvent;
        Intrinsics.checkNotNull(motionEvent);
        if (motionEvent.getActionMasked() != 10) {
            throw new IllegalStateException("The ACTION_HOVER_EXIT event was not cleared.".toString());
        }
        androidComposeView.m5622sendMotionEvent8iAsVTc(motionEvent);
    }

    @Override // android.view.View
    public void getFocusedRect(Rect rect) {
        Unit unit;
        androidx.compose.ui.geometry.Rect focusRect = getFocusOwner().getFocusRect();
        if (focusRect != null) {
            rect.left = MathKt.roundToInt(focusRect.getLeft());
            rect.top = MathKt.roundToInt(focusRect.getTop());
            rect.right = MathKt.roundToInt(focusRect.getRight());
            rect.bottom = MathKt.roundToInt(focusRect.getBottom());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            super.getFocusedRect(rect);
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onResume(LifecycleOwner owner) {
        setShowLayoutBounds(INSTANCE.getIsShowingLayoutBounds());
    }

    @Override // android.view.View
    protected void onFocusChanged(final boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        Log.d(FocusTag, "Owner FocusChanged(" + gainFocus + ')');
        FocusTransactionManager focusTransactionManager = getFocusOwner().getFocusTransactionManager();
        focusTransactionManager.cancellationListener.add(new Function0<Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$onFocusChanged$1
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
                if (gainFocus) {
                    this.clearFocus();
                } else {
                    this.requestFocus();
                }
            }
        });
        if (focusTransactionManager.ongoingTransaction) {
            if (gainFocus) {
                getFocusOwner().takeFocus();
                return;
            } else {
                getFocusOwner().releaseFocus();
                return;
            }
        }
        try {
            focusTransactionManager.beginTransaction();
            if (gainFocus) {
                getFocusOwner().takeFocus();
            } else {
                getFocusOwner().releaseFocus();
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            focusTransactionManager.commitTransaction();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        boolean isShowingLayoutBounds;
        this._windowInfo.setWindowFocused(hasWindowFocus);
        this.keyboardModifiersRequireUpdate = true;
        super.onWindowFocusChanged(hasWindowFocus);
        if (!hasWindowFocus || getShowLayoutBounds() == (isShowingLayoutBounds = INSTANCE.getIsShowingLayoutBounds())) {
            return;
        }
        setShowLayoutBounds(isShowingLayoutBounds);
        invalidateDescendants();
    }

    @Override // androidx.compose.ui.node.RootForTest
    /* renamed from: sendKeyEvent-ZmokQxo */
    public boolean mo5596sendKeyEventZmokQxo(android.view.KeyEvent keyEvent) {
        return getFocusOwner().mo3757dispatchInterceptedSoftKeyboardEventZmokQxo(keyEvent) || getFocusOwner().mo3758dispatchKeyEventZmokQxo(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(android.view.KeyEvent event) {
        if (isFocused()) {
            this._windowInfo.m5698setKeyboardModifiers5xRPYO0(PointerKeyboardModifiers.m5270constructorimpl(event.getMetaState()));
            return getFocusOwner().mo3758dispatchKeyEventZmokQxo(KeyEvent.m5055constructorimpl(event)) || super.dispatchKeyEvent(event);
        }
        return super.dispatchKeyEvent(event);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEventPreIme(android.view.KeyEvent event) {
        return (isFocused() && getFocusOwner().mo3757dispatchInterceptedSoftKeyboardEventZmokQxo(KeyEvent.m5055constructorimpl(event))) || super.dispatchKeyEventPreIme(event);
    }

    @Override // androidx.compose.ui.node.Owner
    public void onDetach(LayoutNode node) {
        this.measureAndLayoutDelegate.onNodeDetached(node);
        requestClearInvalidObservations();
    }

    public final void requestClearInvalidObservations() {
        this.observationClearRequested = true;
    }

    @Override // androidx.compose.ui.node.Owner
    public void onEndApplyChanges() {
        if (this.observationClearRequested) {
            getSnapshotObserver().clearInvalidObservations$ui_release();
            this.observationClearRequested = false;
        }
        AndroidViewsHandler androidViewsHandler = this._androidViewsHandler;
        if (androidViewsHandler != null) {
            clearChildInvalidObservations(androidViewsHandler);
        }
        while (this.endApplyChangesListeners.isNotEmpty()) {
            int size = this.endApplyChangesListeners.getSize();
            for (int i = 0; i < size; i++) {
                Function0<Unit> function0 = this.endApplyChangesListeners.getContent()[i];
                this.endApplyChangesListeners.set(i, null);
                if (function0 != null) {
                    function0.invoke();
                }
            }
            this.endApplyChangesListeners.removeRange(0, size);
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void registerOnEndApplyChangesListener(Function0<Unit> listener) {
        if (this.endApplyChangesListeners.contains(listener)) {
            return;
        }
        this.endApplyChangesListeners.add(listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startDrag-12SF9DM, reason: not valid java name */
    public final boolean m5623startDrag12SF9DM(DragAndDropTransferData transferData, long decorationSize, Function1<? super DrawScope, Unit> drawDragDecoration) {
        Resources resources = getContext().getResources();
        return AndroidComposeViewStartDragAndDropN.INSTANCE.startDragAndDrop(this, transferData, new ComposeDragShadowBuilder(DensityKt.Density(resources.getDisplayMetrics().density, resources.getConfiguration().fontScale), decorationSize, drawDragDecoration, null));
    }

    private final void clearChildInvalidObservations(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof AndroidComposeView) {
                ((AndroidComposeView) childAt).onEndApplyChanges();
            } else if (childAt instanceof ViewGroup) {
                clearChildInvalidObservations((ViewGroup) childAt);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addExtraDataToAccessibilityNodeInfoHelper(int virtualViewId, AccessibilityNodeInfo info, String extraDataKey) {
        Integer num;
        if (Intrinsics.areEqual(extraDataKey, this.composeAccessibilityDelegate.getExtraDataTestTraversalBeforeVal())) {
            Integer num2 = this.composeAccessibilityDelegate.getIdToBeforeMap$ui_release().get(Integer.valueOf(virtualViewId));
            if (num2 != null) {
                info.getExtras().putInt(extraDataKey, num2.intValue());
                return;
            }
            return;
        }
        if (!Intrinsics.areEqual(extraDataKey, this.composeAccessibilityDelegate.getExtraDataTestTraversalAfterVal()) || (num = this.composeAccessibilityDelegate.getIdToAfterMap$ui_release().get(Integer.valueOf(virtualViewId))) == null) {
            return;
        }
        info.getExtras().putInt(extraDataKey, num.intValue());
    }

    public final void addAndroidView(AndroidViewHolder view, final LayoutNode layoutNode) {
        getAndroidViewsHandler$ui_release().getHolderToLayoutNode().put(view, layoutNode);
        AndroidViewHolder androidViewHolder = view;
        getAndroidViewsHandler$ui_release().addView(androidViewHolder);
        getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().put(layoutNode, view);
        ViewCompat.setImportantForAccessibility(androidViewHolder, 1);
        ViewCompat.setAccessibilityDelegate(androidViewHolder, new AccessibilityDelegateCompat() { // from class: androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1
            /* JADX WARN: Code restructure failed: missing block: B:9:0x003d, code lost:
            
                if (r6.intValue() == r5.this$0.getSemanticsOwner().getUnmergedRootSemanticsNode().getId()) goto L12;
             */
            @Override // androidx.core.view.AccessibilityDelegateCompat
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
                super.onInitializeAccessibilityNodeInfo(host, info);
                if (AndroidComposeView.this.composeAccessibilityDelegate.isEnabledForAccessibility$ui_release()) {
                    info.setVisibleToUser(false);
                }
                LayoutNode findClosestParentNode = SemanticsNodeKt.findClosestParentNode(layoutNode, new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(LayoutNode layoutNode2) {
                        return Boolean.valueOf(layoutNode2.getNodes().m5502hasH91voCI$ui_release(NodeKind.m5539constructorimpl(8)));
                    }
                });
                Integer valueOf = findClosestParentNode != null ? Integer.valueOf(findClosestParentNode.getSemanticsId()) : null;
                if (valueOf != null) {
                }
                valueOf = -1;
                info.setParent(this, valueOf.intValue());
                int semanticsId = layoutNode.getSemanticsId();
                Integer num = AndroidComposeView.this.composeAccessibilityDelegate.getIdToBeforeMap$ui_release().get(Integer.valueOf(semanticsId));
                if (num != null) {
                    AndroidComposeView androidComposeView = AndroidComposeView.this;
                    AndroidComposeView androidComposeView2 = this;
                    int intValue = num.intValue();
                    View semanticsIdToView = AndroidComposeViewAccessibilityDelegateCompat_androidKt.semanticsIdToView(androidComposeView.getAndroidViewsHandler$ui_release(), num.intValue());
                    if (semanticsIdToView != null) {
                        info.setTraversalBefore(semanticsIdToView);
                    } else {
                        info.setTraversalBefore(androidComposeView2, intValue);
                    }
                    androidComposeView.addExtraDataToAccessibilityNodeInfoHelper(semanticsId, info.unwrap(), androidComposeView.composeAccessibilityDelegate.getExtraDataTestTraversalBeforeVal());
                }
                Integer num2 = AndroidComposeView.this.composeAccessibilityDelegate.getIdToAfterMap$ui_release().get(Integer.valueOf(semanticsId));
                if (num2 != null) {
                    AndroidComposeView androidComposeView3 = AndroidComposeView.this;
                    AndroidComposeView androidComposeView4 = this;
                    int intValue2 = num2.intValue();
                    View semanticsIdToView2 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.semanticsIdToView(androidComposeView3.getAndroidViewsHandler$ui_release(), num2.intValue());
                    if (semanticsIdToView2 != null) {
                        info.setTraversalAfter(semanticsIdToView2);
                    } else {
                        info.setTraversalAfter(androidComposeView4, intValue2);
                    }
                    androidComposeView3.addExtraDataToAccessibilityNodeInfoHelper(semanticsId, info.unwrap(), androidComposeView3.composeAccessibilityDelegate.getExtraDataTestTraversalAfterVal());
                }
            }
        });
    }

    public final void removeAndroidView(final AndroidViewHolder view) {
        registerOnEndApplyChangesListener(new Function0<Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$removeAndroidView$1
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
                AndroidComposeView.this.getAndroidViewsHandler$ui_release().removeViewInLayout(view);
                HashMap<LayoutNode, AndroidViewHolder> layoutNodeToHolder = AndroidComposeView.this.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder();
                TypeIntrinsics.asMutableMap(layoutNodeToHolder).remove(AndroidComposeView.this.getAndroidViewsHandler$ui_release().getHolderToLayoutNode().remove(view));
                ViewCompat.setImportantForAccessibility(view, 0);
            }
        });
    }

    public final void drawAndroidView(AndroidViewHolder view, Canvas canvas) {
        getAndroidViewsHandler$ui_release().drawView(view, canvas);
    }

    static /* synthetic */ void scheduleMeasureAndLayout$default(AndroidComposeView androidComposeView, LayoutNode layoutNode, int i, Object obj) {
        if ((i & 1) != 0) {
            layoutNode = null;
        }
        androidComposeView.scheduleMeasureAndLayout(layoutNode);
    }

    private final void scheduleMeasureAndLayout(LayoutNode nodeToRemeasure) {
        if (isLayoutRequested() || !isAttachedToWindow()) {
            return;
        }
        if (nodeToRemeasure != null) {
            while (nodeToRemeasure != null && nodeToRemeasure.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock && childSizeCanAffectParentSize(nodeToRemeasure)) {
                nodeToRemeasure = nodeToRemeasure.getParent$ui_release();
            }
            if (nodeToRemeasure == getRoot()) {
                requestLayout();
                return;
            }
        }
        if (getWidth() == 0 || getHeight() == 0) {
            requestLayout();
        } else {
            invalidate();
        }
    }

    private final boolean childSizeCanAffectParentSize(LayoutNode layoutNode) {
        if (this.wasMeasuredWithMultipleConstraints) {
            return true;
        }
        LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
        return (parent$ui_release == null || parent$ui_release.getHasFixedInnerContentConstraints$ui_release()) ? false : true;
    }

    @Override // androidx.compose.ui.node.Owner
    public void measureAndLayout(boolean sendPointerUpdate) {
        Function0<Unit> function0;
        if (this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout() || this.measureAndLayoutDelegate.getHasPendingOnPositionedCallbacks()) {
            Trace.beginSection("AndroidOwner:measureAndLayout");
            if (sendPointerUpdate) {
                try {
                    function0 = this.resendMotionEventOnLayout;
                } catch (Throwable th) {
                    Trace.endSection();
                    throw th;
                }
            } else {
                function0 = null;
            }
            if (this.measureAndLayoutDelegate.measureAndLayout(function0)) {
                requestLayout();
            }
            MeasureAndLayoutDelegate.dispatchOnPositionedCallbacks$default(this.measureAndLayoutDelegate, false, 1, null);
            Unit unit = Unit.INSTANCE;
            Trace.endSection();
        }
    }

    @Override // androidx.compose.ui.node.Owner
    /* renamed from: measureAndLayout-0kLqBqw */
    public void mo5595measureAndLayout0kLqBqw(LayoutNode layoutNode, long constraints) {
        Trace.beginSection("AndroidOwner:measureAndLayout");
        try {
            this.measureAndLayoutDelegate.m5495measureAndLayout0kLqBqw(layoutNode, constraints);
            if (!this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout()) {
                MeasureAndLayoutDelegate.dispatchOnPositionedCallbacks$default(this.measureAndLayoutDelegate, false, 1, null);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void forceMeasureTheSubtree(LayoutNode layoutNode, boolean affectsLookahead) {
        this.measureAndLayoutDelegate.forceMeasureTheSubtree(layoutNode, affectsLookahead);
    }

    @Override // androidx.compose.ui.node.Owner
    public void onRequestMeasure(LayoutNode layoutNode, boolean affectsLookahead, boolean forceRequest, boolean scheduleMeasureAndLayout) {
        if (affectsLookahead) {
            if (this.measureAndLayoutDelegate.requestLookaheadRemeasure(layoutNode, forceRequest) && scheduleMeasureAndLayout) {
                scheduleMeasureAndLayout(layoutNode);
                return;
            }
            return;
        }
        if (this.measureAndLayoutDelegate.requestRemeasure(layoutNode, forceRequest) && scheduleMeasureAndLayout) {
            scheduleMeasureAndLayout(layoutNode);
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void onRequestRelayout(LayoutNode layoutNode, boolean affectsLookahead, boolean forceRequest) {
        if (affectsLookahead) {
            if (this.measureAndLayoutDelegate.requestLookaheadRelayout(layoutNode, forceRequest)) {
                scheduleMeasureAndLayout$default(this, null, 1, null);
            }
        } else if (this.measureAndLayoutDelegate.requestRelayout(layoutNode, forceRequest)) {
            scheduleMeasureAndLayout$default(this, null, 1, null);
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void requestOnPositionedCallback(LayoutNode layoutNode) {
        this.measureAndLayoutDelegate.requestOnPositionedCallback(layoutNode);
        scheduleMeasureAndLayout$default(this, null, 1, null);
    }

    @Override // androidx.compose.ui.node.RootForTest
    public void measureAndLayoutForTest() {
        Owner.measureAndLayout$default(this, false, 1, null);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Trace.beginSection("AndroidOwner:onMeasure");
        try {
            if (!isAttachedToWindow()) {
                invalidateLayoutNodeMeasurement(getRoot());
            }
            long m5619convertMeasureSpecI7RO_PI = m5619convertMeasureSpecI7RO_PI(widthMeasureSpec);
            int m10415constructorimpl = (int) ULong.m10415constructorimpl(m5619convertMeasureSpecI7RO_PI >>> 32);
            int m10415constructorimpl2 = (int) ULong.m10415constructorimpl(m5619convertMeasureSpecI7RO_PI & 4294967295L);
            long m5619convertMeasureSpecI7RO_PI2 = m5619convertMeasureSpecI7RO_PI(heightMeasureSpec);
            long Constraints = ConstraintsKt.Constraints(m10415constructorimpl, m10415constructorimpl2, (int) ULong.m10415constructorimpl(m5619convertMeasureSpecI7RO_PI2 >>> 32), (int) ULong.m10415constructorimpl(4294967295L & m5619convertMeasureSpecI7RO_PI2));
            Constraints constraints = this.onMeasureConstraints;
            boolean z = false;
            if (constraints == null) {
                this.onMeasureConstraints = Constraints.m6333boximpl(Constraints);
                this.wasMeasuredWithMultipleConstraints = false;
            } else {
                if (constraints != null) {
                    z = Constraints.m6338equalsimpl0(constraints.getValue(), Constraints);
                }
                if (!z) {
                    this.wasMeasuredWithMultipleConstraints = true;
                }
            }
            this.measureAndLayoutDelegate.m5496updateRootConstraintsBRTryo0(Constraints);
            this.measureAndLayoutDelegate.measureOnly();
            setMeasuredDimension(getRoot().getWidth(), getRoot().getHeight());
            if (this._androidViewsHandler != null) {
                getAndroidViewsHandler$ui_release().measure(View.MeasureSpec.makeMeasureSpec(getRoot().getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getRoot().getHeight(), 1073741824));
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    /* renamed from: component1-VKZWuLQ, reason: not valid java name */
    private final int m5617component1VKZWuLQ(long j) {
        return (int) ULong.m10415constructorimpl(j >>> 32);
    }

    /* renamed from: component2-VKZWuLQ, reason: not valid java name */
    private final int m5618component2VKZWuLQ(long j) {
        return (int) ULong.m10415constructorimpl(j & 4294967295L);
    }

    /* renamed from: pack-ZIaKswc, reason: not valid java name */
    private final long m5621packZIaKswc(int a2, int b) {
        return ULong.m10415constructorimpl(ULong.m10415constructorimpl(b) | ULong.m10415constructorimpl(ULong.m10415constructorimpl(a2) << 32));
    }

    /* renamed from: convertMeasureSpec-I7RO_PI, reason: not valid java name */
    private final long m5619convertMeasureSpecI7RO_PI(int measureSpec) {
        int mode = View.MeasureSpec.getMode(measureSpec);
        int size = View.MeasureSpec.getSize(measureSpec);
        if (mode == Integer.MIN_VALUE) {
            return m5621packZIaKswc(0, size);
        }
        if (mode == 0) {
            return m5621packZIaKswc(0, Integer.MAX_VALUE);
        }
        if (mode == 1073741824) {
            return m5621packZIaKswc(size, size);
        }
        throw new IllegalStateException();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        this.measureAndLayoutDelegate.measureAndLayout(this.resendMotionEventOnLayout);
        this.onMeasureConstraints = null;
        updatePositionCacheAndDispatch();
        if (this._androidViewsHandler != null) {
            getAndroidViewsHandler$ui_release().layout(0, 0, r - l, b - t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePositionCacheAndDispatch() {
        getLocationOnScreen(this.tmpPositionArray);
        long j = this.globalPosition;
        int m6509component1impl = IntOffset.m6509component1impl(j);
        int m6510component2impl = IntOffset.m6510component2impl(j);
        int[] iArr = this.tmpPositionArray;
        boolean z = false;
        int i = iArr[0];
        if (m6509component1impl != i || m6510component2impl != iArr[1]) {
            this.globalPosition = IntOffsetKt.IntOffset(i, iArr[1]);
            if (m6509component1impl != Integer.MAX_VALUE && m6510component2impl != Integer.MAX_VALUE) {
                getRoot().getLayoutDelegate().getMeasurePassDelegate().notifyChildrenUsingCoordinatesWhilePlacing();
                z = true;
            }
        }
        this.measureAndLayoutDelegate.dispatchOnPositionedCallbacks(z);
    }

    @Override // androidx.compose.ui.node.Owner
    public OwnedLayer createLayer(Function1<? super androidx.compose.ui.graphics.Canvas, Unit> drawBlock, Function0<Unit> invalidateParentLayer) {
        ViewLayerContainer viewLayerContainer;
        OwnedLayer pop = this.layerCache.pop();
        if (pop != null) {
            pop.reuseLayer(drawBlock, invalidateParentLayer);
            return pop;
        }
        if (isHardwareAccelerated() && this.isRenderNodeCompatible) {
            try {
                return new RenderNodeLayer(this, drawBlock, invalidateParentLayer);
            } catch (Throwable unused) {
                this.isRenderNodeCompatible = false;
            }
        }
        if (this.viewLayersContainer == null) {
            if (!ViewLayer.INSTANCE.getHasRetrievedMethod()) {
                ViewLayer.INSTANCE.updateDisplayList(new View(getContext()));
            }
            if (ViewLayer.INSTANCE.getShouldUseDispatchDraw()) {
                viewLayerContainer = new DrawChildContainer(getContext());
            } else {
                viewLayerContainer = new ViewLayerContainer(getContext());
            }
            this.viewLayersContainer = viewLayerContainer;
            addView(viewLayerContainer);
        }
        DrawChildContainer drawChildContainer = this.viewLayersContainer;
        Intrinsics.checkNotNull(drawChildContainer);
        return new ViewLayer(this, drawChildContainer, drawBlock, invalidateParentLayer);
    }

    public final boolean recycle$ui_release(OwnedLayer layer) {
        if (this.viewLayersContainer != null) {
            ViewLayer.INSTANCE.getShouldUseDispatchDraw();
        }
        this.layerCache.push(layer);
        return true;
    }

    @Override // androidx.compose.ui.node.Owner
    public void onSemanticsChange() {
        this.composeAccessibilityDelegate.onSemanticsChange$ui_release();
    }

    @Override // androidx.compose.ui.node.Owner
    public void onLayoutChange(LayoutNode layoutNode) {
        this.composeAccessibilityDelegate.onLayoutChange$ui_release(layoutNode);
    }

    @Override // androidx.compose.ui.node.Owner
    public void registerOnLayoutCompletedListener(Owner.OnLayoutCompletedListener listener) {
        this.measureAndLayoutDelegate.registerOnLayoutCompletedListener(listener);
        scheduleMeasureAndLayout$default(this, null, 1, null);
    }

    @Override // androidx.compose.ui.node.Owner
    /* renamed from: getFocusDirection-P8AzH3I */
    public FocusDirection mo5594getFocusDirectionP8AzH3I(android.view.KeyEvent keyEvent) {
        long m5071getKeyZmokQxo = KeyEvent_androidKt.m5071getKeyZmokQxo(keyEvent);
        if (Key.m4763equalsimpl0(m5071getKeyZmokQxo, Key.INSTANCE.m4999getTabEK5gGoQ())) {
            return FocusDirection.m3739boximpl(KeyEvent_androidKt.m5077isShiftPressedZmokQxo(keyEvent) ? FocusDirection.INSTANCE.m3753getPreviousdhqQ8s() : FocusDirection.INSTANCE.m3752getNextdhqQ8s());
        }
        if (Key.m4763equalsimpl0(m5071getKeyZmokQxo, Key.INSTANCE.m4840getDirectionRightEK5gGoQ())) {
            return FocusDirection.m3739boximpl(FocusDirection.INSTANCE.m3754getRightdhqQ8s());
        }
        if (Key.m4763equalsimpl0(m5071getKeyZmokQxo, Key.INSTANCE.m4839getDirectionLeftEK5gGoQ())) {
            return FocusDirection.m3739boximpl(FocusDirection.INSTANCE.m3751getLeftdhqQ8s());
        }
        if (Key.m4763equalsimpl0(m5071getKeyZmokQxo, Key.INSTANCE.m4841getDirectionUpEK5gGoQ()) ? true : Key.m4763equalsimpl0(m5071getKeyZmokQxo, Key.INSTANCE.m4952getPageUpEK5gGoQ())) {
            return FocusDirection.m3739boximpl(FocusDirection.INSTANCE.m3755getUpdhqQ8s());
        }
        if (Key.m4763equalsimpl0(m5071getKeyZmokQxo, Key.INSTANCE.m4836getDirectionDownEK5gGoQ()) ? true : Key.m4763equalsimpl0(m5071getKeyZmokQxo, Key.INSTANCE.m4951getPageDownEK5gGoQ())) {
            return FocusDirection.m3739boximpl(FocusDirection.INSTANCE.m3748getDowndhqQ8s());
        }
        if (Key.m4763equalsimpl0(m5071getKeyZmokQxo, Key.INSTANCE.m4835getDirectionCenterEK5gGoQ()) ? true : Key.m4763equalsimpl0(m5071getKeyZmokQxo, Key.INSTANCE.m4849getEnterEK5gGoQ()) ? true : Key.m4763equalsimpl0(m5071getKeyZmokQxo, Key.INSTANCE.m4941getNumPadEnterEK5gGoQ())) {
            return FocusDirection.m3739boximpl(FocusDirection.INSTANCE.m3749getEnterdhqQ8s());
        }
        if (Key.m4763equalsimpl0(m5071getKeyZmokQxo, Key.INSTANCE.m4778getBackEK5gGoQ()) ? true : Key.m4763equalsimpl0(m5071getKeyZmokQxo, Key.INSTANCE.m4852getEscapeEK5gGoQ())) {
            return FocusDirection.m3739boximpl(FocusDirection.INSTANCE.m3750getExitdhqQ8s());
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (!isAttachedToWindow()) {
            invalidateLayers(getRoot());
        }
        Owner.measureAndLayout$default(this, false, 1, null);
        Snapshot.INSTANCE.sendApplyNotifications();
        this.isDrawingContent = true;
        CanvasHolder canvasHolder = this.canvasHolder;
        Canvas internalCanvas = canvasHolder.getAndroidCanvas().getInternalCanvas();
        canvasHolder.getAndroidCanvas().setInternalCanvas(canvas);
        getRoot().draw$ui_release(canvasHolder.getAndroidCanvas());
        canvasHolder.getAndroidCanvas().setInternalCanvas(internalCanvas);
        if (!this.dirtyLayers.isEmpty()) {
            int size = this.dirtyLayers.size();
            for (int i = 0; i < size; i++) {
                this.dirtyLayers.get(i).updateDisplayList();
            }
        }
        if (ViewLayer.INSTANCE.getShouldUseDispatchDraw()) {
            int save = canvas.save();
            canvas.clipRect(0.0f, 0.0f, 0.0f, 0.0f);
            super.dispatchDraw(canvas);
            canvas.restoreToCount(save);
        }
        this.dirtyLayers.clear();
        this.isDrawingContent = false;
        List<OwnedLayer> list = this.postponedDirtyLayers;
        if (list != null) {
            Intrinsics.checkNotNull(list);
            this.dirtyLayers.addAll(list);
            list.clear();
        }
    }

    public final void notifyLayerIsDirty$ui_release(OwnedLayer layer, boolean isDirty) {
        if (!isDirty) {
            if (this.isDrawingContent) {
                return;
            }
            this.dirtyLayers.remove(layer);
            List<OwnedLayer> list = this.postponedDirtyLayers;
            if (list != null) {
                list.remove(layer);
                return;
            }
            return;
        }
        if (!this.isDrawingContent) {
            this.dirtyLayers.add(layer);
            return;
        }
        ArrayList arrayList = this.postponedDirtyLayers;
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.postponedDirtyLayers = arrayList;
        }
        arrayList.add(layer);
    }

    public final void setOnViewTreeOwnersAvailable(Function1<? super ViewTreeOwners, Unit> callback) {
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners != null) {
            callback.invoke(viewTreeOwners);
        }
        if (isAttachedToWindow()) {
            return;
        }
        this.onViewTreeOwnersAvailable = callback;
    }

    public final Object boundsUpdatesEventLoop(Continuation<? super Unit> continuation) {
        Object boundsUpdatesEventLoop$ui_release = this.composeAccessibilityDelegate.boundsUpdatesEventLoop$ui_release(continuation);
        return boundsUpdatesEventLoop$ui_release == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? boundsUpdatesEventLoop$ui_release : Unit.INSTANCE;
    }

    private final void invalidateLayoutNodeMeasurement(LayoutNode node) {
        int i = 0;
        MeasureAndLayoutDelegate.requestRemeasure$default(this.measureAndLayoutDelegate, node, false, 2, null);
        MutableVector<LayoutNode> mutableVector = node.get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            do {
                invalidateLayoutNodeMeasurement(content[i]);
                i++;
            } while (i < size);
        }
    }

    private final void invalidateLayers(LayoutNode node) {
        node.invalidateLayers$ui_release();
        MutableVector<LayoutNode> mutableVector = node.get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i = 0;
            do {
                invalidateLayers(content[i]);
                i++;
            } while (i < size);
        }
    }

    @Override // androidx.compose.ui.platform.ViewRootForTest
    public void invalidateDescendants() {
        invalidateLayers(getRoot());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        AndroidAutofill androidAutofill;
        super.onAttachedToWindow();
        invalidateLayoutNodeMeasurement(getRoot());
        invalidateLayers(getRoot());
        getSnapshotObserver().startObserving$ui_release();
        if (autofillSupported() && (androidAutofill = this._autofill) != null) {
            AutofillCallback.INSTANCE.register(androidAutofill);
        }
        AndroidComposeView androidComposeView = this;
        LifecycleOwner lifecycleOwner2 = ViewTreeLifecycleOwner.get(androidComposeView);
        SavedStateRegistryOwner savedStateRegistryOwner = ViewTreeSavedStateRegistryOwner.get(androidComposeView);
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners == null || (lifecycleOwner2 != null && savedStateRegistryOwner != null && (lifecycleOwner2 != viewTreeOwners.getLifecycleOwner() || savedStateRegistryOwner != viewTreeOwners.getLifecycleOwner()))) {
            if (lifecycleOwner2 == null) {
                throw new IllegalStateException("Composed into the View which doesn't propagate ViewTreeLifecycleOwner!");
            }
            if (savedStateRegistryOwner == null) {
                throw new IllegalStateException("Composed into the View which doesn't propagateViewTreeSavedStateRegistryOwner!");
            }
            if (viewTreeOwners != null && (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
                lifecycle.removeObserver(this);
            }
            lifecycleOwner2.getLifecycle().addObserver(this);
            ViewTreeOwners viewTreeOwners2 = new ViewTreeOwners(lifecycleOwner2, savedStateRegistryOwner);
            set_viewTreeOwners(viewTreeOwners2);
            Function1<? super ViewTreeOwners, Unit> function1 = this.onViewTreeOwnersAvailable;
            if (function1 != null) {
                function1.invoke(viewTreeOwners2);
            }
            this.onViewTreeOwnersAvailable = null;
        }
        this._inputModeManager.m4757setInputModeiuPiT84(isInTouchMode() ? InputMode.INSTANCE.m4754getTouchaOaMEAU() : InputMode.INSTANCE.m4753getKeyboardaOaMEAU());
        ViewTreeOwners viewTreeOwners3 = getViewTreeOwners();
        Intrinsics.checkNotNull(viewTreeOwners3);
        viewTreeOwners3.getLifecycleOwner().getLifecycle().addObserver(this);
        ViewTreeOwners viewTreeOwners4 = getViewTreeOwners();
        Intrinsics.checkNotNull(viewTreeOwners4);
        viewTreeOwners4.getLifecycleOwner().getLifecycle().addObserver(this.composeAccessibilityDelegate);
        getViewTreeObserver().addOnGlobalLayoutListener(this.globalLayoutListener);
        getViewTreeObserver().addOnScrollChangedListener(this.scrollChangedListener);
        getViewTreeObserver().addOnTouchModeChangeListener(this.touchModeChangeListener);
        if (Build.VERSION.SDK_INT >= 31) {
            AndroidComposeViewTranslationCallbackS.INSTANCE.setViewTranslationCallback(androidComposeView, new AndroidComposeViewTranslationCallback());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        AndroidAutofill androidAutofill;
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        LifecycleOwner lifecycleOwner2;
        Lifecycle lifecycle2;
        super.onDetachedFromWindow();
        getSnapshotObserver().stopObserving$ui_release();
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners != null && (lifecycleOwner2 = viewTreeOwners.getLifecycleOwner()) != null && (lifecycle2 = lifecycleOwner2.getLifecycle()) != null) {
            lifecycle2.removeObserver(this);
        }
        ViewTreeOwners viewTreeOwners2 = getViewTreeOwners();
        if (viewTreeOwners2 != null && (lifecycleOwner = viewTreeOwners2.getLifecycleOwner()) != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.removeObserver(this.composeAccessibilityDelegate);
        }
        if (autofillSupported() && (androidAutofill = this._autofill) != null) {
            AutofillCallback.INSTANCE.unregister(androidAutofill);
        }
        getViewTreeObserver().removeOnGlobalLayoutListener(this.globalLayoutListener);
        getViewTreeObserver().removeOnScrollChangedListener(this.scrollChangedListener);
        getViewTreeObserver().removeOnTouchModeChangeListener(this.touchModeChangeListener);
        if (Build.VERSION.SDK_INT >= 31) {
            AndroidComposeViewTranslationCallbackS.INSTANCE.clearViewTranslationCallback(this);
        }
    }

    @Override // android.view.View
    public void onProvideAutofillVirtualStructure(ViewStructure structure, int flags) {
        AndroidAutofill androidAutofill;
        if (!autofillSupported() || structure == null || (androidAutofill = this._autofill) == null) {
            return;
        }
        AndroidAutofill_androidKt.populateViewStructure(androidAutofill, structure);
    }

    @Override // android.view.View
    public void autofill(SparseArray<AutofillValue> values) {
        AndroidAutofill androidAutofill;
        if (!autofillSupported() || (androidAutofill = this._autofill) == null) {
            return;
        }
        AndroidAutofill_androidKt.performAutofill(androidAutofill, values);
    }

    @Override // android.view.View
    public void onCreateVirtualViewTranslationRequests(long[] virtualIds, int[] supportedFormats, Consumer<ViewTranslationRequest> requestsCollector) {
        this.composeAccessibilityDelegate.onCreateVirtualViewTranslationRequests$ui_release(virtualIds, supportedFormats, requestsCollector);
    }

    @Override // android.view.View
    public void onVirtualViewTranslationResponses(LongSparseArray<ViewTranslationResponse> response) {
        this.composeAccessibilityDelegate.onVirtualViewTranslationResponses$ui_release(response);
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent event) {
        if (event.getActionMasked() == 8) {
            if (event.isFromSource(4194304)) {
                return handleRotaryEvent(event);
            }
            if (isBadMotionEvent(event) || !isAttachedToWindow()) {
                return super.dispatchGenericMotionEvent(event);
            }
            return ProcessResult.m5296getDispatchedToAPointerInputModifierimpl(m5620handleMotionEvent8iAsVTc(event));
        }
        return super.dispatchGenericMotionEvent(event);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            MotionEvent motionEvent2 = this.previousMotionEvent;
            Intrinsics.checkNotNull(motionEvent2);
            if (motionEvent.getActionMasked() != 0 || hasChangedDevices(motionEvent, motionEvent2)) {
                this.sendHoverExitEvent.run();
            } else {
                this.hoverExitReceived = false;
            }
        }
        if (isBadMotionEvent(motionEvent) || !isAttachedToWindow()) {
            return false;
        }
        if (motionEvent.getActionMasked() == 2 && !isPositionChanged(motionEvent)) {
            return false;
        }
        int m5620handleMotionEvent8iAsVTc = m5620handleMotionEvent8iAsVTc(motionEvent);
        if (ProcessResult.m5295getAnyMovementConsumedimpl(m5620handleMotionEvent8iAsVTc)) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return ProcessResult.m5296getDispatchedToAPointerInputModifierimpl(m5620handleMotionEvent8iAsVTc);
    }

    private final boolean handleRotaryEvent(MotionEvent event) {
        android.view.ViewConfiguration viewConfiguration = android.view.ViewConfiguration.get(getContext());
        float f = -event.getAxisValue(26);
        return getFocusOwner().dispatchRotaryEvent(new RotaryScrollEvent(ViewConfigurationCompat.getScaledVerticalScrollFactor(viewConfiguration, getContext()) * f, f * ViewConfigurationCompat.getScaledHorizontalScrollFactor(viewConfiguration, getContext()), event.getEventTime(), event.getDeviceId()));
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0082 A[Catch: all -> 0x0095, TryCatch #0 {all -> 0x0095, blocks: (B:5:0x0018, B:7:0x0021, B:11:0x002c, B:13:0x0032, B:15:0x0038, B:16:0x003e, B:19:0x0048, B:20:0x0059, B:28:0x006b, B:30:0x0071, B:32:0x0082, B:33:0x0085), top: B:4:0x0018, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0060  */
    /* renamed from: handleMotionEvent-8iAsVTc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int m5620handleMotionEvent8iAsVTc(MotionEvent motionEvent) {
        MotionEvent motionEvent2;
        removeCallbacks(this.resendMotionEventRunnable);
        try {
            recalculateWindowPosition(motionEvent);
            boolean z = true;
            this.forceUseMatrixCache = true;
            measureAndLayout(false);
            Trace.beginSection("AndroidOwner:onTouch");
            try {
                int actionMasked = motionEvent.getActionMasked();
                MotionEvent motionEvent3 = this.previousMotionEvent;
                boolean z2 = motionEvent3 != null && motionEvent3.getToolType(0) == 3;
                if (motionEvent3 != null && hasChangedDevices(motionEvent, motionEvent3)) {
                    if (isDevicePressEvent(motionEvent3)) {
                        this.pointerInputEventProcessor.processCancel();
                    } else if (motionEvent3.getActionMasked() != 10 && z2) {
                        sendSimulatedEvent$default(this, motionEvent3, 10, motionEvent3.getEventTime(), false, 8, null);
                        motionEvent2 = motionEvent3;
                        if (motionEvent.getToolType(0) == 3) {
                            z = false;
                        }
                        if (!z2 && z && actionMasked != 3 && actionMasked != 9 && isInBounds(motionEvent)) {
                            sendSimulatedEvent$default(this, motionEvent, 9, motionEvent.getEventTime(), false, 8, null);
                        }
                        if (motionEvent2 != null) {
                            motionEvent2.recycle();
                        }
                        this.previousMotionEvent = MotionEvent.obtainNoHistory(motionEvent);
                        return m5622sendMotionEvent8iAsVTc(motionEvent);
                    }
                }
                motionEvent2 = motionEvent3;
                if (motionEvent.getToolType(0) == 3) {
                }
                if (!z2) {
                    sendSimulatedEvent$default(this, motionEvent, 9, motionEvent.getEventTime(), false, 8, null);
                }
                if (motionEvent2 != null) {
                }
                this.previousMotionEvent = MotionEvent.obtainNoHistory(motionEvent);
                return m5622sendMotionEvent8iAsVTc(motionEvent);
            } finally {
                Trace.endSection();
            }
        } finally {
            this.forceUseMatrixCache = false;
        }
    }

    private final boolean hasChangedDevices(MotionEvent event, MotionEvent lastEvent) {
        return (lastEvent.getSource() == event.getSource() && lastEvent.getToolType(0) == event.getToolType(0)) ? false : true;
    }

    private final boolean isDevicePressEvent(MotionEvent event) {
        int actionMasked;
        return event.getButtonState() != 0 || (actionMasked = event.getActionMasked()) == 0 || actionMasked == 2 || actionMasked == 6;
    }

    /* renamed from: sendMotionEvent-8iAsVTc, reason: not valid java name */
    private final int m5622sendMotionEvent8iAsVTc(MotionEvent motionEvent) {
        PointerInputEventData pointerInputEventData;
        if (this.keyboardModifiersRequireUpdate) {
            this.keyboardModifiersRequireUpdate = false;
            this._windowInfo.m5698setKeyboardModifiers5xRPYO0(PointerKeyboardModifiers.m5270constructorimpl(motionEvent.getMetaState()));
        }
        AndroidComposeView androidComposeView = this;
        PointerInputEvent convertToPointerInputEvent$ui_release = this.motionEventAdapter.convertToPointerInputEvent$ui_release(motionEvent, androidComposeView);
        if (convertToPointerInputEvent$ui_release != null) {
            List<PointerInputEventData> pointers = convertToPointerInputEvent$ui_release.getPointers();
            int size = pointers.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i = size - 1;
                    pointerInputEventData = pointers.get(size);
                    if (pointerInputEventData.getDown()) {
                        break;
                    }
                    if (i < 0) {
                        break;
                    }
                    size = i;
                }
            }
            pointerInputEventData = null;
            PointerInputEventData pointerInputEventData2 = pointerInputEventData;
            if (pointerInputEventData2 != null) {
                this.lastDownPointerPosition = pointerInputEventData2.m5224getPositionF1C5BW0();
            }
            int m5229processBIzXfog = this.pointerInputEventProcessor.m5229processBIzXfog(convertToPointerInputEvent$ui_release, androidComposeView, isInBounds(motionEvent));
            int actionMasked = motionEvent.getActionMasked();
            if ((actionMasked == 0 || actionMasked == 5) && !ProcessResult.m5296getDispatchedToAPointerInputModifierimpl(m5229processBIzXfog)) {
                this.motionEventAdapter.endStream(motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
            return m5229processBIzXfog;
        }
        this.pointerInputEventProcessor.processCancel();
        return PointerInputEventProcessorKt.ProcessResult(false, false);
    }

    static /* synthetic */ void sendSimulatedEvent$default(AndroidComposeView androidComposeView, MotionEvent motionEvent, int i, long j, boolean z, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z = true;
        }
        androidComposeView.sendSimulatedEvent(motionEvent, i, j, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendSimulatedEvent(MotionEvent motionEvent, int action, long eventTime, boolean forceHover) {
        int actionMasked = motionEvent.getActionMasked();
        int i = -1;
        if (actionMasked != 1) {
            if (actionMasked == 6) {
                i = motionEvent.getActionIndex();
            }
        } else if (action != 9 && action != 10) {
            i = 0;
        }
        int pointerCount = motionEvent.getPointerCount() - (i >= 0 ? 1 : 0);
        if (pointerCount == 0) {
            return;
        }
        MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[pointerCount];
        for (int i2 = 0; i2 < pointerCount; i2++) {
            pointerPropertiesArr[i2] = new MotionEvent.PointerProperties();
        }
        MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[pointerCount];
        for (int i3 = 0; i3 < pointerCount; i3++) {
            pointerCoordsArr[i3] = new MotionEvent.PointerCoords();
        }
        int i4 = 0;
        while (i4 < pointerCount) {
            int i5 = ((i < 0 || i4 < i) ? 0 : 1) + i4;
            motionEvent.getPointerProperties(i5, pointerPropertiesArr[i4]);
            MotionEvent.PointerCoords pointerCoords = pointerCoordsArr[i4];
            motionEvent.getPointerCoords(i5, pointerCoords);
            long mo5289localToScreenMKHz9U = mo5289localToScreenMKHz9U(OffsetKt.Offset(pointerCoords.x, pointerCoords.y));
            pointerCoords.x = Offset.m3822getXimpl(mo5289localToScreenMKHz9U);
            pointerCoords.y = Offset.m3823getYimpl(mo5289localToScreenMKHz9U);
            i4++;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent.getDownTime() == motionEvent.getEventTime() ? eventTime : motionEvent.getDownTime(), eventTime, action, pointerCount, pointerPropertiesArr, pointerCoordsArr, motionEvent.getMetaState(), forceHover ? 0 : motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
        AndroidComposeView androidComposeView = this;
        PointerInputEvent convertToPointerInputEvent$ui_release = this.motionEventAdapter.convertToPointerInputEvent$ui_release(obtain, androidComposeView);
        Intrinsics.checkNotNull(convertToPointerInputEvent$ui_release);
        this.pointerInputEventProcessor.m5229processBIzXfog(convertToPointerInputEvent$ui_release, androidComposeView, true);
        obtain.recycle();
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int direction) {
        return this.composeAccessibilityDelegate.m5631canScroll0AR0LA0$ui_release(false, direction, this.lastDownPointerPosition);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int direction) {
        return this.composeAccessibilityDelegate.m5631canScroll0AR0LA0$ui_release(true, direction, this.lastDownPointerPosition);
    }

    private final boolean isInBounds(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        return 0.0f <= x && x <= ((float) getWidth()) && 0.0f <= y && y <= ((float) getHeight());
    }

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    /* renamed from: localToScreen-MK-Hz9U */
    public long mo5289localToScreenMKHz9U(long localPosition) {
        recalculateWindowPosition();
        long m4300mapMKHz9U = Matrix.m4300mapMKHz9U(this.viewToWindowMatrix, localPosition);
        return OffsetKt.Offset(Offset.m3822getXimpl(m4300mapMKHz9U) + Offset.m3822getXimpl(this.windowPosition), Offset.m3823getYimpl(m4300mapMKHz9U) + Offset.m3823getYimpl(this.windowPosition));
    }

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    /* renamed from: localToScreen-58bKbWc */
    public void mo5288localToScreen58bKbWc(float[] localTransform) {
        recalculateWindowPosition();
        Matrix.m4311timesAssign58bKbWc(localTransform, this.viewToWindowMatrix);
        AndroidComposeView_androidKt.m5638preTranslatecG2Xzmc(localTransform, Offset.m3822getXimpl(this.windowPosition), Offset.m3823getYimpl(this.windowPosition), this.tmpMatrix);
    }

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    /* renamed from: screenToLocal-MK-Hz9U */
    public long mo5290screenToLocalMKHz9U(long positionOnScreen) {
        recalculateWindowPosition();
        return Matrix.m4300mapMKHz9U(this.windowToViewMatrix, OffsetKt.Offset(Offset.m3822getXimpl(positionOnScreen) - Offset.m3822getXimpl(this.windowPosition), Offset.m3823getYimpl(positionOnScreen) - Offset.m3823getYimpl(this.windowPosition)));
    }

    private final void recalculateWindowPosition() {
        if (this.forceUseMatrixCache) {
            return;
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (currentAnimationTimeMillis != this.lastMatrixRecalculationAnimationTime) {
            this.lastMatrixRecalculationAnimationTime = currentAnimationTimeMillis;
            recalculateWindowViewTransforms();
            ViewParent parent = getParent();
            AndroidComposeView androidComposeView = this;
            while (parent instanceof ViewGroup) {
                androidComposeView = (View) parent;
                parent = ((ViewGroup) androidComposeView).getParent();
            }
            androidComposeView.getLocationOnScreen(this.tmpPositionArray);
            int[] iArr = this.tmpPositionArray;
            float f = iArr[0];
            float f2 = iArr[1];
            androidComposeView.getLocationInWindow(iArr);
            int[] iArr2 = this.tmpPositionArray;
            this.windowPosition = OffsetKt.Offset(f - iArr2[0], f2 - iArr2[1]);
        }
    }

    private final void recalculateWindowPosition(MotionEvent motionEvent) {
        this.lastMatrixRecalculationAnimationTime = AnimationUtils.currentAnimationTimeMillis();
        recalculateWindowViewTransforms();
        long m4300mapMKHz9U = Matrix.m4300mapMKHz9U(this.viewToWindowMatrix, OffsetKt.Offset(motionEvent.getX(), motionEvent.getY()));
        this.windowPosition = OffsetKt.Offset(motionEvent.getRawX() - Offset.m3822getXimpl(m4300mapMKHz9U), motionEvent.getRawY() - Offset.m3823getYimpl(m4300mapMKHz9U));
    }

    private final void recalculateWindowViewTransforms() {
        this.matrixToWindow.mo5639calculateMatrixToWindowEL8BTi8(this, this.viewToWindowMatrix);
        InvertMatrixKt.m5663invertToJiSxe2E(this.viewToWindowMatrix, this.windowToViewMatrix);
    }

    @Override // android.view.View
    public boolean onCheckIsTextEditor() {
        AndroidPlatformTextInputSession androidPlatformTextInputSession = (AndroidPlatformTextInputSession) SessionMutex.m3706getCurrentSessionimpl(this.textInputSessionMutex);
        if (androidPlatformTextInputSession == null) {
            return this.legacyTextInputServiceAndroid.getEditorHasFocus();
        }
        return androidPlatformTextInputSession.isReadyForConnection();
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        AndroidPlatformTextInputSession androidPlatformTextInputSession = (AndroidPlatformTextInputSession) SessionMutex.m3706getCurrentSessionimpl(this.textInputSessionMutex);
        if (androidPlatformTextInputSession == null) {
            return this.legacyTextInputServiceAndroid.createInputConnection(outAttrs);
        }
        return androidPlatformTextInputSession.createInputConnection(outAttrs);
    }

    @Override // androidx.compose.ui.node.Owner
    /* renamed from: calculateLocalPosition-MK-Hz9U */
    public long mo5592calculateLocalPositionMKHz9U(long positionInWindow) {
        recalculateWindowPosition();
        return Matrix.m4300mapMKHz9U(this.windowToViewMatrix, positionInWindow);
    }

    @Override // androidx.compose.ui.node.Owner
    /* renamed from: calculatePositionInWindow-MK-Hz9U */
    public long mo5593calculatePositionInWindowMKHz9U(long localPosition) {
        recalculateWindowPosition();
        return Matrix.m4300mapMKHz9U(this.viewToWindowMatrix, localPosition);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this.density = AndroidDensity_androidKt.Density(getContext());
        if (getFontWeightAdjustmentCompat(newConfig) != this.currentFontWeightAdjustment) {
            this.currentFontWeightAdjustment = getFontWeightAdjustmentCompat(newConfig);
            setFontFamilyResolver(FontFamilyResolver_androidKt.createFontFamilyResolver(getContext()));
        }
        this.configurationChangeObserver.invoke(newConfig);
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int layoutDirection) {
        LayoutDirection layoutDirectionFromInt;
        if (this.superclassInitComplete) {
            layoutDirectionFromInt = AndroidComposeView_androidKt.layoutDirectionFromInt(layoutDirection);
            setLayoutDirection(layoutDirectionFromInt);
            getFocusOwner().setLayoutDirection(layoutDirectionFromInt);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchHoverEvent(MotionEvent event) {
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            this.sendHoverExitEvent.run();
        }
        if (isBadMotionEvent(event) || !isAttachedToWindow()) {
            return false;
        }
        this.composeAccessibilityDelegate.dispatchHoverEvent$ui_release(event);
        int actionMasked = event.getActionMasked();
        if (actionMasked != 7) {
            if (actionMasked == 10 && isInBounds(event)) {
                if (event.getToolType(0) == 3 && event.getButtonState() != 0) {
                    return false;
                }
                MotionEvent motionEvent = this.previousMotionEvent;
                if (motionEvent != null) {
                    motionEvent.recycle();
                }
                this.previousMotionEvent = MotionEvent.obtainNoHistory(event);
                this.hoverExitReceived = true;
                post(this.sendHoverExitEvent);
                return false;
            }
        } else if (!isPositionChanged(event)) {
            return false;
        }
        return ProcessResult.m5296getDispatchedToAPointerInputModifierimpl(m5620handleMotionEvent8iAsVTc(event));
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0082 A[LOOP:0: B:20:0x004c->B:35:0x0082, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0085 A[EDGE_INSN: B:36:0x0085->B:39:0x0085 BREAK  A[LOOP:0: B:20:0x004c->B:35:0x0082], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean isBadMotionEvent(MotionEvent event) {
        boolean z;
        float x = event.getX();
        if (!Float.isInfinite(x) && !Float.isNaN(x)) {
            float y = event.getY();
            if (!Float.isInfinite(y) && !Float.isNaN(y)) {
                float rawX = event.getRawX();
                if (!Float.isInfinite(rawX) && !Float.isNaN(rawX)) {
                    float rawY = event.getRawY();
                    if (!Float.isInfinite(rawY) && !Float.isNaN(rawY)) {
                        z = false;
                        if (!z) {
                            int pointerCount = event.getPointerCount();
                            for (int i = 1; i < pointerCount; i++) {
                                float x2 = event.getX(i);
                                if (!Float.isInfinite(x2) && !Float.isNaN(x2)) {
                                    float y2 = event.getY(i);
                                    if (!Float.isInfinite(y2) && !Float.isNaN(y2) && (Build.VERSION.SDK_INT < 29 || MotionEventVerifierApi29.INSTANCE.isValidMotionEvent(event, i))) {
                                        z = false;
                                        if (!z) {
                                            break;
                                        }
                                    }
                                }
                                z = true;
                                if (!z) {
                                }
                            }
                        }
                        return z;
                    }
                }
            }
        }
        z = true;
        if (!z) {
        }
        return z;
    }

    private final boolean isPositionChanged(MotionEvent event) {
        MotionEvent motionEvent;
        return (event.getPointerCount() == 1 && (motionEvent = this.previousMotionEvent) != null && motionEvent.getPointerCount() == event.getPointerCount() && event.getRawX() == motionEvent.getRawX() && event.getRawY() == motionEvent.getRawY()) ? false : true;
    }

    private final View findViewByAccessibilityIdRootedAtCurrentView(int accessibilityId, View currentView) {
        if (Build.VERSION.SDK_INT >= 29) {
            return null;
        }
        Method declaredMethod = Class.forName(AndroidComposeViewAccessibilityDelegateCompat.ClassName).getDeclaredMethod("getAccessibilityViewId", new Class[0]);
        declaredMethod.setAccessible(true);
        if (Intrinsics.areEqual(declaredMethod.invoke(currentView, new Object[0]), Integer.valueOf(accessibilityId))) {
            return currentView;
        }
        if (!(currentView instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) currentView;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View findViewByAccessibilityIdRootedAtCurrentView = findViewByAccessibilityIdRootedAtCurrentView(accessibilityId, viewGroup.getChildAt(i));
            if (findViewByAccessibilityIdRootedAtCurrentView != null) {
                return findViewByAccessibilityIdRootedAtCurrentView;
            }
        }
        return null;
    }

    @Override // androidx.compose.ui.node.Owner
    public PointerIconService getPointerIconService() {
        return this.pointerIconService;
    }

    public final View findViewByAccessibilityIdTraversal(int accessibilityId) {
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                Method declaredMethod = Class.forName(AndroidComposeViewAccessibilityDelegateCompat.ClassName).getDeclaredMethod("findViewByAccessibilityIdTraversal", Integer.TYPE);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(this, Integer.valueOf(accessibilityId));
                if (invoke instanceof View) {
                    return (View) invoke;
                }
                return null;
            }
            return findViewByAccessibilityIdRootedAtCurrentView(accessibilityId, this);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // androidx.compose.ui.platform.ViewRootForTest
    public boolean isLifecycleInResumedState() {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        return ((viewTreeOwners == null || (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) == null || (lifecycle = lifecycleOwner.getLifecycle()) == null) ? null : lifecycle.getState()) == Lifecycle.State.RESUMED;
    }

    /* compiled from: AndroidComposeView.android.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeView$Companion;", "", "()V", "FocusTag", "", "MaximumLayerCacheSize", "", "getBooleanMethod", "Ljava/lang/reflect/Method;", "systemPropertiesClass", "Ljava/lang/Class;", "getIsShowingLayoutBounds", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean getIsShowingLayoutBounds() {
            try {
                if (AndroidComposeView.systemPropertiesClass == null) {
                    AndroidComposeView.systemPropertiesClass = Class.forName("android.os.SystemProperties");
                    Class cls = AndroidComposeView.systemPropertiesClass;
                    AndroidComposeView.getBooleanMethod = cls != null ? cls.getDeclaredMethod("getBoolean", String.class, Boolean.TYPE) : null;
                }
                Method method = AndroidComposeView.getBooleanMethod;
                Object invoke = method != null ? method.invoke(null, "debug.layout", false) : null;
                Boolean bool = invoke instanceof Boolean ? (Boolean) invoke : null;
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    /* compiled from: AndroidComposeView.android.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "savedStateRegistryOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/savedstate/SavedStateRegistryOwner;)V", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "getSavedStateRegistryOwner", "()Landroidx/savedstate/SavedStateRegistryOwner;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ViewTreeOwners {
        public static final int $stable = 8;
        private final LifecycleOwner lifecycleOwner;
        private final SavedStateRegistryOwner savedStateRegistryOwner;

        public ViewTreeOwners(LifecycleOwner lifecycleOwner, SavedStateRegistryOwner savedStateRegistryOwner) {
            this.lifecycleOwner = lifecycleOwner;
            this.savedStateRegistryOwner = savedStateRegistryOwner;
        }

        public final LifecycleOwner getLifecycleOwner() {
            return this.lifecycleOwner;
        }

        public final SavedStateRegistryOwner getSavedStateRegistryOwner() {
            return this.savedStateRegistryOwner;
        }
    }

    /* compiled from: AndroidComposeView.android.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeView$AndroidComposeViewTranslationCallback;", "Landroid/view/translation/ViewTranslationCallback;", "()V", "onClearTranslation", "", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Landroid/view/View;", "onHideTranslation", "onShowTranslation", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class AndroidComposeViewTranslationCallback implements ViewTranslationCallback {
        @Override // android.view.translation.ViewTranslationCallback
        public boolean onShowTranslation(View view) {
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type androidx.compose.ui.platform.AndroidComposeView");
            ((AndroidComposeView) view).composeAccessibilityDelegate.onShowTranslation$ui_release();
            return true;
        }

        @Override // android.view.translation.ViewTranslationCallback
        public boolean onHideTranslation(View view) {
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type androidx.compose.ui.platform.AndroidComposeView");
            ((AndroidComposeView) view).composeAccessibilityDelegate.onHideTranslation$ui_release();
            return true;
        }

        @Override // android.view.translation.ViewTranslationCallback
        public boolean onClearTranslation(View view) {
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type androidx.compose.ui.platform.AndroidComposeView");
            ((AndroidComposeView) view).composeAccessibilityDelegate.onClearTranslation$ui_release();
            return true;
        }
    }
}
