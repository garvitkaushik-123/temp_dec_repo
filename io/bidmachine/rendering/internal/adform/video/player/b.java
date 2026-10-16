package io.bidmachine.rendering.internal.adform.video.player;

import android.net.Uri;
import android.view.View;
import com.ironsource.D5;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import io.bidmachine.rendering.internal.q;
import io.bidmachine.rendering.internal.t;
import io.bidmachine.rendering.internal.w;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\n\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\tH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\tH&¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\tH&¢\u0006\u0004\b\u0012\u0010\u0010J\u000f\u0010\u0014\u001a\u00020\u0013H'¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u0010ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0019À\u0006\u0001"}, d2 = {"Lio/bidmachine/rendering/internal/adform/video/player/b;", "Lio/bidmachine/rendering/internal/q;", "Lio/bidmachine/rendering/internal/t;", "Lio/bidmachine/rendering/internal/w;", "Landroid/view/View;", D5.q, "()Landroid/view/View;", "Lio/bidmachine/rendering/internal/adform/video/player/d;", "playerListener", "", "a", "(Lio/bidmachine/rendering/internal/adform/video/player/d;)V", "Landroid/net/Uri;", "videoUri", "(Landroid/net/Uri;)V", "prepare", "()V", "play", CampaignEx.JSON_NATIVE_VIDEO_PAUSE, "", "getVolume", "()F", "", "g", "()J", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public interface b extends q, t, w {
    void a();

    void a(Uri videoUri);

    void a(d playerListener);

    long g();

    float getVolume();

    View n();

    void pause();

    void play();

    void prepare();
}
