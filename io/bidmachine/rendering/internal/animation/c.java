package io.bidmachine.rendering.internal.animation;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.rendering.internal.o;
import io.bidmachine.rendering.model.EventType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\rB!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000fR\u001e\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lio/bidmachine/rendering/internal/animation/c;", "Lio/bidmachine/rendering/internal/event/e;", "Lio/bidmachine/rendering/internal/animation/b;", "animationController", "Lkotlin/Function0;", "", "rootViewIdProvider", "<init>", "(Lio/bidmachine/rendering/internal/animation/b;Lkotlin/jvm/functions/Function0;)V", "", "", "params", "", "a", "(Ljava/util/List;)Z", "Lio/bidmachine/rendering/internal/animation/b;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lkotlin/jvm/functions/Function0;", "c", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class c implements io.bidmachine.rendering.internal.event.e {
    private static final a c = new a(null);

    @Deprecated
    private static final List<EventType> d = CollectionsKt.listOf(EventType.OnClick);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final b animationController;

    /* renamed from: b, reason: from kotlin metadata */
    private final Function0<Integer> rootViewIdProvider;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/bidmachine/rendering/internal/animation/c$a;", "", "<init>", "()V", "", "TAG", "Ljava/lang/String;", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    public c(b animationController, Function0<Integer> function0) {
        Intrinsics.checkNotNullParameter(animationController, "animationController");
        this.animationController = animationController;
        this.rootViewIdProvider = function0;
    }

    @Override // io.bidmachine.rendering.internal.event.e
    public boolean a(List<? extends Object> params) {
        boolean z;
        Intrinsics.checkNotNullParameter(params, "params");
        Object orNull = CollectionsKt.getOrNull(params, 0);
        if (!(orNull instanceof EventType)) {
            return false;
        }
        boolean z2 = true;
        Object orNull2 = CollectionsKt.getOrNull(params, 1);
        if (!(orNull2 instanceof Integer) || !d.contains(orNull)) {
            return false;
        }
        Function0<Integer> function0 = this.rootViewIdProvider;
        Integer invoke = function0 != null ? function0.invoke() : null;
        if (invoke != null) {
            Integer num = invoke.intValue() != -1 ? invoke : null;
            if (num != null) {
                z = this.animationController.a(num.intValue());
                boolean a2 = this.animationController.a(((Number) orNull2).intValue());
                if (!z && !a2) {
                    z2 = false;
                }
                o.b("AdAnimationEventInterceptor", "Intercept result=" + z2 + "; eventType=" + orNull + "; viewId=" + orNull2, new Object[0]);
                return z2;
            }
        }
        z = false;
        boolean a22 = this.animationController.a(((Number) orNull2).intValue());
        if (!z) {
            z2 = false;
        }
        o.b("AdAnimationEventInterceptor", "Intercept result=" + z2 + "; eventType=" + orNull + "; viewId=" + orNull2, new Object[0]);
        return z2;
    }
}
