package io.bidmachine.rendering.internal.animation;

import io.bidmachine.rendering.model.AdElementParams;
import io.bidmachine.rendering.model.AdPhaseParams;
import io.bidmachine.rendering.model.AnimationEventType;
import io.bidmachine.rendering.model.AnimationParams;
import io.bidmachine.util.Tag;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0007\u0010\fJ?\u0010\u0007\u001a\u00020\u0006\"\u0004\b\u0000\u0010\r2\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002¢\u0006\u0004\b\u0007\u0010\u0016¨\u0006\u0017"}, d2 = {"Lio/bidmachine/rendering/internal/animation/d;", "", "<init>", "()V", "Lio/bidmachine/rendering/model/AdPhaseParams;", "params", "Lio/bidmachine/rendering/internal/animation/a;", "a", "(Lio/bidmachine/rendering/model/AdPhaseParams;)Lio/bidmachine/rendering/internal/animation/a;", "Lio/bidmachine/rendering/model/AdElementParams;", "", "allowPostponed", "(Lio/bidmachine/rendering/model/AdElementParams;Z)Lio/bidmachine/rendering/internal/animation/a;", "Params", "Lio/bidmachine/util/Tag;", "tag", "", "Lio/bidmachine/rendering/model/AnimationEventType;", "Lio/bidmachine/rendering/model/AnimationParams;", "animationParams", "Lio/bidmachine/rendering/internal/animation/f;", "valuesCalculator", "(Lio/bidmachine/util/Tag;Ljava/util/Map;Lio/bidmachine/rendering/internal/animation/f;)Lio/bidmachine/rendering/internal/animation/a;", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f6966a = new d();

    private d() {
    }

    @JvmStatic
    public static final a a(AdPhaseParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        return f6966a.a(new Tag("AdPhaseAnimator"), params.getAnimationParams(), new k(params));
    }

    @JvmStatic
    public static final a a(AdElementParams params, boolean allowPostponed) {
        Intrinsics.checkNotNullParameter(params, "params");
        return f6966a.a(new Tag("AdElementAnimator (" + params.getName() + ')'), params.getAnimationParams(), new j(params, allowPostponed));
    }

    private final <Params> a a(Tag tag, Map<AnimationEventType, AnimationParams> animationParams, f<Params> valuesCalculator) {
        return new a(tag, new h(animationParams), valuesCalculator);
    }
}
