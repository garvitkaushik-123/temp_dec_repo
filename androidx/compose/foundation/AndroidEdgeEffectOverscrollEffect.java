package androidx.compose.foundation;

import android.content.Context;
import android.widget.EdgeEffect;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;

/* compiled from: AndroidOverscroll.android.kt */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u00105\u001a\u00020+H\u0002J?\u00106\u001a\u00020+2\u0006\u00107\u001a\u0002082\"\u00109\u001a\u001e\b\u0001\u0012\u0004\u0012\u000208\u0012\n\u0012\b\u0012\u0004\u0012\u0002080;\u0012\u0006\u0012\u0004\u0018\u00010<0:H\u0096@ø\u0001\u0000¢\u0006\u0004\b=\u0010>J6\u0010?\u001a\u00020/2\u0006\u0010@\u001a\u00020/2\u0006\u0010A\u001a\u00020B2\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/0)H\u0016ø\u0001\u0000¢\u0006\u0004\bD\u0010EJ\b\u0010F\u001a\u00020+H\u0002J\"\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020/2\u0006\u0010J\u001a\u00020/H\u0002ø\u0001\u0000¢\u0006\u0004\bK\u0010LJ\"\u0010M\u001a\u00020H2\u0006\u0010I\u001a\u00020/2\u0006\u0010J\u001a\u00020/H\u0002ø\u0001\u0000¢\u0006\u0004\bN\u0010LJ\"\u0010O\u001a\u00020H2\u0006\u0010I\u001a\u00020/2\u0006\u0010J\u001a\u00020/H\u0002ø\u0001\u0000¢\u0006\u0004\bP\u0010LJ\"\u0010Q\u001a\u00020H2\u0006\u0010I\u001a\u00020/2\u0006\u0010J\u001a\u00020/H\u0002ø\u0001\u0000¢\u0006\u0004\bR\u0010LJ\u001a\u0010S\u001a\u00020\u001e2\u0006\u0010@\u001a\u00020/H\u0002ø\u0001\u0000¢\u0006\u0004\bT\u0010UJ\b\u0010V\u001a\u00020\u001eH\u0002J \u0010W\u001a\u00020\u001e*\u00020X2\u0006\u0010Y\u001a\u00020\t2\n\u0010Z\u001a\u00060[j\u0002`\\H\u0002J \u0010]\u001a\u00020\u001e*\u00020X2\u0006\u0010^\u001a\u00020\t2\n\u0010Z\u001a\u00060[j\u0002`\\H\u0002J\n\u0010_\u001a\u00020+*\u00020XJ \u0010`\u001a\u00020\u001e*\u00020X2\u0006\u0010a\u001a\u00020\t2\n\u0010Z\u001a\u00060[j\u0002`\\H\u0002J \u0010b\u001a\u00020\u001e*\u00020X2\u0006\u0010c\u001a\u00020\t2\n\u0010Z\u001a\u00060[j\u0002`\\H\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\u00020\u000fX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R+\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\r8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001d\u001a\u00020\u001e8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\"R\u000e\u0010&\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u0016\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006d"}, d2 = {"Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;", "Landroidx/compose/foundation/OverscrollEffect;", "context", "Landroid/content/Context;", "overscrollConfig", "Landroidx/compose/foundation/OverscrollConfiguration;", "(Landroid/content/Context;Landroidx/compose/foundation/OverscrollConfiguration;)V", "allEffects", "", "Landroid/widget/EdgeEffect;", "bottomEffect", "bottomEffectNegation", "consumeCount", "", "containerSize", "Landroidx/compose/ui/geometry/Size;", "J", "effectModifier", "Landroidx/compose/ui/Modifier;", "getEffectModifier", "()Landroidx/compose/ui/Modifier;", "<set-?>", "invalidateCount", "getInvalidateCount", "()I", "setInvalidateCount", "(I)V", "invalidateCount$delegate", "Landroidx/compose/runtime/MutableIntState;", "invalidationEnabled", "", "getInvalidationEnabled$foundation_release$annotations", "()V", "getInvalidationEnabled$foundation_release", "()Z", "setInvalidationEnabled$foundation_release", "(Z)V", "isInProgress", "leftEffect", "leftEffectNegation", "onNewSize", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/IntSize;", "", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "rightEffect", "rightEffectNegation", "scrollCycleInProgress", "topEffect", "topEffectNegation", "animateToRelease", "applyToFling", "velocity", "Landroidx/compose/ui/unit/Velocity;", "performFling", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "applyToFling-BMRW4eQ", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyToScroll", "delta", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "performScroll", "applyToScroll-Rhakbz0", "(JILkotlin/jvm/functions/Function1;)J", "invalidateOverscroll", "pullBottom", "", "scroll", "displacement", "pullBottom-0a9Yr6o", "(JJ)F", "pullLeft", "pullLeft-0a9Yr6o", "pullRight", "pullRight-0a9Yr6o", "pullTop", "pullTop-0a9Yr6o", "releaseOppositeOverscroll", "releaseOppositeOverscroll-k-4lQ0M", "(J)Z", "stopOverscrollAnimation", "drawBottom", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "bottom", "canvas", "Landroid/graphics/Canvas;", "Landroidx/compose/ui/graphics/NativeCanvas;", "drawLeft", "left", "drawOverscroll", "drawRight", "right", "drawTop", "top", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidEdgeEffectOverscrollEffect implements OverscrollEffect {
    public static final int $stable = 0;
    private final List<EdgeEffect> allEffects;
    private final EdgeEffect bottomEffect;
    private final EdgeEffect bottomEffectNegation;
    private int consumeCount;
    private long containerSize;
    private final Modifier effectModifier;

    /* renamed from: invalidateCount$delegate, reason: from kotlin metadata */
    private final MutableIntState invalidateCount;
    private boolean invalidationEnabled;
    private final EdgeEffect leftEffect;
    private final EdgeEffect leftEffectNegation;
    private final Function1<IntSize, Unit> onNewSize;
    private final OverscrollConfiguration overscrollConfig;
    private PointerId pointerId;
    private Offset pointerPosition;
    private final EdgeEffect rightEffect;
    private final EdgeEffect rightEffectNegation;
    private boolean scrollCycleInProgress;
    private final EdgeEffect topEffect;
    private final EdgeEffect topEffectNegation;

    public static /* synthetic */ void getInvalidationEnabled$foundation_release$annotations() {
    }

    public AndroidEdgeEffectOverscrollEffect(Context context, OverscrollConfiguration overscrollConfiguration) {
        Modifier modifier;
        this.overscrollConfig = overscrollConfiguration;
        EdgeEffect create = EdgeEffectCompat.INSTANCE.create(context, null);
        this.topEffect = create;
        EdgeEffect create2 = EdgeEffectCompat.INSTANCE.create(context, null);
        this.bottomEffect = create2;
        EdgeEffect create3 = EdgeEffectCompat.INSTANCE.create(context, null);
        this.leftEffect = create3;
        EdgeEffect create4 = EdgeEffectCompat.INSTANCE.create(context, null);
        this.rightEffect = create4;
        List<EdgeEffect> listOf = CollectionsKt.listOf((Object[]) new EdgeEffect[]{create3, create, create4, create2});
        this.allEffects = listOf;
        this.topEffectNegation = EdgeEffectCompat.INSTANCE.create(context, null);
        this.bottomEffectNegation = EdgeEffectCompat.INSTANCE.create(context, null);
        this.leftEffectNegation = EdgeEffectCompat.INSTANCE.create(context, null);
        this.rightEffectNegation = EdgeEffectCompat.INSTANCE.create(context, null);
        int size = listOf.size();
        for (int i = 0; i < size; i++) {
            listOf.get(i).setColor(ColorKt.m4117toArgb8_81llA(this.overscrollConfig.getGlowColor()));
        }
        this.consumeCount = -1;
        this.invalidateCount = SnapshotIntStateKt.mutableIntStateOf(0);
        this.invalidationEnabled = true;
        this.containerSize = Size.INSTANCE.m3900getZeroNHjbRc();
        Function1<IntSize, Unit> function1 = new Function1<IntSize, Unit>() { // from class: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$onNewSize$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                m509invokeozmzZPI(intSize.getPackedValue());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-ozmzZPI, reason: not valid java name */
            public final void m509invokeozmzZPI(long j) {
                long j2;
                EdgeEffect edgeEffect;
                EdgeEffect edgeEffect2;
                EdgeEffect edgeEffect3;
                EdgeEffect edgeEffect4;
                EdgeEffect edgeEffect5;
                EdgeEffect edgeEffect6;
                EdgeEffect edgeEffect7;
                EdgeEffect edgeEffect8;
                long m6569toSizeozmzZPI = IntSizeKt.m6569toSizeozmzZPI(j);
                j2 = AndroidEdgeEffectOverscrollEffect.this.containerSize;
                boolean m3887equalsimpl0 = Size.m3887equalsimpl0(m6569toSizeozmzZPI, j2);
                AndroidEdgeEffectOverscrollEffect.this.containerSize = IntSizeKt.m6569toSizeozmzZPI(j);
                if (!m3887equalsimpl0) {
                    edgeEffect = AndroidEdgeEffectOverscrollEffect.this.topEffect;
                    edgeEffect.setSize(IntSize.m6559getWidthimpl(j), IntSize.m6558getHeightimpl(j));
                    edgeEffect2 = AndroidEdgeEffectOverscrollEffect.this.bottomEffect;
                    edgeEffect2.setSize(IntSize.m6559getWidthimpl(j), IntSize.m6558getHeightimpl(j));
                    edgeEffect3 = AndroidEdgeEffectOverscrollEffect.this.leftEffect;
                    edgeEffect3.setSize(IntSize.m6558getHeightimpl(j), IntSize.m6559getWidthimpl(j));
                    edgeEffect4 = AndroidEdgeEffectOverscrollEffect.this.rightEffect;
                    edgeEffect4.setSize(IntSize.m6558getHeightimpl(j), IntSize.m6559getWidthimpl(j));
                    edgeEffect5 = AndroidEdgeEffectOverscrollEffect.this.topEffectNegation;
                    edgeEffect5.setSize(IntSize.m6559getWidthimpl(j), IntSize.m6558getHeightimpl(j));
                    edgeEffect6 = AndroidEdgeEffectOverscrollEffect.this.bottomEffectNegation;
                    edgeEffect6.setSize(IntSize.m6559getWidthimpl(j), IntSize.m6558getHeightimpl(j));
                    edgeEffect7 = AndroidEdgeEffectOverscrollEffect.this.leftEffectNegation;
                    edgeEffect7.setSize(IntSize.m6558getHeightimpl(j), IntSize.m6559getWidthimpl(j));
                    edgeEffect8 = AndroidEdgeEffectOverscrollEffect.this.rightEffectNegation;
                    edgeEffect8.setSize(IntSize.m6558getHeightimpl(j), IntSize.m6559getWidthimpl(j));
                }
                if (m3887equalsimpl0) {
                    return;
                }
                AndroidEdgeEffectOverscrollEffect.this.invalidateOverscroll();
                AndroidEdgeEffectOverscrollEffect.this.animateToRelease();
            }
        };
        this.onNewSize = function1;
        Modifier.Companion companion = Modifier.INSTANCE;
        modifier = AndroidOverscroll_androidKt.StretchOverscrollNonClippingLayer;
        this.effectModifier = OnRemeasuredModifierKt.onSizeChanged(SuspendingPointerInputFilterKt.pointerInput(companion.then(modifier), Unit.INSTANCE, new AndroidEdgeEffectOverscrollEffect$effectModifier$1(this, null)), function1).then(new DrawOverscrollModifier(this, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$special$$inlined$debugInspectorInfo$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("overscroll");
                inspectorInfo.setValue(AndroidEdgeEffectOverscrollEffect.this);
            }
        } : InspectableValueKt.getNoInspectorInfo()));
    }

    private final int getInvalidateCount() {
        return this.invalidateCount.getIntValue();
    }

    private final void setInvalidateCount(int i) {
        this.invalidateCount.setIntValue(i);
    }

    /* renamed from: getInvalidationEnabled$foundation_release, reason: from getter */
    public final boolean getInvalidationEnabled() {
        return this.invalidationEnabled;
    }

    public final void setInvalidationEnabled$foundation_release(boolean z) {
        this.invalidationEnabled = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0145 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0136  */
    @Override // androidx.compose.foundation.OverscrollEffect
    /* renamed from: applyToScroll-Rhakbz0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long mo508applyToScrollRhakbz0(long delta, int source, Function1<? super Offset, Offset> performScroll) {
        float m505pullTop0a9Yr6o;
        long Offset;
        boolean z;
        boolean z2;
        float m503pullLeft0a9Yr6o;
        if (Size.m3893isEmptyimpl(this.containerSize)) {
            return performScroll.invoke(Offset.m3811boximpl(delta)).getPackedValue();
        }
        boolean z3 = true;
        if (!this.scrollCycleInProgress) {
            stopOverscrollAnimation();
            this.scrollCycleInProgress = true;
        }
        Offset offset = this.pointerPosition;
        long packedValue = offset != null ? offset.getPackedValue() : SizeKt.m3901getCenteruvyYCjk(this.containerSize);
        float f = 0.0f;
        if (Offset.m3823getYimpl(delta) != 0.0f) {
            if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffect) != 0.0f) {
                m505pullTop0a9Yr6o = m505pullTop0a9Yr6o(delta, packedValue);
                if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffect) == 0.0f) {
                    this.topEffect.onRelease();
                }
            } else if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffect) != 0.0f) {
                m505pullTop0a9Yr6o = m502pullBottom0a9Yr6o(delta, packedValue);
                if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffect) == 0.0f) {
                    this.bottomEffect.onRelease();
                }
            }
            if (Offset.m3822getXimpl(delta) != 0.0f) {
                if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffect) != 0.0f) {
                    m503pullLeft0a9Yr6o = m503pullLeft0a9Yr6o(delta, packedValue);
                    if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffect) == 0.0f) {
                        this.leftEffect.onRelease();
                    }
                } else if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffect) != 0.0f) {
                    m503pullLeft0a9Yr6o = m504pullRight0a9Yr6o(delta, packedValue);
                    if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffect) == 0.0f) {
                        this.rightEffect.onRelease();
                    }
                }
                f = m503pullLeft0a9Yr6o;
            }
            Offset = OffsetKt.Offset(f, m505pullTop0a9Yr6o);
            if (!Offset.m3819equalsimpl0(Offset, Offset.INSTANCE.m3838getZeroF1C5BW0())) {
                invalidateOverscroll();
            }
            long m3826minusMKHz9U = Offset.m3826minusMKHz9U(delta, Offset);
            long packedValue2 = performScroll.invoke(Offset.m3811boximpl(m3826minusMKHz9U)).getPackedValue();
            long m3826minusMKHz9U2 = Offset.m3826minusMKHz9U(m3826minusMKHz9U, packedValue2);
            boolean z4 = false;
            if (NestedScrollSource.m5096equalsimpl0(source, NestedScrollSource.INSTANCE.m5101getDragWNlRxjI())) {
                if (Offset.m3822getXimpl(m3826minusMKHz9U2) > 0.5f) {
                    m503pullLeft0a9Yr6o(m3826minusMKHz9U2, packedValue);
                } else if (Offset.m3822getXimpl(m3826minusMKHz9U2) < -0.5f) {
                    m504pullRight0a9Yr6o(m3826minusMKHz9U2, packedValue);
                } else {
                    z = false;
                    if (Offset.m3823getYimpl(m3826minusMKHz9U2) <= 0.5f) {
                        m505pullTop0a9Yr6o(m3826minusMKHz9U2, packedValue);
                    } else if (Offset.m3823getYimpl(m3826minusMKHz9U2) < -0.5f) {
                        m502pullBottom0a9Yr6o(m3826minusMKHz9U2, packedValue);
                    } else {
                        z2 = false;
                        if (!z && !z2) {
                            z3 = false;
                        }
                        z4 = z3;
                    }
                    z2 = true;
                    if (!z) {
                        z3 = false;
                    }
                    z4 = z3;
                }
                z = true;
                if (Offset.m3823getYimpl(m3826minusMKHz9U2) <= 0.5f) {
                }
                z2 = true;
                if (!z) {
                }
                z4 = z3;
            }
            if (!m506releaseOppositeOverscrollk4lQ0M(delta) || z4) {
                invalidateOverscroll();
            }
            return Offset.m3827plusMKHz9U(Offset, packedValue2);
        }
        m505pullTop0a9Yr6o = 0.0f;
        if (Offset.m3822getXimpl(delta) != 0.0f) {
        }
        Offset = OffsetKt.Offset(f, m505pullTop0a9Yr6o);
        if (!Offset.m3819equalsimpl0(Offset, Offset.INSTANCE.m3838getZeroF1C5BW0())) {
        }
        long m3826minusMKHz9U3 = Offset.m3826minusMKHz9U(delta, Offset);
        long packedValue22 = performScroll.invoke(Offset.m3811boximpl(m3826minusMKHz9U3)).getPackedValue();
        long m3826minusMKHz9U22 = Offset.m3826minusMKHz9U(m3826minusMKHz9U3, packedValue22);
        boolean z42 = false;
        if (NestedScrollSource.m5096equalsimpl0(source, NestedScrollSource.INSTANCE.m5101getDragWNlRxjI())) {
        }
        if (!m506releaseOppositeOverscrollk4lQ0M(delta)) {
        }
        invalidateOverscroll();
        return Offset.m3827plusMKHz9U(Offset, packedValue22);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0056, code lost:
    
        if (r13.invoke(r11, r0) == r1) goto L54;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // androidx.compose.foundation.OverscrollEffect
    /* renamed from: applyToFling-BMRW4eQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo507applyToFlingBMRW4eQ(long j, Function2<? super Velocity, ? super Continuation<? super Velocity>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        AndroidEdgeEffectOverscrollEffect$applyToFling$1 androidEdgeEffectOverscrollEffect$applyToFling$1;
        int i;
        float f;
        float f2;
        long m6627minusAH228Gc;
        AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect;
        long m6627minusAH228Gc2;
        if (continuation instanceof AndroidEdgeEffectOverscrollEffect$applyToFling$1) {
            androidEdgeEffectOverscrollEffect$applyToFling$1 = (AndroidEdgeEffectOverscrollEffect$applyToFling$1) continuation;
            if ((androidEdgeEffectOverscrollEffect$applyToFling$1.label & Integer.MIN_VALUE) != 0) {
                androidEdgeEffectOverscrollEffect$applyToFling$1.label -= Integer.MIN_VALUE;
                Object obj = androidEdgeEffectOverscrollEffect$applyToFling$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = androidEdgeEffectOverscrollEffect$applyToFling$1.label;
                if (i == 0) {
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    m6627minusAH228Gc = androidEdgeEffectOverscrollEffect$applyToFling$1.J$0;
                    androidEdgeEffectOverscrollEffect = (AndroidEdgeEffectOverscrollEffect) androidEdgeEffectOverscrollEffect$applyToFling$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    m6627minusAH228Gc2 = Velocity.m6627minusAH228Gc(m6627minusAH228Gc, ((Velocity) obj).getPackedValue());
                    androidEdgeEffectOverscrollEffect.scrollCycleInProgress = false;
                    if (Velocity.m6624getXimpl(m6627minusAH228Gc2) <= 0.0f) {
                        EdgeEffectCompat.INSTANCE.onAbsorbCompat(androidEdgeEffectOverscrollEffect.leftEffect, MathKt.roundToInt(Velocity.m6624getXimpl(m6627minusAH228Gc2)));
                    } else if (Velocity.m6624getXimpl(m6627minusAH228Gc2) < 0.0f) {
                        EdgeEffectCompat.INSTANCE.onAbsorbCompat(androidEdgeEffectOverscrollEffect.rightEffect, -MathKt.roundToInt(Velocity.m6624getXimpl(m6627minusAH228Gc2)));
                    }
                    if (Velocity.m6625getYimpl(m6627minusAH228Gc2) <= 0.0f) {
                        EdgeEffectCompat.INSTANCE.onAbsorbCompat(androidEdgeEffectOverscrollEffect.topEffect, MathKt.roundToInt(Velocity.m6625getYimpl(m6627minusAH228Gc2)));
                    } else if (Velocity.m6625getYimpl(m6627minusAH228Gc2) < 0.0f) {
                        EdgeEffectCompat.INSTANCE.onAbsorbCompat(androidEdgeEffectOverscrollEffect.bottomEffect, -MathKt.roundToInt(Velocity.m6625getYimpl(m6627minusAH228Gc2)));
                    }
                    if (!Velocity.m6623equalsimpl0(m6627minusAH228Gc2, Velocity.INSTANCE.m6635getZero9UxMQ8M())) {
                        androidEdgeEffectOverscrollEffect.invalidateOverscroll();
                    }
                    androidEdgeEffectOverscrollEffect.animateToRelease();
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                if (Size.m3893isEmptyimpl(this.containerSize)) {
                    Velocity m6615boximpl = Velocity.m6615boximpl(j);
                    androidEdgeEffectOverscrollEffect$applyToFling$1.label = 1;
                } else {
                    if (Velocity.m6624getXimpl(j) > 0.0f && EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffect) != 0.0f) {
                        EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.leftEffect, MathKt.roundToInt(Velocity.m6624getXimpl(j)));
                        f = Velocity.m6624getXimpl(j);
                    } else if (Velocity.m6624getXimpl(j) >= 0.0f || EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffect) == 0.0f) {
                        f = 0.0f;
                    } else {
                        EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.rightEffect, -MathKt.roundToInt(Velocity.m6624getXimpl(j)));
                        f = Velocity.m6624getXimpl(j);
                    }
                    if (Velocity.m6625getYimpl(j) > 0.0f && EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffect) != 0.0f) {
                        EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.topEffect, MathKt.roundToInt(Velocity.m6625getYimpl(j)));
                        f2 = Velocity.m6625getYimpl(j);
                    } else if (Velocity.m6625getYimpl(j) >= 0.0f || EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffect) == 0.0f) {
                        f2 = 0.0f;
                    } else {
                        EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.bottomEffect, -MathKt.roundToInt(Velocity.m6625getYimpl(j)));
                        f2 = Velocity.m6625getYimpl(j);
                    }
                    long Velocity = VelocityKt.Velocity(f, f2);
                    if (!Velocity.m6623equalsimpl0(Velocity, Velocity.INSTANCE.m6635getZero9UxMQ8M())) {
                        invalidateOverscroll();
                    }
                    m6627minusAH228Gc = Velocity.m6627minusAH228Gc(j, Velocity);
                    Velocity m6615boximpl2 = Velocity.m6615boximpl(m6627minusAH228Gc);
                    androidEdgeEffectOverscrollEffect$applyToFling$1.L$0 = this;
                    androidEdgeEffectOverscrollEffect$applyToFling$1.J$0 = m6627minusAH228Gc;
                    androidEdgeEffectOverscrollEffect$applyToFling$1.label = 2;
                    obj = function2.invoke(m6615boximpl2, androidEdgeEffectOverscrollEffect$applyToFling$1);
                    if (obj != coroutine_suspended) {
                        androidEdgeEffectOverscrollEffect = this;
                        m6627minusAH228Gc2 = Velocity.m6627minusAH228Gc(m6627minusAH228Gc, ((Velocity) obj).getPackedValue());
                        androidEdgeEffectOverscrollEffect.scrollCycleInProgress = false;
                        if (Velocity.m6624getXimpl(m6627minusAH228Gc2) <= 0.0f) {
                        }
                        if (Velocity.m6625getYimpl(m6627minusAH228Gc2) <= 0.0f) {
                        }
                        if (!Velocity.m6623equalsimpl0(m6627minusAH228Gc2, Velocity.INSTANCE.m6635getZero9UxMQ8M())) {
                        }
                        androidEdgeEffectOverscrollEffect.animateToRelease();
                        return Unit.INSTANCE;
                    }
                }
                return coroutine_suspended;
            }
        }
        androidEdgeEffectOverscrollEffect$applyToFling$1 = new AndroidEdgeEffectOverscrollEffect$applyToFling$1(this, continuation);
        Object obj2 = androidEdgeEffectOverscrollEffect$applyToFling$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidEdgeEffectOverscrollEffect$applyToFling$1.label;
        if (i == 0) {
        }
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public boolean isInProgress() {
        List<EdgeEffect> list = this.allEffects;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(list.get(i)) == 0.0f)) {
                return true;
            }
        }
        return false;
    }

    private final boolean stopOverscrollAnimation() {
        boolean z;
        long m3901getCenteruvyYCjk = SizeKt.m3901getCenteruvyYCjk(this.containerSize);
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffect) == 0.0f) {
            z = false;
        } else {
            m503pullLeft0a9Yr6o(Offset.INSTANCE.m3838getZeroF1C5BW0(), m3901getCenteruvyYCjk);
            z = true;
        }
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffect) != 0.0f) {
            m504pullRight0a9Yr6o(Offset.INSTANCE.m3838getZeroF1C5BW0(), m3901getCenteruvyYCjk);
            z = true;
        }
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffect) != 0.0f) {
            m505pullTop0a9Yr6o(Offset.INSTANCE.m3838getZeroF1C5BW0(), m3901getCenteruvyYCjk);
            z = true;
        }
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffect) == 0.0f) {
            return z;
        }
        m502pullBottom0a9Yr6o(Offset.INSTANCE.m3838getZeroF1C5BW0(), m3901getCenteruvyYCjk);
        return true;
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public Modifier getEffectModifier() {
        return this.effectModifier;
    }

    public final void drawOverscroll(DrawScope drawScope) {
        boolean z;
        if (Size.m3893isEmptyimpl(this.containerSize)) {
            return;
        }
        Canvas canvas = drawScope.getDrawContext().getCanvas();
        this.consumeCount = getInvalidateCount();
        android.graphics.Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffectNegation) != 0.0f) {
            drawRight(drawScope, this.leftEffectNegation, nativeCanvas);
            this.leftEffectNegation.finish();
        }
        if (this.leftEffect.isFinished()) {
            z = false;
        } else {
            z = drawLeft(drawScope, this.leftEffect, nativeCanvas);
            EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.leftEffectNegation, EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffect), 0.0f);
        }
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffectNegation) != 0.0f) {
            drawBottom(drawScope, this.topEffectNegation, nativeCanvas);
            this.topEffectNegation.finish();
        }
        if (!this.topEffect.isFinished()) {
            z = drawTop(drawScope, this.topEffect, nativeCanvas) || z;
            EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.topEffectNegation, EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffect), 0.0f);
        }
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffectNegation) != 0.0f) {
            drawLeft(drawScope, this.rightEffectNegation, nativeCanvas);
            this.rightEffectNegation.finish();
        }
        if (!this.rightEffect.isFinished()) {
            z = drawRight(drawScope, this.rightEffect, nativeCanvas) || z;
            EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.rightEffectNegation, EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffect), 0.0f);
        }
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffectNegation) != 0.0f) {
            drawTop(drawScope, this.bottomEffectNegation, nativeCanvas);
            this.bottomEffectNegation.finish();
        }
        if (!this.bottomEffect.isFinished()) {
            boolean z2 = drawBottom(drawScope, this.bottomEffect, nativeCanvas) || z;
            EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.bottomEffectNegation, EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffect), 0.0f);
            z = z2;
        }
        if (z) {
            invalidateOverscroll();
        }
    }

    private final boolean drawLeft(DrawScope drawScope, EdgeEffect edgeEffect, android.graphics.Canvas canvas) {
        int save = canvas.save();
        canvas.rotate(270.0f);
        canvas.translate(-Size.m3888getHeightimpl(this.containerSize), drawScope.mo630toPx0680j_4(this.overscrollConfig.getDrawPadding().mo830calculateLeftPaddingu2uoSUM(drawScope.getLayoutDirection())));
        boolean draw = edgeEffect.draw(canvas);
        canvas.restoreToCount(save);
        return draw;
    }

    private final boolean drawTop(DrawScope drawScope, EdgeEffect edgeEffect, android.graphics.Canvas canvas) {
        int save = canvas.save();
        canvas.translate(0.0f, drawScope.mo630toPx0680j_4(this.overscrollConfig.getDrawPadding().getTop()));
        boolean draw = edgeEffect.draw(canvas);
        canvas.restoreToCount(save);
        return draw;
    }

    private final boolean drawRight(DrawScope drawScope, EdgeEffect edgeEffect, android.graphics.Canvas canvas) {
        int save = canvas.save();
        int roundToInt = MathKt.roundToInt(Size.m3891getWidthimpl(this.containerSize));
        float mo831calculateRightPaddingu2uoSUM = this.overscrollConfig.getDrawPadding().mo831calculateRightPaddingu2uoSUM(drawScope.getLayoutDirection());
        canvas.rotate(90.0f);
        canvas.translate(0.0f, (-roundToInt) + drawScope.mo630toPx0680j_4(mo831calculateRightPaddingu2uoSUM));
        boolean draw = edgeEffect.draw(canvas);
        canvas.restoreToCount(save);
        return draw;
    }

    private final boolean drawBottom(DrawScope drawScope, EdgeEffect edgeEffect, android.graphics.Canvas canvas) {
        int save = canvas.save();
        canvas.rotate(180.0f);
        canvas.translate(-Size.m3891getWidthimpl(this.containerSize), (-Size.m3888getHeightimpl(this.containerSize)) + drawScope.mo630toPx0680j_4(this.overscrollConfig.getDrawPadding().getBottom()));
        boolean draw = edgeEffect.draw(canvas);
        canvas.restoreToCount(save);
        return draw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidateOverscroll() {
        if (this.invalidationEnabled && this.consumeCount == getInvalidateCount()) {
            setInvalidateCount(getInvalidateCount() + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void animateToRelease() {
        List<EdgeEffect> list = this.allEffects;
        int size = list.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            EdgeEffect edgeEffect = list.get(i);
            edgeEffect.onRelease();
            z = edgeEffect.isFinished() || z;
        }
        if (z) {
            invalidateOverscroll();
        }
    }

    /* renamed from: releaseOppositeOverscroll-k-4lQ0M, reason: not valid java name */
    private final boolean m506releaseOppositeOverscrollk4lQ0M(long delta) {
        boolean z;
        if (this.leftEffect.isFinished() || Offset.m3822getXimpl(delta) >= 0.0f) {
            z = false;
        } else {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.leftEffect, Offset.m3822getXimpl(delta));
            z = this.leftEffect.isFinished();
        }
        if (!this.rightEffect.isFinished() && Offset.m3822getXimpl(delta) > 0.0f) {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.rightEffect, Offset.m3822getXimpl(delta));
            z = z || this.rightEffect.isFinished();
        }
        if (!this.topEffect.isFinished() && Offset.m3823getYimpl(delta) < 0.0f) {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.topEffect, Offset.m3823getYimpl(delta));
            z = z || this.topEffect.isFinished();
        }
        if (this.bottomEffect.isFinished() || Offset.m3823getYimpl(delta) <= 0.0f) {
            return z;
        }
        EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.bottomEffect, Offset.m3823getYimpl(delta));
        return z || this.bottomEffect.isFinished();
    }

    /* renamed from: pullTop-0a9Yr6o, reason: not valid java name */
    private final float m505pullTop0a9Yr6o(long scroll, long displacement) {
        return EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffect) == 0.0f ? EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.topEffect, Offset.m3823getYimpl(scroll) / Size.m3888getHeightimpl(this.containerSize), Offset.m3822getXimpl(displacement) / Size.m3891getWidthimpl(this.containerSize)) * Size.m3888getHeightimpl(this.containerSize) : Offset.m3823getYimpl(scroll);
    }

    /* renamed from: pullBottom-0a9Yr6o, reason: not valid java name */
    private final float m502pullBottom0a9Yr6o(long scroll, long displacement) {
        return EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffect) == 0.0f ? (-EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.bottomEffect, -(Offset.m3823getYimpl(scroll) / Size.m3888getHeightimpl(this.containerSize)), 1 - (Offset.m3822getXimpl(displacement) / Size.m3891getWidthimpl(this.containerSize)))) * Size.m3888getHeightimpl(this.containerSize) : Offset.m3823getYimpl(scroll);
    }

    /* renamed from: pullLeft-0a9Yr6o, reason: not valid java name */
    private final float m503pullLeft0a9Yr6o(long scroll, long displacement) {
        return EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffect) == 0.0f ? EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.leftEffect, Offset.m3822getXimpl(scroll) / Size.m3891getWidthimpl(this.containerSize), 1 - (Offset.m3823getYimpl(displacement) / Size.m3888getHeightimpl(this.containerSize))) * Size.m3891getWidthimpl(this.containerSize) : Offset.m3822getXimpl(scroll);
    }

    /* renamed from: pullRight-0a9Yr6o, reason: not valid java name */
    private final float m504pullRight0a9Yr6o(long scroll, long displacement) {
        return EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffect) == 0.0f ? (-EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.rightEffect, -(Offset.m3822getXimpl(scroll) / Size.m3891getWidthimpl(this.containerSize)), Offset.m3823getYimpl(displacement) / Size.m3888getHeightimpl(this.containerSize))) * Size.m3891getWidthimpl(this.containerSize) : Offset.m3822getXimpl(scroll);
    }
}
