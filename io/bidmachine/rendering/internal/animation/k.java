package io.bidmachine.rendering.internal.animation;

import android.view.View;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.rendering.model.AdPhaseParams;
import io.bidmachine.rendering.model.AnimationDirectionType;
import io.bidmachine.rendering.model.AnimationEventType;
import io.bidmachine.rendering.model.AnimationParams;
import io.bidmachine.rendering.model.AnimationStyleType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J+\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\r\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0014¨\u0006\u0015"}, d2 = {"Lio/bidmachine/rendering/internal/animation/k;", "Lio/bidmachine/rendering/internal/animation/f;", "Lio/bidmachine/rendering/model/AdPhaseParams;", "params", "<init>", "(Lio/bidmachine/rendering/model/AdPhaseParams;)V", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Lio/bidmachine/rendering/model/AnimationStyleType;", "style", "Lio/bidmachine/rendering/model/AnimationDirectionType;", "direction", "Lio/bidmachine/rendering/internal/animation/e;", "a", "(Landroid/view/View;Lio/bidmachine/rendering/model/AnimationStyleType;Lio/bidmachine/rendering/model/AnimationDirectionType;)Lio/bidmachine/rendering/internal/animation/e;", "(Landroid/view/View;Lio/bidmachine/rendering/model/AnimationDirectionType;)Lio/bidmachine/rendering/internal/animation/e;", "Lio/bidmachine/rendering/model/AnimationEventType;", "eventType", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Landroid/view/View;Lio/bidmachine/rendering/model/AnimationEventType;)Lio/bidmachine/rendering/internal/animation/e;", "Lio/bidmachine/rendering/model/AdPhaseParams;", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class k implements f<AdPhaseParams> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final AdPhaseParams params;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[AnimationEventType.values().length];
            try {
                iArr[AnimationEventType.Appear.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AnimationEventType.Disappear.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[AnimationStyleType.values().length];
            try {
                iArr2[AnimationStyleType.Fade.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[AnimationStyleType.Slide.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[AnimationDirectionType.values().length];
            try {
                iArr3[AnimationDirectionType.Left.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr3[AnimationDirectionType.Right.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[AnimationDirectionType.Top.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr3[AnimationDirectionType.Bottom.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    public k(AdPhaseParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        this.params = params;
    }

    @Override // io.bidmachine.rendering.internal.animation.f
    public e a(View view, AnimationEventType eventType) {
        AnimationDirectionType directionOrDefault;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        int i = a.$EnumSwitchMapping$0[eventType.ordinal()];
        if (i == 1) {
            return new e(1.0f, 0.0f, 0.0f);
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        AnimationParams animationParams = this.params.getAnimationParams().get(eventType);
        AnimationDirectionType animationDirectionType = null;
        AnimationStyleType style = animationParams != null ? animationParams.getStyle() : null;
        if (animationParams != null && (directionOrDefault = animationParams.getDirectionOrDefault()) != null) {
            animationDirectionType = directionOrDefault.inverted();
        }
        return a(view, style, animationDirectionType);
    }

    @Override // io.bidmachine.rendering.internal.animation.f
    public e b(View view, AnimationEventType eventType) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        int i = a.$EnumSwitchMapping$0[eventType.ordinal()];
        if (i == 1) {
            AnimationParams animationParams = this.params.getAnimationParams().get(eventType);
            return a(view, animationParams != null ? animationParams.getStyle() : null, animationParams != null ? animationParams.getDirectionOrDefault() : null);
        }
        if (i == 2) {
            return new e(view);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final e a(View view, AnimationStyleType style, AnimationDirectionType direction) {
        e a2;
        int i = style == null ? -1 : a.$EnumSwitchMapping$1[style.ordinal()];
        if (i == 1) {
            return new e(0.0f, view.getTranslationX(), view.getTranslationY());
        }
        if (i != 2) {
            return new e(view);
        }
        return (direction == null || (a2 = a(view, direction)) == null) ? new e(view) : a2;
    }

    private final e a(View view, AnimationDirectionType direction) {
        float measuredWidth = view.getMeasuredWidth();
        int[] iArr = a.$EnumSwitchMapping$2;
        int i = iArr[direction.ordinal()];
        if (i != 1) {
            measuredWidth = i != 2 ? view.getTranslationX() : -measuredWidth;
        }
        float measuredHeight = view.getMeasuredHeight();
        int i2 = iArr[direction.ordinal()];
        if (i2 != 3) {
            measuredHeight = i2 != 4 ? view.getTranslationY() : -measuredHeight;
        }
        return new e(view.getAlpha(), measuredWidth, measuredHeight);
    }
}
