package io.bidmachine.rendering.internal.state;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.rendering.internal.h;
import io.bidmachine.rendering.internal.state.a;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000fR\u001a\u0010\u0015\u001a\u00020\u00108\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lio/bidmachine/rendering/internal/state/b;", "Lkotlinx/coroutines/CoroutineScope;", "Lio/bidmachine/rendering/internal/state/a$b;", "Lio/bidmachine/rendering/internal/state/a;", "adState", "Lio/bidmachine/rendering/internal/h;", "coroutineDispatchers", "<init>", "(Lio/bidmachine/rendering/internal/state/a;Lio/bidmachine/rendering/internal/h;)V", "source", "Lio/bidmachine/rendering/internal/state/a$a;", "event", "", "a", "(Lio/bidmachine/rendering/internal/state/a;Lio/bidmachine/rendering/internal/state/a$a;)V", "Lio/bidmachine/rendering/internal/state/a;", "Lkotlin/coroutines/CoroutineContext;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class b implements CoroutineScope, a.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final a adState;

    /* renamed from: b, reason: from kotlin metadata */
    private final CoroutineContext coroutineContext;

    public b(a adState, h coroutineDispatchers) {
        Intrinsics.checkNotNullParameter(adState, "adState");
        Intrinsics.checkNotNullParameter(coroutineDispatchers, "coroutineDispatchers");
        this.adState = adState;
        this.coroutineContext = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(coroutineDispatchers.e());
        if (adState.h()) {
            CoroutineScopeKt.cancel$default(this, null, 1, null);
        } else {
            adState.a(this);
        }
    }

    @Override // io.bidmachine.rendering.internal.state.a.b
    public void a(a source, a.EnumC0629a event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == a.EnumC0629a.Destroyed && Intrinsics.areEqual(this.adState, source)) {
            CoroutineScopeKt.cancel$default(this, null, 1, null);
            source.b(this);
        }
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }
}
