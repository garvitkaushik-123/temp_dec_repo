package io.bidmachine.rendering.internal.animation;

import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.mbridge.msdk.MBridgeConstans;
import io.bidmachine.rendering.model.AnimationEventType;
import io.bidmachine.rendering.model.AnimationFunctionType;
import io.bidmachine.rendering.model.AnimationParams;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u000b\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u000b\u0010\u0013R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0014¨\u0006\u0015"}, d2 = {"Lio/bidmachine/rendering/internal/animation/h;", "", "", "Lio/bidmachine/rendering/model/AnimationEventType;", "Lio/bidmachine/rendering/model/AnimationParams;", "params", "<init>", "(Ljava/util/Map;)V", "Lio/bidmachine/rendering/model/AnimationFunctionType;", "functionType", "Landroid/animation/TimeInterpolator;", "a", "(Lio/bidmachine/rendering/model/AnimationFunctionType;)Landroid/animation/TimeInterpolator;", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "eventType", "Lio/bidmachine/rendering/internal/animation/e;", "targetValues", "Landroid/view/ViewPropertyAnimator;", "(Landroid/view/View;Lio/bidmachine/rendering/model/AnimationEventType;Lio/bidmachine/rendering/internal/animation/e;)Landroid/view/ViewPropertyAnimator;", "Ljava/util/Map;", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Map<AnimationEventType, AnimationParams> params;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AnimationFunctionType.values().length];
            try {
                iArr[AnimationFunctionType.EaseIn.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AnimationFunctionType.EaseOut.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AnimationFunctionType.EaseInOut.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public h(Map<AnimationEventType, AnimationParams> params) {
        Intrinsics.checkNotNullParameter(params, "params");
        this.params = params;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a() {
    }

    public final ViewPropertyAnimator a(View view, AnimationEventType eventType, e targetValues) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(targetValues, "targetValues");
        AnimationParams animationParams = this.params.get(eventType);
        if (animationParams == null) {
            return null;
        }
        ViewPropertyAnimator withStartAction = view.animate().alpha(targetValues.getAlpha()).translationX(targetValues.getTranslationX()).translationY(targetValues.getTranslationY()).setDuration(animationParams.getDuration()).withStartAction(new Runnable() { // from class: io.bidmachine.rendering.internal.animation.h$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                h.a();
            }
        });
        withStartAction.setInterpolator(a(animationParams.getFunction()));
        return withStartAction;
    }

    private final TimeInterpolator a(AnimationFunctionType functionType) {
        int i = functionType == null ? -1 : a.$EnumSwitchMapping$0[functionType.ordinal()];
        if (i == 1) {
            return new AccelerateInterpolator();
        }
        if (i == 2) {
            return new DecelerateInterpolator();
        }
        if (i != 3) {
            return new LinearInterpolator();
        }
        return new AccelerateDecelerateInterpolator();
    }
}
