package io.bidmachine.rendering.internal.animation;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.rendering.internal.InterfaceC3590c;
import io.bidmachine.rendering.model.AnimationEventType;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u0005\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u0005\u0010\rJ\u001f\u0010\u0005\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u0005\u0010\u0010JM\u0010\u0005\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\u00042\u0010\b\u0002\u0010\u0014\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u00132\u0010\b\u0002\u0010\u0015\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u0013H&¢\u0006\u0004\b\u0005\u0010\u0016JM\u0010\u0017\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\u00042\u0010\b\u0002\u0010\u0014\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u00132\u0010\b\u0002\u0010\u0015\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u0013H&¢\u0006\u0004\b\u0017\u0010\u0016JM\u0010\u0005\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\u00042\u0010\b\u0002\u0010\u0014\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u00132\u0010\b\u0002\u0010\u0015\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u0013H&¢\u0006\u0004\b\u0005\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0005\u0010\u0019J\u0017\u0010\u0005\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0005\u0010\u001aJ\u000f\u0010\u0005\u001a\u00020\fH&¢\u0006\u0004\b\u0005\u0010\u001bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001cÀ\u0006\u0001"}, d2 = {"Lio/bidmachine/rendering/internal/animation/b;", "", "", "id", "", "a", "(I)Z", "Lio/bidmachine/rendering/internal/c;", "adElement", "allowPostponed", "Lio/bidmachine/rendering/model/AnimationEventType;", "eventType", "", "(Lio/bidmachine/rendering/internal/c;ZLio/bidmachine/rendering/model/AnimationEventType;)V", "Lio/bidmachine/rendering/internal/d;", "adPhase", "(Lio/bidmachine/rendering/internal/d;Lio/bidmachine/rendering/model/AnimationEventType;)V", "skip", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "onStart", "onEnd", "(Lio/bidmachine/rendering/internal/c;Lio/bidmachine/rendering/model/AnimationEventType;ZLjava/lang/Runnable;Ljava/lang/Runnable;)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Lio/bidmachine/rendering/internal/d;Lio/bidmachine/rendering/model/AnimationEventType;ZLjava/lang/Runnable;Ljava/lang/Runnable;)V", "(Lio/bidmachine/rendering/internal/c;)V", "(Lio/bidmachine/rendering/internal/d;)V", "()V", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public interface b {
    static /* synthetic */ void a(b bVar, InterfaceC3590c interfaceC3590c, AnimationEventType animationEventType, boolean z, Runnable runnable, Runnable runnable2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: prepareAndAnimate");
        }
        if ((i & 4) != 0) {
            z = false;
        }
        bVar.a(interfaceC3590c, animationEventType, z, (i & 8) != 0 ? null : runnable, (i & 16) != 0 ? null : runnable2);
    }

    void a();

    void a(InterfaceC3590c adElement);

    void a(InterfaceC3590c adElement, AnimationEventType eventType, boolean skip, Runnable onStart, Runnable onEnd);

    void a(InterfaceC3590c adElement, boolean allowPostponed, AnimationEventType eventType);

    void a(io.bidmachine.rendering.internal.d adPhase);

    void a(io.bidmachine.rendering.internal.d adPhase, AnimationEventType eventType);

    void a(io.bidmachine.rendering.internal.d adPhase, AnimationEventType eventType, boolean skip, Runnable onStart, Runnable onEnd);

    boolean a(int id);

    void b(InterfaceC3590c adElement, AnimationEventType eventType, boolean skip, Runnable onStart, Runnable onEnd);
}
