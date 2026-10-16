package io.bidmachine.rendering.internal.animation;

import android.content.Context;
import android.view.View;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.rendering.model.AdElementParams;
import io.bidmachine.rendering.model.AnimationDirectionType;
import io.bidmachine.rendering.model.AnimationEventType;
import io.bidmachine.rendering.model.AnimationParams;
import io.bidmachine.rendering.model.AnimationStyleType;
import io.bidmachine.rendering.model.ElementLayoutParams;
import io.bidmachine.rendering.model.SideType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J3\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0013J\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0011\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0011\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0019R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u001a¨\u0006\u001b"}, d2 = {"Lio/bidmachine/rendering/internal/animation/j;", "Lio/bidmachine/rendering/internal/animation/f;", "Lio/bidmachine/rendering/model/AdElementParams;", "params", "", "allowPostponed", "<init>", "(Lio/bidmachine/rendering/model/AdElementParams;Z)V", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Lio/bidmachine/rendering/model/ElementLayoutParams;", "layoutParams", "Lio/bidmachine/rendering/model/AnimationStyleType;", "style", "Lio/bidmachine/rendering/model/AnimationDirectionType;", "direction", "Lio/bidmachine/rendering/internal/animation/e;", "a", "(Landroid/view/View;Lio/bidmachine/rendering/model/ElementLayoutParams;Lio/bidmachine/rendering/model/AnimationStyleType;Lio/bidmachine/rendering/model/AnimationDirectionType;)Lio/bidmachine/rendering/internal/animation/e;", "(Landroid/view/View;Lio/bidmachine/rendering/model/ElementLayoutParams;Lio/bidmachine/rendering/model/AnimationDirectionType;)Lio/bidmachine/rendering/internal/animation/e;", "(Landroid/view/View;)Lio/bidmachine/rendering/internal/animation/e;", "Lio/bidmachine/rendering/model/AnimationEventType;", "eventType", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Landroid/view/View;Lio/bidmachine/rendering/model/AnimationEventType;)Lio/bidmachine/rendering/internal/animation/e;", "Lio/bidmachine/rendering/model/AdElementParams;", "Z", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class j implements f<AdElementParams> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final AdElementParams params;

    /* renamed from: b, reason: from kotlin metadata */
    private final boolean allowPostponed;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

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
            int[] iArr3 = new int[SideType.values().length];
            try {
                iArr3[SideType.Left.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr3[SideType.Right.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[SideType.Top.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr3[SideType.Bottom.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[AnimationDirectionType.values().length];
            try {
                iArr4[AnimationDirectionType.Left.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr4[AnimationDirectionType.Right.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr4[AnimationDirectionType.Top.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr4[AnimationDirectionType.Bottom.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            $EnumSwitchMapping$3 = iArr4;
        }
    }

    public j(AdElementParams params, boolean z) {
        Intrinsics.checkNotNullParameter(params, "params");
        this.params = params;
        this.allowPostponed = z;
    }

    @Override // io.bidmachine.rendering.internal.animation.f
    public e a(View view, AnimationEventType eventType) {
        AnimationDirectionType directionOrDefault;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        ElementLayoutParams elementLayoutParams = this.params.getElementLayoutParams();
        int i = a.$EnumSwitchMapping$0[eventType.ordinal()];
        if (i == 1) {
            Float f = this.params.getAppearanceParams().getIo.bidmachine.iab.vast.tags.VastAttributes.OPACITY java.lang.String();
            float floatValue = f != null ? f.floatValue() : 1.0f;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            return new e(floatValue, elementLayoutParams.getTranslationXPx(context), elementLayoutParams.getTranslationYPx(context));
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
        return a(view, elementLayoutParams, style, animationDirectionType);
    }

    @Override // io.bidmachine.rendering.internal.animation.f
    public e b(View view, AnimationEventType eventType) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        int i = a.$EnumSwitchMapping$0[eventType.ordinal()];
        if (i == 1) {
            AnimationParams animationParams = this.params.getAnimationParams().get(eventType);
            return a(view, this.params.getElementLayoutParams(), animationParams != null ? animationParams.getStyle() : null, animationParams != null ? animationParams.getDirectionOrDefault() : null);
        }
        if (i == 2) {
            return a(view);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final e a(View view, ElementLayoutParams layoutParams, AnimationStyleType style, AnimationDirectionType direction) {
        e a2;
        int i = style == null ? -1 : a.$EnumSwitchMapping$1[style.ordinal()];
        if (i == 1) {
            return new e(0.0f, view.getTranslationX(), view.getTranslationY());
        }
        if (i != 2) {
            return a(view);
        }
        return (direction == null || (a2 = a(view, layoutParams, direction)) == null) ? a(view) : a2;
    }

    private final e a(View view, ElementLayoutParams layoutParams, AnimationDirectionType direction) {
        float f;
        int i;
        float translationY;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        float marginLeftPx = layoutParams.getMarginLeftPx(context);
        float marginRightPx = layoutParams.getMarginRightPx(context);
        float marginTopPx = layoutParams.getMarginTopPx(context);
        float marginBottomPx = layoutParams.getMarginBottomPx(context);
        float widthPx = layoutParams.getWidthPx(context);
        float heightPx = layoutParams.getHeightPx(context);
        int[] iArr = a.$EnumSwitchMapping$3;
        int i2 = iArr[direction.ordinal()];
        if (i2 == 1) {
            SideType a2 = g.a(layoutParams);
            int i3 = a2 == null ? -1 : a.$EnumSwitchMapping$2[a2.ordinal()];
            if (i3 != 1) {
                f = i3 != 2 ? view.getTranslationX() : widthPx - marginRightPx;
            } else {
                f = (-widthPx) - marginRightPx;
            }
        } else if (i2 != 2) {
            f = view.getTranslationX();
        } else {
            SideType a3 = g.a(layoutParams);
            int i4 = a3 == null ? -1 : a.$EnumSwitchMapping$2[a3.ordinal()];
            if (i4 != 1) {
                f = i4 != 2 ? view.getTranslationX() : widthPx - marginLeftPx;
            } else {
                f = (-widthPx) - marginLeftPx;
            }
        }
        int i5 = iArr[direction.ordinal()];
        if (i5 == 3) {
            SideType b = g.b(layoutParams);
            i = b != null ? a.$EnumSwitchMapping$2[b.ordinal()] : -1;
            translationY = (i == 3 || i == 4) ? heightPx - marginBottomPx : view.getTranslationY();
        } else if (i5 != 4) {
            translationY = view.getTranslationY();
        } else {
            SideType b2 = g.b(layoutParams);
            i = b2 != null ? a.$EnumSwitchMapping$2[b2.ordinal()] : -1;
            translationY = (i == 3 || i == 4) ? (-heightPx) - marginTopPx : view.getTranslationY();
        }
        return new e(view.getAlpha(), f, translationY);
    }

    private final e a(View view) {
        return new e(this.allowPostponed ? 0.0f : view.getAlpha(), view.getTranslationX(), view.getTranslationY());
    }
}
