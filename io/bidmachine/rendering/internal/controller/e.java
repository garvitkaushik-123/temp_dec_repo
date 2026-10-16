package io.bidmachine.rendering.internal.controller;

import android.view.ViewGroup;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00158&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\b\u0010\u0018ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001aÀ\u0006\u0001"}, d2 = {"Lio/bidmachine/rendering/internal/controller/e;", "", "", "c", "()V", "Landroid/view/ViewGroup;", "container", "", "a", "(Landroid/view/ViewGroup;)Z", "d", "isFinishing", "(Z)V", "onShown", "Lio/bidmachine/rendering/internal/d;", "e", "()Lio/bidmachine/rendering/internal/d;", "adPhase", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()Z", "isLoaded", "Lio/bidmachine/rendering/internal/controller/g;", "getPresentListener", "()Lio/bidmachine/rendering/internal/controller/g;", "(Lio/bidmachine/rendering/internal/controller/g;)V", "presentListener", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public interface e {
    void a();

    void a(g gVar);

    void a(boolean isFinishing);

    boolean a(ViewGroup container);

    boolean b();

    void c();

    void d();

    io.bidmachine.rendering.internal.d e();

    void onShown();
}
