package io.bidmachine.rendering.internal.controller;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.rendering.internal.InterfaceC3590c;
import io.bidmachine.rendering.internal.o;
import io.bidmachine.rendering.utils.taskmanager.CancelableTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/bidmachine/rendering/internal/controller/d;", "Lio/bidmachine/rendering/utils/taskmanager/CancelableTask;", "Lio/bidmachine/rendering/internal/c;", "adElement", "<init>", "(Lio/bidmachine/rendering/internal/c;)V", "", "runTask", "()V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lio/bidmachine/rendering/internal/c;", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class d extends CancelableTask {

    /* renamed from: b, reason: from kotlin metadata */
    private final InterfaceC3590c adElement;

    public d(InterfaceC3590c adElement) {
        Intrinsics.checkNotNullParameter(adElement, "adElement");
        this.adElement = adElement;
    }

    @Override // io.bidmachine.rendering.utils.taskmanager.CancelableTask
    public void runTask() {
        try {
            this.adElement.c();
        } catch (Throwable th) {
            o.b(th);
        }
    }
}
