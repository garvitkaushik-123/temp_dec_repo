package io.bidmachine.rendering.internal.animation;

import android.view.View;
import android.view.ViewPropertyAnimator;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.rendering.internal.o;
import io.bidmachine.rendering.model.AnimationEventType;
import io.bidmachine.util.Tag;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u000f\u0010\u0013J=\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u000f\u0010\u0019J\u000f\u0010\u000f\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u000f\u0010\u001aR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u001bR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0011\u0010)\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u001c\u0010(¨\u0006*"}, d2 = {"Lio/bidmachine/rendering/internal/animation/a;", "", "Lio/bidmachine/util/Tag;", "tag", "Lio/bidmachine/rendering/internal/animation/h;", "animatorFactory", "Lio/bidmachine/rendering/internal/animation/f;", "valuesCalculator", "<init>", "(Lio/bidmachine/util/Tag;Lio/bidmachine/rendering/internal/animation/h;Lio/bidmachine/rendering/internal/animation/f;)V", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Lio/bidmachine/rendering/internal/animation/e;", "targetValues", "", "a", "(Landroid/view/View;Lio/bidmachine/rendering/internal/animation/e;)V", "Lio/bidmachine/rendering/model/AnimationEventType;", "eventType", "(Landroid/view/View;Lio/bidmachine/rendering/model/AnimationEventType;)V", "Ljava/lang/Runnable;", "onStart", "onEnd", "", "skip", "(Landroid/view/View;Lio/bidmachine/rendering/model/AnimationEventType;Ljava/lang/Runnable;Ljava/lang/Runnable;Z)V", "()V", "Lio/bidmachine/util/Tag;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lio/bidmachine/rendering/internal/animation/h;", "c", "Lio/bidmachine/rendering/internal/animation/f;", "Landroid/view/ViewPropertyAnimator;", "d", "Landroid/view/ViewPropertyAnimator;", "animator", "Ljava/util/concurrent/atomic/AtomicBoolean;", "e", "Ljava/util/concurrent/atomic/AtomicBoolean;", "animating", "()Z", "isAnimating", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Tag tag;

    /* renamed from: b, reason: from kotlin metadata */
    private final h animatorFactory;

    /* renamed from: c, reason: from kotlin metadata */
    private final f<?> valuesCalculator;

    /* renamed from: d, reason: from kotlin metadata */
    private ViewPropertyAnimator animator;

    /* renamed from: e, reason: from kotlin metadata */
    private final AtomicBoolean animating;

    public a(Tag tag, h animatorFactory, f<?> valuesCalculator) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(animatorFactory, "animatorFactory");
        Intrinsics.checkNotNullParameter(valuesCalculator, "valuesCalculator");
        this.tag = tag;
        this.animatorFactory = animatorFactory;
        this.valuesCalculator = valuesCalculator;
        this.animating = new AtomicBoolean(false);
    }

    public final void a(View view, AnimationEventType eventType) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        e b = this.valuesCalculator.b(view, eventType);
        a(view, b);
        o.b(this.tag, "Prepare animation for event: " + eventType + "; initial values: " + b, new Object[0]);
    }

    public final boolean b() {
        return this.animating.get();
    }

    public final void a(View view, AnimationEventType eventType, Runnable onStart, final Runnable onEnd, boolean skip) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        if (onStart != null) {
            onStart.run();
        }
        if (view == null) {
            o.b(this.tag, "Animation not started for event: " + eventType + "; view is null", new Object[0]);
            if (onEnd != null) {
                onEnd.run();
                return;
            }
            return;
        }
        if (!b() && !skip) {
            e a2 = this.valuesCalculator.a(view, eventType);
            ViewPropertyAnimator a3 = this.animatorFactory.a(view, eventType, a2);
            if (a3 == null) {
                a(view, a2);
                o.b(this.tag, "Apply values without animation for event: " + eventType + "; target values: " + a2, new Object[0]);
                if (onEnd != null) {
                    onEnd.run();
                    return;
                }
                return;
            }
            o.b(this.tag, "Start animation for event: " + eventType + "; target values: " + a2, new Object[0]);
            this.animating.set(true);
            ViewPropertyAnimator withEndAction = a3.withEndAction(new Runnable() { // from class: io.bidmachine.rendering.internal.animation.a$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    a.a(a.this, onEnd);
                }
            });
            withEndAction.start();
            this.animator = withEndAction;
            return;
        }
        o.b(this.tag, "Animation is already running for event: " + eventType, new Object[0]);
        if (onEnd != null) {
            onEnd.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(a this$0, Runnable runnable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.animating.set(false);
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void a() {
        o.b(this.tag, "Cancel animation", new Object[0]);
        ViewPropertyAnimator viewPropertyAnimator = this.animator;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            viewPropertyAnimator.setListener(null);
            viewPropertyAnimator.setUpdateListener(null);
        }
        this.animator = null;
        this.animating.set(false);
    }

    private final void a(View view, e targetValues) {
        view.setAlpha(targetValues.getAlpha());
        view.setTranslationX(targetValues.getTranslationX());
        view.setTranslationY(targetValues.getTranslationY());
    }
}
