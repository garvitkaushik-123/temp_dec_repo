package io.bidmachine.rendering.internal.repository;

import android.graphics.Bitmap;
import android.net.Uri;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.rendering.model.Error;
import io.bidmachine.rendering.model.MediaSource;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\rJ%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\b\u0010\tJ%\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\n0\u0004H&¢\u0006\u0004\b\u000b\u0010\tJ%\u0010\r\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\f0\u0004H&¢\u0006\u0004\b\r\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Lio/bidmachine/rendering/internal/repository/a;", "", "Lio/bidmachine/rendering/model/MediaSource;", "mediaSource", "Lio/bidmachine/rendering/internal/repository/a$a;", "Landroid/graphics/Bitmap;", "resultCallback", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Lio/bidmachine/rendering/model/MediaSource;Lio/bidmachine/rendering/internal/repository/a$a;)V", "Landroid/net/Uri;", "c", "", "a", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public interface a {

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Lio/bidmachine/rendering/internal/repository/a$a;", "SuccessType", "", "result", "", "onSuccess", "(Ljava/lang/Object;)V", "Lio/bidmachine/rendering/model/Error;", "error", "onError", "(Lio/bidmachine/rendering/model/Error;)V", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: io.bidmachine.rendering.internal.repository.a$a, reason: collision with other inner class name */
    public interface InterfaceC0625a<SuccessType> {
        void onError(Error error);

        void onSuccess(SuccessType result);
    }

    void a(MediaSource mediaSource, InterfaceC0625a<String> resultCallback);

    void b(MediaSource mediaSource, InterfaceC0625a<Bitmap> resultCallback);

    void c(MediaSource mediaSource, InterfaceC0625a<Uri> resultCallback);
}
